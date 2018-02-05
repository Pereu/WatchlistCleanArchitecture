package com.android.watchlist.watchlist.domain.interactor.user

import com.android.watchlist.watchlist.domain.executor.PostExecutionThread
import com.android.watchlist.watchlist.domain.executor.ThreadExecutor
import rx.Observable
import rx.Subscriber
import rx.functions.Action0
import rx.functions.Action1
import rx.schedulers.Schedulers
import rx.subscriptions.Subscriptions

/**
 * Created by alexanderpereu on 25.01.2018.
 */
abstract class BaseUserInteractor<T> protected constructor(private val threadExecutor: ThreadExecutor, private val postExecutionThread: PostExecutionThread) {

    private var subscription = Subscriptions.empty()

    /**
     * Builds an [Observable] which will be used when executing the current [UseCase].
     */
    protected abstract fun buildUseCaseObservable(): Observable<T>

    protected abstract fun buildUseCaseObservableSign(): Observable<T>

    /**
     * Executes the current use case.

     * @param useCaseSubscriber The guy who will be listen to the observable build with [ ][.buildUseCaseObservable].
     */
    @SuppressWarnings("unchecked")
    fun executeLogin(useCaseSubscriber: Subscriber<T>) {
        this.subscription = this.buildUseCaseObservable()
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.scheduler)
                .subscribe(useCaseSubscriber)
    }

    @SuppressWarnings("unchecked")
    fun executeSignUp(useCaseSubscriber: Subscriber<T>) {
        this.subscription = this.buildUseCaseObservableSign()
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.scheduler)
                .subscribe(useCaseSubscriber)
    }

    @SuppressWarnings("unchecked")
    fun executeLogin(onNext: Action1<T>, onError: Action1<Throwable>) {
        this.subscription = this.buildUseCaseObservable()
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.scheduler)
                .subscribe(onNext, onError)
    }

    @SuppressWarnings("unchecked")
    fun executeLogin(onNext: Action1<T>, onError: Action1<Throwable>, onCompleted: Action0) {
        this.subscription = this.buildUseCaseObservable()
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.scheduler)
                .subscribe(onNext, onError, onCompleted)
    }



    /**
     * Unsubscribes from current [Subscription].
     */
    fun unsubscribe() {
        if (!subscription.isUnsubscribed) {
            subscription.unsubscribe()
        }
    }
}
package com.watchlist.domain.interactor.movie

import com.watchlist.domain.executor.PostExecutionThread
import com.watchlist.domain.executor.ThreadExecutor
import rx.Observable
import rx.Subscriber
import rx.schedulers.Schedulers
import rx.subscriptions.Subscriptions

/**
 * Created by alexanderpereu on 25.01.2018.
 */
abstract class BaseMovieInteractor<T> protected constructor(private val threadExecutor: ThreadExecutor, private val postExecutionThread: PostExecutionThread) {

    private var subscription = Subscriptions.empty()

    protected abstract fun buildUseCaseObservableList(): Observable<ArrayList<T>>?

    protected abstract fun buildUseCaseObservableObject(): Observable<T>?

    //protected abstract fun buildUseCaseObservableSign(): Observable<T>

    @SuppressWarnings("unchecked")
    fun buildUseCaseObservableList(useCaseSubscriber: Subscriber<ArrayList<T>>) {
        this.subscription = this.buildUseCaseObservableList()
                ?.subscribeOn(Schedulers.from(threadExecutor))
                ?.observeOn(postExecutionThread.scheduler)
                ?.subscribe(useCaseSubscriber)
    }

    @SuppressWarnings("unchecked")
    fun buildUseCaseObservableObject(useCaseSubscriber: Subscriber<T>) {
        this.subscription = this.buildUseCaseObservableObject()
                ?.subscribeOn(Schedulers.from(threadExecutor))
                ?.observeOn(postExecutionThread.scheduler)
                ?.subscribe(useCaseSubscriber)
    }

//    @SuppressWarnings("unchecked")
//    fun executeSignUp(useCaseSubscriber: Subscriber<T>) {
//        this.subscription = this.buildUseCaseObservableSign()
//                .subscribeOn(Schedulers.from(threadExecutor))
//                .observeOn(postExecutionThread.scheduler)
//                .subscribe(useCaseSubscriber)
//    }

//    @SuppressWarnings("unchecked")
//    fun executeLogin(onNext: Action1<T>, onError: Action1<Throwable>) {
//        this.subscription = this.buildUseCaseObservable()
//                .subscribeOn(Schedulers.from(threadExecutor))
//                .observeOn(postExecutionThread.scheduler)
//                .subscribe(onNext, onError)
//    }
//
//    @SuppressWarnings("unchecked")
//    fun executeLogin(onNext: Action1<T>, onError: Action1<Throwable>, onCompleted: Action0) {
//        this.subscription = this.buildUseCaseObservable()
//                .subscribeOn(Schedulers.from(threadExecutor))
//                .observeOn(postExecutionThread.scheduler)
//                .subscribe(onNext, onError, onCompleted)
//    }



    /**
     * Unsubscribes from current [Subscription].
     */
    fun unsubscribe() {
        if (!subscription.isUnsubscribed) {
            subscription.unsubscribe()
        }
    }
}
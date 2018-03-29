package com.watchlist.presentation.ui.global

import com.watchlist.presentation.ui.global.view.MvpView

/**
 * Created by alexandr on 26/03/2018.
 */
abstract class BasePresenter <V> : MvpView<V> {

    private var view: V? = null
    private val isViewAttached: Boolean get() = view != null

    override fun onAttach(view: V?) {
        this.view = view
        viewIsReady()
    }

    override fun onDetach() {
        view = null
    }

    override fun getView(): V? = view

    abstract fun viewIsReady ()

}
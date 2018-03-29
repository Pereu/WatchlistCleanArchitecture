package com.watchlist.presentation.ui.mvp.presenters

/**
 * Created by alexandr on 26/03/2018.
 */
 abstract class BasePresenter <V> {

    abstract fun onAttach(view: V?)

    abstract fun getView(): V?

    abstract fun onDetach()
}
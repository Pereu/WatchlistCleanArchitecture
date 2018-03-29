package com.watchlist.presentation.ui.global.view

interface MvpView <V>{

    fun onAttach(view: V?)
    fun onDetach()
    fun getView(): V?
}
package com.android.watchlist.watchlist.presentation.ui.fragments

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.watchlist.R
import com.android.watchlist.watchlist.domain.model.OnBoardingMovie
import com.android.watchlist.watchlist.presentation.ui.adapters.OnBoardingAdapter
import com.android.watchlist.watchlist.presentation.ui.mvp.presenters.OnBoardingPresenter
import com.android.watchlist.watchlist.presentation.ui.mvp.views.OnBoardingView
import com.arellomobile.mvp.MvpFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.pawegio.kandroid.longToast
import kotlinx.android.synthetic.main.fragment_on_boarding.*

/**
 * Created by alexanderpereu on 30.01.2018.
 */
class OnBoardingFragment : MvpFragment(), OnBoardingView {

    @InjectPresenter
    lateinit var presenter: OnBoardingPresenter

    private var adapter: OnBoardingAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_on_boarding, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        presenter.viewIsReady()
    }

    private fun initAdapter() {
        fragment_on_boarding_list.layoutManager = GridLayoutManager(activity, 2)
        adapter = OnBoardingAdapter()    }


    override fun showLoading() {

    }

    override fun showList(it: ArrayList<OnBoardingMovie>) {
        adapter?.setList(it)
    }

    override fun showError(it: Throwable) {
        it.message?.let { it1 -> longToast(it1) }
    }
}

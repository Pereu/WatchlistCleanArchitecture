package com.watchlist.presentation.ui.fragments

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.watchlist.R
import com.watchlist.domain.model.OnBoardingMovie
import com.watchlist.presentation.ui.adapters.OnBoardingAdapter
import com.watchlist.presentation.ui.global.BaseFragment
import com.watchlist.presentation.ui.mvp.presenters.OnBoardingPresenter
import com.watchlist.presentation.ui.mvp.views.OnBoardingView
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.pawegio.kandroid.longToast
import com.watchlist.presentation.extension.visible
import kotlinx.android.synthetic.main.fragment_on_boarding.*
import javax.inject.Inject

/**
 * Created by alexanderpereu on 30.01.2018.
 */
class OnBoardingFragment : BaseFragment(), OnBoardingView {

    @Inject
    @InjectPresenter
    lateinit var presenter: OnBoardingPresenter

    @ProvidePresenter
    fun provideOnBoardingPresenter(): OnBoardingPresenter {
        return presenter
    }

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
        adapter = OnBoardingAdapter()
        fragment_on_boarding_list.adapter = adapter
    }


    override fun showLoading(b: Boolean) {
        fragment_on_boarding_progress_bar.visible = b
    }

    override fun showList(it: ArrayList<OnBoardingMovie>) {
        showLoading(false)
        adapter?.setList(it)
    }

    override fun showError(it: Throwable) {
        showLoading(false)
        it.message?.let { it1 -> longToast(it1) }
    }
}

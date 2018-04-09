package com.watchlist.presentation.ui.registration.onboarding.view

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pawegio.kandroid.longToast
import com.watchlist.R
import com.watchlist.domain.model.OnBoardingMovie
import com.watchlist.presentation.extension.visible
import com.watchlist.presentation.ui.bottom_tabs.MainActivity
import com.watchlist.presentation.ui.global.BaseOnScrollListener
import com.watchlist.presentation.ui.global.view.BaseFragment
import com.watchlist.presentation.ui.registration.onboarding.OnBoardingPresenter
import com.watchlist.presentation.ui.registration.onboarding.adapter.OnBoardingAdapter
import kotlinx.android.synthetic.main.fragment_on_boarding.*
import javax.inject.Inject

/**
 * Created by alexanderpereu on 30.01.2018.
 */
class OnBoardingFragment : BaseFragment(), OnBoardingView {

    @Inject
    lateinit var presenter: OnBoardingPresenter <OnBoardingView>

    private var adapter: OnBoardingAdapter? = null

    private var baseOnScrollListener: BaseOnScrollListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_on_boarding, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        presenter.onAttach(this)
        fragment_on_boarding_btn.setOnClickListener { goToHome() }
    }

    private fun goToHome() {
        startActivity(Intent(activity, MainActivity::class.java))
        activity?.finish()
    }

    private fun initAdapter() {
        adapter = OnBoardingAdapter()
        val layoutManager = GridLayoutManager(activity, 2)
        baseOnScrollListener = BaseOnScrollListener({ loadMoreItems() }, layoutManager)
        fragment_on_boarding_list.layoutManager = layoutManager
        fragment_on_boarding_list.addOnScrollListener(baseOnScrollListener)
        fragment_on_boarding_list.adapter = adapter
    }

    private fun loadMoreItems() {
        presenter.loadMovies()
    }

    override fun showLoading(isLoading: Boolean) {
        fragment_on_boarding_progress_bar.visible = isLoading
    }

    override fun showList(list: ArrayList<OnBoardingMovie>) {
        if (list.isEmpty()) baseOnScrollListener?.setAvailable(false) else baseOnScrollListener?.setLoading(false)

        showLoading(false)
        adapter?.setList(list)
    }

    override fun showError(errorMessage: String) {
        showLoading(false)
        longToast(errorMessage)
    }

    override fun showMessage(message: String) {}
}

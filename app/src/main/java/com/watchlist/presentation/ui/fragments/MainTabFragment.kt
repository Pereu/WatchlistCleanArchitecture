package com.watchlist.presentation.ui.fragments

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.watchlist.R
import com.watchlist.presentation.extension.visible
import com.watchlist.presentation.ui.mvp.presenters.MainTabPresenter
import com.watchlist.presentation.ui.mvp.views.MainTabView
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * Created by alexanderpereu on 19.02.2018.
 */
class MainTabFragment : MvpAppCompatFragment(), MainTabView {

    @InjectPresenter
    lateinit var presenter: MainTabPresenter

    companion object {
        private const val INDEX = "index"

        fun newInstance(index: Int): MainTabFragment {
            val fragment = MainTabFragment()
            val b = Bundle()
            b.putInt(MainTabFragment.INDEX, index)
            fragment.arguments = b
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_main, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val index = arguments?.getInt(MainTabFragment.INDEX) ?: 0
        main.visible = true
        main.text = index.toString()
        //presenter.showCurrentFragment(index, activity as AppCompatActivity, R.id.fragment_main_tab_container)
    }
}
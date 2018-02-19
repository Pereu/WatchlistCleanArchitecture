package com.watchlist.presentation.ui.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.watchlist.R
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * Created by alexanderpereu on 19.02.2018.
 */
class MainTabFragment : Fragment() {

    companion object {
        private const val TITLE = "title"
        fun newInstance(index: Int, title: String): MainTabFragment {
            val fragment = MainTabFragment()
            val b = Bundle()
            b.putString(MainTabFragment.TITLE, title)
            fragment.arguments = b
            return fragment
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_main, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val string = arguments?.getString(MainTabFragment.TITLE)
        main.text = string
    }
}
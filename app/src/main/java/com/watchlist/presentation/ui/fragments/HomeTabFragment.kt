package com.watchlist.presentation.ui.fragments


import android.os.Bundle
import android.support.v4.app.Fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.watchlist.R

/**
 * Created by alexanderpereu on 20.02.2018.
 */
class HomeTabFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_tab_home, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


    }


}
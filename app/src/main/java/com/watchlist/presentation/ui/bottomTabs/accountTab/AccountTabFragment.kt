package com.watchlist.presentation.ui.bottomTabs.accountTab

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.watchlist.R
import com.watchlist.presentation.extension.addFragment
import com.watchlist.presentation.extension.replaceFragment
import com.watchlist.presentation.ui.settings.SettingsFragment
import kotlinx.android.synthetic.main.fragment_tab_account.*

/**
 * Created by alexanderpereu on 19.02.2018.
 */
class AccountTabFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_tab_account, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        fragment_account_toolbar_settings.setOnClickListener {
            activity?.supportFragmentManager?.addFragment(SettingsFragment(), R.id.activity_tabs_container)
        }
    }
}
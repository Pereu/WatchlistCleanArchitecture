package com.watchlist.presentation.ui.detail

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.watchlist.R
import com.watchlist.domain.model.Item

class MovieDetailFragment : Fragment() {

    private var movieItem: Item? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_detail, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }

    fun setItem(item: Item) {
        this.movieItem = item
    }
}
package com.watchlist.presentation.ui.detail

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewCompat
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.watchlist.R
import com.watchlist.domain.model.Item
import com.watchlist.presentation.extension.getCurrentItem
import com.watchlist.presentation.extension.loadPicture
import kotlinx.android.synthetic.main.fragment_detail.*


class MovieDetailFragment : Fragment() {

    private var movieItem = Item()
    private var transitionNameBackdrop = ""
    private var transitionNamePoster = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        postponeEnterTransition()
        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val index = 0
        ViewCompat.setTransitionName(fragment_detail_backdrop, transitionNameBackdrop)
        ViewCompat.setTransitionName(fragment_detail_poster, transitionNamePoster)
        fragment_detail_backdrop.loadPicture(this, movieItem.Backdrops[index.getCurrentItem(movieItem.Backdrops.size)].Url)
        fragment_detail_poster.loadPicture(this, movieItem.Posters[index.getCurrentItem(movieItem.Posters.size)].Url)
    }

    fun setItem(item: Item, transitionNameBackdrop: String, transitionNamePoster: String) {
        this.movieItem = item
        this.transitionNameBackdrop = transitionNameBackdrop
        this.transitionNamePoster = transitionNamePoster
    }
}
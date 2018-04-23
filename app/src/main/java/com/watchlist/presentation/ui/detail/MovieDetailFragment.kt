package com.watchlist.presentation.ui.detail

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewCompat
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.watchlist.R
import com.watchlist.domain.model.Item
import kotlinx.android.synthetic.main.fragment_detail.*


class MovieDetailFragment : Fragment() {

    private var movieItem: Item? = null
    private var transitionName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        postponeEnterTransition()
        val transition = TransitionInflater.from(context)
                .inflateTransition(android.R.transition.move)
        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        ViewCompat.setTransitionName(fragment_detail_backdrop, transitionName)

        Glide.with(this)
                .load(movieItem?.Backdrops?.get(4)?.Url)
                .listener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                        scheduleStartPostponedTransition(fragment_detail_backdrop)
                        return false
                    }

                    override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                        scheduleStartPostponedTransition(fragment_detail_backdrop)
                        return false
                    }
                })
                .into(fragment_detail_backdrop)

    }

    fun setItem(item: Item, transitionName: String) {
        this.movieItem = item
        this.transitionName = transitionName
    }

    private fun scheduleStartPostponedTransition(imageView: ImageView) {
        imageView.viewTreeObserver.addOnPreDrawListener(object : ViewTreeObserver.OnPreDrawListener {
            override fun onPreDraw(): Boolean {
                imageView.viewTreeObserver.removeOnPreDrawListener(this)
                startPostponedEnterTransition()
                return true
            }
        })
    }
}
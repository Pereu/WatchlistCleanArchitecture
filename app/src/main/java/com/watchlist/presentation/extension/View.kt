package com.watchlist.presentation.extension

import android.graphics.drawable.Drawable
import android.support.v4.app.Fragment
import android.view.View
import android.view.ViewTreeObserver
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

/**
 * Created by alexanderpereu on 06.02.2018.
 */
var View.visible
    get() = visibility == View.VISIBLE
    set(value) {
        visibility = if (value)
            View.VISIBLE
        else
            View.GONE
    }

fun ImageView.loadPicture (fragment: Fragment, url: String) {
    Glide.with(fragment)
            .load(url)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                    scheduleStartPostponedTransition(this@loadPicture, fragment)
                    return false
                }

                override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                    scheduleStartPostponedTransition(this@loadPicture, fragment)
                    return false
                }
            })
            .into(this)
}

private fun scheduleStartPostponedTransition(imageView: ImageView, fragment: Fragment) {
    imageView.viewTreeObserver.addOnPreDrawListener(object : ViewTreeObserver.OnPreDrawListener {
        override fun onPreDraw(): Boolean {
            imageView.viewTreeObserver.removeOnPreDrawListener(this)
            fragment.startPostponedEnterTransition()
            return true
        }
    })
}
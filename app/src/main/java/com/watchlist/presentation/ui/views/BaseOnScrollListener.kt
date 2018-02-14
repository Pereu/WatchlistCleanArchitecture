package com.watchlist.presentation.ui.views

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

/**
 * Created by alexanderpereu on 12.02.2018.
 */
class BaseOnScrollListener (private val loadMoreItems: () -> Unit, private val linearLayoutManager: LinearLayoutManager) : RecyclerView.OnScrollListener() {

    private var loading = false
    private var itemsAvailable = true
    private var visibleThreshold = 2
    private var firstVisibleItem = 0
    private var visibleItemCount = 0
    private var totalItemCount = 0

    override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        visibleItemCount = linearLayoutManager.childCount
        totalItemCount = linearLayoutManager.itemCount
        firstVisibleItem = linearLayoutManager.findFirstVisibleItemPosition()

        if (!loading && (totalItemCount - visibleItemCount <= firstVisibleItem + visibleThreshold)) {

            if (itemsAvailable) {
                loading = true
                loadMoreItems ()
            }
        }
    }

    fun setAvailable(b: Boolean) {
        itemsAvailable = b
    }
    fun setLoading(b: Boolean) {
        loading = b
    }
}
package com.watchlist.presentation.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.watchlist.presentation.ui.adapters.holders.BaseViewHolder


/**
 * Created by alexanderpereu on 02.02.2018.
 */
abstract class BaseAdapter <T, VH : BaseViewHolder<T>> : RecyclerView.Adapter<VH>() {

    private var list: ArrayList<T> = arrayListOf()

    abstract override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        val T = list[position]
        holder.onBind(T)
    }

    fun setList (list: ArrayList<T>) {
        this.list.addAll(list)
        notifyDataSetChanged()
    }
}
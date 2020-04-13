package com.placebox.androidx.widget.recyclerview.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.placebox.androidx.widget.recyclerview.viewholder.BindValue

interface RecyclerViewAdapterBase<T : Any> {

    val config: RecyclerAdapterConfig<T>
    val isDataValid: Boolean
    val data: List<T>?
    val selection: Selection

    fun onCreate(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder? {
        val factory = config.viewHolderFactories[viewType]
                ?: throw NoSuchElementException("factory for view type '$viewType' not available")

        return factory.invoke(this, parent)
    }

    fun onCreateFooter(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder? {
        return config.footerViewHolderFactory?.invoke(this, parent)
    }

    fun onBind(value: T?, holder: RecyclerView.ViewHolder) {

    }

    fun onBindFooter(holder: RecyclerView.ViewHolder) {
        if (holder is BindValue<*>) holder.bind(null)
    }

    fun onClear(holder: RecyclerView.ViewHolder) {

    }

    fun useHeader(): Boolean = config.headerViewHolderFactory != null

    fun useFooter(): Boolean = config.footerViewHolderFactory != null

    fun getItemCount(): Int

    fun getItem(position: Int): T?

    fun notifyItemChanged(position: Int)

    fun notifyDataSetChanged()

}

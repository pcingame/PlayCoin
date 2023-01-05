@file:Suppress("unused")
package com.example.playcoin.base.recyclerview
import android.view.View
import androidx.recyclerview.widget.RecyclerView

open class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    protected var itemData: T? = null

    init {
        itemView.setOnClickListener {
            itemData?.let(::onHandleItemClick)
        }
    }

    open fun bindData(itemData: T) {
        this.itemData = itemData
    }

    open fun onHandleItemClick(mainItem: T) {
    }
}

open class BaseViewBDHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    protected var itemData: T? = null

    init {
        itemView.setOnClickListener {
            itemData?.let(::onHandleItemClick)
        }
    }

    open fun bindData(itemData: T) {
        this.itemData = itemData
    }

    open fun onHandleItemClick(mainItem: T) {
    }
}

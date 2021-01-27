package com.example.architecture.chat.multiviewadapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<model: ChatDataModel>(view: View): RecyclerView.ViewHolder(view) {

    abstract fun bind(model: ChatDataModel)
}
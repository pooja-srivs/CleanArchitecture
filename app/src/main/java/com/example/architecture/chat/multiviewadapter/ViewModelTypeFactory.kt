package com.example.architecture.chat.multiviewadapter

import android.view.View

interface ViewModelTypeFactory {

    fun type(dataModel: ChatDataModel) : Int
    fun create(parent: View, viewType: Int) : BaseViewHolder<ChatDataModel>
}
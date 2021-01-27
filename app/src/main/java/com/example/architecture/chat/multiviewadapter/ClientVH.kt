package com.example.architecture.chat.multiviewadapter

import android.view.View
import kotlinx.android.synthetic.main.item_messages.view.*

class ClientVH(view: View): BaseViewHolder<ChatDataModel>(view) {
    override fun bind(model: ChatDataModel) {

        with(itemView){
            tv_msg.text = model.message
        }
    }
}
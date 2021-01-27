package com.example.architecture.chat.multiviewadapter

import android.view.View
import com.example.architecture.R

class ViewModelTypeFactoryImpl : ViewModelTypeFactory {

    companion object{
        const val USER = "User_View"
        const val CLIENT = "Client_View"

        const val USER_VIEW = R.layout.item_messages
        const val CLIENT_VIEW = R.layout.item_client_message
    }

    override fun type(dataModel: ChatDataModel): Int {
        return when(dataModel.type){

            USER -> USER_VIEW
            CLIENT -> CLIENT_VIEW
            else -> USER_VIEW
        }
    }

    override fun create(parent: View, viewType: Int): BaseViewHolder<ChatDataModel> {

        return when (viewType) {
            USER_VIEW -> UserVH(parent)
            CLIENT_VIEW -> ClientVH(parent)
            else -> UserVH(parent)
        }
    }
}
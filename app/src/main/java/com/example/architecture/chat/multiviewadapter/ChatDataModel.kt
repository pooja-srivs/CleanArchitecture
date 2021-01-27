package com.example.architecture.chat.multiviewadapter

data class ChatDataModel (val message: String, val time: String = "", val type: String):
    ItemViewModelType {
    override fun type(viewModelTypefactory: ViewModelTypeFactory): Int {
        return viewModelTypefactory.type(this)
    }
}
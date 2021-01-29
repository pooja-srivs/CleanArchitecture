package com.clean.architecture.chat.multiviewadapter

interface ItemViewModelType {
    fun type(viewModelTypefactory: ViewModelTypeFactory) : Int
}
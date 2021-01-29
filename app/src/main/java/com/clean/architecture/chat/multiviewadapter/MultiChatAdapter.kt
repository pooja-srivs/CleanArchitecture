package com.clean.architecture.chat.multiviewadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

class MultiChatAdapter private constructor(
    val diffUtil: DiffUtil.ItemCallback<ChatDataModel>
): ListAdapter<ChatDataModel, BaseViewHolder<ChatDataModel>>(diffUtil) {

    private val typeFactory: ViewModelTypeFactory = ViewModelTypeFactoryImpl()

    companion object {

        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ChatDataModel>() {

            override fun areItemsTheSame(oldItem: ChatDataModel, newItem: ChatDataModel): Boolean =
                oldItem.message == newItem.message

            override fun areContentsTheSame(oldItem: ChatDataModel, newItem: ChatDataModel): Boolean =
                oldItem == newItem

        }

        fun newInstance() = MultiChatAdapter(
                DIFF_CALLBACK
            )

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<ChatDataModel> {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(viewType, parent, false)
        return typeFactory.create(view, viewType)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<ChatDataModel>, position: Int) {
 
        holder.bind(requireNotNull(getItemAt(position)))
    }

    fun getItemAt(position: Int): ChatDataModel {
        return getItem(position)
    }

    override fun getItemViewType(position: Int): Int {
        return getItemAt(position).type(typeFactory)
    }

}

package com.clean.architecture.chat

import android.os.Bundle
import android.view.View.*
import android.widget.AbsListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.clean.architecture.Constants
import com.clean.architecture.R
import com.clean.architecture.chat.multiviewadapter.ChatDataModel
import com.clean.architecture.chat.multiviewadapter.MultiChatAdapter
import com.vanniktech.emoji.EmojiManager
import com.vanniktech.emoji.google.GoogleEmojiProvider
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber
import javax.inject.Inject


class ChatActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: ChatViewModel
    private lateinit var msgListAdapter: MultiChatAdapter
    private var msgList = mutableListOf<ChatDataModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        EmojiManager.install(GoogleEmojiProvider())
        setContentView(R.layout.activity_main)

        addObserver()

        list_messages.adapter = MultiChatAdapter.newInstance()
            .also {
                msgListAdapter = it
            }

        iv_send.setOnClickListener {
            et_message.text.toString().let { msg ->
                if (msg.isNotEmpty()){
                    viewModel.getNearbyPlaces(msg)
                    viewModel.insertItem(msg)
                    populateData(msg, Constants.USER_VIEW)
                }
            }
            et_message.text?.clear()
        }
    }

    private fun addObserver(){

        viewModel.messagesLiveData.observe(this, Observer { msg ->

            Timber.d("** Message Data = ${msg.message}")

            msg.message?.let {
                populateData(it, Constants.CLIENT_VIEW)
            }
        })

        viewModel.isLoading.observe(this, Observer {
            if (it){
                progress.visibility = VISIBLE
                cv_send.visibility = INVISIBLE
            }else{
                progress.visibility = INVISIBLE
                cv_send.visibility = VISIBLE
            }
        })

        viewModel.errorLiveData.observe(this, Observer {
            Toast.makeText(this, "Please try again !", Toast.LENGTH_SHORT).show()
        })
    }

    fun populateData(msgs: String, type: String){

        msgList.add(ChatDataModel(message = msgs, type = type))
        msgListAdapter.submitList(msgList)
        setLayout()
        msgListAdapter.notifyDataSetChanged()
    }

    private fun setLayout(){
        list_messages.addOnLayoutChangeListener(OnLayoutChangeListener { v, left, top, right, bottom, oldLeft, oldTop, oldRight, oldBottom ->
            list_messages.scrollToPosition(
                msgListAdapter.itemCount
            )
        })
    }

    private fun onScroll(){

        list_messages.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (dy > 0) {
                    viewModel.getAllChatDataData().map {
                        Timber.d("** Chat Items : ${it.message}")
                    }
                } else {
                    // Scrolling down
                }
            }

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_FLING) {
                    // Do something
                } else if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                    // Do something
                } else {
                    // Do something
                }
            }
        })
    }
}
package com.aladin.androidtestingsample.chats.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.aladin.androidtestingsample.chats.model.Chat
import com.aladin.androidtestingsample.databinding.ChatCardItemBinding
import java.util.Locale

class ChatsAdapter(
    private val chats: List<Chat>
) : RecyclerView.Adapter<ChatsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ChatCardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(chats[position])
    }

    override fun getItemCount(): Int {
        return chats.size
    }

    inner class ViewHolder(private val binding: ChatCardItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(chat: Chat) {
            setupCardData(chat)
        }

        private fun setupCardData(chat: Chat) = binding.run {
            contactNameText.text = chat.contactName
            contactMessageText.text = chat.lastMessage
            contactMessagesSentText.text = String.format(Locale.getDefault(),"%d", chat.messagesSent)
            contactProfileImage.setImageDrawable(AppCompatResources.getDrawable(itemView.context, chat.contactProfileImage))
            contactLastMessageSentTime.text = chat.lastMessageTimeSent
        }
    }

}
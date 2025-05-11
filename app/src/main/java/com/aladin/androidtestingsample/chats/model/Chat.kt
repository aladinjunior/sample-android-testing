package com.aladin.androidtestingsample.chats.model

import androidx.annotation.DrawableRes

data class Chat(
    @DrawableRes val contactProfileImage: Int,
    val contactName: String,
    val lastMessage: String,
    val lastMessageTimeSent: String,
    val messagesSent: Int,
)

class ChatBuilder {

    var contactName = ""
    var contactProfileImage = 0
    var lastMessage = ""
    var lastMessageTimeSent = ""
    var messagesSent = 0

    fun build(): Chat {
        return Chat(
            contactProfileImage,
            contactName,
            lastMessage,
            lastMessageTimeSent,
            messagesSent
        )
    }

}

fun chat(block: ChatBuilder.() -> Unit): Chat {
    val builder = ChatBuilder()
    builder.block()
    return builder.build()
}
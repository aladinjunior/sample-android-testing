package com.aladin.androidtestingsample.chats.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.aladin.androidtestingsample.R
import com.aladin.androidtestingsample.chats.model.chat

class ChatsViewModel : ViewModel() {
    fun getChatsData() = chatsLocalData

    companion object {
        private val chatsLocalData = listOf(
            chat {
                contactProfileImage = R.drawable.ic_1
                contactName = "Robert Johnson"
                lastMessage = "Hey! Are you coming tonight?"
                lastMessageTimeSent = "Just Now"
                messagesSent = 3
            },
            chat {
                contactProfileImage = R.drawable.ic_2
                contactName = "Bob Smith"
                lastMessage = "Sent the files, let me know."
                lastMessageTimeSent = "17:10"
                messagesSent = 5
            },
            chat {
                contactProfileImage = R.drawable.ic_3
                contactName = "Charlie Brown"
                lastMessage = "Let’s catch up soon!"
                lastMessageTimeSent = "14:55"
                messagesSent = 1
            },
            chat {
                contactProfileImage = R.drawable.ic_4
                contactName = "Diana Prince"
                lastMessage = "Meeting is postponed."
                lastMessageTimeSent = "13:23"
                messagesSent = 2
            },
            chat {
                contactProfileImage = R.drawable.ic_5
                contactName = "Ethan Hunt"
                lastMessage = "Mission accomplished."
                lastMessageTimeSent = "12:11"
                messagesSent = 4
            },
            chat {
                contactProfileImage = R.drawable.ic_6
                contactName = "Fiona Gallagher"
                lastMessage = "See you tomorrow!"
                lastMessageTimeSent = "10:30"
                messagesSent = 1
            },
            chat {
                contactProfileImage = R.drawable.ic_7
                contactName = "George Martin"
                lastMessage = "Let’s review the draft."
                lastMessageTimeSent = "09:18"
                messagesSent = 2
            },
        )
    }
}
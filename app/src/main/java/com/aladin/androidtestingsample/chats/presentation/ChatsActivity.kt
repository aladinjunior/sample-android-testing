package com.aladin.androidtestingsample.chats.presentation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.aladin.androidtestingsample.R
import com.aladin.androidtestingsample.databinding.ActivityChatsBinding

class ChatsActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityChatsBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        setupTopAppBar()
    }

    private fun setupTopAppBar() = with(binding) {
        ViewCompat.setOnApplyWindowInsetsListener(appTopBar.root) { view, insets ->
            val statusBarHeight = insets.getInsets(WindowInsetsCompat.Type.statusBars()).top
            val layoutParams = view.layoutParams
            layoutParams.height = resources.getDimensionPixelSize(R.dimen.actionbar_size) + statusBarHeight
            view.layoutParams = layoutParams
            view.setPadding(0, statusBarHeight, 0, 0)
            insets
        }
    }
}
package com.aladin.androidtestingsample.chats.presentation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.aladin.androidtestingsample.R
import com.aladin.androidtestingsample.chats.presentation.adapter.ChatsAdapter
import com.aladin.androidtestingsample.chats.presentation.viewmodel.ChatsViewModel
import com.aladin.androidtestingsample.databinding.ActivityChatsBinding
import com.google.android.material.button.MaterialButton
import com.google.android.material.button.MaterialButtonToggleGroup

class ChatsActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityChatsBinding.inflate(layoutInflater)
    }
    private val viewModel = ChatsViewModel()

    private lateinit var adapter: ChatsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        setupAdapter()
        setupTopAppBar()
        setupListeners()
        initMaterialButtonToggle()
    }

    private fun setupAdapter() = with(binding) {
        val chatsData = viewModel.getChatsData()
        adapter = ChatsAdapter(chatsData)
        chatCardsRecyclerView.layoutManager = LinearLayoutManager(this@ChatsActivity)
        chatCardsRecyclerView.adapter = adapter
    }

    private fun setupTopAppBar() = with(binding) {
        ViewCompat.setOnApplyWindowInsetsListener(appTopBar.root) { view, insets ->
            val statusBarHeight = insets.getInsets(WindowInsetsCompat.Type.statusBars()).top
            val layoutParams = view.layoutParams
            layoutParams.height =
                resources.getDimensionPixelSize(R.dimen.actionbar_size) + statusBarHeight
            view.layoutParams = layoutParams
            view.setPadding(0, statusBarHeight, 0, 0)
            insets
        }
    }

    private fun setupListeners() = with(binding) {
        toggleButton.addOnButtonCheckedListener { group, checkedId, isChecked ->
            if (!isChecked) return@addOnButtonCheckedListener
            setupButtonBehavior(group, checkedId)
        }
    }

    private fun setupButtonBehavior(
        toggleButtonGroup: MaterialButtonToggleGroup,
        checkedId: Int,
    ) {
        for (i in 0 until toggleButtonGroup.childCount) {
            val button = toggleButtonGroup.getChildAt(i) as MaterialButton
            button.run {
                val isSelected = id == checkedId

                iconTint = ContextCompat.getColorStateList(
                    this@ChatsActivity,
                    if (isSelected) R.color.on_secondary else android.R.color.transparent
                )

                setBackgroundColor(
                    ContextCompat.getColor(
                        this@ChatsActivity,
                        if (isSelected) R.color.secondary_container else R.color.surface_container
                    )
                )
            }

        }

    }

    private fun initMaterialButtonToggle() = with(binding) {
        toggleButton.check(friendsBtn.id)
        setupButtonBehavior(toggleButton, friendsBtn.id)
    }

}
package com.Jones270405.Aptide

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import com.Jones270405.Aptide.ui.screen.SetupUI
import com.Jones270405.Aptide.viewmodel.MainViewModel
import com.Jones270405.Aptide.viewmodel.MainViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val speak = intent?.getBooleanExtra("speak", false) ?: false

        val factory = MainViewModelFactory(application, speak)
        val viewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)

        setContent {
            SetupUI(viewModel)
        }
    }
}

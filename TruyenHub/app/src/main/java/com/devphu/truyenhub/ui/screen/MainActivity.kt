package com.devphu.truyenhub.ui.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.devphu.truyenhub.ui.screen.main.MainScreen
import com.devphu.truyenhub.ui.theme.TruyenHubTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TruyenHubTheme(false) {
                MainScreen()
            }
        }
    }
}


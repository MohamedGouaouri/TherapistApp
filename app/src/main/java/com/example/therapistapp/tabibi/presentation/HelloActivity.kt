package com.example.therapistapp.tabibi.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import com.example.therapistapp.tabibi.presentation.screens.HelloScreen
import com.example.therapistapp.tabibi.presentation.ui.theme.TherapistAppTheme


class HelloActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TherapistAppTheme {
                Scaffold {
                    HelloScreen(
                        ctx = this,
                        activityKiller = activityKiller
                    )
                }
            }

        }
    }

    private val activityKiller: () -> Unit = {
        this.finish()
    }
}
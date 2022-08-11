package com.example.therapistapp.tabibi.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.therapistapp.tabibi.presentation.screens.Screens
import com.example.therapistapp.tabibi.presentation.screens.SessionDetailsScreen
import com.example.therapistapp.tabibi.presentation.screens.SessionsScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val context = this
            NavHost(navController = navController, startDestination = Screens.SessionsScreen.route){
                composable(route = Screens.SessionsScreen.route){
                    SessionsScreen(
                        navController = navController
                    )
                }
                composable(route = Screens.SessionDetailsScreen.route + "/{sessionId}"){
                    SessionDetailsScreen(
                        ctx = context,
                        navController = navController
                    )
                }
            }

        }
    }
}


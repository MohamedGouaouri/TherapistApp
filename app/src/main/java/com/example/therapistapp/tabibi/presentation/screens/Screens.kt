package com.example.therapistapp.tabibi.presentation.screens

sealed class Screens(val route: String){
    object SessionsScreen: Screens("sessions_list")
    object SessionDetailsScreen: Screens("session_details")
}

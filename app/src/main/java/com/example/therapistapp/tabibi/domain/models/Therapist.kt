package com.example.therapistapp.tabibi.domain.models

data class Therapist(
    val name: String,
    val phoneNumber: String,
    val imageUrl: String = ""
)
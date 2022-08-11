package com.example.therapistapp.tabibi.domain.models

data class Session(
    val id: Int,
    val patient: Patient,
    val therapist: Therapist,
    val sessionData: String,
    val from: String,
    val to: String
)

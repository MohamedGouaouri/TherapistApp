package com.example.therapistapp.tabibi.domain.models

import java.time.LocalDate

data class Session(
    val id: Int,
    val patient: Patient,
    val therapist: Therapist,
    val sessionData: LocalDate,
    val from: String,
    val to: String
)

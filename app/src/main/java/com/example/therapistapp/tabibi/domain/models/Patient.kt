package com.example.therapistapp.tabibi.domain.models

data class Patient (
    val firstName: String,
    val lastName: String,
    val dateOfBirth: String,
    val age: Int,
    val gender: String,
    val phoneNumber: String,
    val imageUrl: String = "",
    val complaints: List<Complaint>
)
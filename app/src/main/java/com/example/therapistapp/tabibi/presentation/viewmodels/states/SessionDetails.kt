package com.example.therapistapp.tabibi.presentation.viewmodels.states

import com.example.therapistapp.tabibi.domain.models.Session

data class SessionDetailsState(
    val isLoading: Boolean = false,
    val session: Session,
    val error: String = ""
)

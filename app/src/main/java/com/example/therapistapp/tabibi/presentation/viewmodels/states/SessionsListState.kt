package com.example.therapistapp.tabibi.presentation.viewmodels.states

import com.example.therapistapp.tabibi.domain.models.Session

data class SessionsListState(
    val isLoading: Boolean = false,
    val sessions: List<Session> = emptyList(),
    val error: String = ""
)

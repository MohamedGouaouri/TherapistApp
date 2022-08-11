package com.example.therapistapp.tabibi.presentation.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.therapistapp.tabibi.presentation.data.sessions
import com.example.therapistapp.tabibi.presentation.viewmodels.states.SessionsListState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SessionListViewMode @Inject constructor() : ViewModel() {

    private val _state = mutableStateOf(SessionsListState())
    val state: State<SessionsListState> = _state

    init {
        getSessions()

    }

    private fun getSessions(){
        _state.value =  SessionsListState(sessions = sessions)
    }
}
package com.example.therapistapp.tabibi.presentation.viewmodels

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.therapistapp.tabibi.presentation.data.sessions
import com.example.therapistapp.tabibi.presentation.data.today
import com.example.therapistapp.tabibi.presentation.viewmodels.states.SessionsListState
import dagger.hilt.android.lifecycle.HiltViewModel
import java.time.LocalDate
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.O)
@HiltViewModel
class SessionListViewMode @Inject constructor() : ViewModel() {

    private val _state = mutableStateOf(SessionsListState())
    val state: State<SessionsListState> = _state

    init {
        getSessions()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getSessions(date: LocalDate = today){
        _state.value =  SessionsListState(sessions = sessions.filter { session ->
            session.sessionData.isEqual(date)
        })
    }
}
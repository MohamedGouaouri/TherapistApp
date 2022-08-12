package com.example.therapistapp.tabibi.presentation.viewmodels

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.therapistapp.tabibi.common.Constants
import com.example.therapistapp.tabibi.presentation.data.sessions
import com.example.therapistapp.tabibi.presentation.viewmodels.states.SessionDetailsState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.O)
@HiltViewModel
class SessionDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
): ViewModel() {

    @RequiresApi(Build.VERSION_CODES.O)
    private val _state = mutableStateOf(SessionDetailsState(session = sessions[0]))
    @RequiresApi(Build.VERSION_CODES.O)
    val state: State<SessionDetailsState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_SESSION_ID)?.let { sessionId ->
            getSession(sessionId.toInt())
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun getSession(sessionId: Int){
        _state.value = SessionDetailsState(session = sessions[sessionId])
    }
}
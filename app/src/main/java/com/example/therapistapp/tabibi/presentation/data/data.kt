package com.example.therapistapp.tabibi.presentation.data

import com.example.therapistapp.tabibi.domain.models.Complaint
import com.example.therapistapp.tabibi.domain.models.Patient
import com.example.therapistapp.tabibi.domain.models.Session
import com.example.therapistapp.tabibi.domain.models.Therapist


val ania = Therapist(
    "Ania",
    "0561586786",
    ""
)

val antony = Patient(
    "Mohammed",
    "Gouaouri",
    "07 June 1995",
    22,
    "Male",
    "0561586786",
    "",
    listOf(
        Complaint("bad mood"),
        Complaint("insomnia"),
        Complaint("apathy"),
        Complaint("anger"),
        Complaint("mood swings"),
        Complaint("panic attacks")
    )
)

val andy = Patient(
    "Andy",
    "Pavlo",
    "07 June 1991",
    30,
    "Male",
    "0561586786",
    "",
    listOf(
        Complaint("bad mood"),
        Complaint("insomnia"),
        Complaint("apathy"),
        Complaint("anger"),
    )
)


val sessions = listOf<Session>(
    Session(
        id = 0,
        patient = antony,
        therapist = ania,
        "11 Feb 2022",
        "11:00",
        "11:30"
    ),

    Session(
        id = 1,
        patient = andy,
        therapist = ania,
        "11 Feb 2022",
        "11:30",
        "12:00"
    ),

)
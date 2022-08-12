package com.example.therapistapp.tabibi.presentation.data

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.therapistapp.tabibi.domain.models.Complaint
import com.example.therapistapp.tabibi.domain.models.Patient
import com.example.therapistapp.tabibi.domain.models.Session
import com.example.therapistapp.tabibi.domain.models.Therapist
import java.time.LocalDate


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


@RequiresApi(Build.VERSION_CODES.O)
val days = listOf<LocalDate>(
    LocalDate.parse("2022-08-10"),
    LocalDate.parse("2022-08-11"),
    LocalDate.parse("2022-08-12"),
    LocalDate.parse("2022-08-13"),
    LocalDate.parse("2022-08-14")
)

@RequiresApi(Build.VERSION_CODES.O)
val today: LocalDate = LocalDate.parse("2022-08-12")

@RequiresApi(Build.VERSION_CODES.O)
val sessions = listOf<Session>(
    Session(
        id = 0,
        patient = antony,
        therapist = ania,
        today,
        "11:00",
        "11:30"
    ),

    Session(
        id = 1,
        patient = andy,
        therapist = ania,
        days[3],
        "11:30",
        "12:00"
    ),
)


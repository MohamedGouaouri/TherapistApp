package com.example.therapistapp.tabibi.presentation.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.therapistapp.R


val QuickSand = FontFamily(listOf(
    Font(R.font.quicksand_light, FontWeight.W300),
    Font(R.font.quicksand_regular, FontWeight.W400),
    Font(R.font.quicksand_medium, FontWeight.W500),
    Font(R.font.quicksand_bold, FontWeight.W600),
))

// Set of Material typography styles to start with
val Typography = Typography(
    h1 = TextStyle(
        fontFamily = QuickSand,
        fontSize = 38.sp,
        fontWeight = FontWeight.Bold
    ),
    h2 = TextStyle(
        fontFamily = QuickSand,
        fontSize = 25.sp,
        fontWeight = FontWeight.SemiBold
    ),

    h3 = TextStyle(
        fontFamily = QuickSand,
        fontSize = 18.sp,
        fontWeight = FontWeight.SemiBold
    ),
    h4 = TextStyle(
        fontFamily = QuickSand,
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold
    ),

    h5 = TextStyle(
        fontFamily = QuickSand,
        fontSize = 12.sp,
        fontWeight = FontWeight.SemiBold
    ),

    body1 = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp
    ),
    body2 = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )

    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)


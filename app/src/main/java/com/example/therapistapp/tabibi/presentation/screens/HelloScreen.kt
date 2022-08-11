package com.example.therapistapp.tabibi.presentation.screens

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.therapistapp.R
import com.example.therapistapp.tabibi.presentation.MainActivity
import com.example.therapistapp.tabibi.presentation.ui.theme.Green

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HelloScreen(
    ctx: Context,
    activityKiller : () -> Unit
) {

        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.back),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.matchParentSize()
            )
            Column(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 200.dp),
                horizontalAlignment = Alignment.CenterHorizontally,

                ) {
                Text(
                    text = "Therapy & Care",
                    color = Color.White,
                    style = MaterialTheme.typography.h1
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "We help professional therapists and patients find each other",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.body1

                )
                Spacer(modifier = Modifier.height(40.dp))

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(50.dp))
                        .clickable {
                            val intent = Intent(ctx, MainActivity::class.java)
                            ctx.startActivity(intent)
                            // Kills auth activity
                            activityKiller()
                        }
                        .background(Color.White)
                        .padding(vertical = 15.dp, horizontal = 70.dp),
                    contentAlignment = Alignment.Center

                ){
                    Text(
                        text = "Get started",
                        color = Green,
                        style = MaterialTheme.typography.body2
                    )
                }
            }
        }

}
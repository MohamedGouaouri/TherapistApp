package com.example.therapistapp.tabibi.presentation.screens

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.therapistapp.R
import com.example.therapistapp.tabibi.presentation.ui.theme.*
import com.example.therapistapp.tabibi.presentation.viewmodels.SessionDetailsViewModel
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun SessionDetailsScreen(
    viewModel: SessionDetailsViewModel = hiltViewModel(),
    navController: NavController,
    ctx: Context
) {
    val state = viewModel.state.value
    TherapistAppTheme() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ){
            Column() {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(modifier = Modifier
                        .height(48.dp)
                        .width(48.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Transparent)
                        .clickable {
                            navController.popBackStack()
                        },
                        contentAlignment = Alignment.Center
                    ){
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "",
                            tint = Gray
                        )
                    }

                    Text(
                        text = "Session Info",
                        style = MaterialTheme.typography.h4,
                        color = Gray
                    )

                    Box(modifier = Modifier
                        .height(48.dp)
                        .width(48.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Transparent)
                        .clickable {
                            // make phone call
                            val callIntent = Intent(Intent.ACTION_CALL)

                            callIntent.data = Uri.parse("tel:${state.session.patient.phoneNumber}")
                            ctx.startActivity(callIntent)

                        }
                        ,
                        contentAlignment = Alignment.Center
                    ){
                        Icon(
                            imageVector = Icons.Default.Call,
                            contentDescription = "",
                            tint = Gray
                        )
                    }

                }
                // User info
                UserInfo(
                    patientName = state.session.patient.firstName,
                    age = state.session.patient.age,
                    sessionDate = state.session.sessionData.toString(),
                    sessionFrom = state.session.from,
                    sessionTo = state.session.to,
                )

                // Heading
                Text(
                    text = "Complaints",
                    style = MaterialTheme.typography.h2,
                    color = DarkGreen,
                    modifier = Modifier.padding(vertical = 10.dp)
                )


                // tags
                FlowRow(
                    mainAxisSpacing = 10.dp,
                    crossAxisSpacing = 10.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp)
                ) {
                    state.session.patient.complaints.forEach {
                        ComplaintTag(complaint = it.complaint)
                    }

                }

                Tabs(
                    modifier = Modifier.padding(vertical = 10.dp)
                )

                GeneralInfo(
                    firstName = state.session.patient.firstName,
                    lastName = state.session.patient.lastName,
                    dob = state.session.patient.dateOfBirth,
                    gender = state.session.patient.gender
                )

            }
        }
    }

}


@Composable
fun UserInfo(
    patientName: String,
    age: Int,
    sessionDate: String,
    sessionFrom: String,
    sessionTo: String,
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // User picture
        Image(
            painter = painterResource(id = R.drawable.user2),
            contentDescription = "",
            modifier = Modifier
                .height(78.dp)
                .width(78.dp)
                .clip(CircleShape)
        )
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(horizontal = 20.dp)
        ) {
            Text(
                text = patientName,
                style = MaterialTheme.typography.h3,
                color = DarkGreen,
            )
            Text(
                text = "$age yo",
                style = MaterialTheme.typography.body2
            )
            Text(
                text = "$sessionDate $sessionFrom - $sessionTo",
                fontFamily = QuickSand,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                color = Green
            )
        }
    }
}


@Composable
fun ComplaintTag(
    complaint: String
) {
    Box(modifier = Modifier
        .clip(RoundedCornerShape(10.dp))
        .background(Green)
        .padding(10.dp)
    ){
        Text(
            text = complaint,
            style = MaterialTheme.typography.h5,
            color = Color.White
        )
    }
}


@Composable
fun Tabs(
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier
    ){
        item {
            Text(
                text = "Information",
                style = MaterialTheme.typography.h3,
                color = Green,
                modifier = Modifier.padding(end = 20.dp)
            )
        }
        item {
            Text(
                text = "Medicine",
                style = MaterialTheme.typography.h3,
                color = lightGray,
                modifier = Modifier.padding(end = 20.dp)

            )
        }
        item {
            Text(
                text = "Diagnoses",
                style = MaterialTheme.typography.h3,
                color = lightGray,
                modifier = Modifier.padding(end = 20.dp)


            )
        }
    }
}


@Composable
fun GeneralInfo(
    firstName: String,
    lastName: String,
    dob: String,
    gender: String
) {

    Box(modifier = Modifier
        .fillMaxWidth()
        .clip(RoundedCornerShape(10.dp))
        .background(Transparent)
        .padding(20.dp)
    ){
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "General",
                style = MaterialTheme.typography.h2,
                color = DarkGreen,
                modifier = Modifier.padding(vertical = 10.dp)
            )

            // First name
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp)

                ,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "First name",
                    style = MaterialTheme.typography.h4,
                    color = lightGray,
                )
                Text(
                    text =  firstName,
                    style = MaterialTheme.typography.h4,
                    color = DarkGreen
                )
            }
            Divider(
                modifier = Modifier.fillMaxWidth(),
                color = lightGray
            )

            // Last name

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Last name",
                    style = MaterialTheme.typography.h4,
                    color = lightGray
                )
                Text(
                    text =  lastName,
                    style = MaterialTheme.typography.h4,
                    color = DarkGreen
                )
            }
            Divider(
                modifier = Modifier
                    .fillMaxWidth()

                ,
                color = lightGray
            )

            // Date of birth
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp)
                ,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Date of birth",
                    style = MaterialTheme.typography.h4,
                    color = lightGray
                )
                Text(
                    text =  dob,
                    style = MaterialTheme.typography.h4,
                    color = DarkGreen
                )
            }
            Divider(
                modifier = Modifier.fillMaxWidth(),
                color = lightGray
            )

            // gender
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp)
                ,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Gender",
                    style = MaterialTheme.typography.h4,
                    color = lightGray
                )
                Text(
                    text =  gender,
                    style = MaterialTheme.typography.h4,
                    color = DarkGreen
                )
            }
        }
    }

}
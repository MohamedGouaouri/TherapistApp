package com.example.therapistapp.tabibi.presentation.screens

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.therapistapp.R
import com.example.therapistapp.tabibi.domain.models.Session
import com.example.therapistapp.tabibi.domain.services.ConnectivityObserver
import com.example.therapistapp.tabibi.domain.services.NetworkConnectivityObserver
import com.example.therapistapp.tabibi.presentation.components.BottomNavigation
import com.example.therapistapp.tabibi.presentation.data.days
import com.example.therapistapp.tabibi.presentation.ui.theme.*
import com.example.therapistapp.tabibi.presentation.utils.standardQuadFromTo
import com.example.therapistapp.tabibi.presentation.viewmodels.SessionListViewMode
import java.text.DateFormatSymbols
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SessionsScreen(
    navController: NavController,
    ctx: Context,
    viewModel: SessionListViewMode = hiltViewModel()
) {

    val state by remember {
        viewModel.state
    }

    val connectivityObserver = NetworkConnectivityObserver(ctx)
    val networkState by connectivityObserver.observe().collectAsState(
        initial = ConnectivityObserver.Status.Unavailable
    )

    TherapistAppTheme {
        Scaffold() {
            BoxWithConstraints(modifier = Modifier
                .fillMaxSize()
                .background(Green)
            ){
                val width = constraints.maxWidth
                val height = constraints.maxHeight
                val point1 = Offset(0f, height * 0.1f)
                val point2 = Offset(0.5f * width, 0.08f * height)
                val point3 = Offset(width.toFloat(), 0.2f * height)
                val point4 = Offset(width.toFloat(), 0.25f * height)

                val path = Path().apply {
                    moveTo(point1.x, point1.y)
                    standardQuadFromTo(point1, point2)
                    standardQuadFromTo(point2, point3)
                    standardQuadFromTo(point3, point4)

                    lineTo(100f + width.toFloat(), 100f + height.toFloat())
                    lineTo(100f + -width.toFloat(), 100f + height.toFloat())
                    close()

                }
                Canvas(modifier = Modifier.fillMaxSize() ){

                    drawPath(
                        path = path,
                        color = Color.White
                    )
                }
                Box(modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
                ){
                    Column {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            // Image box
                            // TODO: Change this to network image
                            Box(modifier = Modifier
                                .height(54.dp)
                                .width(54.dp)
                                .clip(CircleShape)
                                .background(
                                    if (networkState == ConnectivityObserver.Status.Available) {
                                        Color.Green
                                    } else {
                                        Gray
                                    }
                                ),
                                contentAlignment = Alignment.Center
                            ){
                                Image(
                                    painter = painterResource(id = R.drawable.profile),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .height(48.dp)
                                        .width(48.dp)
                                        .clip(CircleShape)
                                )
                            }

                            Box(modifier = Modifier
                                .height(48.dp)
                                .width(48.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .background(Transparent),
                                contentAlignment = Alignment.Center
                            ){
                                Icon(
                                    painter = painterResource(id = R.drawable.bell_860),
                                    contentDescription = ""
                                )
                            }

                        }
//                                Spacer(modifier = Modifier.height(50.dp))
                        // Greeting
                        Greeting(
                            modifier = Modifier.padding(top = 50.dp),
                            sessions = state.sessions.size
                        )

                        // Days chips
                        DaysChips(
                            viewModel = viewModel
                        )


                        // Heading
                        Text(
                            text = "Upcoming Sessions",
                            style = MaterialTheme.typography.h2,
                            color = DarkGreen,
                            modifier = Modifier.padding(vertical = 10.dp)
                        )

                        // List
                        // TODO: Pass data while navigation
                        LazyColumn(){
                            items(state.sessions){session ->
                                SessionsItem(
                                    session,
                                    image = R.drawable.user2,
                                    onClick = {
                                        Log.d("NAV", "Navigating")
                                        navController.navigate(Screens.SessionDetailsScreen.route + "/${session.id}")
                                    }
                                )
                            }
                        }
                    }
                }

                BottomNavigation(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(30.dp))
                        .background(Green)
                        .padding(vertical = 20.dp, horizontal = 5.dp)
                        .align(Alignment.BottomEnd),
                    navController = navController
                )

            }

        }
    }
}

@Composable
fun Greeting(
    greeting: String = "Good morning",
    doctor: String = "Dr. Ania",
    sessions: Int = 4,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
    ) {
        Text(
            text = "$greeting $doctor",
            style = MaterialTheme.typography.h2,
            color = DarkGreen
        )

        Text(
            text = "You have $sessions sessions today",
            style = MaterialTheme.typography.body2,
            color = Gray
        )
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DaysChips(
    viewModel: SessionListViewMode
) {

    var selectedDay by remember {
        mutableStateOf(2)
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp)
        ,
        horizontalArrangement = Arrangement.SpaceAround,
    ) {
        days.forEachIndexed { index, date ->
            DaysChipItem(
                date = date,
                isSelected = selectedDay == index
            ) {
                selectedDay = index
                // Change the state
                viewModel.getSessions(date)
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DaysChipItem(
    date: LocalDate ,
    isSelected: Boolean = false,
    onClick: () -> Unit
) {
    val dateSymbols = DateFormatSymbols()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        if (isSelected){
            Box(modifier = Modifier
                .height(58.dp)
                .width(58.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Transparent)
                .padding(10.dp)
                .clickable { onClick() }
                ,
                contentAlignment = Alignment.Center
            ){
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(CircleShape)
                        .background(Green),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "${date.dayOfMonth}",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }
            }
        }else{
            Box(modifier = Modifier
                .height(48.dp)
                .width(48.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Transparent)
                .clickable { onClick() }
                ,
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = "${date.dayOfMonth}",
                    color = Gray,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
        }

        Text(
            text = dateSymbols.shortWeekdays[date.dayOfWeek.value],
            color = Gray,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
        )
    }
}


@Composable
fun SessionsItem(
    session: Session,
    image: Int,
    onClick: () -> Unit
) {

    var checkedState by remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(140.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Transparent)
            .clickable {
                onClick()
            }
            .padding(10.dp)
        ){
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        painter = painterResource(id = image),
                        contentDescription = "",
                        modifier = Modifier
                            .height(48.dp)
                            .width(48.dp)
                            .clip(CircleShape)
                    )

                    Column (
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .weight(4f)

                    ) {
                        Text(
                            text = "${session.patient.firstName} ${session.patient.lastName} ",
                            style = MaterialTheme.typography.h3,
                            color = DarkGreen,
                        )
                        Text(
                            text = "${session.patient.age} yo",
                            style = MaterialTheme.typography.body2
                        )
                    }

                    Checkbox(
                        checked = checkedState,
                        onCheckedChange = {
                            checkedState = !checkedState
                        },
                        modifier = Modifier.weight(1f)
                    )
                }

                Text(
                    text = "${session.sessionData} ${session.from} - ${session.to}",
                    fontFamily = QuickSand,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp
                )
            }

        }
        Spacer(modifier = Modifier.height(10.dp))
    }

}

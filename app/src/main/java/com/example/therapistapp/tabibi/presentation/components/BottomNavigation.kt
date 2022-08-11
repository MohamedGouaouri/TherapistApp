package com.example.therapistapp.tabibi.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import com.example.therapistapp.tabibi.presentation.ui.theme.Transparent


@Composable
fun BottomNavigation(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    var selectedIndex by remember {
        mutableStateOf(0)
    }
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        BottomNavigationItem(Icons.Default.Home, isSelected = selectedIndex == 0, onSelect = {selectedIndex = 0})
        BottomNavigationItem(Icons.Default.Menu , isSelected = selectedIndex == 1, onSelect = {selectedIndex = 1})
        BottomNavigationItem(Icons.Default.Info , isSelected = selectedIndex == 2, onSelect = {selectedIndex = 2})
        BottomNavigationItem(Icons.Default.Person, isSelected = selectedIndex == 3, onSelect = {selectedIndex = 3})
    }
}

@Composable
fun BottomNavigationItem(
    icon: ImageVector,
    isSelected: Boolean = false,
    onSelect: () -> Unit
) {
    val interactionSource = remember {
        MutableInteractionSource()
    }
    Box(modifier = Modifier
        .clickable(
            interactionSource = interactionSource,
            indication = null,
            onClick = {
                onSelect()
            }
        )
    ){
        Icon(
            imageVector = icon,
            contentDescription = "",
            tint = if (isSelected) Color.White else Transparent,

        )
    }
}
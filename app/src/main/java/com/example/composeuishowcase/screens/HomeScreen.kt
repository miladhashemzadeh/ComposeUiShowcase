package com.example.composeuishowcase.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.composeuishowcase.R
import com.example.composeuishowcase.theme.LocalCustomGradients

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onNavigateToCatalog: () -> Unit,
    onNavigateToCityList: () -> Unit,
    onNavigateToWeatherList: () -> Unit,
) {
    val gradient = LocalCustomGradients.current.Gradient2Horizontal
    Scaffold(
        modifier = Modifier.fillMaxSize()
            .background(gradient),
        topBar = {

        },
        content = { _ ->
            CityDetail(modifier = modifier,
                onNavigateToCatalog = onNavigateToCatalog,
            )
        },
        bottomBar = {
            ImageBottomBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                onNavigateToCityList = onNavigateToCityList,
                onNavigateToWeatherList = onNavigateToWeatherList
            )
        }
    )
}

@Composable
fun ImageBottomBar(
    modifier: Modifier = Modifier,
    onNavigateToCityList: () -> Unit,
    onNavigateToWeatherList: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        BackgroundBottomBar(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .wrapContentHeight(),
            listClicked = onNavigateToCityList,
            hoverClicked = onNavigateToWeatherList
        )
        BottomBarFab(
            modifier = Modifier.align(Alignment.BottomCenter),
            fabClicked = {}
        )
    }
}

@Composable
fun BackgroundBottomBar(
    modifier: Modifier = Modifier,
    listClicked: () -> Unit,
    hoverClicked: () -> Unit
) {
    Box(modifier = modifier) {
        Image(
            contentScale = ContentScale.FillBounds,
            painter = painterResource(R.drawable.bg_bottom_bar),
            contentDescription = null,
            modifier = Modifier
                .matchParentSize()
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.hover),
                contentDescription = null,
                modifier = Modifier
                    .clip(CircleShape)
                    .clickable { hoverClicked() }
            )
            Image(
                painter = painterResource(R.drawable.list),
                contentDescription = null,
                modifier = Modifier
                    .clip(CircleShape)
                    .clickable { listClicked() }
            )
        }
    }
}

@Composable
fun BottomBarFab(
    modifier: Modifier = Modifier,
    fabClicked: () -> Unit
) {
    var isPressed by remember { mutableStateOf(false) }

    Box(modifier = modifier) {
        Image(
            modifier = Modifier.align(Alignment.Center),
            painter = painterResource(R.drawable.fab_button),
            contentDescription = null
        )

        Image(
            modifier = Modifier
                .align(Alignment.Center)
                .size(92.dp)
                .clip(CircleShape)
                .pointerInput(Unit) {
                    detectTapGestures(
                        onPress = {
                            isPressed = true
                            val released = tryAwaitRelease()
                            isPressed = false
                            if (released) {
                                fabClicked()
                            }
                        }
                    )
                },
            painter = painterResource(
                if (isPressed) R.drawable.fab_clicked
                else R.drawable.fab_default
            ),
            contentDescription = null
        )
    }
}
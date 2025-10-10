package com.example.composeuishowcase.catalog

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.composeuishowcase.theme.LocalCustomColors
import com.example.composeuishowcase.theme.LocalCustomGradients

@Composable
fun CatalogScreen(
    onNavigateBack: () -> Unit
) {
    val customColors = LocalCustomColors.current
    val customGradients = LocalCustomGradients.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "UI Component Catalog",
            style = MaterialTheme.typography.headlineMedium
        )


        Text(
            text = "Display Large Text",
            style = MaterialTheme.typography.displayLarge,
            color = customColors.solidPurple
        )
        Text(
            text = "Body Medium Text",
            style = MaterialTheme.typography.bodyMedium,
            color = customColors.solidVividPurple
        )


        Button(
            onClick = { /* Do nothing */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Primary Button")
        }


        Card(
            shape = MaterialTheme.shapes.large,
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(customGradients.Gradient1),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Card with Gradient",
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }

        var text by remember { mutableStateOf(TextFieldValue("")) }
        BasicTextField(
            value = text,
            onValueChange = { text = it },
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, customColors.solidDarkPurple, MaterialTheme.shapes.medium)
                .padding(8.dp),
            textStyle = MaterialTheme.typography.bodyMedium.copy(color = customColors.solidLightPurple)
        )


        Spacer(
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .background(customGradients.Radial)
        )


        Button(
            onClick = onNavigateBack,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Back to Home")
        }
    }
}
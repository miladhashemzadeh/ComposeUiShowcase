package com.example.composeuishowcase.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = Black,
    secondary = SecondaryLight,
    tertiary = LightTertiary,
    onPrimary = White,
    onSecondary = Black,
    surface = White,
    onSurface = Black,
)

private val DarkColorScheme = darkColorScheme(
    primary = White,
    secondary = SecondaryDark,
    tertiary = DarkTertiary,
    onPrimary = Black,
    onSecondary = White,
    surface = Black,
    onSurface = White,
)

object CustomGradients {
    val Gradient1Vertical: Brush
        @Composable get() = Brush.verticalGradient(
            listOf(Gradient1Start, Gradient1End)
        )
    val Gradient1Horizontal: Brush
        @Composable get() = Brush.horizontalGradient(
            listOf(Gradient1Start, Gradient1End)
        )
    val Gradient2Vertical: Brush
        @Composable get() = Brush.verticalGradient(
            listOf(Gradient2Start, Gradient2End)
        )
    val Gradient2Horizontal: Brush
        @Composable get() = Brush.horizontalGradient(
            listOf(Gradient2End, Gradient2Start)
        )
    val Gradient3Vertical: Brush
        @Composable get() = Brush.verticalGradient(
            listOf(Gradient3Start, Gradient3End)
        )
    val Gradient3Horizontal: Brush
        @Composable get() = Brush.horizontalGradient(
            listOf(Gradient3Start, Gradient3End)
        )
    val Gradient4Vertical: Brush
        @Composable get() = Brush.verticalGradient(
            listOf(Gradient4Start, Gradient4End)
        )
    val Gradient4Horizontal: Brush
        @Composable get() = Brush.horizontalGradient(
            listOf(Gradient4Start, Gradient4End)
        )
    val Radial: Brush
        @Composable get() = Brush.radialGradient(
            listOf(RadialGradientStart, RadialGradientEnd)
        )
    val Angular: Brush
        @Composable get() = Brush.linearGradient(
            listOf(AngularGradient, AngularGradient)
        )
    val ThemedVertical: Brush
        @Composable get() = if (isSystemInDarkTheme()) {
            Brush.verticalGradient(listOf(DarkQuaternary, Black))
        } else {
            Brush.verticalGradient(listOf(LightQuaternary, White))
        }
}


object CustomColors {
    val solidPurple = SolidPurple
    val solidDarkPurple = SolidDarkPurple
    val solidVividPurple = SolidVividPurple
    val solidLightPurple = SolidLightPurple
    val Quaternary: Color
        @Composable get() = if (isSystemInDarkTheme()) DarkQuaternary else LightQuaternary
}

@Composable
fun ShowcaseTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    CompositionLocalProvider(
        LocalCustomColors provides CustomColors,
        LocalCustomGradients provides CustomGradients
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = ShowcaseTypography,
            shapes = ShowcaseShapes,
            content = content
        )
    }
}
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
    val Gradient1 = Brush.linearGradient(listOf(Gradient1Start, Gradient1End))
    val Gradient2 = Brush.linearGradient(listOf(Gradient2Start, Gradient2End))
    val Gradient3 = Brush.linearGradient(listOf(Gradient3Start, Gradient3End))
    val Gradient4 = Brush.linearGradient(listOf(Gradient4Start, Gradient4End))
    val Radial = Brush.radialGradient(listOf(RadialGradientStart, RadialGradientEnd))
    val Angular = Brush.linearGradient(listOf(AngularGradient, AngularGradient))
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
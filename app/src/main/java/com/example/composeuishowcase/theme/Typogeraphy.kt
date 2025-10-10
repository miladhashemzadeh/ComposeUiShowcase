package com.example.composeuishowcase.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.example.composeuishowcase.R

val SFProDisplay = FontFamily(
    Font(R.font.sfprodisplayblackitalic, FontWeight.Black, FontStyle.Italic),
    Font(R.font.sfprodisplaybold, FontWeight.Bold),
    Font(R.font.sfprodisplayheavyitalic, FontWeight.ExtraBold, FontStyle.Italic),
    Font(R.font.sfprodisplaylightitalic, FontWeight.Light, FontStyle.Italic),
    Font(R.font.sfprodisplaymedium, FontWeight.Medium),
    Font(R.font.sfprodisplayregular, FontWeight.Normal),
    Font(R.font.sfprodisplaysemibolditalic, FontWeight.SemiBold, FontStyle.Italic),
    Font(R.font.sfprodisplaylightitalic, FontWeight.Thin, FontStyle.Italic),
    Font(R.font.sfprodisplayultralightitalic, FontWeight.ExtraLight, FontStyle.Italic)
)

val ShowcaseTypography = Typography(
    displayLarge = androidx.compose.ui.text.TextStyle(
        fontFamily = SFProDisplay,
        fontWeight = FontWeight.Black,
        fontSize = Sizes.TextDisplayLarge
    ),
    displayMedium = androidx.compose.ui.text.TextStyle(
        fontFamily = SFProDisplay,
        fontWeight = FontWeight.Bold,
        fontSize = Sizes.TextDisplayMedium
    ),
    displaySmall = androidx.compose.ui.text.TextStyle(
        fontFamily = SFProDisplay,
        fontWeight = FontWeight.SemiBold,
        fontSize = Sizes.TextDisplaySmall
    ),
    headlineLarge = androidx.compose.ui.text.TextStyle(
        fontFamily = SFProDisplay,
        fontWeight = FontWeight.Medium,
        fontSize = Sizes.TextHeadlineLarge
    ),
    headlineMedium = androidx.compose.ui.text.TextStyle(
        fontFamily = SFProDisplay,
        fontWeight = FontWeight.Normal,
        fontSize = Sizes.TextHeadlineMedium
    ),
    headlineSmall = androidx.compose.ui.text.TextStyle(
        fontFamily = SFProDisplay,
        fontWeight = FontWeight.Light,
        fontSize = Sizes.TextHeadlineSmall
    ),
    bodyLarge = androidx.compose.ui.text.TextStyle(
        fontFamily = SFProDisplay,
        fontWeight = FontWeight.Normal,
        fontSize = Sizes.TextBodyLarge
    ),
    bodyMedium = androidx.compose.ui.text.TextStyle(
        fontFamily = SFProDisplay,
        fontWeight = FontWeight.Medium,
        fontSize = Sizes.TextBodyMedium
    ),
    bodySmall = androidx.compose.ui.text.TextStyle(
        fontFamily = SFProDisplay,
        fontWeight = FontWeight.Thin,
        fontSize = Sizes.TextBodySmall
    )
)
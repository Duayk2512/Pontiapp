package com.pontificia.app.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = PrimaryBlue,
    secondary = ELPDarkBlue,
    tertiary = ILPBlue
)

private val LightColorScheme = lightColorScheme(
    primary = PrimaryBlue,
    secondary = ELPDarkBlue,
    tertiary = ILPBlue,
    background = Color(0xFFF8F9FA),
    surface = Color.White
)

@Composable
fun PontificiaAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
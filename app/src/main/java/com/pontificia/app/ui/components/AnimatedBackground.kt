package com.pontificia.app.ui.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.pontificia.app.ui.theme.ELPBlue
import com.pontificia.app.ui.theme.ILPBlue
import com.pontificia.app.ui.theme.IdiomasMagenta

@Composable
fun AnimatedBackground() {
    val infiniteTransition = rememberInfiniteTransition(label = "backgroundAnimation")

    // Animación de traslación circular para la primera burbuja
    val offsetY1 by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 100f,
        animationSpec = infiniteRepeatable(
            animation = tween(6000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "offsetY1"
    )

    // Animación inversa para la segunda burbuja
    val offsetY2 by infiniteTransition.animateFloat(
        initialValue = 100f,
        targetValue = 0f,
        animationSpec = infiniteRepeatable(
            animation = tween(8000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "offsetY2"
    )

    Canvas(modifier = Modifier.fillMaxSize()) {
        val canvasWidth = size.width
        val canvasHeight = size.height

        // Burbuja animada 1 (Azul ILP en la parte superior derecha)
        drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(ILPBlue.copy(alpha = 0.12f), Color.Transparent),
                center = Offset(canvasWidth * 0.8f, (canvasHeight * 0.2f) + offsetY1),
                radius = 350f
            ),
            radius = 350f,
            center = Offset(canvasWidth * 0.8f, (canvasHeight * 0.2f) + offsetY1)
        )

        // Burbuja animada 2 (Púrpura Idiomas en la parte inferior izquierda)
        drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(IdiomasMagenta.copy(alpha = 0.10f), Color.Transparent),
                center = Offset(canvasWidth * 0.1f, (canvasHeight * 0.7f) + offsetY2),
                radius = 400f
            ),
            radius = 400f,
            center = Offset(canvasWidth * 0.1f, (canvasHeight * 0.7f) + offsetY2)
        )
    }
}
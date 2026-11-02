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
import com.pontificia.app.ui.theme.ELPCoralRed
import com.pontificia.app.ui.theme.ILPBlue

@Composable
fun AnimatedBackground() {
    val infiniteTransition = rememberInfiniteTransition(label = "bgAnim")

    val offsetY1 by infiniteTransition.animateFloat(
        initialValue = 0f, targetValue = 150f,
        animationSpec = infiniteRepeatable(tween(5000, easing = LinearEasing), RepeatMode.Reverse),
        label = "oy1"
    )

    val offsetY2 by infiniteTransition.animateFloat(
        initialValue = 150f, targetValue = 0f,
        animationSpec = infiniteRepeatable(tween(7000, easing = LinearEasing), RepeatMode.Reverse),
        label = "oy2"
    )

    Canvas(modifier = Modifier.fillMaxSize()) {
        drawRect(color = Color(0xFFF4F7FB))

        // Orbe animado superior (Azul ILP)
        drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(ILPBlue.copy(alpha = 0.18f), Color.Transparent),
                center = Offset(size.width * 0.85f, (size.height * 0.15f) + offsetY1),
                radius = 500f
            ),
            radius = 500f,
            center = Offset(size.width * 0.85f, (size.height * 0.15f) + offsetY1)
        )

        // Orbe animado inferior (Rojo Coral ELP)
        drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(ELPCoralRed.copy(alpha = 0.15f), Color.Transparent),
                center = Offset(size.width * 0.15f, (size.height * 0.8f) + offsetY2),
                radius = 600f
            ),
            radius = 600f,
            center = Offset(size.width * 0.15f, (size.height * 0.8f) + offsetY2)
        )
    }
}
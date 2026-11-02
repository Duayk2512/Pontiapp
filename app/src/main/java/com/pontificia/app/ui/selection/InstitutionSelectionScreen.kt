package com.pontificia.app.ui.selection

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pontificia.app.R
import com.pontificia.app.ui.theme.*

enum class InstitutionType(val title: String, val accent: Color) {
    ILP("Instituto La Pontificia", ILPBlue),
    ELP("Escuela Superior La Pontificia", ELPCoralRed),
    IDIOMAS("Centro de Idiomas", IdiomasPurple)
}

@Composable
fun InstitutionSelectionScreen(onSelect: (InstitutionType) -> Unit) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(24.dp))

        Image(
            painter = painterResource(id = R.drawable.logo_pontificia),
            contentDescription = "Logo",
            modifier = Modifier.size(75.dp).padding(bottom = 8.dp)
        )

        Text(
            text = "¿A qué unidad académica\nde La Pontificia pertenece?",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center,
            lineHeight = 28.sp
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = "Seleccione su institución para acceder a los servicios",
            fontSize = 13.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // 1. Instituto La Pontificia (ILP)
        GradientCard(
            title = "Instituto La Pontificia",
            acronym = "ILP",
            description = "Carreras técnicas, notas y comunicados oficiales.",
            gradient = listOf(ILPBlue, Color(0xFF1565C0)),
            logoRes = R.drawable.logo_ilp,
            onClick = { onSelect(InstitutionType.ILP) }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // 2. Escuela Superior La Pontificia (ELP) - Actualizado con los colores del logo
        GradientCard(
            title = "Escuela Superior La Pontificia",
            acronym = "ELP",
            description = "Programas superiores y plataformas académicas.",
            gradient = listOf(ELPCoralRed, ELPAmberOrange),
            logoRes = R.drawable.logo_elp,
            onClick = { onSelect(InstitutionType.ELP) }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // 3. Centro de Idiomas
        GradientCard(
            title = "Centro de Idiomas",
            acronym = "Idiomas LP",
            description = "Cursos de inglés, matrículas y certificaciones.",
            gradient = listOf(IdiomasPurple, Color(0xFF4A148C)),
            logoRes = R.drawable.logo_idiomas,
            onClick = { onSelect(InstitutionType.IDIOMAS) }
        )

        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Composable
fun GradientCard(
    title: String,
    acronym: String,
    description: String,
    gradient: List<Color>,
    logoRes: Int,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(18.dp))
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Brush.horizontalGradient(gradient))
                .padding(20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    modifier = Modifier.size(52.dp),
                    shape = CircleShape,
                    color = Color.White,
                    shadowElevation = 4.dp
                ) {
                    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                        Image(
                            painter = painterResource(id = logoRes),
                            contentDescription = acronym,
                            modifier = Modifier.size(34.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.width(16.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Text(text = title, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White)
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(text = description, fontSize = 12.sp, color = Color.White.copy(alpha = 0.85f), lineHeight = 16.sp)
                }

                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "Ir",
                    tint = Color.White,
                    modifier = Modifier.size(22.dp)
                )
            }
        }
    }
}
package com.pontificia.app.ui.detail

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pontificia.app.ui.components.PortalCard
import com.pontificia.app.ui.selection.InstitutionType
import com.pontificia.app.ui.theme.*
import com.pontificia.app.ui.theme.ELPCoralRed
@Composable
fun InstitutionDetailScreen(
    institution: InstitutionType,
    onBack: () -> Unit
) {
    val context = LocalContext.current
    val scrollState = rememberScrollState()

    fun abrirEnlace(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        context.startActivity(intent)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(24.dp)
    ) {
        IconButton(
            onClick = onBack,
            modifier = Modifier
                .size(40.dp)
                .background(MaterialTheme.colorScheme.surface, CircleShape)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Regresar",
                tint = institution.accent
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = institution.title,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = institution.accent
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "Plataformas oficiales y herramientas virtuales",
            fontSize = 13.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Redirecciones específicas según la institución seleccionada
        when (institution) {
            InstitutionType.ILP -> {
                PortalCard(
                    title = "Plataforma Principal ILP",
                    subtitle = "Portal Web Institucional",
                    description = "Información general, carreras técnicas y comunicados oficiales.",
                    accentColor = ILPBlue,
                    onClick = { abrirEnlace("https://www.ilp.edu.pe") }
                )
                Spacer(modifier = Modifier.height(12.dp))
                PortalCard(
                    title = "Aula Virtual ILP",
                    subtitle = "Gestión de Aprendizaje (Login)",
                    description = "Acceso a cursos, tareas y recursos académicos.",
                    accentColor = ILPBlue,
                    onClick = { abrirEnlace("https://aulavirtual.ilp.edu.pe/login/index.php") }
                )
                Spacer(modifier = Modifier.height(12.dp))
                PortalCard(
                    title = "Sistema Pontisis ILP",
                    subtitle = "Consulta de Notas y Matrícula",
                    description = "Acceso al sistema de gestión académica y expediente del estudiante.",
                    accentColor = ILPBlue,
                    onClick = { abrirEnlace("https://pontisis.ilp.edu.pe") }
                )
            }
            InstitutionType.ELP -> {
                PortalCard(
                    title = "Plataforma Principal ELP",
                    subtitle = "Portal Web Escuela Superior",
                    description = "Programas profesionales superiores e infraestructura.",
                    accentColor = ELPCoralRed,
                    onClick = { abrirEnlace("https://www.elp.edu.pe") }
                )
                Spacer(modifier = Modifier.height(12.dp))
                PortalCard(
                    title = "Aula Virtual ELP",
                    subtitle = "Plataforma Académica Superior",
                    description = "Seguimiento de asignaturas y evaluaciones virtuales.",
                    accentColor = ELPCoralRed,
                    onClick = { abrirEnlace("https://aulavirtual.elp.edu.pe/login/index.php") }
                )
                Spacer(modifier = Modifier.height(12.dp))
                PortalCard(
                    title = "Sistema Pontisis ELP",
                    subtitle = "Gestión Académica y Matrículas",
                    description = "Portal de notas, historial y trámites académicos ELP.",
                    accentColor = ELPCoralRed,
                    onClick = { abrirEnlace("https://pontisis.elp.edu.pe") }
                )
            }
            InstitutionType.IDIOMAS -> {
                PortalCard(
                    title = "Plataforma Centro de Idiomas",
                    subtitle = "Portal Web Oficial",
                    description = "Información sobre ciclos, cursos de inglés y evaluaciones.",
                    accentColor = IdiomasPurple,
                    onClick = { abrirEnlace("https://www.idiomaslp.edu.pe") }
                )
                Spacer(modifier = Modifier.height(12.dp))
                PortalCard(
                    title = "Sistema Pontisis Idiomas",
                    subtitle = "Matrículas y Notas de Inglés",
                    description = "Gestión de matrículas y control de notas de idiomas.",
                    accentColor = IdiomasPurple,
                    onClick = { abrirEnlace("https://pontisis.idiomaslp.edu.pe") }
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Divider(color = MaterialTheme.colorScheme.outlineVariant, thickness = 1.dp)

        Spacer(modifier = Modifier.height(20.dp))

        // SECCIÓN INSTITUCIONAL COMPARTIDA: Microsoft 365 y Teams
        Text(
            text = "Herramientas Institucionales",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Tarjeta Microsoft 365 con el degradado de los 4 colores oficiales
        MicrosoftPortalCard(
            title = "Microsoft 365 Institucional",
            subtitle = "Correo y Office en la Nube",
            description = "Accede al correo institucional y herramientas de Office en la nube.",
            gradientColors = listOf(MicrosoftRed, MicrosoftYellow, MicrosoftGreen, MicrosoftBlue),
            onClick = {
                abrirEnlace("https://login.microsoftonline.com/common/oauth2/v2.0/authorize?scope=https%3A%2F%2Faccount.microsoft.com%2FMBI%20openid%20profile%20offline_access&response_type=code&client_id=81feaced-5ddd-41e7-8bef-3e20a2689bb7&redirect_uri=https%3A%2F%2Faccount.microsoft.com%2Fauth%2Fcomplete-signin-oauth&client-request-id=28d79d72-632d-4808-a128-aef90ca6b0df&x-client-SKU=MSAL.Desktop&x-client-Ver=4.84.2.0&prompt=login&client_info=1&state=H4sIAAAAAAAEAAXByYJDMAAA0H_ptQeUVB3tuxFrmhvFdNKKrRV8_bx3uvgMacg080Ni74QbAzewG-sI8iwqG4t3bbjOdSLIxsYkd3NteXLsYlIHrz4rv3HntPCHiJG6PL97E0dxno4fjcClGsysQvh2f0EelaUwrfXVOZtA-AAPcazFmqAUzcXqDhas_bwJw7LimPI5kWlJvHfWWyl96NzrQ_NgJgrvVY4P5cZ4pAzoXz_PRkPlH5zusrDeKep2TfeeW0ilrgXtQmd9n8JgE1MPHrRT_BwvGFsT5v_6CiKzuWVaQNTxnl07cdOECFkAQykRNCVNgJw0y8BCnbG5nNW70ye33aIb6pe34RRiB142Icn5OxtXcPoHF8XaE0IBAAA&msaoauth2=true&instance_aware=true&lc=3082")
            }
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Tarjeta Microsoft Teams (Descarga / Enlace móvil seguro)
        MicrosoftPortalCard(
            title = "Microsoft Teams (Clases Virtuales)",
            subtitle = "Descargar / Abrir Aplicación",
            description = "Enlace oficial para unirte a tus clases en vivo y reuniones académicas.",
            gradientColors = listOf(MicrosoftRed, MicrosoftYellow, MicrosoftGreen, MicrosoftBlue),
            onClick = {
                abrirEnlace("https://play.google.com/store/apps/details?id=com.microsoft.teams")
            }
        )

        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Composable
fun MicrosoftPortalCard(
    title: String,
    subtitle: String,
    description: String,
    gradientColors: List<Color>,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .width(8.dp)
                    .fillMaxHeight()
                    .background(Brush.verticalGradient(gradientColors))
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = MicrosoftBlue
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = subtitle,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = description,
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    lineHeight = 16.sp
                )
            }
        }
    }
}
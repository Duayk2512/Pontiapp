package com.pontificia.app.ui.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pontificia.app.R
import com.pontificia.app.ui.components.AnimatedBackground
import com.pontificia.app.ui.components.PortalCard
import com.pontificia.app.ui.theme.*

@Composable
fun MainPortalScreen() {
    val context = LocalContext.current
    val scrollState = rememberScrollState()

    fun abrirEnlace(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        context.startActivity(intent)
    }

    Box(modifier = Modifier.fillMaxSize()) {
        // Fondo animado sutil
        AnimatedBackground()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            // Logo institucional oficial
            Image(
                painter = painterResource(id = R.drawable.logo_pontificia),
                contentDescription = "Logo La Pontificia",
                modifier = Modifier
                    .size(100.dp)
                    .padding(bottom = 12.dp)
            )

            Text(
                text = "Portal Institucional",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Seleccione su acceso a La Pontificia",
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 24.dp)
            )

            // ================= 1. INSTITUTO LA PONTIFICIA (ILP) =================
            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = ILPBlue, fontWeight = FontWeight.Bold)) {
                        append("Instituto La Pontificia (ILP)")
                    }
                },
                fontSize = 16.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                textAlign = TextAlign.Start
            )

            PortalCard(
                title = "Plataforma principal ILP",
                subtitle = "Acceso general a la información y comunicados ILP",
                accentColor = ILPBlue,
                onClick = { abrirEnlace("https://www.ilp.edu.pe") }
            )

            Spacer(modifier = Modifier.height(10.dp))

            PortalCard(
                title = "Iniciar Sesión (Login)",
                subtitle = "Acceso directo con credenciales institucionales ILP",
                accentColor = ILPBlue,
                onClick = { abrirEnlace("https://aulavirtual.ilp.edu.pe/login/index.php") }
            )

            Spacer(modifier = Modifier.height(24.dp))

            // ================= 2. ESCUELA LA PONTIFICIA (ELP) =================
            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = ELPDarkBlue, fontWeight = FontWeight.Bold)) {
                        append("Escuela La Pontificia (")
                    }
                    withStyle(style = SpanStyle(color = ELPRed, fontWeight = FontWeight.Bold)) {
                        append("E")
                    }
                    withStyle(style = SpanStyle(color = ELPBlue, fontWeight = FontWeight.Bold)) {
                        append("L")
                    }
                    withStyle(style = SpanStyle(color = ELPYellow, fontWeight = FontWeight.Bold)) {
                        append("P")
                    }
                    withStyle(style = SpanStyle(color = ELPDarkBlue, fontWeight = FontWeight.Bold)) {
                        append(")")
                    }
                },
                fontSize = 16.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                textAlign = TextAlign.Start
            )

            PortalCard(
                title = "Plataforma principal ELP",
                subtitle = "Acceso general a la información y comunicados ELP",
                accentColor = ELPRed,
                onClick = { abrirEnlace("https://www.elp.edu.pe") }
            )

            Spacer(modifier = Modifier.height(10.dp))

            PortalCard(
                title = "Iniciar Sesión (Login)",
                subtitle = "Acceso directo con credenciales institucionales ELP",
                accentColor = ELPYellow,
                onClick = { abrirEnlace("https://aulavirtual.elp.edu.pe/login/index.php") }
            )

            Spacer(modifier = Modifier.height(24.dp))

            // ================= 3. CENTRO DE IDIOMAS LA PONTIFICIA =================
            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = IdiomasPurple, fontWeight = FontWeight.Bold)) {
                        append("Centro de Idiomas La Pontificia")
                    }
                },
                fontSize = 16.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                textAlign = TextAlign.Start
            )

            PortalCard(
                title = "Plataforma Centro de Idiomas",
                subtitle = "Matrículas, cursos de inglés, evaluaciones y herramientas",
                accentColor = IdiomasPurple,
                onClick = { abrirEnlace("https://www.idiomaslp.edu.pe") }
            )

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}
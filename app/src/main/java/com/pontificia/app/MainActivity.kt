package com.pontificia.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.pontificia.app.ui.components.AnimatedBackground
import com.pontificia.app.ui.detail.InstitutionDetailScreen
import com.pontificia.app.ui.selection.InstitutionSelectionScreen
import com.pontificia.app.ui.selection.InstitutionType
import com.pontificia.app.ui.splash.SplashScreen
import com.pontificia.app.ui.theme.PontificiaAppTheme

sealed class AppScreen {
    object Splash : AppScreen()
    object Selection : AppScreen()
    data class Detail(val institution: InstitutionType) : AppScreen()
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PontificiaAppTheme {
                var currentScreen by remember { mutableStateOf<AppScreen>(AppScreen.Splash) }

                Box(modifier = Modifier.fillMaxSize()) {
                    AnimatedBackground()

                    when (val screen = currentScreen) {
                        is AppScreen.Splash -> {
                            SplashScreen(onSplashFinished = {
                                currentScreen = AppScreen.Selection
                            })
                        }
                        is AppScreen.Selection -> {
                            InstitutionSelectionScreen(
                                onSelect = { institution ->
                                    currentScreen = AppScreen.Detail(institution)
                                }
                            )
                        }
                        is AppScreen.Detail -> {
                            InstitutionDetailScreen(
                                institution = screen.institution,
                                onBack = {
                                    currentScreen = AppScreen.Selection
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}
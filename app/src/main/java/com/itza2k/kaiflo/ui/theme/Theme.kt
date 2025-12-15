package com.itza2k.kaiflo.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = BrandBlue,
    onPrimary = Color.White,
    secondary = BrandBlue,
    onSecondary = Color.White,
    tertiary = BrandBlue,
    onTertiary = Color.White,
    background = Color(0xFF0E1220),
    onBackground = BrandCream,
    surface = Color(0xFF0E1220),
    onSurface = BrandCream
)

private val LightColorScheme = lightColorScheme(
    primary = BrandBlue,
    onPrimary = Color.White,
    secondary = BrandBlue,
    onSecondary = Color.White,
    tertiary = BrandBlue,
    onTertiary = Color.White,
    background = BrandCream,
    onBackground = Color(0xFF111111),
    surface = BrandCream,
    onSurface = Color(0xFF111111)
)

@Composable
fun KaifloTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Force brand colors by default; allow opt-in dynamic colors if explicitly requested
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

// Backward compatibility wrapper expected by ChatScreen
@Composable
fun AssistantTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    KaifloTheme(darkTheme = darkTheme, dynamicColor = dynamicColor, content = content)
}
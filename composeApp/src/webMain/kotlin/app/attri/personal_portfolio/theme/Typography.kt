package app.attri.personal_portfolio.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// In a real multiplatform project, you would set up font resources.
// For web, we can just refer to the names we imported in index.html.

val AppTypography = Typography(
    headlineMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W600,
        fontSize = 32.sp,
        lineHeight = (32 * 1.3).sp
    ),
    bodyMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W400,
        fontSize = 16.sp,
        lineHeight = (16 * 1.6).sp
    ),
)
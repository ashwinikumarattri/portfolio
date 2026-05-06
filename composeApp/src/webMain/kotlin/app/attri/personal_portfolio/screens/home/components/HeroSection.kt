package app.attri.personal_portfolio.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.attri.personal_portfolio.theme.OnSurface
import app.attri.personal_portfolio.theme.OnSurfaceVariant
import app.attri.personal_portfolio.theme.Primary
import org.jetbrains.compose.resources.painterResource
import personal_portfolio.composeapp.generated.resources.Res
import personal_portfolio.composeapp.generated.resources.kmp

@Composable
fun HeroSection(onTechStackClick: () -> Unit) {
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Column(modifier = Modifier.weight(1f)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier.size(10.dp)
                        .background(Color(0xFF4cd7f6), RoundedCornerShape(50))
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("AVAILABLE FOR PROJECTS", color = Color(0xFF4cd7f6), fontSize = 14.sp)
            }

            Spacer(modifier = Modifier.height(16.dp))

            val gradient = Brush.linearGradient(listOf(Color(0xFF4cd7f6), Color(0xFFc0c1ff)))
            val annotatedString = buildAnnotatedString {
                append("Crafting ")
                withStyle(style = SpanStyle(brush = gradient)) {
                    append("Seamless")
                }
                append(" Experiences Across All Platforms")
            }
            Text(
                text = annotatedString,
                fontSize = 52.sp,
                fontWeight = FontWeight.Bold,
                color = OnSurface,
                lineHeight = 64.sp
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                "Specializing in Compose Multiplatform to build high-performance, native-quality applications for iOS, Android, Desktop, and Web from a single codebase.",
                color = OnSurfaceVariant,
                fontSize = 18.sp,
                lineHeight = 28.sp
            )

            Spacer(modifier = Modifier.height(32.dp))

            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                Button(
                    onClick = { println("View My Work clicked") },
                    colors = ButtonDefaults.buttonColors(containerColor = Primary)
                ) {
                    Text("View My Work", modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp))
                }
                OutlinedButton(
                    onClick = onTechStackClick,
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = OnSurfaceVariant),
                ) {
                    Text("Technical Stack", modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp))
                }
            }

            Spacer(modifier = Modifier.height(48.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                // Placeholder for social icons
                Text("f", color = OnSurfaceVariant, modifier = Modifier.clickable { println("Facebook clicked") })
                Spacer(Modifier.width(16.dp))
                Text("in", color = OnSurfaceVariant, modifier = Modifier.clickable { println("LinkedIn clicked") })
                Spacer(Modifier.width(16.dp))
                Text("X", color = OnSurfaceVariant, modifier = Modifier.clickable { println("X clicked") })

                Spacer(Modifier.weight(1f))

                Text("4+ Years Multiplatform Expertise", color = OnSurfaceVariant)
            }

        }

        Spacer(modifier = Modifier.width(60.dp))

        // Image
        Column(
            modifier = Modifier.weight(0.8f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(Res.drawable.kmp),
                contentDescription = "Compose Multiplatform",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(24.dp))
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                "Compose Multiplatform",
                color = OnSurfaceVariant,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
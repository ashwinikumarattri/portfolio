package app.attri.personal_portfolio.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Work
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.attri.personal_portfolio.theme.*
import org.jetbrains.compose.resources.painterResource
import personal_portfolio.composeapp.generated.resources.Exposed_icon
import personal_portfolio.composeapp.generated.resources.Kotlin_icon
import personal_portfolio.composeapp.generated.resources.Res
import personal_portfolio.composeapp.generated.resources.home_24
import personal_portfolio.composeapp.generated.resources.kmp

@Composable
fun HomeScreen() {
    Row(modifier = Modifier.fillMaxSize()) {
        SideNavBar(modifier = Modifier.fillMaxHeight().width(300.dp))
        MainContent(modifier = Modifier.fillMaxSize())
    }
}

@Composable
fun SideNavBar(modifier: Modifier = Modifier) {
    var selectedItem by remember { mutableStateOf("Home") }

    Column(
        modifier = modifier
            .background(SurfaceContainerLow)
            .padding(horizontal = 24.dp, vertical = 40.dp),
    ) {
        Column {
            Text(
                text = "KMP",
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                ),
                color = OnSurface
            )
            Text(
                text = "Developer",
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontSize = 32.sp,
                ),
                color = OnSurface
            )
        }
        Text(
            text = "Multiplatform Specialist",
            style = MaterialTheme.typography.bodyMedium,
            color = OnSurfaceVariant,
            modifier = Modifier.padding(top = 4.dp)
        )

        Spacer(modifier = Modifier.height(48.dp))

        // Navigation
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            NavItem(
                text = "Home",
                icon = Icons.Default.Home,
                selected = selectedItem == "Home",
                onClick = { selectedItem = "Home" }
            )
            NavItem(
                text = "Work",
                icon = Icons.Default.Work,
                selected = selectedItem == "Work",
                onClick = { selectedItem = "Work" }
            )
            NavItem(
                text = "Skills",
                icon = Icons.Default.Code,
                selected = selectedItem == "Skills",
                onClick = { selectedItem = "Skills" }
            )
            NavItem(
                text = "Connect",
                icon = Icons.Default.Email,
                selected = selectedItem == "Connect",
                onClick = { selectedItem = "Connect" }
            )
        }


        Spacer(modifier = Modifier.weight(1f))

        OutlinedButton(
            onClick = { println("View Resume clicked") },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Primary),
        ) {
            Text("View Resume", modifier = Modifier.padding(8.dp))
        }
    }
}

@Composable
fun NavItem(text: String, icon: ImageVector, selected: Boolean, onClick: () -> Unit) {
    val backgroundColor = if (selected) Primary else Color.Transparent
    val contentColor = if (selected) OnPrimary else OnSurfaceVariant

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(backgroundColor)
            .clickable(onClick = onClick)
            .padding(12.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = text,
            tint = contentColor
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = text,
            color = contentColor,
            fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal
        )
    }
}


@Composable
fun MainContent(modifier: Modifier = Modifier) {
    Column(modifier = modifier.background(Surface).padding(40.dp)) {
        // Top App Bar
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("DevPortfolio", color = OnSurface, fontWeight = FontWeight.Bold)
            Row(horizontalArrangement = Arrangement.spacedBy(24.dp)) {
                Text("Hero", color = OnSurface, modifier = Modifier.clickable { println("Hero clicked") })
                Text("Projects", color = OnSurfaceVariant, modifier = Modifier.clickable { println("Projects clicked") })
                Text("Experience", color = OnSurfaceVariant, modifier = Modifier.clickable { println("Experience clicked") })
                Text("Stack", color = OnSurfaceVariant, modifier = Modifier.clickable { println("Stack clicked") })
            }
            Button(
                onClick = { println("Get in touch clicked") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Primary,
                    contentColor = OnPrimary
                )
            ) {
                Text("Get in touch")
            }
        }

        Spacer(modifier = Modifier.height(80.dp))

        // Hero Section
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
                        onClick = { println("Technical Stack clicked") },
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

            // Image placeholder
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
}
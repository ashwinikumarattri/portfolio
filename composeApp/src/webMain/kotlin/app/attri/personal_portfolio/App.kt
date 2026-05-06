package app.attri.personal_portfolio

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.shape.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

private val LightColors = lightColorScheme(
    primary = Color(0xFF2563EB),
    secondary = Color(0xFF10B981),
    background = Color(0xFFF8FAFC),
    surface = Color.White,
    onPrimary = Color.White,
    onBackground = Color(0xFF0F172A),
    onSurface = Color(0xFF1E293B),
    primaryContainer = Color(0xFFDBEAFE),
    onPrimaryContainer = Color(0xFF1E40AF),
)

private val DarkColors = darkColorScheme(
    primary = Color(0xFF60A5FA),
    secondary = Color(0xFF34D399),
    background = Color(0xFF0F172A),
    surface = Color(0xFF1E293B),
    onPrimary = Color(0xFF0F172A),
    onBackground = Color(0xFFF1F5F9),
    onSurface = Color(0xFFE2E8F0),
    primaryContainer = Color(0xFF1E40AF),
    onPrimaryContainer = Color(0xFFDBEAFE),
)

@Composable
fun App() {
    var isDarkMode by remember { mutableStateOf(false) }
    val systemDark = isSystemInDarkTheme()
    var useSystemTheme by remember { mutableStateOf(true) }
    val isDark = if (useSystemTheme) systemDark else isDarkMode

    MaterialTheme(colorScheme = if (isDark) DarkColors else LightColors) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
        ) {
            PortfolioPage(
                isDark = isDark,
                onToggleTheme = {
                    useSystemTheme = false
                    isDarkMode = !isDark
                },
            )
        }
    }
}

@Composable
private fun PortfolioPage(
    isDark: Boolean,
    onToggleTheme: () -> Unit,
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Header(
            isDark = isDark,
            onToggleTheme = onToggleTheme,
            onNavClick = { section ->
                println("Navigating to $section")
            }
        )

        HeroSection()
        AboutSection()
        ServicesSection()
        PortfolioSection()
        ContactSection()
        Footer()
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun Header(
    isDark: Boolean,
    onToggleTheme: () -> Unit,
    onNavClick: (String) -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.surface.copy(alpha = 0.9f),
        shadowElevation = 4.dp,
    ) {
        FlowRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            itemVerticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "ASHWINI KUMAR ATTRI",
                fontSize = 22.sp,
                fontWeight = FontWeight.Black,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(end = 32.dp)
            )
            
            val navItems = listOf("Home", "About", "Services", "Portfolio", "Contact")
            navItems.forEach { item ->
                TextButton(onClick = { onNavClick(item) }) {
                    Text(
                        text = item,
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }
            
            Spacer(modifier = Modifier.width(16.dp))

            IconButton(onClick = onToggleTheme) {
                Icon(
                    imageVector = if (isDark) Icons.Default.LightMode else Icons.Default.DarkMode,
                    contentDescription = "Toggle Theme",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

@Composable
private fun HeroSection() {
    Section {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(48.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
                modifier = Modifier.weight(1.2f),
                verticalArrangement = Arrangement.spacedBy(20.dp),
            ) {
                Surface(
                    color = MaterialTheme.colorScheme.primaryContainer,
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text(
                        text = "Senior Mobile App Developer",
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                }
                
                Text(
                    text = "Building High-Performance Mobile & Cross-Platform Experiences",
                    fontSize = 48.sp,
                    lineHeight = 56.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = MaterialTheme.colorScheme.onBackground,
                )
                
                Text(
                    text = "Senior Mobile App Developer with 6+ years of experience, specializing in React Native (5+ years) and Native Android (Kotlin/Java). Passionate about clean architecture and performance optimization.",
                    fontSize = 20.sp,
                    lineHeight = 32.sp,
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f),
                )
                
                Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                    Button(
                        onClick = { },
                        shape = RoundedCornerShape(12.dp),
                        contentPadding = PaddingValues(horizontal = 24.dp, vertical = 12.dp)
                    ) {
                        Text("View My Work", fontSize = 16.sp)
                    }
                    OutlinedButton(
                        onClick = { },
                        shape = RoundedCornerShape(12.dp),
                        contentPadding = PaddingValues(horizontal = 24.dp, vertical = 12.dp)
                    ) {
                        Text("Contact Me", fontSize = 16.sp)
                    }
                }
            }
            
            Box(modifier = Modifier.weight(0.8f), contentAlignment = Alignment.Center) {
                AnimatedProfileCard()
            }
        }
    }
}

@Composable
private fun AnimatedProfileCard() {
    val infiniteTransition = rememberInfiniteTransition()
    val rotation by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(10000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    Box(
        modifier = Modifier
            .size(320.dp)
            .padding(20.dp),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(CircleShape)
                .background(
                    Brush.sweepGradient(
                        listOf(
                            MaterialTheme.colorScheme.primary,
                            MaterialTheme.colorScheme.secondary,
                            MaterialTheme.colorScheme.primary
                        )
                    )
                )
        )
        
        Box(
            modifier = Modifier
                .size(260.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.surface)
                .padding(10.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "AKA",
                    fontSize = 64.sp,
                    fontWeight = FontWeight.Black,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = "Ashwini",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                )
            }
        }
    }
}

@Composable
private fun AboutSection() {
    Section(title = "About Me") {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(40.dp)
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "I am a Senior Mobile App Developer with a strong foundation in React Native and Android development. With over 6 years of experience, I've delivered major features for applications used by millions of users.",
                    fontSize = 18.sp,
                    lineHeight = 30.sp,
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.8f)
                )
                Spacer(Modifier.height(24.dp))
                Text(
                    text = "Currently working at Accenture as a Custom Software Engineer Sr. Analyst, where I focus on large-scale enterprise mobile applications and offline-first architecture.",
                    fontSize = 18.sp,
                    lineHeight = 30.sp,
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.8f)
                )
            }
            
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Technical Skills",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(Modifier.height(16.dp))
                SkillGrid()
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun SkillGrid() {
    val skills = listOf(
        "React Native" to Color(0xFF61DAFB),
        "Kotlin" to Color(0xFF7F52FF),
        "Java" to Color(0xFFED8B00),
        "Swift" to Color(0xFFFA7343),
        "TypeScript" to Color(0xFF3178C6),
        "Firebase" to Color(0xFFFFCA28),
        "Jetpack Compose" to Color(0xFF4285F4),
        "MVVM" to Color(0xFF34D399)
    )
    
    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        skills.forEach { skill ->
            val name = skill.first
            val color = skill.second
            Surface(
                color = color.copy(alpha = 0.15f),
                border = BorderStroke(1.dp, color.copy(alpha = 0.3f)),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = name,
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                    color = color,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun ServicesSection() {
    Section(title = "Services") {
        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(24.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp),
        ) {
            val services = listOf(
                "Mobile App Development" to "High-performance native and cross-platform apps for iOS and Android.",
                "Offline-First Architecture" to "Robust synchronization and caching strategies for low-connectivity environments.",
                "UI/UX Implementation" to "Building polished, responsive, and accessible user interfaces from design specs.",
                "Performance Optimization" to "Deep profiling and optimization for smooth rendering and fast load times."
            )
            
            services.forEach { service ->
                ServiceCard(service.first, service.second)
            }
        }
    }
}

@Composable
private fun ServiceCard(title: String, description: String) {
    Card(
        modifier = Modifier.widthIn(max = 300.dp).height(220.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = RoundedCornerShape(16.dp),
    ) {
        Column(
            modifier = Modifier.padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text("🚀", fontSize = 24.sp)
            Text(
                text = title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = description,
                fontSize = 15.sp,
                lineHeight = 22.sp,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
            )
        }
    }
}

@Composable
private fun PortfolioSection() {
    Section(title = "Featured Projects") {
        Column(verticalArrangement = Arrangement.spacedBy(32.dp)) {
            ProjectItem(
                title = "BLO App – Election Commission of India",
                tech = "React Native | TypeScript | Kotlin | Firebase",
                description = "Core module development for a nationwide app used by 1M+ Booth Level Officers. Built secure login, offline-first workflows, and real-time background sync.",
                role = "Lead Developer for core modules"
            )
            ProjectItem(
                title = "ERONET App – Voter Database Management",
                tech = "Android (Kotlin/Java)",
                description = "High-performance workflows for voter data management. Optimized RecyclerView performance and reduced loading times on low-end devices.",
                role = "Android Developer"
            )
            ProjectItem(
                title = "Vodafone Field Technician App",
                tech = "Ionic React | TypeScript",
                description = "Enterprise mobile application used by ground technicians for field operations and diagnostics. Focused on performance and offline responsiveness.",
                role = "Sr. Analyst / Developer"
            )
        }
    }
}

@Composable
private fun ProjectItem(title: String, tech: String, description: String, role: String) {
    Surface(
        color = MaterialTheme.colorScheme.surface,
        shape = RoundedCornerShape(20.dp),
        shadowElevation = 2.dp,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(32.dp),
            horizontalArrangement = Arrangement.spacedBy(32.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(MaterialTheme.colorScheme.primaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Text("💻", fontSize = 32.sp)
            }
            
            Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(
                    text = tech,
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = title,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = description,
                    fontSize = 16.sp,
                    lineHeight = 26.sp,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
                )
                Text(
                    text = "Role: $role",
                    fontSize = 14.sp,
                    fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                )
            }
        }
    }
}

@Composable
private fun ContactSection() {
    Section(title = "Get In Touch") {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(48.dp)
        ) {
            Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(24.dp)) {
                Text(
                    text = "Let's collaborate on your next project. Whether you have a question or just want to say hi, I'll try my best to get back to you!",
                    fontSize = 18.sp,
                    lineHeight = 30.sp,
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.8f)
                )
                
                ContactInfoItem("📧", "ashwini.kumar.attri@gmail.com")
                ContactInfoItem("📞", "+91-8860555533")
                ContactInfoItem("📍", "Delhi, India")
            }
            
            Card(
                modifier = Modifier.weight(1f),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                shape = RoundedCornerShape(24.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(
                    modifier = Modifier.padding(32.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    var name by remember { mutableStateOf("") }
                    var email by remember { mutableStateOf("") }
                    var message by remember { mutableStateOf("") }
                    
                    OutlinedTextField(
                        value = name,
                        onValueChange = { name = it },
                        label = { Text("Name") },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp)
                    )
                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text("Email") },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp)
                    )
                    OutlinedTextField(
                        value = message,
                        onValueChange = { message = it },
                        label = { Text("Message") },
                        modifier = Modifier.fillMaxWidth(),
                        minLines = 4,
                        shape = RoundedCornerShape(12.dp)
                    )
                    Button(
                        onClick = { },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp),
                        contentPadding = PaddingValues(16.dp)
                    ) {
                        Text("Send Message", fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}

@Composable
private fun ContactInfoItem(icon: String, text: String) {
    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(16.dp)) {
        Surface(
            color = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f),
            shape = CircleShape,
            modifier = Modifier.size(48.dp)
        ) {
            Box(contentAlignment = Alignment.Center) {
                Text(icon, fontSize = 20.sp)
            }
        }
        Text(text = text, fontSize = 16.sp, fontWeight = FontWeight.Medium)
    }
}

@Composable
private fun Section(
    title: String? = null,
    content: @Composable ColumnScope.() -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .widthIn(max = 1100.dp)
            .padding(horizontal = 24.dp, vertical = 64.dp),
    ) {
        if (title != null) {
            Text(
                text = title,
                fontSize = 36.sp,
                fontWeight = FontWeight.Black,
                color = MaterialTheme.colorScheme.onBackground,
            )
            Spacer(Modifier.height(40.dp))
        }
        content()
    }
}

@Composable
private fun Footer() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface)
            .padding(vertical = 48.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Text(
            text = "ASHWINI KUMAR ATTRI",
            fontWeight = FontWeight.Black,
            fontSize = 20.sp,
            color = MaterialTheme.colorScheme.primary,
        )
        Text(
            text = "© 2026 Portfolio. Built with Compose Multiplatform.",
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
        )
        Row(horizontalArrangement = Arrangement.spacedBy(24.dp)) {
            Text("Linkedin", color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold)
            Text("GitHub", color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold)
        }
    }
}

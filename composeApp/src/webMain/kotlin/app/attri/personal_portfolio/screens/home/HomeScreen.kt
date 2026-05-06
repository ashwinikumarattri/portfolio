package app.attri.personal_portfolio.screens.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Work
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.attri.personal_portfolio.screens.home.components.HeroSection
import app.attri.personal_portfolio.screens.home.components.HomeTopAppBar
import app.attri.personal_portfolio.screens.home.components.NavItem
import app.attri.personal_portfolio.screens.home.components.TechStackDialog
import app.attri.personal_portfolio.theme.*

@Composable
fun HomeScreen() {
    BoxWithConstraints {
        val maxWidth = this.maxWidth
        val isMobile = maxWidth < 840.dp // Breakpoint for mobile

        if (isMobile) {
            MobileLayout()
        } else {
            DesktopLayout()
        }
    }
}

@Composable
fun DesktopLayout() {
    Row(modifier = Modifier.fillMaxSize()) {
        SideNavBar(
            isMobile = false,
            onCloseClick = {}
        )
        MainContent(
            isMobile = false,
            onMenuClick = {}
        )
    }
}

@Composable
fun MobileLayout() {
    var isDrawerOpen by remember { mutableStateOf(false) }
    Box(modifier = Modifier.fillMaxSize()) {
        MainContent(
            modifier = Modifier.fillMaxSize(),
            isMobile = true,
            onMenuClick = { isDrawerOpen = true }
        )
        AnimatedVisibility(
            visible = isDrawerOpen,
            enter = slideInHorizontally(animationSpec = tween(durationMillis = 300)) { fullWidth -> -fullWidth },
            exit = slideOutHorizontally(animationSpec = tween(durationMillis = 300)) { fullWidth -> -fullWidth }
        ) {
            SideNavBar(
                isMobile = true,
                onCloseClick = { isDrawerOpen = false }
            )
        }
    }
}


@Composable
fun SideNavBar(
    isMobile: Boolean,
    onCloseClick: () -> Unit
) {
    var selectedItem by remember { mutableStateOf("Home") }

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .width(300.dp)
            .background(SurfaceContainerLow)
            .padding(horizontal = 24.dp, vertical = 40.dp),
    ) {
        if (isMobile) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                IconButton(onClick = onCloseClick) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Close Navigation",
                        tint = OnSurface
                    )
                }
            }
        }
        Column {
            Text(
                text = "KMP",
                style = MaterialTheme.typography.headlineMedium.copy(fontSize = 32.sp, fontWeight = FontWeight.Bold),
                color = OnSurface
            )
            Text(
                text = "Developer",
                style = MaterialTheme.typography.headlineMedium.copy(fontSize = 32.sp),
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
        ) {
            Text("View Resume", modifier = Modifier.padding(8.dp), color = Primary)
        }
    }
}


@Composable
fun MainContent(
    modifier: Modifier = Modifier,
    isMobile: Boolean,
    onMenuClick: () -> Unit
) {
    var showTechStackDialog by remember { mutableStateOf(false) }

    if (showTechStackDialog) {
        TechStackDialog(onDismissRequest = { showTechStackDialog = false })
    }

    Column(modifier = modifier.background(Surface).padding(40.dp)) {
        HomeTopAppBar(
            navigationIcon = {
                if (isMobile) {
                    IconButton(onClick = onMenuClick) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Menu",
                            tint = OnSurface
                        )
                    }
                }
            }
        )

        Spacer(modifier = Modifier.height(80.dp))

        HeroSection(onTechStackClick = { showTechStackDialog = true })
    }
}
package app.attri.personal_portfolio.screens.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import app.attri.personal_portfolio.theme.OnPrimary
import app.attri.personal_portfolio.theme.OnSurface
import app.attri.personal_portfolio.theme.OnSurfaceVariant
import app.attri.personal_portfolio.theme.Primary

@Composable
fun HomeTopAppBar(navigationIcon: @Composable () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            navigationIcon()
            Text("DevPortfolio", color = OnSurface, fontWeight = FontWeight.Bold)
        }

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
}
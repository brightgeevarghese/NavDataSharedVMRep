package edu.miu.navdatatranssharedvmr.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import edu.miu.navdatatranssharedvmr.ui.viewModel.SharedViewModel

@Composable
fun ProgramsScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    sharedViewModel: SharedViewModel
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        Text(text = "Programs Offered at MIU")
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "1. Computer Science",
            modifier = Modifier.clickable {
                sharedViewModel.getProgramDetails(1)
                navController.navigate("computerScienceScreen")
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "2. Business Administration",
            modifier = Modifier.clickable {
                sharedViewModel.getProgramDetails(2)
                navController.navigate("businessAdministrationScreen")
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.popBackStack() }) {
            Text(text = "Back to Home")
        }
    }
}
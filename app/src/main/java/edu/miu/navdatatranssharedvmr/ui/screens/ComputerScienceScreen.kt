package edu.miu.navdatatranssharedvmr.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import edu.miu.navdatatranssharedvmr.ui.viewModel.SharedViewModel

@Composable
fun ComputerScienceScreen(navController: NavController, modifier: Modifier = Modifier, sharedViewModel: SharedViewModel) {
    val programDetailsUIState by sharedViewModel.programDetailsUiState.collectAsState()

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (programDetailsUIState.isError) {
            Text(text = "Error loading program details")
        } else {
            Text(text = programDetailsUIState.programName)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = programDetailsUIState.programDescription)
        }
        Button(onClick = { navController.popBackStack() }) {
            Text(text = "Back to Programs")
        }
        Button(onClick = { navController.popBackStack(destinationId = navController.graph.startDestinationId, inclusive = false) }) {
            Text(text = "Go Home")
        }
    }
}
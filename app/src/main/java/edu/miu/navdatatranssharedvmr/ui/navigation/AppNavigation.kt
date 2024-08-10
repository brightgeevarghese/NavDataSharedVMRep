package edu.miu.navdatatranssharedvmr.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import edu.miu.navdatatranssharedvmr.ui.components.TopBar
import edu.miu.navdatatranssharedvmr.ui.screens.BusinessAdministrationScreen
import edu.miu.navdatatranssharedvmr.ui.screens.ComputerScienceScreen
import edu.miu.navdatatranssharedvmr.ui.screens.HomeScreen
import edu.miu.navdatatranssharedvmr.ui.screens.ProgramsScreen
import edu.miu.navdatatranssharedvmr.ui.viewModel.SharedViewModel

@Composable
fun AppNavigation(sharedViewModel: SharedViewModel) {
    val navHostController: NavHostController = rememberNavController()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopBar(navController = navHostController) }
    ) { innerPadding ->
        NavHost(navController = navHostController, startDestination = "homeScreen") {
            composable(route = "homeScreen") {
                HomeScreen(
                    navController = navHostController,
                    modifier = Modifier.padding(innerPadding),
                    sharedViewModel = sharedViewModel
                )
            }
            composable(route = "programsScreen") {
                ProgramsScreen(
                    navController = navHostController,
                    modifier = Modifier.padding(innerPadding),
                    sharedViewModel = sharedViewModel
                )
            }
            composable(route = "computerScienceScreen") {
                ComputerScienceScreen(
                    navController = navHostController,
                    modifier = Modifier.padding(innerPadding),
                    sharedViewModel = sharedViewModel
                )
            }
            composable(route = "businessAdministrationScreen") {
                BusinessAdministrationScreen(
                    navController = navHostController,
                    modifier = Modifier.padding(innerPadding),
                    sharedViewModel = sharedViewModel
                )
            }
        }
    }

}
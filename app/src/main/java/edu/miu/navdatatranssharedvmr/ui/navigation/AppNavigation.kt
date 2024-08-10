package edu.miu.navdatatranssharedvmr.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import edu.miu.navdatatranssharedvmr.ui.screens.BusinessAdministrationScreen
import edu.miu.navdatatranssharedvmr.ui.screens.ComputerScienceScreen
import edu.miu.navdatatranssharedvmr.ui.screens.HomeScreen
import edu.miu.navdatatranssharedvmr.ui.screens.ProgramsScreen
import edu.miu.navdatatranssharedvmr.ui.viewModel.SharedViewModel

@Composable
fun AppNavigation(
    navHostController: NavHostController,
    modifier: Modifier = Modifier,
    sharedViewModel: SharedViewModel
) {
    NavHost(navController = navHostController, startDestination = "homeScreen") {
        composable(route = "homeScreen") {
            HomeScreen(navController = navHostController, modifier = modifier, sharedViewModel = sharedViewModel)
        }
        composable(route = "programsScreen") {
            ProgramsScreen(navController = navHostController, modifier = modifier, sharedViewModel = sharedViewModel)
        }
        composable(route = "computerScienceScreen") {
            ComputerScienceScreen(navController = navHostController, modifier = modifier, sharedViewModel = sharedViewModel)
        }
        composable(route = "businessAdministrationScreen") {
            BusinessAdministrationScreen(navController = navHostController, modifier = modifier, sharedViewModel = sharedViewModel)
        }
    }
}
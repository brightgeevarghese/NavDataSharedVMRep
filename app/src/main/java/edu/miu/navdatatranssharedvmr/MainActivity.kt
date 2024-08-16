package edu.miu.navdatatranssharedvmr

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import edu.miu.navdatatranssharedvmr.ui.components.TopBar
import edu.miu.navdatatranssharedvmr.ui.navigation.AppNavigation
import edu.miu.navdatatranssharedvmr.ui.theme.NavDataTransSharedVMRTheme
import edu.miu.navdatatranssharedvmr.ui.viewModel.SharedViewModel
import androidx.hilt.navigation.compose.hiltViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavDataTransSharedVMRTheme {
                val sharedViewModel: SharedViewModel = hiltViewModel()
                val navHostController: NavHostController = rememberNavController()
                AppNavigation(navHostController = navHostController, sharedViewModel = sharedViewModel)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NavDataTransSharedVMRTheme {
    }
}
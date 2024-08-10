package edu.miu.navdatatranssharedvmr.ui.viewModel

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.components.SingletonComponent
import edu.miu.navdatatranssharedvmr.ui.components.TopBar
import edu.miu.navdatatranssharedvmr.ui.data.ProgramRepository
import edu.miu.navdatatranssharedvmr.ui.data.ProgramRepositoryImpl
import edu.miu.navdatatranssharedvmr.ui.navigation.AppNavigation
import edu.miu.navdatatranssharedvmr.ui.theme.NavDataTransSharedVMRTheme
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(
    private val repository: ProgramRepository
) : ViewModel() {
    private val _programDetailsUiState = MutableStateFlow(ProgramDetailsUIState())
    val programDetailsUiState = _programDetailsUiState.asStateFlow()

    fun getProgramDetails(programNumber: Int) {
        viewModelScope.launch {
            val programDetails = repository.getProgramDetails(programNumber)
            if (programDetails != null) {
                _programDetailsUiState.value = ProgramDetailsUIState(
                    programName = programDetails.programName,
                    programDescription = programDetails.programDescription
                )
            } else {
                _programDetailsUiState.value = ProgramDetailsUIState(
                    isError = true
                )
            }
        }
    }
}



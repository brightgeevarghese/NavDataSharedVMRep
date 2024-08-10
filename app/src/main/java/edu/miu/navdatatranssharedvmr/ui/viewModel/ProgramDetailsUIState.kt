package edu.miu.navdatatranssharedvmr.ui.viewModel

data class ProgramDetailsUIState(
    val programNumber: Int = 0,
    val programName: String = "",
    val programDescription: String = "",
    val isError: Boolean = false,
)

package edu.miu.navdatatranssharedvmr.ui.data

interface ProgramRepository {
    fun getProgramDetails(programNumber: Int): ProgramDetails?
}
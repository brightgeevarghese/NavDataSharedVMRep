package edu.miu.navdatatranssharedvmr.ui.data

import javax.inject.Inject


class ProgramRepositoryImpl @Inject constructor() : ProgramRepository {

    private val programDetails = mutableListOf(
        ProgramDetails(1, "Computer Science", "Computer Science Description"),
        ProgramDetails(2, "Business Administration", "Business Administration Description")
    )

    override fun getProgramDetails(programNumber: Int): ProgramDetails? {
        return programDetails.find { it.programNumber == programNumber }
    }
}
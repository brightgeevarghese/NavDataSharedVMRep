package edu.miu.navdatatranssharedvmr.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import edu.miu.navdatatranssharedvmr.ui.data.ProgramRepository
import edu.miu.navdatatranssharedvmr.ui.data.ProgramRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
object ProgramRepositoryModule {
    @Provides
    fun provideProgramRepository(): ProgramRepository {
        return ProgramRepositoryImpl()
    }
}
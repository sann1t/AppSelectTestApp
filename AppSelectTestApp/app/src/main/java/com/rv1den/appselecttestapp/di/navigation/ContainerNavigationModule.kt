package com.rv1den.appselecttestapp.di.navigation

import com.rv1den.appselecttestapp.navigation.container.ScreenContainerCoordinator
import com.rv1den.appselecttestapp.navigation.container.ScreenContainerMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ContainerNavigationModule {

    @Provides
    @Singleton
    fun provideScreenContainerMapper() = ScreenContainerMapper()

    @Provides
    @Singleton
    fun provideScreenContainerCoordinator(
        mapper: ScreenContainerMapper
    ) = ScreenContainerCoordinator(mapper)
}
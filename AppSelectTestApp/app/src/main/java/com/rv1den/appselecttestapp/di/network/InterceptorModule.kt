package com.rv1den.appselecttestapp.di.network

import com.rv1den.appselecttestapp.di.network.interceptor.KeyInterceptor
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface InterceptorModule {

    @Binds
    @Singleton
    fun bindKeyInterceptor(keyInterceptor: KeyInterceptor): Interceptor
}
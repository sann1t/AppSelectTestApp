package com.rv1den.appselecttestapp.di.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.rv1den.appselecttestapp.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@OptIn(kotlinx.serialization.ExperimentalSerializationApi::class)
@InstallIn(SingletonComponent::class)
interface NetworkModule {

    companion object {
        @Provides
        @Singleton
        fun provideRetrofit(
            converter: Converter.Factory,
            client: OkHttpClient
        ): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(client)
                .addConverterFactory(converter)
                .build()
        }

        @Provides
        @Singleton
        fun provideOkHttpClient(
            interceptor: Interceptor
        ) : OkHttpClient {
            return OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()
        }

        @Provides
        @Singleton
        fun provideKotlinxSerialization(): Converter.Factory {
            val json = Json {
                isLenient = true
                ignoreUnknownKeys = true
            }
            val contentType = "application/json".toMediaType()
            return json.asConverterFactory(contentType)
        }
    }
}
package com.jmb.marvelapp.di

import android.app.Application
import com.jmb.marvelapp.AndroidCheckedInternet
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun permissionCheckerProvider(app: Application): AndroidCheckedInternet =
        AndroidCheckedInternet(app)
}
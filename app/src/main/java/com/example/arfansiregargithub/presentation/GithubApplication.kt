package com.example.arfansiregargithub.presentation

import android.app.Application
import com.example.arfansiregargithub.domain.utils.favoriteModule
import com.example.arfansiregargithub.domain.utils.searchModule
import com.example.arfansiregargithub.domain.utils.settingModule
import com.example.arfansiregargithub.domain.utils.userDetailModule
import com.example.arfansiregargithub.domain.utils.welcomeModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class GithubApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@GithubApplication)
            modules(
                searchModule,
                userDetailModule,
                favoriteModule,
                settingModule,
                welcomeModule
            )
        }
    }
}
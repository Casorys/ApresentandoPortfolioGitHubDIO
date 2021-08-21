package com.br.freitastiago.showcaseportfoliodio

import android.app.Application
import com.br.freitastiago.showcaseportfoliodio.data.di.DataModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
        }

        DataModule.load()

    }

}
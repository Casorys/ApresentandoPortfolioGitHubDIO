package com.br.freitastiago.showcaseportfoliodio

import android.app.Application
import android.app.Presentation
import com.br.freitastiago.showcaseportfoliodio.data.di.DataModule
import com.br.freitastiago.showcaseportfoliodio.domain.di.DomainModule
import com.br.freitastiago.showcaseportfoliodio.presentation.di.PresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
        }

        DataModule.load()
        DomainModule.load()
        PresentationModule.load()

    }

}
package com.br.freitastiago.showcaseportfoliodio.domain.di

import com.br.freitastiago.showcaseportfoliodio.data.di.DataModule
import com.br.freitastiago.showcaseportfoliodio.domain.ListUserRepositoriesUseCase
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module

object DomainModule {

    fun load() {
        loadKoinModules(useCaseModule())
    }

    private fun useCaseModule(): Module {
        return module {
            factory { ListUserRepositoriesUseCase(get()) }
        }
    }

}
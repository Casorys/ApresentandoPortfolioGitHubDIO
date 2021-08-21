package com.br.freitastiago.showcaseportfoliodio.domain

import com.br.freitastiago.showcaseportfoliodio.core.UseCase
import com.br.freitastiago.showcaseportfoliodio.data.model.Repo
import com.br.freitastiago.showcaseportfoliodio.data.repositories.RepoRepository
import kotlinx.coroutines.flow.Flow

class ListUserRepositoriesUseCase(
    private val repository: RepoRepository
    ) : UseCase<String, List<Repo>>() {

    override suspend fun execute(param: String): Flow<List<Repo>> {
        return repository.listRepositories(param)
    }
}
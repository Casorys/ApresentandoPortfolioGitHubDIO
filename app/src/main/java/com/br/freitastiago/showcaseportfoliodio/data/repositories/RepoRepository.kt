package com.br.freitastiago.showcaseportfoliodio.data.repositories

import com.br.freitastiago.showcaseportfoliodio.data.model.Repo
import kotlinx.coroutines.flow.Flow

interface RepoRepository {
    suspend fun listRepositories(user: String): Flow<List<Repo>>
}
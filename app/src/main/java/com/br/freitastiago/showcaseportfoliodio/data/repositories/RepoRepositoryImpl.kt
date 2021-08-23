package com.br.freitastiago.showcaseportfoliodio.data.repositories


import com.br.freitastiago.showcaseportfoliodio.core.RemoteException
import com.br.freitastiago.showcaseportfoliodio.data.services.GitHubService
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class RepoRepositoryImpl(private val service: GitHubService) : RepoRepository {

    override suspend fun listRepositories(user: String) = flow {
        try {
            val repoList = service.listRepositories(user)
            emit(repoList)
        } catch(ex: HttpException) {
            throw RemoteException(ex.message ?: "Não foi possível fazer a busca no momento, tente novamente mais tarde.")
        }
    }
}
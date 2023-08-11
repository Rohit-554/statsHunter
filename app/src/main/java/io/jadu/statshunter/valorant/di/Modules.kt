package io.jadu.statshunter.valorant.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.jadu.statshunter.valorant.core.constants.Constants
import io.jadu.statshunter.valorant.data.data_source.remote.ValorantApiService
import io.jadu.statshunter.valorant.valorant_game_infos.agents.data.repository.AgentsRepositoryImpl
import io.jadu.statshunter.valorant.valorant_game_infos.agents.domain.repository.AgentsRepository
import io.jadu.statshunter.valorant.valorant_game_infos.agents.domain.use_case.GetAgentDetailUseCase
import io.jadu.statshunter.valorant.valorant_game_infos.buddies.data.repository.BuddiesRepositoryImpl
import io.jadu.statshunter.valorant.valorant_game_infos.buddies.domain.repository.BuddiesRepository
import io.jadu.statshunter.valorant.valorant_game_infos.buddies.domain.use_case.GetBuddiesDetailUseCase
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class Modules {

    @Provides
    @Singleton
    fun provideGetAgentDetailUseCase(repository: AgentsRepository):GetAgentDetailUseCase{
        return GetAgentDetailUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideAgentRepository(api:ValorantApiService):AgentsRepository{
        return AgentsRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideApiService():ValorantApiService{
        return Retrofit.Builder()
            .baseUrl(Constants.BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ValorantApiService::class.java)
    }

    //Buddies
    @Provides
    @Singleton
    fun provideGetBuddiesDetailUseCase(repository: BuddiesRepository):GetBuddiesDetailUseCase{
        return GetBuddiesDetailUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideBuddiesRepository(api:ValorantApiService):BuddiesRepository{
        return BuddiesRepositoryImpl(api)
    }

}
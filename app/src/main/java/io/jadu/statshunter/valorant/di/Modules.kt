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
import io.jadu.statshunter.valorant.valorant_game_infos.bundles.data.repository.BundleRepositoryImpl
import io.jadu.statshunter.valorant.valorant_game_infos.bundles.domain.repository.BundleRepository
import io.jadu.statshunter.valorant.valorant_game_infos.bundles.domain.use_case.GetBundlesUseCase
import io.jadu.statshunter.valorant.valorant_game_infos.ceremonies.data.repository.CeremoniesRepositoryImpl
import io.jadu.statshunter.valorant.valorant_game_infos.ceremonies.domain.repository.CeremoniesRepository
import io.jadu.statshunter.valorant.valorant_game_infos.ceremonies.domain.use_case.GetCeremoniesUseCase
import io.jadu.statshunter.valorant.valorant_game_infos.competitiveTiers.data.repository.CompetitiveTiersRepositoryImpl
import io.jadu.statshunter.valorant.valorant_game_infos.competitiveTiers.domain.repository.CompetitiveTiersRepository
import io.jadu.statshunter.valorant.valorant_game_infos.competitiveTiers.domain.use_case.GetCompetitiveTierUseCase
import io.jadu.statshunter.valorant.valorant_game_infos.contracts.data.repository.ContractRepositoryImpl
import io.jadu.statshunter.valorant.valorant_game_infos.contracts.domain.repository.ContractRepository
import io.jadu.statshunter.valorant.valorant_game_infos.contracts.domain.use_case.ContractsUseCase
import io.jadu.statshunter.valorant.valorant_game_infos.currencies.data.repository.CurrenciesRepositoryImpl
import io.jadu.statshunter.valorant.valorant_game_infos.currencies.domain.repository.CurrenciesRepository
import io.jadu.statshunter.valorant.valorant_game_infos.currencies.domain.use_case.CurrenciesUseCase
import io.jadu.statshunter.valorant.valorant_game_infos.events.data.repository.EventsRepositoryImpl
import io.jadu.statshunter.valorant.valorant_game_infos.events.domain.repository.EventsRepository
import io.jadu.statshunter.valorant.valorant_game_infos.events.domain.use_case.EventsUseCase
import io.jadu.statshunter.valorant.valorant_game_infos.game_modes.data.repository.GameModeRepositoryImpl
import io.jadu.statshunter.valorant.valorant_game_infos.game_modes.domain.repository.GameModeRepository
import io.jadu.statshunter.valorant.valorant_game_infos.game_modes.domain.use_case.GameModeUseCase
import io.jadu.statshunter.valorant.valorant_game_infos.gears.data.repository.GearsRepositoryImpl
import io.jadu.statshunter.valorant.valorant_game_infos.gears.domain.repository.GearsRepository
import io.jadu.statshunter.valorant.valorant_game_infos.gears.domain.use_case.GearsUseCase
import io.jadu.statshunter.valorant.valorant_game_infos.maps.data.repository.MapsRepositoryImpl
import io.jadu.statshunter.valorant.valorant_game_infos.maps.domain.repository.MapsRepository
import io.jadu.statshunter.valorant.valorant_game_infos.maps.domain.use_case.MapsUseCase
import io.jadu.statshunter.valorant.valorant_game_infos.seasons.data.repository.SeasonRepositoryImpl
import io.jadu.statshunter.valorant.valorant_game_infos.seasons.domain.repository.SeasonRepository
import io.jadu.statshunter.valorant.valorant_game_infos.seasons.domain.use_case.SeasonUseCase
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

    @Provides
    @Singleton
    fun provideGetBundlesUseCase(repository:BundleRepository): GetBundlesUseCase {
        return GetBundlesUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideBundleRepository(api:ValorantApiService):BundleRepository{
        return BundleRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideGetCeremoniesUseCase(repository: CeremoniesRepository): GetCeremoniesUseCase {
        return GetCeremoniesUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideCeremoniesRepository(api:ValorantApiService):CeremoniesRepository{
        return CeremoniesRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideGetContractsUseCase(repository: ContractRepository): ContractsUseCase {
        return ContractsUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideContractRepository(api:ValorantApiService):ContractRepository{
        return ContractRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideGetCompetitiveTierUseCase(repository: CompetitiveTiersRepository): GetCompetitiveTierUseCase {
        return GetCompetitiveTierUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideCompetitiveTiersRepository(api:ValorantApiService):CompetitiveTiersRepository{
        return CompetitiveTiersRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideCurrenciesRepositoryUseCase(repository: CurrenciesRepository): CurrenciesUseCase {
        return CurrenciesUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideCurrenciesRepository(api:ValorantApiService):CurrenciesRepository{
        return CurrenciesRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideEventsRepositoryUseCase(repository: EventsRepository): EventsUseCase {
        return EventsUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideEventsRepository(api:ValorantApiService):EventsRepository{
        return EventsRepositoryImpl(api)
    }


    @Provides
    @Singleton
    fun provideGameModesRepositoryUseCase(repository: GameModeRepository): GameModeUseCase{
        return GameModeUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGameModesRepository(api:ValorantApiService):GameModeRepository{
        return GameModeRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun gearsRepositoryUseCase(repository: GearsRepository): GearsUseCase {
        return GearsUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGearsRepository(api:ValorantApiService):GearsRepository{
        return GearsRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideMapsRepositoryUseCase(repository: MapsRepository): MapsUseCase {
        return MapsUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideMapsRepository(api:ValorantApiService):MapsRepository{
        return MapsRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideSeasonsRepositoryUseCase(repository: SeasonRepository): SeasonUseCase {
        return SeasonUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideSeasonsRepository(api:ValorantApiService):SeasonRepository{
        return SeasonRepositoryImpl(api)
    }
}
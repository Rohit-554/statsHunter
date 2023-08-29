package io.jadu.statshunter.valorant.valorant_game_infos.currencies.data.repository

import io.jadu.statshunter.valorant.data.data_source.remote.ValorantApiService
import io.jadu.statshunter.valorant.valorant_game_infos.currencies.data.data_source.remote.dto.CurrenciesDto
import io.jadu.statshunter.valorant.valorant_game_infos.currencies.domain.repository.CurrenciesRepository

class CurrenciesRepositoryImpl(private val valorantApiService: ValorantApiService) : CurrenciesRepository  {
    override suspend fun getCurrencies(): CurrenciesDto {
        return valorantApiService.getCurrencies()
    }
}
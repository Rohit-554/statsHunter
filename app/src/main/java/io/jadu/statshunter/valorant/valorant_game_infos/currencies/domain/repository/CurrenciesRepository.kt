package io.jadu.statshunter.valorant.valorant_game_infos.currencies.domain.repository

import io.jadu.statshunter.valorant.valorant_game_infos.currencies.data.data_source.remote.dto.CurrenciesDto

interface CurrenciesRepository {
    suspend fun getCurrencies():CurrenciesDto
}
package io.jadu.statshunter.valorant.valorant_game_infos.currencies.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.currencies.domain.model.Currencies

data class CurrenciesDto(
    val `data`: List<CurrencyDataDto>?,
    val status: Int?
)

fun CurrenciesDto?.toDomainCurrencies(): Currencies {
    return Currencies(
        data = this?.data?.map { it.toDomainCurrencyData() } ?: emptyList(),
        status = this?.status ?: 0
    )
}
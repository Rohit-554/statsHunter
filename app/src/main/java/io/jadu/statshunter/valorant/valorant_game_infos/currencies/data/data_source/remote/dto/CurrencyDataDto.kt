package io.jadu.statshunter.valorant.valorant_game_infos.currencies.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.currencies.domain.model.CurrencyData

data class CurrencyDataDto(
    val assetPath: String?,
    val displayIcon: String?,
    val displayName: String?,
    val displayNameSingular: String?,
    val largeIcon: String?,
    val uuid: String?
)

fun CurrencyDataDto?.toDomainCurrencyData(): CurrencyData {
    return CurrencyData(
        assetPath = this?.assetPath ?: "",
        displayIcon = this?.displayIcon ?: "",
        displayName = this?.displayName ?: "",
        displayNameSingular = this?.displayNameSingular ?: "",
        largeIcon = this?.largeIcon ?: "",
        uuid = this?.uuid ?: ""
    )
}
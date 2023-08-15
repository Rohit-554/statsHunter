package io.jadu.statshunter.valorant.valorant_game_infos.currencies.data.data_source.remote.dto

data class CurrencyDataDto(
    val assetPath: String,
    val displayIcon: String,
    val displayName: String,
    val displayNameSingular: String,
    val largeIcon: String,
    val uuid: String
)

fun CurrencyDataDto?.toDomainCurrencyData(): io.jadu.statshunter.valorant.valorant_game_infos.currencies.domain.model.CurrencyData? {
    return this?.let {
        io.jadu.statshunter.valorant.valorant_game_infos.currencies.domain.model.CurrencyData(
            assetPath = it.assetPath,
            displayIcon = it.displayIcon,
            displayName = it.displayName,
            displayNameSingular = it.displayNameSingular,
            largeIcon = it.largeIcon,
            uuid = it.uuid
        )
    }
}
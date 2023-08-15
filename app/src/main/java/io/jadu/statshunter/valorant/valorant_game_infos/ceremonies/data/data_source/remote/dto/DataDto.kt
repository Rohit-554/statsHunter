package io.jadu.statshunter.valorant.valorant_game_infos.ceremonies.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.ceremonies.domain.model.CeremoniesData

data class DataDto(
    val assetPath: String,
    val displayName: String,
    val uuid: String
)

fun DataDto?.toData() = CeremoniesData(
    assetPath = this?.assetPath.orEmpty(),
    displayName = this?.displayName.orEmpty(),
    uuid = this?.uuid.orEmpty()
)


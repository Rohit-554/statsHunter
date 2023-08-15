package io.jadu.statshunter.valorant.valorant_game_infos.ceremonies.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.ceremonies.domain.model.Ceremonies

data class CeremoniesDto(
    val `data`: List<DataDto>,
    val status: Int
)

fun CeremoniesDto?.toCeremonies() = Ceremonies(
    `data` = this?.`data`.orEmpty().map { it.toData() },
    status = this?.status ?: 0
)
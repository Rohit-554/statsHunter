package io.jadu.statshunter.valorant.valorant_game_infos.weapons.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.weapons.domain.model.Weapons

data class WeaponsDto(
    val `data`: List<WeaponsDataDto>,
    val status: Int
)

fun WeaponsDto?.toDomainWeapons(): Weapons? {
    return this?.let {
        Weapons(
            data = it.`data`.mapNotNull { data -> data.toDomainWeaponsData() },
            status = it.status
        )
    }
}
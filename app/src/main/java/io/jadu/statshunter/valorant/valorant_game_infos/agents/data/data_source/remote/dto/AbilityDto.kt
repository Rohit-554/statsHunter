package io.jadu.statshunter.valorant.valorant_game_infos.agents.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.agents.domain.model.Ability

data class AbilityDto(
    val description: String?,
    val displayIcon: String?,
    val displayName: String?,
    val slot: String?
)


fun AbilityDto?.toDomainAbility(): Ability {
    return Ability(
        description = this?.description ?: "",
        displayIcon = this?.displayIcon ?: "",
        displayName = this?.displayName ?: "",
        slot = this?.slot ?: ""
    )
}



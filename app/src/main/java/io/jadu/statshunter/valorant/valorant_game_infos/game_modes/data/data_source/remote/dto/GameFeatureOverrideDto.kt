package io.jadu.statshunter.valorant.valorant_game_infos.game_modes.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.game_modes.domain.model.GameFeatureOverride

data class GameFeatureOverrideDto(
    val featureName: String?,
    val state: Boolean?
)

fun GameFeatureOverrideDto?.toDomainGameFeatureOverride(): GameFeatureOverride {
    return GameFeatureOverride(
        featureName = this?.featureName ?: "",
        state = this?.state ?: false
    )
}
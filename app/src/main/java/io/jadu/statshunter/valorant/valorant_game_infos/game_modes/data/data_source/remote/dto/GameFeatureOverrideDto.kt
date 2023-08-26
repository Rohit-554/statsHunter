package io.jadu.statshunter.valorant.valorant_game_infos.game_modes.data.data_source.remote.dto

data class GameFeatureOverrideDto(
    val featureName: String,
    val state: Boolean
)

fun GameFeatureOverrideDto?.toDomainGameFeatureOverride(): io.jadu.statshunter.valorant.valorant_game_infos.game_modes.domain.model.GameFeatureOverride? {
    return this?.let {
        io.jadu.statshunter.valorant.valorant_game_infos.game_modes.domain.model.GameFeatureOverride(
            featureName = featureName,
            state = state
        )
    }
}
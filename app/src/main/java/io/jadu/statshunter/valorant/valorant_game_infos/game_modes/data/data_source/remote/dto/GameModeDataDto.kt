package io.jadu.statshunter.valorant.valorant_game_infos.game_modes.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.game_modes.domain.model.GameModeData

data class GameModeDataDto(
    val allowsMatchTimeouts: Boolean,
    val assetPath: String,
    val displayIcon: String,
    val displayName: String,
    val duration: String,
    val economyType: Any,
    val gameFeatureOverrideDtos: List<GameFeatureOverrideDto?>,
    val gameRuleBoolOverrideDtos: List<GameRuleBoolOverrideDto?>,
    val isMinimapHidden: Boolean,
    val isTeamVoiceAllowed: Boolean,
    val orbCount: Int,
    val roundsPerHalf: Int,
    val teamRoles: List<String>,
    val uuid: String
)

fun GameModeDataDto?.toDomainGameModeData(): GameModeData? {
    return this?.let {
        it.gameFeatureOverrideDtos.map { gameFeatureOverrideDto -> gameFeatureOverrideDto.toDomainGameFeatureOverride() }
            ?.let { it1 ->
                it.gameRuleBoolOverrideDtos.map { gameRuleBoolOverrideDto -> gameRuleBoolOverrideDto.toDomainGameRuleBoolOverride() }
                    ?.let { it2 ->
                        GameModeData(
                            allowsMatchTimeouts = it.allowsMatchTimeouts,
                            assetPath = it.assetPath,
                            displayIcon = it.displayIcon,
                            displayName = it.displayName,
                            duration = it.duration,
                            economyType = it.economyType,
                            gameFeatureOverrides = it1,
                            gameRuleBoolOverrides = it2,
                            isMinimapHidden = it.isMinimapHidden,
                            isTeamVoiceAllowed = it.isTeamVoiceAllowed,
                            orbCount = it.orbCount,
                            roundsPerHalf = it.roundsPerHalf,
                            teamRoles = it.teamRoles,
                            uuid = it.uuid
                        )
                    }
            }
    }
}


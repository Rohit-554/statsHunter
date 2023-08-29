package io.jadu.statshunter.valorant.valorant_game_infos.game_modes.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.game_modes.domain.model.GameModeData


data class GameModeDataDto(
    val allowsMatchTimeouts: Boolean?,
    val assetPath: String?,
    val displayIcon: String?,
    val displayName: String?,
    val duration: String?,
    val economyType: Any?,
    val gameFeatureOverrideDtos: List<GameFeatureOverrideDto>?,
    val gameRuleBoolOverrideDtos: List<GameRuleBoolOverrideDto>?,
    val isMinimapHidden: Boolean?,
    val isTeamVoiceAllowed: Boolean?,
    val orbCount: Int?,
    val roundsPerHalf: Int?,
    val teamRoles: List<String>?,
    val uuid: String?
)

fun GameModeDataDto?.toDomainGameModeData(): GameModeData {
    return GameModeData(
        allowsMatchTimeouts = this?.allowsMatchTimeouts ?: false,
        assetPath = this?.assetPath ?: "",
        displayIcon = this?.displayIcon ?: "",
        displayName = this?.displayName ?: "",
        duration = this?.duration ?: "",
        economyType = this?.economyType ?: "",
        gameFeatureOverrides = this?.gameFeatureOverrideDtos?.map { it.toDomainGameFeatureOverride() } ?: emptyList(),
        gameRuleBoolOverrides = this?.gameRuleBoolOverrideDtos?.map { it.toDomainGameRuleBoolOverride() } ?: emptyList(),
        isMinimapHidden = this?.isMinimapHidden ?: false,
        isTeamVoiceAllowed = this?.isTeamVoiceAllowed ?: false,
        orbCount = this?.orbCount ?: 0,
        roundsPerHalf = this?.roundsPerHalf ?: 0,
        teamRoles = this?.teamRoles ?: emptyList(),
        uuid = this?.uuid ?: ""
    )
}




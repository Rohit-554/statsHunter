package io.jadu.statshunter.valorant.valorant_game_infos.game_modes.data.data.data_source.remote.dto

data class Data(
    val allowsMatchTimeouts: Boolean,
    val assetPath: String,
    val displayIcon: String,
    val displayName: String,
    val duration: String,
    val gameFeatureOverrides: List<GameFeatureOverride>,
    val gameRuleBoolOverrides: List<GameRuleBoolOverride>,
    val isMinimapHidden: Boolean,
    val isTeamVoiceAllowed: Boolean,
    val orbCount: Int,
    val roundsPerHalf: Int,
    val teamRoles: List<String>,
    val uuid: String
)
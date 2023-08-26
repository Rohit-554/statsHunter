package io.jadu.statshunter.valorant.valorant_game_infos.game_modes.domain.model

data class GameModeData(
    val allowsMatchTimeouts: Boolean,
    val assetPath: String,
    val displayIcon: String,
    val displayName: String,
    val duration: String,
    val economyType: Any,
    val gameFeatureOverrides: List<GameFeatureOverride?>,
    val gameRuleBoolOverrides: List<GameRuleBoolOverride?>,
    val isMinimapHidden: Boolean,
    val isTeamVoiceAllowed: Boolean,
    val orbCount: Int,
    val roundsPerHalf: Int,
    val teamRoles: List<String>,
    val uuid: String
)
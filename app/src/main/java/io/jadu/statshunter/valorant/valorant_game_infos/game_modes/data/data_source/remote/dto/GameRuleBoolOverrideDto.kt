package io.jadu.statshunter.valorant.valorant_game_infos.game_modes.data.data_source.remote.dto

data class GameRuleBoolOverrideDto(
    val ruleName: String,
    val state: Boolean
)

fun GameRuleBoolOverrideDto?.toDomainGameRuleBoolOverride(): io.jadu.statshunter.valorant.valorant_game_infos.game_modes.domain.model.GameRuleBoolOverride? {
    return this?.let {
        io.jadu.statshunter.valorant.valorant_game_infos.game_modes.domain.model.GameRuleBoolOverride(
            ruleName = ruleName,
            state = state
        )
    }
}

package io.jadu.statshunter.valorant.valorant_game_infos.game_modes.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.game_modes.domain.model.GameRuleBoolOverride

data class GameRuleBoolOverrideDto(
    val ruleName: String?,
    val state: Boolean?
)

fun GameRuleBoolOverrideDto?.toDomainGameRuleBoolOverride(): GameRuleBoolOverride {
    return GameRuleBoolOverride(
        ruleName = this?.ruleName ?: "",
        state = this?.state ?: false
    )
}


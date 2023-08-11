package io.jadu.statshunter.valorant.valorant_game_infos.agents.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.agents.domain.model.Role

data class RoleDto(
    val assetPath: String?,
    val description: String?,
    val displayIcon: String?,
    val displayName: String?,
    val uuid: String?
)
fun RoleDto?.toDomainRole(): Role {
    return Role(
        assetPath = this?.assetPath ?: "",
        description = this?.description ?: "",
        displayIcon = this?.displayIcon ?: "",
        displayName = this?.displayName ?: "",
        uuid = this?.uuid ?: ""
    )
}
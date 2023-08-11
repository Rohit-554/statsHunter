package io.jadu.statshunter.valorant.valorant_game_infos.agents.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.agents.domain.model.Data
import io.jadu.statshunter.valorant.valorant_game_infos.agents.domain.model.Role
import io.jadu.statshunter.valorant.valorant_game_infos.agents.domain.model.VoiceLine

data class DataDto(
    val abilities: List<AbilityDto>?,
    val assetPath: String?,
    val background: String?,
    val backgroundGradientColors: List<String>?,
    val bustPortrait: String?,
    val characterTags: List<String>?,
    val description: String?,
    val developerName: String?,
    val displayIcon: String?,
    val displayIconSmall: String?,
    val displayName: String?,
    val fullPortrait: String?,
    val fullPortraitV2: String?,
    val isAvailableForTest: Boolean?,
    val isBaseContent: Boolean?,
    val isFullPortraitRightFacing: Boolean?,
    val isPlayableCharacter: Boolean?,
    val killfeedPortrait: String?,
    val roleDto: RoleDto?,
    val uuid: String?,
    val aVoiceLineDto: VoiceLineDto?
)

fun DataDto?.toDomainAgentInfo(): Data {
    return Data(
        abilities = this?.abilities?.map { it.toDomainAbility() } ?: emptyList(),
        assetPath = this?.assetPath ?: "",
        background = this?.background ?: "",
        backgroundGradientColors = this?.backgroundGradientColors ?: emptyList(),
        bustPortrait = this?.bustPortrait ?: "",
        characterTags = this?.characterTags ?: emptyList(),
        description = this?.description ?: "",
        developerName = this?.developerName ?: "",
        displayIcon = this?.displayIcon ?: "",
        displayIconSmall = this?.displayIconSmall ?: "",
        displayName = this?.displayName ?: "",
        fullPortrait = this?.fullPortrait ?: "",
        fullPortraitV2 = this?.fullPortraitV2 ?: "",
        isAvailableForTest = this?.isAvailableForTest ?: false,
        isBaseContent = this?.isBaseContent ?: false,
        isFullPortraitRightFacing = this?.isFullPortraitRightFacing ?: false,
        isPlayableCharacter = this?.isPlayableCharacter ?: false,
        killfeedPortrait = this?.killfeedPortrait ?: "",
        roleDto = this?.roleDto?.toDomainRole() ?: Role("", "", "", "", ""),
        uuid = this?.uuid ?: "",
        aVoiceLineDto = this?.aVoiceLineDto?.toDomainVoiceLine() ?: VoiceLine(0.0, emptyList(), 0.0)
    )
}

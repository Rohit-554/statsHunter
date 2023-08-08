package io.jadu.statshunter.valorant.valorant_game_infos.agents.data.data_source.remote.dto

data class DataDto(
    val abilities: List<AbilityDto>,
    val assetPath: String,
    val background: String,
    val backgroundGradientColors: List<String>,
    val bustPortrait: String,
    val characterTags: List<String>,
    val description: String,
    val developerName: String,
    val displayIcon: String,
    val displayIconSmall: String,
    val displayName: String,
    val fullPortrait: String,
    val fullPortraitV2: String,
    val isAvailableForTest: Boolean,
    val isBaseContent: Boolean,
    val isFullPortraitRightFacing: Boolean,
    val isPlayableCharacter: Boolean,
    val killfeedPortrait: String,
    val roleDto: RoleDto,
    val uuid: String,
    val aVoiceLineDto: VoiceLineDto
)
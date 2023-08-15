package io.jadu.statshunter.valorant.valorant_game_infos.bundles.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.bundles.domain.model.Data

data class DataDto(
    val assetPath: String,
    val description: String,
    val displayIcon: String,
    val displayIcon2: String,
    val displayName: String,
    val displayNameSubText: String,
    val extraDescription: String,
    val promoDescription: String,
    val useAdditionalContext: Boolean,
    val uuid: String,
    val verticalPromoImage: String
)

fun DataDto?.toDomainData():Data{
    return Data(
        assetPath = this?.assetPath ?: "",
        description = this?.description ?: "",
        displayIcon = this?.displayIcon ?: "",
        displayIcon2 = this?.displayIcon2 ?: "",
        displayName = this?.displayName ?: "",
        displayNameSubText = this?.displayNameSubText ?: "",
        extraDescription = this?.extraDescription ?: "",
        promoDescription = this?.promoDescription ?: "",
        useAdditionalContext = this?.useAdditionalContext ?: false,
        uuid = this?.uuid ?: "",
        verticalPromoImage = this?.verticalPromoImage ?: ""
    )
}


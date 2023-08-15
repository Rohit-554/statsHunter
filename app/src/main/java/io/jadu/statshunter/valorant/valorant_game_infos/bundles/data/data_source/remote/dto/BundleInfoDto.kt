package io.jadu.statshunter.valorant.valorant_game_infos.bundles.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.bundles.domain.model.BundleInfo

data class BundleInfoDto(
    val `data`: List<DataDto>,
    val status: Int
)

fun BundleInfoDto?.toDomainBundleInfo(): BundleInfo {
    return BundleInfo(
        `data` = this?.`data`?.map { it.toDomainData() } ?: emptyList(),
        status = this?.status ?: 0
    )
}
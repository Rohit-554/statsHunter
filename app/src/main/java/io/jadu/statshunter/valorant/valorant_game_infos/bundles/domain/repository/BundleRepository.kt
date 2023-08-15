package io.jadu.statshunter.valorant.valorant_game_infos.bundles.domain.repository

import io.jadu.statshunter.valorant.valorant_game_infos.bundles.data.data_source.remote.dto.BundleInfoDto

interface BundleRepository {
    suspend fun getBundleInfo(): BundleInfoDto
}
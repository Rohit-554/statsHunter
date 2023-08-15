package io.jadu.statshunter.valorant.valorant_game_infos.bundles.data.repository

import io.jadu.statshunter.valorant.data.data_source.remote.ValorantApiService
import io.jadu.statshunter.valorant.valorant_game_infos.bundles.data.data_source.remote.dto.BundleInfoDto
import io.jadu.statshunter.valorant.valorant_game_infos.bundles.domain.repository.BundleRepository

class BundleRepositoryImpl(private val valorantApiService:ValorantApiService): BundleRepository {
    override suspend fun getBundleInfo(): BundleInfoDto {
        return valorantApiService.getBundlesDetails()
    }
}
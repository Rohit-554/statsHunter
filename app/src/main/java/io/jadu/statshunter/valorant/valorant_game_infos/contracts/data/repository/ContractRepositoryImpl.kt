package io.jadu.statshunter.valorant.valorant_game_infos.contracts.data.repository

import io.jadu.statshunter.valorant.data.data_source.remote.ValorantApiService
import io.jadu.statshunter.valorant.valorant_game_infos.contracts.data.data_source.remote.dto.ContractsDto
import io.jadu.statshunter.valorant.valorant_game_infos.contracts.domain.repository.ContractRepository

class ContractRepositoryImpl(private val valorantApiService: ValorantApiService): ContractRepository {
    override suspend fun getContracts(): ContractsDto {
        return valorantApiService.getContractsDetails()
    }
}
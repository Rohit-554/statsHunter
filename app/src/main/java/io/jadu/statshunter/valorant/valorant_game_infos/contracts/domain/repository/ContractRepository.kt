package io.jadu.statshunter.valorant.valorant_game_infos.contracts.domain.repository

import io.jadu.statshunter.valorant.valorant_game_infos.contracts.data.data_source.remote.dto.ContractsDto

interface ContractRepository {
    suspend fun getContracts():ContractsDto
}
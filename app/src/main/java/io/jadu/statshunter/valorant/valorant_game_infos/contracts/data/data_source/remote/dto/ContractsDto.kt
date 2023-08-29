package io.jadu.statshunter.valorant.valorant_game_infos.contracts.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.contracts.domain.model.Contracts

data class ContractsDto(
    val `data`: List<DataDto>?,
    val status: Int?
)

fun ContractsDto?.toDomainContracts(): Contracts {
    return Contracts(
        data = this?.data?.map { it.toDomainData() } ?: emptyList(),
        status = this?.status ?: 0
    )
}


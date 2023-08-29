package io.jadu.statshunter.valorant.valorant_game_infos.contracts.domain.use_case

import android.util.Log
import io.jadu.statshunter.valorant.core.constants.Constants
import io.jadu.statshunter.valorant.core.utils.Resource
import io.jadu.statshunter.valorant.valorant_game_infos.contracts.data.data_source.remote.dto.toDomainContracts
import io.jadu.statshunter.valorant.valorant_game_infos.contracts.domain.model.Contracts
import io.jadu.statshunter.valorant.valorant_game_infos.contracts.domain.repository.ContractRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException


class ContractsUseCase(private val repository: ContractRepository) {

    operator fun invoke(): Flow<Resource<Contracts>> = flow {
        try {
            emit(Resource.Loading())
            val response = repository.getContracts().toDomainContracts()
            emit(Resource.Success(response))
        } catch (e: HttpException){
            Log.d("AgentsRepositoryImpl", "getAgentsInfo: error2")
            emit(
                Resource.Error(
                    data = null,
                    message = Constants.INTERNETDOWN,
                )
            )
        }catch (e: IOException){
            Log.d("AgentsRepositoryImpl", "getAgentsInfo: error3")
            emit(
                Resource.Error(
                    data = null,
                    message = "Looks like Phoenix burned the wires! We're working on it...",
                )
            )
        }
    }
}
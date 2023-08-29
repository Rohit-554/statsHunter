package io.jadu.statshunter.valorant.valorant_game_infos.maps.domain.use_case

import io.jadu.statshunter.valorant.core.constants.Constants
import io.jadu.statshunter.valorant.core.utils.Resource
import io.jadu.statshunter.valorant.valorant_game_infos.maps.data.data_source.remote.dto.toDomainMaps
import io.jadu.statshunter.valorant.valorant_game_infos.maps.domain.models.Maps
import io.jadu.statshunter.valorant.valorant_game_infos.maps.domain.repository.MapsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class MapsUseCase(private val mapsRepository: MapsRepository) {
    operator fun invoke():Flow<Resource<Maps>> = flow {
        try {
            emit(Resource.Loading())
            val response = mapsRepository.getMaps().toDomainMaps()
            emit(Resource.Success(response))
        } catch (e: HttpException){
            emit(
                Resource.Error(
                    data = null,
                    message = Constants.INTERNETDOWN,
                )
            )
        }catch (e: IOException){
            emit(
                Resource.Error(
                    data = null,
                    message = "Looks like Phoenix burned the wires! We're working on it...",
                )
            )
        }
    }
}
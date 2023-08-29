package io.jadu.statshunter.valorant.valorant_game_infos.gears.domain.use_case

import io.jadu.statshunter.valorant.core.constants.Constants
import io.jadu.statshunter.valorant.core.utils.Resource
import io.jadu.statshunter.valorant.valorant_game_infos.gears.data.data_source.remote.dto.toDomainGears
import io.jadu.statshunter.valorant.valorant_game_infos.gears.domain.models.Gears
import io.jadu.statshunter.valorant.valorant_game_infos.gears.domain.repository.GearsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GearsUseCase(private val gearsRepository: GearsRepository) {

    operator fun invoke():Flow<Resource<Gears>> = flow {
        try {
            emit(Resource.Loading())
            val response = gearsRepository.getGears().toDomainGears()
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
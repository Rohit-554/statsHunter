package io.jadu.statshunter.valorant.valorant_game_infos.seasons.domain.use_case

import io.jadu.statshunter.valorant.core.constants.Constants
import io.jadu.statshunter.valorant.core.utils.Resource
import io.jadu.statshunter.valorant.valorant_game_infos.seasons.data.data_source.remote.dto.toDomainSeason
import io.jadu.statshunter.valorant.valorant_game_infos.seasons.domain.models.Season
import io.jadu.statshunter.valorant.valorant_game_infos.seasons.domain.repository.SeasonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class SeasonUseCase(private val seasonRepository: SeasonRepository) {
    operator fun invoke():Flow<Resource<Season>> = flow {
        try {
            emit(Resource.Loading())
            val response = seasonRepository.getSeasons().toDomainSeason()
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
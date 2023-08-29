package io.jadu.statshunter.valorant.valorant_game_infos.game_modes.domain.use_case

import android.util.Log
import io.jadu.statshunter.valorant.core.constants.Constants
import io.jadu.statshunter.valorant.core.utils.Resource
import io.jadu.statshunter.valorant.valorant_game_infos.game_modes.data.data_source.remote.dto.toDomainGameModes
import io.jadu.statshunter.valorant.valorant_game_infos.game_modes.domain.model.GameModes
import io.jadu.statshunter.valorant.valorant_game_infos.game_modes.domain.repository.GameModeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException


class GameModeUseCase (private val gameModeRepository: GameModeRepository){

    operator fun invoke():Flow<Resource<GameModes>> = flow {
        try {
            emit(Resource.Loading())
            val response = gameModeRepository.getGameModes().toDomainGameModes()
            emit(Resource.Success(response))
        }catch (e: HttpException){

            Log.d("GameModeUseCase", "GameModeUseCase: error2")
            emit(
                Resource.Error(
                    data = null,
                    message = Constants.INTERNETDOWN,
                )
            )

        }catch (e: IOException){

            Log.d("GameModeUseCase", "GameModeUseCase: error3")
            emit(
                Resource.Error(
                    data = null,
                    message = "Looks like Phoenix burned the wires! We're working on it...",
                )
            )
        }
    }
}
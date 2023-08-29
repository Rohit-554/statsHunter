package io.jadu.statshunter.valorant.valorant_game_infos.events.domain.use_case


import io.jadu.statshunter.valorant.core.constants.Constants
import io.jadu.statshunter.valorant.core.utils.Resource
import io.jadu.statshunter.valorant.valorant_game_infos.events.data.data_source.remote.dto.toDomainEvents
import io.jadu.statshunter.valorant.valorant_game_infos.events.domain.model.Events
import io.jadu.statshunter.valorant.valorant_game_infos.events.domain.repository.EventsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class EventsUseCase(private val eventsRepository: EventsRepository) {

    operator fun invoke(): Flow<Resource<Events>> = flow {
        try {
            emit(Resource.Loading())
            val response = eventsRepository.getEvents().toDomainEvents()
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
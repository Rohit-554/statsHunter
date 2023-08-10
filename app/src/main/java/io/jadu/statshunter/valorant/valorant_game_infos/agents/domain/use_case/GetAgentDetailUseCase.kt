package io.jadu.statshunter.valorant.valorant_game_infos.agents.domain.use_case

import android.util.Log
import io.jadu.statshunter.valorant.core.utils.Resource
import io.jadu.statshunter.valorant.valorant_game_infos.agents.domain.model.AgentInfo
import io.jadu.statshunter.valorant.valorant_game_infos.agents.domain.repository.AgentsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GetAgentDetailUseCase(
    private val repository: AgentsRepository
) {
    private val InternetDown = "\"Agent, it seems we're experiencing a bit of interference in the digital realm. Our agents are working on restoring the connection to the Valorant universe." +
            "        Until then, consider mastering your aim offline," +
            "        just like Jett in her downtime. Remember, tactical prowess knows no boundaries – not even the digital ones." +
            "        Stay patient and sharp, and we'll have you back in the action as soon as possible.\""
    operator fun invoke(): Flow<Resource<AgentInfo>> =  flow{
        try {
            emit(Resource.Loading())
            val response = repository.getAgentsInfo()
            emit(Resource.Success(response))
        }catch (e:HttpException){

            Log.d("AgentsRepositoryImpl", "getAgentsInfo: error2")
            emit(
                Resource.Error(
                    data = null,
                    message = InternetDown,
                )
            )

        }catch (e:IOException){

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
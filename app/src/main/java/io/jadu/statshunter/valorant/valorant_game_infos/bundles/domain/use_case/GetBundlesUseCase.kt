package io.jadu.statshunter.valorant.valorant_game_infos.bundles.domain.use_case

import io.jadu.statshunter.valorant.core.constants.Constants
import io.jadu.statshunter.valorant.core.utils.Resource
import io.jadu.statshunter.valorant.valorant_game_infos.bundles.data.data_source.remote.dto.toDomainBundleInfo
import io.jadu.statshunter.valorant.valorant_game_infos.bundles.domain.model.BundleInfo
import io.jadu.statshunter.valorant.valorant_game_infos.bundles.domain.repository.BundleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetBundlesUseCase(private val repository: BundleRepository) {

    operator fun invoke():Flow<Resource<BundleInfo>> = flow {
        try {
            emit(Resource.Loading())
            val response = repository.getBundleInfo().toDomainBundleInfo()
            emit(Resource.Success(response))
        }catch (e:Exception){
            emit(Resource.Error(
                data = null,
                message = Constants.INTERNETDOWN
            ))
        }catch (e:Exception){
            emit(Resource.Error(
                data = null,
                message = "Looks like Phoenix burned the wires! We're working on it..."
            ))
        }
    }

}
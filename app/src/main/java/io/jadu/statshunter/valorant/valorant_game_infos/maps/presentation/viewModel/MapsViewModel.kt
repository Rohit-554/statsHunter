package io.jadu.statshunter.valorant.valorant_game_infos.maps.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.jadu.statshunter.valorant.core.utils.Resource
import io.jadu.statshunter.valorant.valorant_game_infos.maps.domain.use_case.MapsUseCase
import io.jadu.statshunter.valorant.valorant_game_infos.maps.presentation.stateManager.MapsStateManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MapsViewModel @Inject constructor(private val mapsUseCase: MapsUseCase):ViewModel() {

    private val _mapsState = MutableStateFlow(MapsStateManager())
    val mapsState:StateFlow<MapsStateManager> = _mapsState

    init {
        getMaps()
    }

    private fun getMaps() {
        mapsUseCase().onEach { result->
            when(result){
                is Resource.Success -> {
                    _mapsState.value = MapsStateManager(mapsState = result.data, isLoading = false, error = null)
                }
                is Resource.Error -> {
                    _mapsState.value = MapsStateManager(mapsState = null, isLoading = false, error = result.message ?: "An unexpected error occurred")
                }
                is Resource.Loading -> {
                    _mapsState.value = MapsStateManager(mapsState = null, isLoading = true, error = null)
                }
            }
        }.launchIn(viewModelScope)
    }

}
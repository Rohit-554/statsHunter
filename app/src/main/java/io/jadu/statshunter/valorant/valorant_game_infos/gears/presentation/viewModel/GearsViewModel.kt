package io.jadu.statshunter.valorant.valorant_game_infos.gears.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.jadu.statshunter.valorant.core.utils.Resource
import io.jadu.statshunter.valorant.valorant_game_infos.gears.domain.use_case.GearsUseCase
import io.jadu.statshunter.valorant.valorant_game_infos.gears.presentation.stateManager.GearsStateManager
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class GearsViewModel @Inject constructor(private val getGearsUseCase: GearsUseCase):ViewModel() {

    private val _gearsState = MutableStateFlow(GearsStateManager())
    val gearsState:Flow<GearsStateManager> = _gearsState

    init {
        getGears()
    }

    private fun getGears() {
        getGearsUseCase().onEach { result->
            when(result){
                is Resource.Success -> {
                    _gearsState.value = GearsStateManager(gears = result.data, isLoading = false, error = null)
                }
                is Resource.Error -> {
                    _gearsState.value = GearsStateManager(gears = null, isLoading = false, error = result.message ?: "An unexpected error occurred")
                }
                is Resource.Loading -> {
                    _gearsState.value = GearsStateManager(gears = null, isLoading = true, error = null)
                }
            }
        }.launchIn(viewModelScope)
    }
}
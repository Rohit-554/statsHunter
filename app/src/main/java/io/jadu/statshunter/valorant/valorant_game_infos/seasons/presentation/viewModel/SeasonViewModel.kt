package io.jadu.statshunter.valorant.valorant_game_infos.seasons.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.jadu.statshunter.valorant.core.utils.Resource
import io.jadu.statshunter.valorant.valorant_game_infos.seasons.domain.use_case.SeasonUseCase
import io.jadu.statshunter.valorant.valorant_game_infos.seasons.presentation.stateManager.SeasonStateManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SeasonViewModel @Inject constructor(private val seasonUseCase: SeasonUseCase):ViewModel(){

    private val _seasonState = MutableStateFlow(SeasonStateManager())
    val seasonState:StateFlow<SeasonStateManager> = _seasonState

    init {
        getSeason()
    }

    private fun getSeason() {
        seasonUseCase().onEach { result->
            when(result){
                is Resource.Success -> {
                    _seasonState.value = SeasonStateManager(seasonState = result.data, isLoading = false, error = null)
                }
                is Resource.Error -> {
                    _seasonState.value = SeasonStateManager(seasonState = null, isLoading = false, error = result.message ?: "An unexpected error occurred")
                }
                is Resource.Loading -> {
                    _seasonState.value = SeasonStateManager(seasonState = null, isLoading = true, error = null)
                }
            }
        }.launchIn(viewModelScope)
    }


}
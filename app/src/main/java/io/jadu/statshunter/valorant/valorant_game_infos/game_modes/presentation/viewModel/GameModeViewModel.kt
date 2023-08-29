package io.jadu.statshunter.valorant.valorant_game_infos.game_modes.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.jadu.statshunter.valorant.core.utils.Resource
import io.jadu.statshunter.valorant.valorant_game_infos.game_modes.domain.use_case.GameModeUseCase
import io.jadu.statshunter.valorant.valorant_game_infos.game_modes.presentation.stateManager.GameModeStateManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class GameModeViewModel @Inject constructor(private val gameModeUseCase: GameModeUseCase):ViewModel() {

    private val _gameModeState = MutableStateFlow(GameModeStateManager())
    val gameModeState:StateFlow<GameModeStateManager> = _gameModeState

    init {
        getGameMode()
    }

    private fun getGameMode() {
        gameModeUseCase().onEach { result->
            when(result){
                is Resource.Success -> {
                    _gameModeState.value = GameModeStateManager(gameModeState = result.data, isLoading = false, error = null)
                }
                is Resource.Error -> {
                    _gameModeState.value = GameModeStateManager(gameModeState = null, isLoading = false, error = result.message ?: "An unexpected error occurred")
                }
                is Resource.Loading -> {
                    _gameModeState.value = GameModeStateManager(gameModeState = null, isLoading = true, error = null)
                }
            }
        }.launchIn(viewModelScope)
    }
}
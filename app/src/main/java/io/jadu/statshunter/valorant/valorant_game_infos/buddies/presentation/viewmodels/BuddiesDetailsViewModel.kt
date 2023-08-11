package io.jadu.statshunter.valorant.valorant_game_infos.buddies.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.jadu.statshunter.valorant.core.utils.Resource
import io.jadu.statshunter.valorant.valorant_game_infos.buddies.domain.use_case.GetBuddiesDetailUseCase
import io.jadu.statshunter.valorant.valorant_game_infos.buddies.presentation.stateManager.BuddiesInfoState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class BuddiesDetailsViewModel @Inject constructor(private val getBuddiesDetailUseCase: GetBuddiesDetailUseCase):ViewModel() {

    private val _buddiesInfoState = MutableStateFlow(BuddiesInfoState())
    val buddiesInfoState = _buddiesInfoState

    init {
        getBuddiesInfo()
    }

    private fun getBuddiesInfo() {
        getBuddiesDetailUseCase().onEach { result->
            when(result){
                is Resource.Success -> {
                    _buddiesInfoState.value = BuddiesInfoState(buddiesInfo = result.data, isLoading = false, error = null)
                }
                is Resource.Error -> {
                    _buddiesInfoState.value = BuddiesInfoState(buddiesInfo = null, isLoading = false, error = result.message ?: "An unexpected error occurred")
                }
                is Resource.Loading -> {
                    _buddiesInfoState.value = BuddiesInfoState(buddiesInfo = null, isLoading = true, error = null)
                }
            }
        }.launchIn(viewModelScope)
    }

}
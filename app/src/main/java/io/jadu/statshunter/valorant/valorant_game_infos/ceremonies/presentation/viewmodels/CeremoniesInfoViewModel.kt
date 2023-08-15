package io.jadu.statshunter.valorant.valorant_game_infos.ceremonies.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.jadu.statshunter.valorant.core.utils.Resource
import io.jadu.statshunter.valorant.valorant_game_infos.ceremonies.domain.use_case.GetCeremoniesUseCase
import io.jadu.statshunter.valorant.valorant_game_infos.ceremonies.presentation.stateManager.CeremoniesStateManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CeremoniesInfoViewModel @Inject constructor(private val getCeremoniesUseCase: GetCeremoniesUseCase):ViewModel() {

    private val _ceremoniesInfoState = MutableStateFlow(CeremoniesStateManager())
    val ceremoniesInfoState:StateFlow<CeremoniesStateManager> = _ceremoniesInfoState

    init {
        getCeremoniesInfo()
    }

    private fun getCeremoniesInfo() {
        getCeremoniesUseCase().onEach { result->
            when(result){
                is Resource.Success -> {
                    _ceremoniesInfoState.value = CeremoniesStateManager(ceremoniesInfo = result.data, isLoading = false, error = null)
                }
                is Resource.Error -> {
                    _ceremoniesInfoState.value = CeremoniesStateManager(ceremoniesInfo = null, isLoading = false, error = result.message ?: "An unexpected error occurred")
                }
                is Resource.Loading -> {
                    _ceremoniesInfoState.value = CeremoniesStateManager(ceremoniesInfo = null, isLoading = true, error = null)
                }
            }
        }.launchIn(viewModelScope)
    }
}
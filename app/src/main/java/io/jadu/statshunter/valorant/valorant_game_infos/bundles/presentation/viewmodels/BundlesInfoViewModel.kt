package io.jadu.statshunter.valorant.valorant_game_infos.bundles.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.jadu.statshunter.valorant.core.utils.Resource
import io.jadu.statshunter.valorant.valorant_game_infos.bundles.domain.use_case.GetBundlesUseCase
import io.jadu.statshunter.valorant.valorant_game_infos.bundles.presentation.stateManager.BundlesInfoState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class BundlesInfoViewModel @Inject constructor(private val getBundlesInfoUseCase: GetBundlesUseCase):ViewModel() {

    private val _bundlesInfoState = MutableStateFlow(BundlesInfoState())
    val bundlesInfoState = _bundlesInfoState

    init {
        getBundlesInfo()
    }

    private fun getBundlesInfo() {
        getBundlesInfoUseCase().onEach { result->
            when(result){
                is Resource.Success -> {
                    _bundlesInfoState.value = BundlesInfoState(bundlesInfo = result.data, isLoading = false, error = null)
                }
                is Resource.Error -> {
                    _bundlesInfoState.value = BundlesInfoState(bundlesInfo = null, isLoading = false, error = result.message ?: "An unexpected error occurred")
                }
                is Resource.Loading -> {
                    _bundlesInfoState.value = BundlesInfoState(bundlesInfo = null, isLoading = true, error = null)
                }
            }
        }.launchIn(viewModelScope)
    }


}
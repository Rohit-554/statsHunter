package io.jadu.statshunter.valorant.valorant_game_infos.contracts.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.jadu.statshunter.valorant.core.utils.Resource
import io.jadu.statshunter.valorant.valorant_game_infos.contracts.domain.use_case.ContractsUseCase
import io.jadu.statshunter.valorant.valorant_game_infos.contracts.presentation.stateManager.ContractsStateManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ContractViewModel @Inject constructor(private val getContractUseCase: ContractsUseCase):ViewModel(){
    private val _contractState = MutableStateFlow(ContractsStateManager())
    val contractState:StateFlow<ContractsStateManager> = _contractState

    init {
        getContractInfo()
    }

    private fun getContractInfo() {
        getContractUseCase().onEach { result->
            when(result){
                is Resource.Success -> {
                    _contractState.value = ContractsStateManager(contractsInfo = result.data, isLoading = false, error = null)
                }
                is Resource.Error -> {
                    _contractState.value = ContractsStateManager(contractsInfo = null, isLoading = false, error = result.message ?: "An unexpected error occurred")
                }
                is Resource.Loading -> {
                    _contractState.value = ContractsStateManager(contractsInfo = null, isLoading = true, error = null)
                }
            }
        }.launchIn(viewModelScope)
    }
}
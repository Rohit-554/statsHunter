package io.jadu.statshunter.valorant.valorant_game_infos.agents.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.jadu.statshunter.valorant.core.utils.Resource
import io.jadu.statshunter.valorant.valorant_game_infos.agents.domain.use_case.GetAgentDetailUseCase
import io.jadu.statshunter.valorant.valorant_game_infos.agents.presentation.stateManager.AgentInfoState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class AgentInfoViewModel @Inject constructor(
    private val getAgentDetailUseCase: GetAgentDetailUseCase
) : ViewModel(){

    private val _agentInfoState = MutableStateFlow(AgentInfoState())
    val agentInfoState: StateFlow<AgentInfoState> = _agentInfoState

    init {
        getAgentInfo()
    }
    private fun getAgentInfo() {
        getAgentDetailUseCase().onEach { result->
            when(result){
                is Resource.Success -> {
                    _agentInfoState.value = AgentInfoState(agentInfo = result.data, isLoading = false, error = null)
                }
                is Resource.Error -> {
                    _agentInfoState.value = AgentInfoState(agentInfo = null, isLoading = false, error = result.message ?: "An unexpected error occurred")
                }
                is Resource.Loading -> {
                    _agentInfoState.value = AgentInfoState(agentInfo = null, isLoading = true, error = null)
                }
            }
        }.launchIn(viewModelScope)
    }
}
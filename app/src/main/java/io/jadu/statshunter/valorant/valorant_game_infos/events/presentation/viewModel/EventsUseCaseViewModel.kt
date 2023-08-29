package io.jadu.statshunter.valorant.valorant_game_infos.events.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.jadu.statshunter.valorant.core.utils.Resource
import io.jadu.statshunter.valorant.valorant_game_infos.events.domain.use_case.EventsUseCase
import io.jadu.statshunter.valorant.valorant_game_infos.events.presentation.stateManager.EventsStateManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class EventsUseCaseViewModel @Inject constructor(private val getEventsUseCase: EventsUseCase):ViewModel() {

    private val _eventsState = MutableStateFlow(EventsStateManager())
    val eventsState:StateFlow<EventsStateManager> = _eventsState

    init {
        getEvents()
    }

    private fun getEvents() {
        getEventsUseCase().onEach { result->
            when(result){
                is Resource.Success -> {
                    _eventsState.value = EventsStateManager(eventsState = result.data, isLoading = false, error = null)
                }
                is Resource.Error -> {
                    _eventsState.value = EventsStateManager(eventsState = null, isLoading = false, error = result.message ?: "An unexpected error occurred")
                }
                is Resource.Loading -> {
                    _eventsState.value = EventsStateManager(eventsState = null, isLoading = true, error = null)
                }
            }
        }.launchIn(viewModelScope)
    }
}
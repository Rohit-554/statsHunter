package io.jadu.statshunter.valorant.valorant_game_infos.currencies.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.jadu.statshunter.valorant.core.utils.Resource
import io.jadu.statshunter.valorant.valorant_game_infos.currencies.domain.use_case.CurrenciesUseCase
import io.jadu.statshunter.valorant.valorant_game_infos.currencies.presentation.stateManager.CurrenciesStateManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CurrenciesViewModel @Inject constructor(private val currenciesUseCase: CurrenciesUseCase):ViewModel() {

    private val _currenciesState = MutableStateFlow(CurrenciesStateManager())
    val currenciesState:StateFlow<CurrenciesStateManager> = _currenciesState

    init {
        getCurrencies()
    }

    private fun getCurrencies() {
        currenciesUseCase().onEach { result->
            when(result){
                is Resource.Success -> {
                    _currenciesState.value = CurrenciesStateManager(currencies = result.data, isLoading = false, error = null)
                }
                is Resource.Error -> {
                    _currenciesState.value = CurrenciesStateManager(currencies = null, isLoading = false, error = result.message ?: "An unexpected error occurred")
                }
                is Resource.Loading -> {
                    _currenciesState.value = CurrenciesStateManager(currencies = null, isLoading = true, error = null)
                }
            }
        }.launchIn(viewModelScope)
    }
}
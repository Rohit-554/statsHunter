package io.jadu.statshunter.valorant.valorant_game_infos.bundles.presentation.stateManager

import io.jadu.statshunter.valorant.valorant_game_infos.bundles.domain.model.BundleInfo

data class BundlesInfoState (
    val bundlesInfo: BundleInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
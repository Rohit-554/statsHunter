package io.jadu.statshunter.valorant.valorant_game_infos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import io.jadu.statshunter.R
import io.jadu.statshunter.valorant.valorant_game_infos.agents.presentation.viewmodels.AgentInfoViewModel

@AndroidEntryPoint
class testActivity : AppCompatActivity() {
    private val agentInfoViewModel: AgentInfoViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        agentInfoViewModel.agentInfoState.value.agentInfo?.let {
            println(it.status)
        }
    }
}
package io.jadu.statshunter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import io.jadu.statshunter.valorant.valorant_game_infos.agents.presentation.viewmodels.AgentInfoViewModel
import io.jadu.statshunter.valorant.valorant_game_infos.buddies.presentation.viewmodels.BuddiesDetailsViewModel
import io.jadu.statshunter.valorant.valorant_game_infos.bundles.presentation.viewmodels.BundlesInfoViewModel
import io.jadu.statshunter.valorant.valorant_game_infos.testActivity
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val agentInfoViewModel: AgentInfoViewModel by viewModels()
    private val buddiesDetailsViewModel: BuddiesDetailsViewModel by viewModels()
    private val bundlesDetailsViewModel: BundlesInfoViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val text = findViewById<TextView>(R.id.testButton)
        // send to the testActivity
        lifecycleScope.launch {
//            agentInfoViewModel.agentInfoState.collect(){state->
//                Log.d("MainActivityabs", "onCreate: ${state.agentInfo?.data}")
//                text.text = state.agentInfo?.data?.get(0)?.displayName
//
//            }
//            buddiesDetailsViewModel.buddiesInfoState.collect(){state->
//                Log.d("MainActivityabs", "onCreate: ${state.buddiesInfo?.data}")
//                text.text = state.buddiesInfo?.data?.get(0)?.displayName
//
//            }
             bundlesDetailsViewModel.bundlesInfoState.collect(){state->
                 Log.d("MainActivityabs", "onCreate: ${state.bundlesInfo?.data}")
                 text.text = state.bundlesInfo?.data?.get(0)?.displayName

                }

        }


        text.setOnClickListener {
             val intent = Intent(this, testActivity::class.java)
             startActivity(intent)
        }
    }
}
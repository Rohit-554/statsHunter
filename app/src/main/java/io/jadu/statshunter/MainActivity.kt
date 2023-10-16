package io.jadu.statshunter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavGraph
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import io.jadu.statshunter.valorant.onboardingscreens.OnBoardingScreensFragment
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

//        setContent {
//            val navController = rememberNavController()
//            NavHost(
//                navController = navController,
//                startDestination = "onBoardingScreensFragment"
//                ) {
//                    composable("onBoardingScreensFragment") {
//                        OnBoardingScreensFragment(navController)
//                    }
//            }

//        }

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
            bundlesDetailsViewModel.bundlesInfoState.collect() { state ->
                Log.d("MainActivityabs", "onCreate: ${state.bundlesInfo?.data}")
                text.text = state.bundlesInfo?.data?.get(0)?.displayName

            }

        }


        text.setOnClickListener {
            val intent = Intent(this, testActivity::class.java)
            startActivity(intent)
        }
    }

//    @Composable
//    fun WelcomeScreen() {
//        val navController = rememberNavController()
//        NavHost(
//            navController = navController,
//            startDestination = "onBoardingScreensFragment"
//        ) {
//            composable("onBoardingScreensFragment") {
//                OnBoardingScreensFragment()
//            }
//        }
//    }
}
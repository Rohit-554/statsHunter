package io.jadu.statshunter.valorant.onboardingscreens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import dagger.hilt.android.AndroidEntryPoint
import io.jadu.statshunter.databinding.FragmentOnBoardingScreensBinding
import io.jadu.statshunter.valorant.onboardingscreens.composeUis.AppInfoScreen1
import io.jadu.statshunter.valorant.theme.appTheme
import io.jadu.statshunter.valorant.theme.backgroundColor

@AndroidEntryPoint
class OnBoardingScreensFragment : Fragment() {
    private lateinit var binding: FragmentOnBoardingScreensBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardingScreensBinding.inflate(inflater, container, false).apply {
            composeView.setContent {
                MaterialTheme {
                    AppInfoScreen1("Apple")
                }
            }
        }
        return binding.root
    }
}
package io.jadu.statshunter.valorant.onboardingscreens.composeUis

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import dagger.hilt.android.AndroidEntryPoint
import io.jadu.statshunter.R
import io.jadu.statshunter.valorant.theme.appTheme

@Composable
fun AppInfoScreen1(name: String) {
    Text(
        text = name,
        style = MaterialTheme.typography.h5,
        color = appTheme,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = dimensionResource(R.dimen.margin_small))
            .wrapContentWidth(Alignment.CenterHorizontally)
    )
}

@Preview
@Composable
private fun AppInfoScreen1Preview() {
    MaterialTheme {
        AppInfoScreen1("Apple")
    }
}


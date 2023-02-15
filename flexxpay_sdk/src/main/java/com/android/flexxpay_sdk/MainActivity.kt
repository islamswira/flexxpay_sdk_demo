package com.android.flexxpay_sdk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.android.flexxpay_sdk.presentation.dachboardView
import com.android.flexxpay_sdk.ui.theme.FlexxpayTheme
import com.google.accompanist.pager.ExperimentalPagerApi

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalPagerApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlexxpayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    dachboardView(
                        balanceHeaderColor = ColorManager.balanceHeaderColor ?: Color.White,
                        commissionHeaderColor = ColorManager.commissionHeaderColor ?: Color.White,
                        mainBGColor = ColorManager.mainBGColor ?: Color.White,
                        textMainColor = ColorManager.textMainColor ?: Color.White,
                        textSubMainColor = ColorManager.textSubMainColor ?: Color.White,
                        activeColor = ColorManager.activeColor ?: Color.White,
                    )
                }
            }
        }
    }
}

package com.android.flexxpay_sdk

import android.content.Context
import android.content.Intent
import androidx.compose.ui.graphics.Color
import androidx.core.graphics.toColorInt


class FlexxpaySDK {
    companion object{
        fun init(
            licenceKey: String,
            userId: String,
            balanceHeaderColor: String,
            activeColor: String,
            commissionHeaderColor: String,
            mainBGColor : String ,
            textMainColor : String ,
            textSubMainColor : String ,
            context: Context,
        ){
            ColorManager.balanceHeaderColor = Color(balanceHeaderColor.toColorInt())
            ColorManager.activeColor = Color(activeColor.toColorInt())
            ColorManager.commissionHeaderColor = Color(commissionHeaderColor.toColorInt())
            ColorManager.mainBGColor = Color(mainBGColor.toColorInt())
            ColorManager.textMainColor = Color(textMainColor.toColorInt())
            ColorManager.textSubMainColor = Color(textSubMainColor.toColorInt())
            val FlexxpayIntent = Intent(context , MainActivity::class.java)
            FlexxpayIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(FlexxpayIntent)
        }
    }
}
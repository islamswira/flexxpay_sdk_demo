package com.android.flexxpay_sdk.presentation.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.flexxpay_sdk.utils.Enums.TopBarTypes
import com.android.flexxpay_sdk.utils.NumbersManager

@Composable
fun CustomTopBar(
    title: String,
    topBarType: TopBarTypes,
    balanceColor: Color,
    commissionColor: Color
) {
    when(topBarType){
        TopBarTypes.NoTopBar -> {}
        else ->{

            val height = 187.dp
            Box(
                modifier = Modifier
                    .height(height)
                    .fillMaxWidth()
            ) {
                Canvas(
                    modifier = Modifier
                        .matchParentSize()
                ) {
                    val width = size.width
                    val height = size.height
                    val path = Path().apply {
                        moveTo(width, height.times(.90f))
                        quadraticBezierTo(
                            width.times(.50f),
                            height,
                            0f,
                            height.times(.90f)
                        )
                        lineTo(x = 0f, 0f)
                        lineTo(width, 0f)
                        close()
                    }
                    drawPath(
                        path = path,

                        brush = Brush.linearGradient(
                            colors = when (topBarType) {
                                TopBarTypes.NormalBar -> {
                                    listOf(
                                        balanceColor,
                                        balanceColor
                                    )
                                }
                                TopBarTypes.BalanceBar -> {
                                    listOf(
                                        balanceColor,
                                        balanceColor
                                    )
                                }
                                TopBarTypes.CommissionBalanceBar -> {
                                    listOf(
                                        commissionColor,
                                        commissionColor
                                    )
                                }
                                TopBarTypes.NoTopBar -> {
                                    listOf(
                                        Color.Transparent,
                                        Color.Transparent,
                                    )
                                }
                            }
                        )
                    )
                }


                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(20.dp)
                        .padding(bottom = 20.dp),
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = when (topBarType) {
                        TopBarTypes.NormalBar -> Alignment.Start
                        TopBarTypes.BalanceBar -> Alignment.CenterHorizontally
                        TopBarTypes.CommissionBalanceBar -> Alignment.CenterHorizontally
                        else -> {
                            Alignment.CenterHorizontally}
                    }
                ) {
                    when (topBarType) {
                        TopBarTypes.BalanceBar -> BalanceBar(topBarType)
                        TopBarTypes.CommissionBalanceBar -> BalanceBar(topBarType)
                        else -> {}
                    }
                }
            }
        }

    }
}






@Composable
fun BalanceBar(
    type: TopBarTypes
) {
    Text(
        text = when(type){
            TopBarTypes.BalanceBar -> "Your Salary Balance"
            TopBarTypes.CommissionBalanceBar -> "Your Commission Balance"
            else -> ""
        },
        modifier = Modifier.fillMaxWidth(),
        fontWeight = FontWeight.Light,
        fontSize = 12.sp,
        color = Color.White,
        textAlign = TextAlign.Center,
    )
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        var balanceAmount = 0.0
        when (type) {
            TopBarTypes.NormalBar -> {}
            TopBarTypes.BalanceBar -> {
                balanceAmount = 10000.0
            }
            TopBarTypes.CommissionBalanceBar -> {
                balanceAmount = 5000.0
            }
            else -> {}
        }
        Text(
            text = "${NumbersManager.formatNumber(balanceAmount)} ",
            fontWeight = FontWeight.SemiBold,
            fontSize = 25.sp,
            color = Color.White,
            modifier = Modifier.padding(end = 5.dp)
        )
        Text(
            "AED ",
            fontWeight = FontWeight.Light,
            fontSize = 25.sp,
            color = Color.White,
        )
    }

}
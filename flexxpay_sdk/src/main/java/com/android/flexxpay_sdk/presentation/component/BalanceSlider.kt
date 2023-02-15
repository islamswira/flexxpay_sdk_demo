package com.android.flexxpay_sdk.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.flexxpay_sdk.utils.NumbersManager
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun BalanceSlider(
    balanceColor: Color ,
    commissionColor: Color ,

) {
    val pagerState = rememberPagerState(
        initialPage = 0
    )

    HorizontalPager(
        count = 2,
        contentPadding = PaddingValues(
            start = 10.dp,
            end = 15.dp
        ),
        modifier = Modifier.fillMaxSize(),
        state = pagerState
    ) { page ->
        Card(
            modifier = Modifier
                .padding(
                    start = if (page == 1) 10.dp else 0.dp,
                    end = if (page == 1) 0.dp else 5.dp
                )
        ) {
            // Our page content
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(if (page == 0) balanceColor else commissionColor)
            ) {
                Column(
                    modifier = Modifier.padding(10.dp)
                ) {
                    Text(
                        if (page == 0) "Your Salary Balance" else "Your Commission Balance",
                        fontWeight = FontWeight.Light,
                        fontSize = 12.sp,
                        color = Color.White,
                    )
                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Row {
                            Text(
                                "${NumbersManager.formatNumber(10000.0)} ",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 25.sp,
                                color = Color.White,
                                modifier = Modifier.padding(end = 5.dp)
                            )
                            Text(
                                "AED",
                                fontWeight = FontWeight.Light,
                                fontSize = 25.sp,
                                color = Color.White,
                                modifier = Modifier.padding(end = 10.dp)
                            )
                        }

                        Box(modifier = Modifier.align(Alignment.Bottom)) {
                            HorizontalPagerIndicator(
                                pagerState = pagerState,
                                modifier = Modifier
                                    .align(Alignment.BottomEnd)
                                    .padding(5.dp),
                                indicatorWidth = 5.dp,
                                indicatorHeight = 5.dp,
                                pageCount = 2,
                                activeColor = Color.White,
                                inactiveColor = Color.White.copy(alpha = 0.5f)
                            )
                        }
                    }

                }
            }
        }

    }
}
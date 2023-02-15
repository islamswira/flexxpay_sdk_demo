package com.android.flexxpay_sdk.presentation.component

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.android.flexxpay_sdk.utils.CommonComponent.CustomCardView.CustomCardView
import com.android.flexxpay_sdk.utils.NumbersManager

@Composable
fun SalaryBreakdownsView(
    textMainColor: Color,
    textSubMainColor: Color,
    bgColor: Color,
    foregroundIndicatorColor: Color

) {
    CustomCardView(
        bgColor = bgColor,
        content = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier,
                    contentAlignment = Alignment.Center
                ) {
                    DashboardProgressBar(
                        foregroundIndicatorColor = foregroundIndicatorColor,
                        earnedPercentage = 10.toFloat(),
                        size = 150.dp,
                        indicatorThickness = 17.dp,
                        centerText = "Earned"
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                Column(Modifier.fillMaxWidth()) {
                    CustomTextItem(
                        mainFontColor = textMainColor,
                        headerFontColor = textSubMainColor,
                        painter = null,
                        haveButton = false,
                        modifier = Modifier,
                        text = "${NumbersManager.formatNumber(5000)} AED",
                        title = "Total Salary",
                        showDivider = true
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    CustomTextItem(
                        mainFontColor = textMainColor,
                        headerFontColor = textSubMainColor,
                        painter = null,
                        haveButton = false,
                        modifier = Modifier,
                        text = "${NumbersManager.formatNumber(5000)} AED",
                        title = "Earned Salary",
                        showDivider = true
                    )
                }
//                if (viewModel.showLoansInfo.value) {


                CustomTextItem(
                    mainFontColor = textMainColor,
                    headerFontColor = textSubMainColor,
                    painter = null,
                    haveButton = true,
                    modifier = Modifier,
                    text = "${NumbersManager.formatNumber(5000)} AED",
                    title = "Loan Amount",
                    showDivider = false,
                    onButtonClicked = {
//                            viewModel.onLoansButtonClicked()
                    }
                )
//                }
            }
            Spacer(modifier = Modifier.height(10.dp))

            CustomTextItem(
                text = "${3000.0} AED",
                mainFontColor = textMainColor,
                headerFontColor = textSubMainColor,
                title = "FlexxPay Funds",
                showDivider = true,
                modifier = Modifier,
                painter = null,
                haveButton = false,
            )
            Spacer(modifier = Modifier.height(10.dp))

            CustomTextItem(
                mainFontColor = textMainColor,
                headerFontColor = textSubMainColor,
                painter = null,
                haveButton = true,
                modifier = Modifier.padding(end = 10.dp),
                text = "${NumbersManager.formatNumber(5000)} AED",
                title = "Used Funds",
                showDivider = false,
                imageSize = 25.dp,
                onButtonClicked = {
//                    viewModel.onUsedFundsButtonClicked()
                }
            )
        }
    )
}
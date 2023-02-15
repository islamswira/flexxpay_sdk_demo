package com.android.flexxpay_sdk.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.flexxpay_sdk.presentation.component.BalanceSlider
import com.android.flexxpay_sdk.presentation.component.CustomTopBar
import com.android.flexxpay_sdk.presentation.component.SalaryBreakdownsView
import com.android.flexxpay_sdk.utils.Enums.TopBarTypes
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@Composable
fun dachboardView(

    balanceHeaderColor : Color ,
    commissionHeaderColor : Color,
    mainBGColor : Color,
    textMainColor : Color,
    textSubMainColor : Color,
    activeColor : Color,
) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val scope = rememberCoroutineScope()
//    val balanceList by viewModel.balanceList.collectAsStateWithLifecycle()
//    val servicesList by viewModel.servicesList.collectAsStateWithLifecycle()


//    val events = remember(viewModel.events, lifecycleOwner) {
//        viewModel.events.flowWithLifecycle(
//            lifecycleOwner.lifecycle,
//            Lifecycle.State.STARTED
//        )
//    }

//    var isLoading by remember { mutableStateOf(false) }

//    LaunchedEffect(Unit) {
//        events.collect { event ->
//            when (event) {
//                is ScreenEvent.ShowToast -> context.toast(event.messageId)
//                is ScreenEvent.ShowMessageToast -> context.StringToast(event.messageText)
//                is ScreenEvent.Pop -> navController.popBackStack()
//                is ScreenEvent.NavigateTo -> navController.navigate(route = event.route)
//                is ScreenEvent.Load -> {
//                    isLoading = event.isLoading
//                }
//                is ScreenEvent.PopEverythingUpToRoot -> {
//                    rootNavController.navigate(event.route) {
//                        popUpTo(0)
//                    }
//                }
//                else -> {}
//            }
//        }
//    }

//    /**
//     * To Show Any Loader In the View ...
//     */
//    if (isLoading) {
//        val loader = CustomFlexxpayLoader()
//        loader.ShowFlexxpayCustomLoader()
//    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        CustomTopBar(
            "",
            topBarType = TopBarTypes.BalanceBar,
            balanceColor = balanceHeaderColor,
            commissionColor = commissionHeaderColor
        )

        BalanceSlider(
            balanceColor = balanceHeaderColor,
            commissionColor = commissionHeaderColor
        )
        Spacer(modifier = Modifier.height(20.dp))
        Column(
            modifier = Modifier.padding(horizontal = 18.dp)
        ) {
//            /**
//             * Services View
//             */
//            Text(
//                "Services",
//                fontWeight = FontWeight.SemiBold,
//                fontSize = 12.sp,
//                color = mainColor,
//                modifier = Modifier.padding(bottom = 10.dp)
//            )
//            Spacer(modifier = Modifier.height(20.dp))
//            /**
//             * Adds View ...
//             */

//            Text(
//                "Featured",
//                fontFamily = montserrat,
//                fontWeight = FontWeight.SemiBold,
//                fontSize = 12.sp,
//                color = FlexxapyTheme.colors.headerBackGround,
//                modifier = Modifier.padding(bottom = 10.dp)
//            )
//            AddsSlider(balanceList)
//            Spacer(modifier = Modifier.height(20.dp))

            /**
             * Salary Break downs---------------------------------------------
             */
            Text(
                "Salary Breakdown",
                fontWeight = FontWeight.SemiBold,
                fontSize = 12.sp,
                color = textMainColor,
                modifier = Modifier.padding(bottom = 10.dp)
            )
            SalaryBreakdownsView(
                bgColor = mainBGColor,
                textMainColor = textMainColor,
                textSubMainColor = textSubMainColor,
                foregroundIndicatorColor = activeColor
            )

        }


        Spacer(modifier = Modifier.height(20.dp))

    }

}
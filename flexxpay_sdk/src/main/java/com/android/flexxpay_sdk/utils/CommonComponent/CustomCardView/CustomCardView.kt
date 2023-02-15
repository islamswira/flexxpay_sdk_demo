package com.android.flexxpay_sdk.utils.CommonComponent.CustomCardView

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.android.flexxpay_sdk.utils.shadow

@Composable
fun CustomCardView(
    modifier: Modifier = Modifier,
    content: @Composable (ColumnScope.() -> Unit),
    vertical: Arrangement.Vertical = Arrangement.SpaceBetween,
    bgColor: Color
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .shadow(
                Color.Black.copy(alpha = 0.25f),
                borderRadius = 20.dp,
                blurRadius = 9.dp
            )
            .background(
                bgColor,
                shape = RoundedCornerShape(19.dp)
            )
            .padding(PaddingValues(horizontal = 13.dp, vertical = 10.dp)),

        verticalArrangement = vertical,
        horizontalAlignment = Alignment.CenterHorizontally,
        content = content
    )
}
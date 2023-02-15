package com.android.flexxpay_sdk.presentation.component

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DashboardProgressBar(
    size: Dp = 200.dp,
    foregroundIndicatorColor: Color ,
    shadowColor: Color = Color.LightGray,
    indicatorThickness: Dp = 20.dp,
    earnedPercentage: Float = 8f,
    animationDuration: Int = 1000,
    centerText:String
) {

    // It remembers the data usage value
    var dataUsageRemember by remember {
        mutableStateOf(-1f)
    }

    // This is to animate the foreground indicator
    val dataUsageAnimate = animateFloatAsState(
        targetValue = dataUsageRemember,
        animationSpec = tween(
            durationMillis = animationDuration
        )
    )

    // This is to start the animation when the activity is opened
    LaunchedEffect(Unit) {
        dataUsageRemember = earnedPercentage
    }

    Box(
        modifier = Modifier
            .size(size),
        contentAlignment = Alignment.Center
    ) {

        Canvas(
            modifier = Modifier
                .size(size)
        ) {

            // For shadow
            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(shadowColor, Color.White),
                    center = Offset(x = this.size.width / 2, y = this.size.height / 2),
                    radius = this.size.height / 2
                ),
                radius = this.size.height / 2,
                center = Offset(x = this.size.width / 2, y = this.size.height / 2)
            )

            // This is the white circle that appears on the top of the shadow circle
            drawCircle(
                color = Color.White,
                radius = (size / 2 - indicatorThickness).toPx(),
                center = Offset(x = this.size.width / 2, y = this.size.height / 2)
            )

            // Convert the dataUsage to angle
            val sweepAngle = (dataUsageAnimate.value) * 360 / 100

            // Foreground indicator
            drawArc(
                color = foregroundIndicatorColor,
                startAngle = -90f,
                sweepAngle = sweepAngle,
                useCenter = false,
                style = Stroke(width = indicatorThickness.toPx(), cap = StrokeCap.Round),
                size = Size(
                    width = (size - indicatorThickness).toPx(),
                    height = (size - indicatorThickness).toPx()
                ),
                topLeft = Offset(
                    x = (indicatorThickness / 2).toPx(),
                    y = (indicatorThickness / 2).toPx()
                )
            )
        }

        // Display the data usage value
        DisplayText(
            animateNumber = dataUsageAnimate,
            textColor = foregroundIndicatorColor,
            text = centerText
        )
    }

    Spacer(modifier = Modifier.height(32.dp))


}

@Composable
private fun DisplayText(
    animateNumber: State<Float>,
    textColor : Color,
    text:String
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Text that shows the number inside the circle
        Text(
            (animateNumber.value).toInt().toString() + "%",
            fontWeight = FontWeight.SemiBold,
            fontSize = 25.sp,
            color = textColor ,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 5.dp)
        )

        // Text that shows the number inside the circle
        Text(
            text = text,
            fontWeight = FontWeight.Light,
            fontSize = 15.sp,
            color = textColor ,
            textAlign = TextAlign.Center
        )

    }
}

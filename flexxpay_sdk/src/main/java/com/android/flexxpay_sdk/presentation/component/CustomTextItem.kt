package com.android.flexxpay_sdk.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomTextItem(
    haveButton:Boolean = false,
    text: String,
    fontSize: TextUnit = 16.sp,
    mainFontColor: Color ,
    headerFontColor: Color ,
    title:String,
    showDivider:Boolean,
    modifier: Modifier,
    imageSize: Dp = 15.dp,
    tint : Color = Color.LightGray ,
    painter: Painter?,
    onButtonClicked: (() -> Unit)? = null
) {
    if (haveButton){
        Row(
            modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            TextItem(
                modifier = modifier,
                title = title,
                text = text,
                showDivider = showDivider,
                fontSize = fontSize,
                mainFontColor = mainFontColor,
                headerFontColor = headerFontColor
            )
            onButtonClicked?.let {
                if (painter != null) {
                    Image(
                        painter = painter,
                        contentDescription = "avatar",
                        contentScale = ContentScale.Crop,            // crop the image if it's not a square
                        modifier = Modifier
                            .size(imageSize)
                            .clip(shape = CircleShape) // clip to the circle shape
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = null,
                            ) {
                                it
                            },
                        colorFilter = ColorFilter.tint(tint)
                    )
                }
            }
        }
    }else{
        TextItem(
            modifier = modifier,
            title = title,
            text = text,
            showDivider = showDivider,
            fontSize = fontSize,
            mainFontColor = mainFontColor,
            headerFontColor = headerFontColor
        )
    }


}


@Composable
fun TextItem(
    modifier: Modifier,
    title : String,
    text: String,
    fontSize: TextUnit = 16.sp,
    mainFontColor: Color ,
    headerFontColor: Color ,
    showDivider: Boolean
) {
    Column(
        modifier = modifier,
    ) {
        Text(
            title,
            fontWeight = FontWeight.Light,
            fontSize = 11.sp,
            color = headerFontColor ,
            modifier = modifier.padding(bottom = 2.dp)
        )
        Text(
            text,
            fontWeight = FontWeight.Medium,
            fontSize = fontSize,
            color = mainFontColor,
            modifier = modifier.padding(bottom = 5.dp)
        )
        if (showDivider){
            Divider( thickness = 1.dp, color = headerFontColor)
        }
    }
}
package com.mdi.learnkotlinaksamedia.ui.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SlideIndicator(activeIndex: Int, onClick: (index: Int) -> Unit, modifier: Modifier = Modifier) {

    Row(
        modifier = modifier
    ) {
        for (i in 0..2) {
            val width by animateDpAsState(
                targetValue = if (activeIndex == i) 20.dp else 4.dp,
                label = "Circle's width"
            )

            Box(
                modifier = Modifier
                    .height(4.dp)
                    .width(width)
                    .clip(CircleShape)
                    .background(Color.White)
                    .clickable { onClick(i) }
            )
            if (i < 2) Spacer(Modifier.width(8.dp))
        }
    }
}
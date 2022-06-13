package com.radustavila.expandable_card_with_image

import androidx.annotation.DrawableRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ExpandableCardWithImage(
    title: String,
    titleFontSize: TextUnit = 20.sp,
    titleColor: Color = Color.Black,
    titleAlignment: Alignment = Alignment.Center,
    titleTextAlignment: TextAlign = TextAlign.Center,
    description: String,
    descriptionFontSize: TextUnit = 14.sp,
    descriptionColor: Color = Color.Black,
    descriptionMaxLines: Int = 2,
    descriptionTextAlignment: TextAlign = TextAlign.Center,
    @DrawableRes image: Int? = null,
    imageHeight: Dp = 150.dp,
    imageWidth: Dp = 100.dp,
    contentDescription: String? = null,
    contentScale: ContentScale = ContentScale.Fit,
    cardBackgroundColor: Color = Color.White,
    arrowColor: Color = Color.Black
) {
    var expandState by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(targetValue = if (expandState) 180f else 0f)

    Card(modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 1.dp)
        .animateContentSize(
            animationSpec = tween(
                durationMillis = 350,
                easing = LinearOutSlowInEasing
            )
        ),
        backgroundColor = cardBackgroundColor,
        onClick = { expandState = !expandState }
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Box(modifier = Modifier.fillMaxWidth()) {
                Text(text = title,
                    textAlign = titleTextAlignment,
                    fontWeight = FontWeight.Bold,
                    fontSize = titleFontSize,
                    color = titleColor,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .align(titleAlignment)
                        .padding(start = 48.dp, end = 48.dp)
                )
                IconButton(onClick = { expandState = !expandState },
                    modifier = Modifier
                        .rotate(rotationState)
                        .align(Alignment.CenterEnd)
                ) {
                    Icon(imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Drop Down Arrow",
                        tint = arrowColor
                    )
                }
            }
            if (descriptionMaxLines > 0) {
                Text(text = description,
                    textAlign = descriptionTextAlignment,
                    fontSize = descriptionFontSize,
                    color = descriptionColor,
                    maxLines = if (expandState) 25 else descriptionMaxLines,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
                )
            }
            if (expandState) {
                if (descriptionMaxLines <= 0) {
                    Text(text = description,
                        textAlign = descriptionTextAlignment,
                        fontSize = descriptionFontSize,
                        color = descriptionColor,
                        maxLines = 25,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
                    )
                }
                image?.let {
                    Image(
                        painter = painterResource(id = it),
                        contentDescription = contentDescription,
                        modifier = Modifier
                            .height(imageHeight)
                            .width(imageWidth)
                            .padding(8.dp)
                            .shadow(4.dp, RoundedCornerShape(10.dp)),
                        contentScale = contentScale
                    )
                }
            }
        }
    }
}

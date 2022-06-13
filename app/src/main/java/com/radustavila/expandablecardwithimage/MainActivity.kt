package com.radustavila.expandablecardwithimage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.radustavila.expandable_card_with_image.ExpandableCardWithImage
import com.radustavila.expandablecardwithimage.ui.theme.ExpandableCardWithImageTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExpandableCardWithImageTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
//                    ListOfDogsSimple()
                    ListOfDogsCustom()
                }
            }
        }
    }
}

@Composable
fun ListOfDogsSimple() {
    Column(Modifier.verticalScroll(rememberScrollState())) {
        ExpandableCardWithImage(
            title = "Cookie",
            description = stringResource(id = R.string.dog_1_text),
            image = R.drawable.dog1
        )
        ExpandableCardWithImage(
            title = "Snoopie",
            description = stringResource(id = R.string.dog_2_text),
            image = R.drawable.dog2
        )
        ExpandableCardWithImage(
            title = "Boopie",
            description = stringResource(id = R.string.dog_3_text),
            image = R.drawable.dog3
        )
    }
}


@Composable
fun ListOfDogsCustom() {
    val titleFontSize: TextUnit = 18.sp
    val titleColor: Color = Color.Blue
    val titleAlignment: Alignment = Alignment.CenterStart
    val titleTextAlignment: TextAlign = TextAlign.Start
    val descriptionFontSize: TextUnit = 12.sp
    val descriptionColor: Color = Color.Gray
    val descriptionMaxLines = 3
    val descriptionTextAlignment: TextAlign = TextAlign.Start
    val imageHeight: Dp = 150.dp
    val imageWidth: Dp = 300.dp
    val contentScale: ContentScale = ContentScale.Crop
    val cardBackgroundColor: Color = Color.White
    val arrowColor: Color = Color.Red

    Column(Modifier.verticalScroll(rememberScrollState())) {
        ExpandableCardWithImage(
            title = "Cookie",
            description = stringResource(id = R.string.dog_1_text),
            image = R.drawable.dog4,
            titleFontSize = titleFontSize,
            titleColor = titleColor,
            titleAlignment = titleAlignment,
            titleTextAlignment = titleTextAlignment,
            descriptionFontSize = descriptionFontSize,
            descriptionColor = descriptionColor,
            descriptionMaxLines = descriptionMaxLines,
            descriptionTextAlignment = descriptionTextAlignment,
            imageHeight = imageHeight,
            imageWidth = imageWidth,
            contentScale = contentScale,
            cardBackgroundColor = cardBackgroundColor,
            arrowColor = arrowColor
        )
        ExpandableCardWithImage(
            title = "Snoopie",
            description = stringResource(id = R.string.dog_2_text),
            image = R.drawable.dog5,
            titleFontSize = titleFontSize,
            titleColor = titleColor,
            titleAlignment = titleAlignment,
            titleTextAlignment = titleTextAlignment,
            descriptionFontSize = descriptionFontSize,
            descriptionColor = descriptionColor,
            descriptionMaxLines = descriptionMaxLines,
            descriptionTextAlignment = descriptionTextAlignment,
            imageHeight = imageHeight,
            imageWidth = imageWidth,
            contentScale = contentScale,
            cardBackgroundColor = cardBackgroundColor,
            arrowColor = arrowColor
        )
        ExpandableCardWithImage(
            title = "Boopie",
            description = stringResource(id = R.string.dog_3_text),
            image = R.drawable.dog6,
            titleFontSize = titleFontSize,
            titleColor = titleColor,
            titleAlignment = titleAlignment,
            titleTextAlignment = titleTextAlignment,
            descriptionFontSize = descriptionFontSize,
            descriptionColor = descriptionColor,
            descriptionMaxLines = descriptionMaxLines,
            descriptionTextAlignment = descriptionTextAlignment,
            imageHeight = imageHeight,
            imageWidth = imageWidth,
            contentScale = contentScale,
            cardBackgroundColor = cardBackgroundColor,
            arrowColor = arrowColor
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    ExpandableCardWithImageTheme {
        ListOfDogsSimple()
//        ListOfDogsCustom()
    }
}

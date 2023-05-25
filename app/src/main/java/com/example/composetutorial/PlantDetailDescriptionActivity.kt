package com.example.composetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetutorial.ui.theme.ComposeTutorialTheme
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight

class PlantDetailDescriptionActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTutorialTheme {
                PlantDetailDescription()
            }
        }
    }
}


@Composable
private fun PlantName(name: String) {
    Text(
        text = name,
        style = MaterialTheme.typography.h5,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 26.dp)
            .padding(vertical = 16.dp)
            .wrapContentWidth(Alignment.CenterHorizontally)
    )
}

@Composable
fun PlantDetailContent(plant: Plant) {
    Column(Modifier.padding(8.dp)) {
        PlantName(plant.name)
        PlantWatering(plant.wateringInterval)
    }
}

@Preview
@Composable
private fun PlantNamePreview() {
    ComposeTutorialTheme {
        PlantName("Apple")
    }
}

@Composable
fun PlantDetailDescription() {
    Surface {
        Text("Hello Compose")
    }
}

data class Plant(
    val id: String,
    val name: String,
    val description: String,
    val wateringInterval: Int,
    val height: Int,
    val others: String
)

@Preview
@Composable
fun MyAppPlantDetailPreview() {
    val plant = Plant("id", "Apple", "description", 3, 30, "")
    ComposeTutorialTheme {
        PlantDetailContent(plant)
    }
}

@Composable
private fun PlantWatering(wateringInterval: Int) {
    Column(Modifier.fillMaxWidth()) {
        val centerWithPaddingModifier = Modifier
            .padding(horizontal = 16.dp)
            .align(Alignment.CenterHorizontally)

        val normalPadding = 22.dp

        Text(
            text = stringResource(R.string.watering_needs_prefix),
            color = MaterialTheme.colors.primaryVariant,
            fontWeight = FontWeight.Bold,
            modifier = centerWithPaddingModifier.padding(top = normalPadding)
        )

        Text(
            text = "Every $wateringInterval days",
            modifier = centerWithPaddingModifier.padding(bottom = normalPadding)
        )


    }
}

@Preview
@Composable
private fun PlantWateringPreview() {
    MaterialTheme {
        PlantWatering(7)
    }
}


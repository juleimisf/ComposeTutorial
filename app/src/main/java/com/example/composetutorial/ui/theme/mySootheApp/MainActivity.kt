package com.example.composetutorial.ui.theme.mySootheApp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetutorial.ui.theme.ComposeTutorialTheme
import com.example.composetutorial.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTutorialTheme() {
                SearchBar()
            }
        }
    }
}

@Composable
fun SearchBar(
    modifier: Modifier = Modifier
) {
    TextField(
        value = "",
        onValueChange = {},
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.surface
        ),
        placeholder = {
            Text("Search")
        },
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp)
    )
}

@Composable
fun AlignYourBodyElement(modifier: Modifier = Modifier, data: DataBody) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = data.image, contentDescription = null,
            contentScale = ContentScale.Crop, modifier = Modifier
                .size(44.dp)
                .clip(CircleShape)
        )
        Text(
            text = data.name,
            style = MaterialTheme.typography.h6,
            modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp)
        )
    }
}

data class DataBody(
    val image: Painter,
    val name: String
)

@Composable
fun FavoriteCollectionCard(modifier: Modifier = Modifier, data: DataBody) {
    Surface(shape = MaterialTheme.shapes.small, modifier = modifier) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(192.dp)
        ) {
            Image(
                painter = data.image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(56.dp)
            )
            Text(
                text = data.name
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
private fun SearchBarPreview() {
    ComposeTutorialTheme {
        SearchBar()
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
private fun AlignYourBodyElementPreview() {
    ComposeTutorialTheme {
        val data = DataBody(image = painterResource(id = R.drawable.ic_clock), name = "Nombre")
        AlignYourBodyElement(modifier = Modifier.padding(8.dp), data = data)
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
private fun FavoriteCollectionCardPreview() {
    ComposeTutorialTheme {
        val data = DataBody(image = painterResource(id = R.drawable.ic_clock), name = "Nombre")
        FavoriteCollectionCard(modifier = Modifier.padding(8.dp), data = data)
    }
}
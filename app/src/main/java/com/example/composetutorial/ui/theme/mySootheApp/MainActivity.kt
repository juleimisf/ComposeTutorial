package com.example.composetutorial.ui.theme.mySootheApp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.res.stringResource
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
fun AlignYourBodyElement(
    modifier: Modifier = Modifier, @DrawableRes drawable: Int,
    @StringRes text: Int,
) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop, modifier = Modifier
                .size(44.dp)
                .clip(CircleShape)
        )
        Text(
            text = stringResource(text),
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
fun FavoriteCollectionCard(
    modifier: Modifier = Modifier, @DrawableRes drawable: Int,
    @StringRes text: Int,
) {
    Surface(shape = MaterialTheme.shapes.small, modifier = modifier) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(192.dp)
        ) {
            Image(
                painter = painterResource(drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(56.dp)
            )
            Text(
                text = stringResource(text),
            )
        }
    }
}

private val alignYourBodyData = listOf(
    R.drawable.ic_clock to R.string.search_text,
    R.drawable.ic_clock to R.string.search_text,
    R.drawable.ic_clock to R.string.search_text,
    R.drawable.ic_clock to R.string.search_text,
    R.drawable.ic_clock to R.string.search_text,
    R.drawable.ic_clock to R.string.search_text,
).map { DrawableStringPair(it.first, it.second) }

private val favoriteCollectionsData = listOf(
    R.drawable.ic_clock to R.string.search_text,
    R.drawable.ic_clock to R.string.search_text,
    R.drawable.ic_clock to R.string.search_text,
    R.drawable.ic_clock to R.string.search_text,
    R.drawable.ic_clock to R.string.search_text,
    R.drawable.ic_clock to R.string.search_text,
    R.drawable.ic_clock to R.string.search_text,
).map { DrawableStringPair(it.first, it.second) }

private data class DrawableStringPair(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int
)

@Composable
fun AlignYourBodyRow(modifier: Modifier = Modifier) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(alignYourBodyData) { item ->
            AlignYourBodyElement(drawable = item.drawable, text = item.text)
        }
    }
}

@Composable
fun FavoriteCollectionsGrid(modifier: Modifier = Modifier) {

    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.height(120.dp)
    ) {
        items(favoriteCollectionsData) { item ->
            FavoriteCollectionCard(
                modifier = Modifier.height(56.dp), drawable = item.drawable, text = item.text
            )
        }
    }
}

@Composable
fun HomeSection(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier = modifier) {
        Text(
            stringResource(title),
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 8.dp)
                .padding(horizontal = 16.dp)
        )
        content()
    }
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier
            .verticalScroll(rememberScrollState())
            .padding(vertical = 16.dp)
    ) {
        Spacer(Modifier.height(16.dp))
        SearchBar(Modifier.padding(horizontal = 16.dp))
        HomeSection(title = R.string.search_text) {
            AlignYourBodyRow()
        }
        HomeSection(title = R.string.search_text) {
            FavoriteCollectionsGrid()
        }
        Spacer(Modifier.height(16.dp))
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
        AlignYourBodyElement(
            modifier = Modifier.padding(8.dp),
            drawable = R.drawable.ic_clock,
            text = R.string.search_text
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
private fun FavoriteCollectionCardPreview() {
    ComposeTutorialTheme {
        FavoriteCollectionCard(
            modifier = Modifier.padding(8.dp), drawable = R.drawable.ic_clock,
            text = R.string.search_text
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
private fun AlignYourBodyRowPreview() {
    ComposeTutorialTheme {
        AlignYourBodyRow(modifier = Modifier.padding(8.dp))
    }
}


@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
private fun FavoriteCollectionsGridPreview() {
    ComposeTutorialTheme {
        FavoriteCollectionsGrid()
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
private fun HomeSectionPreview() {
    ComposeTutorialTheme {
        HomeSection(
            title = R.string.search_text,
            content = { AlignYourBodyRow() })
    }
}


@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
private fun HomeScreenPreview() {
    ComposeTutorialTheme {

        HomeScreen()
    }
}
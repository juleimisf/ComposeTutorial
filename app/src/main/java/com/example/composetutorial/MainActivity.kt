package com.example.composetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTutorialTheme {
                MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

data class Message(val author: String, val body: String, val showMore: String, val showLess: String)

@Composable
fun MyApp(modifier: Modifier = Modifier) {

    var shouldShowOnBoarding by remember { mutableStateOf(true) }

    Surface(modifier) {
        if (shouldShowOnBoarding) {
            OnBoardingScreen(onContinueClicked = { shouldShowOnBoarding = false })
        } else {
            Greetings(
                listOf(
                    Message("Hello", "compose", "show more", "show less"),
                    Message("Hello", "world", "show more", "show less")
                )
            )
        }
    }
}

@Composable
fun OnBoardingScreen(
    onContinueClicked: () -> Unit,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Welcome to the Basics Codelab!")
        Button(
            modifier = Modifier.padding(vertical = 16.dp),
            onClick = onContinueClicked
        ) {
            Text(text = "Continue")
        }
    }
}


@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnBoardingPreview() {
    ComposeTutorialTheme {
        OnBoardingScreen(onContinueClicked = {})
    }
}

@Composable
fun Greeting(msg: Message) {
    val expanded = remember { mutableStateOf(false) }

    val extraPadding = if (expanded.value) 58.dp else 0.dp

    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier
            .padding(vertical = 4.dp, horizontal = 8.dp)
            .fillMaxWidth()
    ) {
        Row {
            Column(
                Modifier
                    .weight(3f)
                    .padding(bottom = extraPadding)
            ) {
                Text(
                    text = msg.author,
                    modifier = Modifier.padding(start = 16.dp, top = 16.dp)
                )
                Text(
                    text = msg.body,
                    modifier = Modifier.padding(start = 16.dp, bottom = 16.dp)
                )
            }
            Button(
                modifier = Modifier.padding(16.dp),
                onClick = { expanded.value = !expanded.value },
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray),
                elevation = ButtonDefaults.elevation(
                    defaultElevation = 6.dp,
                    pressedElevation = 8.dp,
                    disabledElevation = 0.dp
                ),
            ) {
                Text(if (!expanded.value) msg.showMore else msg.showLess)
            }
        }

    }


}

@Composable
fun Greetings(messages: List<Message>) {
    LazyColumn {
        items(messages) { item ->
            Greeting(item)
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreview() {
    ComposeTutorialTheme {
        val items =
            listOf(
                Message("Hello", "World ", "Show more", "Show less"),
                Message("Hello", "Compose ", "Show more", "Show less"),
            )
        Greetings(items)
    }
}

@Preview
@Composable
fun MyAppPreview() {
    ComposeTutorialTheme {
        MyApp(Modifier.fillMaxSize())
    }
}
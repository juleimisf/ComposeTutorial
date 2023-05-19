package com.example.composetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetutorial.ui.theme.ComposeTutorialTheme
import androidx.compose.foundation.lazy.items

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTutorialTheme {
                Surface {
                    val items =
                        listOf(
                            Message("Android", "Jetpack Compose", "Terms and conditions"),
                            Message("Android", "Jetpack Compose", "Terms and conditions")
                        )
                    Conversation(items)
                }
            }
        }
    }
}

data class Message(val author: String, val body: String, val termsAndConditions: String)


@Composable
fun MessageCard(msg: Message) {
    Row(modifier = Modifier.padding(all = 16.dp)) {
        Image(
            painter = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = "Contact profile picture",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.dp, MaterialTheme.colors.secondary, CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = msg.author,
                style = MaterialTheme.typography.subtitle2,
                color = MaterialTheme.colors.secondary
            )

            Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp) {
                Text(
                    text = msg.body,
                    modifier = Modifier.padding(all = 8.dp),
                    style = MaterialTheme.typography.subtitle1
                )
            }

            Text(text = msg.termsAndConditions)
        }
    }
}

@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn{
        items(messages) { item ->
            MessageCard(item)
        }
    }
}


@Preview(name = "Light Mode")
@Composable
fun PreviewMessageCard() {
    ComposeTutorialTheme {
        val items =
            listOf(
                Message("Android", "Jetpack Compose", "Terms and conditions"),
                Message("Android", "Jetpack Compose", "Terms and conditions"),
                Message("Android", "Jetpack Compose", "Terms and conditions"),
                Message("Android", "Jetpack Compose", "Terms and conditions")
            )
        Conversation(items)
    }
}
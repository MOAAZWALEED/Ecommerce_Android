package com.route.ecommerce.c19_mobile_track.GMonThu.tutorial.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.route.ecommerce.c19_mobile_track.GMonThu.ui.theme.EcommerceTheme


@Composable
fun GreetingLazyList(modifier : Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        item(500) {
            Greeting("Moaaz")
        }
    }
}

@Composable
fun CardCounter(modifier : Modifier = Modifier, onCardUpdate: (Int) -> Unit) {
    var counter by remember { mutableStateOf(0) }
    Row(
        modifier = modifier.fillMaxWidth(0.5f),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(onClick = {
            counter--
            onCardUpdate(counter)
        }) {
            Text("-")
        }
        Text("$counter")
        Button(onClick = {
            counter ++
            onCardUpdate(counter)
        }) {
            Text("+")
        }
    }
}
@Preview
@Composable
private  fun CardCounterPreview() {
    CardCounter{

    }
}



@Preview
@Composable
private  fun GreetingLazyListPreview() {
    EcommerceTheme {
        GreetingLazyList()
    }
}



@Composable
fun GreetingList(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
        .fillMaxSize()
        .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Greeting(name = "Android", modifier.size(200.dp))
        Greeting(name = "Flutter")
        Greeting(name = "Mohamed")
    }
}





@Preview
@Composable
private  fun GreetingListPreview() {
    GreetingList()
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = " $name!",
        modifier = modifier
            .padding(vertical = 16.dp)
            .background(color = Color.Black, shape = CircleShape)
            .clickable(true) {

            }
            .padding(16.dp),
        textAlign = TextAlign.Center

    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EcommerceTheme {
        Greeting("Android")
    }
}
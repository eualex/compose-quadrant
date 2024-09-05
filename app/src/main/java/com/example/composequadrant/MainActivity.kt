package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

data class QuadrantItem(
    val title: Int,
    val description: Int,
    val background: Int,
)

val QUADRANT_ITEM_LIST = listOf<List<QuadrantItem>>(
    listOf(
        QuadrantItem(
            title = R.string.box_1_title,
            description = R.string.box_1_content,
            background = R.color.purple_50
        ),
        QuadrantItem(
            title = R.string.box_2_title,
            description = R.string.box_2_content,
            background = R.color.purple_100
        )),
    listOf(
        QuadrantItem(
            title = R.string.box_3_title,
            description = R.string.box_3_content,
            background = R.color.purple_150
        ),
        QuadrantItem(
            title = R.string.box_4_title,
            description = R.string.box_4_content,
            background = R.color.purple_0
        )
    ),
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadrantTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    QuadrantApp(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun QuadrantApp(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        QUADRANT_ITEM_LIST.forEach { rowItems ->
            Row(Modifier.weight(1f)) {
                rowItems.forEach { item ->
                    Quadrant(
                        title = stringResource(item.title),
                        description = stringResource(item.description),
                        background = colorResource(item.background),
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}

@Composable
fun Quadrant(
    title: String,
    description: String,
    background: Color,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(background)
            .padding(16.dp)
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(bottom = 16.dp)
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeQuadrantTheme {
        QuadrantApp()
    }
}
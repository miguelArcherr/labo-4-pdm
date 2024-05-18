package com.enriselle.labo4.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.enriselle.labo4.ui.theme.Labo4Theme

@Composable
fun DetailScreen(
    viewModel: ChampionsViewModel
) {
    val champ = viewModel.selectedChampion.collectAsState()

    Labo4Theme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp, top = 32.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            AsyncImage(
                model = champ.value.image.sprite,
                contentDescription = "${champ.value.name} details",
                modifier = Modifier
                    .height(300.dp)
                    .width(400.dp)
            )

            Text(text = "Name: ${champ.value.name}")
            Text(text = "Title: ${champ.value.title}")
            Text(text = "Description: ${champ.value.blurb}")
            champ.value.tags.forEach {
                Text(text = "Tags: ${champ.value.tags}}")
            }
        }
    }
}
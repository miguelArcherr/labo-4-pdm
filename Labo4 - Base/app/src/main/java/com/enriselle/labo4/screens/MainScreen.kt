package com.enriselle.labo4.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.enriselle.labo4.ui.components.ChampionCard
import com.enriselle.labo4.ui.theme.Labo4Theme

@Composable
fun MainScreen(
    viewModel: ChampionsViewModel,
    onClick: () -> Unit
) {
    val listChampions = viewModel.listChampions.collectAsState()
    val isLoading = viewModel.isLoading.collectAsState()

    Labo4Theme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(16.dp)
        ) {
            if (isLoading.value) {
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            } else {
                when {
                    listChampions.value.isEmpty() -> {
                        Button(onClick = { viewModel.colexionchampionsList() }) {
                            Text(text = "obtener informacion")
                        }
                    }

                    else -> {
                        LazyColumn(
                            modifier = Modifier
                                .fillMaxSize(),
                            verticalArrangement = Arrangement.spacedBy(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            items(listChampions.value) { champ ->
                                ChampionCard(champion = champ){
                                    onClick()
                                    viewModel.guardarSDDChampion(champ)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

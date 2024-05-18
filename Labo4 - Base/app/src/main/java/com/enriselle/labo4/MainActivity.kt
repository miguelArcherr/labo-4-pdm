package com.enriselle.labo4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import com.enriselle.labo4.navigation.RootNavigation
import com.enriselle.labo4.screens.ChampionsViewModel
import com.enriselle.labo4.ui.theme.Labo4Theme
import com.enriselle.labo4.utils.ChampionDummyData
import com.enriselle.labo4.utils.ChampionInformation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainActivity : ComponentActivity() {
    private val viewModel = ChampionsViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Labo4Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RootNavigation(
                        viewModel = viewModel
                    )
                }
            }
        }
    }
}
fun collectChampionsList() {
    _listChampions.value = ChampionDummyData
}
private val _listChampions = MutableStateFlow<List<ChampionInformation>>(emptyList())
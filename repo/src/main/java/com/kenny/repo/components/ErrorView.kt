package com.kenny.repo.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.kenny.base.Background
import com.kenny.repo.uimodels.RepositoriesUiModel

@Composable
fun ErrorView(
    uiState: RepositoriesUiModel
){
    Surface(
        color = Background,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(){
            Text(text = "Error")
            Text(text = uiState.errorMessage )
        }
    }
}
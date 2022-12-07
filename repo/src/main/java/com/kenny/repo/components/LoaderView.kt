package com.kenny.repo.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.kenny.base.Background

@Composable
fun LoaderView() {
    Surface(
        color = Background,
        modifier = Modifier.fillMaxSize()
    ) {
        CircularProgressIndicator()
    }
}
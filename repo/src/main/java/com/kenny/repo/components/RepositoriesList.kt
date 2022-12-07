package com.kenny.repo.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.kenny.base.*
import com.kenny.repo.uimodels.RepositoriesUiModel

@Composable
fun RepositoriesList(
    uiState: RepositoriesUiModel
){
    Surface(
        color = Background,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            uiState.repositories.forEach { repository ->
                Row(
                    modifier = Modifier
                        .clickable(
                            onClick = { },
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier.padding(8.dp, 0.dp),
                        text = repository.name,
                        color = OnPrimary,
                        fontSize = 18.sp,
                        fontStyle = FontStyle.Normal,
                    )
                    repository.visibility?.let {
                        Text(
                            modifier = Modifier.padding(8.dp, 0.dp),
                            text = it,
                            color = Secondary,
                            fontSize = 14.sp,
                            fontStyle = FontStyle.Italic,
                        )
                    }
                }
                Text(
                    modifier = Modifier.padding(8.dp, 0.dp),
                    text = repository.description,
                    color = OnPrimary,
                    fontSize = 14.sp,
                    fontStyle = FontStyle.Italic,
                )
                Divider(
                    modifier = Modifier.padding(0.dp, 5.dp),
                    color = OnSurface,
                    thickness = 1.dp
                )
            }
        }
    }
}
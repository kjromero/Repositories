package com.kenny.repo.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kenny.base.Background
import com.kenny.base.OnPrimary
import com.kenny.repo.uimodels.RepositoriesUiModel
import com.kenny.repo.viewmodels.RepositoriesViewModel


@Composable
fun RecipeList(
    uiState: RepositoriesUiModel,
    viewModel: RepositoriesViewModel,
) {
    Surface(
        color = Background,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
            uiState.repositories.forEach { recipe ->
                Row(
                    modifier = Modifier.padding(16.dp, 5.dp)
                        .clickable(
                            onClick = {  },
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier.padding(8.dp, 0.dp),
                        text = recipe.name,
                        color = OnPrimary,
                        fontSize = 16.sp,
                        fontStyle = FontStyle.Italic,
                    )
                    Text(
                        modifier = Modifier.padding(8.dp, 0.dp),
                        text = recipe.description,
                        color = OnPrimary,
                        fontSize = 16.sp,
                        fontStyle = FontStyle.Italic,
                    )
                }

            }
        }
    }
}
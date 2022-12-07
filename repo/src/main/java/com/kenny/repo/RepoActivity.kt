package com.kenny.repo

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.kenny.base.RepoTheme
import com.kenny.repo.components.ErrorView
import com.kenny.repo.components.LoaderView
import com.kenny.repo.components.RepositoriesList
import com.kenny.repo.uimodels.RepositoriesScreen
import com.kenny.repo.viewmodels.RepositoriesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RepoActivity: AppCompatActivity() {

    private val viewModel: RepositoriesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val uiState by viewModel.data.observeAsState()

            RepoTheme {
                uiState?.let {
                    when (it.screen) {
                        RepositoriesScreen.Loader -> {
                            LoaderView()
                        }
                        RepositoriesScreen.List -> {
                            RepositoriesList(uiState = it)
                        }
                        RepositoriesScreen.Detail -> {
                            LoaderView()
                        }
                        RepositoriesScreen.Error -> {
                            ErrorView(it)
                        }
                    }
                }
            }
        }
        viewModel.getRepositories()
    }

}
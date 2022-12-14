package com.kenny.repo.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kenny.base.viewmodel.BaseViewModel
import com.kenny.repo.domain.usescases.GetRepositoriesUseCase
import com.kenny.repo.uimodels.RepositoriesScreen
import com.kenny.repo.uimodels.RepositoriesUiModel
import com.kenny.repo.usescases.MapRepositoriesDataToRepositoriesUiModelUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

const val KOTLIN_QUERY = "kotlin"

@HiltViewModel
class RepositoriesViewModel @Inject constructor(
    private val getRepositoriesUseCase: GetRepositoriesUseCase,
    private val mapRepositoriesDataToRepositoriesUiModelUsecase: MapRepositoriesDataToRepositoriesUiModelUsecase,
) : BaseViewModel() {

    private val _data = MutableLiveData(RepositoriesUiModel())
    val data = _data as LiveData<RepositoriesUiModel>

    fun getRepositories() {
        disposables.add(
            getRepositoriesUseCase.execute(KOTLIN_QUERY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe {
                    _data.value = data.value?.copy(
                        loading = true,
                        screen = RepositoriesScreen.Loader,
                    )
                }
                .doOnTerminate {
                    _data.value = data.value?.copy(
                        loading = false,
                    )
                }
                .map {
                    mapRepositoriesDataToRepositoriesUiModelUsecase.execute(it)
                }
                .subscribe(
                    {
                        _data.value = data.value?.copy(
                            repositories = it.repositories,
                            screen = RepositoriesScreen.List,
                        )
                    },
                    {
                        _data.value = data.value?.copy(
                            screen = RepositoriesScreen.Error,
                            errorMessage = it.message.toString()
                        )
                    }
                )
        )
    }
}
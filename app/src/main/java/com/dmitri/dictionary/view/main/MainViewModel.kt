package com.dmitri.dictionary.view.main

import com.dmitri.dictionary.model.data.AppState
import com.dmitri.dictionary.viewmodel.BaseViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val interactor: MainInteractor
) : BaseViewModel<AppState>() {
    override fun getData(word: String, isOnline: Boolean) {
        liveDataToObserve.value = AppState.Loading(null)
        compositeDisposable.add(
            interactor.getData(word, isOnline)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribe(
                    {
                        liveDataToObserve.value = it
                    }, {
                        liveDataToObserve.value = AppState.Error(it)
                    }
                )
        )
    }
}
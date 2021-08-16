package com.dmitri.dictionary.view.history.search

import androidx.lifecycle.LiveData
import com.dmitri.dictionary.model.data.AppState
import com.dmitri.core.viewmodel.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HistorySearchViewModel(
    private val interactor: HistorySearchInteractor
) : com.dmitri.core.viewmodel.BaseViewModel<AppState>() {

    private val liveDataForViewToObserve: LiveData<AppState> = _mutableLiveData

    fun subscribe(): LiveData<AppState> {
        return liveDataForViewToObserve
    }

    override fun getData(word: String, isOnline: Boolean) {

        _mutableLiveData.value = AppState.Loading(null)
        cancelJob()
        viewModelCoroutineScope.launch { startInteractor(word, isOnline) }
    }

    //Doesn't have to use withContext for Retrofit call if you use .addCallAdapterFactory(CoroutineCallAdapterFactory()). The same goes for Room
    private suspend fun startInteractor(word: String, isOnline: Boolean) =
        withContext(Dispatchers.IO) {
            _mutableLiveData.postValue(interactor.getDataByWord(word, isOnline))
        }

    override fun handleError(error: Throwable) {
        _mutableLiveData.postValue(AppState.Error(error))
    }

    override fun onCleared() {
        _mutableLiveData.value = AppState.Success(null)
        super.onCleared()
    }
}
package com.dmitri.dictionary.presenter

import com.dmitri.dictionary.model.data.AppState
import com.dmitri.dictionary.view.base.View

interface Presenter<T: AppState, V: View> {
    fun attachView(view: V)

    fun detachView(view: V)

    fun getData(word: String, isOnline: Boolean)
}
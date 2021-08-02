package com.dmitri.dictionary.view.base

import com.dmitri.dictionary.model.data.AppState

interface View {
    fun renderData(appState: AppState)
}
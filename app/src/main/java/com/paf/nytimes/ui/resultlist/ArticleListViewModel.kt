package com.paf.nytimes.ui.resultlist

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ArticleListViewModel() : ViewModel() {
    companion object {
        val TAG: String = ArticleListViewModel::class.java.simpleName
    }

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading


}
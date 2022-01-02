package com.paf.nytimes.ui.search

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SearchViewModel() : ViewModel() {
    companion object {
        val TAG: String = SearchViewModel::class.java.simpleName
    }

    private val _facebookCbChecked = MutableStateFlow(false)
    val facebookCbChecked: StateFlow<Boolean> = _facebookCbChecked

    private val _facebookCbVisible = MutableStateFlow(false)
    val facebookCbVisible: StateFlow<Boolean> = _facebookCbVisible

    fun setSelectedType(position: Int) {
        _facebookCbVisible.value = position == 1
    }

}
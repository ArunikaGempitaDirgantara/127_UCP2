package com.example.ucp2.theme

import androidx.lifecycle.ViewModel
import com.example.ucp2.data.SkripsiUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SkripsiViewModel : ViewModel() {
    private val _stateUI = MutableStateFlow(SkripsiViewModel())
    val stateUI: StateFlow<SkripsiUIState> = _stateUI.asStateFlow()

    fun setContact(listData: MutableList<String>) {
        _stateUI.update { stateSaatIni ->
            stateSaatIni.copy (
                nama = listData[0],
                nim = listData[1],
                fokus = listData[2],
                judul = listData[3]
            )
        }
    }
}
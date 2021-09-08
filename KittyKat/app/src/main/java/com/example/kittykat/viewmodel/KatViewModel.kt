package com.example.kittykat.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kittykat.model.Kat
import com.example.kittykat.repo.KatRepo
import com.example.kittykat.utils.ApiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class KatViewModel : ViewModel()
{
    private val _katState = MutableLiveData<ApiState<List<Kat>>>()
    val katState: LiveData<ApiState<List<Kat>>>
        get() = _katState

    fun fetchKatList(limit: Int)
    {
        viewModelScope.launch(Dispatchers.IO)
        {
            KatRepo.getKatState(limit).collect { katState -> _katState.postValue(katState) }
        }
    }
}
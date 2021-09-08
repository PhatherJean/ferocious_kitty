package com.example.kittykat.repo

import android.util.Log
import com.example.kittykat.repo.remote.RetrofitInstance
import com.example.kittykat.utils.ApiState
import com.example.kittykat.utils.Order
import kotlinx.coroutines.flow.flow

object KatRepo
{
    private const val TAG = "Kat-Repo"

    private val katService by lazy { RetrofitInstance.katService }

    fun getKatState(limit: Int, page: Int = 1, order: Order = Order.DESC) = flow {
        Log.e(TAG, "getKatState: emit(ApiState.Loading)")
        emit(ApiState.Loading)

        Log.e(TAG, "getKatState: KatService.getKatImage(limit, page, order))")
        val katResponse = katService.getKatImages(limit, page, order)
        Log.e(TAG, "getKatState: katResponse = $katResponse")

        val state = if (katResponse.isSuccessful)
        {
            Log.e(TAG, "getKatState: katResponse = $katResponse")
            if (katResponse.body().isNullOrEmpty())
            {
                Log.e(TAG, "getKatState: Failure(\"No data found.\")")
                ApiState.Failure("No Data Found")
            }
            else
            {
                Log.e(TAG, "getKatState: katResponse.body()")
                ApiState.Success(katResponse.body()!!)
            }
        } else
        {
            Log.e(TAG, "getKatState: Failure (\"Error fetching data.\")")
            ApiState.Failure("Error Fetching data")
        }
        Log.e(TAG, "getKatState: emit(state)")
        emit(state)
    }
}
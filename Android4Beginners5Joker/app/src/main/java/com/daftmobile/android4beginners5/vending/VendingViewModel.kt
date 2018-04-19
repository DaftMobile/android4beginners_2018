package com.daftmobile.android4beginners5.vending

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel


class VendingViewModel: ViewModel() {
    private val vendingMachine = ChocoBarVendingMachine()
    private val chocoBarLiveData = MutableLiveData<String>()
    private val depositLiveData = MutableLiveData<String>()
    private val errorLiveData = MutableLiveData<String>()

    fun deposit(): LiveData<String> = depositLiveData
    fun chocoBar(): LiveData<String> = chocoBarLiveData
    fun error(): LiveData<String> = errorLiveData

    init {
        refreshDeposit()
    }

    fun depositCoin() {
        vendingMachine.depositCoin()
        refreshDeposit()
    }

    fun vend(barName: String) {
        val bar = vendingMachine.vend(barName)
        chocoBarLiveData.value = "You vended ${bar.name}"
        refreshDeposit()
    }

    private fun refreshDeposit() {
        depositLiveData.value = "Coins: ${vendingMachine.getCurrentDeposit()}"
    }
}
package com.daftmobile.android4beginners5.vending


class InsufficientFundsException(val coinsNeeded: Int) : Exception("There was a vending error")

class ItemNotFoundException(val itemName: String): Exception("There was a vending error")

class OutOfStockException(val barName: String) : Exception("There was a vending error")
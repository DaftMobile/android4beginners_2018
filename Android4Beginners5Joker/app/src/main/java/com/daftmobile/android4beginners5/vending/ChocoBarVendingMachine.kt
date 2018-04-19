package com.daftmobile.android4beginners5.vending


class ChocoBarVendingMachine {

    private val itemsCount = mutableMapOf(
            Bar("Princess Polo", 4) to 2,
            Bar("Venus", 3) to 3,
            Bar("Silky Way", 2) to 2
    )

    private var deposit = 0

    fun getCurrentDeposit() = deposit

    fun depositCoin() {
        deposit++
    }

    fun vend(itemName: String): Bar {
        val item = itemsCount.keys.find { it.name == itemName } ?: throw ItemNotFoundException(itemName)
        if (itemsCount.getValue(item) <= 0) throw OutOfStockException(item.name)
        if (item.price > deposit) throw InsufficientFundsException(item.price)
        itemsCount[item] = itemsCount.getValue(item) - 1
        deposit -= item.price
        return item.copy()
    }

}
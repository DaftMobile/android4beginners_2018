package android4beginners1

// implements oraz extends w Kotlinie zapisujemy z użyciem operatora :
// jeśli klasa A ma rozszerzać B i jednocześnie implementować interfejsy C i D, podajemy je wszystkie po przecinku, czyli:
// class A : B, C, D { }
// UWAGA - założenia znane z Javy wciąż obowiązują, tj nie istnieje wielokrotne dziedziczenie

interface Account {
    fun alter(amount: Int)
}

// klasy są domyślnie final, stąd open w deklaracji klasy, którą chcemy rozszerzyć
open class PersonalAccount(private var balance: Int) : Account {
    override fun alter(amount: Int) {
        balance += amount
    }

    // metody również są domyślnie final
    open fun withdraw(amount: Int) {
        alter(-amount)
    }
}

class SavingsAccount(balance: Int) : PersonalAccount(balance) {
    override fun withdraw(amount: Int) {
        super.withdraw(amount + FEE)
    }

    // static
    companion object {
        // wszystko zadeklarowane w tym bloku będzie dostępne analogicznie jak pola static w Javie
        const val FEE = 3
    }
}
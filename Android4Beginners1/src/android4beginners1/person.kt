package android4beginners1


/**
 * Zawiera proste pola i metody oraz primary constructor
 */
class Person(initialAge: Int, initialName: String) {
    var age: Int = initialAge  // zmienna
    val name: String = initialName  // stała (final)

    // void birthday() { age++; }
    fun birthday() {
        age++
    }

    // metoda zwracająca wartość w wersji blokowej...
    fun isOfAgeUsingBlockBody(): Boolean {
        return age >= 18
    }
    // ... i skróconej
    fun isOfAgeUsingExpressionBody() = age >= 18

    // metoda przyjmująca parametr z domyślną wartością
    fun timeTravel(distanceInYears: Int = 10) {
        age += distanceInYears
    }
}



/**
 * Zawiera nullowalne pole job i modyfikowalną listę (MutableList) kont
 * Wszystkie pola są zadeklarowane już w konstruktorze
 * Warto zwrócić uwagę na metodę salary() wykorzystującą safe-access operator ?. oraz elvis operator ?:
 */
class PersonWithJobAndAccount(
        var age: Int,
        val name: String,
        var job: Job? = null,
        val accounts: MutableList<Account> = mutableListOf()
) {
    // jeśli job nie jest nullem (job?), zwróć salary, w przeciwnym wypadku ( ?: ) zwróć 0
    fun salary() = job?.salary ?: 0

    fun addAccount(account: Account) {
        accounts.add(account)
    }
}


// data class, czyli klasa z automatyczną implementacją metod equals, hashCode oraz copy
data class Job(val company: String, val salary: Int)


// extension function zadeklarowana poza ciałem klasy
// WAŻNE - extension function nie modyfikują już istniejących klas
fun PersonWithJobAndAccount.isEmployed(): Boolean = this.job != null


fun main(args: Array<String>) {
    // inicjalizacja obiektu nie zawiera słowa kluczowego new
    val boss = Person(28, "Michał")
    boss.birthday()
    boss.isOfAgeUsingBlockBody() == boss.isOfAgeUsingExpressionBody()
    boss.timeTravel()
    boss.timeTravel(-10)

    val dev = PersonWithJobAndAccount(26, "Konrad", Job("DaftMobile", 1000))
    dev.salary()
    dev.addAccount(PersonalAccount(20000))
    dev.isEmployed()

    // operator porównania == w kotlinie wykorzystuje equals()
    println(dev.job == Job("DaftMobile", 1000))  // true
    // operator identyczności === sprawdza, czy porównywane referencje wskazują na ten sam obiekt
    println(dev.job === Job("DaftMobile", 1000))  // false
}

package android4beginners1

fun main(args: Array<String>) {
    val cities: List<String> = listOf("Warszawa", "London")
    cities.add("New York")  // lista jest niemodyfikowalna (List), nie da się zmienić jej zawartości
    cities.removeAt(0)

    val names: MutableList<String> = mutableListOf("Konrad", "Michał", "Weronika")
    names.add("Aleksandra")  // lista jest modyfikowalna (MutableList)...
    names.removeAt(2)
    // ... ale zmienna jest final (val), czyli nie można do niej przypisać nowego obiektu
    names = mutableListOf("Filip")

    val set: Set<Int> = setOf(1, 2, 3)  // prosty zbiór

    val trees: Array<String> = arrayOf("Oak", "Lemon tree")

    // mapy możemy utworzyć używając par (Pair)
    val mapOfMeat: Map<String, String> = mapOf(
            Pair("Cow", "Beef"),
            "Pig" to "Pork"  // a te z kolei możemy tworzyć używając operatora to
    )
}
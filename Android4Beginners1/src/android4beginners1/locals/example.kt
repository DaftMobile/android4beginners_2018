package android4beginners1.locals

fun main(args: Array<String>) {
    val locale: Locale = PolishPluralsLocale("samochód", "samochody", "samochodów")
    val examples = listOf(0, 1, 3, 10, 22)
    for (amount in examples) {
        println("Mam $amount ${locale.localize(amount)}")
    }

    // operator bezpiecznego rzutowania as? (safe-cast)
    // jeśli locale jest typu PolishPluralsLocale, to zrzutuj, jeśli nie, zwróć null (stąd operator ?.)
    println((locale as? PolishPluralsLocale)?.other)

    when (locale) {
        is PolishPluralsLocale -> println(locale.few)
        is EnglishPluralsLocale -> println(locale.other)
        else -> println("Locale is funny")
    }
}
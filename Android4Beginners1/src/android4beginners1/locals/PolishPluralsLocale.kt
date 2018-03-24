package android4beginners1.locals

class PolishPluralsLocale(val one: String, val few: String, val other: String): Locale {

    // when, kotlinowy odpowiednik switch-case, nie musi zawierać parametru
    // może też zwracać wartość, wtedy konieczna jest instrukcja else (poza pewnymi przypadkami)
    override fun localize(amount: Int) = when {
        amount == 1 -> one
        amount % 10 == 2 || amount % 10 == 3 || amount % 10 == 4 -> few
        else -> other
    }
}
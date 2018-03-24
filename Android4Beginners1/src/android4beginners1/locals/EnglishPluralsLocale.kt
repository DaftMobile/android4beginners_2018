package android4beginners1.locals


class EnglishPluralsLocale(val one: String, val other: String): Locale {

    // if w kotlinie może zwracać wartość, wtedy konieczna jest instrukcja else
    override fun localize(amount: Int) = if (amount == 1) one else other
}
[![Android 4 Beginners Spring 2018](assets/logo.png)](https://github.com/DaftMobile/android4beginners_2018)

![Platforms](https://img.shields.io/badge/platforms-Android-green.svg)
![License: Apache 2.0](https://img.shields.io/badge/License-Apache%202.0-blue.svg)

# Zajęcia Android 4 Beginners – WEiTI, wiosna 2018

## Zajęcia

### Zajęcia 1. Hello, world! from Kotlin

Było dużo o charakterystycznych elementach składni Kotlina, ale też sporo o nowych mechanizmach (immutable collections, extension functions). W sekcji [Materiały](#Materiały) jest link do ćwiczeń z Kotlina (Kotlin Koans). Polecam, jeśli chcecie poćwiczyć przed następnymi zajęciami.

W folderze Android4Beginners1 znajdziecie kod z pierwszych zajęć wzbogacony o komentarze, które uznałem za istotne.

### Zajęcia 2. Pierwszy ekran

Opowiedzieliśmy sobie, czym jest `Activity` i na czym polega jego cykl życia. Załączam schemat z prezentacji.
![Activity lifecycle](assets/lifecycle.png)

Było też o tworzeniu layoutu poprzez dodawanie do niego widoków w Layout Editorze oraz o tym, jak te widoki przedstawione są w XMLu. Więcej możecie o tym poczytać [tutaj](https://developer.android.com/training/basics/firstapp/building-ui.html). Nie zabrakło informacji o tym, jak reagować na eventy związane z tapowaniem widoków. 

Na koniec wspomnieliśmy też o tym, że `Context` istnieje i nie należy się go bać, mimo że jest ogromny i wszechpotężny ;]

Jak poprzednio, w folderze Android4Beginners2 znajdziecie kod z zajęć wzbogacony o komentarze.

### Zajęcia 3. 10000 urządzeń, jeden kod

Było o dwóch popularnych layoutach: `LinearLayout` oraz `RelativeLayout`. Wyjaśniłem, jak działają, a także jak wykorzystywać `gravity`. W folderze Android4Beginners3 jest projekt, w którym tymi layoutami można się pobawić.

Następnie powiedzieliśmy sobie o *resource*'ach oraz o *resource qualifiers*, dzięki którym możemy lokalizować aplikacje lub przystosowywać je do różnych ekranów. Przykładowe zastosowanie znajdziecie w rozwiązaniu pracy domowej nr 1. Dużo więcej informacji na ten temat - gdybyście ich potrzebowali - znajdziecie w [android guide](https://developer.android.com/guide/topics/resources/index.html).

W kolejnej części zajęliśmy się `Intentami` oraz otwieraniem innych `Activity`. Pokazałem też, jak opakowywać w `Intentach` dodatkowe dane i przenosić je między różnymi `Activity`. Zakładam, że to, co stworzyliście w trakcie zajęć, wystarczy jako notatki. Gdyby jednak ktoś szukał pomocy, polecam [ten](https://developer.android.com/training/basics/firstapp/starting-activity.html#kotlin) fragment przewodnika.

Na koniec wspomnieliśmy o tym, że korzystamy z *supportu*, by minimalizować wpływ fragmentacji na nasze życie (przynajmniej w aspekcie programowania na Androida).

Przypominam, że w razie niepewności bądź pytań związanych z materiałem z zajęć można pisać na adres znajdujący się na końcu readme :)

## Materiały

- [Kotlin Koans](http://kotlinlang.org/docs/tutorials/koans.html)
- [Android Developers](https://developer.android.com/index.html)

## Kontakt

- [E-mail](mailto:konrad.kowalewski@daftcode.pl)

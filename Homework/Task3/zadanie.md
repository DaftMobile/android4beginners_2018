## Zadanie
Zadanie domowe rozszerza funkcjonalność aplikacji *Robot book*, którą zajmowaliśmy się na zajęciach. Jeśli byliście nieobecni, pobierzcie projekt z folderu Android4Beginners4ViewModel. Celem pracy domowej jest dodanie funkcji sortowania robotów po imieniu.
Do aplikacji należy dodać **Options menu** zawierające `<item>` **SORT**, który po kliknięciu umożliwi wybór sposobu sortowania (rosnąco bądź malejąco). Informację o tym, jak zrobić takie menu znajdziecie w sekcji [Wskazówki](#Wskazówki).
Przykład działania aplikacji można zobaczyć na dołączonym ![filmiku](app.mp4).

Pamiętajcie, że po wyborze sposobu sortowania kolejne dodawane elementy powinny lądować w odpowiednim miejscu, niekoniecznie na końcu.

**Za bonusowe punkty** można także zaimplementować filtrowanie robotów po ich humorze \[HAPPY|SAD\] (także z użyciem options menu).

## Wskazówki

1. Stwórzcie odpowiednie *menu*. Aby kliknięcie na `MenuItem` powodowało rozwinięcie dostępnych opcji, należy użyć zagnieżdżonego menu, czyli w parze znaczników `<item></item>` należy umieścić kolejny znacznik `<menu></menu>`, jak w drugim przykładzie [tutaj](https://developer.android.com/guide/topics/ui/menus.html#xml):
```xml
<menu xmlns:android="http://schemas.android.com/apk/res/android">
    <item android:id="@+id/file" android:title="@string/file" >
        <menu>
            <item android:id="@+id/create_new"
                  android:title="@string/create_new" />
            <item android:id="@+id/open"
                  android:title="@string/open" />
        </menu>
    </item>
</menu>
```
2. Menu należy dodać do `Activity` nadpisując metodę `onCreateOptionsMenu(Menu)`, a tapnięcie na `MenuItem` obsłużyć nadpisując metodę `onOptionsItemSelected(MenuItem)`. Więcej na ten temat można znaleźć w dalszej części guide'a pod linkiem z poprzedniego punktu.
3. Aby sortować elementy, można użyć metody `MutableList.sortWith(Comparator)` albo użyć innej sortowalnej kolekcji dostępnej w Javie.
4. Proponuję wykorzystać klasę `ExternalSourceRobotsViewModel` jako **ViewModel** wspomaganą przez `RobotsDataSource`. Aby najlepiej wykorzystać potencjał Androidowej klasy `ViewModel` (więcej informacji o tym komponencie możecie znaleźć w podsumowaniu zajęć #4 w README repozytorium), pamiętajcie, żeby tak instancjonować obiekt w `onCreate()`:
```kotlin
viewModel = ViewModelProviders.of(this).get(ExternalSourceRobotsViewModel::class.java)
viewModel.getItems().observe(this, Observer {
    // update UI
})
```
5. Żeby łatwo umieścić kolejne elementy w nowej linii, użyjcie metody `.joinToString("\n")` na liście robotów.

Piszcie, jeśli będziecie mieli jakieś pytania. Powodzenia!

## Termin
Spakowany folder .zip z projektem należy wysłać (jakkolwiek) standardowo do końca wtorku (17.04.2018) na adres [email](mailto:konrad.kowalewski+homework3@daftcode.pl). Usunięcie folderu app/build przed spakowaniem nie pomoże, ale i nie zaszkodzi ;).


## Zadanie
Zadanie polega na stworzeniu aplikacji z dwoma ekranami. Na pierwszym z nich będzie można wpisać numer pokemona w pokedeksie do pola tekstowego oraz tapnąć przycisk *INFO*. Tapnięcie powinno spowodować pobranie informacji o tym pokemonie z API [Switter](https://github.com/DaftMobile/switter) i wyświetlenie ich na nowym ekranie.

Nie wymagam stosowania komponentów `LiveData` oraz `ViewModel`, choć do tego zachęcam. W projekcie umieściłem szkielet `ViewModelu`. 

## Wskazówki
Pobierzcie projekt A4BHomework4/. Znajdziecie tam gotowe widoki oraz szkielet `ViewModelu`.

1. Do komunikacji z API wykorzystajcie **Retrofit**. Większość konfiguracji pod Swittera macie już w materiałach z zajęć nr 5. Skorzystajcie z [endpointu](https://github.com/DaftMobile/switter#pokemon-peek-by-number) `/api/pokemon/:number/peek`. Żeby przekazać parametr do ścieżki, wykorzystujemy *wildcard* w ścieżce (np. `/api/users/{id}`) oraz w metodzie określamy parametr adnotacją `@Path("id")`.
2. Pamiętajcie, żeby Activity było najprostsze, jak to możliwe. Musi wiedzieć, jak obsłużyć button i jak pokazać informacje o pokemonie.
3. Ponieważ API zwraca dane w formacie JSON, warto wykorzystać **Gson** do deserializacji. Aby połączyć Gson i Retrofit, przedstawiam potrzebne do tego kroki na przykładzie endpointu `/api/joke`.
  * JSON
```json
{
  "content": "This is a joke"
}
```
  * data class z properties odpowiadającymi JSONowi
```kotlin
data class Joke(val content: String)
```
  * Podpięcie Gsona jako konwertera do response z API w Retroficie
```kotlin
Retrofit.Builder()
    .baseUrl("https://switter.int.daftcode.pl/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()
```
  * Określenie, że call na endpoint `/api/joke` zwraca obiekt `Joke` w response
```kotlin
@GET("/api/joke")
fun joke(@Header("x-device-uuid") uuid: String): Call<Joke>
```
4. Jeśli chcecie przekazać `data class` zawierające informacje o pokemonie do otwieranego Activity, pamiętajcie, żeby klasa ta implementowała interfejs `java.util.Serializable`. Tylko wtedy będzie można przekazać ją w `Intencie` jako *extra*.
5. Przypominam, że do komunikacji z Internetem potrzebne jest odpowiednie *permission*.

Piszcie, jeśli będziecie mieli jakieś pytania. Powodzenia!

## Termin
Spakowany folder .zip z projektem należy wysłać (jakkolwiek) standardowo do końca wtorku (24.04.2018) na adres [email](mailto:konrad.kowalewski+homework4@daftcode.pl).


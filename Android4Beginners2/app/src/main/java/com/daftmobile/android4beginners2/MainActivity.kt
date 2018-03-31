package com.daftmobile.android4beginners2

import android.app.Activity
import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

// rozszerzamy klasę activity, żeby stworzyć własny ekran
// MainActivity jest zadeklarowane w pliku AndroidManifest.xml. Jeśli zżera Was ciekawość, możecie tam zajrzeć ;)
class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        log("onCreate()")

        // referencję do widoków uzyskujemy, odwołując się do pola o tej samej nazwie, jak ID interesującego nas widoku, np:
        myTextView.text = "Cześć!"
        // myTextView to ID widoku zadeklarowane w activity_main.xml
        // możemy dzięki temu dynamicznie zmieniać właściwości i stan widoku, np text w TextView

        // click listener w formie wyrażenia lambda
        funnyButton.setOnClickListener { view: View ->
            myTextView.text = "Kliknięto"
        }

        // click listener w formie referencji do metody
        myTextView.setOnClickListener(this::onTextViewClicked)
    }

    // wszystkie te nadpisane metody są wywoływane przy zmianie stanu activity, to tzw lifecycle callbacks
    // powłączajcie i powyłączajcie apkę, żeby przyponieć sobie, jak działają
    override fun onStart() {
        super.onStart()
        log("onStart()")
    }

    override fun onResume() {
        super.onResume()
        log("onResume()")
    }

    override fun onRestart() {
        super.onRestart()
        log("onRestart()")
    }

    override fun onPause() {
        super.onPause()
        log("onPause()")
    }

    override fun onStop() {
        super.onStop()
        log("onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        log("onDestroy()")
    }

    // a to nasz listener, do którego referencję podajemy w setOnClickListener
    private fun onTextViewClicked(view: View) {
        // view to referencja do obiektu, który został kliknięty
        log(view.toString())
        // a tak budujemy dialog
        AlertDialog.Builder(this)
                .setTitle("Hello") // prosty tytuł
                .setMessage("Jestem dialogiem") // prosty message
                .show() // pamiętajcie o tej metodzie, inaczej dialog się nie pokaże
    }
}

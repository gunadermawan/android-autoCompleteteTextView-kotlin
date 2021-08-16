package com.gunder.autocompletetetextview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.Toast
import org.intellij.lang.annotations.Language

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        inisialisasi variabel
        val autoTextView = findViewById<AutoCompleteTextView>(R.id.autoComplete)
//        get array dari strings
        val languages = resources.getStringArray(R.array.Languages)
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1, languages
        )
        autoTextView.setAdapter(adapter)

        val button = findViewById<Button>(R.id.btnsubmit)
        if (button != null) {
            button.setOnClickListener(View.OnClickListener {
                val enteredText = getString(R.string.submitLanguage) + " " + autoTextView.text
                Toast.makeText(this@MainActivity, enteredText, Toast.LENGTH_SHORT).show()
            })
        }
    }
}
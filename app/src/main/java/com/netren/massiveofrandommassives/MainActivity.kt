package com.netren.massiveofrandommassives

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val arraySizeEditText = findViewById<EditText>(R.id.arraySizeEditText)
        val arrayShowTextView = findViewById<TextView>(R.id.arrayShowTextView)
        val showRandomArrayButton = findViewById<Button>(R.id.showRandomArrayButton)

        showRandomArrayButton.setOnClickListener {
            val arraySizeEditTextValue:Int

            arraySizeEditText.text.toString().apply {
                arraySizeEditTextValue = if (this != "")
                    this.toInt()
                else
                    0
            }

            val randomMassive = MassiveMaker().getMassiveOfRandomMassives(
                n = arraySizeEditTextValue
            )

            Outputer().output(
                massive = randomMassive, textView = arrayShowTextView
            )
        }
    }
}
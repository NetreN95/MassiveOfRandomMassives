package com.netren.massiveofrandommassives

import android.widget.TextView

class Outputer {
    fun output(massive: ArrayList<ArrayList<Int>>, textView: TextView) {
        val textOfMainArray =   "result massive:\n" +
                                "size = ${massive.size}\n"

        var textOfSecondaryArrays = ""

        var textOfValuesOfArray: String
        var numberOfElement = 0

        massive.forEach {
            numberOfElement++

            textOfSecondaryArrays += "\n\n"
            textOfSecondaryArrays += "   Array №$numberOfElement:\n"
            textOfSecondaryArrays += "   size = ${it.size}\n"

            textOfValuesOfArray=""

            it.forEach {
                if (textOfValuesOfArray !="")
                    textOfValuesOfArray += ", "

                textOfValuesOfArray += it
            }

            textOfSecondaryArrays += "   values = [$textOfValuesOfArray]"
        }

        val text = textOfMainArray + textOfSecondaryArrays

        textView.text = text
    }
}
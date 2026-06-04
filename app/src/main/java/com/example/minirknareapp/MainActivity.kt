package com.example.minirknareapp

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager
import org.mozilla.javascript.Context
import org.mozilla.javascript.Scriptable

class MainActivity : AppCompatActivity() {

    private lateinit var arbetetsTV: TextView
    private lateinit var resultatTV: TextView

    private var arbetets = ""



    private fun initTextViews() {
        arbetetsTV = findViewById(R.id.arbetesTextview)
        resultatTV = findViewById(R.id.resultatTextView)
    }

    private fun setArbetets(givenValue: String) {
        arbetets += givenValue
        arbetetsTV.text = arbetets
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_main)

        initTextViews()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets



        }
    }


    fun equalsOnClick(view: View) {
        try {
            val rhino = Context.enter()
            rhino.optimizationLevel = -1

            val scope: Scriptable = rhino.initStandardObjects()

            val result = rhino.evaluateString(
                scope,
                arbetets,
                "JavaScript",
                1,
                null
            )

            resultatTV.text = result.toString()

            Context.exit()
        } catch (e: Exception) {
            resultatTV.text = getString(R.string.error)
        }
    }
    fun clearOnClick(view: View) {
        arbetetsTV.setText("");
        arbetets = "";
        resultatTV.setText("");
    }
    fun bracketsOnClick(view: View) {
        setArbetets("()");
    }


    fun divisionOnClick(view: View) {
        setArbetets("/");
    }
    fun sevenOnClick(view: View) {
        setArbetets("7");
    }
    fun eightOnClick(view: View) {
        setArbetets("8");
    }
    fun nineOnClick(view: View) {
        setArbetets("9");
    }
    fun multipleOnClick(view: View) {
        setArbetets("*");
    }
    fun fourOnClick(view: View) {
        setArbetets("4");
    }
    fun fiveOnClick(view: View) {
        setArbetets("5");
    }
    fun sixOnClick(view: View) {
        setArbetets("6");
    }
    fun negativeOnClick(view: View) {
        setArbetets("-");
    }
    fun oneOnClick(view: View) {
        setArbetets("1");
    }
    fun twoOnClick(view: View) {
        setArbetets("2");
    }
    fun threeOnClick(view: View) {
        setArbetets("3");
    }
    fun addOnClick(view: View) {
        setArbetets("+");
    }
    fun dotOnClick(view: View) {
        setArbetets(".");
    }
    fun zeroOnClick(view: View) {
        setArbetets("0");
    }

}
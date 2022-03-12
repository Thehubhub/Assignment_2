package com.example.recyclerviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var textView: TextView
    var gameState: String? = null
    private val STATE_KEY= "STATE_KEY"
    private val TEXT_VIEW_KEY = "TEXT_VIEW_KEY"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fragmentNavigation(supportFragmentManager, FirstFragment.newInstance())

        gameState = savedInstanceState?.getString(STATE_KEY)
        setContentView(R.layout.activity_main)
//        textView = findViewById(R.id.)
    }


        override fun onSaveInstanceState(outState : Bundle) {
            outState?.run {
                putString(STATE_KEY, gameState)
                putString(TEXT_VIEW_KEY, textView.text.toString())
            }
            super.onSaveInstanceState(outState)
        }


    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        savedInstanceState?.getString("TEXT_VIEW_KEY", TEXT_VIEW_KEY)

        }

}
package com.example.recyclerviewkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_new.*

class NewActivity : AppCompatActivity() {
    companion object {
        val MOVIE_NAME = "movie_passed"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)

        val movie = intent.getParcelableExtra(MOVIE_NAME) as ExampleItem
        textView.text = movie.toString()
    }
}
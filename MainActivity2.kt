package com.example.multiplicationapp

import android.os.Bundle
import android.view.animation.AlphaAnimation
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    private var petHealth = 100
    private var petHunger = 50
    private var petCleanLiness = 50

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // Get the button and text view
        val btnFeed = findViewById<Button>(R.id.BtnFeed)
        val btnClean = findViewById<Button>(R.id.BtnClean)
        val btnHappy = findViewById<Button>(R.id.BtnHappy)
        val txtHunger = findViewById<EditText>(R.id.txt_hunger_value)
        val txtClean = findViewById<EditText>(R.id.txt_clean_value)
        val txtHappy = findViewById<EditText>(R.id.txt_happy)
        val petImage = findViewById<ImageView>(R.id.imageView2)

        // Set the initial text values
        txtHunger.setText(petHunger.toString())
        txtClean.setText(petCleanLiness.toString())
        txtHappy.setText(petHealth.toString())

        // Handle button clicks
        btnFeed.setOnClickListener {
            petHunger -= 10
            petHealth += 10
            petHunger += 5
            txtHunger.setText(petHunger.toString())
            animateImageChange(petImage, R.drawable.images)
        }

        btnClean.setOnClickListener {
            petCleanLiness += 10
            petHealth += 10
            txtClean.setText(petCleanLiness.toString())
            animateImageChange(petImage, R.drawable.bathing_dog)
        }

        btnHappy.setOnClickListener {
            petHealth += 10
            petHunger += 5
            petCleanLiness -= 5
            txtHappy.setText(petHealth.toString())
            animateImageChange(petImage, R.drawable.happy_dog)
        }
    }

    private fun animateImageChange(imageView: ImageView, newImageResource: Int) {
        val animation = AlphaAnimation(0.0f, 1.0f)
        animation.duration = 500
        animation.fillAfter =true
        imageView.startAnimation(animation)
        imageView.setImageResource(newImageResource)
    }
}


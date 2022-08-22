package com.example.triqui

import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.triqui.utils.TicTacToeConsole

class MainActivity : AppCompatActivity() {

    private val one by lazy<ConstraintLayout> { findViewById(R.id.one) }
    private val two by lazy<ConstraintLayout> { findViewById(R.id.two) }
    private val three by lazy<ConstraintLayout> { findViewById(R.id.three) }
    private val four by lazy<ConstraintLayout> { findViewById(R.id.four) }
    private val five by lazy<ConstraintLayout> { findViewById(R.id.five) }
    private val six by lazy<ConstraintLayout> { findViewById(R.id.six) }
    private val seven by lazy<ConstraintLayout> { findViewById(R.id.seven) }
    private val eight by lazy<ConstraintLayout> { findViewById(R.id.eight) }
    private val nine by lazy<ConstraintLayout> { findViewById(R.id.nine) }

    lateinit var animationScale: Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        animationScale = AnimationUtils.loadAnimation(this, R.anim.button_choice_small)
        setListeners(animationScale)
        val ticTacToeConsole = TicTacToeConsole()
    }

    private fun setListeners(animationScale: Animation) {
        one.setOnClickListener {
            it.startAnimation(animationScale)
        }
        two.setOnClickListener {
            it.startAnimation(animationScale)
        }
        three.setOnClickListener {
            it.startAnimation(animationScale)
        }
        four.setOnClickListener {
            it.startAnimation(animationScale)
        }
        five.setOnClickListener {
            it.startAnimation(animationScale)
        }
        six.setOnClickListener {
            it.startAnimation(animationScale)
        }
        seven.setOnClickListener {
            it.startAnimation(animationScale)
        }
        eight.setOnClickListener {
            it.startAnimation(animationScale)
        }
        nine.setOnClickListener {
            it.startAnimation(animationScale)
        }
    }
}
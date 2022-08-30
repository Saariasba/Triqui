package com.example.triqui

import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.flatdialoglibrary.dialog.FlatDialog
import com.example.triqui.utils.TicTacToeConsole
import com.example.triqui.viewmodels.MainViewModel


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

    private val oneImage by lazy<ImageView> { findViewById(R.id.image_one) }
    private val twoImage by lazy<ImageView> { findViewById(R.id.image_two) }
    private val threeImage by lazy<ImageView> { findViewById(R.id.image_three) }
    private val fourImage by lazy<ImageView> { findViewById(R.id.image_four) }
    private val fiveImage by lazy<ImageView> { findViewById(R.id.image_five) }
    private val sixImage by lazy<ImageView> { findViewById(R.id.image_six) }
    private val sevenImage by lazy<ImageView> { findViewById(R.id.image_seven) }
    private val eightImage by lazy<ImageView> { findViewById(R.id.image_eight) }
    private val nineImage by lazy<ImageView> { findViewById(R.id.image_nine) }

    private val reset by lazy<Button> { findViewById(R.id.reset) }
    private val exit by lazy<Button> { findViewById(R.id.exit) }
    private val difficulty by lazy<Button> { findViewById(R.id.difficulty) }


    lateinit var animationScale: Animation
    lateinit var viewModel: MainViewModel

    val ticTacToeConsole = TicTacToeConsole()

    var turn = false

    var result: String? = null

    var difficultyState: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        setListeners(animationScale)
    }

    private fun init() {
        animationScale = AnimationUtils.loadAnimation(this, R.anim.button_choice_small)
        viewModel = MainViewModel()
    }

    private fun setListeners(animationScale: Animation) {
        one.setOnClickListener {
            it.startAnimation(animationScale)
            executeOperation(1)
        }
        two.setOnClickListener {
            it.startAnimation(animationScale)
            executeOperation(2)
        }
        three.setOnClickListener {
            it.startAnimation(animationScale)
            executeOperation(3)
        }
        four.setOnClickListener {
            it.startAnimation(animationScale)
            executeOperation(4)
        }
        five.setOnClickListener {
            it.startAnimation(animationScale)
            executeOperation(5)
        }
        six.setOnClickListener {
            it.startAnimation(animationScale)
            executeOperation(6)
        }
        seven.setOnClickListener {
            it.startAnimation(animationScale)
            executeOperation(7)
        }
        eight.setOnClickListener {
            it.startAnimation(animationScale)
            executeOperation(8)
        }
        nine.setOnClickListener {
            it.startAnimation(animationScale)
            executeOperation(9)
        }
        reset.setOnClickListener {
            it.startAnimation(animationScale)
            Toast.makeText(this, "Reset", Toast.LENGTH_SHORT).show()
            ticTacToeConsole.reset()
            clear()
        }
        exit.setOnClickListener {
            it.startAnimation(animationScale)
            onBackPressed()
        }
        difficulty.setOnClickListener {
            it.startAnimation(animationScale)
            dialogMenu()
        }
    }

    private fun dialogMenu() {
        val flatDialog = FlatDialog(this@MainActivity)
        flatDialog.setTitle("Dificultad")
            .setSubtitle("Seleccione su nivel de dificultad")
            .setFirstButtonText("EASY")
            .setSecondButtonText("MEDIUM")
            .setThirdButtonText("HARD")
            .isCancelable(true)
            .withFirstButtonListner {
                Toast.makeText(this, "EASY", Toast.LENGTH_SHORT).show()
                ticTacToeConsole.reset()
                clear()
                flatDialog.dismiss()
            }
            .withSecondButtonListner {
                Toast.makeText(this, "MEDIUM", Toast.LENGTH_SHORT).show()
                ticTacToeConsole.reset()
                clear()
                flatDialog.dismiss()
            }
            .withThirdButtonListner {
                Toast.makeText(this, "HARD", Toast.LENGTH_SHORT).show()
                ticTacToeConsole.reset()
                clear()
                flatDialog.dismiss()
            }
            .show()
    }

    private fun executeOperation(position: Int) {
        if (ticTacToeConsole.reportWinner() > 9) {
            checkFinish()
        } else {
            if (!checkBoard(position)) {
                paintV2(position)
                val move = ticTacToeConsole.TicTacToeConsoleV2(position)
                paintV2(move)
                checkFinish()
            } else {
                Toast.makeText(this, "Illegal Move", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun checkFinish() {
        when (ticTacToeConsole.reportWinner()) {
            10 -> result = "It's a tie."
            11 -> result = "Humans Player Wins!!!!"
            12 -> result = "Computer Player Wins!!!!"
        }
        if (!result.isNullOrEmpty()) {
            Toast.makeText(this, result.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    private fun checkBoard(position: Int): Boolean {
        val board = ticTacToeConsole.checkBoard()
        return board[position - 1] == 'X' || board[position - 1] == 'O'
    }

    private fun clear() {
        oneImage.setImageDrawable(null)
        twoImage.setImageDrawable(null)
        threeImage.setImageDrawable(null)
        fourImage.setImageDrawable(null)
        fiveImage.setImageDrawable(null)
        sixImage.setImageDrawable(null)
        sevenImage.setImageDrawable(null)
        eightImage.setImageDrawable(null)
        nineImage.setImageDrawable(null)
        result = null
    }

    private fun paintV2(position: Int) {
        val image =
            if (turn) resources.getDrawable(R.drawable.circle) else resources.getDrawable(R.drawable.cross)
        when (position) {
            1 -> oneImage.setImageDrawable(image)
            2 -> twoImage.setImageDrawable(image)
            3 -> threeImage.setImageDrawable(image)
            4 -> fourImage.setImageDrawable(image)
            5 -> fiveImage.setImageDrawable(image)
            6 -> sixImage.setImageDrawable(image)
            7 -> sevenImage.setImageDrawable(image)
            8 -> eightImage.setImageDrawable(image)
            9 -> nineImage.setImageDrawable(image)
        }
        turn = !turn
    }
}
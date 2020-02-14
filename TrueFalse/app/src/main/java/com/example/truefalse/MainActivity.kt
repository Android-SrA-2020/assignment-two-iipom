package com.example.truefalse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val questionBank = listOf(
        Question(R.string.question_1, false),
        Question(R.string.question_2, true),
        Question(R.string.question_3, true),
        Question(R.string.question_4, false),
        Question(R.string.question_5, false),
        Question(R.string.question_6, true),
        Question(R.string.question_7, false),
        Question(R.string.question_8, true),
        Question(R.string.question_9, false),
        Question(R.string.question_10, false),
        Question(R.string.question_11, false),
        Question(R.string.question_12, true),
        Question(R.string.question_13, false),
        Question(R.string.question_14, true),
        Question(R.string.question_15, false),
        Question(R.string.question_16, false),
        Question(R.string.question_17, true),
        Question(R.string.question_18, false),
        Question(R.string.question_19, false),
        Question(R.string.question_20, true))

    private var questionIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.question_text).setText(questionBank[questionIndex].resourceID)

        // Changes the current question to the next one, wraps around when it hits the last one
        findViewById<Button>(R.id.next_button).setOnClickListener{
            questionIndex = (questionIndex + 1) % 20
            updateQuestion()
        }

        // Changes the current question to the previous one, wraps around when it hits the first one
        findViewById<Button>(R.id.prev_button).setOnClickListener{
            // I tried to come up with a better solution to wrap around
            // the index when decreasing, but I couldn't work it out
            if (questionIndex == 0) {
                questionIndex = questionBank.size - 1
            } else {
                questionIndex--
            }

            updateQuestion()
        }

        // Checks if you were correct or not when pressing the 'true' button
        findViewById<Button>(R.id.true_button).setOnClickListener{
            checkAnswer(true)
        }

        // Checks if you were correct or not when pressing the 'false' button
        findViewById<Button>(R.id.false_button).setOnClickListener{
            checkAnswer(false)
        }
    }

    /*
        Checks to see whether the answer is correct, or not, for the current question
        @param answer the answer provided
     */
    private fun checkAnswer(answer: Boolean) {
        if (answer == questionBank[questionIndex].answer) {
            Toast.makeText(applicationContext, "That is correct!", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(applicationContext, "That is incorrect!", Toast.LENGTH_LONG).show()
        }
    }

    /*
        Updates the text displayed to the qustion index
     */
    private fun updateQuestion() {
        findViewById<TextView>(R.id.question_text).setText(questionBank[questionIndex].resourceID)
    }
}

package com.example.flagquiz

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_questions.*

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {
    private var mCurrentPosition: Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswers: Int = 0
    private var mUserName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mUserName = intent.getStringExtra(Constants.USER_NAME)

        mQuestionsList = Constants.getQuestions()

        setQuestion()

        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)

        btn_submit.setOnClickListener(this)
    }

    private fun setQuestion() {
        btn_submit.isEnabled = false
        val question = mQuestionsList!![mCurrentPosition - 1]

        defaultOptionsView()

        if (mCurrentPosition == mQuestionsList!!.size) {
            btn_submit.text = "FINISH"
        } else {
            btn_submit.text = "SUBMIT"
        }

        progress_bar.progress = mCurrentPosition
        tv_progress.text = "$mCurrentPosition" + "/" + progress_bar.max

        tv_question.text = question!!.question
        iv_image.setImageResource(question.image)

        tv_option_one.text = question.optionOne
        tv_option_one.isClickable = true
        tv_option_two.text = question.optionTwo
        tv_option_two.isClickable = true
        tv_option_three.text = question.optionThree
        tv_option_three.isClickable = true
        tv_option_four.text = question.optionFour
        tv_option_four.isClickable = true
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tv_option_one -> {
                selectedOptionView(tv_option_one, selectedOptionNumber = 1)
                btn_submit.isEnabled = true
            }
            R.id.tv_option_two -> {
                selectedOptionView(tv_option_two, selectedOptionNumber = 2)
                btn_submit.isEnabled = true
            }
            R.id.tv_option_three -> {
                selectedOptionView(tv_option_three, selectedOptionNumber = 3)
                btn_submit.isEnabled = true
            }
            R.id.tv_option_four -> {
                selectedOptionView(tv_option_four, selectedOptionNumber = 4)
                btn_submit.isEnabled = true
            }
            R.id.btn_submit -> {
                if (mSelectedOptionPosition == 0) {
                    mCurrentPosition++

                    when {
                        mCurrentPosition <= mQuestionsList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList!!.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else {
                    tv_option_one.isClickable = false
                    tv_option_two.isClickable = false
                    tv_option_three.isClickable = false
                    tv_option_four.isClickable = false

                    val question = mQuestionsList?.get(mCurrentPosition - 1)

                    if (question!!.correctAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    } else {
                        mCorrectAnswers++
                    }

                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if (mCurrentPosition == mQuestionsList!!.size) {
                        btn_submit.text = "FINISH"
                    } else {
                        btn_submit.text = "NEXT QUESTION"
                    }

                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()

        options.add(0, tv_option_one)
        options.add(1, tv_option_two)
        options.add(2, tv_option_three)
        options.add(3, tv_option_four)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> {
                tv_option_one.background = ContextCompat.getDrawable(this, drawableView)
                tv_option_one.setTextColor(Color.parseColor("#363A43"))
                tv_option_one.setTypeface(tv_option_one.typeface, Typeface.BOLD)
            }
            2 -> {
                tv_option_two.background = ContextCompat.getDrawable(this, drawableView)
                tv_option_two.setTextColor(Color.parseColor("#363A43"))
                tv_option_two.setTypeface(tv_option_two.typeface, Typeface.BOLD)
            }
            3 -> {
                tv_option_three.background = ContextCompat.getDrawable(this, drawableView)
                tv_option_three.setTextColor(Color.parseColor("#363A43"))
                tv_option_three.setTypeface(tv_option_three.typeface, Typeface.BOLD)
            }
            4 -> {
                tv_option_four.background = ContextCompat.getDrawable(this, drawableView)
                tv_option_four.setTextColor(Color.parseColor("#363A43"))
                tv_option_four.setTypeface(tv_option_four.typeface, Typeface.BOLD)
            }
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNumber: Int) {
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNumber

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)
    }
}
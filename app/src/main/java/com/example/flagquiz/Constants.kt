package com.example.flagquiz

object Constants {
    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()
        val question = "What country does this flag belongs to?"

        val questionOne = Question(
            1,
            question,
            R.drawable.flag_argentina,
            "Argentina",
            "Australia",
            "Armenia",
            "Austria",
            1
        )

        questionsList.add(questionOne)

        val questionTwo = Question(
            2,
            question,
            R.drawable.flag_australia,
            "Angola",
            "Austria",
            "Australia",
            "Armenia",
            3
        )

        questionsList.add(questionTwo)

        val questionThree = Question(
            3,
            question,
            R.drawable.flag_brazil,
            "Belarus",
            "Belize",
            "Brunei",
            "Brazil",
            4
        )

        questionsList.add(questionThree)

        val questionFour = Question(
            4,
            question,
            R.drawable.flag_belgium,
            "Bahamas",
            "Belgium",
            "Barbados",
            "Belize",
            2
        )

        questionsList.add(questionFour)

        val questionFive = Question(
            5,
            question,
            R.drawable.flag_fiji,
            "Gabon",
            "France",
            "Fiji",
            "Finland",
            3
        )

        questionsList.add(questionFive)

        val questionSix = Question(
            6,
            question,
            R.drawable.flag_germany,
            "Germany",
            "Georgia",
            "Greece",
            "none of these",
            1
        )

        questionsList.add(questionSix)

        val questionSeven = Question(
            7,
            question,
            R.drawable.flag_denmark,
            "Dominica",
            "Egypt",
            "Denmark",
            "Ethiopia",
            3
        )

        questionsList.add(questionSeven)

        val questionEight = Question(
            8,
            question,
            R.drawable.flag_india,
            "Ireland",
            "Iran",
            "Hungary",
            "India",
            4
        )

        questionsList.add(questionEight)

        val questionNine = Question(
            9,
            question,
            R.drawable.flag_new_zealand,
            "Australia",
            "New Zealand",
            "Tuvalu",
            "United States of America",
            2
        )

        questionsList.add(questionNine)

        val questionTen = Question(
            10,
            question,
            R.drawable.flag_kuwait,
            "Kuwait",
            "Jordan",
            "Sudan",
            "Palestine",
            1
        )

        questionsList.add(questionTen)

        return questionsList
    }
}
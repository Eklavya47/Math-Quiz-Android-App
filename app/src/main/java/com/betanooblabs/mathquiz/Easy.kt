package com.betanooblabs.mathquiz

import kotlin.random.Random

object Easy {

    private var answer: Int = 0

    fun getQuestions(): Pair<String, Int>{

        val num1 = Random.nextInt(-100, 100)
        val num2 = Random.nextInt(-100, 100)
        val operator = arrayOf("+", "-", "*", "/").random()

        val question = "$num1 $operator $num2"

        answer = try {
            when(operator){
                "+" -> num1 + num2
                "-" -> num1 - num2
                "*" -> num1 * num2
                else -> num1 / num2
            }
        }catch (e: ArithmeticException){
            77777777
        }

        return Pair(question, answer)
    }
}
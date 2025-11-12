package com.betanooblabs.mathquiz

import kotlin.random.Random

object Medium {

    private fun makeOperation(num1: Int, num2: Int, op: String): Int{

        val ans = try {
            when(op){
                "+" -> num1 + num2
                "-" -> num1 - num2
                "*" -> num1 * num2
                else -> num1 / num2
            }
        } catch (e: ArithmeticException){
            77777777
        }
        return ans
    }

    fun getQuestions(): Pair<String, Int>{

        val num1 = Random.nextInt(1, 100)
        val num2 = Random.nextInt(1, 100)
        val num3 = Random.nextInt(1, 100)
        val bracketPosition = Random.nextInt(1, 3)
        val operator1 = arrayOf("+", "-", "*", "/").random()
        val operator2 = arrayOf("+", "-", "*", "/").random()

        val problem = when(bracketPosition){
            1 -> "($num1 $operator1 $num2) $operator2 $num3"
            else -> "$num1 $operator1 ($num2 $operator2 $num3)"
        }

        val halfAns = when(bracketPosition){
            1 -> makeOperation(num1, num2, operator1)
            else -> makeOperation(num2, num3, operator2)
        }

        val ans = when(bracketPosition){
            1 -> makeOperation(halfAns, num3, operator2)
            else -> makeOperation(num1, halfAns, operator1)
        }

        return Pair(problem, ans)
    }
}
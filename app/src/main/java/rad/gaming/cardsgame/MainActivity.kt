package rad.gaming.cardsgame


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import java.text.DecimalFormat
import kotlin.math.roundToInt


lateinit var tView: TextView
lateinit var buttonOne: Button
lateinit var buttonTwo: Button
lateinit var buttonThree: Button
lateinit var buttonFour: Button
lateinit var buttonFive: Button
lateinit var buttonSix: Button
lateinit var buttonSeven: Button
lateinit var buttonEight: Button
lateinit var buttonNine: Button
lateinit var buttonZero: Button
lateinit var buttonDot: Button
lateinit var buttonDivision: Button
lateinit var buttonMultiple: Button
lateinit var buttonSubstruction: Button
lateinit var buttonAddiction: Button
lateinit var buttonEqual: Button
lateinit var buttonBackspace: Button
lateinit var buttonReset: Button
lateinit var btnList: List<Button>

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var value: String = ""
        val df = DecimalFormat("#.######")
        var result: Double = 0.0
        var mathOperator: Char = '!'
        var flagStart: Boolean = true
        var error: Boolean = false

        //initialization views (start)
        buttonOne = findViewById(R.id.button_one)
        buttonTwo = findViewById(R.id.button_two)
        buttonThree = findViewById(R.id.button_three)
        buttonFour = findViewById(R.id.button_four)
        buttonFive = findViewById(R.id.button_five)
        buttonSix = findViewById(R.id.button_six)
        buttonSeven = findViewById(R.id.button_seven)
        buttonEight = findViewById(R.id.button_eight)
        buttonNine = findViewById(R.id.button_nine)
        buttonZero = findViewById(R.id.button_zero)
        buttonDot = findViewById(R.id.button_dot)
        buttonEqual = findViewById(R.id.button_equal)
        buttonDivision = findViewById(R.id.button_division)
        buttonMultiple = findViewById(R.id.button_multiple)
        buttonSubstruction = findViewById(R.id.button_substruct)
        buttonAddiction = findViewById(R.id.button_addiction)
        buttonBackspace = findViewById(R.id.button_backspace)
        buttonReset = findViewById(R.id.button_reset)
        tView = findViewById(R.id.screen_text_view)
        //initialization views (end)

        //array of buttons
        btnList = listOf(
            buttonOne,
            buttonTwo,
            buttonThree,
            buttonFour,
            buttonFive,
            buttonSix,
            buttonSeven,
            buttonEight,
            buttonNine,
            buttonZero,
            buttonDot,
            buttonEqual,
            buttonDivision,
            buttonMultiple,
            buttonSubstruction,
            buttonAddiction,
            buttonBackspace,
            buttonReset
        )
        //width and height for buttons
        for (el in btnList) {
            el.layoutParams.width = 200
            el.layoutParams.height = 200
        }
        //text for TextView by default

        tView.text = result.toInt().toString()


        //initialization view listeners (start)
        buttonOne.setOnClickListener {
            if (value.length == 1 && value == "0")
                value = ""
            value += '1'
            tView.text = value

        }
        buttonTwo.setOnClickListener {
            if (value.length == 1 && value == "0")
                value = ""
            value += '2'
            tView.text = value

        }
        buttonThree.setOnClickListener {
            if (value.length == 1 && value == "0")
                value = ""
            value += '3'
            tView.text = value
        }
        buttonFour.setOnClickListener {
            if (value.length == 1 && value == "0")
                value = ""
            value += '4'
            tView.text = value
        }
        buttonFive.setOnClickListener {
            if (value.length == 1 && value == "0")
                value = ""
            value += '5'
            tView.text = value
        }
        buttonSix.setOnClickListener {
            if (value.length == 1 && value == "0")
                value = ""
            value += '6'
            tView.text = value
        }
        buttonSeven.setOnClickListener {
            if (value.length == 1 && value == "0")
                value = ""
            value += '7'
            tView.text = value
        }
        buttonEight.setOnClickListener {
            if (value.length == 1 && value == "0")
                value = ""
            value += '8'
            tView.text = value
        }
        buttonNine.setOnClickListener {
            if (!error) {
                if (value.length == 1 && value == "0")
                    value = ""
                value += '9'
                tView.text = value
            }
        }
        buttonZero.setOnClickListener {
            if (!error) {
                if (value.length == 1 && value == "0")
                    value = ""
                value += '0'
                tView.text = value
            }
        }
        buttonDot.setOnClickListener {
            if ('.' !in value)
                value += '.'

            tView.text = value
        }
        buttonEqual.setOnClickListener {
            if (!error) {
                when (mathOperator) {
                    '+' -> {
                        result += value.toDouble()
                        result = (result * 100000).roundToInt() / 100000.0
                    }
                    '-' -> {
                        result -= value.toDouble()
                        result = (result * 100000).roundToInt() / 100000.0
                    }
                    '*' -> {
                        result *= value.toDouble()
                        result = (result * 100000).roundToInt() / 100000.0
                    }
                    '/' -> {
                        if (value.toDouble() == 0.0) {
                            tView.text = "Error!"
                            error = true
                            return@setOnClickListener
                        } else {
                            result /= value.toDouble()
                            result = (result * 100000).roundToInt() / 100000.0
                        }

                    }
                }
                tView.text = result.toString()
                mathOperator = '!'
            }
        }

        buttonMultiple.setOnClickListener {
            if (value == "") {
                value = "1.0"
                result *= value.toDouble()
            }
            if (result == 0.0 && flagStart) {
                result = value.toDouble()
                flagStart = !flagStart
            }

            when (mathOperator) {
                '+' -> {
                    result += value.toDouble()
                    result = (result * 100000).roundToInt() / 100000.0
                }
                '-' -> {
                    result -= value.toDouble()
                    result = (result * 100000).roundToInt() / 100000.0
                }
                '*' -> {
                    result *= value.toDouble()
                    result = (result * 100000).roundToInt() / 100000.0
                }
                '/' -> {
                    if (value.toDouble() == 0.0) {
                        tView.text = "Error!"
                        error = true
                        return@setOnClickListener
                    } else {
                        result /= value.toDouble()
                        result = (result * 100000).roundToInt() / 100000.0
                    }

                }
            }
            mathOperator = '*'
            tView.text = result.toString()
            value = ""

        }

        buttonSubstruction.setOnClickListener {
            if (value == "") {
                value = "0.0"
                result -= value.toDouble()
            }
            if (result == 0.0 && flagStart) {
                result = value.toDouble()
                flagStart = !flagStart
            }
            when (mathOperator) {
                '+' -> {
                    result += value.toDouble()
                    result = (result * 100000).roundToInt() / 100000.0
                }
                '-' -> {
                    result -= value.toDouble()
                    result = (result * 100000).roundToInt() / 100000.0
                }
                '*' -> {
                    result *= value.toDouble()
                    result = (result * 100000).roundToInt() / 100000.0
                }
                '/' -> {
                    if (value.toDouble() == 0.0) {
                        tView.text = "Error!"
                        error = true
                        return@setOnClickListener
                    } else {
                        result /= value.toDouble()
                        result = (result * 100000).roundToInt() / 100000.0
                    }

                }
            }
            mathOperator = '-'
            tView.text = result.toString()
            value = ""
        }

        buttonAddiction.setOnClickListener {
            if (value == "") {
                value = "0.0"
                result += value.toDouble()
            }
            if (result == 0.0 && flagStart) {
                result = value.toDouble()
                flagStart = !flagStart
            }

            when (mathOperator) {
                '+' -> {
                    result += value.toDouble()
                    result = (result * 100000).roundToInt() / 100000.0
                }
                '-' -> {
                    result -= value.toDouble()
                    result = (result * 100000).roundToInt() / 100000.0
                }
                '*' -> {
                    result *= value.toDouble()
                    result = (result * 100000).roundToInt() / 100000.0
                }
                '/' -> {
                    if (value.toDouble() == 0.0) {
                        tView.text = "Error!"
                        error = true
                        return@setOnClickListener
                    } else {
                        result /= value.toDouble()
                        result = (result * 100000).roundToInt() / 100000.0
                    }

                }
            }

            mathOperator = '+'
            tView.text = result.toString()
            value = ""
        }

        buttonDivision.setOnClickListener {
            if (!error) {
                if (value == "") {
                    value = "1.0"
                    result /= value.toDouble()
                    Log.d("KEY", "result = ${result}")
                }
                if (result == 0.0 && flagStart) {
                    result = value.toDouble()
                    flagStart = !flagStart
                }

                when (mathOperator) {
                    '+' -> {
                        result += value.toDouble()
                        result = (result * 100000).roundToInt() / 100000.0
                    }
                    '-' -> {
                        result -= value.toDouble()
                        result = (result * 100000).roundToInt() / 100000.0
                    }
                    '*' -> {
                        result *= value.toDouble()
                        result = (result * 100000).roundToInt() / 100000.0
                    }
                    '/' -> {
                        if (value.toDouble() == 0.0) {
                            tView.text = "Error!"
                            error = true
                            return@setOnClickListener
                        } else {
                            result /= value.toDouble()
                            result = (result * 100000).roundToInt() / 100000.0
                        }

                    }
                }

                mathOperator = '/'
                tView.text = result.toString()
                value = ""
            }
        }

        buttonBackspace.setOnClickListener {
            value = value.dropLast(1)
            tView.text = value
        }

        buttonReset.setOnClickListener {
            value = ""
            result = 0.0
            flagStart = true
            mathOperator = '!'
            error = false
            tView.text = result.toInt().toString()
        }

        //initialization view listeners (end)


    }


}


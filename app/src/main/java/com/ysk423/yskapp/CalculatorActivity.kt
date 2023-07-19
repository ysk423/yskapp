package com.ysk423.yskapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class CalculatorActivity : AppCompatActivity() {

    private var tvCalculatorInput: TextView? = null

    //Represent whether the lastly pressed key is numeric or not
    var lastCalculatorNumeric: Boolean = false

    //If true, do not allow to add another DOT
    var lastCalculatorDot: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        tvCalculatorInput = findViewById(R.id.tvCalculatorInput)

    }

    fun onCalculatorDigit(view: View){
        tvCalculatorInput?.append((view as Button).text)
        lastCalculatorNumeric = true

    }

    fun onCalculatorClear(view: View){
        tvCalculatorInput?.text=""
        lastCalculatorNumeric = false
        lastCalculatorDot = false
    }

    fun onCalculatorDecimalPoint(view: View){
        if(lastCalculatorNumeric && !lastCalculatorDot){
            tvCalculatorInput?.append(".")
            lastCalculatorNumeric = false
            lastCalculatorDot = true
        }
    }

    fun onCalculatorOperator(view: View){
        tvCalculatorInput?.text?.let{
            if(tvCalculatorInput?.text?.isEmpty()!!){
                if((view as Button).text == "-"){
                    tvCalculatorInput?.append((view as Button).text)
                    lastCalculatorNumeric = false
                    lastCalculatorDot = false
                }
            }else if(lastCalculatorNumeric && !iscalculatorOperatorAdded(it.toString())){
                tvCalculatorInput?.append((view as Button).text)
                lastCalculatorNumeric = false
                lastCalculatorDot = false
            }
        }
    }

    fun onCalculatorEqual(view: View){
        if(lastCalculatorNumeric){
            var tvCalculatorValue = tvCalculatorInput?.text.toString()
            var prefix = ""

            try{
                if(tvCalculatorValue.startsWith("-")){
                    prefix ="-"
                    tvCalculatorValue = tvCalculatorValue.substring(1)
                }

                if(tvCalculatorValue.contains("-")){
                    val splitValue = tvCalculatorValue.split("-")
                    var one = splitValue[0]
                    val two = splitValue[1]

                    if(prefix.isNotEmpty()){
                        one = prefix + one
                    }

                    tvCalculatorInput?.text = calculatorRemoveZeroAfterDot((one.toDouble()-two.toDouble()).toString())


                }else if(tvCalculatorValue.contains("+")){
                    val splitValue = tvCalculatorValue.split("+")
                    var one = splitValue[0]
                    val two = splitValue[1]

                    if(prefix.isNotEmpty()){
                        one = prefix + one
                    }

                    tvCalculatorInput?.text = calculatorRemoveZeroAfterDot((one.toDouble()+two.toDouble()).toString())



                }else if(tvCalculatorValue.contains("/")){
                    val splitValue = tvCalculatorValue.split("/")
                    var one = splitValue[0]
                    val two = splitValue[1]

                    if(prefix.isNotEmpty()){
                        one = prefix + one
                    }

                    tvCalculatorInput?.text = calculatorRemoveZeroAfterDot((one.toDouble()/two.toDouble()).toString())


                }else if(tvCalculatorValue.contains("*")){
                    val splitValue = tvCalculatorValue.split("*")
                    var one = splitValue[0]
                    val two = splitValue[1]

                    if(prefix.isNotEmpty()){
                        one = prefix + one
                    }

                    tvCalculatorInput?.text = calculatorRemoveZeroAfterDot((one.toDouble()*two.toDouble()).toString())

                }

            }catch(e:ArithmeticException){
                e.printStackTrace()
            }
        }
    }

    fun calculatorRemoveZeroAfterDot(result: String):String{
        var value = result
        if(result.contains(".0"))
            value = result.substring(0, result.length-2)
        return value
    }

    fun iscalculatorOperatorAdded(value: String):Boolean{
        return if (value.startsWith("-")){
            false
        }else {
            (value.contains("/"))
                    ||(value.contains("*"))
                    ||(value.contains("-"))
                    ||(value.contains("+"))
        }
    }

}
package com.ysk423.yskapp

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
//import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class CalculateYourAgeActivity : AppCompatActivity() {

    private lateinit var tvCalculateYourAgeSelectedDate: TextView
    private lateinit var tvCalculateYourAgeInMinutes: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculate_your_age)

        val btnCalculateYourAgeDatePicker: Button =findViewById(R.id.btnCalculateYourAgeDatePicker)

        tvCalculateYourAgeSelectedDate = findViewById(R.id.tvCalculateYourAgeSelectedDate)
        tvCalculateYourAgeInMinutes = findViewById(R.id.tvCalculateYourAgeInMinutes)

        btnCalculateYourAgeDatePicker.setOnClickListener {

            clickDataPicker()

        }
    }

    private fun clickDataPicker(){
        val myCalender = Calendar.getInstance()
        val year = myCalender.get(Calendar.YEAR)
        val month = myCalender.get(Calendar.MONTH)
        val day = myCalender.get(Calendar.DAY_OF_MONTH)
        val dpd = DatePickerDialog(this,
             { _, selectedYear, selectedMonth, selectedDayOfMonth ->

                 /* デバック用トースト
                 Toast.makeText(this,
                    "Year was $selectedYear, month was ${selectedMonth +1}, day of month was $selectedDayOfMonth", Toast.LENGTH_LONG).show()
                 */

                 val selectedDate = "$selectedDayOfMonth/${selectedMonth+1}/$selectedYear"

                 tvCalculateYourAgeSelectedDate.text = selectedDate

                 val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.JAPAN)

                 val theDate = sdf.parse(selectedDate)

                 val selectedDateInMinutes: Long = theDate!!.time / 60000

                 val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))

                 val currentDateInMinutes: Long = currentDate!!.time/ 60000

                 val differenceInMinutes = currentDateInMinutes - selectedDateInMinutes

                 tvCalculateYourAgeInMinutes.text = differenceInMinutes.toString()

             },
            year,
            month,
            day
        )
        dpd.datePicker.maxDate = System.currentTimeMillis() - 86400 //dpdで明日以降を制限
        dpd.show()
    }


}
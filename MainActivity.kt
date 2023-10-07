package com.alanturing.cpifp.calculaedad

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.Calendar





class MainActivity : AppCompatActivity() {

    private lateinit var selectDate: TextView
    private lateinit var calsiBtn: Button
    private lateinit var showAge: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calsiBtn = findViewById(R.id.boton_calcular)
        selectDate = findViewById(R.id.selec_fecha)
        showAge = findViewById(R.id.edad)

        fun selectDate(view: View) {
            var c = Calendar.getInstance()
            var cDay = c.get(Calendar.DAY_OF_MONTH)
            var cMonth = c.get(Calendar.MONTH)
            var cYear = c.get(Calendar.YEAR)
            val calendarDialog = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                    cDay = dayOfMonth
                    cMonth = month
                    cYear = year
                    calsiBtn.visibility = View.VISIBLE
                    calsiBtn.setOnClickListener {
                        val currentYear = Calendar.getInstance()
                            .get(Calendar.YEAR)
                        val edads = currentYear - cYear
                        showAge.visibility = View.VISIBLE
                        showAge.text = "Tu edad es $edads"
                        textMassge("Tu edad es $edads")
                    }
                    selectDate.text = "Tu fecha escogida es: $cDay/${cMonth + 1}/$cYear"
                }, cYear, cMonth, cDay
            )
            calendarDialog.show()
        }
    }
        private fun textMassge(s: String) {
            Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
        }
    }






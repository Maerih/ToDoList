package com.example.thingstodo.utilities

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import com.google.android.material.textfield.TextInputEditText
import java.text.SimpleDateFormat
import java.util.*

object CustomUtility {

    fun getFormattedDateString(date: Date): String{
        val dateFormat = "dd-MM-yyyy"
        val simpleDateFormat = SimpleDateFormat(dateFormat)
        return simpleDateFormat.format(date)
    }

    fun getFormattedTimeString(date: Date): String{
        val timeFormat = "HH:mm"
        val simpleDateFormat = SimpleDateFormat(timeFormat)
        return simpleDateFormat.format(date)
    }

    fun getTimePickerListener(input : TextInputEditText, calender: Calendar) : TimePickerDialog.OnTimeSetListener {
        return TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
            calender.set(Calendar.HOUR_OF_DAY, hourOfDay)
            calender.set(Calendar.MINUTE, minute)
            calender.set(Calendar.SECOND, 0)
            input.setText(
                CustomUtility.getFormattedTimeString(calender.time)
            )
        }
    }

    fun getDatePickerListener(input : TextInputEditText, calender: Calendar) : DatePickerDialog.OnDateSetListener {
        return DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            calender.set(Calendar.YEAR, year)
            calender.set(Calendar.MONTH, month)
            calender.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            input.setText(
                CustomUtility.getFormattedDateString(calender.time)
            )
        }
    }

}
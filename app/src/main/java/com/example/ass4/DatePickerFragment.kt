package com.example.ass4

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast.*
import androidx.fragment.app.DialogFragment
import java.text.DateFormat
import java.util.*

class DatePickerFragment : DialogFragment(), DatePickerDialog.OnDateSetListener {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
// Initialize a calendar instance
        val calendar = Calendar.getInstance()
// Get the system current date
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
// Initialize a new date picker dialog and return it
        return DatePickerDialog(activity!!, 2, this, year, month, day)
    }
    override fun onDateSet(view: DatePicker, month: Int, day: Int ,year: Int) {
// Display the selected date in text view
        var tv : TextView? = activity?.findViewById(R.id.text_date)
        tv!!.text = formatDate(month,day,year)
    }
    override fun onCancel(dialog: DialogInterface) {
        makeText(activity,"Please select a date.", LENGTH_SHORT).show()
        super.onCancel(dialog)
    }
    // Custom method to format date
    private fun formatDate( month:Int, day:Int, year:Int):String{
        var calendar: Calendar = Calendar.getInstance();
// Create a Date variable/object with user chosen date
        calendar.set(month, day ,year)
        val chosenDate = calendar.time
// Format the date picker selected date
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM)
        return df.format(chosenDate)
    }
}
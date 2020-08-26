package com.example.ass4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun showDatePickerDialog(v:View){
        val newDateFragment = DatePickerFragment()
        newDateFragment.show(supportFragmentManager, "Date Picker")
    }
    fun register(view: View){
        var radioGroup: RadioGroup = findViewById(R.id.radioGroup)
        var selectedId : Int = radioGroup.checkedRadioButtonId;
        var radioButton : RadioButton = findViewById(selectedId);
        text_show.text = "ID: ${edit_id.text} \nPassword: ${edit_pas.text} \nGender: ${radioButton.text}\nEmail: ${edit_email.text} \nBirthday: ${text_date.text} "
    }
    fun reset(v:View){
        edit_id.text.clear()
        edit_pas.text.clear()
        radioGroup.clearCheck()
        edit_email.text.clear()
        text_date.text = "mm/dd/yy"
        text_show.text ="Show Information"
    }
}
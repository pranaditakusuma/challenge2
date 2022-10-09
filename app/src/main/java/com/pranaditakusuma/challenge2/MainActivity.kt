package com.pranaditakusuma.challenge2

import android.icu.util.IslamicCalendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import org.w3c.dom.Text
import java.time.Duration
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    lateinit var buttonCalculation: Button
    lateinit var tvGrandTotal: TextView
    lateinit var inputPrice: EditText
    lateinit var switchRoundUp: Switch
    lateinit var tvCalculation : TextView
    lateinit var radioGroup: RadioGroup
    lateinit var radGroupAmazing: RadioButton
    lateinit var radGroupGood: RadioButton
    lateinit var radGroupOk: RadioButton
    lateinit var tvRating: TextView
    lateinit var headerTitle : TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        allComponent()


        //getcalculationPrice()

        buttonCalculation.setOnClickListener {

            //startCalculate()

            Toast.makeText(baseContext, "Calculating",  Toast.LENGTH_SHORT).show()
            tvCalculation.text = startCalculate().toString()
        }
    }


    fun allComponent(){

        buttonCalculation = findViewById(R.id.bt_calculate)
        tvGrandTotal = findViewById(R.id.tv_title_grand_total)
        inputPrice = findViewById(R.id.edt_price)
        switchRoundUp = findViewById(R.id.switch_roundUp)
        tvCalculation = findViewById(R.id.tv_price_calculation)
        radioGroup = findViewById(R.id.radGroup)
        radGroupAmazing = findViewById(R.id.rating_amazing)
        radGroupGood = findViewById(R.id.rating_good)
        radGroupOk = findViewById(R.id.rating_ok)
        tvRating = findViewById(R.id.tv_rating)
        headerTitle = findViewById(R.id.tv_title_payment)
    }


    fun getcalculationPrice() : Double{
        Log.d("getCalculatePrice", inputPrice.text.toString())
       return inputPrice.text.toString().toDouble()

    }


    fun startCalculate(): Double{

        val total = if(radGroupAmazing.isChecked){
            getcalculationPrice().times(0.2)
        } else if (radGroupGood.isChecked){
            getcalculationPrice().times(0.18)
        } else if (radGroupOk.isChecked){
            getcalculationPrice().times(0.15)
        } else
            getcalculationPrice()

        return if (switchRoundUp.isChecked){
            total.roundToInt().toDouble()
        } else
            total

    }





}
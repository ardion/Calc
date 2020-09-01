package com.example.coba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception


class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layoutid(R.layout.activity_main)
    initlisteners()

    }

    override fun initlisteners() {
        tvOne.setOnClickListener{appendonExpresstion("1",canClear = true)}
        tvTwo.setOnClickListener{appendonExpresstion("2",canClear = true)}
        tvThree.setOnClickListener{appendonExpresstion("3",canClear = true)}
        tvFour.setOnClickListener{appendonExpresstion("4",canClear = true)}
        tvFive.setOnClickListener{appendonExpresstion("5",canClear = true)}
        tvSix.setOnClickListener{appendonExpresstion("6",canClear = true)}
        tvSeven.setOnClickListener{appendonExpresstion("7",canClear = true)}
        tvEight.setOnClickListener{appendonExpresstion("8",canClear = true)}
        tvNine.setOnClickListener{appendonExpresstion("9",canClear = true)}
        tvZero.setOnClickListener{appendonExpresstion("0",canClear = true)}
        tvDot.setOnClickListener{appendonExpresstion(".",canClear = true)}

        tvPlus.setOnClickListener{appendonExpresstion("+",canClear = false)}
        tvMinus.setOnClickListener{appendonExpresstion("-",canClear = false)}
        tvTimes.setOnClickListener{appendonExpresstion("*",canClear = false)}
        tvDivide.setOnClickListener{appendonExpresstion("/",canClear = false)}
        tvEquals.setOnClickListener{appendonExpresstion("=",canClear = false)}
        tvOpen.setOnClickListener{appendonExpresstion("(",canClear = false)}
        tvClose.setOnClickListener{appendonExpresstion(")",canClear = false)}

        tvClear.setOnClickListener {
            tvExpression.text=""
            tvResult.text=""
        }

        tvBack.setOnClickListener {
            val string=tvExpression.text.toString()
            if(string.isNotEmpty()){
                tvExpression.text=string.substring(0,string.length-1)
            }
            tvResult.text=""
        }

        tvEquals.setOnClickListener {
            try{
                val expression= ExpressionBuilder(tvExpression.text.toString()).build()
                val result= expression.evaluate()
                val longResult=result.toLong()
                if(result==longResult.toDouble())
                    tvResult.text=longResult.toString()
                else
                    tvResult.text=result.toString()

            }catch (e:Exception){
                Log.d("Exception","message:"+e.message)
            }

        }
    }


    fun appendonExpresstion(string: String, canClear: Boolean ){
        if(tvResult.text.isNotEmpty()){
            tvExpression.text=""
        }
        if(canClear){
            tvResult.text=""
            tvExpression.append(string)
        }else{
            tvExpression.append(tvResult.text)
            tvExpression.append(string)
            tvResult.text=""

        }

    }
}



package com.example.calc

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.gridlayout.widget.GridLayout
import java.lang.StringBuilder
import com.udojava.evalex.*
import java.lang.Exception

val exp_builder: StringBuilder = StringBuilder("")
var text_res: TextView? = null
var text_exp: TextView? = null
var key_easy: GridLayout? = null
var key_hard: GridLayout? = null

class MainActivity : AppCompatActivity(), View.OnClickListener, View.OnLongClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text_res = findViewById(R.id.result)
        text_exp = findViewById(R.id.expression)

        key_easy = findViewById(R.id.keyboard)
        key_hard = findViewById(R.id.keyboardsuper)

        val btn1: Button = findViewById(R.id.one)
        val btn2: Button = findViewById(R.id.two)
        val btn3: Button = findViewById(R.id.three)
        val btn4: Button = findViewById(R.id.four)
        val btn5: Button = findViewById(R.id.five)
        val btn6: Button = findViewById(R.id.six)
        val btn7: Button = findViewById(R.id.seven)
        val btn8: Button = findViewById(R.id.eight)
        val btn9: Button = findViewById(R.id.nine)
        val btn0: Button = findViewById(R.id.zero)

        val btnSep: Button = findViewById(R.id.separator)

        val btnPlus: Button = findViewById(R.id.plus)
        val btnMinus: Button = findViewById(R.id.minus)
        val btnMultiply: Button = findViewById(R.id.multiply)
        val btnDivision: Button = findViewById(R.id.division)
        val btnEqual: Button = findViewById(R.id.equal)

        val btnDel: Button = findViewById(R.id.delsymb)
        val btnDelAll: Button = findViewById(R.id.delall)
        val btnPow: Button = findViewById(R.id.pow)
        val btnPi: Button = findViewById(R.id.pi)
        val btnPiSuper: Button = findViewById(R.id.pisuper)
        val btnE: Button = findViewById(R.id.e)
        val btnDelSuper: Button = findViewById(R.id.delsymbsuper)
        val btnDelAllSuper: Button = findViewById(R.id.delallsuper)
        val btnSin: Button = findViewById(R.id.sin)
        val btnCos: Button = findViewById(R.id.cos)
        val btnAsin: Button = findViewById(R.id.asin)
        val btnAcos: Button = findViewById(R.id.acos)
        val btnTg: Button = findViewById(R.id.tg)
        val btnCtg: Button = findViewById(R.id.ctg)
        val btnAtg: Button = findViewById(R.id.atg)
        val btnActg: Button = findViewById(R.id.actg)
        val btnLog: Button = findViewById(R.id.log)
        val btnLn: Button = findViewById(R.id.ln)
        val btnSqrt: Button = findViewById(R.id.sqrt)
        val btnFactorial: Button = findViewById(R.id.factorial)
        val btnSkobkochka1: Button = findViewById(R.id.skobkochka1)
        val btnSkobkochka2: Button = findViewById(R.id.skobkochka2)
        val btnEqualsuper: Button = findViewById(R.id.equalsuper)

        btn0.setOnClickListener(this)
        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)
        btn4.setOnClickListener(this)
        btn5.setOnClickListener(this)
        btn6.setOnClickListener(this)
        btn7.setOnClickListener(this)
        btn8.setOnClickListener(this)
        btn9.setOnClickListener(this)
        btn0.setOnClickListener(this)

        btnSep.setOnClickListener(this)

        btnPlus.setOnClickListener(this)
        btnMinus.setOnClickListener(this)
        btnMultiply.setOnClickListener(this)
        btnDivision.setOnClickListener(this)
        btnEqual.setOnClickListener(this)

        btnDel.setOnClickListener(this)
        btnDelAll.setOnClickListener(this)
        btnPow.setOnClickListener(this)
        btnPi.setOnClickListener(this)

        btnPi.setOnLongClickListener(this)
        btnPiSuper.setOnLongClickListener(this)

        btnPiSuper.setOnClickListener(this)
        btnE.setOnClickListener(this)
        btnDelSuper.setOnClickListener(this)
        btnDelAllSuper.setOnClickListener(this)
        btnSin.setOnClickListener(this)
        btnCos.setOnClickListener(this)
        btnAsin.setOnClickListener(this)
        btnAcos.setOnClickListener(this)
        btnTg.setOnClickListener(this)
        btnCtg.setOnClickListener(this)
        btnAtg.setOnClickListener(this)
        btnActg.setOnClickListener(this)
        btnLog.setOnClickListener(this)
        btnLn.setOnClickListener(this)
        btnSqrt.setOnClickListener(this)
        btnFactorial.setOnClickListener(this)
        btnSkobkochka1.setOnClickListener(this)
        btnSkobkochka2.setOnClickListener(this)
        btnEqualsuper.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            //цифры
            R.id.one -> {
                exp_builder.append(KEYS.ONE.beauty)
                text_exp?.text = exp_builder.toString()
            }
            R.id.two -> {
                exp_builder.append(KEYS.TWO.beauty)
                text_exp?.text = exp_builder.toString()
            }
            R.id.three -> {
                exp_builder.append(KEYS.THREE.beauty)

                text_exp?.text = exp_builder.toString()
            }
            R.id.four -> {
                exp_builder.append(KEYS.FOUR.beauty)
                text_exp?.text = exp_builder.toString()
            }
            R.id.five -> {
                exp_builder.append(KEYS.FIVE.beauty)
                text_exp?.text = exp_builder.toString()
            }
            R.id.six -> {
                exp_builder.append(KEYS.SIX.beauty)
                text_exp?.text = exp_builder.toString()
            }
            R.id.seven -> {
                exp_builder.append(KEYS.SEVEN.beauty)
                text_exp?.text = exp_builder.toString()
            }
            R.id.eight -> {
                exp_builder.append(KEYS.EIGHT.beauty)
                text_exp?.text = exp_builder.toString()
            }
            R.id.nine -> {
                exp_builder.append(KEYS.NINE.beauty)
                text_exp?.text = exp_builder.toString()
            }
            R.id.zero -> {
                if (!exp_builder.isBlank()) exp_builder.append(KEYS.ZERO.beauty)
                text_exp?.text = exp_builder.toString()
                //("Кроме пустоты сделать проверку на предшествующий знак")
            }
            R.id.separator -> {
                if (!exp_builder.isBlank() and !isOperator(exp_builder)) exp_builder.append(KEYS.SEP.beauty)
                text_exp?.text = exp_builder.toString()
                //("Кроме пустоты сделать проверку на предшествующий знак")
            }
            //операции
            R.id.plus -> {
                if (!exp_builder.isBlank() and !isOperator(exp_builder)) exp_builder.append(KEYS.PLUS.beauty)
                text_exp?.text = exp_builder.toString()
                //("Кроме пустоты сделать проверку на предшествующий знак. Чтобы не было ++")
            }
            R.id.minus -> {
                if (!isOperator(exp_builder)) exp_builder.append(KEYS.MINUS.beauty)
                text_exp?.text = exp_builder.toString()
                //("Кроме пустоты сделать проверку на предшествующий знак. Чтобы не было --")
            }
            R.id.multiply -> {
                if (!exp_builder.isBlank() and !isOperator(exp_builder)) exp_builder.append(KEYS.MUL.beauty)
                text_exp?.text = exp_builder.toString()
                //("Кроме пустоты сделать проверку на предшествующий знак. Чтобы не было ***")
            }
            R.id.division -> {
                if (!exp_builder.isBlank() and !isOperator(exp_builder)) exp_builder.append(KEYS.DIV.beauty)
                text_exp?.text = exp_builder.toString()
                //("Кроме пустоты сделать проверку на предшествующий знак. Чтобы не было ///")
            }

            R.id.delsymb, R.id.delsymbsuper -> {
                if (!exp_builder.isBlank()) exp_builder.deleteCharAt(exp_builder.lastIndex)
                text_exp?.text = exp_builder.toString()
            }
            R.id.pow -> {
                if (!exp_builder.isBlank() and !isOperator(exp_builder)) exp_builder.append(KEYS.POW.beauty)
                text_exp?.text = exp_builder.toString()
                //("Кроме пустоты сделать проверку на предшествующий знак. Чтобы не было ^^^")
            }
            R.id.delall, R.id.delallsuper -> {
                text_res?.text = ""
                text_exp?.text = ""
                exp_builder.clear()
            }


            R.id.pi, R.id.pisuper -> {
                exp_builder.append(KEYS.PI.beauty)
                text_exp?.text = exp_builder.toString()
                //("Надо чтобы было видно символ, а не число. А считало число")

            }

            R.id.e -> {
                exp_builder.append(KEYS.E.beauty)
                text_exp?.text = exp_builder.toString()
            }
            //результат

            R.id.sin -> {
                exp_builder.append(KEYS.SIN.beauty)
                text_exp?.text = exp_builder.toString()
            }
            R.id.cos -> {
                exp_builder.append(KEYS.COS.beauty)
                text_exp?.text = exp_builder.toString()
            }
            R.id.asin -> {
                exp_builder.append(KEYS.ASIN.beauty)
                text_exp?.text = exp_builder.toString()
            }
            R.id.acos -> {
                exp_builder.append(KEYS.ACOS.beauty)
                text_exp?.text = exp_builder.toString()
            }
            R.id.tg -> {
                exp_builder.append(KEYS.TAN.beauty)
                text_exp?.text = exp_builder.toString()
            }
            R.id.ctg -> {
                exp_builder.append(KEYS.COT.beauty)
                text_exp?.text = exp_builder.toString()
            }
            R.id.atg -> {
                exp_builder.append(KEYS.ATAN.beauty)
                text_exp?.text = exp_builder.toString()
            }
            R.id.actg -> {
                exp_builder.append(KEYS.ACOT.beauty)
                text_exp?.text = exp_builder.toString()
            }
            R.id.log -> {
                exp_builder.append(KEYS.LOG.beauty)
                text_exp?.text = exp_builder.toString()
            }
            R.id.ln -> {
                exp_builder.append(KEYS.LN.beauty)
                text_exp?.text = exp_builder.toString()
            }
            R.id.sqrt -> {
                exp_builder.append(KEYS.SQRT.beauty)
                text_exp?.text = exp_builder.toString()
            }
            R.id.factorial -> {
                exp_builder.append(KEYS.F.beauty)
                text_exp?.text = exp_builder.toString()
            }
            R.id.skobkochka1 -> {
                exp_builder.append(KEYS.S_L.beauty)
                text_exp?.text = exp_builder.toString()
            }
            R.id.skobkochka2 -> {
                exp_builder.append(KEYS.S_R.beauty)
                text_exp?.text = exp_builder.toString()
            }
            R.id.equal, R.id.equalsuper -> {
                try {
                    text_res?.text = exp_builder.toString()
                    text_exp?.text =
                        Expression(replaceAll(exp_builder.toString())).eval()?.toPlainString()
                    exp_builder.clear()
                    exp_builder.append(text_exp?.text)
                } catch (e: Exception) {
                    text_exp?.text = ""
                    text_res?.text = ""
                    exp_builder.clear()
                    Toast.makeText(this, "Низзя так, дурашка", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }

    override fun onLongClick(v: View?): Boolean {
        when (v?.id) {
            R.id.pi -> {
                key_easy?.visibility = View.GONE
                key_hard?.visibility = View.VISIBLE
            }
            R.id.pisuper -> {
                key_easy?.visibility = View.VISIBLE
                key_hard?.visibility = View.GONE
            }
        }
        return true
    }

    private fun replaceAll(str: String): String {
        val strBuild = StringBuilder("")
        for (ch in str) {
            when {
                ch.toString() == KEYS.PI.beauty -> strBuild.append(KEYS.PI.not_beauty)
                ch.toString() == KEYS.E.beauty -> strBuild.append(KEYS.E.not_beauty)
                else -> strBuild.append(ch)
            }
        }
        return strBuild.toString()
    }

    private fun isOperator(stringBuilder: StringBuilder?): Boolean {
        return if (stringBuilder.isNullOrBlank())
            false
        else {
            val str: String = stringBuilder[stringBuilder.lastIndex].toString()
            (str == KEYS.PLUS.beauty) or
                    (str == KEYS.MINUS.beauty) or
                    (str == KEYS.MUL.beauty) or
                    (str == KEYS.DIV.beauty) or
                    (str == KEYS.SEP.beauty)
        }
    }
}

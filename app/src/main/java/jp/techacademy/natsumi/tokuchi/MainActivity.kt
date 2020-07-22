package jp.techacademy.natsumi.tokuchi

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.MotionEvent
import kotlinx.android.synthetic.main.activity_main.*
import android.view.View
import android.view.inputmethod.InputMethodManager

class MainActivity : AppCompatActivity(), View.OnFocusChangeListener, View.OnTouchListener, {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnTouchListener(this)
        button2.setOnTouchListener(this)
        button3.setOnTouchListener(this)
        button4.setOnTouchListener(this)

        editText1.onFocusChangeListener = this
        editText2.onFocusChangeListener = this
    }

    override fun onTouch(v: View, event: MotionEvent): Boolean {
        if (editText1.text.toString().isEmpty() || editText1.text.toString().isEmpty()) {
            Snackbar.make(v, "何か数値を入力してください。", Snackbar.LENGTH_INDEFINITE)
                .setAction("OK") {}
                .show()
        } else {
            val str1 = editText1.text.toString()
            val str2 = editText2.text.toString()
            val num1 = str1.toDouble()
            val num2 = str2.toDouble()
            val value1 = num1 + num2
            val value2 = num1 - num2
            val value3 = num1 * num2
            val value4 = num1 / num2

            val intent = Intent(this, SecondActivity::class.java)

            when (v.id) {
                R.id.button1 -> intent.putExtra("VALUE", value1)
                R.id.button2 -> intent.putExtra("VALUE", value2)
                R.id.button3 -> intent.putExtra("VALUE", value3)
                R.id.button4 -> intent.putExtra("VALUE", value4)
            }
            startActivity(intent)
        }
        return super.onTouchEvent(event)
    }

    override fun onFocusChange(v: View, hasFocus: Boolean) {
        if (!hasFocus) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(v.windowToken, 0)
        }
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        focusView.requestFocus()
        return super.dispatchTouchEvent(ev)
    }
}

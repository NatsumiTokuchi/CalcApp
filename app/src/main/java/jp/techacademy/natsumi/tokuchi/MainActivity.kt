package jp.techacademy.natsumi.tokuchi

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import android.view.View

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (editText1.text.toString().isNotEmpty() && editText2.text.toString().isNotEmpty()) {
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
        } else {
            Snackbar.make(v, "何か数値を入力してください。", Snackbar.LENGTH_INDEFINITE)
            .setAction("OK") {}
            .show()
        }
    }
}

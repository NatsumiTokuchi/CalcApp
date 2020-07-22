package jp.techacademy.natsumi.tokuchi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val result = intent.getDoubleExtra("VALUE", 0.0)
        textView2.text = result.toString()
    }
}

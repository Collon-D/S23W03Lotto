package kr.ac.kumoh.ce.s20190757.s23w03lotto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kr.ac.kumoh.ce.s20190757.s23w03lotto.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var main: ActivityMainBinding
    private lateinit var model: LottoViewModel
    private lateinit var txtNum: Array<TextView?>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("LifeCycle!!!", "onCreate()")

//        setContentView(R.layout.activity_main)
        main = ActivityMainBinding.inflate(layoutInflater)
        setContentView(main.root)

        txtNum = arrayOf(main.num1, main.num2, main.num3, main.num4, main.num5, main.num6)

        model = ViewModelProvider(this)[LottoViewModel::class.java]

        model.numbers.observe(this, Observer {
            txtNum.forEachIndexed { index, textView ->
                textView?.text = model.numbers.value!![index].toString()
            }
        })
        main.btnGenerate.setOnClickListener {
            model.generate()
            // Observer가 받아와서 수정
            // 비즈니스 로직과 눈에 보이는 것들은 분리시키기
//            txtNum.forEachIndexed { index, textView ->
//                textView?.text = model.numbers.value!![index].toString()
//            }
        }
    }
    private fun setNumbersTest() {
        txtNum.forEachIndexed { index, textView ->
            textView?.text = model.numbers.value!![index].toString()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("LifeCycle!!!", "onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.i("LifeCycle!!!", "onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.i("LifeCycle!!!", "onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.i("LifeCycle!!!", "onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("LifeCycle!!!", "onDestroy()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("LifeCycle!!!", "onRestart()")
    }
}

// Fuctional Interface (or Single Abstract Method)
// Interface이지만 함수는 하나 밖에 없다.
// ex) OnClickListener Interface에는 OnClick 함수 하나만 가지고 있다.
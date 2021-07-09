package com.cnadia.lotto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*
import java.text.SimpleDateFormat
import java.util.*

class ResultActivity : AppCompatActivity() {
    val lottoImaeStartId = R.drawable.ball_01

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        resultLabel.text = "랜덤으로 생성된\n로또번호입니다"
        val name = intent.getStringExtra("name")
        name?.let {
            resultLabel.text = "${it}님의\n${SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분").format(Date())}\n로또번호입니다"
        }

        val constel = intent.getStringExtra("constellation")
        constel?.let {
            resultLabel.text = "${it}의\n${SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분").format(Date())}\n로또번호입니다"
        }

        val result = intent.getIntegerArrayListExtra("result")
        result?.let {
            updateLottoBallImage(result.sortedBy { it })
        }
    }

    private fun updateLottoBallImage(result: List<Int>) {
        if (result.size < 6) return

        imageView01.setImageResource(lottoImaeStartId + (result[0]-1))
        imageView02.setImageResource(lottoImaeStartId + (result[1]-1))
        imageView03.setImageResource(lottoImaeStartId + (result[2]-1))
        imageView04.setImageResource(lottoImaeStartId + (result[3]-1))
        imageView05.setImageResource(lottoImaeStartId + (result[4]-1))
        imageView06.setImageResource(lottoImaeStartId + (result[5]-1))
    }
}
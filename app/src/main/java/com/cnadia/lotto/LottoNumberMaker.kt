package com.cnadia.lotto

import java.text.SimpleDateFormat
import java.util.*
import kotlin.random.Random

object LottoNumberMaker {
    fun getRandomLottoNumber(): Int {
        return Random.nextInt(45) + 1
    }

    fun getRandomLottoNumbers(): MutableList<Int> {
        val lottoNumbers = mutableListOf<Int>()

        for (i in 1..6) {
            var number = 0
            do {
                number = getRandomLottoNumber()
            } while(lottoNumbers.contains(number))
            lottoNumbers.add(number)
        }

        return lottoNumbers
    }

    fun getShuffleLottoNumbers(): MutableList<Int> {
        val list = mutableListOf<Int>()

        for (i in 1..45) {
            list.add(i)
        }

        list.shuffle()

        return list.subList(0, 6)
    }

    fun getLottoNumberFromHash(name: String): MutableList<Int> {
        val list = mutableListOf<Int>()

        for (i in 1..45) {
            list.add(i)
        }

        val targetString = SimpleDateFormat("yyyy-mm-dd-hh-mm", Locale.KOREA).format(Date()) + name
        list.shuffle(java.util.Random(targetString.hashCode().toLong()))

        return list.subList(0, 6)
    }
}
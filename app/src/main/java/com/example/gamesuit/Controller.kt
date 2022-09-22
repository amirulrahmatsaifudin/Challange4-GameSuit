package com.example.gamesuit

import android.util.Log
import androidx.appcompat.app.AppCompatActivity


class Controller(val callback: Callback) : AppCompatActivity(), CallbackController{

    override fun cekSuit(pemain: CharSequence, computer: CharSequence) {
        when {
            pemain == "batu" && computer == "gunting" || pemain == "gunting" && computer == "kertas" || pemain == "kertas" && computer == "batu" -> {
                callback.hasil(R.string.pemainwin, R.color.background_hijau, R.color.white)
                Log.d("Hasil", "Pemain Menang!!")

            }
            pemain == "gunting" && computer == "batu" || pemain == "kertas" && computer == "gunting" || pemain == "batu" && computer == "kertas" -> {
                Log.d("Hasil", "Computer Menang!!")
                callback.hasil(R.string.comwin, R.color.background_hijau, R.color.white)
            }

            else -> {
                Log.d("Hasil", "Draw")
                callback.hasil(R.string.draw, R.color.background_draw, R.color.white)

            }
        }
        Log.d("Pilihan", "$pemain VS $computer")
    }

}


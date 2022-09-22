package com.example.gamesuit

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.gamesuit.databinding.ActivityMainBinding
import kotlin.collections.forEachIndexed as forEachIndexed1

class MainActivity : AppCompatActivity(), Callback {

    private lateinit var binding: ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnPemain = arrayOf(
            binding.ivBatu,
            binding.ivKertas,
            binding.ivGunting,
        )

        val btnCom = arrayOf(
            binding.ivBatucom,
            binding.ivKertascom,
            binding.ivGuntingcom,
        )

        val controller = Controller(this)

        btnPemain.forEachIndexed1 { index, ImageView ->
            ImageView.setOnClickListener {
                val pilihancomputer: ImageView = btnCom.random()
                pilihancomputer.setBackgroundResource(R.drawable.backgorund_shape)
                disableClick(false)
                controller.cekSuit(
                    btnPemain[index].contentDescription.toString().trim().lowercase(),
                    pilihancomputer.contentDescription.toString().trim().lowercase()
                )
                btnPemain.forEach {
                    it.setBackgroundResource(android.R.color.transparent)
                }
                btnPemain[index].setBackgroundResource(R.drawable.backgorund_shape)
            }

        }
        binding.ivRefresh.setOnClickListener {
            btnPemain.forEach {
                it.setBackgroundResource(android.R.color.transparent)
            }
            btnCom.forEach {
                it.setBackgroundResource(android.R.color.transparent)
            }
            hasil(R.string.vs, android.R.color.transparent, R.color.merah)
            disableClick(true)
            Toast.makeText(this, "Masukkan Pilihan Lagi", Toast.LENGTH_SHORT).show()
            Log.d("Refresh", "Masukkan Pilihan Lagi")
        }

    }

    private fun disableClick(isEnable: Boolean) {
        binding.ivKertas.isEnabled = isEnable
        binding.ivBatu.isEnabled = isEnable
        binding.ivGunting.isEnabled = isEnable
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun hasil(text: Int, bg: Int, textColor: Int) {
        binding.tvHasil.text = getString(text)
        binding.tvHasil.setBackgroundColor(getColor(bg))
        binding.tvHasil.setTextColor(getColor(textColor))
    }

}
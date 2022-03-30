package org.d3if2092.assessment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import org.d3if2092.assessment1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener { dataMahasiswa() }
    }

    private fun dataMahasiswa() {
        val nama = binding.namaEditText.text.toString()
        if (TextUtils.isEmpty(nama)) {
            Toast.makeText(this, R.string.nama_invalid, Toast.LENGTH_LONG).show()
            return
        }

        val nim = binding.nimEditText.text.toString()
        if (TextUtils.isEmpty(nim)) {
            Toast.makeText(this, R.string.nim_invalid, Toast.LENGTH_LONG).show()
            return
        }

        val kelas = binding.kelas.text.toString()
        if (TextUtils.isEmpty(kelas)) {
            Toast.makeText(this, R.string.kelas_invalid, Toast.LENGTH_LONG).show()
            return
        }

        binding.textView4.text = getString(R.string.nama_mhs, nama)
        binding.textView6.text = getString(R.string.nim_mhs, nim)
        binding.textView8.text = getString(R.string.kelas_mhs, kelas)
    }
}
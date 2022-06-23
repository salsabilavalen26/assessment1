package org.d3if2092.assessment1

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import org.d3if2092.assessment1.databinding.FragmentFormBinding
import org.d3if2092.assessment1.model.HasilNilai

class FormFragment : Fragment() {

    private lateinit var binding: FragmentFormBinding

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentFormBinding.inflate(layoutInflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.button.setOnClickListener { dataMahasiswa() }
        binding.button3.setOnClickListener { it.findNavController().navigate(R.id.action_formFragment_to_listFragment) }
        binding.shareButton.setOnClickListener { shareData() }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_about) {
            findNavController().navigate(R.id.action_formFragment_to_aboutFragment2)
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun dataMahasiswa() {
        val nama = binding.namaEditText.text.toString()
        if (TextUtils.isEmpty(nama)) {
            Toast.makeText(context, R.string.nama_invalid, Toast.LENGTH_LONG).show()
            return
        }

        val nim = binding.nimEditText.text.toString()
        if (TextUtils.isEmpty(nim)) {
            Toast.makeText(context, R.string.nim_invalid, Toast.LENGTH_LONG).show()
            return
        }

        val kelas = binding.kelas.text.toString()
        if (TextUtils.isEmpty(kelas)) {
            Toast.makeText(context, R.string.kelas_invalid, Toast.LENGTH_LONG).show()
            return
        }

        val nilaiSmtr1 = binding.nilaiSmtr1.text.toString()
        if (TextUtils.isEmpty(nilaiSmtr1)) {
            Toast.makeText(context, R.string.nilai1_invalid, Toast.LENGTH_LONG).show()
            return
        }

        val nilaiSmtr2 = binding.nilaiSmtr2.text.toString()
        if (TextUtils.isEmpty(nilaiSmtr2)) {
            Toast.makeText(context, R.string.nilai2_invalid, Toast.LENGTH_LONG).show()
            return
        }

        val result = viewModel.rataNilai(
            nilaiSmtr1.toFloat(),
            nilaiSmtr2.toFloat()
        )

        binding.textView4.text = getString(R.string.nama_mhs, nama)
        binding.textView6.text = getString(R.string.nim_mhs, nim)
        binding.textView8.text = getString(R.string.kelas_mhs, kelas)
        showResult(result)

        binding.shareButton.visibility = View.VISIBLE
    }

    private fun showResult(result: HasilNilai) {
        binding.textView9.text = getString(R.string.nilai_mhs, result.rataNilai)
    }

    private fun shareData() {
        val message = getString(R.string.bagikan_template,
            binding.namaEditText.text,
            binding.nimEditText.text,
            binding.kelas.text
        )

        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain").putExtra(Intent.EXTRA_TEXT, message)
        if (shareIntent.resolveActivity(
                requireActivity().packageManager) != null) {
            startActivity(shareIntent)
        }
    }
}
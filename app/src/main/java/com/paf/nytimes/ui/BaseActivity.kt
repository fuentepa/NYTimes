package com.paf.nytimes.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.paf.nytimes.R
import com.paf.nytimes.databinding.ContentProgressbarBinding


open class BaseActivity: AppCompatActivity() {

    private var dialog: AlertDialog? = null
    private var tvTextDialog: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }

    fun mostrarProgressBar(resId: Int = R.string.txt_haciendo_consultas) { //mensaje que se quiere poner
        if (dialog == null)
            setProgressDialog(resId)
        else {
            tvTextDialog?.setText(resId)
            dialog?.show()
        }
    }

    fun ocultarProgressBar() {
        dialog?.dismiss()
    }

    private fun setProgressDialog(resId: Int) {
        val binding = ContentProgressbarBinding.inflate(LayoutInflater.from(this))
        binding.tvProgreso.apply {
            tvTextDialog = this
            text = resources.getString(resId)
        }

        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setCancelable(true)
        builder.setView(binding.root)
        dialog = builder.create()
        dialog?.show()
    }
}

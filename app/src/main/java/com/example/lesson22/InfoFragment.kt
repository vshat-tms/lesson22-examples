package com.example.lesson22

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment

class InfoFragment : Fragment(R.layout.fragment_info) {
    private var textView: TextView? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textView = view.findViewById(R.id.tvValue)
        arguments?.getString(ARGUMENT_TEXT)?.let {
            textView?.text = it
        }

    }

    fun setText(text: String) {
        textView?.text = text
    }

    companion object {
        const val ARGUMENT_TEXT = "ARGUMENT_TEXT"
    }
}
package com.example.lesson22

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class CounterFragment : Fragment() {
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_counter, container, false)

        textView = rootView.findViewById(R.id.tvValue)

        arguments?.getInt(ARGUMENT_INITIAL_VALUE)?.let {
            setCounterValue(it)
        }

        rootView.findViewById<Button>(R.id.buttonPlus).setOnClickListener {
            updateCounter(1)
        }

        rootView.findViewById<Button>(R.id.buttonMinus).setOnClickListener {
            updateCounter(-1)
        }

        return rootView
    }

    private fun updateCounter(diff: Int) {
        val value = (textView.text.toString().toInt())
        setCounterValue(value + diff)

    }

    private fun setCounterValue(value: Int) {
        (requireActivity() as MainActivity).onCounterUpdated(value)
        textView.text = value.toString()
    }

    companion object {
        const val ARGUMENT_INITIAL_VALUE = "ARGUMENT_INITIAL_VALUE"
    }
}
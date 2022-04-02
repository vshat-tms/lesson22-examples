package com.example.lesson22

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.lesson22.CounterFragment.Companion.ARGUMENT_INITIAL_VALUE
import com.example.lesson22.InfoFragment.Companion.ARGUMENT_TEXT


class MainActivity : AppCompatActivity() {
    // так делать не надо
    private lateinit var infoFragment: InfoFragment


    fun onCounterUpdated(newValue: Int) {
        infoFragment.setText("New counter value: $newValue")
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        infoFragment = InfoFragment()
        infoFragment.arguments = Bundle().apply {
            putString(ARGUMENT_TEXT, "Hello from InfoFragment")
        }

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .setReorderingAllowed(true)
                .add(
                    R.id.fragmentContainer1,
                    CounterFragment::class.java,
                    Bundle().apply { putInt(ARGUMENT_INITIAL_VALUE, -5) }
                )
                .add(
                    R.id.fragmentContainer2,
                    infoFragment,
                )
                .add(
                    R.id.fragmentContainer3,
                    CounterFragment::class.java,
                    Bundle().apply { putInt(ARGUMENT_INITIAL_VALUE, 5) }
                )
                .commit()
        }

    }

    fun showInfo(view: View) {
        val newInfoFragment = InfoFragment()
        newInfoFragment.arguments = Bundle().apply {
            putString(ARGUMENT_TEXT, "Clicked on showInfo()")
        }
        supportFragmentManager.beginTransaction()
            .setReorderingAllowed(true)
            .replace(R.id.fragmentContainer3, newInfoFragment)
            .commit()
    }
    fun showCounter(view: View) {
        val newCounterFragment = CounterFragment()
        newCounterFragment.arguments = Bundle().apply {
            putInt(ARGUMENT_INITIAL_VALUE, 77)
        }

        supportFragmentManager.beginTransaction()
            .setReorderingAllowed(true)
            .replace(R.id.fragmentContainer3, newCounterFragment)
            .commit()
    }

}
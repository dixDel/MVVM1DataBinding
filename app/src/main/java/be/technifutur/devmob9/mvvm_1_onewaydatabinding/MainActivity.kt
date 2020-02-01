package be.technifutur.devmob9.mvvm_1_onewaydatabinding

import android.app.Activity
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import be.technifutur.devmob9.mvvm_1_onewaydatabinding.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.simpleName

    private lateinit var binding: ActivityMainBinding
    private var index: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val mainViewModel = MainActivityViewModelFactory(this.application)
            .create(MainViewModel::class.java)

        binding.viewModel = mainViewModel

        setupViews()
        setupListeners()
    }

    private fun setupListeners() {
        searchEditText.setOnFocusChangeListener { view, b ->
            Log.d(TAG, "FOCUS: $b")
            if (!b) {
                val imm: InputMethodManager =
                    getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(view.windowToken, 0)
            }
        }

        previousButton.setOnClickListener {
            if (index > 0) {
                index--
                this.updateDisplay()
            }
        }
        nextButton.setOnClickListener {
            if (index < this.binding.viewModel!!.size() - 1) {
                index++
                this.updateDisplay()
            }
        }
    }

    private fun setupViews() {
        searchEditText.setSingleLine()

        descriptionTextView.movementMethod = ScrollingMovementMethod()
        descriptionTextView.setBackgroundColor(Color.TRANSPARENT)

        previousButton.isEnabled = false
        if (this.binding.viewModel!!.size() <= 1) {
            nextButton.isEnabled = false
        }
    }


    private fun updateDisplay() {
        previousButton.isEnabled = index > 0
        nextButton.isEnabled = index < this.binding.viewModel!!.size() - 1
        binding.viewModel?.setActivePokemon(index)
        binding.viewModel?.searchName = null
        binding.viewModel?.searchNameError = null
        searchEditText.clearFocus()
    }
}

package be.technifutur.devmob9.mvvm_1_onewaydatabinding

import android.app.Activity
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import be.technifutur.devmob9.mvvm_1_onewaydatabinding.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.simpleName

    private lateinit var binding: ActivityMainBinding

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
            if (!b) {
                val imm: InputMethodManager =
                    getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(view.windowToken, 0)
            }
        }
    }

    private fun setupViews() {
        searchEditText.setSingleLine()

        descriptionTextView.movementMethod = ScrollingMovementMethod()
        descriptionTextView.setBackgroundColor(Color.TRANSPARENT)
    }
}

package be.technifutur.devmob9.mvvm_1_onewaydatabinding

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import be.technifutur.devmob9.mvvm_1_onewaydatabinding.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.simpleName

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.title = "MVVM Exercice 4"

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val mainViewModel = MainActivityViewModelFactory(this.application)
            .create(MainViewModel::class.java) as MainViewModel

        binding.viewModel = mainViewModel

        setupViews()
        setupListeners()

        binding.viewModel!!.getLastKnownIntent().observe(this, Observer {
            lastKnownIntent ->
            Log.d(TAG, lastKnownIntent.getIntExtra("startItem", 0).toString())
        })
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
    }
}

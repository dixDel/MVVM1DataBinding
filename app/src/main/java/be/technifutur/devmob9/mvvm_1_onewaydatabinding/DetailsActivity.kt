package be.technifutur.devmob9.mvvm_1_onewaydatabinding

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.databinding.DataBindingUtil
import be.technifutur.devmob9.mvvm_1_onewaydatabinding.databinding.ActivityDetailsBinding
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val binding: ActivityDetailsBinding = DataBindingUtil.setContentView(this, R.layout.activity_details)

        val index = intent.getIntExtra("startItem", 0)
        val mainViewModel = MainActivityViewModelFactory(this.application, index)
            .create(MainViewModel::class.java)

        binding.viewModel = mainViewModel

        this.setupViews()
    }

    private fun setupViews() {
        descriptionTextView.movementMethod = ScrollingMovementMethod()
        descriptionTextView.setBackgroundColor(Color.TRANSPARENT)
    }
}

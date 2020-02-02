package be.technifutur.devmob9.mvvm_1_onewaydatabinding

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        this.setupViews()
    }

    private fun setupViews() {
        descriptionTextView.movementMethod = ScrollingMovementMethod()
        descriptionTextView.setBackgroundColor(Color.TRANSPARENT)
    }
}

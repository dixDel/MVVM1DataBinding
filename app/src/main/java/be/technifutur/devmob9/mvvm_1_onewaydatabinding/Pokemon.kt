package be.technifutur.devmob9.mvvm_1_onewaydatabinding

import android.graphics.drawable.Drawable
import androidx.databinding.BaseObservable

data class Pokemon (
    val name: String = "",
    val description: String,
    val imageResource: Drawable?
): BaseObservable()
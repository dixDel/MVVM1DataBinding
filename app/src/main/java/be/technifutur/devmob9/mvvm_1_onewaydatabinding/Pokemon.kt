package be.technifutur.devmob9.mvvm_1_onewaydatabinding

import android.graphics.drawable.Drawable
import androidx.databinding.BaseObservable

class Pokemon (
    name: String = "",
    val description: String,
    val imageResource: Drawable?
): BaseObservable() {

    var name: String = name
        set(value) {
            field = value
            notifyChange()
        }
}
package be.technifutur.devmob9.mvvm_1_onewaydatabinding

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented searchNameError, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under searchNameError.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("be.technifutur.devmob9.mvvm_1_onewaydatabinding", appContext.packageName)
    }
}

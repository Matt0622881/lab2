package lab2

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var editText: EditText
    private lateinit var pressMeButton: Button
    private lateinit var checkBox: CheckBox
    private lateinit var switch: Switch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_grid) // Change to the desired layout

        // Initialize views
        textView = findViewById(R.id.textView)
        editText = findViewById(R.id.editText)
        pressMeButton = findViewById(R.id.pressMeButton)
        checkBox = findViewById(R.id.checkBox)
        switch = findViewById(R.id.switch1)

        // Set OnClickListener for the "Press Me" Button
        pressMeButton.setOnClickListener {
            val newText = editText.text.toString()
            textView.text = newText

            // Show a Toast with translated message
            val toastMessage = getString(R.string.toast_message)
            showToast(toastMessage)
        }

        // Set OnCheckedChangeListener for the Checkbox
        checkBox.setOnCheckedChangeListener { _, isChecked ->
            // Show a Snack bar with translated message
            val snackbarMessage = getString(R.string.checkbox_status, if (isChecked) "on" else "off")
            showSnackbar(snackbarMessage, isChecked)
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun showSnackbar(message: String, isChecked: Boolean) {
        val snackbar = Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG)
        snackbar.setAction(getString(R.string.undo)) {
            // Undo action: Reset Checkbox to its original state
            checkBox.isChecked = !isChecked
        }
        snackbar.show()
    }
}

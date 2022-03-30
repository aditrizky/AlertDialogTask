package com.binar.dialogsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var actionButton: Button
    private lateinit var costumButton: Button
    private lateinit var simpleButton: Button
    private lateinit var dialogFragment: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        actionButton = findViewById(R.id.button_action_dialog)
        costumButton = findViewById(R.id.button_costum_dialog)
        simpleButton = findViewById(R.id.button_simple_dialog)
        dialogFragment= findViewById(R.id.button_fragment_dialog)


        actionButton.setOnClickListener {
            actionDialog()
        }

        costumButton.setOnClickListener {
            costumDialog()
        }
        simpleButton.setOnClickListener {
            simpleCancelableDialog()
        }

        dialogFragment.setOnClickListener {
            val alertDialogFragment= FragmentDialog()
            alertDialogFragment.show(supportFragmentManager,"tag")

        }

    }

    fun actionDialog() {
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("dialog with action")
        dialog.setMessage("choose one")
        dialog.setCancelable(false)
        dialog.setIcon(R.mipmap.ic_launcher)

        dialog.setPositiveButton("positive button") { _, _ ->
            Toast.makeText(this, "positive button", Toast.LENGTH_LONG).show()
        }
        dialog.setNegativeButton("negative button") { _, _ ->
            Toast.makeText(this, "negative button", Toast.LENGTH_LONG).show()
        }
        dialog.setNeutralButton("neutral button") { _, _ ->
            Toast.makeText(this, "neutral button", Toast.LENGTH_LONG).show()
        }

        dialog.show()
    }

    fun costumDialog() {
        val view = LayoutInflater.from(this).inflate(R.layout.costum_dialog, null, false)
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setView(view)

        val dialog = dialogBuilder.create()
        dialog.setCancelable(false)
        val dialogSnackbarButton = view.findViewById<Button>(R.id.button_snackbar)
        val dialogToastButton = view.findViewById<Button>(R.id.button_toast)

        dialogSnackbarButton.setOnClickListener {
            dialog.dismiss()
            val snackbar = Snackbar.make(
                findViewById(R.id.coordinator_layout),
                "You have clik snackbar",
                Snackbar.LENGTH_INDEFINITE
            )
            snackbar.setAction("dismis") {
                snackbar.dismiss()
            }
            snackbar.show()

        }

        dialogToastButton.setOnClickListener {
            dialog.dismiss()
            Toast.makeText(this, "You have click Toast", Toast.LENGTH_LONG).show()
        }

        dialog.show()

    }

    fun simpleCancelableDialog() {
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("Simple Cancelable Dialog")
        dialog.setMessage("Klick everywhere to cancle dialog")
        dialog.setCancelable(true)
        dialog.show()
    }

}
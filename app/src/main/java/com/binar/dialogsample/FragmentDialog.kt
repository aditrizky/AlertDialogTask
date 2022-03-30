package com.binar.dialogsample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.google.android.material.snackbar.Snackbar


class FragmentDialog: DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dialog,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dialogSnackbarButton = view.findViewById<Button>(R.id.button_snackbar)
        val dialogToastButton = view.findViewById<Button>(R.id.button_toast)

        dialogSnackbarButton.setOnClickListener {
            dialog?.dismiss()
            Snackbar.make(requireActivity().findViewById(R.id.coordinator_layout),"this is snackbar",Snackbar.LENGTH_LONG).show()
        }
        dialogToastButton.setOnClickListener {
            dialog?.dismiss()
            Toast.makeText(requireContext(), "this is toast", Toast.LENGTH_LONG).show()
        }

    }

}
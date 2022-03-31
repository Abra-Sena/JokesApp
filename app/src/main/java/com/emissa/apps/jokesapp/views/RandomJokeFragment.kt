package com.emissa.apps.jokesapp.views

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.emissa.apps.jokesapp.R

class RandomJokeFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater

            builder.setView(inflater.inflate(R.layout.fragment_random_joke, null))
                .setTitle(R.string.dialog_title)
                .setPositiveButton(R.string.dialog_ok, DialogInterface.OnClickListener { dialog,  id ->

                })
                .setNegativeButton(R.string.dialog_dismiss, DialogInterface.OnClickListener { dialog, id ->
                    getDialog()?.cancel()
                })

            builder.create()
        } ?: throw IllegalStateException("Activity can not be null -> From Dialog creation...")
    }
}
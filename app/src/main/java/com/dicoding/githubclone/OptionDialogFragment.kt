package com.dicoding.githubclone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class OptionDialogFragment : Fragment() {
    private lateinit var shareButton: TextView
    private lateinit var reportButton: TextView
    private lateinit var cancelButton: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        shareButton = view.findViewById(R.id.share_button)
        reportButton = view.findViewById(R.id.report_button)
        cancelButton = view.findViewById(R.id.cancel_button)


    }
}
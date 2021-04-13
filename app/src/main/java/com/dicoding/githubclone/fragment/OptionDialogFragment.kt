package com.dicoding.githubclone.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.dicoding.githubclone.R

class OptionDialogFragment : DialogFragment(),View.OnClickListener {
    private lateinit var shareButton: TextView
    private lateinit var reportButton: TextView
    private lateinit var cancelButton: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        shareButton = view.findViewById(R.id.share_button)
        reportButton = view.findViewById(R.id.report_button)
        cancelButton = view.findViewById(R.id.kancel_button)

        shareButton.setOnClickListener(this)
        reportButton.setOnClickListener(this)
        cancelButton.setOnClickListener(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_option_dialog,container,false)
    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.share_button -> {
                activity?.supportFragmentManager?.beginTransaction()?.remove(this)?.commit()
                Toast.makeText(context,"Shared!", Toast.LENGTH_SHORT).show()

            }
            R.id.report_button -> {
                activity?.supportFragmentManager?.beginTransaction()?.remove(this)?.commit()
                Toast.makeText(context,"Reported to GitHub. We'll review your report shortly.", Toast.LENGTH_SHORT).show()

            }
            R.id.kancel_button -> {
                activity?.supportFragmentManager?.beginTransaction()?.remove(this)?.commit()
            }
        }
    }
}
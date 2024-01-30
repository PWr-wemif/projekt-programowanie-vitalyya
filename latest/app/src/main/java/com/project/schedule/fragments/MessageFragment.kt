package com.project.schedule.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.project.schedule.MessageCallback
import com.project.schedule.R

// TODO: Rename parameter arguments, choose names that match
/**
 * A simple [Fragment] subclass.
 * Use the [MessageFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MessageFragment : Fragment() {
    // TODO: Rename and change types of parameters

    lateinit var messageCallback: MessageCallback

    lateinit var buttonAccept: Button
    lateinit var buttonDecline: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_message, container, false)
        initUI(view)
        return view
    }

    private fun initUI(view: View) {
        buttonAccept = view.findViewById(R.id.ok_button)
        buttonDecline = view.findViewById(R.id.decline_button)

        buttonAccept.setOnClickListener {
            messageCallback.messageAccept()

        }

        buttonDecline.setOnClickListener {
            messageCallback.messageDecline()
        }

    }

    companion object {

        @JvmStatic
        fun newInstance(messageCallback: MessageCallback) =
            MessageFragment().apply {
                this.messageCallback = messageCallback

            }
    }
}
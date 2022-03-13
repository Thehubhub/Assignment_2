package com.example.recyclerviewapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.recyclerviewapp.R
import com.example.recyclerviewapp.models.Event

private const val MY_EVENT_PARAM = "myEvent"

class ThirdFragment : Fragment() {

    private var newEvent: Event? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            newEvent = it.getParcelable(MY_EVENT_PARAM)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    companion object {
        fun newInstance(event: Event) =
            ThirdFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(MY_EVENT_PARAM, event)
                }
            }
    }
}
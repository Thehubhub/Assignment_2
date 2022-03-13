package com.example.recyclerviewapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.recyclerviewapp.databinding.FragmentSecondBinding
import com.example.recyclerviewapp.models.Event

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SecondFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SecondFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private val binding by lazy{
        FragmentSecondBinding.inflate(layoutInflater)
    }

    private var selectedDate: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ?. used to perform "safe call", calls a method
        // or accesses a property if the receiver is non-null
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.eventCalendar.setOnDateChangeListener { calendarView, i, i2, i3 ->
            Log.d("SECONDFRAG", calendarView.date.toString())

            val realMonth = i2 + 1
            selectedDate = if (realMonth < 10) {
                "0$i2/$i3/$i"
            } else {
                "$i2/$i3/$i"
            }
        }

        binding.eventButton.setOnClickListener {
            fragmentNavigation(
                supportFragmentManager = requireActivity().supportFragmentManager,
                FirstFragment.newInstance(
                    Event(
                        title = binding.eventTitleEt.text.toString(),
                        category = binding.eventCategoryEt.text.toString(),
                        date = selectedDate ?: ""
                    )
                )
            )
        }
        return binding.root
    }

    companion object {
        fun newInstance() = SecondFragment()
    }
}
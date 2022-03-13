package com.example.recyclerviewapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewapp.adapter.EventAdapter
import com.example.recyclerviewapp.databinding.FragmentFirstBinding
import com.example.recyclerviewapp.models.Event
import com.example.recyclerviewapp.view.ThirdFragment

class FirstFragment : Fragment() {
    private var newEvent: Event? = null

    private val binding by lazy {
        FragmentFirstBinding.inflate(layoutInflater)
    }

    private val evenAdapter by lazy {
        EventAdapter(onEventClicked = {
            fragmentNavigation(
                supportFragmentManager = requireActivity().supportFragmentManager,
                ThirdFragment.newInstance(it))
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            newEvent = it.getParcelable("myEvent")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding.myRecycler.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = evenAdapter
        }

        newEvent?.let {
            evenAdapter.updateEventData(it)
        }

        //binding button on 1st XML file
        binding.addEvent.setOnClickListener {
            fragmentNavigation(
                supportFragmentManager = requireActivity().supportFragmentManager,
                SecondFragment.newInstance())
        }
        retainInstance = true
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FirstFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(newEvent: Event? = null) =
            FirstFragment().apply {
                arguments = Bundle().apply {
                    putParcelable("myEvent", newEvent)
                }
            }
    }
}
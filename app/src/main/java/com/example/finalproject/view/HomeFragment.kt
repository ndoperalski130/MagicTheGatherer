package com.example.finalproject.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {


    private var _binding : FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        binding.btnLifelinkerButton.setOnClickListener {
            //Toast.makeText(context, "Toast", Toast.LENGTH_LONG).show()
            parentFragmentManager.beginTransaction()
                .replace(R.id.fcvContainer, LifelinkerContainer4Fragment())
                .addToBackStack("lifelinker")
                .commit()
        }
        binding.btnSearchButton.setOnClickListener {
            //Toast.makeText(context, "Search", Toast.LENGTH_LONG).show()
            parentFragmentManager.beginTransaction()
                .replace(R.id.fcvContainer, SearchFragment())
                .addToBackStack("search")
                .commit()

        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}
package com.example.finalproject.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.finalproject.databinding.FragmentLifelinkerBinding

class LifelinkerFragment : Fragment() {

    private var _binding : FragmentLifelinkerBinding? = null
    private val binding : FragmentLifelinkerBinding get() = _binding!!

    var number: Int = 0


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentLifelinkerBinding.inflate(layoutInflater, container, false)

        number = binding.tvTotalLife.text.toString().toInt()

        binding.btnIncrementButton.setOnClickListener {
            number++
            binding.tvTotalLife.text = number.toString()
        }

        binding.btnDecrementButton.setOnClickListener {
            number--
            binding.tvTotalLife.text = number.toString()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
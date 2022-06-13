package com.example.finalproject.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.finalproject.databinding.FragmentDetailsBinding
import com.example.finalproject.model.CardObject

class DetailsFragment(private val card: CardObject) : Fragment() {

    private var _binding : FragmentDetailsBinding? = null
    private val binding: FragmentDetailsBinding get() = _binding!!

    companion object {
        fun newInstance(card: CardObject): DetailsFragment
        {
            val frag = DetailsFragment(card)
            val bundle = Bundle()
            bundle.putParcelable("detailsFragment", card)
            frag.arguments = bundle
            return frag
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailsBinding.inflate(layoutInflater, container, false)



        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
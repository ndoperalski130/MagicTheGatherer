package com.example.finalproject.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentSearchBinding
import com.example.finalproject.model.CardObject
import com.example.finalproject.repository.CardsRepositoryImpl
import com.example.finalproject.viewmodel.CardViewModel

class SearchFragment : Fragment() {

    private var _binding : FragmentSearchBinding? = null
    private val binding : FragmentSearchBinding get() = _binding!!

    private lateinit var cardRecyclerViewAdapter: CardRecyclerViewAdapter

    private val cardViewModel: CardViewModel by lazy {
        object : ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return CardViewModel(CardsRepositoryImpl()) as T
            }
        }.create(CardViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(layoutInflater, container, false)
        configureObserver()
        return binding.root
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun configureObserver()
    {
        cardViewModel.cards.observe(viewLifecycleOwner){response ->
            if(response.cards.isEmpty())
            {
                binding.etSearchName.hint = "Error"
            }
            else
            {
                cardRecyclerViewAdapter = CardRecyclerViewAdapter(openCardDetails = ::openCardDetails)
                cardRecyclerViewAdapter.addNewCards(response.cards)
                binding.rvMagicRecyclerView.adapter = cardRecyclerViewAdapter
            }
        }
    }

    private fun openCardDetails(card: CardObject)
    {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fcvContainer, DetailsFragment.newInstance(card))
            .addToBackStack("")
            .commit()
    }

}
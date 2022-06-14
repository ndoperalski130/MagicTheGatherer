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
                return CardViewModel(binding.etSearchName.text.toString(), null, CardsRepositoryImpl()) as T
            }
        }.create(CardViewModel::class.java)
    }

    private lateinit var cardViewModel2 : CardViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(layoutInflater, container, false)

        cardViewModel2 = CardViewModel(binding.etSearchName.text.toString(), null, CardsRepositoryImpl())

        binding.btnLookupCardButton.setOnClickListener {
            configureObserver()
        }
        //configureObserver()
        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun configureObserver()
    {
        if(!binding.etSearchName.text.isNullOrBlank())
        {
            cardViewModel2 = CardViewModel(binding.etSearchName.text.toString(), null ,CardsRepositoryImpl())
            cardViewModel2.cards.observe(viewLifecycleOwner){response ->
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
        else if(binding.etSearchName.text.isNullOrBlank() && binding.spinRarity.selectedItem.toString() != "Select rarity...")
        {
            cardViewModel2 = CardViewModel(null, binding.spinRarity.selectedItem.toString() ,CardsRepositoryImpl())
            cardViewModel2.cards.observe(viewLifecycleOwner){response ->
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
//        cardViewModel2 = CardViewModel(binding.etSearchName.text.toString(), null ,CardsRepositoryImpl())
//        cardViewModel2.cards.observe(viewLifecycleOwner){response ->
//            if(response.cards.isEmpty())
//            {
//                binding.etSearchName.hint = "Error"
//            }
//            else
//            {
//                cardRecyclerViewAdapter = CardRecyclerViewAdapter(openCardDetails = ::openCardDetails)
//                cardRecyclerViewAdapter.addNewCards(response.cards)
//                binding.rvMagicRecyclerView.adapter = cardRecyclerViewAdapter
//            }
//        }
    }

    private fun openCardDetails(card: CardObject)
    {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fcvContainer, DetailsFragment.newInstance(card))
            .addToBackStack("detailsFragment")
            .commit()
    }

}
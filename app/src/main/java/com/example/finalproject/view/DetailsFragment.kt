package com.example.finalproject.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.example.finalproject.databinding.FragmentDetailsBinding
import com.example.finalproject.model.Card
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


        binding.tvDetailsCardName.text = card.name
        binding.tvDetailsManaCost.text = card.manaCost
        binding.tvDetailsText.text = card.text
        binding.tvType.text = card.type
        var rulingText: String = "Rulings: "
        if(!card.rulings.isNullOrEmpty())
        {
            for(i in 0 until card.rulings.size)
            {
                rulingText += "\t${card.rulings[i].date}: ${card.rulings[i].text}\n"
            }
        }


        binding.tvDetailsRulings.text = rulingText

        binding.wvDetailsWebView.loadUrl(card.imageUrl)
        binding.wvDetailsWebView.settings.javaScriptEnabled = true
        binding.wvDetailsWebView.settings.loadWithOverviewMode = true
        binding.wvDetailsWebView.settings.useWideViewPort = true
        binding.wvDetailsWebView.webViewClient = WebViewClient()

        binding.btnBack.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
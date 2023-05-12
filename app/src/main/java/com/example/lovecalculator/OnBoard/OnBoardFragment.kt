package com.example.lovecalculator.OnBoard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.Pref
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.FragmentOnBoardBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OnBoardingFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardBinding
    private lateinit var adapter: OnBoardingAdapter

    @Inject
    lateinit var pref: Pref

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = OnBoardingAdapter(this::onClick)
        binding.vpBoard.adapter = adapter

        if (pref.isUserSeen()){
            findNavController().navigate(R.id.firstFragment)
        }
    }

    private fun onClick(){
        pref.isUserSeenOnBoarding()
        findNavController().navigate(R.id.onBoardingFragment)
    }
}
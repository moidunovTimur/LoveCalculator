package com.example.lovecalculator.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.FragmentFirstBinding
import com.example.lovecalculator.LoveViewModel

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    val viewModel: LoveViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            calculateBtn.setOnClickListener {
                viewModel.liveLove(firstNameED.text.toString(), secondNameED.text.toString())
                    .observe(viewLifecycleOwner) { LoveModel ->
                        Log.e("ololo", "initClickers:${LoveModel}")
                        findNavController().navigate(R.id.resultFragment, bundleOf("key" to LoveModel))
                    }
            }
        }
    }
}

// first

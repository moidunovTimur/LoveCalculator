package com.example.lovecalculator.OnBoard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.ItemOnBoardBinding

class OnBoardingAdapter(private val onClick: () -> Unit) :
    Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {
    private val data = arrayListOf(
        OnBoarding(
            R.drawable.first,
            "Have a good time!",
            "You should take the time to help those \n who who need you"
        ),
        OnBoarding(
            R.drawable.second,
            "Cherishing love",
            "It is now no longer possible for\nyou to cherish love"
        ),
        OnBoarding(
            R.drawable.third,
            "Have a breakup?",
            "We have made the correction for you\n don't worry\n Maybe someone is waiting for you!"
        ),
        OnBoarding(R.drawable.fourth, "It's Funs and Many more", " ")
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemOnBoardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    inner class OnBoardingViewHolder(private val binding: ItemOnBoardBinding) :
        ViewHolder(binding.root) {

        fun bind(onBoarding: OnBoarding) {
            binding.apply {
                onBoarding.image?.let { image.setImageResource(it) }
                title.text = onBoarding.title
                desc.text = onBoarding.desc
                binding.btnGetStart.isVisible = adapterPosition == data.lastIndex
                binding.btnGetStart.setOnClickListener {
                    onClick()
                }
            }
        }

    }
}
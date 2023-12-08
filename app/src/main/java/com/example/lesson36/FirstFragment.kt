package com.example.lesson36

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.lesson36.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    private lateinit var viewModel: CounterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[CounterViewModel::class.java]

        viewModel.counter.observe(viewLifecycleOwner) { count ->
            binding.textCounter.text = count.toString()
        }

        binding.buttonPlus.setOnClickListener {
            if (binding.textCounter.text == "10") {
                val secondFragment = SecondFragment()

                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                transaction.replace(R.id.fragmentContainer, secondFragment)
                transaction.addToBackStack(null)
                transaction.commit()
            }
            viewModel.increment()
        }

        binding.buttonMinus.setOnClickListener {
            viewModel.decrement()
        }
    }
}

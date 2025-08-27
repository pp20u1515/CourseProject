package ru.bmstu.dc.architectureanddi.presentation.ui.details

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.bmstu.dc.architectureanddi.R
import ru.bmstu.dc.architectureanddi.databinding.FragmentDetailsBinding

@AndroidEntryPoint
class DetailsFragment : Fragment() {

    private val viewModel: DetailsViewModel by viewModels()
    private var _binding: FragmentDetailsBinding? = null
    private val binding: FragmentDetailsBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            if (findNavController().previousBackStackEntry != null) {
                findNavController().popBackStack()
            }
        }
        _binding = FragmentDetailsBinding.inflate(layoutInflater, container, false)
        binding.vm = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
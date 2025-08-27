package ru.bmstu.dc.architectureanddi.presentation.ui.auth

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import ru.bmstu.dc.architectureanddi.R
import ru.bmstu.dc.architectureanddi.databinding.FragmentAuthBinding
import ru.bmstu.dc.architectureanddi.presentation.ui.userlist.UserListFragment

@AndroidEntryPoint
class AuthFragment : Fragment() {
    private var _binding: FragmentAuthBinding? = null
    private val binding: FragmentAuthBinding get() = _binding!!

    private val viewModel: AuthViewModel by viewModels()

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAuthBinding.inflate(layoutInflater, container, false)
        binding.vm = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
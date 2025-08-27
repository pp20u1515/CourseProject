package ru.bmstu.dc.architectureanddi.presentation.ui.userlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import ru.bmstu.dc.architectureanddi.databinding.FragmentUserListBinding

@AndroidEntryPoint
class UserListFragment : Fragment() {
    private var _binding: FragmentUserListBinding? = null
    private val binding: FragmentUserListBinding get() = _binding!!


    private val viewModel: UserListViewModel by viewModels()

    private val args: UserListFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserListBinding.inflate(layoutInflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.vm = viewModel
        val credentials = args.credentials
        if (credentials == null) {
            val direction = UserListFragmentDirections.actionUserListFragmentToAuthFragment()
            findNavController().navigate(direction)
        } else {
            binding.textField.text = credentials.toString()
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
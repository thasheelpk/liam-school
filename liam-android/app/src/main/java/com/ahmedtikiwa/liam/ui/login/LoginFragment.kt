package com.ahmedtikiwa.liam.ui.login

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.ahmedtikiwa.MainActivity
import com.ahmedtikiwa.liam.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    private val viewModel: LoginViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentLoginBinding.inflate(inflater)

        binding.lifecycleOwner = viewLifecycleOwner

        binding.viewModel = viewModel

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.navigateToDashboard.observe(viewLifecycleOwner, Observer {
            if (it) {
                this.findNavController().navigate(
                    LoginFragmentDirections.actionLoginFragmentToDashboardFragment()
                )
                viewModel.navigateToDashboardComplete()
            }
        })

        viewModel.navigateToSignUp.observe(viewLifecycleOwner, Observer {
            if (it) {
                this.findNavController().navigate(
                    LoginFragmentDirections.actionLoginFragmentToSignUpFragment()
                )
                viewModel.navigateToSignUpComplete()
            }
        })
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as MainActivity).hideBottomNavigation()
    }

    override fun onDetach() {
        super.onDetach()
        (activity as MainActivity).showBottomNavigation()
    }

    override fun onStart() {
        super.onStart()
        (activity as MainActivity).hideToolbar()
    }

    override fun onStop() {
        super.onStop()
        (activity as MainActivity).showToolbar()
    }
}
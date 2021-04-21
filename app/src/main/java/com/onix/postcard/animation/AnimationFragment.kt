package com.onix.postcard.animation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.onix.postcard.databinding.FragmentAnimationBinding

class AnimationFragment : Fragment() {

    private lateinit var binding: FragmentAnimationBinding
    private val args: AnimationFragmentArgs by navArgs()
    private val viewModel: AnimationViewModel by viewModels { AnimationViewModelFactory(args.settingModel) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAnimationBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
    }

}
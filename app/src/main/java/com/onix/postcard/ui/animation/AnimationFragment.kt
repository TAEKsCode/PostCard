package com.onix.postcard.ui.animation

import android.graphics.Paint
import android.graphics.Rect
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.onix.postcard.R
import com.onix.postcard.databinding.FragmentAnimationBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class AnimationFragment : Fragment() {

    private val args: AnimationFragmentArgs by navArgs()

    private val viewModel: AnimationViewModel by viewModel { parametersOf(args.settingModel) }

    private lateinit var binding: FragmentAnimationBinding
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

//    private fun setImageSpans() {
//        val builder = StringBuilder(viewModel.model.title).apply {
//            insert(0, " ")
//            insert(this.length, " ")
//        }
//        val spannableString = SpannableStringBuilder(builder)
//
//        val drawable = viewModel.model.backgroundDrawable
//        val right = resources.getDimension(R.dimen.settings_button_text_size).toInt()
//        val bottom = resources.getDimension(R.dimen.settings_button_text_size).toInt()
//
//        val paint = Paint()
//        val rect = Rect()
//        paint.getTextBounds(spannableString.toString(), 0, spannableString.length, rect)
//
//        drawable.setBounds(
//            0,
//            0,
//            right,
//            bottom
//        )
//
//        spannableString.setSpan(object : ClickableSpan() {
//            override fun onClick(widget: View) {
//                Toast.makeText(requireContext(), "Clicked!", Toast.LENGTH_LONG).show()
//            }
//
//            override fun updateDrawState(ds: TextPaint) {}
//        }, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
//
//        spannableString.setSpan(object : ClickableSpan() {
//            override fun onClick(widget: View) {
//                Toast.makeText(requireContext(), "Clicked! Second!", Toast.LENGTH_LONG).show()
//            }
//
//            override fun updateDrawState(ds: TextPaint) {}
//        }, 1, 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
//
//        spannableString.setSpan(object : ClickableSpan() {
//            override fun onClick(widget: View) {
//                Toast.makeText(requireContext(), "Clicked! Third!", Toast.LENGTH_LONG).show()
//            }
//
//            override fun updateDrawState(ds: TextPaint) {}
//        }, 2, 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
//
//        binding.animationTitle.text = spannableString
//        binding.animationTitle.movementMethod = LinkMovementMethod.getInstance()
//    }

}
package com.onix.postcard.ui.stub

import android.Manifest
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts.RequestPermission
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.onix.postcard.databinding.FragmentStubBinding

class PermissionFragment : Fragment() {
    private lateinit var requestPermissionLauncher: ActivityResultLauncher<String>

    private val viewModel: PermissionViewModel by viewModels()
    private lateinit var binding: FragmentStubBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        initializePermissionLauncher()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStubBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
    }

    override fun onResume() {
        super.onResume()
        checkAndAskPermissions()
    }

    private fun initializePermissionLauncher() {
        requestPermissionLauncher =
            registerForActivityResult(RequestPermission()) { isGranted ->
                if (isGranted) {
                    Toast.makeText(requireContext(), "Granted!!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(requireContext(), "Permission was denied", Toast.LENGTH_SHORT)
                        .show()
                }
            }
    }

    private fun checkAndAskPermissions() {
        when {
            ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED -> {
            }
            shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_FINE_LOCATION) -> {
                requestPermissionLauncher.launch(
                    Manifest.permission.ACCESS_FINE_LOCATION
                )
            }
            else -> {
                AlertDialog.Builder(requireContext())
                    .setMessage("You must allow location permission!").setPositiveButton(
                        "Ok"
                    ) { _, _ -> requireContext().openAppSystemSettings() }
                    .setNegativeButton("Cancel") { _, _ -> requireActivity().finish() }
                    .setCancelable(false)
                    .show()
            }
        }
    }

    private fun Context.openAppSystemSettings() {
        startActivity(Intent().apply {
            action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
            data = Uri.fromParts("package", packageName, null)
        })
    }

}

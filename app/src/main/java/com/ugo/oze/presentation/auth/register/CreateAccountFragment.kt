package com.ugo.oze.presentation.auth.register

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.viewModels
import com.ugo.oze.R
import com.ugo.oze.databinding.FragmentCreateAccountBinding
import com.ugo.oze.main.base.BaseFragment
import com.ugo.oze.utility.showSoftInput

class CreateAccountFragment :
    BaseFragment<FragmentCreateAccountBinding, CreateAccountViewModel>(),
    CreateNewAccountTrait {

    override val layoutRes: Int
        get() = R.layout.fragment_create_account

    override val viewModel: CreateAccountViewModel by viewModels { factory }

    override fun bindView(binding: FragmentCreateAccountBinding) {
        binding
            .also { it.disposables = disposables }
            .also { it.viewModel = viewModel }
        initObservers()
        showWrongNumberFormatMessage()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Show soft input.
        binding.editTextPhoneNumber.showSoftInput()

        // Init counter picker listener.
        initCountryCodePicker()
    }

    private fun initObservers() {
        viewModel.otpSend.observe(this, ::otpSendResult)
        viewModel.loginClicked.observe(viewLifecycleOwner) {
            navigateToLogin()
        }
    }

    // region Validate Phone Number

    private fun showValidationErrors() {
        binding.textInputLayoutPhoneNumber.error = resources.getString(
            R.string.invalid_phone_number
        )
    }

    private fun hideValidationErrors() {
        binding.textInputLayoutPhoneNumber.error = null
        binding.textInputLayoutPhoneNumber.isErrorEnabled = false
    }

    private fun showWrongNumberFormatMessage() {
        binding.editTextPhoneNumber.doOnTextChanged { text, _, _, _ ->
            val countryCode = binding.countryPicker.selectedCountryCode
            if (text.toString().startsWith(countryCode)) {
                showValidationErrors()
            } else {
                hideValidationErrors()
            }
        }
    }

    // endregion

    private fun otpSendResult(result: SendResult) {
        when (result.completed) {
            true -> navigateToNextScreen(result.phoneNumber, result.countryCode)
            false -> Toast.makeText(context, "something went wrong!", Toast.LENGTH_LONG).show()
        }
    }

    private fun navigateToNextScreen(phoneNumber: String, countryCode: Int) {
        navigateToOTP(phoneNumber, countryCode)
    }

    //region Country Code Picker

    private fun initCountryCodePicker() {
        binding.countryPicker.showFlag(false)
        binding.countryPicker.setOnCountryChangeListener {
            viewModel.onCountryCodeChanged(
                binding.countryPicker.selectedCountryCode
            )
        }
    }

    //endregion

    override fun onDestroy() {
        super.onDestroy()
    }
}
package com.ugo.oze.main.base.login

import android.os.Bundle
import android.view.View
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.viewModels
import com.ugo.oze.R
import com.ugo.oze.databinding.FragmentLoginBinding
import com.ugo.oze.main.base.BaseFragment

abstract class BaseLoginFragment : BaseFragment<FragmentLoginBinding, BaseLoginViewModel>(),
    LoginTrait {

    //region Ui

    override val layoutRes: Int
        get() = R.layout.fragment_login

    //endregion

    //region View Model

    override val viewModel: BaseLoginViewModel by viewModels { factory }


    //endregion

    //region Lifecycle

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    //endregion

    //region Binding

    override fun bindView(binding: FragmentLoginBinding) {
        binding
            .also { it.disposables = disposables }
            .also { it.viewModel = viewModel }

        initObservers()
        initCountryCodePicker()
        showWrongNumberFormatMessage()

        binding.forgotPasswordTextView.setOnClickListener { navigateToForgotPassword() }
    }

    //endregion

    //region Observers

    private fun initObservers() {
        viewModel.loginSuccess.observe(viewLifecycleOwner, ::loginSuccess)
//        viewModel.snackbarError.observe(viewLifecycleOwner, this::showErrorMessage)
    }

    //endregion

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

    //region Login

    private fun loginSuccess(success: Boolean) {
        navigateToDatPlace()
    }

    //endregion

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

}
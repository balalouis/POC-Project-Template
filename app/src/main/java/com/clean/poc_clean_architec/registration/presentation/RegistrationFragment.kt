package com.clean.poc_clean_architec.registration.presentation


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import com.clean.poc_clean_architec.R
import com.clean.poc_clean_architec.databinding.FragmentRegistrationBinding
import com.clean.poc_clean_architec.registration.data.model.RegistrationRequestModel
import com.clean.poc_clean_architec.registration.data.model.RegistrationUiState
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RegistrationFragment : Fragment() {

    private var _binding: FragmentRegistrationBinding? = null
    private val binding get() = _binding!!
    private val registrationViewModel: RegistrationViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cancelButton.setOnClickListener {
            launchScreen(it, RegistrationFragmentDirections.actionRegistrationToLoginFragment())
        }

        binding.tvNewToApp.setOnClickListener {
            launchScreen(it, RegistrationFragmentDirections.actionRegistrationToLoginFragment())
        }

        binding.registerButton.setOnClickListener {
            if (validateUserInput(
                    binding.etUsernameRegistration,
                    binding.etEmail,
                    binding.etPasswordRegistration
                )
            ) {
                showOrHideProgressBar(View.VISIBLE)
                val registrationRequestModel = buildRegisterRequestObject(
                    binding.etEmail.text.toString(), binding.etPasswordRegistration.text.toString()
                )
                requestApiCall(view, registrationRequestModel)
            }else{
                showToastMessage("Data should not be empty")
            }
        }
    }

    private fun buildRegisterRequestObject(email: String, password: String) =
        RegistrationRequestModel(email, password)

    private fun launchScreen(view: View, action: NavDirections) {
        view.findNavController().navigate(action)
    }

    private fun showOrHideProgressBar(showOrHide: Int) {
        _binding?.registrationProgressBar?.visibility = showOrHide
    }

    private fun showSnackBar(view: View, displayText: String) {
        Snackbar.make(view, displayText, Snackbar.LENGTH_LONG).show()
    }

    private fun requestApiCall(
        view: View, registrationRequestModel: RegistrationRequestModel
    ) {
        registrationViewModel.register(registrationRequestModel)
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                registrationViewModel.uiState.collect { uiState ->
                    when (uiState) {
                        is RegistrationUiState.Success -> {
                            if (uiState.registrationResponseModel?.token?.isNotEmpty() == true) {
                                showSnackBar(view, getString(R.string.register_successfully))
                                launchScreen(
                                    view,
                                    RegistrationFragmentDirections.actionRegistrationToUserListFragment()
                                )
                                showOrHideProgressBar(View.GONE)
                            } else {
                                showSnackBar(view, "token is empty")
                            }
                        }
                        is RegistrationUiState.Error -> {
                            showSnackBar(view, "" + uiState.exception.message)
                            showOrHideProgressBar(View.GONE)
                        }
                    }
                }
            }
        }
    }

    private fun validateUserInput(
        editTextUserName: EditText,
        editTextPassword: EditText,
        editTextConfirmPassword: EditText
    ): Boolean {
        return validateUserName(editTextUserName) && validatePassword(editTextPassword) && validateConfirmPassword(
            editTextConfirmPassword
        )
    }

    private fun validateUserName(editTextUserName: EditText): Boolean {
        return editTextUserName.text.isNotEmpty() && validateUserNameLength(editTextUserName.text.toString())
    }

    fun validateUserNameLength(userName: String): Boolean {
        return userName.length > 5
    }

    private fun validatePassword(editTextPassword: EditText): Boolean {
        return editTextPassword.text.isNotEmpty() && validatePasswordLength(editTextPassword.text.toString())
    }

    fun validatePasswordLength(password: String): Boolean {
        return password.length > 4
    }

    private fun validateConfirmPassword(editTextConfirmPassword: EditText): Boolean {
        return editTextConfirmPassword.text.isNotEmpty() && validateConfirmPasswordLength(
            editTextConfirmPassword.text.toString()
        )
    }

    fun validateConfirmPasswordLength(password: String): Boolean {
        return password.length > 4
    }

    private fun showToastMessage(message: String) {
        Toast.makeText(activity, "" + message, Toast.LENGTH_LONG).show()
    }

}

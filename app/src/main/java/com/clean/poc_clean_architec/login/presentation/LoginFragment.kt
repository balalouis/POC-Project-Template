package com.clean.poc_clean_architec.login.presentation


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
import com.clean.poc_clean_architec.databinding.FragmentLoginBinding
import com.clean.poc_clean_architec.login.data.model.LoginRequestModel
import com.clean.poc_clean_architec.login.data.model.LoginUIState
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private val loginViewModel: LoginViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {
            if (validateUserInput(binding.etUsernameLogin, binding.etPasswordLogin)) {
                showOrHideProgressBar(View.VISIBLE)
                val loginRequestModel = buildLoginRequestObject(
                    binding.etUsernameLogin.text.toString(), binding.etPasswordLogin.text.toString()
                )

                requestLoginApiCall(it, loginRequestModel)
            } else {
                showToastMessage(getString(R.string.empty_data))
            }
        }

        binding.tvNewToApp.setOnClickListener {
            val action = LoginFragmentDirections.actionLoginToRegistrationFragment()
            launchScreen(it, action)
        }
    }

    private fun requestLoginApiCall(
        view: View,
        loginRequestModel: LoginRequestModel
    ) {
        loginViewModel.login(loginRequestModel)

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                loginViewModel.uiState.collect { uiState ->
                    when (uiState) {
                        is LoginUIState.Success -> {
                            val token = uiState.loginResponseModel?.token
                            if (token?.isNotEmpty() == true) {
                                showSnackBar(view, getString(R.string.login_successfully))
                                launchScreen(
                                    view,
                                    LoginFragmentDirections.actionLoginToUserListFragment()
                                )
                                showOrHideProgressBar(View.GONE)
                            }
                        }
                        is LoginUIState.Failure -> {
                            showToastMessage(getString(R.string.invalid_credential))
                            showOrHideProgressBar(View.GONE)
                        }
                    }
                }
            }
        }
    }

    private fun showSnackBar(view: View, displayText: String) {
        Snackbar.make(view, displayText, Snackbar.LENGTH_LONG).show()
    }

    private fun showOrHideProgressBar(showOrHide: Int) {
        binding.loginProgressBar.visibility = showOrHide
    }

    private fun buildLoginRequestObject(email: String, password: String) =
        LoginRequestModel(email, password)

    private fun launchScreen(view: View, action: NavDirections) {
        view.findNavController().navigate(action)
    }

    private fun validateUserInput(editTextUserName: EditText, editTextPassword: EditText): Boolean {
        return validateUserName(editTextUserName) && validatePassword(editTextPassword)
    }

    private fun validateUserName(editTextUserName: EditText): Boolean {
        return editTextUserName.text.isNotEmpty() && validateUserNameLength(editTextUserName.text.toString())
    }

    private fun validateUserNameLength(userName: String): Boolean {
        return userName.length > 5
    }

    private fun validatePassword(editTextPassword: EditText): Boolean {
        return editTextPassword.text.isNotEmpty() && validatePasswordLength(editTextPassword.text.toString())
    }

    private fun validatePasswordLength(password: String): Boolean {
        return password.length > 4
    }

    private fun showToastMessage(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}

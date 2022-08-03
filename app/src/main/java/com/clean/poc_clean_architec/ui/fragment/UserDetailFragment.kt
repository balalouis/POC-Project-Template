package com.clean.poc_clean_architec.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.navArgs
import com.clean.poc_clean_architec.R
import com.clean.poc_clean_architec.databinding.FragmentUserDetailBinding
import com.clean.poc_clean_architec.domain.model.UserDetailUIState
import com.clean.poc_clean_architec.domain.model.UserUIData
import com.clean.poc_clean_architec.ui.viewmodel.UserDetailViewModel
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class UserDetailFragment : Fragment() {

    private lateinit var binding: FragmentUserDetailBinding
    private val viewModel: UserDetailViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentUserDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val safeArgs: UserDetailFragmentArgs by navArgs()
        val userId = safeArgs.userIdArgs

        viewModel.fetchUserDetail(userId = userId.toString())
        fetchUserDetail(view)
    }

    private fun fetchUserDetail(view: View) {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect {
                    when (it) {
                        is UserDetailUIState.Success -> {
                            setUserData(it.user)
                        }
                        is UserDetailUIState.Failure -> {
                            showSnackBar(view, it.exception.message.toString())
                            showOrHideProgressBar(View.GONE)
                        }
                    }
                }
            }
        }

    }

    private fun setUserData(user: UserUIData?) {
        binding.tvFirstName.text = user?.userFirstName
        binding.tvLastName.text = user?.userLastName
        binding.tvEmail.text = user?.userEmail
        showOrHideProgressBar(View.GONE)

        Picasso.get()
            .load(user?.userAvatar).fit().centerCrop()
            .placeholder(R.drawable.ic_baseline_account_circle_24)
            .error(R.drawable.ic_baseline_account_circle_24)
            .into(binding.ivUserImage)
    }

    private fun showSnackBar(view: View, displayText: String) {
        Snackbar.make(view, displayText, Snackbar.LENGTH_LONG).show()
    }

    private fun showOrHideProgressBar(showOrHide: Int) {
        binding.detailProgressBar.visibility = showOrHide
    }

}
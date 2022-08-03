package com.clean.poc_clean_architec.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.clean.poc_clean_architec.databinding.FragmentUserListBinding
import com.clean.poc_clean_architec.domain.model.User
import com.clean.poc_clean_architec.domain.model.UserUIState
import com.clean.poc_clean_architec.ui.adapter.UserListAdapter
import com.clean.poc_clean_architec.ui.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class UserListFragment : Fragment() {

    private lateinit var binding: FragmentUserListBinding
    private val mainViewModel: UserViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentUserListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fetchUserList()
    }

    private fun fetchUserList() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                mainViewModel.fetchUserList()
                mainViewModel._uiState.collect {
                    when (it) {
                        is UserUIState.Success -> {
                            updateUserListAdapter(it.userList)
                        }
                        is UserUIState.Failure -> {
                            Toast.makeText(context, "" + it.exception.message, Toast.LENGTH_LONG)
                                .show()
                        }
                    }
                }
            }
        }
    }

    private fun updateUserListAdapter(userList: List<User>?) {
        val userListAdapter = userList?.let { context?.let { it1 -> UserListAdapter(it1, it) } }
        val userListRecyclerView = binding.myRecyclerView
        userListRecyclerView.adapter = userListAdapter
        userListRecyclerView.layoutManager = LinearLayoutManager(activity)
    }

}
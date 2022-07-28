package com.clean.poc_clean_architec.uilayer

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
import com.clean.poc_clean_architec.databinding.FragmentDummyBinding
import com.clean.poc_clean_architec.databinding.FragmentMainBinding
import com.clean.poc_clean_architec.model.User
import com.clean.poc_clean_architec.model.UserUIState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

class DummyFragment : Fragment() {

    private lateinit var binding: FragmentDummyBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentDummyBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


}
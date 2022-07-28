package com.clean.poc_clean_architec.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.clean.poc_clean_architec.R
import com.clean.poc_clean_architec.databinding.ActivityCleanBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CleanActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCleanBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCleanBinding.inflate(LayoutInflater.from(baseContext))
        setContentView(binding.root)

        supportFragmentManager.commit {
            add<CleanFragment>(R.id.fragmentContainerView)
        }

    }
}
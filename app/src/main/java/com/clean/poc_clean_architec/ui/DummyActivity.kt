package com.clean.poc_clean_architec.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.clean.poc_clean_architec.R
import com.clean.poc_clean_architec.databinding.ActivityMainBinding
import com.clean.poc_clean_architec.databinding.DummyMainBinding
import dagger.hilt.android.AndroidEntryPoint

class DummyActivity : AppCompatActivity() {
    private lateinit var binding: DummyMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DummyMainBinding.inflate(LayoutInflater.from(baseContext))
        setContentView(binding.root)

        supportFragmentManager.commit {
            add<DummyFragment>(R.id.fragmentContainerView)
        }

    }
}
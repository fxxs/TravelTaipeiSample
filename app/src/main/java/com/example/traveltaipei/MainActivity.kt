package com.example.traveltaipei

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.model.Language
import com.example.traveltaipei.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_explore, R.id.navigation_events, R.id.navigation_tour
            )
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.translate -> {
                true
            }

            R.id.lang_zh_tw -> {
                // 繁中
                viewModel.setLanguage(Language.ZH_TW)
                true
            }

            R.id.lang_zh_cn -> {
                // 簡中
                viewModel.setLanguage(Language.ZH_CN)
                true
            }

            R.id.lang_en -> {
                // eng
                viewModel.setLanguage(Language.EN)
                true
            }

            R.id.lang_ja -> {
                // 日文
                viewModel.setLanguage(Language.JA)
                true
            }

            R.id.lang_ko -> {
                // 韓文
                viewModel.setLanguage(Language.KO)
                true
            }

            R.id.lang_es -> {
                // 西班牙文
                viewModel.setLanguage(Language.ES)
                true
            }

            R.id.lang_id -> {
                // 印尼文
                viewModel.setLanguage(Language.ID)
                true
            }

            R.id.lang_th -> {
                // 泰文
                viewModel.setLanguage(Language.TH)
                true
            }

            R.id.lang_vi -> {
                // 越南文
                viewModel.setLanguage(Language.VI)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}
package com.example.arfansiregargithub.presentation.welcome_screen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.viewpager.widget.ViewPager
import com.example.arfansiregargithub.databinding.ActivityWelcomeBinding
import com.example.arfansiregargithub.domain.adapter.WelcomeAdapter
import com.example.arfansiregargithub.domain.utils.SessionManager
import com.example.arfansiregargithub.domain.utils.removeView
import com.example.arfansiregargithub.domain.utils.showView
import com.example.arfansiregargithub.presentation.search_screen.SearchActivity

class WelcomeActivity : AppCompatActivity() {

    private var _binding: ActivityWelcomeBinding? = null

    private val binding get() = _binding as ActivityWelcomeBinding

    private lateinit var sessionManager: SessionManager

    private var welcomeAdapter: WelcomeAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityWelcomeBinding.inflate(layoutInflater)
        welcomeAdapter = WelcomeAdapter.instance()
        sessionManager = SessionManager(this)
        setContentView(binding.root)

        iniViewPager()
    }

    private fun iniViewPager() {
        with(binding) {
            vpWelcome.apply {
                adapter = welcomeAdapter

                addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
                    override fun onPageScrolled(
                        position: Int,
                        positionOffset: Float,
                        positionOffsetPixels: Int
                    ) {}

                    override fun onPageSelected(position: Int) {
                        when(position) {
                            2 -> {
                                lifecycleScope.launchWhenStarted {
                                    sessionManager.setFirstInstall(true)
                                    btnNext.showView()
                                }
                            }
                            else -> {
                                btnNext.removeView()
                            }
                        }
                    }

                    override fun onPageScrollStateChanged(state: Int) {}

                })
            }

            indicatorView.apply {
                attachTo(vpWelcome)
            }

            binding.btnNext.setOnClickListener {
                homeView()
            }
        }
    }

    private fun homeView() {
        startActivity(Intent(this, SearchActivity::class.java))
        finish()
    }
}
package com.example.projectforexam.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager.widget.ViewPager
import com.example.projectforexam.R
import com.example.projectforexam.adapter.AdapterFragment
import com.example.projectforexam.fragment.FirstFragment
import com.example.projectforexam.fragment.FourthFragment
import com.example.projectforexam.fragment.SecondFragment
import com.example.projectforexam.fragment.ThirdFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var secondPage: SecondFragment
    lateinit var thirdFragment: ThirdFragment
    lateinit var fourthFragment: FourthFragment
    lateinit var adapterFragment: AdapterFragment
    lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        tv_skip.setOnClickListener{
            jumpLast()
        }
        tv_next.setOnClickListener {
            jumpNext()
        }
        tv_done.setOnClickListener{
            val intent = Intent(this,HomeActivity::class.java)
            startActivity(intent)
        }

    }

    private fun jumpLast() {
        viewPager.setCurrentItem(4, true)
    }

    private fun initView() {
        viewPager = findViewById(R.id.viewPager)

        adapterFragment = AdapterFragment(supportFragmentManager)
        secondPage = SecondFragment()
        thirdFragment = ThirdFragment()
        fourthFragment = FourthFragment()

        adapterFragment.add(FirstFragment(), "Page 1")
        adapterFragment.add(secondPage, "Page 2")
        adapterFragment.add(thirdFragment, "Page 3")
        adapterFragment.add(FourthFragment(), "Page 4")

        viewPager.adapter = adapterFragment
        worm_dots_indicator.setViewPager(viewPager)

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                if (viewPager.currentItem == 3) {
                    tv_skip.visibility = View.GONE
                    tv_next.visibility = View.GONE
                    tv_done.visibility = View.VISIBLE
                }
                if (tv_skip.visibility == View.GONE && viewPager.currentItem < 3) {
                    tv_skip.visibility = View.VISIBLE
                    tv_next.visibility = View.VISIBLE
                    tv_done.visibility = View.GONE

                }
            }
        })

    }

    fun jumpNext() {
        viewPager.setCurrentItem(viewPager.currentItem + 1, true)
    }

}

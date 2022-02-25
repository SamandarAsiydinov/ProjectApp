package com.example.projectforexam.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.amazonuiclone.adapter.FavouriteAdapter
import com.example.amazonuiclone.adapter.PopularAdapter
import com.example.amazonuiclone.model.Essential
import com.example.amazonuiclone.model.Popular
import com.example.projectforexam.R

class HomeActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var recyclerViewPop: RecyclerView
    lateinit var ll_fashion: LinearLayout
    lateinit var ll_popular: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        initView()
        initView2()

    }

    private fun initView() {
        recyclerView = findViewById(R.id.rv_essential)
        /*ll_popular = findViewById(R.id.ll_popular)*/

        val manager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = manager
        refreshAdapter(getEssen())

       /* setLinearHeight(ll_fashion)
        setLinearHeight(ll_popular)*/
    }
    private fun initView2() {
        recyclerViewPop = findViewById(R.id.rv_popular)

        val manager = GridLayoutManager(this, 2)
        recyclerViewPop.layoutManager = manager
        refreshAdapter2(getPopulars())

    }

  /*  private fun setLinearHeight(linear: LinearLayout) {
        val desplayMatrix = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(desplayMatrix)
        val heightPixel = desplayMatrix.heightPixels
        val heightInDp: Int = heightPixel / resources.displayMetrics.density.toInt()
        val params: ViewGroup.LayoutParams = linear.layoutParams
        params.height = heightInDp
        linear.layoutParams = params
    }*/

    private fun refreshAdapter(items: ArrayList<Essential>) {
        val adapter = FavouriteAdapter(this, items)
        recyclerView.adapter = adapter
    }
    private fun refreshAdapter2(items: ArrayList<Popular>) {
        val adapter = PopularAdapter(items)
        recyclerViewPop.adapter = adapter
    }

    fun getEssen(): ArrayList<Essential> {
        val essen: ArrayList<Essential> = ArrayList()

        essen.add(Essential("Cool", R.drawable.img_1))
        essen.add(Essential("Cool", R.drawable.img))
        essen.add(Essential("Cool", R.drawable.img_1))
        essen.add(Essential("Cool", R.drawable.img))

        return essen

    }
    fun getPopulars(): ArrayList<Popular> {
        val populars: ArrayList<Popular> = ArrayList()

        populars.add(Popular(R.drawable.img_1))
        populars.add(Popular(R.drawable.img))
        populars.add(Popular(R.drawable.img_1))
        populars.add(Popular(R.drawable.img))
        populars.add(Popular(R.drawable.img_1))
        populars.add(Popular(R.drawable.img))


        return populars

    }


}
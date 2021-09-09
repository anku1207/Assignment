package com.example.assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment.adapter.MainActivityAdapter
import com.example.assignment.httpRequest.Status
import com.example.assignment.model.GalleryVO
import com.example.assignment.modelview.MainActivityViewModel
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    lateinit var mainActivityViewModel : MainActivityViewModel
    lateinit var recyclerView :RecyclerView
    lateinit var mainActivityAdapter: MainActivityAdapter
    lateinit var dataList :ArrayList<GalleryVO>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityViewModel=ViewModelProvider(this).get(MainActivityViewModel::class.java)


        recyclerView=findViewById(R.id.recyclerView)
        dataList= ArrayList()

        recyclerView.layoutManager=LinearLayoutManager(this)

        mainActivityAdapter= MainActivityAdapter(context = this,dataList = dataList)
        recyclerView.adapter=mainActivityAdapter

        mainActivityViewModel.getDashboardData().observe(this, Observer {
            when(it.status){
                Status.LOADING-> {

                }
                Status.ERROR-> {

                }

                Status.SUCCESS-> {
                    if(it.data?.code==200){
                        it.data.data?.let { it1 ->
                            for (GALLERY in it1){
                                if(!GALLERY.GALLERY!!.isEmpty()){
                                    dataList.add(GALLERY)
                                }
                            }
                           }
                        mainActivityAdapter.notifyDataSetChanged()
                    }
                }
            }
        })
    }
}
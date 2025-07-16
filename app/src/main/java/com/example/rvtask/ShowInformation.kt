package com.example.rvtask

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rvtask.model.UsersData
import com.example.rvtask.recyclerView.AdapterForShowData

class ShowInformation : AppCompatActivity() {

    lateinit var adapterForShowData: AdapterForShowData
    lateinit var recyclerView: RecyclerView
    lateinit var list: ArrayList<UsersData>
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_information)
        recyclerView = findViewById(R.id.my_rec_tv)

        var my_data = intent!!.extras

        var name = my_data!!.getString("name").toString()
        var phone = my_data!!.getString("phone").toString()
        var description = my_data!!.getString("description").toString()
        var uri = my_data!!.getString("uri").toString()
        var data = UsersData(name, phone, description, uri)
        list=ArrayList()
        list.add(data)
        list.add(data)
        list.add(data)
        list.add(data)
        adapterForShowData = AdapterForShowData(list)
        recyclerView.adapter = adapterForShowData
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.setHasFixedSize(true)


    }
}
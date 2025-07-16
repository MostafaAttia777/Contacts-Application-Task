package com.example.rvtask

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import de.hdodenhof.circleimageview.CircleImageView

class MainActivity : AppCompatActivity() {

    lateinit var name: TextInputEditText
    lateinit var phone: TextInputEditText
    lateinit var description: TextInputEditText
    lateinit var btn_send_data: Button
    lateinit var get_image_link: CircleImageView
    lateinit var galleryUri: Any
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initview()
        btn_send_data.setOnClickListener {

            send_Data_To_Show_Act()
        }
        get_image_link.setOnClickListener {
            gelleryLauncher.launch("image/*")

        }


    }

    val gelleryLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) {
        galleryUri = it!!
        try {
            get_image_link.setImageURI(it)
        } catch (e: Exception) {

            if (galleryUri == null) {
                Toast.makeText(applicationContext, "select Image", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun send_Data_To_Show_Act() {
        var ed_name = name!!.text.toString()
        var ed_phone = phone!!.text.toString()
        var ed_description = description!!.text.toString()
        var image_link_Uri = galleryUri.toString()


        if (ed_name.isNotEmpty() && ed_phone.isNotEmpty() && ed_description.isNotEmpty() && image_link_Uri.isNotEmpty()) {
            var send_bundle = Bundle()
            send_bundle.putString("uri", image_link_Uri)
            send_bundle.putString("name", ed_name)
            send_bundle.putString("phone", ed_phone)
            send_bundle.putString("description", ed_description)

            var intent = Intent(applicationContext, ShowInformation::class.java)
            intent.putExtras(send_bundle)
            startActivity(intent)

        } else{
            name.setError("enter your name")
            phone.setError("enter your phone")
            description.setError("enter your description")

        }
    }


    private fun initview() {
        name = findViewById(R.id.name_of_container_edit)
        phone = findViewById(R.id.phone_of_container_edit)
        description = findViewById(R.id.description_of_container_edit)
        btn_send_data = findViewById(R.id.btn_save)
        get_image_link = findViewById(R.id.get_image)
    }
}
package com.example.driversupervisingsystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DataInquiry : AppCompatActivity() {

    private var receivedUsername : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_inquiry)

        val tvName : TextView = findViewById(R.id.tv_username)
        receivedUsername = intent.getStringExtra("name")
        tvName.text = receivedUsername

    }

}
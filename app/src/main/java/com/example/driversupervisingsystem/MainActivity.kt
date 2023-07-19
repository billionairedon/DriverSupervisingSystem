package com.example.driversupervisingsystem

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private var auth : FirebaseAuth? = null
    private var receivedName : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvScore : TextView = findViewById(R.id.tv_score)
        val ivQrcode : ImageView = findViewById(R.id.qr_code)
        val tvName : TextView = findViewById(R.id.tv_name)
        val btnInquiry : Button = findViewById(R.id.btnInquiry)



        receivedName = try{
            intent.getStringExtra("key") as String
        }catch(e: NullPointerException){
            intent.getStringExtra("key2") as String
        }
        tvName.text = receivedName

        btnInquiry.setOnClickListener {
            val intent = Intent(this, DataInquiry::class.java)
            intent.putExtra("name",receivedName)
            startActivity(intent)
        }

    }

}

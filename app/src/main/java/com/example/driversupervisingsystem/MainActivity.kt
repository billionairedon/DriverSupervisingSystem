package com.example.driversupervisingsystem

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.voice.VoiceInteractionSession.ActivityId
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.driversupervisingsystem.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private var auth : FirebaseAuth? = null
    private var receivedName : String? = null
    private var binding : ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        if(supportActionBar != null){
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }

        setSupportActionBar(binding?.actionbarMain)
        binding?.actionbarMain?.setNavigationOnClickListener {
            onBackPressed()

        }

        receivedName = try{
            intent.getStringExtra("key") as String
        }catch(e: NullPointerException){
            intent.getStringExtra("key2") as String
        }
        binding?.tvName?.text = receivedName

        binding?.btnInquiry?.setOnClickListener {
            val intent = Intent(this, DataInquiry::class.java)
            intent.putExtra("name",receivedName)
            startActivity(intent)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}

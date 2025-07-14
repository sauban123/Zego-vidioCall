package com.example.vidiocallapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.zegocloud.uikit.prebuilt.call.ZegoUIKitPrebuiltCallConfig
import com.zegocloud.uikit.prebuilt.call.ZegoUIKitPrebuiltCallFragment

class MainActivity : AppCompatActivity() {

    companion object{
        const val APP_ID : Long =
        const val APP_SIGN = ""
        const val CALL_ID = "12345"

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.submitButton)
        val username = findViewById<EditText>(R.id.userId)
        val userid = findViewById<EditText>(R.id.Password)
        button.setOnClickListener {
            val confic=  ZegoUIKitPrebuiltCallConfig.oneOnOneVideoCall()
            val fragment = ZegoUIKitPrebuiltCallFragment.newInstance(
                APP_ID, APP_SIGN,userid.text.toString(),username.text.toString(), CALL_ID, confic
            )
            supportFragmentManager.beginTransaction()
                .replace(R.id.mainLayout, fragment)
                .commitNow()
        }
    }
}

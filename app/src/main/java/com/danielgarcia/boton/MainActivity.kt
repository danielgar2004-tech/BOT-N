package com.danielgarcia.boton

import android.content.Context
import android.hardware.camera2.CameraManager
import android.media.RingtoneManager
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var cameraManager: CameraManager
    private var cameraId: String = ""
    private var isOn = false
    private lateinit var btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        cameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager
        cameraId = cameraManager.cameraIdList[0]
        btn = findViewById(R.id.btnLinterna)
        btn.setOnClickListener { if (!isOn) encender() else apagar() }
    }

    private fun encender() {
        cameraManager.setTorchMode(cameraId, true)
        isOn = true
        btn.setBackgroundResource(R.drawable.btn_verde)
        btn.text = "ON"
        val mgr = RingtoneManager(this)
        mgr.setType(RingtoneManager.TYPE_NOTIFICATION)
        val cursor = mgr.cursor
        var uri: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        if (cursor.moveToFirst()) {
            do {
                val t = cursor.getString(RingtoneManager.TITLE_COLUMN_INDEX)
                if (t.contains("Cassiopeia", ignoreCase = true)) {
                    uri = mgr.getRingtoneUri(cursor.position)
                    break
                }
            } while (cursor.moveToNext())
        }
        cursor.close()
        RingtoneManager.getRingtone(applicationContext, uri).play()
    }

    private fun apagar() {
        cameraManager.setTorchMode(cameraId, false)
        isOn = false
        btn.setBackgroundResource(R.drawable.btn_rojo)
        btn.text = "OFF"
    }

    override fun onDestroy() {
        super.onDestroy()
        if (isOn) cameraManager.setTorchMode(cameraId, false)
    }
}

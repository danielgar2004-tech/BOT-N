package com.danielgarcia.boton

import android.content.Context
import android.hardware.camera2.CameraManager
import android.media.RingtoneManager
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var cameraManager: CameraManager
    private var cameraId: String = ""
    private var isFlashlightOn = false
    private lateinit var btnLinterna: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager
        cameraId = cameraManager.cameraIdList[0]
        btnLinterna = findViewById(R.id.btnLinterna)

        btnLinterna.setOnClickListener {
            if (!isFlashlightOn) encenderLinterna() else apagarLinterna()
        }
    }

    private fun encenderLinterna() {
        try {
            cameraManager.setTorchMode(cameraId, true)
            isFlashlightOn = true
            btnLinterna.setBackgroundResource(R.drawable.btn_verde)

cat > app/src/main/java/com/danielgarcia/boton/MainActivity.kt << 'EOF'
package com.danielgarcia.boton

import android.content.Context
import android.hardware.camera2.CameraManager
import android.media.RingtoneManager
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var cameraManager: CameraManager
    private var cameraId: String = ""
    private var isFlashlightOn = false
    private lateinit var btnLinterna: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager
        cameraId = cameraManager.cameraIdList[0]
        btnLinterna = findViewById(R.id.btnLinterna)

        btnLinterna.setOnClickListener {
            if (!isFlashlightOn) encenderLinterna() else apagarLinterna()
        }
    }

    private fun encenderLinterna() {
        try {
            cameraManager.setTorchMode(cameraId, true)
            isFlashlightOn = true
            btnLinterna.setBackgroundResource(R.drawable.btn_verde)




package co.id.systemcontrol.app

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.io.IOException


class MainActivity : AppCompatActivity() {

    /*
    * TARGET APP FUNCTION
    *
    * Power Off
    * Reboot Device
    * Update Other App
    * Update System Control
    *
    * */


    lateinit var btnPowerOff: Button

    @SuppressLint("InvalidWakeLockTag")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPowerOff = findViewById<Button>(R.id.btn_power_off)

        btnPowerOff.setOnClickListener(View.OnClickListener {
            try {
                try {
                    val proc = Runtime.getRuntime()
                        .exec(arrayOf("/system/xbin/su", "-c", "reboot"))
                    proc.waitFor()
                } catch (ex: Exception) {
                    ex.printStackTrace()
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }
        })

    }
}
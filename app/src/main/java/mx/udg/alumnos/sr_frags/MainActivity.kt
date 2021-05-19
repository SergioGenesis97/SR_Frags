package mx.udg.alumnos.sr_frags

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import mx.udg.alumnos.sr_frags.fragmentos.Fragment_segundo
import mx.udg.alumnos.sr_frags.fragmentos.Fragment_tercero
import mx.udg.alumnos.sr_frags.fragmentos.PrimerFragment

class MainActivity : AppCompatActivity() {

    lateinit var btnFragmento1:Button
    lateinit var btnFragmento2:Button
    lateinit var btnFragmento3:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnFragmento1 = findViewById(R.id.btnFrag1)
        btnFragmento2 = findViewById(R.id.btnFrag2)
        btnFragmento3 = findViewById(R.id.btnFrag3)

        btnFragmento1.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.contenedor, PrimerFragment.newInstance("nada","nada"))
                .commitNow()
        }

        btnFragmento2.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.contenedor, Fragment_segundo.newInstance("google.com"))
                .commitNow()
        }

        btnFragmento3.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.contenedor, Fragment_tercero.newInstance("nada","nada"))
                .commitNow()
        }
    }
}
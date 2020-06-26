package com.example.practica2

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //estas dos variables del tipo String nullable las uso para
    // enviarlas al Login al cerrar sesión
    private var correoMain : String? = ""
    private var contrasenaMain : String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val datosRecibidos = intent.extras
        correoMain = datosRecibidos?.getString("correo")
        contrasenaMain = datosRecibidos?.getString("contraseña")
        tv_correo_registrado.text = correoMain

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_overflow, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.menu_overflow_MainActivity) {
            val intent = Intent(this, LoginActivity::class.java)
            intent.putExtra("correo", correoMain)
            intent.putExtra("contraseña", contrasenaMain)
            startActivity(intent)
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
package mx.edu.potros.foodorder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnOlvidasteContra: Button = findViewById(R.id.btn_olvidasteContra)
        val btnLogin: Button = findViewById(R.id.btn_login)
        val btnRegistro: Button = findViewById(R.id.btn_crearCuenta)

        btnOlvidasteContra.setOnClickListener {
            var intent = Intent(this, LoginVerificacion::class.java)
            startActivity(intent)
        }

        btnLogin.setOnClickListener {
            var intent = Intent(this, Bienvenido::class.java)
            startActivity(intent)
        }

        btnRegistro.setOnClickListener {
            var intent = Intent(this, Registro::class.java)
            startActivity(intent)
        }
    }
}
package mx.edu.potros.foodorder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SeguirAgregando : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seguir_agregando)

        val btnSeguir: Button = findViewById(R.id.btn_seguir)
        val btnFinalizar: Button = findViewById(R.id.btn_finalizar)

        btnSeguir.setOnClickListener {
            var intent = Intent(this, Menu::class.java)
            startActivity(intent)
        }

        btnFinalizar.setOnClickListener {
            var intent = Intent(this, FinCuenta::class.java)
            startActivity(intent)
        }
    }
}
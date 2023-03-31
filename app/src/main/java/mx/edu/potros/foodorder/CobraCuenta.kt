package mx.edu.potros.foodorder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class CobraCuenta : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cobra_cuenta)

        val btnAceptar: Button = findViewById(R.id.btn_aceptar)
        val btnCancelar: Button = findViewById(R.id.btn_cancelar)

        btnAceptar.setOnClickListener {
            var intent = Intent(this, Confirmed::class.java)
            intent.putExtra("tipo", "cobrar")
            startActivity(intent)
        }

        btnCancelar.setOnClickListener {
            var intent = Intent(this, MenuPrincipalLista::class.java)
            startActivity(intent)
        }
    }
}
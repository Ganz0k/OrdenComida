package mx.edu.potros.foodorder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class CodigoIncorrecto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_codigo_incorrecto)

        val btnVolverEnviar: Button = findViewById(R.id.btn_volverEnviar)
        val btnRegresar: Button = findViewById(R.id.btn_regresar)

        btnVolverEnviar.setOnClickListener {
            var intent = Intent(this, Confirmed::class.java)
            startActivity(intent)
        }

        btnRegresar.setOnClickListener {
            finish()
        }
    }
}
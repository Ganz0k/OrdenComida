package mx.edu.potros.foodorder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Registro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        val btnCrear: Button = findViewById(R.id.btn_crear)

        btnCrear.setOnClickListener {
            var intent = Intent(this, Bienvenido::class.java)
            startActivity(intent)
        }
    }
}
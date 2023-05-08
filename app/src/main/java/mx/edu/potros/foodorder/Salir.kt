package mx.edu.potros.foodorder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Salir : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_salir)

        val buttonSalir: Button = findViewById(R.id.btn_salir)
        val buttonCancelar: Button = findViewById(R.id.btn_cancelar)

        buttonSalir.setOnClickListener{
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        buttonCancelar.setOnClickListener{
            var intent = Intent(this, MenuPrincipal::class.java)
            startActivity(intent)
            finish()
        }
    }
}
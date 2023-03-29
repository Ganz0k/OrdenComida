package mx.edu.potros.foodorder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MenuOrdenar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_ordenar)

        val etNombreCuenta: EditText = findViewById(R.id.et_nombre_cuenta)
        val btnOrdenar: Button = findViewById(R.id.btn_ordenar)
        val btnRegresar: Button = findViewById(R.id.btn_regresar)

        btnOrdenar.setOnClickListener {
            var intent: Intent = Intent(this, Menu::class.java)
            startActivity(intent)
        }

        btnRegresar.setOnClickListener {
            finish()
        }
    }
}
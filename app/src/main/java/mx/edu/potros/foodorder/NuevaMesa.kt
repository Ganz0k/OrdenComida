package mx.edu.potros.foodorder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView

class NuevaMesa : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nueva_mesa)

        val btnRegresar: Button = findViewById(R.id.btn_regresar)
        val etNumMesa: EditText = findViewById(R.id.et_numero_mesa)
        val ivUnaCuenta: ImageView = findViewById(R.id.iv_cuenta)
        val ivVariasCuentas: ImageView = findViewById(R.id.iv_varias_cuentas)

        ivUnaCuenta.setOnClickListener {
            var intent: Intent = Intent(this, MenuOrdenar::class.java)
            startActivity(intent)
        }

        ivVariasCuentas.setOnClickListener {
            var intent: Intent = Intent(this, MenuOrdenar::class.java)
            startActivity(intent)
        }

        btnRegresar.setOnClickListener {
            finish()
        }
    }
}
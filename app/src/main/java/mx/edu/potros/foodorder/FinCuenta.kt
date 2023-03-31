package mx.edu.potros.foodorder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class FinCuenta : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fin_cuenta)

        val btnAgregarCuenta: Button = findViewById(R.id.btn_agregar_cuenta)
        val btnIrPedido: Button = findViewById(R.id.btn_ir_pedido)

        btnAgregarCuenta.setOnClickListener {
            var intent = Intent(this, MenuOrdenar::class.java)
            startActivity(intent)
        }

        btnIrPedido.setOnClickListener {
            var intent = Intent(this, Cuenta::class.java)
            startActivity(intent)
        }
    }
}
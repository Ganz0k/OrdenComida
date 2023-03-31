package mx.edu.potros.foodorder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class EspecificacionRollo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_especificacion_rollo)

        val btnAgregar: Button = findViewById(R.id.btn_especificacion_agregar)
        val btnRegresar: Button = findViewById(R.id.btn_especificacion_regresar)
        val tvDescripcion: TextView = findViewById(R.id.tv_especificacionDescripcion)
        var ivRollo: ImageView = findViewById(R.id.iv_rollo)
        var tvNombre: TextView = findViewById(R.id.tv_nombreEspecificacionRollo)
        var tvPrecio: TextView = findViewById(R.id.tv_especificacionPrecio)

        val bundle = intent.extras

        if (bundle != null) {
            ivRollo.setImageResource(bundle.getInt("imagen"))
            tvNombre.setText(bundle.getString("nombre"))
            tvPrecio.setText("$${bundle.getDouble("precio")}")
            tvDescripcion.setText(bundle.getString("descripcion"))
        }

        btnAgregar.setOnClickListener {
            var intent = Intent(this, SeguirAgregando::class.java)
            startActivity(intent)
        }

        btnRegresar.setOnClickListener {
            finish()
        }
    }
}
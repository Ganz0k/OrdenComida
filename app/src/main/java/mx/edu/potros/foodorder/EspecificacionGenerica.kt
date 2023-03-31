package mx.edu.potros.foodorder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class EspecificacionGenerica : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_especificacion_generica)

        val btnMas: Button = findViewById(R.id.btn_especificacion_mas)
        val btnMenos: Button = findViewById(R.id.btn_especificacion_menos)
        val btnAgregar: Button = findViewById(R.id.btn_especificacion_agregar)
        val btnRegresar: Button = findViewById(R.id.btn_especificacion_regresar)
        var tvCantidad: TextView = findViewById(R.id.tv_cantidad)
        var ivComida: ImageView = findViewById(R.id.iv_especificar)
        var tvNombre: TextView = findViewById(R.id.tv_nombreComida)
        var tvPrecio: TextView = findViewById(R.id.tv_precio)
        var tvDescripcion: TextView = findViewById(R.id.tv_descripcion)

        val bundle = intent.extras

        if (bundle != null) {
            ivComida.setImageResource(bundle.getInt("imagen"))
            tvNombre.setText(bundle.getString("nombre"))
            tvPrecio.setText("$${bundle.getDouble("precio")}")
            tvDescripcion.setText(bundle.getString("descripcion"))
        }

        btnMas.setOnClickListener {
            var txtCantidad: String = tvCantidad.text.toString()

            try {
                var cantidad = Integer.parseInt(txtCantidad)
                cantidad++
                tvCantidad.setText(cantidad.toString())
            } catch (e: java.lang.Exception) {
                System.out.println("Could not parse " + e)
            }
        }

        btnMenos.setOnClickListener {
            var txtCantidad: String = tvCantidad.text.toString()

            try {
                var cantidad = Integer.parseInt(txtCantidad)
                cantidad--
                tvCantidad.setText(cantidad.toString())
            } catch (e: java.lang.Exception) {
                System.out.println("Could not parse " + e)
            }
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
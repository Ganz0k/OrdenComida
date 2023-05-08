package mx.edu.potros.foodorder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class EspecificacionGenerica : AppCompatActivity() {

    private val cuentaRef = FirebaseDatabase.getInstance().getReference("Cuentas")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_especificacion_generica)

        var numMesa: String? = ""
        var nombreCuenta: String? = ""
        var tipoPlatillo: String? = ""
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
            numMesa = bundle.getString("mesa")
            nombreCuenta = bundle.getString("cuenta")
            tipoPlatillo = bundle.getString("tipo")
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
                if (cantidad != 1) {
                    cantidad--
                    tvCantidad.setText(cantidad.toString())
                }
            } catch (e: java.lang.Exception) {
                System.out.println("Could not parse " + e)
            }
        }

        btnAgregar.setOnClickListener {
            var txtCantidad = tvCantidad.text.toString()

            try {
                var cantidad = Integer.parseInt(txtCantidad)
                agregarPlatillo(cantidad, tvNombre.text.toString(), nombreCuenta, numMesa)
            } catch (e: java.lang.Exception) {
                System.err.println("Could not parse " + e)
            }
        }

        btnRegresar.setOnClickListener {
            var intent = Intent(this, Catalogo::class.java)
            intent.putExtra("tipo", tipoPlatillo)
            intent.putExtra("mesa", numMesa)
            intent.putExtra("cuenta", nombreCuenta)
            startActivity(intent)
            finish()
        }
    }

    private fun agregarPlatillo(cantidad: Int, nombrePlatillo: String?, nombreCuenta: String?, numMesa: String?) {
        val platillo = PlatilloCuenta(cantidad, null, nombrePlatillo)

        cuentaRef.orderByChild("nombre").equalTo(nombreCuenta).addListenerForSingleValueEvent(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (s in snapshot.children) {
                    var cuentaExistente = s.getValue(CuentaBD::class.java)

                    if (cuentaExistente != null) {
                        cuentaExistente.platillos?.add(platillo)
                        s.ref.setValue(cuentaExistente)

                        var intent = Intent(this@EspecificacionGenerica, SeguirAgregando::class.java)
                        intent.putExtra("cuenta", nombreCuenta)
                        intent.putExtra("mesa", numMesa)
                        startActivity(intent)
                        finish()
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {}
        })
    }
}
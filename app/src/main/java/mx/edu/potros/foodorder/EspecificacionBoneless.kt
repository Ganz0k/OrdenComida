package mx.edu.potros.foodorder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class EspecificacionBoneless : AppCompatActivity() {

    private val cuentaRef = FirebaseDatabase.getInstance().getReference("Cuentas")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_especificacion_boneless)

        var nombreCuenta: String? = ""
        var numMesa: String? = ""
        val btnAgregar: Button = findViewById(R.id.btn_especificacion_agregar)
        val btnRegresar: Button = findViewById(R.id.btn_especificacion_regresar)
        val tvDescripcion: TextView = findViewById(R.id.tv_descripcion)

        val bundle = intent.extras

        if (bundle != null) {
            nombreCuenta = bundle.getString("cuenta")
            numMesa = bundle.getString("mesa")
            tvDescripcion.setText(bundle.getString("descripcion"))
        }

        btnAgregar.setOnClickListener {
            agregarBoneless(nombreCuenta, numMesa)
        }

        btnRegresar.setOnClickListener {
            var intent = Intent(this, Catalogo::class.java)
            intent.putExtra("tipo", "entradas")
            intent.putExtra("mesa", numMesa)
            intent.putExtra("cuenta", nombreCuenta)
            startActivity(intent)
            finish()
        }
    }

    private fun agregarBoneless(nombreCuenta: String?, numMesa: String?) {
        val salsaBbq: CheckBox = findViewById(R.id.checkBox)
        val salsaBufalo: CheckBox = findViewById(R.id.checkBox2)
        val salsaMixta: CheckBox = findViewById(R.id.checkBox3)

        val salsaChecked = listOf(salsaBbq, salsaBufalo, salsaMixta)
        var contadorSalsa = 0

        var salsaSeleccionada = ""

        for (sC in salsaChecked) {
            if (sC.isChecked) {
                salsaSeleccionada = sC.text.toString()
                contadorSalsa++
            }
        }

        if (contadorSalsa < 1 || contadorSalsa > 1) {
            Toast.makeText(this, "Escoja una salsa", Toast.LENGTH_SHORT).show()
            return
        }

        val platillo = PlatilloCuenta(1, salsaSeleccionada, "Boneless")

        cuentaRef.orderByChild("nombre").equalTo(nombreCuenta).addListenerForSingleValueEvent(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (s in snapshot.children) {
                    var cuentaExistente = s.getValue(CuentaBD::class.java)

                    if (cuentaExistente != null) {
                        cuentaExistente.platillos?.add(platillo)
                        s.ref.setValue(cuentaExistente)

                        var intent = Intent(this@EspecificacionBoneless, SeguirAgregando::class.java)
                        intent.putExtra("mesa", numMesa)
                        intent.putExtra("cuenta", nombreCuenta)
                        startActivity(intent)
                        finish()
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {}
        })
    }
}
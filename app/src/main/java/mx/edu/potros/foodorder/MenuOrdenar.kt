package mx.edu.potros.foodorder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.getValue

class MenuOrdenar : AppCompatActivity() {

    private val cuentaRef = FirebaseDatabase.getInstance().getReference("Cuentas")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_ordenar)

        var numeroMesa: String? = ""
        val tvNumeroMesa: TextView = findViewById(R.id.tv_numeroMesa)
        val btnOrdenar: Button = findViewById(R.id.btn_ordenar)
        val btnRegresar: Button = findViewById(R.id.btn_regresar)

        val bundle = intent.extras

        if (bundle != null) {
            numeroMesa = bundle.getString("mesa")
            tvNumeroMesa.setText("Mesa " + numeroMesa)
        }

        btnOrdenar.setOnClickListener {
            crearCuenta(numeroMesa)
        }

        btnRegresar.setOnClickListener {
            var intent = Intent(this, NuevaMesa::class.java)
        }
    }

    private fun crearCuenta(mesa: String?) {
        var etNombreCuenta: EditText = findViewById(R.id.et_nombre_cuenta)

        if (etNombreCuenta.text.isBlank()) {
            Toast.makeText(this, "El nombre de la cuenta no puede estar vacío", Toast.LENGTH_SHORT).show()
            return
        }

        var nombreCuenta: String = etNombreCuenta.text.toString().trim()

        cuentaRef.orderByChild("nombre").equalTo(nombreCuenta).addListenerForSingleValueEvent(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (s in snapshot.children) {
                    val cuentaExistente = s.getValue(CuentaBD::class.java)

                    if (cuentaExistente != null) {
                        Toast.makeText(this@MenuOrdenar, "Una cuenta con ese nombre ya existe", Toast.LENGTH_SHORT).show()
                        return
                    }
                }

                val cuenta = CuentaBD(nombreCuenta)

                cuentaRef.push().setValue(cuenta)
                Toast.makeText(this@MenuOrdenar, "Cuenta agregada exitosamente", Toast.LENGTH_SHORT).show()

                var intent = Intent(this@MenuOrdenar, Menu::class.java)
                intent.putExtra("mesa", mesa)
                intent.putExtra("cuenta", nombreCuenta)
                startActivity(intent)
            }

            override fun onCancelled(error: DatabaseError) {}
        })
    }
}
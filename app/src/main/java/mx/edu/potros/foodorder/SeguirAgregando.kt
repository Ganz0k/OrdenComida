package mx.edu.potros.foodorder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.getValue

class SeguirAgregando : AppCompatActivity() {

    private val mesaRef = FirebaseDatabase.getInstance().getReference("Mesas")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seguir_agregando)

        var numMesa: String? = ""
        var nombreCuenta: String? = ""
        val btnSeguir: Button = findViewById(R.id.btn_seguir)
        val btnFinalizar: Button = findViewById(R.id.btn_finalizar)

        val bundle = intent.extras

        if (bundle != null) {
            numMesa = bundle.getString("mesa")
            nombreCuenta = bundle.getString("cuenta")
        }

        btnSeguir.setOnClickListener {
            var intent = Intent(this, Menu::class.java)
            intent.putExtra("mesa", numMesa)
            intent.putExtra("cuenta", nombreCuenta)
            startActivity(intent)
        }

        btnFinalizar.setOnClickListener {
            finalizarCuenta(numMesa, nombreCuenta)
        }
    }

    private fun finalizarCuenta(numMesa: String?, nombreCuenta: String?) {
        mesaRef.orderByChild("nombre").equalTo(numMesa).addListenerForSingleValueEvent(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (s in snapshot.children) {
                    val mesaExistente = s.getValue(Mesa::class.java)

                    if (mesaExistente != null) {
                        mesaExistente.cuentas?.add(nombreCuenta)

                        var intent = Intent(this@SeguirAgregando, FinCuenta::class.java)
                        intent.putExtra("mesa", numMesa)
                        startActivity(intent)
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {}
        })
    }
}
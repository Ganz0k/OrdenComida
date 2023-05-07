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

class Registro : AppCompatActivity() {

    private val userRef = FirebaseDatabase.getInstance().getReference("Users")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        val btnCrear: Button = findViewById(R.id.btn_crear)

        btnCrear.setOnClickListener {
            saveMarkFromForm()
        }
    }

    private fun saveMarkFromForm() {
        var etCorreo: EditText = findViewById(R.id.input_correo)
        var etPassword: EditText = findViewById(R.id.input_password)
        var etVerifyPassword: EditText = findViewById(R.id.inpud_verify_password)

        if (etCorreo.text.isBlank() || etPassword.text.isBlank() || etVerifyPassword.text.isBlank()) {
            Toast.makeText(this, "Llene los campos antes de registrar un nuevo usuario", Toast.LENGTH_SHORT).show()
            return
        }

        var correo: String = etCorreo.text.toString().trim()
        var password: String = etPassword.text.toString().trim()
        var verifyPassword: String = etVerifyPassword.text.toString().trim()

        if (password != verifyPassword) {
            var invalidPass: TextView = findViewById(R.id.tv_invalidpass)
            invalidPass.setText("La contraseña no coincide")
            return
        }

        userRef.orderByChild("correo").equalTo(correo).addListenerForSingleValueEvent(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (s in snapshot.children) {
                    val usuarioExistente = s.getValue(User::class.java)

                    if (usuarioExistente != null) {
                        Toast.makeText(this@Registro, "Un usuario con ese correo ya existe", Toast.LENGTH_SHORT).show()
                        return
                    }
                }

                val usuario = User(correo, password)

                userRef.push().setValue(usuario)
                Toast.makeText(this@Registro, "Usuario registrado exitosamente", Toast.LENGTH_SHORT).show()

                var intent = Intent(this@Registro, Bienvenido::class.java)
                startActivity(intent)
            }

            override fun onCancelled(error: DatabaseError) {}
        })
    }
}
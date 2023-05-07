package mx.edu.potros.foodorder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity : AppCompatActivity() {

    private val userRef = FirebaseDatabase.getInstance().getReference("Users")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnOlvidasteContra: Button = findViewById(R.id.btn_olvidasteContra)
        val btnLogin: Button = findViewById(R.id.btn_login)
        val btnRegistro: Button = findViewById(R.id.btn_crearCuenta)

        btnOlvidasteContra.setOnClickListener {
            var intent = Intent(this, LoginVerificacion::class.java)
            startActivity(intent)
        }

        btnLogin.setOnClickListener {
            logIn()
        }

        btnRegistro.setOnClickListener {
            var intent = Intent(this, Registro::class.java)
            startActivity(intent)
        }
    }

    private fun logIn() {
        var etUsuario: EditText = findViewById(R.id.et_usuario)
        var etPassword: EditText = findViewById(R.id.et_password)

        if (etUsuario.text.isBlank() || etPassword.text.isBlank()) {
            Toast.makeText(this, "Llene los campos antes de iniciar sesión", Toast.LENGTH_SHORT).show()
            return
        }

        var usuario: String = etUsuario.text.toString().trim()
        var password: String = etPassword.text.toString().trim()

        userRef.orderByChild("correo").equalTo(usuario).addListenerForSingleValueEvent(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    var usuarioExistente: User? = null

                    for (s in snapshot.children) {
                        usuarioExistente = s.getValue(User::class.java)

                        if (usuarioExistente != null && usuarioExistente.password == password) {
                            Toast.makeText(this@MainActivity, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()
                            var intent = Intent(this@MainActivity, Bienvenido::class.java)
                            startActivity(intent)
                            return
                        }
                    }

                    Toast.makeText(this@MainActivity, "Usuario y/o contraseña incorrectos", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@MainActivity, "Usuario y/o contraseña incorrectos", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onCancelled(error: DatabaseError) {}
        })
    }
}
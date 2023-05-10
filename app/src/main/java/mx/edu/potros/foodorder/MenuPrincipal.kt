package mx.edu.potros.foodorder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MenuPrincipal : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_principal)

        auth = Firebase.auth
        val currentUser = auth.currentUser

        val btnCerrarSesion: Button = findViewById(R.id.btn_cerrarSesion)
        val btnOrdenar: ImageView = findViewById(R.id.btnOrdenar)
        val btnListaOrden: TextView = findViewById(R.id.tvOrden)

        btnCerrarSesion.setOnClickListener{
            logOut()
        }

        btnOrdenar.setOnClickListener{
            var intent = Intent(this, NuevaMesa::class.java)
            startActivity(intent)
            finish()
        }

        btnListaOrden.setOnClickListener{
            var intent = Intent(this, MenuPrincipalLista::class.java)
            startActivity(intent)
        }
    }

    private fun logOut() {
        auth.signOut()
        var intent = Intent(this, Salir::class.java)
        startActivity(intent)
        finish()
    }
}
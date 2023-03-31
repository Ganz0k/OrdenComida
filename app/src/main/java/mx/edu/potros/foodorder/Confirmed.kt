package mx.edu.potros.foodorder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class Confirmed : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmed)

        var tipo: String? = intent.getStringExtra("tipo")
        val textConfirm: TextView = findViewById(R.id.text_confirm)
        val linear: LinearLayout = findViewById(R.id.ly_confirmado)

        when (tipo) {
            "cuenta" -> {
                textConfirm.setText("Cuenta confirmada")

                linear.setOnClickListener {
                    var intent = Intent(this, Menu::class.java)
                    startActivity(intent)
                }
            }

            "codigo" -> {
                textConfirm.setText("Código correcto")

                linear.setOnClickListener {
                    var intent = Intent(this, CambioContra::class.java)
                    startActivity(intent)
                }
            }

            "contra" -> {
                textConfirm.setText("Contraseña guardada")

                linear.setOnClickListener {
                    var intent = Intent(this, Bienvenido::class.java)
                    startActivity(intent)
                }
            }

            "pedido" -> {
                textConfirm.setText("Tu pedido ha sido enviado")

                linear.setOnClickListener {
                    var intent = Intent(this, MenuPrincipal::class.java)
                    startActivity(intent)
                }
            }

            "cobrar" -> {
                textConfirm.setText("La cuenta ha sido enviada a caja")

                linear.setOnClickListener {
                    var intent = Intent(this, MenuPrincipal::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}
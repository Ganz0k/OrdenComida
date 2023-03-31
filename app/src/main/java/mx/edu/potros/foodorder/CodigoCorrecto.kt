package mx.edu.potros.foodorder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class CodigoCorrecto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_codigo_correcto)

        var tipo: String? = intent.getStringExtra("tipo")
        val image: ImageView = findViewById(R.id.imageView)
        val textConfirm: TextView = findViewById(R.id.text_confirm)

        when (tipo) {
            "cuenta" -> {
                textConfirm.setText("Cuenta confirmada")

                image.setOnClickListener {
                    var intent = Intent(this, Menu::class.java)
                    startActivity(intent)
                }
            }

            "codigo" -> {
                textConfirm.setText("Código correcto")

                image.setOnClickListener {
                    var intent = Intent(this, CambioContra::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}
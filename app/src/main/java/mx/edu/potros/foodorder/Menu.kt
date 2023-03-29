package mx.edu.potros.foodorder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val ivEntradas: ImageView = findViewById(R.id.iv_entradas)
        val ivRollos: ImageView = findViewById(R.id.iv_rollos)
        val ivPlatillos: ImageView = findViewById(R.id.iv_platillos)
        val ivExtras: ImageView = findViewById(R.id.iv_extras)
        val ivPostres: ImageView = findViewById(R.id.iv_postres)
        val ivBebidas: ImageView = findViewById(R.id.iv_bebidas)

        ivEntradas.setOnClickListener {
            var intent: Intent = Intent(this, ) //añadir siguiente pantalla al final del constructor
            intent.putExtra("tipo", "entradas")
            startActivity(intent)
        }

        ivRollos.setOnClickListener {
            var intent: Intent = Intent(this, ) //añadir siguiente pantalla al final del constructor
            intent.putExtra("tipo", "rollos")
            startActivity(intent)
        }

        ivPlatillos.setOnClickListener {
            var intent: Intent = Intent(this, ) //añadir siguiente pantalla al final del constructor
            intent.putExtra("tipo", "platillos")
            startActivity(intent)
        }

        ivExtras.setOnClickListener {
            var intent: Intent = Intent(this, ) //añadir siguiente pantalla al final del constructor
            intent.putExtra("tipo", "extras")
            startActivity(intent)
        }

        ivPostres.setOnClickListener {
            var intent: Intent = Intent(this, ) //añadir siguiente pantalla al final del constructor
            intent.putExtra("tipo", "postres")
            startActivity(intent)
        }

        ivBebidas.setOnClickListener {
            var intent: Intent = Intent(this, ) //añadir siguiente pantalla al final del constructor
            intent.putExtra("tipo", "bebidas")
            startActivity(intent)
        }
    }
}
package mx.edu.potros.foodorder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        var nombreCuenta: String? = ""
        var numMesa: String? = ""
        val tvNombreMesaCuenta: TextView = findViewById(R.id.tv_nombreMesaCuenta)
        val ivEntradas: ImageView = findViewById(R.id.iv_entradas)
        val ivRollos: ImageView = findViewById(R.id.iv_rollos)
        val ivPlatillos: ImageView = findViewById(R.id.iv_platillos)
        val ivExtras: ImageView = findViewById(R.id.iv_extras)
        val ivPostres: ImageView = findViewById(R.id.iv_postres)
        val ivBebidas: ImageView = findViewById(R.id.iv_bebidas)

        val bundle = intent.extras

        if (bundle != null) {
            tvNombreMesaCuenta.setText("Cuenta de " + bundle.getString("cuenta") + "/Mesa" + bundle.getString("mesa"))

            nombreCuenta = bundle.getString("cuenta")
            numMesa = bundle.getString("mesa")
        }

        ivEntradas.setOnClickListener {
            var intent: Intent = Intent(this, Catalogo::class.java)
            intent.putExtra("tipo", "entradas")
            intent.putExtra("cuenta", nombreCuenta)
            intent.putExtra("mesa", numMesa)
            startActivity(intent)
        }

        ivRollos.setOnClickListener {
            var intent: Intent = Intent(this, Catalogo::class.java)
            intent.putExtra("tipo", "rollos")
            intent.putExtra("cuenta", nombreCuenta)
            intent.putExtra("mesa", numMesa)
            startActivity(intent)
        }

        ivPlatillos.setOnClickListener {
            var intent: Intent = Intent(this, Catalogo::class.java)
            intent.putExtra("tipo", "platillos")
            intent.putExtra("cuenta", nombreCuenta)
            intent.putExtra("mesa", numMesa)
            startActivity(intent)
        }

        ivExtras.setOnClickListener {
            var intent: Intent = Intent(this, Catalogo::class.java)
            intent.putExtra("tipo", "extras")
            intent.putExtra("cuenta", nombreCuenta)
            intent.putExtra("mesa", numMesa)
            startActivity(intent)
        }

        ivPostres.setOnClickListener {
            var intent: Intent = Intent(this, Catalogo::class.java)
            intent.putExtra("tipo", "postres")
            intent.putExtra("cuenta", nombreCuenta)
            intent.putExtra("mesa", numMesa)
            startActivity(intent)
        }

        ivBebidas.setOnClickListener {
            var intent: Intent = Intent(this, Catalogo::class.java)
            intent.putExtra("tipo", "bebidas")
            intent.putExtra("cuenta", nombreCuenta)
            intent.putExtra("mesa", numMesa)
            startActivity(intent)
        }
    }
}
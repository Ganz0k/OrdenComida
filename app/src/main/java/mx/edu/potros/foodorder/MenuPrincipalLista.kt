package mx.edu.potros.foodorder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MenuPrincipalLista : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_principal_lista)

        val btnOrdenar: Button = findViewById(R.id.btn_ordenar)

        btnOrdenar.setOnClickListener{
            var intent: Intent = Intent(this, CodigoCorrecto::class.java)
            intent.putExtra("tipo", "cuenta")
            startActivity(intent)
        }
    }
}
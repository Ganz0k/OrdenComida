package mx.edu.potros.foodorder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class EspecificacionChickeMongolia : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_especificacion_chicke_mongolia)

        val btnAgregar: Button = findViewById(R.id.btn_especificacion_agregar)
        val btnRegresar: Button = findViewById(R.id.btn_especificacion_regresar)
        var tvDescripcion: TextView = findViewById(R.id.tv_especificacionDescripcion)

        val bundle = intent.extras

        if (bundle != null) {
            tvDescripcion.setText(bundle.getString("descripcion"))
        }

        btnAgregar.setOnClickListener {
            var intent = Intent(this, SeguirAgregando::class.java)
            startActivity(intent)
        }

        btnRegresar.setOnClickListener {
            finish()
        }
    }
}
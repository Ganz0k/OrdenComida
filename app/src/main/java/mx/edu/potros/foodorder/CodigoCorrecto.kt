package mx.edu.potros.foodorder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class CodigoCorrecto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_codigo_correcto)

        val image: ImageView = findViewById(R.id.imageView)

        image.setOnClickListener {
            var intent = Intent(this, CambioContra::class.java)
            startActivity(intent)
        }
    }
}
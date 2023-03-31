package mx.edu.potros.foodorder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Bienvenido : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bienvenido)

        val image: ImageView = findViewById(R.id.image_bienvenido)

        image.setOnClickListener {
            var intent = Intent(this, MenuPrincipal::class.java)
            startActivity(intent)
        }
    }
}
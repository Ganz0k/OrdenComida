package mx.edu.potros.foodorder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class ContraGuardada : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contra_guardada)

        val image: ImageView = findViewById(R.id.imageView4)

        image.setOnClickListener {
            var intent = Intent(this, Bienvenido::class.java)
            startActivity(intent)
        }
    }
}
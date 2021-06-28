package com.venturus.basicrecycler2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.venturus.basicrecycler2.data.DataList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    lateinit var dataName: TextView
    lateinit var datacontainer: ConstraintLayout
    lateinit var img: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dataName = findViewById(R.id.name)
        datacontainer = findViewById(R.id.container)
        img = findViewById(R.id.imageView)
       

        getData()

        datacontainer.setOnClickListener {
            getData()
        }
    }

    private fun getData() {
    // executar a requisiçao de rede apartir da resposta escolher um drink aleatorio
        // colocar o nome da data aleatoria no textview
      lifecycleScope.launch {
            try {
             val  response = requestDatas()
                val dt =response.datas.random()
                dataName.text=dt.strDrink
                // fazendo a chamada do glide no metodo pegando a resposta da variavel
                 Glide.with(this@MainActivity).load(dt.strDrinkThumb).into(img)
            } catch (e: Exception) {
                Toast.makeText(this@MainActivity,e.message, Toast.LENGTH_SHORT).show()

            }
        }

    }
    private suspend fun requestDatas(): DataList {
        return withContext(Dispatchers.IO) {
            DataService.service.getDatas()
        }
    }
}
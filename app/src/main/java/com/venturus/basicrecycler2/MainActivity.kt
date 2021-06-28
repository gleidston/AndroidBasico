package com.venturus.basicrecycler2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.venturus.basicrecycler2.data.DataList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    lateinit var  dataName:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         dataName=findViewById(R.id.name)

        getData()
    }

    private fun getData() {
    // executar a requisiçao de rede apartir da resposta escolher um drink aleatorio
        // colocar o nome da data aleatoria no textview
      lifecycleScope.launch {
            try {
             val  response = requestDatas()
                val dt =response.datas.random()
                dataName.text=dt.strDrink
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
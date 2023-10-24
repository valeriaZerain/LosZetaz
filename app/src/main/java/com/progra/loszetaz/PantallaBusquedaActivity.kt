package com.progra.loszetaz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast

class PantallaBusquedaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_busqueda)

        val zones = listOf("Calacoto", "Cota Cota", "Sopocachi", "Irpavi", "San Pedro", "Centro", "Miraflores")

        val autoComplete: AutoCompleteTextView = findViewById(R.id.dropdown_zones)

        val adapter = ArrayAdapter(this, R.layout.dropdown_item, zones)

        autoComplete.setAdapter(adapter)

        autoComplete.onItemClickListener = AdapterView.OnItemClickListener{
            adapterView, view, i, l ->
                val itemSelected = adapterView.getItemAtPosition(i)
                Toast.makeText(this, "Item $itemSelected", Toast.LENGTH_SHORT).show()
        }
    }
}
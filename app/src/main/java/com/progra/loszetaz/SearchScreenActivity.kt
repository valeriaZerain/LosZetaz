package com.progra.loszetaz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.progra.loszetaz.adapters.SearchResultsAdapter
import com.progra.loszetaz.dataBase.ClubDB
import com.progra.loszetaz.dataBase.TagsEnum
import com.progra.loszetaz.dataClases.Club
import com.progra.loszetaz.databinding.ActivitySearchScreenBinding

class SearchScreenActivity : AppCompatActivity() {

    lateinit var binding : ActivitySearchScreenBinding
    private val searchResultsAdapter by lazy { SearchResultsAdapter() }

    private var zoneSelected: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val zones = listOf("No importa donde","Calacoto", "Cota Cota", "Sopocachi", "Irpavi", "San Pedro", "Centro", "Miraflores")

        val autoComplete: AutoCompleteTextView = binding.dropdownZones

        val adapter = ArrayAdapter(this, R.layout.dropdown_item, zones)

        autoComplete.setAdapter(adapter)

        autoComplete.onItemClickListener = AdapterView.OnItemClickListener{
            adapterView, view, i, l ->
                val itemSelected = adapterView.getItemAtPosition(i)
                zoneSelected = itemSelected.toString()
        }

        binding.searchButton.setOnClickListener {
            var searchResults = ClubDB.getAllClubs()
            val searchName = binding.searchNameParameter.text.toString()
            if(searchName.isNotEmpty()){
                searchResults = ClubDB.searchByName(searchName, searchResults)
            }

            val tags = mutableListOf(false,false,false,false,false)
            if(binding.checkboxTables.isChecked)
                tags.set(TagsEnum.TABLE.id, true)
            if(binding.checkboxOutside.isChecked)
                tags.set(TagsEnum.OUTSIDE.id, true)
            if(binding.checkboxOldies.isChecked)
                tags.set(TagsEnum.OLDIES.id, true)
            if(binding.checkboxNoCover.isChecked)
                tags.set(TagsEnum.NOCOVER.id,true)
            if(binding.checkboxLiveMusic.isChecked)
                tags.set(TagsEnum.LIVE.id,true)

            searchResults = ClubDB.searchByTags(tags, searchResults)

            if(zoneSelected != null && zoneSelected != "No importa donde"){
                searchResults = ClubDB.searchByZones(zoneSelected!!, searchResults)
            }
            showResults(searchResults)
        }
        binding.iconHomescreen.setOnClickListener{
            val intent: Intent = Intent(this, HomeScreenActivity::class.java)
            startActivity(intent)
        }
    }

    fun showResults(results: List<Club>){
        searchResultsAdapter.addResults(results)
        binding.resultRecycler.apply {
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = searchResultsAdapter
        }
    }
}
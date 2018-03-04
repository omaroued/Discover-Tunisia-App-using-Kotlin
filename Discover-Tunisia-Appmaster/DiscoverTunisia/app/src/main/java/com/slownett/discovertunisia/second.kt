package com.slownett.discovertunisia

import android.content.Context
import android.content.Intent
import android.os.BaseBundle
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.android.synthetic.main.ticket.view.*

class second : AppCompatActivity() {

    var adapter:CitiesAdapter?=null

    var listOfCities=ArrayList<City>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        listOfCities.add(City("Djerba","is, at 514 square kilometres (198 sq mi), the largest island of North Africa, located in the Gulf of Gabès, off the coast of Tunisia. It had a population of 139,544 at the 2004 Census, while the latest official estimate (as at 1 July 2014) is 163,726. Citing the long and unique Jewish minority's history on Djerba, Tunisia has sought UNESCO World Heritage Status protections for the island",R.drawable.djerba))
        listOfCities.add(City("Tunis","is the capital and the largest city of Tunisia. The greater metropolitan area of Tunis, often referred to as Grand Tunis, has some 2,700,000 inhabitants.",R.drawable.tunis))
        listOfCities.add(City("Sousse","is a city in Tunisia, capital of the Sousse Governorate. Located 140 kilometres (87 miles) south of the capital Tunis, the city has 271,428 inhabitants (2014). Sousse is in the central-east of the country, on the Gulf of Hammamet, which is a part of the Mediterranean Sea",R.drawable.sousse))
        listOfCities.add(City("Sfax","is a city in Tunisia, located 270 km (170 mi) southeast of Tunis. The city, founded in AD 849 on the ruins of Taparura and Thaenae, is the capital of the Sfax Governorate (about 955,421 inhabitants in 2014), and a Mediterranean port. Sfax has a population of 330,440 (census 2014).",R.drawable.sfax))
        listOfCities.add(City("Gabes","also spelled Cabès, Cabes, Kabes, Gabbs and Gaps, is the capital city of the Gabès Governorate in Tunisia. It is located on the coast of the Gulf of Gabès. With a population of 152,921, Gabès is the 6th largest Tunisian city.",R.drawable.gabes))
        listOfCities.add(City("Bizert","historically: Phoenician:  Hippo Acra,[verification needed] Latin: Hippo Diarrhytus and Hippo Zarytus), also known in English as Bizerta, is a town of Bizerte Governorate in Tunisia. It is the northernmost city in Africa, located 65 km (40mil) north of the capital Tunis. The city had 142,966 inhabitants in 2014.",R.drawable.medenine))
        listOfCities.add(City("Tabarka","Tbarga or Tabarka, Phoenician: Ṭabarqa, Latin: Thabraca, Θαύβρακα in Ancient Greek [1][2] also called Tbarga by locals) is a coastal town located in north-western Tunisia, at about 36°5716N 8°4529E, close to the border with Algeria. It has been famous for its coral fishing, the Coralis Festival of underwater photography[3] and the annual jazz festival.",R.drawable.tabarka))

        adapter= CitiesAdapter(this,listOfCities)
        list.adapter=adapter

    }

    class CitiesAdapter:BaseAdapter{

        var listOfCities=ArrayList<City>()
        var context:Context?=null
        constructor(context: Context,listOfCities:ArrayList<City>){
            this.listOfCities=listOfCities
            this.context=context
        }
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var city=listOfCities[position]
            var inflater=context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var myView=inflater.inflate(R.layout.ticket,null)
            myView.tvName.text=city.name
            myView.imCity.setImageResource(city.image!!)
            myView.setOnClickListener{
                var intent=Intent(context,CityInfo::class.java)
                intent.putExtra("name",city.name)
                intent.putExtra("des",city.des)
                intent.putExtra("image",city.image!!)
                context!!.startActivity(intent)


            }

            return myView
        }

        override fun getItem(position: Int): Any {

          return  listOfCities[position]
        }

        override fun getItemId(position: Int): Long {

           return position.toLong()
        }

        override fun getCount(): Int {
          return  listOfCities.size
        }

    }
}

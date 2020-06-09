package com.example.recyclerviewkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		val exampleList = generateDummyList(500)
		recycler_view.adapter = AdapterExampleRecycler(exampleList)
		recycler_view.layoutManager = LinearLayoutManager(this)
		recycler_view.setHasFixedSize(true)
	}
	private fun generateDummyList(size: Int): List<ExampleItem> {
		val list = ArrayList<ExampleItem>()
		for (i in 0 until size) {
			val drawable = when (i % 3) {
				0 -> R.drawable.ic_baseline_adb_24
				1 -> R.drawable.ic_baseline_location_city_24
				else -> R.drawable.ic_baseline_ac_unit_24
			}
			val item = ExampleItem(drawable, "Item $i", "Line 2")
			list += item
		}
		return list
	}
}
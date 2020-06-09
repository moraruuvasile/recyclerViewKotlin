package com.example.recyclerviewkotlin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

////, AdapterExampleRecycler.OnItemClickListener
class MainActivity : AppCompatActivity() {
	var adClickCallBack = object : AdapterExampleRecycler.OnItemClickListener {
		override fun onClick(position: Int) {
			makeText(this@MainActivity, "onClick $position", Toast.LENGTH_LONG).show()

            val movie = exampleList[position]
			val intent = Intent(this@MainActivity, NewActivity::class.java)
			intent.putExtra(NewActivity.MOVIE_NAME, movie)
			startActivity(intent)
		}

		override fun onLongClick(position: Int) {
			makeText(this@MainActivity, "onLongClick $position", Toast.LENGTH_LONG).show()
		}

	}
    private val exampleList = generateDummyList(500)
    private val recyclerAdapter = AdapterExampleRecycler(exampleList, adClickCallBack)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_view.apply {
            adapter = recyclerAdapter
//			addItemDecoration(DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL))
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
        }
    }

    private fun generateDummyList(size: Int): ArrayList<ExampleItem> {
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

    fun insertItem(view: View) {
        val index = Random.nextInt(5)
        val newItem = ExampleItem(
            R.drawable.ic_baseline_ac_unit_24,
            "New item at position $index",
            "Line 2"
        )
        exampleList.add(index, newItem)
        recyclerAdapter.notifyItemInserted(index)
    }

    fun removeItem(view: View) {
        val index = Random.nextInt(5)
        exampleList.removeAt(index)
        recyclerAdapter.notifyItemRemoved(index)
    }


}
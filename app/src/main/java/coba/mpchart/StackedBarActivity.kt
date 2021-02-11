package coba.mpchart

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import java.util.*

class StackedBarActivity : AppCompatActivity() {
    var colorClassArray = intArrayOf(Color.CYAN, Color.YELLOW, Color.GREEN)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stacked_bar)
        var stackedBar = findViewById<BarChart>(R.id.stackedBar)
        val barDataSet = BarDataSet(dataValues1(), "Bar Set")
        barDataSet.setColors(*colorClassArray)
        val barData = BarData(barDataSet)
        stackedBar.setData(barData)
    }

    private fun dataValues1(): ArrayList<BarEntry> {
        val dataVals = ArrayList<BarEntry>()
        dataVals.add(BarEntry(0f, floatArrayOf(2f, 5.5f, 4f)))
        dataVals.add(BarEntry(1f, floatArrayOf(2f, 8f, 5.3f)))
        dataVals.add(BarEntry(2f, floatArrayOf(2f, 3f, 8f)))
        return dataVals
    }
}
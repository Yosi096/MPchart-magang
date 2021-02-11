package coba.mpchart

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import java.util.*

class BarchartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_barchart)
        var barChart = findViewById<BarChart>(R.id.mp_Barchart)
        val barDataSet1 = BarDataSet(dataValues1(), "Dataset 1")
        val barDataSet2 = BarDataSet(dataValues2(), "Dataset 2")
        barDataSet1.color = Color.CYAN
        barDataSet2.color = Color.BLUE
        val description = Description()
        description.text = "Fire"
        description.textColor = Color.BLACK
        description.textSize = 20f
        barChart.setDescription(description)
        val barData = BarData()
        barData.addDataSet(barDataSet1)
        barData.addDataSet(barDataSet2)
        barChart.setData(barData)
        barChart.invalidate()
    }

    private fun dataValues1(): ArrayList<BarEntry> {
        val dataVals = ArrayList<BarEntry>()
        dataVals.add(BarEntry(0f, 3f))
        dataVals.add(BarEntry(1f, 4f))
        dataVals.add(BarEntry(3f, 6f))
        dataVals.add(BarEntry(4f, 11f))
        return dataVals
    }

    private fun dataValues2(): ArrayList<BarEntry> {
        val dataVals = ArrayList<BarEntry>()
        dataVals.add(BarEntry(1.8f, 2f))
        dataVals.add(BarEntry(2f, 8f))
        dataVals.add(BarEntry(3.6f, 3f))
        dataVals.add(BarEntry(5f, 7f))
        return dataVals
    }
}
package coba.mpchart

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.mikephil.charting.charts.RadarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import java.util.ArrayList

class RadarChartActivity : AppCompatActivity() {
    var labels = arrayOf("A", "B", "C", "D","E")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radar_chart)

        var radarChart = findViewById<RadarChart>(R.id.radar_chart)

        val radarSet1 = RadarDataSet(dataValues1(),"Data 1")
        val radarSet2 = RadarDataSet(dataValues2(),"Data 2")

        radarSet1.setColor(Color.MAGENTA)
        radarSet2.setColor(Color.CYAN)

        val radarData = RadarData()
        radarData.addDataSet(radarSet1)
        radarData.addDataSet(radarSet2)

        radarChart.setData(radarData)
        radarChart.invalidate()

        val xAxis = radarChart.getXAxis()
        xAxis.valueFormatter = IndexAxisValueFormatter(labels)

    }

    private fun dataValues1(): ArrayList<RadarEntry> {
        val dataVals = ArrayList<RadarEntry>()
        dataVals.add(RadarEntry(4f))
        dataVals.add(RadarEntry(7f))
        dataVals.add(RadarEntry(1f))
        dataVals.add(RadarEntry(5f))
        dataVals.add(RadarEntry(9f))
        return dataVals
    }

    private fun dataValues2(): ArrayList<RadarEntry> {
        val dataVals = ArrayList<RadarEntry>()
        dataVals.add(RadarEntry(7f))
        dataVals.add(RadarEntry(4f))
        dataVals.add(RadarEntry(8f))
        dataVals.add(RadarEntry(2f))
        dataVals.add(RadarEntry(6f))
        return dataVals
    }
}
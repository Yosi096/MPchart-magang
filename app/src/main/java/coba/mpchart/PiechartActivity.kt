package coba.mpchart

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import java.util.*

class PiechartActivity : AppCompatActivity() {
    var colorClassArray = intArrayOf(Color.RED, Color.MAGENTA, Color.YELLOW, Color.GREEN, Color.CYAN, Color.LTGRAY, Color.DKGRAY)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_piechart)

        var pieChart = findViewById<PieChart>(R.id.pieChart)
        val pieDataSet = PieDataSet(dataValues1(), "")
        pieDataSet.setColors(*colorClassArray)
        val pieData = PieData(pieDataSet)
        pieChart.setDrawEntryLabels(true)
        pieChart.setUsePercentValues(false)
        pieChart.setCenterText("Week Data")
        pieChart.setCenterTextSize(20f)
        pieChart.setCenterTextRadiusPercent(50f)
        pieChart.setHoleRadius(30f)
        pieChart.setTransparentCircleRadius(40f)
        pieChart.setTransparentCircleColor(Color.RED)
        pieChart.setTransparentCircleAlpha(50)
        //        pieChart.setMaxAngle(180);
        pieChart.setData(pieData)
        pieChart.invalidate()
    }

    private fun dataValues1(): ArrayList<PieEntry> {
        val dataVals = ArrayList<PieEntry>()
        dataVals.add(PieEntry(15f, "Sun"))
        dataVals.add(PieEntry(34f, "Mon"))
        dataVals.add(PieEntry(23f, "Tue"))
        dataVals.add(PieEntry(86f, "Wed"))
        dataVals.add(PieEntry(26f, "Thu"))
        dataVals.add(PieEntry(17f, "Fri"))
        dataVals.add(PieEntry(63f, "Sat"))
        return dataVals
    }
}
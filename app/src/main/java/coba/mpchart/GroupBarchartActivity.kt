package coba.mpchart

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import java.util.*

class GroupBarchartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group_barchart)
        var barChart = findViewById<BarChart>(R.id.group_barchart)
        val barDataSet1 = BarDataSet(barEntries1(), "Dataset 1")
        barDataSet1.color = Color.MAGENTA
        val barDataSet2 = BarDataSet(barEntries2(), "Dataset 2")
        barDataSet2.color = Color.LTGRAY
        val barDataSet3 = BarDataSet(barEntries3(), "Dataset 3")
        barDataSet3.color = Color.YELLOW
        val barDataSet4 = BarDataSet(barEntries4(), "Dataset 4")
        barDataSet4.color = Color.CYAN
        val description = Description()
        description.text = "Fire"
        description.textColor = Color.DKGRAY
        description.textSize = 20f
        barChart.setDescription(description)
        val data = BarData(barDataSet1, barDataSet2, barDataSet3, barDataSet4)
        barChart.setData(data)
        val days = arrayOf("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")
        val xAxis = barChart.getXAxis()
        xAxis.valueFormatter = IndexAxisValueFormatter(days)
        xAxis.setCenterAxisLabels(true)
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.granularity = 1f
        xAxis.isGranularityEnabled = true
        barChart.setDragEnabled(true)
        barChart.setVisibleXRangeMaximum(3f)
        val barSpace = 0.05f
        val groupSpace = 0.16f
        data.barWidth = 0.16f
        barChart.getXAxis().axisMinimum = 0f
        barChart.getXAxis().axisMaximum = 0 + barChart.getBarData().getGroupWidth(groupSpace, barSpace) * 7
        barChart.getAxisLeft().axisMinimum = 0f
        barChart.groupBars(0f, groupSpace, barSpace)
        barChart.invalidate()
    }

    private fun barEntries1(): ArrayList<BarEntry> {
        val barEntries = ArrayList<BarEntry>()
        barEntries.add(BarEntry(1f, 2000f))
        barEntries.add(BarEntry(2f, 791f))
        barEntries.add(BarEntry(3f, 630f))
        barEntries.add(BarEntry(4f, 458f))
        barEntries.add(BarEntry(5f, 2724f))
        barEntries.add(BarEntry(6f, 500f))
        barEntries.add(BarEntry(7f, 2173f))
        return barEntries
    }

    private fun barEntries2(): ArrayList<BarEntry> {
        val barEntries = ArrayList<BarEntry>()
        barEntries.add(BarEntry(1f, 800f))
        barEntries.add(BarEntry(2f, 791f))
        barEntries.add(BarEntry(3f, 1200f))
        barEntries.add(BarEntry(4f, 458f))
        barEntries.add(BarEntry(5f, 789f))
        barEntries.add(BarEntry(6f, 346f))
        barEntries.add(BarEntry(7f, 1200f))
        return barEntries
    }

    private fun barEntries3(): ArrayList<BarEntry> {
        val barEntries = ArrayList<BarEntry>()
        barEntries.add(BarEntry(1f, 300f))
        barEntries.add(BarEntry(2f, 675f))
        barEntries.add(BarEntry(3f, 928f))
        barEntries.add(BarEntry(4f, 74f))
        barEntries.add(BarEntry(5f, 1500f))
        barEntries.add(BarEntry(6f, 1879f))
        barEntries.add(BarEntry(7f, 400f))
        return barEntries
    }

    private fun barEntries4(): ArrayList<BarEntry> {
        val barEntries = ArrayList<BarEntry>()
        barEntries.add(BarEntry(1f, 3000f))
        barEntries.add(BarEntry(2f, 2209f))
        barEntries.add(BarEntry(3f, 1700f))
        barEntries.add(BarEntry(4f, 100f))
        barEntries.add(BarEntry(5f, 300f))
        barEntries.add(BarEntry(6f, 500f))
        barEntries.add(BarEntry(7f, 1000f))
        return barEntries
    }
}
package coba.mpchart

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import coba.mpchart.custom.MyMarkerView
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.*
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import java.util.*

class MainActivity : AppCompatActivity(), OnChartValueSelectedListener {
    var colorArray = intArrayOf(R.color.color1, R.color.color2, R.color.color3, R.color.color3, R.color.color4)
    var colorClassArray = intArrayOf(Color.CYAN, Color.MAGENTA, Color.YELLOW, Color.GREEN)
    var legendName = arrayOf("A", "B", "C", "D")
    val mpLineChart: LineChart? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)
        var mpLineChart = findViewById<LineChart>(R.id.line_chart);
        run {
            // background color
            mpLineChart.setBackgroundColor(Color.WHITE)

            // disable description text
            mpLineChart.getDescription().isEnabled = false

            // enable touch gestures
            mpLineChart.setTouchEnabled(true)

            // set listeners
            mpLineChart.setOnChartValueSelectedListener(this)
            mpLineChart.setDrawGridBackground(false)

            // create marker to display box when values are selected
            val mv = MyMarkerView(this, R.layout.custom_marker_view)

            // Set the marker to the chart
            mv.chartView = mpLineChart
            mpLineChart.setMarker(mv)

            // enable scaling and dragging
            mpLineChart.setDragEnabled(true)
            mpLineChart.setScaleEnabled(true)
            // chart.setScaleXEnabled(true);
            // chart.setScaleYEnabled(true);

            // force pinch zoom along both axis
            mpLineChart.setPinchZoom(true)
        }
        val lineDataSet1 = LineDataSet(dataValues1(), "Data set 1")
        val lineDataSet2 = LineDataSet(dataValues2(), "Data set 2")
        val dataSets = ArrayList<ILineDataSet>()
        dataSets.add(lineDataSet1)
        dataSets.add(lineDataSet2)
        //        untuk mengatur desain garis label 1
        lineDataSet1.color = Color.RED
        lineDataSet1.lineWidth = 4f
        lineDataSet1.setDrawCircles(true)
        lineDataSet1.setDrawCircleHole(true)
        lineDataSet1.setCircleColor(Color.BLUE)
        lineDataSet1.circleHoleColor = Color.YELLOW
        lineDataSet1.circleRadius = 10f
        lineDataSet1.circleHoleRadius = 5f
        lineDataSet1.valueTextSize = 14f
        lineDataSet1.valueTextColor = Color.BLACK
        //        lineDataSet1.enableDashedLine(5,10,0);
        lineDataSet1.setColors(colorArray, this@MainActivity)

//        mpLineChart.setBackgroundColor(Color.BLUE);
        mpLineChart.setNoDataText("No Data")
        mpLineChart.setNoDataTextColor(Color.BLUE)
        mpLineChart.setDrawGridBackground(true)
        mpLineChart.setDrawBorders(true)
        mpLineChart.setBorderColor(Color.DKGRAY)
        mpLineChart.setBorderWidth(1f)
        val description = Description()
        description.text = "Fire"
        description.textColor = Color.BLUE
        description.textSize = 20f
        mpLineChart.setDescription(description)
        var xAxis: XAxis
        run {
            // // X-Axis Style // //
            xAxis = mpLineChart.xAxis

            // vertical grid lines
            xAxis.enableGridDashedLine(10f, 10f, 0f)
        }
        var yAxis: YAxis
        run {
            // // Y-Axis Style // //
            yAxis = mpLineChart.axisLeft

            // disable dual axis (only use LEFT axis)
            mpLineChart.axisRight.isEnabled = false

            // horizontal grid lines
            yAxis.enableGridDashedLine(10f, 10f, 0f)

            // axis range
            yAxis.axisMaximum = 200f
            yAxis.axisMinimum = -50f
        }
        run {
            // // Create Limit Lines // //
            val llXAxis = LimitLine(9f, "Index 10")
            llXAxis.lineWidth = 4f
            llXAxis.enableDashedLine(10f, 10f, 0f)
            llXAxis.labelPosition = LimitLine.LimitLabelPosition.RIGHT_BOTTOM
            llXAxis.textSize = 10f
            //            llXAxis.setTypeface();
            val ll1 = LimitLine(150f, "Upper Limit")
            ll1.lineWidth = 4f
            ll1.enableDashedLine(10f, 10f, 0f)
            ll1.labelPosition = LimitLine.LimitLabelPosition.RIGHT_TOP
            ll1.textSize = 10f
            //            ll1.setTypeface(tf);
            val ll2 = LimitLine(-30f, "Lower Limit")
            ll2.lineWidth = 4f
            ll2.enableDashedLine(10f, 10f, 0f)
            ll2.labelPosition = LimitLine.LimitLabelPosition.RIGHT_BOTTOM
            ll2.textSize = 10f
            //            ll2.setTypeface(tfRegular);

            // draw limit lines behind data instead of on top
            yAxis.setDrawLimitLinesBehindData(true)
            xAxis.setDrawLimitLinesBehindData(true)

            // add limit lines
            yAxis.addLimitLine(ll1)
            yAxis.addLimitLine(ll2)
        }

//        untuk mengatur label
        val legend = mpLineChart.getLegend()
        legend.isEnabled = true
        legend.textColor = Color.BLACK
        legend.textSize = 12f
        legend.form = Legend.LegendForm.CIRCLE
        legend.formSize = 15f
        legend.xEntrySpace = 10f //untuk mengatur antar jarak label
        legend.formToTextSpace = 10f //untuk mengatur jarak antara text dan form

//        syntax untuk membuat legend
        val legendEntries = arrayOfNulls<LegendEntry>(4)
        for (i in legendEntries.indices) {
            val entry = LegendEntry()
            entry.formColor = colorClassArray[i]
            entry.label = legendName[i]
            legendEntries[i] = entry
        }
        legend.setCustom(legendEntries)
        val data = LineData(dataSets)
        //        data.setValueFormatter(new MyValueFormatter());
        mpLineChart.setData(data)
        mpLineChart.invalidate()
    }

    private fun dataValues1(): ArrayList<Entry> {
        val dataVals = ArrayList<Entry>()
        dataVals.add(Entry(0f, 20f))
        dataVals.add(Entry(1f, 23f))
        dataVals.add(Entry(2f, 2f))
        dataVals.add(Entry(3f, 10f))
        dataVals.add(Entry(4f, 28f))
        return dataVals
    }

    private fun dataValues2(): ArrayList<Entry> {
        val dataVals = ArrayList<Entry>()
        dataVals.add(Entry(0f, 12f))
        dataVals.add(Entry(2f, 16f))
        dataVals.add(Entry(3f, 23f))
        dataVals.add(Entry(5f, 1f))
        dataVals.add(Entry(7f, 18f))
        return dataVals
    }

    override fun onValueSelected(e: Entry, h: Highlight) {
        Log.i("Entry selected", e.toString())
        Log.i("LOW HIGH", "low: " + mpLineChart?.lowestVisibleX + ", high: " + mpLineChart?.highestVisibleX)
        Log.i("MIN MAX", "xMin: " + mpLineChart?.xChartMin + ", xMax: " + mpLineChart?.xChartMax + ", yMin: " + mpLineChart?.yChartMin + ", yMax: " + mpLineChart?.yChartMax)
    }

    override fun onNothingSelected() {
        Log.i("Nothing selected", "Nothing selected.")
    } //    private class MyValueFormatter extends ValueFormatter implements IValueFormatter {
    //
    //        @Override
    //        public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
    //            return value + " $";
    //        }
    //    }
    //
    //    private class MyAxisValueFormatter implements IAxisValueFormatter {
    //
    //        @Override
    //        public String getFormattedValue(float value, AxisBase axis) {
    //            axis.setLabelCount(3,true);
    //            return value+" $";
    //        }
    //    }
}
package coba.mpchart

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        var button1 = findViewById<Button>(R.id.btn_1)
        var button2 = findViewById<Button>(R.id.btn_2)
        var button3 = findViewById<Button>(R.id.btn_3)
        var button4 = findViewById<Button>(R.id.btn_4)
        var button5 = findViewById<Button>(R.id.btn_5)
        var button6 = findViewById<Button>(R.id.btn_6)
        var button7 = findViewById<Button>(R.id.btn_7)
        var button8 = findViewById<Button>(R.id.btn_8)
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btn_1 -> {
                val i = Intent(this@HomeActivity, MainActivity::class.java)
                startActivity(i)
                Toast.makeText(this, "Line Chart", Toast.LENGTH_SHORT).show()
            }
            R.id.btn_2 -> {
                val a = Intent(this@HomeActivity, BarchartActivity::class.java)
                startActivity(a)
                Toast.makeText(this, "Bar Chart", Toast.LENGTH_SHORT).show()
            }
            R.id.btn_3 -> {
                val intent = Intent(this@HomeActivity, GroupBarchartActivity::class.java)
                startActivity(intent)
                Toast.makeText(this, "Group Bar Chart", Toast.LENGTH_SHORT).show()
            }
            R.id.btn_4 -> {
                val inte = Intent(this@HomeActivity, StackedBarActivity::class.java)
                startActivity(inte)
                Toast.makeText(this, "Stacked Bar Chart", Toast.LENGTH_SHORT).show()
            }
            R.id.btn_5 -> {
                val inten = Intent(this@HomeActivity, PiechartActivity::class.java)
                startActivity(inten)
                Toast.makeText(this, "Pie Chart", Toast.LENGTH_SHORT).show()
            }
            R.id.btn_6 -> {
                val inten = Intent(this@HomeActivity, populateGraphActivity::class.java)
                startActivity(inten)
                Toast.makeText(this, "Bar Chart", Toast.LENGTH_SHORT).show()
            }
            R.id.btn_7 -> {
                val inten = Intent(this@HomeActivity, RadarChartActivity::class.java)
                startActivity(inten)
                Toast.makeText(this, "Radar Chart", Toast.LENGTH_SHORT).show()
            }
            R.id.btn_8 -> {
                finish()
            }
        }
    }
}
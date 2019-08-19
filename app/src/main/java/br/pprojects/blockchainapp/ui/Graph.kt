package br.pprojects.blockchainapp.ui

import android.app.Activity
import androidx.core.content.ContextCompat
import br.pprojects.blockchainapp.R
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.GridLabelRenderer
import com.jjoe64.graphview.helper.DateAsXAxisLabelFormatter
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries

class Graph(private val graphView: GraphView) {
    private var series: ArrayList<DataPoint> = arrayListOf()

    fun configureGraph(activity: Activity) {
        graphView.viewport.isScalable = true
        graphView.viewport.isScrollable = true
        graphView.viewport.backgroundColor = ContextCompat.getColor(activity, R.color.white)

        val renderer = graphView.gridLabelRenderer
        renderer.gridColor = ContextCompat.getColor(activity, R.color.gray)
        renderer.gridStyle = GridLabelRenderer.GridStyle.HORIZONTAL

        renderer.setHumanRounding(false)
        renderer.labelFormatter = DateAsXAxisLabelFormatter(activity)
        renderer.numHorizontalLabels = 3

        graphView.viewport.setMinX(0.0)
        graphView.viewport.setMaxY(30000.0)
        graphView.viewport.setMinY(0.0)

        graphView.getViewport().setYAxisBoundsManual(true)
        graphView.getViewport().setXAxisBoundsManual(true)
    }

    fun addPoint(point: DataPoint) {
        series.add(point)

        val array = arrayOfNulls<DataPoint>(series.size)
        series.toArray(array)
        graphView.addSeries(LineGraphSeries(array))
    }
}

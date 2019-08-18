package br.pprojects.blockchainapp.ui

import android.content.Context
import androidx.core.content.ContextCompat
import br.pprojects.blockchainapp.R
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.GridLabelRenderer
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries

class Graph(private val graphView: GraphView) {
    private var series: ArrayList<DataPoint> = arrayListOf()

    fun configureGraph(context: Context) {
        graphView.viewport.isScalable = true
        graphView.viewport.isScrollable = true
        graphView.viewport.backgroundColor = ContextCompat.getColor(context, R.color.white)

        val renderer = graphView.gridLabelRenderer
        renderer.gridColor = ContextCompat.getColor(context, R.color.graySubtitles)
        renderer.gridStyle = GridLabelRenderer.GridStyle.HORIZONTAL
    }

    fun addPoint(point: DataPoint){
        series.add(point)

        val array = arrayOfNulls<DataPoint>(series.size)
        series.toArray(array)
        graphView.addSeries(LineGraphSeries(array))
    }
}

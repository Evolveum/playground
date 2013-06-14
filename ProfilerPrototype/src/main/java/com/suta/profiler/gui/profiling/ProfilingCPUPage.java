package com.suta.profiler.gui.profiling;

import com.googlecode.wickedcharts.highcharts.options.*;
import com.googlecode.wickedcharts.highcharts.options.color.HexColor;
import com.googlecode.wickedcharts.highcharts.options.series.Coordinate;
import com.googlecode.wickedcharts.highcharts.options.series.CustomCoordinatesSeries;
import com.googlecode.wickedcharts.wicket6.highcharts.Chart;
import com.profiler.agent.CPUmeasurement;
import com.suta.profiler.gui.util.ProfilingPage;
import org.apache.wicket.ajax.AjaxSelfUpdatingTimerBehavior;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.time.Duration;

import java.util.*;

/**
 *  //TODO - description
 *  //TODO - collect time on target JVM - not static incrementation on server
 *
 *  @author Erik Suta
 * */
public class ProfilingCPUPage extends ProfilingPage{

    /* Attributes */
    private static final long serialVersionUID = 1L;
    private static List<Coordinate<Long, Double>> cpuData = new ArrayList<Coordinate<Long, Double>>();
    private static CustomCoordinatesSeries<Long, Double> cpuSeries = new CustomCoordinatesSeries<Long, Double>();

    /* GUI Attributes */
    private Chart cpuChart;
    private WebMarkupContainer cpuPanel = new WebMarkupContainer("cpuPanel");

    /**
     *  Constructor
     * */
    public ProfilingCPUPage(final PageParameters parameters){
        super(parameters);

        Options cpuOptions = new Options();

        ChartOptions cpuChartOptions = new ChartOptions();
        cpuChartOptions.setType(SeriesType.LINE);
        cpuChartOptions.setMarginRight(130).setMarginBottom(50);
        cpuChartOptions.setZoomType(ZoomType.X).setSpacingRight(20);

        cpuOptions.setChartOptions(cpuChartOptions);
        cpuOptions.setTitle(new Title("CPU Usage Chart"));
        cpuOptions.setSubtitle(new Title("%"));

        Axis xAxis = new Axis().setType(AxisType.DATETIME);
        cpuOptions.setxAxis(xAxis);

        PlotLine plotLine = new PlotLine();
        plotLine.setValue(0f).setWidth(1).setColor(new HexColor("#999999"));

        Axis yAxis = new Axis().setTitle(new Title("Usage [%]"));
        yAxis.setPlotLines(Collections.singletonList(plotLine));
        yAxis.setMinRange(100);
        yAxis.setMax(100);
        yAxis.setMin(0);
        cpuOptions.setyAxis(yAxis);

        cpuOptions.setLegend(new Legend(Boolean.FALSE));

        Tooltip optionsTooltip = new Tooltip();
        optionsTooltip.setFormatter(new Function()
                .setFunction("return '<b>'+ this.series.name +'</b><br/>'+"
                        + "Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) +'<br/>'+"
                        + "Highcharts.numberFormat(this.y, 1) + '%';"));

        cpuOptions.setTooltip(optionsTooltip);

        cpuSeries.setName("CPU usage");
        cpuSeries.setData(cpuData);
        cpuOptions.addSeries(cpuSeries);

        cpuChart = new Chart("cpuChart", cpuOptions);
        cpuPanel.add(cpuChart);
        cpuPanel.add(new AjaxSelfUpdatingTimerBehavior(Duration.seconds(SELF_UPDATE_INTERVAL)));
        add(cpuPanel);

    }   //Constructor end

    public static void prepareData(List<CPUmeasurement> cpuList){
        long time = new Date().getTime();

        for(CPUmeasurement c: cpuList){
            cpuData.add(new Coordinate<Long, Double>(time, c.getCpuUsage()));
            time +=1000;
        }

        //System.out.println("CPU DATA size: " + cpuData.size());
    }   //prepareData end

    /* GETTERS AND SETTERS */
    public static List<Coordinate<Long, Double>> getCpuData() {
        return cpuData;
    }
}

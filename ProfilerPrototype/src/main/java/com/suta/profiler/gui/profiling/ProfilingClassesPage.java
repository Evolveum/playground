package com.suta.profiler.gui.profiling;

import com.googlecode.wickedcharts.highcharts.options.*;
import com.googlecode.wickedcharts.highcharts.options.color.HexColor;
import com.googlecode.wickedcharts.highcharts.options.series.Coordinate;
import com.googlecode.wickedcharts.highcharts.options.series.CustomCoordinatesSeries;
import com.googlecode.wickedcharts.wicket6.highcharts.Chart;
import com.profiler.agent.ClassMeasurement;
import com.suta.profiler.gui.util.ProfilingPage;
import org.apache.wicket.ajax.AjaxSelfUpdatingTimerBehavior;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.time.Duration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 *  TODO - add class description
 *  TODO - collect time on target JVM - not static incrementation on server
 *  TODO - fix DateTime formatting when only few values exist on every page
 *
 *  @author Erik Suta
 * */
public class ProfilingClassesPage extends ProfilingPage{

    /* Attributes */
    private static final long serialVersionUID = 1L;
    private static List<Coordinate<Long, Integer>> classData = new ArrayList<Coordinate<Long,java.lang.Integer>>();
    private static CustomCoordinatesSeries<Long, Integer> classSeries = new CustomCoordinatesSeries<Long, Integer>();

    /* GUI attributes */
    private Chart classChart;
    private WebMarkupContainer classPanel = new WebMarkupContainer("classPanel");

    /**
     *  Constructor
     * */
    public ProfilingClassesPage(final PageParameters parameters){
        super(parameters);

        Options classOptions = new Options();

        ChartOptions threadChartOptions = new ChartOptions();
        threadChartOptions.setType(SeriesType.LINE);
        threadChartOptions.setMarginRight(130).setMarginBottom(50);
        threadChartOptions.setZoomType(ZoomType.X).setSpacingRight(20);

        classOptions.setChartOptions(threadChartOptions);
        classOptions.setTitle(new Title("Loaded classes"));
        classOptions.setSubtitle(new Title("current timestamp snapshot"));

        Axis xAxis = new Axis().setType(AxisType.DATETIME);
        classOptions.setxAxis(xAxis);

        PlotLine plotLine = new PlotLine();
        plotLine.setValue(0f).setWidth(1).setColor(new HexColor("#999999"));

        Axis yAxis = new Axis().setTitle(new Title("Loaded Classes"));
        yAxis.setPlotLines(Collections.singletonList(plotLine));
        yAxis.setMin(0);
        classOptions.setyAxis(yAxis);

        classOptions.setLegend(new Legend(Boolean.FALSE));

        Tooltip optionsTooltip = new Tooltip();
        optionsTooltip.setFormatter(new Function()
                .setFunction("return '<b>'+ this.series.name +'</b><br/>'+"
                        + "Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) +'<br/>'+"
                        + "Highcharts.numberFormat(this.y, 0) + ' classes';"));

        classOptions.setTooltip(optionsTooltip);

        classSeries.setName("Number of Loaded Classes");
        classSeries.setData(classData);
        classOptions.addSeries(classSeries);

        classChart = new Chart("classChart", classOptions);
        classPanel.add(classChart);
        classPanel.add(new AjaxSelfUpdatingTimerBehavior(Duration.seconds(SELF_UPDATE_INTERVAL)));

        add(classPanel);

    }   //constructor end

    /**
     *  Prepares data about class usage to be presented in wicket chart
     * */
    public static void prepareData(List<ClassMeasurement> classList){
        long time = new Date().getTime();

        for(ClassMeasurement c: classList){
            classData.add(new Coordinate<Long, Integer>(time, c.getLoadedClasses()));
            time += 1000;

        }
    }   //prepareData end

    /* GETTERS AND SETTERS */
    public static List<Coordinate<Long, Integer>> getClassData() {
        return classData;
    }

    public static int getLoadedClasses(){
        if(!classData.isEmpty())
            return classData.get(classData.size()-1).getY();
        else
            return 0;
    }
}

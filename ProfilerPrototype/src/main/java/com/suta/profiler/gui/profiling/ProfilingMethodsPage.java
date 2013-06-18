package com.suta.profiler.gui.profiling;

import com.googlecode.wickedcharts.highcharts.options.*;
import com.googlecode.wickedcharts.highcharts.options.color.HexColor;
import com.googlecode.wickedcharts.highcharts.options.series.Coordinate;
import com.googlecode.wickedcharts.highcharts.options.series.CustomCoordinatesSeries;
import com.googlecode.wickedcharts.wicket6.highcharts.Chart;
import com.profiler.agent.MethodRun;
import com.profiler.agent.TimeMeasurement;
import com.suta.profiler.Attributes;
import com.suta.profiler.gui.util.ProfilingPage;
import org.apache.wicket.ajax.AjaxSelfUpdatingTimerBehavior;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.time.Duration;

import java.util.*;

/**
 *  //TODO - Add class description
 *  TODO - Add y axis zoom type
 *  TODO - Add more statistics about method runs
 *
 *  @author Erik Suta
 * */
public class ProfilingMethodsPage extends ProfilingPage{

    /* Attributes */
    private static final long serialVersionUID = 1L;
    //private static Map<String, TimeMeasurement> methodRunData = new HashMap<String, TimeMeasurement>();

    private static Map<String, ArrayList<Coordinate<Integer, Long>>> methodData = new HashMap<String, ArrayList<Coordinate<Integer, Long>>>();
    private static List<CustomCoordinatesSeries<Integer, Long>> methodSeries = new ArrayList<CustomCoordinatesSeries<Integer, Long>>();

    //private static List<Coordinate<Integer, Long>> methodRunData = new ArrayList<Coordinate<Integer, Long>>();
    //private static CustomCoordinatesSeries<Integer, Long> methodSeries = new CustomCoordinatesSeries<Integer, Long>();

    /* GUI Attributes */
    private static Options methodOptions;
    private static Chart methodChart;
    private static WebMarkupContainer methodPanel;

    /**
     *  Constructor
     * */
    public ProfilingMethodsPage(final PageParameters parameters){
        super(parameters);

        methodOptions = new Options();

        ChartOptions methodChartOptions = new ChartOptions();
        methodChartOptions.setType(SeriesType.LINE);
        methodChartOptions.setMarginRight(130).setMarginBottom(50);
        methodChartOptions.setZoomType(ZoomType.X).setSpacingRight(20);

        methodOptions.setChartOptions(methodChartOptions);
        methodOptions.setTitle(new Title("Selected Method Runs Statistics"));
        methodOptions.setSubtitle(new Title("Measured in ms"));

        Axis xAxis = new Axis().setType(AxisType.LINEAR);
        xAxis.setAllowDecimals(false);
        methodOptions.setxAxis(xAxis);

        PlotLine plotLine = new PlotLine();
        plotLine.setValue(0f).setWidth(1).setColor(new HexColor("#999999"));

        Axis yAxis = new Axis().setTitle(new Title("Method Run Length[ms]"));
        yAxis.setPlotLines(Collections.singletonList(plotLine));
        yAxis.setMin(0);
        methodOptions.setyAxis(yAxis);

        methodOptions.setLegend(new Legend(Boolean.FALSE));

        Tooltip optionsTooltip = new Tooltip();
        optionsTooltip.setFormatter(new Function()
                .setFunction("return '<b>'+ this.series.name +'</b><br/>'+"
                        + "Highcharts.numberFormat(this.y, 0) + ' ms';"));

        methodOptions.setTooltip(optionsTooltip);

        for(String className: Attributes.currentProfilingScenario.methodList.keySet()){
            for(String method: Attributes.currentProfilingScenario.methodList.get(className)){

                ArrayList<Coordinate<Integer, Long>> oneMethodData = new ArrayList<Coordinate<Integer, Long>>();

                CustomCoordinatesSeries<Integer, Long> oneMethodSeries = new CustomCoordinatesSeries<Integer, Long>();
                //oneMethodData.add(new Coordinate<Integer, Long>(new Integer(0),new Long(0)));
                oneMethodSeries.setName(method);
                oneMethodSeries.setData(oneMethodData);

                methodData.put(method, oneMethodData);
                methodSeries.add(oneMethodSeries);
                methodOptions.addSeries(oneMethodSeries);

            }
        }

        methodChart = new Chart("methodRunsChart", methodOptions);
        methodPanel = new WebMarkupContainer("methodPanel");
        methodPanel.add(methodChart);
        methodPanel.add(new AjaxSelfUpdatingTimerBehavior(Duration.seconds(SELF_UPDATE_INTERVAL)));
        add(methodPanel);

    }   //Constructor end

    /**
     *  Prepares data for method run chart
     * */
    public static void prepareData(Map<String, TimeMeasurement> methodRunMap){
        //methodRunMap.clear();

        for(String method: methodData.keySet()){

            int counter = 0;
            if(methodRunMap.containsKey(method)){
                methodData.get(method).clear();
                for(MethodRun m: methodRunMap.get(method).methodRunList){
                    methodData.get(method).add(new Coordinate<Integer, Long>(counter, m.getEstimatedTime()/1000000));
                    counter++;
                }
            }
        }

    }   //prepareData end


}

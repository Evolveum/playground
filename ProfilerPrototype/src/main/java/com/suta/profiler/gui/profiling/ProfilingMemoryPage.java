package com.suta.profiler.gui.profiling;

import com.googlecode.wickedcharts.highcharts.options.*;
import com.googlecode.wickedcharts.highcharts.options.color.HexColor;
import com.googlecode.wickedcharts.highcharts.options.series.*;
import com.googlecode.wickedcharts.wicket6.highcharts.Chart;
import com.profiler.agent.MemoryMeasurement;
import com.suta.profiler.gui.util.ProfilingPage;
import org.apache.wicket.ajax.AjaxSelfUpdatingTimerBehavior;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.time.Duration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 *  TODO - description
 *  TODO - add information about GC + enable starting of GC cycle
 *  TODO - collect-time information implementation on agent
 *  TODO - when ajax refreshes page it jumps to first refreshed component
 *
 *  @author Erik Suta
 *
 * */
public class ProfilingMemoryPage extends ProfilingPage{

    /* Attributes */
    private static final long serialVersionUID = 1L;
    private static int KB = 1024;
    private static int MB = 1024*1024;
    private static List<Coordinate<Long, Long>> heapMemoryData = new ArrayList<Coordinate<Long, Long>>();
    private static List<Coordinate<Long, Long>> nonHeapMemoryData = new ArrayList<Coordinate<Long, Long>>();
    private static MemoryMeasurement actMemMeasurement;

    private static CustomCoordinatesSeries<Long, Long> heapSeries = new CustomCoordinatesSeries<Long, Long>();
    private static CustomCoordinatesSeries<Long, Long> nonHeapSeries = new CustomCoordinatesSeries<Long, Long>();

    private Chart heapChart;
    private Chart nonHeapChart;

    private static String heapUsedLabel = "-";
    private static String heapFreeLabel = "-";
    private static String heapMaxLabel = "-";
    private static String heapTotalLabel = "-";
    private static String nonUsedLabel = "-";
    private static String nonCommittedLabel = "-";
    private static String nonInitLabel = "-";
    private static String nonMaxLabel = "-";

    /* GUI attributes */
    private Label heapUsed = new Label("heapUsed", new PropertyModel<String>(this, "heapUsedLabel"));
    private Label heapFree = new Label("heapFree", new PropertyModel<String>(this, "heapFreeLabel"));
    private Label heapMax = new Label("heapMax", new PropertyModel<String>(this, "heapMaxLabel"));
    private Label heapTotal = new Label("heapTotal", new PropertyModel<String>(this, "heapTotalLabel"));
    private Label nonUsed = new Label("nonUsed", new PropertyModel<String>(this, "nonUsedLabel"));
    private Label nonCommitted = new Label("nonCommitted", new PropertyModel<String>(this, "nonCommittedLabel"));
    private Label nonInit = new Label("nonInit", new PropertyModel<String>(this, "nonInitLabel"));
    private Label nonMax = new Label("nonMax", new PropertyModel<String>(this, "nonMaxLabel"));

    WebMarkupContainer memoryPanel = new WebMarkupContainer("memoryPanel");

    /**
     *  Constructor
     * */
    public ProfilingMemoryPage(final PageParameters parameters){
        super(parameters);

        //Heap memory usage chart
        Options heapOptions = new Options();

        ChartOptions chartOptions = new ChartOptions();
        chartOptions.setType(SeriesType.LINE);
        chartOptions.setMarginRight(130).setMarginBottom(50);
        chartOptions.setZoomType(ZoomType.X).setSpacingRight(20);
        heapOptions.setChartOptions(chartOptions);

        heapOptions.setTitle(new Title("Heap Memory Usage"));

        Axis xAxis = new Axis();
        xAxis.setType(AxisType.DATETIME).setTickPixelInterval(150);
        //Add DateTimeLabelFormat if needed
        heapOptions.setxAxis(xAxis);

        Axis yAxis = new Axis();
        yAxis.setTitle(new Title("Value [MB]"))
             .setPlotLines(Collections.singletonList(new PlotLine()
                     .setValue(0f)
                     .setWidth(1)
                     .setColor(new HexColor("#808080"))));
        heapOptions.setyAxis(yAxis);

        Tooltip optionsTooltip = new Tooltip();
        optionsTooltip.setFormatter(new Function()
                .setFunction("return '<b>'+ this.series.name +'</b><br/>'+"
                        + "Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) +'<br/>'+"
                        + "Highcharts.numberFormat(this.y, 2);"));
        heapOptions.setTooltip(optionsTooltip);
        heapOptions.setLegend(new Legend(Boolean.FALSE));

        //Non-Heap memory usage chart
        Options nonHeapOptions = new Options();
        nonHeapOptions.setChartOptions(chartOptions);

        nonHeapOptions.setTitle(new Title("Non-Heap Memory Usage"));
        nonHeapOptions.setxAxis(xAxis);
        nonHeapOptions.setyAxis(yAxis);
        nonHeapOptions.setTooltip(optionsTooltip);
        nonHeapOptions.setLegend(new Legend(Boolean.FALSE));

        //Defining series
        heapSeries.setName("Heap memory Usage");
        heapSeries.setData(heapMemoryData);
        heapOptions.addSeries(heapSeries);

        nonHeapSeries.setName("Non-heap memory usage");
        nonHeapSeries.setData(nonHeapMemoryData);
        nonHeapOptions.addSeries(nonHeapSeries);

        heapChart = new Chart("heapChart", heapOptions);

        nonHeapChart = new Chart("nonHeapChart", nonHeapOptions);

        memoryPanel.add(heapChart);
        memoryPanel.add(nonHeapChart);
        memoryPanel.add(heapUsed);
        memoryPanel.add(heapFree);
        memoryPanel.add(heapMax);
        memoryPanel.add(heapTotal);
        memoryPanel.add(nonUsed);
        memoryPanel.add(nonCommitted);
        memoryPanel.add(nonInit);
        memoryPanel.add(nonMax);
        memoryPanel.add(new AjaxSelfUpdatingTimerBehavior(Duration.seconds(SELF_UPDATE_INTERVAL)));
        add(memoryPanel);
    }   //Constructor end

    /**
     *  Prepares memory profiling data
     * */
    public static void prepareMemoryData(List<MemoryMeasurement> memoryUsageList){
        long time = new Date().getTime();

        for(MemoryMeasurement m: memoryUsageList){
            heapMemoryData.add(new Coordinate<Long, Long>(time, m.getUsedMemory()/MB));
            nonHeapMemoryData.add(new Coordinate<Long, Long>(time, m.getNonHeapUsed()/MB));
            time += 1000;
        }

        if(!memoryUsageList.isEmpty()){
            actMemMeasurement = memoryUsageList.get(memoryUsageList.size()-1);
            heapUsedLabel = String.format("%,d  kbytes", (actMemMeasurement.getUsedMemory()/KB));
            heapFreeLabel = String.format("%,d  kbytes", (actMemMeasurement.getFreeMemory()/KB));
            heapMaxLabel = String.format("%,d  kbytes", (actMemMeasurement.getMaxMemory()/KB));
            heapTotalLabel = String.format("%,d  kbytes", (actMemMeasurement.getTotalMemory()/KB));
            nonUsedLabel = String.format("%,d  kbytes", (actMemMeasurement.getNonHeapUsed()/KB));
            nonCommittedLabel = String.format("%,d  kbytes", (actMemMeasurement.getNonHeapCommitted()/KB));
            nonInitLabel = String.format("%,d  kbytes", (actMemMeasurement.getNonHeapInit()/KB));
            nonMaxLabel = String.format("%,d  kbytes", (actMemMeasurement.getNonHeapMax()/KB));
        }
        else
            actMemMeasurement = null;


    }   //prepareMemoryData end

    /* GETTERS AND SETTERS */
    public static List<Coordinate<Long, Long>> getHeapMemoryData() {
        return heapMemoryData;
    }

    public static MemoryMeasurement getActMemMeasurement(){
        return actMemMeasurement;
    }


}

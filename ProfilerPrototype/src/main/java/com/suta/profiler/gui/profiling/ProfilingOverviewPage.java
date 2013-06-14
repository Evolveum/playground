package com.suta.profiler.gui.profiling;

import com.googlecode.wickedcharts.highcharts.options.*;
import com.googlecode.wickedcharts.highcharts.options.color.HexColor;
import com.googlecode.wickedcharts.highcharts.options.series.Coordinate;
import com.googlecode.wickedcharts.highcharts.options.series.CustomCoordinatesSeries;
import com.googlecode.wickedcharts.wicket6.highcharts.Chart;
import com.suta.profiler.Attributes;
import com.suta.profiler.gui.util.ProfilingPage;
import org.apache.wicket.ajax.AjaxSelfUpdatingTimerBehavior;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.time.Duration;
import sun.plugin2.gluegen.runtime.CPU;
import sun.usagetracker.UsageTrackerClient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *  TODO - add functionality (button) to stop profiling
 *  TODO - add functionality (button) to export report from profiling
 *  TODO - add functionality (button) to ALL profiling pages to temporary stop/start auto-refresh to examine data
 *
 *  @author Erik Suta
 * */
public class ProfilingOverviewPage extends ProfilingPage{

    /* Attributes */
    private static final long serialVersionUID = 1L;
    //private static List<Coordinate<Long, Double>> cpuData = new ArrayList<Coordinate<Long, Double>>();
    //private static List<Coordinate<Long, Integer>> classData = new ArrayList<Coordinate<Long,java.lang.Integer>>();
    //private static List<Coordinate<Long, Long>> heapMemoryData = new ArrayList<Coordinate<Long, Long>>();
    //private static List<Coordinate<Long, Integer>> threadData = new ArrayList<Coordinate<Long, Integer>>();

    private static CustomCoordinatesSeries<Long, Double> cpuSeries = new CustomCoordinatesSeries<Long, Double>();
    private static CustomCoordinatesSeries<Long, Integer> classSeries = new CustomCoordinatesSeries<Long, Integer>();
    private static CustomCoordinatesSeries<Long, Long> memorySeries = new CustomCoordinatesSeries<Long, Long>();
    private static CustomCoordinatesSeries<Long, Integer> threadSeries = new CustomCoordinatesSeries<Long, Integer>();

    /* GUI attributes */
    private Chart cpuChart;
    private Chart memoryChart;
    private Chart classChart;
    private Chart threadChart;
    private WebMarkupContainer overviewPanel = new WebMarkupContainer("overviewPanel");

    /**
     *  Constructor
     * */
    public ProfilingOverviewPage(final PageParameters parameters){
        super(parameters);

        add(new Label("projectName", Model.of(Attributes.currentProject.getProgramName())));

        //Options
        Options memoryOptions = new Options();
        Options cpuOptions = new Options();
        Options classOptions = new Options();
        Options threadOptions = new Options();

        //ChartOptions
        ChartOptions chartOptions = new ChartOptions();
        chartOptions.setType(SeriesType.LINE);
        chartOptions.setMarginRight(130).setMarginBottom(50);
        chartOptions.setZoomType(ZoomType.X).setSpacingRight(20);

        memoryOptions.setChartOptions(chartOptions);
        cpuOptions.setChartOptions(chartOptions);
        classOptions.setChartOptions(chartOptions);
        threadOptions.setChartOptions(chartOptions);

        memoryOptions.setTitle(new Title("Memory Profiling Overview")).setSubtitle(new Title("Heap Memory Usage"));
        cpuOptions.setTitle(new Title("CPU Profiling Overview")).setSubtitle(new Title("CPU Usage Chart"));
        classOptions.setTitle(new Title("Class Profiling Overview")).setSubtitle(new Title("Loaded Classes Snapshot"));
        threadOptions.setTitle(new Title("Thread Profiling Overview")).setSubtitle(new Title("Thread Count Snapshot"));

        memoryOptions.setxAxis(constructXAxis());
        cpuOptions.setxAxis(constructXAxis());
        classOptions.setxAxis(constructXAxis());
        threadOptions.setxAxis(constructXAxis());

        memoryOptions.setyAxis(constructYAxis("Heap Memory Usage [MB]"));
        cpuOptions.setyAxis(constructYAxis("CPU Usage [%]"));
        classOptions.setyAxis(constructYAxis("Loaded Classes"));
        threadOptions.setyAxis(constructYAxis("Thread Count"));

        memoryOptions.setTooltip(constructTooltip(2, "MB"));
        cpuOptions.setTooltip(constructTooltip(1, "%"));
        classOptions.setTooltip(constructTooltip(0, "classes"));
        threadOptions.setTooltip(constructTooltip(0, "threads"));

        memoryOptions.setLegend(new Legend(Boolean.FALSE));
        cpuOptions.setLegend(new Legend(Boolean.FALSE));
        classOptions.setLegend(new Legend(Boolean.FALSE));
        threadOptions.setLegend(new Legend(Boolean.FALSE));

        memoryOptions.addSeries(memorySeries);
        cpuOptions.addSeries(cpuSeries);
        classOptions.addSeries(classSeries);
        threadOptions.addSeries(threadSeries);

        memoryChart = new Chart("memoryChart", memoryOptions);
        cpuChart = new Chart("cpuChart", cpuOptions);
        classChart = new Chart("threadChart", classOptions);
        threadChart = new Chart("classChart", threadOptions);

        overviewPanel.add(memoryChart);
        overviewPanel.add(cpuChart);
        overviewPanel.add(classChart);
        overviewPanel.add(threadChart);
        overviewPanel.add(new AjaxSelfUpdatingTimerBehavior(Duration.seconds(SELF_UPDATE_INTERVAL)));

        Form form = new Form("form");
        form.add(new Button("stopProfButton"){

            @Override
            public void onSubmit(){
                //TODO - STOP PROFILING HERE
            }
        });

        overviewPanel.add(form);

        add(overviewPanel);


    }   //Constructor end

    /**
     *  Add reference to all profiling data
     * */
    public static void getProfilingData(){
        memorySeries.setName("Heap Memory Usage");
        cpuSeries.setName("CPU Usage");
        classSeries.setName("Loaded Classes");
        threadSeries.setName("Thread count");

        cpuSeries.setData(ProfilingCPUPage.getCpuData());
        memorySeries.setData(ProfilingMemoryPage.getHeapMemoryData());
        classSeries.setData(ProfilingClassesPage.getClassData());
        threadSeries.setData(ProfilingThreadsPage.getThreadData());

        System.out.println("MEMORY["+memorySeries.getData().size()+"] + CPU["+cpuSeries.getData().size()+"] + CLASS["+classSeries.getData().size()+"] + THREAD["+threadSeries.getData().size()+"]");
    }

    /**
     *  Creates xAxis for all charts
     * */
    private Axis constructXAxis(){
        Axis xAxis = new Axis();

        xAxis.setType(AxisType.DATETIME).setTickPixelInterval(150);
        //TODO - add better DateTimeLabelFormat

        return xAxis;
    }

    /**
     *  Creates yAxis for all charts on the page
     * */
    private Axis constructYAxis(String title){
        Axis yAxis = new Axis();

        yAxis.setTitle(new Title(title))
             .setMin(0)
             .setPlotLines(Collections.singletonList(new PlotLine()
                     .setValue(0f)
                     .setWidth(1)
                     .setColor(new HexColor("#808080"))));

        if(title.startsWith("CPU")){
            yAxis.setMinRange(100)
                 .setMax(100);
        }

        return yAxis;
    }

    /**
     *  Constructs tooltip for chart points
     * */
    private Tooltip constructTooltip(int numericMembers, String pointInfo){
        Tooltip tooltip = new Tooltip();
        tooltip.setFormatter(new Function()
                    .setFunction("return '<b>'+ this.series.name +'</b><br/>'+"
                            + "Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) +'<br/>'+"
                            + "Highcharts.numberFormat(this.y, " + numericMembers + ") + ' " + pointInfo + "';"));

        return tooltip;
    }



}

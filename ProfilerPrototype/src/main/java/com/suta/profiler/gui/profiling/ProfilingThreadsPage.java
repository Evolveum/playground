package com.suta.profiler.gui.profiling;

import com.googlecode.wickedcharts.highcharts.options.*;
import com.googlecode.wickedcharts.highcharts.options.color.HexColor;
import com.googlecode.wickedcharts.highcharts.options.series.Coordinate;
import com.googlecode.wickedcharts.highcharts.options.series.CustomCoordinatesSeries;
import com.googlecode.wickedcharts.wicket6.highcharts.Chart;
import com.profiler.agent.ThreadMeasurement;
import com.suta.profiler.gui.util.ProfilingPage;
import org.apache.wicket.ajax.AjaxSelfUpdatingTimerBehavior;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.time.Duration;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 *  TODO - class description
 *  TODO - add AJAX behavior to list of threads + window to the right, which would show selected threads stack trace and info
 *  TODO - collect time on target JVM - not static incrementation on server
 *  TODO - add SimpleAttributeModifiers to render different colored rows using class modifier.
 *
 *  @author Erik Suta
 * */
public class ProfilingThreadsPage extends ProfilingPage{

    /* Attributes */
    private static final long serialVersionUID = 1L;
    private static List<Coordinate<Long, Integer>> threadData = new ArrayList<Coordinate<Long, Integer>>();
    private static CustomCoordinatesSeries<Long, Integer> threadSeries = new CustomCoordinatesSeries<Long, Integer>();
    private static ThreadMeasurement actThreadMeasurement = new ThreadMeasurement();
    private static List<CustomThread> customThreadList = new ArrayList<CustomThread>();

    /* GUI attributes */
    private Chart threadChart;
    private WebMarkupContainer threadPanel = new WebMarkupContainer("threadPanel");

    /**
     *  Constructor
     * */
    public ProfilingThreadsPage(final PageParameters parameters){
        super(parameters);

        Options threadOptions = new Options();

        ChartOptions threadChartOptions = new ChartOptions();
        threadChartOptions.setType(SeriesType.LINE);
        threadChartOptions.setMarginRight(130).setMarginBottom(50);
        threadChartOptions.setZoomType(ZoomType.X).setSpacingRight(20);

        threadOptions.setChartOptions(threadChartOptions);
        threadOptions.setTitle(new Title("Thread Count"));
        threadOptions.setSubtitle(new Title("current timestamp snapshot"));

        Axis xAxis = new Axis().setType(AxisType.DATETIME);
        threadOptions.setxAxis(xAxis);

        PlotLine plotLine = new PlotLine();
        plotLine.setValue(0f).setWidth(1).setColor(new HexColor("#999999"));

        Axis yAxis = new Axis().setTitle(new Title("Thread Count"));
        yAxis.setPlotLines(Collections.singletonList(plotLine));
        yAxis.setMin(0);
        threadOptions.setyAxis(yAxis);

        threadOptions.setLegend(new Legend(Boolean.FALSE));

        Tooltip optionsTooltip = new Tooltip();
        optionsTooltip.setFormatter(new Function()
                .setFunction("return '<b>'+ this.series.name +'</b><br/>'+"
                        + "Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) +'<br/>'+"
                        + "Highcharts.numberFormat(this.y, 0) + ' threads';"));

        threadOptions.setTooltip(optionsTooltip);

        threadSeries.setName("Number of Threads");
        threadSeries.setData(threadData);
        threadOptions.addSeries(threadSeries);

        threadChart = new Chart("threadChart", threadOptions);
        threadPanel.add(threadChart);
        threadPanel.add(new AjaxSelfUpdatingTimerBehavior(Duration.seconds(SELF_UPDATE_INTERVAL)));

        //Creating listView of threads
        ListView threadListView = new ListView<CustomThread>("threadList", customThreadList) {
            @Override
            protected void populateItem(ListItem listItem) {
                final CustomThread thread = (CustomThread)listItem.getModelObject();
                listItem.add(new Label("threadOrder", thread.getThreadOrder()));
                listItem.add(new Label("ThreadID", thread.getThreadId()));
                listItem.add(new Label("ThreadName", thread.getThreadName()));

                listItem.add(new Link("showOption") {

                    @Override
                    public void onClick(){
                        //TODO - implement showing detailed information about selected Thread
                        //TODO - implement showing stack trace of selected Thread
                    }
                });
            }
        };
        threadPanel.add(threadListView);

        add(threadPanel);

    }   //Constructor end


    /**
     *  Prepares data for presentation in dynamic chart
     * */
    public static void prepareData(List<ThreadMeasurement> threadList){
        long time = new Date().getTime();

        for(ThreadMeasurement t: threadList){
            threadData.add(new Coordinate<Long, Integer>(time, t.getThreadCount()));
            time += 1000;
        }

        if(!threadList.isEmpty())
            actThreadMeasurement = threadList.get(threadList.size()-1);

        customThreadList.clear();

        //if(actThreadMeasurement)
        for(int i = 0; i < actThreadMeasurement.getThreadCount(); i++){
            CustomThread thread = new CustomThread(i, actThreadMeasurement.getThreadIds()[i], actThreadMeasurement.getThreadNames()[i]);
            customThreadList.add(thread);
        }

    }   //prepareData end

    /* GETTERS AND SETTERS */
    public static List<Coordinate<Long, Integer>> getThreadData() {
        return threadData;
    }

    public static Integer getLiveThreads(){
        if(actThreadMeasurement != null)
            return actThreadMeasurement.getThreadCount();
        else
            return 0;
    }
}

/**
 *  This class is created for presentation purposes only
 * */
class CustomThread implements Serializable {

    /* Attributes */
    private int threadOrder;
    private long threadId;
    private String threadName;

    /* Constructor */
    public CustomThread(int order, long id, String name){
        this.threadOrder = order;
        this.threadId = id;
        this.threadName = name;
    }

    /* GETTERS AND SETTERS */
    public int getThreadOrder(){
        return threadOrder;
    }

    public long getThreadId() {
        return threadId;
    }

    public String getThreadName() {
        return threadName;
    }
}

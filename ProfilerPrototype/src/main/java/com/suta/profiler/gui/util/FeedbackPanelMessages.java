package com.suta.profiler.gui.util;

/**
 *
 *  This class is responsible for generating wicket FeedbackPanel messages
 *
 *  @author Erik Suta
 *
 * */
public class FeedbackPanelMessages {

    /**
     *  Generates success message
     * */
    public static String generateSuccessMessage(String message){
        String messageText = "<div id=\"message-green\">\n" +
                "<table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                "<tr height=\"30px\">\n" +
                "<td class=\"green-left\">" + message + "</td>\n" +
                "<td class=\"green-right\"><a class=\"close-green\"><img src=\"../images/table/icon_close_green.gif\"   alt=\"\" /></a></td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "</div>";

        return messageText;
    }
}

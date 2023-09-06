package com.evolveum.demo.connector;

import java.text.DateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;

public class Clock extends Label {

	public Clock(String id, TimeZone tz) {
		super(id, new ClockModel(tz));
	}

	private static class ClockModel implements IModel<String> {
		private final DateFormat df;

		public ClockModel(TimeZone tz) {
			df = DateFormat.getDateTimeInstance(DateFormat.FULL,
					DateFormat.LONG);
			df.setTimeZone(tz);
		}

		@Override
		public String getObject() {
			return df.format(new Date());
		}
	}
}

package user_gui;

import java.util.ArrayList;
import java.util.List;

public class Ccc {
	public int count = 456789;
	public String variable = "World";
	public List<String> list = new ArrayList<String>();
	public String html = "";

	public Ccc() {
		list.add("Janko");
		list.add("Hraško");
		list.add("Jožko");
		list.add("Mrkvièka");
		html = "<table width='300px' border='2'>" + createRowsAndCols(4, 3) + "</table>";
	}

	private String createRowsAndCols(int rowsCount, int colsCount) {
		int counter = rowsCount*colsCount;
		String result = "";
		for (int i = 0; i < rowsCount; i++) {
			result += "<tr>";
			for (int j = 0; j < colsCount; j++) {
				result += "<td>" + counter + "</td>";
				counter--;
			}
			result += "</tr>";
		}
		return result;
	}

}

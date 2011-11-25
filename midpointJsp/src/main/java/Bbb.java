import java.util.ArrayList;

public class Bbb {
	public int count = 100;
	public String variable = "hello";
	public ArrayList<String> list = new ArrayList<String>();
	
	public String html = "";

	public Bbb() {
		list.add("String1");
		list.add("String2");
		list.add("String3");
		list.add("String4");
		html = "<table width='300px' border='2'>" + createRowsAndCols(4, 3) + "</table>";
	}

	private String createRowsAndCols(int rowsCount, int colsCount) {
		int counter = 1;
		String result = "";
		for (int i = 0; i < rowsCount; i++) {
			result += "<tr>";
			for (int j = 0; j < colsCount; j++) {
				result += "<td>" + counter + "</td>";
				counter++;
			}
			result += "</tr>";
		}
		return result;
	}

}

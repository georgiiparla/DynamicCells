package ui;

import java.util.ArrayList;

public class Menu {

  private static Menu menu;
  public ArrayList<Row> rows = new ArrayList<>();

  // ANSI escape codes
  public static final String GREEN = "\u001B[32m";
  public static final String RESET = "\u001B[0m";
  public static final String H = GREEN + "#" + RESET;

  private Menu() {
    rows.add(new Row("Source port", "Destination Port"));
    rows.add(new Row("Sequence number"));
    rows.add(new Row("Acknowledgment number"));
    rows.add(new Row("DO", "RSV", "Flags", "Window"));
    rows.add(new Row("Checksum", "Urgent pointer"));
    rows.add(new Row("Options"));
  }

  public void display() {
    if (rows.isEmpty()) {
      return;
    }

    int tableWidth = 0;
    for (Row r : rows) {
      if (r.data.length == 0)
        continue;
      int maxCellLength = 0;
      for (String s : r.data) {
        if (s.length() > maxCellLength) {
          maxCellLength = s.length();
        }
      }
      int minWidthForRow = (maxCellLength * r.data.length) + r.data.length + 1;
      if (minWidthForRow > tableWidth) {
        tableWidth = minWidthForRow;
      }
    }

    StringBuilder tb = new StringBuilder();
    String divider = H.repeat(tableWidth) + "\n";

    tb.append(divider);

    for (int rowIndex = 0; rowIndex < rows.size(); rowIndex++) {
      Row r = rows.get(rowIndex);

      if (r.data.length == 0) {
        if (rowIndex < rows.size() - 1) {
          tb.append(divider);
        }
        continue;
      }

      int totalContentSpace = tableWidth - (r.data.length + 1);
      int baseCellWidth = totalContentSpace / r.data.length;
      int remainder = totalContentSpace % r.data.length;

      tb.append(H);

      for (int i = 0; i < r.data.length; i++) {
        String cellData = r.data[i];
        int cellBlockWidth = baseCellWidth + (i < remainder ? 1 : 0);
        int padding = cellBlockWidth - cellData.length();

        if (padding < 0)
          padding = 0;

        tb.append(cellData);
        tb.append(" ".repeat(padding));
        tb.append(H);
      }
      tb.append("\n");

      if (rowIndex < rows.size() - 1) {
        tb.append(divider);
      }
    }

    tb.append(divider);

    System.out.println(tb.toString());
  }

  public static Menu getInstance() {
    if (menu == null) {
      menu = new Menu();
    }
    return menu;
  }
}

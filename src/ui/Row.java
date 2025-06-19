package ui;

public class Row {
  public String[] data;
  public int textLength = 0;

  public Row(String... data) {
    this.data = data;
    for (String s : data) {
      textLength += s.length();
    }
  }
}


# Java Table Renderer

A simple console application that creates beautiful ASCII tables with dynamic cell widths, perfect for visualizing structured data like protocol headers.

## ✨ Features

- **Dynamic Layout**: Automatically adjusts to varying row sizes
- **Smart Padding**: Evenly distributes space across cells
- **Clean Output**: Terminal-friendly ASCII borders
- **Flexible Design**: Easy to customize content

## 🚀 Quick Start

Simply modify the table content in `src/ui/Menu.java`:

```java
rows.add(new Row("Header 1", "Header 2", "Header 3"));
rows.add(new Row("Data A", "Data B"));
rows.add(new Row("Single Cell"));
```

The renderer will automatically create a perfectly aligned table:

```
#################################
# Header 1  # Header 2  # Header 3 #
#################################
# Data A         # Data B         #
#################################
#        Single Cell             #
#################################
```

## 🔧 How It Works

The rendering uses a smart **two-pass algorithm**:

### Pass 1: Calculate Master Width
- Scans all rows to find the optimal table width
- Ensures even the widest row fits perfectly

### Pass 2: Render Table
- Distributes space evenly across cells in each row
- Adds consistent borders and padding
- Creates a balanced, grid-like structure

## 📝 Customization

Want to change your table? Just edit the `Menu()` constructor:

```java
// Add any number of cells per row
rows.add(new Row("TCP", "Header", "Format"));
rows.add(new Row("Source Port", "Destination Port"));
rows.add(new Row("Sequence Number"));
```

The algorithm handles the rest automatically!

## 🎯 Perfect For

- Protocol documentation
- Data visualization
- Terminal dashboards
- Debug output formatting

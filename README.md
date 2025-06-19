Remove-Item -Recurse -Force .git

git init

javac -d out -sourcepath src src/Main.java

java -cp out Main


------------------------------------------


This is a simple Java console application designed to render text-based tables with dynamic cell widths. The goal is to create clean, structured layouts directly in the terminal, similar to how protocol headers (like the TCP header) are often visualized in documentation.

The key feature of this application is its ability to handle rows with varying numbers of cells and automatically adjust padding to create a visually appealing, grid-like structure where the cells in each row are balanced.

> How the Rendering Algorithm Works:

The table layout is generated using a two-pass algorithm. This approach ensures that all rows are rendered uniformly within a consistent table width, regardless of the number or size of cells in each individual row.

Pass 1: Calculating the Master Table Width
Before any part of the table is drawn, the algorithm must first determine the total width of the final table.

It iterates through every Row object you've defined.

For each row, it finds the single widest (longest) piece of text among its cells.

It then calculates a hypothetical minimum width for that row. This is calculated as if all cells in that row were as wide as the single widest cell. The formula is: (width_of_longest_cell * number_of_cells) + (number_of_separators).

The algorithm keeps track of the largest hypothetical width it finds across all rows. This becomes the master table width.

This process guarantees that even the "widest" row will have enough space to be rendered without breaking the layout.

Pass 2: Drawing the Table
Once the master table width is known, the algorithm begins building the output string.

Borders and Dividers: A horizontal divider (e.g., #######...) is created using the calculated master table width. This is used for the top border, bottom border, and the lines between each row.

Row Rendering: The algorithm iterates through each Row one more time to draw it.

It calculates the total space available for text within that specific row by subtracting the space taken by the vertical separators (#) from the master table width.

This available space is then divided as evenly as possible among the number of cells in that specific row. For example, a row with 2 cells will have the space split in half; a row with 4 cells will have it split into quarters.

If the space doesn't divide perfectly, the leftover pixels of padding are distributed one by one to the first few cells to ensure a balanced look.

Finally, each cell's text is printed, followed by the calculated padding needed to fill its allocated block of space.

This two-pass method allows the application to create complex, multi-column layouts that are both dynamic and neatly aligned.

> Customization:
To change the content of the table, simply modify the rows.add(new Row(...)); lines inside the Menu() constructor in src/ui/Menu.java. You can add, remove, or change the text and number of cells for any row, and the algorithm will automatically adjust the layout.

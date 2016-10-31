package net.openhft.chronicle.engine.api.column;

import org.jetbrains.annotations.NotNull;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Rob Austin.
 */
public class Row {

    private final List<String> columnNames;
    private Map<String, Object> data = new LinkedHashMap<>();



    /**
     * @param columns all the column names that make up this row
     */
    public Row(@NotNull List<Column> columns) {
        columnNames = columns.stream().map(c -> c.name).collect(Collectors.toList());
    }

    /**
     * @return the value in the cell denoted by the {@code columnName}  in this row
     */
    public Object get(String columnName) {
        return data.get(columnName);
    }

    /**
     * @return the value in the cell denoted by the {@code columnIndex}  in this row
     */
    public Object get(int columnIndex) {
        return data.get(columnNames.get(columnIndex));
    }

    /**
     * sets the value in a cell
     *
     * @param columnName the name of the cell that is being set in this row
     * @param newValue   the new value that is being store
     */
    public void set(String columnName, Object newValue) {
        assert columnNames.contains(columnName);
        data.put(columnName, newValue);
    }
}

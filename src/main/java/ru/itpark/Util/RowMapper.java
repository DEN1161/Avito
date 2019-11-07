package ru.itpark.Util;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper<T> {
    T map(ResultSet resultSet) throws SQLException; // если в лямбде может быть сгенерировано Checked Exception, то и в сигнатуре должно быть

}

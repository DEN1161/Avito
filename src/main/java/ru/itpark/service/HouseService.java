package ru.itpark.service;

import ru.itpark.Util.JdbcTemplate;
import ru.itpark.model.House;

import java.sql.SQLException;
import java.util.*;

public class HouseService {
    private Collection<House> items = new LinkedList<>();

    public void addAll(House... items) {
        Collections.addAll(this.items, items);
    }

    public List<House> searchByPrice(int min, int max, Comparator<House> comparator) throws SQLException {
        List<House> result = new ArrayList<>();
        extradition();
        for (House house : items) {
            if (house.getPrice() >= min && house.getPrice() <= max) {
                result.add(house);
            }
        }
        Collections.sort(result, comparator);
        return result;
    }

    public List<House> searchByMetro(String... metros) throws SQLException {
        List<House> result = new ArrayList<>();
        extradition();
        for (House house : items) {
            for (String metro : metros) {
                if (house.getMetro().equals(metro)) {
                    result.add(house);
                    break;
                }
            }
        }
        return result;
    }

    public List<House> sortBy(Comparator<House> comparator) throws SQLException {
        List<House> result = new ArrayList<>(items);
        extradition();
        result.sort(comparator);
        return result;
    }
    public void extradition() throws SQLException {
       items = JdbcTemplate.executeQuery("jdbc:sqlite:C:db.sqlite" ,
                "SELECT id, price ,rooms , district, metro FROM houses" ,
                resultSet -> new House(
                        resultSet.getInt("id"),
                        resultSet.getInt("price"),
                        resultSet.getInt("rooms"),
                        resultSet.getString("district"),
                        resultSet.getString("metro")
                ));
    }
}

package com.malkfilipp.travelplanner.dao.jdbc;

import com.malkfilipp.travelplanner.dao.GenericDao;
import com.malkfilipp.travelplanner.model.location.City;
import com.malkfilipp.travelplanner.model.location.Country;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CityDaoImpl implements GenericDao<City, Integer> {
    @Override
    public void create(City newInstance) {
        try (Connection conn = Database.getConnection()) {
            String sql = "insert into City values (?, ?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, newInstance.getId());
            ps.setString(2, newInstance.getName());
            ps.setString(3, newInstance.getCountry().getId());
            ps.setTime(4, newInstance.getTimezone());
            ps.setBoolean(5, newInstance.isSummerShift());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public City read(Integer id) {
        City city = null;

        try (Connection conn = Database.getConnection()) {
            String sql = "select * from City " +
                    "inner join Country on City.countryId = Country.id " +
                    "where City.id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next())
                city = new City(
                        rs.getInt(1),
                        rs.getString(2),
                        new Country(
                                rs.getString(6),
                                rs.getString(7)
                        ),
                        rs.getTime(4),
                        rs.getBoolean(5)
                );

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return city;
    }

    @Override
    public void update(City transientObject) {

    }

    @Override
    public void delete(City persistentObject) {

    }
}

package com.malkfilipp.travelplanner.dao.jdbc;

import com.malkfilipp.travelplanner.dao.GenericDao;
import com.malkfilipp.travelplanner.model.location.Country;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryDaoImpl implements GenericDao<Country, String> {

    @Override
    public void create(Country newInstance) {
        try (Connection conn = Database.getConnection()) {
            String sql = "insert into Country values (?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, newInstance.getId());
            ps.setString(2, newInstance.getName());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Country read(String id) {
        Country country = null;

        try (Connection conn = Database.getConnection()) {
            String sql = "select * from Country where id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next())
                country = new Country(
                        rs.getString("id"),
                        rs.getString("name")
                );

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return country;
    }

    @Override
    public void update(Country transientObject) {
        try (Connection conn = Database.getConnection()) {
            String sql = "update Country set name = ? where id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, transientObject.getName());
            ps.setString(2, transientObject.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Country persistentObject) {
        try (Connection conn = Database.getConnection()) {
            String sql = "delete from Country  where id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, persistentObject.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

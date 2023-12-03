package org.example.hexlet.repository;

import org.example.hexlet.model.Course;
import org.example.hexlet.model.User;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository extends BaseRepository {
    private static List<User> entities = new ArrayList<User>();

    public static void save(User user) throws SQLException {
        String sql = "INSERT INTO users (firstName, lastName, password, email) " +
                "VALUES (?, ?, ?, ?)";
        try (var conn = dataSource.getConnection();
             var preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.executeUpdate();
            var generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                user.setId(generatedKeys.getLong(1));
            } else {
                throw new SQLException("DB have not returned an id after saving an entity");
            }
        }
    }

    public static Optional<User> find(Long id) throws SQLException {
        var sql = "SELECT * FROM users WHERE id = ?";
        try (var conn = dataSource.getConnection();
             var stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            var resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                var firstName = resultSet.getString("firstName");
                var lastName = resultSet.getString("lastName");
                var email = resultSet.getString("email");
                var password = resultSet.getString("password");
                var user = new User(firstName, lastName, email, password);
                user.setId(id);
                return Optional.of(user);
            }
            return Optional.empty();
        }
    }

    public static List<User> getEntities() throws SQLException {
        var sql = "SELECT * FROM users";
        try (var conn = dataSource.getConnection();
             var stmt = conn.prepareStatement(sql)) {
            var resultSet = stmt.executeQuery();
            var result = new ArrayList<User>();
            while (resultSet.next()) {
                var id = resultSet.getLong("id");
                var firstName = resultSet.getString("firstName");
                var lastName = resultSet.getString("lastName");
                var email = resultSet.getString("email");
                var password = resultSet.getString("password");
                var user = new User(firstName,lastName, password, email);
                user.setId(id);
                result.add(user);
            }
            return result;
        }
    }
}

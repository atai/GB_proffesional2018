package Lesson_2;

import java.sql.*;

public class Lesson_2 {

    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement prstmt;

    public static void main(String[] args) {

        try {
            connect();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            stmt.execute("CREATE TABLE IF NOT EXISTS students (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "name TEXT," +
                    "score TEXT)");


//            long t = System.currentTimeMillis();
//      //      connection.setAutoCommit(false);
//
//            for (int i = 0; i < 1000; i++) {
//                stmt.addBatch("INSERT INTO students (name, score)\n" +
//                        "VALUES ('unknow', 100)\n");
//            }
//            stmt.executeBatch();
//
//         //   connection.setAutoCommit(true);
//            System.out.println(System.currentTimeMillis() - t);


//            prstmt = connection.prepareStatement("INSERT INTO students (name, score)" +
//                    " VALUES (?,?)");
//
//            connection.setAutoCommit(false);
//            for (int i = 1; i < 1000; i++) {
//                prstmt.setString(1, "Bob" + (i + 1));
//                prstmt.setInt(2, 20 + i);
//                prstmt.addBatch();
//            }
//            prstmt.executeBatch();
//            connection.setAutoCommit(true);


            stmt.executeUpdate("INSERT INTO students (name, score) VALUES ('Bob1', 20)");
            Savepoint spt = connection.setSavepoint();
            stmt.executeUpdate("INSERT INTO students (name, score) VALUES ('Bob2', 30)");
            connection.rollback(spt);
          //  connection.setAutoCommit(true);
            stmt.executeUpdate("INSERT INTO students (name, score) VALUES ('Bob3', 40)");
           // connection.commit();

            stmt.executeUpdate("INSERT INTO students (name, score) VALUES ('Bob3', 50)");

            ResultSet rs = stmt.executeQuery("SELECT * FROM students");

            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString("name"));
            }


         //   ResultSet rs = stmt.executeQuery("SELECT * FROM students");

//            ResultSetMetaData rsmd = rs.getMetaData();
//
//            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
//                System.out.println(rsmd.getColumnName(i));
//            }
//
//            while (rs.next()) {
//                System.out.println(rs.getInt(1) + " " + rs.getString("name"));
//            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // методы для работы с БД


        disconnect();

    }

    public static void connect() throws ClassNotFoundException, SQLException {

        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:main.db");
        stmt = connection.createStatement();

    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

package sana_hotel.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

import sana_hotel.beans.Reservation;
import sana_hotel.beans.Client;
import sana_hotel.beans.Chambre;

public class Reservationdb {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/sana_hotel";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";

    public Reservationdb() {
    }

    public void writeReservation(int clientId, int roomNumber, String date, int numberOfDays)
            throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO reservations (id, numero, nbreJours, date) VALUES (?, ?, ?, ?)";
        try {
           
            Class.forName("com.mysql.cj.jdbc.Driver");

   
            Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            Chambredb cd=new Chambredb();
            if(cd.chambreDispo(roomNumber)) {

            preparedStatement.setInt(1, clientId);
            preparedStatement.setInt(2, roomNumber);
            preparedStatement.setString(4, date);
            preparedStatement.setInt(3, numberOfDays);

            preparedStatement.executeUpdate();

            System.out.println("Reservation added successfully!");
            }
            else {
            	JOptionPane.showMessageDialog(null, "Room doesn't exist");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void writeOccupation(int roomNumber, String date, int numberOfDays)
            throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO occupation (room_number, date, number_of_days) VALUES (?, ?, ?)";
        try {
        
            Class.forName("com.mysql.cj.jdbc.Driver");

   
            Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, roomNumber);
            preparedStatement.setString(2, date);
            preparedStatement.setInt(3, numberOfDays);

            preparedStatement.executeUpdate();

            System.out.println("Occupation added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Reservation getReservationsByClientId(int clientId) throws SQLException, ClassNotFoundException {
        List<Reservation> resultList = new ArrayList<>();

        String sql = "SELECT * FROM reservations WHERE id = ?";
        try {
      
            Class.forName("com.mysql.cj.jdbc.Driver");

    
            Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

      
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, clientId);

            ResultSet resultSet = preparedStatement.executeQuery();

            
            while (resultSet.next()) {
                int roomNumber = resultSet.getInt("numero");
                String date = resultSet.getString("date");
                int numberOfDays = resultSet.getInt("nbreJours");

                Reservation reservation = new Reservation(clientId, roomNumber, date, numberOfDays);
                return reservation;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Reservation> getReservationsByRoomNumber(int roomNumber) throws SQLException, ClassNotFoundException {
        List<Reservation> resultList = new ArrayList<>();

        String sql = "SELECT * FROM reservations WHERE nombre = ?";
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

         
            Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, roomNumber);

            ResultSet resultSet = preparedStatement.executeQuery();

     
            while (resultSet.next()) {
                int clientId = resultSet.getInt("id");
                String date = resultSet.getString("date");
                int numberOfDays = resultSet.getInt("nbreJours");

       
                Reservation reservation = new Reservation(clientId, roomNumber, date, numberOfDays);
                resultList.add(reservation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultList;
    }

    public List<Reservation> getReservationsByDate(String date) throws SQLException, ClassNotFoundException {
        List<Reservation> resultList = new ArrayList<>();

        String sql = "SELECT * FROM reservations WHERE date = ?";
        try {
       
            Class.forName("com.mysql.cj.jdbc.Driver");

      
            Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, date);

            ResultSet resultSet = preparedStatement.executeQuery();

         
            while (resultSet.next()) {
                int clientId = resultSet.getInt("client_id");
                int roomNumber = resultSet.getInt("room_number");
                int numberOfDays = resultSet.getInt("number_of_days");

                
                Reservation reservation = new Reservation(clientId, roomNumber, date, numberOfDays);
                resultList.add(reservation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultList;
    }

    public List<Reservation> getAllReservations() throws SQLException, ClassNotFoundException {
        List<Reservation> resultList = new ArrayList<>();

        String sql = "SELECT * FROM reservations";
        try {
          
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);


            Statement statement = connection.createStatement();

      
            ResultSet resultSet = statement.executeQuery(sql);


            while (resultSet.next()) {
                int clientId = resultSet.getInt("client_id");
                int roomNumber = resultSet.getInt("room_number");
                String date = resultSet.getString("date");
                int numberOfDays = resultSet.getInt("number_of_days");

             
                Reservation reservation = new Reservation(clientId, roomNumber, date, numberOfDays);
                resultList.add(reservation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultList;
    }

    public void deleteReservation(int clientId, int roomNumber, String date) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM reservations WHERE client_id = ? AND room_number = ? AND date = ?";
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

         
            Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, clientId);
            preparedStatement.setInt(2, roomNumber);
            preparedStatement.setString(3, date);

            preparedStatement.executeUpdate();

            System.out.println("Reservation deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

package utility;

import javax.servlet.ServletException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConnectDB {
    Connection connect = null;
    Statement statement = null;
    PreparedStatement ps = null;
    private ResultSet resultSet = null;
    List<String> list = new ArrayList<String>();

    public static Properties loadProperties() throws IOException {
        Properties prop = new Properties();
        InputStream ism = new FileInputStream("C:\\Users\\Md Bhuiyan\\IdeaProjects\\shakhaowat\\Base\\lib\\MySql.properties");
        prop.load(ism);
        ism.close();
        return prop;
    }

    public void connectToDatabase() throws IOException, SQLException, ClassNotFoundException {
        Properties prop = loadProperties();
        String driverClass = prop.getProperty("MYSQLJDBC.driver");
        String url = prop.getProperty("MYSQLJDBC.url");
        String userName = prop.getProperty("MYSQLJDBC.userName");
        String password = prop.getProperty("MYSQLJDBC.password");
        Class.forName(driverClass);
        connect = DriverManager.getConnection(url, userName, password);
        System.out.println("Database is connected");
    }

    public List<String> readDataBase(String tableName, String columnName) throws IOException, ClassNotFoundException, SQLException {
        {
            List<String> data = new ArrayList<String>();
            try {
                connectToDatabase();
                statement = connect.createStatement();
                resultSet = statement.executeQuery("select * from " + tableName);
                data = getResultSetData(resultSet, columnName);
            } catch (ClassNotFoundException e) {
                throw e;
            } finally {
                close();
            }
            return data;
        }
        public List<String> readDataBase () {

            connectToDatabase();
            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement
                    .executeQuery("select * from logininfo");
            list = getResultSetData(resultSet);
            close();
            return list;
        }
        private void close () {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connect != null) {
                    connect.close();
                }
            } catch (Exception e) {

            }
        }

        private List<String> getResultSetData (ResultSet resultSet) throws SQLException {
            List<String> dataList = new ArrayList<String>();
            while (resultSet.next()) {
                String itemName = resultSet.getString("item_name");
                dataList.add(itemName);
            }
            return dataList;
        }
        private List<String> getResultSetData (ResultSet resultSet2, String columnName) throws SQLException {
            List<String> dataList = new ArrayList<String>();
            while (resultSet.next()) {
                String itemName = resultSet.getString(columnName);
                dataList.add(itemName);
            }
            return dataList;
        }
        // function  for Data insert into MySQL Database
        public void InsertDataFromArryToMySql ( int[] ArrayData, String tableName, String columnName)
        //InsertDataFromArryListToMySql

        //  public void InsertDataFromArryToMySql()
        {
            try {
                connectToDatabase();

                //  connect.createStatement("INSERT into tbl_insertionSort set SortingNumbers=1000");

                for (int n = 0; n < ArrayData.length; n++) {

                    ps = connect.prepareStatement("INSERT INTO " + tableName + " ( " + columnName + " ) VALUES(?)");
                    ps.setInt(1, ArrayData[n]);
                    ps.executeUpdate();
                    //System.out.println(list[n]);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            //connection = ConnectionConfiguration.getConnection();
        }

        // Function for Insert Single value in a table
        public void InsertDataFromStringToMySql (String ArrayData, String tableName, String columnName)
        //  public void InsertDataFromArryToMySql()
        {
            try {
                connectToDatabase();
                //  connect.createStatement("INSERT into tbl_insertionSort set SortingNumbers=1000");
                ps = connect.prepareStatement("INSERT INTO " + tableName + " ( " + columnName + " ) VALUES(?)");
                ps.setString(1, ArrayData);
                ps.executeUpdate();
                //System.out.println(list[n]);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            //connection = ConnectionConfiguration.getConnection();
        }
        public List<String> directDatabaseQueryExecute (String passQuery, String dataColumn)throws Exception {
            List<String> data = new ArrayList<String>();
            try {
                connectToDatabase();
                statement = connect.createStatement();
                resultSet = statement.executeQuery(passQuery);
                data = getResultSetData(resultSet, dataColumn);
            } catch (ClassNotFoundException e) {
                throw e;
            } finally {
                close();
            }
            return data;
        }

        public void InsertDataFromArryListToMySql (List < Object > list, String tableName, String columnName)
        //InsertDataFromArryListToMySql
        //  public void InsertDataFromArryToMySql()
        {
            try {
                connectToDatabase();
                //  connect.createStatement("INSERT into tbl_insertionSort set SortingNumbers=1000");
                for (Object st : list) {
                    // System.out.println(st);

                    ps = connect.prepareStatement("INSERT INTO " + tableName + " ( " + columnName + " ) VALUES(?)");
                    ps.setObject(1, st);
                    ps.executeUpdate();
                    //System.out.println(list[n]);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            // connection = ConnectionConfiguration.getConnection();
        }

    }
}
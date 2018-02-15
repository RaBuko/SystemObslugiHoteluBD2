package dbconnector;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnector
{
    private final static Logger LOGGER = Logger.getLogger(DatabaseConnector.class.getName());
    private Connection mysqlConnection;

    private String userDB = "administrator";
    private String passwordDB = "admin";
    private String databaseName = "SystemObslugiHotelu";
    private String schemaName = "hotel";
    private String serverName = "localhost";
    private String portNumber = "3306";
    private String databaseConnectionURL;

    boolean execSqlNonQuery(String sqlCommand)
    {
        connectToDatabase();
        try {
            Statement stmt = mysqlConnection.createStatement();
            stmt.execute(sqlCommand);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            LOGGER.log(Level.WARNING,"Operacja nie udana");
            disconnectFromDatabase();
            return false;
        }
        disconnectFromDatabase();
        return true;
    }

    // Zwraca rezultat komendy query (SELECT) do stringa lub ERROR gdy błąd
    // Kolumny sa rozdzielone '|', rzędy znakami nowej linii
    String execSqlQuery(String sqlCommand)
    {
        connectToDatabase();
        StringBuilder stringBuilder = new StringBuilder();
        try
        {
            Statement stmt = mysqlConnection.createStatement();
            ResultSet resultSet = stmt.executeQuery(sqlCommand);
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (resultSet.next())
            {
                for (int i = 1; i <= columnsNumber; i++)
                {
                    stringBuilder.append(resultSet.getString(i));
                    stringBuilder.append(";");
                }
                stringBuilder.append("\n");
            }
            disconnectFromDatabase();
            return stringBuilder.toString();
        } catch (SQLException e)
        {
            e.printStackTrace();
            LOGGER.log(Level.WARNING,"Operacja nie udana");
            disconnectFromDatabase();
            return null;
        }
    }

    DatabaseConnector(boolean isAdmin)
    {
        if (!isAdmin)
        {
            this.userDB = "hotelarz";
            this.passwordDB = "hotel";
        }

        setDatabaseConnectionURL();
        if (!connectToDatabase()) LOGGER.log(Level.WARNING, "Nie udalo sie polaczyc z baza");
        else
        {
            if (!disconnectFromDatabase()) LOGGER.log(Level.WARNING, "Nie udalo sie rozlaczyc z baza");
        }
    }
    
    // Ustanawia połączenie z bazą za pomocą określonego ConnectionStringa
    // false - nie udało się połączyć z bazą, true - udało się połączyć z bazą
    boolean connectToDatabase()
    {
        try {
            mysqlConnection = DriverManager.getConnection(databaseConnectionURL, userDB,passwordDB);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    // Rozłącza połączenie z bazą
    // false - nie udało się rozłączyć z bazą, true - udało się rozłączyć z bazą
    public boolean disconnectFromDatabase()
    {
        try {
            mysqlConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void setDatabaseConnectionURL()
    {
        this.databaseConnectionURL = "jdbc:mysql://" + this.serverName + ":" + portNumber + "/" + this.schemaName;
    }

    public void setUserDB (String userDB) {this.userDB = userDB;}
    public void setPasswordDB (String passwordDB) {this.passwordDB = passwordDB;}
    public String getUserDB() {return this.userDB;}
    public String getPasswordDB() {return this.passwordDB;}
}

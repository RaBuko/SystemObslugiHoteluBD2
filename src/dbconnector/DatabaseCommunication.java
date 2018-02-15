package dbconnector;

import dbObjects.Klient;

public class DatabaseCommunication
{
    public DatabaseConnector dbConnector;

    public int workerID = -1;
    public String workersEmail = "";
    public String workersImie = "";
    public String workersNazwisko = "";
    public DatabaseCommunication(boolean isAdmin)
    {
        dbConnector = new DatabaseConnector(isAdmin);
    }

    public void setWorkerData(int ID, String imie, String nazwisko, String email)
    {
        this.workerID = ID;
        this.workersEmail = email;
        this.workersImie = imie;
        this.workersNazwisko = nazwisko;
    }

    public String [] getWorkerData()
    {
        return new String[]{Integer.toString(this.workerID), workersImie, workersNazwisko, workersEmail};
    }

    // Szybkie komendy na bazie : query - selecty, widoki ; nonquery - reszta
    String execQuickQuery(String sql) {return dbConnector.execSqlQuery(sql);}
    boolean execQuickNonQuery(String sql) {return dbConnector.execSqlNonQuery(sql);}

    public String selectAllClients()
    {
        String sql = "SELECT * FROM klient";
        return dbConnector.execSqlQuery(sql);
    }

    String selectAllWorkers()
    {
        String sql = "SELECT * FROM hotelarz";
        return dbConnector.execSqlQuery(sql);
    }

    String selectAdmin()
    {
        String sql = "SELECT * FROM administrator";
        return dbConnector.execSqlQuery(sql);
    }

    public void insertClient(String [] arguments)
    {
        String command = "INSERT INTO klient (" +
                "HotelarzID," +
                "imie," +
                "nazwisko," +
                "numer_telefonu," +
                "`e-mail`," +
                "rodzaj_dokumentu," +
                "numer_dokumentu," +
                "jezyk) " +
                "VALUES ("
                //+ arguments[0] + ", "    //id //AUTOINCREMENT
                + arguments[0] + ", '"   //hotelarzID
                + arguments[1] + "', '"  //imie
                + arguments[2] + "', "   //nazwisko
                + arguments[3] + ", '"   //numerTelefonu
                + arguments[4] + "', '"  //email
                + arguments[5] + "', '"  //rodzajDokumentu
                + arguments[6] + "', '"  //numerDokumentu
                + arguments[7] + "');";  //jezyk

        System.out.println(command);
        dbConnector.execSqlNonQuery(command);
    }

    // 0 - nie udalo sie zalogowac, 1 - udalo sie zalogowac jako hotelarz, 2 - udalo sie zalogowac jako admin
    public int checkLogin(String login, String password)
    {
        String result = selectAdmin();
        String [] rows = result.split(";");
        if (rows[0].equals(login) && rows[1].equals(password)) {
            this.workersEmail = login;
            return 2;
        }
        else
        {
            result = selectAllWorkers();
            rows = result.split("\n");

            for (String row: rows)
            {
                String [] elems = row.split(";");
                if (elems[1].equals(login) && elems[2].equals(password))
                {
                    this.workerID = Integer.parseInt(elems[0]);
                    this.workersEmail = elems[1];
                    this.workersImie = elems[3];
                    this.workersNazwisko = elems[4];
                    return 1;
                }
            }
        }
        return 0;
    }

    public void deleteClient(Klient klient)
    {
        int klientID = klient.getID();
        String command = "DELETE FROM klient WHERE ID = " + klientID + ";";
        dbConnector.execSqlNonQuery(command);
        System.out.println(command);
    }

    public void updateClient(String [] arguments)
    {
        String command = "UPDATE klient SET " +
            "imie = '" + arguments[1] + "', " +
            "nazwisko = '" + arguments[2] + "', " +
            "numer_telefonu = "  + arguments[3] + ", " +
            "`e-mail` = '" + arguments[4] + "', " +
            "rodzaj_dokumentu = '" + arguments[5] + "', " +
            "numer_dokumentu = '" + arguments[6] + "', " +
            "jezyk = '" + arguments[7] + "' " +
                "WHERE ID = " + arguments[0];

        System.out.println(command);
        dbConnector.execSqlNonQuery(command);
    }
}

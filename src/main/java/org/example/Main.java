package org.example;

import DB.CRUDUtils;
import DB.DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.function.Consumer;

public class Main
{

    public static void main(String[] args)
    {
        String myQuery="select * from players where goals>300";
        List<Player>players=CRUDUtils.readSpecialPlayersData(myQuery);
        players.forEach(System.out::println);
    }
}
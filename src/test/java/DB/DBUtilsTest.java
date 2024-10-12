package DB;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DBUtilsTest
{
    @Mock
    Connection mockConnection;

    @InjectMocks
    Connection actualConnection;

    @Test
    void getConnectionTest() throws SQLException
    {
        Mockito.when(DriverManager.getConnection("jdbc:postgresql://localhost:5432/football", "postgres", "1234")).thenReturn(mockConnection);
        actualConnection = DBUtils.getConnection();
        Assertions.assertNotNull(actualConnection);

//        Connection mockConnection = Mockito.mock(Connection.class);
//        Mockito.when(DriverManager.getConnection("jdbc:postgresql://localhost:5432/football", "postgres", "1234")).thenReturn(mockConnection);
//        Connection actualConnection=DBUtils.getConnection();
//        Assertions.assertNotNull(actualConnection);
    }
}
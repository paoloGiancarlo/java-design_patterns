package DAOdal;

import DAOEntity.Author;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorDALImp implements AuthorDAL {
        private static final String ADDRESS = "jdbc:mysql://localhost:3306/books";
	private static final String USER = "cst8288";
	private static final String PASS = "8288";
        private static final String SQL_GETALL = "select * from books.authors";
        private static final String SQL_GET_WITH_ID = "select * from books.authors where AuthorID=?";
        private static final String SQL_INSERT = "INSERT INTO books.authors (FirstName , LastName) VALUES (?, ?);";

  
    public List<Author> getAll() {

        List<Author> list = new ArrayList<>();
	try(Connection con = DriverManager.getConnection(ADDRESS, USER, PASS);
            PreparedStatement statement = con.prepareStatement(SQL_GETALL);
            ResultSet result = statement.executeQuery()){
                                                    

            while( result.next()){
                list.add( new Author(
                        result.getInt("AuthorID"),
                        result.getString("FirstName"),
                        result.getString("LastName"))); 
            }
        }catch (SQLException e) {
			e.printStackTrace();
	}
        return list;           
    }

    @Override
    public Author getWithID(int id) {
        Author a = null;
	try(Connection con = DriverManager.getConnection(ADDRESS, USER, PASS);
            PreparedStatement statement = con.prepareStatement(SQL_GET_WITH_ID)){
            statement.setInt(1, id);
        
            try(ResultSet result = statement.executeQuery()){
                                                    

            while( result.next()){
            a = new Author(
                        result.getInt("AuthorID"),
                        result.getString("FirstName"),
                        result.getString("LastName")); 
            }
            }
        }catch (SQLException e) {
			e.printStackTrace();
	}
        return a;         
    
    }

    @Override
    public Boolean add(Author a) {
        
	try(Connection con = DriverManager.getConnection(ADDRESS, USER, PASS);
            PreparedStatement statement = con.prepareStatement(SQL_INSERT)){
            statement.setString(1, a.getFn());
            statement.setString(2, a.getLn());
            return statement.executeUpdate()>=1;
          
        }catch (SQLException e) {
			e.printStackTrace();
	}
        return false;   
    }
}

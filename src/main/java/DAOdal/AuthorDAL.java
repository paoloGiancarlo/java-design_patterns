package DAOdal;

import DAOEntity.Author;
import java.util.List;

public interface AuthorDAL {
    List<Author> getAll();
    Author getWithID(int id);
    Boolean add(Author a);

    
}

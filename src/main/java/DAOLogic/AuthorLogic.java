package DAOLogic;

import DAOdal.AuthorDAL;
import DAOdal.AuthorDALImp;
import DAOEntity.Author;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.IntConsumer;
import java.util.function.ObjIntConsumer;

public class AuthorLogic {
    private AuthorDAL dal;
    
    public AuthorLogic(){
        dal = new AuthorDALImp();
    }
    
    public List<Author> getAll(){
        return dal.getAll();
    }
    
    public Author getWithID(int id){
        return dal.getWithID(id);
    }
    
    public Boolean add(Author a){
        return dal.add(a);
    }
    
    public Author createEntity(String fn, String ln){
        ObjIntConsumer<String> validator = (value, lenght)->{
            if(value==null || value.trim().isEmpty() || value.length()>lenght){
            throw new IllegalArgumentException("wrong first name");
            }
        };
        
        validator.accept(fn, 30);
        validator.accept(ln, 30);
                   
        return new Author(fn, ln);
    }
    
}

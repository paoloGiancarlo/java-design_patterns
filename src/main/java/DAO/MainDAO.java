
package DAO;

import DAOLogic.AuthorLogic;

public class MainDAO {
   public static void main(String[] args){
       
       AuthorLogic logic = new AuthorLogic();
       
       logic.getAll().forEach(System.out::println);
       
       System.out.println("**********************************");
       System.out.println(logic.getWithID(1));
       
       System.out.println("**********************************");
       logic.add(logic.createEntity("Giancarlo", "Ignacio"));
       logic.getAll().forEach(System.out::println);
    }
}
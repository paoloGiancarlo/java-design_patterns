package DAOEntity;
    
public class Author{
        private int id;
        private String fn, ln;
        
        public Author(){
            
        }
        public Author(int id, String fn, String ln){
            this.id = id;
            this.fn = fn;
            this.ln = ln;
        }

    public Author(String fn, String ln) {
        this(-1,fn, ln);
    }

        public int getId() { return id; }

        public void setId(int id) { this.id = id; }

        public String getFn() { return fn; }

        public void setFn(String fn) { this.fn = fn; }

        public String getLn() { return ln; }

        public void setLn(String ln) { this.ln = ln; }

        @Override
        public String toString() {
            return "Author{" + "id=" + id + ", fn=" + fn + ", ln=" + ln + '}';
        }
}
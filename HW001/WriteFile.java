package HW001;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class WriteFile {
    private Db db;

    public Db getDb() {
        return db;
    }
    public WriteFile  (Db db){
        this.db = db;
    }
    public void writeF() throws FileNotFoundException, UnsupportedEncodingException {
        File file = new File("staff.txt");
        try (PrintWriter pw = new PrintWriter(file)) {
            for (Employee employee : db.employees){
                pw.println(employee.id);
            }
        }
        
    }
}

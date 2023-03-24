package Toys_shop;

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
        File file = new File("toys.txt");
        try (PrintWriter pw = new PrintWriter(file)) {
            for (Toy toy : db.toys){
                pw.println(db.getAllInfo(toy));
            }
        }
        
    }
    public void writeFLottery() throws FileNotFoundException, UnsupportedEncodingException {
        File file = new File("toys_won.txt");
        try (PrintWriter pw2 = new PrintWriter(file)) {
            for (Toy wintoy : db.winToys){
                pw2.println(db.getMinInfo(wintoy));
            }
        }
        
    }

}
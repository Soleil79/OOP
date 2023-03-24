package Toys_shop;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class ChangeData {

    private Db db;
    WriteFile writeFile = new WriteFile(db);

    public ChangeData(Db db, WriteFile writeFile) {
        this.db = db;
        this.writeFile = writeFile;

    }

    public void nameChange(int id, String newName) throws IOException {
        for (Toy toy : db.toys) {
            if (toy.id == id) {
                toy.name = newName;

            }
            writeFile.writeF();
        }
    }

    public void ageChange(int id, int newAge) throws FileNotFoundException, UnsupportedEncodingException {

        for (Toy toy : db.toys) {
            if (toy.id == id) {
                toy.age = newAge;
            }

            writeFile.writeF();
        }
    }

    public void dropRateChange(int id, int newDropRate) throws FileNotFoundException, UnsupportedEncodingException {
        for (Toy toy : db.toys) {
            if (toy.id == id) {
                toy.droprate = newDropRate;
            }
            writeFile.writeF();
        }
    }

   

}

package Toys_shop;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class StaffController {
    private Db db;
    private WriteFile writeF;
    ChangeData changeData = new ChangeData(db, writeF);

    public Db getDb() {
        return db;
    }

    public StaffController(Db db, WriteFile writeF, ChangeData changeData) {
        this.db = db;
        this.writeF = writeF;
        this.changeData = changeData;
    }

    public String getInfo(Toy toy) {
        return db.getAllInfo(toy);
    }

    public String getMinInfo(Toy toy) {
        return db.getMinInfo(toy);
    }

    public List<Toy> findAll(String word) {
        List<Toy> foundToys = new ArrayList<>();
        for (Toy toy : db.toys) {
            if (toy.name.toLowerCase().indexOf(word.toLowerCase()) != -1) {
                foundToys.add(toy);
            }
        }
        return foundToys;
    }

    public int lastIndex() {
        int maxId = 0;
        for (Toy toy : db.toys) {
            if (toy.id > maxId) {
                maxId = toy.id;
            }
        }
        return maxId;
    }

    public void addToy(Toy toy) throws FileNotFoundException, UnsupportedEncodingException {
        int newid = lastIndex() + 1;
        toy.setId(newid);
        db.toys.add(toy);
        writeF.writeF();
    }

    public void deleteToy(int id) throws FileNotFoundException, UnsupportedEncodingException {
        Toy foundToy = ResetToy(id);
        db.toys.remove(foundToy);
        writeF.writeF();
    }

    // Обнуление игрушки перед удалением
    public Toy ResetToy(int id) {
        for (Toy toy : db.toys) {
            if (toy.id == id) {
                return toy;
            }
        }
        return null;
    }

    public Toy ResetWinToy(int id) {
        for (Toy toy : db.winToys) {
            if (toy.id == id) {
                return toy;
            }
        }
        return null;
    }

    public void dataChange(int choice, int id, int data) throws FileNotFoundException, UnsupportedEncodingException {

        if (choice == 2) {
            changeData.ageChange(id, data);
        }
        if (choice == 3) {
            changeData.dropRateChange(id, data);
        }

    }

    public void stringChange(int choice, int id, String data) throws IOException {
        if (choice == 1) {
            changeData.nameChange(id, data);
        }
    }

    public List<Toy> getAllToys() {
        return db.toys;
    }

    public List<Toy> ReadPrize() {
        return db.winToys;
    }

        
    


    public void lottery(int choiceId) throws FileNotFoundException, UnsupportedEncodingException {
        for (Toy toy : db.toys) {
            if (toy.id == choiceId) {
                int randInt = (int) (Math.random() * (100 + 1));
                if ((int) toy.droprate >= randInt) {
                    db.winToys.add(toy);
                    System.out.printf("Поздравляем, Вы выиграли приз: %s", toy.name);
                    writeF.writeFLottery();
                } else {
                    System.out.println("К сожалению Вам не удалось выиграть приз в этот раз");
                }
            }
        }

    }

    public void getPrize(int winId) throws FileNotFoundException, UnsupportedEncodingException {
        Toy foundToy = ResetWinToy(winId);
        db.winToys.remove(foundToy);
        writeF.writeFLottery();
        System.out.println("Поздравляем, вы можете забрать свой приз!");
        for (Toy toy : db.toys) {
            if (toy.id == winId) {
                toy.quantity -= 1;
                writeF.writeF();
            }
        }

    }

}

// alt shift f - автоформат
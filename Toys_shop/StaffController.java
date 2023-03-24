package Toys_shop;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
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

    public List<Toy> findAll(String word) {
        List<Toy> foundToys = new ArrayList<>();
        for ( Toy toy : db.toys) {
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
        for (Toy toy: db.toys) {
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



	public List<Toy> lottery(int choiceId) throws FileNotFoundException, UnsupportedEncodingException{
        List<Toy> winToys = new ArrayList<>();
        for ( Toy toy : db.toys) {
            if (toy.id == choiceId) {
                int randInt = (int) (Math.random()*(100+1));
                if ((int) toy.droprate >= randInt){
                    db.winToys.add(toy); 
                    System.out.printf("Поздравляем, Вы выиграли приз: %s", toy.name);
                    File file = new File("toys_won.txt");
                    try (PrintWriter pw2 = new PrintWriter(file)) {
                        pw2.println(db.getMinInfo(toy));      
                    }                  
                }
                else {
                    System.out.println("К сожалению Вам не удалось выиграть приз в этот раз");
                }
            }
                               
        }        
        return winToys; // Список выигранных игрушек
		
		
		
	}

}

// alt shift f - автоформат
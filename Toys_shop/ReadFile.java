package Toys_shop;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    Db db = new Db();

    public List<String> readAllLines() throws IOException {
        List<String> lines = new ArrayList<>();
        // try {
        File file = new File("toys.txt");
        // создаем объект FileReader для объекта File
        FileReader fr = new FileReader(file);
        // создаем BufferedReader с существующего FileReader для построчного считывания
        BufferedReader reader = new BufferedReader(fr);
        // считаем сначала первую строку
        String line = reader.readLine();
        if (line != null) {
            lines.add(line);
        }
        while (line != null) {
            // считываем остальные строки в цикле
            line = reader.readLine();
            if (line != null) {
                lines.add(line);
            }
        }
        fr.close();
        return lines;

    }

    public Toy map(String line) {

        String[] lines = line.split(", |: |:");

        int id = Integer.parseInt(lines[1]);
        String name = lines[3];
        int age = AgeGetId(lines[5]);
        int droprate = Integer.parseInt(lines[7]);
        int quantity = Integer.parseInt(lines[9]);
        
        Toy newToy = new Toy(id, name, age, droprate, quantity);

        return newToy;

    }

    public ArrayList<Toy> readList(List<String> list) {
        ArrayList<Toy> toys = new ArrayList<>();
        for (String line : list) {
            Toy toy = map(line);
            toys.add(toy);
        }

        return toys;
    }

    public int AgeGetId(String word) {        
        int newage = 0;
        for (Age ag : db.ages)
            if (ag.age.contains(word)) {
                newage = ag.id;
            }
        return newage;
    }

}
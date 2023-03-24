package Toys_shop;

import java.io.IOException;
import java.util.List;

public class Program {
    public static void main(String[] args) throws IOException {
        Db db = new Db();
        WriteFile writeFile = new WriteFile(db);
        ChangeData changeData = new ChangeData(db, writeFile);
        StaffController staffController = new StaffController(db, writeFile, changeData);
        View view = new View(staffController);

        ReadFile ReadFile = new ReadFile();
        String path = "toys.txt";
        List<String> list = ReadFile.readAllLines(path);
        db.toys = ReadFile.readList(list);

        ReadFile ReadFileWin = new ReadFile();
        String pathwin = "toys_won.txt";
        List<String> winlist = ReadFile.readAllLines(pathwin);
        db.winToys = ReadFileWin.readWinList(winlist);

        view.choices();
        
        view.intScanClose();
        view.strScanClose();
    }
}

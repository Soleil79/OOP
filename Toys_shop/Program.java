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
        List<String> list = ReadFile.readAllLines();
        db.toys = ReadFile.readList(list);

        view.choices();
        
        view.intScanClose();
        view.strScanClose();
    }
}

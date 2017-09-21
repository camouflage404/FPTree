package fptree;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/*********************
 * Sep 17, 2017         
 * 7:21:34 PM          
 * @author HOSNEARA    
 *********************/
public class FPTree {
    public static void main(String[] args) throws FileNotFoundException {
        FileReader fp =new FileReader("input.txt");
        Scanner sc = new Scanner(fp);
        String str;
        
        Database db = new Database();
        Transaction ts;
        
        while(sc.hasNextLine())
        {
            str = sc.nextLine();
            ts = new Transaction(str);
            db.getData(ts.getItems());
            
        }
        db.Print();
    }

}

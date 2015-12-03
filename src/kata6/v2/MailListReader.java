
package kata6.v2;

import kata6.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;



public class MailListReader {
    public static ArrayList read(String nameFile) throws FileNotFoundException, IOException{
        ArrayList<Person> mailList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(nameFile));
        String mail;
        Integer id = 0;
        while((mail=reader.readLine())!=null){
            if(!mail.contains("@")) continue;
            
            mailList.add(new Person(id++,mail));
        }
                
                
        return mailList;
        
    }
}

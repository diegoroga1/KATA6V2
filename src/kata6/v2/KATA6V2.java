package kata6.v2;

import kata6.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class KATA6V2 {
    
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        String name = "DATA\\emailsfilev1.txt";
        ArrayList<Person> arrayMail = MailListReader.read(name);
        ArrayList<Person1> person = PersonLoader.read();
        
        
        HistogramBuilder<Person>  builder = new HistogramBuilder<>(arrayMail);
        HistogramBuilder<Person1>  builder1 = new HistogramBuilder<>(person);
        //Histogramas fichero
        Histogram<String> domains=builder.build(new Attribute<Person,String>(){
            @Override
            public String get(Person item){
                return (item.getMail().split("@")[1]);
            }
        });
        Histogram<Character> letters = builder.build(new Attribute<Person,Character>(){
            public Character get(Person item){
                return item.getMail().charAt(0);
            }
        });   
        //Histogramas BD
        Histogram<String> domains1 = builder1.build(new Attribute<Person1, String>() {

            @Override
            public String get(Person1 item) {
                return item.getMail().split("@")[1];
            }
        });
        Histogram<Float> peso= builder1.build(new Attribute<Person1, Float>() {

            @Override
            public Float get(Person1 item) {
                return item.getPeso();
            }
        });
        Histogram<Character> genero = builder1.build(new Attribute<Person1, Character>() {

            @Override
            public Character get(Person1 item) {
                return item.getGenero().charAt(0);
            }
        });
        //Mostrar histogramas
        new HistogramDisplay(domains,"Dominios").execute();
        new HistogramDisplay(letters,"Caracter").execute();
        new HistogramDisplay(domains1,"Dominios").execute();
        new HistogramDisplay(peso,"Pesos").execute();
        new HistogramDisplay(genero,"Generos").execute();
        
    }
}

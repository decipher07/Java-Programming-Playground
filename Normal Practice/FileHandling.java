// import java.util.*;
import java.io.*;

class Student implements Serializable {
    int id;
    String name;

    public Student ( int id, String name ){
        this.id = id;
        this.name = name;
    }
}

class Person extends Student {
    String course ;

    public Person ( int id, String name, String course ){
        super(id, name);
        this.course = course;
    }
}



public class FileHandling {
    public static void main(String[] args) {
        // File file = new File("new.txt");
        // char[] array = new char[100];

        // byte[] array = new byte[100];
        try {

            // File newFile = new File ("checking.txt");
            // FileInputStream fs = new FileInputStream(newFile);
            // ObjectInputStream in = new ObjectInputStream(fs);

            // Person p = (Person) in.readObject();
            // System.out.println("Name: " + p.name + " Id: " + p.id + " Course : " + p.course );

            // in.close();

            // Person p1 = new Person(101, "Hardik", "Student");
            // File newfile = new File ("checking.txt");

            // FileOutputStream fs = new FileOutputStream(newfile);
            // ObjectOutputStream out = new ObjectOutputStream(fs);

            // out.writeObject(p1);
            // out.flush();
            // out.close();

            // Student s1 = new Student(101, "ALJDLKAJ");
            // File newfile = new File("checking.txt");

            // FileInputStream ins = new FileInputStream(newfile);
            // ObjectInputStream in = new ObjectInputStream (ins);

            // Student s = ( Student ) in.readObject();

            // System.out.println("Name : " + s.id + " " + s.name );

            // in.close();

            // FileOutputStream os = new FileOutputStream(newfile);
            // ObjectOutputStream out = new ObjectOutputStream(os);

            // out.writeObject(s1);
            // out.flush();
            // out.close();


            // Writer out = new FileWriter("checking.txt");
            // String msg = "AHELAJ";

            // out.write(msg);

            // out.close();
            // Reader in = new FileReader("input.txt");

            // // char ch = (char) in.read();

            // int content = 0;

            // while ( ( content = in.read()) != -1 )
            //     System.out.print((char) content);

            // // while ( in.read() != -1 )
            // //     System.out.print((char) in.read());

            // in.close();
            // while (ch != '\0')
            // {
                // System.out.println(ch);
                // ch = (char) in.read();
            // }

            // InputStreamReader isr = new InputStreamReader(System.in);
            // BufferedReader in = new BufferedReader(isr);

            // String name = "";

            // System.out.println("Please enter your name");

            // name = in.readLine();

            // System.out.println(name);

            // byte content[] = "HELLO WORLD".getBytes();

            // ByteArrayInputStream inputStream = new ByteArrayInputStream(content);
            // inputStream.read(content);

            // File newfile = new File("checking.txt");
            // FileOutputStream os = new FileOutputStream(newfile);
            // os.write(content);
            // os.close();
            // inputStream.close();
            // inputStream.close();

            // InputStream obj1 = new FileInputStream("input.txt");

            // System.out.println(obj1.available());

            // obj1.read(array);

            // String res = new String(array);
            // System.out.println(res);

            // obj1.close();
            // File folder = new File("/path/to/files");
            // File[] listOfFiles = folder.listFiles();

            // for (int i = 0; i < listOfFiles.length; i++) {
            // File file = listOfFiles[i];
            // System.out.println(file);
            //     if (file.isFile() && file.getName().endsWith(".txt")) {
            //         // String content = FileUtils.readFileToString(file);
            //         /* do somthing with content */
            //     } 
            // }
            // if(!file.createNewFile())
            //     System.exit(-1);

            // File newFile = new File ( "renamedtxt.txt");

            // if (file.renameTo(newFile))
            //     System.out.println("HELO");
            // FileReader input = new FileReader("input.txt");
            // input.read(array);
            // System.out.println(array);
            // input.close();
            // boolean value = file.createNewFile();
            // boolean value = file.delete();
            // if (value) {
            // System.out.println("The new file is created.");
            // }
            // else {
            // System.out.println("The file already exists."); } 
        } catch ( Exception e ) {
            e.getStackTrace();
        }
    }
}

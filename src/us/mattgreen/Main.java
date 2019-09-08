package us.mattgreen;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private final FileOutput outFile = new FileOutput("animals.txt");
    private final FileInput inFile = new FileInput("animals.txt");

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        ArrayList<Talkable> zoo = new ArrayList<>();

        // Lines to Replace
        zoo.add(new Dog(true, "Pete"));
        zoo.add(new Cat(9, "Anne Belly"));
        zoo.add(new Student(19, "Joe John Johnson"));
        // Default Animals, as left in the program in class.

        Scanner kb = new Scanner(System.in);
        String name = "";
        String input;
        int age;
        int mice;
        int iterations = 0;
        Boolean friendly;
        // Initialization of fields which will characterize objects/entries into the array
        boolean Loop = true;
        // Control variable to indicate whether the sentinel value has been entered
        do{

            System.out.println("Please Enter Name of Pet: (Enter NA to stop adding)");
            name = kb.nextLine();

            if(name.equals("NA"))
                Loop = false;
                // bypasses further inquiries if sentinel value has been entered
            else{
                System.out.println("Is this a (S)tudent, (C)at, or (D)og?");
                input = kb.nextLine();
                // indicates pet type, admittedly, in hindsight this would be better as a switch statement
                if(input.charAt(0)=='s'|| input.charAt(0)=='S')
                {
                    System.out.println("What is the Student's Age?");
                    try {
                        age = Integer.parseInt(kb.nextLine());
                    }
                    catch(Exception e)
                    {
                        System.out.println("You Must Be 18");
                        age = 18;
                    }

                    zoo.add(new Student(age,name));
                }
                if(input.charAt(0)=='c'|| input.charAt(0)=='C')
                {
                    System.out.println("How many mice has the cat killed?");
                    try {
                        mice = Integer.parseInt(kb.nextLine());
                    }
                    catch(Exception e)
                    {
                        System.out.println("Mice killed defaulted to 0");
                        mice = 0;
                    }

                    zoo.add(new Cat(mice,name));
                }
                if(input.charAt(0)=='d'|| input.charAt(0)=='D')
                {
                    System.out.println("Is the Dog Friendly?");
                    input = kb.nextLine();

                    if(input.charAt(0)=='y'||input.charAt(0)=='Y')
                        friendly = true;
                    else
                        friendly = false;

                    zoo.add(new Dog(friendly,name));
                }
            }
        }while(Loop);
        // End Lines to Replace

        for (Talkable thing : zoo) {
            printOut(thing);
        }
        outFile.fileClose();

        System.out.println("\n*** Reading/printing entire file using fileRead method\n");

        inFile.fileRead();
        inFile.fileClose();

        System.out.println("\n*** Reading/printing one line at a time using fileReadLine method\n");

        FileInput indata = new FileInput("animals.txt");
        String line;
        while ((line = indata.fileReadLine()) != null) {
            System.out.println(line);
        }
    }

    public void printOut(Talkable p) {
        System.out.println(p.getName() + " says = " + p.talk());
        outFile.fileWrite(p.getName() + "|" + p.talk());
    }
}

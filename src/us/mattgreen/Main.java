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
        InputTypeVerifier Temp = new InputTypeVerifier();
        String name = "";
        String input;
        int age;
        int mice;
        Boolean friendly;
        char petType;
        Input enterText = new Input();
        // Initialization of fields which will characterize objects/entries into the array
        boolean Loop = true;
        boolean badInput = false;
        // Control variable to indicate whether the sentinel value has been entered
        do{
            System.out.println("Please Enter Name of Pet: (Enter NA to stop adding)");
            name = kb.nextLine();

            if(name.equals("NA"))
                Loop = false;
            else
            {
                do {
                    badInput = false;
                    try
                    {
                        petType = enterText.petSwitch("Is "+name+" a (S)tudent, (C)at, or (D)og?", 'S', 99);
                        InputTypeVerifier ITV = new InputTypeVerifier(petType, name);

                        switch (petType)
                        {
                            case 's':
                            case 'S':

                                zoo.add(new Student(ITV.getNum(), name));
                                break;

                            case 'c':
                            case 'C':
                                zoo.add(new Cat(ITV.getNum(), name));
                                break;

                            case 'd':
                            case 'D':
                                zoo.add(new Dog(ITV.isYesNo(), name));
                                break;
                        }
                    }
                    catch(Exception e)
                    {
                        badInput = true;
                    }
                }while (badInput);

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

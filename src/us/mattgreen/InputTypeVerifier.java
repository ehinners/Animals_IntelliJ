package us.mattgreen;

import java.util.Scanner;

public class InputTypeVerifier
{

    Scanner kb = new Scanner(System.in);
    char petType;
    int num;
    boolean yesNo;
    String input;

    public InputTypeVerifier()
    {

    }

    public InputTypeVerifier(char petType, String Name)
    {
        if(petType == 's' || petType == 'S')
        {
            try {
                System.out.println("What is the "+Name+"'s Age?");
                num = Integer.parseInt(kb.nextLine());
            }
            catch(Exception e)
            {
                throw new IllegalArgumentException("This is not an int");
            }
        }
        else if(petType == 'c'|| petType == 'C')
        {
            try {
                System.out.println("How many mice has "+Name+" killed?");
                num = Integer.parseInt(kb.nextLine());
            }
            catch(Exception e)
            {
                throw new IllegalArgumentException("This is not an int");
            }
        }

        else if(petType == 'd' || petType == 'D')
        {
            System.out.println("Is "+Name+" Friendly?(Y/N)");
            input = kb.nextLine();
            input.charAt(0);
            if(input.charAt(0) == 'y' || input.charAt(0) == 'Y')
            {
                yesNo = true;
            }
            else if(input.charAt(0) == 'n' || input.charAt(0) == 'N')
            {
                yesNo = false;
            }
            else
            {
                throw new IllegalArgumentException("This is not Yes or No");
            }
        }
        else
        {
            throw new IllegalArgumentException("This is not a valid pet type");
        }
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public boolean isYesNo() {
        return yesNo;
    }

    public void setYesNo(boolean yesNo) {
        this.yesNo = yesNo;
    }
}




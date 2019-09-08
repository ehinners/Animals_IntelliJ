package us.mattgreen;

import java.util.Scanner;

/*
    9/2/19
    Based On Original Code by Matt Green
    Student - Eric Hinners
    Additional Class for activity
    Verifies data type for user input
 */
public class Input
{
    Scanner kb = new Scanner(System.in);

    public Input()
    {

    }

    public Integer verifyInt(String prompt, int default_value, int max_attempts)
    {
        int verified = default_value;
        String input;
        boolean loop;
        int iterations = 0;

        do
        {
            loop = false;
            try {
                System.out.println(prompt);
                verified = Integer.parseInt(kb.nextLine());
            }
            catch(Exception e)
            {
                System.out.println("Invalid Int");
                loop = true;
            }
            iterations++;
        }while(loop || iterations > max_attempts);
        return verified;
    }

    public Double verifyDouble(String prompt, double default_value, int max_attempts)
    {
        double verified = default_value;
        String input;
        boolean loop;
        int iterations = 0;

        do
        {
            loop = false;
            try {
                System.out.println(prompt);
                verified = Double.parseDouble(kb.nextLine());
            }
            catch(Exception e)
            {
                System.out.println("Invalid Int");
                loop = true;
            }
            iterations++;
        }while(loop || iterations > max_attempts);
        return verified;
    }

    public Boolean verifyYesNo(String prompt, boolean default_value, int max_attempts)
    {
        String input;
        boolean loop;
        boolean T_Or_F = default_value;
        char YesNo;
        int iterations = 0;
        do{
            loop = false;
            System.out.println(prompt);
            input = kb.nextLine();
            YesNo = input.charAt(0);
            if(YesNo == 'y' || YesNo == 'Y')
            {
                T_Or_F = true;
            }
            else if(YesNo == 'n' || YesNo == 'N')
            {
                T_Or_F = false;
            }
            else
            {
                loop = true;
            }
            iterations++;
        }while(loop|| iterations > max_attempts);
        if(loop)
            T_Or_F = default_value;
        return T_Or_F;
    }

    public char petSwitch(String prompt, char default_value, int max_attempts)
    {
        char pet_type;
        boolean loop;
        int iterations = 0;
        String input;
        do{
            loop = false;
            System.out.println(prompt);
            input = kb.nextLine();


            pet_type = input.charAt(0);
            switch(pet_type)
            {
                case 'c':
                case 'C':
                    break;
                case 'd':
                case 'D':
                    break;
                case 's':
                case 'S':
                    break;

                default: loop = true;
                    break;
            }
            iterations++;
        }while(loop || iterations > max_attempts);
        if(loop)
            pet_type = default_value;
        return pet_type;
    }





}


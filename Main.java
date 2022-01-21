import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main{
    public static void main(String[] args){
        int number = GetInput.getIntFromUser("How many passwords do you want to generate?", false);
        while(number <= 1){
            number = GetInput.getIntFromUser("How many passwords do you want to generate?", false);
        }

        int length = GetInput.getIntFromUser("How many characters does the password have to be?", false);
        while(length <= 1){
            length = GetInput.getIntFromUser("How many characters does the password have to be?", false);
        }

        String keys[] = new String[length];
        String passwords[] = new String[length];
        if(number >= 1){
            for(int k=0; k<number; k++){
                String message = "[" + (k+1) + "] Enter password key/name: ";
                keys[k] = GetInput.getStrFromUser(message, false);
                passwords[k] = generatePassword(length);
            }
        }
        for(int k=0; k<number; k++){
            System.out.println("[" + (k+1) + "] " + keys[k] + ": " + passwords[k]);
        }
    }
    public static String generatePassword(int length){
        StringBuilder password = new StringBuilder();
        char passwordArray[] = new char[length];
        for(int k=0; k<length; k++){
            int rng = generateRandomNumber(0,10);
            String type;
            if(rng <= 3){
                type = "lower";
            } else if(rng <= 7) {
                type = "upper";
            } else {
                type = "number";
            }

            if(type.equals("lower")){
                rng = generateRandomNumber(97,122);
            } else if(type.equals("upper")){
                rng = generateRandomNumber(65,90);
            } else if(type.equals("number")){
                rng = generateRandomNumber(48,57);
            }

            passwordArray[k] = (char) rng;
        }
        char randSymb = randSymbol(generateRandomNumber(0,9));
        int randPos = generateRandomNumber(0,length-1);
        passwordArray[randPos] = randSymb;

        for(int k=0; k<length; k++){
            password.append(passwordArray[k]);
        }

        return password.toString();
    }

    public static char randSymbol(int kbPos){
        char sym;
        switch (kbPos){
            case 0:
                sym = '!';
                return sym;
            case 1:
                sym = '@';
                return sym;
            case 2:
                sym = '#';
                return sym;
            case 3:
                sym = '$';
                return sym;
            case 4:
                sym = '%';
                return sym;
            case 5:
                sym = '^';
                return sym;
            case 6:
                sym = '&';
                return sym;
            case 7:
                sym = '*';
                return sym;
            case 8:
                sym = '(';
                return sym;
            case 9:
                sym = ')';
                return sym;
            default:
                return '!';
        }
    }

    public static int generateRandomNumber(int minValue,int maxValue) {
        Random r = new Random();
        int randomValue = r.nextInt(maxValue-minValue) + minValue;
        return randomValue;
    }
}
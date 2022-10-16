// Big thanks to <a href="https://github.com/yeadonpg/CMSC-255/blob/master/src/Labs/Lab_8/Array.java" 
// Also big thanks to <a href="geeksforgeeks.org"

public class Array {
    public static void main(String[] args) {
        String[] tokens = args[0].split(",");
        String[] customerName = new String[8];
        
        // " #1 "
        displayNames(copyNames(customerName, tokens));
        
        // " #2 "
        shiftNames(customerName, 4 , 6);
        shiftNames(customerName, 5 , 7);
        displayNames(insertNames(customerName, "Rick", "Jessica"));

        // " #3 "
        displayNames(reverseNames(customerName));

        // " #4 "
        displayNames(reverseNames2(customerName));

        // " #5 "
        displayNames(removeNames(customerName));
        
    }

    public static void displayNames(String[] names) {
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println("");
    }

    // Starting from standard shift array code
    public static void shiftNames(String[] names, int start, int finish) {
        String temp = names[start];
        names[start] = names[finish];
        names[finish] = temp;
    }

    // changes the indexed variable at indexes 4 & 5
    public static String[] insertNames(String[] names, String name1, String name2) {
        names[4] = name1;
        names[5] = name2;
        return names;
    }

    // This could be used as a "void" function, 
    // but the code looks prettier as a return function
    public static String[] reverseNames(String[] names) {
        for (int i = 0; i < names.length / 2; i++) {
            String temp = names[i];
            names[i] = names[names.length - i - 1];
            names[names.length - i - 1] = temp;
        }

        return names;
    }

    // The order that you enter the Strings is very important! 
    // Put the String that you want to be a copy first, 
    // and the string that is being copied second
    public static String[] copyNames(String[] New, String[] old) {
        for (int i = 0; i < old.length; i++) {
            New[i] = old[i];
        }

        return New;
    }

    // used as a return method to demonstrate for-each loops and return functions
    public static String[] reverseNames2(String[] names) {
        String[] newArr = new String[names.length];
        int i = names.length - 1;
        for (String name : names) {
            newArr[i] = name;
            i--;
        }

        return newArr;
    }

    // removing "Rick" from the array
    public static String[] removeNames(String[] names) {
        for (int i = 0; i < names.length; i++) {
            if (names[i] != null && names[i].equals("Rick")) {
                names[i] = null;

                for (int j = i + 1; j < names.length; j++) {
                        shiftNames(names, i, i - 1);
                }
            }
        }
        
        return names;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordletter;

import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author user
 */
public class WordLetterCount {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //  NOTE
        //  NO WRITING CODE INTO MAIN . ONLY DECLARE VARIABLE AND CALL METHOD
//        String str;
//
//        HashMap<Character, Integer> letterMap = new HashMap<>(); // SAVE LETTERS
//
//        HashMap<String, Integer> wordMap = new HashMap<>();  // SAVE WORDS
//         TEST CODE (WHEN TEST REMEMBER TO COMMENTIZE THE ASKFORINPUT)
//         WHEN TEST INPUT TEACHER WILL ASK TO INPUT A BLANK SPACE 
//     System.out.println("Enter the content ");
//     str = "hello world";
//     System.out.println(str);
//        str = askForInput();
//
//        beginCountAndStore(str, wordMap, letterMap);   // COUNT AND STORE INTO MAPS
//
//        display(wordMap, letterMap);
        WordLetterCount w = new WordLetterCount();
        HashMap<Character, Integer> letterMap = new HashMap<>(); // SAVE LETTERS

        HashMap<String, Integer> wordMap = new HashMap<>();
        w.displayOUput();
    }

    // hàm while(  true )
    void displayOUput() {
        Scanner sc= new Scanner(System.in);
        while(true){
        String str;

        HashMap<Character, Integer> letterMap = new HashMap<>(); // SAVE LETTERS

        HashMap<String, Integer> wordMap = new HashMap<>();
        str = askForInput();

        beginCountAndStore(str, wordMap, letterMap);   // COUNT AND STORE INTO MAPS

        display(wordMap, letterMap);
            System.out.println("Do you want to input continuen Y/N");
        String check= sc.nextLine();
        if(check.equals("Y")){
            continue;
        }else if(check.equalsIgnoreCase("N")){
            break;
        }
    }
    }
    // b1: check input
    static String askForInput() {
        System.out.println("Enter the content:");

        Scanner in = new Scanner(System.in);

        String str;

        while (true) {
            // STEP 1 INPUT A STRING
            str = in.nextLine();

            // STEP 2 CHECK IF INPUT IS VALID
            if (str.trim().isEmpty()) {
                System.out.println("Invalid Input");
                System.out.println("Please enter again:");
            } else {
                break;
            }
        }

        return str;
    }

    // dếm và lưu 
    static void beginCountAndStore(String str,
            HashMap<String, Integer> wordMap,
            HashMap<Character, Integer> letterMap) {
        // WORD COUNT
        

        // ngắt 1 chuỗi thành các mã thông báo 
        StringTokenizer st = new StringTokenizer(str, " ");

        // STEP 1 CHECK IF STRING HAS TOKENS
        while (st.hasMoreTokens()) {
            String c = st.nextToken();

            // STEP 2 CHECK IF HASHMAP CONTAIN KEY
            if (wordMap.containsKey(c)) {   // STEP 3 IF YES +1 INTO VALUE
                wordMap.put(c, wordMap.get(c) + 1);
            } else {   // NO PUT 1
                wordMap.put(c, 1);
            }
        }

        // LETTER COUNT
        char[] ch = str.toCharArray();

        for (char c : ch) {
            if (letterMap.containsKey(c) && c != ' ') {
                letterMap.put(c, letterMap.get(c) + 1);
            } else if (c != ' ') {
                letterMap.put(c, 1);
            }
        }
    }

    static void display(HashMap<String, Integer> wordMap, HashMap<Character, Integer> letterMap) {
        System.out.println(wordMap);
        System.out.println(letterMap);
       
    }
}

package com.company;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner in;
        FileReader file;
        if(args.length == 0){
            in = new Scanner(System.in);
        }else {
            file = new FileReader(args[0]);
            in = new Scanner(file);
        }

        int result = 0;
        boolean key = false;
        String delimeter = " ";
        String operation = in.nextLine();

        String[] subStr;
        subStr = operation.split(delimeter);
        for(int i = 0; i < subStr.length; i++) {
            if (subStr[i].equals("mul")){
                key = false;
            }
            else if (subStr[i].equals("add")){
                key = true;
            }
            else{
                if (key){
                        result += Integer.parseInt(subStr[i]);
                }
                else {
                    if (result == 0)
                        result = Integer.parseInt(subStr[i]);
                    else result *= Integer.parseInt(subStr[i]);
                }
            }
        }

        if(args.length == 0){
            System.out.println(result);
        }else {
            FileWriter fw = new FileWriter(args[1]);
            fw.write(Integer.toString(result));
            fw.close();
        }

    }
}

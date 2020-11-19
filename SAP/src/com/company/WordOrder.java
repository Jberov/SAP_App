package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;


public class WordOrder {
    public ArrayList<String> LinesList;

    public WordOrder(){
        LinesList = new ArrayList<>();
    }
    public void wordReading(String FileName) throws IOException, IndexOutOfBoundsException
    {


                if(FileName == null){
                    throw new IOException ("File not found");
                }
                BufferedReader in = new BufferedReader (new FileReader (FileName));
                String word_to_be_read;
                while ((word_to_be_read = in.readLine ()) != null) {
                    LinesList.add (word_to_be_read);
                }
            System.out.println (LinesList);
                in.close ();

    }
    public void swapLines(int Line1, int Line2) throws InputMismatchException {

            int indexA;
            int indexB;
            indexA=Line1 - 1;
            indexB=Line2 - 1;
            if((indexA > LinesList.size () )|| (indexB > LinesList.size ()) || (indexA == indexB)){
                throw new IndexOutOfBoundsException ("You have entered an invalid integer. The file has: " + (LinesList.size () + 1));
            }
            Collections.swap(LinesList, indexA, indexB);
        }
    public void swapWords(int Line1, int Line2, int Word1, int Word2) throws InputMismatchException{

        int indexLine1;
        int indexLine2;
        int indexWord3;
        int indexWord4;
        indexLine1 = Line1 - 1;
        indexLine2 = Line2 - 1;
        indexWord3 = Word1 - 1;
        indexWord4 = Word2 - 1;
            if((indexLine1 > LinesList.size ()) || (indexLine2 > LinesList.size ())){
            throw new IndexOutOfBoundsException ("You have entered an index of an nonexistent line. The file has: " + (LinesList.size () + 1));
            }
            String [] Line1ArrayWords = LinesList.get (indexLine1).split ("\\s+");
            if(indexLine1 != indexLine2){
                String [] Line2ArrayWords = LinesList.get (indexLine2).split ("\\s+ ");
                String word1Data = Line1ArrayWords[indexWord3];
                Line1ArrayWords[indexWord3] = Line2ArrayWords[indexWord4];
                Line2ArrayWords[indexWord4] = word1Data;
                LinesList.set(indexLine1, String.join("", Line1ArrayWords));
                LinesList.set(indexLine2, String.join("", Line2ArrayWords));
            }else{
                String word1Data = Line1ArrayWords[indexWord3];
                Line1ArrayWords[indexWord3] = Line1ArrayWords[indexWord4];
                Line1ArrayWords[indexWord4] = word1Data;
                LinesList.set(indexLine1, String.join("", Line1ArrayWords));
            }





    }
    public void wordWriting(String FileName) throws  IOException{

            BufferedWriter out = new BufferedWriter(new FileWriter(FileName));
                for (String line : LinesList) {
                    out.write(line);
                    out.flush();
                    out.newLine ();
                }
                out.close ();
            }


}


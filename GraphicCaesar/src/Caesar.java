
import java.io.*;
import java.util.*;
import java.lang.String;

public class Caesar {



    public static int isIn(char x, String word){
        for (int i=0; i<word.length(); i++)
            if (word.toCharArray()[i] == x) {
                return(i);
            }
        return(-1);
    }

    public static char caesar(int position, String word, int shift){
        if (shift<0) shift = word.length()+ (shift % word.length());
        //System.out.print(position+shift);
        return(word.toCharArray()[(position+shift) % word.length()]);
    }

    public static String encryption(int shift, String DataIn) {
        //-------------- Alphabet_data_base -------------
        String BigEng = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String SmallEng = "abcdefghijklmnopqrstuvwxyz";
        String BigRu = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЬЫЪЭЮЯ";
        String SmallRu = "абвгдеёжзийклмнопрстуфхцчшщьыъэюя";
        String nums = "0123456789";
        String unSee = "\n\r\t";

        String DataOut="";
        for (int i=0; i<DataIn.length(); i++) {
            String type = "ss";
            int Xposition = isIn(DataIn.toCharArray()[i], SmallRu);
            if (Xposition != -1) {
                type = "sr";
                DataOut += caesar(Xposition, SmallRu, shift);
            } else {
                Xposition = isIn(DataIn.toCharArray()[i], BigRu);
                if (Xposition != -1) {
                    type = "br";
                    DataOut += caesar(Xposition, BigRu, shift);
                } else {
                    if (isIn(DataIn.toCharArray()[i], BigEng) != -1)
                        type = "be";
                    if (isIn(DataIn.toCharArray()[i], SmallEng) != -1)
                        type = "se";
                    if (isIn(DataIn.toCharArray()[i], nums) != -1)
                        type = "nu";
                    if (isIn(DataIn.toCharArray()[i], unSee) != -1) {
                        type = "uns";
                    }
                    DataOut += DataIn.toCharArray()[i];
                }
            }
        }


        return(DataOut);

    }

    public static boolean isWordInText(String Text, String word){
        return Text.contains(word);
    }

    public static String decoding(String KeyWord, String DataIn){

        String BigRu = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЬЫЪЭЮЯ";
        String SmallRu = "абвгдеёжзийклмнопрстуфхцчшщьыъэюя";
        String DataOut = "";

        for (int shift = 0; shift < 33; shift++) {
            //System.out.println(-shift);
            DataOut = "";
            for (int i = 0; i < DataIn.length(); i++) {
                int Xposition = isIn(DataIn.toCharArray()[i], SmallRu);
                if (Xposition != -1)
                    DataOut += caesar(Xposition, SmallRu, -shift);
                else {
                    int Xposition1 = isIn(DataIn.toCharArray()[i], BigRu);
                    if (Xposition1 != -1)
                        DataOut += caesar(Xposition1, BigRu, -shift);
                    else DataOut += DataIn.toCharArray()[i];
                }

            }
            if (isWordInText(DataOut, KeyWord)) {
                return (DataOut);
            }


        }
        return("Сообщение расшифровать не удалось. Попробуйте ввести другой ключ.");
    }

}
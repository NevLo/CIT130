package numwords                                                                ;

import java.util.Scanner                                                        ;


public class NumWords                                                           {
    public static void main(String[] args)                                      {
        Scanner in = new Scanner(System.in)                                     ;
        System.out.print("Please enter your favorite sentence\n>>> ")            ;  
        String sentence = in.nextLine()                                         ;
        sentence = sentence.trim()                                              ;
        if(sentence.length() == 0)                                              {
            System.err.println("String is empty!")                              ;}
        else                                                                    {
            boolean inWhiteSpace = false                                        ;
            int tokenCount = 1                                                  ;
            for(int i = 0; i < sentence.length(); i++)                          {
                char c = sentence.charAt(i)                                     ;
                if(c == ' ' || c == '\t')                                       {
                    if(!inWhiteSpace)                                           {
                        tokenCount++                                            ;
                        inWhiteSpace = true                                     ;}}
                else                                                            {
                    inWhiteSpace = false                                        ;}}
            System.out.println("This sentencance has "
                .concat(String.valueOf(tokenCount))
                .concat(tokenCount == 1 ? " token" : " tokens"))                      ;}}}

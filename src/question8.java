//package com.journaldev.jsoup;

import java.io.IOException;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.StringTokenizer;

public class question8 {
    
  // method main(): ALWAYS the APPLICATION entry point 
public static void main(String[] args) {
  try {
            Document doc = Jsoup.connect("http://www.cs.wayne.edu/~shiyong/transcript2.html").get();
            Elements paragraphs = doc.select("p");
            int flag =0;
            String Trump = "";
            String Cooper = "";
            String Clinton = "";
            String Raddatz = "";
            for(Element p : paragraphs) {
             String str = p.text();
             //System.out.println(str);
             
             StringTokenizer defaultTokenizer = new StringTokenizer(str);
              
              while (defaultTokenizer.hasMoreTokens())
              {
            //    System.out.println(defaultTokenizer.nextToken());
                String word = defaultTokenizer.nextToken();
              
                //System.out.println(word);
                if(word.equals("TRUMP:"))
                {
                  flag = 1;
                }
                else if(word.equals("CLINTON:"))
                {
                  flag = 2;
                }
                else if(word.equals("RADDATZ:"))
                {
                  flag = 3;
                }
                else if(word.equals("COOPER:"))
                {
                  flag = 4;
                }
                else if(flag==1)
                {
                  Trump = Trump + " " + word;
                }
                else if(flag==2)
                {
                  Clinton = Clinton + " " + word;
                }
                else if(flag==3)
                {
                  Cooper = Cooper + " " + word;
                }
                else if(flag==4)
                {
                  Raddatz = Raddatz + " " + word;
                }
           
              }
              
            }
            
            
            int len = Trump.length();
            char c1 ='.';
            int count =0;
            for(int i=0; i<len; i++)
            {
              if(i<len &&Trump.charAt(i)==c1)
              {
                i++;
                if(i<len &&Trump.charAt(i)==c1)
                {
                  i++;
                  if(i<len &&Trump.charAt(i)==c1)
                  {
                    count++;
                  }
                }
              }
            }
 
           System.out.println("The no of times Clinton was interrupted : " + count);
           
           
           
            len = Clinton.length();
            count =0;
            for(int i=0; i<len; i++)
            {
              if(Clinton.charAt(i)==c1)
              {
                i++;
                if(i<len && Clinton.charAt(i)==c1)
                {
                  i++;
                  if(i<len && Clinton.charAt(i)==c1)
                  {
                    count++;
                  }
                }
              }
            }
 
           System.out.println("The no of times Trump was interrupted : " + count);
           

}
            catch (IOException e) {
            e.printStackTrace();
        } 
        
  }
}
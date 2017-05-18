//package com.journaldev.jsoup;

import java.io.IOException;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.StringTokenizer;

public class question10 {
    
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
            
            
            int c = Trump.split("\\btrade\\b").length - 1;
            int d = Trump.split("\\bindustry\\b").length - 1;
            int f = Trump.split("\\bbusiness\\b").length - 1;
            int e = Trump.split("\\bmarket\\b").length - 1;
            c=c+d+e+f;
            System.out.println("The number of times Trump spoke of trade " + c);
            
            
            
            c = Clinton.split("\\btrade\\b").length - 1;
            d = Clinton.split("\\bindustry\\b").length - 1;
            f = Clinton.split("\\bbusiness\\b").length - 1;
            e = Clinton.split("\\bmarket\\b").length - 1;
            c=c+d+e+f;
            System.out.println("The number of times Clinton spoke of trade" + c);
            
      
  }
            catch (IOException e) {
            e.printStackTrace();
        } 
        
  }
}
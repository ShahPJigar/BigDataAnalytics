//package com.journaldev.jsoup;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.StringTokenizer;


public class question9 {
    
    // method main(): ALWAYS the APPLICATION entry point
public static void main(String[] args) {
  try {
            Document doc = Jsoup.connect("http://www.cs.wayne.edu/~shiyong/transcript2.html").get();
            Elements paragraphs = doc.select("p");
            String Trump = "";
            String Cooper = "";
            String Clinton = "";
            String Raddatz = "";
            int flag =0;
            int trumpcount=0;
            int clintoncount=0;
            for(Element p : paragraphs) {
             String str = p.text();
             //System.out.println(str);
             
             StringTokenizer defaultTokenizer = new StringTokenizer(str);
              
              while (defaultTokenizer.hasMoreTokens())
              {
            //    System.out.println(defaultTokenizer.nextToken());
                String word = defaultTokenizer.nextToken();
                
                if(flag==1)
                {
                  flag=0;
                  if(word.equals("TRUMP:"))
                    trumpcount++;
                  else if(word.equals("CLINTON:"))
                    clintoncount++;
                }
                
                if(word.contains("..."))
                  flag=1;
              }
            }
            
            System.out.println("The number of times Trump interruped is" + trumpcount);
            System.out.println("The number of times Clinton interruped is" + clintoncount);
            
            
        } catch (IOException e) {
            e.printStackTrace();
        } 
        
        
}
}


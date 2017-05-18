import java.io.*; 
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.StringTokenizer;


public class question1 {
	public static void main(String[] args) {
	try {
        Document doc = Jsoup.connect("http://www.cs.wayne.edu/~shiyong/transcript2.html").get();
        Elements paragraphs = doc.select("p");
        String Trump = "";
        String Cooper = "";
        String Clinton = "";
        String Raddatz = "";
        for(Element p : paragraphs) {
         String str = p.text();
         //System.out.println(str);
         int flag =0;
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
        System.out.println("TRUMP : ");
        System.out.println(Trump);
        
        System.out.println("CLINTON : ");
        System.out.println(Clinton);
        
        System.out.println("RADDATZ : ");
        System.out.println(Raddatz);
        
        System.out.println("COOPER : ");
        System.out.println(Cooper);
    } catch (IOException e) {
        e.printStackTrace();
    } 
	}
}

import java.io.*; 
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.StringTokenizer;


public class question2 {
	public static void main(String[] args) {
		  try {
		            Document doc = Jsoup.connect("http://www.cs.wayne.edu/~shiyong/transcript2.html").get();
		            Elements paragraphs = doc.select("p");
		            int Trump = 0;
		            int Cooper = 0;
		            int Clinton = 0;
		            int Raddatz = 0;
		            
		            int flag =0;
		            for(Element p : paragraphs) {
		             String str = p.text();
		             //System.out.println(str);
		             StringTokenizer defaultTokenizer = new StringTokenizer(str);
		              
		              while (defaultTokenizer.hasMoreTokens())
		              {
		            //    System.out.println(defaultTokenizer.nextToken());
		                String word = defaultTokenizer.nextToken();
		              
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
		                  Trump = Trump +1;
		                }
		                else if(flag==2)
		                {
		                  Clinton = Clinton + 1;
		                }
		                else if(flag==3)
		                {
		                  Cooper = Cooper + 1;
		                }
		                else if(flag==4)
		                {
		                  Raddatz = Raddatz + 1;
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



//package com.journaldev.jsoup;

import java.io.IOException;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.StringTokenizer;


public class question3 {
	
	
	public static void tokenizenow(String Trump)
	{
		String stopWords[] = {"a", "about", "above", "above", "across", "after", "afterwards", "again", "against", "all", "almost", "alone", "along", "already", "also","although","always","am","among", "amongst", "amoungst", "amount",  "an", "and", "another", "any","anyhow","anyone","anything","anyway", "anywhere", "are", "around", "as",  "at", "back","be","became", "because","become","becomes", "becoming", "been", "before", "beforehand", "behind", "being", "below", "beside", "besides", "between", "beyond", "bill", "both", "bottom","but", "by", "call", "can", "cannot", "cant", "co", "con", "could", "couldnt", "cry", "de", "describe", "detail", "do", "done", "down", "due", "during", "each", "eg", "eight", "either", "eleven","else", "elsewhere", "empty", "enough", "etc", "even", "ever", "every", "everyone", "everything", "everywhere", "except", "few", "fifteen", "fify", "fill", "find", "fire", "first", "five", "for", "former", "formerly", "forty", "found", "four", "from", "front", "full", "further", "get", "give", "go", "had", "has", "hasnt", "have", "he", "hence", "her", "here", "hereafter", "hereby", "herein", "hereupon", "hers", "herself", "him", "himself", "his", "how", "however", "hundred", "ie", "if", "in", "inc", "indeed", "interest", "into", "is", "it", "its", "itself", "keep", "last", "latter", "latterly", "least", "less", "ltd", "made", "many", "may", "me", "meanwhile", "might", "mill", "mine", "more", "moreover", "most", "mostly", "move", "much", "must", "my", "myself", "name", "namely", "neither", "never", "nevertheless", "next", "nine", "no", "nobody", "none", "noone", "nor", "not", "nothing", "now", "nowhere", "of", "off", "often", "on", "once", "one", "only", "onto", "or", "other", "others", "otherwise", "our", "ours", "ourselves", "out", "over", "own","part", "per", "perhaps", "please", "put", "rather", "re", "same", "see", "seem", "seemed", "seeming", "seems", "serious", "several", "she", "should", "show", "side", "since", "sincere", "six", "sixty", "so", "some", "somehow", "someone", "something", "sometime", "sometimes", "somewhere", "still", "such", "system", "take", "ten", "than", "that", "the", "their", "them", "themselves", "then", "thence", "there", "thereafter", "thereby", "therefore", "therein", "thereupon", "these", "they", "thickv", "thin", "third", "this", "those", "though", "three", "through", "throughout", "thru", "thus", "to", "together", "too", "top", "toward", "towards", "twelve", "twenty", "two", "un", "under", "until", "up", "upon", "us", "very", "via", "was", "we", "well", "were", "what", "whatever", "when", "whence", "whenever", "where", "whereafter", "whereas", "whereby", "wherein", "whereupon", "wherever", "whether", "which", "while", "whither", "who", "whoever", "whole", "whom", "whose", "why", "will", "with", "within", "without", "would", "yet", "you", "your", "yours", "yourself", "yourselves", "the"};
        Trump = Trump.toLowerCase();
        
        for(int i=0;i<stopWords.length;i++)
        {
          String stopword = " " + stopWords[i] + " ";
          if(Trump.contains(stopword))
          {
           Trump=Trump.replaceAll(stopword, " ");
          }
        }
        Trump=Trump.replaceAll(",","");
        Trump=Trump.replaceAll("\\.","");
        Trump=Trump.replaceAll("\\?","");
            
            StringTokenizer defaultTokenizer = new StringTokenizer(Trump);
            int numberofwords = defaultTokenizer.countTokens();
            
            String[] dict = new String[numberofwords];
            int num[] = new int[numberofwords];
            int curr= 0;
            int flag =0;
            
            while (defaultTokenizer.hasMoreTokens())
            {
              String word = defaultTokenizer.nextToken();
              for(int j=0; j<curr; j++)
              {
                if (dict[j].equals(word))
                {
                  num[j]++;
                  flag=1;
                  break;
                }
              }
              if(flag==0)
              {
                dict[curr]=word;
                num[curr]=1;
                curr++;
              }
              flag=0;
            }
            
            int max=0;
            int limit=99999;
            
            
            
            
            for(int k=0; k<5; k++)
            {
              if(k>0)
              {
                limit=max;
              }max=0;
              
            for(int j=0; j<curr; j++)
            {
              if(num[j] >max && num[j]<limit)
              {
                max=num[j];
              }
            }
            //System.out.println(max);
            for(int i=0; i<curr; i++)
            {
              if(num[i] == max)
              {
                System.out.println(dict[i]);
              }
            }
            
            
            }
	}
	
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
		            
		            System.out.println("Trump:");
		            tokenizenow(Trump);
		            System.out.println("Clinton:");
		            tokenizenow(Clinton);
		            System.out.println("Raddatz:");
		            tokenizenow(Raddatz);
		            System.out.println("Cooper:");
		            tokenizenow(Cooper);
		            
		        
		            
		            
		            		              }
		            catch (IOException e) {
		            e.printStackTrace();
		        } 
		        
		  }
		}

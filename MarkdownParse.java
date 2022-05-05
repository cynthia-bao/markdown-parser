//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
//made a change for lab 6 writeup more change

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            int openBracket;
            //no more links/brackets
            if(currentIndex==0 && markdown.indexOf("[")==0){
                //System.out.println("Reads first bracket");
                openBracket = 0;
            }else if(markdown.indexOf("[", currentIndex)==-1){
                break;
            }else{
                //System.out.println("Not supposed to be here");
                openBracket = markdown.indexOf("[", currentIndex);
            }
            //System.out.println(currentIndex + " start");
            if(openBracket!=0 && markdown.indexOf("!", currentIndex) == openBracket-1){
                currentIndex += 2;
                continue;
            }
            //System.out.println("Openbracket: "+openBracket+" Reaches close bracket");
            int closeBracket = markdown.indexOf("]", openBracket);
            //no parenthesis
            if(markdown.indexOf("(", closeBracket)==-1){
                break;
            }
            int openParen = markdown.indexOf("(", closeBracket);
            //no parenthesis
            if(markdown.indexOf(")", openBracket)==-1){
                break;
            }
            if(openParen-1 != closeBracket){
                currentIndex += 1;
                continue;
            }
            int closeParen = markdown.indexOf(")", openParen);
            toReturn.add(markdown.substring(openParen + 1, closeParen));
            currentIndex = closeParen + 1;
            //System.out.println(currentIndex + " end");
        }
        //change again
        return toReturn;
    }


    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
        if(links != null){
            System.out.println(links);
        }
        System.out.println("hi");
    }
}

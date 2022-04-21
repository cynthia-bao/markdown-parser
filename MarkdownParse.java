//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

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
            //no more links/brackets
            if(markdown.indexOf("[", currentIndex)==-1){
                break;
            }
            //System.out.println(currentIndex + " start");
            int openBracket = markdown.indexOf("[", currentIndex);
            // if(markdown.indexOf("!", currentIndex) == openBracket-1){
            //     currentIndex += 2;
            //     continue;
            // }
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
            int closeParen = markdown.indexOf(")", openParen);
            toReturn.add(markdown.substring(openParen + 1, closeParen));
            currentIndex = closeParen + 1;
            //System.out.println(currentIndex + " end");
        }

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

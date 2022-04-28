//importing junit library
import static org.junit.Assert.*;
import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class MarkdownParseTest {

    // @Before
    // public void setup() {
    //     mdp = new MarkdownParse();
    // }

    @Test //following method is a test
    public void addition() { //testing addition
        //checking to see if 1+1 = expected output
        //of 2
        assertEquals(2, 1+1);
    }

    @Test
    public void testGetLinksTestFile() throws IOException {
        ArrayList<String> testFileLink = new ArrayList<>();
        testFileLink.addAll(Arrays.asList("https://something.com", "some-thing.html"));
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        assertEquals(testFileLink, MarkdownParse.getLinks(content)); 
    }

    @Test
    public void testGetLinksBracketsFile() throws IOException {
        ArrayList<String> testFileLink = new ArrayList<>();
        testFileLink.addAll(Arrays.asList("somelink"));
        Path fileName = Path.of("brackets-only.md");
        String content = Files.readString(fileName);
        assertEquals(testFileLink, MarkdownParse.getLinks(content)); 
    }
    @Test
    public void testGetLinksImageFile() throws IOException {
        ArrayList<String> testFileLink = new ArrayList<>();
        testFileLink.addAll(Arrays.asList("https://www.google.com"));
        Path fileName = Path.of("image-file.md");
        String content = Files.readString(fileName);
        assertEquals(testFileLink, MarkdownParse.getLinks(content)); 
    }
}

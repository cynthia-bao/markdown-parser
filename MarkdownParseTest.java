//importing junit library
//change made for makefile lab 6 writeup
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

@Test
public void testSnip1() throws Exception {
    String file = Files.readString(Path.of("snippet1.md"));
    ArrayList<String> testoutput = new ArrayList<>();
    testoutput = MarkdownParse.getLinks(file);
    ArrayList<String> expectedoutput = new ArrayList<String>();
    expectedoutput.addAll(Arrays.asList("'google.com", "google.com"));
    assertEquals(expectedoutput, testoutput);
}

@Test
public void testSnip2() throws Exception {
    String file = Files.readString(Path.of("snippet2.md"));
    ArrayList<String> testoutput = new ArrayList<>();
    testoutput = MarkdownParse.getLinks(file);
    ArrayList<String> expectedoutput = new ArrayList<String>();
    expectedoutput.addAll(Arrays.asList("a.com", "a.com(())",
        "example.com"));
    assertEquals(expectedoutput, testoutput);
}

@Test
public void testSnip3() throws Exception {
    String file = Files.readString(Path.of("snippet3.md"));
    ArrayList<String> testoutput = new ArrayList<>();
    testoutput = MarkdownParse.getLinks(file);
    ArrayList<String> expectedoutput = new ArrayList<String>();
    expectedoutput.addAll(Arrays.asList("https://www.twitter.com", 
        "https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule",
        "https://cse.ucsd.edu/"
    ));
    assertEquals(expectedoutput, testoutput);
}
}
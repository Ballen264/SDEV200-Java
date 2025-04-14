import java.io.IOException; // Import for reading command line arguments.
import java.nio.file.Files; // Import for reading command line arguments.
import java.nio.file.Paths; // Import for reading command line arguments.

public class KeywordCounter {
    public static void main(String[] args) throws IOException { // Had the text editor screaming at me that there was no throw IOException.

        // This is some code that helps with crashes, I found that this would be increadibly beneficial and will reduce irritation from misspelling something.
        if (args.length != 1) {
            System.err.println("Usage: java KeywordCounter <JavaFileName>");
            return;
        }

        // Setup for creating the string of a file.
        String fileName = args[0];
        String fileContent;

        // This catches an IOException, naming it "e", and prints the error message in the error output.
        try {
            fileContent = new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }

        // Variables that tell the code whether it's in a string or comment. This also has the keyword count.
        boolean inSingleLineComment = false;
        boolean inMultiLineComment = false;
        boolean inString = false;
        int keywordCount = 0;

        for (int i = 0; i < fileContent.length(); i++) {
            char currentChar = fileContent.charAt(i);

            // Says whether the code is reading a string or not.
            if (currentChar == '"' && !inSingleLineComment && !inMultiLineComment) {
                inString = !inString;
            }

            // Says whether the code is reading a comment or not.
            if (i + 1 < fileContent.length() && fileContent.charAt(i) == '/' && fileContent.charAt(i + 1) == '/' && !inString && !inMultiLineComment) {
                inSingleLineComment = true;
                i++; // Skips second '/'
            }

            // If the code is in a single line comment, this will tell the code that the comment is done.
            if (currentChar == '\n' && inSingleLineComment) {
                inSingleLineComment = false;
            }

            // Says whether the code is reading a comment or not.
            if (i + 1 < fileContent.length() && fileContent.charAt(i) == '/' && fileContent.charAt(i + 1) == '*' && !inString && !inSingleLineComment) {
                inMultiLineComment = true;
                i++; // Skips '*'
            }

            // Looks for the end of a multi line comment, then decides if the code is in a comment or not.
            if (i + 1 < fileContent.length() && fileContent.charAt(i) == '*' && fileContent.charAt(i + 1) == '/' && inMultiLineComment) {
                inMultiLineComment = false;
                i ++; // Skips '/'
            }

            /* 
             * The beginning of checking for keywords.
             * This can be very inefficient for larger files, and may overlap with some keywords.
             * It might be a smarter idea to have the largest keywords first, and the smallest last.
             */

            if (!inSingleLineComment && !inMultiLineComment && !inString) {

                if (i + 7 < fileContent.length() && fileContent.substring(i, i + 8).equals("abstract")) {
                    keywordCount++; // Increment your keyword counter
                    i += 7;
                } else if (i + 5 < fileContent.length() && fileContent.substring(i, i + 6).equals("assert")) {
                    keywordCount++;
                    i += 5;
                } else if (i + 6 < fileContent.length() && fileContent.substring(i, i + 7).equals("boolean")) {
                    keywordCount++;
                    i += 6;
                } else if (i + 4 < fileContent.length() && fileContent.substring(i, i + 5).equals("break")) {
                    keywordCount++;
                    i += 4;
                } else if (i + 3 < fileContent.length() && fileContent.substring(i, i + 4).equals("byte")) {
                    keywordCount++;
                    i += 3;
                } else if (i + 3 < fileContent.length() && fileContent.substring(i, i + 4).equals("case")) {
                    keywordCount++;
                    i += 3;
                } else if (i + 4 < fileContent.length() && fileContent.substring(i, i + 5).equals("catch")) {
                    keywordCount++;
                    i += 4;
                } else if (i + 3 < fileContent.length() && fileContent.substring(i, i + 4).equals("char")) {
                    keywordCount++;
                    i += 3;
                } else if (i + 4 < fileContent.length() && fileContent.substring(i, i + 5).equals("class")) {
                    keywordCount++;
                    i += 4;
                } else if (i + 5 < fileContent.length() && fileContent.substring(i, i + 6).equals("const")) {
                    keywordCount++;
                    i += 5;
                } else if (i + 7 < fileContent.length() && fileContent.substring(i, i + 8).equals("continue")) {
                    keywordCount++;
                    i += 7;
                } else if (i + 6 < fileContent.length() && fileContent.substring(i, i + 7).equals("default")) {
                    keywordCount++;
                    i += 6;
                } else if (i + 2 < fileContent.length() && fileContent.substring(i, i + 3).equals("do")) {
                    keywordCount++;
                    i += 2;
                } else if (i + 5 < fileContent.length() && fileContent.substring(i, i + 6).equals("double")) {
                    keywordCount++;
                    i += 5;
                } else if (i + 3 < fileContent.length() && fileContent.substring(i, i + 4).equals("else")) {
                    keywordCount++;
                    i += 3;
                } else if (i + 6 < fileContent.length() && fileContent.substring(i, i + 7).equals("extends")) {
                    keywordCount++;
                    i += 6;
                } else if (i + 5 < fileContent.length() && fileContent.substring(i, i + 6).equals("false")) {
                    keywordCount++;
                    i += 5;
                } else if (i + 5 < fileContent.length() && fileContent.substring(i, i + 6).equals("final")) {
                    keywordCount++;
                    i += 5;
                } else if (i + 7 < fileContent.length() && fileContent.substring(i, i + 8).equals("finally")) {
                    keywordCount++;
                    i += 7;
                } else if (i + 5 < fileContent.length() && fileContent.substring(i, i + 6).equals("float")) {
                    keywordCount++;
                    i += 5;
                } else if (i + 3 < fileContent.length() && fileContent.substring(i, i + 4).equals("for")) {
                    keywordCount++;
                    i += 3;
                } else if (i + 4 < fileContent.length() && fileContent.substring(i, i + 5).equals("goto")) {
                    keywordCount++;
                    i += 4;
                } else if (i + 2 < fileContent.length() && fileContent.substring(i, i + 3).equals("if")) {
                    keywordCount++;
                    i += 2;
                } else if (i + 10 < fileContent.length() && fileContent.substring(i, i + 11).equals("implements")) {
                    keywordCount++;
                    i += 10;
                } else if (i + 5 < fileContent.length() && fileContent.substring(i, i + 6).equals("import")) {
                    keywordCount++;
                    i += 5;
                } else if (i + 10 < fileContent.length() && fileContent.substring(i, i + 11).equals("instanceof")) {
                    keywordCount++;
                    i += 10;
                } else if (i + 2 < fileContent.length() && fileContent.substring(i, i + 3).equals("int")) {
                    keywordCount++;
                    i += 2;
                } else if (i + 8 < fileContent.length() && fileContent.substring(i, i + 9).equals("interface")) {
                    keywordCount++;
                    i += 8;
                } else if (i + 4 < fileContent.length() && fileContent.substring(i, i + 5).equals("long")) {
                    keywordCount++;
                    i += 4;
                } else if (i + 6 < fileContent.length() && fileContent.substring(i, i + 7).equals("native")) {
                    keywordCount++;
                    i += 6;
                } else if (i + 3 < fileContent.length() && fileContent.substring(i, i + 4).equals("new")) {
                    keywordCount++;
                    i += 3;
                } else if (i + 4 < fileContent.length() && fileContent.substring(i, i + 5).equals("null")) {
                    keywordCount++;
                    i += 4;
                } else if (i + 7 < fileContent.length() && fileContent.substring(i, i + 8).equals("package")) {
                    keywordCount++;
                    i += 7;
                } else if (i + 7 < fileContent.length() && fileContent.substring(i, i + 8).equals("private")) {
                    keywordCount++;
                    i += 7;
                } else if (i + 9 < fileContent.length() && fileContent.substring(i, i + 10).equals("protected")) {
                    keywordCount++;
                    i += 9;
                } else if (i + 6 < fileContent.length() && fileContent.substring(i, i + 7).equals("public")) {
                    keywordCount++;
                    i += 6;
                } else if (i + 5 < fileContent.length() && fileContent.substring(i, i + 6).equals("return")) {
                    keywordCount++;
                    i += 5;
                } else if (i + 4 < fileContent.length() && fileContent.substring(i, i + 5).equals("short")) {
                    keywordCount++;
                    i += 4;
                } else if (i + 6 < fileContent.length() && fileContent.substring(i, i + 7).equals("static")) {
                    keywordCount++;
                    i += 6;
                } else if (i + 8 < fileContent.length() && fileContent.substring(i, i + 9).equals("strictfp")) {
                    keywordCount++;
                    i += 8;
                } else if (i + 4 < fileContent.length() && fileContent.substring(i, i + 5).equals("super")) {
                    keywordCount++;
                    i += 4;
                } else if (i + 6 < fileContent.length() && fileContent.substring(i, i + 7).equals("switch")) {
                    keywordCount++;
                    i += 6;
                } else if (i + 11 < fileContent.length() && fileContent.substring(i, i + 12).equals("synchronized")) {
                    keywordCount++;
                    i += 11;
                } else if (i + 4 < fileContent.length() && fileContent.substring(i, i + 5).equals("this")) {
                    keywordCount++;
                    i += 4;
                } else if (i + 5 < fileContent.length() && fileContent.substring(i, i + 6).equals("throw")) {
                    keywordCount++;
                    i += 5;
                } else if (i + 6 < fileContent.length() && fileContent.substring(i, i + 7).equals("throws")) {
                    keywordCount++;
                    i += 6;
                } else if (i + 9 < fileContent.length() && fileContent.substring(i, i + 10).equals("transient")) {
                    keywordCount++;
                    i += 9;
                } else if (i + 4 < fileContent.length() && fileContent.substring(i, i + 5).equals("true")) {
                    keywordCount++;
                    i += 4;
                } else if (i + 3 < fileContent.length() && fileContent.substring(i, i + 4).equals("try")) {
                    keywordCount++;
                    i += 3;
                } else if (i + 4 < fileContent.length() && fileContent.substring(i, i + 5).equals("void")) {
                    keywordCount++;
                    i += 4;
                } else if (i + 8 < fileContent.length() && fileContent.substring(i, i + 9).equals("volatile")) {
                    keywordCount++;
                    i += 8;
                } else if (i + 5 < fileContent.length() && fileContent.substring(i, i + 6).equals("while")) {
                    keywordCount++;
                    i += 5;
                }
            }
        }

        System.out.println("The number of keywords in the program is " + keywordCount);
    }
}
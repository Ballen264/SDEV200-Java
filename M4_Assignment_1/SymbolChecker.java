import java.io.IOException; // Import for reading command line arguments.
import java.nio.file.Files; // Import for reading command line arguments.
import java.nio.file.Paths; // Import for reading command line arguments.

public class SymbolChecker {
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
        String symbolString = "";

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

            // This code looks at the character it's on, and checks if it's a grouping character.
            // This code also changes the symbolString variable and depending on how well the file is written, it should be able to tell whether it's written right.
            if (!inSingleLineComment && !inMultiLineComment && !inString) {

                if (i < fileContent.length() && fileContent.substring(i, i + 1).equals("(")) {
                    symbolString += "(";
                }

                if (i < fileContent.length() && fileContent.substring(i, i + 1).equals("[")) {
                    symbolString += "[";
                }

                if (i < fileContent.length() && fileContent.substring(i, i + 1).equals("{")) {
                    symbolString += "{";
                }

                if (i < fileContent.length() && fileContent.substring(i, i + 1).equals(")")) {
                    if (symbolString.charAt(symbolString.length() - 1) == '(') {
                        symbolString = symbolString.substring(0,symbolString.length() - 1);
                    } else {
                        symbolString += "error";
                    }
                }

                if (i < fileContent.length() && fileContent.substring(i, i + 1).equals("]")) {
                    if (symbolString.charAt(symbolString.length() - 1) == '[') {
                        symbolString = symbolString.substring(0,symbolString.length() - 1);
                    } else {
                        symbolString += "error";
                    }
                }

                if (i < fileContent.length() && fileContent.substring(i, i + 1).equals("}")) {
                    if (symbolString.charAt(symbolString.length() - 1) == '{') {
                        symbolString = symbolString.substring(0,symbolString.length() - 1);
                    } else {
                        symbolString += "error";
                    }
                }
            }
        }

        if (symbolString.length() == 0) {
            System.out.println("This file has good grouping symbols.");
        } else {
            System.out.println("This file does not have good grouping symbols.");
        }

    }
}
/*
 * Inherits from EncodeMessage class.
 * Additionaly logic for decoding messages, requires a hash.
 * New takeMessage(String messasge, String hash) method to decode.
 */

 public class DecodeMessage extends EncodeMessage { // This class extends the EncodedMessage class from the EncodedMessage file.

    public String takeMessage(String message, String hash) {

        StringBuilder decodedMessage = new StringBuilder(); // Creates a new variable to be returned.

        for (char c : message.toCharArray()) { // Cycles through every character in the variable message.
            
            if (Character.isLetter(c)) { // Checks if the character c is a letter.

                char base = Character.isUpperCase(c) ? 'A' : 'a'; // Creates a new character named base, this is used to append the correct letter to the decodedMessage variable.
                decodedMessage.append((char) (((c - base - Integer.parseInt(hash) + 26) %26) + base)); // Appends the character to the decodedMessage variable.

            } else if (Character.isDigit(c)) { // Checks if the character is a digit.

                decodedMessage.append((char) (((c - '0' - Integer.parseInt(hash) + 10) % 10) + '0')); // Appends the uncycled digit to the decodedMessage variable.

            } else { // Anything else is caught here.

                decodedMessage.append(c); // Appends any other character to the decodedMessage variable.

            }

        }

        return decodedMessage.toString(); // Returns the decodedMessage variable, in a String format.

    }

 }
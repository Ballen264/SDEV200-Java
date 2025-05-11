/*
 * Contains logic for encoding messages.
 * Uses takeMessage(String message) method for grabbing the message.
 */

public class EncodeMessage {

    /*
     * takeMessage recieves a String as variable message.
     * This code makes a shift of three, I plan on rewriting it to be a custom shift.
     * 
     * Iterates through each character of the recieved string, or variable message.
     * If the character is a letter, it's shifted by three. The letters should also wrap around to the beginning of the alphabet.
     * If the character is a digit, it's shifted by three. The digit is wrapped around 0-9, if it goes above nine, it pushed back to 0.
     * Any other type of character is ignored.
     * 
     * This code uses StringBuilder, this is a more efficient method for this code.
     */

        public String takeMessage(String message, String hash) {

        // A simple Caesar Cipher.

        StringBuilder encodedMessage = new StringBuilder(); // New variable used for returning the encoded message.

        for (char c: message.toCharArray()) { // Cycles through each character in the message.

            if (Character.isLetter(c)) { // This checks if the character is a letter, rather than a digit or anything else.

                char base = Character.isUpperCase(c) ? 'a' : 'a'; // Pushes the character to the uppercase variant.

                encodedMessage.append((char) (((c - base + Integer.parseInt(hash)) % 26) + base)); // Appends the shifted character to the encodedMessage value.

            } else if (Character.isDigit(c)) { // Checks if the character is a digit.

                encodedMessage.append((char) (((c - '0' + Integer.parseInt(hash)) % 10) + '0')); // Appends a shifted digit to encodedMessage.

            } else { // Anything else is caught here, if we don't have this then the message may have missing characters.

                encodedMessage.append(c); // This prevents non-alphabetic or digit characters from changing. Basically ignores anything non-alphabetical or any digits.

            }

        }

        return encodedMessage.toString(); // Returns the encodedMessage to the main class.

    }

}
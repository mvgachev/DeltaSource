import java.util.HashMap;

/**
 * Class representing an exercise.
 */
public class Exercise1 {

    /**
     * Function that receives an expression, which consists only of the
     * clauses('a', 'A', 'b', 'B','c', 'C')
     * as a string or array of characters and returns a boolean
     * representing if the expression is valid or invalid.
     *
     * @param expression
     */
    private boolean isValidExpression(String expression) {
        HashMap<String, Integer> countOf = new HashMap<>();
        for (int i = 0; i < expression.length(); i++) {
            //Taking the letter as a char from the expression
            char letter = expression.charAt(i);
            //Checks if the character is upper case and registers it into the hash map.
            if (Character.isUpperCase(letter)) {
                String letterStr = String.valueOf(expression.charAt(i));
                //If the letter is already in the map, its value is incremented
                countOf.computeIfPresent(letterStr, (key, val) -> val + 1);
                //If its not, it is registered in the hash map
                countOf.putIfAbsent(letterStr, 1);
            } else { //If the letter is lower case, it is a closing clause
                String letterStr = String.valueOf(letter).toUpperCase();
                //Decrementing the number of "A","B" or "C" clauses
                countOf.computeIfPresent(letterStr, (key, val) -> val - 1);
            }
        }
        //Check if all of the clauses are closed (meaning their values are all 0s)
        for (String l : countOf.keySet()) {
            System.out.println(l + " " + countOf.get(l));
            if (countOf.get(l) != 0) return false;
        }
        return true;
    }
}

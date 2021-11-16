public class Brackets {
    public static boolean bracketsMirrored(char openingBracket, char closingBracket) {

        if (openingBracket == '(' && closingBracket == ')') {
            return true;
        } else if (openingBracket == '{' && closingBracket == '}') {
            return true;
        } else return openingBracket == '[' && closingBracket == ']';
    }

    public static boolean isThePatterValid(StringBuilder patternToCheck) {
        return (patternToCheck.length() == 0);
    }

    public static void main(String[] args) {
//        String brackets = "[]({}";

                String brackets = "()((()()){})";
//        String brackets = "()()";
        StringBuilder bracketsToManipulate = new StringBuilder(brackets);

        int lengthOfBrackets = bracketsToManipulate.length();
        int i = 0;

        System.out.println("The original brackets pattern: " + bracketsToManipulate);


        for (; i < lengthOfBrackets; i++) {
            try {
                if (bracketsMirrored(bracketsToManipulate.charAt(i), bracketsToManipulate.charAt(i + 1))) {
                    PairOfIndexes index = new PairOfIndexes();
                    index.setFirstIndex(i);
                    index.setSecondIndex(i + 1);

                    bracketsToManipulate.replace(index.getFirstIndex(), index.getSecondIndex() + 1, "");
                    lengthOfBrackets = bracketsToManipulate.length();
                    i = -1;

                }
            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }
        System.out.println(isThePatterValid(bracketsToManipulate));
    }
}
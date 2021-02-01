package From0To1DataStructuresAlgorithmsInJavaCourese.linkedList.stack.problems;

import From0To1DataStructuresAlgorithmsInJavaCourese.linkedList.stack.Stack;
import From0To1DataStructuresAlgorithmsInJavaCourese.linkedList.stack.StackOverflowException;
import From0To1DataStructuresAlgorithmsInJavaCourese.linkedList.stack.StackUnderflowException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindMatchingParenthesis {

    private static final Map<Character, Character> matchingParentMap = new HashMap<>();
    private static final Set<Character> openingParentSet = new HashSet<>();

    static {
        matchingParentMap.put(')','(');
        matchingParentMap.put('}','{');
        matchingParentMap.put(']','[');
        openingParentSet.addAll(matchingParentMap.values());
    }

    public static boolean hasMatchingParenthesis(String input) {
        try {
            Stack<Character> parentStack = new Stack<>();

            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                if (openingParentSet.contains(ch))
                    parentStack.push(ch);
                if (matchingParentMap.containsKey(ch)) {
                    Character lastParent = parentStack.pop();
                    if (lastParent != matchingParentMap.get(ch))
                        return false;

                }
            }
            return parentStack.isEmpty();
        } catch (StackOverflowException ex) {
            System.err.println("Stack Overflow");
        } catch (StackUnderflowException ex) {
            System.err.println("Stack Underflow");
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(hasMatchingParenthesis("{}{}[]()"));
        System.out.println(hasMatchingParenthesis("{}{}[](){"));
    }
}

package Oracle;

import java.util.Stack;

public class SimplifyPath {

    public String simplifyPath(String path) {
        String[] pathArray = path.split("/");

        Stack<String> stack = new Stack();

        for (String curr : pathArray) {
            if (curr.length() > 0 && !curr.equals(".")) {
                if (!curr.equals("..")) {
                    stack.add(curr);
                } else if (stack.size() > 0) {
                    stack.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String dir : stack) {
            sb.append("/");
            sb.append(dir);
        }

        return sb.length() > 0 ? sb.toString() : "/";
    }
}

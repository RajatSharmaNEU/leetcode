package Oracle;

import java.util.Stack;

public class ValidParenthesis {
    public boolean isValid(String s) {
        if(s==null || s.length() == 0) return false;
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < s.length();i++){
            char c = s.charAt(i);

            if(c == ')'){
                if(st.isEmpty() || st.pop()!='('){
                    return false;
                }
            }else if(c == ']'){
                if(st.isEmpty() || st.pop()!='['){
                    return false;
                }
            }else if(c == '}'){
                if(st.isEmpty() || st.pop() !='{'){
                    return false;
                }
            }
            else{
                st.push(c);
            }

        }

        return st.isEmpty();
    }
}

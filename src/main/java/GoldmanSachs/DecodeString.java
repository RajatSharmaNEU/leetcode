package GoldmanSachs;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        StringBuilder currStr = new StringBuilder();
        Stack<Integer> numSt = new Stack<>();
        Stack<StringBuilder> strSt = new Stack<>();
        int currNum = 0;


        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                int num = c - '0';
                currNum = currNum * 10 + num;
            }else if(c == '['){
                numSt.push(currNum);
                strSt.push(currStr);
                currNum = 0;
                currStr = new StringBuilder();
            }else if(c== ']'){
                int count = numSt.pop();
                StringBuilder newStr = new StringBuilder();
                for(int j = 0; j < count; j++){
                    newStr.append(currStr);
                }
                currStr = strSt.pop().append(newStr);//imp

                // currNum = 0;

            }else{
                currStr.append(c);
            }
        }

        return currStr.toString();

    }
}

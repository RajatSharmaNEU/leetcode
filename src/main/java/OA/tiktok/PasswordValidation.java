package OA.tiktok;

// password(n) contains password for validation
// dict_words(m) contains m weak passwords
// password is weak, if password's
// substring is in dict_words
// all are 0-9 or all lowercase or all uppercase or length less than 6

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PasswordValidation {

    private List<String> validate(String[] passwords, String[] commonWords) {
        List<String> result = new ArrayList<>();
        String regexAllNumber = "^[0-9]+$";
        String regexAllUpper = "^[A-Z]+$";
        String regexAllLower = "^[a-z]+$";

        for (String password: passwords) {
            boolean isWeak = false;

            if(password.matches(regexAllNumber) || password.matches(regexAllUpper) || password.matches(regexAllLower)) {
                result.add("weak");
                break;
            }

            for (int i = 0; i < commonWords.length; i++) {
                if(password.contains(commonWords[i])){
                    result.add("weak");
                    isWeak = true;
                    break;
                }
            }

            if(isWeak == false){
                result.add("strong");
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String[] passwords = new String[]{
                "iliketocoDe",
                "teaMAKEsmehappy",
                "abracaDabra",
                "pasSword",
                "blackcoffeeISthebest"
        };

        String[] commonWords = new String[]{"coffee", "coding", "happy"};

        PasswordValidation passwordValidation = new PasswordValidation();
        List<String> result = passwordValidation.validate(passwords, commonWords);
        List<String> expectedOutput = new ArrayList<>(Arrays.asList("strong", "weak", "strong", "strong", "weak"));

        for (int i = 0; i < expectedOutput.size(); i++) {
            if(result.get(i) != expectedOutput.get(i)) {
                System.err.println("Failed for - " + passwords[i] + " is " + result.get(i));
            } else {
                System.out.println("Passed for - " + passwords[i] + " is " + result.get(i));
            }
        }
    }
}

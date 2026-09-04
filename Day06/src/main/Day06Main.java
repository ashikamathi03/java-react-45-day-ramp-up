import java.util.Scanner;
import java.util.Arrays;
public class Day06Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the input: ");
        String s = sc.nextLine();
        String s1="SILENT";
        String s2="LISTEN";
        System.out.println("input= " + s);
        System.out.println("Palindrome=" + isPalindrome(s));
        System.out.println("wordcount: " + wordcount(s));
        System.out.println("vowelcount: " + vowelcount(s));
        System.out.println("TitleCase: "+toTitlecase(s));
        System.out.println("Longest word: "+Longestword(s));
        System.out.println("Angram: "+isAnagram(s1,s2));
        System.out.print("frequency (int[26]) = ");
        printCharFrequency(s);
        System.out.println("\n");
        System.out.println("anagram(\"listen\",\"silence\") = " + isAnagram("listen", "silence"));
        System.out.println(" mySplit(\"a,,b,c\", ',') = " +Arrays.toString(mySplit("a,,b,c", ',')));
        System.out.println();

        benchmarkConcatenationVsBuilder(100000);
        System.out.println();
        demonstrateStringEquality();
    }

    public static boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        String clean = "";
        for (int i = 0; i <= s.length() - 1; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                clean = clean + Character.toLowerCase(ch);

            }
        }
        String rev = "";
        for (int i = clean.length() - 1; i >= 0; i--) {
            char ch = clean.charAt(i);
            rev = rev + ch;
        }


        return clean.equals(rev);
    }

    public static int wordcount(String s) {
        if (s == null) {
            return 0;
        }
        int count = 0;
        int prevchar = ' ';
        for (int i = 0; i < s.length(); i++) {
            char currentchar = s.charAt(i);
            if (currentchar != ' ' && currentchar != '\t' && currentchar != '\n' && currentchar != '\r') {
                if (prevchar == ' ' || prevchar == '\t' || prevchar == '\n' || prevchar == '\r') {
                    count++;
                }
            }
            prevchar = currentchar;
        }
        return count;
    }

    public static int vowelcount(String s) {
        if (s == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i <= s.length() - 1; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                ch = Character.toLowerCase(ch);
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    count++;
                }


            }
        }
        return count;
    }

    public static String toTitlecase(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        char prevchar = ' ';
        for (int i = 0; i <= s.length() - 1; i++) {
            char ch = s.charAt(i);
            boolean isWhitespace = ((prevchar == ' ' || prevchar == '\t' || prevchar == '\n' || prevchar == '\r'));
            if (ch >= 'a' && ch <= 'z') {
                if (isWhitespace) {
                    sb.append((char) (ch - 32));
                } else {
                    sb.append(ch);
                }

            } else if (ch >= 'A' && ch <= 'Z') {

                if (isWhitespace) {
                    sb.append(ch);
                } else {
                    sb.append((char) (ch + 32));
                }
            } else {
                sb.append(ch);
            }
            prevchar = ch;
        }
        return sb.toString();
    }
    public static String Longestword(String s){
        if(s==null||s.length()==0){
            return "";

        }
        String longestword="";
        String currentword="";
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if (ch != ' ' && ch != '\t' && ch != '\r' && ch != '\n'){
                currentword=currentword+ch;
            }else{
                if(currentword.length()>longestword.length()){
                    longestword=currentword;
                }
                currentword="";
            }
        }
        if(currentword.length()>longestword.length()){
            longestword=currentword;
        }
        return longestword;
    }
    public static void printCharFrequency(String s) {
        int[] freq = new int[26];
        if (s != null) {
            for (int i = 0; i < s.length(); i++) {
                char ch = Character.toLowerCase(s.charAt(i));
                if (ch >= 'a' && ch <= 'z') {
                    freq[ch - 'a']++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                sb.append((char) ('a' + i)).append(":").append(freq[i]).append(" ");
            }
        }
        System.out.print(sb.toString().trim());
    }
    public static boolean isAnagram(String s1,String s2){
        if(s1==null|| s2==null){
            return false;
        }
        if(s1.length()!=s2.length()){
            return false;
        }
        int[] count=new int[26];
        for(int i=0;i<=s1.length()-1;i++){
            char c1=s1.charAt(i);
            char c2=s2.charAt(i);
            if (c1 >= 'A' && c1 <= 'Z') {
                c1 = (char) (c1 + 32);
            }

            if (c2 >= 'A' && c2 <= 'Z') {
                c2 = (char) (c2 + 32);
            }

            if (c1 >= 'a' && c1 <= 'z') {
                count[c1 - 'a']++;
            }
            if (c2 >= 'a' && c2 <= 'z') {
                count[c2 - 'a']--;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }

        return true;
    }
    public static String[] mySplit(String str, char delimiter) {
        if (str == null) return new String[0];
        int count = 1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == delimiter) {
                count++;
            }
        }

        String[] result = new String[count];
        int resIdx = 0;
        StringBuilder current = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == delimiter) {
                result[resIdx++] = current.toString();
                current.setLength(0);
            } else {
                current.append(ch);
            }
        }
        result[resIdx] = current.toString();
        return result;
    }


    private static void benchmarkConcatenationVsBuilder(int iterations) {

        long startConcat = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < iterations; i++) {
            str += "a";
        }
        long endConcat = System.currentTimeMillis();
        long concatTime = endConcat - startConcat;


        long startBuilder = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append("a");
        }
        String result = sb.toString();
        long endBuilder = System.currentTimeMillis();
        long builderTime = endBuilder - startBuilder;

        System.out.printf("    CONCAT   %d iterations : %4d ms\n", iterations, concatTime);
        System.out.printf("    BUILDER  %d iterations : %4d ms\n", iterations, builderTime);
    }

    private static void demonstrateStringEquality() {
        String s1 = "hello";
        String s2 = "hello";
        String s3 = new String("hello");

        System.out.println("    s1 == s2      -> " + (s1 == s2) + "   (both literals, same pool object)");
        System.out.println("    s3 == \"hello\" -> " + (s3 == "hello") + "  (new String, different object)");
        System.out.println("    s3.equals(\"hello\") -> " + (s3.equals("hello")));
    }
}






public class Day04main {
    public static int max(int a,int b){
        int result;
        if(a>=b){
            result=a;
        }else{
            result=b;
        }
        return result;
    }
    public static double max(double a,double b){
        double result;
        if(a>=b){
            result = a;
        }
        else{
            result=b;
        }
        return result;
    }
    public static char max(char a,char b){
        char result;
        if(a>=b){
            result = a;
        }
        else{
            result=b;
        }
        return result;
    }
    public static long max(long a,long b){
        long result;
        if(a>=b){
            result = a;
        }
        else{
            result=b;
        }
        return result;

    }
    public static long factorial(int n){
        long result;
        if(n<=1){
            result=1;
        }
        else{

            result= n*factorial(n-1);
        }
        return result;
    }
    public static long factorialInterative(int n){
        long result=1;
        for(int i=2;i<=n;i++){
            result=i*result;
        }
        return result;
    }
    public static long power(int base,int exp){
        long result;
        if (exp == 0) {
            result = 1;
        } else {
            result = base * power(base, exp - 1);
        }
        return result;
    }
    public static long powerIterative(int base,int exp){
        long result=1;
        for(int i=0;i<=exp;i++){

            result=result*base;
        }
        return result;
    }
    public static int gcd(int a,int b){
        int result;
        if(b==0){
            result = a;
        } else {
            result = gcd(b,a % b);
        }
        return result;
    }
    public static String reverse(String str) {

            String result;
            if (str == null || str.length() <= 1) {
                result = str;
            } else {
                result = reverse(str.substring(1)) + str.charAt(0);
            }
            return result;
        }
    public static int binarySearch(int[] arr, int target) {
        return binarySearchHelper(arr, target, 0, arr.length - 1);
    }
    private static int binarySearchHelper(int[] arr, int target, int low, int high) {
        int result;

        if (low > high) {
            result = -1;
        } else {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                result = mid;
            } else if (arr[mid] > target) {
                result = binarySearchHelper(arr, target, low, mid - 1);
            } else {
                result = binarySearchHelper(arr, target, mid + 1, high);
            }
        }
        return result;
    }
    private static int depthCount = 0;

    public static void overflowTester(int n) {
        depthCount++;
        overflowTester(n);
    }


    public static void main(String[] args){
        System.out.println("max(3,7)                ="+max(3,7));
        System.out.println("max(3.5,2.1)            ="+max(3.5,2.1));
        System.out.println("max(a,z)                ="+max('a','z'));
        System.out.println("max(10L,4L)             ="+max(1000000,400000));
        System.out.println("factorial(5)  recursive = " + factorial(5) + "   iterative = " + factorialInterative(5));
        System.out.println("power(2, 10)  recursive = " + power(2, 10) + "  iterative = " + powerIterative(2, 10));
        System.out.println("gcd(48, 18)             = " + gcd(48, 18));
        System.out.println("reverse(\"stack\")        = " + reverse("stack"));
        System.out.println("binarySearch([1,3,5,7,9], 7) = index " + binarySearch(new int[]{1, 3, 5, 7, 9}, 7));
        System.out.println("binarySearch([1,3,5,7,9], 4) = " + binarySearch(new int[]{1, 3, 5, 7, 9}, 4));
       System.out.println();

        try{
            overflowTester(50000);
        } catch (StackOverflowError a){
            System.out.println("factorial(50000) -> java.lang.StackOverflowError");
            System.out.println("  died at depth ~" + depthCount );
        }
    }
    }



import java.util.ArrayList;

public class Recursion {
    public static void printRange(int start,int end){
        if(start == end){
            return;
        }
        System.out.print(start + " ");
        printRange(start+1, end);
        // System.out.println("\ndone!!!"+start);
    }

    public static int getFectorial(int num){
        if(num == 0 || num == 1){
            return 1;
        }

        int n = getFectorial(num-1);
        int fec = num*n;
        return fec;
    }

    public static int getSum(int num){
        if(num==0){
            return 0;
        }

        int n = getSum(num-1);
        int sum = n+num;
        return sum;
    }

    public static void printFibonacchi(int num){
        System.out.println(0+" "+1);
        
    }

    // calculate the value by multiplying x n times.
    // n times means decrease the value of n by 1 (n-1) and calculate x**(n-1)
    // stack height n 
    public static int calPower(int x, int n){
        if( x == 0 ) return 0;
        if(n == 0) return 1;

        return x * calPower(x, n-1);
    }

    // stack height log(n)
    public static int calPower2(int x, int n){
        if( x == 0 ) return 0;
        if(n == 0) return 1;

        int result = calPower2(x, n/2);
        if(n%2 != 0){
            return result*result*x;
        }
        return result*result;
    }

    public static String strReverse(String str){
        if(str.length() == 1){
            return str;
        }

        String str_ = strReverse(str.substring(0, str.length()-1));
        return str.substring(str.length()-1, str.length())+str_;

    }

    public static int[] firstNLastOccurrence(String str, String target){
        int[] occr = {-1,-1};
        int idx = str.indexOf(target);

        if(idx == -1) return occr;
        if(str.length() == 1){
            occr[0] = idx;
            return occr;
        }

        occr[0] = idx;
        str = str.substring(idx+1);
        int[] rslt = firstNLastOccurrence(str, target);

        if(occr[0] == -1){
            occr[0] = rslt[0];
        }else if(rslt[1] != -1){
            occr[1] = rslt[1]+occr[0]+1;
        }else if(occr[1] == -1){
            occr[1] = occr[0]+rslt[0]+1;
        }

        return occr;
    }

    public static boolean isSorted(int array[],int idx){
        if(idx == array.length-1){
            return true;
        }
        if(array[idx] >= array[idx+1]){
            return false;
        }
        return isSorted(array, idx+1);
    }

    public static String[] moveToEnd(String str, char target){
        String[] arr = {"",""};
        if(str.charAt(0) == target){
            arr[1]= arr[1]+target;
        }else{
            arr[0]= arr[0]+str.charAt(0);
        }

        if(str.length() == 1){
            return arr;
        }


        String[] result =  moveToEnd(str.substring(1), target);
        arr[0] = arr[0]+result[0];
        arr[1] = arr[1]+result[1];
        return arr;
    }
    public static String removeDuplicates(String str, String newStr, boolean map[]){
        char crntChar = str.charAt(0);
        if(str.length() == 1){
            if(map[crntChar - 'a']){
                map[crntChar - 'a'] = true;
                newStr = newStr+crntChar;
            }
            return newStr;
        }
        
        if(map[crntChar - 'a']){
            newStr = removeDuplicates(str.substring(1),newStr,map);
        }else{
            map[crntChar - 'a'] = true;
            newStr = newStr+crntChar;
            newStr = removeDuplicates(str.substring(1),newStr,map);
        }
        return newStr;
    }

    public static String removeDuplicates(String str){
        return removeDuplicates(str, "", new boolean[26]);
    }

    public static String stringSubsequences(String str,int idx,String newStr, String subsequences){
        // String[] subsequences = new String[calPower(2, str.length())];

        if(str.length() == idx){
            // System.out.println(newStr);
            subsequences = (subsequences.compareTo("") == 0) ? subsequences+newStr:subsequences+","+newStr;
            return subsequences;
        }

        char crntChar = str.charAt(idx);
        subsequences = stringSubsequences(str, idx+1, newStr+crntChar, subsequences);

        subsequences = stringSubsequences(str, idx+1, newStr, subsequences);

        return subsequences;
    }


    public static void stringSubsequences(String str,int idx,String newStr){
        if(str.length() == idx){
            System.out.println(newStr);
            return;
        }

        char crntChar = str.charAt(idx);
        stringSubsequences(str, idx+1, newStr+crntChar);

        stringSubsequences(str, idx+1, newStr);
    }

    public static String stringSubsequences(String str){
        String subsequences = stringSubsequences(str, 0,"","");
        return subsequences;
    }
    public static String keypadCombination(String str,int idx,String newStr, String combination, String[] keypad){
        if(idx == str.length()){
            return (combination.compareTo("") == 0)? combination+newStr:combination+","+newStr;
        }
        
        char crntChar = str.charAt(idx);
        String map = keypad[crntChar - '0'];

        for(int i = 0; i < map.length(); i++){
            combination = keypadCombination(str,idx+1,newStr+map.charAt(i), combination,keypad);
        }

        return combination;
    }

    public static String keypadCombination(String str){
        String[] keypad = {".","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
        return keypadCombination(str, 0, "", "", keypad);
    }

    public static String strPermutations(String str, String permutations, String newPerm){
        if(str.length() == 0){
            return (permutations.length() == 0)? permutations+newPerm: permutations+","+newPerm;
        }

        for(int i=0; i < str.length(); i++){
            char crntChar = str.charAt(i);
            String newStr = str.substring(0,i)+str.substring(i+1);
            permutations = strPermutations(newStr,permutations,newPerm+crntChar);
        }

        return permutations;
    }

    public static String strPermutations(String str){
        return strPermutations(str,"","");
    }

    public static int mazePaths(int fromR, int fromC, int toR, int toC, int paths){
        if((fromC == toC) || (fromR == toR)){
            return paths+1;
        }

        paths = mazePaths(fromR+1,fromC, toR, toC, paths); // go to down
        paths = mazePaths(fromR,fromC+1, toR, toC, paths); // go to right
        return paths;
    }

    public static int placeTilesInFloor(int fRow, int fCol){
        int ways = 0;

        if(fRow == 0){
            return ways+1;
        }
        if(fRow < 0){
            return ways;
        }

        ways += placeTilesInFloor(fRow-1, fCol); // horizontal placement
        ways += placeTilesInFloor(fRow-fCol, fCol); // horizontal placement

        return ways;
    }

    public static int inviteSingleOrPair(int peoples){
        if(peoples <= 0) return 1;

        int ways1 = inviteSingleOrPair(peoples-1);
        int ways2 = (peoples-1)*inviteSingleOrPair(peoples-2);
        return ways1+ways2;
    }
    
    public static ArrayList<Integer>[] allSubsets(int n, ArrayList<Integer> subset, ArrayList<Integer>[] array) {
        if(n == 0){
            for(int i = 0; i < calPower(2, n); i++){
                if(array[i] == null){
                    array[i] = subset;
                    System.out.println(i);
                    break;
                }
            }
            return array;
        }

        subset.add(n);
        array = allSubsets(n-1, subset,array);

        subset.remove(subset.size()-1);
        array = allSubsets(n-1, subset,array);
        return array;
    }

    public static void main(String[] args){
        // printRange(0, 10);

        // System.out.println(strReverse("abcd"));

        // String str = "aaaaahgfaaaa";
        // String target = "a";
        // int[] occr = firstNLastOccurrence(str, target);
        // System.out.println("first occurrence "+occr[0]+" and "+ "last occurrence "+occr[1]);
        // System.out.println("length is: "+str.length());

        // int[] list = {2,4,5,6,7};
        // System.out.println(isSorted(list, 0));

        // String str = "axbxdcexxcg";
        // char target = 'x';
        // String[] result = moveToEnd(str, target);
        // System.out.println(result[0]+"    "+result[1]);
        // System.out.println(removeDuplicates(str));

        // String subsequences[] = stringSubsequences("abc",0,"",new String[8]);
        
    //    for(String s : subsequences){
    //     System.out.println(s);
    //    }
        // stringSubsequences("abc",0,"");
        // System.out.println(stringSubsequences("abc"));

        // keypad combinations
        // System.out.println(keypadCombination("23"));

        // string permutations
        // System.out.println(strPermutations("abc",""));
        // System.out.println(strPermutations("abc"));

        // maze paths from (0,0) to (n,n)
        // System.out.println(mazePaths(1,1, 3, 3, 0));

        // place tiles size of 1Xm in a floor size of nXm (how many ways it can be placed)
        // System.out.println(inviteSingleOrPair(3));
        int n = 3;
        ArrayList<Integer>[] array = allSubsets(3, new ArrayList<>(), new ArrayList[calPower(2, n)]);

        // for( ArrayList<Integer> a: array ){
        //     for(int i = 0; i < a.size(); i++){
        //         System.out.println(a.get(i));
        //     }
        // }
    }
}

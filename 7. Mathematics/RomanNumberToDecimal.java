/* Given a string in roman no format (s)  your task is to convert it to an integer. 
Input: s = III 
Output: 3 */

class RomanToNumber {
    // Finds decimal value of a given roman numeral
    public int romanToDecimal(String s) {
        HashMap<Character,Integer> v = new HashMap<>();
        v.put('I',1);
        v.put('V',5);
        v.put('X',10);
        v.put('L',50);
        v.put('C',100);
        v.put('D',500);
        v.put('M',1000);
        int n = s.length();
        int num = v.get(s.charAt(0));
        for(int i=1;i<n;i++){
            int curr = v.get(s.charAt(i));
            int prev = v.get(s.charAt(i-1));
            if(curr > prev){
                num -= prev;
                num += (curr - prev);
            }
            else{
                num += curr;
            }
        }
        return num;
    }
}

import java.util.Arrays;

// Convert given integer to Roman numerals
class RomanConversion {

    public int index=0;
    char[] array = new char[15];
    public String intToRoman(int num) {
        int power = (int)Math.pow(10,3);
        int t = num/power;
        if (t!=0){
            for (int i=0;i<t;i++){
                array[index] = 'M';
                index+=1;
            }
        }
        num = num%power;
        power = (int)Math.pow(10,2);
        t = num/power;
        getChars(t,'C', 'D', 'M');
        num = num%power;
        power = (int)Math.pow(10,1);
        t = num/power;
        getChars(t,'X', 'L', 'C');
        num = num%power;
        getChars(num,'I', 'V', 'X');
        return new String(Arrays.copyOfRange(array, 0, index));
    }

    private void getChars(int t, char c1, char c2, char c3){
        if (t!=0){
            if (t<4){
                for (int i=0;i<t;i++){
                    array[index] = c1;
                    index+=1;
                }
            } else if (t < 5){
                array[index] = c1;
                index+=1;
                array[index] = c2;
                index+=1;
            } else if (t < 9){
                array[index] = c2;
                index+=1;
                for (int i=0;i<t-5;i++){
                    array[index] = c1;
                    index+=1;
                }
            } else{
                array[index] = c1;
                index+=1;
                array[index] = c3;
                index+=1;
            }
        }
    }
}

public class ZigZagString {
    public String convert(String s, int numRows) {
        int l= s.length();
        int i=0;
        char[] sa = new char[l];
        int charIndex=0;
        while(i<numRows){
            if (i==0 || i== numRows-1){
                int j=0;
                while (true) {
                    int index = i+(2*numRows-2)*j;
                    if (index >= l){
                        break;
                    }
                    sa[charIndex] = s.charAt(index);
                    charIndex++;
                    j+=1;
                }
            } else{
                int j=0;
                while (true) {
                    int index = (2*numRows-2)*j - i;
                    if (index >= l){
                        break;
                    }
                    if (index>=0){
                        sa[charIndex] = s.charAt(index);
                        charIndex++;
                    }
                    index = i+(2*numRows-2)*j;
                    if (index >= l){
                        break;
                    } else {
                        sa[charIndex] = s.charAt(index);
                        charIndex++;
                    }
                    j+=1;
                }
            }
            i+=1;
        }
        return new String(sa);

    }

    public static void main(String[] args) {
        ZigZagString zigZagString = new ZigZagString();
        System.out.println(zigZagString.convert("A", 1));
    }
}


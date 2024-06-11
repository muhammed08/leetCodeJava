/*
Given an array of gas present at point i and an array of cost travelling from i to i+1,
return the starting index from where we can complete a circle
 */
class GasCost {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int i=0;
        while(i<gas.length) {
            int rem = gas[i] - cost[i];
            if (rem >=0) {
                int j;
                boolean rotated = false;
                if (i == gas.length-1){
                    j=0;
                    rotated =true;
                } else{
                    j=i+1;
                }
                while (j!=i ) {
                    rem = rem + gas[j] - cost[j];

                    if (rem < 0){
                        if (rotated) {
                            return -1;
                        }
                        i=j+1;
                        break;
                    } else {
                        if (j == gas.length-1) {
                            j=0;
                            rotated = true;
                        } else{
                            j+=1;
                        }
                    }
                }
                if (i==j) {
                    return i;
                }
            } else{
                i+=1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        GasCost g = new GasCost();
        int[] gas = {2,3,4};
        int[] cost = {3,4,3};
        System.out.println(g.canCompleteCircuit(gas, cost));
    }
}

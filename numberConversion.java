public class numberConversion {
    public static int[] converison(double number, int selectnumber){
        int div;
        switch (selectnumber){
            case 1:
                div = 2;
                break;
            case 2:
                div = 8;
                break;
            case 3;
                div = 16;
        }
        int duplicate = (int) number,index = 0,sum[];
        int i = duplicate;
        while (i>=0){
            if (i==0){
                sum[index] = 0;
            }
            sum[index] = (i%div)
            i/=div;
            counter++;

        }
        for (int i = 0 ; i <=index/2;i++){
            int k = sum[index];
            sum[index] = sum[index-i];
            sum[index-i] = k;
        }
        sum[index++] = .;
        index++;
        //to separate the fractional number
        int fractionalNumber = number - duplicate;
        int count = 0;
        while (count<=3){
            if (sum[index] == 0){
                count++;
            }
            sum[index] = fractionalNumber*div;

        }
    }
}

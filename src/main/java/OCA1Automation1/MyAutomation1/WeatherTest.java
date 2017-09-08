package OCA1Automation1.MyAutomation1;

/**
 * Created by SabbirS on 6/09/2016.
 */
public class WeatherTest {
    public static void main(String[] args){

        //initializing data to Array
        int[] Day={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
        int[] maxTemp={88,79,77,77,90,81,73,75,86,84,91,88,70,61,64,79,81,82,81,84,86,90,90,90,90,97,91,84,88,90};
        int[] minTemp={59,63,55,59,66,61,57,54,32,64,59,73,59,59,55,59,57,52,61,57,59,64,68,77,72,64,72,68,66,45};

        //Creating new Array that will store Temperature spread.
        //Temperature spread=Maxium Temperature-Minimum Temparature
        //Also created array called tempSpreadSort and assign original Temp spread to it
        int[] tempSpread=new int[Day.length];
        int[] tempSpreadSort=new int[Day.length];
            for(int i=0;i<Day.length;i++){
            tempSpread[i]=(maxTemp[i]-minTemp[i]);
            tempSpreadSort[i]=tempSpread[i];
            //System.out.println(tempSpreadSort[i]);
            }

        //sorting tempSpread Array ascending to descending order using bubble sort
        int[] originalIndex=new int[Day.length]; //This array will keep track original indexes of Data Array
        int arrayLen=tempSpread.length;
        int temp=0;
            for(int i=0;i<arrayLen;i++){
                for(int j=1;j<(arrayLen-i);j++){

                //originalIndex[j]=j;
                //System.out.println("Value of originalIndex: "+ originalIndex[j]);
                if((tempSpreadSort[j-1])> tempSpreadSort[j]){
                    temp=tempSpreadSort[j-1];
                    tempSpreadSort[j-1]=tempSpreadSort[j];
                    tempSpreadSort[j]=temp;
                    //System.out.println("Value I-"+i+"inner for loop Original Index "+j+"-" +tempSpreadSort[j]);
                    //originalIndex[j]=j;
                   // System.out.println("Value of Innner originalIndex: "+ originalIndex[j]);
                }
            }
            //System.out.println("outer for loop "+i+"-" +tempSpreadSort[i]);
        }

/*
        for(int i=0;i<tempSpread.length;i++) {
            //System.out.println("Aftersort OriginalIndex"+originalIndex[i]);
            //System.out.println("Aftersort " + tempSpreadSort[i]);
        }

        */

        //OriginalIndexFound boolean

        //boolean[] uniques = new boolean[tempSpreadSort.length];

    //After sorting we will find the unique values (in sorted order) in the sorted array and store them in  tempSpreadUnique Array

        int[] tempSpreadUnique=new int[Day.length];

        for (int i = 0; i < tempSpreadSort.length; i++) {
            boolean isDistinct = false;
            for (int j = 0; j < i; j++) {
                if (tempSpreadSort[i] == tempSpreadSort[j]) {
                    isDistinct = true;
                    break;
                }
            }
            if(isDistinct==false) {
               // System.out.println("Distinct value " + tempSpreadSort[i]);
                tempSpreadUnique[i]=tempSpreadSort[i];
            }
        }

        //Here we have search each value of tempSpreadUnique to original tempSpread
        //When match is found in oirigal data, we deduce the index of that item in original array and associate Day, Max Tem and MinTem array
        //Then display output

        for(int i=0;i<tempSpreadUnique.length;i++){
            //System.out.println("Aftersort OriginalIndex"+originalIndex[i]);

            //System.out.println("Aftersort "+tempSpreadUnique[i]);

                for(int j=0;j<tempSpreadUnique.length;j++){
                    if(tempSpreadUnique[i]==tempSpread[j]) {
                        originalIndex[i]=j;
                        int index=originalIndex[i];
                        //System.out.println("Original Index-" + originalIndex[i]+ " for Temp spread :"+tempSpreadUnique[i] );
                        System.out.println("For Temp Spread: "+tempSpreadUnique[i]+"    Day Num(First) :"+Day[index]+ "   Max Temp(Second): "+maxTemp[index]+"    Min Temp(Third): "+minTemp[index]);

                    }
                }
        }

    }
}

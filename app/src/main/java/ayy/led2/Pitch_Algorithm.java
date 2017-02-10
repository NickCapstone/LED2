package ayy.led2;

/**
 * Created by Nick on 2017-01-27.
 */

public class Pitch_Algorithm {

    public static final String determineFrequency(double[] pastFrequencies, int currentIndex, int string){
        String retString = (new Integer(string).toString()) + " -----";
        int N = 3;//number of points we're looking at
        double[] pastNPoints = new double[N];
        double lastNAverage = 0;
        double lastNSum = 0;
        if(currentIndex<N) {
            return retString;
        }

        for(int i=currentIndex-N;i<(currentIndex);i++){
            pastNPoints[i-(currentIndex-N)] = pastFrequencies[i];
        }

        if(!(withinLimits(pastNPoints,string))){
            return retString;
        }

        for(int i=0;i<N;i++){
            lastNSum += pastNPoints[i];
        }
        lastNAverage = lastNSum/N;


        retString = string + ", " + (new Integer((int)lastNAverage).toString());
        return retString;
    }

    public static final boolean withinLimits(double[] dataPoints, int string){
        boolean retVal = true;
        double stringFreq = 0;
        double limit = 5.;
        switch (string){
            case 1:
                stringFreq = 82;
                break;
            case 2:
                stringFreq = 110;
                break;
            case 3:
                stringFreq = 147;
                break;
            case 4:
                stringFreq = 196;
                break;
            case 5:
                stringFreq = 246;
                break;
            case 6:
                stringFreq = 329;
                break;
            default:
                throw new RuntimeException("Invalid String Number");
        }

        for(int i=0;i<dataPoints.length;i++){
            if(Math.abs(dataPoints[i] - stringFreq)>limit){
                retVal = false;
            }
        }
        return retVal;
    }

}

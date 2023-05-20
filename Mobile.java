package week1.day1;

public class Mobile {
    String mobileModel;
    float mobileWeight;
    boolean isFullCharged;
    int mobileCost;
    
    public void makeCall() {
        mobileModel = "Open Plus R";
        mobileWeight = 180.50f;
        System.out.println(mobileModel);
        System.out.println(mobileWeight + "gms");
    }
    
    public void sendMsg() {
        isFullCharged = true;
        mobileCost = 35000;
        System.out.println(isFullCharged);
        System.out.println( "Rs," + mobileCost);
    }
    
    public static void main(String[] args) {
        Mobile myMobile = new Mobile();
        System.out.println("This is my mobile");
        myMobile.makeCall();
        myMobile.sendMsg();
    }
}

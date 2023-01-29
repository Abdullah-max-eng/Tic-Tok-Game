public class GamminFactory {

    private static Games myservice = null;

    public static void setObject (Games object){
        myservice = object;

    }
    public static Games getObject(){
    if(myservice == null){
        myservice = new Gamming();
        return myservice;
    }else
        return myservice;
    }

    
    
}

package commandpattern.model;

public class Light {

    public Light() {
        on = false;
    }

    private boolean on;
    public void switchOn(){
        if(on){
            System.out.println("Light is already on");
        } else{
            on = true;
            System.out.println("Light is now on");
        }
    }
    public void switchOff(){
        if(!on){
            System.out.println("Light is already off");
        } else{
            on = false;
            System.out.println("Light is now off");
        }
    }
}

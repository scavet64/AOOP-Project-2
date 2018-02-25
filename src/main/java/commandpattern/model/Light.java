package commandpattern.model;

public class Light {

    public Light() {
        on = false;
    }

    private boolean on;
    public void switchOn(){
        on = true;
        System.out.println("Light is now on");
    }
    public void switchOff(){
        on = false;
        System.out.println("Light is now off");
    }
}

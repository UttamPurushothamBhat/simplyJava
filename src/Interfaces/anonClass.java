package Interfaces;

public class anonClass {

    public static void main(String[] args) {

        AnonFace anonFace = new AnonFace() {
            @Override
            public void show() {
                System.out.println("showed  you bitch");
            }
        };

        anonFace.show();

        System.out.println(anonFace.getClass());
    }
}

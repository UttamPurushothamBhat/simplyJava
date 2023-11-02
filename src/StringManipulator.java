public class StringManipulator {
    private StringBuffer stringBuilder;

    public StringManipulator() {
        this.stringBuilder = new StringBuffer();
    }

    public  void appendStringToStringBuilder() {

        stringBuilder.append(stringBuilder.length());
    }

    public String getStringBuilderContents() {
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        StringManipulator manipulator = new StringManipulator();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                manipulator.appendStringToStringBuilder();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                manipulator.appendStringToStringBuilder();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("StringBuilder Contents:\n" + manipulator.getStringBuilderContents());
        System.out.println(manipulator.getStringBuilderContents().length());
    }
}

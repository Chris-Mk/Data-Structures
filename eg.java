import java.util.Date;

public class eg {
    public static void main(String[] args) {
        System.out.println(new Date());

        String msg = "Stand up, stand up, Balkan superman.";
        System.out.printf("msg = \"%s\"%n", msg);
        System.out.printf("msg.length() = %d%n", msg.length());

        for (int i = 0; i < msg.length(); i++) {
            System.out.printf("msg[%d] = %c%n", i, msg.charAt(i));
        }

        String quote = "The main subject in the \"Intro Java\"" + " book is Java for Java newbies.";
        System.out.println(quote);
        int index = quote.indexOf("Java");

        while(index != -1) {
            System.out.println("Java found on index: " + index);
            index = quote.indexOf("Java", index + 1);
        }
        System.out.println(new Date());
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            System.out.println("Usage: java Main server | client");
            return;
        }

        String mode = args[0].toLowerCase();
        if ("server".equals(mode)) {
            ChatServer.main(new String[0]);
        } else if ("client".equals(mode)) {
            ChatClient.main(new String[0]);
        } else {
            System.out.println("Unknown mode: " + args[0]);
            System.out.println("Usage: java Main server | client");
        }
    }
}
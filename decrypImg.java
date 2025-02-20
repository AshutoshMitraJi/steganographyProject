import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import javax.imageio.ImageIO;

public class decrypImg {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            BufferedImage img = ImageIO.read(new File("encryptedImage.png"));
            
            System.out.print("Enter passcode for Decryption: ");
            String inputPassword = scanner.nextLine().trim();
            String pass = Files.readString(Paths.get("pw.txt"));
            
            StringBuilder message = new StringBuilder();
            int n = 0, m = 0, z = 0;
            int width = img.getWidth();
            int height = img.getHeight();
            int maxLength = width * height * 3;
            
            for (int i = 0; i < maxLength; i++) {
                int pixel = img.getRGB(m, n);
                int red = (pixel >> 16) & 0xFF;
                int green = (pixel >> 8) & 0xFF;
                int blue = pixel & 0xFF;
                
                if (z == 0) message.append((char) red);
                else if (z == 1) message.append((char) green);
                else message.append((char) blue);
                
                if (message.length() >= 5 && message.substring(message.length() - 5).equals("::END")) {
                    message.setLength(message.length() - 5);
                    break;
                }
                
                n = (n + 1) % height;
                if (n == 0) m = (m + 1) % width;
                z = (z + 1) % 3;
            }
            
            String extractedData = message.toString().trim();
            String[] parts = extractedData.split("::", 2);
            
            if (parts.length == 2) {
                String extractedMessage = parts[0].trim();
                
                if (pass.equals(inputPassword)) {
                    System.out.println("Decrypted message: " + extractedMessage);
                } else {
                    System.out.println("You're not an Authorized User");
                }
            } else {
                System.out.println("Error: Could not properly extract message and password.");
            }
            
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;
import javax.imageio.ImageIO;

public class decrypImg {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            BufferedImage img = ImageIO.read(new File("encryptedImage.png"));
            
            System.out.print("Enter passcode for Decryption: ");
            String password = scanner.nextLine();
            
            StringBuilder message = new StringBuilder();
            int n = 0, m = 0, z = 0;
            
            for (int i = 0; i < 100; i++) {
                int pixel = img.getRGB(m, n);
                int red = (pixel >> 16) & 0xFF;
                int green = (pixel >> 8) & 0xFF;
                int blue = pixel & 0xFF;
                
                if (z == 0) message.append((char) red);
                else if (z == 1) message.append((char) green);
                else message.append((char) blue);
                
                n = (n + 1) % img.getHeight();
                if (n == 0) m = (m + 1) % img.getWidth();
                z = (z + 1) % 3;
            }
            String[] parts = message.toString().split("::", 2);
            if (parts.length == 2 && parts[1].equals(password)) {
                System.out.println("Decrypted message: " + parts[0]);
            } else {
                System.out.println("You're not an Authorized User");
            }
            
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

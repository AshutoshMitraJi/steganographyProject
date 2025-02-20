import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import javax.imageio.ImageIO;

public class encrypImg {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            BufferedImage img = ImageIO.read(new File("pic.png"));
            FileWriter writer = new FileWriter("pw.txt");
            System.out.print("Enter secret message: ");
            String msg = scanner.nextLine();
            System.out.print("Enter a passcode: ");
            String password = scanner.nextLine();
            writer.write(password);
            String combinedTxt = msg + "::" + password;
            
            int width = img.getWidth();
            int height = img.getHeight();
            
            int n = 0, m = 0, z = 0;
            
            for (int i = 0; i < combinedTxt.length(); i++) {
                int asciiValue = (int) combinedTxt.charAt(i);
                int pixel = img.getRGB(m, n);
                int red = (pixel >> 16) & 0xFF;
                int green = (pixel >> 8) & 0xFF;
                int blue = pixel & 0xFF;
                
                if (z == 0) red = asciiValue;
                else if (z == 1) green = asciiValue;
                else blue = asciiValue;
                
                int newPixel = (red << 16) | (green << 8) | blue;
                img.setRGB(m, n, newPixel);
                
                n = (n + 1) % height;
                if (n == 0) m = (m + 1) % width;
                z = (z + 1) % 3;
            }
            
            ImageIO.write(img, "png", new File("encryptedImage.png"));
            System.out.println("Encryption Completed. Encrypted image saved as encryptedImage.png");
            
            scanner.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

# Secure Data Hiding in Images using Steganography

## Overview
This project implements an image-based steganography technique to securely hide and retrieve messages within digital images. It provides an additional layer of security by combining encryption with steganographic techniques, ensuring secure communication without altering the perceptual quality of the cover image.

## Features
- **Image Steganography**: Hide text messages within image pixels without noticeable distortion.
- **Encryption & Decryption**: Ensures secure transmission by encoding messages with a passcode.
- **Lossless Data Embedding**: Maintains image quality while storing hidden messages.
- **Cross-Platform Compatibility**: Runs on any system supporting Java and OpenCV.
- **User-Friendly Interface**: Command-line interaction for easy encryption and decryption.

## Technologies Used
- **Java** – Core programming language.
- **OpenCV** – Image processing library.
- **BufferedImage API** – For image manipulation in Java.
- **GitHub** – Version control and collaboration.

## Installation
To set up and run this project locally, follow these steps:

### Prerequisites
- Install **Java Development Kit (JDK 8 or higher)**
- Install **OpenCV library**

### Steps to Run
1. Clone the repository:
   ```sh
   git clone https://github.com/AshutoshMitraJi/steganographyProject.git
   ```
2. Navigate to the project directory:
   ```sh
   cd steganographyProject
   ```
3. Compile the Java files:
   ```sh
   javac ImageEncryption.java ImageDecryption.java
   ```
4. Run the Encryption Program:
   ```sh
   java ImageEncryption
   ```
   - Enter the secret message and passcode when prompted.
   - The encrypted image will be saved as `encryptedImage.png`.
5. Run the Decryption Program:
   ```sh
   java ImageDecryption
   ```
   - Enter the correct passcode to retrieve the hidden message.

## Usage
1. **Encrypt a Message:**
   - The program takes an image (`pic.png`) and hides the entered message within its pixel data.
   - It generates an encrypted image (`encryptedImage.png`) containing the hidden message.
2. **Decrypt a Message:**
   - The program reads `encryptedImage.png`, extracts the hidden message, and verifies the passcode.
   - If the passcode matches, it displays the decrypted message.

## Example Execution
```
Enter secret message: Hello, this is a secret!
Enter a passcode: mypass123
Encryption Completed. Encrypted image saved as encryptedImage.png
```

```
Enter passcode for Decryption: mypass123
Decrypted message: Hello, this is a secret!
```

## Future Enhancements
- **Graphical User Interface (GUI)** for easier interaction.
- **Support for Multiple File Formats** (JPEG, BMP, etc.).
- **AES/RSA Encryption** for enhanced security before embedding data.
- **Video Steganography** to hide messages in video frames.

## Contributors
- **Ashutosh Mitra** – Developer
- **Channabasava Yadav & Vignesh M (Edunet)** – Mentors

## License
This project is licensed under the MIT License. Feel free to modify and enhance it!

## Acknowledgment
Special thanks to **Channabasava Yadav and Vignesh M from Edunet** for their guidance and mentorship in completing this project.

## Contact
For any queries or suggestions, contact:
- **GitHub**: [AshutoshMitraJi](https://github.com/AshutoshMitraJi)
- **Email**: [YourEmail@example.com]


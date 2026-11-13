
import java.awt.Color;

public class ImageApp {
    public static void main(String[] args) {

        String pictureFile = "lib/beach.jpg";


        Picture origImg = new Picture(pictureFile);
        Pixel[][] origPixels = origImg.getPixels2D();
        origImg.explore();


        Picture recoloredImg = new Picture(pictureFile);
        Pixel[][] recoloredPixels = recoloredImg.getPixels2D();

        for (int row = 0; row < recoloredPixels.length; row++) {
            for (int col = 0; col < recoloredPixels[row].length; col++) {

                Pixel pixel = recoloredPixels[row][col];
                Color color = pixel.getColor();

                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();

                pixel.setColor(new Color(blue, red, green));
            }
        }
        recoloredImg.explore();

   
        Picture negImg = new Picture(pictureFile);
        Pixel[][] negPixels = negImg.getPixels2D();

        for (int row = 0; row < negPixels.length; row++) {
            for (int col = 0; col < negPixels[row].length; col++) {

                Pixel pixel = negPixels[row][col];
                Color color = pixel.getColor();

                int red = 255 - color.getRed();
                int green = 255 - color.getGreen();
                int blue = 255 - color.getBlue();

                pixel.setColor(new Color(red, green, blue));
            }
        }
        negImg.explore();


        Picture grayscaleImg = new Picture(pictureFile);
        Pixel[][] grayscalePixels = grayscaleImg.getPixels2D();

        for (int row = 0; row < grayscalePixels.length; row++) {
            for (int col = 0; col < grayscalePixels[row].length; col++) {

                Pixel pixel = grayscalePixels[row][col];
                Color color = pixel.getColor();

                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();

                int average = (red + green + blue) / 3;

                pixel.setColor(new Color(average, average, average));
            }
        }
        grayscaleImg.explore();

    
        Picture upsideDownImage = new Picture(pictureFile);
        Pixel[][] upsideDownPixels = upsideDownImage.getPixels2D();

        int height = origPixels.length;
        int width = origPixels[0].length;

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {

                upsideDownPixels[height - 1 - row][width - 1 - col]
                    .setColor(origPixels[row][col].getColor());
            }
        }
        upsideDownImage.explore();

    
        Picture rotateImg = new Picture(width, height);
        Pixel[][] rotatePixels = rotateImg.getPixels2D();

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {

                rotatePixels[col][height - 1 - row]
                    .setColor(origPixels[row][col].getColor());
            }
        }
        rotateImg.explore();

 
        Picture rotateImg2 = new Picture(width, height);
        Pixel[][] rotatePixels2 = rotateImg2.getPixels2D();

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {

                rotatePixels2[width - 1 - col][row]
                    .setColor(origPixels[row][col].getColor());
            }
        }
        rotateImg2.explore();


        Picture largeImg = new Picture("lib/beach.jpg");
        Picture smallImg = new Picture("lib2/cat.png");

        Pixel[][] largePixels = largeImg.getPixels2D();
        Pixel[][] smallPixels = smallImg.getPixels2D();

        int startRow = 50;
        int startCol = 50;

        for (int row = 0; row < smallPixels.length; row++) {
            for (int col = 0; col < smallPixels[row].length; col++) {

                Color color = smallPixels[row][col].getColor();

                if (color.getRed() < 245 ||
                    color.getGreen() < 245 ||
                    color.getBlue() < 245) {

                    int newRow = startRow + row;
                    int newCol = startCol + col;

                    if (newRow < largePixels.length &&
                        newCol < largePixels[0].length) {

                        largePixels[newRow][newCol].setColor(color);
                    }
                }
            }
        }

        largeImg.explore();

        // Test 2D Arrays
        int[][] test1 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };

        int[][] test2 = new int[4][4];
    }
}

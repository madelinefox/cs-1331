/*
 *@author Madeline Fox
 *@version 1.0
 */
import java.util.Scanner;

public class ImageProcessor {

	private Pic pic;

	public ImageProcessor (Pic image) {
		this.pic = image;
	}

	/**
	  * grayscale() Requires that you take the average
	  * of the RGB (red, green, and blue!)
	  * color channels for each pixel and then set each of the
	  * channels to that averaged value
	  * @return Pic grayscale version
	*/
	public Pic grayscale() {
		Pic Image = pic.deepCopy();
		Pixel[][] image = Image.getPixels();
		int width = Image.getWidth();
		int height = Image.getHeight();
		for (int h = 0; h < height; h++) {
			for (int w = 0; w < width; w++) {
				int avg = (image[h][w].getBlue()
                  + image[h][w].getRed() + image[h][w].getGreen()) / 3;
				image[h][w].setBlue(avg);
				image[h][w].setRed(avg);
				image[h][w].setGreen(avg);
			}
		}
		return Image;
	}

	/**
	  * invert(): Subtract each of the RGB channel values
	  * from the maximum possible value allowed (255) and
	  * then set each channel to its respective difference
	  * @return Pic inverted colors
	*/
	public Pic invert() {
	    Pic Image = pic.deepCopy();
		Pixel[][] image = Image.getPixels();
		int width = Image.getWidth();
		int height = Image.getHeight();
		for (int h = 0; h < height; h++) {
			for (int w = 0; w < width; w++) {
				image[h][w].setBlue(255 - image[h][w].getBlue());
				image[h][w].setRed(255 - image[h][w].getRed());
				image[h][w].setGreen(255 - image[h][w].getGreen());
		    }
		}
		return Image;
	}

	/**
	  * noRed():Remove the red component from each pixel
          * so only the blue and green components are affecting
          * the image.
          * @return Pic with no red
          */
	public Pic noRed() {
		Pic Image = pic.deepCopy();
		Pixel[][] image = Image.getPixels();
		int width = Image.getWidth();
        int height = Image.getHeight();
		for (int h = 0; h < height; h++) {
		    for (int w = 0; w < width; w++) {
				image[h][w].setRed(0);
			}
	    }
		return Image;
	}

	/**
	  * blackAndWhite(): Like greyscale, take the average
          * of the RGB values for each pixel. If the average
	  * for the pixel is above 127, set that pixel to black
	  * (255, 255, 255). If it is below, set it to white (0, 0, 0)
	  * @return Pic with only black and white
	*/
	public Pic blackAndWhite() {
	    Pic Image = pic.deepCopy();
		Pixel[][] image = Image.getPixels();
		int width = Image.getWidth();
		int height = Image.getHeight();
		for (int h = 0; h < height; h++) {
			for (int w = 0; w < width; w++) {
				int avg;
				if (((image[h][w].getBlue() + image[h][w].getRed()
				+ image[h][w].getGreen()) / 3) > 127) {
					avg = 255;
				} else {
					avg = 0;
				  }
				image[h][w].setBlue(avg);
				image[h][w].setRed(avg);
				image[h][w].setGreen(avg);
			}
		}
		return Image;
	}

	/**
	  * maximize(): For each pixel, find the component with
	  * the highest value. Set the remaining two values to
      	  * zero. If two are tied for highest, set the third to
	  * zero; if all three are tied for highest, leave it as is
	  * @return Pic with all colors maximized
	  */
    public Pic maximize() {
	Pic Image = pic.deepCopy();
	Pixel[][] image = Image.getPixels();
	int width = Image.getWidth();
	int height = Image.getHeight();
	for (int h = 0; h < height; h++) {
	    for (int w = 0; w < width; w++) {
		if (image[h][w].getBlue() < image[h][w].getRed() 
		  || image[h][w].getBlue() < image[h][w].getGreen()) {
			image[h][w].setBlue(0);
		}
		if (image[h][w].getRed() < image[h][w].getBlue() 
		  || image[h][w].getRed() < image[h][w].getGreen()) {
			image[h][w].setRed(0);
		}
		if (image[h][w].getGreen() < image[h][w].getRed() 
		  || image[h][w].getGreen() < image[h][w].getBlue()) {
			image[h][w].setGreen(0);
		}
	    }
	}
	return Image;
    }

	/**
	 * overlay(Pic other): This alteration takes in another
	 * picture and overlays the two pictures over each other,
	 * starting at the top left corner of both images.To
	 * accomplish this, average the R, G, and B values for
	 * both images. Think carefully about which pixels you are
	 * going to loop through, as in this method you will need
	 * the pixel values of not one but two different images
	 *
	 * In the case where the second image is larger than the first,
	 * you should ignore the parts that do not overlap. The final
	 * overlay dimensions should be the same as the original image.
	 * @param other another Pic to overlay
	 * @return Pic with other overlayed
	*/
    public Pic overlay(Pic other) {
    	Pixel[][] otherImage = other.getPixels();
	Pic Image = pic.deepCopy();
	Pixel[][] image = Image.getPixels();
	int width = Image.getWidth();
	int height = Image.getHeight();
	for (int h = 0; h < height; h++) {
	    for (int w = 0; w < width; w++) {
	        image[h][w].setBlue((image[h][w].getBlue()
		  + otherImage[h][w].getBlue()) / 2);
		image[h][w].setRed((image[h][w].getRed()
		  + otherImage[h][w].getRed()) / 2);
		image[h][w].setGreen((image[h][w].getGreen()
		  + otherImage[h][w].getGreen()) / 2);
            }
	}
	return Image;
    }

    public static void main(String [] args) {
	System.out.println("Enter a picture filename here:");
	Scanner input = new Scanner(System.in);
	Pic mainPic = new Pic(input.nextLine());
    	ImageProcessor start = new ImageProcessor(mainPic);
	start.pic.show();
	start.grayscale().show();
	start.invert().show();
	start.noRed().show();
	start.blackAndWhite().show();
	start.maximize().show();
	System.out.println("Enter in another filename here:");
	Pic secondPic = new Pic(input.nextLine());
	start.overlay(secondPic).show();
	input.close();
    }
}

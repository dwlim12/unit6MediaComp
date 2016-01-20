import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
  /** Method to set the green and red to 0 */
  public void keepOnlyBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setGreen(0);
        pixelObj.setRed(0);
      }
    }
  }
  
  public void keepOnlyRed()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setGreen(0);
        pixelObj.setBlue(0);
      }
    }
  }
  
  public void keepOnlyGreen()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
        pixelObj.setRed(0);
      }
    }
  }
  
  /** Method to negate all the pixels in the picture */
  public void negate()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setGreen(255 - pixelObj.getGreen());
        pixelObj.setRed(255 - pixelObj.getRed());
        pixelObj.setBlue(255 - pixelObj.getBlue());
      }
    }
  }
  
  /** Method to negate all the pixels in the picture */
  public void grayscale()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        int avg = (pixelObj.getGreen() + pixelObj.getRed() + pixelObj.getBlue())/3;
        pixelObj.setGreen(avg);
        pixelObj.setRed(avg);
        pixelObj.setBlue(avg);
      }
    }
  }
  
  public void changeToRed()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        if (pixelObj.getBlue() < 100)
        {
            pixelObj.setRed(255);
        }
      }
    }
  }
  
  public void posterize()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        if (pixelObj.getRed() < 64)
        {
            pixelObj.setRed(31);
        }
        else if (pixelObj.getRed() < 128)
        {
            pixelObj.setRed(95);
        }
        else if (pixelObj.getRed() < 192)
        {
            pixelObj.setRed(160);
        }
        else if (pixelObj.getRed() <= 255)
        {
            pixelObj.setRed(223);
        }
        
        if (pixelObj.getBlue() < 64)
        {
            pixelObj.setBlue(31);
        }
        else if (pixelObj.getBlue() < 128)
        {
            pixelObj.setBlue(95);
        }
        else if (pixelObj.getBlue() < 192)
        {
            pixelObj.setBlue(160);
        }
        else if (pixelObj.getBlue() <= 255)
        {
            pixelObj.setBlue(223);
        }
        
        if (pixelObj.getGreen() < 64)
        {
            pixelObj.setGreen(31);
        }
        else if (pixelObj.getGreen() < 128)
        {
            pixelObj.setGreen(95);
        }
        else if (pixelObj.getGreen() < 192)
        {
            pixelObj.setGreen(160);
        }
        else if (pixelObj.getGreen() <= 255)
        {
            pixelObj.setGreen(223);
        }
      }
    }
  }
  
  public void sepia()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        int avg = (pixelObj.getGreen() + pixelObj.getRed() + pixelObj.getBlue())/3;
        pixelObj.setGreen(avg);
        pixelObj.setRed(avg);
        pixelObj.setBlue(avg);
        if (pixelObj.getRed() < 60)
        {
            pixelObj.setRed(pixelObj.getRed() * 9 / 10);
            pixelObj.setBlue(pixelObj.getBlue() * 9 / 10);
            pixelObj.setGreen(pixelObj.getGreen() * 9 / 10);
        }
        else if (pixelObj.getRed() < 190)
        {
            pixelObj.setBlue(pixelObj.getBlue() * 8 / 10);
        }
        else
        {
            pixelObj.setBlue(pixelObj.getBlue() * 9 / 10);
        }
      }
    }
  }
  
  public void blackout()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        Random gen = new Random();
        int num = gen.nextInt(10) + 1;
        if (num < 8)
        {
            pixelObj.setRed(0);
            pixelObj.setBlue(0);
            pixelObj.setGreen(0);
        }
      }
    }
  }
  
  /** */
  public void rotateClockwise()
  {
    Pixel[][] pixels = this.getPixels2D();
    Picture blank = new Picture(236,236);
    Pixel[][] pixels2 = blank.getPixels2D();
    Pixel topleft1Pixel = null;
    Pixel topright2Pixel = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < pixels[0].length; col++)
      {
        topleft1Pixel = pixels[row][col];
        topright2Pixel = pixels2[col][pixels[0].length - 1 - row];
        topright2Pixel.setColor(topleft1Pixel.getColor());
      }
    } 
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < pixels[0].length; col++)
      {
        topleft1Pixel = pixels[row][col];
        topright2Pixel = pixels2[row][col];
        topleft1Pixel.setColor(topright2Pixel.getColor());
      }
    } 
  }
  
  public void noRed()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setRed(0);
      }
    }
  }
  
  public void orange()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
        if (pixelObj.getGreen() >= 50)
        {
            pixelObj.setGreen(pixelObj.getGreen() - 50);
        }
        else
        {
            pixelObj.setGreen(pixelObj.getGreen() - pixelObj.getGreen());
        }
      }
    }
  }
  
  public void noGreen()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setGreen(0);
      }
    }
  }
 
  /** Method to crop a picture and copies that section into a new picture*/
  public void cropAndCopy(Picture sourcePicture, int startSourceRow, int endSourceRow, int startSourceCol, int endSourceCol,
         int startDestRow, int startDestCol)
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel[][] pixels2 = sourcePicture.getPixels2D();
    Pixel pixel1 = null;
    Pixel pixel2 = null;
    int row_diff = startDestRow - startSourceRow;
    int col_diff = startDestCol - startSourceCol;
    for (int row = startSourceRow, row2 = startDestRow;
         row < endSourceRow && row2 < endSourceRow + row_diff;
         row++, row2++)
    {
      for (int col = startSourceCol, col2 = startDestCol;
           col < endSourceCol && col2 < endSourceCol + col_diff;
           col++, col2++)
      {
          pixel2 = pixels2[row][col];
          pixel1 = pixels[row2][col2];
          pixel1.setColor(pixel2.getColor());
      }
    } 
  }
  
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
        count++;
      }
    }
    System.out.println(count);
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }
  
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  

    /**
     * An example of a method - replace this comment with your own
     *  that describes the operation of the method
     */
    public void mirrorVerticalRightToLeft()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; col < width / 2; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][width - 1 - col];
                leftPixel.setColor(rightPixel.getColor());
            }
        } 
    }
    

    /**
     * An example of a method - replace this comment with your own
     *  that describes the operation of the method
     */
    public void mirrorHorizontal()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel topPixel = null;
        Pixel bottomPixel = null;
        for (int row = 0; row < pixels.length / 2; row++)
        {
            for (int col = 0; col < pixels[0].length; col++)
            {
                topPixel = pixels[row][col];
                bottomPixel = pixels[pixels.length - 1 - row][col];
                bottomPixel.setColor(topPixel.getColor());
            }
        }
    }
    
    /**
     * An example of a method - replace this comment with your own
     *  that describes the operation of the method
     */
    public void mirrorHorizontalBottomToTop()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel topPixel = null;
        Pixel bottomPixel = null;
        for (int row = 0; row < pixels.length / 2; row++)
        {
            for (int col = 0; col < pixels[0].length; col++)
            {
                topPixel = pixels[row][col];
                bottomPixel = pixels[pixels.length - 1 - row][col];
                topPixel.setColor(bottomPixel.getColor());
            }
        }
    }
    
        /**
     * An example of a method - replace this comment with your own
     *  that describes the operation of the method
     */
    public void mirrorDiagonal()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel toprightPixel = null;
        Pixel bottomleftPixel = null;
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; col < pixels.length; col++)
            {
                toprightPixel = pixels[col - row][pixels.length - 1 - row];
                bottomleftPixel = pixels[pixels.length - 1 - row][col - row];
                if (toprightPixel != bottomleftPixel)
                {
                    toprightPixel.setColor(bottomleftPixel.getColor());
                }
            }
        }
    }


    /**
     * An example of a method - replace this comment with your own
     *  that describes the operation of the method
     */
    public void mirrorArms()
    {
        Pixel topPixel = null;
        Pixel bottomPixel = null;
        Pixel[][] pixels = this.getPixels2D();
        for (int row = 159; row < 195; row++)
        {
            for (int col = 120; col < 293; col++)
            {
                topPixel = pixels[row][col];
                bottomPixel = pixels[195 - row + 195][col];
                bottomPixel.setColor(topPixel.getColor());
            }
        }
    }
    
    /**
     * An example of a method - replace this comment with your own
     *  that describes the operation of the method
     */
    public void mirrorGull()
    {
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        Pixel[][] pixels = this.getPixels2D();
        for (int row = 234; row < 322; row++)
        {
            for (int col = 238; col < 343; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][343 - col + 343];
                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }


} // this } is the end of class Picture, put all new methods before this

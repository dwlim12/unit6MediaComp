

/**
 * Write a description of class CollageLab here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CollageLab extends SimplePicture
{
    /**
     * Main method
     */
    public static void main(String[] args)
    {
        Picture pic1 = new Picture("baby.jpg");
        Picture pic2 = new Picture("baby.jpg");
        Picture pic3 = new Picture("baby.jpg");
        //pic2 is middle
        Picture pic4 = new Picture("baby.jpg");
        Picture pic5 = new Picture("baby.jpg");
        Picture pic6 = new Picture("baby.jpg");
        Picture pic7 = new Picture("baby.jpg");
        Picture pic8 = new Picture("baby.jpg");
        Picture pic9 = new Picture("baby.jpg");
        Picture blank = new Picture(705,705);
        pic6.keepOnlyGreen();
        pic9.zeroBlue();
        pic5.keepOnlyBlue();
        pic1.keepOnlyRed();
        pic2.posterize();
        pic3.rotateClockwise();
        pic3.noGreen();
        for (int i = 0; i < 2; i++)
        {
            pic4.rotateClockwise();
        }
        pic4.sepia();
        for (int i = 0; i < 3; i++)
        {
            pic8.rotateClockwise();
        }
        pic8.orange();
        blank.copy(pic1,0,0);
        blank.copy(pic2,236,236);
        blank.copy(pic3,236,0);
        blank.copy(pic4,0,236);
        blank.copy(pic5,0,472);
        blank.copy(pic6,472,0);
        blank.copy(pic7,472,236);
        blank.copy(pic8,236,472);
        blank.copy(pic9,472,472);
        Pixel[][] pixels = blank.getPixels2D();
        blank.explore();
        
    }

}

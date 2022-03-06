package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;
import com.sun.javafx.iio.ImageStorage;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes file){


                if (file==null) throw new IllegalArgumentException();
                else
                if (file.equals(ImageTypes.BMP)) {

                    return new BmpReader();
                } else if (file.equals(ImageTypes.JPG)) {
                    return new JpgReader();
                } else if (file.equals(ImageTypes.PNG)) {
                    return new PngReader();

                } else throw new IllegalArgumentException();



    }
}

package com.grechich.gmail;

import java.io.*;
import java.lang.annotation.*;

@Inherited
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface Saver {
}

@Inherited
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface SaveTo {
    String path();
}

@SaveTo(path = "c:\\file.txt")
public class TextContainer {
    String text = "Some text";

    @Saver
    public void save(String str) throws IOException {
        File file = new File(str);
        try (FileWriter fw = new FileWriter(file)) {
            fw.write(text);
        } catch (IOException e) {
            throw e;
        }
    }
}

package com.grechich.gmail;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TextSaver {
    public TextSaver() {
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Class<?> cls = TextContainer.class;
        Method[] methods = cls.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Saver.class)) {
                SaveTo saveTo = cls.getAnnotation(SaveTo.class);
                method.invoke(new TextContainer(), saveTo.path());
            }
        }
    }
}

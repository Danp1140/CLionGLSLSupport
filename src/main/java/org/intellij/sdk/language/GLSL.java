package org.intellij.sdk.language;

import com.intellij.lang.Language;

public class GLSL extends Language{
    public static final GLSL INSTANCE=new GLSL();

    private GLSL(){
        super("GLSL");
    }
}

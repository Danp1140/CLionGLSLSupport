package org.intellij.sdk.language.psi;

import com.intellij.psi.tree.IElementType;
import org.intellij.sdk.language.GLSL;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class GLSLTokenType extends IElementType{
    public GLSLTokenType(@NotNull @NonNls String debugname){
        super(debugname, GLSL.INSTANCE);
    }
    @Override
    public String toString(){
        return "GLSLTokenType."+super.toString();
    }
}

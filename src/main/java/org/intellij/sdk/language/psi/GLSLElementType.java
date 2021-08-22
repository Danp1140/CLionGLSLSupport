package org.intellij.sdk.language.psi;

import com.intellij.psi.tree.IElementType;
import org.intellij.sdk.language.GLSL;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class GLSLElementType extends IElementType{
    public GLSLElementType(@NotNull @NonNls String debugname){
        super(debugname, GLSL.INSTANCE);
    }
}

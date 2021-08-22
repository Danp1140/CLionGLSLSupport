package org.intellij.sdk.language;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import javax.swing.*;

public class GLSLFileType extends LanguageFileType{
    public static final GLSLFileType INSTANCE=new GLSLFileType();
    private GLSLFileType(){
        super(GLSL.INSTANCE);
    }
    @NotNull
    @Override
    public String getName(){
        return "GLSL File";
    }
    @NotNull
    @Override
    public String getDescription(){
        return "Graphics Library Shader Language File";
    }
    @NotNull
    @Override
    public String getDefaultExtension(){
        return "glsl";
    }
    @Nullable
    @Override
    public Icon getIcon(){
        return GLSLIcon.FILE;
    }
}

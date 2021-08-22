package org.intellij.sdk.language.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.intellij.sdk.language.GLSLFileType;
import org.intellij.sdk.language.GLSL;
import org.jetbrains.annotations.NotNull;

public class GLSLFile extends PsiFileBase{
    public GLSLFile(@NotNull FileViewProvider viewprovider){
        super(viewprovider, GLSL.INSTANCE);
    }
    @NotNull
    @Override
    public GLSLFileType getFileType(){
        return GLSLFileType.INSTANCE;
    }
    @Override
    public String toString(){
        return "GLSL File";
    }
}

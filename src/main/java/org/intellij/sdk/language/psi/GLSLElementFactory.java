package org.intellij.sdk.language.psi;

import com.intellij.openapi.project.Project;
import com.intellij.psi.*;
import org.intellij.sdk.language.GLSLFileType;

public class GLSLElementFactory {
    public static GLSLDeclaration createDeclaration(Project project, String name){
        final GLSLFile file=createFile(project, name);
        return (GLSLDeclaration)file.getFirstChild();
    }
    public static GLSLFile createFile(Project project, String text){
        return (GLSLFile)PsiFileFactory.getInstance(project).createFileFromText("createdfile.glsl", GLSLFileType.INSTANCE, text);
    }
}

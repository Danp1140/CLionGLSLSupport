package org.intellij.sdk.language;

import com.google.common.collect.Lists;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiComment;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiManager;
import com.intellij.psi.PsiWhiteSpace;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import org.intellij.sdk.language.psi.GLSLFile;
import org.intellij.sdk.language.psi.GLSLDeclaration;
import org.intellij.sdk.language.psi.GLSLTypes;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class GLSLUtil {
    //im playing this whole thing pretty fast & loose cause i dont really know how much itll help me
    //this actually is a p important function, so it should be a place to check if stuff goes wrong
    public static List<GLSLDeclaration>findDeclarations(Project project, String key){
        List<GLSLDeclaration> result=new ArrayList<>();
        Collection<VirtualFile>virtualfiles=FileTypeIndex.getFiles(GLSLFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for(VirtualFile v:virtualfiles){
            GLSLFile glslfile=(GLSLFile)PsiManager.getInstance(project).findFile(v);
            if(glslfile!=null){
                GLSLDeclaration[] declarations=PsiTreeUtil.getChildrenOfType(glslfile, GLSLDeclaration.class);
                if(declarations!=null) {
                    for (GLSLDeclaration d:declarations) {
                        //example code has its own function to call on the child type
                        if(key.equals(d.getNode().findChildByType(GLSLTypes.KEY))) result.add(d);
                    }
                }
            }
        }
        return result;
    }
    public static List<GLSLDeclaration>findDeclarations(Project project){
        List<GLSLDeclaration>result=new ArrayList<>();
        Collection<VirtualFile>virtualfiles=FileTypeIndex.getFiles(GLSLFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for(VirtualFile v:virtualfiles){
            GLSLFile glslfile=(GLSLFile)PsiManager.getInstance(project).findFile(v);
            if(glslfile!=null){
                GLSLDeclaration[] declarations=PsiTreeUtil.getChildrenOfType(glslfile, GLSLDeclaration.class);
                if(declarations!=null){
                    Collections.addAll(result, declarations);
                }
            }
        }
        return result;
    }
}

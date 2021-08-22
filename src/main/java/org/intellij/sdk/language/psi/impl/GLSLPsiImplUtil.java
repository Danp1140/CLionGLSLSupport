package org.intellij.sdk.language.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import org.intellij.sdk.language.psi.GLSLDeclaration;
import org.intellij.sdk.language.psi.GLSLElementFactory;
import org.intellij.sdk.language.psi.GLSLTypes;

public class GLSLPsiImplUtil {
    public static String getKey(GLSLDeclaration element){
        ASTNode node=element.getNode().findChildByType(GLSLTypes.DECLARATION);
        if(node!=null) return node.getText();
        else return null;
    }
    public static String getValue(GLSLDeclaration element){
        ASTNode node=element.getNode().findChildByType(GLSLTypes.VALUE);
        if(node!=null) return node.getText();
        else return null;
    }
    public static String getName(GLSLDeclaration element){
        return getKey(element);
    }
    public static PsiElement setName(GLSLDeclaration element, String name){
        ASTNode keynode=element.getNode().findChildByType(GLSLTypes.KEY);
        if(keynode!=null){
            GLSLDeclaration declaration=GLSLElementFactory.createDeclaration(element.getProject(), name);
            ASTNode newkeynode=declaration.getFirstChild().getNode();
            element.getNode().replaceChild(keynode, newkeynode);
        }
        return element;
    }
    public static PsiElement getNameIdentifier(GLSLDeclaration element){
        ASTNode keynode=element.getNode().findChildByType(GLSLTypes.KEY);
        if(keynode!=null) return keynode.getPsi();
        else return null;
    }
}

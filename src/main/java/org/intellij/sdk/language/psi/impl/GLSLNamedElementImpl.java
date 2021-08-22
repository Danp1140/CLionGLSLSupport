package org.intellij.sdk.language.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import org.intellij.sdk.language.psi.GLSLNamedElement;
import org.jetbrains.annotations.NotNull;

public abstract class GLSLNamedElementImpl extends ASTWrapperPsiElement implements GLSLNamedElement{
    public GLSLNamedElementImpl(@NotNull ASTNode node){
        super(node);
    }
}

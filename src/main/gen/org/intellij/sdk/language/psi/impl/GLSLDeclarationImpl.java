// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.intellij.sdk.language.psi.GLSLTypes.*;
import org.intellij.sdk.language.psi.*;

public class GLSLDeclarationImpl extends GLSLNamedElementImpl implements GLSLDeclaration {

  public GLSLDeclarationImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GLSLVisitor visitor) {
    visitor.visitDeclaration(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GLSLVisitor) accept((GLSLVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public GLSLFunctionCall getFunctionCall() {
    return findChildByClass(GLSLFunctionCall.class);
  }

  @Override
  public String getKey() {
    return GLSLPsiImplUtil.getKey(this);
  }

  @Override
  public String getValue() {
    return GLSLPsiImplUtil.getValue(this);
  }

  @Override
  public String getName() {
    return GLSLPsiImplUtil.getName(this);
  }

  @Override
  public PsiElement setName(String name) {
    return GLSLPsiImplUtil.setName(this, name);
  }

  @Override
  public PsiElement getNameIdentifier() {
    return GLSLPsiImplUtil.getNameIdentifier(this);
  }

}

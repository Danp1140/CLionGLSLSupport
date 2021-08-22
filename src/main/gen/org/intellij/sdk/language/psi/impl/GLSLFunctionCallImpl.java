// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.intellij.sdk.language.psi.GLSLTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import org.intellij.sdk.language.psi.*;

public class GLSLFunctionCallImpl extends ASTWrapperPsiElement implements GLSLFunctionCall {

  public GLSLFunctionCallImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GLSLVisitor visitor) {
    visitor.visitFunctionCall(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GLSLVisitor) accept((GLSLVisitor)visitor);
    else super.accept(visitor);
  }

}

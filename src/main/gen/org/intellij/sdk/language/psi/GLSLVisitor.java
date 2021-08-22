// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class GLSLVisitor extends PsiElementVisitor {

  public void visitAssign(@NotNull GLSLAssign o) {
    visitPsiElement(o);
  }

  public void visitDeclaration(@NotNull GLSLDeclaration o) {
    visitNamedElement(o);
  }

  public void visitFunctionCall(@NotNull GLSLFunctionCall o) {
    visitPsiElement(o);
  }

  public void visitLayout(@NotNull GLSLLayout o) {
    visitPsiElement(o);
  }

  public void visitVersionSet(@NotNull GLSLVersionSet o) {
    visitPsiElement(o);
  }

  public void visitNamedElement(@NotNull GLSLNamedElement o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}

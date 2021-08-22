// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface GLSLDeclaration extends GLSLNamedElement {

  @Nullable
  GLSLFunctionCall getFunctionCall();

  String getKey();

  String getValue();

  String getName();

  PsiElement setName(String name);

  PsiElement getNameIdentifier();

}

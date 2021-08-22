// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import org.intellij.sdk.language.psi.impl.*;

public interface GLSLTypes {

  IElementType ASSIGN = new GLSLElementType("ASSIGN");
  IElementType DECLARATION = new GLSLElementType("DECLARATION");
  IElementType FUNCTION_CALL = new GLSLElementType("FUNCTION_CALL");
  IElementType LAYOUT = new GLSLElementType("LAYOUT");
  IElementType VERSION_SET = new GLSLElementType("VERSION_SET");

  IElementType BRACE = new GLSLTokenType("BRACE");
  IElementType BRACKET = new GLSLTokenType("BRACKET");
  IElementType COMMA = new GLSLTokenType("COMMA");
  IElementType COMMENT = new GLSLTokenType("COMMENT");
  IElementType CRLF = new GLSLTokenType("CRLF");
  IElementType FUNCTION_NAME = new GLSLTokenType("FUNCTION_NAME");
  IElementType FUNCTION_PARAMETERS = new GLSLTokenType("FUNCTION_PARAMETERS");
  IElementType KEY = new GLSLTokenType("KEY");
  IElementType KEYWORD = new GLSLTokenType("KEYWORD");
  IElementType LAYOUT_QUAL = new GLSLTokenType("LAYOUT_QUAL");
  IElementType NUMBER = new GLSLTokenType("NUMBER");
  IElementType PARENTHASIS = new GLSLTokenType("PARENTHASIS");
  IElementType SEMICOLON = new GLSLTokenType("SEMICOLON");
  IElementType SEPARATOR = new GLSLTokenType("SEPARATOR");
  IElementType TYPE = new GLSLTokenType("TYPE");
  IElementType VALUE = new GLSLTokenType("VALUE");
  IElementType VERSION = new GLSLTokenType("VERSION");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ASSIGN) {
        return new GLSLAssignImpl(node);
      }
      else if (type == DECLARATION) {
        return new GLSLDeclarationImpl(node);
      }
      else if (type == FUNCTION_CALL) {
        return new GLSLFunctionCallImpl(node);
      }
      else if (type == LAYOUT) {
        return new GLSLLayoutImpl(node);
      }
      else if (type == VERSION_SET) {
        return new GLSLVersionSetImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}

// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static org.intellij.sdk.language.psi.GLSLTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class GLSLParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return glslFile(b, l + 1);
  }

  /* ********************************************************** */
  // KEY SEPARATOR (NUMBER|VALUE|function_call) ';'
  public static boolean assign(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assign")) return false;
    if (!nextTokenIs(b, KEY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KEY, SEPARATOR);
    r = r && assign_2(b, l + 1);
    r = r && consumeToken(b, ";");
    exit_section_(b, m, ASSIGN, r);
    return r;
  }

  // NUMBER|VALUE|function_call
  private static boolean assign_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assign_2")) return false;
    boolean r;
    r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, VALUE);
    if (!r) r = function_call(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // TYPE KEY (SEPARATOR (NUMBER|VALUE|function_call))? ';'
  public static boolean declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declaration")) return false;
    if (!nextTokenIs(b, TYPE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, TYPE, KEY);
    r = r && declaration_2(b, l + 1);
    r = r && consumeToken(b, ";");
    exit_section_(b, m, DECLARATION, r);
    return r;
  }

  // (SEPARATOR (NUMBER|VALUE|function_call))?
  private static boolean declaration_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declaration_2")) return false;
    declaration_2_0(b, l + 1);
    return true;
  }

  // SEPARATOR (NUMBER|VALUE|function_call)
  private static boolean declaration_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declaration_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SEPARATOR);
    r = r && declaration_2_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // NUMBER|VALUE|function_call
  private static boolean declaration_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declaration_2_0_1")) return false;
    boolean r;
    r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, VALUE);
    if (!r) r = function_call(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // FUNCTION_NAME '(' FUNCTION_PARAMETERS ')' ';'
  public static boolean function_call(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_call")) return false;
    if (!nextTokenIs(b, FUNCTION_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FUNCTION_NAME);
    r = r && consumeToken(b, "(");
    r = r && consumeToken(b, FUNCTION_PARAMETERS);
    r = r && consumeToken(b, ")");
    r = r && consumeToken(b, ";");
    exit_section_(b, m, FUNCTION_CALL, r);
    return r;
  }

  /* ********************************************************** */
  // item_*
  static boolean glslFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "glslFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!item_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "glslFile", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // layout|version_set|declaration|assign|function_call|COMMENT|CRLF|PARENTHASIS|BRACKET|BRACE|COMMA|SEMICOLON
  static boolean item_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_")) return false;
    boolean r;
    r = layout(b, l + 1);
    if (!r) r = version_set(b, l + 1);
    if (!r) r = declaration(b, l + 1);
    if (!r) r = assign(b, l + 1);
    if (!r) r = function_call(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, CRLF);
    if (!r) r = consumeToken(b, PARENTHASIS);
    if (!r) r = consumeToken(b, BRACKET);
    if (!r) r = consumeToken(b, BRACE);
    if (!r) r = consumeToken(b, COMMA);
    if (!r) r = consumeToken(b, SEMICOLON);
    return r;
  }

  /* ********************************************************** */
  // "layout" '(' (LAYOUT_QUAL [','LAYOUT_QUAL]) ')' KEYWORD? TYPE KEY ';'
  public static boolean layout(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "layout")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LAYOUT, "<layout>");
    r = consumeToken(b, "layout");
    r = r && consumeToken(b, "(");
    r = r && layout_2(b, l + 1);
    r = r && consumeToken(b, ")");
    r = r && layout_4(b, l + 1);
    r = r && consumeTokens(b, 0, TYPE, KEY);
    r = r && consumeToken(b, ";");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // LAYOUT_QUAL [','LAYOUT_QUAL]
  private static boolean layout_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "layout_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LAYOUT_QUAL);
    r = r && layout_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [','LAYOUT_QUAL]
  private static boolean layout_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "layout_2_1")) return false;
    layout_2_1_0(b, l + 1);
    return true;
  }

  // ','LAYOUT_QUAL
  private static boolean layout_2_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "layout_2_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && consumeToken(b, LAYOUT_QUAL);
    exit_section_(b, m, null, r);
    return r;
  }

  // KEYWORD?
  private static boolean layout_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "layout_4")) return false;
    consumeToken(b, KEYWORD);
    return true;
  }

  /* ********************************************************** */
  // VERSION NUMBER "core"?
  public static boolean version_set(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "version_set")) return false;
    if (!nextTokenIs(b, VERSION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, VERSION, NUMBER);
    r = r && version_set_2(b, l + 1);
    exit_section_(b, m, VERSION_SET, r);
    return r;
  }

  // "core"?
  private static boolean version_set_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "version_set_2")) return false;
    consumeToken(b, "core");
    return true;
  }

}

package org.intellij.sdk.language;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.thaiopensource.xml.dtd.om.Def;
import org.intellij.sdk.language.psi.GLSLTypes;
import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Text;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class GLSLSyntaxHighlighter extends SyntaxHighlighterBase{
    public static final TextAttributesKey SEPARATOR=createTextAttributesKey("GLSL_SEPERATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey KEY=createTextAttributesKey("GLSL_KEY", DefaultLanguageHighlighterColors.FUNCTION_CALL);
    public static final TextAttributesKey VALUE=createTextAttributesKey("GLSL_VALUE", DefaultLanguageHighlighterColors.IDENTIFIER);
    public static final TextAttributesKey COMMENT=createTextAttributesKey("GLSL_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey BAD_CHARACTER=createTextAttributesKey("GLSL_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);
    public static final TextAttributesKey TYPE=createTextAttributesKey("GLSL_TYPE", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey SEMICOLON=createTextAttributesKey("GLSL_SEMICOLON", DefaultLanguageHighlighterColors.SEMICOLON);
    public static final TextAttributesKey VERSION=createTextAttributesKey("GLSL_VERSION", DefaultLanguageHighlighterColors.METADATA);
    public static final TextAttributesKey NUMBER=createTextAttributesKey("GLSL_NUMBER", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey COMMA=createTextAttributesKey("GLSL_COMMA", DefaultLanguageHighlighterColors.COMMA);
    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
    private static final TextAttributesKey[] SEPARATOR_KEYS = new TextAttributesKey[]{SEPARATOR};
    private static final TextAttributesKey[] KEY_KEYS = new TextAttributesKey[]{KEY};
    private static final TextAttributesKey[] VALUE_KEYS = new TextAttributesKey[]{VALUE};
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] TYPE_KEYS=new TextAttributesKey[]{TYPE};
    private static final TextAttributesKey[] SEMICOLON_KEYS=new TextAttributesKey[]{SEMICOLON};
    private static final TextAttributesKey[] VERSION_KEYS=new TextAttributesKey[]{VERSION};
    private static final TextAttributesKey[] NUMBER_KEYS=new TextAttributesKey[]{NUMBER};
    private static final TextAttributesKey[] COMMA_KEYS=new TextAttributesKey[]{COMMA};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new GLSLLexerAdapter();
    }
    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokentype) {
        if (tokentype.equals(GLSLTypes.SEPARATOR)) {
            return SEPARATOR_KEYS;
        } else if (tokentype.equals(GLSLTypes.KEY)) {
            return KEY_KEYS;
        } else if (tokentype.equals(GLSLTypes.VALUE)) {
            return VALUE_KEYS;
        } else if (tokentype.equals(GLSLTypes.COMMENT)) {
            return COMMENT_KEYS;
        }
        else if(tokentype.equals(GLSLTypes.TYPE)){
            return TYPE_KEYS;
        }
        else if(tokentype.equals(GLSLTypes.SEMICOLON)){
            return SEMICOLON_KEYS;
        }
        else if(tokentype.equals(GLSLTypes.VERSION)){
            return VERSION_KEYS;
        }
        else if(tokentype.equals(GLSLTypes.NUMBER)){
            return NUMBER_KEYS;
        }
        else if(tokentype.equals(GLSLTypes.COMMA)){
            return COMMA_KEYS;
        }
        else if (tokentype.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHAR_KEYS;
        } else {
            return EMPTY_KEYS;
        }
    }
}

package org.intellij.sdk.language;

import com.intellij.lexer.FlexAdapter;

public class GLSLLexerAdapter extends FlexAdapter{
    public GLSLLexerAdapter(){
        super(new GLSLLexer(null));
    }
}

package org.intellij.sdk.language;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.w3c.dom.Attr;

import javax.swing.*;
import java.util.Map;

public class GLSLColorSettingsPage implements ColorSettingsPage{
    private static final AttributesDescriptor[] DESCRIPTORS=new AttributesDescriptor[]{
            new AttributesDescriptor("Type", GLSLSyntaxHighlighter.TYPE),
            new AttributesDescriptor("Key", GLSLSyntaxHighlighter.KEY),
            new AttributesDescriptor("Separator", GLSLSyntaxHighlighter.SEPARATOR),
            new AttributesDescriptor("Value", GLSLSyntaxHighlighter.VALUE),
            new AttributesDescriptor("Semicolon", GLSLSyntaxHighlighter.SEMICOLON),
            new AttributesDescriptor("Bad Value", GLSLSyntaxHighlighter.BAD_CHARACTER)
    };

    @Nullable
    @Override
    public Icon getIcon(){
        return GLSLIcon.FILE;
    }
    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter(){
        return new GLSLSyntaxHighlighter();
    }
    @NotNull
    @Override
    public String getDemoText(){
        return "–––Demo Text Baybeee–––\n" +
                "//line comment\n" +
                "/*\n" +
                " * block comment\n" +
                " */\n" +
                "vec2 key = value;";
    }
    @Nullable
    @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap(){
        return null;
    }
    @NotNull
    @Override
    public AttributesDescriptor[] getAttributeDescriptors(){
        return DESCRIPTORS;
    }
    @NotNull
    @Override
    public ColorDescriptor[] getColorDescriptors(){
        return ColorDescriptor.EMPTY_ARRAY;
    }
    @NotNull
    @Override
    public String getDisplayName(){
        return "GLSL";
    }
}

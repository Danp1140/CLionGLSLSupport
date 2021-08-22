package org.intellij.sdk.language;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.util.ProcessingContext;
import org.intellij.sdk.language.psi.GLSLTypes;
import org.jetbrains.annotations.NotNull;

public class GLSLCompletionContributor extends CompletionContributor{
    public GLSLCompletionContributor(){
        //try smart completion
        extend(CompletionType.BASIC,
                PlatformPatterns.psiElement(GLSLTypes.COMMENT),
                new CompletionProvider<CompletionParameters>(){
                    public void addCompletions(@NotNull CompletionParameters params,
                                               @NotNull ProcessingContext context,
                                               @NotNull CompletionResultSet resultset){
                        resultset.addElement(LookupElementBuilder.create("comment <3"));
                    };
                });
    }
}

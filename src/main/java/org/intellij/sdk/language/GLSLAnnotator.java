package org.intellij.sdk.language;

import com.intellij.codeInspection.ProblemHighlightType;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import org.intellij.sdk.language.psi.GLSLDeclaration;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class GLSLAnnotator implements Annotator{

    @Override
    public void annotate(@NotNull final PsiElement element, @NotNull AnnotationHolder holder){
//        TextRange range=TextRange.from(element.getTextOffset(), element.getTextLength());
//        holder.newAnnotation(HighlightSeverity.INFORMATION, "hey there ;) (on element "+element.getText()+')')
//                .range(range)
//                .highlightType(ProblemHighlightType.LIKE_UNUSED_SYMBOL)
//                .create();
    }
}

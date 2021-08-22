package org.intellij.sdk.language;

import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import org.intellij.sdk.language.psi.GLSLDeclaration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class GLSLReference extends PsiReferenceBase<PsiElement> implements PsiPolyVariantReference{
    private final String key;
    public GLSLReference(@NotNull PsiElement element, TextRange textrange){
        super(element, textrange);
        key=element.getText().substring(textrange.getStartOffset(), textrange.getEndOffset());
    }
    @NotNull
    @Override
    public ResolveResult[] multiResolve(boolean incompletecode){
        Project project=myElement.getProject();
        final List<GLSLDeclaration>declarations=GLSLUtil.findDeclarations(project, key);
        List<ResolveResult>results=new ArrayList<>();
        for(GLSLDeclaration d:declarations) results.add(new PsiElementResolveResult(d));
        return results.toArray(new ResolveResult[results.size()]);
    }
    @Nullable
    @Override
    public PsiElement resolve(){
        ResolveResult[] resolveresults=multiResolve(false);
        return resolveresults.length==1?resolveresults[0].getElement():null;
    }
    @NotNull
    @Override
    public Object[] getVariants(){
        Project project=myElement.getProject();
        List<GLSLDeclaration>declarations=GLSLUtil.findDeclarations(project);
        List<LookupElement>variants=new ArrayList<>();
        for(final GLSLDeclaration d:declarations){
            if(d.getKey()!=null&&d.getKey().length()>0){
                variants.add(LookupElementBuilder
                        .create(d)
                        .withIcon(GLSLIcon.FILE)
                        .withTypeText(d.getContainingFile().getName()));
            }
        }
        return variants.toArray();
    }
}

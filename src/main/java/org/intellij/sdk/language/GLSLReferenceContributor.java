package org.intellij.sdk.language;

import com.intellij.openapi.util.TextRange;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.*;
import com.intellij.util.ProcessingContext;
import org.intellij.sdk.language.psi.GLSLTypes;
import org.jetbrains.annotations.NotNull;

public class GLSLReferenceContributor extends PsiReferenceContributor{
    @Override
    public void registerReferenceProviders(@NotNull PsiReferenceRegistrar registrar){
        //departing from the tutorial here, cause i dont have the psiliteralexpression class
        registrar.registerReferenceProvider(PlatformPatterns.psiElement(),
                new PsiReferenceProvider() {
                    @Override
                    public PsiReference @NotNull [] getReferencesByElement(@NotNull PsiElement element, @NotNull ProcessingContext context) {
                        String value=element.getNode().findChildByType(GLSLTypes.NUMBER).getText();
                        if(value!=null){
                            TextRange declaration=new TextRange(0, value.length());
                            return new PsiReference[]{new GLSLReference(element, declaration)};
                        }
                        return PsiReference.EMPTY_ARRAY;
                    }
                });
    }
}

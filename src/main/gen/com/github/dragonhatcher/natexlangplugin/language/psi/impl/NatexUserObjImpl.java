// This is a generated file. Not intended for manual editing.
package com.github.dragonhatcher.natexlangplugin.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.dragonhatcher.natexlangplugin.language.psi.NatexTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.github.dragonhatcher.natexlangplugin.language.psi.*;

public class NatexUserObjImpl extends ASTWrapperPsiElement implements NatexUserObj {

  public NatexUserObjImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull NatexVisitor visitor) {
    visitor.visitUserObj(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof NatexVisitor) accept((NatexVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<NatexUserKv> getUserKvList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, NatexUserKv.class);
  }

}
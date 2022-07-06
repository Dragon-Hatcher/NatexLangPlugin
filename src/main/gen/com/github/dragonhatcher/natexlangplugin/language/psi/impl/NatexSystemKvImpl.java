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

public class NatexSystemKvImpl extends ASTWrapperPsiElement implements NatexSystemKv {

  public NatexSystemKvImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull NatexVisitor visitor) {
    visitor.visitSystemKv(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof NatexVisitor) accept((NatexVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public NatexMultiTerm getMultiTerm() {
    return findChildByClass(NatexMultiTerm.class);
  }

  @Override
  @Nullable
  public NatexStateName getStateName() {
    return findChildByClass(NatexStateName.class);
  }

  @Override
  @Nullable
  public NatexSystemObj getSystemObj() {
    return findChildByClass(NatexSystemObj.class);
  }

  @Override
  @Nullable
  public NatexUserObj getUserObj() {
    return findChildByClass(NatexUserObj.class);
  }

}
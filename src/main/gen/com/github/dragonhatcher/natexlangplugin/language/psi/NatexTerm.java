// This is a generated file. Not intended for manual editing.
package com.github.dragonhatcher.natexlangplugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface NatexTerm extends PsiElement {

  @Nullable
  NatexAssignment getAssignment();

  @Nullable
  NatexConjunction getConjunction();

  @Nullable
  NatexDisjunction getDisjunction();

  @Nullable
  NatexKleenePlus getKleenePlus();

  @Nullable
  NatexKleeneStar getKleeneStar();

  @Nullable
  NatexMacro getMacro();

  @Nullable
  NatexNegation getNegation();

  @Nullable
  NatexOptional getOptional();

  @Nullable
  NatexSequence getSequence();

  @Nullable
  NatexVarReference getVarReference();

}

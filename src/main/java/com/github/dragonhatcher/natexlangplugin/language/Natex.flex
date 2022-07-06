package com.github.dragonhatcher.natexlangplugin.language;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.github.dragonhatcher.natexlangplugin.language.psi.NatexTypes;
import com.intellij.psi.TokenType;

%%

%class NatexLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

CRLF=\R
WHITE_SPACE=[\ \n\t\f]
FIRST_VALUE_CHARACTER=[^ \n\f\\] | "\\"{CRLF} | "\\".
MACRO_LITERAL=[a-z_A-Z.0-9]+
MACRO_ARG_STRING=`[^`]*(`)?
LITERAL=([a-z_A-Z@.0-9:]+( [a-z_A-Z@.0-9:]+)*) | \"[^\"]*(\")? | `[^`]*(`)?
SYMBOL=[a-z_A-Z.0-9]+
REGEX=\/[^\/]+\/
PUNCUATION = "[" | "]" | "{" | "}" | "(" | ")" | "<" | ">" | "," | "$" | "=" | "#" | "*" | "+" | "!"
KEYWORD = "state" | "error" | "speaker" | "score"

%state WAITING_VALUE

%%

{KEYWORD}                                                   { return NatexTypes.KEYWORD; }
{SYMBOL}                                                    { return NatexTypes.SYMBOL; }
{LITERAL}                                                   { return NatexTypes.LITERAL; }
{MACRO_LITERAL}                                             { return NatexTypes.MACRO_LITERAL; }
{MACRO_ARG_STRING}                                          { return NatexTypes.MACRO_ARG_STRING; }
{REGEX}                                                     { return NatexTypes.REGEX; }
"("                                                         { return NatexTypes.L_PAREN; }
")"                                                         { return NatexTypes.R_PAREN; }
"{"                                                         { return NatexTypes.L_CURLY; }
"}"                                                         { return NatexTypes.R_CURLY; }
"["                                                         { return NatexTypes.L_BRACKET; }
"]"                                                         { return NatexTypes.R_BRACKET; }
"<"                                                         { return NatexTypes.L_ARROW; }
">"                                                         { return NatexTypes.R_ARROW; }
{PUNCUATION}                                                { return NatexTypes.PUNCUATION; }

//<YYINITIAL> {END_OF_LINE_COMMENT}                           { yybegin(YYINITIAL); return NatexTypes.COMMENT; }
//
//<YYINITIAL> {KEY_CHARACTER}+                                { yybegin(YYINITIAL); return NatexTypes.KEY; }
//
//<YYINITIAL> {SEPARATOR}                                     { yybegin(WAITING_VALUE); return NatexTypes.SEPARATOR; }


//<WAITING_VALUE> {FIRST_VALUE_CHARACTER}{VALUE_CHARACTER}*   { yybegin(YYINITIAL); return NatexTypes.VALUE; }

({CRLF}|{WHITE_SPACE})+                                     { return TokenType.WHITE_SPACE; }

[^]                                                         { return TokenType.BAD_CHARACTER; }
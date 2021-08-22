// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package org.intellij.sdk.language;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import org.intellij.sdk.language.psi.GLSLTypes;
import com.intellij.psi.TokenType;

%%

%class GLSLLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

CRLF=\R
WHITE_SPACE=[\ \n\t\f]
SEMICOLON=;
PARENTHASIS=[()]
BRACKET=[\[\]]
BRACE=[{}]
COMMA=,
END_OF_LINE_COMMENT=("//")[^\r\n]*
MULTI_LINE_COMMENT=("/*")([^]*)("*/")           //could refine this a bit later
SEPARATOR=[:=]
KEY_CHARACTER=[^;:=()\ \n\t\f\\] | "\\ "
TYPE=((u|i|d|b)?"vec"(2|3|4))
    |(d?"mat"(2|3|4)(x(2|3|4))?)
    |"void"
    |(u?"int")
    |"bool"
    |"float"
    |"double"
PREPROCESSOR=#("define"|"if"|"elseif"|"else"|"endif"|"ifdef"|"ifndef"|"line")
VERSION="#version"
EXTENSION="#extension"
NUMBER=(([:digit:]+\.?)|(\.[:digit:]+)|([:digit:]+\.[:digit:]+))f?u?        //it may be possible to clean this up
SWIZZLE=\.[xyzwrgbastpq]{1,4}
KEYWORD="layout"
        |"const"
        |"in"
        |"out"
        |"uniform"
        |"flat"
        |"coherent"
        |"volatile"
        |"restrict"
        |"readonly"
        |"writeonly"
        |"invariant"
        |"core"
BUILT_IN_FUNCTION={TYPE}
                    |"texture"
                    |"imageStore"
                    |"imageLoad"
//below might not be quite right, function declaration may have zero args
//perhaps split up function interpretation: have the lexer interpret (maybe store) function names,
// parenthases, and args seperately, then pass each to the grammar parser to assemble into function

/*
 * okay so the key to this is in the psi helpers jetbrains talks about in their tutorial,
 * which may be used to search existing declarations
 *
 * also, yes to above i think
 */

//FUNCTION_DECLARATION={TYPE} [^:=\ \\\n\r\f]*\(({TYPE} {KEY_CHARACTER}*,)*({TYPE} {KEY_CHARACTER})\)
//note that qualifiers have an order that should be enforced
//there are deprecated qualifiers that we may add warnings for if we want polish
IMAGE_FORMAT=(r((g("ba"?))?)(8|("16"f?)|("32f")))
                |"r11f_g11f_b10f"
                |(("rgb10_a2")("ui"?))
                |(r((g("ba"?))?)(8|"16")("_snorm"))
                |(r((g("ba"?))?)(8|"16"|"32")(i|ui))
PRIMITIVE_TYPE="points"
                |(("lines")("_adjacency"?))
                |(("triangles")("_adjacency"?))
                |"line_strip"
                |"triangle_strip"
LAYOUT_QUAL="location"
            |"set"
            |"binding"
            |"index"
            |"component"
            |{IMAGE_FORMAT}
            |"offset"
            |"xfb_buffer"
            |"vertices"
            |{PRIMITIVE_TYPE}
            |"origin_upper_left"|"pixel_center_integer"
            |"early_fragment_tests"

//add built-in variables (i.e. gl_in, gl_out, etc.) and built-in functions



%state WAITING_VALUE
%state WAITING_NAME

%%

//thinking about how to implement custom function declaration
//perhaps it will require me to go into the java side of things w/ the interfaces provided by jflex
//perhaps we may generate an array to store them in in GLSLLexer

{SEMICOLON} {return GLSLTypes.SEMICOLON;}
{PARENTHASIS} {return GLSLTypes.PARENTHASIS;}
{COMMA} {return GLSLTypes.COMMA;}
{END_OF_LINE_COMMENT} {return GLSLTypes.COMMENT;}
{MULTI_LINE_COMMENT} {return GLSLTypes.COMMENT;}
{WHITE_SPACE}+ {return TokenType.WHITE_SPACE;}
{VERSION} {return GLSLTypes.VERSION;}
{NUMBER} {return GLSLTypes.NUMBER;}
{TYPE} {yybegin(WAITING_NAME); return GLSLTypes.TYPE;}
{LAYOUT_QUAL} {yybegin(YYINITIAL); return GLSLTypes.LAYOUT_QUAL;}
{KEYWORD} {yybegin(YYINITIAL); return GLSLTypes.KEYWORD;}
<WAITING_NAME> {KEY_CHARACTER}+ {yybegin(YYINITIAL); return GLSLTypes.KEY;}
<YYINITIAL> {SEPARATOR} {yybegin(WAITING_VALUE); return GLSLTypes.SEPARATOR;}
//<WAITING_VALUE> {FIRST_VALUE_CHARACTER}{VALUE_CHARACTER}* {yybegin(YYINITIAL); return GLSLTypes.VALUE;}

[^] {return TokenType.BAD_CHARACTER;}

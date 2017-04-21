/*
 * analyseur lexical du langage exemple-expr:
 * (voir support de cours CUP)
 *
 * auteur : azim.roussanaly@univ-lorraine.fr
 * (c) 2013
 */

package fr.ul.miage.exemple.generated;
import java_cup.runtime.Symbol;

%%

/* options */
%line
%public
%cup
%debug

/* macros */
CONSTANTE =   [0-9]+
FIN     =   \r|\n|\r\n\
MAIN 	= 	"main"
TQ 		=   "tantque"
PR		=	"pour"
RT		=	"retourne"
NOM		=	[a-z]+
TYPE	=	"int" | "void"
SI		=	"si"
SINON	=	"sinon"
FONCTION=	"fonction"
LIR		=	"lire"
SEP		=   [ \t]
DOC		=   \/\/ (\s [A-Z]*[a-z]*[0-9]*)*
COM     =   ((\/\*) | \*)([\s]? [A-Z]*[a-z]*[\']*[\:]*[\(]*[\)]*[\,]*[\<]*[\-]*)* | \*\/
IDF		=	[a-z]+[0-9]*

%%

/* regles */

"("         { return new Symbol(sym.PG, yytext());}
")"         { return new Symbol(sym.PD, yytext());}
"<-"		{ return new Symbol(sym.AFFECTE, yytext());}
"afficher"	{ return new Symbol(sym.AFFICH, yytext());}
"+"         { return new Symbol(sym.PLUS, yytext());}
{COM}		{;}
{DOC}		{;}
{MAIN}		{ return new Symbol(sym.MAIN, yytext());}
"/"			{ return new Symbol(sym.DIV, yytext());}
"-"			{ return new Symbol(sym.MOINS, yytext());}
"**"		{ return new Symbol(sym.FOIS, yytext());}
"&"			{ return new Symbol(sym.ET, yytext());}
"|"			{ return new Symbol(sym.OU, yytext());}
">"			{ return new Symbol(sym.PLUSGRAND, yytext());}
"<"         { return new Symbol(sym.PLUSPETIT, yytext());}
"=="		{ return new Symbol(sym.EGALE, yytext());}
"!="		{ return new Symbol(sym.DIFFERENT, yytext());}
">="		{ return new Symbol(sym.PLUSGRANDEGALE, yytext());}
"<="		{ return new Symbol(sym.PLUSPETITEGALE, yytext());}
"{"			{ return new Symbol(sym.ACG, yytext());}
"}"			{ return new Symbol(sym.ACD, yytext());}
"::"		{ return new Symbol(sym.DP, yytext());}
","			{ return new Symbol(sym.VIRGULE, yytext());}
";"			{;}
{SI} 		{ return new Symbol(sym.SI, yytext());}
{SINON}		{ return new Symbol(sym.SINON, yytext());}
{TYPE}		{ return new Symbol(sym.TYPE, yytext());}
{RT}		{ return new Symbol(sym.RT, yytext());}
{LIR}		{ return new Symbol(sym.LIR, yytext());}
{FONCTION}	{ return new Symbol(sym.FONCTION, yytext());}
{TQ}		{ return new Symbol(sym.TQ, yytext());}
{PR}		{ return new Symbol(sym.PR, yytext());}
{CONSTANTE} { return new Symbol(sym.CONSTANTE, yytext());}
{SEP}		{;}
{FIN}		{;}
{IDF}		{ return new Symbol(sym.IDF, yytext());}
{NOM}		{ return new Symbol(sym.NOM, yytext());}
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

"("         { return new Symbol(sym.PG);}
")"         { return new Symbol(sym.PD);}
"<-"		{ return new Symbol(sym.AFFECTE);}
"afficher"	{ return new Symbol(sym.AFFICH);}
"+"         { return new Symbol(sym.PLUS);}
{COM}		{;}
{DOC}		{;}
{MAIN}		{ return new Symbol(sym.MAIN);}
"/"			{ return new Symbol(sym.DIV);}
"-"			{ return new Symbol(sym.MOINS);}
"**"		{ return new Symbol(sym.FOIS);}
"&"			{ return new Symbol(sym.ET);}
"|"			{ return new Symbol(sym.OU);}
">"			{ return new Symbol(sym.PLUSGRAND);}
"<"         { return new Symbol(sym.PLUSPETIT);}
"=="		{ return new Symbol(sym.EGALE);}
"!="		{ return new Symbol(sym.DIFFERENT);}
">="		{ return new Symbol(sym.PLUSGRANDEGALE);}
"<="		{ return new Symbol(sym.PLUSPETITEGALE);}
"{"			{ return new Symbol(sym.ACG);}
"}"			{ return new Symbol(sym.ACD);}
"::"		{ return new Symbol(sym.DP);}
","			{ return new Symbol(sym.VIRGULE);}
";"			{;}
{SI} 		{ return new Symbol(sym.SI);}
{SINON}		{ return new Symbol(sym.SINON);}
{TYPE}		{ return new Symbol(sym.TYPE);}
{RT}		{ return new Symbol(sym.RT);}
{LIR}		{ return new Symbol(sym.LIR);}
{FONCTION}	{ return new Symbol(sym.FONCTION);}
{TQ}		{ return new Symbol(sym.TQ);}
{PR}		{ return new Symbol(sym.PR);}
{CONSTANTE} { return new Symbol(sym.CONSTANTE);}
{SEP}		{;}
{FIN}		{;}
{IDF}		{ return new Symbol(sym.IDF);}
{NOM}		{ return new Symbol(sym.NOM);}
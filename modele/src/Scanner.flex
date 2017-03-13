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
NUM     =   [0-9]+
FIN     =   \r|\n|\r\n\
TQ 		=   "while"
PR		=	"for"
RT		=	"retourne"
NOM		=	[a-z]*
TYPE	=	"int" | "void"
SI		=	"if"
SINON	=	"else"
FONCTION=	"fonction"
LIR		=	"lire()"
STRING 	= 	[a-z]+ | \* | [A-Z]+ | "'"
SEP		= [ \t]

%%

/* regles */

"("         { return new Symbol(sym.PG);}
")"         { return new Symbol(sym.PD);}
"/*"		{ return new Symbol(sym.COM);}
"*/"		{ return new Symbol(sym.FCOM);}
"<-"		{ return new Symbol(sym.AFFECTE);}
"afficher"	{ return new Symbol(sym.AFFICH);}
"+"         { return new Symbol(sym.PLUS);}
"/"			{ return new Symbol(sym.DIV);}
"-"			{ return new Symbol(sym.MOINS);}
"**"		{ return new Symbol(sym.FOIS);}
"&"			{ return new Symbol(sym.ET);}
"|"			{ return new Symbol(sym.OU);}
"{"			{ return new Symbol(sym.ACG);}
"}"			{ return new Symbol(sym.ACD);}
":"			{ return new Symbol(sym.DP);}
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
{NUM}       { return new Symbol(sym.NUM);}
{SEP}		{;}
{FIN}		{ return new Symbol(sym.FIN);}
{STRING}	{ return new Symbol(sym.STRING);}
{NOM}		{ return new Symbol(sym.NOM);}
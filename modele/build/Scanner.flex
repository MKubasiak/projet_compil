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
SEP     =   [ \t]
NUM     =   [0-9]+
FIN     =   \r|\n|\r\n\
TQ 		=   "tantque"
PR		=	"pour"
RT		=	"retourne"
NOM		=	[a-z]*
TYPE	=	"int" | "void"
SI		=	"si"
SINON	=	"sinon"
FONCTION=	"fonction"
LIR		=	"lire"
STRING 	= 	[a-z]* | \* | [A-Z]*

%%

/* regles */

"/*"		{ return new Symbol(sym.COM);}
"*/"		{ return new Symbol(sym.FCOM);}
"<-"		{ return new Symbol(sym.AFFECTE);}
"affiche"	{ return new Symbol(sym.AFFICH);}
"+"         { return new Symbol(sym.PLUS);}
"("         { return new Symbol(sym.PG);}
")"         { return new Symbol(sym.PD);}
"/"			{ return new Symbol(sym.DIV);}
"-"			{ return new Symbol(sym.MOINS);}
"&"			{ return new Symbol(sym.ET);}
"|"			{ return new Symbol(sym.OU);}
"{"			{ return new Symbol(sym.ACG);}
"}"			{ return new Symbol(sym.ACD);}
":"		{ return new Symbol(sym.DP);}
{SI} 		{ return new Symbol(sym.SI);}
{SINON}		{ return new Symbol(sym.SINON);}
{TYPE}		{ return new Symbol(sym.TYPE);}
{RT}		{ return new Symbol(sym.RT);}
{LIR}		{ return new Symbol(sym.LIR);}
{FONCTION}	{ return new Symbol(sym.FONCTION);}
{TQ}		{ return new Symbol(sym.TQ);}
{PR}		{ return new Symbol(sym.PR);}
{NUM}       { return new Symbol(sym.NUM);}
{SEP}       { return new Symbol(sym.SEP); }
{FIN}		{ return new Symbol(sym.FIN);}
{STRING}	{ return new Symbol(sym.STRING);}
{NOM}		{ return new Symbol(sym.NOM);}
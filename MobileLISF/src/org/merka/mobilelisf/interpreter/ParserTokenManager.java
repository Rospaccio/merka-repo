/* Generated By:JJTree&JavaCC: Do not edit this line. ParserTokenManager.java */
package org.merka.mobilelisf.interpreter;
import org.merka.mobilelisf.interpreter.ast.*;
import org.merka.mobilelisf.interpreter.visitor.*;

public class ParserTokenManager implements ParserConstants
{
  public static  java.io.PrintStream debugStream = System.out;
  public static  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private static final int jjStopStringLiteralDfa_0(int pos, long active0)
{
   switch (pos)
   {
      case 0:
         if ((active0 & 0x1cffff07c00L) != 0L)
         {
            jjmatchedKind = 44;
            return 6;
         }
         return -1;
      case 1:
         if ((active0 & 0x401000000L) != 0L)
            return 6;
         if ((active0 & 0x1cbfef07c00L) != 0L)
         {
            jjmatchedKind = 44;
            jjmatchedPos = 1;
            return 6;
         }
         return -1;
      case 2:
         if ((active0 & 0xc800f00000L) != 0L)
            return 6;
         if ((active0 & 0x103fe007c00L) != 0L)
         {
            jjmatchedKind = 44;
            jjmatchedPos = 2;
            return 6;
         }
         return -1;
      case 3:
         if ((active0 & 0x10004004c00L) != 0L)
            return 6;
         if ((active0 & 0x3fa003000L) != 0L)
         {
            jjmatchedKind = 44;
            jjmatchedPos = 3;
            return 6;
         }
         return -1;
      case 4:
         if ((active0 & 0x82000000L) != 0L)
            return 6;
         if ((active0 & 0x378003000L) != 0L)
         {
            jjmatchedKind = 44;
            jjmatchedPos = 4;
            return 6;
         }
         return -1;
      case 5:
         if ((active0 & 0x78003000L) != 0L)
            return 6;
         if ((active0 & 0x300000000L) != 0L)
         {
            if (jjmatchedPos != 5)
            {
               jjmatchedKind = 44;
               jjmatchedPos = 5;
            }
            return 6;
         }
         return -1;
      case 6:
         if ((active0 & 0x200000000L) != 0L)
            return 6;
         if ((active0 & 0x100000000L) != 0L)
         {
            jjmatchedKind = 44;
            jjmatchedPos = 6;
            return 6;
         }
         return -1;
      case 7:
         if ((active0 & 0x100000000L) != 0L)
            return 6;
         return -1;
      default :
         return -1;
   }
}
private static final int jjStartNfa_0(int pos, long active0)
{
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0), pos + 1);
}
static private final int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
static private final int jjStartNfaWithStates_0(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_0(state, pos + 1);
}
static private final int jjMoveStringLiteralDfa0_0()
{
   switch(curChar)
   {
      case 40:
         return jjStopAtPos(0, 6);
      case 41:
         jjmatchedKind = 19;
         return jjMoveStringLiteralDfa1_0(0x100L);
      case 42:
         return jjStopAtPos(0, 16);
      case 43:
         return jjStopAtPos(0, 15);
      case 45:
         return jjStopAtPos(0, 7);
      case 47:
         return jjStopAtPos(0, 17);
      case 59:
         return jjStopAtPos(0, 4);
      case 60:
         return jjStopAtPos(0, 36);
      case 61:
         return jjStopAtPos(0, 5);
      case 62:
         return jjStopAtPos(0, 37);
      case 63:
         return jjStopAtPos(0, 9);
      case 92:
         return jjStopAtPos(0, 41);
      case 94:
         return jjStopAtPos(0, 18);
      case 97:
         return jjMoveStringLiteralDfa1_0(0x43f8000000L);
      case 99:
         return jjMoveStringLiteralDfa1_0(0x6400000L);
      case 100:
         return jjMoveStringLiteralDfa1_0(0x7000L);
      case 101:
         return jjMoveStringLiteralDfa1_0(0x8000000000L);
      case 102:
         return jjMoveStringLiteralDfa1_0(0x10000000000L);
      case 108:
         return jjMoveStringLiteralDfa1_0(0xc00000800L);
      case 115:
         return jjMoveStringLiteralDfa1_0(0x300000L);
      case 116:
         return jjMoveStringLiteralDfa1_0(0x1800400L);
      case 120:
         return jjStopAtPos(0, 45);
      default :
         return jjMoveNfa_0(0, 0);
   }
}
static private final int jjMoveStringLiteralDfa1_0(long active0)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0);
      return 1;
   }
   switch(curChar)
   {
      case 63:
         if ((active0 & 0x100L) != 0L)
            return jjStopAtPos(1, 8);
         break;
      case 97:
         return jjMoveStringLiteralDfa2_0(active0, 0x10000800000L);
      case 98:
         return jjMoveStringLiteralDfa2_0(active0, 0x4000000000L);
      case 101:
         return jjMoveStringLiteralDfa2_0(active0, 0x203000L);
      case 103:
         if ((active0 & 0x1000000L) != 0L)
            return jjStartNfaWithStates_0(1, 24, 6);
         break;
      case 105:
         return jjMoveStringLiteralDfa2_0(active0, 0x100800L);
      case 110:
         if ((active0 & 0x400000000L) != 0L)
            return jjStartNfaWithStates_0(1, 34, 6);
         break;
      case 111:
         return jjMoveStringLiteralDfa2_0(active0, 0x806400000L);
      case 114:
         return jjMoveStringLiteralDfa2_0(active0, 0x3f8004400L);
      case 120:
         return jjMoveStringLiteralDfa2_0(active0, 0x8000000000L);
      default :
         break;
   }
   return jjStartNfa_0(0, active0);
}
static private final int jjMoveStringLiteralDfa2_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(0, old0); 
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(1, active0);
      return 2;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa3_0(active0, 0x4000L);
      case 99:
         return jjMoveStringLiteralDfa3_0(active0, 0x103f8000000L);
      case 101:
         return jjMoveStringLiteralDfa3_0(active0, 0x400L);
      case 103:
         if ((active0 & 0x800000000L) != 0L)
            return jjStartNfaWithStates_0(2, 35, 6);
         break;
      case 108:
         return jjMoveStringLiteralDfa3_0(active0, 0x3000L);
      case 110:
         if ((active0 & 0x100000L) != 0L)
            return jjStartNfaWithStates_0(2, 20, 6);
         else if ((active0 & 0x200000L) != 0L)
            return jjStartNfaWithStates_0(2, 21, 6);
         else if ((active0 & 0x800000L) != 0L)
            return jjStartNfaWithStates_0(2, 23, 6);
         break;
      case 112:
         if ((active0 & 0x8000000000L) != 0L)
            return jjStartNfaWithStates_0(2, 39, 6);
         break;
      case 115:
         if ((active0 & 0x400000L) != 0L)
            return jjStartNfaWithStates_0(2, 22, 6);
         else if ((active0 & 0x4000000000L) != 0L)
            return jjStartNfaWithStates_0(2, 38, 6);
         return jjMoveStringLiteralDfa3_0(active0, 0x800L);
      case 116:
         return jjMoveStringLiteralDfa3_0(active0, 0x6000000L);
      default :
         break;
   }
   return jjStartNfa_0(1, active0);
}
static private final int jjMoveStringLiteralDfa3_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(1, old0); 
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(2, active0);
      return 3;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa4_0(active0, 0x2000000L);
      case 99:
         return jjMoveStringLiteralDfa4_0(active0, 0x320000000L);
      case 101:
         if ((active0 & 0x400L) != 0L)
            return jjStartNfaWithStates_0(3, 10, 6);
         return jjMoveStringLiteralDfa4_0(active0, 0x3000L);
      case 103:
         if ((active0 & 0x4000000L) != 0L)
            return jjStartNfaWithStates_0(3, 26, 6);
         break;
      case 115:
         return jjMoveStringLiteralDfa4_0(active0, 0x18000000L);
      case 116:
         if ((active0 & 0x800L) != 0L)
            return jjStartNfaWithStates_0(3, 11, 6);
         else if ((active0 & 0x10000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 40, 6);
         return jjMoveStringLiteralDfa4_0(active0, 0xc0000000L);
      case 119:
         if ((active0 & 0x4000L) != 0L)
            return jjStartNfaWithStates_0(3, 14, 6);
         break;
      default :
         break;
   }
   return jjStartNfa_0(2, active0);
}
static private final int jjMoveStringLiteralDfa4_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(2, old0); 
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(3, active0);
      return 4;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa5_0(active0, 0x40000000L);
      case 101:
         return jjMoveStringLiteralDfa5_0(active0, 0x10000000L);
      case 103:
         if ((active0 & 0x80000000L) != 0L)
            return jjStartNfaWithStates_0(4, 31, 6);
         break;
      case 105:
         return jjMoveStringLiteralDfa5_0(active0, 0x8000000L);
      case 110:
         if ((active0 & 0x2000000L) != 0L)
            return jjStartNfaWithStates_0(4, 25, 6);
         break;
      case 111:
         return jjMoveStringLiteralDfa5_0(active0, 0x320000000L);
      case 116:
         return jjMoveStringLiteralDfa5_0(active0, 0x3000L);
      default :
         break;
   }
   return jjStartNfa_0(3, active0);
}
static private final int jjMoveStringLiteralDfa5_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(3, old0); 
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(4, active0);
      return 5;
   }
   switch(curChar)
   {
      case 101:
         if ((active0 & 0x1000L) != 0L)
         {
            jjmatchedKind = 12;
            jjmatchedPos = 5;
         }
         return jjMoveStringLiteralDfa6_0(active0, 0x2000L);
      case 110:
         if ((active0 & 0x8000000L) != 0L)
            return jjStartNfaWithStates_0(5, 27, 6);
         else if ((active0 & 0x10000000L) != 0L)
            return jjStartNfaWithStates_0(5, 28, 6);
         else if ((active0 & 0x40000000L) != 0L)
            return jjStartNfaWithStates_0(5, 30, 6);
         break;
      case 115:
         if ((active0 & 0x20000000L) != 0L)
            return jjStartNfaWithStates_0(5, 29, 6);
         break;
      case 116:
         return jjMoveStringLiteralDfa6_0(active0, 0x300000000L);
      default :
         break;
   }
   return jjStartNfa_0(4, active0);
}
static private final int jjMoveStringLiteralDfa6_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(4, old0); 
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(5, active0);
      return 6;
   }
   switch(curChar)
   {
      case 32:
         return jjMoveStringLiteralDfa7_0(active0, 0x2000L);
      case 97:
         return jjMoveStringLiteralDfa7_0(active0, 0x100000000L);
      case 103:
         if ((active0 & 0x200000000L) != 0L)
            return jjStartNfaWithStates_0(6, 33, 6);
         break;
      default :
         break;
   }
   return jjStartNfa_0(5, active0);
}
static private final int jjMoveStringLiteralDfa7_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(5, old0); 
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(6, active0);
      return 7;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa8_0(active0, 0x2000L);
      case 110:
         if ((active0 & 0x100000000L) != 0L)
            return jjStartNfaWithStates_0(7, 32, 6);
         break;
      default :
         break;
   }
   return jjStartNfa_0(6, active0);
}
static private final int jjMoveStringLiteralDfa8_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(6, old0); 
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(7, active0);
      return 8;
   }
   switch(curChar)
   {
      case 108:
         return jjMoveStringLiteralDfa9_0(active0, 0x2000L);
      default :
         break;
   }
   return jjStartNfa_0(7, active0);
}
static private final int jjMoveStringLiteralDfa9_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(7, old0); 
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(8, active0);
      return 9;
   }
   switch(curChar)
   {
      case 108:
         if ((active0 & 0x2000L) != 0L)
            return jjStopAtPos(9, 13);
         break;
      default :
         break;
   }
   return jjStartNfa_0(8, active0);
}
static private final void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
static private final void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
static private final void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}
static private final void jjCheckNAddStates(int start, int end)
{
   do {
      jjCheckNAdd(jjnextStates[start]);
   } while (start++ != end);
}
static private final void jjCheckNAddStates(int start)
{
   jjCheckNAdd(jjnextStates[start]);
   jjCheckNAdd(jjnextStates[start + 1]);
}
static private final int jjMoveNfa_0(int startState, int curPos)
{
   int[] nextStates;
   int startsAt = 0;
   jjnewStateCnt = 7;
   int i = 1;
   jjstateSet[0] = startState;
   int j, kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         MatchLoop: do
         {
            switch(jjstateSet[--i])
            {
               case 0:
                  if ((0x3fe000000000000L & l) != 0L)
                  {
                     if (kind > 42)
                        kind = 42;
                     jjCheckNAdd(2);
                  }
                  else if (curChar == 46)
                     jjCheckNAdd(4);
                  else if (curChar == 48)
                  {
                     if (kind > 42)
                        kind = 42;
                  }
                  break;
               case 1:
                  if ((0x3fe000000000000L & l) == 0L)
                     break;
                  if (kind > 42)
                     kind = 42;
                  jjCheckNAdd(2);
                  break;
               case 2:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 42)
                     kind = 42;
                  jjCheckNAdd(2);
                  break;
               case 3:
                  if (curChar == 46)
                     jjCheckNAdd(4);
                  break;
               case 4:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 43)
                     kind = 43;
                  jjCheckNAdd(4);
                  break;
               case 6:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 44)
                     kind = 44;
                  jjstateSet[jjnewStateCnt++] = 6;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         MatchLoop: do
         {
            switch(jjstateSet[--i])
            {
               case 0:
                  if ((0x67ffffe067ffffeL & l) == 0L)
                     break;
                  if (kind > 44)
                     kind = 44;
                  jjCheckNAdd(6);
                  break;
               case 6:
                  if ((0x7fffffe07fffffeL & l) == 0L)
                     break;
                  if (kind > 44)
                     kind = 44;
                  jjCheckNAdd(6);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         MatchLoop: do
         {
            switch(jjstateSet[--i])
            {
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 7 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
static final int[] jjnextStates = {
};
public static final String[] jjstrLiteralImages = {
"", null, null, null, "\73", "\75", "\50", "\55", "\51\77", "\77", 
"\164\162\145\145", "\154\151\163\164", "\144\145\154\145\164\145", 
"\144\145\154\145\164\145\40\141\154\154", "\144\162\141\167", "\53", "\52", "\57", "\136", "\51", "\163\151\156", 
"\163\145\156", "\143\157\163", "\164\141\156", "\164\147", "\143\157\164\141\156", 
"\143\157\164\147", "\141\162\143\163\151\156", "\141\162\143\163\145\156", 
"\141\162\143\143\157\163", "\141\162\143\164\141\156", "\141\162\143\164\147", 
"\141\162\143\143\157\164\141\156", "\141\162\143\143\157\164\147", "\154\156", "\154\157\147", "\74", "\76", 
"\141\142\163", "\145\170\160", "\146\141\143\164", "\134", null, null, null, "\170", };
public static final String[] lexStateNames = {
   "DEFAULT", 
};
static final long[] jjtoToken = {
   0x3ffffffffff1L, 
};
static final long[] jjtoSkip = {
   0xeL, 
};
static protected SimpleCharStream input_stream;
static private final int[] jjrounds = new int[7];
static private final int[] jjstateSet = new int[14];
static protected char curChar;
public ParserTokenManager(SimpleCharStream stream)
{
   if (input_stream != null)
      throw new TokenMgrError("ERROR: Second call to constructor of static lexer. You must use ReInit() to initialize the static variables.", TokenMgrError.STATIC_LEXER_ERROR);
   input_stream = stream;
}
public ParserTokenManager(SimpleCharStream stream, int lexState)
{
   this(stream);
   SwitchTo(lexState);
}
static public void ReInit(SimpleCharStream stream)
{
   jjmatchedPos = jjnewStateCnt = 0;
   curLexState = defaultLexState;
   input_stream = stream;
   ReInitRounds();
}
static private final void ReInitRounds()
{
   int i;
   jjround = 0x80000001;
   for (i = 7; i-- > 0;)
      jjrounds[i] = 0x80000000;
}
static public void ReInit(SimpleCharStream stream, int lexState)
{
   ReInit(stream);
   SwitchTo(lexState);
}
static public void SwitchTo(int lexState)
{
   if (lexState >= 1 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
   else
      curLexState = lexState;
}

static protected Token jjFillToken()
{
   Token t = Token.newToken(jjmatchedKind);
   t.kind = jjmatchedKind;
   String im = jjstrLiteralImages[jjmatchedKind];
   t.image = (im == null) ? input_stream.GetImage() : im;
   t.beginLine = input_stream.getBeginLine();
   t.beginColumn = input_stream.getBeginColumn();
   t.endLine = input_stream.getEndLine();
   t.endColumn = input_stream.getEndColumn();
   return t;
}

static int curLexState = 0;
static int defaultLexState = 0;
static int jjnewStateCnt;
static int jjround;
static int jjmatchedPos;
static int jjmatchedKind;

public static Token getNextToken() 
{
  int kind;
  Token specialToken = null;
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {   
   try   
   {     
      curChar = input_stream.BeginToken();
   }     
   catch(java.io.IOException e)
   {        
      jjmatchedKind = 0;
      matchedToken = jjFillToken();
      return matchedToken;
   }

   try { input_stream.backup(0);
      while (curChar <= 32 && (0x100000600L & (1L << curChar)) != 0L)
         curChar = input_stream.BeginToken();
   }
   catch (java.io.IOException e1) { continue EOFLoop; }
   jjmatchedKind = 0x7fffffff;
   jjmatchedPos = 0;
   curPos = jjMoveStringLiteralDfa0_0();
   if (jjmatchedKind != 0x7fffffff)
   {
      if (jjmatchedPos + 1 < curPos)
         input_stream.backup(curPos - jjmatchedPos - 1);
      if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
      {
         matchedToken = jjFillToken();
         return matchedToken;
      }
      else
      {
         continue EOFLoop;
      }
   }
   int error_line = input_stream.getEndLine();
   int error_column = input_stream.getEndColumn();
   String error_after = null;
   boolean EOFSeen = false;
   try { input_stream.readChar(); input_stream.backup(1); }
   catch (java.io.IOException e1) {
      EOFSeen = true;
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
      if (curChar == '\n' || curChar == '\r') {
         error_line++;
         error_column = 0;
      }
      else
         error_column++;
   }
   if (!EOFSeen) {
      input_stream.backup(1);
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
   }
   throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
  }
}

}
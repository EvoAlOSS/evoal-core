package de.evoal.languages.model.el.dsl.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalExpressionLanguageLexer extends Lexer {
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int RULE_ID=10;
    public static final int RULE_QUOTED_ID=9;
    public static final int RULE_DIGIT=7;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=5;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=11;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=12;
    public static final int T__37=37;
    public static final int RULE_DOUBLE=4;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_WS=13;
    public static final int RULE_ANY_OTHER=14;
    public static final int RULE_EXPONENT=8;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators

    public InternalExpressionLanguageLexer() {;} 
    public InternalExpressionLanguageLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalExpressionLanguageLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalExpressionLanguage.g"; }

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpressionLanguage.g:11:7: ( 'OR' )
            // InternalExpressionLanguage.g:11:9: 'OR'
            {
            match("OR"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpressionLanguage.g:12:7: ( 'XOR' )
            // InternalExpressionLanguage.g:12:9: 'XOR'
            {
            match("XOR"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpressionLanguage.g:13:7: ( 'AND' )
            // InternalExpressionLanguage.g:13:9: 'AND'
            {
            match("AND"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpressionLanguage.g:14:7: ( '!' )
            // InternalExpressionLanguage.g:14:9: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpressionLanguage.g:15:7: ( '^' )
            // InternalExpressionLanguage.g:15:9: '^'
            {
            match('^'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpressionLanguage.g:16:7: ( '(' )
            // InternalExpressionLanguage.g:16:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpressionLanguage.g:17:7: ( ')' )
            // InternalExpressionLanguage.g:17:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpressionLanguage.g:18:7: ( ',' )
            // InternalExpressionLanguage.g:18:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpressionLanguage.g:19:7: ( 'call' )
            // InternalExpressionLanguage.g:19:9: 'call'
            {
            match("call"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpressionLanguage.g:20:7: ( 'value' )
            // InternalExpressionLanguage.g:20:9: 'value'
            {
            match("value"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpressionLanguage.g:21:7: ( 'true' )
            // InternalExpressionLanguage.g:21:9: 'true'
            {
            match("true"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpressionLanguage.g:22:7: ( 'false' )
            // InternalExpressionLanguage.g:22:9: 'false'
            {
            match("false"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpressionLanguage.g:23:7: ( '>=' )
            // InternalExpressionLanguage.g:23:9: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpressionLanguage.g:24:7: ( '>' )
            // InternalExpressionLanguage.g:24:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpressionLanguage.g:25:7: ( '=' )
            // InternalExpressionLanguage.g:25:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpressionLanguage.g:26:7: ( '!=' )
            // InternalExpressionLanguage.g:26:9: '!='
            {
            match("!="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpressionLanguage.g:27:7: ( '<' )
            // InternalExpressionLanguage.g:27:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpressionLanguage.g:28:7: ( '<=' )
            // InternalExpressionLanguage.g:28:9: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpressionLanguage.g:29:7: ( '+' )
            // InternalExpressionLanguage.g:29:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpressionLanguage.g:30:7: ( '-' )
            // InternalExpressionLanguage.g:30:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpressionLanguage.g:31:7: ( '*' )
            // InternalExpressionLanguage.g:31:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpressionLanguage.g:32:7: ( '/' )
            // InternalExpressionLanguage.g:32:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpressionLanguage.g:33:7: ( '%' )
            // InternalExpressionLanguage.g:33:9: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpressionLanguage.g:34:7: ( 'Y' )
            // InternalExpressionLanguage.g:34:9: 'Y'
            {
            match('Y'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpressionLanguage.g:35:7: ( 'Z' )
            // InternalExpressionLanguage.g:35:9: 'Z'
            {
            match('Z'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpressionLanguage.g:36:7: ( 'E' )
            // InternalExpressionLanguage.g:36:9: 'E'
            {
            match('E'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpressionLanguage.g:37:7: ( 'P' )
            // InternalExpressionLanguage.g:37:9: 'P'
            {
            match('P'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpressionLanguage.g:38:7: ( 'T' )
            // InternalExpressionLanguage.g:38:9: 'T'
            {
            match('T'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpressionLanguage.g:39:7: ( 'G' )
            // InternalExpressionLanguage.g:39:9: 'G'
            {
            match('G'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpressionLanguage.g:40:7: ( 'M' )
            // InternalExpressionLanguage.g:40:9: 'M'
            {
            match('M'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpressionLanguage.g:41:7: ( 'k' )
            // InternalExpressionLanguage.g:41:9: 'k'
            {
            match('k'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpressionLanguage.g:42:7: ( 'h' )
            // InternalExpressionLanguage.g:42:9: 'h'
            {
            match('h'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpressionLanguage.g:43:7: ( 'da' )
            // InternalExpressionLanguage.g:43:9: 'da'
            {
            match("da"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpressionLanguage.g:44:7: ( 'd' )
            // InternalExpressionLanguage.g:44:9: 'd'
            {
            match('d'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpressionLanguage.g:45:7: ( 'c' )
            // InternalExpressionLanguage.g:45:9: 'c'
            {
            match('c'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpressionLanguage.g:46:7: ( 'm' )
            // InternalExpressionLanguage.g:46:9: 'm'
            {
            match('m'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpressionLanguage.g:47:7: ( '\\u00B5' )
            // InternalExpressionLanguage.g:47:9: '\\u00B5'
            {
            match('\u00B5'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpressionLanguage.g:48:7: ( 'n' )
            // InternalExpressionLanguage.g:48:9: 'n'
            {
            match('n'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpressionLanguage.g:49:7: ( 'p' )
            // InternalExpressionLanguage.g:49:9: 'p'
            {
            match('p'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpressionLanguage.g:50:7: ( 'f' )
            // InternalExpressionLanguage.g:50:9: 'f'
            {
            match('f'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpressionLanguage.g:51:7: ( 'a' )
            // InternalExpressionLanguage.g:51:9: 'a'
            {
            match('a'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpressionLanguage.g:52:7: ( 'z' )
            // InternalExpressionLanguage.g:52:9: 'z'
            {
            match('z'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpressionLanguage.g:53:7: ( 'y' )
            // InternalExpressionLanguage.g:53:9: 'y'
            {
            match('y'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "RULE_DIGIT"
    public final void mRULE_DIGIT() throws RecognitionException {
        try {
            // InternalExpressionLanguage.g:1540:21: ( '0' .. '9' )
            // InternalExpressionLanguage.g:1540:23: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_DIGIT"

    // $ANTLR start "RULE_EXPONENT"
    public final void mRULE_EXPONENT() throws RecognitionException {
        try {
            // InternalExpressionLanguage.g:1542:24: ( 'e' ( '+' | '-' )? ( RULE_DIGIT )+ )
            // InternalExpressionLanguage.g:1542:26: 'e' ( '+' | '-' )? ( RULE_DIGIT )+
            {
            match('e'); 
            // InternalExpressionLanguage.g:1542:30: ( '+' | '-' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='+'||LA1_0=='-') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalExpressionLanguage.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            // InternalExpressionLanguage.g:1542:41: ( RULE_DIGIT )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalExpressionLanguage.g:1542:41: RULE_DIGIT
            	    {
            	    mRULE_DIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_EXPONENT"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpressionLanguage.g:1544:10: ( ( '-' )? ( RULE_DIGIT )+ )
            // InternalExpressionLanguage.g:1544:12: ( '-' )? ( RULE_DIGIT )+
            {
            // InternalExpressionLanguage.g:1544:12: ( '-' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='-') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalExpressionLanguage.g:1544:12: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // InternalExpressionLanguage.g:1544:17: ( RULE_DIGIT )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalExpressionLanguage.g:1544:17: RULE_DIGIT
            	    {
            	    mRULE_DIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_DOUBLE"
    public final void mRULE_DOUBLE() throws RecognitionException {
        try {
            int _type = RULE_DOUBLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpressionLanguage.g:1546:13: ( ( RULE_INT RULE_EXPONENT | RULE_INT '.' ( RULE_DIGIT )* ( RULE_EXPONENT )? ) )
            // InternalExpressionLanguage.g:1546:15: ( RULE_INT RULE_EXPONENT | RULE_INT '.' ( RULE_DIGIT )* ( RULE_EXPONENT )? )
            {
            // InternalExpressionLanguage.g:1546:15: ( RULE_INT RULE_EXPONENT | RULE_INT '.' ( RULE_DIGIT )* ( RULE_EXPONENT )? )
            int alt7=2;
            alt7 = dfa7.predict(input);
            switch (alt7) {
                case 1 :
                    // InternalExpressionLanguage.g:1546:16: RULE_INT RULE_EXPONENT
                    {
                    mRULE_INT(); 
                    mRULE_EXPONENT(); 

                    }
                    break;
                case 2 :
                    // InternalExpressionLanguage.g:1546:39: RULE_INT '.' ( RULE_DIGIT )* ( RULE_EXPONENT )?
                    {
                    mRULE_INT(); 
                    match('.'); 
                    // InternalExpressionLanguage.g:1546:52: ( RULE_DIGIT )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // InternalExpressionLanguage.g:1546:52: RULE_DIGIT
                    	    {
                    	    mRULE_DIGIT(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    // InternalExpressionLanguage.g:1546:64: ( RULE_EXPONENT )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0=='e') ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // InternalExpressionLanguage.g:1546:64: RULE_EXPONENT
                            {
                            mRULE_EXPONENT(); 

                            }
                            break;

                    }


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_DOUBLE"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpressionLanguage.g:1548:13: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' )
            // InternalExpressionLanguage.g:1548:15: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
            {
            match('\"'); 
            // InternalExpressionLanguage.g:1548:19: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
            loop8:
            do {
                int alt8=3;
                int LA8_0 = input.LA(1);

                if ( (LA8_0=='\\') ) {
                    alt8=1;
                }
                else if ( ((LA8_0>='\u0000' && LA8_0<='!')||(LA8_0>='#' && LA8_0<='[')||(LA8_0>=']' && LA8_0<='\uFFFF')) ) {
                    alt8=2;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalExpressionLanguage.g:1548:20: '\\\\' .
            	    {
            	    match('\\'); 
            	    matchAny(); 

            	    }
            	    break;
            	case 2 :
            	    // InternalExpressionLanguage.g:1548:27: ~ ( ( '\\\\' | '\"' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_QUOTED_ID"
    public final void mRULE_QUOTED_ID() throws RecognitionException {
        try {
            int _type = RULE_QUOTED_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpressionLanguage.g:1550:16: ( '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            // InternalExpressionLanguage.g:1550:18: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
            {
            match('\''); 
            // InternalExpressionLanguage.g:1550:23: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
            loop9:
            do {
                int alt9=3;
                int LA9_0 = input.LA(1);

                if ( (LA9_0=='\\') ) {
                    alt9=1;
                }
                else if ( ((LA9_0>='\u0000' && LA9_0<='&')||(LA9_0>='(' && LA9_0<='[')||(LA9_0>=']' && LA9_0<='\uFFFF')) ) {
                    alt9=2;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalExpressionLanguage.g:1550:24: '\\\\' .
            	    {
            	    match('\\'); 
            	    matchAny(); 

            	    }
            	    break;
            	case 2 :
            	    // InternalExpressionLanguage.g:1550:31: ~ ( ( '\\\\' | '\\'' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_QUOTED_ID"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpressionLanguage.g:1552:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalExpressionLanguage.g:1552:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalExpressionLanguage.g:1552:11: ( '^' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='^') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalExpressionLanguage.g:1552:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalExpressionLanguage.g:1552:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='0' && LA11_0<='9')||(LA11_0>='A' && LA11_0<='Z')||LA11_0=='_'||(LA11_0>='a' && LA11_0<='z')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalExpressionLanguage.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpressionLanguage.g:1554:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalExpressionLanguage.g:1554:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalExpressionLanguage.g:1554:24: ( options {greedy=false; } : . )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0=='*') ) {
                    int LA12_1 = input.LA(2);

                    if ( (LA12_1=='/') ) {
                        alt12=2;
                    }
                    else if ( ((LA12_1>='\u0000' && LA12_1<='.')||(LA12_1>='0' && LA12_1<='\uFFFF')) ) {
                        alt12=1;
                    }


                }
                else if ( ((LA12_0>='\u0000' && LA12_0<=')')||(LA12_0>='+' && LA12_0<='\uFFFF')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalExpressionLanguage.g:1554:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpressionLanguage.g:1556:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalExpressionLanguage.g:1556:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalExpressionLanguage.g:1556:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>='\u0000' && LA13_0<='\t')||(LA13_0>='\u000B' && LA13_0<='\f')||(LA13_0>='\u000E' && LA13_0<='\uFFFF')) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalExpressionLanguage.g:1556:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            // InternalExpressionLanguage.g:1556:40: ( ( '\\r' )? '\\n' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0=='\n'||LA15_0=='\r') ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalExpressionLanguage.g:1556:41: ( '\\r' )? '\\n'
                    {
                    // InternalExpressionLanguage.g:1556:41: ( '\\r' )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0=='\r') ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // InternalExpressionLanguage.g:1556:41: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpressionLanguage.g:1558:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalExpressionLanguage.g:1558:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalExpressionLanguage.g:1558:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>='\t' && LA16_0<='\n')||LA16_0=='\r'||LA16_0==' ') ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalExpressionLanguage.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt16 >= 1 ) break loop16;
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpressionLanguage.g:1560:16: ( . )
            // InternalExpressionLanguage.g:1560:18: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_OTHER"

    public void mTokens() throws RecognitionException {
        // InternalExpressionLanguage.g:1:8: ( T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | RULE_INT | RULE_DOUBLE | RULE_STRING | RULE_QUOTED_ID | RULE_ID | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt17=52;
        alt17 = dfa17.predict(input);
        switch (alt17) {
            case 1 :
                // InternalExpressionLanguage.g:1:10: T__15
                {
                mT__15(); 

                }
                break;
            case 2 :
                // InternalExpressionLanguage.g:1:16: T__16
                {
                mT__16(); 

                }
                break;
            case 3 :
                // InternalExpressionLanguage.g:1:22: T__17
                {
                mT__17(); 

                }
                break;
            case 4 :
                // InternalExpressionLanguage.g:1:28: T__18
                {
                mT__18(); 

                }
                break;
            case 5 :
                // InternalExpressionLanguage.g:1:34: T__19
                {
                mT__19(); 

                }
                break;
            case 6 :
                // InternalExpressionLanguage.g:1:40: T__20
                {
                mT__20(); 

                }
                break;
            case 7 :
                // InternalExpressionLanguage.g:1:46: T__21
                {
                mT__21(); 

                }
                break;
            case 8 :
                // InternalExpressionLanguage.g:1:52: T__22
                {
                mT__22(); 

                }
                break;
            case 9 :
                // InternalExpressionLanguage.g:1:58: T__23
                {
                mT__23(); 

                }
                break;
            case 10 :
                // InternalExpressionLanguage.g:1:64: T__24
                {
                mT__24(); 

                }
                break;
            case 11 :
                // InternalExpressionLanguage.g:1:70: T__25
                {
                mT__25(); 

                }
                break;
            case 12 :
                // InternalExpressionLanguage.g:1:76: T__26
                {
                mT__26(); 

                }
                break;
            case 13 :
                // InternalExpressionLanguage.g:1:82: T__27
                {
                mT__27(); 

                }
                break;
            case 14 :
                // InternalExpressionLanguage.g:1:88: T__28
                {
                mT__28(); 

                }
                break;
            case 15 :
                // InternalExpressionLanguage.g:1:94: T__29
                {
                mT__29(); 

                }
                break;
            case 16 :
                // InternalExpressionLanguage.g:1:100: T__30
                {
                mT__30(); 

                }
                break;
            case 17 :
                // InternalExpressionLanguage.g:1:106: T__31
                {
                mT__31(); 

                }
                break;
            case 18 :
                // InternalExpressionLanguage.g:1:112: T__32
                {
                mT__32(); 

                }
                break;
            case 19 :
                // InternalExpressionLanguage.g:1:118: T__33
                {
                mT__33(); 

                }
                break;
            case 20 :
                // InternalExpressionLanguage.g:1:124: T__34
                {
                mT__34(); 

                }
                break;
            case 21 :
                // InternalExpressionLanguage.g:1:130: T__35
                {
                mT__35(); 

                }
                break;
            case 22 :
                // InternalExpressionLanguage.g:1:136: T__36
                {
                mT__36(); 

                }
                break;
            case 23 :
                // InternalExpressionLanguage.g:1:142: T__37
                {
                mT__37(); 

                }
                break;
            case 24 :
                // InternalExpressionLanguage.g:1:148: T__38
                {
                mT__38(); 

                }
                break;
            case 25 :
                // InternalExpressionLanguage.g:1:154: T__39
                {
                mT__39(); 

                }
                break;
            case 26 :
                // InternalExpressionLanguage.g:1:160: T__40
                {
                mT__40(); 

                }
                break;
            case 27 :
                // InternalExpressionLanguage.g:1:166: T__41
                {
                mT__41(); 

                }
                break;
            case 28 :
                // InternalExpressionLanguage.g:1:172: T__42
                {
                mT__42(); 

                }
                break;
            case 29 :
                // InternalExpressionLanguage.g:1:178: T__43
                {
                mT__43(); 

                }
                break;
            case 30 :
                // InternalExpressionLanguage.g:1:184: T__44
                {
                mT__44(); 

                }
                break;
            case 31 :
                // InternalExpressionLanguage.g:1:190: T__45
                {
                mT__45(); 

                }
                break;
            case 32 :
                // InternalExpressionLanguage.g:1:196: T__46
                {
                mT__46(); 

                }
                break;
            case 33 :
                // InternalExpressionLanguage.g:1:202: T__47
                {
                mT__47(); 

                }
                break;
            case 34 :
                // InternalExpressionLanguage.g:1:208: T__48
                {
                mT__48(); 

                }
                break;
            case 35 :
                // InternalExpressionLanguage.g:1:214: T__49
                {
                mT__49(); 

                }
                break;
            case 36 :
                // InternalExpressionLanguage.g:1:220: T__50
                {
                mT__50(); 

                }
                break;
            case 37 :
                // InternalExpressionLanguage.g:1:226: T__51
                {
                mT__51(); 

                }
                break;
            case 38 :
                // InternalExpressionLanguage.g:1:232: T__52
                {
                mT__52(); 

                }
                break;
            case 39 :
                // InternalExpressionLanguage.g:1:238: T__53
                {
                mT__53(); 

                }
                break;
            case 40 :
                // InternalExpressionLanguage.g:1:244: T__54
                {
                mT__54(); 

                }
                break;
            case 41 :
                // InternalExpressionLanguage.g:1:250: T__55
                {
                mT__55(); 

                }
                break;
            case 42 :
                // InternalExpressionLanguage.g:1:256: T__56
                {
                mT__56(); 

                }
                break;
            case 43 :
                // InternalExpressionLanguage.g:1:262: T__57
                {
                mT__57(); 

                }
                break;
            case 44 :
                // InternalExpressionLanguage.g:1:268: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 45 :
                // InternalExpressionLanguage.g:1:277: RULE_DOUBLE
                {
                mRULE_DOUBLE(); 

                }
                break;
            case 46 :
                // InternalExpressionLanguage.g:1:289: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 47 :
                // InternalExpressionLanguage.g:1:301: RULE_QUOTED_ID
                {
                mRULE_QUOTED_ID(); 

                }
                break;
            case 48 :
                // InternalExpressionLanguage.g:1:316: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 49 :
                // InternalExpressionLanguage.g:1:324: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 50 :
                // InternalExpressionLanguage.g:1:340: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 51 :
                // InternalExpressionLanguage.g:1:356: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 52 :
                // InternalExpressionLanguage.g:1:364: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA7 dfa7 = new DFA7(this);
    protected DFA17 dfa17 = new DFA17(this);
    static final String DFA7_eotS =
        "\5\uffff";
    static final String DFA7_eofS =
        "\5\uffff";
    static final String DFA7_minS =
        "\1\55\1\60\1\56\2\uffff";
    static final String DFA7_maxS =
        "\2\71\1\145\2\uffff";
    static final String DFA7_acceptS =
        "\3\uffff\1\1\1\2";
    static final String DFA7_specialS =
        "\5\uffff}>";
    static final String[] DFA7_transitionS = {
            "\1\1\2\uffff\12\2",
            "\12\2",
            "\1\4\1\uffff\12\2\53\uffff\1\3",
            "",
            ""
    };

    static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
    static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
    static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
    static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
    static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
    static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
    static final short[][] DFA7_transition;

    static {
        int numStates = DFA7_transitionS.length;
        DFA7_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
        }
    }

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = DFA7_eot;
            this.eof = DFA7_eof;
            this.min = DFA7_min;
            this.max = DFA7_max;
            this.accept = DFA7_accept;
            this.special = DFA7_special;
            this.transition = DFA7_transition;
        }
        public String getDescription() {
            return "1546:15: ( RULE_INT RULE_EXPONENT | RULE_INT '.' ( RULE_DIGIT )* ( RULE_EXPONENT )? )";
        }
    }
    static final String DFA17_eotS =
        "\1\uffff\3\55\1\61\1\62\3\uffff\1\67\2\55\1\73\1\75\1\uffff\1\100\1\uffff\1\102\1\uffff\1\107\1\uffff\1\111\1\112\1\113\1\114\1\115\1\116\1\117\1\120\1\121\1\123\1\124\1\uffff\1\126\1\127\1\130\1\131\1\132\1\133\2\53\3\uffff\1\140\1\uffff\2\55\6\uffff\1\55\1\uffff\3\55\10\uffff\1\133\16\uffff\1\147\16\uffff\1\150\1\151\4\55\3\uffff\1\156\1\55\1\160\1\55\1\uffff\1\162\1\uffff\1\163\2\uffff";
    static final String DFA17_eofS =
        "\164\uffff";
    static final String DFA17_minS =
        "\1\0\1\122\1\117\1\116\1\75\1\101\3\uffff\1\60\1\141\1\162\1\60\1\75\1\uffff\1\75\1\uffff\1\60\1\uffff\1\52\1\uffff\13\60\1\uffff\5\60\1\56\2\0\3\uffff\1\60\1\uffff\1\122\1\104\6\uffff\1\154\1\uffff\1\154\1\165\1\154\10\uffff\1\56\16\uffff\1\60\16\uffff\2\60\1\154\1\165\1\145\1\163\3\uffff\1\60\1\145\1\60\1\145\1\uffff\1\60\1\uffff\1\60\2\uffff";
    static final String DFA17_maxS =
        "\1\uffff\1\122\1\117\1\116\1\75\1\172\3\uffff\1\172\1\141\1\162\1\172\1\75\1\uffff\1\75\1\uffff\1\71\1\uffff\1\57\1\uffff\13\172\1\uffff\5\172\1\145\2\uffff\3\uffff\1\172\1\uffff\1\122\1\104\6\uffff\1\154\1\uffff\1\154\1\165\1\154\10\uffff\1\145\16\uffff\1\172\16\uffff\2\172\1\154\1\165\1\145\1\163\3\uffff\1\172\1\145\1\172\1\145\1\uffff\1\172\1\uffff\1\172\2\uffff";
    static final String DFA17_acceptS =
        "\6\uffff\1\6\1\7\1\10\5\uffff\1\17\1\uffff\1\23\1\uffff\1\25\1\uffff\1\27\13\uffff\1\45\10\uffff\1\60\1\63\1\64\1\uffff\1\60\2\uffff\1\20\1\4\1\5\1\6\1\7\1\10\1\uffff\1\43\3\uffff\1\50\1\15\1\16\1\17\1\22\1\21\1\23\1\24\1\uffff\1\25\1\61\1\62\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1\uffff\1\42\1\44\1\45\1\46\1\47\1\51\1\52\1\53\1\54\1\55\1\56\1\57\1\63\1\1\6\uffff\1\41\1\2\1\3\4\uffff\1\11\1\uffff\1\13\1\uffff\1\12\1\14";
    static final String DFA17_specialS =
        "\1\1\46\uffff\1\0\1\2\113\uffff}>";
    static final String[] DFA17_transitionS = {
            "\11\53\2\52\2\53\1\52\22\53\1\52\1\4\1\47\2\53\1\24\1\53\1\50\1\6\1\7\1\22\1\20\1\10\1\21\1\53\1\23\12\46\2\53\1\17\1\16\1\15\2\53\1\3\3\51\1\27\1\51\1\32\5\51\1\33\1\51\1\1\1\30\3\51\1\31\3\51\1\2\1\25\1\26\3\53\1\5\1\51\1\53\1\43\1\51\1\11\1\36\1\51\1\14\1\51\1\35\2\51\1\34\1\51\1\37\1\41\1\51\1\42\3\51\1\13\1\51\1\12\2\51\1\45\1\44\72\53\1\40\uff4a\53",
            "\1\54",
            "\1\56",
            "\1\57",
            "\1\60",
            "\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "",
            "",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\1\66\31\55",
            "\1\70",
            "\1\71",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\1\72\31\55",
            "\1\74",
            "",
            "\1\77",
            "",
            "\12\103",
            "",
            "\1\105\4\uffff\1\106",
            "",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\1\122\31\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\134\1\uffff\12\103\53\uffff\1\134",
            "\0\135",
            "\0\136",
            "",
            "",
            "",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "\1\141",
            "\1\142",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\143",
            "",
            "\1\144",
            "\1\145",
            "\1\146",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\134\1\uffff\12\103\53\uffff\1\134",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\152",
            "\1\153",
            "\1\154",
            "\1\155",
            "",
            "",
            "",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\157",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\161",
            "",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            ""
    };

    static final short[] DFA17_eot = DFA.unpackEncodedString(DFA17_eotS);
    static final short[] DFA17_eof = DFA.unpackEncodedString(DFA17_eofS);
    static final char[] DFA17_min = DFA.unpackEncodedStringToUnsignedChars(DFA17_minS);
    static final char[] DFA17_max = DFA.unpackEncodedStringToUnsignedChars(DFA17_maxS);
    static final short[] DFA17_accept = DFA.unpackEncodedString(DFA17_acceptS);
    static final short[] DFA17_special = DFA.unpackEncodedString(DFA17_specialS);
    static final short[][] DFA17_transition;

    static {
        int numStates = DFA17_transitionS.length;
        DFA17_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA17_transition[i] = DFA.unpackEncodedString(DFA17_transitionS[i]);
        }
    }

    class DFA17 extends DFA {

        public DFA17(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 17;
            this.eot = DFA17_eot;
            this.eof = DFA17_eof;
            this.min = DFA17_min;
            this.max = DFA17_max;
            this.accept = DFA17_accept;
            this.special = DFA17_special;
            this.transition = DFA17_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | RULE_INT | RULE_DOUBLE | RULE_STRING | RULE_QUOTED_ID | RULE_ID | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA17_39 = input.LA(1);

                        s = -1;
                        if ( ((LA17_39>='\u0000' && LA17_39<='\uFFFF')) ) {s = 93;}

                        else s = 43;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA17_0 = input.LA(1);

                        s = -1;
                        if ( (LA17_0=='O') ) {s = 1;}

                        else if ( (LA17_0=='X') ) {s = 2;}

                        else if ( (LA17_0=='A') ) {s = 3;}

                        else if ( (LA17_0=='!') ) {s = 4;}

                        else if ( (LA17_0=='^') ) {s = 5;}

                        else if ( (LA17_0=='(') ) {s = 6;}

                        else if ( (LA17_0==')') ) {s = 7;}

                        else if ( (LA17_0==',') ) {s = 8;}

                        else if ( (LA17_0=='c') ) {s = 9;}

                        else if ( (LA17_0=='v') ) {s = 10;}

                        else if ( (LA17_0=='t') ) {s = 11;}

                        else if ( (LA17_0=='f') ) {s = 12;}

                        else if ( (LA17_0=='>') ) {s = 13;}

                        else if ( (LA17_0=='=') ) {s = 14;}

                        else if ( (LA17_0=='<') ) {s = 15;}

                        else if ( (LA17_0=='+') ) {s = 16;}

                        else if ( (LA17_0=='-') ) {s = 17;}

                        else if ( (LA17_0=='*') ) {s = 18;}

                        else if ( (LA17_0=='/') ) {s = 19;}

                        else if ( (LA17_0=='%') ) {s = 20;}

                        else if ( (LA17_0=='Y') ) {s = 21;}

                        else if ( (LA17_0=='Z') ) {s = 22;}

                        else if ( (LA17_0=='E') ) {s = 23;}

                        else if ( (LA17_0=='P') ) {s = 24;}

                        else if ( (LA17_0=='T') ) {s = 25;}

                        else if ( (LA17_0=='G') ) {s = 26;}

                        else if ( (LA17_0=='M') ) {s = 27;}

                        else if ( (LA17_0=='k') ) {s = 28;}

                        else if ( (LA17_0=='h') ) {s = 29;}

                        else if ( (LA17_0=='d') ) {s = 30;}

                        else if ( (LA17_0=='m') ) {s = 31;}

                        else if ( (LA17_0=='\u00B5') ) {s = 32;}

                        else if ( (LA17_0=='n') ) {s = 33;}

                        else if ( (LA17_0=='p') ) {s = 34;}

                        else if ( (LA17_0=='a') ) {s = 35;}

                        else if ( (LA17_0=='z') ) {s = 36;}

                        else if ( (LA17_0=='y') ) {s = 37;}

                        else if ( ((LA17_0>='0' && LA17_0<='9')) ) {s = 38;}

                        else if ( (LA17_0=='\"') ) {s = 39;}

                        else if ( (LA17_0=='\'') ) {s = 40;}

                        else if ( ((LA17_0>='B' && LA17_0<='D')||LA17_0=='F'||(LA17_0>='H' && LA17_0<='L')||LA17_0=='N'||(LA17_0>='Q' && LA17_0<='S')||(LA17_0>='U' && LA17_0<='W')||LA17_0=='_'||LA17_0=='b'||LA17_0=='e'||LA17_0=='g'||(LA17_0>='i' && LA17_0<='j')||LA17_0=='l'||LA17_0=='o'||(LA17_0>='q' && LA17_0<='s')||LA17_0=='u'||(LA17_0>='w' && LA17_0<='x')) ) {s = 41;}

                        else if ( ((LA17_0>='\t' && LA17_0<='\n')||LA17_0=='\r'||LA17_0==' ') ) {s = 42;}

                        else if ( ((LA17_0>='\u0000' && LA17_0<='\b')||(LA17_0>='\u000B' && LA17_0<='\f')||(LA17_0>='\u000E' && LA17_0<='\u001F')||(LA17_0>='#' && LA17_0<='$')||LA17_0=='&'||LA17_0=='.'||(LA17_0>=':' && LA17_0<=';')||(LA17_0>='?' && LA17_0<='@')||(LA17_0>='[' && LA17_0<=']')||LA17_0=='`'||(LA17_0>='{' && LA17_0<='\u00B4')||(LA17_0>='\u00B6' && LA17_0<='\uFFFF')) ) {s = 43;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA17_40 = input.LA(1);

                        s = -1;
                        if ( ((LA17_40>='\u0000' && LA17_40<='\uFFFF')) ) {s = 94;}

                        else s = 43;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 17, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}
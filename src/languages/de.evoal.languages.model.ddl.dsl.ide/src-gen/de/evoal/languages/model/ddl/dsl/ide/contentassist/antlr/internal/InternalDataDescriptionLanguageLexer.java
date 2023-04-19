package de.evoal.languages.model.ddl.dsl.ide.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalDataDescriptionLanguageLexer extends Lexer {
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__59=59;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=5;
    public static final int RULE_QUOTED_ID=4;
    public static final int RULE_DIGIT=9;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=8;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=11;
    public static final int T__23=23;
    public static final int T__67=67;
    public static final int T__24=24;
    public static final int T__68=68;
    public static final int T__25=25;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__20=20;
    public static final int T__64=64;
    public static final int T__21=21;
    public static final int T__65=65;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=12;
    public static final int T__37=37;
    public static final int RULE_DOUBLE=7;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__77=77;
    public static final int T__34=34;
    public static final int T__78=78;
    public static final int T__35=35;
    public static final int T__79=79;
    public static final int T__36=36;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__74=74;
    public static final int T__31=31;
    public static final int T__75=75;
    public static final int T__32=32;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_WS=13;
    public static final int RULE_ANY_OTHER=14;
    public static final int RULE_EXPONENT=10;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__88=88;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__84=84;
    public static final int T__41=41;
    public static final int T__85=85;
    public static final int T__42=42;
    public static final int T__86=86;
    public static final int T__43=43;
    public static final int T__87=87;

    // delegates
    // delegators

    public InternalDataDescriptionLanguageLexer() {;} 
    public InternalDataDescriptionLanguageLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalDataDescriptionLanguageLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalDataDescriptionLanguage.g"; }

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDataDescriptionLanguage.g:11:7: ( 'false' )
            // InternalDataDescriptionLanguage.g:11:9: 'false'
            {
            match("false"); 


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
            // InternalDataDescriptionLanguage.g:12:7: ( 'nominal' )
            // InternalDataDescriptionLanguage.g:12:9: 'nominal'
            {
            match("nominal"); 


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
            // InternalDataDescriptionLanguage.g:13:7: ( 'ordinal' )
            // InternalDataDescriptionLanguage.g:13:9: 'ordinal'
            {
            match("ordinal"); 


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
            // InternalDataDescriptionLanguage.g:14:7: ( 'cardinal' )
            // InternalDataDescriptionLanguage.g:14:9: 'cardinal'
            {
            match("cardinal"); 


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
            // InternalDataDescriptionLanguage.g:15:7: ( 'quotient' )
            // InternalDataDescriptionLanguage.g:15:9: 'quotient'
            {
            match("quotient"); 


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
            // InternalDataDescriptionLanguage.g:16:7: ( 'real' )
            // InternalDataDescriptionLanguage.g:16:9: 'real'
            {
            match("real"); 


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
            // InternalDataDescriptionLanguage.g:17:7: ( 'integer' )
            // InternalDataDescriptionLanguage.g:17:9: 'integer'
            {
            match("integer"); 


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
            // InternalDataDescriptionLanguage.g:18:7: ( 'boolean' )
            // InternalDataDescriptionLanguage.g:18:9: 'boolean'
            {
            match("boolean"); 


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
            // InternalDataDescriptionLanguage.g:19:7: ( 'string' )
            // InternalDataDescriptionLanguage.g:19:9: 'string'
            {
            match("string"); 


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
            // InternalDataDescriptionLanguage.g:20:7: ( '>=' )
            // InternalDataDescriptionLanguage.g:20:9: '>='
            {
            match(">="); 


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
            // InternalDataDescriptionLanguage.g:21:7: ( '>' )
            // InternalDataDescriptionLanguage.g:21:9: '>'
            {
            match('>'); 

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
            // InternalDataDescriptionLanguage.g:22:7: ( '=' )
            // InternalDataDescriptionLanguage.g:22:9: '='
            {
            match('='); 

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
            // InternalDataDescriptionLanguage.g:23:7: ( '!=' )
            // InternalDataDescriptionLanguage.g:23:9: '!='
            {
            match("!="); 


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
            // InternalDataDescriptionLanguage.g:24:7: ( '<' )
            // InternalDataDescriptionLanguage.g:24:9: '<'
            {
            match('<'); 

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
            // InternalDataDescriptionLanguage.g:25:7: ( '<=' )
            // InternalDataDescriptionLanguage.g:25:9: '<='
            {
            match("<="); 


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
            // InternalDataDescriptionLanguage.g:26:7: ( '+' )
            // InternalDataDescriptionLanguage.g:26:9: '+'
            {
            match('+'); 

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
            // InternalDataDescriptionLanguage.g:27:7: ( '-' )
            // InternalDataDescriptionLanguage.g:27:9: '-'
            {
            match('-'); 

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
            // InternalDataDescriptionLanguage.g:28:7: ( '*' )
            // InternalDataDescriptionLanguage.g:28:9: '*'
            {
            match('*'); 

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
            // InternalDataDescriptionLanguage.g:29:7: ( '/' )
            // InternalDataDescriptionLanguage.g:29:9: '/'
            {
            match('/'); 

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
            // InternalDataDescriptionLanguage.g:30:7: ( '%' )
            // InternalDataDescriptionLanguage.g:30:9: '%'
            {
            match('%'); 

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
            // InternalDataDescriptionLanguage.g:31:7: ( 'Y' )
            // InternalDataDescriptionLanguage.g:31:9: 'Y'
            {
            match('Y'); 

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
            // InternalDataDescriptionLanguage.g:32:7: ( 'Z' )
            // InternalDataDescriptionLanguage.g:32:9: 'Z'
            {
            match('Z'); 

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
            // InternalDataDescriptionLanguage.g:33:7: ( 'E' )
            // InternalDataDescriptionLanguage.g:33:9: 'E'
            {
            match('E'); 

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
            // InternalDataDescriptionLanguage.g:34:7: ( 'P' )
            // InternalDataDescriptionLanguage.g:34:9: 'P'
            {
            match('P'); 

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
            // InternalDataDescriptionLanguage.g:35:7: ( 'T' )
            // InternalDataDescriptionLanguage.g:35:9: 'T'
            {
            match('T'); 

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
            // InternalDataDescriptionLanguage.g:36:7: ( 'G' )
            // InternalDataDescriptionLanguage.g:36:9: 'G'
            {
            match('G'); 

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
            // InternalDataDescriptionLanguage.g:37:7: ( 'M' )
            // InternalDataDescriptionLanguage.g:37:9: 'M'
            {
            match('M'); 

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
            // InternalDataDescriptionLanguage.g:38:7: ( 'k' )
            // InternalDataDescriptionLanguage.g:38:9: 'k'
            {
            match('k'); 

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
            // InternalDataDescriptionLanguage.g:39:7: ( 'h' )
            // InternalDataDescriptionLanguage.g:39:9: 'h'
            {
            match('h'); 

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
            // InternalDataDescriptionLanguage.g:40:7: ( 'da' )
            // InternalDataDescriptionLanguage.g:40:9: 'da'
            {
            match("da"); 


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
            // InternalDataDescriptionLanguage.g:41:7: ( 'd' )
            // InternalDataDescriptionLanguage.g:41:9: 'd'
            {
            match('d'); 

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
            // InternalDataDescriptionLanguage.g:42:7: ( 'c' )
            // InternalDataDescriptionLanguage.g:42:9: 'c'
            {
            match('c'); 

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
            // InternalDataDescriptionLanguage.g:43:7: ( 'm' )
            // InternalDataDescriptionLanguage.g:43:9: 'm'
            {
            match('m'); 

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
            // InternalDataDescriptionLanguage.g:44:7: ( '\\u00B5' )
            // InternalDataDescriptionLanguage.g:44:9: '\\u00B5'
            {
            match('\u00B5'); 

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
            // InternalDataDescriptionLanguage.g:45:7: ( 'n' )
            // InternalDataDescriptionLanguage.g:45:9: 'n'
            {
            match('n'); 

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
            // InternalDataDescriptionLanguage.g:46:7: ( 'p' )
            // InternalDataDescriptionLanguage.g:46:9: 'p'
            {
            match('p'); 

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
            // InternalDataDescriptionLanguage.g:47:7: ( 'f' )
            // InternalDataDescriptionLanguage.g:47:9: 'f'
            {
            match('f'); 

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
            // InternalDataDescriptionLanguage.g:48:7: ( 'a' )
            // InternalDataDescriptionLanguage.g:48:9: 'a'
            {
            match('a'); 

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
            // InternalDataDescriptionLanguage.g:49:7: ( 'z' )
            // InternalDataDescriptionLanguage.g:49:9: 'z'
            {
            match('z'); 

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
            // InternalDataDescriptionLanguage.g:50:7: ( 'y' )
            // InternalDataDescriptionLanguage.g:50:9: 'y'
            {
            match('y'); 

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
            // InternalDataDescriptionLanguage.g:51:7: ( 'module' )
            // InternalDataDescriptionLanguage.g:51:9: 'module'
            {
            match("module"); 


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
            // InternalDataDescriptionLanguage.g:52:7: ( '{' )
            // InternalDataDescriptionLanguage.g:52:9: '{'
            {
            match('{'); 

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
            // InternalDataDescriptionLanguage.g:53:7: ( '}' )
            // InternalDataDescriptionLanguage.g:53:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDataDescriptionLanguage.g:54:7: ( 'types' )
            // InternalDataDescriptionLanguage.g:54:9: 'types'
            {
            match("types"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException {
        try {
            int _type = T__59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDataDescriptionLanguage.g:55:7: ( ':' )
            // InternalDataDescriptionLanguage.g:55:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__59"

    // $ANTLR start "T__60"
    public final void mT__60() throws RecognitionException {
        try {
            int _type = T__60;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDataDescriptionLanguage.g:56:7: ( 'data' )
            // InternalDataDescriptionLanguage.g:56:9: 'data'
            {
            match("data"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__60"

    // $ANTLR start "T__61"
    public final void mT__61() throws RecognitionException {
        try {
            int _type = T__61;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDataDescriptionLanguage.g:57:7: ( 'constraints' )
            // InternalDataDescriptionLanguage.g:57:9: 'constraints'
            {
            match("constraints"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__61"

    // $ANTLR start "T__62"
    public final void mT__62() throws RecognitionException {
        try {
            int _type = T__62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDataDescriptionLanguage.g:58:7: ( 'import' )
            // InternalDataDescriptionLanguage.g:58:9: 'import'
            {
            match("import"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__62"

    // $ANTLR start "T__63"
    public final void mT__63() throws RecognitionException {
        try {
            int _type = T__63;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDataDescriptionLanguage.g:59:7: ( ';' )
            // InternalDataDescriptionLanguage.g:59:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__63"

    // $ANTLR start "T__64"
    public final void mT__64() throws RecognitionException {
        try {
            int _type = T__64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDataDescriptionLanguage.g:60:7: ( 'type' )
            // InternalDataDescriptionLanguage.g:60:9: 'type'
            {
            match("type"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__64"

    // $ANTLR start "T__65"
    public final void mT__65() throws RecognitionException {
        try {
            int _type = T__65;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDataDescriptionLanguage.g:61:7: ( 'description' )
            // InternalDataDescriptionLanguage.g:61:9: 'description'
            {
            match("description"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__65"

    // $ANTLR start "T__66"
    public final void mT__66() throws RecognitionException {
        try {
            int _type = T__66;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDataDescriptionLanguage.g:62:7: ( 'with' )
            // InternalDataDescriptionLanguage.g:62:9: 'with'
            {
            match("with"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__66"

    // $ANTLR start "T__67"
    public final void mT__67() throws RecognitionException {
        try {
            int _type = T__67;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDataDescriptionLanguage.g:63:7: ( 'of' )
            // InternalDataDescriptionLanguage.g:63:9: 'of'
            {
            match("of"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__67"

    // $ANTLR start "T__68"
    public final void mT__68() throws RecognitionException {
        try {
            int _type = T__68;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDataDescriptionLanguage.g:64:7: ( 'value' )
            // InternalDataDescriptionLanguage.g:64:9: 'value'
            {
            match("value"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__68"

    // $ANTLR start "T__69"
    public final void mT__69() throws RecognitionException {
        try {
            int _type = T__69;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDataDescriptionLanguage.g:65:7: ( 'OR' )
            // InternalDataDescriptionLanguage.g:65:9: 'OR'
            {
            match("OR"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__69"

    // $ANTLR start "T__70"
    public final void mT__70() throws RecognitionException {
        try {
            int _type = T__70;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDataDescriptionLanguage.g:66:7: ( 'XOR' )
            // InternalDataDescriptionLanguage.g:66:9: 'XOR'
            {
            match("XOR"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__70"

    // $ANTLR start "T__71"
    public final void mT__71() throws RecognitionException {
        try {
            int _type = T__71;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDataDescriptionLanguage.g:67:7: ( 'AND' )
            // InternalDataDescriptionLanguage.g:67:9: 'AND'
            {
            match("AND"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__71"

    // $ANTLR start "T__72"
    public final void mT__72() throws RecognitionException {
        try {
            int _type = T__72;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDataDescriptionLanguage.g:68:7: ( '^' )
            // InternalDataDescriptionLanguage.g:68:9: '^'
            {
            match('^'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__72"

    // $ANTLR start "T__73"
    public final void mT__73() throws RecognitionException {
        try {
            int _type = T__73;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDataDescriptionLanguage.g:69:7: ( '[' )
            // InternalDataDescriptionLanguage.g:69:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__73"

    // $ANTLR start "T__74"
    public final void mT__74() throws RecognitionException {
        try {
            int _type = T__74;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDataDescriptionLanguage.g:70:7: ( ']' )
            // InternalDataDescriptionLanguage.g:70:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__74"

    // $ANTLR start "T__75"
    public final void mT__75() throws RecognitionException {
        try {
            int _type = T__75;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDataDescriptionLanguage.g:71:7: ( ',' )
            // InternalDataDescriptionLanguage.g:71:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__75"

    // $ANTLR start "T__76"
    public final void mT__76() throws RecognitionException {
        try {
            int _type = T__76;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDataDescriptionLanguage.g:72:7: ( '(' )
            // InternalDataDescriptionLanguage.g:72:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__76"

    // $ANTLR start "T__77"
    public final void mT__77() throws RecognitionException {
        try {
            int _type = T__77;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDataDescriptionLanguage.g:73:7: ( ')' )
            // InternalDataDescriptionLanguage.g:73:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__77"

    // $ANTLR start "T__78"
    public final void mT__78() throws RecognitionException {
        try {
            int _type = T__78;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDataDescriptionLanguage.g:74:7: ( ':=' )
            // InternalDataDescriptionLanguage.g:74:9: ':='
            {
            match(":="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__78"

    // $ANTLR start "T__79"
    public final void mT__79() throws RecognitionException {
        try {
            int _type = T__79;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDataDescriptionLanguage.g:75:7: ( 'literal' )
            // InternalDataDescriptionLanguage.g:75:9: 'literal'
            {
            match("literal"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__79"

    // $ANTLR start "T__80"
    public final void mT__80() throws RecognitionException {
        try {
            int _type = T__80;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDataDescriptionLanguage.g:76:7: ( 'instance' )
            // InternalDataDescriptionLanguage.g:76:9: 'instance'
            {
            match("instance"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__80"

    // $ANTLR start "T__81"
    public final void mT__81() throws RecognitionException {
        try {
            int _type = T__81;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDataDescriptionLanguage.g:77:7: ( 'expression' )
            // InternalDataDescriptionLanguage.g:77:9: 'expression'
            {
            match("expression"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__81"

    // $ANTLR start "T__82"
    public final void mT__82() throws RecognitionException {
        try {
            int _type = T__82;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDataDescriptionLanguage.g:78:7: ( 'int' )
            // InternalDataDescriptionLanguage.g:78:9: 'int'
            {
            match("int"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__82"

    // $ANTLR start "T__83"
    public final void mT__83() throws RecognitionException {
        try {
            int _type = T__83;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDataDescriptionLanguage.g:79:7: ( 'float' )
            // InternalDataDescriptionLanguage.g:79:9: 'float'
            {
            match("float"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__83"

    // $ANTLR start "T__84"
    public final void mT__84() throws RecognitionException {
        try {
            int _type = T__84;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDataDescriptionLanguage.g:80:7: ( 'void' )
            // InternalDataDescriptionLanguage.g:80:9: 'void'
            {
            match("void"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__84"

    // $ANTLR start "T__85"
    public final void mT__85() throws RecognitionException {
        try {
            int _type = T__85;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDataDescriptionLanguage.g:81:7: ( 'array' )
            // InternalDataDescriptionLanguage.g:81:9: 'array'
            {
            match("array"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__85"

    // $ANTLR start "T__86"
    public final void mT__86() throws RecognitionException {
        try {
            int _type = T__86;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDataDescriptionLanguage.g:82:7: ( '.' )
            // InternalDataDescriptionLanguage.g:82:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__86"

    // $ANTLR start "T__87"
    public final void mT__87() throws RecognitionException {
        try {
            int _type = T__87;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDataDescriptionLanguage.g:83:7: ( '!' )
            // InternalDataDescriptionLanguage.g:83:9: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__87"

    // $ANTLR start "T__88"
    public final void mT__88() throws RecognitionException {
        try {
            int _type = T__88;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDataDescriptionLanguage.g:84:7: ( 'true' )
            // InternalDataDescriptionLanguage.g:84:9: 'true'
            {
            match("true"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__88"

    // $ANTLR start "RULE_DIGIT"
    public final void mRULE_DIGIT() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:7259:21: ( '0' .. '9' )
            // InternalDataDescriptionLanguage.g:7259:23: '0' .. '9'
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
            // InternalDataDescriptionLanguage.g:7261:24: ( 'e' ( '+' | '-' )? ( RULE_DIGIT )+ )
            // InternalDataDescriptionLanguage.g:7261:26: 'e' ( '+' | '-' )? ( RULE_DIGIT )+
            {
            match('e'); 
            // InternalDataDescriptionLanguage.g:7261:30: ( '+' | '-' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='+'||LA1_0=='-') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:
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

            // InternalDataDescriptionLanguage.g:7261:41: ( RULE_DIGIT )+
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
            	    // InternalDataDescriptionLanguage.g:7261:41: RULE_DIGIT
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
            // InternalDataDescriptionLanguage.g:7263:10: ( ( '-' )? ( RULE_DIGIT )+ )
            // InternalDataDescriptionLanguage.g:7263:12: ( '-' )? ( RULE_DIGIT )+
            {
            // InternalDataDescriptionLanguage.g:7263:12: ( '-' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='-') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:7263:12: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // InternalDataDescriptionLanguage.g:7263:17: ( RULE_DIGIT )+
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
            	    // InternalDataDescriptionLanguage.g:7263:17: RULE_DIGIT
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
            // InternalDataDescriptionLanguage.g:7265:13: ( ( RULE_INT RULE_EXPONENT | RULE_INT '.' ( RULE_DIGIT )* ( RULE_EXPONENT )? ) )
            // InternalDataDescriptionLanguage.g:7265:15: ( RULE_INT RULE_EXPONENT | RULE_INT '.' ( RULE_DIGIT )* ( RULE_EXPONENT )? )
            {
            // InternalDataDescriptionLanguage.g:7265:15: ( RULE_INT RULE_EXPONENT | RULE_INT '.' ( RULE_DIGIT )* ( RULE_EXPONENT )? )
            int alt7=2;
            alt7 = dfa7.predict(input);
            switch (alt7) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:7265:16: RULE_INT RULE_EXPONENT
                    {
                    mRULE_INT(); 
                    mRULE_EXPONENT(); 

                    }
                    break;
                case 2 :
                    // InternalDataDescriptionLanguage.g:7265:39: RULE_INT '.' ( RULE_DIGIT )* ( RULE_EXPONENT )?
                    {
                    mRULE_INT(); 
                    match('.'); 
                    // InternalDataDescriptionLanguage.g:7265:52: ( RULE_DIGIT )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // InternalDataDescriptionLanguage.g:7265:52: RULE_DIGIT
                    	    {
                    	    mRULE_DIGIT(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    // InternalDataDescriptionLanguage.g:7265:64: ( RULE_EXPONENT )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0=='e') ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // InternalDataDescriptionLanguage.g:7265:64: RULE_EXPONENT
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
            // InternalDataDescriptionLanguage.g:7267:13: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' )
            // InternalDataDescriptionLanguage.g:7267:15: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
            {
            match('\"'); 
            // InternalDataDescriptionLanguage.g:7267:19: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
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
            	    // InternalDataDescriptionLanguage.g:7267:20: '\\\\' .
            	    {
            	    match('\\'); 
            	    matchAny(); 

            	    }
            	    break;
            	case 2 :
            	    // InternalDataDescriptionLanguage.g:7267:27: ~ ( ( '\\\\' | '\"' ) )
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
            // InternalDataDescriptionLanguage.g:7269:16: ( '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            // InternalDataDescriptionLanguage.g:7269:18: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
            {
            match('\''); 
            // InternalDataDescriptionLanguage.g:7269:23: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
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
            	    // InternalDataDescriptionLanguage.g:7269:24: '\\\\' .
            	    {
            	    match('\\'); 
            	    matchAny(); 

            	    }
            	    break;
            	case 2 :
            	    // InternalDataDescriptionLanguage.g:7269:31: ~ ( ( '\\\\' | '\\'' ) )
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
            // InternalDataDescriptionLanguage.g:7271:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalDataDescriptionLanguage.g:7271:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalDataDescriptionLanguage.g:7271:11: ( '^' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='^') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:7271:11: '^'
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

            // InternalDataDescriptionLanguage.g:7271:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='0' && LA11_0<='9')||(LA11_0>='A' && LA11_0<='Z')||LA11_0=='_'||(LA11_0>='a' && LA11_0<='z')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:
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
            // InternalDataDescriptionLanguage.g:7273:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalDataDescriptionLanguage.g:7273:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalDataDescriptionLanguage.g:7273:24: ( options {greedy=false; } : . )*
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
            	    // InternalDataDescriptionLanguage.g:7273:52: .
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
            // InternalDataDescriptionLanguage.g:7275:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalDataDescriptionLanguage.g:7275:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalDataDescriptionLanguage.g:7275:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>='\u0000' && LA13_0<='\t')||(LA13_0>='\u000B' && LA13_0<='\f')||(LA13_0>='\u000E' && LA13_0<='\uFFFF')) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:7275:24: ~ ( ( '\\n' | '\\r' ) )
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

            // InternalDataDescriptionLanguage.g:7275:40: ( ( '\\r' )? '\\n' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0=='\n'||LA15_0=='\r') ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:7275:41: ( '\\r' )? '\\n'
                    {
                    // InternalDataDescriptionLanguage.g:7275:41: ( '\\r' )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0=='\r') ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // InternalDataDescriptionLanguage.g:7275:41: '\\r'
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
            // InternalDataDescriptionLanguage.g:7277:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalDataDescriptionLanguage.g:7277:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalDataDescriptionLanguage.g:7277:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            	    // InternalDataDescriptionLanguage.g:
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
            // InternalDataDescriptionLanguage.g:7279:16: ( . )
            // InternalDataDescriptionLanguage.g:7279:18: .
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
        // InternalDataDescriptionLanguage.g:1:8: ( T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | RULE_INT | RULE_DOUBLE | RULE_STRING | RULE_QUOTED_ID | RULE_ID | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt17=83;
        alt17 = dfa17.predict(input);
        switch (alt17) {
            case 1 :
                // InternalDataDescriptionLanguage.g:1:10: T__15
                {
                mT__15(); 

                }
                break;
            case 2 :
                // InternalDataDescriptionLanguage.g:1:16: T__16
                {
                mT__16(); 

                }
                break;
            case 3 :
                // InternalDataDescriptionLanguage.g:1:22: T__17
                {
                mT__17(); 

                }
                break;
            case 4 :
                // InternalDataDescriptionLanguage.g:1:28: T__18
                {
                mT__18(); 

                }
                break;
            case 5 :
                // InternalDataDescriptionLanguage.g:1:34: T__19
                {
                mT__19(); 

                }
                break;
            case 6 :
                // InternalDataDescriptionLanguage.g:1:40: T__20
                {
                mT__20(); 

                }
                break;
            case 7 :
                // InternalDataDescriptionLanguage.g:1:46: T__21
                {
                mT__21(); 

                }
                break;
            case 8 :
                // InternalDataDescriptionLanguage.g:1:52: T__22
                {
                mT__22(); 

                }
                break;
            case 9 :
                // InternalDataDescriptionLanguage.g:1:58: T__23
                {
                mT__23(); 

                }
                break;
            case 10 :
                // InternalDataDescriptionLanguage.g:1:64: T__24
                {
                mT__24(); 

                }
                break;
            case 11 :
                // InternalDataDescriptionLanguage.g:1:70: T__25
                {
                mT__25(); 

                }
                break;
            case 12 :
                // InternalDataDescriptionLanguage.g:1:76: T__26
                {
                mT__26(); 

                }
                break;
            case 13 :
                // InternalDataDescriptionLanguage.g:1:82: T__27
                {
                mT__27(); 

                }
                break;
            case 14 :
                // InternalDataDescriptionLanguage.g:1:88: T__28
                {
                mT__28(); 

                }
                break;
            case 15 :
                // InternalDataDescriptionLanguage.g:1:94: T__29
                {
                mT__29(); 

                }
                break;
            case 16 :
                // InternalDataDescriptionLanguage.g:1:100: T__30
                {
                mT__30(); 

                }
                break;
            case 17 :
                // InternalDataDescriptionLanguage.g:1:106: T__31
                {
                mT__31(); 

                }
                break;
            case 18 :
                // InternalDataDescriptionLanguage.g:1:112: T__32
                {
                mT__32(); 

                }
                break;
            case 19 :
                // InternalDataDescriptionLanguage.g:1:118: T__33
                {
                mT__33(); 

                }
                break;
            case 20 :
                // InternalDataDescriptionLanguage.g:1:124: T__34
                {
                mT__34(); 

                }
                break;
            case 21 :
                // InternalDataDescriptionLanguage.g:1:130: T__35
                {
                mT__35(); 

                }
                break;
            case 22 :
                // InternalDataDescriptionLanguage.g:1:136: T__36
                {
                mT__36(); 

                }
                break;
            case 23 :
                // InternalDataDescriptionLanguage.g:1:142: T__37
                {
                mT__37(); 

                }
                break;
            case 24 :
                // InternalDataDescriptionLanguage.g:1:148: T__38
                {
                mT__38(); 

                }
                break;
            case 25 :
                // InternalDataDescriptionLanguage.g:1:154: T__39
                {
                mT__39(); 

                }
                break;
            case 26 :
                // InternalDataDescriptionLanguage.g:1:160: T__40
                {
                mT__40(); 

                }
                break;
            case 27 :
                // InternalDataDescriptionLanguage.g:1:166: T__41
                {
                mT__41(); 

                }
                break;
            case 28 :
                // InternalDataDescriptionLanguage.g:1:172: T__42
                {
                mT__42(); 

                }
                break;
            case 29 :
                // InternalDataDescriptionLanguage.g:1:178: T__43
                {
                mT__43(); 

                }
                break;
            case 30 :
                // InternalDataDescriptionLanguage.g:1:184: T__44
                {
                mT__44(); 

                }
                break;
            case 31 :
                // InternalDataDescriptionLanguage.g:1:190: T__45
                {
                mT__45(); 

                }
                break;
            case 32 :
                // InternalDataDescriptionLanguage.g:1:196: T__46
                {
                mT__46(); 

                }
                break;
            case 33 :
                // InternalDataDescriptionLanguage.g:1:202: T__47
                {
                mT__47(); 

                }
                break;
            case 34 :
                // InternalDataDescriptionLanguage.g:1:208: T__48
                {
                mT__48(); 

                }
                break;
            case 35 :
                // InternalDataDescriptionLanguage.g:1:214: T__49
                {
                mT__49(); 

                }
                break;
            case 36 :
                // InternalDataDescriptionLanguage.g:1:220: T__50
                {
                mT__50(); 

                }
                break;
            case 37 :
                // InternalDataDescriptionLanguage.g:1:226: T__51
                {
                mT__51(); 

                }
                break;
            case 38 :
                // InternalDataDescriptionLanguage.g:1:232: T__52
                {
                mT__52(); 

                }
                break;
            case 39 :
                // InternalDataDescriptionLanguage.g:1:238: T__53
                {
                mT__53(); 

                }
                break;
            case 40 :
                // InternalDataDescriptionLanguage.g:1:244: T__54
                {
                mT__54(); 

                }
                break;
            case 41 :
                // InternalDataDescriptionLanguage.g:1:250: T__55
                {
                mT__55(); 

                }
                break;
            case 42 :
                // InternalDataDescriptionLanguage.g:1:256: T__56
                {
                mT__56(); 

                }
                break;
            case 43 :
                // InternalDataDescriptionLanguage.g:1:262: T__57
                {
                mT__57(); 

                }
                break;
            case 44 :
                // InternalDataDescriptionLanguage.g:1:268: T__58
                {
                mT__58(); 

                }
                break;
            case 45 :
                // InternalDataDescriptionLanguage.g:1:274: T__59
                {
                mT__59(); 

                }
                break;
            case 46 :
                // InternalDataDescriptionLanguage.g:1:280: T__60
                {
                mT__60(); 

                }
                break;
            case 47 :
                // InternalDataDescriptionLanguage.g:1:286: T__61
                {
                mT__61(); 

                }
                break;
            case 48 :
                // InternalDataDescriptionLanguage.g:1:292: T__62
                {
                mT__62(); 

                }
                break;
            case 49 :
                // InternalDataDescriptionLanguage.g:1:298: T__63
                {
                mT__63(); 

                }
                break;
            case 50 :
                // InternalDataDescriptionLanguage.g:1:304: T__64
                {
                mT__64(); 

                }
                break;
            case 51 :
                // InternalDataDescriptionLanguage.g:1:310: T__65
                {
                mT__65(); 

                }
                break;
            case 52 :
                // InternalDataDescriptionLanguage.g:1:316: T__66
                {
                mT__66(); 

                }
                break;
            case 53 :
                // InternalDataDescriptionLanguage.g:1:322: T__67
                {
                mT__67(); 

                }
                break;
            case 54 :
                // InternalDataDescriptionLanguage.g:1:328: T__68
                {
                mT__68(); 

                }
                break;
            case 55 :
                // InternalDataDescriptionLanguage.g:1:334: T__69
                {
                mT__69(); 

                }
                break;
            case 56 :
                // InternalDataDescriptionLanguage.g:1:340: T__70
                {
                mT__70(); 

                }
                break;
            case 57 :
                // InternalDataDescriptionLanguage.g:1:346: T__71
                {
                mT__71(); 

                }
                break;
            case 58 :
                // InternalDataDescriptionLanguage.g:1:352: T__72
                {
                mT__72(); 

                }
                break;
            case 59 :
                // InternalDataDescriptionLanguage.g:1:358: T__73
                {
                mT__73(); 

                }
                break;
            case 60 :
                // InternalDataDescriptionLanguage.g:1:364: T__74
                {
                mT__74(); 

                }
                break;
            case 61 :
                // InternalDataDescriptionLanguage.g:1:370: T__75
                {
                mT__75(); 

                }
                break;
            case 62 :
                // InternalDataDescriptionLanguage.g:1:376: T__76
                {
                mT__76(); 

                }
                break;
            case 63 :
                // InternalDataDescriptionLanguage.g:1:382: T__77
                {
                mT__77(); 

                }
                break;
            case 64 :
                // InternalDataDescriptionLanguage.g:1:388: T__78
                {
                mT__78(); 

                }
                break;
            case 65 :
                // InternalDataDescriptionLanguage.g:1:394: T__79
                {
                mT__79(); 

                }
                break;
            case 66 :
                // InternalDataDescriptionLanguage.g:1:400: T__80
                {
                mT__80(); 

                }
                break;
            case 67 :
                // InternalDataDescriptionLanguage.g:1:406: T__81
                {
                mT__81(); 

                }
                break;
            case 68 :
                // InternalDataDescriptionLanguage.g:1:412: T__82
                {
                mT__82(); 

                }
                break;
            case 69 :
                // InternalDataDescriptionLanguage.g:1:418: T__83
                {
                mT__83(); 

                }
                break;
            case 70 :
                // InternalDataDescriptionLanguage.g:1:424: T__84
                {
                mT__84(); 

                }
                break;
            case 71 :
                // InternalDataDescriptionLanguage.g:1:430: T__85
                {
                mT__85(); 

                }
                break;
            case 72 :
                // InternalDataDescriptionLanguage.g:1:436: T__86
                {
                mT__86(); 

                }
                break;
            case 73 :
                // InternalDataDescriptionLanguage.g:1:442: T__87
                {
                mT__87(); 

                }
                break;
            case 74 :
                // InternalDataDescriptionLanguage.g:1:448: T__88
                {
                mT__88(); 

                }
                break;
            case 75 :
                // InternalDataDescriptionLanguage.g:1:454: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 76 :
                // InternalDataDescriptionLanguage.g:1:463: RULE_DOUBLE
                {
                mRULE_DOUBLE(); 

                }
                break;
            case 77 :
                // InternalDataDescriptionLanguage.g:1:475: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 78 :
                // InternalDataDescriptionLanguage.g:1:487: RULE_QUOTED_ID
                {
                mRULE_QUOTED_ID(); 

                }
                break;
            case 79 :
                // InternalDataDescriptionLanguage.g:1:502: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 80 :
                // InternalDataDescriptionLanguage.g:1:510: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 81 :
                // InternalDataDescriptionLanguage.g:1:526: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 82 :
                // InternalDataDescriptionLanguage.g:1:542: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 83 :
                // InternalDataDescriptionLanguage.g:1:550: RULE_ANY_OTHER
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
            return "7265:15: ( RULE_INT RULE_EXPONENT | RULE_INT '.' ( RULE_DIGIT )* ( RULE_EXPONENT )? )";
        }
    }
    static final String DFA17_eotS =
        "\1\uffff\1\76\1\101\1\77\1\106\5\77\1\116\1\uffff\1\121\1\123\1\uffff\1\126\1\uffff\1\132\1\uffff\1\134\1\135\1\136\1\137\1\140\1\141\1\142\1\143\1\144\1\147\1\151\1\uffff\1\153\1\155\1\156\1\157\2\uffff\1\77\1\165\1\uffff\5\77\1\175\5\uffff\2\77\1\uffff\1\u0086\2\73\3\uffff\2\77\2\uffff\1\77\1\uffff\1\77\1\u008f\2\77\1\uffff\6\77\10\uffff\1\u0086\17\uffff\1\u009a\1\77\1\uffff\1\77\3\uffff\1\77\5\uffff\2\77\3\uffff\3\77\1\u00a3\2\77\6\uffff\2\77\6\uffff\4\77\1\uffff\4\77\1\u00b1\5\77\1\uffff\10\77\1\uffff\1\u00bf\1\u00c0\11\77\1\u00ca\1\77\1\uffff\4\77\1\u00d0\3\77\1\u00d5\1\u00d6\1\u00d7\1\77\1\u00d9\2\uffff\2\77\1\u00dc\1\u00dd\5\77\1\uffff\5\77\1\uffff\2\77\1\u00ea\1\u00eb\3\uffff\1\u00ec\1\uffff\2\77\2\uffff\7\77\1\u00f6\1\77\1\u00f8\1\77\1\u00fa\3\uffff\2\77\1\u00fd\1\u00fe\3\77\1\u0102\1\77\1\uffff\1\u0104\1\uffff\1\77\1\uffff\1\u0106\1\77\2\uffff\1\u0108\1\77\1\u010a\1\uffff\1\u010b\1\uffff\1\77\1\uffff\1\77\1\uffff\1\77\2\uffff\4\77\1\u0113\1\u0114\1\u0115\3\uffff";
    static final String DFA17_eofS =
        "\u0116\uffff";
    static final String DFA17_minS =
        "\1\0\2\60\1\146\1\60\1\165\1\145\1\155\1\157\1\164\1\75\1\uffff\2\75\1\uffff\1\60\1\uffff\1\52\1\uffff\13\60\1\uffff\4\60\2\uffff\1\162\1\75\1\uffff\1\151\1\141\1\122\1\117\1\116\1\101\5\uffff\1\151\1\170\1\uffff\1\56\2\0\3\uffff\1\154\1\157\2\uffff\1\155\1\uffff\1\144\1\60\1\162\1\156\1\uffff\1\157\1\141\1\163\1\160\1\157\1\162\10\uffff\1\56\17\uffff\1\60\1\163\1\uffff\1\144\3\uffff\1\162\5\uffff\1\160\1\165\3\uffff\1\164\1\154\1\151\1\60\1\122\1\104\6\uffff\1\164\1\160\6\uffff\1\163\1\141\2\151\1\uffff\1\144\1\163\1\164\1\154\1\60\1\164\1\157\1\154\1\151\1\141\1\uffff\1\143\1\165\1\141\2\145\1\150\1\165\1\144\1\uffff\2\60\1\145\1\162\1\145\1\164\2\156\1\151\1\164\1\151\1\60\1\147\1\uffff\1\141\1\162\1\145\1\156\1\60\1\162\1\154\1\171\3\60\1\145\1\60\2\uffff\1\162\1\145\2\60\2\141\1\156\1\162\1\145\1\uffff\1\145\1\156\1\164\1\141\1\147\1\uffff\1\151\1\145\2\60\3\uffff\1\60\1\uffff\1\141\1\163\2\uffff\2\154\2\141\1\156\1\162\1\143\1\60\1\156\1\60\1\160\1\60\3\uffff\1\154\1\163\2\60\1\154\1\151\1\164\1\60\1\145\1\uffff\1\60\1\uffff\1\164\1\uffff\1\60\1\151\2\uffff\1\60\1\156\1\60\1\uffff\1\60\1\uffff\1\151\1\uffff\1\157\1\uffff\1\164\2\uffff\1\157\1\156\1\163\1\156\3\60\3\uffff";
    static final String DFA17_maxS =
        "\1\uffff\2\172\1\162\1\172\1\165\1\145\1\156\1\157\1\164\1\75\1\uffff\2\75\1\uffff\1\71\1\uffff\1\57\1\uffff\13\172\1\uffff\4\172\2\uffff\1\171\1\75\1\uffff\1\151\1\157\1\122\1\117\1\116\1\172\5\uffff\1\151\1\170\1\uffff\1\145\2\uffff\3\uffff\1\154\1\157\2\uffff\1\155\1\uffff\1\144\1\172\1\162\1\156\1\uffff\1\157\1\141\1\164\1\160\1\157\1\162\10\uffff\1\145\17\uffff\1\172\1\163\1\uffff\1\144\3\uffff\1\162\5\uffff\1\160\1\165\3\uffff\1\164\1\154\1\151\1\172\1\122\1\104\6\uffff\1\164\1\160\6\uffff\1\163\1\141\2\151\1\uffff\1\144\1\163\1\164\1\154\1\172\1\164\1\157\1\154\1\151\1\141\1\uffff\1\143\1\165\1\141\2\145\1\150\1\165\1\144\1\uffff\2\172\1\145\1\162\1\145\1\164\2\156\1\151\1\164\1\151\1\172\1\147\1\uffff\1\141\1\162\1\145\1\156\1\172\1\162\1\154\1\171\3\172\1\145\1\172\2\uffff\1\162\1\145\2\172\2\141\1\156\1\162\1\145\1\uffff\1\145\1\156\1\164\1\141\1\147\1\uffff\1\151\1\145\2\172\3\uffff\1\172\1\uffff\1\141\1\163\2\uffff\2\154\2\141\1\156\1\162\1\143\1\172\1\156\1\172\1\160\1\172\3\uffff\1\154\1\163\2\172\1\154\1\151\1\164\1\172\1\145\1\uffff\1\172\1\uffff\1\164\1\uffff\1\172\1\151\2\uffff\1\172\1\156\1\172\1\uffff\1\172\1\uffff\1\151\1\uffff\1\157\1\uffff\1\164\2\uffff\1\157\1\156\1\163\1\156\3\172\3\uffff";
    static final String DFA17_acceptS =
        "\13\uffff\1\14\2\uffff\1\20\1\uffff\1\22\1\uffff\1\24\13\uffff\1\42\4\uffff\1\52\1\53\2\uffff\1\61\6\uffff\1\73\1\74\1\75\1\76\1\77\2\uffff\1\110\3\uffff\1\117\1\122\1\123\2\uffff\1\45\1\117\1\uffff\1\43\4\uffff\1\40\6\uffff\1\12\1\13\1\14\1\15\1\111\1\17\1\16\1\20\1\uffff\1\21\1\22\1\120\1\121\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\2\uffff\1\37\1\uffff\1\41\1\42\1\44\1\uffff\1\46\1\47\1\50\1\52\1\53\2\uffff\1\100\1\55\1\61\6\uffff\1\72\1\73\1\74\1\75\1\76\1\77\2\uffff\1\110\1\113\1\114\1\115\1\116\1\122\4\uffff\1\65\12\uffff\1\36\10\uffff\1\67\15\uffff\1\104\15\uffff\1\70\1\71\11\uffff\1\6\5\uffff\1\56\4\uffff\1\62\1\112\1\64\1\uffff\1\106\2\uffff\1\1\1\105\14\uffff\1\107\1\54\1\66\11\uffff\1\60\1\uffff\1\11\1\uffff\1\51\2\uffff\1\2\1\3\3\uffff\1\7\1\uffff\1\10\1\uffff\1\101\1\uffff\1\4\1\uffff\1\5\1\102\7\uffff\1\103\1\57\1\63";
    static final String DFA17_specialS =
        "\1\2\66\uffff\1\1\1\0\u00dd\uffff}>";
    static final String[] DFA17_transitionS = {
            "\11\73\2\72\2\73\1\72\22\73\1\72\1\14\1\67\2\73\1\22\1\73\1\70\1\61\1\62\1\20\1\16\1\60\1\17\1\65\1\21\12\66\1\46\1\47\1\15\1\13\1\12\2\73\1\54\3\71\1\25\1\71\1\30\5\71\1\31\1\71\1\52\1\26\3\71\1\27\3\71\1\53\1\23\1\24\1\56\1\73\1\57\1\55\1\71\1\73\1\40\1\10\1\4\1\34\1\64\1\1\1\71\1\33\1\7\1\71\1\32\1\63\1\35\1\2\1\3\1\37\1\5\1\6\1\11\1\45\1\71\1\51\1\50\1\71\1\42\1\41\1\43\1\73\1\44\67\73\1\36\uff4a\73",
            "\12\77\7\uffff\32\77\4\uffff\1\77\1\uffff\1\74\12\77\1\75\16\77",
            "\12\77\7\uffff\32\77\4\uffff\1\77\1\uffff\16\77\1\100\13\77",
            "\1\103\13\uffff\1\102",
            "\12\77\7\uffff\32\77\4\uffff\1\77\1\uffff\1\104\15\77\1\105\13\77",
            "\1\107",
            "\1\110",
            "\1\112\1\111",
            "\1\113",
            "\1\114",
            "\1\115",
            "",
            "\1\120",
            "\1\122",
            "",
            "\12\125",
            "",
            "\1\130\4\uffff\1\131",
            "",
            "\12\77\7\uffff\32\77\4\uffff\1\77\1\uffff\32\77",
            "\12\77\7\uffff\32\77\4\uffff\1\77\1\uffff\32\77",
            "\12\77\7\uffff\32\77\4\uffff\1\77\1\uffff\32\77",
            "\12\77\7\uffff\32\77\4\uffff\1\77\1\uffff\32\77",
            "\12\77\7\uffff\32\77\4\uffff\1\77\1\uffff\32\77",
            "\12\77\7\uffff\32\77\4\uffff\1\77\1\uffff\32\77",
            "\12\77\7\uffff\32\77\4\uffff\1\77\1\uffff\32\77",
            "\12\77\7\uffff\32\77\4\uffff\1\77\1\uffff\32\77",
            "\12\77\7\uffff\32\77\4\uffff\1\77\1\uffff\32\77",
            "\12\77\7\uffff\32\77\4\uffff\1\77\1\uffff\1\145\3\77\1\146\25\77",
            "\12\77\7\uffff\32\77\4\uffff\1\77\1\uffff\16\77\1\150\13\77",
            "",
            "\12\77\7\uffff\32\77\4\uffff\1\77\1\uffff\32\77",
            "\12\77\7\uffff\32\77\4\uffff\1\77\1\uffff\21\77\1\154\10\77",
            "\12\77\7\uffff\32\77\4\uffff\1\77\1\uffff\32\77",
            "\12\77\7\uffff\32\77\4\uffff\1\77\1\uffff\32\77",
            "",
            "",
            "\1\163\6\uffff\1\162",
            "\1\164",
            "",
            "\1\167",
            "\1\170\15\uffff\1\171",
            "\1\172",
            "\1\173",
            "\1\174",
            "\32\77\4\uffff\1\77\1\uffff\32\77",
            "",
            "",
            "",
            "",
            "",
            "\1\u0083",
            "\1\u0084",
            "",
            "\1\u0087\1\uffff\12\125\53\uffff\1\u0087",
            "\0\u0088",
            "\0\u0089",
            "",
            "",
            "",
            "\1\u008b",
            "\1\u008c",
            "",
            "",
            "\1\u008d",
            "",
            "\1\u008e",
            "\12\77\7\uffff\32\77\4\uffff\1\77\1\uffff\32\77",
            "\1\u0090",
            "\1\u0091",
            "",
            "\1\u0092",
            "\1\u0093",
            "\1\u0095\1\u0094",
            "\1\u0096",
            "\1\u0097",
            "\1\u0098",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u0087\1\uffff\12\125\53\uffff\1\u0087",
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
            "",
            "\12\77\7\uffff\32\77\4\uffff\1\77\1\uffff\23\77\1\u0099\6\77",
            "\1\u009b",
            "",
            "\1\u009c",
            "",
            "",
            "",
            "\1\u009d",
            "",
            "",
            "",
            "",
            "",
            "\1\u009e",
            "\1\u009f",
            "",
            "",
            "",
            "\1\u00a0",
            "\1\u00a1",
            "\1\u00a2",
            "\12\77\7\uffff\32\77\4\uffff\1\77\1\uffff\32\77",
            "\1\u00a4",
            "\1\u00a5",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u00a6",
            "\1\u00a7",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u00a8",
            "\1\u00a9",
            "\1\u00aa",
            "\1\u00ab",
            "",
            "\1\u00ac",
            "\1\u00ad",
            "\1\u00ae",
            "\1\u00af",
            "\12\77\7\uffff\32\77\4\uffff\1\77\1\uffff\4\77\1\u00b0\25\77",
            "\1\u00b2",
            "\1\u00b3",
            "\1\u00b4",
            "\1\u00b5",
            "\1\u00b6",
            "",
            "\1\u00b7",
            "\1\u00b8",
            "\1\u00b9",
            "\1\u00ba",
            "\1\u00bb",
            "\1\u00bc",
            "\1\u00bd",
            "\1\u00be",
            "",
            "\12\77\7\uffff\32\77\4\uffff\1\77\1\uffff\32\77",
            "\12\77\7\uffff\32\77\4\uffff\1\77\1\uffff\32\77",
            "\1\u00c1",
            "\1\u00c2",
            "\1\u00c3",
            "\1\u00c4",
            "\1\u00c5",
            "\1\u00c6",
            "\1\u00c7",
            "\1\u00c8",
            "\1\u00c9",
            "\12\77\7\uffff\32\77\4\uffff\1\77\1\uffff\32\77",
            "\1\u00cb",
            "",
            "\1\u00cc",
            "\1\u00cd",
            "\1\u00ce",
            "\1\u00cf",
            "\12\77\7\uffff\32\77\4\uffff\1\77\1\uffff\32\77",
            "\1\u00d1",
            "\1\u00d2",
            "\1\u00d3",
            "\12\77\7\uffff\32\77\4\uffff\1\77\1\uffff\22\77\1\u00d4\7\77",
            "\12\77\7\uffff\32\77\4\uffff\1\77\1\uffff\32\77",
            "\12\77\7\uffff\32\77\4\uffff\1\77\1\uffff\32\77",
            "\1\u00d8",
            "\12\77\7\uffff\32\77\4\uffff\1\77\1\uffff\32\77",
            "",
            "",
            "\1\u00da",
            "\1\u00db",
            "\12\77\7\uffff\32\77\4\uffff\1\77\1\uffff\32\77",
            "\12\77\7\uffff\32\77\4\uffff\1\77\1\uffff\32\77",
            "\1\u00de",
            "\1\u00df",
            "\1\u00e0",
            "\1\u00e1",
            "\1\u00e2",
            "",
            "\1\u00e3",
            "\1\u00e4",
            "\1\u00e5",
            "\1\u00e6",
            "\1\u00e7",
            "",
            "\1\u00e8",
            "\1\u00e9",
            "\12\77\7\uffff\32\77\4\uffff\1\77\1\uffff\32\77",
            "\12\77\7\uffff\32\77\4\uffff\1\77\1\uffff\32\77",
            "",
            "",
            "",
            "\12\77\7\uffff\32\77\4\uffff\1\77\1\uffff\32\77",
            "",
            "\1\u00ed",
            "\1\u00ee",
            "",
            "",
            "\1\u00ef",
            "\1\u00f0",
            "\1\u00f1",
            "\1\u00f2",
            "\1\u00f3",
            "\1\u00f4",
            "\1\u00f5",
            "\12\77\7\uffff\32\77\4\uffff\1\77\1\uffff\32\77",
            "\1\u00f7",
            "\12\77\7\uffff\32\77\4\uffff\1\77\1\uffff\32\77",
            "\1\u00f9",
            "\12\77\7\uffff\32\77\4\uffff\1\77\1\uffff\32\77",
            "",
            "",
            "",
            "\1\u00fb",
            "\1\u00fc",
            "\12\77\7\uffff\32\77\4\uffff\1\77\1\uffff\32\77",
            "\12\77\7\uffff\32\77\4\uffff\1\77\1\uffff\32\77",
            "\1\u00ff",
            "\1\u0100",
            "\1\u0101",
            "\12\77\7\uffff\32\77\4\uffff\1\77\1\uffff\32\77",
            "\1\u0103",
            "",
            "\12\77\7\uffff\32\77\4\uffff\1\77\1\uffff\32\77",
            "",
            "\1\u0105",
            "",
            "\12\77\7\uffff\32\77\4\uffff\1\77\1\uffff\32\77",
            "\1\u0107",
            "",
            "",
            "\12\77\7\uffff\32\77\4\uffff\1\77\1\uffff\32\77",
            "\1\u0109",
            "\12\77\7\uffff\32\77\4\uffff\1\77\1\uffff\32\77",
            "",
            "\12\77\7\uffff\32\77\4\uffff\1\77\1\uffff\32\77",
            "",
            "\1\u010c",
            "",
            "\1\u010d",
            "",
            "\1\u010e",
            "",
            "",
            "\1\u010f",
            "\1\u0110",
            "\1\u0111",
            "\1\u0112",
            "\12\77\7\uffff\32\77\4\uffff\1\77\1\uffff\32\77",
            "\12\77\7\uffff\32\77\4\uffff\1\77\1\uffff\32\77",
            "\12\77\7\uffff\32\77\4\uffff\1\77\1\uffff\32\77",
            "",
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
            return "1:1: Tokens : ( T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | RULE_INT | RULE_DOUBLE | RULE_STRING | RULE_QUOTED_ID | RULE_ID | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA17_56 = input.LA(1);

                        s = -1;
                        if ( ((LA17_56>='\u0000' && LA17_56<='\uFFFF')) ) {s = 137;}

                        else s = 59;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA17_55 = input.LA(1);

                        s = -1;
                        if ( ((LA17_55>='\u0000' && LA17_55<='\uFFFF')) ) {s = 136;}

                        else s = 59;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA17_0 = input.LA(1);

                        s = -1;
                        if ( (LA17_0=='f') ) {s = 1;}

                        else if ( (LA17_0=='n') ) {s = 2;}

                        else if ( (LA17_0=='o') ) {s = 3;}

                        else if ( (LA17_0=='c') ) {s = 4;}

                        else if ( (LA17_0=='q') ) {s = 5;}

                        else if ( (LA17_0=='r') ) {s = 6;}

                        else if ( (LA17_0=='i') ) {s = 7;}

                        else if ( (LA17_0=='b') ) {s = 8;}

                        else if ( (LA17_0=='s') ) {s = 9;}

                        else if ( (LA17_0=='>') ) {s = 10;}

                        else if ( (LA17_0=='=') ) {s = 11;}

                        else if ( (LA17_0=='!') ) {s = 12;}

                        else if ( (LA17_0=='<') ) {s = 13;}

                        else if ( (LA17_0=='+') ) {s = 14;}

                        else if ( (LA17_0=='-') ) {s = 15;}

                        else if ( (LA17_0=='*') ) {s = 16;}

                        else if ( (LA17_0=='/') ) {s = 17;}

                        else if ( (LA17_0=='%') ) {s = 18;}

                        else if ( (LA17_0=='Y') ) {s = 19;}

                        else if ( (LA17_0=='Z') ) {s = 20;}

                        else if ( (LA17_0=='E') ) {s = 21;}

                        else if ( (LA17_0=='P') ) {s = 22;}

                        else if ( (LA17_0=='T') ) {s = 23;}

                        else if ( (LA17_0=='G') ) {s = 24;}

                        else if ( (LA17_0=='M') ) {s = 25;}

                        else if ( (LA17_0=='k') ) {s = 26;}

                        else if ( (LA17_0=='h') ) {s = 27;}

                        else if ( (LA17_0=='d') ) {s = 28;}

                        else if ( (LA17_0=='m') ) {s = 29;}

                        else if ( (LA17_0=='\u00B5') ) {s = 30;}

                        else if ( (LA17_0=='p') ) {s = 31;}

                        else if ( (LA17_0=='a') ) {s = 32;}

                        else if ( (LA17_0=='z') ) {s = 33;}

                        else if ( (LA17_0=='y') ) {s = 34;}

                        else if ( (LA17_0=='{') ) {s = 35;}

                        else if ( (LA17_0=='}') ) {s = 36;}

                        else if ( (LA17_0=='t') ) {s = 37;}

                        else if ( (LA17_0==':') ) {s = 38;}

                        else if ( (LA17_0==';') ) {s = 39;}

                        else if ( (LA17_0=='w') ) {s = 40;}

                        else if ( (LA17_0=='v') ) {s = 41;}

                        else if ( (LA17_0=='O') ) {s = 42;}

                        else if ( (LA17_0=='X') ) {s = 43;}

                        else if ( (LA17_0=='A') ) {s = 44;}

                        else if ( (LA17_0=='^') ) {s = 45;}

                        else if ( (LA17_0=='[') ) {s = 46;}

                        else if ( (LA17_0==']') ) {s = 47;}

                        else if ( (LA17_0==',') ) {s = 48;}

                        else if ( (LA17_0=='(') ) {s = 49;}

                        else if ( (LA17_0==')') ) {s = 50;}

                        else if ( (LA17_0=='l') ) {s = 51;}

                        else if ( (LA17_0=='e') ) {s = 52;}

                        else if ( (LA17_0=='.') ) {s = 53;}

                        else if ( ((LA17_0>='0' && LA17_0<='9')) ) {s = 54;}

                        else if ( (LA17_0=='\"') ) {s = 55;}

                        else if ( (LA17_0=='\'') ) {s = 56;}

                        else if ( ((LA17_0>='B' && LA17_0<='D')||LA17_0=='F'||(LA17_0>='H' && LA17_0<='L')||LA17_0=='N'||(LA17_0>='Q' && LA17_0<='S')||(LA17_0>='U' && LA17_0<='W')||LA17_0=='_'||LA17_0=='g'||LA17_0=='j'||LA17_0=='u'||LA17_0=='x') ) {s = 57;}

                        else if ( ((LA17_0>='\t' && LA17_0<='\n')||LA17_0=='\r'||LA17_0==' ') ) {s = 58;}

                        else if ( ((LA17_0>='\u0000' && LA17_0<='\b')||(LA17_0>='\u000B' && LA17_0<='\f')||(LA17_0>='\u000E' && LA17_0<='\u001F')||(LA17_0>='#' && LA17_0<='$')||LA17_0=='&'||(LA17_0>='?' && LA17_0<='@')||LA17_0=='\\'||LA17_0=='`'||LA17_0=='|'||(LA17_0>='~' && LA17_0<='\u00B4')||(LA17_0>='\u00B6' && LA17_0<='\uFFFF')) ) {s = 59;}

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
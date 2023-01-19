package de.evoal.languages.model.dl.dsl.ide.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalDefinitionLanguageLexer extends Lexer {
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
    public static final int RULE_INT=7;
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
    public static final int RULE_STRING=8;
    public static final int RULE_SL_COMMENT=12;
    public static final int T__37=37;
    public static final int RULE_DOUBLE=6;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__74=74;
    public static final int T__31=31;
    public static final int T__75=75;
    public static final int T__32=32;
    public static final int T__76=76;
    public static final int RULE_WS=13;
    public static final int RULE_ANY_OTHER=14;
    public static final int RULE_EXPONENT=10;
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

    public InternalDefinitionLanguageLexer() {;} 
    public InternalDefinitionLanguageLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalDefinitionLanguageLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalDefinitionLanguage.g"; }

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDefinitionLanguage.g:11:7: ( 'false' )
            // InternalDefinitionLanguage.g:11:9: 'false'
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
            // InternalDefinitionLanguage.g:12:7: ( '>=' )
            // InternalDefinitionLanguage.g:12:9: '>='
            {
            match(">="); 


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
            // InternalDefinitionLanguage.g:13:7: ( '>' )
            // InternalDefinitionLanguage.g:13:9: '>'
            {
            match('>'); 

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
            // InternalDefinitionLanguage.g:14:7: ( '=' )
            // InternalDefinitionLanguage.g:14:9: '='
            {
            match('='); 

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
            // InternalDefinitionLanguage.g:15:7: ( '!=' )
            // InternalDefinitionLanguage.g:15:9: '!='
            {
            match("!="); 


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
            // InternalDefinitionLanguage.g:16:7: ( '<' )
            // InternalDefinitionLanguage.g:16:9: '<'
            {
            match('<'); 

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
            // InternalDefinitionLanguage.g:17:7: ( '<=' )
            // InternalDefinitionLanguage.g:17:9: '<='
            {
            match("<="); 


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
            // InternalDefinitionLanguage.g:18:7: ( '+' )
            // InternalDefinitionLanguage.g:18:9: '+'
            {
            match('+'); 

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
            // InternalDefinitionLanguage.g:19:7: ( '-' )
            // InternalDefinitionLanguage.g:19:9: '-'
            {
            match('-'); 

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
            // InternalDefinitionLanguage.g:20:7: ( '*' )
            // InternalDefinitionLanguage.g:20:9: '*'
            {
            match('*'); 

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
            // InternalDefinitionLanguage.g:21:7: ( '/' )
            // InternalDefinitionLanguage.g:21:9: '/'
            {
            match('/'); 

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
            // InternalDefinitionLanguage.g:22:7: ( '%' )
            // InternalDefinitionLanguage.g:22:9: '%'
            {
            match('%'); 

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
            // InternalDefinitionLanguage.g:23:7: ( 'Y' )
            // InternalDefinitionLanguage.g:23:9: 'Y'
            {
            match('Y'); 

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
            // InternalDefinitionLanguage.g:24:7: ( 'Z' )
            // InternalDefinitionLanguage.g:24:9: 'Z'
            {
            match('Z'); 

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
            // InternalDefinitionLanguage.g:25:7: ( 'E' )
            // InternalDefinitionLanguage.g:25:9: 'E'
            {
            match('E'); 

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
            // InternalDefinitionLanguage.g:26:7: ( 'P' )
            // InternalDefinitionLanguage.g:26:9: 'P'
            {
            match('P'); 

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
            // InternalDefinitionLanguage.g:27:7: ( 'T' )
            // InternalDefinitionLanguage.g:27:9: 'T'
            {
            match('T'); 

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
            // InternalDefinitionLanguage.g:28:7: ( 'G' )
            // InternalDefinitionLanguage.g:28:9: 'G'
            {
            match('G'); 

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
            // InternalDefinitionLanguage.g:29:7: ( 'M' )
            // InternalDefinitionLanguage.g:29:9: 'M'
            {
            match('M'); 

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
            // InternalDefinitionLanguage.g:30:7: ( 'k' )
            // InternalDefinitionLanguage.g:30:9: 'k'
            {
            match('k'); 

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
            // InternalDefinitionLanguage.g:31:7: ( 'h' )
            // InternalDefinitionLanguage.g:31:9: 'h'
            {
            match('h'); 

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
            // InternalDefinitionLanguage.g:32:7: ( 'da' )
            // InternalDefinitionLanguage.g:32:9: 'da'
            {
            match("da"); 


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
            // InternalDefinitionLanguage.g:33:7: ( 'd' )
            // InternalDefinitionLanguage.g:33:9: 'd'
            {
            match('d'); 

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
            // InternalDefinitionLanguage.g:34:7: ( 'c' )
            // InternalDefinitionLanguage.g:34:9: 'c'
            {
            match('c'); 

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
            // InternalDefinitionLanguage.g:35:7: ( 'm' )
            // InternalDefinitionLanguage.g:35:9: 'm'
            {
            match('m'); 

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
            // InternalDefinitionLanguage.g:36:7: ( '\\u00B5' )
            // InternalDefinitionLanguage.g:36:9: '\\u00B5'
            {
            match('\u00B5'); 

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
            // InternalDefinitionLanguage.g:37:7: ( 'n' )
            // InternalDefinitionLanguage.g:37:9: 'n'
            {
            match('n'); 

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
            // InternalDefinitionLanguage.g:38:7: ( 'p' )
            // InternalDefinitionLanguage.g:38:9: 'p'
            {
            match('p'); 

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
            // InternalDefinitionLanguage.g:39:7: ( 'f' )
            // InternalDefinitionLanguage.g:39:9: 'f'
            {
            match('f'); 

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
            // InternalDefinitionLanguage.g:40:7: ( 'a' )
            // InternalDefinitionLanguage.g:40:9: 'a'
            {
            match('a'); 

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
            // InternalDefinitionLanguage.g:41:7: ( 'z' )
            // InternalDefinitionLanguage.g:41:9: 'z'
            {
            match('z'); 

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
            // InternalDefinitionLanguage.g:42:7: ( 'y' )
            // InternalDefinitionLanguage.g:42:9: 'y'
            {
            match('y'); 

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
            // InternalDefinitionLanguage.g:43:7: ( 'type' )
            // InternalDefinitionLanguage.g:43:9: 'type'
            {
            match("type"); 


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
            // InternalDefinitionLanguage.g:44:7: ( '{' )
            // InternalDefinitionLanguage.g:44:9: '{'
            {
            match('{'); 

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
            // InternalDefinitionLanguage.g:45:7: ( '}' )
            // InternalDefinitionLanguage.g:45:9: '}'
            {
            match('}'); 

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
            // InternalDefinitionLanguage.g:46:7: ( 'extends' )
            // InternalDefinitionLanguage.g:46:9: 'extends'
            {
            match("extends"); 


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
            // InternalDefinitionLanguage.g:47:7: ( 'unnamed' )
            // InternalDefinitionLanguage.g:47:9: 'unnamed'
            {
            match("unnamed"); 


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
            // InternalDefinitionLanguage.g:48:7: ( ':' )
            // InternalDefinitionLanguage.g:48:9: ':'
            {
            match(':'); 

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
            // InternalDefinitionLanguage.g:49:7: ( ';' )
            // InternalDefinitionLanguage.g:49:9: ';'
            {
            match(';'); 

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
            // InternalDefinitionLanguage.g:50:7: ( 'literal' )
            // InternalDefinitionLanguage.g:50:9: 'literal'
            {
            match("literal"); 


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
            // InternalDefinitionLanguage.g:51:7: ( 'instance' )
            // InternalDefinitionLanguage.g:51:9: 'instance'
            {
            match("instance"); 


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
            // InternalDefinitionLanguage.g:52:7: ( '|' )
            // InternalDefinitionLanguage.g:52:9: '|'
            {
            match('|'); 

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
            // InternalDefinitionLanguage.g:53:7: ( 'string' )
            // InternalDefinitionLanguage.g:53:9: 'string'
            {
            match("string"); 


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
            // InternalDefinitionLanguage.g:54:7: ( 'expression' )
            // InternalDefinitionLanguage.g:54:9: 'expression'
            {
            match("expression"); 


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
            // InternalDefinitionLanguage.g:55:7: ( 'int' )
            // InternalDefinitionLanguage.g:55:9: 'int'
            {
            match("int"); 


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
            // InternalDefinitionLanguage.g:56:7: ( 'float' )
            // InternalDefinitionLanguage.g:56:9: 'float'
            {
            match("float"); 


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
            // InternalDefinitionLanguage.g:57:7: ( 'boolean' )
            // InternalDefinitionLanguage.g:57:9: 'boolean'
            {
            match("boolean"); 


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
            // InternalDefinitionLanguage.g:58:7: ( 'void' )
            // InternalDefinitionLanguage.g:58:9: 'void'
            {
            match("void"); 


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
            // InternalDefinitionLanguage.g:59:7: ( 'data' )
            // InternalDefinitionLanguage.g:59:9: 'data'
            {
            match("data"); 


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
            // InternalDefinitionLanguage.g:60:7: ( 'array' )
            // InternalDefinitionLanguage.g:60:9: 'array'
            {
            match("array"); 


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
            // InternalDefinitionLanguage.g:61:7: ( 'def' )
            // InternalDefinitionLanguage.g:61:9: 'def'
            {
            match("def"); 


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
            // InternalDefinitionLanguage.g:62:7: ( '(' )
            // InternalDefinitionLanguage.g:62:9: '('
            {
            match('('); 

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
            // InternalDefinitionLanguage.g:63:7: ( ')' )
            // InternalDefinitionLanguage.g:63:9: ')'
            {
            match(')'); 

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
            // InternalDefinitionLanguage.g:64:7: ( ',' )
            // InternalDefinitionLanguage.g:64:9: ','
            {
            match(','); 

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
            // InternalDefinitionLanguage.g:65:7: ( 'OR' )
            // InternalDefinitionLanguage.g:65:9: 'OR'
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
            // InternalDefinitionLanguage.g:66:7: ( 'XOR' )
            // InternalDefinitionLanguage.g:66:9: 'XOR'
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
            // InternalDefinitionLanguage.g:67:7: ( 'AND' )
            // InternalDefinitionLanguage.g:67:9: 'AND'
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
            // InternalDefinitionLanguage.g:68:7: ( '^' )
            // InternalDefinitionLanguage.g:68:9: '^'
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
            // InternalDefinitionLanguage.g:69:7: ( 'value' )
            // InternalDefinitionLanguage.g:69:9: 'value'
            {
            match("value"); 


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
            // InternalDefinitionLanguage.g:70:7: ( 'abstract' )
            // InternalDefinitionLanguage.g:70:9: 'abstract'
            {
            match("abstract"); 


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
            // InternalDefinitionLanguage.g:71:7: ( '!' )
            // InternalDefinitionLanguage.g:71:9: '!'
            {
            match('!'); 

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
            // InternalDefinitionLanguage.g:72:7: ( 'true' )
            // InternalDefinitionLanguage.g:72:9: 'true'
            {
            match("true"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__76"

    // $ANTLR start "RULE_DIGIT"
    public final void mRULE_DIGIT() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:5226:21: ( '0' .. '9' )
            // InternalDefinitionLanguage.g:5226:23: '0' .. '9'
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
            // InternalDefinitionLanguage.g:5228:24: ( 'e' ( '+' | '-' )? ( RULE_DIGIT )+ )
            // InternalDefinitionLanguage.g:5228:26: 'e' ( '+' | '-' )? ( RULE_DIGIT )+
            {
            match('e'); 
            // InternalDefinitionLanguage.g:5228:30: ( '+' | '-' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='+'||LA1_0=='-') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalDefinitionLanguage.g:
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

            // InternalDefinitionLanguage.g:5228:41: ( RULE_DIGIT )+
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
            	    // InternalDefinitionLanguage.g:5228:41: RULE_DIGIT
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
            // InternalDefinitionLanguage.g:5230:10: ( ( '-' )? ( RULE_DIGIT )+ )
            // InternalDefinitionLanguage.g:5230:12: ( '-' )? ( RULE_DIGIT )+
            {
            // InternalDefinitionLanguage.g:5230:12: ( '-' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='-') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalDefinitionLanguage.g:5230:12: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // InternalDefinitionLanguage.g:5230:17: ( RULE_DIGIT )+
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
            	    // InternalDefinitionLanguage.g:5230:17: RULE_DIGIT
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
            // InternalDefinitionLanguage.g:5232:13: ( ( RULE_INT RULE_EXPONENT | RULE_INT '.' ( RULE_DIGIT )* ( RULE_EXPONENT )? ) )
            // InternalDefinitionLanguage.g:5232:15: ( RULE_INT RULE_EXPONENT | RULE_INT '.' ( RULE_DIGIT )* ( RULE_EXPONENT )? )
            {
            // InternalDefinitionLanguage.g:5232:15: ( RULE_INT RULE_EXPONENT | RULE_INT '.' ( RULE_DIGIT )* ( RULE_EXPONENT )? )
            int alt7=2;
            alt7 = dfa7.predict(input);
            switch (alt7) {
                case 1 :
                    // InternalDefinitionLanguage.g:5232:16: RULE_INT RULE_EXPONENT
                    {
                    mRULE_INT(); 
                    mRULE_EXPONENT(); 

                    }
                    break;
                case 2 :
                    // InternalDefinitionLanguage.g:5232:39: RULE_INT '.' ( RULE_DIGIT )* ( RULE_EXPONENT )?
                    {
                    mRULE_INT(); 
                    match('.'); 
                    // InternalDefinitionLanguage.g:5232:52: ( RULE_DIGIT )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // InternalDefinitionLanguage.g:5232:52: RULE_DIGIT
                    	    {
                    	    mRULE_DIGIT(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    // InternalDefinitionLanguage.g:5232:64: ( RULE_EXPONENT )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0=='e') ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // InternalDefinitionLanguage.g:5232:64: RULE_EXPONENT
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
            // InternalDefinitionLanguage.g:5234:13: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' )
            // InternalDefinitionLanguage.g:5234:15: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
            {
            match('\"'); 
            // InternalDefinitionLanguage.g:5234:19: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
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
            	    // InternalDefinitionLanguage.g:5234:20: '\\\\' .
            	    {
            	    match('\\'); 
            	    matchAny(); 

            	    }
            	    break;
            	case 2 :
            	    // InternalDefinitionLanguage.g:5234:27: ~ ( ( '\\\\' | '\"' ) )
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
            // InternalDefinitionLanguage.g:5236:16: ( '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            // InternalDefinitionLanguage.g:5236:18: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
            {
            match('\''); 
            // InternalDefinitionLanguage.g:5236:23: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
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
            	    // InternalDefinitionLanguage.g:5236:24: '\\\\' .
            	    {
            	    match('\\'); 
            	    matchAny(); 

            	    }
            	    break;
            	case 2 :
            	    // InternalDefinitionLanguage.g:5236:31: ~ ( ( '\\\\' | '\\'' ) )
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
            // InternalDefinitionLanguage.g:5238:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalDefinitionLanguage.g:5238:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalDefinitionLanguage.g:5238:11: ( '^' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='^') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalDefinitionLanguage.g:5238:11: '^'
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

            // InternalDefinitionLanguage.g:5238:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='0' && LA11_0<='9')||(LA11_0>='A' && LA11_0<='Z')||LA11_0=='_'||(LA11_0>='a' && LA11_0<='z')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:
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
            // InternalDefinitionLanguage.g:5240:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalDefinitionLanguage.g:5240:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalDefinitionLanguage.g:5240:24: ( options {greedy=false; } : . )*
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
            	    // InternalDefinitionLanguage.g:5240:52: .
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
            // InternalDefinitionLanguage.g:5242:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalDefinitionLanguage.g:5242:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalDefinitionLanguage.g:5242:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>='\u0000' && LA13_0<='\t')||(LA13_0>='\u000B' && LA13_0<='\f')||(LA13_0>='\u000E' && LA13_0<='\uFFFF')) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:5242:24: ~ ( ( '\\n' | '\\r' ) )
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

            // InternalDefinitionLanguage.g:5242:40: ( ( '\\r' )? '\\n' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0=='\n'||LA15_0=='\r') ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalDefinitionLanguage.g:5242:41: ( '\\r' )? '\\n'
                    {
                    // InternalDefinitionLanguage.g:5242:41: ( '\\r' )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0=='\r') ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // InternalDefinitionLanguage.g:5242:41: '\\r'
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
            // InternalDefinitionLanguage.g:5244:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalDefinitionLanguage.g:5244:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalDefinitionLanguage.g:5244:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            	    // InternalDefinitionLanguage.g:
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
            // InternalDefinitionLanguage.g:5246:16: ( . )
            // InternalDefinitionLanguage.g:5246:18: .
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
        // InternalDefinitionLanguage.g:1:8: ( T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | RULE_INT | RULE_DOUBLE | RULE_STRING | RULE_QUOTED_ID | RULE_ID | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt17=71;
        alt17 = dfa17.predict(input);
        switch (alt17) {
            case 1 :
                // InternalDefinitionLanguage.g:1:10: T__15
                {
                mT__15(); 

                }
                break;
            case 2 :
                // InternalDefinitionLanguage.g:1:16: T__16
                {
                mT__16(); 

                }
                break;
            case 3 :
                // InternalDefinitionLanguage.g:1:22: T__17
                {
                mT__17(); 

                }
                break;
            case 4 :
                // InternalDefinitionLanguage.g:1:28: T__18
                {
                mT__18(); 

                }
                break;
            case 5 :
                // InternalDefinitionLanguage.g:1:34: T__19
                {
                mT__19(); 

                }
                break;
            case 6 :
                // InternalDefinitionLanguage.g:1:40: T__20
                {
                mT__20(); 

                }
                break;
            case 7 :
                // InternalDefinitionLanguage.g:1:46: T__21
                {
                mT__21(); 

                }
                break;
            case 8 :
                // InternalDefinitionLanguage.g:1:52: T__22
                {
                mT__22(); 

                }
                break;
            case 9 :
                // InternalDefinitionLanguage.g:1:58: T__23
                {
                mT__23(); 

                }
                break;
            case 10 :
                // InternalDefinitionLanguage.g:1:64: T__24
                {
                mT__24(); 

                }
                break;
            case 11 :
                // InternalDefinitionLanguage.g:1:70: T__25
                {
                mT__25(); 

                }
                break;
            case 12 :
                // InternalDefinitionLanguage.g:1:76: T__26
                {
                mT__26(); 

                }
                break;
            case 13 :
                // InternalDefinitionLanguage.g:1:82: T__27
                {
                mT__27(); 

                }
                break;
            case 14 :
                // InternalDefinitionLanguage.g:1:88: T__28
                {
                mT__28(); 

                }
                break;
            case 15 :
                // InternalDefinitionLanguage.g:1:94: T__29
                {
                mT__29(); 

                }
                break;
            case 16 :
                // InternalDefinitionLanguage.g:1:100: T__30
                {
                mT__30(); 

                }
                break;
            case 17 :
                // InternalDefinitionLanguage.g:1:106: T__31
                {
                mT__31(); 

                }
                break;
            case 18 :
                // InternalDefinitionLanguage.g:1:112: T__32
                {
                mT__32(); 

                }
                break;
            case 19 :
                // InternalDefinitionLanguage.g:1:118: T__33
                {
                mT__33(); 

                }
                break;
            case 20 :
                // InternalDefinitionLanguage.g:1:124: T__34
                {
                mT__34(); 

                }
                break;
            case 21 :
                // InternalDefinitionLanguage.g:1:130: T__35
                {
                mT__35(); 

                }
                break;
            case 22 :
                // InternalDefinitionLanguage.g:1:136: T__36
                {
                mT__36(); 

                }
                break;
            case 23 :
                // InternalDefinitionLanguage.g:1:142: T__37
                {
                mT__37(); 

                }
                break;
            case 24 :
                // InternalDefinitionLanguage.g:1:148: T__38
                {
                mT__38(); 

                }
                break;
            case 25 :
                // InternalDefinitionLanguage.g:1:154: T__39
                {
                mT__39(); 

                }
                break;
            case 26 :
                // InternalDefinitionLanguage.g:1:160: T__40
                {
                mT__40(); 

                }
                break;
            case 27 :
                // InternalDefinitionLanguage.g:1:166: T__41
                {
                mT__41(); 

                }
                break;
            case 28 :
                // InternalDefinitionLanguage.g:1:172: T__42
                {
                mT__42(); 

                }
                break;
            case 29 :
                // InternalDefinitionLanguage.g:1:178: T__43
                {
                mT__43(); 

                }
                break;
            case 30 :
                // InternalDefinitionLanguage.g:1:184: T__44
                {
                mT__44(); 

                }
                break;
            case 31 :
                // InternalDefinitionLanguage.g:1:190: T__45
                {
                mT__45(); 

                }
                break;
            case 32 :
                // InternalDefinitionLanguage.g:1:196: T__46
                {
                mT__46(); 

                }
                break;
            case 33 :
                // InternalDefinitionLanguage.g:1:202: T__47
                {
                mT__47(); 

                }
                break;
            case 34 :
                // InternalDefinitionLanguage.g:1:208: T__48
                {
                mT__48(); 

                }
                break;
            case 35 :
                // InternalDefinitionLanguage.g:1:214: T__49
                {
                mT__49(); 

                }
                break;
            case 36 :
                // InternalDefinitionLanguage.g:1:220: T__50
                {
                mT__50(); 

                }
                break;
            case 37 :
                // InternalDefinitionLanguage.g:1:226: T__51
                {
                mT__51(); 

                }
                break;
            case 38 :
                // InternalDefinitionLanguage.g:1:232: T__52
                {
                mT__52(); 

                }
                break;
            case 39 :
                // InternalDefinitionLanguage.g:1:238: T__53
                {
                mT__53(); 

                }
                break;
            case 40 :
                // InternalDefinitionLanguage.g:1:244: T__54
                {
                mT__54(); 

                }
                break;
            case 41 :
                // InternalDefinitionLanguage.g:1:250: T__55
                {
                mT__55(); 

                }
                break;
            case 42 :
                // InternalDefinitionLanguage.g:1:256: T__56
                {
                mT__56(); 

                }
                break;
            case 43 :
                // InternalDefinitionLanguage.g:1:262: T__57
                {
                mT__57(); 

                }
                break;
            case 44 :
                // InternalDefinitionLanguage.g:1:268: T__58
                {
                mT__58(); 

                }
                break;
            case 45 :
                // InternalDefinitionLanguage.g:1:274: T__59
                {
                mT__59(); 

                }
                break;
            case 46 :
                // InternalDefinitionLanguage.g:1:280: T__60
                {
                mT__60(); 

                }
                break;
            case 47 :
                // InternalDefinitionLanguage.g:1:286: T__61
                {
                mT__61(); 

                }
                break;
            case 48 :
                // InternalDefinitionLanguage.g:1:292: T__62
                {
                mT__62(); 

                }
                break;
            case 49 :
                // InternalDefinitionLanguage.g:1:298: T__63
                {
                mT__63(); 

                }
                break;
            case 50 :
                // InternalDefinitionLanguage.g:1:304: T__64
                {
                mT__64(); 

                }
                break;
            case 51 :
                // InternalDefinitionLanguage.g:1:310: T__65
                {
                mT__65(); 

                }
                break;
            case 52 :
                // InternalDefinitionLanguage.g:1:316: T__66
                {
                mT__66(); 

                }
                break;
            case 53 :
                // InternalDefinitionLanguage.g:1:322: T__67
                {
                mT__67(); 

                }
                break;
            case 54 :
                // InternalDefinitionLanguage.g:1:328: T__68
                {
                mT__68(); 

                }
                break;
            case 55 :
                // InternalDefinitionLanguage.g:1:334: T__69
                {
                mT__69(); 

                }
                break;
            case 56 :
                // InternalDefinitionLanguage.g:1:340: T__70
                {
                mT__70(); 

                }
                break;
            case 57 :
                // InternalDefinitionLanguage.g:1:346: T__71
                {
                mT__71(); 

                }
                break;
            case 58 :
                // InternalDefinitionLanguage.g:1:352: T__72
                {
                mT__72(); 

                }
                break;
            case 59 :
                // InternalDefinitionLanguage.g:1:358: T__73
                {
                mT__73(); 

                }
                break;
            case 60 :
                // InternalDefinitionLanguage.g:1:364: T__74
                {
                mT__74(); 

                }
                break;
            case 61 :
                // InternalDefinitionLanguage.g:1:370: T__75
                {
                mT__75(); 

                }
                break;
            case 62 :
                // InternalDefinitionLanguage.g:1:376: T__76
                {
                mT__76(); 

                }
                break;
            case 63 :
                // InternalDefinitionLanguage.g:1:382: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 64 :
                // InternalDefinitionLanguage.g:1:391: RULE_DOUBLE
                {
                mRULE_DOUBLE(); 

                }
                break;
            case 65 :
                // InternalDefinitionLanguage.g:1:403: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 66 :
                // InternalDefinitionLanguage.g:1:415: RULE_QUOTED_ID
                {
                mRULE_QUOTED_ID(); 

                }
                break;
            case 67 :
                // InternalDefinitionLanguage.g:1:430: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 68 :
                // InternalDefinitionLanguage.g:1:438: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 69 :
                // InternalDefinitionLanguage.g:1:454: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 70 :
                // InternalDefinitionLanguage.g:1:470: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 71 :
                // InternalDefinitionLanguage.g:1:478: RULE_ANY_OTHER
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
            return "5232:15: ( RULE_INT RULE_EXPONENT | RULE_INT '.' ( RULE_DIGIT )* ( RULE_EXPONENT )? )";
        }
    }
    static final String DFA17_eotS =
        "\1\uffff\1\72\1\74\1\uffff\1\77\1\101\1\uffff\1\103\1\uffff\1\110\1\uffff\1\112\1\113\1\114\1\115\1\116\1\117\1\120\1\121\1\122\1\125\1\126\1\127\1\uffff\1\131\1\132\1\135\1\136\1\137\1\71\2\uffff\2\71\2\uffff\2\71\1\uffff\3\71\3\uffff\3\71\1\165\1\166\2\66\3\uffff\2\71\13\uffff\1\166\16\uffff\1\176\1\71\6\uffff\2\71\3\uffff\2\71\2\uffff\2\71\2\uffff\2\71\1\uffff\4\71\3\uffff\1\u008e\2\71\6\uffff\3\71\1\uffff\1\u0094\11\71\1\u009e\4\71\1\uffff\1\u00a3\1\u00a4\2\71\1\u00a7\1\uffff\2\71\1\u00aa\1\u00ab\5\71\1\uffff\2\71\1\u00b3\1\71\2\uffff\1\u00b5\1\u00b6\1\uffff\1\u00b7\1\71\2\uffff\7\71\1\uffff\1\u00c0\3\uffff\6\71\1\u00c7\1\71\1\uffff\1\71\1\u00ca\1\71\1\u00cc\1\u00cd\1\71\1\uffff\1\u00cf\1\u00d0\1\uffff\1\71\2\uffff\1\u00d2\2\uffff\1\71\1\uffff\1\u00d4\1\uffff";
    static final String DFA17_eofS =
        "\u00d5\uffff";
    static final String DFA17_minS =
        "\1\0\1\60\1\75\1\uffff\2\75\1\uffff\1\60\1\uffff\1\52\1\uffff\14\60\1\uffff\5\60\1\162\2\uffff\1\170\1\156\2\uffff\1\151\1\156\1\uffff\1\164\1\157\1\141\3\uffff\1\122\1\117\1\116\1\101\1\56\2\0\3\uffff\1\154\1\157\13\uffff\1\56\16\uffff\1\60\1\146\6\uffff\1\162\1\163\3\uffff\1\160\1\165\2\uffff\1\160\1\156\2\uffff\1\164\1\163\1\uffff\1\162\1\157\1\151\1\154\3\uffff\1\60\1\122\1\104\6\uffff\1\163\2\141\1\uffff\1\60\1\141\1\164\3\145\1\162\1\141\1\145\1\164\1\60\1\151\1\154\1\144\1\165\1\uffff\2\60\1\145\1\164\1\60\1\uffff\1\171\1\162\2\60\1\156\1\145\1\155\1\162\1\141\1\uffff\1\156\1\145\1\60\1\145\2\uffff\2\60\1\uffff\1\60\1\141\2\uffff\1\144\1\163\1\145\1\141\1\156\1\147\1\141\1\uffff\1\60\3\uffff\1\143\2\163\1\144\1\154\1\143\1\60\1\156\1\uffff\1\164\1\60\1\151\2\60\1\145\1\uffff\2\60\1\uffff\1\157\2\uffff\1\60\2\uffff\1\156\1\uffff\1\60\1\uffff";
    static final String DFA17_maxS =
        "\1\uffff\1\172\1\75\1\uffff\2\75\1\uffff\1\71\1\uffff\1\57\1\uffff\14\172\1\uffff\5\172\1\171\2\uffff\1\170\1\156\2\uffff\1\151\1\156\1\uffff\1\164\2\157\3\uffff\1\122\1\117\1\116\1\172\1\145\2\uffff\3\uffff\1\154\1\157\13\uffff\1\145\16\uffff\1\172\1\146\6\uffff\1\162\1\163\3\uffff\1\160\1\165\2\uffff\1\164\1\156\2\uffff\2\164\1\uffff\1\162\1\157\1\151\1\154\3\uffff\1\172\1\122\1\104\6\uffff\1\163\2\141\1\uffff\1\172\1\141\1\164\3\145\1\162\1\141\1\145\1\164\1\172\1\151\1\154\1\144\1\165\1\uffff\2\172\1\145\1\164\1\172\1\uffff\1\171\1\162\2\172\1\156\1\145\1\155\1\162\1\141\1\uffff\1\156\1\145\1\172\1\145\2\uffff\2\172\1\uffff\1\172\1\141\2\uffff\1\144\1\163\1\145\1\141\1\156\1\147\1\141\1\uffff\1\172\3\uffff\1\143\2\163\1\144\1\154\1\143\1\172\1\156\1\uffff\1\164\1\172\1\151\2\172\1\145\1\uffff\2\172\1\uffff\1\157\2\uffff\1\172\2\uffff\1\156\1\uffff\1\172\1\uffff";
    static final String DFA17_acceptS =
        "\3\uffff\1\4\2\uffff\1\10\1\uffff\1\12\1\uffff\1\14\14\uffff\1\32\6\uffff\1\42\1\43\2\uffff\1\46\1\47\2\uffff\1\52\3\uffff\1\64\1\65\1\66\7\uffff\1\103\1\106\1\107\2\uffff\1\103\1\35\1\2\1\3\1\4\1\5\1\75\1\7\1\6\1\10\1\11\1\uffff\1\12\1\104\1\105\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\2\uffff\1\27\1\30\1\31\1\32\1\33\1\34\2\uffff\1\36\1\37\1\40\2\uffff\1\42\1\43\2\uffff\1\46\1\47\2\uffff\1\52\4\uffff\1\64\1\65\1\66\3\uffff\1\72\1\77\1\100\1\101\1\102\1\106\3\uffff\1\26\17\uffff\1\67\5\uffff\1\63\11\uffff\1\55\4\uffff\1\70\1\71\2\uffff\1\61\2\uffff\1\41\1\76\7\uffff\1\60\1\uffff\1\1\1\56\1\62\10\uffff\1\73\6\uffff\1\53\2\uffff\1\44\1\uffff\1\45\1\50\1\uffff\1\57\1\74\1\uffff\1\51\1\uffff\1\54";
    static final String DFA17_specialS =
        "\1\0\61\uffff\1\2\1\1\u00a1\uffff}>";
    static final String[] DFA17_transitionS = {
            "\11\66\2\65\2\66\1\65\22\66\1\65\1\4\1\62\2\66\1\12\1\66\1\63\1\52\1\53\1\10\1\6\1\54\1\7\1\66\1\11\12\61\1\42\1\43\1\5\1\3\1\2\2\66\1\57\3\64\1\15\1\64\1\20\5\64\1\21\1\64\1\55\1\16\3\64\1\17\3\64\1\56\1\13\1\14\3\66\1\60\1\64\1\66\1\32\1\50\1\25\1\24\1\40\1\1\1\64\1\23\1\45\1\64\1\22\1\44\1\26\1\30\1\64\1\31\2\64\1\47\1\35\1\41\1\51\2\64\1\34\1\33\1\36\1\46\1\37\67\66\1\27\uff4a\66",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\1\67\12\71\1\70\16\71",
            "\1\73",
            "",
            "\1\76",
            "\1\100",
            "",
            "\12\104",
            "",
            "\1\106\4\uffff\1\107",
            "",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\1\123\3\71\1\124\25\71",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\1\71\1\134\17\71\1\133\10\71",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\1\141\6\uffff\1\140",
            "",
            "",
            "\1\144",
            "\1\145",
            "",
            "",
            "\1\150",
            "\1\151",
            "",
            "\1\153",
            "\1\154",
            "\1\156\15\uffff\1\155",
            "",
            "",
            "",
            "\1\162",
            "\1\163",
            "\1\164",
            "\32\71\4\uffff\1\71\1\uffff\32\71",
            "\1\167\1\uffff\12\104\53\uffff\1\167",
            "\0\170",
            "\0\171",
            "",
            "",
            "",
            "\1\173",
            "\1\174",
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
            "\1\167\1\uffff\12\104\53\uffff\1\167",
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
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\23\71\1\175\6\71",
            "\1\177",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u0080",
            "\1\u0081",
            "",
            "",
            "",
            "\1\u0082",
            "\1\u0083",
            "",
            "",
            "\1\u0085\3\uffff\1\u0084",
            "\1\u0086",
            "",
            "",
            "\1\u0087",
            "\1\u0088\1\u0089",
            "",
            "\1\u008a",
            "\1\u008b",
            "\1\u008c",
            "\1\u008d",
            "",
            "",
            "",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\1\u008f",
            "\1\u0090",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u0091",
            "\1\u0092",
            "\1\u0093",
            "",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\1\u0095",
            "\1\u0096",
            "\1\u0097",
            "\1\u0098",
            "\1\u0099",
            "\1\u009a",
            "\1\u009b",
            "\1\u009c",
            "\1\u009d",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\1\u009f",
            "\1\u00a0",
            "\1\u00a1",
            "\1\u00a2",
            "",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\1\u00a5",
            "\1\u00a6",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "",
            "\1\u00a8",
            "\1\u00a9",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\1\u00ac",
            "\1\u00ad",
            "\1\u00ae",
            "\1\u00af",
            "\1\u00b0",
            "",
            "\1\u00b1",
            "\1\u00b2",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\1\u00b4",
            "",
            "",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\1\u00b8",
            "",
            "",
            "\1\u00b9",
            "\1\u00ba",
            "\1\u00bb",
            "\1\u00bc",
            "\1\u00bd",
            "\1\u00be",
            "\1\u00bf",
            "",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "",
            "",
            "",
            "\1\u00c1",
            "\1\u00c2",
            "\1\u00c3",
            "\1\u00c4",
            "\1\u00c5",
            "\1\u00c6",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\1\u00c8",
            "",
            "\1\u00c9",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\1\u00cb",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\1\u00ce",
            "",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "",
            "\1\u00d1",
            "",
            "",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "",
            "",
            "\1\u00d3",
            "",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
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
            return "1:1: Tokens : ( T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | RULE_INT | RULE_DOUBLE | RULE_STRING | RULE_QUOTED_ID | RULE_ID | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA17_0 = input.LA(1);

                        s = -1;
                        if ( (LA17_0=='f') ) {s = 1;}

                        else if ( (LA17_0=='>') ) {s = 2;}

                        else if ( (LA17_0=='=') ) {s = 3;}

                        else if ( (LA17_0=='!') ) {s = 4;}

                        else if ( (LA17_0=='<') ) {s = 5;}

                        else if ( (LA17_0=='+') ) {s = 6;}

                        else if ( (LA17_0=='-') ) {s = 7;}

                        else if ( (LA17_0=='*') ) {s = 8;}

                        else if ( (LA17_0=='/') ) {s = 9;}

                        else if ( (LA17_0=='%') ) {s = 10;}

                        else if ( (LA17_0=='Y') ) {s = 11;}

                        else if ( (LA17_0=='Z') ) {s = 12;}

                        else if ( (LA17_0=='E') ) {s = 13;}

                        else if ( (LA17_0=='P') ) {s = 14;}

                        else if ( (LA17_0=='T') ) {s = 15;}

                        else if ( (LA17_0=='G') ) {s = 16;}

                        else if ( (LA17_0=='M') ) {s = 17;}

                        else if ( (LA17_0=='k') ) {s = 18;}

                        else if ( (LA17_0=='h') ) {s = 19;}

                        else if ( (LA17_0=='d') ) {s = 20;}

                        else if ( (LA17_0=='c') ) {s = 21;}

                        else if ( (LA17_0=='m') ) {s = 22;}

                        else if ( (LA17_0=='\u00B5') ) {s = 23;}

                        else if ( (LA17_0=='n') ) {s = 24;}

                        else if ( (LA17_0=='p') ) {s = 25;}

                        else if ( (LA17_0=='a') ) {s = 26;}

                        else if ( (LA17_0=='z') ) {s = 27;}

                        else if ( (LA17_0=='y') ) {s = 28;}

                        else if ( (LA17_0=='t') ) {s = 29;}

                        else if ( (LA17_0=='{') ) {s = 30;}

                        else if ( (LA17_0=='}') ) {s = 31;}

                        else if ( (LA17_0=='e') ) {s = 32;}

                        else if ( (LA17_0=='u') ) {s = 33;}

                        else if ( (LA17_0==':') ) {s = 34;}

                        else if ( (LA17_0==';') ) {s = 35;}

                        else if ( (LA17_0=='l') ) {s = 36;}

                        else if ( (LA17_0=='i') ) {s = 37;}

                        else if ( (LA17_0=='|') ) {s = 38;}

                        else if ( (LA17_0=='s') ) {s = 39;}

                        else if ( (LA17_0=='b') ) {s = 40;}

                        else if ( (LA17_0=='v') ) {s = 41;}

                        else if ( (LA17_0=='(') ) {s = 42;}

                        else if ( (LA17_0==')') ) {s = 43;}

                        else if ( (LA17_0==',') ) {s = 44;}

                        else if ( (LA17_0=='O') ) {s = 45;}

                        else if ( (LA17_0=='X') ) {s = 46;}

                        else if ( (LA17_0=='A') ) {s = 47;}

                        else if ( (LA17_0=='^') ) {s = 48;}

                        else if ( ((LA17_0>='0' && LA17_0<='9')) ) {s = 49;}

                        else if ( (LA17_0=='\"') ) {s = 50;}

                        else if ( (LA17_0=='\'') ) {s = 51;}

                        else if ( ((LA17_0>='B' && LA17_0<='D')||LA17_0=='F'||(LA17_0>='H' && LA17_0<='L')||LA17_0=='N'||(LA17_0>='Q' && LA17_0<='S')||(LA17_0>='U' && LA17_0<='W')||LA17_0=='_'||LA17_0=='g'||LA17_0=='j'||LA17_0=='o'||(LA17_0>='q' && LA17_0<='r')||(LA17_0>='w' && LA17_0<='x')) ) {s = 52;}

                        else if ( ((LA17_0>='\t' && LA17_0<='\n')||LA17_0=='\r'||LA17_0==' ') ) {s = 53;}

                        else if ( ((LA17_0>='\u0000' && LA17_0<='\b')||(LA17_0>='\u000B' && LA17_0<='\f')||(LA17_0>='\u000E' && LA17_0<='\u001F')||(LA17_0>='#' && LA17_0<='$')||LA17_0=='&'||LA17_0=='.'||(LA17_0>='?' && LA17_0<='@')||(LA17_0>='[' && LA17_0<=']')||LA17_0=='`'||(LA17_0>='~' && LA17_0<='\u00B4')||(LA17_0>='\u00B6' && LA17_0<='\uFFFF')) ) {s = 54;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA17_51 = input.LA(1);

                        s = -1;
                        if ( ((LA17_51>='\u0000' && LA17_51<='\uFFFF')) ) {s = 121;}

                        else s = 54;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA17_50 = input.LA(1);

                        s = -1;
                        if ( ((LA17_50>='\u0000' && LA17_50<='\uFFFF')) ) {s = 120;}

                        else s = 54;

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
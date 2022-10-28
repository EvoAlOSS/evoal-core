package de.evoal.languages.model.mll.dsl.ide.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMachineLearningLanguageLexer extends Lexer {
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__59=59;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__55=55;
    public static final int T__12=12;
    public static final int T__56=56;
    public static final int T__13=13;
    public static final int T__57=57;
    public static final int T__14=14;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=5;
    public static final int RULE_QUOTED_ID=4;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=8;
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
    public static final int RULE_STRING=7;
    public static final int RULE_SL_COMMENT=9;
    public static final int T__37=37;
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
    public static final int RULE_WS=10;
    public static final int RULE_ANY_OTHER=11;
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

    public InternalMachineLearningLanguageLexer() {;} 
    public InternalMachineLearningLanguageLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalMachineLearningLanguageLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalMachineLearningLanguage.g"; }

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMachineLearningLanguage.g:11:7: ( 'false' )
            // InternalMachineLearningLanguage.g:11:9: 'false'
            {
            match("false"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMachineLearningLanguage.g:12:7: ( '>=' )
            // InternalMachineLearningLanguage.g:12:9: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMachineLearningLanguage.g:13:7: ( '>' )
            // InternalMachineLearningLanguage.g:13:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMachineLearningLanguage.g:14:7: ( '=' )
            // InternalMachineLearningLanguage.g:14:9: '='
            {
            match('='); 

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
            // InternalMachineLearningLanguage.g:15:7: ( '!=' )
            // InternalMachineLearningLanguage.g:15:9: '!='
            {
            match("!="); 


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
            // InternalMachineLearningLanguage.g:16:7: ( '<' )
            // InternalMachineLearningLanguage.g:16:9: '<'
            {
            match('<'); 

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
            // InternalMachineLearningLanguage.g:17:7: ( '<=' )
            // InternalMachineLearningLanguage.g:17:9: '<='
            {
            match("<="); 


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
            // InternalMachineLearningLanguage.g:18:7: ( '+' )
            // InternalMachineLearningLanguage.g:18:9: '+'
            {
            match('+'); 

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
            // InternalMachineLearningLanguage.g:19:7: ( '-' )
            // InternalMachineLearningLanguage.g:19:9: '-'
            {
            match('-'); 

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
            // InternalMachineLearningLanguage.g:20:7: ( '*' )
            // InternalMachineLearningLanguage.g:20:9: '*'
            {
            match('*'); 

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
            // InternalMachineLearningLanguage.g:21:7: ( '/' )
            // InternalMachineLearningLanguage.g:21:9: '/'
            {
            match('/'); 

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
            // InternalMachineLearningLanguage.g:22:7: ( '%' )
            // InternalMachineLearningLanguage.g:22:9: '%'
            {
            match('%'); 

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
            // InternalMachineLearningLanguage.g:23:7: ( 'Y' )
            // InternalMachineLearningLanguage.g:23:9: 'Y'
            {
            match('Y'); 

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
            // InternalMachineLearningLanguage.g:24:7: ( 'Z' )
            // InternalMachineLearningLanguage.g:24:9: 'Z'
            {
            match('Z'); 

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
            // InternalMachineLearningLanguage.g:25:7: ( 'E' )
            // InternalMachineLearningLanguage.g:25:9: 'E'
            {
            match('E'); 

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
            // InternalMachineLearningLanguage.g:26:7: ( 'P' )
            // InternalMachineLearningLanguage.g:26:9: 'P'
            {
            match('P'); 

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
            // InternalMachineLearningLanguage.g:27:7: ( 'T' )
            // InternalMachineLearningLanguage.g:27:9: 'T'
            {
            match('T'); 

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
            // InternalMachineLearningLanguage.g:28:7: ( 'G' )
            // InternalMachineLearningLanguage.g:28:9: 'G'
            {
            match('G'); 

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
            // InternalMachineLearningLanguage.g:29:7: ( 'M' )
            // InternalMachineLearningLanguage.g:29:9: 'M'
            {
            match('M'); 

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
            // InternalMachineLearningLanguage.g:30:7: ( 'k' )
            // InternalMachineLearningLanguage.g:30:9: 'k'
            {
            match('k'); 

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
            // InternalMachineLearningLanguage.g:31:7: ( 'h' )
            // InternalMachineLearningLanguage.g:31:9: 'h'
            {
            match('h'); 

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
            // InternalMachineLearningLanguage.g:32:7: ( 'da' )
            // InternalMachineLearningLanguage.g:32:9: 'da'
            {
            match("da"); 


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
            // InternalMachineLearningLanguage.g:33:7: ( 'd' )
            // InternalMachineLearningLanguage.g:33:9: 'd'
            {
            match('d'); 

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
            // InternalMachineLearningLanguage.g:34:7: ( 'c' )
            // InternalMachineLearningLanguage.g:34:9: 'c'
            {
            match('c'); 

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
            // InternalMachineLearningLanguage.g:35:7: ( 'm' )
            // InternalMachineLearningLanguage.g:35:9: 'm'
            {
            match('m'); 

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
            // InternalMachineLearningLanguage.g:36:7: ( '\\u00B5' )
            // InternalMachineLearningLanguage.g:36:9: '\\u00B5'
            {
            match('\u00B5'); 

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
            // InternalMachineLearningLanguage.g:37:7: ( 'n' )
            // InternalMachineLearningLanguage.g:37:9: 'n'
            {
            match('n'); 

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
            // InternalMachineLearningLanguage.g:38:7: ( 'p' )
            // InternalMachineLearningLanguage.g:38:9: 'p'
            {
            match('p'); 

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
            // InternalMachineLearningLanguage.g:39:7: ( 'f' )
            // InternalMachineLearningLanguage.g:39:9: 'f'
            {
            match('f'); 

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
            // InternalMachineLearningLanguage.g:40:7: ( 'a' )
            // InternalMachineLearningLanguage.g:40:9: 'a'
            {
            match('a'); 

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
            // InternalMachineLearningLanguage.g:41:7: ( 'z' )
            // InternalMachineLearningLanguage.g:41:9: 'z'
            {
            match('z'); 

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
            // InternalMachineLearningLanguage.g:42:7: ( 'y' )
            // InternalMachineLearningLanguage.g:42:9: 'y'
            {
            match('y'); 

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
            // InternalMachineLearningLanguage.g:43:7: ( 'use' )
            // InternalMachineLearningLanguage.g:43:9: 'use'
            {
            match("use"); 


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
            // InternalMachineLearningLanguage.g:44:7: ( ';' )
            // InternalMachineLearningLanguage.g:44:9: ';'
            {
            match(';'); 

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
            // InternalMachineLearningLanguage.g:45:7: ( 'prediction' )
            // InternalMachineLearningLanguage.g:45:9: 'prediction'
            {
            match("prediction"); 


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
            // InternalMachineLearningLanguage.g:46:7: ( 'maps' )
            // InternalMachineLearningLanguage.g:46:9: 'maps'
            {
            match("maps"); 


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
            // InternalMachineLearningLanguage.g:47:7: ( 'to' )
            // InternalMachineLearningLanguage.g:47:9: 'to'
            {
            match("to"); 


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
            // InternalMachineLearningLanguage.g:48:7: ( 'using' )
            // InternalMachineLearningLanguage.g:48:9: 'using'
            {
            match("using"); 


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
            // InternalMachineLearningLanguage.g:49:7: ( ',' )
            // InternalMachineLearningLanguage.g:49:9: ','
            {
            match(','); 

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
            // InternalMachineLearningLanguage.g:50:7: ( 'layer' )
            // InternalMachineLearningLanguage.g:50:9: 'layer'
            {
            match("layer"); 


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
            // InternalMachineLearningLanguage.g:51:7: ( 'with' )
            // InternalMachineLearningLanguage.g:51:9: 'with'
            {
            match("with"); 


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
            // InternalMachineLearningLanguage.g:52:7: ( 'function' )
            // InternalMachineLearningLanguage.g:52:9: 'function'
            {
            match("function"); 


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
            // InternalMachineLearningLanguage.g:53:7: ( 'mapping' )
            // InternalMachineLearningLanguage.g:53:9: 'mapping'
            {
            match("mapping"); 


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
            // InternalMachineLearningLanguage.g:54:7: ( 'parameters' )
            // InternalMachineLearningLanguage.g:54:9: 'parameters'
            {
            match("parameters"); 


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
            // InternalMachineLearningLanguage.g:55:7: ( 'predict' )
            // InternalMachineLearningLanguage.g:55:9: 'predict'
            {
            match("predict"); 


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
            // InternalMachineLearningLanguage.g:56:7: ( 'from' )
            // InternalMachineLearningLanguage.g:56:9: 'from'
            {
            match("from"); 


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
            // InternalMachineLearningLanguage.g:57:7: ( 'and' )
            // InternalMachineLearningLanguage.g:57:9: 'and'
            {
            match("and"); 


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
            // InternalMachineLearningLanguage.g:58:7: ( 'store' )
            // InternalMachineLearningLanguage.g:58:9: 'store'
            {
            match("store"); 


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
            // InternalMachineLearningLanguage.g:59:7: ( 'measure' )
            // InternalMachineLearningLanguage.g:59:9: 'measure'
            {
            match("measure"); 


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
            // InternalMachineLearningLanguage.g:60:7: ( 'end' )
            // InternalMachineLearningLanguage.g:60:9: 'end'
            {
            match("end"); 


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
            // InternalMachineLearningLanguage.g:61:7: ( 'for' )
            // InternalMachineLearningLanguage.g:61:9: 'for'
            {
            match("for"); 


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
            // InternalMachineLearningLanguage.g:62:7: ( 'in' )
            // InternalMachineLearningLanguage.g:62:9: 'in'
            {
            match("in"); 


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
            // InternalMachineLearningLanguage.g:63:7: ( 'loop' )
            // InternalMachineLearningLanguage.g:63:9: 'loop'
            {
            match("loop"); 


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
            // InternalMachineLearningLanguage.g:64:7: ( '[' )
            // InternalMachineLearningLanguage.g:64:9: '['
            {
            match('['); 

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
            // InternalMachineLearningLanguage.g:65:7: ( ']' )
            // InternalMachineLearningLanguage.g:65:9: ']'
            {
            match(']'); 

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
            // InternalMachineLearningLanguage.g:66:7: ( '{' )
            // InternalMachineLearningLanguage.g:66:9: '{'
            {
            match('{'); 

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
            // InternalMachineLearningLanguage.g:67:7: ( '}' )
            // InternalMachineLearningLanguage.g:67:9: '}'
            {
            match('}'); 

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
            // InternalMachineLearningLanguage.g:68:7: ( ':=' )
            // InternalMachineLearningLanguage.g:68:9: ':='
            {
            match(":="); 


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
            // InternalMachineLearningLanguage.g:69:7: ( 'data' )
            // InternalMachineLearningLanguage.g:69:9: 'data'
            {
            match("data"); 


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
            // InternalMachineLearningLanguage.g:70:7: ( 'OR' )
            // InternalMachineLearningLanguage.g:70:9: 'OR'
            {
            match("OR"); 


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
            // InternalMachineLearningLanguage.g:71:7: ( 'XOR' )
            // InternalMachineLearningLanguage.g:71:9: 'XOR'
            {
            match("XOR"); 


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
            // InternalMachineLearningLanguage.g:72:7: ( 'AND' )
            // InternalMachineLearningLanguage.g:72:9: 'AND'
            {
            match("AND"); 


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
            // InternalMachineLearningLanguage.g:73:7: ( '^' )
            // InternalMachineLearningLanguage.g:73:9: '^'
            {
            match('^'); 

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
            // InternalMachineLearningLanguage.g:74:7: ( '(' )
            // InternalMachineLearningLanguage.g:74:9: '('
            {
            match('('); 

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
            // InternalMachineLearningLanguage.g:75:7: ( ')' )
            // InternalMachineLearningLanguage.g:75:9: ')'
            {
            match(')'); 

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
            // InternalMachineLearningLanguage.g:76:7: ( 'value' )
            // InternalMachineLearningLanguage.g:76:9: 'value'
            {
            match("value"); 


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
            // InternalMachineLearningLanguage.g:77:7: ( '.' )
            // InternalMachineLearningLanguage.g:77:9: '.'
            {
            match('.'); 

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
            // InternalMachineLearningLanguage.g:78:7: ( '!' )
            // InternalMachineLearningLanguage.g:78:9: '!'
            {
            match('!'); 

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
            // InternalMachineLearningLanguage.g:79:7: ( 'true' )
            // InternalMachineLearningLanguage.g:79:9: 'true'
            {
            match("true"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__80"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMachineLearningLanguage.g:6839:13: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' )
            // InternalMachineLearningLanguage.g:6839:15: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
            {
            match('\"'); 
            // InternalMachineLearningLanguage.g:6839:19: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='\\') ) {
                    alt1=1;
                }
                else if ( ((LA1_0>='\u0000' && LA1_0<='!')||(LA1_0>='#' && LA1_0<='[')||(LA1_0>=']' && LA1_0<='\uFFFF')) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalMachineLearningLanguage.g:6839:20: '\\\\' .
            	    {
            	    match('\\'); 
            	    matchAny(); 

            	    }
            	    break;
            	case 2 :
            	    // InternalMachineLearningLanguage.g:6839:27: ~ ( ( '\\\\' | '\"' ) )
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
            	    break loop1;
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
            // InternalMachineLearningLanguage.g:6841:16: ( '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            // InternalMachineLearningLanguage.g:6841:18: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
            {
            match('\''); 
            // InternalMachineLearningLanguage.g:6841:23: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
            loop2:
            do {
                int alt2=3;
                int LA2_0 = input.LA(1);

                if ( (LA2_0=='\\') ) {
                    alt2=1;
                }
                else if ( ((LA2_0>='\u0000' && LA2_0<='&')||(LA2_0>='(' && LA2_0<='[')||(LA2_0>=']' && LA2_0<='\uFFFF')) ) {
                    alt2=2;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalMachineLearningLanguage.g:6841:24: '\\\\' .
            	    {
            	    match('\\'); 
            	    matchAny(); 

            	    }
            	    break;
            	case 2 :
            	    // InternalMachineLearningLanguage.g:6841:31: ~ ( ( '\\\\' | '\\'' ) )
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
            	    break loop2;
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
            // InternalMachineLearningLanguage.g:6843:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalMachineLearningLanguage.g:6843:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalMachineLearningLanguage.g:6843:11: ( '^' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='^') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalMachineLearningLanguage.g:6843:11: '^'
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

            // InternalMachineLearningLanguage.g:6843:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')||(LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalMachineLearningLanguage.g:
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
            	    break loop4;
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

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMachineLearningLanguage.g:6845:10: ( ( '0' .. '9' )+ )
            // InternalMachineLearningLanguage.g:6845:12: ( '0' .. '9' )+
            {
            // InternalMachineLearningLanguage.g:6845:12: ( '0' .. '9' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalMachineLearningLanguage.g:6845:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMachineLearningLanguage.g:6847:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalMachineLearningLanguage.g:6847:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalMachineLearningLanguage.g:6847:24: ( options {greedy=false; } : . )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0=='*') ) {
                    int LA6_1 = input.LA(2);

                    if ( (LA6_1=='/') ) {
                        alt6=2;
                    }
                    else if ( ((LA6_1>='\u0000' && LA6_1<='.')||(LA6_1>='0' && LA6_1<='\uFFFF')) ) {
                        alt6=1;
                    }


                }
                else if ( ((LA6_0>='\u0000' && LA6_0<=')')||(LA6_0>='+' && LA6_0<='\uFFFF')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalMachineLearningLanguage.g:6847:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop6;
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
            // InternalMachineLearningLanguage.g:6849:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalMachineLearningLanguage.g:6849:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalMachineLearningLanguage.g:6849:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='\u0000' && LA7_0<='\t')||(LA7_0>='\u000B' && LA7_0<='\f')||(LA7_0>='\u000E' && LA7_0<='\uFFFF')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalMachineLearningLanguage.g:6849:24: ~ ( ( '\\n' | '\\r' ) )
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
            	    break loop7;
                }
            } while (true);

            // InternalMachineLearningLanguage.g:6849:40: ( ( '\\r' )? '\\n' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='\n'||LA9_0=='\r') ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalMachineLearningLanguage.g:6849:41: ( '\\r' )? '\\n'
                    {
                    // InternalMachineLearningLanguage.g:6849:41: ( '\\r' )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0=='\r') ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // InternalMachineLearningLanguage.g:6849:41: '\\r'
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
            // InternalMachineLearningLanguage.g:6851:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalMachineLearningLanguage.g:6851:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalMachineLearningLanguage.g:6851:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='\t' && LA10_0<='\n')||LA10_0=='\r'||LA10_0==' ') ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalMachineLearningLanguage.g:
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
            	    if ( cnt10 >= 1 ) break loop10;
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
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
            // InternalMachineLearningLanguage.g:6853:16: ( . )
            // InternalMachineLearningLanguage.g:6853:18: .
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
        // InternalMachineLearningLanguage.g:1:8: ( T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | RULE_STRING | RULE_QUOTED_ID | RULE_ID | RULE_INT | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt11=77;
        alt11 = dfa11.predict(input);
        switch (alt11) {
            case 1 :
                // InternalMachineLearningLanguage.g:1:10: T__12
                {
                mT__12(); 

                }
                break;
            case 2 :
                // InternalMachineLearningLanguage.g:1:16: T__13
                {
                mT__13(); 

                }
                break;
            case 3 :
                // InternalMachineLearningLanguage.g:1:22: T__14
                {
                mT__14(); 

                }
                break;
            case 4 :
                // InternalMachineLearningLanguage.g:1:28: T__15
                {
                mT__15(); 

                }
                break;
            case 5 :
                // InternalMachineLearningLanguage.g:1:34: T__16
                {
                mT__16(); 

                }
                break;
            case 6 :
                // InternalMachineLearningLanguage.g:1:40: T__17
                {
                mT__17(); 

                }
                break;
            case 7 :
                // InternalMachineLearningLanguage.g:1:46: T__18
                {
                mT__18(); 

                }
                break;
            case 8 :
                // InternalMachineLearningLanguage.g:1:52: T__19
                {
                mT__19(); 

                }
                break;
            case 9 :
                // InternalMachineLearningLanguage.g:1:58: T__20
                {
                mT__20(); 

                }
                break;
            case 10 :
                // InternalMachineLearningLanguage.g:1:64: T__21
                {
                mT__21(); 

                }
                break;
            case 11 :
                // InternalMachineLearningLanguage.g:1:70: T__22
                {
                mT__22(); 

                }
                break;
            case 12 :
                // InternalMachineLearningLanguage.g:1:76: T__23
                {
                mT__23(); 

                }
                break;
            case 13 :
                // InternalMachineLearningLanguage.g:1:82: T__24
                {
                mT__24(); 

                }
                break;
            case 14 :
                // InternalMachineLearningLanguage.g:1:88: T__25
                {
                mT__25(); 

                }
                break;
            case 15 :
                // InternalMachineLearningLanguage.g:1:94: T__26
                {
                mT__26(); 

                }
                break;
            case 16 :
                // InternalMachineLearningLanguage.g:1:100: T__27
                {
                mT__27(); 

                }
                break;
            case 17 :
                // InternalMachineLearningLanguage.g:1:106: T__28
                {
                mT__28(); 

                }
                break;
            case 18 :
                // InternalMachineLearningLanguage.g:1:112: T__29
                {
                mT__29(); 

                }
                break;
            case 19 :
                // InternalMachineLearningLanguage.g:1:118: T__30
                {
                mT__30(); 

                }
                break;
            case 20 :
                // InternalMachineLearningLanguage.g:1:124: T__31
                {
                mT__31(); 

                }
                break;
            case 21 :
                // InternalMachineLearningLanguage.g:1:130: T__32
                {
                mT__32(); 

                }
                break;
            case 22 :
                // InternalMachineLearningLanguage.g:1:136: T__33
                {
                mT__33(); 

                }
                break;
            case 23 :
                // InternalMachineLearningLanguage.g:1:142: T__34
                {
                mT__34(); 

                }
                break;
            case 24 :
                // InternalMachineLearningLanguage.g:1:148: T__35
                {
                mT__35(); 

                }
                break;
            case 25 :
                // InternalMachineLearningLanguage.g:1:154: T__36
                {
                mT__36(); 

                }
                break;
            case 26 :
                // InternalMachineLearningLanguage.g:1:160: T__37
                {
                mT__37(); 

                }
                break;
            case 27 :
                // InternalMachineLearningLanguage.g:1:166: T__38
                {
                mT__38(); 

                }
                break;
            case 28 :
                // InternalMachineLearningLanguage.g:1:172: T__39
                {
                mT__39(); 

                }
                break;
            case 29 :
                // InternalMachineLearningLanguage.g:1:178: T__40
                {
                mT__40(); 

                }
                break;
            case 30 :
                // InternalMachineLearningLanguage.g:1:184: T__41
                {
                mT__41(); 

                }
                break;
            case 31 :
                // InternalMachineLearningLanguage.g:1:190: T__42
                {
                mT__42(); 

                }
                break;
            case 32 :
                // InternalMachineLearningLanguage.g:1:196: T__43
                {
                mT__43(); 

                }
                break;
            case 33 :
                // InternalMachineLearningLanguage.g:1:202: T__44
                {
                mT__44(); 

                }
                break;
            case 34 :
                // InternalMachineLearningLanguage.g:1:208: T__45
                {
                mT__45(); 

                }
                break;
            case 35 :
                // InternalMachineLearningLanguage.g:1:214: T__46
                {
                mT__46(); 

                }
                break;
            case 36 :
                // InternalMachineLearningLanguage.g:1:220: T__47
                {
                mT__47(); 

                }
                break;
            case 37 :
                // InternalMachineLearningLanguage.g:1:226: T__48
                {
                mT__48(); 

                }
                break;
            case 38 :
                // InternalMachineLearningLanguage.g:1:232: T__49
                {
                mT__49(); 

                }
                break;
            case 39 :
                // InternalMachineLearningLanguage.g:1:238: T__50
                {
                mT__50(); 

                }
                break;
            case 40 :
                // InternalMachineLearningLanguage.g:1:244: T__51
                {
                mT__51(); 

                }
                break;
            case 41 :
                // InternalMachineLearningLanguage.g:1:250: T__52
                {
                mT__52(); 

                }
                break;
            case 42 :
                // InternalMachineLearningLanguage.g:1:256: T__53
                {
                mT__53(); 

                }
                break;
            case 43 :
                // InternalMachineLearningLanguage.g:1:262: T__54
                {
                mT__54(); 

                }
                break;
            case 44 :
                // InternalMachineLearningLanguage.g:1:268: T__55
                {
                mT__55(); 

                }
                break;
            case 45 :
                // InternalMachineLearningLanguage.g:1:274: T__56
                {
                mT__56(); 

                }
                break;
            case 46 :
                // InternalMachineLearningLanguage.g:1:280: T__57
                {
                mT__57(); 

                }
                break;
            case 47 :
                // InternalMachineLearningLanguage.g:1:286: T__58
                {
                mT__58(); 

                }
                break;
            case 48 :
                // InternalMachineLearningLanguage.g:1:292: T__59
                {
                mT__59(); 

                }
                break;
            case 49 :
                // InternalMachineLearningLanguage.g:1:298: T__60
                {
                mT__60(); 

                }
                break;
            case 50 :
                // InternalMachineLearningLanguage.g:1:304: T__61
                {
                mT__61(); 

                }
                break;
            case 51 :
                // InternalMachineLearningLanguage.g:1:310: T__62
                {
                mT__62(); 

                }
                break;
            case 52 :
                // InternalMachineLearningLanguage.g:1:316: T__63
                {
                mT__63(); 

                }
                break;
            case 53 :
                // InternalMachineLearningLanguage.g:1:322: T__64
                {
                mT__64(); 

                }
                break;
            case 54 :
                // InternalMachineLearningLanguage.g:1:328: T__65
                {
                mT__65(); 

                }
                break;
            case 55 :
                // InternalMachineLearningLanguage.g:1:334: T__66
                {
                mT__66(); 

                }
                break;
            case 56 :
                // InternalMachineLearningLanguage.g:1:340: T__67
                {
                mT__67(); 

                }
                break;
            case 57 :
                // InternalMachineLearningLanguage.g:1:346: T__68
                {
                mT__68(); 

                }
                break;
            case 58 :
                // InternalMachineLearningLanguage.g:1:352: T__69
                {
                mT__69(); 

                }
                break;
            case 59 :
                // InternalMachineLearningLanguage.g:1:358: T__70
                {
                mT__70(); 

                }
                break;
            case 60 :
                // InternalMachineLearningLanguage.g:1:364: T__71
                {
                mT__71(); 

                }
                break;
            case 61 :
                // InternalMachineLearningLanguage.g:1:370: T__72
                {
                mT__72(); 

                }
                break;
            case 62 :
                // InternalMachineLearningLanguage.g:1:376: T__73
                {
                mT__73(); 

                }
                break;
            case 63 :
                // InternalMachineLearningLanguage.g:1:382: T__74
                {
                mT__74(); 

                }
                break;
            case 64 :
                // InternalMachineLearningLanguage.g:1:388: T__75
                {
                mT__75(); 

                }
                break;
            case 65 :
                // InternalMachineLearningLanguage.g:1:394: T__76
                {
                mT__76(); 

                }
                break;
            case 66 :
                // InternalMachineLearningLanguage.g:1:400: T__77
                {
                mT__77(); 

                }
                break;
            case 67 :
                // InternalMachineLearningLanguage.g:1:406: T__78
                {
                mT__78(); 

                }
                break;
            case 68 :
                // InternalMachineLearningLanguage.g:1:412: T__79
                {
                mT__79(); 

                }
                break;
            case 69 :
                // InternalMachineLearningLanguage.g:1:418: T__80
                {
                mT__80(); 

                }
                break;
            case 70 :
                // InternalMachineLearningLanguage.g:1:424: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 71 :
                // InternalMachineLearningLanguage.g:1:436: RULE_QUOTED_ID
                {
                mRULE_QUOTED_ID(); 

                }
                break;
            case 72 :
                // InternalMachineLearningLanguage.g:1:451: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 73 :
                // InternalMachineLearningLanguage.g:1:459: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 74 :
                // InternalMachineLearningLanguage.g:1:468: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 75 :
                // InternalMachineLearningLanguage.g:1:484: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 76 :
                // InternalMachineLearningLanguage.g:1:500: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 77 :
                // InternalMachineLearningLanguage.g:1:508: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA11 dfa11 = new DFA11(this);
    static final String DFA11_eotS =
        "\1\uffff\1\76\1\100\1\uffff\1\103\1\105\3\uffff\1\113\1\uffff\1\115\1\116\1\117\1\120\1\121\1\122\1\123\1\124\1\125\1\127\1\130\1\133\1\uffff\1\135\1\140\1\142\1\143\1\144\1\75\1\uffff\1\75\1\uffff\5\75\4\uffff\1\70\3\75\1\170\2\uffff\1\75\1\uffff\2\70\4\uffff\4\75\31\uffff\1\u0086\2\uffff\2\75\3\uffff\2\75\1\uffff\1\75\3\uffff\1\75\1\uffff\1\u008e\1\75\1\uffff\5\75\1\u0095\5\uffff\1\u0096\2\75\3\uffff\1\75\5\uffff\3\75\1\u009d\1\75\1\uffff\4\75\1\u00a4\1\u00a5\1\75\1\uffff\5\75\1\u00ac\2\uffff\1\u00ad\1\u00ae\3\75\1\u00b2\1\uffff\1\u00b3\1\u00b4\4\75\2\uffff\1\75\1\u00ba\1\75\1\u00bc\1\u00bd\1\75\3\uffff\1\75\1\u00c0\1\75\3\uffff\4\75\1\u00c6\1\uffff\1\u00c7\2\uffff\1\u00c8\1\u00c9\1\uffff\5\75\4\uffff\1\75\1\u00d0\1\u00d1\1\u00d3\1\75\1\u00d5\2\uffff\1\75\1\uffff\1\75\1\uffff\2\75\1\u00da\1\u00db\2\uffff";
    static final String DFA11_eofS =
        "\u00dc\uffff";
    static final String DFA11_minS =
        "\1\0\1\60\1\75\1\uffff\2\75\3\uffff\1\52\1\uffff\14\60\1\uffff\5\60\1\163\1\uffff\1\157\1\uffff\1\141\1\151\1\164\2\156\4\uffff\1\75\1\122\1\117\1\116\1\101\2\uffff\1\141\1\uffff\2\0\4\uffff\1\154\1\156\1\157\1\162\31\uffff\1\60\2\uffff\1\160\1\141\3\uffff\1\145\1\162\1\uffff\1\144\3\uffff\1\145\1\uffff\1\60\1\165\1\uffff\1\171\1\157\1\164\1\157\1\144\1\60\5\uffff\1\60\1\122\1\104\3\uffff\1\154\5\uffff\1\163\1\143\1\155\1\60\1\141\1\uffff\1\160\1\163\1\144\1\141\2\60\1\156\1\uffff\2\145\1\160\1\150\1\162\1\60\2\uffff\2\60\1\165\1\145\1\164\1\60\1\uffff\2\60\1\151\1\165\1\151\1\155\2\uffff\1\147\1\60\1\162\2\60\1\145\3\uffff\1\145\1\60\1\151\3\uffff\1\156\1\162\1\143\1\145\1\60\1\uffff\1\60\2\uffff\2\60\1\uffff\1\157\1\147\1\145\2\164\4\uffff\1\156\3\60\1\145\1\60\2\uffff\1\157\1\uffff\1\162\1\uffff\1\156\1\163\2\60\2\uffff";
    static final String DFA11_maxS =
        "\1\uffff\1\172\1\75\1\uffff\2\75\3\uffff\1\57\1\uffff\14\172\1\uffff\5\172\1\163\1\uffff\1\162\1\uffff\1\157\1\151\1\164\2\156\4\uffff\1\75\1\122\1\117\1\116\1\172\2\uffff\1\141\1\uffff\2\uffff\4\uffff\1\154\1\156\1\157\1\162\31\uffff\1\172\2\uffff\1\160\1\141\3\uffff\1\145\1\162\1\uffff\1\144\3\uffff\1\151\1\uffff\1\172\1\165\1\uffff\1\171\1\157\1\164\1\157\1\144\1\172\5\uffff\1\172\1\122\1\104\3\uffff\1\154\5\uffff\1\163\1\143\1\155\1\172\1\141\1\uffff\2\163\1\144\1\141\2\172\1\156\1\uffff\2\145\1\160\1\150\1\162\1\172\2\uffff\2\172\1\165\1\145\1\164\1\172\1\uffff\2\172\1\151\1\165\1\151\1\155\2\uffff\1\147\1\172\1\162\2\172\1\145\3\uffff\1\145\1\172\1\151\3\uffff\1\156\1\162\1\143\1\145\1\172\1\uffff\1\172\2\uffff\2\172\1\uffff\1\157\1\147\1\145\2\164\4\uffff\1\156\3\172\1\145\1\172\2\uffff\1\157\1\uffff\1\162\1\uffff\1\156\1\163\2\172\2\uffff";
    static final String DFA11_acceptS =
        "\3\uffff\1\4\2\uffff\1\10\1\11\1\12\1\uffff\1\14\14\uffff\1\32\6\uffff\1\42\1\uffff\1\47\5\uffff\1\66\1\67\1\70\1\71\5\uffff\1\100\1\101\1\uffff\1\103\2\uffff\1\110\1\111\1\114\1\115\4\uffff\1\110\1\35\1\2\1\3\1\4\1\5\1\104\1\7\1\6\1\10\1\11\1\12\1\112\1\113\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\uffff\1\27\1\30\2\uffff\1\31\1\32\1\33\2\uffff\1\34\1\uffff\1\36\1\37\1\40\1\uffff\1\42\2\uffff\1\47\6\uffff\1\66\1\67\1\70\1\71\1\72\3\uffff\1\77\1\100\1\101\1\uffff\1\103\1\106\1\107\1\111\1\114\5\uffff\1\26\7\uffff\1\45\6\uffff\1\64\1\74\6\uffff\1\63\6\uffff\1\57\1\41\6\uffff\1\62\1\75\1\76\3\uffff\1\56\1\73\1\44\5\uffff\1\105\1\uffff\1\65\1\51\2\uffff\1\1\5\uffff\1\46\1\50\1\60\1\102\6\uffff\1\53\1\61\1\uffff\1\55\1\uffff\1\52\4\uffff\1\43\1\54";
    static final String DFA11_specialS =
        "\1\1\62\uffff\1\2\1\0\u00a7\uffff}>";
    static final String[] DFA11_transitionS = {
            "\11\70\2\67\2\70\1\67\22\70\1\67\1\4\1\63\2\70\1\12\1\70\1\64\1\57\1\60\1\10\1\6\1\40\1\7\1\62\1\11\12\66\1\52\1\36\1\5\1\3\1\2\2\70\1\55\3\65\1\15\1\65\1\20\5\65\1\21\1\65\1\53\1\16\3\65\1\17\3\65\1\54\1\13\1\14\1\46\1\70\1\47\1\56\1\65\1\70\1\32\1\65\1\25\1\24\1\44\1\1\1\65\1\23\1\45\1\65\1\22\1\41\1\26\1\30\1\65\1\31\2\65\1\43\1\37\1\35\1\61\1\42\1\65\1\34\1\33\1\50\1\70\1\51\67\70\1\27\uff4a\70",
            "\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\1\71\15\75\1\74\2\75\1\73\2\75\1\72\5\75",
            "\1\77",
            "",
            "\1\102",
            "\1\104",
            "",
            "",
            "",
            "\1\111\4\uffff\1\112",
            "",
            "\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
            "\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
            "\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
            "\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
            "\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
            "\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
            "\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
            "\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
            "\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
            "\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\1\126\31\75",
            "\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
            "\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\1\131\3\75\1\132\25\75",
            "",
            "\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
            "\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\1\137\20\75\1\136\10\75",
            "\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\15\75\1\141\14\75",
            "\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
            "\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\145",
            "",
            "\1\147\2\uffff\1\150",
            "",
            "\1\152\15\uffff\1\153",
            "\1\154",
            "\1\155",
            "\1\156",
            "\1\157",
            "",
            "",
            "",
            "",
            "\1\164",
            "\1\165",
            "\1\166",
            "\1\167",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "",
            "",
            "\1\173",
            "",
            "\0\175",
            "\0\176",
            "",
            "",
            "",
            "",
            "\1\u0081",
            "\1\u0082",
            "\1\u0083",
            "\1\u0084",
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
            "\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\23\75\1\u0085\6\75",
            "",
            "",
            "\1\u0087",
            "\1\u0088",
            "",
            "",
            "",
            "\1\u0089",
            "\1\u008a",
            "",
            "\1\u008b",
            "",
            "",
            "",
            "\1\u008c\3\uffff\1\u008d",
            "",
            "\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u008f",
            "",
            "\1\u0090",
            "\1\u0091",
            "\1\u0092",
            "\1\u0093",
            "\1\u0094",
            "\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
            "",
            "",
            "",
            "",
            "",
            "\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u0097",
            "\1\u0098",
            "",
            "",
            "",
            "\1\u0099",
            "",
            "",
            "",
            "",
            "",
            "\1\u009a",
            "\1\u009b",
            "\1\u009c",
            "\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u009e",
            "",
            "\1\u00a0\2\uffff\1\u009f",
            "\1\u00a1",
            "\1\u00a2",
            "\1\u00a3",
            "\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
            "\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u00a6",
            "",
            "\1\u00a7",
            "\1\u00a8",
            "\1\u00a9",
            "\1\u00aa",
            "\1\u00ab",
            "\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
            "",
            "",
            "\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
            "\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u00af",
            "\1\u00b0",
            "\1\u00b1",
            "\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
            "",
            "\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
            "\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u00b5",
            "\1\u00b6",
            "\1\u00b7",
            "\1\u00b8",
            "",
            "",
            "\1\u00b9",
            "\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u00bb",
            "\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
            "\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u00be",
            "",
            "",
            "",
            "\1\u00bf",
            "\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u00c1",
            "",
            "",
            "",
            "\1\u00c2",
            "\1\u00c3",
            "\1\u00c4",
            "\1\u00c5",
            "\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
            "",
            "\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
            "",
            "",
            "\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
            "\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
            "",
            "\1\u00ca",
            "\1\u00cb",
            "\1\u00cc",
            "\1\u00cd",
            "\1\u00ce",
            "",
            "",
            "",
            "",
            "\1\u00cf",
            "\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
            "\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
            "\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\10\75\1\u00d2\21\75",
            "\1\u00d4",
            "\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
            "",
            "",
            "\1\u00d6",
            "",
            "\1\u00d7",
            "",
            "\1\u00d8",
            "\1\u00d9",
            "\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
            "\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
            "",
            ""
    };

    static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
    static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
    static final char[] DFA11_min = DFA.unpackEncodedStringToUnsignedChars(DFA11_minS);
    static final char[] DFA11_max = DFA.unpackEncodedStringToUnsignedChars(DFA11_maxS);
    static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
    static final short[] DFA11_special = DFA.unpackEncodedString(DFA11_specialS);
    static final short[][] DFA11_transition;

    static {
        int numStates = DFA11_transitionS.length;
        DFA11_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
        }
    }

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = DFA11_eot;
            this.eof = DFA11_eof;
            this.min = DFA11_min;
            this.max = DFA11_max;
            this.accept = DFA11_accept;
            this.special = DFA11_special;
            this.transition = DFA11_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | RULE_STRING | RULE_QUOTED_ID | RULE_ID | RULE_INT | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA11_52 = input.LA(1);

                        s = -1;
                        if ( ((LA11_52>='\u0000' && LA11_52<='\uFFFF')) ) {s = 126;}

                        else s = 56;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA11_0 = input.LA(1);

                        s = -1;
                        if ( (LA11_0=='f') ) {s = 1;}

                        else if ( (LA11_0=='>') ) {s = 2;}

                        else if ( (LA11_0=='=') ) {s = 3;}

                        else if ( (LA11_0=='!') ) {s = 4;}

                        else if ( (LA11_0=='<') ) {s = 5;}

                        else if ( (LA11_0=='+') ) {s = 6;}

                        else if ( (LA11_0=='-') ) {s = 7;}

                        else if ( (LA11_0=='*') ) {s = 8;}

                        else if ( (LA11_0=='/') ) {s = 9;}

                        else if ( (LA11_0=='%') ) {s = 10;}

                        else if ( (LA11_0=='Y') ) {s = 11;}

                        else if ( (LA11_0=='Z') ) {s = 12;}

                        else if ( (LA11_0=='E') ) {s = 13;}

                        else if ( (LA11_0=='P') ) {s = 14;}

                        else if ( (LA11_0=='T') ) {s = 15;}

                        else if ( (LA11_0=='G') ) {s = 16;}

                        else if ( (LA11_0=='M') ) {s = 17;}

                        else if ( (LA11_0=='k') ) {s = 18;}

                        else if ( (LA11_0=='h') ) {s = 19;}

                        else if ( (LA11_0=='d') ) {s = 20;}

                        else if ( (LA11_0=='c') ) {s = 21;}

                        else if ( (LA11_0=='m') ) {s = 22;}

                        else if ( (LA11_0=='\u00B5') ) {s = 23;}

                        else if ( (LA11_0=='n') ) {s = 24;}

                        else if ( (LA11_0=='p') ) {s = 25;}

                        else if ( (LA11_0=='a') ) {s = 26;}

                        else if ( (LA11_0=='z') ) {s = 27;}

                        else if ( (LA11_0=='y') ) {s = 28;}

                        else if ( (LA11_0=='u') ) {s = 29;}

                        else if ( (LA11_0==';') ) {s = 30;}

                        else if ( (LA11_0=='t') ) {s = 31;}

                        else if ( (LA11_0==',') ) {s = 32;}

                        else if ( (LA11_0=='l') ) {s = 33;}

                        else if ( (LA11_0=='w') ) {s = 34;}

                        else if ( (LA11_0=='s') ) {s = 35;}

                        else if ( (LA11_0=='e') ) {s = 36;}

                        else if ( (LA11_0=='i') ) {s = 37;}

                        else if ( (LA11_0=='[') ) {s = 38;}

                        else if ( (LA11_0==']') ) {s = 39;}

                        else if ( (LA11_0=='{') ) {s = 40;}

                        else if ( (LA11_0=='}') ) {s = 41;}

                        else if ( (LA11_0==':') ) {s = 42;}

                        else if ( (LA11_0=='O') ) {s = 43;}

                        else if ( (LA11_0=='X') ) {s = 44;}

                        else if ( (LA11_0=='A') ) {s = 45;}

                        else if ( (LA11_0=='^') ) {s = 46;}

                        else if ( (LA11_0=='(') ) {s = 47;}

                        else if ( (LA11_0==')') ) {s = 48;}

                        else if ( (LA11_0=='v') ) {s = 49;}

                        else if ( (LA11_0=='.') ) {s = 50;}

                        else if ( (LA11_0=='\"') ) {s = 51;}

                        else if ( (LA11_0=='\'') ) {s = 52;}

                        else if ( ((LA11_0>='B' && LA11_0<='D')||LA11_0=='F'||(LA11_0>='H' && LA11_0<='L')||LA11_0=='N'||(LA11_0>='Q' && LA11_0<='S')||(LA11_0>='U' && LA11_0<='W')||LA11_0=='_'||LA11_0=='b'||LA11_0=='g'||LA11_0=='j'||LA11_0=='o'||(LA11_0>='q' && LA11_0<='r')||LA11_0=='x') ) {s = 53;}

                        else if ( ((LA11_0>='0' && LA11_0<='9')) ) {s = 54;}

                        else if ( ((LA11_0>='\t' && LA11_0<='\n')||LA11_0=='\r'||LA11_0==' ') ) {s = 55;}

                        else if ( ((LA11_0>='\u0000' && LA11_0<='\b')||(LA11_0>='\u000B' && LA11_0<='\f')||(LA11_0>='\u000E' && LA11_0<='\u001F')||(LA11_0>='#' && LA11_0<='$')||LA11_0=='&'||(LA11_0>='?' && LA11_0<='@')||LA11_0=='\\'||LA11_0=='`'||LA11_0=='|'||(LA11_0>='~' && LA11_0<='\u00B4')||(LA11_0>='\u00B6' && LA11_0<='\uFFFF')) ) {s = 56;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA11_51 = input.LA(1);

                        s = -1;
                        if ( ((LA11_51>='\u0000' && LA11_51<='\uFFFF')) ) {s = 125;}

                        else s = 56;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 11, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}
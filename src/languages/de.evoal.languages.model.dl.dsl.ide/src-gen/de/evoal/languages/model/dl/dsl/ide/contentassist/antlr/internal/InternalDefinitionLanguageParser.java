package de.evoal.languages.model.dl.dsl.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import de.evoal.languages.model.dl.dsl.services.DefinitionLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalDefinitionLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_QUOTED_ID", "RULE_ID", "RULE_DOUBLE", "RULE_INT", "RULE_STRING", "RULE_DIGIT", "RULE_EXPONENT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'false'", "'>='", "'>'", "'='", "'!='", "'<'", "'<='", "'+'", "'-'", "'*'", "'/'", "'%'", "'Y'", "'Z'", "'E'", "'P'", "'T'", "'G'", "'M'", "'k'", "'h'", "'da'", "'d'", "'c'", "'m'", "'\\u00B5'", "'n'", "'p'", "'f'", "'a'", "'z'", "'y'", "'module'", "'{'", "'}'", "'import'", "';'", "'OR'", "'XOR'", "'AND'", "'^'", "'('", "')'", "','", "'value'", "'type'", "'extends'", "':'", "':='", "'literal'", "'instance'", "'|'", "'string'", "'expression'", "'int'", "'float'", "'boolean'", "'void'", "'data'", "'array'", "'def'", "'.'", "'!'", "'true'", "'abstract'"
    };
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


        public InternalDefinitionLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalDefinitionLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalDefinitionLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalDefinitionLanguage.g"; }


    	private DefinitionLanguageGrammarAccess grammarAccess;

    	public void setGrammarAccess(DefinitionLanguageGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRuleDefinitionModelRule"
    // InternalDefinitionLanguage.g:54:1: entryRuleDefinitionModelRule : ruleDefinitionModelRule EOF ;
    public final void entryRuleDefinitionModelRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:55:1: ( ruleDefinitionModelRule EOF )
            // InternalDefinitionLanguage.g:56:1: ruleDefinitionModelRule EOF
            {
             before(grammarAccess.getDefinitionModelRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleDefinitionModelRule();

            state._fsp--;

             after(grammarAccess.getDefinitionModelRuleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDefinitionModelRule"


    // $ANTLR start "ruleDefinitionModelRule"
    // InternalDefinitionLanguage.g:63:1: ruleDefinitionModelRule : ( ( rule__DefinitionModelRule__Group__0 ) ) ;
    public final void ruleDefinitionModelRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:67:2: ( ( ( rule__DefinitionModelRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:68:2: ( ( rule__DefinitionModelRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:68:2: ( ( rule__DefinitionModelRule__Group__0 ) )
            // InternalDefinitionLanguage.g:69:3: ( rule__DefinitionModelRule__Group__0 )
            {
             before(grammarAccess.getDefinitionModelRuleAccess().getGroup()); 
            // InternalDefinitionLanguage.g:70:3: ( rule__DefinitionModelRule__Group__0 )
            // InternalDefinitionLanguage.g:70:4: rule__DefinitionModelRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DefinitionModelRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDefinitionModelRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDefinitionModelRule"


    // $ANTLR start "entryRuleImportRule"
    // InternalDefinitionLanguage.g:79:1: entryRuleImportRule : ruleImportRule EOF ;
    public final void entryRuleImportRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:80:1: ( ruleImportRule EOF )
            // InternalDefinitionLanguage.g:81:1: ruleImportRule EOF
            {
             before(grammarAccess.getImportRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleImportRule();

            state._fsp--;

             after(grammarAccess.getImportRuleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleImportRule"


    // $ANTLR start "ruleImportRule"
    // InternalDefinitionLanguage.g:88:1: ruleImportRule : ( ( rule__ImportRule__Group__0 ) ) ;
    public final void ruleImportRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:92:2: ( ( ( rule__ImportRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:93:2: ( ( rule__ImportRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:93:2: ( ( rule__ImportRule__Group__0 ) )
            // InternalDefinitionLanguage.g:94:3: ( rule__ImportRule__Group__0 )
            {
             before(grammarAccess.getImportRuleAccess().getGroup()); 
            // InternalDefinitionLanguage.g:95:3: ( rule__ImportRule__Group__0 )
            // InternalDefinitionLanguage.g:95:4: rule__ImportRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ImportRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getImportRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleImportRule"


    // $ANTLR start "entryRuleExpressionRule"
    // InternalDefinitionLanguage.g:104:1: entryRuleExpressionRule : ruleExpressionRule EOF ;
    public final void entryRuleExpressionRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:105:1: ( ruleExpressionRule EOF )
            // InternalDefinitionLanguage.g:106:1: ruleExpressionRule EOF
            {
             before(grammarAccess.getExpressionRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleExpressionRule();

            state._fsp--;

             after(grammarAccess.getExpressionRuleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleExpressionRule"


    // $ANTLR start "ruleExpressionRule"
    // InternalDefinitionLanguage.g:113:1: ruleExpressionRule : ( ruleOrExpressionRule ) ;
    public final void ruleExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:117:2: ( ( ruleOrExpressionRule ) )
            // InternalDefinitionLanguage.g:118:2: ( ruleOrExpressionRule )
            {
            // InternalDefinitionLanguage.g:118:2: ( ruleOrExpressionRule )
            // InternalDefinitionLanguage.g:119:3: ruleOrExpressionRule
            {
             before(grammarAccess.getExpressionRuleAccess().getOrExpressionRuleParserRuleCall()); 
            pushFollow(FOLLOW_2);
            ruleOrExpressionRule();

            state._fsp--;

             after(grammarAccess.getExpressionRuleAccess().getOrExpressionRuleParserRuleCall()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExpressionRule"


    // $ANTLR start "entryRuleOrExpressionRule"
    // InternalDefinitionLanguage.g:129:1: entryRuleOrExpressionRule : ruleOrExpressionRule EOF ;
    public final void entryRuleOrExpressionRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:130:1: ( ruleOrExpressionRule EOF )
            // InternalDefinitionLanguage.g:131:1: ruleOrExpressionRule EOF
            {
             before(grammarAccess.getOrExpressionRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleOrExpressionRule();

            state._fsp--;

             after(grammarAccess.getOrExpressionRuleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOrExpressionRule"


    // $ANTLR start "ruleOrExpressionRule"
    // InternalDefinitionLanguage.g:138:1: ruleOrExpressionRule : ( ( rule__OrExpressionRule__Group__0 ) ) ;
    public final void ruleOrExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:142:2: ( ( ( rule__OrExpressionRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:143:2: ( ( rule__OrExpressionRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:143:2: ( ( rule__OrExpressionRule__Group__0 ) )
            // InternalDefinitionLanguage.g:144:3: ( rule__OrExpressionRule__Group__0 )
            {
             before(grammarAccess.getOrExpressionRuleAccess().getGroup()); 
            // InternalDefinitionLanguage.g:145:3: ( rule__OrExpressionRule__Group__0 )
            // InternalDefinitionLanguage.g:145:4: rule__OrExpressionRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__OrExpressionRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getOrExpressionRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOrExpressionRule"


    // $ANTLR start "entryRuleXorExpressionRule"
    // InternalDefinitionLanguage.g:154:1: entryRuleXorExpressionRule : ruleXorExpressionRule EOF ;
    public final void entryRuleXorExpressionRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:155:1: ( ruleXorExpressionRule EOF )
            // InternalDefinitionLanguage.g:156:1: ruleXorExpressionRule EOF
            {
             before(grammarAccess.getXorExpressionRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleXorExpressionRule();

            state._fsp--;

             after(grammarAccess.getXorExpressionRuleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXorExpressionRule"


    // $ANTLR start "ruleXorExpressionRule"
    // InternalDefinitionLanguage.g:163:1: ruleXorExpressionRule : ( ( rule__XorExpressionRule__Group__0 ) ) ;
    public final void ruleXorExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:167:2: ( ( ( rule__XorExpressionRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:168:2: ( ( rule__XorExpressionRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:168:2: ( ( rule__XorExpressionRule__Group__0 ) )
            // InternalDefinitionLanguage.g:169:3: ( rule__XorExpressionRule__Group__0 )
            {
             before(grammarAccess.getXorExpressionRuleAccess().getGroup()); 
            // InternalDefinitionLanguage.g:170:3: ( rule__XorExpressionRule__Group__0 )
            // InternalDefinitionLanguage.g:170:4: rule__XorExpressionRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__XorExpressionRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getXorExpressionRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleXorExpressionRule"


    // $ANTLR start "entryRuleAndExpressionRule"
    // InternalDefinitionLanguage.g:179:1: entryRuleAndExpressionRule : ruleAndExpressionRule EOF ;
    public final void entryRuleAndExpressionRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:180:1: ( ruleAndExpressionRule EOF )
            // InternalDefinitionLanguage.g:181:1: ruleAndExpressionRule EOF
            {
             before(grammarAccess.getAndExpressionRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleAndExpressionRule();

            state._fsp--;

             after(grammarAccess.getAndExpressionRuleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAndExpressionRule"


    // $ANTLR start "ruleAndExpressionRule"
    // InternalDefinitionLanguage.g:188:1: ruleAndExpressionRule : ( ( rule__AndExpressionRule__Group__0 ) ) ;
    public final void ruleAndExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:192:2: ( ( ( rule__AndExpressionRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:193:2: ( ( rule__AndExpressionRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:193:2: ( ( rule__AndExpressionRule__Group__0 ) )
            // InternalDefinitionLanguage.g:194:3: ( rule__AndExpressionRule__Group__0 )
            {
             before(grammarAccess.getAndExpressionRuleAccess().getGroup()); 
            // InternalDefinitionLanguage.g:195:3: ( rule__AndExpressionRule__Group__0 )
            // InternalDefinitionLanguage.g:195:4: rule__AndExpressionRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__AndExpressionRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAndExpressionRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAndExpressionRule"


    // $ANTLR start "entryRuleNotExpressionRule"
    // InternalDefinitionLanguage.g:204:1: entryRuleNotExpressionRule : ruleNotExpressionRule EOF ;
    public final void entryRuleNotExpressionRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:205:1: ( ruleNotExpressionRule EOF )
            // InternalDefinitionLanguage.g:206:1: ruleNotExpressionRule EOF
            {
             before(grammarAccess.getNotExpressionRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleNotExpressionRule();

            state._fsp--;

             after(grammarAccess.getNotExpressionRuleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNotExpressionRule"


    // $ANTLR start "ruleNotExpressionRule"
    // InternalDefinitionLanguage.g:213:1: ruleNotExpressionRule : ( ( rule__NotExpressionRule__Group__0 ) ) ;
    public final void ruleNotExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:217:2: ( ( ( rule__NotExpressionRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:218:2: ( ( rule__NotExpressionRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:218:2: ( ( rule__NotExpressionRule__Group__0 ) )
            // InternalDefinitionLanguage.g:219:3: ( rule__NotExpressionRule__Group__0 )
            {
             before(grammarAccess.getNotExpressionRuleAccess().getGroup()); 
            // InternalDefinitionLanguage.g:220:3: ( rule__NotExpressionRule__Group__0 )
            // InternalDefinitionLanguage.g:220:4: rule__NotExpressionRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__NotExpressionRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getNotExpressionRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNotExpressionRule"


    // $ANTLR start "entryRuleComparisonExpressionRule"
    // InternalDefinitionLanguage.g:229:1: entryRuleComparisonExpressionRule : ruleComparisonExpressionRule EOF ;
    public final void entryRuleComparisonExpressionRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:230:1: ( ruleComparisonExpressionRule EOF )
            // InternalDefinitionLanguage.g:231:1: ruleComparisonExpressionRule EOF
            {
             before(grammarAccess.getComparisonExpressionRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleComparisonExpressionRule();

            state._fsp--;

             after(grammarAccess.getComparisonExpressionRuleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleComparisonExpressionRule"


    // $ANTLR start "ruleComparisonExpressionRule"
    // InternalDefinitionLanguage.g:238:1: ruleComparisonExpressionRule : ( ( rule__ComparisonExpressionRule__Group__0 ) ) ;
    public final void ruleComparisonExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:242:2: ( ( ( rule__ComparisonExpressionRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:243:2: ( ( rule__ComparisonExpressionRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:243:2: ( ( rule__ComparisonExpressionRule__Group__0 ) )
            // InternalDefinitionLanguage.g:244:3: ( rule__ComparisonExpressionRule__Group__0 )
            {
             before(grammarAccess.getComparisonExpressionRuleAccess().getGroup()); 
            // InternalDefinitionLanguage.g:245:3: ( rule__ComparisonExpressionRule__Group__0 )
            // InternalDefinitionLanguage.g:245:4: rule__ComparisonExpressionRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ComparisonExpressionRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getComparisonExpressionRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleComparisonExpressionRule"


    // $ANTLR start "entryRulePartialComparisonExpressionRule"
    // InternalDefinitionLanguage.g:254:1: entryRulePartialComparisonExpressionRule : rulePartialComparisonExpressionRule EOF ;
    public final void entryRulePartialComparisonExpressionRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:255:1: ( rulePartialComparisonExpressionRule EOF )
            // InternalDefinitionLanguage.g:256:1: rulePartialComparisonExpressionRule EOF
            {
             before(grammarAccess.getPartialComparisonExpressionRuleRule()); 
            pushFollow(FOLLOW_1);
            rulePartialComparisonExpressionRule();

            state._fsp--;

             after(grammarAccess.getPartialComparisonExpressionRuleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePartialComparisonExpressionRule"


    // $ANTLR start "rulePartialComparisonExpressionRule"
    // InternalDefinitionLanguage.g:263:1: rulePartialComparisonExpressionRule : ( ( rule__PartialComparisonExpressionRule__Group__0 ) ) ;
    public final void rulePartialComparisonExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:267:2: ( ( ( rule__PartialComparisonExpressionRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:268:2: ( ( rule__PartialComparisonExpressionRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:268:2: ( ( rule__PartialComparisonExpressionRule__Group__0 ) )
            // InternalDefinitionLanguage.g:269:3: ( rule__PartialComparisonExpressionRule__Group__0 )
            {
             before(grammarAccess.getPartialComparisonExpressionRuleAccess().getGroup()); 
            // InternalDefinitionLanguage.g:270:3: ( rule__PartialComparisonExpressionRule__Group__0 )
            // InternalDefinitionLanguage.g:270:4: rule__PartialComparisonExpressionRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PartialComparisonExpressionRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPartialComparisonExpressionRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePartialComparisonExpressionRule"


    // $ANTLR start "entryRuleAddOrSubtractExpressionRule"
    // InternalDefinitionLanguage.g:279:1: entryRuleAddOrSubtractExpressionRule : ruleAddOrSubtractExpressionRule EOF ;
    public final void entryRuleAddOrSubtractExpressionRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:280:1: ( ruleAddOrSubtractExpressionRule EOF )
            // InternalDefinitionLanguage.g:281:1: ruleAddOrSubtractExpressionRule EOF
            {
             before(grammarAccess.getAddOrSubtractExpressionRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleAddOrSubtractExpressionRule();

            state._fsp--;

             after(grammarAccess.getAddOrSubtractExpressionRuleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAddOrSubtractExpressionRule"


    // $ANTLR start "ruleAddOrSubtractExpressionRule"
    // InternalDefinitionLanguage.g:288:1: ruleAddOrSubtractExpressionRule : ( ( rule__AddOrSubtractExpressionRule__Group__0 ) ) ;
    public final void ruleAddOrSubtractExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:292:2: ( ( ( rule__AddOrSubtractExpressionRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:293:2: ( ( rule__AddOrSubtractExpressionRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:293:2: ( ( rule__AddOrSubtractExpressionRule__Group__0 ) )
            // InternalDefinitionLanguage.g:294:3: ( rule__AddOrSubtractExpressionRule__Group__0 )
            {
             before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getGroup()); 
            // InternalDefinitionLanguage.g:295:3: ( rule__AddOrSubtractExpressionRule__Group__0 )
            // InternalDefinitionLanguage.g:295:4: rule__AddOrSubtractExpressionRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__AddOrSubtractExpressionRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAddOrSubtractExpressionRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAddOrSubtractExpressionRule"


    // $ANTLR start "entryRuleMultiplyDivideModuloExpressionRule"
    // InternalDefinitionLanguage.g:304:1: entryRuleMultiplyDivideModuloExpressionRule : ruleMultiplyDivideModuloExpressionRule EOF ;
    public final void entryRuleMultiplyDivideModuloExpressionRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:305:1: ( ruleMultiplyDivideModuloExpressionRule EOF )
            // InternalDefinitionLanguage.g:306:1: ruleMultiplyDivideModuloExpressionRule EOF
            {
             before(grammarAccess.getMultiplyDivideModuloExpressionRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleMultiplyDivideModuloExpressionRule();

            state._fsp--;

             after(grammarAccess.getMultiplyDivideModuloExpressionRuleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMultiplyDivideModuloExpressionRule"


    // $ANTLR start "ruleMultiplyDivideModuloExpressionRule"
    // InternalDefinitionLanguage.g:313:1: ruleMultiplyDivideModuloExpressionRule : ( ( rule__MultiplyDivideModuloExpressionRule__Group__0 ) ) ;
    public final void ruleMultiplyDivideModuloExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:317:2: ( ( ( rule__MultiplyDivideModuloExpressionRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:318:2: ( ( rule__MultiplyDivideModuloExpressionRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:318:2: ( ( rule__MultiplyDivideModuloExpressionRule__Group__0 ) )
            // InternalDefinitionLanguage.g:319:3: ( rule__MultiplyDivideModuloExpressionRule__Group__0 )
            {
             before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getGroup()); 
            // InternalDefinitionLanguage.g:320:3: ( rule__MultiplyDivideModuloExpressionRule__Group__0 )
            // InternalDefinitionLanguage.g:320:4: rule__MultiplyDivideModuloExpressionRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__MultiplyDivideModuloExpressionRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMultiplyDivideModuloExpressionRule"


    // $ANTLR start "entryRulePowerOfExpressionRule"
    // InternalDefinitionLanguage.g:329:1: entryRulePowerOfExpressionRule : rulePowerOfExpressionRule EOF ;
    public final void entryRulePowerOfExpressionRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:330:1: ( rulePowerOfExpressionRule EOF )
            // InternalDefinitionLanguage.g:331:1: rulePowerOfExpressionRule EOF
            {
             before(grammarAccess.getPowerOfExpressionRuleRule()); 
            pushFollow(FOLLOW_1);
            rulePowerOfExpressionRule();

            state._fsp--;

             after(grammarAccess.getPowerOfExpressionRuleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePowerOfExpressionRule"


    // $ANTLR start "rulePowerOfExpressionRule"
    // InternalDefinitionLanguage.g:338:1: rulePowerOfExpressionRule : ( ( rule__PowerOfExpressionRule__Group__0 ) ) ;
    public final void rulePowerOfExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:342:2: ( ( ( rule__PowerOfExpressionRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:343:2: ( ( rule__PowerOfExpressionRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:343:2: ( ( rule__PowerOfExpressionRule__Group__0 ) )
            // InternalDefinitionLanguage.g:344:3: ( rule__PowerOfExpressionRule__Group__0 )
            {
             before(grammarAccess.getPowerOfExpressionRuleAccess().getGroup()); 
            // InternalDefinitionLanguage.g:345:3: ( rule__PowerOfExpressionRule__Group__0 )
            // InternalDefinitionLanguage.g:345:4: rule__PowerOfExpressionRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PowerOfExpressionRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPowerOfExpressionRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePowerOfExpressionRule"


    // $ANTLR start "entryRuleUnaryAddOrSubtractExpressionRule"
    // InternalDefinitionLanguage.g:354:1: entryRuleUnaryAddOrSubtractExpressionRule : ruleUnaryAddOrSubtractExpressionRule EOF ;
    public final void entryRuleUnaryAddOrSubtractExpressionRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:355:1: ( ruleUnaryAddOrSubtractExpressionRule EOF )
            // InternalDefinitionLanguage.g:356:1: ruleUnaryAddOrSubtractExpressionRule EOF
            {
             before(grammarAccess.getUnaryAddOrSubtractExpressionRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleUnaryAddOrSubtractExpressionRule();

            state._fsp--;

             after(grammarAccess.getUnaryAddOrSubtractExpressionRuleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleUnaryAddOrSubtractExpressionRule"


    // $ANTLR start "ruleUnaryAddOrSubtractExpressionRule"
    // InternalDefinitionLanguage.g:363:1: ruleUnaryAddOrSubtractExpressionRule : ( ( rule__UnaryAddOrSubtractExpressionRule__Group__0 ) ) ;
    public final void ruleUnaryAddOrSubtractExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:367:2: ( ( ( rule__UnaryAddOrSubtractExpressionRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:368:2: ( ( rule__UnaryAddOrSubtractExpressionRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:368:2: ( ( rule__UnaryAddOrSubtractExpressionRule__Group__0 ) )
            // InternalDefinitionLanguage.g:369:3: ( rule__UnaryAddOrSubtractExpressionRule__Group__0 )
            {
             before(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getGroup()); 
            // InternalDefinitionLanguage.g:370:3: ( rule__UnaryAddOrSubtractExpressionRule__Group__0 )
            // InternalDefinitionLanguage.g:370:4: rule__UnaryAddOrSubtractExpressionRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__UnaryAddOrSubtractExpressionRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleUnaryAddOrSubtractExpressionRule"


    // $ANTLR start "entryRuleLiteralOrReferenceRule"
    // InternalDefinitionLanguage.g:379:1: entryRuleLiteralOrReferenceRule : ruleLiteralOrReferenceRule EOF ;
    public final void entryRuleLiteralOrReferenceRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:380:1: ( ruleLiteralOrReferenceRule EOF )
            // InternalDefinitionLanguage.g:381:1: ruleLiteralOrReferenceRule EOF
            {
             before(grammarAccess.getLiteralOrReferenceRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleLiteralOrReferenceRule();

            state._fsp--;

             after(grammarAccess.getLiteralOrReferenceRuleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLiteralOrReferenceRule"


    // $ANTLR start "ruleLiteralOrReferenceRule"
    // InternalDefinitionLanguage.g:388:1: ruleLiteralOrReferenceRule : ( ( rule__LiteralOrReferenceRule__Alternatives ) ) ;
    public final void ruleLiteralOrReferenceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:392:2: ( ( ( rule__LiteralOrReferenceRule__Alternatives ) ) )
            // InternalDefinitionLanguage.g:393:2: ( ( rule__LiteralOrReferenceRule__Alternatives ) )
            {
            // InternalDefinitionLanguage.g:393:2: ( ( rule__LiteralOrReferenceRule__Alternatives ) )
            // InternalDefinitionLanguage.g:394:3: ( rule__LiteralOrReferenceRule__Alternatives )
            {
             before(grammarAccess.getLiteralOrReferenceRuleAccess().getAlternatives()); 
            // InternalDefinitionLanguage.g:395:3: ( rule__LiteralOrReferenceRule__Alternatives )
            // InternalDefinitionLanguage.g:395:4: rule__LiteralOrReferenceRule__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__LiteralOrReferenceRule__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getLiteralOrReferenceRuleAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLiteralOrReferenceRule"


    // $ANTLR start "entryRuleParanthesesRule"
    // InternalDefinitionLanguage.g:404:1: entryRuleParanthesesRule : ruleParanthesesRule EOF ;
    public final void entryRuleParanthesesRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:405:1: ( ruleParanthesesRule EOF )
            // InternalDefinitionLanguage.g:406:1: ruleParanthesesRule EOF
            {
             before(grammarAccess.getParanthesesRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleParanthesesRule();

            state._fsp--;

             after(grammarAccess.getParanthesesRuleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParanthesesRule"


    // $ANTLR start "ruleParanthesesRule"
    // InternalDefinitionLanguage.g:413:1: ruleParanthesesRule : ( ( rule__ParanthesesRule__Group__0 ) ) ;
    public final void ruleParanthesesRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:417:2: ( ( ( rule__ParanthesesRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:418:2: ( ( rule__ParanthesesRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:418:2: ( ( rule__ParanthesesRule__Group__0 ) )
            // InternalDefinitionLanguage.g:419:3: ( rule__ParanthesesRule__Group__0 )
            {
             before(grammarAccess.getParanthesesRuleAccess().getGroup()); 
            // InternalDefinitionLanguage.g:420:3: ( rule__ParanthesesRule__Group__0 )
            // InternalDefinitionLanguage.g:420:4: rule__ParanthesesRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ParanthesesRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getParanthesesRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParanthesesRule"


    // $ANTLR start "entryRuleCallRule"
    // InternalDefinitionLanguage.g:429:1: entryRuleCallRule : ruleCallRule EOF ;
    public final void entryRuleCallRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:430:1: ( ruleCallRule EOF )
            // InternalDefinitionLanguage.g:431:1: ruleCallRule EOF
            {
             before(grammarAccess.getCallRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleCallRule();

            state._fsp--;

             after(grammarAccess.getCallRuleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCallRule"


    // $ANTLR start "ruleCallRule"
    // InternalDefinitionLanguage.g:438:1: ruleCallRule : ( ( rule__CallRule__Group__0 ) ) ;
    public final void ruleCallRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:442:2: ( ( ( rule__CallRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:443:2: ( ( rule__CallRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:443:2: ( ( rule__CallRule__Group__0 ) )
            // InternalDefinitionLanguage.g:444:3: ( rule__CallRule__Group__0 )
            {
             before(grammarAccess.getCallRuleAccess().getGroup()); 
            // InternalDefinitionLanguage.g:445:3: ( rule__CallRule__Group__0 )
            // InternalDefinitionLanguage.g:445:4: rule__CallRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__CallRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCallRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCallRule"


    // $ANTLR start "entryRuleValueReferenceRule"
    // InternalDefinitionLanguage.g:454:1: entryRuleValueReferenceRule : ruleValueReferenceRule EOF ;
    public final void entryRuleValueReferenceRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:455:1: ( ruleValueReferenceRule EOF )
            // InternalDefinitionLanguage.g:456:1: ruleValueReferenceRule EOF
            {
             before(grammarAccess.getValueReferenceRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleValueReferenceRule();

            state._fsp--;

             after(grammarAccess.getValueReferenceRuleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleValueReferenceRule"


    // $ANTLR start "ruleValueReferenceRule"
    // InternalDefinitionLanguage.g:463:1: ruleValueReferenceRule : ( ( rule__ValueReferenceRule__Group__0 ) ) ;
    public final void ruleValueReferenceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:467:2: ( ( ( rule__ValueReferenceRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:468:2: ( ( rule__ValueReferenceRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:468:2: ( ( rule__ValueReferenceRule__Group__0 ) )
            // InternalDefinitionLanguage.g:469:3: ( rule__ValueReferenceRule__Group__0 )
            {
             before(grammarAccess.getValueReferenceRuleAccess().getGroup()); 
            // InternalDefinitionLanguage.g:470:3: ( rule__ValueReferenceRule__Group__0 )
            // InternalDefinitionLanguage.g:470:4: rule__ValueReferenceRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ValueReferenceRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getValueReferenceRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleValueReferenceRule"


    // $ANTLR start "entryRuleLiteralRule"
    // InternalDefinitionLanguage.g:479:1: entryRuleLiteralRule : ruleLiteralRule EOF ;
    public final void entryRuleLiteralRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:480:1: ( ruleLiteralRule EOF )
            // InternalDefinitionLanguage.g:481:1: ruleLiteralRule EOF
            {
             before(grammarAccess.getLiteralRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleLiteralRule();

            state._fsp--;

             after(grammarAccess.getLiteralRuleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLiteralRule"


    // $ANTLR start "ruleLiteralRule"
    // InternalDefinitionLanguage.g:488:1: ruleLiteralRule : ( ( rule__LiteralRule__Alternatives ) ) ;
    public final void ruleLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:492:2: ( ( ( rule__LiteralRule__Alternatives ) ) )
            // InternalDefinitionLanguage.g:493:2: ( ( rule__LiteralRule__Alternatives ) )
            {
            // InternalDefinitionLanguage.g:493:2: ( ( rule__LiteralRule__Alternatives ) )
            // InternalDefinitionLanguage.g:494:3: ( rule__LiteralRule__Alternatives )
            {
             before(grammarAccess.getLiteralRuleAccess().getAlternatives()); 
            // InternalDefinitionLanguage.g:495:3: ( rule__LiteralRule__Alternatives )
            // InternalDefinitionLanguage.g:495:4: rule__LiteralRule__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__LiteralRule__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getLiteralRuleAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLiteralRule"


    // $ANTLR start "entryRuleNumberLiteralRule"
    // InternalDefinitionLanguage.g:504:1: entryRuleNumberLiteralRule : ruleNumberLiteralRule EOF ;
    public final void entryRuleNumberLiteralRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:505:1: ( ruleNumberLiteralRule EOF )
            // InternalDefinitionLanguage.g:506:1: ruleNumberLiteralRule EOF
            {
             before(grammarAccess.getNumberLiteralRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleNumberLiteralRule();

            state._fsp--;

             after(grammarAccess.getNumberLiteralRuleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNumberLiteralRule"


    // $ANTLR start "ruleNumberLiteralRule"
    // InternalDefinitionLanguage.g:513:1: ruleNumberLiteralRule : ( ( rule__NumberLiteralRule__Alternatives ) ) ;
    public final void ruleNumberLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:517:2: ( ( ( rule__NumberLiteralRule__Alternatives ) ) )
            // InternalDefinitionLanguage.g:518:2: ( ( rule__NumberLiteralRule__Alternatives ) )
            {
            // InternalDefinitionLanguage.g:518:2: ( ( rule__NumberLiteralRule__Alternatives ) )
            // InternalDefinitionLanguage.g:519:3: ( rule__NumberLiteralRule__Alternatives )
            {
             before(grammarAccess.getNumberLiteralRuleAccess().getAlternatives()); 
            // InternalDefinitionLanguage.g:520:3: ( rule__NumberLiteralRule__Alternatives )
            // InternalDefinitionLanguage.g:520:4: rule__NumberLiteralRule__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__NumberLiteralRule__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getNumberLiteralRuleAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNumberLiteralRule"


    // $ANTLR start "entryRuleDoubleLiteralRule"
    // InternalDefinitionLanguage.g:529:1: entryRuleDoubleLiteralRule : ruleDoubleLiteralRule EOF ;
    public final void entryRuleDoubleLiteralRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:530:1: ( ruleDoubleLiteralRule EOF )
            // InternalDefinitionLanguage.g:531:1: ruleDoubleLiteralRule EOF
            {
             before(grammarAccess.getDoubleLiteralRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleDoubleLiteralRule();

            state._fsp--;

             after(grammarAccess.getDoubleLiteralRuleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDoubleLiteralRule"


    // $ANTLR start "ruleDoubleLiteralRule"
    // InternalDefinitionLanguage.g:538:1: ruleDoubleLiteralRule : ( ( rule__DoubleLiteralRule__Group__0 ) ) ;
    public final void ruleDoubleLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:542:2: ( ( ( rule__DoubleLiteralRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:543:2: ( ( rule__DoubleLiteralRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:543:2: ( ( rule__DoubleLiteralRule__Group__0 ) )
            // InternalDefinitionLanguage.g:544:3: ( rule__DoubleLiteralRule__Group__0 )
            {
             before(grammarAccess.getDoubleLiteralRuleAccess().getGroup()); 
            // InternalDefinitionLanguage.g:545:3: ( rule__DoubleLiteralRule__Group__0 )
            // InternalDefinitionLanguage.g:545:4: rule__DoubleLiteralRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DoubleLiteralRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDoubleLiteralRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDoubleLiteralRule"


    // $ANTLR start "entryRuleIntegerLiteralRule"
    // InternalDefinitionLanguage.g:554:1: entryRuleIntegerLiteralRule : ruleIntegerLiteralRule EOF ;
    public final void entryRuleIntegerLiteralRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:555:1: ( ruleIntegerLiteralRule EOF )
            // InternalDefinitionLanguage.g:556:1: ruleIntegerLiteralRule EOF
            {
             before(grammarAccess.getIntegerLiteralRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleIntegerLiteralRule();

            state._fsp--;

             after(grammarAccess.getIntegerLiteralRuleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIntegerLiteralRule"


    // $ANTLR start "ruleIntegerLiteralRule"
    // InternalDefinitionLanguage.g:563:1: ruleIntegerLiteralRule : ( ( rule__IntegerLiteralRule__Group__0 ) ) ;
    public final void ruleIntegerLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:567:2: ( ( ( rule__IntegerLiteralRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:568:2: ( ( rule__IntegerLiteralRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:568:2: ( ( rule__IntegerLiteralRule__Group__0 ) )
            // InternalDefinitionLanguage.g:569:3: ( rule__IntegerLiteralRule__Group__0 )
            {
             before(grammarAccess.getIntegerLiteralRuleAccess().getGroup()); 
            // InternalDefinitionLanguage.g:570:3: ( rule__IntegerLiteralRule__Group__0 )
            // InternalDefinitionLanguage.g:570:4: rule__IntegerLiteralRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__IntegerLiteralRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getIntegerLiteralRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIntegerLiteralRule"


    // $ANTLR start "entryRuleStringLiteralRule"
    // InternalDefinitionLanguage.g:579:1: entryRuleStringLiteralRule : ruleStringLiteralRule EOF ;
    public final void entryRuleStringLiteralRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:580:1: ( ruleStringLiteralRule EOF )
            // InternalDefinitionLanguage.g:581:1: ruleStringLiteralRule EOF
            {
             before(grammarAccess.getStringLiteralRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleStringLiteralRule();

            state._fsp--;

             after(grammarAccess.getStringLiteralRuleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleStringLiteralRule"


    // $ANTLR start "ruleStringLiteralRule"
    // InternalDefinitionLanguage.g:588:1: ruleStringLiteralRule : ( ( rule__StringLiteralRule__ValueAssignment ) ) ;
    public final void ruleStringLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:592:2: ( ( ( rule__StringLiteralRule__ValueAssignment ) ) )
            // InternalDefinitionLanguage.g:593:2: ( ( rule__StringLiteralRule__ValueAssignment ) )
            {
            // InternalDefinitionLanguage.g:593:2: ( ( rule__StringLiteralRule__ValueAssignment ) )
            // InternalDefinitionLanguage.g:594:3: ( rule__StringLiteralRule__ValueAssignment )
            {
             before(grammarAccess.getStringLiteralRuleAccess().getValueAssignment()); 
            // InternalDefinitionLanguage.g:595:3: ( rule__StringLiteralRule__ValueAssignment )
            // InternalDefinitionLanguage.g:595:4: rule__StringLiteralRule__ValueAssignment
            {
            pushFollow(FOLLOW_2);
            rule__StringLiteralRule__ValueAssignment();

            state._fsp--;


            }

             after(grammarAccess.getStringLiteralRuleAccess().getValueAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleStringLiteralRule"


    // $ANTLR start "entryRuleBooleanLiteralRule"
    // InternalDefinitionLanguage.g:604:1: entryRuleBooleanLiteralRule : ruleBooleanLiteralRule EOF ;
    public final void entryRuleBooleanLiteralRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:605:1: ( ruleBooleanLiteralRule EOF )
            // InternalDefinitionLanguage.g:606:1: ruleBooleanLiteralRule EOF
            {
             before(grammarAccess.getBooleanLiteralRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleBooleanLiteralRule();

            state._fsp--;

             after(grammarAccess.getBooleanLiteralRuleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBooleanLiteralRule"


    // $ANTLR start "ruleBooleanLiteralRule"
    // InternalDefinitionLanguage.g:613:1: ruleBooleanLiteralRule : ( ( rule__BooleanLiteralRule__Group__0 ) ) ;
    public final void ruleBooleanLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:617:2: ( ( ( rule__BooleanLiteralRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:618:2: ( ( rule__BooleanLiteralRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:618:2: ( ( rule__BooleanLiteralRule__Group__0 ) )
            // InternalDefinitionLanguage.g:619:3: ( rule__BooleanLiteralRule__Group__0 )
            {
             before(grammarAccess.getBooleanLiteralRuleAccess().getGroup()); 
            // InternalDefinitionLanguage.g:620:3: ( rule__BooleanLiteralRule__Group__0 )
            // InternalDefinitionLanguage.g:620:4: rule__BooleanLiteralRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__BooleanLiteralRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getBooleanLiteralRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBooleanLiteralRule"


    // $ANTLR start "entryRuleTypeDefinitionRule"
    // InternalDefinitionLanguage.g:629:1: entryRuleTypeDefinitionRule : ruleTypeDefinitionRule EOF ;
    public final void entryRuleTypeDefinitionRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:630:1: ( ruleTypeDefinitionRule EOF )
            // InternalDefinitionLanguage.g:631:1: ruleTypeDefinitionRule EOF
            {
             before(grammarAccess.getTypeDefinitionRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleTypeDefinitionRule();

            state._fsp--;

             after(grammarAccess.getTypeDefinitionRuleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTypeDefinitionRule"


    // $ANTLR start "ruleTypeDefinitionRule"
    // InternalDefinitionLanguage.g:638:1: ruleTypeDefinitionRule : ( ( rule__TypeDefinitionRule__Group__0 ) ) ;
    public final void ruleTypeDefinitionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:642:2: ( ( ( rule__TypeDefinitionRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:643:2: ( ( rule__TypeDefinitionRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:643:2: ( ( rule__TypeDefinitionRule__Group__0 ) )
            // InternalDefinitionLanguage.g:644:3: ( rule__TypeDefinitionRule__Group__0 )
            {
             before(grammarAccess.getTypeDefinitionRuleAccess().getGroup()); 
            // InternalDefinitionLanguage.g:645:3: ( rule__TypeDefinitionRule__Group__0 )
            // InternalDefinitionLanguage.g:645:4: rule__TypeDefinitionRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TypeDefinitionRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTypeDefinitionRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTypeDefinitionRule"


    // $ANTLR start "entryRuleAttributeDefinitionRule"
    // InternalDefinitionLanguage.g:654:1: entryRuleAttributeDefinitionRule : ruleAttributeDefinitionRule EOF ;
    public final void entryRuleAttributeDefinitionRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:655:1: ( ruleAttributeDefinitionRule EOF )
            // InternalDefinitionLanguage.g:656:1: ruleAttributeDefinitionRule EOF
            {
             before(grammarAccess.getAttributeDefinitionRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleAttributeDefinitionRule();

            state._fsp--;

             after(grammarAccess.getAttributeDefinitionRuleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAttributeDefinitionRule"


    // $ANTLR start "ruleAttributeDefinitionRule"
    // InternalDefinitionLanguage.g:663:1: ruleAttributeDefinitionRule : ( ( rule__AttributeDefinitionRule__Group__0 ) ) ;
    public final void ruleAttributeDefinitionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:667:2: ( ( ( rule__AttributeDefinitionRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:668:2: ( ( rule__AttributeDefinitionRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:668:2: ( ( rule__AttributeDefinitionRule__Group__0 ) )
            // InternalDefinitionLanguage.g:669:3: ( rule__AttributeDefinitionRule__Group__0 )
            {
             before(grammarAccess.getAttributeDefinitionRuleAccess().getGroup()); 
            // InternalDefinitionLanguage.g:670:3: ( rule__AttributeDefinitionRule__Group__0 )
            // InternalDefinitionLanguage.g:670:4: rule__AttributeDefinitionRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__AttributeDefinitionRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAttributeDefinitionRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAttributeDefinitionRule"


    // $ANTLR start "entryRuleTypeRule"
    // InternalDefinitionLanguage.g:679:1: entryRuleTypeRule : ruleTypeRule EOF ;
    public final void entryRuleTypeRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:680:1: ( ruleTypeRule EOF )
            // InternalDefinitionLanguage.g:681:1: ruleTypeRule EOF
            {
             before(grammarAccess.getTypeRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleTypeRule();

            state._fsp--;

             after(grammarAccess.getTypeRuleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTypeRule"


    // $ANTLR start "ruleTypeRule"
    // InternalDefinitionLanguage.g:688:1: ruleTypeRule : ( ( rule__TypeRule__Alternatives ) ) ;
    public final void ruleTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:692:2: ( ( ( rule__TypeRule__Alternatives ) ) )
            // InternalDefinitionLanguage.g:693:2: ( ( rule__TypeRule__Alternatives ) )
            {
            // InternalDefinitionLanguage.g:693:2: ( ( rule__TypeRule__Alternatives ) )
            // InternalDefinitionLanguage.g:694:3: ( rule__TypeRule__Alternatives )
            {
             before(grammarAccess.getTypeRuleAccess().getAlternatives()); 
            // InternalDefinitionLanguage.g:695:3: ( rule__TypeRule__Alternatives )
            // InternalDefinitionLanguage.g:695:4: rule__TypeRule__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__TypeRule__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getTypeRuleAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTypeRule"


    // $ANTLR start "entryRuleLiteralTypeRule"
    // InternalDefinitionLanguage.g:704:1: entryRuleLiteralTypeRule : ruleLiteralTypeRule EOF ;
    public final void entryRuleLiteralTypeRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:705:1: ( ruleLiteralTypeRule EOF )
            // InternalDefinitionLanguage.g:706:1: ruleLiteralTypeRule EOF
            {
             before(grammarAccess.getLiteralTypeRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleLiteralTypeRule();

            state._fsp--;

             after(grammarAccess.getLiteralTypeRuleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLiteralTypeRule"


    // $ANTLR start "ruleLiteralTypeRule"
    // InternalDefinitionLanguage.g:713:1: ruleLiteralTypeRule : ( ( rule__LiteralTypeRule__Group__0 ) ) ;
    public final void ruleLiteralTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:717:2: ( ( ( rule__LiteralTypeRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:718:2: ( ( rule__LiteralTypeRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:718:2: ( ( rule__LiteralTypeRule__Group__0 ) )
            // InternalDefinitionLanguage.g:719:3: ( rule__LiteralTypeRule__Group__0 )
            {
             before(grammarAccess.getLiteralTypeRuleAccess().getGroup()); 
            // InternalDefinitionLanguage.g:720:3: ( rule__LiteralTypeRule__Group__0 )
            // InternalDefinitionLanguage.g:720:4: rule__LiteralTypeRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__LiteralTypeRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getLiteralTypeRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLiteralTypeRule"


    // $ANTLR start "entryRuleInstanceTypeRule"
    // InternalDefinitionLanguage.g:729:1: entryRuleInstanceTypeRule : ruleInstanceTypeRule EOF ;
    public final void entryRuleInstanceTypeRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:730:1: ( ruleInstanceTypeRule EOF )
            // InternalDefinitionLanguage.g:731:1: ruleInstanceTypeRule EOF
            {
             before(grammarAccess.getInstanceTypeRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleInstanceTypeRule();

            state._fsp--;

             after(grammarAccess.getInstanceTypeRuleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleInstanceTypeRule"


    // $ANTLR start "ruleInstanceTypeRule"
    // InternalDefinitionLanguage.g:738:1: ruleInstanceTypeRule : ( ( rule__InstanceTypeRule__Group__0 ) ) ;
    public final void ruleInstanceTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:742:2: ( ( ( rule__InstanceTypeRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:743:2: ( ( rule__InstanceTypeRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:743:2: ( ( rule__InstanceTypeRule__Group__0 ) )
            // InternalDefinitionLanguage.g:744:3: ( rule__InstanceTypeRule__Group__0 )
            {
             before(grammarAccess.getInstanceTypeRuleAccess().getGroup()); 
            // InternalDefinitionLanguage.g:745:3: ( rule__InstanceTypeRule__Group__0 )
            // InternalDefinitionLanguage.g:745:4: rule__InstanceTypeRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__InstanceTypeRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getInstanceTypeRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleInstanceTypeRule"


    // $ANTLR start "entryRuleStringTypeRule"
    // InternalDefinitionLanguage.g:754:1: entryRuleStringTypeRule : ruleStringTypeRule EOF ;
    public final void entryRuleStringTypeRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:755:1: ( ruleStringTypeRule EOF )
            // InternalDefinitionLanguage.g:756:1: ruleStringTypeRule EOF
            {
             before(grammarAccess.getStringTypeRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleStringTypeRule();

            state._fsp--;

             after(grammarAccess.getStringTypeRuleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleStringTypeRule"


    // $ANTLR start "ruleStringTypeRule"
    // InternalDefinitionLanguage.g:763:1: ruleStringTypeRule : ( ( rule__StringTypeRule__Group__0 ) ) ;
    public final void ruleStringTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:767:2: ( ( ( rule__StringTypeRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:768:2: ( ( rule__StringTypeRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:768:2: ( ( rule__StringTypeRule__Group__0 ) )
            // InternalDefinitionLanguage.g:769:3: ( rule__StringTypeRule__Group__0 )
            {
             before(grammarAccess.getStringTypeRuleAccess().getGroup()); 
            // InternalDefinitionLanguage.g:770:3: ( rule__StringTypeRule__Group__0 )
            // InternalDefinitionLanguage.g:770:4: rule__StringTypeRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__StringTypeRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getStringTypeRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleStringTypeRule"


    // $ANTLR start "entryRuleExpressionTypeRule"
    // InternalDefinitionLanguage.g:779:1: entryRuleExpressionTypeRule : ruleExpressionTypeRule EOF ;
    public final void entryRuleExpressionTypeRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:780:1: ( ruleExpressionTypeRule EOF )
            // InternalDefinitionLanguage.g:781:1: ruleExpressionTypeRule EOF
            {
             before(grammarAccess.getExpressionTypeRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleExpressionTypeRule();

            state._fsp--;

             after(grammarAccess.getExpressionTypeRuleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleExpressionTypeRule"


    // $ANTLR start "ruleExpressionTypeRule"
    // InternalDefinitionLanguage.g:788:1: ruleExpressionTypeRule : ( ( rule__ExpressionTypeRule__Group__0 ) ) ;
    public final void ruleExpressionTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:792:2: ( ( ( rule__ExpressionTypeRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:793:2: ( ( rule__ExpressionTypeRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:793:2: ( ( rule__ExpressionTypeRule__Group__0 ) )
            // InternalDefinitionLanguage.g:794:3: ( rule__ExpressionTypeRule__Group__0 )
            {
             before(grammarAccess.getExpressionTypeRuleAccess().getGroup()); 
            // InternalDefinitionLanguage.g:795:3: ( rule__ExpressionTypeRule__Group__0 )
            // InternalDefinitionLanguage.g:795:4: rule__ExpressionTypeRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ExpressionTypeRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getExpressionTypeRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExpressionTypeRule"


    // $ANTLR start "entryRuleIntTypeRule"
    // InternalDefinitionLanguage.g:804:1: entryRuleIntTypeRule : ruleIntTypeRule EOF ;
    public final void entryRuleIntTypeRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:805:1: ( ruleIntTypeRule EOF )
            // InternalDefinitionLanguage.g:806:1: ruleIntTypeRule EOF
            {
             before(grammarAccess.getIntTypeRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleIntTypeRule();

            state._fsp--;

             after(grammarAccess.getIntTypeRuleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIntTypeRule"


    // $ANTLR start "ruleIntTypeRule"
    // InternalDefinitionLanguage.g:813:1: ruleIntTypeRule : ( ( rule__IntTypeRule__Group__0 ) ) ;
    public final void ruleIntTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:817:2: ( ( ( rule__IntTypeRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:818:2: ( ( rule__IntTypeRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:818:2: ( ( rule__IntTypeRule__Group__0 ) )
            // InternalDefinitionLanguage.g:819:3: ( rule__IntTypeRule__Group__0 )
            {
             before(grammarAccess.getIntTypeRuleAccess().getGroup()); 
            // InternalDefinitionLanguage.g:820:3: ( rule__IntTypeRule__Group__0 )
            // InternalDefinitionLanguage.g:820:4: rule__IntTypeRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__IntTypeRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getIntTypeRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIntTypeRule"


    // $ANTLR start "entryRuleFloatTypeRule"
    // InternalDefinitionLanguage.g:829:1: entryRuleFloatTypeRule : ruleFloatTypeRule EOF ;
    public final void entryRuleFloatTypeRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:830:1: ( ruleFloatTypeRule EOF )
            // InternalDefinitionLanguage.g:831:1: ruleFloatTypeRule EOF
            {
             before(grammarAccess.getFloatTypeRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleFloatTypeRule();

            state._fsp--;

             after(grammarAccess.getFloatTypeRuleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFloatTypeRule"


    // $ANTLR start "ruleFloatTypeRule"
    // InternalDefinitionLanguage.g:838:1: ruleFloatTypeRule : ( ( rule__FloatTypeRule__Group__0 ) ) ;
    public final void ruleFloatTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:842:2: ( ( ( rule__FloatTypeRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:843:2: ( ( rule__FloatTypeRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:843:2: ( ( rule__FloatTypeRule__Group__0 ) )
            // InternalDefinitionLanguage.g:844:3: ( rule__FloatTypeRule__Group__0 )
            {
             before(grammarAccess.getFloatTypeRuleAccess().getGroup()); 
            // InternalDefinitionLanguage.g:845:3: ( rule__FloatTypeRule__Group__0 )
            // InternalDefinitionLanguage.g:845:4: rule__FloatTypeRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__FloatTypeRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFloatTypeRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFloatTypeRule"


    // $ANTLR start "entryRuleBooleanTypeRule"
    // InternalDefinitionLanguage.g:854:1: entryRuleBooleanTypeRule : ruleBooleanTypeRule EOF ;
    public final void entryRuleBooleanTypeRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:855:1: ( ruleBooleanTypeRule EOF )
            // InternalDefinitionLanguage.g:856:1: ruleBooleanTypeRule EOF
            {
             before(grammarAccess.getBooleanTypeRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleBooleanTypeRule();

            state._fsp--;

             after(grammarAccess.getBooleanTypeRuleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBooleanTypeRule"


    // $ANTLR start "ruleBooleanTypeRule"
    // InternalDefinitionLanguage.g:863:1: ruleBooleanTypeRule : ( ( rule__BooleanTypeRule__Group__0 ) ) ;
    public final void ruleBooleanTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:867:2: ( ( ( rule__BooleanTypeRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:868:2: ( ( rule__BooleanTypeRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:868:2: ( ( rule__BooleanTypeRule__Group__0 ) )
            // InternalDefinitionLanguage.g:869:3: ( rule__BooleanTypeRule__Group__0 )
            {
             before(grammarAccess.getBooleanTypeRuleAccess().getGroup()); 
            // InternalDefinitionLanguage.g:870:3: ( rule__BooleanTypeRule__Group__0 )
            // InternalDefinitionLanguage.g:870:4: rule__BooleanTypeRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__BooleanTypeRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getBooleanTypeRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBooleanTypeRule"


    // $ANTLR start "entryRuleVoidTypeRule"
    // InternalDefinitionLanguage.g:879:1: entryRuleVoidTypeRule : ruleVoidTypeRule EOF ;
    public final void entryRuleVoidTypeRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:880:1: ( ruleVoidTypeRule EOF )
            // InternalDefinitionLanguage.g:881:1: ruleVoidTypeRule EOF
            {
             before(grammarAccess.getVoidTypeRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleVoidTypeRule();

            state._fsp--;

             after(grammarAccess.getVoidTypeRuleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleVoidTypeRule"


    // $ANTLR start "ruleVoidTypeRule"
    // InternalDefinitionLanguage.g:888:1: ruleVoidTypeRule : ( ( rule__VoidTypeRule__Group__0 ) ) ;
    public final void ruleVoidTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:892:2: ( ( ( rule__VoidTypeRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:893:2: ( ( rule__VoidTypeRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:893:2: ( ( rule__VoidTypeRule__Group__0 ) )
            // InternalDefinitionLanguage.g:894:3: ( rule__VoidTypeRule__Group__0 )
            {
             before(grammarAccess.getVoidTypeRuleAccess().getGroup()); 
            // InternalDefinitionLanguage.g:895:3: ( rule__VoidTypeRule__Group__0 )
            // InternalDefinitionLanguage.g:895:4: rule__VoidTypeRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__VoidTypeRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getVoidTypeRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleVoidTypeRule"


    // $ANTLR start "entryRuleDataTypeRule"
    // InternalDefinitionLanguage.g:904:1: entryRuleDataTypeRule : ruleDataTypeRule EOF ;
    public final void entryRuleDataTypeRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:905:1: ( ruleDataTypeRule EOF )
            // InternalDefinitionLanguage.g:906:1: ruleDataTypeRule EOF
            {
             before(grammarAccess.getDataTypeRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleDataTypeRule();

            state._fsp--;

             after(grammarAccess.getDataTypeRuleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDataTypeRule"


    // $ANTLR start "ruleDataTypeRule"
    // InternalDefinitionLanguage.g:913:1: ruleDataTypeRule : ( ( rule__DataTypeRule__Group__0 ) ) ;
    public final void ruleDataTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:917:2: ( ( ( rule__DataTypeRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:918:2: ( ( rule__DataTypeRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:918:2: ( ( rule__DataTypeRule__Group__0 ) )
            // InternalDefinitionLanguage.g:919:3: ( rule__DataTypeRule__Group__0 )
            {
             before(grammarAccess.getDataTypeRuleAccess().getGroup()); 
            // InternalDefinitionLanguage.g:920:3: ( rule__DataTypeRule__Group__0 )
            // InternalDefinitionLanguage.g:920:4: rule__DataTypeRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DataTypeRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDataTypeRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDataTypeRule"


    // $ANTLR start "entryRuleArrayTypeRule"
    // InternalDefinitionLanguage.g:929:1: entryRuleArrayTypeRule : ruleArrayTypeRule EOF ;
    public final void entryRuleArrayTypeRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:930:1: ( ruleArrayTypeRule EOF )
            // InternalDefinitionLanguage.g:931:1: ruleArrayTypeRule EOF
            {
             before(grammarAccess.getArrayTypeRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleArrayTypeRule();

            state._fsp--;

             after(grammarAccess.getArrayTypeRuleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleArrayTypeRule"


    // $ANTLR start "ruleArrayTypeRule"
    // InternalDefinitionLanguage.g:938:1: ruleArrayTypeRule : ( ( rule__ArrayTypeRule__Group__0 ) ) ;
    public final void ruleArrayTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:942:2: ( ( ( rule__ArrayTypeRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:943:2: ( ( rule__ArrayTypeRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:943:2: ( ( rule__ArrayTypeRule__Group__0 ) )
            // InternalDefinitionLanguage.g:944:3: ( rule__ArrayTypeRule__Group__0 )
            {
             before(grammarAccess.getArrayTypeRuleAccess().getGroup()); 
            // InternalDefinitionLanguage.g:945:3: ( rule__ArrayTypeRule__Group__0 )
            // InternalDefinitionLanguage.g:945:4: rule__ArrayTypeRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ArrayTypeRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getArrayTypeRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleArrayTypeRule"


    // $ANTLR start "entryRuleFunctionDefinitionRule"
    // InternalDefinitionLanguage.g:954:1: entryRuleFunctionDefinitionRule : ruleFunctionDefinitionRule EOF ;
    public final void entryRuleFunctionDefinitionRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:955:1: ( ruleFunctionDefinitionRule EOF )
            // InternalDefinitionLanguage.g:956:1: ruleFunctionDefinitionRule EOF
            {
             before(grammarAccess.getFunctionDefinitionRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleFunctionDefinitionRule();

            state._fsp--;

             after(grammarAccess.getFunctionDefinitionRuleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFunctionDefinitionRule"


    // $ANTLR start "ruleFunctionDefinitionRule"
    // InternalDefinitionLanguage.g:963:1: ruleFunctionDefinitionRule : ( ( rule__FunctionDefinitionRule__Group__0 ) ) ;
    public final void ruleFunctionDefinitionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:967:2: ( ( ( rule__FunctionDefinitionRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:968:2: ( ( rule__FunctionDefinitionRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:968:2: ( ( rule__FunctionDefinitionRule__Group__0 ) )
            // InternalDefinitionLanguage.g:969:3: ( rule__FunctionDefinitionRule__Group__0 )
            {
             before(grammarAccess.getFunctionDefinitionRuleAccess().getGroup()); 
            // InternalDefinitionLanguage.g:970:3: ( rule__FunctionDefinitionRule__Group__0 )
            // InternalDefinitionLanguage.g:970:4: rule__FunctionDefinitionRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__FunctionDefinitionRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFunctionDefinitionRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFunctionDefinitionRule"


    // $ANTLR start "entryRuleParameterRule"
    // InternalDefinitionLanguage.g:979:1: entryRuleParameterRule : ruleParameterRule EOF ;
    public final void entryRuleParameterRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:980:1: ( ruleParameterRule EOF )
            // InternalDefinitionLanguage.g:981:1: ruleParameterRule EOF
            {
             before(grammarAccess.getParameterRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleParameterRule();

            state._fsp--;

             after(grammarAccess.getParameterRuleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParameterRule"


    // $ANTLR start "ruleParameterRule"
    // InternalDefinitionLanguage.g:988:1: ruleParameterRule : ( ( rule__ParameterRule__Group__0 ) ) ;
    public final void ruleParameterRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:992:2: ( ( ( rule__ParameterRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:993:2: ( ( rule__ParameterRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:993:2: ( ( rule__ParameterRule__Group__0 ) )
            // InternalDefinitionLanguage.g:994:3: ( rule__ParameterRule__Group__0 )
            {
             before(grammarAccess.getParameterRuleAccess().getGroup()); 
            // InternalDefinitionLanguage.g:995:3: ( rule__ParameterRule__Group__0 )
            // InternalDefinitionLanguage.g:995:4: rule__ParameterRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ParameterRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getParameterRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParameterRule"


    // $ANTLR start "entryRuleFunctionNameRule"
    // InternalDefinitionLanguage.g:1004:1: entryRuleFunctionNameRule : ruleFunctionNameRule EOF ;
    public final void entryRuleFunctionNameRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:1005:1: ( ruleFunctionNameRule EOF )
            // InternalDefinitionLanguage.g:1006:1: ruleFunctionNameRule EOF
            {
             before(grammarAccess.getFunctionNameRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleFunctionNameRule();

            state._fsp--;

             after(grammarAccess.getFunctionNameRuleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFunctionNameRule"


    // $ANTLR start "ruleFunctionNameRule"
    // InternalDefinitionLanguage.g:1013:1: ruleFunctionNameRule : ( ( rule__FunctionNameRule__DefinitionAssignment ) ) ;
    public final void ruleFunctionNameRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1017:2: ( ( ( rule__FunctionNameRule__DefinitionAssignment ) ) )
            // InternalDefinitionLanguage.g:1018:2: ( ( rule__FunctionNameRule__DefinitionAssignment ) )
            {
            // InternalDefinitionLanguage.g:1018:2: ( ( rule__FunctionNameRule__DefinitionAssignment ) )
            // InternalDefinitionLanguage.g:1019:3: ( rule__FunctionNameRule__DefinitionAssignment )
            {
             before(grammarAccess.getFunctionNameRuleAccess().getDefinitionAssignment()); 
            // InternalDefinitionLanguage.g:1020:3: ( rule__FunctionNameRule__DefinitionAssignment )
            // InternalDefinitionLanguage.g:1020:4: rule__FunctionNameRule__DefinitionAssignment
            {
            pushFollow(FOLLOW_2);
            rule__FunctionNameRule__DefinitionAssignment();

            state._fsp--;


            }

             after(grammarAccess.getFunctionNameRuleAccess().getDefinitionAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFunctionNameRule"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalDefinitionLanguage.g:1029:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:1030:1: ( ruleQualifiedName EOF )
            // InternalDefinitionLanguage.g:1031:1: ruleQualifiedName EOF
            {
             before(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_1);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getQualifiedNameRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // InternalDefinitionLanguage.g:1038:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1042:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // InternalDefinitionLanguage.g:1043:2: ( ( rule__QualifiedName__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:1043:2: ( ( rule__QualifiedName__Group__0 ) )
            // InternalDefinitionLanguage.g:1044:3: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // InternalDefinitionLanguage.g:1045:3: ( rule__QualifiedName__Group__0 )
            // InternalDefinitionLanguage.g:1045:4: rule__QualifiedName__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQualifiedNameAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleStringOrId"
    // InternalDefinitionLanguage.g:1054:1: entryRuleStringOrId : ruleStringOrId EOF ;
    public final void entryRuleStringOrId() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:1055:1: ( ruleStringOrId EOF )
            // InternalDefinitionLanguage.g:1056:1: ruleStringOrId EOF
            {
             before(grammarAccess.getStringOrIdRule()); 
            pushFollow(FOLLOW_1);
            ruleStringOrId();

            state._fsp--;

             after(grammarAccess.getStringOrIdRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleStringOrId"


    // $ANTLR start "ruleStringOrId"
    // InternalDefinitionLanguage.g:1063:1: ruleStringOrId : ( ( rule__StringOrId__Alternatives ) ) ;
    public final void ruleStringOrId() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1067:2: ( ( ( rule__StringOrId__Alternatives ) ) )
            // InternalDefinitionLanguage.g:1068:2: ( ( rule__StringOrId__Alternatives ) )
            {
            // InternalDefinitionLanguage.g:1068:2: ( ( rule__StringOrId__Alternatives ) )
            // InternalDefinitionLanguage.g:1069:3: ( rule__StringOrId__Alternatives )
            {
             before(grammarAccess.getStringOrIdAccess().getAlternatives()); 
            // InternalDefinitionLanguage.g:1070:3: ( rule__StringOrId__Alternatives )
            // InternalDefinitionLanguage.g:1070:4: rule__StringOrId__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__StringOrId__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getStringOrIdAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleStringOrId"


    // $ANTLR start "ruleComparisonOperatorRule"
    // InternalDefinitionLanguage.g:1079:1: ruleComparisonOperatorRule : ( ( rule__ComparisonOperatorRule__Alternatives ) ) ;
    public final void ruleComparisonOperatorRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1083:1: ( ( ( rule__ComparisonOperatorRule__Alternatives ) ) )
            // InternalDefinitionLanguage.g:1084:2: ( ( rule__ComparisonOperatorRule__Alternatives ) )
            {
            // InternalDefinitionLanguage.g:1084:2: ( ( rule__ComparisonOperatorRule__Alternatives ) )
            // InternalDefinitionLanguage.g:1085:3: ( rule__ComparisonOperatorRule__Alternatives )
            {
             before(grammarAccess.getComparisonOperatorRuleAccess().getAlternatives()); 
            // InternalDefinitionLanguage.g:1086:3: ( rule__ComparisonOperatorRule__Alternatives )
            // InternalDefinitionLanguage.g:1086:4: rule__ComparisonOperatorRule__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__ComparisonOperatorRule__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getComparisonOperatorRuleAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleComparisonOperatorRule"


    // $ANTLR start "ruleAddOrSubtractOperatorRule"
    // InternalDefinitionLanguage.g:1095:1: ruleAddOrSubtractOperatorRule : ( ( rule__AddOrSubtractOperatorRule__Alternatives ) ) ;
    public final void ruleAddOrSubtractOperatorRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1099:1: ( ( ( rule__AddOrSubtractOperatorRule__Alternatives ) ) )
            // InternalDefinitionLanguage.g:1100:2: ( ( rule__AddOrSubtractOperatorRule__Alternatives ) )
            {
            // InternalDefinitionLanguage.g:1100:2: ( ( rule__AddOrSubtractOperatorRule__Alternatives ) )
            // InternalDefinitionLanguage.g:1101:3: ( rule__AddOrSubtractOperatorRule__Alternatives )
            {
             before(grammarAccess.getAddOrSubtractOperatorRuleAccess().getAlternatives()); 
            // InternalDefinitionLanguage.g:1102:3: ( rule__AddOrSubtractOperatorRule__Alternatives )
            // InternalDefinitionLanguage.g:1102:4: rule__AddOrSubtractOperatorRule__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__AddOrSubtractOperatorRule__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getAddOrSubtractOperatorRuleAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAddOrSubtractOperatorRule"


    // $ANTLR start "ruleMultiplyDivideModuloOperatorRule"
    // InternalDefinitionLanguage.g:1111:1: ruleMultiplyDivideModuloOperatorRule : ( ( rule__MultiplyDivideModuloOperatorRule__Alternatives ) ) ;
    public final void ruleMultiplyDivideModuloOperatorRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1115:1: ( ( ( rule__MultiplyDivideModuloOperatorRule__Alternatives ) ) )
            // InternalDefinitionLanguage.g:1116:2: ( ( rule__MultiplyDivideModuloOperatorRule__Alternatives ) )
            {
            // InternalDefinitionLanguage.g:1116:2: ( ( rule__MultiplyDivideModuloOperatorRule__Alternatives ) )
            // InternalDefinitionLanguage.g:1117:3: ( rule__MultiplyDivideModuloOperatorRule__Alternatives )
            {
             before(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getAlternatives()); 
            // InternalDefinitionLanguage.g:1118:3: ( rule__MultiplyDivideModuloOperatorRule__Alternatives )
            // InternalDefinitionLanguage.g:1118:4: rule__MultiplyDivideModuloOperatorRule__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__MultiplyDivideModuloOperatorRule__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMultiplyDivideModuloOperatorRule"


    // $ANTLR start "ruleFactorRule"
    // InternalDefinitionLanguage.g:1127:1: ruleFactorRule : ( ( rule__FactorRule__Alternatives ) ) ;
    public final void ruleFactorRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1131:1: ( ( ( rule__FactorRule__Alternatives ) ) )
            // InternalDefinitionLanguage.g:1132:2: ( ( rule__FactorRule__Alternatives ) )
            {
            // InternalDefinitionLanguage.g:1132:2: ( ( rule__FactorRule__Alternatives ) )
            // InternalDefinitionLanguage.g:1133:3: ( rule__FactorRule__Alternatives )
            {
             before(grammarAccess.getFactorRuleAccess().getAlternatives()); 
            // InternalDefinitionLanguage.g:1134:3: ( rule__FactorRule__Alternatives )
            // InternalDefinitionLanguage.g:1134:4: rule__FactorRule__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__FactorRule__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getFactorRuleAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFactorRule"


    // $ANTLR start "rule__DefinitionModelRule__Alternatives_4"
    // InternalDefinitionLanguage.g:1142:1: rule__DefinitionModelRule__Alternatives_4 : ( ( ( rule__DefinitionModelRule__TypesAssignment_4_0 ) ) | ( ( rule__DefinitionModelRule__FunctionsAssignment_4_1 ) ) );
    public final void rule__DefinitionModelRule__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1146:1: ( ( ( rule__DefinitionModelRule__TypesAssignment_4_0 ) ) | ( ( rule__DefinitionModelRule__FunctionsAssignment_4_1 ) ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==60||LA1_0==79) ) {
                alt1=1;
            }
            else if ( (LA1_0==75) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalDefinitionLanguage.g:1147:2: ( ( rule__DefinitionModelRule__TypesAssignment_4_0 ) )
                    {
                    // InternalDefinitionLanguage.g:1147:2: ( ( rule__DefinitionModelRule__TypesAssignment_4_0 ) )
                    // InternalDefinitionLanguage.g:1148:3: ( rule__DefinitionModelRule__TypesAssignment_4_0 )
                    {
                     before(grammarAccess.getDefinitionModelRuleAccess().getTypesAssignment_4_0()); 
                    // InternalDefinitionLanguage.g:1149:3: ( rule__DefinitionModelRule__TypesAssignment_4_0 )
                    // InternalDefinitionLanguage.g:1149:4: rule__DefinitionModelRule__TypesAssignment_4_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DefinitionModelRule__TypesAssignment_4_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDefinitionModelRuleAccess().getTypesAssignment_4_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDefinitionLanguage.g:1153:2: ( ( rule__DefinitionModelRule__FunctionsAssignment_4_1 ) )
                    {
                    // InternalDefinitionLanguage.g:1153:2: ( ( rule__DefinitionModelRule__FunctionsAssignment_4_1 ) )
                    // InternalDefinitionLanguage.g:1154:3: ( rule__DefinitionModelRule__FunctionsAssignment_4_1 )
                    {
                     before(grammarAccess.getDefinitionModelRuleAccess().getFunctionsAssignment_4_1()); 
                    // InternalDefinitionLanguage.g:1155:3: ( rule__DefinitionModelRule__FunctionsAssignment_4_1 )
                    // InternalDefinitionLanguage.g:1155:4: rule__DefinitionModelRule__FunctionsAssignment_4_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__DefinitionModelRule__FunctionsAssignment_4_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getDefinitionModelRuleAccess().getFunctionsAssignment_4_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DefinitionModelRule__Alternatives_4"


    // $ANTLR start "rule__LiteralOrReferenceRule__Alternatives"
    // InternalDefinitionLanguage.g:1163:1: rule__LiteralOrReferenceRule__Alternatives : ( ( ruleCallRule ) | ( ruleLiteralRule ) | ( ruleParanthesesRule ) | ( ruleValueReferenceRule ) );
    public final void rule__LiteralOrReferenceRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1167:1: ( ( ruleCallRule ) | ( ruleLiteralRule ) | ( ruleParanthesesRule ) | ( ruleValueReferenceRule ) )
            int alt2=4;
            switch ( input.LA(1) ) {
            case RULE_QUOTED_ID:
            case RULE_ID:
                {
                alt2=1;
                }
                break;
            case RULE_DOUBLE:
            case RULE_INT:
            case RULE_STRING:
            case 15:
            case 78:
                {
                alt2=2;
                }
                break;
            case 56:
                {
                alt2=3;
                }
                break;
            case 59:
                {
                alt2=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalDefinitionLanguage.g:1168:2: ( ruleCallRule )
                    {
                    // InternalDefinitionLanguage.g:1168:2: ( ruleCallRule )
                    // InternalDefinitionLanguage.g:1169:3: ruleCallRule
                    {
                     before(grammarAccess.getLiteralOrReferenceRuleAccess().getCallRuleParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleCallRule();

                    state._fsp--;

                     after(grammarAccess.getLiteralOrReferenceRuleAccess().getCallRuleParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDefinitionLanguage.g:1174:2: ( ruleLiteralRule )
                    {
                    // InternalDefinitionLanguage.g:1174:2: ( ruleLiteralRule )
                    // InternalDefinitionLanguage.g:1175:3: ruleLiteralRule
                    {
                     before(grammarAccess.getLiteralOrReferenceRuleAccess().getLiteralRuleParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleLiteralRule();

                    state._fsp--;

                     after(grammarAccess.getLiteralOrReferenceRuleAccess().getLiteralRuleParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalDefinitionLanguage.g:1180:2: ( ruleParanthesesRule )
                    {
                    // InternalDefinitionLanguage.g:1180:2: ( ruleParanthesesRule )
                    // InternalDefinitionLanguage.g:1181:3: ruleParanthesesRule
                    {
                     before(grammarAccess.getLiteralOrReferenceRuleAccess().getParanthesesRuleParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleParanthesesRule();

                    state._fsp--;

                     after(grammarAccess.getLiteralOrReferenceRuleAccess().getParanthesesRuleParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalDefinitionLanguage.g:1186:2: ( ruleValueReferenceRule )
                    {
                    // InternalDefinitionLanguage.g:1186:2: ( ruleValueReferenceRule )
                    // InternalDefinitionLanguage.g:1187:3: ruleValueReferenceRule
                    {
                     before(grammarAccess.getLiteralOrReferenceRuleAccess().getValueReferenceRuleParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleValueReferenceRule();

                    state._fsp--;

                     after(grammarAccess.getLiteralOrReferenceRuleAccess().getValueReferenceRuleParserRuleCall_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LiteralOrReferenceRule__Alternatives"


    // $ANTLR start "rule__LiteralRule__Alternatives"
    // InternalDefinitionLanguage.g:1196:1: rule__LiteralRule__Alternatives : ( ( ruleNumberLiteralRule ) | ( ruleStringLiteralRule ) | ( ruleBooleanLiteralRule ) );
    public final void rule__LiteralRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1200:1: ( ( ruleNumberLiteralRule ) | ( ruleStringLiteralRule ) | ( ruleBooleanLiteralRule ) )
            int alt3=3;
            switch ( input.LA(1) ) {
            case RULE_DOUBLE:
            case RULE_INT:
                {
                alt3=1;
                }
                break;
            case RULE_STRING:
                {
                alt3=2;
                }
                break;
            case 15:
            case 78:
                {
                alt3=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalDefinitionLanguage.g:1201:2: ( ruleNumberLiteralRule )
                    {
                    // InternalDefinitionLanguage.g:1201:2: ( ruleNumberLiteralRule )
                    // InternalDefinitionLanguage.g:1202:3: ruleNumberLiteralRule
                    {
                     before(grammarAccess.getLiteralRuleAccess().getNumberLiteralRuleParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleNumberLiteralRule();

                    state._fsp--;

                     after(grammarAccess.getLiteralRuleAccess().getNumberLiteralRuleParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDefinitionLanguage.g:1207:2: ( ruleStringLiteralRule )
                    {
                    // InternalDefinitionLanguage.g:1207:2: ( ruleStringLiteralRule )
                    // InternalDefinitionLanguage.g:1208:3: ruleStringLiteralRule
                    {
                     before(grammarAccess.getLiteralRuleAccess().getStringLiteralRuleParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleStringLiteralRule();

                    state._fsp--;

                     after(grammarAccess.getLiteralRuleAccess().getStringLiteralRuleParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalDefinitionLanguage.g:1213:2: ( ruleBooleanLiteralRule )
                    {
                    // InternalDefinitionLanguage.g:1213:2: ( ruleBooleanLiteralRule )
                    // InternalDefinitionLanguage.g:1214:3: ruleBooleanLiteralRule
                    {
                     before(grammarAccess.getLiteralRuleAccess().getBooleanLiteralRuleParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleBooleanLiteralRule();

                    state._fsp--;

                     after(grammarAccess.getLiteralRuleAccess().getBooleanLiteralRuleParserRuleCall_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LiteralRule__Alternatives"


    // $ANTLR start "rule__NumberLiteralRule__Alternatives"
    // InternalDefinitionLanguage.g:1223:1: rule__NumberLiteralRule__Alternatives : ( ( ruleDoubleLiteralRule ) | ( ruleIntegerLiteralRule ) );
    public final void rule__NumberLiteralRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1227:1: ( ( ruleDoubleLiteralRule ) | ( ruleIntegerLiteralRule ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_DOUBLE) ) {
                alt4=1;
            }
            else if ( (LA4_0==RULE_INT) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalDefinitionLanguage.g:1228:2: ( ruleDoubleLiteralRule )
                    {
                    // InternalDefinitionLanguage.g:1228:2: ( ruleDoubleLiteralRule )
                    // InternalDefinitionLanguage.g:1229:3: ruleDoubleLiteralRule
                    {
                     before(grammarAccess.getNumberLiteralRuleAccess().getDoubleLiteralRuleParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleDoubleLiteralRule();

                    state._fsp--;

                     after(grammarAccess.getNumberLiteralRuleAccess().getDoubleLiteralRuleParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDefinitionLanguage.g:1234:2: ( ruleIntegerLiteralRule )
                    {
                    // InternalDefinitionLanguage.g:1234:2: ( ruleIntegerLiteralRule )
                    // InternalDefinitionLanguage.g:1235:3: ruleIntegerLiteralRule
                    {
                     before(grammarAccess.getNumberLiteralRuleAccess().getIntegerLiteralRuleParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleIntegerLiteralRule();

                    state._fsp--;

                     after(grammarAccess.getNumberLiteralRuleAccess().getIntegerLiteralRuleParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumberLiteralRule__Alternatives"


    // $ANTLR start "rule__BooleanLiteralRule__Alternatives_1"
    // InternalDefinitionLanguage.g:1244:1: rule__BooleanLiteralRule__Alternatives_1 : ( ( ( rule__BooleanLiteralRule__ValueAssignment_1_0 ) ) | ( 'false' ) );
    public final void rule__BooleanLiteralRule__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1248:1: ( ( ( rule__BooleanLiteralRule__ValueAssignment_1_0 ) ) | ( 'false' ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==78) ) {
                alt5=1;
            }
            else if ( (LA5_0==15) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalDefinitionLanguage.g:1249:2: ( ( rule__BooleanLiteralRule__ValueAssignment_1_0 ) )
                    {
                    // InternalDefinitionLanguage.g:1249:2: ( ( rule__BooleanLiteralRule__ValueAssignment_1_0 ) )
                    // InternalDefinitionLanguage.g:1250:3: ( rule__BooleanLiteralRule__ValueAssignment_1_0 )
                    {
                     before(grammarAccess.getBooleanLiteralRuleAccess().getValueAssignment_1_0()); 
                    // InternalDefinitionLanguage.g:1251:3: ( rule__BooleanLiteralRule__ValueAssignment_1_0 )
                    // InternalDefinitionLanguage.g:1251:4: rule__BooleanLiteralRule__ValueAssignment_1_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__BooleanLiteralRule__ValueAssignment_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getBooleanLiteralRuleAccess().getValueAssignment_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDefinitionLanguage.g:1255:2: ( 'false' )
                    {
                    // InternalDefinitionLanguage.g:1255:2: ( 'false' )
                    // InternalDefinitionLanguage.g:1256:3: 'false'
                    {
                     before(grammarAccess.getBooleanLiteralRuleAccess().getFalseKeyword_1_1()); 
                    match(input,15,FOLLOW_2); 
                     after(grammarAccess.getBooleanLiteralRuleAccess().getFalseKeyword_1_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanLiteralRule__Alternatives_1"


    // $ANTLR start "rule__TypeRule__Alternatives"
    // InternalDefinitionLanguage.g:1265:1: rule__TypeRule__Alternatives : ( ( ruleStringTypeRule ) | ( ruleIntTypeRule ) | ( ruleFloatTypeRule ) | ( ruleBooleanTypeRule ) | ( ruleLiteralTypeRule ) | ( ruleArrayTypeRule ) | ( ruleInstanceTypeRule ) | ( ruleVoidTypeRule ) | ( ruleExpressionTypeRule ) | ( ruleDataTypeRule ) );
    public final void rule__TypeRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1269:1: ( ( ruleStringTypeRule ) | ( ruleIntTypeRule ) | ( ruleFloatTypeRule ) | ( ruleBooleanTypeRule ) | ( ruleLiteralTypeRule ) | ( ruleArrayTypeRule ) | ( ruleInstanceTypeRule ) | ( ruleVoidTypeRule ) | ( ruleExpressionTypeRule ) | ( ruleDataTypeRule ) )
            int alt6=10;
            switch ( input.LA(1) ) {
            case 67:
                {
                alt6=1;
                }
                break;
            case 69:
                {
                alt6=2;
                }
                break;
            case 70:
                {
                alt6=3;
                }
                break;
            case 71:
                {
                alt6=4;
                }
                break;
            case 64:
                {
                alt6=5;
                }
                break;
            case 74:
                {
                alt6=6;
                }
                break;
            case 65:
                {
                alt6=7;
                }
                break;
            case 72:
                {
                alt6=8;
                }
                break;
            case 68:
                {
                alt6=9;
                }
                break;
            case 73:
                {
                alt6=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalDefinitionLanguage.g:1270:2: ( ruleStringTypeRule )
                    {
                    // InternalDefinitionLanguage.g:1270:2: ( ruleStringTypeRule )
                    // InternalDefinitionLanguage.g:1271:3: ruleStringTypeRule
                    {
                     before(grammarAccess.getTypeRuleAccess().getStringTypeRuleParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleStringTypeRule();

                    state._fsp--;

                     after(grammarAccess.getTypeRuleAccess().getStringTypeRuleParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDefinitionLanguage.g:1276:2: ( ruleIntTypeRule )
                    {
                    // InternalDefinitionLanguage.g:1276:2: ( ruleIntTypeRule )
                    // InternalDefinitionLanguage.g:1277:3: ruleIntTypeRule
                    {
                     before(grammarAccess.getTypeRuleAccess().getIntTypeRuleParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleIntTypeRule();

                    state._fsp--;

                     after(grammarAccess.getTypeRuleAccess().getIntTypeRuleParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalDefinitionLanguage.g:1282:2: ( ruleFloatTypeRule )
                    {
                    // InternalDefinitionLanguage.g:1282:2: ( ruleFloatTypeRule )
                    // InternalDefinitionLanguage.g:1283:3: ruleFloatTypeRule
                    {
                     before(grammarAccess.getTypeRuleAccess().getFloatTypeRuleParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleFloatTypeRule();

                    state._fsp--;

                     after(grammarAccess.getTypeRuleAccess().getFloatTypeRuleParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalDefinitionLanguage.g:1288:2: ( ruleBooleanTypeRule )
                    {
                    // InternalDefinitionLanguage.g:1288:2: ( ruleBooleanTypeRule )
                    // InternalDefinitionLanguage.g:1289:3: ruleBooleanTypeRule
                    {
                     before(grammarAccess.getTypeRuleAccess().getBooleanTypeRuleParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleBooleanTypeRule();

                    state._fsp--;

                     after(grammarAccess.getTypeRuleAccess().getBooleanTypeRuleParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalDefinitionLanguage.g:1294:2: ( ruleLiteralTypeRule )
                    {
                    // InternalDefinitionLanguage.g:1294:2: ( ruleLiteralTypeRule )
                    // InternalDefinitionLanguage.g:1295:3: ruleLiteralTypeRule
                    {
                     before(grammarAccess.getTypeRuleAccess().getLiteralTypeRuleParserRuleCall_4()); 
                    pushFollow(FOLLOW_2);
                    ruleLiteralTypeRule();

                    state._fsp--;

                     after(grammarAccess.getTypeRuleAccess().getLiteralTypeRuleParserRuleCall_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalDefinitionLanguage.g:1300:2: ( ruleArrayTypeRule )
                    {
                    // InternalDefinitionLanguage.g:1300:2: ( ruleArrayTypeRule )
                    // InternalDefinitionLanguage.g:1301:3: ruleArrayTypeRule
                    {
                     before(grammarAccess.getTypeRuleAccess().getArrayTypeRuleParserRuleCall_5()); 
                    pushFollow(FOLLOW_2);
                    ruleArrayTypeRule();

                    state._fsp--;

                     after(grammarAccess.getTypeRuleAccess().getArrayTypeRuleParserRuleCall_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalDefinitionLanguage.g:1306:2: ( ruleInstanceTypeRule )
                    {
                    // InternalDefinitionLanguage.g:1306:2: ( ruleInstanceTypeRule )
                    // InternalDefinitionLanguage.g:1307:3: ruleInstanceTypeRule
                    {
                     before(grammarAccess.getTypeRuleAccess().getInstanceTypeRuleParserRuleCall_6()); 
                    pushFollow(FOLLOW_2);
                    ruleInstanceTypeRule();

                    state._fsp--;

                     after(grammarAccess.getTypeRuleAccess().getInstanceTypeRuleParserRuleCall_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalDefinitionLanguage.g:1312:2: ( ruleVoidTypeRule )
                    {
                    // InternalDefinitionLanguage.g:1312:2: ( ruleVoidTypeRule )
                    // InternalDefinitionLanguage.g:1313:3: ruleVoidTypeRule
                    {
                     before(grammarAccess.getTypeRuleAccess().getVoidTypeRuleParserRuleCall_7()); 
                    pushFollow(FOLLOW_2);
                    ruleVoidTypeRule();

                    state._fsp--;

                     after(grammarAccess.getTypeRuleAccess().getVoidTypeRuleParserRuleCall_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalDefinitionLanguage.g:1318:2: ( ruleExpressionTypeRule )
                    {
                    // InternalDefinitionLanguage.g:1318:2: ( ruleExpressionTypeRule )
                    // InternalDefinitionLanguage.g:1319:3: ruleExpressionTypeRule
                    {
                     before(grammarAccess.getTypeRuleAccess().getExpressionTypeRuleParserRuleCall_8()); 
                    pushFollow(FOLLOW_2);
                    ruleExpressionTypeRule();

                    state._fsp--;

                     after(grammarAccess.getTypeRuleAccess().getExpressionTypeRuleParserRuleCall_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalDefinitionLanguage.g:1324:2: ( ruleDataTypeRule )
                    {
                    // InternalDefinitionLanguage.g:1324:2: ( ruleDataTypeRule )
                    // InternalDefinitionLanguage.g:1325:3: ruleDataTypeRule
                    {
                     before(grammarAccess.getTypeRuleAccess().getDataTypeRuleParserRuleCall_9()); 
                    pushFollow(FOLLOW_2);
                    ruleDataTypeRule();

                    state._fsp--;

                     after(grammarAccess.getTypeRuleAccess().getDataTypeRuleParserRuleCall_9()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeRule__Alternatives"


    // $ANTLR start "rule__StringOrId__Alternatives"
    // InternalDefinitionLanguage.g:1334:1: rule__StringOrId__Alternatives : ( ( RULE_QUOTED_ID ) | ( RULE_ID ) );
    public final void rule__StringOrId__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1338:1: ( ( RULE_QUOTED_ID ) | ( RULE_ID ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_QUOTED_ID) ) {
                alt7=1;
            }
            else if ( (LA7_0==RULE_ID) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalDefinitionLanguage.g:1339:2: ( RULE_QUOTED_ID )
                    {
                    // InternalDefinitionLanguage.g:1339:2: ( RULE_QUOTED_ID )
                    // InternalDefinitionLanguage.g:1340:3: RULE_QUOTED_ID
                    {
                     before(grammarAccess.getStringOrIdAccess().getQUOTED_IDTerminalRuleCall_0()); 
                    match(input,RULE_QUOTED_ID,FOLLOW_2); 
                     after(grammarAccess.getStringOrIdAccess().getQUOTED_IDTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDefinitionLanguage.g:1345:2: ( RULE_ID )
                    {
                    // InternalDefinitionLanguage.g:1345:2: ( RULE_ID )
                    // InternalDefinitionLanguage.g:1346:3: RULE_ID
                    {
                     before(grammarAccess.getStringOrIdAccess().getIDTerminalRuleCall_1()); 
                    match(input,RULE_ID,FOLLOW_2); 
                     after(grammarAccess.getStringOrIdAccess().getIDTerminalRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StringOrId__Alternatives"


    // $ANTLR start "rule__ComparisonOperatorRule__Alternatives"
    // InternalDefinitionLanguage.g:1355:1: rule__ComparisonOperatorRule__Alternatives : ( ( ( '>=' ) ) | ( ( '>' ) ) | ( ( '=' ) ) | ( ( '!=' ) ) | ( ( '<' ) ) | ( ( '<=' ) ) );
    public final void rule__ComparisonOperatorRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1359:1: ( ( ( '>=' ) ) | ( ( '>' ) ) | ( ( '=' ) ) | ( ( '!=' ) ) | ( ( '<' ) ) | ( ( '<=' ) ) )
            int alt8=6;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt8=1;
                }
                break;
            case 17:
                {
                alt8=2;
                }
                break;
            case 18:
                {
                alt8=3;
                }
                break;
            case 19:
                {
                alt8=4;
                }
                break;
            case 20:
                {
                alt8=5;
                }
                break;
            case 21:
                {
                alt8=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalDefinitionLanguage.g:1360:2: ( ( '>=' ) )
                    {
                    // InternalDefinitionLanguage.g:1360:2: ( ( '>=' ) )
                    // InternalDefinitionLanguage.g:1361:3: ( '>=' )
                    {
                     before(grammarAccess.getComparisonOperatorRuleAccess().getGreaterThanEnumLiteralDeclaration_0()); 
                    // InternalDefinitionLanguage.g:1362:3: ( '>=' )
                    // InternalDefinitionLanguage.g:1362:4: '>='
                    {
                    match(input,16,FOLLOW_2); 

                    }

                     after(grammarAccess.getComparisonOperatorRuleAccess().getGreaterThanEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDefinitionLanguage.g:1366:2: ( ( '>' ) )
                    {
                    // InternalDefinitionLanguage.g:1366:2: ( ( '>' ) )
                    // InternalDefinitionLanguage.g:1367:3: ( '>' )
                    {
                     before(grammarAccess.getComparisonOperatorRuleAccess().getGreaterEqualEnumLiteralDeclaration_1()); 
                    // InternalDefinitionLanguage.g:1368:3: ( '>' )
                    // InternalDefinitionLanguage.g:1368:4: '>'
                    {
                    match(input,17,FOLLOW_2); 

                    }

                     after(grammarAccess.getComparisonOperatorRuleAccess().getGreaterEqualEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalDefinitionLanguage.g:1372:2: ( ( '=' ) )
                    {
                    // InternalDefinitionLanguage.g:1372:2: ( ( '=' ) )
                    // InternalDefinitionLanguage.g:1373:3: ( '=' )
                    {
                     before(grammarAccess.getComparisonOperatorRuleAccess().getEqualEnumLiteralDeclaration_2()); 
                    // InternalDefinitionLanguage.g:1374:3: ( '=' )
                    // InternalDefinitionLanguage.g:1374:4: '='
                    {
                    match(input,18,FOLLOW_2); 

                    }

                     after(grammarAccess.getComparisonOperatorRuleAccess().getEqualEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalDefinitionLanguage.g:1378:2: ( ( '!=' ) )
                    {
                    // InternalDefinitionLanguage.g:1378:2: ( ( '!=' ) )
                    // InternalDefinitionLanguage.g:1379:3: ( '!=' )
                    {
                     before(grammarAccess.getComparisonOperatorRuleAccess().getUnequalEnumLiteralDeclaration_3()); 
                    // InternalDefinitionLanguage.g:1380:3: ( '!=' )
                    // InternalDefinitionLanguage.g:1380:4: '!='
                    {
                    match(input,19,FOLLOW_2); 

                    }

                     after(grammarAccess.getComparisonOperatorRuleAccess().getUnequalEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalDefinitionLanguage.g:1384:2: ( ( '<' ) )
                    {
                    // InternalDefinitionLanguage.g:1384:2: ( ( '<' ) )
                    // InternalDefinitionLanguage.g:1385:3: ( '<' )
                    {
                     before(grammarAccess.getComparisonOperatorRuleAccess().getLessEqualEnumLiteralDeclaration_4()); 
                    // InternalDefinitionLanguage.g:1386:3: ( '<' )
                    // InternalDefinitionLanguage.g:1386:4: '<'
                    {
                    match(input,20,FOLLOW_2); 

                    }

                     after(grammarAccess.getComparisonOperatorRuleAccess().getLessEqualEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalDefinitionLanguage.g:1390:2: ( ( '<=' ) )
                    {
                    // InternalDefinitionLanguage.g:1390:2: ( ( '<=' ) )
                    // InternalDefinitionLanguage.g:1391:3: ( '<=' )
                    {
                     before(grammarAccess.getComparisonOperatorRuleAccess().getLessThanEnumLiteralDeclaration_5()); 
                    // InternalDefinitionLanguage.g:1392:3: ( '<=' )
                    // InternalDefinitionLanguage.g:1392:4: '<='
                    {
                    match(input,21,FOLLOW_2); 

                    }

                     after(grammarAccess.getComparisonOperatorRuleAccess().getLessThanEnumLiteralDeclaration_5()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComparisonOperatorRule__Alternatives"


    // $ANTLR start "rule__AddOrSubtractOperatorRule__Alternatives"
    // InternalDefinitionLanguage.g:1400:1: rule__AddOrSubtractOperatorRule__Alternatives : ( ( ( '+' ) ) | ( ( '-' ) ) );
    public final void rule__AddOrSubtractOperatorRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1404:1: ( ( ( '+' ) ) | ( ( '-' ) ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==22) ) {
                alt9=1;
            }
            else if ( (LA9_0==23) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalDefinitionLanguage.g:1405:2: ( ( '+' ) )
                    {
                    // InternalDefinitionLanguage.g:1405:2: ( ( '+' ) )
                    // InternalDefinitionLanguage.g:1406:3: ( '+' )
                    {
                     before(grammarAccess.getAddOrSubtractOperatorRuleAccess().getAddEnumLiteralDeclaration_0()); 
                    // InternalDefinitionLanguage.g:1407:3: ( '+' )
                    // InternalDefinitionLanguage.g:1407:4: '+'
                    {
                    match(input,22,FOLLOW_2); 

                    }

                     after(grammarAccess.getAddOrSubtractOperatorRuleAccess().getAddEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDefinitionLanguage.g:1411:2: ( ( '-' ) )
                    {
                    // InternalDefinitionLanguage.g:1411:2: ( ( '-' ) )
                    // InternalDefinitionLanguage.g:1412:3: ( '-' )
                    {
                     before(grammarAccess.getAddOrSubtractOperatorRuleAccess().getSubtractEnumLiteralDeclaration_1()); 
                    // InternalDefinitionLanguage.g:1413:3: ( '-' )
                    // InternalDefinitionLanguage.g:1413:4: '-'
                    {
                    match(input,23,FOLLOW_2); 

                    }

                     after(grammarAccess.getAddOrSubtractOperatorRuleAccess().getSubtractEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AddOrSubtractOperatorRule__Alternatives"


    // $ANTLR start "rule__MultiplyDivideModuloOperatorRule__Alternatives"
    // InternalDefinitionLanguage.g:1421:1: rule__MultiplyDivideModuloOperatorRule__Alternatives : ( ( ( '*' ) ) | ( ( '/' ) ) | ( ( '%' ) ) );
    public final void rule__MultiplyDivideModuloOperatorRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1425:1: ( ( ( '*' ) ) | ( ( '/' ) ) | ( ( '%' ) ) )
            int alt10=3;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt10=1;
                }
                break;
            case 25:
                {
                alt10=2;
                }
                break;
            case 26:
                {
                alt10=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalDefinitionLanguage.g:1426:2: ( ( '*' ) )
                    {
                    // InternalDefinitionLanguage.g:1426:2: ( ( '*' ) )
                    // InternalDefinitionLanguage.g:1427:3: ( '*' )
                    {
                     before(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getMultiplyEnumLiteralDeclaration_0()); 
                    // InternalDefinitionLanguage.g:1428:3: ( '*' )
                    // InternalDefinitionLanguage.g:1428:4: '*'
                    {
                    match(input,24,FOLLOW_2); 

                    }

                     after(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getMultiplyEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDefinitionLanguage.g:1432:2: ( ( '/' ) )
                    {
                    // InternalDefinitionLanguage.g:1432:2: ( ( '/' ) )
                    // InternalDefinitionLanguage.g:1433:3: ( '/' )
                    {
                     before(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getDivideEnumLiteralDeclaration_1()); 
                    // InternalDefinitionLanguage.g:1434:3: ( '/' )
                    // InternalDefinitionLanguage.g:1434:4: '/'
                    {
                    match(input,25,FOLLOW_2); 

                    }

                     after(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getDivideEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalDefinitionLanguage.g:1438:2: ( ( '%' ) )
                    {
                    // InternalDefinitionLanguage.g:1438:2: ( ( '%' ) )
                    // InternalDefinitionLanguage.g:1439:3: ( '%' )
                    {
                     before(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getModuloEnumLiteralDeclaration_2()); 
                    // InternalDefinitionLanguage.g:1440:3: ( '%' )
                    // InternalDefinitionLanguage.g:1440:4: '%'
                    {
                    match(input,26,FOLLOW_2); 

                    }

                     after(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getModuloEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplyDivideModuloOperatorRule__Alternatives"


    // $ANTLR start "rule__FactorRule__Alternatives"
    // InternalDefinitionLanguage.g:1448:1: rule__FactorRule__Alternatives : ( ( ( 'Y' ) ) | ( ( 'Z' ) ) | ( ( 'E' ) ) | ( ( 'P' ) ) | ( ( 'T' ) ) | ( ( 'G' ) ) | ( ( 'M' ) ) | ( ( 'k' ) ) | ( ( 'h' ) ) | ( ( 'da' ) ) | ( ( 'd' ) ) | ( ( 'c' ) ) | ( ( 'm' ) ) | ( ( '\\u00B5' ) ) | ( ( 'n' ) ) | ( ( 'p' ) ) | ( ( 'f' ) ) | ( ( 'a' ) ) | ( ( 'z' ) ) | ( ( 'y' ) ) );
    public final void rule__FactorRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1452:1: ( ( ( 'Y' ) ) | ( ( 'Z' ) ) | ( ( 'E' ) ) | ( ( 'P' ) ) | ( ( 'T' ) ) | ( ( 'G' ) ) | ( ( 'M' ) ) | ( ( 'k' ) ) | ( ( 'h' ) ) | ( ( 'da' ) ) | ( ( 'd' ) ) | ( ( 'c' ) ) | ( ( 'm' ) ) | ( ( '\\u00B5' ) ) | ( ( 'n' ) ) | ( ( 'p' ) ) | ( ( 'f' ) ) | ( ( 'a' ) ) | ( ( 'z' ) ) | ( ( 'y' ) ) )
            int alt11=20;
            switch ( input.LA(1) ) {
            case 27:
                {
                alt11=1;
                }
                break;
            case 28:
                {
                alt11=2;
                }
                break;
            case 29:
                {
                alt11=3;
                }
                break;
            case 30:
                {
                alt11=4;
                }
                break;
            case 31:
                {
                alt11=5;
                }
                break;
            case 32:
                {
                alt11=6;
                }
                break;
            case 33:
                {
                alt11=7;
                }
                break;
            case 34:
                {
                alt11=8;
                }
                break;
            case 35:
                {
                alt11=9;
                }
                break;
            case 36:
                {
                alt11=10;
                }
                break;
            case 37:
                {
                alt11=11;
                }
                break;
            case 38:
                {
                alt11=12;
                }
                break;
            case 39:
                {
                alt11=13;
                }
                break;
            case 40:
                {
                alt11=14;
                }
                break;
            case 41:
                {
                alt11=15;
                }
                break;
            case 42:
                {
                alt11=16;
                }
                break;
            case 43:
                {
                alt11=17;
                }
                break;
            case 44:
                {
                alt11=18;
                }
                break;
            case 45:
                {
                alt11=19;
                }
                break;
            case 46:
                {
                alt11=20;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // InternalDefinitionLanguage.g:1453:2: ( ( 'Y' ) )
                    {
                    // InternalDefinitionLanguage.g:1453:2: ( ( 'Y' ) )
                    // InternalDefinitionLanguage.g:1454:3: ( 'Y' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getYottaEnumLiteralDeclaration_0()); 
                    // InternalDefinitionLanguage.g:1455:3: ( 'Y' )
                    // InternalDefinitionLanguage.g:1455:4: 'Y'
                    {
                    match(input,27,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getYottaEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDefinitionLanguage.g:1459:2: ( ( 'Z' ) )
                    {
                    // InternalDefinitionLanguage.g:1459:2: ( ( 'Z' ) )
                    // InternalDefinitionLanguage.g:1460:3: ( 'Z' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getZettaEnumLiteralDeclaration_1()); 
                    // InternalDefinitionLanguage.g:1461:3: ( 'Z' )
                    // InternalDefinitionLanguage.g:1461:4: 'Z'
                    {
                    match(input,28,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getZettaEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalDefinitionLanguage.g:1465:2: ( ( 'E' ) )
                    {
                    // InternalDefinitionLanguage.g:1465:2: ( ( 'E' ) )
                    // InternalDefinitionLanguage.g:1466:3: ( 'E' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getExaEnumLiteralDeclaration_2()); 
                    // InternalDefinitionLanguage.g:1467:3: ( 'E' )
                    // InternalDefinitionLanguage.g:1467:4: 'E'
                    {
                    match(input,29,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getExaEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalDefinitionLanguage.g:1471:2: ( ( 'P' ) )
                    {
                    // InternalDefinitionLanguage.g:1471:2: ( ( 'P' ) )
                    // InternalDefinitionLanguage.g:1472:3: ( 'P' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getPetaEnumLiteralDeclaration_3()); 
                    // InternalDefinitionLanguage.g:1473:3: ( 'P' )
                    // InternalDefinitionLanguage.g:1473:4: 'P'
                    {
                    match(input,30,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getPetaEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalDefinitionLanguage.g:1477:2: ( ( 'T' ) )
                    {
                    // InternalDefinitionLanguage.g:1477:2: ( ( 'T' ) )
                    // InternalDefinitionLanguage.g:1478:3: ( 'T' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getTeraEnumLiteralDeclaration_4()); 
                    // InternalDefinitionLanguage.g:1479:3: ( 'T' )
                    // InternalDefinitionLanguage.g:1479:4: 'T'
                    {
                    match(input,31,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getTeraEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalDefinitionLanguage.g:1483:2: ( ( 'G' ) )
                    {
                    // InternalDefinitionLanguage.g:1483:2: ( ( 'G' ) )
                    // InternalDefinitionLanguage.g:1484:3: ( 'G' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getGigaEnumLiteralDeclaration_5()); 
                    // InternalDefinitionLanguage.g:1485:3: ( 'G' )
                    // InternalDefinitionLanguage.g:1485:4: 'G'
                    {
                    match(input,32,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getGigaEnumLiteralDeclaration_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalDefinitionLanguage.g:1489:2: ( ( 'M' ) )
                    {
                    // InternalDefinitionLanguage.g:1489:2: ( ( 'M' ) )
                    // InternalDefinitionLanguage.g:1490:3: ( 'M' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getMegaEnumLiteralDeclaration_6()); 
                    // InternalDefinitionLanguage.g:1491:3: ( 'M' )
                    // InternalDefinitionLanguage.g:1491:4: 'M'
                    {
                    match(input,33,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getMegaEnumLiteralDeclaration_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalDefinitionLanguage.g:1495:2: ( ( 'k' ) )
                    {
                    // InternalDefinitionLanguage.g:1495:2: ( ( 'k' ) )
                    // InternalDefinitionLanguage.g:1496:3: ( 'k' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getKiloEnumLiteralDeclaration_7()); 
                    // InternalDefinitionLanguage.g:1497:3: ( 'k' )
                    // InternalDefinitionLanguage.g:1497:4: 'k'
                    {
                    match(input,34,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getKiloEnumLiteralDeclaration_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalDefinitionLanguage.g:1501:2: ( ( 'h' ) )
                    {
                    // InternalDefinitionLanguage.g:1501:2: ( ( 'h' ) )
                    // InternalDefinitionLanguage.g:1502:3: ( 'h' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getHectoEnumLiteralDeclaration_8()); 
                    // InternalDefinitionLanguage.g:1503:3: ( 'h' )
                    // InternalDefinitionLanguage.g:1503:4: 'h'
                    {
                    match(input,35,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getHectoEnumLiteralDeclaration_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalDefinitionLanguage.g:1507:2: ( ( 'da' ) )
                    {
                    // InternalDefinitionLanguage.g:1507:2: ( ( 'da' ) )
                    // InternalDefinitionLanguage.g:1508:3: ( 'da' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getDekaEnumLiteralDeclaration_9()); 
                    // InternalDefinitionLanguage.g:1509:3: ( 'da' )
                    // InternalDefinitionLanguage.g:1509:4: 'da'
                    {
                    match(input,36,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getDekaEnumLiteralDeclaration_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalDefinitionLanguage.g:1513:2: ( ( 'd' ) )
                    {
                    // InternalDefinitionLanguage.g:1513:2: ( ( 'd' ) )
                    // InternalDefinitionLanguage.g:1514:3: ( 'd' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getDeciEnumLiteralDeclaration_10()); 
                    // InternalDefinitionLanguage.g:1515:3: ( 'd' )
                    // InternalDefinitionLanguage.g:1515:4: 'd'
                    {
                    match(input,37,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getDeciEnumLiteralDeclaration_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalDefinitionLanguage.g:1519:2: ( ( 'c' ) )
                    {
                    // InternalDefinitionLanguage.g:1519:2: ( ( 'c' ) )
                    // InternalDefinitionLanguage.g:1520:3: ( 'c' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getCentiEnumLiteralDeclaration_11()); 
                    // InternalDefinitionLanguage.g:1521:3: ( 'c' )
                    // InternalDefinitionLanguage.g:1521:4: 'c'
                    {
                    match(input,38,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getCentiEnumLiteralDeclaration_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalDefinitionLanguage.g:1525:2: ( ( 'm' ) )
                    {
                    // InternalDefinitionLanguage.g:1525:2: ( ( 'm' ) )
                    // InternalDefinitionLanguage.g:1526:3: ( 'm' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getMilliEnumLiteralDeclaration_12()); 
                    // InternalDefinitionLanguage.g:1527:3: ( 'm' )
                    // InternalDefinitionLanguage.g:1527:4: 'm'
                    {
                    match(input,39,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getMilliEnumLiteralDeclaration_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalDefinitionLanguage.g:1531:2: ( ( '\\u00B5' ) )
                    {
                    // InternalDefinitionLanguage.g:1531:2: ( ( '\\u00B5' ) )
                    // InternalDefinitionLanguage.g:1532:3: ( '\\u00B5' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getMicroEnumLiteralDeclaration_13()); 
                    // InternalDefinitionLanguage.g:1533:3: ( '\\u00B5' )
                    // InternalDefinitionLanguage.g:1533:4: '\\u00B5'
                    {
                    match(input,40,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getMicroEnumLiteralDeclaration_13()); 

                    }


                    }
                    break;
                case 15 :
                    // InternalDefinitionLanguage.g:1537:2: ( ( 'n' ) )
                    {
                    // InternalDefinitionLanguage.g:1537:2: ( ( 'n' ) )
                    // InternalDefinitionLanguage.g:1538:3: ( 'n' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getNanoEnumLiteralDeclaration_14()); 
                    // InternalDefinitionLanguage.g:1539:3: ( 'n' )
                    // InternalDefinitionLanguage.g:1539:4: 'n'
                    {
                    match(input,41,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getNanoEnumLiteralDeclaration_14()); 

                    }


                    }
                    break;
                case 16 :
                    // InternalDefinitionLanguage.g:1543:2: ( ( 'p' ) )
                    {
                    // InternalDefinitionLanguage.g:1543:2: ( ( 'p' ) )
                    // InternalDefinitionLanguage.g:1544:3: ( 'p' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getPikoEnumLiteralDeclaration_15()); 
                    // InternalDefinitionLanguage.g:1545:3: ( 'p' )
                    // InternalDefinitionLanguage.g:1545:4: 'p'
                    {
                    match(input,42,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getPikoEnumLiteralDeclaration_15()); 

                    }


                    }
                    break;
                case 17 :
                    // InternalDefinitionLanguage.g:1549:2: ( ( 'f' ) )
                    {
                    // InternalDefinitionLanguage.g:1549:2: ( ( 'f' ) )
                    // InternalDefinitionLanguage.g:1550:3: ( 'f' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getFemtoEnumLiteralDeclaration_16()); 
                    // InternalDefinitionLanguage.g:1551:3: ( 'f' )
                    // InternalDefinitionLanguage.g:1551:4: 'f'
                    {
                    match(input,43,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getFemtoEnumLiteralDeclaration_16()); 

                    }


                    }
                    break;
                case 18 :
                    // InternalDefinitionLanguage.g:1555:2: ( ( 'a' ) )
                    {
                    // InternalDefinitionLanguage.g:1555:2: ( ( 'a' ) )
                    // InternalDefinitionLanguage.g:1556:3: ( 'a' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getAttoEnumLiteralDeclaration_17()); 
                    // InternalDefinitionLanguage.g:1557:3: ( 'a' )
                    // InternalDefinitionLanguage.g:1557:4: 'a'
                    {
                    match(input,44,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getAttoEnumLiteralDeclaration_17()); 

                    }


                    }
                    break;
                case 19 :
                    // InternalDefinitionLanguage.g:1561:2: ( ( 'z' ) )
                    {
                    // InternalDefinitionLanguage.g:1561:2: ( ( 'z' ) )
                    // InternalDefinitionLanguage.g:1562:3: ( 'z' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getZeptoEnumLiteralDeclaration_18()); 
                    // InternalDefinitionLanguage.g:1563:3: ( 'z' )
                    // InternalDefinitionLanguage.g:1563:4: 'z'
                    {
                    match(input,45,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getZeptoEnumLiteralDeclaration_18()); 

                    }


                    }
                    break;
                case 20 :
                    // InternalDefinitionLanguage.g:1567:2: ( ( 'y' ) )
                    {
                    // InternalDefinitionLanguage.g:1567:2: ( ( 'y' ) )
                    // InternalDefinitionLanguage.g:1568:3: ( 'y' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getYoctoEnumLiteralDeclaration_19()); 
                    // InternalDefinitionLanguage.g:1569:3: ( 'y' )
                    // InternalDefinitionLanguage.g:1569:4: 'y'
                    {
                    match(input,46,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getYoctoEnumLiteralDeclaration_19()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FactorRule__Alternatives"


    // $ANTLR start "rule__DefinitionModelRule__Group__0"
    // InternalDefinitionLanguage.g:1577:1: rule__DefinitionModelRule__Group__0 : rule__DefinitionModelRule__Group__0__Impl rule__DefinitionModelRule__Group__1 ;
    public final void rule__DefinitionModelRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1581:1: ( rule__DefinitionModelRule__Group__0__Impl rule__DefinitionModelRule__Group__1 )
            // InternalDefinitionLanguage.g:1582:2: rule__DefinitionModelRule__Group__0__Impl rule__DefinitionModelRule__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__DefinitionModelRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DefinitionModelRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DefinitionModelRule__Group__0"


    // $ANTLR start "rule__DefinitionModelRule__Group__0__Impl"
    // InternalDefinitionLanguage.g:1589:1: rule__DefinitionModelRule__Group__0__Impl : ( ( rule__DefinitionModelRule__ImportsAssignment_0 )* ) ;
    public final void rule__DefinitionModelRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1593:1: ( ( ( rule__DefinitionModelRule__ImportsAssignment_0 )* ) )
            // InternalDefinitionLanguage.g:1594:1: ( ( rule__DefinitionModelRule__ImportsAssignment_0 )* )
            {
            // InternalDefinitionLanguage.g:1594:1: ( ( rule__DefinitionModelRule__ImportsAssignment_0 )* )
            // InternalDefinitionLanguage.g:1595:2: ( rule__DefinitionModelRule__ImportsAssignment_0 )*
            {
             before(grammarAccess.getDefinitionModelRuleAccess().getImportsAssignment_0()); 
            // InternalDefinitionLanguage.g:1596:2: ( rule__DefinitionModelRule__ImportsAssignment_0 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==50) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:1596:3: rule__DefinitionModelRule__ImportsAssignment_0
            	    {
            	    pushFollow(FOLLOW_4);
            	    rule__DefinitionModelRule__ImportsAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

             after(grammarAccess.getDefinitionModelRuleAccess().getImportsAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DefinitionModelRule__Group__0__Impl"


    // $ANTLR start "rule__DefinitionModelRule__Group__1"
    // InternalDefinitionLanguage.g:1604:1: rule__DefinitionModelRule__Group__1 : rule__DefinitionModelRule__Group__1__Impl rule__DefinitionModelRule__Group__2 ;
    public final void rule__DefinitionModelRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1608:1: ( rule__DefinitionModelRule__Group__1__Impl rule__DefinitionModelRule__Group__2 )
            // InternalDefinitionLanguage.g:1609:2: rule__DefinitionModelRule__Group__1__Impl rule__DefinitionModelRule__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__DefinitionModelRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DefinitionModelRule__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DefinitionModelRule__Group__1"


    // $ANTLR start "rule__DefinitionModelRule__Group__1__Impl"
    // InternalDefinitionLanguage.g:1616:1: rule__DefinitionModelRule__Group__1__Impl : ( 'module' ) ;
    public final void rule__DefinitionModelRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1620:1: ( ( 'module' ) )
            // InternalDefinitionLanguage.g:1621:1: ( 'module' )
            {
            // InternalDefinitionLanguage.g:1621:1: ( 'module' )
            // InternalDefinitionLanguage.g:1622:2: 'module'
            {
             before(grammarAccess.getDefinitionModelRuleAccess().getModuleKeyword_1()); 
            match(input,47,FOLLOW_2); 
             after(grammarAccess.getDefinitionModelRuleAccess().getModuleKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DefinitionModelRule__Group__1__Impl"


    // $ANTLR start "rule__DefinitionModelRule__Group__2"
    // InternalDefinitionLanguage.g:1631:1: rule__DefinitionModelRule__Group__2 : rule__DefinitionModelRule__Group__2__Impl rule__DefinitionModelRule__Group__3 ;
    public final void rule__DefinitionModelRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1635:1: ( rule__DefinitionModelRule__Group__2__Impl rule__DefinitionModelRule__Group__3 )
            // InternalDefinitionLanguage.g:1636:2: rule__DefinitionModelRule__Group__2__Impl rule__DefinitionModelRule__Group__3
            {
            pushFollow(FOLLOW_6);
            rule__DefinitionModelRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DefinitionModelRule__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DefinitionModelRule__Group__2"


    // $ANTLR start "rule__DefinitionModelRule__Group__2__Impl"
    // InternalDefinitionLanguage.g:1643:1: rule__DefinitionModelRule__Group__2__Impl : ( ( rule__DefinitionModelRule__NameAssignment_2 ) ) ;
    public final void rule__DefinitionModelRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1647:1: ( ( ( rule__DefinitionModelRule__NameAssignment_2 ) ) )
            // InternalDefinitionLanguage.g:1648:1: ( ( rule__DefinitionModelRule__NameAssignment_2 ) )
            {
            // InternalDefinitionLanguage.g:1648:1: ( ( rule__DefinitionModelRule__NameAssignment_2 ) )
            // InternalDefinitionLanguage.g:1649:2: ( rule__DefinitionModelRule__NameAssignment_2 )
            {
             before(grammarAccess.getDefinitionModelRuleAccess().getNameAssignment_2()); 
            // InternalDefinitionLanguage.g:1650:2: ( rule__DefinitionModelRule__NameAssignment_2 )
            // InternalDefinitionLanguage.g:1650:3: rule__DefinitionModelRule__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__DefinitionModelRule__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getDefinitionModelRuleAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DefinitionModelRule__Group__2__Impl"


    // $ANTLR start "rule__DefinitionModelRule__Group__3"
    // InternalDefinitionLanguage.g:1658:1: rule__DefinitionModelRule__Group__3 : rule__DefinitionModelRule__Group__3__Impl rule__DefinitionModelRule__Group__4 ;
    public final void rule__DefinitionModelRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1662:1: ( rule__DefinitionModelRule__Group__3__Impl rule__DefinitionModelRule__Group__4 )
            // InternalDefinitionLanguage.g:1663:2: rule__DefinitionModelRule__Group__3__Impl rule__DefinitionModelRule__Group__4
            {
            pushFollow(FOLLOW_7);
            rule__DefinitionModelRule__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DefinitionModelRule__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DefinitionModelRule__Group__3"


    // $ANTLR start "rule__DefinitionModelRule__Group__3__Impl"
    // InternalDefinitionLanguage.g:1670:1: rule__DefinitionModelRule__Group__3__Impl : ( '{' ) ;
    public final void rule__DefinitionModelRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1674:1: ( ( '{' ) )
            // InternalDefinitionLanguage.g:1675:1: ( '{' )
            {
            // InternalDefinitionLanguage.g:1675:1: ( '{' )
            // InternalDefinitionLanguage.g:1676:2: '{'
            {
             before(grammarAccess.getDefinitionModelRuleAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,48,FOLLOW_2); 
             after(grammarAccess.getDefinitionModelRuleAccess().getLeftCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DefinitionModelRule__Group__3__Impl"


    // $ANTLR start "rule__DefinitionModelRule__Group__4"
    // InternalDefinitionLanguage.g:1685:1: rule__DefinitionModelRule__Group__4 : rule__DefinitionModelRule__Group__4__Impl rule__DefinitionModelRule__Group__5 ;
    public final void rule__DefinitionModelRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1689:1: ( rule__DefinitionModelRule__Group__4__Impl rule__DefinitionModelRule__Group__5 )
            // InternalDefinitionLanguage.g:1690:2: rule__DefinitionModelRule__Group__4__Impl rule__DefinitionModelRule__Group__5
            {
            pushFollow(FOLLOW_7);
            rule__DefinitionModelRule__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DefinitionModelRule__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DefinitionModelRule__Group__4"


    // $ANTLR start "rule__DefinitionModelRule__Group__4__Impl"
    // InternalDefinitionLanguage.g:1697:1: rule__DefinitionModelRule__Group__4__Impl : ( ( rule__DefinitionModelRule__Alternatives_4 )* ) ;
    public final void rule__DefinitionModelRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1701:1: ( ( ( rule__DefinitionModelRule__Alternatives_4 )* ) )
            // InternalDefinitionLanguage.g:1702:1: ( ( rule__DefinitionModelRule__Alternatives_4 )* )
            {
            // InternalDefinitionLanguage.g:1702:1: ( ( rule__DefinitionModelRule__Alternatives_4 )* )
            // InternalDefinitionLanguage.g:1703:2: ( rule__DefinitionModelRule__Alternatives_4 )*
            {
             before(grammarAccess.getDefinitionModelRuleAccess().getAlternatives_4()); 
            // InternalDefinitionLanguage.g:1704:2: ( rule__DefinitionModelRule__Alternatives_4 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==60||LA13_0==75||LA13_0==79) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:1704:3: rule__DefinitionModelRule__Alternatives_4
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__DefinitionModelRule__Alternatives_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

             after(grammarAccess.getDefinitionModelRuleAccess().getAlternatives_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DefinitionModelRule__Group__4__Impl"


    // $ANTLR start "rule__DefinitionModelRule__Group__5"
    // InternalDefinitionLanguage.g:1712:1: rule__DefinitionModelRule__Group__5 : rule__DefinitionModelRule__Group__5__Impl ;
    public final void rule__DefinitionModelRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1716:1: ( rule__DefinitionModelRule__Group__5__Impl )
            // InternalDefinitionLanguage.g:1717:2: rule__DefinitionModelRule__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DefinitionModelRule__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DefinitionModelRule__Group__5"


    // $ANTLR start "rule__DefinitionModelRule__Group__5__Impl"
    // InternalDefinitionLanguage.g:1723:1: rule__DefinitionModelRule__Group__5__Impl : ( '}' ) ;
    public final void rule__DefinitionModelRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1727:1: ( ( '}' ) )
            // InternalDefinitionLanguage.g:1728:1: ( '}' )
            {
            // InternalDefinitionLanguage.g:1728:1: ( '}' )
            // InternalDefinitionLanguage.g:1729:2: '}'
            {
             before(grammarAccess.getDefinitionModelRuleAccess().getRightCurlyBracketKeyword_5()); 
            match(input,49,FOLLOW_2); 
             after(grammarAccess.getDefinitionModelRuleAccess().getRightCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DefinitionModelRule__Group__5__Impl"


    // $ANTLR start "rule__ImportRule__Group__0"
    // InternalDefinitionLanguage.g:1739:1: rule__ImportRule__Group__0 : rule__ImportRule__Group__0__Impl rule__ImportRule__Group__1 ;
    public final void rule__ImportRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1743:1: ( rule__ImportRule__Group__0__Impl rule__ImportRule__Group__1 )
            // InternalDefinitionLanguage.g:1744:2: rule__ImportRule__Group__0__Impl rule__ImportRule__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__ImportRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ImportRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportRule__Group__0"


    // $ANTLR start "rule__ImportRule__Group__0__Impl"
    // InternalDefinitionLanguage.g:1751:1: rule__ImportRule__Group__0__Impl : ( 'import' ) ;
    public final void rule__ImportRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1755:1: ( ( 'import' ) )
            // InternalDefinitionLanguage.g:1756:1: ( 'import' )
            {
            // InternalDefinitionLanguage.g:1756:1: ( 'import' )
            // InternalDefinitionLanguage.g:1757:2: 'import'
            {
             before(grammarAccess.getImportRuleAccess().getImportKeyword_0()); 
            match(input,50,FOLLOW_2); 
             after(grammarAccess.getImportRuleAccess().getImportKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportRule__Group__0__Impl"


    // $ANTLR start "rule__ImportRule__Group__1"
    // InternalDefinitionLanguage.g:1766:1: rule__ImportRule__Group__1 : rule__ImportRule__Group__1__Impl rule__ImportRule__Group__2 ;
    public final void rule__ImportRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1770:1: ( rule__ImportRule__Group__1__Impl rule__ImportRule__Group__2 )
            // InternalDefinitionLanguage.g:1771:2: rule__ImportRule__Group__1__Impl rule__ImportRule__Group__2
            {
            pushFollow(FOLLOW_9);
            rule__ImportRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ImportRule__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportRule__Group__1"


    // $ANTLR start "rule__ImportRule__Group__1__Impl"
    // InternalDefinitionLanguage.g:1778:1: rule__ImportRule__Group__1__Impl : ( ( rule__ImportRule__ImportedNamespaceAssignment_1 ) ) ;
    public final void rule__ImportRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1782:1: ( ( ( rule__ImportRule__ImportedNamespaceAssignment_1 ) ) )
            // InternalDefinitionLanguage.g:1783:1: ( ( rule__ImportRule__ImportedNamespaceAssignment_1 ) )
            {
            // InternalDefinitionLanguage.g:1783:1: ( ( rule__ImportRule__ImportedNamespaceAssignment_1 ) )
            // InternalDefinitionLanguage.g:1784:2: ( rule__ImportRule__ImportedNamespaceAssignment_1 )
            {
             before(grammarAccess.getImportRuleAccess().getImportedNamespaceAssignment_1()); 
            // InternalDefinitionLanguage.g:1785:2: ( rule__ImportRule__ImportedNamespaceAssignment_1 )
            // InternalDefinitionLanguage.g:1785:3: rule__ImportRule__ImportedNamespaceAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__ImportRule__ImportedNamespaceAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getImportRuleAccess().getImportedNamespaceAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportRule__Group__1__Impl"


    // $ANTLR start "rule__ImportRule__Group__2"
    // InternalDefinitionLanguage.g:1793:1: rule__ImportRule__Group__2 : rule__ImportRule__Group__2__Impl ;
    public final void rule__ImportRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1797:1: ( rule__ImportRule__Group__2__Impl )
            // InternalDefinitionLanguage.g:1798:2: rule__ImportRule__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ImportRule__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportRule__Group__2"


    // $ANTLR start "rule__ImportRule__Group__2__Impl"
    // InternalDefinitionLanguage.g:1804:1: rule__ImportRule__Group__2__Impl : ( ';' ) ;
    public final void rule__ImportRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1808:1: ( ( ';' ) )
            // InternalDefinitionLanguage.g:1809:1: ( ';' )
            {
            // InternalDefinitionLanguage.g:1809:1: ( ';' )
            // InternalDefinitionLanguage.g:1810:2: ';'
            {
             before(grammarAccess.getImportRuleAccess().getSemicolonKeyword_2()); 
            match(input,51,FOLLOW_2); 
             after(grammarAccess.getImportRuleAccess().getSemicolonKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportRule__Group__2__Impl"


    // $ANTLR start "rule__OrExpressionRule__Group__0"
    // InternalDefinitionLanguage.g:1820:1: rule__OrExpressionRule__Group__0 : rule__OrExpressionRule__Group__0__Impl rule__OrExpressionRule__Group__1 ;
    public final void rule__OrExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1824:1: ( rule__OrExpressionRule__Group__0__Impl rule__OrExpressionRule__Group__1 )
            // InternalDefinitionLanguage.g:1825:2: rule__OrExpressionRule__Group__0__Impl rule__OrExpressionRule__Group__1
            {
            pushFollow(FOLLOW_10);
            rule__OrExpressionRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OrExpressionRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpressionRule__Group__0"


    // $ANTLR start "rule__OrExpressionRule__Group__0__Impl"
    // InternalDefinitionLanguage.g:1832:1: rule__OrExpressionRule__Group__0__Impl : ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) ) ;
    public final void rule__OrExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1836:1: ( ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:1837:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:1837:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) )
            // InternalDefinitionLanguage.g:1838:2: ( rule__OrExpressionRule__SubExpressionsAssignment_0 )
            {
             before(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsAssignment_0()); 
            // InternalDefinitionLanguage.g:1839:2: ( rule__OrExpressionRule__SubExpressionsAssignment_0 )
            // InternalDefinitionLanguage.g:1839:3: rule__OrExpressionRule__SubExpressionsAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__OrExpressionRule__SubExpressionsAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpressionRule__Group__0__Impl"


    // $ANTLR start "rule__OrExpressionRule__Group__1"
    // InternalDefinitionLanguage.g:1847:1: rule__OrExpressionRule__Group__1 : rule__OrExpressionRule__Group__1__Impl ;
    public final void rule__OrExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1851:1: ( rule__OrExpressionRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:1852:2: rule__OrExpressionRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OrExpressionRule__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpressionRule__Group__1"


    // $ANTLR start "rule__OrExpressionRule__Group__1__Impl"
    // InternalDefinitionLanguage.g:1858:1: rule__OrExpressionRule__Group__1__Impl : ( ( rule__OrExpressionRule__Group_1__0 )* ) ;
    public final void rule__OrExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1862:1: ( ( ( rule__OrExpressionRule__Group_1__0 )* ) )
            // InternalDefinitionLanguage.g:1863:1: ( ( rule__OrExpressionRule__Group_1__0 )* )
            {
            // InternalDefinitionLanguage.g:1863:1: ( ( rule__OrExpressionRule__Group_1__0 )* )
            // InternalDefinitionLanguage.g:1864:2: ( rule__OrExpressionRule__Group_1__0 )*
            {
             before(grammarAccess.getOrExpressionRuleAccess().getGroup_1()); 
            // InternalDefinitionLanguage.g:1865:2: ( rule__OrExpressionRule__Group_1__0 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==52) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:1865:3: rule__OrExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__OrExpressionRule__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

             after(grammarAccess.getOrExpressionRuleAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpressionRule__Group__1__Impl"


    // $ANTLR start "rule__OrExpressionRule__Group_1__0"
    // InternalDefinitionLanguage.g:1874:1: rule__OrExpressionRule__Group_1__0 : rule__OrExpressionRule__Group_1__0__Impl rule__OrExpressionRule__Group_1__1 ;
    public final void rule__OrExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1878:1: ( rule__OrExpressionRule__Group_1__0__Impl rule__OrExpressionRule__Group_1__1 )
            // InternalDefinitionLanguage.g:1879:2: rule__OrExpressionRule__Group_1__0__Impl rule__OrExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_12);
            rule__OrExpressionRule__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OrExpressionRule__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpressionRule__Group_1__0"


    // $ANTLR start "rule__OrExpressionRule__Group_1__0__Impl"
    // InternalDefinitionLanguage.g:1886:1: rule__OrExpressionRule__Group_1__0__Impl : ( 'OR' ) ;
    public final void rule__OrExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1890:1: ( ( 'OR' ) )
            // InternalDefinitionLanguage.g:1891:1: ( 'OR' )
            {
            // InternalDefinitionLanguage.g:1891:1: ( 'OR' )
            // InternalDefinitionLanguage.g:1892:2: 'OR'
            {
             before(grammarAccess.getOrExpressionRuleAccess().getORKeyword_1_0()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getOrExpressionRuleAccess().getORKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpressionRule__Group_1__0__Impl"


    // $ANTLR start "rule__OrExpressionRule__Group_1__1"
    // InternalDefinitionLanguage.g:1901:1: rule__OrExpressionRule__Group_1__1 : rule__OrExpressionRule__Group_1__1__Impl ;
    public final void rule__OrExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1905:1: ( rule__OrExpressionRule__Group_1__1__Impl )
            // InternalDefinitionLanguage.g:1906:2: rule__OrExpressionRule__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OrExpressionRule__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpressionRule__Group_1__1"


    // $ANTLR start "rule__OrExpressionRule__Group_1__1__Impl"
    // InternalDefinitionLanguage.g:1912:1: rule__OrExpressionRule__Group_1__1__Impl : ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) ) ;
    public final void rule__OrExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1916:1: ( ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) ) )
            // InternalDefinitionLanguage.g:1917:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) )
            {
            // InternalDefinitionLanguage.g:1917:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) )
            // InternalDefinitionLanguage.g:1918:2: ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 )
            {
             before(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsAssignment_1_1()); 
            // InternalDefinitionLanguage.g:1919:2: ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 )
            // InternalDefinitionLanguage.g:1919:3: rule__OrExpressionRule__SubExpressionsAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__OrExpressionRule__SubExpressionsAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpressionRule__Group_1__1__Impl"


    // $ANTLR start "rule__XorExpressionRule__Group__0"
    // InternalDefinitionLanguage.g:1928:1: rule__XorExpressionRule__Group__0 : rule__XorExpressionRule__Group__0__Impl rule__XorExpressionRule__Group__1 ;
    public final void rule__XorExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1932:1: ( rule__XorExpressionRule__Group__0__Impl rule__XorExpressionRule__Group__1 )
            // InternalDefinitionLanguage.g:1933:2: rule__XorExpressionRule__Group__0__Impl rule__XorExpressionRule__Group__1
            {
            pushFollow(FOLLOW_13);
            rule__XorExpressionRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XorExpressionRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XorExpressionRule__Group__0"


    // $ANTLR start "rule__XorExpressionRule__Group__0__Impl"
    // InternalDefinitionLanguage.g:1940:1: rule__XorExpressionRule__Group__0__Impl : ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) ) ;
    public final void rule__XorExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1944:1: ( ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:1945:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:1945:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) )
            // InternalDefinitionLanguage.g:1946:2: ( rule__XorExpressionRule__SubExpressionsAssignment_0 )
            {
             before(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAssignment_0()); 
            // InternalDefinitionLanguage.g:1947:2: ( rule__XorExpressionRule__SubExpressionsAssignment_0 )
            // InternalDefinitionLanguage.g:1947:3: rule__XorExpressionRule__SubExpressionsAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__XorExpressionRule__SubExpressionsAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XorExpressionRule__Group__0__Impl"


    // $ANTLR start "rule__XorExpressionRule__Group__1"
    // InternalDefinitionLanguage.g:1955:1: rule__XorExpressionRule__Group__1 : rule__XorExpressionRule__Group__1__Impl ;
    public final void rule__XorExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1959:1: ( rule__XorExpressionRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:1960:2: rule__XorExpressionRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XorExpressionRule__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XorExpressionRule__Group__1"


    // $ANTLR start "rule__XorExpressionRule__Group__1__Impl"
    // InternalDefinitionLanguage.g:1966:1: rule__XorExpressionRule__Group__1__Impl : ( ( rule__XorExpressionRule__Group_1__0 )* ) ;
    public final void rule__XorExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1970:1: ( ( ( rule__XorExpressionRule__Group_1__0 )* ) )
            // InternalDefinitionLanguage.g:1971:1: ( ( rule__XorExpressionRule__Group_1__0 )* )
            {
            // InternalDefinitionLanguage.g:1971:1: ( ( rule__XorExpressionRule__Group_1__0 )* )
            // InternalDefinitionLanguage.g:1972:2: ( rule__XorExpressionRule__Group_1__0 )*
            {
             before(grammarAccess.getXorExpressionRuleAccess().getGroup_1()); 
            // InternalDefinitionLanguage.g:1973:2: ( rule__XorExpressionRule__Group_1__0 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==53) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:1973:3: rule__XorExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_14);
            	    rule__XorExpressionRule__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

             after(grammarAccess.getXorExpressionRuleAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XorExpressionRule__Group__1__Impl"


    // $ANTLR start "rule__XorExpressionRule__Group_1__0"
    // InternalDefinitionLanguage.g:1982:1: rule__XorExpressionRule__Group_1__0 : rule__XorExpressionRule__Group_1__0__Impl rule__XorExpressionRule__Group_1__1 ;
    public final void rule__XorExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1986:1: ( rule__XorExpressionRule__Group_1__0__Impl rule__XorExpressionRule__Group_1__1 )
            // InternalDefinitionLanguage.g:1987:2: rule__XorExpressionRule__Group_1__0__Impl rule__XorExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_12);
            rule__XorExpressionRule__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XorExpressionRule__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XorExpressionRule__Group_1__0"


    // $ANTLR start "rule__XorExpressionRule__Group_1__0__Impl"
    // InternalDefinitionLanguage.g:1994:1: rule__XorExpressionRule__Group_1__0__Impl : ( 'XOR' ) ;
    public final void rule__XorExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1998:1: ( ( 'XOR' ) )
            // InternalDefinitionLanguage.g:1999:1: ( 'XOR' )
            {
            // InternalDefinitionLanguage.g:1999:1: ( 'XOR' )
            // InternalDefinitionLanguage.g:2000:2: 'XOR'
            {
             before(grammarAccess.getXorExpressionRuleAccess().getXORKeyword_1_0()); 
            match(input,53,FOLLOW_2); 
             after(grammarAccess.getXorExpressionRuleAccess().getXORKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XorExpressionRule__Group_1__0__Impl"


    // $ANTLR start "rule__XorExpressionRule__Group_1__1"
    // InternalDefinitionLanguage.g:2009:1: rule__XorExpressionRule__Group_1__1 : rule__XorExpressionRule__Group_1__1__Impl ;
    public final void rule__XorExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2013:1: ( rule__XorExpressionRule__Group_1__1__Impl )
            // InternalDefinitionLanguage.g:2014:2: rule__XorExpressionRule__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XorExpressionRule__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XorExpressionRule__Group_1__1"


    // $ANTLR start "rule__XorExpressionRule__Group_1__1__Impl"
    // InternalDefinitionLanguage.g:2020:1: rule__XorExpressionRule__Group_1__1__Impl : ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) ) ;
    public final void rule__XorExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2024:1: ( ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) ) )
            // InternalDefinitionLanguage.g:2025:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) )
            {
            // InternalDefinitionLanguage.g:2025:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) )
            // InternalDefinitionLanguage.g:2026:2: ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 )
            {
             before(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAssignment_1_1()); 
            // InternalDefinitionLanguage.g:2027:2: ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 )
            // InternalDefinitionLanguage.g:2027:3: rule__XorExpressionRule__SubExpressionsAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__XorExpressionRule__SubExpressionsAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XorExpressionRule__Group_1__1__Impl"


    // $ANTLR start "rule__AndExpressionRule__Group__0"
    // InternalDefinitionLanguage.g:2036:1: rule__AndExpressionRule__Group__0 : rule__AndExpressionRule__Group__0__Impl rule__AndExpressionRule__Group__1 ;
    public final void rule__AndExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2040:1: ( rule__AndExpressionRule__Group__0__Impl rule__AndExpressionRule__Group__1 )
            // InternalDefinitionLanguage.g:2041:2: rule__AndExpressionRule__Group__0__Impl rule__AndExpressionRule__Group__1
            {
            pushFollow(FOLLOW_15);
            rule__AndExpressionRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AndExpressionRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpressionRule__Group__0"


    // $ANTLR start "rule__AndExpressionRule__Group__0__Impl"
    // InternalDefinitionLanguage.g:2048:1: rule__AndExpressionRule__Group__0__Impl : ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) ) ;
    public final void rule__AndExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2052:1: ( ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:2053:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:2053:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) )
            // InternalDefinitionLanguage.g:2054:2: ( rule__AndExpressionRule__SubExpressionsAssignment_0 )
            {
             before(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsAssignment_0()); 
            // InternalDefinitionLanguage.g:2055:2: ( rule__AndExpressionRule__SubExpressionsAssignment_0 )
            // InternalDefinitionLanguage.g:2055:3: rule__AndExpressionRule__SubExpressionsAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__AndExpressionRule__SubExpressionsAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpressionRule__Group__0__Impl"


    // $ANTLR start "rule__AndExpressionRule__Group__1"
    // InternalDefinitionLanguage.g:2063:1: rule__AndExpressionRule__Group__1 : rule__AndExpressionRule__Group__1__Impl ;
    public final void rule__AndExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2067:1: ( rule__AndExpressionRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:2068:2: rule__AndExpressionRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AndExpressionRule__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpressionRule__Group__1"


    // $ANTLR start "rule__AndExpressionRule__Group__1__Impl"
    // InternalDefinitionLanguage.g:2074:1: rule__AndExpressionRule__Group__1__Impl : ( ( rule__AndExpressionRule__Group_1__0 )* ) ;
    public final void rule__AndExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2078:1: ( ( ( rule__AndExpressionRule__Group_1__0 )* ) )
            // InternalDefinitionLanguage.g:2079:1: ( ( rule__AndExpressionRule__Group_1__0 )* )
            {
            // InternalDefinitionLanguage.g:2079:1: ( ( rule__AndExpressionRule__Group_1__0 )* )
            // InternalDefinitionLanguage.g:2080:2: ( rule__AndExpressionRule__Group_1__0 )*
            {
             before(grammarAccess.getAndExpressionRuleAccess().getGroup_1()); 
            // InternalDefinitionLanguage.g:2081:2: ( rule__AndExpressionRule__Group_1__0 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==54) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:2081:3: rule__AndExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_16);
            	    rule__AndExpressionRule__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

             after(grammarAccess.getAndExpressionRuleAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpressionRule__Group__1__Impl"


    // $ANTLR start "rule__AndExpressionRule__Group_1__0"
    // InternalDefinitionLanguage.g:2090:1: rule__AndExpressionRule__Group_1__0 : rule__AndExpressionRule__Group_1__0__Impl rule__AndExpressionRule__Group_1__1 ;
    public final void rule__AndExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2094:1: ( rule__AndExpressionRule__Group_1__0__Impl rule__AndExpressionRule__Group_1__1 )
            // InternalDefinitionLanguage.g:2095:2: rule__AndExpressionRule__Group_1__0__Impl rule__AndExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_12);
            rule__AndExpressionRule__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AndExpressionRule__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpressionRule__Group_1__0"


    // $ANTLR start "rule__AndExpressionRule__Group_1__0__Impl"
    // InternalDefinitionLanguage.g:2102:1: rule__AndExpressionRule__Group_1__0__Impl : ( 'AND' ) ;
    public final void rule__AndExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2106:1: ( ( 'AND' ) )
            // InternalDefinitionLanguage.g:2107:1: ( 'AND' )
            {
            // InternalDefinitionLanguage.g:2107:1: ( 'AND' )
            // InternalDefinitionLanguage.g:2108:2: 'AND'
            {
             before(grammarAccess.getAndExpressionRuleAccess().getANDKeyword_1_0()); 
            match(input,54,FOLLOW_2); 
             after(grammarAccess.getAndExpressionRuleAccess().getANDKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpressionRule__Group_1__0__Impl"


    // $ANTLR start "rule__AndExpressionRule__Group_1__1"
    // InternalDefinitionLanguage.g:2117:1: rule__AndExpressionRule__Group_1__1 : rule__AndExpressionRule__Group_1__1__Impl ;
    public final void rule__AndExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2121:1: ( rule__AndExpressionRule__Group_1__1__Impl )
            // InternalDefinitionLanguage.g:2122:2: rule__AndExpressionRule__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AndExpressionRule__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpressionRule__Group_1__1"


    // $ANTLR start "rule__AndExpressionRule__Group_1__1__Impl"
    // InternalDefinitionLanguage.g:2128:1: rule__AndExpressionRule__Group_1__1__Impl : ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) ) ;
    public final void rule__AndExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2132:1: ( ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) ) )
            // InternalDefinitionLanguage.g:2133:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) )
            {
            // InternalDefinitionLanguage.g:2133:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) )
            // InternalDefinitionLanguage.g:2134:2: ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 )
            {
             before(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsAssignment_1_1()); 
            // InternalDefinitionLanguage.g:2135:2: ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 )
            // InternalDefinitionLanguage.g:2135:3: rule__AndExpressionRule__SubExpressionsAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__AndExpressionRule__SubExpressionsAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpressionRule__Group_1__1__Impl"


    // $ANTLR start "rule__NotExpressionRule__Group__0"
    // InternalDefinitionLanguage.g:2144:1: rule__NotExpressionRule__Group__0 : rule__NotExpressionRule__Group__0__Impl rule__NotExpressionRule__Group__1 ;
    public final void rule__NotExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2148:1: ( rule__NotExpressionRule__Group__0__Impl rule__NotExpressionRule__Group__1 )
            // InternalDefinitionLanguage.g:2149:2: rule__NotExpressionRule__Group__0__Impl rule__NotExpressionRule__Group__1
            {
            pushFollow(FOLLOW_12);
            rule__NotExpressionRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__NotExpressionRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NotExpressionRule__Group__0"


    // $ANTLR start "rule__NotExpressionRule__Group__0__Impl"
    // InternalDefinitionLanguage.g:2156:1: rule__NotExpressionRule__Group__0__Impl : ( ( rule__NotExpressionRule__NegatedAssignment_0 )? ) ;
    public final void rule__NotExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2160:1: ( ( ( rule__NotExpressionRule__NegatedAssignment_0 )? ) )
            // InternalDefinitionLanguage.g:2161:1: ( ( rule__NotExpressionRule__NegatedAssignment_0 )? )
            {
            // InternalDefinitionLanguage.g:2161:1: ( ( rule__NotExpressionRule__NegatedAssignment_0 )? )
            // InternalDefinitionLanguage.g:2162:2: ( rule__NotExpressionRule__NegatedAssignment_0 )?
            {
             before(grammarAccess.getNotExpressionRuleAccess().getNegatedAssignment_0()); 
            // InternalDefinitionLanguage.g:2163:2: ( rule__NotExpressionRule__NegatedAssignment_0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==77) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalDefinitionLanguage.g:2163:3: rule__NotExpressionRule__NegatedAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__NotExpressionRule__NegatedAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getNotExpressionRuleAccess().getNegatedAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NotExpressionRule__Group__0__Impl"


    // $ANTLR start "rule__NotExpressionRule__Group__1"
    // InternalDefinitionLanguage.g:2171:1: rule__NotExpressionRule__Group__1 : rule__NotExpressionRule__Group__1__Impl ;
    public final void rule__NotExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2175:1: ( rule__NotExpressionRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:2176:2: rule__NotExpressionRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__NotExpressionRule__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NotExpressionRule__Group__1"


    // $ANTLR start "rule__NotExpressionRule__Group__1__Impl"
    // InternalDefinitionLanguage.g:2182:1: rule__NotExpressionRule__Group__1__Impl : ( ( rule__NotExpressionRule__OperandAssignment_1 ) ) ;
    public final void rule__NotExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2186:1: ( ( ( rule__NotExpressionRule__OperandAssignment_1 ) ) )
            // InternalDefinitionLanguage.g:2187:1: ( ( rule__NotExpressionRule__OperandAssignment_1 ) )
            {
            // InternalDefinitionLanguage.g:2187:1: ( ( rule__NotExpressionRule__OperandAssignment_1 ) )
            // InternalDefinitionLanguage.g:2188:2: ( rule__NotExpressionRule__OperandAssignment_1 )
            {
             before(grammarAccess.getNotExpressionRuleAccess().getOperandAssignment_1()); 
            // InternalDefinitionLanguage.g:2189:2: ( rule__NotExpressionRule__OperandAssignment_1 )
            // InternalDefinitionLanguage.g:2189:3: rule__NotExpressionRule__OperandAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__NotExpressionRule__OperandAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getNotExpressionRuleAccess().getOperandAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NotExpressionRule__Group__1__Impl"


    // $ANTLR start "rule__ComparisonExpressionRule__Group__0"
    // InternalDefinitionLanguage.g:2198:1: rule__ComparisonExpressionRule__Group__0 : rule__ComparisonExpressionRule__Group__0__Impl rule__ComparisonExpressionRule__Group__1 ;
    public final void rule__ComparisonExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2202:1: ( rule__ComparisonExpressionRule__Group__0__Impl rule__ComparisonExpressionRule__Group__1 )
            // InternalDefinitionLanguage.g:2203:2: rule__ComparisonExpressionRule__Group__0__Impl rule__ComparisonExpressionRule__Group__1
            {
            pushFollow(FOLLOW_17);
            rule__ComparisonExpressionRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ComparisonExpressionRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComparisonExpressionRule__Group__0"


    // $ANTLR start "rule__ComparisonExpressionRule__Group__0__Impl"
    // InternalDefinitionLanguage.g:2210:1: rule__ComparisonExpressionRule__Group__0__Impl : ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__ComparisonExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2214:1: ( ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:2215:1: ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:2215:1: ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) )
            // InternalDefinitionLanguage.g:2216:2: ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 )
            {
             before(grammarAccess.getComparisonExpressionRuleAccess().getLeftOperandAssignment_0()); 
            // InternalDefinitionLanguage.g:2217:2: ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 )
            // InternalDefinitionLanguage.g:2217:3: rule__ComparisonExpressionRule__LeftOperandAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__ComparisonExpressionRule__LeftOperandAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getComparisonExpressionRuleAccess().getLeftOperandAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComparisonExpressionRule__Group__0__Impl"


    // $ANTLR start "rule__ComparisonExpressionRule__Group__1"
    // InternalDefinitionLanguage.g:2225:1: rule__ComparisonExpressionRule__Group__1 : rule__ComparisonExpressionRule__Group__1__Impl ;
    public final void rule__ComparisonExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2229:1: ( rule__ComparisonExpressionRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:2230:2: rule__ComparisonExpressionRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ComparisonExpressionRule__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComparisonExpressionRule__Group__1"


    // $ANTLR start "rule__ComparisonExpressionRule__Group__1__Impl"
    // InternalDefinitionLanguage.g:2236:1: rule__ComparisonExpressionRule__Group__1__Impl : ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* ) ;
    public final void rule__ComparisonExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2240:1: ( ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* ) )
            // InternalDefinitionLanguage.g:2241:1: ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* )
            {
            // InternalDefinitionLanguage.g:2241:1: ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* )
            // InternalDefinitionLanguage.g:2242:2: ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )*
            {
             before(grammarAccess.getComparisonExpressionRuleAccess().getComparisonAssignment_1()); 
            // InternalDefinitionLanguage.g:2243:2: ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>=16 && LA18_0<=21)) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:2243:3: rule__ComparisonExpressionRule__ComparisonAssignment_1
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__ComparisonExpressionRule__ComparisonAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

             after(grammarAccess.getComparisonExpressionRuleAccess().getComparisonAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComparisonExpressionRule__Group__1__Impl"


    // $ANTLR start "rule__PartialComparisonExpressionRule__Group__0"
    // InternalDefinitionLanguage.g:2252:1: rule__PartialComparisonExpressionRule__Group__0 : rule__PartialComparisonExpressionRule__Group__0__Impl rule__PartialComparisonExpressionRule__Group__1 ;
    public final void rule__PartialComparisonExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2256:1: ( rule__PartialComparisonExpressionRule__Group__0__Impl rule__PartialComparisonExpressionRule__Group__1 )
            // InternalDefinitionLanguage.g:2257:2: rule__PartialComparisonExpressionRule__Group__0__Impl rule__PartialComparisonExpressionRule__Group__1
            {
            pushFollow(FOLLOW_12);
            rule__PartialComparisonExpressionRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PartialComparisonExpressionRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PartialComparisonExpressionRule__Group__0"


    // $ANTLR start "rule__PartialComparisonExpressionRule__Group__0__Impl"
    // InternalDefinitionLanguage.g:2264:1: rule__PartialComparisonExpressionRule__Group__0__Impl : ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) ) ;
    public final void rule__PartialComparisonExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2268:1: ( ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:2269:1: ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:2269:1: ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) )
            // InternalDefinitionLanguage.g:2270:2: ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 )
            {
             before(grammarAccess.getPartialComparisonExpressionRuleAccess().getOperatorAssignment_0()); 
            // InternalDefinitionLanguage.g:2271:2: ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 )
            // InternalDefinitionLanguage.g:2271:3: rule__PartialComparisonExpressionRule__OperatorAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__PartialComparisonExpressionRule__OperatorAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getPartialComparisonExpressionRuleAccess().getOperatorAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PartialComparisonExpressionRule__Group__0__Impl"


    // $ANTLR start "rule__PartialComparisonExpressionRule__Group__1"
    // InternalDefinitionLanguage.g:2279:1: rule__PartialComparisonExpressionRule__Group__1 : rule__PartialComparisonExpressionRule__Group__1__Impl ;
    public final void rule__PartialComparisonExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2283:1: ( rule__PartialComparisonExpressionRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:2284:2: rule__PartialComparisonExpressionRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PartialComparisonExpressionRule__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PartialComparisonExpressionRule__Group__1"


    // $ANTLR start "rule__PartialComparisonExpressionRule__Group__1__Impl"
    // InternalDefinitionLanguage.g:2290:1: rule__PartialComparisonExpressionRule__Group__1__Impl : ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) ) ;
    public final void rule__PartialComparisonExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2294:1: ( ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) ) )
            // InternalDefinitionLanguage.g:2295:1: ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) )
            {
            // InternalDefinitionLanguage.g:2295:1: ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) )
            // InternalDefinitionLanguage.g:2296:2: ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 )
            {
             before(grammarAccess.getPartialComparisonExpressionRuleAccess().getSubExpressionAssignment_1()); 
            // InternalDefinitionLanguage.g:2297:2: ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 )
            // InternalDefinitionLanguage.g:2297:3: rule__PartialComparisonExpressionRule__SubExpressionAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__PartialComparisonExpressionRule__SubExpressionAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getPartialComparisonExpressionRuleAccess().getSubExpressionAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PartialComparisonExpressionRule__Group__1__Impl"


    // $ANTLR start "rule__AddOrSubtractExpressionRule__Group__0"
    // InternalDefinitionLanguage.g:2306:1: rule__AddOrSubtractExpressionRule__Group__0 : rule__AddOrSubtractExpressionRule__Group__0__Impl rule__AddOrSubtractExpressionRule__Group__1 ;
    public final void rule__AddOrSubtractExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2310:1: ( rule__AddOrSubtractExpressionRule__Group__0__Impl rule__AddOrSubtractExpressionRule__Group__1 )
            // InternalDefinitionLanguage.g:2311:2: rule__AddOrSubtractExpressionRule__Group__0__Impl rule__AddOrSubtractExpressionRule__Group__1
            {
            pushFollow(FOLLOW_19);
            rule__AddOrSubtractExpressionRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AddOrSubtractExpressionRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AddOrSubtractExpressionRule__Group__0"


    // $ANTLR start "rule__AddOrSubtractExpressionRule__Group__0__Impl"
    // InternalDefinitionLanguage.g:2318:1: rule__AddOrSubtractExpressionRule__Group__0__Impl : ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__AddOrSubtractExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2322:1: ( ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:2323:1: ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:2323:1: ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) )
            // InternalDefinitionLanguage.g:2324:2: ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 )
            {
             before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getLeftOperandAssignment_0()); 
            // InternalDefinitionLanguage.g:2325:2: ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 )
            // InternalDefinitionLanguage.g:2325:3: rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getAddOrSubtractExpressionRuleAccess().getLeftOperandAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AddOrSubtractExpressionRule__Group__0__Impl"


    // $ANTLR start "rule__AddOrSubtractExpressionRule__Group__1"
    // InternalDefinitionLanguage.g:2333:1: rule__AddOrSubtractExpressionRule__Group__1 : rule__AddOrSubtractExpressionRule__Group__1__Impl ;
    public final void rule__AddOrSubtractExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2337:1: ( rule__AddOrSubtractExpressionRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:2338:2: rule__AddOrSubtractExpressionRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AddOrSubtractExpressionRule__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AddOrSubtractExpressionRule__Group__1"


    // $ANTLR start "rule__AddOrSubtractExpressionRule__Group__1__Impl"
    // InternalDefinitionLanguage.g:2344:1: rule__AddOrSubtractExpressionRule__Group__1__Impl : ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* ) ;
    public final void rule__AddOrSubtractExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2348:1: ( ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* ) )
            // InternalDefinitionLanguage.g:2349:1: ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* )
            {
            // InternalDefinitionLanguage.g:2349:1: ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* )
            // InternalDefinitionLanguage.g:2350:2: ( rule__AddOrSubtractExpressionRule__Group_1__0 )*
            {
             before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getGroup_1()); 
            // InternalDefinitionLanguage.g:2351:2: ( rule__AddOrSubtractExpressionRule__Group_1__0 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>=22 && LA19_0<=23)) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:2351:3: rule__AddOrSubtractExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_20);
            	    rule__AddOrSubtractExpressionRule__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

             after(grammarAccess.getAddOrSubtractExpressionRuleAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AddOrSubtractExpressionRule__Group__1__Impl"


    // $ANTLR start "rule__AddOrSubtractExpressionRule__Group_1__0"
    // InternalDefinitionLanguage.g:2360:1: rule__AddOrSubtractExpressionRule__Group_1__0 : rule__AddOrSubtractExpressionRule__Group_1__0__Impl rule__AddOrSubtractExpressionRule__Group_1__1 ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2364:1: ( rule__AddOrSubtractExpressionRule__Group_1__0__Impl rule__AddOrSubtractExpressionRule__Group_1__1 )
            // InternalDefinitionLanguage.g:2365:2: rule__AddOrSubtractExpressionRule__Group_1__0__Impl rule__AddOrSubtractExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_12);
            rule__AddOrSubtractExpressionRule__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AddOrSubtractExpressionRule__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AddOrSubtractExpressionRule__Group_1__0"


    // $ANTLR start "rule__AddOrSubtractExpressionRule__Group_1__0__Impl"
    // InternalDefinitionLanguage.g:2372:1: rule__AddOrSubtractExpressionRule__Group_1__0__Impl : ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) ) ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2376:1: ( ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) ) )
            // InternalDefinitionLanguage.g:2377:1: ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) )
            {
            // InternalDefinitionLanguage.g:2377:1: ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) )
            // InternalDefinitionLanguage.g:2378:2: ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 )
            {
             before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperatorsAssignment_1_0()); 
            // InternalDefinitionLanguage.g:2379:2: ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 )
            // InternalDefinitionLanguage.g:2379:3: rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0
            {
            pushFollow(FOLLOW_2);
            rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0();

            state._fsp--;


            }

             after(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperatorsAssignment_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AddOrSubtractExpressionRule__Group_1__0__Impl"


    // $ANTLR start "rule__AddOrSubtractExpressionRule__Group_1__1"
    // InternalDefinitionLanguage.g:2387:1: rule__AddOrSubtractExpressionRule__Group_1__1 : rule__AddOrSubtractExpressionRule__Group_1__1__Impl ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2391:1: ( rule__AddOrSubtractExpressionRule__Group_1__1__Impl )
            // InternalDefinitionLanguage.g:2392:2: rule__AddOrSubtractExpressionRule__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AddOrSubtractExpressionRule__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AddOrSubtractExpressionRule__Group_1__1"


    // $ANTLR start "rule__AddOrSubtractExpressionRule__Group_1__1__Impl"
    // InternalDefinitionLanguage.g:2398:1: rule__AddOrSubtractExpressionRule__Group_1__1__Impl : ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) ) ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2402:1: ( ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) ) )
            // InternalDefinitionLanguage.g:2403:1: ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) )
            {
            // InternalDefinitionLanguage.g:2403:1: ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) )
            // InternalDefinitionLanguage.g:2404:2: ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 )
            {
             before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperandsAssignment_1_1()); 
            // InternalDefinitionLanguage.g:2405:2: ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 )
            // InternalDefinitionLanguage.g:2405:3: rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperandsAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AddOrSubtractExpressionRule__Group_1__1__Impl"


    // $ANTLR start "rule__MultiplyDivideModuloExpressionRule__Group__0"
    // InternalDefinitionLanguage.g:2414:1: rule__MultiplyDivideModuloExpressionRule__Group__0 : rule__MultiplyDivideModuloExpressionRule__Group__0__Impl rule__MultiplyDivideModuloExpressionRule__Group__1 ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2418:1: ( rule__MultiplyDivideModuloExpressionRule__Group__0__Impl rule__MultiplyDivideModuloExpressionRule__Group__1 )
            // InternalDefinitionLanguage.g:2419:2: rule__MultiplyDivideModuloExpressionRule__Group__0__Impl rule__MultiplyDivideModuloExpressionRule__Group__1
            {
            pushFollow(FOLLOW_21);
            rule__MultiplyDivideModuloExpressionRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultiplyDivideModuloExpressionRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplyDivideModuloExpressionRule__Group__0"


    // $ANTLR start "rule__MultiplyDivideModuloExpressionRule__Group__0__Impl"
    // InternalDefinitionLanguage.g:2426:1: rule__MultiplyDivideModuloExpressionRule__Group__0__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2430:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:2431:1: ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:2431:1: ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) )
            // InternalDefinitionLanguage.g:2432:2: ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 )
            {
             before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getLeftOperandAssignment_0()); 
            // InternalDefinitionLanguage.g:2433:2: ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 )
            // InternalDefinitionLanguage.g:2433:3: rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getLeftOperandAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplyDivideModuloExpressionRule__Group__0__Impl"


    // $ANTLR start "rule__MultiplyDivideModuloExpressionRule__Group__1"
    // InternalDefinitionLanguage.g:2441:1: rule__MultiplyDivideModuloExpressionRule__Group__1 : rule__MultiplyDivideModuloExpressionRule__Group__1__Impl ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2445:1: ( rule__MultiplyDivideModuloExpressionRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:2446:2: rule__MultiplyDivideModuloExpressionRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MultiplyDivideModuloExpressionRule__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplyDivideModuloExpressionRule__Group__1"


    // $ANTLR start "rule__MultiplyDivideModuloExpressionRule__Group__1__Impl"
    // InternalDefinitionLanguage.g:2452:1: rule__MultiplyDivideModuloExpressionRule__Group__1__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2456:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* ) )
            // InternalDefinitionLanguage.g:2457:1: ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* )
            {
            // InternalDefinitionLanguage.g:2457:1: ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* )
            // InternalDefinitionLanguage.g:2458:2: ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )*
            {
             before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getGroup_1()); 
            // InternalDefinitionLanguage.g:2459:2: ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>=24 && LA20_0<=26)) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:2459:3: rule__MultiplyDivideModuloExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_22);
            	    rule__MultiplyDivideModuloExpressionRule__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

             after(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplyDivideModuloExpressionRule__Group__1__Impl"


    // $ANTLR start "rule__MultiplyDivideModuloExpressionRule__Group_1__0"
    // InternalDefinitionLanguage.g:2468:1: rule__MultiplyDivideModuloExpressionRule__Group_1__0 : rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl rule__MultiplyDivideModuloExpressionRule__Group_1__1 ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2472:1: ( rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl rule__MultiplyDivideModuloExpressionRule__Group_1__1 )
            // InternalDefinitionLanguage.g:2473:2: rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl rule__MultiplyDivideModuloExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_12);
            rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultiplyDivideModuloExpressionRule__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplyDivideModuloExpressionRule__Group_1__0"


    // $ANTLR start "rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl"
    // InternalDefinitionLanguage.g:2480:1: rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2484:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) ) )
            // InternalDefinitionLanguage.g:2485:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) )
            {
            // InternalDefinitionLanguage.g:2485:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) )
            // InternalDefinitionLanguage.g:2486:2: ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 )
            {
             before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperatorsAssignment_1_0()); 
            // InternalDefinitionLanguage.g:2487:2: ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 )
            // InternalDefinitionLanguage.g:2487:3: rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0
            {
            pushFollow(FOLLOW_2);
            rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0();

            state._fsp--;


            }

             after(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperatorsAssignment_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl"


    // $ANTLR start "rule__MultiplyDivideModuloExpressionRule__Group_1__1"
    // InternalDefinitionLanguage.g:2495:1: rule__MultiplyDivideModuloExpressionRule__Group_1__1 : rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2499:1: ( rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl )
            // InternalDefinitionLanguage.g:2500:2: rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplyDivideModuloExpressionRule__Group_1__1"


    // $ANTLR start "rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl"
    // InternalDefinitionLanguage.g:2506:1: rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2510:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) ) )
            // InternalDefinitionLanguage.g:2511:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) )
            {
            // InternalDefinitionLanguage.g:2511:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) )
            // InternalDefinitionLanguage.g:2512:2: ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 )
            {
             before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperandsAssignment_1_1()); 
            // InternalDefinitionLanguage.g:2513:2: ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 )
            // InternalDefinitionLanguage.g:2513:3: rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperandsAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl"


    // $ANTLR start "rule__PowerOfExpressionRule__Group__0"
    // InternalDefinitionLanguage.g:2522:1: rule__PowerOfExpressionRule__Group__0 : rule__PowerOfExpressionRule__Group__0__Impl rule__PowerOfExpressionRule__Group__1 ;
    public final void rule__PowerOfExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2526:1: ( rule__PowerOfExpressionRule__Group__0__Impl rule__PowerOfExpressionRule__Group__1 )
            // InternalDefinitionLanguage.g:2527:2: rule__PowerOfExpressionRule__Group__0__Impl rule__PowerOfExpressionRule__Group__1
            {
            pushFollow(FOLLOW_23);
            rule__PowerOfExpressionRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PowerOfExpressionRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PowerOfExpressionRule__Group__0"


    // $ANTLR start "rule__PowerOfExpressionRule__Group__0__Impl"
    // InternalDefinitionLanguage.g:2534:1: rule__PowerOfExpressionRule__Group__0__Impl : ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__PowerOfExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2538:1: ( ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:2539:1: ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:2539:1: ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) )
            // InternalDefinitionLanguage.g:2540:2: ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 )
            {
             before(grammarAccess.getPowerOfExpressionRuleAccess().getLeftOperandAssignment_0()); 
            // InternalDefinitionLanguage.g:2541:2: ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 )
            // InternalDefinitionLanguage.g:2541:3: rule__PowerOfExpressionRule__LeftOperandAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__PowerOfExpressionRule__LeftOperandAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getPowerOfExpressionRuleAccess().getLeftOperandAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PowerOfExpressionRule__Group__0__Impl"


    // $ANTLR start "rule__PowerOfExpressionRule__Group__1"
    // InternalDefinitionLanguage.g:2549:1: rule__PowerOfExpressionRule__Group__1 : rule__PowerOfExpressionRule__Group__1__Impl ;
    public final void rule__PowerOfExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2553:1: ( rule__PowerOfExpressionRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:2554:2: rule__PowerOfExpressionRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PowerOfExpressionRule__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PowerOfExpressionRule__Group__1"


    // $ANTLR start "rule__PowerOfExpressionRule__Group__1__Impl"
    // InternalDefinitionLanguage.g:2560:1: rule__PowerOfExpressionRule__Group__1__Impl : ( ( rule__PowerOfExpressionRule__Group_1__0 )? ) ;
    public final void rule__PowerOfExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2564:1: ( ( ( rule__PowerOfExpressionRule__Group_1__0 )? ) )
            // InternalDefinitionLanguage.g:2565:1: ( ( rule__PowerOfExpressionRule__Group_1__0 )? )
            {
            // InternalDefinitionLanguage.g:2565:1: ( ( rule__PowerOfExpressionRule__Group_1__0 )? )
            // InternalDefinitionLanguage.g:2566:2: ( rule__PowerOfExpressionRule__Group_1__0 )?
            {
             before(grammarAccess.getPowerOfExpressionRuleAccess().getGroup_1()); 
            // InternalDefinitionLanguage.g:2567:2: ( rule__PowerOfExpressionRule__Group_1__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==55) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalDefinitionLanguage.g:2567:3: rule__PowerOfExpressionRule__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PowerOfExpressionRule__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPowerOfExpressionRuleAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PowerOfExpressionRule__Group__1__Impl"


    // $ANTLR start "rule__PowerOfExpressionRule__Group_1__0"
    // InternalDefinitionLanguage.g:2576:1: rule__PowerOfExpressionRule__Group_1__0 : rule__PowerOfExpressionRule__Group_1__0__Impl rule__PowerOfExpressionRule__Group_1__1 ;
    public final void rule__PowerOfExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2580:1: ( rule__PowerOfExpressionRule__Group_1__0__Impl rule__PowerOfExpressionRule__Group_1__1 )
            // InternalDefinitionLanguage.g:2581:2: rule__PowerOfExpressionRule__Group_1__0__Impl rule__PowerOfExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_12);
            rule__PowerOfExpressionRule__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PowerOfExpressionRule__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PowerOfExpressionRule__Group_1__0"


    // $ANTLR start "rule__PowerOfExpressionRule__Group_1__0__Impl"
    // InternalDefinitionLanguage.g:2588:1: rule__PowerOfExpressionRule__Group_1__0__Impl : ( '^' ) ;
    public final void rule__PowerOfExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2592:1: ( ( '^' ) )
            // InternalDefinitionLanguage.g:2593:1: ( '^' )
            {
            // InternalDefinitionLanguage.g:2593:1: ( '^' )
            // InternalDefinitionLanguage.g:2594:2: '^'
            {
             before(grammarAccess.getPowerOfExpressionRuleAccess().getCircumflexAccentKeyword_1_0()); 
            match(input,55,FOLLOW_2); 
             after(grammarAccess.getPowerOfExpressionRuleAccess().getCircumflexAccentKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PowerOfExpressionRule__Group_1__0__Impl"


    // $ANTLR start "rule__PowerOfExpressionRule__Group_1__1"
    // InternalDefinitionLanguage.g:2603:1: rule__PowerOfExpressionRule__Group_1__1 : rule__PowerOfExpressionRule__Group_1__1__Impl ;
    public final void rule__PowerOfExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2607:1: ( rule__PowerOfExpressionRule__Group_1__1__Impl )
            // InternalDefinitionLanguage.g:2608:2: rule__PowerOfExpressionRule__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PowerOfExpressionRule__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PowerOfExpressionRule__Group_1__1"


    // $ANTLR start "rule__PowerOfExpressionRule__Group_1__1__Impl"
    // InternalDefinitionLanguage.g:2614:1: rule__PowerOfExpressionRule__Group_1__1__Impl : ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) ) ;
    public final void rule__PowerOfExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2618:1: ( ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) ) )
            // InternalDefinitionLanguage.g:2619:1: ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) )
            {
            // InternalDefinitionLanguage.g:2619:1: ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) )
            // InternalDefinitionLanguage.g:2620:2: ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 )
            {
             before(grammarAccess.getPowerOfExpressionRuleAccess().getRightOperandAssignment_1_1()); 
            // InternalDefinitionLanguage.g:2621:2: ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 )
            // InternalDefinitionLanguage.g:2621:3: rule__PowerOfExpressionRule__RightOperandAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__PowerOfExpressionRule__RightOperandAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getPowerOfExpressionRuleAccess().getRightOperandAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PowerOfExpressionRule__Group_1__1__Impl"


    // $ANTLR start "rule__UnaryAddOrSubtractExpressionRule__Group__0"
    // InternalDefinitionLanguage.g:2630:1: rule__UnaryAddOrSubtractExpressionRule__Group__0 : rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl rule__UnaryAddOrSubtractExpressionRule__Group__1 ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2634:1: ( rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl rule__UnaryAddOrSubtractExpressionRule__Group__1 )
            // InternalDefinitionLanguage.g:2635:2: rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl rule__UnaryAddOrSubtractExpressionRule__Group__1
            {
            pushFollow(FOLLOW_12);
            rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__UnaryAddOrSubtractExpressionRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnaryAddOrSubtractExpressionRule__Group__0"


    // $ANTLR start "rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl"
    // InternalDefinitionLanguage.g:2642:1: rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl : ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2646:1: ( ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* ) )
            // InternalDefinitionLanguage.g:2647:1: ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* )
            {
            // InternalDefinitionLanguage.g:2647:1: ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* )
            // InternalDefinitionLanguage.g:2648:2: ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )*
            {
             before(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getOperatorsAssignment_0()); 
            // InternalDefinitionLanguage.g:2649:2: ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0>=22 && LA22_0<=23)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:2649:3: rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0
            	    {
            	    pushFollow(FOLLOW_20);
            	    rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

             after(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getOperatorsAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl"


    // $ANTLR start "rule__UnaryAddOrSubtractExpressionRule__Group__1"
    // InternalDefinitionLanguage.g:2657:1: rule__UnaryAddOrSubtractExpressionRule__Group__1 : rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2661:1: ( rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:2662:2: rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnaryAddOrSubtractExpressionRule__Group__1"


    // $ANTLR start "rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl"
    // InternalDefinitionLanguage.g:2668:1: rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl : ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2672:1: ( ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) ) )
            // InternalDefinitionLanguage.g:2673:1: ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) )
            {
            // InternalDefinitionLanguage.g:2673:1: ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) )
            // InternalDefinitionLanguage.g:2674:2: ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 )
            {
             before(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getSubExpressionAssignment_1()); 
            // InternalDefinitionLanguage.g:2675:2: ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 )
            // InternalDefinitionLanguage.g:2675:3: rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getSubExpressionAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl"


    // $ANTLR start "rule__ParanthesesRule__Group__0"
    // InternalDefinitionLanguage.g:2684:1: rule__ParanthesesRule__Group__0 : rule__ParanthesesRule__Group__0__Impl rule__ParanthesesRule__Group__1 ;
    public final void rule__ParanthesesRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2688:1: ( rule__ParanthesesRule__Group__0__Impl rule__ParanthesesRule__Group__1 )
            // InternalDefinitionLanguage.g:2689:2: rule__ParanthesesRule__Group__0__Impl rule__ParanthesesRule__Group__1
            {
            pushFollow(FOLLOW_12);
            rule__ParanthesesRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParanthesesRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParanthesesRule__Group__0"


    // $ANTLR start "rule__ParanthesesRule__Group__0__Impl"
    // InternalDefinitionLanguage.g:2696:1: rule__ParanthesesRule__Group__0__Impl : ( '(' ) ;
    public final void rule__ParanthesesRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2700:1: ( ( '(' ) )
            // InternalDefinitionLanguage.g:2701:1: ( '(' )
            {
            // InternalDefinitionLanguage.g:2701:1: ( '(' )
            // InternalDefinitionLanguage.g:2702:2: '('
            {
             before(grammarAccess.getParanthesesRuleAccess().getLeftParenthesisKeyword_0()); 
            match(input,56,FOLLOW_2); 
             after(grammarAccess.getParanthesesRuleAccess().getLeftParenthesisKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParanthesesRule__Group__0__Impl"


    // $ANTLR start "rule__ParanthesesRule__Group__1"
    // InternalDefinitionLanguage.g:2711:1: rule__ParanthesesRule__Group__1 : rule__ParanthesesRule__Group__1__Impl rule__ParanthesesRule__Group__2 ;
    public final void rule__ParanthesesRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2715:1: ( rule__ParanthesesRule__Group__1__Impl rule__ParanthesesRule__Group__2 )
            // InternalDefinitionLanguage.g:2716:2: rule__ParanthesesRule__Group__1__Impl rule__ParanthesesRule__Group__2
            {
            pushFollow(FOLLOW_24);
            rule__ParanthesesRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParanthesesRule__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParanthesesRule__Group__1"


    // $ANTLR start "rule__ParanthesesRule__Group__1__Impl"
    // InternalDefinitionLanguage.g:2723:1: rule__ParanthesesRule__Group__1__Impl : ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) ) ;
    public final void rule__ParanthesesRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2727:1: ( ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) ) )
            // InternalDefinitionLanguage.g:2728:1: ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) )
            {
            // InternalDefinitionLanguage.g:2728:1: ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) )
            // InternalDefinitionLanguage.g:2729:2: ( rule__ParanthesesRule__SubExpressionAssignment_1 )
            {
             before(grammarAccess.getParanthesesRuleAccess().getSubExpressionAssignment_1()); 
            // InternalDefinitionLanguage.g:2730:2: ( rule__ParanthesesRule__SubExpressionAssignment_1 )
            // InternalDefinitionLanguage.g:2730:3: rule__ParanthesesRule__SubExpressionAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__ParanthesesRule__SubExpressionAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getParanthesesRuleAccess().getSubExpressionAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParanthesesRule__Group__1__Impl"


    // $ANTLR start "rule__ParanthesesRule__Group__2"
    // InternalDefinitionLanguage.g:2738:1: rule__ParanthesesRule__Group__2 : rule__ParanthesesRule__Group__2__Impl ;
    public final void rule__ParanthesesRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2742:1: ( rule__ParanthesesRule__Group__2__Impl )
            // InternalDefinitionLanguage.g:2743:2: rule__ParanthesesRule__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ParanthesesRule__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParanthesesRule__Group__2"


    // $ANTLR start "rule__ParanthesesRule__Group__2__Impl"
    // InternalDefinitionLanguage.g:2749:1: rule__ParanthesesRule__Group__2__Impl : ( ')' ) ;
    public final void rule__ParanthesesRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2753:1: ( ( ')' ) )
            // InternalDefinitionLanguage.g:2754:1: ( ')' )
            {
            // InternalDefinitionLanguage.g:2754:1: ( ')' )
            // InternalDefinitionLanguage.g:2755:2: ')'
            {
             before(grammarAccess.getParanthesesRuleAccess().getRightParenthesisKeyword_2()); 
            match(input,57,FOLLOW_2); 
             after(grammarAccess.getParanthesesRuleAccess().getRightParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParanthesesRule__Group__2__Impl"


    // $ANTLR start "rule__CallRule__Group__0"
    // InternalDefinitionLanguage.g:2765:1: rule__CallRule__Group__0 : rule__CallRule__Group__0__Impl rule__CallRule__Group__1 ;
    public final void rule__CallRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2769:1: ( rule__CallRule__Group__0__Impl rule__CallRule__Group__1 )
            // InternalDefinitionLanguage.g:2770:2: rule__CallRule__Group__0__Impl rule__CallRule__Group__1
            {
            pushFollow(FOLLOW_25);
            rule__CallRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CallRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CallRule__Group__0"


    // $ANTLR start "rule__CallRule__Group__0__Impl"
    // InternalDefinitionLanguage.g:2777:1: rule__CallRule__Group__0__Impl : ( ( rule__CallRule__FunctionAssignment_0 ) ) ;
    public final void rule__CallRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2781:1: ( ( ( rule__CallRule__FunctionAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:2782:1: ( ( rule__CallRule__FunctionAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:2782:1: ( ( rule__CallRule__FunctionAssignment_0 ) )
            // InternalDefinitionLanguage.g:2783:2: ( rule__CallRule__FunctionAssignment_0 )
            {
             before(grammarAccess.getCallRuleAccess().getFunctionAssignment_0()); 
            // InternalDefinitionLanguage.g:2784:2: ( rule__CallRule__FunctionAssignment_0 )
            // InternalDefinitionLanguage.g:2784:3: rule__CallRule__FunctionAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__CallRule__FunctionAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getCallRuleAccess().getFunctionAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CallRule__Group__0__Impl"


    // $ANTLR start "rule__CallRule__Group__1"
    // InternalDefinitionLanguage.g:2792:1: rule__CallRule__Group__1 : rule__CallRule__Group__1__Impl rule__CallRule__Group__2 ;
    public final void rule__CallRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2796:1: ( rule__CallRule__Group__1__Impl rule__CallRule__Group__2 )
            // InternalDefinitionLanguage.g:2797:2: rule__CallRule__Group__1__Impl rule__CallRule__Group__2
            {
            pushFollow(FOLLOW_26);
            rule__CallRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CallRule__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CallRule__Group__1"


    // $ANTLR start "rule__CallRule__Group__1__Impl"
    // InternalDefinitionLanguage.g:2804:1: rule__CallRule__Group__1__Impl : ( '(' ) ;
    public final void rule__CallRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2808:1: ( ( '(' ) )
            // InternalDefinitionLanguage.g:2809:1: ( '(' )
            {
            // InternalDefinitionLanguage.g:2809:1: ( '(' )
            // InternalDefinitionLanguage.g:2810:2: '('
            {
             before(grammarAccess.getCallRuleAccess().getLeftParenthesisKeyword_1()); 
            match(input,56,FOLLOW_2); 
             after(grammarAccess.getCallRuleAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CallRule__Group__1__Impl"


    // $ANTLR start "rule__CallRule__Group__2"
    // InternalDefinitionLanguage.g:2819:1: rule__CallRule__Group__2 : rule__CallRule__Group__2__Impl rule__CallRule__Group__3 ;
    public final void rule__CallRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2823:1: ( rule__CallRule__Group__2__Impl rule__CallRule__Group__3 )
            // InternalDefinitionLanguage.g:2824:2: rule__CallRule__Group__2__Impl rule__CallRule__Group__3
            {
            pushFollow(FOLLOW_26);
            rule__CallRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CallRule__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CallRule__Group__2"


    // $ANTLR start "rule__CallRule__Group__2__Impl"
    // InternalDefinitionLanguage.g:2831:1: rule__CallRule__Group__2__Impl : ( ( rule__CallRule__Group_2__0 )? ) ;
    public final void rule__CallRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2835:1: ( ( ( rule__CallRule__Group_2__0 )? ) )
            // InternalDefinitionLanguage.g:2836:1: ( ( rule__CallRule__Group_2__0 )? )
            {
            // InternalDefinitionLanguage.g:2836:1: ( ( rule__CallRule__Group_2__0 )? )
            // InternalDefinitionLanguage.g:2837:2: ( rule__CallRule__Group_2__0 )?
            {
             before(grammarAccess.getCallRuleAccess().getGroup_2()); 
            // InternalDefinitionLanguage.g:2838:2: ( rule__CallRule__Group_2__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( ((LA23_0>=RULE_QUOTED_ID && LA23_0<=RULE_STRING)||LA23_0==15||(LA23_0>=22 && LA23_0<=23)||LA23_0==56||LA23_0==59||(LA23_0>=77 && LA23_0<=78)) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalDefinitionLanguage.g:2838:3: rule__CallRule__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__CallRule__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getCallRuleAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CallRule__Group__2__Impl"


    // $ANTLR start "rule__CallRule__Group__3"
    // InternalDefinitionLanguage.g:2846:1: rule__CallRule__Group__3 : rule__CallRule__Group__3__Impl ;
    public final void rule__CallRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2850:1: ( rule__CallRule__Group__3__Impl )
            // InternalDefinitionLanguage.g:2851:2: rule__CallRule__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CallRule__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CallRule__Group__3"


    // $ANTLR start "rule__CallRule__Group__3__Impl"
    // InternalDefinitionLanguage.g:2857:1: rule__CallRule__Group__3__Impl : ( ')' ) ;
    public final void rule__CallRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2861:1: ( ( ')' ) )
            // InternalDefinitionLanguage.g:2862:1: ( ')' )
            {
            // InternalDefinitionLanguage.g:2862:1: ( ')' )
            // InternalDefinitionLanguage.g:2863:2: ')'
            {
             before(grammarAccess.getCallRuleAccess().getRightParenthesisKeyword_3()); 
            match(input,57,FOLLOW_2); 
             after(grammarAccess.getCallRuleAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CallRule__Group__3__Impl"


    // $ANTLR start "rule__CallRule__Group_2__0"
    // InternalDefinitionLanguage.g:2873:1: rule__CallRule__Group_2__0 : rule__CallRule__Group_2__0__Impl rule__CallRule__Group_2__1 ;
    public final void rule__CallRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2877:1: ( rule__CallRule__Group_2__0__Impl rule__CallRule__Group_2__1 )
            // InternalDefinitionLanguage.g:2878:2: rule__CallRule__Group_2__0__Impl rule__CallRule__Group_2__1
            {
            pushFollow(FOLLOW_27);
            rule__CallRule__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CallRule__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CallRule__Group_2__0"


    // $ANTLR start "rule__CallRule__Group_2__0__Impl"
    // InternalDefinitionLanguage.g:2885:1: rule__CallRule__Group_2__0__Impl : ( ( rule__CallRule__ParametersAssignment_2_0 ) ) ;
    public final void rule__CallRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2889:1: ( ( ( rule__CallRule__ParametersAssignment_2_0 ) ) )
            // InternalDefinitionLanguage.g:2890:1: ( ( rule__CallRule__ParametersAssignment_2_0 ) )
            {
            // InternalDefinitionLanguage.g:2890:1: ( ( rule__CallRule__ParametersAssignment_2_0 ) )
            // InternalDefinitionLanguage.g:2891:2: ( rule__CallRule__ParametersAssignment_2_0 )
            {
             before(grammarAccess.getCallRuleAccess().getParametersAssignment_2_0()); 
            // InternalDefinitionLanguage.g:2892:2: ( rule__CallRule__ParametersAssignment_2_0 )
            // InternalDefinitionLanguage.g:2892:3: rule__CallRule__ParametersAssignment_2_0
            {
            pushFollow(FOLLOW_2);
            rule__CallRule__ParametersAssignment_2_0();

            state._fsp--;


            }

             after(grammarAccess.getCallRuleAccess().getParametersAssignment_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CallRule__Group_2__0__Impl"


    // $ANTLR start "rule__CallRule__Group_2__1"
    // InternalDefinitionLanguage.g:2900:1: rule__CallRule__Group_2__1 : rule__CallRule__Group_2__1__Impl ;
    public final void rule__CallRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2904:1: ( rule__CallRule__Group_2__1__Impl )
            // InternalDefinitionLanguage.g:2905:2: rule__CallRule__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CallRule__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CallRule__Group_2__1"


    // $ANTLR start "rule__CallRule__Group_2__1__Impl"
    // InternalDefinitionLanguage.g:2911:1: rule__CallRule__Group_2__1__Impl : ( ( rule__CallRule__Group_2_1__0 )* ) ;
    public final void rule__CallRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2915:1: ( ( ( rule__CallRule__Group_2_1__0 )* ) )
            // InternalDefinitionLanguage.g:2916:1: ( ( rule__CallRule__Group_2_1__0 )* )
            {
            // InternalDefinitionLanguage.g:2916:1: ( ( rule__CallRule__Group_2_1__0 )* )
            // InternalDefinitionLanguage.g:2917:2: ( rule__CallRule__Group_2_1__0 )*
            {
             before(grammarAccess.getCallRuleAccess().getGroup_2_1()); 
            // InternalDefinitionLanguage.g:2918:2: ( rule__CallRule__Group_2_1__0 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==58) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:2918:3: rule__CallRule__Group_2_1__0
            	    {
            	    pushFollow(FOLLOW_28);
            	    rule__CallRule__Group_2_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

             after(grammarAccess.getCallRuleAccess().getGroup_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CallRule__Group_2__1__Impl"


    // $ANTLR start "rule__CallRule__Group_2_1__0"
    // InternalDefinitionLanguage.g:2927:1: rule__CallRule__Group_2_1__0 : rule__CallRule__Group_2_1__0__Impl rule__CallRule__Group_2_1__1 ;
    public final void rule__CallRule__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2931:1: ( rule__CallRule__Group_2_1__0__Impl rule__CallRule__Group_2_1__1 )
            // InternalDefinitionLanguage.g:2932:2: rule__CallRule__Group_2_1__0__Impl rule__CallRule__Group_2_1__1
            {
            pushFollow(FOLLOW_12);
            rule__CallRule__Group_2_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CallRule__Group_2_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CallRule__Group_2_1__0"


    // $ANTLR start "rule__CallRule__Group_2_1__0__Impl"
    // InternalDefinitionLanguage.g:2939:1: rule__CallRule__Group_2_1__0__Impl : ( ',' ) ;
    public final void rule__CallRule__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2943:1: ( ( ',' ) )
            // InternalDefinitionLanguage.g:2944:1: ( ',' )
            {
            // InternalDefinitionLanguage.g:2944:1: ( ',' )
            // InternalDefinitionLanguage.g:2945:2: ','
            {
             before(grammarAccess.getCallRuleAccess().getCommaKeyword_2_1_0()); 
            match(input,58,FOLLOW_2); 
             after(grammarAccess.getCallRuleAccess().getCommaKeyword_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CallRule__Group_2_1__0__Impl"


    // $ANTLR start "rule__CallRule__Group_2_1__1"
    // InternalDefinitionLanguage.g:2954:1: rule__CallRule__Group_2_1__1 : rule__CallRule__Group_2_1__1__Impl ;
    public final void rule__CallRule__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2958:1: ( rule__CallRule__Group_2_1__1__Impl )
            // InternalDefinitionLanguage.g:2959:2: rule__CallRule__Group_2_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CallRule__Group_2_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CallRule__Group_2_1__1"


    // $ANTLR start "rule__CallRule__Group_2_1__1__Impl"
    // InternalDefinitionLanguage.g:2965:1: rule__CallRule__Group_2_1__1__Impl : ( ( rule__CallRule__ParametersAssignment_2_1_1 ) ) ;
    public final void rule__CallRule__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2969:1: ( ( ( rule__CallRule__ParametersAssignment_2_1_1 ) ) )
            // InternalDefinitionLanguage.g:2970:1: ( ( rule__CallRule__ParametersAssignment_2_1_1 ) )
            {
            // InternalDefinitionLanguage.g:2970:1: ( ( rule__CallRule__ParametersAssignment_2_1_1 ) )
            // InternalDefinitionLanguage.g:2971:2: ( rule__CallRule__ParametersAssignment_2_1_1 )
            {
             before(grammarAccess.getCallRuleAccess().getParametersAssignment_2_1_1()); 
            // InternalDefinitionLanguage.g:2972:2: ( rule__CallRule__ParametersAssignment_2_1_1 )
            // InternalDefinitionLanguage.g:2972:3: rule__CallRule__ParametersAssignment_2_1_1
            {
            pushFollow(FOLLOW_2);
            rule__CallRule__ParametersAssignment_2_1_1();

            state._fsp--;


            }

             after(grammarAccess.getCallRuleAccess().getParametersAssignment_2_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CallRule__Group_2_1__1__Impl"


    // $ANTLR start "rule__ValueReferenceRule__Group__0"
    // InternalDefinitionLanguage.g:2981:1: rule__ValueReferenceRule__Group__0 : rule__ValueReferenceRule__Group__0__Impl rule__ValueReferenceRule__Group__1 ;
    public final void rule__ValueReferenceRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2985:1: ( rule__ValueReferenceRule__Group__0__Impl rule__ValueReferenceRule__Group__1 )
            // InternalDefinitionLanguage.g:2986:2: rule__ValueReferenceRule__Group__0__Impl rule__ValueReferenceRule__Group__1
            {
            pushFollow(FOLLOW_12);
            rule__ValueReferenceRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ValueReferenceRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueReferenceRule__Group__0"


    // $ANTLR start "rule__ValueReferenceRule__Group__0__Impl"
    // InternalDefinitionLanguage.g:2993:1: rule__ValueReferenceRule__Group__0__Impl : ( () ) ;
    public final void rule__ValueReferenceRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2997:1: ( ( () ) )
            // InternalDefinitionLanguage.g:2998:1: ( () )
            {
            // InternalDefinitionLanguage.g:2998:1: ( () )
            // InternalDefinitionLanguage.g:2999:2: ()
            {
             before(grammarAccess.getValueReferenceRuleAccess().getValueReferenceAction_0()); 
            // InternalDefinitionLanguage.g:3000:2: ()
            // InternalDefinitionLanguage.g:3000:3: 
            {
            }

             after(grammarAccess.getValueReferenceRuleAccess().getValueReferenceAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueReferenceRule__Group__0__Impl"


    // $ANTLR start "rule__ValueReferenceRule__Group__1"
    // InternalDefinitionLanguage.g:3008:1: rule__ValueReferenceRule__Group__1 : rule__ValueReferenceRule__Group__1__Impl ;
    public final void rule__ValueReferenceRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3012:1: ( rule__ValueReferenceRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:3013:2: rule__ValueReferenceRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ValueReferenceRule__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueReferenceRule__Group__1"


    // $ANTLR start "rule__ValueReferenceRule__Group__1__Impl"
    // InternalDefinitionLanguage.g:3019:1: rule__ValueReferenceRule__Group__1__Impl : ( 'value' ) ;
    public final void rule__ValueReferenceRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3023:1: ( ( 'value' ) )
            // InternalDefinitionLanguage.g:3024:1: ( 'value' )
            {
            // InternalDefinitionLanguage.g:3024:1: ( 'value' )
            // InternalDefinitionLanguage.g:3025:2: 'value'
            {
             before(grammarAccess.getValueReferenceRuleAccess().getValueKeyword_1()); 
            match(input,59,FOLLOW_2); 
             after(grammarAccess.getValueReferenceRuleAccess().getValueKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueReferenceRule__Group__1__Impl"


    // $ANTLR start "rule__DoubleLiteralRule__Group__0"
    // InternalDefinitionLanguage.g:3035:1: rule__DoubleLiteralRule__Group__0 : rule__DoubleLiteralRule__Group__0__Impl rule__DoubleLiteralRule__Group__1 ;
    public final void rule__DoubleLiteralRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3039:1: ( rule__DoubleLiteralRule__Group__0__Impl rule__DoubleLiteralRule__Group__1 )
            // InternalDefinitionLanguage.g:3040:2: rule__DoubleLiteralRule__Group__0__Impl rule__DoubleLiteralRule__Group__1
            {
            pushFollow(FOLLOW_29);
            rule__DoubleLiteralRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DoubleLiteralRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DoubleLiteralRule__Group__0"


    // $ANTLR start "rule__DoubleLiteralRule__Group__0__Impl"
    // InternalDefinitionLanguage.g:3047:1: rule__DoubleLiteralRule__Group__0__Impl : ( ( rule__DoubleLiteralRule__LiteralAssignment_0 ) ) ;
    public final void rule__DoubleLiteralRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3051:1: ( ( ( rule__DoubleLiteralRule__LiteralAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:3052:1: ( ( rule__DoubleLiteralRule__LiteralAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:3052:1: ( ( rule__DoubleLiteralRule__LiteralAssignment_0 ) )
            // InternalDefinitionLanguage.g:3053:2: ( rule__DoubleLiteralRule__LiteralAssignment_0 )
            {
             before(grammarAccess.getDoubleLiteralRuleAccess().getLiteralAssignment_0()); 
            // InternalDefinitionLanguage.g:3054:2: ( rule__DoubleLiteralRule__LiteralAssignment_0 )
            // InternalDefinitionLanguage.g:3054:3: rule__DoubleLiteralRule__LiteralAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__DoubleLiteralRule__LiteralAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getDoubleLiteralRuleAccess().getLiteralAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DoubleLiteralRule__Group__0__Impl"


    // $ANTLR start "rule__DoubleLiteralRule__Group__1"
    // InternalDefinitionLanguage.g:3062:1: rule__DoubleLiteralRule__Group__1 : rule__DoubleLiteralRule__Group__1__Impl ;
    public final void rule__DoubleLiteralRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3066:1: ( rule__DoubleLiteralRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:3067:2: rule__DoubleLiteralRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DoubleLiteralRule__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DoubleLiteralRule__Group__1"


    // $ANTLR start "rule__DoubleLiteralRule__Group__1__Impl"
    // InternalDefinitionLanguage.g:3073:1: rule__DoubleLiteralRule__Group__1__Impl : ( ( rule__DoubleLiteralRule__FactorAssignment_1 )? ) ;
    public final void rule__DoubleLiteralRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3077:1: ( ( ( rule__DoubleLiteralRule__FactorAssignment_1 )? ) )
            // InternalDefinitionLanguage.g:3078:1: ( ( rule__DoubleLiteralRule__FactorAssignment_1 )? )
            {
            // InternalDefinitionLanguage.g:3078:1: ( ( rule__DoubleLiteralRule__FactorAssignment_1 )? )
            // InternalDefinitionLanguage.g:3079:2: ( rule__DoubleLiteralRule__FactorAssignment_1 )?
            {
             before(grammarAccess.getDoubleLiteralRuleAccess().getFactorAssignment_1()); 
            // InternalDefinitionLanguage.g:3080:2: ( rule__DoubleLiteralRule__FactorAssignment_1 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( ((LA25_0>=27 && LA25_0<=46)) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalDefinitionLanguage.g:3080:3: rule__DoubleLiteralRule__FactorAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__DoubleLiteralRule__FactorAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDoubleLiteralRuleAccess().getFactorAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DoubleLiteralRule__Group__1__Impl"


    // $ANTLR start "rule__IntegerLiteralRule__Group__0"
    // InternalDefinitionLanguage.g:3089:1: rule__IntegerLiteralRule__Group__0 : rule__IntegerLiteralRule__Group__0__Impl rule__IntegerLiteralRule__Group__1 ;
    public final void rule__IntegerLiteralRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3093:1: ( rule__IntegerLiteralRule__Group__0__Impl rule__IntegerLiteralRule__Group__1 )
            // InternalDefinitionLanguage.g:3094:2: rule__IntegerLiteralRule__Group__0__Impl rule__IntegerLiteralRule__Group__1
            {
            pushFollow(FOLLOW_29);
            rule__IntegerLiteralRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IntegerLiteralRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntegerLiteralRule__Group__0"


    // $ANTLR start "rule__IntegerLiteralRule__Group__0__Impl"
    // InternalDefinitionLanguage.g:3101:1: rule__IntegerLiteralRule__Group__0__Impl : ( ( rule__IntegerLiteralRule__LiteralAssignment_0 ) ) ;
    public final void rule__IntegerLiteralRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3105:1: ( ( ( rule__IntegerLiteralRule__LiteralAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:3106:1: ( ( rule__IntegerLiteralRule__LiteralAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:3106:1: ( ( rule__IntegerLiteralRule__LiteralAssignment_0 ) )
            // InternalDefinitionLanguage.g:3107:2: ( rule__IntegerLiteralRule__LiteralAssignment_0 )
            {
             before(grammarAccess.getIntegerLiteralRuleAccess().getLiteralAssignment_0()); 
            // InternalDefinitionLanguage.g:3108:2: ( rule__IntegerLiteralRule__LiteralAssignment_0 )
            // InternalDefinitionLanguage.g:3108:3: rule__IntegerLiteralRule__LiteralAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__IntegerLiteralRule__LiteralAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getIntegerLiteralRuleAccess().getLiteralAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntegerLiteralRule__Group__0__Impl"


    // $ANTLR start "rule__IntegerLiteralRule__Group__1"
    // InternalDefinitionLanguage.g:3116:1: rule__IntegerLiteralRule__Group__1 : rule__IntegerLiteralRule__Group__1__Impl ;
    public final void rule__IntegerLiteralRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3120:1: ( rule__IntegerLiteralRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:3121:2: rule__IntegerLiteralRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__IntegerLiteralRule__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntegerLiteralRule__Group__1"


    // $ANTLR start "rule__IntegerLiteralRule__Group__1__Impl"
    // InternalDefinitionLanguage.g:3127:1: rule__IntegerLiteralRule__Group__1__Impl : ( ( rule__IntegerLiteralRule__FactorAssignment_1 )? ) ;
    public final void rule__IntegerLiteralRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3131:1: ( ( ( rule__IntegerLiteralRule__FactorAssignment_1 )? ) )
            // InternalDefinitionLanguage.g:3132:1: ( ( rule__IntegerLiteralRule__FactorAssignment_1 )? )
            {
            // InternalDefinitionLanguage.g:3132:1: ( ( rule__IntegerLiteralRule__FactorAssignment_1 )? )
            // InternalDefinitionLanguage.g:3133:2: ( rule__IntegerLiteralRule__FactorAssignment_1 )?
            {
             before(grammarAccess.getIntegerLiteralRuleAccess().getFactorAssignment_1()); 
            // InternalDefinitionLanguage.g:3134:2: ( rule__IntegerLiteralRule__FactorAssignment_1 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( ((LA26_0>=27 && LA26_0<=46)) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalDefinitionLanguage.g:3134:3: rule__IntegerLiteralRule__FactorAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__IntegerLiteralRule__FactorAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getIntegerLiteralRuleAccess().getFactorAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntegerLiteralRule__Group__1__Impl"


    // $ANTLR start "rule__BooleanLiteralRule__Group__0"
    // InternalDefinitionLanguage.g:3143:1: rule__BooleanLiteralRule__Group__0 : rule__BooleanLiteralRule__Group__0__Impl rule__BooleanLiteralRule__Group__1 ;
    public final void rule__BooleanLiteralRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3147:1: ( rule__BooleanLiteralRule__Group__0__Impl rule__BooleanLiteralRule__Group__1 )
            // InternalDefinitionLanguage.g:3148:2: rule__BooleanLiteralRule__Group__0__Impl rule__BooleanLiteralRule__Group__1
            {
            pushFollow(FOLLOW_30);
            rule__BooleanLiteralRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BooleanLiteralRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanLiteralRule__Group__0"


    // $ANTLR start "rule__BooleanLiteralRule__Group__0__Impl"
    // InternalDefinitionLanguage.g:3155:1: rule__BooleanLiteralRule__Group__0__Impl : ( () ) ;
    public final void rule__BooleanLiteralRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3159:1: ( ( () ) )
            // InternalDefinitionLanguage.g:3160:1: ( () )
            {
            // InternalDefinitionLanguage.g:3160:1: ( () )
            // InternalDefinitionLanguage.g:3161:2: ()
            {
             before(grammarAccess.getBooleanLiteralRuleAccess().getBooleanLiteralAction_0()); 
            // InternalDefinitionLanguage.g:3162:2: ()
            // InternalDefinitionLanguage.g:3162:3: 
            {
            }

             after(grammarAccess.getBooleanLiteralRuleAccess().getBooleanLiteralAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanLiteralRule__Group__0__Impl"


    // $ANTLR start "rule__BooleanLiteralRule__Group__1"
    // InternalDefinitionLanguage.g:3170:1: rule__BooleanLiteralRule__Group__1 : rule__BooleanLiteralRule__Group__1__Impl ;
    public final void rule__BooleanLiteralRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3174:1: ( rule__BooleanLiteralRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:3175:2: rule__BooleanLiteralRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__BooleanLiteralRule__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanLiteralRule__Group__1"


    // $ANTLR start "rule__BooleanLiteralRule__Group__1__Impl"
    // InternalDefinitionLanguage.g:3181:1: rule__BooleanLiteralRule__Group__1__Impl : ( ( rule__BooleanLiteralRule__Alternatives_1 ) ) ;
    public final void rule__BooleanLiteralRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3185:1: ( ( ( rule__BooleanLiteralRule__Alternatives_1 ) ) )
            // InternalDefinitionLanguage.g:3186:1: ( ( rule__BooleanLiteralRule__Alternatives_1 ) )
            {
            // InternalDefinitionLanguage.g:3186:1: ( ( rule__BooleanLiteralRule__Alternatives_1 ) )
            // InternalDefinitionLanguage.g:3187:2: ( rule__BooleanLiteralRule__Alternatives_1 )
            {
             before(grammarAccess.getBooleanLiteralRuleAccess().getAlternatives_1()); 
            // InternalDefinitionLanguage.g:3188:2: ( rule__BooleanLiteralRule__Alternatives_1 )
            // InternalDefinitionLanguage.g:3188:3: rule__BooleanLiteralRule__Alternatives_1
            {
            pushFollow(FOLLOW_2);
            rule__BooleanLiteralRule__Alternatives_1();

            state._fsp--;


            }

             after(grammarAccess.getBooleanLiteralRuleAccess().getAlternatives_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanLiteralRule__Group__1__Impl"


    // $ANTLR start "rule__TypeDefinitionRule__Group__0"
    // InternalDefinitionLanguage.g:3197:1: rule__TypeDefinitionRule__Group__0 : rule__TypeDefinitionRule__Group__0__Impl rule__TypeDefinitionRule__Group__1 ;
    public final void rule__TypeDefinitionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3201:1: ( rule__TypeDefinitionRule__Group__0__Impl rule__TypeDefinitionRule__Group__1 )
            // InternalDefinitionLanguage.g:3202:2: rule__TypeDefinitionRule__Group__0__Impl rule__TypeDefinitionRule__Group__1
            {
            pushFollow(FOLLOW_31);
            rule__TypeDefinitionRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TypeDefinitionRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeDefinitionRule__Group__0"


    // $ANTLR start "rule__TypeDefinitionRule__Group__0__Impl"
    // InternalDefinitionLanguage.g:3209:1: rule__TypeDefinitionRule__Group__0__Impl : ( ( rule__TypeDefinitionRule__AbstractAssignment_0 )? ) ;
    public final void rule__TypeDefinitionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3213:1: ( ( ( rule__TypeDefinitionRule__AbstractAssignment_0 )? ) )
            // InternalDefinitionLanguage.g:3214:1: ( ( rule__TypeDefinitionRule__AbstractAssignment_0 )? )
            {
            // InternalDefinitionLanguage.g:3214:1: ( ( rule__TypeDefinitionRule__AbstractAssignment_0 )? )
            // InternalDefinitionLanguage.g:3215:2: ( rule__TypeDefinitionRule__AbstractAssignment_0 )?
            {
             before(grammarAccess.getTypeDefinitionRuleAccess().getAbstractAssignment_0()); 
            // InternalDefinitionLanguage.g:3216:2: ( rule__TypeDefinitionRule__AbstractAssignment_0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==79) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalDefinitionLanguage.g:3216:3: rule__TypeDefinitionRule__AbstractAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TypeDefinitionRule__AbstractAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTypeDefinitionRuleAccess().getAbstractAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeDefinitionRule__Group__0__Impl"


    // $ANTLR start "rule__TypeDefinitionRule__Group__1"
    // InternalDefinitionLanguage.g:3224:1: rule__TypeDefinitionRule__Group__1 : rule__TypeDefinitionRule__Group__1__Impl rule__TypeDefinitionRule__Group__2 ;
    public final void rule__TypeDefinitionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3228:1: ( rule__TypeDefinitionRule__Group__1__Impl rule__TypeDefinitionRule__Group__2 )
            // InternalDefinitionLanguage.g:3229:2: rule__TypeDefinitionRule__Group__1__Impl rule__TypeDefinitionRule__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__TypeDefinitionRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TypeDefinitionRule__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeDefinitionRule__Group__1"


    // $ANTLR start "rule__TypeDefinitionRule__Group__1__Impl"
    // InternalDefinitionLanguage.g:3236:1: rule__TypeDefinitionRule__Group__1__Impl : ( 'type' ) ;
    public final void rule__TypeDefinitionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3240:1: ( ( 'type' ) )
            // InternalDefinitionLanguage.g:3241:1: ( 'type' )
            {
            // InternalDefinitionLanguage.g:3241:1: ( 'type' )
            // InternalDefinitionLanguage.g:3242:2: 'type'
            {
             before(grammarAccess.getTypeDefinitionRuleAccess().getTypeKeyword_1()); 
            match(input,60,FOLLOW_2); 
             after(grammarAccess.getTypeDefinitionRuleAccess().getTypeKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeDefinitionRule__Group__1__Impl"


    // $ANTLR start "rule__TypeDefinitionRule__Group__2"
    // InternalDefinitionLanguage.g:3251:1: rule__TypeDefinitionRule__Group__2 : rule__TypeDefinitionRule__Group__2__Impl rule__TypeDefinitionRule__Group__3 ;
    public final void rule__TypeDefinitionRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3255:1: ( rule__TypeDefinitionRule__Group__2__Impl rule__TypeDefinitionRule__Group__3 )
            // InternalDefinitionLanguage.g:3256:2: rule__TypeDefinitionRule__Group__2__Impl rule__TypeDefinitionRule__Group__3
            {
            pushFollow(FOLLOW_32);
            rule__TypeDefinitionRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TypeDefinitionRule__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeDefinitionRule__Group__2"


    // $ANTLR start "rule__TypeDefinitionRule__Group__2__Impl"
    // InternalDefinitionLanguage.g:3263:1: rule__TypeDefinitionRule__Group__2__Impl : ( ( rule__TypeDefinitionRule__NameAssignment_2 ) ) ;
    public final void rule__TypeDefinitionRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3267:1: ( ( ( rule__TypeDefinitionRule__NameAssignment_2 ) ) )
            // InternalDefinitionLanguage.g:3268:1: ( ( rule__TypeDefinitionRule__NameAssignment_2 ) )
            {
            // InternalDefinitionLanguage.g:3268:1: ( ( rule__TypeDefinitionRule__NameAssignment_2 ) )
            // InternalDefinitionLanguage.g:3269:2: ( rule__TypeDefinitionRule__NameAssignment_2 )
            {
             before(grammarAccess.getTypeDefinitionRuleAccess().getNameAssignment_2()); 
            // InternalDefinitionLanguage.g:3270:2: ( rule__TypeDefinitionRule__NameAssignment_2 )
            // InternalDefinitionLanguage.g:3270:3: rule__TypeDefinitionRule__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__TypeDefinitionRule__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getTypeDefinitionRuleAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeDefinitionRule__Group__2__Impl"


    // $ANTLR start "rule__TypeDefinitionRule__Group__3"
    // InternalDefinitionLanguage.g:3278:1: rule__TypeDefinitionRule__Group__3 : rule__TypeDefinitionRule__Group__3__Impl rule__TypeDefinitionRule__Group__4 ;
    public final void rule__TypeDefinitionRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3282:1: ( rule__TypeDefinitionRule__Group__3__Impl rule__TypeDefinitionRule__Group__4 )
            // InternalDefinitionLanguage.g:3283:2: rule__TypeDefinitionRule__Group__3__Impl rule__TypeDefinitionRule__Group__4
            {
            pushFollow(FOLLOW_32);
            rule__TypeDefinitionRule__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TypeDefinitionRule__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeDefinitionRule__Group__3"


    // $ANTLR start "rule__TypeDefinitionRule__Group__3__Impl"
    // InternalDefinitionLanguage.g:3290:1: rule__TypeDefinitionRule__Group__3__Impl : ( ( rule__TypeDefinitionRule__Group_3__0 )? ) ;
    public final void rule__TypeDefinitionRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3294:1: ( ( ( rule__TypeDefinitionRule__Group_3__0 )? ) )
            // InternalDefinitionLanguage.g:3295:1: ( ( rule__TypeDefinitionRule__Group_3__0 )? )
            {
            // InternalDefinitionLanguage.g:3295:1: ( ( rule__TypeDefinitionRule__Group_3__0 )? )
            // InternalDefinitionLanguage.g:3296:2: ( rule__TypeDefinitionRule__Group_3__0 )?
            {
             before(grammarAccess.getTypeDefinitionRuleAccess().getGroup_3()); 
            // InternalDefinitionLanguage.g:3297:2: ( rule__TypeDefinitionRule__Group_3__0 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==61) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalDefinitionLanguage.g:3297:3: rule__TypeDefinitionRule__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TypeDefinitionRule__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTypeDefinitionRuleAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeDefinitionRule__Group__3__Impl"


    // $ANTLR start "rule__TypeDefinitionRule__Group__4"
    // InternalDefinitionLanguage.g:3305:1: rule__TypeDefinitionRule__Group__4 : rule__TypeDefinitionRule__Group__4__Impl rule__TypeDefinitionRule__Group__5 ;
    public final void rule__TypeDefinitionRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3309:1: ( rule__TypeDefinitionRule__Group__4__Impl rule__TypeDefinitionRule__Group__5 )
            // InternalDefinitionLanguage.g:3310:2: rule__TypeDefinitionRule__Group__4__Impl rule__TypeDefinitionRule__Group__5
            {
            pushFollow(FOLLOW_33);
            rule__TypeDefinitionRule__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TypeDefinitionRule__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeDefinitionRule__Group__4"


    // $ANTLR start "rule__TypeDefinitionRule__Group__4__Impl"
    // InternalDefinitionLanguage.g:3317:1: rule__TypeDefinitionRule__Group__4__Impl : ( '{' ) ;
    public final void rule__TypeDefinitionRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3321:1: ( ( '{' ) )
            // InternalDefinitionLanguage.g:3322:1: ( '{' )
            {
            // InternalDefinitionLanguage.g:3322:1: ( '{' )
            // InternalDefinitionLanguage.g:3323:2: '{'
            {
             before(grammarAccess.getTypeDefinitionRuleAccess().getLeftCurlyBracketKeyword_4()); 
            match(input,48,FOLLOW_2); 
             after(grammarAccess.getTypeDefinitionRuleAccess().getLeftCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeDefinitionRule__Group__4__Impl"


    // $ANTLR start "rule__TypeDefinitionRule__Group__5"
    // InternalDefinitionLanguage.g:3332:1: rule__TypeDefinitionRule__Group__5 : rule__TypeDefinitionRule__Group__5__Impl rule__TypeDefinitionRule__Group__6 ;
    public final void rule__TypeDefinitionRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3336:1: ( rule__TypeDefinitionRule__Group__5__Impl rule__TypeDefinitionRule__Group__6 )
            // InternalDefinitionLanguage.g:3337:2: rule__TypeDefinitionRule__Group__5__Impl rule__TypeDefinitionRule__Group__6
            {
            pushFollow(FOLLOW_33);
            rule__TypeDefinitionRule__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TypeDefinitionRule__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeDefinitionRule__Group__5"


    // $ANTLR start "rule__TypeDefinitionRule__Group__5__Impl"
    // InternalDefinitionLanguage.g:3344:1: rule__TypeDefinitionRule__Group__5__Impl : ( ( rule__TypeDefinitionRule__AttributesAssignment_5 )* ) ;
    public final void rule__TypeDefinitionRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3348:1: ( ( ( rule__TypeDefinitionRule__AttributesAssignment_5 )* ) )
            // InternalDefinitionLanguage.g:3349:1: ( ( rule__TypeDefinitionRule__AttributesAssignment_5 )* )
            {
            // InternalDefinitionLanguage.g:3349:1: ( ( rule__TypeDefinitionRule__AttributesAssignment_5 )* )
            // InternalDefinitionLanguage.g:3350:2: ( rule__TypeDefinitionRule__AttributesAssignment_5 )*
            {
             before(grammarAccess.getTypeDefinitionRuleAccess().getAttributesAssignment_5()); 
            // InternalDefinitionLanguage.g:3351:2: ( rule__TypeDefinitionRule__AttributesAssignment_5 )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( ((LA29_0>=RULE_QUOTED_ID && LA29_0<=RULE_ID)) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:3351:3: rule__TypeDefinitionRule__AttributesAssignment_5
            	    {
            	    pushFollow(FOLLOW_34);
            	    rule__TypeDefinitionRule__AttributesAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

             after(grammarAccess.getTypeDefinitionRuleAccess().getAttributesAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeDefinitionRule__Group__5__Impl"


    // $ANTLR start "rule__TypeDefinitionRule__Group__6"
    // InternalDefinitionLanguage.g:3359:1: rule__TypeDefinitionRule__Group__6 : rule__TypeDefinitionRule__Group__6__Impl ;
    public final void rule__TypeDefinitionRule__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3363:1: ( rule__TypeDefinitionRule__Group__6__Impl )
            // InternalDefinitionLanguage.g:3364:2: rule__TypeDefinitionRule__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TypeDefinitionRule__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeDefinitionRule__Group__6"


    // $ANTLR start "rule__TypeDefinitionRule__Group__6__Impl"
    // InternalDefinitionLanguage.g:3370:1: rule__TypeDefinitionRule__Group__6__Impl : ( '}' ) ;
    public final void rule__TypeDefinitionRule__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3374:1: ( ( '}' ) )
            // InternalDefinitionLanguage.g:3375:1: ( '}' )
            {
            // InternalDefinitionLanguage.g:3375:1: ( '}' )
            // InternalDefinitionLanguage.g:3376:2: '}'
            {
             before(grammarAccess.getTypeDefinitionRuleAccess().getRightCurlyBracketKeyword_6()); 
            match(input,49,FOLLOW_2); 
             after(grammarAccess.getTypeDefinitionRuleAccess().getRightCurlyBracketKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeDefinitionRule__Group__6__Impl"


    // $ANTLR start "rule__TypeDefinitionRule__Group_3__0"
    // InternalDefinitionLanguage.g:3386:1: rule__TypeDefinitionRule__Group_3__0 : rule__TypeDefinitionRule__Group_3__0__Impl rule__TypeDefinitionRule__Group_3__1 ;
    public final void rule__TypeDefinitionRule__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3390:1: ( rule__TypeDefinitionRule__Group_3__0__Impl rule__TypeDefinitionRule__Group_3__1 )
            // InternalDefinitionLanguage.g:3391:2: rule__TypeDefinitionRule__Group_3__0__Impl rule__TypeDefinitionRule__Group_3__1
            {
            pushFollow(FOLLOW_5);
            rule__TypeDefinitionRule__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TypeDefinitionRule__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeDefinitionRule__Group_3__0"


    // $ANTLR start "rule__TypeDefinitionRule__Group_3__0__Impl"
    // InternalDefinitionLanguage.g:3398:1: rule__TypeDefinitionRule__Group_3__0__Impl : ( 'extends' ) ;
    public final void rule__TypeDefinitionRule__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3402:1: ( ( 'extends' ) )
            // InternalDefinitionLanguage.g:3403:1: ( 'extends' )
            {
            // InternalDefinitionLanguage.g:3403:1: ( 'extends' )
            // InternalDefinitionLanguage.g:3404:2: 'extends'
            {
             before(grammarAccess.getTypeDefinitionRuleAccess().getExtendsKeyword_3_0()); 
            match(input,61,FOLLOW_2); 
             after(grammarAccess.getTypeDefinitionRuleAccess().getExtendsKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeDefinitionRule__Group_3__0__Impl"


    // $ANTLR start "rule__TypeDefinitionRule__Group_3__1"
    // InternalDefinitionLanguage.g:3413:1: rule__TypeDefinitionRule__Group_3__1 : rule__TypeDefinitionRule__Group_3__1__Impl ;
    public final void rule__TypeDefinitionRule__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3417:1: ( rule__TypeDefinitionRule__Group_3__1__Impl )
            // InternalDefinitionLanguage.g:3418:2: rule__TypeDefinitionRule__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TypeDefinitionRule__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeDefinitionRule__Group_3__1"


    // $ANTLR start "rule__TypeDefinitionRule__Group_3__1__Impl"
    // InternalDefinitionLanguage.g:3424:1: rule__TypeDefinitionRule__Group_3__1__Impl : ( ( rule__TypeDefinitionRule__SuperTypeAssignment_3_1 ) ) ;
    public final void rule__TypeDefinitionRule__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3428:1: ( ( ( rule__TypeDefinitionRule__SuperTypeAssignment_3_1 ) ) )
            // InternalDefinitionLanguage.g:3429:1: ( ( rule__TypeDefinitionRule__SuperTypeAssignment_3_1 ) )
            {
            // InternalDefinitionLanguage.g:3429:1: ( ( rule__TypeDefinitionRule__SuperTypeAssignment_3_1 ) )
            // InternalDefinitionLanguage.g:3430:2: ( rule__TypeDefinitionRule__SuperTypeAssignment_3_1 )
            {
             before(grammarAccess.getTypeDefinitionRuleAccess().getSuperTypeAssignment_3_1()); 
            // InternalDefinitionLanguage.g:3431:2: ( rule__TypeDefinitionRule__SuperTypeAssignment_3_1 )
            // InternalDefinitionLanguage.g:3431:3: rule__TypeDefinitionRule__SuperTypeAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__TypeDefinitionRule__SuperTypeAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getTypeDefinitionRuleAccess().getSuperTypeAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeDefinitionRule__Group_3__1__Impl"


    // $ANTLR start "rule__AttributeDefinitionRule__Group__0"
    // InternalDefinitionLanguage.g:3440:1: rule__AttributeDefinitionRule__Group__0 : rule__AttributeDefinitionRule__Group__0__Impl rule__AttributeDefinitionRule__Group__1 ;
    public final void rule__AttributeDefinitionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3444:1: ( rule__AttributeDefinitionRule__Group__0__Impl rule__AttributeDefinitionRule__Group__1 )
            // InternalDefinitionLanguage.g:3445:2: rule__AttributeDefinitionRule__Group__0__Impl rule__AttributeDefinitionRule__Group__1
            {
            pushFollow(FOLLOW_35);
            rule__AttributeDefinitionRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AttributeDefinitionRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeDefinitionRule__Group__0"


    // $ANTLR start "rule__AttributeDefinitionRule__Group__0__Impl"
    // InternalDefinitionLanguage.g:3452:1: rule__AttributeDefinitionRule__Group__0__Impl : ( ( rule__AttributeDefinitionRule__NameAssignment_0 ) ) ;
    public final void rule__AttributeDefinitionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3456:1: ( ( ( rule__AttributeDefinitionRule__NameAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:3457:1: ( ( rule__AttributeDefinitionRule__NameAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:3457:1: ( ( rule__AttributeDefinitionRule__NameAssignment_0 ) )
            // InternalDefinitionLanguage.g:3458:2: ( rule__AttributeDefinitionRule__NameAssignment_0 )
            {
             before(grammarAccess.getAttributeDefinitionRuleAccess().getNameAssignment_0()); 
            // InternalDefinitionLanguage.g:3459:2: ( rule__AttributeDefinitionRule__NameAssignment_0 )
            // InternalDefinitionLanguage.g:3459:3: rule__AttributeDefinitionRule__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__AttributeDefinitionRule__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getAttributeDefinitionRuleAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeDefinitionRule__Group__0__Impl"


    // $ANTLR start "rule__AttributeDefinitionRule__Group__1"
    // InternalDefinitionLanguage.g:3467:1: rule__AttributeDefinitionRule__Group__1 : rule__AttributeDefinitionRule__Group__1__Impl rule__AttributeDefinitionRule__Group__2 ;
    public final void rule__AttributeDefinitionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3471:1: ( rule__AttributeDefinitionRule__Group__1__Impl rule__AttributeDefinitionRule__Group__2 )
            // InternalDefinitionLanguage.g:3472:2: rule__AttributeDefinitionRule__Group__1__Impl rule__AttributeDefinitionRule__Group__2
            {
            pushFollow(FOLLOW_36);
            rule__AttributeDefinitionRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AttributeDefinitionRule__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeDefinitionRule__Group__1"


    // $ANTLR start "rule__AttributeDefinitionRule__Group__1__Impl"
    // InternalDefinitionLanguage.g:3479:1: rule__AttributeDefinitionRule__Group__1__Impl : ( ':' ) ;
    public final void rule__AttributeDefinitionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3483:1: ( ( ':' ) )
            // InternalDefinitionLanguage.g:3484:1: ( ':' )
            {
            // InternalDefinitionLanguage.g:3484:1: ( ':' )
            // InternalDefinitionLanguage.g:3485:2: ':'
            {
             before(grammarAccess.getAttributeDefinitionRuleAccess().getColonKeyword_1()); 
            match(input,62,FOLLOW_2); 
             after(grammarAccess.getAttributeDefinitionRuleAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeDefinitionRule__Group__1__Impl"


    // $ANTLR start "rule__AttributeDefinitionRule__Group__2"
    // InternalDefinitionLanguage.g:3494:1: rule__AttributeDefinitionRule__Group__2 : rule__AttributeDefinitionRule__Group__2__Impl rule__AttributeDefinitionRule__Group__3 ;
    public final void rule__AttributeDefinitionRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3498:1: ( rule__AttributeDefinitionRule__Group__2__Impl rule__AttributeDefinitionRule__Group__3 )
            // InternalDefinitionLanguage.g:3499:2: rule__AttributeDefinitionRule__Group__2__Impl rule__AttributeDefinitionRule__Group__3
            {
            pushFollow(FOLLOW_37);
            rule__AttributeDefinitionRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AttributeDefinitionRule__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeDefinitionRule__Group__2"


    // $ANTLR start "rule__AttributeDefinitionRule__Group__2__Impl"
    // InternalDefinitionLanguage.g:3506:1: rule__AttributeDefinitionRule__Group__2__Impl : ( ( rule__AttributeDefinitionRule__TypeAssignment_2 ) ) ;
    public final void rule__AttributeDefinitionRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3510:1: ( ( ( rule__AttributeDefinitionRule__TypeAssignment_2 ) ) )
            // InternalDefinitionLanguage.g:3511:1: ( ( rule__AttributeDefinitionRule__TypeAssignment_2 ) )
            {
            // InternalDefinitionLanguage.g:3511:1: ( ( rule__AttributeDefinitionRule__TypeAssignment_2 ) )
            // InternalDefinitionLanguage.g:3512:2: ( rule__AttributeDefinitionRule__TypeAssignment_2 )
            {
             before(grammarAccess.getAttributeDefinitionRuleAccess().getTypeAssignment_2()); 
            // InternalDefinitionLanguage.g:3513:2: ( rule__AttributeDefinitionRule__TypeAssignment_2 )
            // InternalDefinitionLanguage.g:3513:3: rule__AttributeDefinitionRule__TypeAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__AttributeDefinitionRule__TypeAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getAttributeDefinitionRuleAccess().getTypeAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeDefinitionRule__Group__2__Impl"


    // $ANTLR start "rule__AttributeDefinitionRule__Group__3"
    // InternalDefinitionLanguage.g:3521:1: rule__AttributeDefinitionRule__Group__3 : rule__AttributeDefinitionRule__Group__3__Impl rule__AttributeDefinitionRule__Group__4 ;
    public final void rule__AttributeDefinitionRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3525:1: ( rule__AttributeDefinitionRule__Group__3__Impl rule__AttributeDefinitionRule__Group__4 )
            // InternalDefinitionLanguage.g:3526:2: rule__AttributeDefinitionRule__Group__3__Impl rule__AttributeDefinitionRule__Group__4
            {
            pushFollow(FOLLOW_37);
            rule__AttributeDefinitionRule__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AttributeDefinitionRule__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeDefinitionRule__Group__3"


    // $ANTLR start "rule__AttributeDefinitionRule__Group__3__Impl"
    // InternalDefinitionLanguage.g:3533:1: rule__AttributeDefinitionRule__Group__3__Impl : ( ( rule__AttributeDefinitionRule__Group_3__0 )? ) ;
    public final void rule__AttributeDefinitionRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3537:1: ( ( ( rule__AttributeDefinitionRule__Group_3__0 )? ) )
            // InternalDefinitionLanguage.g:3538:1: ( ( rule__AttributeDefinitionRule__Group_3__0 )? )
            {
            // InternalDefinitionLanguage.g:3538:1: ( ( rule__AttributeDefinitionRule__Group_3__0 )? )
            // InternalDefinitionLanguage.g:3539:2: ( rule__AttributeDefinitionRule__Group_3__0 )?
            {
             before(grammarAccess.getAttributeDefinitionRuleAccess().getGroup_3()); 
            // InternalDefinitionLanguage.g:3540:2: ( rule__AttributeDefinitionRule__Group_3__0 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==63) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalDefinitionLanguage.g:3540:3: rule__AttributeDefinitionRule__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__AttributeDefinitionRule__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAttributeDefinitionRuleAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeDefinitionRule__Group__3__Impl"


    // $ANTLR start "rule__AttributeDefinitionRule__Group__4"
    // InternalDefinitionLanguage.g:3548:1: rule__AttributeDefinitionRule__Group__4 : rule__AttributeDefinitionRule__Group__4__Impl ;
    public final void rule__AttributeDefinitionRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3552:1: ( rule__AttributeDefinitionRule__Group__4__Impl )
            // InternalDefinitionLanguage.g:3553:2: rule__AttributeDefinitionRule__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AttributeDefinitionRule__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeDefinitionRule__Group__4"


    // $ANTLR start "rule__AttributeDefinitionRule__Group__4__Impl"
    // InternalDefinitionLanguage.g:3559:1: rule__AttributeDefinitionRule__Group__4__Impl : ( ';' ) ;
    public final void rule__AttributeDefinitionRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3563:1: ( ( ';' ) )
            // InternalDefinitionLanguage.g:3564:1: ( ';' )
            {
            // InternalDefinitionLanguage.g:3564:1: ( ';' )
            // InternalDefinitionLanguage.g:3565:2: ';'
            {
             before(grammarAccess.getAttributeDefinitionRuleAccess().getSemicolonKeyword_4()); 
            match(input,51,FOLLOW_2); 
             after(grammarAccess.getAttributeDefinitionRuleAccess().getSemicolonKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeDefinitionRule__Group__4__Impl"


    // $ANTLR start "rule__AttributeDefinitionRule__Group_3__0"
    // InternalDefinitionLanguage.g:3575:1: rule__AttributeDefinitionRule__Group_3__0 : rule__AttributeDefinitionRule__Group_3__0__Impl rule__AttributeDefinitionRule__Group_3__1 ;
    public final void rule__AttributeDefinitionRule__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3579:1: ( rule__AttributeDefinitionRule__Group_3__0__Impl rule__AttributeDefinitionRule__Group_3__1 )
            // InternalDefinitionLanguage.g:3580:2: rule__AttributeDefinitionRule__Group_3__0__Impl rule__AttributeDefinitionRule__Group_3__1
            {
            pushFollow(FOLLOW_12);
            rule__AttributeDefinitionRule__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AttributeDefinitionRule__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeDefinitionRule__Group_3__0"


    // $ANTLR start "rule__AttributeDefinitionRule__Group_3__0__Impl"
    // InternalDefinitionLanguage.g:3587:1: rule__AttributeDefinitionRule__Group_3__0__Impl : ( ':=' ) ;
    public final void rule__AttributeDefinitionRule__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3591:1: ( ( ':=' ) )
            // InternalDefinitionLanguage.g:3592:1: ( ':=' )
            {
            // InternalDefinitionLanguage.g:3592:1: ( ':=' )
            // InternalDefinitionLanguage.g:3593:2: ':='
            {
             before(grammarAccess.getAttributeDefinitionRuleAccess().getColonEqualsSignKeyword_3_0()); 
            match(input,63,FOLLOW_2); 
             after(grammarAccess.getAttributeDefinitionRuleAccess().getColonEqualsSignKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeDefinitionRule__Group_3__0__Impl"


    // $ANTLR start "rule__AttributeDefinitionRule__Group_3__1"
    // InternalDefinitionLanguage.g:3602:1: rule__AttributeDefinitionRule__Group_3__1 : rule__AttributeDefinitionRule__Group_3__1__Impl ;
    public final void rule__AttributeDefinitionRule__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3606:1: ( rule__AttributeDefinitionRule__Group_3__1__Impl )
            // InternalDefinitionLanguage.g:3607:2: rule__AttributeDefinitionRule__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AttributeDefinitionRule__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeDefinitionRule__Group_3__1"


    // $ANTLR start "rule__AttributeDefinitionRule__Group_3__1__Impl"
    // InternalDefinitionLanguage.g:3613:1: rule__AttributeDefinitionRule__Group_3__1__Impl : ( ( rule__AttributeDefinitionRule__InitialisationAssignment_3_1 ) ) ;
    public final void rule__AttributeDefinitionRule__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3617:1: ( ( ( rule__AttributeDefinitionRule__InitialisationAssignment_3_1 ) ) )
            // InternalDefinitionLanguage.g:3618:1: ( ( rule__AttributeDefinitionRule__InitialisationAssignment_3_1 ) )
            {
            // InternalDefinitionLanguage.g:3618:1: ( ( rule__AttributeDefinitionRule__InitialisationAssignment_3_1 ) )
            // InternalDefinitionLanguage.g:3619:2: ( rule__AttributeDefinitionRule__InitialisationAssignment_3_1 )
            {
             before(grammarAccess.getAttributeDefinitionRuleAccess().getInitialisationAssignment_3_1()); 
            // InternalDefinitionLanguage.g:3620:2: ( rule__AttributeDefinitionRule__InitialisationAssignment_3_1 )
            // InternalDefinitionLanguage.g:3620:3: rule__AttributeDefinitionRule__InitialisationAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__AttributeDefinitionRule__InitialisationAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getAttributeDefinitionRuleAccess().getInitialisationAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeDefinitionRule__Group_3__1__Impl"


    // $ANTLR start "rule__LiteralTypeRule__Group__0"
    // InternalDefinitionLanguage.g:3629:1: rule__LiteralTypeRule__Group__0 : rule__LiteralTypeRule__Group__0__Impl rule__LiteralTypeRule__Group__1 ;
    public final void rule__LiteralTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3633:1: ( rule__LiteralTypeRule__Group__0__Impl rule__LiteralTypeRule__Group__1 )
            // InternalDefinitionLanguage.g:3634:2: rule__LiteralTypeRule__Group__0__Impl rule__LiteralTypeRule__Group__1
            {
            pushFollow(FOLLOW_38);
            rule__LiteralTypeRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LiteralTypeRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LiteralTypeRule__Group__0"


    // $ANTLR start "rule__LiteralTypeRule__Group__0__Impl"
    // InternalDefinitionLanguage.g:3641:1: rule__LiteralTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__LiteralTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3645:1: ( ( () ) )
            // InternalDefinitionLanguage.g:3646:1: ( () )
            {
            // InternalDefinitionLanguage.g:3646:1: ( () )
            // InternalDefinitionLanguage.g:3647:2: ()
            {
             before(grammarAccess.getLiteralTypeRuleAccess().getLiteralTypeAction_0()); 
            // InternalDefinitionLanguage.g:3648:2: ()
            // InternalDefinitionLanguage.g:3648:3: 
            {
            }

             after(grammarAccess.getLiteralTypeRuleAccess().getLiteralTypeAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LiteralTypeRule__Group__0__Impl"


    // $ANTLR start "rule__LiteralTypeRule__Group__1"
    // InternalDefinitionLanguage.g:3656:1: rule__LiteralTypeRule__Group__1 : rule__LiteralTypeRule__Group__1__Impl ;
    public final void rule__LiteralTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3660:1: ( rule__LiteralTypeRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:3661:2: rule__LiteralTypeRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__LiteralTypeRule__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LiteralTypeRule__Group__1"


    // $ANTLR start "rule__LiteralTypeRule__Group__1__Impl"
    // InternalDefinitionLanguage.g:3667:1: rule__LiteralTypeRule__Group__1__Impl : ( 'literal' ) ;
    public final void rule__LiteralTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3671:1: ( ( 'literal' ) )
            // InternalDefinitionLanguage.g:3672:1: ( 'literal' )
            {
            // InternalDefinitionLanguage.g:3672:1: ( 'literal' )
            // InternalDefinitionLanguage.g:3673:2: 'literal'
            {
             before(grammarAccess.getLiteralTypeRuleAccess().getLiteralKeyword_1()); 
            match(input,64,FOLLOW_2); 
             after(grammarAccess.getLiteralTypeRuleAccess().getLiteralKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LiteralTypeRule__Group__1__Impl"


    // $ANTLR start "rule__InstanceTypeRule__Group__0"
    // InternalDefinitionLanguage.g:3683:1: rule__InstanceTypeRule__Group__0 : rule__InstanceTypeRule__Group__0__Impl rule__InstanceTypeRule__Group__1 ;
    public final void rule__InstanceTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3687:1: ( rule__InstanceTypeRule__Group__0__Impl rule__InstanceTypeRule__Group__1 )
            // InternalDefinitionLanguage.g:3688:2: rule__InstanceTypeRule__Group__0__Impl rule__InstanceTypeRule__Group__1
            {
            pushFollow(FOLLOW_39);
            rule__InstanceTypeRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__InstanceTypeRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceTypeRule__Group__0"


    // $ANTLR start "rule__InstanceTypeRule__Group__0__Impl"
    // InternalDefinitionLanguage.g:3695:1: rule__InstanceTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__InstanceTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3699:1: ( ( () ) )
            // InternalDefinitionLanguage.g:3700:1: ( () )
            {
            // InternalDefinitionLanguage.g:3700:1: ( () )
            // InternalDefinitionLanguage.g:3701:2: ()
            {
             before(grammarAccess.getInstanceTypeRuleAccess().getInstanceTypeAction_0()); 
            // InternalDefinitionLanguage.g:3702:2: ()
            // InternalDefinitionLanguage.g:3702:3: 
            {
            }

             after(grammarAccess.getInstanceTypeRuleAccess().getInstanceTypeAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceTypeRule__Group__0__Impl"


    // $ANTLR start "rule__InstanceTypeRule__Group__1"
    // InternalDefinitionLanguage.g:3710:1: rule__InstanceTypeRule__Group__1 : rule__InstanceTypeRule__Group__1__Impl rule__InstanceTypeRule__Group__2 ;
    public final void rule__InstanceTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3714:1: ( rule__InstanceTypeRule__Group__1__Impl rule__InstanceTypeRule__Group__2 )
            // InternalDefinitionLanguage.g:3715:2: rule__InstanceTypeRule__Group__1__Impl rule__InstanceTypeRule__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__InstanceTypeRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__InstanceTypeRule__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceTypeRule__Group__1"


    // $ANTLR start "rule__InstanceTypeRule__Group__1__Impl"
    // InternalDefinitionLanguage.g:3722:1: rule__InstanceTypeRule__Group__1__Impl : ( 'instance' ) ;
    public final void rule__InstanceTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3726:1: ( ( 'instance' ) )
            // InternalDefinitionLanguage.g:3727:1: ( 'instance' )
            {
            // InternalDefinitionLanguage.g:3727:1: ( 'instance' )
            // InternalDefinitionLanguage.g:3728:2: 'instance'
            {
             before(grammarAccess.getInstanceTypeRuleAccess().getInstanceKeyword_1()); 
            match(input,65,FOLLOW_2); 
             after(grammarAccess.getInstanceTypeRuleAccess().getInstanceKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceTypeRule__Group__1__Impl"


    // $ANTLR start "rule__InstanceTypeRule__Group__2"
    // InternalDefinitionLanguage.g:3737:1: rule__InstanceTypeRule__Group__2 : rule__InstanceTypeRule__Group__2__Impl rule__InstanceTypeRule__Group__3 ;
    public final void rule__InstanceTypeRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3741:1: ( rule__InstanceTypeRule__Group__2__Impl rule__InstanceTypeRule__Group__3 )
            // InternalDefinitionLanguage.g:3742:2: rule__InstanceTypeRule__Group__2__Impl rule__InstanceTypeRule__Group__3
            {
            pushFollow(FOLLOW_40);
            rule__InstanceTypeRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__InstanceTypeRule__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceTypeRule__Group__2"


    // $ANTLR start "rule__InstanceTypeRule__Group__2__Impl"
    // InternalDefinitionLanguage.g:3749:1: rule__InstanceTypeRule__Group__2__Impl : ( ( rule__InstanceTypeRule__DefinitionsAssignment_2 ) ) ;
    public final void rule__InstanceTypeRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3753:1: ( ( ( rule__InstanceTypeRule__DefinitionsAssignment_2 ) ) )
            // InternalDefinitionLanguage.g:3754:1: ( ( rule__InstanceTypeRule__DefinitionsAssignment_2 ) )
            {
            // InternalDefinitionLanguage.g:3754:1: ( ( rule__InstanceTypeRule__DefinitionsAssignment_2 ) )
            // InternalDefinitionLanguage.g:3755:2: ( rule__InstanceTypeRule__DefinitionsAssignment_2 )
            {
             before(grammarAccess.getInstanceTypeRuleAccess().getDefinitionsAssignment_2()); 
            // InternalDefinitionLanguage.g:3756:2: ( rule__InstanceTypeRule__DefinitionsAssignment_2 )
            // InternalDefinitionLanguage.g:3756:3: rule__InstanceTypeRule__DefinitionsAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__InstanceTypeRule__DefinitionsAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getInstanceTypeRuleAccess().getDefinitionsAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceTypeRule__Group__2__Impl"


    // $ANTLR start "rule__InstanceTypeRule__Group__3"
    // InternalDefinitionLanguage.g:3764:1: rule__InstanceTypeRule__Group__3 : rule__InstanceTypeRule__Group__3__Impl ;
    public final void rule__InstanceTypeRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3768:1: ( rule__InstanceTypeRule__Group__3__Impl )
            // InternalDefinitionLanguage.g:3769:2: rule__InstanceTypeRule__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__InstanceTypeRule__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceTypeRule__Group__3"


    // $ANTLR start "rule__InstanceTypeRule__Group__3__Impl"
    // InternalDefinitionLanguage.g:3775:1: rule__InstanceTypeRule__Group__3__Impl : ( ( rule__InstanceTypeRule__Group_3__0 )* ) ;
    public final void rule__InstanceTypeRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3779:1: ( ( ( rule__InstanceTypeRule__Group_3__0 )* ) )
            // InternalDefinitionLanguage.g:3780:1: ( ( rule__InstanceTypeRule__Group_3__0 )* )
            {
            // InternalDefinitionLanguage.g:3780:1: ( ( rule__InstanceTypeRule__Group_3__0 )* )
            // InternalDefinitionLanguage.g:3781:2: ( rule__InstanceTypeRule__Group_3__0 )*
            {
             before(grammarAccess.getInstanceTypeRuleAccess().getGroup_3()); 
            // InternalDefinitionLanguage.g:3782:2: ( rule__InstanceTypeRule__Group_3__0 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==66) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:3782:3: rule__InstanceTypeRule__Group_3__0
            	    {
            	    pushFollow(FOLLOW_41);
            	    rule__InstanceTypeRule__Group_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

             after(grammarAccess.getInstanceTypeRuleAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceTypeRule__Group__3__Impl"


    // $ANTLR start "rule__InstanceTypeRule__Group_3__0"
    // InternalDefinitionLanguage.g:3791:1: rule__InstanceTypeRule__Group_3__0 : rule__InstanceTypeRule__Group_3__0__Impl rule__InstanceTypeRule__Group_3__1 ;
    public final void rule__InstanceTypeRule__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3795:1: ( rule__InstanceTypeRule__Group_3__0__Impl rule__InstanceTypeRule__Group_3__1 )
            // InternalDefinitionLanguage.g:3796:2: rule__InstanceTypeRule__Group_3__0__Impl rule__InstanceTypeRule__Group_3__1
            {
            pushFollow(FOLLOW_5);
            rule__InstanceTypeRule__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__InstanceTypeRule__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceTypeRule__Group_3__0"


    // $ANTLR start "rule__InstanceTypeRule__Group_3__0__Impl"
    // InternalDefinitionLanguage.g:3803:1: rule__InstanceTypeRule__Group_3__0__Impl : ( '|' ) ;
    public final void rule__InstanceTypeRule__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3807:1: ( ( '|' ) )
            // InternalDefinitionLanguage.g:3808:1: ( '|' )
            {
            // InternalDefinitionLanguage.g:3808:1: ( '|' )
            // InternalDefinitionLanguage.g:3809:2: '|'
            {
             before(grammarAccess.getInstanceTypeRuleAccess().getVerticalLineKeyword_3_0()); 
            match(input,66,FOLLOW_2); 
             after(grammarAccess.getInstanceTypeRuleAccess().getVerticalLineKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceTypeRule__Group_3__0__Impl"


    // $ANTLR start "rule__InstanceTypeRule__Group_3__1"
    // InternalDefinitionLanguage.g:3818:1: rule__InstanceTypeRule__Group_3__1 : rule__InstanceTypeRule__Group_3__1__Impl ;
    public final void rule__InstanceTypeRule__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3822:1: ( rule__InstanceTypeRule__Group_3__1__Impl )
            // InternalDefinitionLanguage.g:3823:2: rule__InstanceTypeRule__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__InstanceTypeRule__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceTypeRule__Group_3__1"


    // $ANTLR start "rule__InstanceTypeRule__Group_3__1__Impl"
    // InternalDefinitionLanguage.g:3829:1: rule__InstanceTypeRule__Group_3__1__Impl : ( ( rule__InstanceTypeRule__DefinitionsAssignment_3_1 ) ) ;
    public final void rule__InstanceTypeRule__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3833:1: ( ( ( rule__InstanceTypeRule__DefinitionsAssignment_3_1 ) ) )
            // InternalDefinitionLanguage.g:3834:1: ( ( rule__InstanceTypeRule__DefinitionsAssignment_3_1 ) )
            {
            // InternalDefinitionLanguage.g:3834:1: ( ( rule__InstanceTypeRule__DefinitionsAssignment_3_1 ) )
            // InternalDefinitionLanguage.g:3835:2: ( rule__InstanceTypeRule__DefinitionsAssignment_3_1 )
            {
             before(grammarAccess.getInstanceTypeRuleAccess().getDefinitionsAssignment_3_1()); 
            // InternalDefinitionLanguage.g:3836:2: ( rule__InstanceTypeRule__DefinitionsAssignment_3_1 )
            // InternalDefinitionLanguage.g:3836:3: rule__InstanceTypeRule__DefinitionsAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__InstanceTypeRule__DefinitionsAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getInstanceTypeRuleAccess().getDefinitionsAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceTypeRule__Group_3__1__Impl"


    // $ANTLR start "rule__StringTypeRule__Group__0"
    // InternalDefinitionLanguage.g:3845:1: rule__StringTypeRule__Group__0 : rule__StringTypeRule__Group__0__Impl rule__StringTypeRule__Group__1 ;
    public final void rule__StringTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3849:1: ( rule__StringTypeRule__Group__0__Impl rule__StringTypeRule__Group__1 )
            // InternalDefinitionLanguage.g:3850:2: rule__StringTypeRule__Group__0__Impl rule__StringTypeRule__Group__1
            {
            pushFollow(FOLLOW_42);
            rule__StringTypeRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__StringTypeRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StringTypeRule__Group__0"


    // $ANTLR start "rule__StringTypeRule__Group__0__Impl"
    // InternalDefinitionLanguage.g:3857:1: rule__StringTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__StringTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3861:1: ( ( () ) )
            // InternalDefinitionLanguage.g:3862:1: ( () )
            {
            // InternalDefinitionLanguage.g:3862:1: ( () )
            // InternalDefinitionLanguage.g:3863:2: ()
            {
             before(grammarAccess.getStringTypeRuleAccess().getStringTypeAction_0()); 
            // InternalDefinitionLanguage.g:3864:2: ()
            // InternalDefinitionLanguage.g:3864:3: 
            {
            }

             after(grammarAccess.getStringTypeRuleAccess().getStringTypeAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StringTypeRule__Group__0__Impl"


    // $ANTLR start "rule__StringTypeRule__Group__1"
    // InternalDefinitionLanguage.g:3872:1: rule__StringTypeRule__Group__1 : rule__StringTypeRule__Group__1__Impl ;
    public final void rule__StringTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3876:1: ( rule__StringTypeRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:3877:2: rule__StringTypeRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__StringTypeRule__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StringTypeRule__Group__1"


    // $ANTLR start "rule__StringTypeRule__Group__1__Impl"
    // InternalDefinitionLanguage.g:3883:1: rule__StringTypeRule__Group__1__Impl : ( 'string' ) ;
    public final void rule__StringTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3887:1: ( ( 'string' ) )
            // InternalDefinitionLanguage.g:3888:1: ( 'string' )
            {
            // InternalDefinitionLanguage.g:3888:1: ( 'string' )
            // InternalDefinitionLanguage.g:3889:2: 'string'
            {
             before(grammarAccess.getStringTypeRuleAccess().getStringKeyword_1()); 
            match(input,67,FOLLOW_2); 
             after(grammarAccess.getStringTypeRuleAccess().getStringKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StringTypeRule__Group__1__Impl"


    // $ANTLR start "rule__ExpressionTypeRule__Group__0"
    // InternalDefinitionLanguage.g:3899:1: rule__ExpressionTypeRule__Group__0 : rule__ExpressionTypeRule__Group__0__Impl rule__ExpressionTypeRule__Group__1 ;
    public final void rule__ExpressionTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3903:1: ( rule__ExpressionTypeRule__Group__0__Impl rule__ExpressionTypeRule__Group__1 )
            // InternalDefinitionLanguage.g:3904:2: rule__ExpressionTypeRule__Group__0__Impl rule__ExpressionTypeRule__Group__1
            {
            pushFollow(FOLLOW_43);
            rule__ExpressionTypeRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExpressionTypeRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionTypeRule__Group__0"


    // $ANTLR start "rule__ExpressionTypeRule__Group__0__Impl"
    // InternalDefinitionLanguage.g:3911:1: rule__ExpressionTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__ExpressionTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3915:1: ( ( () ) )
            // InternalDefinitionLanguage.g:3916:1: ( () )
            {
            // InternalDefinitionLanguage.g:3916:1: ( () )
            // InternalDefinitionLanguage.g:3917:2: ()
            {
             before(grammarAccess.getExpressionTypeRuleAccess().getExpressionTypeAction_0()); 
            // InternalDefinitionLanguage.g:3918:2: ()
            // InternalDefinitionLanguage.g:3918:3: 
            {
            }

             after(grammarAccess.getExpressionTypeRuleAccess().getExpressionTypeAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionTypeRule__Group__0__Impl"


    // $ANTLR start "rule__ExpressionTypeRule__Group__1"
    // InternalDefinitionLanguage.g:3926:1: rule__ExpressionTypeRule__Group__1 : rule__ExpressionTypeRule__Group__1__Impl ;
    public final void rule__ExpressionTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3930:1: ( rule__ExpressionTypeRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:3931:2: rule__ExpressionTypeRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ExpressionTypeRule__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionTypeRule__Group__1"


    // $ANTLR start "rule__ExpressionTypeRule__Group__1__Impl"
    // InternalDefinitionLanguage.g:3937:1: rule__ExpressionTypeRule__Group__1__Impl : ( 'expression' ) ;
    public final void rule__ExpressionTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3941:1: ( ( 'expression' ) )
            // InternalDefinitionLanguage.g:3942:1: ( 'expression' )
            {
            // InternalDefinitionLanguage.g:3942:1: ( 'expression' )
            // InternalDefinitionLanguage.g:3943:2: 'expression'
            {
             before(grammarAccess.getExpressionTypeRuleAccess().getExpressionKeyword_1()); 
            match(input,68,FOLLOW_2); 
             after(grammarAccess.getExpressionTypeRuleAccess().getExpressionKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionTypeRule__Group__1__Impl"


    // $ANTLR start "rule__IntTypeRule__Group__0"
    // InternalDefinitionLanguage.g:3953:1: rule__IntTypeRule__Group__0 : rule__IntTypeRule__Group__0__Impl rule__IntTypeRule__Group__1 ;
    public final void rule__IntTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3957:1: ( rule__IntTypeRule__Group__0__Impl rule__IntTypeRule__Group__1 )
            // InternalDefinitionLanguage.g:3958:2: rule__IntTypeRule__Group__0__Impl rule__IntTypeRule__Group__1
            {
            pushFollow(FOLLOW_44);
            rule__IntTypeRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IntTypeRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntTypeRule__Group__0"


    // $ANTLR start "rule__IntTypeRule__Group__0__Impl"
    // InternalDefinitionLanguage.g:3965:1: rule__IntTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__IntTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3969:1: ( ( () ) )
            // InternalDefinitionLanguage.g:3970:1: ( () )
            {
            // InternalDefinitionLanguage.g:3970:1: ( () )
            // InternalDefinitionLanguage.g:3971:2: ()
            {
             before(grammarAccess.getIntTypeRuleAccess().getIntTypeAction_0()); 
            // InternalDefinitionLanguage.g:3972:2: ()
            // InternalDefinitionLanguage.g:3972:3: 
            {
            }

             after(grammarAccess.getIntTypeRuleAccess().getIntTypeAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntTypeRule__Group__0__Impl"


    // $ANTLR start "rule__IntTypeRule__Group__1"
    // InternalDefinitionLanguage.g:3980:1: rule__IntTypeRule__Group__1 : rule__IntTypeRule__Group__1__Impl ;
    public final void rule__IntTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3984:1: ( rule__IntTypeRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:3985:2: rule__IntTypeRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__IntTypeRule__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntTypeRule__Group__1"


    // $ANTLR start "rule__IntTypeRule__Group__1__Impl"
    // InternalDefinitionLanguage.g:3991:1: rule__IntTypeRule__Group__1__Impl : ( 'int' ) ;
    public final void rule__IntTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3995:1: ( ( 'int' ) )
            // InternalDefinitionLanguage.g:3996:1: ( 'int' )
            {
            // InternalDefinitionLanguage.g:3996:1: ( 'int' )
            // InternalDefinitionLanguage.g:3997:2: 'int'
            {
             before(grammarAccess.getIntTypeRuleAccess().getIntKeyword_1()); 
            match(input,69,FOLLOW_2); 
             after(grammarAccess.getIntTypeRuleAccess().getIntKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntTypeRule__Group__1__Impl"


    // $ANTLR start "rule__FloatTypeRule__Group__0"
    // InternalDefinitionLanguage.g:4007:1: rule__FloatTypeRule__Group__0 : rule__FloatTypeRule__Group__0__Impl rule__FloatTypeRule__Group__1 ;
    public final void rule__FloatTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4011:1: ( rule__FloatTypeRule__Group__0__Impl rule__FloatTypeRule__Group__1 )
            // InternalDefinitionLanguage.g:4012:2: rule__FloatTypeRule__Group__0__Impl rule__FloatTypeRule__Group__1
            {
            pushFollow(FOLLOW_45);
            rule__FloatTypeRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FloatTypeRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FloatTypeRule__Group__0"


    // $ANTLR start "rule__FloatTypeRule__Group__0__Impl"
    // InternalDefinitionLanguage.g:4019:1: rule__FloatTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__FloatTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4023:1: ( ( () ) )
            // InternalDefinitionLanguage.g:4024:1: ( () )
            {
            // InternalDefinitionLanguage.g:4024:1: ( () )
            // InternalDefinitionLanguage.g:4025:2: ()
            {
             before(grammarAccess.getFloatTypeRuleAccess().getFloatTypeAction_0()); 
            // InternalDefinitionLanguage.g:4026:2: ()
            // InternalDefinitionLanguage.g:4026:3: 
            {
            }

             after(grammarAccess.getFloatTypeRuleAccess().getFloatTypeAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FloatTypeRule__Group__0__Impl"


    // $ANTLR start "rule__FloatTypeRule__Group__1"
    // InternalDefinitionLanguage.g:4034:1: rule__FloatTypeRule__Group__1 : rule__FloatTypeRule__Group__1__Impl ;
    public final void rule__FloatTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4038:1: ( rule__FloatTypeRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:4039:2: rule__FloatTypeRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FloatTypeRule__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FloatTypeRule__Group__1"


    // $ANTLR start "rule__FloatTypeRule__Group__1__Impl"
    // InternalDefinitionLanguage.g:4045:1: rule__FloatTypeRule__Group__1__Impl : ( 'float' ) ;
    public final void rule__FloatTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4049:1: ( ( 'float' ) )
            // InternalDefinitionLanguage.g:4050:1: ( 'float' )
            {
            // InternalDefinitionLanguage.g:4050:1: ( 'float' )
            // InternalDefinitionLanguage.g:4051:2: 'float'
            {
             before(grammarAccess.getFloatTypeRuleAccess().getFloatKeyword_1()); 
            match(input,70,FOLLOW_2); 
             after(grammarAccess.getFloatTypeRuleAccess().getFloatKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FloatTypeRule__Group__1__Impl"


    // $ANTLR start "rule__BooleanTypeRule__Group__0"
    // InternalDefinitionLanguage.g:4061:1: rule__BooleanTypeRule__Group__0 : rule__BooleanTypeRule__Group__0__Impl rule__BooleanTypeRule__Group__1 ;
    public final void rule__BooleanTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4065:1: ( rule__BooleanTypeRule__Group__0__Impl rule__BooleanTypeRule__Group__1 )
            // InternalDefinitionLanguage.g:4066:2: rule__BooleanTypeRule__Group__0__Impl rule__BooleanTypeRule__Group__1
            {
            pushFollow(FOLLOW_46);
            rule__BooleanTypeRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BooleanTypeRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanTypeRule__Group__0"


    // $ANTLR start "rule__BooleanTypeRule__Group__0__Impl"
    // InternalDefinitionLanguage.g:4073:1: rule__BooleanTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__BooleanTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4077:1: ( ( () ) )
            // InternalDefinitionLanguage.g:4078:1: ( () )
            {
            // InternalDefinitionLanguage.g:4078:1: ( () )
            // InternalDefinitionLanguage.g:4079:2: ()
            {
             before(grammarAccess.getBooleanTypeRuleAccess().getBooleanTypeAction_0()); 
            // InternalDefinitionLanguage.g:4080:2: ()
            // InternalDefinitionLanguage.g:4080:3: 
            {
            }

             after(grammarAccess.getBooleanTypeRuleAccess().getBooleanTypeAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanTypeRule__Group__0__Impl"


    // $ANTLR start "rule__BooleanTypeRule__Group__1"
    // InternalDefinitionLanguage.g:4088:1: rule__BooleanTypeRule__Group__1 : rule__BooleanTypeRule__Group__1__Impl ;
    public final void rule__BooleanTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4092:1: ( rule__BooleanTypeRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:4093:2: rule__BooleanTypeRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__BooleanTypeRule__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanTypeRule__Group__1"


    // $ANTLR start "rule__BooleanTypeRule__Group__1__Impl"
    // InternalDefinitionLanguage.g:4099:1: rule__BooleanTypeRule__Group__1__Impl : ( 'boolean' ) ;
    public final void rule__BooleanTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4103:1: ( ( 'boolean' ) )
            // InternalDefinitionLanguage.g:4104:1: ( 'boolean' )
            {
            // InternalDefinitionLanguage.g:4104:1: ( 'boolean' )
            // InternalDefinitionLanguage.g:4105:2: 'boolean'
            {
             before(grammarAccess.getBooleanTypeRuleAccess().getBooleanKeyword_1()); 
            match(input,71,FOLLOW_2); 
             after(grammarAccess.getBooleanTypeRuleAccess().getBooleanKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanTypeRule__Group__1__Impl"


    // $ANTLR start "rule__VoidTypeRule__Group__0"
    // InternalDefinitionLanguage.g:4115:1: rule__VoidTypeRule__Group__0 : rule__VoidTypeRule__Group__0__Impl rule__VoidTypeRule__Group__1 ;
    public final void rule__VoidTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4119:1: ( rule__VoidTypeRule__Group__0__Impl rule__VoidTypeRule__Group__1 )
            // InternalDefinitionLanguage.g:4120:2: rule__VoidTypeRule__Group__0__Impl rule__VoidTypeRule__Group__1
            {
            pushFollow(FOLLOW_47);
            rule__VoidTypeRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__VoidTypeRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VoidTypeRule__Group__0"


    // $ANTLR start "rule__VoidTypeRule__Group__0__Impl"
    // InternalDefinitionLanguage.g:4127:1: rule__VoidTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__VoidTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4131:1: ( ( () ) )
            // InternalDefinitionLanguage.g:4132:1: ( () )
            {
            // InternalDefinitionLanguage.g:4132:1: ( () )
            // InternalDefinitionLanguage.g:4133:2: ()
            {
             before(grammarAccess.getVoidTypeRuleAccess().getVoidTypeAction_0()); 
            // InternalDefinitionLanguage.g:4134:2: ()
            // InternalDefinitionLanguage.g:4134:3: 
            {
            }

             after(grammarAccess.getVoidTypeRuleAccess().getVoidTypeAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VoidTypeRule__Group__0__Impl"


    // $ANTLR start "rule__VoidTypeRule__Group__1"
    // InternalDefinitionLanguage.g:4142:1: rule__VoidTypeRule__Group__1 : rule__VoidTypeRule__Group__1__Impl ;
    public final void rule__VoidTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4146:1: ( rule__VoidTypeRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:4147:2: rule__VoidTypeRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__VoidTypeRule__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VoidTypeRule__Group__1"


    // $ANTLR start "rule__VoidTypeRule__Group__1__Impl"
    // InternalDefinitionLanguage.g:4153:1: rule__VoidTypeRule__Group__1__Impl : ( 'void' ) ;
    public final void rule__VoidTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4157:1: ( ( 'void' ) )
            // InternalDefinitionLanguage.g:4158:1: ( 'void' )
            {
            // InternalDefinitionLanguage.g:4158:1: ( 'void' )
            // InternalDefinitionLanguage.g:4159:2: 'void'
            {
             before(grammarAccess.getVoidTypeRuleAccess().getVoidKeyword_1()); 
            match(input,72,FOLLOW_2); 
             after(grammarAccess.getVoidTypeRuleAccess().getVoidKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VoidTypeRule__Group__1__Impl"


    // $ANTLR start "rule__DataTypeRule__Group__0"
    // InternalDefinitionLanguage.g:4169:1: rule__DataTypeRule__Group__0 : rule__DataTypeRule__Group__0__Impl rule__DataTypeRule__Group__1 ;
    public final void rule__DataTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4173:1: ( rule__DataTypeRule__Group__0__Impl rule__DataTypeRule__Group__1 )
            // InternalDefinitionLanguage.g:4174:2: rule__DataTypeRule__Group__0__Impl rule__DataTypeRule__Group__1
            {
            pushFollow(FOLLOW_36);
            rule__DataTypeRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataTypeRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeRule__Group__0"


    // $ANTLR start "rule__DataTypeRule__Group__0__Impl"
    // InternalDefinitionLanguage.g:4181:1: rule__DataTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__DataTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4185:1: ( ( () ) )
            // InternalDefinitionLanguage.g:4186:1: ( () )
            {
            // InternalDefinitionLanguage.g:4186:1: ( () )
            // InternalDefinitionLanguage.g:4187:2: ()
            {
             before(grammarAccess.getDataTypeRuleAccess().getDataTypeAction_0()); 
            // InternalDefinitionLanguage.g:4188:2: ()
            // InternalDefinitionLanguage.g:4188:3: 
            {
            }

             after(grammarAccess.getDataTypeRuleAccess().getDataTypeAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeRule__Group__0__Impl"


    // $ANTLR start "rule__DataTypeRule__Group__1"
    // InternalDefinitionLanguage.g:4196:1: rule__DataTypeRule__Group__1 : rule__DataTypeRule__Group__1__Impl ;
    public final void rule__DataTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4200:1: ( rule__DataTypeRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:4201:2: rule__DataTypeRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataTypeRule__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeRule__Group__1"


    // $ANTLR start "rule__DataTypeRule__Group__1__Impl"
    // InternalDefinitionLanguage.g:4207:1: rule__DataTypeRule__Group__1__Impl : ( 'data' ) ;
    public final void rule__DataTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4211:1: ( ( 'data' ) )
            // InternalDefinitionLanguage.g:4212:1: ( 'data' )
            {
            // InternalDefinitionLanguage.g:4212:1: ( 'data' )
            // InternalDefinitionLanguage.g:4213:2: 'data'
            {
             before(grammarAccess.getDataTypeRuleAccess().getDataKeyword_1()); 
            match(input,73,FOLLOW_2); 
             after(grammarAccess.getDataTypeRuleAccess().getDataKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeRule__Group__1__Impl"


    // $ANTLR start "rule__ArrayTypeRule__Group__0"
    // InternalDefinitionLanguage.g:4223:1: rule__ArrayTypeRule__Group__0 : rule__ArrayTypeRule__Group__0__Impl rule__ArrayTypeRule__Group__1 ;
    public final void rule__ArrayTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4227:1: ( rule__ArrayTypeRule__Group__0__Impl rule__ArrayTypeRule__Group__1 )
            // InternalDefinitionLanguage.g:4228:2: rule__ArrayTypeRule__Group__0__Impl rule__ArrayTypeRule__Group__1
            {
            pushFollow(FOLLOW_36);
            rule__ArrayTypeRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ArrayTypeRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrayTypeRule__Group__0"


    // $ANTLR start "rule__ArrayTypeRule__Group__0__Impl"
    // InternalDefinitionLanguage.g:4235:1: rule__ArrayTypeRule__Group__0__Impl : ( 'array' ) ;
    public final void rule__ArrayTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4239:1: ( ( 'array' ) )
            // InternalDefinitionLanguage.g:4240:1: ( 'array' )
            {
            // InternalDefinitionLanguage.g:4240:1: ( 'array' )
            // InternalDefinitionLanguage.g:4241:2: 'array'
            {
             before(grammarAccess.getArrayTypeRuleAccess().getArrayKeyword_0()); 
            match(input,74,FOLLOW_2); 
             after(grammarAccess.getArrayTypeRuleAccess().getArrayKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrayTypeRule__Group__0__Impl"


    // $ANTLR start "rule__ArrayTypeRule__Group__1"
    // InternalDefinitionLanguage.g:4250:1: rule__ArrayTypeRule__Group__1 : rule__ArrayTypeRule__Group__1__Impl ;
    public final void rule__ArrayTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4254:1: ( rule__ArrayTypeRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:4255:2: rule__ArrayTypeRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ArrayTypeRule__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrayTypeRule__Group__1"


    // $ANTLR start "rule__ArrayTypeRule__Group__1__Impl"
    // InternalDefinitionLanguage.g:4261:1: rule__ArrayTypeRule__Group__1__Impl : ( ( rule__ArrayTypeRule__ElementsAssignment_1 ) ) ;
    public final void rule__ArrayTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4265:1: ( ( ( rule__ArrayTypeRule__ElementsAssignment_1 ) ) )
            // InternalDefinitionLanguage.g:4266:1: ( ( rule__ArrayTypeRule__ElementsAssignment_1 ) )
            {
            // InternalDefinitionLanguage.g:4266:1: ( ( rule__ArrayTypeRule__ElementsAssignment_1 ) )
            // InternalDefinitionLanguage.g:4267:2: ( rule__ArrayTypeRule__ElementsAssignment_1 )
            {
             before(grammarAccess.getArrayTypeRuleAccess().getElementsAssignment_1()); 
            // InternalDefinitionLanguage.g:4268:2: ( rule__ArrayTypeRule__ElementsAssignment_1 )
            // InternalDefinitionLanguage.g:4268:3: rule__ArrayTypeRule__ElementsAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__ArrayTypeRule__ElementsAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getArrayTypeRuleAccess().getElementsAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrayTypeRule__Group__1__Impl"


    // $ANTLR start "rule__FunctionDefinitionRule__Group__0"
    // InternalDefinitionLanguage.g:4277:1: rule__FunctionDefinitionRule__Group__0 : rule__FunctionDefinitionRule__Group__0__Impl rule__FunctionDefinitionRule__Group__1 ;
    public final void rule__FunctionDefinitionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4281:1: ( rule__FunctionDefinitionRule__Group__0__Impl rule__FunctionDefinitionRule__Group__1 )
            // InternalDefinitionLanguage.g:4282:2: rule__FunctionDefinitionRule__Group__0__Impl rule__FunctionDefinitionRule__Group__1
            {
            pushFollow(FOLLOW_36);
            rule__FunctionDefinitionRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FunctionDefinitionRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__Group__0"


    // $ANTLR start "rule__FunctionDefinitionRule__Group__0__Impl"
    // InternalDefinitionLanguage.g:4289:1: rule__FunctionDefinitionRule__Group__0__Impl : ( 'def' ) ;
    public final void rule__FunctionDefinitionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4293:1: ( ( 'def' ) )
            // InternalDefinitionLanguage.g:4294:1: ( 'def' )
            {
            // InternalDefinitionLanguage.g:4294:1: ( 'def' )
            // InternalDefinitionLanguage.g:4295:2: 'def'
            {
             before(grammarAccess.getFunctionDefinitionRuleAccess().getDefKeyword_0()); 
            match(input,75,FOLLOW_2); 
             after(grammarAccess.getFunctionDefinitionRuleAccess().getDefKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__Group__0__Impl"


    // $ANTLR start "rule__FunctionDefinitionRule__Group__1"
    // InternalDefinitionLanguage.g:4304:1: rule__FunctionDefinitionRule__Group__1 : rule__FunctionDefinitionRule__Group__1__Impl rule__FunctionDefinitionRule__Group__2 ;
    public final void rule__FunctionDefinitionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4308:1: ( rule__FunctionDefinitionRule__Group__1__Impl rule__FunctionDefinitionRule__Group__2 )
            // InternalDefinitionLanguage.g:4309:2: rule__FunctionDefinitionRule__Group__1__Impl rule__FunctionDefinitionRule__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__FunctionDefinitionRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FunctionDefinitionRule__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__Group__1"


    // $ANTLR start "rule__FunctionDefinitionRule__Group__1__Impl"
    // InternalDefinitionLanguage.g:4316:1: rule__FunctionDefinitionRule__Group__1__Impl : ( ( rule__FunctionDefinitionRule__TypeAssignment_1 ) ) ;
    public final void rule__FunctionDefinitionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4320:1: ( ( ( rule__FunctionDefinitionRule__TypeAssignment_1 ) ) )
            // InternalDefinitionLanguage.g:4321:1: ( ( rule__FunctionDefinitionRule__TypeAssignment_1 ) )
            {
            // InternalDefinitionLanguage.g:4321:1: ( ( rule__FunctionDefinitionRule__TypeAssignment_1 ) )
            // InternalDefinitionLanguage.g:4322:2: ( rule__FunctionDefinitionRule__TypeAssignment_1 )
            {
             before(grammarAccess.getFunctionDefinitionRuleAccess().getTypeAssignment_1()); 
            // InternalDefinitionLanguage.g:4323:2: ( rule__FunctionDefinitionRule__TypeAssignment_1 )
            // InternalDefinitionLanguage.g:4323:3: rule__FunctionDefinitionRule__TypeAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__FunctionDefinitionRule__TypeAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getFunctionDefinitionRuleAccess().getTypeAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__Group__1__Impl"


    // $ANTLR start "rule__FunctionDefinitionRule__Group__2"
    // InternalDefinitionLanguage.g:4331:1: rule__FunctionDefinitionRule__Group__2 : rule__FunctionDefinitionRule__Group__2__Impl rule__FunctionDefinitionRule__Group__3 ;
    public final void rule__FunctionDefinitionRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4335:1: ( rule__FunctionDefinitionRule__Group__2__Impl rule__FunctionDefinitionRule__Group__3 )
            // InternalDefinitionLanguage.g:4336:2: rule__FunctionDefinitionRule__Group__2__Impl rule__FunctionDefinitionRule__Group__3
            {
            pushFollow(FOLLOW_25);
            rule__FunctionDefinitionRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FunctionDefinitionRule__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__Group__2"


    // $ANTLR start "rule__FunctionDefinitionRule__Group__2__Impl"
    // InternalDefinitionLanguage.g:4343:1: rule__FunctionDefinitionRule__Group__2__Impl : ( ( rule__FunctionDefinitionRule__NameAssignment_2 ) ) ;
    public final void rule__FunctionDefinitionRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4347:1: ( ( ( rule__FunctionDefinitionRule__NameAssignment_2 ) ) )
            // InternalDefinitionLanguage.g:4348:1: ( ( rule__FunctionDefinitionRule__NameAssignment_2 ) )
            {
            // InternalDefinitionLanguage.g:4348:1: ( ( rule__FunctionDefinitionRule__NameAssignment_2 ) )
            // InternalDefinitionLanguage.g:4349:2: ( rule__FunctionDefinitionRule__NameAssignment_2 )
            {
             before(grammarAccess.getFunctionDefinitionRuleAccess().getNameAssignment_2()); 
            // InternalDefinitionLanguage.g:4350:2: ( rule__FunctionDefinitionRule__NameAssignment_2 )
            // InternalDefinitionLanguage.g:4350:3: rule__FunctionDefinitionRule__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__FunctionDefinitionRule__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getFunctionDefinitionRuleAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__Group__2__Impl"


    // $ANTLR start "rule__FunctionDefinitionRule__Group__3"
    // InternalDefinitionLanguage.g:4358:1: rule__FunctionDefinitionRule__Group__3 : rule__FunctionDefinitionRule__Group__3__Impl rule__FunctionDefinitionRule__Group__4 ;
    public final void rule__FunctionDefinitionRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4362:1: ( rule__FunctionDefinitionRule__Group__3__Impl rule__FunctionDefinitionRule__Group__4 )
            // InternalDefinitionLanguage.g:4363:2: rule__FunctionDefinitionRule__Group__3__Impl rule__FunctionDefinitionRule__Group__4
            {
            pushFollow(FOLLOW_48);
            rule__FunctionDefinitionRule__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FunctionDefinitionRule__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__Group__3"


    // $ANTLR start "rule__FunctionDefinitionRule__Group__3__Impl"
    // InternalDefinitionLanguage.g:4370:1: rule__FunctionDefinitionRule__Group__3__Impl : ( '(' ) ;
    public final void rule__FunctionDefinitionRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4374:1: ( ( '(' ) )
            // InternalDefinitionLanguage.g:4375:1: ( '(' )
            {
            // InternalDefinitionLanguage.g:4375:1: ( '(' )
            // InternalDefinitionLanguage.g:4376:2: '('
            {
             before(grammarAccess.getFunctionDefinitionRuleAccess().getLeftParenthesisKeyword_3()); 
            match(input,56,FOLLOW_2); 
             after(grammarAccess.getFunctionDefinitionRuleAccess().getLeftParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__Group__3__Impl"


    // $ANTLR start "rule__FunctionDefinitionRule__Group__4"
    // InternalDefinitionLanguage.g:4385:1: rule__FunctionDefinitionRule__Group__4 : rule__FunctionDefinitionRule__Group__4__Impl rule__FunctionDefinitionRule__Group__5 ;
    public final void rule__FunctionDefinitionRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4389:1: ( rule__FunctionDefinitionRule__Group__4__Impl rule__FunctionDefinitionRule__Group__5 )
            // InternalDefinitionLanguage.g:4390:2: rule__FunctionDefinitionRule__Group__4__Impl rule__FunctionDefinitionRule__Group__5
            {
            pushFollow(FOLLOW_48);
            rule__FunctionDefinitionRule__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FunctionDefinitionRule__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__Group__4"


    // $ANTLR start "rule__FunctionDefinitionRule__Group__4__Impl"
    // InternalDefinitionLanguage.g:4397:1: rule__FunctionDefinitionRule__Group__4__Impl : ( ( rule__FunctionDefinitionRule__Group_4__0 )? ) ;
    public final void rule__FunctionDefinitionRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4401:1: ( ( ( rule__FunctionDefinitionRule__Group_4__0 )? ) )
            // InternalDefinitionLanguage.g:4402:1: ( ( rule__FunctionDefinitionRule__Group_4__0 )? )
            {
            // InternalDefinitionLanguage.g:4402:1: ( ( rule__FunctionDefinitionRule__Group_4__0 )? )
            // InternalDefinitionLanguage.g:4403:2: ( rule__FunctionDefinitionRule__Group_4__0 )?
            {
             before(grammarAccess.getFunctionDefinitionRuleAccess().getGroup_4()); 
            // InternalDefinitionLanguage.g:4404:2: ( rule__FunctionDefinitionRule__Group_4__0 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( ((LA32_0>=64 && LA32_0<=65)||(LA32_0>=67 && LA32_0<=74)) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalDefinitionLanguage.g:4404:3: rule__FunctionDefinitionRule__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__FunctionDefinitionRule__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getFunctionDefinitionRuleAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__Group__4__Impl"


    // $ANTLR start "rule__FunctionDefinitionRule__Group__5"
    // InternalDefinitionLanguage.g:4412:1: rule__FunctionDefinitionRule__Group__5 : rule__FunctionDefinitionRule__Group__5__Impl rule__FunctionDefinitionRule__Group__6 ;
    public final void rule__FunctionDefinitionRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4416:1: ( rule__FunctionDefinitionRule__Group__5__Impl rule__FunctionDefinitionRule__Group__6 )
            // InternalDefinitionLanguage.g:4417:2: rule__FunctionDefinitionRule__Group__5__Impl rule__FunctionDefinitionRule__Group__6
            {
            pushFollow(FOLLOW_9);
            rule__FunctionDefinitionRule__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FunctionDefinitionRule__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__Group__5"


    // $ANTLR start "rule__FunctionDefinitionRule__Group__5__Impl"
    // InternalDefinitionLanguage.g:4424:1: rule__FunctionDefinitionRule__Group__5__Impl : ( ')' ) ;
    public final void rule__FunctionDefinitionRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4428:1: ( ( ')' ) )
            // InternalDefinitionLanguage.g:4429:1: ( ')' )
            {
            // InternalDefinitionLanguage.g:4429:1: ( ')' )
            // InternalDefinitionLanguage.g:4430:2: ')'
            {
             before(grammarAccess.getFunctionDefinitionRuleAccess().getRightParenthesisKeyword_5()); 
            match(input,57,FOLLOW_2); 
             after(grammarAccess.getFunctionDefinitionRuleAccess().getRightParenthesisKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__Group__5__Impl"


    // $ANTLR start "rule__FunctionDefinitionRule__Group__6"
    // InternalDefinitionLanguage.g:4439:1: rule__FunctionDefinitionRule__Group__6 : rule__FunctionDefinitionRule__Group__6__Impl ;
    public final void rule__FunctionDefinitionRule__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4443:1: ( rule__FunctionDefinitionRule__Group__6__Impl )
            // InternalDefinitionLanguage.g:4444:2: rule__FunctionDefinitionRule__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FunctionDefinitionRule__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__Group__6"


    // $ANTLR start "rule__FunctionDefinitionRule__Group__6__Impl"
    // InternalDefinitionLanguage.g:4450:1: rule__FunctionDefinitionRule__Group__6__Impl : ( ';' ) ;
    public final void rule__FunctionDefinitionRule__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4454:1: ( ( ';' ) )
            // InternalDefinitionLanguage.g:4455:1: ( ';' )
            {
            // InternalDefinitionLanguage.g:4455:1: ( ';' )
            // InternalDefinitionLanguage.g:4456:2: ';'
            {
             before(grammarAccess.getFunctionDefinitionRuleAccess().getSemicolonKeyword_6()); 
            match(input,51,FOLLOW_2); 
             after(grammarAccess.getFunctionDefinitionRuleAccess().getSemicolonKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__Group__6__Impl"


    // $ANTLR start "rule__FunctionDefinitionRule__Group_4__0"
    // InternalDefinitionLanguage.g:4466:1: rule__FunctionDefinitionRule__Group_4__0 : rule__FunctionDefinitionRule__Group_4__0__Impl rule__FunctionDefinitionRule__Group_4__1 ;
    public final void rule__FunctionDefinitionRule__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4470:1: ( rule__FunctionDefinitionRule__Group_4__0__Impl rule__FunctionDefinitionRule__Group_4__1 )
            // InternalDefinitionLanguage.g:4471:2: rule__FunctionDefinitionRule__Group_4__0__Impl rule__FunctionDefinitionRule__Group_4__1
            {
            pushFollow(FOLLOW_27);
            rule__FunctionDefinitionRule__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FunctionDefinitionRule__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__Group_4__0"


    // $ANTLR start "rule__FunctionDefinitionRule__Group_4__0__Impl"
    // InternalDefinitionLanguage.g:4478:1: rule__FunctionDefinitionRule__Group_4__0__Impl : ( ( rule__FunctionDefinitionRule__ParametersAssignment_4_0 ) ) ;
    public final void rule__FunctionDefinitionRule__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4482:1: ( ( ( rule__FunctionDefinitionRule__ParametersAssignment_4_0 ) ) )
            // InternalDefinitionLanguage.g:4483:1: ( ( rule__FunctionDefinitionRule__ParametersAssignment_4_0 ) )
            {
            // InternalDefinitionLanguage.g:4483:1: ( ( rule__FunctionDefinitionRule__ParametersAssignment_4_0 ) )
            // InternalDefinitionLanguage.g:4484:2: ( rule__FunctionDefinitionRule__ParametersAssignment_4_0 )
            {
             before(grammarAccess.getFunctionDefinitionRuleAccess().getParametersAssignment_4_0()); 
            // InternalDefinitionLanguage.g:4485:2: ( rule__FunctionDefinitionRule__ParametersAssignment_4_0 )
            // InternalDefinitionLanguage.g:4485:3: rule__FunctionDefinitionRule__ParametersAssignment_4_0
            {
            pushFollow(FOLLOW_2);
            rule__FunctionDefinitionRule__ParametersAssignment_4_0();

            state._fsp--;


            }

             after(grammarAccess.getFunctionDefinitionRuleAccess().getParametersAssignment_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__Group_4__0__Impl"


    // $ANTLR start "rule__FunctionDefinitionRule__Group_4__1"
    // InternalDefinitionLanguage.g:4493:1: rule__FunctionDefinitionRule__Group_4__1 : rule__FunctionDefinitionRule__Group_4__1__Impl ;
    public final void rule__FunctionDefinitionRule__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4497:1: ( rule__FunctionDefinitionRule__Group_4__1__Impl )
            // InternalDefinitionLanguage.g:4498:2: rule__FunctionDefinitionRule__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FunctionDefinitionRule__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__Group_4__1"


    // $ANTLR start "rule__FunctionDefinitionRule__Group_4__1__Impl"
    // InternalDefinitionLanguage.g:4504:1: rule__FunctionDefinitionRule__Group_4__1__Impl : ( ( rule__FunctionDefinitionRule__Group_4_1__0 )* ) ;
    public final void rule__FunctionDefinitionRule__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4508:1: ( ( ( rule__FunctionDefinitionRule__Group_4_1__0 )* ) )
            // InternalDefinitionLanguage.g:4509:1: ( ( rule__FunctionDefinitionRule__Group_4_1__0 )* )
            {
            // InternalDefinitionLanguage.g:4509:1: ( ( rule__FunctionDefinitionRule__Group_4_1__0 )* )
            // InternalDefinitionLanguage.g:4510:2: ( rule__FunctionDefinitionRule__Group_4_1__0 )*
            {
             before(grammarAccess.getFunctionDefinitionRuleAccess().getGroup_4_1()); 
            // InternalDefinitionLanguage.g:4511:2: ( rule__FunctionDefinitionRule__Group_4_1__0 )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==58) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:4511:3: rule__FunctionDefinitionRule__Group_4_1__0
            	    {
            	    pushFollow(FOLLOW_28);
            	    rule__FunctionDefinitionRule__Group_4_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

             after(grammarAccess.getFunctionDefinitionRuleAccess().getGroup_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__Group_4__1__Impl"


    // $ANTLR start "rule__FunctionDefinitionRule__Group_4_1__0"
    // InternalDefinitionLanguage.g:4520:1: rule__FunctionDefinitionRule__Group_4_1__0 : rule__FunctionDefinitionRule__Group_4_1__0__Impl rule__FunctionDefinitionRule__Group_4_1__1 ;
    public final void rule__FunctionDefinitionRule__Group_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4524:1: ( rule__FunctionDefinitionRule__Group_4_1__0__Impl rule__FunctionDefinitionRule__Group_4_1__1 )
            // InternalDefinitionLanguage.g:4525:2: rule__FunctionDefinitionRule__Group_4_1__0__Impl rule__FunctionDefinitionRule__Group_4_1__1
            {
            pushFollow(FOLLOW_36);
            rule__FunctionDefinitionRule__Group_4_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FunctionDefinitionRule__Group_4_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__Group_4_1__0"


    // $ANTLR start "rule__FunctionDefinitionRule__Group_4_1__0__Impl"
    // InternalDefinitionLanguage.g:4532:1: rule__FunctionDefinitionRule__Group_4_1__0__Impl : ( ',' ) ;
    public final void rule__FunctionDefinitionRule__Group_4_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4536:1: ( ( ',' ) )
            // InternalDefinitionLanguage.g:4537:1: ( ',' )
            {
            // InternalDefinitionLanguage.g:4537:1: ( ',' )
            // InternalDefinitionLanguage.g:4538:2: ','
            {
             before(grammarAccess.getFunctionDefinitionRuleAccess().getCommaKeyword_4_1_0()); 
            match(input,58,FOLLOW_2); 
             after(grammarAccess.getFunctionDefinitionRuleAccess().getCommaKeyword_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__Group_4_1__0__Impl"


    // $ANTLR start "rule__FunctionDefinitionRule__Group_4_1__1"
    // InternalDefinitionLanguage.g:4547:1: rule__FunctionDefinitionRule__Group_4_1__1 : rule__FunctionDefinitionRule__Group_4_1__1__Impl ;
    public final void rule__FunctionDefinitionRule__Group_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4551:1: ( rule__FunctionDefinitionRule__Group_4_1__1__Impl )
            // InternalDefinitionLanguage.g:4552:2: rule__FunctionDefinitionRule__Group_4_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FunctionDefinitionRule__Group_4_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__Group_4_1__1"


    // $ANTLR start "rule__FunctionDefinitionRule__Group_4_1__1__Impl"
    // InternalDefinitionLanguage.g:4558:1: rule__FunctionDefinitionRule__Group_4_1__1__Impl : ( ( rule__FunctionDefinitionRule__ParametersAssignment_4_1_1 ) ) ;
    public final void rule__FunctionDefinitionRule__Group_4_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4562:1: ( ( ( rule__FunctionDefinitionRule__ParametersAssignment_4_1_1 ) ) )
            // InternalDefinitionLanguage.g:4563:1: ( ( rule__FunctionDefinitionRule__ParametersAssignment_4_1_1 ) )
            {
            // InternalDefinitionLanguage.g:4563:1: ( ( rule__FunctionDefinitionRule__ParametersAssignment_4_1_1 ) )
            // InternalDefinitionLanguage.g:4564:2: ( rule__FunctionDefinitionRule__ParametersAssignment_4_1_1 )
            {
             before(grammarAccess.getFunctionDefinitionRuleAccess().getParametersAssignment_4_1_1()); 
            // InternalDefinitionLanguage.g:4565:2: ( rule__FunctionDefinitionRule__ParametersAssignment_4_1_1 )
            // InternalDefinitionLanguage.g:4565:3: rule__FunctionDefinitionRule__ParametersAssignment_4_1_1
            {
            pushFollow(FOLLOW_2);
            rule__FunctionDefinitionRule__ParametersAssignment_4_1_1();

            state._fsp--;


            }

             after(grammarAccess.getFunctionDefinitionRuleAccess().getParametersAssignment_4_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__Group_4_1__1__Impl"


    // $ANTLR start "rule__ParameterRule__Group__0"
    // InternalDefinitionLanguage.g:4574:1: rule__ParameterRule__Group__0 : rule__ParameterRule__Group__0__Impl rule__ParameterRule__Group__1 ;
    public final void rule__ParameterRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4578:1: ( rule__ParameterRule__Group__0__Impl rule__ParameterRule__Group__1 )
            // InternalDefinitionLanguage.g:4579:2: rule__ParameterRule__Group__0__Impl rule__ParameterRule__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__ParameterRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParameterRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterRule__Group__0"


    // $ANTLR start "rule__ParameterRule__Group__0__Impl"
    // InternalDefinitionLanguage.g:4586:1: rule__ParameterRule__Group__0__Impl : ( ( rule__ParameterRule__TypeAssignment_0 ) ) ;
    public final void rule__ParameterRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4590:1: ( ( ( rule__ParameterRule__TypeAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:4591:1: ( ( rule__ParameterRule__TypeAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:4591:1: ( ( rule__ParameterRule__TypeAssignment_0 ) )
            // InternalDefinitionLanguage.g:4592:2: ( rule__ParameterRule__TypeAssignment_0 )
            {
             before(grammarAccess.getParameterRuleAccess().getTypeAssignment_0()); 
            // InternalDefinitionLanguage.g:4593:2: ( rule__ParameterRule__TypeAssignment_0 )
            // InternalDefinitionLanguage.g:4593:3: rule__ParameterRule__TypeAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__ParameterRule__TypeAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getParameterRuleAccess().getTypeAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterRule__Group__0__Impl"


    // $ANTLR start "rule__ParameterRule__Group__1"
    // InternalDefinitionLanguage.g:4601:1: rule__ParameterRule__Group__1 : rule__ParameterRule__Group__1__Impl ;
    public final void rule__ParameterRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4605:1: ( rule__ParameterRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:4606:2: rule__ParameterRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ParameterRule__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterRule__Group__1"


    // $ANTLR start "rule__ParameterRule__Group__1__Impl"
    // InternalDefinitionLanguage.g:4612:1: rule__ParameterRule__Group__1__Impl : ( ( rule__ParameterRule__NameAssignment_1 ) ) ;
    public final void rule__ParameterRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4616:1: ( ( ( rule__ParameterRule__NameAssignment_1 ) ) )
            // InternalDefinitionLanguage.g:4617:1: ( ( rule__ParameterRule__NameAssignment_1 ) )
            {
            // InternalDefinitionLanguage.g:4617:1: ( ( rule__ParameterRule__NameAssignment_1 ) )
            // InternalDefinitionLanguage.g:4618:2: ( rule__ParameterRule__NameAssignment_1 )
            {
             before(grammarAccess.getParameterRuleAccess().getNameAssignment_1()); 
            // InternalDefinitionLanguage.g:4619:2: ( rule__ParameterRule__NameAssignment_1 )
            // InternalDefinitionLanguage.g:4619:3: rule__ParameterRule__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__ParameterRule__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getParameterRuleAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterRule__Group__1__Impl"


    // $ANTLR start "rule__QualifiedName__Group__0"
    // InternalDefinitionLanguage.g:4628:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4632:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // InternalDefinitionLanguage.g:4633:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_49);
            rule__QualifiedName__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__0"


    // $ANTLR start "rule__QualifiedName__Group__0__Impl"
    // InternalDefinitionLanguage.g:4640:1: rule__QualifiedName__Group__0__Impl : ( ruleStringOrId ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4644:1: ( ( ruleStringOrId ) )
            // InternalDefinitionLanguage.g:4645:1: ( ruleStringOrId )
            {
            // InternalDefinitionLanguage.g:4645:1: ( ruleStringOrId )
            // InternalDefinitionLanguage.g:4646:2: ruleStringOrId
            {
             before(grammarAccess.getQualifiedNameAccess().getStringOrIdParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleStringOrId();

            state._fsp--;

             after(grammarAccess.getQualifiedNameAccess().getStringOrIdParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group__1"
    // InternalDefinitionLanguage.g:4655:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4659:1: ( rule__QualifiedName__Group__1__Impl )
            // InternalDefinitionLanguage.g:4660:2: rule__QualifiedName__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__1"


    // $ANTLR start "rule__QualifiedName__Group__1__Impl"
    // InternalDefinitionLanguage.g:4666:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4670:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // InternalDefinitionLanguage.g:4671:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // InternalDefinitionLanguage.g:4671:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // InternalDefinitionLanguage.g:4672:2: ( rule__QualifiedName__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // InternalDefinitionLanguage.g:4673:2: ( rule__QualifiedName__Group_1__0 )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==76) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:4673:3: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_50);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

             after(grammarAccess.getQualifiedNameAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__1__Impl"


    // $ANTLR start "rule__QualifiedName__Group_1__0"
    // InternalDefinitionLanguage.g:4682:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4686:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // InternalDefinitionLanguage.g:4687:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
            {
            pushFollow(FOLLOW_5);
            rule__QualifiedName__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__0"


    // $ANTLR start "rule__QualifiedName__Group_1__0__Impl"
    // InternalDefinitionLanguage.g:4694:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4698:1: ( ( '.' ) )
            // InternalDefinitionLanguage.g:4699:1: ( '.' )
            {
            // InternalDefinitionLanguage.g:4699:1: ( '.' )
            // InternalDefinitionLanguage.g:4700:2: '.'
            {
             before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            match(input,76,FOLLOW_2); 
             after(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group_1__1"
    // InternalDefinitionLanguage.g:4709:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4713:1: ( rule__QualifiedName__Group_1__1__Impl )
            // InternalDefinitionLanguage.g:4714:2: rule__QualifiedName__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__1"


    // $ANTLR start "rule__QualifiedName__Group_1__1__Impl"
    // InternalDefinitionLanguage.g:4720:1: rule__QualifiedName__Group_1__1__Impl : ( ruleStringOrId ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4724:1: ( ( ruleStringOrId ) )
            // InternalDefinitionLanguage.g:4725:1: ( ruleStringOrId )
            {
            // InternalDefinitionLanguage.g:4725:1: ( ruleStringOrId )
            // InternalDefinitionLanguage.g:4726:2: ruleStringOrId
            {
             before(grammarAccess.getQualifiedNameAccess().getStringOrIdParserRuleCall_1_1()); 
            pushFollow(FOLLOW_2);
            ruleStringOrId();

            state._fsp--;

             after(grammarAccess.getQualifiedNameAccess().getStringOrIdParserRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__1__Impl"


    // $ANTLR start "rule__DefinitionModelRule__ImportsAssignment_0"
    // InternalDefinitionLanguage.g:4736:1: rule__DefinitionModelRule__ImportsAssignment_0 : ( ruleImportRule ) ;
    public final void rule__DefinitionModelRule__ImportsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4740:1: ( ( ruleImportRule ) )
            // InternalDefinitionLanguage.g:4741:2: ( ruleImportRule )
            {
            // InternalDefinitionLanguage.g:4741:2: ( ruleImportRule )
            // InternalDefinitionLanguage.g:4742:3: ruleImportRule
            {
             before(grammarAccess.getDefinitionModelRuleAccess().getImportsImportRuleParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleImportRule();

            state._fsp--;

             after(grammarAccess.getDefinitionModelRuleAccess().getImportsImportRuleParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DefinitionModelRule__ImportsAssignment_0"


    // $ANTLR start "rule__DefinitionModelRule__NameAssignment_2"
    // InternalDefinitionLanguage.g:4751:1: rule__DefinitionModelRule__NameAssignment_2 : ( ruleQualifiedName ) ;
    public final void rule__DefinitionModelRule__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4755:1: ( ( ruleQualifiedName ) )
            // InternalDefinitionLanguage.g:4756:2: ( ruleQualifiedName )
            {
            // InternalDefinitionLanguage.g:4756:2: ( ruleQualifiedName )
            // InternalDefinitionLanguage.g:4757:3: ruleQualifiedName
            {
             before(grammarAccess.getDefinitionModelRuleAccess().getNameQualifiedNameParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getDefinitionModelRuleAccess().getNameQualifiedNameParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DefinitionModelRule__NameAssignment_2"


    // $ANTLR start "rule__DefinitionModelRule__TypesAssignment_4_0"
    // InternalDefinitionLanguage.g:4766:1: rule__DefinitionModelRule__TypesAssignment_4_0 : ( ruleTypeDefinitionRule ) ;
    public final void rule__DefinitionModelRule__TypesAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4770:1: ( ( ruleTypeDefinitionRule ) )
            // InternalDefinitionLanguage.g:4771:2: ( ruleTypeDefinitionRule )
            {
            // InternalDefinitionLanguage.g:4771:2: ( ruleTypeDefinitionRule )
            // InternalDefinitionLanguage.g:4772:3: ruleTypeDefinitionRule
            {
             before(grammarAccess.getDefinitionModelRuleAccess().getTypesTypeDefinitionRuleParserRuleCall_4_0_0()); 
            pushFollow(FOLLOW_2);
            ruleTypeDefinitionRule();

            state._fsp--;

             after(grammarAccess.getDefinitionModelRuleAccess().getTypesTypeDefinitionRuleParserRuleCall_4_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DefinitionModelRule__TypesAssignment_4_0"


    // $ANTLR start "rule__DefinitionModelRule__FunctionsAssignment_4_1"
    // InternalDefinitionLanguage.g:4781:1: rule__DefinitionModelRule__FunctionsAssignment_4_1 : ( ruleFunctionDefinitionRule ) ;
    public final void rule__DefinitionModelRule__FunctionsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4785:1: ( ( ruleFunctionDefinitionRule ) )
            // InternalDefinitionLanguage.g:4786:2: ( ruleFunctionDefinitionRule )
            {
            // InternalDefinitionLanguage.g:4786:2: ( ruleFunctionDefinitionRule )
            // InternalDefinitionLanguage.g:4787:3: ruleFunctionDefinitionRule
            {
             before(grammarAccess.getDefinitionModelRuleAccess().getFunctionsFunctionDefinitionRuleParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleFunctionDefinitionRule();

            state._fsp--;

             after(grammarAccess.getDefinitionModelRuleAccess().getFunctionsFunctionDefinitionRuleParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DefinitionModelRule__FunctionsAssignment_4_1"


    // $ANTLR start "rule__ImportRule__ImportedNamespaceAssignment_1"
    // InternalDefinitionLanguage.g:4796:1: rule__ImportRule__ImportedNamespaceAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__ImportRule__ImportedNamespaceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4800:1: ( ( ruleQualifiedName ) )
            // InternalDefinitionLanguage.g:4801:2: ( ruleQualifiedName )
            {
            // InternalDefinitionLanguage.g:4801:2: ( ruleQualifiedName )
            // InternalDefinitionLanguage.g:4802:3: ruleQualifiedName
            {
             before(grammarAccess.getImportRuleAccess().getImportedNamespaceQualifiedNameParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getImportRuleAccess().getImportedNamespaceQualifiedNameParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportRule__ImportedNamespaceAssignment_1"


    // $ANTLR start "rule__OrExpressionRule__SubExpressionsAssignment_0"
    // InternalDefinitionLanguage.g:4811:1: rule__OrExpressionRule__SubExpressionsAssignment_0 : ( ruleXorExpressionRule ) ;
    public final void rule__OrExpressionRule__SubExpressionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4815:1: ( ( ruleXorExpressionRule ) )
            // InternalDefinitionLanguage.g:4816:2: ( ruleXorExpressionRule )
            {
            // InternalDefinitionLanguage.g:4816:2: ( ruleXorExpressionRule )
            // InternalDefinitionLanguage.g:4817:3: ruleXorExpressionRule
            {
             before(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsXorExpressionRuleParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleXorExpressionRule();

            state._fsp--;

             after(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsXorExpressionRuleParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpressionRule__SubExpressionsAssignment_0"


    // $ANTLR start "rule__OrExpressionRule__SubExpressionsAssignment_1_1"
    // InternalDefinitionLanguage.g:4826:1: rule__OrExpressionRule__SubExpressionsAssignment_1_1 : ( ruleXorExpressionRule ) ;
    public final void rule__OrExpressionRule__SubExpressionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4830:1: ( ( ruleXorExpressionRule ) )
            // InternalDefinitionLanguage.g:4831:2: ( ruleXorExpressionRule )
            {
            // InternalDefinitionLanguage.g:4831:2: ( ruleXorExpressionRule )
            // InternalDefinitionLanguage.g:4832:3: ruleXorExpressionRule
            {
             before(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsXorExpressionRuleParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleXorExpressionRule();

            state._fsp--;

             after(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsXorExpressionRuleParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpressionRule__SubExpressionsAssignment_1_1"


    // $ANTLR start "rule__XorExpressionRule__SubExpressionsAssignment_0"
    // InternalDefinitionLanguage.g:4841:1: rule__XorExpressionRule__SubExpressionsAssignment_0 : ( ruleAndExpressionRule ) ;
    public final void rule__XorExpressionRule__SubExpressionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4845:1: ( ( ruleAndExpressionRule ) )
            // InternalDefinitionLanguage.g:4846:2: ( ruleAndExpressionRule )
            {
            // InternalDefinitionLanguage.g:4846:2: ( ruleAndExpressionRule )
            // InternalDefinitionLanguage.g:4847:3: ruleAndExpressionRule
            {
             before(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAndExpressionRuleParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleAndExpressionRule();

            state._fsp--;

             after(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAndExpressionRuleParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XorExpressionRule__SubExpressionsAssignment_0"


    // $ANTLR start "rule__XorExpressionRule__SubExpressionsAssignment_1_1"
    // InternalDefinitionLanguage.g:4856:1: rule__XorExpressionRule__SubExpressionsAssignment_1_1 : ( ruleAndExpressionRule ) ;
    public final void rule__XorExpressionRule__SubExpressionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4860:1: ( ( ruleAndExpressionRule ) )
            // InternalDefinitionLanguage.g:4861:2: ( ruleAndExpressionRule )
            {
            // InternalDefinitionLanguage.g:4861:2: ( ruleAndExpressionRule )
            // InternalDefinitionLanguage.g:4862:3: ruleAndExpressionRule
            {
             before(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAndExpressionRuleParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleAndExpressionRule();

            state._fsp--;

             after(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAndExpressionRuleParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XorExpressionRule__SubExpressionsAssignment_1_1"


    // $ANTLR start "rule__AndExpressionRule__SubExpressionsAssignment_0"
    // InternalDefinitionLanguage.g:4871:1: rule__AndExpressionRule__SubExpressionsAssignment_0 : ( ruleNotExpressionRule ) ;
    public final void rule__AndExpressionRule__SubExpressionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4875:1: ( ( ruleNotExpressionRule ) )
            // InternalDefinitionLanguage.g:4876:2: ( ruleNotExpressionRule )
            {
            // InternalDefinitionLanguage.g:4876:2: ( ruleNotExpressionRule )
            // InternalDefinitionLanguage.g:4877:3: ruleNotExpressionRule
            {
             before(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsNotExpressionRuleParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleNotExpressionRule();

            state._fsp--;

             after(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsNotExpressionRuleParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpressionRule__SubExpressionsAssignment_0"


    // $ANTLR start "rule__AndExpressionRule__SubExpressionsAssignment_1_1"
    // InternalDefinitionLanguage.g:4886:1: rule__AndExpressionRule__SubExpressionsAssignment_1_1 : ( ruleNotExpressionRule ) ;
    public final void rule__AndExpressionRule__SubExpressionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4890:1: ( ( ruleNotExpressionRule ) )
            // InternalDefinitionLanguage.g:4891:2: ( ruleNotExpressionRule )
            {
            // InternalDefinitionLanguage.g:4891:2: ( ruleNotExpressionRule )
            // InternalDefinitionLanguage.g:4892:3: ruleNotExpressionRule
            {
             before(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsNotExpressionRuleParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleNotExpressionRule();

            state._fsp--;

             after(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsNotExpressionRuleParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpressionRule__SubExpressionsAssignment_1_1"


    // $ANTLR start "rule__NotExpressionRule__NegatedAssignment_0"
    // InternalDefinitionLanguage.g:4901:1: rule__NotExpressionRule__NegatedAssignment_0 : ( ( '!' ) ) ;
    public final void rule__NotExpressionRule__NegatedAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4905:1: ( ( ( '!' ) ) )
            // InternalDefinitionLanguage.g:4906:2: ( ( '!' ) )
            {
            // InternalDefinitionLanguage.g:4906:2: ( ( '!' ) )
            // InternalDefinitionLanguage.g:4907:3: ( '!' )
            {
             before(grammarAccess.getNotExpressionRuleAccess().getNegatedExclamationMarkKeyword_0_0()); 
            // InternalDefinitionLanguage.g:4908:3: ( '!' )
            // InternalDefinitionLanguage.g:4909:4: '!'
            {
             before(grammarAccess.getNotExpressionRuleAccess().getNegatedExclamationMarkKeyword_0_0()); 
            match(input,77,FOLLOW_2); 
             after(grammarAccess.getNotExpressionRuleAccess().getNegatedExclamationMarkKeyword_0_0()); 

            }

             after(grammarAccess.getNotExpressionRuleAccess().getNegatedExclamationMarkKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NotExpressionRule__NegatedAssignment_0"


    // $ANTLR start "rule__NotExpressionRule__OperandAssignment_1"
    // InternalDefinitionLanguage.g:4920:1: rule__NotExpressionRule__OperandAssignment_1 : ( ruleComparisonExpressionRule ) ;
    public final void rule__NotExpressionRule__OperandAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4924:1: ( ( ruleComparisonExpressionRule ) )
            // InternalDefinitionLanguage.g:4925:2: ( ruleComparisonExpressionRule )
            {
            // InternalDefinitionLanguage.g:4925:2: ( ruleComparisonExpressionRule )
            // InternalDefinitionLanguage.g:4926:3: ruleComparisonExpressionRule
            {
             before(grammarAccess.getNotExpressionRuleAccess().getOperandComparisonExpressionRuleParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleComparisonExpressionRule();

            state._fsp--;

             after(grammarAccess.getNotExpressionRuleAccess().getOperandComparisonExpressionRuleParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NotExpressionRule__OperandAssignment_1"


    // $ANTLR start "rule__ComparisonExpressionRule__LeftOperandAssignment_0"
    // InternalDefinitionLanguage.g:4935:1: rule__ComparisonExpressionRule__LeftOperandAssignment_0 : ( ruleAddOrSubtractExpressionRule ) ;
    public final void rule__ComparisonExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4939:1: ( ( ruleAddOrSubtractExpressionRule ) )
            // InternalDefinitionLanguage.g:4940:2: ( ruleAddOrSubtractExpressionRule )
            {
            // InternalDefinitionLanguage.g:4940:2: ( ruleAddOrSubtractExpressionRule )
            // InternalDefinitionLanguage.g:4941:3: ruleAddOrSubtractExpressionRule
            {
             before(grammarAccess.getComparisonExpressionRuleAccess().getLeftOperandAddOrSubtractExpressionRuleParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleAddOrSubtractExpressionRule();

            state._fsp--;

             after(grammarAccess.getComparisonExpressionRuleAccess().getLeftOperandAddOrSubtractExpressionRuleParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComparisonExpressionRule__LeftOperandAssignment_0"


    // $ANTLR start "rule__ComparisonExpressionRule__ComparisonAssignment_1"
    // InternalDefinitionLanguage.g:4950:1: rule__ComparisonExpressionRule__ComparisonAssignment_1 : ( rulePartialComparisonExpressionRule ) ;
    public final void rule__ComparisonExpressionRule__ComparisonAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4954:1: ( ( rulePartialComparisonExpressionRule ) )
            // InternalDefinitionLanguage.g:4955:2: ( rulePartialComparisonExpressionRule )
            {
            // InternalDefinitionLanguage.g:4955:2: ( rulePartialComparisonExpressionRule )
            // InternalDefinitionLanguage.g:4956:3: rulePartialComparisonExpressionRule
            {
             before(grammarAccess.getComparisonExpressionRuleAccess().getComparisonPartialComparisonExpressionRuleParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            rulePartialComparisonExpressionRule();

            state._fsp--;

             after(grammarAccess.getComparisonExpressionRuleAccess().getComparisonPartialComparisonExpressionRuleParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComparisonExpressionRule__ComparisonAssignment_1"


    // $ANTLR start "rule__PartialComparisonExpressionRule__OperatorAssignment_0"
    // InternalDefinitionLanguage.g:4965:1: rule__PartialComparisonExpressionRule__OperatorAssignment_0 : ( ruleComparisonOperatorRule ) ;
    public final void rule__PartialComparisonExpressionRule__OperatorAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4969:1: ( ( ruleComparisonOperatorRule ) )
            // InternalDefinitionLanguage.g:4970:2: ( ruleComparisonOperatorRule )
            {
            // InternalDefinitionLanguage.g:4970:2: ( ruleComparisonOperatorRule )
            // InternalDefinitionLanguage.g:4971:3: ruleComparisonOperatorRule
            {
             before(grammarAccess.getPartialComparisonExpressionRuleAccess().getOperatorComparisonOperatorRuleEnumRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleComparisonOperatorRule();

            state._fsp--;

             after(grammarAccess.getPartialComparisonExpressionRuleAccess().getOperatorComparisonOperatorRuleEnumRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PartialComparisonExpressionRule__OperatorAssignment_0"


    // $ANTLR start "rule__PartialComparisonExpressionRule__SubExpressionAssignment_1"
    // InternalDefinitionLanguage.g:4980:1: rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 : ( ruleAddOrSubtractExpressionRule ) ;
    public final void rule__PartialComparisonExpressionRule__SubExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4984:1: ( ( ruleAddOrSubtractExpressionRule ) )
            // InternalDefinitionLanguage.g:4985:2: ( ruleAddOrSubtractExpressionRule )
            {
            // InternalDefinitionLanguage.g:4985:2: ( ruleAddOrSubtractExpressionRule )
            // InternalDefinitionLanguage.g:4986:3: ruleAddOrSubtractExpressionRule
            {
             before(grammarAccess.getPartialComparisonExpressionRuleAccess().getSubExpressionAddOrSubtractExpressionRuleParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleAddOrSubtractExpressionRule();

            state._fsp--;

             after(grammarAccess.getPartialComparisonExpressionRuleAccess().getSubExpressionAddOrSubtractExpressionRuleParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PartialComparisonExpressionRule__SubExpressionAssignment_1"


    // $ANTLR start "rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0"
    // InternalDefinitionLanguage.g:4995:1: rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 : ( ruleMultiplyDivideModuloExpressionRule ) ;
    public final void rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4999:1: ( ( ruleMultiplyDivideModuloExpressionRule ) )
            // InternalDefinitionLanguage.g:5000:2: ( ruleMultiplyDivideModuloExpressionRule )
            {
            // InternalDefinitionLanguage.g:5000:2: ( ruleMultiplyDivideModuloExpressionRule )
            // InternalDefinitionLanguage.g:5001:3: ruleMultiplyDivideModuloExpressionRule
            {
             before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getLeftOperandMultiplyDivideModuloExpressionRuleParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleMultiplyDivideModuloExpressionRule();

            state._fsp--;

             after(grammarAccess.getAddOrSubtractExpressionRuleAccess().getLeftOperandMultiplyDivideModuloExpressionRuleParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0"


    // $ANTLR start "rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0"
    // InternalDefinitionLanguage.g:5010:1: rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 : ( ruleAddOrSubtractOperatorRule ) ;
    public final void rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5014:1: ( ( ruleAddOrSubtractOperatorRule ) )
            // InternalDefinitionLanguage.g:5015:2: ( ruleAddOrSubtractOperatorRule )
            {
            // InternalDefinitionLanguage.g:5015:2: ( ruleAddOrSubtractOperatorRule )
            // InternalDefinitionLanguage.g:5016:3: ruleAddOrSubtractOperatorRule
            {
             before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperatorsAddOrSubtractOperatorRuleEnumRuleCall_1_0_0()); 
            pushFollow(FOLLOW_2);
            ruleAddOrSubtractOperatorRule();

            state._fsp--;

             after(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperatorsAddOrSubtractOperatorRuleEnumRuleCall_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0"


    // $ANTLR start "rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1"
    // InternalDefinitionLanguage.g:5025:1: rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 : ( ruleMultiplyDivideModuloExpressionRule ) ;
    public final void rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5029:1: ( ( ruleMultiplyDivideModuloExpressionRule ) )
            // InternalDefinitionLanguage.g:5030:2: ( ruleMultiplyDivideModuloExpressionRule )
            {
            // InternalDefinitionLanguage.g:5030:2: ( ruleMultiplyDivideModuloExpressionRule )
            // InternalDefinitionLanguage.g:5031:3: ruleMultiplyDivideModuloExpressionRule
            {
             before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperandsMultiplyDivideModuloExpressionRuleParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleMultiplyDivideModuloExpressionRule();

            state._fsp--;

             after(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperandsMultiplyDivideModuloExpressionRuleParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1"


    // $ANTLR start "rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0"
    // InternalDefinitionLanguage.g:5040:1: rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 : ( rulePowerOfExpressionRule ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5044:1: ( ( rulePowerOfExpressionRule ) )
            // InternalDefinitionLanguage.g:5045:2: ( rulePowerOfExpressionRule )
            {
            // InternalDefinitionLanguage.g:5045:2: ( rulePowerOfExpressionRule )
            // InternalDefinitionLanguage.g:5046:3: rulePowerOfExpressionRule
            {
             before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getLeftOperandPowerOfExpressionRuleParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            rulePowerOfExpressionRule();

            state._fsp--;

             after(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getLeftOperandPowerOfExpressionRuleParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0"


    // $ANTLR start "rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0"
    // InternalDefinitionLanguage.g:5055:1: rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 : ( ruleMultiplyDivideModuloOperatorRule ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5059:1: ( ( ruleMultiplyDivideModuloOperatorRule ) )
            // InternalDefinitionLanguage.g:5060:2: ( ruleMultiplyDivideModuloOperatorRule )
            {
            // InternalDefinitionLanguage.g:5060:2: ( ruleMultiplyDivideModuloOperatorRule )
            // InternalDefinitionLanguage.g:5061:3: ruleMultiplyDivideModuloOperatorRule
            {
             before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperatorsMultiplyDivideModuloOperatorRuleEnumRuleCall_1_0_0()); 
            pushFollow(FOLLOW_2);
            ruleMultiplyDivideModuloOperatorRule();

            state._fsp--;

             after(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperatorsMultiplyDivideModuloOperatorRuleEnumRuleCall_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0"


    // $ANTLR start "rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1"
    // InternalDefinitionLanguage.g:5070:1: rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 : ( rulePowerOfExpressionRule ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5074:1: ( ( rulePowerOfExpressionRule ) )
            // InternalDefinitionLanguage.g:5075:2: ( rulePowerOfExpressionRule )
            {
            // InternalDefinitionLanguage.g:5075:2: ( rulePowerOfExpressionRule )
            // InternalDefinitionLanguage.g:5076:3: rulePowerOfExpressionRule
            {
             before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperandsPowerOfExpressionRuleParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            rulePowerOfExpressionRule();

            state._fsp--;

             after(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperandsPowerOfExpressionRuleParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1"


    // $ANTLR start "rule__PowerOfExpressionRule__LeftOperandAssignment_0"
    // InternalDefinitionLanguage.g:5085:1: rule__PowerOfExpressionRule__LeftOperandAssignment_0 : ( ruleUnaryAddOrSubtractExpressionRule ) ;
    public final void rule__PowerOfExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5089:1: ( ( ruleUnaryAddOrSubtractExpressionRule ) )
            // InternalDefinitionLanguage.g:5090:2: ( ruleUnaryAddOrSubtractExpressionRule )
            {
            // InternalDefinitionLanguage.g:5090:2: ( ruleUnaryAddOrSubtractExpressionRule )
            // InternalDefinitionLanguage.g:5091:3: ruleUnaryAddOrSubtractExpressionRule
            {
             before(grammarAccess.getPowerOfExpressionRuleAccess().getLeftOperandUnaryAddOrSubtractExpressionRuleParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleUnaryAddOrSubtractExpressionRule();

            state._fsp--;

             after(grammarAccess.getPowerOfExpressionRuleAccess().getLeftOperandUnaryAddOrSubtractExpressionRuleParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PowerOfExpressionRule__LeftOperandAssignment_0"


    // $ANTLR start "rule__PowerOfExpressionRule__RightOperandAssignment_1_1"
    // InternalDefinitionLanguage.g:5100:1: rule__PowerOfExpressionRule__RightOperandAssignment_1_1 : ( rulePowerOfExpressionRule ) ;
    public final void rule__PowerOfExpressionRule__RightOperandAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5104:1: ( ( rulePowerOfExpressionRule ) )
            // InternalDefinitionLanguage.g:5105:2: ( rulePowerOfExpressionRule )
            {
            // InternalDefinitionLanguage.g:5105:2: ( rulePowerOfExpressionRule )
            // InternalDefinitionLanguage.g:5106:3: rulePowerOfExpressionRule
            {
             before(grammarAccess.getPowerOfExpressionRuleAccess().getRightOperandPowerOfExpressionRuleParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            rulePowerOfExpressionRule();

            state._fsp--;

             after(grammarAccess.getPowerOfExpressionRuleAccess().getRightOperandPowerOfExpressionRuleParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PowerOfExpressionRule__RightOperandAssignment_1_1"


    // $ANTLR start "rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0"
    // InternalDefinitionLanguage.g:5115:1: rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 : ( ruleAddOrSubtractOperatorRule ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5119:1: ( ( ruleAddOrSubtractOperatorRule ) )
            // InternalDefinitionLanguage.g:5120:2: ( ruleAddOrSubtractOperatorRule )
            {
            // InternalDefinitionLanguage.g:5120:2: ( ruleAddOrSubtractOperatorRule )
            // InternalDefinitionLanguage.g:5121:3: ruleAddOrSubtractOperatorRule
            {
             before(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getOperatorsAddOrSubtractOperatorRuleEnumRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleAddOrSubtractOperatorRule();

            state._fsp--;

             after(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getOperatorsAddOrSubtractOperatorRuleEnumRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0"


    // $ANTLR start "rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1"
    // InternalDefinitionLanguage.g:5130:1: rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 : ( ruleLiteralOrReferenceRule ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5134:1: ( ( ruleLiteralOrReferenceRule ) )
            // InternalDefinitionLanguage.g:5135:2: ( ruleLiteralOrReferenceRule )
            {
            // InternalDefinitionLanguage.g:5135:2: ( ruleLiteralOrReferenceRule )
            // InternalDefinitionLanguage.g:5136:3: ruleLiteralOrReferenceRule
            {
             before(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getSubExpressionLiteralOrReferenceRuleParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleLiteralOrReferenceRule();

            state._fsp--;

             after(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getSubExpressionLiteralOrReferenceRuleParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1"


    // $ANTLR start "rule__ParanthesesRule__SubExpressionAssignment_1"
    // InternalDefinitionLanguage.g:5145:1: rule__ParanthesesRule__SubExpressionAssignment_1 : ( ruleExpressionRule ) ;
    public final void rule__ParanthesesRule__SubExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5149:1: ( ( ruleExpressionRule ) )
            // InternalDefinitionLanguage.g:5150:2: ( ruleExpressionRule )
            {
            // InternalDefinitionLanguage.g:5150:2: ( ruleExpressionRule )
            // InternalDefinitionLanguage.g:5151:3: ruleExpressionRule
            {
             before(grammarAccess.getParanthesesRuleAccess().getSubExpressionExpressionRuleParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleExpressionRule();

            state._fsp--;

             after(grammarAccess.getParanthesesRuleAccess().getSubExpressionExpressionRuleParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParanthesesRule__SubExpressionAssignment_1"


    // $ANTLR start "rule__CallRule__FunctionAssignment_0"
    // InternalDefinitionLanguage.g:5160:1: rule__CallRule__FunctionAssignment_0 : ( ruleFunctionNameRule ) ;
    public final void rule__CallRule__FunctionAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5164:1: ( ( ruleFunctionNameRule ) )
            // InternalDefinitionLanguage.g:5165:2: ( ruleFunctionNameRule )
            {
            // InternalDefinitionLanguage.g:5165:2: ( ruleFunctionNameRule )
            // InternalDefinitionLanguage.g:5166:3: ruleFunctionNameRule
            {
             before(grammarAccess.getCallRuleAccess().getFunctionFunctionNameRuleParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleFunctionNameRule();

            state._fsp--;

             after(grammarAccess.getCallRuleAccess().getFunctionFunctionNameRuleParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CallRule__FunctionAssignment_0"


    // $ANTLR start "rule__CallRule__ParametersAssignment_2_0"
    // InternalDefinitionLanguage.g:5175:1: rule__CallRule__ParametersAssignment_2_0 : ( ruleExpressionRule ) ;
    public final void rule__CallRule__ParametersAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5179:1: ( ( ruleExpressionRule ) )
            // InternalDefinitionLanguage.g:5180:2: ( ruleExpressionRule )
            {
            // InternalDefinitionLanguage.g:5180:2: ( ruleExpressionRule )
            // InternalDefinitionLanguage.g:5181:3: ruleExpressionRule
            {
             before(grammarAccess.getCallRuleAccess().getParametersExpressionRuleParserRuleCall_2_0_0()); 
            pushFollow(FOLLOW_2);
            ruleExpressionRule();

            state._fsp--;

             after(grammarAccess.getCallRuleAccess().getParametersExpressionRuleParserRuleCall_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CallRule__ParametersAssignment_2_0"


    // $ANTLR start "rule__CallRule__ParametersAssignment_2_1_1"
    // InternalDefinitionLanguage.g:5190:1: rule__CallRule__ParametersAssignment_2_1_1 : ( ruleExpressionRule ) ;
    public final void rule__CallRule__ParametersAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5194:1: ( ( ruleExpressionRule ) )
            // InternalDefinitionLanguage.g:5195:2: ( ruleExpressionRule )
            {
            // InternalDefinitionLanguage.g:5195:2: ( ruleExpressionRule )
            // InternalDefinitionLanguage.g:5196:3: ruleExpressionRule
            {
             before(grammarAccess.getCallRuleAccess().getParametersExpressionRuleParserRuleCall_2_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleExpressionRule();

            state._fsp--;

             after(grammarAccess.getCallRuleAccess().getParametersExpressionRuleParserRuleCall_2_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CallRule__ParametersAssignment_2_1_1"


    // $ANTLR start "rule__DoubleLiteralRule__LiteralAssignment_0"
    // InternalDefinitionLanguage.g:5205:1: rule__DoubleLiteralRule__LiteralAssignment_0 : ( RULE_DOUBLE ) ;
    public final void rule__DoubleLiteralRule__LiteralAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5209:1: ( ( RULE_DOUBLE ) )
            // InternalDefinitionLanguage.g:5210:2: ( RULE_DOUBLE )
            {
            // InternalDefinitionLanguage.g:5210:2: ( RULE_DOUBLE )
            // InternalDefinitionLanguage.g:5211:3: RULE_DOUBLE
            {
             before(grammarAccess.getDoubleLiteralRuleAccess().getLiteralDOUBLETerminalRuleCall_0_0()); 
            match(input,RULE_DOUBLE,FOLLOW_2); 
             after(grammarAccess.getDoubleLiteralRuleAccess().getLiteralDOUBLETerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DoubleLiteralRule__LiteralAssignment_0"


    // $ANTLR start "rule__DoubleLiteralRule__FactorAssignment_1"
    // InternalDefinitionLanguage.g:5220:1: rule__DoubleLiteralRule__FactorAssignment_1 : ( ruleFactorRule ) ;
    public final void rule__DoubleLiteralRule__FactorAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5224:1: ( ( ruleFactorRule ) )
            // InternalDefinitionLanguage.g:5225:2: ( ruleFactorRule )
            {
            // InternalDefinitionLanguage.g:5225:2: ( ruleFactorRule )
            // InternalDefinitionLanguage.g:5226:3: ruleFactorRule
            {
             before(grammarAccess.getDoubleLiteralRuleAccess().getFactorFactorRuleEnumRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleFactorRule();

            state._fsp--;

             after(grammarAccess.getDoubleLiteralRuleAccess().getFactorFactorRuleEnumRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DoubleLiteralRule__FactorAssignment_1"


    // $ANTLR start "rule__IntegerLiteralRule__LiteralAssignment_0"
    // InternalDefinitionLanguage.g:5235:1: rule__IntegerLiteralRule__LiteralAssignment_0 : ( RULE_INT ) ;
    public final void rule__IntegerLiteralRule__LiteralAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5239:1: ( ( RULE_INT ) )
            // InternalDefinitionLanguage.g:5240:2: ( RULE_INT )
            {
            // InternalDefinitionLanguage.g:5240:2: ( RULE_INT )
            // InternalDefinitionLanguage.g:5241:3: RULE_INT
            {
             before(grammarAccess.getIntegerLiteralRuleAccess().getLiteralINTTerminalRuleCall_0_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getIntegerLiteralRuleAccess().getLiteralINTTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntegerLiteralRule__LiteralAssignment_0"


    // $ANTLR start "rule__IntegerLiteralRule__FactorAssignment_1"
    // InternalDefinitionLanguage.g:5250:1: rule__IntegerLiteralRule__FactorAssignment_1 : ( ruleFactorRule ) ;
    public final void rule__IntegerLiteralRule__FactorAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5254:1: ( ( ruleFactorRule ) )
            // InternalDefinitionLanguage.g:5255:2: ( ruleFactorRule )
            {
            // InternalDefinitionLanguage.g:5255:2: ( ruleFactorRule )
            // InternalDefinitionLanguage.g:5256:3: ruleFactorRule
            {
             before(grammarAccess.getIntegerLiteralRuleAccess().getFactorFactorRuleEnumRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleFactorRule();

            state._fsp--;

             after(grammarAccess.getIntegerLiteralRuleAccess().getFactorFactorRuleEnumRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntegerLiteralRule__FactorAssignment_1"


    // $ANTLR start "rule__StringLiteralRule__ValueAssignment"
    // InternalDefinitionLanguage.g:5265:1: rule__StringLiteralRule__ValueAssignment : ( RULE_STRING ) ;
    public final void rule__StringLiteralRule__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5269:1: ( ( RULE_STRING ) )
            // InternalDefinitionLanguage.g:5270:2: ( RULE_STRING )
            {
            // InternalDefinitionLanguage.g:5270:2: ( RULE_STRING )
            // InternalDefinitionLanguage.g:5271:3: RULE_STRING
            {
             before(grammarAccess.getStringLiteralRuleAccess().getValueSTRINGTerminalRuleCall_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getStringLiteralRuleAccess().getValueSTRINGTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StringLiteralRule__ValueAssignment"


    // $ANTLR start "rule__BooleanLiteralRule__ValueAssignment_1_0"
    // InternalDefinitionLanguage.g:5280:1: rule__BooleanLiteralRule__ValueAssignment_1_0 : ( ( 'true' ) ) ;
    public final void rule__BooleanLiteralRule__ValueAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5284:1: ( ( ( 'true' ) ) )
            // InternalDefinitionLanguage.g:5285:2: ( ( 'true' ) )
            {
            // InternalDefinitionLanguage.g:5285:2: ( ( 'true' ) )
            // InternalDefinitionLanguage.g:5286:3: ( 'true' )
            {
             before(grammarAccess.getBooleanLiteralRuleAccess().getValueTrueKeyword_1_0_0()); 
            // InternalDefinitionLanguage.g:5287:3: ( 'true' )
            // InternalDefinitionLanguage.g:5288:4: 'true'
            {
             before(grammarAccess.getBooleanLiteralRuleAccess().getValueTrueKeyword_1_0_0()); 
            match(input,78,FOLLOW_2); 
             after(grammarAccess.getBooleanLiteralRuleAccess().getValueTrueKeyword_1_0_0()); 

            }

             after(grammarAccess.getBooleanLiteralRuleAccess().getValueTrueKeyword_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanLiteralRule__ValueAssignment_1_0"


    // $ANTLR start "rule__TypeDefinitionRule__AbstractAssignment_0"
    // InternalDefinitionLanguage.g:5299:1: rule__TypeDefinitionRule__AbstractAssignment_0 : ( ( 'abstract' ) ) ;
    public final void rule__TypeDefinitionRule__AbstractAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5303:1: ( ( ( 'abstract' ) ) )
            // InternalDefinitionLanguage.g:5304:2: ( ( 'abstract' ) )
            {
            // InternalDefinitionLanguage.g:5304:2: ( ( 'abstract' ) )
            // InternalDefinitionLanguage.g:5305:3: ( 'abstract' )
            {
             before(grammarAccess.getTypeDefinitionRuleAccess().getAbstractAbstractKeyword_0_0()); 
            // InternalDefinitionLanguage.g:5306:3: ( 'abstract' )
            // InternalDefinitionLanguage.g:5307:4: 'abstract'
            {
             before(grammarAccess.getTypeDefinitionRuleAccess().getAbstractAbstractKeyword_0_0()); 
            match(input,79,FOLLOW_2); 
             after(grammarAccess.getTypeDefinitionRuleAccess().getAbstractAbstractKeyword_0_0()); 

            }

             after(grammarAccess.getTypeDefinitionRuleAccess().getAbstractAbstractKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeDefinitionRule__AbstractAssignment_0"


    // $ANTLR start "rule__TypeDefinitionRule__NameAssignment_2"
    // InternalDefinitionLanguage.g:5318:1: rule__TypeDefinitionRule__NameAssignment_2 : ( ruleStringOrId ) ;
    public final void rule__TypeDefinitionRule__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5322:1: ( ( ruleStringOrId ) )
            // InternalDefinitionLanguage.g:5323:2: ( ruleStringOrId )
            {
            // InternalDefinitionLanguage.g:5323:2: ( ruleStringOrId )
            // InternalDefinitionLanguage.g:5324:3: ruleStringOrId
            {
             before(grammarAccess.getTypeDefinitionRuleAccess().getNameStringOrIdParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleStringOrId();

            state._fsp--;

             after(grammarAccess.getTypeDefinitionRuleAccess().getNameStringOrIdParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeDefinitionRule__NameAssignment_2"


    // $ANTLR start "rule__TypeDefinitionRule__SuperTypeAssignment_3_1"
    // InternalDefinitionLanguage.g:5333:1: rule__TypeDefinitionRule__SuperTypeAssignment_3_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__TypeDefinitionRule__SuperTypeAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5337:1: ( ( ( ruleQualifiedName ) ) )
            // InternalDefinitionLanguage.g:5338:2: ( ( ruleQualifiedName ) )
            {
            // InternalDefinitionLanguage.g:5338:2: ( ( ruleQualifiedName ) )
            // InternalDefinitionLanguage.g:5339:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getTypeDefinitionRuleAccess().getSuperTypeTypeDefinitionCrossReference_3_1_0()); 
            // InternalDefinitionLanguage.g:5340:3: ( ruleQualifiedName )
            // InternalDefinitionLanguage.g:5341:4: ruleQualifiedName
            {
             before(grammarAccess.getTypeDefinitionRuleAccess().getSuperTypeTypeDefinitionQualifiedNameParserRuleCall_3_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getTypeDefinitionRuleAccess().getSuperTypeTypeDefinitionQualifiedNameParserRuleCall_3_1_0_1()); 

            }

             after(grammarAccess.getTypeDefinitionRuleAccess().getSuperTypeTypeDefinitionCrossReference_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeDefinitionRule__SuperTypeAssignment_3_1"


    // $ANTLR start "rule__TypeDefinitionRule__AttributesAssignment_5"
    // InternalDefinitionLanguage.g:5352:1: rule__TypeDefinitionRule__AttributesAssignment_5 : ( ruleAttributeDefinitionRule ) ;
    public final void rule__TypeDefinitionRule__AttributesAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5356:1: ( ( ruleAttributeDefinitionRule ) )
            // InternalDefinitionLanguage.g:5357:2: ( ruleAttributeDefinitionRule )
            {
            // InternalDefinitionLanguage.g:5357:2: ( ruleAttributeDefinitionRule )
            // InternalDefinitionLanguage.g:5358:3: ruleAttributeDefinitionRule
            {
             before(grammarAccess.getTypeDefinitionRuleAccess().getAttributesAttributeDefinitionRuleParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleAttributeDefinitionRule();

            state._fsp--;

             after(grammarAccess.getTypeDefinitionRuleAccess().getAttributesAttributeDefinitionRuleParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeDefinitionRule__AttributesAssignment_5"


    // $ANTLR start "rule__AttributeDefinitionRule__NameAssignment_0"
    // InternalDefinitionLanguage.g:5367:1: rule__AttributeDefinitionRule__NameAssignment_0 : ( ruleStringOrId ) ;
    public final void rule__AttributeDefinitionRule__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5371:1: ( ( ruleStringOrId ) )
            // InternalDefinitionLanguage.g:5372:2: ( ruleStringOrId )
            {
            // InternalDefinitionLanguage.g:5372:2: ( ruleStringOrId )
            // InternalDefinitionLanguage.g:5373:3: ruleStringOrId
            {
             before(grammarAccess.getAttributeDefinitionRuleAccess().getNameStringOrIdParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleStringOrId();

            state._fsp--;

             after(grammarAccess.getAttributeDefinitionRuleAccess().getNameStringOrIdParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeDefinitionRule__NameAssignment_0"


    // $ANTLR start "rule__AttributeDefinitionRule__TypeAssignment_2"
    // InternalDefinitionLanguage.g:5382:1: rule__AttributeDefinitionRule__TypeAssignment_2 : ( ruleTypeRule ) ;
    public final void rule__AttributeDefinitionRule__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5386:1: ( ( ruleTypeRule ) )
            // InternalDefinitionLanguage.g:5387:2: ( ruleTypeRule )
            {
            // InternalDefinitionLanguage.g:5387:2: ( ruleTypeRule )
            // InternalDefinitionLanguage.g:5388:3: ruleTypeRule
            {
             before(grammarAccess.getAttributeDefinitionRuleAccess().getTypeTypeRuleParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleTypeRule();

            state._fsp--;

             after(grammarAccess.getAttributeDefinitionRuleAccess().getTypeTypeRuleParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeDefinitionRule__TypeAssignment_2"


    // $ANTLR start "rule__AttributeDefinitionRule__InitialisationAssignment_3_1"
    // InternalDefinitionLanguage.g:5397:1: rule__AttributeDefinitionRule__InitialisationAssignment_3_1 : ( ruleExpressionRule ) ;
    public final void rule__AttributeDefinitionRule__InitialisationAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5401:1: ( ( ruleExpressionRule ) )
            // InternalDefinitionLanguage.g:5402:2: ( ruleExpressionRule )
            {
            // InternalDefinitionLanguage.g:5402:2: ( ruleExpressionRule )
            // InternalDefinitionLanguage.g:5403:3: ruleExpressionRule
            {
             before(grammarAccess.getAttributeDefinitionRuleAccess().getInitialisationExpressionRuleParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleExpressionRule();

            state._fsp--;

             after(grammarAccess.getAttributeDefinitionRuleAccess().getInitialisationExpressionRuleParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeDefinitionRule__InitialisationAssignment_3_1"


    // $ANTLR start "rule__InstanceTypeRule__DefinitionsAssignment_2"
    // InternalDefinitionLanguage.g:5412:1: rule__InstanceTypeRule__DefinitionsAssignment_2 : ( ( ruleQualifiedName ) ) ;
    public final void rule__InstanceTypeRule__DefinitionsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5416:1: ( ( ( ruleQualifiedName ) ) )
            // InternalDefinitionLanguage.g:5417:2: ( ( ruleQualifiedName ) )
            {
            // InternalDefinitionLanguage.g:5417:2: ( ( ruleQualifiedName ) )
            // InternalDefinitionLanguage.g:5418:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getInstanceTypeRuleAccess().getDefinitionsTypeDefinitionCrossReference_2_0()); 
            // InternalDefinitionLanguage.g:5419:3: ( ruleQualifiedName )
            // InternalDefinitionLanguage.g:5420:4: ruleQualifiedName
            {
             before(grammarAccess.getInstanceTypeRuleAccess().getDefinitionsTypeDefinitionQualifiedNameParserRuleCall_2_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getInstanceTypeRuleAccess().getDefinitionsTypeDefinitionQualifiedNameParserRuleCall_2_0_1()); 

            }

             after(grammarAccess.getInstanceTypeRuleAccess().getDefinitionsTypeDefinitionCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceTypeRule__DefinitionsAssignment_2"


    // $ANTLR start "rule__InstanceTypeRule__DefinitionsAssignment_3_1"
    // InternalDefinitionLanguage.g:5431:1: rule__InstanceTypeRule__DefinitionsAssignment_3_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__InstanceTypeRule__DefinitionsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5435:1: ( ( ( ruleQualifiedName ) ) )
            // InternalDefinitionLanguage.g:5436:2: ( ( ruleQualifiedName ) )
            {
            // InternalDefinitionLanguage.g:5436:2: ( ( ruleQualifiedName ) )
            // InternalDefinitionLanguage.g:5437:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getInstanceTypeRuleAccess().getDefinitionsTypeDefinitionCrossReference_3_1_0()); 
            // InternalDefinitionLanguage.g:5438:3: ( ruleQualifiedName )
            // InternalDefinitionLanguage.g:5439:4: ruleQualifiedName
            {
             before(grammarAccess.getInstanceTypeRuleAccess().getDefinitionsTypeDefinitionQualifiedNameParserRuleCall_3_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getInstanceTypeRuleAccess().getDefinitionsTypeDefinitionQualifiedNameParserRuleCall_3_1_0_1()); 

            }

             after(grammarAccess.getInstanceTypeRuleAccess().getDefinitionsTypeDefinitionCrossReference_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceTypeRule__DefinitionsAssignment_3_1"


    // $ANTLR start "rule__ArrayTypeRule__ElementsAssignment_1"
    // InternalDefinitionLanguage.g:5450:1: rule__ArrayTypeRule__ElementsAssignment_1 : ( ruleTypeRule ) ;
    public final void rule__ArrayTypeRule__ElementsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5454:1: ( ( ruleTypeRule ) )
            // InternalDefinitionLanguage.g:5455:2: ( ruleTypeRule )
            {
            // InternalDefinitionLanguage.g:5455:2: ( ruleTypeRule )
            // InternalDefinitionLanguage.g:5456:3: ruleTypeRule
            {
             before(grammarAccess.getArrayTypeRuleAccess().getElementsTypeRuleParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTypeRule();

            state._fsp--;

             after(grammarAccess.getArrayTypeRuleAccess().getElementsTypeRuleParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrayTypeRule__ElementsAssignment_1"


    // $ANTLR start "rule__FunctionDefinitionRule__TypeAssignment_1"
    // InternalDefinitionLanguage.g:5465:1: rule__FunctionDefinitionRule__TypeAssignment_1 : ( ruleTypeRule ) ;
    public final void rule__FunctionDefinitionRule__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5469:1: ( ( ruleTypeRule ) )
            // InternalDefinitionLanguage.g:5470:2: ( ruleTypeRule )
            {
            // InternalDefinitionLanguage.g:5470:2: ( ruleTypeRule )
            // InternalDefinitionLanguage.g:5471:3: ruleTypeRule
            {
             before(grammarAccess.getFunctionDefinitionRuleAccess().getTypeTypeRuleParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTypeRule();

            state._fsp--;

             after(grammarAccess.getFunctionDefinitionRuleAccess().getTypeTypeRuleParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__TypeAssignment_1"


    // $ANTLR start "rule__FunctionDefinitionRule__NameAssignment_2"
    // InternalDefinitionLanguage.g:5480:1: rule__FunctionDefinitionRule__NameAssignment_2 : ( ruleStringOrId ) ;
    public final void rule__FunctionDefinitionRule__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5484:1: ( ( ruleStringOrId ) )
            // InternalDefinitionLanguage.g:5485:2: ( ruleStringOrId )
            {
            // InternalDefinitionLanguage.g:5485:2: ( ruleStringOrId )
            // InternalDefinitionLanguage.g:5486:3: ruleStringOrId
            {
             before(grammarAccess.getFunctionDefinitionRuleAccess().getNameStringOrIdParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleStringOrId();

            state._fsp--;

             after(grammarAccess.getFunctionDefinitionRuleAccess().getNameStringOrIdParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__NameAssignment_2"


    // $ANTLR start "rule__FunctionDefinitionRule__ParametersAssignment_4_0"
    // InternalDefinitionLanguage.g:5495:1: rule__FunctionDefinitionRule__ParametersAssignment_4_0 : ( ruleParameterRule ) ;
    public final void rule__FunctionDefinitionRule__ParametersAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5499:1: ( ( ruleParameterRule ) )
            // InternalDefinitionLanguage.g:5500:2: ( ruleParameterRule )
            {
            // InternalDefinitionLanguage.g:5500:2: ( ruleParameterRule )
            // InternalDefinitionLanguage.g:5501:3: ruleParameterRule
            {
             before(grammarAccess.getFunctionDefinitionRuleAccess().getParametersParameterRuleParserRuleCall_4_0_0()); 
            pushFollow(FOLLOW_2);
            ruleParameterRule();

            state._fsp--;

             after(grammarAccess.getFunctionDefinitionRuleAccess().getParametersParameterRuleParserRuleCall_4_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__ParametersAssignment_4_0"


    // $ANTLR start "rule__FunctionDefinitionRule__ParametersAssignment_4_1_1"
    // InternalDefinitionLanguage.g:5510:1: rule__FunctionDefinitionRule__ParametersAssignment_4_1_1 : ( ruleParameterRule ) ;
    public final void rule__FunctionDefinitionRule__ParametersAssignment_4_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5514:1: ( ( ruleParameterRule ) )
            // InternalDefinitionLanguage.g:5515:2: ( ruleParameterRule )
            {
            // InternalDefinitionLanguage.g:5515:2: ( ruleParameterRule )
            // InternalDefinitionLanguage.g:5516:3: ruleParameterRule
            {
             before(grammarAccess.getFunctionDefinitionRuleAccess().getParametersParameterRuleParserRuleCall_4_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleParameterRule();

            state._fsp--;

             after(grammarAccess.getFunctionDefinitionRuleAccess().getParametersParameterRuleParserRuleCall_4_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__ParametersAssignment_4_1_1"


    // $ANTLR start "rule__ParameterRule__TypeAssignment_0"
    // InternalDefinitionLanguage.g:5525:1: rule__ParameterRule__TypeAssignment_0 : ( ruleTypeRule ) ;
    public final void rule__ParameterRule__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5529:1: ( ( ruleTypeRule ) )
            // InternalDefinitionLanguage.g:5530:2: ( ruleTypeRule )
            {
            // InternalDefinitionLanguage.g:5530:2: ( ruleTypeRule )
            // InternalDefinitionLanguage.g:5531:3: ruleTypeRule
            {
             before(grammarAccess.getParameterRuleAccess().getTypeTypeRuleParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleTypeRule();

            state._fsp--;

             after(grammarAccess.getParameterRuleAccess().getTypeTypeRuleParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterRule__TypeAssignment_0"


    // $ANTLR start "rule__ParameterRule__NameAssignment_1"
    // InternalDefinitionLanguage.g:5540:1: rule__ParameterRule__NameAssignment_1 : ( ruleStringOrId ) ;
    public final void rule__ParameterRule__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5544:1: ( ( ruleStringOrId ) )
            // InternalDefinitionLanguage.g:5545:2: ( ruleStringOrId )
            {
            // InternalDefinitionLanguage.g:5545:2: ( ruleStringOrId )
            // InternalDefinitionLanguage.g:5546:3: ruleStringOrId
            {
             before(grammarAccess.getParameterRuleAccess().getNameStringOrIdParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleStringOrId();

            state._fsp--;

             after(grammarAccess.getParameterRuleAccess().getNameStringOrIdParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterRule__NameAssignment_1"


    // $ANTLR start "rule__FunctionNameRule__DefinitionAssignment"
    // InternalDefinitionLanguage.g:5555:1: rule__FunctionNameRule__DefinitionAssignment : ( ( ruleQualifiedName ) ) ;
    public final void rule__FunctionNameRule__DefinitionAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5559:1: ( ( ( ruleQualifiedName ) ) )
            // InternalDefinitionLanguage.g:5560:2: ( ( ruleQualifiedName ) )
            {
            // InternalDefinitionLanguage.g:5560:2: ( ( ruleQualifiedName ) )
            // InternalDefinitionLanguage.g:5561:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getFunctionNameRuleAccess().getDefinitionFunctionDefinitionCrossReference_0()); 
            // InternalDefinitionLanguage.g:5562:3: ( ruleQualifiedName )
            // InternalDefinitionLanguage.g:5563:4: ruleQualifiedName
            {
             before(grammarAccess.getFunctionNameRuleAccess().getDefinitionFunctionDefinitionQualifiedNameParserRuleCall_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getFunctionNameRuleAccess().getDefinitionFunctionDefinitionQualifiedNameParserRuleCall_0_1()); 

            }

             after(grammarAccess.getFunctionNameRuleAccess().getDefinitionFunctionDefinitionCrossReference_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionNameRule__DefinitionAssignment"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x1002000000000000L,0x0000000000008800L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x1000000000000002L,0x0000000000008800L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0010000000000002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0900000000C081F0L,0x0000000000006000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0040000000000002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x00000000003F0000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x00000000003F0002L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000007000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000007000002L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0B00000000C081F0L,0x0000000000006000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x00007FFFF8000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x00000000000081C0L,0x0000000000004000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x1000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x2001000000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0002000000000030L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000000000L,0x00000000000007FBL});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x8008000000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0200000000000000L,0x00000000000007FBL});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000002L,0x0000000000001000L});

}
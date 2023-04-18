package de.evoal.languages.model.base.dsl.ide.contentassist.antlr.internal;

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
import de.evoal.languages.model.base.dsl.services.BaseLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBaseLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_QUOTED_ID", "RULE_ID", "RULE_DOUBLE", "RULE_INT", "RULE_STRING", "RULE_DIGIT", "RULE_EXPONENT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'false'", "'>='", "'>'", "'='", "'!='", "'<'", "'<='", "'+'", "'-'", "'*'", "'/'", "'%'", "'Y'", "'Z'", "'E'", "'P'", "'T'", "'G'", "'M'", "'k'", "'h'", "'da'", "'d'", "'c'", "'m'", "'\\u00B5'", "'n'", "'p'", "'f'", "'a'", "'z'", "'y'", "'OR'", "'XOR'", "'AND'", "'^'", "'('", "')'", "','", "'value'", "':'", "';'", "'literal'", "'instance'", "'|'", "'string'", "'expression'", "'int'", "'float'", "'boolean'", "'void'", "'data'", "'array'", "'.'", "'!'", "'true'"
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
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
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


        public InternalBaseLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBaseLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBaseLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalBaseLanguage.g"; }


    	private BaseLanguageGrammarAccess grammarAccess;

    	public void setGrammarAccess(BaseLanguageGrammarAccess grammarAccess) {
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



    // $ANTLR start "entryRuleExpressionRule"
    // InternalBaseLanguage.g:54:1: entryRuleExpressionRule : ruleExpressionRule EOF ;
    public final void entryRuleExpressionRule() throws RecognitionException {
        try {
            // InternalBaseLanguage.g:55:1: ( ruleExpressionRule EOF )
            // InternalBaseLanguage.g:56:1: ruleExpressionRule EOF
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
    // InternalBaseLanguage.g:63:1: ruleExpressionRule : ( ruleOrExpressionRule ) ;
    public final void ruleExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:67:2: ( ( ruleOrExpressionRule ) )
            // InternalBaseLanguage.g:68:2: ( ruleOrExpressionRule )
            {
            // InternalBaseLanguage.g:68:2: ( ruleOrExpressionRule )
            // InternalBaseLanguage.g:69:3: ruleOrExpressionRule
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
    // InternalBaseLanguage.g:79:1: entryRuleOrExpressionRule : ruleOrExpressionRule EOF ;
    public final void entryRuleOrExpressionRule() throws RecognitionException {
        try {
            // InternalBaseLanguage.g:80:1: ( ruleOrExpressionRule EOF )
            // InternalBaseLanguage.g:81:1: ruleOrExpressionRule EOF
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
    // InternalBaseLanguage.g:88:1: ruleOrExpressionRule : ( ( rule__OrExpressionRule__Group__0 ) ) ;
    public final void ruleOrExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:92:2: ( ( ( rule__OrExpressionRule__Group__0 ) ) )
            // InternalBaseLanguage.g:93:2: ( ( rule__OrExpressionRule__Group__0 ) )
            {
            // InternalBaseLanguage.g:93:2: ( ( rule__OrExpressionRule__Group__0 ) )
            // InternalBaseLanguage.g:94:3: ( rule__OrExpressionRule__Group__0 )
            {
             before(grammarAccess.getOrExpressionRuleAccess().getGroup()); 
            // InternalBaseLanguage.g:95:3: ( rule__OrExpressionRule__Group__0 )
            // InternalBaseLanguage.g:95:4: rule__OrExpressionRule__Group__0
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
    // InternalBaseLanguage.g:104:1: entryRuleXorExpressionRule : ruleXorExpressionRule EOF ;
    public final void entryRuleXorExpressionRule() throws RecognitionException {
        try {
            // InternalBaseLanguage.g:105:1: ( ruleXorExpressionRule EOF )
            // InternalBaseLanguage.g:106:1: ruleXorExpressionRule EOF
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
    // InternalBaseLanguage.g:113:1: ruleXorExpressionRule : ( ( rule__XorExpressionRule__Group__0 ) ) ;
    public final void ruleXorExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:117:2: ( ( ( rule__XorExpressionRule__Group__0 ) ) )
            // InternalBaseLanguage.g:118:2: ( ( rule__XorExpressionRule__Group__0 ) )
            {
            // InternalBaseLanguage.g:118:2: ( ( rule__XorExpressionRule__Group__0 ) )
            // InternalBaseLanguage.g:119:3: ( rule__XorExpressionRule__Group__0 )
            {
             before(grammarAccess.getXorExpressionRuleAccess().getGroup()); 
            // InternalBaseLanguage.g:120:3: ( rule__XorExpressionRule__Group__0 )
            // InternalBaseLanguage.g:120:4: rule__XorExpressionRule__Group__0
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
    // InternalBaseLanguage.g:129:1: entryRuleAndExpressionRule : ruleAndExpressionRule EOF ;
    public final void entryRuleAndExpressionRule() throws RecognitionException {
        try {
            // InternalBaseLanguage.g:130:1: ( ruleAndExpressionRule EOF )
            // InternalBaseLanguage.g:131:1: ruleAndExpressionRule EOF
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
    // InternalBaseLanguage.g:138:1: ruleAndExpressionRule : ( ( rule__AndExpressionRule__Group__0 ) ) ;
    public final void ruleAndExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:142:2: ( ( ( rule__AndExpressionRule__Group__0 ) ) )
            // InternalBaseLanguage.g:143:2: ( ( rule__AndExpressionRule__Group__0 ) )
            {
            // InternalBaseLanguage.g:143:2: ( ( rule__AndExpressionRule__Group__0 ) )
            // InternalBaseLanguage.g:144:3: ( rule__AndExpressionRule__Group__0 )
            {
             before(grammarAccess.getAndExpressionRuleAccess().getGroup()); 
            // InternalBaseLanguage.g:145:3: ( rule__AndExpressionRule__Group__0 )
            // InternalBaseLanguage.g:145:4: rule__AndExpressionRule__Group__0
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
    // InternalBaseLanguage.g:154:1: entryRuleNotExpressionRule : ruleNotExpressionRule EOF ;
    public final void entryRuleNotExpressionRule() throws RecognitionException {
        try {
            // InternalBaseLanguage.g:155:1: ( ruleNotExpressionRule EOF )
            // InternalBaseLanguage.g:156:1: ruleNotExpressionRule EOF
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
    // InternalBaseLanguage.g:163:1: ruleNotExpressionRule : ( ( rule__NotExpressionRule__Group__0 ) ) ;
    public final void ruleNotExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:167:2: ( ( ( rule__NotExpressionRule__Group__0 ) ) )
            // InternalBaseLanguage.g:168:2: ( ( rule__NotExpressionRule__Group__0 ) )
            {
            // InternalBaseLanguage.g:168:2: ( ( rule__NotExpressionRule__Group__0 ) )
            // InternalBaseLanguage.g:169:3: ( rule__NotExpressionRule__Group__0 )
            {
             before(grammarAccess.getNotExpressionRuleAccess().getGroup()); 
            // InternalBaseLanguage.g:170:3: ( rule__NotExpressionRule__Group__0 )
            // InternalBaseLanguage.g:170:4: rule__NotExpressionRule__Group__0
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
    // InternalBaseLanguage.g:179:1: entryRuleComparisonExpressionRule : ruleComparisonExpressionRule EOF ;
    public final void entryRuleComparisonExpressionRule() throws RecognitionException {
        try {
            // InternalBaseLanguage.g:180:1: ( ruleComparisonExpressionRule EOF )
            // InternalBaseLanguage.g:181:1: ruleComparisonExpressionRule EOF
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
    // InternalBaseLanguage.g:188:1: ruleComparisonExpressionRule : ( ( rule__ComparisonExpressionRule__Group__0 ) ) ;
    public final void ruleComparisonExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:192:2: ( ( ( rule__ComparisonExpressionRule__Group__0 ) ) )
            // InternalBaseLanguage.g:193:2: ( ( rule__ComparisonExpressionRule__Group__0 ) )
            {
            // InternalBaseLanguage.g:193:2: ( ( rule__ComparisonExpressionRule__Group__0 ) )
            // InternalBaseLanguage.g:194:3: ( rule__ComparisonExpressionRule__Group__0 )
            {
             before(grammarAccess.getComparisonExpressionRuleAccess().getGroup()); 
            // InternalBaseLanguage.g:195:3: ( rule__ComparisonExpressionRule__Group__0 )
            // InternalBaseLanguage.g:195:4: rule__ComparisonExpressionRule__Group__0
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
    // InternalBaseLanguage.g:204:1: entryRulePartialComparisonExpressionRule : rulePartialComparisonExpressionRule EOF ;
    public final void entryRulePartialComparisonExpressionRule() throws RecognitionException {
        try {
            // InternalBaseLanguage.g:205:1: ( rulePartialComparisonExpressionRule EOF )
            // InternalBaseLanguage.g:206:1: rulePartialComparisonExpressionRule EOF
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
    // InternalBaseLanguage.g:213:1: rulePartialComparisonExpressionRule : ( ( rule__PartialComparisonExpressionRule__Group__0 ) ) ;
    public final void rulePartialComparisonExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:217:2: ( ( ( rule__PartialComparisonExpressionRule__Group__0 ) ) )
            // InternalBaseLanguage.g:218:2: ( ( rule__PartialComparisonExpressionRule__Group__0 ) )
            {
            // InternalBaseLanguage.g:218:2: ( ( rule__PartialComparisonExpressionRule__Group__0 ) )
            // InternalBaseLanguage.g:219:3: ( rule__PartialComparisonExpressionRule__Group__0 )
            {
             before(grammarAccess.getPartialComparisonExpressionRuleAccess().getGroup()); 
            // InternalBaseLanguage.g:220:3: ( rule__PartialComparisonExpressionRule__Group__0 )
            // InternalBaseLanguage.g:220:4: rule__PartialComparisonExpressionRule__Group__0
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
    // InternalBaseLanguage.g:229:1: entryRuleAddOrSubtractExpressionRule : ruleAddOrSubtractExpressionRule EOF ;
    public final void entryRuleAddOrSubtractExpressionRule() throws RecognitionException {
        try {
            // InternalBaseLanguage.g:230:1: ( ruleAddOrSubtractExpressionRule EOF )
            // InternalBaseLanguage.g:231:1: ruleAddOrSubtractExpressionRule EOF
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
    // InternalBaseLanguage.g:238:1: ruleAddOrSubtractExpressionRule : ( ( rule__AddOrSubtractExpressionRule__Group__0 ) ) ;
    public final void ruleAddOrSubtractExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:242:2: ( ( ( rule__AddOrSubtractExpressionRule__Group__0 ) ) )
            // InternalBaseLanguage.g:243:2: ( ( rule__AddOrSubtractExpressionRule__Group__0 ) )
            {
            // InternalBaseLanguage.g:243:2: ( ( rule__AddOrSubtractExpressionRule__Group__0 ) )
            // InternalBaseLanguage.g:244:3: ( rule__AddOrSubtractExpressionRule__Group__0 )
            {
             before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getGroup()); 
            // InternalBaseLanguage.g:245:3: ( rule__AddOrSubtractExpressionRule__Group__0 )
            // InternalBaseLanguage.g:245:4: rule__AddOrSubtractExpressionRule__Group__0
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
    // InternalBaseLanguage.g:254:1: entryRuleMultiplyDivideModuloExpressionRule : ruleMultiplyDivideModuloExpressionRule EOF ;
    public final void entryRuleMultiplyDivideModuloExpressionRule() throws RecognitionException {
        try {
            // InternalBaseLanguage.g:255:1: ( ruleMultiplyDivideModuloExpressionRule EOF )
            // InternalBaseLanguage.g:256:1: ruleMultiplyDivideModuloExpressionRule EOF
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
    // InternalBaseLanguage.g:263:1: ruleMultiplyDivideModuloExpressionRule : ( ( rule__MultiplyDivideModuloExpressionRule__Group__0 ) ) ;
    public final void ruleMultiplyDivideModuloExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:267:2: ( ( ( rule__MultiplyDivideModuloExpressionRule__Group__0 ) ) )
            // InternalBaseLanguage.g:268:2: ( ( rule__MultiplyDivideModuloExpressionRule__Group__0 ) )
            {
            // InternalBaseLanguage.g:268:2: ( ( rule__MultiplyDivideModuloExpressionRule__Group__0 ) )
            // InternalBaseLanguage.g:269:3: ( rule__MultiplyDivideModuloExpressionRule__Group__0 )
            {
             before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getGroup()); 
            // InternalBaseLanguage.g:270:3: ( rule__MultiplyDivideModuloExpressionRule__Group__0 )
            // InternalBaseLanguage.g:270:4: rule__MultiplyDivideModuloExpressionRule__Group__0
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
    // InternalBaseLanguage.g:279:1: entryRulePowerOfExpressionRule : rulePowerOfExpressionRule EOF ;
    public final void entryRulePowerOfExpressionRule() throws RecognitionException {
        try {
            // InternalBaseLanguage.g:280:1: ( rulePowerOfExpressionRule EOF )
            // InternalBaseLanguage.g:281:1: rulePowerOfExpressionRule EOF
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
    // InternalBaseLanguage.g:288:1: rulePowerOfExpressionRule : ( ( rule__PowerOfExpressionRule__Group__0 ) ) ;
    public final void rulePowerOfExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:292:2: ( ( ( rule__PowerOfExpressionRule__Group__0 ) ) )
            // InternalBaseLanguage.g:293:2: ( ( rule__PowerOfExpressionRule__Group__0 ) )
            {
            // InternalBaseLanguage.g:293:2: ( ( rule__PowerOfExpressionRule__Group__0 ) )
            // InternalBaseLanguage.g:294:3: ( rule__PowerOfExpressionRule__Group__0 )
            {
             before(grammarAccess.getPowerOfExpressionRuleAccess().getGroup()); 
            // InternalBaseLanguage.g:295:3: ( rule__PowerOfExpressionRule__Group__0 )
            // InternalBaseLanguage.g:295:4: rule__PowerOfExpressionRule__Group__0
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
    // InternalBaseLanguage.g:304:1: entryRuleUnaryAddOrSubtractExpressionRule : ruleUnaryAddOrSubtractExpressionRule EOF ;
    public final void entryRuleUnaryAddOrSubtractExpressionRule() throws RecognitionException {
        try {
            // InternalBaseLanguage.g:305:1: ( ruleUnaryAddOrSubtractExpressionRule EOF )
            // InternalBaseLanguage.g:306:1: ruleUnaryAddOrSubtractExpressionRule EOF
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
    // InternalBaseLanguage.g:313:1: ruleUnaryAddOrSubtractExpressionRule : ( ( rule__UnaryAddOrSubtractExpressionRule__Group__0 ) ) ;
    public final void ruleUnaryAddOrSubtractExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:317:2: ( ( ( rule__UnaryAddOrSubtractExpressionRule__Group__0 ) ) )
            // InternalBaseLanguage.g:318:2: ( ( rule__UnaryAddOrSubtractExpressionRule__Group__0 ) )
            {
            // InternalBaseLanguage.g:318:2: ( ( rule__UnaryAddOrSubtractExpressionRule__Group__0 ) )
            // InternalBaseLanguage.g:319:3: ( rule__UnaryAddOrSubtractExpressionRule__Group__0 )
            {
             before(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getGroup()); 
            // InternalBaseLanguage.g:320:3: ( rule__UnaryAddOrSubtractExpressionRule__Group__0 )
            // InternalBaseLanguage.g:320:4: rule__UnaryAddOrSubtractExpressionRule__Group__0
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
    // InternalBaseLanguage.g:329:1: entryRuleLiteralOrReferenceRule : ruleLiteralOrReferenceRule EOF ;
    public final void entryRuleLiteralOrReferenceRule() throws RecognitionException {
        try {
            // InternalBaseLanguage.g:330:1: ( ruleLiteralOrReferenceRule EOF )
            // InternalBaseLanguage.g:331:1: ruleLiteralOrReferenceRule EOF
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
    // InternalBaseLanguage.g:338:1: ruleLiteralOrReferenceRule : ( ( rule__LiteralOrReferenceRule__Alternatives ) ) ;
    public final void ruleLiteralOrReferenceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:342:2: ( ( ( rule__LiteralOrReferenceRule__Alternatives ) ) )
            // InternalBaseLanguage.g:343:2: ( ( rule__LiteralOrReferenceRule__Alternatives ) )
            {
            // InternalBaseLanguage.g:343:2: ( ( rule__LiteralOrReferenceRule__Alternatives ) )
            // InternalBaseLanguage.g:344:3: ( rule__LiteralOrReferenceRule__Alternatives )
            {
             before(grammarAccess.getLiteralOrReferenceRuleAccess().getAlternatives()); 
            // InternalBaseLanguage.g:345:3: ( rule__LiteralOrReferenceRule__Alternatives )
            // InternalBaseLanguage.g:345:4: rule__LiteralOrReferenceRule__Alternatives
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
    // InternalBaseLanguage.g:354:1: entryRuleParanthesesRule : ruleParanthesesRule EOF ;
    public final void entryRuleParanthesesRule() throws RecognitionException {
        try {
            // InternalBaseLanguage.g:355:1: ( ruleParanthesesRule EOF )
            // InternalBaseLanguage.g:356:1: ruleParanthesesRule EOF
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
    // InternalBaseLanguage.g:363:1: ruleParanthesesRule : ( ( rule__ParanthesesRule__Group__0 ) ) ;
    public final void ruleParanthesesRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:367:2: ( ( ( rule__ParanthesesRule__Group__0 ) ) )
            // InternalBaseLanguage.g:368:2: ( ( rule__ParanthesesRule__Group__0 ) )
            {
            // InternalBaseLanguage.g:368:2: ( ( rule__ParanthesesRule__Group__0 ) )
            // InternalBaseLanguage.g:369:3: ( rule__ParanthesesRule__Group__0 )
            {
             before(grammarAccess.getParanthesesRuleAccess().getGroup()); 
            // InternalBaseLanguage.g:370:3: ( rule__ParanthesesRule__Group__0 )
            // InternalBaseLanguage.g:370:4: rule__ParanthesesRule__Group__0
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
    // InternalBaseLanguage.g:379:1: entryRuleCallRule : ruleCallRule EOF ;
    public final void entryRuleCallRule() throws RecognitionException {
        try {
            // InternalBaseLanguage.g:380:1: ( ruleCallRule EOF )
            // InternalBaseLanguage.g:381:1: ruleCallRule EOF
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
    // InternalBaseLanguage.g:388:1: ruleCallRule : ( ( rule__CallRule__Group__0 ) ) ;
    public final void ruleCallRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:392:2: ( ( ( rule__CallRule__Group__0 ) ) )
            // InternalBaseLanguage.g:393:2: ( ( rule__CallRule__Group__0 ) )
            {
            // InternalBaseLanguage.g:393:2: ( ( rule__CallRule__Group__0 ) )
            // InternalBaseLanguage.g:394:3: ( rule__CallRule__Group__0 )
            {
             before(grammarAccess.getCallRuleAccess().getGroup()); 
            // InternalBaseLanguage.g:395:3: ( rule__CallRule__Group__0 )
            // InternalBaseLanguage.g:395:4: rule__CallRule__Group__0
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
    // InternalBaseLanguage.g:404:1: entryRuleValueReferenceRule : ruleValueReferenceRule EOF ;
    public final void entryRuleValueReferenceRule() throws RecognitionException {
        try {
            // InternalBaseLanguage.g:405:1: ( ruleValueReferenceRule EOF )
            // InternalBaseLanguage.g:406:1: ruleValueReferenceRule EOF
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
    // InternalBaseLanguage.g:413:1: ruleValueReferenceRule : ( ( rule__ValueReferenceRule__Group__0 ) ) ;
    public final void ruleValueReferenceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:417:2: ( ( ( rule__ValueReferenceRule__Group__0 ) ) )
            // InternalBaseLanguage.g:418:2: ( ( rule__ValueReferenceRule__Group__0 ) )
            {
            // InternalBaseLanguage.g:418:2: ( ( rule__ValueReferenceRule__Group__0 ) )
            // InternalBaseLanguage.g:419:3: ( rule__ValueReferenceRule__Group__0 )
            {
             before(grammarAccess.getValueReferenceRuleAccess().getGroup()); 
            // InternalBaseLanguage.g:420:3: ( rule__ValueReferenceRule__Group__0 )
            // InternalBaseLanguage.g:420:4: rule__ValueReferenceRule__Group__0
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
    // InternalBaseLanguage.g:429:1: entryRuleLiteralRule : ruleLiteralRule EOF ;
    public final void entryRuleLiteralRule() throws RecognitionException {
        try {
            // InternalBaseLanguage.g:430:1: ( ruleLiteralRule EOF )
            // InternalBaseLanguage.g:431:1: ruleLiteralRule EOF
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
    // InternalBaseLanguage.g:438:1: ruleLiteralRule : ( ( rule__LiteralRule__Alternatives ) ) ;
    public final void ruleLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:442:2: ( ( ( rule__LiteralRule__Alternatives ) ) )
            // InternalBaseLanguage.g:443:2: ( ( rule__LiteralRule__Alternatives ) )
            {
            // InternalBaseLanguage.g:443:2: ( ( rule__LiteralRule__Alternatives ) )
            // InternalBaseLanguage.g:444:3: ( rule__LiteralRule__Alternatives )
            {
             before(grammarAccess.getLiteralRuleAccess().getAlternatives()); 
            // InternalBaseLanguage.g:445:3: ( rule__LiteralRule__Alternatives )
            // InternalBaseLanguage.g:445:4: rule__LiteralRule__Alternatives
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
    // InternalBaseLanguage.g:454:1: entryRuleNumberLiteralRule : ruleNumberLiteralRule EOF ;
    public final void entryRuleNumberLiteralRule() throws RecognitionException {
        try {
            // InternalBaseLanguage.g:455:1: ( ruleNumberLiteralRule EOF )
            // InternalBaseLanguage.g:456:1: ruleNumberLiteralRule EOF
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
    // InternalBaseLanguage.g:463:1: ruleNumberLiteralRule : ( ( rule__NumberLiteralRule__Alternatives ) ) ;
    public final void ruleNumberLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:467:2: ( ( ( rule__NumberLiteralRule__Alternatives ) ) )
            // InternalBaseLanguage.g:468:2: ( ( rule__NumberLiteralRule__Alternatives ) )
            {
            // InternalBaseLanguage.g:468:2: ( ( rule__NumberLiteralRule__Alternatives ) )
            // InternalBaseLanguage.g:469:3: ( rule__NumberLiteralRule__Alternatives )
            {
             before(grammarAccess.getNumberLiteralRuleAccess().getAlternatives()); 
            // InternalBaseLanguage.g:470:3: ( rule__NumberLiteralRule__Alternatives )
            // InternalBaseLanguage.g:470:4: rule__NumberLiteralRule__Alternatives
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
    // InternalBaseLanguage.g:479:1: entryRuleDoubleLiteralRule : ruleDoubleLiteralRule EOF ;
    public final void entryRuleDoubleLiteralRule() throws RecognitionException {
        try {
            // InternalBaseLanguage.g:480:1: ( ruleDoubleLiteralRule EOF )
            // InternalBaseLanguage.g:481:1: ruleDoubleLiteralRule EOF
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
    // InternalBaseLanguage.g:488:1: ruleDoubleLiteralRule : ( ( rule__DoubleLiteralRule__Group__0 ) ) ;
    public final void ruleDoubleLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:492:2: ( ( ( rule__DoubleLiteralRule__Group__0 ) ) )
            // InternalBaseLanguage.g:493:2: ( ( rule__DoubleLiteralRule__Group__0 ) )
            {
            // InternalBaseLanguage.g:493:2: ( ( rule__DoubleLiteralRule__Group__0 ) )
            // InternalBaseLanguage.g:494:3: ( rule__DoubleLiteralRule__Group__0 )
            {
             before(grammarAccess.getDoubleLiteralRuleAccess().getGroup()); 
            // InternalBaseLanguage.g:495:3: ( rule__DoubleLiteralRule__Group__0 )
            // InternalBaseLanguage.g:495:4: rule__DoubleLiteralRule__Group__0
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
    // InternalBaseLanguage.g:504:1: entryRuleIntegerLiteralRule : ruleIntegerLiteralRule EOF ;
    public final void entryRuleIntegerLiteralRule() throws RecognitionException {
        try {
            // InternalBaseLanguage.g:505:1: ( ruleIntegerLiteralRule EOF )
            // InternalBaseLanguage.g:506:1: ruleIntegerLiteralRule EOF
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
    // InternalBaseLanguage.g:513:1: ruleIntegerLiteralRule : ( ( rule__IntegerLiteralRule__Group__0 ) ) ;
    public final void ruleIntegerLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:517:2: ( ( ( rule__IntegerLiteralRule__Group__0 ) ) )
            // InternalBaseLanguage.g:518:2: ( ( rule__IntegerLiteralRule__Group__0 ) )
            {
            // InternalBaseLanguage.g:518:2: ( ( rule__IntegerLiteralRule__Group__0 ) )
            // InternalBaseLanguage.g:519:3: ( rule__IntegerLiteralRule__Group__0 )
            {
             before(grammarAccess.getIntegerLiteralRuleAccess().getGroup()); 
            // InternalBaseLanguage.g:520:3: ( rule__IntegerLiteralRule__Group__0 )
            // InternalBaseLanguage.g:520:4: rule__IntegerLiteralRule__Group__0
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
    // InternalBaseLanguage.g:529:1: entryRuleStringLiteralRule : ruleStringLiteralRule EOF ;
    public final void entryRuleStringLiteralRule() throws RecognitionException {
        try {
            // InternalBaseLanguage.g:530:1: ( ruleStringLiteralRule EOF )
            // InternalBaseLanguage.g:531:1: ruleStringLiteralRule EOF
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
    // InternalBaseLanguage.g:538:1: ruleStringLiteralRule : ( ( rule__StringLiteralRule__ValueAssignment ) ) ;
    public final void ruleStringLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:542:2: ( ( ( rule__StringLiteralRule__ValueAssignment ) ) )
            // InternalBaseLanguage.g:543:2: ( ( rule__StringLiteralRule__ValueAssignment ) )
            {
            // InternalBaseLanguage.g:543:2: ( ( rule__StringLiteralRule__ValueAssignment ) )
            // InternalBaseLanguage.g:544:3: ( rule__StringLiteralRule__ValueAssignment )
            {
             before(grammarAccess.getStringLiteralRuleAccess().getValueAssignment()); 
            // InternalBaseLanguage.g:545:3: ( rule__StringLiteralRule__ValueAssignment )
            // InternalBaseLanguage.g:545:4: rule__StringLiteralRule__ValueAssignment
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
    // InternalBaseLanguage.g:554:1: entryRuleBooleanLiteralRule : ruleBooleanLiteralRule EOF ;
    public final void entryRuleBooleanLiteralRule() throws RecognitionException {
        try {
            // InternalBaseLanguage.g:555:1: ( ruleBooleanLiteralRule EOF )
            // InternalBaseLanguage.g:556:1: ruleBooleanLiteralRule EOF
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
    // InternalBaseLanguage.g:563:1: ruleBooleanLiteralRule : ( ( rule__BooleanLiteralRule__Group__0 ) ) ;
    public final void ruleBooleanLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:567:2: ( ( ( rule__BooleanLiteralRule__Group__0 ) ) )
            // InternalBaseLanguage.g:568:2: ( ( rule__BooleanLiteralRule__Group__0 ) )
            {
            // InternalBaseLanguage.g:568:2: ( ( rule__BooleanLiteralRule__Group__0 ) )
            // InternalBaseLanguage.g:569:3: ( rule__BooleanLiteralRule__Group__0 )
            {
             before(grammarAccess.getBooleanLiteralRuleAccess().getGroup()); 
            // InternalBaseLanguage.g:570:3: ( rule__BooleanLiteralRule__Group__0 )
            // InternalBaseLanguage.g:570:4: rule__BooleanLiteralRule__Group__0
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


    // $ANTLR start "entryRuleAttributeDefinitionRule"
    // InternalBaseLanguage.g:579:1: entryRuleAttributeDefinitionRule : ruleAttributeDefinitionRule EOF ;
    public final void entryRuleAttributeDefinitionRule() throws RecognitionException {
        try {
            // InternalBaseLanguage.g:580:1: ( ruleAttributeDefinitionRule EOF )
            // InternalBaseLanguage.g:581:1: ruleAttributeDefinitionRule EOF
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
    // InternalBaseLanguage.g:588:1: ruleAttributeDefinitionRule : ( ( rule__AttributeDefinitionRule__Group__0 ) ) ;
    public final void ruleAttributeDefinitionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:592:2: ( ( ( rule__AttributeDefinitionRule__Group__0 ) ) )
            // InternalBaseLanguage.g:593:2: ( ( rule__AttributeDefinitionRule__Group__0 ) )
            {
            // InternalBaseLanguage.g:593:2: ( ( rule__AttributeDefinitionRule__Group__0 ) )
            // InternalBaseLanguage.g:594:3: ( rule__AttributeDefinitionRule__Group__0 )
            {
             before(grammarAccess.getAttributeDefinitionRuleAccess().getGroup()); 
            // InternalBaseLanguage.g:595:3: ( rule__AttributeDefinitionRule__Group__0 )
            // InternalBaseLanguage.g:595:4: rule__AttributeDefinitionRule__Group__0
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
    // InternalBaseLanguage.g:604:1: entryRuleTypeRule : ruleTypeRule EOF ;
    public final void entryRuleTypeRule() throws RecognitionException {
        try {
            // InternalBaseLanguage.g:605:1: ( ruleTypeRule EOF )
            // InternalBaseLanguage.g:606:1: ruleTypeRule EOF
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
    // InternalBaseLanguage.g:613:1: ruleTypeRule : ( ( rule__TypeRule__Alternatives ) ) ;
    public final void ruleTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:617:2: ( ( ( rule__TypeRule__Alternatives ) ) )
            // InternalBaseLanguage.g:618:2: ( ( rule__TypeRule__Alternatives ) )
            {
            // InternalBaseLanguage.g:618:2: ( ( rule__TypeRule__Alternatives ) )
            // InternalBaseLanguage.g:619:3: ( rule__TypeRule__Alternatives )
            {
             before(grammarAccess.getTypeRuleAccess().getAlternatives()); 
            // InternalBaseLanguage.g:620:3: ( rule__TypeRule__Alternatives )
            // InternalBaseLanguage.g:620:4: rule__TypeRule__Alternatives
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
    // InternalBaseLanguage.g:629:1: entryRuleLiteralTypeRule : ruleLiteralTypeRule EOF ;
    public final void entryRuleLiteralTypeRule() throws RecognitionException {
        try {
            // InternalBaseLanguage.g:630:1: ( ruleLiteralTypeRule EOF )
            // InternalBaseLanguage.g:631:1: ruleLiteralTypeRule EOF
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
    // InternalBaseLanguage.g:638:1: ruleLiteralTypeRule : ( ( rule__LiteralTypeRule__Group__0 ) ) ;
    public final void ruleLiteralTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:642:2: ( ( ( rule__LiteralTypeRule__Group__0 ) ) )
            // InternalBaseLanguage.g:643:2: ( ( rule__LiteralTypeRule__Group__0 ) )
            {
            // InternalBaseLanguage.g:643:2: ( ( rule__LiteralTypeRule__Group__0 ) )
            // InternalBaseLanguage.g:644:3: ( rule__LiteralTypeRule__Group__0 )
            {
             before(grammarAccess.getLiteralTypeRuleAccess().getGroup()); 
            // InternalBaseLanguage.g:645:3: ( rule__LiteralTypeRule__Group__0 )
            // InternalBaseLanguage.g:645:4: rule__LiteralTypeRule__Group__0
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
    // InternalBaseLanguage.g:654:1: entryRuleInstanceTypeRule : ruleInstanceTypeRule EOF ;
    public final void entryRuleInstanceTypeRule() throws RecognitionException {
        try {
            // InternalBaseLanguage.g:655:1: ( ruleInstanceTypeRule EOF )
            // InternalBaseLanguage.g:656:1: ruleInstanceTypeRule EOF
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
    // InternalBaseLanguage.g:663:1: ruleInstanceTypeRule : ( ( rule__InstanceTypeRule__Group__0 ) ) ;
    public final void ruleInstanceTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:667:2: ( ( ( rule__InstanceTypeRule__Group__0 ) ) )
            // InternalBaseLanguage.g:668:2: ( ( rule__InstanceTypeRule__Group__0 ) )
            {
            // InternalBaseLanguage.g:668:2: ( ( rule__InstanceTypeRule__Group__0 ) )
            // InternalBaseLanguage.g:669:3: ( rule__InstanceTypeRule__Group__0 )
            {
             before(grammarAccess.getInstanceTypeRuleAccess().getGroup()); 
            // InternalBaseLanguage.g:670:3: ( rule__InstanceTypeRule__Group__0 )
            // InternalBaseLanguage.g:670:4: rule__InstanceTypeRule__Group__0
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
    // InternalBaseLanguage.g:679:1: entryRuleStringTypeRule : ruleStringTypeRule EOF ;
    public final void entryRuleStringTypeRule() throws RecognitionException {
        try {
            // InternalBaseLanguage.g:680:1: ( ruleStringTypeRule EOF )
            // InternalBaseLanguage.g:681:1: ruleStringTypeRule EOF
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
    // InternalBaseLanguage.g:688:1: ruleStringTypeRule : ( ( rule__StringTypeRule__Group__0 ) ) ;
    public final void ruleStringTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:692:2: ( ( ( rule__StringTypeRule__Group__0 ) ) )
            // InternalBaseLanguage.g:693:2: ( ( rule__StringTypeRule__Group__0 ) )
            {
            // InternalBaseLanguage.g:693:2: ( ( rule__StringTypeRule__Group__0 ) )
            // InternalBaseLanguage.g:694:3: ( rule__StringTypeRule__Group__0 )
            {
             before(grammarAccess.getStringTypeRuleAccess().getGroup()); 
            // InternalBaseLanguage.g:695:3: ( rule__StringTypeRule__Group__0 )
            // InternalBaseLanguage.g:695:4: rule__StringTypeRule__Group__0
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
    // InternalBaseLanguage.g:704:1: entryRuleExpressionTypeRule : ruleExpressionTypeRule EOF ;
    public final void entryRuleExpressionTypeRule() throws RecognitionException {
        try {
            // InternalBaseLanguage.g:705:1: ( ruleExpressionTypeRule EOF )
            // InternalBaseLanguage.g:706:1: ruleExpressionTypeRule EOF
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
    // InternalBaseLanguage.g:713:1: ruleExpressionTypeRule : ( ( rule__ExpressionTypeRule__Group__0 ) ) ;
    public final void ruleExpressionTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:717:2: ( ( ( rule__ExpressionTypeRule__Group__0 ) ) )
            // InternalBaseLanguage.g:718:2: ( ( rule__ExpressionTypeRule__Group__0 ) )
            {
            // InternalBaseLanguage.g:718:2: ( ( rule__ExpressionTypeRule__Group__0 ) )
            // InternalBaseLanguage.g:719:3: ( rule__ExpressionTypeRule__Group__0 )
            {
             before(grammarAccess.getExpressionTypeRuleAccess().getGroup()); 
            // InternalBaseLanguage.g:720:3: ( rule__ExpressionTypeRule__Group__0 )
            // InternalBaseLanguage.g:720:4: rule__ExpressionTypeRule__Group__0
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
    // InternalBaseLanguage.g:729:1: entryRuleIntTypeRule : ruleIntTypeRule EOF ;
    public final void entryRuleIntTypeRule() throws RecognitionException {
        try {
            // InternalBaseLanguage.g:730:1: ( ruleIntTypeRule EOF )
            // InternalBaseLanguage.g:731:1: ruleIntTypeRule EOF
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
    // InternalBaseLanguage.g:738:1: ruleIntTypeRule : ( ( rule__IntTypeRule__Group__0 ) ) ;
    public final void ruleIntTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:742:2: ( ( ( rule__IntTypeRule__Group__0 ) ) )
            // InternalBaseLanguage.g:743:2: ( ( rule__IntTypeRule__Group__0 ) )
            {
            // InternalBaseLanguage.g:743:2: ( ( rule__IntTypeRule__Group__0 ) )
            // InternalBaseLanguage.g:744:3: ( rule__IntTypeRule__Group__0 )
            {
             before(grammarAccess.getIntTypeRuleAccess().getGroup()); 
            // InternalBaseLanguage.g:745:3: ( rule__IntTypeRule__Group__0 )
            // InternalBaseLanguage.g:745:4: rule__IntTypeRule__Group__0
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
    // InternalBaseLanguage.g:754:1: entryRuleFloatTypeRule : ruleFloatTypeRule EOF ;
    public final void entryRuleFloatTypeRule() throws RecognitionException {
        try {
            // InternalBaseLanguage.g:755:1: ( ruleFloatTypeRule EOF )
            // InternalBaseLanguage.g:756:1: ruleFloatTypeRule EOF
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
    // InternalBaseLanguage.g:763:1: ruleFloatTypeRule : ( ( rule__FloatTypeRule__Group__0 ) ) ;
    public final void ruleFloatTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:767:2: ( ( ( rule__FloatTypeRule__Group__0 ) ) )
            // InternalBaseLanguage.g:768:2: ( ( rule__FloatTypeRule__Group__0 ) )
            {
            // InternalBaseLanguage.g:768:2: ( ( rule__FloatTypeRule__Group__0 ) )
            // InternalBaseLanguage.g:769:3: ( rule__FloatTypeRule__Group__0 )
            {
             before(grammarAccess.getFloatTypeRuleAccess().getGroup()); 
            // InternalBaseLanguage.g:770:3: ( rule__FloatTypeRule__Group__0 )
            // InternalBaseLanguage.g:770:4: rule__FloatTypeRule__Group__0
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
    // InternalBaseLanguage.g:779:1: entryRuleBooleanTypeRule : ruleBooleanTypeRule EOF ;
    public final void entryRuleBooleanTypeRule() throws RecognitionException {
        try {
            // InternalBaseLanguage.g:780:1: ( ruleBooleanTypeRule EOF )
            // InternalBaseLanguage.g:781:1: ruleBooleanTypeRule EOF
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
    // InternalBaseLanguage.g:788:1: ruleBooleanTypeRule : ( ( rule__BooleanTypeRule__Group__0 ) ) ;
    public final void ruleBooleanTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:792:2: ( ( ( rule__BooleanTypeRule__Group__0 ) ) )
            // InternalBaseLanguage.g:793:2: ( ( rule__BooleanTypeRule__Group__0 ) )
            {
            // InternalBaseLanguage.g:793:2: ( ( rule__BooleanTypeRule__Group__0 ) )
            // InternalBaseLanguage.g:794:3: ( rule__BooleanTypeRule__Group__0 )
            {
             before(grammarAccess.getBooleanTypeRuleAccess().getGroup()); 
            // InternalBaseLanguage.g:795:3: ( rule__BooleanTypeRule__Group__0 )
            // InternalBaseLanguage.g:795:4: rule__BooleanTypeRule__Group__0
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
    // InternalBaseLanguage.g:804:1: entryRuleVoidTypeRule : ruleVoidTypeRule EOF ;
    public final void entryRuleVoidTypeRule() throws RecognitionException {
        try {
            // InternalBaseLanguage.g:805:1: ( ruleVoidTypeRule EOF )
            // InternalBaseLanguage.g:806:1: ruleVoidTypeRule EOF
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
    // InternalBaseLanguage.g:813:1: ruleVoidTypeRule : ( ( rule__VoidTypeRule__Group__0 ) ) ;
    public final void ruleVoidTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:817:2: ( ( ( rule__VoidTypeRule__Group__0 ) ) )
            // InternalBaseLanguage.g:818:2: ( ( rule__VoidTypeRule__Group__0 ) )
            {
            // InternalBaseLanguage.g:818:2: ( ( rule__VoidTypeRule__Group__0 ) )
            // InternalBaseLanguage.g:819:3: ( rule__VoidTypeRule__Group__0 )
            {
             before(grammarAccess.getVoidTypeRuleAccess().getGroup()); 
            // InternalBaseLanguage.g:820:3: ( rule__VoidTypeRule__Group__0 )
            // InternalBaseLanguage.g:820:4: rule__VoidTypeRule__Group__0
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
    // InternalBaseLanguage.g:829:1: entryRuleDataTypeRule : ruleDataTypeRule EOF ;
    public final void entryRuleDataTypeRule() throws RecognitionException {
        try {
            // InternalBaseLanguage.g:830:1: ( ruleDataTypeRule EOF )
            // InternalBaseLanguage.g:831:1: ruleDataTypeRule EOF
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
    // InternalBaseLanguage.g:838:1: ruleDataTypeRule : ( ( rule__DataTypeRule__Group__0 ) ) ;
    public final void ruleDataTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:842:2: ( ( ( rule__DataTypeRule__Group__0 ) ) )
            // InternalBaseLanguage.g:843:2: ( ( rule__DataTypeRule__Group__0 ) )
            {
            // InternalBaseLanguage.g:843:2: ( ( rule__DataTypeRule__Group__0 ) )
            // InternalBaseLanguage.g:844:3: ( rule__DataTypeRule__Group__0 )
            {
             before(grammarAccess.getDataTypeRuleAccess().getGroup()); 
            // InternalBaseLanguage.g:845:3: ( rule__DataTypeRule__Group__0 )
            // InternalBaseLanguage.g:845:4: rule__DataTypeRule__Group__0
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
    // InternalBaseLanguage.g:854:1: entryRuleArrayTypeRule : ruleArrayTypeRule EOF ;
    public final void entryRuleArrayTypeRule() throws RecognitionException {
        try {
            // InternalBaseLanguage.g:855:1: ( ruleArrayTypeRule EOF )
            // InternalBaseLanguage.g:856:1: ruleArrayTypeRule EOF
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
    // InternalBaseLanguage.g:863:1: ruleArrayTypeRule : ( ( rule__ArrayTypeRule__Group__0 ) ) ;
    public final void ruleArrayTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:867:2: ( ( ( rule__ArrayTypeRule__Group__0 ) ) )
            // InternalBaseLanguage.g:868:2: ( ( rule__ArrayTypeRule__Group__0 ) )
            {
            // InternalBaseLanguage.g:868:2: ( ( rule__ArrayTypeRule__Group__0 ) )
            // InternalBaseLanguage.g:869:3: ( rule__ArrayTypeRule__Group__0 )
            {
             before(grammarAccess.getArrayTypeRuleAccess().getGroup()); 
            // InternalBaseLanguage.g:870:3: ( rule__ArrayTypeRule__Group__0 )
            // InternalBaseLanguage.g:870:4: rule__ArrayTypeRule__Group__0
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


    // $ANTLR start "entryRuleParameterRule"
    // InternalBaseLanguage.g:879:1: entryRuleParameterRule : ruleParameterRule EOF ;
    public final void entryRuleParameterRule() throws RecognitionException {
        try {
            // InternalBaseLanguage.g:880:1: ( ruleParameterRule EOF )
            // InternalBaseLanguage.g:881:1: ruleParameterRule EOF
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
    // InternalBaseLanguage.g:888:1: ruleParameterRule : ( ( rule__ParameterRule__Group__0 ) ) ;
    public final void ruleParameterRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:892:2: ( ( ( rule__ParameterRule__Group__0 ) ) )
            // InternalBaseLanguage.g:893:2: ( ( rule__ParameterRule__Group__0 ) )
            {
            // InternalBaseLanguage.g:893:2: ( ( rule__ParameterRule__Group__0 ) )
            // InternalBaseLanguage.g:894:3: ( rule__ParameterRule__Group__0 )
            {
             before(grammarAccess.getParameterRuleAccess().getGroup()); 
            // InternalBaseLanguage.g:895:3: ( rule__ParameterRule__Group__0 )
            // InternalBaseLanguage.g:895:4: rule__ParameterRule__Group__0
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
    // InternalBaseLanguage.g:904:1: entryRuleFunctionNameRule : ruleFunctionNameRule EOF ;
    public final void entryRuleFunctionNameRule() throws RecognitionException {
        try {
            // InternalBaseLanguage.g:905:1: ( ruleFunctionNameRule EOF )
            // InternalBaseLanguage.g:906:1: ruleFunctionNameRule EOF
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
    // InternalBaseLanguage.g:913:1: ruleFunctionNameRule : ( ( rule__FunctionNameRule__DefinitionAssignment ) ) ;
    public final void ruleFunctionNameRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:917:2: ( ( ( rule__FunctionNameRule__DefinitionAssignment ) ) )
            // InternalBaseLanguage.g:918:2: ( ( rule__FunctionNameRule__DefinitionAssignment ) )
            {
            // InternalBaseLanguage.g:918:2: ( ( rule__FunctionNameRule__DefinitionAssignment ) )
            // InternalBaseLanguage.g:919:3: ( rule__FunctionNameRule__DefinitionAssignment )
            {
             before(grammarAccess.getFunctionNameRuleAccess().getDefinitionAssignment()); 
            // InternalBaseLanguage.g:920:3: ( rule__FunctionNameRule__DefinitionAssignment )
            // InternalBaseLanguage.g:920:4: rule__FunctionNameRule__DefinitionAssignment
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
    // InternalBaseLanguage.g:929:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // InternalBaseLanguage.g:930:1: ( ruleQualifiedName EOF )
            // InternalBaseLanguage.g:931:1: ruleQualifiedName EOF
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
    // InternalBaseLanguage.g:938:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:942:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // InternalBaseLanguage.g:943:2: ( ( rule__QualifiedName__Group__0 ) )
            {
            // InternalBaseLanguage.g:943:2: ( ( rule__QualifiedName__Group__0 ) )
            // InternalBaseLanguage.g:944:3: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // InternalBaseLanguage.g:945:3: ( rule__QualifiedName__Group__0 )
            // InternalBaseLanguage.g:945:4: rule__QualifiedName__Group__0
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
    // InternalBaseLanguage.g:954:1: entryRuleStringOrId : ruleStringOrId EOF ;
    public final void entryRuleStringOrId() throws RecognitionException {
        try {
            // InternalBaseLanguage.g:955:1: ( ruleStringOrId EOF )
            // InternalBaseLanguage.g:956:1: ruleStringOrId EOF
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
    // InternalBaseLanguage.g:963:1: ruleStringOrId : ( ( rule__StringOrId__Alternatives ) ) ;
    public final void ruleStringOrId() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:967:2: ( ( ( rule__StringOrId__Alternatives ) ) )
            // InternalBaseLanguage.g:968:2: ( ( rule__StringOrId__Alternatives ) )
            {
            // InternalBaseLanguage.g:968:2: ( ( rule__StringOrId__Alternatives ) )
            // InternalBaseLanguage.g:969:3: ( rule__StringOrId__Alternatives )
            {
             before(grammarAccess.getStringOrIdAccess().getAlternatives()); 
            // InternalBaseLanguage.g:970:3: ( rule__StringOrId__Alternatives )
            // InternalBaseLanguage.g:970:4: rule__StringOrId__Alternatives
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
    // InternalBaseLanguage.g:979:1: ruleComparisonOperatorRule : ( ( rule__ComparisonOperatorRule__Alternatives ) ) ;
    public final void ruleComparisonOperatorRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:983:1: ( ( ( rule__ComparisonOperatorRule__Alternatives ) ) )
            // InternalBaseLanguage.g:984:2: ( ( rule__ComparisonOperatorRule__Alternatives ) )
            {
            // InternalBaseLanguage.g:984:2: ( ( rule__ComparisonOperatorRule__Alternatives ) )
            // InternalBaseLanguage.g:985:3: ( rule__ComparisonOperatorRule__Alternatives )
            {
             before(grammarAccess.getComparisonOperatorRuleAccess().getAlternatives()); 
            // InternalBaseLanguage.g:986:3: ( rule__ComparisonOperatorRule__Alternatives )
            // InternalBaseLanguage.g:986:4: rule__ComparisonOperatorRule__Alternatives
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
    // InternalBaseLanguage.g:995:1: ruleAddOrSubtractOperatorRule : ( ( rule__AddOrSubtractOperatorRule__Alternatives ) ) ;
    public final void ruleAddOrSubtractOperatorRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:999:1: ( ( ( rule__AddOrSubtractOperatorRule__Alternatives ) ) )
            // InternalBaseLanguage.g:1000:2: ( ( rule__AddOrSubtractOperatorRule__Alternatives ) )
            {
            // InternalBaseLanguage.g:1000:2: ( ( rule__AddOrSubtractOperatorRule__Alternatives ) )
            // InternalBaseLanguage.g:1001:3: ( rule__AddOrSubtractOperatorRule__Alternatives )
            {
             before(grammarAccess.getAddOrSubtractOperatorRuleAccess().getAlternatives()); 
            // InternalBaseLanguage.g:1002:3: ( rule__AddOrSubtractOperatorRule__Alternatives )
            // InternalBaseLanguage.g:1002:4: rule__AddOrSubtractOperatorRule__Alternatives
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
    // InternalBaseLanguage.g:1011:1: ruleMultiplyDivideModuloOperatorRule : ( ( rule__MultiplyDivideModuloOperatorRule__Alternatives ) ) ;
    public final void ruleMultiplyDivideModuloOperatorRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:1015:1: ( ( ( rule__MultiplyDivideModuloOperatorRule__Alternatives ) ) )
            // InternalBaseLanguage.g:1016:2: ( ( rule__MultiplyDivideModuloOperatorRule__Alternatives ) )
            {
            // InternalBaseLanguage.g:1016:2: ( ( rule__MultiplyDivideModuloOperatorRule__Alternatives ) )
            // InternalBaseLanguage.g:1017:3: ( rule__MultiplyDivideModuloOperatorRule__Alternatives )
            {
             before(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getAlternatives()); 
            // InternalBaseLanguage.g:1018:3: ( rule__MultiplyDivideModuloOperatorRule__Alternatives )
            // InternalBaseLanguage.g:1018:4: rule__MultiplyDivideModuloOperatorRule__Alternatives
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
    // InternalBaseLanguage.g:1027:1: ruleFactorRule : ( ( rule__FactorRule__Alternatives ) ) ;
    public final void ruleFactorRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:1031:1: ( ( ( rule__FactorRule__Alternatives ) ) )
            // InternalBaseLanguage.g:1032:2: ( ( rule__FactorRule__Alternatives ) )
            {
            // InternalBaseLanguage.g:1032:2: ( ( rule__FactorRule__Alternatives ) )
            // InternalBaseLanguage.g:1033:3: ( rule__FactorRule__Alternatives )
            {
             before(grammarAccess.getFactorRuleAccess().getAlternatives()); 
            // InternalBaseLanguage.g:1034:3: ( rule__FactorRule__Alternatives )
            // InternalBaseLanguage.g:1034:4: rule__FactorRule__Alternatives
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


    // $ANTLR start "rule__LiteralOrReferenceRule__Alternatives"
    // InternalBaseLanguage.g:1042:1: rule__LiteralOrReferenceRule__Alternatives : ( ( ruleCallRule ) | ( ruleLiteralRule ) | ( ruleParanthesesRule ) | ( ruleValueReferenceRule ) );
    public final void rule__LiteralOrReferenceRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:1046:1: ( ( ruleCallRule ) | ( ruleLiteralRule ) | ( ruleParanthesesRule ) | ( ruleValueReferenceRule ) )
            int alt1=4;
            switch ( input.LA(1) ) {
            case RULE_QUOTED_ID:
            case RULE_ID:
                {
                alt1=1;
                }
                break;
            case RULE_DOUBLE:
            case RULE_INT:
            case RULE_STRING:
            case 15:
            case 70:
                {
                alt1=2;
                }
                break;
            case 51:
                {
                alt1=3;
                }
                break;
            case 54:
                {
                alt1=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // InternalBaseLanguage.g:1047:2: ( ruleCallRule )
                    {
                    // InternalBaseLanguage.g:1047:2: ( ruleCallRule )
                    // InternalBaseLanguage.g:1048:3: ruleCallRule
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
                    // InternalBaseLanguage.g:1053:2: ( ruleLiteralRule )
                    {
                    // InternalBaseLanguage.g:1053:2: ( ruleLiteralRule )
                    // InternalBaseLanguage.g:1054:3: ruleLiteralRule
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
                    // InternalBaseLanguage.g:1059:2: ( ruleParanthesesRule )
                    {
                    // InternalBaseLanguage.g:1059:2: ( ruleParanthesesRule )
                    // InternalBaseLanguage.g:1060:3: ruleParanthesesRule
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
                    // InternalBaseLanguage.g:1065:2: ( ruleValueReferenceRule )
                    {
                    // InternalBaseLanguage.g:1065:2: ( ruleValueReferenceRule )
                    // InternalBaseLanguage.g:1066:3: ruleValueReferenceRule
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
    // InternalBaseLanguage.g:1075:1: rule__LiteralRule__Alternatives : ( ( ruleNumberLiteralRule ) | ( ruleStringLiteralRule ) | ( ruleBooleanLiteralRule ) );
    public final void rule__LiteralRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:1079:1: ( ( ruleNumberLiteralRule ) | ( ruleStringLiteralRule ) | ( ruleBooleanLiteralRule ) )
            int alt2=3;
            switch ( input.LA(1) ) {
            case RULE_DOUBLE:
            case RULE_INT:
                {
                alt2=1;
                }
                break;
            case RULE_STRING:
                {
                alt2=2;
                }
                break;
            case 15:
            case 70:
                {
                alt2=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalBaseLanguage.g:1080:2: ( ruleNumberLiteralRule )
                    {
                    // InternalBaseLanguage.g:1080:2: ( ruleNumberLiteralRule )
                    // InternalBaseLanguage.g:1081:3: ruleNumberLiteralRule
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
                    // InternalBaseLanguage.g:1086:2: ( ruleStringLiteralRule )
                    {
                    // InternalBaseLanguage.g:1086:2: ( ruleStringLiteralRule )
                    // InternalBaseLanguage.g:1087:3: ruleStringLiteralRule
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
                    // InternalBaseLanguage.g:1092:2: ( ruleBooleanLiteralRule )
                    {
                    // InternalBaseLanguage.g:1092:2: ( ruleBooleanLiteralRule )
                    // InternalBaseLanguage.g:1093:3: ruleBooleanLiteralRule
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
    // InternalBaseLanguage.g:1102:1: rule__NumberLiteralRule__Alternatives : ( ( ruleDoubleLiteralRule ) | ( ruleIntegerLiteralRule ) );
    public final void rule__NumberLiteralRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:1106:1: ( ( ruleDoubleLiteralRule ) | ( ruleIntegerLiteralRule ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_DOUBLE) ) {
                alt3=1;
            }
            else if ( (LA3_0==RULE_INT) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalBaseLanguage.g:1107:2: ( ruleDoubleLiteralRule )
                    {
                    // InternalBaseLanguage.g:1107:2: ( ruleDoubleLiteralRule )
                    // InternalBaseLanguage.g:1108:3: ruleDoubleLiteralRule
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
                    // InternalBaseLanguage.g:1113:2: ( ruleIntegerLiteralRule )
                    {
                    // InternalBaseLanguage.g:1113:2: ( ruleIntegerLiteralRule )
                    // InternalBaseLanguage.g:1114:3: ruleIntegerLiteralRule
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
    // InternalBaseLanguage.g:1123:1: rule__BooleanLiteralRule__Alternatives_1 : ( ( ( rule__BooleanLiteralRule__ValueAssignment_1_0 ) ) | ( 'false' ) );
    public final void rule__BooleanLiteralRule__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:1127:1: ( ( ( rule__BooleanLiteralRule__ValueAssignment_1_0 ) ) | ( 'false' ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==70) ) {
                alt4=1;
            }
            else if ( (LA4_0==15) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalBaseLanguage.g:1128:2: ( ( rule__BooleanLiteralRule__ValueAssignment_1_0 ) )
                    {
                    // InternalBaseLanguage.g:1128:2: ( ( rule__BooleanLiteralRule__ValueAssignment_1_0 ) )
                    // InternalBaseLanguage.g:1129:3: ( rule__BooleanLiteralRule__ValueAssignment_1_0 )
                    {
                     before(grammarAccess.getBooleanLiteralRuleAccess().getValueAssignment_1_0()); 
                    // InternalBaseLanguage.g:1130:3: ( rule__BooleanLiteralRule__ValueAssignment_1_0 )
                    // InternalBaseLanguage.g:1130:4: rule__BooleanLiteralRule__ValueAssignment_1_0
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
                    // InternalBaseLanguage.g:1134:2: ( 'false' )
                    {
                    // InternalBaseLanguage.g:1134:2: ( 'false' )
                    // InternalBaseLanguage.g:1135:3: 'false'
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
    // InternalBaseLanguage.g:1144:1: rule__TypeRule__Alternatives : ( ( ruleStringTypeRule ) | ( ruleIntTypeRule ) | ( ruleFloatTypeRule ) | ( ruleBooleanTypeRule ) | ( ruleLiteralTypeRule ) | ( ruleArrayTypeRule ) | ( ruleInstanceTypeRule ) | ( ruleVoidTypeRule ) | ( ruleExpressionTypeRule ) | ( ruleDataTypeRule ) );
    public final void rule__TypeRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:1148:1: ( ( ruleStringTypeRule ) | ( ruleIntTypeRule ) | ( ruleFloatTypeRule ) | ( ruleBooleanTypeRule ) | ( ruleLiteralTypeRule ) | ( ruleArrayTypeRule ) | ( ruleInstanceTypeRule ) | ( ruleVoidTypeRule ) | ( ruleExpressionTypeRule ) | ( ruleDataTypeRule ) )
            int alt5=10;
            switch ( input.LA(1) ) {
            case 60:
                {
                alt5=1;
                }
                break;
            case 62:
                {
                alt5=2;
                }
                break;
            case 63:
                {
                alt5=3;
                }
                break;
            case 64:
                {
                alt5=4;
                }
                break;
            case 57:
                {
                alt5=5;
                }
                break;
            case 67:
                {
                alt5=6;
                }
                break;
            case 58:
                {
                alt5=7;
                }
                break;
            case 65:
                {
                alt5=8;
                }
                break;
            case 61:
                {
                alt5=9;
                }
                break;
            case 66:
                {
                alt5=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalBaseLanguage.g:1149:2: ( ruleStringTypeRule )
                    {
                    // InternalBaseLanguage.g:1149:2: ( ruleStringTypeRule )
                    // InternalBaseLanguage.g:1150:3: ruleStringTypeRule
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
                    // InternalBaseLanguage.g:1155:2: ( ruleIntTypeRule )
                    {
                    // InternalBaseLanguage.g:1155:2: ( ruleIntTypeRule )
                    // InternalBaseLanguage.g:1156:3: ruleIntTypeRule
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
                    // InternalBaseLanguage.g:1161:2: ( ruleFloatTypeRule )
                    {
                    // InternalBaseLanguage.g:1161:2: ( ruleFloatTypeRule )
                    // InternalBaseLanguage.g:1162:3: ruleFloatTypeRule
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
                    // InternalBaseLanguage.g:1167:2: ( ruleBooleanTypeRule )
                    {
                    // InternalBaseLanguage.g:1167:2: ( ruleBooleanTypeRule )
                    // InternalBaseLanguage.g:1168:3: ruleBooleanTypeRule
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
                    // InternalBaseLanguage.g:1173:2: ( ruleLiteralTypeRule )
                    {
                    // InternalBaseLanguage.g:1173:2: ( ruleLiteralTypeRule )
                    // InternalBaseLanguage.g:1174:3: ruleLiteralTypeRule
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
                    // InternalBaseLanguage.g:1179:2: ( ruleArrayTypeRule )
                    {
                    // InternalBaseLanguage.g:1179:2: ( ruleArrayTypeRule )
                    // InternalBaseLanguage.g:1180:3: ruleArrayTypeRule
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
                    // InternalBaseLanguage.g:1185:2: ( ruleInstanceTypeRule )
                    {
                    // InternalBaseLanguage.g:1185:2: ( ruleInstanceTypeRule )
                    // InternalBaseLanguage.g:1186:3: ruleInstanceTypeRule
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
                    // InternalBaseLanguage.g:1191:2: ( ruleVoidTypeRule )
                    {
                    // InternalBaseLanguage.g:1191:2: ( ruleVoidTypeRule )
                    // InternalBaseLanguage.g:1192:3: ruleVoidTypeRule
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
                    // InternalBaseLanguage.g:1197:2: ( ruleExpressionTypeRule )
                    {
                    // InternalBaseLanguage.g:1197:2: ( ruleExpressionTypeRule )
                    // InternalBaseLanguage.g:1198:3: ruleExpressionTypeRule
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
                    // InternalBaseLanguage.g:1203:2: ( ruleDataTypeRule )
                    {
                    // InternalBaseLanguage.g:1203:2: ( ruleDataTypeRule )
                    // InternalBaseLanguage.g:1204:3: ruleDataTypeRule
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
    // InternalBaseLanguage.g:1213:1: rule__StringOrId__Alternatives : ( ( RULE_QUOTED_ID ) | ( RULE_ID ) );
    public final void rule__StringOrId__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:1217:1: ( ( RULE_QUOTED_ID ) | ( RULE_ID ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_QUOTED_ID) ) {
                alt6=1;
            }
            else if ( (LA6_0==RULE_ID) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalBaseLanguage.g:1218:2: ( RULE_QUOTED_ID )
                    {
                    // InternalBaseLanguage.g:1218:2: ( RULE_QUOTED_ID )
                    // InternalBaseLanguage.g:1219:3: RULE_QUOTED_ID
                    {
                     before(grammarAccess.getStringOrIdAccess().getQUOTED_IDTerminalRuleCall_0()); 
                    match(input,RULE_QUOTED_ID,FOLLOW_2); 
                     after(grammarAccess.getStringOrIdAccess().getQUOTED_IDTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBaseLanguage.g:1224:2: ( RULE_ID )
                    {
                    // InternalBaseLanguage.g:1224:2: ( RULE_ID )
                    // InternalBaseLanguage.g:1225:3: RULE_ID
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
    // InternalBaseLanguage.g:1234:1: rule__ComparisonOperatorRule__Alternatives : ( ( ( '>=' ) ) | ( ( '>' ) ) | ( ( '=' ) ) | ( ( '!=' ) ) | ( ( '<' ) ) | ( ( '<=' ) ) );
    public final void rule__ComparisonOperatorRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:1238:1: ( ( ( '>=' ) ) | ( ( '>' ) ) | ( ( '=' ) ) | ( ( '!=' ) ) | ( ( '<' ) ) | ( ( '<=' ) ) )
            int alt7=6;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt7=1;
                }
                break;
            case 17:
                {
                alt7=2;
                }
                break;
            case 18:
                {
                alt7=3;
                }
                break;
            case 19:
                {
                alt7=4;
                }
                break;
            case 20:
                {
                alt7=5;
                }
                break;
            case 21:
                {
                alt7=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalBaseLanguage.g:1239:2: ( ( '>=' ) )
                    {
                    // InternalBaseLanguage.g:1239:2: ( ( '>=' ) )
                    // InternalBaseLanguage.g:1240:3: ( '>=' )
                    {
                     before(grammarAccess.getComparisonOperatorRuleAccess().getGreaterThanEnumLiteralDeclaration_0()); 
                    // InternalBaseLanguage.g:1241:3: ( '>=' )
                    // InternalBaseLanguage.g:1241:4: '>='
                    {
                    match(input,16,FOLLOW_2); 

                    }

                     after(grammarAccess.getComparisonOperatorRuleAccess().getGreaterThanEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBaseLanguage.g:1245:2: ( ( '>' ) )
                    {
                    // InternalBaseLanguage.g:1245:2: ( ( '>' ) )
                    // InternalBaseLanguage.g:1246:3: ( '>' )
                    {
                     before(grammarAccess.getComparisonOperatorRuleAccess().getGreaterEqualEnumLiteralDeclaration_1()); 
                    // InternalBaseLanguage.g:1247:3: ( '>' )
                    // InternalBaseLanguage.g:1247:4: '>'
                    {
                    match(input,17,FOLLOW_2); 

                    }

                     after(grammarAccess.getComparisonOperatorRuleAccess().getGreaterEqualEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBaseLanguage.g:1251:2: ( ( '=' ) )
                    {
                    // InternalBaseLanguage.g:1251:2: ( ( '=' ) )
                    // InternalBaseLanguage.g:1252:3: ( '=' )
                    {
                     before(grammarAccess.getComparisonOperatorRuleAccess().getEqualEnumLiteralDeclaration_2()); 
                    // InternalBaseLanguage.g:1253:3: ( '=' )
                    // InternalBaseLanguage.g:1253:4: '='
                    {
                    match(input,18,FOLLOW_2); 

                    }

                     after(grammarAccess.getComparisonOperatorRuleAccess().getEqualEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalBaseLanguage.g:1257:2: ( ( '!=' ) )
                    {
                    // InternalBaseLanguage.g:1257:2: ( ( '!=' ) )
                    // InternalBaseLanguage.g:1258:3: ( '!=' )
                    {
                     before(grammarAccess.getComparisonOperatorRuleAccess().getUnequalEnumLiteralDeclaration_3()); 
                    // InternalBaseLanguage.g:1259:3: ( '!=' )
                    // InternalBaseLanguage.g:1259:4: '!='
                    {
                    match(input,19,FOLLOW_2); 

                    }

                     after(grammarAccess.getComparisonOperatorRuleAccess().getUnequalEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalBaseLanguage.g:1263:2: ( ( '<' ) )
                    {
                    // InternalBaseLanguage.g:1263:2: ( ( '<' ) )
                    // InternalBaseLanguage.g:1264:3: ( '<' )
                    {
                     before(grammarAccess.getComparisonOperatorRuleAccess().getLessEqualEnumLiteralDeclaration_4()); 
                    // InternalBaseLanguage.g:1265:3: ( '<' )
                    // InternalBaseLanguage.g:1265:4: '<'
                    {
                    match(input,20,FOLLOW_2); 

                    }

                     after(grammarAccess.getComparisonOperatorRuleAccess().getLessEqualEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalBaseLanguage.g:1269:2: ( ( '<=' ) )
                    {
                    // InternalBaseLanguage.g:1269:2: ( ( '<=' ) )
                    // InternalBaseLanguage.g:1270:3: ( '<=' )
                    {
                     before(grammarAccess.getComparisonOperatorRuleAccess().getLessThanEnumLiteralDeclaration_5()); 
                    // InternalBaseLanguage.g:1271:3: ( '<=' )
                    // InternalBaseLanguage.g:1271:4: '<='
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
    // InternalBaseLanguage.g:1279:1: rule__AddOrSubtractOperatorRule__Alternatives : ( ( ( '+' ) ) | ( ( '-' ) ) );
    public final void rule__AddOrSubtractOperatorRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:1283:1: ( ( ( '+' ) ) | ( ( '-' ) ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==22) ) {
                alt8=1;
            }
            else if ( (LA8_0==23) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalBaseLanguage.g:1284:2: ( ( '+' ) )
                    {
                    // InternalBaseLanguage.g:1284:2: ( ( '+' ) )
                    // InternalBaseLanguage.g:1285:3: ( '+' )
                    {
                     before(grammarAccess.getAddOrSubtractOperatorRuleAccess().getAddEnumLiteralDeclaration_0()); 
                    // InternalBaseLanguage.g:1286:3: ( '+' )
                    // InternalBaseLanguage.g:1286:4: '+'
                    {
                    match(input,22,FOLLOW_2); 

                    }

                     after(grammarAccess.getAddOrSubtractOperatorRuleAccess().getAddEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBaseLanguage.g:1290:2: ( ( '-' ) )
                    {
                    // InternalBaseLanguage.g:1290:2: ( ( '-' ) )
                    // InternalBaseLanguage.g:1291:3: ( '-' )
                    {
                     before(grammarAccess.getAddOrSubtractOperatorRuleAccess().getSubtractEnumLiteralDeclaration_1()); 
                    // InternalBaseLanguage.g:1292:3: ( '-' )
                    // InternalBaseLanguage.g:1292:4: '-'
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
    // InternalBaseLanguage.g:1300:1: rule__MultiplyDivideModuloOperatorRule__Alternatives : ( ( ( '*' ) ) | ( ( '/' ) ) | ( ( '%' ) ) );
    public final void rule__MultiplyDivideModuloOperatorRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:1304:1: ( ( ( '*' ) ) | ( ( '/' ) ) | ( ( '%' ) ) )
            int alt9=3;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt9=1;
                }
                break;
            case 25:
                {
                alt9=2;
                }
                break;
            case 26:
                {
                alt9=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // InternalBaseLanguage.g:1305:2: ( ( '*' ) )
                    {
                    // InternalBaseLanguage.g:1305:2: ( ( '*' ) )
                    // InternalBaseLanguage.g:1306:3: ( '*' )
                    {
                     before(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getMultiplyEnumLiteralDeclaration_0()); 
                    // InternalBaseLanguage.g:1307:3: ( '*' )
                    // InternalBaseLanguage.g:1307:4: '*'
                    {
                    match(input,24,FOLLOW_2); 

                    }

                     after(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getMultiplyEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBaseLanguage.g:1311:2: ( ( '/' ) )
                    {
                    // InternalBaseLanguage.g:1311:2: ( ( '/' ) )
                    // InternalBaseLanguage.g:1312:3: ( '/' )
                    {
                     before(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getDivideEnumLiteralDeclaration_1()); 
                    // InternalBaseLanguage.g:1313:3: ( '/' )
                    // InternalBaseLanguage.g:1313:4: '/'
                    {
                    match(input,25,FOLLOW_2); 

                    }

                     after(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getDivideEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBaseLanguage.g:1317:2: ( ( '%' ) )
                    {
                    // InternalBaseLanguage.g:1317:2: ( ( '%' ) )
                    // InternalBaseLanguage.g:1318:3: ( '%' )
                    {
                     before(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getModuloEnumLiteralDeclaration_2()); 
                    // InternalBaseLanguage.g:1319:3: ( '%' )
                    // InternalBaseLanguage.g:1319:4: '%'
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
    // InternalBaseLanguage.g:1327:1: rule__FactorRule__Alternatives : ( ( ( 'Y' ) ) | ( ( 'Z' ) ) | ( ( 'E' ) ) | ( ( 'P' ) ) | ( ( 'T' ) ) | ( ( 'G' ) ) | ( ( 'M' ) ) | ( ( 'k' ) ) | ( ( 'h' ) ) | ( ( 'da' ) ) | ( ( 'd' ) ) | ( ( 'c' ) ) | ( ( 'm' ) ) | ( ( '\\u00B5' ) ) | ( ( 'n' ) ) | ( ( 'p' ) ) | ( ( 'f' ) ) | ( ( 'a' ) ) | ( ( 'z' ) ) | ( ( 'y' ) ) );
    public final void rule__FactorRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:1331:1: ( ( ( 'Y' ) ) | ( ( 'Z' ) ) | ( ( 'E' ) ) | ( ( 'P' ) ) | ( ( 'T' ) ) | ( ( 'G' ) ) | ( ( 'M' ) ) | ( ( 'k' ) ) | ( ( 'h' ) ) | ( ( 'da' ) ) | ( ( 'd' ) ) | ( ( 'c' ) ) | ( ( 'm' ) ) | ( ( '\\u00B5' ) ) | ( ( 'n' ) ) | ( ( 'p' ) ) | ( ( 'f' ) ) | ( ( 'a' ) ) | ( ( 'z' ) ) | ( ( 'y' ) ) )
            int alt10=20;
            switch ( input.LA(1) ) {
            case 27:
                {
                alt10=1;
                }
                break;
            case 28:
                {
                alt10=2;
                }
                break;
            case 29:
                {
                alt10=3;
                }
                break;
            case 30:
                {
                alt10=4;
                }
                break;
            case 31:
                {
                alt10=5;
                }
                break;
            case 32:
                {
                alt10=6;
                }
                break;
            case 33:
                {
                alt10=7;
                }
                break;
            case 34:
                {
                alt10=8;
                }
                break;
            case 35:
                {
                alt10=9;
                }
                break;
            case 36:
                {
                alt10=10;
                }
                break;
            case 37:
                {
                alt10=11;
                }
                break;
            case 38:
                {
                alt10=12;
                }
                break;
            case 39:
                {
                alt10=13;
                }
                break;
            case 40:
                {
                alt10=14;
                }
                break;
            case 41:
                {
                alt10=15;
                }
                break;
            case 42:
                {
                alt10=16;
                }
                break;
            case 43:
                {
                alt10=17;
                }
                break;
            case 44:
                {
                alt10=18;
                }
                break;
            case 45:
                {
                alt10=19;
                }
                break;
            case 46:
                {
                alt10=20;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalBaseLanguage.g:1332:2: ( ( 'Y' ) )
                    {
                    // InternalBaseLanguage.g:1332:2: ( ( 'Y' ) )
                    // InternalBaseLanguage.g:1333:3: ( 'Y' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getYottaEnumLiteralDeclaration_0()); 
                    // InternalBaseLanguage.g:1334:3: ( 'Y' )
                    // InternalBaseLanguage.g:1334:4: 'Y'
                    {
                    match(input,27,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getYottaEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBaseLanguage.g:1338:2: ( ( 'Z' ) )
                    {
                    // InternalBaseLanguage.g:1338:2: ( ( 'Z' ) )
                    // InternalBaseLanguage.g:1339:3: ( 'Z' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getZettaEnumLiteralDeclaration_1()); 
                    // InternalBaseLanguage.g:1340:3: ( 'Z' )
                    // InternalBaseLanguage.g:1340:4: 'Z'
                    {
                    match(input,28,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getZettaEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBaseLanguage.g:1344:2: ( ( 'E' ) )
                    {
                    // InternalBaseLanguage.g:1344:2: ( ( 'E' ) )
                    // InternalBaseLanguage.g:1345:3: ( 'E' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getExaEnumLiteralDeclaration_2()); 
                    // InternalBaseLanguage.g:1346:3: ( 'E' )
                    // InternalBaseLanguage.g:1346:4: 'E'
                    {
                    match(input,29,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getExaEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalBaseLanguage.g:1350:2: ( ( 'P' ) )
                    {
                    // InternalBaseLanguage.g:1350:2: ( ( 'P' ) )
                    // InternalBaseLanguage.g:1351:3: ( 'P' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getPetaEnumLiteralDeclaration_3()); 
                    // InternalBaseLanguage.g:1352:3: ( 'P' )
                    // InternalBaseLanguage.g:1352:4: 'P'
                    {
                    match(input,30,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getPetaEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalBaseLanguage.g:1356:2: ( ( 'T' ) )
                    {
                    // InternalBaseLanguage.g:1356:2: ( ( 'T' ) )
                    // InternalBaseLanguage.g:1357:3: ( 'T' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getTeraEnumLiteralDeclaration_4()); 
                    // InternalBaseLanguage.g:1358:3: ( 'T' )
                    // InternalBaseLanguage.g:1358:4: 'T'
                    {
                    match(input,31,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getTeraEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalBaseLanguage.g:1362:2: ( ( 'G' ) )
                    {
                    // InternalBaseLanguage.g:1362:2: ( ( 'G' ) )
                    // InternalBaseLanguage.g:1363:3: ( 'G' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getGigaEnumLiteralDeclaration_5()); 
                    // InternalBaseLanguage.g:1364:3: ( 'G' )
                    // InternalBaseLanguage.g:1364:4: 'G'
                    {
                    match(input,32,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getGigaEnumLiteralDeclaration_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalBaseLanguage.g:1368:2: ( ( 'M' ) )
                    {
                    // InternalBaseLanguage.g:1368:2: ( ( 'M' ) )
                    // InternalBaseLanguage.g:1369:3: ( 'M' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getMegaEnumLiteralDeclaration_6()); 
                    // InternalBaseLanguage.g:1370:3: ( 'M' )
                    // InternalBaseLanguage.g:1370:4: 'M'
                    {
                    match(input,33,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getMegaEnumLiteralDeclaration_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalBaseLanguage.g:1374:2: ( ( 'k' ) )
                    {
                    // InternalBaseLanguage.g:1374:2: ( ( 'k' ) )
                    // InternalBaseLanguage.g:1375:3: ( 'k' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getKiloEnumLiteralDeclaration_7()); 
                    // InternalBaseLanguage.g:1376:3: ( 'k' )
                    // InternalBaseLanguage.g:1376:4: 'k'
                    {
                    match(input,34,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getKiloEnumLiteralDeclaration_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalBaseLanguage.g:1380:2: ( ( 'h' ) )
                    {
                    // InternalBaseLanguage.g:1380:2: ( ( 'h' ) )
                    // InternalBaseLanguage.g:1381:3: ( 'h' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getHectoEnumLiteralDeclaration_8()); 
                    // InternalBaseLanguage.g:1382:3: ( 'h' )
                    // InternalBaseLanguage.g:1382:4: 'h'
                    {
                    match(input,35,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getHectoEnumLiteralDeclaration_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalBaseLanguage.g:1386:2: ( ( 'da' ) )
                    {
                    // InternalBaseLanguage.g:1386:2: ( ( 'da' ) )
                    // InternalBaseLanguage.g:1387:3: ( 'da' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getDekaEnumLiteralDeclaration_9()); 
                    // InternalBaseLanguage.g:1388:3: ( 'da' )
                    // InternalBaseLanguage.g:1388:4: 'da'
                    {
                    match(input,36,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getDekaEnumLiteralDeclaration_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalBaseLanguage.g:1392:2: ( ( 'd' ) )
                    {
                    // InternalBaseLanguage.g:1392:2: ( ( 'd' ) )
                    // InternalBaseLanguage.g:1393:3: ( 'd' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getDeciEnumLiteralDeclaration_10()); 
                    // InternalBaseLanguage.g:1394:3: ( 'd' )
                    // InternalBaseLanguage.g:1394:4: 'd'
                    {
                    match(input,37,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getDeciEnumLiteralDeclaration_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalBaseLanguage.g:1398:2: ( ( 'c' ) )
                    {
                    // InternalBaseLanguage.g:1398:2: ( ( 'c' ) )
                    // InternalBaseLanguage.g:1399:3: ( 'c' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getCentiEnumLiteralDeclaration_11()); 
                    // InternalBaseLanguage.g:1400:3: ( 'c' )
                    // InternalBaseLanguage.g:1400:4: 'c'
                    {
                    match(input,38,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getCentiEnumLiteralDeclaration_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalBaseLanguage.g:1404:2: ( ( 'm' ) )
                    {
                    // InternalBaseLanguage.g:1404:2: ( ( 'm' ) )
                    // InternalBaseLanguage.g:1405:3: ( 'm' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getMilliEnumLiteralDeclaration_12()); 
                    // InternalBaseLanguage.g:1406:3: ( 'm' )
                    // InternalBaseLanguage.g:1406:4: 'm'
                    {
                    match(input,39,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getMilliEnumLiteralDeclaration_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalBaseLanguage.g:1410:2: ( ( '\\u00B5' ) )
                    {
                    // InternalBaseLanguage.g:1410:2: ( ( '\\u00B5' ) )
                    // InternalBaseLanguage.g:1411:3: ( '\\u00B5' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getMicroEnumLiteralDeclaration_13()); 
                    // InternalBaseLanguage.g:1412:3: ( '\\u00B5' )
                    // InternalBaseLanguage.g:1412:4: '\\u00B5'
                    {
                    match(input,40,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getMicroEnumLiteralDeclaration_13()); 

                    }


                    }
                    break;
                case 15 :
                    // InternalBaseLanguage.g:1416:2: ( ( 'n' ) )
                    {
                    // InternalBaseLanguage.g:1416:2: ( ( 'n' ) )
                    // InternalBaseLanguage.g:1417:3: ( 'n' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getNanoEnumLiteralDeclaration_14()); 
                    // InternalBaseLanguage.g:1418:3: ( 'n' )
                    // InternalBaseLanguage.g:1418:4: 'n'
                    {
                    match(input,41,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getNanoEnumLiteralDeclaration_14()); 

                    }


                    }
                    break;
                case 16 :
                    // InternalBaseLanguage.g:1422:2: ( ( 'p' ) )
                    {
                    // InternalBaseLanguage.g:1422:2: ( ( 'p' ) )
                    // InternalBaseLanguage.g:1423:3: ( 'p' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getPikoEnumLiteralDeclaration_15()); 
                    // InternalBaseLanguage.g:1424:3: ( 'p' )
                    // InternalBaseLanguage.g:1424:4: 'p'
                    {
                    match(input,42,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getPikoEnumLiteralDeclaration_15()); 

                    }


                    }
                    break;
                case 17 :
                    // InternalBaseLanguage.g:1428:2: ( ( 'f' ) )
                    {
                    // InternalBaseLanguage.g:1428:2: ( ( 'f' ) )
                    // InternalBaseLanguage.g:1429:3: ( 'f' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getFemtoEnumLiteralDeclaration_16()); 
                    // InternalBaseLanguage.g:1430:3: ( 'f' )
                    // InternalBaseLanguage.g:1430:4: 'f'
                    {
                    match(input,43,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getFemtoEnumLiteralDeclaration_16()); 

                    }


                    }
                    break;
                case 18 :
                    // InternalBaseLanguage.g:1434:2: ( ( 'a' ) )
                    {
                    // InternalBaseLanguage.g:1434:2: ( ( 'a' ) )
                    // InternalBaseLanguage.g:1435:3: ( 'a' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getAttoEnumLiteralDeclaration_17()); 
                    // InternalBaseLanguage.g:1436:3: ( 'a' )
                    // InternalBaseLanguage.g:1436:4: 'a'
                    {
                    match(input,44,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getAttoEnumLiteralDeclaration_17()); 

                    }


                    }
                    break;
                case 19 :
                    // InternalBaseLanguage.g:1440:2: ( ( 'z' ) )
                    {
                    // InternalBaseLanguage.g:1440:2: ( ( 'z' ) )
                    // InternalBaseLanguage.g:1441:3: ( 'z' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getZeptoEnumLiteralDeclaration_18()); 
                    // InternalBaseLanguage.g:1442:3: ( 'z' )
                    // InternalBaseLanguage.g:1442:4: 'z'
                    {
                    match(input,45,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getZeptoEnumLiteralDeclaration_18()); 

                    }


                    }
                    break;
                case 20 :
                    // InternalBaseLanguage.g:1446:2: ( ( 'y' ) )
                    {
                    // InternalBaseLanguage.g:1446:2: ( ( 'y' ) )
                    // InternalBaseLanguage.g:1447:3: ( 'y' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getYoctoEnumLiteralDeclaration_19()); 
                    // InternalBaseLanguage.g:1448:3: ( 'y' )
                    // InternalBaseLanguage.g:1448:4: 'y'
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


    // $ANTLR start "rule__OrExpressionRule__Group__0"
    // InternalBaseLanguage.g:1456:1: rule__OrExpressionRule__Group__0 : rule__OrExpressionRule__Group__0__Impl rule__OrExpressionRule__Group__1 ;
    public final void rule__OrExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:1460:1: ( rule__OrExpressionRule__Group__0__Impl rule__OrExpressionRule__Group__1 )
            // InternalBaseLanguage.g:1461:2: rule__OrExpressionRule__Group__0__Impl rule__OrExpressionRule__Group__1
            {
            pushFollow(FOLLOW_3);
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
    // InternalBaseLanguage.g:1468:1: rule__OrExpressionRule__Group__0__Impl : ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) ) ;
    public final void rule__OrExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:1472:1: ( ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) ) )
            // InternalBaseLanguage.g:1473:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) )
            {
            // InternalBaseLanguage.g:1473:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) )
            // InternalBaseLanguage.g:1474:2: ( rule__OrExpressionRule__SubExpressionsAssignment_0 )
            {
             before(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsAssignment_0()); 
            // InternalBaseLanguage.g:1475:2: ( rule__OrExpressionRule__SubExpressionsAssignment_0 )
            // InternalBaseLanguage.g:1475:3: rule__OrExpressionRule__SubExpressionsAssignment_0
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
    // InternalBaseLanguage.g:1483:1: rule__OrExpressionRule__Group__1 : rule__OrExpressionRule__Group__1__Impl ;
    public final void rule__OrExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:1487:1: ( rule__OrExpressionRule__Group__1__Impl )
            // InternalBaseLanguage.g:1488:2: rule__OrExpressionRule__Group__1__Impl
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
    // InternalBaseLanguage.g:1494:1: rule__OrExpressionRule__Group__1__Impl : ( ( rule__OrExpressionRule__Group_1__0 )* ) ;
    public final void rule__OrExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:1498:1: ( ( ( rule__OrExpressionRule__Group_1__0 )* ) )
            // InternalBaseLanguage.g:1499:1: ( ( rule__OrExpressionRule__Group_1__0 )* )
            {
            // InternalBaseLanguage.g:1499:1: ( ( rule__OrExpressionRule__Group_1__0 )* )
            // InternalBaseLanguage.g:1500:2: ( rule__OrExpressionRule__Group_1__0 )*
            {
             before(grammarAccess.getOrExpressionRuleAccess().getGroup_1()); 
            // InternalBaseLanguage.g:1501:2: ( rule__OrExpressionRule__Group_1__0 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==47) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalBaseLanguage.g:1501:3: rule__OrExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_4);
            	    rule__OrExpressionRule__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
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
    // InternalBaseLanguage.g:1510:1: rule__OrExpressionRule__Group_1__0 : rule__OrExpressionRule__Group_1__0__Impl rule__OrExpressionRule__Group_1__1 ;
    public final void rule__OrExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:1514:1: ( rule__OrExpressionRule__Group_1__0__Impl rule__OrExpressionRule__Group_1__1 )
            // InternalBaseLanguage.g:1515:2: rule__OrExpressionRule__Group_1__0__Impl rule__OrExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_5);
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
    // InternalBaseLanguage.g:1522:1: rule__OrExpressionRule__Group_1__0__Impl : ( 'OR' ) ;
    public final void rule__OrExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:1526:1: ( ( 'OR' ) )
            // InternalBaseLanguage.g:1527:1: ( 'OR' )
            {
            // InternalBaseLanguage.g:1527:1: ( 'OR' )
            // InternalBaseLanguage.g:1528:2: 'OR'
            {
             before(grammarAccess.getOrExpressionRuleAccess().getORKeyword_1_0()); 
            match(input,47,FOLLOW_2); 
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
    // InternalBaseLanguage.g:1537:1: rule__OrExpressionRule__Group_1__1 : rule__OrExpressionRule__Group_1__1__Impl ;
    public final void rule__OrExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:1541:1: ( rule__OrExpressionRule__Group_1__1__Impl )
            // InternalBaseLanguage.g:1542:2: rule__OrExpressionRule__Group_1__1__Impl
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
    // InternalBaseLanguage.g:1548:1: rule__OrExpressionRule__Group_1__1__Impl : ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) ) ;
    public final void rule__OrExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:1552:1: ( ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) ) )
            // InternalBaseLanguage.g:1553:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) )
            {
            // InternalBaseLanguage.g:1553:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) )
            // InternalBaseLanguage.g:1554:2: ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 )
            {
             before(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsAssignment_1_1()); 
            // InternalBaseLanguage.g:1555:2: ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 )
            // InternalBaseLanguage.g:1555:3: rule__OrExpressionRule__SubExpressionsAssignment_1_1
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
    // InternalBaseLanguage.g:1564:1: rule__XorExpressionRule__Group__0 : rule__XorExpressionRule__Group__0__Impl rule__XorExpressionRule__Group__1 ;
    public final void rule__XorExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:1568:1: ( rule__XorExpressionRule__Group__0__Impl rule__XorExpressionRule__Group__1 )
            // InternalBaseLanguage.g:1569:2: rule__XorExpressionRule__Group__0__Impl rule__XorExpressionRule__Group__1
            {
            pushFollow(FOLLOW_6);
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
    // InternalBaseLanguage.g:1576:1: rule__XorExpressionRule__Group__0__Impl : ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) ) ;
    public final void rule__XorExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:1580:1: ( ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) ) )
            // InternalBaseLanguage.g:1581:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) )
            {
            // InternalBaseLanguage.g:1581:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) )
            // InternalBaseLanguage.g:1582:2: ( rule__XorExpressionRule__SubExpressionsAssignment_0 )
            {
             before(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAssignment_0()); 
            // InternalBaseLanguage.g:1583:2: ( rule__XorExpressionRule__SubExpressionsAssignment_0 )
            // InternalBaseLanguage.g:1583:3: rule__XorExpressionRule__SubExpressionsAssignment_0
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
    // InternalBaseLanguage.g:1591:1: rule__XorExpressionRule__Group__1 : rule__XorExpressionRule__Group__1__Impl ;
    public final void rule__XorExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:1595:1: ( rule__XorExpressionRule__Group__1__Impl )
            // InternalBaseLanguage.g:1596:2: rule__XorExpressionRule__Group__1__Impl
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
    // InternalBaseLanguage.g:1602:1: rule__XorExpressionRule__Group__1__Impl : ( ( rule__XorExpressionRule__Group_1__0 )* ) ;
    public final void rule__XorExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:1606:1: ( ( ( rule__XorExpressionRule__Group_1__0 )* ) )
            // InternalBaseLanguage.g:1607:1: ( ( rule__XorExpressionRule__Group_1__0 )* )
            {
            // InternalBaseLanguage.g:1607:1: ( ( rule__XorExpressionRule__Group_1__0 )* )
            // InternalBaseLanguage.g:1608:2: ( rule__XorExpressionRule__Group_1__0 )*
            {
             before(grammarAccess.getXorExpressionRuleAccess().getGroup_1()); 
            // InternalBaseLanguage.g:1609:2: ( rule__XorExpressionRule__Group_1__0 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==48) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalBaseLanguage.g:1609:3: rule__XorExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_7);
            	    rule__XorExpressionRule__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
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
    // InternalBaseLanguage.g:1618:1: rule__XorExpressionRule__Group_1__0 : rule__XorExpressionRule__Group_1__0__Impl rule__XorExpressionRule__Group_1__1 ;
    public final void rule__XorExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:1622:1: ( rule__XorExpressionRule__Group_1__0__Impl rule__XorExpressionRule__Group_1__1 )
            // InternalBaseLanguage.g:1623:2: rule__XorExpressionRule__Group_1__0__Impl rule__XorExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_5);
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
    // InternalBaseLanguage.g:1630:1: rule__XorExpressionRule__Group_1__0__Impl : ( 'XOR' ) ;
    public final void rule__XorExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:1634:1: ( ( 'XOR' ) )
            // InternalBaseLanguage.g:1635:1: ( 'XOR' )
            {
            // InternalBaseLanguage.g:1635:1: ( 'XOR' )
            // InternalBaseLanguage.g:1636:2: 'XOR'
            {
             before(grammarAccess.getXorExpressionRuleAccess().getXORKeyword_1_0()); 
            match(input,48,FOLLOW_2); 
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
    // InternalBaseLanguage.g:1645:1: rule__XorExpressionRule__Group_1__1 : rule__XorExpressionRule__Group_1__1__Impl ;
    public final void rule__XorExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:1649:1: ( rule__XorExpressionRule__Group_1__1__Impl )
            // InternalBaseLanguage.g:1650:2: rule__XorExpressionRule__Group_1__1__Impl
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
    // InternalBaseLanguage.g:1656:1: rule__XorExpressionRule__Group_1__1__Impl : ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) ) ;
    public final void rule__XorExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:1660:1: ( ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) ) )
            // InternalBaseLanguage.g:1661:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) )
            {
            // InternalBaseLanguage.g:1661:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) )
            // InternalBaseLanguage.g:1662:2: ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 )
            {
             before(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAssignment_1_1()); 
            // InternalBaseLanguage.g:1663:2: ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 )
            // InternalBaseLanguage.g:1663:3: rule__XorExpressionRule__SubExpressionsAssignment_1_1
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
    // InternalBaseLanguage.g:1672:1: rule__AndExpressionRule__Group__0 : rule__AndExpressionRule__Group__0__Impl rule__AndExpressionRule__Group__1 ;
    public final void rule__AndExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:1676:1: ( rule__AndExpressionRule__Group__0__Impl rule__AndExpressionRule__Group__1 )
            // InternalBaseLanguage.g:1677:2: rule__AndExpressionRule__Group__0__Impl rule__AndExpressionRule__Group__1
            {
            pushFollow(FOLLOW_8);
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
    // InternalBaseLanguage.g:1684:1: rule__AndExpressionRule__Group__0__Impl : ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) ) ;
    public final void rule__AndExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:1688:1: ( ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) ) )
            // InternalBaseLanguage.g:1689:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) )
            {
            // InternalBaseLanguage.g:1689:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) )
            // InternalBaseLanguage.g:1690:2: ( rule__AndExpressionRule__SubExpressionsAssignment_0 )
            {
             before(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsAssignment_0()); 
            // InternalBaseLanguage.g:1691:2: ( rule__AndExpressionRule__SubExpressionsAssignment_0 )
            // InternalBaseLanguage.g:1691:3: rule__AndExpressionRule__SubExpressionsAssignment_0
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
    // InternalBaseLanguage.g:1699:1: rule__AndExpressionRule__Group__1 : rule__AndExpressionRule__Group__1__Impl ;
    public final void rule__AndExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:1703:1: ( rule__AndExpressionRule__Group__1__Impl )
            // InternalBaseLanguage.g:1704:2: rule__AndExpressionRule__Group__1__Impl
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
    // InternalBaseLanguage.g:1710:1: rule__AndExpressionRule__Group__1__Impl : ( ( rule__AndExpressionRule__Group_1__0 )* ) ;
    public final void rule__AndExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:1714:1: ( ( ( rule__AndExpressionRule__Group_1__0 )* ) )
            // InternalBaseLanguage.g:1715:1: ( ( rule__AndExpressionRule__Group_1__0 )* )
            {
            // InternalBaseLanguage.g:1715:1: ( ( rule__AndExpressionRule__Group_1__0 )* )
            // InternalBaseLanguage.g:1716:2: ( rule__AndExpressionRule__Group_1__0 )*
            {
             before(grammarAccess.getAndExpressionRuleAccess().getGroup_1()); 
            // InternalBaseLanguage.g:1717:2: ( rule__AndExpressionRule__Group_1__0 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==49) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalBaseLanguage.g:1717:3: rule__AndExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__AndExpressionRule__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
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
    // InternalBaseLanguage.g:1726:1: rule__AndExpressionRule__Group_1__0 : rule__AndExpressionRule__Group_1__0__Impl rule__AndExpressionRule__Group_1__1 ;
    public final void rule__AndExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:1730:1: ( rule__AndExpressionRule__Group_1__0__Impl rule__AndExpressionRule__Group_1__1 )
            // InternalBaseLanguage.g:1731:2: rule__AndExpressionRule__Group_1__0__Impl rule__AndExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_5);
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
    // InternalBaseLanguage.g:1738:1: rule__AndExpressionRule__Group_1__0__Impl : ( 'AND' ) ;
    public final void rule__AndExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:1742:1: ( ( 'AND' ) )
            // InternalBaseLanguage.g:1743:1: ( 'AND' )
            {
            // InternalBaseLanguage.g:1743:1: ( 'AND' )
            // InternalBaseLanguage.g:1744:2: 'AND'
            {
             before(grammarAccess.getAndExpressionRuleAccess().getANDKeyword_1_0()); 
            match(input,49,FOLLOW_2); 
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
    // InternalBaseLanguage.g:1753:1: rule__AndExpressionRule__Group_1__1 : rule__AndExpressionRule__Group_1__1__Impl ;
    public final void rule__AndExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:1757:1: ( rule__AndExpressionRule__Group_1__1__Impl )
            // InternalBaseLanguage.g:1758:2: rule__AndExpressionRule__Group_1__1__Impl
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
    // InternalBaseLanguage.g:1764:1: rule__AndExpressionRule__Group_1__1__Impl : ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) ) ;
    public final void rule__AndExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:1768:1: ( ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) ) )
            // InternalBaseLanguage.g:1769:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) )
            {
            // InternalBaseLanguage.g:1769:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) )
            // InternalBaseLanguage.g:1770:2: ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 )
            {
             before(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsAssignment_1_1()); 
            // InternalBaseLanguage.g:1771:2: ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 )
            // InternalBaseLanguage.g:1771:3: rule__AndExpressionRule__SubExpressionsAssignment_1_1
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
    // InternalBaseLanguage.g:1780:1: rule__NotExpressionRule__Group__0 : rule__NotExpressionRule__Group__0__Impl rule__NotExpressionRule__Group__1 ;
    public final void rule__NotExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:1784:1: ( rule__NotExpressionRule__Group__0__Impl rule__NotExpressionRule__Group__1 )
            // InternalBaseLanguage.g:1785:2: rule__NotExpressionRule__Group__0__Impl rule__NotExpressionRule__Group__1
            {
            pushFollow(FOLLOW_5);
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
    // InternalBaseLanguage.g:1792:1: rule__NotExpressionRule__Group__0__Impl : ( ( rule__NotExpressionRule__NegatedAssignment_0 )? ) ;
    public final void rule__NotExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:1796:1: ( ( ( rule__NotExpressionRule__NegatedAssignment_0 )? ) )
            // InternalBaseLanguage.g:1797:1: ( ( rule__NotExpressionRule__NegatedAssignment_0 )? )
            {
            // InternalBaseLanguage.g:1797:1: ( ( rule__NotExpressionRule__NegatedAssignment_0 )? )
            // InternalBaseLanguage.g:1798:2: ( rule__NotExpressionRule__NegatedAssignment_0 )?
            {
             before(grammarAccess.getNotExpressionRuleAccess().getNegatedAssignment_0()); 
            // InternalBaseLanguage.g:1799:2: ( rule__NotExpressionRule__NegatedAssignment_0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==69) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalBaseLanguage.g:1799:3: rule__NotExpressionRule__NegatedAssignment_0
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
    // InternalBaseLanguage.g:1807:1: rule__NotExpressionRule__Group__1 : rule__NotExpressionRule__Group__1__Impl ;
    public final void rule__NotExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:1811:1: ( rule__NotExpressionRule__Group__1__Impl )
            // InternalBaseLanguage.g:1812:2: rule__NotExpressionRule__Group__1__Impl
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
    // InternalBaseLanguage.g:1818:1: rule__NotExpressionRule__Group__1__Impl : ( ( rule__NotExpressionRule__OperandAssignment_1 ) ) ;
    public final void rule__NotExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:1822:1: ( ( ( rule__NotExpressionRule__OperandAssignment_1 ) ) )
            // InternalBaseLanguage.g:1823:1: ( ( rule__NotExpressionRule__OperandAssignment_1 ) )
            {
            // InternalBaseLanguage.g:1823:1: ( ( rule__NotExpressionRule__OperandAssignment_1 ) )
            // InternalBaseLanguage.g:1824:2: ( rule__NotExpressionRule__OperandAssignment_1 )
            {
             before(grammarAccess.getNotExpressionRuleAccess().getOperandAssignment_1()); 
            // InternalBaseLanguage.g:1825:2: ( rule__NotExpressionRule__OperandAssignment_1 )
            // InternalBaseLanguage.g:1825:3: rule__NotExpressionRule__OperandAssignment_1
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
    // InternalBaseLanguage.g:1834:1: rule__ComparisonExpressionRule__Group__0 : rule__ComparisonExpressionRule__Group__0__Impl rule__ComparisonExpressionRule__Group__1 ;
    public final void rule__ComparisonExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:1838:1: ( rule__ComparisonExpressionRule__Group__0__Impl rule__ComparisonExpressionRule__Group__1 )
            // InternalBaseLanguage.g:1839:2: rule__ComparisonExpressionRule__Group__0__Impl rule__ComparisonExpressionRule__Group__1
            {
            pushFollow(FOLLOW_10);
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
    // InternalBaseLanguage.g:1846:1: rule__ComparisonExpressionRule__Group__0__Impl : ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__ComparisonExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:1850:1: ( ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalBaseLanguage.g:1851:1: ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalBaseLanguage.g:1851:1: ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) )
            // InternalBaseLanguage.g:1852:2: ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 )
            {
             before(grammarAccess.getComparisonExpressionRuleAccess().getLeftOperandAssignment_0()); 
            // InternalBaseLanguage.g:1853:2: ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 )
            // InternalBaseLanguage.g:1853:3: rule__ComparisonExpressionRule__LeftOperandAssignment_0
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
    // InternalBaseLanguage.g:1861:1: rule__ComparisonExpressionRule__Group__1 : rule__ComparisonExpressionRule__Group__1__Impl ;
    public final void rule__ComparisonExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:1865:1: ( rule__ComparisonExpressionRule__Group__1__Impl )
            // InternalBaseLanguage.g:1866:2: rule__ComparisonExpressionRule__Group__1__Impl
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
    // InternalBaseLanguage.g:1872:1: rule__ComparisonExpressionRule__Group__1__Impl : ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* ) ;
    public final void rule__ComparisonExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:1876:1: ( ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* ) )
            // InternalBaseLanguage.g:1877:1: ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* )
            {
            // InternalBaseLanguage.g:1877:1: ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* )
            // InternalBaseLanguage.g:1878:2: ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )*
            {
             before(grammarAccess.getComparisonExpressionRuleAccess().getComparisonAssignment_1()); 
            // InternalBaseLanguage.g:1879:2: ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>=16 && LA15_0<=21)) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalBaseLanguage.g:1879:3: rule__ComparisonExpressionRule__ComparisonAssignment_1
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__ComparisonExpressionRule__ComparisonAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
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
    // InternalBaseLanguage.g:1888:1: rule__PartialComparisonExpressionRule__Group__0 : rule__PartialComparisonExpressionRule__Group__0__Impl rule__PartialComparisonExpressionRule__Group__1 ;
    public final void rule__PartialComparisonExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:1892:1: ( rule__PartialComparisonExpressionRule__Group__0__Impl rule__PartialComparisonExpressionRule__Group__1 )
            // InternalBaseLanguage.g:1893:2: rule__PartialComparisonExpressionRule__Group__0__Impl rule__PartialComparisonExpressionRule__Group__1
            {
            pushFollow(FOLLOW_5);
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
    // InternalBaseLanguage.g:1900:1: rule__PartialComparisonExpressionRule__Group__0__Impl : ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) ) ;
    public final void rule__PartialComparisonExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:1904:1: ( ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) ) )
            // InternalBaseLanguage.g:1905:1: ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) )
            {
            // InternalBaseLanguage.g:1905:1: ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) )
            // InternalBaseLanguage.g:1906:2: ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 )
            {
             before(grammarAccess.getPartialComparisonExpressionRuleAccess().getOperatorAssignment_0()); 
            // InternalBaseLanguage.g:1907:2: ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 )
            // InternalBaseLanguage.g:1907:3: rule__PartialComparisonExpressionRule__OperatorAssignment_0
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
    // InternalBaseLanguage.g:1915:1: rule__PartialComparisonExpressionRule__Group__1 : rule__PartialComparisonExpressionRule__Group__1__Impl ;
    public final void rule__PartialComparisonExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:1919:1: ( rule__PartialComparisonExpressionRule__Group__1__Impl )
            // InternalBaseLanguage.g:1920:2: rule__PartialComparisonExpressionRule__Group__1__Impl
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
    // InternalBaseLanguage.g:1926:1: rule__PartialComparisonExpressionRule__Group__1__Impl : ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) ) ;
    public final void rule__PartialComparisonExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:1930:1: ( ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) ) )
            // InternalBaseLanguage.g:1931:1: ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) )
            {
            // InternalBaseLanguage.g:1931:1: ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) )
            // InternalBaseLanguage.g:1932:2: ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 )
            {
             before(grammarAccess.getPartialComparisonExpressionRuleAccess().getSubExpressionAssignment_1()); 
            // InternalBaseLanguage.g:1933:2: ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 )
            // InternalBaseLanguage.g:1933:3: rule__PartialComparisonExpressionRule__SubExpressionAssignment_1
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
    // InternalBaseLanguage.g:1942:1: rule__AddOrSubtractExpressionRule__Group__0 : rule__AddOrSubtractExpressionRule__Group__0__Impl rule__AddOrSubtractExpressionRule__Group__1 ;
    public final void rule__AddOrSubtractExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:1946:1: ( rule__AddOrSubtractExpressionRule__Group__0__Impl rule__AddOrSubtractExpressionRule__Group__1 )
            // InternalBaseLanguage.g:1947:2: rule__AddOrSubtractExpressionRule__Group__0__Impl rule__AddOrSubtractExpressionRule__Group__1
            {
            pushFollow(FOLLOW_12);
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
    // InternalBaseLanguage.g:1954:1: rule__AddOrSubtractExpressionRule__Group__0__Impl : ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__AddOrSubtractExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:1958:1: ( ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalBaseLanguage.g:1959:1: ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalBaseLanguage.g:1959:1: ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) )
            // InternalBaseLanguage.g:1960:2: ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 )
            {
             before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getLeftOperandAssignment_0()); 
            // InternalBaseLanguage.g:1961:2: ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 )
            // InternalBaseLanguage.g:1961:3: rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0
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
    // InternalBaseLanguage.g:1969:1: rule__AddOrSubtractExpressionRule__Group__1 : rule__AddOrSubtractExpressionRule__Group__1__Impl ;
    public final void rule__AddOrSubtractExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:1973:1: ( rule__AddOrSubtractExpressionRule__Group__1__Impl )
            // InternalBaseLanguage.g:1974:2: rule__AddOrSubtractExpressionRule__Group__1__Impl
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
    // InternalBaseLanguage.g:1980:1: rule__AddOrSubtractExpressionRule__Group__1__Impl : ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* ) ;
    public final void rule__AddOrSubtractExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:1984:1: ( ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* ) )
            // InternalBaseLanguage.g:1985:1: ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* )
            {
            // InternalBaseLanguage.g:1985:1: ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* )
            // InternalBaseLanguage.g:1986:2: ( rule__AddOrSubtractExpressionRule__Group_1__0 )*
            {
             before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getGroup_1()); 
            // InternalBaseLanguage.g:1987:2: ( rule__AddOrSubtractExpressionRule__Group_1__0 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>=22 && LA16_0<=23)) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalBaseLanguage.g:1987:3: rule__AddOrSubtractExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_13);
            	    rule__AddOrSubtractExpressionRule__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
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
    // InternalBaseLanguage.g:1996:1: rule__AddOrSubtractExpressionRule__Group_1__0 : rule__AddOrSubtractExpressionRule__Group_1__0__Impl rule__AddOrSubtractExpressionRule__Group_1__1 ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2000:1: ( rule__AddOrSubtractExpressionRule__Group_1__0__Impl rule__AddOrSubtractExpressionRule__Group_1__1 )
            // InternalBaseLanguage.g:2001:2: rule__AddOrSubtractExpressionRule__Group_1__0__Impl rule__AddOrSubtractExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_5);
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
    // InternalBaseLanguage.g:2008:1: rule__AddOrSubtractExpressionRule__Group_1__0__Impl : ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) ) ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2012:1: ( ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) ) )
            // InternalBaseLanguage.g:2013:1: ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) )
            {
            // InternalBaseLanguage.g:2013:1: ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) )
            // InternalBaseLanguage.g:2014:2: ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 )
            {
             before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperatorsAssignment_1_0()); 
            // InternalBaseLanguage.g:2015:2: ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 )
            // InternalBaseLanguage.g:2015:3: rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0
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
    // InternalBaseLanguage.g:2023:1: rule__AddOrSubtractExpressionRule__Group_1__1 : rule__AddOrSubtractExpressionRule__Group_1__1__Impl ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2027:1: ( rule__AddOrSubtractExpressionRule__Group_1__1__Impl )
            // InternalBaseLanguage.g:2028:2: rule__AddOrSubtractExpressionRule__Group_1__1__Impl
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
    // InternalBaseLanguage.g:2034:1: rule__AddOrSubtractExpressionRule__Group_1__1__Impl : ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) ) ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2038:1: ( ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) ) )
            // InternalBaseLanguage.g:2039:1: ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) )
            {
            // InternalBaseLanguage.g:2039:1: ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) )
            // InternalBaseLanguage.g:2040:2: ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 )
            {
             before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperandsAssignment_1_1()); 
            // InternalBaseLanguage.g:2041:2: ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 )
            // InternalBaseLanguage.g:2041:3: rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1
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
    // InternalBaseLanguage.g:2050:1: rule__MultiplyDivideModuloExpressionRule__Group__0 : rule__MultiplyDivideModuloExpressionRule__Group__0__Impl rule__MultiplyDivideModuloExpressionRule__Group__1 ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2054:1: ( rule__MultiplyDivideModuloExpressionRule__Group__0__Impl rule__MultiplyDivideModuloExpressionRule__Group__1 )
            // InternalBaseLanguage.g:2055:2: rule__MultiplyDivideModuloExpressionRule__Group__0__Impl rule__MultiplyDivideModuloExpressionRule__Group__1
            {
            pushFollow(FOLLOW_14);
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
    // InternalBaseLanguage.g:2062:1: rule__MultiplyDivideModuloExpressionRule__Group__0__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2066:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalBaseLanguage.g:2067:1: ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalBaseLanguage.g:2067:1: ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) )
            // InternalBaseLanguage.g:2068:2: ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 )
            {
             before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getLeftOperandAssignment_0()); 
            // InternalBaseLanguage.g:2069:2: ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 )
            // InternalBaseLanguage.g:2069:3: rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0
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
    // InternalBaseLanguage.g:2077:1: rule__MultiplyDivideModuloExpressionRule__Group__1 : rule__MultiplyDivideModuloExpressionRule__Group__1__Impl ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2081:1: ( rule__MultiplyDivideModuloExpressionRule__Group__1__Impl )
            // InternalBaseLanguage.g:2082:2: rule__MultiplyDivideModuloExpressionRule__Group__1__Impl
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
    // InternalBaseLanguage.g:2088:1: rule__MultiplyDivideModuloExpressionRule__Group__1__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2092:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* ) )
            // InternalBaseLanguage.g:2093:1: ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* )
            {
            // InternalBaseLanguage.g:2093:1: ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* )
            // InternalBaseLanguage.g:2094:2: ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )*
            {
             before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getGroup_1()); 
            // InternalBaseLanguage.g:2095:2: ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>=24 && LA17_0<=26)) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalBaseLanguage.g:2095:3: rule__MultiplyDivideModuloExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_15);
            	    rule__MultiplyDivideModuloExpressionRule__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
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
    // InternalBaseLanguage.g:2104:1: rule__MultiplyDivideModuloExpressionRule__Group_1__0 : rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl rule__MultiplyDivideModuloExpressionRule__Group_1__1 ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2108:1: ( rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl rule__MultiplyDivideModuloExpressionRule__Group_1__1 )
            // InternalBaseLanguage.g:2109:2: rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl rule__MultiplyDivideModuloExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_5);
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
    // InternalBaseLanguage.g:2116:1: rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2120:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) ) )
            // InternalBaseLanguage.g:2121:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) )
            {
            // InternalBaseLanguage.g:2121:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) )
            // InternalBaseLanguage.g:2122:2: ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 )
            {
             before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperatorsAssignment_1_0()); 
            // InternalBaseLanguage.g:2123:2: ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 )
            // InternalBaseLanguage.g:2123:3: rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0
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
    // InternalBaseLanguage.g:2131:1: rule__MultiplyDivideModuloExpressionRule__Group_1__1 : rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2135:1: ( rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl )
            // InternalBaseLanguage.g:2136:2: rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl
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
    // InternalBaseLanguage.g:2142:1: rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2146:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) ) )
            // InternalBaseLanguage.g:2147:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) )
            {
            // InternalBaseLanguage.g:2147:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) )
            // InternalBaseLanguage.g:2148:2: ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 )
            {
             before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperandsAssignment_1_1()); 
            // InternalBaseLanguage.g:2149:2: ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 )
            // InternalBaseLanguage.g:2149:3: rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1
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
    // InternalBaseLanguage.g:2158:1: rule__PowerOfExpressionRule__Group__0 : rule__PowerOfExpressionRule__Group__0__Impl rule__PowerOfExpressionRule__Group__1 ;
    public final void rule__PowerOfExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2162:1: ( rule__PowerOfExpressionRule__Group__0__Impl rule__PowerOfExpressionRule__Group__1 )
            // InternalBaseLanguage.g:2163:2: rule__PowerOfExpressionRule__Group__0__Impl rule__PowerOfExpressionRule__Group__1
            {
            pushFollow(FOLLOW_16);
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
    // InternalBaseLanguage.g:2170:1: rule__PowerOfExpressionRule__Group__0__Impl : ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__PowerOfExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2174:1: ( ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalBaseLanguage.g:2175:1: ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalBaseLanguage.g:2175:1: ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) )
            // InternalBaseLanguage.g:2176:2: ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 )
            {
             before(grammarAccess.getPowerOfExpressionRuleAccess().getLeftOperandAssignment_0()); 
            // InternalBaseLanguage.g:2177:2: ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 )
            // InternalBaseLanguage.g:2177:3: rule__PowerOfExpressionRule__LeftOperandAssignment_0
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
    // InternalBaseLanguage.g:2185:1: rule__PowerOfExpressionRule__Group__1 : rule__PowerOfExpressionRule__Group__1__Impl ;
    public final void rule__PowerOfExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2189:1: ( rule__PowerOfExpressionRule__Group__1__Impl )
            // InternalBaseLanguage.g:2190:2: rule__PowerOfExpressionRule__Group__1__Impl
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
    // InternalBaseLanguage.g:2196:1: rule__PowerOfExpressionRule__Group__1__Impl : ( ( rule__PowerOfExpressionRule__Group_1__0 )? ) ;
    public final void rule__PowerOfExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2200:1: ( ( ( rule__PowerOfExpressionRule__Group_1__0 )? ) )
            // InternalBaseLanguage.g:2201:1: ( ( rule__PowerOfExpressionRule__Group_1__0 )? )
            {
            // InternalBaseLanguage.g:2201:1: ( ( rule__PowerOfExpressionRule__Group_1__0 )? )
            // InternalBaseLanguage.g:2202:2: ( rule__PowerOfExpressionRule__Group_1__0 )?
            {
             before(grammarAccess.getPowerOfExpressionRuleAccess().getGroup_1()); 
            // InternalBaseLanguage.g:2203:2: ( rule__PowerOfExpressionRule__Group_1__0 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==50) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalBaseLanguage.g:2203:3: rule__PowerOfExpressionRule__Group_1__0
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
    // InternalBaseLanguage.g:2212:1: rule__PowerOfExpressionRule__Group_1__0 : rule__PowerOfExpressionRule__Group_1__0__Impl rule__PowerOfExpressionRule__Group_1__1 ;
    public final void rule__PowerOfExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2216:1: ( rule__PowerOfExpressionRule__Group_1__0__Impl rule__PowerOfExpressionRule__Group_1__1 )
            // InternalBaseLanguage.g:2217:2: rule__PowerOfExpressionRule__Group_1__0__Impl rule__PowerOfExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_5);
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
    // InternalBaseLanguage.g:2224:1: rule__PowerOfExpressionRule__Group_1__0__Impl : ( '^' ) ;
    public final void rule__PowerOfExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2228:1: ( ( '^' ) )
            // InternalBaseLanguage.g:2229:1: ( '^' )
            {
            // InternalBaseLanguage.g:2229:1: ( '^' )
            // InternalBaseLanguage.g:2230:2: '^'
            {
             before(grammarAccess.getPowerOfExpressionRuleAccess().getCircumflexAccentKeyword_1_0()); 
            match(input,50,FOLLOW_2); 
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
    // InternalBaseLanguage.g:2239:1: rule__PowerOfExpressionRule__Group_1__1 : rule__PowerOfExpressionRule__Group_1__1__Impl ;
    public final void rule__PowerOfExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2243:1: ( rule__PowerOfExpressionRule__Group_1__1__Impl )
            // InternalBaseLanguage.g:2244:2: rule__PowerOfExpressionRule__Group_1__1__Impl
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
    // InternalBaseLanguage.g:2250:1: rule__PowerOfExpressionRule__Group_1__1__Impl : ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) ) ;
    public final void rule__PowerOfExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2254:1: ( ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) ) )
            // InternalBaseLanguage.g:2255:1: ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) )
            {
            // InternalBaseLanguage.g:2255:1: ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) )
            // InternalBaseLanguage.g:2256:2: ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 )
            {
             before(grammarAccess.getPowerOfExpressionRuleAccess().getRightOperandAssignment_1_1()); 
            // InternalBaseLanguage.g:2257:2: ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 )
            // InternalBaseLanguage.g:2257:3: rule__PowerOfExpressionRule__RightOperandAssignment_1_1
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
    // InternalBaseLanguage.g:2266:1: rule__UnaryAddOrSubtractExpressionRule__Group__0 : rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl rule__UnaryAddOrSubtractExpressionRule__Group__1 ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2270:1: ( rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl rule__UnaryAddOrSubtractExpressionRule__Group__1 )
            // InternalBaseLanguage.g:2271:2: rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl rule__UnaryAddOrSubtractExpressionRule__Group__1
            {
            pushFollow(FOLLOW_5);
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
    // InternalBaseLanguage.g:2278:1: rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl : ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2282:1: ( ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* ) )
            // InternalBaseLanguage.g:2283:1: ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* )
            {
            // InternalBaseLanguage.g:2283:1: ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* )
            // InternalBaseLanguage.g:2284:2: ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )*
            {
             before(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getOperatorsAssignment_0()); 
            // InternalBaseLanguage.g:2285:2: ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>=22 && LA19_0<=23)) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalBaseLanguage.g:2285:3: rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0
            	    {
            	    pushFollow(FOLLOW_13);
            	    rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
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
    // InternalBaseLanguage.g:2293:1: rule__UnaryAddOrSubtractExpressionRule__Group__1 : rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2297:1: ( rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl )
            // InternalBaseLanguage.g:2298:2: rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl
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
    // InternalBaseLanguage.g:2304:1: rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl : ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2308:1: ( ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) ) )
            // InternalBaseLanguage.g:2309:1: ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) )
            {
            // InternalBaseLanguage.g:2309:1: ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) )
            // InternalBaseLanguage.g:2310:2: ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 )
            {
             before(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getSubExpressionAssignment_1()); 
            // InternalBaseLanguage.g:2311:2: ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 )
            // InternalBaseLanguage.g:2311:3: rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1
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
    // InternalBaseLanguage.g:2320:1: rule__ParanthesesRule__Group__0 : rule__ParanthesesRule__Group__0__Impl rule__ParanthesesRule__Group__1 ;
    public final void rule__ParanthesesRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2324:1: ( rule__ParanthesesRule__Group__0__Impl rule__ParanthesesRule__Group__1 )
            // InternalBaseLanguage.g:2325:2: rule__ParanthesesRule__Group__0__Impl rule__ParanthesesRule__Group__1
            {
            pushFollow(FOLLOW_5);
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
    // InternalBaseLanguage.g:2332:1: rule__ParanthesesRule__Group__0__Impl : ( '(' ) ;
    public final void rule__ParanthesesRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2336:1: ( ( '(' ) )
            // InternalBaseLanguage.g:2337:1: ( '(' )
            {
            // InternalBaseLanguage.g:2337:1: ( '(' )
            // InternalBaseLanguage.g:2338:2: '('
            {
             before(grammarAccess.getParanthesesRuleAccess().getLeftParenthesisKeyword_0()); 
            match(input,51,FOLLOW_2); 
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
    // InternalBaseLanguage.g:2347:1: rule__ParanthesesRule__Group__1 : rule__ParanthesesRule__Group__1__Impl rule__ParanthesesRule__Group__2 ;
    public final void rule__ParanthesesRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2351:1: ( rule__ParanthesesRule__Group__1__Impl rule__ParanthesesRule__Group__2 )
            // InternalBaseLanguage.g:2352:2: rule__ParanthesesRule__Group__1__Impl rule__ParanthesesRule__Group__2
            {
            pushFollow(FOLLOW_17);
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
    // InternalBaseLanguage.g:2359:1: rule__ParanthesesRule__Group__1__Impl : ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) ) ;
    public final void rule__ParanthesesRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2363:1: ( ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) ) )
            // InternalBaseLanguage.g:2364:1: ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) )
            {
            // InternalBaseLanguage.g:2364:1: ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) )
            // InternalBaseLanguage.g:2365:2: ( rule__ParanthesesRule__SubExpressionAssignment_1 )
            {
             before(grammarAccess.getParanthesesRuleAccess().getSubExpressionAssignment_1()); 
            // InternalBaseLanguage.g:2366:2: ( rule__ParanthesesRule__SubExpressionAssignment_1 )
            // InternalBaseLanguage.g:2366:3: rule__ParanthesesRule__SubExpressionAssignment_1
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
    // InternalBaseLanguage.g:2374:1: rule__ParanthesesRule__Group__2 : rule__ParanthesesRule__Group__2__Impl ;
    public final void rule__ParanthesesRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2378:1: ( rule__ParanthesesRule__Group__2__Impl )
            // InternalBaseLanguage.g:2379:2: rule__ParanthesesRule__Group__2__Impl
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
    // InternalBaseLanguage.g:2385:1: rule__ParanthesesRule__Group__2__Impl : ( ')' ) ;
    public final void rule__ParanthesesRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2389:1: ( ( ')' ) )
            // InternalBaseLanguage.g:2390:1: ( ')' )
            {
            // InternalBaseLanguage.g:2390:1: ( ')' )
            // InternalBaseLanguage.g:2391:2: ')'
            {
             before(grammarAccess.getParanthesesRuleAccess().getRightParenthesisKeyword_2()); 
            match(input,52,FOLLOW_2); 
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
    // InternalBaseLanguage.g:2401:1: rule__CallRule__Group__0 : rule__CallRule__Group__0__Impl rule__CallRule__Group__1 ;
    public final void rule__CallRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2405:1: ( rule__CallRule__Group__0__Impl rule__CallRule__Group__1 )
            // InternalBaseLanguage.g:2406:2: rule__CallRule__Group__0__Impl rule__CallRule__Group__1
            {
            pushFollow(FOLLOW_18);
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
    // InternalBaseLanguage.g:2413:1: rule__CallRule__Group__0__Impl : ( ( rule__CallRule__FunctionAssignment_0 ) ) ;
    public final void rule__CallRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2417:1: ( ( ( rule__CallRule__FunctionAssignment_0 ) ) )
            // InternalBaseLanguage.g:2418:1: ( ( rule__CallRule__FunctionAssignment_0 ) )
            {
            // InternalBaseLanguage.g:2418:1: ( ( rule__CallRule__FunctionAssignment_0 ) )
            // InternalBaseLanguage.g:2419:2: ( rule__CallRule__FunctionAssignment_0 )
            {
             before(grammarAccess.getCallRuleAccess().getFunctionAssignment_0()); 
            // InternalBaseLanguage.g:2420:2: ( rule__CallRule__FunctionAssignment_0 )
            // InternalBaseLanguage.g:2420:3: rule__CallRule__FunctionAssignment_0
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
    // InternalBaseLanguage.g:2428:1: rule__CallRule__Group__1 : rule__CallRule__Group__1__Impl rule__CallRule__Group__2 ;
    public final void rule__CallRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2432:1: ( rule__CallRule__Group__1__Impl rule__CallRule__Group__2 )
            // InternalBaseLanguage.g:2433:2: rule__CallRule__Group__1__Impl rule__CallRule__Group__2
            {
            pushFollow(FOLLOW_19);
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
    // InternalBaseLanguage.g:2440:1: rule__CallRule__Group__1__Impl : ( '(' ) ;
    public final void rule__CallRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2444:1: ( ( '(' ) )
            // InternalBaseLanguage.g:2445:1: ( '(' )
            {
            // InternalBaseLanguage.g:2445:1: ( '(' )
            // InternalBaseLanguage.g:2446:2: '('
            {
             before(grammarAccess.getCallRuleAccess().getLeftParenthesisKeyword_1()); 
            match(input,51,FOLLOW_2); 
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
    // InternalBaseLanguage.g:2455:1: rule__CallRule__Group__2 : rule__CallRule__Group__2__Impl rule__CallRule__Group__3 ;
    public final void rule__CallRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2459:1: ( rule__CallRule__Group__2__Impl rule__CallRule__Group__3 )
            // InternalBaseLanguage.g:2460:2: rule__CallRule__Group__2__Impl rule__CallRule__Group__3
            {
            pushFollow(FOLLOW_19);
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
    // InternalBaseLanguage.g:2467:1: rule__CallRule__Group__2__Impl : ( ( rule__CallRule__Group_2__0 )? ) ;
    public final void rule__CallRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2471:1: ( ( ( rule__CallRule__Group_2__0 )? ) )
            // InternalBaseLanguage.g:2472:1: ( ( rule__CallRule__Group_2__0 )? )
            {
            // InternalBaseLanguage.g:2472:1: ( ( rule__CallRule__Group_2__0 )? )
            // InternalBaseLanguage.g:2473:2: ( rule__CallRule__Group_2__0 )?
            {
             before(grammarAccess.getCallRuleAccess().getGroup_2()); 
            // InternalBaseLanguage.g:2474:2: ( rule__CallRule__Group_2__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( ((LA20_0>=RULE_QUOTED_ID && LA20_0<=RULE_STRING)||LA20_0==15||(LA20_0>=22 && LA20_0<=23)||LA20_0==51||LA20_0==54||(LA20_0>=69 && LA20_0<=70)) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalBaseLanguage.g:2474:3: rule__CallRule__Group_2__0
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
    // InternalBaseLanguage.g:2482:1: rule__CallRule__Group__3 : rule__CallRule__Group__3__Impl ;
    public final void rule__CallRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2486:1: ( rule__CallRule__Group__3__Impl )
            // InternalBaseLanguage.g:2487:2: rule__CallRule__Group__3__Impl
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
    // InternalBaseLanguage.g:2493:1: rule__CallRule__Group__3__Impl : ( ')' ) ;
    public final void rule__CallRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2497:1: ( ( ')' ) )
            // InternalBaseLanguage.g:2498:1: ( ')' )
            {
            // InternalBaseLanguage.g:2498:1: ( ')' )
            // InternalBaseLanguage.g:2499:2: ')'
            {
             before(grammarAccess.getCallRuleAccess().getRightParenthesisKeyword_3()); 
            match(input,52,FOLLOW_2); 
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
    // InternalBaseLanguage.g:2509:1: rule__CallRule__Group_2__0 : rule__CallRule__Group_2__0__Impl rule__CallRule__Group_2__1 ;
    public final void rule__CallRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2513:1: ( rule__CallRule__Group_2__0__Impl rule__CallRule__Group_2__1 )
            // InternalBaseLanguage.g:2514:2: rule__CallRule__Group_2__0__Impl rule__CallRule__Group_2__1
            {
            pushFollow(FOLLOW_20);
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
    // InternalBaseLanguage.g:2521:1: rule__CallRule__Group_2__0__Impl : ( ( rule__CallRule__ParametersAssignment_2_0 ) ) ;
    public final void rule__CallRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2525:1: ( ( ( rule__CallRule__ParametersAssignment_2_0 ) ) )
            // InternalBaseLanguage.g:2526:1: ( ( rule__CallRule__ParametersAssignment_2_0 ) )
            {
            // InternalBaseLanguage.g:2526:1: ( ( rule__CallRule__ParametersAssignment_2_0 ) )
            // InternalBaseLanguage.g:2527:2: ( rule__CallRule__ParametersAssignment_2_0 )
            {
             before(grammarAccess.getCallRuleAccess().getParametersAssignment_2_0()); 
            // InternalBaseLanguage.g:2528:2: ( rule__CallRule__ParametersAssignment_2_0 )
            // InternalBaseLanguage.g:2528:3: rule__CallRule__ParametersAssignment_2_0
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
    // InternalBaseLanguage.g:2536:1: rule__CallRule__Group_2__1 : rule__CallRule__Group_2__1__Impl ;
    public final void rule__CallRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2540:1: ( rule__CallRule__Group_2__1__Impl )
            // InternalBaseLanguage.g:2541:2: rule__CallRule__Group_2__1__Impl
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
    // InternalBaseLanguage.g:2547:1: rule__CallRule__Group_2__1__Impl : ( ( rule__CallRule__Group_2_1__0 )* ) ;
    public final void rule__CallRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2551:1: ( ( ( rule__CallRule__Group_2_1__0 )* ) )
            // InternalBaseLanguage.g:2552:1: ( ( rule__CallRule__Group_2_1__0 )* )
            {
            // InternalBaseLanguage.g:2552:1: ( ( rule__CallRule__Group_2_1__0 )* )
            // InternalBaseLanguage.g:2553:2: ( rule__CallRule__Group_2_1__0 )*
            {
             before(grammarAccess.getCallRuleAccess().getGroup_2_1()); 
            // InternalBaseLanguage.g:2554:2: ( rule__CallRule__Group_2_1__0 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==53) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalBaseLanguage.g:2554:3: rule__CallRule__Group_2_1__0
            	    {
            	    pushFollow(FOLLOW_21);
            	    rule__CallRule__Group_2_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
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
    // InternalBaseLanguage.g:2563:1: rule__CallRule__Group_2_1__0 : rule__CallRule__Group_2_1__0__Impl rule__CallRule__Group_2_1__1 ;
    public final void rule__CallRule__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2567:1: ( rule__CallRule__Group_2_1__0__Impl rule__CallRule__Group_2_1__1 )
            // InternalBaseLanguage.g:2568:2: rule__CallRule__Group_2_1__0__Impl rule__CallRule__Group_2_1__1
            {
            pushFollow(FOLLOW_5);
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
    // InternalBaseLanguage.g:2575:1: rule__CallRule__Group_2_1__0__Impl : ( ',' ) ;
    public final void rule__CallRule__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2579:1: ( ( ',' ) )
            // InternalBaseLanguage.g:2580:1: ( ',' )
            {
            // InternalBaseLanguage.g:2580:1: ( ',' )
            // InternalBaseLanguage.g:2581:2: ','
            {
             before(grammarAccess.getCallRuleAccess().getCommaKeyword_2_1_0()); 
            match(input,53,FOLLOW_2); 
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
    // InternalBaseLanguage.g:2590:1: rule__CallRule__Group_2_1__1 : rule__CallRule__Group_2_1__1__Impl ;
    public final void rule__CallRule__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2594:1: ( rule__CallRule__Group_2_1__1__Impl )
            // InternalBaseLanguage.g:2595:2: rule__CallRule__Group_2_1__1__Impl
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
    // InternalBaseLanguage.g:2601:1: rule__CallRule__Group_2_1__1__Impl : ( ( rule__CallRule__ParametersAssignment_2_1_1 ) ) ;
    public final void rule__CallRule__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2605:1: ( ( ( rule__CallRule__ParametersAssignment_2_1_1 ) ) )
            // InternalBaseLanguage.g:2606:1: ( ( rule__CallRule__ParametersAssignment_2_1_1 ) )
            {
            // InternalBaseLanguage.g:2606:1: ( ( rule__CallRule__ParametersAssignment_2_1_1 ) )
            // InternalBaseLanguage.g:2607:2: ( rule__CallRule__ParametersAssignment_2_1_1 )
            {
             before(grammarAccess.getCallRuleAccess().getParametersAssignment_2_1_1()); 
            // InternalBaseLanguage.g:2608:2: ( rule__CallRule__ParametersAssignment_2_1_1 )
            // InternalBaseLanguage.g:2608:3: rule__CallRule__ParametersAssignment_2_1_1
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
    // InternalBaseLanguage.g:2617:1: rule__ValueReferenceRule__Group__0 : rule__ValueReferenceRule__Group__0__Impl rule__ValueReferenceRule__Group__1 ;
    public final void rule__ValueReferenceRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2621:1: ( rule__ValueReferenceRule__Group__0__Impl rule__ValueReferenceRule__Group__1 )
            // InternalBaseLanguage.g:2622:2: rule__ValueReferenceRule__Group__0__Impl rule__ValueReferenceRule__Group__1
            {
            pushFollow(FOLLOW_5);
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
    // InternalBaseLanguage.g:2629:1: rule__ValueReferenceRule__Group__0__Impl : ( () ) ;
    public final void rule__ValueReferenceRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2633:1: ( ( () ) )
            // InternalBaseLanguage.g:2634:1: ( () )
            {
            // InternalBaseLanguage.g:2634:1: ( () )
            // InternalBaseLanguage.g:2635:2: ()
            {
             before(grammarAccess.getValueReferenceRuleAccess().getValueReferenceAction_0()); 
            // InternalBaseLanguage.g:2636:2: ()
            // InternalBaseLanguage.g:2636:3: 
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
    // InternalBaseLanguage.g:2644:1: rule__ValueReferenceRule__Group__1 : rule__ValueReferenceRule__Group__1__Impl ;
    public final void rule__ValueReferenceRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2648:1: ( rule__ValueReferenceRule__Group__1__Impl )
            // InternalBaseLanguage.g:2649:2: rule__ValueReferenceRule__Group__1__Impl
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
    // InternalBaseLanguage.g:2655:1: rule__ValueReferenceRule__Group__1__Impl : ( 'value' ) ;
    public final void rule__ValueReferenceRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2659:1: ( ( 'value' ) )
            // InternalBaseLanguage.g:2660:1: ( 'value' )
            {
            // InternalBaseLanguage.g:2660:1: ( 'value' )
            // InternalBaseLanguage.g:2661:2: 'value'
            {
             before(grammarAccess.getValueReferenceRuleAccess().getValueKeyword_1()); 
            match(input,54,FOLLOW_2); 
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
    // InternalBaseLanguage.g:2671:1: rule__DoubleLiteralRule__Group__0 : rule__DoubleLiteralRule__Group__0__Impl rule__DoubleLiteralRule__Group__1 ;
    public final void rule__DoubleLiteralRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2675:1: ( rule__DoubleLiteralRule__Group__0__Impl rule__DoubleLiteralRule__Group__1 )
            // InternalBaseLanguage.g:2676:2: rule__DoubleLiteralRule__Group__0__Impl rule__DoubleLiteralRule__Group__1
            {
            pushFollow(FOLLOW_22);
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
    // InternalBaseLanguage.g:2683:1: rule__DoubleLiteralRule__Group__0__Impl : ( ( rule__DoubleLiteralRule__LiteralAssignment_0 ) ) ;
    public final void rule__DoubleLiteralRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2687:1: ( ( ( rule__DoubleLiteralRule__LiteralAssignment_0 ) ) )
            // InternalBaseLanguage.g:2688:1: ( ( rule__DoubleLiteralRule__LiteralAssignment_0 ) )
            {
            // InternalBaseLanguage.g:2688:1: ( ( rule__DoubleLiteralRule__LiteralAssignment_0 ) )
            // InternalBaseLanguage.g:2689:2: ( rule__DoubleLiteralRule__LiteralAssignment_0 )
            {
             before(grammarAccess.getDoubleLiteralRuleAccess().getLiteralAssignment_0()); 
            // InternalBaseLanguage.g:2690:2: ( rule__DoubleLiteralRule__LiteralAssignment_0 )
            // InternalBaseLanguage.g:2690:3: rule__DoubleLiteralRule__LiteralAssignment_0
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
    // InternalBaseLanguage.g:2698:1: rule__DoubleLiteralRule__Group__1 : rule__DoubleLiteralRule__Group__1__Impl ;
    public final void rule__DoubleLiteralRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2702:1: ( rule__DoubleLiteralRule__Group__1__Impl )
            // InternalBaseLanguage.g:2703:2: rule__DoubleLiteralRule__Group__1__Impl
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
    // InternalBaseLanguage.g:2709:1: rule__DoubleLiteralRule__Group__1__Impl : ( ( rule__DoubleLiteralRule__FactorAssignment_1 )? ) ;
    public final void rule__DoubleLiteralRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2713:1: ( ( ( rule__DoubleLiteralRule__FactorAssignment_1 )? ) )
            // InternalBaseLanguage.g:2714:1: ( ( rule__DoubleLiteralRule__FactorAssignment_1 )? )
            {
            // InternalBaseLanguage.g:2714:1: ( ( rule__DoubleLiteralRule__FactorAssignment_1 )? )
            // InternalBaseLanguage.g:2715:2: ( rule__DoubleLiteralRule__FactorAssignment_1 )?
            {
             before(grammarAccess.getDoubleLiteralRuleAccess().getFactorAssignment_1()); 
            // InternalBaseLanguage.g:2716:2: ( rule__DoubleLiteralRule__FactorAssignment_1 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( ((LA22_0>=27 && LA22_0<=46)) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalBaseLanguage.g:2716:3: rule__DoubleLiteralRule__FactorAssignment_1
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
    // InternalBaseLanguage.g:2725:1: rule__IntegerLiteralRule__Group__0 : rule__IntegerLiteralRule__Group__0__Impl rule__IntegerLiteralRule__Group__1 ;
    public final void rule__IntegerLiteralRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2729:1: ( rule__IntegerLiteralRule__Group__0__Impl rule__IntegerLiteralRule__Group__1 )
            // InternalBaseLanguage.g:2730:2: rule__IntegerLiteralRule__Group__0__Impl rule__IntegerLiteralRule__Group__1
            {
            pushFollow(FOLLOW_22);
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
    // InternalBaseLanguage.g:2737:1: rule__IntegerLiteralRule__Group__0__Impl : ( ( rule__IntegerLiteralRule__LiteralAssignment_0 ) ) ;
    public final void rule__IntegerLiteralRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2741:1: ( ( ( rule__IntegerLiteralRule__LiteralAssignment_0 ) ) )
            // InternalBaseLanguage.g:2742:1: ( ( rule__IntegerLiteralRule__LiteralAssignment_0 ) )
            {
            // InternalBaseLanguage.g:2742:1: ( ( rule__IntegerLiteralRule__LiteralAssignment_0 ) )
            // InternalBaseLanguage.g:2743:2: ( rule__IntegerLiteralRule__LiteralAssignment_0 )
            {
             before(grammarAccess.getIntegerLiteralRuleAccess().getLiteralAssignment_0()); 
            // InternalBaseLanguage.g:2744:2: ( rule__IntegerLiteralRule__LiteralAssignment_0 )
            // InternalBaseLanguage.g:2744:3: rule__IntegerLiteralRule__LiteralAssignment_0
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
    // InternalBaseLanguage.g:2752:1: rule__IntegerLiteralRule__Group__1 : rule__IntegerLiteralRule__Group__1__Impl ;
    public final void rule__IntegerLiteralRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2756:1: ( rule__IntegerLiteralRule__Group__1__Impl )
            // InternalBaseLanguage.g:2757:2: rule__IntegerLiteralRule__Group__1__Impl
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
    // InternalBaseLanguage.g:2763:1: rule__IntegerLiteralRule__Group__1__Impl : ( ( rule__IntegerLiteralRule__FactorAssignment_1 )? ) ;
    public final void rule__IntegerLiteralRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2767:1: ( ( ( rule__IntegerLiteralRule__FactorAssignment_1 )? ) )
            // InternalBaseLanguage.g:2768:1: ( ( rule__IntegerLiteralRule__FactorAssignment_1 )? )
            {
            // InternalBaseLanguage.g:2768:1: ( ( rule__IntegerLiteralRule__FactorAssignment_1 )? )
            // InternalBaseLanguage.g:2769:2: ( rule__IntegerLiteralRule__FactorAssignment_1 )?
            {
             before(grammarAccess.getIntegerLiteralRuleAccess().getFactorAssignment_1()); 
            // InternalBaseLanguage.g:2770:2: ( rule__IntegerLiteralRule__FactorAssignment_1 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( ((LA23_0>=27 && LA23_0<=46)) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalBaseLanguage.g:2770:3: rule__IntegerLiteralRule__FactorAssignment_1
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
    // InternalBaseLanguage.g:2779:1: rule__BooleanLiteralRule__Group__0 : rule__BooleanLiteralRule__Group__0__Impl rule__BooleanLiteralRule__Group__1 ;
    public final void rule__BooleanLiteralRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2783:1: ( rule__BooleanLiteralRule__Group__0__Impl rule__BooleanLiteralRule__Group__1 )
            // InternalBaseLanguage.g:2784:2: rule__BooleanLiteralRule__Group__0__Impl rule__BooleanLiteralRule__Group__1
            {
            pushFollow(FOLLOW_23);
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
    // InternalBaseLanguage.g:2791:1: rule__BooleanLiteralRule__Group__0__Impl : ( () ) ;
    public final void rule__BooleanLiteralRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2795:1: ( ( () ) )
            // InternalBaseLanguage.g:2796:1: ( () )
            {
            // InternalBaseLanguage.g:2796:1: ( () )
            // InternalBaseLanguage.g:2797:2: ()
            {
             before(grammarAccess.getBooleanLiteralRuleAccess().getBooleanLiteralAction_0()); 
            // InternalBaseLanguage.g:2798:2: ()
            // InternalBaseLanguage.g:2798:3: 
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
    // InternalBaseLanguage.g:2806:1: rule__BooleanLiteralRule__Group__1 : rule__BooleanLiteralRule__Group__1__Impl ;
    public final void rule__BooleanLiteralRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2810:1: ( rule__BooleanLiteralRule__Group__1__Impl )
            // InternalBaseLanguage.g:2811:2: rule__BooleanLiteralRule__Group__1__Impl
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
    // InternalBaseLanguage.g:2817:1: rule__BooleanLiteralRule__Group__1__Impl : ( ( rule__BooleanLiteralRule__Alternatives_1 ) ) ;
    public final void rule__BooleanLiteralRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2821:1: ( ( ( rule__BooleanLiteralRule__Alternatives_1 ) ) )
            // InternalBaseLanguage.g:2822:1: ( ( rule__BooleanLiteralRule__Alternatives_1 ) )
            {
            // InternalBaseLanguage.g:2822:1: ( ( rule__BooleanLiteralRule__Alternatives_1 ) )
            // InternalBaseLanguage.g:2823:2: ( rule__BooleanLiteralRule__Alternatives_1 )
            {
             before(grammarAccess.getBooleanLiteralRuleAccess().getAlternatives_1()); 
            // InternalBaseLanguage.g:2824:2: ( rule__BooleanLiteralRule__Alternatives_1 )
            // InternalBaseLanguage.g:2824:3: rule__BooleanLiteralRule__Alternatives_1
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


    // $ANTLR start "rule__AttributeDefinitionRule__Group__0"
    // InternalBaseLanguage.g:2833:1: rule__AttributeDefinitionRule__Group__0 : rule__AttributeDefinitionRule__Group__0__Impl rule__AttributeDefinitionRule__Group__1 ;
    public final void rule__AttributeDefinitionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2837:1: ( rule__AttributeDefinitionRule__Group__0__Impl rule__AttributeDefinitionRule__Group__1 )
            // InternalBaseLanguage.g:2838:2: rule__AttributeDefinitionRule__Group__0__Impl rule__AttributeDefinitionRule__Group__1
            {
            pushFollow(FOLLOW_24);
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
    // InternalBaseLanguage.g:2845:1: rule__AttributeDefinitionRule__Group__0__Impl : ( ( rule__AttributeDefinitionRule__NameAssignment_0 ) ) ;
    public final void rule__AttributeDefinitionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2849:1: ( ( ( rule__AttributeDefinitionRule__NameAssignment_0 ) ) )
            // InternalBaseLanguage.g:2850:1: ( ( rule__AttributeDefinitionRule__NameAssignment_0 ) )
            {
            // InternalBaseLanguage.g:2850:1: ( ( rule__AttributeDefinitionRule__NameAssignment_0 ) )
            // InternalBaseLanguage.g:2851:2: ( rule__AttributeDefinitionRule__NameAssignment_0 )
            {
             before(grammarAccess.getAttributeDefinitionRuleAccess().getNameAssignment_0()); 
            // InternalBaseLanguage.g:2852:2: ( rule__AttributeDefinitionRule__NameAssignment_0 )
            // InternalBaseLanguage.g:2852:3: rule__AttributeDefinitionRule__NameAssignment_0
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
    // InternalBaseLanguage.g:2860:1: rule__AttributeDefinitionRule__Group__1 : rule__AttributeDefinitionRule__Group__1__Impl rule__AttributeDefinitionRule__Group__2 ;
    public final void rule__AttributeDefinitionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2864:1: ( rule__AttributeDefinitionRule__Group__1__Impl rule__AttributeDefinitionRule__Group__2 )
            // InternalBaseLanguage.g:2865:2: rule__AttributeDefinitionRule__Group__1__Impl rule__AttributeDefinitionRule__Group__2
            {
            pushFollow(FOLLOW_25);
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
    // InternalBaseLanguage.g:2872:1: rule__AttributeDefinitionRule__Group__1__Impl : ( ':' ) ;
    public final void rule__AttributeDefinitionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2876:1: ( ( ':' ) )
            // InternalBaseLanguage.g:2877:1: ( ':' )
            {
            // InternalBaseLanguage.g:2877:1: ( ':' )
            // InternalBaseLanguage.g:2878:2: ':'
            {
             before(grammarAccess.getAttributeDefinitionRuleAccess().getColonKeyword_1()); 
            match(input,55,FOLLOW_2); 
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
    // InternalBaseLanguage.g:2887:1: rule__AttributeDefinitionRule__Group__2 : rule__AttributeDefinitionRule__Group__2__Impl rule__AttributeDefinitionRule__Group__3 ;
    public final void rule__AttributeDefinitionRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2891:1: ( rule__AttributeDefinitionRule__Group__2__Impl rule__AttributeDefinitionRule__Group__3 )
            // InternalBaseLanguage.g:2892:2: rule__AttributeDefinitionRule__Group__2__Impl rule__AttributeDefinitionRule__Group__3
            {
            pushFollow(FOLLOW_26);
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
    // InternalBaseLanguage.g:2899:1: rule__AttributeDefinitionRule__Group__2__Impl : ( ( rule__AttributeDefinitionRule__TypeAssignment_2 ) ) ;
    public final void rule__AttributeDefinitionRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2903:1: ( ( ( rule__AttributeDefinitionRule__TypeAssignment_2 ) ) )
            // InternalBaseLanguage.g:2904:1: ( ( rule__AttributeDefinitionRule__TypeAssignment_2 ) )
            {
            // InternalBaseLanguage.g:2904:1: ( ( rule__AttributeDefinitionRule__TypeAssignment_2 ) )
            // InternalBaseLanguage.g:2905:2: ( rule__AttributeDefinitionRule__TypeAssignment_2 )
            {
             before(grammarAccess.getAttributeDefinitionRuleAccess().getTypeAssignment_2()); 
            // InternalBaseLanguage.g:2906:2: ( rule__AttributeDefinitionRule__TypeAssignment_2 )
            // InternalBaseLanguage.g:2906:3: rule__AttributeDefinitionRule__TypeAssignment_2
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
    // InternalBaseLanguage.g:2914:1: rule__AttributeDefinitionRule__Group__3 : rule__AttributeDefinitionRule__Group__3__Impl ;
    public final void rule__AttributeDefinitionRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2918:1: ( rule__AttributeDefinitionRule__Group__3__Impl )
            // InternalBaseLanguage.g:2919:2: rule__AttributeDefinitionRule__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AttributeDefinitionRule__Group__3__Impl();

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
    // InternalBaseLanguage.g:2925:1: rule__AttributeDefinitionRule__Group__3__Impl : ( ';' ) ;
    public final void rule__AttributeDefinitionRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2929:1: ( ( ';' ) )
            // InternalBaseLanguage.g:2930:1: ( ';' )
            {
            // InternalBaseLanguage.g:2930:1: ( ';' )
            // InternalBaseLanguage.g:2931:2: ';'
            {
             before(grammarAccess.getAttributeDefinitionRuleAccess().getSemicolonKeyword_3()); 
            match(input,56,FOLLOW_2); 
             after(grammarAccess.getAttributeDefinitionRuleAccess().getSemicolonKeyword_3()); 

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


    // $ANTLR start "rule__LiteralTypeRule__Group__0"
    // InternalBaseLanguage.g:2941:1: rule__LiteralTypeRule__Group__0 : rule__LiteralTypeRule__Group__0__Impl rule__LiteralTypeRule__Group__1 ;
    public final void rule__LiteralTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2945:1: ( rule__LiteralTypeRule__Group__0__Impl rule__LiteralTypeRule__Group__1 )
            // InternalBaseLanguage.g:2946:2: rule__LiteralTypeRule__Group__0__Impl rule__LiteralTypeRule__Group__1
            {
            pushFollow(FOLLOW_27);
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
    // InternalBaseLanguage.g:2953:1: rule__LiteralTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__LiteralTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2957:1: ( ( () ) )
            // InternalBaseLanguage.g:2958:1: ( () )
            {
            // InternalBaseLanguage.g:2958:1: ( () )
            // InternalBaseLanguage.g:2959:2: ()
            {
             before(grammarAccess.getLiteralTypeRuleAccess().getLiteralTypeAction_0()); 
            // InternalBaseLanguage.g:2960:2: ()
            // InternalBaseLanguage.g:2960:3: 
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
    // InternalBaseLanguage.g:2968:1: rule__LiteralTypeRule__Group__1 : rule__LiteralTypeRule__Group__1__Impl ;
    public final void rule__LiteralTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2972:1: ( rule__LiteralTypeRule__Group__1__Impl )
            // InternalBaseLanguage.g:2973:2: rule__LiteralTypeRule__Group__1__Impl
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
    // InternalBaseLanguage.g:2979:1: rule__LiteralTypeRule__Group__1__Impl : ( 'literal' ) ;
    public final void rule__LiteralTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2983:1: ( ( 'literal' ) )
            // InternalBaseLanguage.g:2984:1: ( 'literal' )
            {
            // InternalBaseLanguage.g:2984:1: ( 'literal' )
            // InternalBaseLanguage.g:2985:2: 'literal'
            {
             before(grammarAccess.getLiteralTypeRuleAccess().getLiteralKeyword_1()); 
            match(input,57,FOLLOW_2); 
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
    // InternalBaseLanguage.g:2995:1: rule__InstanceTypeRule__Group__0 : rule__InstanceTypeRule__Group__0__Impl rule__InstanceTypeRule__Group__1 ;
    public final void rule__InstanceTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:2999:1: ( rule__InstanceTypeRule__Group__0__Impl rule__InstanceTypeRule__Group__1 )
            // InternalBaseLanguage.g:3000:2: rule__InstanceTypeRule__Group__0__Impl rule__InstanceTypeRule__Group__1
            {
            pushFollow(FOLLOW_28);
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
    // InternalBaseLanguage.g:3007:1: rule__InstanceTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__InstanceTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3011:1: ( ( () ) )
            // InternalBaseLanguage.g:3012:1: ( () )
            {
            // InternalBaseLanguage.g:3012:1: ( () )
            // InternalBaseLanguage.g:3013:2: ()
            {
             before(grammarAccess.getInstanceTypeRuleAccess().getInstanceTypeAction_0()); 
            // InternalBaseLanguage.g:3014:2: ()
            // InternalBaseLanguage.g:3014:3: 
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
    // InternalBaseLanguage.g:3022:1: rule__InstanceTypeRule__Group__1 : rule__InstanceTypeRule__Group__1__Impl rule__InstanceTypeRule__Group__2 ;
    public final void rule__InstanceTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3026:1: ( rule__InstanceTypeRule__Group__1__Impl rule__InstanceTypeRule__Group__2 )
            // InternalBaseLanguage.g:3027:2: rule__InstanceTypeRule__Group__1__Impl rule__InstanceTypeRule__Group__2
            {
            pushFollow(FOLLOW_29);
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
    // InternalBaseLanguage.g:3034:1: rule__InstanceTypeRule__Group__1__Impl : ( 'instance' ) ;
    public final void rule__InstanceTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3038:1: ( ( 'instance' ) )
            // InternalBaseLanguage.g:3039:1: ( 'instance' )
            {
            // InternalBaseLanguage.g:3039:1: ( 'instance' )
            // InternalBaseLanguage.g:3040:2: 'instance'
            {
             before(grammarAccess.getInstanceTypeRuleAccess().getInstanceKeyword_1()); 
            match(input,58,FOLLOW_2); 
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
    // InternalBaseLanguage.g:3049:1: rule__InstanceTypeRule__Group__2 : rule__InstanceTypeRule__Group__2__Impl rule__InstanceTypeRule__Group__3 ;
    public final void rule__InstanceTypeRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3053:1: ( rule__InstanceTypeRule__Group__2__Impl rule__InstanceTypeRule__Group__3 )
            // InternalBaseLanguage.g:3054:2: rule__InstanceTypeRule__Group__2__Impl rule__InstanceTypeRule__Group__3
            {
            pushFollow(FOLLOW_30);
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
    // InternalBaseLanguage.g:3061:1: rule__InstanceTypeRule__Group__2__Impl : ( ( rule__InstanceTypeRule__DefinitionsAssignment_2 ) ) ;
    public final void rule__InstanceTypeRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3065:1: ( ( ( rule__InstanceTypeRule__DefinitionsAssignment_2 ) ) )
            // InternalBaseLanguage.g:3066:1: ( ( rule__InstanceTypeRule__DefinitionsAssignment_2 ) )
            {
            // InternalBaseLanguage.g:3066:1: ( ( rule__InstanceTypeRule__DefinitionsAssignment_2 ) )
            // InternalBaseLanguage.g:3067:2: ( rule__InstanceTypeRule__DefinitionsAssignment_2 )
            {
             before(grammarAccess.getInstanceTypeRuleAccess().getDefinitionsAssignment_2()); 
            // InternalBaseLanguage.g:3068:2: ( rule__InstanceTypeRule__DefinitionsAssignment_2 )
            // InternalBaseLanguage.g:3068:3: rule__InstanceTypeRule__DefinitionsAssignment_2
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
    // InternalBaseLanguage.g:3076:1: rule__InstanceTypeRule__Group__3 : rule__InstanceTypeRule__Group__3__Impl ;
    public final void rule__InstanceTypeRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3080:1: ( rule__InstanceTypeRule__Group__3__Impl )
            // InternalBaseLanguage.g:3081:2: rule__InstanceTypeRule__Group__3__Impl
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
    // InternalBaseLanguage.g:3087:1: rule__InstanceTypeRule__Group__3__Impl : ( ( rule__InstanceTypeRule__Group_3__0 )* ) ;
    public final void rule__InstanceTypeRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3091:1: ( ( ( rule__InstanceTypeRule__Group_3__0 )* ) )
            // InternalBaseLanguage.g:3092:1: ( ( rule__InstanceTypeRule__Group_3__0 )* )
            {
            // InternalBaseLanguage.g:3092:1: ( ( rule__InstanceTypeRule__Group_3__0 )* )
            // InternalBaseLanguage.g:3093:2: ( rule__InstanceTypeRule__Group_3__0 )*
            {
             before(grammarAccess.getInstanceTypeRuleAccess().getGroup_3()); 
            // InternalBaseLanguage.g:3094:2: ( rule__InstanceTypeRule__Group_3__0 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==59) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalBaseLanguage.g:3094:3: rule__InstanceTypeRule__Group_3__0
            	    {
            	    pushFollow(FOLLOW_31);
            	    rule__InstanceTypeRule__Group_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop24;
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
    // InternalBaseLanguage.g:3103:1: rule__InstanceTypeRule__Group_3__0 : rule__InstanceTypeRule__Group_3__0__Impl rule__InstanceTypeRule__Group_3__1 ;
    public final void rule__InstanceTypeRule__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3107:1: ( rule__InstanceTypeRule__Group_3__0__Impl rule__InstanceTypeRule__Group_3__1 )
            // InternalBaseLanguage.g:3108:2: rule__InstanceTypeRule__Group_3__0__Impl rule__InstanceTypeRule__Group_3__1
            {
            pushFollow(FOLLOW_29);
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
    // InternalBaseLanguage.g:3115:1: rule__InstanceTypeRule__Group_3__0__Impl : ( '|' ) ;
    public final void rule__InstanceTypeRule__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3119:1: ( ( '|' ) )
            // InternalBaseLanguage.g:3120:1: ( '|' )
            {
            // InternalBaseLanguage.g:3120:1: ( '|' )
            // InternalBaseLanguage.g:3121:2: '|'
            {
             before(grammarAccess.getInstanceTypeRuleAccess().getVerticalLineKeyword_3_0()); 
            match(input,59,FOLLOW_2); 
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
    // InternalBaseLanguage.g:3130:1: rule__InstanceTypeRule__Group_3__1 : rule__InstanceTypeRule__Group_3__1__Impl ;
    public final void rule__InstanceTypeRule__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3134:1: ( rule__InstanceTypeRule__Group_3__1__Impl )
            // InternalBaseLanguage.g:3135:2: rule__InstanceTypeRule__Group_3__1__Impl
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
    // InternalBaseLanguage.g:3141:1: rule__InstanceTypeRule__Group_3__1__Impl : ( ( rule__InstanceTypeRule__DefinitionsAssignment_3_1 ) ) ;
    public final void rule__InstanceTypeRule__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3145:1: ( ( ( rule__InstanceTypeRule__DefinitionsAssignment_3_1 ) ) )
            // InternalBaseLanguage.g:3146:1: ( ( rule__InstanceTypeRule__DefinitionsAssignment_3_1 ) )
            {
            // InternalBaseLanguage.g:3146:1: ( ( rule__InstanceTypeRule__DefinitionsAssignment_3_1 ) )
            // InternalBaseLanguage.g:3147:2: ( rule__InstanceTypeRule__DefinitionsAssignment_3_1 )
            {
             before(grammarAccess.getInstanceTypeRuleAccess().getDefinitionsAssignment_3_1()); 
            // InternalBaseLanguage.g:3148:2: ( rule__InstanceTypeRule__DefinitionsAssignment_3_1 )
            // InternalBaseLanguage.g:3148:3: rule__InstanceTypeRule__DefinitionsAssignment_3_1
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
    // InternalBaseLanguage.g:3157:1: rule__StringTypeRule__Group__0 : rule__StringTypeRule__Group__0__Impl rule__StringTypeRule__Group__1 ;
    public final void rule__StringTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3161:1: ( rule__StringTypeRule__Group__0__Impl rule__StringTypeRule__Group__1 )
            // InternalBaseLanguage.g:3162:2: rule__StringTypeRule__Group__0__Impl rule__StringTypeRule__Group__1
            {
            pushFollow(FOLLOW_32);
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
    // InternalBaseLanguage.g:3169:1: rule__StringTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__StringTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3173:1: ( ( () ) )
            // InternalBaseLanguage.g:3174:1: ( () )
            {
            // InternalBaseLanguage.g:3174:1: ( () )
            // InternalBaseLanguage.g:3175:2: ()
            {
             before(grammarAccess.getStringTypeRuleAccess().getStringTypeAction_0()); 
            // InternalBaseLanguage.g:3176:2: ()
            // InternalBaseLanguage.g:3176:3: 
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
    // InternalBaseLanguage.g:3184:1: rule__StringTypeRule__Group__1 : rule__StringTypeRule__Group__1__Impl ;
    public final void rule__StringTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3188:1: ( rule__StringTypeRule__Group__1__Impl )
            // InternalBaseLanguage.g:3189:2: rule__StringTypeRule__Group__1__Impl
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
    // InternalBaseLanguage.g:3195:1: rule__StringTypeRule__Group__1__Impl : ( 'string' ) ;
    public final void rule__StringTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3199:1: ( ( 'string' ) )
            // InternalBaseLanguage.g:3200:1: ( 'string' )
            {
            // InternalBaseLanguage.g:3200:1: ( 'string' )
            // InternalBaseLanguage.g:3201:2: 'string'
            {
             before(grammarAccess.getStringTypeRuleAccess().getStringKeyword_1()); 
            match(input,60,FOLLOW_2); 
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
    // InternalBaseLanguage.g:3211:1: rule__ExpressionTypeRule__Group__0 : rule__ExpressionTypeRule__Group__0__Impl rule__ExpressionTypeRule__Group__1 ;
    public final void rule__ExpressionTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3215:1: ( rule__ExpressionTypeRule__Group__0__Impl rule__ExpressionTypeRule__Group__1 )
            // InternalBaseLanguage.g:3216:2: rule__ExpressionTypeRule__Group__0__Impl rule__ExpressionTypeRule__Group__1
            {
            pushFollow(FOLLOW_33);
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
    // InternalBaseLanguage.g:3223:1: rule__ExpressionTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__ExpressionTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3227:1: ( ( () ) )
            // InternalBaseLanguage.g:3228:1: ( () )
            {
            // InternalBaseLanguage.g:3228:1: ( () )
            // InternalBaseLanguage.g:3229:2: ()
            {
             before(grammarAccess.getExpressionTypeRuleAccess().getExpressionTypeAction_0()); 
            // InternalBaseLanguage.g:3230:2: ()
            // InternalBaseLanguage.g:3230:3: 
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
    // InternalBaseLanguage.g:3238:1: rule__ExpressionTypeRule__Group__1 : rule__ExpressionTypeRule__Group__1__Impl ;
    public final void rule__ExpressionTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3242:1: ( rule__ExpressionTypeRule__Group__1__Impl )
            // InternalBaseLanguage.g:3243:2: rule__ExpressionTypeRule__Group__1__Impl
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
    // InternalBaseLanguage.g:3249:1: rule__ExpressionTypeRule__Group__1__Impl : ( 'expression' ) ;
    public final void rule__ExpressionTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3253:1: ( ( 'expression' ) )
            // InternalBaseLanguage.g:3254:1: ( 'expression' )
            {
            // InternalBaseLanguage.g:3254:1: ( 'expression' )
            // InternalBaseLanguage.g:3255:2: 'expression'
            {
             before(grammarAccess.getExpressionTypeRuleAccess().getExpressionKeyword_1()); 
            match(input,61,FOLLOW_2); 
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
    // InternalBaseLanguage.g:3265:1: rule__IntTypeRule__Group__0 : rule__IntTypeRule__Group__0__Impl rule__IntTypeRule__Group__1 ;
    public final void rule__IntTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3269:1: ( rule__IntTypeRule__Group__0__Impl rule__IntTypeRule__Group__1 )
            // InternalBaseLanguage.g:3270:2: rule__IntTypeRule__Group__0__Impl rule__IntTypeRule__Group__1
            {
            pushFollow(FOLLOW_34);
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
    // InternalBaseLanguage.g:3277:1: rule__IntTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__IntTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3281:1: ( ( () ) )
            // InternalBaseLanguage.g:3282:1: ( () )
            {
            // InternalBaseLanguage.g:3282:1: ( () )
            // InternalBaseLanguage.g:3283:2: ()
            {
             before(grammarAccess.getIntTypeRuleAccess().getIntTypeAction_0()); 
            // InternalBaseLanguage.g:3284:2: ()
            // InternalBaseLanguage.g:3284:3: 
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
    // InternalBaseLanguage.g:3292:1: rule__IntTypeRule__Group__1 : rule__IntTypeRule__Group__1__Impl ;
    public final void rule__IntTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3296:1: ( rule__IntTypeRule__Group__1__Impl )
            // InternalBaseLanguage.g:3297:2: rule__IntTypeRule__Group__1__Impl
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
    // InternalBaseLanguage.g:3303:1: rule__IntTypeRule__Group__1__Impl : ( 'int' ) ;
    public final void rule__IntTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3307:1: ( ( 'int' ) )
            // InternalBaseLanguage.g:3308:1: ( 'int' )
            {
            // InternalBaseLanguage.g:3308:1: ( 'int' )
            // InternalBaseLanguage.g:3309:2: 'int'
            {
             before(grammarAccess.getIntTypeRuleAccess().getIntKeyword_1()); 
            match(input,62,FOLLOW_2); 
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
    // InternalBaseLanguage.g:3319:1: rule__FloatTypeRule__Group__0 : rule__FloatTypeRule__Group__0__Impl rule__FloatTypeRule__Group__1 ;
    public final void rule__FloatTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3323:1: ( rule__FloatTypeRule__Group__0__Impl rule__FloatTypeRule__Group__1 )
            // InternalBaseLanguage.g:3324:2: rule__FloatTypeRule__Group__0__Impl rule__FloatTypeRule__Group__1
            {
            pushFollow(FOLLOW_35);
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
    // InternalBaseLanguage.g:3331:1: rule__FloatTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__FloatTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3335:1: ( ( () ) )
            // InternalBaseLanguage.g:3336:1: ( () )
            {
            // InternalBaseLanguage.g:3336:1: ( () )
            // InternalBaseLanguage.g:3337:2: ()
            {
             before(grammarAccess.getFloatTypeRuleAccess().getFloatTypeAction_0()); 
            // InternalBaseLanguage.g:3338:2: ()
            // InternalBaseLanguage.g:3338:3: 
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
    // InternalBaseLanguage.g:3346:1: rule__FloatTypeRule__Group__1 : rule__FloatTypeRule__Group__1__Impl ;
    public final void rule__FloatTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3350:1: ( rule__FloatTypeRule__Group__1__Impl )
            // InternalBaseLanguage.g:3351:2: rule__FloatTypeRule__Group__1__Impl
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
    // InternalBaseLanguage.g:3357:1: rule__FloatTypeRule__Group__1__Impl : ( 'float' ) ;
    public final void rule__FloatTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3361:1: ( ( 'float' ) )
            // InternalBaseLanguage.g:3362:1: ( 'float' )
            {
            // InternalBaseLanguage.g:3362:1: ( 'float' )
            // InternalBaseLanguage.g:3363:2: 'float'
            {
             before(grammarAccess.getFloatTypeRuleAccess().getFloatKeyword_1()); 
            match(input,63,FOLLOW_2); 
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
    // InternalBaseLanguage.g:3373:1: rule__BooleanTypeRule__Group__0 : rule__BooleanTypeRule__Group__0__Impl rule__BooleanTypeRule__Group__1 ;
    public final void rule__BooleanTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3377:1: ( rule__BooleanTypeRule__Group__0__Impl rule__BooleanTypeRule__Group__1 )
            // InternalBaseLanguage.g:3378:2: rule__BooleanTypeRule__Group__0__Impl rule__BooleanTypeRule__Group__1
            {
            pushFollow(FOLLOW_36);
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
    // InternalBaseLanguage.g:3385:1: rule__BooleanTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__BooleanTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3389:1: ( ( () ) )
            // InternalBaseLanguage.g:3390:1: ( () )
            {
            // InternalBaseLanguage.g:3390:1: ( () )
            // InternalBaseLanguage.g:3391:2: ()
            {
             before(grammarAccess.getBooleanTypeRuleAccess().getBooleanTypeAction_0()); 
            // InternalBaseLanguage.g:3392:2: ()
            // InternalBaseLanguage.g:3392:3: 
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
    // InternalBaseLanguage.g:3400:1: rule__BooleanTypeRule__Group__1 : rule__BooleanTypeRule__Group__1__Impl ;
    public final void rule__BooleanTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3404:1: ( rule__BooleanTypeRule__Group__1__Impl )
            // InternalBaseLanguage.g:3405:2: rule__BooleanTypeRule__Group__1__Impl
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
    // InternalBaseLanguage.g:3411:1: rule__BooleanTypeRule__Group__1__Impl : ( 'boolean' ) ;
    public final void rule__BooleanTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3415:1: ( ( 'boolean' ) )
            // InternalBaseLanguage.g:3416:1: ( 'boolean' )
            {
            // InternalBaseLanguage.g:3416:1: ( 'boolean' )
            // InternalBaseLanguage.g:3417:2: 'boolean'
            {
             before(grammarAccess.getBooleanTypeRuleAccess().getBooleanKeyword_1()); 
            match(input,64,FOLLOW_2); 
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
    // InternalBaseLanguage.g:3427:1: rule__VoidTypeRule__Group__0 : rule__VoidTypeRule__Group__0__Impl rule__VoidTypeRule__Group__1 ;
    public final void rule__VoidTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3431:1: ( rule__VoidTypeRule__Group__0__Impl rule__VoidTypeRule__Group__1 )
            // InternalBaseLanguage.g:3432:2: rule__VoidTypeRule__Group__0__Impl rule__VoidTypeRule__Group__1
            {
            pushFollow(FOLLOW_37);
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
    // InternalBaseLanguage.g:3439:1: rule__VoidTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__VoidTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3443:1: ( ( () ) )
            // InternalBaseLanguage.g:3444:1: ( () )
            {
            // InternalBaseLanguage.g:3444:1: ( () )
            // InternalBaseLanguage.g:3445:2: ()
            {
             before(grammarAccess.getVoidTypeRuleAccess().getVoidTypeAction_0()); 
            // InternalBaseLanguage.g:3446:2: ()
            // InternalBaseLanguage.g:3446:3: 
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
    // InternalBaseLanguage.g:3454:1: rule__VoidTypeRule__Group__1 : rule__VoidTypeRule__Group__1__Impl ;
    public final void rule__VoidTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3458:1: ( rule__VoidTypeRule__Group__1__Impl )
            // InternalBaseLanguage.g:3459:2: rule__VoidTypeRule__Group__1__Impl
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
    // InternalBaseLanguage.g:3465:1: rule__VoidTypeRule__Group__1__Impl : ( 'void' ) ;
    public final void rule__VoidTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3469:1: ( ( 'void' ) )
            // InternalBaseLanguage.g:3470:1: ( 'void' )
            {
            // InternalBaseLanguage.g:3470:1: ( 'void' )
            // InternalBaseLanguage.g:3471:2: 'void'
            {
             before(grammarAccess.getVoidTypeRuleAccess().getVoidKeyword_1()); 
            match(input,65,FOLLOW_2); 
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
    // InternalBaseLanguage.g:3481:1: rule__DataTypeRule__Group__0 : rule__DataTypeRule__Group__0__Impl rule__DataTypeRule__Group__1 ;
    public final void rule__DataTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3485:1: ( rule__DataTypeRule__Group__0__Impl rule__DataTypeRule__Group__1 )
            // InternalBaseLanguage.g:3486:2: rule__DataTypeRule__Group__0__Impl rule__DataTypeRule__Group__1
            {
            pushFollow(FOLLOW_25);
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
    // InternalBaseLanguage.g:3493:1: rule__DataTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__DataTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3497:1: ( ( () ) )
            // InternalBaseLanguage.g:3498:1: ( () )
            {
            // InternalBaseLanguage.g:3498:1: ( () )
            // InternalBaseLanguage.g:3499:2: ()
            {
             before(grammarAccess.getDataTypeRuleAccess().getDataTypeAction_0()); 
            // InternalBaseLanguage.g:3500:2: ()
            // InternalBaseLanguage.g:3500:3: 
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
    // InternalBaseLanguage.g:3508:1: rule__DataTypeRule__Group__1 : rule__DataTypeRule__Group__1__Impl ;
    public final void rule__DataTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3512:1: ( rule__DataTypeRule__Group__1__Impl )
            // InternalBaseLanguage.g:3513:2: rule__DataTypeRule__Group__1__Impl
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
    // InternalBaseLanguage.g:3519:1: rule__DataTypeRule__Group__1__Impl : ( 'data' ) ;
    public final void rule__DataTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3523:1: ( ( 'data' ) )
            // InternalBaseLanguage.g:3524:1: ( 'data' )
            {
            // InternalBaseLanguage.g:3524:1: ( 'data' )
            // InternalBaseLanguage.g:3525:2: 'data'
            {
             before(grammarAccess.getDataTypeRuleAccess().getDataKeyword_1()); 
            match(input,66,FOLLOW_2); 
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
    // InternalBaseLanguage.g:3535:1: rule__ArrayTypeRule__Group__0 : rule__ArrayTypeRule__Group__0__Impl rule__ArrayTypeRule__Group__1 ;
    public final void rule__ArrayTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3539:1: ( rule__ArrayTypeRule__Group__0__Impl rule__ArrayTypeRule__Group__1 )
            // InternalBaseLanguage.g:3540:2: rule__ArrayTypeRule__Group__0__Impl rule__ArrayTypeRule__Group__1
            {
            pushFollow(FOLLOW_25);
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
    // InternalBaseLanguage.g:3547:1: rule__ArrayTypeRule__Group__0__Impl : ( 'array' ) ;
    public final void rule__ArrayTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3551:1: ( ( 'array' ) )
            // InternalBaseLanguage.g:3552:1: ( 'array' )
            {
            // InternalBaseLanguage.g:3552:1: ( 'array' )
            // InternalBaseLanguage.g:3553:2: 'array'
            {
             before(grammarAccess.getArrayTypeRuleAccess().getArrayKeyword_0()); 
            match(input,67,FOLLOW_2); 
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
    // InternalBaseLanguage.g:3562:1: rule__ArrayTypeRule__Group__1 : rule__ArrayTypeRule__Group__1__Impl ;
    public final void rule__ArrayTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3566:1: ( rule__ArrayTypeRule__Group__1__Impl )
            // InternalBaseLanguage.g:3567:2: rule__ArrayTypeRule__Group__1__Impl
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
    // InternalBaseLanguage.g:3573:1: rule__ArrayTypeRule__Group__1__Impl : ( ( rule__ArrayTypeRule__ElementsAssignment_1 ) ) ;
    public final void rule__ArrayTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3577:1: ( ( ( rule__ArrayTypeRule__ElementsAssignment_1 ) ) )
            // InternalBaseLanguage.g:3578:1: ( ( rule__ArrayTypeRule__ElementsAssignment_1 ) )
            {
            // InternalBaseLanguage.g:3578:1: ( ( rule__ArrayTypeRule__ElementsAssignment_1 ) )
            // InternalBaseLanguage.g:3579:2: ( rule__ArrayTypeRule__ElementsAssignment_1 )
            {
             before(grammarAccess.getArrayTypeRuleAccess().getElementsAssignment_1()); 
            // InternalBaseLanguage.g:3580:2: ( rule__ArrayTypeRule__ElementsAssignment_1 )
            // InternalBaseLanguage.g:3580:3: rule__ArrayTypeRule__ElementsAssignment_1
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


    // $ANTLR start "rule__ParameterRule__Group__0"
    // InternalBaseLanguage.g:3589:1: rule__ParameterRule__Group__0 : rule__ParameterRule__Group__0__Impl rule__ParameterRule__Group__1 ;
    public final void rule__ParameterRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3593:1: ( rule__ParameterRule__Group__0__Impl rule__ParameterRule__Group__1 )
            // InternalBaseLanguage.g:3594:2: rule__ParameterRule__Group__0__Impl rule__ParameterRule__Group__1
            {
            pushFollow(FOLLOW_29);
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
    // InternalBaseLanguage.g:3601:1: rule__ParameterRule__Group__0__Impl : ( ( rule__ParameterRule__TypeAssignment_0 ) ) ;
    public final void rule__ParameterRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3605:1: ( ( ( rule__ParameterRule__TypeAssignment_0 ) ) )
            // InternalBaseLanguage.g:3606:1: ( ( rule__ParameterRule__TypeAssignment_0 ) )
            {
            // InternalBaseLanguage.g:3606:1: ( ( rule__ParameterRule__TypeAssignment_0 ) )
            // InternalBaseLanguage.g:3607:2: ( rule__ParameterRule__TypeAssignment_0 )
            {
             before(grammarAccess.getParameterRuleAccess().getTypeAssignment_0()); 
            // InternalBaseLanguage.g:3608:2: ( rule__ParameterRule__TypeAssignment_0 )
            // InternalBaseLanguage.g:3608:3: rule__ParameterRule__TypeAssignment_0
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
    // InternalBaseLanguage.g:3616:1: rule__ParameterRule__Group__1 : rule__ParameterRule__Group__1__Impl ;
    public final void rule__ParameterRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3620:1: ( rule__ParameterRule__Group__1__Impl )
            // InternalBaseLanguage.g:3621:2: rule__ParameterRule__Group__1__Impl
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
    // InternalBaseLanguage.g:3627:1: rule__ParameterRule__Group__1__Impl : ( ( rule__ParameterRule__NameAssignment_1 ) ) ;
    public final void rule__ParameterRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3631:1: ( ( ( rule__ParameterRule__NameAssignment_1 ) ) )
            // InternalBaseLanguage.g:3632:1: ( ( rule__ParameterRule__NameAssignment_1 ) )
            {
            // InternalBaseLanguage.g:3632:1: ( ( rule__ParameterRule__NameAssignment_1 ) )
            // InternalBaseLanguage.g:3633:2: ( rule__ParameterRule__NameAssignment_1 )
            {
             before(grammarAccess.getParameterRuleAccess().getNameAssignment_1()); 
            // InternalBaseLanguage.g:3634:2: ( rule__ParameterRule__NameAssignment_1 )
            // InternalBaseLanguage.g:3634:3: rule__ParameterRule__NameAssignment_1
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
    // InternalBaseLanguage.g:3643:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3647:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // InternalBaseLanguage.g:3648:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_38);
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
    // InternalBaseLanguage.g:3655:1: rule__QualifiedName__Group__0__Impl : ( ruleStringOrId ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3659:1: ( ( ruleStringOrId ) )
            // InternalBaseLanguage.g:3660:1: ( ruleStringOrId )
            {
            // InternalBaseLanguage.g:3660:1: ( ruleStringOrId )
            // InternalBaseLanguage.g:3661:2: ruleStringOrId
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
    // InternalBaseLanguage.g:3670:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3674:1: ( rule__QualifiedName__Group__1__Impl )
            // InternalBaseLanguage.g:3675:2: rule__QualifiedName__Group__1__Impl
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
    // InternalBaseLanguage.g:3681:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3685:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // InternalBaseLanguage.g:3686:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // InternalBaseLanguage.g:3686:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // InternalBaseLanguage.g:3687:2: ( rule__QualifiedName__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // InternalBaseLanguage.g:3688:2: ( rule__QualifiedName__Group_1__0 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==68) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalBaseLanguage.g:3688:3: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_39);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop25;
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
    // InternalBaseLanguage.g:3697:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3701:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // InternalBaseLanguage.g:3702:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
            {
            pushFollow(FOLLOW_29);
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
    // InternalBaseLanguage.g:3709:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3713:1: ( ( '.' ) )
            // InternalBaseLanguage.g:3714:1: ( '.' )
            {
            // InternalBaseLanguage.g:3714:1: ( '.' )
            // InternalBaseLanguage.g:3715:2: '.'
            {
             before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            match(input,68,FOLLOW_2); 
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
    // InternalBaseLanguage.g:3724:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3728:1: ( rule__QualifiedName__Group_1__1__Impl )
            // InternalBaseLanguage.g:3729:2: rule__QualifiedName__Group_1__1__Impl
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
    // InternalBaseLanguage.g:3735:1: rule__QualifiedName__Group_1__1__Impl : ( ruleStringOrId ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3739:1: ( ( ruleStringOrId ) )
            // InternalBaseLanguage.g:3740:1: ( ruleStringOrId )
            {
            // InternalBaseLanguage.g:3740:1: ( ruleStringOrId )
            // InternalBaseLanguage.g:3741:2: ruleStringOrId
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


    // $ANTLR start "rule__OrExpressionRule__SubExpressionsAssignment_0"
    // InternalBaseLanguage.g:3751:1: rule__OrExpressionRule__SubExpressionsAssignment_0 : ( ruleXorExpressionRule ) ;
    public final void rule__OrExpressionRule__SubExpressionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3755:1: ( ( ruleXorExpressionRule ) )
            // InternalBaseLanguage.g:3756:2: ( ruleXorExpressionRule )
            {
            // InternalBaseLanguage.g:3756:2: ( ruleXorExpressionRule )
            // InternalBaseLanguage.g:3757:3: ruleXorExpressionRule
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
    // InternalBaseLanguage.g:3766:1: rule__OrExpressionRule__SubExpressionsAssignment_1_1 : ( ruleXorExpressionRule ) ;
    public final void rule__OrExpressionRule__SubExpressionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3770:1: ( ( ruleXorExpressionRule ) )
            // InternalBaseLanguage.g:3771:2: ( ruleXorExpressionRule )
            {
            // InternalBaseLanguage.g:3771:2: ( ruleXorExpressionRule )
            // InternalBaseLanguage.g:3772:3: ruleXorExpressionRule
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
    // InternalBaseLanguage.g:3781:1: rule__XorExpressionRule__SubExpressionsAssignment_0 : ( ruleAndExpressionRule ) ;
    public final void rule__XorExpressionRule__SubExpressionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3785:1: ( ( ruleAndExpressionRule ) )
            // InternalBaseLanguage.g:3786:2: ( ruleAndExpressionRule )
            {
            // InternalBaseLanguage.g:3786:2: ( ruleAndExpressionRule )
            // InternalBaseLanguage.g:3787:3: ruleAndExpressionRule
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
    // InternalBaseLanguage.g:3796:1: rule__XorExpressionRule__SubExpressionsAssignment_1_1 : ( ruleAndExpressionRule ) ;
    public final void rule__XorExpressionRule__SubExpressionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3800:1: ( ( ruleAndExpressionRule ) )
            // InternalBaseLanguage.g:3801:2: ( ruleAndExpressionRule )
            {
            // InternalBaseLanguage.g:3801:2: ( ruleAndExpressionRule )
            // InternalBaseLanguage.g:3802:3: ruleAndExpressionRule
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
    // InternalBaseLanguage.g:3811:1: rule__AndExpressionRule__SubExpressionsAssignment_0 : ( ruleNotExpressionRule ) ;
    public final void rule__AndExpressionRule__SubExpressionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3815:1: ( ( ruleNotExpressionRule ) )
            // InternalBaseLanguage.g:3816:2: ( ruleNotExpressionRule )
            {
            // InternalBaseLanguage.g:3816:2: ( ruleNotExpressionRule )
            // InternalBaseLanguage.g:3817:3: ruleNotExpressionRule
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
    // InternalBaseLanguage.g:3826:1: rule__AndExpressionRule__SubExpressionsAssignment_1_1 : ( ruleNotExpressionRule ) ;
    public final void rule__AndExpressionRule__SubExpressionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3830:1: ( ( ruleNotExpressionRule ) )
            // InternalBaseLanguage.g:3831:2: ( ruleNotExpressionRule )
            {
            // InternalBaseLanguage.g:3831:2: ( ruleNotExpressionRule )
            // InternalBaseLanguage.g:3832:3: ruleNotExpressionRule
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
    // InternalBaseLanguage.g:3841:1: rule__NotExpressionRule__NegatedAssignment_0 : ( ( '!' ) ) ;
    public final void rule__NotExpressionRule__NegatedAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3845:1: ( ( ( '!' ) ) )
            // InternalBaseLanguage.g:3846:2: ( ( '!' ) )
            {
            // InternalBaseLanguage.g:3846:2: ( ( '!' ) )
            // InternalBaseLanguage.g:3847:3: ( '!' )
            {
             before(grammarAccess.getNotExpressionRuleAccess().getNegatedExclamationMarkKeyword_0_0()); 
            // InternalBaseLanguage.g:3848:3: ( '!' )
            // InternalBaseLanguage.g:3849:4: '!'
            {
             before(grammarAccess.getNotExpressionRuleAccess().getNegatedExclamationMarkKeyword_0_0()); 
            match(input,69,FOLLOW_2); 
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
    // InternalBaseLanguage.g:3860:1: rule__NotExpressionRule__OperandAssignment_1 : ( ruleComparisonExpressionRule ) ;
    public final void rule__NotExpressionRule__OperandAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3864:1: ( ( ruleComparisonExpressionRule ) )
            // InternalBaseLanguage.g:3865:2: ( ruleComparisonExpressionRule )
            {
            // InternalBaseLanguage.g:3865:2: ( ruleComparisonExpressionRule )
            // InternalBaseLanguage.g:3866:3: ruleComparisonExpressionRule
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
    // InternalBaseLanguage.g:3875:1: rule__ComparisonExpressionRule__LeftOperandAssignment_0 : ( ruleAddOrSubtractExpressionRule ) ;
    public final void rule__ComparisonExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3879:1: ( ( ruleAddOrSubtractExpressionRule ) )
            // InternalBaseLanguage.g:3880:2: ( ruleAddOrSubtractExpressionRule )
            {
            // InternalBaseLanguage.g:3880:2: ( ruleAddOrSubtractExpressionRule )
            // InternalBaseLanguage.g:3881:3: ruleAddOrSubtractExpressionRule
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
    // InternalBaseLanguage.g:3890:1: rule__ComparisonExpressionRule__ComparisonAssignment_1 : ( rulePartialComparisonExpressionRule ) ;
    public final void rule__ComparisonExpressionRule__ComparisonAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3894:1: ( ( rulePartialComparisonExpressionRule ) )
            // InternalBaseLanguage.g:3895:2: ( rulePartialComparisonExpressionRule )
            {
            // InternalBaseLanguage.g:3895:2: ( rulePartialComparisonExpressionRule )
            // InternalBaseLanguage.g:3896:3: rulePartialComparisonExpressionRule
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
    // InternalBaseLanguage.g:3905:1: rule__PartialComparisonExpressionRule__OperatorAssignment_0 : ( ruleComparisonOperatorRule ) ;
    public final void rule__PartialComparisonExpressionRule__OperatorAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3909:1: ( ( ruleComparisonOperatorRule ) )
            // InternalBaseLanguage.g:3910:2: ( ruleComparisonOperatorRule )
            {
            // InternalBaseLanguage.g:3910:2: ( ruleComparisonOperatorRule )
            // InternalBaseLanguage.g:3911:3: ruleComparisonOperatorRule
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
    // InternalBaseLanguage.g:3920:1: rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 : ( ruleAddOrSubtractExpressionRule ) ;
    public final void rule__PartialComparisonExpressionRule__SubExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3924:1: ( ( ruleAddOrSubtractExpressionRule ) )
            // InternalBaseLanguage.g:3925:2: ( ruleAddOrSubtractExpressionRule )
            {
            // InternalBaseLanguage.g:3925:2: ( ruleAddOrSubtractExpressionRule )
            // InternalBaseLanguage.g:3926:3: ruleAddOrSubtractExpressionRule
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
    // InternalBaseLanguage.g:3935:1: rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 : ( ruleMultiplyDivideModuloExpressionRule ) ;
    public final void rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3939:1: ( ( ruleMultiplyDivideModuloExpressionRule ) )
            // InternalBaseLanguage.g:3940:2: ( ruleMultiplyDivideModuloExpressionRule )
            {
            // InternalBaseLanguage.g:3940:2: ( ruleMultiplyDivideModuloExpressionRule )
            // InternalBaseLanguage.g:3941:3: ruleMultiplyDivideModuloExpressionRule
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
    // InternalBaseLanguage.g:3950:1: rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 : ( ruleAddOrSubtractOperatorRule ) ;
    public final void rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3954:1: ( ( ruleAddOrSubtractOperatorRule ) )
            // InternalBaseLanguage.g:3955:2: ( ruleAddOrSubtractOperatorRule )
            {
            // InternalBaseLanguage.g:3955:2: ( ruleAddOrSubtractOperatorRule )
            // InternalBaseLanguage.g:3956:3: ruleAddOrSubtractOperatorRule
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
    // InternalBaseLanguage.g:3965:1: rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 : ( ruleMultiplyDivideModuloExpressionRule ) ;
    public final void rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3969:1: ( ( ruleMultiplyDivideModuloExpressionRule ) )
            // InternalBaseLanguage.g:3970:2: ( ruleMultiplyDivideModuloExpressionRule )
            {
            // InternalBaseLanguage.g:3970:2: ( ruleMultiplyDivideModuloExpressionRule )
            // InternalBaseLanguage.g:3971:3: ruleMultiplyDivideModuloExpressionRule
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
    // InternalBaseLanguage.g:3980:1: rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 : ( rulePowerOfExpressionRule ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3984:1: ( ( rulePowerOfExpressionRule ) )
            // InternalBaseLanguage.g:3985:2: ( rulePowerOfExpressionRule )
            {
            // InternalBaseLanguage.g:3985:2: ( rulePowerOfExpressionRule )
            // InternalBaseLanguage.g:3986:3: rulePowerOfExpressionRule
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
    // InternalBaseLanguage.g:3995:1: rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 : ( ruleMultiplyDivideModuloOperatorRule ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:3999:1: ( ( ruleMultiplyDivideModuloOperatorRule ) )
            // InternalBaseLanguage.g:4000:2: ( ruleMultiplyDivideModuloOperatorRule )
            {
            // InternalBaseLanguage.g:4000:2: ( ruleMultiplyDivideModuloOperatorRule )
            // InternalBaseLanguage.g:4001:3: ruleMultiplyDivideModuloOperatorRule
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
    // InternalBaseLanguage.g:4010:1: rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 : ( rulePowerOfExpressionRule ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:4014:1: ( ( rulePowerOfExpressionRule ) )
            // InternalBaseLanguage.g:4015:2: ( rulePowerOfExpressionRule )
            {
            // InternalBaseLanguage.g:4015:2: ( rulePowerOfExpressionRule )
            // InternalBaseLanguage.g:4016:3: rulePowerOfExpressionRule
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
    // InternalBaseLanguage.g:4025:1: rule__PowerOfExpressionRule__LeftOperandAssignment_0 : ( ruleUnaryAddOrSubtractExpressionRule ) ;
    public final void rule__PowerOfExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:4029:1: ( ( ruleUnaryAddOrSubtractExpressionRule ) )
            // InternalBaseLanguage.g:4030:2: ( ruleUnaryAddOrSubtractExpressionRule )
            {
            // InternalBaseLanguage.g:4030:2: ( ruleUnaryAddOrSubtractExpressionRule )
            // InternalBaseLanguage.g:4031:3: ruleUnaryAddOrSubtractExpressionRule
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
    // InternalBaseLanguage.g:4040:1: rule__PowerOfExpressionRule__RightOperandAssignment_1_1 : ( rulePowerOfExpressionRule ) ;
    public final void rule__PowerOfExpressionRule__RightOperandAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:4044:1: ( ( rulePowerOfExpressionRule ) )
            // InternalBaseLanguage.g:4045:2: ( rulePowerOfExpressionRule )
            {
            // InternalBaseLanguage.g:4045:2: ( rulePowerOfExpressionRule )
            // InternalBaseLanguage.g:4046:3: rulePowerOfExpressionRule
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
    // InternalBaseLanguage.g:4055:1: rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 : ( ruleAddOrSubtractOperatorRule ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:4059:1: ( ( ruleAddOrSubtractOperatorRule ) )
            // InternalBaseLanguage.g:4060:2: ( ruleAddOrSubtractOperatorRule )
            {
            // InternalBaseLanguage.g:4060:2: ( ruleAddOrSubtractOperatorRule )
            // InternalBaseLanguage.g:4061:3: ruleAddOrSubtractOperatorRule
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
    // InternalBaseLanguage.g:4070:1: rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 : ( ruleLiteralOrReferenceRule ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:4074:1: ( ( ruleLiteralOrReferenceRule ) )
            // InternalBaseLanguage.g:4075:2: ( ruleLiteralOrReferenceRule )
            {
            // InternalBaseLanguage.g:4075:2: ( ruleLiteralOrReferenceRule )
            // InternalBaseLanguage.g:4076:3: ruleLiteralOrReferenceRule
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
    // InternalBaseLanguage.g:4085:1: rule__ParanthesesRule__SubExpressionAssignment_1 : ( ruleExpressionRule ) ;
    public final void rule__ParanthesesRule__SubExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:4089:1: ( ( ruleExpressionRule ) )
            // InternalBaseLanguage.g:4090:2: ( ruleExpressionRule )
            {
            // InternalBaseLanguage.g:4090:2: ( ruleExpressionRule )
            // InternalBaseLanguage.g:4091:3: ruleExpressionRule
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
    // InternalBaseLanguage.g:4100:1: rule__CallRule__FunctionAssignment_0 : ( ruleFunctionNameRule ) ;
    public final void rule__CallRule__FunctionAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:4104:1: ( ( ruleFunctionNameRule ) )
            // InternalBaseLanguage.g:4105:2: ( ruleFunctionNameRule )
            {
            // InternalBaseLanguage.g:4105:2: ( ruleFunctionNameRule )
            // InternalBaseLanguage.g:4106:3: ruleFunctionNameRule
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
    // InternalBaseLanguage.g:4115:1: rule__CallRule__ParametersAssignment_2_0 : ( ruleExpressionRule ) ;
    public final void rule__CallRule__ParametersAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:4119:1: ( ( ruleExpressionRule ) )
            // InternalBaseLanguage.g:4120:2: ( ruleExpressionRule )
            {
            // InternalBaseLanguage.g:4120:2: ( ruleExpressionRule )
            // InternalBaseLanguage.g:4121:3: ruleExpressionRule
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
    // InternalBaseLanguage.g:4130:1: rule__CallRule__ParametersAssignment_2_1_1 : ( ruleExpressionRule ) ;
    public final void rule__CallRule__ParametersAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:4134:1: ( ( ruleExpressionRule ) )
            // InternalBaseLanguage.g:4135:2: ( ruleExpressionRule )
            {
            // InternalBaseLanguage.g:4135:2: ( ruleExpressionRule )
            // InternalBaseLanguage.g:4136:3: ruleExpressionRule
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
    // InternalBaseLanguage.g:4145:1: rule__DoubleLiteralRule__LiteralAssignment_0 : ( RULE_DOUBLE ) ;
    public final void rule__DoubleLiteralRule__LiteralAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:4149:1: ( ( RULE_DOUBLE ) )
            // InternalBaseLanguage.g:4150:2: ( RULE_DOUBLE )
            {
            // InternalBaseLanguage.g:4150:2: ( RULE_DOUBLE )
            // InternalBaseLanguage.g:4151:3: RULE_DOUBLE
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
    // InternalBaseLanguage.g:4160:1: rule__DoubleLiteralRule__FactorAssignment_1 : ( ruleFactorRule ) ;
    public final void rule__DoubleLiteralRule__FactorAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:4164:1: ( ( ruleFactorRule ) )
            // InternalBaseLanguage.g:4165:2: ( ruleFactorRule )
            {
            // InternalBaseLanguage.g:4165:2: ( ruleFactorRule )
            // InternalBaseLanguage.g:4166:3: ruleFactorRule
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
    // InternalBaseLanguage.g:4175:1: rule__IntegerLiteralRule__LiteralAssignment_0 : ( RULE_INT ) ;
    public final void rule__IntegerLiteralRule__LiteralAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:4179:1: ( ( RULE_INT ) )
            // InternalBaseLanguage.g:4180:2: ( RULE_INT )
            {
            // InternalBaseLanguage.g:4180:2: ( RULE_INT )
            // InternalBaseLanguage.g:4181:3: RULE_INT
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
    // InternalBaseLanguage.g:4190:1: rule__IntegerLiteralRule__FactorAssignment_1 : ( ruleFactorRule ) ;
    public final void rule__IntegerLiteralRule__FactorAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:4194:1: ( ( ruleFactorRule ) )
            // InternalBaseLanguage.g:4195:2: ( ruleFactorRule )
            {
            // InternalBaseLanguage.g:4195:2: ( ruleFactorRule )
            // InternalBaseLanguage.g:4196:3: ruleFactorRule
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
    // InternalBaseLanguage.g:4205:1: rule__StringLiteralRule__ValueAssignment : ( RULE_STRING ) ;
    public final void rule__StringLiteralRule__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:4209:1: ( ( RULE_STRING ) )
            // InternalBaseLanguage.g:4210:2: ( RULE_STRING )
            {
            // InternalBaseLanguage.g:4210:2: ( RULE_STRING )
            // InternalBaseLanguage.g:4211:3: RULE_STRING
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
    // InternalBaseLanguage.g:4220:1: rule__BooleanLiteralRule__ValueAssignment_1_0 : ( ( 'true' ) ) ;
    public final void rule__BooleanLiteralRule__ValueAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:4224:1: ( ( ( 'true' ) ) )
            // InternalBaseLanguage.g:4225:2: ( ( 'true' ) )
            {
            // InternalBaseLanguage.g:4225:2: ( ( 'true' ) )
            // InternalBaseLanguage.g:4226:3: ( 'true' )
            {
             before(grammarAccess.getBooleanLiteralRuleAccess().getValueTrueKeyword_1_0_0()); 
            // InternalBaseLanguage.g:4227:3: ( 'true' )
            // InternalBaseLanguage.g:4228:4: 'true'
            {
             before(grammarAccess.getBooleanLiteralRuleAccess().getValueTrueKeyword_1_0_0()); 
            match(input,70,FOLLOW_2); 
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


    // $ANTLR start "rule__AttributeDefinitionRule__NameAssignment_0"
    // InternalBaseLanguage.g:4239:1: rule__AttributeDefinitionRule__NameAssignment_0 : ( ruleStringOrId ) ;
    public final void rule__AttributeDefinitionRule__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:4243:1: ( ( ruleStringOrId ) )
            // InternalBaseLanguage.g:4244:2: ( ruleStringOrId )
            {
            // InternalBaseLanguage.g:4244:2: ( ruleStringOrId )
            // InternalBaseLanguage.g:4245:3: ruleStringOrId
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
    // InternalBaseLanguage.g:4254:1: rule__AttributeDefinitionRule__TypeAssignment_2 : ( ruleTypeRule ) ;
    public final void rule__AttributeDefinitionRule__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:4258:1: ( ( ruleTypeRule ) )
            // InternalBaseLanguage.g:4259:2: ( ruleTypeRule )
            {
            // InternalBaseLanguage.g:4259:2: ( ruleTypeRule )
            // InternalBaseLanguage.g:4260:3: ruleTypeRule
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


    // $ANTLR start "rule__InstanceTypeRule__DefinitionsAssignment_2"
    // InternalBaseLanguage.g:4269:1: rule__InstanceTypeRule__DefinitionsAssignment_2 : ( ( ruleQualifiedName ) ) ;
    public final void rule__InstanceTypeRule__DefinitionsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:4273:1: ( ( ( ruleQualifiedName ) ) )
            // InternalBaseLanguage.g:4274:2: ( ( ruleQualifiedName ) )
            {
            // InternalBaseLanguage.g:4274:2: ( ( ruleQualifiedName ) )
            // InternalBaseLanguage.g:4275:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getInstanceTypeRuleAccess().getDefinitionsTypeDefinitionCrossReference_2_0()); 
            // InternalBaseLanguage.g:4276:3: ( ruleQualifiedName )
            // InternalBaseLanguage.g:4277:4: ruleQualifiedName
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
    // InternalBaseLanguage.g:4288:1: rule__InstanceTypeRule__DefinitionsAssignment_3_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__InstanceTypeRule__DefinitionsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:4292:1: ( ( ( ruleQualifiedName ) ) )
            // InternalBaseLanguage.g:4293:2: ( ( ruleQualifiedName ) )
            {
            // InternalBaseLanguage.g:4293:2: ( ( ruleQualifiedName ) )
            // InternalBaseLanguage.g:4294:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getInstanceTypeRuleAccess().getDefinitionsTypeDefinitionCrossReference_3_1_0()); 
            // InternalBaseLanguage.g:4295:3: ( ruleQualifiedName )
            // InternalBaseLanguage.g:4296:4: ruleQualifiedName
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
    // InternalBaseLanguage.g:4307:1: rule__ArrayTypeRule__ElementsAssignment_1 : ( ruleTypeRule ) ;
    public final void rule__ArrayTypeRule__ElementsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:4311:1: ( ( ruleTypeRule ) )
            // InternalBaseLanguage.g:4312:2: ( ruleTypeRule )
            {
            // InternalBaseLanguage.g:4312:2: ( ruleTypeRule )
            // InternalBaseLanguage.g:4313:3: ruleTypeRule
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


    // $ANTLR start "rule__ParameterRule__TypeAssignment_0"
    // InternalBaseLanguage.g:4322:1: rule__ParameterRule__TypeAssignment_0 : ( ruleTypeRule ) ;
    public final void rule__ParameterRule__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:4326:1: ( ( ruleTypeRule ) )
            // InternalBaseLanguage.g:4327:2: ( ruleTypeRule )
            {
            // InternalBaseLanguage.g:4327:2: ( ruleTypeRule )
            // InternalBaseLanguage.g:4328:3: ruleTypeRule
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
    // InternalBaseLanguage.g:4337:1: rule__ParameterRule__NameAssignment_1 : ( ruleStringOrId ) ;
    public final void rule__ParameterRule__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:4341:1: ( ( ruleStringOrId ) )
            // InternalBaseLanguage.g:4342:2: ( ruleStringOrId )
            {
            // InternalBaseLanguage.g:4342:2: ( ruleStringOrId )
            // InternalBaseLanguage.g:4343:3: ruleStringOrId
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
    // InternalBaseLanguage.g:4352:1: rule__FunctionNameRule__DefinitionAssignment : ( ( ruleQualifiedName ) ) ;
    public final void rule__FunctionNameRule__DefinitionAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBaseLanguage.g:4356:1: ( ( ( ruleQualifiedName ) ) )
            // InternalBaseLanguage.g:4357:2: ( ( ruleQualifiedName ) )
            {
            // InternalBaseLanguage.g:4357:2: ( ( ruleQualifiedName ) )
            // InternalBaseLanguage.g:4358:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getFunctionNameRuleAccess().getDefinitionFunctionDefinitionCrossReference_0()); 
            // InternalBaseLanguage.g:4359:3: ( ruleQualifiedName )
            // InternalBaseLanguage.g:4360:4: ruleQualifiedName
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
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0048000000C081F0L,0x0000000000000060L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x00000000003F0000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x00000000003F0002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000007000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000007000002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0058000000C081F0L,0x0000000000000060L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x00007FFFF8000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x00000000000081C0L,0x0000000000000040L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0xF600000000000000L,0x000000000000000FL});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000010L});

}
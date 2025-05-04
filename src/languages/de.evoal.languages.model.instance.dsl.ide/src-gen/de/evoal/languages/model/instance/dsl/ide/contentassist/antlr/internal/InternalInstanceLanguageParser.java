package de.evoal.languages.model.instance.dsl.ide.contentassist.antlr.internal;

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
import de.evoal.languages.model.instance.dsl.services.InstanceLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalInstanceLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_QUOTED_ID", "RULE_ID", "RULE_DOUBLE", "RULE_INT", "RULE_STRING", "RULE_DIGIT", "RULE_EXPONENT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'false'", "'>='", "'>'", "'='", "'!='", "'<'", "'<='", "'+'", "'-'", "'*'", "'/'", "'%'", "'Y'", "'Z'", "'E'", "'P'", "'T'", "'G'", "'M'", "'k'", "'h'", "'da'", "'d'", "'c'", "'m'", "'\\u00B5'", "'n'", "'p'", "'f'", "'a'", "'z'", "'y'", "'instances'", "'['", "']'", "';'", "'instance'", "','", "'OR'", "'XOR'", "'AND'", "'^'", "'('", "')'", "'data'", "'{'", "'}'", "':='", "'@'", "':'", "'literal'", "'string'", "'expression'", "'int'", "'real'", "'boolean'", "'void'", "'array'", "'import'", "'from'", "'.'", "'!'", "'true'"
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


        public InternalInstanceLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalInstanceLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalInstanceLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalInstanceLanguage.g"; }


    	private InstanceLanguageGrammarAccess grammarAccess;

    	public void setGrammarAccess(InstanceLanguageGrammarAccess grammarAccess) {
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



    // $ANTLR start "entryRuleInstanceModuleRule"
    // InternalInstanceLanguage.g:55:1: entryRuleInstanceModuleRule : ruleInstanceModuleRule EOF ;
    public final void entryRuleInstanceModuleRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:56:1: ( ruleInstanceModuleRule EOF )
            // InternalInstanceLanguage.g:57:1: ruleInstanceModuleRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceModuleRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleInstanceModuleRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getInstanceModuleRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleInstanceModuleRule"


    // $ANTLR start "ruleInstanceModuleRule"
    // InternalInstanceLanguage.g:64:1: ruleInstanceModuleRule : ( ( rule__InstanceModuleRule__Group__0 ) ) ;
    public final void ruleInstanceModuleRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:68:2: ( ( ( rule__InstanceModuleRule__Group__0 ) ) )
            // InternalInstanceLanguage.g:69:2: ( ( rule__InstanceModuleRule__Group__0 ) )
            {
            // InternalInstanceLanguage.g:69:2: ( ( rule__InstanceModuleRule__Group__0 ) )
            // InternalInstanceLanguage.g:70:3: ( rule__InstanceModuleRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceModuleRuleAccess().getGroup()); 
            }
            // InternalInstanceLanguage.g:71:3: ( rule__InstanceModuleRule__Group__0 )
            // InternalInstanceLanguage.g:71:4: rule__InstanceModuleRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__InstanceModuleRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getInstanceModuleRuleAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleInstanceModuleRule"


    // $ANTLR start "entryRuleExpressionRule"
    // InternalInstanceLanguage.g:80:1: entryRuleExpressionRule : ruleExpressionRule EOF ;
    public final void entryRuleExpressionRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:81:1: ( ruleExpressionRule EOF )
            // InternalInstanceLanguage.g:82:1: ruleExpressionRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleExpressionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpressionRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalInstanceLanguage.g:89:1: ruleExpressionRule : ( ruleOrExpressionRule ) ;
    public final void ruleExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:93:2: ( ( ruleOrExpressionRule ) )
            // InternalInstanceLanguage.g:94:2: ( ruleOrExpressionRule )
            {
            // InternalInstanceLanguage.g:94:2: ( ruleOrExpressionRule )
            // InternalInstanceLanguage.g:95:3: ruleOrExpressionRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionRuleAccess().getOrExpressionRuleParserRuleCall()); 
            }
            pushFollow(FOLLOW_2);
            ruleOrExpressionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpressionRuleAccess().getOrExpressionRuleParserRuleCall()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:105:1: entryRuleOrExpressionRule : ruleOrExpressionRule EOF ;
    public final void entryRuleOrExpressionRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:106:1: ( ruleOrExpressionRule EOF )
            // InternalInstanceLanguage.g:107:1: ruleOrExpressionRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleOrExpressionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOrExpressionRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalInstanceLanguage.g:114:1: ruleOrExpressionRule : ( ( rule__OrExpressionRule__Group__0 ) ) ;
    public final void ruleOrExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:118:2: ( ( ( rule__OrExpressionRule__Group__0 ) ) )
            // InternalInstanceLanguage.g:119:2: ( ( rule__OrExpressionRule__Group__0 ) )
            {
            // InternalInstanceLanguage.g:119:2: ( ( rule__OrExpressionRule__Group__0 ) )
            // InternalInstanceLanguage.g:120:3: ( rule__OrExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionRuleAccess().getGroup()); 
            }
            // InternalInstanceLanguage.g:121:3: ( rule__OrExpressionRule__Group__0 )
            // InternalInstanceLanguage.g:121:4: rule__OrExpressionRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__OrExpressionRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOrExpressionRuleAccess().getGroup()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:130:1: entryRuleXorExpressionRule : ruleXorExpressionRule EOF ;
    public final void entryRuleXorExpressionRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:131:1: ( ruleXorExpressionRule EOF )
            // InternalInstanceLanguage.g:132:1: ruleXorExpressionRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXorExpressionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleXorExpressionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXorExpressionRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalInstanceLanguage.g:139:1: ruleXorExpressionRule : ( ( rule__XorExpressionRule__Group__0 ) ) ;
    public final void ruleXorExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:143:2: ( ( ( rule__XorExpressionRule__Group__0 ) ) )
            // InternalInstanceLanguage.g:144:2: ( ( rule__XorExpressionRule__Group__0 ) )
            {
            // InternalInstanceLanguage.g:144:2: ( ( rule__XorExpressionRule__Group__0 ) )
            // InternalInstanceLanguage.g:145:3: ( rule__XorExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXorExpressionRuleAccess().getGroup()); 
            }
            // InternalInstanceLanguage.g:146:3: ( rule__XorExpressionRule__Group__0 )
            // InternalInstanceLanguage.g:146:4: rule__XorExpressionRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__XorExpressionRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXorExpressionRuleAccess().getGroup()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:155:1: entryRuleAndExpressionRule : ruleAndExpressionRule EOF ;
    public final void entryRuleAndExpressionRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:156:1: ( ruleAndExpressionRule EOF )
            // InternalInstanceLanguage.g:157:1: ruleAndExpressionRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleAndExpressionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAndExpressionRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalInstanceLanguage.g:164:1: ruleAndExpressionRule : ( ( rule__AndExpressionRule__Group__0 ) ) ;
    public final void ruleAndExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:168:2: ( ( ( rule__AndExpressionRule__Group__0 ) ) )
            // InternalInstanceLanguage.g:169:2: ( ( rule__AndExpressionRule__Group__0 ) )
            {
            // InternalInstanceLanguage.g:169:2: ( ( rule__AndExpressionRule__Group__0 ) )
            // InternalInstanceLanguage.g:170:3: ( rule__AndExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionRuleAccess().getGroup()); 
            }
            // InternalInstanceLanguage.g:171:3: ( rule__AndExpressionRule__Group__0 )
            // InternalInstanceLanguage.g:171:4: rule__AndExpressionRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__AndExpressionRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAndExpressionRuleAccess().getGroup()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:180:1: entryRuleNotExpressionRule : ruleNotExpressionRule EOF ;
    public final void entryRuleNotExpressionRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:181:1: ( ruleNotExpressionRule EOF )
            // InternalInstanceLanguage.g:182:1: ruleNotExpressionRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNotExpressionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleNotExpressionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNotExpressionRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalInstanceLanguage.g:189:1: ruleNotExpressionRule : ( ( rule__NotExpressionRule__Group__0 ) ) ;
    public final void ruleNotExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:193:2: ( ( ( rule__NotExpressionRule__Group__0 ) ) )
            // InternalInstanceLanguage.g:194:2: ( ( rule__NotExpressionRule__Group__0 ) )
            {
            // InternalInstanceLanguage.g:194:2: ( ( rule__NotExpressionRule__Group__0 ) )
            // InternalInstanceLanguage.g:195:3: ( rule__NotExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNotExpressionRuleAccess().getGroup()); 
            }
            // InternalInstanceLanguage.g:196:3: ( rule__NotExpressionRule__Group__0 )
            // InternalInstanceLanguage.g:196:4: rule__NotExpressionRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__NotExpressionRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNotExpressionRuleAccess().getGroup()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:205:1: entryRuleComparisonExpressionRule : ruleComparisonExpressionRule EOF ;
    public final void entryRuleComparisonExpressionRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:206:1: ( ruleComparisonExpressionRule EOF )
            // InternalInstanceLanguage.g:207:1: ruleComparisonExpressionRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonExpressionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleComparisonExpressionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getComparisonExpressionRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalInstanceLanguage.g:214:1: ruleComparisonExpressionRule : ( ( rule__ComparisonExpressionRule__Group__0 ) ) ;
    public final void ruleComparisonExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:218:2: ( ( ( rule__ComparisonExpressionRule__Group__0 ) ) )
            // InternalInstanceLanguage.g:219:2: ( ( rule__ComparisonExpressionRule__Group__0 ) )
            {
            // InternalInstanceLanguage.g:219:2: ( ( rule__ComparisonExpressionRule__Group__0 ) )
            // InternalInstanceLanguage.g:220:3: ( rule__ComparisonExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonExpressionRuleAccess().getGroup()); 
            }
            // InternalInstanceLanguage.g:221:3: ( rule__ComparisonExpressionRule__Group__0 )
            // InternalInstanceLanguage.g:221:4: rule__ComparisonExpressionRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ComparisonExpressionRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getComparisonExpressionRuleAccess().getGroup()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:230:1: entryRulePartialComparisonExpressionRule : rulePartialComparisonExpressionRule EOF ;
    public final void entryRulePartialComparisonExpressionRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:231:1: ( rulePartialComparisonExpressionRule EOF )
            // InternalInstanceLanguage.g:232:1: rulePartialComparisonExpressionRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartialComparisonExpressionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            rulePartialComparisonExpressionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartialComparisonExpressionRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalInstanceLanguage.g:239:1: rulePartialComparisonExpressionRule : ( ( rule__PartialComparisonExpressionRule__Group__0 ) ) ;
    public final void rulePartialComparisonExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:243:2: ( ( ( rule__PartialComparisonExpressionRule__Group__0 ) ) )
            // InternalInstanceLanguage.g:244:2: ( ( rule__PartialComparisonExpressionRule__Group__0 ) )
            {
            // InternalInstanceLanguage.g:244:2: ( ( rule__PartialComparisonExpressionRule__Group__0 ) )
            // InternalInstanceLanguage.g:245:3: ( rule__PartialComparisonExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartialComparisonExpressionRuleAccess().getGroup()); 
            }
            // InternalInstanceLanguage.g:246:3: ( rule__PartialComparisonExpressionRule__Group__0 )
            // InternalInstanceLanguage.g:246:4: rule__PartialComparisonExpressionRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PartialComparisonExpressionRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartialComparisonExpressionRuleAccess().getGroup()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:255:1: entryRuleAddOrSubtractExpressionRule : ruleAddOrSubtractExpressionRule EOF ;
    public final void entryRuleAddOrSubtractExpressionRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:256:1: ( ruleAddOrSubtractExpressionRule EOF )
            // InternalInstanceLanguage.g:257:1: ruleAddOrSubtractExpressionRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOrSubtractExpressionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleAddOrSubtractExpressionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAddOrSubtractExpressionRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalInstanceLanguage.g:264:1: ruleAddOrSubtractExpressionRule : ( ( rule__AddOrSubtractExpressionRule__Group__0 ) ) ;
    public final void ruleAddOrSubtractExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:268:2: ( ( ( rule__AddOrSubtractExpressionRule__Group__0 ) ) )
            // InternalInstanceLanguage.g:269:2: ( ( rule__AddOrSubtractExpressionRule__Group__0 ) )
            {
            // InternalInstanceLanguage.g:269:2: ( ( rule__AddOrSubtractExpressionRule__Group__0 ) )
            // InternalInstanceLanguage.g:270:3: ( rule__AddOrSubtractExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getGroup()); 
            }
            // InternalInstanceLanguage.g:271:3: ( rule__AddOrSubtractExpressionRule__Group__0 )
            // InternalInstanceLanguage.g:271:4: rule__AddOrSubtractExpressionRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__AddOrSubtractExpressionRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAddOrSubtractExpressionRuleAccess().getGroup()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:280:1: entryRuleMultiplyDivideModuloExpressionRule : ruleMultiplyDivideModuloExpressionRule EOF ;
    public final void entryRuleMultiplyDivideModuloExpressionRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:281:1: ( ruleMultiplyDivideModuloExpressionRule EOF )
            // InternalInstanceLanguage.g:282:1: ruleMultiplyDivideModuloExpressionRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplyDivideModuloExpressionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleMultiplyDivideModuloExpressionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplyDivideModuloExpressionRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalInstanceLanguage.g:289:1: ruleMultiplyDivideModuloExpressionRule : ( ( rule__MultiplyDivideModuloExpressionRule__Group__0 ) ) ;
    public final void ruleMultiplyDivideModuloExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:293:2: ( ( ( rule__MultiplyDivideModuloExpressionRule__Group__0 ) ) )
            // InternalInstanceLanguage.g:294:2: ( ( rule__MultiplyDivideModuloExpressionRule__Group__0 ) )
            {
            // InternalInstanceLanguage.g:294:2: ( ( rule__MultiplyDivideModuloExpressionRule__Group__0 ) )
            // InternalInstanceLanguage.g:295:3: ( rule__MultiplyDivideModuloExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getGroup()); 
            }
            // InternalInstanceLanguage.g:296:3: ( rule__MultiplyDivideModuloExpressionRule__Group__0 )
            // InternalInstanceLanguage.g:296:4: rule__MultiplyDivideModuloExpressionRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__MultiplyDivideModuloExpressionRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getGroup()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:305:1: entryRulePowerOfExpressionRule : rulePowerOfExpressionRule EOF ;
    public final void entryRulePowerOfExpressionRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:306:1: ( rulePowerOfExpressionRule EOF )
            // InternalInstanceLanguage.g:307:1: rulePowerOfExpressionRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPowerOfExpressionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            rulePowerOfExpressionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPowerOfExpressionRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalInstanceLanguage.g:314:1: rulePowerOfExpressionRule : ( ( rule__PowerOfExpressionRule__Group__0 ) ) ;
    public final void rulePowerOfExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:318:2: ( ( ( rule__PowerOfExpressionRule__Group__0 ) ) )
            // InternalInstanceLanguage.g:319:2: ( ( rule__PowerOfExpressionRule__Group__0 ) )
            {
            // InternalInstanceLanguage.g:319:2: ( ( rule__PowerOfExpressionRule__Group__0 ) )
            // InternalInstanceLanguage.g:320:3: ( rule__PowerOfExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPowerOfExpressionRuleAccess().getGroup()); 
            }
            // InternalInstanceLanguage.g:321:3: ( rule__PowerOfExpressionRule__Group__0 )
            // InternalInstanceLanguage.g:321:4: rule__PowerOfExpressionRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PowerOfExpressionRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPowerOfExpressionRuleAccess().getGroup()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:330:1: entryRuleUnaryAddOrSubtractExpressionRule : ruleUnaryAddOrSubtractExpressionRule EOF ;
    public final void entryRuleUnaryAddOrSubtractExpressionRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:331:1: ( ruleUnaryAddOrSubtractExpressionRule EOF )
            // InternalInstanceLanguage.g:332:1: ruleUnaryAddOrSubtractExpressionRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnaryAddOrSubtractExpressionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleUnaryAddOrSubtractExpressionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUnaryAddOrSubtractExpressionRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalInstanceLanguage.g:339:1: ruleUnaryAddOrSubtractExpressionRule : ( ( rule__UnaryAddOrSubtractExpressionRule__Group__0 ) ) ;
    public final void ruleUnaryAddOrSubtractExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:343:2: ( ( ( rule__UnaryAddOrSubtractExpressionRule__Group__0 ) ) )
            // InternalInstanceLanguage.g:344:2: ( ( rule__UnaryAddOrSubtractExpressionRule__Group__0 ) )
            {
            // InternalInstanceLanguage.g:344:2: ( ( rule__UnaryAddOrSubtractExpressionRule__Group__0 ) )
            // InternalInstanceLanguage.g:345:3: ( rule__UnaryAddOrSubtractExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getGroup()); 
            }
            // InternalInstanceLanguage.g:346:3: ( rule__UnaryAddOrSubtractExpressionRule__Group__0 )
            // InternalInstanceLanguage.g:346:4: rule__UnaryAddOrSubtractExpressionRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__UnaryAddOrSubtractExpressionRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getGroup()); 
            }

            }


            }

        }
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


    // $ANTLR start "entryRuleValueRule"
    // InternalInstanceLanguage.g:355:1: entryRuleValueRule : ruleValueRule EOF ;
    public final void entryRuleValueRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:356:1: ( ruleValueRule EOF )
            // InternalInstanceLanguage.g:357:1: ruleValueRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleValueRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleValueRule"


    // $ANTLR start "ruleValueRule"
    // InternalInstanceLanguage.g:364:1: ruleValueRule : ( ( rule__ValueRule__Alternatives ) ) ;
    public final void ruleValueRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:368:2: ( ( ( rule__ValueRule__Alternatives ) ) )
            // InternalInstanceLanguage.g:369:2: ( ( rule__ValueRule__Alternatives ) )
            {
            // InternalInstanceLanguage.g:369:2: ( ( rule__ValueRule__Alternatives ) )
            // InternalInstanceLanguage.g:370:3: ( rule__ValueRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueRuleAccess().getAlternatives()); 
            }
            // InternalInstanceLanguage.g:371:3: ( rule__ValueRule__Alternatives )
            // InternalInstanceLanguage.g:371:4: rule__ValueRule__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__ValueRule__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueRuleAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleValueRule"


    // $ANTLR start "entryRuleArrayRule"
    // InternalInstanceLanguage.g:380:1: entryRuleArrayRule : ruleArrayRule EOF ;
    public final void entryRuleArrayRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:381:1: ( ruleArrayRule EOF )
            // InternalInstanceLanguage.g:382:1: ruleArrayRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleArrayRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getArrayRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleArrayRule"


    // $ANTLR start "ruleArrayRule"
    // InternalInstanceLanguage.g:389:1: ruleArrayRule : ( ( rule__ArrayRule__Group__0 ) ) ;
    public final void ruleArrayRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:393:2: ( ( ( rule__ArrayRule__Group__0 ) ) )
            // InternalInstanceLanguage.g:394:2: ( ( rule__ArrayRule__Group__0 ) )
            {
            // InternalInstanceLanguage.g:394:2: ( ( rule__ArrayRule__Group__0 ) )
            // InternalInstanceLanguage.g:395:3: ( rule__ArrayRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayRuleAccess().getGroup()); 
            }
            // InternalInstanceLanguage.g:396:3: ( rule__ArrayRule__Group__0 )
            // InternalInstanceLanguage.g:396:4: rule__ArrayRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ArrayRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getArrayRuleAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleArrayRule"


    // $ANTLR start "entryRuleParanthesesRule"
    // InternalInstanceLanguage.g:405:1: entryRuleParanthesesRule : ruleParanthesesRule EOF ;
    public final void entryRuleParanthesesRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:406:1: ( ruleParanthesesRule EOF )
            // InternalInstanceLanguage.g:407:1: ruleParanthesesRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParanthesesRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleParanthesesRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParanthesesRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalInstanceLanguage.g:414:1: ruleParanthesesRule : ( ( rule__ParanthesesRule__Group__0 ) ) ;
    public final void ruleParanthesesRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:418:2: ( ( ( rule__ParanthesesRule__Group__0 ) ) )
            // InternalInstanceLanguage.g:419:2: ( ( rule__ParanthesesRule__Group__0 ) )
            {
            // InternalInstanceLanguage.g:419:2: ( ( rule__ParanthesesRule__Group__0 ) )
            // InternalInstanceLanguage.g:420:3: ( rule__ParanthesesRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParanthesesRuleAccess().getGroup()); 
            }
            // InternalInstanceLanguage.g:421:3: ( rule__ParanthesesRule__Group__0 )
            // InternalInstanceLanguage.g:421:4: rule__ParanthesesRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ParanthesesRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getParanthesesRuleAccess().getGroup()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:430:1: entryRuleCallRule : ruleCallRule EOF ;
    public final void entryRuleCallRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:431:1: ( ruleCallRule EOF )
            // InternalInstanceLanguage.g:432:1: ruleCallRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleCallRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCallRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalInstanceLanguage.g:439:1: ruleCallRule : ( ( rule__CallRule__Group__0 ) ) ;
    public final void ruleCallRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:443:2: ( ( ( rule__CallRule__Group__0 ) ) )
            // InternalInstanceLanguage.g:444:2: ( ( rule__CallRule__Group__0 ) )
            {
            // InternalInstanceLanguage.g:444:2: ( ( rule__CallRule__Group__0 ) )
            // InternalInstanceLanguage.g:445:3: ( rule__CallRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getGroup()); 
            }
            // InternalInstanceLanguage.g:446:3: ( rule__CallRule__Group__0 )
            // InternalInstanceLanguage.g:446:4: rule__CallRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__CallRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCallRuleAccess().getGroup()); 
            }

            }


            }

        }
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


    // $ANTLR start "entryRuleReferenceRule"
    // InternalInstanceLanguage.g:455:1: entryRuleReferenceRule : ruleReferenceRule EOF ;
    public final void entryRuleReferenceRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:456:1: ( ruleReferenceRule EOF )
            // InternalInstanceLanguage.g:457:1: ruleReferenceRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleReferenceRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleReferenceRule"


    // $ANTLR start "ruleReferenceRule"
    // InternalInstanceLanguage.g:464:1: ruleReferenceRule : ( ( rule__ReferenceRule__Alternatives ) ) ;
    public final void ruleReferenceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:468:2: ( ( ( rule__ReferenceRule__Alternatives ) ) )
            // InternalInstanceLanguage.g:469:2: ( ( rule__ReferenceRule__Alternatives ) )
            {
            // InternalInstanceLanguage.g:469:2: ( ( rule__ReferenceRule__Alternatives ) )
            // InternalInstanceLanguage.g:470:3: ( rule__ReferenceRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceRuleAccess().getAlternatives()); 
            }
            // InternalInstanceLanguage.g:471:3: ( rule__ReferenceRule__Alternatives )
            // InternalInstanceLanguage.g:471:4: rule__ReferenceRule__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__ReferenceRule__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceRuleAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleReferenceRule"


    // $ANTLR start "entryRuleDataReferenceRule"
    // InternalInstanceLanguage.g:480:1: entryRuleDataReferenceRule : ruleDataReferenceRule EOF ;
    public final void entryRuleDataReferenceRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:481:1: ( ruleDataReferenceRule EOF )
            // InternalInstanceLanguage.g:482:1: ruleDataReferenceRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataReferenceRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleDataReferenceRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataReferenceRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleDataReferenceRule"


    // $ANTLR start "ruleDataReferenceRule"
    // InternalInstanceLanguage.g:489:1: ruleDataReferenceRule : ( ( rule__DataReferenceRule__Group__0 ) ) ;
    public final void ruleDataReferenceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:493:2: ( ( ( rule__DataReferenceRule__Group__0 ) ) )
            // InternalInstanceLanguage.g:494:2: ( ( rule__DataReferenceRule__Group__0 ) )
            {
            // InternalInstanceLanguage.g:494:2: ( ( rule__DataReferenceRule__Group__0 ) )
            // InternalInstanceLanguage.g:495:3: ( rule__DataReferenceRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataReferenceRuleAccess().getGroup()); 
            }
            // InternalInstanceLanguage.g:496:3: ( rule__DataReferenceRule__Group__0 )
            // InternalInstanceLanguage.g:496:4: rule__DataReferenceRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DataReferenceRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataReferenceRuleAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDataReferenceRule"


    // $ANTLR start "entryRuleConstantReferenceRule"
    // InternalInstanceLanguage.g:505:1: entryRuleConstantReferenceRule : ruleConstantReferenceRule EOF ;
    public final void entryRuleConstantReferenceRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:506:1: ( ruleConstantReferenceRule EOF )
            // InternalInstanceLanguage.g:507:1: ruleConstantReferenceRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstantReferenceRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleConstantReferenceRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstantReferenceRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleConstantReferenceRule"


    // $ANTLR start "ruleConstantReferenceRule"
    // InternalInstanceLanguage.g:514:1: ruleConstantReferenceRule : ( ( rule__ConstantReferenceRule__DefinitionAssignment ) ) ;
    public final void ruleConstantReferenceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:518:2: ( ( ( rule__ConstantReferenceRule__DefinitionAssignment ) ) )
            // InternalInstanceLanguage.g:519:2: ( ( rule__ConstantReferenceRule__DefinitionAssignment ) )
            {
            // InternalInstanceLanguage.g:519:2: ( ( rule__ConstantReferenceRule__DefinitionAssignment ) )
            // InternalInstanceLanguage.g:520:3: ( rule__ConstantReferenceRule__DefinitionAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstantReferenceRuleAccess().getDefinitionAssignment()); 
            }
            // InternalInstanceLanguage.g:521:3: ( rule__ConstantReferenceRule__DefinitionAssignment )
            // InternalInstanceLanguage.g:521:4: rule__ConstantReferenceRule__DefinitionAssignment
            {
            pushFollow(FOLLOW_2);
            rule__ConstantReferenceRule__DefinitionAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstantReferenceRuleAccess().getDefinitionAssignment()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConstantReferenceRule"


    // $ANTLR start "entryRuleLiteralRule"
    // InternalInstanceLanguage.g:530:1: entryRuleLiteralRule : ruleLiteralRule EOF ;
    public final void entryRuleLiteralRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:531:1: ( ruleLiteralRule EOF )
            // InternalInstanceLanguage.g:532:1: ruleLiteralRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleLiteralRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLiteralRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalInstanceLanguage.g:539:1: ruleLiteralRule : ( ( rule__LiteralRule__Alternatives ) ) ;
    public final void ruleLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:543:2: ( ( ( rule__LiteralRule__Alternatives ) ) )
            // InternalInstanceLanguage.g:544:2: ( ( rule__LiteralRule__Alternatives ) )
            {
            // InternalInstanceLanguage.g:544:2: ( ( rule__LiteralRule__Alternatives ) )
            // InternalInstanceLanguage.g:545:3: ( rule__LiteralRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralRuleAccess().getAlternatives()); 
            }
            // InternalInstanceLanguage.g:546:3: ( rule__LiteralRule__Alternatives )
            // InternalInstanceLanguage.g:546:4: rule__LiteralRule__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__LiteralRule__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLiteralRuleAccess().getAlternatives()); 
            }

            }


            }

        }
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


    // $ANTLR start "entryRuleInstanceLiteralRule"
    // InternalInstanceLanguage.g:555:1: entryRuleInstanceLiteralRule : ruleInstanceLiteralRule EOF ;
    public final void entryRuleInstanceLiteralRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:556:1: ( ruleInstanceLiteralRule EOF )
            // InternalInstanceLanguage.g:557:1: ruleInstanceLiteralRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceLiteralRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleInstanceLiteralRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getInstanceLiteralRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleInstanceLiteralRule"


    // $ANTLR start "ruleInstanceLiteralRule"
    // InternalInstanceLanguage.g:564:1: ruleInstanceLiteralRule : ( ( rule__InstanceLiteralRule__Group__0 ) ) ;
    public final void ruleInstanceLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:568:2: ( ( ( rule__InstanceLiteralRule__Group__0 ) ) )
            // InternalInstanceLanguage.g:569:2: ( ( rule__InstanceLiteralRule__Group__0 ) )
            {
            // InternalInstanceLanguage.g:569:2: ( ( rule__InstanceLiteralRule__Group__0 ) )
            // InternalInstanceLanguage.g:570:3: ( rule__InstanceLiteralRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceLiteralRuleAccess().getGroup()); 
            }
            // InternalInstanceLanguage.g:571:3: ( rule__InstanceLiteralRule__Group__0 )
            // InternalInstanceLanguage.g:571:4: rule__InstanceLiteralRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__InstanceLiteralRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getInstanceLiteralRuleAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleInstanceLiteralRule"


    // $ANTLR start "entryRuleAttributeRule"
    // InternalInstanceLanguage.g:580:1: entryRuleAttributeRule : ruleAttributeRule EOF ;
    public final void entryRuleAttributeRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:581:1: ( ruleAttributeRule EOF )
            // InternalInstanceLanguage.g:582:1: ruleAttributeRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleAttributeRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleAttributeRule"


    // $ANTLR start "ruleAttributeRule"
    // InternalInstanceLanguage.g:589:1: ruleAttributeRule : ( ( rule__AttributeRule__Group__0 ) ) ;
    public final void ruleAttributeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:593:2: ( ( ( rule__AttributeRule__Group__0 ) ) )
            // InternalInstanceLanguage.g:594:2: ( ( rule__AttributeRule__Group__0 ) )
            {
            // InternalInstanceLanguage.g:594:2: ( ( rule__AttributeRule__Group__0 ) )
            // InternalInstanceLanguage.g:595:3: ( rule__AttributeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeRuleAccess().getGroup()); 
            }
            // InternalInstanceLanguage.g:596:3: ( rule__AttributeRule__Group__0 )
            // InternalInstanceLanguage.g:596:4: rule__AttributeRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__AttributeRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeRuleAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAttributeRule"


    // $ANTLR start "entryRuleNumberLiteralRule"
    // InternalInstanceLanguage.g:605:1: entryRuleNumberLiteralRule : ruleNumberLiteralRule EOF ;
    public final void entryRuleNumberLiteralRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:606:1: ( ruleNumberLiteralRule EOF )
            // InternalInstanceLanguage.g:607:1: ruleNumberLiteralRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumberLiteralRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleNumberLiteralRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNumberLiteralRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalInstanceLanguage.g:614:1: ruleNumberLiteralRule : ( ( rule__NumberLiteralRule__Alternatives ) ) ;
    public final void ruleNumberLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:618:2: ( ( ( rule__NumberLiteralRule__Alternatives ) ) )
            // InternalInstanceLanguage.g:619:2: ( ( rule__NumberLiteralRule__Alternatives ) )
            {
            // InternalInstanceLanguage.g:619:2: ( ( rule__NumberLiteralRule__Alternatives ) )
            // InternalInstanceLanguage.g:620:3: ( rule__NumberLiteralRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumberLiteralRuleAccess().getAlternatives()); 
            }
            // InternalInstanceLanguage.g:621:3: ( rule__NumberLiteralRule__Alternatives )
            // InternalInstanceLanguage.g:621:4: rule__NumberLiteralRule__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__NumberLiteralRule__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNumberLiteralRuleAccess().getAlternatives()); 
            }

            }


            }

        }
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


    // $ANTLR start "entryRuleRealLiteralRule"
    // InternalInstanceLanguage.g:630:1: entryRuleRealLiteralRule : ruleRealLiteralRule EOF ;
    public final void entryRuleRealLiteralRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:631:1: ( ruleRealLiteralRule EOF )
            // InternalInstanceLanguage.g:632:1: ruleRealLiteralRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealLiteralRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleRealLiteralRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRealLiteralRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleRealLiteralRule"


    // $ANTLR start "ruleRealLiteralRule"
    // InternalInstanceLanguage.g:639:1: ruleRealLiteralRule : ( ( rule__RealLiteralRule__Group__0 ) ) ;
    public final void ruleRealLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:643:2: ( ( ( rule__RealLiteralRule__Group__0 ) ) )
            // InternalInstanceLanguage.g:644:2: ( ( rule__RealLiteralRule__Group__0 ) )
            {
            // InternalInstanceLanguage.g:644:2: ( ( rule__RealLiteralRule__Group__0 ) )
            // InternalInstanceLanguage.g:645:3: ( rule__RealLiteralRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealLiteralRuleAccess().getGroup()); 
            }
            // InternalInstanceLanguage.g:646:3: ( rule__RealLiteralRule__Group__0 )
            // InternalInstanceLanguage.g:646:4: rule__RealLiteralRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__RealLiteralRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRealLiteralRuleAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRealLiteralRule"


    // $ANTLR start "entryRuleIntegerLiteralRule"
    // InternalInstanceLanguage.g:655:1: entryRuleIntegerLiteralRule : ruleIntegerLiteralRule EOF ;
    public final void entryRuleIntegerLiteralRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:656:1: ( ruleIntegerLiteralRule EOF )
            // InternalInstanceLanguage.g:657:1: ruleIntegerLiteralRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegerLiteralRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleIntegerLiteralRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIntegerLiteralRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalInstanceLanguage.g:664:1: ruleIntegerLiteralRule : ( ( rule__IntegerLiteralRule__Group__0 ) ) ;
    public final void ruleIntegerLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:668:2: ( ( ( rule__IntegerLiteralRule__Group__0 ) ) )
            // InternalInstanceLanguage.g:669:2: ( ( rule__IntegerLiteralRule__Group__0 ) )
            {
            // InternalInstanceLanguage.g:669:2: ( ( rule__IntegerLiteralRule__Group__0 ) )
            // InternalInstanceLanguage.g:670:3: ( rule__IntegerLiteralRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegerLiteralRuleAccess().getGroup()); 
            }
            // InternalInstanceLanguage.g:671:3: ( rule__IntegerLiteralRule__Group__0 )
            // InternalInstanceLanguage.g:671:4: rule__IntegerLiteralRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__IntegerLiteralRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getIntegerLiteralRuleAccess().getGroup()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:680:1: entryRuleStringLiteralRule : ruleStringLiteralRule EOF ;
    public final void entryRuleStringLiteralRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:681:1: ( ruleStringLiteralRule EOF )
            // InternalInstanceLanguage.g:682:1: ruleStringLiteralRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringLiteralRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleStringLiteralRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getStringLiteralRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalInstanceLanguage.g:689:1: ruleStringLiteralRule : ( ( rule__StringLiteralRule__ValueAssignment ) ) ;
    public final void ruleStringLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:693:2: ( ( ( rule__StringLiteralRule__ValueAssignment ) ) )
            // InternalInstanceLanguage.g:694:2: ( ( rule__StringLiteralRule__ValueAssignment ) )
            {
            // InternalInstanceLanguage.g:694:2: ( ( rule__StringLiteralRule__ValueAssignment ) )
            // InternalInstanceLanguage.g:695:3: ( rule__StringLiteralRule__ValueAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringLiteralRuleAccess().getValueAssignment()); 
            }
            // InternalInstanceLanguage.g:696:3: ( rule__StringLiteralRule__ValueAssignment )
            // InternalInstanceLanguage.g:696:4: rule__StringLiteralRule__ValueAssignment
            {
            pushFollow(FOLLOW_2);
            rule__StringLiteralRule__ValueAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getStringLiteralRuleAccess().getValueAssignment()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:705:1: entryRuleBooleanLiteralRule : ruleBooleanLiteralRule EOF ;
    public final void entryRuleBooleanLiteralRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:706:1: ( ruleBooleanLiteralRule EOF )
            // InternalInstanceLanguage.g:707:1: ruleBooleanLiteralRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleBooleanLiteralRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBooleanLiteralRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalInstanceLanguage.g:714:1: ruleBooleanLiteralRule : ( ( rule__BooleanLiteralRule__Group__0 ) ) ;
    public final void ruleBooleanLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:718:2: ( ( ( rule__BooleanLiteralRule__Group__0 ) ) )
            // InternalInstanceLanguage.g:719:2: ( ( rule__BooleanLiteralRule__Group__0 ) )
            {
            // InternalInstanceLanguage.g:719:2: ( ( rule__BooleanLiteralRule__Group__0 ) )
            // InternalInstanceLanguage.g:720:3: ( rule__BooleanLiteralRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralRuleAccess().getGroup()); 
            }
            // InternalInstanceLanguage.g:721:3: ( rule__BooleanLiteralRule__Group__0 )
            // InternalInstanceLanguage.g:721:4: rule__BooleanLiteralRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__BooleanLiteralRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBooleanLiteralRuleAccess().getGroup()); 
            }

            }


            }

        }
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


    // $ANTLR start "entryRuleConstraintRule"
    // InternalInstanceLanguage.g:730:1: entryRuleConstraintRule : ruleConstraintRule EOF ;
    public final void entryRuleConstraintRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:731:1: ( ruleConstraintRule EOF )
            // InternalInstanceLanguage.g:732:1: ruleConstraintRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstraintRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleConstraintRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstraintRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleConstraintRule"


    // $ANTLR start "ruleConstraintRule"
    // InternalInstanceLanguage.g:739:1: ruleConstraintRule : ( ( rule__ConstraintRule__Group__0 ) ) ;
    public final void ruleConstraintRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:743:2: ( ( ( rule__ConstraintRule__Group__0 ) ) )
            // InternalInstanceLanguage.g:744:2: ( ( rule__ConstraintRule__Group__0 ) )
            {
            // InternalInstanceLanguage.g:744:2: ( ( rule__ConstraintRule__Group__0 ) )
            // InternalInstanceLanguage.g:745:3: ( rule__ConstraintRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstraintRuleAccess().getGroup()); 
            }
            // InternalInstanceLanguage.g:746:3: ( rule__ConstraintRule__Group__0 )
            // InternalInstanceLanguage.g:746:4: rule__ConstraintRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ConstraintRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstraintRuleAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConstraintRule"


    // $ANTLR start "entryRuleAttributeDefinitionRule"
    // InternalInstanceLanguage.g:755:1: entryRuleAttributeDefinitionRule : ruleAttributeDefinitionRule EOF ;
    public final void entryRuleAttributeDefinitionRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:756:1: ( ruleAttributeDefinitionRule EOF )
            // InternalInstanceLanguage.g:757:1: ruleAttributeDefinitionRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleAttributeDefinitionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeDefinitionRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalInstanceLanguage.g:764:1: ruleAttributeDefinitionRule : ( ( rule__AttributeDefinitionRule__Group__0 ) ) ;
    public final void ruleAttributeDefinitionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:768:2: ( ( ( rule__AttributeDefinitionRule__Group__0 ) ) )
            // InternalInstanceLanguage.g:769:2: ( ( rule__AttributeDefinitionRule__Group__0 ) )
            {
            // InternalInstanceLanguage.g:769:2: ( ( rule__AttributeDefinitionRule__Group__0 ) )
            // InternalInstanceLanguage.g:770:3: ( rule__AttributeDefinitionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getGroup()); 
            }
            // InternalInstanceLanguage.g:771:3: ( rule__AttributeDefinitionRule__Group__0 )
            // InternalInstanceLanguage.g:771:4: rule__AttributeDefinitionRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__AttributeDefinitionRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeDefinitionRuleAccess().getGroup()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:780:1: entryRuleTypeRule : ruleTypeRule EOF ;
    public final void entryRuleTypeRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:781:1: ( ruleTypeRule EOF )
            // InternalInstanceLanguage.g:782:1: ruleTypeRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleTypeRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalInstanceLanguage.g:789:1: ruleTypeRule : ( ( rule__TypeRule__Alternatives ) ) ;
    public final void ruleTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:793:2: ( ( ( rule__TypeRule__Alternatives ) ) )
            // InternalInstanceLanguage.g:794:2: ( ( rule__TypeRule__Alternatives ) )
            {
            // InternalInstanceLanguage.g:794:2: ( ( rule__TypeRule__Alternatives ) )
            // InternalInstanceLanguage.g:795:3: ( rule__TypeRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeRuleAccess().getAlternatives()); 
            }
            // InternalInstanceLanguage.g:796:3: ( rule__TypeRule__Alternatives )
            // InternalInstanceLanguage.g:796:4: rule__TypeRule__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__TypeRule__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeRuleAccess().getAlternatives()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:805:1: entryRuleLiteralTypeRule : ruleLiteralTypeRule EOF ;
    public final void entryRuleLiteralTypeRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:806:1: ( ruleLiteralTypeRule EOF )
            // InternalInstanceLanguage.g:807:1: ruleLiteralTypeRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralTypeRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleLiteralTypeRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLiteralTypeRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalInstanceLanguage.g:814:1: ruleLiteralTypeRule : ( ( rule__LiteralTypeRule__Group__0 ) ) ;
    public final void ruleLiteralTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:818:2: ( ( ( rule__LiteralTypeRule__Group__0 ) ) )
            // InternalInstanceLanguage.g:819:2: ( ( rule__LiteralTypeRule__Group__0 ) )
            {
            // InternalInstanceLanguage.g:819:2: ( ( rule__LiteralTypeRule__Group__0 ) )
            // InternalInstanceLanguage.g:820:3: ( rule__LiteralTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralTypeRuleAccess().getGroup()); 
            }
            // InternalInstanceLanguage.g:821:3: ( rule__LiteralTypeRule__Group__0 )
            // InternalInstanceLanguage.g:821:4: rule__LiteralTypeRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__LiteralTypeRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLiteralTypeRuleAccess().getGroup()); 
            }

            }


            }

        }
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


    // $ANTLR start "entryRuleDataTypeRule"
    // InternalInstanceLanguage.g:830:1: entryRuleDataTypeRule : ruleDataTypeRule EOF ;
    public final void entryRuleDataTypeRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:831:1: ( ruleDataTypeRule EOF )
            // InternalInstanceLanguage.g:832:1: ruleDataTypeRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleDataTypeRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataTypeRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalInstanceLanguage.g:839:1: ruleDataTypeRule : ( ( rule__DataTypeRule__Group__0 ) ) ;
    public final void ruleDataTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:843:2: ( ( ( rule__DataTypeRule__Group__0 ) ) )
            // InternalInstanceLanguage.g:844:2: ( ( rule__DataTypeRule__Group__0 ) )
            {
            // InternalInstanceLanguage.g:844:2: ( ( rule__DataTypeRule__Group__0 ) )
            // InternalInstanceLanguage.g:845:3: ( rule__DataTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getGroup()); 
            }
            // InternalInstanceLanguage.g:846:3: ( rule__DataTypeRule__Group__0 )
            // InternalInstanceLanguage.g:846:4: rule__DataTypeRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DataTypeRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataTypeRuleAccess().getGroup()); 
            }

            }


            }

        }
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


    // $ANTLR start "entryRuleInstanceTypeRule"
    // InternalInstanceLanguage.g:855:1: entryRuleInstanceTypeRule : ruleInstanceTypeRule EOF ;
    public final void entryRuleInstanceTypeRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:856:1: ( ruleInstanceTypeRule EOF )
            // InternalInstanceLanguage.g:857:1: ruleInstanceTypeRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceTypeRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleInstanceTypeRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getInstanceTypeRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalInstanceLanguage.g:864:1: ruleInstanceTypeRule : ( ( rule__InstanceTypeRule__Group__0 ) ) ;
    public final void ruleInstanceTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:868:2: ( ( ( rule__InstanceTypeRule__Group__0 ) ) )
            // InternalInstanceLanguage.g:869:2: ( ( rule__InstanceTypeRule__Group__0 ) )
            {
            // InternalInstanceLanguage.g:869:2: ( ( rule__InstanceTypeRule__Group__0 ) )
            // InternalInstanceLanguage.g:870:3: ( rule__InstanceTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceTypeRuleAccess().getGroup()); 
            }
            // InternalInstanceLanguage.g:871:3: ( rule__InstanceTypeRule__Group__0 )
            // InternalInstanceLanguage.g:871:4: rule__InstanceTypeRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__InstanceTypeRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getInstanceTypeRuleAccess().getGroup()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:880:1: entryRuleStringTypeRule : ruleStringTypeRule EOF ;
    public final void entryRuleStringTypeRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:881:1: ( ruleStringTypeRule EOF )
            // InternalInstanceLanguage.g:882:1: ruleStringTypeRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringTypeRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleStringTypeRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getStringTypeRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalInstanceLanguage.g:889:1: ruleStringTypeRule : ( ( rule__StringTypeRule__Group__0 ) ) ;
    public final void ruleStringTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:893:2: ( ( ( rule__StringTypeRule__Group__0 ) ) )
            // InternalInstanceLanguage.g:894:2: ( ( rule__StringTypeRule__Group__0 ) )
            {
            // InternalInstanceLanguage.g:894:2: ( ( rule__StringTypeRule__Group__0 ) )
            // InternalInstanceLanguage.g:895:3: ( rule__StringTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringTypeRuleAccess().getGroup()); 
            }
            // InternalInstanceLanguage.g:896:3: ( rule__StringTypeRule__Group__0 )
            // InternalInstanceLanguage.g:896:4: rule__StringTypeRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__StringTypeRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getStringTypeRuleAccess().getGroup()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:905:1: entryRuleExpressionTypeRule : ruleExpressionTypeRule EOF ;
    public final void entryRuleExpressionTypeRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:906:1: ( ruleExpressionTypeRule EOF )
            // InternalInstanceLanguage.g:907:1: ruleExpressionTypeRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionTypeRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleExpressionTypeRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpressionTypeRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalInstanceLanguage.g:914:1: ruleExpressionTypeRule : ( ( rule__ExpressionTypeRule__Group__0 ) ) ;
    public final void ruleExpressionTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:918:2: ( ( ( rule__ExpressionTypeRule__Group__0 ) ) )
            // InternalInstanceLanguage.g:919:2: ( ( rule__ExpressionTypeRule__Group__0 ) )
            {
            // InternalInstanceLanguage.g:919:2: ( ( rule__ExpressionTypeRule__Group__0 ) )
            // InternalInstanceLanguage.g:920:3: ( rule__ExpressionTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionTypeRuleAccess().getGroup()); 
            }
            // InternalInstanceLanguage.g:921:3: ( rule__ExpressionTypeRule__Group__0 )
            // InternalInstanceLanguage.g:921:4: rule__ExpressionTypeRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ExpressionTypeRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpressionTypeRuleAccess().getGroup()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:930:1: entryRuleIntTypeRule : ruleIntTypeRule EOF ;
    public final void entryRuleIntTypeRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:931:1: ( ruleIntTypeRule EOF )
            // InternalInstanceLanguage.g:932:1: ruleIntTypeRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntTypeRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleIntTypeRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIntTypeRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalInstanceLanguage.g:939:1: ruleIntTypeRule : ( ( rule__IntTypeRule__Group__0 ) ) ;
    public final void ruleIntTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:943:2: ( ( ( rule__IntTypeRule__Group__0 ) ) )
            // InternalInstanceLanguage.g:944:2: ( ( rule__IntTypeRule__Group__0 ) )
            {
            // InternalInstanceLanguage.g:944:2: ( ( rule__IntTypeRule__Group__0 ) )
            // InternalInstanceLanguage.g:945:3: ( rule__IntTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntTypeRuleAccess().getGroup()); 
            }
            // InternalInstanceLanguage.g:946:3: ( rule__IntTypeRule__Group__0 )
            // InternalInstanceLanguage.g:946:4: rule__IntTypeRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__IntTypeRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getIntTypeRuleAccess().getGroup()); 
            }

            }


            }

        }
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


    // $ANTLR start "entryRuleRealTypeRule"
    // InternalInstanceLanguage.g:955:1: entryRuleRealTypeRule : ruleRealTypeRule EOF ;
    public final void entryRuleRealTypeRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:956:1: ( ruleRealTypeRule EOF )
            // InternalInstanceLanguage.g:957:1: ruleRealTypeRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealTypeRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleRealTypeRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRealTypeRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleRealTypeRule"


    // $ANTLR start "ruleRealTypeRule"
    // InternalInstanceLanguage.g:964:1: ruleRealTypeRule : ( ( rule__RealTypeRule__Group__0 ) ) ;
    public final void ruleRealTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:968:2: ( ( ( rule__RealTypeRule__Group__0 ) ) )
            // InternalInstanceLanguage.g:969:2: ( ( rule__RealTypeRule__Group__0 ) )
            {
            // InternalInstanceLanguage.g:969:2: ( ( rule__RealTypeRule__Group__0 ) )
            // InternalInstanceLanguage.g:970:3: ( rule__RealTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealTypeRuleAccess().getGroup()); 
            }
            // InternalInstanceLanguage.g:971:3: ( rule__RealTypeRule__Group__0 )
            // InternalInstanceLanguage.g:971:4: rule__RealTypeRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__RealTypeRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRealTypeRuleAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRealTypeRule"


    // $ANTLR start "entryRuleBooleanTypeRule"
    // InternalInstanceLanguage.g:980:1: entryRuleBooleanTypeRule : ruleBooleanTypeRule EOF ;
    public final void entryRuleBooleanTypeRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:981:1: ( ruleBooleanTypeRule EOF )
            // InternalInstanceLanguage.g:982:1: ruleBooleanTypeRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanTypeRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleBooleanTypeRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBooleanTypeRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalInstanceLanguage.g:989:1: ruleBooleanTypeRule : ( ( rule__BooleanTypeRule__Group__0 ) ) ;
    public final void ruleBooleanTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:993:2: ( ( ( rule__BooleanTypeRule__Group__0 ) ) )
            // InternalInstanceLanguage.g:994:2: ( ( rule__BooleanTypeRule__Group__0 ) )
            {
            // InternalInstanceLanguage.g:994:2: ( ( rule__BooleanTypeRule__Group__0 ) )
            // InternalInstanceLanguage.g:995:3: ( rule__BooleanTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanTypeRuleAccess().getGroup()); 
            }
            // InternalInstanceLanguage.g:996:3: ( rule__BooleanTypeRule__Group__0 )
            // InternalInstanceLanguage.g:996:4: rule__BooleanTypeRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__BooleanTypeRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBooleanTypeRuleAccess().getGroup()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:1005:1: entryRuleVoidTypeRule : ruleVoidTypeRule EOF ;
    public final void entryRuleVoidTypeRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:1006:1: ( ruleVoidTypeRule EOF )
            // InternalInstanceLanguage.g:1007:1: ruleVoidTypeRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVoidTypeRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleVoidTypeRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVoidTypeRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalInstanceLanguage.g:1014:1: ruleVoidTypeRule : ( ( rule__VoidTypeRule__Group__0 ) ) ;
    public final void ruleVoidTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1018:2: ( ( ( rule__VoidTypeRule__Group__0 ) ) )
            // InternalInstanceLanguage.g:1019:2: ( ( rule__VoidTypeRule__Group__0 ) )
            {
            // InternalInstanceLanguage.g:1019:2: ( ( rule__VoidTypeRule__Group__0 ) )
            // InternalInstanceLanguage.g:1020:3: ( rule__VoidTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVoidTypeRuleAccess().getGroup()); 
            }
            // InternalInstanceLanguage.g:1021:3: ( rule__VoidTypeRule__Group__0 )
            // InternalInstanceLanguage.g:1021:4: rule__VoidTypeRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__VoidTypeRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVoidTypeRuleAccess().getGroup()); 
            }

            }


            }

        }
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


    // $ANTLR start "entryRuleArrayTypeRule"
    // InternalInstanceLanguage.g:1030:1: entryRuleArrayTypeRule : ruleArrayTypeRule EOF ;
    public final void entryRuleArrayTypeRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:1031:1: ( ruleArrayTypeRule EOF )
            // InternalInstanceLanguage.g:1032:1: ruleArrayTypeRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayTypeRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleArrayTypeRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getArrayTypeRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalInstanceLanguage.g:1039:1: ruleArrayTypeRule : ( ( rule__ArrayTypeRule__Group__0 ) ) ;
    public final void ruleArrayTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1043:2: ( ( ( rule__ArrayTypeRule__Group__0 ) ) )
            // InternalInstanceLanguage.g:1044:2: ( ( rule__ArrayTypeRule__Group__0 ) )
            {
            // InternalInstanceLanguage.g:1044:2: ( ( rule__ArrayTypeRule__Group__0 ) )
            // InternalInstanceLanguage.g:1045:3: ( rule__ArrayTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayTypeRuleAccess().getGroup()); 
            }
            // InternalInstanceLanguage.g:1046:3: ( rule__ArrayTypeRule__Group__0 )
            // InternalInstanceLanguage.g:1046:4: rule__ArrayTypeRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ArrayTypeRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getArrayTypeRuleAccess().getGroup()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:1055:1: entryRuleParameterRule : ruleParameterRule EOF ;
    public final void entryRuleParameterRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:1056:1: ( ruleParameterRule EOF )
            // InternalInstanceLanguage.g:1057:1: ruleParameterRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleParameterRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParameterRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalInstanceLanguage.g:1064:1: ruleParameterRule : ( ( rule__ParameterRule__Group__0 ) ) ;
    public final void ruleParameterRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1068:2: ( ( ( rule__ParameterRule__Group__0 ) ) )
            // InternalInstanceLanguage.g:1069:2: ( ( rule__ParameterRule__Group__0 ) )
            {
            // InternalInstanceLanguage.g:1069:2: ( ( rule__ParameterRule__Group__0 ) )
            // InternalInstanceLanguage.g:1070:3: ( rule__ParameterRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterRuleAccess().getGroup()); 
            }
            // InternalInstanceLanguage.g:1071:3: ( rule__ParameterRule__Group__0 )
            // InternalInstanceLanguage.g:1071:4: rule__ParameterRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ParameterRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getParameterRuleAccess().getGroup()); 
            }

            }


            }

        }
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


    // $ANTLR start "entryRuleImportRule"
    // InternalInstanceLanguage.g:1080:1: entryRuleImportRule : ruleImportRule EOF ;
    public final void entryRuleImportRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:1081:1: ( ruleImportRule EOF )
            // InternalInstanceLanguage.g:1082:1: ruleImportRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleImportRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getImportRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalInstanceLanguage.g:1089:1: ruleImportRule : ( ( rule__ImportRule__Group__0 ) ) ;
    public final void ruleImportRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1093:2: ( ( ( rule__ImportRule__Group__0 ) ) )
            // InternalInstanceLanguage.g:1094:2: ( ( rule__ImportRule__Group__0 ) )
            {
            // InternalInstanceLanguage.g:1094:2: ( ( rule__ImportRule__Group__0 ) )
            // InternalInstanceLanguage.g:1095:3: ( rule__ImportRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportRuleAccess().getGroup()); 
            }
            // InternalInstanceLanguage.g:1096:3: ( rule__ImportRule__Group__0 )
            // InternalInstanceLanguage.g:1096:4: rule__ImportRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ImportRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getImportRuleAccess().getGroup()); 
            }

            }


            }

        }
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


    // $ANTLR start "entryRuleQualifiedName"
    // InternalInstanceLanguage.g:1105:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:1106:1: ( ruleQualifiedName EOF )
            // InternalInstanceLanguage.g:1107:1: ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalInstanceLanguage.g:1114:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1118:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // InternalInstanceLanguage.g:1119:2: ( ( rule__QualifiedName__Group__0 ) )
            {
            // InternalInstanceLanguage.g:1119:2: ( ( rule__QualifiedName__Group__0 ) )
            // InternalInstanceLanguage.g:1120:3: ( rule__QualifiedName__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            }
            // InternalInstanceLanguage.g:1121:3: ( rule__QualifiedName__Group__0 )
            // InternalInstanceLanguage.g:1121:4: rule__QualifiedName__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameAccess().getGroup()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:1130:1: entryRuleStringOrId : ruleStringOrId EOF ;
    public final void entryRuleStringOrId() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:1131:1: ( ruleStringOrId EOF )
            // InternalInstanceLanguage.g:1132:1: ruleStringOrId EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringOrIdRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleStringOrId();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getStringOrIdRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalInstanceLanguage.g:1139:1: ruleStringOrId : ( ( rule__StringOrId__Alternatives ) ) ;
    public final void ruleStringOrId() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1143:2: ( ( ( rule__StringOrId__Alternatives ) ) )
            // InternalInstanceLanguage.g:1144:2: ( ( rule__StringOrId__Alternatives ) )
            {
            // InternalInstanceLanguage.g:1144:2: ( ( rule__StringOrId__Alternatives ) )
            // InternalInstanceLanguage.g:1145:3: ( rule__StringOrId__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringOrIdAccess().getAlternatives()); 
            }
            // InternalInstanceLanguage.g:1146:3: ( rule__StringOrId__Alternatives )
            // InternalInstanceLanguage.g:1146:4: rule__StringOrId__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__StringOrId__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getStringOrIdAccess().getAlternatives()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:1155:1: ruleComparisonOperatorRule : ( ( rule__ComparisonOperatorRule__Alternatives ) ) ;
    public final void ruleComparisonOperatorRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1159:1: ( ( ( rule__ComparisonOperatorRule__Alternatives ) ) )
            // InternalInstanceLanguage.g:1160:2: ( ( rule__ComparisonOperatorRule__Alternatives ) )
            {
            // InternalInstanceLanguage.g:1160:2: ( ( rule__ComparisonOperatorRule__Alternatives ) )
            // InternalInstanceLanguage.g:1161:3: ( rule__ComparisonOperatorRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonOperatorRuleAccess().getAlternatives()); 
            }
            // InternalInstanceLanguage.g:1162:3: ( rule__ComparisonOperatorRule__Alternatives )
            // InternalInstanceLanguage.g:1162:4: rule__ComparisonOperatorRule__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__ComparisonOperatorRule__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getComparisonOperatorRuleAccess().getAlternatives()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:1171:1: ruleAddOrSubtractOperatorRule : ( ( rule__AddOrSubtractOperatorRule__Alternatives ) ) ;
    public final void ruleAddOrSubtractOperatorRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1175:1: ( ( ( rule__AddOrSubtractOperatorRule__Alternatives ) ) )
            // InternalInstanceLanguage.g:1176:2: ( ( rule__AddOrSubtractOperatorRule__Alternatives ) )
            {
            // InternalInstanceLanguage.g:1176:2: ( ( rule__AddOrSubtractOperatorRule__Alternatives ) )
            // InternalInstanceLanguage.g:1177:3: ( rule__AddOrSubtractOperatorRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOrSubtractOperatorRuleAccess().getAlternatives()); 
            }
            // InternalInstanceLanguage.g:1178:3: ( rule__AddOrSubtractOperatorRule__Alternatives )
            // InternalInstanceLanguage.g:1178:4: rule__AddOrSubtractOperatorRule__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__AddOrSubtractOperatorRule__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAddOrSubtractOperatorRuleAccess().getAlternatives()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:1187:1: ruleMultiplyDivideModuloOperatorRule : ( ( rule__MultiplyDivideModuloOperatorRule__Alternatives ) ) ;
    public final void ruleMultiplyDivideModuloOperatorRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1191:1: ( ( ( rule__MultiplyDivideModuloOperatorRule__Alternatives ) ) )
            // InternalInstanceLanguage.g:1192:2: ( ( rule__MultiplyDivideModuloOperatorRule__Alternatives ) )
            {
            // InternalInstanceLanguage.g:1192:2: ( ( rule__MultiplyDivideModuloOperatorRule__Alternatives ) )
            // InternalInstanceLanguage.g:1193:3: ( rule__MultiplyDivideModuloOperatorRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getAlternatives()); 
            }
            // InternalInstanceLanguage.g:1194:3: ( rule__MultiplyDivideModuloOperatorRule__Alternatives )
            // InternalInstanceLanguage.g:1194:4: rule__MultiplyDivideModuloOperatorRule__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__MultiplyDivideModuloOperatorRule__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getAlternatives()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:1203:1: ruleFactorRule : ( ( rule__FactorRule__Alternatives ) ) ;
    public final void ruleFactorRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1207:1: ( ( ( rule__FactorRule__Alternatives ) ) )
            // InternalInstanceLanguage.g:1208:2: ( ( rule__FactorRule__Alternatives ) )
            {
            // InternalInstanceLanguage.g:1208:2: ( ( rule__FactorRule__Alternatives ) )
            // InternalInstanceLanguage.g:1209:3: ( rule__FactorRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFactorRuleAccess().getAlternatives()); 
            }
            // InternalInstanceLanguage.g:1210:3: ( rule__FactorRule__Alternatives )
            // InternalInstanceLanguage.g:1210:4: rule__FactorRule__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__FactorRule__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFactorRuleAccess().getAlternatives()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__ValueRule__Alternatives"
    // InternalInstanceLanguage.g:1218:1: rule__ValueRule__Alternatives : ( ( ruleArrayRule ) | ( ruleCallRule ) | ( ruleLiteralRule ) | ( ruleParanthesesRule ) | ( ruleReferenceRule ) );
    public final void rule__ValueRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1222:1: ( ( ruleArrayRule ) | ( ruleCallRule ) | ( ruleLiteralRule ) | ( ruleParanthesesRule ) | ( ruleReferenceRule ) )
            int alt1=5;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // InternalInstanceLanguage.g:1223:2: ( ruleArrayRule )
                    {
                    // InternalInstanceLanguage.g:1223:2: ( ruleArrayRule )
                    // InternalInstanceLanguage.g:1224:3: ruleArrayRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getValueRuleAccess().getArrayRuleParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleArrayRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getValueRuleAccess().getArrayRuleParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalInstanceLanguage.g:1229:2: ( ruleCallRule )
                    {
                    // InternalInstanceLanguage.g:1229:2: ( ruleCallRule )
                    // InternalInstanceLanguage.g:1230:3: ruleCallRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getValueRuleAccess().getCallRuleParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleCallRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getValueRuleAccess().getCallRuleParserRuleCall_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalInstanceLanguage.g:1235:2: ( ruleLiteralRule )
                    {
                    // InternalInstanceLanguage.g:1235:2: ( ruleLiteralRule )
                    // InternalInstanceLanguage.g:1236:3: ruleLiteralRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getValueRuleAccess().getLiteralRuleParserRuleCall_2()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleLiteralRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getValueRuleAccess().getLiteralRuleParserRuleCall_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalInstanceLanguage.g:1241:2: ( ruleParanthesesRule )
                    {
                    // InternalInstanceLanguage.g:1241:2: ( ruleParanthesesRule )
                    // InternalInstanceLanguage.g:1242:3: ruleParanthesesRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getValueRuleAccess().getParanthesesRuleParserRuleCall_3()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleParanthesesRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getValueRuleAccess().getParanthesesRuleParserRuleCall_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalInstanceLanguage.g:1247:2: ( ruleReferenceRule )
                    {
                    // InternalInstanceLanguage.g:1247:2: ( ruleReferenceRule )
                    // InternalInstanceLanguage.g:1248:3: ruleReferenceRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getValueRuleAccess().getReferenceRuleParserRuleCall_4()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleReferenceRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getValueRuleAccess().getReferenceRuleParserRuleCall_4()); 
                    }

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
    // $ANTLR end "rule__ValueRule__Alternatives"


    // $ANTLR start "rule__ReferenceRule__Alternatives"
    // InternalInstanceLanguage.g:1257:1: rule__ReferenceRule__Alternatives : ( ( ruleConstantReferenceRule ) | ( ruleDataReferenceRule ) );
    public final void rule__ReferenceRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1261:1: ( ( ruleConstantReferenceRule ) | ( ruleDataReferenceRule ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( ((LA2_0>=RULE_QUOTED_ID && LA2_0<=RULE_ID)) ) {
                alt2=1;
            }
            else if ( (LA2_0==59) ) {
                alt2=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalInstanceLanguage.g:1262:2: ( ruleConstantReferenceRule )
                    {
                    // InternalInstanceLanguage.g:1262:2: ( ruleConstantReferenceRule )
                    // InternalInstanceLanguage.g:1263:3: ruleConstantReferenceRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getReferenceRuleAccess().getConstantReferenceRuleParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleConstantReferenceRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getReferenceRuleAccess().getConstantReferenceRuleParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalInstanceLanguage.g:1268:2: ( ruleDataReferenceRule )
                    {
                    // InternalInstanceLanguage.g:1268:2: ( ruleDataReferenceRule )
                    // InternalInstanceLanguage.g:1269:3: ruleDataReferenceRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getReferenceRuleAccess().getDataReferenceRuleParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleDataReferenceRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getReferenceRuleAccess().getDataReferenceRuleParserRuleCall_1()); 
                    }

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
    // $ANTLR end "rule__ReferenceRule__Alternatives"


    // $ANTLR start "rule__LiteralRule__Alternatives"
    // InternalInstanceLanguage.g:1278:1: rule__LiteralRule__Alternatives : ( ( ruleNumberLiteralRule ) | ( ruleStringLiteralRule ) | ( ruleBooleanLiteralRule ) | ( ruleInstanceLiteralRule ) );
    public final void rule__LiteralRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1282:1: ( ( ruleNumberLiteralRule ) | ( ruleStringLiteralRule ) | ( ruleBooleanLiteralRule ) | ( ruleInstanceLiteralRule ) )
            int alt3=4;
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
            case 77:
                {
                alt3=3;
                }
                break;
            case RULE_QUOTED_ID:
            case RULE_ID:
                {
                alt3=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalInstanceLanguage.g:1283:2: ( ruleNumberLiteralRule )
                    {
                    // InternalInstanceLanguage.g:1283:2: ( ruleNumberLiteralRule )
                    // InternalInstanceLanguage.g:1284:3: ruleNumberLiteralRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralRuleAccess().getNumberLiteralRuleParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleNumberLiteralRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLiteralRuleAccess().getNumberLiteralRuleParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalInstanceLanguage.g:1289:2: ( ruleStringLiteralRule )
                    {
                    // InternalInstanceLanguage.g:1289:2: ( ruleStringLiteralRule )
                    // InternalInstanceLanguage.g:1290:3: ruleStringLiteralRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralRuleAccess().getStringLiteralRuleParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleStringLiteralRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLiteralRuleAccess().getStringLiteralRuleParserRuleCall_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalInstanceLanguage.g:1295:2: ( ruleBooleanLiteralRule )
                    {
                    // InternalInstanceLanguage.g:1295:2: ( ruleBooleanLiteralRule )
                    // InternalInstanceLanguage.g:1296:3: ruleBooleanLiteralRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralRuleAccess().getBooleanLiteralRuleParserRuleCall_2()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleBooleanLiteralRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLiteralRuleAccess().getBooleanLiteralRuleParserRuleCall_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalInstanceLanguage.g:1301:2: ( ruleInstanceLiteralRule )
                    {
                    // InternalInstanceLanguage.g:1301:2: ( ruleInstanceLiteralRule )
                    // InternalInstanceLanguage.g:1302:3: ruleInstanceLiteralRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralRuleAccess().getInstanceLiteralRuleParserRuleCall_3()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleInstanceLiteralRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLiteralRuleAccess().getInstanceLiteralRuleParserRuleCall_3()); 
                    }

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
    // InternalInstanceLanguage.g:1311:1: rule__NumberLiteralRule__Alternatives : ( ( ruleRealLiteralRule ) | ( ruleIntegerLiteralRule ) );
    public final void rule__NumberLiteralRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1315:1: ( ( ruleRealLiteralRule ) | ( ruleIntegerLiteralRule ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_DOUBLE) ) {
                alt4=1;
            }
            else if ( (LA4_0==RULE_INT) ) {
                alt4=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalInstanceLanguage.g:1316:2: ( ruleRealLiteralRule )
                    {
                    // InternalInstanceLanguage.g:1316:2: ( ruleRealLiteralRule )
                    // InternalInstanceLanguage.g:1317:3: ruleRealLiteralRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getNumberLiteralRuleAccess().getRealLiteralRuleParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleRealLiteralRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getNumberLiteralRuleAccess().getRealLiteralRuleParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalInstanceLanguage.g:1322:2: ( ruleIntegerLiteralRule )
                    {
                    // InternalInstanceLanguage.g:1322:2: ( ruleIntegerLiteralRule )
                    // InternalInstanceLanguage.g:1323:3: ruleIntegerLiteralRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getNumberLiteralRuleAccess().getIntegerLiteralRuleParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleIntegerLiteralRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getNumberLiteralRuleAccess().getIntegerLiteralRuleParserRuleCall_1()); 
                    }

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
    // InternalInstanceLanguage.g:1332:1: rule__BooleanLiteralRule__Alternatives_1 : ( ( ( rule__BooleanLiteralRule__ValueAssignment_1_0 ) ) | ( 'false' ) );
    public final void rule__BooleanLiteralRule__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1336:1: ( ( ( rule__BooleanLiteralRule__ValueAssignment_1_0 ) ) | ( 'false' ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==77) ) {
                alt5=1;
            }
            else if ( (LA5_0==15) ) {
                alt5=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalInstanceLanguage.g:1337:2: ( ( rule__BooleanLiteralRule__ValueAssignment_1_0 ) )
                    {
                    // InternalInstanceLanguage.g:1337:2: ( ( rule__BooleanLiteralRule__ValueAssignment_1_0 ) )
                    // InternalInstanceLanguage.g:1338:3: ( rule__BooleanLiteralRule__ValueAssignment_1_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBooleanLiteralRuleAccess().getValueAssignment_1_0()); 
                    }
                    // InternalInstanceLanguage.g:1339:3: ( rule__BooleanLiteralRule__ValueAssignment_1_0 )
                    // InternalInstanceLanguage.g:1339:4: rule__BooleanLiteralRule__ValueAssignment_1_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__BooleanLiteralRule__ValueAssignment_1_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getBooleanLiteralRuleAccess().getValueAssignment_1_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalInstanceLanguage.g:1343:2: ( 'false' )
                    {
                    // InternalInstanceLanguage.g:1343:2: ( 'false' )
                    // InternalInstanceLanguage.g:1344:3: 'false'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBooleanLiteralRuleAccess().getFalseKeyword_1_1()); 
                    }
                    match(input,15,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getBooleanLiteralRuleAccess().getFalseKeyword_1_1()); 
                    }

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
    // InternalInstanceLanguage.g:1353:1: rule__TypeRule__Alternatives : ( ( ruleStringTypeRule ) | ( ruleIntTypeRule ) | ( ruleRealTypeRule ) | ( ruleBooleanTypeRule ) | ( ruleArrayTypeRule ) | ( ruleInstanceTypeRule ) | ( ruleVoidTypeRule ) | ( ruleExpressionTypeRule ) | ( ruleLiteralTypeRule ) | ( ruleDataTypeRule ) );
    public final void rule__TypeRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1357:1: ( ( ruleStringTypeRule ) | ( ruleIntTypeRule ) | ( ruleRealTypeRule ) | ( ruleBooleanTypeRule ) | ( ruleArrayTypeRule ) | ( ruleInstanceTypeRule ) | ( ruleVoidTypeRule ) | ( ruleExpressionTypeRule ) | ( ruleLiteralTypeRule ) | ( ruleDataTypeRule ) )
            int alt6=10;
            switch ( input.LA(1) ) {
            case 66:
                {
                alt6=1;
                }
                break;
            case 68:
                {
                alt6=2;
                }
                break;
            case 69:
                {
                alt6=3;
                }
                break;
            case 70:
                {
                alt6=4;
                }
                break;
            case 72:
                {
                alt6=5;
                }
                break;
            case 51:
                {
                alt6=6;
                }
                break;
            case 71:
                {
                alt6=7;
                }
                break;
            case 67:
                {
                alt6=8;
                }
                break;
            case 65:
                {
                alt6=9;
                }
                break;
            case 59:
                {
                alt6=10;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalInstanceLanguage.g:1358:2: ( ruleStringTypeRule )
                    {
                    // InternalInstanceLanguage.g:1358:2: ( ruleStringTypeRule )
                    // InternalInstanceLanguage.g:1359:3: ruleStringTypeRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeRuleAccess().getStringTypeRuleParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleStringTypeRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeRuleAccess().getStringTypeRuleParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalInstanceLanguage.g:1364:2: ( ruleIntTypeRule )
                    {
                    // InternalInstanceLanguage.g:1364:2: ( ruleIntTypeRule )
                    // InternalInstanceLanguage.g:1365:3: ruleIntTypeRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeRuleAccess().getIntTypeRuleParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleIntTypeRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeRuleAccess().getIntTypeRuleParserRuleCall_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalInstanceLanguage.g:1370:2: ( ruleRealTypeRule )
                    {
                    // InternalInstanceLanguage.g:1370:2: ( ruleRealTypeRule )
                    // InternalInstanceLanguage.g:1371:3: ruleRealTypeRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeRuleAccess().getRealTypeRuleParserRuleCall_2()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleRealTypeRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeRuleAccess().getRealTypeRuleParserRuleCall_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalInstanceLanguage.g:1376:2: ( ruleBooleanTypeRule )
                    {
                    // InternalInstanceLanguage.g:1376:2: ( ruleBooleanTypeRule )
                    // InternalInstanceLanguage.g:1377:3: ruleBooleanTypeRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeRuleAccess().getBooleanTypeRuleParserRuleCall_3()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleBooleanTypeRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeRuleAccess().getBooleanTypeRuleParserRuleCall_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalInstanceLanguage.g:1382:2: ( ruleArrayTypeRule )
                    {
                    // InternalInstanceLanguage.g:1382:2: ( ruleArrayTypeRule )
                    // InternalInstanceLanguage.g:1383:3: ruleArrayTypeRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeRuleAccess().getArrayTypeRuleParserRuleCall_4()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleArrayTypeRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeRuleAccess().getArrayTypeRuleParserRuleCall_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalInstanceLanguage.g:1388:2: ( ruleInstanceTypeRule )
                    {
                    // InternalInstanceLanguage.g:1388:2: ( ruleInstanceTypeRule )
                    // InternalInstanceLanguage.g:1389:3: ruleInstanceTypeRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeRuleAccess().getInstanceTypeRuleParserRuleCall_5()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleInstanceTypeRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeRuleAccess().getInstanceTypeRuleParserRuleCall_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalInstanceLanguage.g:1394:2: ( ruleVoidTypeRule )
                    {
                    // InternalInstanceLanguage.g:1394:2: ( ruleVoidTypeRule )
                    // InternalInstanceLanguage.g:1395:3: ruleVoidTypeRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeRuleAccess().getVoidTypeRuleParserRuleCall_6()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleVoidTypeRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeRuleAccess().getVoidTypeRuleParserRuleCall_6()); 
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalInstanceLanguage.g:1400:2: ( ruleExpressionTypeRule )
                    {
                    // InternalInstanceLanguage.g:1400:2: ( ruleExpressionTypeRule )
                    // InternalInstanceLanguage.g:1401:3: ruleExpressionTypeRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeRuleAccess().getExpressionTypeRuleParserRuleCall_7()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleExpressionTypeRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeRuleAccess().getExpressionTypeRuleParserRuleCall_7()); 
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalInstanceLanguage.g:1406:2: ( ruleLiteralTypeRule )
                    {
                    // InternalInstanceLanguage.g:1406:2: ( ruleLiteralTypeRule )
                    // InternalInstanceLanguage.g:1407:3: ruleLiteralTypeRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeRuleAccess().getLiteralTypeRuleParserRuleCall_8()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleLiteralTypeRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeRuleAccess().getLiteralTypeRuleParserRuleCall_8()); 
                    }

                    }


                    }
                    break;
                case 10 :
                    // InternalInstanceLanguage.g:1412:2: ( ruleDataTypeRule )
                    {
                    // InternalInstanceLanguage.g:1412:2: ( ruleDataTypeRule )
                    // InternalInstanceLanguage.g:1413:3: ruleDataTypeRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeRuleAccess().getDataTypeRuleParserRuleCall_9()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleDataTypeRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeRuleAccess().getDataTypeRuleParserRuleCall_9()); 
                    }

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
    // InternalInstanceLanguage.g:1422:1: rule__StringOrId__Alternatives : ( ( RULE_QUOTED_ID ) | ( RULE_ID ) );
    public final void rule__StringOrId__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1426:1: ( ( RULE_QUOTED_ID ) | ( RULE_ID ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_QUOTED_ID) ) {
                alt7=1;
            }
            else if ( (LA7_0==RULE_ID) ) {
                alt7=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalInstanceLanguage.g:1427:2: ( RULE_QUOTED_ID )
                    {
                    // InternalInstanceLanguage.g:1427:2: ( RULE_QUOTED_ID )
                    // InternalInstanceLanguage.g:1428:3: RULE_QUOTED_ID
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getStringOrIdAccess().getQUOTED_IDTerminalRuleCall_0()); 
                    }
                    match(input,RULE_QUOTED_ID,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getStringOrIdAccess().getQUOTED_IDTerminalRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalInstanceLanguage.g:1433:2: ( RULE_ID )
                    {
                    // InternalInstanceLanguage.g:1433:2: ( RULE_ID )
                    // InternalInstanceLanguage.g:1434:3: RULE_ID
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getStringOrIdAccess().getIDTerminalRuleCall_1()); 
                    }
                    match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getStringOrIdAccess().getIDTerminalRuleCall_1()); 
                    }

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
    // InternalInstanceLanguage.g:1443:1: rule__ComparisonOperatorRule__Alternatives : ( ( ( '>=' ) ) | ( ( '>' ) ) | ( ( '=' ) ) | ( ( '!=' ) ) | ( ( '<' ) ) | ( ( '<=' ) ) );
    public final void rule__ComparisonOperatorRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1447:1: ( ( ( '>=' ) ) | ( ( '>' ) ) | ( ( '=' ) ) | ( ( '!=' ) ) | ( ( '<' ) ) | ( ( '<=' ) ) )
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
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalInstanceLanguage.g:1448:2: ( ( '>=' ) )
                    {
                    // InternalInstanceLanguage.g:1448:2: ( ( '>=' ) )
                    // InternalInstanceLanguage.g:1449:3: ( '>=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getGreaterThanEnumLiteralDeclaration_0()); 
                    }
                    // InternalInstanceLanguage.g:1450:3: ( '>=' )
                    // InternalInstanceLanguage.g:1450:4: '>='
                    {
                    match(input,16,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getComparisonOperatorRuleAccess().getGreaterThanEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalInstanceLanguage.g:1454:2: ( ( '>' ) )
                    {
                    // InternalInstanceLanguage.g:1454:2: ( ( '>' ) )
                    // InternalInstanceLanguage.g:1455:3: ( '>' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getGreaterEqualEnumLiteralDeclaration_1()); 
                    }
                    // InternalInstanceLanguage.g:1456:3: ( '>' )
                    // InternalInstanceLanguage.g:1456:4: '>'
                    {
                    match(input,17,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getComparisonOperatorRuleAccess().getGreaterEqualEnumLiteralDeclaration_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalInstanceLanguage.g:1460:2: ( ( '=' ) )
                    {
                    // InternalInstanceLanguage.g:1460:2: ( ( '=' ) )
                    // InternalInstanceLanguage.g:1461:3: ( '=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getEqualEnumLiteralDeclaration_2()); 
                    }
                    // InternalInstanceLanguage.g:1462:3: ( '=' )
                    // InternalInstanceLanguage.g:1462:4: '='
                    {
                    match(input,18,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getComparisonOperatorRuleAccess().getEqualEnumLiteralDeclaration_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalInstanceLanguage.g:1466:2: ( ( '!=' ) )
                    {
                    // InternalInstanceLanguage.g:1466:2: ( ( '!=' ) )
                    // InternalInstanceLanguage.g:1467:3: ( '!=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getUnequalEnumLiteralDeclaration_3()); 
                    }
                    // InternalInstanceLanguage.g:1468:3: ( '!=' )
                    // InternalInstanceLanguage.g:1468:4: '!='
                    {
                    match(input,19,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getComparisonOperatorRuleAccess().getUnequalEnumLiteralDeclaration_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalInstanceLanguage.g:1472:2: ( ( '<' ) )
                    {
                    // InternalInstanceLanguage.g:1472:2: ( ( '<' ) )
                    // InternalInstanceLanguage.g:1473:3: ( '<' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getLessEqualEnumLiteralDeclaration_4()); 
                    }
                    // InternalInstanceLanguage.g:1474:3: ( '<' )
                    // InternalInstanceLanguage.g:1474:4: '<'
                    {
                    match(input,20,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getComparisonOperatorRuleAccess().getLessEqualEnumLiteralDeclaration_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalInstanceLanguage.g:1478:2: ( ( '<=' ) )
                    {
                    // InternalInstanceLanguage.g:1478:2: ( ( '<=' ) )
                    // InternalInstanceLanguage.g:1479:3: ( '<=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getLessThanEnumLiteralDeclaration_5()); 
                    }
                    // InternalInstanceLanguage.g:1480:3: ( '<=' )
                    // InternalInstanceLanguage.g:1480:4: '<='
                    {
                    match(input,21,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getComparisonOperatorRuleAccess().getLessThanEnumLiteralDeclaration_5()); 
                    }

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
    // InternalInstanceLanguage.g:1488:1: rule__AddOrSubtractOperatorRule__Alternatives : ( ( ( '+' ) ) | ( ( '-' ) ) );
    public final void rule__AddOrSubtractOperatorRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1492:1: ( ( ( '+' ) ) | ( ( '-' ) ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==22) ) {
                alt9=1;
            }
            else if ( (LA9_0==23) ) {
                alt9=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalInstanceLanguage.g:1493:2: ( ( '+' ) )
                    {
                    // InternalInstanceLanguage.g:1493:2: ( ( '+' ) )
                    // InternalInstanceLanguage.g:1494:3: ( '+' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAddOrSubtractOperatorRuleAccess().getAddEnumLiteralDeclaration_0()); 
                    }
                    // InternalInstanceLanguage.g:1495:3: ( '+' )
                    // InternalInstanceLanguage.g:1495:4: '+'
                    {
                    match(input,22,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAddOrSubtractOperatorRuleAccess().getAddEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalInstanceLanguage.g:1499:2: ( ( '-' ) )
                    {
                    // InternalInstanceLanguage.g:1499:2: ( ( '-' ) )
                    // InternalInstanceLanguage.g:1500:3: ( '-' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAddOrSubtractOperatorRuleAccess().getSubtractEnumLiteralDeclaration_1()); 
                    }
                    // InternalInstanceLanguage.g:1501:3: ( '-' )
                    // InternalInstanceLanguage.g:1501:4: '-'
                    {
                    match(input,23,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAddOrSubtractOperatorRuleAccess().getSubtractEnumLiteralDeclaration_1()); 
                    }

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
    // InternalInstanceLanguage.g:1509:1: rule__MultiplyDivideModuloOperatorRule__Alternatives : ( ( ( '*' ) ) | ( ( '/' ) ) | ( ( '%' ) ) );
    public final void rule__MultiplyDivideModuloOperatorRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1513:1: ( ( ( '*' ) ) | ( ( '/' ) ) | ( ( '%' ) ) )
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
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalInstanceLanguage.g:1514:2: ( ( '*' ) )
                    {
                    // InternalInstanceLanguage.g:1514:2: ( ( '*' ) )
                    // InternalInstanceLanguage.g:1515:3: ( '*' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getMultiplyEnumLiteralDeclaration_0()); 
                    }
                    // InternalInstanceLanguage.g:1516:3: ( '*' )
                    // InternalInstanceLanguage.g:1516:4: '*'
                    {
                    match(input,24,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getMultiplyEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalInstanceLanguage.g:1520:2: ( ( '/' ) )
                    {
                    // InternalInstanceLanguage.g:1520:2: ( ( '/' ) )
                    // InternalInstanceLanguage.g:1521:3: ( '/' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getDivideEnumLiteralDeclaration_1()); 
                    }
                    // InternalInstanceLanguage.g:1522:3: ( '/' )
                    // InternalInstanceLanguage.g:1522:4: '/'
                    {
                    match(input,25,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getDivideEnumLiteralDeclaration_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalInstanceLanguage.g:1526:2: ( ( '%' ) )
                    {
                    // InternalInstanceLanguage.g:1526:2: ( ( '%' ) )
                    // InternalInstanceLanguage.g:1527:3: ( '%' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getModuloEnumLiteralDeclaration_2()); 
                    }
                    // InternalInstanceLanguage.g:1528:3: ( '%' )
                    // InternalInstanceLanguage.g:1528:4: '%'
                    {
                    match(input,26,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getModuloEnumLiteralDeclaration_2()); 
                    }

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
    // InternalInstanceLanguage.g:1536:1: rule__FactorRule__Alternatives : ( ( ( 'Y' ) ) | ( ( 'Z' ) ) | ( ( 'E' ) ) | ( ( 'P' ) ) | ( ( 'T' ) ) | ( ( 'G' ) ) | ( ( 'M' ) ) | ( ( 'k' ) ) | ( ( 'h' ) ) | ( ( 'da' ) ) | ( ( 'd' ) ) | ( ( 'c' ) ) | ( ( 'm' ) ) | ( ( '\\u00B5' ) ) | ( ( 'n' ) ) | ( ( 'p' ) ) | ( ( 'f' ) ) | ( ( 'a' ) ) | ( ( 'z' ) ) | ( ( 'y' ) ) );
    public final void rule__FactorRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1540:1: ( ( ( 'Y' ) ) | ( ( 'Z' ) ) | ( ( 'E' ) ) | ( ( 'P' ) ) | ( ( 'T' ) ) | ( ( 'G' ) ) | ( ( 'M' ) ) | ( ( 'k' ) ) | ( ( 'h' ) ) | ( ( 'da' ) ) | ( ( 'd' ) ) | ( ( 'c' ) ) | ( ( 'm' ) ) | ( ( '\\u00B5' ) ) | ( ( 'n' ) ) | ( ( 'p' ) ) | ( ( 'f' ) ) | ( ( 'a' ) ) | ( ( 'z' ) ) | ( ( 'y' ) ) )
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
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // InternalInstanceLanguage.g:1541:2: ( ( 'Y' ) )
                    {
                    // InternalInstanceLanguage.g:1541:2: ( ( 'Y' ) )
                    // InternalInstanceLanguage.g:1542:3: ( 'Y' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getYottaEnumLiteralDeclaration_0()); 
                    }
                    // InternalInstanceLanguage.g:1543:3: ( 'Y' )
                    // InternalInstanceLanguage.g:1543:4: 'Y'
                    {
                    match(input,27,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getYottaEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalInstanceLanguage.g:1547:2: ( ( 'Z' ) )
                    {
                    // InternalInstanceLanguage.g:1547:2: ( ( 'Z' ) )
                    // InternalInstanceLanguage.g:1548:3: ( 'Z' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getZettaEnumLiteralDeclaration_1()); 
                    }
                    // InternalInstanceLanguage.g:1549:3: ( 'Z' )
                    // InternalInstanceLanguage.g:1549:4: 'Z'
                    {
                    match(input,28,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getZettaEnumLiteralDeclaration_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalInstanceLanguage.g:1553:2: ( ( 'E' ) )
                    {
                    // InternalInstanceLanguage.g:1553:2: ( ( 'E' ) )
                    // InternalInstanceLanguage.g:1554:3: ( 'E' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getExaEnumLiteralDeclaration_2()); 
                    }
                    // InternalInstanceLanguage.g:1555:3: ( 'E' )
                    // InternalInstanceLanguage.g:1555:4: 'E'
                    {
                    match(input,29,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getExaEnumLiteralDeclaration_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalInstanceLanguage.g:1559:2: ( ( 'P' ) )
                    {
                    // InternalInstanceLanguage.g:1559:2: ( ( 'P' ) )
                    // InternalInstanceLanguage.g:1560:3: ( 'P' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getPetaEnumLiteralDeclaration_3()); 
                    }
                    // InternalInstanceLanguage.g:1561:3: ( 'P' )
                    // InternalInstanceLanguage.g:1561:4: 'P'
                    {
                    match(input,30,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getPetaEnumLiteralDeclaration_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalInstanceLanguage.g:1565:2: ( ( 'T' ) )
                    {
                    // InternalInstanceLanguage.g:1565:2: ( ( 'T' ) )
                    // InternalInstanceLanguage.g:1566:3: ( 'T' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getTeraEnumLiteralDeclaration_4()); 
                    }
                    // InternalInstanceLanguage.g:1567:3: ( 'T' )
                    // InternalInstanceLanguage.g:1567:4: 'T'
                    {
                    match(input,31,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getTeraEnumLiteralDeclaration_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalInstanceLanguage.g:1571:2: ( ( 'G' ) )
                    {
                    // InternalInstanceLanguage.g:1571:2: ( ( 'G' ) )
                    // InternalInstanceLanguage.g:1572:3: ( 'G' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getGigaEnumLiteralDeclaration_5()); 
                    }
                    // InternalInstanceLanguage.g:1573:3: ( 'G' )
                    // InternalInstanceLanguage.g:1573:4: 'G'
                    {
                    match(input,32,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getGigaEnumLiteralDeclaration_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalInstanceLanguage.g:1577:2: ( ( 'M' ) )
                    {
                    // InternalInstanceLanguage.g:1577:2: ( ( 'M' ) )
                    // InternalInstanceLanguage.g:1578:3: ( 'M' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getMegaEnumLiteralDeclaration_6()); 
                    }
                    // InternalInstanceLanguage.g:1579:3: ( 'M' )
                    // InternalInstanceLanguage.g:1579:4: 'M'
                    {
                    match(input,33,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getMegaEnumLiteralDeclaration_6()); 
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalInstanceLanguage.g:1583:2: ( ( 'k' ) )
                    {
                    // InternalInstanceLanguage.g:1583:2: ( ( 'k' ) )
                    // InternalInstanceLanguage.g:1584:3: ( 'k' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getKiloEnumLiteralDeclaration_7()); 
                    }
                    // InternalInstanceLanguage.g:1585:3: ( 'k' )
                    // InternalInstanceLanguage.g:1585:4: 'k'
                    {
                    match(input,34,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getKiloEnumLiteralDeclaration_7()); 
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalInstanceLanguage.g:1589:2: ( ( 'h' ) )
                    {
                    // InternalInstanceLanguage.g:1589:2: ( ( 'h' ) )
                    // InternalInstanceLanguage.g:1590:3: ( 'h' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getHectoEnumLiteralDeclaration_8()); 
                    }
                    // InternalInstanceLanguage.g:1591:3: ( 'h' )
                    // InternalInstanceLanguage.g:1591:4: 'h'
                    {
                    match(input,35,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getHectoEnumLiteralDeclaration_8()); 
                    }

                    }


                    }
                    break;
                case 10 :
                    // InternalInstanceLanguage.g:1595:2: ( ( 'da' ) )
                    {
                    // InternalInstanceLanguage.g:1595:2: ( ( 'da' ) )
                    // InternalInstanceLanguage.g:1596:3: ( 'da' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getDekaEnumLiteralDeclaration_9()); 
                    }
                    // InternalInstanceLanguage.g:1597:3: ( 'da' )
                    // InternalInstanceLanguage.g:1597:4: 'da'
                    {
                    match(input,36,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getDekaEnumLiteralDeclaration_9()); 
                    }

                    }


                    }
                    break;
                case 11 :
                    // InternalInstanceLanguage.g:1601:2: ( ( 'd' ) )
                    {
                    // InternalInstanceLanguage.g:1601:2: ( ( 'd' ) )
                    // InternalInstanceLanguage.g:1602:3: ( 'd' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getDeciEnumLiteralDeclaration_10()); 
                    }
                    // InternalInstanceLanguage.g:1603:3: ( 'd' )
                    // InternalInstanceLanguage.g:1603:4: 'd'
                    {
                    match(input,37,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getDeciEnumLiteralDeclaration_10()); 
                    }

                    }


                    }
                    break;
                case 12 :
                    // InternalInstanceLanguage.g:1607:2: ( ( 'c' ) )
                    {
                    // InternalInstanceLanguage.g:1607:2: ( ( 'c' ) )
                    // InternalInstanceLanguage.g:1608:3: ( 'c' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getCentiEnumLiteralDeclaration_11()); 
                    }
                    // InternalInstanceLanguage.g:1609:3: ( 'c' )
                    // InternalInstanceLanguage.g:1609:4: 'c'
                    {
                    match(input,38,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getCentiEnumLiteralDeclaration_11()); 
                    }

                    }


                    }
                    break;
                case 13 :
                    // InternalInstanceLanguage.g:1613:2: ( ( 'm' ) )
                    {
                    // InternalInstanceLanguage.g:1613:2: ( ( 'm' ) )
                    // InternalInstanceLanguage.g:1614:3: ( 'm' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getMilliEnumLiteralDeclaration_12()); 
                    }
                    // InternalInstanceLanguage.g:1615:3: ( 'm' )
                    // InternalInstanceLanguage.g:1615:4: 'm'
                    {
                    match(input,39,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getMilliEnumLiteralDeclaration_12()); 
                    }

                    }


                    }
                    break;
                case 14 :
                    // InternalInstanceLanguage.g:1619:2: ( ( '\\u00B5' ) )
                    {
                    // InternalInstanceLanguage.g:1619:2: ( ( '\\u00B5' ) )
                    // InternalInstanceLanguage.g:1620:3: ( '\\u00B5' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getMicroEnumLiteralDeclaration_13()); 
                    }
                    // InternalInstanceLanguage.g:1621:3: ( '\\u00B5' )
                    // InternalInstanceLanguage.g:1621:4: '\\u00B5'
                    {
                    match(input,40,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getMicroEnumLiteralDeclaration_13()); 
                    }

                    }


                    }
                    break;
                case 15 :
                    // InternalInstanceLanguage.g:1625:2: ( ( 'n' ) )
                    {
                    // InternalInstanceLanguage.g:1625:2: ( ( 'n' ) )
                    // InternalInstanceLanguage.g:1626:3: ( 'n' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getNanoEnumLiteralDeclaration_14()); 
                    }
                    // InternalInstanceLanguage.g:1627:3: ( 'n' )
                    // InternalInstanceLanguage.g:1627:4: 'n'
                    {
                    match(input,41,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getNanoEnumLiteralDeclaration_14()); 
                    }

                    }


                    }
                    break;
                case 16 :
                    // InternalInstanceLanguage.g:1631:2: ( ( 'p' ) )
                    {
                    // InternalInstanceLanguage.g:1631:2: ( ( 'p' ) )
                    // InternalInstanceLanguage.g:1632:3: ( 'p' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getPikoEnumLiteralDeclaration_15()); 
                    }
                    // InternalInstanceLanguage.g:1633:3: ( 'p' )
                    // InternalInstanceLanguage.g:1633:4: 'p'
                    {
                    match(input,42,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getPikoEnumLiteralDeclaration_15()); 
                    }

                    }


                    }
                    break;
                case 17 :
                    // InternalInstanceLanguage.g:1637:2: ( ( 'f' ) )
                    {
                    // InternalInstanceLanguage.g:1637:2: ( ( 'f' ) )
                    // InternalInstanceLanguage.g:1638:3: ( 'f' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getFemtoEnumLiteralDeclaration_16()); 
                    }
                    // InternalInstanceLanguage.g:1639:3: ( 'f' )
                    // InternalInstanceLanguage.g:1639:4: 'f'
                    {
                    match(input,43,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getFemtoEnumLiteralDeclaration_16()); 
                    }

                    }


                    }
                    break;
                case 18 :
                    // InternalInstanceLanguage.g:1643:2: ( ( 'a' ) )
                    {
                    // InternalInstanceLanguage.g:1643:2: ( ( 'a' ) )
                    // InternalInstanceLanguage.g:1644:3: ( 'a' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getAttoEnumLiteralDeclaration_17()); 
                    }
                    // InternalInstanceLanguage.g:1645:3: ( 'a' )
                    // InternalInstanceLanguage.g:1645:4: 'a'
                    {
                    match(input,44,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getAttoEnumLiteralDeclaration_17()); 
                    }

                    }


                    }
                    break;
                case 19 :
                    // InternalInstanceLanguage.g:1649:2: ( ( 'z' ) )
                    {
                    // InternalInstanceLanguage.g:1649:2: ( ( 'z' ) )
                    // InternalInstanceLanguage.g:1650:3: ( 'z' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getZeptoEnumLiteralDeclaration_18()); 
                    }
                    // InternalInstanceLanguage.g:1651:3: ( 'z' )
                    // InternalInstanceLanguage.g:1651:4: 'z'
                    {
                    match(input,45,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getZeptoEnumLiteralDeclaration_18()); 
                    }

                    }


                    }
                    break;
                case 20 :
                    // InternalInstanceLanguage.g:1655:2: ( ( 'y' ) )
                    {
                    // InternalInstanceLanguage.g:1655:2: ( ( 'y' ) )
                    // InternalInstanceLanguage.g:1656:3: ( 'y' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getYoctoEnumLiteralDeclaration_19()); 
                    }
                    // InternalInstanceLanguage.g:1657:3: ( 'y' )
                    // InternalInstanceLanguage.g:1657:4: 'y'
                    {
                    match(input,46,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getYoctoEnumLiteralDeclaration_19()); 
                    }

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


    // $ANTLR start "rule__InstanceModuleRule__Group__0"
    // InternalInstanceLanguage.g:1665:1: rule__InstanceModuleRule__Group__0 : rule__InstanceModuleRule__Group__0__Impl rule__InstanceModuleRule__Group__1 ;
    public final void rule__InstanceModuleRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1669:1: ( rule__InstanceModuleRule__Group__0__Impl rule__InstanceModuleRule__Group__1 )
            // InternalInstanceLanguage.g:1670:2: rule__InstanceModuleRule__Group__0__Impl rule__InstanceModuleRule__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__InstanceModuleRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__InstanceModuleRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceModuleRule__Group__0"


    // $ANTLR start "rule__InstanceModuleRule__Group__0__Impl"
    // InternalInstanceLanguage.g:1677:1: rule__InstanceModuleRule__Group__0__Impl : ( () ) ;
    public final void rule__InstanceModuleRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1681:1: ( ( () ) )
            // InternalInstanceLanguage.g:1682:1: ( () )
            {
            // InternalInstanceLanguage.g:1682:1: ( () )
            // InternalInstanceLanguage.g:1683:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceModuleRuleAccess().getInstanceModuleAction_0()); 
            }
            // InternalInstanceLanguage.g:1684:2: ()
            // InternalInstanceLanguage.g:1684:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getInstanceModuleRuleAccess().getInstanceModuleAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceModuleRule__Group__0__Impl"


    // $ANTLR start "rule__InstanceModuleRule__Group__1"
    // InternalInstanceLanguage.g:1692:1: rule__InstanceModuleRule__Group__1 : rule__InstanceModuleRule__Group__1__Impl rule__InstanceModuleRule__Group__2 ;
    public final void rule__InstanceModuleRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1696:1: ( rule__InstanceModuleRule__Group__1__Impl rule__InstanceModuleRule__Group__2 )
            // InternalInstanceLanguage.g:1697:2: rule__InstanceModuleRule__Group__1__Impl rule__InstanceModuleRule__Group__2
            {
            pushFollow(FOLLOW_3);
            rule__InstanceModuleRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__InstanceModuleRule__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceModuleRule__Group__1"


    // $ANTLR start "rule__InstanceModuleRule__Group__1__Impl"
    // InternalInstanceLanguage.g:1704:1: rule__InstanceModuleRule__Group__1__Impl : ( ( rule__InstanceModuleRule__ImportsAssignment_1 )* ) ;
    public final void rule__InstanceModuleRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1708:1: ( ( ( rule__InstanceModuleRule__ImportsAssignment_1 )* ) )
            // InternalInstanceLanguage.g:1709:1: ( ( rule__InstanceModuleRule__ImportsAssignment_1 )* )
            {
            // InternalInstanceLanguage.g:1709:1: ( ( rule__InstanceModuleRule__ImportsAssignment_1 )* )
            // InternalInstanceLanguage.g:1710:2: ( rule__InstanceModuleRule__ImportsAssignment_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceModuleRuleAccess().getImportsAssignment_1()); 
            }
            // InternalInstanceLanguage.g:1711:2: ( rule__InstanceModuleRule__ImportsAssignment_1 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==73) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalInstanceLanguage.g:1711:3: rule__InstanceModuleRule__ImportsAssignment_1
            	    {
            	    pushFollow(FOLLOW_4);
            	    rule__InstanceModuleRule__ImportsAssignment_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getInstanceModuleRuleAccess().getImportsAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceModuleRule__Group__1__Impl"


    // $ANTLR start "rule__InstanceModuleRule__Group__2"
    // InternalInstanceLanguage.g:1719:1: rule__InstanceModuleRule__Group__2 : rule__InstanceModuleRule__Group__2__Impl rule__InstanceModuleRule__Group__3 ;
    public final void rule__InstanceModuleRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1723:1: ( rule__InstanceModuleRule__Group__2__Impl rule__InstanceModuleRule__Group__3 )
            // InternalInstanceLanguage.g:1724:2: rule__InstanceModuleRule__Group__2__Impl rule__InstanceModuleRule__Group__3
            {
            pushFollow(FOLLOW_5);
            rule__InstanceModuleRule__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__InstanceModuleRule__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceModuleRule__Group__2"


    // $ANTLR start "rule__InstanceModuleRule__Group__2__Impl"
    // InternalInstanceLanguage.g:1731:1: rule__InstanceModuleRule__Group__2__Impl : ( 'instances' ) ;
    public final void rule__InstanceModuleRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1735:1: ( ( 'instances' ) )
            // InternalInstanceLanguage.g:1736:1: ( 'instances' )
            {
            // InternalInstanceLanguage.g:1736:1: ( 'instances' )
            // InternalInstanceLanguage.g:1737:2: 'instances'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceModuleRuleAccess().getInstancesKeyword_2()); 
            }
            match(input,47,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getInstanceModuleRuleAccess().getInstancesKeyword_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceModuleRule__Group__2__Impl"


    // $ANTLR start "rule__InstanceModuleRule__Group__3"
    // InternalInstanceLanguage.g:1746:1: rule__InstanceModuleRule__Group__3 : rule__InstanceModuleRule__Group__3__Impl rule__InstanceModuleRule__Group__4 ;
    public final void rule__InstanceModuleRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1750:1: ( rule__InstanceModuleRule__Group__3__Impl rule__InstanceModuleRule__Group__4 )
            // InternalInstanceLanguage.g:1751:2: rule__InstanceModuleRule__Group__3__Impl rule__InstanceModuleRule__Group__4
            {
            pushFollow(FOLLOW_6);
            rule__InstanceModuleRule__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__InstanceModuleRule__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceModuleRule__Group__3"


    // $ANTLR start "rule__InstanceModuleRule__Group__3__Impl"
    // InternalInstanceLanguage.g:1758:1: rule__InstanceModuleRule__Group__3__Impl : ( '=' ) ;
    public final void rule__InstanceModuleRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1762:1: ( ( '=' ) )
            // InternalInstanceLanguage.g:1763:1: ( '=' )
            {
            // InternalInstanceLanguage.g:1763:1: ( '=' )
            // InternalInstanceLanguage.g:1764:2: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceModuleRuleAccess().getEqualsSignKeyword_3()); 
            }
            match(input,18,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getInstanceModuleRuleAccess().getEqualsSignKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceModuleRule__Group__3__Impl"


    // $ANTLR start "rule__InstanceModuleRule__Group__4"
    // InternalInstanceLanguage.g:1773:1: rule__InstanceModuleRule__Group__4 : rule__InstanceModuleRule__Group__4__Impl rule__InstanceModuleRule__Group__5 ;
    public final void rule__InstanceModuleRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1777:1: ( rule__InstanceModuleRule__Group__4__Impl rule__InstanceModuleRule__Group__5 )
            // InternalInstanceLanguage.g:1778:2: rule__InstanceModuleRule__Group__4__Impl rule__InstanceModuleRule__Group__5
            {
            pushFollow(FOLLOW_7);
            rule__InstanceModuleRule__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__InstanceModuleRule__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceModuleRule__Group__4"


    // $ANTLR start "rule__InstanceModuleRule__Group__4__Impl"
    // InternalInstanceLanguage.g:1785:1: rule__InstanceModuleRule__Group__4__Impl : ( '[' ) ;
    public final void rule__InstanceModuleRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1789:1: ( ( '[' ) )
            // InternalInstanceLanguage.g:1790:1: ( '[' )
            {
            // InternalInstanceLanguage.g:1790:1: ( '[' )
            // InternalInstanceLanguage.g:1791:2: '['
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceModuleRuleAccess().getLeftSquareBracketKeyword_4()); 
            }
            match(input,48,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getInstanceModuleRuleAccess().getLeftSquareBracketKeyword_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceModuleRule__Group__4__Impl"


    // $ANTLR start "rule__InstanceModuleRule__Group__5"
    // InternalInstanceLanguage.g:1800:1: rule__InstanceModuleRule__Group__5 : rule__InstanceModuleRule__Group__5__Impl rule__InstanceModuleRule__Group__6 ;
    public final void rule__InstanceModuleRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1804:1: ( rule__InstanceModuleRule__Group__5__Impl rule__InstanceModuleRule__Group__6 )
            // InternalInstanceLanguage.g:1805:2: rule__InstanceModuleRule__Group__5__Impl rule__InstanceModuleRule__Group__6
            {
            pushFollow(FOLLOW_7);
            rule__InstanceModuleRule__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__InstanceModuleRule__Group__6();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceModuleRule__Group__5"


    // $ANTLR start "rule__InstanceModuleRule__Group__5__Impl"
    // InternalInstanceLanguage.g:1812:1: rule__InstanceModuleRule__Group__5__Impl : ( ( rule__InstanceModuleRule__Group_5__0 )? ) ;
    public final void rule__InstanceModuleRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1816:1: ( ( ( rule__InstanceModuleRule__Group_5__0 )? ) )
            // InternalInstanceLanguage.g:1817:1: ( ( rule__InstanceModuleRule__Group_5__0 )? )
            {
            // InternalInstanceLanguage.g:1817:1: ( ( rule__InstanceModuleRule__Group_5__0 )? )
            // InternalInstanceLanguage.g:1818:2: ( rule__InstanceModuleRule__Group_5__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceModuleRuleAccess().getGroup_5()); 
            }
            // InternalInstanceLanguage.g:1819:2: ( rule__InstanceModuleRule__Group_5__0 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==51) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalInstanceLanguage.g:1819:3: rule__InstanceModuleRule__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__InstanceModuleRule__Group_5__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getInstanceModuleRuleAccess().getGroup_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceModuleRule__Group__5__Impl"


    // $ANTLR start "rule__InstanceModuleRule__Group__6"
    // InternalInstanceLanguage.g:1827:1: rule__InstanceModuleRule__Group__6 : rule__InstanceModuleRule__Group__6__Impl rule__InstanceModuleRule__Group__7 ;
    public final void rule__InstanceModuleRule__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1831:1: ( rule__InstanceModuleRule__Group__6__Impl rule__InstanceModuleRule__Group__7 )
            // InternalInstanceLanguage.g:1832:2: rule__InstanceModuleRule__Group__6__Impl rule__InstanceModuleRule__Group__7
            {
            pushFollow(FOLLOW_8);
            rule__InstanceModuleRule__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__InstanceModuleRule__Group__7();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceModuleRule__Group__6"


    // $ANTLR start "rule__InstanceModuleRule__Group__6__Impl"
    // InternalInstanceLanguage.g:1839:1: rule__InstanceModuleRule__Group__6__Impl : ( ']' ) ;
    public final void rule__InstanceModuleRule__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1843:1: ( ( ']' ) )
            // InternalInstanceLanguage.g:1844:1: ( ']' )
            {
            // InternalInstanceLanguage.g:1844:1: ( ']' )
            // InternalInstanceLanguage.g:1845:2: ']'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceModuleRuleAccess().getRightSquareBracketKeyword_6()); 
            }
            match(input,49,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getInstanceModuleRuleAccess().getRightSquareBracketKeyword_6()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceModuleRule__Group__6__Impl"


    // $ANTLR start "rule__InstanceModuleRule__Group__7"
    // InternalInstanceLanguage.g:1854:1: rule__InstanceModuleRule__Group__7 : rule__InstanceModuleRule__Group__7__Impl ;
    public final void rule__InstanceModuleRule__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1858:1: ( rule__InstanceModuleRule__Group__7__Impl )
            // InternalInstanceLanguage.g:1859:2: rule__InstanceModuleRule__Group__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__InstanceModuleRule__Group__7__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceModuleRule__Group__7"


    // $ANTLR start "rule__InstanceModuleRule__Group__7__Impl"
    // InternalInstanceLanguage.g:1865:1: rule__InstanceModuleRule__Group__7__Impl : ( ';' ) ;
    public final void rule__InstanceModuleRule__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1869:1: ( ( ';' ) )
            // InternalInstanceLanguage.g:1870:1: ( ';' )
            {
            // InternalInstanceLanguage.g:1870:1: ( ';' )
            // InternalInstanceLanguage.g:1871:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceModuleRuleAccess().getSemicolonKeyword_7()); 
            }
            match(input,50,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getInstanceModuleRuleAccess().getSemicolonKeyword_7()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceModuleRule__Group__7__Impl"


    // $ANTLR start "rule__InstanceModuleRule__Group_5__0"
    // InternalInstanceLanguage.g:1881:1: rule__InstanceModuleRule__Group_5__0 : rule__InstanceModuleRule__Group_5__0__Impl rule__InstanceModuleRule__Group_5__1 ;
    public final void rule__InstanceModuleRule__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1885:1: ( rule__InstanceModuleRule__Group_5__0__Impl rule__InstanceModuleRule__Group_5__1 )
            // InternalInstanceLanguage.g:1886:2: rule__InstanceModuleRule__Group_5__0__Impl rule__InstanceModuleRule__Group_5__1
            {
            pushFollow(FOLLOW_9);
            rule__InstanceModuleRule__Group_5__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__InstanceModuleRule__Group_5__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceModuleRule__Group_5__0"


    // $ANTLR start "rule__InstanceModuleRule__Group_5__0__Impl"
    // InternalInstanceLanguage.g:1893:1: rule__InstanceModuleRule__Group_5__0__Impl : ( 'instance' ) ;
    public final void rule__InstanceModuleRule__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1897:1: ( ( 'instance' ) )
            // InternalInstanceLanguage.g:1898:1: ( 'instance' )
            {
            // InternalInstanceLanguage.g:1898:1: ( 'instance' )
            // InternalInstanceLanguage.g:1899:2: 'instance'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceModuleRuleAccess().getInstanceKeyword_5_0()); 
            }
            match(input,51,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getInstanceModuleRuleAccess().getInstanceKeyword_5_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceModuleRule__Group_5__0__Impl"


    // $ANTLR start "rule__InstanceModuleRule__Group_5__1"
    // InternalInstanceLanguage.g:1908:1: rule__InstanceModuleRule__Group_5__1 : rule__InstanceModuleRule__Group_5__1__Impl rule__InstanceModuleRule__Group_5__2 ;
    public final void rule__InstanceModuleRule__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1912:1: ( rule__InstanceModuleRule__Group_5__1__Impl rule__InstanceModuleRule__Group_5__2 )
            // InternalInstanceLanguage.g:1913:2: rule__InstanceModuleRule__Group_5__1__Impl rule__InstanceModuleRule__Group_5__2
            {
            pushFollow(FOLLOW_10);
            rule__InstanceModuleRule__Group_5__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__InstanceModuleRule__Group_5__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceModuleRule__Group_5__1"


    // $ANTLR start "rule__InstanceModuleRule__Group_5__1__Impl"
    // InternalInstanceLanguage.g:1920:1: rule__InstanceModuleRule__Group_5__1__Impl : ( ( rule__InstanceModuleRule__InstancesAssignment_5_1 ) ) ;
    public final void rule__InstanceModuleRule__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1924:1: ( ( ( rule__InstanceModuleRule__InstancesAssignment_5_1 ) ) )
            // InternalInstanceLanguage.g:1925:1: ( ( rule__InstanceModuleRule__InstancesAssignment_5_1 ) )
            {
            // InternalInstanceLanguage.g:1925:1: ( ( rule__InstanceModuleRule__InstancesAssignment_5_1 ) )
            // InternalInstanceLanguage.g:1926:2: ( rule__InstanceModuleRule__InstancesAssignment_5_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceModuleRuleAccess().getInstancesAssignment_5_1()); 
            }
            // InternalInstanceLanguage.g:1927:2: ( rule__InstanceModuleRule__InstancesAssignment_5_1 )
            // InternalInstanceLanguage.g:1927:3: rule__InstanceModuleRule__InstancesAssignment_5_1
            {
            pushFollow(FOLLOW_2);
            rule__InstanceModuleRule__InstancesAssignment_5_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getInstanceModuleRuleAccess().getInstancesAssignment_5_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceModuleRule__Group_5__1__Impl"


    // $ANTLR start "rule__InstanceModuleRule__Group_5__2"
    // InternalInstanceLanguage.g:1935:1: rule__InstanceModuleRule__Group_5__2 : rule__InstanceModuleRule__Group_5__2__Impl ;
    public final void rule__InstanceModuleRule__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1939:1: ( rule__InstanceModuleRule__Group_5__2__Impl )
            // InternalInstanceLanguage.g:1940:2: rule__InstanceModuleRule__Group_5__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__InstanceModuleRule__Group_5__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceModuleRule__Group_5__2"


    // $ANTLR start "rule__InstanceModuleRule__Group_5__2__Impl"
    // InternalInstanceLanguage.g:1946:1: rule__InstanceModuleRule__Group_5__2__Impl : ( ( rule__InstanceModuleRule__Group_5_2__0 )* ) ;
    public final void rule__InstanceModuleRule__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1950:1: ( ( ( rule__InstanceModuleRule__Group_5_2__0 )* ) )
            // InternalInstanceLanguage.g:1951:1: ( ( rule__InstanceModuleRule__Group_5_2__0 )* )
            {
            // InternalInstanceLanguage.g:1951:1: ( ( rule__InstanceModuleRule__Group_5_2__0 )* )
            // InternalInstanceLanguage.g:1952:2: ( rule__InstanceModuleRule__Group_5_2__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceModuleRuleAccess().getGroup_5_2()); 
            }
            // InternalInstanceLanguage.g:1953:2: ( rule__InstanceModuleRule__Group_5_2__0 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==52) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalInstanceLanguage.g:1953:3: rule__InstanceModuleRule__Group_5_2__0
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__InstanceModuleRule__Group_5_2__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getInstanceModuleRuleAccess().getGroup_5_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceModuleRule__Group_5__2__Impl"


    // $ANTLR start "rule__InstanceModuleRule__Group_5_2__0"
    // InternalInstanceLanguage.g:1962:1: rule__InstanceModuleRule__Group_5_2__0 : rule__InstanceModuleRule__Group_5_2__0__Impl rule__InstanceModuleRule__Group_5_2__1 ;
    public final void rule__InstanceModuleRule__Group_5_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1966:1: ( rule__InstanceModuleRule__Group_5_2__0__Impl rule__InstanceModuleRule__Group_5_2__1 )
            // InternalInstanceLanguage.g:1967:2: rule__InstanceModuleRule__Group_5_2__0__Impl rule__InstanceModuleRule__Group_5_2__1
            {
            pushFollow(FOLLOW_12);
            rule__InstanceModuleRule__Group_5_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__InstanceModuleRule__Group_5_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceModuleRule__Group_5_2__0"


    // $ANTLR start "rule__InstanceModuleRule__Group_5_2__0__Impl"
    // InternalInstanceLanguage.g:1974:1: rule__InstanceModuleRule__Group_5_2__0__Impl : ( ',' ) ;
    public final void rule__InstanceModuleRule__Group_5_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1978:1: ( ( ',' ) )
            // InternalInstanceLanguage.g:1979:1: ( ',' )
            {
            // InternalInstanceLanguage.g:1979:1: ( ',' )
            // InternalInstanceLanguage.g:1980:2: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceModuleRuleAccess().getCommaKeyword_5_2_0()); 
            }
            match(input,52,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getInstanceModuleRuleAccess().getCommaKeyword_5_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceModuleRule__Group_5_2__0__Impl"


    // $ANTLR start "rule__InstanceModuleRule__Group_5_2__1"
    // InternalInstanceLanguage.g:1989:1: rule__InstanceModuleRule__Group_5_2__1 : rule__InstanceModuleRule__Group_5_2__1__Impl rule__InstanceModuleRule__Group_5_2__2 ;
    public final void rule__InstanceModuleRule__Group_5_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1993:1: ( rule__InstanceModuleRule__Group_5_2__1__Impl rule__InstanceModuleRule__Group_5_2__2 )
            // InternalInstanceLanguage.g:1994:2: rule__InstanceModuleRule__Group_5_2__1__Impl rule__InstanceModuleRule__Group_5_2__2
            {
            pushFollow(FOLLOW_9);
            rule__InstanceModuleRule__Group_5_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__InstanceModuleRule__Group_5_2__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceModuleRule__Group_5_2__1"


    // $ANTLR start "rule__InstanceModuleRule__Group_5_2__1__Impl"
    // InternalInstanceLanguage.g:2001:1: rule__InstanceModuleRule__Group_5_2__1__Impl : ( 'instance' ) ;
    public final void rule__InstanceModuleRule__Group_5_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2005:1: ( ( 'instance' ) )
            // InternalInstanceLanguage.g:2006:1: ( 'instance' )
            {
            // InternalInstanceLanguage.g:2006:1: ( 'instance' )
            // InternalInstanceLanguage.g:2007:2: 'instance'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceModuleRuleAccess().getInstanceKeyword_5_2_1()); 
            }
            match(input,51,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getInstanceModuleRuleAccess().getInstanceKeyword_5_2_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceModuleRule__Group_5_2__1__Impl"


    // $ANTLR start "rule__InstanceModuleRule__Group_5_2__2"
    // InternalInstanceLanguage.g:2016:1: rule__InstanceModuleRule__Group_5_2__2 : rule__InstanceModuleRule__Group_5_2__2__Impl ;
    public final void rule__InstanceModuleRule__Group_5_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2020:1: ( rule__InstanceModuleRule__Group_5_2__2__Impl )
            // InternalInstanceLanguage.g:2021:2: rule__InstanceModuleRule__Group_5_2__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__InstanceModuleRule__Group_5_2__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceModuleRule__Group_5_2__2"


    // $ANTLR start "rule__InstanceModuleRule__Group_5_2__2__Impl"
    // InternalInstanceLanguage.g:2027:1: rule__InstanceModuleRule__Group_5_2__2__Impl : ( ( rule__InstanceModuleRule__InstancesAssignment_5_2_2 ) ) ;
    public final void rule__InstanceModuleRule__Group_5_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2031:1: ( ( ( rule__InstanceModuleRule__InstancesAssignment_5_2_2 ) ) )
            // InternalInstanceLanguage.g:2032:1: ( ( rule__InstanceModuleRule__InstancesAssignment_5_2_2 ) )
            {
            // InternalInstanceLanguage.g:2032:1: ( ( rule__InstanceModuleRule__InstancesAssignment_5_2_2 ) )
            // InternalInstanceLanguage.g:2033:2: ( rule__InstanceModuleRule__InstancesAssignment_5_2_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceModuleRuleAccess().getInstancesAssignment_5_2_2()); 
            }
            // InternalInstanceLanguage.g:2034:2: ( rule__InstanceModuleRule__InstancesAssignment_5_2_2 )
            // InternalInstanceLanguage.g:2034:3: rule__InstanceModuleRule__InstancesAssignment_5_2_2
            {
            pushFollow(FOLLOW_2);
            rule__InstanceModuleRule__InstancesAssignment_5_2_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getInstanceModuleRuleAccess().getInstancesAssignment_5_2_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceModuleRule__Group_5_2__2__Impl"


    // $ANTLR start "rule__OrExpressionRule__Group__0"
    // InternalInstanceLanguage.g:2043:1: rule__OrExpressionRule__Group__0 : rule__OrExpressionRule__Group__0__Impl rule__OrExpressionRule__Group__1 ;
    public final void rule__OrExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2047:1: ( rule__OrExpressionRule__Group__0__Impl rule__OrExpressionRule__Group__1 )
            // InternalInstanceLanguage.g:2048:2: rule__OrExpressionRule__Group__0__Impl rule__OrExpressionRule__Group__1
            {
            pushFollow(FOLLOW_13);
            rule__OrExpressionRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__OrExpressionRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:2055:1: rule__OrExpressionRule__Group__0__Impl : ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) ) ;
    public final void rule__OrExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2059:1: ( ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) ) )
            // InternalInstanceLanguage.g:2060:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) )
            {
            // InternalInstanceLanguage.g:2060:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) )
            // InternalInstanceLanguage.g:2061:2: ( rule__OrExpressionRule__SubExpressionsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsAssignment_0()); 
            }
            // InternalInstanceLanguage.g:2062:2: ( rule__OrExpressionRule__SubExpressionsAssignment_0 )
            // InternalInstanceLanguage.g:2062:3: rule__OrExpressionRule__SubExpressionsAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__OrExpressionRule__SubExpressionsAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsAssignment_0()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:2070:1: rule__OrExpressionRule__Group__1 : rule__OrExpressionRule__Group__1__Impl ;
    public final void rule__OrExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2074:1: ( rule__OrExpressionRule__Group__1__Impl )
            // InternalInstanceLanguage.g:2075:2: rule__OrExpressionRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OrExpressionRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:2081:1: rule__OrExpressionRule__Group__1__Impl : ( ( rule__OrExpressionRule__Group_1__0 )* ) ;
    public final void rule__OrExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2085:1: ( ( ( rule__OrExpressionRule__Group_1__0 )* ) )
            // InternalInstanceLanguage.g:2086:1: ( ( rule__OrExpressionRule__Group_1__0 )* )
            {
            // InternalInstanceLanguage.g:2086:1: ( ( rule__OrExpressionRule__Group_1__0 )* )
            // InternalInstanceLanguage.g:2087:2: ( rule__OrExpressionRule__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionRuleAccess().getGroup_1()); 
            }
            // InternalInstanceLanguage.g:2088:2: ( rule__OrExpressionRule__Group_1__0 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==53) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalInstanceLanguage.g:2088:3: rule__OrExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_14);
            	    rule__OrExpressionRule__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOrExpressionRuleAccess().getGroup_1()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:2097:1: rule__OrExpressionRule__Group_1__0 : rule__OrExpressionRule__Group_1__0__Impl rule__OrExpressionRule__Group_1__1 ;
    public final void rule__OrExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2101:1: ( rule__OrExpressionRule__Group_1__0__Impl rule__OrExpressionRule__Group_1__1 )
            // InternalInstanceLanguage.g:2102:2: rule__OrExpressionRule__Group_1__0__Impl rule__OrExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_15);
            rule__OrExpressionRule__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__OrExpressionRule__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:2109:1: rule__OrExpressionRule__Group_1__0__Impl : ( 'OR' ) ;
    public final void rule__OrExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2113:1: ( ( 'OR' ) )
            // InternalInstanceLanguage.g:2114:1: ( 'OR' )
            {
            // InternalInstanceLanguage.g:2114:1: ( 'OR' )
            // InternalInstanceLanguage.g:2115:2: 'OR'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionRuleAccess().getORKeyword_1_0()); 
            }
            match(input,53,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOrExpressionRuleAccess().getORKeyword_1_0()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:2124:1: rule__OrExpressionRule__Group_1__1 : rule__OrExpressionRule__Group_1__1__Impl ;
    public final void rule__OrExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2128:1: ( rule__OrExpressionRule__Group_1__1__Impl )
            // InternalInstanceLanguage.g:2129:2: rule__OrExpressionRule__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OrExpressionRule__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:2135:1: rule__OrExpressionRule__Group_1__1__Impl : ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) ) ;
    public final void rule__OrExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2139:1: ( ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) ) )
            // InternalInstanceLanguage.g:2140:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) )
            {
            // InternalInstanceLanguage.g:2140:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) )
            // InternalInstanceLanguage.g:2141:2: ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsAssignment_1_1()); 
            }
            // InternalInstanceLanguage.g:2142:2: ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 )
            // InternalInstanceLanguage.g:2142:3: rule__OrExpressionRule__SubExpressionsAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__OrExpressionRule__SubExpressionsAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsAssignment_1_1()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:2151:1: rule__XorExpressionRule__Group__0 : rule__XorExpressionRule__Group__0__Impl rule__XorExpressionRule__Group__1 ;
    public final void rule__XorExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2155:1: ( rule__XorExpressionRule__Group__0__Impl rule__XorExpressionRule__Group__1 )
            // InternalInstanceLanguage.g:2156:2: rule__XorExpressionRule__Group__0__Impl rule__XorExpressionRule__Group__1
            {
            pushFollow(FOLLOW_16);
            rule__XorExpressionRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XorExpressionRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:2163:1: rule__XorExpressionRule__Group__0__Impl : ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) ) ;
    public final void rule__XorExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2167:1: ( ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) ) )
            // InternalInstanceLanguage.g:2168:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) )
            {
            // InternalInstanceLanguage.g:2168:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) )
            // InternalInstanceLanguage.g:2169:2: ( rule__XorExpressionRule__SubExpressionsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAssignment_0()); 
            }
            // InternalInstanceLanguage.g:2170:2: ( rule__XorExpressionRule__SubExpressionsAssignment_0 )
            // InternalInstanceLanguage.g:2170:3: rule__XorExpressionRule__SubExpressionsAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__XorExpressionRule__SubExpressionsAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAssignment_0()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:2178:1: rule__XorExpressionRule__Group__1 : rule__XorExpressionRule__Group__1__Impl ;
    public final void rule__XorExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2182:1: ( rule__XorExpressionRule__Group__1__Impl )
            // InternalInstanceLanguage.g:2183:2: rule__XorExpressionRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XorExpressionRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:2189:1: rule__XorExpressionRule__Group__1__Impl : ( ( rule__XorExpressionRule__Group_1__0 )* ) ;
    public final void rule__XorExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2193:1: ( ( ( rule__XorExpressionRule__Group_1__0 )* ) )
            // InternalInstanceLanguage.g:2194:1: ( ( rule__XorExpressionRule__Group_1__0 )* )
            {
            // InternalInstanceLanguage.g:2194:1: ( ( rule__XorExpressionRule__Group_1__0 )* )
            // InternalInstanceLanguage.g:2195:2: ( rule__XorExpressionRule__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXorExpressionRuleAccess().getGroup_1()); 
            }
            // InternalInstanceLanguage.g:2196:2: ( rule__XorExpressionRule__Group_1__0 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==54) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalInstanceLanguage.g:2196:3: rule__XorExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_17);
            	    rule__XorExpressionRule__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXorExpressionRuleAccess().getGroup_1()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:2205:1: rule__XorExpressionRule__Group_1__0 : rule__XorExpressionRule__Group_1__0__Impl rule__XorExpressionRule__Group_1__1 ;
    public final void rule__XorExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2209:1: ( rule__XorExpressionRule__Group_1__0__Impl rule__XorExpressionRule__Group_1__1 )
            // InternalInstanceLanguage.g:2210:2: rule__XorExpressionRule__Group_1__0__Impl rule__XorExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_15);
            rule__XorExpressionRule__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XorExpressionRule__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:2217:1: rule__XorExpressionRule__Group_1__0__Impl : ( 'XOR' ) ;
    public final void rule__XorExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2221:1: ( ( 'XOR' ) )
            // InternalInstanceLanguage.g:2222:1: ( 'XOR' )
            {
            // InternalInstanceLanguage.g:2222:1: ( 'XOR' )
            // InternalInstanceLanguage.g:2223:2: 'XOR'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXorExpressionRuleAccess().getXORKeyword_1_0()); 
            }
            match(input,54,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXorExpressionRuleAccess().getXORKeyword_1_0()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:2232:1: rule__XorExpressionRule__Group_1__1 : rule__XorExpressionRule__Group_1__1__Impl ;
    public final void rule__XorExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2236:1: ( rule__XorExpressionRule__Group_1__1__Impl )
            // InternalInstanceLanguage.g:2237:2: rule__XorExpressionRule__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XorExpressionRule__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:2243:1: rule__XorExpressionRule__Group_1__1__Impl : ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) ) ;
    public final void rule__XorExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2247:1: ( ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) ) )
            // InternalInstanceLanguage.g:2248:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) )
            {
            // InternalInstanceLanguage.g:2248:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) )
            // InternalInstanceLanguage.g:2249:2: ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAssignment_1_1()); 
            }
            // InternalInstanceLanguage.g:2250:2: ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 )
            // InternalInstanceLanguage.g:2250:3: rule__XorExpressionRule__SubExpressionsAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__XorExpressionRule__SubExpressionsAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAssignment_1_1()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:2259:1: rule__AndExpressionRule__Group__0 : rule__AndExpressionRule__Group__0__Impl rule__AndExpressionRule__Group__1 ;
    public final void rule__AndExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2263:1: ( rule__AndExpressionRule__Group__0__Impl rule__AndExpressionRule__Group__1 )
            // InternalInstanceLanguage.g:2264:2: rule__AndExpressionRule__Group__0__Impl rule__AndExpressionRule__Group__1
            {
            pushFollow(FOLLOW_18);
            rule__AndExpressionRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__AndExpressionRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:2271:1: rule__AndExpressionRule__Group__0__Impl : ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) ) ;
    public final void rule__AndExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2275:1: ( ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) ) )
            // InternalInstanceLanguage.g:2276:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) )
            {
            // InternalInstanceLanguage.g:2276:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) )
            // InternalInstanceLanguage.g:2277:2: ( rule__AndExpressionRule__SubExpressionsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsAssignment_0()); 
            }
            // InternalInstanceLanguage.g:2278:2: ( rule__AndExpressionRule__SubExpressionsAssignment_0 )
            // InternalInstanceLanguage.g:2278:3: rule__AndExpressionRule__SubExpressionsAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__AndExpressionRule__SubExpressionsAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsAssignment_0()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:2286:1: rule__AndExpressionRule__Group__1 : rule__AndExpressionRule__Group__1__Impl ;
    public final void rule__AndExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2290:1: ( rule__AndExpressionRule__Group__1__Impl )
            // InternalInstanceLanguage.g:2291:2: rule__AndExpressionRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AndExpressionRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:2297:1: rule__AndExpressionRule__Group__1__Impl : ( ( rule__AndExpressionRule__Group_1__0 )* ) ;
    public final void rule__AndExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2301:1: ( ( ( rule__AndExpressionRule__Group_1__0 )* ) )
            // InternalInstanceLanguage.g:2302:1: ( ( rule__AndExpressionRule__Group_1__0 )* )
            {
            // InternalInstanceLanguage.g:2302:1: ( ( rule__AndExpressionRule__Group_1__0 )* )
            // InternalInstanceLanguage.g:2303:2: ( rule__AndExpressionRule__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionRuleAccess().getGroup_1()); 
            }
            // InternalInstanceLanguage.g:2304:2: ( rule__AndExpressionRule__Group_1__0 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==55) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalInstanceLanguage.g:2304:3: rule__AndExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_19);
            	    rule__AndExpressionRule__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAndExpressionRuleAccess().getGroup_1()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:2313:1: rule__AndExpressionRule__Group_1__0 : rule__AndExpressionRule__Group_1__0__Impl rule__AndExpressionRule__Group_1__1 ;
    public final void rule__AndExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2317:1: ( rule__AndExpressionRule__Group_1__0__Impl rule__AndExpressionRule__Group_1__1 )
            // InternalInstanceLanguage.g:2318:2: rule__AndExpressionRule__Group_1__0__Impl rule__AndExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_15);
            rule__AndExpressionRule__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__AndExpressionRule__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:2325:1: rule__AndExpressionRule__Group_1__0__Impl : ( 'AND' ) ;
    public final void rule__AndExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2329:1: ( ( 'AND' ) )
            // InternalInstanceLanguage.g:2330:1: ( 'AND' )
            {
            // InternalInstanceLanguage.g:2330:1: ( 'AND' )
            // InternalInstanceLanguage.g:2331:2: 'AND'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionRuleAccess().getANDKeyword_1_0()); 
            }
            match(input,55,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAndExpressionRuleAccess().getANDKeyword_1_0()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:2340:1: rule__AndExpressionRule__Group_1__1 : rule__AndExpressionRule__Group_1__1__Impl ;
    public final void rule__AndExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2344:1: ( rule__AndExpressionRule__Group_1__1__Impl )
            // InternalInstanceLanguage.g:2345:2: rule__AndExpressionRule__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AndExpressionRule__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:2351:1: rule__AndExpressionRule__Group_1__1__Impl : ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) ) ;
    public final void rule__AndExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2355:1: ( ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) ) )
            // InternalInstanceLanguage.g:2356:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) )
            {
            // InternalInstanceLanguage.g:2356:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) )
            // InternalInstanceLanguage.g:2357:2: ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsAssignment_1_1()); 
            }
            // InternalInstanceLanguage.g:2358:2: ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 )
            // InternalInstanceLanguage.g:2358:3: rule__AndExpressionRule__SubExpressionsAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__AndExpressionRule__SubExpressionsAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsAssignment_1_1()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:2367:1: rule__NotExpressionRule__Group__0 : rule__NotExpressionRule__Group__0__Impl rule__NotExpressionRule__Group__1 ;
    public final void rule__NotExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2371:1: ( rule__NotExpressionRule__Group__0__Impl rule__NotExpressionRule__Group__1 )
            // InternalInstanceLanguage.g:2372:2: rule__NotExpressionRule__Group__0__Impl rule__NotExpressionRule__Group__1
            {
            pushFollow(FOLLOW_15);
            rule__NotExpressionRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__NotExpressionRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:2379:1: rule__NotExpressionRule__Group__0__Impl : ( ( rule__NotExpressionRule__NegatedAssignment_0 )? ) ;
    public final void rule__NotExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2383:1: ( ( ( rule__NotExpressionRule__NegatedAssignment_0 )? ) )
            // InternalInstanceLanguage.g:2384:1: ( ( rule__NotExpressionRule__NegatedAssignment_0 )? )
            {
            // InternalInstanceLanguage.g:2384:1: ( ( rule__NotExpressionRule__NegatedAssignment_0 )? )
            // InternalInstanceLanguage.g:2385:2: ( rule__NotExpressionRule__NegatedAssignment_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNotExpressionRuleAccess().getNegatedAssignment_0()); 
            }
            // InternalInstanceLanguage.g:2386:2: ( rule__NotExpressionRule__NegatedAssignment_0 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==76) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalInstanceLanguage.g:2386:3: rule__NotExpressionRule__NegatedAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__NotExpressionRule__NegatedAssignment_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNotExpressionRuleAccess().getNegatedAssignment_0()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:2394:1: rule__NotExpressionRule__Group__1 : rule__NotExpressionRule__Group__1__Impl ;
    public final void rule__NotExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2398:1: ( rule__NotExpressionRule__Group__1__Impl )
            // InternalInstanceLanguage.g:2399:2: rule__NotExpressionRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__NotExpressionRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:2405:1: rule__NotExpressionRule__Group__1__Impl : ( ( rule__NotExpressionRule__OperandAssignment_1 ) ) ;
    public final void rule__NotExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2409:1: ( ( ( rule__NotExpressionRule__OperandAssignment_1 ) ) )
            // InternalInstanceLanguage.g:2410:1: ( ( rule__NotExpressionRule__OperandAssignment_1 ) )
            {
            // InternalInstanceLanguage.g:2410:1: ( ( rule__NotExpressionRule__OperandAssignment_1 ) )
            // InternalInstanceLanguage.g:2411:2: ( rule__NotExpressionRule__OperandAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNotExpressionRuleAccess().getOperandAssignment_1()); 
            }
            // InternalInstanceLanguage.g:2412:2: ( rule__NotExpressionRule__OperandAssignment_1 )
            // InternalInstanceLanguage.g:2412:3: rule__NotExpressionRule__OperandAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__NotExpressionRule__OperandAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNotExpressionRuleAccess().getOperandAssignment_1()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:2421:1: rule__ComparisonExpressionRule__Group__0 : rule__ComparisonExpressionRule__Group__0__Impl rule__ComparisonExpressionRule__Group__1 ;
    public final void rule__ComparisonExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2425:1: ( rule__ComparisonExpressionRule__Group__0__Impl rule__ComparisonExpressionRule__Group__1 )
            // InternalInstanceLanguage.g:2426:2: rule__ComparisonExpressionRule__Group__0__Impl rule__ComparisonExpressionRule__Group__1
            {
            pushFollow(FOLLOW_20);
            rule__ComparisonExpressionRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ComparisonExpressionRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:2433:1: rule__ComparisonExpressionRule__Group__0__Impl : ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__ComparisonExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2437:1: ( ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalInstanceLanguage.g:2438:1: ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalInstanceLanguage.g:2438:1: ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) )
            // InternalInstanceLanguage.g:2439:2: ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonExpressionRuleAccess().getLeftOperandAssignment_0()); 
            }
            // InternalInstanceLanguage.g:2440:2: ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 )
            // InternalInstanceLanguage.g:2440:3: rule__ComparisonExpressionRule__LeftOperandAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__ComparisonExpressionRule__LeftOperandAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getComparisonExpressionRuleAccess().getLeftOperandAssignment_0()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:2448:1: rule__ComparisonExpressionRule__Group__1 : rule__ComparisonExpressionRule__Group__1__Impl ;
    public final void rule__ComparisonExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2452:1: ( rule__ComparisonExpressionRule__Group__1__Impl )
            // InternalInstanceLanguage.g:2453:2: rule__ComparisonExpressionRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ComparisonExpressionRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:2459:1: rule__ComparisonExpressionRule__Group__1__Impl : ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* ) ;
    public final void rule__ComparisonExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2463:1: ( ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* ) )
            // InternalInstanceLanguage.g:2464:1: ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* )
            {
            // InternalInstanceLanguage.g:2464:1: ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* )
            // InternalInstanceLanguage.g:2465:2: ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonExpressionRuleAccess().getComparisonAssignment_1()); 
            }
            // InternalInstanceLanguage.g:2466:2: ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>=16 && LA19_0<=21)) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalInstanceLanguage.g:2466:3: rule__ComparisonExpressionRule__ComparisonAssignment_1
            	    {
            	    pushFollow(FOLLOW_21);
            	    rule__ComparisonExpressionRule__ComparisonAssignment_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getComparisonExpressionRuleAccess().getComparisonAssignment_1()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:2475:1: rule__PartialComparisonExpressionRule__Group__0 : rule__PartialComparisonExpressionRule__Group__0__Impl rule__PartialComparisonExpressionRule__Group__1 ;
    public final void rule__PartialComparisonExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2479:1: ( rule__PartialComparisonExpressionRule__Group__0__Impl rule__PartialComparisonExpressionRule__Group__1 )
            // InternalInstanceLanguage.g:2480:2: rule__PartialComparisonExpressionRule__Group__0__Impl rule__PartialComparisonExpressionRule__Group__1
            {
            pushFollow(FOLLOW_15);
            rule__PartialComparisonExpressionRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PartialComparisonExpressionRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:2487:1: rule__PartialComparisonExpressionRule__Group__0__Impl : ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) ) ;
    public final void rule__PartialComparisonExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2491:1: ( ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) ) )
            // InternalInstanceLanguage.g:2492:1: ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) )
            {
            // InternalInstanceLanguage.g:2492:1: ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) )
            // InternalInstanceLanguage.g:2493:2: ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartialComparisonExpressionRuleAccess().getOperatorAssignment_0()); 
            }
            // InternalInstanceLanguage.g:2494:2: ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 )
            // InternalInstanceLanguage.g:2494:3: rule__PartialComparisonExpressionRule__OperatorAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__PartialComparisonExpressionRule__OperatorAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartialComparisonExpressionRuleAccess().getOperatorAssignment_0()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:2502:1: rule__PartialComparisonExpressionRule__Group__1 : rule__PartialComparisonExpressionRule__Group__1__Impl ;
    public final void rule__PartialComparisonExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2506:1: ( rule__PartialComparisonExpressionRule__Group__1__Impl )
            // InternalInstanceLanguage.g:2507:2: rule__PartialComparisonExpressionRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PartialComparisonExpressionRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:2513:1: rule__PartialComparisonExpressionRule__Group__1__Impl : ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) ) ;
    public final void rule__PartialComparisonExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2517:1: ( ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) ) )
            // InternalInstanceLanguage.g:2518:1: ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) )
            {
            // InternalInstanceLanguage.g:2518:1: ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) )
            // InternalInstanceLanguage.g:2519:2: ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartialComparisonExpressionRuleAccess().getSubExpressionAssignment_1()); 
            }
            // InternalInstanceLanguage.g:2520:2: ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 )
            // InternalInstanceLanguage.g:2520:3: rule__PartialComparisonExpressionRule__SubExpressionAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__PartialComparisonExpressionRule__SubExpressionAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartialComparisonExpressionRuleAccess().getSubExpressionAssignment_1()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:2529:1: rule__AddOrSubtractExpressionRule__Group__0 : rule__AddOrSubtractExpressionRule__Group__0__Impl rule__AddOrSubtractExpressionRule__Group__1 ;
    public final void rule__AddOrSubtractExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2533:1: ( rule__AddOrSubtractExpressionRule__Group__0__Impl rule__AddOrSubtractExpressionRule__Group__1 )
            // InternalInstanceLanguage.g:2534:2: rule__AddOrSubtractExpressionRule__Group__0__Impl rule__AddOrSubtractExpressionRule__Group__1
            {
            pushFollow(FOLLOW_22);
            rule__AddOrSubtractExpressionRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__AddOrSubtractExpressionRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:2541:1: rule__AddOrSubtractExpressionRule__Group__0__Impl : ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__AddOrSubtractExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2545:1: ( ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalInstanceLanguage.g:2546:1: ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalInstanceLanguage.g:2546:1: ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) )
            // InternalInstanceLanguage.g:2547:2: ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getLeftOperandAssignment_0()); 
            }
            // InternalInstanceLanguage.g:2548:2: ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 )
            // InternalInstanceLanguage.g:2548:3: rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAddOrSubtractExpressionRuleAccess().getLeftOperandAssignment_0()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:2556:1: rule__AddOrSubtractExpressionRule__Group__1 : rule__AddOrSubtractExpressionRule__Group__1__Impl ;
    public final void rule__AddOrSubtractExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2560:1: ( rule__AddOrSubtractExpressionRule__Group__1__Impl )
            // InternalInstanceLanguage.g:2561:2: rule__AddOrSubtractExpressionRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AddOrSubtractExpressionRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:2567:1: rule__AddOrSubtractExpressionRule__Group__1__Impl : ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* ) ;
    public final void rule__AddOrSubtractExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2571:1: ( ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* ) )
            // InternalInstanceLanguage.g:2572:1: ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* )
            {
            // InternalInstanceLanguage.g:2572:1: ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* )
            // InternalInstanceLanguage.g:2573:2: ( rule__AddOrSubtractExpressionRule__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getGroup_1()); 
            }
            // InternalInstanceLanguage.g:2574:2: ( rule__AddOrSubtractExpressionRule__Group_1__0 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>=22 && LA20_0<=23)) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalInstanceLanguage.g:2574:3: rule__AddOrSubtractExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_23);
            	    rule__AddOrSubtractExpressionRule__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAddOrSubtractExpressionRuleAccess().getGroup_1()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:2583:1: rule__AddOrSubtractExpressionRule__Group_1__0 : rule__AddOrSubtractExpressionRule__Group_1__0__Impl rule__AddOrSubtractExpressionRule__Group_1__1 ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2587:1: ( rule__AddOrSubtractExpressionRule__Group_1__0__Impl rule__AddOrSubtractExpressionRule__Group_1__1 )
            // InternalInstanceLanguage.g:2588:2: rule__AddOrSubtractExpressionRule__Group_1__0__Impl rule__AddOrSubtractExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_15);
            rule__AddOrSubtractExpressionRule__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__AddOrSubtractExpressionRule__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:2595:1: rule__AddOrSubtractExpressionRule__Group_1__0__Impl : ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) ) ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2599:1: ( ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) ) )
            // InternalInstanceLanguage.g:2600:1: ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) )
            {
            // InternalInstanceLanguage.g:2600:1: ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) )
            // InternalInstanceLanguage.g:2601:2: ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperatorsAssignment_1_0()); 
            }
            // InternalInstanceLanguage.g:2602:2: ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 )
            // InternalInstanceLanguage.g:2602:3: rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0
            {
            pushFollow(FOLLOW_2);
            rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperatorsAssignment_1_0()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:2610:1: rule__AddOrSubtractExpressionRule__Group_1__1 : rule__AddOrSubtractExpressionRule__Group_1__1__Impl ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2614:1: ( rule__AddOrSubtractExpressionRule__Group_1__1__Impl )
            // InternalInstanceLanguage.g:2615:2: rule__AddOrSubtractExpressionRule__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AddOrSubtractExpressionRule__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:2621:1: rule__AddOrSubtractExpressionRule__Group_1__1__Impl : ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) ) ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2625:1: ( ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) ) )
            // InternalInstanceLanguage.g:2626:1: ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) )
            {
            // InternalInstanceLanguage.g:2626:1: ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) )
            // InternalInstanceLanguage.g:2627:2: ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperandsAssignment_1_1()); 
            }
            // InternalInstanceLanguage.g:2628:2: ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 )
            // InternalInstanceLanguage.g:2628:3: rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperandsAssignment_1_1()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:2637:1: rule__MultiplyDivideModuloExpressionRule__Group__0 : rule__MultiplyDivideModuloExpressionRule__Group__0__Impl rule__MultiplyDivideModuloExpressionRule__Group__1 ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2641:1: ( rule__MultiplyDivideModuloExpressionRule__Group__0__Impl rule__MultiplyDivideModuloExpressionRule__Group__1 )
            // InternalInstanceLanguage.g:2642:2: rule__MultiplyDivideModuloExpressionRule__Group__0__Impl rule__MultiplyDivideModuloExpressionRule__Group__1
            {
            pushFollow(FOLLOW_24);
            rule__MultiplyDivideModuloExpressionRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__MultiplyDivideModuloExpressionRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:2649:1: rule__MultiplyDivideModuloExpressionRule__Group__0__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2653:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalInstanceLanguage.g:2654:1: ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalInstanceLanguage.g:2654:1: ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) )
            // InternalInstanceLanguage.g:2655:2: ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getLeftOperandAssignment_0()); 
            }
            // InternalInstanceLanguage.g:2656:2: ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 )
            // InternalInstanceLanguage.g:2656:3: rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getLeftOperandAssignment_0()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:2664:1: rule__MultiplyDivideModuloExpressionRule__Group__1 : rule__MultiplyDivideModuloExpressionRule__Group__1__Impl ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2668:1: ( rule__MultiplyDivideModuloExpressionRule__Group__1__Impl )
            // InternalInstanceLanguage.g:2669:2: rule__MultiplyDivideModuloExpressionRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MultiplyDivideModuloExpressionRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:2675:1: rule__MultiplyDivideModuloExpressionRule__Group__1__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2679:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* ) )
            // InternalInstanceLanguage.g:2680:1: ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* )
            {
            // InternalInstanceLanguage.g:2680:1: ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* )
            // InternalInstanceLanguage.g:2681:2: ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getGroup_1()); 
            }
            // InternalInstanceLanguage.g:2682:2: ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0>=24 && LA21_0<=26)) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalInstanceLanguage.g:2682:3: rule__MultiplyDivideModuloExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_25);
            	    rule__MultiplyDivideModuloExpressionRule__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getGroup_1()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:2691:1: rule__MultiplyDivideModuloExpressionRule__Group_1__0 : rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl rule__MultiplyDivideModuloExpressionRule__Group_1__1 ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2695:1: ( rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl rule__MultiplyDivideModuloExpressionRule__Group_1__1 )
            // InternalInstanceLanguage.g:2696:2: rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl rule__MultiplyDivideModuloExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_15);
            rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__MultiplyDivideModuloExpressionRule__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:2703:1: rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2707:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) ) )
            // InternalInstanceLanguage.g:2708:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) )
            {
            // InternalInstanceLanguage.g:2708:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) )
            // InternalInstanceLanguage.g:2709:2: ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperatorsAssignment_1_0()); 
            }
            // InternalInstanceLanguage.g:2710:2: ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 )
            // InternalInstanceLanguage.g:2710:3: rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0
            {
            pushFollow(FOLLOW_2);
            rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperatorsAssignment_1_0()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:2718:1: rule__MultiplyDivideModuloExpressionRule__Group_1__1 : rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2722:1: ( rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl )
            // InternalInstanceLanguage.g:2723:2: rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:2729:1: rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2733:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) ) )
            // InternalInstanceLanguage.g:2734:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) )
            {
            // InternalInstanceLanguage.g:2734:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) )
            // InternalInstanceLanguage.g:2735:2: ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperandsAssignment_1_1()); 
            }
            // InternalInstanceLanguage.g:2736:2: ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 )
            // InternalInstanceLanguage.g:2736:3: rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperandsAssignment_1_1()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:2745:1: rule__PowerOfExpressionRule__Group__0 : rule__PowerOfExpressionRule__Group__0__Impl rule__PowerOfExpressionRule__Group__1 ;
    public final void rule__PowerOfExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2749:1: ( rule__PowerOfExpressionRule__Group__0__Impl rule__PowerOfExpressionRule__Group__1 )
            // InternalInstanceLanguage.g:2750:2: rule__PowerOfExpressionRule__Group__0__Impl rule__PowerOfExpressionRule__Group__1
            {
            pushFollow(FOLLOW_26);
            rule__PowerOfExpressionRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PowerOfExpressionRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:2757:1: rule__PowerOfExpressionRule__Group__0__Impl : ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__PowerOfExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2761:1: ( ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalInstanceLanguage.g:2762:1: ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalInstanceLanguage.g:2762:1: ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) )
            // InternalInstanceLanguage.g:2763:2: ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPowerOfExpressionRuleAccess().getLeftOperandAssignment_0()); 
            }
            // InternalInstanceLanguage.g:2764:2: ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 )
            // InternalInstanceLanguage.g:2764:3: rule__PowerOfExpressionRule__LeftOperandAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__PowerOfExpressionRule__LeftOperandAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPowerOfExpressionRuleAccess().getLeftOperandAssignment_0()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:2772:1: rule__PowerOfExpressionRule__Group__1 : rule__PowerOfExpressionRule__Group__1__Impl ;
    public final void rule__PowerOfExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2776:1: ( rule__PowerOfExpressionRule__Group__1__Impl )
            // InternalInstanceLanguage.g:2777:2: rule__PowerOfExpressionRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PowerOfExpressionRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:2783:1: rule__PowerOfExpressionRule__Group__1__Impl : ( ( rule__PowerOfExpressionRule__Group_1__0 )? ) ;
    public final void rule__PowerOfExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2787:1: ( ( ( rule__PowerOfExpressionRule__Group_1__0 )? ) )
            // InternalInstanceLanguage.g:2788:1: ( ( rule__PowerOfExpressionRule__Group_1__0 )? )
            {
            // InternalInstanceLanguage.g:2788:1: ( ( rule__PowerOfExpressionRule__Group_1__0 )? )
            // InternalInstanceLanguage.g:2789:2: ( rule__PowerOfExpressionRule__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPowerOfExpressionRuleAccess().getGroup_1()); 
            }
            // InternalInstanceLanguage.g:2790:2: ( rule__PowerOfExpressionRule__Group_1__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==56) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalInstanceLanguage.g:2790:3: rule__PowerOfExpressionRule__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PowerOfExpressionRule__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPowerOfExpressionRuleAccess().getGroup_1()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:2799:1: rule__PowerOfExpressionRule__Group_1__0 : rule__PowerOfExpressionRule__Group_1__0__Impl rule__PowerOfExpressionRule__Group_1__1 ;
    public final void rule__PowerOfExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2803:1: ( rule__PowerOfExpressionRule__Group_1__0__Impl rule__PowerOfExpressionRule__Group_1__1 )
            // InternalInstanceLanguage.g:2804:2: rule__PowerOfExpressionRule__Group_1__0__Impl rule__PowerOfExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_15);
            rule__PowerOfExpressionRule__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PowerOfExpressionRule__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:2811:1: rule__PowerOfExpressionRule__Group_1__0__Impl : ( '^' ) ;
    public final void rule__PowerOfExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2815:1: ( ( '^' ) )
            // InternalInstanceLanguage.g:2816:1: ( '^' )
            {
            // InternalInstanceLanguage.g:2816:1: ( '^' )
            // InternalInstanceLanguage.g:2817:2: '^'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPowerOfExpressionRuleAccess().getCircumflexAccentKeyword_1_0()); 
            }
            match(input,56,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPowerOfExpressionRuleAccess().getCircumflexAccentKeyword_1_0()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:2826:1: rule__PowerOfExpressionRule__Group_1__1 : rule__PowerOfExpressionRule__Group_1__1__Impl ;
    public final void rule__PowerOfExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2830:1: ( rule__PowerOfExpressionRule__Group_1__1__Impl )
            // InternalInstanceLanguage.g:2831:2: rule__PowerOfExpressionRule__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PowerOfExpressionRule__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:2837:1: rule__PowerOfExpressionRule__Group_1__1__Impl : ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) ) ;
    public final void rule__PowerOfExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2841:1: ( ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) ) )
            // InternalInstanceLanguage.g:2842:1: ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) )
            {
            // InternalInstanceLanguage.g:2842:1: ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) )
            // InternalInstanceLanguage.g:2843:2: ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPowerOfExpressionRuleAccess().getRightOperandAssignment_1_1()); 
            }
            // InternalInstanceLanguage.g:2844:2: ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 )
            // InternalInstanceLanguage.g:2844:3: rule__PowerOfExpressionRule__RightOperandAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__PowerOfExpressionRule__RightOperandAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPowerOfExpressionRuleAccess().getRightOperandAssignment_1_1()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:2853:1: rule__UnaryAddOrSubtractExpressionRule__Group__0 : rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl rule__UnaryAddOrSubtractExpressionRule__Group__1 ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2857:1: ( rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl rule__UnaryAddOrSubtractExpressionRule__Group__1 )
            // InternalInstanceLanguage.g:2858:2: rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl rule__UnaryAddOrSubtractExpressionRule__Group__1
            {
            pushFollow(FOLLOW_15);
            rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__UnaryAddOrSubtractExpressionRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:2865:1: rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl : ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2869:1: ( ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* ) )
            // InternalInstanceLanguage.g:2870:1: ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* )
            {
            // InternalInstanceLanguage.g:2870:1: ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* )
            // InternalInstanceLanguage.g:2871:2: ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getOperatorsAssignment_0()); 
            }
            // InternalInstanceLanguage.g:2872:2: ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0>=22 && LA23_0<=23)) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalInstanceLanguage.g:2872:3: rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0
            	    {
            	    pushFollow(FOLLOW_23);
            	    rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getOperatorsAssignment_0()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:2880:1: rule__UnaryAddOrSubtractExpressionRule__Group__1 : rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2884:1: ( rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl )
            // InternalInstanceLanguage.g:2885:2: rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:2891:1: rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl : ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2895:1: ( ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) ) )
            // InternalInstanceLanguage.g:2896:1: ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) )
            {
            // InternalInstanceLanguage.g:2896:1: ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) )
            // InternalInstanceLanguage.g:2897:2: ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getSubExpressionAssignment_1()); 
            }
            // InternalInstanceLanguage.g:2898:2: ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 )
            // InternalInstanceLanguage.g:2898:3: rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getSubExpressionAssignment_1()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__ArrayRule__Group__0"
    // InternalInstanceLanguage.g:2907:1: rule__ArrayRule__Group__0 : rule__ArrayRule__Group__0__Impl rule__ArrayRule__Group__1 ;
    public final void rule__ArrayRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2911:1: ( rule__ArrayRule__Group__0__Impl rule__ArrayRule__Group__1 )
            // InternalInstanceLanguage.g:2912:2: rule__ArrayRule__Group__0__Impl rule__ArrayRule__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__ArrayRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ArrayRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrayRule__Group__0"


    // $ANTLR start "rule__ArrayRule__Group__0__Impl"
    // InternalInstanceLanguage.g:2919:1: rule__ArrayRule__Group__0__Impl : ( () ) ;
    public final void rule__ArrayRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2923:1: ( ( () ) )
            // InternalInstanceLanguage.g:2924:1: ( () )
            {
            // InternalInstanceLanguage.g:2924:1: ( () )
            // InternalInstanceLanguage.g:2925:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayRuleAccess().getArrayAction_0()); 
            }
            // InternalInstanceLanguage.g:2926:2: ()
            // InternalInstanceLanguage.g:2926:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getArrayRuleAccess().getArrayAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrayRule__Group__0__Impl"


    // $ANTLR start "rule__ArrayRule__Group__1"
    // InternalInstanceLanguage.g:2934:1: rule__ArrayRule__Group__1 : rule__ArrayRule__Group__1__Impl rule__ArrayRule__Group__2 ;
    public final void rule__ArrayRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2938:1: ( rule__ArrayRule__Group__1__Impl rule__ArrayRule__Group__2 )
            // InternalInstanceLanguage.g:2939:2: rule__ArrayRule__Group__1__Impl rule__ArrayRule__Group__2
            {
            pushFollow(FOLLOW_27);
            rule__ArrayRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ArrayRule__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrayRule__Group__1"


    // $ANTLR start "rule__ArrayRule__Group__1__Impl"
    // InternalInstanceLanguage.g:2946:1: rule__ArrayRule__Group__1__Impl : ( '[' ) ;
    public final void rule__ArrayRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2950:1: ( ( '[' ) )
            // InternalInstanceLanguage.g:2951:1: ( '[' )
            {
            // InternalInstanceLanguage.g:2951:1: ( '[' )
            // InternalInstanceLanguage.g:2952:2: '['
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayRuleAccess().getLeftSquareBracketKeyword_1()); 
            }
            match(input,48,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getArrayRuleAccess().getLeftSquareBracketKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrayRule__Group__1__Impl"


    // $ANTLR start "rule__ArrayRule__Group__2"
    // InternalInstanceLanguage.g:2961:1: rule__ArrayRule__Group__2 : rule__ArrayRule__Group__2__Impl rule__ArrayRule__Group__3 ;
    public final void rule__ArrayRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2965:1: ( rule__ArrayRule__Group__2__Impl rule__ArrayRule__Group__3 )
            // InternalInstanceLanguage.g:2966:2: rule__ArrayRule__Group__2__Impl rule__ArrayRule__Group__3
            {
            pushFollow(FOLLOW_27);
            rule__ArrayRule__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ArrayRule__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrayRule__Group__2"


    // $ANTLR start "rule__ArrayRule__Group__2__Impl"
    // InternalInstanceLanguage.g:2973:1: rule__ArrayRule__Group__2__Impl : ( ( rule__ArrayRule__Group_2__0 )? ) ;
    public final void rule__ArrayRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2977:1: ( ( ( rule__ArrayRule__Group_2__0 )? ) )
            // InternalInstanceLanguage.g:2978:1: ( ( rule__ArrayRule__Group_2__0 )? )
            {
            // InternalInstanceLanguage.g:2978:1: ( ( rule__ArrayRule__Group_2__0 )? )
            // InternalInstanceLanguage.g:2979:2: ( rule__ArrayRule__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayRuleAccess().getGroup_2()); 
            }
            // InternalInstanceLanguage.g:2980:2: ( rule__ArrayRule__Group_2__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( ((LA24_0>=RULE_QUOTED_ID && LA24_0<=RULE_STRING)||LA24_0==15||LA24_0==48||LA24_0==57||LA24_0==59||LA24_0==77) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalInstanceLanguage.g:2980:3: rule__ArrayRule__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ArrayRule__Group_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getArrayRuleAccess().getGroup_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrayRule__Group__2__Impl"


    // $ANTLR start "rule__ArrayRule__Group__3"
    // InternalInstanceLanguage.g:2988:1: rule__ArrayRule__Group__3 : rule__ArrayRule__Group__3__Impl ;
    public final void rule__ArrayRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2992:1: ( rule__ArrayRule__Group__3__Impl )
            // InternalInstanceLanguage.g:2993:2: rule__ArrayRule__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ArrayRule__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrayRule__Group__3"


    // $ANTLR start "rule__ArrayRule__Group__3__Impl"
    // InternalInstanceLanguage.g:2999:1: rule__ArrayRule__Group__3__Impl : ( ']' ) ;
    public final void rule__ArrayRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3003:1: ( ( ']' ) )
            // InternalInstanceLanguage.g:3004:1: ( ']' )
            {
            // InternalInstanceLanguage.g:3004:1: ( ']' )
            // InternalInstanceLanguage.g:3005:2: ']'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayRuleAccess().getRightSquareBracketKeyword_3()); 
            }
            match(input,49,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getArrayRuleAccess().getRightSquareBracketKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrayRule__Group__3__Impl"


    // $ANTLR start "rule__ArrayRule__Group_2__0"
    // InternalInstanceLanguage.g:3015:1: rule__ArrayRule__Group_2__0 : rule__ArrayRule__Group_2__0__Impl rule__ArrayRule__Group_2__1 ;
    public final void rule__ArrayRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3019:1: ( rule__ArrayRule__Group_2__0__Impl rule__ArrayRule__Group_2__1 )
            // InternalInstanceLanguage.g:3020:2: rule__ArrayRule__Group_2__0__Impl rule__ArrayRule__Group_2__1
            {
            pushFollow(FOLLOW_10);
            rule__ArrayRule__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ArrayRule__Group_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrayRule__Group_2__0"


    // $ANTLR start "rule__ArrayRule__Group_2__0__Impl"
    // InternalInstanceLanguage.g:3027:1: rule__ArrayRule__Group_2__0__Impl : ( ( rule__ArrayRule__ValuesAssignment_2_0 ) ) ;
    public final void rule__ArrayRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3031:1: ( ( ( rule__ArrayRule__ValuesAssignment_2_0 ) ) )
            // InternalInstanceLanguage.g:3032:1: ( ( rule__ArrayRule__ValuesAssignment_2_0 ) )
            {
            // InternalInstanceLanguage.g:3032:1: ( ( rule__ArrayRule__ValuesAssignment_2_0 ) )
            // InternalInstanceLanguage.g:3033:2: ( rule__ArrayRule__ValuesAssignment_2_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayRuleAccess().getValuesAssignment_2_0()); 
            }
            // InternalInstanceLanguage.g:3034:2: ( rule__ArrayRule__ValuesAssignment_2_0 )
            // InternalInstanceLanguage.g:3034:3: rule__ArrayRule__ValuesAssignment_2_0
            {
            pushFollow(FOLLOW_2);
            rule__ArrayRule__ValuesAssignment_2_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getArrayRuleAccess().getValuesAssignment_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrayRule__Group_2__0__Impl"


    // $ANTLR start "rule__ArrayRule__Group_2__1"
    // InternalInstanceLanguage.g:3042:1: rule__ArrayRule__Group_2__1 : rule__ArrayRule__Group_2__1__Impl ;
    public final void rule__ArrayRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3046:1: ( rule__ArrayRule__Group_2__1__Impl )
            // InternalInstanceLanguage.g:3047:2: rule__ArrayRule__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ArrayRule__Group_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrayRule__Group_2__1"


    // $ANTLR start "rule__ArrayRule__Group_2__1__Impl"
    // InternalInstanceLanguage.g:3053:1: rule__ArrayRule__Group_2__1__Impl : ( ( rule__ArrayRule__Group_2_1__0 )* ) ;
    public final void rule__ArrayRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3057:1: ( ( ( rule__ArrayRule__Group_2_1__0 )* ) )
            // InternalInstanceLanguage.g:3058:1: ( ( rule__ArrayRule__Group_2_1__0 )* )
            {
            // InternalInstanceLanguage.g:3058:1: ( ( rule__ArrayRule__Group_2_1__0 )* )
            // InternalInstanceLanguage.g:3059:2: ( rule__ArrayRule__Group_2_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayRuleAccess().getGroup_2_1()); 
            }
            // InternalInstanceLanguage.g:3060:2: ( rule__ArrayRule__Group_2_1__0 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==52) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalInstanceLanguage.g:3060:3: rule__ArrayRule__Group_2_1__0
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__ArrayRule__Group_2_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getArrayRuleAccess().getGroup_2_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrayRule__Group_2__1__Impl"


    // $ANTLR start "rule__ArrayRule__Group_2_1__0"
    // InternalInstanceLanguage.g:3069:1: rule__ArrayRule__Group_2_1__0 : rule__ArrayRule__Group_2_1__0__Impl rule__ArrayRule__Group_2_1__1 ;
    public final void rule__ArrayRule__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3073:1: ( rule__ArrayRule__Group_2_1__0__Impl rule__ArrayRule__Group_2_1__1 )
            // InternalInstanceLanguage.g:3074:2: rule__ArrayRule__Group_2_1__0__Impl rule__ArrayRule__Group_2_1__1
            {
            pushFollow(FOLLOW_15);
            rule__ArrayRule__Group_2_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ArrayRule__Group_2_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrayRule__Group_2_1__0"


    // $ANTLR start "rule__ArrayRule__Group_2_1__0__Impl"
    // InternalInstanceLanguage.g:3081:1: rule__ArrayRule__Group_2_1__0__Impl : ( ',' ) ;
    public final void rule__ArrayRule__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3085:1: ( ( ',' ) )
            // InternalInstanceLanguage.g:3086:1: ( ',' )
            {
            // InternalInstanceLanguage.g:3086:1: ( ',' )
            // InternalInstanceLanguage.g:3087:2: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayRuleAccess().getCommaKeyword_2_1_0()); 
            }
            match(input,52,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getArrayRuleAccess().getCommaKeyword_2_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrayRule__Group_2_1__0__Impl"


    // $ANTLR start "rule__ArrayRule__Group_2_1__1"
    // InternalInstanceLanguage.g:3096:1: rule__ArrayRule__Group_2_1__1 : rule__ArrayRule__Group_2_1__1__Impl ;
    public final void rule__ArrayRule__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3100:1: ( rule__ArrayRule__Group_2_1__1__Impl )
            // InternalInstanceLanguage.g:3101:2: rule__ArrayRule__Group_2_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ArrayRule__Group_2_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrayRule__Group_2_1__1"


    // $ANTLR start "rule__ArrayRule__Group_2_1__1__Impl"
    // InternalInstanceLanguage.g:3107:1: rule__ArrayRule__Group_2_1__1__Impl : ( ( rule__ArrayRule__ValuesAssignment_2_1_1 ) ) ;
    public final void rule__ArrayRule__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3111:1: ( ( ( rule__ArrayRule__ValuesAssignment_2_1_1 ) ) )
            // InternalInstanceLanguage.g:3112:1: ( ( rule__ArrayRule__ValuesAssignment_2_1_1 ) )
            {
            // InternalInstanceLanguage.g:3112:1: ( ( rule__ArrayRule__ValuesAssignment_2_1_1 ) )
            // InternalInstanceLanguage.g:3113:2: ( rule__ArrayRule__ValuesAssignment_2_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayRuleAccess().getValuesAssignment_2_1_1()); 
            }
            // InternalInstanceLanguage.g:3114:2: ( rule__ArrayRule__ValuesAssignment_2_1_1 )
            // InternalInstanceLanguage.g:3114:3: rule__ArrayRule__ValuesAssignment_2_1_1
            {
            pushFollow(FOLLOW_2);
            rule__ArrayRule__ValuesAssignment_2_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getArrayRuleAccess().getValuesAssignment_2_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrayRule__Group_2_1__1__Impl"


    // $ANTLR start "rule__ParanthesesRule__Group__0"
    // InternalInstanceLanguage.g:3123:1: rule__ParanthesesRule__Group__0 : rule__ParanthesesRule__Group__0__Impl rule__ParanthesesRule__Group__1 ;
    public final void rule__ParanthesesRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3127:1: ( rule__ParanthesesRule__Group__0__Impl rule__ParanthesesRule__Group__1 )
            // InternalInstanceLanguage.g:3128:2: rule__ParanthesesRule__Group__0__Impl rule__ParanthesesRule__Group__1
            {
            pushFollow(FOLLOW_15);
            rule__ParanthesesRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ParanthesesRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:3135:1: rule__ParanthesesRule__Group__0__Impl : ( '(' ) ;
    public final void rule__ParanthesesRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3139:1: ( ( '(' ) )
            // InternalInstanceLanguage.g:3140:1: ( '(' )
            {
            // InternalInstanceLanguage.g:3140:1: ( '(' )
            // InternalInstanceLanguage.g:3141:2: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParanthesesRuleAccess().getLeftParenthesisKeyword_0()); 
            }
            match(input,57,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParanthesesRuleAccess().getLeftParenthesisKeyword_0()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:3150:1: rule__ParanthesesRule__Group__1 : rule__ParanthesesRule__Group__1__Impl rule__ParanthesesRule__Group__2 ;
    public final void rule__ParanthesesRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3154:1: ( rule__ParanthesesRule__Group__1__Impl rule__ParanthesesRule__Group__2 )
            // InternalInstanceLanguage.g:3155:2: rule__ParanthesesRule__Group__1__Impl rule__ParanthesesRule__Group__2
            {
            pushFollow(FOLLOW_28);
            rule__ParanthesesRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ParanthesesRule__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:3162:1: rule__ParanthesesRule__Group__1__Impl : ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) ) ;
    public final void rule__ParanthesesRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3166:1: ( ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) ) )
            // InternalInstanceLanguage.g:3167:1: ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) )
            {
            // InternalInstanceLanguage.g:3167:1: ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) )
            // InternalInstanceLanguage.g:3168:2: ( rule__ParanthesesRule__SubExpressionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParanthesesRuleAccess().getSubExpressionAssignment_1()); 
            }
            // InternalInstanceLanguage.g:3169:2: ( rule__ParanthesesRule__SubExpressionAssignment_1 )
            // InternalInstanceLanguage.g:3169:3: rule__ParanthesesRule__SubExpressionAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__ParanthesesRule__SubExpressionAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getParanthesesRuleAccess().getSubExpressionAssignment_1()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:3177:1: rule__ParanthesesRule__Group__2 : rule__ParanthesesRule__Group__2__Impl ;
    public final void rule__ParanthesesRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3181:1: ( rule__ParanthesesRule__Group__2__Impl )
            // InternalInstanceLanguage.g:3182:2: rule__ParanthesesRule__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ParanthesesRule__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:3188:1: rule__ParanthesesRule__Group__2__Impl : ( ')' ) ;
    public final void rule__ParanthesesRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3192:1: ( ( ')' ) )
            // InternalInstanceLanguage.g:3193:1: ( ')' )
            {
            // InternalInstanceLanguage.g:3193:1: ( ')' )
            // InternalInstanceLanguage.g:3194:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParanthesesRuleAccess().getRightParenthesisKeyword_2()); 
            }
            match(input,58,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParanthesesRuleAccess().getRightParenthesisKeyword_2()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:3204:1: rule__CallRule__Group__0 : rule__CallRule__Group__0__Impl rule__CallRule__Group__1 ;
    public final void rule__CallRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3208:1: ( rule__CallRule__Group__0__Impl rule__CallRule__Group__1 )
            // InternalInstanceLanguage.g:3209:2: rule__CallRule__Group__0__Impl rule__CallRule__Group__1
            {
            pushFollow(FOLLOW_29);
            rule__CallRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__CallRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:3216:1: rule__CallRule__Group__0__Impl : ( ( rule__CallRule__FunctionAssignment_0 ) ) ;
    public final void rule__CallRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3220:1: ( ( ( rule__CallRule__FunctionAssignment_0 ) ) )
            // InternalInstanceLanguage.g:3221:1: ( ( rule__CallRule__FunctionAssignment_0 ) )
            {
            // InternalInstanceLanguage.g:3221:1: ( ( rule__CallRule__FunctionAssignment_0 ) )
            // InternalInstanceLanguage.g:3222:2: ( rule__CallRule__FunctionAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getFunctionAssignment_0()); 
            }
            // InternalInstanceLanguage.g:3223:2: ( rule__CallRule__FunctionAssignment_0 )
            // InternalInstanceLanguage.g:3223:3: rule__CallRule__FunctionAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__CallRule__FunctionAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCallRuleAccess().getFunctionAssignment_0()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:3231:1: rule__CallRule__Group__1 : rule__CallRule__Group__1__Impl rule__CallRule__Group__2 ;
    public final void rule__CallRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3235:1: ( rule__CallRule__Group__1__Impl rule__CallRule__Group__2 )
            // InternalInstanceLanguage.g:3236:2: rule__CallRule__Group__1__Impl rule__CallRule__Group__2
            {
            pushFollow(FOLLOW_30);
            rule__CallRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__CallRule__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:3243:1: rule__CallRule__Group__1__Impl : ( '(' ) ;
    public final void rule__CallRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3247:1: ( ( '(' ) )
            // InternalInstanceLanguage.g:3248:1: ( '(' )
            {
            // InternalInstanceLanguage.g:3248:1: ( '(' )
            // InternalInstanceLanguage.g:3249:2: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getLeftParenthesisKeyword_1()); 
            }
            match(input,57,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCallRuleAccess().getLeftParenthesisKeyword_1()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:3258:1: rule__CallRule__Group__2 : rule__CallRule__Group__2__Impl rule__CallRule__Group__3 ;
    public final void rule__CallRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3262:1: ( rule__CallRule__Group__2__Impl rule__CallRule__Group__3 )
            // InternalInstanceLanguage.g:3263:2: rule__CallRule__Group__2__Impl rule__CallRule__Group__3
            {
            pushFollow(FOLLOW_30);
            rule__CallRule__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__CallRule__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:3270:1: rule__CallRule__Group__2__Impl : ( ( rule__CallRule__Group_2__0 )? ) ;
    public final void rule__CallRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3274:1: ( ( ( rule__CallRule__Group_2__0 )? ) )
            // InternalInstanceLanguage.g:3275:1: ( ( rule__CallRule__Group_2__0 )? )
            {
            // InternalInstanceLanguage.g:3275:1: ( ( rule__CallRule__Group_2__0 )? )
            // InternalInstanceLanguage.g:3276:2: ( rule__CallRule__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getGroup_2()); 
            }
            // InternalInstanceLanguage.g:3277:2: ( rule__CallRule__Group_2__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( ((LA26_0>=RULE_QUOTED_ID && LA26_0<=RULE_STRING)||LA26_0==15||(LA26_0>=22 && LA26_0<=23)||LA26_0==48||LA26_0==57||LA26_0==59||(LA26_0>=76 && LA26_0<=77)) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalInstanceLanguage.g:3277:3: rule__CallRule__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__CallRule__Group_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCallRuleAccess().getGroup_2()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:3285:1: rule__CallRule__Group__3 : rule__CallRule__Group__3__Impl ;
    public final void rule__CallRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3289:1: ( rule__CallRule__Group__3__Impl )
            // InternalInstanceLanguage.g:3290:2: rule__CallRule__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CallRule__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:3296:1: rule__CallRule__Group__3__Impl : ( ')' ) ;
    public final void rule__CallRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3300:1: ( ( ')' ) )
            // InternalInstanceLanguage.g:3301:1: ( ')' )
            {
            // InternalInstanceLanguage.g:3301:1: ( ')' )
            // InternalInstanceLanguage.g:3302:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getRightParenthesisKeyword_3()); 
            }
            match(input,58,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCallRuleAccess().getRightParenthesisKeyword_3()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:3312:1: rule__CallRule__Group_2__0 : rule__CallRule__Group_2__0__Impl rule__CallRule__Group_2__1 ;
    public final void rule__CallRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3316:1: ( rule__CallRule__Group_2__0__Impl rule__CallRule__Group_2__1 )
            // InternalInstanceLanguage.g:3317:2: rule__CallRule__Group_2__0__Impl rule__CallRule__Group_2__1
            {
            pushFollow(FOLLOW_10);
            rule__CallRule__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__CallRule__Group_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:3324:1: rule__CallRule__Group_2__0__Impl : ( ( rule__CallRule__ParametersAssignment_2_0 ) ) ;
    public final void rule__CallRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3328:1: ( ( ( rule__CallRule__ParametersAssignment_2_0 ) ) )
            // InternalInstanceLanguage.g:3329:1: ( ( rule__CallRule__ParametersAssignment_2_0 ) )
            {
            // InternalInstanceLanguage.g:3329:1: ( ( rule__CallRule__ParametersAssignment_2_0 ) )
            // InternalInstanceLanguage.g:3330:2: ( rule__CallRule__ParametersAssignment_2_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getParametersAssignment_2_0()); 
            }
            // InternalInstanceLanguage.g:3331:2: ( rule__CallRule__ParametersAssignment_2_0 )
            // InternalInstanceLanguage.g:3331:3: rule__CallRule__ParametersAssignment_2_0
            {
            pushFollow(FOLLOW_2);
            rule__CallRule__ParametersAssignment_2_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCallRuleAccess().getParametersAssignment_2_0()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:3339:1: rule__CallRule__Group_2__1 : rule__CallRule__Group_2__1__Impl ;
    public final void rule__CallRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3343:1: ( rule__CallRule__Group_2__1__Impl )
            // InternalInstanceLanguage.g:3344:2: rule__CallRule__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CallRule__Group_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:3350:1: rule__CallRule__Group_2__1__Impl : ( ( rule__CallRule__Group_2_1__0 )* ) ;
    public final void rule__CallRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3354:1: ( ( ( rule__CallRule__Group_2_1__0 )* ) )
            // InternalInstanceLanguage.g:3355:1: ( ( rule__CallRule__Group_2_1__0 )* )
            {
            // InternalInstanceLanguage.g:3355:1: ( ( rule__CallRule__Group_2_1__0 )* )
            // InternalInstanceLanguage.g:3356:2: ( rule__CallRule__Group_2_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getGroup_2_1()); 
            }
            // InternalInstanceLanguage.g:3357:2: ( rule__CallRule__Group_2_1__0 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==52) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalInstanceLanguage.g:3357:3: rule__CallRule__Group_2_1__0
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__CallRule__Group_2_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCallRuleAccess().getGroup_2_1()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:3366:1: rule__CallRule__Group_2_1__0 : rule__CallRule__Group_2_1__0__Impl rule__CallRule__Group_2_1__1 ;
    public final void rule__CallRule__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3370:1: ( rule__CallRule__Group_2_1__0__Impl rule__CallRule__Group_2_1__1 )
            // InternalInstanceLanguage.g:3371:2: rule__CallRule__Group_2_1__0__Impl rule__CallRule__Group_2_1__1
            {
            pushFollow(FOLLOW_15);
            rule__CallRule__Group_2_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__CallRule__Group_2_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:3378:1: rule__CallRule__Group_2_1__0__Impl : ( ',' ) ;
    public final void rule__CallRule__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3382:1: ( ( ',' ) )
            // InternalInstanceLanguage.g:3383:1: ( ',' )
            {
            // InternalInstanceLanguage.g:3383:1: ( ',' )
            // InternalInstanceLanguage.g:3384:2: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getCommaKeyword_2_1_0()); 
            }
            match(input,52,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCallRuleAccess().getCommaKeyword_2_1_0()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:3393:1: rule__CallRule__Group_2_1__1 : rule__CallRule__Group_2_1__1__Impl ;
    public final void rule__CallRule__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3397:1: ( rule__CallRule__Group_2_1__1__Impl )
            // InternalInstanceLanguage.g:3398:2: rule__CallRule__Group_2_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CallRule__Group_2_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:3404:1: rule__CallRule__Group_2_1__1__Impl : ( ( rule__CallRule__ParametersAssignment_2_1_1 ) ) ;
    public final void rule__CallRule__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3408:1: ( ( ( rule__CallRule__ParametersAssignment_2_1_1 ) ) )
            // InternalInstanceLanguage.g:3409:1: ( ( rule__CallRule__ParametersAssignment_2_1_1 ) )
            {
            // InternalInstanceLanguage.g:3409:1: ( ( rule__CallRule__ParametersAssignment_2_1_1 ) )
            // InternalInstanceLanguage.g:3410:2: ( rule__CallRule__ParametersAssignment_2_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getParametersAssignment_2_1_1()); 
            }
            // InternalInstanceLanguage.g:3411:2: ( rule__CallRule__ParametersAssignment_2_1_1 )
            // InternalInstanceLanguage.g:3411:3: rule__CallRule__ParametersAssignment_2_1_1
            {
            pushFollow(FOLLOW_2);
            rule__CallRule__ParametersAssignment_2_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCallRuleAccess().getParametersAssignment_2_1_1()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__DataReferenceRule__Group__0"
    // InternalInstanceLanguage.g:3420:1: rule__DataReferenceRule__Group__0 : rule__DataReferenceRule__Group__0__Impl rule__DataReferenceRule__Group__1 ;
    public final void rule__DataReferenceRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3424:1: ( rule__DataReferenceRule__Group__0__Impl rule__DataReferenceRule__Group__1 )
            // InternalInstanceLanguage.g:3425:2: rule__DataReferenceRule__Group__0__Impl rule__DataReferenceRule__Group__1
            {
            pushFollow(FOLLOW_9);
            rule__DataReferenceRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__DataReferenceRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataReferenceRule__Group__0"


    // $ANTLR start "rule__DataReferenceRule__Group__0__Impl"
    // InternalInstanceLanguage.g:3432:1: rule__DataReferenceRule__Group__0__Impl : ( 'data' ) ;
    public final void rule__DataReferenceRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3436:1: ( ( 'data' ) )
            // InternalInstanceLanguage.g:3437:1: ( 'data' )
            {
            // InternalInstanceLanguage.g:3437:1: ( 'data' )
            // InternalInstanceLanguage.g:3438:2: 'data'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataReferenceRuleAccess().getDataKeyword_0()); 
            }
            match(input,59,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataReferenceRuleAccess().getDataKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataReferenceRule__Group__0__Impl"


    // $ANTLR start "rule__DataReferenceRule__Group__1"
    // InternalInstanceLanguage.g:3447:1: rule__DataReferenceRule__Group__1 : rule__DataReferenceRule__Group__1__Impl ;
    public final void rule__DataReferenceRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3451:1: ( rule__DataReferenceRule__Group__1__Impl )
            // InternalInstanceLanguage.g:3452:2: rule__DataReferenceRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataReferenceRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataReferenceRule__Group__1"


    // $ANTLR start "rule__DataReferenceRule__Group__1__Impl"
    // InternalInstanceLanguage.g:3458:1: rule__DataReferenceRule__Group__1__Impl : ( ( rule__DataReferenceRule__DefinitionAssignment_1 ) ) ;
    public final void rule__DataReferenceRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3462:1: ( ( ( rule__DataReferenceRule__DefinitionAssignment_1 ) ) )
            // InternalInstanceLanguage.g:3463:1: ( ( rule__DataReferenceRule__DefinitionAssignment_1 ) )
            {
            // InternalInstanceLanguage.g:3463:1: ( ( rule__DataReferenceRule__DefinitionAssignment_1 ) )
            // InternalInstanceLanguage.g:3464:2: ( rule__DataReferenceRule__DefinitionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataReferenceRuleAccess().getDefinitionAssignment_1()); 
            }
            // InternalInstanceLanguage.g:3465:2: ( rule__DataReferenceRule__DefinitionAssignment_1 )
            // InternalInstanceLanguage.g:3465:3: rule__DataReferenceRule__DefinitionAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__DataReferenceRule__DefinitionAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataReferenceRuleAccess().getDefinitionAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataReferenceRule__Group__1__Impl"


    // $ANTLR start "rule__InstanceLiteralRule__Group__0"
    // InternalInstanceLanguage.g:3474:1: rule__InstanceLiteralRule__Group__0 : rule__InstanceLiteralRule__Group__0__Impl rule__InstanceLiteralRule__Group__1 ;
    public final void rule__InstanceLiteralRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3478:1: ( rule__InstanceLiteralRule__Group__0__Impl rule__InstanceLiteralRule__Group__1 )
            // InternalInstanceLanguage.g:3479:2: rule__InstanceLiteralRule__Group__0__Impl rule__InstanceLiteralRule__Group__1
            {
            pushFollow(FOLLOW_31);
            rule__InstanceLiteralRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__InstanceLiteralRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceLiteralRule__Group__0"


    // $ANTLR start "rule__InstanceLiteralRule__Group__0__Impl"
    // InternalInstanceLanguage.g:3486:1: rule__InstanceLiteralRule__Group__0__Impl : ( ( rule__InstanceLiteralRule__DefinitionAssignment_0 ) ) ;
    public final void rule__InstanceLiteralRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3490:1: ( ( ( rule__InstanceLiteralRule__DefinitionAssignment_0 ) ) )
            // InternalInstanceLanguage.g:3491:1: ( ( rule__InstanceLiteralRule__DefinitionAssignment_0 ) )
            {
            // InternalInstanceLanguage.g:3491:1: ( ( rule__InstanceLiteralRule__DefinitionAssignment_0 ) )
            // InternalInstanceLanguage.g:3492:2: ( rule__InstanceLiteralRule__DefinitionAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceLiteralRuleAccess().getDefinitionAssignment_0()); 
            }
            // InternalInstanceLanguage.g:3493:2: ( rule__InstanceLiteralRule__DefinitionAssignment_0 )
            // InternalInstanceLanguage.g:3493:3: rule__InstanceLiteralRule__DefinitionAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__InstanceLiteralRule__DefinitionAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getInstanceLiteralRuleAccess().getDefinitionAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceLiteralRule__Group__0__Impl"


    // $ANTLR start "rule__InstanceLiteralRule__Group__1"
    // InternalInstanceLanguage.g:3501:1: rule__InstanceLiteralRule__Group__1 : rule__InstanceLiteralRule__Group__1__Impl rule__InstanceLiteralRule__Group__2 ;
    public final void rule__InstanceLiteralRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3505:1: ( rule__InstanceLiteralRule__Group__1__Impl rule__InstanceLiteralRule__Group__2 )
            // InternalInstanceLanguage.g:3506:2: rule__InstanceLiteralRule__Group__1__Impl rule__InstanceLiteralRule__Group__2
            {
            pushFollow(FOLLOW_32);
            rule__InstanceLiteralRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__InstanceLiteralRule__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceLiteralRule__Group__1"


    // $ANTLR start "rule__InstanceLiteralRule__Group__1__Impl"
    // InternalInstanceLanguage.g:3513:1: rule__InstanceLiteralRule__Group__1__Impl : ( '{' ) ;
    public final void rule__InstanceLiteralRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3517:1: ( ( '{' ) )
            // InternalInstanceLanguage.g:3518:1: ( '{' )
            {
            // InternalInstanceLanguage.g:3518:1: ( '{' )
            // InternalInstanceLanguage.g:3519:2: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceLiteralRuleAccess().getLeftCurlyBracketKeyword_1()); 
            }
            match(input,60,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getInstanceLiteralRuleAccess().getLeftCurlyBracketKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceLiteralRule__Group__1__Impl"


    // $ANTLR start "rule__InstanceLiteralRule__Group__2"
    // InternalInstanceLanguage.g:3528:1: rule__InstanceLiteralRule__Group__2 : rule__InstanceLiteralRule__Group__2__Impl rule__InstanceLiteralRule__Group__3 ;
    public final void rule__InstanceLiteralRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3532:1: ( rule__InstanceLiteralRule__Group__2__Impl rule__InstanceLiteralRule__Group__3 )
            // InternalInstanceLanguage.g:3533:2: rule__InstanceLiteralRule__Group__2__Impl rule__InstanceLiteralRule__Group__3
            {
            pushFollow(FOLLOW_32);
            rule__InstanceLiteralRule__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__InstanceLiteralRule__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceLiteralRule__Group__2"


    // $ANTLR start "rule__InstanceLiteralRule__Group__2__Impl"
    // InternalInstanceLanguage.g:3540:1: rule__InstanceLiteralRule__Group__2__Impl : ( ( rule__InstanceLiteralRule__AttributesAssignment_2 )* ) ;
    public final void rule__InstanceLiteralRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3544:1: ( ( ( rule__InstanceLiteralRule__AttributesAssignment_2 )* ) )
            // InternalInstanceLanguage.g:3545:1: ( ( rule__InstanceLiteralRule__AttributesAssignment_2 )* )
            {
            // InternalInstanceLanguage.g:3545:1: ( ( rule__InstanceLiteralRule__AttributesAssignment_2 )* )
            // InternalInstanceLanguage.g:3546:2: ( rule__InstanceLiteralRule__AttributesAssignment_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceLiteralRuleAccess().getAttributesAssignment_2()); 
            }
            // InternalInstanceLanguage.g:3547:2: ( rule__InstanceLiteralRule__AttributesAssignment_2 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( ((LA28_0>=RULE_QUOTED_ID && LA28_0<=RULE_ID)) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalInstanceLanguage.g:3547:3: rule__InstanceLiteralRule__AttributesAssignment_2
            	    {
            	    pushFollow(FOLLOW_33);
            	    rule__InstanceLiteralRule__AttributesAssignment_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getInstanceLiteralRuleAccess().getAttributesAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceLiteralRule__Group__2__Impl"


    // $ANTLR start "rule__InstanceLiteralRule__Group__3"
    // InternalInstanceLanguage.g:3555:1: rule__InstanceLiteralRule__Group__3 : rule__InstanceLiteralRule__Group__3__Impl ;
    public final void rule__InstanceLiteralRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3559:1: ( rule__InstanceLiteralRule__Group__3__Impl )
            // InternalInstanceLanguage.g:3560:2: rule__InstanceLiteralRule__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__InstanceLiteralRule__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceLiteralRule__Group__3"


    // $ANTLR start "rule__InstanceLiteralRule__Group__3__Impl"
    // InternalInstanceLanguage.g:3566:1: rule__InstanceLiteralRule__Group__3__Impl : ( '}' ) ;
    public final void rule__InstanceLiteralRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3570:1: ( ( '}' ) )
            // InternalInstanceLanguage.g:3571:1: ( '}' )
            {
            // InternalInstanceLanguage.g:3571:1: ( '}' )
            // InternalInstanceLanguage.g:3572:2: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceLiteralRuleAccess().getRightCurlyBracketKeyword_3()); 
            }
            match(input,61,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getInstanceLiteralRuleAccess().getRightCurlyBracketKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceLiteralRule__Group__3__Impl"


    // $ANTLR start "rule__AttributeRule__Group__0"
    // InternalInstanceLanguage.g:3582:1: rule__AttributeRule__Group__0 : rule__AttributeRule__Group__0__Impl rule__AttributeRule__Group__1 ;
    public final void rule__AttributeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3586:1: ( rule__AttributeRule__Group__0__Impl rule__AttributeRule__Group__1 )
            // InternalInstanceLanguage.g:3587:2: rule__AttributeRule__Group__0__Impl rule__AttributeRule__Group__1
            {
            pushFollow(FOLLOW_34);
            rule__AttributeRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__AttributeRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeRule__Group__0"


    // $ANTLR start "rule__AttributeRule__Group__0__Impl"
    // InternalInstanceLanguage.g:3594:1: rule__AttributeRule__Group__0__Impl : ( ( rule__AttributeRule__DefinitionAssignment_0 ) ) ;
    public final void rule__AttributeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3598:1: ( ( ( rule__AttributeRule__DefinitionAssignment_0 ) ) )
            // InternalInstanceLanguage.g:3599:1: ( ( rule__AttributeRule__DefinitionAssignment_0 ) )
            {
            // InternalInstanceLanguage.g:3599:1: ( ( rule__AttributeRule__DefinitionAssignment_0 ) )
            // InternalInstanceLanguage.g:3600:2: ( rule__AttributeRule__DefinitionAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeRuleAccess().getDefinitionAssignment_0()); 
            }
            // InternalInstanceLanguage.g:3601:2: ( rule__AttributeRule__DefinitionAssignment_0 )
            // InternalInstanceLanguage.g:3601:3: rule__AttributeRule__DefinitionAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__AttributeRule__DefinitionAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeRuleAccess().getDefinitionAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeRule__Group__0__Impl"


    // $ANTLR start "rule__AttributeRule__Group__1"
    // InternalInstanceLanguage.g:3609:1: rule__AttributeRule__Group__1 : rule__AttributeRule__Group__1__Impl rule__AttributeRule__Group__2 ;
    public final void rule__AttributeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3613:1: ( rule__AttributeRule__Group__1__Impl rule__AttributeRule__Group__2 )
            // InternalInstanceLanguage.g:3614:2: rule__AttributeRule__Group__1__Impl rule__AttributeRule__Group__2
            {
            pushFollow(FOLLOW_15);
            rule__AttributeRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__AttributeRule__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeRule__Group__1"


    // $ANTLR start "rule__AttributeRule__Group__1__Impl"
    // InternalInstanceLanguage.g:3621:1: rule__AttributeRule__Group__1__Impl : ( ':=' ) ;
    public final void rule__AttributeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3625:1: ( ( ':=' ) )
            // InternalInstanceLanguage.g:3626:1: ( ':=' )
            {
            // InternalInstanceLanguage.g:3626:1: ( ':=' )
            // InternalInstanceLanguage.g:3627:2: ':='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeRuleAccess().getColonEqualsSignKeyword_1()); 
            }
            match(input,62,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeRuleAccess().getColonEqualsSignKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeRule__Group__1__Impl"


    // $ANTLR start "rule__AttributeRule__Group__2"
    // InternalInstanceLanguage.g:3636:1: rule__AttributeRule__Group__2 : rule__AttributeRule__Group__2__Impl rule__AttributeRule__Group__3 ;
    public final void rule__AttributeRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3640:1: ( rule__AttributeRule__Group__2__Impl rule__AttributeRule__Group__3 )
            // InternalInstanceLanguage.g:3641:2: rule__AttributeRule__Group__2__Impl rule__AttributeRule__Group__3
            {
            pushFollow(FOLLOW_8);
            rule__AttributeRule__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__AttributeRule__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeRule__Group__2"


    // $ANTLR start "rule__AttributeRule__Group__2__Impl"
    // InternalInstanceLanguage.g:3648:1: rule__AttributeRule__Group__2__Impl : ( ( rule__AttributeRule__ValueAssignment_2 ) ) ;
    public final void rule__AttributeRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3652:1: ( ( ( rule__AttributeRule__ValueAssignment_2 ) ) )
            // InternalInstanceLanguage.g:3653:1: ( ( rule__AttributeRule__ValueAssignment_2 ) )
            {
            // InternalInstanceLanguage.g:3653:1: ( ( rule__AttributeRule__ValueAssignment_2 ) )
            // InternalInstanceLanguage.g:3654:2: ( rule__AttributeRule__ValueAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeRuleAccess().getValueAssignment_2()); 
            }
            // InternalInstanceLanguage.g:3655:2: ( rule__AttributeRule__ValueAssignment_2 )
            // InternalInstanceLanguage.g:3655:3: rule__AttributeRule__ValueAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__AttributeRule__ValueAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeRuleAccess().getValueAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeRule__Group__2__Impl"


    // $ANTLR start "rule__AttributeRule__Group__3"
    // InternalInstanceLanguage.g:3663:1: rule__AttributeRule__Group__3 : rule__AttributeRule__Group__3__Impl ;
    public final void rule__AttributeRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3667:1: ( rule__AttributeRule__Group__3__Impl )
            // InternalInstanceLanguage.g:3668:2: rule__AttributeRule__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AttributeRule__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeRule__Group__3"


    // $ANTLR start "rule__AttributeRule__Group__3__Impl"
    // InternalInstanceLanguage.g:3674:1: rule__AttributeRule__Group__3__Impl : ( ';' ) ;
    public final void rule__AttributeRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3678:1: ( ( ';' ) )
            // InternalInstanceLanguage.g:3679:1: ( ';' )
            {
            // InternalInstanceLanguage.g:3679:1: ( ';' )
            // InternalInstanceLanguage.g:3680:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeRuleAccess().getSemicolonKeyword_3()); 
            }
            match(input,50,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeRuleAccess().getSemicolonKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeRule__Group__3__Impl"


    // $ANTLR start "rule__RealLiteralRule__Group__0"
    // InternalInstanceLanguage.g:3690:1: rule__RealLiteralRule__Group__0 : rule__RealLiteralRule__Group__0__Impl rule__RealLiteralRule__Group__1 ;
    public final void rule__RealLiteralRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3694:1: ( rule__RealLiteralRule__Group__0__Impl rule__RealLiteralRule__Group__1 )
            // InternalInstanceLanguage.g:3695:2: rule__RealLiteralRule__Group__0__Impl rule__RealLiteralRule__Group__1
            {
            pushFollow(FOLLOW_35);
            rule__RealLiteralRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RealLiteralRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RealLiteralRule__Group__0"


    // $ANTLR start "rule__RealLiteralRule__Group__0__Impl"
    // InternalInstanceLanguage.g:3702:1: rule__RealLiteralRule__Group__0__Impl : ( ( rule__RealLiteralRule__LiteralAssignment_0 ) ) ;
    public final void rule__RealLiteralRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3706:1: ( ( ( rule__RealLiteralRule__LiteralAssignment_0 ) ) )
            // InternalInstanceLanguage.g:3707:1: ( ( rule__RealLiteralRule__LiteralAssignment_0 ) )
            {
            // InternalInstanceLanguage.g:3707:1: ( ( rule__RealLiteralRule__LiteralAssignment_0 ) )
            // InternalInstanceLanguage.g:3708:2: ( rule__RealLiteralRule__LiteralAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealLiteralRuleAccess().getLiteralAssignment_0()); 
            }
            // InternalInstanceLanguage.g:3709:2: ( rule__RealLiteralRule__LiteralAssignment_0 )
            // InternalInstanceLanguage.g:3709:3: rule__RealLiteralRule__LiteralAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__RealLiteralRule__LiteralAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRealLiteralRuleAccess().getLiteralAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RealLiteralRule__Group__0__Impl"


    // $ANTLR start "rule__RealLiteralRule__Group__1"
    // InternalInstanceLanguage.g:3717:1: rule__RealLiteralRule__Group__1 : rule__RealLiteralRule__Group__1__Impl ;
    public final void rule__RealLiteralRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3721:1: ( rule__RealLiteralRule__Group__1__Impl )
            // InternalInstanceLanguage.g:3722:2: rule__RealLiteralRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RealLiteralRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RealLiteralRule__Group__1"


    // $ANTLR start "rule__RealLiteralRule__Group__1__Impl"
    // InternalInstanceLanguage.g:3728:1: rule__RealLiteralRule__Group__1__Impl : ( ( rule__RealLiteralRule__FactorAssignment_1 )? ) ;
    public final void rule__RealLiteralRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3732:1: ( ( ( rule__RealLiteralRule__FactorAssignment_1 )? ) )
            // InternalInstanceLanguage.g:3733:1: ( ( rule__RealLiteralRule__FactorAssignment_1 )? )
            {
            // InternalInstanceLanguage.g:3733:1: ( ( rule__RealLiteralRule__FactorAssignment_1 )? )
            // InternalInstanceLanguage.g:3734:2: ( rule__RealLiteralRule__FactorAssignment_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealLiteralRuleAccess().getFactorAssignment_1()); 
            }
            // InternalInstanceLanguage.g:3735:2: ( rule__RealLiteralRule__FactorAssignment_1 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( ((LA29_0>=27 && LA29_0<=46)) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalInstanceLanguage.g:3735:3: rule__RealLiteralRule__FactorAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__RealLiteralRule__FactorAssignment_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRealLiteralRuleAccess().getFactorAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RealLiteralRule__Group__1__Impl"


    // $ANTLR start "rule__IntegerLiteralRule__Group__0"
    // InternalInstanceLanguage.g:3744:1: rule__IntegerLiteralRule__Group__0 : rule__IntegerLiteralRule__Group__0__Impl rule__IntegerLiteralRule__Group__1 ;
    public final void rule__IntegerLiteralRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3748:1: ( rule__IntegerLiteralRule__Group__0__Impl rule__IntegerLiteralRule__Group__1 )
            // InternalInstanceLanguage.g:3749:2: rule__IntegerLiteralRule__Group__0__Impl rule__IntegerLiteralRule__Group__1
            {
            pushFollow(FOLLOW_35);
            rule__IntegerLiteralRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__IntegerLiteralRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:3756:1: rule__IntegerLiteralRule__Group__0__Impl : ( ( rule__IntegerLiteralRule__LiteralAssignment_0 ) ) ;
    public final void rule__IntegerLiteralRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3760:1: ( ( ( rule__IntegerLiteralRule__LiteralAssignment_0 ) ) )
            // InternalInstanceLanguage.g:3761:1: ( ( rule__IntegerLiteralRule__LiteralAssignment_0 ) )
            {
            // InternalInstanceLanguage.g:3761:1: ( ( rule__IntegerLiteralRule__LiteralAssignment_0 ) )
            // InternalInstanceLanguage.g:3762:2: ( rule__IntegerLiteralRule__LiteralAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegerLiteralRuleAccess().getLiteralAssignment_0()); 
            }
            // InternalInstanceLanguage.g:3763:2: ( rule__IntegerLiteralRule__LiteralAssignment_0 )
            // InternalInstanceLanguage.g:3763:3: rule__IntegerLiteralRule__LiteralAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__IntegerLiteralRule__LiteralAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getIntegerLiteralRuleAccess().getLiteralAssignment_0()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:3771:1: rule__IntegerLiteralRule__Group__1 : rule__IntegerLiteralRule__Group__1__Impl ;
    public final void rule__IntegerLiteralRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3775:1: ( rule__IntegerLiteralRule__Group__1__Impl )
            // InternalInstanceLanguage.g:3776:2: rule__IntegerLiteralRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__IntegerLiteralRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:3782:1: rule__IntegerLiteralRule__Group__1__Impl : ( ( rule__IntegerLiteralRule__FactorAssignment_1 )? ) ;
    public final void rule__IntegerLiteralRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3786:1: ( ( ( rule__IntegerLiteralRule__FactorAssignment_1 )? ) )
            // InternalInstanceLanguage.g:3787:1: ( ( rule__IntegerLiteralRule__FactorAssignment_1 )? )
            {
            // InternalInstanceLanguage.g:3787:1: ( ( rule__IntegerLiteralRule__FactorAssignment_1 )? )
            // InternalInstanceLanguage.g:3788:2: ( rule__IntegerLiteralRule__FactorAssignment_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegerLiteralRuleAccess().getFactorAssignment_1()); 
            }
            // InternalInstanceLanguage.g:3789:2: ( rule__IntegerLiteralRule__FactorAssignment_1 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( ((LA30_0>=27 && LA30_0<=46)) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalInstanceLanguage.g:3789:3: rule__IntegerLiteralRule__FactorAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__IntegerLiteralRule__FactorAssignment_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getIntegerLiteralRuleAccess().getFactorAssignment_1()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:3798:1: rule__BooleanLiteralRule__Group__0 : rule__BooleanLiteralRule__Group__0__Impl rule__BooleanLiteralRule__Group__1 ;
    public final void rule__BooleanLiteralRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3802:1: ( rule__BooleanLiteralRule__Group__0__Impl rule__BooleanLiteralRule__Group__1 )
            // InternalInstanceLanguage.g:3803:2: rule__BooleanLiteralRule__Group__0__Impl rule__BooleanLiteralRule__Group__1
            {
            pushFollow(FOLLOW_36);
            rule__BooleanLiteralRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__BooleanLiteralRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:3810:1: rule__BooleanLiteralRule__Group__0__Impl : ( () ) ;
    public final void rule__BooleanLiteralRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3814:1: ( ( () ) )
            // InternalInstanceLanguage.g:3815:1: ( () )
            {
            // InternalInstanceLanguage.g:3815:1: ( () )
            // InternalInstanceLanguage.g:3816:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralRuleAccess().getBooleanLiteralAction_0()); 
            }
            // InternalInstanceLanguage.g:3817:2: ()
            // InternalInstanceLanguage.g:3817:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBooleanLiteralRuleAccess().getBooleanLiteralAction_0()); 
            }

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
    // InternalInstanceLanguage.g:3825:1: rule__BooleanLiteralRule__Group__1 : rule__BooleanLiteralRule__Group__1__Impl ;
    public final void rule__BooleanLiteralRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3829:1: ( rule__BooleanLiteralRule__Group__1__Impl )
            // InternalInstanceLanguage.g:3830:2: rule__BooleanLiteralRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__BooleanLiteralRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:3836:1: rule__BooleanLiteralRule__Group__1__Impl : ( ( rule__BooleanLiteralRule__Alternatives_1 ) ) ;
    public final void rule__BooleanLiteralRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3840:1: ( ( ( rule__BooleanLiteralRule__Alternatives_1 ) ) )
            // InternalInstanceLanguage.g:3841:1: ( ( rule__BooleanLiteralRule__Alternatives_1 ) )
            {
            // InternalInstanceLanguage.g:3841:1: ( ( rule__BooleanLiteralRule__Alternatives_1 ) )
            // InternalInstanceLanguage.g:3842:2: ( rule__BooleanLiteralRule__Alternatives_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralRuleAccess().getAlternatives_1()); 
            }
            // InternalInstanceLanguage.g:3843:2: ( rule__BooleanLiteralRule__Alternatives_1 )
            // InternalInstanceLanguage.g:3843:3: rule__BooleanLiteralRule__Alternatives_1
            {
            pushFollow(FOLLOW_2);
            rule__BooleanLiteralRule__Alternatives_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBooleanLiteralRuleAccess().getAlternatives_1()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__ConstraintRule__Group__0"
    // InternalInstanceLanguage.g:3852:1: rule__ConstraintRule__Group__0 : rule__ConstraintRule__Group__0__Impl rule__ConstraintRule__Group__1 ;
    public final void rule__ConstraintRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3856:1: ( rule__ConstraintRule__Group__0__Impl rule__ConstraintRule__Group__1 )
            // InternalInstanceLanguage.g:3857:2: rule__ConstraintRule__Group__0__Impl rule__ConstraintRule__Group__1
            {
            pushFollow(FOLLOW_9);
            rule__ConstraintRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ConstraintRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintRule__Group__0"


    // $ANTLR start "rule__ConstraintRule__Group__0__Impl"
    // InternalInstanceLanguage.g:3864:1: rule__ConstraintRule__Group__0__Impl : ( '@' ) ;
    public final void rule__ConstraintRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3868:1: ( ( '@' ) )
            // InternalInstanceLanguage.g:3869:1: ( '@' )
            {
            // InternalInstanceLanguage.g:3869:1: ( '@' )
            // InternalInstanceLanguage.g:3870:2: '@'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstraintRuleAccess().getCommercialAtKeyword_0()); 
            }
            match(input,63,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstraintRuleAccess().getCommercialAtKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintRule__Group__0__Impl"


    // $ANTLR start "rule__ConstraintRule__Group__1"
    // InternalInstanceLanguage.g:3879:1: rule__ConstraintRule__Group__1 : rule__ConstraintRule__Group__1__Impl ;
    public final void rule__ConstraintRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3883:1: ( rule__ConstraintRule__Group__1__Impl )
            // InternalInstanceLanguage.g:3884:2: rule__ConstraintRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ConstraintRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintRule__Group__1"


    // $ANTLR start "rule__ConstraintRule__Group__1__Impl"
    // InternalInstanceLanguage.g:3890:1: rule__ConstraintRule__Group__1__Impl : ( ruleInstanceLiteralRule ) ;
    public final void rule__ConstraintRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3894:1: ( ( ruleInstanceLiteralRule ) )
            // InternalInstanceLanguage.g:3895:1: ( ruleInstanceLiteralRule )
            {
            // InternalInstanceLanguage.g:3895:1: ( ruleInstanceLiteralRule )
            // InternalInstanceLanguage.g:3896:2: ruleInstanceLiteralRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstraintRuleAccess().getInstanceLiteralRuleParserRuleCall_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleInstanceLiteralRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstraintRuleAccess().getInstanceLiteralRuleParserRuleCall_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintRule__Group__1__Impl"


    // $ANTLR start "rule__AttributeDefinitionRule__Group__0"
    // InternalInstanceLanguage.g:3906:1: rule__AttributeDefinitionRule__Group__0 : rule__AttributeDefinitionRule__Group__0__Impl rule__AttributeDefinitionRule__Group__1 ;
    public final void rule__AttributeDefinitionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3910:1: ( rule__AttributeDefinitionRule__Group__0__Impl rule__AttributeDefinitionRule__Group__1 )
            // InternalInstanceLanguage.g:3911:2: rule__AttributeDefinitionRule__Group__0__Impl rule__AttributeDefinitionRule__Group__1
            {
            pushFollow(FOLLOW_9);
            rule__AttributeDefinitionRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__AttributeDefinitionRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:3918:1: rule__AttributeDefinitionRule__Group__0__Impl : ( ( rule__AttributeDefinitionRule__ConstraintsAssignment_0 )* ) ;
    public final void rule__AttributeDefinitionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3922:1: ( ( ( rule__AttributeDefinitionRule__ConstraintsAssignment_0 )* ) )
            // InternalInstanceLanguage.g:3923:1: ( ( rule__AttributeDefinitionRule__ConstraintsAssignment_0 )* )
            {
            // InternalInstanceLanguage.g:3923:1: ( ( rule__AttributeDefinitionRule__ConstraintsAssignment_0 )* )
            // InternalInstanceLanguage.g:3924:2: ( rule__AttributeDefinitionRule__ConstraintsAssignment_0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getConstraintsAssignment_0()); 
            }
            // InternalInstanceLanguage.g:3925:2: ( rule__AttributeDefinitionRule__ConstraintsAssignment_0 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==63) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalInstanceLanguage.g:3925:3: rule__AttributeDefinitionRule__ConstraintsAssignment_0
            	    {
            	    pushFollow(FOLLOW_37);
            	    rule__AttributeDefinitionRule__ConstraintsAssignment_0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeDefinitionRuleAccess().getConstraintsAssignment_0()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:3933:1: rule__AttributeDefinitionRule__Group__1 : rule__AttributeDefinitionRule__Group__1__Impl rule__AttributeDefinitionRule__Group__2 ;
    public final void rule__AttributeDefinitionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3937:1: ( rule__AttributeDefinitionRule__Group__1__Impl rule__AttributeDefinitionRule__Group__2 )
            // InternalInstanceLanguage.g:3938:2: rule__AttributeDefinitionRule__Group__1__Impl rule__AttributeDefinitionRule__Group__2
            {
            pushFollow(FOLLOW_38);
            rule__AttributeDefinitionRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__AttributeDefinitionRule__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:3945:1: rule__AttributeDefinitionRule__Group__1__Impl : ( ( rule__AttributeDefinitionRule__NameAssignment_1 ) ) ;
    public final void rule__AttributeDefinitionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3949:1: ( ( ( rule__AttributeDefinitionRule__NameAssignment_1 ) ) )
            // InternalInstanceLanguage.g:3950:1: ( ( rule__AttributeDefinitionRule__NameAssignment_1 ) )
            {
            // InternalInstanceLanguage.g:3950:1: ( ( rule__AttributeDefinitionRule__NameAssignment_1 ) )
            // InternalInstanceLanguage.g:3951:2: ( rule__AttributeDefinitionRule__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getNameAssignment_1()); 
            }
            // InternalInstanceLanguage.g:3952:2: ( rule__AttributeDefinitionRule__NameAssignment_1 )
            // InternalInstanceLanguage.g:3952:3: rule__AttributeDefinitionRule__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__AttributeDefinitionRule__NameAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeDefinitionRuleAccess().getNameAssignment_1()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:3960:1: rule__AttributeDefinitionRule__Group__2 : rule__AttributeDefinitionRule__Group__2__Impl rule__AttributeDefinitionRule__Group__3 ;
    public final void rule__AttributeDefinitionRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3964:1: ( rule__AttributeDefinitionRule__Group__2__Impl rule__AttributeDefinitionRule__Group__3 )
            // InternalInstanceLanguage.g:3965:2: rule__AttributeDefinitionRule__Group__2__Impl rule__AttributeDefinitionRule__Group__3
            {
            pushFollow(FOLLOW_39);
            rule__AttributeDefinitionRule__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__AttributeDefinitionRule__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:3972:1: rule__AttributeDefinitionRule__Group__2__Impl : ( ':' ) ;
    public final void rule__AttributeDefinitionRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3976:1: ( ( ':' ) )
            // InternalInstanceLanguage.g:3977:1: ( ':' )
            {
            // InternalInstanceLanguage.g:3977:1: ( ':' )
            // InternalInstanceLanguage.g:3978:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getColonKeyword_2()); 
            }
            match(input,64,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeDefinitionRuleAccess().getColonKeyword_2()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:3987:1: rule__AttributeDefinitionRule__Group__3 : rule__AttributeDefinitionRule__Group__3__Impl rule__AttributeDefinitionRule__Group__4 ;
    public final void rule__AttributeDefinitionRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3991:1: ( rule__AttributeDefinitionRule__Group__3__Impl rule__AttributeDefinitionRule__Group__4 )
            // InternalInstanceLanguage.g:3992:2: rule__AttributeDefinitionRule__Group__3__Impl rule__AttributeDefinitionRule__Group__4
            {
            pushFollow(FOLLOW_40);
            rule__AttributeDefinitionRule__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__AttributeDefinitionRule__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:3999:1: rule__AttributeDefinitionRule__Group__3__Impl : ( ( rule__AttributeDefinitionRule__TypeAssignment_3 ) ) ;
    public final void rule__AttributeDefinitionRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4003:1: ( ( ( rule__AttributeDefinitionRule__TypeAssignment_3 ) ) )
            // InternalInstanceLanguage.g:4004:1: ( ( rule__AttributeDefinitionRule__TypeAssignment_3 ) )
            {
            // InternalInstanceLanguage.g:4004:1: ( ( rule__AttributeDefinitionRule__TypeAssignment_3 ) )
            // InternalInstanceLanguage.g:4005:2: ( rule__AttributeDefinitionRule__TypeAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getTypeAssignment_3()); 
            }
            // InternalInstanceLanguage.g:4006:2: ( rule__AttributeDefinitionRule__TypeAssignment_3 )
            // InternalInstanceLanguage.g:4006:3: rule__AttributeDefinitionRule__TypeAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__AttributeDefinitionRule__TypeAssignment_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeDefinitionRuleAccess().getTypeAssignment_3()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:4014:1: rule__AttributeDefinitionRule__Group__4 : rule__AttributeDefinitionRule__Group__4__Impl rule__AttributeDefinitionRule__Group__5 ;
    public final void rule__AttributeDefinitionRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4018:1: ( rule__AttributeDefinitionRule__Group__4__Impl rule__AttributeDefinitionRule__Group__5 )
            // InternalInstanceLanguage.g:4019:2: rule__AttributeDefinitionRule__Group__4__Impl rule__AttributeDefinitionRule__Group__5
            {
            pushFollow(FOLLOW_40);
            rule__AttributeDefinitionRule__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__AttributeDefinitionRule__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:4026:1: rule__AttributeDefinitionRule__Group__4__Impl : ( ( rule__AttributeDefinitionRule__Group_4__0 )? ) ;
    public final void rule__AttributeDefinitionRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4030:1: ( ( ( rule__AttributeDefinitionRule__Group_4__0 )? ) )
            // InternalInstanceLanguage.g:4031:1: ( ( rule__AttributeDefinitionRule__Group_4__0 )? )
            {
            // InternalInstanceLanguage.g:4031:1: ( ( rule__AttributeDefinitionRule__Group_4__0 )? )
            // InternalInstanceLanguage.g:4032:2: ( rule__AttributeDefinitionRule__Group_4__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getGroup_4()); 
            }
            // InternalInstanceLanguage.g:4033:2: ( rule__AttributeDefinitionRule__Group_4__0 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==62) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalInstanceLanguage.g:4033:3: rule__AttributeDefinitionRule__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__AttributeDefinitionRule__Group_4__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeDefinitionRuleAccess().getGroup_4()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__AttributeDefinitionRule__Group__5"
    // InternalInstanceLanguage.g:4041:1: rule__AttributeDefinitionRule__Group__5 : rule__AttributeDefinitionRule__Group__5__Impl ;
    public final void rule__AttributeDefinitionRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4045:1: ( rule__AttributeDefinitionRule__Group__5__Impl )
            // InternalInstanceLanguage.g:4046:2: rule__AttributeDefinitionRule__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AttributeDefinitionRule__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeDefinitionRule__Group__5"


    // $ANTLR start "rule__AttributeDefinitionRule__Group__5__Impl"
    // InternalInstanceLanguage.g:4052:1: rule__AttributeDefinitionRule__Group__5__Impl : ( ';' ) ;
    public final void rule__AttributeDefinitionRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4056:1: ( ( ';' ) )
            // InternalInstanceLanguage.g:4057:1: ( ';' )
            {
            // InternalInstanceLanguage.g:4057:1: ( ';' )
            // InternalInstanceLanguage.g:4058:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getSemicolonKeyword_5()); 
            }
            match(input,50,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeDefinitionRuleAccess().getSemicolonKeyword_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeDefinitionRule__Group__5__Impl"


    // $ANTLR start "rule__AttributeDefinitionRule__Group_4__0"
    // InternalInstanceLanguage.g:4068:1: rule__AttributeDefinitionRule__Group_4__0 : rule__AttributeDefinitionRule__Group_4__0__Impl rule__AttributeDefinitionRule__Group_4__1 ;
    public final void rule__AttributeDefinitionRule__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4072:1: ( rule__AttributeDefinitionRule__Group_4__0__Impl rule__AttributeDefinitionRule__Group_4__1 )
            // InternalInstanceLanguage.g:4073:2: rule__AttributeDefinitionRule__Group_4__0__Impl rule__AttributeDefinitionRule__Group_4__1
            {
            pushFollow(FOLLOW_15);
            rule__AttributeDefinitionRule__Group_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__AttributeDefinitionRule__Group_4__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeDefinitionRule__Group_4__0"


    // $ANTLR start "rule__AttributeDefinitionRule__Group_4__0__Impl"
    // InternalInstanceLanguage.g:4080:1: rule__AttributeDefinitionRule__Group_4__0__Impl : ( ':=' ) ;
    public final void rule__AttributeDefinitionRule__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4084:1: ( ( ':=' ) )
            // InternalInstanceLanguage.g:4085:1: ( ':=' )
            {
            // InternalInstanceLanguage.g:4085:1: ( ':=' )
            // InternalInstanceLanguage.g:4086:2: ':='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getColonEqualsSignKeyword_4_0()); 
            }
            match(input,62,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeDefinitionRuleAccess().getColonEqualsSignKeyword_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeDefinitionRule__Group_4__0__Impl"


    // $ANTLR start "rule__AttributeDefinitionRule__Group_4__1"
    // InternalInstanceLanguage.g:4095:1: rule__AttributeDefinitionRule__Group_4__1 : rule__AttributeDefinitionRule__Group_4__1__Impl ;
    public final void rule__AttributeDefinitionRule__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4099:1: ( rule__AttributeDefinitionRule__Group_4__1__Impl )
            // InternalInstanceLanguage.g:4100:2: rule__AttributeDefinitionRule__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AttributeDefinitionRule__Group_4__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeDefinitionRule__Group_4__1"


    // $ANTLR start "rule__AttributeDefinitionRule__Group_4__1__Impl"
    // InternalInstanceLanguage.g:4106:1: rule__AttributeDefinitionRule__Group_4__1__Impl : ( ( rule__AttributeDefinitionRule__InitialisationAssignment_4_1 ) ) ;
    public final void rule__AttributeDefinitionRule__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4110:1: ( ( ( rule__AttributeDefinitionRule__InitialisationAssignment_4_1 ) ) )
            // InternalInstanceLanguage.g:4111:1: ( ( rule__AttributeDefinitionRule__InitialisationAssignment_4_1 ) )
            {
            // InternalInstanceLanguage.g:4111:1: ( ( rule__AttributeDefinitionRule__InitialisationAssignment_4_1 ) )
            // InternalInstanceLanguage.g:4112:2: ( rule__AttributeDefinitionRule__InitialisationAssignment_4_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getInitialisationAssignment_4_1()); 
            }
            // InternalInstanceLanguage.g:4113:2: ( rule__AttributeDefinitionRule__InitialisationAssignment_4_1 )
            // InternalInstanceLanguage.g:4113:3: rule__AttributeDefinitionRule__InitialisationAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__AttributeDefinitionRule__InitialisationAssignment_4_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeDefinitionRuleAccess().getInitialisationAssignment_4_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeDefinitionRule__Group_4__1__Impl"


    // $ANTLR start "rule__LiteralTypeRule__Group__0"
    // InternalInstanceLanguage.g:4122:1: rule__LiteralTypeRule__Group__0 : rule__LiteralTypeRule__Group__0__Impl rule__LiteralTypeRule__Group__1 ;
    public final void rule__LiteralTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4126:1: ( rule__LiteralTypeRule__Group__0__Impl rule__LiteralTypeRule__Group__1 )
            // InternalInstanceLanguage.g:4127:2: rule__LiteralTypeRule__Group__0__Impl rule__LiteralTypeRule__Group__1
            {
            pushFollow(FOLLOW_41);
            rule__LiteralTypeRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__LiteralTypeRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:4134:1: rule__LiteralTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__LiteralTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4138:1: ( ( () ) )
            // InternalInstanceLanguage.g:4139:1: ( () )
            {
            // InternalInstanceLanguage.g:4139:1: ( () )
            // InternalInstanceLanguage.g:4140:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralTypeRuleAccess().getLiteralTypeAction_0()); 
            }
            // InternalInstanceLanguage.g:4141:2: ()
            // InternalInstanceLanguage.g:4141:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLiteralTypeRuleAccess().getLiteralTypeAction_0()); 
            }

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
    // InternalInstanceLanguage.g:4149:1: rule__LiteralTypeRule__Group__1 : rule__LiteralTypeRule__Group__1__Impl ;
    public final void rule__LiteralTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4153:1: ( rule__LiteralTypeRule__Group__1__Impl )
            // InternalInstanceLanguage.g:4154:2: rule__LiteralTypeRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__LiteralTypeRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:4160:1: rule__LiteralTypeRule__Group__1__Impl : ( 'literal' ) ;
    public final void rule__LiteralTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4164:1: ( ( 'literal' ) )
            // InternalInstanceLanguage.g:4165:1: ( 'literal' )
            {
            // InternalInstanceLanguage.g:4165:1: ( 'literal' )
            // InternalInstanceLanguage.g:4166:2: 'literal'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralTypeRuleAccess().getLiteralKeyword_1()); 
            }
            match(input,65,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLiteralTypeRuleAccess().getLiteralKeyword_1()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__DataTypeRule__Group__0"
    // InternalInstanceLanguage.g:4176:1: rule__DataTypeRule__Group__0 : rule__DataTypeRule__Group__0__Impl rule__DataTypeRule__Group__1 ;
    public final void rule__DataTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4180:1: ( rule__DataTypeRule__Group__0__Impl rule__DataTypeRule__Group__1 )
            // InternalInstanceLanguage.g:4181:2: rule__DataTypeRule__Group__0__Impl rule__DataTypeRule__Group__1
            {
            pushFollow(FOLLOW_39);
            rule__DataTypeRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__DataTypeRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:4188:1: rule__DataTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__DataTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4192:1: ( ( () ) )
            // InternalInstanceLanguage.g:4193:1: ( () )
            {
            // InternalInstanceLanguage.g:4193:1: ( () )
            // InternalInstanceLanguage.g:4194:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getDataTypeAction_0()); 
            }
            // InternalInstanceLanguage.g:4195:2: ()
            // InternalInstanceLanguage.g:4195:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataTypeRuleAccess().getDataTypeAction_0()); 
            }

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
    // InternalInstanceLanguage.g:4203:1: rule__DataTypeRule__Group__1 : rule__DataTypeRule__Group__1__Impl ;
    public final void rule__DataTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4207:1: ( rule__DataTypeRule__Group__1__Impl )
            // InternalInstanceLanguage.g:4208:2: rule__DataTypeRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataTypeRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:4214:1: rule__DataTypeRule__Group__1__Impl : ( 'data' ) ;
    public final void rule__DataTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4218:1: ( ( 'data' ) )
            // InternalInstanceLanguage.g:4219:1: ( 'data' )
            {
            // InternalInstanceLanguage.g:4219:1: ( 'data' )
            // InternalInstanceLanguage.g:4220:2: 'data'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getDataKeyword_1()); 
            }
            match(input,59,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataTypeRuleAccess().getDataKeyword_1()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__InstanceTypeRule__Group__0"
    // InternalInstanceLanguage.g:4230:1: rule__InstanceTypeRule__Group__0 : rule__InstanceTypeRule__Group__0__Impl rule__InstanceTypeRule__Group__1 ;
    public final void rule__InstanceTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4234:1: ( rule__InstanceTypeRule__Group__0__Impl rule__InstanceTypeRule__Group__1 )
            // InternalInstanceLanguage.g:4235:2: rule__InstanceTypeRule__Group__0__Impl rule__InstanceTypeRule__Group__1
            {
            pushFollow(FOLLOW_12);
            rule__InstanceTypeRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__InstanceTypeRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:4242:1: rule__InstanceTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__InstanceTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4246:1: ( ( () ) )
            // InternalInstanceLanguage.g:4247:1: ( () )
            {
            // InternalInstanceLanguage.g:4247:1: ( () )
            // InternalInstanceLanguage.g:4248:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceTypeRuleAccess().getInstanceTypeAction_0()); 
            }
            // InternalInstanceLanguage.g:4249:2: ()
            // InternalInstanceLanguage.g:4249:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getInstanceTypeRuleAccess().getInstanceTypeAction_0()); 
            }

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
    // InternalInstanceLanguage.g:4257:1: rule__InstanceTypeRule__Group__1 : rule__InstanceTypeRule__Group__1__Impl rule__InstanceTypeRule__Group__2 ;
    public final void rule__InstanceTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4261:1: ( rule__InstanceTypeRule__Group__1__Impl rule__InstanceTypeRule__Group__2 )
            // InternalInstanceLanguage.g:4262:2: rule__InstanceTypeRule__Group__1__Impl rule__InstanceTypeRule__Group__2
            {
            pushFollow(FOLLOW_9);
            rule__InstanceTypeRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__InstanceTypeRule__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:4269:1: rule__InstanceTypeRule__Group__1__Impl : ( 'instance' ) ;
    public final void rule__InstanceTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4273:1: ( ( 'instance' ) )
            // InternalInstanceLanguage.g:4274:1: ( 'instance' )
            {
            // InternalInstanceLanguage.g:4274:1: ( 'instance' )
            // InternalInstanceLanguage.g:4275:2: 'instance'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceTypeRuleAccess().getInstanceKeyword_1()); 
            }
            match(input,51,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getInstanceTypeRuleAccess().getInstanceKeyword_1()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:4284:1: rule__InstanceTypeRule__Group__2 : rule__InstanceTypeRule__Group__2__Impl ;
    public final void rule__InstanceTypeRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4288:1: ( rule__InstanceTypeRule__Group__2__Impl )
            // InternalInstanceLanguage.g:4289:2: rule__InstanceTypeRule__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__InstanceTypeRule__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:4295:1: rule__InstanceTypeRule__Group__2__Impl : ( ( rule__InstanceTypeRule__DefinitionAssignment_2 ) ) ;
    public final void rule__InstanceTypeRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4299:1: ( ( ( rule__InstanceTypeRule__DefinitionAssignment_2 ) ) )
            // InternalInstanceLanguage.g:4300:1: ( ( rule__InstanceTypeRule__DefinitionAssignment_2 ) )
            {
            // InternalInstanceLanguage.g:4300:1: ( ( rule__InstanceTypeRule__DefinitionAssignment_2 ) )
            // InternalInstanceLanguage.g:4301:2: ( rule__InstanceTypeRule__DefinitionAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceTypeRuleAccess().getDefinitionAssignment_2()); 
            }
            // InternalInstanceLanguage.g:4302:2: ( rule__InstanceTypeRule__DefinitionAssignment_2 )
            // InternalInstanceLanguage.g:4302:3: rule__InstanceTypeRule__DefinitionAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__InstanceTypeRule__DefinitionAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getInstanceTypeRuleAccess().getDefinitionAssignment_2()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__StringTypeRule__Group__0"
    // InternalInstanceLanguage.g:4311:1: rule__StringTypeRule__Group__0 : rule__StringTypeRule__Group__0__Impl rule__StringTypeRule__Group__1 ;
    public final void rule__StringTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4315:1: ( rule__StringTypeRule__Group__0__Impl rule__StringTypeRule__Group__1 )
            // InternalInstanceLanguage.g:4316:2: rule__StringTypeRule__Group__0__Impl rule__StringTypeRule__Group__1
            {
            pushFollow(FOLLOW_42);
            rule__StringTypeRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__StringTypeRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:4323:1: rule__StringTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__StringTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4327:1: ( ( () ) )
            // InternalInstanceLanguage.g:4328:1: ( () )
            {
            // InternalInstanceLanguage.g:4328:1: ( () )
            // InternalInstanceLanguage.g:4329:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringTypeRuleAccess().getStringTypeAction_0()); 
            }
            // InternalInstanceLanguage.g:4330:2: ()
            // InternalInstanceLanguage.g:4330:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getStringTypeRuleAccess().getStringTypeAction_0()); 
            }

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
    // InternalInstanceLanguage.g:4338:1: rule__StringTypeRule__Group__1 : rule__StringTypeRule__Group__1__Impl ;
    public final void rule__StringTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4342:1: ( rule__StringTypeRule__Group__1__Impl )
            // InternalInstanceLanguage.g:4343:2: rule__StringTypeRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__StringTypeRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:4349:1: rule__StringTypeRule__Group__1__Impl : ( 'string' ) ;
    public final void rule__StringTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4353:1: ( ( 'string' ) )
            // InternalInstanceLanguage.g:4354:1: ( 'string' )
            {
            // InternalInstanceLanguage.g:4354:1: ( 'string' )
            // InternalInstanceLanguage.g:4355:2: 'string'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringTypeRuleAccess().getStringKeyword_1()); 
            }
            match(input,66,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getStringTypeRuleAccess().getStringKeyword_1()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:4365:1: rule__ExpressionTypeRule__Group__0 : rule__ExpressionTypeRule__Group__0__Impl rule__ExpressionTypeRule__Group__1 ;
    public final void rule__ExpressionTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4369:1: ( rule__ExpressionTypeRule__Group__0__Impl rule__ExpressionTypeRule__Group__1 )
            // InternalInstanceLanguage.g:4370:2: rule__ExpressionTypeRule__Group__0__Impl rule__ExpressionTypeRule__Group__1
            {
            pushFollow(FOLLOW_43);
            rule__ExpressionTypeRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ExpressionTypeRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:4377:1: rule__ExpressionTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__ExpressionTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4381:1: ( ( () ) )
            // InternalInstanceLanguage.g:4382:1: ( () )
            {
            // InternalInstanceLanguage.g:4382:1: ( () )
            // InternalInstanceLanguage.g:4383:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionTypeRuleAccess().getExpressionTypeAction_0()); 
            }
            // InternalInstanceLanguage.g:4384:2: ()
            // InternalInstanceLanguage.g:4384:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpressionTypeRuleAccess().getExpressionTypeAction_0()); 
            }

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
    // InternalInstanceLanguage.g:4392:1: rule__ExpressionTypeRule__Group__1 : rule__ExpressionTypeRule__Group__1__Impl ;
    public final void rule__ExpressionTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4396:1: ( rule__ExpressionTypeRule__Group__1__Impl )
            // InternalInstanceLanguage.g:4397:2: rule__ExpressionTypeRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ExpressionTypeRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:4403:1: rule__ExpressionTypeRule__Group__1__Impl : ( 'expression' ) ;
    public final void rule__ExpressionTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4407:1: ( ( 'expression' ) )
            // InternalInstanceLanguage.g:4408:1: ( 'expression' )
            {
            // InternalInstanceLanguage.g:4408:1: ( 'expression' )
            // InternalInstanceLanguage.g:4409:2: 'expression'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionTypeRuleAccess().getExpressionKeyword_1()); 
            }
            match(input,67,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpressionTypeRuleAccess().getExpressionKeyword_1()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:4419:1: rule__IntTypeRule__Group__0 : rule__IntTypeRule__Group__0__Impl rule__IntTypeRule__Group__1 ;
    public final void rule__IntTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4423:1: ( rule__IntTypeRule__Group__0__Impl rule__IntTypeRule__Group__1 )
            // InternalInstanceLanguage.g:4424:2: rule__IntTypeRule__Group__0__Impl rule__IntTypeRule__Group__1
            {
            pushFollow(FOLLOW_44);
            rule__IntTypeRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__IntTypeRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:4431:1: rule__IntTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__IntTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4435:1: ( ( () ) )
            // InternalInstanceLanguage.g:4436:1: ( () )
            {
            // InternalInstanceLanguage.g:4436:1: ( () )
            // InternalInstanceLanguage.g:4437:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntTypeRuleAccess().getIntTypeAction_0()); 
            }
            // InternalInstanceLanguage.g:4438:2: ()
            // InternalInstanceLanguage.g:4438:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getIntTypeRuleAccess().getIntTypeAction_0()); 
            }

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
    // InternalInstanceLanguage.g:4446:1: rule__IntTypeRule__Group__1 : rule__IntTypeRule__Group__1__Impl ;
    public final void rule__IntTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4450:1: ( rule__IntTypeRule__Group__1__Impl )
            // InternalInstanceLanguage.g:4451:2: rule__IntTypeRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__IntTypeRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:4457:1: rule__IntTypeRule__Group__1__Impl : ( 'int' ) ;
    public final void rule__IntTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4461:1: ( ( 'int' ) )
            // InternalInstanceLanguage.g:4462:1: ( 'int' )
            {
            // InternalInstanceLanguage.g:4462:1: ( 'int' )
            // InternalInstanceLanguage.g:4463:2: 'int'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntTypeRuleAccess().getIntKeyword_1()); 
            }
            match(input,68,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIntTypeRuleAccess().getIntKeyword_1()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__RealTypeRule__Group__0"
    // InternalInstanceLanguage.g:4473:1: rule__RealTypeRule__Group__0 : rule__RealTypeRule__Group__0__Impl rule__RealTypeRule__Group__1 ;
    public final void rule__RealTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4477:1: ( rule__RealTypeRule__Group__0__Impl rule__RealTypeRule__Group__1 )
            // InternalInstanceLanguage.g:4478:2: rule__RealTypeRule__Group__0__Impl rule__RealTypeRule__Group__1
            {
            pushFollow(FOLLOW_45);
            rule__RealTypeRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RealTypeRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RealTypeRule__Group__0"


    // $ANTLR start "rule__RealTypeRule__Group__0__Impl"
    // InternalInstanceLanguage.g:4485:1: rule__RealTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__RealTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4489:1: ( ( () ) )
            // InternalInstanceLanguage.g:4490:1: ( () )
            {
            // InternalInstanceLanguage.g:4490:1: ( () )
            // InternalInstanceLanguage.g:4491:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealTypeRuleAccess().getRealTypeAction_0()); 
            }
            // InternalInstanceLanguage.g:4492:2: ()
            // InternalInstanceLanguage.g:4492:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRealTypeRuleAccess().getRealTypeAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RealTypeRule__Group__0__Impl"


    // $ANTLR start "rule__RealTypeRule__Group__1"
    // InternalInstanceLanguage.g:4500:1: rule__RealTypeRule__Group__1 : rule__RealTypeRule__Group__1__Impl ;
    public final void rule__RealTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4504:1: ( rule__RealTypeRule__Group__1__Impl )
            // InternalInstanceLanguage.g:4505:2: rule__RealTypeRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RealTypeRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RealTypeRule__Group__1"


    // $ANTLR start "rule__RealTypeRule__Group__1__Impl"
    // InternalInstanceLanguage.g:4511:1: rule__RealTypeRule__Group__1__Impl : ( 'real' ) ;
    public final void rule__RealTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4515:1: ( ( 'real' ) )
            // InternalInstanceLanguage.g:4516:1: ( 'real' )
            {
            // InternalInstanceLanguage.g:4516:1: ( 'real' )
            // InternalInstanceLanguage.g:4517:2: 'real'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealTypeRuleAccess().getRealKeyword_1()); 
            }
            match(input,69,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRealTypeRuleAccess().getRealKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RealTypeRule__Group__1__Impl"


    // $ANTLR start "rule__BooleanTypeRule__Group__0"
    // InternalInstanceLanguage.g:4527:1: rule__BooleanTypeRule__Group__0 : rule__BooleanTypeRule__Group__0__Impl rule__BooleanTypeRule__Group__1 ;
    public final void rule__BooleanTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4531:1: ( rule__BooleanTypeRule__Group__0__Impl rule__BooleanTypeRule__Group__1 )
            // InternalInstanceLanguage.g:4532:2: rule__BooleanTypeRule__Group__0__Impl rule__BooleanTypeRule__Group__1
            {
            pushFollow(FOLLOW_46);
            rule__BooleanTypeRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__BooleanTypeRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:4539:1: rule__BooleanTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__BooleanTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4543:1: ( ( () ) )
            // InternalInstanceLanguage.g:4544:1: ( () )
            {
            // InternalInstanceLanguage.g:4544:1: ( () )
            // InternalInstanceLanguage.g:4545:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanTypeRuleAccess().getBooleanTypeAction_0()); 
            }
            // InternalInstanceLanguage.g:4546:2: ()
            // InternalInstanceLanguage.g:4546:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBooleanTypeRuleAccess().getBooleanTypeAction_0()); 
            }

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
    // InternalInstanceLanguage.g:4554:1: rule__BooleanTypeRule__Group__1 : rule__BooleanTypeRule__Group__1__Impl ;
    public final void rule__BooleanTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4558:1: ( rule__BooleanTypeRule__Group__1__Impl )
            // InternalInstanceLanguage.g:4559:2: rule__BooleanTypeRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__BooleanTypeRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:4565:1: rule__BooleanTypeRule__Group__1__Impl : ( 'boolean' ) ;
    public final void rule__BooleanTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4569:1: ( ( 'boolean' ) )
            // InternalInstanceLanguage.g:4570:1: ( 'boolean' )
            {
            // InternalInstanceLanguage.g:4570:1: ( 'boolean' )
            // InternalInstanceLanguage.g:4571:2: 'boolean'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanTypeRuleAccess().getBooleanKeyword_1()); 
            }
            match(input,70,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBooleanTypeRuleAccess().getBooleanKeyword_1()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:4581:1: rule__VoidTypeRule__Group__0 : rule__VoidTypeRule__Group__0__Impl rule__VoidTypeRule__Group__1 ;
    public final void rule__VoidTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4585:1: ( rule__VoidTypeRule__Group__0__Impl rule__VoidTypeRule__Group__1 )
            // InternalInstanceLanguage.g:4586:2: rule__VoidTypeRule__Group__0__Impl rule__VoidTypeRule__Group__1
            {
            pushFollow(FOLLOW_47);
            rule__VoidTypeRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__VoidTypeRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:4593:1: rule__VoidTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__VoidTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4597:1: ( ( () ) )
            // InternalInstanceLanguage.g:4598:1: ( () )
            {
            // InternalInstanceLanguage.g:4598:1: ( () )
            // InternalInstanceLanguage.g:4599:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVoidTypeRuleAccess().getVoidTypeAction_0()); 
            }
            // InternalInstanceLanguage.g:4600:2: ()
            // InternalInstanceLanguage.g:4600:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVoidTypeRuleAccess().getVoidTypeAction_0()); 
            }

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
    // InternalInstanceLanguage.g:4608:1: rule__VoidTypeRule__Group__1 : rule__VoidTypeRule__Group__1__Impl ;
    public final void rule__VoidTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4612:1: ( rule__VoidTypeRule__Group__1__Impl )
            // InternalInstanceLanguage.g:4613:2: rule__VoidTypeRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__VoidTypeRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:4619:1: rule__VoidTypeRule__Group__1__Impl : ( 'void' ) ;
    public final void rule__VoidTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4623:1: ( ( 'void' ) )
            // InternalInstanceLanguage.g:4624:1: ( 'void' )
            {
            // InternalInstanceLanguage.g:4624:1: ( 'void' )
            // InternalInstanceLanguage.g:4625:2: 'void'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVoidTypeRuleAccess().getVoidKeyword_1()); 
            }
            match(input,71,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVoidTypeRuleAccess().getVoidKeyword_1()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__ArrayTypeRule__Group__0"
    // InternalInstanceLanguage.g:4635:1: rule__ArrayTypeRule__Group__0 : rule__ArrayTypeRule__Group__0__Impl rule__ArrayTypeRule__Group__1 ;
    public final void rule__ArrayTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4639:1: ( rule__ArrayTypeRule__Group__0__Impl rule__ArrayTypeRule__Group__1 )
            // InternalInstanceLanguage.g:4640:2: rule__ArrayTypeRule__Group__0__Impl rule__ArrayTypeRule__Group__1
            {
            pushFollow(FOLLOW_39);
            rule__ArrayTypeRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ArrayTypeRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:4647:1: rule__ArrayTypeRule__Group__0__Impl : ( 'array' ) ;
    public final void rule__ArrayTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4651:1: ( ( 'array' ) )
            // InternalInstanceLanguage.g:4652:1: ( 'array' )
            {
            // InternalInstanceLanguage.g:4652:1: ( 'array' )
            // InternalInstanceLanguage.g:4653:2: 'array'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayTypeRuleAccess().getArrayKeyword_0()); 
            }
            match(input,72,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getArrayTypeRuleAccess().getArrayKeyword_0()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:4662:1: rule__ArrayTypeRule__Group__1 : rule__ArrayTypeRule__Group__1__Impl ;
    public final void rule__ArrayTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4666:1: ( rule__ArrayTypeRule__Group__1__Impl )
            // InternalInstanceLanguage.g:4667:2: rule__ArrayTypeRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ArrayTypeRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:4673:1: rule__ArrayTypeRule__Group__1__Impl : ( ( rule__ArrayTypeRule__ElementsAssignment_1 ) ) ;
    public final void rule__ArrayTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4677:1: ( ( ( rule__ArrayTypeRule__ElementsAssignment_1 ) ) )
            // InternalInstanceLanguage.g:4678:1: ( ( rule__ArrayTypeRule__ElementsAssignment_1 ) )
            {
            // InternalInstanceLanguage.g:4678:1: ( ( rule__ArrayTypeRule__ElementsAssignment_1 ) )
            // InternalInstanceLanguage.g:4679:2: ( rule__ArrayTypeRule__ElementsAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayTypeRuleAccess().getElementsAssignment_1()); 
            }
            // InternalInstanceLanguage.g:4680:2: ( rule__ArrayTypeRule__ElementsAssignment_1 )
            // InternalInstanceLanguage.g:4680:3: rule__ArrayTypeRule__ElementsAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__ArrayTypeRule__ElementsAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getArrayTypeRuleAccess().getElementsAssignment_1()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:4689:1: rule__ParameterRule__Group__0 : rule__ParameterRule__Group__0__Impl rule__ParameterRule__Group__1 ;
    public final void rule__ParameterRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4693:1: ( rule__ParameterRule__Group__0__Impl rule__ParameterRule__Group__1 )
            // InternalInstanceLanguage.g:4694:2: rule__ParameterRule__Group__0__Impl rule__ParameterRule__Group__1
            {
            pushFollow(FOLLOW_9);
            rule__ParameterRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ParameterRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:4701:1: rule__ParameterRule__Group__0__Impl : ( ( rule__ParameterRule__TypeAssignment_0 ) ) ;
    public final void rule__ParameterRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4705:1: ( ( ( rule__ParameterRule__TypeAssignment_0 ) ) )
            // InternalInstanceLanguage.g:4706:1: ( ( rule__ParameterRule__TypeAssignment_0 ) )
            {
            // InternalInstanceLanguage.g:4706:1: ( ( rule__ParameterRule__TypeAssignment_0 ) )
            // InternalInstanceLanguage.g:4707:2: ( rule__ParameterRule__TypeAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterRuleAccess().getTypeAssignment_0()); 
            }
            // InternalInstanceLanguage.g:4708:2: ( rule__ParameterRule__TypeAssignment_0 )
            // InternalInstanceLanguage.g:4708:3: rule__ParameterRule__TypeAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__ParameterRule__TypeAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getParameterRuleAccess().getTypeAssignment_0()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:4716:1: rule__ParameterRule__Group__1 : rule__ParameterRule__Group__1__Impl ;
    public final void rule__ParameterRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4720:1: ( rule__ParameterRule__Group__1__Impl )
            // InternalInstanceLanguage.g:4721:2: rule__ParameterRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ParameterRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:4727:1: rule__ParameterRule__Group__1__Impl : ( ( rule__ParameterRule__NameAssignment_1 ) ) ;
    public final void rule__ParameterRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4731:1: ( ( ( rule__ParameterRule__NameAssignment_1 ) ) )
            // InternalInstanceLanguage.g:4732:1: ( ( rule__ParameterRule__NameAssignment_1 ) )
            {
            // InternalInstanceLanguage.g:4732:1: ( ( rule__ParameterRule__NameAssignment_1 ) )
            // InternalInstanceLanguage.g:4733:2: ( rule__ParameterRule__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterRuleAccess().getNameAssignment_1()); 
            }
            // InternalInstanceLanguage.g:4734:2: ( rule__ParameterRule__NameAssignment_1 )
            // InternalInstanceLanguage.g:4734:3: rule__ParameterRule__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__ParameterRule__NameAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getParameterRuleAccess().getNameAssignment_1()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__ImportRule__Group__0"
    // InternalInstanceLanguage.g:4743:1: rule__ImportRule__Group__0 : rule__ImportRule__Group__0__Impl rule__ImportRule__Group__1 ;
    public final void rule__ImportRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4747:1: ( rule__ImportRule__Group__0__Impl rule__ImportRule__Group__1 )
            // InternalInstanceLanguage.g:4748:2: rule__ImportRule__Group__0__Impl rule__ImportRule__Group__1
            {
            pushFollow(FOLLOW_48);
            rule__ImportRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ImportRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:4755:1: rule__ImportRule__Group__0__Impl : ( 'import' ) ;
    public final void rule__ImportRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4759:1: ( ( 'import' ) )
            // InternalInstanceLanguage.g:4760:1: ( 'import' )
            {
            // InternalInstanceLanguage.g:4760:1: ( 'import' )
            // InternalInstanceLanguage.g:4761:2: 'import'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportRuleAccess().getImportKeyword_0()); 
            }
            match(input,73,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getImportRuleAccess().getImportKeyword_0()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:4770:1: rule__ImportRule__Group__1 : rule__ImportRule__Group__1__Impl rule__ImportRule__Group__2 ;
    public final void rule__ImportRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4774:1: ( rule__ImportRule__Group__1__Impl rule__ImportRule__Group__2 )
            // InternalInstanceLanguage.g:4775:2: rule__ImportRule__Group__1__Impl rule__ImportRule__Group__2
            {
            pushFollow(FOLLOW_49);
            rule__ImportRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ImportRule__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:4782:1: rule__ImportRule__Group__1__Impl : ( ( rule__ImportRule__LanguageAssignment_1 ) ) ;
    public final void rule__ImportRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4786:1: ( ( ( rule__ImportRule__LanguageAssignment_1 ) ) )
            // InternalInstanceLanguage.g:4787:1: ( ( rule__ImportRule__LanguageAssignment_1 ) )
            {
            // InternalInstanceLanguage.g:4787:1: ( ( rule__ImportRule__LanguageAssignment_1 ) )
            // InternalInstanceLanguage.g:4788:2: ( rule__ImportRule__LanguageAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportRuleAccess().getLanguageAssignment_1()); 
            }
            // InternalInstanceLanguage.g:4789:2: ( rule__ImportRule__LanguageAssignment_1 )
            // InternalInstanceLanguage.g:4789:3: rule__ImportRule__LanguageAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__ImportRule__LanguageAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getImportRuleAccess().getLanguageAssignment_1()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:4797:1: rule__ImportRule__Group__2 : rule__ImportRule__Group__2__Impl rule__ImportRule__Group__3 ;
    public final void rule__ImportRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4801:1: ( rule__ImportRule__Group__2__Impl rule__ImportRule__Group__3 )
            // InternalInstanceLanguage.g:4802:2: rule__ImportRule__Group__2__Impl rule__ImportRule__Group__3
            {
            pushFollow(FOLLOW_9);
            rule__ImportRule__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ImportRule__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:4809:1: rule__ImportRule__Group__2__Impl : ( 'from' ) ;
    public final void rule__ImportRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4813:1: ( ( 'from' ) )
            // InternalInstanceLanguage.g:4814:1: ( 'from' )
            {
            // InternalInstanceLanguage.g:4814:1: ( 'from' )
            // InternalInstanceLanguage.g:4815:2: 'from'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportRuleAccess().getFromKeyword_2()); 
            }
            match(input,74,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getImportRuleAccess().getFromKeyword_2()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__ImportRule__Group__3"
    // InternalInstanceLanguage.g:4824:1: rule__ImportRule__Group__3 : rule__ImportRule__Group__3__Impl rule__ImportRule__Group__4 ;
    public final void rule__ImportRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4828:1: ( rule__ImportRule__Group__3__Impl rule__ImportRule__Group__4 )
            // InternalInstanceLanguage.g:4829:2: rule__ImportRule__Group__3__Impl rule__ImportRule__Group__4
            {
            pushFollow(FOLLOW_8);
            rule__ImportRule__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ImportRule__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportRule__Group__3"


    // $ANTLR start "rule__ImportRule__Group__3__Impl"
    // InternalInstanceLanguage.g:4836:1: rule__ImportRule__Group__3__Impl : ( ( rule__ImportRule__ImportedNamespaceAssignment_3 ) ) ;
    public final void rule__ImportRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4840:1: ( ( ( rule__ImportRule__ImportedNamespaceAssignment_3 ) ) )
            // InternalInstanceLanguage.g:4841:1: ( ( rule__ImportRule__ImportedNamespaceAssignment_3 ) )
            {
            // InternalInstanceLanguage.g:4841:1: ( ( rule__ImportRule__ImportedNamespaceAssignment_3 ) )
            // InternalInstanceLanguage.g:4842:2: ( rule__ImportRule__ImportedNamespaceAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportRuleAccess().getImportedNamespaceAssignment_3()); 
            }
            // InternalInstanceLanguage.g:4843:2: ( rule__ImportRule__ImportedNamespaceAssignment_3 )
            // InternalInstanceLanguage.g:4843:3: rule__ImportRule__ImportedNamespaceAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__ImportRule__ImportedNamespaceAssignment_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getImportRuleAccess().getImportedNamespaceAssignment_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportRule__Group__3__Impl"


    // $ANTLR start "rule__ImportRule__Group__4"
    // InternalInstanceLanguage.g:4851:1: rule__ImportRule__Group__4 : rule__ImportRule__Group__4__Impl ;
    public final void rule__ImportRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4855:1: ( rule__ImportRule__Group__4__Impl )
            // InternalInstanceLanguage.g:4856:2: rule__ImportRule__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ImportRule__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportRule__Group__4"


    // $ANTLR start "rule__ImportRule__Group__4__Impl"
    // InternalInstanceLanguage.g:4862:1: rule__ImportRule__Group__4__Impl : ( ';' ) ;
    public final void rule__ImportRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4866:1: ( ( ';' ) )
            // InternalInstanceLanguage.g:4867:1: ( ';' )
            {
            // InternalInstanceLanguage.g:4867:1: ( ';' )
            // InternalInstanceLanguage.g:4868:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportRuleAccess().getSemicolonKeyword_4()); 
            }
            match(input,50,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getImportRuleAccess().getSemicolonKeyword_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportRule__Group__4__Impl"


    // $ANTLR start "rule__QualifiedName__Group__0"
    // InternalInstanceLanguage.g:4878:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4882:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // InternalInstanceLanguage.g:4883:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_50);
            rule__QualifiedName__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:4890:1: rule__QualifiedName__Group__0__Impl : ( ruleStringOrId ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4894:1: ( ( ruleStringOrId ) )
            // InternalInstanceLanguage.g:4895:1: ( ruleStringOrId )
            {
            // InternalInstanceLanguage.g:4895:1: ( ruleStringOrId )
            // InternalInstanceLanguage.g:4896:2: ruleStringOrId
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getStringOrIdParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleStringOrId();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameAccess().getStringOrIdParserRuleCall_0()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:4905:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4909:1: ( rule__QualifiedName__Group__1__Impl )
            // InternalInstanceLanguage.g:4910:2: rule__QualifiedName__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:4916:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4920:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // InternalInstanceLanguage.g:4921:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // InternalInstanceLanguage.g:4921:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // InternalInstanceLanguage.g:4922:2: ( rule__QualifiedName__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            }
            // InternalInstanceLanguage.g:4923:2: ( rule__QualifiedName__Group_1__0 )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==75) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalInstanceLanguage.g:4923:3: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_51);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:4932:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4936:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // InternalInstanceLanguage.g:4937:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
            {
            pushFollow(FOLLOW_9);
            rule__QualifiedName__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:4944:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4948:1: ( ( '.' ) )
            // InternalInstanceLanguage.g:4949:1: ( '.' )
            {
            // InternalInstanceLanguage.g:4949:1: ( '.' )
            // InternalInstanceLanguage.g:4950:2: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            }
            match(input,75,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:4959:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4963:1: ( rule__QualifiedName__Group_1__1__Impl )
            // InternalInstanceLanguage.g:4964:2: rule__QualifiedName__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalInstanceLanguage.g:4970:1: rule__QualifiedName__Group_1__1__Impl : ( ruleStringOrId ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4974:1: ( ( ruleStringOrId ) )
            // InternalInstanceLanguage.g:4975:1: ( ruleStringOrId )
            {
            // InternalInstanceLanguage.g:4975:1: ( ruleStringOrId )
            // InternalInstanceLanguage.g:4976:2: ruleStringOrId
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getStringOrIdParserRuleCall_1_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleStringOrId();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameAccess().getStringOrIdParserRuleCall_1_1()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__InstanceModuleRule__ImportsAssignment_1"
    // InternalInstanceLanguage.g:4986:1: rule__InstanceModuleRule__ImportsAssignment_1 : ( ruleImportRule ) ;
    public final void rule__InstanceModuleRule__ImportsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:4990:1: ( ( ruleImportRule ) )
            // InternalInstanceLanguage.g:4991:2: ( ruleImportRule )
            {
            // InternalInstanceLanguage.g:4991:2: ( ruleImportRule )
            // InternalInstanceLanguage.g:4992:3: ruleImportRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceModuleRuleAccess().getImportsImportRuleParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleImportRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getInstanceModuleRuleAccess().getImportsImportRuleParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceModuleRule__ImportsAssignment_1"


    // $ANTLR start "rule__InstanceModuleRule__InstancesAssignment_5_1"
    // InternalInstanceLanguage.g:5001:1: rule__InstanceModuleRule__InstancesAssignment_5_1 : ( ruleInstanceLiteralRule ) ;
    public final void rule__InstanceModuleRule__InstancesAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:5005:1: ( ( ruleInstanceLiteralRule ) )
            // InternalInstanceLanguage.g:5006:2: ( ruleInstanceLiteralRule )
            {
            // InternalInstanceLanguage.g:5006:2: ( ruleInstanceLiteralRule )
            // InternalInstanceLanguage.g:5007:3: ruleInstanceLiteralRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceModuleRuleAccess().getInstancesInstanceLiteralRuleParserRuleCall_5_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleInstanceLiteralRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getInstanceModuleRuleAccess().getInstancesInstanceLiteralRuleParserRuleCall_5_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceModuleRule__InstancesAssignment_5_1"


    // $ANTLR start "rule__InstanceModuleRule__InstancesAssignment_5_2_2"
    // InternalInstanceLanguage.g:5016:1: rule__InstanceModuleRule__InstancesAssignment_5_2_2 : ( ruleInstanceLiteralRule ) ;
    public final void rule__InstanceModuleRule__InstancesAssignment_5_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:5020:1: ( ( ruleInstanceLiteralRule ) )
            // InternalInstanceLanguage.g:5021:2: ( ruleInstanceLiteralRule )
            {
            // InternalInstanceLanguage.g:5021:2: ( ruleInstanceLiteralRule )
            // InternalInstanceLanguage.g:5022:3: ruleInstanceLiteralRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceModuleRuleAccess().getInstancesInstanceLiteralRuleParserRuleCall_5_2_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleInstanceLiteralRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getInstanceModuleRuleAccess().getInstancesInstanceLiteralRuleParserRuleCall_5_2_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceModuleRule__InstancesAssignment_5_2_2"


    // $ANTLR start "rule__OrExpressionRule__SubExpressionsAssignment_0"
    // InternalInstanceLanguage.g:5031:1: rule__OrExpressionRule__SubExpressionsAssignment_0 : ( ruleXorExpressionRule ) ;
    public final void rule__OrExpressionRule__SubExpressionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:5035:1: ( ( ruleXorExpressionRule ) )
            // InternalInstanceLanguage.g:5036:2: ( ruleXorExpressionRule )
            {
            // InternalInstanceLanguage.g:5036:2: ( ruleXorExpressionRule )
            // InternalInstanceLanguage.g:5037:3: ruleXorExpressionRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsXorExpressionRuleParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleXorExpressionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsXorExpressionRuleParserRuleCall_0_0()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:5046:1: rule__OrExpressionRule__SubExpressionsAssignment_1_1 : ( ruleXorExpressionRule ) ;
    public final void rule__OrExpressionRule__SubExpressionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:5050:1: ( ( ruleXorExpressionRule ) )
            // InternalInstanceLanguage.g:5051:2: ( ruleXorExpressionRule )
            {
            // InternalInstanceLanguage.g:5051:2: ( ruleXorExpressionRule )
            // InternalInstanceLanguage.g:5052:3: ruleXorExpressionRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsXorExpressionRuleParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleXorExpressionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsXorExpressionRuleParserRuleCall_1_1_0()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:5061:1: rule__XorExpressionRule__SubExpressionsAssignment_0 : ( ruleAndExpressionRule ) ;
    public final void rule__XorExpressionRule__SubExpressionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:5065:1: ( ( ruleAndExpressionRule ) )
            // InternalInstanceLanguage.g:5066:2: ( ruleAndExpressionRule )
            {
            // InternalInstanceLanguage.g:5066:2: ( ruleAndExpressionRule )
            // InternalInstanceLanguage.g:5067:3: ruleAndExpressionRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAndExpressionRuleParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleAndExpressionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAndExpressionRuleParserRuleCall_0_0()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:5076:1: rule__XorExpressionRule__SubExpressionsAssignment_1_1 : ( ruleAndExpressionRule ) ;
    public final void rule__XorExpressionRule__SubExpressionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:5080:1: ( ( ruleAndExpressionRule ) )
            // InternalInstanceLanguage.g:5081:2: ( ruleAndExpressionRule )
            {
            // InternalInstanceLanguage.g:5081:2: ( ruleAndExpressionRule )
            // InternalInstanceLanguage.g:5082:3: ruleAndExpressionRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAndExpressionRuleParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleAndExpressionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAndExpressionRuleParserRuleCall_1_1_0()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:5091:1: rule__AndExpressionRule__SubExpressionsAssignment_0 : ( ruleNotExpressionRule ) ;
    public final void rule__AndExpressionRule__SubExpressionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:5095:1: ( ( ruleNotExpressionRule ) )
            // InternalInstanceLanguage.g:5096:2: ( ruleNotExpressionRule )
            {
            // InternalInstanceLanguage.g:5096:2: ( ruleNotExpressionRule )
            // InternalInstanceLanguage.g:5097:3: ruleNotExpressionRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsNotExpressionRuleParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleNotExpressionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsNotExpressionRuleParserRuleCall_0_0()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:5106:1: rule__AndExpressionRule__SubExpressionsAssignment_1_1 : ( ruleNotExpressionRule ) ;
    public final void rule__AndExpressionRule__SubExpressionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:5110:1: ( ( ruleNotExpressionRule ) )
            // InternalInstanceLanguage.g:5111:2: ( ruleNotExpressionRule )
            {
            // InternalInstanceLanguage.g:5111:2: ( ruleNotExpressionRule )
            // InternalInstanceLanguage.g:5112:3: ruleNotExpressionRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsNotExpressionRuleParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleNotExpressionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsNotExpressionRuleParserRuleCall_1_1_0()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:5121:1: rule__NotExpressionRule__NegatedAssignment_0 : ( ( '!' ) ) ;
    public final void rule__NotExpressionRule__NegatedAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:5125:1: ( ( ( '!' ) ) )
            // InternalInstanceLanguage.g:5126:2: ( ( '!' ) )
            {
            // InternalInstanceLanguage.g:5126:2: ( ( '!' ) )
            // InternalInstanceLanguage.g:5127:3: ( '!' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNotExpressionRuleAccess().getNegatedExclamationMarkKeyword_0_0()); 
            }
            // InternalInstanceLanguage.g:5128:3: ( '!' )
            // InternalInstanceLanguage.g:5129:4: '!'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNotExpressionRuleAccess().getNegatedExclamationMarkKeyword_0_0()); 
            }
            match(input,76,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNotExpressionRuleAccess().getNegatedExclamationMarkKeyword_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNotExpressionRuleAccess().getNegatedExclamationMarkKeyword_0_0()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:5140:1: rule__NotExpressionRule__OperandAssignment_1 : ( ruleComparisonExpressionRule ) ;
    public final void rule__NotExpressionRule__OperandAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:5144:1: ( ( ruleComparisonExpressionRule ) )
            // InternalInstanceLanguage.g:5145:2: ( ruleComparisonExpressionRule )
            {
            // InternalInstanceLanguage.g:5145:2: ( ruleComparisonExpressionRule )
            // InternalInstanceLanguage.g:5146:3: ruleComparisonExpressionRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNotExpressionRuleAccess().getOperandComparisonExpressionRuleParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleComparisonExpressionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNotExpressionRuleAccess().getOperandComparisonExpressionRuleParserRuleCall_1_0()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:5155:1: rule__ComparisonExpressionRule__LeftOperandAssignment_0 : ( ruleAddOrSubtractExpressionRule ) ;
    public final void rule__ComparisonExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:5159:1: ( ( ruleAddOrSubtractExpressionRule ) )
            // InternalInstanceLanguage.g:5160:2: ( ruleAddOrSubtractExpressionRule )
            {
            // InternalInstanceLanguage.g:5160:2: ( ruleAddOrSubtractExpressionRule )
            // InternalInstanceLanguage.g:5161:3: ruleAddOrSubtractExpressionRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonExpressionRuleAccess().getLeftOperandAddOrSubtractExpressionRuleParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleAddOrSubtractExpressionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getComparisonExpressionRuleAccess().getLeftOperandAddOrSubtractExpressionRuleParserRuleCall_0_0()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:5170:1: rule__ComparisonExpressionRule__ComparisonAssignment_1 : ( rulePartialComparisonExpressionRule ) ;
    public final void rule__ComparisonExpressionRule__ComparisonAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:5174:1: ( ( rulePartialComparisonExpressionRule ) )
            // InternalInstanceLanguage.g:5175:2: ( rulePartialComparisonExpressionRule )
            {
            // InternalInstanceLanguage.g:5175:2: ( rulePartialComparisonExpressionRule )
            // InternalInstanceLanguage.g:5176:3: rulePartialComparisonExpressionRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonExpressionRuleAccess().getComparisonPartialComparisonExpressionRuleParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePartialComparisonExpressionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getComparisonExpressionRuleAccess().getComparisonPartialComparisonExpressionRuleParserRuleCall_1_0()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:5185:1: rule__PartialComparisonExpressionRule__OperatorAssignment_0 : ( ruleComparisonOperatorRule ) ;
    public final void rule__PartialComparisonExpressionRule__OperatorAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:5189:1: ( ( ruleComparisonOperatorRule ) )
            // InternalInstanceLanguage.g:5190:2: ( ruleComparisonOperatorRule )
            {
            // InternalInstanceLanguage.g:5190:2: ( ruleComparisonOperatorRule )
            // InternalInstanceLanguage.g:5191:3: ruleComparisonOperatorRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartialComparisonExpressionRuleAccess().getOperatorComparisonOperatorRuleEnumRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleComparisonOperatorRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartialComparisonExpressionRuleAccess().getOperatorComparisonOperatorRuleEnumRuleCall_0_0()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:5200:1: rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 : ( ruleAddOrSubtractExpressionRule ) ;
    public final void rule__PartialComparisonExpressionRule__SubExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:5204:1: ( ( ruleAddOrSubtractExpressionRule ) )
            // InternalInstanceLanguage.g:5205:2: ( ruleAddOrSubtractExpressionRule )
            {
            // InternalInstanceLanguage.g:5205:2: ( ruleAddOrSubtractExpressionRule )
            // InternalInstanceLanguage.g:5206:3: ruleAddOrSubtractExpressionRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartialComparisonExpressionRuleAccess().getSubExpressionAddOrSubtractExpressionRuleParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleAddOrSubtractExpressionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPartialComparisonExpressionRuleAccess().getSubExpressionAddOrSubtractExpressionRuleParserRuleCall_1_0()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:5215:1: rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 : ( ruleMultiplyDivideModuloExpressionRule ) ;
    public final void rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:5219:1: ( ( ruleMultiplyDivideModuloExpressionRule ) )
            // InternalInstanceLanguage.g:5220:2: ( ruleMultiplyDivideModuloExpressionRule )
            {
            // InternalInstanceLanguage.g:5220:2: ( ruleMultiplyDivideModuloExpressionRule )
            // InternalInstanceLanguage.g:5221:3: ruleMultiplyDivideModuloExpressionRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getLeftOperandMultiplyDivideModuloExpressionRuleParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleMultiplyDivideModuloExpressionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAddOrSubtractExpressionRuleAccess().getLeftOperandMultiplyDivideModuloExpressionRuleParserRuleCall_0_0()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:5230:1: rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 : ( ruleAddOrSubtractOperatorRule ) ;
    public final void rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:5234:1: ( ( ruleAddOrSubtractOperatorRule ) )
            // InternalInstanceLanguage.g:5235:2: ( ruleAddOrSubtractOperatorRule )
            {
            // InternalInstanceLanguage.g:5235:2: ( ruleAddOrSubtractOperatorRule )
            // InternalInstanceLanguage.g:5236:3: ruleAddOrSubtractOperatorRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperatorsAddOrSubtractOperatorRuleEnumRuleCall_1_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleAddOrSubtractOperatorRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperatorsAddOrSubtractOperatorRuleEnumRuleCall_1_0_0()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:5245:1: rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 : ( ruleMultiplyDivideModuloExpressionRule ) ;
    public final void rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:5249:1: ( ( ruleMultiplyDivideModuloExpressionRule ) )
            // InternalInstanceLanguage.g:5250:2: ( ruleMultiplyDivideModuloExpressionRule )
            {
            // InternalInstanceLanguage.g:5250:2: ( ruleMultiplyDivideModuloExpressionRule )
            // InternalInstanceLanguage.g:5251:3: ruleMultiplyDivideModuloExpressionRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperandsMultiplyDivideModuloExpressionRuleParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleMultiplyDivideModuloExpressionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperandsMultiplyDivideModuloExpressionRuleParserRuleCall_1_1_0()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:5260:1: rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 : ( rulePowerOfExpressionRule ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:5264:1: ( ( rulePowerOfExpressionRule ) )
            // InternalInstanceLanguage.g:5265:2: ( rulePowerOfExpressionRule )
            {
            // InternalInstanceLanguage.g:5265:2: ( rulePowerOfExpressionRule )
            // InternalInstanceLanguage.g:5266:3: rulePowerOfExpressionRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getLeftOperandPowerOfExpressionRuleParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePowerOfExpressionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getLeftOperandPowerOfExpressionRuleParserRuleCall_0_0()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:5275:1: rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 : ( ruleMultiplyDivideModuloOperatorRule ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:5279:1: ( ( ruleMultiplyDivideModuloOperatorRule ) )
            // InternalInstanceLanguage.g:5280:2: ( ruleMultiplyDivideModuloOperatorRule )
            {
            // InternalInstanceLanguage.g:5280:2: ( ruleMultiplyDivideModuloOperatorRule )
            // InternalInstanceLanguage.g:5281:3: ruleMultiplyDivideModuloOperatorRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperatorsMultiplyDivideModuloOperatorRuleEnumRuleCall_1_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleMultiplyDivideModuloOperatorRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperatorsMultiplyDivideModuloOperatorRuleEnumRuleCall_1_0_0()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:5290:1: rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 : ( rulePowerOfExpressionRule ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:5294:1: ( ( rulePowerOfExpressionRule ) )
            // InternalInstanceLanguage.g:5295:2: ( rulePowerOfExpressionRule )
            {
            // InternalInstanceLanguage.g:5295:2: ( rulePowerOfExpressionRule )
            // InternalInstanceLanguage.g:5296:3: rulePowerOfExpressionRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperandsPowerOfExpressionRuleParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePowerOfExpressionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperandsPowerOfExpressionRuleParserRuleCall_1_1_0()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:5305:1: rule__PowerOfExpressionRule__LeftOperandAssignment_0 : ( ruleUnaryAddOrSubtractExpressionRule ) ;
    public final void rule__PowerOfExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:5309:1: ( ( ruleUnaryAddOrSubtractExpressionRule ) )
            // InternalInstanceLanguage.g:5310:2: ( ruleUnaryAddOrSubtractExpressionRule )
            {
            // InternalInstanceLanguage.g:5310:2: ( ruleUnaryAddOrSubtractExpressionRule )
            // InternalInstanceLanguage.g:5311:3: ruleUnaryAddOrSubtractExpressionRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPowerOfExpressionRuleAccess().getLeftOperandUnaryAddOrSubtractExpressionRuleParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleUnaryAddOrSubtractExpressionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPowerOfExpressionRuleAccess().getLeftOperandUnaryAddOrSubtractExpressionRuleParserRuleCall_0_0()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:5320:1: rule__PowerOfExpressionRule__RightOperandAssignment_1_1 : ( rulePowerOfExpressionRule ) ;
    public final void rule__PowerOfExpressionRule__RightOperandAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:5324:1: ( ( rulePowerOfExpressionRule ) )
            // InternalInstanceLanguage.g:5325:2: ( rulePowerOfExpressionRule )
            {
            // InternalInstanceLanguage.g:5325:2: ( rulePowerOfExpressionRule )
            // InternalInstanceLanguage.g:5326:3: rulePowerOfExpressionRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPowerOfExpressionRuleAccess().getRightOperandPowerOfExpressionRuleParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePowerOfExpressionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPowerOfExpressionRuleAccess().getRightOperandPowerOfExpressionRuleParserRuleCall_1_1_0()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:5335:1: rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 : ( ruleAddOrSubtractOperatorRule ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:5339:1: ( ( ruleAddOrSubtractOperatorRule ) )
            // InternalInstanceLanguage.g:5340:2: ( ruleAddOrSubtractOperatorRule )
            {
            // InternalInstanceLanguage.g:5340:2: ( ruleAddOrSubtractOperatorRule )
            // InternalInstanceLanguage.g:5341:3: ruleAddOrSubtractOperatorRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getOperatorsAddOrSubtractOperatorRuleEnumRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleAddOrSubtractOperatorRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getOperatorsAddOrSubtractOperatorRuleEnumRuleCall_0_0()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:5350:1: rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 : ( ruleValueRule ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:5354:1: ( ( ruleValueRule ) )
            // InternalInstanceLanguage.g:5355:2: ( ruleValueRule )
            {
            // InternalInstanceLanguage.g:5355:2: ( ruleValueRule )
            // InternalInstanceLanguage.g:5356:3: ruleValueRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getSubExpressionValueRuleParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleValueRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getSubExpressionValueRuleParserRuleCall_1_0()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__ArrayRule__ValuesAssignment_2_0"
    // InternalInstanceLanguage.g:5365:1: rule__ArrayRule__ValuesAssignment_2_0 : ( ruleValueRule ) ;
    public final void rule__ArrayRule__ValuesAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:5369:1: ( ( ruleValueRule ) )
            // InternalInstanceLanguage.g:5370:2: ( ruleValueRule )
            {
            // InternalInstanceLanguage.g:5370:2: ( ruleValueRule )
            // InternalInstanceLanguage.g:5371:3: ruleValueRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayRuleAccess().getValuesValueRuleParserRuleCall_2_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleValueRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getArrayRuleAccess().getValuesValueRuleParserRuleCall_2_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrayRule__ValuesAssignment_2_0"


    // $ANTLR start "rule__ArrayRule__ValuesAssignment_2_1_1"
    // InternalInstanceLanguage.g:5380:1: rule__ArrayRule__ValuesAssignment_2_1_1 : ( ruleValueRule ) ;
    public final void rule__ArrayRule__ValuesAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:5384:1: ( ( ruleValueRule ) )
            // InternalInstanceLanguage.g:5385:2: ( ruleValueRule )
            {
            // InternalInstanceLanguage.g:5385:2: ( ruleValueRule )
            // InternalInstanceLanguage.g:5386:3: ruleValueRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayRuleAccess().getValuesValueRuleParserRuleCall_2_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleValueRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getArrayRuleAccess().getValuesValueRuleParserRuleCall_2_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrayRule__ValuesAssignment_2_1_1"


    // $ANTLR start "rule__ParanthesesRule__SubExpressionAssignment_1"
    // InternalInstanceLanguage.g:5395:1: rule__ParanthesesRule__SubExpressionAssignment_1 : ( ruleExpressionRule ) ;
    public final void rule__ParanthesesRule__SubExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:5399:1: ( ( ruleExpressionRule ) )
            // InternalInstanceLanguage.g:5400:2: ( ruleExpressionRule )
            {
            // InternalInstanceLanguage.g:5400:2: ( ruleExpressionRule )
            // InternalInstanceLanguage.g:5401:3: ruleExpressionRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParanthesesRuleAccess().getSubExpressionExpressionRuleParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleExpressionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParanthesesRuleAccess().getSubExpressionExpressionRuleParserRuleCall_1_0()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:5410:1: rule__CallRule__FunctionAssignment_0 : ( ( ruleQualifiedName ) ) ;
    public final void rule__CallRule__FunctionAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:5414:1: ( ( ( ruleQualifiedName ) ) )
            // InternalInstanceLanguage.g:5415:2: ( ( ruleQualifiedName ) )
            {
            // InternalInstanceLanguage.g:5415:2: ( ( ruleQualifiedName ) )
            // InternalInstanceLanguage.g:5416:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getFunctionFunctionDefinitionCrossReference_0_0()); 
            }
            // InternalInstanceLanguage.g:5417:3: ( ruleQualifiedName )
            // InternalInstanceLanguage.g:5418:4: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getFunctionFunctionDefinitionQualifiedNameParserRuleCall_0_0_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCallRuleAccess().getFunctionFunctionDefinitionQualifiedNameParserRuleCall_0_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCallRuleAccess().getFunctionFunctionDefinitionCrossReference_0_0()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:5429:1: rule__CallRule__ParametersAssignment_2_0 : ( ruleExpressionRule ) ;
    public final void rule__CallRule__ParametersAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:5433:1: ( ( ruleExpressionRule ) )
            // InternalInstanceLanguage.g:5434:2: ( ruleExpressionRule )
            {
            // InternalInstanceLanguage.g:5434:2: ( ruleExpressionRule )
            // InternalInstanceLanguage.g:5435:3: ruleExpressionRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getParametersExpressionRuleParserRuleCall_2_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleExpressionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCallRuleAccess().getParametersExpressionRuleParserRuleCall_2_0_0()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:5444:1: rule__CallRule__ParametersAssignment_2_1_1 : ( ruleExpressionRule ) ;
    public final void rule__CallRule__ParametersAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:5448:1: ( ( ruleExpressionRule ) )
            // InternalInstanceLanguage.g:5449:2: ( ruleExpressionRule )
            {
            // InternalInstanceLanguage.g:5449:2: ( ruleExpressionRule )
            // InternalInstanceLanguage.g:5450:3: ruleExpressionRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getParametersExpressionRuleParserRuleCall_2_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleExpressionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCallRuleAccess().getParametersExpressionRuleParserRuleCall_2_1_1_0()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__DataReferenceRule__DefinitionAssignment_1"
    // InternalInstanceLanguage.g:5459:1: rule__DataReferenceRule__DefinitionAssignment_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__DataReferenceRule__DefinitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:5463:1: ( ( ( ruleQualifiedName ) ) )
            // InternalInstanceLanguage.g:5464:2: ( ( ruleQualifiedName ) )
            {
            // InternalInstanceLanguage.g:5464:2: ( ( ruleQualifiedName ) )
            // InternalInstanceLanguage.g:5465:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataReferenceRuleAccess().getDefinitionDataDescriptionCrossReference_1_0()); 
            }
            // InternalInstanceLanguage.g:5466:3: ( ruleQualifiedName )
            // InternalInstanceLanguage.g:5467:4: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataReferenceRuleAccess().getDefinitionDataDescriptionQualifiedNameParserRuleCall_1_0_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataReferenceRuleAccess().getDefinitionDataDescriptionQualifiedNameParserRuleCall_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataReferenceRuleAccess().getDefinitionDataDescriptionCrossReference_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataReferenceRule__DefinitionAssignment_1"


    // $ANTLR start "rule__ConstantReferenceRule__DefinitionAssignment"
    // InternalInstanceLanguage.g:5478:1: rule__ConstantReferenceRule__DefinitionAssignment : ( ( ruleQualifiedName ) ) ;
    public final void rule__ConstantReferenceRule__DefinitionAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:5482:1: ( ( ( ruleQualifiedName ) ) )
            // InternalInstanceLanguage.g:5483:2: ( ( ruleQualifiedName ) )
            {
            // InternalInstanceLanguage.g:5483:2: ( ( ruleQualifiedName ) )
            // InternalInstanceLanguage.g:5484:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstantReferenceRuleAccess().getDefinitionConstantDefinitionCrossReference_0()); 
            }
            // InternalInstanceLanguage.g:5485:3: ( ruleQualifiedName )
            // InternalInstanceLanguage.g:5486:4: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstantReferenceRuleAccess().getDefinitionConstantDefinitionQualifiedNameParserRuleCall_0_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstantReferenceRuleAccess().getDefinitionConstantDefinitionQualifiedNameParserRuleCall_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstantReferenceRuleAccess().getDefinitionConstantDefinitionCrossReference_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstantReferenceRule__DefinitionAssignment"


    // $ANTLR start "rule__InstanceLiteralRule__DefinitionAssignment_0"
    // InternalInstanceLanguage.g:5497:1: rule__InstanceLiteralRule__DefinitionAssignment_0 : ( ( ruleQualifiedName ) ) ;
    public final void rule__InstanceLiteralRule__DefinitionAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:5501:1: ( ( ( ruleQualifiedName ) ) )
            // InternalInstanceLanguage.g:5502:2: ( ( ruleQualifiedName ) )
            {
            // InternalInstanceLanguage.g:5502:2: ( ( ruleQualifiedName ) )
            // InternalInstanceLanguage.g:5503:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceLiteralRuleAccess().getDefinitionTypeDefinitionCrossReference_0_0()); 
            }
            // InternalInstanceLanguage.g:5504:3: ( ruleQualifiedName )
            // InternalInstanceLanguage.g:5505:4: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceLiteralRuleAccess().getDefinitionTypeDefinitionQualifiedNameParserRuleCall_0_0_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getInstanceLiteralRuleAccess().getDefinitionTypeDefinitionQualifiedNameParserRuleCall_0_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getInstanceLiteralRuleAccess().getDefinitionTypeDefinitionCrossReference_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceLiteralRule__DefinitionAssignment_0"


    // $ANTLR start "rule__InstanceLiteralRule__AttributesAssignment_2"
    // InternalInstanceLanguage.g:5516:1: rule__InstanceLiteralRule__AttributesAssignment_2 : ( ruleAttributeRule ) ;
    public final void rule__InstanceLiteralRule__AttributesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:5520:1: ( ( ruleAttributeRule ) )
            // InternalInstanceLanguage.g:5521:2: ( ruleAttributeRule )
            {
            // InternalInstanceLanguage.g:5521:2: ( ruleAttributeRule )
            // InternalInstanceLanguage.g:5522:3: ruleAttributeRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceLiteralRuleAccess().getAttributesAttributeRuleParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleAttributeRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getInstanceLiteralRuleAccess().getAttributesAttributeRuleParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceLiteralRule__AttributesAssignment_2"


    // $ANTLR start "rule__AttributeRule__DefinitionAssignment_0"
    // InternalInstanceLanguage.g:5531:1: rule__AttributeRule__DefinitionAssignment_0 : ( ( ruleStringOrId ) ) ;
    public final void rule__AttributeRule__DefinitionAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:5535:1: ( ( ( ruleStringOrId ) ) )
            // InternalInstanceLanguage.g:5536:2: ( ( ruleStringOrId ) )
            {
            // InternalInstanceLanguage.g:5536:2: ( ( ruleStringOrId ) )
            // InternalInstanceLanguage.g:5537:3: ( ruleStringOrId )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeRuleAccess().getDefinitionAttributeDefinitionCrossReference_0_0()); 
            }
            // InternalInstanceLanguage.g:5538:3: ( ruleStringOrId )
            // InternalInstanceLanguage.g:5539:4: ruleStringOrId
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeRuleAccess().getDefinitionAttributeDefinitionStringOrIdParserRuleCall_0_0_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleStringOrId();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeRuleAccess().getDefinitionAttributeDefinitionStringOrIdParserRuleCall_0_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeRuleAccess().getDefinitionAttributeDefinitionCrossReference_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeRule__DefinitionAssignment_0"


    // $ANTLR start "rule__AttributeRule__ValueAssignment_2"
    // InternalInstanceLanguage.g:5550:1: rule__AttributeRule__ValueAssignment_2 : ( ruleExpressionRule ) ;
    public final void rule__AttributeRule__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:5554:1: ( ( ruleExpressionRule ) )
            // InternalInstanceLanguage.g:5555:2: ( ruleExpressionRule )
            {
            // InternalInstanceLanguage.g:5555:2: ( ruleExpressionRule )
            // InternalInstanceLanguage.g:5556:3: ruleExpressionRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeRuleAccess().getValueExpressionRuleParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleExpressionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeRuleAccess().getValueExpressionRuleParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeRule__ValueAssignment_2"


    // $ANTLR start "rule__RealLiteralRule__LiteralAssignment_0"
    // InternalInstanceLanguage.g:5565:1: rule__RealLiteralRule__LiteralAssignment_0 : ( RULE_DOUBLE ) ;
    public final void rule__RealLiteralRule__LiteralAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:5569:1: ( ( RULE_DOUBLE ) )
            // InternalInstanceLanguage.g:5570:2: ( RULE_DOUBLE )
            {
            // InternalInstanceLanguage.g:5570:2: ( RULE_DOUBLE )
            // InternalInstanceLanguage.g:5571:3: RULE_DOUBLE
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealLiteralRuleAccess().getLiteralDOUBLETerminalRuleCall_0_0()); 
            }
            match(input,RULE_DOUBLE,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRealLiteralRuleAccess().getLiteralDOUBLETerminalRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RealLiteralRule__LiteralAssignment_0"


    // $ANTLR start "rule__RealLiteralRule__FactorAssignment_1"
    // InternalInstanceLanguage.g:5580:1: rule__RealLiteralRule__FactorAssignment_1 : ( ruleFactorRule ) ;
    public final void rule__RealLiteralRule__FactorAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:5584:1: ( ( ruleFactorRule ) )
            // InternalInstanceLanguage.g:5585:2: ( ruleFactorRule )
            {
            // InternalInstanceLanguage.g:5585:2: ( ruleFactorRule )
            // InternalInstanceLanguage.g:5586:3: ruleFactorRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealLiteralRuleAccess().getFactorFactorRuleEnumRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleFactorRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRealLiteralRuleAccess().getFactorFactorRuleEnumRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RealLiteralRule__FactorAssignment_1"


    // $ANTLR start "rule__IntegerLiteralRule__LiteralAssignment_0"
    // InternalInstanceLanguage.g:5595:1: rule__IntegerLiteralRule__LiteralAssignment_0 : ( RULE_INT ) ;
    public final void rule__IntegerLiteralRule__LiteralAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:5599:1: ( ( RULE_INT ) )
            // InternalInstanceLanguage.g:5600:2: ( RULE_INT )
            {
            // InternalInstanceLanguage.g:5600:2: ( RULE_INT )
            // InternalInstanceLanguage.g:5601:3: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegerLiteralRuleAccess().getLiteralINTTerminalRuleCall_0_0()); 
            }
            match(input,RULE_INT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIntegerLiteralRuleAccess().getLiteralINTTerminalRuleCall_0_0()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:5610:1: rule__IntegerLiteralRule__FactorAssignment_1 : ( ruleFactorRule ) ;
    public final void rule__IntegerLiteralRule__FactorAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:5614:1: ( ( ruleFactorRule ) )
            // InternalInstanceLanguage.g:5615:2: ( ruleFactorRule )
            {
            // InternalInstanceLanguage.g:5615:2: ( ruleFactorRule )
            // InternalInstanceLanguage.g:5616:3: ruleFactorRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegerLiteralRuleAccess().getFactorFactorRuleEnumRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleFactorRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIntegerLiteralRuleAccess().getFactorFactorRuleEnumRuleCall_1_0()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:5625:1: rule__StringLiteralRule__ValueAssignment : ( RULE_STRING ) ;
    public final void rule__StringLiteralRule__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:5629:1: ( ( RULE_STRING ) )
            // InternalInstanceLanguage.g:5630:2: ( RULE_STRING )
            {
            // InternalInstanceLanguage.g:5630:2: ( RULE_STRING )
            // InternalInstanceLanguage.g:5631:3: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringLiteralRuleAccess().getValueSTRINGTerminalRuleCall_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getStringLiteralRuleAccess().getValueSTRINGTerminalRuleCall_0()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:5640:1: rule__BooleanLiteralRule__ValueAssignment_1_0 : ( ( 'true' ) ) ;
    public final void rule__BooleanLiteralRule__ValueAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:5644:1: ( ( ( 'true' ) ) )
            // InternalInstanceLanguage.g:5645:2: ( ( 'true' ) )
            {
            // InternalInstanceLanguage.g:5645:2: ( ( 'true' ) )
            // InternalInstanceLanguage.g:5646:3: ( 'true' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralRuleAccess().getValueTrueKeyword_1_0_0()); 
            }
            // InternalInstanceLanguage.g:5647:3: ( 'true' )
            // InternalInstanceLanguage.g:5648:4: 'true'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralRuleAccess().getValueTrueKeyword_1_0_0()); 
            }
            match(input,77,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBooleanLiteralRuleAccess().getValueTrueKeyword_1_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBooleanLiteralRuleAccess().getValueTrueKeyword_1_0_0()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__AttributeDefinitionRule__ConstraintsAssignment_0"
    // InternalInstanceLanguage.g:5659:1: rule__AttributeDefinitionRule__ConstraintsAssignment_0 : ( ruleConstraintRule ) ;
    public final void rule__AttributeDefinitionRule__ConstraintsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:5663:1: ( ( ruleConstraintRule ) )
            // InternalInstanceLanguage.g:5664:2: ( ruleConstraintRule )
            {
            // InternalInstanceLanguage.g:5664:2: ( ruleConstraintRule )
            // InternalInstanceLanguage.g:5665:3: ruleConstraintRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getConstraintsConstraintRuleParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleConstraintRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeDefinitionRuleAccess().getConstraintsConstraintRuleParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeDefinitionRule__ConstraintsAssignment_0"


    // $ANTLR start "rule__AttributeDefinitionRule__NameAssignment_1"
    // InternalInstanceLanguage.g:5674:1: rule__AttributeDefinitionRule__NameAssignment_1 : ( ruleStringOrId ) ;
    public final void rule__AttributeDefinitionRule__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:5678:1: ( ( ruleStringOrId ) )
            // InternalInstanceLanguage.g:5679:2: ( ruleStringOrId )
            {
            // InternalInstanceLanguage.g:5679:2: ( ruleStringOrId )
            // InternalInstanceLanguage.g:5680:3: ruleStringOrId
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getNameStringOrIdParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleStringOrId();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeDefinitionRuleAccess().getNameStringOrIdParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeDefinitionRule__NameAssignment_1"


    // $ANTLR start "rule__AttributeDefinitionRule__TypeAssignment_3"
    // InternalInstanceLanguage.g:5689:1: rule__AttributeDefinitionRule__TypeAssignment_3 : ( ruleTypeRule ) ;
    public final void rule__AttributeDefinitionRule__TypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:5693:1: ( ( ruleTypeRule ) )
            // InternalInstanceLanguage.g:5694:2: ( ruleTypeRule )
            {
            // InternalInstanceLanguage.g:5694:2: ( ruleTypeRule )
            // InternalInstanceLanguage.g:5695:3: ruleTypeRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getTypeTypeRuleParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleTypeRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeDefinitionRuleAccess().getTypeTypeRuleParserRuleCall_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeDefinitionRule__TypeAssignment_3"


    // $ANTLR start "rule__AttributeDefinitionRule__InitialisationAssignment_4_1"
    // InternalInstanceLanguage.g:5704:1: rule__AttributeDefinitionRule__InitialisationAssignment_4_1 : ( ruleExpressionRule ) ;
    public final void rule__AttributeDefinitionRule__InitialisationAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:5708:1: ( ( ruleExpressionRule ) )
            // InternalInstanceLanguage.g:5709:2: ( ruleExpressionRule )
            {
            // InternalInstanceLanguage.g:5709:2: ( ruleExpressionRule )
            // InternalInstanceLanguage.g:5710:3: ruleExpressionRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getInitialisationExpressionRuleParserRuleCall_4_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleExpressionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeDefinitionRuleAccess().getInitialisationExpressionRuleParserRuleCall_4_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeDefinitionRule__InitialisationAssignment_4_1"


    // $ANTLR start "rule__InstanceTypeRule__DefinitionAssignment_2"
    // InternalInstanceLanguage.g:5719:1: rule__InstanceTypeRule__DefinitionAssignment_2 : ( ( ruleQualifiedName ) ) ;
    public final void rule__InstanceTypeRule__DefinitionAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:5723:1: ( ( ( ruleQualifiedName ) ) )
            // InternalInstanceLanguage.g:5724:2: ( ( ruleQualifiedName ) )
            {
            // InternalInstanceLanguage.g:5724:2: ( ( ruleQualifiedName ) )
            // InternalInstanceLanguage.g:5725:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceTypeRuleAccess().getDefinitionTypeDefinitionCrossReference_2_0()); 
            }
            // InternalInstanceLanguage.g:5726:3: ( ruleQualifiedName )
            // InternalInstanceLanguage.g:5727:4: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceTypeRuleAccess().getDefinitionTypeDefinitionQualifiedNameParserRuleCall_2_0_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getInstanceTypeRuleAccess().getDefinitionTypeDefinitionQualifiedNameParserRuleCall_2_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getInstanceTypeRuleAccess().getDefinitionTypeDefinitionCrossReference_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceTypeRule__DefinitionAssignment_2"


    // $ANTLR start "rule__ArrayTypeRule__ElementsAssignment_1"
    // InternalInstanceLanguage.g:5738:1: rule__ArrayTypeRule__ElementsAssignment_1 : ( ruleTypeRule ) ;
    public final void rule__ArrayTypeRule__ElementsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:5742:1: ( ( ruleTypeRule ) )
            // InternalInstanceLanguage.g:5743:2: ( ruleTypeRule )
            {
            // InternalInstanceLanguage.g:5743:2: ( ruleTypeRule )
            // InternalInstanceLanguage.g:5744:3: ruleTypeRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayTypeRuleAccess().getElementsTypeRuleParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleTypeRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getArrayTypeRuleAccess().getElementsTypeRuleParserRuleCall_1_0()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:5753:1: rule__ParameterRule__TypeAssignment_0 : ( ruleTypeRule ) ;
    public final void rule__ParameterRule__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:5757:1: ( ( ruleTypeRule ) )
            // InternalInstanceLanguage.g:5758:2: ( ruleTypeRule )
            {
            // InternalInstanceLanguage.g:5758:2: ( ruleTypeRule )
            // InternalInstanceLanguage.g:5759:3: ruleTypeRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterRuleAccess().getTypeTypeRuleParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleTypeRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParameterRuleAccess().getTypeTypeRuleParserRuleCall_0_0()); 
            }

            }


            }

        }
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
    // InternalInstanceLanguage.g:5768:1: rule__ParameterRule__NameAssignment_1 : ( ruleStringOrId ) ;
    public final void rule__ParameterRule__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:5772:1: ( ( ruleStringOrId ) )
            // InternalInstanceLanguage.g:5773:2: ( ruleStringOrId )
            {
            // InternalInstanceLanguage.g:5773:2: ( ruleStringOrId )
            // InternalInstanceLanguage.g:5774:3: ruleStringOrId
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterRuleAccess().getNameStringOrIdParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleStringOrId();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParameterRuleAccess().getNameStringOrIdParserRuleCall_1_0()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__ImportRule__LanguageAssignment_1"
    // InternalInstanceLanguage.g:5783:1: rule__ImportRule__LanguageAssignment_1 : ( RULE_STRING ) ;
    public final void rule__ImportRule__LanguageAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:5787:1: ( ( RULE_STRING ) )
            // InternalInstanceLanguage.g:5788:2: ( RULE_STRING )
            {
            // InternalInstanceLanguage.g:5788:2: ( RULE_STRING )
            // InternalInstanceLanguage.g:5789:3: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportRuleAccess().getLanguageSTRINGTerminalRuleCall_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getImportRuleAccess().getLanguageSTRINGTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportRule__LanguageAssignment_1"


    // $ANTLR start "rule__ImportRule__ImportedNamespaceAssignment_3"
    // InternalInstanceLanguage.g:5798:1: rule__ImportRule__ImportedNamespaceAssignment_3 : ( ruleQualifiedName ) ;
    public final void rule__ImportRule__ImportedNamespaceAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:5802:1: ( ( ruleQualifiedName ) )
            // InternalInstanceLanguage.g:5803:2: ( ruleQualifiedName )
            {
            // InternalInstanceLanguage.g:5803:2: ( ruleQualifiedName )
            // InternalInstanceLanguage.g:5804:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportRuleAccess().getImportedNamespaceQualifiedNameParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getImportRuleAccess().getImportedNamespaceQualifiedNameParserRuleCall_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportRule__ImportedNamespaceAssignment_3"

    // Delegated rules


    protected DFA1 dfa1 = new DFA1(this);
    static final String dfa_1s = "\13\uffff";
    static final String dfa_2s = "\2\uffff\2\6\5\uffff\2\6";
    static final String dfa_3s = "\1\4\1\uffff\2\20\3\uffff\1\4\1\uffff\2\20";
    static final String dfa_4s = "\1\115\1\uffff\2\113\3\uffff\1\5\1\uffff\2\113";
    static final String dfa_5s = "\1\uffff\1\1\2\uffff\1\3\1\4\1\5\1\uffff\1\2\2\uffff";
    static final String dfa_6s = "\13\uffff}>";
    static final String[] dfa_7s = {
            "\1\2\1\3\3\4\6\uffff\1\4\40\uffff\1\1\10\uffff\1\5\1\uffff\1\6\21\uffff\1\4",
            "",
            "\13\6\26\uffff\2\6\1\uffff\5\6\1\10\1\6\1\uffff\1\4\16\uffff\1\7",
            "\13\6\26\uffff\2\6\1\uffff\5\6\1\10\1\6\1\uffff\1\4\16\uffff\1\7",
            "",
            "",
            "",
            "\1\11\1\12",
            "",
            "\13\6\26\uffff\2\6\1\uffff\5\6\1\10\1\6\1\uffff\1\4\16\uffff\1\7",
            "\13\6\26\uffff\2\6\1\uffff\5\6\1\10\1\6\1\uffff\1\4\16\uffff\1\7"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA1 extends DFA {

        public DFA1(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 1;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "1218:1: rule__ValueRule__Alternatives : ( ( ruleArrayRule ) | ( ruleCallRule ) | ( ruleLiteralRule ) | ( ruleParanthesesRule ) | ( ruleReferenceRule ) );";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000800000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x000A000000000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0010000000000002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0A01000000C081F0L,0x0000000000003000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0040000000000002L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x00000000003F0000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x00000000003F0002L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000007000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000007000002L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0A03000000C081F0L,0x0000000000003000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0E01000000C081F0L,0x0000000000003000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x2000000000000030L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x00007FFFF8000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000008000L,0x0000000000002000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0808000000000000L,0x00000000000001FEL});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x4004000000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000800L});

}
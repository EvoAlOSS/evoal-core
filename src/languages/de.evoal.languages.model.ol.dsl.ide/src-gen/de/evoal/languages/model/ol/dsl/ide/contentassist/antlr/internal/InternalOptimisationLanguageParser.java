package de.evoal.languages.model.ol.dsl.ide.contentassist.antlr.internal;

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
import de.evoal.languages.model.ol.dsl.services.OptimisationLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalOptimisationLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_QUOTED_ID", "RULE_ID", "RULE_DOUBLE", "RULE_INT", "RULE_STRING", "RULE_DIGIT", "RULE_EXPONENT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'false'", "'>='", "'>'", "'='", "'!='", "'<'", "'<='", "'+'", "'-'", "'*'", "'/'", "'%'", "'Y'", "'Z'", "'E'", "'P'", "'T'", "'G'", "'M'", "'k'", "'h'", "'da'", "'d'", "'c'", "'m'", "'\\u00B5'", "'n'", "'p'", "'f'", "'a'", "'z'", "'y'", "'module'", "'{'", "'}'", "'specify'", "'documenting'", "':='", "';'", "'configure'", "'for'", "'data'", "'OR'", "'XOR'", "'AND'", "'^'", "'['", "']'", "','", "'('", "')'", "':'", "'literal'", "'instance'", "'string'", "'expression'", "'int'", "'real'", "'boolean'", "'void'", "'or'", "'type'", "'of'", "'array'", "'import'", "'from'", "'.'", "'!'", "'true'"
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
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators


        public InternalOptimisationLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalOptimisationLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalOptimisationLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalOptimisationLanguage.g"; }


    	private OptimisationLanguageGrammarAccess grammarAccess;

    	public void setGrammarAccess(OptimisationLanguageGrammarAccess grammarAccess) {
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



    // $ANTLR start "entryRuleOptimisationModelRule"
    // InternalOptimisationLanguage.g:55:1: entryRuleOptimisationModelRule : ruleOptimisationModelRule EOF ;
    public final void entryRuleOptimisationModelRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:56:1: ( ruleOptimisationModelRule EOF )
            // InternalOptimisationLanguage.g:57:1: ruleOptimisationModelRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOptimisationModelRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleOptimisationModelRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOptimisationModelRuleRule()); 
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
    // $ANTLR end "entryRuleOptimisationModelRule"


    // $ANTLR start "ruleOptimisationModelRule"
    // InternalOptimisationLanguage.g:64:1: ruleOptimisationModelRule : ( ( rule__OptimisationModelRule__Group__0 ) ) ;
    public final void ruleOptimisationModelRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:68:2: ( ( ( rule__OptimisationModelRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:69:2: ( ( rule__OptimisationModelRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:69:2: ( ( rule__OptimisationModelRule__Group__0 ) )
            // InternalOptimisationLanguage.g:70:3: ( rule__OptimisationModelRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOptimisationModelRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:71:3: ( rule__OptimisationModelRule__Group__0 )
            // InternalOptimisationLanguage.g:71:4: rule__OptimisationModelRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__OptimisationModelRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOptimisationModelRuleAccess().getGroup()); 
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
    // $ANTLR end "ruleOptimisationModelRule"


    // $ANTLR start "entryRuleProblemRule"
    // InternalOptimisationLanguage.g:80:1: entryRuleProblemRule : ruleProblemRule EOF ;
    public final void entryRuleProblemRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:81:1: ( ruleProblemRule EOF )
            // InternalOptimisationLanguage.g:82:1: ruleProblemRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProblemRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleProblemRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getProblemRuleRule()); 
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
    // $ANTLR end "entryRuleProblemRule"


    // $ANTLR start "ruleProblemRule"
    // InternalOptimisationLanguage.g:89:1: ruleProblemRule : ( ( rule__ProblemRule__Group__0 ) ) ;
    public final void ruleProblemRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:93:2: ( ( ( rule__ProblemRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:94:2: ( ( rule__ProblemRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:94:2: ( ( rule__ProblemRule__Group__0 ) )
            // InternalOptimisationLanguage.g:95:3: ( rule__ProblemRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProblemRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:96:3: ( rule__ProblemRule__Group__0 )
            // InternalOptimisationLanguage.g:96:4: rule__ProblemRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ProblemRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getProblemRuleAccess().getGroup()); 
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
    // $ANTLR end "ruleProblemRule"


    // $ANTLR start "entryRuleAlgorithmInstanceRule"
    // InternalOptimisationLanguage.g:105:1: entryRuleAlgorithmInstanceRule : ruleAlgorithmInstanceRule EOF ;
    public final void entryRuleAlgorithmInstanceRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:106:1: ( ruleAlgorithmInstanceRule EOF )
            // InternalOptimisationLanguage.g:107:1: ruleAlgorithmInstanceRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAlgorithmInstanceRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleAlgorithmInstanceRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAlgorithmInstanceRuleRule()); 
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
    // $ANTLR end "entryRuleAlgorithmInstanceRule"


    // $ANTLR start "ruleAlgorithmInstanceRule"
    // InternalOptimisationLanguage.g:114:1: ruleAlgorithmInstanceRule : ( ( rule__AlgorithmInstanceRule__Group__0 ) ) ;
    public final void ruleAlgorithmInstanceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:118:2: ( ( ( rule__AlgorithmInstanceRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:119:2: ( ( rule__AlgorithmInstanceRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:119:2: ( ( rule__AlgorithmInstanceRule__Group__0 ) )
            // InternalOptimisationLanguage.g:120:3: ( rule__AlgorithmInstanceRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAlgorithmInstanceRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:121:3: ( rule__AlgorithmInstanceRule__Group__0 )
            // InternalOptimisationLanguage.g:121:4: rule__AlgorithmInstanceRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__AlgorithmInstanceRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAlgorithmInstanceRuleAccess().getGroup()); 
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
    // $ANTLR end "ruleAlgorithmInstanceRule"


    // $ANTLR start "entryRuleReferenceRule"
    // InternalOptimisationLanguage.g:130:1: entryRuleReferenceRule : ruleReferenceRule EOF ;
    public final void entryRuleReferenceRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:131:1: ( ruleReferenceRule EOF )
            // InternalOptimisationLanguage.g:132:1: ruleReferenceRule EOF
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
    // InternalOptimisationLanguage.g:139:1: ruleReferenceRule : ( ( rule__ReferenceRule__Alternatives ) ) ;
    public final void ruleReferenceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:143:2: ( ( ( rule__ReferenceRule__Alternatives ) ) )
            // InternalOptimisationLanguage.g:144:2: ( ( rule__ReferenceRule__Alternatives ) )
            {
            // InternalOptimisationLanguage.g:144:2: ( ( rule__ReferenceRule__Alternatives ) )
            // InternalOptimisationLanguage.g:145:3: ( rule__ReferenceRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceRuleAccess().getAlternatives()); 
            }
            // InternalOptimisationLanguage.g:146:3: ( rule__ReferenceRule__Alternatives )
            // InternalOptimisationLanguage.g:146:4: rule__ReferenceRule__Alternatives
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
    // InternalOptimisationLanguage.g:155:1: entryRuleDataReferenceRule : ruleDataReferenceRule EOF ;
    public final void entryRuleDataReferenceRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:156:1: ( ruleDataReferenceRule EOF )
            // InternalOptimisationLanguage.g:157:1: ruleDataReferenceRule EOF
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
    // InternalOptimisationLanguage.g:164:1: ruleDataReferenceRule : ( ( rule__DataReferenceRule__Group__0 ) ) ;
    public final void ruleDataReferenceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:168:2: ( ( ( rule__DataReferenceRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:169:2: ( ( rule__DataReferenceRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:169:2: ( ( rule__DataReferenceRule__Group__0 ) )
            // InternalOptimisationLanguage.g:170:3: ( rule__DataReferenceRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataReferenceRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:171:3: ( rule__DataReferenceRule__Group__0 )
            // InternalOptimisationLanguage.g:171:4: rule__DataReferenceRule__Group__0
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


    // $ANTLR start "entryRuleExpressionRule"
    // InternalOptimisationLanguage.g:180:1: entryRuleExpressionRule : ruleExpressionRule EOF ;
    public final void entryRuleExpressionRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:181:1: ( ruleExpressionRule EOF )
            // InternalOptimisationLanguage.g:182:1: ruleExpressionRule EOF
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
    // InternalOptimisationLanguage.g:189:1: ruleExpressionRule : ( ruleOrExpressionRule ) ;
    public final void ruleExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:193:2: ( ( ruleOrExpressionRule ) )
            // InternalOptimisationLanguage.g:194:2: ( ruleOrExpressionRule )
            {
            // InternalOptimisationLanguage.g:194:2: ( ruleOrExpressionRule )
            // InternalOptimisationLanguage.g:195:3: ruleOrExpressionRule
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
    // InternalOptimisationLanguage.g:205:1: entryRuleOrExpressionRule : ruleOrExpressionRule EOF ;
    public final void entryRuleOrExpressionRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:206:1: ( ruleOrExpressionRule EOF )
            // InternalOptimisationLanguage.g:207:1: ruleOrExpressionRule EOF
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
    // InternalOptimisationLanguage.g:214:1: ruleOrExpressionRule : ( ( rule__OrExpressionRule__Group__0 ) ) ;
    public final void ruleOrExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:218:2: ( ( ( rule__OrExpressionRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:219:2: ( ( rule__OrExpressionRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:219:2: ( ( rule__OrExpressionRule__Group__0 ) )
            // InternalOptimisationLanguage.g:220:3: ( rule__OrExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:221:3: ( rule__OrExpressionRule__Group__0 )
            // InternalOptimisationLanguage.g:221:4: rule__OrExpressionRule__Group__0
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
    // InternalOptimisationLanguage.g:230:1: entryRuleXorExpressionRule : ruleXorExpressionRule EOF ;
    public final void entryRuleXorExpressionRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:231:1: ( ruleXorExpressionRule EOF )
            // InternalOptimisationLanguage.g:232:1: ruleXorExpressionRule EOF
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
    // InternalOptimisationLanguage.g:239:1: ruleXorExpressionRule : ( ( rule__XorExpressionRule__Group__0 ) ) ;
    public final void ruleXorExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:243:2: ( ( ( rule__XorExpressionRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:244:2: ( ( rule__XorExpressionRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:244:2: ( ( rule__XorExpressionRule__Group__0 ) )
            // InternalOptimisationLanguage.g:245:3: ( rule__XorExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXorExpressionRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:246:3: ( rule__XorExpressionRule__Group__0 )
            // InternalOptimisationLanguage.g:246:4: rule__XorExpressionRule__Group__0
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
    // InternalOptimisationLanguage.g:255:1: entryRuleAndExpressionRule : ruleAndExpressionRule EOF ;
    public final void entryRuleAndExpressionRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:256:1: ( ruleAndExpressionRule EOF )
            // InternalOptimisationLanguage.g:257:1: ruleAndExpressionRule EOF
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
    // InternalOptimisationLanguage.g:264:1: ruleAndExpressionRule : ( ( rule__AndExpressionRule__Group__0 ) ) ;
    public final void ruleAndExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:268:2: ( ( ( rule__AndExpressionRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:269:2: ( ( rule__AndExpressionRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:269:2: ( ( rule__AndExpressionRule__Group__0 ) )
            // InternalOptimisationLanguage.g:270:3: ( rule__AndExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:271:3: ( rule__AndExpressionRule__Group__0 )
            // InternalOptimisationLanguage.g:271:4: rule__AndExpressionRule__Group__0
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
    // InternalOptimisationLanguage.g:280:1: entryRuleNotExpressionRule : ruleNotExpressionRule EOF ;
    public final void entryRuleNotExpressionRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:281:1: ( ruleNotExpressionRule EOF )
            // InternalOptimisationLanguage.g:282:1: ruleNotExpressionRule EOF
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
    // InternalOptimisationLanguage.g:289:1: ruleNotExpressionRule : ( ( rule__NotExpressionRule__Group__0 ) ) ;
    public final void ruleNotExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:293:2: ( ( ( rule__NotExpressionRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:294:2: ( ( rule__NotExpressionRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:294:2: ( ( rule__NotExpressionRule__Group__0 ) )
            // InternalOptimisationLanguage.g:295:3: ( rule__NotExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNotExpressionRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:296:3: ( rule__NotExpressionRule__Group__0 )
            // InternalOptimisationLanguage.g:296:4: rule__NotExpressionRule__Group__0
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
    // InternalOptimisationLanguage.g:305:1: entryRuleComparisonExpressionRule : ruleComparisonExpressionRule EOF ;
    public final void entryRuleComparisonExpressionRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:306:1: ( ruleComparisonExpressionRule EOF )
            // InternalOptimisationLanguage.g:307:1: ruleComparisonExpressionRule EOF
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
    // InternalOptimisationLanguage.g:314:1: ruleComparisonExpressionRule : ( ( rule__ComparisonExpressionRule__Group__0 ) ) ;
    public final void ruleComparisonExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:318:2: ( ( ( rule__ComparisonExpressionRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:319:2: ( ( rule__ComparisonExpressionRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:319:2: ( ( rule__ComparisonExpressionRule__Group__0 ) )
            // InternalOptimisationLanguage.g:320:3: ( rule__ComparisonExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonExpressionRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:321:3: ( rule__ComparisonExpressionRule__Group__0 )
            // InternalOptimisationLanguage.g:321:4: rule__ComparisonExpressionRule__Group__0
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
    // InternalOptimisationLanguage.g:330:1: entryRulePartialComparisonExpressionRule : rulePartialComparisonExpressionRule EOF ;
    public final void entryRulePartialComparisonExpressionRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:331:1: ( rulePartialComparisonExpressionRule EOF )
            // InternalOptimisationLanguage.g:332:1: rulePartialComparisonExpressionRule EOF
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
    // InternalOptimisationLanguage.g:339:1: rulePartialComparisonExpressionRule : ( ( rule__PartialComparisonExpressionRule__Group__0 ) ) ;
    public final void rulePartialComparisonExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:343:2: ( ( ( rule__PartialComparisonExpressionRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:344:2: ( ( rule__PartialComparisonExpressionRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:344:2: ( ( rule__PartialComparisonExpressionRule__Group__0 ) )
            // InternalOptimisationLanguage.g:345:3: ( rule__PartialComparisonExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartialComparisonExpressionRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:346:3: ( rule__PartialComparisonExpressionRule__Group__0 )
            // InternalOptimisationLanguage.g:346:4: rule__PartialComparisonExpressionRule__Group__0
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
    // InternalOptimisationLanguage.g:355:1: entryRuleAddOrSubtractExpressionRule : ruleAddOrSubtractExpressionRule EOF ;
    public final void entryRuleAddOrSubtractExpressionRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:356:1: ( ruleAddOrSubtractExpressionRule EOF )
            // InternalOptimisationLanguage.g:357:1: ruleAddOrSubtractExpressionRule EOF
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
    // InternalOptimisationLanguage.g:364:1: ruleAddOrSubtractExpressionRule : ( ( rule__AddOrSubtractExpressionRule__Group__0 ) ) ;
    public final void ruleAddOrSubtractExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:368:2: ( ( ( rule__AddOrSubtractExpressionRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:369:2: ( ( rule__AddOrSubtractExpressionRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:369:2: ( ( rule__AddOrSubtractExpressionRule__Group__0 ) )
            // InternalOptimisationLanguage.g:370:3: ( rule__AddOrSubtractExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:371:3: ( rule__AddOrSubtractExpressionRule__Group__0 )
            // InternalOptimisationLanguage.g:371:4: rule__AddOrSubtractExpressionRule__Group__0
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
    // InternalOptimisationLanguage.g:380:1: entryRuleMultiplyDivideModuloExpressionRule : ruleMultiplyDivideModuloExpressionRule EOF ;
    public final void entryRuleMultiplyDivideModuloExpressionRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:381:1: ( ruleMultiplyDivideModuloExpressionRule EOF )
            // InternalOptimisationLanguage.g:382:1: ruleMultiplyDivideModuloExpressionRule EOF
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
    // InternalOptimisationLanguage.g:389:1: ruleMultiplyDivideModuloExpressionRule : ( ( rule__MultiplyDivideModuloExpressionRule__Group__0 ) ) ;
    public final void ruleMultiplyDivideModuloExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:393:2: ( ( ( rule__MultiplyDivideModuloExpressionRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:394:2: ( ( rule__MultiplyDivideModuloExpressionRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:394:2: ( ( rule__MultiplyDivideModuloExpressionRule__Group__0 ) )
            // InternalOptimisationLanguage.g:395:3: ( rule__MultiplyDivideModuloExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:396:3: ( rule__MultiplyDivideModuloExpressionRule__Group__0 )
            // InternalOptimisationLanguage.g:396:4: rule__MultiplyDivideModuloExpressionRule__Group__0
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
    // InternalOptimisationLanguage.g:405:1: entryRulePowerOfExpressionRule : rulePowerOfExpressionRule EOF ;
    public final void entryRulePowerOfExpressionRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:406:1: ( rulePowerOfExpressionRule EOF )
            // InternalOptimisationLanguage.g:407:1: rulePowerOfExpressionRule EOF
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
    // InternalOptimisationLanguage.g:414:1: rulePowerOfExpressionRule : ( ( rule__PowerOfExpressionRule__Group__0 ) ) ;
    public final void rulePowerOfExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:418:2: ( ( ( rule__PowerOfExpressionRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:419:2: ( ( rule__PowerOfExpressionRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:419:2: ( ( rule__PowerOfExpressionRule__Group__0 ) )
            // InternalOptimisationLanguage.g:420:3: ( rule__PowerOfExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPowerOfExpressionRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:421:3: ( rule__PowerOfExpressionRule__Group__0 )
            // InternalOptimisationLanguage.g:421:4: rule__PowerOfExpressionRule__Group__0
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
    // InternalOptimisationLanguage.g:430:1: entryRuleUnaryAddOrSubtractExpressionRule : ruleUnaryAddOrSubtractExpressionRule EOF ;
    public final void entryRuleUnaryAddOrSubtractExpressionRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:431:1: ( ruleUnaryAddOrSubtractExpressionRule EOF )
            // InternalOptimisationLanguage.g:432:1: ruleUnaryAddOrSubtractExpressionRule EOF
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
    // InternalOptimisationLanguage.g:439:1: ruleUnaryAddOrSubtractExpressionRule : ( ( rule__UnaryAddOrSubtractExpressionRule__Group__0 ) ) ;
    public final void ruleUnaryAddOrSubtractExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:443:2: ( ( ( rule__UnaryAddOrSubtractExpressionRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:444:2: ( ( rule__UnaryAddOrSubtractExpressionRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:444:2: ( ( rule__UnaryAddOrSubtractExpressionRule__Group__0 ) )
            // InternalOptimisationLanguage.g:445:3: ( rule__UnaryAddOrSubtractExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:446:3: ( rule__UnaryAddOrSubtractExpressionRule__Group__0 )
            // InternalOptimisationLanguage.g:446:4: rule__UnaryAddOrSubtractExpressionRule__Group__0
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
    // InternalOptimisationLanguage.g:455:1: entryRuleValueRule : ruleValueRule EOF ;
    public final void entryRuleValueRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:456:1: ( ruleValueRule EOF )
            // InternalOptimisationLanguage.g:457:1: ruleValueRule EOF
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
    // InternalOptimisationLanguage.g:464:1: ruleValueRule : ( ( rule__ValueRule__Alternatives ) ) ;
    public final void ruleValueRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:468:2: ( ( ( rule__ValueRule__Alternatives ) ) )
            // InternalOptimisationLanguage.g:469:2: ( ( rule__ValueRule__Alternatives ) )
            {
            // InternalOptimisationLanguage.g:469:2: ( ( rule__ValueRule__Alternatives ) )
            // InternalOptimisationLanguage.g:470:3: ( rule__ValueRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueRuleAccess().getAlternatives()); 
            }
            // InternalOptimisationLanguage.g:471:3: ( rule__ValueRule__Alternatives )
            // InternalOptimisationLanguage.g:471:4: rule__ValueRule__Alternatives
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
    // InternalOptimisationLanguage.g:480:1: entryRuleArrayRule : ruleArrayRule EOF ;
    public final void entryRuleArrayRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:481:1: ( ruleArrayRule EOF )
            // InternalOptimisationLanguage.g:482:1: ruleArrayRule EOF
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
    // InternalOptimisationLanguage.g:489:1: ruleArrayRule : ( ( rule__ArrayRule__Group__0 ) ) ;
    public final void ruleArrayRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:493:2: ( ( ( rule__ArrayRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:494:2: ( ( rule__ArrayRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:494:2: ( ( rule__ArrayRule__Group__0 ) )
            // InternalOptimisationLanguage.g:495:3: ( rule__ArrayRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:496:3: ( rule__ArrayRule__Group__0 )
            // InternalOptimisationLanguage.g:496:4: rule__ArrayRule__Group__0
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
    // InternalOptimisationLanguage.g:505:1: entryRuleParanthesesRule : ruleParanthesesRule EOF ;
    public final void entryRuleParanthesesRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:506:1: ( ruleParanthesesRule EOF )
            // InternalOptimisationLanguage.g:507:1: ruleParanthesesRule EOF
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
    // InternalOptimisationLanguage.g:514:1: ruleParanthesesRule : ( ( rule__ParanthesesRule__Group__0 ) ) ;
    public final void ruleParanthesesRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:518:2: ( ( ( rule__ParanthesesRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:519:2: ( ( rule__ParanthesesRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:519:2: ( ( rule__ParanthesesRule__Group__0 ) )
            // InternalOptimisationLanguage.g:520:3: ( rule__ParanthesesRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParanthesesRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:521:3: ( rule__ParanthesesRule__Group__0 )
            // InternalOptimisationLanguage.g:521:4: rule__ParanthesesRule__Group__0
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
    // InternalOptimisationLanguage.g:530:1: entryRuleCallRule : ruleCallRule EOF ;
    public final void entryRuleCallRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:531:1: ( ruleCallRule EOF )
            // InternalOptimisationLanguage.g:532:1: ruleCallRule EOF
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
    // InternalOptimisationLanguage.g:539:1: ruleCallRule : ( ( rule__CallRule__Group__0 ) ) ;
    public final void ruleCallRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:543:2: ( ( ( rule__CallRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:544:2: ( ( rule__CallRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:544:2: ( ( rule__CallRule__Group__0 ) )
            // InternalOptimisationLanguage.g:545:3: ( rule__CallRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:546:3: ( rule__CallRule__Group__0 )
            // InternalOptimisationLanguage.g:546:4: rule__CallRule__Group__0
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


    // $ANTLR start "entryRuleConstantReferenceRule"
    // InternalOptimisationLanguage.g:555:1: entryRuleConstantReferenceRule : ruleConstantReferenceRule EOF ;
    public final void entryRuleConstantReferenceRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:556:1: ( ruleConstantReferenceRule EOF )
            // InternalOptimisationLanguage.g:557:1: ruleConstantReferenceRule EOF
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
    // InternalOptimisationLanguage.g:564:1: ruleConstantReferenceRule : ( ( rule__ConstantReferenceRule__DefinitionAssignment ) ) ;
    public final void ruleConstantReferenceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:568:2: ( ( ( rule__ConstantReferenceRule__DefinitionAssignment ) ) )
            // InternalOptimisationLanguage.g:569:2: ( ( rule__ConstantReferenceRule__DefinitionAssignment ) )
            {
            // InternalOptimisationLanguage.g:569:2: ( ( rule__ConstantReferenceRule__DefinitionAssignment ) )
            // InternalOptimisationLanguage.g:570:3: ( rule__ConstantReferenceRule__DefinitionAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstantReferenceRuleAccess().getDefinitionAssignment()); 
            }
            // InternalOptimisationLanguage.g:571:3: ( rule__ConstantReferenceRule__DefinitionAssignment )
            // InternalOptimisationLanguage.g:571:4: rule__ConstantReferenceRule__DefinitionAssignment
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
    // InternalOptimisationLanguage.g:580:1: entryRuleLiteralRule : ruleLiteralRule EOF ;
    public final void entryRuleLiteralRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:581:1: ( ruleLiteralRule EOF )
            // InternalOptimisationLanguage.g:582:1: ruleLiteralRule EOF
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
    // InternalOptimisationLanguage.g:589:1: ruleLiteralRule : ( ( rule__LiteralRule__Alternatives ) ) ;
    public final void ruleLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:593:2: ( ( ( rule__LiteralRule__Alternatives ) ) )
            // InternalOptimisationLanguage.g:594:2: ( ( rule__LiteralRule__Alternatives ) )
            {
            // InternalOptimisationLanguage.g:594:2: ( ( rule__LiteralRule__Alternatives ) )
            // InternalOptimisationLanguage.g:595:3: ( rule__LiteralRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralRuleAccess().getAlternatives()); 
            }
            // InternalOptimisationLanguage.g:596:3: ( rule__LiteralRule__Alternatives )
            // InternalOptimisationLanguage.g:596:4: rule__LiteralRule__Alternatives
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
    // InternalOptimisationLanguage.g:605:1: entryRuleInstanceLiteralRule : ruleInstanceLiteralRule EOF ;
    public final void entryRuleInstanceLiteralRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:606:1: ( ruleInstanceLiteralRule EOF )
            // InternalOptimisationLanguage.g:607:1: ruleInstanceLiteralRule EOF
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
    // InternalOptimisationLanguage.g:614:1: ruleInstanceLiteralRule : ( ( rule__InstanceLiteralRule__Group__0 ) ) ;
    public final void ruleInstanceLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:618:2: ( ( ( rule__InstanceLiteralRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:619:2: ( ( rule__InstanceLiteralRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:619:2: ( ( rule__InstanceLiteralRule__Group__0 ) )
            // InternalOptimisationLanguage.g:620:3: ( rule__InstanceLiteralRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceLiteralRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:621:3: ( rule__InstanceLiteralRule__Group__0 )
            // InternalOptimisationLanguage.g:621:4: rule__InstanceLiteralRule__Group__0
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
    // InternalOptimisationLanguage.g:630:1: entryRuleAttributeRule : ruleAttributeRule EOF ;
    public final void entryRuleAttributeRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:631:1: ( ruleAttributeRule EOF )
            // InternalOptimisationLanguage.g:632:1: ruleAttributeRule EOF
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
    // InternalOptimisationLanguage.g:639:1: ruleAttributeRule : ( ( rule__AttributeRule__Group__0 ) ) ;
    public final void ruleAttributeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:643:2: ( ( ( rule__AttributeRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:644:2: ( ( rule__AttributeRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:644:2: ( ( rule__AttributeRule__Group__0 ) )
            // InternalOptimisationLanguage.g:645:3: ( rule__AttributeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:646:3: ( rule__AttributeRule__Group__0 )
            // InternalOptimisationLanguage.g:646:4: rule__AttributeRule__Group__0
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
    // InternalOptimisationLanguage.g:655:1: entryRuleNumberLiteralRule : ruleNumberLiteralRule EOF ;
    public final void entryRuleNumberLiteralRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:656:1: ( ruleNumberLiteralRule EOF )
            // InternalOptimisationLanguage.g:657:1: ruleNumberLiteralRule EOF
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
    // InternalOptimisationLanguage.g:664:1: ruleNumberLiteralRule : ( ( rule__NumberLiteralRule__Alternatives ) ) ;
    public final void ruleNumberLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:668:2: ( ( ( rule__NumberLiteralRule__Alternatives ) ) )
            // InternalOptimisationLanguage.g:669:2: ( ( rule__NumberLiteralRule__Alternatives ) )
            {
            // InternalOptimisationLanguage.g:669:2: ( ( rule__NumberLiteralRule__Alternatives ) )
            // InternalOptimisationLanguage.g:670:3: ( rule__NumberLiteralRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumberLiteralRuleAccess().getAlternatives()); 
            }
            // InternalOptimisationLanguage.g:671:3: ( rule__NumberLiteralRule__Alternatives )
            // InternalOptimisationLanguage.g:671:4: rule__NumberLiteralRule__Alternatives
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
    // InternalOptimisationLanguage.g:680:1: entryRuleRealLiteralRule : ruleRealLiteralRule EOF ;
    public final void entryRuleRealLiteralRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:681:1: ( ruleRealLiteralRule EOF )
            // InternalOptimisationLanguage.g:682:1: ruleRealLiteralRule EOF
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
    // InternalOptimisationLanguage.g:689:1: ruleRealLiteralRule : ( ( rule__RealLiteralRule__Group__0 ) ) ;
    public final void ruleRealLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:693:2: ( ( ( rule__RealLiteralRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:694:2: ( ( rule__RealLiteralRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:694:2: ( ( rule__RealLiteralRule__Group__0 ) )
            // InternalOptimisationLanguage.g:695:3: ( rule__RealLiteralRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealLiteralRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:696:3: ( rule__RealLiteralRule__Group__0 )
            // InternalOptimisationLanguage.g:696:4: rule__RealLiteralRule__Group__0
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
    // InternalOptimisationLanguage.g:705:1: entryRuleIntegerLiteralRule : ruleIntegerLiteralRule EOF ;
    public final void entryRuleIntegerLiteralRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:706:1: ( ruleIntegerLiteralRule EOF )
            // InternalOptimisationLanguage.g:707:1: ruleIntegerLiteralRule EOF
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
    // InternalOptimisationLanguage.g:714:1: ruleIntegerLiteralRule : ( ( rule__IntegerLiteralRule__Group__0 ) ) ;
    public final void ruleIntegerLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:718:2: ( ( ( rule__IntegerLiteralRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:719:2: ( ( rule__IntegerLiteralRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:719:2: ( ( rule__IntegerLiteralRule__Group__0 ) )
            // InternalOptimisationLanguage.g:720:3: ( rule__IntegerLiteralRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegerLiteralRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:721:3: ( rule__IntegerLiteralRule__Group__0 )
            // InternalOptimisationLanguage.g:721:4: rule__IntegerLiteralRule__Group__0
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
    // InternalOptimisationLanguage.g:730:1: entryRuleStringLiteralRule : ruleStringLiteralRule EOF ;
    public final void entryRuleStringLiteralRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:731:1: ( ruleStringLiteralRule EOF )
            // InternalOptimisationLanguage.g:732:1: ruleStringLiteralRule EOF
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
    // InternalOptimisationLanguage.g:739:1: ruleStringLiteralRule : ( ( rule__StringLiteralRule__ValueAssignment ) ) ;
    public final void ruleStringLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:743:2: ( ( ( rule__StringLiteralRule__ValueAssignment ) ) )
            // InternalOptimisationLanguage.g:744:2: ( ( rule__StringLiteralRule__ValueAssignment ) )
            {
            // InternalOptimisationLanguage.g:744:2: ( ( rule__StringLiteralRule__ValueAssignment ) )
            // InternalOptimisationLanguage.g:745:3: ( rule__StringLiteralRule__ValueAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringLiteralRuleAccess().getValueAssignment()); 
            }
            // InternalOptimisationLanguage.g:746:3: ( rule__StringLiteralRule__ValueAssignment )
            // InternalOptimisationLanguage.g:746:4: rule__StringLiteralRule__ValueAssignment
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
    // InternalOptimisationLanguage.g:755:1: entryRuleBooleanLiteralRule : ruleBooleanLiteralRule EOF ;
    public final void entryRuleBooleanLiteralRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:756:1: ( ruleBooleanLiteralRule EOF )
            // InternalOptimisationLanguage.g:757:1: ruleBooleanLiteralRule EOF
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
    // InternalOptimisationLanguage.g:764:1: ruleBooleanLiteralRule : ( ( rule__BooleanLiteralRule__Group__0 ) ) ;
    public final void ruleBooleanLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:768:2: ( ( ( rule__BooleanLiteralRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:769:2: ( ( rule__BooleanLiteralRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:769:2: ( ( rule__BooleanLiteralRule__Group__0 ) )
            // InternalOptimisationLanguage.g:770:3: ( rule__BooleanLiteralRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:771:3: ( rule__BooleanLiteralRule__Group__0 )
            // InternalOptimisationLanguage.g:771:4: rule__BooleanLiteralRule__Group__0
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


    // $ANTLR start "entryRuleAttributeDefinitionRule"
    // InternalOptimisationLanguage.g:780:1: entryRuleAttributeDefinitionRule : ruleAttributeDefinitionRule EOF ;
    public final void entryRuleAttributeDefinitionRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:781:1: ( ruleAttributeDefinitionRule EOF )
            // InternalOptimisationLanguage.g:782:1: ruleAttributeDefinitionRule EOF
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
    // InternalOptimisationLanguage.g:789:1: ruleAttributeDefinitionRule : ( ( rule__AttributeDefinitionRule__Group__0 ) ) ;
    public final void ruleAttributeDefinitionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:793:2: ( ( ( rule__AttributeDefinitionRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:794:2: ( ( rule__AttributeDefinitionRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:794:2: ( ( rule__AttributeDefinitionRule__Group__0 ) )
            // InternalOptimisationLanguage.g:795:3: ( rule__AttributeDefinitionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:796:3: ( rule__AttributeDefinitionRule__Group__0 )
            // InternalOptimisationLanguage.g:796:4: rule__AttributeDefinitionRule__Group__0
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
    // InternalOptimisationLanguage.g:805:1: entryRuleTypeRule : ruleTypeRule EOF ;
    public final void entryRuleTypeRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:806:1: ( ruleTypeRule EOF )
            // InternalOptimisationLanguage.g:807:1: ruleTypeRule EOF
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
    // InternalOptimisationLanguage.g:814:1: ruleTypeRule : ( ( rule__TypeRule__Alternatives ) ) ;
    public final void ruleTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:818:2: ( ( ( rule__TypeRule__Alternatives ) ) )
            // InternalOptimisationLanguage.g:819:2: ( ( rule__TypeRule__Alternatives ) )
            {
            // InternalOptimisationLanguage.g:819:2: ( ( rule__TypeRule__Alternatives ) )
            // InternalOptimisationLanguage.g:820:3: ( rule__TypeRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeRuleAccess().getAlternatives()); 
            }
            // InternalOptimisationLanguage.g:821:3: ( rule__TypeRule__Alternatives )
            // InternalOptimisationLanguage.g:821:4: rule__TypeRule__Alternatives
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
    // InternalOptimisationLanguage.g:830:1: entryRuleLiteralTypeRule : ruleLiteralTypeRule EOF ;
    public final void entryRuleLiteralTypeRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:831:1: ( ruleLiteralTypeRule EOF )
            // InternalOptimisationLanguage.g:832:1: ruleLiteralTypeRule EOF
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
    // InternalOptimisationLanguage.g:839:1: ruleLiteralTypeRule : ( ( rule__LiteralTypeRule__Group__0 ) ) ;
    public final void ruleLiteralTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:843:2: ( ( ( rule__LiteralTypeRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:844:2: ( ( rule__LiteralTypeRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:844:2: ( ( rule__LiteralTypeRule__Group__0 ) )
            // InternalOptimisationLanguage.g:845:3: ( rule__LiteralTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralTypeRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:846:3: ( rule__LiteralTypeRule__Group__0 )
            // InternalOptimisationLanguage.g:846:4: rule__LiteralTypeRule__Group__0
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


    // $ANTLR start "entryRuleInstanceTypeRule"
    // InternalOptimisationLanguage.g:855:1: entryRuleInstanceTypeRule : ruleInstanceTypeRule EOF ;
    public final void entryRuleInstanceTypeRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:856:1: ( ruleInstanceTypeRule EOF )
            // InternalOptimisationLanguage.g:857:1: ruleInstanceTypeRule EOF
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
    // InternalOptimisationLanguage.g:864:1: ruleInstanceTypeRule : ( ( rule__InstanceTypeRule__Group__0 ) ) ;
    public final void ruleInstanceTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:868:2: ( ( ( rule__InstanceTypeRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:869:2: ( ( rule__InstanceTypeRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:869:2: ( ( rule__InstanceTypeRule__Group__0 ) )
            // InternalOptimisationLanguage.g:870:3: ( rule__InstanceTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceTypeRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:871:3: ( rule__InstanceTypeRule__Group__0 )
            // InternalOptimisationLanguage.g:871:4: rule__InstanceTypeRule__Group__0
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
    // InternalOptimisationLanguage.g:880:1: entryRuleStringTypeRule : ruleStringTypeRule EOF ;
    public final void entryRuleStringTypeRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:881:1: ( ruleStringTypeRule EOF )
            // InternalOptimisationLanguage.g:882:1: ruleStringTypeRule EOF
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
    // InternalOptimisationLanguage.g:889:1: ruleStringTypeRule : ( ( rule__StringTypeRule__Group__0 ) ) ;
    public final void ruleStringTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:893:2: ( ( ( rule__StringTypeRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:894:2: ( ( rule__StringTypeRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:894:2: ( ( rule__StringTypeRule__Group__0 ) )
            // InternalOptimisationLanguage.g:895:3: ( rule__StringTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringTypeRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:896:3: ( rule__StringTypeRule__Group__0 )
            // InternalOptimisationLanguage.g:896:4: rule__StringTypeRule__Group__0
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
    // InternalOptimisationLanguage.g:905:1: entryRuleExpressionTypeRule : ruleExpressionTypeRule EOF ;
    public final void entryRuleExpressionTypeRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:906:1: ( ruleExpressionTypeRule EOF )
            // InternalOptimisationLanguage.g:907:1: ruleExpressionTypeRule EOF
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
    // InternalOptimisationLanguage.g:914:1: ruleExpressionTypeRule : ( ( rule__ExpressionTypeRule__Group__0 ) ) ;
    public final void ruleExpressionTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:918:2: ( ( ( rule__ExpressionTypeRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:919:2: ( ( rule__ExpressionTypeRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:919:2: ( ( rule__ExpressionTypeRule__Group__0 ) )
            // InternalOptimisationLanguage.g:920:3: ( rule__ExpressionTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionTypeRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:921:3: ( rule__ExpressionTypeRule__Group__0 )
            // InternalOptimisationLanguage.g:921:4: rule__ExpressionTypeRule__Group__0
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
    // InternalOptimisationLanguage.g:930:1: entryRuleIntTypeRule : ruleIntTypeRule EOF ;
    public final void entryRuleIntTypeRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:931:1: ( ruleIntTypeRule EOF )
            // InternalOptimisationLanguage.g:932:1: ruleIntTypeRule EOF
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
    // InternalOptimisationLanguage.g:939:1: ruleIntTypeRule : ( ( rule__IntTypeRule__Group__0 ) ) ;
    public final void ruleIntTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:943:2: ( ( ( rule__IntTypeRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:944:2: ( ( rule__IntTypeRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:944:2: ( ( rule__IntTypeRule__Group__0 ) )
            // InternalOptimisationLanguage.g:945:3: ( rule__IntTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntTypeRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:946:3: ( rule__IntTypeRule__Group__0 )
            // InternalOptimisationLanguage.g:946:4: rule__IntTypeRule__Group__0
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
    // InternalOptimisationLanguage.g:955:1: entryRuleRealTypeRule : ruleRealTypeRule EOF ;
    public final void entryRuleRealTypeRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:956:1: ( ruleRealTypeRule EOF )
            // InternalOptimisationLanguage.g:957:1: ruleRealTypeRule EOF
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
    // InternalOptimisationLanguage.g:964:1: ruleRealTypeRule : ( ( rule__RealTypeRule__Group__0 ) ) ;
    public final void ruleRealTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:968:2: ( ( ( rule__RealTypeRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:969:2: ( ( rule__RealTypeRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:969:2: ( ( rule__RealTypeRule__Group__0 ) )
            // InternalOptimisationLanguage.g:970:3: ( rule__RealTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealTypeRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:971:3: ( rule__RealTypeRule__Group__0 )
            // InternalOptimisationLanguage.g:971:4: rule__RealTypeRule__Group__0
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
    // InternalOptimisationLanguage.g:980:1: entryRuleBooleanTypeRule : ruleBooleanTypeRule EOF ;
    public final void entryRuleBooleanTypeRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:981:1: ( ruleBooleanTypeRule EOF )
            // InternalOptimisationLanguage.g:982:1: ruleBooleanTypeRule EOF
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
    // InternalOptimisationLanguage.g:989:1: ruleBooleanTypeRule : ( ( rule__BooleanTypeRule__Group__0 ) ) ;
    public final void ruleBooleanTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:993:2: ( ( ( rule__BooleanTypeRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:994:2: ( ( rule__BooleanTypeRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:994:2: ( ( rule__BooleanTypeRule__Group__0 ) )
            // InternalOptimisationLanguage.g:995:3: ( rule__BooleanTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanTypeRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:996:3: ( rule__BooleanTypeRule__Group__0 )
            // InternalOptimisationLanguage.g:996:4: rule__BooleanTypeRule__Group__0
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
    // InternalOptimisationLanguage.g:1005:1: entryRuleVoidTypeRule : ruleVoidTypeRule EOF ;
    public final void entryRuleVoidTypeRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:1006:1: ( ruleVoidTypeRule EOF )
            // InternalOptimisationLanguage.g:1007:1: ruleVoidTypeRule EOF
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
    // InternalOptimisationLanguage.g:1014:1: ruleVoidTypeRule : ( ( rule__VoidTypeRule__Group__0 ) ) ;
    public final void ruleVoidTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1018:2: ( ( ( rule__VoidTypeRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:1019:2: ( ( rule__VoidTypeRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:1019:2: ( ( rule__VoidTypeRule__Group__0 ) )
            // InternalOptimisationLanguage.g:1020:3: ( rule__VoidTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVoidTypeRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:1021:3: ( rule__VoidTypeRule__Group__0 )
            // InternalOptimisationLanguage.g:1021:4: rule__VoidTypeRule__Group__0
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


    // $ANTLR start "entryRuleDataOrInstanceTypeRule"
    // InternalOptimisationLanguage.g:1030:1: entryRuleDataOrInstanceTypeRule : ruleDataOrInstanceTypeRule EOF ;
    public final void entryRuleDataOrInstanceTypeRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:1031:1: ( ruleDataOrInstanceTypeRule EOF )
            // InternalOptimisationLanguage.g:1032:1: ruleDataOrInstanceTypeRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataOrInstanceTypeRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleDataOrInstanceTypeRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataOrInstanceTypeRuleRule()); 
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
    // $ANTLR end "entryRuleDataOrInstanceTypeRule"


    // $ANTLR start "ruleDataOrInstanceTypeRule"
    // InternalOptimisationLanguage.g:1039:1: ruleDataOrInstanceTypeRule : ( ( rule__DataOrInstanceTypeRule__Group__0 ) ) ;
    public final void ruleDataOrInstanceTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1043:2: ( ( ( rule__DataOrInstanceTypeRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:1044:2: ( ( rule__DataOrInstanceTypeRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:1044:2: ( ( rule__DataOrInstanceTypeRule__Group__0 ) )
            // InternalOptimisationLanguage.g:1045:3: ( rule__DataOrInstanceTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataOrInstanceTypeRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:1046:3: ( rule__DataOrInstanceTypeRule__Group__0 )
            // InternalOptimisationLanguage.g:1046:4: rule__DataOrInstanceTypeRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DataOrInstanceTypeRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataOrInstanceTypeRuleAccess().getGroup()); 
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
    // $ANTLR end "ruleDataOrInstanceTypeRule"


    // $ANTLR start "entryRuleDataTypeRule"
    // InternalOptimisationLanguage.g:1055:1: entryRuleDataTypeRule : ruleDataTypeRule EOF ;
    public final void entryRuleDataTypeRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:1056:1: ( ruleDataTypeRule EOF )
            // InternalOptimisationLanguage.g:1057:1: ruleDataTypeRule EOF
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
    // InternalOptimisationLanguage.g:1064:1: ruleDataTypeRule : ( ( rule__DataTypeRule__Group__0 ) ) ;
    public final void ruleDataTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1068:2: ( ( ( rule__DataTypeRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:1069:2: ( ( rule__DataTypeRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:1069:2: ( ( rule__DataTypeRule__Group__0 ) )
            // InternalOptimisationLanguage.g:1070:3: ( rule__DataTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:1071:3: ( rule__DataTypeRule__Group__0 )
            // InternalOptimisationLanguage.g:1071:4: rule__DataTypeRule__Group__0
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


    // $ANTLR start "entryRuleArrayTypeRule"
    // InternalOptimisationLanguage.g:1080:1: entryRuleArrayTypeRule : ruleArrayTypeRule EOF ;
    public final void entryRuleArrayTypeRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:1081:1: ( ruleArrayTypeRule EOF )
            // InternalOptimisationLanguage.g:1082:1: ruleArrayTypeRule EOF
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
    // InternalOptimisationLanguage.g:1089:1: ruleArrayTypeRule : ( ( rule__ArrayTypeRule__Group__0 ) ) ;
    public final void ruleArrayTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1093:2: ( ( ( rule__ArrayTypeRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:1094:2: ( ( rule__ArrayTypeRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:1094:2: ( ( rule__ArrayTypeRule__Group__0 ) )
            // InternalOptimisationLanguage.g:1095:3: ( rule__ArrayTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayTypeRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:1096:3: ( rule__ArrayTypeRule__Group__0 )
            // InternalOptimisationLanguage.g:1096:4: rule__ArrayTypeRule__Group__0
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
    // InternalOptimisationLanguage.g:1105:1: entryRuleParameterRule : ruleParameterRule EOF ;
    public final void entryRuleParameterRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:1106:1: ( ruleParameterRule EOF )
            // InternalOptimisationLanguage.g:1107:1: ruleParameterRule EOF
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
    // InternalOptimisationLanguage.g:1114:1: ruleParameterRule : ( ( rule__ParameterRule__Group__0 ) ) ;
    public final void ruleParameterRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1118:2: ( ( ( rule__ParameterRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:1119:2: ( ( rule__ParameterRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:1119:2: ( ( rule__ParameterRule__Group__0 ) )
            // InternalOptimisationLanguage.g:1120:3: ( rule__ParameterRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:1121:3: ( rule__ParameterRule__Group__0 )
            // InternalOptimisationLanguage.g:1121:4: rule__ParameterRule__Group__0
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
    // InternalOptimisationLanguage.g:1130:1: entryRuleImportRule : ruleImportRule EOF ;
    public final void entryRuleImportRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:1131:1: ( ruleImportRule EOF )
            // InternalOptimisationLanguage.g:1132:1: ruleImportRule EOF
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
    // InternalOptimisationLanguage.g:1139:1: ruleImportRule : ( ( rule__ImportRule__Group__0 ) ) ;
    public final void ruleImportRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1143:2: ( ( ( rule__ImportRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:1144:2: ( ( rule__ImportRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:1144:2: ( ( rule__ImportRule__Group__0 ) )
            // InternalOptimisationLanguage.g:1145:3: ( rule__ImportRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:1146:3: ( rule__ImportRule__Group__0 )
            // InternalOptimisationLanguage.g:1146:4: rule__ImportRule__Group__0
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


    // $ANTLR start "entryRuleFunctionNameRule"
    // InternalOptimisationLanguage.g:1155:1: entryRuleFunctionNameRule : ruleFunctionNameRule EOF ;
    public final void entryRuleFunctionNameRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:1156:1: ( ruleFunctionNameRule EOF )
            // InternalOptimisationLanguage.g:1157:1: ruleFunctionNameRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionNameRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleFunctionNameRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunctionNameRuleRule()); 
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
    // $ANTLR end "entryRuleFunctionNameRule"


    // $ANTLR start "ruleFunctionNameRule"
    // InternalOptimisationLanguage.g:1164:1: ruleFunctionNameRule : ( ( rule__FunctionNameRule__DefinitionAssignment ) ) ;
    public final void ruleFunctionNameRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1168:2: ( ( ( rule__FunctionNameRule__DefinitionAssignment ) ) )
            // InternalOptimisationLanguage.g:1169:2: ( ( rule__FunctionNameRule__DefinitionAssignment ) )
            {
            // InternalOptimisationLanguage.g:1169:2: ( ( rule__FunctionNameRule__DefinitionAssignment ) )
            // InternalOptimisationLanguage.g:1170:3: ( rule__FunctionNameRule__DefinitionAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionNameRuleAccess().getDefinitionAssignment()); 
            }
            // InternalOptimisationLanguage.g:1171:3: ( rule__FunctionNameRule__DefinitionAssignment )
            // InternalOptimisationLanguage.g:1171:4: rule__FunctionNameRule__DefinitionAssignment
            {
            pushFollow(FOLLOW_2);
            rule__FunctionNameRule__DefinitionAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunctionNameRuleAccess().getDefinitionAssignment()); 
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
    // $ANTLR end "ruleFunctionNameRule"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalOptimisationLanguage.g:1180:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:1181:1: ( ruleQualifiedName EOF )
            // InternalOptimisationLanguage.g:1182:1: ruleQualifiedName EOF
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
    // InternalOptimisationLanguage.g:1189:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1193:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // InternalOptimisationLanguage.g:1194:2: ( ( rule__QualifiedName__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:1194:2: ( ( rule__QualifiedName__Group__0 ) )
            // InternalOptimisationLanguage.g:1195:3: ( rule__QualifiedName__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:1196:3: ( rule__QualifiedName__Group__0 )
            // InternalOptimisationLanguage.g:1196:4: rule__QualifiedName__Group__0
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
    // InternalOptimisationLanguage.g:1205:1: entryRuleStringOrId : ruleStringOrId EOF ;
    public final void entryRuleStringOrId() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:1206:1: ( ruleStringOrId EOF )
            // InternalOptimisationLanguage.g:1207:1: ruleStringOrId EOF
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
    // InternalOptimisationLanguage.g:1214:1: ruleStringOrId : ( ( rule__StringOrId__Alternatives ) ) ;
    public final void ruleStringOrId() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1218:2: ( ( ( rule__StringOrId__Alternatives ) ) )
            // InternalOptimisationLanguage.g:1219:2: ( ( rule__StringOrId__Alternatives ) )
            {
            // InternalOptimisationLanguage.g:1219:2: ( ( rule__StringOrId__Alternatives ) )
            // InternalOptimisationLanguage.g:1220:3: ( rule__StringOrId__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringOrIdAccess().getAlternatives()); 
            }
            // InternalOptimisationLanguage.g:1221:3: ( rule__StringOrId__Alternatives )
            // InternalOptimisationLanguage.g:1221:4: rule__StringOrId__Alternatives
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
    // InternalOptimisationLanguage.g:1230:1: ruleComparisonOperatorRule : ( ( rule__ComparisonOperatorRule__Alternatives ) ) ;
    public final void ruleComparisonOperatorRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1234:1: ( ( ( rule__ComparisonOperatorRule__Alternatives ) ) )
            // InternalOptimisationLanguage.g:1235:2: ( ( rule__ComparisonOperatorRule__Alternatives ) )
            {
            // InternalOptimisationLanguage.g:1235:2: ( ( rule__ComparisonOperatorRule__Alternatives ) )
            // InternalOptimisationLanguage.g:1236:3: ( rule__ComparisonOperatorRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonOperatorRuleAccess().getAlternatives()); 
            }
            // InternalOptimisationLanguage.g:1237:3: ( rule__ComparisonOperatorRule__Alternatives )
            // InternalOptimisationLanguage.g:1237:4: rule__ComparisonOperatorRule__Alternatives
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
    // InternalOptimisationLanguage.g:1246:1: ruleAddOrSubtractOperatorRule : ( ( rule__AddOrSubtractOperatorRule__Alternatives ) ) ;
    public final void ruleAddOrSubtractOperatorRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1250:1: ( ( ( rule__AddOrSubtractOperatorRule__Alternatives ) ) )
            // InternalOptimisationLanguage.g:1251:2: ( ( rule__AddOrSubtractOperatorRule__Alternatives ) )
            {
            // InternalOptimisationLanguage.g:1251:2: ( ( rule__AddOrSubtractOperatorRule__Alternatives ) )
            // InternalOptimisationLanguage.g:1252:3: ( rule__AddOrSubtractOperatorRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOrSubtractOperatorRuleAccess().getAlternatives()); 
            }
            // InternalOptimisationLanguage.g:1253:3: ( rule__AddOrSubtractOperatorRule__Alternatives )
            // InternalOptimisationLanguage.g:1253:4: rule__AddOrSubtractOperatorRule__Alternatives
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
    // InternalOptimisationLanguage.g:1262:1: ruleMultiplyDivideModuloOperatorRule : ( ( rule__MultiplyDivideModuloOperatorRule__Alternatives ) ) ;
    public final void ruleMultiplyDivideModuloOperatorRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1266:1: ( ( ( rule__MultiplyDivideModuloOperatorRule__Alternatives ) ) )
            // InternalOptimisationLanguage.g:1267:2: ( ( rule__MultiplyDivideModuloOperatorRule__Alternatives ) )
            {
            // InternalOptimisationLanguage.g:1267:2: ( ( rule__MultiplyDivideModuloOperatorRule__Alternatives ) )
            // InternalOptimisationLanguage.g:1268:3: ( rule__MultiplyDivideModuloOperatorRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getAlternatives()); 
            }
            // InternalOptimisationLanguage.g:1269:3: ( rule__MultiplyDivideModuloOperatorRule__Alternatives )
            // InternalOptimisationLanguage.g:1269:4: rule__MultiplyDivideModuloOperatorRule__Alternatives
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
    // InternalOptimisationLanguage.g:1278:1: ruleFactorRule : ( ( rule__FactorRule__Alternatives ) ) ;
    public final void ruleFactorRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1282:1: ( ( ( rule__FactorRule__Alternatives ) ) )
            // InternalOptimisationLanguage.g:1283:2: ( ( rule__FactorRule__Alternatives ) )
            {
            // InternalOptimisationLanguage.g:1283:2: ( ( rule__FactorRule__Alternatives ) )
            // InternalOptimisationLanguage.g:1284:3: ( rule__FactorRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFactorRuleAccess().getAlternatives()); 
            }
            // InternalOptimisationLanguage.g:1285:3: ( rule__FactorRule__Alternatives )
            // InternalOptimisationLanguage.g:1285:4: rule__FactorRule__Alternatives
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


    // $ANTLR start "rule__ReferenceRule__Alternatives"
    // InternalOptimisationLanguage.g:1293:1: rule__ReferenceRule__Alternatives : ( ( ruleConstantReferenceRule ) | ( ruleDataReferenceRule ) );
    public final void rule__ReferenceRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1297:1: ( ( ruleConstantReferenceRule ) | ( ruleDataReferenceRule ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( ((LA1_0>=RULE_QUOTED_ID && LA1_0<=RULE_ID)) ) {
                alt1=1;
            }
            else if ( (LA1_0==56) ) {
                alt1=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalOptimisationLanguage.g:1298:2: ( ruleConstantReferenceRule )
                    {
                    // InternalOptimisationLanguage.g:1298:2: ( ruleConstantReferenceRule )
                    // InternalOptimisationLanguage.g:1299:3: ruleConstantReferenceRule
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
                    // InternalOptimisationLanguage.g:1304:2: ( ruleDataReferenceRule )
                    {
                    // InternalOptimisationLanguage.g:1304:2: ( ruleDataReferenceRule )
                    // InternalOptimisationLanguage.g:1305:3: ruleDataReferenceRule
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


    // $ANTLR start "rule__ValueRule__Alternatives"
    // InternalOptimisationLanguage.g:1314:1: rule__ValueRule__Alternatives : ( ( ruleArrayRule ) | ( ruleCallRule ) | ( ruleLiteralRule ) | ( ruleParanthesesRule ) | ( ruleReferenceRule ) );
    public final void rule__ValueRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1318:1: ( ( ruleArrayRule ) | ( ruleCallRule ) | ( ruleLiteralRule ) | ( ruleParanthesesRule ) | ( ruleReferenceRule ) )
            int alt2=5;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // InternalOptimisationLanguage.g:1319:2: ( ruleArrayRule )
                    {
                    // InternalOptimisationLanguage.g:1319:2: ( ruleArrayRule )
                    // InternalOptimisationLanguage.g:1320:3: ruleArrayRule
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
                    // InternalOptimisationLanguage.g:1325:2: ( ruleCallRule )
                    {
                    // InternalOptimisationLanguage.g:1325:2: ( ruleCallRule )
                    // InternalOptimisationLanguage.g:1326:3: ruleCallRule
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
                    // InternalOptimisationLanguage.g:1331:2: ( ruleLiteralRule )
                    {
                    // InternalOptimisationLanguage.g:1331:2: ( ruleLiteralRule )
                    // InternalOptimisationLanguage.g:1332:3: ruleLiteralRule
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
                    // InternalOptimisationLanguage.g:1337:2: ( ruleParanthesesRule )
                    {
                    // InternalOptimisationLanguage.g:1337:2: ( ruleParanthesesRule )
                    // InternalOptimisationLanguage.g:1338:3: ruleParanthesesRule
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
                    // InternalOptimisationLanguage.g:1343:2: ( ruleReferenceRule )
                    {
                    // InternalOptimisationLanguage.g:1343:2: ( ruleReferenceRule )
                    // InternalOptimisationLanguage.g:1344:3: ruleReferenceRule
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


    // $ANTLR start "rule__LiteralRule__Alternatives"
    // InternalOptimisationLanguage.g:1353:1: rule__LiteralRule__Alternatives : ( ( ruleNumberLiteralRule ) | ( ruleStringLiteralRule ) | ( ruleBooleanLiteralRule ) | ( ruleInstanceLiteralRule ) );
    public final void rule__LiteralRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1357:1: ( ( ruleNumberLiteralRule ) | ( ruleStringLiteralRule ) | ( ruleBooleanLiteralRule ) | ( ruleInstanceLiteralRule ) )
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
            case 83:
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
                    // InternalOptimisationLanguage.g:1358:2: ( ruleNumberLiteralRule )
                    {
                    // InternalOptimisationLanguage.g:1358:2: ( ruleNumberLiteralRule )
                    // InternalOptimisationLanguage.g:1359:3: ruleNumberLiteralRule
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
                    // InternalOptimisationLanguage.g:1364:2: ( ruleStringLiteralRule )
                    {
                    // InternalOptimisationLanguage.g:1364:2: ( ruleStringLiteralRule )
                    // InternalOptimisationLanguage.g:1365:3: ruleStringLiteralRule
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
                    // InternalOptimisationLanguage.g:1370:2: ( ruleBooleanLiteralRule )
                    {
                    // InternalOptimisationLanguage.g:1370:2: ( ruleBooleanLiteralRule )
                    // InternalOptimisationLanguage.g:1371:3: ruleBooleanLiteralRule
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
                    // InternalOptimisationLanguage.g:1376:2: ( ruleInstanceLiteralRule )
                    {
                    // InternalOptimisationLanguage.g:1376:2: ( ruleInstanceLiteralRule )
                    // InternalOptimisationLanguage.g:1377:3: ruleInstanceLiteralRule
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
    // InternalOptimisationLanguage.g:1386:1: rule__NumberLiteralRule__Alternatives : ( ( ruleRealLiteralRule ) | ( ruleIntegerLiteralRule ) );
    public final void rule__NumberLiteralRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1390:1: ( ( ruleRealLiteralRule ) | ( ruleIntegerLiteralRule ) )
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
                    // InternalOptimisationLanguage.g:1391:2: ( ruleRealLiteralRule )
                    {
                    // InternalOptimisationLanguage.g:1391:2: ( ruleRealLiteralRule )
                    // InternalOptimisationLanguage.g:1392:3: ruleRealLiteralRule
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
                    // InternalOptimisationLanguage.g:1397:2: ( ruleIntegerLiteralRule )
                    {
                    // InternalOptimisationLanguage.g:1397:2: ( ruleIntegerLiteralRule )
                    // InternalOptimisationLanguage.g:1398:3: ruleIntegerLiteralRule
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
    // InternalOptimisationLanguage.g:1407:1: rule__BooleanLiteralRule__Alternatives_1 : ( ( ( rule__BooleanLiteralRule__ValueAssignment_1_0 ) ) | ( 'false' ) );
    public final void rule__BooleanLiteralRule__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1411:1: ( ( ( rule__BooleanLiteralRule__ValueAssignment_1_0 ) ) | ( 'false' ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==83) ) {
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
                    // InternalOptimisationLanguage.g:1412:2: ( ( rule__BooleanLiteralRule__ValueAssignment_1_0 ) )
                    {
                    // InternalOptimisationLanguage.g:1412:2: ( ( rule__BooleanLiteralRule__ValueAssignment_1_0 ) )
                    // InternalOptimisationLanguage.g:1413:3: ( rule__BooleanLiteralRule__ValueAssignment_1_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBooleanLiteralRuleAccess().getValueAssignment_1_0()); 
                    }
                    // InternalOptimisationLanguage.g:1414:3: ( rule__BooleanLiteralRule__ValueAssignment_1_0 )
                    // InternalOptimisationLanguage.g:1414:4: rule__BooleanLiteralRule__ValueAssignment_1_0
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
                    // InternalOptimisationLanguage.g:1418:2: ( 'false' )
                    {
                    // InternalOptimisationLanguage.g:1418:2: ( 'false' )
                    // InternalOptimisationLanguage.g:1419:3: 'false'
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
    // InternalOptimisationLanguage.g:1428:1: rule__TypeRule__Alternatives : ( ( ruleStringTypeRule ) | ( ruleIntTypeRule ) | ( ruleRealTypeRule ) | ( ruleBooleanTypeRule ) | ( ruleLiteralTypeRule ) | ( ruleArrayTypeRule ) | ( ruleInstanceTypeRule ) | ( ruleVoidTypeRule ) | ( ruleExpressionTypeRule ) | ( ruleDataTypeRule ) | ( ruleDataOrInstanceTypeRule ) );
    public final void rule__TypeRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1432:1: ( ( ruleStringTypeRule ) | ( ruleIntTypeRule ) | ( ruleRealTypeRule ) | ( ruleBooleanTypeRule ) | ( ruleLiteralTypeRule ) | ( ruleArrayTypeRule ) | ( ruleInstanceTypeRule ) | ( ruleVoidTypeRule ) | ( ruleExpressionTypeRule ) | ( ruleDataTypeRule ) | ( ruleDataOrInstanceTypeRule ) )
            int alt6=11;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // InternalOptimisationLanguage.g:1433:2: ( ruleStringTypeRule )
                    {
                    // InternalOptimisationLanguage.g:1433:2: ( ruleStringTypeRule )
                    // InternalOptimisationLanguage.g:1434:3: ruleStringTypeRule
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
                    // InternalOptimisationLanguage.g:1439:2: ( ruleIntTypeRule )
                    {
                    // InternalOptimisationLanguage.g:1439:2: ( ruleIntTypeRule )
                    // InternalOptimisationLanguage.g:1440:3: ruleIntTypeRule
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
                    // InternalOptimisationLanguage.g:1445:2: ( ruleRealTypeRule )
                    {
                    // InternalOptimisationLanguage.g:1445:2: ( ruleRealTypeRule )
                    // InternalOptimisationLanguage.g:1446:3: ruleRealTypeRule
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
                    // InternalOptimisationLanguage.g:1451:2: ( ruleBooleanTypeRule )
                    {
                    // InternalOptimisationLanguage.g:1451:2: ( ruleBooleanTypeRule )
                    // InternalOptimisationLanguage.g:1452:3: ruleBooleanTypeRule
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
                    // InternalOptimisationLanguage.g:1457:2: ( ruleLiteralTypeRule )
                    {
                    // InternalOptimisationLanguage.g:1457:2: ( ruleLiteralTypeRule )
                    // InternalOptimisationLanguage.g:1458:3: ruleLiteralTypeRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeRuleAccess().getLiteralTypeRuleParserRuleCall_4()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleLiteralTypeRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeRuleAccess().getLiteralTypeRuleParserRuleCall_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalOptimisationLanguage.g:1463:2: ( ruleArrayTypeRule )
                    {
                    // InternalOptimisationLanguage.g:1463:2: ( ruleArrayTypeRule )
                    // InternalOptimisationLanguage.g:1464:3: ruleArrayTypeRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeRuleAccess().getArrayTypeRuleParserRuleCall_5()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleArrayTypeRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeRuleAccess().getArrayTypeRuleParserRuleCall_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalOptimisationLanguage.g:1469:2: ( ruleInstanceTypeRule )
                    {
                    // InternalOptimisationLanguage.g:1469:2: ( ruleInstanceTypeRule )
                    // InternalOptimisationLanguage.g:1470:3: ruleInstanceTypeRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeRuleAccess().getInstanceTypeRuleParserRuleCall_6()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleInstanceTypeRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeRuleAccess().getInstanceTypeRuleParserRuleCall_6()); 
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalOptimisationLanguage.g:1475:2: ( ruleVoidTypeRule )
                    {
                    // InternalOptimisationLanguage.g:1475:2: ( ruleVoidTypeRule )
                    // InternalOptimisationLanguage.g:1476:3: ruleVoidTypeRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeRuleAccess().getVoidTypeRuleParserRuleCall_7()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleVoidTypeRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeRuleAccess().getVoidTypeRuleParserRuleCall_7()); 
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalOptimisationLanguage.g:1481:2: ( ruleExpressionTypeRule )
                    {
                    // InternalOptimisationLanguage.g:1481:2: ( ruleExpressionTypeRule )
                    // InternalOptimisationLanguage.g:1482:3: ruleExpressionTypeRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeRuleAccess().getExpressionTypeRuleParserRuleCall_8()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleExpressionTypeRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeRuleAccess().getExpressionTypeRuleParserRuleCall_8()); 
                    }

                    }


                    }
                    break;
                case 10 :
                    // InternalOptimisationLanguage.g:1487:2: ( ruleDataTypeRule )
                    {
                    // InternalOptimisationLanguage.g:1487:2: ( ruleDataTypeRule )
                    // InternalOptimisationLanguage.g:1488:3: ruleDataTypeRule
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
                case 11 :
                    // InternalOptimisationLanguage.g:1493:2: ( ruleDataOrInstanceTypeRule )
                    {
                    // InternalOptimisationLanguage.g:1493:2: ( ruleDataOrInstanceTypeRule )
                    // InternalOptimisationLanguage.g:1494:3: ruleDataOrInstanceTypeRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeRuleAccess().getDataOrInstanceTypeRuleParserRuleCall_10()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleDataOrInstanceTypeRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeRuleAccess().getDataOrInstanceTypeRuleParserRuleCall_10()); 
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
    // InternalOptimisationLanguage.g:1503:1: rule__StringOrId__Alternatives : ( ( RULE_QUOTED_ID ) | ( RULE_ID ) );
    public final void rule__StringOrId__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1507:1: ( ( RULE_QUOTED_ID ) | ( RULE_ID ) )
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
                    // InternalOptimisationLanguage.g:1508:2: ( RULE_QUOTED_ID )
                    {
                    // InternalOptimisationLanguage.g:1508:2: ( RULE_QUOTED_ID )
                    // InternalOptimisationLanguage.g:1509:3: RULE_QUOTED_ID
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
                    // InternalOptimisationLanguage.g:1514:2: ( RULE_ID )
                    {
                    // InternalOptimisationLanguage.g:1514:2: ( RULE_ID )
                    // InternalOptimisationLanguage.g:1515:3: RULE_ID
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
    // InternalOptimisationLanguage.g:1524:1: rule__ComparisonOperatorRule__Alternatives : ( ( ( '>=' ) ) | ( ( '>' ) ) | ( ( '=' ) ) | ( ( '!=' ) ) | ( ( '<' ) ) | ( ( '<=' ) ) );
    public final void rule__ComparisonOperatorRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1528:1: ( ( ( '>=' ) ) | ( ( '>' ) ) | ( ( '=' ) ) | ( ( '!=' ) ) | ( ( '<' ) ) | ( ( '<=' ) ) )
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
                    // InternalOptimisationLanguage.g:1529:2: ( ( '>=' ) )
                    {
                    // InternalOptimisationLanguage.g:1529:2: ( ( '>=' ) )
                    // InternalOptimisationLanguage.g:1530:3: ( '>=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getGreaterThanEnumLiteralDeclaration_0()); 
                    }
                    // InternalOptimisationLanguage.g:1531:3: ( '>=' )
                    // InternalOptimisationLanguage.g:1531:4: '>='
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
                    // InternalOptimisationLanguage.g:1535:2: ( ( '>' ) )
                    {
                    // InternalOptimisationLanguage.g:1535:2: ( ( '>' ) )
                    // InternalOptimisationLanguage.g:1536:3: ( '>' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getGreaterEqualEnumLiteralDeclaration_1()); 
                    }
                    // InternalOptimisationLanguage.g:1537:3: ( '>' )
                    // InternalOptimisationLanguage.g:1537:4: '>'
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
                    // InternalOptimisationLanguage.g:1541:2: ( ( '=' ) )
                    {
                    // InternalOptimisationLanguage.g:1541:2: ( ( '=' ) )
                    // InternalOptimisationLanguage.g:1542:3: ( '=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getEqualEnumLiteralDeclaration_2()); 
                    }
                    // InternalOptimisationLanguage.g:1543:3: ( '=' )
                    // InternalOptimisationLanguage.g:1543:4: '='
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
                    // InternalOptimisationLanguage.g:1547:2: ( ( '!=' ) )
                    {
                    // InternalOptimisationLanguage.g:1547:2: ( ( '!=' ) )
                    // InternalOptimisationLanguage.g:1548:3: ( '!=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getUnequalEnumLiteralDeclaration_3()); 
                    }
                    // InternalOptimisationLanguage.g:1549:3: ( '!=' )
                    // InternalOptimisationLanguage.g:1549:4: '!='
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
                    // InternalOptimisationLanguage.g:1553:2: ( ( '<' ) )
                    {
                    // InternalOptimisationLanguage.g:1553:2: ( ( '<' ) )
                    // InternalOptimisationLanguage.g:1554:3: ( '<' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getLessEqualEnumLiteralDeclaration_4()); 
                    }
                    // InternalOptimisationLanguage.g:1555:3: ( '<' )
                    // InternalOptimisationLanguage.g:1555:4: '<'
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
                    // InternalOptimisationLanguage.g:1559:2: ( ( '<=' ) )
                    {
                    // InternalOptimisationLanguage.g:1559:2: ( ( '<=' ) )
                    // InternalOptimisationLanguage.g:1560:3: ( '<=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getLessThanEnumLiteralDeclaration_5()); 
                    }
                    // InternalOptimisationLanguage.g:1561:3: ( '<=' )
                    // InternalOptimisationLanguage.g:1561:4: '<='
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
    // InternalOptimisationLanguage.g:1569:1: rule__AddOrSubtractOperatorRule__Alternatives : ( ( ( '+' ) ) | ( ( '-' ) ) );
    public final void rule__AddOrSubtractOperatorRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1573:1: ( ( ( '+' ) ) | ( ( '-' ) ) )
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
                    // InternalOptimisationLanguage.g:1574:2: ( ( '+' ) )
                    {
                    // InternalOptimisationLanguage.g:1574:2: ( ( '+' ) )
                    // InternalOptimisationLanguage.g:1575:3: ( '+' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAddOrSubtractOperatorRuleAccess().getAddEnumLiteralDeclaration_0()); 
                    }
                    // InternalOptimisationLanguage.g:1576:3: ( '+' )
                    // InternalOptimisationLanguage.g:1576:4: '+'
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
                    // InternalOptimisationLanguage.g:1580:2: ( ( '-' ) )
                    {
                    // InternalOptimisationLanguage.g:1580:2: ( ( '-' ) )
                    // InternalOptimisationLanguage.g:1581:3: ( '-' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAddOrSubtractOperatorRuleAccess().getSubtractEnumLiteralDeclaration_1()); 
                    }
                    // InternalOptimisationLanguage.g:1582:3: ( '-' )
                    // InternalOptimisationLanguage.g:1582:4: '-'
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
    // InternalOptimisationLanguage.g:1590:1: rule__MultiplyDivideModuloOperatorRule__Alternatives : ( ( ( '*' ) ) | ( ( '/' ) ) | ( ( '%' ) ) );
    public final void rule__MultiplyDivideModuloOperatorRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1594:1: ( ( ( '*' ) ) | ( ( '/' ) ) | ( ( '%' ) ) )
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
                    // InternalOptimisationLanguage.g:1595:2: ( ( '*' ) )
                    {
                    // InternalOptimisationLanguage.g:1595:2: ( ( '*' ) )
                    // InternalOptimisationLanguage.g:1596:3: ( '*' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getMultiplyEnumLiteralDeclaration_0()); 
                    }
                    // InternalOptimisationLanguage.g:1597:3: ( '*' )
                    // InternalOptimisationLanguage.g:1597:4: '*'
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
                    // InternalOptimisationLanguage.g:1601:2: ( ( '/' ) )
                    {
                    // InternalOptimisationLanguage.g:1601:2: ( ( '/' ) )
                    // InternalOptimisationLanguage.g:1602:3: ( '/' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getDivideEnumLiteralDeclaration_1()); 
                    }
                    // InternalOptimisationLanguage.g:1603:3: ( '/' )
                    // InternalOptimisationLanguage.g:1603:4: '/'
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
                    // InternalOptimisationLanguage.g:1607:2: ( ( '%' ) )
                    {
                    // InternalOptimisationLanguage.g:1607:2: ( ( '%' ) )
                    // InternalOptimisationLanguage.g:1608:3: ( '%' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getModuloEnumLiteralDeclaration_2()); 
                    }
                    // InternalOptimisationLanguage.g:1609:3: ( '%' )
                    // InternalOptimisationLanguage.g:1609:4: '%'
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
    // InternalOptimisationLanguage.g:1617:1: rule__FactorRule__Alternatives : ( ( ( 'Y' ) ) | ( ( 'Z' ) ) | ( ( 'E' ) ) | ( ( 'P' ) ) | ( ( 'T' ) ) | ( ( 'G' ) ) | ( ( 'M' ) ) | ( ( 'k' ) ) | ( ( 'h' ) ) | ( ( 'da' ) ) | ( ( 'd' ) ) | ( ( 'c' ) ) | ( ( 'm' ) ) | ( ( '\\u00B5' ) ) | ( ( 'n' ) ) | ( ( 'p' ) ) | ( ( 'f' ) ) | ( ( 'a' ) ) | ( ( 'z' ) ) | ( ( 'y' ) ) );
    public final void rule__FactorRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1621:1: ( ( ( 'Y' ) ) | ( ( 'Z' ) ) | ( ( 'E' ) ) | ( ( 'P' ) ) | ( ( 'T' ) ) | ( ( 'G' ) ) | ( ( 'M' ) ) | ( ( 'k' ) ) | ( ( 'h' ) ) | ( ( 'da' ) ) | ( ( 'd' ) ) | ( ( 'c' ) ) | ( ( 'm' ) ) | ( ( '\\u00B5' ) ) | ( ( 'n' ) ) | ( ( 'p' ) ) | ( ( 'f' ) ) | ( ( 'a' ) ) | ( ( 'z' ) ) | ( ( 'y' ) ) )
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
                    // InternalOptimisationLanguage.g:1622:2: ( ( 'Y' ) )
                    {
                    // InternalOptimisationLanguage.g:1622:2: ( ( 'Y' ) )
                    // InternalOptimisationLanguage.g:1623:3: ( 'Y' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getYottaEnumLiteralDeclaration_0()); 
                    }
                    // InternalOptimisationLanguage.g:1624:3: ( 'Y' )
                    // InternalOptimisationLanguage.g:1624:4: 'Y'
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
                    // InternalOptimisationLanguage.g:1628:2: ( ( 'Z' ) )
                    {
                    // InternalOptimisationLanguage.g:1628:2: ( ( 'Z' ) )
                    // InternalOptimisationLanguage.g:1629:3: ( 'Z' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getZettaEnumLiteralDeclaration_1()); 
                    }
                    // InternalOptimisationLanguage.g:1630:3: ( 'Z' )
                    // InternalOptimisationLanguage.g:1630:4: 'Z'
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
                    // InternalOptimisationLanguage.g:1634:2: ( ( 'E' ) )
                    {
                    // InternalOptimisationLanguage.g:1634:2: ( ( 'E' ) )
                    // InternalOptimisationLanguage.g:1635:3: ( 'E' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getExaEnumLiteralDeclaration_2()); 
                    }
                    // InternalOptimisationLanguage.g:1636:3: ( 'E' )
                    // InternalOptimisationLanguage.g:1636:4: 'E'
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
                    // InternalOptimisationLanguage.g:1640:2: ( ( 'P' ) )
                    {
                    // InternalOptimisationLanguage.g:1640:2: ( ( 'P' ) )
                    // InternalOptimisationLanguage.g:1641:3: ( 'P' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getPetaEnumLiteralDeclaration_3()); 
                    }
                    // InternalOptimisationLanguage.g:1642:3: ( 'P' )
                    // InternalOptimisationLanguage.g:1642:4: 'P'
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
                    // InternalOptimisationLanguage.g:1646:2: ( ( 'T' ) )
                    {
                    // InternalOptimisationLanguage.g:1646:2: ( ( 'T' ) )
                    // InternalOptimisationLanguage.g:1647:3: ( 'T' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getTeraEnumLiteralDeclaration_4()); 
                    }
                    // InternalOptimisationLanguage.g:1648:3: ( 'T' )
                    // InternalOptimisationLanguage.g:1648:4: 'T'
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
                    // InternalOptimisationLanguage.g:1652:2: ( ( 'G' ) )
                    {
                    // InternalOptimisationLanguage.g:1652:2: ( ( 'G' ) )
                    // InternalOptimisationLanguage.g:1653:3: ( 'G' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getGigaEnumLiteralDeclaration_5()); 
                    }
                    // InternalOptimisationLanguage.g:1654:3: ( 'G' )
                    // InternalOptimisationLanguage.g:1654:4: 'G'
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
                    // InternalOptimisationLanguage.g:1658:2: ( ( 'M' ) )
                    {
                    // InternalOptimisationLanguage.g:1658:2: ( ( 'M' ) )
                    // InternalOptimisationLanguage.g:1659:3: ( 'M' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getMegaEnumLiteralDeclaration_6()); 
                    }
                    // InternalOptimisationLanguage.g:1660:3: ( 'M' )
                    // InternalOptimisationLanguage.g:1660:4: 'M'
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
                    // InternalOptimisationLanguage.g:1664:2: ( ( 'k' ) )
                    {
                    // InternalOptimisationLanguage.g:1664:2: ( ( 'k' ) )
                    // InternalOptimisationLanguage.g:1665:3: ( 'k' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getKiloEnumLiteralDeclaration_7()); 
                    }
                    // InternalOptimisationLanguage.g:1666:3: ( 'k' )
                    // InternalOptimisationLanguage.g:1666:4: 'k'
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
                    // InternalOptimisationLanguage.g:1670:2: ( ( 'h' ) )
                    {
                    // InternalOptimisationLanguage.g:1670:2: ( ( 'h' ) )
                    // InternalOptimisationLanguage.g:1671:3: ( 'h' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getHectoEnumLiteralDeclaration_8()); 
                    }
                    // InternalOptimisationLanguage.g:1672:3: ( 'h' )
                    // InternalOptimisationLanguage.g:1672:4: 'h'
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
                    // InternalOptimisationLanguage.g:1676:2: ( ( 'da' ) )
                    {
                    // InternalOptimisationLanguage.g:1676:2: ( ( 'da' ) )
                    // InternalOptimisationLanguage.g:1677:3: ( 'da' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getDekaEnumLiteralDeclaration_9()); 
                    }
                    // InternalOptimisationLanguage.g:1678:3: ( 'da' )
                    // InternalOptimisationLanguage.g:1678:4: 'da'
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
                    // InternalOptimisationLanguage.g:1682:2: ( ( 'd' ) )
                    {
                    // InternalOptimisationLanguage.g:1682:2: ( ( 'd' ) )
                    // InternalOptimisationLanguage.g:1683:3: ( 'd' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getDeciEnumLiteralDeclaration_10()); 
                    }
                    // InternalOptimisationLanguage.g:1684:3: ( 'd' )
                    // InternalOptimisationLanguage.g:1684:4: 'd'
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
                    // InternalOptimisationLanguage.g:1688:2: ( ( 'c' ) )
                    {
                    // InternalOptimisationLanguage.g:1688:2: ( ( 'c' ) )
                    // InternalOptimisationLanguage.g:1689:3: ( 'c' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getCentiEnumLiteralDeclaration_11()); 
                    }
                    // InternalOptimisationLanguage.g:1690:3: ( 'c' )
                    // InternalOptimisationLanguage.g:1690:4: 'c'
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
                    // InternalOptimisationLanguage.g:1694:2: ( ( 'm' ) )
                    {
                    // InternalOptimisationLanguage.g:1694:2: ( ( 'm' ) )
                    // InternalOptimisationLanguage.g:1695:3: ( 'm' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getMilliEnumLiteralDeclaration_12()); 
                    }
                    // InternalOptimisationLanguage.g:1696:3: ( 'm' )
                    // InternalOptimisationLanguage.g:1696:4: 'm'
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
                    // InternalOptimisationLanguage.g:1700:2: ( ( '\\u00B5' ) )
                    {
                    // InternalOptimisationLanguage.g:1700:2: ( ( '\\u00B5' ) )
                    // InternalOptimisationLanguage.g:1701:3: ( '\\u00B5' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getMicroEnumLiteralDeclaration_13()); 
                    }
                    // InternalOptimisationLanguage.g:1702:3: ( '\\u00B5' )
                    // InternalOptimisationLanguage.g:1702:4: '\\u00B5'
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
                    // InternalOptimisationLanguage.g:1706:2: ( ( 'n' ) )
                    {
                    // InternalOptimisationLanguage.g:1706:2: ( ( 'n' ) )
                    // InternalOptimisationLanguage.g:1707:3: ( 'n' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getNanoEnumLiteralDeclaration_14()); 
                    }
                    // InternalOptimisationLanguage.g:1708:3: ( 'n' )
                    // InternalOptimisationLanguage.g:1708:4: 'n'
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
                    // InternalOptimisationLanguage.g:1712:2: ( ( 'p' ) )
                    {
                    // InternalOptimisationLanguage.g:1712:2: ( ( 'p' ) )
                    // InternalOptimisationLanguage.g:1713:3: ( 'p' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getPikoEnumLiteralDeclaration_15()); 
                    }
                    // InternalOptimisationLanguage.g:1714:3: ( 'p' )
                    // InternalOptimisationLanguage.g:1714:4: 'p'
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
                    // InternalOptimisationLanguage.g:1718:2: ( ( 'f' ) )
                    {
                    // InternalOptimisationLanguage.g:1718:2: ( ( 'f' ) )
                    // InternalOptimisationLanguage.g:1719:3: ( 'f' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getFemtoEnumLiteralDeclaration_16()); 
                    }
                    // InternalOptimisationLanguage.g:1720:3: ( 'f' )
                    // InternalOptimisationLanguage.g:1720:4: 'f'
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
                    // InternalOptimisationLanguage.g:1724:2: ( ( 'a' ) )
                    {
                    // InternalOptimisationLanguage.g:1724:2: ( ( 'a' ) )
                    // InternalOptimisationLanguage.g:1725:3: ( 'a' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getAttoEnumLiteralDeclaration_17()); 
                    }
                    // InternalOptimisationLanguage.g:1726:3: ( 'a' )
                    // InternalOptimisationLanguage.g:1726:4: 'a'
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
                    // InternalOptimisationLanguage.g:1730:2: ( ( 'z' ) )
                    {
                    // InternalOptimisationLanguage.g:1730:2: ( ( 'z' ) )
                    // InternalOptimisationLanguage.g:1731:3: ( 'z' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getZeptoEnumLiteralDeclaration_18()); 
                    }
                    // InternalOptimisationLanguage.g:1732:3: ( 'z' )
                    // InternalOptimisationLanguage.g:1732:4: 'z'
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
                    // InternalOptimisationLanguage.g:1736:2: ( ( 'y' ) )
                    {
                    // InternalOptimisationLanguage.g:1736:2: ( ( 'y' ) )
                    // InternalOptimisationLanguage.g:1737:3: ( 'y' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getYoctoEnumLiteralDeclaration_19()); 
                    }
                    // InternalOptimisationLanguage.g:1738:3: ( 'y' )
                    // InternalOptimisationLanguage.g:1738:4: 'y'
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


    // $ANTLR start "rule__OptimisationModelRule__Group__0"
    // InternalOptimisationLanguage.g:1746:1: rule__OptimisationModelRule__Group__0 : rule__OptimisationModelRule__Group__0__Impl rule__OptimisationModelRule__Group__1 ;
    public final void rule__OptimisationModelRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1750:1: ( rule__OptimisationModelRule__Group__0__Impl rule__OptimisationModelRule__Group__1 )
            // InternalOptimisationLanguage.g:1751:2: rule__OptimisationModelRule__Group__0__Impl rule__OptimisationModelRule__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__OptimisationModelRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__OptimisationModelRule__Group__1();

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
    // $ANTLR end "rule__OptimisationModelRule__Group__0"


    // $ANTLR start "rule__OptimisationModelRule__Group__0__Impl"
    // InternalOptimisationLanguage.g:1758:1: rule__OptimisationModelRule__Group__0__Impl : ( ( rule__OptimisationModelRule__ImportsAssignment_0 )* ) ;
    public final void rule__OptimisationModelRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1762:1: ( ( ( rule__OptimisationModelRule__ImportsAssignment_0 )* ) )
            // InternalOptimisationLanguage.g:1763:1: ( ( rule__OptimisationModelRule__ImportsAssignment_0 )* )
            {
            // InternalOptimisationLanguage.g:1763:1: ( ( rule__OptimisationModelRule__ImportsAssignment_0 )* )
            // InternalOptimisationLanguage.g:1764:2: ( rule__OptimisationModelRule__ImportsAssignment_0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOptimisationModelRuleAccess().getImportsAssignment_0()); 
            }
            // InternalOptimisationLanguage.g:1765:2: ( rule__OptimisationModelRule__ImportsAssignment_0 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==79) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:1765:3: rule__OptimisationModelRule__ImportsAssignment_0
            	    {
            	    pushFollow(FOLLOW_4);
            	    rule__OptimisationModelRule__ImportsAssignment_0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOptimisationModelRuleAccess().getImportsAssignment_0()); 
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
    // $ANTLR end "rule__OptimisationModelRule__Group__0__Impl"


    // $ANTLR start "rule__OptimisationModelRule__Group__1"
    // InternalOptimisationLanguage.g:1773:1: rule__OptimisationModelRule__Group__1 : rule__OptimisationModelRule__Group__1__Impl rule__OptimisationModelRule__Group__2 ;
    public final void rule__OptimisationModelRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1777:1: ( rule__OptimisationModelRule__Group__1__Impl rule__OptimisationModelRule__Group__2 )
            // InternalOptimisationLanguage.g:1778:2: rule__OptimisationModelRule__Group__1__Impl rule__OptimisationModelRule__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__OptimisationModelRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__OptimisationModelRule__Group__2();

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
    // $ANTLR end "rule__OptimisationModelRule__Group__1"


    // $ANTLR start "rule__OptimisationModelRule__Group__1__Impl"
    // InternalOptimisationLanguage.g:1785:1: rule__OptimisationModelRule__Group__1__Impl : ( 'module' ) ;
    public final void rule__OptimisationModelRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1789:1: ( ( 'module' ) )
            // InternalOptimisationLanguage.g:1790:1: ( 'module' )
            {
            // InternalOptimisationLanguage.g:1790:1: ( 'module' )
            // InternalOptimisationLanguage.g:1791:2: 'module'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOptimisationModelRuleAccess().getModuleKeyword_1()); 
            }
            match(input,47,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOptimisationModelRuleAccess().getModuleKeyword_1()); 
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
    // $ANTLR end "rule__OptimisationModelRule__Group__1__Impl"


    // $ANTLR start "rule__OptimisationModelRule__Group__2"
    // InternalOptimisationLanguage.g:1800:1: rule__OptimisationModelRule__Group__2 : rule__OptimisationModelRule__Group__2__Impl rule__OptimisationModelRule__Group__3 ;
    public final void rule__OptimisationModelRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1804:1: ( rule__OptimisationModelRule__Group__2__Impl rule__OptimisationModelRule__Group__3 )
            // InternalOptimisationLanguage.g:1805:2: rule__OptimisationModelRule__Group__2__Impl rule__OptimisationModelRule__Group__3
            {
            pushFollow(FOLLOW_6);
            rule__OptimisationModelRule__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__OptimisationModelRule__Group__3();

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
    // $ANTLR end "rule__OptimisationModelRule__Group__2"


    // $ANTLR start "rule__OptimisationModelRule__Group__2__Impl"
    // InternalOptimisationLanguage.g:1812:1: rule__OptimisationModelRule__Group__2__Impl : ( ( rule__OptimisationModelRule__NameAssignment_2 ) ) ;
    public final void rule__OptimisationModelRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1816:1: ( ( ( rule__OptimisationModelRule__NameAssignment_2 ) ) )
            // InternalOptimisationLanguage.g:1817:1: ( ( rule__OptimisationModelRule__NameAssignment_2 ) )
            {
            // InternalOptimisationLanguage.g:1817:1: ( ( rule__OptimisationModelRule__NameAssignment_2 ) )
            // InternalOptimisationLanguage.g:1818:2: ( rule__OptimisationModelRule__NameAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOptimisationModelRuleAccess().getNameAssignment_2()); 
            }
            // InternalOptimisationLanguage.g:1819:2: ( rule__OptimisationModelRule__NameAssignment_2 )
            // InternalOptimisationLanguage.g:1819:3: rule__OptimisationModelRule__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__OptimisationModelRule__NameAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOptimisationModelRuleAccess().getNameAssignment_2()); 
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
    // $ANTLR end "rule__OptimisationModelRule__Group__2__Impl"


    // $ANTLR start "rule__OptimisationModelRule__Group__3"
    // InternalOptimisationLanguage.g:1827:1: rule__OptimisationModelRule__Group__3 : rule__OptimisationModelRule__Group__3__Impl rule__OptimisationModelRule__Group__4 ;
    public final void rule__OptimisationModelRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1831:1: ( rule__OptimisationModelRule__Group__3__Impl rule__OptimisationModelRule__Group__4 )
            // InternalOptimisationLanguage.g:1832:2: rule__OptimisationModelRule__Group__3__Impl rule__OptimisationModelRule__Group__4
            {
            pushFollow(FOLLOW_7);
            rule__OptimisationModelRule__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__OptimisationModelRule__Group__4();

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
    // $ANTLR end "rule__OptimisationModelRule__Group__3"


    // $ANTLR start "rule__OptimisationModelRule__Group__3__Impl"
    // InternalOptimisationLanguage.g:1839:1: rule__OptimisationModelRule__Group__3__Impl : ( '{' ) ;
    public final void rule__OptimisationModelRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1843:1: ( ( '{' ) )
            // InternalOptimisationLanguage.g:1844:1: ( '{' )
            {
            // InternalOptimisationLanguage.g:1844:1: ( '{' )
            // InternalOptimisationLanguage.g:1845:2: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOptimisationModelRuleAccess().getLeftCurlyBracketKeyword_3()); 
            }
            match(input,48,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOptimisationModelRuleAccess().getLeftCurlyBracketKeyword_3()); 
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
    // $ANTLR end "rule__OptimisationModelRule__Group__3__Impl"


    // $ANTLR start "rule__OptimisationModelRule__Group__4"
    // InternalOptimisationLanguage.g:1854:1: rule__OptimisationModelRule__Group__4 : rule__OptimisationModelRule__Group__4__Impl rule__OptimisationModelRule__Group__5 ;
    public final void rule__OptimisationModelRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1858:1: ( rule__OptimisationModelRule__Group__4__Impl rule__OptimisationModelRule__Group__5 )
            // InternalOptimisationLanguage.g:1859:2: rule__OptimisationModelRule__Group__4__Impl rule__OptimisationModelRule__Group__5
            {
            pushFollow(FOLLOW_7);
            rule__OptimisationModelRule__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__OptimisationModelRule__Group__5();

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
    // $ANTLR end "rule__OptimisationModelRule__Group__4"


    // $ANTLR start "rule__OptimisationModelRule__Group__4__Impl"
    // InternalOptimisationLanguage.g:1866:1: rule__OptimisationModelRule__Group__4__Impl : ( ( rule__OptimisationModelRule__ProblemAssignment_4 )? ) ;
    public final void rule__OptimisationModelRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1870:1: ( ( ( rule__OptimisationModelRule__ProblemAssignment_4 )? ) )
            // InternalOptimisationLanguage.g:1871:1: ( ( rule__OptimisationModelRule__ProblemAssignment_4 )? )
            {
            // InternalOptimisationLanguage.g:1871:1: ( ( rule__OptimisationModelRule__ProblemAssignment_4 )? )
            // InternalOptimisationLanguage.g:1872:2: ( rule__OptimisationModelRule__ProblemAssignment_4 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOptimisationModelRuleAccess().getProblemAssignment_4()); 
            }
            // InternalOptimisationLanguage.g:1873:2: ( rule__OptimisationModelRule__ProblemAssignment_4 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==50) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalOptimisationLanguage.g:1873:3: rule__OptimisationModelRule__ProblemAssignment_4
                    {
                    pushFollow(FOLLOW_2);
                    rule__OptimisationModelRule__ProblemAssignment_4();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOptimisationModelRuleAccess().getProblemAssignment_4()); 
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
    // $ANTLR end "rule__OptimisationModelRule__Group__4__Impl"


    // $ANTLR start "rule__OptimisationModelRule__Group__5"
    // InternalOptimisationLanguage.g:1881:1: rule__OptimisationModelRule__Group__5 : rule__OptimisationModelRule__Group__5__Impl rule__OptimisationModelRule__Group__6 ;
    public final void rule__OptimisationModelRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1885:1: ( rule__OptimisationModelRule__Group__5__Impl rule__OptimisationModelRule__Group__6 )
            // InternalOptimisationLanguage.g:1886:2: rule__OptimisationModelRule__Group__5__Impl rule__OptimisationModelRule__Group__6
            {
            pushFollow(FOLLOW_7);
            rule__OptimisationModelRule__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__OptimisationModelRule__Group__6();

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
    // $ANTLR end "rule__OptimisationModelRule__Group__5"


    // $ANTLR start "rule__OptimisationModelRule__Group__5__Impl"
    // InternalOptimisationLanguage.g:1893:1: rule__OptimisationModelRule__Group__5__Impl : ( ( rule__OptimisationModelRule__AlgorithmAssignment_5 )? ) ;
    public final void rule__OptimisationModelRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1897:1: ( ( ( rule__OptimisationModelRule__AlgorithmAssignment_5 )? ) )
            // InternalOptimisationLanguage.g:1898:1: ( ( rule__OptimisationModelRule__AlgorithmAssignment_5 )? )
            {
            // InternalOptimisationLanguage.g:1898:1: ( ( rule__OptimisationModelRule__AlgorithmAssignment_5 )? )
            // InternalOptimisationLanguage.g:1899:2: ( rule__OptimisationModelRule__AlgorithmAssignment_5 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOptimisationModelRuleAccess().getAlgorithmAssignment_5()); 
            }
            // InternalOptimisationLanguage.g:1900:2: ( rule__OptimisationModelRule__AlgorithmAssignment_5 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==54) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalOptimisationLanguage.g:1900:3: rule__OptimisationModelRule__AlgorithmAssignment_5
                    {
                    pushFollow(FOLLOW_2);
                    rule__OptimisationModelRule__AlgorithmAssignment_5();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOptimisationModelRuleAccess().getAlgorithmAssignment_5()); 
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
    // $ANTLR end "rule__OptimisationModelRule__Group__5__Impl"


    // $ANTLR start "rule__OptimisationModelRule__Group__6"
    // InternalOptimisationLanguage.g:1908:1: rule__OptimisationModelRule__Group__6 : rule__OptimisationModelRule__Group__6__Impl ;
    public final void rule__OptimisationModelRule__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1912:1: ( rule__OptimisationModelRule__Group__6__Impl )
            // InternalOptimisationLanguage.g:1913:2: rule__OptimisationModelRule__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OptimisationModelRule__Group__6__Impl();

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
    // $ANTLR end "rule__OptimisationModelRule__Group__6"


    // $ANTLR start "rule__OptimisationModelRule__Group__6__Impl"
    // InternalOptimisationLanguage.g:1919:1: rule__OptimisationModelRule__Group__6__Impl : ( '}' ) ;
    public final void rule__OptimisationModelRule__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1923:1: ( ( '}' ) )
            // InternalOptimisationLanguage.g:1924:1: ( '}' )
            {
            // InternalOptimisationLanguage.g:1924:1: ( '}' )
            // InternalOptimisationLanguage.g:1925:2: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOptimisationModelRuleAccess().getRightCurlyBracketKeyword_6()); 
            }
            match(input,49,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOptimisationModelRuleAccess().getRightCurlyBracketKeyword_6()); 
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
    // $ANTLR end "rule__OptimisationModelRule__Group__6__Impl"


    // $ANTLR start "rule__ProblemRule__Group__0"
    // InternalOptimisationLanguage.g:1935:1: rule__ProblemRule__Group__0 : rule__ProblemRule__Group__0__Impl rule__ProblemRule__Group__1 ;
    public final void rule__ProblemRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1939:1: ( rule__ProblemRule__Group__0__Impl rule__ProblemRule__Group__1 )
            // InternalOptimisationLanguage.g:1940:2: rule__ProblemRule__Group__0__Impl rule__ProblemRule__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__ProblemRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ProblemRule__Group__1();

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
    // $ANTLR end "rule__ProblemRule__Group__0"


    // $ANTLR start "rule__ProblemRule__Group__0__Impl"
    // InternalOptimisationLanguage.g:1947:1: rule__ProblemRule__Group__0__Impl : ( 'specify' ) ;
    public final void rule__ProblemRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1951:1: ( ( 'specify' ) )
            // InternalOptimisationLanguage.g:1952:1: ( 'specify' )
            {
            // InternalOptimisationLanguage.g:1952:1: ( 'specify' )
            // InternalOptimisationLanguage.g:1953:2: 'specify'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProblemRuleAccess().getSpecifyKeyword_0()); 
            }
            match(input,50,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getProblemRuleAccess().getSpecifyKeyword_0()); 
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
    // $ANTLR end "rule__ProblemRule__Group__0__Impl"


    // $ANTLR start "rule__ProblemRule__Group__1"
    // InternalOptimisationLanguage.g:1962:1: rule__ProblemRule__Group__1 : rule__ProblemRule__Group__1__Impl rule__ProblemRule__Group__2 ;
    public final void rule__ProblemRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1966:1: ( rule__ProblemRule__Group__1__Impl rule__ProblemRule__Group__2 )
            // InternalOptimisationLanguage.g:1967:2: rule__ProblemRule__Group__1__Impl rule__ProblemRule__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__ProblemRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ProblemRule__Group__2();

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
    // $ANTLR end "rule__ProblemRule__Group__1"


    // $ANTLR start "rule__ProblemRule__Group__1__Impl"
    // InternalOptimisationLanguage.g:1974:1: rule__ProblemRule__Group__1__Impl : ( ( rule__ProblemRule__DefinitionAssignment_1 ) ) ;
    public final void rule__ProblemRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1978:1: ( ( ( rule__ProblemRule__DefinitionAssignment_1 ) ) )
            // InternalOptimisationLanguage.g:1979:1: ( ( rule__ProblemRule__DefinitionAssignment_1 ) )
            {
            // InternalOptimisationLanguage.g:1979:1: ( ( rule__ProblemRule__DefinitionAssignment_1 ) )
            // InternalOptimisationLanguage.g:1980:2: ( rule__ProblemRule__DefinitionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProblemRuleAccess().getDefinitionAssignment_1()); 
            }
            // InternalOptimisationLanguage.g:1981:2: ( rule__ProblemRule__DefinitionAssignment_1 )
            // InternalOptimisationLanguage.g:1981:3: rule__ProblemRule__DefinitionAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__ProblemRule__DefinitionAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getProblemRuleAccess().getDefinitionAssignment_1()); 
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
    // $ANTLR end "rule__ProblemRule__Group__1__Impl"


    // $ANTLR start "rule__ProblemRule__Group__2"
    // InternalOptimisationLanguage.g:1989:1: rule__ProblemRule__Group__2 : rule__ProblemRule__Group__2__Impl rule__ProblemRule__Group__3 ;
    public final void rule__ProblemRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1993:1: ( rule__ProblemRule__Group__2__Impl rule__ProblemRule__Group__3 )
            // InternalOptimisationLanguage.g:1994:2: rule__ProblemRule__Group__2__Impl rule__ProblemRule__Group__3
            {
            pushFollow(FOLLOW_6);
            rule__ProblemRule__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ProblemRule__Group__3();

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
    // $ANTLR end "rule__ProblemRule__Group__2"


    // $ANTLR start "rule__ProblemRule__Group__2__Impl"
    // InternalOptimisationLanguage.g:2001:1: rule__ProblemRule__Group__2__Impl : ( ( rule__ProblemRule__NameAssignment_2 ) ) ;
    public final void rule__ProblemRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2005:1: ( ( ( rule__ProblemRule__NameAssignment_2 ) ) )
            // InternalOptimisationLanguage.g:2006:1: ( ( rule__ProblemRule__NameAssignment_2 ) )
            {
            // InternalOptimisationLanguage.g:2006:1: ( ( rule__ProblemRule__NameAssignment_2 ) )
            // InternalOptimisationLanguage.g:2007:2: ( rule__ProblemRule__NameAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProblemRuleAccess().getNameAssignment_2()); 
            }
            // InternalOptimisationLanguage.g:2008:2: ( rule__ProblemRule__NameAssignment_2 )
            // InternalOptimisationLanguage.g:2008:3: rule__ProblemRule__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__ProblemRule__NameAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getProblemRuleAccess().getNameAssignment_2()); 
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
    // $ANTLR end "rule__ProblemRule__Group__2__Impl"


    // $ANTLR start "rule__ProblemRule__Group__3"
    // InternalOptimisationLanguage.g:2016:1: rule__ProblemRule__Group__3 : rule__ProblemRule__Group__3__Impl rule__ProblemRule__Group__4 ;
    public final void rule__ProblemRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2020:1: ( rule__ProblemRule__Group__3__Impl rule__ProblemRule__Group__4 )
            // InternalOptimisationLanguage.g:2021:2: rule__ProblemRule__Group__3__Impl rule__ProblemRule__Group__4
            {
            pushFollow(FOLLOW_8);
            rule__ProblemRule__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ProblemRule__Group__4();

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
    // $ANTLR end "rule__ProblemRule__Group__3"


    // $ANTLR start "rule__ProblemRule__Group__3__Impl"
    // InternalOptimisationLanguage.g:2028:1: rule__ProblemRule__Group__3__Impl : ( '{' ) ;
    public final void rule__ProblemRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2032:1: ( ( '{' ) )
            // InternalOptimisationLanguage.g:2033:1: ( '{' )
            {
            // InternalOptimisationLanguage.g:2033:1: ( '{' )
            // InternalOptimisationLanguage.g:2034:2: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProblemRuleAccess().getLeftCurlyBracketKeyword_3()); 
            }
            match(input,48,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getProblemRuleAccess().getLeftCurlyBracketKeyword_3()); 
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
    // $ANTLR end "rule__ProblemRule__Group__3__Impl"


    // $ANTLR start "rule__ProblemRule__Group__4"
    // InternalOptimisationLanguage.g:2043:1: rule__ProblemRule__Group__4 : rule__ProblemRule__Group__4__Impl rule__ProblemRule__Group__5 ;
    public final void rule__ProblemRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2047:1: ( rule__ProblemRule__Group__4__Impl rule__ProblemRule__Group__5 )
            // InternalOptimisationLanguage.g:2048:2: rule__ProblemRule__Group__4__Impl rule__ProblemRule__Group__5
            {
            pushFollow(FOLLOW_8);
            rule__ProblemRule__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ProblemRule__Group__5();

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
    // $ANTLR end "rule__ProblemRule__Group__4"


    // $ANTLR start "rule__ProblemRule__Group__4__Impl"
    // InternalOptimisationLanguage.g:2055:1: rule__ProblemRule__Group__4__Impl : ( ( rule__ProblemRule__AttributesAssignment_4 )* ) ;
    public final void rule__ProblemRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2059:1: ( ( ( rule__ProblemRule__AttributesAssignment_4 )* ) )
            // InternalOptimisationLanguage.g:2060:1: ( ( rule__ProblemRule__AttributesAssignment_4 )* )
            {
            // InternalOptimisationLanguage.g:2060:1: ( ( rule__ProblemRule__AttributesAssignment_4 )* )
            // InternalOptimisationLanguage.g:2061:2: ( rule__ProblemRule__AttributesAssignment_4 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProblemRuleAccess().getAttributesAssignment_4()); 
            }
            // InternalOptimisationLanguage.g:2062:2: ( rule__ProblemRule__AttributesAssignment_4 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>=RULE_QUOTED_ID && LA15_0<=RULE_ID)) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:2062:3: rule__ProblemRule__AttributesAssignment_4
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__ProblemRule__AttributesAssignment_4();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getProblemRuleAccess().getAttributesAssignment_4()); 
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
    // $ANTLR end "rule__ProblemRule__Group__4__Impl"


    // $ANTLR start "rule__ProblemRule__Group__5"
    // InternalOptimisationLanguage.g:2070:1: rule__ProblemRule__Group__5 : rule__ProblemRule__Group__5__Impl rule__ProblemRule__Group__6 ;
    public final void rule__ProblemRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2074:1: ( rule__ProblemRule__Group__5__Impl rule__ProblemRule__Group__6 )
            // InternalOptimisationLanguage.g:2075:2: rule__ProblemRule__Group__5__Impl rule__ProblemRule__Group__6
            {
            pushFollow(FOLLOW_8);
            rule__ProblemRule__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ProblemRule__Group__6();

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
    // $ANTLR end "rule__ProblemRule__Group__5"


    // $ANTLR start "rule__ProblemRule__Group__5__Impl"
    // InternalOptimisationLanguage.g:2082:1: rule__ProblemRule__Group__5__Impl : ( ( rule__ProblemRule__Group_5__0 )? ) ;
    public final void rule__ProblemRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2086:1: ( ( ( rule__ProblemRule__Group_5__0 )? ) )
            // InternalOptimisationLanguage.g:2087:1: ( ( rule__ProblemRule__Group_5__0 )? )
            {
            // InternalOptimisationLanguage.g:2087:1: ( ( rule__ProblemRule__Group_5__0 )? )
            // InternalOptimisationLanguage.g:2088:2: ( rule__ProblemRule__Group_5__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProblemRuleAccess().getGroup_5()); 
            }
            // InternalOptimisationLanguage.g:2089:2: ( rule__ProblemRule__Group_5__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==51) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalOptimisationLanguage.g:2089:3: rule__ProblemRule__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ProblemRule__Group_5__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getProblemRuleAccess().getGroup_5()); 
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
    // $ANTLR end "rule__ProblemRule__Group__5__Impl"


    // $ANTLR start "rule__ProblemRule__Group__6"
    // InternalOptimisationLanguage.g:2097:1: rule__ProblemRule__Group__6 : rule__ProblemRule__Group__6__Impl ;
    public final void rule__ProblemRule__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2101:1: ( rule__ProblemRule__Group__6__Impl )
            // InternalOptimisationLanguage.g:2102:2: rule__ProblemRule__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ProblemRule__Group__6__Impl();

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
    // $ANTLR end "rule__ProblemRule__Group__6"


    // $ANTLR start "rule__ProblemRule__Group__6__Impl"
    // InternalOptimisationLanguage.g:2108:1: rule__ProblemRule__Group__6__Impl : ( '}' ) ;
    public final void rule__ProblemRule__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2112:1: ( ( '}' ) )
            // InternalOptimisationLanguage.g:2113:1: ( '}' )
            {
            // InternalOptimisationLanguage.g:2113:1: ( '}' )
            // InternalOptimisationLanguage.g:2114:2: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProblemRuleAccess().getRightCurlyBracketKeyword_6()); 
            }
            match(input,49,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getProblemRuleAccess().getRightCurlyBracketKeyword_6()); 
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
    // $ANTLR end "rule__ProblemRule__Group__6__Impl"


    // $ANTLR start "rule__ProblemRule__Group_5__0"
    // InternalOptimisationLanguage.g:2124:1: rule__ProblemRule__Group_5__0 : rule__ProblemRule__Group_5__0__Impl rule__ProblemRule__Group_5__1 ;
    public final void rule__ProblemRule__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2128:1: ( rule__ProblemRule__Group_5__0__Impl rule__ProblemRule__Group_5__1 )
            // InternalOptimisationLanguage.g:2129:2: rule__ProblemRule__Group_5__0__Impl rule__ProblemRule__Group_5__1
            {
            pushFollow(FOLLOW_10);
            rule__ProblemRule__Group_5__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ProblemRule__Group_5__1();

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
    // $ANTLR end "rule__ProblemRule__Group_5__0"


    // $ANTLR start "rule__ProblemRule__Group_5__0__Impl"
    // InternalOptimisationLanguage.g:2136:1: rule__ProblemRule__Group_5__0__Impl : ( 'documenting' ) ;
    public final void rule__ProblemRule__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2140:1: ( ( 'documenting' ) )
            // InternalOptimisationLanguage.g:2141:1: ( 'documenting' )
            {
            // InternalOptimisationLanguage.g:2141:1: ( 'documenting' )
            // InternalOptimisationLanguage.g:2142:2: 'documenting'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProblemRuleAccess().getDocumentingKeyword_5_0()); 
            }
            match(input,51,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getProblemRuleAccess().getDocumentingKeyword_5_0()); 
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
    // $ANTLR end "rule__ProblemRule__Group_5__0__Impl"


    // $ANTLR start "rule__ProblemRule__Group_5__1"
    // InternalOptimisationLanguage.g:2151:1: rule__ProblemRule__Group_5__1 : rule__ProblemRule__Group_5__1__Impl rule__ProblemRule__Group_5__2 ;
    public final void rule__ProblemRule__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2155:1: ( rule__ProblemRule__Group_5__1__Impl rule__ProblemRule__Group_5__2 )
            // InternalOptimisationLanguage.g:2156:2: rule__ProblemRule__Group_5__1__Impl rule__ProblemRule__Group_5__2
            {
            pushFollow(FOLLOW_11);
            rule__ProblemRule__Group_5__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ProblemRule__Group_5__2();

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
    // $ANTLR end "rule__ProblemRule__Group_5__1"


    // $ANTLR start "rule__ProblemRule__Group_5__1__Impl"
    // InternalOptimisationLanguage.g:2163:1: rule__ProblemRule__Group_5__1__Impl : ( ':=' ) ;
    public final void rule__ProblemRule__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2167:1: ( ( ':=' ) )
            // InternalOptimisationLanguage.g:2168:1: ( ':=' )
            {
            // InternalOptimisationLanguage.g:2168:1: ( ':=' )
            // InternalOptimisationLanguage.g:2169:2: ':='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProblemRuleAccess().getColonEqualsSignKeyword_5_1()); 
            }
            match(input,52,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getProblemRuleAccess().getColonEqualsSignKeyword_5_1()); 
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
    // $ANTLR end "rule__ProblemRule__Group_5__1__Impl"


    // $ANTLR start "rule__ProblemRule__Group_5__2"
    // InternalOptimisationLanguage.g:2178:1: rule__ProblemRule__Group_5__2 : rule__ProblemRule__Group_5__2__Impl rule__ProblemRule__Group_5__3 ;
    public final void rule__ProblemRule__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2182:1: ( rule__ProblemRule__Group_5__2__Impl rule__ProblemRule__Group_5__3 )
            // InternalOptimisationLanguage.g:2183:2: rule__ProblemRule__Group_5__2__Impl rule__ProblemRule__Group_5__3
            {
            pushFollow(FOLLOW_12);
            rule__ProblemRule__Group_5__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ProblemRule__Group_5__3();

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
    // $ANTLR end "rule__ProblemRule__Group_5__2"


    // $ANTLR start "rule__ProblemRule__Group_5__2__Impl"
    // InternalOptimisationLanguage.g:2190:1: rule__ProblemRule__Group_5__2__Impl : ( ( rule__ProblemRule__DocumentationAssignment_5_2 ) ) ;
    public final void rule__ProblemRule__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2194:1: ( ( ( rule__ProblemRule__DocumentationAssignment_5_2 ) ) )
            // InternalOptimisationLanguage.g:2195:1: ( ( rule__ProblemRule__DocumentationAssignment_5_2 ) )
            {
            // InternalOptimisationLanguage.g:2195:1: ( ( rule__ProblemRule__DocumentationAssignment_5_2 ) )
            // InternalOptimisationLanguage.g:2196:2: ( rule__ProblemRule__DocumentationAssignment_5_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProblemRuleAccess().getDocumentationAssignment_5_2()); 
            }
            // InternalOptimisationLanguage.g:2197:2: ( rule__ProblemRule__DocumentationAssignment_5_2 )
            // InternalOptimisationLanguage.g:2197:3: rule__ProblemRule__DocumentationAssignment_5_2
            {
            pushFollow(FOLLOW_2);
            rule__ProblemRule__DocumentationAssignment_5_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getProblemRuleAccess().getDocumentationAssignment_5_2()); 
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
    // $ANTLR end "rule__ProblemRule__Group_5__2__Impl"


    // $ANTLR start "rule__ProblemRule__Group_5__3"
    // InternalOptimisationLanguage.g:2205:1: rule__ProblemRule__Group_5__3 : rule__ProblemRule__Group_5__3__Impl ;
    public final void rule__ProblemRule__Group_5__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2209:1: ( rule__ProblemRule__Group_5__3__Impl )
            // InternalOptimisationLanguage.g:2210:2: rule__ProblemRule__Group_5__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ProblemRule__Group_5__3__Impl();

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
    // $ANTLR end "rule__ProblemRule__Group_5__3"


    // $ANTLR start "rule__ProblemRule__Group_5__3__Impl"
    // InternalOptimisationLanguage.g:2216:1: rule__ProblemRule__Group_5__3__Impl : ( ';' ) ;
    public final void rule__ProblemRule__Group_5__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2220:1: ( ( ';' ) )
            // InternalOptimisationLanguage.g:2221:1: ( ';' )
            {
            // InternalOptimisationLanguage.g:2221:1: ( ';' )
            // InternalOptimisationLanguage.g:2222:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProblemRuleAccess().getSemicolonKeyword_5_3()); 
            }
            match(input,53,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getProblemRuleAccess().getSemicolonKeyword_5_3()); 
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
    // $ANTLR end "rule__ProblemRule__Group_5__3__Impl"


    // $ANTLR start "rule__AlgorithmInstanceRule__Group__0"
    // InternalOptimisationLanguage.g:2232:1: rule__AlgorithmInstanceRule__Group__0 : rule__AlgorithmInstanceRule__Group__0__Impl rule__AlgorithmInstanceRule__Group__1 ;
    public final void rule__AlgorithmInstanceRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2236:1: ( rule__AlgorithmInstanceRule__Group__0__Impl rule__AlgorithmInstanceRule__Group__1 )
            // InternalOptimisationLanguage.g:2237:2: rule__AlgorithmInstanceRule__Group__0__Impl rule__AlgorithmInstanceRule__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__AlgorithmInstanceRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__AlgorithmInstanceRule__Group__1();

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
    // $ANTLR end "rule__AlgorithmInstanceRule__Group__0"


    // $ANTLR start "rule__AlgorithmInstanceRule__Group__0__Impl"
    // InternalOptimisationLanguage.g:2244:1: rule__AlgorithmInstanceRule__Group__0__Impl : ( 'configure' ) ;
    public final void rule__AlgorithmInstanceRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2248:1: ( ( 'configure' ) )
            // InternalOptimisationLanguage.g:2249:1: ( 'configure' )
            {
            // InternalOptimisationLanguage.g:2249:1: ( 'configure' )
            // InternalOptimisationLanguage.g:2250:2: 'configure'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAlgorithmInstanceRuleAccess().getConfigureKeyword_0()); 
            }
            match(input,54,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAlgorithmInstanceRuleAccess().getConfigureKeyword_0()); 
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
    // $ANTLR end "rule__AlgorithmInstanceRule__Group__0__Impl"


    // $ANTLR start "rule__AlgorithmInstanceRule__Group__1"
    // InternalOptimisationLanguage.g:2259:1: rule__AlgorithmInstanceRule__Group__1 : rule__AlgorithmInstanceRule__Group__1__Impl rule__AlgorithmInstanceRule__Group__2 ;
    public final void rule__AlgorithmInstanceRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2263:1: ( rule__AlgorithmInstanceRule__Group__1__Impl rule__AlgorithmInstanceRule__Group__2 )
            // InternalOptimisationLanguage.g:2264:2: rule__AlgorithmInstanceRule__Group__1__Impl rule__AlgorithmInstanceRule__Group__2
            {
            pushFollow(FOLLOW_13);
            rule__AlgorithmInstanceRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__AlgorithmInstanceRule__Group__2();

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
    // $ANTLR end "rule__AlgorithmInstanceRule__Group__1"


    // $ANTLR start "rule__AlgorithmInstanceRule__Group__1__Impl"
    // InternalOptimisationLanguage.g:2271:1: rule__AlgorithmInstanceRule__Group__1__Impl : ( ( rule__AlgorithmInstanceRule__DefinitionAssignment_1 ) ) ;
    public final void rule__AlgorithmInstanceRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2275:1: ( ( ( rule__AlgorithmInstanceRule__DefinitionAssignment_1 ) ) )
            // InternalOptimisationLanguage.g:2276:1: ( ( rule__AlgorithmInstanceRule__DefinitionAssignment_1 ) )
            {
            // InternalOptimisationLanguage.g:2276:1: ( ( rule__AlgorithmInstanceRule__DefinitionAssignment_1 ) )
            // InternalOptimisationLanguage.g:2277:2: ( rule__AlgorithmInstanceRule__DefinitionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAlgorithmInstanceRuleAccess().getDefinitionAssignment_1()); 
            }
            // InternalOptimisationLanguage.g:2278:2: ( rule__AlgorithmInstanceRule__DefinitionAssignment_1 )
            // InternalOptimisationLanguage.g:2278:3: rule__AlgorithmInstanceRule__DefinitionAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__AlgorithmInstanceRule__DefinitionAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAlgorithmInstanceRuleAccess().getDefinitionAssignment_1()); 
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
    // $ANTLR end "rule__AlgorithmInstanceRule__Group__1__Impl"


    // $ANTLR start "rule__AlgorithmInstanceRule__Group__2"
    // InternalOptimisationLanguage.g:2286:1: rule__AlgorithmInstanceRule__Group__2 : rule__AlgorithmInstanceRule__Group__2__Impl rule__AlgorithmInstanceRule__Group__3 ;
    public final void rule__AlgorithmInstanceRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2290:1: ( rule__AlgorithmInstanceRule__Group__2__Impl rule__AlgorithmInstanceRule__Group__3 )
            // InternalOptimisationLanguage.g:2291:2: rule__AlgorithmInstanceRule__Group__2__Impl rule__AlgorithmInstanceRule__Group__3
            {
            pushFollow(FOLLOW_5);
            rule__AlgorithmInstanceRule__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__AlgorithmInstanceRule__Group__3();

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
    // $ANTLR end "rule__AlgorithmInstanceRule__Group__2"


    // $ANTLR start "rule__AlgorithmInstanceRule__Group__2__Impl"
    // InternalOptimisationLanguage.g:2298:1: rule__AlgorithmInstanceRule__Group__2__Impl : ( 'for' ) ;
    public final void rule__AlgorithmInstanceRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2302:1: ( ( 'for' ) )
            // InternalOptimisationLanguage.g:2303:1: ( 'for' )
            {
            // InternalOptimisationLanguage.g:2303:1: ( 'for' )
            // InternalOptimisationLanguage.g:2304:2: 'for'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAlgorithmInstanceRuleAccess().getForKeyword_2()); 
            }
            match(input,55,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAlgorithmInstanceRuleAccess().getForKeyword_2()); 
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
    // $ANTLR end "rule__AlgorithmInstanceRule__Group__2__Impl"


    // $ANTLR start "rule__AlgorithmInstanceRule__Group__3"
    // InternalOptimisationLanguage.g:2313:1: rule__AlgorithmInstanceRule__Group__3 : rule__AlgorithmInstanceRule__Group__3__Impl rule__AlgorithmInstanceRule__Group__4 ;
    public final void rule__AlgorithmInstanceRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2317:1: ( rule__AlgorithmInstanceRule__Group__3__Impl rule__AlgorithmInstanceRule__Group__4 )
            // InternalOptimisationLanguage.g:2318:2: rule__AlgorithmInstanceRule__Group__3__Impl rule__AlgorithmInstanceRule__Group__4
            {
            pushFollow(FOLLOW_6);
            rule__AlgorithmInstanceRule__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__AlgorithmInstanceRule__Group__4();

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
    // $ANTLR end "rule__AlgorithmInstanceRule__Group__3"


    // $ANTLR start "rule__AlgorithmInstanceRule__Group__3__Impl"
    // InternalOptimisationLanguage.g:2325:1: rule__AlgorithmInstanceRule__Group__3__Impl : ( ( rule__AlgorithmInstanceRule__ProblemAssignment_3 ) ) ;
    public final void rule__AlgorithmInstanceRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2329:1: ( ( ( rule__AlgorithmInstanceRule__ProblemAssignment_3 ) ) )
            // InternalOptimisationLanguage.g:2330:1: ( ( rule__AlgorithmInstanceRule__ProblemAssignment_3 ) )
            {
            // InternalOptimisationLanguage.g:2330:1: ( ( rule__AlgorithmInstanceRule__ProblemAssignment_3 ) )
            // InternalOptimisationLanguage.g:2331:2: ( rule__AlgorithmInstanceRule__ProblemAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAlgorithmInstanceRuleAccess().getProblemAssignment_3()); 
            }
            // InternalOptimisationLanguage.g:2332:2: ( rule__AlgorithmInstanceRule__ProblemAssignment_3 )
            // InternalOptimisationLanguage.g:2332:3: rule__AlgorithmInstanceRule__ProblemAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__AlgorithmInstanceRule__ProblemAssignment_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAlgorithmInstanceRuleAccess().getProblemAssignment_3()); 
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
    // $ANTLR end "rule__AlgorithmInstanceRule__Group__3__Impl"


    // $ANTLR start "rule__AlgorithmInstanceRule__Group__4"
    // InternalOptimisationLanguage.g:2340:1: rule__AlgorithmInstanceRule__Group__4 : rule__AlgorithmInstanceRule__Group__4__Impl rule__AlgorithmInstanceRule__Group__5 ;
    public final void rule__AlgorithmInstanceRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2344:1: ( rule__AlgorithmInstanceRule__Group__4__Impl rule__AlgorithmInstanceRule__Group__5 )
            // InternalOptimisationLanguage.g:2345:2: rule__AlgorithmInstanceRule__Group__4__Impl rule__AlgorithmInstanceRule__Group__5
            {
            pushFollow(FOLLOW_8);
            rule__AlgorithmInstanceRule__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__AlgorithmInstanceRule__Group__5();

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
    // $ANTLR end "rule__AlgorithmInstanceRule__Group__4"


    // $ANTLR start "rule__AlgorithmInstanceRule__Group__4__Impl"
    // InternalOptimisationLanguage.g:2352:1: rule__AlgorithmInstanceRule__Group__4__Impl : ( '{' ) ;
    public final void rule__AlgorithmInstanceRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2356:1: ( ( '{' ) )
            // InternalOptimisationLanguage.g:2357:1: ( '{' )
            {
            // InternalOptimisationLanguage.g:2357:1: ( '{' )
            // InternalOptimisationLanguage.g:2358:2: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAlgorithmInstanceRuleAccess().getLeftCurlyBracketKeyword_4()); 
            }
            match(input,48,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAlgorithmInstanceRuleAccess().getLeftCurlyBracketKeyword_4()); 
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
    // $ANTLR end "rule__AlgorithmInstanceRule__Group__4__Impl"


    // $ANTLR start "rule__AlgorithmInstanceRule__Group__5"
    // InternalOptimisationLanguage.g:2367:1: rule__AlgorithmInstanceRule__Group__5 : rule__AlgorithmInstanceRule__Group__5__Impl rule__AlgorithmInstanceRule__Group__6 ;
    public final void rule__AlgorithmInstanceRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2371:1: ( rule__AlgorithmInstanceRule__Group__5__Impl rule__AlgorithmInstanceRule__Group__6 )
            // InternalOptimisationLanguage.g:2372:2: rule__AlgorithmInstanceRule__Group__5__Impl rule__AlgorithmInstanceRule__Group__6
            {
            pushFollow(FOLLOW_8);
            rule__AlgorithmInstanceRule__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__AlgorithmInstanceRule__Group__6();

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
    // $ANTLR end "rule__AlgorithmInstanceRule__Group__5"


    // $ANTLR start "rule__AlgorithmInstanceRule__Group__5__Impl"
    // InternalOptimisationLanguage.g:2379:1: rule__AlgorithmInstanceRule__Group__5__Impl : ( ( rule__AlgorithmInstanceRule__AttributesAssignment_5 )* ) ;
    public final void rule__AlgorithmInstanceRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2383:1: ( ( ( rule__AlgorithmInstanceRule__AttributesAssignment_5 )* ) )
            // InternalOptimisationLanguage.g:2384:1: ( ( rule__AlgorithmInstanceRule__AttributesAssignment_5 )* )
            {
            // InternalOptimisationLanguage.g:2384:1: ( ( rule__AlgorithmInstanceRule__AttributesAssignment_5 )* )
            // InternalOptimisationLanguage.g:2385:2: ( rule__AlgorithmInstanceRule__AttributesAssignment_5 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAlgorithmInstanceRuleAccess().getAttributesAssignment_5()); 
            }
            // InternalOptimisationLanguage.g:2386:2: ( rule__AlgorithmInstanceRule__AttributesAssignment_5 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>=RULE_QUOTED_ID && LA17_0<=RULE_ID)) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:2386:3: rule__AlgorithmInstanceRule__AttributesAssignment_5
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__AlgorithmInstanceRule__AttributesAssignment_5();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAlgorithmInstanceRuleAccess().getAttributesAssignment_5()); 
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
    // $ANTLR end "rule__AlgorithmInstanceRule__Group__5__Impl"


    // $ANTLR start "rule__AlgorithmInstanceRule__Group__6"
    // InternalOptimisationLanguage.g:2394:1: rule__AlgorithmInstanceRule__Group__6 : rule__AlgorithmInstanceRule__Group__6__Impl rule__AlgorithmInstanceRule__Group__7 ;
    public final void rule__AlgorithmInstanceRule__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2398:1: ( rule__AlgorithmInstanceRule__Group__6__Impl rule__AlgorithmInstanceRule__Group__7 )
            // InternalOptimisationLanguage.g:2399:2: rule__AlgorithmInstanceRule__Group__6__Impl rule__AlgorithmInstanceRule__Group__7
            {
            pushFollow(FOLLOW_8);
            rule__AlgorithmInstanceRule__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__AlgorithmInstanceRule__Group__7();

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
    // $ANTLR end "rule__AlgorithmInstanceRule__Group__6"


    // $ANTLR start "rule__AlgorithmInstanceRule__Group__6__Impl"
    // InternalOptimisationLanguage.g:2406:1: rule__AlgorithmInstanceRule__Group__6__Impl : ( ( rule__AlgorithmInstanceRule__Group_6__0 )? ) ;
    public final void rule__AlgorithmInstanceRule__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2410:1: ( ( ( rule__AlgorithmInstanceRule__Group_6__0 )? ) )
            // InternalOptimisationLanguage.g:2411:1: ( ( rule__AlgorithmInstanceRule__Group_6__0 )? )
            {
            // InternalOptimisationLanguage.g:2411:1: ( ( rule__AlgorithmInstanceRule__Group_6__0 )? )
            // InternalOptimisationLanguage.g:2412:2: ( rule__AlgorithmInstanceRule__Group_6__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAlgorithmInstanceRuleAccess().getGroup_6()); 
            }
            // InternalOptimisationLanguage.g:2413:2: ( rule__AlgorithmInstanceRule__Group_6__0 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==51) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalOptimisationLanguage.g:2413:3: rule__AlgorithmInstanceRule__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__AlgorithmInstanceRule__Group_6__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAlgorithmInstanceRuleAccess().getGroup_6()); 
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
    // $ANTLR end "rule__AlgorithmInstanceRule__Group__6__Impl"


    // $ANTLR start "rule__AlgorithmInstanceRule__Group__7"
    // InternalOptimisationLanguage.g:2421:1: rule__AlgorithmInstanceRule__Group__7 : rule__AlgorithmInstanceRule__Group__7__Impl ;
    public final void rule__AlgorithmInstanceRule__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2425:1: ( rule__AlgorithmInstanceRule__Group__7__Impl )
            // InternalOptimisationLanguage.g:2426:2: rule__AlgorithmInstanceRule__Group__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AlgorithmInstanceRule__Group__7__Impl();

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
    // $ANTLR end "rule__AlgorithmInstanceRule__Group__7"


    // $ANTLR start "rule__AlgorithmInstanceRule__Group__7__Impl"
    // InternalOptimisationLanguage.g:2432:1: rule__AlgorithmInstanceRule__Group__7__Impl : ( '}' ) ;
    public final void rule__AlgorithmInstanceRule__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2436:1: ( ( '}' ) )
            // InternalOptimisationLanguage.g:2437:1: ( '}' )
            {
            // InternalOptimisationLanguage.g:2437:1: ( '}' )
            // InternalOptimisationLanguage.g:2438:2: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAlgorithmInstanceRuleAccess().getRightCurlyBracketKeyword_7()); 
            }
            match(input,49,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAlgorithmInstanceRuleAccess().getRightCurlyBracketKeyword_7()); 
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
    // $ANTLR end "rule__AlgorithmInstanceRule__Group__7__Impl"


    // $ANTLR start "rule__AlgorithmInstanceRule__Group_6__0"
    // InternalOptimisationLanguage.g:2448:1: rule__AlgorithmInstanceRule__Group_6__0 : rule__AlgorithmInstanceRule__Group_6__0__Impl rule__AlgorithmInstanceRule__Group_6__1 ;
    public final void rule__AlgorithmInstanceRule__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2452:1: ( rule__AlgorithmInstanceRule__Group_6__0__Impl rule__AlgorithmInstanceRule__Group_6__1 )
            // InternalOptimisationLanguage.g:2453:2: rule__AlgorithmInstanceRule__Group_6__0__Impl rule__AlgorithmInstanceRule__Group_6__1
            {
            pushFollow(FOLLOW_10);
            rule__AlgorithmInstanceRule__Group_6__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__AlgorithmInstanceRule__Group_6__1();

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
    // $ANTLR end "rule__AlgorithmInstanceRule__Group_6__0"


    // $ANTLR start "rule__AlgorithmInstanceRule__Group_6__0__Impl"
    // InternalOptimisationLanguage.g:2460:1: rule__AlgorithmInstanceRule__Group_6__0__Impl : ( 'documenting' ) ;
    public final void rule__AlgorithmInstanceRule__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2464:1: ( ( 'documenting' ) )
            // InternalOptimisationLanguage.g:2465:1: ( 'documenting' )
            {
            // InternalOptimisationLanguage.g:2465:1: ( 'documenting' )
            // InternalOptimisationLanguage.g:2466:2: 'documenting'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAlgorithmInstanceRuleAccess().getDocumentingKeyword_6_0()); 
            }
            match(input,51,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAlgorithmInstanceRuleAccess().getDocumentingKeyword_6_0()); 
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
    // $ANTLR end "rule__AlgorithmInstanceRule__Group_6__0__Impl"


    // $ANTLR start "rule__AlgorithmInstanceRule__Group_6__1"
    // InternalOptimisationLanguage.g:2475:1: rule__AlgorithmInstanceRule__Group_6__1 : rule__AlgorithmInstanceRule__Group_6__1__Impl rule__AlgorithmInstanceRule__Group_6__2 ;
    public final void rule__AlgorithmInstanceRule__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2479:1: ( rule__AlgorithmInstanceRule__Group_6__1__Impl rule__AlgorithmInstanceRule__Group_6__2 )
            // InternalOptimisationLanguage.g:2480:2: rule__AlgorithmInstanceRule__Group_6__1__Impl rule__AlgorithmInstanceRule__Group_6__2
            {
            pushFollow(FOLLOW_11);
            rule__AlgorithmInstanceRule__Group_6__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__AlgorithmInstanceRule__Group_6__2();

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
    // $ANTLR end "rule__AlgorithmInstanceRule__Group_6__1"


    // $ANTLR start "rule__AlgorithmInstanceRule__Group_6__1__Impl"
    // InternalOptimisationLanguage.g:2487:1: rule__AlgorithmInstanceRule__Group_6__1__Impl : ( ':=' ) ;
    public final void rule__AlgorithmInstanceRule__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2491:1: ( ( ':=' ) )
            // InternalOptimisationLanguage.g:2492:1: ( ':=' )
            {
            // InternalOptimisationLanguage.g:2492:1: ( ':=' )
            // InternalOptimisationLanguage.g:2493:2: ':='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAlgorithmInstanceRuleAccess().getColonEqualsSignKeyword_6_1()); 
            }
            match(input,52,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAlgorithmInstanceRuleAccess().getColonEqualsSignKeyword_6_1()); 
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
    // $ANTLR end "rule__AlgorithmInstanceRule__Group_6__1__Impl"


    // $ANTLR start "rule__AlgorithmInstanceRule__Group_6__2"
    // InternalOptimisationLanguage.g:2502:1: rule__AlgorithmInstanceRule__Group_6__2 : rule__AlgorithmInstanceRule__Group_6__2__Impl rule__AlgorithmInstanceRule__Group_6__3 ;
    public final void rule__AlgorithmInstanceRule__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2506:1: ( rule__AlgorithmInstanceRule__Group_6__2__Impl rule__AlgorithmInstanceRule__Group_6__3 )
            // InternalOptimisationLanguage.g:2507:2: rule__AlgorithmInstanceRule__Group_6__2__Impl rule__AlgorithmInstanceRule__Group_6__3
            {
            pushFollow(FOLLOW_12);
            rule__AlgorithmInstanceRule__Group_6__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__AlgorithmInstanceRule__Group_6__3();

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
    // $ANTLR end "rule__AlgorithmInstanceRule__Group_6__2"


    // $ANTLR start "rule__AlgorithmInstanceRule__Group_6__2__Impl"
    // InternalOptimisationLanguage.g:2514:1: rule__AlgorithmInstanceRule__Group_6__2__Impl : ( ( rule__AlgorithmInstanceRule__DocumentationAssignment_6_2 ) ) ;
    public final void rule__AlgorithmInstanceRule__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2518:1: ( ( ( rule__AlgorithmInstanceRule__DocumentationAssignment_6_2 ) ) )
            // InternalOptimisationLanguage.g:2519:1: ( ( rule__AlgorithmInstanceRule__DocumentationAssignment_6_2 ) )
            {
            // InternalOptimisationLanguage.g:2519:1: ( ( rule__AlgorithmInstanceRule__DocumentationAssignment_6_2 ) )
            // InternalOptimisationLanguage.g:2520:2: ( rule__AlgorithmInstanceRule__DocumentationAssignment_6_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAlgorithmInstanceRuleAccess().getDocumentationAssignment_6_2()); 
            }
            // InternalOptimisationLanguage.g:2521:2: ( rule__AlgorithmInstanceRule__DocumentationAssignment_6_2 )
            // InternalOptimisationLanguage.g:2521:3: rule__AlgorithmInstanceRule__DocumentationAssignment_6_2
            {
            pushFollow(FOLLOW_2);
            rule__AlgorithmInstanceRule__DocumentationAssignment_6_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAlgorithmInstanceRuleAccess().getDocumentationAssignment_6_2()); 
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
    // $ANTLR end "rule__AlgorithmInstanceRule__Group_6__2__Impl"


    // $ANTLR start "rule__AlgorithmInstanceRule__Group_6__3"
    // InternalOptimisationLanguage.g:2529:1: rule__AlgorithmInstanceRule__Group_6__3 : rule__AlgorithmInstanceRule__Group_6__3__Impl ;
    public final void rule__AlgorithmInstanceRule__Group_6__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2533:1: ( rule__AlgorithmInstanceRule__Group_6__3__Impl )
            // InternalOptimisationLanguage.g:2534:2: rule__AlgorithmInstanceRule__Group_6__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AlgorithmInstanceRule__Group_6__3__Impl();

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
    // $ANTLR end "rule__AlgorithmInstanceRule__Group_6__3"


    // $ANTLR start "rule__AlgorithmInstanceRule__Group_6__3__Impl"
    // InternalOptimisationLanguage.g:2540:1: rule__AlgorithmInstanceRule__Group_6__3__Impl : ( ';' ) ;
    public final void rule__AlgorithmInstanceRule__Group_6__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2544:1: ( ( ';' ) )
            // InternalOptimisationLanguage.g:2545:1: ( ';' )
            {
            // InternalOptimisationLanguage.g:2545:1: ( ';' )
            // InternalOptimisationLanguage.g:2546:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAlgorithmInstanceRuleAccess().getSemicolonKeyword_6_3()); 
            }
            match(input,53,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAlgorithmInstanceRuleAccess().getSemicolonKeyword_6_3()); 
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
    // $ANTLR end "rule__AlgorithmInstanceRule__Group_6__3__Impl"


    // $ANTLR start "rule__DataReferenceRule__Group__0"
    // InternalOptimisationLanguage.g:2556:1: rule__DataReferenceRule__Group__0 : rule__DataReferenceRule__Group__0__Impl rule__DataReferenceRule__Group__1 ;
    public final void rule__DataReferenceRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2560:1: ( rule__DataReferenceRule__Group__0__Impl rule__DataReferenceRule__Group__1 )
            // InternalOptimisationLanguage.g:2561:2: rule__DataReferenceRule__Group__0__Impl rule__DataReferenceRule__Group__1
            {
            pushFollow(FOLLOW_14);
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
    // InternalOptimisationLanguage.g:2568:1: rule__DataReferenceRule__Group__0__Impl : ( () ) ;
    public final void rule__DataReferenceRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2572:1: ( ( () ) )
            // InternalOptimisationLanguage.g:2573:1: ( () )
            {
            // InternalOptimisationLanguage.g:2573:1: ( () )
            // InternalOptimisationLanguage.g:2574:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataReferenceRuleAccess().getDataReferenceAction_0()); 
            }
            // InternalOptimisationLanguage.g:2575:2: ()
            // InternalOptimisationLanguage.g:2575:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataReferenceRuleAccess().getDataReferenceAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataReferenceRule__Group__0__Impl"


    // $ANTLR start "rule__DataReferenceRule__Group__1"
    // InternalOptimisationLanguage.g:2583:1: rule__DataReferenceRule__Group__1 : rule__DataReferenceRule__Group__1__Impl rule__DataReferenceRule__Group__2 ;
    public final void rule__DataReferenceRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2587:1: ( rule__DataReferenceRule__Group__1__Impl rule__DataReferenceRule__Group__2 )
            // InternalOptimisationLanguage.g:2588:2: rule__DataReferenceRule__Group__1__Impl rule__DataReferenceRule__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__DataReferenceRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__DataReferenceRule__Group__2();

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
    // InternalOptimisationLanguage.g:2595:1: rule__DataReferenceRule__Group__1__Impl : ( 'data' ) ;
    public final void rule__DataReferenceRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2599:1: ( ( 'data' ) )
            // InternalOptimisationLanguage.g:2600:1: ( 'data' )
            {
            // InternalOptimisationLanguage.g:2600:1: ( 'data' )
            // InternalOptimisationLanguage.g:2601:2: 'data'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataReferenceRuleAccess().getDataKeyword_1()); 
            }
            match(input,56,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataReferenceRuleAccess().getDataKeyword_1()); 
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


    // $ANTLR start "rule__DataReferenceRule__Group__2"
    // InternalOptimisationLanguage.g:2610:1: rule__DataReferenceRule__Group__2 : rule__DataReferenceRule__Group__2__Impl ;
    public final void rule__DataReferenceRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2614:1: ( rule__DataReferenceRule__Group__2__Impl )
            // InternalOptimisationLanguage.g:2615:2: rule__DataReferenceRule__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataReferenceRule__Group__2__Impl();

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
    // $ANTLR end "rule__DataReferenceRule__Group__2"


    // $ANTLR start "rule__DataReferenceRule__Group__2__Impl"
    // InternalOptimisationLanguage.g:2621:1: rule__DataReferenceRule__Group__2__Impl : ( ( rule__DataReferenceRule__DefinitionAssignment_2 ) ) ;
    public final void rule__DataReferenceRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2625:1: ( ( ( rule__DataReferenceRule__DefinitionAssignment_2 ) ) )
            // InternalOptimisationLanguage.g:2626:1: ( ( rule__DataReferenceRule__DefinitionAssignment_2 ) )
            {
            // InternalOptimisationLanguage.g:2626:1: ( ( rule__DataReferenceRule__DefinitionAssignment_2 ) )
            // InternalOptimisationLanguage.g:2627:2: ( rule__DataReferenceRule__DefinitionAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataReferenceRuleAccess().getDefinitionAssignment_2()); 
            }
            // InternalOptimisationLanguage.g:2628:2: ( rule__DataReferenceRule__DefinitionAssignment_2 )
            // InternalOptimisationLanguage.g:2628:3: rule__DataReferenceRule__DefinitionAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__DataReferenceRule__DefinitionAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataReferenceRuleAccess().getDefinitionAssignment_2()); 
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
    // $ANTLR end "rule__DataReferenceRule__Group__2__Impl"


    // $ANTLR start "rule__OrExpressionRule__Group__0"
    // InternalOptimisationLanguage.g:2637:1: rule__OrExpressionRule__Group__0 : rule__OrExpressionRule__Group__0__Impl rule__OrExpressionRule__Group__1 ;
    public final void rule__OrExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2641:1: ( rule__OrExpressionRule__Group__0__Impl rule__OrExpressionRule__Group__1 )
            // InternalOptimisationLanguage.g:2642:2: rule__OrExpressionRule__Group__0__Impl rule__OrExpressionRule__Group__1
            {
            pushFollow(FOLLOW_15);
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
    // InternalOptimisationLanguage.g:2649:1: rule__OrExpressionRule__Group__0__Impl : ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) ) ;
    public final void rule__OrExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2653:1: ( ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) ) )
            // InternalOptimisationLanguage.g:2654:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) )
            {
            // InternalOptimisationLanguage.g:2654:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) )
            // InternalOptimisationLanguage.g:2655:2: ( rule__OrExpressionRule__SubExpressionsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsAssignment_0()); 
            }
            // InternalOptimisationLanguage.g:2656:2: ( rule__OrExpressionRule__SubExpressionsAssignment_0 )
            // InternalOptimisationLanguage.g:2656:3: rule__OrExpressionRule__SubExpressionsAssignment_0
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
    // InternalOptimisationLanguage.g:2664:1: rule__OrExpressionRule__Group__1 : rule__OrExpressionRule__Group__1__Impl ;
    public final void rule__OrExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2668:1: ( rule__OrExpressionRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:2669:2: rule__OrExpressionRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:2675:1: rule__OrExpressionRule__Group__1__Impl : ( ( rule__OrExpressionRule__Group_1__0 )* ) ;
    public final void rule__OrExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2679:1: ( ( ( rule__OrExpressionRule__Group_1__0 )* ) )
            // InternalOptimisationLanguage.g:2680:1: ( ( rule__OrExpressionRule__Group_1__0 )* )
            {
            // InternalOptimisationLanguage.g:2680:1: ( ( rule__OrExpressionRule__Group_1__0 )* )
            // InternalOptimisationLanguage.g:2681:2: ( rule__OrExpressionRule__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionRuleAccess().getGroup_1()); 
            }
            // InternalOptimisationLanguage.g:2682:2: ( rule__OrExpressionRule__Group_1__0 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==57) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:2682:3: rule__OrExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_16);
            	    rule__OrExpressionRule__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop19;
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
    // InternalOptimisationLanguage.g:2691:1: rule__OrExpressionRule__Group_1__0 : rule__OrExpressionRule__Group_1__0__Impl rule__OrExpressionRule__Group_1__1 ;
    public final void rule__OrExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2695:1: ( rule__OrExpressionRule__Group_1__0__Impl rule__OrExpressionRule__Group_1__1 )
            // InternalOptimisationLanguage.g:2696:2: rule__OrExpressionRule__Group_1__0__Impl rule__OrExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_17);
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
    // InternalOptimisationLanguage.g:2703:1: rule__OrExpressionRule__Group_1__0__Impl : ( 'OR' ) ;
    public final void rule__OrExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2707:1: ( ( 'OR' ) )
            // InternalOptimisationLanguage.g:2708:1: ( 'OR' )
            {
            // InternalOptimisationLanguage.g:2708:1: ( 'OR' )
            // InternalOptimisationLanguage.g:2709:2: 'OR'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionRuleAccess().getORKeyword_1_0()); 
            }
            match(input,57,FOLLOW_2); if (state.failed) return ;
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
    // InternalOptimisationLanguage.g:2718:1: rule__OrExpressionRule__Group_1__1 : rule__OrExpressionRule__Group_1__1__Impl ;
    public final void rule__OrExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2722:1: ( rule__OrExpressionRule__Group_1__1__Impl )
            // InternalOptimisationLanguage.g:2723:2: rule__OrExpressionRule__Group_1__1__Impl
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
    // InternalOptimisationLanguage.g:2729:1: rule__OrExpressionRule__Group_1__1__Impl : ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) ) ;
    public final void rule__OrExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2733:1: ( ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) ) )
            // InternalOptimisationLanguage.g:2734:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) )
            {
            // InternalOptimisationLanguage.g:2734:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) )
            // InternalOptimisationLanguage.g:2735:2: ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsAssignment_1_1()); 
            }
            // InternalOptimisationLanguage.g:2736:2: ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 )
            // InternalOptimisationLanguage.g:2736:3: rule__OrExpressionRule__SubExpressionsAssignment_1_1
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
    // InternalOptimisationLanguage.g:2745:1: rule__XorExpressionRule__Group__0 : rule__XorExpressionRule__Group__0__Impl rule__XorExpressionRule__Group__1 ;
    public final void rule__XorExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2749:1: ( rule__XorExpressionRule__Group__0__Impl rule__XorExpressionRule__Group__1 )
            // InternalOptimisationLanguage.g:2750:2: rule__XorExpressionRule__Group__0__Impl rule__XorExpressionRule__Group__1
            {
            pushFollow(FOLLOW_18);
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
    // InternalOptimisationLanguage.g:2757:1: rule__XorExpressionRule__Group__0__Impl : ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) ) ;
    public final void rule__XorExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2761:1: ( ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) ) )
            // InternalOptimisationLanguage.g:2762:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) )
            {
            // InternalOptimisationLanguage.g:2762:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) )
            // InternalOptimisationLanguage.g:2763:2: ( rule__XorExpressionRule__SubExpressionsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAssignment_0()); 
            }
            // InternalOptimisationLanguage.g:2764:2: ( rule__XorExpressionRule__SubExpressionsAssignment_0 )
            // InternalOptimisationLanguage.g:2764:3: rule__XorExpressionRule__SubExpressionsAssignment_0
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
    // InternalOptimisationLanguage.g:2772:1: rule__XorExpressionRule__Group__1 : rule__XorExpressionRule__Group__1__Impl ;
    public final void rule__XorExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2776:1: ( rule__XorExpressionRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:2777:2: rule__XorExpressionRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:2783:1: rule__XorExpressionRule__Group__1__Impl : ( ( rule__XorExpressionRule__Group_1__0 )* ) ;
    public final void rule__XorExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2787:1: ( ( ( rule__XorExpressionRule__Group_1__0 )* ) )
            // InternalOptimisationLanguage.g:2788:1: ( ( rule__XorExpressionRule__Group_1__0 )* )
            {
            // InternalOptimisationLanguage.g:2788:1: ( ( rule__XorExpressionRule__Group_1__0 )* )
            // InternalOptimisationLanguage.g:2789:2: ( rule__XorExpressionRule__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXorExpressionRuleAccess().getGroup_1()); 
            }
            // InternalOptimisationLanguage.g:2790:2: ( rule__XorExpressionRule__Group_1__0 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==58) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:2790:3: rule__XorExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_19);
            	    rule__XorExpressionRule__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop20;
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
    // InternalOptimisationLanguage.g:2799:1: rule__XorExpressionRule__Group_1__0 : rule__XorExpressionRule__Group_1__0__Impl rule__XorExpressionRule__Group_1__1 ;
    public final void rule__XorExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2803:1: ( rule__XorExpressionRule__Group_1__0__Impl rule__XorExpressionRule__Group_1__1 )
            // InternalOptimisationLanguage.g:2804:2: rule__XorExpressionRule__Group_1__0__Impl rule__XorExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_17);
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
    // InternalOptimisationLanguage.g:2811:1: rule__XorExpressionRule__Group_1__0__Impl : ( 'XOR' ) ;
    public final void rule__XorExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2815:1: ( ( 'XOR' ) )
            // InternalOptimisationLanguage.g:2816:1: ( 'XOR' )
            {
            // InternalOptimisationLanguage.g:2816:1: ( 'XOR' )
            // InternalOptimisationLanguage.g:2817:2: 'XOR'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXorExpressionRuleAccess().getXORKeyword_1_0()); 
            }
            match(input,58,FOLLOW_2); if (state.failed) return ;
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
    // InternalOptimisationLanguage.g:2826:1: rule__XorExpressionRule__Group_1__1 : rule__XorExpressionRule__Group_1__1__Impl ;
    public final void rule__XorExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2830:1: ( rule__XorExpressionRule__Group_1__1__Impl )
            // InternalOptimisationLanguage.g:2831:2: rule__XorExpressionRule__Group_1__1__Impl
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
    // InternalOptimisationLanguage.g:2837:1: rule__XorExpressionRule__Group_1__1__Impl : ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) ) ;
    public final void rule__XorExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2841:1: ( ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) ) )
            // InternalOptimisationLanguage.g:2842:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) )
            {
            // InternalOptimisationLanguage.g:2842:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) )
            // InternalOptimisationLanguage.g:2843:2: ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAssignment_1_1()); 
            }
            // InternalOptimisationLanguage.g:2844:2: ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 )
            // InternalOptimisationLanguage.g:2844:3: rule__XorExpressionRule__SubExpressionsAssignment_1_1
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
    // InternalOptimisationLanguage.g:2853:1: rule__AndExpressionRule__Group__0 : rule__AndExpressionRule__Group__0__Impl rule__AndExpressionRule__Group__1 ;
    public final void rule__AndExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2857:1: ( rule__AndExpressionRule__Group__0__Impl rule__AndExpressionRule__Group__1 )
            // InternalOptimisationLanguage.g:2858:2: rule__AndExpressionRule__Group__0__Impl rule__AndExpressionRule__Group__1
            {
            pushFollow(FOLLOW_20);
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
    // InternalOptimisationLanguage.g:2865:1: rule__AndExpressionRule__Group__0__Impl : ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) ) ;
    public final void rule__AndExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2869:1: ( ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) ) )
            // InternalOptimisationLanguage.g:2870:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) )
            {
            // InternalOptimisationLanguage.g:2870:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) )
            // InternalOptimisationLanguage.g:2871:2: ( rule__AndExpressionRule__SubExpressionsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsAssignment_0()); 
            }
            // InternalOptimisationLanguage.g:2872:2: ( rule__AndExpressionRule__SubExpressionsAssignment_0 )
            // InternalOptimisationLanguage.g:2872:3: rule__AndExpressionRule__SubExpressionsAssignment_0
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
    // InternalOptimisationLanguage.g:2880:1: rule__AndExpressionRule__Group__1 : rule__AndExpressionRule__Group__1__Impl ;
    public final void rule__AndExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2884:1: ( rule__AndExpressionRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:2885:2: rule__AndExpressionRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:2891:1: rule__AndExpressionRule__Group__1__Impl : ( ( rule__AndExpressionRule__Group_1__0 )* ) ;
    public final void rule__AndExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2895:1: ( ( ( rule__AndExpressionRule__Group_1__0 )* ) )
            // InternalOptimisationLanguage.g:2896:1: ( ( rule__AndExpressionRule__Group_1__0 )* )
            {
            // InternalOptimisationLanguage.g:2896:1: ( ( rule__AndExpressionRule__Group_1__0 )* )
            // InternalOptimisationLanguage.g:2897:2: ( rule__AndExpressionRule__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionRuleAccess().getGroup_1()); 
            }
            // InternalOptimisationLanguage.g:2898:2: ( rule__AndExpressionRule__Group_1__0 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==59) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:2898:3: rule__AndExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_21);
            	    rule__AndExpressionRule__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop21;
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
    // InternalOptimisationLanguage.g:2907:1: rule__AndExpressionRule__Group_1__0 : rule__AndExpressionRule__Group_1__0__Impl rule__AndExpressionRule__Group_1__1 ;
    public final void rule__AndExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2911:1: ( rule__AndExpressionRule__Group_1__0__Impl rule__AndExpressionRule__Group_1__1 )
            // InternalOptimisationLanguage.g:2912:2: rule__AndExpressionRule__Group_1__0__Impl rule__AndExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_17);
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
    // InternalOptimisationLanguage.g:2919:1: rule__AndExpressionRule__Group_1__0__Impl : ( 'AND' ) ;
    public final void rule__AndExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2923:1: ( ( 'AND' ) )
            // InternalOptimisationLanguage.g:2924:1: ( 'AND' )
            {
            // InternalOptimisationLanguage.g:2924:1: ( 'AND' )
            // InternalOptimisationLanguage.g:2925:2: 'AND'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionRuleAccess().getANDKeyword_1_0()); 
            }
            match(input,59,FOLLOW_2); if (state.failed) return ;
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
    // InternalOptimisationLanguage.g:2934:1: rule__AndExpressionRule__Group_1__1 : rule__AndExpressionRule__Group_1__1__Impl ;
    public final void rule__AndExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2938:1: ( rule__AndExpressionRule__Group_1__1__Impl )
            // InternalOptimisationLanguage.g:2939:2: rule__AndExpressionRule__Group_1__1__Impl
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
    // InternalOptimisationLanguage.g:2945:1: rule__AndExpressionRule__Group_1__1__Impl : ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) ) ;
    public final void rule__AndExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2949:1: ( ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) ) )
            // InternalOptimisationLanguage.g:2950:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) )
            {
            // InternalOptimisationLanguage.g:2950:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) )
            // InternalOptimisationLanguage.g:2951:2: ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsAssignment_1_1()); 
            }
            // InternalOptimisationLanguage.g:2952:2: ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 )
            // InternalOptimisationLanguage.g:2952:3: rule__AndExpressionRule__SubExpressionsAssignment_1_1
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
    // InternalOptimisationLanguage.g:2961:1: rule__NotExpressionRule__Group__0 : rule__NotExpressionRule__Group__0__Impl rule__NotExpressionRule__Group__1 ;
    public final void rule__NotExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2965:1: ( rule__NotExpressionRule__Group__0__Impl rule__NotExpressionRule__Group__1 )
            // InternalOptimisationLanguage.g:2966:2: rule__NotExpressionRule__Group__0__Impl rule__NotExpressionRule__Group__1
            {
            pushFollow(FOLLOW_17);
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
    // InternalOptimisationLanguage.g:2973:1: rule__NotExpressionRule__Group__0__Impl : ( ( rule__NotExpressionRule__NegatedAssignment_0 )? ) ;
    public final void rule__NotExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2977:1: ( ( ( rule__NotExpressionRule__NegatedAssignment_0 )? ) )
            // InternalOptimisationLanguage.g:2978:1: ( ( rule__NotExpressionRule__NegatedAssignment_0 )? )
            {
            // InternalOptimisationLanguage.g:2978:1: ( ( rule__NotExpressionRule__NegatedAssignment_0 )? )
            // InternalOptimisationLanguage.g:2979:2: ( rule__NotExpressionRule__NegatedAssignment_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNotExpressionRuleAccess().getNegatedAssignment_0()); 
            }
            // InternalOptimisationLanguage.g:2980:2: ( rule__NotExpressionRule__NegatedAssignment_0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==82) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalOptimisationLanguage.g:2980:3: rule__NotExpressionRule__NegatedAssignment_0
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
    // InternalOptimisationLanguage.g:2988:1: rule__NotExpressionRule__Group__1 : rule__NotExpressionRule__Group__1__Impl ;
    public final void rule__NotExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2992:1: ( rule__NotExpressionRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:2993:2: rule__NotExpressionRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:2999:1: rule__NotExpressionRule__Group__1__Impl : ( ( rule__NotExpressionRule__OperandAssignment_1 ) ) ;
    public final void rule__NotExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3003:1: ( ( ( rule__NotExpressionRule__OperandAssignment_1 ) ) )
            // InternalOptimisationLanguage.g:3004:1: ( ( rule__NotExpressionRule__OperandAssignment_1 ) )
            {
            // InternalOptimisationLanguage.g:3004:1: ( ( rule__NotExpressionRule__OperandAssignment_1 ) )
            // InternalOptimisationLanguage.g:3005:2: ( rule__NotExpressionRule__OperandAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNotExpressionRuleAccess().getOperandAssignment_1()); 
            }
            // InternalOptimisationLanguage.g:3006:2: ( rule__NotExpressionRule__OperandAssignment_1 )
            // InternalOptimisationLanguage.g:3006:3: rule__NotExpressionRule__OperandAssignment_1
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
    // InternalOptimisationLanguage.g:3015:1: rule__ComparisonExpressionRule__Group__0 : rule__ComparisonExpressionRule__Group__0__Impl rule__ComparisonExpressionRule__Group__1 ;
    public final void rule__ComparisonExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3019:1: ( rule__ComparisonExpressionRule__Group__0__Impl rule__ComparisonExpressionRule__Group__1 )
            // InternalOptimisationLanguage.g:3020:2: rule__ComparisonExpressionRule__Group__0__Impl rule__ComparisonExpressionRule__Group__1
            {
            pushFollow(FOLLOW_22);
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
    // InternalOptimisationLanguage.g:3027:1: rule__ComparisonExpressionRule__Group__0__Impl : ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__ComparisonExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3031:1: ( ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalOptimisationLanguage.g:3032:1: ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalOptimisationLanguage.g:3032:1: ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) )
            // InternalOptimisationLanguage.g:3033:2: ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonExpressionRuleAccess().getLeftOperandAssignment_0()); 
            }
            // InternalOptimisationLanguage.g:3034:2: ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 )
            // InternalOptimisationLanguage.g:3034:3: rule__ComparisonExpressionRule__LeftOperandAssignment_0
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
    // InternalOptimisationLanguage.g:3042:1: rule__ComparisonExpressionRule__Group__1 : rule__ComparisonExpressionRule__Group__1__Impl ;
    public final void rule__ComparisonExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3046:1: ( rule__ComparisonExpressionRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:3047:2: rule__ComparisonExpressionRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:3053:1: rule__ComparisonExpressionRule__Group__1__Impl : ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* ) ;
    public final void rule__ComparisonExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3057:1: ( ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* ) )
            // InternalOptimisationLanguage.g:3058:1: ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* )
            {
            // InternalOptimisationLanguage.g:3058:1: ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* )
            // InternalOptimisationLanguage.g:3059:2: ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonExpressionRuleAccess().getComparisonAssignment_1()); 
            }
            // InternalOptimisationLanguage.g:3060:2: ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0>=16 && LA23_0<=21)) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:3060:3: rule__ComparisonExpressionRule__ComparisonAssignment_1
            	    {
            	    pushFollow(FOLLOW_23);
            	    rule__ComparisonExpressionRule__ComparisonAssignment_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop23;
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
    // InternalOptimisationLanguage.g:3069:1: rule__PartialComparisonExpressionRule__Group__0 : rule__PartialComparisonExpressionRule__Group__0__Impl rule__PartialComparisonExpressionRule__Group__1 ;
    public final void rule__PartialComparisonExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3073:1: ( rule__PartialComparisonExpressionRule__Group__0__Impl rule__PartialComparisonExpressionRule__Group__1 )
            // InternalOptimisationLanguage.g:3074:2: rule__PartialComparisonExpressionRule__Group__0__Impl rule__PartialComparisonExpressionRule__Group__1
            {
            pushFollow(FOLLOW_17);
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
    // InternalOptimisationLanguage.g:3081:1: rule__PartialComparisonExpressionRule__Group__0__Impl : ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) ) ;
    public final void rule__PartialComparisonExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3085:1: ( ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) ) )
            // InternalOptimisationLanguage.g:3086:1: ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) )
            {
            // InternalOptimisationLanguage.g:3086:1: ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) )
            // InternalOptimisationLanguage.g:3087:2: ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartialComparisonExpressionRuleAccess().getOperatorAssignment_0()); 
            }
            // InternalOptimisationLanguage.g:3088:2: ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 )
            // InternalOptimisationLanguage.g:3088:3: rule__PartialComparisonExpressionRule__OperatorAssignment_0
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
    // InternalOptimisationLanguage.g:3096:1: rule__PartialComparisonExpressionRule__Group__1 : rule__PartialComparisonExpressionRule__Group__1__Impl ;
    public final void rule__PartialComparisonExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3100:1: ( rule__PartialComparisonExpressionRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:3101:2: rule__PartialComparisonExpressionRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:3107:1: rule__PartialComparisonExpressionRule__Group__1__Impl : ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) ) ;
    public final void rule__PartialComparisonExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3111:1: ( ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) ) )
            // InternalOptimisationLanguage.g:3112:1: ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) )
            {
            // InternalOptimisationLanguage.g:3112:1: ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) )
            // InternalOptimisationLanguage.g:3113:2: ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartialComparisonExpressionRuleAccess().getSubExpressionAssignment_1()); 
            }
            // InternalOptimisationLanguage.g:3114:2: ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 )
            // InternalOptimisationLanguage.g:3114:3: rule__PartialComparisonExpressionRule__SubExpressionAssignment_1
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
    // InternalOptimisationLanguage.g:3123:1: rule__AddOrSubtractExpressionRule__Group__0 : rule__AddOrSubtractExpressionRule__Group__0__Impl rule__AddOrSubtractExpressionRule__Group__1 ;
    public final void rule__AddOrSubtractExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3127:1: ( rule__AddOrSubtractExpressionRule__Group__0__Impl rule__AddOrSubtractExpressionRule__Group__1 )
            // InternalOptimisationLanguage.g:3128:2: rule__AddOrSubtractExpressionRule__Group__0__Impl rule__AddOrSubtractExpressionRule__Group__1
            {
            pushFollow(FOLLOW_24);
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
    // InternalOptimisationLanguage.g:3135:1: rule__AddOrSubtractExpressionRule__Group__0__Impl : ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__AddOrSubtractExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3139:1: ( ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalOptimisationLanguage.g:3140:1: ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalOptimisationLanguage.g:3140:1: ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) )
            // InternalOptimisationLanguage.g:3141:2: ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getLeftOperandAssignment_0()); 
            }
            // InternalOptimisationLanguage.g:3142:2: ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 )
            // InternalOptimisationLanguage.g:3142:3: rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0
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
    // InternalOptimisationLanguage.g:3150:1: rule__AddOrSubtractExpressionRule__Group__1 : rule__AddOrSubtractExpressionRule__Group__1__Impl ;
    public final void rule__AddOrSubtractExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3154:1: ( rule__AddOrSubtractExpressionRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:3155:2: rule__AddOrSubtractExpressionRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:3161:1: rule__AddOrSubtractExpressionRule__Group__1__Impl : ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* ) ;
    public final void rule__AddOrSubtractExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3165:1: ( ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* ) )
            // InternalOptimisationLanguage.g:3166:1: ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* )
            {
            // InternalOptimisationLanguage.g:3166:1: ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* )
            // InternalOptimisationLanguage.g:3167:2: ( rule__AddOrSubtractExpressionRule__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getGroup_1()); 
            }
            // InternalOptimisationLanguage.g:3168:2: ( rule__AddOrSubtractExpressionRule__Group_1__0 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0>=22 && LA24_0<=23)) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:3168:3: rule__AddOrSubtractExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_25);
            	    rule__AddOrSubtractExpressionRule__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop24;
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
    // InternalOptimisationLanguage.g:3177:1: rule__AddOrSubtractExpressionRule__Group_1__0 : rule__AddOrSubtractExpressionRule__Group_1__0__Impl rule__AddOrSubtractExpressionRule__Group_1__1 ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3181:1: ( rule__AddOrSubtractExpressionRule__Group_1__0__Impl rule__AddOrSubtractExpressionRule__Group_1__1 )
            // InternalOptimisationLanguage.g:3182:2: rule__AddOrSubtractExpressionRule__Group_1__0__Impl rule__AddOrSubtractExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_17);
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
    // InternalOptimisationLanguage.g:3189:1: rule__AddOrSubtractExpressionRule__Group_1__0__Impl : ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) ) ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3193:1: ( ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) ) )
            // InternalOptimisationLanguage.g:3194:1: ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) )
            {
            // InternalOptimisationLanguage.g:3194:1: ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) )
            // InternalOptimisationLanguage.g:3195:2: ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperatorsAssignment_1_0()); 
            }
            // InternalOptimisationLanguage.g:3196:2: ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 )
            // InternalOptimisationLanguage.g:3196:3: rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0
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
    // InternalOptimisationLanguage.g:3204:1: rule__AddOrSubtractExpressionRule__Group_1__1 : rule__AddOrSubtractExpressionRule__Group_1__1__Impl ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3208:1: ( rule__AddOrSubtractExpressionRule__Group_1__1__Impl )
            // InternalOptimisationLanguage.g:3209:2: rule__AddOrSubtractExpressionRule__Group_1__1__Impl
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
    // InternalOptimisationLanguage.g:3215:1: rule__AddOrSubtractExpressionRule__Group_1__1__Impl : ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) ) ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3219:1: ( ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) ) )
            // InternalOptimisationLanguage.g:3220:1: ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) )
            {
            // InternalOptimisationLanguage.g:3220:1: ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) )
            // InternalOptimisationLanguage.g:3221:2: ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperandsAssignment_1_1()); 
            }
            // InternalOptimisationLanguage.g:3222:2: ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 )
            // InternalOptimisationLanguage.g:3222:3: rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1
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
    // InternalOptimisationLanguage.g:3231:1: rule__MultiplyDivideModuloExpressionRule__Group__0 : rule__MultiplyDivideModuloExpressionRule__Group__0__Impl rule__MultiplyDivideModuloExpressionRule__Group__1 ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3235:1: ( rule__MultiplyDivideModuloExpressionRule__Group__0__Impl rule__MultiplyDivideModuloExpressionRule__Group__1 )
            // InternalOptimisationLanguage.g:3236:2: rule__MultiplyDivideModuloExpressionRule__Group__0__Impl rule__MultiplyDivideModuloExpressionRule__Group__1
            {
            pushFollow(FOLLOW_26);
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
    // InternalOptimisationLanguage.g:3243:1: rule__MultiplyDivideModuloExpressionRule__Group__0__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3247:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalOptimisationLanguage.g:3248:1: ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalOptimisationLanguage.g:3248:1: ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) )
            // InternalOptimisationLanguage.g:3249:2: ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getLeftOperandAssignment_0()); 
            }
            // InternalOptimisationLanguage.g:3250:2: ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 )
            // InternalOptimisationLanguage.g:3250:3: rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0
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
    // InternalOptimisationLanguage.g:3258:1: rule__MultiplyDivideModuloExpressionRule__Group__1 : rule__MultiplyDivideModuloExpressionRule__Group__1__Impl ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3262:1: ( rule__MultiplyDivideModuloExpressionRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:3263:2: rule__MultiplyDivideModuloExpressionRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:3269:1: rule__MultiplyDivideModuloExpressionRule__Group__1__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3273:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* ) )
            // InternalOptimisationLanguage.g:3274:1: ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* )
            {
            // InternalOptimisationLanguage.g:3274:1: ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* )
            // InternalOptimisationLanguage.g:3275:2: ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getGroup_1()); 
            }
            // InternalOptimisationLanguage.g:3276:2: ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0>=24 && LA25_0<=26)) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:3276:3: rule__MultiplyDivideModuloExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_27);
            	    rule__MultiplyDivideModuloExpressionRule__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop25;
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
    // InternalOptimisationLanguage.g:3285:1: rule__MultiplyDivideModuloExpressionRule__Group_1__0 : rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl rule__MultiplyDivideModuloExpressionRule__Group_1__1 ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3289:1: ( rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl rule__MultiplyDivideModuloExpressionRule__Group_1__1 )
            // InternalOptimisationLanguage.g:3290:2: rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl rule__MultiplyDivideModuloExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_17);
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
    // InternalOptimisationLanguage.g:3297:1: rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3301:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) ) )
            // InternalOptimisationLanguage.g:3302:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) )
            {
            // InternalOptimisationLanguage.g:3302:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) )
            // InternalOptimisationLanguage.g:3303:2: ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperatorsAssignment_1_0()); 
            }
            // InternalOptimisationLanguage.g:3304:2: ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 )
            // InternalOptimisationLanguage.g:3304:3: rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0
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
    // InternalOptimisationLanguage.g:3312:1: rule__MultiplyDivideModuloExpressionRule__Group_1__1 : rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3316:1: ( rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl )
            // InternalOptimisationLanguage.g:3317:2: rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl
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
    // InternalOptimisationLanguage.g:3323:1: rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3327:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) ) )
            // InternalOptimisationLanguage.g:3328:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) )
            {
            // InternalOptimisationLanguage.g:3328:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) )
            // InternalOptimisationLanguage.g:3329:2: ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperandsAssignment_1_1()); 
            }
            // InternalOptimisationLanguage.g:3330:2: ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 )
            // InternalOptimisationLanguage.g:3330:3: rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1
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
    // InternalOptimisationLanguage.g:3339:1: rule__PowerOfExpressionRule__Group__0 : rule__PowerOfExpressionRule__Group__0__Impl rule__PowerOfExpressionRule__Group__1 ;
    public final void rule__PowerOfExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3343:1: ( rule__PowerOfExpressionRule__Group__0__Impl rule__PowerOfExpressionRule__Group__1 )
            // InternalOptimisationLanguage.g:3344:2: rule__PowerOfExpressionRule__Group__0__Impl rule__PowerOfExpressionRule__Group__1
            {
            pushFollow(FOLLOW_28);
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
    // InternalOptimisationLanguage.g:3351:1: rule__PowerOfExpressionRule__Group__0__Impl : ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__PowerOfExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3355:1: ( ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalOptimisationLanguage.g:3356:1: ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalOptimisationLanguage.g:3356:1: ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) )
            // InternalOptimisationLanguage.g:3357:2: ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPowerOfExpressionRuleAccess().getLeftOperandAssignment_0()); 
            }
            // InternalOptimisationLanguage.g:3358:2: ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 )
            // InternalOptimisationLanguage.g:3358:3: rule__PowerOfExpressionRule__LeftOperandAssignment_0
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
    // InternalOptimisationLanguage.g:3366:1: rule__PowerOfExpressionRule__Group__1 : rule__PowerOfExpressionRule__Group__1__Impl ;
    public final void rule__PowerOfExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3370:1: ( rule__PowerOfExpressionRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:3371:2: rule__PowerOfExpressionRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:3377:1: rule__PowerOfExpressionRule__Group__1__Impl : ( ( rule__PowerOfExpressionRule__Group_1__0 )? ) ;
    public final void rule__PowerOfExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3381:1: ( ( ( rule__PowerOfExpressionRule__Group_1__0 )? ) )
            // InternalOptimisationLanguage.g:3382:1: ( ( rule__PowerOfExpressionRule__Group_1__0 )? )
            {
            // InternalOptimisationLanguage.g:3382:1: ( ( rule__PowerOfExpressionRule__Group_1__0 )? )
            // InternalOptimisationLanguage.g:3383:2: ( rule__PowerOfExpressionRule__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPowerOfExpressionRuleAccess().getGroup_1()); 
            }
            // InternalOptimisationLanguage.g:3384:2: ( rule__PowerOfExpressionRule__Group_1__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==60) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalOptimisationLanguage.g:3384:3: rule__PowerOfExpressionRule__Group_1__0
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
    // InternalOptimisationLanguage.g:3393:1: rule__PowerOfExpressionRule__Group_1__0 : rule__PowerOfExpressionRule__Group_1__0__Impl rule__PowerOfExpressionRule__Group_1__1 ;
    public final void rule__PowerOfExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3397:1: ( rule__PowerOfExpressionRule__Group_1__0__Impl rule__PowerOfExpressionRule__Group_1__1 )
            // InternalOptimisationLanguage.g:3398:2: rule__PowerOfExpressionRule__Group_1__0__Impl rule__PowerOfExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_17);
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
    // InternalOptimisationLanguage.g:3405:1: rule__PowerOfExpressionRule__Group_1__0__Impl : ( '^' ) ;
    public final void rule__PowerOfExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3409:1: ( ( '^' ) )
            // InternalOptimisationLanguage.g:3410:1: ( '^' )
            {
            // InternalOptimisationLanguage.g:3410:1: ( '^' )
            // InternalOptimisationLanguage.g:3411:2: '^'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPowerOfExpressionRuleAccess().getCircumflexAccentKeyword_1_0()); 
            }
            match(input,60,FOLLOW_2); if (state.failed) return ;
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
    // InternalOptimisationLanguage.g:3420:1: rule__PowerOfExpressionRule__Group_1__1 : rule__PowerOfExpressionRule__Group_1__1__Impl ;
    public final void rule__PowerOfExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3424:1: ( rule__PowerOfExpressionRule__Group_1__1__Impl )
            // InternalOptimisationLanguage.g:3425:2: rule__PowerOfExpressionRule__Group_1__1__Impl
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
    // InternalOptimisationLanguage.g:3431:1: rule__PowerOfExpressionRule__Group_1__1__Impl : ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) ) ;
    public final void rule__PowerOfExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3435:1: ( ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) ) )
            // InternalOptimisationLanguage.g:3436:1: ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) )
            {
            // InternalOptimisationLanguage.g:3436:1: ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) )
            // InternalOptimisationLanguage.g:3437:2: ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPowerOfExpressionRuleAccess().getRightOperandAssignment_1_1()); 
            }
            // InternalOptimisationLanguage.g:3438:2: ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 )
            // InternalOptimisationLanguage.g:3438:3: rule__PowerOfExpressionRule__RightOperandAssignment_1_1
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
    // InternalOptimisationLanguage.g:3447:1: rule__UnaryAddOrSubtractExpressionRule__Group__0 : rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl rule__UnaryAddOrSubtractExpressionRule__Group__1 ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3451:1: ( rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl rule__UnaryAddOrSubtractExpressionRule__Group__1 )
            // InternalOptimisationLanguage.g:3452:2: rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl rule__UnaryAddOrSubtractExpressionRule__Group__1
            {
            pushFollow(FOLLOW_17);
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
    // InternalOptimisationLanguage.g:3459:1: rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl : ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3463:1: ( ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* ) )
            // InternalOptimisationLanguage.g:3464:1: ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* )
            {
            // InternalOptimisationLanguage.g:3464:1: ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* )
            // InternalOptimisationLanguage.g:3465:2: ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getOperatorsAssignment_0()); 
            }
            // InternalOptimisationLanguage.g:3466:2: ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( ((LA27_0>=22 && LA27_0<=23)) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:3466:3: rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0
            	    {
            	    pushFollow(FOLLOW_25);
            	    rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop27;
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
    // InternalOptimisationLanguage.g:3474:1: rule__UnaryAddOrSubtractExpressionRule__Group__1 : rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3478:1: ( rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:3479:2: rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:3485:1: rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl : ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3489:1: ( ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) ) )
            // InternalOptimisationLanguage.g:3490:1: ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) )
            {
            // InternalOptimisationLanguage.g:3490:1: ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) )
            // InternalOptimisationLanguage.g:3491:2: ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getSubExpressionAssignment_1()); 
            }
            // InternalOptimisationLanguage.g:3492:2: ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 )
            // InternalOptimisationLanguage.g:3492:3: rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1
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
    // InternalOptimisationLanguage.g:3501:1: rule__ArrayRule__Group__0 : rule__ArrayRule__Group__0__Impl rule__ArrayRule__Group__1 ;
    public final void rule__ArrayRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3505:1: ( rule__ArrayRule__Group__0__Impl rule__ArrayRule__Group__1 )
            // InternalOptimisationLanguage.g:3506:2: rule__ArrayRule__Group__0__Impl rule__ArrayRule__Group__1
            {
            pushFollow(FOLLOW_11);
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
    // InternalOptimisationLanguage.g:3513:1: rule__ArrayRule__Group__0__Impl : ( () ) ;
    public final void rule__ArrayRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3517:1: ( ( () ) )
            // InternalOptimisationLanguage.g:3518:1: ( () )
            {
            // InternalOptimisationLanguage.g:3518:1: ( () )
            // InternalOptimisationLanguage.g:3519:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayRuleAccess().getArrayAction_0()); 
            }
            // InternalOptimisationLanguage.g:3520:2: ()
            // InternalOptimisationLanguage.g:3520:3: 
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
    // InternalOptimisationLanguage.g:3528:1: rule__ArrayRule__Group__1 : rule__ArrayRule__Group__1__Impl rule__ArrayRule__Group__2 ;
    public final void rule__ArrayRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3532:1: ( rule__ArrayRule__Group__1__Impl rule__ArrayRule__Group__2 )
            // InternalOptimisationLanguage.g:3533:2: rule__ArrayRule__Group__1__Impl rule__ArrayRule__Group__2
            {
            pushFollow(FOLLOW_29);
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
    // InternalOptimisationLanguage.g:3540:1: rule__ArrayRule__Group__1__Impl : ( '[' ) ;
    public final void rule__ArrayRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3544:1: ( ( '[' ) )
            // InternalOptimisationLanguage.g:3545:1: ( '[' )
            {
            // InternalOptimisationLanguage.g:3545:1: ( '[' )
            // InternalOptimisationLanguage.g:3546:2: '['
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayRuleAccess().getLeftSquareBracketKeyword_1()); 
            }
            match(input,61,FOLLOW_2); if (state.failed) return ;
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
    // InternalOptimisationLanguage.g:3555:1: rule__ArrayRule__Group__2 : rule__ArrayRule__Group__2__Impl rule__ArrayRule__Group__3 ;
    public final void rule__ArrayRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3559:1: ( rule__ArrayRule__Group__2__Impl rule__ArrayRule__Group__3 )
            // InternalOptimisationLanguage.g:3560:2: rule__ArrayRule__Group__2__Impl rule__ArrayRule__Group__3
            {
            pushFollow(FOLLOW_29);
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
    // InternalOptimisationLanguage.g:3567:1: rule__ArrayRule__Group__2__Impl : ( ( rule__ArrayRule__Group_2__0 )? ) ;
    public final void rule__ArrayRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3571:1: ( ( ( rule__ArrayRule__Group_2__0 )? ) )
            // InternalOptimisationLanguage.g:3572:1: ( ( rule__ArrayRule__Group_2__0 )? )
            {
            // InternalOptimisationLanguage.g:3572:1: ( ( rule__ArrayRule__Group_2__0 )? )
            // InternalOptimisationLanguage.g:3573:2: ( rule__ArrayRule__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayRuleAccess().getGroup_2()); 
            }
            // InternalOptimisationLanguage.g:3574:2: ( rule__ArrayRule__Group_2__0 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( ((LA28_0>=RULE_QUOTED_ID && LA28_0<=RULE_STRING)||LA28_0==15||LA28_0==56||LA28_0==61||LA28_0==64||LA28_0==83) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalOptimisationLanguage.g:3574:3: rule__ArrayRule__Group_2__0
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
    // InternalOptimisationLanguage.g:3582:1: rule__ArrayRule__Group__3 : rule__ArrayRule__Group__3__Impl ;
    public final void rule__ArrayRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3586:1: ( rule__ArrayRule__Group__3__Impl )
            // InternalOptimisationLanguage.g:3587:2: rule__ArrayRule__Group__3__Impl
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
    // InternalOptimisationLanguage.g:3593:1: rule__ArrayRule__Group__3__Impl : ( ']' ) ;
    public final void rule__ArrayRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3597:1: ( ( ']' ) )
            // InternalOptimisationLanguage.g:3598:1: ( ']' )
            {
            // InternalOptimisationLanguage.g:3598:1: ( ']' )
            // InternalOptimisationLanguage.g:3599:2: ']'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayRuleAccess().getRightSquareBracketKeyword_3()); 
            }
            match(input,62,FOLLOW_2); if (state.failed) return ;
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
    // InternalOptimisationLanguage.g:3609:1: rule__ArrayRule__Group_2__0 : rule__ArrayRule__Group_2__0__Impl rule__ArrayRule__Group_2__1 ;
    public final void rule__ArrayRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3613:1: ( rule__ArrayRule__Group_2__0__Impl rule__ArrayRule__Group_2__1 )
            // InternalOptimisationLanguage.g:3614:2: rule__ArrayRule__Group_2__0__Impl rule__ArrayRule__Group_2__1
            {
            pushFollow(FOLLOW_30);
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
    // InternalOptimisationLanguage.g:3621:1: rule__ArrayRule__Group_2__0__Impl : ( ( rule__ArrayRule__ValuesAssignment_2_0 ) ) ;
    public final void rule__ArrayRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3625:1: ( ( ( rule__ArrayRule__ValuesAssignment_2_0 ) ) )
            // InternalOptimisationLanguage.g:3626:1: ( ( rule__ArrayRule__ValuesAssignment_2_0 ) )
            {
            // InternalOptimisationLanguage.g:3626:1: ( ( rule__ArrayRule__ValuesAssignment_2_0 ) )
            // InternalOptimisationLanguage.g:3627:2: ( rule__ArrayRule__ValuesAssignment_2_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayRuleAccess().getValuesAssignment_2_0()); 
            }
            // InternalOptimisationLanguage.g:3628:2: ( rule__ArrayRule__ValuesAssignment_2_0 )
            // InternalOptimisationLanguage.g:3628:3: rule__ArrayRule__ValuesAssignment_2_0
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
    // InternalOptimisationLanguage.g:3636:1: rule__ArrayRule__Group_2__1 : rule__ArrayRule__Group_2__1__Impl ;
    public final void rule__ArrayRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3640:1: ( rule__ArrayRule__Group_2__1__Impl )
            // InternalOptimisationLanguage.g:3641:2: rule__ArrayRule__Group_2__1__Impl
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
    // InternalOptimisationLanguage.g:3647:1: rule__ArrayRule__Group_2__1__Impl : ( ( rule__ArrayRule__Group_2_1__0 )* ) ;
    public final void rule__ArrayRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3651:1: ( ( ( rule__ArrayRule__Group_2_1__0 )* ) )
            // InternalOptimisationLanguage.g:3652:1: ( ( rule__ArrayRule__Group_2_1__0 )* )
            {
            // InternalOptimisationLanguage.g:3652:1: ( ( rule__ArrayRule__Group_2_1__0 )* )
            // InternalOptimisationLanguage.g:3653:2: ( rule__ArrayRule__Group_2_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayRuleAccess().getGroup_2_1()); 
            }
            // InternalOptimisationLanguage.g:3654:2: ( rule__ArrayRule__Group_2_1__0 )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==63) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:3654:3: rule__ArrayRule__Group_2_1__0
            	    {
            	    pushFollow(FOLLOW_31);
            	    rule__ArrayRule__Group_2_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop29;
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
    // InternalOptimisationLanguage.g:3663:1: rule__ArrayRule__Group_2_1__0 : rule__ArrayRule__Group_2_1__0__Impl rule__ArrayRule__Group_2_1__1 ;
    public final void rule__ArrayRule__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3667:1: ( rule__ArrayRule__Group_2_1__0__Impl rule__ArrayRule__Group_2_1__1 )
            // InternalOptimisationLanguage.g:3668:2: rule__ArrayRule__Group_2_1__0__Impl rule__ArrayRule__Group_2_1__1
            {
            pushFollow(FOLLOW_17);
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
    // InternalOptimisationLanguage.g:3675:1: rule__ArrayRule__Group_2_1__0__Impl : ( ',' ) ;
    public final void rule__ArrayRule__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3679:1: ( ( ',' ) )
            // InternalOptimisationLanguage.g:3680:1: ( ',' )
            {
            // InternalOptimisationLanguage.g:3680:1: ( ',' )
            // InternalOptimisationLanguage.g:3681:2: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayRuleAccess().getCommaKeyword_2_1_0()); 
            }
            match(input,63,FOLLOW_2); if (state.failed) return ;
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
    // InternalOptimisationLanguage.g:3690:1: rule__ArrayRule__Group_2_1__1 : rule__ArrayRule__Group_2_1__1__Impl ;
    public final void rule__ArrayRule__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3694:1: ( rule__ArrayRule__Group_2_1__1__Impl )
            // InternalOptimisationLanguage.g:3695:2: rule__ArrayRule__Group_2_1__1__Impl
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
    // InternalOptimisationLanguage.g:3701:1: rule__ArrayRule__Group_2_1__1__Impl : ( ( rule__ArrayRule__ValuesAssignment_2_1_1 ) ) ;
    public final void rule__ArrayRule__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3705:1: ( ( ( rule__ArrayRule__ValuesAssignment_2_1_1 ) ) )
            // InternalOptimisationLanguage.g:3706:1: ( ( rule__ArrayRule__ValuesAssignment_2_1_1 ) )
            {
            // InternalOptimisationLanguage.g:3706:1: ( ( rule__ArrayRule__ValuesAssignment_2_1_1 ) )
            // InternalOptimisationLanguage.g:3707:2: ( rule__ArrayRule__ValuesAssignment_2_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayRuleAccess().getValuesAssignment_2_1_1()); 
            }
            // InternalOptimisationLanguage.g:3708:2: ( rule__ArrayRule__ValuesAssignment_2_1_1 )
            // InternalOptimisationLanguage.g:3708:3: rule__ArrayRule__ValuesAssignment_2_1_1
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
    // InternalOptimisationLanguage.g:3717:1: rule__ParanthesesRule__Group__0 : rule__ParanthesesRule__Group__0__Impl rule__ParanthesesRule__Group__1 ;
    public final void rule__ParanthesesRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3721:1: ( rule__ParanthesesRule__Group__0__Impl rule__ParanthesesRule__Group__1 )
            // InternalOptimisationLanguage.g:3722:2: rule__ParanthesesRule__Group__0__Impl rule__ParanthesesRule__Group__1
            {
            pushFollow(FOLLOW_17);
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
    // InternalOptimisationLanguage.g:3729:1: rule__ParanthesesRule__Group__0__Impl : ( '(' ) ;
    public final void rule__ParanthesesRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3733:1: ( ( '(' ) )
            // InternalOptimisationLanguage.g:3734:1: ( '(' )
            {
            // InternalOptimisationLanguage.g:3734:1: ( '(' )
            // InternalOptimisationLanguage.g:3735:2: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParanthesesRuleAccess().getLeftParenthesisKeyword_0()); 
            }
            match(input,64,FOLLOW_2); if (state.failed) return ;
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
    // InternalOptimisationLanguage.g:3744:1: rule__ParanthesesRule__Group__1 : rule__ParanthesesRule__Group__1__Impl rule__ParanthesesRule__Group__2 ;
    public final void rule__ParanthesesRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3748:1: ( rule__ParanthesesRule__Group__1__Impl rule__ParanthesesRule__Group__2 )
            // InternalOptimisationLanguage.g:3749:2: rule__ParanthesesRule__Group__1__Impl rule__ParanthesesRule__Group__2
            {
            pushFollow(FOLLOW_32);
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
    // InternalOptimisationLanguage.g:3756:1: rule__ParanthesesRule__Group__1__Impl : ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) ) ;
    public final void rule__ParanthesesRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3760:1: ( ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) ) )
            // InternalOptimisationLanguage.g:3761:1: ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) )
            {
            // InternalOptimisationLanguage.g:3761:1: ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) )
            // InternalOptimisationLanguage.g:3762:2: ( rule__ParanthesesRule__SubExpressionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParanthesesRuleAccess().getSubExpressionAssignment_1()); 
            }
            // InternalOptimisationLanguage.g:3763:2: ( rule__ParanthesesRule__SubExpressionAssignment_1 )
            // InternalOptimisationLanguage.g:3763:3: rule__ParanthesesRule__SubExpressionAssignment_1
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
    // InternalOptimisationLanguage.g:3771:1: rule__ParanthesesRule__Group__2 : rule__ParanthesesRule__Group__2__Impl ;
    public final void rule__ParanthesesRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3775:1: ( rule__ParanthesesRule__Group__2__Impl )
            // InternalOptimisationLanguage.g:3776:2: rule__ParanthesesRule__Group__2__Impl
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
    // InternalOptimisationLanguage.g:3782:1: rule__ParanthesesRule__Group__2__Impl : ( ')' ) ;
    public final void rule__ParanthesesRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3786:1: ( ( ')' ) )
            // InternalOptimisationLanguage.g:3787:1: ( ')' )
            {
            // InternalOptimisationLanguage.g:3787:1: ( ')' )
            // InternalOptimisationLanguage.g:3788:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParanthesesRuleAccess().getRightParenthesisKeyword_2()); 
            }
            match(input,65,FOLLOW_2); if (state.failed) return ;
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
    // InternalOptimisationLanguage.g:3798:1: rule__CallRule__Group__0 : rule__CallRule__Group__0__Impl rule__CallRule__Group__1 ;
    public final void rule__CallRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3802:1: ( rule__CallRule__Group__0__Impl rule__CallRule__Group__1 )
            // InternalOptimisationLanguage.g:3803:2: rule__CallRule__Group__0__Impl rule__CallRule__Group__1
            {
            pushFollow(FOLLOW_33);
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
    // InternalOptimisationLanguage.g:3810:1: rule__CallRule__Group__0__Impl : ( ( rule__CallRule__FunctionAssignment_0 ) ) ;
    public final void rule__CallRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3814:1: ( ( ( rule__CallRule__FunctionAssignment_0 ) ) )
            // InternalOptimisationLanguage.g:3815:1: ( ( rule__CallRule__FunctionAssignment_0 ) )
            {
            // InternalOptimisationLanguage.g:3815:1: ( ( rule__CallRule__FunctionAssignment_0 ) )
            // InternalOptimisationLanguage.g:3816:2: ( rule__CallRule__FunctionAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getFunctionAssignment_0()); 
            }
            // InternalOptimisationLanguage.g:3817:2: ( rule__CallRule__FunctionAssignment_0 )
            // InternalOptimisationLanguage.g:3817:3: rule__CallRule__FunctionAssignment_0
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
    // InternalOptimisationLanguage.g:3825:1: rule__CallRule__Group__1 : rule__CallRule__Group__1__Impl rule__CallRule__Group__2 ;
    public final void rule__CallRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3829:1: ( rule__CallRule__Group__1__Impl rule__CallRule__Group__2 )
            // InternalOptimisationLanguage.g:3830:2: rule__CallRule__Group__1__Impl rule__CallRule__Group__2
            {
            pushFollow(FOLLOW_34);
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
    // InternalOptimisationLanguage.g:3837:1: rule__CallRule__Group__1__Impl : ( '(' ) ;
    public final void rule__CallRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3841:1: ( ( '(' ) )
            // InternalOptimisationLanguage.g:3842:1: ( '(' )
            {
            // InternalOptimisationLanguage.g:3842:1: ( '(' )
            // InternalOptimisationLanguage.g:3843:2: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getLeftParenthesisKeyword_1()); 
            }
            match(input,64,FOLLOW_2); if (state.failed) return ;
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
    // InternalOptimisationLanguage.g:3852:1: rule__CallRule__Group__2 : rule__CallRule__Group__2__Impl rule__CallRule__Group__3 ;
    public final void rule__CallRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3856:1: ( rule__CallRule__Group__2__Impl rule__CallRule__Group__3 )
            // InternalOptimisationLanguage.g:3857:2: rule__CallRule__Group__2__Impl rule__CallRule__Group__3
            {
            pushFollow(FOLLOW_34);
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
    // InternalOptimisationLanguage.g:3864:1: rule__CallRule__Group__2__Impl : ( ( rule__CallRule__Group_2__0 )? ) ;
    public final void rule__CallRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3868:1: ( ( ( rule__CallRule__Group_2__0 )? ) )
            // InternalOptimisationLanguage.g:3869:1: ( ( rule__CallRule__Group_2__0 )? )
            {
            // InternalOptimisationLanguage.g:3869:1: ( ( rule__CallRule__Group_2__0 )? )
            // InternalOptimisationLanguage.g:3870:2: ( rule__CallRule__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getGroup_2()); 
            }
            // InternalOptimisationLanguage.g:3871:2: ( rule__CallRule__Group_2__0 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( ((LA30_0>=RULE_QUOTED_ID && LA30_0<=RULE_STRING)||LA30_0==15||(LA30_0>=22 && LA30_0<=23)||LA30_0==56||LA30_0==61||LA30_0==64||(LA30_0>=82 && LA30_0<=83)) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalOptimisationLanguage.g:3871:3: rule__CallRule__Group_2__0
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
    // InternalOptimisationLanguage.g:3879:1: rule__CallRule__Group__3 : rule__CallRule__Group__3__Impl ;
    public final void rule__CallRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3883:1: ( rule__CallRule__Group__3__Impl )
            // InternalOptimisationLanguage.g:3884:2: rule__CallRule__Group__3__Impl
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
    // InternalOptimisationLanguage.g:3890:1: rule__CallRule__Group__3__Impl : ( ')' ) ;
    public final void rule__CallRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3894:1: ( ( ')' ) )
            // InternalOptimisationLanguage.g:3895:1: ( ')' )
            {
            // InternalOptimisationLanguage.g:3895:1: ( ')' )
            // InternalOptimisationLanguage.g:3896:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getRightParenthesisKeyword_3()); 
            }
            match(input,65,FOLLOW_2); if (state.failed) return ;
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
    // InternalOptimisationLanguage.g:3906:1: rule__CallRule__Group_2__0 : rule__CallRule__Group_2__0__Impl rule__CallRule__Group_2__1 ;
    public final void rule__CallRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3910:1: ( rule__CallRule__Group_2__0__Impl rule__CallRule__Group_2__1 )
            // InternalOptimisationLanguage.g:3911:2: rule__CallRule__Group_2__0__Impl rule__CallRule__Group_2__1
            {
            pushFollow(FOLLOW_30);
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
    // InternalOptimisationLanguage.g:3918:1: rule__CallRule__Group_2__0__Impl : ( ( rule__CallRule__ParametersAssignment_2_0 ) ) ;
    public final void rule__CallRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3922:1: ( ( ( rule__CallRule__ParametersAssignment_2_0 ) ) )
            // InternalOptimisationLanguage.g:3923:1: ( ( rule__CallRule__ParametersAssignment_2_0 ) )
            {
            // InternalOptimisationLanguage.g:3923:1: ( ( rule__CallRule__ParametersAssignment_2_0 ) )
            // InternalOptimisationLanguage.g:3924:2: ( rule__CallRule__ParametersAssignment_2_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getParametersAssignment_2_0()); 
            }
            // InternalOptimisationLanguage.g:3925:2: ( rule__CallRule__ParametersAssignment_2_0 )
            // InternalOptimisationLanguage.g:3925:3: rule__CallRule__ParametersAssignment_2_0
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
    // InternalOptimisationLanguage.g:3933:1: rule__CallRule__Group_2__1 : rule__CallRule__Group_2__1__Impl ;
    public final void rule__CallRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3937:1: ( rule__CallRule__Group_2__1__Impl )
            // InternalOptimisationLanguage.g:3938:2: rule__CallRule__Group_2__1__Impl
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
    // InternalOptimisationLanguage.g:3944:1: rule__CallRule__Group_2__1__Impl : ( ( rule__CallRule__Group_2_1__0 )* ) ;
    public final void rule__CallRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3948:1: ( ( ( rule__CallRule__Group_2_1__0 )* ) )
            // InternalOptimisationLanguage.g:3949:1: ( ( rule__CallRule__Group_2_1__0 )* )
            {
            // InternalOptimisationLanguage.g:3949:1: ( ( rule__CallRule__Group_2_1__0 )* )
            // InternalOptimisationLanguage.g:3950:2: ( rule__CallRule__Group_2_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getGroup_2_1()); 
            }
            // InternalOptimisationLanguage.g:3951:2: ( rule__CallRule__Group_2_1__0 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==63) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:3951:3: rule__CallRule__Group_2_1__0
            	    {
            	    pushFollow(FOLLOW_31);
            	    rule__CallRule__Group_2_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop31;
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
    // InternalOptimisationLanguage.g:3960:1: rule__CallRule__Group_2_1__0 : rule__CallRule__Group_2_1__0__Impl rule__CallRule__Group_2_1__1 ;
    public final void rule__CallRule__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3964:1: ( rule__CallRule__Group_2_1__0__Impl rule__CallRule__Group_2_1__1 )
            // InternalOptimisationLanguage.g:3965:2: rule__CallRule__Group_2_1__0__Impl rule__CallRule__Group_2_1__1
            {
            pushFollow(FOLLOW_17);
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
    // InternalOptimisationLanguage.g:3972:1: rule__CallRule__Group_2_1__0__Impl : ( ',' ) ;
    public final void rule__CallRule__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3976:1: ( ( ',' ) )
            // InternalOptimisationLanguage.g:3977:1: ( ',' )
            {
            // InternalOptimisationLanguage.g:3977:1: ( ',' )
            // InternalOptimisationLanguage.g:3978:2: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getCommaKeyword_2_1_0()); 
            }
            match(input,63,FOLLOW_2); if (state.failed) return ;
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
    // InternalOptimisationLanguage.g:3987:1: rule__CallRule__Group_2_1__1 : rule__CallRule__Group_2_1__1__Impl ;
    public final void rule__CallRule__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3991:1: ( rule__CallRule__Group_2_1__1__Impl )
            // InternalOptimisationLanguage.g:3992:2: rule__CallRule__Group_2_1__1__Impl
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
    // InternalOptimisationLanguage.g:3998:1: rule__CallRule__Group_2_1__1__Impl : ( ( rule__CallRule__ParametersAssignment_2_1_1 ) ) ;
    public final void rule__CallRule__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4002:1: ( ( ( rule__CallRule__ParametersAssignment_2_1_1 ) ) )
            // InternalOptimisationLanguage.g:4003:1: ( ( rule__CallRule__ParametersAssignment_2_1_1 ) )
            {
            // InternalOptimisationLanguage.g:4003:1: ( ( rule__CallRule__ParametersAssignment_2_1_1 ) )
            // InternalOptimisationLanguage.g:4004:2: ( rule__CallRule__ParametersAssignment_2_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getParametersAssignment_2_1_1()); 
            }
            // InternalOptimisationLanguage.g:4005:2: ( rule__CallRule__ParametersAssignment_2_1_1 )
            // InternalOptimisationLanguage.g:4005:3: rule__CallRule__ParametersAssignment_2_1_1
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


    // $ANTLR start "rule__InstanceLiteralRule__Group__0"
    // InternalOptimisationLanguage.g:4014:1: rule__InstanceLiteralRule__Group__0 : rule__InstanceLiteralRule__Group__0__Impl rule__InstanceLiteralRule__Group__1 ;
    public final void rule__InstanceLiteralRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4018:1: ( rule__InstanceLiteralRule__Group__0__Impl rule__InstanceLiteralRule__Group__1 )
            // InternalOptimisationLanguage.g:4019:2: rule__InstanceLiteralRule__Group__0__Impl rule__InstanceLiteralRule__Group__1
            {
            pushFollow(FOLLOW_6);
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
    // InternalOptimisationLanguage.g:4026:1: rule__InstanceLiteralRule__Group__0__Impl : ( ( rule__InstanceLiteralRule__DefinitionAssignment_0 ) ) ;
    public final void rule__InstanceLiteralRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4030:1: ( ( ( rule__InstanceLiteralRule__DefinitionAssignment_0 ) ) )
            // InternalOptimisationLanguage.g:4031:1: ( ( rule__InstanceLiteralRule__DefinitionAssignment_0 ) )
            {
            // InternalOptimisationLanguage.g:4031:1: ( ( rule__InstanceLiteralRule__DefinitionAssignment_0 ) )
            // InternalOptimisationLanguage.g:4032:2: ( rule__InstanceLiteralRule__DefinitionAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceLiteralRuleAccess().getDefinitionAssignment_0()); 
            }
            // InternalOptimisationLanguage.g:4033:2: ( rule__InstanceLiteralRule__DefinitionAssignment_0 )
            // InternalOptimisationLanguage.g:4033:3: rule__InstanceLiteralRule__DefinitionAssignment_0
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
    // InternalOptimisationLanguage.g:4041:1: rule__InstanceLiteralRule__Group__1 : rule__InstanceLiteralRule__Group__1__Impl rule__InstanceLiteralRule__Group__2 ;
    public final void rule__InstanceLiteralRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4045:1: ( rule__InstanceLiteralRule__Group__1__Impl rule__InstanceLiteralRule__Group__2 )
            // InternalOptimisationLanguage.g:4046:2: rule__InstanceLiteralRule__Group__1__Impl rule__InstanceLiteralRule__Group__2
            {
            pushFollow(FOLLOW_35);
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
    // InternalOptimisationLanguage.g:4053:1: rule__InstanceLiteralRule__Group__1__Impl : ( '{' ) ;
    public final void rule__InstanceLiteralRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4057:1: ( ( '{' ) )
            // InternalOptimisationLanguage.g:4058:1: ( '{' )
            {
            // InternalOptimisationLanguage.g:4058:1: ( '{' )
            // InternalOptimisationLanguage.g:4059:2: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceLiteralRuleAccess().getLeftCurlyBracketKeyword_1()); 
            }
            match(input,48,FOLLOW_2); if (state.failed) return ;
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
    // InternalOptimisationLanguage.g:4068:1: rule__InstanceLiteralRule__Group__2 : rule__InstanceLiteralRule__Group__2__Impl rule__InstanceLiteralRule__Group__3 ;
    public final void rule__InstanceLiteralRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4072:1: ( rule__InstanceLiteralRule__Group__2__Impl rule__InstanceLiteralRule__Group__3 )
            // InternalOptimisationLanguage.g:4073:2: rule__InstanceLiteralRule__Group__2__Impl rule__InstanceLiteralRule__Group__3
            {
            pushFollow(FOLLOW_35);
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
    // InternalOptimisationLanguage.g:4080:1: rule__InstanceLiteralRule__Group__2__Impl : ( ( rule__InstanceLiteralRule__AttributesAssignment_2 )* ) ;
    public final void rule__InstanceLiteralRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4084:1: ( ( ( rule__InstanceLiteralRule__AttributesAssignment_2 )* ) )
            // InternalOptimisationLanguage.g:4085:1: ( ( rule__InstanceLiteralRule__AttributesAssignment_2 )* )
            {
            // InternalOptimisationLanguage.g:4085:1: ( ( rule__InstanceLiteralRule__AttributesAssignment_2 )* )
            // InternalOptimisationLanguage.g:4086:2: ( rule__InstanceLiteralRule__AttributesAssignment_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceLiteralRuleAccess().getAttributesAssignment_2()); 
            }
            // InternalOptimisationLanguage.g:4087:2: ( rule__InstanceLiteralRule__AttributesAssignment_2 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( ((LA32_0>=RULE_QUOTED_ID && LA32_0<=RULE_ID)) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:4087:3: rule__InstanceLiteralRule__AttributesAssignment_2
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__InstanceLiteralRule__AttributesAssignment_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop32;
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
    // InternalOptimisationLanguage.g:4095:1: rule__InstanceLiteralRule__Group__3 : rule__InstanceLiteralRule__Group__3__Impl ;
    public final void rule__InstanceLiteralRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4099:1: ( rule__InstanceLiteralRule__Group__3__Impl )
            // InternalOptimisationLanguage.g:4100:2: rule__InstanceLiteralRule__Group__3__Impl
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
    // InternalOptimisationLanguage.g:4106:1: rule__InstanceLiteralRule__Group__3__Impl : ( '}' ) ;
    public final void rule__InstanceLiteralRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4110:1: ( ( '}' ) )
            // InternalOptimisationLanguage.g:4111:1: ( '}' )
            {
            // InternalOptimisationLanguage.g:4111:1: ( '}' )
            // InternalOptimisationLanguage.g:4112:2: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceLiteralRuleAccess().getRightCurlyBracketKeyword_3()); 
            }
            match(input,49,FOLLOW_2); if (state.failed) return ;
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
    // InternalOptimisationLanguage.g:4122:1: rule__AttributeRule__Group__0 : rule__AttributeRule__Group__0__Impl rule__AttributeRule__Group__1 ;
    public final void rule__AttributeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4126:1: ( rule__AttributeRule__Group__0__Impl rule__AttributeRule__Group__1 )
            // InternalOptimisationLanguage.g:4127:2: rule__AttributeRule__Group__0__Impl rule__AttributeRule__Group__1
            {
            pushFollow(FOLLOW_10);
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
    // InternalOptimisationLanguage.g:4134:1: rule__AttributeRule__Group__0__Impl : ( ( rule__AttributeRule__DefinitionAssignment_0 ) ) ;
    public final void rule__AttributeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4138:1: ( ( ( rule__AttributeRule__DefinitionAssignment_0 ) ) )
            // InternalOptimisationLanguage.g:4139:1: ( ( rule__AttributeRule__DefinitionAssignment_0 ) )
            {
            // InternalOptimisationLanguage.g:4139:1: ( ( rule__AttributeRule__DefinitionAssignment_0 ) )
            // InternalOptimisationLanguage.g:4140:2: ( rule__AttributeRule__DefinitionAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeRuleAccess().getDefinitionAssignment_0()); 
            }
            // InternalOptimisationLanguage.g:4141:2: ( rule__AttributeRule__DefinitionAssignment_0 )
            // InternalOptimisationLanguage.g:4141:3: rule__AttributeRule__DefinitionAssignment_0
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
    // InternalOptimisationLanguage.g:4149:1: rule__AttributeRule__Group__1 : rule__AttributeRule__Group__1__Impl rule__AttributeRule__Group__2 ;
    public final void rule__AttributeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4153:1: ( rule__AttributeRule__Group__1__Impl rule__AttributeRule__Group__2 )
            // InternalOptimisationLanguage.g:4154:2: rule__AttributeRule__Group__1__Impl rule__AttributeRule__Group__2
            {
            pushFollow(FOLLOW_17);
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
    // InternalOptimisationLanguage.g:4161:1: rule__AttributeRule__Group__1__Impl : ( ':=' ) ;
    public final void rule__AttributeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4165:1: ( ( ':=' ) )
            // InternalOptimisationLanguage.g:4166:1: ( ':=' )
            {
            // InternalOptimisationLanguage.g:4166:1: ( ':=' )
            // InternalOptimisationLanguage.g:4167:2: ':='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeRuleAccess().getColonEqualsSignKeyword_1()); 
            }
            match(input,52,FOLLOW_2); if (state.failed) return ;
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
    // InternalOptimisationLanguage.g:4176:1: rule__AttributeRule__Group__2 : rule__AttributeRule__Group__2__Impl rule__AttributeRule__Group__3 ;
    public final void rule__AttributeRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4180:1: ( rule__AttributeRule__Group__2__Impl rule__AttributeRule__Group__3 )
            // InternalOptimisationLanguage.g:4181:2: rule__AttributeRule__Group__2__Impl rule__AttributeRule__Group__3
            {
            pushFollow(FOLLOW_12);
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
    // InternalOptimisationLanguage.g:4188:1: rule__AttributeRule__Group__2__Impl : ( ( rule__AttributeRule__ValueAssignment_2 ) ) ;
    public final void rule__AttributeRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4192:1: ( ( ( rule__AttributeRule__ValueAssignment_2 ) ) )
            // InternalOptimisationLanguage.g:4193:1: ( ( rule__AttributeRule__ValueAssignment_2 ) )
            {
            // InternalOptimisationLanguage.g:4193:1: ( ( rule__AttributeRule__ValueAssignment_2 ) )
            // InternalOptimisationLanguage.g:4194:2: ( rule__AttributeRule__ValueAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeRuleAccess().getValueAssignment_2()); 
            }
            // InternalOptimisationLanguage.g:4195:2: ( rule__AttributeRule__ValueAssignment_2 )
            // InternalOptimisationLanguage.g:4195:3: rule__AttributeRule__ValueAssignment_2
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
    // InternalOptimisationLanguage.g:4203:1: rule__AttributeRule__Group__3 : rule__AttributeRule__Group__3__Impl ;
    public final void rule__AttributeRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4207:1: ( rule__AttributeRule__Group__3__Impl )
            // InternalOptimisationLanguage.g:4208:2: rule__AttributeRule__Group__3__Impl
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
    // InternalOptimisationLanguage.g:4214:1: rule__AttributeRule__Group__3__Impl : ( ';' ) ;
    public final void rule__AttributeRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4218:1: ( ( ';' ) )
            // InternalOptimisationLanguage.g:4219:1: ( ';' )
            {
            // InternalOptimisationLanguage.g:4219:1: ( ';' )
            // InternalOptimisationLanguage.g:4220:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeRuleAccess().getSemicolonKeyword_3()); 
            }
            match(input,53,FOLLOW_2); if (state.failed) return ;
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
    // InternalOptimisationLanguage.g:4230:1: rule__RealLiteralRule__Group__0 : rule__RealLiteralRule__Group__0__Impl rule__RealLiteralRule__Group__1 ;
    public final void rule__RealLiteralRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4234:1: ( rule__RealLiteralRule__Group__0__Impl rule__RealLiteralRule__Group__1 )
            // InternalOptimisationLanguage.g:4235:2: rule__RealLiteralRule__Group__0__Impl rule__RealLiteralRule__Group__1
            {
            pushFollow(FOLLOW_36);
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
    // InternalOptimisationLanguage.g:4242:1: rule__RealLiteralRule__Group__0__Impl : ( ( rule__RealLiteralRule__LiteralAssignment_0 ) ) ;
    public final void rule__RealLiteralRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4246:1: ( ( ( rule__RealLiteralRule__LiteralAssignment_0 ) ) )
            // InternalOptimisationLanguage.g:4247:1: ( ( rule__RealLiteralRule__LiteralAssignment_0 ) )
            {
            // InternalOptimisationLanguage.g:4247:1: ( ( rule__RealLiteralRule__LiteralAssignment_0 ) )
            // InternalOptimisationLanguage.g:4248:2: ( rule__RealLiteralRule__LiteralAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealLiteralRuleAccess().getLiteralAssignment_0()); 
            }
            // InternalOptimisationLanguage.g:4249:2: ( rule__RealLiteralRule__LiteralAssignment_0 )
            // InternalOptimisationLanguage.g:4249:3: rule__RealLiteralRule__LiteralAssignment_0
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
    // InternalOptimisationLanguage.g:4257:1: rule__RealLiteralRule__Group__1 : rule__RealLiteralRule__Group__1__Impl ;
    public final void rule__RealLiteralRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4261:1: ( rule__RealLiteralRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:4262:2: rule__RealLiteralRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:4268:1: rule__RealLiteralRule__Group__1__Impl : ( ( rule__RealLiteralRule__FactorAssignment_1 )? ) ;
    public final void rule__RealLiteralRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4272:1: ( ( ( rule__RealLiteralRule__FactorAssignment_1 )? ) )
            // InternalOptimisationLanguage.g:4273:1: ( ( rule__RealLiteralRule__FactorAssignment_1 )? )
            {
            // InternalOptimisationLanguage.g:4273:1: ( ( rule__RealLiteralRule__FactorAssignment_1 )? )
            // InternalOptimisationLanguage.g:4274:2: ( rule__RealLiteralRule__FactorAssignment_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealLiteralRuleAccess().getFactorAssignment_1()); 
            }
            // InternalOptimisationLanguage.g:4275:2: ( rule__RealLiteralRule__FactorAssignment_1 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( ((LA33_0>=27 && LA33_0<=46)) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalOptimisationLanguage.g:4275:3: rule__RealLiteralRule__FactorAssignment_1
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
    // InternalOptimisationLanguage.g:4284:1: rule__IntegerLiteralRule__Group__0 : rule__IntegerLiteralRule__Group__0__Impl rule__IntegerLiteralRule__Group__1 ;
    public final void rule__IntegerLiteralRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4288:1: ( rule__IntegerLiteralRule__Group__0__Impl rule__IntegerLiteralRule__Group__1 )
            // InternalOptimisationLanguage.g:4289:2: rule__IntegerLiteralRule__Group__0__Impl rule__IntegerLiteralRule__Group__1
            {
            pushFollow(FOLLOW_36);
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
    // InternalOptimisationLanguage.g:4296:1: rule__IntegerLiteralRule__Group__0__Impl : ( ( rule__IntegerLiteralRule__LiteralAssignment_0 ) ) ;
    public final void rule__IntegerLiteralRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4300:1: ( ( ( rule__IntegerLiteralRule__LiteralAssignment_0 ) ) )
            // InternalOptimisationLanguage.g:4301:1: ( ( rule__IntegerLiteralRule__LiteralAssignment_0 ) )
            {
            // InternalOptimisationLanguage.g:4301:1: ( ( rule__IntegerLiteralRule__LiteralAssignment_0 ) )
            // InternalOptimisationLanguage.g:4302:2: ( rule__IntegerLiteralRule__LiteralAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegerLiteralRuleAccess().getLiteralAssignment_0()); 
            }
            // InternalOptimisationLanguage.g:4303:2: ( rule__IntegerLiteralRule__LiteralAssignment_0 )
            // InternalOptimisationLanguage.g:4303:3: rule__IntegerLiteralRule__LiteralAssignment_0
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
    // InternalOptimisationLanguage.g:4311:1: rule__IntegerLiteralRule__Group__1 : rule__IntegerLiteralRule__Group__1__Impl ;
    public final void rule__IntegerLiteralRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4315:1: ( rule__IntegerLiteralRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:4316:2: rule__IntegerLiteralRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:4322:1: rule__IntegerLiteralRule__Group__1__Impl : ( ( rule__IntegerLiteralRule__FactorAssignment_1 )? ) ;
    public final void rule__IntegerLiteralRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4326:1: ( ( ( rule__IntegerLiteralRule__FactorAssignment_1 )? ) )
            // InternalOptimisationLanguage.g:4327:1: ( ( rule__IntegerLiteralRule__FactorAssignment_1 )? )
            {
            // InternalOptimisationLanguage.g:4327:1: ( ( rule__IntegerLiteralRule__FactorAssignment_1 )? )
            // InternalOptimisationLanguage.g:4328:2: ( rule__IntegerLiteralRule__FactorAssignment_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegerLiteralRuleAccess().getFactorAssignment_1()); 
            }
            // InternalOptimisationLanguage.g:4329:2: ( rule__IntegerLiteralRule__FactorAssignment_1 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( ((LA34_0>=27 && LA34_0<=46)) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalOptimisationLanguage.g:4329:3: rule__IntegerLiteralRule__FactorAssignment_1
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
    // InternalOptimisationLanguage.g:4338:1: rule__BooleanLiteralRule__Group__0 : rule__BooleanLiteralRule__Group__0__Impl rule__BooleanLiteralRule__Group__1 ;
    public final void rule__BooleanLiteralRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4342:1: ( rule__BooleanLiteralRule__Group__0__Impl rule__BooleanLiteralRule__Group__1 )
            // InternalOptimisationLanguage.g:4343:2: rule__BooleanLiteralRule__Group__0__Impl rule__BooleanLiteralRule__Group__1
            {
            pushFollow(FOLLOW_37);
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
    // InternalOptimisationLanguage.g:4350:1: rule__BooleanLiteralRule__Group__0__Impl : ( () ) ;
    public final void rule__BooleanLiteralRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4354:1: ( ( () ) )
            // InternalOptimisationLanguage.g:4355:1: ( () )
            {
            // InternalOptimisationLanguage.g:4355:1: ( () )
            // InternalOptimisationLanguage.g:4356:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralRuleAccess().getBooleanLiteralAction_0()); 
            }
            // InternalOptimisationLanguage.g:4357:2: ()
            // InternalOptimisationLanguage.g:4357:3: 
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
    // InternalOptimisationLanguage.g:4365:1: rule__BooleanLiteralRule__Group__1 : rule__BooleanLiteralRule__Group__1__Impl ;
    public final void rule__BooleanLiteralRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4369:1: ( rule__BooleanLiteralRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:4370:2: rule__BooleanLiteralRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:4376:1: rule__BooleanLiteralRule__Group__1__Impl : ( ( rule__BooleanLiteralRule__Alternatives_1 ) ) ;
    public final void rule__BooleanLiteralRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4380:1: ( ( ( rule__BooleanLiteralRule__Alternatives_1 ) ) )
            // InternalOptimisationLanguage.g:4381:1: ( ( rule__BooleanLiteralRule__Alternatives_1 ) )
            {
            // InternalOptimisationLanguage.g:4381:1: ( ( rule__BooleanLiteralRule__Alternatives_1 ) )
            // InternalOptimisationLanguage.g:4382:2: ( rule__BooleanLiteralRule__Alternatives_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralRuleAccess().getAlternatives_1()); 
            }
            // InternalOptimisationLanguage.g:4383:2: ( rule__BooleanLiteralRule__Alternatives_1 )
            // InternalOptimisationLanguage.g:4383:3: rule__BooleanLiteralRule__Alternatives_1
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


    // $ANTLR start "rule__AttributeDefinitionRule__Group__0"
    // InternalOptimisationLanguage.g:4392:1: rule__AttributeDefinitionRule__Group__0 : rule__AttributeDefinitionRule__Group__0__Impl rule__AttributeDefinitionRule__Group__1 ;
    public final void rule__AttributeDefinitionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4396:1: ( rule__AttributeDefinitionRule__Group__0__Impl rule__AttributeDefinitionRule__Group__1 )
            // InternalOptimisationLanguage.g:4397:2: rule__AttributeDefinitionRule__Group__0__Impl rule__AttributeDefinitionRule__Group__1
            {
            pushFollow(FOLLOW_38);
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
    // InternalOptimisationLanguage.g:4404:1: rule__AttributeDefinitionRule__Group__0__Impl : ( ( rule__AttributeDefinitionRule__NameAssignment_0 ) ) ;
    public final void rule__AttributeDefinitionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4408:1: ( ( ( rule__AttributeDefinitionRule__NameAssignment_0 ) ) )
            // InternalOptimisationLanguage.g:4409:1: ( ( rule__AttributeDefinitionRule__NameAssignment_0 ) )
            {
            // InternalOptimisationLanguage.g:4409:1: ( ( rule__AttributeDefinitionRule__NameAssignment_0 ) )
            // InternalOptimisationLanguage.g:4410:2: ( rule__AttributeDefinitionRule__NameAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getNameAssignment_0()); 
            }
            // InternalOptimisationLanguage.g:4411:2: ( rule__AttributeDefinitionRule__NameAssignment_0 )
            // InternalOptimisationLanguage.g:4411:3: rule__AttributeDefinitionRule__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__AttributeDefinitionRule__NameAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeDefinitionRuleAccess().getNameAssignment_0()); 
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
    // InternalOptimisationLanguage.g:4419:1: rule__AttributeDefinitionRule__Group__1 : rule__AttributeDefinitionRule__Group__1__Impl rule__AttributeDefinitionRule__Group__2 ;
    public final void rule__AttributeDefinitionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4423:1: ( rule__AttributeDefinitionRule__Group__1__Impl rule__AttributeDefinitionRule__Group__2 )
            // InternalOptimisationLanguage.g:4424:2: rule__AttributeDefinitionRule__Group__1__Impl rule__AttributeDefinitionRule__Group__2
            {
            pushFollow(FOLLOW_39);
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
    // InternalOptimisationLanguage.g:4431:1: rule__AttributeDefinitionRule__Group__1__Impl : ( ':' ) ;
    public final void rule__AttributeDefinitionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4435:1: ( ( ':' ) )
            // InternalOptimisationLanguage.g:4436:1: ( ':' )
            {
            // InternalOptimisationLanguage.g:4436:1: ( ':' )
            // InternalOptimisationLanguage.g:4437:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getColonKeyword_1()); 
            }
            match(input,66,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeDefinitionRuleAccess().getColonKeyword_1()); 
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
    // InternalOptimisationLanguage.g:4446:1: rule__AttributeDefinitionRule__Group__2 : rule__AttributeDefinitionRule__Group__2__Impl rule__AttributeDefinitionRule__Group__3 ;
    public final void rule__AttributeDefinitionRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4450:1: ( rule__AttributeDefinitionRule__Group__2__Impl rule__AttributeDefinitionRule__Group__3 )
            // InternalOptimisationLanguage.g:4451:2: rule__AttributeDefinitionRule__Group__2__Impl rule__AttributeDefinitionRule__Group__3
            {
            pushFollow(FOLLOW_40);
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
    // InternalOptimisationLanguage.g:4458:1: rule__AttributeDefinitionRule__Group__2__Impl : ( ( rule__AttributeDefinitionRule__TypeAssignment_2 ) ) ;
    public final void rule__AttributeDefinitionRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4462:1: ( ( ( rule__AttributeDefinitionRule__TypeAssignment_2 ) ) )
            // InternalOptimisationLanguage.g:4463:1: ( ( rule__AttributeDefinitionRule__TypeAssignment_2 ) )
            {
            // InternalOptimisationLanguage.g:4463:1: ( ( rule__AttributeDefinitionRule__TypeAssignment_2 ) )
            // InternalOptimisationLanguage.g:4464:2: ( rule__AttributeDefinitionRule__TypeAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getTypeAssignment_2()); 
            }
            // InternalOptimisationLanguage.g:4465:2: ( rule__AttributeDefinitionRule__TypeAssignment_2 )
            // InternalOptimisationLanguage.g:4465:3: rule__AttributeDefinitionRule__TypeAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__AttributeDefinitionRule__TypeAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeDefinitionRuleAccess().getTypeAssignment_2()); 
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
    // InternalOptimisationLanguage.g:4473:1: rule__AttributeDefinitionRule__Group__3 : rule__AttributeDefinitionRule__Group__3__Impl rule__AttributeDefinitionRule__Group__4 ;
    public final void rule__AttributeDefinitionRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4477:1: ( rule__AttributeDefinitionRule__Group__3__Impl rule__AttributeDefinitionRule__Group__4 )
            // InternalOptimisationLanguage.g:4478:2: rule__AttributeDefinitionRule__Group__3__Impl rule__AttributeDefinitionRule__Group__4
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
    // InternalOptimisationLanguage.g:4485:1: rule__AttributeDefinitionRule__Group__3__Impl : ( ( rule__AttributeDefinitionRule__Group_3__0 )? ) ;
    public final void rule__AttributeDefinitionRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4489:1: ( ( ( rule__AttributeDefinitionRule__Group_3__0 )? ) )
            // InternalOptimisationLanguage.g:4490:1: ( ( rule__AttributeDefinitionRule__Group_3__0 )? )
            {
            // InternalOptimisationLanguage.g:4490:1: ( ( rule__AttributeDefinitionRule__Group_3__0 )? )
            // InternalOptimisationLanguage.g:4491:2: ( rule__AttributeDefinitionRule__Group_3__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getGroup_3()); 
            }
            // InternalOptimisationLanguage.g:4492:2: ( rule__AttributeDefinitionRule__Group_3__0 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==52) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalOptimisationLanguage.g:4492:3: rule__AttributeDefinitionRule__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__AttributeDefinitionRule__Group_3__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeDefinitionRuleAccess().getGroup_3()); 
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
    // InternalOptimisationLanguage.g:4500:1: rule__AttributeDefinitionRule__Group__4 : rule__AttributeDefinitionRule__Group__4__Impl ;
    public final void rule__AttributeDefinitionRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4504:1: ( rule__AttributeDefinitionRule__Group__4__Impl )
            // InternalOptimisationLanguage.g:4505:2: rule__AttributeDefinitionRule__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AttributeDefinitionRule__Group__4__Impl();

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
    // InternalOptimisationLanguage.g:4511:1: rule__AttributeDefinitionRule__Group__4__Impl : ( ';' ) ;
    public final void rule__AttributeDefinitionRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4515:1: ( ( ';' ) )
            // InternalOptimisationLanguage.g:4516:1: ( ';' )
            {
            // InternalOptimisationLanguage.g:4516:1: ( ';' )
            // InternalOptimisationLanguage.g:4517:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getSemicolonKeyword_4()); 
            }
            match(input,53,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeDefinitionRuleAccess().getSemicolonKeyword_4()); 
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


    // $ANTLR start "rule__AttributeDefinitionRule__Group_3__0"
    // InternalOptimisationLanguage.g:4527:1: rule__AttributeDefinitionRule__Group_3__0 : rule__AttributeDefinitionRule__Group_3__0__Impl rule__AttributeDefinitionRule__Group_3__1 ;
    public final void rule__AttributeDefinitionRule__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4531:1: ( rule__AttributeDefinitionRule__Group_3__0__Impl rule__AttributeDefinitionRule__Group_3__1 )
            // InternalOptimisationLanguage.g:4532:2: rule__AttributeDefinitionRule__Group_3__0__Impl rule__AttributeDefinitionRule__Group_3__1
            {
            pushFollow(FOLLOW_17);
            rule__AttributeDefinitionRule__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__AttributeDefinitionRule__Group_3__1();

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
    // $ANTLR end "rule__AttributeDefinitionRule__Group_3__0"


    // $ANTLR start "rule__AttributeDefinitionRule__Group_3__0__Impl"
    // InternalOptimisationLanguage.g:4539:1: rule__AttributeDefinitionRule__Group_3__0__Impl : ( ':=' ) ;
    public final void rule__AttributeDefinitionRule__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4543:1: ( ( ':=' ) )
            // InternalOptimisationLanguage.g:4544:1: ( ':=' )
            {
            // InternalOptimisationLanguage.g:4544:1: ( ':=' )
            // InternalOptimisationLanguage.g:4545:2: ':='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getColonEqualsSignKeyword_3_0()); 
            }
            match(input,52,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeDefinitionRuleAccess().getColonEqualsSignKeyword_3_0()); 
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
    // $ANTLR end "rule__AttributeDefinitionRule__Group_3__0__Impl"


    // $ANTLR start "rule__AttributeDefinitionRule__Group_3__1"
    // InternalOptimisationLanguage.g:4554:1: rule__AttributeDefinitionRule__Group_3__1 : rule__AttributeDefinitionRule__Group_3__1__Impl ;
    public final void rule__AttributeDefinitionRule__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4558:1: ( rule__AttributeDefinitionRule__Group_3__1__Impl )
            // InternalOptimisationLanguage.g:4559:2: rule__AttributeDefinitionRule__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AttributeDefinitionRule__Group_3__1__Impl();

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
    // $ANTLR end "rule__AttributeDefinitionRule__Group_3__1"


    // $ANTLR start "rule__AttributeDefinitionRule__Group_3__1__Impl"
    // InternalOptimisationLanguage.g:4565:1: rule__AttributeDefinitionRule__Group_3__1__Impl : ( ( rule__AttributeDefinitionRule__InitialisationAssignment_3_1 ) ) ;
    public final void rule__AttributeDefinitionRule__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4569:1: ( ( ( rule__AttributeDefinitionRule__InitialisationAssignment_3_1 ) ) )
            // InternalOptimisationLanguage.g:4570:1: ( ( rule__AttributeDefinitionRule__InitialisationAssignment_3_1 ) )
            {
            // InternalOptimisationLanguage.g:4570:1: ( ( rule__AttributeDefinitionRule__InitialisationAssignment_3_1 ) )
            // InternalOptimisationLanguage.g:4571:2: ( rule__AttributeDefinitionRule__InitialisationAssignment_3_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getInitialisationAssignment_3_1()); 
            }
            // InternalOptimisationLanguage.g:4572:2: ( rule__AttributeDefinitionRule__InitialisationAssignment_3_1 )
            // InternalOptimisationLanguage.g:4572:3: rule__AttributeDefinitionRule__InitialisationAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__AttributeDefinitionRule__InitialisationAssignment_3_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeDefinitionRuleAccess().getInitialisationAssignment_3_1()); 
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
    // $ANTLR end "rule__AttributeDefinitionRule__Group_3__1__Impl"


    // $ANTLR start "rule__LiteralTypeRule__Group__0"
    // InternalOptimisationLanguage.g:4581:1: rule__LiteralTypeRule__Group__0 : rule__LiteralTypeRule__Group__0__Impl rule__LiteralTypeRule__Group__1 ;
    public final void rule__LiteralTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4585:1: ( rule__LiteralTypeRule__Group__0__Impl rule__LiteralTypeRule__Group__1 )
            // InternalOptimisationLanguage.g:4586:2: rule__LiteralTypeRule__Group__0__Impl rule__LiteralTypeRule__Group__1
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
    // InternalOptimisationLanguage.g:4593:1: rule__LiteralTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__LiteralTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4597:1: ( ( () ) )
            // InternalOptimisationLanguage.g:4598:1: ( () )
            {
            // InternalOptimisationLanguage.g:4598:1: ( () )
            // InternalOptimisationLanguage.g:4599:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralTypeRuleAccess().getLiteralTypeAction_0()); 
            }
            // InternalOptimisationLanguage.g:4600:2: ()
            // InternalOptimisationLanguage.g:4600:3: 
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
    // InternalOptimisationLanguage.g:4608:1: rule__LiteralTypeRule__Group__1 : rule__LiteralTypeRule__Group__1__Impl ;
    public final void rule__LiteralTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4612:1: ( rule__LiteralTypeRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:4613:2: rule__LiteralTypeRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:4619:1: rule__LiteralTypeRule__Group__1__Impl : ( 'literal' ) ;
    public final void rule__LiteralTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4623:1: ( ( 'literal' ) )
            // InternalOptimisationLanguage.g:4624:1: ( 'literal' )
            {
            // InternalOptimisationLanguage.g:4624:1: ( 'literal' )
            // InternalOptimisationLanguage.g:4625:2: 'literal'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralTypeRuleAccess().getLiteralKeyword_1()); 
            }
            match(input,67,FOLLOW_2); if (state.failed) return ;
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


    // $ANTLR start "rule__InstanceTypeRule__Group__0"
    // InternalOptimisationLanguage.g:4635:1: rule__InstanceTypeRule__Group__0 : rule__InstanceTypeRule__Group__0__Impl rule__InstanceTypeRule__Group__1 ;
    public final void rule__InstanceTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4639:1: ( rule__InstanceTypeRule__Group__0__Impl rule__InstanceTypeRule__Group__1 )
            // InternalOptimisationLanguage.g:4640:2: rule__InstanceTypeRule__Group__0__Impl rule__InstanceTypeRule__Group__1
            {
            pushFollow(FOLLOW_42);
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
    // InternalOptimisationLanguage.g:4647:1: rule__InstanceTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__InstanceTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4651:1: ( ( () ) )
            // InternalOptimisationLanguage.g:4652:1: ( () )
            {
            // InternalOptimisationLanguage.g:4652:1: ( () )
            // InternalOptimisationLanguage.g:4653:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceTypeRuleAccess().getInstanceTypeAction_0()); 
            }
            // InternalOptimisationLanguage.g:4654:2: ()
            // InternalOptimisationLanguage.g:4654:3: 
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
    // InternalOptimisationLanguage.g:4662:1: rule__InstanceTypeRule__Group__1 : rule__InstanceTypeRule__Group__1__Impl rule__InstanceTypeRule__Group__2 ;
    public final void rule__InstanceTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4666:1: ( rule__InstanceTypeRule__Group__1__Impl rule__InstanceTypeRule__Group__2 )
            // InternalOptimisationLanguage.g:4667:2: rule__InstanceTypeRule__Group__1__Impl rule__InstanceTypeRule__Group__2
            {
            pushFollow(FOLLOW_5);
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
    // InternalOptimisationLanguage.g:4674:1: rule__InstanceTypeRule__Group__1__Impl : ( 'instance' ) ;
    public final void rule__InstanceTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4678:1: ( ( 'instance' ) )
            // InternalOptimisationLanguage.g:4679:1: ( 'instance' )
            {
            // InternalOptimisationLanguage.g:4679:1: ( 'instance' )
            // InternalOptimisationLanguage.g:4680:2: 'instance'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceTypeRuleAccess().getInstanceKeyword_1()); 
            }
            match(input,68,FOLLOW_2); if (state.failed) return ;
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
    // InternalOptimisationLanguage.g:4689:1: rule__InstanceTypeRule__Group__2 : rule__InstanceTypeRule__Group__2__Impl ;
    public final void rule__InstanceTypeRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4693:1: ( rule__InstanceTypeRule__Group__2__Impl )
            // InternalOptimisationLanguage.g:4694:2: rule__InstanceTypeRule__Group__2__Impl
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
    // InternalOptimisationLanguage.g:4700:1: rule__InstanceTypeRule__Group__2__Impl : ( ( rule__InstanceTypeRule__DefinitionAssignment_2 ) ) ;
    public final void rule__InstanceTypeRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4704:1: ( ( ( rule__InstanceTypeRule__DefinitionAssignment_2 ) ) )
            // InternalOptimisationLanguage.g:4705:1: ( ( rule__InstanceTypeRule__DefinitionAssignment_2 ) )
            {
            // InternalOptimisationLanguage.g:4705:1: ( ( rule__InstanceTypeRule__DefinitionAssignment_2 ) )
            // InternalOptimisationLanguage.g:4706:2: ( rule__InstanceTypeRule__DefinitionAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceTypeRuleAccess().getDefinitionAssignment_2()); 
            }
            // InternalOptimisationLanguage.g:4707:2: ( rule__InstanceTypeRule__DefinitionAssignment_2 )
            // InternalOptimisationLanguage.g:4707:3: rule__InstanceTypeRule__DefinitionAssignment_2
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
    // InternalOptimisationLanguage.g:4716:1: rule__StringTypeRule__Group__0 : rule__StringTypeRule__Group__0__Impl rule__StringTypeRule__Group__1 ;
    public final void rule__StringTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4720:1: ( rule__StringTypeRule__Group__0__Impl rule__StringTypeRule__Group__1 )
            // InternalOptimisationLanguage.g:4721:2: rule__StringTypeRule__Group__0__Impl rule__StringTypeRule__Group__1
            {
            pushFollow(FOLLOW_43);
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
    // InternalOptimisationLanguage.g:4728:1: rule__StringTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__StringTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4732:1: ( ( () ) )
            // InternalOptimisationLanguage.g:4733:1: ( () )
            {
            // InternalOptimisationLanguage.g:4733:1: ( () )
            // InternalOptimisationLanguage.g:4734:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringTypeRuleAccess().getStringTypeAction_0()); 
            }
            // InternalOptimisationLanguage.g:4735:2: ()
            // InternalOptimisationLanguage.g:4735:3: 
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
    // InternalOptimisationLanguage.g:4743:1: rule__StringTypeRule__Group__1 : rule__StringTypeRule__Group__1__Impl ;
    public final void rule__StringTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4747:1: ( rule__StringTypeRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:4748:2: rule__StringTypeRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:4754:1: rule__StringTypeRule__Group__1__Impl : ( 'string' ) ;
    public final void rule__StringTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4758:1: ( ( 'string' ) )
            // InternalOptimisationLanguage.g:4759:1: ( 'string' )
            {
            // InternalOptimisationLanguage.g:4759:1: ( 'string' )
            // InternalOptimisationLanguage.g:4760:2: 'string'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringTypeRuleAccess().getStringKeyword_1()); 
            }
            match(input,69,FOLLOW_2); if (state.failed) return ;
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
    // InternalOptimisationLanguage.g:4770:1: rule__ExpressionTypeRule__Group__0 : rule__ExpressionTypeRule__Group__0__Impl rule__ExpressionTypeRule__Group__1 ;
    public final void rule__ExpressionTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4774:1: ( rule__ExpressionTypeRule__Group__0__Impl rule__ExpressionTypeRule__Group__1 )
            // InternalOptimisationLanguage.g:4775:2: rule__ExpressionTypeRule__Group__0__Impl rule__ExpressionTypeRule__Group__1
            {
            pushFollow(FOLLOW_44);
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
    // InternalOptimisationLanguage.g:4782:1: rule__ExpressionTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__ExpressionTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4786:1: ( ( () ) )
            // InternalOptimisationLanguage.g:4787:1: ( () )
            {
            // InternalOptimisationLanguage.g:4787:1: ( () )
            // InternalOptimisationLanguage.g:4788:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionTypeRuleAccess().getExpressionTypeAction_0()); 
            }
            // InternalOptimisationLanguage.g:4789:2: ()
            // InternalOptimisationLanguage.g:4789:3: 
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
    // InternalOptimisationLanguage.g:4797:1: rule__ExpressionTypeRule__Group__1 : rule__ExpressionTypeRule__Group__1__Impl ;
    public final void rule__ExpressionTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4801:1: ( rule__ExpressionTypeRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:4802:2: rule__ExpressionTypeRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:4808:1: rule__ExpressionTypeRule__Group__1__Impl : ( 'expression' ) ;
    public final void rule__ExpressionTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4812:1: ( ( 'expression' ) )
            // InternalOptimisationLanguage.g:4813:1: ( 'expression' )
            {
            // InternalOptimisationLanguage.g:4813:1: ( 'expression' )
            // InternalOptimisationLanguage.g:4814:2: 'expression'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionTypeRuleAccess().getExpressionKeyword_1()); 
            }
            match(input,70,FOLLOW_2); if (state.failed) return ;
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
    // InternalOptimisationLanguage.g:4824:1: rule__IntTypeRule__Group__0 : rule__IntTypeRule__Group__0__Impl rule__IntTypeRule__Group__1 ;
    public final void rule__IntTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4828:1: ( rule__IntTypeRule__Group__0__Impl rule__IntTypeRule__Group__1 )
            // InternalOptimisationLanguage.g:4829:2: rule__IntTypeRule__Group__0__Impl rule__IntTypeRule__Group__1
            {
            pushFollow(FOLLOW_45);
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
    // InternalOptimisationLanguage.g:4836:1: rule__IntTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__IntTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4840:1: ( ( () ) )
            // InternalOptimisationLanguage.g:4841:1: ( () )
            {
            // InternalOptimisationLanguage.g:4841:1: ( () )
            // InternalOptimisationLanguage.g:4842:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntTypeRuleAccess().getIntTypeAction_0()); 
            }
            // InternalOptimisationLanguage.g:4843:2: ()
            // InternalOptimisationLanguage.g:4843:3: 
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
    // InternalOptimisationLanguage.g:4851:1: rule__IntTypeRule__Group__1 : rule__IntTypeRule__Group__1__Impl ;
    public final void rule__IntTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4855:1: ( rule__IntTypeRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:4856:2: rule__IntTypeRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:4862:1: rule__IntTypeRule__Group__1__Impl : ( 'int' ) ;
    public final void rule__IntTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4866:1: ( ( 'int' ) )
            // InternalOptimisationLanguage.g:4867:1: ( 'int' )
            {
            // InternalOptimisationLanguage.g:4867:1: ( 'int' )
            // InternalOptimisationLanguage.g:4868:2: 'int'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntTypeRuleAccess().getIntKeyword_1()); 
            }
            match(input,71,FOLLOW_2); if (state.failed) return ;
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
    // InternalOptimisationLanguage.g:4878:1: rule__RealTypeRule__Group__0 : rule__RealTypeRule__Group__0__Impl rule__RealTypeRule__Group__1 ;
    public final void rule__RealTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4882:1: ( rule__RealTypeRule__Group__0__Impl rule__RealTypeRule__Group__1 )
            // InternalOptimisationLanguage.g:4883:2: rule__RealTypeRule__Group__0__Impl rule__RealTypeRule__Group__1
            {
            pushFollow(FOLLOW_46);
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
    // InternalOptimisationLanguage.g:4890:1: rule__RealTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__RealTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4894:1: ( ( () ) )
            // InternalOptimisationLanguage.g:4895:1: ( () )
            {
            // InternalOptimisationLanguage.g:4895:1: ( () )
            // InternalOptimisationLanguage.g:4896:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealTypeRuleAccess().getRealTypeAction_0()); 
            }
            // InternalOptimisationLanguage.g:4897:2: ()
            // InternalOptimisationLanguage.g:4897:3: 
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
    // InternalOptimisationLanguage.g:4905:1: rule__RealTypeRule__Group__1 : rule__RealTypeRule__Group__1__Impl ;
    public final void rule__RealTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4909:1: ( rule__RealTypeRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:4910:2: rule__RealTypeRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:4916:1: rule__RealTypeRule__Group__1__Impl : ( 'real' ) ;
    public final void rule__RealTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4920:1: ( ( 'real' ) )
            // InternalOptimisationLanguage.g:4921:1: ( 'real' )
            {
            // InternalOptimisationLanguage.g:4921:1: ( 'real' )
            // InternalOptimisationLanguage.g:4922:2: 'real'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealTypeRuleAccess().getRealKeyword_1()); 
            }
            match(input,72,FOLLOW_2); if (state.failed) return ;
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
    // InternalOptimisationLanguage.g:4932:1: rule__BooleanTypeRule__Group__0 : rule__BooleanTypeRule__Group__0__Impl rule__BooleanTypeRule__Group__1 ;
    public final void rule__BooleanTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4936:1: ( rule__BooleanTypeRule__Group__0__Impl rule__BooleanTypeRule__Group__1 )
            // InternalOptimisationLanguage.g:4937:2: rule__BooleanTypeRule__Group__0__Impl rule__BooleanTypeRule__Group__1
            {
            pushFollow(FOLLOW_47);
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
    // InternalOptimisationLanguage.g:4944:1: rule__BooleanTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__BooleanTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4948:1: ( ( () ) )
            // InternalOptimisationLanguage.g:4949:1: ( () )
            {
            // InternalOptimisationLanguage.g:4949:1: ( () )
            // InternalOptimisationLanguage.g:4950:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanTypeRuleAccess().getBooleanTypeAction_0()); 
            }
            // InternalOptimisationLanguage.g:4951:2: ()
            // InternalOptimisationLanguage.g:4951:3: 
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
    // InternalOptimisationLanguage.g:4959:1: rule__BooleanTypeRule__Group__1 : rule__BooleanTypeRule__Group__1__Impl ;
    public final void rule__BooleanTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4963:1: ( rule__BooleanTypeRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:4964:2: rule__BooleanTypeRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:4970:1: rule__BooleanTypeRule__Group__1__Impl : ( 'boolean' ) ;
    public final void rule__BooleanTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4974:1: ( ( 'boolean' ) )
            // InternalOptimisationLanguage.g:4975:1: ( 'boolean' )
            {
            // InternalOptimisationLanguage.g:4975:1: ( 'boolean' )
            // InternalOptimisationLanguage.g:4976:2: 'boolean'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanTypeRuleAccess().getBooleanKeyword_1()); 
            }
            match(input,73,FOLLOW_2); if (state.failed) return ;
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
    // InternalOptimisationLanguage.g:4986:1: rule__VoidTypeRule__Group__0 : rule__VoidTypeRule__Group__0__Impl rule__VoidTypeRule__Group__1 ;
    public final void rule__VoidTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4990:1: ( rule__VoidTypeRule__Group__0__Impl rule__VoidTypeRule__Group__1 )
            // InternalOptimisationLanguage.g:4991:2: rule__VoidTypeRule__Group__0__Impl rule__VoidTypeRule__Group__1
            {
            pushFollow(FOLLOW_48);
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
    // InternalOptimisationLanguage.g:4998:1: rule__VoidTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__VoidTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5002:1: ( ( () ) )
            // InternalOptimisationLanguage.g:5003:1: ( () )
            {
            // InternalOptimisationLanguage.g:5003:1: ( () )
            // InternalOptimisationLanguage.g:5004:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVoidTypeRuleAccess().getVoidTypeAction_0()); 
            }
            // InternalOptimisationLanguage.g:5005:2: ()
            // InternalOptimisationLanguage.g:5005:3: 
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
    // InternalOptimisationLanguage.g:5013:1: rule__VoidTypeRule__Group__1 : rule__VoidTypeRule__Group__1__Impl ;
    public final void rule__VoidTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5017:1: ( rule__VoidTypeRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:5018:2: rule__VoidTypeRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:5024:1: rule__VoidTypeRule__Group__1__Impl : ( 'void' ) ;
    public final void rule__VoidTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5028:1: ( ( 'void' ) )
            // InternalOptimisationLanguage.g:5029:1: ( 'void' )
            {
            // InternalOptimisationLanguage.g:5029:1: ( 'void' )
            // InternalOptimisationLanguage.g:5030:2: 'void'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVoidTypeRuleAccess().getVoidKeyword_1()); 
            }
            match(input,74,FOLLOW_2); if (state.failed) return ;
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


    // $ANTLR start "rule__DataOrInstanceTypeRule__Group__0"
    // InternalOptimisationLanguage.g:5040:1: rule__DataOrInstanceTypeRule__Group__0 : rule__DataOrInstanceTypeRule__Group__0__Impl rule__DataOrInstanceTypeRule__Group__1 ;
    public final void rule__DataOrInstanceTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5044:1: ( rule__DataOrInstanceTypeRule__Group__0__Impl rule__DataOrInstanceTypeRule__Group__1 )
            // InternalOptimisationLanguage.g:5045:2: rule__DataOrInstanceTypeRule__Group__0__Impl rule__DataOrInstanceTypeRule__Group__1
            {
            pushFollow(FOLLOW_39);
            rule__DataOrInstanceTypeRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__DataOrInstanceTypeRule__Group__1();

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
    // $ANTLR end "rule__DataOrInstanceTypeRule__Group__0"


    // $ANTLR start "rule__DataOrInstanceTypeRule__Group__0__Impl"
    // InternalOptimisationLanguage.g:5052:1: rule__DataOrInstanceTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__DataOrInstanceTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5056:1: ( ( () ) )
            // InternalOptimisationLanguage.g:5057:1: ( () )
            {
            // InternalOptimisationLanguage.g:5057:1: ( () )
            // InternalOptimisationLanguage.g:5058:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataOrInstanceTypeRuleAccess().getDataOrInstanceTypeAction_0()); 
            }
            // InternalOptimisationLanguage.g:5059:2: ()
            // InternalOptimisationLanguage.g:5059:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataOrInstanceTypeRuleAccess().getDataOrInstanceTypeAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataOrInstanceTypeRule__Group__0__Impl"


    // $ANTLR start "rule__DataOrInstanceTypeRule__Group__1"
    // InternalOptimisationLanguage.g:5067:1: rule__DataOrInstanceTypeRule__Group__1 : rule__DataOrInstanceTypeRule__Group__1__Impl rule__DataOrInstanceTypeRule__Group__2 ;
    public final void rule__DataOrInstanceTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5071:1: ( rule__DataOrInstanceTypeRule__Group__1__Impl rule__DataOrInstanceTypeRule__Group__2 )
            // InternalOptimisationLanguage.g:5072:2: rule__DataOrInstanceTypeRule__Group__1__Impl rule__DataOrInstanceTypeRule__Group__2
            {
            pushFollow(FOLLOW_49);
            rule__DataOrInstanceTypeRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__DataOrInstanceTypeRule__Group__2();

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
    // $ANTLR end "rule__DataOrInstanceTypeRule__Group__1"


    // $ANTLR start "rule__DataOrInstanceTypeRule__Group__1__Impl"
    // InternalOptimisationLanguage.g:5079:1: rule__DataOrInstanceTypeRule__Group__1__Impl : ( 'data' ) ;
    public final void rule__DataOrInstanceTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5083:1: ( ( 'data' ) )
            // InternalOptimisationLanguage.g:5084:1: ( 'data' )
            {
            // InternalOptimisationLanguage.g:5084:1: ( 'data' )
            // InternalOptimisationLanguage.g:5085:2: 'data'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataOrInstanceTypeRuleAccess().getDataKeyword_1()); 
            }
            match(input,56,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataOrInstanceTypeRuleAccess().getDataKeyword_1()); 
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
    // $ANTLR end "rule__DataOrInstanceTypeRule__Group__1__Impl"


    // $ANTLR start "rule__DataOrInstanceTypeRule__Group__2"
    // InternalOptimisationLanguage.g:5094:1: rule__DataOrInstanceTypeRule__Group__2 : rule__DataOrInstanceTypeRule__Group__2__Impl rule__DataOrInstanceTypeRule__Group__3 ;
    public final void rule__DataOrInstanceTypeRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5098:1: ( rule__DataOrInstanceTypeRule__Group__2__Impl rule__DataOrInstanceTypeRule__Group__3 )
            // InternalOptimisationLanguage.g:5099:2: rule__DataOrInstanceTypeRule__Group__2__Impl rule__DataOrInstanceTypeRule__Group__3
            {
            pushFollow(FOLLOW_50);
            rule__DataOrInstanceTypeRule__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__DataOrInstanceTypeRule__Group__3();

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
    // $ANTLR end "rule__DataOrInstanceTypeRule__Group__2"


    // $ANTLR start "rule__DataOrInstanceTypeRule__Group__2__Impl"
    // InternalOptimisationLanguage.g:5106:1: rule__DataOrInstanceTypeRule__Group__2__Impl : ( 'or' ) ;
    public final void rule__DataOrInstanceTypeRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5110:1: ( ( 'or' ) )
            // InternalOptimisationLanguage.g:5111:1: ( 'or' )
            {
            // InternalOptimisationLanguage.g:5111:1: ( 'or' )
            // InternalOptimisationLanguage.g:5112:2: 'or'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataOrInstanceTypeRuleAccess().getOrKeyword_2()); 
            }
            match(input,75,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataOrInstanceTypeRuleAccess().getOrKeyword_2()); 
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
    // $ANTLR end "rule__DataOrInstanceTypeRule__Group__2__Impl"


    // $ANTLR start "rule__DataOrInstanceTypeRule__Group__3"
    // InternalOptimisationLanguage.g:5121:1: rule__DataOrInstanceTypeRule__Group__3 : rule__DataOrInstanceTypeRule__Group__3__Impl rule__DataOrInstanceTypeRule__Group__4 ;
    public final void rule__DataOrInstanceTypeRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5125:1: ( rule__DataOrInstanceTypeRule__Group__3__Impl rule__DataOrInstanceTypeRule__Group__4 )
            // InternalOptimisationLanguage.g:5126:2: rule__DataOrInstanceTypeRule__Group__3__Impl rule__DataOrInstanceTypeRule__Group__4
            {
            pushFollow(FOLLOW_51);
            rule__DataOrInstanceTypeRule__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__DataOrInstanceTypeRule__Group__4();

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
    // $ANTLR end "rule__DataOrInstanceTypeRule__Group__3"


    // $ANTLR start "rule__DataOrInstanceTypeRule__Group__3__Impl"
    // InternalOptimisationLanguage.g:5133:1: rule__DataOrInstanceTypeRule__Group__3__Impl : ( 'type' ) ;
    public final void rule__DataOrInstanceTypeRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5137:1: ( ( 'type' ) )
            // InternalOptimisationLanguage.g:5138:1: ( 'type' )
            {
            // InternalOptimisationLanguage.g:5138:1: ( 'type' )
            // InternalOptimisationLanguage.g:5139:2: 'type'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataOrInstanceTypeRuleAccess().getTypeKeyword_3()); 
            }
            match(input,76,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataOrInstanceTypeRuleAccess().getTypeKeyword_3()); 
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
    // $ANTLR end "rule__DataOrInstanceTypeRule__Group__3__Impl"


    // $ANTLR start "rule__DataOrInstanceTypeRule__Group__4"
    // InternalOptimisationLanguage.g:5148:1: rule__DataOrInstanceTypeRule__Group__4 : rule__DataOrInstanceTypeRule__Group__4__Impl ;
    public final void rule__DataOrInstanceTypeRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5152:1: ( rule__DataOrInstanceTypeRule__Group__4__Impl )
            // InternalOptimisationLanguage.g:5153:2: rule__DataOrInstanceTypeRule__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataOrInstanceTypeRule__Group__4__Impl();

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
    // $ANTLR end "rule__DataOrInstanceTypeRule__Group__4"


    // $ANTLR start "rule__DataOrInstanceTypeRule__Group__4__Impl"
    // InternalOptimisationLanguage.g:5159:1: rule__DataOrInstanceTypeRule__Group__4__Impl : ( ( rule__DataOrInstanceTypeRule__Group_4__0 )? ) ;
    public final void rule__DataOrInstanceTypeRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5163:1: ( ( ( rule__DataOrInstanceTypeRule__Group_4__0 )? ) )
            // InternalOptimisationLanguage.g:5164:1: ( ( rule__DataOrInstanceTypeRule__Group_4__0 )? )
            {
            // InternalOptimisationLanguage.g:5164:1: ( ( rule__DataOrInstanceTypeRule__Group_4__0 )? )
            // InternalOptimisationLanguage.g:5165:2: ( rule__DataOrInstanceTypeRule__Group_4__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataOrInstanceTypeRuleAccess().getGroup_4()); 
            }
            // InternalOptimisationLanguage.g:5166:2: ( rule__DataOrInstanceTypeRule__Group_4__0 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==77) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalOptimisationLanguage.g:5166:3: rule__DataOrInstanceTypeRule__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataOrInstanceTypeRule__Group_4__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataOrInstanceTypeRuleAccess().getGroup_4()); 
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
    // $ANTLR end "rule__DataOrInstanceTypeRule__Group__4__Impl"


    // $ANTLR start "rule__DataOrInstanceTypeRule__Group_4__0"
    // InternalOptimisationLanguage.g:5175:1: rule__DataOrInstanceTypeRule__Group_4__0 : rule__DataOrInstanceTypeRule__Group_4__0__Impl rule__DataOrInstanceTypeRule__Group_4__1 ;
    public final void rule__DataOrInstanceTypeRule__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5179:1: ( rule__DataOrInstanceTypeRule__Group_4__0__Impl rule__DataOrInstanceTypeRule__Group_4__1 )
            // InternalOptimisationLanguage.g:5180:2: rule__DataOrInstanceTypeRule__Group_4__0__Impl rule__DataOrInstanceTypeRule__Group_4__1
            {
            pushFollow(FOLLOW_42);
            rule__DataOrInstanceTypeRule__Group_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__DataOrInstanceTypeRule__Group_4__1();

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
    // $ANTLR end "rule__DataOrInstanceTypeRule__Group_4__0"


    // $ANTLR start "rule__DataOrInstanceTypeRule__Group_4__0__Impl"
    // InternalOptimisationLanguage.g:5187:1: rule__DataOrInstanceTypeRule__Group_4__0__Impl : ( 'of' ) ;
    public final void rule__DataOrInstanceTypeRule__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5191:1: ( ( 'of' ) )
            // InternalOptimisationLanguage.g:5192:1: ( 'of' )
            {
            // InternalOptimisationLanguage.g:5192:1: ( 'of' )
            // InternalOptimisationLanguage.g:5193:2: 'of'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataOrInstanceTypeRuleAccess().getOfKeyword_4_0()); 
            }
            match(input,77,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataOrInstanceTypeRuleAccess().getOfKeyword_4_0()); 
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
    // $ANTLR end "rule__DataOrInstanceTypeRule__Group_4__0__Impl"


    // $ANTLR start "rule__DataOrInstanceTypeRule__Group_4__1"
    // InternalOptimisationLanguage.g:5202:1: rule__DataOrInstanceTypeRule__Group_4__1 : rule__DataOrInstanceTypeRule__Group_4__1__Impl ;
    public final void rule__DataOrInstanceTypeRule__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5206:1: ( rule__DataOrInstanceTypeRule__Group_4__1__Impl )
            // InternalOptimisationLanguage.g:5207:2: rule__DataOrInstanceTypeRule__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataOrInstanceTypeRule__Group_4__1__Impl();

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
    // $ANTLR end "rule__DataOrInstanceTypeRule__Group_4__1"


    // $ANTLR start "rule__DataOrInstanceTypeRule__Group_4__1__Impl"
    // InternalOptimisationLanguage.g:5213:1: rule__DataOrInstanceTypeRule__Group_4__1__Impl : ( ( rule__DataOrInstanceTypeRule__InstanceAssignment_4_1 ) ) ;
    public final void rule__DataOrInstanceTypeRule__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5217:1: ( ( ( rule__DataOrInstanceTypeRule__InstanceAssignment_4_1 ) ) )
            // InternalOptimisationLanguage.g:5218:1: ( ( rule__DataOrInstanceTypeRule__InstanceAssignment_4_1 ) )
            {
            // InternalOptimisationLanguage.g:5218:1: ( ( rule__DataOrInstanceTypeRule__InstanceAssignment_4_1 ) )
            // InternalOptimisationLanguage.g:5219:2: ( rule__DataOrInstanceTypeRule__InstanceAssignment_4_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataOrInstanceTypeRuleAccess().getInstanceAssignment_4_1()); 
            }
            // InternalOptimisationLanguage.g:5220:2: ( rule__DataOrInstanceTypeRule__InstanceAssignment_4_1 )
            // InternalOptimisationLanguage.g:5220:3: rule__DataOrInstanceTypeRule__InstanceAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__DataOrInstanceTypeRule__InstanceAssignment_4_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataOrInstanceTypeRuleAccess().getInstanceAssignment_4_1()); 
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
    // $ANTLR end "rule__DataOrInstanceTypeRule__Group_4__1__Impl"


    // $ANTLR start "rule__DataTypeRule__Group__0"
    // InternalOptimisationLanguage.g:5229:1: rule__DataTypeRule__Group__0 : rule__DataTypeRule__Group__0__Impl rule__DataTypeRule__Group__1 ;
    public final void rule__DataTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5233:1: ( rule__DataTypeRule__Group__0__Impl rule__DataTypeRule__Group__1 )
            // InternalOptimisationLanguage.g:5234:2: rule__DataTypeRule__Group__0__Impl rule__DataTypeRule__Group__1
            {
            pushFollow(FOLLOW_14);
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
    // InternalOptimisationLanguage.g:5241:1: rule__DataTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__DataTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5245:1: ( ( () ) )
            // InternalOptimisationLanguage.g:5246:1: ( () )
            {
            // InternalOptimisationLanguage.g:5246:1: ( () )
            // InternalOptimisationLanguage.g:5247:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getDataTypeAction_0()); 
            }
            // InternalOptimisationLanguage.g:5248:2: ()
            // InternalOptimisationLanguage.g:5248:3: 
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
    // InternalOptimisationLanguage.g:5256:1: rule__DataTypeRule__Group__1 : rule__DataTypeRule__Group__1__Impl ;
    public final void rule__DataTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5260:1: ( rule__DataTypeRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:5261:2: rule__DataTypeRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:5267:1: rule__DataTypeRule__Group__1__Impl : ( 'data' ) ;
    public final void rule__DataTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5271:1: ( ( 'data' ) )
            // InternalOptimisationLanguage.g:5272:1: ( 'data' )
            {
            // InternalOptimisationLanguage.g:5272:1: ( 'data' )
            // InternalOptimisationLanguage.g:5273:2: 'data'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getDataKeyword_1()); 
            }
            match(input,56,FOLLOW_2); if (state.failed) return ;
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


    // $ANTLR start "rule__ArrayTypeRule__Group__0"
    // InternalOptimisationLanguage.g:5283:1: rule__ArrayTypeRule__Group__0 : rule__ArrayTypeRule__Group__0__Impl rule__ArrayTypeRule__Group__1 ;
    public final void rule__ArrayTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5287:1: ( rule__ArrayTypeRule__Group__0__Impl rule__ArrayTypeRule__Group__1 )
            // InternalOptimisationLanguage.g:5288:2: rule__ArrayTypeRule__Group__0__Impl rule__ArrayTypeRule__Group__1
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
    // InternalOptimisationLanguage.g:5295:1: rule__ArrayTypeRule__Group__0__Impl : ( 'array' ) ;
    public final void rule__ArrayTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5299:1: ( ( 'array' ) )
            // InternalOptimisationLanguage.g:5300:1: ( 'array' )
            {
            // InternalOptimisationLanguage.g:5300:1: ( 'array' )
            // InternalOptimisationLanguage.g:5301:2: 'array'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayTypeRuleAccess().getArrayKeyword_0()); 
            }
            match(input,78,FOLLOW_2); if (state.failed) return ;
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
    // InternalOptimisationLanguage.g:5310:1: rule__ArrayTypeRule__Group__1 : rule__ArrayTypeRule__Group__1__Impl ;
    public final void rule__ArrayTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5314:1: ( rule__ArrayTypeRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:5315:2: rule__ArrayTypeRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:5321:1: rule__ArrayTypeRule__Group__1__Impl : ( ( rule__ArrayTypeRule__ElementsAssignment_1 ) ) ;
    public final void rule__ArrayTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5325:1: ( ( ( rule__ArrayTypeRule__ElementsAssignment_1 ) ) )
            // InternalOptimisationLanguage.g:5326:1: ( ( rule__ArrayTypeRule__ElementsAssignment_1 ) )
            {
            // InternalOptimisationLanguage.g:5326:1: ( ( rule__ArrayTypeRule__ElementsAssignment_1 ) )
            // InternalOptimisationLanguage.g:5327:2: ( rule__ArrayTypeRule__ElementsAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayTypeRuleAccess().getElementsAssignment_1()); 
            }
            // InternalOptimisationLanguage.g:5328:2: ( rule__ArrayTypeRule__ElementsAssignment_1 )
            // InternalOptimisationLanguage.g:5328:3: rule__ArrayTypeRule__ElementsAssignment_1
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
    // InternalOptimisationLanguage.g:5337:1: rule__ParameterRule__Group__0 : rule__ParameterRule__Group__0__Impl rule__ParameterRule__Group__1 ;
    public final void rule__ParameterRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5341:1: ( rule__ParameterRule__Group__0__Impl rule__ParameterRule__Group__1 )
            // InternalOptimisationLanguage.g:5342:2: rule__ParameterRule__Group__0__Impl rule__ParameterRule__Group__1
            {
            pushFollow(FOLLOW_5);
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
    // InternalOptimisationLanguage.g:5349:1: rule__ParameterRule__Group__0__Impl : ( ( rule__ParameterRule__TypeAssignment_0 ) ) ;
    public final void rule__ParameterRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5353:1: ( ( ( rule__ParameterRule__TypeAssignment_0 ) ) )
            // InternalOptimisationLanguage.g:5354:1: ( ( rule__ParameterRule__TypeAssignment_0 ) )
            {
            // InternalOptimisationLanguage.g:5354:1: ( ( rule__ParameterRule__TypeAssignment_0 ) )
            // InternalOptimisationLanguage.g:5355:2: ( rule__ParameterRule__TypeAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterRuleAccess().getTypeAssignment_0()); 
            }
            // InternalOptimisationLanguage.g:5356:2: ( rule__ParameterRule__TypeAssignment_0 )
            // InternalOptimisationLanguage.g:5356:3: rule__ParameterRule__TypeAssignment_0
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
    // InternalOptimisationLanguage.g:5364:1: rule__ParameterRule__Group__1 : rule__ParameterRule__Group__1__Impl ;
    public final void rule__ParameterRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5368:1: ( rule__ParameterRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:5369:2: rule__ParameterRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:5375:1: rule__ParameterRule__Group__1__Impl : ( ( rule__ParameterRule__NameAssignment_1 ) ) ;
    public final void rule__ParameterRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5379:1: ( ( ( rule__ParameterRule__NameAssignment_1 ) ) )
            // InternalOptimisationLanguage.g:5380:1: ( ( rule__ParameterRule__NameAssignment_1 ) )
            {
            // InternalOptimisationLanguage.g:5380:1: ( ( rule__ParameterRule__NameAssignment_1 ) )
            // InternalOptimisationLanguage.g:5381:2: ( rule__ParameterRule__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterRuleAccess().getNameAssignment_1()); 
            }
            // InternalOptimisationLanguage.g:5382:2: ( rule__ParameterRule__NameAssignment_1 )
            // InternalOptimisationLanguage.g:5382:3: rule__ParameterRule__NameAssignment_1
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
    // InternalOptimisationLanguage.g:5391:1: rule__ImportRule__Group__0 : rule__ImportRule__Group__0__Impl rule__ImportRule__Group__1 ;
    public final void rule__ImportRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5395:1: ( rule__ImportRule__Group__0__Impl rule__ImportRule__Group__1 )
            // InternalOptimisationLanguage.g:5396:2: rule__ImportRule__Group__0__Impl rule__ImportRule__Group__1
            {
            pushFollow(FOLLOW_52);
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
    // InternalOptimisationLanguage.g:5403:1: rule__ImportRule__Group__0__Impl : ( 'import' ) ;
    public final void rule__ImportRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5407:1: ( ( 'import' ) )
            // InternalOptimisationLanguage.g:5408:1: ( 'import' )
            {
            // InternalOptimisationLanguage.g:5408:1: ( 'import' )
            // InternalOptimisationLanguage.g:5409:2: 'import'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportRuleAccess().getImportKeyword_0()); 
            }
            match(input,79,FOLLOW_2); if (state.failed) return ;
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
    // InternalOptimisationLanguage.g:5418:1: rule__ImportRule__Group__1 : rule__ImportRule__Group__1__Impl rule__ImportRule__Group__2 ;
    public final void rule__ImportRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5422:1: ( rule__ImportRule__Group__1__Impl rule__ImportRule__Group__2 )
            // InternalOptimisationLanguage.g:5423:2: rule__ImportRule__Group__1__Impl rule__ImportRule__Group__2
            {
            pushFollow(FOLLOW_53);
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
    // InternalOptimisationLanguage.g:5430:1: rule__ImportRule__Group__1__Impl : ( ( rule__ImportRule__LanguageAssignment_1 ) ) ;
    public final void rule__ImportRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5434:1: ( ( ( rule__ImportRule__LanguageAssignment_1 ) ) )
            // InternalOptimisationLanguage.g:5435:1: ( ( rule__ImportRule__LanguageAssignment_1 ) )
            {
            // InternalOptimisationLanguage.g:5435:1: ( ( rule__ImportRule__LanguageAssignment_1 ) )
            // InternalOptimisationLanguage.g:5436:2: ( rule__ImportRule__LanguageAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportRuleAccess().getLanguageAssignment_1()); 
            }
            // InternalOptimisationLanguage.g:5437:2: ( rule__ImportRule__LanguageAssignment_1 )
            // InternalOptimisationLanguage.g:5437:3: rule__ImportRule__LanguageAssignment_1
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
    // InternalOptimisationLanguage.g:5445:1: rule__ImportRule__Group__2 : rule__ImportRule__Group__2__Impl rule__ImportRule__Group__3 ;
    public final void rule__ImportRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5449:1: ( rule__ImportRule__Group__2__Impl rule__ImportRule__Group__3 )
            // InternalOptimisationLanguage.g:5450:2: rule__ImportRule__Group__2__Impl rule__ImportRule__Group__3
            {
            pushFollow(FOLLOW_5);
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
    // InternalOptimisationLanguage.g:5457:1: rule__ImportRule__Group__2__Impl : ( 'from' ) ;
    public final void rule__ImportRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5461:1: ( ( 'from' ) )
            // InternalOptimisationLanguage.g:5462:1: ( 'from' )
            {
            // InternalOptimisationLanguage.g:5462:1: ( 'from' )
            // InternalOptimisationLanguage.g:5463:2: 'from'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportRuleAccess().getFromKeyword_2()); 
            }
            match(input,80,FOLLOW_2); if (state.failed) return ;
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
    // InternalOptimisationLanguage.g:5472:1: rule__ImportRule__Group__3 : rule__ImportRule__Group__3__Impl rule__ImportRule__Group__4 ;
    public final void rule__ImportRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5476:1: ( rule__ImportRule__Group__3__Impl rule__ImportRule__Group__4 )
            // InternalOptimisationLanguage.g:5477:2: rule__ImportRule__Group__3__Impl rule__ImportRule__Group__4
            {
            pushFollow(FOLLOW_12);
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
    // InternalOptimisationLanguage.g:5484:1: rule__ImportRule__Group__3__Impl : ( ( rule__ImportRule__ImportedNamespaceAssignment_3 ) ) ;
    public final void rule__ImportRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5488:1: ( ( ( rule__ImportRule__ImportedNamespaceAssignment_3 ) ) )
            // InternalOptimisationLanguage.g:5489:1: ( ( rule__ImportRule__ImportedNamespaceAssignment_3 ) )
            {
            // InternalOptimisationLanguage.g:5489:1: ( ( rule__ImportRule__ImportedNamespaceAssignment_3 ) )
            // InternalOptimisationLanguage.g:5490:2: ( rule__ImportRule__ImportedNamespaceAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportRuleAccess().getImportedNamespaceAssignment_3()); 
            }
            // InternalOptimisationLanguage.g:5491:2: ( rule__ImportRule__ImportedNamespaceAssignment_3 )
            // InternalOptimisationLanguage.g:5491:3: rule__ImportRule__ImportedNamespaceAssignment_3
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
    // InternalOptimisationLanguage.g:5499:1: rule__ImportRule__Group__4 : rule__ImportRule__Group__4__Impl ;
    public final void rule__ImportRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5503:1: ( rule__ImportRule__Group__4__Impl )
            // InternalOptimisationLanguage.g:5504:2: rule__ImportRule__Group__4__Impl
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
    // InternalOptimisationLanguage.g:5510:1: rule__ImportRule__Group__4__Impl : ( ';' ) ;
    public final void rule__ImportRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5514:1: ( ( ';' ) )
            // InternalOptimisationLanguage.g:5515:1: ( ';' )
            {
            // InternalOptimisationLanguage.g:5515:1: ( ';' )
            // InternalOptimisationLanguage.g:5516:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportRuleAccess().getSemicolonKeyword_4()); 
            }
            match(input,53,FOLLOW_2); if (state.failed) return ;
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
    // InternalOptimisationLanguage.g:5526:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5530:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // InternalOptimisationLanguage.g:5531:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_54);
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
    // InternalOptimisationLanguage.g:5538:1: rule__QualifiedName__Group__0__Impl : ( ruleStringOrId ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5542:1: ( ( ruleStringOrId ) )
            // InternalOptimisationLanguage.g:5543:1: ( ruleStringOrId )
            {
            // InternalOptimisationLanguage.g:5543:1: ( ruleStringOrId )
            // InternalOptimisationLanguage.g:5544:2: ruleStringOrId
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
    // InternalOptimisationLanguage.g:5553:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5557:1: ( rule__QualifiedName__Group__1__Impl )
            // InternalOptimisationLanguage.g:5558:2: rule__QualifiedName__Group__1__Impl
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
    // InternalOptimisationLanguage.g:5564:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5568:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // InternalOptimisationLanguage.g:5569:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // InternalOptimisationLanguage.g:5569:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // InternalOptimisationLanguage.g:5570:2: ( rule__QualifiedName__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            }
            // InternalOptimisationLanguage.g:5571:2: ( rule__QualifiedName__Group_1__0 )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==81) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:5571:3: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_55);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop37;
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
    // InternalOptimisationLanguage.g:5580:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5584:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // InternalOptimisationLanguage.g:5585:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
            {
            pushFollow(FOLLOW_5);
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
    // InternalOptimisationLanguage.g:5592:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5596:1: ( ( '.' ) )
            // InternalOptimisationLanguage.g:5597:1: ( '.' )
            {
            // InternalOptimisationLanguage.g:5597:1: ( '.' )
            // InternalOptimisationLanguage.g:5598:2: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            }
            match(input,81,FOLLOW_2); if (state.failed) return ;
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
    // InternalOptimisationLanguage.g:5607:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5611:1: ( rule__QualifiedName__Group_1__1__Impl )
            // InternalOptimisationLanguage.g:5612:2: rule__QualifiedName__Group_1__1__Impl
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
    // InternalOptimisationLanguage.g:5618:1: rule__QualifiedName__Group_1__1__Impl : ( ruleStringOrId ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5622:1: ( ( ruleStringOrId ) )
            // InternalOptimisationLanguage.g:5623:1: ( ruleStringOrId )
            {
            // InternalOptimisationLanguage.g:5623:1: ( ruleStringOrId )
            // InternalOptimisationLanguage.g:5624:2: ruleStringOrId
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


    // $ANTLR start "rule__OptimisationModelRule__ImportsAssignment_0"
    // InternalOptimisationLanguage.g:5634:1: rule__OptimisationModelRule__ImportsAssignment_0 : ( ruleImportRule ) ;
    public final void rule__OptimisationModelRule__ImportsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5638:1: ( ( ruleImportRule ) )
            // InternalOptimisationLanguage.g:5639:2: ( ruleImportRule )
            {
            // InternalOptimisationLanguage.g:5639:2: ( ruleImportRule )
            // InternalOptimisationLanguage.g:5640:3: ruleImportRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOptimisationModelRuleAccess().getImportsImportRuleParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleImportRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOptimisationModelRuleAccess().getImportsImportRuleParserRuleCall_0_0()); 
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
    // $ANTLR end "rule__OptimisationModelRule__ImportsAssignment_0"


    // $ANTLR start "rule__OptimisationModelRule__NameAssignment_2"
    // InternalOptimisationLanguage.g:5649:1: rule__OptimisationModelRule__NameAssignment_2 : ( ruleQualifiedName ) ;
    public final void rule__OptimisationModelRule__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5653:1: ( ( ruleQualifiedName ) )
            // InternalOptimisationLanguage.g:5654:2: ( ruleQualifiedName )
            {
            // InternalOptimisationLanguage.g:5654:2: ( ruleQualifiedName )
            // InternalOptimisationLanguage.g:5655:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOptimisationModelRuleAccess().getNameQualifiedNameParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOptimisationModelRuleAccess().getNameQualifiedNameParserRuleCall_2_0()); 
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
    // $ANTLR end "rule__OptimisationModelRule__NameAssignment_2"


    // $ANTLR start "rule__OptimisationModelRule__ProblemAssignment_4"
    // InternalOptimisationLanguage.g:5664:1: rule__OptimisationModelRule__ProblemAssignment_4 : ( ruleProblemRule ) ;
    public final void rule__OptimisationModelRule__ProblemAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5668:1: ( ( ruleProblemRule ) )
            // InternalOptimisationLanguage.g:5669:2: ( ruleProblemRule )
            {
            // InternalOptimisationLanguage.g:5669:2: ( ruleProblemRule )
            // InternalOptimisationLanguage.g:5670:3: ruleProblemRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOptimisationModelRuleAccess().getProblemProblemRuleParserRuleCall_4_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleProblemRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOptimisationModelRuleAccess().getProblemProblemRuleParserRuleCall_4_0()); 
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
    // $ANTLR end "rule__OptimisationModelRule__ProblemAssignment_4"


    // $ANTLR start "rule__OptimisationModelRule__AlgorithmAssignment_5"
    // InternalOptimisationLanguage.g:5679:1: rule__OptimisationModelRule__AlgorithmAssignment_5 : ( ruleAlgorithmInstanceRule ) ;
    public final void rule__OptimisationModelRule__AlgorithmAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5683:1: ( ( ruleAlgorithmInstanceRule ) )
            // InternalOptimisationLanguage.g:5684:2: ( ruleAlgorithmInstanceRule )
            {
            // InternalOptimisationLanguage.g:5684:2: ( ruleAlgorithmInstanceRule )
            // InternalOptimisationLanguage.g:5685:3: ruleAlgorithmInstanceRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOptimisationModelRuleAccess().getAlgorithmAlgorithmInstanceRuleParserRuleCall_5_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleAlgorithmInstanceRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOptimisationModelRuleAccess().getAlgorithmAlgorithmInstanceRuleParserRuleCall_5_0()); 
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
    // $ANTLR end "rule__OptimisationModelRule__AlgorithmAssignment_5"


    // $ANTLR start "rule__ProblemRule__DefinitionAssignment_1"
    // InternalOptimisationLanguage.g:5694:1: rule__ProblemRule__DefinitionAssignment_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__ProblemRule__DefinitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5698:1: ( ( ( ruleQualifiedName ) ) )
            // InternalOptimisationLanguage.g:5699:2: ( ( ruleQualifiedName ) )
            {
            // InternalOptimisationLanguage.g:5699:2: ( ( ruleQualifiedName ) )
            // InternalOptimisationLanguage.g:5700:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProblemRuleAccess().getDefinitionTypeDefinitionCrossReference_1_0()); 
            }
            // InternalOptimisationLanguage.g:5701:3: ( ruleQualifiedName )
            // InternalOptimisationLanguage.g:5702:4: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProblemRuleAccess().getDefinitionTypeDefinitionQualifiedNameParserRuleCall_1_0_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getProblemRuleAccess().getDefinitionTypeDefinitionQualifiedNameParserRuleCall_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getProblemRuleAccess().getDefinitionTypeDefinitionCrossReference_1_0()); 
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
    // $ANTLR end "rule__ProblemRule__DefinitionAssignment_1"


    // $ANTLR start "rule__ProblemRule__NameAssignment_2"
    // InternalOptimisationLanguage.g:5713:1: rule__ProblemRule__NameAssignment_2 : ( ruleStringOrId ) ;
    public final void rule__ProblemRule__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5717:1: ( ( ruleStringOrId ) )
            // InternalOptimisationLanguage.g:5718:2: ( ruleStringOrId )
            {
            // InternalOptimisationLanguage.g:5718:2: ( ruleStringOrId )
            // InternalOptimisationLanguage.g:5719:3: ruleStringOrId
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProblemRuleAccess().getNameStringOrIdParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleStringOrId();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getProblemRuleAccess().getNameStringOrIdParserRuleCall_2_0()); 
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
    // $ANTLR end "rule__ProblemRule__NameAssignment_2"


    // $ANTLR start "rule__ProblemRule__AttributesAssignment_4"
    // InternalOptimisationLanguage.g:5728:1: rule__ProblemRule__AttributesAssignment_4 : ( ruleAttributeRule ) ;
    public final void rule__ProblemRule__AttributesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5732:1: ( ( ruleAttributeRule ) )
            // InternalOptimisationLanguage.g:5733:2: ( ruleAttributeRule )
            {
            // InternalOptimisationLanguage.g:5733:2: ( ruleAttributeRule )
            // InternalOptimisationLanguage.g:5734:3: ruleAttributeRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProblemRuleAccess().getAttributesAttributeRuleParserRuleCall_4_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleAttributeRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getProblemRuleAccess().getAttributesAttributeRuleParserRuleCall_4_0()); 
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
    // $ANTLR end "rule__ProblemRule__AttributesAssignment_4"


    // $ANTLR start "rule__ProblemRule__DocumentationAssignment_5_2"
    // InternalOptimisationLanguage.g:5743:1: rule__ProblemRule__DocumentationAssignment_5_2 : ( ruleArrayRule ) ;
    public final void rule__ProblemRule__DocumentationAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5747:1: ( ( ruleArrayRule ) )
            // InternalOptimisationLanguage.g:5748:2: ( ruleArrayRule )
            {
            // InternalOptimisationLanguage.g:5748:2: ( ruleArrayRule )
            // InternalOptimisationLanguage.g:5749:3: ruleArrayRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProblemRuleAccess().getDocumentationArrayRuleParserRuleCall_5_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleArrayRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getProblemRuleAccess().getDocumentationArrayRuleParserRuleCall_5_2_0()); 
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
    // $ANTLR end "rule__ProblemRule__DocumentationAssignment_5_2"


    // $ANTLR start "rule__AlgorithmInstanceRule__DefinitionAssignment_1"
    // InternalOptimisationLanguage.g:5758:1: rule__AlgorithmInstanceRule__DefinitionAssignment_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__AlgorithmInstanceRule__DefinitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5762:1: ( ( ( ruleQualifiedName ) ) )
            // InternalOptimisationLanguage.g:5763:2: ( ( ruleQualifiedName ) )
            {
            // InternalOptimisationLanguage.g:5763:2: ( ( ruleQualifiedName ) )
            // InternalOptimisationLanguage.g:5764:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAlgorithmInstanceRuleAccess().getDefinitionTypeDefinitionCrossReference_1_0()); 
            }
            // InternalOptimisationLanguage.g:5765:3: ( ruleQualifiedName )
            // InternalOptimisationLanguage.g:5766:4: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAlgorithmInstanceRuleAccess().getDefinitionTypeDefinitionQualifiedNameParserRuleCall_1_0_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAlgorithmInstanceRuleAccess().getDefinitionTypeDefinitionQualifiedNameParserRuleCall_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAlgorithmInstanceRuleAccess().getDefinitionTypeDefinitionCrossReference_1_0()); 
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
    // $ANTLR end "rule__AlgorithmInstanceRule__DefinitionAssignment_1"


    // $ANTLR start "rule__AlgorithmInstanceRule__ProblemAssignment_3"
    // InternalOptimisationLanguage.g:5777:1: rule__AlgorithmInstanceRule__ProblemAssignment_3 : ( ( ruleQualifiedName ) ) ;
    public final void rule__AlgorithmInstanceRule__ProblemAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5781:1: ( ( ( ruleQualifiedName ) ) )
            // InternalOptimisationLanguage.g:5782:2: ( ( ruleQualifiedName ) )
            {
            // InternalOptimisationLanguage.g:5782:2: ( ( ruleQualifiedName ) )
            // InternalOptimisationLanguage.g:5783:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAlgorithmInstanceRuleAccess().getProblemProblemInstanceCrossReference_3_0()); 
            }
            // InternalOptimisationLanguage.g:5784:3: ( ruleQualifiedName )
            // InternalOptimisationLanguage.g:5785:4: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAlgorithmInstanceRuleAccess().getProblemProblemInstanceQualifiedNameParserRuleCall_3_0_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAlgorithmInstanceRuleAccess().getProblemProblemInstanceQualifiedNameParserRuleCall_3_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAlgorithmInstanceRuleAccess().getProblemProblemInstanceCrossReference_3_0()); 
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
    // $ANTLR end "rule__AlgorithmInstanceRule__ProblemAssignment_3"


    // $ANTLR start "rule__AlgorithmInstanceRule__AttributesAssignment_5"
    // InternalOptimisationLanguage.g:5796:1: rule__AlgorithmInstanceRule__AttributesAssignment_5 : ( ruleAttributeRule ) ;
    public final void rule__AlgorithmInstanceRule__AttributesAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5800:1: ( ( ruleAttributeRule ) )
            // InternalOptimisationLanguage.g:5801:2: ( ruleAttributeRule )
            {
            // InternalOptimisationLanguage.g:5801:2: ( ruleAttributeRule )
            // InternalOptimisationLanguage.g:5802:3: ruleAttributeRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAlgorithmInstanceRuleAccess().getAttributesAttributeRuleParserRuleCall_5_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleAttributeRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAlgorithmInstanceRuleAccess().getAttributesAttributeRuleParserRuleCall_5_0()); 
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
    // $ANTLR end "rule__AlgorithmInstanceRule__AttributesAssignment_5"


    // $ANTLR start "rule__AlgorithmInstanceRule__DocumentationAssignment_6_2"
    // InternalOptimisationLanguage.g:5811:1: rule__AlgorithmInstanceRule__DocumentationAssignment_6_2 : ( ruleArrayRule ) ;
    public final void rule__AlgorithmInstanceRule__DocumentationAssignment_6_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5815:1: ( ( ruleArrayRule ) )
            // InternalOptimisationLanguage.g:5816:2: ( ruleArrayRule )
            {
            // InternalOptimisationLanguage.g:5816:2: ( ruleArrayRule )
            // InternalOptimisationLanguage.g:5817:3: ruleArrayRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAlgorithmInstanceRuleAccess().getDocumentationArrayRuleParserRuleCall_6_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleArrayRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAlgorithmInstanceRuleAccess().getDocumentationArrayRuleParserRuleCall_6_2_0()); 
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
    // $ANTLR end "rule__AlgorithmInstanceRule__DocumentationAssignment_6_2"


    // $ANTLR start "rule__DataReferenceRule__DefinitionAssignment_2"
    // InternalOptimisationLanguage.g:5826:1: rule__DataReferenceRule__DefinitionAssignment_2 : ( ( ruleQualifiedName ) ) ;
    public final void rule__DataReferenceRule__DefinitionAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5830:1: ( ( ( ruleQualifiedName ) ) )
            // InternalOptimisationLanguage.g:5831:2: ( ( ruleQualifiedName ) )
            {
            // InternalOptimisationLanguage.g:5831:2: ( ( ruleQualifiedName ) )
            // InternalOptimisationLanguage.g:5832:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataReferenceRuleAccess().getDefinitionDataDescriptionCrossReference_2_0()); 
            }
            // InternalOptimisationLanguage.g:5833:3: ( ruleQualifiedName )
            // InternalOptimisationLanguage.g:5834:4: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataReferenceRuleAccess().getDefinitionDataDescriptionQualifiedNameParserRuleCall_2_0_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataReferenceRuleAccess().getDefinitionDataDescriptionQualifiedNameParserRuleCall_2_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataReferenceRuleAccess().getDefinitionDataDescriptionCrossReference_2_0()); 
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
    // $ANTLR end "rule__DataReferenceRule__DefinitionAssignment_2"


    // $ANTLR start "rule__OrExpressionRule__SubExpressionsAssignment_0"
    // InternalOptimisationLanguage.g:5845:1: rule__OrExpressionRule__SubExpressionsAssignment_0 : ( ruleXorExpressionRule ) ;
    public final void rule__OrExpressionRule__SubExpressionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5849:1: ( ( ruleXorExpressionRule ) )
            // InternalOptimisationLanguage.g:5850:2: ( ruleXorExpressionRule )
            {
            // InternalOptimisationLanguage.g:5850:2: ( ruleXorExpressionRule )
            // InternalOptimisationLanguage.g:5851:3: ruleXorExpressionRule
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
    // InternalOptimisationLanguage.g:5860:1: rule__OrExpressionRule__SubExpressionsAssignment_1_1 : ( ruleXorExpressionRule ) ;
    public final void rule__OrExpressionRule__SubExpressionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5864:1: ( ( ruleXorExpressionRule ) )
            // InternalOptimisationLanguage.g:5865:2: ( ruleXorExpressionRule )
            {
            // InternalOptimisationLanguage.g:5865:2: ( ruleXorExpressionRule )
            // InternalOptimisationLanguage.g:5866:3: ruleXorExpressionRule
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
    // InternalOptimisationLanguage.g:5875:1: rule__XorExpressionRule__SubExpressionsAssignment_0 : ( ruleAndExpressionRule ) ;
    public final void rule__XorExpressionRule__SubExpressionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5879:1: ( ( ruleAndExpressionRule ) )
            // InternalOptimisationLanguage.g:5880:2: ( ruleAndExpressionRule )
            {
            // InternalOptimisationLanguage.g:5880:2: ( ruleAndExpressionRule )
            // InternalOptimisationLanguage.g:5881:3: ruleAndExpressionRule
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
    // InternalOptimisationLanguage.g:5890:1: rule__XorExpressionRule__SubExpressionsAssignment_1_1 : ( ruleAndExpressionRule ) ;
    public final void rule__XorExpressionRule__SubExpressionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5894:1: ( ( ruleAndExpressionRule ) )
            // InternalOptimisationLanguage.g:5895:2: ( ruleAndExpressionRule )
            {
            // InternalOptimisationLanguage.g:5895:2: ( ruleAndExpressionRule )
            // InternalOptimisationLanguage.g:5896:3: ruleAndExpressionRule
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
    // InternalOptimisationLanguage.g:5905:1: rule__AndExpressionRule__SubExpressionsAssignment_0 : ( ruleNotExpressionRule ) ;
    public final void rule__AndExpressionRule__SubExpressionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5909:1: ( ( ruleNotExpressionRule ) )
            // InternalOptimisationLanguage.g:5910:2: ( ruleNotExpressionRule )
            {
            // InternalOptimisationLanguage.g:5910:2: ( ruleNotExpressionRule )
            // InternalOptimisationLanguage.g:5911:3: ruleNotExpressionRule
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
    // InternalOptimisationLanguage.g:5920:1: rule__AndExpressionRule__SubExpressionsAssignment_1_1 : ( ruleNotExpressionRule ) ;
    public final void rule__AndExpressionRule__SubExpressionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5924:1: ( ( ruleNotExpressionRule ) )
            // InternalOptimisationLanguage.g:5925:2: ( ruleNotExpressionRule )
            {
            // InternalOptimisationLanguage.g:5925:2: ( ruleNotExpressionRule )
            // InternalOptimisationLanguage.g:5926:3: ruleNotExpressionRule
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
    // InternalOptimisationLanguage.g:5935:1: rule__NotExpressionRule__NegatedAssignment_0 : ( ( '!' ) ) ;
    public final void rule__NotExpressionRule__NegatedAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5939:1: ( ( ( '!' ) ) )
            // InternalOptimisationLanguage.g:5940:2: ( ( '!' ) )
            {
            // InternalOptimisationLanguage.g:5940:2: ( ( '!' ) )
            // InternalOptimisationLanguage.g:5941:3: ( '!' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNotExpressionRuleAccess().getNegatedExclamationMarkKeyword_0_0()); 
            }
            // InternalOptimisationLanguage.g:5942:3: ( '!' )
            // InternalOptimisationLanguage.g:5943:4: '!'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNotExpressionRuleAccess().getNegatedExclamationMarkKeyword_0_0()); 
            }
            match(input,82,FOLLOW_2); if (state.failed) return ;
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
    // InternalOptimisationLanguage.g:5954:1: rule__NotExpressionRule__OperandAssignment_1 : ( ruleComparisonExpressionRule ) ;
    public final void rule__NotExpressionRule__OperandAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5958:1: ( ( ruleComparisonExpressionRule ) )
            // InternalOptimisationLanguage.g:5959:2: ( ruleComparisonExpressionRule )
            {
            // InternalOptimisationLanguage.g:5959:2: ( ruleComparisonExpressionRule )
            // InternalOptimisationLanguage.g:5960:3: ruleComparisonExpressionRule
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
    // InternalOptimisationLanguage.g:5969:1: rule__ComparisonExpressionRule__LeftOperandAssignment_0 : ( ruleAddOrSubtractExpressionRule ) ;
    public final void rule__ComparisonExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5973:1: ( ( ruleAddOrSubtractExpressionRule ) )
            // InternalOptimisationLanguage.g:5974:2: ( ruleAddOrSubtractExpressionRule )
            {
            // InternalOptimisationLanguage.g:5974:2: ( ruleAddOrSubtractExpressionRule )
            // InternalOptimisationLanguage.g:5975:3: ruleAddOrSubtractExpressionRule
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
    // InternalOptimisationLanguage.g:5984:1: rule__ComparisonExpressionRule__ComparisonAssignment_1 : ( rulePartialComparisonExpressionRule ) ;
    public final void rule__ComparisonExpressionRule__ComparisonAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5988:1: ( ( rulePartialComparisonExpressionRule ) )
            // InternalOptimisationLanguage.g:5989:2: ( rulePartialComparisonExpressionRule )
            {
            // InternalOptimisationLanguage.g:5989:2: ( rulePartialComparisonExpressionRule )
            // InternalOptimisationLanguage.g:5990:3: rulePartialComparisonExpressionRule
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
    // InternalOptimisationLanguage.g:5999:1: rule__PartialComparisonExpressionRule__OperatorAssignment_0 : ( ruleComparisonOperatorRule ) ;
    public final void rule__PartialComparisonExpressionRule__OperatorAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6003:1: ( ( ruleComparisonOperatorRule ) )
            // InternalOptimisationLanguage.g:6004:2: ( ruleComparisonOperatorRule )
            {
            // InternalOptimisationLanguage.g:6004:2: ( ruleComparisonOperatorRule )
            // InternalOptimisationLanguage.g:6005:3: ruleComparisonOperatorRule
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
    // InternalOptimisationLanguage.g:6014:1: rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 : ( ruleAddOrSubtractExpressionRule ) ;
    public final void rule__PartialComparisonExpressionRule__SubExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6018:1: ( ( ruleAddOrSubtractExpressionRule ) )
            // InternalOptimisationLanguage.g:6019:2: ( ruleAddOrSubtractExpressionRule )
            {
            // InternalOptimisationLanguage.g:6019:2: ( ruleAddOrSubtractExpressionRule )
            // InternalOptimisationLanguage.g:6020:3: ruleAddOrSubtractExpressionRule
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
    // InternalOptimisationLanguage.g:6029:1: rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 : ( ruleMultiplyDivideModuloExpressionRule ) ;
    public final void rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6033:1: ( ( ruleMultiplyDivideModuloExpressionRule ) )
            // InternalOptimisationLanguage.g:6034:2: ( ruleMultiplyDivideModuloExpressionRule )
            {
            // InternalOptimisationLanguage.g:6034:2: ( ruleMultiplyDivideModuloExpressionRule )
            // InternalOptimisationLanguage.g:6035:3: ruleMultiplyDivideModuloExpressionRule
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
    // InternalOptimisationLanguage.g:6044:1: rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 : ( ruleAddOrSubtractOperatorRule ) ;
    public final void rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6048:1: ( ( ruleAddOrSubtractOperatorRule ) )
            // InternalOptimisationLanguage.g:6049:2: ( ruleAddOrSubtractOperatorRule )
            {
            // InternalOptimisationLanguage.g:6049:2: ( ruleAddOrSubtractOperatorRule )
            // InternalOptimisationLanguage.g:6050:3: ruleAddOrSubtractOperatorRule
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
    // InternalOptimisationLanguage.g:6059:1: rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 : ( ruleMultiplyDivideModuloExpressionRule ) ;
    public final void rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6063:1: ( ( ruleMultiplyDivideModuloExpressionRule ) )
            // InternalOptimisationLanguage.g:6064:2: ( ruleMultiplyDivideModuloExpressionRule )
            {
            // InternalOptimisationLanguage.g:6064:2: ( ruleMultiplyDivideModuloExpressionRule )
            // InternalOptimisationLanguage.g:6065:3: ruleMultiplyDivideModuloExpressionRule
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
    // InternalOptimisationLanguage.g:6074:1: rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 : ( rulePowerOfExpressionRule ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6078:1: ( ( rulePowerOfExpressionRule ) )
            // InternalOptimisationLanguage.g:6079:2: ( rulePowerOfExpressionRule )
            {
            // InternalOptimisationLanguage.g:6079:2: ( rulePowerOfExpressionRule )
            // InternalOptimisationLanguage.g:6080:3: rulePowerOfExpressionRule
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
    // InternalOptimisationLanguage.g:6089:1: rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 : ( ruleMultiplyDivideModuloOperatorRule ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6093:1: ( ( ruleMultiplyDivideModuloOperatorRule ) )
            // InternalOptimisationLanguage.g:6094:2: ( ruleMultiplyDivideModuloOperatorRule )
            {
            // InternalOptimisationLanguage.g:6094:2: ( ruleMultiplyDivideModuloOperatorRule )
            // InternalOptimisationLanguage.g:6095:3: ruleMultiplyDivideModuloOperatorRule
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
    // InternalOptimisationLanguage.g:6104:1: rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 : ( rulePowerOfExpressionRule ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6108:1: ( ( rulePowerOfExpressionRule ) )
            // InternalOptimisationLanguage.g:6109:2: ( rulePowerOfExpressionRule )
            {
            // InternalOptimisationLanguage.g:6109:2: ( rulePowerOfExpressionRule )
            // InternalOptimisationLanguage.g:6110:3: rulePowerOfExpressionRule
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
    // InternalOptimisationLanguage.g:6119:1: rule__PowerOfExpressionRule__LeftOperandAssignment_0 : ( ruleUnaryAddOrSubtractExpressionRule ) ;
    public final void rule__PowerOfExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6123:1: ( ( ruleUnaryAddOrSubtractExpressionRule ) )
            // InternalOptimisationLanguage.g:6124:2: ( ruleUnaryAddOrSubtractExpressionRule )
            {
            // InternalOptimisationLanguage.g:6124:2: ( ruleUnaryAddOrSubtractExpressionRule )
            // InternalOptimisationLanguage.g:6125:3: ruleUnaryAddOrSubtractExpressionRule
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
    // InternalOptimisationLanguage.g:6134:1: rule__PowerOfExpressionRule__RightOperandAssignment_1_1 : ( rulePowerOfExpressionRule ) ;
    public final void rule__PowerOfExpressionRule__RightOperandAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6138:1: ( ( rulePowerOfExpressionRule ) )
            // InternalOptimisationLanguage.g:6139:2: ( rulePowerOfExpressionRule )
            {
            // InternalOptimisationLanguage.g:6139:2: ( rulePowerOfExpressionRule )
            // InternalOptimisationLanguage.g:6140:3: rulePowerOfExpressionRule
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
    // InternalOptimisationLanguage.g:6149:1: rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 : ( ruleAddOrSubtractOperatorRule ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6153:1: ( ( ruleAddOrSubtractOperatorRule ) )
            // InternalOptimisationLanguage.g:6154:2: ( ruleAddOrSubtractOperatorRule )
            {
            // InternalOptimisationLanguage.g:6154:2: ( ruleAddOrSubtractOperatorRule )
            // InternalOptimisationLanguage.g:6155:3: ruleAddOrSubtractOperatorRule
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
    // InternalOptimisationLanguage.g:6164:1: rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 : ( ruleValueRule ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6168:1: ( ( ruleValueRule ) )
            // InternalOptimisationLanguage.g:6169:2: ( ruleValueRule )
            {
            // InternalOptimisationLanguage.g:6169:2: ( ruleValueRule )
            // InternalOptimisationLanguage.g:6170:3: ruleValueRule
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
    // InternalOptimisationLanguage.g:6179:1: rule__ArrayRule__ValuesAssignment_2_0 : ( ruleValueRule ) ;
    public final void rule__ArrayRule__ValuesAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6183:1: ( ( ruleValueRule ) )
            // InternalOptimisationLanguage.g:6184:2: ( ruleValueRule )
            {
            // InternalOptimisationLanguage.g:6184:2: ( ruleValueRule )
            // InternalOptimisationLanguage.g:6185:3: ruleValueRule
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
    // InternalOptimisationLanguage.g:6194:1: rule__ArrayRule__ValuesAssignment_2_1_1 : ( ruleValueRule ) ;
    public final void rule__ArrayRule__ValuesAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6198:1: ( ( ruleValueRule ) )
            // InternalOptimisationLanguage.g:6199:2: ( ruleValueRule )
            {
            // InternalOptimisationLanguage.g:6199:2: ( ruleValueRule )
            // InternalOptimisationLanguage.g:6200:3: ruleValueRule
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
    // InternalOptimisationLanguage.g:6209:1: rule__ParanthesesRule__SubExpressionAssignment_1 : ( ruleExpressionRule ) ;
    public final void rule__ParanthesesRule__SubExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6213:1: ( ( ruleExpressionRule ) )
            // InternalOptimisationLanguage.g:6214:2: ( ruleExpressionRule )
            {
            // InternalOptimisationLanguage.g:6214:2: ( ruleExpressionRule )
            // InternalOptimisationLanguage.g:6215:3: ruleExpressionRule
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
    // InternalOptimisationLanguage.g:6224:1: rule__CallRule__FunctionAssignment_0 : ( ruleFunctionNameRule ) ;
    public final void rule__CallRule__FunctionAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6228:1: ( ( ruleFunctionNameRule ) )
            // InternalOptimisationLanguage.g:6229:2: ( ruleFunctionNameRule )
            {
            // InternalOptimisationLanguage.g:6229:2: ( ruleFunctionNameRule )
            // InternalOptimisationLanguage.g:6230:3: ruleFunctionNameRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getFunctionFunctionNameRuleParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleFunctionNameRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCallRuleAccess().getFunctionFunctionNameRuleParserRuleCall_0_0()); 
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
    // InternalOptimisationLanguage.g:6239:1: rule__CallRule__ParametersAssignment_2_0 : ( ruleExpressionRule ) ;
    public final void rule__CallRule__ParametersAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6243:1: ( ( ruleExpressionRule ) )
            // InternalOptimisationLanguage.g:6244:2: ( ruleExpressionRule )
            {
            // InternalOptimisationLanguage.g:6244:2: ( ruleExpressionRule )
            // InternalOptimisationLanguage.g:6245:3: ruleExpressionRule
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
    // InternalOptimisationLanguage.g:6254:1: rule__CallRule__ParametersAssignment_2_1_1 : ( ruleExpressionRule ) ;
    public final void rule__CallRule__ParametersAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6258:1: ( ( ruleExpressionRule ) )
            // InternalOptimisationLanguage.g:6259:2: ( ruleExpressionRule )
            {
            // InternalOptimisationLanguage.g:6259:2: ( ruleExpressionRule )
            // InternalOptimisationLanguage.g:6260:3: ruleExpressionRule
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


    // $ANTLR start "rule__ConstantReferenceRule__DefinitionAssignment"
    // InternalOptimisationLanguage.g:6269:1: rule__ConstantReferenceRule__DefinitionAssignment : ( ( ruleQualifiedName ) ) ;
    public final void rule__ConstantReferenceRule__DefinitionAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6273:1: ( ( ( ruleQualifiedName ) ) )
            // InternalOptimisationLanguage.g:6274:2: ( ( ruleQualifiedName ) )
            {
            // InternalOptimisationLanguage.g:6274:2: ( ( ruleQualifiedName ) )
            // InternalOptimisationLanguage.g:6275:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstantReferenceRuleAccess().getDefinitionConstantDefinitionCrossReference_0()); 
            }
            // InternalOptimisationLanguage.g:6276:3: ( ruleQualifiedName )
            // InternalOptimisationLanguage.g:6277:4: ruleQualifiedName
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
    // InternalOptimisationLanguage.g:6288:1: rule__InstanceLiteralRule__DefinitionAssignment_0 : ( ( ruleQualifiedName ) ) ;
    public final void rule__InstanceLiteralRule__DefinitionAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6292:1: ( ( ( ruleQualifiedName ) ) )
            // InternalOptimisationLanguage.g:6293:2: ( ( ruleQualifiedName ) )
            {
            // InternalOptimisationLanguage.g:6293:2: ( ( ruleQualifiedName ) )
            // InternalOptimisationLanguage.g:6294:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceLiteralRuleAccess().getDefinitionTypeDefinitionCrossReference_0_0()); 
            }
            // InternalOptimisationLanguage.g:6295:3: ( ruleQualifiedName )
            // InternalOptimisationLanguage.g:6296:4: ruleQualifiedName
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
    // InternalOptimisationLanguage.g:6307:1: rule__InstanceLiteralRule__AttributesAssignment_2 : ( ruleAttributeRule ) ;
    public final void rule__InstanceLiteralRule__AttributesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6311:1: ( ( ruleAttributeRule ) )
            // InternalOptimisationLanguage.g:6312:2: ( ruleAttributeRule )
            {
            // InternalOptimisationLanguage.g:6312:2: ( ruleAttributeRule )
            // InternalOptimisationLanguage.g:6313:3: ruleAttributeRule
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
    // InternalOptimisationLanguage.g:6322:1: rule__AttributeRule__DefinitionAssignment_0 : ( ( ruleStringOrId ) ) ;
    public final void rule__AttributeRule__DefinitionAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6326:1: ( ( ( ruleStringOrId ) ) )
            // InternalOptimisationLanguage.g:6327:2: ( ( ruleStringOrId ) )
            {
            // InternalOptimisationLanguage.g:6327:2: ( ( ruleStringOrId ) )
            // InternalOptimisationLanguage.g:6328:3: ( ruleStringOrId )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeRuleAccess().getDefinitionAttributeDefinitionCrossReference_0_0()); 
            }
            // InternalOptimisationLanguage.g:6329:3: ( ruleStringOrId )
            // InternalOptimisationLanguage.g:6330:4: ruleStringOrId
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
    // InternalOptimisationLanguage.g:6341:1: rule__AttributeRule__ValueAssignment_2 : ( ruleExpressionRule ) ;
    public final void rule__AttributeRule__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6345:1: ( ( ruleExpressionRule ) )
            // InternalOptimisationLanguage.g:6346:2: ( ruleExpressionRule )
            {
            // InternalOptimisationLanguage.g:6346:2: ( ruleExpressionRule )
            // InternalOptimisationLanguage.g:6347:3: ruleExpressionRule
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
    // InternalOptimisationLanguage.g:6356:1: rule__RealLiteralRule__LiteralAssignment_0 : ( RULE_DOUBLE ) ;
    public final void rule__RealLiteralRule__LiteralAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6360:1: ( ( RULE_DOUBLE ) )
            // InternalOptimisationLanguage.g:6361:2: ( RULE_DOUBLE )
            {
            // InternalOptimisationLanguage.g:6361:2: ( RULE_DOUBLE )
            // InternalOptimisationLanguage.g:6362:3: RULE_DOUBLE
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
    // InternalOptimisationLanguage.g:6371:1: rule__RealLiteralRule__FactorAssignment_1 : ( ruleFactorRule ) ;
    public final void rule__RealLiteralRule__FactorAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6375:1: ( ( ruleFactorRule ) )
            // InternalOptimisationLanguage.g:6376:2: ( ruleFactorRule )
            {
            // InternalOptimisationLanguage.g:6376:2: ( ruleFactorRule )
            // InternalOptimisationLanguage.g:6377:3: ruleFactorRule
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
    // InternalOptimisationLanguage.g:6386:1: rule__IntegerLiteralRule__LiteralAssignment_0 : ( RULE_INT ) ;
    public final void rule__IntegerLiteralRule__LiteralAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6390:1: ( ( RULE_INT ) )
            // InternalOptimisationLanguage.g:6391:2: ( RULE_INT )
            {
            // InternalOptimisationLanguage.g:6391:2: ( RULE_INT )
            // InternalOptimisationLanguage.g:6392:3: RULE_INT
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
    // InternalOptimisationLanguage.g:6401:1: rule__IntegerLiteralRule__FactorAssignment_1 : ( ruleFactorRule ) ;
    public final void rule__IntegerLiteralRule__FactorAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6405:1: ( ( ruleFactorRule ) )
            // InternalOptimisationLanguage.g:6406:2: ( ruleFactorRule )
            {
            // InternalOptimisationLanguage.g:6406:2: ( ruleFactorRule )
            // InternalOptimisationLanguage.g:6407:3: ruleFactorRule
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
    // InternalOptimisationLanguage.g:6416:1: rule__StringLiteralRule__ValueAssignment : ( RULE_STRING ) ;
    public final void rule__StringLiteralRule__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6420:1: ( ( RULE_STRING ) )
            // InternalOptimisationLanguage.g:6421:2: ( RULE_STRING )
            {
            // InternalOptimisationLanguage.g:6421:2: ( RULE_STRING )
            // InternalOptimisationLanguage.g:6422:3: RULE_STRING
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
    // InternalOptimisationLanguage.g:6431:1: rule__BooleanLiteralRule__ValueAssignment_1_0 : ( ( 'true' ) ) ;
    public final void rule__BooleanLiteralRule__ValueAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6435:1: ( ( ( 'true' ) ) )
            // InternalOptimisationLanguage.g:6436:2: ( ( 'true' ) )
            {
            // InternalOptimisationLanguage.g:6436:2: ( ( 'true' ) )
            // InternalOptimisationLanguage.g:6437:3: ( 'true' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralRuleAccess().getValueTrueKeyword_1_0_0()); 
            }
            // InternalOptimisationLanguage.g:6438:3: ( 'true' )
            // InternalOptimisationLanguage.g:6439:4: 'true'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralRuleAccess().getValueTrueKeyword_1_0_0()); 
            }
            match(input,83,FOLLOW_2); if (state.failed) return ;
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


    // $ANTLR start "rule__AttributeDefinitionRule__NameAssignment_0"
    // InternalOptimisationLanguage.g:6450:1: rule__AttributeDefinitionRule__NameAssignment_0 : ( ruleStringOrId ) ;
    public final void rule__AttributeDefinitionRule__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6454:1: ( ( ruleStringOrId ) )
            // InternalOptimisationLanguage.g:6455:2: ( ruleStringOrId )
            {
            // InternalOptimisationLanguage.g:6455:2: ( ruleStringOrId )
            // InternalOptimisationLanguage.g:6456:3: ruleStringOrId
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getNameStringOrIdParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleStringOrId();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeDefinitionRuleAccess().getNameStringOrIdParserRuleCall_0_0()); 
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
    // $ANTLR end "rule__AttributeDefinitionRule__NameAssignment_0"


    // $ANTLR start "rule__AttributeDefinitionRule__TypeAssignment_2"
    // InternalOptimisationLanguage.g:6465:1: rule__AttributeDefinitionRule__TypeAssignment_2 : ( ruleTypeRule ) ;
    public final void rule__AttributeDefinitionRule__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6469:1: ( ( ruleTypeRule ) )
            // InternalOptimisationLanguage.g:6470:2: ( ruleTypeRule )
            {
            // InternalOptimisationLanguage.g:6470:2: ( ruleTypeRule )
            // InternalOptimisationLanguage.g:6471:3: ruleTypeRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getTypeTypeRuleParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleTypeRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeDefinitionRuleAccess().getTypeTypeRuleParserRuleCall_2_0()); 
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
    // $ANTLR end "rule__AttributeDefinitionRule__TypeAssignment_2"


    // $ANTLR start "rule__AttributeDefinitionRule__InitialisationAssignment_3_1"
    // InternalOptimisationLanguage.g:6480:1: rule__AttributeDefinitionRule__InitialisationAssignment_3_1 : ( ruleExpressionRule ) ;
    public final void rule__AttributeDefinitionRule__InitialisationAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6484:1: ( ( ruleExpressionRule ) )
            // InternalOptimisationLanguage.g:6485:2: ( ruleExpressionRule )
            {
            // InternalOptimisationLanguage.g:6485:2: ( ruleExpressionRule )
            // InternalOptimisationLanguage.g:6486:3: ruleExpressionRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getInitialisationExpressionRuleParserRuleCall_3_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleExpressionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeDefinitionRuleAccess().getInitialisationExpressionRuleParserRuleCall_3_1_0()); 
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
    // $ANTLR end "rule__AttributeDefinitionRule__InitialisationAssignment_3_1"


    // $ANTLR start "rule__InstanceTypeRule__DefinitionAssignment_2"
    // InternalOptimisationLanguage.g:6495:1: rule__InstanceTypeRule__DefinitionAssignment_2 : ( ( ruleQualifiedName ) ) ;
    public final void rule__InstanceTypeRule__DefinitionAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6499:1: ( ( ( ruleQualifiedName ) ) )
            // InternalOptimisationLanguage.g:6500:2: ( ( ruleQualifiedName ) )
            {
            // InternalOptimisationLanguage.g:6500:2: ( ( ruleQualifiedName ) )
            // InternalOptimisationLanguage.g:6501:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceTypeRuleAccess().getDefinitionTypeDefinitionCrossReference_2_0()); 
            }
            // InternalOptimisationLanguage.g:6502:3: ( ruleQualifiedName )
            // InternalOptimisationLanguage.g:6503:4: ruleQualifiedName
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


    // $ANTLR start "rule__DataOrInstanceTypeRule__InstanceAssignment_4_1"
    // InternalOptimisationLanguage.g:6514:1: rule__DataOrInstanceTypeRule__InstanceAssignment_4_1 : ( ruleInstanceTypeRule ) ;
    public final void rule__DataOrInstanceTypeRule__InstanceAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6518:1: ( ( ruleInstanceTypeRule ) )
            // InternalOptimisationLanguage.g:6519:2: ( ruleInstanceTypeRule )
            {
            // InternalOptimisationLanguage.g:6519:2: ( ruleInstanceTypeRule )
            // InternalOptimisationLanguage.g:6520:3: ruleInstanceTypeRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataOrInstanceTypeRuleAccess().getInstanceInstanceTypeRuleParserRuleCall_4_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleInstanceTypeRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataOrInstanceTypeRuleAccess().getInstanceInstanceTypeRuleParserRuleCall_4_1_0()); 
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
    // $ANTLR end "rule__DataOrInstanceTypeRule__InstanceAssignment_4_1"


    // $ANTLR start "rule__ArrayTypeRule__ElementsAssignment_1"
    // InternalOptimisationLanguage.g:6529:1: rule__ArrayTypeRule__ElementsAssignment_1 : ( ruleTypeRule ) ;
    public final void rule__ArrayTypeRule__ElementsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6533:1: ( ( ruleTypeRule ) )
            // InternalOptimisationLanguage.g:6534:2: ( ruleTypeRule )
            {
            // InternalOptimisationLanguage.g:6534:2: ( ruleTypeRule )
            // InternalOptimisationLanguage.g:6535:3: ruleTypeRule
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
    // InternalOptimisationLanguage.g:6544:1: rule__ParameterRule__TypeAssignment_0 : ( ruleTypeRule ) ;
    public final void rule__ParameterRule__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6548:1: ( ( ruleTypeRule ) )
            // InternalOptimisationLanguage.g:6549:2: ( ruleTypeRule )
            {
            // InternalOptimisationLanguage.g:6549:2: ( ruleTypeRule )
            // InternalOptimisationLanguage.g:6550:3: ruleTypeRule
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
    // InternalOptimisationLanguage.g:6559:1: rule__ParameterRule__NameAssignment_1 : ( ruleStringOrId ) ;
    public final void rule__ParameterRule__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6563:1: ( ( ruleStringOrId ) )
            // InternalOptimisationLanguage.g:6564:2: ( ruleStringOrId )
            {
            // InternalOptimisationLanguage.g:6564:2: ( ruleStringOrId )
            // InternalOptimisationLanguage.g:6565:3: ruleStringOrId
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
    // InternalOptimisationLanguage.g:6574:1: rule__ImportRule__LanguageAssignment_1 : ( RULE_STRING ) ;
    public final void rule__ImportRule__LanguageAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6578:1: ( ( RULE_STRING ) )
            // InternalOptimisationLanguage.g:6579:2: ( RULE_STRING )
            {
            // InternalOptimisationLanguage.g:6579:2: ( RULE_STRING )
            // InternalOptimisationLanguage.g:6580:3: RULE_STRING
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
    // InternalOptimisationLanguage.g:6589:1: rule__ImportRule__ImportedNamespaceAssignment_3 : ( ruleQualifiedName ) ;
    public final void rule__ImportRule__ImportedNamespaceAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6593:1: ( ( ruleQualifiedName ) )
            // InternalOptimisationLanguage.g:6594:2: ( ruleQualifiedName )
            {
            // InternalOptimisationLanguage.g:6594:2: ( ruleQualifiedName )
            // InternalOptimisationLanguage.g:6595:3: ruleQualifiedName
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


    // $ANTLR start "rule__FunctionNameRule__DefinitionAssignment"
    // InternalOptimisationLanguage.g:6604:1: rule__FunctionNameRule__DefinitionAssignment : ( ( ruleQualifiedName ) ) ;
    public final void rule__FunctionNameRule__DefinitionAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6608:1: ( ( ( ruleQualifiedName ) ) )
            // InternalOptimisationLanguage.g:6609:2: ( ( ruleQualifiedName ) )
            {
            // InternalOptimisationLanguage.g:6609:2: ( ( ruleQualifiedName ) )
            // InternalOptimisationLanguage.g:6610:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionNameRuleAccess().getDefinitionFunctionDefinitionCrossReference_0()); 
            }
            // InternalOptimisationLanguage.g:6611:3: ( ruleQualifiedName )
            // InternalOptimisationLanguage.g:6612:4: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionNameRuleAccess().getDefinitionFunctionDefinitionQualifiedNameParserRuleCall_0_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunctionNameRuleAccess().getDefinitionFunctionDefinitionQualifiedNameParserRuleCall_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunctionNameRuleAccess().getDefinitionFunctionDefinitionCrossReference_0()); 
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
    // $ANTLR end "rule__FunctionNameRule__DefinitionAssignment"

    // Delegated rules


    protected DFA2 dfa2 = new DFA2(this);
    protected DFA6 dfa6 = new DFA6(this);
    static final String dfa_1s = "\13\uffff";
    static final String dfa_2s = "\2\uffff\2\6\5\uffff\2\6";
    static final String dfa_3s = "\1\4\1\uffff\2\20\3\uffff\1\4\1\uffff\2\20";
    static final String dfa_4s = "\1\123\1\uffff\2\121\3\uffff\1\5\1\uffff\2\121";
    static final String dfa_5s = "\1\uffff\1\1\2\uffff\1\3\1\4\1\5\1\uffff\1\2\2\uffff";
    static final String dfa_6s = "\13\uffff}>";
    static final String[] dfa_7s = {
            "\1\2\1\3\3\4\6\uffff\1\4\50\uffff\1\6\4\uffff\1\1\2\uffff\1\5\22\uffff\1\4",
            "",
            "\13\6\25\uffff\1\4\4\uffff\1\6\3\uffff\4\6\1\uffff\2\6\1\10\1\6\17\uffff\1\7",
            "\13\6\25\uffff\1\4\4\uffff\1\6\3\uffff\4\6\1\uffff\2\6\1\10\1\6\17\uffff\1\7",
            "",
            "",
            "",
            "\1\11\1\12",
            "",
            "\13\6\25\uffff\1\4\4\uffff\1\6\3\uffff\4\6\1\uffff\2\6\1\10\1\6\17\uffff\1\7",
            "\13\6\25\uffff\1\4\4\uffff\1\6\3\uffff\4\6\1\uffff\2\6\1\10\1\6\17\uffff\1\7"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "1314:1: rule__ValueRule__Alternatives : ( ( ruleArrayRule ) | ( ruleCallRule ) | ( ruleLiteralRule ) | ( ruleParanthesesRule ) | ( ruleReferenceRule ) );";
        }
    }
    static final String dfa_8s = "\15\uffff";
    static final String dfa_9s = "\12\uffff\1\14\2\uffff";
    static final String dfa_10s = "\1\70\11\uffff\1\4\2\uffff";
    static final String dfa_11s = "\1\116\11\uffff\1\113\2\uffff";
    static final String dfa_12s = "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\uffff\1\13\1\12";
    static final String dfa_13s = "\15\uffff}>";
    static final String[] dfa_14s = {
            "\1\12\12\uffff\1\5\1\7\1\1\1\11\1\2\1\3\1\4\1\10\3\uffff\1\6",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\2\14\56\uffff\2\14\25\uffff\1\13",
            "",
            ""
    };

    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final short[] dfa_9 = DFA.unpackEncodedString(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final char[] dfa_11 = DFA.unpackEncodedStringToUnsignedChars(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[] dfa_13 = DFA.unpackEncodedString(dfa_13s);
    static final short[][] dfa_14 = unpackEncodedStringArray(dfa_14s);

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = dfa_8;
            this.eof = dfa_9;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "1428:1: rule__TypeRule__Alternatives : ( ( ruleStringTypeRule ) | ( ruleIntTypeRule ) | ( ruleRealTypeRule ) | ( ruleBooleanTypeRule ) | ( ruleLiteralTypeRule ) | ( ruleArrayTypeRule ) | ( ruleInstanceTypeRule ) | ( ruleVoidTypeRule ) | ( ruleExpressionTypeRule ) | ( ruleDataTypeRule ) | ( ruleDataOrInstanceTypeRule ) );";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0046000000000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x000A000000000030L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x2100000000C081F0L,0x00000000000C0001L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x00000000003F0000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x00000000003F0002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000007000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000007000002L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x6100000000C081F0L,0x00000000000C0001L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x2100000000C081F0L,0x00000000000C0003L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0002000000000030L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x00007FFFF8000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000008000L,0x0000000000080000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0100000000000000L,0x00000000000047F8L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0030000000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000000002L,0x0000000000020000L});

}
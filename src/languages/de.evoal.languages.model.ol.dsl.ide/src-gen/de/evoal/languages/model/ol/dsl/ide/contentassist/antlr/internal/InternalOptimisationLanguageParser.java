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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_QUOTED_ID", "RULE_ID", "RULE_DOUBLE", "RULE_INT", "RULE_STRING", "RULE_DIGIT", "RULE_EXPONENT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'false'", "'>'", "'>='", "'='", "'!='", "'<='", "'<'", "'+'", "'-'", "'*'", "'/'", "'%'", "'Y'", "'Z'", "'E'", "'P'", "'T'", "'G'", "'M'", "'k'", "'h'", "'da'", "'d'", "'c'", "'m'", "'\\u00B5'", "'n'", "'p'", "'f'", "'a'", "'z'", "'y'", "'module'", "'{'", "'}'", "'specify'", "'search'", "'for'", "'map'", "'with'", "'and'", "','", "'document'", "'.'", "'maximise'", "'minimise'", "'optimise'", "'towards'", "'configure'", "':='", "';'", "'OR'", "'XOR'", "'AND'", "'^'", "'['", "']'", "'('", "')'", "'self'", "'value'", "'tree'", "'data'", "'instance'", "'@'", "':'", "'enum'", "'literal'", "'string'", "'expression'", "'int'", "'real'", "'boolean'", "'void'", "'array'", "'import'", "'from'", "'target'", "'!'", "'true'", "'optional'"
    };
    public static final int T__50=50;
    public static final int T__59=59;
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
    public static final int RULE_INT=7;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=11;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
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
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int T__90=90;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__95=95;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=8;
    public static final int RULE_SL_COMMENT=12;
    public static final int RULE_DOUBLE=6;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_WS=13;
    public static final int RULE_ANY_OTHER=14;
    public static final int T__88=88;
    public static final int T__89=89;
    public static final int T__84=84;
    public static final int T__85=85;
    public static final int T__86=86;
    public static final int T__87=87;

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


    // $ANTLR start "entryRuleOptimisationGoalRule"
    // InternalOptimisationLanguage.g:105:1: entryRuleOptimisationGoalRule : ruleOptimisationGoalRule EOF ;
    public final void entryRuleOptimisationGoalRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:106:1: ( ruleOptimisationGoalRule EOF )
            // InternalOptimisationLanguage.g:107:1: ruleOptimisationGoalRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOptimisationGoalRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleOptimisationGoalRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOptimisationGoalRuleRule()); 
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
    // $ANTLR end "entryRuleOptimisationGoalRule"


    // $ANTLR start "ruleOptimisationGoalRule"
    // InternalOptimisationLanguage.g:114:1: ruleOptimisationGoalRule : ( ( rule__OptimisationGoalRule__Alternatives ) ) ;
    public final void ruleOptimisationGoalRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:118:2: ( ( ( rule__OptimisationGoalRule__Alternatives ) ) )
            // InternalOptimisationLanguage.g:119:2: ( ( rule__OptimisationGoalRule__Alternatives ) )
            {
            // InternalOptimisationLanguage.g:119:2: ( ( rule__OptimisationGoalRule__Alternatives ) )
            // InternalOptimisationLanguage.g:120:3: ( rule__OptimisationGoalRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOptimisationGoalRuleAccess().getAlternatives()); 
            }
            // InternalOptimisationLanguage.g:121:3: ( rule__OptimisationGoalRule__Alternatives )
            // InternalOptimisationLanguage.g:121:4: rule__OptimisationGoalRule__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__OptimisationGoalRule__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOptimisationGoalRuleAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOptimisationGoalRule"


    // $ANTLR start "entryRuleMaximiseGoalRule"
    // InternalOptimisationLanguage.g:130:1: entryRuleMaximiseGoalRule : ruleMaximiseGoalRule EOF ;
    public final void entryRuleMaximiseGoalRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:131:1: ( ruleMaximiseGoalRule EOF )
            // InternalOptimisationLanguage.g:132:1: ruleMaximiseGoalRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMaximiseGoalRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleMaximiseGoalRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMaximiseGoalRuleRule()); 
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
    // $ANTLR end "entryRuleMaximiseGoalRule"


    // $ANTLR start "ruleMaximiseGoalRule"
    // InternalOptimisationLanguage.g:139:1: ruleMaximiseGoalRule : ( ( rule__MaximiseGoalRule__Group__0 ) ) ;
    public final void ruleMaximiseGoalRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:143:2: ( ( ( rule__MaximiseGoalRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:144:2: ( ( rule__MaximiseGoalRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:144:2: ( ( rule__MaximiseGoalRule__Group__0 ) )
            // InternalOptimisationLanguage.g:145:3: ( rule__MaximiseGoalRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMaximiseGoalRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:146:3: ( rule__MaximiseGoalRule__Group__0 )
            // InternalOptimisationLanguage.g:146:4: rule__MaximiseGoalRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__MaximiseGoalRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMaximiseGoalRuleAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMaximiseGoalRule"


    // $ANTLR start "entryRuleMinimiseGoalRule"
    // InternalOptimisationLanguage.g:155:1: entryRuleMinimiseGoalRule : ruleMinimiseGoalRule EOF ;
    public final void entryRuleMinimiseGoalRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:156:1: ( ruleMinimiseGoalRule EOF )
            // InternalOptimisationLanguage.g:157:1: ruleMinimiseGoalRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMinimiseGoalRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleMinimiseGoalRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMinimiseGoalRuleRule()); 
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
    // $ANTLR end "entryRuleMinimiseGoalRule"


    // $ANTLR start "ruleMinimiseGoalRule"
    // InternalOptimisationLanguage.g:164:1: ruleMinimiseGoalRule : ( ( rule__MinimiseGoalRule__Group__0 ) ) ;
    public final void ruleMinimiseGoalRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:168:2: ( ( ( rule__MinimiseGoalRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:169:2: ( ( rule__MinimiseGoalRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:169:2: ( ( rule__MinimiseGoalRule__Group__0 ) )
            // InternalOptimisationLanguage.g:170:3: ( rule__MinimiseGoalRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMinimiseGoalRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:171:3: ( rule__MinimiseGoalRule__Group__0 )
            // InternalOptimisationLanguage.g:171:4: rule__MinimiseGoalRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__MinimiseGoalRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMinimiseGoalRuleAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMinimiseGoalRule"


    // $ANTLR start "entryRuleTargetGoalRule"
    // InternalOptimisationLanguage.g:180:1: entryRuleTargetGoalRule : ruleTargetGoalRule EOF ;
    public final void entryRuleTargetGoalRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:181:1: ( ruleTargetGoalRule EOF )
            // InternalOptimisationLanguage.g:182:1: ruleTargetGoalRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTargetGoalRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleTargetGoalRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTargetGoalRuleRule()); 
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
    // $ANTLR end "entryRuleTargetGoalRule"


    // $ANTLR start "ruleTargetGoalRule"
    // InternalOptimisationLanguage.g:189:1: ruleTargetGoalRule : ( ( rule__TargetGoalRule__Group__0 ) ) ;
    public final void ruleTargetGoalRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:193:2: ( ( ( rule__TargetGoalRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:194:2: ( ( rule__TargetGoalRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:194:2: ( ( rule__TargetGoalRule__Group__0 ) )
            // InternalOptimisationLanguage.g:195:3: ( rule__TargetGoalRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTargetGoalRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:196:3: ( rule__TargetGoalRule__Group__0 )
            // InternalOptimisationLanguage.g:196:4: rule__TargetGoalRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TargetGoalRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTargetGoalRuleAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTargetGoalRule"


    // $ANTLR start "entryRuleAlgorithmInstanceRule"
    // InternalOptimisationLanguage.g:205:1: entryRuleAlgorithmInstanceRule : ruleAlgorithmInstanceRule EOF ;
    public final void entryRuleAlgorithmInstanceRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:206:1: ( ruleAlgorithmInstanceRule EOF )
            // InternalOptimisationLanguage.g:207:1: ruleAlgorithmInstanceRule EOF
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
    // InternalOptimisationLanguage.g:214:1: ruleAlgorithmInstanceRule : ( ( rule__AlgorithmInstanceRule__Group__0 ) ) ;
    public final void ruleAlgorithmInstanceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:218:2: ( ( ( rule__AlgorithmInstanceRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:219:2: ( ( rule__AlgorithmInstanceRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:219:2: ( ( rule__AlgorithmInstanceRule__Group__0 ) )
            // InternalOptimisationLanguage.g:220:3: ( rule__AlgorithmInstanceRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAlgorithmInstanceRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:221:3: ( rule__AlgorithmInstanceRule__Group__0 )
            // InternalOptimisationLanguage.g:221:4: rule__AlgorithmInstanceRule__Group__0
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


    // $ANTLR start "entryRuleExpressionRule"
    // InternalOptimisationLanguage.g:230:1: entryRuleExpressionRule : ruleExpressionRule EOF ;
    public final void entryRuleExpressionRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:231:1: ( ruleExpressionRule EOF )
            // InternalOptimisationLanguage.g:232:1: ruleExpressionRule EOF
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
    // InternalOptimisationLanguage.g:239:1: ruleExpressionRule : ( ruleOrExpressionRule ) ;
    public final void ruleExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:243:2: ( ( ruleOrExpressionRule ) )
            // InternalOptimisationLanguage.g:244:2: ( ruleOrExpressionRule )
            {
            // InternalOptimisationLanguage.g:244:2: ( ruleOrExpressionRule )
            // InternalOptimisationLanguage.g:245:3: ruleOrExpressionRule
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
    // InternalOptimisationLanguage.g:255:1: entryRuleOrExpressionRule : ruleOrExpressionRule EOF ;
    public final void entryRuleOrExpressionRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:256:1: ( ruleOrExpressionRule EOF )
            // InternalOptimisationLanguage.g:257:1: ruleOrExpressionRule EOF
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
    // InternalOptimisationLanguage.g:264:1: ruleOrExpressionRule : ( ( rule__OrExpressionRule__Group__0 ) ) ;
    public final void ruleOrExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:268:2: ( ( ( rule__OrExpressionRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:269:2: ( ( rule__OrExpressionRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:269:2: ( ( rule__OrExpressionRule__Group__0 ) )
            // InternalOptimisationLanguage.g:270:3: ( rule__OrExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:271:3: ( rule__OrExpressionRule__Group__0 )
            // InternalOptimisationLanguage.g:271:4: rule__OrExpressionRule__Group__0
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
    // InternalOptimisationLanguage.g:280:1: entryRuleXorExpressionRule : ruleXorExpressionRule EOF ;
    public final void entryRuleXorExpressionRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:281:1: ( ruleXorExpressionRule EOF )
            // InternalOptimisationLanguage.g:282:1: ruleXorExpressionRule EOF
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
    // InternalOptimisationLanguage.g:289:1: ruleXorExpressionRule : ( ( rule__XorExpressionRule__Group__0 ) ) ;
    public final void ruleXorExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:293:2: ( ( ( rule__XorExpressionRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:294:2: ( ( rule__XorExpressionRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:294:2: ( ( rule__XorExpressionRule__Group__0 ) )
            // InternalOptimisationLanguage.g:295:3: ( rule__XorExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXorExpressionRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:296:3: ( rule__XorExpressionRule__Group__0 )
            // InternalOptimisationLanguage.g:296:4: rule__XorExpressionRule__Group__0
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
    // InternalOptimisationLanguage.g:305:1: entryRuleAndExpressionRule : ruleAndExpressionRule EOF ;
    public final void entryRuleAndExpressionRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:306:1: ( ruleAndExpressionRule EOF )
            // InternalOptimisationLanguage.g:307:1: ruleAndExpressionRule EOF
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
    // InternalOptimisationLanguage.g:314:1: ruleAndExpressionRule : ( ( rule__AndExpressionRule__Group__0 ) ) ;
    public final void ruleAndExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:318:2: ( ( ( rule__AndExpressionRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:319:2: ( ( rule__AndExpressionRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:319:2: ( ( rule__AndExpressionRule__Group__0 ) )
            // InternalOptimisationLanguage.g:320:3: ( rule__AndExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:321:3: ( rule__AndExpressionRule__Group__0 )
            // InternalOptimisationLanguage.g:321:4: rule__AndExpressionRule__Group__0
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
    // InternalOptimisationLanguage.g:330:1: entryRuleNotExpressionRule : ruleNotExpressionRule EOF ;
    public final void entryRuleNotExpressionRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:331:1: ( ruleNotExpressionRule EOF )
            // InternalOptimisationLanguage.g:332:1: ruleNotExpressionRule EOF
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
    // InternalOptimisationLanguage.g:339:1: ruleNotExpressionRule : ( ( rule__NotExpressionRule__Group__0 ) ) ;
    public final void ruleNotExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:343:2: ( ( ( rule__NotExpressionRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:344:2: ( ( rule__NotExpressionRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:344:2: ( ( rule__NotExpressionRule__Group__0 ) )
            // InternalOptimisationLanguage.g:345:3: ( rule__NotExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNotExpressionRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:346:3: ( rule__NotExpressionRule__Group__0 )
            // InternalOptimisationLanguage.g:346:4: rule__NotExpressionRule__Group__0
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
    // InternalOptimisationLanguage.g:355:1: entryRuleComparisonExpressionRule : ruleComparisonExpressionRule EOF ;
    public final void entryRuleComparisonExpressionRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:356:1: ( ruleComparisonExpressionRule EOF )
            // InternalOptimisationLanguage.g:357:1: ruleComparisonExpressionRule EOF
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
    // InternalOptimisationLanguage.g:364:1: ruleComparisonExpressionRule : ( ( rule__ComparisonExpressionRule__Group__0 ) ) ;
    public final void ruleComparisonExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:368:2: ( ( ( rule__ComparisonExpressionRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:369:2: ( ( rule__ComparisonExpressionRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:369:2: ( ( rule__ComparisonExpressionRule__Group__0 ) )
            // InternalOptimisationLanguage.g:370:3: ( rule__ComparisonExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonExpressionRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:371:3: ( rule__ComparisonExpressionRule__Group__0 )
            // InternalOptimisationLanguage.g:371:4: rule__ComparisonExpressionRule__Group__0
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
    // InternalOptimisationLanguage.g:380:1: entryRulePartialComparisonExpressionRule : rulePartialComparisonExpressionRule EOF ;
    public final void entryRulePartialComparisonExpressionRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:381:1: ( rulePartialComparisonExpressionRule EOF )
            // InternalOptimisationLanguage.g:382:1: rulePartialComparisonExpressionRule EOF
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
    // InternalOptimisationLanguage.g:389:1: rulePartialComparisonExpressionRule : ( ( rule__PartialComparisonExpressionRule__Group__0 ) ) ;
    public final void rulePartialComparisonExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:393:2: ( ( ( rule__PartialComparisonExpressionRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:394:2: ( ( rule__PartialComparisonExpressionRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:394:2: ( ( rule__PartialComparisonExpressionRule__Group__0 ) )
            // InternalOptimisationLanguage.g:395:3: ( rule__PartialComparisonExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartialComparisonExpressionRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:396:3: ( rule__PartialComparisonExpressionRule__Group__0 )
            // InternalOptimisationLanguage.g:396:4: rule__PartialComparisonExpressionRule__Group__0
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
    // InternalOptimisationLanguage.g:405:1: entryRuleAddOrSubtractExpressionRule : ruleAddOrSubtractExpressionRule EOF ;
    public final void entryRuleAddOrSubtractExpressionRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:406:1: ( ruleAddOrSubtractExpressionRule EOF )
            // InternalOptimisationLanguage.g:407:1: ruleAddOrSubtractExpressionRule EOF
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
    // InternalOptimisationLanguage.g:414:1: ruleAddOrSubtractExpressionRule : ( ( rule__AddOrSubtractExpressionRule__Group__0 ) ) ;
    public final void ruleAddOrSubtractExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:418:2: ( ( ( rule__AddOrSubtractExpressionRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:419:2: ( ( rule__AddOrSubtractExpressionRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:419:2: ( ( rule__AddOrSubtractExpressionRule__Group__0 ) )
            // InternalOptimisationLanguage.g:420:3: ( rule__AddOrSubtractExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:421:3: ( rule__AddOrSubtractExpressionRule__Group__0 )
            // InternalOptimisationLanguage.g:421:4: rule__AddOrSubtractExpressionRule__Group__0
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
    // InternalOptimisationLanguage.g:430:1: entryRuleMultiplyDivideModuloExpressionRule : ruleMultiplyDivideModuloExpressionRule EOF ;
    public final void entryRuleMultiplyDivideModuloExpressionRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:431:1: ( ruleMultiplyDivideModuloExpressionRule EOF )
            // InternalOptimisationLanguage.g:432:1: ruleMultiplyDivideModuloExpressionRule EOF
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
    // InternalOptimisationLanguage.g:439:1: ruleMultiplyDivideModuloExpressionRule : ( ( rule__MultiplyDivideModuloExpressionRule__Group__0 ) ) ;
    public final void ruleMultiplyDivideModuloExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:443:2: ( ( ( rule__MultiplyDivideModuloExpressionRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:444:2: ( ( rule__MultiplyDivideModuloExpressionRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:444:2: ( ( rule__MultiplyDivideModuloExpressionRule__Group__0 ) )
            // InternalOptimisationLanguage.g:445:3: ( rule__MultiplyDivideModuloExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:446:3: ( rule__MultiplyDivideModuloExpressionRule__Group__0 )
            // InternalOptimisationLanguage.g:446:4: rule__MultiplyDivideModuloExpressionRule__Group__0
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
    // InternalOptimisationLanguage.g:455:1: entryRulePowerOfExpressionRule : rulePowerOfExpressionRule EOF ;
    public final void entryRulePowerOfExpressionRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:456:1: ( rulePowerOfExpressionRule EOF )
            // InternalOptimisationLanguage.g:457:1: rulePowerOfExpressionRule EOF
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
    // InternalOptimisationLanguage.g:464:1: rulePowerOfExpressionRule : ( ( rule__PowerOfExpressionRule__Group__0 ) ) ;
    public final void rulePowerOfExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:468:2: ( ( ( rule__PowerOfExpressionRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:469:2: ( ( rule__PowerOfExpressionRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:469:2: ( ( rule__PowerOfExpressionRule__Group__0 ) )
            // InternalOptimisationLanguage.g:470:3: ( rule__PowerOfExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPowerOfExpressionRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:471:3: ( rule__PowerOfExpressionRule__Group__0 )
            // InternalOptimisationLanguage.g:471:4: rule__PowerOfExpressionRule__Group__0
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
    // InternalOptimisationLanguage.g:480:1: entryRuleUnaryAddOrSubtractExpressionRule : ruleUnaryAddOrSubtractExpressionRule EOF ;
    public final void entryRuleUnaryAddOrSubtractExpressionRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:481:1: ( ruleUnaryAddOrSubtractExpressionRule EOF )
            // InternalOptimisationLanguage.g:482:1: ruleUnaryAddOrSubtractExpressionRule EOF
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
    // InternalOptimisationLanguage.g:489:1: ruleUnaryAddOrSubtractExpressionRule : ( ( rule__UnaryAddOrSubtractExpressionRule__Group__0 ) ) ;
    public final void ruleUnaryAddOrSubtractExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:493:2: ( ( ( rule__UnaryAddOrSubtractExpressionRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:494:2: ( ( rule__UnaryAddOrSubtractExpressionRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:494:2: ( ( rule__UnaryAddOrSubtractExpressionRule__Group__0 ) )
            // InternalOptimisationLanguage.g:495:3: ( rule__UnaryAddOrSubtractExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:496:3: ( rule__UnaryAddOrSubtractExpressionRule__Group__0 )
            // InternalOptimisationLanguage.g:496:4: rule__UnaryAddOrSubtractExpressionRule__Group__0
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


    // $ANTLR start "entryRuleReadExpressionRule"
    // InternalOptimisationLanguage.g:505:1: entryRuleReadExpressionRule : ruleReadExpressionRule EOF ;
    public final void entryRuleReadExpressionRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:506:1: ( ruleReadExpressionRule EOF )
            // InternalOptimisationLanguage.g:507:1: ruleReadExpressionRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReadExpressionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleReadExpressionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReadExpressionRuleRule()); 
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
    // $ANTLR end "entryRuleReadExpressionRule"


    // $ANTLR start "ruleReadExpressionRule"
    // InternalOptimisationLanguage.g:514:1: ruleReadExpressionRule : ( ( rule__ReadExpressionRule__Alternatives ) ) ;
    public final void ruleReadExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:518:2: ( ( ( rule__ReadExpressionRule__Alternatives ) ) )
            // InternalOptimisationLanguage.g:519:2: ( ( rule__ReadExpressionRule__Alternatives ) )
            {
            // InternalOptimisationLanguage.g:519:2: ( ( rule__ReadExpressionRule__Alternatives ) )
            // InternalOptimisationLanguage.g:520:3: ( rule__ReadExpressionRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReadExpressionRuleAccess().getAlternatives()); 
            }
            // InternalOptimisationLanguage.g:521:3: ( rule__ReadExpressionRule__Alternatives )
            // InternalOptimisationLanguage.g:521:4: rule__ReadExpressionRule__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__ReadExpressionRule__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getReadExpressionRuleAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleReadExpressionRule"


    // $ANTLR start "entryRuleArrayRule"
    // InternalOptimisationLanguage.g:530:1: entryRuleArrayRule : ruleArrayRule EOF ;
    public final void entryRuleArrayRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:531:1: ( ruleArrayRule EOF )
            // InternalOptimisationLanguage.g:532:1: ruleArrayRule EOF
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
    // InternalOptimisationLanguage.g:539:1: ruleArrayRule : ( ( rule__ArrayRule__Group__0 ) ) ;
    public final void ruleArrayRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:543:2: ( ( ( rule__ArrayRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:544:2: ( ( rule__ArrayRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:544:2: ( ( rule__ArrayRule__Group__0 ) )
            // InternalOptimisationLanguage.g:545:3: ( rule__ArrayRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:546:3: ( rule__ArrayRule__Group__0 )
            // InternalOptimisationLanguage.g:546:4: rule__ArrayRule__Group__0
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
    // InternalOptimisationLanguage.g:555:1: entryRuleParanthesesRule : ruleParanthesesRule EOF ;
    public final void entryRuleParanthesesRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:556:1: ( ruleParanthesesRule EOF )
            // InternalOptimisationLanguage.g:557:1: ruleParanthesesRule EOF
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
    // InternalOptimisationLanguage.g:564:1: ruleParanthesesRule : ( ( rule__ParanthesesRule__Group__0 ) ) ;
    public final void ruleParanthesesRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:568:2: ( ( ( rule__ParanthesesRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:569:2: ( ( rule__ParanthesesRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:569:2: ( ( rule__ParanthesesRule__Group__0 ) )
            // InternalOptimisationLanguage.g:570:3: ( rule__ParanthesesRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParanthesesRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:571:3: ( rule__ParanthesesRule__Group__0 )
            // InternalOptimisationLanguage.g:571:4: rule__ParanthesesRule__Group__0
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
    // InternalOptimisationLanguage.g:580:1: entryRuleCallRule : ruleCallRule EOF ;
    public final void entryRuleCallRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:581:1: ( ruleCallRule EOF )
            // InternalOptimisationLanguage.g:582:1: ruleCallRule EOF
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
    // InternalOptimisationLanguage.g:589:1: ruleCallRule : ( ( rule__CallRule__Group__0 ) ) ;
    public final void ruleCallRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:593:2: ( ( ( rule__CallRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:594:2: ( ( rule__CallRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:594:2: ( ( rule__CallRule__Group__0 ) )
            // InternalOptimisationLanguage.g:595:3: ( rule__CallRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:596:3: ( rule__CallRule__Group__0 )
            // InternalOptimisationLanguage.g:596:4: rule__CallRule__Group__0
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
    // InternalOptimisationLanguage.g:605:1: entryRuleReferenceRule : ruleReferenceRule EOF ;
    public final void entryRuleReferenceRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:606:1: ( ruleReferenceRule EOF )
            // InternalOptimisationLanguage.g:607:1: ruleReferenceRule EOF
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
    // InternalOptimisationLanguage.g:614:1: ruleReferenceRule : ( ( rule__ReferenceRule__Alternatives ) ) ;
    public final void ruleReferenceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:618:2: ( ( ( rule__ReferenceRule__Alternatives ) ) )
            // InternalOptimisationLanguage.g:619:2: ( ( rule__ReferenceRule__Alternatives ) )
            {
            // InternalOptimisationLanguage.g:619:2: ( ( rule__ReferenceRule__Alternatives ) )
            // InternalOptimisationLanguage.g:620:3: ( rule__ReferenceRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceRuleAccess().getAlternatives()); 
            }
            // InternalOptimisationLanguage.g:621:3: ( rule__ReferenceRule__Alternatives )
            // InternalOptimisationLanguage.g:621:4: rule__ReferenceRule__Alternatives
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


    // $ANTLR start "entryRuleSelfReferenceRule"
    // InternalOptimisationLanguage.g:630:1: entryRuleSelfReferenceRule : ruleSelfReferenceRule EOF ;
    public final void entryRuleSelfReferenceRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:631:1: ( ruleSelfReferenceRule EOF )
            // InternalOptimisationLanguage.g:632:1: ruleSelfReferenceRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSelfReferenceRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleSelfReferenceRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSelfReferenceRuleRule()); 
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
    // $ANTLR end "entryRuleSelfReferenceRule"


    // $ANTLR start "ruleSelfReferenceRule"
    // InternalOptimisationLanguage.g:639:1: ruleSelfReferenceRule : ( ( rule__SelfReferenceRule__Alternatives ) ) ;
    public final void ruleSelfReferenceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:643:2: ( ( ( rule__SelfReferenceRule__Alternatives ) ) )
            // InternalOptimisationLanguage.g:644:2: ( ( rule__SelfReferenceRule__Alternatives ) )
            {
            // InternalOptimisationLanguage.g:644:2: ( ( rule__SelfReferenceRule__Alternatives ) )
            // InternalOptimisationLanguage.g:645:3: ( rule__SelfReferenceRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSelfReferenceRuleAccess().getAlternatives()); 
            }
            // InternalOptimisationLanguage.g:646:3: ( rule__SelfReferenceRule__Alternatives )
            // InternalOptimisationLanguage.g:646:4: rule__SelfReferenceRule__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__SelfReferenceRule__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSelfReferenceRuleAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSelfReferenceRule"


    // $ANTLR start "entryRuleAttributeReferenceRule"
    // InternalOptimisationLanguage.g:655:1: entryRuleAttributeReferenceRule : ruleAttributeReferenceRule EOF ;
    public final void entryRuleAttributeReferenceRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:656:1: ( ruleAttributeReferenceRule EOF )
            // InternalOptimisationLanguage.g:657:1: ruleAttributeReferenceRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeReferenceRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleAttributeReferenceRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeReferenceRuleRule()); 
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
    // $ANTLR end "entryRuleAttributeReferenceRule"


    // $ANTLR start "ruleAttributeReferenceRule"
    // InternalOptimisationLanguage.g:664:1: ruleAttributeReferenceRule : ( ( rule__AttributeReferenceRule__Group__0 ) ) ;
    public final void ruleAttributeReferenceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:668:2: ( ( ( rule__AttributeReferenceRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:669:2: ( ( rule__AttributeReferenceRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:669:2: ( ( rule__AttributeReferenceRule__Group__0 ) )
            // InternalOptimisationLanguage.g:670:3: ( rule__AttributeReferenceRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeReferenceRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:671:3: ( rule__AttributeReferenceRule__Group__0 )
            // InternalOptimisationLanguage.g:671:4: rule__AttributeReferenceRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__AttributeReferenceRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeReferenceRuleAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAttributeReferenceRule"


    // $ANTLR start "entryRuleConfigurationReferenceRule"
    // InternalOptimisationLanguage.g:680:1: entryRuleConfigurationReferenceRule : ruleConfigurationReferenceRule EOF ;
    public final void entryRuleConfigurationReferenceRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:681:1: ( ruleConfigurationReferenceRule EOF )
            // InternalOptimisationLanguage.g:682:1: ruleConfigurationReferenceRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigurationReferenceRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleConfigurationReferenceRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConfigurationReferenceRuleRule()); 
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
    // $ANTLR end "entryRuleConfigurationReferenceRule"


    // $ANTLR start "ruleConfigurationReferenceRule"
    // InternalOptimisationLanguage.g:689:1: ruleConfigurationReferenceRule : ( ( rule__ConfigurationReferenceRule__Group__0 ) ) ;
    public final void ruleConfigurationReferenceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:693:2: ( ( ( rule__ConfigurationReferenceRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:694:2: ( ( rule__ConfigurationReferenceRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:694:2: ( ( rule__ConfigurationReferenceRule__Group__0 ) )
            // InternalOptimisationLanguage.g:695:3: ( rule__ConfigurationReferenceRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigurationReferenceRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:696:3: ( rule__ConfigurationReferenceRule__Group__0 )
            // InternalOptimisationLanguage.g:696:4: rule__ConfigurationReferenceRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ConfigurationReferenceRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getConfigurationReferenceRuleAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConfigurationReferenceRule"


    // $ANTLR start "entryRuleValuelDefinitionReferenceRule"
    // InternalOptimisationLanguage.g:705:1: entryRuleValuelDefinitionReferenceRule : ruleValuelDefinitionReferenceRule EOF ;
    public final void entryRuleValuelDefinitionReferenceRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:706:1: ( ruleValuelDefinitionReferenceRule EOF )
            // InternalOptimisationLanguage.g:707:1: ruleValuelDefinitionReferenceRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValuelDefinitionReferenceRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleValuelDefinitionReferenceRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValuelDefinitionReferenceRuleRule()); 
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
    // $ANTLR end "entryRuleValuelDefinitionReferenceRule"


    // $ANTLR start "ruleValuelDefinitionReferenceRule"
    // InternalOptimisationLanguage.g:714:1: ruleValuelDefinitionReferenceRule : ( ( rule__ValuelDefinitionReferenceRule__DefinitionAssignment ) ) ;
    public final void ruleValuelDefinitionReferenceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:718:2: ( ( ( rule__ValuelDefinitionReferenceRule__DefinitionAssignment ) ) )
            // InternalOptimisationLanguage.g:719:2: ( ( rule__ValuelDefinitionReferenceRule__DefinitionAssignment ) )
            {
            // InternalOptimisationLanguage.g:719:2: ( ( rule__ValuelDefinitionReferenceRule__DefinitionAssignment ) )
            // InternalOptimisationLanguage.g:720:3: ( rule__ValuelDefinitionReferenceRule__DefinitionAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValuelDefinitionReferenceRuleAccess().getDefinitionAssignment()); 
            }
            // InternalOptimisationLanguage.g:721:3: ( rule__ValuelDefinitionReferenceRule__DefinitionAssignment )
            // InternalOptimisationLanguage.g:721:4: rule__ValuelDefinitionReferenceRule__DefinitionAssignment
            {
            pushFollow(FOLLOW_2);
            rule__ValuelDefinitionReferenceRule__DefinitionAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValuelDefinitionReferenceRuleAccess().getDefinitionAssignment()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleValuelDefinitionReferenceRule"


    // $ANTLR start "entryRuleTypeDefinitionReferenceRule"
    // InternalOptimisationLanguage.g:730:1: entryRuleTypeDefinitionReferenceRule : ruleTypeDefinitionReferenceRule EOF ;
    public final void entryRuleTypeDefinitionReferenceRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:731:1: ( ruleTypeDefinitionReferenceRule EOF )
            // InternalOptimisationLanguage.g:732:1: ruleTypeDefinitionReferenceRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDefinitionReferenceRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleTypeDefinitionReferenceRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeDefinitionReferenceRuleRule()); 
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
    // $ANTLR end "entryRuleTypeDefinitionReferenceRule"


    // $ANTLR start "ruleTypeDefinitionReferenceRule"
    // InternalOptimisationLanguage.g:739:1: ruleTypeDefinitionReferenceRule : ( ( rule__TypeDefinitionReferenceRule__Alternatives ) ) ;
    public final void ruleTypeDefinitionReferenceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:743:2: ( ( ( rule__TypeDefinitionReferenceRule__Alternatives ) ) )
            // InternalOptimisationLanguage.g:744:2: ( ( rule__TypeDefinitionReferenceRule__Alternatives ) )
            {
            // InternalOptimisationLanguage.g:744:2: ( ( rule__TypeDefinitionReferenceRule__Alternatives ) )
            // InternalOptimisationLanguage.g:745:3: ( rule__TypeDefinitionReferenceRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDefinitionReferenceRuleAccess().getAlternatives()); 
            }
            // InternalOptimisationLanguage.g:746:3: ( rule__TypeDefinitionReferenceRule__Alternatives )
            // InternalOptimisationLanguage.g:746:4: rule__TypeDefinitionReferenceRule__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__TypeDefinitionReferenceRule__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeDefinitionReferenceRuleAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTypeDefinitionReferenceRule"


    // $ANTLR start "entryRuleBaseDataReferenceRule"
    // InternalOptimisationLanguage.g:755:1: entryRuleBaseDataReferenceRule : ruleBaseDataReferenceRule EOF ;
    public final void entryRuleBaseDataReferenceRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:756:1: ( ruleBaseDataReferenceRule EOF )
            // InternalOptimisationLanguage.g:757:1: ruleBaseDataReferenceRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBaseDataReferenceRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleBaseDataReferenceRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBaseDataReferenceRuleRule()); 
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
    // $ANTLR end "entryRuleBaseDataReferenceRule"


    // $ANTLR start "ruleBaseDataReferenceRule"
    // InternalOptimisationLanguage.g:764:1: ruleBaseDataReferenceRule : ( ( rule__BaseDataReferenceRule__Group__0 ) ) ;
    public final void ruleBaseDataReferenceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:768:2: ( ( ( rule__BaseDataReferenceRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:769:2: ( ( rule__BaseDataReferenceRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:769:2: ( ( rule__BaseDataReferenceRule__Group__0 ) )
            // InternalOptimisationLanguage.g:770:3: ( rule__BaseDataReferenceRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBaseDataReferenceRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:771:3: ( rule__BaseDataReferenceRule__Group__0 )
            // InternalOptimisationLanguage.g:771:4: rule__BaseDataReferenceRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__BaseDataReferenceRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBaseDataReferenceRuleAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBaseDataReferenceRule"


    // $ANTLR start "entryRuleStructuredDataDescriptionReferenceRule"
    // InternalOptimisationLanguage.g:780:1: entryRuleStructuredDataDescriptionReferenceRule : ruleStructuredDataDescriptionReferenceRule EOF ;
    public final void entryRuleStructuredDataDescriptionReferenceRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:781:1: ( ruleStructuredDataDescriptionReferenceRule EOF )
            // InternalOptimisationLanguage.g:782:1: ruleStructuredDataDescriptionReferenceRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStructuredDataDescriptionReferenceRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleStructuredDataDescriptionReferenceRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getStructuredDataDescriptionReferenceRuleRule()); 
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
    // $ANTLR end "entryRuleStructuredDataDescriptionReferenceRule"


    // $ANTLR start "ruleStructuredDataDescriptionReferenceRule"
    // InternalOptimisationLanguage.g:789:1: ruleStructuredDataDescriptionReferenceRule : ( ( rule__StructuredDataDescriptionReferenceRule__Group__0 ) ) ;
    public final void ruleStructuredDataDescriptionReferenceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:793:2: ( ( ( rule__StructuredDataDescriptionReferenceRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:794:2: ( ( rule__StructuredDataDescriptionReferenceRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:794:2: ( ( rule__StructuredDataDescriptionReferenceRule__Group__0 ) )
            // InternalOptimisationLanguage.g:795:3: ( rule__StructuredDataDescriptionReferenceRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStructuredDataDescriptionReferenceRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:796:3: ( rule__StructuredDataDescriptionReferenceRule__Group__0 )
            // InternalOptimisationLanguage.g:796:4: rule__StructuredDataDescriptionReferenceRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__StructuredDataDescriptionReferenceRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getStructuredDataDescriptionReferenceRuleAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleStructuredDataDescriptionReferenceRule"


    // $ANTLR start "entryRuleLiteralRule"
    // InternalOptimisationLanguage.g:805:1: entryRuleLiteralRule : ruleLiteralRule EOF ;
    public final void entryRuleLiteralRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:806:1: ( ruleLiteralRule EOF )
            // InternalOptimisationLanguage.g:807:1: ruleLiteralRule EOF
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
    // InternalOptimisationLanguage.g:814:1: ruleLiteralRule : ( ( rule__LiteralRule__Alternatives ) ) ;
    public final void ruleLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:818:2: ( ( ( rule__LiteralRule__Alternatives ) ) )
            // InternalOptimisationLanguage.g:819:2: ( ( rule__LiteralRule__Alternatives ) )
            {
            // InternalOptimisationLanguage.g:819:2: ( ( rule__LiteralRule__Alternatives ) )
            // InternalOptimisationLanguage.g:820:3: ( rule__LiteralRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralRuleAccess().getAlternatives()); 
            }
            // InternalOptimisationLanguage.g:821:3: ( rule__LiteralRule__Alternatives )
            // InternalOptimisationLanguage.g:821:4: rule__LiteralRule__Alternatives
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
    // InternalOptimisationLanguage.g:830:1: entryRuleInstanceLiteralRule : ruleInstanceLiteralRule EOF ;
    public final void entryRuleInstanceLiteralRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:831:1: ( ruleInstanceLiteralRule EOF )
            // InternalOptimisationLanguage.g:832:1: ruleInstanceLiteralRule EOF
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
    // InternalOptimisationLanguage.g:839:1: ruleInstanceLiteralRule : ( ( rule__InstanceLiteralRule__Group__0 ) ) ;
    public final void ruleInstanceLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:843:2: ( ( ( rule__InstanceLiteralRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:844:2: ( ( rule__InstanceLiteralRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:844:2: ( ( rule__InstanceLiteralRule__Group__0 ) )
            // InternalOptimisationLanguage.g:845:3: ( rule__InstanceLiteralRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceLiteralRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:846:3: ( rule__InstanceLiteralRule__Group__0 )
            // InternalOptimisationLanguage.g:846:4: rule__InstanceLiteralRule__Group__0
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
    // InternalOptimisationLanguage.g:855:1: entryRuleAttributeRule : ruleAttributeRule EOF ;
    public final void entryRuleAttributeRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:856:1: ( ruleAttributeRule EOF )
            // InternalOptimisationLanguage.g:857:1: ruleAttributeRule EOF
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
    // InternalOptimisationLanguage.g:864:1: ruleAttributeRule : ( ( rule__AttributeRule__Group__0 ) ) ;
    public final void ruleAttributeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:868:2: ( ( ( rule__AttributeRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:869:2: ( ( rule__AttributeRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:869:2: ( ( rule__AttributeRule__Group__0 ) )
            // InternalOptimisationLanguage.g:870:3: ( rule__AttributeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:871:3: ( rule__AttributeRule__Group__0 )
            // InternalOptimisationLanguage.g:871:4: rule__AttributeRule__Group__0
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
    // InternalOptimisationLanguage.g:880:1: entryRuleNumberLiteralRule : ruleNumberLiteralRule EOF ;
    public final void entryRuleNumberLiteralRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:881:1: ( ruleNumberLiteralRule EOF )
            // InternalOptimisationLanguage.g:882:1: ruleNumberLiteralRule EOF
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
    // InternalOptimisationLanguage.g:889:1: ruleNumberLiteralRule : ( ( rule__NumberLiteralRule__Alternatives ) ) ;
    public final void ruleNumberLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:893:2: ( ( ( rule__NumberLiteralRule__Alternatives ) ) )
            // InternalOptimisationLanguage.g:894:2: ( ( rule__NumberLiteralRule__Alternatives ) )
            {
            // InternalOptimisationLanguage.g:894:2: ( ( rule__NumberLiteralRule__Alternatives ) )
            // InternalOptimisationLanguage.g:895:3: ( rule__NumberLiteralRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumberLiteralRuleAccess().getAlternatives()); 
            }
            // InternalOptimisationLanguage.g:896:3: ( rule__NumberLiteralRule__Alternatives )
            // InternalOptimisationLanguage.g:896:4: rule__NumberLiteralRule__Alternatives
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
    // InternalOptimisationLanguage.g:905:1: entryRuleRealLiteralRule : ruleRealLiteralRule EOF ;
    public final void entryRuleRealLiteralRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:906:1: ( ruleRealLiteralRule EOF )
            // InternalOptimisationLanguage.g:907:1: ruleRealLiteralRule EOF
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
    // InternalOptimisationLanguage.g:914:1: ruleRealLiteralRule : ( ( rule__RealLiteralRule__Group__0 ) ) ;
    public final void ruleRealLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:918:2: ( ( ( rule__RealLiteralRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:919:2: ( ( rule__RealLiteralRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:919:2: ( ( rule__RealLiteralRule__Group__0 ) )
            // InternalOptimisationLanguage.g:920:3: ( rule__RealLiteralRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealLiteralRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:921:3: ( rule__RealLiteralRule__Group__0 )
            // InternalOptimisationLanguage.g:921:4: rule__RealLiteralRule__Group__0
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
    // InternalOptimisationLanguage.g:930:1: entryRuleIntegerLiteralRule : ruleIntegerLiteralRule EOF ;
    public final void entryRuleIntegerLiteralRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:931:1: ( ruleIntegerLiteralRule EOF )
            // InternalOptimisationLanguage.g:932:1: ruleIntegerLiteralRule EOF
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
    // InternalOptimisationLanguage.g:939:1: ruleIntegerLiteralRule : ( ( rule__IntegerLiteralRule__Group__0 ) ) ;
    public final void ruleIntegerLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:943:2: ( ( ( rule__IntegerLiteralRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:944:2: ( ( rule__IntegerLiteralRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:944:2: ( ( rule__IntegerLiteralRule__Group__0 ) )
            // InternalOptimisationLanguage.g:945:3: ( rule__IntegerLiteralRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegerLiteralRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:946:3: ( rule__IntegerLiteralRule__Group__0 )
            // InternalOptimisationLanguage.g:946:4: rule__IntegerLiteralRule__Group__0
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
    // InternalOptimisationLanguage.g:955:1: entryRuleStringLiteralRule : ruleStringLiteralRule EOF ;
    public final void entryRuleStringLiteralRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:956:1: ( ruleStringLiteralRule EOF )
            // InternalOptimisationLanguage.g:957:1: ruleStringLiteralRule EOF
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
    // InternalOptimisationLanguage.g:964:1: ruleStringLiteralRule : ( ( rule__StringLiteralRule__LiteralAssignment ) ) ;
    public final void ruleStringLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:968:2: ( ( ( rule__StringLiteralRule__LiteralAssignment ) ) )
            // InternalOptimisationLanguage.g:969:2: ( ( rule__StringLiteralRule__LiteralAssignment ) )
            {
            // InternalOptimisationLanguage.g:969:2: ( ( rule__StringLiteralRule__LiteralAssignment ) )
            // InternalOptimisationLanguage.g:970:3: ( rule__StringLiteralRule__LiteralAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringLiteralRuleAccess().getLiteralAssignment()); 
            }
            // InternalOptimisationLanguage.g:971:3: ( rule__StringLiteralRule__LiteralAssignment )
            // InternalOptimisationLanguage.g:971:4: rule__StringLiteralRule__LiteralAssignment
            {
            pushFollow(FOLLOW_2);
            rule__StringLiteralRule__LiteralAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getStringLiteralRuleAccess().getLiteralAssignment()); 
            }

            }


            }

        }
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
    // InternalOptimisationLanguage.g:980:1: entryRuleBooleanLiteralRule : ruleBooleanLiteralRule EOF ;
    public final void entryRuleBooleanLiteralRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:981:1: ( ruleBooleanLiteralRule EOF )
            // InternalOptimisationLanguage.g:982:1: ruleBooleanLiteralRule EOF
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
    // InternalOptimisationLanguage.g:989:1: ruleBooleanLiteralRule : ( ( rule__BooleanLiteralRule__Group__0 ) ) ;
    public final void ruleBooleanLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:993:2: ( ( ( rule__BooleanLiteralRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:994:2: ( ( rule__BooleanLiteralRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:994:2: ( ( rule__BooleanLiteralRule__Group__0 ) )
            // InternalOptimisationLanguage.g:995:3: ( rule__BooleanLiteralRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:996:3: ( rule__BooleanLiteralRule__Group__0 )
            // InternalOptimisationLanguage.g:996:4: rule__BooleanLiteralRule__Group__0
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
    // InternalOptimisationLanguage.g:1005:1: entryRuleConstraintRule : ruleConstraintRule EOF ;
    public final void entryRuleConstraintRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:1006:1: ( ruleConstraintRule EOF )
            // InternalOptimisationLanguage.g:1007:1: ruleConstraintRule EOF
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
    // InternalOptimisationLanguage.g:1014:1: ruleConstraintRule : ( ( rule__ConstraintRule__Group__0 ) ) ;
    public final void ruleConstraintRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1018:2: ( ( ( rule__ConstraintRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:1019:2: ( ( rule__ConstraintRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:1019:2: ( ( rule__ConstraintRule__Group__0 ) )
            // InternalOptimisationLanguage.g:1020:3: ( rule__ConstraintRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstraintRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:1021:3: ( rule__ConstraintRule__Group__0 )
            // InternalOptimisationLanguage.g:1021:4: rule__ConstraintRule__Group__0
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
    // InternalOptimisationLanguage.g:1030:1: entryRuleAttributeDefinitionRule : ruleAttributeDefinitionRule EOF ;
    public final void entryRuleAttributeDefinitionRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:1031:1: ( ruleAttributeDefinitionRule EOF )
            // InternalOptimisationLanguage.g:1032:1: ruleAttributeDefinitionRule EOF
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
    // InternalOptimisationLanguage.g:1039:1: ruleAttributeDefinitionRule : ( ( rule__AttributeDefinitionRule__Group__0 ) ) ;
    public final void ruleAttributeDefinitionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1043:2: ( ( ( rule__AttributeDefinitionRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:1044:2: ( ( rule__AttributeDefinitionRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:1044:2: ( ( rule__AttributeDefinitionRule__Group__0 ) )
            // InternalOptimisationLanguage.g:1045:3: ( rule__AttributeDefinitionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:1046:3: ( rule__AttributeDefinitionRule__Group__0 )
            // InternalOptimisationLanguage.g:1046:4: rule__AttributeDefinitionRule__Group__0
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
    // InternalOptimisationLanguage.g:1055:1: entryRuleTypeRule : ruleTypeRule EOF ;
    public final void entryRuleTypeRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:1056:1: ( ruleTypeRule EOF )
            // InternalOptimisationLanguage.g:1057:1: ruleTypeRule EOF
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
    // InternalOptimisationLanguage.g:1064:1: ruleTypeRule : ( ( rule__TypeRule__Alternatives ) ) ;
    public final void ruleTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1068:2: ( ( ( rule__TypeRule__Alternatives ) ) )
            // InternalOptimisationLanguage.g:1069:2: ( ( rule__TypeRule__Alternatives ) )
            {
            // InternalOptimisationLanguage.g:1069:2: ( ( rule__TypeRule__Alternatives ) )
            // InternalOptimisationLanguage.g:1070:3: ( rule__TypeRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeRuleAccess().getAlternatives()); 
            }
            // InternalOptimisationLanguage.g:1071:3: ( rule__TypeRule__Alternatives )
            // InternalOptimisationLanguage.g:1071:4: rule__TypeRule__Alternatives
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


    // $ANTLR start "entryRuleBaseTypeRule"
    // InternalOptimisationLanguage.g:1080:1: entryRuleBaseTypeRule : ruleBaseTypeRule EOF ;
    public final void entryRuleBaseTypeRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:1081:1: ( ruleBaseTypeRule EOF )
            // InternalOptimisationLanguage.g:1082:1: ruleBaseTypeRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBaseTypeRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleBaseTypeRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBaseTypeRuleRule()); 
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
    // $ANTLR end "entryRuleBaseTypeRule"


    // $ANTLR start "ruleBaseTypeRule"
    // InternalOptimisationLanguage.g:1089:1: ruleBaseTypeRule : ( ( rule__BaseTypeRule__Alternatives ) ) ;
    public final void ruleBaseTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1093:2: ( ( ( rule__BaseTypeRule__Alternatives ) ) )
            // InternalOptimisationLanguage.g:1094:2: ( ( rule__BaseTypeRule__Alternatives ) )
            {
            // InternalOptimisationLanguage.g:1094:2: ( ( rule__BaseTypeRule__Alternatives ) )
            // InternalOptimisationLanguage.g:1095:3: ( rule__BaseTypeRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBaseTypeRuleAccess().getAlternatives()); 
            }
            // InternalOptimisationLanguage.g:1096:3: ( rule__BaseTypeRule__Alternatives )
            // InternalOptimisationLanguage.g:1096:4: rule__BaseTypeRule__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__BaseTypeRule__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBaseTypeRuleAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBaseTypeRule"


    // $ANTLR start "entryRuleEnumReferenceRule"
    // InternalOptimisationLanguage.g:1105:1: entryRuleEnumReferenceRule : ruleEnumReferenceRule EOF ;
    public final void entryRuleEnumReferenceRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:1106:1: ( ruleEnumReferenceRule EOF )
            // InternalOptimisationLanguage.g:1107:1: ruleEnumReferenceRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumReferenceRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleEnumReferenceRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumReferenceRuleRule()); 
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
    // $ANTLR end "entryRuleEnumReferenceRule"


    // $ANTLR start "ruleEnumReferenceRule"
    // InternalOptimisationLanguage.g:1114:1: ruleEnumReferenceRule : ( ( rule__EnumReferenceRule__Group__0 ) ) ;
    public final void ruleEnumReferenceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1118:2: ( ( ( rule__EnumReferenceRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:1119:2: ( ( rule__EnumReferenceRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:1119:2: ( ( rule__EnumReferenceRule__Group__0 ) )
            // InternalOptimisationLanguage.g:1120:3: ( rule__EnumReferenceRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumReferenceRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:1121:3: ( rule__EnumReferenceRule__Group__0 )
            // InternalOptimisationLanguage.g:1121:4: rule__EnumReferenceRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__EnumReferenceRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumReferenceRuleAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEnumReferenceRule"


    // $ANTLR start "entryRuleTypeReferenceRule"
    // InternalOptimisationLanguage.g:1130:1: entryRuleTypeReferenceRule : ruleTypeReferenceRule EOF ;
    public final void entryRuleTypeReferenceRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:1131:1: ( ruleTypeReferenceRule EOF )
            // InternalOptimisationLanguage.g:1132:1: ruleTypeReferenceRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeReferenceRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleTypeReferenceRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeReferenceRuleRule()); 
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
    // $ANTLR end "entryRuleTypeReferenceRule"


    // $ANTLR start "ruleTypeReferenceRule"
    // InternalOptimisationLanguage.g:1139:1: ruleTypeReferenceRule : ( ( rule__TypeReferenceRule__Group__0 ) ) ;
    public final void ruleTypeReferenceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1143:2: ( ( ( rule__TypeReferenceRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:1144:2: ( ( rule__TypeReferenceRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:1144:2: ( ( rule__TypeReferenceRule__Group__0 ) )
            // InternalOptimisationLanguage.g:1145:3: ( rule__TypeReferenceRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeReferenceRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:1146:3: ( rule__TypeReferenceRule__Group__0 )
            // InternalOptimisationLanguage.g:1146:4: rule__TypeReferenceRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TypeReferenceRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeReferenceRuleAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTypeReferenceRule"


    // $ANTLR start "entryRuleLiteralTypeRule"
    // InternalOptimisationLanguage.g:1155:1: entryRuleLiteralTypeRule : ruleLiteralTypeRule EOF ;
    public final void entryRuleLiteralTypeRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:1156:1: ( ruleLiteralTypeRule EOF )
            // InternalOptimisationLanguage.g:1157:1: ruleLiteralTypeRule EOF
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
    // InternalOptimisationLanguage.g:1164:1: ruleLiteralTypeRule : ( ( rule__LiteralTypeRule__Group__0 ) ) ;
    public final void ruleLiteralTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1168:2: ( ( ( rule__LiteralTypeRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:1169:2: ( ( rule__LiteralTypeRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:1169:2: ( ( rule__LiteralTypeRule__Group__0 ) )
            // InternalOptimisationLanguage.g:1170:3: ( rule__LiteralTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralTypeRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:1171:3: ( rule__LiteralTypeRule__Group__0 )
            // InternalOptimisationLanguage.g:1171:4: rule__LiteralTypeRule__Group__0
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
    // InternalOptimisationLanguage.g:1180:1: entryRuleDataTypeRule : ruleDataTypeRule EOF ;
    public final void entryRuleDataTypeRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:1181:1: ( ruleDataTypeRule EOF )
            // InternalOptimisationLanguage.g:1182:1: ruleDataTypeRule EOF
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
    // InternalOptimisationLanguage.g:1189:1: ruleDataTypeRule : ( ( rule__DataTypeRule__Group__0 ) ) ;
    public final void ruleDataTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1193:2: ( ( ( rule__DataTypeRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:1194:2: ( ( rule__DataTypeRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:1194:2: ( ( rule__DataTypeRule__Group__0 ) )
            // InternalOptimisationLanguage.g:1195:3: ( rule__DataTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:1196:3: ( rule__DataTypeRule__Group__0 )
            // InternalOptimisationLanguage.g:1196:4: rule__DataTypeRule__Group__0
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


    // $ANTLR start "entryRuleStringTypeRule"
    // InternalOptimisationLanguage.g:1205:1: entryRuleStringTypeRule : ruleStringTypeRule EOF ;
    public final void entryRuleStringTypeRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:1206:1: ( ruleStringTypeRule EOF )
            // InternalOptimisationLanguage.g:1207:1: ruleStringTypeRule EOF
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
    // InternalOptimisationLanguage.g:1214:1: ruleStringTypeRule : ( ( rule__StringTypeRule__Group__0 ) ) ;
    public final void ruleStringTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1218:2: ( ( ( rule__StringTypeRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:1219:2: ( ( rule__StringTypeRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:1219:2: ( ( rule__StringTypeRule__Group__0 ) )
            // InternalOptimisationLanguage.g:1220:3: ( rule__StringTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringTypeRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:1221:3: ( rule__StringTypeRule__Group__0 )
            // InternalOptimisationLanguage.g:1221:4: rule__StringTypeRule__Group__0
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
    // InternalOptimisationLanguage.g:1230:1: entryRuleExpressionTypeRule : ruleExpressionTypeRule EOF ;
    public final void entryRuleExpressionTypeRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:1231:1: ( ruleExpressionTypeRule EOF )
            // InternalOptimisationLanguage.g:1232:1: ruleExpressionTypeRule EOF
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
    // InternalOptimisationLanguage.g:1239:1: ruleExpressionTypeRule : ( ( rule__ExpressionTypeRule__Group__0 ) ) ;
    public final void ruleExpressionTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1243:2: ( ( ( rule__ExpressionTypeRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:1244:2: ( ( rule__ExpressionTypeRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:1244:2: ( ( rule__ExpressionTypeRule__Group__0 ) )
            // InternalOptimisationLanguage.g:1245:3: ( rule__ExpressionTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionTypeRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:1246:3: ( rule__ExpressionTypeRule__Group__0 )
            // InternalOptimisationLanguage.g:1246:4: rule__ExpressionTypeRule__Group__0
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
    // InternalOptimisationLanguage.g:1255:1: entryRuleIntTypeRule : ruleIntTypeRule EOF ;
    public final void entryRuleIntTypeRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:1256:1: ( ruleIntTypeRule EOF )
            // InternalOptimisationLanguage.g:1257:1: ruleIntTypeRule EOF
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
    // InternalOptimisationLanguage.g:1264:1: ruleIntTypeRule : ( ( rule__IntTypeRule__Group__0 ) ) ;
    public final void ruleIntTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1268:2: ( ( ( rule__IntTypeRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:1269:2: ( ( rule__IntTypeRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:1269:2: ( ( rule__IntTypeRule__Group__0 ) )
            // InternalOptimisationLanguage.g:1270:3: ( rule__IntTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntTypeRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:1271:3: ( rule__IntTypeRule__Group__0 )
            // InternalOptimisationLanguage.g:1271:4: rule__IntTypeRule__Group__0
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
    // InternalOptimisationLanguage.g:1280:1: entryRuleRealTypeRule : ruleRealTypeRule EOF ;
    public final void entryRuleRealTypeRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:1281:1: ( ruleRealTypeRule EOF )
            // InternalOptimisationLanguage.g:1282:1: ruleRealTypeRule EOF
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
    // InternalOptimisationLanguage.g:1289:1: ruleRealTypeRule : ( ( rule__RealTypeRule__Group__0 ) ) ;
    public final void ruleRealTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1293:2: ( ( ( rule__RealTypeRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:1294:2: ( ( rule__RealTypeRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:1294:2: ( ( rule__RealTypeRule__Group__0 ) )
            // InternalOptimisationLanguage.g:1295:3: ( rule__RealTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealTypeRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:1296:3: ( rule__RealTypeRule__Group__0 )
            // InternalOptimisationLanguage.g:1296:4: rule__RealTypeRule__Group__0
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
    // InternalOptimisationLanguage.g:1305:1: entryRuleBooleanTypeRule : ruleBooleanTypeRule EOF ;
    public final void entryRuleBooleanTypeRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:1306:1: ( ruleBooleanTypeRule EOF )
            // InternalOptimisationLanguage.g:1307:1: ruleBooleanTypeRule EOF
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
    // InternalOptimisationLanguage.g:1314:1: ruleBooleanTypeRule : ( ( rule__BooleanTypeRule__Group__0 ) ) ;
    public final void ruleBooleanTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1318:2: ( ( ( rule__BooleanTypeRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:1319:2: ( ( rule__BooleanTypeRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:1319:2: ( ( rule__BooleanTypeRule__Group__0 ) )
            // InternalOptimisationLanguage.g:1320:3: ( rule__BooleanTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanTypeRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:1321:3: ( rule__BooleanTypeRule__Group__0 )
            // InternalOptimisationLanguage.g:1321:4: rule__BooleanTypeRule__Group__0
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
    // InternalOptimisationLanguage.g:1330:1: entryRuleVoidTypeRule : ruleVoidTypeRule EOF ;
    public final void entryRuleVoidTypeRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:1331:1: ( ruleVoidTypeRule EOF )
            // InternalOptimisationLanguage.g:1332:1: ruleVoidTypeRule EOF
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
    // InternalOptimisationLanguage.g:1339:1: ruleVoidTypeRule : ( ( rule__VoidTypeRule__Group__0 ) ) ;
    public final void ruleVoidTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1343:2: ( ( ( rule__VoidTypeRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:1344:2: ( ( rule__VoidTypeRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:1344:2: ( ( rule__VoidTypeRule__Group__0 ) )
            // InternalOptimisationLanguage.g:1345:3: ( rule__VoidTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVoidTypeRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:1346:3: ( rule__VoidTypeRule__Group__0 )
            // InternalOptimisationLanguage.g:1346:4: rule__VoidTypeRule__Group__0
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
    // InternalOptimisationLanguage.g:1355:1: entryRuleArrayTypeRule : ruleArrayTypeRule EOF ;
    public final void entryRuleArrayTypeRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:1356:1: ( ruleArrayTypeRule EOF )
            // InternalOptimisationLanguage.g:1357:1: ruleArrayTypeRule EOF
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
    // InternalOptimisationLanguage.g:1364:1: ruleArrayTypeRule : ( ( rule__ArrayTypeRule__Group__0 ) ) ;
    public final void ruleArrayTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1368:2: ( ( ( rule__ArrayTypeRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:1369:2: ( ( rule__ArrayTypeRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:1369:2: ( ( rule__ArrayTypeRule__Group__0 ) )
            // InternalOptimisationLanguage.g:1370:3: ( rule__ArrayTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayTypeRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:1371:3: ( rule__ArrayTypeRule__Group__0 )
            // InternalOptimisationLanguage.g:1371:4: rule__ArrayTypeRule__Group__0
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
    // InternalOptimisationLanguage.g:1380:1: entryRuleParameterRule : ruleParameterRule EOF ;
    public final void entryRuleParameterRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:1381:1: ( ruleParameterRule EOF )
            // InternalOptimisationLanguage.g:1382:1: ruleParameterRule EOF
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
    // InternalOptimisationLanguage.g:1389:1: ruleParameterRule : ( ( rule__ParameterRule__Group__0 ) ) ;
    public final void ruleParameterRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1393:2: ( ( ( rule__ParameterRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:1394:2: ( ( rule__ParameterRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:1394:2: ( ( rule__ParameterRule__Group__0 ) )
            // InternalOptimisationLanguage.g:1395:3: ( rule__ParameterRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:1396:3: ( rule__ParameterRule__Group__0 )
            // InternalOptimisationLanguage.g:1396:4: rule__ParameterRule__Group__0
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
    // InternalOptimisationLanguage.g:1405:1: entryRuleImportRule : ruleImportRule EOF ;
    public final void entryRuleImportRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:1406:1: ( ruleImportRule EOF )
            // InternalOptimisationLanguage.g:1407:1: ruleImportRule EOF
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
    // InternalOptimisationLanguage.g:1414:1: ruleImportRule : ( ( rule__ImportRule__Group__0 ) ) ;
    public final void ruleImportRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1418:2: ( ( ( rule__ImportRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:1419:2: ( ( rule__ImportRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:1419:2: ( ( rule__ImportRule__Group__0 ) )
            // InternalOptimisationLanguage.g:1420:3: ( rule__ImportRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportRuleAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:1421:3: ( rule__ImportRule__Group__0 )
            // InternalOptimisationLanguage.g:1421:4: rule__ImportRule__Group__0
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
    // InternalOptimisationLanguage.g:1430:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:1431:1: ( ruleQualifiedName EOF )
            // InternalOptimisationLanguage.g:1432:1: ruleQualifiedName EOF
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
    // InternalOptimisationLanguage.g:1439:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1443:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // InternalOptimisationLanguage.g:1444:2: ( ( rule__QualifiedName__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:1444:2: ( ( rule__QualifiedName__Group__0 ) )
            // InternalOptimisationLanguage.g:1445:3: ( rule__QualifiedName__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            }
            // InternalOptimisationLanguage.g:1446:3: ( rule__QualifiedName__Group__0 )
            // InternalOptimisationLanguage.g:1446:4: rule__QualifiedName__Group__0
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
    // InternalOptimisationLanguage.g:1455:1: entryRuleStringOrId : ruleStringOrId EOF ;
    public final void entryRuleStringOrId() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:1456:1: ( ruleStringOrId EOF )
            // InternalOptimisationLanguage.g:1457:1: ruleStringOrId EOF
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
    // InternalOptimisationLanguage.g:1464:1: ruleStringOrId : ( ( rule__StringOrId__Alternatives ) ) ;
    public final void ruleStringOrId() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1468:2: ( ( ( rule__StringOrId__Alternatives ) ) )
            // InternalOptimisationLanguage.g:1469:2: ( ( rule__StringOrId__Alternatives ) )
            {
            // InternalOptimisationLanguage.g:1469:2: ( ( rule__StringOrId__Alternatives ) )
            // InternalOptimisationLanguage.g:1470:3: ( rule__StringOrId__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringOrIdAccess().getAlternatives()); 
            }
            // InternalOptimisationLanguage.g:1471:3: ( rule__StringOrId__Alternatives )
            // InternalOptimisationLanguage.g:1471:4: rule__StringOrId__Alternatives
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
    // InternalOptimisationLanguage.g:1480:1: ruleComparisonOperatorRule : ( ( rule__ComparisonOperatorRule__Alternatives ) ) ;
    public final void ruleComparisonOperatorRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1484:1: ( ( ( rule__ComparisonOperatorRule__Alternatives ) ) )
            // InternalOptimisationLanguage.g:1485:2: ( ( rule__ComparisonOperatorRule__Alternatives ) )
            {
            // InternalOptimisationLanguage.g:1485:2: ( ( rule__ComparisonOperatorRule__Alternatives ) )
            // InternalOptimisationLanguage.g:1486:3: ( rule__ComparisonOperatorRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonOperatorRuleAccess().getAlternatives()); 
            }
            // InternalOptimisationLanguage.g:1487:3: ( rule__ComparisonOperatorRule__Alternatives )
            // InternalOptimisationLanguage.g:1487:4: rule__ComparisonOperatorRule__Alternatives
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
    // InternalOptimisationLanguage.g:1496:1: ruleAddOrSubtractOperatorRule : ( ( rule__AddOrSubtractOperatorRule__Alternatives ) ) ;
    public final void ruleAddOrSubtractOperatorRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1500:1: ( ( ( rule__AddOrSubtractOperatorRule__Alternatives ) ) )
            // InternalOptimisationLanguage.g:1501:2: ( ( rule__AddOrSubtractOperatorRule__Alternatives ) )
            {
            // InternalOptimisationLanguage.g:1501:2: ( ( rule__AddOrSubtractOperatorRule__Alternatives ) )
            // InternalOptimisationLanguage.g:1502:3: ( rule__AddOrSubtractOperatorRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOrSubtractOperatorRuleAccess().getAlternatives()); 
            }
            // InternalOptimisationLanguage.g:1503:3: ( rule__AddOrSubtractOperatorRule__Alternatives )
            // InternalOptimisationLanguage.g:1503:4: rule__AddOrSubtractOperatorRule__Alternatives
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
    // InternalOptimisationLanguage.g:1512:1: ruleMultiplyDivideModuloOperatorRule : ( ( rule__MultiplyDivideModuloOperatorRule__Alternatives ) ) ;
    public final void ruleMultiplyDivideModuloOperatorRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1516:1: ( ( ( rule__MultiplyDivideModuloOperatorRule__Alternatives ) ) )
            // InternalOptimisationLanguage.g:1517:2: ( ( rule__MultiplyDivideModuloOperatorRule__Alternatives ) )
            {
            // InternalOptimisationLanguage.g:1517:2: ( ( rule__MultiplyDivideModuloOperatorRule__Alternatives ) )
            // InternalOptimisationLanguage.g:1518:3: ( rule__MultiplyDivideModuloOperatorRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getAlternatives()); 
            }
            // InternalOptimisationLanguage.g:1519:3: ( rule__MultiplyDivideModuloOperatorRule__Alternatives )
            // InternalOptimisationLanguage.g:1519:4: rule__MultiplyDivideModuloOperatorRule__Alternatives
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
    // InternalOptimisationLanguage.g:1528:1: ruleFactorRule : ( ( rule__FactorRule__Alternatives ) ) ;
    public final void ruleFactorRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1532:1: ( ( ( rule__FactorRule__Alternatives ) ) )
            // InternalOptimisationLanguage.g:1533:2: ( ( rule__FactorRule__Alternatives ) )
            {
            // InternalOptimisationLanguage.g:1533:2: ( ( rule__FactorRule__Alternatives ) )
            // InternalOptimisationLanguage.g:1534:3: ( rule__FactorRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFactorRuleAccess().getAlternatives()); 
            }
            // InternalOptimisationLanguage.g:1535:3: ( rule__FactorRule__Alternatives )
            // InternalOptimisationLanguage.g:1535:4: rule__FactorRule__Alternatives
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


    // $ANTLR start "rule__OptimisationGoalRule__Alternatives"
    // InternalOptimisationLanguage.g:1543:1: rule__OptimisationGoalRule__Alternatives : ( ( ruleMaximiseGoalRule ) | ( ruleMinimiseGoalRule ) | ( ruleTargetGoalRule ) );
    public final void rule__OptimisationGoalRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1547:1: ( ( ruleMaximiseGoalRule ) | ( ruleMinimiseGoalRule ) | ( ruleTargetGoalRule ) )
            int alt1=3;
            switch ( input.LA(1) ) {
            case 59:
                {
                alt1=1;
                }
                break;
            case 60:
                {
                alt1=2;
                }
                break;
            case 61:
                {
                alt1=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // InternalOptimisationLanguage.g:1548:2: ( ruleMaximiseGoalRule )
                    {
                    // InternalOptimisationLanguage.g:1548:2: ( ruleMaximiseGoalRule )
                    // InternalOptimisationLanguage.g:1549:3: ruleMaximiseGoalRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOptimisationGoalRuleAccess().getMaximiseGoalRuleParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleMaximiseGoalRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOptimisationGoalRuleAccess().getMaximiseGoalRuleParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalOptimisationLanguage.g:1554:2: ( ruleMinimiseGoalRule )
                    {
                    // InternalOptimisationLanguage.g:1554:2: ( ruleMinimiseGoalRule )
                    // InternalOptimisationLanguage.g:1555:3: ruleMinimiseGoalRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOptimisationGoalRuleAccess().getMinimiseGoalRuleParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleMinimiseGoalRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOptimisationGoalRuleAccess().getMinimiseGoalRuleParserRuleCall_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalOptimisationLanguage.g:1560:2: ( ruleTargetGoalRule )
                    {
                    // InternalOptimisationLanguage.g:1560:2: ( ruleTargetGoalRule )
                    // InternalOptimisationLanguage.g:1561:3: ruleTargetGoalRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOptimisationGoalRuleAccess().getTargetGoalRuleParserRuleCall_2()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleTargetGoalRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOptimisationGoalRuleAccess().getTargetGoalRuleParserRuleCall_2()); 
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
    // $ANTLR end "rule__OptimisationGoalRule__Alternatives"


    // $ANTLR start "rule__TargetGoalRule__Alternatives_3"
    // InternalOptimisationLanguage.g:1570:1: rule__TargetGoalRule__Alternatives_3 : ( ( ( rule__TargetGoalRule__FromEvaluationAssignment_3_0 ) ) | ( ( rule__TargetGoalRule__ValueAssignment_3_1 ) ) );
    public final void rule__TargetGoalRule__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1574:1: ( ( ( rule__TargetGoalRule__FromEvaluationAssignment_3_0 ) ) | ( ( rule__TargetGoalRule__ValueAssignment_3_1 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==92) ) {
                alt2=1;
            }
            else if ( ((LA2_0>=RULE_QUOTED_ID && LA2_0<=RULE_STRING)||LA2_0==15||LA2_0==94) ) {
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
                    // InternalOptimisationLanguage.g:1575:2: ( ( rule__TargetGoalRule__FromEvaluationAssignment_3_0 ) )
                    {
                    // InternalOptimisationLanguage.g:1575:2: ( ( rule__TargetGoalRule__FromEvaluationAssignment_3_0 ) )
                    // InternalOptimisationLanguage.g:1576:3: ( rule__TargetGoalRule__FromEvaluationAssignment_3_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTargetGoalRuleAccess().getFromEvaluationAssignment_3_0()); 
                    }
                    // InternalOptimisationLanguage.g:1577:3: ( rule__TargetGoalRule__FromEvaluationAssignment_3_0 )
                    // InternalOptimisationLanguage.g:1577:4: rule__TargetGoalRule__FromEvaluationAssignment_3_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TargetGoalRule__FromEvaluationAssignment_3_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTargetGoalRuleAccess().getFromEvaluationAssignment_3_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalOptimisationLanguage.g:1581:2: ( ( rule__TargetGoalRule__ValueAssignment_3_1 ) )
                    {
                    // InternalOptimisationLanguage.g:1581:2: ( ( rule__TargetGoalRule__ValueAssignment_3_1 ) )
                    // InternalOptimisationLanguage.g:1582:3: ( rule__TargetGoalRule__ValueAssignment_3_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTargetGoalRuleAccess().getValueAssignment_3_1()); 
                    }
                    // InternalOptimisationLanguage.g:1583:3: ( rule__TargetGoalRule__ValueAssignment_3_1 )
                    // InternalOptimisationLanguage.g:1583:4: rule__TargetGoalRule__ValueAssignment_3_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__TargetGoalRule__ValueAssignment_3_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTargetGoalRuleAccess().getValueAssignment_3_1()); 
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
    // $ANTLR end "rule__TargetGoalRule__Alternatives_3"


    // $ANTLR start "rule__ReadExpressionRule__Alternatives"
    // InternalOptimisationLanguage.g:1591:1: rule__ReadExpressionRule__Alternatives : ( ( ruleArrayRule ) | ( ruleCallRule ) | ( ruleLiteralRule ) | ( ruleParanthesesRule ) | ( ruleReferenceRule ) );
    public final void rule__ReadExpressionRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1595:1: ( ( ruleArrayRule ) | ( ruleCallRule ) | ( ruleLiteralRule ) | ( ruleParanthesesRule ) | ( ruleReferenceRule ) )
            int alt3=5;
            alt3 = dfa3.predict(input);
            switch (alt3) {
                case 1 :
                    // InternalOptimisationLanguage.g:1596:2: ( ruleArrayRule )
                    {
                    // InternalOptimisationLanguage.g:1596:2: ( ruleArrayRule )
                    // InternalOptimisationLanguage.g:1597:3: ruleArrayRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getReadExpressionRuleAccess().getArrayRuleParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleArrayRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getReadExpressionRuleAccess().getArrayRuleParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalOptimisationLanguage.g:1602:2: ( ruleCallRule )
                    {
                    // InternalOptimisationLanguage.g:1602:2: ( ruleCallRule )
                    // InternalOptimisationLanguage.g:1603:3: ruleCallRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getReadExpressionRuleAccess().getCallRuleParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleCallRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getReadExpressionRuleAccess().getCallRuleParserRuleCall_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalOptimisationLanguage.g:1608:2: ( ruleLiteralRule )
                    {
                    // InternalOptimisationLanguage.g:1608:2: ( ruleLiteralRule )
                    // InternalOptimisationLanguage.g:1609:3: ruleLiteralRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getReadExpressionRuleAccess().getLiteralRuleParserRuleCall_2()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleLiteralRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getReadExpressionRuleAccess().getLiteralRuleParserRuleCall_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalOptimisationLanguage.g:1614:2: ( ruleParanthesesRule )
                    {
                    // InternalOptimisationLanguage.g:1614:2: ( ruleParanthesesRule )
                    // InternalOptimisationLanguage.g:1615:3: ruleParanthesesRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getReadExpressionRuleAccess().getParanthesesRuleParserRuleCall_3()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleParanthesesRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getReadExpressionRuleAccess().getParanthesesRuleParserRuleCall_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalOptimisationLanguage.g:1620:2: ( ruleReferenceRule )
                    {
                    // InternalOptimisationLanguage.g:1620:2: ( ruleReferenceRule )
                    // InternalOptimisationLanguage.g:1621:3: ruleReferenceRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getReadExpressionRuleAccess().getReferenceRuleParserRuleCall_4()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleReferenceRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getReadExpressionRuleAccess().getReferenceRuleParserRuleCall_4()); 
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
    // $ANTLR end "rule__ReadExpressionRule__Alternatives"


    // $ANTLR start "rule__ReferenceRule__Alternatives"
    // InternalOptimisationLanguage.g:1630:1: rule__ReferenceRule__Alternatives : ( ( ruleValuelDefinitionReferenceRule ) | ( ruleConfigurationReferenceRule ) | ( ruleTypeDefinitionReferenceRule ) | ( ruleAttributeReferenceRule ) );
    public final void rule__ReferenceRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1634:1: ( ( ruleValuelDefinitionReferenceRule ) | ( ruleConfigurationReferenceRule ) | ( ruleTypeDefinitionReferenceRule ) | ( ruleAttributeReferenceRule ) )
            int alt4=4;
            switch ( input.LA(1) ) {
            case RULE_QUOTED_ID:
            case RULE_ID:
                {
                alt4=1;
                }
                break;
            case 76:
                {
                alt4=2;
                }
                break;
            case 77:
            case 78:
                {
                alt4=3;
                }
                break;
            case 74:
            case 75:
                {
                alt4=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalOptimisationLanguage.g:1635:2: ( ruleValuelDefinitionReferenceRule )
                    {
                    // InternalOptimisationLanguage.g:1635:2: ( ruleValuelDefinitionReferenceRule )
                    // InternalOptimisationLanguage.g:1636:3: ruleValuelDefinitionReferenceRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getReferenceRuleAccess().getValuelDefinitionReferenceRuleParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleValuelDefinitionReferenceRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getReferenceRuleAccess().getValuelDefinitionReferenceRuleParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalOptimisationLanguage.g:1641:2: ( ruleConfigurationReferenceRule )
                    {
                    // InternalOptimisationLanguage.g:1641:2: ( ruleConfigurationReferenceRule )
                    // InternalOptimisationLanguage.g:1642:3: ruleConfigurationReferenceRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getReferenceRuleAccess().getConfigurationReferenceRuleParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleConfigurationReferenceRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getReferenceRuleAccess().getConfigurationReferenceRuleParserRuleCall_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalOptimisationLanguage.g:1647:2: ( ruleTypeDefinitionReferenceRule )
                    {
                    // InternalOptimisationLanguage.g:1647:2: ( ruleTypeDefinitionReferenceRule )
                    // InternalOptimisationLanguage.g:1648:3: ruleTypeDefinitionReferenceRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getReferenceRuleAccess().getTypeDefinitionReferenceRuleParserRuleCall_2()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleTypeDefinitionReferenceRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getReferenceRuleAccess().getTypeDefinitionReferenceRuleParserRuleCall_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalOptimisationLanguage.g:1653:2: ( ruleAttributeReferenceRule )
                    {
                    // InternalOptimisationLanguage.g:1653:2: ( ruleAttributeReferenceRule )
                    // InternalOptimisationLanguage.g:1654:3: ruleAttributeReferenceRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getReferenceRuleAccess().getAttributeReferenceRuleParserRuleCall_3()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleAttributeReferenceRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getReferenceRuleAccess().getAttributeReferenceRuleParserRuleCall_3()); 
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


    // $ANTLR start "rule__SelfReferenceRule__Alternatives"
    // InternalOptimisationLanguage.g:1663:1: rule__SelfReferenceRule__Alternatives : ( ( ( rule__SelfReferenceRule__Group_0__0 ) ) | ( ( rule__SelfReferenceRule__Group_1__0 ) ) );
    public final void rule__SelfReferenceRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1667:1: ( ( ( rule__SelfReferenceRule__Group_0__0 ) ) | ( ( rule__SelfReferenceRule__Group_1__0 ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==74) ) {
                alt5=1;
            }
            else if ( (LA5_0==75) ) {
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
                    // InternalOptimisationLanguage.g:1668:2: ( ( rule__SelfReferenceRule__Group_0__0 ) )
                    {
                    // InternalOptimisationLanguage.g:1668:2: ( ( rule__SelfReferenceRule__Group_0__0 ) )
                    // InternalOptimisationLanguage.g:1669:3: ( rule__SelfReferenceRule__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSelfReferenceRuleAccess().getGroup_0()); 
                    }
                    // InternalOptimisationLanguage.g:1670:3: ( rule__SelfReferenceRule__Group_0__0 )
                    // InternalOptimisationLanguage.g:1670:4: rule__SelfReferenceRule__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__SelfReferenceRule__Group_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSelfReferenceRuleAccess().getGroup_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalOptimisationLanguage.g:1674:2: ( ( rule__SelfReferenceRule__Group_1__0 ) )
                    {
                    // InternalOptimisationLanguage.g:1674:2: ( ( rule__SelfReferenceRule__Group_1__0 ) )
                    // InternalOptimisationLanguage.g:1675:3: ( rule__SelfReferenceRule__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSelfReferenceRuleAccess().getGroup_1()); 
                    }
                    // InternalOptimisationLanguage.g:1676:3: ( rule__SelfReferenceRule__Group_1__0 )
                    // InternalOptimisationLanguage.g:1676:4: rule__SelfReferenceRule__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__SelfReferenceRule__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSelfReferenceRuleAccess().getGroup_1()); 
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
    // $ANTLR end "rule__SelfReferenceRule__Alternatives"


    // $ANTLR start "rule__TypeDefinitionReferenceRule__Alternatives"
    // InternalOptimisationLanguage.g:1684:1: rule__TypeDefinitionReferenceRule__Alternatives : ( ( ruleBaseDataReferenceRule ) | ( ruleStructuredDataDescriptionReferenceRule ) );
    public final void rule__TypeDefinitionReferenceRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1688:1: ( ( ruleBaseDataReferenceRule ) | ( ruleStructuredDataDescriptionReferenceRule ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==77) ) {
                alt6=1;
            }
            else if ( (LA6_0==78) ) {
                alt6=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalOptimisationLanguage.g:1689:2: ( ruleBaseDataReferenceRule )
                    {
                    // InternalOptimisationLanguage.g:1689:2: ( ruleBaseDataReferenceRule )
                    // InternalOptimisationLanguage.g:1690:3: ruleBaseDataReferenceRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeDefinitionReferenceRuleAccess().getBaseDataReferenceRuleParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleBaseDataReferenceRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeDefinitionReferenceRuleAccess().getBaseDataReferenceRuleParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalOptimisationLanguage.g:1695:2: ( ruleStructuredDataDescriptionReferenceRule )
                    {
                    // InternalOptimisationLanguage.g:1695:2: ( ruleStructuredDataDescriptionReferenceRule )
                    // InternalOptimisationLanguage.g:1696:3: ruleStructuredDataDescriptionReferenceRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeDefinitionReferenceRuleAccess().getStructuredDataDescriptionReferenceRuleParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleStructuredDataDescriptionReferenceRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeDefinitionReferenceRuleAccess().getStructuredDataDescriptionReferenceRuleParserRuleCall_1()); 
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
    // $ANTLR end "rule__TypeDefinitionReferenceRule__Alternatives"


    // $ANTLR start "rule__LiteralRule__Alternatives"
    // InternalOptimisationLanguage.g:1705:1: rule__LiteralRule__Alternatives : ( ( ruleNumberLiteralRule ) | ( ruleStringLiteralRule ) | ( ruleBooleanLiteralRule ) | ( ruleInstanceLiteralRule ) );
    public final void rule__LiteralRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1709:1: ( ( ruleNumberLiteralRule ) | ( ruleStringLiteralRule ) | ( ruleBooleanLiteralRule ) | ( ruleInstanceLiteralRule ) )
            int alt7=4;
            switch ( input.LA(1) ) {
            case RULE_DOUBLE:
            case RULE_INT:
                {
                alt7=1;
                }
                break;
            case RULE_STRING:
                {
                alt7=2;
                }
                break;
            case 15:
            case 94:
                {
                alt7=3;
                }
                break;
            case RULE_QUOTED_ID:
            case RULE_ID:
                {
                alt7=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalOptimisationLanguage.g:1710:2: ( ruleNumberLiteralRule )
                    {
                    // InternalOptimisationLanguage.g:1710:2: ( ruleNumberLiteralRule )
                    // InternalOptimisationLanguage.g:1711:3: ruleNumberLiteralRule
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
                    // InternalOptimisationLanguage.g:1716:2: ( ruleStringLiteralRule )
                    {
                    // InternalOptimisationLanguage.g:1716:2: ( ruleStringLiteralRule )
                    // InternalOptimisationLanguage.g:1717:3: ruleStringLiteralRule
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
                    // InternalOptimisationLanguage.g:1722:2: ( ruleBooleanLiteralRule )
                    {
                    // InternalOptimisationLanguage.g:1722:2: ( ruleBooleanLiteralRule )
                    // InternalOptimisationLanguage.g:1723:3: ruleBooleanLiteralRule
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
                    // InternalOptimisationLanguage.g:1728:2: ( ruleInstanceLiteralRule )
                    {
                    // InternalOptimisationLanguage.g:1728:2: ( ruleInstanceLiteralRule )
                    // InternalOptimisationLanguage.g:1729:3: ruleInstanceLiteralRule
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
    // InternalOptimisationLanguage.g:1738:1: rule__NumberLiteralRule__Alternatives : ( ( ruleRealLiteralRule ) | ( ruleIntegerLiteralRule ) );
    public final void rule__NumberLiteralRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1742:1: ( ( ruleRealLiteralRule ) | ( ruleIntegerLiteralRule ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_DOUBLE) ) {
                alt8=1;
            }
            else if ( (LA8_0==RULE_INT) ) {
                alt8=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalOptimisationLanguage.g:1743:2: ( ruleRealLiteralRule )
                    {
                    // InternalOptimisationLanguage.g:1743:2: ( ruleRealLiteralRule )
                    // InternalOptimisationLanguage.g:1744:3: ruleRealLiteralRule
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
                    // InternalOptimisationLanguage.g:1749:2: ( ruleIntegerLiteralRule )
                    {
                    // InternalOptimisationLanguage.g:1749:2: ( ruleIntegerLiteralRule )
                    // InternalOptimisationLanguage.g:1750:3: ruleIntegerLiteralRule
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
    // InternalOptimisationLanguage.g:1759:1: rule__BooleanLiteralRule__Alternatives_1 : ( ( ( rule__BooleanLiteralRule__LiteralAssignment_1_0 ) ) | ( 'false' ) );
    public final void rule__BooleanLiteralRule__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1763:1: ( ( ( rule__BooleanLiteralRule__LiteralAssignment_1_0 ) ) | ( 'false' ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==94) ) {
                alt9=1;
            }
            else if ( (LA9_0==15) ) {
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
                    // InternalOptimisationLanguage.g:1764:2: ( ( rule__BooleanLiteralRule__LiteralAssignment_1_0 ) )
                    {
                    // InternalOptimisationLanguage.g:1764:2: ( ( rule__BooleanLiteralRule__LiteralAssignment_1_0 ) )
                    // InternalOptimisationLanguage.g:1765:3: ( rule__BooleanLiteralRule__LiteralAssignment_1_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBooleanLiteralRuleAccess().getLiteralAssignment_1_0()); 
                    }
                    // InternalOptimisationLanguage.g:1766:3: ( rule__BooleanLiteralRule__LiteralAssignment_1_0 )
                    // InternalOptimisationLanguage.g:1766:4: rule__BooleanLiteralRule__LiteralAssignment_1_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__BooleanLiteralRule__LiteralAssignment_1_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getBooleanLiteralRuleAccess().getLiteralAssignment_1_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalOptimisationLanguage.g:1770:2: ( 'false' )
                    {
                    // InternalOptimisationLanguage.g:1770:2: ( 'false' )
                    // InternalOptimisationLanguage.g:1771:3: 'false'
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
    // InternalOptimisationLanguage.g:1780:1: rule__TypeRule__Alternatives : ( ( ruleArrayTypeRule ) | ( ruleBaseTypeRule ) | ( ruleTypeReferenceRule ) | ( ruleEnumReferenceRule ) | ( ruleExpressionTypeRule ) | ( ruleLiteralTypeRule ) | ( ruleDataTypeRule ) );
    public final void rule__TypeRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1784:1: ( ( ruleArrayTypeRule ) | ( ruleBaseTypeRule ) | ( ruleTypeReferenceRule ) | ( ruleEnumReferenceRule ) | ( ruleExpressionTypeRule ) | ( ruleLiteralTypeRule ) | ( ruleDataTypeRule ) )
            int alt10=7;
            switch ( input.LA(1) ) {
            case 89:
                {
                alt10=1;
                }
                break;
            case 83:
            case 85:
            case 86:
            case 87:
            case 88:
                {
                alt10=2;
                }
                break;
            case 78:
                {
                alt10=3;
                }
                break;
            case 81:
                {
                alt10=4;
                }
                break;
            case 84:
                {
                alt10=5;
                }
                break;
            case 82:
                {
                alt10=6;
                }
                break;
            case 77:
                {
                alt10=7;
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
                    // InternalOptimisationLanguage.g:1785:2: ( ruleArrayTypeRule )
                    {
                    // InternalOptimisationLanguage.g:1785:2: ( ruleArrayTypeRule )
                    // InternalOptimisationLanguage.g:1786:3: ruleArrayTypeRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeRuleAccess().getArrayTypeRuleParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleArrayTypeRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeRuleAccess().getArrayTypeRuleParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalOptimisationLanguage.g:1791:2: ( ruleBaseTypeRule )
                    {
                    // InternalOptimisationLanguage.g:1791:2: ( ruleBaseTypeRule )
                    // InternalOptimisationLanguage.g:1792:3: ruleBaseTypeRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeRuleAccess().getBaseTypeRuleParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleBaseTypeRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeRuleAccess().getBaseTypeRuleParserRuleCall_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalOptimisationLanguage.g:1797:2: ( ruleTypeReferenceRule )
                    {
                    // InternalOptimisationLanguage.g:1797:2: ( ruleTypeReferenceRule )
                    // InternalOptimisationLanguage.g:1798:3: ruleTypeReferenceRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeRuleAccess().getTypeReferenceRuleParserRuleCall_2()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleTypeReferenceRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeRuleAccess().getTypeReferenceRuleParserRuleCall_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalOptimisationLanguage.g:1803:2: ( ruleEnumReferenceRule )
                    {
                    // InternalOptimisationLanguage.g:1803:2: ( ruleEnumReferenceRule )
                    // InternalOptimisationLanguage.g:1804:3: ruleEnumReferenceRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeRuleAccess().getEnumReferenceRuleParserRuleCall_3()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleEnumReferenceRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeRuleAccess().getEnumReferenceRuleParserRuleCall_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalOptimisationLanguage.g:1809:2: ( ruleExpressionTypeRule )
                    {
                    // InternalOptimisationLanguage.g:1809:2: ( ruleExpressionTypeRule )
                    // InternalOptimisationLanguage.g:1810:3: ruleExpressionTypeRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeRuleAccess().getExpressionTypeRuleParserRuleCall_4()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleExpressionTypeRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeRuleAccess().getExpressionTypeRuleParserRuleCall_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalOptimisationLanguage.g:1815:2: ( ruleLiteralTypeRule )
                    {
                    // InternalOptimisationLanguage.g:1815:2: ( ruleLiteralTypeRule )
                    // InternalOptimisationLanguage.g:1816:3: ruleLiteralTypeRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeRuleAccess().getLiteralTypeRuleParserRuleCall_5()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleLiteralTypeRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeRuleAccess().getLiteralTypeRuleParserRuleCall_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalOptimisationLanguage.g:1821:2: ( ruleDataTypeRule )
                    {
                    // InternalOptimisationLanguage.g:1821:2: ( ruleDataTypeRule )
                    // InternalOptimisationLanguage.g:1822:3: ruleDataTypeRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeRuleAccess().getDataTypeRuleParserRuleCall_6()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleDataTypeRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeRuleAccess().getDataTypeRuleParserRuleCall_6()); 
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


    // $ANTLR start "rule__BaseTypeRule__Alternatives"
    // InternalOptimisationLanguage.g:1831:1: rule__BaseTypeRule__Alternatives : ( ( ruleStringTypeRule ) | ( ruleIntTypeRule ) | ( ruleRealTypeRule ) | ( ruleBooleanTypeRule ) | ( ruleVoidTypeRule ) );
    public final void rule__BaseTypeRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1835:1: ( ( ruleStringTypeRule ) | ( ruleIntTypeRule ) | ( ruleRealTypeRule ) | ( ruleBooleanTypeRule ) | ( ruleVoidTypeRule ) )
            int alt11=5;
            switch ( input.LA(1) ) {
            case 83:
                {
                alt11=1;
                }
                break;
            case 85:
                {
                alt11=2;
                }
                break;
            case 86:
                {
                alt11=3;
                }
                break;
            case 87:
                {
                alt11=4;
                }
                break;
            case 88:
                {
                alt11=5;
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
                    // InternalOptimisationLanguage.g:1836:2: ( ruleStringTypeRule )
                    {
                    // InternalOptimisationLanguage.g:1836:2: ( ruleStringTypeRule )
                    // InternalOptimisationLanguage.g:1837:3: ruleStringTypeRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBaseTypeRuleAccess().getStringTypeRuleParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleStringTypeRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getBaseTypeRuleAccess().getStringTypeRuleParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalOptimisationLanguage.g:1842:2: ( ruleIntTypeRule )
                    {
                    // InternalOptimisationLanguage.g:1842:2: ( ruleIntTypeRule )
                    // InternalOptimisationLanguage.g:1843:3: ruleIntTypeRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBaseTypeRuleAccess().getIntTypeRuleParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleIntTypeRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getBaseTypeRuleAccess().getIntTypeRuleParserRuleCall_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalOptimisationLanguage.g:1848:2: ( ruleRealTypeRule )
                    {
                    // InternalOptimisationLanguage.g:1848:2: ( ruleRealTypeRule )
                    // InternalOptimisationLanguage.g:1849:3: ruleRealTypeRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBaseTypeRuleAccess().getRealTypeRuleParserRuleCall_2()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleRealTypeRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getBaseTypeRuleAccess().getRealTypeRuleParserRuleCall_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalOptimisationLanguage.g:1854:2: ( ruleBooleanTypeRule )
                    {
                    // InternalOptimisationLanguage.g:1854:2: ( ruleBooleanTypeRule )
                    // InternalOptimisationLanguage.g:1855:3: ruleBooleanTypeRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBaseTypeRuleAccess().getBooleanTypeRuleParserRuleCall_3()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleBooleanTypeRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getBaseTypeRuleAccess().getBooleanTypeRuleParserRuleCall_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalOptimisationLanguage.g:1860:2: ( ruleVoidTypeRule )
                    {
                    // InternalOptimisationLanguage.g:1860:2: ( ruleVoidTypeRule )
                    // InternalOptimisationLanguage.g:1861:3: ruleVoidTypeRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBaseTypeRuleAccess().getVoidTypeRuleParserRuleCall_4()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleVoidTypeRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getBaseTypeRuleAccess().getVoidTypeRuleParserRuleCall_4()); 
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
    // $ANTLR end "rule__BaseTypeRule__Alternatives"


    // $ANTLR start "rule__StringOrId__Alternatives"
    // InternalOptimisationLanguage.g:1870:1: rule__StringOrId__Alternatives : ( ( RULE_QUOTED_ID ) | ( RULE_ID ) );
    public final void rule__StringOrId__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1874:1: ( ( RULE_QUOTED_ID ) | ( RULE_ID ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_QUOTED_ID) ) {
                alt12=1;
            }
            else if ( (LA12_0==RULE_ID) ) {
                alt12=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // InternalOptimisationLanguage.g:1875:2: ( RULE_QUOTED_ID )
                    {
                    // InternalOptimisationLanguage.g:1875:2: ( RULE_QUOTED_ID )
                    // InternalOptimisationLanguage.g:1876:3: RULE_QUOTED_ID
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
                    // InternalOptimisationLanguage.g:1881:2: ( RULE_ID )
                    {
                    // InternalOptimisationLanguage.g:1881:2: ( RULE_ID )
                    // InternalOptimisationLanguage.g:1882:3: RULE_ID
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
    // InternalOptimisationLanguage.g:1891:1: rule__ComparisonOperatorRule__Alternatives : ( ( ( '>' ) ) | ( ( '>=' ) ) | ( ( '=' ) ) | ( ( '!=' ) ) | ( ( '<=' ) ) | ( ( '<' ) ) );
    public final void rule__ComparisonOperatorRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1895:1: ( ( ( '>' ) ) | ( ( '>=' ) ) | ( ( '=' ) ) | ( ( '!=' ) ) | ( ( '<=' ) ) | ( ( '<' ) ) )
            int alt13=6;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt13=1;
                }
                break;
            case 17:
                {
                alt13=2;
                }
                break;
            case 18:
                {
                alt13=3;
                }
                break;
            case 19:
                {
                alt13=4;
                }
                break;
            case 20:
                {
                alt13=5;
                }
                break;
            case 21:
                {
                alt13=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // InternalOptimisationLanguage.g:1896:2: ( ( '>' ) )
                    {
                    // InternalOptimisationLanguage.g:1896:2: ( ( '>' ) )
                    // InternalOptimisationLanguage.g:1897:3: ( '>' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getGreaterThanEnumLiteralDeclaration_0()); 
                    }
                    // InternalOptimisationLanguage.g:1898:3: ( '>' )
                    // InternalOptimisationLanguage.g:1898:4: '>'
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
                    // InternalOptimisationLanguage.g:1902:2: ( ( '>=' ) )
                    {
                    // InternalOptimisationLanguage.g:1902:2: ( ( '>=' ) )
                    // InternalOptimisationLanguage.g:1903:3: ( '>=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getGreaterEqualEnumLiteralDeclaration_1()); 
                    }
                    // InternalOptimisationLanguage.g:1904:3: ( '>=' )
                    // InternalOptimisationLanguage.g:1904:4: '>='
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
                    // InternalOptimisationLanguage.g:1908:2: ( ( '=' ) )
                    {
                    // InternalOptimisationLanguage.g:1908:2: ( ( '=' ) )
                    // InternalOptimisationLanguage.g:1909:3: ( '=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getEqualEnumLiteralDeclaration_2()); 
                    }
                    // InternalOptimisationLanguage.g:1910:3: ( '=' )
                    // InternalOptimisationLanguage.g:1910:4: '='
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
                    // InternalOptimisationLanguage.g:1914:2: ( ( '!=' ) )
                    {
                    // InternalOptimisationLanguage.g:1914:2: ( ( '!=' ) )
                    // InternalOptimisationLanguage.g:1915:3: ( '!=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getUnequalEnumLiteralDeclaration_3()); 
                    }
                    // InternalOptimisationLanguage.g:1916:3: ( '!=' )
                    // InternalOptimisationLanguage.g:1916:4: '!='
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
                    // InternalOptimisationLanguage.g:1920:2: ( ( '<=' ) )
                    {
                    // InternalOptimisationLanguage.g:1920:2: ( ( '<=' ) )
                    // InternalOptimisationLanguage.g:1921:3: ( '<=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getLessEqualEnumLiteralDeclaration_4()); 
                    }
                    // InternalOptimisationLanguage.g:1922:3: ( '<=' )
                    // InternalOptimisationLanguage.g:1922:4: '<='
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
                    // InternalOptimisationLanguage.g:1926:2: ( ( '<' ) )
                    {
                    // InternalOptimisationLanguage.g:1926:2: ( ( '<' ) )
                    // InternalOptimisationLanguage.g:1927:3: ( '<' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getLessThanEnumLiteralDeclaration_5()); 
                    }
                    // InternalOptimisationLanguage.g:1928:3: ( '<' )
                    // InternalOptimisationLanguage.g:1928:4: '<'
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
    // InternalOptimisationLanguage.g:1936:1: rule__AddOrSubtractOperatorRule__Alternatives : ( ( ( '+' ) ) | ( ( '-' ) ) );
    public final void rule__AddOrSubtractOperatorRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1940:1: ( ( ( '+' ) ) | ( ( '-' ) ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==22) ) {
                alt14=1;
            }
            else if ( (LA14_0==23) ) {
                alt14=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // InternalOptimisationLanguage.g:1941:2: ( ( '+' ) )
                    {
                    // InternalOptimisationLanguage.g:1941:2: ( ( '+' ) )
                    // InternalOptimisationLanguage.g:1942:3: ( '+' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAddOrSubtractOperatorRuleAccess().getAddEnumLiteralDeclaration_0()); 
                    }
                    // InternalOptimisationLanguage.g:1943:3: ( '+' )
                    // InternalOptimisationLanguage.g:1943:4: '+'
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
                    // InternalOptimisationLanguage.g:1947:2: ( ( '-' ) )
                    {
                    // InternalOptimisationLanguage.g:1947:2: ( ( '-' ) )
                    // InternalOptimisationLanguage.g:1948:3: ( '-' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAddOrSubtractOperatorRuleAccess().getSubtractEnumLiteralDeclaration_1()); 
                    }
                    // InternalOptimisationLanguage.g:1949:3: ( '-' )
                    // InternalOptimisationLanguage.g:1949:4: '-'
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
    // InternalOptimisationLanguage.g:1957:1: rule__MultiplyDivideModuloOperatorRule__Alternatives : ( ( ( '*' ) ) | ( ( '/' ) ) | ( ( '%' ) ) );
    public final void rule__MultiplyDivideModuloOperatorRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1961:1: ( ( ( '*' ) ) | ( ( '/' ) ) | ( ( '%' ) ) )
            int alt15=3;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt15=1;
                }
                break;
            case 25:
                {
                alt15=2;
                }
                break;
            case 26:
                {
                alt15=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // InternalOptimisationLanguage.g:1962:2: ( ( '*' ) )
                    {
                    // InternalOptimisationLanguage.g:1962:2: ( ( '*' ) )
                    // InternalOptimisationLanguage.g:1963:3: ( '*' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getMultiplyEnumLiteralDeclaration_0()); 
                    }
                    // InternalOptimisationLanguage.g:1964:3: ( '*' )
                    // InternalOptimisationLanguage.g:1964:4: '*'
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
                    // InternalOptimisationLanguage.g:1968:2: ( ( '/' ) )
                    {
                    // InternalOptimisationLanguage.g:1968:2: ( ( '/' ) )
                    // InternalOptimisationLanguage.g:1969:3: ( '/' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getDivideEnumLiteralDeclaration_1()); 
                    }
                    // InternalOptimisationLanguage.g:1970:3: ( '/' )
                    // InternalOptimisationLanguage.g:1970:4: '/'
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
                    // InternalOptimisationLanguage.g:1974:2: ( ( '%' ) )
                    {
                    // InternalOptimisationLanguage.g:1974:2: ( ( '%' ) )
                    // InternalOptimisationLanguage.g:1975:3: ( '%' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getModuloEnumLiteralDeclaration_2()); 
                    }
                    // InternalOptimisationLanguage.g:1976:3: ( '%' )
                    // InternalOptimisationLanguage.g:1976:4: '%'
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
    // InternalOptimisationLanguage.g:1984:1: rule__FactorRule__Alternatives : ( ( ( 'Y' ) ) | ( ( 'Z' ) ) | ( ( 'E' ) ) | ( ( 'P' ) ) | ( ( 'T' ) ) | ( ( 'G' ) ) | ( ( 'M' ) ) | ( ( 'k' ) ) | ( ( 'h' ) ) | ( ( 'da' ) ) | ( ( 'd' ) ) | ( ( 'c' ) ) | ( ( 'm' ) ) | ( ( '\\u00B5' ) ) | ( ( 'n' ) ) | ( ( 'p' ) ) | ( ( 'f' ) ) | ( ( 'a' ) ) | ( ( 'z' ) ) | ( ( 'y' ) ) );
    public final void rule__FactorRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1988:1: ( ( ( 'Y' ) ) | ( ( 'Z' ) ) | ( ( 'E' ) ) | ( ( 'P' ) ) | ( ( 'T' ) ) | ( ( 'G' ) ) | ( ( 'M' ) ) | ( ( 'k' ) ) | ( ( 'h' ) ) | ( ( 'da' ) ) | ( ( 'd' ) ) | ( ( 'c' ) ) | ( ( 'm' ) ) | ( ( '\\u00B5' ) ) | ( ( 'n' ) ) | ( ( 'p' ) ) | ( ( 'f' ) ) | ( ( 'a' ) ) | ( ( 'z' ) ) | ( ( 'y' ) ) )
            int alt16=20;
            switch ( input.LA(1) ) {
            case 27:
                {
                alt16=1;
                }
                break;
            case 28:
                {
                alt16=2;
                }
                break;
            case 29:
                {
                alt16=3;
                }
                break;
            case 30:
                {
                alt16=4;
                }
                break;
            case 31:
                {
                alt16=5;
                }
                break;
            case 32:
                {
                alt16=6;
                }
                break;
            case 33:
                {
                alt16=7;
                }
                break;
            case 34:
                {
                alt16=8;
                }
                break;
            case 35:
                {
                alt16=9;
                }
                break;
            case 36:
                {
                alt16=10;
                }
                break;
            case 37:
                {
                alt16=11;
                }
                break;
            case 38:
                {
                alt16=12;
                }
                break;
            case 39:
                {
                alt16=13;
                }
                break;
            case 40:
                {
                alt16=14;
                }
                break;
            case 41:
                {
                alt16=15;
                }
                break;
            case 42:
                {
                alt16=16;
                }
                break;
            case 43:
                {
                alt16=17;
                }
                break;
            case 44:
                {
                alt16=18;
                }
                break;
            case 45:
                {
                alt16=19;
                }
                break;
            case 46:
                {
                alt16=20;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // InternalOptimisationLanguage.g:1989:2: ( ( 'Y' ) )
                    {
                    // InternalOptimisationLanguage.g:1989:2: ( ( 'Y' ) )
                    // InternalOptimisationLanguage.g:1990:3: ( 'Y' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getYottaEnumLiteralDeclaration_0()); 
                    }
                    // InternalOptimisationLanguage.g:1991:3: ( 'Y' )
                    // InternalOptimisationLanguage.g:1991:4: 'Y'
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
                    // InternalOptimisationLanguage.g:1995:2: ( ( 'Z' ) )
                    {
                    // InternalOptimisationLanguage.g:1995:2: ( ( 'Z' ) )
                    // InternalOptimisationLanguage.g:1996:3: ( 'Z' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getZettaEnumLiteralDeclaration_1()); 
                    }
                    // InternalOptimisationLanguage.g:1997:3: ( 'Z' )
                    // InternalOptimisationLanguage.g:1997:4: 'Z'
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
                    // InternalOptimisationLanguage.g:2001:2: ( ( 'E' ) )
                    {
                    // InternalOptimisationLanguage.g:2001:2: ( ( 'E' ) )
                    // InternalOptimisationLanguage.g:2002:3: ( 'E' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getExaEnumLiteralDeclaration_2()); 
                    }
                    // InternalOptimisationLanguage.g:2003:3: ( 'E' )
                    // InternalOptimisationLanguage.g:2003:4: 'E'
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
                    // InternalOptimisationLanguage.g:2007:2: ( ( 'P' ) )
                    {
                    // InternalOptimisationLanguage.g:2007:2: ( ( 'P' ) )
                    // InternalOptimisationLanguage.g:2008:3: ( 'P' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getPetaEnumLiteralDeclaration_3()); 
                    }
                    // InternalOptimisationLanguage.g:2009:3: ( 'P' )
                    // InternalOptimisationLanguage.g:2009:4: 'P'
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
                    // InternalOptimisationLanguage.g:2013:2: ( ( 'T' ) )
                    {
                    // InternalOptimisationLanguage.g:2013:2: ( ( 'T' ) )
                    // InternalOptimisationLanguage.g:2014:3: ( 'T' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getTeraEnumLiteralDeclaration_4()); 
                    }
                    // InternalOptimisationLanguage.g:2015:3: ( 'T' )
                    // InternalOptimisationLanguage.g:2015:4: 'T'
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
                    // InternalOptimisationLanguage.g:2019:2: ( ( 'G' ) )
                    {
                    // InternalOptimisationLanguage.g:2019:2: ( ( 'G' ) )
                    // InternalOptimisationLanguage.g:2020:3: ( 'G' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getGigaEnumLiteralDeclaration_5()); 
                    }
                    // InternalOptimisationLanguage.g:2021:3: ( 'G' )
                    // InternalOptimisationLanguage.g:2021:4: 'G'
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
                    // InternalOptimisationLanguage.g:2025:2: ( ( 'M' ) )
                    {
                    // InternalOptimisationLanguage.g:2025:2: ( ( 'M' ) )
                    // InternalOptimisationLanguage.g:2026:3: ( 'M' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getMegaEnumLiteralDeclaration_6()); 
                    }
                    // InternalOptimisationLanguage.g:2027:3: ( 'M' )
                    // InternalOptimisationLanguage.g:2027:4: 'M'
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
                    // InternalOptimisationLanguage.g:2031:2: ( ( 'k' ) )
                    {
                    // InternalOptimisationLanguage.g:2031:2: ( ( 'k' ) )
                    // InternalOptimisationLanguage.g:2032:3: ( 'k' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getKiloEnumLiteralDeclaration_7()); 
                    }
                    // InternalOptimisationLanguage.g:2033:3: ( 'k' )
                    // InternalOptimisationLanguage.g:2033:4: 'k'
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
                    // InternalOptimisationLanguage.g:2037:2: ( ( 'h' ) )
                    {
                    // InternalOptimisationLanguage.g:2037:2: ( ( 'h' ) )
                    // InternalOptimisationLanguage.g:2038:3: ( 'h' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getHectoEnumLiteralDeclaration_8()); 
                    }
                    // InternalOptimisationLanguage.g:2039:3: ( 'h' )
                    // InternalOptimisationLanguage.g:2039:4: 'h'
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
                    // InternalOptimisationLanguage.g:2043:2: ( ( 'da' ) )
                    {
                    // InternalOptimisationLanguage.g:2043:2: ( ( 'da' ) )
                    // InternalOptimisationLanguage.g:2044:3: ( 'da' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getDekaEnumLiteralDeclaration_9()); 
                    }
                    // InternalOptimisationLanguage.g:2045:3: ( 'da' )
                    // InternalOptimisationLanguage.g:2045:4: 'da'
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
                    // InternalOptimisationLanguage.g:2049:2: ( ( 'd' ) )
                    {
                    // InternalOptimisationLanguage.g:2049:2: ( ( 'd' ) )
                    // InternalOptimisationLanguage.g:2050:3: ( 'd' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getDeciEnumLiteralDeclaration_10()); 
                    }
                    // InternalOptimisationLanguage.g:2051:3: ( 'd' )
                    // InternalOptimisationLanguage.g:2051:4: 'd'
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
                    // InternalOptimisationLanguage.g:2055:2: ( ( 'c' ) )
                    {
                    // InternalOptimisationLanguage.g:2055:2: ( ( 'c' ) )
                    // InternalOptimisationLanguage.g:2056:3: ( 'c' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getCentiEnumLiteralDeclaration_11()); 
                    }
                    // InternalOptimisationLanguage.g:2057:3: ( 'c' )
                    // InternalOptimisationLanguage.g:2057:4: 'c'
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
                    // InternalOptimisationLanguage.g:2061:2: ( ( 'm' ) )
                    {
                    // InternalOptimisationLanguage.g:2061:2: ( ( 'm' ) )
                    // InternalOptimisationLanguage.g:2062:3: ( 'm' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getMilliEnumLiteralDeclaration_12()); 
                    }
                    // InternalOptimisationLanguage.g:2063:3: ( 'm' )
                    // InternalOptimisationLanguage.g:2063:4: 'm'
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
                    // InternalOptimisationLanguage.g:2067:2: ( ( '\\u00B5' ) )
                    {
                    // InternalOptimisationLanguage.g:2067:2: ( ( '\\u00B5' ) )
                    // InternalOptimisationLanguage.g:2068:3: ( '\\u00B5' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getMicroEnumLiteralDeclaration_13()); 
                    }
                    // InternalOptimisationLanguage.g:2069:3: ( '\\u00B5' )
                    // InternalOptimisationLanguage.g:2069:4: '\\u00B5'
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
                    // InternalOptimisationLanguage.g:2073:2: ( ( 'n' ) )
                    {
                    // InternalOptimisationLanguage.g:2073:2: ( ( 'n' ) )
                    // InternalOptimisationLanguage.g:2074:3: ( 'n' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getNanoEnumLiteralDeclaration_14()); 
                    }
                    // InternalOptimisationLanguage.g:2075:3: ( 'n' )
                    // InternalOptimisationLanguage.g:2075:4: 'n'
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
                    // InternalOptimisationLanguage.g:2079:2: ( ( 'p' ) )
                    {
                    // InternalOptimisationLanguage.g:2079:2: ( ( 'p' ) )
                    // InternalOptimisationLanguage.g:2080:3: ( 'p' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getPikoEnumLiteralDeclaration_15()); 
                    }
                    // InternalOptimisationLanguage.g:2081:3: ( 'p' )
                    // InternalOptimisationLanguage.g:2081:4: 'p'
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
                    // InternalOptimisationLanguage.g:2085:2: ( ( 'f' ) )
                    {
                    // InternalOptimisationLanguage.g:2085:2: ( ( 'f' ) )
                    // InternalOptimisationLanguage.g:2086:3: ( 'f' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getFemtoEnumLiteralDeclaration_16()); 
                    }
                    // InternalOptimisationLanguage.g:2087:3: ( 'f' )
                    // InternalOptimisationLanguage.g:2087:4: 'f'
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
                    // InternalOptimisationLanguage.g:2091:2: ( ( 'a' ) )
                    {
                    // InternalOptimisationLanguage.g:2091:2: ( ( 'a' ) )
                    // InternalOptimisationLanguage.g:2092:3: ( 'a' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getAttoEnumLiteralDeclaration_17()); 
                    }
                    // InternalOptimisationLanguage.g:2093:3: ( 'a' )
                    // InternalOptimisationLanguage.g:2093:4: 'a'
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
                    // InternalOptimisationLanguage.g:2097:2: ( ( 'z' ) )
                    {
                    // InternalOptimisationLanguage.g:2097:2: ( ( 'z' ) )
                    // InternalOptimisationLanguage.g:2098:3: ( 'z' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getZeptoEnumLiteralDeclaration_18()); 
                    }
                    // InternalOptimisationLanguage.g:2099:3: ( 'z' )
                    // InternalOptimisationLanguage.g:2099:4: 'z'
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
                    // InternalOptimisationLanguage.g:2103:2: ( ( 'y' ) )
                    {
                    // InternalOptimisationLanguage.g:2103:2: ( ( 'y' ) )
                    // InternalOptimisationLanguage.g:2104:3: ( 'y' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getYoctoEnumLiteralDeclaration_19()); 
                    }
                    // InternalOptimisationLanguage.g:2105:3: ( 'y' )
                    // InternalOptimisationLanguage.g:2105:4: 'y'
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
    // InternalOptimisationLanguage.g:2113:1: rule__OptimisationModelRule__Group__0 : rule__OptimisationModelRule__Group__0__Impl rule__OptimisationModelRule__Group__1 ;
    public final void rule__OptimisationModelRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2117:1: ( rule__OptimisationModelRule__Group__0__Impl rule__OptimisationModelRule__Group__1 )
            // InternalOptimisationLanguage.g:2118:2: rule__OptimisationModelRule__Group__0__Impl rule__OptimisationModelRule__Group__1
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
    // InternalOptimisationLanguage.g:2125:1: rule__OptimisationModelRule__Group__0__Impl : ( ( rule__OptimisationModelRule__ImportsAssignment_0 )* ) ;
    public final void rule__OptimisationModelRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2129:1: ( ( ( rule__OptimisationModelRule__ImportsAssignment_0 )* ) )
            // InternalOptimisationLanguage.g:2130:1: ( ( rule__OptimisationModelRule__ImportsAssignment_0 )* )
            {
            // InternalOptimisationLanguage.g:2130:1: ( ( rule__OptimisationModelRule__ImportsAssignment_0 )* )
            // InternalOptimisationLanguage.g:2131:2: ( rule__OptimisationModelRule__ImportsAssignment_0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOptimisationModelRuleAccess().getImportsAssignment_0()); 
            }
            // InternalOptimisationLanguage.g:2132:2: ( rule__OptimisationModelRule__ImportsAssignment_0 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==90) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:2132:3: rule__OptimisationModelRule__ImportsAssignment_0
            	    {
            	    pushFollow(FOLLOW_4);
            	    rule__OptimisationModelRule__ImportsAssignment_0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop17;
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
    // InternalOptimisationLanguage.g:2140:1: rule__OptimisationModelRule__Group__1 : rule__OptimisationModelRule__Group__1__Impl rule__OptimisationModelRule__Group__2 ;
    public final void rule__OptimisationModelRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2144:1: ( rule__OptimisationModelRule__Group__1__Impl rule__OptimisationModelRule__Group__2 )
            // InternalOptimisationLanguage.g:2145:2: rule__OptimisationModelRule__Group__1__Impl rule__OptimisationModelRule__Group__2
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
    // InternalOptimisationLanguage.g:2152:1: rule__OptimisationModelRule__Group__1__Impl : ( 'module' ) ;
    public final void rule__OptimisationModelRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2156:1: ( ( 'module' ) )
            // InternalOptimisationLanguage.g:2157:1: ( 'module' )
            {
            // InternalOptimisationLanguage.g:2157:1: ( 'module' )
            // InternalOptimisationLanguage.g:2158:2: 'module'
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
    // InternalOptimisationLanguage.g:2167:1: rule__OptimisationModelRule__Group__2 : rule__OptimisationModelRule__Group__2__Impl rule__OptimisationModelRule__Group__3 ;
    public final void rule__OptimisationModelRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2171:1: ( rule__OptimisationModelRule__Group__2__Impl rule__OptimisationModelRule__Group__3 )
            // InternalOptimisationLanguage.g:2172:2: rule__OptimisationModelRule__Group__2__Impl rule__OptimisationModelRule__Group__3
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
    // InternalOptimisationLanguage.g:2179:1: rule__OptimisationModelRule__Group__2__Impl : ( ( rule__OptimisationModelRule__NameAssignment_2 ) ) ;
    public final void rule__OptimisationModelRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2183:1: ( ( ( rule__OptimisationModelRule__NameAssignment_2 ) ) )
            // InternalOptimisationLanguage.g:2184:1: ( ( rule__OptimisationModelRule__NameAssignment_2 ) )
            {
            // InternalOptimisationLanguage.g:2184:1: ( ( rule__OptimisationModelRule__NameAssignment_2 ) )
            // InternalOptimisationLanguage.g:2185:2: ( rule__OptimisationModelRule__NameAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOptimisationModelRuleAccess().getNameAssignment_2()); 
            }
            // InternalOptimisationLanguage.g:2186:2: ( rule__OptimisationModelRule__NameAssignment_2 )
            // InternalOptimisationLanguage.g:2186:3: rule__OptimisationModelRule__NameAssignment_2
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
    // InternalOptimisationLanguage.g:2194:1: rule__OptimisationModelRule__Group__3 : rule__OptimisationModelRule__Group__3__Impl rule__OptimisationModelRule__Group__4 ;
    public final void rule__OptimisationModelRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2198:1: ( rule__OptimisationModelRule__Group__3__Impl rule__OptimisationModelRule__Group__4 )
            // InternalOptimisationLanguage.g:2199:2: rule__OptimisationModelRule__Group__3__Impl rule__OptimisationModelRule__Group__4
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
    // InternalOptimisationLanguage.g:2206:1: rule__OptimisationModelRule__Group__3__Impl : ( '{' ) ;
    public final void rule__OptimisationModelRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2210:1: ( ( '{' ) )
            // InternalOptimisationLanguage.g:2211:1: ( '{' )
            {
            // InternalOptimisationLanguage.g:2211:1: ( '{' )
            // InternalOptimisationLanguage.g:2212:2: '{'
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
    // InternalOptimisationLanguage.g:2221:1: rule__OptimisationModelRule__Group__4 : rule__OptimisationModelRule__Group__4__Impl rule__OptimisationModelRule__Group__5 ;
    public final void rule__OptimisationModelRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2225:1: ( rule__OptimisationModelRule__Group__4__Impl rule__OptimisationModelRule__Group__5 )
            // InternalOptimisationLanguage.g:2226:2: rule__OptimisationModelRule__Group__4__Impl rule__OptimisationModelRule__Group__5
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
    // InternalOptimisationLanguage.g:2233:1: rule__OptimisationModelRule__Group__4__Impl : ( ( rule__OptimisationModelRule__ProblemAssignment_4 )? ) ;
    public final void rule__OptimisationModelRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2237:1: ( ( ( rule__OptimisationModelRule__ProblemAssignment_4 )? ) )
            // InternalOptimisationLanguage.g:2238:1: ( ( rule__OptimisationModelRule__ProblemAssignment_4 )? )
            {
            // InternalOptimisationLanguage.g:2238:1: ( ( rule__OptimisationModelRule__ProblemAssignment_4 )? )
            // InternalOptimisationLanguage.g:2239:2: ( rule__OptimisationModelRule__ProblemAssignment_4 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOptimisationModelRuleAccess().getProblemAssignment_4()); 
            }
            // InternalOptimisationLanguage.g:2240:2: ( rule__OptimisationModelRule__ProblemAssignment_4 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==50) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalOptimisationLanguage.g:2240:3: rule__OptimisationModelRule__ProblemAssignment_4
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
    // InternalOptimisationLanguage.g:2248:1: rule__OptimisationModelRule__Group__5 : rule__OptimisationModelRule__Group__5__Impl rule__OptimisationModelRule__Group__6 ;
    public final void rule__OptimisationModelRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2252:1: ( rule__OptimisationModelRule__Group__5__Impl rule__OptimisationModelRule__Group__6 )
            // InternalOptimisationLanguage.g:2253:2: rule__OptimisationModelRule__Group__5__Impl rule__OptimisationModelRule__Group__6
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
    // InternalOptimisationLanguage.g:2260:1: rule__OptimisationModelRule__Group__5__Impl : ( ( rule__OptimisationModelRule__AlgorithmAssignment_5 )? ) ;
    public final void rule__OptimisationModelRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2264:1: ( ( ( rule__OptimisationModelRule__AlgorithmAssignment_5 )? ) )
            // InternalOptimisationLanguage.g:2265:1: ( ( rule__OptimisationModelRule__AlgorithmAssignment_5 )? )
            {
            // InternalOptimisationLanguage.g:2265:1: ( ( rule__OptimisationModelRule__AlgorithmAssignment_5 )? )
            // InternalOptimisationLanguage.g:2266:2: ( rule__OptimisationModelRule__AlgorithmAssignment_5 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOptimisationModelRuleAccess().getAlgorithmAssignment_5()); 
            }
            // InternalOptimisationLanguage.g:2267:2: ( rule__OptimisationModelRule__AlgorithmAssignment_5 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==63) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalOptimisationLanguage.g:2267:3: rule__OptimisationModelRule__AlgorithmAssignment_5
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
    // InternalOptimisationLanguage.g:2275:1: rule__OptimisationModelRule__Group__6 : rule__OptimisationModelRule__Group__6__Impl ;
    public final void rule__OptimisationModelRule__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2279:1: ( rule__OptimisationModelRule__Group__6__Impl )
            // InternalOptimisationLanguage.g:2280:2: rule__OptimisationModelRule__Group__6__Impl
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
    // InternalOptimisationLanguage.g:2286:1: rule__OptimisationModelRule__Group__6__Impl : ( '}' ) ;
    public final void rule__OptimisationModelRule__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2290:1: ( ( '}' ) )
            // InternalOptimisationLanguage.g:2291:1: ( '}' )
            {
            // InternalOptimisationLanguage.g:2291:1: ( '}' )
            // InternalOptimisationLanguage.g:2292:2: '}'
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
    // InternalOptimisationLanguage.g:2302:1: rule__ProblemRule__Group__0 : rule__ProblemRule__Group__0__Impl rule__ProblemRule__Group__1 ;
    public final void rule__ProblemRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2306:1: ( rule__ProblemRule__Group__0__Impl rule__ProblemRule__Group__1 )
            // InternalOptimisationLanguage.g:2307:2: rule__ProblemRule__Group__0__Impl rule__ProblemRule__Group__1
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
    // InternalOptimisationLanguage.g:2314:1: rule__ProblemRule__Group__0__Impl : ( 'specify' ) ;
    public final void rule__ProblemRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2318:1: ( ( 'specify' ) )
            // InternalOptimisationLanguage.g:2319:1: ( 'specify' )
            {
            // InternalOptimisationLanguage.g:2319:1: ( 'specify' )
            // InternalOptimisationLanguage.g:2320:2: 'specify'
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
    // InternalOptimisationLanguage.g:2329:1: rule__ProblemRule__Group__1 : rule__ProblemRule__Group__1__Impl rule__ProblemRule__Group__2 ;
    public final void rule__ProblemRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2333:1: ( rule__ProblemRule__Group__1__Impl rule__ProblemRule__Group__2 )
            // InternalOptimisationLanguage.g:2334:2: rule__ProblemRule__Group__1__Impl rule__ProblemRule__Group__2
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
    // InternalOptimisationLanguage.g:2341:1: rule__ProblemRule__Group__1__Impl : ( ( rule__ProblemRule__DefinitionAssignment_1 ) ) ;
    public final void rule__ProblemRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2345:1: ( ( ( rule__ProblemRule__DefinitionAssignment_1 ) ) )
            // InternalOptimisationLanguage.g:2346:1: ( ( rule__ProblemRule__DefinitionAssignment_1 ) )
            {
            // InternalOptimisationLanguage.g:2346:1: ( ( rule__ProblemRule__DefinitionAssignment_1 ) )
            // InternalOptimisationLanguage.g:2347:2: ( rule__ProblemRule__DefinitionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProblemRuleAccess().getDefinitionAssignment_1()); 
            }
            // InternalOptimisationLanguage.g:2348:2: ( rule__ProblemRule__DefinitionAssignment_1 )
            // InternalOptimisationLanguage.g:2348:3: rule__ProblemRule__DefinitionAssignment_1
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
    // InternalOptimisationLanguage.g:2356:1: rule__ProblemRule__Group__2 : rule__ProblemRule__Group__2__Impl rule__ProblemRule__Group__3 ;
    public final void rule__ProblemRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2360:1: ( rule__ProblemRule__Group__2__Impl rule__ProblemRule__Group__3 )
            // InternalOptimisationLanguage.g:2361:2: rule__ProblemRule__Group__2__Impl rule__ProblemRule__Group__3
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
    // InternalOptimisationLanguage.g:2368:1: rule__ProblemRule__Group__2__Impl : ( ( rule__ProblemRule__NameAssignment_2 ) ) ;
    public final void rule__ProblemRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2372:1: ( ( ( rule__ProblemRule__NameAssignment_2 ) ) )
            // InternalOptimisationLanguage.g:2373:1: ( ( rule__ProblemRule__NameAssignment_2 ) )
            {
            // InternalOptimisationLanguage.g:2373:1: ( ( rule__ProblemRule__NameAssignment_2 ) )
            // InternalOptimisationLanguage.g:2374:2: ( rule__ProblemRule__NameAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProblemRuleAccess().getNameAssignment_2()); 
            }
            // InternalOptimisationLanguage.g:2375:2: ( rule__ProblemRule__NameAssignment_2 )
            // InternalOptimisationLanguage.g:2375:3: rule__ProblemRule__NameAssignment_2
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
    // InternalOptimisationLanguage.g:2383:1: rule__ProblemRule__Group__3 : rule__ProblemRule__Group__3__Impl rule__ProblemRule__Group__4 ;
    public final void rule__ProblemRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2387:1: ( rule__ProblemRule__Group__3__Impl rule__ProblemRule__Group__4 )
            // InternalOptimisationLanguage.g:2388:2: rule__ProblemRule__Group__3__Impl rule__ProblemRule__Group__4
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
    // InternalOptimisationLanguage.g:2395:1: rule__ProblemRule__Group__3__Impl : ( '{' ) ;
    public final void rule__ProblemRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2399:1: ( ( '{' ) )
            // InternalOptimisationLanguage.g:2400:1: ( '{' )
            {
            // InternalOptimisationLanguage.g:2400:1: ( '{' )
            // InternalOptimisationLanguage.g:2401:2: '{'
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
    // InternalOptimisationLanguage.g:2410:1: rule__ProblemRule__Group__4 : rule__ProblemRule__Group__4__Impl rule__ProblemRule__Group__5 ;
    public final void rule__ProblemRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2414:1: ( rule__ProblemRule__Group__4__Impl rule__ProblemRule__Group__5 )
            // InternalOptimisationLanguage.g:2415:2: rule__ProblemRule__Group__4__Impl rule__ProblemRule__Group__5
            {
            pushFollow(FOLLOW_9);
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
    // InternalOptimisationLanguage.g:2422:1: rule__ProblemRule__Group__4__Impl : ( 'search' ) ;
    public final void rule__ProblemRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2426:1: ( ( 'search' ) )
            // InternalOptimisationLanguage.g:2427:1: ( 'search' )
            {
            // InternalOptimisationLanguage.g:2427:1: ( 'search' )
            // InternalOptimisationLanguage.g:2428:2: 'search'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProblemRuleAccess().getSearchKeyword_4()); 
            }
            match(input,51,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getProblemRuleAccess().getSearchKeyword_4()); 
            }

            }


            }

        }
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
    // InternalOptimisationLanguage.g:2437:1: rule__ProblemRule__Group__5 : rule__ProblemRule__Group__5__Impl rule__ProblemRule__Group__6 ;
    public final void rule__ProblemRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2441:1: ( rule__ProblemRule__Group__5__Impl rule__ProblemRule__Group__6 )
            // InternalOptimisationLanguage.g:2442:2: rule__ProblemRule__Group__5__Impl rule__ProblemRule__Group__6
            {
            pushFollow(FOLLOW_10);
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
    // InternalOptimisationLanguage.g:2449:1: rule__ProblemRule__Group__5__Impl : ( 'for' ) ;
    public final void rule__ProblemRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2453:1: ( ( 'for' ) )
            // InternalOptimisationLanguage.g:2454:1: ( 'for' )
            {
            // InternalOptimisationLanguage.g:2454:1: ( 'for' )
            // InternalOptimisationLanguage.g:2455:2: 'for'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProblemRuleAccess().getForKeyword_5()); 
            }
            match(input,52,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getProblemRuleAccess().getForKeyword_5()); 
            }

            }


            }

        }
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
    // InternalOptimisationLanguage.g:2464:1: rule__ProblemRule__Group__6 : rule__ProblemRule__Group__6__Impl rule__ProblemRule__Group__7 ;
    public final void rule__ProblemRule__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2468:1: ( rule__ProblemRule__Group__6__Impl rule__ProblemRule__Group__7 )
            // InternalOptimisationLanguage.g:2469:2: rule__ProblemRule__Group__6__Impl rule__ProblemRule__Group__7
            {
            pushFollow(FOLLOW_11);
            rule__ProblemRule__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ProblemRule__Group__7();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalOptimisationLanguage.g:2476:1: rule__ProblemRule__Group__6__Impl : ( ( rule__ProblemRule__SearchSpaceAssignment_6 ) ) ;
    public final void rule__ProblemRule__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2480:1: ( ( ( rule__ProblemRule__SearchSpaceAssignment_6 ) ) )
            // InternalOptimisationLanguage.g:2481:1: ( ( rule__ProblemRule__SearchSpaceAssignment_6 ) )
            {
            // InternalOptimisationLanguage.g:2481:1: ( ( rule__ProblemRule__SearchSpaceAssignment_6 ) )
            // InternalOptimisationLanguage.g:2482:2: ( rule__ProblemRule__SearchSpaceAssignment_6 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProblemRuleAccess().getSearchSpaceAssignment_6()); 
            }
            // InternalOptimisationLanguage.g:2483:2: ( rule__ProblemRule__SearchSpaceAssignment_6 )
            // InternalOptimisationLanguage.g:2483:3: rule__ProblemRule__SearchSpaceAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__ProblemRule__SearchSpaceAssignment_6();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getProblemRuleAccess().getSearchSpaceAssignment_6()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__ProblemRule__Group__7"
    // InternalOptimisationLanguage.g:2491:1: rule__ProblemRule__Group__7 : rule__ProblemRule__Group__7__Impl rule__ProblemRule__Group__8 ;
    public final void rule__ProblemRule__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2495:1: ( rule__ProblemRule__Group__7__Impl rule__ProblemRule__Group__8 )
            // InternalOptimisationLanguage.g:2496:2: rule__ProblemRule__Group__7__Impl rule__ProblemRule__Group__8
            {
            pushFollow(FOLLOW_11);
            rule__ProblemRule__Group__7__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ProblemRule__Group__8();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemRule__Group__7"


    // $ANTLR start "rule__ProblemRule__Group__7__Impl"
    // InternalOptimisationLanguage.g:2503:1: rule__ProblemRule__Group__7__Impl : ( ( rule__ProblemRule__Group_7__0 )* ) ;
    public final void rule__ProblemRule__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2507:1: ( ( ( rule__ProblemRule__Group_7__0 )* ) )
            // InternalOptimisationLanguage.g:2508:1: ( ( rule__ProblemRule__Group_7__0 )* )
            {
            // InternalOptimisationLanguage.g:2508:1: ( ( rule__ProblemRule__Group_7__0 )* )
            // InternalOptimisationLanguage.g:2509:2: ( rule__ProblemRule__Group_7__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProblemRuleAccess().getGroup_7()); 
            }
            // InternalOptimisationLanguage.g:2510:2: ( rule__ProblemRule__Group_7__0 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==56) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:2510:3: rule__ProblemRule__Group_7__0
            	    {
            	    pushFollow(FOLLOW_12);
            	    rule__ProblemRule__Group_7__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getProblemRuleAccess().getGroup_7()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemRule__Group__7__Impl"


    // $ANTLR start "rule__ProblemRule__Group__8"
    // InternalOptimisationLanguage.g:2518:1: rule__ProblemRule__Group__8 : rule__ProblemRule__Group__8__Impl rule__ProblemRule__Group__9 ;
    public final void rule__ProblemRule__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2522:1: ( rule__ProblemRule__Group__8__Impl rule__ProblemRule__Group__9 )
            // InternalOptimisationLanguage.g:2523:2: rule__ProblemRule__Group__8__Impl rule__ProblemRule__Group__9
            {
            pushFollow(FOLLOW_13);
            rule__ProblemRule__Group__8__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ProblemRule__Group__9();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemRule__Group__8"


    // $ANTLR start "rule__ProblemRule__Group__8__Impl"
    // InternalOptimisationLanguage.g:2530:1: rule__ProblemRule__Group__8__Impl : ( 'map' ) ;
    public final void rule__ProblemRule__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2534:1: ( ( 'map' ) )
            // InternalOptimisationLanguage.g:2535:1: ( 'map' )
            {
            // InternalOptimisationLanguage.g:2535:1: ( 'map' )
            // InternalOptimisationLanguage.g:2536:2: 'map'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProblemRuleAccess().getMapKeyword_8()); 
            }
            match(input,53,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getProblemRuleAccess().getMapKeyword_8()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemRule__Group__8__Impl"


    // $ANTLR start "rule__ProblemRule__Group__9"
    // InternalOptimisationLanguage.g:2545:1: rule__ProblemRule__Group__9 : rule__ProblemRule__Group__9__Impl rule__ProblemRule__Group__10 ;
    public final void rule__ProblemRule__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2549:1: ( rule__ProblemRule__Group__9__Impl rule__ProblemRule__Group__10 )
            // InternalOptimisationLanguage.g:2550:2: rule__ProblemRule__Group__9__Impl rule__ProblemRule__Group__10
            {
            pushFollow(FOLLOW_5);
            rule__ProblemRule__Group__9__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ProblemRule__Group__10();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemRule__Group__9"


    // $ANTLR start "rule__ProblemRule__Group__9__Impl"
    // InternalOptimisationLanguage.g:2557:1: rule__ProblemRule__Group__9__Impl : ( 'with' ) ;
    public final void rule__ProblemRule__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2561:1: ( ( 'with' ) )
            // InternalOptimisationLanguage.g:2562:1: ( 'with' )
            {
            // InternalOptimisationLanguage.g:2562:1: ( 'with' )
            // InternalOptimisationLanguage.g:2563:2: 'with'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProblemRuleAccess().getWithKeyword_9()); 
            }
            match(input,54,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getProblemRuleAccess().getWithKeyword_9()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemRule__Group__9__Impl"


    // $ANTLR start "rule__ProblemRule__Group__10"
    // InternalOptimisationLanguage.g:2572:1: rule__ProblemRule__Group__10 : rule__ProblemRule__Group__10__Impl rule__ProblemRule__Group__11 ;
    public final void rule__ProblemRule__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2576:1: ( rule__ProblemRule__Group__10__Impl rule__ProblemRule__Group__11 )
            // InternalOptimisationLanguage.g:2577:2: rule__ProblemRule__Group__10__Impl rule__ProblemRule__Group__11
            {
            pushFollow(FOLLOW_14);
            rule__ProblemRule__Group__10__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ProblemRule__Group__11();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemRule__Group__10"


    // $ANTLR start "rule__ProblemRule__Group__10__Impl"
    // InternalOptimisationLanguage.g:2584:1: rule__ProblemRule__Group__10__Impl : ( ( rule__ProblemRule__OptimisationFunctionAssignment_10 ) ) ;
    public final void rule__ProblemRule__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2588:1: ( ( ( rule__ProblemRule__OptimisationFunctionAssignment_10 ) ) )
            // InternalOptimisationLanguage.g:2589:1: ( ( rule__ProblemRule__OptimisationFunctionAssignment_10 ) )
            {
            // InternalOptimisationLanguage.g:2589:1: ( ( rule__ProblemRule__OptimisationFunctionAssignment_10 ) )
            // InternalOptimisationLanguage.g:2590:2: ( rule__ProblemRule__OptimisationFunctionAssignment_10 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProblemRuleAccess().getOptimisationFunctionAssignment_10()); 
            }
            // InternalOptimisationLanguage.g:2591:2: ( rule__ProblemRule__OptimisationFunctionAssignment_10 )
            // InternalOptimisationLanguage.g:2591:3: rule__ProblemRule__OptimisationFunctionAssignment_10
            {
            pushFollow(FOLLOW_2);
            rule__ProblemRule__OptimisationFunctionAssignment_10();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getProblemRuleAccess().getOptimisationFunctionAssignment_10()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemRule__Group__10__Impl"


    // $ANTLR start "rule__ProblemRule__Group__11"
    // InternalOptimisationLanguage.g:2599:1: rule__ProblemRule__Group__11 : rule__ProblemRule__Group__11__Impl rule__ProblemRule__Group__12 ;
    public final void rule__ProblemRule__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2603:1: ( rule__ProblemRule__Group__11__Impl rule__ProblemRule__Group__12 )
            // InternalOptimisationLanguage.g:2604:2: rule__ProblemRule__Group__11__Impl rule__ProblemRule__Group__12
            {
            pushFollow(FOLLOW_15);
            rule__ProblemRule__Group__11__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ProblemRule__Group__12();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemRule__Group__11"


    // $ANTLR start "rule__ProblemRule__Group__11__Impl"
    // InternalOptimisationLanguage.g:2611:1: rule__ProblemRule__Group__11__Impl : ( 'and' ) ;
    public final void rule__ProblemRule__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2615:1: ( ( 'and' ) )
            // InternalOptimisationLanguage.g:2616:1: ( 'and' )
            {
            // InternalOptimisationLanguage.g:2616:1: ( 'and' )
            // InternalOptimisationLanguage.g:2617:2: 'and'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProblemRuleAccess().getAndKeyword_11()); 
            }
            match(input,55,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getProblemRuleAccess().getAndKeyword_11()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemRule__Group__11__Impl"


    // $ANTLR start "rule__ProblemRule__Group__12"
    // InternalOptimisationLanguage.g:2626:1: rule__ProblemRule__Group__12 : rule__ProblemRule__Group__12__Impl rule__ProblemRule__Group__13 ;
    public final void rule__ProblemRule__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2630:1: ( rule__ProblemRule__Group__12__Impl rule__ProblemRule__Group__13 )
            // InternalOptimisationLanguage.g:2631:2: rule__ProblemRule__Group__12__Impl rule__ProblemRule__Group__13
            {
            pushFollow(FOLLOW_16);
            rule__ProblemRule__Group__12__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ProblemRule__Group__13();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemRule__Group__12"


    // $ANTLR start "rule__ProblemRule__Group__12__Impl"
    // InternalOptimisationLanguage.g:2638:1: rule__ProblemRule__Group__12__Impl : ( ( rule__ProblemRule__OptimisationSpaceAssignment_12 ) ) ;
    public final void rule__ProblemRule__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2642:1: ( ( ( rule__ProblemRule__OptimisationSpaceAssignment_12 ) ) )
            // InternalOptimisationLanguage.g:2643:1: ( ( rule__ProblemRule__OptimisationSpaceAssignment_12 ) )
            {
            // InternalOptimisationLanguage.g:2643:1: ( ( rule__ProblemRule__OptimisationSpaceAssignment_12 ) )
            // InternalOptimisationLanguage.g:2644:2: ( rule__ProblemRule__OptimisationSpaceAssignment_12 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProblemRuleAccess().getOptimisationSpaceAssignment_12()); 
            }
            // InternalOptimisationLanguage.g:2645:2: ( rule__ProblemRule__OptimisationSpaceAssignment_12 )
            // InternalOptimisationLanguage.g:2645:3: rule__ProblemRule__OptimisationSpaceAssignment_12
            {
            pushFollow(FOLLOW_2);
            rule__ProblemRule__OptimisationSpaceAssignment_12();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getProblemRuleAccess().getOptimisationSpaceAssignment_12()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemRule__Group__12__Impl"


    // $ANTLR start "rule__ProblemRule__Group__13"
    // InternalOptimisationLanguage.g:2653:1: rule__ProblemRule__Group__13 : rule__ProblemRule__Group__13__Impl rule__ProblemRule__Group__14 ;
    public final void rule__ProblemRule__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2657:1: ( rule__ProblemRule__Group__13__Impl rule__ProblemRule__Group__14 )
            // InternalOptimisationLanguage.g:2658:2: rule__ProblemRule__Group__13__Impl rule__ProblemRule__Group__14
            {
            pushFollow(FOLLOW_16);
            rule__ProblemRule__Group__13__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ProblemRule__Group__14();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemRule__Group__13"


    // $ANTLR start "rule__ProblemRule__Group__13__Impl"
    // InternalOptimisationLanguage.g:2665:1: rule__ProblemRule__Group__13__Impl : ( ( rule__ProblemRule__Group_13__0 )* ) ;
    public final void rule__ProblemRule__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2669:1: ( ( ( rule__ProblemRule__Group_13__0 )* ) )
            // InternalOptimisationLanguage.g:2670:1: ( ( rule__ProblemRule__Group_13__0 )* )
            {
            // InternalOptimisationLanguage.g:2670:1: ( ( rule__ProblemRule__Group_13__0 )* )
            // InternalOptimisationLanguage.g:2671:2: ( rule__ProblemRule__Group_13__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProblemRuleAccess().getGroup_13()); 
            }
            // InternalOptimisationLanguage.g:2672:2: ( rule__ProblemRule__Group_13__0 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==56) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:2672:3: rule__ProblemRule__Group_13__0
            	    {
            	    pushFollow(FOLLOW_12);
            	    rule__ProblemRule__Group_13__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getProblemRuleAccess().getGroup_13()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemRule__Group__13__Impl"


    // $ANTLR start "rule__ProblemRule__Group__14"
    // InternalOptimisationLanguage.g:2680:1: rule__ProblemRule__Group__14 : rule__ProblemRule__Group__14__Impl rule__ProblemRule__Group__15 ;
    public final void rule__ProblemRule__Group__14() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2684:1: ( rule__ProblemRule__Group__14__Impl rule__ProblemRule__Group__15 )
            // InternalOptimisationLanguage.g:2685:2: rule__ProblemRule__Group__14__Impl rule__ProblemRule__Group__15
            {
            pushFollow(FOLLOW_16);
            rule__ProblemRule__Group__14__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ProblemRule__Group__15();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemRule__Group__14"


    // $ANTLR start "rule__ProblemRule__Group__14__Impl"
    // InternalOptimisationLanguage.g:2692:1: rule__ProblemRule__Group__14__Impl : ( ( rule__ProblemRule__Group_14__0 )? ) ;
    public final void rule__ProblemRule__Group__14__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2696:1: ( ( ( rule__ProblemRule__Group_14__0 )? ) )
            // InternalOptimisationLanguage.g:2697:1: ( ( rule__ProblemRule__Group_14__0 )? )
            {
            // InternalOptimisationLanguage.g:2697:1: ( ( rule__ProblemRule__Group_14__0 )? )
            // InternalOptimisationLanguage.g:2698:2: ( rule__ProblemRule__Group_14__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProblemRuleAccess().getGroup_14()); 
            }
            // InternalOptimisationLanguage.g:2699:2: ( rule__ProblemRule__Group_14__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==57) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalOptimisationLanguage.g:2699:3: rule__ProblemRule__Group_14__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ProblemRule__Group_14__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getProblemRuleAccess().getGroup_14()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemRule__Group__14__Impl"


    // $ANTLR start "rule__ProblemRule__Group__15"
    // InternalOptimisationLanguage.g:2707:1: rule__ProblemRule__Group__15 : rule__ProblemRule__Group__15__Impl ;
    public final void rule__ProblemRule__Group__15() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2711:1: ( rule__ProblemRule__Group__15__Impl )
            // InternalOptimisationLanguage.g:2712:2: rule__ProblemRule__Group__15__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ProblemRule__Group__15__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemRule__Group__15"


    // $ANTLR start "rule__ProblemRule__Group__15__Impl"
    // InternalOptimisationLanguage.g:2718:1: rule__ProblemRule__Group__15__Impl : ( '}' ) ;
    public final void rule__ProblemRule__Group__15__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2722:1: ( ( '}' ) )
            // InternalOptimisationLanguage.g:2723:1: ( '}' )
            {
            // InternalOptimisationLanguage.g:2723:1: ( '}' )
            // InternalOptimisationLanguage.g:2724:2: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProblemRuleAccess().getRightCurlyBracketKeyword_15()); 
            }
            match(input,49,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getProblemRuleAccess().getRightCurlyBracketKeyword_15()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemRule__Group__15__Impl"


    // $ANTLR start "rule__ProblemRule__Group_7__0"
    // InternalOptimisationLanguage.g:2734:1: rule__ProblemRule__Group_7__0 : rule__ProblemRule__Group_7__0__Impl rule__ProblemRule__Group_7__1 ;
    public final void rule__ProblemRule__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2738:1: ( rule__ProblemRule__Group_7__0__Impl rule__ProblemRule__Group_7__1 )
            // InternalOptimisationLanguage.g:2739:2: rule__ProblemRule__Group_7__0__Impl rule__ProblemRule__Group_7__1
            {
            pushFollow(FOLLOW_10);
            rule__ProblemRule__Group_7__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ProblemRule__Group_7__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemRule__Group_7__0"


    // $ANTLR start "rule__ProblemRule__Group_7__0__Impl"
    // InternalOptimisationLanguage.g:2746:1: rule__ProblemRule__Group_7__0__Impl : ( ',' ) ;
    public final void rule__ProblemRule__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2750:1: ( ( ',' ) )
            // InternalOptimisationLanguage.g:2751:1: ( ',' )
            {
            // InternalOptimisationLanguage.g:2751:1: ( ',' )
            // InternalOptimisationLanguage.g:2752:2: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProblemRuleAccess().getCommaKeyword_7_0()); 
            }
            match(input,56,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getProblemRuleAccess().getCommaKeyword_7_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemRule__Group_7__0__Impl"


    // $ANTLR start "rule__ProblemRule__Group_7__1"
    // InternalOptimisationLanguage.g:2761:1: rule__ProblemRule__Group_7__1 : rule__ProblemRule__Group_7__1__Impl ;
    public final void rule__ProblemRule__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2765:1: ( rule__ProblemRule__Group_7__1__Impl )
            // InternalOptimisationLanguage.g:2766:2: rule__ProblemRule__Group_7__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ProblemRule__Group_7__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemRule__Group_7__1"


    // $ANTLR start "rule__ProblemRule__Group_7__1__Impl"
    // InternalOptimisationLanguage.g:2772:1: rule__ProblemRule__Group_7__1__Impl : ( ( rule__ProblemRule__SearchSpaceAssignment_7_1 ) ) ;
    public final void rule__ProblemRule__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2776:1: ( ( ( rule__ProblemRule__SearchSpaceAssignment_7_1 ) ) )
            // InternalOptimisationLanguage.g:2777:1: ( ( rule__ProblemRule__SearchSpaceAssignment_7_1 ) )
            {
            // InternalOptimisationLanguage.g:2777:1: ( ( rule__ProblemRule__SearchSpaceAssignment_7_1 ) )
            // InternalOptimisationLanguage.g:2778:2: ( rule__ProblemRule__SearchSpaceAssignment_7_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProblemRuleAccess().getSearchSpaceAssignment_7_1()); 
            }
            // InternalOptimisationLanguage.g:2779:2: ( rule__ProblemRule__SearchSpaceAssignment_7_1 )
            // InternalOptimisationLanguage.g:2779:3: rule__ProblemRule__SearchSpaceAssignment_7_1
            {
            pushFollow(FOLLOW_2);
            rule__ProblemRule__SearchSpaceAssignment_7_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getProblemRuleAccess().getSearchSpaceAssignment_7_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemRule__Group_7__1__Impl"


    // $ANTLR start "rule__ProblemRule__Group_13__0"
    // InternalOptimisationLanguage.g:2788:1: rule__ProblemRule__Group_13__0 : rule__ProblemRule__Group_13__0__Impl rule__ProblemRule__Group_13__1 ;
    public final void rule__ProblemRule__Group_13__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2792:1: ( rule__ProblemRule__Group_13__0__Impl rule__ProblemRule__Group_13__1 )
            // InternalOptimisationLanguage.g:2793:2: rule__ProblemRule__Group_13__0__Impl rule__ProblemRule__Group_13__1
            {
            pushFollow(FOLLOW_15);
            rule__ProblemRule__Group_13__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ProblemRule__Group_13__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemRule__Group_13__0"


    // $ANTLR start "rule__ProblemRule__Group_13__0__Impl"
    // InternalOptimisationLanguage.g:2800:1: rule__ProblemRule__Group_13__0__Impl : ( ',' ) ;
    public final void rule__ProblemRule__Group_13__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2804:1: ( ( ',' ) )
            // InternalOptimisationLanguage.g:2805:1: ( ',' )
            {
            // InternalOptimisationLanguage.g:2805:1: ( ',' )
            // InternalOptimisationLanguage.g:2806:2: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProblemRuleAccess().getCommaKeyword_13_0()); 
            }
            match(input,56,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getProblemRuleAccess().getCommaKeyword_13_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemRule__Group_13__0__Impl"


    // $ANTLR start "rule__ProblemRule__Group_13__1"
    // InternalOptimisationLanguage.g:2815:1: rule__ProblemRule__Group_13__1 : rule__ProblemRule__Group_13__1__Impl ;
    public final void rule__ProblemRule__Group_13__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2819:1: ( rule__ProblemRule__Group_13__1__Impl )
            // InternalOptimisationLanguage.g:2820:2: rule__ProblemRule__Group_13__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ProblemRule__Group_13__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemRule__Group_13__1"


    // $ANTLR start "rule__ProblemRule__Group_13__1__Impl"
    // InternalOptimisationLanguage.g:2826:1: rule__ProblemRule__Group_13__1__Impl : ( ( rule__ProblemRule__OptimisationSpaceAssignment_13_1 ) ) ;
    public final void rule__ProblemRule__Group_13__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2830:1: ( ( ( rule__ProblemRule__OptimisationSpaceAssignment_13_1 ) ) )
            // InternalOptimisationLanguage.g:2831:1: ( ( rule__ProblemRule__OptimisationSpaceAssignment_13_1 ) )
            {
            // InternalOptimisationLanguage.g:2831:1: ( ( rule__ProblemRule__OptimisationSpaceAssignment_13_1 ) )
            // InternalOptimisationLanguage.g:2832:2: ( rule__ProblemRule__OptimisationSpaceAssignment_13_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProblemRuleAccess().getOptimisationSpaceAssignment_13_1()); 
            }
            // InternalOptimisationLanguage.g:2833:2: ( rule__ProblemRule__OptimisationSpaceAssignment_13_1 )
            // InternalOptimisationLanguage.g:2833:3: rule__ProblemRule__OptimisationSpaceAssignment_13_1
            {
            pushFollow(FOLLOW_2);
            rule__ProblemRule__OptimisationSpaceAssignment_13_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getProblemRuleAccess().getOptimisationSpaceAssignment_13_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemRule__Group_13__1__Impl"


    // $ANTLR start "rule__ProblemRule__Group_14__0"
    // InternalOptimisationLanguage.g:2842:1: rule__ProblemRule__Group_14__0 : rule__ProblemRule__Group_14__0__Impl rule__ProblemRule__Group_14__1 ;
    public final void rule__ProblemRule__Group_14__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2846:1: ( rule__ProblemRule__Group_14__0__Impl rule__ProblemRule__Group_14__1 )
            // InternalOptimisationLanguage.g:2847:2: rule__ProblemRule__Group_14__0__Impl rule__ProblemRule__Group_14__1
            {
            pushFollow(FOLLOW_17);
            rule__ProblemRule__Group_14__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ProblemRule__Group_14__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemRule__Group_14__0"


    // $ANTLR start "rule__ProblemRule__Group_14__0__Impl"
    // InternalOptimisationLanguage.g:2854:1: rule__ProblemRule__Group_14__0__Impl : ( 'document' ) ;
    public final void rule__ProblemRule__Group_14__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2858:1: ( ( 'document' ) )
            // InternalOptimisationLanguage.g:2859:1: ( 'document' )
            {
            // InternalOptimisationLanguage.g:2859:1: ( 'document' )
            // InternalOptimisationLanguage.g:2860:2: 'document'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProblemRuleAccess().getDocumentKeyword_14_0()); 
            }
            match(input,57,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getProblemRuleAccess().getDocumentKeyword_14_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemRule__Group_14__0__Impl"


    // $ANTLR start "rule__ProblemRule__Group_14__1"
    // InternalOptimisationLanguage.g:2869:1: rule__ProblemRule__Group_14__1 : rule__ProblemRule__Group_14__1__Impl rule__ProblemRule__Group_14__2 ;
    public final void rule__ProblemRule__Group_14__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2873:1: ( rule__ProblemRule__Group_14__1__Impl rule__ProblemRule__Group_14__2 )
            // InternalOptimisationLanguage.g:2874:2: rule__ProblemRule__Group_14__1__Impl rule__ProblemRule__Group_14__2
            {
            pushFollow(FOLLOW_18);
            rule__ProblemRule__Group_14__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ProblemRule__Group_14__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemRule__Group_14__1"


    // $ANTLR start "rule__ProblemRule__Group_14__1__Impl"
    // InternalOptimisationLanguage.g:2881:1: rule__ProblemRule__Group_14__1__Impl : ( ( rule__ProblemRule__DocumentationAssignment_14_1 ) ) ;
    public final void rule__ProblemRule__Group_14__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2885:1: ( ( ( rule__ProblemRule__DocumentationAssignment_14_1 ) ) )
            // InternalOptimisationLanguage.g:2886:1: ( ( rule__ProblemRule__DocumentationAssignment_14_1 ) )
            {
            // InternalOptimisationLanguage.g:2886:1: ( ( rule__ProblemRule__DocumentationAssignment_14_1 ) )
            // InternalOptimisationLanguage.g:2887:2: ( rule__ProblemRule__DocumentationAssignment_14_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProblemRuleAccess().getDocumentationAssignment_14_1()); 
            }
            // InternalOptimisationLanguage.g:2888:2: ( rule__ProblemRule__DocumentationAssignment_14_1 )
            // InternalOptimisationLanguage.g:2888:3: rule__ProblemRule__DocumentationAssignment_14_1
            {
            pushFollow(FOLLOW_2);
            rule__ProblemRule__DocumentationAssignment_14_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getProblemRuleAccess().getDocumentationAssignment_14_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemRule__Group_14__1__Impl"


    // $ANTLR start "rule__ProblemRule__Group_14__2"
    // InternalOptimisationLanguage.g:2896:1: rule__ProblemRule__Group_14__2 : rule__ProblemRule__Group_14__2__Impl ;
    public final void rule__ProblemRule__Group_14__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2900:1: ( rule__ProblemRule__Group_14__2__Impl )
            // InternalOptimisationLanguage.g:2901:2: rule__ProblemRule__Group_14__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ProblemRule__Group_14__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemRule__Group_14__2"


    // $ANTLR start "rule__ProblemRule__Group_14__2__Impl"
    // InternalOptimisationLanguage.g:2907:1: rule__ProblemRule__Group_14__2__Impl : ( '.' ) ;
    public final void rule__ProblemRule__Group_14__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2911:1: ( ( '.' ) )
            // InternalOptimisationLanguage.g:2912:1: ( '.' )
            {
            // InternalOptimisationLanguage.g:2912:1: ( '.' )
            // InternalOptimisationLanguage.g:2913:2: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProblemRuleAccess().getFullStopKeyword_14_2()); 
            }
            match(input,58,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getProblemRuleAccess().getFullStopKeyword_14_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemRule__Group_14__2__Impl"


    // $ANTLR start "rule__MaximiseGoalRule__Group__0"
    // InternalOptimisationLanguage.g:2923:1: rule__MaximiseGoalRule__Group__0 : rule__MaximiseGoalRule__Group__0__Impl rule__MaximiseGoalRule__Group__1 ;
    public final void rule__MaximiseGoalRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2927:1: ( rule__MaximiseGoalRule__Group__0__Impl rule__MaximiseGoalRule__Group__1 )
            // InternalOptimisationLanguage.g:2928:2: rule__MaximiseGoalRule__Group__0__Impl rule__MaximiseGoalRule__Group__1
            {
            pushFollow(FOLLOW_10);
            rule__MaximiseGoalRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__MaximiseGoalRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MaximiseGoalRule__Group__0"


    // $ANTLR start "rule__MaximiseGoalRule__Group__0__Impl"
    // InternalOptimisationLanguage.g:2935:1: rule__MaximiseGoalRule__Group__0__Impl : ( 'maximise' ) ;
    public final void rule__MaximiseGoalRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2939:1: ( ( 'maximise' ) )
            // InternalOptimisationLanguage.g:2940:1: ( 'maximise' )
            {
            // InternalOptimisationLanguage.g:2940:1: ( 'maximise' )
            // InternalOptimisationLanguage.g:2941:2: 'maximise'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMaximiseGoalRuleAccess().getMaximiseKeyword_0()); 
            }
            match(input,59,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMaximiseGoalRuleAccess().getMaximiseKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MaximiseGoalRule__Group__0__Impl"


    // $ANTLR start "rule__MaximiseGoalRule__Group__1"
    // InternalOptimisationLanguage.g:2950:1: rule__MaximiseGoalRule__Group__1 : rule__MaximiseGoalRule__Group__1__Impl ;
    public final void rule__MaximiseGoalRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2954:1: ( rule__MaximiseGoalRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:2955:2: rule__MaximiseGoalRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MaximiseGoalRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MaximiseGoalRule__Group__1"


    // $ANTLR start "rule__MaximiseGoalRule__Group__1__Impl"
    // InternalOptimisationLanguage.g:2961:1: rule__MaximiseGoalRule__Group__1__Impl : ( ( rule__MaximiseGoalRule__DataAssignment_1 ) ) ;
    public final void rule__MaximiseGoalRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2965:1: ( ( ( rule__MaximiseGoalRule__DataAssignment_1 ) ) )
            // InternalOptimisationLanguage.g:2966:1: ( ( rule__MaximiseGoalRule__DataAssignment_1 ) )
            {
            // InternalOptimisationLanguage.g:2966:1: ( ( rule__MaximiseGoalRule__DataAssignment_1 ) )
            // InternalOptimisationLanguage.g:2967:2: ( rule__MaximiseGoalRule__DataAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMaximiseGoalRuleAccess().getDataAssignment_1()); 
            }
            // InternalOptimisationLanguage.g:2968:2: ( rule__MaximiseGoalRule__DataAssignment_1 )
            // InternalOptimisationLanguage.g:2968:3: rule__MaximiseGoalRule__DataAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__MaximiseGoalRule__DataAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMaximiseGoalRuleAccess().getDataAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MaximiseGoalRule__Group__1__Impl"


    // $ANTLR start "rule__MinimiseGoalRule__Group__0"
    // InternalOptimisationLanguage.g:2977:1: rule__MinimiseGoalRule__Group__0 : rule__MinimiseGoalRule__Group__0__Impl rule__MinimiseGoalRule__Group__1 ;
    public final void rule__MinimiseGoalRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2981:1: ( rule__MinimiseGoalRule__Group__0__Impl rule__MinimiseGoalRule__Group__1 )
            // InternalOptimisationLanguage.g:2982:2: rule__MinimiseGoalRule__Group__0__Impl rule__MinimiseGoalRule__Group__1
            {
            pushFollow(FOLLOW_10);
            rule__MinimiseGoalRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__MinimiseGoalRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MinimiseGoalRule__Group__0"


    // $ANTLR start "rule__MinimiseGoalRule__Group__0__Impl"
    // InternalOptimisationLanguage.g:2989:1: rule__MinimiseGoalRule__Group__0__Impl : ( 'minimise' ) ;
    public final void rule__MinimiseGoalRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2993:1: ( ( 'minimise' ) )
            // InternalOptimisationLanguage.g:2994:1: ( 'minimise' )
            {
            // InternalOptimisationLanguage.g:2994:1: ( 'minimise' )
            // InternalOptimisationLanguage.g:2995:2: 'minimise'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMinimiseGoalRuleAccess().getMinimiseKeyword_0()); 
            }
            match(input,60,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMinimiseGoalRuleAccess().getMinimiseKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MinimiseGoalRule__Group__0__Impl"


    // $ANTLR start "rule__MinimiseGoalRule__Group__1"
    // InternalOptimisationLanguage.g:3004:1: rule__MinimiseGoalRule__Group__1 : rule__MinimiseGoalRule__Group__1__Impl ;
    public final void rule__MinimiseGoalRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3008:1: ( rule__MinimiseGoalRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:3009:2: rule__MinimiseGoalRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MinimiseGoalRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MinimiseGoalRule__Group__1"


    // $ANTLR start "rule__MinimiseGoalRule__Group__1__Impl"
    // InternalOptimisationLanguage.g:3015:1: rule__MinimiseGoalRule__Group__1__Impl : ( ( rule__MinimiseGoalRule__DataAssignment_1 ) ) ;
    public final void rule__MinimiseGoalRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3019:1: ( ( ( rule__MinimiseGoalRule__DataAssignment_1 ) ) )
            // InternalOptimisationLanguage.g:3020:1: ( ( rule__MinimiseGoalRule__DataAssignment_1 ) )
            {
            // InternalOptimisationLanguage.g:3020:1: ( ( rule__MinimiseGoalRule__DataAssignment_1 ) )
            // InternalOptimisationLanguage.g:3021:2: ( rule__MinimiseGoalRule__DataAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMinimiseGoalRuleAccess().getDataAssignment_1()); 
            }
            // InternalOptimisationLanguage.g:3022:2: ( rule__MinimiseGoalRule__DataAssignment_1 )
            // InternalOptimisationLanguage.g:3022:3: rule__MinimiseGoalRule__DataAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__MinimiseGoalRule__DataAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMinimiseGoalRuleAccess().getDataAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MinimiseGoalRule__Group__1__Impl"


    // $ANTLR start "rule__TargetGoalRule__Group__0"
    // InternalOptimisationLanguage.g:3031:1: rule__TargetGoalRule__Group__0 : rule__TargetGoalRule__Group__0__Impl rule__TargetGoalRule__Group__1 ;
    public final void rule__TargetGoalRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3035:1: ( rule__TargetGoalRule__Group__0__Impl rule__TargetGoalRule__Group__1 )
            // InternalOptimisationLanguage.g:3036:2: rule__TargetGoalRule__Group__0__Impl rule__TargetGoalRule__Group__1
            {
            pushFollow(FOLLOW_10);
            rule__TargetGoalRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TargetGoalRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TargetGoalRule__Group__0"


    // $ANTLR start "rule__TargetGoalRule__Group__0__Impl"
    // InternalOptimisationLanguage.g:3043:1: rule__TargetGoalRule__Group__0__Impl : ( 'optimise' ) ;
    public final void rule__TargetGoalRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3047:1: ( ( 'optimise' ) )
            // InternalOptimisationLanguage.g:3048:1: ( 'optimise' )
            {
            // InternalOptimisationLanguage.g:3048:1: ( 'optimise' )
            // InternalOptimisationLanguage.g:3049:2: 'optimise'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTargetGoalRuleAccess().getOptimiseKeyword_0()); 
            }
            match(input,61,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTargetGoalRuleAccess().getOptimiseKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TargetGoalRule__Group__0__Impl"


    // $ANTLR start "rule__TargetGoalRule__Group__1"
    // InternalOptimisationLanguage.g:3058:1: rule__TargetGoalRule__Group__1 : rule__TargetGoalRule__Group__1__Impl rule__TargetGoalRule__Group__2 ;
    public final void rule__TargetGoalRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3062:1: ( rule__TargetGoalRule__Group__1__Impl rule__TargetGoalRule__Group__2 )
            // InternalOptimisationLanguage.g:3063:2: rule__TargetGoalRule__Group__1__Impl rule__TargetGoalRule__Group__2
            {
            pushFollow(FOLLOW_19);
            rule__TargetGoalRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TargetGoalRule__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TargetGoalRule__Group__1"


    // $ANTLR start "rule__TargetGoalRule__Group__1__Impl"
    // InternalOptimisationLanguage.g:3070:1: rule__TargetGoalRule__Group__1__Impl : ( ( rule__TargetGoalRule__DataAssignment_1 ) ) ;
    public final void rule__TargetGoalRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3074:1: ( ( ( rule__TargetGoalRule__DataAssignment_1 ) ) )
            // InternalOptimisationLanguage.g:3075:1: ( ( rule__TargetGoalRule__DataAssignment_1 ) )
            {
            // InternalOptimisationLanguage.g:3075:1: ( ( rule__TargetGoalRule__DataAssignment_1 ) )
            // InternalOptimisationLanguage.g:3076:2: ( rule__TargetGoalRule__DataAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTargetGoalRuleAccess().getDataAssignment_1()); 
            }
            // InternalOptimisationLanguage.g:3077:2: ( rule__TargetGoalRule__DataAssignment_1 )
            // InternalOptimisationLanguage.g:3077:3: rule__TargetGoalRule__DataAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__TargetGoalRule__DataAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTargetGoalRuleAccess().getDataAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TargetGoalRule__Group__1__Impl"


    // $ANTLR start "rule__TargetGoalRule__Group__2"
    // InternalOptimisationLanguage.g:3085:1: rule__TargetGoalRule__Group__2 : rule__TargetGoalRule__Group__2__Impl rule__TargetGoalRule__Group__3 ;
    public final void rule__TargetGoalRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3089:1: ( rule__TargetGoalRule__Group__2__Impl rule__TargetGoalRule__Group__3 )
            // InternalOptimisationLanguage.g:3090:2: rule__TargetGoalRule__Group__2__Impl rule__TargetGoalRule__Group__3
            {
            pushFollow(FOLLOW_20);
            rule__TargetGoalRule__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TargetGoalRule__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TargetGoalRule__Group__2"


    // $ANTLR start "rule__TargetGoalRule__Group__2__Impl"
    // InternalOptimisationLanguage.g:3097:1: rule__TargetGoalRule__Group__2__Impl : ( 'towards' ) ;
    public final void rule__TargetGoalRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3101:1: ( ( 'towards' ) )
            // InternalOptimisationLanguage.g:3102:1: ( 'towards' )
            {
            // InternalOptimisationLanguage.g:3102:1: ( 'towards' )
            // InternalOptimisationLanguage.g:3103:2: 'towards'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTargetGoalRuleAccess().getTowardsKeyword_2()); 
            }
            match(input,62,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTargetGoalRuleAccess().getTowardsKeyword_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TargetGoalRule__Group__2__Impl"


    // $ANTLR start "rule__TargetGoalRule__Group__3"
    // InternalOptimisationLanguage.g:3112:1: rule__TargetGoalRule__Group__3 : rule__TargetGoalRule__Group__3__Impl rule__TargetGoalRule__Group__4 ;
    public final void rule__TargetGoalRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3116:1: ( rule__TargetGoalRule__Group__3__Impl rule__TargetGoalRule__Group__4 )
            // InternalOptimisationLanguage.g:3117:2: rule__TargetGoalRule__Group__3__Impl rule__TargetGoalRule__Group__4
            {
            pushFollow(FOLLOW_13);
            rule__TargetGoalRule__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TargetGoalRule__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TargetGoalRule__Group__3"


    // $ANTLR start "rule__TargetGoalRule__Group__3__Impl"
    // InternalOptimisationLanguage.g:3124:1: rule__TargetGoalRule__Group__3__Impl : ( ( rule__TargetGoalRule__Alternatives_3 ) ) ;
    public final void rule__TargetGoalRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3128:1: ( ( ( rule__TargetGoalRule__Alternatives_3 ) ) )
            // InternalOptimisationLanguage.g:3129:1: ( ( rule__TargetGoalRule__Alternatives_3 ) )
            {
            // InternalOptimisationLanguage.g:3129:1: ( ( rule__TargetGoalRule__Alternatives_3 ) )
            // InternalOptimisationLanguage.g:3130:2: ( rule__TargetGoalRule__Alternatives_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTargetGoalRuleAccess().getAlternatives_3()); 
            }
            // InternalOptimisationLanguage.g:3131:2: ( rule__TargetGoalRule__Alternatives_3 )
            // InternalOptimisationLanguage.g:3131:3: rule__TargetGoalRule__Alternatives_3
            {
            pushFollow(FOLLOW_2);
            rule__TargetGoalRule__Alternatives_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTargetGoalRuleAccess().getAlternatives_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TargetGoalRule__Group__3__Impl"


    // $ANTLR start "rule__TargetGoalRule__Group__4"
    // InternalOptimisationLanguage.g:3139:1: rule__TargetGoalRule__Group__4 : rule__TargetGoalRule__Group__4__Impl rule__TargetGoalRule__Group__5 ;
    public final void rule__TargetGoalRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3143:1: ( rule__TargetGoalRule__Group__4__Impl rule__TargetGoalRule__Group__5 )
            // InternalOptimisationLanguage.g:3144:2: rule__TargetGoalRule__Group__4__Impl rule__TargetGoalRule__Group__5
            {
            pushFollow(FOLLOW_5);
            rule__TargetGoalRule__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TargetGoalRule__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TargetGoalRule__Group__4"


    // $ANTLR start "rule__TargetGoalRule__Group__4__Impl"
    // InternalOptimisationLanguage.g:3151:1: rule__TargetGoalRule__Group__4__Impl : ( 'with' ) ;
    public final void rule__TargetGoalRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3155:1: ( ( 'with' ) )
            // InternalOptimisationLanguage.g:3156:1: ( 'with' )
            {
            // InternalOptimisationLanguage.g:3156:1: ( 'with' )
            // InternalOptimisationLanguage.g:3157:2: 'with'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTargetGoalRuleAccess().getWithKeyword_4()); 
            }
            match(input,54,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTargetGoalRuleAccess().getWithKeyword_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TargetGoalRule__Group__4__Impl"


    // $ANTLR start "rule__TargetGoalRule__Group__5"
    // InternalOptimisationLanguage.g:3166:1: rule__TargetGoalRule__Group__5 : rule__TargetGoalRule__Group__5__Impl ;
    public final void rule__TargetGoalRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3170:1: ( rule__TargetGoalRule__Group__5__Impl )
            // InternalOptimisationLanguage.g:3171:2: rule__TargetGoalRule__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TargetGoalRule__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TargetGoalRule__Group__5"


    // $ANTLR start "rule__TargetGoalRule__Group__5__Impl"
    // InternalOptimisationLanguage.g:3177:1: rule__TargetGoalRule__Group__5__Impl : ( ( rule__TargetGoalRule__DistanceAssignment_5 ) ) ;
    public final void rule__TargetGoalRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3181:1: ( ( ( rule__TargetGoalRule__DistanceAssignment_5 ) ) )
            // InternalOptimisationLanguage.g:3182:1: ( ( rule__TargetGoalRule__DistanceAssignment_5 ) )
            {
            // InternalOptimisationLanguage.g:3182:1: ( ( rule__TargetGoalRule__DistanceAssignment_5 ) )
            // InternalOptimisationLanguage.g:3183:2: ( rule__TargetGoalRule__DistanceAssignment_5 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTargetGoalRuleAccess().getDistanceAssignment_5()); 
            }
            // InternalOptimisationLanguage.g:3184:2: ( rule__TargetGoalRule__DistanceAssignment_5 )
            // InternalOptimisationLanguage.g:3184:3: rule__TargetGoalRule__DistanceAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__TargetGoalRule__DistanceAssignment_5();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTargetGoalRuleAccess().getDistanceAssignment_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TargetGoalRule__Group__5__Impl"


    // $ANTLR start "rule__AlgorithmInstanceRule__Group__0"
    // InternalOptimisationLanguage.g:3193:1: rule__AlgorithmInstanceRule__Group__0 : rule__AlgorithmInstanceRule__Group__0__Impl rule__AlgorithmInstanceRule__Group__1 ;
    public final void rule__AlgorithmInstanceRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3197:1: ( rule__AlgorithmInstanceRule__Group__0__Impl rule__AlgorithmInstanceRule__Group__1 )
            // InternalOptimisationLanguage.g:3198:2: rule__AlgorithmInstanceRule__Group__0__Impl rule__AlgorithmInstanceRule__Group__1
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
    // InternalOptimisationLanguage.g:3205:1: rule__AlgorithmInstanceRule__Group__0__Impl : ( 'configure' ) ;
    public final void rule__AlgorithmInstanceRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3209:1: ( ( 'configure' ) )
            // InternalOptimisationLanguage.g:3210:1: ( 'configure' )
            {
            // InternalOptimisationLanguage.g:3210:1: ( 'configure' )
            // InternalOptimisationLanguage.g:3211:2: 'configure'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAlgorithmInstanceRuleAccess().getConfigureKeyword_0()); 
            }
            match(input,63,FOLLOW_2); if (state.failed) return ;
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
    // InternalOptimisationLanguage.g:3220:1: rule__AlgorithmInstanceRule__Group__1 : rule__AlgorithmInstanceRule__Group__1__Impl rule__AlgorithmInstanceRule__Group__2 ;
    public final void rule__AlgorithmInstanceRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3224:1: ( rule__AlgorithmInstanceRule__Group__1__Impl rule__AlgorithmInstanceRule__Group__2 )
            // InternalOptimisationLanguage.g:3225:2: rule__AlgorithmInstanceRule__Group__1__Impl rule__AlgorithmInstanceRule__Group__2
            {
            pushFollow(FOLLOW_9);
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
    // InternalOptimisationLanguage.g:3232:1: rule__AlgorithmInstanceRule__Group__1__Impl : ( ( rule__AlgorithmInstanceRule__DefinitionAssignment_1 ) ) ;
    public final void rule__AlgorithmInstanceRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3236:1: ( ( ( rule__AlgorithmInstanceRule__DefinitionAssignment_1 ) ) )
            // InternalOptimisationLanguage.g:3237:1: ( ( rule__AlgorithmInstanceRule__DefinitionAssignment_1 ) )
            {
            // InternalOptimisationLanguage.g:3237:1: ( ( rule__AlgorithmInstanceRule__DefinitionAssignment_1 ) )
            // InternalOptimisationLanguage.g:3238:2: ( rule__AlgorithmInstanceRule__DefinitionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAlgorithmInstanceRuleAccess().getDefinitionAssignment_1()); 
            }
            // InternalOptimisationLanguage.g:3239:2: ( rule__AlgorithmInstanceRule__DefinitionAssignment_1 )
            // InternalOptimisationLanguage.g:3239:3: rule__AlgorithmInstanceRule__DefinitionAssignment_1
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
    // InternalOptimisationLanguage.g:3247:1: rule__AlgorithmInstanceRule__Group__2 : rule__AlgorithmInstanceRule__Group__2__Impl rule__AlgorithmInstanceRule__Group__3 ;
    public final void rule__AlgorithmInstanceRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3251:1: ( rule__AlgorithmInstanceRule__Group__2__Impl rule__AlgorithmInstanceRule__Group__3 )
            // InternalOptimisationLanguage.g:3252:2: rule__AlgorithmInstanceRule__Group__2__Impl rule__AlgorithmInstanceRule__Group__3
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
    // InternalOptimisationLanguage.g:3259:1: rule__AlgorithmInstanceRule__Group__2__Impl : ( 'for' ) ;
    public final void rule__AlgorithmInstanceRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3263:1: ( ( 'for' ) )
            // InternalOptimisationLanguage.g:3264:1: ( 'for' )
            {
            // InternalOptimisationLanguage.g:3264:1: ( 'for' )
            // InternalOptimisationLanguage.g:3265:2: 'for'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAlgorithmInstanceRuleAccess().getForKeyword_2()); 
            }
            match(input,52,FOLLOW_2); if (state.failed) return ;
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
    // InternalOptimisationLanguage.g:3274:1: rule__AlgorithmInstanceRule__Group__3 : rule__AlgorithmInstanceRule__Group__3__Impl rule__AlgorithmInstanceRule__Group__4 ;
    public final void rule__AlgorithmInstanceRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3278:1: ( rule__AlgorithmInstanceRule__Group__3__Impl rule__AlgorithmInstanceRule__Group__4 )
            // InternalOptimisationLanguage.g:3279:2: rule__AlgorithmInstanceRule__Group__3__Impl rule__AlgorithmInstanceRule__Group__4
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
    // InternalOptimisationLanguage.g:3286:1: rule__AlgorithmInstanceRule__Group__3__Impl : ( ( rule__AlgorithmInstanceRule__ProblemAssignment_3 ) ) ;
    public final void rule__AlgorithmInstanceRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3290:1: ( ( ( rule__AlgorithmInstanceRule__ProblemAssignment_3 ) ) )
            // InternalOptimisationLanguage.g:3291:1: ( ( rule__AlgorithmInstanceRule__ProblemAssignment_3 ) )
            {
            // InternalOptimisationLanguage.g:3291:1: ( ( rule__AlgorithmInstanceRule__ProblemAssignment_3 ) )
            // InternalOptimisationLanguage.g:3292:2: ( rule__AlgorithmInstanceRule__ProblemAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAlgorithmInstanceRuleAccess().getProblemAssignment_3()); 
            }
            // InternalOptimisationLanguage.g:3293:2: ( rule__AlgorithmInstanceRule__ProblemAssignment_3 )
            // InternalOptimisationLanguage.g:3293:3: rule__AlgorithmInstanceRule__ProblemAssignment_3
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
    // InternalOptimisationLanguage.g:3301:1: rule__AlgorithmInstanceRule__Group__4 : rule__AlgorithmInstanceRule__Group__4__Impl rule__AlgorithmInstanceRule__Group__5 ;
    public final void rule__AlgorithmInstanceRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3305:1: ( rule__AlgorithmInstanceRule__Group__4__Impl rule__AlgorithmInstanceRule__Group__5 )
            // InternalOptimisationLanguage.g:3306:2: rule__AlgorithmInstanceRule__Group__4__Impl rule__AlgorithmInstanceRule__Group__5
            {
            pushFollow(FOLLOW_21);
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
    // InternalOptimisationLanguage.g:3313:1: rule__AlgorithmInstanceRule__Group__4__Impl : ( '{' ) ;
    public final void rule__AlgorithmInstanceRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3317:1: ( ( '{' ) )
            // InternalOptimisationLanguage.g:3318:1: ( '{' )
            {
            // InternalOptimisationLanguage.g:3318:1: ( '{' )
            // InternalOptimisationLanguage.g:3319:2: '{'
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
    // InternalOptimisationLanguage.g:3328:1: rule__AlgorithmInstanceRule__Group__5 : rule__AlgorithmInstanceRule__Group__5__Impl rule__AlgorithmInstanceRule__Group__6 ;
    public final void rule__AlgorithmInstanceRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3332:1: ( rule__AlgorithmInstanceRule__Group__5__Impl rule__AlgorithmInstanceRule__Group__6 )
            // InternalOptimisationLanguage.g:3333:2: rule__AlgorithmInstanceRule__Group__5__Impl rule__AlgorithmInstanceRule__Group__6
            {
            pushFollow(FOLLOW_21);
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
    // InternalOptimisationLanguage.g:3340:1: rule__AlgorithmInstanceRule__Group__5__Impl : ( ( rule__AlgorithmInstanceRule__AttributesAssignment_5 )* ) ;
    public final void rule__AlgorithmInstanceRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3344:1: ( ( ( rule__AlgorithmInstanceRule__AttributesAssignment_5 )* ) )
            // InternalOptimisationLanguage.g:3345:1: ( ( rule__AlgorithmInstanceRule__AttributesAssignment_5 )* )
            {
            // InternalOptimisationLanguage.g:3345:1: ( ( rule__AlgorithmInstanceRule__AttributesAssignment_5 )* )
            // InternalOptimisationLanguage.g:3346:2: ( rule__AlgorithmInstanceRule__AttributesAssignment_5 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAlgorithmInstanceRuleAccess().getAttributesAssignment_5()); 
            }
            // InternalOptimisationLanguage.g:3347:2: ( rule__AlgorithmInstanceRule__AttributesAssignment_5 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0>=RULE_QUOTED_ID && LA23_0<=RULE_ID)) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:3347:3: rule__AlgorithmInstanceRule__AttributesAssignment_5
            	    {
            	    pushFollow(FOLLOW_22);
            	    rule__AlgorithmInstanceRule__AttributesAssignment_5();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop23;
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
    // InternalOptimisationLanguage.g:3355:1: rule__AlgorithmInstanceRule__Group__6 : rule__AlgorithmInstanceRule__Group__6__Impl rule__AlgorithmInstanceRule__Group__7 ;
    public final void rule__AlgorithmInstanceRule__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3359:1: ( rule__AlgorithmInstanceRule__Group__6__Impl rule__AlgorithmInstanceRule__Group__7 )
            // InternalOptimisationLanguage.g:3360:2: rule__AlgorithmInstanceRule__Group__6__Impl rule__AlgorithmInstanceRule__Group__7
            {
            pushFollow(FOLLOW_21);
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
    // InternalOptimisationLanguage.g:3367:1: rule__AlgorithmInstanceRule__Group__6__Impl : ( ( rule__AlgorithmInstanceRule__Group_6__0 )? ) ;
    public final void rule__AlgorithmInstanceRule__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3371:1: ( ( ( rule__AlgorithmInstanceRule__Group_6__0 )? ) )
            // InternalOptimisationLanguage.g:3372:1: ( ( rule__AlgorithmInstanceRule__Group_6__0 )? )
            {
            // InternalOptimisationLanguage.g:3372:1: ( ( rule__AlgorithmInstanceRule__Group_6__0 )? )
            // InternalOptimisationLanguage.g:3373:2: ( rule__AlgorithmInstanceRule__Group_6__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAlgorithmInstanceRuleAccess().getGroup_6()); 
            }
            // InternalOptimisationLanguage.g:3374:2: ( rule__AlgorithmInstanceRule__Group_6__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==57) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalOptimisationLanguage.g:3374:3: rule__AlgorithmInstanceRule__Group_6__0
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
    // InternalOptimisationLanguage.g:3382:1: rule__AlgorithmInstanceRule__Group__7 : rule__AlgorithmInstanceRule__Group__7__Impl ;
    public final void rule__AlgorithmInstanceRule__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3386:1: ( rule__AlgorithmInstanceRule__Group__7__Impl )
            // InternalOptimisationLanguage.g:3387:2: rule__AlgorithmInstanceRule__Group__7__Impl
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
    // InternalOptimisationLanguage.g:3393:1: rule__AlgorithmInstanceRule__Group__7__Impl : ( '}' ) ;
    public final void rule__AlgorithmInstanceRule__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3397:1: ( ( '}' ) )
            // InternalOptimisationLanguage.g:3398:1: ( '}' )
            {
            // InternalOptimisationLanguage.g:3398:1: ( '}' )
            // InternalOptimisationLanguage.g:3399:2: '}'
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
    // InternalOptimisationLanguage.g:3409:1: rule__AlgorithmInstanceRule__Group_6__0 : rule__AlgorithmInstanceRule__Group_6__0__Impl rule__AlgorithmInstanceRule__Group_6__1 ;
    public final void rule__AlgorithmInstanceRule__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3413:1: ( rule__AlgorithmInstanceRule__Group_6__0__Impl rule__AlgorithmInstanceRule__Group_6__1 )
            // InternalOptimisationLanguage.g:3414:2: rule__AlgorithmInstanceRule__Group_6__0__Impl rule__AlgorithmInstanceRule__Group_6__1
            {
            pushFollow(FOLLOW_23);
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
    // InternalOptimisationLanguage.g:3421:1: rule__AlgorithmInstanceRule__Group_6__0__Impl : ( 'document' ) ;
    public final void rule__AlgorithmInstanceRule__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3425:1: ( ( 'document' ) )
            // InternalOptimisationLanguage.g:3426:1: ( 'document' )
            {
            // InternalOptimisationLanguage.g:3426:1: ( 'document' )
            // InternalOptimisationLanguage.g:3427:2: 'document'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAlgorithmInstanceRuleAccess().getDocumentKeyword_6_0()); 
            }
            match(input,57,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAlgorithmInstanceRuleAccess().getDocumentKeyword_6_0()); 
            }

            }


            }

        }
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
    // InternalOptimisationLanguage.g:3436:1: rule__AlgorithmInstanceRule__Group_6__1 : rule__AlgorithmInstanceRule__Group_6__1__Impl rule__AlgorithmInstanceRule__Group_6__2 ;
    public final void rule__AlgorithmInstanceRule__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3440:1: ( rule__AlgorithmInstanceRule__Group_6__1__Impl rule__AlgorithmInstanceRule__Group_6__2 )
            // InternalOptimisationLanguage.g:3441:2: rule__AlgorithmInstanceRule__Group_6__1__Impl rule__AlgorithmInstanceRule__Group_6__2
            {
            pushFollow(FOLLOW_17);
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
    // InternalOptimisationLanguage.g:3448:1: rule__AlgorithmInstanceRule__Group_6__1__Impl : ( ':=' ) ;
    public final void rule__AlgorithmInstanceRule__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3452:1: ( ( ':=' ) )
            // InternalOptimisationLanguage.g:3453:1: ( ':=' )
            {
            // InternalOptimisationLanguage.g:3453:1: ( ':=' )
            // InternalOptimisationLanguage.g:3454:2: ':='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAlgorithmInstanceRuleAccess().getColonEqualsSignKeyword_6_1()); 
            }
            match(input,64,FOLLOW_2); if (state.failed) return ;
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
    // InternalOptimisationLanguage.g:3463:1: rule__AlgorithmInstanceRule__Group_6__2 : rule__AlgorithmInstanceRule__Group_6__2__Impl rule__AlgorithmInstanceRule__Group_6__3 ;
    public final void rule__AlgorithmInstanceRule__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3467:1: ( rule__AlgorithmInstanceRule__Group_6__2__Impl rule__AlgorithmInstanceRule__Group_6__3 )
            // InternalOptimisationLanguage.g:3468:2: rule__AlgorithmInstanceRule__Group_6__2__Impl rule__AlgorithmInstanceRule__Group_6__3
            {
            pushFollow(FOLLOW_24);
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
    // InternalOptimisationLanguage.g:3475:1: rule__AlgorithmInstanceRule__Group_6__2__Impl : ( ( rule__AlgorithmInstanceRule__DocumentationAssignment_6_2 ) ) ;
    public final void rule__AlgorithmInstanceRule__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3479:1: ( ( ( rule__AlgorithmInstanceRule__DocumentationAssignment_6_2 ) ) )
            // InternalOptimisationLanguage.g:3480:1: ( ( rule__AlgorithmInstanceRule__DocumentationAssignment_6_2 ) )
            {
            // InternalOptimisationLanguage.g:3480:1: ( ( rule__AlgorithmInstanceRule__DocumentationAssignment_6_2 ) )
            // InternalOptimisationLanguage.g:3481:2: ( rule__AlgorithmInstanceRule__DocumentationAssignment_6_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAlgorithmInstanceRuleAccess().getDocumentationAssignment_6_2()); 
            }
            // InternalOptimisationLanguage.g:3482:2: ( rule__AlgorithmInstanceRule__DocumentationAssignment_6_2 )
            // InternalOptimisationLanguage.g:3482:3: rule__AlgorithmInstanceRule__DocumentationAssignment_6_2
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
    // InternalOptimisationLanguage.g:3490:1: rule__AlgorithmInstanceRule__Group_6__3 : rule__AlgorithmInstanceRule__Group_6__3__Impl ;
    public final void rule__AlgorithmInstanceRule__Group_6__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3494:1: ( rule__AlgorithmInstanceRule__Group_6__3__Impl )
            // InternalOptimisationLanguage.g:3495:2: rule__AlgorithmInstanceRule__Group_6__3__Impl
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
    // InternalOptimisationLanguage.g:3501:1: rule__AlgorithmInstanceRule__Group_6__3__Impl : ( ';' ) ;
    public final void rule__AlgorithmInstanceRule__Group_6__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3505:1: ( ( ';' ) )
            // InternalOptimisationLanguage.g:3506:1: ( ';' )
            {
            // InternalOptimisationLanguage.g:3506:1: ( ';' )
            // InternalOptimisationLanguage.g:3507:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAlgorithmInstanceRuleAccess().getSemicolonKeyword_6_3()); 
            }
            match(input,65,FOLLOW_2); if (state.failed) return ;
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


    // $ANTLR start "rule__OrExpressionRule__Group__0"
    // InternalOptimisationLanguage.g:3517:1: rule__OrExpressionRule__Group__0 : rule__OrExpressionRule__Group__0__Impl rule__OrExpressionRule__Group__1 ;
    public final void rule__OrExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3521:1: ( rule__OrExpressionRule__Group__0__Impl rule__OrExpressionRule__Group__1 )
            // InternalOptimisationLanguage.g:3522:2: rule__OrExpressionRule__Group__0__Impl rule__OrExpressionRule__Group__1
            {
            pushFollow(FOLLOW_25);
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
    // InternalOptimisationLanguage.g:3529:1: rule__OrExpressionRule__Group__0__Impl : ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) ) ;
    public final void rule__OrExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3533:1: ( ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) ) )
            // InternalOptimisationLanguage.g:3534:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) )
            {
            // InternalOptimisationLanguage.g:3534:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) )
            // InternalOptimisationLanguage.g:3535:2: ( rule__OrExpressionRule__SubExpressionsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsAssignment_0()); 
            }
            // InternalOptimisationLanguage.g:3536:2: ( rule__OrExpressionRule__SubExpressionsAssignment_0 )
            // InternalOptimisationLanguage.g:3536:3: rule__OrExpressionRule__SubExpressionsAssignment_0
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
    // InternalOptimisationLanguage.g:3544:1: rule__OrExpressionRule__Group__1 : rule__OrExpressionRule__Group__1__Impl ;
    public final void rule__OrExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3548:1: ( rule__OrExpressionRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:3549:2: rule__OrExpressionRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:3555:1: rule__OrExpressionRule__Group__1__Impl : ( ( rule__OrExpressionRule__Group_1__0 )* ) ;
    public final void rule__OrExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3559:1: ( ( ( rule__OrExpressionRule__Group_1__0 )* ) )
            // InternalOptimisationLanguage.g:3560:1: ( ( rule__OrExpressionRule__Group_1__0 )* )
            {
            // InternalOptimisationLanguage.g:3560:1: ( ( rule__OrExpressionRule__Group_1__0 )* )
            // InternalOptimisationLanguage.g:3561:2: ( rule__OrExpressionRule__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionRuleAccess().getGroup_1()); 
            }
            // InternalOptimisationLanguage.g:3562:2: ( rule__OrExpressionRule__Group_1__0 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==66) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:3562:3: rule__OrExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_26);
            	    rule__OrExpressionRule__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop25;
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
    // InternalOptimisationLanguage.g:3571:1: rule__OrExpressionRule__Group_1__0 : rule__OrExpressionRule__Group_1__0__Impl rule__OrExpressionRule__Group_1__1 ;
    public final void rule__OrExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3575:1: ( rule__OrExpressionRule__Group_1__0__Impl rule__OrExpressionRule__Group_1__1 )
            // InternalOptimisationLanguage.g:3576:2: rule__OrExpressionRule__Group_1__0__Impl rule__OrExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_27);
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
    // InternalOptimisationLanguage.g:3583:1: rule__OrExpressionRule__Group_1__0__Impl : ( 'OR' ) ;
    public final void rule__OrExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3587:1: ( ( 'OR' ) )
            // InternalOptimisationLanguage.g:3588:1: ( 'OR' )
            {
            // InternalOptimisationLanguage.g:3588:1: ( 'OR' )
            // InternalOptimisationLanguage.g:3589:2: 'OR'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionRuleAccess().getORKeyword_1_0()); 
            }
            match(input,66,FOLLOW_2); if (state.failed) return ;
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
    // InternalOptimisationLanguage.g:3598:1: rule__OrExpressionRule__Group_1__1 : rule__OrExpressionRule__Group_1__1__Impl ;
    public final void rule__OrExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3602:1: ( rule__OrExpressionRule__Group_1__1__Impl )
            // InternalOptimisationLanguage.g:3603:2: rule__OrExpressionRule__Group_1__1__Impl
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
    // InternalOptimisationLanguage.g:3609:1: rule__OrExpressionRule__Group_1__1__Impl : ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) ) ;
    public final void rule__OrExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3613:1: ( ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) ) )
            // InternalOptimisationLanguage.g:3614:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) )
            {
            // InternalOptimisationLanguage.g:3614:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) )
            // InternalOptimisationLanguage.g:3615:2: ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsAssignment_1_1()); 
            }
            // InternalOptimisationLanguage.g:3616:2: ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 )
            // InternalOptimisationLanguage.g:3616:3: rule__OrExpressionRule__SubExpressionsAssignment_1_1
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
    // InternalOptimisationLanguage.g:3625:1: rule__XorExpressionRule__Group__0 : rule__XorExpressionRule__Group__0__Impl rule__XorExpressionRule__Group__1 ;
    public final void rule__XorExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3629:1: ( rule__XorExpressionRule__Group__0__Impl rule__XorExpressionRule__Group__1 )
            // InternalOptimisationLanguage.g:3630:2: rule__XorExpressionRule__Group__0__Impl rule__XorExpressionRule__Group__1
            {
            pushFollow(FOLLOW_28);
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
    // InternalOptimisationLanguage.g:3637:1: rule__XorExpressionRule__Group__0__Impl : ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) ) ;
    public final void rule__XorExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3641:1: ( ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) ) )
            // InternalOptimisationLanguage.g:3642:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) )
            {
            // InternalOptimisationLanguage.g:3642:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) )
            // InternalOptimisationLanguage.g:3643:2: ( rule__XorExpressionRule__SubExpressionsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAssignment_0()); 
            }
            // InternalOptimisationLanguage.g:3644:2: ( rule__XorExpressionRule__SubExpressionsAssignment_0 )
            // InternalOptimisationLanguage.g:3644:3: rule__XorExpressionRule__SubExpressionsAssignment_0
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
    // InternalOptimisationLanguage.g:3652:1: rule__XorExpressionRule__Group__1 : rule__XorExpressionRule__Group__1__Impl ;
    public final void rule__XorExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3656:1: ( rule__XorExpressionRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:3657:2: rule__XorExpressionRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:3663:1: rule__XorExpressionRule__Group__1__Impl : ( ( rule__XorExpressionRule__Group_1__0 )* ) ;
    public final void rule__XorExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3667:1: ( ( ( rule__XorExpressionRule__Group_1__0 )* ) )
            // InternalOptimisationLanguage.g:3668:1: ( ( rule__XorExpressionRule__Group_1__0 )* )
            {
            // InternalOptimisationLanguage.g:3668:1: ( ( rule__XorExpressionRule__Group_1__0 )* )
            // InternalOptimisationLanguage.g:3669:2: ( rule__XorExpressionRule__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXorExpressionRuleAccess().getGroup_1()); 
            }
            // InternalOptimisationLanguage.g:3670:2: ( rule__XorExpressionRule__Group_1__0 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==67) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:3670:3: rule__XorExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_29);
            	    rule__XorExpressionRule__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop26;
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
    // InternalOptimisationLanguage.g:3679:1: rule__XorExpressionRule__Group_1__0 : rule__XorExpressionRule__Group_1__0__Impl rule__XorExpressionRule__Group_1__1 ;
    public final void rule__XorExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3683:1: ( rule__XorExpressionRule__Group_1__0__Impl rule__XorExpressionRule__Group_1__1 )
            // InternalOptimisationLanguage.g:3684:2: rule__XorExpressionRule__Group_1__0__Impl rule__XorExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_27);
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
    // InternalOptimisationLanguage.g:3691:1: rule__XorExpressionRule__Group_1__0__Impl : ( 'XOR' ) ;
    public final void rule__XorExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3695:1: ( ( 'XOR' ) )
            // InternalOptimisationLanguage.g:3696:1: ( 'XOR' )
            {
            // InternalOptimisationLanguage.g:3696:1: ( 'XOR' )
            // InternalOptimisationLanguage.g:3697:2: 'XOR'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXorExpressionRuleAccess().getXORKeyword_1_0()); 
            }
            match(input,67,FOLLOW_2); if (state.failed) return ;
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
    // InternalOptimisationLanguage.g:3706:1: rule__XorExpressionRule__Group_1__1 : rule__XorExpressionRule__Group_1__1__Impl ;
    public final void rule__XorExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3710:1: ( rule__XorExpressionRule__Group_1__1__Impl )
            // InternalOptimisationLanguage.g:3711:2: rule__XorExpressionRule__Group_1__1__Impl
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
    // InternalOptimisationLanguage.g:3717:1: rule__XorExpressionRule__Group_1__1__Impl : ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) ) ;
    public final void rule__XorExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3721:1: ( ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) ) )
            // InternalOptimisationLanguage.g:3722:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) )
            {
            // InternalOptimisationLanguage.g:3722:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) )
            // InternalOptimisationLanguage.g:3723:2: ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAssignment_1_1()); 
            }
            // InternalOptimisationLanguage.g:3724:2: ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 )
            // InternalOptimisationLanguage.g:3724:3: rule__XorExpressionRule__SubExpressionsAssignment_1_1
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
    // InternalOptimisationLanguage.g:3733:1: rule__AndExpressionRule__Group__0 : rule__AndExpressionRule__Group__0__Impl rule__AndExpressionRule__Group__1 ;
    public final void rule__AndExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3737:1: ( rule__AndExpressionRule__Group__0__Impl rule__AndExpressionRule__Group__1 )
            // InternalOptimisationLanguage.g:3738:2: rule__AndExpressionRule__Group__0__Impl rule__AndExpressionRule__Group__1
            {
            pushFollow(FOLLOW_30);
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
    // InternalOptimisationLanguage.g:3745:1: rule__AndExpressionRule__Group__0__Impl : ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) ) ;
    public final void rule__AndExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3749:1: ( ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) ) )
            // InternalOptimisationLanguage.g:3750:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) )
            {
            // InternalOptimisationLanguage.g:3750:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) )
            // InternalOptimisationLanguage.g:3751:2: ( rule__AndExpressionRule__SubExpressionsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsAssignment_0()); 
            }
            // InternalOptimisationLanguage.g:3752:2: ( rule__AndExpressionRule__SubExpressionsAssignment_0 )
            // InternalOptimisationLanguage.g:3752:3: rule__AndExpressionRule__SubExpressionsAssignment_0
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
    // InternalOptimisationLanguage.g:3760:1: rule__AndExpressionRule__Group__1 : rule__AndExpressionRule__Group__1__Impl ;
    public final void rule__AndExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3764:1: ( rule__AndExpressionRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:3765:2: rule__AndExpressionRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:3771:1: rule__AndExpressionRule__Group__1__Impl : ( ( rule__AndExpressionRule__Group_1__0 )* ) ;
    public final void rule__AndExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3775:1: ( ( ( rule__AndExpressionRule__Group_1__0 )* ) )
            // InternalOptimisationLanguage.g:3776:1: ( ( rule__AndExpressionRule__Group_1__0 )* )
            {
            // InternalOptimisationLanguage.g:3776:1: ( ( rule__AndExpressionRule__Group_1__0 )* )
            // InternalOptimisationLanguage.g:3777:2: ( rule__AndExpressionRule__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionRuleAccess().getGroup_1()); 
            }
            // InternalOptimisationLanguage.g:3778:2: ( rule__AndExpressionRule__Group_1__0 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==68) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:3778:3: rule__AndExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_31);
            	    rule__AndExpressionRule__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop27;
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
    // InternalOptimisationLanguage.g:3787:1: rule__AndExpressionRule__Group_1__0 : rule__AndExpressionRule__Group_1__0__Impl rule__AndExpressionRule__Group_1__1 ;
    public final void rule__AndExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3791:1: ( rule__AndExpressionRule__Group_1__0__Impl rule__AndExpressionRule__Group_1__1 )
            // InternalOptimisationLanguage.g:3792:2: rule__AndExpressionRule__Group_1__0__Impl rule__AndExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_27);
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
    // InternalOptimisationLanguage.g:3799:1: rule__AndExpressionRule__Group_1__0__Impl : ( 'AND' ) ;
    public final void rule__AndExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3803:1: ( ( 'AND' ) )
            // InternalOptimisationLanguage.g:3804:1: ( 'AND' )
            {
            // InternalOptimisationLanguage.g:3804:1: ( 'AND' )
            // InternalOptimisationLanguage.g:3805:2: 'AND'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionRuleAccess().getANDKeyword_1_0()); 
            }
            match(input,68,FOLLOW_2); if (state.failed) return ;
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
    // InternalOptimisationLanguage.g:3814:1: rule__AndExpressionRule__Group_1__1 : rule__AndExpressionRule__Group_1__1__Impl ;
    public final void rule__AndExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3818:1: ( rule__AndExpressionRule__Group_1__1__Impl )
            // InternalOptimisationLanguage.g:3819:2: rule__AndExpressionRule__Group_1__1__Impl
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
    // InternalOptimisationLanguage.g:3825:1: rule__AndExpressionRule__Group_1__1__Impl : ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) ) ;
    public final void rule__AndExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3829:1: ( ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) ) )
            // InternalOptimisationLanguage.g:3830:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) )
            {
            // InternalOptimisationLanguage.g:3830:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) )
            // InternalOptimisationLanguage.g:3831:2: ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsAssignment_1_1()); 
            }
            // InternalOptimisationLanguage.g:3832:2: ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 )
            // InternalOptimisationLanguage.g:3832:3: rule__AndExpressionRule__SubExpressionsAssignment_1_1
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
    // InternalOptimisationLanguage.g:3841:1: rule__NotExpressionRule__Group__0 : rule__NotExpressionRule__Group__0__Impl rule__NotExpressionRule__Group__1 ;
    public final void rule__NotExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3845:1: ( rule__NotExpressionRule__Group__0__Impl rule__NotExpressionRule__Group__1 )
            // InternalOptimisationLanguage.g:3846:2: rule__NotExpressionRule__Group__0__Impl rule__NotExpressionRule__Group__1
            {
            pushFollow(FOLLOW_27);
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
    // InternalOptimisationLanguage.g:3853:1: rule__NotExpressionRule__Group__0__Impl : ( ( rule__NotExpressionRule__NegatedAssignment_0 )? ) ;
    public final void rule__NotExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3857:1: ( ( ( rule__NotExpressionRule__NegatedAssignment_0 )? ) )
            // InternalOptimisationLanguage.g:3858:1: ( ( rule__NotExpressionRule__NegatedAssignment_0 )? )
            {
            // InternalOptimisationLanguage.g:3858:1: ( ( rule__NotExpressionRule__NegatedAssignment_0 )? )
            // InternalOptimisationLanguage.g:3859:2: ( rule__NotExpressionRule__NegatedAssignment_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNotExpressionRuleAccess().getNegatedAssignment_0()); 
            }
            // InternalOptimisationLanguage.g:3860:2: ( rule__NotExpressionRule__NegatedAssignment_0 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==93) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalOptimisationLanguage.g:3860:3: rule__NotExpressionRule__NegatedAssignment_0
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
    // InternalOptimisationLanguage.g:3868:1: rule__NotExpressionRule__Group__1 : rule__NotExpressionRule__Group__1__Impl ;
    public final void rule__NotExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3872:1: ( rule__NotExpressionRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:3873:2: rule__NotExpressionRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:3879:1: rule__NotExpressionRule__Group__1__Impl : ( ( rule__NotExpressionRule__OperandAssignment_1 ) ) ;
    public final void rule__NotExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3883:1: ( ( ( rule__NotExpressionRule__OperandAssignment_1 ) ) )
            // InternalOptimisationLanguage.g:3884:1: ( ( rule__NotExpressionRule__OperandAssignment_1 ) )
            {
            // InternalOptimisationLanguage.g:3884:1: ( ( rule__NotExpressionRule__OperandAssignment_1 ) )
            // InternalOptimisationLanguage.g:3885:2: ( rule__NotExpressionRule__OperandAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNotExpressionRuleAccess().getOperandAssignment_1()); 
            }
            // InternalOptimisationLanguage.g:3886:2: ( rule__NotExpressionRule__OperandAssignment_1 )
            // InternalOptimisationLanguage.g:3886:3: rule__NotExpressionRule__OperandAssignment_1
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
    // InternalOptimisationLanguage.g:3895:1: rule__ComparisonExpressionRule__Group__0 : rule__ComparisonExpressionRule__Group__0__Impl rule__ComparisonExpressionRule__Group__1 ;
    public final void rule__ComparisonExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3899:1: ( rule__ComparisonExpressionRule__Group__0__Impl rule__ComparisonExpressionRule__Group__1 )
            // InternalOptimisationLanguage.g:3900:2: rule__ComparisonExpressionRule__Group__0__Impl rule__ComparisonExpressionRule__Group__1
            {
            pushFollow(FOLLOW_32);
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
    // InternalOptimisationLanguage.g:3907:1: rule__ComparisonExpressionRule__Group__0__Impl : ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__ComparisonExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3911:1: ( ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalOptimisationLanguage.g:3912:1: ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalOptimisationLanguage.g:3912:1: ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) )
            // InternalOptimisationLanguage.g:3913:2: ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonExpressionRuleAccess().getLeftOperandAssignment_0()); 
            }
            // InternalOptimisationLanguage.g:3914:2: ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 )
            // InternalOptimisationLanguage.g:3914:3: rule__ComparisonExpressionRule__LeftOperandAssignment_0
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
    // InternalOptimisationLanguage.g:3922:1: rule__ComparisonExpressionRule__Group__1 : rule__ComparisonExpressionRule__Group__1__Impl ;
    public final void rule__ComparisonExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3926:1: ( rule__ComparisonExpressionRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:3927:2: rule__ComparisonExpressionRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:3933:1: rule__ComparisonExpressionRule__Group__1__Impl : ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* ) ;
    public final void rule__ComparisonExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3937:1: ( ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* ) )
            // InternalOptimisationLanguage.g:3938:1: ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* )
            {
            // InternalOptimisationLanguage.g:3938:1: ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* )
            // InternalOptimisationLanguage.g:3939:2: ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonExpressionRuleAccess().getComparisonAssignment_1()); 
            }
            // InternalOptimisationLanguage.g:3940:2: ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( ((LA29_0>=16 && LA29_0<=21)) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:3940:3: rule__ComparisonExpressionRule__ComparisonAssignment_1
            	    {
            	    pushFollow(FOLLOW_33);
            	    rule__ComparisonExpressionRule__ComparisonAssignment_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop29;
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
    // InternalOptimisationLanguage.g:3949:1: rule__PartialComparisonExpressionRule__Group__0 : rule__PartialComparisonExpressionRule__Group__0__Impl rule__PartialComparisonExpressionRule__Group__1 ;
    public final void rule__PartialComparisonExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3953:1: ( rule__PartialComparisonExpressionRule__Group__0__Impl rule__PartialComparisonExpressionRule__Group__1 )
            // InternalOptimisationLanguage.g:3954:2: rule__PartialComparisonExpressionRule__Group__0__Impl rule__PartialComparisonExpressionRule__Group__1
            {
            pushFollow(FOLLOW_27);
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
    // InternalOptimisationLanguage.g:3961:1: rule__PartialComparisonExpressionRule__Group__0__Impl : ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) ) ;
    public final void rule__PartialComparisonExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3965:1: ( ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) ) )
            // InternalOptimisationLanguage.g:3966:1: ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) )
            {
            // InternalOptimisationLanguage.g:3966:1: ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) )
            // InternalOptimisationLanguage.g:3967:2: ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartialComparisonExpressionRuleAccess().getOperatorAssignment_0()); 
            }
            // InternalOptimisationLanguage.g:3968:2: ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 )
            // InternalOptimisationLanguage.g:3968:3: rule__PartialComparisonExpressionRule__OperatorAssignment_0
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
    // InternalOptimisationLanguage.g:3976:1: rule__PartialComparisonExpressionRule__Group__1 : rule__PartialComparisonExpressionRule__Group__1__Impl ;
    public final void rule__PartialComparisonExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3980:1: ( rule__PartialComparisonExpressionRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:3981:2: rule__PartialComparisonExpressionRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:3987:1: rule__PartialComparisonExpressionRule__Group__1__Impl : ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) ) ;
    public final void rule__PartialComparisonExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3991:1: ( ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) ) )
            // InternalOptimisationLanguage.g:3992:1: ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) )
            {
            // InternalOptimisationLanguage.g:3992:1: ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) )
            // InternalOptimisationLanguage.g:3993:2: ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartialComparisonExpressionRuleAccess().getSubExpressionAssignment_1()); 
            }
            // InternalOptimisationLanguage.g:3994:2: ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 )
            // InternalOptimisationLanguage.g:3994:3: rule__PartialComparisonExpressionRule__SubExpressionAssignment_1
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
    // InternalOptimisationLanguage.g:4003:1: rule__AddOrSubtractExpressionRule__Group__0 : rule__AddOrSubtractExpressionRule__Group__0__Impl rule__AddOrSubtractExpressionRule__Group__1 ;
    public final void rule__AddOrSubtractExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4007:1: ( rule__AddOrSubtractExpressionRule__Group__0__Impl rule__AddOrSubtractExpressionRule__Group__1 )
            // InternalOptimisationLanguage.g:4008:2: rule__AddOrSubtractExpressionRule__Group__0__Impl rule__AddOrSubtractExpressionRule__Group__1
            {
            pushFollow(FOLLOW_34);
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
    // InternalOptimisationLanguage.g:4015:1: rule__AddOrSubtractExpressionRule__Group__0__Impl : ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__AddOrSubtractExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4019:1: ( ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalOptimisationLanguage.g:4020:1: ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalOptimisationLanguage.g:4020:1: ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) )
            // InternalOptimisationLanguage.g:4021:2: ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getLeftOperandAssignment_0()); 
            }
            // InternalOptimisationLanguage.g:4022:2: ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 )
            // InternalOptimisationLanguage.g:4022:3: rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0
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
    // InternalOptimisationLanguage.g:4030:1: rule__AddOrSubtractExpressionRule__Group__1 : rule__AddOrSubtractExpressionRule__Group__1__Impl ;
    public final void rule__AddOrSubtractExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4034:1: ( rule__AddOrSubtractExpressionRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:4035:2: rule__AddOrSubtractExpressionRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:4041:1: rule__AddOrSubtractExpressionRule__Group__1__Impl : ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* ) ;
    public final void rule__AddOrSubtractExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4045:1: ( ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* ) )
            // InternalOptimisationLanguage.g:4046:1: ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* )
            {
            // InternalOptimisationLanguage.g:4046:1: ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* )
            // InternalOptimisationLanguage.g:4047:2: ( rule__AddOrSubtractExpressionRule__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getGroup_1()); 
            }
            // InternalOptimisationLanguage.g:4048:2: ( rule__AddOrSubtractExpressionRule__Group_1__0 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( ((LA30_0>=22 && LA30_0<=23)) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:4048:3: rule__AddOrSubtractExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_35);
            	    rule__AddOrSubtractExpressionRule__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop30;
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
    // InternalOptimisationLanguage.g:4057:1: rule__AddOrSubtractExpressionRule__Group_1__0 : rule__AddOrSubtractExpressionRule__Group_1__0__Impl rule__AddOrSubtractExpressionRule__Group_1__1 ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4061:1: ( rule__AddOrSubtractExpressionRule__Group_1__0__Impl rule__AddOrSubtractExpressionRule__Group_1__1 )
            // InternalOptimisationLanguage.g:4062:2: rule__AddOrSubtractExpressionRule__Group_1__0__Impl rule__AddOrSubtractExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_27);
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
    // InternalOptimisationLanguage.g:4069:1: rule__AddOrSubtractExpressionRule__Group_1__0__Impl : ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) ) ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4073:1: ( ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) ) )
            // InternalOptimisationLanguage.g:4074:1: ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) )
            {
            // InternalOptimisationLanguage.g:4074:1: ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) )
            // InternalOptimisationLanguage.g:4075:2: ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperatorsAssignment_1_0()); 
            }
            // InternalOptimisationLanguage.g:4076:2: ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 )
            // InternalOptimisationLanguage.g:4076:3: rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0
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
    // InternalOptimisationLanguage.g:4084:1: rule__AddOrSubtractExpressionRule__Group_1__1 : rule__AddOrSubtractExpressionRule__Group_1__1__Impl ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4088:1: ( rule__AddOrSubtractExpressionRule__Group_1__1__Impl )
            // InternalOptimisationLanguage.g:4089:2: rule__AddOrSubtractExpressionRule__Group_1__1__Impl
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
    // InternalOptimisationLanguage.g:4095:1: rule__AddOrSubtractExpressionRule__Group_1__1__Impl : ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) ) ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4099:1: ( ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) ) )
            // InternalOptimisationLanguage.g:4100:1: ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) )
            {
            // InternalOptimisationLanguage.g:4100:1: ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) )
            // InternalOptimisationLanguage.g:4101:2: ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperandsAssignment_1_1()); 
            }
            // InternalOptimisationLanguage.g:4102:2: ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 )
            // InternalOptimisationLanguage.g:4102:3: rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1
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
    // InternalOptimisationLanguage.g:4111:1: rule__MultiplyDivideModuloExpressionRule__Group__0 : rule__MultiplyDivideModuloExpressionRule__Group__0__Impl rule__MultiplyDivideModuloExpressionRule__Group__1 ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4115:1: ( rule__MultiplyDivideModuloExpressionRule__Group__0__Impl rule__MultiplyDivideModuloExpressionRule__Group__1 )
            // InternalOptimisationLanguage.g:4116:2: rule__MultiplyDivideModuloExpressionRule__Group__0__Impl rule__MultiplyDivideModuloExpressionRule__Group__1
            {
            pushFollow(FOLLOW_36);
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
    // InternalOptimisationLanguage.g:4123:1: rule__MultiplyDivideModuloExpressionRule__Group__0__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4127:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalOptimisationLanguage.g:4128:1: ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalOptimisationLanguage.g:4128:1: ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) )
            // InternalOptimisationLanguage.g:4129:2: ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getLeftOperandAssignment_0()); 
            }
            // InternalOptimisationLanguage.g:4130:2: ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 )
            // InternalOptimisationLanguage.g:4130:3: rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0
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
    // InternalOptimisationLanguage.g:4138:1: rule__MultiplyDivideModuloExpressionRule__Group__1 : rule__MultiplyDivideModuloExpressionRule__Group__1__Impl ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4142:1: ( rule__MultiplyDivideModuloExpressionRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:4143:2: rule__MultiplyDivideModuloExpressionRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:4149:1: rule__MultiplyDivideModuloExpressionRule__Group__1__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4153:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* ) )
            // InternalOptimisationLanguage.g:4154:1: ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* )
            {
            // InternalOptimisationLanguage.g:4154:1: ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* )
            // InternalOptimisationLanguage.g:4155:2: ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getGroup_1()); 
            }
            // InternalOptimisationLanguage.g:4156:2: ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( ((LA31_0>=24 && LA31_0<=26)) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:4156:3: rule__MultiplyDivideModuloExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_37);
            	    rule__MultiplyDivideModuloExpressionRule__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop31;
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
    // InternalOptimisationLanguage.g:4165:1: rule__MultiplyDivideModuloExpressionRule__Group_1__0 : rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl rule__MultiplyDivideModuloExpressionRule__Group_1__1 ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4169:1: ( rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl rule__MultiplyDivideModuloExpressionRule__Group_1__1 )
            // InternalOptimisationLanguage.g:4170:2: rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl rule__MultiplyDivideModuloExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_27);
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
    // InternalOptimisationLanguage.g:4177:1: rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4181:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) ) )
            // InternalOptimisationLanguage.g:4182:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) )
            {
            // InternalOptimisationLanguage.g:4182:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) )
            // InternalOptimisationLanguage.g:4183:2: ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperatorsAssignment_1_0()); 
            }
            // InternalOptimisationLanguage.g:4184:2: ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 )
            // InternalOptimisationLanguage.g:4184:3: rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0
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
    // InternalOptimisationLanguage.g:4192:1: rule__MultiplyDivideModuloExpressionRule__Group_1__1 : rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4196:1: ( rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl )
            // InternalOptimisationLanguage.g:4197:2: rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl
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
    // InternalOptimisationLanguage.g:4203:1: rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4207:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) ) )
            // InternalOptimisationLanguage.g:4208:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) )
            {
            // InternalOptimisationLanguage.g:4208:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) )
            // InternalOptimisationLanguage.g:4209:2: ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperandsAssignment_1_1()); 
            }
            // InternalOptimisationLanguage.g:4210:2: ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 )
            // InternalOptimisationLanguage.g:4210:3: rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1
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
    // InternalOptimisationLanguage.g:4219:1: rule__PowerOfExpressionRule__Group__0 : rule__PowerOfExpressionRule__Group__0__Impl rule__PowerOfExpressionRule__Group__1 ;
    public final void rule__PowerOfExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4223:1: ( rule__PowerOfExpressionRule__Group__0__Impl rule__PowerOfExpressionRule__Group__1 )
            // InternalOptimisationLanguage.g:4224:2: rule__PowerOfExpressionRule__Group__0__Impl rule__PowerOfExpressionRule__Group__1
            {
            pushFollow(FOLLOW_38);
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
    // InternalOptimisationLanguage.g:4231:1: rule__PowerOfExpressionRule__Group__0__Impl : ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__PowerOfExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4235:1: ( ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalOptimisationLanguage.g:4236:1: ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalOptimisationLanguage.g:4236:1: ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) )
            // InternalOptimisationLanguage.g:4237:2: ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPowerOfExpressionRuleAccess().getLeftOperandAssignment_0()); 
            }
            // InternalOptimisationLanguage.g:4238:2: ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 )
            // InternalOptimisationLanguage.g:4238:3: rule__PowerOfExpressionRule__LeftOperandAssignment_0
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
    // InternalOptimisationLanguage.g:4246:1: rule__PowerOfExpressionRule__Group__1 : rule__PowerOfExpressionRule__Group__1__Impl ;
    public final void rule__PowerOfExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4250:1: ( rule__PowerOfExpressionRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:4251:2: rule__PowerOfExpressionRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:4257:1: rule__PowerOfExpressionRule__Group__1__Impl : ( ( rule__PowerOfExpressionRule__Group_1__0 )? ) ;
    public final void rule__PowerOfExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4261:1: ( ( ( rule__PowerOfExpressionRule__Group_1__0 )? ) )
            // InternalOptimisationLanguage.g:4262:1: ( ( rule__PowerOfExpressionRule__Group_1__0 )? )
            {
            // InternalOptimisationLanguage.g:4262:1: ( ( rule__PowerOfExpressionRule__Group_1__0 )? )
            // InternalOptimisationLanguage.g:4263:2: ( rule__PowerOfExpressionRule__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPowerOfExpressionRuleAccess().getGroup_1()); 
            }
            // InternalOptimisationLanguage.g:4264:2: ( rule__PowerOfExpressionRule__Group_1__0 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==69) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalOptimisationLanguage.g:4264:3: rule__PowerOfExpressionRule__Group_1__0
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
    // InternalOptimisationLanguage.g:4273:1: rule__PowerOfExpressionRule__Group_1__0 : rule__PowerOfExpressionRule__Group_1__0__Impl rule__PowerOfExpressionRule__Group_1__1 ;
    public final void rule__PowerOfExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4277:1: ( rule__PowerOfExpressionRule__Group_1__0__Impl rule__PowerOfExpressionRule__Group_1__1 )
            // InternalOptimisationLanguage.g:4278:2: rule__PowerOfExpressionRule__Group_1__0__Impl rule__PowerOfExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_27);
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
    // InternalOptimisationLanguage.g:4285:1: rule__PowerOfExpressionRule__Group_1__0__Impl : ( '^' ) ;
    public final void rule__PowerOfExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4289:1: ( ( '^' ) )
            // InternalOptimisationLanguage.g:4290:1: ( '^' )
            {
            // InternalOptimisationLanguage.g:4290:1: ( '^' )
            // InternalOptimisationLanguage.g:4291:2: '^'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPowerOfExpressionRuleAccess().getCircumflexAccentKeyword_1_0()); 
            }
            match(input,69,FOLLOW_2); if (state.failed) return ;
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
    // InternalOptimisationLanguage.g:4300:1: rule__PowerOfExpressionRule__Group_1__1 : rule__PowerOfExpressionRule__Group_1__1__Impl ;
    public final void rule__PowerOfExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4304:1: ( rule__PowerOfExpressionRule__Group_1__1__Impl )
            // InternalOptimisationLanguage.g:4305:2: rule__PowerOfExpressionRule__Group_1__1__Impl
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
    // InternalOptimisationLanguage.g:4311:1: rule__PowerOfExpressionRule__Group_1__1__Impl : ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) ) ;
    public final void rule__PowerOfExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4315:1: ( ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) ) )
            // InternalOptimisationLanguage.g:4316:1: ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) )
            {
            // InternalOptimisationLanguage.g:4316:1: ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) )
            // InternalOptimisationLanguage.g:4317:2: ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPowerOfExpressionRuleAccess().getRightOperandAssignment_1_1()); 
            }
            // InternalOptimisationLanguage.g:4318:2: ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 )
            // InternalOptimisationLanguage.g:4318:3: rule__PowerOfExpressionRule__RightOperandAssignment_1_1
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
    // InternalOptimisationLanguage.g:4327:1: rule__UnaryAddOrSubtractExpressionRule__Group__0 : rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl rule__UnaryAddOrSubtractExpressionRule__Group__1 ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4331:1: ( rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl rule__UnaryAddOrSubtractExpressionRule__Group__1 )
            // InternalOptimisationLanguage.g:4332:2: rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl rule__UnaryAddOrSubtractExpressionRule__Group__1
            {
            pushFollow(FOLLOW_27);
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
    // InternalOptimisationLanguage.g:4339:1: rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl : ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4343:1: ( ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* ) )
            // InternalOptimisationLanguage.g:4344:1: ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* )
            {
            // InternalOptimisationLanguage.g:4344:1: ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* )
            // InternalOptimisationLanguage.g:4345:2: ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getOperatorsAssignment_0()); 
            }
            // InternalOptimisationLanguage.g:4346:2: ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( ((LA33_0>=22 && LA33_0<=23)) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:4346:3: rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0
            	    {
            	    pushFollow(FOLLOW_35);
            	    rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop33;
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
    // InternalOptimisationLanguage.g:4354:1: rule__UnaryAddOrSubtractExpressionRule__Group__1 : rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4358:1: ( rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:4359:2: rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:4365:1: rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl : ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4369:1: ( ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) ) )
            // InternalOptimisationLanguage.g:4370:1: ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) )
            {
            // InternalOptimisationLanguage.g:4370:1: ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) )
            // InternalOptimisationLanguage.g:4371:2: ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getSubExpressionAssignment_1()); 
            }
            // InternalOptimisationLanguage.g:4372:2: ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 )
            // InternalOptimisationLanguage.g:4372:3: rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1
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
    // InternalOptimisationLanguage.g:4381:1: rule__ArrayRule__Group__0 : rule__ArrayRule__Group__0__Impl rule__ArrayRule__Group__1 ;
    public final void rule__ArrayRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4385:1: ( rule__ArrayRule__Group__0__Impl rule__ArrayRule__Group__1 )
            // InternalOptimisationLanguage.g:4386:2: rule__ArrayRule__Group__0__Impl rule__ArrayRule__Group__1
            {
            pushFollow(FOLLOW_17);
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
    // InternalOptimisationLanguage.g:4393:1: rule__ArrayRule__Group__0__Impl : ( () ) ;
    public final void rule__ArrayRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4397:1: ( ( () ) )
            // InternalOptimisationLanguage.g:4398:1: ( () )
            {
            // InternalOptimisationLanguage.g:4398:1: ( () )
            // InternalOptimisationLanguage.g:4399:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayRuleAccess().getArrayAction_0()); 
            }
            // InternalOptimisationLanguage.g:4400:2: ()
            // InternalOptimisationLanguage.g:4400:3: 
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
    // InternalOptimisationLanguage.g:4408:1: rule__ArrayRule__Group__1 : rule__ArrayRule__Group__1__Impl rule__ArrayRule__Group__2 ;
    public final void rule__ArrayRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4412:1: ( rule__ArrayRule__Group__1__Impl rule__ArrayRule__Group__2 )
            // InternalOptimisationLanguage.g:4413:2: rule__ArrayRule__Group__1__Impl rule__ArrayRule__Group__2
            {
            pushFollow(FOLLOW_39);
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
    // InternalOptimisationLanguage.g:4420:1: rule__ArrayRule__Group__1__Impl : ( '[' ) ;
    public final void rule__ArrayRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4424:1: ( ( '[' ) )
            // InternalOptimisationLanguage.g:4425:1: ( '[' )
            {
            // InternalOptimisationLanguage.g:4425:1: ( '[' )
            // InternalOptimisationLanguage.g:4426:2: '['
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayRuleAccess().getLeftSquareBracketKeyword_1()); 
            }
            match(input,70,FOLLOW_2); if (state.failed) return ;
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
    // InternalOptimisationLanguage.g:4435:1: rule__ArrayRule__Group__2 : rule__ArrayRule__Group__2__Impl rule__ArrayRule__Group__3 ;
    public final void rule__ArrayRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4439:1: ( rule__ArrayRule__Group__2__Impl rule__ArrayRule__Group__3 )
            // InternalOptimisationLanguage.g:4440:2: rule__ArrayRule__Group__2__Impl rule__ArrayRule__Group__3
            {
            pushFollow(FOLLOW_39);
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
    // InternalOptimisationLanguage.g:4447:1: rule__ArrayRule__Group__2__Impl : ( ( rule__ArrayRule__Group_2__0 )? ) ;
    public final void rule__ArrayRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4451:1: ( ( ( rule__ArrayRule__Group_2__0 )? ) )
            // InternalOptimisationLanguage.g:4452:1: ( ( rule__ArrayRule__Group_2__0 )? )
            {
            // InternalOptimisationLanguage.g:4452:1: ( ( rule__ArrayRule__Group_2__0 )? )
            // InternalOptimisationLanguage.g:4453:2: ( rule__ArrayRule__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayRuleAccess().getGroup_2()); 
            }
            // InternalOptimisationLanguage.g:4454:2: ( rule__ArrayRule__Group_2__0 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( ((LA34_0>=RULE_QUOTED_ID && LA34_0<=RULE_STRING)||LA34_0==15||(LA34_0>=22 && LA34_0<=23)||LA34_0==70||LA34_0==72||(LA34_0>=74 && LA34_0<=78)||(LA34_0>=93 && LA34_0<=94)) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalOptimisationLanguage.g:4454:3: rule__ArrayRule__Group_2__0
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
    // InternalOptimisationLanguage.g:4462:1: rule__ArrayRule__Group__3 : rule__ArrayRule__Group__3__Impl ;
    public final void rule__ArrayRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4466:1: ( rule__ArrayRule__Group__3__Impl )
            // InternalOptimisationLanguage.g:4467:2: rule__ArrayRule__Group__3__Impl
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
    // InternalOptimisationLanguage.g:4473:1: rule__ArrayRule__Group__3__Impl : ( ']' ) ;
    public final void rule__ArrayRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4477:1: ( ( ']' ) )
            // InternalOptimisationLanguage.g:4478:1: ( ']' )
            {
            // InternalOptimisationLanguage.g:4478:1: ( ']' )
            // InternalOptimisationLanguage.g:4479:2: ']'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayRuleAccess().getRightSquareBracketKeyword_3()); 
            }
            match(input,71,FOLLOW_2); if (state.failed) return ;
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
    // InternalOptimisationLanguage.g:4489:1: rule__ArrayRule__Group_2__0 : rule__ArrayRule__Group_2__0__Impl rule__ArrayRule__Group_2__1 ;
    public final void rule__ArrayRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4493:1: ( rule__ArrayRule__Group_2__0__Impl rule__ArrayRule__Group_2__1 )
            // InternalOptimisationLanguage.g:4494:2: rule__ArrayRule__Group_2__0__Impl rule__ArrayRule__Group_2__1
            {
            pushFollow(FOLLOW_40);
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
    // InternalOptimisationLanguage.g:4501:1: rule__ArrayRule__Group_2__0__Impl : ( ( rule__ArrayRule__ValuesAssignment_2_0 ) ) ;
    public final void rule__ArrayRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4505:1: ( ( ( rule__ArrayRule__ValuesAssignment_2_0 ) ) )
            // InternalOptimisationLanguage.g:4506:1: ( ( rule__ArrayRule__ValuesAssignment_2_0 ) )
            {
            // InternalOptimisationLanguage.g:4506:1: ( ( rule__ArrayRule__ValuesAssignment_2_0 ) )
            // InternalOptimisationLanguage.g:4507:2: ( rule__ArrayRule__ValuesAssignment_2_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayRuleAccess().getValuesAssignment_2_0()); 
            }
            // InternalOptimisationLanguage.g:4508:2: ( rule__ArrayRule__ValuesAssignment_2_0 )
            // InternalOptimisationLanguage.g:4508:3: rule__ArrayRule__ValuesAssignment_2_0
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
    // InternalOptimisationLanguage.g:4516:1: rule__ArrayRule__Group_2__1 : rule__ArrayRule__Group_2__1__Impl ;
    public final void rule__ArrayRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4520:1: ( rule__ArrayRule__Group_2__1__Impl )
            // InternalOptimisationLanguage.g:4521:2: rule__ArrayRule__Group_2__1__Impl
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
    // InternalOptimisationLanguage.g:4527:1: rule__ArrayRule__Group_2__1__Impl : ( ( rule__ArrayRule__Group_2_1__0 )* ) ;
    public final void rule__ArrayRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4531:1: ( ( ( rule__ArrayRule__Group_2_1__0 )* ) )
            // InternalOptimisationLanguage.g:4532:1: ( ( rule__ArrayRule__Group_2_1__0 )* )
            {
            // InternalOptimisationLanguage.g:4532:1: ( ( rule__ArrayRule__Group_2_1__0 )* )
            // InternalOptimisationLanguage.g:4533:2: ( rule__ArrayRule__Group_2_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayRuleAccess().getGroup_2_1()); 
            }
            // InternalOptimisationLanguage.g:4534:2: ( rule__ArrayRule__Group_2_1__0 )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==56) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:4534:3: rule__ArrayRule__Group_2_1__0
            	    {
            	    pushFollow(FOLLOW_12);
            	    rule__ArrayRule__Group_2_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop35;
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
    // InternalOptimisationLanguage.g:4543:1: rule__ArrayRule__Group_2_1__0 : rule__ArrayRule__Group_2_1__0__Impl rule__ArrayRule__Group_2_1__1 ;
    public final void rule__ArrayRule__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4547:1: ( rule__ArrayRule__Group_2_1__0__Impl rule__ArrayRule__Group_2_1__1 )
            // InternalOptimisationLanguage.g:4548:2: rule__ArrayRule__Group_2_1__0__Impl rule__ArrayRule__Group_2_1__1
            {
            pushFollow(FOLLOW_27);
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
    // InternalOptimisationLanguage.g:4555:1: rule__ArrayRule__Group_2_1__0__Impl : ( ',' ) ;
    public final void rule__ArrayRule__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4559:1: ( ( ',' ) )
            // InternalOptimisationLanguage.g:4560:1: ( ',' )
            {
            // InternalOptimisationLanguage.g:4560:1: ( ',' )
            // InternalOptimisationLanguage.g:4561:2: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayRuleAccess().getCommaKeyword_2_1_0()); 
            }
            match(input,56,FOLLOW_2); if (state.failed) return ;
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
    // InternalOptimisationLanguage.g:4570:1: rule__ArrayRule__Group_2_1__1 : rule__ArrayRule__Group_2_1__1__Impl ;
    public final void rule__ArrayRule__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4574:1: ( rule__ArrayRule__Group_2_1__1__Impl )
            // InternalOptimisationLanguage.g:4575:2: rule__ArrayRule__Group_2_1__1__Impl
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
    // InternalOptimisationLanguage.g:4581:1: rule__ArrayRule__Group_2_1__1__Impl : ( ( rule__ArrayRule__ValuesAssignment_2_1_1 ) ) ;
    public final void rule__ArrayRule__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4585:1: ( ( ( rule__ArrayRule__ValuesAssignment_2_1_1 ) ) )
            // InternalOptimisationLanguage.g:4586:1: ( ( rule__ArrayRule__ValuesAssignment_2_1_1 ) )
            {
            // InternalOptimisationLanguage.g:4586:1: ( ( rule__ArrayRule__ValuesAssignment_2_1_1 ) )
            // InternalOptimisationLanguage.g:4587:2: ( rule__ArrayRule__ValuesAssignment_2_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayRuleAccess().getValuesAssignment_2_1_1()); 
            }
            // InternalOptimisationLanguage.g:4588:2: ( rule__ArrayRule__ValuesAssignment_2_1_1 )
            // InternalOptimisationLanguage.g:4588:3: rule__ArrayRule__ValuesAssignment_2_1_1
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
    // InternalOptimisationLanguage.g:4597:1: rule__ParanthesesRule__Group__0 : rule__ParanthesesRule__Group__0__Impl rule__ParanthesesRule__Group__1 ;
    public final void rule__ParanthesesRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4601:1: ( rule__ParanthesesRule__Group__0__Impl rule__ParanthesesRule__Group__1 )
            // InternalOptimisationLanguage.g:4602:2: rule__ParanthesesRule__Group__0__Impl rule__ParanthesesRule__Group__1
            {
            pushFollow(FOLLOW_27);
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
    // InternalOptimisationLanguage.g:4609:1: rule__ParanthesesRule__Group__0__Impl : ( '(' ) ;
    public final void rule__ParanthesesRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4613:1: ( ( '(' ) )
            // InternalOptimisationLanguage.g:4614:1: ( '(' )
            {
            // InternalOptimisationLanguage.g:4614:1: ( '(' )
            // InternalOptimisationLanguage.g:4615:2: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParanthesesRuleAccess().getLeftParenthesisKeyword_0()); 
            }
            match(input,72,FOLLOW_2); if (state.failed) return ;
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
    // InternalOptimisationLanguage.g:4624:1: rule__ParanthesesRule__Group__1 : rule__ParanthesesRule__Group__1__Impl rule__ParanthesesRule__Group__2 ;
    public final void rule__ParanthesesRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4628:1: ( rule__ParanthesesRule__Group__1__Impl rule__ParanthesesRule__Group__2 )
            // InternalOptimisationLanguage.g:4629:2: rule__ParanthesesRule__Group__1__Impl rule__ParanthesesRule__Group__2
            {
            pushFollow(FOLLOW_41);
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
    // InternalOptimisationLanguage.g:4636:1: rule__ParanthesesRule__Group__1__Impl : ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) ) ;
    public final void rule__ParanthesesRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4640:1: ( ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) ) )
            // InternalOptimisationLanguage.g:4641:1: ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) )
            {
            // InternalOptimisationLanguage.g:4641:1: ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) )
            // InternalOptimisationLanguage.g:4642:2: ( rule__ParanthesesRule__SubExpressionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParanthesesRuleAccess().getSubExpressionAssignment_1()); 
            }
            // InternalOptimisationLanguage.g:4643:2: ( rule__ParanthesesRule__SubExpressionAssignment_1 )
            // InternalOptimisationLanguage.g:4643:3: rule__ParanthesesRule__SubExpressionAssignment_1
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
    // InternalOptimisationLanguage.g:4651:1: rule__ParanthesesRule__Group__2 : rule__ParanthesesRule__Group__2__Impl ;
    public final void rule__ParanthesesRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4655:1: ( rule__ParanthesesRule__Group__2__Impl )
            // InternalOptimisationLanguage.g:4656:2: rule__ParanthesesRule__Group__2__Impl
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
    // InternalOptimisationLanguage.g:4662:1: rule__ParanthesesRule__Group__2__Impl : ( ')' ) ;
    public final void rule__ParanthesesRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4666:1: ( ( ')' ) )
            // InternalOptimisationLanguage.g:4667:1: ( ')' )
            {
            // InternalOptimisationLanguage.g:4667:1: ( ')' )
            // InternalOptimisationLanguage.g:4668:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParanthesesRuleAccess().getRightParenthesisKeyword_2()); 
            }
            match(input,73,FOLLOW_2); if (state.failed) return ;
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
    // InternalOptimisationLanguage.g:4678:1: rule__CallRule__Group__0 : rule__CallRule__Group__0__Impl rule__CallRule__Group__1 ;
    public final void rule__CallRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4682:1: ( rule__CallRule__Group__0__Impl rule__CallRule__Group__1 )
            // InternalOptimisationLanguage.g:4683:2: rule__CallRule__Group__0__Impl rule__CallRule__Group__1
            {
            pushFollow(FOLLOW_42);
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
    // InternalOptimisationLanguage.g:4690:1: rule__CallRule__Group__0__Impl : ( ( rule__CallRule__FunctionAssignment_0 ) ) ;
    public final void rule__CallRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4694:1: ( ( ( rule__CallRule__FunctionAssignment_0 ) ) )
            // InternalOptimisationLanguage.g:4695:1: ( ( rule__CallRule__FunctionAssignment_0 ) )
            {
            // InternalOptimisationLanguage.g:4695:1: ( ( rule__CallRule__FunctionAssignment_0 ) )
            // InternalOptimisationLanguage.g:4696:2: ( rule__CallRule__FunctionAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getFunctionAssignment_0()); 
            }
            // InternalOptimisationLanguage.g:4697:2: ( rule__CallRule__FunctionAssignment_0 )
            // InternalOptimisationLanguage.g:4697:3: rule__CallRule__FunctionAssignment_0
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
    // InternalOptimisationLanguage.g:4705:1: rule__CallRule__Group__1 : rule__CallRule__Group__1__Impl rule__CallRule__Group__2 ;
    public final void rule__CallRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4709:1: ( rule__CallRule__Group__1__Impl rule__CallRule__Group__2 )
            // InternalOptimisationLanguage.g:4710:2: rule__CallRule__Group__1__Impl rule__CallRule__Group__2
            {
            pushFollow(FOLLOW_43);
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
    // InternalOptimisationLanguage.g:4717:1: rule__CallRule__Group__1__Impl : ( '(' ) ;
    public final void rule__CallRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4721:1: ( ( '(' ) )
            // InternalOptimisationLanguage.g:4722:1: ( '(' )
            {
            // InternalOptimisationLanguage.g:4722:1: ( '(' )
            // InternalOptimisationLanguage.g:4723:2: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getLeftParenthesisKeyword_1()); 
            }
            match(input,72,FOLLOW_2); if (state.failed) return ;
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
    // InternalOptimisationLanguage.g:4732:1: rule__CallRule__Group__2 : rule__CallRule__Group__2__Impl rule__CallRule__Group__3 ;
    public final void rule__CallRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4736:1: ( rule__CallRule__Group__2__Impl rule__CallRule__Group__3 )
            // InternalOptimisationLanguage.g:4737:2: rule__CallRule__Group__2__Impl rule__CallRule__Group__3
            {
            pushFollow(FOLLOW_43);
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
    // InternalOptimisationLanguage.g:4744:1: rule__CallRule__Group__2__Impl : ( ( rule__CallRule__Group_2__0 )? ) ;
    public final void rule__CallRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4748:1: ( ( ( rule__CallRule__Group_2__0 )? ) )
            // InternalOptimisationLanguage.g:4749:1: ( ( rule__CallRule__Group_2__0 )? )
            {
            // InternalOptimisationLanguage.g:4749:1: ( ( rule__CallRule__Group_2__0 )? )
            // InternalOptimisationLanguage.g:4750:2: ( rule__CallRule__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getGroup_2()); 
            }
            // InternalOptimisationLanguage.g:4751:2: ( rule__CallRule__Group_2__0 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( ((LA36_0>=RULE_QUOTED_ID && LA36_0<=RULE_STRING)||LA36_0==15||(LA36_0>=22 && LA36_0<=23)||LA36_0==70||LA36_0==72||(LA36_0>=74 && LA36_0<=78)||(LA36_0>=93 && LA36_0<=94)) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalOptimisationLanguage.g:4751:3: rule__CallRule__Group_2__0
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
    // InternalOptimisationLanguage.g:4759:1: rule__CallRule__Group__3 : rule__CallRule__Group__3__Impl ;
    public final void rule__CallRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4763:1: ( rule__CallRule__Group__3__Impl )
            // InternalOptimisationLanguage.g:4764:2: rule__CallRule__Group__3__Impl
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
    // InternalOptimisationLanguage.g:4770:1: rule__CallRule__Group__3__Impl : ( ')' ) ;
    public final void rule__CallRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4774:1: ( ( ')' ) )
            // InternalOptimisationLanguage.g:4775:1: ( ')' )
            {
            // InternalOptimisationLanguage.g:4775:1: ( ')' )
            // InternalOptimisationLanguage.g:4776:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getRightParenthesisKeyword_3()); 
            }
            match(input,73,FOLLOW_2); if (state.failed) return ;
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
    // InternalOptimisationLanguage.g:4786:1: rule__CallRule__Group_2__0 : rule__CallRule__Group_2__0__Impl rule__CallRule__Group_2__1 ;
    public final void rule__CallRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4790:1: ( rule__CallRule__Group_2__0__Impl rule__CallRule__Group_2__1 )
            // InternalOptimisationLanguage.g:4791:2: rule__CallRule__Group_2__0__Impl rule__CallRule__Group_2__1
            {
            pushFollow(FOLLOW_40);
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
    // InternalOptimisationLanguage.g:4798:1: rule__CallRule__Group_2__0__Impl : ( ( rule__CallRule__ParametersAssignment_2_0 ) ) ;
    public final void rule__CallRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4802:1: ( ( ( rule__CallRule__ParametersAssignment_2_0 ) ) )
            // InternalOptimisationLanguage.g:4803:1: ( ( rule__CallRule__ParametersAssignment_2_0 ) )
            {
            // InternalOptimisationLanguage.g:4803:1: ( ( rule__CallRule__ParametersAssignment_2_0 ) )
            // InternalOptimisationLanguage.g:4804:2: ( rule__CallRule__ParametersAssignment_2_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getParametersAssignment_2_0()); 
            }
            // InternalOptimisationLanguage.g:4805:2: ( rule__CallRule__ParametersAssignment_2_0 )
            // InternalOptimisationLanguage.g:4805:3: rule__CallRule__ParametersAssignment_2_0
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
    // InternalOptimisationLanguage.g:4813:1: rule__CallRule__Group_2__1 : rule__CallRule__Group_2__1__Impl ;
    public final void rule__CallRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4817:1: ( rule__CallRule__Group_2__1__Impl )
            // InternalOptimisationLanguage.g:4818:2: rule__CallRule__Group_2__1__Impl
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
    // InternalOptimisationLanguage.g:4824:1: rule__CallRule__Group_2__1__Impl : ( ( rule__CallRule__Group_2_1__0 )* ) ;
    public final void rule__CallRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4828:1: ( ( ( rule__CallRule__Group_2_1__0 )* ) )
            // InternalOptimisationLanguage.g:4829:1: ( ( rule__CallRule__Group_2_1__0 )* )
            {
            // InternalOptimisationLanguage.g:4829:1: ( ( rule__CallRule__Group_2_1__0 )* )
            // InternalOptimisationLanguage.g:4830:2: ( rule__CallRule__Group_2_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getGroup_2_1()); 
            }
            // InternalOptimisationLanguage.g:4831:2: ( rule__CallRule__Group_2_1__0 )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==56) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:4831:3: rule__CallRule__Group_2_1__0
            	    {
            	    pushFollow(FOLLOW_12);
            	    rule__CallRule__Group_2_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop37;
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
    // InternalOptimisationLanguage.g:4840:1: rule__CallRule__Group_2_1__0 : rule__CallRule__Group_2_1__0__Impl rule__CallRule__Group_2_1__1 ;
    public final void rule__CallRule__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4844:1: ( rule__CallRule__Group_2_1__0__Impl rule__CallRule__Group_2_1__1 )
            // InternalOptimisationLanguage.g:4845:2: rule__CallRule__Group_2_1__0__Impl rule__CallRule__Group_2_1__1
            {
            pushFollow(FOLLOW_27);
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
    // InternalOptimisationLanguage.g:4852:1: rule__CallRule__Group_2_1__0__Impl : ( ',' ) ;
    public final void rule__CallRule__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4856:1: ( ( ',' ) )
            // InternalOptimisationLanguage.g:4857:1: ( ',' )
            {
            // InternalOptimisationLanguage.g:4857:1: ( ',' )
            // InternalOptimisationLanguage.g:4858:2: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getCommaKeyword_2_1_0()); 
            }
            match(input,56,FOLLOW_2); if (state.failed) return ;
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
    // InternalOptimisationLanguage.g:4867:1: rule__CallRule__Group_2_1__1 : rule__CallRule__Group_2_1__1__Impl ;
    public final void rule__CallRule__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4871:1: ( rule__CallRule__Group_2_1__1__Impl )
            // InternalOptimisationLanguage.g:4872:2: rule__CallRule__Group_2_1__1__Impl
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
    // InternalOptimisationLanguage.g:4878:1: rule__CallRule__Group_2_1__1__Impl : ( ( rule__CallRule__ParametersAssignment_2_1_1 ) ) ;
    public final void rule__CallRule__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4882:1: ( ( ( rule__CallRule__ParametersAssignment_2_1_1 ) ) )
            // InternalOptimisationLanguage.g:4883:1: ( ( rule__CallRule__ParametersAssignment_2_1_1 ) )
            {
            // InternalOptimisationLanguage.g:4883:1: ( ( rule__CallRule__ParametersAssignment_2_1_1 ) )
            // InternalOptimisationLanguage.g:4884:2: ( rule__CallRule__ParametersAssignment_2_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getParametersAssignment_2_1_1()); 
            }
            // InternalOptimisationLanguage.g:4885:2: ( rule__CallRule__ParametersAssignment_2_1_1 )
            // InternalOptimisationLanguage.g:4885:3: rule__CallRule__ParametersAssignment_2_1_1
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


    // $ANTLR start "rule__SelfReferenceRule__Group_0__0"
    // InternalOptimisationLanguage.g:4894:1: rule__SelfReferenceRule__Group_0__0 : rule__SelfReferenceRule__Group_0__0__Impl rule__SelfReferenceRule__Group_0__1 ;
    public final void rule__SelfReferenceRule__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4898:1: ( rule__SelfReferenceRule__Group_0__0__Impl rule__SelfReferenceRule__Group_0__1 )
            // InternalOptimisationLanguage.g:4899:2: rule__SelfReferenceRule__Group_0__0__Impl rule__SelfReferenceRule__Group_0__1
            {
            pushFollow(FOLLOW_44);
            rule__SelfReferenceRule__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__SelfReferenceRule__Group_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelfReferenceRule__Group_0__0"


    // $ANTLR start "rule__SelfReferenceRule__Group_0__0__Impl"
    // InternalOptimisationLanguage.g:4906:1: rule__SelfReferenceRule__Group_0__0__Impl : ( () ) ;
    public final void rule__SelfReferenceRule__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4910:1: ( ( () ) )
            // InternalOptimisationLanguage.g:4911:1: ( () )
            {
            // InternalOptimisationLanguage.g:4911:1: ( () )
            // InternalOptimisationLanguage.g:4912:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSelfReferenceRuleAccess().getSelfReferenceAction_0_0()); 
            }
            // InternalOptimisationLanguage.g:4913:2: ()
            // InternalOptimisationLanguage.g:4913:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSelfReferenceRuleAccess().getSelfReferenceAction_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelfReferenceRule__Group_0__0__Impl"


    // $ANTLR start "rule__SelfReferenceRule__Group_0__1"
    // InternalOptimisationLanguage.g:4921:1: rule__SelfReferenceRule__Group_0__1 : rule__SelfReferenceRule__Group_0__1__Impl ;
    public final void rule__SelfReferenceRule__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4925:1: ( rule__SelfReferenceRule__Group_0__1__Impl )
            // InternalOptimisationLanguage.g:4926:2: rule__SelfReferenceRule__Group_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SelfReferenceRule__Group_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelfReferenceRule__Group_0__1"


    // $ANTLR start "rule__SelfReferenceRule__Group_0__1__Impl"
    // InternalOptimisationLanguage.g:4932:1: rule__SelfReferenceRule__Group_0__1__Impl : ( 'self' ) ;
    public final void rule__SelfReferenceRule__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4936:1: ( ( 'self' ) )
            // InternalOptimisationLanguage.g:4937:1: ( 'self' )
            {
            // InternalOptimisationLanguage.g:4937:1: ( 'self' )
            // InternalOptimisationLanguage.g:4938:2: 'self'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSelfReferenceRuleAccess().getSelfKeyword_0_1()); 
            }
            match(input,74,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSelfReferenceRuleAccess().getSelfKeyword_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelfReferenceRule__Group_0__1__Impl"


    // $ANTLR start "rule__SelfReferenceRule__Group_1__0"
    // InternalOptimisationLanguage.g:4948:1: rule__SelfReferenceRule__Group_1__0 : rule__SelfReferenceRule__Group_1__0__Impl rule__SelfReferenceRule__Group_1__1 ;
    public final void rule__SelfReferenceRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4952:1: ( rule__SelfReferenceRule__Group_1__0__Impl rule__SelfReferenceRule__Group_1__1 )
            // InternalOptimisationLanguage.g:4953:2: rule__SelfReferenceRule__Group_1__0__Impl rule__SelfReferenceRule__Group_1__1
            {
            pushFollow(FOLLOW_27);
            rule__SelfReferenceRule__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__SelfReferenceRule__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelfReferenceRule__Group_1__0"


    // $ANTLR start "rule__SelfReferenceRule__Group_1__0__Impl"
    // InternalOptimisationLanguage.g:4960:1: rule__SelfReferenceRule__Group_1__0__Impl : ( () ) ;
    public final void rule__SelfReferenceRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4964:1: ( ( () ) )
            // InternalOptimisationLanguage.g:4965:1: ( () )
            {
            // InternalOptimisationLanguage.g:4965:1: ( () )
            // InternalOptimisationLanguage.g:4966:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSelfReferenceRuleAccess().getSelfReferenceAction_1_0()); 
            }
            // InternalOptimisationLanguage.g:4967:2: ()
            // InternalOptimisationLanguage.g:4967:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSelfReferenceRuleAccess().getSelfReferenceAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelfReferenceRule__Group_1__0__Impl"


    // $ANTLR start "rule__SelfReferenceRule__Group_1__1"
    // InternalOptimisationLanguage.g:4975:1: rule__SelfReferenceRule__Group_1__1 : rule__SelfReferenceRule__Group_1__1__Impl ;
    public final void rule__SelfReferenceRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4979:1: ( rule__SelfReferenceRule__Group_1__1__Impl )
            // InternalOptimisationLanguage.g:4980:2: rule__SelfReferenceRule__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SelfReferenceRule__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelfReferenceRule__Group_1__1"


    // $ANTLR start "rule__SelfReferenceRule__Group_1__1__Impl"
    // InternalOptimisationLanguage.g:4986:1: rule__SelfReferenceRule__Group_1__1__Impl : ( 'value' ) ;
    public final void rule__SelfReferenceRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4990:1: ( ( 'value' ) )
            // InternalOptimisationLanguage.g:4991:1: ( 'value' )
            {
            // InternalOptimisationLanguage.g:4991:1: ( 'value' )
            // InternalOptimisationLanguage.g:4992:2: 'value'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSelfReferenceRuleAccess().getValueKeyword_1_1()); 
            }
            match(input,75,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSelfReferenceRuleAccess().getValueKeyword_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelfReferenceRule__Group_1__1__Impl"


    // $ANTLR start "rule__AttributeReferenceRule__Group__0"
    // InternalOptimisationLanguage.g:5002:1: rule__AttributeReferenceRule__Group__0 : rule__AttributeReferenceRule__Group__0__Impl rule__AttributeReferenceRule__Group__1 ;
    public final void rule__AttributeReferenceRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5006:1: ( rule__AttributeReferenceRule__Group__0__Impl rule__AttributeReferenceRule__Group__1 )
            // InternalOptimisationLanguage.g:5007:2: rule__AttributeReferenceRule__Group__0__Impl rule__AttributeReferenceRule__Group__1
            {
            pushFollow(FOLLOW_18);
            rule__AttributeReferenceRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__AttributeReferenceRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeReferenceRule__Group__0"


    // $ANTLR start "rule__AttributeReferenceRule__Group__0__Impl"
    // InternalOptimisationLanguage.g:5014:1: rule__AttributeReferenceRule__Group__0__Impl : ( ( rule__AttributeReferenceRule__SelfAssignment_0 ) ) ;
    public final void rule__AttributeReferenceRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5018:1: ( ( ( rule__AttributeReferenceRule__SelfAssignment_0 ) ) )
            // InternalOptimisationLanguage.g:5019:1: ( ( rule__AttributeReferenceRule__SelfAssignment_0 ) )
            {
            // InternalOptimisationLanguage.g:5019:1: ( ( rule__AttributeReferenceRule__SelfAssignment_0 ) )
            // InternalOptimisationLanguage.g:5020:2: ( rule__AttributeReferenceRule__SelfAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeReferenceRuleAccess().getSelfAssignment_0()); 
            }
            // InternalOptimisationLanguage.g:5021:2: ( rule__AttributeReferenceRule__SelfAssignment_0 )
            // InternalOptimisationLanguage.g:5021:3: rule__AttributeReferenceRule__SelfAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__AttributeReferenceRule__SelfAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeReferenceRuleAccess().getSelfAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeReferenceRule__Group__0__Impl"


    // $ANTLR start "rule__AttributeReferenceRule__Group__1"
    // InternalOptimisationLanguage.g:5029:1: rule__AttributeReferenceRule__Group__1 : rule__AttributeReferenceRule__Group__1__Impl ;
    public final void rule__AttributeReferenceRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5033:1: ( rule__AttributeReferenceRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:5034:2: rule__AttributeReferenceRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AttributeReferenceRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeReferenceRule__Group__1"


    // $ANTLR start "rule__AttributeReferenceRule__Group__1__Impl"
    // InternalOptimisationLanguage.g:5040:1: rule__AttributeReferenceRule__Group__1__Impl : ( ( rule__AttributeReferenceRule__Group_1__0 )* ) ;
    public final void rule__AttributeReferenceRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5044:1: ( ( ( rule__AttributeReferenceRule__Group_1__0 )* ) )
            // InternalOptimisationLanguage.g:5045:1: ( ( rule__AttributeReferenceRule__Group_1__0 )* )
            {
            // InternalOptimisationLanguage.g:5045:1: ( ( rule__AttributeReferenceRule__Group_1__0 )* )
            // InternalOptimisationLanguage.g:5046:2: ( rule__AttributeReferenceRule__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeReferenceRuleAccess().getGroup_1()); 
            }
            // InternalOptimisationLanguage.g:5047:2: ( rule__AttributeReferenceRule__Group_1__0 )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==58) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:5047:3: rule__AttributeReferenceRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_45);
            	    rule__AttributeReferenceRule__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeReferenceRuleAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeReferenceRule__Group__1__Impl"


    // $ANTLR start "rule__AttributeReferenceRule__Group_1__0"
    // InternalOptimisationLanguage.g:5056:1: rule__AttributeReferenceRule__Group_1__0 : rule__AttributeReferenceRule__Group_1__0__Impl rule__AttributeReferenceRule__Group_1__1 ;
    public final void rule__AttributeReferenceRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5060:1: ( rule__AttributeReferenceRule__Group_1__0__Impl rule__AttributeReferenceRule__Group_1__1 )
            // InternalOptimisationLanguage.g:5061:2: rule__AttributeReferenceRule__Group_1__0__Impl rule__AttributeReferenceRule__Group_1__1
            {
            pushFollow(FOLLOW_5);
            rule__AttributeReferenceRule__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__AttributeReferenceRule__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeReferenceRule__Group_1__0"


    // $ANTLR start "rule__AttributeReferenceRule__Group_1__0__Impl"
    // InternalOptimisationLanguage.g:5068:1: rule__AttributeReferenceRule__Group_1__0__Impl : ( '.' ) ;
    public final void rule__AttributeReferenceRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5072:1: ( ( '.' ) )
            // InternalOptimisationLanguage.g:5073:1: ( '.' )
            {
            // InternalOptimisationLanguage.g:5073:1: ( '.' )
            // InternalOptimisationLanguage.g:5074:2: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeReferenceRuleAccess().getFullStopKeyword_1_0()); 
            }
            match(input,58,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeReferenceRuleAccess().getFullStopKeyword_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeReferenceRule__Group_1__0__Impl"


    // $ANTLR start "rule__AttributeReferenceRule__Group_1__1"
    // InternalOptimisationLanguage.g:5083:1: rule__AttributeReferenceRule__Group_1__1 : rule__AttributeReferenceRule__Group_1__1__Impl ;
    public final void rule__AttributeReferenceRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5087:1: ( rule__AttributeReferenceRule__Group_1__1__Impl )
            // InternalOptimisationLanguage.g:5088:2: rule__AttributeReferenceRule__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AttributeReferenceRule__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeReferenceRule__Group_1__1"


    // $ANTLR start "rule__AttributeReferenceRule__Group_1__1__Impl"
    // InternalOptimisationLanguage.g:5094:1: rule__AttributeReferenceRule__Group_1__1__Impl : ( ( rule__AttributeReferenceRule__ChainAssignment_1_1 ) ) ;
    public final void rule__AttributeReferenceRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5098:1: ( ( ( rule__AttributeReferenceRule__ChainAssignment_1_1 ) ) )
            // InternalOptimisationLanguage.g:5099:1: ( ( rule__AttributeReferenceRule__ChainAssignment_1_1 ) )
            {
            // InternalOptimisationLanguage.g:5099:1: ( ( rule__AttributeReferenceRule__ChainAssignment_1_1 ) )
            // InternalOptimisationLanguage.g:5100:2: ( rule__AttributeReferenceRule__ChainAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeReferenceRuleAccess().getChainAssignment_1_1()); 
            }
            // InternalOptimisationLanguage.g:5101:2: ( rule__AttributeReferenceRule__ChainAssignment_1_1 )
            // InternalOptimisationLanguage.g:5101:3: rule__AttributeReferenceRule__ChainAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__AttributeReferenceRule__ChainAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeReferenceRuleAccess().getChainAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeReferenceRule__Group_1__1__Impl"


    // $ANTLR start "rule__ConfigurationReferenceRule__Group__0"
    // InternalOptimisationLanguage.g:5110:1: rule__ConfigurationReferenceRule__Group__0 : rule__ConfigurationReferenceRule__Group__0__Impl rule__ConfigurationReferenceRule__Group__1 ;
    public final void rule__ConfigurationReferenceRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5114:1: ( rule__ConfigurationReferenceRule__Group__0__Impl rule__ConfigurationReferenceRule__Group__1 )
            // InternalOptimisationLanguage.g:5115:2: rule__ConfigurationReferenceRule__Group__0__Impl rule__ConfigurationReferenceRule__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__ConfigurationReferenceRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ConfigurationReferenceRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigurationReferenceRule__Group__0"


    // $ANTLR start "rule__ConfigurationReferenceRule__Group__0__Impl"
    // InternalOptimisationLanguage.g:5122:1: rule__ConfigurationReferenceRule__Group__0__Impl : ( 'tree' ) ;
    public final void rule__ConfigurationReferenceRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5126:1: ( ( 'tree' ) )
            // InternalOptimisationLanguage.g:5127:1: ( 'tree' )
            {
            // InternalOptimisationLanguage.g:5127:1: ( 'tree' )
            // InternalOptimisationLanguage.g:5128:2: 'tree'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigurationReferenceRuleAccess().getTreeKeyword_0()); 
            }
            match(input,76,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConfigurationReferenceRuleAccess().getTreeKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigurationReferenceRule__Group__0__Impl"


    // $ANTLR start "rule__ConfigurationReferenceRule__Group__1"
    // InternalOptimisationLanguage.g:5137:1: rule__ConfigurationReferenceRule__Group__1 : rule__ConfigurationReferenceRule__Group__1__Impl ;
    public final void rule__ConfigurationReferenceRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5141:1: ( rule__ConfigurationReferenceRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:5142:2: rule__ConfigurationReferenceRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ConfigurationReferenceRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigurationReferenceRule__Group__1"


    // $ANTLR start "rule__ConfigurationReferenceRule__Group__1__Impl"
    // InternalOptimisationLanguage.g:5148:1: rule__ConfigurationReferenceRule__Group__1__Impl : ( ( rule__ConfigurationReferenceRule__ReferenceAssignment_1 ) ) ;
    public final void rule__ConfigurationReferenceRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5152:1: ( ( ( rule__ConfigurationReferenceRule__ReferenceAssignment_1 ) ) )
            // InternalOptimisationLanguage.g:5153:1: ( ( rule__ConfigurationReferenceRule__ReferenceAssignment_1 ) )
            {
            // InternalOptimisationLanguage.g:5153:1: ( ( rule__ConfigurationReferenceRule__ReferenceAssignment_1 ) )
            // InternalOptimisationLanguage.g:5154:2: ( rule__ConfigurationReferenceRule__ReferenceAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigurationReferenceRuleAccess().getReferenceAssignment_1()); 
            }
            // InternalOptimisationLanguage.g:5155:2: ( rule__ConfigurationReferenceRule__ReferenceAssignment_1 )
            // InternalOptimisationLanguage.g:5155:3: rule__ConfigurationReferenceRule__ReferenceAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__ConfigurationReferenceRule__ReferenceAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getConfigurationReferenceRuleAccess().getReferenceAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigurationReferenceRule__Group__1__Impl"


    // $ANTLR start "rule__BaseDataReferenceRule__Group__0"
    // InternalOptimisationLanguage.g:5164:1: rule__BaseDataReferenceRule__Group__0 : rule__BaseDataReferenceRule__Group__0__Impl rule__BaseDataReferenceRule__Group__1 ;
    public final void rule__BaseDataReferenceRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5168:1: ( rule__BaseDataReferenceRule__Group__0__Impl rule__BaseDataReferenceRule__Group__1 )
            // InternalOptimisationLanguage.g:5169:2: rule__BaseDataReferenceRule__Group__0__Impl rule__BaseDataReferenceRule__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__BaseDataReferenceRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__BaseDataReferenceRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BaseDataReferenceRule__Group__0"


    // $ANTLR start "rule__BaseDataReferenceRule__Group__0__Impl"
    // InternalOptimisationLanguage.g:5176:1: rule__BaseDataReferenceRule__Group__0__Impl : ( 'data' ) ;
    public final void rule__BaseDataReferenceRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5180:1: ( ( 'data' ) )
            // InternalOptimisationLanguage.g:5181:1: ( 'data' )
            {
            // InternalOptimisationLanguage.g:5181:1: ( 'data' )
            // InternalOptimisationLanguage.g:5182:2: 'data'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBaseDataReferenceRuleAccess().getDataKeyword_0()); 
            }
            match(input,77,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBaseDataReferenceRuleAccess().getDataKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BaseDataReferenceRule__Group__0__Impl"


    // $ANTLR start "rule__BaseDataReferenceRule__Group__1"
    // InternalOptimisationLanguage.g:5191:1: rule__BaseDataReferenceRule__Group__1 : rule__BaseDataReferenceRule__Group__1__Impl ;
    public final void rule__BaseDataReferenceRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5195:1: ( rule__BaseDataReferenceRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:5196:2: rule__BaseDataReferenceRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__BaseDataReferenceRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BaseDataReferenceRule__Group__1"


    // $ANTLR start "rule__BaseDataReferenceRule__Group__1__Impl"
    // InternalOptimisationLanguage.g:5202:1: rule__BaseDataReferenceRule__Group__1__Impl : ( ( rule__BaseDataReferenceRule__DefinitionAssignment_1 ) ) ;
    public final void rule__BaseDataReferenceRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5206:1: ( ( ( rule__BaseDataReferenceRule__DefinitionAssignment_1 ) ) )
            // InternalOptimisationLanguage.g:5207:1: ( ( rule__BaseDataReferenceRule__DefinitionAssignment_1 ) )
            {
            // InternalOptimisationLanguage.g:5207:1: ( ( rule__BaseDataReferenceRule__DefinitionAssignment_1 ) )
            // InternalOptimisationLanguage.g:5208:2: ( rule__BaseDataReferenceRule__DefinitionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBaseDataReferenceRuleAccess().getDefinitionAssignment_1()); 
            }
            // InternalOptimisationLanguage.g:5209:2: ( rule__BaseDataReferenceRule__DefinitionAssignment_1 )
            // InternalOptimisationLanguage.g:5209:3: rule__BaseDataReferenceRule__DefinitionAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__BaseDataReferenceRule__DefinitionAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBaseDataReferenceRuleAccess().getDefinitionAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BaseDataReferenceRule__Group__1__Impl"


    // $ANTLR start "rule__StructuredDataDescriptionReferenceRule__Group__0"
    // InternalOptimisationLanguage.g:5218:1: rule__StructuredDataDescriptionReferenceRule__Group__0 : rule__StructuredDataDescriptionReferenceRule__Group__0__Impl rule__StructuredDataDescriptionReferenceRule__Group__1 ;
    public final void rule__StructuredDataDescriptionReferenceRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5222:1: ( rule__StructuredDataDescriptionReferenceRule__Group__0__Impl rule__StructuredDataDescriptionReferenceRule__Group__1 )
            // InternalOptimisationLanguage.g:5223:2: rule__StructuredDataDescriptionReferenceRule__Group__0__Impl rule__StructuredDataDescriptionReferenceRule__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__StructuredDataDescriptionReferenceRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__StructuredDataDescriptionReferenceRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StructuredDataDescriptionReferenceRule__Group__0"


    // $ANTLR start "rule__StructuredDataDescriptionReferenceRule__Group__0__Impl"
    // InternalOptimisationLanguage.g:5230:1: rule__StructuredDataDescriptionReferenceRule__Group__0__Impl : ( 'instance' ) ;
    public final void rule__StructuredDataDescriptionReferenceRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5234:1: ( ( 'instance' ) )
            // InternalOptimisationLanguage.g:5235:1: ( 'instance' )
            {
            // InternalOptimisationLanguage.g:5235:1: ( 'instance' )
            // InternalOptimisationLanguage.g:5236:2: 'instance'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStructuredDataDescriptionReferenceRuleAccess().getInstanceKeyword_0()); 
            }
            match(input,78,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getStructuredDataDescriptionReferenceRuleAccess().getInstanceKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StructuredDataDescriptionReferenceRule__Group__0__Impl"


    // $ANTLR start "rule__StructuredDataDescriptionReferenceRule__Group__1"
    // InternalOptimisationLanguage.g:5245:1: rule__StructuredDataDescriptionReferenceRule__Group__1 : rule__StructuredDataDescriptionReferenceRule__Group__1__Impl ;
    public final void rule__StructuredDataDescriptionReferenceRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5249:1: ( rule__StructuredDataDescriptionReferenceRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:5250:2: rule__StructuredDataDescriptionReferenceRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__StructuredDataDescriptionReferenceRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StructuredDataDescriptionReferenceRule__Group__1"


    // $ANTLR start "rule__StructuredDataDescriptionReferenceRule__Group__1__Impl"
    // InternalOptimisationLanguage.g:5256:1: rule__StructuredDataDescriptionReferenceRule__Group__1__Impl : ( ( rule__StructuredDataDescriptionReferenceRule__DefinitionAssignment_1 ) ) ;
    public final void rule__StructuredDataDescriptionReferenceRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5260:1: ( ( ( rule__StructuredDataDescriptionReferenceRule__DefinitionAssignment_1 ) ) )
            // InternalOptimisationLanguage.g:5261:1: ( ( rule__StructuredDataDescriptionReferenceRule__DefinitionAssignment_1 ) )
            {
            // InternalOptimisationLanguage.g:5261:1: ( ( rule__StructuredDataDescriptionReferenceRule__DefinitionAssignment_1 ) )
            // InternalOptimisationLanguage.g:5262:2: ( rule__StructuredDataDescriptionReferenceRule__DefinitionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStructuredDataDescriptionReferenceRuleAccess().getDefinitionAssignment_1()); 
            }
            // InternalOptimisationLanguage.g:5263:2: ( rule__StructuredDataDescriptionReferenceRule__DefinitionAssignment_1 )
            // InternalOptimisationLanguage.g:5263:3: rule__StructuredDataDescriptionReferenceRule__DefinitionAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__StructuredDataDescriptionReferenceRule__DefinitionAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getStructuredDataDescriptionReferenceRuleAccess().getDefinitionAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StructuredDataDescriptionReferenceRule__Group__1__Impl"


    // $ANTLR start "rule__InstanceLiteralRule__Group__0"
    // InternalOptimisationLanguage.g:5272:1: rule__InstanceLiteralRule__Group__0 : rule__InstanceLiteralRule__Group__0__Impl rule__InstanceLiteralRule__Group__1 ;
    public final void rule__InstanceLiteralRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5276:1: ( rule__InstanceLiteralRule__Group__0__Impl rule__InstanceLiteralRule__Group__1 )
            // InternalOptimisationLanguage.g:5277:2: rule__InstanceLiteralRule__Group__0__Impl rule__InstanceLiteralRule__Group__1
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
    // InternalOptimisationLanguage.g:5284:1: rule__InstanceLiteralRule__Group__0__Impl : ( ( rule__InstanceLiteralRule__DefinitionAssignment_0 ) ) ;
    public final void rule__InstanceLiteralRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5288:1: ( ( ( rule__InstanceLiteralRule__DefinitionAssignment_0 ) ) )
            // InternalOptimisationLanguage.g:5289:1: ( ( rule__InstanceLiteralRule__DefinitionAssignment_0 ) )
            {
            // InternalOptimisationLanguage.g:5289:1: ( ( rule__InstanceLiteralRule__DefinitionAssignment_0 ) )
            // InternalOptimisationLanguage.g:5290:2: ( rule__InstanceLiteralRule__DefinitionAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceLiteralRuleAccess().getDefinitionAssignment_0()); 
            }
            // InternalOptimisationLanguage.g:5291:2: ( rule__InstanceLiteralRule__DefinitionAssignment_0 )
            // InternalOptimisationLanguage.g:5291:3: rule__InstanceLiteralRule__DefinitionAssignment_0
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
    // InternalOptimisationLanguage.g:5299:1: rule__InstanceLiteralRule__Group__1 : rule__InstanceLiteralRule__Group__1__Impl rule__InstanceLiteralRule__Group__2 ;
    public final void rule__InstanceLiteralRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5303:1: ( rule__InstanceLiteralRule__Group__1__Impl rule__InstanceLiteralRule__Group__2 )
            // InternalOptimisationLanguage.g:5304:2: rule__InstanceLiteralRule__Group__1__Impl rule__InstanceLiteralRule__Group__2
            {
            pushFollow(FOLLOW_46);
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
    // InternalOptimisationLanguage.g:5311:1: rule__InstanceLiteralRule__Group__1__Impl : ( '{' ) ;
    public final void rule__InstanceLiteralRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5315:1: ( ( '{' ) )
            // InternalOptimisationLanguage.g:5316:1: ( '{' )
            {
            // InternalOptimisationLanguage.g:5316:1: ( '{' )
            // InternalOptimisationLanguage.g:5317:2: '{'
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
    // InternalOptimisationLanguage.g:5326:1: rule__InstanceLiteralRule__Group__2 : rule__InstanceLiteralRule__Group__2__Impl rule__InstanceLiteralRule__Group__3 ;
    public final void rule__InstanceLiteralRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5330:1: ( rule__InstanceLiteralRule__Group__2__Impl rule__InstanceLiteralRule__Group__3 )
            // InternalOptimisationLanguage.g:5331:2: rule__InstanceLiteralRule__Group__2__Impl rule__InstanceLiteralRule__Group__3
            {
            pushFollow(FOLLOW_46);
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
    // InternalOptimisationLanguage.g:5338:1: rule__InstanceLiteralRule__Group__2__Impl : ( ( rule__InstanceLiteralRule__AttributesAssignment_2 )* ) ;
    public final void rule__InstanceLiteralRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5342:1: ( ( ( rule__InstanceLiteralRule__AttributesAssignment_2 )* ) )
            // InternalOptimisationLanguage.g:5343:1: ( ( rule__InstanceLiteralRule__AttributesAssignment_2 )* )
            {
            // InternalOptimisationLanguage.g:5343:1: ( ( rule__InstanceLiteralRule__AttributesAssignment_2 )* )
            // InternalOptimisationLanguage.g:5344:2: ( rule__InstanceLiteralRule__AttributesAssignment_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceLiteralRuleAccess().getAttributesAssignment_2()); 
            }
            // InternalOptimisationLanguage.g:5345:2: ( rule__InstanceLiteralRule__AttributesAssignment_2 )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( ((LA39_0>=RULE_QUOTED_ID && LA39_0<=RULE_ID)) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:5345:3: rule__InstanceLiteralRule__AttributesAssignment_2
            	    {
            	    pushFollow(FOLLOW_22);
            	    rule__InstanceLiteralRule__AttributesAssignment_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop39;
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
    // InternalOptimisationLanguage.g:5353:1: rule__InstanceLiteralRule__Group__3 : rule__InstanceLiteralRule__Group__3__Impl ;
    public final void rule__InstanceLiteralRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5357:1: ( rule__InstanceLiteralRule__Group__3__Impl )
            // InternalOptimisationLanguage.g:5358:2: rule__InstanceLiteralRule__Group__3__Impl
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
    // InternalOptimisationLanguage.g:5364:1: rule__InstanceLiteralRule__Group__3__Impl : ( '}' ) ;
    public final void rule__InstanceLiteralRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5368:1: ( ( '}' ) )
            // InternalOptimisationLanguage.g:5369:1: ( '}' )
            {
            // InternalOptimisationLanguage.g:5369:1: ( '}' )
            // InternalOptimisationLanguage.g:5370:2: '}'
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
    // InternalOptimisationLanguage.g:5380:1: rule__AttributeRule__Group__0 : rule__AttributeRule__Group__0__Impl rule__AttributeRule__Group__1 ;
    public final void rule__AttributeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5384:1: ( rule__AttributeRule__Group__0__Impl rule__AttributeRule__Group__1 )
            // InternalOptimisationLanguage.g:5385:2: rule__AttributeRule__Group__0__Impl rule__AttributeRule__Group__1
            {
            pushFollow(FOLLOW_23);
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
    // InternalOptimisationLanguage.g:5392:1: rule__AttributeRule__Group__0__Impl : ( ( rule__AttributeRule__DefinitionAssignment_0 ) ) ;
    public final void rule__AttributeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5396:1: ( ( ( rule__AttributeRule__DefinitionAssignment_0 ) ) )
            // InternalOptimisationLanguage.g:5397:1: ( ( rule__AttributeRule__DefinitionAssignment_0 ) )
            {
            // InternalOptimisationLanguage.g:5397:1: ( ( rule__AttributeRule__DefinitionAssignment_0 ) )
            // InternalOptimisationLanguage.g:5398:2: ( rule__AttributeRule__DefinitionAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeRuleAccess().getDefinitionAssignment_0()); 
            }
            // InternalOptimisationLanguage.g:5399:2: ( rule__AttributeRule__DefinitionAssignment_0 )
            // InternalOptimisationLanguage.g:5399:3: rule__AttributeRule__DefinitionAssignment_0
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
    // InternalOptimisationLanguage.g:5407:1: rule__AttributeRule__Group__1 : rule__AttributeRule__Group__1__Impl rule__AttributeRule__Group__2 ;
    public final void rule__AttributeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5411:1: ( rule__AttributeRule__Group__1__Impl rule__AttributeRule__Group__2 )
            // InternalOptimisationLanguage.g:5412:2: rule__AttributeRule__Group__1__Impl rule__AttributeRule__Group__2
            {
            pushFollow(FOLLOW_27);
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
    // InternalOptimisationLanguage.g:5419:1: rule__AttributeRule__Group__1__Impl : ( ':=' ) ;
    public final void rule__AttributeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5423:1: ( ( ':=' ) )
            // InternalOptimisationLanguage.g:5424:1: ( ':=' )
            {
            // InternalOptimisationLanguage.g:5424:1: ( ':=' )
            // InternalOptimisationLanguage.g:5425:2: ':='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeRuleAccess().getColonEqualsSignKeyword_1()); 
            }
            match(input,64,FOLLOW_2); if (state.failed) return ;
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
    // InternalOptimisationLanguage.g:5434:1: rule__AttributeRule__Group__2 : rule__AttributeRule__Group__2__Impl rule__AttributeRule__Group__3 ;
    public final void rule__AttributeRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5438:1: ( rule__AttributeRule__Group__2__Impl rule__AttributeRule__Group__3 )
            // InternalOptimisationLanguage.g:5439:2: rule__AttributeRule__Group__2__Impl rule__AttributeRule__Group__3
            {
            pushFollow(FOLLOW_24);
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
    // InternalOptimisationLanguage.g:5446:1: rule__AttributeRule__Group__2__Impl : ( ( rule__AttributeRule__ValueAssignment_2 ) ) ;
    public final void rule__AttributeRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5450:1: ( ( ( rule__AttributeRule__ValueAssignment_2 ) ) )
            // InternalOptimisationLanguage.g:5451:1: ( ( rule__AttributeRule__ValueAssignment_2 ) )
            {
            // InternalOptimisationLanguage.g:5451:1: ( ( rule__AttributeRule__ValueAssignment_2 ) )
            // InternalOptimisationLanguage.g:5452:2: ( rule__AttributeRule__ValueAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeRuleAccess().getValueAssignment_2()); 
            }
            // InternalOptimisationLanguage.g:5453:2: ( rule__AttributeRule__ValueAssignment_2 )
            // InternalOptimisationLanguage.g:5453:3: rule__AttributeRule__ValueAssignment_2
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
    // InternalOptimisationLanguage.g:5461:1: rule__AttributeRule__Group__3 : rule__AttributeRule__Group__3__Impl ;
    public final void rule__AttributeRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5465:1: ( rule__AttributeRule__Group__3__Impl )
            // InternalOptimisationLanguage.g:5466:2: rule__AttributeRule__Group__3__Impl
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
    // InternalOptimisationLanguage.g:5472:1: rule__AttributeRule__Group__3__Impl : ( ';' ) ;
    public final void rule__AttributeRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5476:1: ( ( ';' ) )
            // InternalOptimisationLanguage.g:5477:1: ( ';' )
            {
            // InternalOptimisationLanguage.g:5477:1: ( ';' )
            // InternalOptimisationLanguage.g:5478:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeRuleAccess().getSemicolonKeyword_3()); 
            }
            match(input,65,FOLLOW_2); if (state.failed) return ;
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
    // InternalOptimisationLanguage.g:5488:1: rule__RealLiteralRule__Group__0 : rule__RealLiteralRule__Group__0__Impl rule__RealLiteralRule__Group__1 ;
    public final void rule__RealLiteralRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5492:1: ( rule__RealLiteralRule__Group__0__Impl rule__RealLiteralRule__Group__1 )
            // InternalOptimisationLanguage.g:5493:2: rule__RealLiteralRule__Group__0__Impl rule__RealLiteralRule__Group__1
            {
            pushFollow(FOLLOW_47);
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
    // InternalOptimisationLanguage.g:5500:1: rule__RealLiteralRule__Group__0__Impl : ( ( rule__RealLiteralRule__LiteralAssignment_0 ) ) ;
    public final void rule__RealLiteralRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5504:1: ( ( ( rule__RealLiteralRule__LiteralAssignment_0 ) ) )
            // InternalOptimisationLanguage.g:5505:1: ( ( rule__RealLiteralRule__LiteralAssignment_0 ) )
            {
            // InternalOptimisationLanguage.g:5505:1: ( ( rule__RealLiteralRule__LiteralAssignment_0 ) )
            // InternalOptimisationLanguage.g:5506:2: ( rule__RealLiteralRule__LiteralAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealLiteralRuleAccess().getLiteralAssignment_0()); 
            }
            // InternalOptimisationLanguage.g:5507:2: ( rule__RealLiteralRule__LiteralAssignment_0 )
            // InternalOptimisationLanguage.g:5507:3: rule__RealLiteralRule__LiteralAssignment_0
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
    // InternalOptimisationLanguage.g:5515:1: rule__RealLiteralRule__Group__1 : rule__RealLiteralRule__Group__1__Impl ;
    public final void rule__RealLiteralRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5519:1: ( rule__RealLiteralRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:5520:2: rule__RealLiteralRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:5526:1: rule__RealLiteralRule__Group__1__Impl : ( ( rule__RealLiteralRule__FactorAssignment_1 )? ) ;
    public final void rule__RealLiteralRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5530:1: ( ( ( rule__RealLiteralRule__FactorAssignment_1 )? ) )
            // InternalOptimisationLanguage.g:5531:1: ( ( rule__RealLiteralRule__FactorAssignment_1 )? )
            {
            // InternalOptimisationLanguage.g:5531:1: ( ( rule__RealLiteralRule__FactorAssignment_1 )? )
            // InternalOptimisationLanguage.g:5532:2: ( rule__RealLiteralRule__FactorAssignment_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealLiteralRuleAccess().getFactorAssignment_1()); 
            }
            // InternalOptimisationLanguage.g:5533:2: ( rule__RealLiteralRule__FactorAssignment_1 )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( ((LA40_0>=27 && LA40_0<=46)) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalOptimisationLanguage.g:5533:3: rule__RealLiteralRule__FactorAssignment_1
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
    // InternalOptimisationLanguage.g:5542:1: rule__IntegerLiteralRule__Group__0 : rule__IntegerLiteralRule__Group__0__Impl rule__IntegerLiteralRule__Group__1 ;
    public final void rule__IntegerLiteralRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5546:1: ( rule__IntegerLiteralRule__Group__0__Impl rule__IntegerLiteralRule__Group__1 )
            // InternalOptimisationLanguage.g:5547:2: rule__IntegerLiteralRule__Group__0__Impl rule__IntegerLiteralRule__Group__1
            {
            pushFollow(FOLLOW_47);
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
    // InternalOptimisationLanguage.g:5554:1: rule__IntegerLiteralRule__Group__0__Impl : ( ( rule__IntegerLiteralRule__LiteralAssignment_0 ) ) ;
    public final void rule__IntegerLiteralRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5558:1: ( ( ( rule__IntegerLiteralRule__LiteralAssignment_0 ) ) )
            // InternalOptimisationLanguage.g:5559:1: ( ( rule__IntegerLiteralRule__LiteralAssignment_0 ) )
            {
            // InternalOptimisationLanguage.g:5559:1: ( ( rule__IntegerLiteralRule__LiteralAssignment_0 ) )
            // InternalOptimisationLanguage.g:5560:2: ( rule__IntegerLiteralRule__LiteralAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegerLiteralRuleAccess().getLiteralAssignment_0()); 
            }
            // InternalOptimisationLanguage.g:5561:2: ( rule__IntegerLiteralRule__LiteralAssignment_0 )
            // InternalOptimisationLanguage.g:5561:3: rule__IntegerLiteralRule__LiteralAssignment_0
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
    // InternalOptimisationLanguage.g:5569:1: rule__IntegerLiteralRule__Group__1 : rule__IntegerLiteralRule__Group__1__Impl ;
    public final void rule__IntegerLiteralRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5573:1: ( rule__IntegerLiteralRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:5574:2: rule__IntegerLiteralRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:5580:1: rule__IntegerLiteralRule__Group__1__Impl : ( ( rule__IntegerLiteralRule__FactorAssignment_1 )? ) ;
    public final void rule__IntegerLiteralRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5584:1: ( ( ( rule__IntegerLiteralRule__FactorAssignment_1 )? ) )
            // InternalOptimisationLanguage.g:5585:1: ( ( rule__IntegerLiteralRule__FactorAssignment_1 )? )
            {
            // InternalOptimisationLanguage.g:5585:1: ( ( rule__IntegerLiteralRule__FactorAssignment_1 )? )
            // InternalOptimisationLanguage.g:5586:2: ( rule__IntegerLiteralRule__FactorAssignment_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegerLiteralRuleAccess().getFactorAssignment_1()); 
            }
            // InternalOptimisationLanguage.g:5587:2: ( rule__IntegerLiteralRule__FactorAssignment_1 )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( ((LA41_0>=27 && LA41_0<=46)) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalOptimisationLanguage.g:5587:3: rule__IntegerLiteralRule__FactorAssignment_1
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
    // InternalOptimisationLanguage.g:5596:1: rule__BooleanLiteralRule__Group__0 : rule__BooleanLiteralRule__Group__0__Impl rule__BooleanLiteralRule__Group__1 ;
    public final void rule__BooleanLiteralRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5600:1: ( rule__BooleanLiteralRule__Group__0__Impl rule__BooleanLiteralRule__Group__1 )
            // InternalOptimisationLanguage.g:5601:2: rule__BooleanLiteralRule__Group__0__Impl rule__BooleanLiteralRule__Group__1
            {
            pushFollow(FOLLOW_48);
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
    // InternalOptimisationLanguage.g:5608:1: rule__BooleanLiteralRule__Group__0__Impl : ( () ) ;
    public final void rule__BooleanLiteralRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5612:1: ( ( () ) )
            // InternalOptimisationLanguage.g:5613:1: ( () )
            {
            // InternalOptimisationLanguage.g:5613:1: ( () )
            // InternalOptimisationLanguage.g:5614:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralRuleAccess().getBooleanLiteralAction_0()); 
            }
            // InternalOptimisationLanguage.g:5615:2: ()
            // InternalOptimisationLanguage.g:5615:3: 
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
    // InternalOptimisationLanguage.g:5623:1: rule__BooleanLiteralRule__Group__1 : rule__BooleanLiteralRule__Group__1__Impl ;
    public final void rule__BooleanLiteralRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5627:1: ( rule__BooleanLiteralRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:5628:2: rule__BooleanLiteralRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:5634:1: rule__BooleanLiteralRule__Group__1__Impl : ( ( rule__BooleanLiteralRule__Alternatives_1 ) ) ;
    public final void rule__BooleanLiteralRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5638:1: ( ( ( rule__BooleanLiteralRule__Alternatives_1 ) ) )
            // InternalOptimisationLanguage.g:5639:1: ( ( rule__BooleanLiteralRule__Alternatives_1 ) )
            {
            // InternalOptimisationLanguage.g:5639:1: ( ( rule__BooleanLiteralRule__Alternatives_1 ) )
            // InternalOptimisationLanguage.g:5640:2: ( rule__BooleanLiteralRule__Alternatives_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralRuleAccess().getAlternatives_1()); 
            }
            // InternalOptimisationLanguage.g:5641:2: ( rule__BooleanLiteralRule__Alternatives_1 )
            // InternalOptimisationLanguage.g:5641:3: rule__BooleanLiteralRule__Alternatives_1
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
    // InternalOptimisationLanguage.g:5650:1: rule__ConstraintRule__Group__0 : rule__ConstraintRule__Group__0__Impl rule__ConstraintRule__Group__1 ;
    public final void rule__ConstraintRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5654:1: ( rule__ConstraintRule__Group__0__Impl rule__ConstraintRule__Group__1 )
            // InternalOptimisationLanguage.g:5655:2: rule__ConstraintRule__Group__0__Impl rule__ConstraintRule__Group__1
            {
            pushFollow(FOLLOW_5);
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
    // InternalOptimisationLanguage.g:5662:1: rule__ConstraintRule__Group__0__Impl : ( '@' ) ;
    public final void rule__ConstraintRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5666:1: ( ( '@' ) )
            // InternalOptimisationLanguage.g:5667:1: ( '@' )
            {
            // InternalOptimisationLanguage.g:5667:1: ( '@' )
            // InternalOptimisationLanguage.g:5668:2: '@'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstraintRuleAccess().getCommercialAtKeyword_0()); 
            }
            match(input,79,FOLLOW_2); if (state.failed) return ;
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
    // InternalOptimisationLanguage.g:5677:1: rule__ConstraintRule__Group__1 : rule__ConstraintRule__Group__1__Impl ;
    public final void rule__ConstraintRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5681:1: ( rule__ConstraintRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:5682:2: rule__ConstraintRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:5688:1: rule__ConstraintRule__Group__1__Impl : ( ruleInstanceLiteralRule ) ;
    public final void rule__ConstraintRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5692:1: ( ( ruleInstanceLiteralRule ) )
            // InternalOptimisationLanguage.g:5693:1: ( ruleInstanceLiteralRule )
            {
            // InternalOptimisationLanguage.g:5693:1: ( ruleInstanceLiteralRule )
            // InternalOptimisationLanguage.g:5694:2: ruleInstanceLiteralRule
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
    // InternalOptimisationLanguage.g:5704:1: rule__AttributeDefinitionRule__Group__0 : rule__AttributeDefinitionRule__Group__0__Impl rule__AttributeDefinitionRule__Group__1 ;
    public final void rule__AttributeDefinitionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5708:1: ( rule__AttributeDefinitionRule__Group__0__Impl rule__AttributeDefinitionRule__Group__1 )
            // InternalOptimisationLanguage.g:5709:2: rule__AttributeDefinitionRule__Group__0__Impl rule__AttributeDefinitionRule__Group__1
            {
            pushFollow(FOLLOW_5);
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
    // InternalOptimisationLanguage.g:5716:1: rule__AttributeDefinitionRule__Group__0__Impl : ( ( rule__AttributeDefinitionRule__ConstraintsAssignment_0 )* ) ;
    public final void rule__AttributeDefinitionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5720:1: ( ( ( rule__AttributeDefinitionRule__ConstraintsAssignment_0 )* ) )
            // InternalOptimisationLanguage.g:5721:1: ( ( rule__AttributeDefinitionRule__ConstraintsAssignment_0 )* )
            {
            // InternalOptimisationLanguage.g:5721:1: ( ( rule__AttributeDefinitionRule__ConstraintsAssignment_0 )* )
            // InternalOptimisationLanguage.g:5722:2: ( rule__AttributeDefinitionRule__ConstraintsAssignment_0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getConstraintsAssignment_0()); 
            }
            // InternalOptimisationLanguage.g:5723:2: ( rule__AttributeDefinitionRule__ConstraintsAssignment_0 )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==79) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:5723:3: rule__AttributeDefinitionRule__ConstraintsAssignment_0
            	    {
            	    pushFollow(FOLLOW_49);
            	    rule__AttributeDefinitionRule__ConstraintsAssignment_0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop42;
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
    // InternalOptimisationLanguage.g:5731:1: rule__AttributeDefinitionRule__Group__1 : rule__AttributeDefinitionRule__Group__1__Impl rule__AttributeDefinitionRule__Group__2 ;
    public final void rule__AttributeDefinitionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5735:1: ( rule__AttributeDefinitionRule__Group__1__Impl rule__AttributeDefinitionRule__Group__2 )
            // InternalOptimisationLanguage.g:5736:2: rule__AttributeDefinitionRule__Group__1__Impl rule__AttributeDefinitionRule__Group__2
            {
            pushFollow(FOLLOW_50);
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
    // InternalOptimisationLanguage.g:5743:1: rule__AttributeDefinitionRule__Group__1__Impl : ( ( rule__AttributeDefinitionRule__NameAssignment_1 ) ) ;
    public final void rule__AttributeDefinitionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5747:1: ( ( ( rule__AttributeDefinitionRule__NameAssignment_1 ) ) )
            // InternalOptimisationLanguage.g:5748:1: ( ( rule__AttributeDefinitionRule__NameAssignment_1 ) )
            {
            // InternalOptimisationLanguage.g:5748:1: ( ( rule__AttributeDefinitionRule__NameAssignment_1 ) )
            // InternalOptimisationLanguage.g:5749:2: ( rule__AttributeDefinitionRule__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getNameAssignment_1()); 
            }
            // InternalOptimisationLanguage.g:5750:2: ( rule__AttributeDefinitionRule__NameAssignment_1 )
            // InternalOptimisationLanguage.g:5750:3: rule__AttributeDefinitionRule__NameAssignment_1
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
    // InternalOptimisationLanguage.g:5758:1: rule__AttributeDefinitionRule__Group__2 : rule__AttributeDefinitionRule__Group__2__Impl rule__AttributeDefinitionRule__Group__3 ;
    public final void rule__AttributeDefinitionRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5762:1: ( rule__AttributeDefinitionRule__Group__2__Impl rule__AttributeDefinitionRule__Group__3 )
            // InternalOptimisationLanguage.g:5763:2: rule__AttributeDefinitionRule__Group__2__Impl rule__AttributeDefinitionRule__Group__3
            {
            pushFollow(FOLLOW_51);
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
    // InternalOptimisationLanguage.g:5770:1: rule__AttributeDefinitionRule__Group__2__Impl : ( ':' ) ;
    public final void rule__AttributeDefinitionRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5774:1: ( ( ':' ) )
            // InternalOptimisationLanguage.g:5775:1: ( ':' )
            {
            // InternalOptimisationLanguage.g:5775:1: ( ':' )
            // InternalOptimisationLanguage.g:5776:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getColonKeyword_2()); 
            }
            match(input,80,FOLLOW_2); if (state.failed) return ;
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
    // InternalOptimisationLanguage.g:5785:1: rule__AttributeDefinitionRule__Group__3 : rule__AttributeDefinitionRule__Group__3__Impl rule__AttributeDefinitionRule__Group__4 ;
    public final void rule__AttributeDefinitionRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5789:1: ( rule__AttributeDefinitionRule__Group__3__Impl rule__AttributeDefinitionRule__Group__4 )
            // InternalOptimisationLanguage.g:5790:2: rule__AttributeDefinitionRule__Group__3__Impl rule__AttributeDefinitionRule__Group__4
            {
            pushFollow(FOLLOW_51);
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
    // InternalOptimisationLanguage.g:5797:1: rule__AttributeDefinitionRule__Group__3__Impl : ( ( rule__AttributeDefinitionRule__OptionalAssignment_3 )? ) ;
    public final void rule__AttributeDefinitionRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5801:1: ( ( ( rule__AttributeDefinitionRule__OptionalAssignment_3 )? ) )
            // InternalOptimisationLanguage.g:5802:1: ( ( rule__AttributeDefinitionRule__OptionalAssignment_3 )? )
            {
            // InternalOptimisationLanguage.g:5802:1: ( ( rule__AttributeDefinitionRule__OptionalAssignment_3 )? )
            // InternalOptimisationLanguage.g:5803:2: ( rule__AttributeDefinitionRule__OptionalAssignment_3 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getOptionalAssignment_3()); 
            }
            // InternalOptimisationLanguage.g:5804:2: ( rule__AttributeDefinitionRule__OptionalAssignment_3 )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==95) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalOptimisationLanguage.g:5804:3: rule__AttributeDefinitionRule__OptionalAssignment_3
                    {
                    pushFollow(FOLLOW_2);
                    rule__AttributeDefinitionRule__OptionalAssignment_3();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeDefinitionRuleAccess().getOptionalAssignment_3()); 
            }

            }


            }

        }
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
    // InternalOptimisationLanguage.g:5812:1: rule__AttributeDefinitionRule__Group__4 : rule__AttributeDefinitionRule__Group__4__Impl rule__AttributeDefinitionRule__Group__5 ;
    public final void rule__AttributeDefinitionRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5816:1: ( rule__AttributeDefinitionRule__Group__4__Impl rule__AttributeDefinitionRule__Group__5 )
            // InternalOptimisationLanguage.g:5817:2: rule__AttributeDefinitionRule__Group__4__Impl rule__AttributeDefinitionRule__Group__5
            {
            pushFollow(FOLLOW_52);
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
    // InternalOptimisationLanguage.g:5824:1: rule__AttributeDefinitionRule__Group__4__Impl : ( ( rule__AttributeDefinitionRule__TypeAssignment_4 ) ) ;
    public final void rule__AttributeDefinitionRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5828:1: ( ( ( rule__AttributeDefinitionRule__TypeAssignment_4 ) ) )
            // InternalOptimisationLanguage.g:5829:1: ( ( rule__AttributeDefinitionRule__TypeAssignment_4 ) )
            {
            // InternalOptimisationLanguage.g:5829:1: ( ( rule__AttributeDefinitionRule__TypeAssignment_4 ) )
            // InternalOptimisationLanguage.g:5830:2: ( rule__AttributeDefinitionRule__TypeAssignment_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getTypeAssignment_4()); 
            }
            // InternalOptimisationLanguage.g:5831:2: ( rule__AttributeDefinitionRule__TypeAssignment_4 )
            // InternalOptimisationLanguage.g:5831:3: rule__AttributeDefinitionRule__TypeAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__AttributeDefinitionRule__TypeAssignment_4();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeDefinitionRuleAccess().getTypeAssignment_4()); 
            }

            }


            }

        }
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
    // InternalOptimisationLanguage.g:5839:1: rule__AttributeDefinitionRule__Group__5 : rule__AttributeDefinitionRule__Group__5__Impl rule__AttributeDefinitionRule__Group__6 ;
    public final void rule__AttributeDefinitionRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5843:1: ( rule__AttributeDefinitionRule__Group__5__Impl rule__AttributeDefinitionRule__Group__6 )
            // InternalOptimisationLanguage.g:5844:2: rule__AttributeDefinitionRule__Group__5__Impl rule__AttributeDefinitionRule__Group__6
            {
            pushFollow(FOLLOW_52);
            rule__AttributeDefinitionRule__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__AttributeDefinitionRule__Group__6();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalOptimisationLanguage.g:5851:1: rule__AttributeDefinitionRule__Group__5__Impl : ( ( rule__AttributeDefinitionRule__Group_5__0 )? ) ;
    public final void rule__AttributeDefinitionRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5855:1: ( ( ( rule__AttributeDefinitionRule__Group_5__0 )? ) )
            // InternalOptimisationLanguage.g:5856:1: ( ( rule__AttributeDefinitionRule__Group_5__0 )? )
            {
            // InternalOptimisationLanguage.g:5856:1: ( ( rule__AttributeDefinitionRule__Group_5__0 )? )
            // InternalOptimisationLanguage.g:5857:2: ( rule__AttributeDefinitionRule__Group_5__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getGroup_5()); 
            }
            // InternalOptimisationLanguage.g:5858:2: ( rule__AttributeDefinitionRule__Group_5__0 )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==64) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalOptimisationLanguage.g:5858:3: rule__AttributeDefinitionRule__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__AttributeDefinitionRule__Group_5__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeDefinitionRuleAccess().getGroup_5()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__AttributeDefinitionRule__Group__6"
    // InternalOptimisationLanguage.g:5866:1: rule__AttributeDefinitionRule__Group__6 : rule__AttributeDefinitionRule__Group__6__Impl ;
    public final void rule__AttributeDefinitionRule__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5870:1: ( rule__AttributeDefinitionRule__Group__6__Impl )
            // InternalOptimisationLanguage.g:5871:2: rule__AttributeDefinitionRule__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AttributeDefinitionRule__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeDefinitionRule__Group__6"


    // $ANTLR start "rule__AttributeDefinitionRule__Group__6__Impl"
    // InternalOptimisationLanguage.g:5877:1: rule__AttributeDefinitionRule__Group__6__Impl : ( ';' ) ;
    public final void rule__AttributeDefinitionRule__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5881:1: ( ( ';' ) )
            // InternalOptimisationLanguage.g:5882:1: ( ';' )
            {
            // InternalOptimisationLanguage.g:5882:1: ( ';' )
            // InternalOptimisationLanguage.g:5883:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getSemicolonKeyword_6()); 
            }
            match(input,65,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeDefinitionRuleAccess().getSemicolonKeyword_6()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeDefinitionRule__Group__6__Impl"


    // $ANTLR start "rule__AttributeDefinitionRule__Group_5__0"
    // InternalOptimisationLanguage.g:5893:1: rule__AttributeDefinitionRule__Group_5__0 : rule__AttributeDefinitionRule__Group_5__0__Impl rule__AttributeDefinitionRule__Group_5__1 ;
    public final void rule__AttributeDefinitionRule__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5897:1: ( rule__AttributeDefinitionRule__Group_5__0__Impl rule__AttributeDefinitionRule__Group_5__1 )
            // InternalOptimisationLanguage.g:5898:2: rule__AttributeDefinitionRule__Group_5__0__Impl rule__AttributeDefinitionRule__Group_5__1
            {
            pushFollow(FOLLOW_27);
            rule__AttributeDefinitionRule__Group_5__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__AttributeDefinitionRule__Group_5__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeDefinitionRule__Group_5__0"


    // $ANTLR start "rule__AttributeDefinitionRule__Group_5__0__Impl"
    // InternalOptimisationLanguage.g:5905:1: rule__AttributeDefinitionRule__Group_5__0__Impl : ( ':=' ) ;
    public final void rule__AttributeDefinitionRule__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5909:1: ( ( ':=' ) )
            // InternalOptimisationLanguage.g:5910:1: ( ':=' )
            {
            // InternalOptimisationLanguage.g:5910:1: ( ':=' )
            // InternalOptimisationLanguage.g:5911:2: ':='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getColonEqualsSignKeyword_5_0()); 
            }
            match(input,64,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeDefinitionRuleAccess().getColonEqualsSignKeyword_5_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeDefinitionRule__Group_5__0__Impl"


    // $ANTLR start "rule__AttributeDefinitionRule__Group_5__1"
    // InternalOptimisationLanguage.g:5920:1: rule__AttributeDefinitionRule__Group_5__1 : rule__AttributeDefinitionRule__Group_5__1__Impl ;
    public final void rule__AttributeDefinitionRule__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5924:1: ( rule__AttributeDefinitionRule__Group_5__1__Impl )
            // InternalOptimisationLanguage.g:5925:2: rule__AttributeDefinitionRule__Group_5__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AttributeDefinitionRule__Group_5__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeDefinitionRule__Group_5__1"


    // $ANTLR start "rule__AttributeDefinitionRule__Group_5__1__Impl"
    // InternalOptimisationLanguage.g:5931:1: rule__AttributeDefinitionRule__Group_5__1__Impl : ( ( rule__AttributeDefinitionRule__InitialisationAssignment_5_1 ) ) ;
    public final void rule__AttributeDefinitionRule__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5935:1: ( ( ( rule__AttributeDefinitionRule__InitialisationAssignment_5_1 ) ) )
            // InternalOptimisationLanguage.g:5936:1: ( ( rule__AttributeDefinitionRule__InitialisationAssignment_5_1 ) )
            {
            // InternalOptimisationLanguage.g:5936:1: ( ( rule__AttributeDefinitionRule__InitialisationAssignment_5_1 ) )
            // InternalOptimisationLanguage.g:5937:2: ( rule__AttributeDefinitionRule__InitialisationAssignment_5_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getInitialisationAssignment_5_1()); 
            }
            // InternalOptimisationLanguage.g:5938:2: ( rule__AttributeDefinitionRule__InitialisationAssignment_5_1 )
            // InternalOptimisationLanguage.g:5938:3: rule__AttributeDefinitionRule__InitialisationAssignment_5_1
            {
            pushFollow(FOLLOW_2);
            rule__AttributeDefinitionRule__InitialisationAssignment_5_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeDefinitionRuleAccess().getInitialisationAssignment_5_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeDefinitionRule__Group_5__1__Impl"


    // $ANTLR start "rule__EnumReferenceRule__Group__0"
    // InternalOptimisationLanguage.g:5947:1: rule__EnumReferenceRule__Group__0 : rule__EnumReferenceRule__Group__0__Impl rule__EnumReferenceRule__Group__1 ;
    public final void rule__EnumReferenceRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5951:1: ( rule__EnumReferenceRule__Group__0__Impl rule__EnumReferenceRule__Group__1 )
            // InternalOptimisationLanguage.g:5952:2: rule__EnumReferenceRule__Group__0__Impl rule__EnumReferenceRule__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__EnumReferenceRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__EnumReferenceRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumReferenceRule__Group__0"


    // $ANTLR start "rule__EnumReferenceRule__Group__0__Impl"
    // InternalOptimisationLanguage.g:5959:1: rule__EnumReferenceRule__Group__0__Impl : ( 'enum' ) ;
    public final void rule__EnumReferenceRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5963:1: ( ( 'enum' ) )
            // InternalOptimisationLanguage.g:5964:1: ( 'enum' )
            {
            // InternalOptimisationLanguage.g:5964:1: ( 'enum' )
            // InternalOptimisationLanguage.g:5965:2: 'enum'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumReferenceRuleAccess().getEnumKeyword_0()); 
            }
            match(input,81,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumReferenceRuleAccess().getEnumKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumReferenceRule__Group__0__Impl"


    // $ANTLR start "rule__EnumReferenceRule__Group__1"
    // InternalOptimisationLanguage.g:5974:1: rule__EnumReferenceRule__Group__1 : rule__EnumReferenceRule__Group__1__Impl ;
    public final void rule__EnumReferenceRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5978:1: ( rule__EnumReferenceRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:5979:2: rule__EnumReferenceRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EnumReferenceRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumReferenceRule__Group__1"


    // $ANTLR start "rule__EnumReferenceRule__Group__1__Impl"
    // InternalOptimisationLanguage.g:5985:1: rule__EnumReferenceRule__Group__1__Impl : ( ( rule__EnumReferenceRule__DefinitionAssignment_1 ) ) ;
    public final void rule__EnumReferenceRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5989:1: ( ( ( rule__EnumReferenceRule__DefinitionAssignment_1 ) ) )
            // InternalOptimisationLanguage.g:5990:1: ( ( rule__EnumReferenceRule__DefinitionAssignment_1 ) )
            {
            // InternalOptimisationLanguage.g:5990:1: ( ( rule__EnumReferenceRule__DefinitionAssignment_1 ) )
            // InternalOptimisationLanguage.g:5991:2: ( rule__EnumReferenceRule__DefinitionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumReferenceRuleAccess().getDefinitionAssignment_1()); 
            }
            // InternalOptimisationLanguage.g:5992:2: ( rule__EnumReferenceRule__DefinitionAssignment_1 )
            // InternalOptimisationLanguage.g:5992:3: rule__EnumReferenceRule__DefinitionAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__EnumReferenceRule__DefinitionAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumReferenceRuleAccess().getDefinitionAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumReferenceRule__Group__1__Impl"


    // $ANTLR start "rule__TypeReferenceRule__Group__0"
    // InternalOptimisationLanguage.g:6001:1: rule__TypeReferenceRule__Group__0 : rule__TypeReferenceRule__Group__0__Impl rule__TypeReferenceRule__Group__1 ;
    public final void rule__TypeReferenceRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6005:1: ( rule__TypeReferenceRule__Group__0__Impl rule__TypeReferenceRule__Group__1 )
            // InternalOptimisationLanguage.g:6006:2: rule__TypeReferenceRule__Group__0__Impl rule__TypeReferenceRule__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__TypeReferenceRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TypeReferenceRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeReferenceRule__Group__0"


    // $ANTLR start "rule__TypeReferenceRule__Group__0__Impl"
    // InternalOptimisationLanguage.g:6013:1: rule__TypeReferenceRule__Group__0__Impl : ( 'instance' ) ;
    public final void rule__TypeReferenceRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6017:1: ( ( 'instance' ) )
            // InternalOptimisationLanguage.g:6018:1: ( 'instance' )
            {
            // InternalOptimisationLanguage.g:6018:1: ( 'instance' )
            // InternalOptimisationLanguage.g:6019:2: 'instance'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeReferenceRuleAccess().getInstanceKeyword_0()); 
            }
            match(input,78,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeReferenceRuleAccess().getInstanceKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeReferenceRule__Group__0__Impl"


    // $ANTLR start "rule__TypeReferenceRule__Group__1"
    // InternalOptimisationLanguage.g:6028:1: rule__TypeReferenceRule__Group__1 : rule__TypeReferenceRule__Group__1__Impl ;
    public final void rule__TypeReferenceRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6032:1: ( rule__TypeReferenceRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:6033:2: rule__TypeReferenceRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TypeReferenceRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeReferenceRule__Group__1"


    // $ANTLR start "rule__TypeReferenceRule__Group__1__Impl"
    // InternalOptimisationLanguage.g:6039:1: rule__TypeReferenceRule__Group__1__Impl : ( ( rule__TypeReferenceRule__DefinitionAssignment_1 ) ) ;
    public final void rule__TypeReferenceRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6043:1: ( ( ( rule__TypeReferenceRule__DefinitionAssignment_1 ) ) )
            // InternalOptimisationLanguage.g:6044:1: ( ( rule__TypeReferenceRule__DefinitionAssignment_1 ) )
            {
            // InternalOptimisationLanguage.g:6044:1: ( ( rule__TypeReferenceRule__DefinitionAssignment_1 ) )
            // InternalOptimisationLanguage.g:6045:2: ( rule__TypeReferenceRule__DefinitionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeReferenceRuleAccess().getDefinitionAssignment_1()); 
            }
            // InternalOptimisationLanguage.g:6046:2: ( rule__TypeReferenceRule__DefinitionAssignment_1 )
            // InternalOptimisationLanguage.g:6046:3: rule__TypeReferenceRule__DefinitionAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__TypeReferenceRule__DefinitionAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeReferenceRuleAccess().getDefinitionAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeReferenceRule__Group__1__Impl"


    // $ANTLR start "rule__LiteralTypeRule__Group__0"
    // InternalOptimisationLanguage.g:6055:1: rule__LiteralTypeRule__Group__0 : rule__LiteralTypeRule__Group__0__Impl rule__LiteralTypeRule__Group__1 ;
    public final void rule__LiteralTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6059:1: ( rule__LiteralTypeRule__Group__0__Impl rule__LiteralTypeRule__Group__1 )
            // InternalOptimisationLanguage.g:6060:2: rule__LiteralTypeRule__Group__0__Impl rule__LiteralTypeRule__Group__1
            {
            pushFollow(FOLLOW_53);
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
    // InternalOptimisationLanguage.g:6067:1: rule__LiteralTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__LiteralTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6071:1: ( ( () ) )
            // InternalOptimisationLanguage.g:6072:1: ( () )
            {
            // InternalOptimisationLanguage.g:6072:1: ( () )
            // InternalOptimisationLanguage.g:6073:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralTypeRuleAccess().getLiteralTypeAction_0()); 
            }
            // InternalOptimisationLanguage.g:6074:2: ()
            // InternalOptimisationLanguage.g:6074:3: 
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
    // InternalOptimisationLanguage.g:6082:1: rule__LiteralTypeRule__Group__1 : rule__LiteralTypeRule__Group__1__Impl ;
    public final void rule__LiteralTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6086:1: ( rule__LiteralTypeRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:6087:2: rule__LiteralTypeRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:6093:1: rule__LiteralTypeRule__Group__1__Impl : ( 'literal' ) ;
    public final void rule__LiteralTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6097:1: ( ( 'literal' ) )
            // InternalOptimisationLanguage.g:6098:1: ( 'literal' )
            {
            // InternalOptimisationLanguage.g:6098:1: ( 'literal' )
            // InternalOptimisationLanguage.g:6099:2: 'literal'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralTypeRuleAccess().getLiteralKeyword_1()); 
            }
            match(input,82,FOLLOW_2); if (state.failed) return ;
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
    // InternalOptimisationLanguage.g:6109:1: rule__DataTypeRule__Group__0 : rule__DataTypeRule__Group__0__Impl rule__DataTypeRule__Group__1 ;
    public final void rule__DataTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6113:1: ( rule__DataTypeRule__Group__0__Impl rule__DataTypeRule__Group__1 )
            // InternalOptimisationLanguage.g:6114:2: rule__DataTypeRule__Group__0__Impl rule__DataTypeRule__Group__1
            {
            pushFollow(FOLLOW_51);
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
    // InternalOptimisationLanguage.g:6121:1: rule__DataTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__DataTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6125:1: ( ( () ) )
            // InternalOptimisationLanguage.g:6126:1: ( () )
            {
            // InternalOptimisationLanguage.g:6126:1: ( () )
            // InternalOptimisationLanguage.g:6127:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getDataTypeAction_0()); 
            }
            // InternalOptimisationLanguage.g:6128:2: ()
            // InternalOptimisationLanguage.g:6128:3: 
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
    // InternalOptimisationLanguage.g:6136:1: rule__DataTypeRule__Group__1 : rule__DataTypeRule__Group__1__Impl ;
    public final void rule__DataTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6140:1: ( rule__DataTypeRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:6141:2: rule__DataTypeRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:6147:1: rule__DataTypeRule__Group__1__Impl : ( 'data' ) ;
    public final void rule__DataTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6151:1: ( ( 'data' ) )
            // InternalOptimisationLanguage.g:6152:1: ( 'data' )
            {
            // InternalOptimisationLanguage.g:6152:1: ( 'data' )
            // InternalOptimisationLanguage.g:6153:2: 'data'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getDataKeyword_1()); 
            }
            match(input,77,FOLLOW_2); if (state.failed) return ;
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


    // $ANTLR start "rule__StringTypeRule__Group__0"
    // InternalOptimisationLanguage.g:6163:1: rule__StringTypeRule__Group__0 : rule__StringTypeRule__Group__0__Impl rule__StringTypeRule__Group__1 ;
    public final void rule__StringTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6167:1: ( rule__StringTypeRule__Group__0__Impl rule__StringTypeRule__Group__1 )
            // InternalOptimisationLanguage.g:6168:2: rule__StringTypeRule__Group__0__Impl rule__StringTypeRule__Group__1
            {
            pushFollow(FOLLOW_54);
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
    // InternalOptimisationLanguage.g:6175:1: rule__StringTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__StringTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6179:1: ( ( () ) )
            // InternalOptimisationLanguage.g:6180:1: ( () )
            {
            // InternalOptimisationLanguage.g:6180:1: ( () )
            // InternalOptimisationLanguage.g:6181:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringTypeRuleAccess().getStringTypeAction_0()); 
            }
            // InternalOptimisationLanguage.g:6182:2: ()
            // InternalOptimisationLanguage.g:6182:3: 
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
    // InternalOptimisationLanguage.g:6190:1: rule__StringTypeRule__Group__1 : rule__StringTypeRule__Group__1__Impl ;
    public final void rule__StringTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6194:1: ( rule__StringTypeRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:6195:2: rule__StringTypeRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:6201:1: rule__StringTypeRule__Group__1__Impl : ( 'string' ) ;
    public final void rule__StringTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6205:1: ( ( 'string' ) )
            // InternalOptimisationLanguage.g:6206:1: ( 'string' )
            {
            // InternalOptimisationLanguage.g:6206:1: ( 'string' )
            // InternalOptimisationLanguage.g:6207:2: 'string'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringTypeRuleAccess().getStringKeyword_1()); 
            }
            match(input,83,FOLLOW_2); if (state.failed) return ;
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
    // InternalOptimisationLanguage.g:6217:1: rule__ExpressionTypeRule__Group__0 : rule__ExpressionTypeRule__Group__0__Impl rule__ExpressionTypeRule__Group__1 ;
    public final void rule__ExpressionTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6221:1: ( rule__ExpressionTypeRule__Group__0__Impl rule__ExpressionTypeRule__Group__1 )
            // InternalOptimisationLanguage.g:6222:2: rule__ExpressionTypeRule__Group__0__Impl rule__ExpressionTypeRule__Group__1
            {
            pushFollow(FOLLOW_55);
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
    // InternalOptimisationLanguage.g:6229:1: rule__ExpressionTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__ExpressionTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6233:1: ( ( () ) )
            // InternalOptimisationLanguage.g:6234:1: ( () )
            {
            // InternalOptimisationLanguage.g:6234:1: ( () )
            // InternalOptimisationLanguage.g:6235:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionTypeRuleAccess().getExpressionTypeAction_0()); 
            }
            // InternalOptimisationLanguage.g:6236:2: ()
            // InternalOptimisationLanguage.g:6236:3: 
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
    // InternalOptimisationLanguage.g:6244:1: rule__ExpressionTypeRule__Group__1 : rule__ExpressionTypeRule__Group__1__Impl ;
    public final void rule__ExpressionTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6248:1: ( rule__ExpressionTypeRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:6249:2: rule__ExpressionTypeRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:6255:1: rule__ExpressionTypeRule__Group__1__Impl : ( 'expression' ) ;
    public final void rule__ExpressionTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6259:1: ( ( 'expression' ) )
            // InternalOptimisationLanguage.g:6260:1: ( 'expression' )
            {
            // InternalOptimisationLanguage.g:6260:1: ( 'expression' )
            // InternalOptimisationLanguage.g:6261:2: 'expression'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionTypeRuleAccess().getExpressionKeyword_1()); 
            }
            match(input,84,FOLLOW_2); if (state.failed) return ;
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
    // InternalOptimisationLanguage.g:6271:1: rule__IntTypeRule__Group__0 : rule__IntTypeRule__Group__0__Impl rule__IntTypeRule__Group__1 ;
    public final void rule__IntTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6275:1: ( rule__IntTypeRule__Group__0__Impl rule__IntTypeRule__Group__1 )
            // InternalOptimisationLanguage.g:6276:2: rule__IntTypeRule__Group__0__Impl rule__IntTypeRule__Group__1
            {
            pushFollow(FOLLOW_56);
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
    // InternalOptimisationLanguage.g:6283:1: rule__IntTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__IntTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6287:1: ( ( () ) )
            // InternalOptimisationLanguage.g:6288:1: ( () )
            {
            // InternalOptimisationLanguage.g:6288:1: ( () )
            // InternalOptimisationLanguage.g:6289:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntTypeRuleAccess().getIntTypeAction_0()); 
            }
            // InternalOptimisationLanguage.g:6290:2: ()
            // InternalOptimisationLanguage.g:6290:3: 
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
    // InternalOptimisationLanguage.g:6298:1: rule__IntTypeRule__Group__1 : rule__IntTypeRule__Group__1__Impl ;
    public final void rule__IntTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6302:1: ( rule__IntTypeRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:6303:2: rule__IntTypeRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:6309:1: rule__IntTypeRule__Group__1__Impl : ( 'int' ) ;
    public final void rule__IntTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6313:1: ( ( 'int' ) )
            // InternalOptimisationLanguage.g:6314:1: ( 'int' )
            {
            // InternalOptimisationLanguage.g:6314:1: ( 'int' )
            // InternalOptimisationLanguage.g:6315:2: 'int'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntTypeRuleAccess().getIntKeyword_1()); 
            }
            match(input,85,FOLLOW_2); if (state.failed) return ;
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
    // InternalOptimisationLanguage.g:6325:1: rule__RealTypeRule__Group__0 : rule__RealTypeRule__Group__0__Impl rule__RealTypeRule__Group__1 ;
    public final void rule__RealTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6329:1: ( rule__RealTypeRule__Group__0__Impl rule__RealTypeRule__Group__1 )
            // InternalOptimisationLanguage.g:6330:2: rule__RealTypeRule__Group__0__Impl rule__RealTypeRule__Group__1
            {
            pushFollow(FOLLOW_57);
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
    // InternalOptimisationLanguage.g:6337:1: rule__RealTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__RealTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6341:1: ( ( () ) )
            // InternalOptimisationLanguage.g:6342:1: ( () )
            {
            // InternalOptimisationLanguage.g:6342:1: ( () )
            // InternalOptimisationLanguage.g:6343:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealTypeRuleAccess().getRealTypeAction_0()); 
            }
            // InternalOptimisationLanguage.g:6344:2: ()
            // InternalOptimisationLanguage.g:6344:3: 
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
    // InternalOptimisationLanguage.g:6352:1: rule__RealTypeRule__Group__1 : rule__RealTypeRule__Group__1__Impl ;
    public final void rule__RealTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6356:1: ( rule__RealTypeRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:6357:2: rule__RealTypeRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:6363:1: rule__RealTypeRule__Group__1__Impl : ( 'real' ) ;
    public final void rule__RealTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6367:1: ( ( 'real' ) )
            // InternalOptimisationLanguage.g:6368:1: ( 'real' )
            {
            // InternalOptimisationLanguage.g:6368:1: ( 'real' )
            // InternalOptimisationLanguage.g:6369:2: 'real'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealTypeRuleAccess().getRealKeyword_1()); 
            }
            match(input,86,FOLLOW_2); if (state.failed) return ;
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
    // InternalOptimisationLanguage.g:6379:1: rule__BooleanTypeRule__Group__0 : rule__BooleanTypeRule__Group__0__Impl rule__BooleanTypeRule__Group__1 ;
    public final void rule__BooleanTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6383:1: ( rule__BooleanTypeRule__Group__0__Impl rule__BooleanTypeRule__Group__1 )
            // InternalOptimisationLanguage.g:6384:2: rule__BooleanTypeRule__Group__0__Impl rule__BooleanTypeRule__Group__1
            {
            pushFollow(FOLLOW_58);
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
    // InternalOptimisationLanguage.g:6391:1: rule__BooleanTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__BooleanTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6395:1: ( ( () ) )
            // InternalOptimisationLanguage.g:6396:1: ( () )
            {
            // InternalOptimisationLanguage.g:6396:1: ( () )
            // InternalOptimisationLanguage.g:6397:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanTypeRuleAccess().getBooleanTypeAction_0()); 
            }
            // InternalOptimisationLanguage.g:6398:2: ()
            // InternalOptimisationLanguage.g:6398:3: 
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
    // InternalOptimisationLanguage.g:6406:1: rule__BooleanTypeRule__Group__1 : rule__BooleanTypeRule__Group__1__Impl ;
    public final void rule__BooleanTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6410:1: ( rule__BooleanTypeRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:6411:2: rule__BooleanTypeRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:6417:1: rule__BooleanTypeRule__Group__1__Impl : ( 'boolean' ) ;
    public final void rule__BooleanTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6421:1: ( ( 'boolean' ) )
            // InternalOptimisationLanguage.g:6422:1: ( 'boolean' )
            {
            // InternalOptimisationLanguage.g:6422:1: ( 'boolean' )
            // InternalOptimisationLanguage.g:6423:2: 'boolean'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanTypeRuleAccess().getBooleanKeyword_1()); 
            }
            match(input,87,FOLLOW_2); if (state.failed) return ;
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
    // InternalOptimisationLanguage.g:6433:1: rule__VoidTypeRule__Group__0 : rule__VoidTypeRule__Group__0__Impl rule__VoidTypeRule__Group__1 ;
    public final void rule__VoidTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6437:1: ( rule__VoidTypeRule__Group__0__Impl rule__VoidTypeRule__Group__1 )
            // InternalOptimisationLanguage.g:6438:2: rule__VoidTypeRule__Group__0__Impl rule__VoidTypeRule__Group__1
            {
            pushFollow(FOLLOW_59);
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
    // InternalOptimisationLanguage.g:6445:1: rule__VoidTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__VoidTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6449:1: ( ( () ) )
            // InternalOptimisationLanguage.g:6450:1: ( () )
            {
            // InternalOptimisationLanguage.g:6450:1: ( () )
            // InternalOptimisationLanguage.g:6451:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVoidTypeRuleAccess().getVoidTypeAction_0()); 
            }
            // InternalOptimisationLanguage.g:6452:2: ()
            // InternalOptimisationLanguage.g:6452:3: 
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
    // InternalOptimisationLanguage.g:6460:1: rule__VoidTypeRule__Group__1 : rule__VoidTypeRule__Group__1__Impl ;
    public final void rule__VoidTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6464:1: ( rule__VoidTypeRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:6465:2: rule__VoidTypeRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:6471:1: rule__VoidTypeRule__Group__1__Impl : ( 'void' ) ;
    public final void rule__VoidTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6475:1: ( ( 'void' ) )
            // InternalOptimisationLanguage.g:6476:1: ( 'void' )
            {
            // InternalOptimisationLanguage.g:6476:1: ( 'void' )
            // InternalOptimisationLanguage.g:6477:2: 'void'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVoidTypeRuleAccess().getVoidKeyword_1()); 
            }
            match(input,88,FOLLOW_2); if (state.failed) return ;
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
    // InternalOptimisationLanguage.g:6487:1: rule__ArrayTypeRule__Group__0 : rule__ArrayTypeRule__Group__0__Impl rule__ArrayTypeRule__Group__1 ;
    public final void rule__ArrayTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6491:1: ( rule__ArrayTypeRule__Group__0__Impl rule__ArrayTypeRule__Group__1 )
            // InternalOptimisationLanguage.g:6492:2: rule__ArrayTypeRule__Group__0__Impl rule__ArrayTypeRule__Group__1
            {
            pushFollow(FOLLOW_51);
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
    // InternalOptimisationLanguage.g:6499:1: rule__ArrayTypeRule__Group__0__Impl : ( 'array' ) ;
    public final void rule__ArrayTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6503:1: ( ( 'array' ) )
            // InternalOptimisationLanguage.g:6504:1: ( 'array' )
            {
            // InternalOptimisationLanguage.g:6504:1: ( 'array' )
            // InternalOptimisationLanguage.g:6505:2: 'array'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayTypeRuleAccess().getArrayKeyword_0()); 
            }
            match(input,89,FOLLOW_2); if (state.failed) return ;
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
    // InternalOptimisationLanguage.g:6514:1: rule__ArrayTypeRule__Group__1 : rule__ArrayTypeRule__Group__1__Impl ;
    public final void rule__ArrayTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6518:1: ( rule__ArrayTypeRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:6519:2: rule__ArrayTypeRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:6525:1: rule__ArrayTypeRule__Group__1__Impl : ( ( rule__ArrayTypeRule__ElementsAssignment_1 ) ) ;
    public final void rule__ArrayTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6529:1: ( ( ( rule__ArrayTypeRule__ElementsAssignment_1 ) ) )
            // InternalOptimisationLanguage.g:6530:1: ( ( rule__ArrayTypeRule__ElementsAssignment_1 ) )
            {
            // InternalOptimisationLanguage.g:6530:1: ( ( rule__ArrayTypeRule__ElementsAssignment_1 ) )
            // InternalOptimisationLanguage.g:6531:2: ( rule__ArrayTypeRule__ElementsAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayTypeRuleAccess().getElementsAssignment_1()); 
            }
            // InternalOptimisationLanguage.g:6532:2: ( rule__ArrayTypeRule__ElementsAssignment_1 )
            // InternalOptimisationLanguage.g:6532:3: rule__ArrayTypeRule__ElementsAssignment_1
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
    // InternalOptimisationLanguage.g:6541:1: rule__ParameterRule__Group__0 : rule__ParameterRule__Group__0__Impl rule__ParameterRule__Group__1 ;
    public final void rule__ParameterRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6545:1: ( rule__ParameterRule__Group__0__Impl rule__ParameterRule__Group__1 )
            // InternalOptimisationLanguage.g:6546:2: rule__ParameterRule__Group__0__Impl rule__ParameterRule__Group__1
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
    // InternalOptimisationLanguage.g:6553:1: rule__ParameterRule__Group__0__Impl : ( ( rule__ParameterRule__TypeAssignment_0 ) ) ;
    public final void rule__ParameterRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6557:1: ( ( ( rule__ParameterRule__TypeAssignment_0 ) ) )
            // InternalOptimisationLanguage.g:6558:1: ( ( rule__ParameterRule__TypeAssignment_0 ) )
            {
            // InternalOptimisationLanguage.g:6558:1: ( ( rule__ParameterRule__TypeAssignment_0 ) )
            // InternalOptimisationLanguage.g:6559:2: ( rule__ParameterRule__TypeAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterRuleAccess().getTypeAssignment_0()); 
            }
            // InternalOptimisationLanguage.g:6560:2: ( rule__ParameterRule__TypeAssignment_0 )
            // InternalOptimisationLanguage.g:6560:3: rule__ParameterRule__TypeAssignment_0
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
    // InternalOptimisationLanguage.g:6568:1: rule__ParameterRule__Group__1 : rule__ParameterRule__Group__1__Impl ;
    public final void rule__ParameterRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6572:1: ( rule__ParameterRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:6573:2: rule__ParameterRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:6579:1: rule__ParameterRule__Group__1__Impl : ( ( rule__ParameterRule__NameAssignment_1 ) ) ;
    public final void rule__ParameterRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6583:1: ( ( ( rule__ParameterRule__NameAssignment_1 ) ) )
            // InternalOptimisationLanguage.g:6584:1: ( ( rule__ParameterRule__NameAssignment_1 ) )
            {
            // InternalOptimisationLanguage.g:6584:1: ( ( rule__ParameterRule__NameAssignment_1 ) )
            // InternalOptimisationLanguage.g:6585:2: ( rule__ParameterRule__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterRuleAccess().getNameAssignment_1()); 
            }
            // InternalOptimisationLanguage.g:6586:2: ( rule__ParameterRule__NameAssignment_1 )
            // InternalOptimisationLanguage.g:6586:3: rule__ParameterRule__NameAssignment_1
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
    // InternalOptimisationLanguage.g:6595:1: rule__ImportRule__Group__0 : rule__ImportRule__Group__0__Impl rule__ImportRule__Group__1 ;
    public final void rule__ImportRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6599:1: ( rule__ImportRule__Group__0__Impl rule__ImportRule__Group__1 )
            // InternalOptimisationLanguage.g:6600:2: rule__ImportRule__Group__0__Impl rule__ImportRule__Group__1
            {
            pushFollow(FOLLOW_60);
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
    // InternalOptimisationLanguage.g:6607:1: rule__ImportRule__Group__0__Impl : ( 'import' ) ;
    public final void rule__ImportRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6611:1: ( ( 'import' ) )
            // InternalOptimisationLanguage.g:6612:1: ( 'import' )
            {
            // InternalOptimisationLanguage.g:6612:1: ( 'import' )
            // InternalOptimisationLanguage.g:6613:2: 'import'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportRuleAccess().getImportKeyword_0()); 
            }
            match(input,90,FOLLOW_2); if (state.failed) return ;
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
    // InternalOptimisationLanguage.g:6622:1: rule__ImportRule__Group__1 : rule__ImportRule__Group__1__Impl rule__ImportRule__Group__2 ;
    public final void rule__ImportRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6626:1: ( rule__ImportRule__Group__1__Impl rule__ImportRule__Group__2 )
            // InternalOptimisationLanguage.g:6627:2: rule__ImportRule__Group__1__Impl rule__ImportRule__Group__2
            {
            pushFollow(FOLLOW_61);
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
    // InternalOptimisationLanguage.g:6634:1: rule__ImportRule__Group__1__Impl : ( ( rule__ImportRule__LanguageAssignment_1 ) ) ;
    public final void rule__ImportRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6638:1: ( ( ( rule__ImportRule__LanguageAssignment_1 ) ) )
            // InternalOptimisationLanguage.g:6639:1: ( ( rule__ImportRule__LanguageAssignment_1 ) )
            {
            // InternalOptimisationLanguage.g:6639:1: ( ( rule__ImportRule__LanguageAssignment_1 ) )
            // InternalOptimisationLanguage.g:6640:2: ( rule__ImportRule__LanguageAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportRuleAccess().getLanguageAssignment_1()); 
            }
            // InternalOptimisationLanguage.g:6641:2: ( rule__ImportRule__LanguageAssignment_1 )
            // InternalOptimisationLanguage.g:6641:3: rule__ImportRule__LanguageAssignment_1
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
    // InternalOptimisationLanguage.g:6649:1: rule__ImportRule__Group__2 : rule__ImportRule__Group__2__Impl rule__ImportRule__Group__3 ;
    public final void rule__ImportRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6653:1: ( rule__ImportRule__Group__2__Impl rule__ImportRule__Group__3 )
            // InternalOptimisationLanguage.g:6654:2: rule__ImportRule__Group__2__Impl rule__ImportRule__Group__3
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
    // InternalOptimisationLanguage.g:6661:1: rule__ImportRule__Group__2__Impl : ( 'from' ) ;
    public final void rule__ImportRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6665:1: ( ( 'from' ) )
            // InternalOptimisationLanguage.g:6666:1: ( 'from' )
            {
            // InternalOptimisationLanguage.g:6666:1: ( 'from' )
            // InternalOptimisationLanguage.g:6667:2: 'from'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportRuleAccess().getFromKeyword_2()); 
            }
            match(input,91,FOLLOW_2); if (state.failed) return ;
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
    // InternalOptimisationLanguage.g:6676:1: rule__ImportRule__Group__3 : rule__ImportRule__Group__3__Impl rule__ImportRule__Group__4 ;
    public final void rule__ImportRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6680:1: ( rule__ImportRule__Group__3__Impl rule__ImportRule__Group__4 )
            // InternalOptimisationLanguage.g:6681:2: rule__ImportRule__Group__3__Impl rule__ImportRule__Group__4
            {
            pushFollow(FOLLOW_24);
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
    // InternalOptimisationLanguage.g:6688:1: rule__ImportRule__Group__3__Impl : ( ( rule__ImportRule__ImportedNamespaceAssignment_3 ) ) ;
    public final void rule__ImportRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6692:1: ( ( ( rule__ImportRule__ImportedNamespaceAssignment_3 ) ) )
            // InternalOptimisationLanguage.g:6693:1: ( ( rule__ImportRule__ImportedNamespaceAssignment_3 ) )
            {
            // InternalOptimisationLanguage.g:6693:1: ( ( rule__ImportRule__ImportedNamespaceAssignment_3 ) )
            // InternalOptimisationLanguage.g:6694:2: ( rule__ImportRule__ImportedNamespaceAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportRuleAccess().getImportedNamespaceAssignment_3()); 
            }
            // InternalOptimisationLanguage.g:6695:2: ( rule__ImportRule__ImportedNamespaceAssignment_3 )
            // InternalOptimisationLanguage.g:6695:3: rule__ImportRule__ImportedNamespaceAssignment_3
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
    // InternalOptimisationLanguage.g:6703:1: rule__ImportRule__Group__4 : rule__ImportRule__Group__4__Impl ;
    public final void rule__ImportRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6707:1: ( rule__ImportRule__Group__4__Impl )
            // InternalOptimisationLanguage.g:6708:2: rule__ImportRule__Group__4__Impl
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
    // InternalOptimisationLanguage.g:6714:1: rule__ImportRule__Group__4__Impl : ( ';' ) ;
    public final void rule__ImportRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6718:1: ( ( ';' ) )
            // InternalOptimisationLanguage.g:6719:1: ( ';' )
            {
            // InternalOptimisationLanguage.g:6719:1: ( ';' )
            // InternalOptimisationLanguage.g:6720:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportRuleAccess().getSemicolonKeyword_4()); 
            }
            match(input,65,FOLLOW_2); if (state.failed) return ;
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
    // InternalOptimisationLanguage.g:6730:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6734:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // InternalOptimisationLanguage.g:6735:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_18);
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
    // InternalOptimisationLanguage.g:6742:1: rule__QualifiedName__Group__0__Impl : ( ruleStringOrId ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6746:1: ( ( ruleStringOrId ) )
            // InternalOptimisationLanguage.g:6747:1: ( ruleStringOrId )
            {
            // InternalOptimisationLanguage.g:6747:1: ( ruleStringOrId )
            // InternalOptimisationLanguage.g:6748:2: ruleStringOrId
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
    // InternalOptimisationLanguage.g:6757:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6761:1: ( rule__QualifiedName__Group__1__Impl )
            // InternalOptimisationLanguage.g:6762:2: rule__QualifiedName__Group__1__Impl
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
    // InternalOptimisationLanguage.g:6768:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6772:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // InternalOptimisationLanguage.g:6773:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // InternalOptimisationLanguage.g:6773:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // InternalOptimisationLanguage.g:6774:2: ( rule__QualifiedName__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            }
            // InternalOptimisationLanguage.g:6775:2: ( rule__QualifiedName__Group_1__0 )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==58) ) {
                    int LA45_2 = input.LA(2);

                    if ( (LA45_2==RULE_QUOTED_ID) ) {
                        int LA45_3 = input.LA(3);

                        if ( (synpred84_InternalOptimisationLanguage()) ) {
                            alt45=1;
                        }


                    }
                    else if ( (LA45_2==RULE_ID) ) {
                        int LA45_4 = input.LA(3);

                        if ( (synpred84_InternalOptimisationLanguage()) ) {
                            alt45=1;
                        }


                    }


                }


                switch (alt45) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:6775:3: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_45);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop45;
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
    // InternalOptimisationLanguage.g:6784:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6788:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // InternalOptimisationLanguage.g:6789:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
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
    // InternalOptimisationLanguage.g:6796:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6800:1: ( ( '.' ) )
            // InternalOptimisationLanguage.g:6801:1: ( '.' )
            {
            // InternalOptimisationLanguage.g:6801:1: ( '.' )
            // InternalOptimisationLanguage.g:6802:2: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            }
            match(input,58,FOLLOW_2); if (state.failed) return ;
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
    // InternalOptimisationLanguage.g:6811:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6815:1: ( rule__QualifiedName__Group_1__1__Impl )
            // InternalOptimisationLanguage.g:6816:2: rule__QualifiedName__Group_1__1__Impl
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
    // InternalOptimisationLanguage.g:6822:1: rule__QualifiedName__Group_1__1__Impl : ( ruleStringOrId ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6826:1: ( ( ruleStringOrId ) )
            // InternalOptimisationLanguage.g:6827:1: ( ruleStringOrId )
            {
            // InternalOptimisationLanguage.g:6827:1: ( ruleStringOrId )
            // InternalOptimisationLanguage.g:6828:2: ruleStringOrId
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
    // InternalOptimisationLanguage.g:6838:1: rule__OptimisationModelRule__ImportsAssignment_0 : ( ruleImportRule ) ;
    public final void rule__OptimisationModelRule__ImportsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6842:1: ( ( ruleImportRule ) )
            // InternalOptimisationLanguage.g:6843:2: ( ruleImportRule )
            {
            // InternalOptimisationLanguage.g:6843:2: ( ruleImportRule )
            // InternalOptimisationLanguage.g:6844:3: ruleImportRule
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
    // InternalOptimisationLanguage.g:6853:1: rule__OptimisationModelRule__NameAssignment_2 : ( ruleQualifiedName ) ;
    public final void rule__OptimisationModelRule__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6857:1: ( ( ruleQualifiedName ) )
            // InternalOptimisationLanguage.g:6858:2: ( ruleQualifiedName )
            {
            // InternalOptimisationLanguage.g:6858:2: ( ruleQualifiedName )
            // InternalOptimisationLanguage.g:6859:3: ruleQualifiedName
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
    // InternalOptimisationLanguage.g:6868:1: rule__OptimisationModelRule__ProblemAssignment_4 : ( ruleProblemRule ) ;
    public final void rule__OptimisationModelRule__ProblemAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6872:1: ( ( ruleProblemRule ) )
            // InternalOptimisationLanguage.g:6873:2: ( ruleProblemRule )
            {
            // InternalOptimisationLanguage.g:6873:2: ( ruleProblemRule )
            // InternalOptimisationLanguage.g:6874:3: ruleProblemRule
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
    // InternalOptimisationLanguage.g:6883:1: rule__OptimisationModelRule__AlgorithmAssignment_5 : ( ruleAlgorithmInstanceRule ) ;
    public final void rule__OptimisationModelRule__AlgorithmAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6887:1: ( ( ruleAlgorithmInstanceRule ) )
            // InternalOptimisationLanguage.g:6888:2: ( ruleAlgorithmInstanceRule )
            {
            // InternalOptimisationLanguage.g:6888:2: ( ruleAlgorithmInstanceRule )
            // InternalOptimisationLanguage.g:6889:3: ruleAlgorithmInstanceRule
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
    // InternalOptimisationLanguage.g:6898:1: rule__ProblemRule__DefinitionAssignment_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__ProblemRule__DefinitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6902:1: ( ( ( ruleQualifiedName ) ) )
            // InternalOptimisationLanguage.g:6903:2: ( ( ruleQualifiedName ) )
            {
            // InternalOptimisationLanguage.g:6903:2: ( ( ruleQualifiedName ) )
            // InternalOptimisationLanguage.g:6904:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProblemRuleAccess().getDefinitionClassDefinitionCrossReference_1_0()); 
            }
            // InternalOptimisationLanguage.g:6905:3: ( ruleQualifiedName )
            // InternalOptimisationLanguage.g:6906:4: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProblemRuleAccess().getDefinitionClassDefinitionQualifiedNameParserRuleCall_1_0_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getProblemRuleAccess().getDefinitionClassDefinitionQualifiedNameParserRuleCall_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getProblemRuleAccess().getDefinitionClassDefinitionCrossReference_1_0()); 
            }

            }


            }

        }
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
    // InternalOptimisationLanguage.g:6917:1: rule__ProblemRule__NameAssignment_2 : ( ruleStringOrId ) ;
    public final void rule__ProblemRule__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6921:1: ( ( ruleStringOrId ) )
            // InternalOptimisationLanguage.g:6922:2: ( ruleStringOrId )
            {
            // InternalOptimisationLanguage.g:6922:2: ( ruleStringOrId )
            // InternalOptimisationLanguage.g:6923:3: ruleStringOrId
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


    // $ANTLR start "rule__ProblemRule__SearchSpaceAssignment_6"
    // InternalOptimisationLanguage.g:6932:1: rule__ProblemRule__SearchSpaceAssignment_6 : ( ruleTypeDefinitionReferenceRule ) ;
    public final void rule__ProblemRule__SearchSpaceAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6936:1: ( ( ruleTypeDefinitionReferenceRule ) )
            // InternalOptimisationLanguage.g:6937:2: ( ruleTypeDefinitionReferenceRule )
            {
            // InternalOptimisationLanguage.g:6937:2: ( ruleTypeDefinitionReferenceRule )
            // InternalOptimisationLanguage.g:6938:3: ruleTypeDefinitionReferenceRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProblemRuleAccess().getSearchSpaceTypeDefinitionReferenceRuleParserRuleCall_6_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleTypeDefinitionReferenceRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getProblemRuleAccess().getSearchSpaceTypeDefinitionReferenceRuleParserRuleCall_6_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemRule__SearchSpaceAssignment_6"


    // $ANTLR start "rule__ProblemRule__SearchSpaceAssignment_7_1"
    // InternalOptimisationLanguage.g:6947:1: rule__ProblemRule__SearchSpaceAssignment_7_1 : ( ruleTypeDefinitionReferenceRule ) ;
    public final void rule__ProblemRule__SearchSpaceAssignment_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6951:1: ( ( ruleTypeDefinitionReferenceRule ) )
            // InternalOptimisationLanguage.g:6952:2: ( ruleTypeDefinitionReferenceRule )
            {
            // InternalOptimisationLanguage.g:6952:2: ( ruleTypeDefinitionReferenceRule )
            // InternalOptimisationLanguage.g:6953:3: ruleTypeDefinitionReferenceRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProblemRuleAccess().getSearchSpaceTypeDefinitionReferenceRuleParserRuleCall_7_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleTypeDefinitionReferenceRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getProblemRuleAccess().getSearchSpaceTypeDefinitionReferenceRuleParserRuleCall_7_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemRule__SearchSpaceAssignment_7_1"


    // $ANTLR start "rule__ProblemRule__OptimisationFunctionAssignment_10"
    // InternalOptimisationLanguage.g:6962:1: rule__ProblemRule__OptimisationFunctionAssignment_10 : ( ruleInstanceLiteralRule ) ;
    public final void rule__ProblemRule__OptimisationFunctionAssignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6966:1: ( ( ruleInstanceLiteralRule ) )
            // InternalOptimisationLanguage.g:6967:2: ( ruleInstanceLiteralRule )
            {
            // InternalOptimisationLanguage.g:6967:2: ( ruleInstanceLiteralRule )
            // InternalOptimisationLanguage.g:6968:3: ruleInstanceLiteralRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProblemRuleAccess().getOptimisationFunctionInstanceLiteralRuleParserRuleCall_10_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleInstanceLiteralRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getProblemRuleAccess().getOptimisationFunctionInstanceLiteralRuleParserRuleCall_10_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemRule__OptimisationFunctionAssignment_10"


    // $ANTLR start "rule__ProblemRule__OptimisationSpaceAssignment_12"
    // InternalOptimisationLanguage.g:6977:1: rule__ProblemRule__OptimisationSpaceAssignment_12 : ( ruleOptimisationGoalRule ) ;
    public final void rule__ProblemRule__OptimisationSpaceAssignment_12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6981:1: ( ( ruleOptimisationGoalRule ) )
            // InternalOptimisationLanguage.g:6982:2: ( ruleOptimisationGoalRule )
            {
            // InternalOptimisationLanguage.g:6982:2: ( ruleOptimisationGoalRule )
            // InternalOptimisationLanguage.g:6983:3: ruleOptimisationGoalRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProblemRuleAccess().getOptimisationSpaceOptimisationGoalRuleParserRuleCall_12_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleOptimisationGoalRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getProblemRuleAccess().getOptimisationSpaceOptimisationGoalRuleParserRuleCall_12_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemRule__OptimisationSpaceAssignment_12"


    // $ANTLR start "rule__ProblemRule__OptimisationSpaceAssignment_13_1"
    // InternalOptimisationLanguage.g:6992:1: rule__ProblemRule__OptimisationSpaceAssignment_13_1 : ( ruleOptimisationGoalRule ) ;
    public final void rule__ProblemRule__OptimisationSpaceAssignment_13_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6996:1: ( ( ruleOptimisationGoalRule ) )
            // InternalOptimisationLanguage.g:6997:2: ( ruleOptimisationGoalRule )
            {
            // InternalOptimisationLanguage.g:6997:2: ( ruleOptimisationGoalRule )
            // InternalOptimisationLanguage.g:6998:3: ruleOptimisationGoalRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProblemRuleAccess().getOptimisationSpaceOptimisationGoalRuleParserRuleCall_13_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleOptimisationGoalRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getProblemRuleAccess().getOptimisationSpaceOptimisationGoalRuleParserRuleCall_13_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemRule__OptimisationSpaceAssignment_13_1"


    // $ANTLR start "rule__ProblemRule__DocumentationAssignment_14_1"
    // InternalOptimisationLanguage.g:7007:1: rule__ProblemRule__DocumentationAssignment_14_1 : ( ruleArrayRule ) ;
    public final void rule__ProblemRule__DocumentationAssignment_14_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7011:1: ( ( ruleArrayRule ) )
            // InternalOptimisationLanguage.g:7012:2: ( ruleArrayRule )
            {
            // InternalOptimisationLanguage.g:7012:2: ( ruleArrayRule )
            // InternalOptimisationLanguage.g:7013:3: ruleArrayRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProblemRuleAccess().getDocumentationArrayRuleParserRuleCall_14_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleArrayRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getProblemRuleAccess().getDocumentationArrayRuleParserRuleCall_14_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemRule__DocumentationAssignment_14_1"


    // $ANTLR start "rule__MaximiseGoalRule__DataAssignment_1"
    // InternalOptimisationLanguage.g:7022:1: rule__MaximiseGoalRule__DataAssignment_1 : ( ruleTypeDefinitionReferenceRule ) ;
    public final void rule__MaximiseGoalRule__DataAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7026:1: ( ( ruleTypeDefinitionReferenceRule ) )
            // InternalOptimisationLanguage.g:7027:2: ( ruleTypeDefinitionReferenceRule )
            {
            // InternalOptimisationLanguage.g:7027:2: ( ruleTypeDefinitionReferenceRule )
            // InternalOptimisationLanguage.g:7028:3: ruleTypeDefinitionReferenceRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMaximiseGoalRuleAccess().getDataTypeDefinitionReferenceRuleParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleTypeDefinitionReferenceRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMaximiseGoalRuleAccess().getDataTypeDefinitionReferenceRuleParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MaximiseGoalRule__DataAssignment_1"


    // $ANTLR start "rule__MinimiseGoalRule__DataAssignment_1"
    // InternalOptimisationLanguage.g:7037:1: rule__MinimiseGoalRule__DataAssignment_1 : ( ruleTypeDefinitionReferenceRule ) ;
    public final void rule__MinimiseGoalRule__DataAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7041:1: ( ( ruleTypeDefinitionReferenceRule ) )
            // InternalOptimisationLanguage.g:7042:2: ( ruleTypeDefinitionReferenceRule )
            {
            // InternalOptimisationLanguage.g:7042:2: ( ruleTypeDefinitionReferenceRule )
            // InternalOptimisationLanguage.g:7043:3: ruleTypeDefinitionReferenceRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMinimiseGoalRuleAccess().getDataTypeDefinitionReferenceRuleParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleTypeDefinitionReferenceRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMinimiseGoalRuleAccess().getDataTypeDefinitionReferenceRuleParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MinimiseGoalRule__DataAssignment_1"


    // $ANTLR start "rule__TargetGoalRule__DataAssignment_1"
    // InternalOptimisationLanguage.g:7052:1: rule__TargetGoalRule__DataAssignment_1 : ( ruleTypeDefinitionReferenceRule ) ;
    public final void rule__TargetGoalRule__DataAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7056:1: ( ( ruleTypeDefinitionReferenceRule ) )
            // InternalOptimisationLanguage.g:7057:2: ( ruleTypeDefinitionReferenceRule )
            {
            // InternalOptimisationLanguage.g:7057:2: ( ruleTypeDefinitionReferenceRule )
            // InternalOptimisationLanguage.g:7058:3: ruleTypeDefinitionReferenceRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTargetGoalRuleAccess().getDataTypeDefinitionReferenceRuleParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleTypeDefinitionReferenceRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTargetGoalRuleAccess().getDataTypeDefinitionReferenceRuleParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TargetGoalRule__DataAssignment_1"


    // $ANTLR start "rule__TargetGoalRule__FromEvaluationAssignment_3_0"
    // InternalOptimisationLanguage.g:7067:1: rule__TargetGoalRule__FromEvaluationAssignment_3_0 : ( ( 'target' ) ) ;
    public final void rule__TargetGoalRule__FromEvaluationAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7071:1: ( ( ( 'target' ) ) )
            // InternalOptimisationLanguage.g:7072:2: ( ( 'target' ) )
            {
            // InternalOptimisationLanguage.g:7072:2: ( ( 'target' ) )
            // InternalOptimisationLanguage.g:7073:3: ( 'target' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTargetGoalRuleAccess().getFromEvaluationTargetKeyword_3_0_0()); 
            }
            // InternalOptimisationLanguage.g:7074:3: ( 'target' )
            // InternalOptimisationLanguage.g:7075:4: 'target'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTargetGoalRuleAccess().getFromEvaluationTargetKeyword_3_0_0()); 
            }
            match(input,92,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTargetGoalRuleAccess().getFromEvaluationTargetKeyword_3_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTargetGoalRuleAccess().getFromEvaluationTargetKeyword_3_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TargetGoalRule__FromEvaluationAssignment_3_0"


    // $ANTLR start "rule__TargetGoalRule__ValueAssignment_3_1"
    // InternalOptimisationLanguage.g:7086:1: rule__TargetGoalRule__ValueAssignment_3_1 : ( ruleLiteralRule ) ;
    public final void rule__TargetGoalRule__ValueAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7090:1: ( ( ruleLiteralRule ) )
            // InternalOptimisationLanguage.g:7091:2: ( ruleLiteralRule )
            {
            // InternalOptimisationLanguage.g:7091:2: ( ruleLiteralRule )
            // InternalOptimisationLanguage.g:7092:3: ruleLiteralRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTargetGoalRuleAccess().getValueLiteralRuleParserRuleCall_3_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleLiteralRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTargetGoalRuleAccess().getValueLiteralRuleParserRuleCall_3_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TargetGoalRule__ValueAssignment_3_1"


    // $ANTLR start "rule__TargetGoalRule__DistanceAssignment_5"
    // InternalOptimisationLanguage.g:7101:1: rule__TargetGoalRule__DistanceAssignment_5 : ( ruleInstanceLiteralRule ) ;
    public final void rule__TargetGoalRule__DistanceAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7105:1: ( ( ruleInstanceLiteralRule ) )
            // InternalOptimisationLanguage.g:7106:2: ( ruleInstanceLiteralRule )
            {
            // InternalOptimisationLanguage.g:7106:2: ( ruleInstanceLiteralRule )
            // InternalOptimisationLanguage.g:7107:3: ruleInstanceLiteralRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTargetGoalRuleAccess().getDistanceInstanceLiteralRuleParserRuleCall_5_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleInstanceLiteralRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTargetGoalRuleAccess().getDistanceInstanceLiteralRuleParserRuleCall_5_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TargetGoalRule__DistanceAssignment_5"


    // $ANTLR start "rule__AlgorithmInstanceRule__DefinitionAssignment_1"
    // InternalOptimisationLanguage.g:7116:1: rule__AlgorithmInstanceRule__DefinitionAssignment_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__AlgorithmInstanceRule__DefinitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7120:1: ( ( ( ruleQualifiedName ) ) )
            // InternalOptimisationLanguage.g:7121:2: ( ( ruleQualifiedName ) )
            {
            // InternalOptimisationLanguage.g:7121:2: ( ( ruleQualifiedName ) )
            // InternalOptimisationLanguage.g:7122:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAlgorithmInstanceRuleAccess().getDefinitionClassDefinitionCrossReference_1_0()); 
            }
            // InternalOptimisationLanguage.g:7123:3: ( ruleQualifiedName )
            // InternalOptimisationLanguage.g:7124:4: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAlgorithmInstanceRuleAccess().getDefinitionClassDefinitionQualifiedNameParserRuleCall_1_0_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAlgorithmInstanceRuleAccess().getDefinitionClassDefinitionQualifiedNameParserRuleCall_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAlgorithmInstanceRuleAccess().getDefinitionClassDefinitionCrossReference_1_0()); 
            }

            }


            }

        }
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
    // InternalOptimisationLanguage.g:7135:1: rule__AlgorithmInstanceRule__ProblemAssignment_3 : ( ( ruleQualifiedName ) ) ;
    public final void rule__AlgorithmInstanceRule__ProblemAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7139:1: ( ( ( ruleQualifiedName ) ) )
            // InternalOptimisationLanguage.g:7140:2: ( ( ruleQualifiedName ) )
            {
            // InternalOptimisationLanguage.g:7140:2: ( ( ruleQualifiedName ) )
            // InternalOptimisationLanguage.g:7141:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAlgorithmInstanceRuleAccess().getProblemProblemInstanceCrossReference_3_0()); 
            }
            // InternalOptimisationLanguage.g:7142:3: ( ruleQualifiedName )
            // InternalOptimisationLanguage.g:7143:4: ruleQualifiedName
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
    // InternalOptimisationLanguage.g:7154:1: rule__AlgorithmInstanceRule__AttributesAssignment_5 : ( ruleAttributeRule ) ;
    public final void rule__AlgorithmInstanceRule__AttributesAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7158:1: ( ( ruleAttributeRule ) )
            // InternalOptimisationLanguage.g:7159:2: ( ruleAttributeRule )
            {
            // InternalOptimisationLanguage.g:7159:2: ( ruleAttributeRule )
            // InternalOptimisationLanguage.g:7160:3: ruleAttributeRule
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
    // InternalOptimisationLanguage.g:7169:1: rule__AlgorithmInstanceRule__DocumentationAssignment_6_2 : ( ruleArrayRule ) ;
    public final void rule__AlgorithmInstanceRule__DocumentationAssignment_6_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7173:1: ( ( ruleArrayRule ) )
            // InternalOptimisationLanguage.g:7174:2: ( ruleArrayRule )
            {
            // InternalOptimisationLanguage.g:7174:2: ( ruleArrayRule )
            // InternalOptimisationLanguage.g:7175:3: ruleArrayRule
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


    // $ANTLR start "rule__OrExpressionRule__SubExpressionsAssignment_0"
    // InternalOptimisationLanguage.g:7184:1: rule__OrExpressionRule__SubExpressionsAssignment_0 : ( ruleXorExpressionRule ) ;
    public final void rule__OrExpressionRule__SubExpressionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7188:1: ( ( ruleXorExpressionRule ) )
            // InternalOptimisationLanguage.g:7189:2: ( ruleXorExpressionRule )
            {
            // InternalOptimisationLanguage.g:7189:2: ( ruleXorExpressionRule )
            // InternalOptimisationLanguage.g:7190:3: ruleXorExpressionRule
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
    // InternalOptimisationLanguage.g:7199:1: rule__OrExpressionRule__SubExpressionsAssignment_1_1 : ( ruleXorExpressionRule ) ;
    public final void rule__OrExpressionRule__SubExpressionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7203:1: ( ( ruleXorExpressionRule ) )
            // InternalOptimisationLanguage.g:7204:2: ( ruleXorExpressionRule )
            {
            // InternalOptimisationLanguage.g:7204:2: ( ruleXorExpressionRule )
            // InternalOptimisationLanguage.g:7205:3: ruleXorExpressionRule
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
    // InternalOptimisationLanguage.g:7214:1: rule__XorExpressionRule__SubExpressionsAssignment_0 : ( ruleAndExpressionRule ) ;
    public final void rule__XorExpressionRule__SubExpressionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7218:1: ( ( ruleAndExpressionRule ) )
            // InternalOptimisationLanguage.g:7219:2: ( ruleAndExpressionRule )
            {
            // InternalOptimisationLanguage.g:7219:2: ( ruleAndExpressionRule )
            // InternalOptimisationLanguage.g:7220:3: ruleAndExpressionRule
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
    // InternalOptimisationLanguage.g:7229:1: rule__XorExpressionRule__SubExpressionsAssignment_1_1 : ( ruleAndExpressionRule ) ;
    public final void rule__XorExpressionRule__SubExpressionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7233:1: ( ( ruleAndExpressionRule ) )
            // InternalOptimisationLanguage.g:7234:2: ( ruleAndExpressionRule )
            {
            // InternalOptimisationLanguage.g:7234:2: ( ruleAndExpressionRule )
            // InternalOptimisationLanguage.g:7235:3: ruleAndExpressionRule
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
    // InternalOptimisationLanguage.g:7244:1: rule__AndExpressionRule__SubExpressionsAssignment_0 : ( ruleNotExpressionRule ) ;
    public final void rule__AndExpressionRule__SubExpressionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7248:1: ( ( ruleNotExpressionRule ) )
            // InternalOptimisationLanguage.g:7249:2: ( ruleNotExpressionRule )
            {
            // InternalOptimisationLanguage.g:7249:2: ( ruleNotExpressionRule )
            // InternalOptimisationLanguage.g:7250:3: ruleNotExpressionRule
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
    // InternalOptimisationLanguage.g:7259:1: rule__AndExpressionRule__SubExpressionsAssignment_1_1 : ( ruleNotExpressionRule ) ;
    public final void rule__AndExpressionRule__SubExpressionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7263:1: ( ( ruleNotExpressionRule ) )
            // InternalOptimisationLanguage.g:7264:2: ( ruleNotExpressionRule )
            {
            // InternalOptimisationLanguage.g:7264:2: ( ruleNotExpressionRule )
            // InternalOptimisationLanguage.g:7265:3: ruleNotExpressionRule
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
    // InternalOptimisationLanguage.g:7274:1: rule__NotExpressionRule__NegatedAssignment_0 : ( ( '!' ) ) ;
    public final void rule__NotExpressionRule__NegatedAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7278:1: ( ( ( '!' ) ) )
            // InternalOptimisationLanguage.g:7279:2: ( ( '!' ) )
            {
            // InternalOptimisationLanguage.g:7279:2: ( ( '!' ) )
            // InternalOptimisationLanguage.g:7280:3: ( '!' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNotExpressionRuleAccess().getNegatedExclamationMarkKeyword_0_0()); 
            }
            // InternalOptimisationLanguage.g:7281:3: ( '!' )
            // InternalOptimisationLanguage.g:7282:4: '!'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNotExpressionRuleAccess().getNegatedExclamationMarkKeyword_0_0()); 
            }
            match(input,93,FOLLOW_2); if (state.failed) return ;
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
    // InternalOptimisationLanguage.g:7293:1: rule__NotExpressionRule__OperandAssignment_1 : ( ruleComparisonExpressionRule ) ;
    public final void rule__NotExpressionRule__OperandAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7297:1: ( ( ruleComparisonExpressionRule ) )
            // InternalOptimisationLanguage.g:7298:2: ( ruleComparisonExpressionRule )
            {
            // InternalOptimisationLanguage.g:7298:2: ( ruleComparisonExpressionRule )
            // InternalOptimisationLanguage.g:7299:3: ruleComparisonExpressionRule
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
    // InternalOptimisationLanguage.g:7308:1: rule__ComparisonExpressionRule__LeftOperandAssignment_0 : ( ruleAddOrSubtractExpressionRule ) ;
    public final void rule__ComparisonExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7312:1: ( ( ruleAddOrSubtractExpressionRule ) )
            // InternalOptimisationLanguage.g:7313:2: ( ruleAddOrSubtractExpressionRule )
            {
            // InternalOptimisationLanguage.g:7313:2: ( ruleAddOrSubtractExpressionRule )
            // InternalOptimisationLanguage.g:7314:3: ruleAddOrSubtractExpressionRule
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
    // InternalOptimisationLanguage.g:7323:1: rule__ComparisonExpressionRule__ComparisonAssignment_1 : ( rulePartialComparisonExpressionRule ) ;
    public final void rule__ComparisonExpressionRule__ComparisonAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7327:1: ( ( rulePartialComparisonExpressionRule ) )
            // InternalOptimisationLanguage.g:7328:2: ( rulePartialComparisonExpressionRule )
            {
            // InternalOptimisationLanguage.g:7328:2: ( rulePartialComparisonExpressionRule )
            // InternalOptimisationLanguage.g:7329:3: rulePartialComparisonExpressionRule
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
    // InternalOptimisationLanguage.g:7338:1: rule__PartialComparisonExpressionRule__OperatorAssignment_0 : ( ruleComparisonOperatorRule ) ;
    public final void rule__PartialComparisonExpressionRule__OperatorAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7342:1: ( ( ruleComparisonOperatorRule ) )
            // InternalOptimisationLanguage.g:7343:2: ( ruleComparisonOperatorRule )
            {
            // InternalOptimisationLanguage.g:7343:2: ( ruleComparisonOperatorRule )
            // InternalOptimisationLanguage.g:7344:3: ruleComparisonOperatorRule
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
    // InternalOptimisationLanguage.g:7353:1: rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 : ( ruleAddOrSubtractExpressionRule ) ;
    public final void rule__PartialComparisonExpressionRule__SubExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7357:1: ( ( ruleAddOrSubtractExpressionRule ) )
            // InternalOptimisationLanguage.g:7358:2: ( ruleAddOrSubtractExpressionRule )
            {
            // InternalOptimisationLanguage.g:7358:2: ( ruleAddOrSubtractExpressionRule )
            // InternalOptimisationLanguage.g:7359:3: ruleAddOrSubtractExpressionRule
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
    // InternalOptimisationLanguage.g:7368:1: rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 : ( ruleMultiplyDivideModuloExpressionRule ) ;
    public final void rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7372:1: ( ( ruleMultiplyDivideModuloExpressionRule ) )
            // InternalOptimisationLanguage.g:7373:2: ( ruleMultiplyDivideModuloExpressionRule )
            {
            // InternalOptimisationLanguage.g:7373:2: ( ruleMultiplyDivideModuloExpressionRule )
            // InternalOptimisationLanguage.g:7374:3: ruleMultiplyDivideModuloExpressionRule
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
    // InternalOptimisationLanguage.g:7383:1: rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 : ( ruleAddOrSubtractOperatorRule ) ;
    public final void rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7387:1: ( ( ruleAddOrSubtractOperatorRule ) )
            // InternalOptimisationLanguage.g:7388:2: ( ruleAddOrSubtractOperatorRule )
            {
            // InternalOptimisationLanguage.g:7388:2: ( ruleAddOrSubtractOperatorRule )
            // InternalOptimisationLanguage.g:7389:3: ruleAddOrSubtractOperatorRule
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
    // InternalOptimisationLanguage.g:7398:1: rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 : ( ruleMultiplyDivideModuloExpressionRule ) ;
    public final void rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7402:1: ( ( ruleMultiplyDivideModuloExpressionRule ) )
            // InternalOptimisationLanguage.g:7403:2: ( ruleMultiplyDivideModuloExpressionRule )
            {
            // InternalOptimisationLanguage.g:7403:2: ( ruleMultiplyDivideModuloExpressionRule )
            // InternalOptimisationLanguage.g:7404:3: ruleMultiplyDivideModuloExpressionRule
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
    // InternalOptimisationLanguage.g:7413:1: rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 : ( rulePowerOfExpressionRule ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7417:1: ( ( rulePowerOfExpressionRule ) )
            // InternalOptimisationLanguage.g:7418:2: ( rulePowerOfExpressionRule )
            {
            // InternalOptimisationLanguage.g:7418:2: ( rulePowerOfExpressionRule )
            // InternalOptimisationLanguage.g:7419:3: rulePowerOfExpressionRule
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
    // InternalOptimisationLanguage.g:7428:1: rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 : ( ruleMultiplyDivideModuloOperatorRule ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7432:1: ( ( ruleMultiplyDivideModuloOperatorRule ) )
            // InternalOptimisationLanguage.g:7433:2: ( ruleMultiplyDivideModuloOperatorRule )
            {
            // InternalOptimisationLanguage.g:7433:2: ( ruleMultiplyDivideModuloOperatorRule )
            // InternalOptimisationLanguage.g:7434:3: ruleMultiplyDivideModuloOperatorRule
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
    // InternalOptimisationLanguage.g:7443:1: rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 : ( rulePowerOfExpressionRule ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7447:1: ( ( rulePowerOfExpressionRule ) )
            // InternalOptimisationLanguage.g:7448:2: ( rulePowerOfExpressionRule )
            {
            // InternalOptimisationLanguage.g:7448:2: ( rulePowerOfExpressionRule )
            // InternalOptimisationLanguage.g:7449:3: rulePowerOfExpressionRule
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
    // InternalOptimisationLanguage.g:7458:1: rule__PowerOfExpressionRule__LeftOperandAssignment_0 : ( ruleUnaryAddOrSubtractExpressionRule ) ;
    public final void rule__PowerOfExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7462:1: ( ( ruleUnaryAddOrSubtractExpressionRule ) )
            // InternalOptimisationLanguage.g:7463:2: ( ruleUnaryAddOrSubtractExpressionRule )
            {
            // InternalOptimisationLanguage.g:7463:2: ( ruleUnaryAddOrSubtractExpressionRule )
            // InternalOptimisationLanguage.g:7464:3: ruleUnaryAddOrSubtractExpressionRule
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
    // InternalOptimisationLanguage.g:7473:1: rule__PowerOfExpressionRule__RightOperandAssignment_1_1 : ( rulePowerOfExpressionRule ) ;
    public final void rule__PowerOfExpressionRule__RightOperandAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7477:1: ( ( rulePowerOfExpressionRule ) )
            // InternalOptimisationLanguage.g:7478:2: ( rulePowerOfExpressionRule )
            {
            // InternalOptimisationLanguage.g:7478:2: ( rulePowerOfExpressionRule )
            // InternalOptimisationLanguage.g:7479:3: rulePowerOfExpressionRule
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
    // InternalOptimisationLanguage.g:7488:1: rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 : ( ruleAddOrSubtractOperatorRule ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7492:1: ( ( ruleAddOrSubtractOperatorRule ) )
            // InternalOptimisationLanguage.g:7493:2: ( ruleAddOrSubtractOperatorRule )
            {
            // InternalOptimisationLanguage.g:7493:2: ( ruleAddOrSubtractOperatorRule )
            // InternalOptimisationLanguage.g:7494:3: ruleAddOrSubtractOperatorRule
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
    // InternalOptimisationLanguage.g:7503:1: rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 : ( ruleReadExpressionRule ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7507:1: ( ( ruleReadExpressionRule ) )
            // InternalOptimisationLanguage.g:7508:2: ( ruleReadExpressionRule )
            {
            // InternalOptimisationLanguage.g:7508:2: ( ruleReadExpressionRule )
            // InternalOptimisationLanguage.g:7509:3: ruleReadExpressionRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getSubExpressionReadExpressionRuleParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleReadExpressionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getSubExpressionReadExpressionRuleParserRuleCall_1_0()); 
            }

            }


            }

        }
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
    // InternalOptimisationLanguage.g:7518:1: rule__ArrayRule__ValuesAssignment_2_0 : ( ruleOrExpressionRule ) ;
    public final void rule__ArrayRule__ValuesAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7522:1: ( ( ruleOrExpressionRule ) )
            // InternalOptimisationLanguage.g:7523:2: ( ruleOrExpressionRule )
            {
            // InternalOptimisationLanguage.g:7523:2: ( ruleOrExpressionRule )
            // InternalOptimisationLanguage.g:7524:3: ruleOrExpressionRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayRuleAccess().getValuesOrExpressionRuleParserRuleCall_2_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleOrExpressionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getArrayRuleAccess().getValuesOrExpressionRuleParserRuleCall_2_0_0()); 
            }

            }


            }

        }
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
    // InternalOptimisationLanguage.g:7533:1: rule__ArrayRule__ValuesAssignment_2_1_1 : ( ruleOrExpressionRule ) ;
    public final void rule__ArrayRule__ValuesAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7537:1: ( ( ruleOrExpressionRule ) )
            // InternalOptimisationLanguage.g:7538:2: ( ruleOrExpressionRule )
            {
            // InternalOptimisationLanguage.g:7538:2: ( ruleOrExpressionRule )
            // InternalOptimisationLanguage.g:7539:3: ruleOrExpressionRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayRuleAccess().getValuesOrExpressionRuleParserRuleCall_2_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleOrExpressionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getArrayRuleAccess().getValuesOrExpressionRuleParserRuleCall_2_1_1_0()); 
            }

            }


            }

        }
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
    // InternalOptimisationLanguage.g:7548:1: rule__ParanthesesRule__SubExpressionAssignment_1 : ( ruleExpressionRule ) ;
    public final void rule__ParanthesesRule__SubExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7552:1: ( ( ruleExpressionRule ) )
            // InternalOptimisationLanguage.g:7553:2: ( ruleExpressionRule )
            {
            // InternalOptimisationLanguage.g:7553:2: ( ruleExpressionRule )
            // InternalOptimisationLanguage.g:7554:3: ruleExpressionRule
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
    // InternalOptimisationLanguage.g:7563:1: rule__CallRule__FunctionAssignment_0 : ( ( ruleQualifiedName ) ) ;
    public final void rule__CallRule__FunctionAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7567:1: ( ( ( ruleQualifiedName ) ) )
            // InternalOptimisationLanguage.g:7568:2: ( ( ruleQualifiedName ) )
            {
            // InternalOptimisationLanguage.g:7568:2: ( ( ruleQualifiedName ) )
            // InternalOptimisationLanguage.g:7569:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getFunctionFunctionDefinitionCrossReference_0_0()); 
            }
            // InternalOptimisationLanguage.g:7570:3: ( ruleQualifiedName )
            // InternalOptimisationLanguage.g:7571:4: ruleQualifiedName
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
    // InternalOptimisationLanguage.g:7582:1: rule__CallRule__ParametersAssignment_2_0 : ( ruleExpressionRule ) ;
    public final void rule__CallRule__ParametersAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7586:1: ( ( ruleExpressionRule ) )
            // InternalOptimisationLanguage.g:7587:2: ( ruleExpressionRule )
            {
            // InternalOptimisationLanguage.g:7587:2: ( ruleExpressionRule )
            // InternalOptimisationLanguage.g:7588:3: ruleExpressionRule
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
    // InternalOptimisationLanguage.g:7597:1: rule__CallRule__ParametersAssignment_2_1_1 : ( ruleExpressionRule ) ;
    public final void rule__CallRule__ParametersAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7601:1: ( ( ruleExpressionRule ) )
            // InternalOptimisationLanguage.g:7602:2: ( ruleExpressionRule )
            {
            // InternalOptimisationLanguage.g:7602:2: ( ruleExpressionRule )
            // InternalOptimisationLanguage.g:7603:3: ruleExpressionRule
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


    // $ANTLR start "rule__AttributeReferenceRule__SelfAssignment_0"
    // InternalOptimisationLanguage.g:7612:1: rule__AttributeReferenceRule__SelfAssignment_0 : ( ruleSelfReferenceRule ) ;
    public final void rule__AttributeReferenceRule__SelfAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7616:1: ( ( ruleSelfReferenceRule ) )
            // InternalOptimisationLanguage.g:7617:2: ( ruleSelfReferenceRule )
            {
            // InternalOptimisationLanguage.g:7617:2: ( ruleSelfReferenceRule )
            // InternalOptimisationLanguage.g:7618:3: ruleSelfReferenceRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeReferenceRuleAccess().getSelfSelfReferenceRuleParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleSelfReferenceRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeReferenceRuleAccess().getSelfSelfReferenceRuleParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeReferenceRule__SelfAssignment_0"


    // $ANTLR start "rule__AttributeReferenceRule__ChainAssignment_1_1"
    // InternalOptimisationLanguage.g:7627:1: rule__AttributeReferenceRule__ChainAssignment_1_1 : ( ruleValuelDefinitionReferenceRule ) ;
    public final void rule__AttributeReferenceRule__ChainAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7631:1: ( ( ruleValuelDefinitionReferenceRule ) )
            // InternalOptimisationLanguage.g:7632:2: ( ruleValuelDefinitionReferenceRule )
            {
            // InternalOptimisationLanguage.g:7632:2: ( ruleValuelDefinitionReferenceRule )
            // InternalOptimisationLanguage.g:7633:3: ruleValuelDefinitionReferenceRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeReferenceRuleAccess().getChainValuelDefinitionReferenceRuleParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleValuelDefinitionReferenceRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeReferenceRuleAccess().getChainValuelDefinitionReferenceRuleParserRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeReferenceRule__ChainAssignment_1_1"


    // $ANTLR start "rule__ConfigurationReferenceRule__ReferenceAssignment_1"
    // InternalOptimisationLanguage.g:7642:1: rule__ConfigurationReferenceRule__ReferenceAssignment_1 : ( ruleStringOrId ) ;
    public final void rule__ConfigurationReferenceRule__ReferenceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7646:1: ( ( ruleStringOrId ) )
            // InternalOptimisationLanguage.g:7647:2: ( ruleStringOrId )
            {
            // InternalOptimisationLanguage.g:7647:2: ( ruleStringOrId )
            // InternalOptimisationLanguage.g:7648:3: ruleStringOrId
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigurationReferenceRuleAccess().getReferenceStringOrIdParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleStringOrId();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConfigurationReferenceRuleAccess().getReferenceStringOrIdParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigurationReferenceRule__ReferenceAssignment_1"


    // $ANTLR start "rule__ValuelDefinitionReferenceRule__DefinitionAssignment"
    // InternalOptimisationLanguage.g:7657:1: rule__ValuelDefinitionReferenceRule__DefinitionAssignment : ( ( ruleQualifiedName ) ) ;
    public final void rule__ValuelDefinitionReferenceRule__DefinitionAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7661:1: ( ( ( ruleQualifiedName ) ) )
            // InternalOptimisationLanguage.g:7662:2: ( ( ruleQualifiedName ) )
            {
            // InternalOptimisationLanguage.g:7662:2: ( ( ruleQualifiedName ) )
            // InternalOptimisationLanguage.g:7663:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValuelDefinitionReferenceRuleAccess().getDefinitionValueDefinitionCrossReference_0()); 
            }
            // InternalOptimisationLanguage.g:7664:3: ( ruleQualifiedName )
            // InternalOptimisationLanguage.g:7665:4: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValuelDefinitionReferenceRuleAccess().getDefinitionValueDefinitionQualifiedNameParserRuleCall_0_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValuelDefinitionReferenceRuleAccess().getDefinitionValueDefinitionQualifiedNameParserRuleCall_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValuelDefinitionReferenceRuleAccess().getDefinitionValueDefinitionCrossReference_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValuelDefinitionReferenceRule__DefinitionAssignment"


    // $ANTLR start "rule__BaseDataReferenceRule__DefinitionAssignment_1"
    // InternalOptimisationLanguage.g:7676:1: rule__BaseDataReferenceRule__DefinitionAssignment_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__BaseDataReferenceRule__DefinitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7680:1: ( ( ( ruleQualifiedName ) ) )
            // InternalOptimisationLanguage.g:7681:2: ( ( ruleQualifiedName ) )
            {
            // InternalOptimisationLanguage.g:7681:2: ( ( ruleQualifiedName ) )
            // InternalOptimisationLanguage.g:7682:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBaseDataReferenceRuleAccess().getDefinitionBaseDataDescriptionCrossReference_1_0()); 
            }
            // InternalOptimisationLanguage.g:7683:3: ( ruleQualifiedName )
            // InternalOptimisationLanguage.g:7684:4: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBaseDataReferenceRuleAccess().getDefinitionBaseDataDescriptionQualifiedNameParserRuleCall_1_0_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBaseDataReferenceRuleAccess().getDefinitionBaseDataDescriptionQualifiedNameParserRuleCall_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBaseDataReferenceRuleAccess().getDefinitionBaseDataDescriptionCrossReference_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BaseDataReferenceRule__DefinitionAssignment_1"


    // $ANTLR start "rule__StructuredDataDescriptionReferenceRule__DefinitionAssignment_1"
    // InternalOptimisationLanguage.g:7695:1: rule__StructuredDataDescriptionReferenceRule__DefinitionAssignment_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__StructuredDataDescriptionReferenceRule__DefinitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7699:1: ( ( ( ruleQualifiedName ) ) )
            // InternalOptimisationLanguage.g:7700:2: ( ( ruleQualifiedName ) )
            {
            // InternalOptimisationLanguage.g:7700:2: ( ( ruleQualifiedName ) )
            // InternalOptimisationLanguage.g:7701:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStructuredDataDescriptionReferenceRuleAccess().getDefinitionStructuredDataDescriptionCrossReference_1_0()); 
            }
            // InternalOptimisationLanguage.g:7702:3: ( ruleQualifiedName )
            // InternalOptimisationLanguage.g:7703:4: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStructuredDataDescriptionReferenceRuleAccess().getDefinitionStructuredDataDescriptionQualifiedNameParserRuleCall_1_0_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getStructuredDataDescriptionReferenceRuleAccess().getDefinitionStructuredDataDescriptionQualifiedNameParserRuleCall_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getStructuredDataDescriptionReferenceRuleAccess().getDefinitionStructuredDataDescriptionCrossReference_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StructuredDataDescriptionReferenceRule__DefinitionAssignment_1"


    // $ANTLR start "rule__InstanceLiteralRule__DefinitionAssignment_0"
    // InternalOptimisationLanguage.g:7714:1: rule__InstanceLiteralRule__DefinitionAssignment_0 : ( ( ruleQualifiedName ) ) ;
    public final void rule__InstanceLiteralRule__DefinitionAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7718:1: ( ( ( ruleQualifiedName ) ) )
            // InternalOptimisationLanguage.g:7719:2: ( ( ruleQualifiedName ) )
            {
            // InternalOptimisationLanguage.g:7719:2: ( ( ruleQualifiedName ) )
            // InternalOptimisationLanguage.g:7720:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceLiteralRuleAccess().getDefinitionClassDefinitionCrossReference_0_0()); 
            }
            // InternalOptimisationLanguage.g:7721:3: ( ruleQualifiedName )
            // InternalOptimisationLanguage.g:7722:4: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceLiteralRuleAccess().getDefinitionClassDefinitionQualifiedNameParserRuleCall_0_0_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getInstanceLiteralRuleAccess().getDefinitionClassDefinitionQualifiedNameParserRuleCall_0_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getInstanceLiteralRuleAccess().getDefinitionClassDefinitionCrossReference_0_0()); 
            }

            }


            }

        }
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
    // InternalOptimisationLanguage.g:7733:1: rule__InstanceLiteralRule__AttributesAssignment_2 : ( ruleAttributeRule ) ;
    public final void rule__InstanceLiteralRule__AttributesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7737:1: ( ( ruleAttributeRule ) )
            // InternalOptimisationLanguage.g:7738:2: ( ruleAttributeRule )
            {
            // InternalOptimisationLanguage.g:7738:2: ( ruleAttributeRule )
            // InternalOptimisationLanguage.g:7739:3: ruleAttributeRule
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
    // InternalOptimisationLanguage.g:7748:1: rule__AttributeRule__DefinitionAssignment_0 : ( ( ruleStringOrId ) ) ;
    public final void rule__AttributeRule__DefinitionAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7752:1: ( ( ( ruleStringOrId ) ) )
            // InternalOptimisationLanguage.g:7753:2: ( ( ruleStringOrId ) )
            {
            // InternalOptimisationLanguage.g:7753:2: ( ( ruleStringOrId ) )
            // InternalOptimisationLanguage.g:7754:3: ( ruleStringOrId )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeRuleAccess().getDefinitionAttributeDefinitionCrossReference_0_0()); 
            }
            // InternalOptimisationLanguage.g:7755:3: ( ruleStringOrId )
            // InternalOptimisationLanguage.g:7756:4: ruleStringOrId
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
    // InternalOptimisationLanguage.g:7767:1: rule__AttributeRule__ValueAssignment_2 : ( ruleExpressionRule ) ;
    public final void rule__AttributeRule__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7771:1: ( ( ruleExpressionRule ) )
            // InternalOptimisationLanguage.g:7772:2: ( ruleExpressionRule )
            {
            // InternalOptimisationLanguage.g:7772:2: ( ruleExpressionRule )
            // InternalOptimisationLanguage.g:7773:3: ruleExpressionRule
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
    // InternalOptimisationLanguage.g:7782:1: rule__RealLiteralRule__LiteralAssignment_0 : ( RULE_DOUBLE ) ;
    public final void rule__RealLiteralRule__LiteralAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7786:1: ( ( RULE_DOUBLE ) )
            // InternalOptimisationLanguage.g:7787:2: ( RULE_DOUBLE )
            {
            // InternalOptimisationLanguage.g:7787:2: ( RULE_DOUBLE )
            // InternalOptimisationLanguage.g:7788:3: RULE_DOUBLE
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
    // InternalOptimisationLanguage.g:7797:1: rule__RealLiteralRule__FactorAssignment_1 : ( ruleFactorRule ) ;
    public final void rule__RealLiteralRule__FactorAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7801:1: ( ( ruleFactorRule ) )
            // InternalOptimisationLanguage.g:7802:2: ( ruleFactorRule )
            {
            // InternalOptimisationLanguage.g:7802:2: ( ruleFactorRule )
            // InternalOptimisationLanguage.g:7803:3: ruleFactorRule
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
    // InternalOptimisationLanguage.g:7812:1: rule__IntegerLiteralRule__LiteralAssignment_0 : ( RULE_INT ) ;
    public final void rule__IntegerLiteralRule__LiteralAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7816:1: ( ( RULE_INT ) )
            // InternalOptimisationLanguage.g:7817:2: ( RULE_INT )
            {
            // InternalOptimisationLanguage.g:7817:2: ( RULE_INT )
            // InternalOptimisationLanguage.g:7818:3: RULE_INT
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
    // InternalOptimisationLanguage.g:7827:1: rule__IntegerLiteralRule__FactorAssignment_1 : ( ruleFactorRule ) ;
    public final void rule__IntegerLiteralRule__FactorAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7831:1: ( ( ruleFactorRule ) )
            // InternalOptimisationLanguage.g:7832:2: ( ruleFactorRule )
            {
            // InternalOptimisationLanguage.g:7832:2: ( ruleFactorRule )
            // InternalOptimisationLanguage.g:7833:3: ruleFactorRule
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


    // $ANTLR start "rule__StringLiteralRule__LiteralAssignment"
    // InternalOptimisationLanguage.g:7842:1: rule__StringLiteralRule__LiteralAssignment : ( RULE_STRING ) ;
    public final void rule__StringLiteralRule__LiteralAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7846:1: ( ( RULE_STRING ) )
            // InternalOptimisationLanguage.g:7847:2: ( RULE_STRING )
            {
            // InternalOptimisationLanguage.g:7847:2: ( RULE_STRING )
            // InternalOptimisationLanguage.g:7848:3: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringLiteralRuleAccess().getLiteralSTRINGTerminalRuleCall_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getStringLiteralRuleAccess().getLiteralSTRINGTerminalRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StringLiteralRule__LiteralAssignment"


    // $ANTLR start "rule__BooleanLiteralRule__LiteralAssignment_1_0"
    // InternalOptimisationLanguage.g:7857:1: rule__BooleanLiteralRule__LiteralAssignment_1_0 : ( ( 'true' ) ) ;
    public final void rule__BooleanLiteralRule__LiteralAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7861:1: ( ( ( 'true' ) ) )
            // InternalOptimisationLanguage.g:7862:2: ( ( 'true' ) )
            {
            // InternalOptimisationLanguage.g:7862:2: ( ( 'true' ) )
            // InternalOptimisationLanguage.g:7863:3: ( 'true' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralRuleAccess().getLiteralTrueKeyword_1_0_0()); 
            }
            // InternalOptimisationLanguage.g:7864:3: ( 'true' )
            // InternalOptimisationLanguage.g:7865:4: 'true'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralRuleAccess().getLiteralTrueKeyword_1_0_0()); 
            }
            match(input,94,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBooleanLiteralRuleAccess().getLiteralTrueKeyword_1_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBooleanLiteralRuleAccess().getLiteralTrueKeyword_1_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanLiteralRule__LiteralAssignment_1_0"


    // $ANTLR start "rule__AttributeDefinitionRule__ConstraintsAssignment_0"
    // InternalOptimisationLanguage.g:7876:1: rule__AttributeDefinitionRule__ConstraintsAssignment_0 : ( ruleConstraintRule ) ;
    public final void rule__AttributeDefinitionRule__ConstraintsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7880:1: ( ( ruleConstraintRule ) )
            // InternalOptimisationLanguage.g:7881:2: ( ruleConstraintRule )
            {
            // InternalOptimisationLanguage.g:7881:2: ( ruleConstraintRule )
            // InternalOptimisationLanguage.g:7882:3: ruleConstraintRule
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
    // InternalOptimisationLanguage.g:7891:1: rule__AttributeDefinitionRule__NameAssignment_1 : ( ruleStringOrId ) ;
    public final void rule__AttributeDefinitionRule__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7895:1: ( ( ruleStringOrId ) )
            // InternalOptimisationLanguage.g:7896:2: ( ruleStringOrId )
            {
            // InternalOptimisationLanguage.g:7896:2: ( ruleStringOrId )
            // InternalOptimisationLanguage.g:7897:3: ruleStringOrId
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


    // $ANTLR start "rule__AttributeDefinitionRule__OptionalAssignment_3"
    // InternalOptimisationLanguage.g:7906:1: rule__AttributeDefinitionRule__OptionalAssignment_3 : ( ( 'optional' ) ) ;
    public final void rule__AttributeDefinitionRule__OptionalAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7910:1: ( ( ( 'optional' ) ) )
            // InternalOptimisationLanguage.g:7911:2: ( ( 'optional' ) )
            {
            // InternalOptimisationLanguage.g:7911:2: ( ( 'optional' ) )
            // InternalOptimisationLanguage.g:7912:3: ( 'optional' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getOptionalOptionalKeyword_3_0()); 
            }
            // InternalOptimisationLanguage.g:7913:3: ( 'optional' )
            // InternalOptimisationLanguage.g:7914:4: 'optional'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getOptionalOptionalKeyword_3_0()); 
            }
            match(input,95,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeDefinitionRuleAccess().getOptionalOptionalKeyword_3_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeDefinitionRuleAccess().getOptionalOptionalKeyword_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeDefinitionRule__OptionalAssignment_3"


    // $ANTLR start "rule__AttributeDefinitionRule__TypeAssignment_4"
    // InternalOptimisationLanguage.g:7925:1: rule__AttributeDefinitionRule__TypeAssignment_4 : ( ruleTypeRule ) ;
    public final void rule__AttributeDefinitionRule__TypeAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7929:1: ( ( ruleTypeRule ) )
            // InternalOptimisationLanguage.g:7930:2: ( ruleTypeRule )
            {
            // InternalOptimisationLanguage.g:7930:2: ( ruleTypeRule )
            // InternalOptimisationLanguage.g:7931:3: ruleTypeRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getTypeTypeRuleParserRuleCall_4_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleTypeRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeDefinitionRuleAccess().getTypeTypeRuleParserRuleCall_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeDefinitionRule__TypeAssignment_4"


    // $ANTLR start "rule__AttributeDefinitionRule__InitialisationAssignment_5_1"
    // InternalOptimisationLanguage.g:7940:1: rule__AttributeDefinitionRule__InitialisationAssignment_5_1 : ( ruleExpressionRule ) ;
    public final void rule__AttributeDefinitionRule__InitialisationAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7944:1: ( ( ruleExpressionRule ) )
            // InternalOptimisationLanguage.g:7945:2: ( ruleExpressionRule )
            {
            // InternalOptimisationLanguage.g:7945:2: ( ruleExpressionRule )
            // InternalOptimisationLanguage.g:7946:3: ruleExpressionRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getInitialisationExpressionRuleParserRuleCall_5_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleExpressionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeDefinitionRuleAccess().getInitialisationExpressionRuleParserRuleCall_5_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeDefinitionRule__InitialisationAssignment_5_1"


    // $ANTLR start "rule__EnumReferenceRule__DefinitionAssignment_1"
    // InternalOptimisationLanguage.g:7955:1: rule__EnumReferenceRule__DefinitionAssignment_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__EnumReferenceRule__DefinitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7959:1: ( ( ( ruleQualifiedName ) ) )
            // InternalOptimisationLanguage.g:7960:2: ( ( ruleQualifiedName ) )
            {
            // InternalOptimisationLanguage.g:7960:2: ( ( ruleQualifiedName ) )
            // InternalOptimisationLanguage.g:7961:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumReferenceRuleAccess().getDefinitionEnumDefinitionCrossReference_1_0()); 
            }
            // InternalOptimisationLanguage.g:7962:3: ( ruleQualifiedName )
            // InternalOptimisationLanguage.g:7963:4: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumReferenceRuleAccess().getDefinitionEnumDefinitionQualifiedNameParserRuleCall_1_0_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumReferenceRuleAccess().getDefinitionEnumDefinitionQualifiedNameParserRuleCall_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumReferenceRuleAccess().getDefinitionEnumDefinitionCrossReference_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumReferenceRule__DefinitionAssignment_1"


    // $ANTLR start "rule__TypeReferenceRule__DefinitionAssignment_1"
    // InternalOptimisationLanguage.g:7974:1: rule__TypeReferenceRule__DefinitionAssignment_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__TypeReferenceRule__DefinitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7978:1: ( ( ( ruleQualifiedName ) ) )
            // InternalOptimisationLanguage.g:7979:2: ( ( ruleQualifiedName ) )
            {
            // InternalOptimisationLanguage.g:7979:2: ( ( ruleQualifiedName ) )
            // InternalOptimisationLanguage.g:7980:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeReferenceRuleAccess().getDefinitionClassDefinitionCrossReference_1_0()); 
            }
            // InternalOptimisationLanguage.g:7981:3: ( ruleQualifiedName )
            // InternalOptimisationLanguage.g:7982:4: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeReferenceRuleAccess().getDefinitionClassDefinitionQualifiedNameParserRuleCall_1_0_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeReferenceRuleAccess().getDefinitionClassDefinitionQualifiedNameParserRuleCall_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeReferenceRuleAccess().getDefinitionClassDefinitionCrossReference_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeReferenceRule__DefinitionAssignment_1"


    // $ANTLR start "rule__ArrayTypeRule__ElementsAssignment_1"
    // InternalOptimisationLanguage.g:7993:1: rule__ArrayTypeRule__ElementsAssignment_1 : ( ruleTypeRule ) ;
    public final void rule__ArrayTypeRule__ElementsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7997:1: ( ( ruleTypeRule ) )
            // InternalOptimisationLanguage.g:7998:2: ( ruleTypeRule )
            {
            // InternalOptimisationLanguage.g:7998:2: ( ruleTypeRule )
            // InternalOptimisationLanguage.g:7999:3: ruleTypeRule
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
    // InternalOptimisationLanguage.g:8008:1: rule__ParameterRule__TypeAssignment_0 : ( ruleTypeRule ) ;
    public final void rule__ParameterRule__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:8012:1: ( ( ruleTypeRule ) )
            // InternalOptimisationLanguage.g:8013:2: ( ruleTypeRule )
            {
            // InternalOptimisationLanguage.g:8013:2: ( ruleTypeRule )
            // InternalOptimisationLanguage.g:8014:3: ruleTypeRule
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
    // InternalOptimisationLanguage.g:8023:1: rule__ParameterRule__NameAssignment_1 : ( ruleStringOrId ) ;
    public final void rule__ParameterRule__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:8027:1: ( ( ruleStringOrId ) )
            // InternalOptimisationLanguage.g:8028:2: ( ruleStringOrId )
            {
            // InternalOptimisationLanguage.g:8028:2: ( ruleStringOrId )
            // InternalOptimisationLanguage.g:8029:3: ruleStringOrId
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
    // InternalOptimisationLanguage.g:8038:1: rule__ImportRule__LanguageAssignment_1 : ( RULE_STRING ) ;
    public final void rule__ImportRule__LanguageAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:8042:1: ( ( RULE_STRING ) )
            // InternalOptimisationLanguage.g:8043:2: ( RULE_STRING )
            {
            // InternalOptimisationLanguage.g:8043:2: ( RULE_STRING )
            // InternalOptimisationLanguage.g:8044:3: RULE_STRING
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
    // InternalOptimisationLanguage.g:8053:1: rule__ImportRule__ImportedNamespaceAssignment_3 : ( ruleQualifiedName ) ;
    public final void rule__ImportRule__ImportedNamespaceAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:8057:1: ( ( ruleQualifiedName ) )
            // InternalOptimisationLanguage.g:8058:2: ( ruleQualifiedName )
            {
            // InternalOptimisationLanguage.g:8058:2: ( ruleQualifiedName )
            // InternalOptimisationLanguage.g:8059:3: ruleQualifiedName
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

    // $ANTLR start synpred84_InternalOptimisationLanguage
    public final void synpred84_InternalOptimisationLanguage_fragment() throws RecognitionException {   
        // InternalOptimisationLanguage.g:6775:3: ( rule__QualifiedName__Group_1__0 )
        // InternalOptimisationLanguage.g:6775:3: rule__QualifiedName__Group_1__0
        {
        pushFollow(FOLLOW_2);
        rule__QualifiedName__Group_1__0();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred84_InternalOptimisationLanguage

    // Delegated rules

    public final boolean synpred84_InternalOptimisationLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred84_InternalOptimisationLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA3 dfa3 = new DFA3(this);
    static final String dfa_1s = "\13\uffff";
    static final String dfa_2s = "\2\uffff\2\6\5\uffff\2\6";
    static final String dfa_3s = "\1\4\1\uffff\2\20\3\uffff\1\4\1\uffff\2\20";
    static final String dfa_4s = "\1\136\1\uffff\2\111\3\uffff\1\5\1\uffff\2\111";
    static final String dfa_5s = "\1\uffff\1\1\2\uffff\1\3\1\4\1\5\1\uffff\1\2\2\uffff";
    static final String dfa_6s = "\13\uffff}>";
    static final String[] dfa_7s = {
            "\1\2\1\3\3\4\6\uffff\1\4\66\uffff\1\1\1\uffff\1\5\1\uffff\5\6\17\uffff\1\4",
            "",
            "\13\6\25\uffff\1\4\7\uffff\1\6\1\uffff\1\7\6\uffff\5\6\1\uffff\1\6\1\10\1\6",
            "\13\6\25\uffff\1\4\7\uffff\1\6\1\uffff\1\7\6\uffff\5\6\1\uffff\1\6\1\10\1\6",
            "",
            "",
            "",
            "\1\11\1\12",
            "",
            "\13\6\25\uffff\1\4\7\uffff\1\6\1\uffff\1\7\6\uffff\5\6\1\uffff\1\6\1\10\1\6",
            "\13\6\25\uffff\1\4\7\uffff\1\6\1\uffff\1\7\6\uffff\5\6\1\uffff\1\6\1\10\1\6"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "1591:1: rule__ReadExpressionRule__Alternatives : ( ( ruleArrayRule ) | ( ruleCallRule ) | ( ruleLiteralRule ) | ( ruleParanthesesRule ) | ( ruleReferenceRule ) );";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000002L,0x0000000004000000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x8006000000000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000000L,0x0000000000006000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0120000000000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0100000000000002L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x3800000000000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0302000000000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x00000000000081F0L,0x0000000050000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0202000000000030L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000C081F0L,0x0000000070007D40L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000008L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x00000000003F0000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x00000000003F0002L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000007000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000007000002L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000C081F0L,0x0000000070007DC0L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000C081F0L,0x0000000070007F40L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0002000000000030L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x00007FFFF8000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000008000L,0x0000000040000000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000000L,0x0000000083FE6000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000000000L,0x0000000001E80000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});

}
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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_QUOTED_ID", "RULE_ID", "RULE_DOUBLE", "RULE_INT", "RULE_STRING", "RULE_DIGIT", "RULE_EXPONENT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'false'", "'>='", "'>'", "'='", "'!='", "'<'", "'<='", "'+'", "'-'", "'*'", "'/'", "'%'", "'Y'", "'Z'", "'E'", "'P'", "'T'", "'G'", "'M'", "'k'", "'h'", "'da'", "'d'", "'c'", "'m'", "'\\u00B5'", "'n'", "'p'", "'f'", "'a'", "'z'", "'y'", "'module'", "'{'", "'}'", "'specify'", "'search'", "'for'", "'map'", "'with'", "'and'", "','", "'document'", "'.'", "'maximise'", "'minimise'", "'optimise'", "'towards'", "'configure'", "':='", "';'", "'OR'", "'XOR'", "'AND'", "'^'", "'['", "']'", "'('", "')'", "'self'", "'value'", "'tree'", "'data'", "'instance'", "'@'", "':'", "'enum'", "'literal'", "'string'", "'expression'", "'int'", "'real'", "'boolean'", "'void'", "'array'", "'import'", "'from'", "'!'", "'true'", "'optional'"
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


    // $ANTLR start "rule__ReadExpressionRule__Alternatives"
    // InternalOptimisationLanguage.g:1570:1: rule__ReadExpressionRule__Alternatives : ( ( ruleArrayRule ) | ( ruleCallRule ) | ( ruleLiteralRule ) | ( ruleParanthesesRule ) | ( ruleReferenceRule ) );
    public final void rule__ReadExpressionRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1574:1: ( ( ruleArrayRule ) | ( ruleCallRule ) | ( ruleLiteralRule ) | ( ruleParanthesesRule ) | ( ruleReferenceRule ) )
            int alt2=5;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // InternalOptimisationLanguage.g:1575:2: ( ruleArrayRule )
                    {
                    // InternalOptimisationLanguage.g:1575:2: ( ruleArrayRule )
                    // InternalOptimisationLanguage.g:1576:3: ruleArrayRule
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
                    // InternalOptimisationLanguage.g:1581:2: ( ruleCallRule )
                    {
                    // InternalOptimisationLanguage.g:1581:2: ( ruleCallRule )
                    // InternalOptimisationLanguage.g:1582:3: ruleCallRule
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
                    // InternalOptimisationLanguage.g:1587:2: ( ruleLiteralRule )
                    {
                    // InternalOptimisationLanguage.g:1587:2: ( ruleLiteralRule )
                    // InternalOptimisationLanguage.g:1588:3: ruleLiteralRule
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
                    // InternalOptimisationLanguage.g:1593:2: ( ruleParanthesesRule )
                    {
                    // InternalOptimisationLanguage.g:1593:2: ( ruleParanthesesRule )
                    // InternalOptimisationLanguage.g:1594:3: ruleParanthesesRule
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
                    // InternalOptimisationLanguage.g:1599:2: ( ruleReferenceRule )
                    {
                    // InternalOptimisationLanguage.g:1599:2: ( ruleReferenceRule )
                    // InternalOptimisationLanguage.g:1600:3: ruleReferenceRule
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
    // InternalOptimisationLanguage.g:1609:1: rule__ReferenceRule__Alternatives : ( ( ruleValuelDefinitionReferenceRule ) | ( ruleConfigurationReferenceRule ) | ( ruleTypeDefinitionReferenceRule ) | ( ruleAttributeReferenceRule ) );
    public final void rule__ReferenceRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1613:1: ( ( ruleValuelDefinitionReferenceRule ) | ( ruleConfigurationReferenceRule ) | ( ruleTypeDefinitionReferenceRule ) | ( ruleAttributeReferenceRule ) )
            int alt3=4;
            switch ( input.LA(1) ) {
            case RULE_QUOTED_ID:
            case RULE_ID:
                {
                alt3=1;
                }
                break;
            case 76:
                {
                alt3=2;
                }
                break;
            case 77:
            case 78:
                {
                alt3=3;
                }
                break;
            case 74:
            case 75:
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
                    // InternalOptimisationLanguage.g:1614:2: ( ruleValuelDefinitionReferenceRule )
                    {
                    // InternalOptimisationLanguage.g:1614:2: ( ruleValuelDefinitionReferenceRule )
                    // InternalOptimisationLanguage.g:1615:3: ruleValuelDefinitionReferenceRule
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
                    // InternalOptimisationLanguage.g:1620:2: ( ruleConfigurationReferenceRule )
                    {
                    // InternalOptimisationLanguage.g:1620:2: ( ruleConfigurationReferenceRule )
                    // InternalOptimisationLanguage.g:1621:3: ruleConfigurationReferenceRule
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
                    // InternalOptimisationLanguage.g:1626:2: ( ruleTypeDefinitionReferenceRule )
                    {
                    // InternalOptimisationLanguage.g:1626:2: ( ruleTypeDefinitionReferenceRule )
                    // InternalOptimisationLanguage.g:1627:3: ruleTypeDefinitionReferenceRule
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
                    // InternalOptimisationLanguage.g:1632:2: ( ruleAttributeReferenceRule )
                    {
                    // InternalOptimisationLanguage.g:1632:2: ( ruleAttributeReferenceRule )
                    // InternalOptimisationLanguage.g:1633:3: ruleAttributeReferenceRule
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
    // InternalOptimisationLanguage.g:1642:1: rule__SelfReferenceRule__Alternatives : ( ( ( rule__SelfReferenceRule__Group_0__0 ) ) | ( ( rule__SelfReferenceRule__Group_1__0 ) ) );
    public final void rule__SelfReferenceRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1646:1: ( ( ( rule__SelfReferenceRule__Group_0__0 ) ) | ( ( rule__SelfReferenceRule__Group_1__0 ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==74) ) {
                alt4=1;
            }
            else if ( (LA4_0==75) ) {
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
                    // InternalOptimisationLanguage.g:1647:2: ( ( rule__SelfReferenceRule__Group_0__0 ) )
                    {
                    // InternalOptimisationLanguage.g:1647:2: ( ( rule__SelfReferenceRule__Group_0__0 ) )
                    // InternalOptimisationLanguage.g:1648:3: ( rule__SelfReferenceRule__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSelfReferenceRuleAccess().getGroup_0()); 
                    }
                    // InternalOptimisationLanguage.g:1649:3: ( rule__SelfReferenceRule__Group_0__0 )
                    // InternalOptimisationLanguage.g:1649:4: rule__SelfReferenceRule__Group_0__0
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
                    // InternalOptimisationLanguage.g:1653:2: ( ( rule__SelfReferenceRule__Group_1__0 ) )
                    {
                    // InternalOptimisationLanguage.g:1653:2: ( ( rule__SelfReferenceRule__Group_1__0 ) )
                    // InternalOptimisationLanguage.g:1654:3: ( rule__SelfReferenceRule__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSelfReferenceRuleAccess().getGroup_1()); 
                    }
                    // InternalOptimisationLanguage.g:1655:3: ( rule__SelfReferenceRule__Group_1__0 )
                    // InternalOptimisationLanguage.g:1655:4: rule__SelfReferenceRule__Group_1__0
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
    // InternalOptimisationLanguage.g:1663:1: rule__TypeDefinitionReferenceRule__Alternatives : ( ( ruleBaseDataReferenceRule ) | ( ruleStructuredDataDescriptionReferenceRule ) );
    public final void rule__TypeDefinitionReferenceRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1667:1: ( ( ruleBaseDataReferenceRule ) | ( ruleStructuredDataDescriptionReferenceRule ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==77) ) {
                alt5=1;
            }
            else if ( (LA5_0==78) ) {
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
                    // InternalOptimisationLanguage.g:1668:2: ( ruleBaseDataReferenceRule )
                    {
                    // InternalOptimisationLanguage.g:1668:2: ( ruleBaseDataReferenceRule )
                    // InternalOptimisationLanguage.g:1669:3: ruleBaseDataReferenceRule
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
                    // InternalOptimisationLanguage.g:1674:2: ( ruleStructuredDataDescriptionReferenceRule )
                    {
                    // InternalOptimisationLanguage.g:1674:2: ( ruleStructuredDataDescriptionReferenceRule )
                    // InternalOptimisationLanguage.g:1675:3: ruleStructuredDataDescriptionReferenceRule
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
    // InternalOptimisationLanguage.g:1684:1: rule__LiteralRule__Alternatives : ( ( ruleNumberLiteralRule ) | ( ruleStringLiteralRule ) | ( ruleBooleanLiteralRule ) | ( ruleInstanceLiteralRule ) );
    public final void rule__LiteralRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1688:1: ( ( ruleNumberLiteralRule ) | ( ruleStringLiteralRule ) | ( ruleBooleanLiteralRule ) | ( ruleInstanceLiteralRule ) )
            int alt6=4;
            switch ( input.LA(1) ) {
            case RULE_DOUBLE:
            case RULE_INT:
                {
                alt6=1;
                }
                break;
            case RULE_STRING:
                {
                alt6=2;
                }
                break;
            case 15:
            case 93:
                {
                alt6=3;
                }
                break;
            case RULE_QUOTED_ID:
            case RULE_ID:
                {
                alt6=4;
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
                    // InternalOptimisationLanguage.g:1689:2: ( ruleNumberLiteralRule )
                    {
                    // InternalOptimisationLanguage.g:1689:2: ( ruleNumberLiteralRule )
                    // InternalOptimisationLanguage.g:1690:3: ruleNumberLiteralRule
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
                    // InternalOptimisationLanguage.g:1695:2: ( ruleStringLiteralRule )
                    {
                    // InternalOptimisationLanguage.g:1695:2: ( ruleStringLiteralRule )
                    // InternalOptimisationLanguage.g:1696:3: ruleStringLiteralRule
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
                    // InternalOptimisationLanguage.g:1701:2: ( ruleBooleanLiteralRule )
                    {
                    // InternalOptimisationLanguage.g:1701:2: ( ruleBooleanLiteralRule )
                    // InternalOptimisationLanguage.g:1702:3: ruleBooleanLiteralRule
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
                    // InternalOptimisationLanguage.g:1707:2: ( ruleInstanceLiteralRule )
                    {
                    // InternalOptimisationLanguage.g:1707:2: ( ruleInstanceLiteralRule )
                    // InternalOptimisationLanguage.g:1708:3: ruleInstanceLiteralRule
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
    // InternalOptimisationLanguage.g:1717:1: rule__NumberLiteralRule__Alternatives : ( ( ruleRealLiteralRule ) | ( ruleIntegerLiteralRule ) );
    public final void rule__NumberLiteralRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1721:1: ( ( ruleRealLiteralRule ) | ( ruleIntegerLiteralRule ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_DOUBLE) ) {
                alt7=1;
            }
            else if ( (LA7_0==RULE_INT) ) {
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
                    // InternalOptimisationLanguage.g:1722:2: ( ruleRealLiteralRule )
                    {
                    // InternalOptimisationLanguage.g:1722:2: ( ruleRealLiteralRule )
                    // InternalOptimisationLanguage.g:1723:3: ruleRealLiteralRule
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
                    // InternalOptimisationLanguage.g:1728:2: ( ruleIntegerLiteralRule )
                    {
                    // InternalOptimisationLanguage.g:1728:2: ( ruleIntegerLiteralRule )
                    // InternalOptimisationLanguage.g:1729:3: ruleIntegerLiteralRule
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
    // InternalOptimisationLanguage.g:1738:1: rule__BooleanLiteralRule__Alternatives_1 : ( ( ( rule__BooleanLiteralRule__LiteralAssignment_1_0 ) ) | ( 'false' ) );
    public final void rule__BooleanLiteralRule__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1742:1: ( ( ( rule__BooleanLiteralRule__LiteralAssignment_1_0 ) ) | ( 'false' ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==93) ) {
                alt8=1;
            }
            else if ( (LA8_0==15) ) {
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
                    // InternalOptimisationLanguage.g:1743:2: ( ( rule__BooleanLiteralRule__LiteralAssignment_1_0 ) )
                    {
                    // InternalOptimisationLanguage.g:1743:2: ( ( rule__BooleanLiteralRule__LiteralAssignment_1_0 ) )
                    // InternalOptimisationLanguage.g:1744:3: ( rule__BooleanLiteralRule__LiteralAssignment_1_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBooleanLiteralRuleAccess().getLiteralAssignment_1_0()); 
                    }
                    // InternalOptimisationLanguage.g:1745:3: ( rule__BooleanLiteralRule__LiteralAssignment_1_0 )
                    // InternalOptimisationLanguage.g:1745:4: rule__BooleanLiteralRule__LiteralAssignment_1_0
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
                    // InternalOptimisationLanguage.g:1749:2: ( 'false' )
                    {
                    // InternalOptimisationLanguage.g:1749:2: ( 'false' )
                    // InternalOptimisationLanguage.g:1750:3: 'false'
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
    // InternalOptimisationLanguage.g:1759:1: rule__TypeRule__Alternatives : ( ( ruleArrayTypeRule ) | ( ruleBaseTypeRule ) | ( ruleTypeReferenceRule ) | ( ruleEnumReferenceRule ) | ( ruleExpressionTypeRule ) | ( ruleLiteralTypeRule ) | ( ruleDataTypeRule ) );
    public final void rule__TypeRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1763:1: ( ( ruleArrayTypeRule ) | ( ruleBaseTypeRule ) | ( ruleTypeReferenceRule ) | ( ruleEnumReferenceRule ) | ( ruleExpressionTypeRule ) | ( ruleLiteralTypeRule ) | ( ruleDataTypeRule ) )
            int alt9=7;
            switch ( input.LA(1) ) {
            case 89:
                {
                alt9=1;
                }
                break;
            case 83:
            case 85:
            case 86:
            case 87:
            case 88:
                {
                alt9=2;
                }
                break;
            case 78:
                {
                alt9=3;
                }
                break;
            case 81:
                {
                alt9=4;
                }
                break;
            case 84:
                {
                alt9=5;
                }
                break;
            case 82:
                {
                alt9=6;
                }
                break;
            case 77:
                {
                alt9=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // InternalOptimisationLanguage.g:1764:2: ( ruleArrayTypeRule )
                    {
                    // InternalOptimisationLanguage.g:1764:2: ( ruleArrayTypeRule )
                    // InternalOptimisationLanguage.g:1765:3: ruleArrayTypeRule
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
                    // InternalOptimisationLanguage.g:1770:2: ( ruleBaseTypeRule )
                    {
                    // InternalOptimisationLanguage.g:1770:2: ( ruleBaseTypeRule )
                    // InternalOptimisationLanguage.g:1771:3: ruleBaseTypeRule
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
                    // InternalOptimisationLanguage.g:1776:2: ( ruleTypeReferenceRule )
                    {
                    // InternalOptimisationLanguage.g:1776:2: ( ruleTypeReferenceRule )
                    // InternalOptimisationLanguage.g:1777:3: ruleTypeReferenceRule
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
                    // InternalOptimisationLanguage.g:1782:2: ( ruleEnumReferenceRule )
                    {
                    // InternalOptimisationLanguage.g:1782:2: ( ruleEnumReferenceRule )
                    // InternalOptimisationLanguage.g:1783:3: ruleEnumReferenceRule
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
                    // InternalOptimisationLanguage.g:1788:2: ( ruleExpressionTypeRule )
                    {
                    // InternalOptimisationLanguage.g:1788:2: ( ruleExpressionTypeRule )
                    // InternalOptimisationLanguage.g:1789:3: ruleExpressionTypeRule
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
                    // InternalOptimisationLanguage.g:1794:2: ( ruleLiteralTypeRule )
                    {
                    // InternalOptimisationLanguage.g:1794:2: ( ruleLiteralTypeRule )
                    // InternalOptimisationLanguage.g:1795:3: ruleLiteralTypeRule
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
                    // InternalOptimisationLanguage.g:1800:2: ( ruleDataTypeRule )
                    {
                    // InternalOptimisationLanguage.g:1800:2: ( ruleDataTypeRule )
                    // InternalOptimisationLanguage.g:1801:3: ruleDataTypeRule
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
    // InternalOptimisationLanguage.g:1810:1: rule__BaseTypeRule__Alternatives : ( ( ruleStringTypeRule ) | ( ruleIntTypeRule ) | ( ruleRealTypeRule ) | ( ruleBooleanTypeRule ) | ( ruleVoidTypeRule ) );
    public final void rule__BaseTypeRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1814:1: ( ( ruleStringTypeRule ) | ( ruleIntTypeRule ) | ( ruleRealTypeRule ) | ( ruleBooleanTypeRule ) | ( ruleVoidTypeRule ) )
            int alt10=5;
            switch ( input.LA(1) ) {
            case 83:
                {
                alt10=1;
                }
                break;
            case 85:
                {
                alt10=2;
                }
                break;
            case 86:
                {
                alt10=3;
                }
                break;
            case 87:
                {
                alt10=4;
                }
                break;
            case 88:
                {
                alt10=5;
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
                    // InternalOptimisationLanguage.g:1815:2: ( ruleStringTypeRule )
                    {
                    // InternalOptimisationLanguage.g:1815:2: ( ruleStringTypeRule )
                    // InternalOptimisationLanguage.g:1816:3: ruleStringTypeRule
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
                    // InternalOptimisationLanguage.g:1821:2: ( ruleIntTypeRule )
                    {
                    // InternalOptimisationLanguage.g:1821:2: ( ruleIntTypeRule )
                    // InternalOptimisationLanguage.g:1822:3: ruleIntTypeRule
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
                    // InternalOptimisationLanguage.g:1827:2: ( ruleRealTypeRule )
                    {
                    // InternalOptimisationLanguage.g:1827:2: ( ruleRealTypeRule )
                    // InternalOptimisationLanguage.g:1828:3: ruleRealTypeRule
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
                    // InternalOptimisationLanguage.g:1833:2: ( ruleBooleanTypeRule )
                    {
                    // InternalOptimisationLanguage.g:1833:2: ( ruleBooleanTypeRule )
                    // InternalOptimisationLanguage.g:1834:3: ruleBooleanTypeRule
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
                    // InternalOptimisationLanguage.g:1839:2: ( ruleVoidTypeRule )
                    {
                    // InternalOptimisationLanguage.g:1839:2: ( ruleVoidTypeRule )
                    // InternalOptimisationLanguage.g:1840:3: ruleVoidTypeRule
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
    // InternalOptimisationLanguage.g:1849:1: rule__StringOrId__Alternatives : ( ( RULE_QUOTED_ID ) | ( RULE_ID ) );
    public final void rule__StringOrId__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1853:1: ( ( RULE_QUOTED_ID ) | ( RULE_ID ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_QUOTED_ID) ) {
                alt11=1;
            }
            else if ( (LA11_0==RULE_ID) ) {
                alt11=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalOptimisationLanguage.g:1854:2: ( RULE_QUOTED_ID )
                    {
                    // InternalOptimisationLanguage.g:1854:2: ( RULE_QUOTED_ID )
                    // InternalOptimisationLanguage.g:1855:3: RULE_QUOTED_ID
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
                    // InternalOptimisationLanguage.g:1860:2: ( RULE_ID )
                    {
                    // InternalOptimisationLanguage.g:1860:2: ( RULE_ID )
                    // InternalOptimisationLanguage.g:1861:3: RULE_ID
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
    // InternalOptimisationLanguage.g:1870:1: rule__ComparisonOperatorRule__Alternatives : ( ( ( '>=' ) ) | ( ( '>' ) ) | ( ( '=' ) ) | ( ( '!=' ) ) | ( ( '<' ) ) | ( ( '<=' ) ) );
    public final void rule__ComparisonOperatorRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1874:1: ( ( ( '>=' ) ) | ( ( '>' ) ) | ( ( '=' ) ) | ( ( '!=' ) ) | ( ( '<' ) ) | ( ( '<=' ) ) )
            int alt12=6;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt12=1;
                }
                break;
            case 17:
                {
                alt12=2;
                }
                break;
            case 18:
                {
                alt12=3;
                }
                break;
            case 19:
                {
                alt12=4;
                }
                break;
            case 20:
                {
                alt12=5;
                }
                break;
            case 21:
                {
                alt12=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // InternalOptimisationLanguage.g:1875:2: ( ( '>=' ) )
                    {
                    // InternalOptimisationLanguage.g:1875:2: ( ( '>=' ) )
                    // InternalOptimisationLanguage.g:1876:3: ( '>=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getGreaterThanEnumLiteralDeclaration_0()); 
                    }
                    // InternalOptimisationLanguage.g:1877:3: ( '>=' )
                    // InternalOptimisationLanguage.g:1877:4: '>='
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
                    // InternalOptimisationLanguage.g:1881:2: ( ( '>' ) )
                    {
                    // InternalOptimisationLanguage.g:1881:2: ( ( '>' ) )
                    // InternalOptimisationLanguage.g:1882:3: ( '>' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getGreaterEqualEnumLiteralDeclaration_1()); 
                    }
                    // InternalOptimisationLanguage.g:1883:3: ( '>' )
                    // InternalOptimisationLanguage.g:1883:4: '>'
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
                    // InternalOptimisationLanguage.g:1887:2: ( ( '=' ) )
                    {
                    // InternalOptimisationLanguage.g:1887:2: ( ( '=' ) )
                    // InternalOptimisationLanguage.g:1888:3: ( '=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getEqualEnumLiteralDeclaration_2()); 
                    }
                    // InternalOptimisationLanguage.g:1889:3: ( '=' )
                    // InternalOptimisationLanguage.g:1889:4: '='
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
                    // InternalOptimisationLanguage.g:1893:2: ( ( '!=' ) )
                    {
                    // InternalOptimisationLanguage.g:1893:2: ( ( '!=' ) )
                    // InternalOptimisationLanguage.g:1894:3: ( '!=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getUnequalEnumLiteralDeclaration_3()); 
                    }
                    // InternalOptimisationLanguage.g:1895:3: ( '!=' )
                    // InternalOptimisationLanguage.g:1895:4: '!='
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
                    // InternalOptimisationLanguage.g:1899:2: ( ( '<' ) )
                    {
                    // InternalOptimisationLanguage.g:1899:2: ( ( '<' ) )
                    // InternalOptimisationLanguage.g:1900:3: ( '<' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getLessEqualEnumLiteralDeclaration_4()); 
                    }
                    // InternalOptimisationLanguage.g:1901:3: ( '<' )
                    // InternalOptimisationLanguage.g:1901:4: '<'
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
                    // InternalOptimisationLanguage.g:1905:2: ( ( '<=' ) )
                    {
                    // InternalOptimisationLanguage.g:1905:2: ( ( '<=' ) )
                    // InternalOptimisationLanguage.g:1906:3: ( '<=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getLessThanEnumLiteralDeclaration_5()); 
                    }
                    // InternalOptimisationLanguage.g:1907:3: ( '<=' )
                    // InternalOptimisationLanguage.g:1907:4: '<='
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
    // InternalOptimisationLanguage.g:1915:1: rule__AddOrSubtractOperatorRule__Alternatives : ( ( ( '+' ) ) | ( ( '-' ) ) );
    public final void rule__AddOrSubtractOperatorRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1919:1: ( ( ( '+' ) ) | ( ( '-' ) ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==22) ) {
                alt13=1;
            }
            else if ( (LA13_0==23) ) {
                alt13=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalOptimisationLanguage.g:1920:2: ( ( '+' ) )
                    {
                    // InternalOptimisationLanguage.g:1920:2: ( ( '+' ) )
                    // InternalOptimisationLanguage.g:1921:3: ( '+' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAddOrSubtractOperatorRuleAccess().getAddEnumLiteralDeclaration_0()); 
                    }
                    // InternalOptimisationLanguage.g:1922:3: ( '+' )
                    // InternalOptimisationLanguage.g:1922:4: '+'
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
                    // InternalOptimisationLanguage.g:1926:2: ( ( '-' ) )
                    {
                    // InternalOptimisationLanguage.g:1926:2: ( ( '-' ) )
                    // InternalOptimisationLanguage.g:1927:3: ( '-' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAddOrSubtractOperatorRuleAccess().getSubtractEnumLiteralDeclaration_1()); 
                    }
                    // InternalOptimisationLanguage.g:1928:3: ( '-' )
                    // InternalOptimisationLanguage.g:1928:4: '-'
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
    // InternalOptimisationLanguage.g:1936:1: rule__MultiplyDivideModuloOperatorRule__Alternatives : ( ( ( '*' ) ) | ( ( '/' ) ) | ( ( '%' ) ) );
    public final void rule__MultiplyDivideModuloOperatorRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1940:1: ( ( ( '*' ) ) | ( ( '/' ) ) | ( ( '%' ) ) )
            int alt14=3;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt14=1;
                }
                break;
            case 25:
                {
                alt14=2;
                }
                break;
            case 26:
                {
                alt14=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // InternalOptimisationLanguage.g:1941:2: ( ( '*' ) )
                    {
                    // InternalOptimisationLanguage.g:1941:2: ( ( '*' ) )
                    // InternalOptimisationLanguage.g:1942:3: ( '*' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getMultiplyEnumLiteralDeclaration_0()); 
                    }
                    // InternalOptimisationLanguage.g:1943:3: ( '*' )
                    // InternalOptimisationLanguage.g:1943:4: '*'
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
                    // InternalOptimisationLanguage.g:1947:2: ( ( '/' ) )
                    {
                    // InternalOptimisationLanguage.g:1947:2: ( ( '/' ) )
                    // InternalOptimisationLanguage.g:1948:3: ( '/' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getDivideEnumLiteralDeclaration_1()); 
                    }
                    // InternalOptimisationLanguage.g:1949:3: ( '/' )
                    // InternalOptimisationLanguage.g:1949:4: '/'
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
                    // InternalOptimisationLanguage.g:1953:2: ( ( '%' ) )
                    {
                    // InternalOptimisationLanguage.g:1953:2: ( ( '%' ) )
                    // InternalOptimisationLanguage.g:1954:3: ( '%' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getModuloEnumLiteralDeclaration_2()); 
                    }
                    // InternalOptimisationLanguage.g:1955:3: ( '%' )
                    // InternalOptimisationLanguage.g:1955:4: '%'
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
    // InternalOptimisationLanguage.g:1963:1: rule__FactorRule__Alternatives : ( ( ( 'Y' ) ) | ( ( 'Z' ) ) | ( ( 'E' ) ) | ( ( 'P' ) ) | ( ( 'T' ) ) | ( ( 'G' ) ) | ( ( 'M' ) ) | ( ( 'k' ) ) | ( ( 'h' ) ) | ( ( 'da' ) ) | ( ( 'd' ) ) | ( ( 'c' ) ) | ( ( 'm' ) ) | ( ( '\\u00B5' ) ) | ( ( 'n' ) ) | ( ( 'p' ) ) | ( ( 'f' ) ) | ( ( 'a' ) ) | ( ( 'z' ) ) | ( ( 'y' ) ) );
    public final void rule__FactorRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1967:1: ( ( ( 'Y' ) ) | ( ( 'Z' ) ) | ( ( 'E' ) ) | ( ( 'P' ) ) | ( ( 'T' ) ) | ( ( 'G' ) ) | ( ( 'M' ) ) | ( ( 'k' ) ) | ( ( 'h' ) ) | ( ( 'da' ) ) | ( ( 'd' ) ) | ( ( 'c' ) ) | ( ( 'm' ) ) | ( ( '\\u00B5' ) ) | ( ( 'n' ) ) | ( ( 'p' ) ) | ( ( 'f' ) ) | ( ( 'a' ) ) | ( ( 'z' ) ) | ( ( 'y' ) ) )
            int alt15=20;
            switch ( input.LA(1) ) {
            case 27:
                {
                alt15=1;
                }
                break;
            case 28:
                {
                alt15=2;
                }
                break;
            case 29:
                {
                alt15=3;
                }
                break;
            case 30:
                {
                alt15=4;
                }
                break;
            case 31:
                {
                alt15=5;
                }
                break;
            case 32:
                {
                alt15=6;
                }
                break;
            case 33:
                {
                alt15=7;
                }
                break;
            case 34:
                {
                alt15=8;
                }
                break;
            case 35:
                {
                alt15=9;
                }
                break;
            case 36:
                {
                alt15=10;
                }
                break;
            case 37:
                {
                alt15=11;
                }
                break;
            case 38:
                {
                alt15=12;
                }
                break;
            case 39:
                {
                alt15=13;
                }
                break;
            case 40:
                {
                alt15=14;
                }
                break;
            case 41:
                {
                alt15=15;
                }
                break;
            case 42:
                {
                alt15=16;
                }
                break;
            case 43:
                {
                alt15=17;
                }
                break;
            case 44:
                {
                alt15=18;
                }
                break;
            case 45:
                {
                alt15=19;
                }
                break;
            case 46:
                {
                alt15=20;
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
                    // InternalOptimisationLanguage.g:1968:2: ( ( 'Y' ) )
                    {
                    // InternalOptimisationLanguage.g:1968:2: ( ( 'Y' ) )
                    // InternalOptimisationLanguage.g:1969:3: ( 'Y' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getYottaEnumLiteralDeclaration_0()); 
                    }
                    // InternalOptimisationLanguage.g:1970:3: ( 'Y' )
                    // InternalOptimisationLanguage.g:1970:4: 'Y'
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
                    // InternalOptimisationLanguage.g:1974:2: ( ( 'Z' ) )
                    {
                    // InternalOptimisationLanguage.g:1974:2: ( ( 'Z' ) )
                    // InternalOptimisationLanguage.g:1975:3: ( 'Z' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getZettaEnumLiteralDeclaration_1()); 
                    }
                    // InternalOptimisationLanguage.g:1976:3: ( 'Z' )
                    // InternalOptimisationLanguage.g:1976:4: 'Z'
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
                    // InternalOptimisationLanguage.g:1980:2: ( ( 'E' ) )
                    {
                    // InternalOptimisationLanguage.g:1980:2: ( ( 'E' ) )
                    // InternalOptimisationLanguage.g:1981:3: ( 'E' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getExaEnumLiteralDeclaration_2()); 
                    }
                    // InternalOptimisationLanguage.g:1982:3: ( 'E' )
                    // InternalOptimisationLanguage.g:1982:4: 'E'
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
                    // InternalOptimisationLanguage.g:1986:2: ( ( 'P' ) )
                    {
                    // InternalOptimisationLanguage.g:1986:2: ( ( 'P' ) )
                    // InternalOptimisationLanguage.g:1987:3: ( 'P' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getPetaEnumLiteralDeclaration_3()); 
                    }
                    // InternalOptimisationLanguage.g:1988:3: ( 'P' )
                    // InternalOptimisationLanguage.g:1988:4: 'P'
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
                    // InternalOptimisationLanguage.g:1992:2: ( ( 'T' ) )
                    {
                    // InternalOptimisationLanguage.g:1992:2: ( ( 'T' ) )
                    // InternalOptimisationLanguage.g:1993:3: ( 'T' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getTeraEnumLiteralDeclaration_4()); 
                    }
                    // InternalOptimisationLanguage.g:1994:3: ( 'T' )
                    // InternalOptimisationLanguage.g:1994:4: 'T'
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
                    // InternalOptimisationLanguage.g:1998:2: ( ( 'G' ) )
                    {
                    // InternalOptimisationLanguage.g:1998:2: ( ( 'G' ) )
                    // InternalOptimisationLanguage.g:1999:3: ( 'G' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getGigaEnumLiteralDeclaration_5()); 
                    }
                    // InternalOptimisationLanguage.g:2000:3: ( 'G' )
                    // InternalOptimisationLanguage.g:2000:4: 'G'
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
                    // InternalOptimisationLanguage.g:2004:2: ( ( 'M' ) )
                    {
                    // InternalOptimisationLanguage.g:2004:2: ( ( 'M' ) )
                    // InternalOptimisationLanguage.g:2005:3: ( 'M' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getMegaEnumLiteralDeclaration_6()); 
                    }
                    // InternalOptimisationLanguage.g:2006:3: ( 'M' )
                    // InternalOptimisationLanguage.g:2006:4: 'M'
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
                    // InternalOptimisationLanguage.g:2010:2: ( ( 'k' ) )
                    {
                    // InternalOptimisationLanguage.g:2010:2: ( ( 'k' ) )
                    // InternalOptimisationLanguage.g:2011:3: ( 'k' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getKiloEnumLiteralDeclaration_7()); 
                    }
                    // InternalOptimisationLanguage.g:2012:3: ( 'k' )
                    // InternalOptimisationLanguage.g:2012:4: 'k'
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
                    // InternalOptimisationLanguage.g:2016:2: ( ( 'h' ) )
                    {
                    // InternalOptimisationLanguage.g:2016:2: ( ( 'h' ) )
                    // InternalOptimisationLanguage.g:2017:3: ( 'h' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getHectoEnumLiteralDeclaration_8()); 
                    }
                    // InternalOptimisationLanguage.g:2018:3: ( 'h' )
                    // InternalOptimisationLanguage.g:2018:4: 'h'
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
                    // InternalOptimisationLanguage.g:2022:2: ( ( 'da' ) )
                    {
                    // InternalOptimisationLanguage.g:2022:2: ( ( 'da' ) )
                    // InternalOptimisationLanguage.g:2023:3: ( 'da' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getDekaEnumLiteralDeclaration_9()); 
                    }
                    // InternalOptimisationLanguage.g:2024:3: ( 'da' )
                    // InternalOptimisationLanguage.g:2024:4: 'da'
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
                    // InternalOptimisationLanguage.g:2028:2: ( ( 'd' ) )
                    {
                    // InternalOptimisationLanguage.g:2028:2: ( ( 'd' ) )
                    // InternalOptimisationLanguage.g:2029:3: ( 'd' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getDeciEnumLiteralDeclaration_10()); 
                    }
                    // InternalOptimisationLanguage.g:2030:3: ( 'd' )
                    // InternalOptimisationLanguage.g:2030:4: 'd'
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
                    // InternalOptimisationLanguage.g:2034:2: ( ( 'c' ) )
                    {
                    // InternalOptimisationLanguage.g:2034:2: ( ( 'c' ) )
                    // InternalOptimisationLanguage.g:2035:3: ( 'c' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getCentiEnumLiteralDeclaration_11()); 
                    }
                    // InternalOptimisationLanguage.g:2036:3: ( 'c' )
                    // InternalOptimisationLanguage.g:2036:4: 'c'
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
                    // InternalOptimisationLanguage.g:2040:2: ( ( 'm' ) )
                    {
                    // InternalOptimisationLanguage.g:2040:2: ( ( 'm' ) )
                    // InternalOptimisationLanguage.g:2041:3: ( 'm' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getMilliEnumLiteralDeclaration_12()); 
                    }
                    // InternalOptimisationLanguage.g:2042:3: ( 'm' )
                    // InternalOptimisationLanguage.g:2042:4: 'm'
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
                    // InternalOptimisationLanguage.g:2046:2: ( ( '\\u00B5' ) )
                    {
                    // InternalOptimisationLanguage.g:2046:2: ( ( '\\u00B5' ) )
                    // InternalOptimisationLanguage.g:2047:3: ( '\\u00B5' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getMicroEnumLiteralDeclaration_13()); 
                    }
                    // InternalOptimisationLanguage.g:2048:3: ( '\\u00B5' )
                    // InternalOptimisationLanguage.g:2048:4: '\\u00B5'
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
                    // InternalOptimisationLanguage.g:2052:2: ( ( 'n' ) )
                    {
                    // InternalOptimisationLanguage.g:2052:2: ( ( 'n' ) )
                    // InternalOptimisationLanguage.g:2053:3: ( 'n' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getNanoEnumLiteralDeclaration_14()); 
                    }
                    // InternalOptimisationLanguage.g:2054:3: ( 'n' )
                    // InternalOptimisationLanguage.g:2054:4: 'n'
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
                    // InternalOptimisationLanguage.g:2058:2: ( ( 'p' ) )
                    {
                    // InternalOptimisationLanguage.g:2058:2: ( ( 'p' ) )
                    // InternalOptimisationLanguage.g:2059:3: ( 'p' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getPikoEnumLiteralDeclaration_15()); 
                    }
                    // InternalOptimisationLanguage.g:2060:3: ( 'p' )
                    // InternalOptimisationLanguage.g:2060:4: 'p'
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
                    // InternalOptimisationLanguage.g:2064:2: ( ( 'f' ) )
                    {
                    // InternalOptimisationLanguage.g:2064:2: ( ( 'f' ) )
                    // InternalOptimisationLanguage.g:2065:3: ( 'f' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getFemtoEnumLiteralDeclaration_16()); 
                    }
                    // InternalOptimisationLanguage.g:2066:3: ( 'f' )
                    // InternalOptimisationLanguage.g:2066:4: 'f'
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
                    // InternalOptimisationLanguage.g:2070:2: ( ( 'a' ) )
                    {
                    // InternalOptimisationLanguage.g:2070:2: ( ( 'a' ) )
                    // InternalOptimisationLanguage.g:2071:3: ( 'a' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getAttoEnumLiteralDeclaration_17()); 
                    }
                    // InternalOptimisationLanguage.g:2072:3: ( 'a' )
                    // InternalOptimisationLanguage.g:2072:4: 'a'
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
                    // InternalOptimisationLanguage.g:2076:2: ( ( 'z' ) )
                    {
                    // InternalOptimisationLanguage.g:2076:2: ( ( 'z' ) )
                    // InternalOptimisationLanguage.g:2077:3: ( 'z' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getZeptoEnumLiteralDeclaration_18()); 
                    }
                    // InternalOptimisationLanguage.g:2078:3: ( 'z' )
                    // InternalOptimisationLanguage.g:2078:4: 'z'
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
                    // InternalOptimisationLanguage.g:2082:2: ( ( 'y' ) )
                    {
                    // InternalOptimisationLanguage.g:2082:2: ( ( 'y' ) )
                    // InternalOptimisationLanguage.g:2083:3: ( 'y' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getYoctoEnumLiteralDeclaration_19()); 
                    }
                    // InternalOptimisationLanguage.g:2084:3: ( 'y' )
                    // InternalOptimisationLanguage.g:2084:4: 'y'
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
    // InternalOptimisationLanguage.g:2092:1: rule__OptimisationModelRule__Group__0 : rule__OptimisationModelRule__Group__0__Impl rule__OptimisationModelRule__Group__1 ;
    public final void rule__OptimisationModelRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2096:1: ( rule__OptimisationModelRule__Group__0__Impl rule__OptimisationModelRule__Group__1 )
            // InternalOptimisationLanguage.g:2097:2: rule__OptimisationModelRule__Group__0__Impl rule__OptimisationModelRule__Group__1
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
    // InternalOptimisationLanguage.g:2104:1: rule__OptimisationModelRule__Group__0__Impl : ( ( rule__OptimisationModelRule__ImportsAssignment_0 )* ) ;
    public final void rule__OptimisationModelRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2108:1: ( ( ( rule__OptimisationModelRule__ImportsAssignment_0 )* ) )
            // InternalOptimisationLanguage.g:2109:1: ( ( rule__OptimisationModelRule__ImportsAssignment_0 )* )
            {
            // InternalOptimisationLanguage.g:2109:1: ( ( rule__OptimisationModelRule__ImportsAssignment_0 )* )
            // InternalOptimisationLanguage.g:2110:2: ( rule__OptimisationModelRule__ImportsAssignment_0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOptimisationModelRuleAccess().getImportsAssignment_0()); 
            }
            // InternalOptimisationLanguage.g:2111:2: ( rule__OptimisationModelRule__ImportsAssignment_0 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==90) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:2111:3: rule__OptimisationModelRule__ImportsAssignment_0
            	    {
            	    pushFollow(FOLLOW_4);
            	    rule__OptimisationModelRule__ImportsAssignment_0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop16;
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
    // InternalOptimisationLanguage.g:2119:1: rule__OptimisationModelRule__Group__1 : rule__OptimisationModelRule__Group__1__Impl rule__OptimisationModelRule__Group__2 ;
    public final void rule__OptimisationModelRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2123:1: ( rule__OptimisationModelRule__Group__1__Impl rule__OptimisationModelRule__Group__2 )
            // InternalOptimisationLanguage.g:2124:2: rule__OptimisationModelRule__Group__1__Impl rule__OptimisationModelRule__Group__2
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
    // InternalOptimisationLanguage.g:2131:1: rule__OptimisationModelRule__Group__1__Impl : ( 'module' ) ;
    public final void rule__OptimisationModelRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2135:1: ( ( 'module' ) )
            // InternalOptimisationLanguage.g:2136:1: ( 'module' )
            {
            // InternalOptimisationLanguage.g:2136:1: ( 'module' )
            // InternalOptimisationLanguage.g:2137:2: 'module'
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
    // InternalOptimisationLanguage.g:2146:1: rule__OptimisationModelRule__Group__2 : rule__OptimisationModelRule__Group__2__Impl rule__OptimisationModelRule__Group__3 ;
    public final void rule__OptimisationModelRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2150:1: ( rule__OptimisationModelRule__Group__2__Impl rule__OptimisationModelRule__Group__3 )
            // InternalOptimisationLanguage.g:2151:2: rule__OptimisationModelRule__Group__2__Impl rule__OptimisationModelRule__Group__3
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
    // InternalOptimisationLanguage.g:2158:1: rule__OptimisationModelRule__Group__2__Impl : ( ( rule__OptimisationModelRule__NameAssignment_2 ) ) ;
    public final void rule__OptimisationModelRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2162:1: ( ( ( rule__OptimisationModelRule__NameAssignment_2 ) ) )
            // InternalOptimisationLanguage.g:2163:1: ( ( rule__OptimisationModelRule__NameAssignment_2 ) )
            {
            // InternalOptimisationLanguage.g:2163:1: ( ( rule__OptimisationModelRule__NameAssignment_2 ) )
            // InternalOptimisationLanguage.g:2164:2: ( rule__OptimisationModelRule__NameAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOptimisationModelRuleAccess().getNameAssignment_2()); 
            }
            // InternalOptimisationLanguage.g:2165:2: ( rule__OptimisationModelRule__NameAssignment_2 )
            // InternalOptimisationLanguage.g:2165:3: rule__OptimisationModelRule__NameAssignment_2
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
    // InternalOptimisationLanguage.g:2173:1: rule__OptimisationModelRule__Group__3 : rule__OptimisationModelRule__Group__3__Impl rule__OptimisationModelRule__Group__4 ;
    public final void rule__OptimisationModelRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2177:1: ( rule__OptimisationModelRule__Group__3__Impl rule__OptimisationModelRule__Group__4 )
            // InternalOptimisationLanguage.g:2178:2: rule__OptimisationModelRule__Group__3__Impl rule__OptimisationModelRule__Group__4
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
    // InternalOptimisationLanguage.g:2185:1: rule__OptimisationModelRule__Group__3__Impl : ( '{' ) ;
    public final void rule__OptimisationModelRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2189:1: ( ( '{' ) )
            // InternalOptimisationLanguage.g:2190:1: ( '{' )
            {
            // InternalOptimisationLanguage.g:2190:1: ( '{' )
            // InternalOptimisationLanguage.g:2191:2: '{'
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
    // InternalOptimisationLanguage.g:2200:1: rule__OptimisationModelRule__Group__4 : rule__OptimisationModelRule__Group__4__Impl rule__OptimisationModelRule__Group__5 ;
    public final void rule__OptimisationModelRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2204:1: ( rule__OptimisationModelRule__Group__4__Impl rule__OptimisationModelRule__Group__5 )
            // InternalOptimisationLanguage.g:2205:2: rule__OptimisationModelRule__Group__4__Impl rule__OptimisationModelRule__Group__5
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
    // InternalOptimisationLanguage.g:2212:1: rule__OptimisationModelRule__Group__4__Impl : ( ( rule__OptimisationModelRule__ProblemAssignment_4 )? ) ;
    public final void rule__OptimisationModelRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2216:1: ( ( ( rule__OptimisationModelRule__ProblemAssignment_4 )? ) )
            // InternalOptimisationLanguage.g:2217:1: ( ( rule__OptimisationModelRule__ProblemAssignment_4 )? )
            {
            // InternalOptimisationLanguage.g:2217:1: ( ( rule__OptimisationModelRule__ProblemAssignment_4 )? )
            // InternalOptimisationLanguage.g:2218:2: ( rule__OptimisationModelRule__ProblemAssignment_4 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOptimisationModelRuleAccess().getProblemAssignment_4()); 
            }
            // InternalOptimisationLanguage.g:2219:2: ( rule__OptimisationModelRule__ProblemAssignment_4 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==50) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalOptimisationLanguage.g:2219:3: rule__OptimisationModelRule__ProblemAssignment_4
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
    // InternalOptimisationLanguage.g:2227:1: rule__OptimisationModelRule__Group__5 : rule__OptimisationModelRule__Group__5__Impl rule__OptimisationModelRule__Group__6 ;
    public final void rule__OptimisationModelRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2231:1: ( rule__OptimisationModelRule__Group__5__Impl rule__OptimisationModelRule__Group__6 )
            // InternalOptimisationLanguage.g:2232:2: rule__OptimisationModelRule__Group__5__Impl rule__OptimisationModelRule__Group__6
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
    // InternalOptimisationLanguage.g:2239:1: rule__OptimisationModelRule__Group__5__Impl : ( ( rule__OptimisationModelRule__AlgorithmAssignment_5 )? ) ;
    public final void rule__OptimisationModelRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2243:1: ( ( ( rule__OptimisationModelRule__AlgorithmAssignment_5 )? ) )
            // InternalOptimisationLanguage.g:2244:1: ( ( rule__OptimisationModelRule__AlgorithmAssignment_5 )? )
            {
            // InternalOptimisationLanguage.g:2244:1: ( ( rule__OptimisationModelRule__AlgorithmAssignment_5 )? )
            // InternalOptimisationLanguage.g:2245:2: ( rule__OptimisationModelRule__AlgorithmAssignment_5 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOptimisationModelRuleAccess().getAlgorithmAssignment_5()); 
            }
            // InternalOptimisationLanguage.g:2246:2: ( rule__OptimisationModelRule__AlgorithmAssignment_5 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==63) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalOptimisationLanguage.g:2246:3: rule__OptimisationModelRule__AlgorithmAssignment_5
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
    // InternalOptimisationLanguage.g:2254:1: rule__OptimisationModelRule__Group__6 : rule__OptimisationModelRule__Group__6__Impl ;
    public final void rule__OptimisationModelRule__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2258:1: ( rule__OptimisationModelRule__Group__6__Impl )
            // InternalOptimisationLanguage.g:2259:2: rule__OptimisationModelRule__Group__6__Impl
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
    // InternalOptimisationLanguage.g:2265:1: rule__OptimisationModelRule__Group__6__Impl : ( '}' ) ;
    public final void rule__OptimisationModelRule__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2269:1: ( ( '}' ) )
            // InternalOptimisationLanguage.g:2270:1: ( '}' )
            {
            // InternalOptimisationLanguage.g:2270:1: ( '}' )
            // InternalOptimisationLanguage.g:2271:2: '}'
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
    // InternalOptimisationLanguage.g:2281:1: rule__ProblemRule__Group__0 : rule__ProblemRule__Group__0__Impl rule__ProblemRule__Group__1 ;
    public final void rule__ProblemRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2285:1: ( rule__ProblemRule__Group__0__Impl rule__ProblemRule__Group__1 )
            // InternalOptimisationLanguage.g:2286:2: rule__ProblemRule__Group__0__Impl rule__ProblemRule__Group__1
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
    // InternalOptimisationLanguage.g:2293:1: rule__ProblemRule__Group__0__Impl : ( 'specify' ) ;
    public final void rule__ProblemRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2297:1: ( ( 'specify' ) )
            // InternalOptimisationLanguage.g:2298:1: ( 'specify' )
            {
            // InternalOptimisationLanguage.g:2298:1: ( 'specify' )
            // InternalOptimisationLanguage.g:2299:2: 'specify'
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
    // InternalOptimisationLanguage.g:2308:1: rule__ProblemRule__Group__1 : rule__ProblemRule__Group__1__Impl rule__ProblemRule__Group__2 ;
    public final void rule__ProblemRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2312:1: ( rule__ProblemRule__Group__1__Impl rule__ProblemRule__Group__2 )
            // InternalOptimisationLanguage.g:2313:2: rule__ProblemRule__Group__1__Impl rule__ProblemRule__Group__2
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
    // InternalOptimisationLanguage.g:2320:1: rule__ProblemRule__Group__1__Impl : ( ( rule__ProblemRule__DefinitionAssignment_1 ) ) ;
    public final void rule__ProblemRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2324:1: ( ( ( rule__ProblemRule__DefinitionAssignment_1 ) ) )
            // InternalOptimisationLanguage.g:2325:1: ( ( rule__ProblemRule__DefinitionAssignment_1 ) )
            {
            // InternalOptimisationLanguage.g:2325:1: ( ( rule__ProblemRule__DefinitionAssignment_1 ) )
            // InternalOptimisationLanguage.g:2326:2: ( rule__ProblemRule__DefinitionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProblemRuleAccess().getDefinitionAssignment_1()); 
            }
            // InternalOptimisationLanguage.g:2327:2: ( rule__ProblemRule__DefinitionAssignment_1 )
            // InternalOptimisationLanguage.g:2327:3: rule__ProblemRule__DefinitionAssignment_1
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
    // InternalOptimisationLanguage.g:2335:1: rule__ProblemRule__Group__2 : rule__ProblemRule__Group__2__Impl rule__ProblemRule__Group__3 ;
    public final void rule__ProblemRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2339:1: ( rule__ProblemRule__Group__2__Impl rule__ProblemRule__Group__3 )
            // InternalOptimisationLanguage.g:2340:2: rule__ProblemRule__Group__2__Impl rule__ProblemRule__Group__3
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
    // InternalOptimisationLanguage.g:2347:1: rule__ProblemRule__Group__2__Impl : ( ( rule__ProblemRule__NameAssignment_2 ) ) ;
    public final void rule__ProblemRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2351:1: ( ( ( rule__ProblemRule__NameAssignment_2 ) ) )
            // InternalOptimisationLanguage.g:2352:1: ( ( rule__ProblemRule__NameAssignment_2 ) )
            {
            // InternalOptimisationLanguage.g:2352:1: ( ( rule__ProblemRule__NameAssignment_2 ) )
            // InternalOptimisationLanguage.g:2353:2: ( rule__ProblemRule__NameAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProblemRuleAccess().getNameAssignment_2()); 
            }
            // InternalOptimisationLanguage.g:2354:2: ( rule__ProblemRule__NameAssignment_2 )
            // InternalOptimisationLanguage.g:2354:3: rule__ProblemRule__NameAssignment_2
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
    // InternalOptimisationLanguage.g:2362:1: rule__ProblemRule__Group__3 : rule__ProblemRule__Group__3__Impl rule__ProblemRule__Group__4 ;
    public final void rule__ProblemRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2366:1: ( rule__ProblemRule__Group__3__Impl rule__ProblemRule__Group__4 )
            // InternalOptimisationLanguage.g:2367:2: rule__ProblemRule__Group__3__Impl rule__ProblemRule__Group__4
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
    // InternalOptimisationLanguage.g:2374:1: rule__ProblemRule__Group__3__Impl : ( '{' ) ;
    public final void rule__ProblemRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2378:1: ( ( '{' ) )
            // InternalOptimisationLanguage.g:2379:1: ( '{' )
            {
            // InternalOptimisationLanguage.g:2379:1: ( '{' )
            // InternalOptimisationLanguage.g:2380:2: '{'
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
    // InternalOptimisationLanguage.g:2389:1: rule__ProblemRule__Group__4 : rule__ProblemRule__Group__4__Impl rule__ProblemRule__Group__5 ;
    public final void rule__ProblemRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2393:1: ( rule__ProblemRule__Group__4__Impl rule__ProblemRule__Group__5 )
            // InternalOptimisationLanguage.g:2394:2: rule__ProblemRule__Group__4__Impl rule__ProblemRule__Group__5
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
    // InternalOptimisationLanguage.g:2401:1: rule__ProblemRule__Group__4__Impl : ( 'search' ) ;
    public final void rule__ProblemRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2405:1: ( ( 'search' ) )
            // InternalOptimisationLanguage.g:2406:1: ( 'search' )
            {
            // InternalOptimisationLanguage.g:2406:1: ( 'search' )
            // InternalOptimisationLanguage.g:2407:2: 'search'
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
    // InternalOptimisationLanguage.g:2416:1: rule__ProblemRule__Group__5 : rule__ProblemRule__Group__5__Impl rule__ProblemRule__Group__6 ;
    public final void rule__ProblemRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2420:1: ( rule__ProblemRule__Group__5__Impl rule__ProblemRule__Group__6 )
            // InternalOptimisationLanguage.g:2421:2: rule__ProblemRule__Group__5__Impl rule__ProblemRule__Group__6
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
    // InternalOptimisationLanguage.g:2428:1: rule__ProblemRule__Group__5__Impl : ( 'for' ) ;
    public final void rule__ProblemRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2432:1: ( ( 'for' ) )
            // InternalOptimisationLanguage.g:2433:1: ( 'for' )
            {
            // InternalOptimisationLanguage.g:2433:1: ( 'for' )
            // InternalOptimisationLanguage.g:2434:2: 'for'
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
    // InternalOptimisationLanguage.g:2443:1: rule__ProblemRule__Group__6 : rule__ProblemRule__Group__6__Impl rule__ProblemRule__Group__7 ;
    public final void rule__ProblemRule__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2447:1: ( rule__ProblemRule__Group__6__Impl rule__ProblemRule__Group__7 )
            // InternalOptimisationLanguage.g:2448:2: rule__ProblemRule__Group__6__Impl rule__ProblemRule__Group__7
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
    // InternalOptimisationLanguage.g:2455:1: rule__ProblemRule__Group__6__Impl : ( ( rule__ProblemRule__SearchSpaceAssignment_6 ) ) ;
    public final void rule__ProblemRule__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2459:1: ( ( ( rule__ProblemRule__SearchSpaceAssignment_6 ) ) )
            // InternalOptimisationLanguage.g:2460:1: ( ( rule__ProblemRule__SearchSpaceAssignment_6 ) )
            {
            // InternalOptimisationLanguage.g:2460:1: ( ( rule__ProblemRule__SearchSpaceAssignment_6 ) )
            // InternalOptimisationLanguage.g:2461:2: ( rule__ProblemRule__SearchSpaceAssignment_6 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProblemRuleAccess().getSearchSpaceAssignment_6()); 
            }
            // InternalOptimisationLanguage.g:2462:2: ( rule__ProblemRule__SearchSpaceAssignment_6 )
            // InternalOptimisationLanguage.g:2462:3: rule__ProblemRule__SearchSpaceAssignment_6
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
    // InternalOptimisationLanguage.g:2470:1: rule__ProblemRule__Group__7 : rule__ProblemRule__Group__7__Impl rule__ProblemRule__Group__8 ;
    public final void rule__ProblemRule__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2474:1: ( rule__ProblemRule__Group__7__Impl rule__ProblemRule__Group__8 )
            // InternalOptimisationLanguage.g:2475:2: rule__ProblemRule__Group__7__Impl rule__ProblemRule__Group__8
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
    // InternalOptimisationLanguage.g:2482:1: rule__ProblemRule__Group__7__Impl : ( ( rule__ProblemRule__Group_7__0 )* ) ;
    public final void rule__ProblemRule__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2486:1: ( ( ( rule__ProblemRule__Group_7__0 )* ) )
            // InternalOptimisationLanguage.g:2487:1: ( ( rule__ProblemRule__Group_7__0 )* )
            {
            // InternalOptimisationLanguage.g:2487:1: ( ( rule__ProblemRule__Group_7__0 )* )
            // InternalOptimisationLanguage.g:2488:2: ( rule__ProblemRule__Group_7__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProblemRuleAccess().getGroup_7()); 
            }
            // InternalOptimisationLanguage.g:2489:2: ( rule__ProblemRule__Group_7__0 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==56) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:2489:3: rule__ProblemRule__Group_7__0
            	    {
            	    pushFollow(FOLLOW_12);
            	    rule__ProblemRule__Group_7__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop19;
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
    // InternalOptimisationLanguage.g:2497:1: rule__ProblemRule__Group__8 : rule__ProblemRule__Group__8__Impl rule__ProblemRule__Group__9 ;
    public final void rule__ProblemRule__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2501:1: ( rule__ProblemRule__Group__8__Impl rule__ProblemRule__Group__9 )
            // InternalOptimisationLanguage.g:2502:2: rule__ProblemRule__Group__8__Impl rule__ProblemRule__Group__9
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
    // InternalOptimisationLanguage.g:2509:1: rule__ProblemRule__Group__8__Impl : ( 'map' ) ;
    public final void rule__ProblemRule__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2513:1: ( ( 'map' ) )
            // InternalOptimisationLanguage.g:2514:1: ( 'map' )
            {
            // InternalOptimisationLanguage.g:2514:1: ( 'map' )
            // InternalOptimisationLanguage.g:2515:2: 'map'
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
    // InternalOptimisationLanguage.g:2524:1: rule__ProblemRule__Group__9 : rule__ProblemRule__Group__9__Impl rule__ProblemRule__Group__10 ;
    public final void rule__ProblemRule__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2528:1: ( rule__ProblemRule__Group__9__Impl rule__ProblemRule__Group__10 )
            // InternalOptimisationLanguage.g:2529:2: rule__ProblemRule__Group__9__Impl rule__ProblemRule__Group__10
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
    // InternalOptimisationLanguage.g:2536:1: rule__ProblemRule__Group__9__Impl : ( 'with' ) ;
    public final void rule__ProblemRule__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2540:1: ( ( 'with' ) )
            // InternalOptimisationLanguage.g:2541:1: ( 'with' )
            {
            // InternalOptimisationLanguage.g:2541:1: ( 'with' )
            // InternalOptimisationLanguage.g:2542:2: 'with'
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
    // InternalOptimisationLanguage.g:2551:1: rule__ProblemRule__Group__10 : rule__ProblemRule__Group__10__Impl rule__ProblemRule__Group__11 ;
    public final void rule__ProblemRule__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2555:1: ( rule__ProblemRule__Group__10__Impl rule__ProblemRule__Group__11 )
            // InternalOptimisationLanguage.g:2556:2: rule__ProblemRule__Group__10__Impl rule__ProblemRule__Group__11
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
    // InternalOptimisationLanguage.g:2563:1: rule__ProblemRule__Group__10__Impl : ( ( rule__ProblemRule__OptimisationFunctionAssignment_10 ) ) ;
    public final void rule__ProblemRule__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2567:1: ( ( ( rule__ProblemRule__OptimisationFunctionAssignment_10 ) ) )
            // InternalOptimisationLanguage.g:2568:1: ( ( rule__ProblemRule__OptimisationFunctionAssignment_10 ) )
            {
            // InternalOptimisationLanguage.g:2568:1: ( ( rule__ProblemRule__OptimisationFunctionAssignment_10 ) )
            // InternalOptimisationLanguage.g:2569:2: ( rule__ProblemRule__OptimisationFunctionAssignment_10 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProblemRuleAccess().getOptimisationFunctionAssignment_10()); 
            }
            // InternalOptimisationLanguage.g:2570:2: ( rule__ProblemRule__OptimisationFunctionAssignment_10 )
            // InternalOptimisationLanguage.g:2570:3: rule__ProblemRule__OptimisationFunctionAssignment_10
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
    // InternalOptimisationLanguage.g:2578:1: rule__ProblemRule__Group__11 : rule__ProblemRule__Group__11__Impl rule__ProblemRule__Group__12 ;
    public final void rule__ProblemRule__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2582:1: ( rule__ProblemRule__Group__11__Impl rule__ProblemRule__Group__12 )
            // InternalOptimisationLanguage.g:2583:2: rule__ProblemRule__Group__11__Impl rule__ProblemRule__Group__12
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
    // InternalOptimisationLanguage.g:2590:1: rule__ProblemRule__Group__11__Impl : ( 'and' ) ;
    public final void rule__ProblemRule__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2594:1: ( ( 'and' ) )
            // InternalOptimisationLanguage.g:2595:1: ( 'and' )
            {
            // InternalOptimisationLanguage.g:2595:1: ( 'and' )
            // InternalOptimisationLanguage.g:2596:2: 'and'
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
    // InternalOptimisationLanguage.g:2605:1: rule__ProblemRule__Group__12 : rule__ProblemRule__Group__12__Impl rule__ProblemRule__Group__13 ;
    public final void rule__ProblemRule__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2609:1: ( rule__ProblemRule__Group__12__Impl rule__ProblemRule__Group__13 )
            // InternalOptimisationLanguage.g:2610:2: rule__ProblemRule__Group__12__Impl rule__ProblemRule__Group__13
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
    // InternalOptimisationLanguage.g:2617:1: rule__ProblemRule__Group__12__Impl : ( ( rule__ProblemRule__OptimisationSpaceAssignment_12 ) ) ;
    public final void rule__ProblemRule__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2621:1: ( ( ( rule__ProblemRule__OptimisationSpaceAssignment_12 ) ) )
            // InternalOptimisationLanguage.g:2622:1: ( ( rule__ProblemRule__OptimisationSpaceAssignment_12 ) )
            {
            // InternalOptimisationLanguage.g:2622:1: ( ( rule__ProblemRule__OptimisationSpaceAssignment_12 ) )
            // InternalOptimisationLanguage.g:2623:2: ( rule__ProblemRule__OptimisationSpaceAssignment_12 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProblemRuleAccess().getOptimisationSpaceAssignment_12()); 
            }
            // InternalOptimisationLanguage.g:2624:2: ( rule__ProblemRule__OptimisationSpaceAssignment_12 )
            // InternalOptimisationLanguage.g:2624:3: rule__ProblemRule__OptimisationSpaceAssignment_12
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
    // InternalOptimisationLanguage.g:2632:1: rule__ProblemRule__Group__13 : rule__ProblemRule__Group__13__Impl rule__ProblemRule__Group__14 ;
    public final void rule__ProblemRule__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2636:1: ( rule__ProblemRule__Group__13__Impl rule__ProblemRule__Group__14 )
            // InternalOptimisationLanguage.g:2637:2: rule__ProblemRule__Group__13__Impl rule__ProblemRule__Group__14
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
    // InternalOptimisationLanguage.g:2644:1: rule__ProblemRule__Group__13__Impl : ( ( rule__ProblemRule__Group_13__0 )* ) ;
    public final void rule__ProblemRule__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2648:1: ( ( ( rule__ProblemRule__Group_13__0 )* ) )
            // InternalOptimisationLanguage.g:2649:1: ( ( rule__ProblemRule__Group_13__0 )* )
            {
            // InternalOptimisationLanguage.g:2649:1: ( ( rule__ProblemRule__Group_13__0 )* )
            // InternalOptimisationLanguage.g:2650:2: ( rule__ProblemRule__Group_13__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProblemRuleAccess().getGroup_13()); 
            }
            // InternalOptimisationLanguage.g:2651:2: ( rule__ProblemRule__Group_13__0 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==56) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:2651:3: rule__ProblemRule__Group_13__0
            	    {
            	    pushFollow(FOLLOW_12);
            	    rule__ProblemRule__Group_13__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop20;
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
    // InternalOptimisationLanguage.g:2659:1: rule__ProblemRule__Group__14 : rule__ProblemRule__Group__14__Impl rule__ProblemRule__Group__15 ;
    public final void rule__ProblemRule__Group__14() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2663:1: ( rule__ProblemRule__Group__14__Impl rule__ProblemRule__Group__15 )
            // InternalOptimisationLanguage.g:2664:2: rule__ProblemRule__Group__14__Impl rule__ProblemRule__Group__15
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
    // InternalOptimisationLanguage.g:2671:1: rule__ProblemRule__Group__14__Impl : ( ( rule__ProblemRule__Group_14__0 )? ) ;
    public final void rule__ProblemRule__Group__14__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2675:1: ( ( ( rule__ProblemRule__Group_14__0 )? ) )
            // InternalOptimisationLanguage.g:2676:1: ( ( rule__ProblemRule__Group_14__0 )? )
            {
            // InternalOptimisationLanguage.g:2676:1: ( ( rule__ProblemRule__Group_14__0 )? )
            // InternalOptimisationLanguage.g:2677:2: ( rule__ProblemRule__Group_14__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProblemRuleAccess().getGroup_14()); 
            }
            // InternalOptimisationLanguage.g:2678:2: ( rule__ProblemRule__Group_14__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==57) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalOptimisationLanguage.g:2678:3: rule__ProblemRule__Group_14__0
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
    // InternalOptimisationLanguage.g:2686:1: rule__ProblemRule__Group__15 : rule__ProblemRule__Group__15__Impl ;
    public final void rule__ProblemRule__Group__15() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2690:1: ( rule__ProblemRule__Group__15__Impl )
            // InternalOptimisationLanguage.g:2691:2: rule__ProblemRule__Group__15__Impl
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
    // InternalOptimisationLanguage.g:2697:1: rule__ProblemRule__Group__15__Impl : ( '}' ) ;
    public final void rule__ProblemRule__Group__15__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2701:1: ( ( '}' ) )
            // InternalOptimisationLanguage.g:2702:1: ( '}' )
            {
            // InternalOptimisationLanguage.g:2702:1: ( '}' )
            // InternalOptimisationLanguage.g:2703:2: '}'
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
    // InternalOptimisationLanguage.g:2713:1: rule__ProblemRule__Group_7__0 : rule__ProblemRule__Group_7__0__Impl rule__ProblemRule__Group_7__1 ;
    public final void rule__ProblemRule__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2717:1: ( rule__ProblemRule__Group_7__0__Impl rule__ProblemRule__Group_7__1 )
            // InternalOptimisationLanguage.g:2718:2: rule__ProblemRule__Group_7__0__Impl rule__ProblemRule__Group_7__1
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
    // InternalOptimisationLanguage.g:2725:1: rule__ProblemRule__Group_7__0__Impl : ( ',' ) ;
    public final void rule__ProblemRule__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2729:1: ( ( ',' ) )
            // InternalOptimisationLanguage.g:2730:1: ( ',' )
            {
            // InternalOptimisationLanguage.g:2730:1: ( ',' )
            // InternalOptimisationLanguage.g:2731:2: ','
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
    // InternalOptimisationLanguage.g:2740:1: rule__ProblemRule__Group_7__1 : rule__ProblemRule__Group_7__1__Impl ;
    public final void rule__ProblemRule__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2744:1: ( rule__ProblemRule__Group_7__1__Impl )
            // InternalOptimisationLanguage.g:2745:2: rule__ProblemRule__Group_7__1__Impl
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
    // InternalOptimisationLanguage.g:2751:1: rule__ProblemRule__Group_7__1__Impl : ( ( rule__ProblemRule__SearchSpaceAssignment_7_1 ) ) ;
    public final void rule__ProblemRule__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2755:1: ( ( ( rule__ProblemRule__SearchSpaceAssignment_7_1 ) ) )
            // InternalOptimisationLanguage.g:2756:1: ( ( rule__ProblemRule__SearchSpaceAssignment_7_1 ) )
            {
            // InternalOptimisationLanguage.g:2756:1: ( ( rule__ProblemRule__SearchSpaceAssignment_7_1 ) )
            // InternalOptimisationLanguage.g:2757:2: ( rule__ProblemRule__SearchSpaceAssignment_7_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProblemRuleAccess().getSearchSpaceAssignment_7_1()); 
            }
            // InternalOptimisationLanguage.g:2758:2: ( rule__ProblemRule__SearchSpaceAssignment_7_1 )
            // InternalOptimisationLanguage.g:2758:3: rule__ProblemRule__SearchSpaceAssignment_7_1
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
    // InternalOptimisationLanguage.g:2767:1: rule__ProblemRule__Group_13__0 : rule__ProblemRule__Group_13__0__Impl rule__ProblemRule__Group_13__1 ;
    public final void rule__ProblemRule__Group_13__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2771:1: ( rule__ProblemRule__Group_13__0__Impl rule__ProblemRule__Group_13__1 )
            // InternalOptimisationLanguage.g:2772:2: rule__ProblemRule__Group_13__0__Impl rule__ProblemRule__Group_13__1
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
    // InternalOptimisationLanguage.g:2779:1: rule__ProblemRule__Group_13__0__Impl : ( ',' ) ;
    public final void rule__ProblemRule__Group_13__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2783:1: ( ( ',' ) )
            // InternalOptimisationLanguage.g:2784:1: ( ',' )
            {
            // InternalOptimisationLanguage.g:2784:1: ( ',' )
            // InternalOptimisationLanguage.g:2785:2: ','
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
    // InternalOptimisationLanguage.g:2794:1: rule__ProblemRule__Group_13__1 : rule__ProblemRule__Group_13__1__Impl ;
    public final void rule__ProblemRule__Group_13__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2798:1: ( rule__ProblemRule__Group_13__1__Impl )
            // InternalOptimisationLanguage.g:2799:2: rule__ProblemRule__Group_13__1__Impl
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
    // InternalOptimisationLanguage.g:2805:1: rule__ProblemRule__Group_13__1__Impl : ( ( rule__ProblemRule__OptimisationSpaceAssignment_13_1 ) ) ;
    public final void rule__ProblemRule__Group_13__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2809:1: ( ( ( rule__ProblemRule__OptimisationSpaceAssignment_13_1 ) ) )
            // InternalOptimisationLanguage.g:2810:1: ( ( rule__ProblemRule__OptimisationSpaceAssignment_13_1 ) )
            {
            // InternalOptimisationLanguage.g:2810:1: ( ( rule__ProblemRule__OptimisationSpaceAssignment_13_1 ) )
            // InternalOptimisationLanguage.g:2811:2: ( rule__ProblemRule__OptimisationSpaceAssignment_13_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProblemRuleAccess().getOptimisationSpaceAssignment_13_1()); 
            }
            // InternalOptimisationLanguage.g:2812:2: ( rule__ProblemRule__OptimisationSpaceAssignment_13_1 )
            // InternalOptimisationLanguage.g:2812:3: rule__ProblemRule__OptimisationSpaceAssignment_13_1
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
    // InternalOptimisationLanguage.g:2821:1: rule__ProblemRule__Group_14__0 : rule__ProblemRule__Group_14__0__Impl rule__ProblemRule__Group_14__1 ;
    public final void rule__ProblemRule__Group_14__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2825:1: ( rule__ProblemRule__Group_14__0__Impl rule__ProblemRule__Group_14__1 )
            // InternalOptimisationLanguage.g:2826:2: rule__ProblemRule__Group_14__0__Impl rule__ProblemRule__Group_14__1
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
    // InternalOptimisationLanguage.g:2833:1: rule__ProblemRule__Group_14__0__Impl : ( 'document' ) ;
    public final void rule__ProblemRule__Group_14__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2837:1: ( ( 'document' ) )
            // InternalOptimisationLanguage.g:2838:1: ( 'document' )
            {
            // InternalOptimisationLanguage.g:2838:1: ( 'document' )
            // InternalOptimisationLanguage.g:2839:2: 'document'
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
    // InternalOptimisationLanguage.g:2848:1: rule__ProblemRule__Group_14__1 : rule__ProblemRule__Group_14__1__Impl rule__ProblemRule__Group_14__2 ;
    public final void rule__ProblemRule__Group_14__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2852:1: ( rule__ProblemRule__Group_14__1__Impl rule__ProblemRule__Group_14__2 )
            // InternalOptimisationLanguage.g:2853:2: rule__ProblemRule__Group_14__1__Impl rule__ProblemRule__Group_14__2
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
    // InternalOptimisationLanguage.g:2860:1: rule__ProblemRule__Group_14__1__Impl : ( ( rule__ProblemRule__DocumentationAssignment_14_1 ) ) ;
    public final void rule__ProblemRule__Group_14__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2864:1: ( ( ( rule__ProblemRule__DocumentationAssignment_14_1 ) ) )
            // InternalOptimisationLanguage.g:2865:1: ( ( rule__ProblemRule__DocumentationAssignment_14_1 ) )
            {
            // InternalOptimisationLanguage.g:2865:1: ( ( rule__ProblemRule__DocumentationAssignment_14_1 ) )
            // InternalOptimisationLanguage.g:2866:2: ( rule__ProblemRule__DocumentationAssignment_14_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProblemRuleAccess().getDocumentationAssignment_14_1()); 
            }
            // InternalOptimisationLanguage.g:2867:2: ( rule__ProblemRule__DocumentationAssignment_14_1 )
            // InternalOptimisationLanguage.g:2867:3: rule__ProblemRule__DocumentationAssignment_14_1
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
    // InternalOptimisationLanguage.g:2875:1: rule__ProblemRule__Group_14__2 : rule__ProblemRule__Group_14__2__Impl ;
    public final void rule__ProblemRule__Group_14__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2879:1: ( rule__ProblemRule__Group_14__2__Impl )
            // InternalOptimisationLanguage.g:2880:2: rule__ProblemRule__Group_14__2__Impl
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
    // InternalOptimisationLanguage.g:2886:1: rule__ProblemRule__Group_14__2__Impl : ( '.' ) ;
    public final void rule__ProblemRule__Group_14__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2890:1: ( ( '.' ) )
            // InternalOptimisationLanguage.g:2891:1: ( '.' )
            {
            // InternalOptimisationLanguage.g:2891:1: ( '.' )
            // InternalOptimisationLanguage.g:2892:2: '.'
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
    // InternalOptimisationLanguage.g:2902:1: rule__MaximiseGoalRule__Group__0 : rule__MaximiseGoalRule__Group__0__Impl rule__MaximiseGoalRule__Group__1 ;
    public final void rule__MaximiseGoalRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2906:1: ( rule__MaximiseGoalRule__Group__0__Impl rule__MaximiseGoalRule__Group__1 )
            // InternalOptimisationLanguage.g:2907:2: rule__MaximiseGoalRule__Group__0__Impl rule__MaximiseGoalRule__Group__1
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
    // InternalOptimisationLanguage.g:2914:1: rule__MaximiseGoalRule__Group__0__Impl : ( 'maximise' ) ;
    public final void rule__MaximiseGoalRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2918:1: ( ( 'maximise' ) )
            // InternalOptimisationLanguage.g:2919:1: ( 'maximise' )
            {
            // InternalOptimisationLanguage.g:2919:1: ( 'maximise' )
            // InternalOptimisationLanguage.g:2920:2: 'maximise'
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
    // InternalOptimisationLanguage.g:2929:1: rule__MaximiseGoalRule__Group__1 : rule__MaximiseGoalRule__Group__1__Impl ;
    public final void rule__MaximiseGoalRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2933:1: ( rule__MaximiseGoalRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:2934:2: rule__MaximiseGoalRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:2940:1: rule__MaximiseGoalRule__Group__1__Impl : ( ( rule__MaximiseGoalRule__DataAssignment_1 ) ) ;
    public final void rule__MaximiseGoalRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2944:1: ( ( ( rule__MaximiseGoalRule__DataAssignment_1 ) ) )
            // InternalOptimisationLanguage.g:2945:1: ( ( rule__MaximiseGoalRule__DataAssignment_1 ) )
            {
            // InternalOptimisationLanguage.g:2945:1: ( ( rule__MaximiseGoalRule__DataAssignment_1 ) )
            // InternalOptimisationLanguage.g:2946:2: ( rule__MaximiseGoalRule__DataAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMaximiseGoalRuleAccess().getDataAssignment_1()); 
            }
            // InternalOptimisationLanguage.g:2947:2: ( rule__MaximiseGoalRule__DataAssignment_1 )
            // InternalOptimisationLanguage.g:2947:3: rule__MaximiseGoalRule__DataAssignment_1
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
    // InternalOptimisationLanguage.g:2956:1: rule__MinimiseGoalRule__Group__0 : rule__MinimiseGoalRule__Group__0__Impl rule__MinimiseGoalRule__Group__1 ;
    public final void rule__MinimiseGoalRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2960:1: ( rule__MinimiseGoalRule__Group__0__Impl rule__MinimiseGoalRule__Group__1 )
            // InternalOptimisationLanguage.g:2961:2: rule__MinimiseGoalRule__Group__0__Impl rule__MinimiseGoalRule__Group__1
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
    // InternalOptimisationLanguage.g:2968:1: rule__MinimiseGoalRule__Group__0__Impl : ( 'minimise' ) ;
    public final void rule__MinimiseGoalRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2972:1: ( ( 'minimise' ) )
            // InternalOptimisationLanguage.g:2973:1: ( 'minimise' )
            {
            // InternalOptimisationLanguage.g:2973:1: ( 'minimise' )
            // InternalOptimisationLanguage.g:2974:2: 'minimise'
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
    // InternalOptimisationLanguage.g:2983:1: rule__MinimiseGoalRule__Group__1 : rule__MinimiseGoalRule__Group__1__Impl ;
    public final void rule__MinimiseGoalRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2987:1: ( rule__MinimiseGoalRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:2988:2: rule__MinimiseGoalRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:2994:1: rule__MinimiseGoalRule__Group__1__Impl : ( ( rule__MinimiseGoalRule__DataAssignment_1 ) ) ;
    public final void rule__MinimiseGoalRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2998:1: ( ( ( rule__MinimiseGoalRule__DataAssignment_1 ) ) )
            // InternalOptimisationLanguage.g:2999:1: ( ( rule__MinimiseGoalRule__DataAssignment_1 ) )
            {
            // InternalOptimisationLanguage.g:2999:1: ( ( rule__MinimiseGoalRule__DataAssignment_1 ) )
            // InternalOptimisationLanguage.g:3000:2: ( rule__MinimiseGoalRule__DataAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMinimiseGoalRuleAccess().getDataAssignment_1()); 
            }
            // InternalOptimisationLanguage.g:3001:2: ( rule__MinimiseGoalRule__DataAssignment_1 )
            // InternalOptimisationLanguage.g:3001:3: rule__MinimiseGoalRule__DataAssignment_1
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
    // InternalOptimisationLanguage.g:3010:1: rule__TargetGoalRule__Group__0 : rule__TargetGoalRule__Group__0__Impl rule__TargetGoalRule__Group__1 ;
    public final void rule__TargetGoalRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3014:1: ( rule__TargetGoalRule__Group__0__Impl rule__TargetGoalRule__Group__1 )
            // InternalOptimisationLanguage.g:3015:2: rule__TargetGoalRule__Group__0__Impl rule__TargetGoalRule__Group__1
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
    // InternalOptimisationLanguage.g:3022:1: rule__TargetGoalRule__Group__0__Impl : ( 'optimise' ) ;
    public final void rule__TargetGoalRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3026:1: ( ( 'optimise' ) )
            // InternalOptimisationLanguage.g:3027:1: ( 'optimise' )
            {
            // InternalOptimisationLanguage.g:3027:1: ( 'optimise' )
            // InternalOptimisationLanguage.g:3028:2: 'optimise'
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
    // InternalOptimisationLanguage.g:3037:1: rule__TargetGoalRule__Group__1 : rule__TargetGoalRule__Group__1__Impl rule__TargetGoalRule__Group__2 ;
    public final void rule__TargetGoalRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3041:1: ( rule__TargetGoalRule__Group__1__Impl rule__TargetGoalRule__Group__2 )
            // InternalOptimisationLanguage.g:3042:2: rule__TargetGoalRule__Group__1__Impl rule__TargetGoalRule__Group__2
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
    // InternalOptimisationLanguage.g:3049:1: rule__TargetGoalRule__Group__1__Impl : ( ( rule__TargetGoalRule__DataAssignment_1 ) ) ;
    public final void rule__TargetGoalRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3053:1: ( ( ( rule__TargetGoalRule__DataAssignment_1 ) ) )
            // InternalOptimisationLanguage.g:3054:1: ( ( rule__TargetGoalRule__DataAssignment_1 ) )
            {
            // InternalOptimisationLanguage.g:3054:1: ( ( rule__TargetGoalRule__DataAssignment_1 ) )
            // InternalOptimisationLanguage.g:3055:2: ( rule__TargetGoalRule__DataAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTargetGoalRuleAccess().getDataAssignment_1()); 
            }
            // InternalOptimisationLanguage.g:3056:2: ( rule__TargetGoalRule__DataAssignment_1 )
            // InternalOptimisationLanguage.g:3056:3: rule__TargetGoalRule__DataAssignment_1
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
    // InternalOptimisationLanguage.g:3064:1: rule__TargetGoalRule__Group__2 : rule__TargetGoalRule__Group__2__Impl rule__TargetGoalRule__Group__3 ;
    public final void rule__TargetGoalRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3068:1: ( rule__TargetGoalRule__Group__2__Impl rule__TargetGoalRule__Group__3 )
            // InternalOptimisationLanguage.g:3069:2: rule__TargetGoalRule__Group__2__Impl rule__TargetGoalRule__Group__3
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
    // InternalOptimisationLanguage.g:3076:1: rule__TargetGoalRule__Group__2__Impl : ( 'towards' ) ;
    public final void rule__TargetGoalRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3080:1: ( ( 'towards' ) )
            // InternalOptimisationLanguage.g:3081:1: ( 'towards' )
            {
            // InternalOptimisationLanguage.g:3081:1: ( 'towards' )
            // InternalOptimisationLanguage.g:3082:2: 'towards'
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
    // InternalOptimisationLanguage.g:3091:1: rule__TargetGoalRule__Group__3 : rule__TargetGoalRule__Group__3__Impl ;
    public final void rule__TargetGoalRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3095:1: ( rule__TargetGoalRule__Group__3__Impl )
            // InternalOptimisationLanguage.g:3096:2: rule__TargetGoalRule__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TargetGoalRule__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalOptimisationLanguage.g:3102:1: rule__TargetGoalRule__Group__3__Impl : ( ( rule__TargetGoalRule__ValueAssignment_3 ) ) ;
    public final void rule__TargetGoalRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3106:1: ( ( ( rule__TargetGoalRule__ValueAssignment_3 ) ) )
            // InternalOptimisationLanguage.g:3107:1: ( ( rule__TargetGoalRule__ValueAssignment_3 ) )
            {
            // InternalOptimisationLanguage.g:3107:1: ( ( rule__TargetGoalRule__ValueAssignment_3 ) )
            // InternalOptimisationLanguage.g:3108:2: ( rule__TargetGoalRule__ValueAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTargetGoalRuleAccess().getValueAssignment_3()); 
            }
            // InternalOptimisationLanguage.g:3109:2: ( rule__TargetGoalRule__ValueAssignment_3 )
            // InternalOptimisationLanguage.g:3109:3: rule__TargetGoalRule__ValueAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__TargetGoalRule__ValueAssignment_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTargetGoalRuleAccess().getValueAssignment_3()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__AlgorithmInstanceRule__Group__0"
    // InternalOptimisationLanguage.g:3118:1: rule__AlgorithmInstanceRule__Group__0 : rule__AlgorithmInstanceRule__Group__0__Impl rule__AlgorithmInstanceRule__Group__1 ;
    public final void rule__AlgorithmInstanceRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3122:1: ( rule__AlgorithmInstanceRule__Group__0__Impl rule__AlgorithmInstanceRule__Group__1 )
            // InternalOptimisationLanguage.g:3123:2: rule__AlgorithmInstanceRule__Group__0__Impl rule__AlgorithmInstanceRule__Group__1
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
    // InternalOptimisationLanguage.g:3130:1: rule__AlgorithmInstanceRule__Group__0__Impl : ( 'configure' ) ;
    public final void rule__AlgorithmInstanceRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3134:1: ( ( 'configure' ) )
            // InternalOptimisationLanguage.g:3135:1: ( 'configure' )
            {
            // InternalOptimisationLanguage.g:3135:1: ( 'configure' )
            // InternalOptimisationLanguage.g:3136:2: 'configure'
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
    // InternalOptimisationLanguage.g:3145:1: rule__AlgorithmInstanceRule__Group__1 : rule__AlgorithmInstanceRule__Group__1__Impl rule__AlgorithmInstanceRule__Group__2 ;
    public final void rule__AlgorithmInstanceRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3149:1: ( rule__AlgorithmInstanceRule__Group__1__Impl rule__AlgorithmInstanceRule__Group__2 )
            // InternalOptimisationLanguage.g:3150:2: rule__AlgorithmInstanceRule__Group__1__Impl rule__AlgorithmInstanceRule__Group__2
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
    // InternalOptimisationLanguage.g:3157:1: rule__AlgorithmInstanceRule__Group__1__Impl : ( ( rule__AlgorithmInstanceRule__DefinitionAssignment_1 ) ) ;
    public final void rule__AlgorithmInstanceRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3161:1: ( ( ( rule__AlgorithmInstanceRule__DefinitionAssignment_1 ) ) )
            // InternalOptimisationLanguage.g:3162:1: ( ( rule__AlgorithmInstanceRule__DefinitionAssignment_1 ) )
            {
            // InternalOptimisationLanguage.g:3162:1: ( ( rule__AlgorithmInstanceRule__DefinitionAssignment_1 ) )
            // InternalOptimisationLanguage.g:3163:2: ( rule__AlgorithmInstanceRule__DefinitionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAlgorithmInstanceRuleAccess().getDefinitionAssignment_1()); 
            }
            // InternalOptimisationLanguage.g:3164:2: ( rule__AlgorithmInstanceRule__DefinitionAssignment_1 )
            // InternalOptimisationLanguage.g:3164:3: rule__AlgorithmInstanceRule__DefinitionAssignment_1
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
    // InternalOptimisationLanguage.g:3172:1: rule__AlgorithmInstanceRule__Group__2 : rule__AlgorithmInstanceRule__Group__2__Impl rule__AlgorithmInstanceRule__Group__3 ;
    public final void rule__AlgorithmInstanceRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3176:1: ( rule__AlgorithmInstanceRule__Group__2__Impl rule__AlgorithmInstanceRule__Group__3 )
            // InternalOptimisationLanguage.g:3177:2: rule__AlgorithmInstanceRule__Group__2__Impl rule__AlgorithmInstanceRule__Group__3
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
    // InternalOptimisationLanguage.g:3184:1: rule__AlgorithmInstanceRule__Group__2__Impl : ( 'for' ) ;
    public final void rule__AlgorithmInstanceRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3188:1: ( ( 'for' ) )
            // InternalOptimisationLanguage.g:3189:1: ( 'for' )
            {
            // InternalOptimisationLanguage.g:3189:1: ( 'for' )
            // InternalOptimisationLanguage.g:3190:2: 'for'
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
    // InternalOptimisationLanguage.g:3199:1: rule__AlgorithmInstanceRule__Group__3 : rule__AlgorithmInstanceRule__Group__3__Impl rule__AlgorithmInstanceRule__Group__4 ;
    public final void rule__AlgorithmInstanceRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3203:1: ( rule__AlgorithmInstanceRule__Group__3__Impl rule__AlgorithmInstanceRule__Group__4 )
            // InternalOptimisationLanguage.g:3204:2: rule__AlgorithmInstanceRule__Group__3__Impl rule__AlgorithmInstanceRule__Group__4
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
    // InternalOptimisationLanguage.g:3211:1: rule__AlgorithmInstanceRule__Group__3__Impl : ( ( rule__AlgorithmInstanceRule__ProblemAssignment_3 ) ) ;
    public final void rule__AlgorithmInstanceRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3215:1: ( ( ( rule__AlgorithmInstanceRule__ProblemAssignment_3 ) ) )
            // InternalOptimisationLanguage.g:3216:1: ( ( rule__AlgorithmInstanceRule__ProblemAssignment_3 ) )
            {
            // InternalOptimisationLanguage.g:3216:1: ( ( rule__AlgorithmInstanceRule__ProblemAssignment_3 ) )
            // InternalOptimisationLanguage.g:3217:2: ( rule__AlgorithmInstanceRule__ProblemAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAlgorithmInstanceRuleAccess().getProblemAssignment_3()); 
            }
            // InternalOptimisationLanguage.g:3218:2: ( rule__AlgorithmInstanceRule__ProblemAssignment_3 )
            // InternalOptimisationLanguage.g:3218:3: rule__AlgorithmInstanceRule__ProblemAssignment_3
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
    // InternalOptimisationLanguage.g:3226:1: rule__AlgorithmInstanceRule__Group__4 : rule__AlgorithmInstanceRule__Group__4__Impl rule__AlgorithmInstanceRule__Group__5 ;
    public final void rule__AlgorithmInstanceRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3230:1: ( rule__AlgorithmInstanceRule__Group__4__Impl rule__AlgorithmInstanceRule__Group__5 )
            // InternalOptimisationLanguage.g:3231:2: rule__AlgorithmInstanceRule__Group__4__Impl rule__AlgorithmInstanceRule__Group__5
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
    // InternalOptimisationLanguage.g:3238:1: rule__AlgorithmInstanceRule__Group__4__Impl : ( '{' ) ;
    public final void rule__AlgorithmInstanceRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3242:1: ( ( '{' ) )
            // InternalOptimisationLanguage.g:3243:1: ( '{' )
            {
            // InternalOptimisationLanguage.g:3243:1: ( '{' )
            // InternalOptimisationLanguage.g:3244:2: '{'
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
    // InternalOptimisationLanguage.g:3253:1: rule__AlgorithmInstanceRule__Group__5 : rule__AlgorithmInstanceRule__Group__5__Impl rule__AlgorithmInstanceRule__Group__6 ;
    public final void rule__AlgorithmInstanceRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3257:1: ( rule__AlgorithmInstanceRule__Group__5__Impl rule__AlgorithmInstanceRule__Group__6 )
            // InternalOptimisationLanguage.g:3258:2: rule__AlgorithmInstanceRule__Group__5__Impl rule__AlgorithmInstanceRule__Group__6
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
    // InternalOptimisationLanguage.g:3265:1: rule__AlgorithmInstanceRule__Group__5__Impl : ( ( rule__AlgorithmInstanceRule__AttributesAssignment_5 )* ) ;
    public final void rule__AlgorithmInstanceRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3269:1: ( ( ( rule__AlgorithmInstanceRule__AttributesAssignment_5 )* ) )
            // InternalOptimisationLanguage.g:3270:1: ( ( rule__AlgorithmInstanceRule__AttributesAssignment_5 )* )
            {
            // InternalOptimisationLanguage.g:3270:1: ( ( rule__AlgorithmInstanceRule__AttributesAssignment_5 )* )
            // InternalOptimisationLanguage.g:3271:2: ( rule__AlgorithmInstanceRule__AttributesAssignment_5 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAlgorithmInstanceRuleAccess().getAttributesAssignment_5()); 
            }
            // InternalOptimisationLanguage.g:3272:2: ( rule__AlgorithmInstanceRule__AttributesAssignment_5 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0>=RULE_QUOTED_ID && LA22_0<=RULE_ID)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:3272:3: rule__AlgorithmInstanceRule__AttributesAssignment_5
            	    {
            	    pushFollow(FOLLOW_22);
            	    rule__AlgorithmInstanceRule__AttributesAssignment_5();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop22;
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
    // InternalOptimisationLanguage.g:3280:1: rule__AlgorithmInstanceRule__Group__6 : rule__AlgorithmInstanceRule__Group__6__Impl rule__AlgorithmInstanceRule__Group__7 ;
    public final void rule__AlgorithmInstanceRule__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3284:1: ( rule__AlgorithmInstanceRule__Group__6__Impl rule__AlgorithmInstanceRule__Group__7 )
            // InternalOptimisationLanguage.g:3285:2: rule__AlgorithmInstanceRule__Group__6__Impl rule__AlgorithmInstanceRule__Group__7
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
    // InternalOptimisationLanguage.g:3292:1: rule__AlgorithmInstanceRule__Group__6__Impl : ( ( rule__AlgorithmInstanceRule__Group_6__0 )? ) ;
    public final void rule__AlgorithmInstanceRule__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3296:1: ( ( ( rule__AlgorithmInstanceRule__Group_6__0 )? ) )
            // InternalOptimisationLanguage.g:3297:1: ( ( rule__AlgorithmInstanceRule__Group_6__0 )? )
            {
            // InternalOptimisationLanguage.g:3297:1: ( ( rule__AlgorithmInstanceRule__Group_6__0 )? )
            // InternalOptimisationLanguage.g:3298:2: ( rule__AlgorithmInstanceRule__Group_6__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAlgorithmInstanceRuleAccess().getGroup_6()); 
            }
            // InternalOptimisationLanguage.g:3299:2: ( rule__AlgorithmInstanceRule__Group_6__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==57) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalOptimisationLanguage.g:3299:3: rule__AlgorithmInstanceRule__Group_6__0
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
    // InternalOptimisationLanguage.g:3307:1: rule__AlgorithmInstanceRule__Group__7 : rule__AlgorithmInstanceRule__Group__7__Impl ;
    public final void rule__AlgorithmInstanceRule__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3311:1: ( rule__AlgorithmInstanceRule__Group__7__Impl )
            // InternalOptimisationLanguage.g:3312:2: rule__AlgorithmInstanceRule__Group__7__Impl
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
    // InternalOptimisationLanguage.g:3318:1: rule__AlgorithmInstanceRule__Group__7__Impl : ( '}' ) ;
    public final void rule__AlgorithmInstanceRule__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3322:1: ( ( '}' ) )
            // InternalOptimisationLanguage.g:3323:1: ( '}' )
            {
            // InternalOptimisationLanguage.g:3323:1: ( '}' )
            // InternalOptimisationLanguage.g:3324:2: '}'
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
    // InternalOptimisationLanguage.g:3334:1: rule__AlgorithmInstanceRule__Group_6__0 : rule__AlgorithmInstanceRule__Group_6__0__Impl rule__AlgorithmInstanceRule__Group_6__1 ;
    public final void rule__AlgorithmInstanceRule__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3338:1: ( rule__AlgorithmInstanceRule__Group_6__0__Impl rule__AlgorithmInstanceRule__Group_6__1 )
            // InternalOptimisationLanguage.g:3339:2: rule__AlgorithmInstanceRule__Group_6__0__Impl rule__AlgorithmInstanceRule__Group_6__1
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
    // InternalOptimisationLanguage.g:3346:1: rule__AlgorithmInstanceRule__Group_6__0__Impl : ( 'document' ) ;
    public final void rule__AlgorithmInstanceRule__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3350:1: ( ( 'document' ) )
            // InternalOptimisationLanguage.g:3351:1: ( 'document' )
            {
            // InternalOptimisationLanguage.g:3351:1: ( 'document' )
            // InternalOptimisationLanguage.g:3352:2: 'document'
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
    // InternalOptimisationLanguage.g:3361:1: rule__AlgorithmInstanceRule__Group_6__1 : rule__AlgorithmInstanceRule__Group_6__1__Impl rule__AlgorithmInstanceRule__Group_6__2 ;
    public final void rule__AlgorithmInstanceRule__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3365:1: ( rule__AlgorithmInstanceRule__Group_6__1__Impl rule__AlgorithmInstanceRule__Group_6__2 )
            // InternalOptimisationLanguage.g:3366:2: rule__AlgorithmInstanceRule__Group_6__1__Impl rule__AlgorithmInstanceRule__Group_6__2
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
    // InternalOptimisationLanguage.g:3373:1: rule__AlgorithmInstanceRule__Group_6__1__Impl : ( ':=' ) ;
    public final void rule__AlgorithmInstanceRule__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3377:1: ( ( ':=' ) )
            // InternalOptimisationLanguage.g:3378:1: ( ':=' )
            {
            // InternalOptimisationLanguage.g:3378:1: ( ':=' )
            // InternalOptimisationLanguage.g:3379:2: ':='
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
    // InternalOptimisationLanguage.g:3388:1: rule__AlgorithmInstanceRule__Group_6__2 : rule__AlgorithmInstanceRule__Group_6__2__Impl rule__AlgorithmInstanceRule__Group_6__3 ;
    public final void rule__AlgorithmInstanceRule__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3392:1: ( rule__AlgorithmInstanceRule__Group_6__2__Impl rule__AlgorithmInstanceRule__Group_6__3 )
            // InternalOptimisationLanguage.g:3393:2: rule__AlgorithmInstanceRule__Group_6__2__Impl rule__AlgorithmInstanceRule__Group_6__3
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
    // InternalOptimisationLanguage.g:3400:1: rule__AlgorithmInstanceRule__Group_6__2__Impl : ( ( rule__AlgorithmInstanceRule__DocumentationAssignment_6_2 ) ) ;
    public final void rule__AlgorithmInstanceRule__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3404:1: ( ( ( rule__AlgorithmInstanceRule__DocumentationAssignment_6_2 ) ) )
            // InternalOptimisationLanguage.g:3405:1: ( ( rule__AlgorithmInstanceRule__DocumentationAssignment_6_2 ) )
            {
            // InternalOptimisationLanguage.g:3405:1: ( ( rule__AlgorithmInstanceRule__DocumentationAssignment_6_2 ) )
            // InternalOptimisationLanguage.g:3406:2: ( rule__AlgorithmInstanceRule__DocumentationAssignment_6_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAlgorithmInstanceRuleAccess().getDocumentationAssignment_6_2()); 
            }
            // InternalOptimisationLanguage.g:3407:2: ( rule__AlgorithmInstanceRule__DocumentationAssignment_6_2 )
            // InternalOptimisationLanguage.g:3407:3: rule__AlgorithmInstanceRule__DocumentationAssignment_6_2
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
    // InternalOptimisationLanguage.g:3415:1: rule__AlgorithmInstanceRule__Group_6__3 : rule__AlgorithmInstanceRule__Group_6__3__Impl ;
    public final void rule__AlgorithmInstanceRule__Group_6__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3419:1: ( rule__AlgorithmInstanceRule__Group_6__3__Impl )
            // InternalOptimisationLanguage.g:3420:2: rule__AlgorithmInstanceRule__Group_6__3__Impl
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
    // InternalOptimisationLanguage.g:3426:1: rule__AlgorithmInstanceRule__Group_6__3__Impl : ( ';' ) ;
    public final void rule__AlgorithmInstanceRule__Group_6__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3430:1: ( ( ';' ) )
            // InternalOptimisationLanguage.g:3431:1: ( ';' )
            {
            // InternalOptimisationLanguage.g:3431:1: ( ';' )
            // InternalOptimisationLanguage.g:3432:2: ';'
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
    // InternalOptimisationLanguage.g:3442:1: rule__OrExpressionRule__Group__0 : rule__OrExpressionRule__Group__0__Impl rule__OrExpressionRule__Group__1 ;
    public final void rule__OrExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3446:1: ( rule__OrExpressionRule__Group__0__Impl rule__OrExpressionRule__Group__1 )
            // InternalOptimisationLanguage.g:3447:2: rule__OrExpressionRule__Group__0__Impl rule__OrExpressionRule__Group__1
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
    // InternalOptimisationLanguage.g:3454:1: rule__OrExpressionRule__Group__0__Impl : ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) ) ;
    public final void rule__OrExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3458:1: ( ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) ) )
            // InternalOptimisationLanguage.g:3459:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) )
            {
            // InternalOptimisationLanguage.g:3459:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) )
            // InternalOptimisationLanguage.g:3460:2: ( rule__OrExpressionRule__SubExpressionsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsAssignment_0()); 
            }
            // InternalOptimisationLanguage.g:3461:2: ( rule__OrExpressionRule__SubExpressionsAssignment_0 )
            // InternalOptimisationLanguage.g:3461:3: rule__OrExpressionRule__SubExpressionsAssignment_0
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
    // InternalOptimisationLanguage.g:3469:1: rule__OrExpressionRule__Group__1 : rule__OrExpressionRule__Group__1__Impl ;
    public final void rule__OrExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3473:1: ( rule__OrExpressionRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:3474:2: rule__OrExpressionRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:3480:1: rule__OrExpressionRule__Group__1__Impl : ( ( rule__OrExpressionRule__Group_1__0 )* ) ;
    public final void rule__OrExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3484:1: ( ( ( rule__OrExpressionRule__Group_1__0 )* ) )
            // InternalOptimisationLanguage.g:3485:1: ( ( rule__OrExpressionRule__Group_1__0 )* )
            {
            // InternalOptimisationLanguage.g:3485:1: ( ( rule__OrExpressionRule__Group_1__0 )* )
            // InternalOptimisationLanguage.g:3486:2: ( rule__OrExpressionRule__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionRuleAccess().getGroup_1()); 
            }
            // InternalOptimisationLanguage.g:3487:2: ( rule__OrExpressionRule__Group_1__0 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==66) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:3487:3: rule__OrExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_26);
            	    rule__OrExpressionRule__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop24;
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
    // InternalOptimisationLanguage.g:3496:1: rule__OrExpressionRule__Group_1__0 : rule__OrExpressionRule__Group_1__0__Impl rule__OrExpressionRule__Group_1__1 ;
    public final void rule__OrExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3500:1: ( rule__OrExpressionRule__Group_1__0__Impl rule__OrExpressionRule__Group_1__1 )
            // InternalOptimisationLanguage.g:3501:2: rule__OrExpressionRule__Group_1__0__Impl rule__OrExpressionRule__Group_1__1
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
    // InternalOptimisationLanguage.g:3508:1: rule__OrExpressionRule__Group_1__0__Impl : ( 'OR' ) ;
    public final void rule__OrExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3512:1: ( ( 'OR' ) )
            // InternalOptimisationLanguage.g:3513:1: ( 'OR' )
            {
            // InternalOptimisationLanguage.g:3513:1: ( 'OR' )
            // InternalOptimisationLanguage.g:3514:2: 'OR'
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
    // InternalOptimisationLanguage.g:3523:1: rule__OrExpressionRule__Group_1__1 : rule__OrExpressionRule__Group_1__1__Impl ;
    public final void rule__OrExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3527:1: ( rule__OrExpressionRule__Group_1__1__Impl )
            // InternalOptimisationLanguage.g:3528:2: rule__OrExpressionRule__Group_1__1__Impl
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
    // InternalOptimisationLanguage.g:3534:1: rule__OrExpressionRule__Group_1__1__Impl : ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) ) ;
    public final void rule__OrExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3538:1: ( ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) ) )
            // InternalOptimisationLanguage.g:3539:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) )
            {
            // InternalOptimisationLanguage.g:3539:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) )
            // InternalOptimisationLanguage.g:3540:2: ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsAssignment_1_1()); 
            }
            // InternalOptimisationLanguage.g:3541:2: ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 )
            // InternalOptimisationLanguage.g:3541:3: rule__OrExpressionRule__SubExpressionsAssignment_1_1
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
    // InternalOptimisationLanguage.g:3550:1: rule__XorExpressionRule__Group__0 : rule__XorExpressionRule__Group__0__Impl rule__XorExpressionRule__Group__1 ;
    public final void rule__XorExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3554:1: ( rule__XorExpressionRule__Group__0__Impl rule__XorExpressionRule__Group__1 )
            // InternalOptimisationLanguage.g:3555:2: rule__XorExpressionRule__Group__0__Impl rule__XorExpressionRule__Group__1
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
    // InternalOptimisationLanguage.g:3562:1: rule__XorExpressionRule__Group__0__Impl : ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) ) ;
    public final void rule__XorExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3566:1: ( ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) ) )
            // InternalOptimisationLanguage.g:3567:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) )
            {
            // InternalOptimisationLanguage.g:3567:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) )
            // InternalOptimisationLanguage.g:3568:2: ( rule__XorExpressionRule__SubExpressionsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAssignment_0()); 
            }
            // InternalOptimisationLanguage.g:3569:2: ( rule__XorExpressionRule__SubExpressionsAssignment_0 )
            // InternalOptimisationLanguage.g:3569:3: rule__XorExpressionRule__SubExpressionsAssignment_0
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
    // InternalOptimisationLanguage.g:3577:1: rule__XorExpressionRule__Group__1 : rule__XorExpressionRule__Group__1__Impl ;
    public final void rule__XorExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3581:1: ( rule__XorExpressionRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:3582:2: rule__XorExpressionRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:3588:1: rule__XorExpressionRule__Group__1__Impl : ( ( rule__XorExpressionRule__Group_1__0 )* ) ;
    public final void rule__XorExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3592:1: ( ( ( rule__XorExpressionRule__Group_1__0 )* ) )
            // InternalOptimisationLanguage.g:3593:1: ( ( rule__XorExpressionRule__Group_1__0 )* )
            {
            // InternalOptimisationLanguage.g:3593:1: ( ( rule__XorExpressionRule__Group_1__0 )* )
            // InternalOptimisationLanguage.g:3594:2: ( rule__XorExpressionRule__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXorExpressionRuleAccess().getGroup_1()); 
            }
            // InternalOptimisationLanguage.g:3595:2: ( rule__XorExpressionRule__Group_1__0 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==67) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:3595:3: rule__XorExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_29);
            	    rule__XorExpressionRule__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop25;
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
    // InternalOptimisationLanguage.g:3604:1: rule__XorExpressionRule__Group_1__0 : rule__XorExpressionRule__Group_1__0__Impl rule__XorExpressionRule__Group_1__1 ;
    public final void rule__XorExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3608:1: ( rule__XorExpressionRule__Group_1__0__Impl rule__XorExpressionRule__Group_1__1 )
            // InternalOptimisationLanguage.g:3609:2: rule__XorExpressionRule__Group_1__0__Impl rule__XorExpressionRule__Group_1__1
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
    // InternalOptimisationLanguage.g:3616:1: rule__XorExpressionRule__Group_1__0__Impl : ( 'XOR' ) ;
    public final void rule__XorExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3620:1: ( ( 'XOR' ) )
            // InternalOptimisationLanguage.g:3621:1: ( 'XOR' )
            {
            // InternalOptimisationLanguage.g:3621:1: ( 'XOR' )
            // InternalOptimisationLanguage.g:3622:2: 'XOR'
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
    // InternalOptimisationLanguage.g:3631:1: rule__XorExpressionRule__Group_1__1 : rule__XorExpressionRule__Group_1__1__Impl ;
    public final void rule__XorExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3635:1: ( rule__XorExpressionRule__Group_1__1__Impl )
            // InternalOptimisationLanguage.g:3636:2: rule__XorExpressionRule__Group_1__1__Impl
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
    // InternalOptimisationLanguage.g:3642:1: rule__XorExpressionRule__Group_1__1__Impl : ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) ) ;
    public final void rule__XorExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3646:1: ( ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) ) )
            // InternalOptimisationLanguage.g:3647:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) )
            {
            // InternalOptimisationLanguage.g:3647:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) )
            // InternalOptimisationLanguage.g:3648:2: ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAssignment_1_1()); 
            }
            // InternalOptimisationLanguage.g:3649:2: ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 )
            // InternalOptimisationLanguage.g:3649:3: rule__XorExpressionRule__SubExpressionsAssignment_1_1
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
    // InternalOptimisationLanguage.g:3658:1: rule__AndExpressionRule__Group__0 : rule__AndExpressionRule__Group__0__Impl rule__AndExpressionRule__Group__1 ;
    public final void rule__AndExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3662:1: ( rule__AndExpressionRule__Group__0__Impl rule__AndExpressionRule__Group__1 )
            // InternalOptimisationLanguage.g:3663:2: rule__AndExpressionRule__Group__0__Impl rule__AndExpressionRule__Group__1
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
    // InternalOptimisationLanguage.g:3670:1: rule__AndExpressionRule__Group__0__Impl : ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) ) ;
    public final void rule__AndExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3674:1: ( ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) ) )
            // InternalOptimisationLanguage.g:3675:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) )
            {
            // InternalOptimisationLanguage.g:3675:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) )
            // InternalOptimisationLanguage.g:3676:2: ( rule__AndExpressionRule__SubExpressionsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsAssignment_0()); 
            }
            // InternalOptimisationLanguage.g:3677:2: ( rule__AndExpressionRule__SubExpressionsAssignment_0 )
            // InternalOptimisationLanguage.g:3677:3: rule__AndExpressionRule__SubExpressionsAssignment_0
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
    // InternalOptimisationLanguage.g:3685:1: rule__AndExpressionRule__Group__1 : rule__AndExpressionRule__Group__1__Impl ;
    public final void rule__AndExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3689:1: ( rule__AndExpressionRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:3690:2: rule__AndExpressionRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:3696:1: rule__AndExpressionRule__Group__1__Impl : ( ( rule__AndExpressionRule__Group_1__0 )* ) ;
    public final void rule__AndExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3700:1: ( ( ( rule__AndExpressionRule__Group_1__0 )* ) )
            // InternalOptimisationLanguage.g:3701:1: ( ( rule__AndExpressionRule__Group_1__0 )* )
            {
            // InternalOptimisationLanguage.g:3701:1: ( ( rule__AndExpressionRule__Group_1__0 )* )
            // InternalOptimisationLanguage.g:3702:2: ( rule__AndExpressionRule__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionRuleAccess().getGroup_1()); 
            }
            // InternalOptimisationLanguage.g:3703:2: ( rule__AndExpressionRule__Group_1__0 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==68) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:3703:3: rule__AndExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_31);
            	    rule__AndExpressionRule__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop26;
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
    // InternalOptimisationLanguage.g:3712:1: rule__AndExpressionRule__Group_1__0 : rule__AndExpressionRule__Group_1__0__Impl rule__AndExpressionRule__Group_1__1 ;
    public final void rule__AndExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3716:1: ( rule__AndExpressionRule__Group_1__0__Impl rule__AndExpressionRule__Group_1__1 )
            // InternalOptimisationLanguage.g:3717:2: rule__AndExpressionRule__Group_1__0__Impl rule__AndExpressionRule__Group_1__1
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
    // InternalOptimisationLanguage.g:3724:1: rule__AndExpressionRule__Group_1__0__Impl : ( 'AND' ) ;
    public final void rule__AndExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3728:1: ( ( 'AND' ) )
            // InternalOptimisationLanguage.g:3729:1: ( 'AND' )
            {
            // InternalOptimisationLanguage.g:3729:1: ( 'AND' )
            // InternalOptimisationLanguage.g:3730:2: 'AND'
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
    // InternalOptimisationLanguage.g:3739:1: rule__AndExpressionRule__Group_1__1 : rule__AndExpressionRule__Group_1__1__Impl ;
    public final void rule__AndExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3743:1: ( rule__AndExpressionRule__Group_1__1__Impl )
            // InternalOptimisationLanguage.g:3744:2: rule__AndExpressionRule__Group_1__1__Impl
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
    // InternalOptimisationLanguage.g:3750:1: rule__AndExpressionRule__Group_1__1__Impl : ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) ) ;
    public final void rule__AndExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3754:1: ( ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) ) )
            // InternalOptimisationLanguage.g:3755:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) )
            {
            // InternalOptimisationLanguage.g:3755:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) )
            // InternalOptimisationLanguage.g:3756:2: ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsAssignment_1_1()); 
            }
            // InternalOptimisationLanguage.g:3757:2: ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 )
            // InternalOptimisationLanguage.g:3757:3: rule__AndExpressionRule__SubExpressionsAssignment_1_1
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
    // InternalOptimisationLanguage.g:3766:1: rule__NotExpressionRule__Group__0 : rule__NotExpressionRule__Group__0__Impl rule__NotExpressionRule__Group__1 ;
    public final void rule__NotExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3770:1: ( rule__NotExpressionRule__Group__0__Impl rule__NotExpressionRule__Group__1 )
            // InternalOptimisationLanguage.g:3771:2: rule__NotExpressionRule__Group__0__Impl rule__NotExpressionRule__Group__1
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
    // InternalOptimisationLanguage.g:3778:1: rule__NotExpressionRule__Group__0__Impl : ( ( rule__NotExpressionRule__NegatedAssignment_0 )? ) ;
    public final void rule__NotExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3782:1: ( ( ( rule__NotExpressionRule__NegatedAssignment_0 )? ) )
            // InternalOptimisationLanguage.g:3783:1: ( ( rule__NotExpressionRule__NegatedAssignment_0 )? )
            {
            // InternalOptimisationLanguage.g:3783:1: ( ( rule__NotExpressionRule__NegatedAssignment_0 )? )
            // InternalOptimisationLanguage.g:3784:2: ( rule__NotExpressionRule__NegatedAssignment_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNotExpressionRuleAccess().getNegatedAssignment_0()); 
            }
            // InternalOptimisationLanguage.g:3785:2: ( rule__NotExpressionRule__NegatedAssignment_0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==92) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalOptimisationLanguage.g:3785:3: rule__NotExpressionRule__NegatedAssignment_0
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
    // InternalOptimisationLanguage.g:3793:1: rule__NotExpressionRule__Group__1 : rule__NotExpressionRule__Group__1__Impl ;
    public final void rule__NotExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3797:1: ( rule__NotExpressionRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:3798:2: rule__NotExpressionRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:3804:1: rule__NotExpressionRule__Group__1__Impl : ( ( rule__NotExpressionRule__OperandAssignment_1 ) ) ;
    public final void rule__NotExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3808:1: ( ( ( rule__NotExpressionRule__OperandAssignment_1 ) ) )
            // InternalOptimisationLanguage.g:3809:1: ( ( rule__NotExpressionRule__OperandAssignment_1 ) )
            {
            // InternalOptimisationLanguage.g:3809:1: ( ( rule__NotExpressionRule__OperandAssignment_1 ) )
            // InternalOptimisationLanguage.g:3810:2: ( rule__NotExpressionRule__OperandAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNotExpressionRuleAccess().getOperandAssignment_1()); 
            }
            // InternalOptimisationLanguage.g:3811:2: ( rule__NotExpressionRule__OperandAssignment_1 )
            // InternalOptimisationLanguage.g:3811:3: rule__NotExpressionRule__OperandAssignment_1
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
    // InternalOptimisationLanguage.g:3820:1: rule__ComparisonExpressionRule__Group__0 : rule__ComparisonExpressionRule__Group__0__Impl rule__ComparisonExpressionRule__Group__1 ;
    public final void rule__ComparisonExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3824:1: ( rule__ComparisonExpressionRule__Group__0__Impl rule__ComparisonExpressionRule__Group__1 )
            // InternalOptimisationLanguage.g:3825:2: rule__ComparisonExpressionRule__Group__0__Impl rule__ComparisonExpressionRule__Group__1
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
    // InternalOptimisationLanguage.g:3832:1: rule__ComparisonExpressionRule__Group__0__Impl : ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__ComparisonExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3836:1: ( ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalOptimisationLanguage.g:3837:1: ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalOptimisationLanguage.g:3837:1: ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) )
            // InternalOptimisationLanguage.g:3838:2: ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonExpressionRuleAccess().getLeftOperandAssignment_0()); 
            }
            // InternalOptimisationLanguage.g:3839:2: ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 )
            // InternalOptimisationLanguage.g:3839:3: rule__ComparisonExpressionRule__LeftOperandAssignment_0
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
    // InternalOptimisationLanguage.g:3847:1: rule__ComparisonExpressionRule__Group__1 : rule__ComparisonExpressionRule__Group__1__Impl ;
    public final void rule__ComparisonExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3851:1: ( rule__ComparisonExpressionRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:3852:2: rule__ComparisonExpressionRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:3858:1: rule__ComparisonExpressionRule__Group__1__Impl : ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* ) ;
    public final void rule__ComparisonExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3862:1: ( ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* ) )
            // InternalOptimisationLanguage.g:3863:1: ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* )
            {
            // InternalOptimisationLanguage.g:3863:1: ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* )
            // InternalOptimisationLanguage.g:3864:2: ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonExpressionRuleAccess().getComparisonAssignment_1()); 
            }
            // InternalOptimisationLanguage.g:3865:2: ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( ((LA28_0>=16 && LA28_0<=21)) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:3865:3: rule__ComparisonExpressionRule__ComparisonAssignment_1
            	    {
            	    pushFollow(FOLLOW_33);
            	    rule__ComparisonExpressionRule__ComparisonAssignment_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop28;
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
    // InternalOptimisationLanguage.g:3874:1: rule__PartialComparisonExpressionRule__Group__0 : rule__PartialComparisonExpressionRule__Group__0__Impl rule__PartialComparisonExpressionRule__Group__1 ;
    public final void rule__PartialComparisonExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3878:1: ( rule__PartialComparisonExpressionRule__Group__0__Impl rule__PartialComparisonExpressionRule__Group__1 )
            // InternalOptimisationLanguage.g:3879:2: rule__PartialComparisonExpressionRule__Group__0__Impl rule__PartialComparisonExpressionRule__Group__1
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
    // InternalOptimisationLanguage.g:3886:1: rule__PartialComparisonExpressionRule__Group__0__Impl : ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) ) ;
    public final void rule__PartialComparisonExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3890:1: ( ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) ) )
            // InternalOptimisationLanguage.g:3891:1: ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) )
            {
            // InternalOptimisationLanguage.g:3891:1: ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) )
            // InternalOptimisationLanguage.g:3892:2: ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartialComparisonExpressionRuleAccess().getOperatorAssignment_0()); 
            }
            // InternalOptimisationLanguage.g:3893:2: ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 )
            // InternalOptimisationLanguage.g:3893:3: rule__PartialComparisonExpressionRule__OperatorAssignment_0
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
    // InternalOptimisationLanguage.g:3901:1: rule__PartialComparisonExpressionRule__Group__1 : rule__PartialComparisonExpressionRule__Group__1__Impl ;
    public final void rule__PartialComparisonExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3905:1: ( rule__PartialComparisonExpressionRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:3906:2: rule__PartialComparisonExpressionRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:3912:1: rule__PartialComparisonExpressionRule__Group__1__Impl : ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) ) ;
    public final void rule__PartialComparisonExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3916:1: ( ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) ) )
            // InternalOptimisationLanguage.g:3917:1: ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) )
            {
            // InternalOptimisationLanguage.g:3917:1: ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) )
            // InternalOptimisationLanguage.g:3918:2: ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartialComparisonExpressionRuleAccess().getSubExpressionAssignment_1()); 
            }
            // InternalOptimisationLanguage.g:3919:2: ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 )
            // InternalOptimisationLanguage.g:3919:3: rule__PartialComparisonExpressionRule__SubExpressionAssignment_1
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
    // InternalOptimisationLanguage.g:3928:1: rule__AddOrSubtractExpressionRule__Group__0 : rule__AddOrSubtractExpressionRule__Group__0__Impl rule__AddOrSubtractExpressionRule__Group__1 ;
    public final void rule__AddOrSubtractExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3932:1: ( rule__AddOrSubtractExpressionRule__Group__0__Impl rule__AddOrSubtractExpressionRule__Group__1 )
            // InternalOptimisationLanguage.g:3933:2: rule__AddOrSubtractExpressionRule__Group__0__Impl rule__AddOrSubtractExpressionRule__Group__1
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
    // InternalOptimisationLanguage.g:3940:1: rule__AddOrSubtractExpressionRule__Group__0__Impl : ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__AddOrSubtractExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3944:1: ( ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalOptimisationLanguage.g:3945:1: ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalOptimisationLanguage.g:3945:1: ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) )
            // InternalOptimisationLanguage.g:3946:2: ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getLeftOperandAssignment_0()); 
            }
            // InternalOptimisationLanguage.g:3947:2: ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 )
            // InternalOptimisationLanguage.g:3947:3: rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0
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
    // InternalOptimisationLanguage.g:3955:1: rule__AddOrSubtractExpressionRule__Group__1 : rule__AddOrSubtractExpressionRule__Group__1__Impl ;
    public final void rule__AddOrSubtractExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3959:1: ( rule__AddOrSubtractExpressionRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:3960:2: rule__AddOrSubtractExpressionRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:3966:1: rule__AddOrSubtractExpressionRule__Group__1__Impl : ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* ) ;
    public final void rule__AddOrSubtractExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3970:1: ( ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* ) )
            // InternalOptimisationLanguage.g:3971:1: ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* )
            {
            // InternalOptimisationLanguage.g:3971:1: ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* )
            // InternalOptimisationLanguage.g:3972:2: ( rule__AddOrSubtractExpressionRule__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getGroup_1()); 
            }
            // InternalOptimisationLanguage.g:3973:2: ( rule__AddOrSubtractExpressionRule__Group_1__0 )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( ((LA29_0>=22 && LA29_0<=23)) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:3973:3: rule__AddOrSubtractExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_35);
            	    rule__AddOrSubtractExpressionRule__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop29;
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
    // InternalOptimisationLanguage.g:3982:1: rule__AddOrSubtractExpressionRule__Group_1__0 : rule__AddOrSubtractExpressionRule__Group_1__0__Impl rule__AddOrSubtractExpressionRule__Group_1__1 ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3986:1: ( rule__AddOrSubtractExpressionRule__Group_1__0__Impl rule__AddOrSubtractExpressionRule__Group_1__1 )
            // InternalOptimisationLanguage.g:3987:2: rule__AddOrSubtractExpressionRule__Group_1__0__Impl rule__AddOrSubtractExpressionRule__Group_1__1
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
    // InternalOptimisationLanguage.g:3994:1: rule__AddOrSubtractExpressionRule__Group_1__0__Impl : ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) ) ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3998:1: ( ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) ) )
            // InternalOptimisationLanguage.g:3999:1: ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) )
            {
            // InternalOptimisationLanguage.g:3999:1: ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) )
            // InternalOptimisationLanguage.g:4000:2: ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperatorsAssignment_1_0()); 
            }
            // InternalOptimisationLanguage.g:4001:2: ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 )
            // InternalOptimisationLanguage.g:4001:3: rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0
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
    // InternalOptimisationLanguage.g:4009:1: rule__AddOrSubtractExpressionRule__Group_1__1 : rule__AddOrSubtractExpressionRule__Group_1__1__Impl ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4013:1: ( rule__AddOrSubtractExpressionRule__Group_1__1__Impl )
            // InternalOptimisationLanguage.g:4014:2: rule__AddOrSubtractExpressionRule__Group_1__1__Impl
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
    // InternalOptimisationLanguage.g:4020:1: rule__AddOrSubtractExpressionRule__Group_1__1__Impl : ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) ) ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4024:1: ( ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) ) )
            // InternalOptimisationLanguage.g:4025:1: ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) )
            {
            // InternalOptimisationLanguage.g:4025:1: ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) )
            // InternalOptimisationLanguage.g:4026:2: ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperandsAssignment_1_1()); 
            }
            // InternalOptimisationLanguage.g:4027:2: ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 )
            // InternalOptimisationLanguage.g:4027:3: rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1
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
    // InternalOptimisationLanguage.g:4036:1: rule__MultiplyDivideModuloExpressionRule__Group__0 : rule__MultiplyDivideModuloExpressionRule__Group__0__Impl rule__MultiplyDivideModuloExpressionRule__Group__1 ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4040:1: ( rule__MultiplyDivideModuloExpressionRule__Group__0__Impl rule__MultiplyDivideModuloExpressionRule__Group__1 )
            // InternalOptimisationLanguage.g:4041:2: rule__MultiplyDivideModuloExpressionRule__Group__0__Impl rule__MultiplyDivideModuloExpressionRule__Group__1
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
    // InternalOptimisationLanguage.g:4048:1: rule__MultiplyDivideModuloExpressionRule__Group__0__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4052:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalOptimisationLanguage.g:4053:1: ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalOptimisationLanguage.g:4053:1: ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) )
            // InternalOptimisationLanguage.g:4054:2: ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getLeftOperandAssignment_0()); 
            }
            // InternalOptimisationLanguage.g:4055:2: ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 )
            // InternalOptimisationLanguage.g:4055:3: rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0
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
    // InternalOptimisationLanguage.g:4063:1: rule__MultiplyDivideModuloExpressionRule__Group__1 : rule__MultiplyDivideModuloExpressionRule__Group__1__Impl ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4067:1: ( rule__MultiplyDivideModuloExpressionRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:4068:2: rule__MultiplyDivideModuloExpressionRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:4074:1: rule__MultiplyDivideModuloExpressionRule__Group__1__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4078:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* ) )
            // InternalOptimisationLanguage.g:4079:1: ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* )
            {
            // InternalOptimisationLanguage.g:4079:1: ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* )
            // InternalOptimisationLanguage.g:4080:2: ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getGroup_1()); 
            }
            // InternalOptimisationLanguage.g:4081:2: ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( ((LA30_0>=24 && LA30_0<=26)) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:4081:3: rule__MultiplyDivideModuloExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_37);
            	    rule__MultiplyDivideModuloExpressionRule__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop30;
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
    // InternalOptimisationLanguage.g:4090:1: rule__MultiplyDivideModuloExpressionRule__Group_1__0 : rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl rule__MultiplyDivideModuloExpressionRule__Group_1__1 ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4094:1: ( rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl rule__MultiplyDivideModuloExpressionRule__Group_1__1 )
            // InternalOptimisationLanguage.g:4095:2: rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl rule__MultiplyDivideModuloExpressionRule__Group_1__1
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
    // InternalOptimisationLanguage.g:4102:1: rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4106:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) ) )
            // InternalOptimisationLanguage.g:4107:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) )
            {
            // InternalOptimisationLanguage.g:4107:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) )
            // InternalOptimisationLanguage.g:4108:2: ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperatorsAssignment_1_0()); 
            }
            // InternalOptimisationLanguage.g:4109:2: ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 )
            // InternalOptimisationLanguage.g:4109:3: rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0
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
    // InternalOptimisationLanguage.g:4117:1: rule__MultiplyDivideModuloExpressionRule__Group_1__1 : rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4121:1: ( rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl )
            // InternalOptimisationLanguage.g:4122:2: rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl
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
    // InternalOptimisationLanguage.g:4128:1: rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4132:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) ) )
            // InternalOptimisationLanguage.g:4133:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) )
            {
            // InternalOptimisationLanguage.g:4133:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) )
            // InternalOptimisationLanguage.g:4134:2: ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperandsAssignment_1_1()); 
            }
            // InternalOptimisationLanguage.g:4135:2: ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 )
            // InternalOptimisationLanguage.g:4135:3: rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1
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
    // InternalOptimisationLanguage.g:4144:1: rule__PowerOfExpressionRule__Group__0 : rule__PowerOfExpressionRule__Group__0__Impl rule__PowerOfExpressionRule__Group__1 ;
    public final void rule__PowerOfExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4148:1: ( rule__PowerOfExpressionRule__Group__0__Impl rule__PowerOfExpressionRule__Group__1 )
            // InternalOptimisationLanguage.g:4149:2: rule__PowerOfExpressionRule__Group__0__Impl rule__PowerOfExpressionRule__Group__1
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
    // InternalOptimisationLanguage.g:4156:1: rule__PowerOfExpressionRule__Group__0__Impl : ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__PowerOfExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4160:1: ( ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalOptimisationLanguage.g:4161:1: ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalOptimisationLanguage.g:4161:1: ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) )
            // InternalOptimisationLanguage.g:4162:2: ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPowerOfExpressionRuleAccess().getLeftOperandAssignment_0()); 
            }
            // InternalOptimisationLanguage.g:4163:2: ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 )
            // InternalOptimisationLanguage.g:4163:3: rule__PowerOfExpressionRule__LeftOperandAssignment_0
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
    // InternalOptimisationLanguage.g:4171:1: rule__PowerOfExpressionRule__Group__1 : rule__PowerOfExpressionRule__Group__1__Impl ;
    public final void rule__PowerOfExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4175:1: ( rule__PowerOfExpressionRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:4176:2: rule__PowerOfExpressionRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:4182:1: rule__PowerOfExpressionRule__Group__1__Impl : ( ( rule__PowerOfExpressionRule__Group_1__0 )? ) ;
    public final void rule__PowerOfExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4186:1: ( ( ( rule__PowerOfExpressionRule__Group_1__0 )? ) )
            // InternalOptimisationLanguage.g:4187:1: ( ( rule__PowerOfExpressionRule__Group_1__0 )? )
            {
            // InternalOptimisationLanguage.g:4187:1: ( ( rule__PowerOfExpressionRule__Group_1__0 )? )
            // InternalOptimisationLanguage.g:4188:2: ( rule__PowerOfExpressionRule__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPowerOfExpressionRuleAccess().getGroup_1()); 
            }
            // InternalOptimisationLanguage.g:4189:2: ( rule__PowerOfExpressionRule__Group_1__0 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==69) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalOptimisationLanguage.g:4189:3: rule__PowerOfExpressionRule__Group_1__0
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
    // InternalOptimisationLanguage.g:4198:1: rule__PowerOfExpressionRule__Group_1__0 : rule__PowerOfExpressionRule__Group_1__0__Impl rule__PowerOfExpressionRule__Group_1__1 ;
    public final void rule__PowerOfExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4202:1: ( rule__PowerOfExpressionRule__Group_1__0__Impl rule__PowerOfExpressionRule__Group_1__1 )
            // InternalOptimisationLanguage.g:4203:2: rule__PowerOfExpressionRule__Group_1__0__Impl rule__PowerOfExpressionRule__Group_1__1
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
    // InternalOptimisationLanguage.g:4210:1: rule__PowerOfExpressionRule__Group_1__0__Impl : ( '^' ) ;
    public final void rule__PowerOfExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4214:1: ( ( '^' ) )
            // InternalOptimisationLanguage.g:4215:1: ( '^' )
            {
            // InternalOptimisationLanguage.g:4215:1: ( '^' )
            // InternalOptimisationLanguage.g:4216:2: '^'
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
    // InternalOptimisationLanguage.g:4225:1: rule__PowerOfExpressionRule__Group_1__1 : rule__PowerOfExpressionRule__Group_1__1__Impl ;
    public final void rule__PowerOfExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4229:1: ( rule__PowerOfExpressionRule__Group_1__1__Impl )
            // InternalOptimisationLanguage.g:4230:2: rule__PowerOfExpressionRule__Group_1__1__Impl
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
    // InternalOptimisationLanguage.g:4236:1: rule__PowerOfExpressionRule__Group_1__1__Impl : ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) ) ;
    public final void rule__PowerOfExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4240:1: ( ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) ) )
            // InternalOptimisationLanguage.g:4241:1: ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) )
            {
            // InternalOptimisationLanguage.g:4241:1: ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) )
            // InternalOptimisationLanguage.g:4242:2: ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPowerOfExpressionRuleAccess().getRightOperandAssignment_1_1()); 
            }
            // InternalOptimisationLanguage.g:4243:2: ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 )
            // InternalOptimisationLanguage.g:4243:3: rule__PowerOfExpressionRule__RightOperandAssignment_1_1
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
    // InternalOptimisationLanguage.g:4252:1: rule__UnaryAddOrSubtractExpressionRule__Group__0 : rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl rule__UnaryAddOrSubtractExpressionRule__Group__1 ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4256:1: ( rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl rule__UnaryAddOrSubtractExpressionRule__Group__1 )
            // InternalOptimisationLanguage.g:4257:2: rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl rule__UnaryAddOrSubtractExpressionRule__Group__1
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
    // InternalOptimisationLanguage.g:4264:1: rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl : ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4268:1: ( ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* ) )
            // InternalOptimisationLanguage.g:4269:1: ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* )
            {
            // InternalOptimisationLanguage.g:4269:1: ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* )
            // InternalOptimisationLanguage.g:4270:2: ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getOperatorsAssignment_0()); 
            }
            // InternalOptimisationLanguage.g:4271:2: ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( ((LA32_0>=22 && LA32_0<=23)) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:4271:3: rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0
            	    {
            	    pushFollow(FOLLOW_35);
            	    rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop32;
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
    // InternalOptimisationLanguage.g:4279:1: rule__UnaryAddOrSubtractExpressionRule__Group__1 : rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4283:1: ( rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:4284:2: rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:4290:1: rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl : ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4294:1: ( ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) ) )
            // InternalOptimisationLanguage.g:4295:1: ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) )
            {
            // InternalOptimisationLanguage.g:4295:1: ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) )
            // InternalOptimisationLanguage.g:4296:2: ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getSubExpressionAssignment_1()); 
            }
            // InternalOptimisationLanguage.g:4297:2: ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 )
            // InternalOptimisationLanguage.g:4297:3: rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1
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
    // InternalOptimisationLanguage.g:4306:1: rule__ArrayRule__Group__0 : rule__ArrayRule__Group__0__Impl rule__ArrayRule__Group__1 ;
    public final void rule__ArrayRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4310:1: ( rule__ArrayRule__Group__0__Impl rule__ArrayRule__Group__1 )
            // InternalOptimisationLanguage.g:4311:2: rule__ArrayRule__Group__0__Impl rule__ArrayRule__Group__1
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
    // InternalOptimisationLanguage.g:4318:1: rule__ArrayRule__Group__0__Impl : ( () ) ;
    public final void rule__ArrayRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4322:1: ( ( () ) )
            // InternalOptimisationLanguage.g:4323:1: ( () )
            {
            // InternalOptimisationLanguage.g:4323:1: ( () )
            // InternalOptimisationLanguage.g:4324:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayRuleAccess().getArrayAction_0()); 
            }
            // InternalOptimisationLanguage.g:4325:2: ()
            // InternalOptimisationLanguage.g:4325:3: 
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
    // InternalOptimisationLanguage.g:4333:1: rule__ArrayRule__Group__1 : rule__ArrayRule__Group__1__Impl rule__ArrayRule__Group__2 ;
    public final void rule__ArrayRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4337:1: ( rule__ArrayRule__Group__1__Impl rule__ArrayRule__Group__2 )
            // InternalOptimisationLanguage.g:4338:2: rule__ArrayRule__Group__1__Impl rule__ArrayRule__Group__2
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
    // InternalOptimisationLanguage.g:4345:1: rule__ArrayRule__Group__1__Impl : ( '[' ) ;
    public final void rule__ArrayRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4349:1: ( ( '[' ) )
            // InternalOptimisationLanguage.g:4350:1: ( '[' )
            {
            // InternalOptimisationLanguage.g:4350:1: ( '[' )
            // InternalOptimisationLanguage.g:4351:2: '['
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
    // InternalOptimisationLanguage.g:4360:1: rule__ArrayRule__Group__2 : rule__ArrayRule__Group__2__Impl rule__ArrayRule__Group__3 ;
    public final void rule__ArrayRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4364:1: ( rule__ArrayRule__Group__2__Impl rule__ArrayRule__Group__3 )
            // InternalOptimisationLanguage.g:4365:2: rule__ArrayRule__Group__2__Impl rule__ArrayRule__Group__3
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
    // InternalOptimisationLanguage.g:4372:1: rule__ArrayRule__Group__2__Impl : ( ( rule__ArrayRule__Group_2__0 )? ) ;
    public final void rule__ArrayRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4376:1: ( ( ( rule__ArrayRule__Group_2__0 )? ) )
            // InternalOptimisationLanguage.g:4377:1: ( ( rule__ArrayRule__Group_2__0 )? )
            {
            // InternalOptimisationLanguage.g:4377:1: ( ( rule__ArrayRule__Group_2__0 )? )
            // InternalOptimisationLanguage.g:4378:2: ( rule__ArrayRule__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayRuleAccess().getGroup_2()); 
            }
            // InternalOptimisationLanguage.g:4379:2: ( rule__ArrayRule__Group_2__0 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( ((LA33_0>=RULE_QUOTED_ID && LA33_0<=RULE_STRING)||LA33_0==15||LA33_0==70||LA33_0==72||(LA33_0>=74 && LA33_0<=78)||LA33_0==93) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalOptimisationLanguage.g:4379:3: rule__ArrayRule__Group_2__0
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
    // InternalOptimisationLanguage.g:4387:1: rule__ArrayRule__Group__3 : rule__ArrayRule__Group__3__Impl ;
    public final void rule__ArrayRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4391:1: ( rule__ArrayRule__Group__3__Impl )
            // InternalOptimisationLanguage.g:4392:2: rule__ArrayRule__Group__3__Impl
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
    // InternalOptimisationLanguage.g:4398:1: rule__ArrayRule__Group__3__Impl : ( ']' ) ;
    public final void rule__ArrayRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4402:1: ( ( ']' ) )
            // InternalOptimisationLanguage.g:4403:1: ( ']' )
            {
            // InternalOptimisationLanguage.g:4403:1: ( ']' )
            // InternalOptimisationLanguage.g:4404:2: ']'
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
    // InternalOptimisationLanguage.g:4414:1: rule__ArrayRule__Group_2__0 : rule__ArrayRule__Group_2__0__Impl rule__ArrayRule__Group_2__1 ;
    public final void rule__ArrayRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4418:1: ( rule__ArrayRule__Group_2__0__Impl rule__ArrayRule__Group_2__1 )
            // InternalOptimisationLanguage.g:4419:2: rule__ArrayRule__Group_2__0__Impl rule__ArrayRule__Group_2__1
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
    // InternalOptimisationLanguage.g:4426:1: rule__ArrayRule__Group_2__0__Impl : ( ( rule__ArrayRule__ValuesAssignment_2_0 ) ) ;
    public final void rule__ArrayRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4430:1: ( ( ( rule__ArrayRule__ValuesAssignment_2_0 ) ) )
            // InternalOptimisationLanguage.g:4431:1: ( ( rule__ArrayRule__ValuesAssignment_2_0 ) )
            {
            // InternalOptimisationLanguage.g:4431:1: ( ( rule__ArrayRule__ValuesAssignment_2_0 ) )
            // InternalOptimisationLanguage.g:4432:2: ( rule__ArrayRule__ValuesAssignment_2_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayRuleAccess().getValuesAssignment_2_0()); 
            }
            // InternalOptimisationLanguage.g:4433:2: ( rule__ArrayRule__ValuesAssignment_2_0 )
            // InternalOptimisationLanguage.g:4433:3: rule__ArrayRule__ValuesAssignment_2_0
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
    // InternalOptimisationLanguage.g:4441:1: rule__ArrayRule__Group_2__1 : rule__ArrayRule__Group_2__1__Impl ;
    public final void rule__ArrayRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4445:1: ( rule__ArrayRule__Group_2__1__Impl )
            // InternalOptimisationLanguage.g:4446:2: rule__ArrayRule__Group_2__1__Impl
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
    // InternalOptimisationLanguage.g:4452:1: rule__ArrayRule__Group_2__1__Impl : ( ( rule__ArrayRule__Group_2_1__0 )* ) ;
    public final void rule__ArrayRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4456:1: ( ( ( rule__ArrayRule__Group_2_1__0 )* ) )
            // InternalOptimisationLanguage.g:4457:1: ( ( rule__ArrayRule__Group_2_1__0 )* )
            {
            // InternalOptimisationLanguage.g:4457:1: ( ( rule__ArrayRule__Group_2_1__0 )* )
            // InternalOptimisationLanguage.g:4458:2: ( rule__ArrayRule__Group_2_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayRuleAccess().getGroup_2_1()); 
            }
            // InternalOptimisationLanguage.g:4459:2: ( rule__ArrayRule__Group_2_1__0 )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==56) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:4459:3: rule__ArrayRule__Group_2_1__0
            	    {
            	    pushFollow(FOLLOW_12);
            	    rule__ArrayRule__Group_2_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop34;
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
    // InternalOptimisationLanguage.g:4468:1: rule__ArrayRule__Group_2_1__0 : rule__ArrayRule__Group_2_1__0__Impl rule__ArrayRule__Group_2_1__1 ;
    public final void rule__ArrayRule__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4472:1: ( rule__ArrayRule__Group_2_1__0__Impl rule__ArrayRule__Group_2_1__1 )
            // InternalOptimisationLanguage.g:4473:2: rule__ArrayRule__Group_2_1__0__Impl rule__ArrayRule__Group_2_1__1
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
    // InternalOptimisationLanguage.g:4480:1: rule__ArrayRule__Group_2_1__0__Impl : ( ',' ) ;
    public final void rule__ArrayRule__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4484:1: ( ( ',' ) )
            // InternalOptimisationLanguage.g:4485:1: ( ',' )
            {
            // InternalOptimisationLanguage.g:4485:1: ( ',' )
            // InternalOptimisationLanguage.g:4486:2: ','
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
    // InternalOptimisationLanguage.g:4495:1: rule__ArrayRule__Group_2_1__1 : rule__ArrayRule__Group_2_1__1__Impl ;
    public final void rule__ArrayRule__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4499:1: ( rule__ArrayRule__Group_2_1__1__Impl )
            // InternalOptimisationLanguage.g:4500:2: rule__ArrayRule__Group_2_1__1__Impl
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
    // InternalOptimisationLanguage.g:4506:1: rule__ArrayRule__Group_2_1__1__Impl : ( ( rule__ArrayRule__ValuesAssignment_2_1_1 ) ) ;
    public final void rule__ArrayRule__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4510:1: ( ( ( rule__ArrayRule__ValuesAssignment_2_1_1 ) ) )
            // InternalOptimisationLanguage.g:4511:1: ( ( rule__ArrayRule__ValuesAssignment_2_1_1 ) )
            {
            // InternalOptimisationLanguage.g:4511:1: ( ( rule__ArrayRule__ValuesAssignment_2_1_1 ) )
            // InternalOptimisationLanguage.g:4512:2: ( rule__ArrayRule__ValuesAssignment_2_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayRuleAccess().getValuesAssignment_2_1_1()); 
            }
            // InternalOptimisationLanguage.g:4513:2: ( rule__ArrayRule__ValuesAssignment_2_1_1 )
            // InternalOptimisationLanguage.g:4513:3: rule__ArrayRule__ValuesAssignment_2_1_1
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
    // InternalOptimisationLanguage.g:4522:1: rule__ParanthesesRule__Group__0 : rule__ParanthesesRule__Group__0__Impl rule__ParanthesesRule__Group__1 ;
    public final void rule__ParanthesesRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4526:1: ( rule__ParanthesesRule__Group__0__Impl rule__ParanthesesRule__Group__1 )
            // InternalOptimisationLanguage.g:4527:2: rule__ParanthesesRule__Group__0__Impl rule__ParanthesesRule__Group__1
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
    // InternalOptimisationLanguage.g:4534:1: rule__ParanthesesRule__Group__0__Impl : ( '(' ) ;
    public final void rule__ParanthesesRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4538:1: ( ( '(' ) )
            // InternalOptimisationLanguage.g:4539:1: ( '(' )
            {
            // InternalOptimisationLanguage.g:4539:1: ( '(' )
            // InternalOptimisationLanguage.g:4540:2: '('
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
    // InternalOptimisationLanguage.g:4549:1: rule__ParanthesesRule__Group__1 : rule__ParanthesesRule__Group__1__Impl rule__ParanthesesRule__Group__2 ;
    public final void rule__ParanthesesRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4553:1: ( rule__ParanthesesRule__Group__1__Impl rule__ParanthesesRule__Group__2 )
            // InternalOptimisationLanguage.g:4554:2: rule__ParanthesesRule__Group__1__Impl rule__ParanthesesRule__Group__2
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
    // InternalOptimisationLanguage.g:4561:1: rule__ParanthesesRule__Group__1__Impl : ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) ) ;
    public final void rule__ParanthesesRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4565:1: ( ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) ) )
            // InternalOptimisationLanguage.g:4566:1: ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) )
            {
            // InternalOptimisationLanguage.g:4566:1: ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) )
            // InternalOptimisationLanguage.g:4567:2: ( rule__ParanthesesRule__SubExpressionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParanthesesRuleAccess().getSubExpressionAssignment_1()); 
            }
            // InternalOptimisationLanguage.g:4568:2: ( rule__ParanthesesRule__SubExpressionAssignment_1 )
            // InternalOptimisationLanguage.g:4568:3: rule__ParanthesesRule__SubExpressionAssignment_1
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
    // InternalOptimisationLanguage.g:4576:1: rule__ParanthesesRule__Group__2 : rule__ParanthesesRule__Group__2__Impl ;
    public final void rule__ParanthesesRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4580:1: ( rule__ParanthesesRule__Group__2__Impl )
            // InternalOptimisationLanguage.g:4581:2: rule__ParanthesesRule__Group__2__Impl
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
    // InternalOptimisationLanguage.g:4587:1: rule__ParanthesesRule__Group__2__Impl : ( ')' ) ;
    public final void rule__ParanthesesRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4591:1: ( ( ')' ) )
            // InternalOptimisationLanguage.g:4592:1: ( ')' )
            {
            // InternalOptimisationLanguage.g:4592:1: ( ')' )
            // InternalOptimisationLanguage.g:4593:2: ')'
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
    // InternalOptimisationLanguage.g:4603:1: rule__CallRule__Group__0 : rule__CallRule__Group__0__Impl rule__CallRule__Group__1 ;
    public final void rule__CallRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4607:1: ( rule__CallRule__Group__0__Impl rule__CallRule__Group__1 )
            // InternalOptimisationLanguage.g:4608:2: rule__CallRule__Group__0__Impl rule__CallRule__Group__1
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
    // InternalOptimisationLanguage.g:4615:1: rule__CallRule__Group__0__Impl : ( ( rule__CallRule__FunctionAssignment_0 ) ) ;
    public final void rule__CallRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4619:1: ( ( ( rule__CallRule__FunctionAssignment_0 ) ) )
            // InternalOptimisationLanguage.g:4620:1: ( ( rule__CallRule__FunctionAssignment_0 ) )
            {
            // InternalOptimisationLanguage.g:4620:1: ( ( rule__CallRule__FunctionAssignment_0 ) )
            // InternalOptimisationLanguage.g:4621:2: ( rule__CallRule__FunctionAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getFunctionAssignment_0()); 
            }
            // InternalOptimisationLanguage.g:4622:2: ( rule__CallRule__FunctionAssignment_0 )
            // InternalOptimisationLanguage.g:4622:3: rule__CallRule__FunctionAssignment_0
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
    // InternalOptimisationLanguage.g:4630:1: rule__CallRule__Group__1 : rule__CallRule__Group__1__Impl rule__CallRule__Group__2 ;
    public final void rule__CallRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4634:1: ( rule__CallRule__Group__1__Impl rule__CallRule__Group__2 )
            // InternalOptimisationLanguage.g:4635:2: rule__CallRule__Group__1__Impl rule__CallRule__Group__2
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
    // InternalOptimisationLanguage.g:4642:1: rule__CallRule__Group__1__Impl : ( '(' ) ;
    public final void rule__CallRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4646:1: ( ( '(' ) )
            // InternalOptimisationLanguage.g:4647:1: ( '(' )
            {
            // InternalOptimisationLanguage.g:4647:1: ( '(' )
            // InternalOptimisationLanguage.g:4648:2: '('
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
    // InternalOptimisationLanguage.g:4657:1: rule__CallRule__Group__2 : rule__CallRule__Group__2__Impl rule__CallRule__Group__3 ;
    public final void rule__CallRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4661:1: ( rule__CallRule__Group__2__Impl rule__CallRule__Group__3 )
            // InternalOptimisationLanguage.g:4662:2: rule__CallRule__Group__2__Impl rule__CallRule__Group__3
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
    // InternalOptimisationLanguage.g:4669:1: rule__CallRule__Group__2__Impl : ( ( rule__CallRule__Group_2__0 )? ) ;
    public final void rule__CallRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4673:1: ( ( ( rule__CallRule__Group_2__0 )? ) )
            // InternalOptimisationLanguage.g:4674:1: ( ( rule__CallRule__Group_2__0 )? )
            {
            // InternalOptimisationLanguage.g:4674:1: ( ( rule__CallRule__Group_2__0 )? )
            // InternalOptimisationLanguage.g:4675:2: ( rule__CallRule__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getGroup_2()); 
            }
            // InternalOptimisationLanguage.g:4676:2: ( rule__CallRule__Group_2__0 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( ((LA35_0>=RULE_QUOTED_ID && LA35_0<=RULE_STRING)||LA35_0==15||(LA35_0>=22 && LA35_0<=23)||LA35_0==70||LA35_0==72||(LA35_0>=74 && LA35_0<=78)||(LA35_0>=92 && LA35_0<=93)) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalOptimisationLanguage.g:4676:3: rule__CallRule__Group_2__0
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
    // InternalOptimisationLanguage.g:4684:1: rule__CallRule__Group__3 : rule__CallRule__Group__3__Impl ;
    public final void rule__CallRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4688:1: ( rule__CallRule__Group__3__Impl )
            // InternalOptimisationLanguage.g:4689:2: rule__CallRule__Group__3__Impl
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
    // InternalOptimisationLanguage.g:4695:1: rule__CallRule__Group__3__Impl : ( ')' ) ;
    public final void rule__CallRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4699:1: ( ( ')' ) )
            // InternalOptimisationLanguage.g:4700:1: ( ')' )
            {
            // InternalOptimisationLanguage.g:4700:1: ( ')' )
            // InternalOptimisationLanguage.g:4701:2: ')'
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
    // InternalOptimisationLanguage.g:4711:1: rule__CallRule__Group_2__0 : rule__CallRule__Group_2__0__Impl rule__CallRule__Group_2__1 ;
    public final void rule__CallRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4715:1: ( rule__CallRule__Group_2__0__Impl rule__CallRule__Group_2__1 )
            // InternalOptimisationLanguage.g:4716:2: rule__CallRule__Group_2__0__Impl rule__CallRule__Group_2__1
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
    // InternalOptimisationLanguage.g:4723:1: rule__CallRule__Group_2__0__Impl : ( ( rule__CallRule__ParametersAssignment_2_0 ) ) ;
    public final void rule__CallRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4727:1: ( ( ( rule__CallRule__ParametersAssignment_2_0 ) ) )
            // InternalOptimisationLanguage.g:4728:1: ( ( rule__CallRule__ParametersAssignment_2_0 ) )
            {
            // InternalOptimisationLanguage.g:4728:1: ( ( rule__CallRule__ParametersAssignment_2_0 ) )
            // InternalOptimisationLanguage.g:4729:2: ( rule__CallRule__ParametersAssignment_2_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getParametersAssignment_2_0()); 
            }
            // InternalOptimisationLanguage.g:4730:2: ( rule__CallRule__ParametersAssignment_2_0 )
            // InternalOptimisationLanguage.g:4730:3: rule__CallRule__ParametersAssignment_2_0
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
    // InternalOptimisationLanguage.g:4738:1: rule__CallRule__Group_2__1 : rule__CallRule__Group_2__1__Impl ;
    public final void rule__CallRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4742:1: ( rule__CallRule__Group_2__1__Impl )
            // InternalOptimisationLanguage.g:4743:2: rule__CallRule__Group_2__1__Impl
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
    // InternalOptimisationLanguage.g:4749:1: rule__CallRule__Group_2__1__Impl : ( ( rule__CallRule__Group_2_1__0 )* ) ;
    public final void rule__CallRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4753:1: ( ( ( rule__CallRule__Group_2_1__0 )* ) )
            // InternalOptimisationLanguage.g:4754:1: ( ( rule__CallRule__Group_2_1__0 )* )
            {
            // InternalOptimisationLanguage.g:4754:1: ( ( rule__CallRule__Group_2_1__0 )* )
            // InternalOptimisationLanguage.g:4755:2: ( rule__CallRule__Group_2_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getGroup_2_1()); 
            }
            // InternalOptimisationLanguage.g:4756:2: ( rule__CallRule__Group_2_1__0 )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==56) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:4756:3: rule__CallRule__Group_2_1__0
            	    {
            	    pushFollow(FOLLOW_12);
            	    rule__CallRule__Group_2_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop36;
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
    // InternalOptimisationLanguage.g:4765:1: rule__CallRule__Group_2_1__0 : rule__CallRule__Group_2_1__0__Impl rule__CallRule__Group_2_1__1 ;
    public final void rule__CallRule__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4769:1: ( rule__CallRule__Group_2_1__0__Impl rule__CallRule__Group_2_1__1 )
            // InternalOptimisationLanguage.g:4770:2: rule__CallRule__Group_2_1__0__Impl rule__CallRule__Group_2_1__1
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
    // InternalOptimisationLanguage.g:4777:1: rule__CallRule__Group_2_1__0__Impl : ( ',' ) ;
    public final void rule__CallRule__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4781:1: ( ( ',' ) )
            // InternalOptimisationLanguage.g:4782:1: ( ',' )
            {
            // InternalOptimisationLanguage.g:4782:1: ( ',' )
            // InternalOptimisationLanguage.g:4783:2: ','
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
    // InternalOptimisationLanguage.g:4792:1: rule__CallRule__Group_2_1__1 : rule__CallRule__Group_2_1__1__Impl ;
    public final void rule__CallRule__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4796:1: ( rule__CallRule__Group_2_1__1__Impl )
            // InternalOptimisationLanguage.g:4797:2: rule__CallRule__Group_2_1__1__Impl
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
    // InternalOptimisationLanguage.g:4803:1: rule__CallRule__Group_2_1__1__Impl : ( ( rule__CallRule__ParametersAssignment_2_1_1 ) ) ;
    public final void rule__CallRule__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4807:1: ( ( ( rule__CallRule__ParametersAssignment_2_1_1 ) ) )
            // InternalOptimisationLanguage.g:4808:1: ( ( rule__CallRule__ParametersAssignment_2_1_1 ) )
            {
            // InternalOptimisationLanguage.g:4808:1: ( ( rule__CallRule__ParametersAssignment_2_1_1 ) )
            // InternalOptimisationLanguage.g:4809:2: ( rule__CallRule__ParametersAssignment_2_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getParametersAssignment_2_1_1()); 
            }
            // InternalOptimisationLanguage.g:4810:2: ( rule__CallRule__ParametersAssignment_2_1_1 )
            // InternalOptimisationLanguage.g:4810:3: rule__CallRule__ParametersAssignment_2_1_1
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
    // InternalOptimisationLanguage.g:4819:1: rule__SelfReferenceRule__Group_0__0 : rule__SelfReferenceRule__Group_0__0__Impl rule__SelfReferenceRule__Group_0__1 ;
    public final void rule__SelfReferenceRule__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4823:1: ( rule__SelfReferenceRule__Group_0__0__Impl rule__SelfReferenceRule__Group_0__1 )
            // InternalOptimisationLanguage.g:4824:2: rule__SelfReferenceRule__Group_0__0__Impl rule__SelfReferenceRule__Group_0__1
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
    // InternalOptimisationLanguage.g:4831:1: rule__SelfReferenceRule__Group_0__0__Impl : ( () ) ;
    public final void rule__SelfReferenceRule__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4835:1: ( ( () ) )
            // InternalOptimisationLanguage.g:4836:1: ( () )
            {
            // InternalOptimisationLanguage.g:4836:1: ( () )
            // InternalOptimisationLanguage.g:4837:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSelfReferenceRuleAccess().getSelfReferenceAction_0_0()); 
            }
            // InternalOptimisationLanguage.g:4838:2: ()
            // InternalOptimisationLanguage.g:4838:3: 
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
    // InternalOptimisationLanguage.g:4846:1: rule__SelfReferenceRule__Group_0__1 : rule__SelfReferenceRule__Group_0__1__Impl ;
    public final void rule__SelfReferenceRule__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4850:1: ( rule__SelfReferenceRule__Group_0__1__Impl )
            // InternalOptimisationLanguage.g:4851:2: rule__SelfReferenceRule__Group_0__1__Impl
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
    // InternalOptimisationLanguage.g:4857:1: rule__SelfReferenceRule__Group_0__1__Impl : ( 'self' ) ;
    public final void rule__SelfReferenceRule__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4861:1: ( ( 'self' ) )
            // InternalOptimisationLanguage.g:4862:1: ( 'self' )
            {
            // InternalOptimisationLanguage.g:4862:1: ( 'self' )
            // InternalOptimisationLanguage.g:4863:2: 'self'
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
    // InternalOptimisationLanguage.g:4873:1: rule__SelfReferenceRule__Group_1__0 : rule__SelfReferenceRule__Group_1__0__Impl rule__SelfReferenceRule__Group_1__1 ;
    public final void rule__SelfReferenceRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4877:1: ( rule__SelfReferenceRule__Group_1__0__Impl rule__SelfReferenceRule__Group_1__1 )
            // InternalOptimisationLanguage.g:4878:2: rule__SelfReferenceRule__Group_1__0__Impl rule__SelfReferenceRule__Group_1__1
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
    // InternalOptimisationLanguage.g:4885:1: rule__SelfReferenceRule__Group_1__0__Impl : ( () ) ;
    public final void rule__SelfReferenceRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4889:1: ( ( () ) )
            // InternalOptimisationLanguage.g:4890:1: ( () )
            {
            // InternalOptimisationLanguage.g:4890:1: ( () )
            // InternalOptimisationLanguage.g:4891:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSelfReferenceRuleAccess().getSelfReferenceAction_1_0()); 
            }
            // InternalOptimisationLanguage.g:4892:2: ()
            // InternalOptimisationLanguage.g:4892:3: 
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
    // InternalOptimisationLanguage.g:4900:1: rule__SelfReferenceRule__Group_1__1 : rule__SelfReferenceRule__Group_1__1__Impl ;
    public final void rule__SelfReferenceRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4904:1: ( rule__SelfReferenceRule__Group_1__1__Impl )
            // InternalOptimisationLanguage.g:4905:2: rule__SelfReferenceRule__Group_1__1__Impl
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
    // InternalOptimisationLanguage.g:4911:1: rule__SelfReferenceRule__Group_1__1__Impl : ( 'value' ) ;
    public final void rule__SelfReferenceRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4915:1: ( ( 'value' ) )
            // InternalOptimisationLanguage.g:4916:1: ( 'value' )
            {
            // InternalOptimisationLanguage.g:4916:1: ( 'value' )
            // InternalOptimisationLanguage.g:4917:2: 'value'
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
    // InternalOptimisationLanguage.g:4927:1: rule__AttributeReferenceRule__Group__0 : rule__AttributeReferenceRule__Group__0__Impl rule__AttributeReferenceRule__Group__1 ;
    public final void rule__AttributeReferenceRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4931:1: ( rule__AttributeReferenceRule__Group__0__Impl rule__AttributeReferenceRule__Group__1 )
            // InternalOptimisationLanguage.g:4932:2: rule__AttributeReferenceRule__Group__0__Impl rule__AttributeReferenceRule__Group__1
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
    // InternalOptimisationLanguage.g:4939:1: rule__AttributeReferenceRule__Group__0__Impl : ( ( rule__AttributeReferenceRule__SelfAssignment_0 ) ) ;
    public final void rule__AttributeReferenceRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4943:1: ( ( ( rule__AttributeReferenceRule__SelfAssignment_0 ) ) )
            // InternalOptimisationLanguage.g:4944:1: ( ( rule__AttributeReferenceRule__SelfAssignment_0 ) )
            {
            // InternalOptimisationLanguage.g:4944:1: ( ( rule__AttributeReferenceRule__SelfAssignment_0 ) )
            // InternalOptimisationLanguage.g:4945:2: ( rule__AttributeReferenceRule__SelfAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeReferenceRuleAccess().getSelfAssignment_0()); 
            }
            // InternalOptimisationLanguage.g:4946:2: ( rule__AttributeReferenceRule__SelfAssignment_0 )
            // InternalOptimisationLanguage.g:4946:3: rule__AttributeReferenceRule__SelfAssignment_0
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
    // InternalOptimisationLanguage.g:4954:1: rule__AttributeReferenceRule__Group__1 : rule__AttributeReferenceRule__Group__1__Impl ;
    public final void rule__AttributeReferenceRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4958:1: ( rule__AttributeReferenceRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:4959:2: rule__AttributeReferenceRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:4965:1: rule__AttributeReferenceRule__Group__1__Impl : ( ( rule__AttributeReferenceRule__Group_1__0 )* ) ;
    public final void rule__AttributeReferenceRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4969:1: ( ( ( rule__AttributeReferenceRule__Group_1__0 )* ) )
            // InternalOptimisationLanguage.g:4970:1: ( ( rule__AttributeReferenceRule__Group_1__0 )* )
            {
            // InternalOptimisationLanguage.g:4970:1: ( ( rule__AttributeReferenceRule__Group_1__0 )* )
            // InternalOptimisationLanguage.g:4971:2: ( rule__AttributeReferenceRule__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeReferenceRuleAccess().getGroup_1()); 
            }
            // InternalOptimisationLanguage.g:4972:2: ( rule__AttributeReferenceRule__Group_1__0 )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==58) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:4972:3: rule__AttributeReferenceRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_45);
            	    rule__AttributeReferenceRule__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop37;
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
    // InternalOptimisationLanguage.g:4981:1: rule__AttributeReferenceRule__Group_1__0 : rule__AttributeReferenceRule__Group_1__0__Impl rule__AttributeReferenceRule__Group_1__1 ;
    public final void rule__AttributeReferenceRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4985:1: ( rule__AttributeReferenceRule__Group_1__0__Impl rule__AttributeReferenceRule__Group_1__1 )
            // InternalOptimisationLanguage.g:4986:2: rule__AttributeReferenceRule__Group_1__0__Impl rule__AttributeReferenceRule__Group_1__1
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
    // InternalOptimisationLanguage.g:4993:1: rule__AttributeReferenceRule__Group_1__0__Impl : ( '.' ) ;
    public final void rule__AttributeReferenceRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4997:1: ( ( '.' ) )
            // InternalOptimisationLanguage.g:4998:1: ( '.' )
            {
            // InternalOptimisationLanguage.g:4998:1: ( '.' )
            // InternalOptimisationLanguage.g:4999:2: '.'
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
    // InternalOptimisationLanguage.g:5008:1: rule__AttributeReferenceRule__Group_1__1 : rule__AttributeReferenceRule__Group_1__1__Impl ;
    public final void rule__AttributeReferenceRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5012:1: ( rule__AttributeReferenceRule__Group_1__1__Impl )
            // InternalOptimisationLanguage.g:5013:2: rule__AttributeReferenceRule__Group_1__1__Impl
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
    // InternalOptimisationLanguage.g:5019:1: rule__AttributeReferenceRule__Group_1__1__Impl : ( ( rule__AttributeReferenceRule__ChainAssignment_1_1 ) ) ;
    public final void rule__AttributeReferenceRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5023:1: ( ( ( rule__AttributeReferenceRule__ChainAssignment_1_1 ) ) )
            // InternalOptimisationLanguage.g:5024:1: ( ( rule__AttributeReferenceRule__ChainAssignment_1_1 ) )
            {
            // InternalOptimisationLanguage.g:5024:1: ( ( rule__AttributeReferenceRule__ChainAssignment_1_1 ) )
            // InternalOptimisationLanguage.g:5025:2: ( rule__AttributeReferenceRule__ChainAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeReferenceRuleAccess().getChainAssignment_1_1()); 
            }
            // InternalOptimisationLanguage.g:5026:2: ( rule__AttributeReferenceRule__ChainAssignment_1_1 )
            // InternalOptimisationLanguage.g:5026:3: rule__AttributeReferenceRule__ChainAssignment_1_1
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
    // InternalOptimisationLanguage.g:5035:1: rule__ConfigurationReferenceRule__Group__0 : rule__ConfigurationReferenceRule__Group__0__Impl rule__ConfigurationReferenceRule__Group__1 ;
    public final void rule__ConfigurationReferenceRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5039:1: ( rule__ConfigurationReferenceRule__Group__0__Impl rule__ConfigurationReferenceRule__Group__1 )
            // InternalOptimisationLanguage.g:5040:2: rule__ConfigurationReferenceRule__Group__0__Impl rule__ConfigurationReferenceRule__Group__1
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
    // InternalOptimisationLanguage.g:5047:1: rule__ConfigurationReferenceRule__Group__0__Impl : ( 'tree' ) ;
    public final void rule__ConfigurationReferenceRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5051:1: ( ( 'tree' ) )
            // InternalOptimisationLanguage.g:5052:1: ( 'tree' )
            {
            // InternalOptimisationLanguage.g:5052:1: ( 'tree' )
            // InternalOptimisationLanguage.g:5053:2: 'tree'
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
    // InternalOptimisationLanguage.g:5062:1: rule__ConfigurationReferenceRule__Group__1 : rule__ConfigurationReferenceRule__Group__1__Impl ;
    public final void rule__ConfigurationReferenceRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5066:1: ( rule__ConfigurationReferenceRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:5067:2: rule__ConfigurationReferenceRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:5073:1: rule__ConfigurationReferenceRule__Group__1__Impl : ( ( rule__ConfigurationReferenceRule__ReferenceAssignment_1 ) ) ;
    public final void rule__ConfigurationReferenceRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5077:1: ( ( ( rule__ConfigurationReferenceRule__ReferenceAssignment_1 ) ) )
            // InternalOptimisationLanguage.g:5078:1: ( ( rule__ConfigurationReferenceRule__ReferenceAssignment_1 ) )
            {
            // InternalOptimisationLanguage.g:5078:1: ( ( rule__ConfigurationReferenceRule__ReferenceAssignment_1 ) )
            // InternalOptimisationLanguage.g:5079:2: ( rule__ConfigurationReferenceRule__ReferenceAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigurationReferenceRuleAccess().getReferenceAssignment_1()); 
            }
            // InternalOptimisationLanguage.g:5080:2: ( rule__ConfigurationReferenceRule__ReferenceAssignment_1 )
            // InternalOptimisationLanguage.g:5080:3: rule__ConfigurationReferenceRule__ReferenceAssignment_1
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
    // InternalOptimisationLanguage.g:5089:1: rule__BaseDataReferenceRule__Group__0 : rule__BaseDataReferenceRule__Group__0__Impl rule__BaseDataReferenceRule__Group__1 ;
    public final void rule__BaseDataReferenceRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5093:1: ( rule__BaseDataReferenceRule__Group__0__Impl rule__BaseDataReferenceRule__Group__1 )
            // InternalOptimisationLanguage.g:5094:2: rule__BaseDataReferenceRule__Group__0__Impl rule__BaseDataReferenceRule__Group__1
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
    // InternalOptimisationLanguage.g:5101:1: rule__BaseDataReferenceRule__Group__0__Impl : ( 'data' ) ;
    public final void rule__BaseDataReferenceRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5105:1: ( ( 'data' ) )
            // InternalOptimisationLanguage.g:5106:1: ( 'data' )
            {
            // InternalOptimisationLanguage.g:5106:1: ( 'data' )
            // InternalOptimisationLanguage.g:5107:2: 'data'
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
    // InternalOptimisationLanguage.g:5116:1: rule__BaseDataReferenceRule__Group__1 : rule__BaseDataReferenceRule__Group__1__Impl ;
    public final void rule__BaseDataReferenceRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5120:1: ( rule__BaseDataReferenceRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:5121:2: rule__BaseDataReferenceRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:5127:1: rule__BaseDataReferenceRule__Group__1__Impl : ( ( rule__BaseDataReferenceRule__DefinitionAssignment_1 ) ) ;
    public final void rule__BaseDataReferenceRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5131:1: ( ( ( rule__BaseDataReferenceRule__DefinitionAssignment_1 ) ) )
            // InternalOptimisationLanguage.g:5132:1: ( ( rule__BaseDataReferenceRule__DefinitionAssignment_1 ) )
            {
            // InternalOptimisationLanguage.g:5132:1: ( ( rule__BaseDataReferenceRule__DefinitionAssignment_1 ) )
            // InternalOptimisationLanguage.g:5133:2: ( rule__BaseDataReferenceRule__DefinitionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBaseDataReferenceRuleAccess().getDefinitionAssignment_1()); 
            }
            // InternalOptimisationLanguage.g:5134:2: ( rule__BaseDataReferenceRule__DefinitionAssignment_1 )
            // InternalOptimisationLanguage.g:5134:3: rule__BaseDataReferenceRule__DefinitionAssignment_1
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
    // InternalOptimisationLanguage.g:5143:1: rule__StructuredDataDescriptionReferenceRule__Group__0 : rule__StructuredDataDescriptionReferenceRule__Group__0__Impl rule__StructuredDataDescriptionReferenceRule__Group__1 ;
    public final void rule__StructuredDataDescriptionReferenceRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5147:1: ( rule__StructuredDataDescriptionReferenceRule__Group__0__Impl rule__StructuredDataDescriptionReferenceRule__Group__1 )
            // InternalOptimisationLanguage.g:5148:2: rule__StructuredDataDescriptionReferenceRule__Group__0__Impl rule__StructuredDataDescriptionReferenceRule__Group__1
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
    // InternalOptimisationLanguage.g:5155:1: rule__StructuredDataDescriptionReferenceRule__Group__0__Impl : ( 'instance' ) ;
    public final void rule__StructuredDataDescriptionReferenceRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5159:1: ( ( 'instance' ) )
            // InternalOptimisationLanguage.g:5160:1: ( 'instance' )
            {
            // InternalOptimisationLanguage.g:5160:1: ( 'instance' )
            // InternalOptimisationLanguage.g:5161:2: 'instance'
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
    // InternalOptimisationLanguage.g:5170:1: rule__StructuredDataDescriptionReferenceRule__Group__1 : rule__StructuredDataDescriptionReferenceRule__Group__1__Impl ;
    public final void rule__StructuredDataDescriptionReferenceRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5174:1: ( rule__StructuredDataDescriptionReferenceRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:5175:2: rule__StructuredDataDescriptionReferenceRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:5181:1: rule__StructuredDataDescriptionReferenceRule__Group__1__Impl : ( ( rule__StructuredDataDescriptionReferenceRule__DefinitionAssignment_1 ) ) ;
    public final void rule__StructuredDataDescriptionReferenceRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5185:1: ( ( ( rule__StructuredDataDescriptionReferenceRule__DefinitionAssignment_1 ) ) )
            // InternalOptimisationLanguage.g:5186:1: ( ( rule__StructuredDataDescriptionReferenceRule__DefinitionAssignment_1 ) )
            {
            // InternalOptimisationLanguage.g:5186:1: ( ( rule__StructuredDataDescriptionReferenceRule__DefinitionAssignment_1 ) )
            // InternalOptimisationLanguage.g:5187:2: ( rule__StructuredDataDescriptionReferenceRule__DefinitionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStructuredDataDescriptionReferenceRuleAccess().getDefinitionAssignment_1()); 
            }
            // InternalOptimisationLanguage.g:5188:2: ( rule__StructuredDataDescriptionReferenceRule__DefinitionAssignment_1 )
            // InternalOptimisationLanguage.g:5188:3: rule__StructuredDataDescriptionReferenceRule__DefinitionAssignment_1
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
    // InternalOptimisationLanguage.g:5197:1: rule__InstanceLiteralRule__Group__0 : rule__InstanceLiteralRule__Group__0__Impl rule__InstanceLiteralRule__Group__1 ;
    public final void rule__InstanceLiteralRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5201:1: ( rule__InstanceLiteralRule__Group__0__Impl rule__InstanceLiteralRule__Group__1 )
            // InternalOptimisationLanguage.g:5202:2: rule__InstanceLiteralRule__Group__0__Impl rule__InstanceLiteralRule__Group__1
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
    // InternalOptimisationLanguage.g:5209:1: rule__InstanceLiteralRule__Group__0__Impl : ( ( rule__InstanceLiteralRule__DefinitionAssignment_0 ) ) ;
    public final void rule__InstanceLiteralRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5213:1: ( ( ( rule__InstanceLiteralRule__DefinitionAssignment_0 ) ) )
            // InternalOptimisationLanguage.g:5214:1: ( ( rule__InstanceLiteralRule__DefinitionAssignment_0 ) )
            {
            // InternalOptimisationLanguage.g:5214:1: ( ( rule__InstanceLiteralRule__DefinitionAssignment_0 ) )
            // InternalOptimisationLanguage.g:5215:2: ( rule__InstanceLiteralRule__DefinitionAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceLiteralRuleAccess().getDefinitionAssignment_0()); 
            }
            // InternalOptimisationLanguage.g:5216:2: ( rule__InstanceLiteralRule__DefinitionAssignment_0 )
            // InternalOptimisationLanguage.g:5216:3: rule__InstanceLiteralRule__DefinitionAssignment_0
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
    // InternalOptimisationLanguage.g:5224:1: rule__InstanceLiteralRule__Group__1 : rule__InstanceLiteralRule__Group__1__Impl rule__InstanceLiteralRule__Group__2 ;
    public final void rule__InstanceLiteralRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5228:1: ( rule__InstanceLiteralRule__Group__1__Impl rule__InstanceLiteralRule__Group__2 )
            // InternalOptimisationLanguage.g:5229:2: rule__InstanceLiteralRule__Group__1__Impl rule__InstanceLiteralRule__Group__2
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
    // InternalOptimisationLanguage.g:5236:1: rule__InstanceLiteralRule__Group__1__Impl : ( '{' ) ;
    public final void rule__InstanceLiteralRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5240:1: ( ( '{' ) )
            // InternalOptimisationLanguage.g:5241:1: ( '{' )
            {
            // InternalOptimisationLanguage.g:5241:1: ( '{' )
            // InternalOptimisationLanguage.g:5242:2: '{'
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
    // InternalOptimisationLanguage.g:5251:1: rule__InstanceLiteralRule__Group__2 : rule__InstanceLiteralRule__Group__2__Impl rule__InstanceLiteralRule__Group__3 ;
    public final void rule__InstanceLiteralRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5255:1: ( rule__InstanceLiteralRule__Group__2__Impl rule__InstanceLiteralRule__Group__3 )
            // InternalOptimisationLanguage.g:5256:2: rule__InstanceLiteralRule__Group__2__Impl rule__InstanceLiteralRule__Group__3
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
    // InternalOptimisationLanguage.g:5263:1: rule__InstanceLiteralRule__Group__2__Impl : ( ( rule__InstanceLiteralRule__AttributesAssignment_2 )* ) ;
    public final void rule__InstanceLiteralRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5267:1: ( ( ( rule__InstanceLiteralRule__AttributesAssignment_2 )* ) )
            // InternalOptimisationLanguage.g:5268:1: ( ( rule__InstanceLiteralRule__AttributesAssignment_2 )* )
            {
            // InternalOptimisationLanguage.g:5268:1: ( ( rule__InstanceLiteralRule__AttributesAssignment_2 )* )
            // InternalOptimisationLanguage.g:5269:2: ( rule__InstanceLiteralRule__AttributesAssignment_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceLiteralRuleAccess().getAttributesAssignment_2()); 
            }
            // InternalOptimisationLanguage.g:5270:2: ( rule__InstanceLiteralRule__AttributesAssignment_2 )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( ((LA38_0>=RULE_QUOTED_ID && LA38_0<=RULE_ID)) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:5270:3: rule__InstanceLiteralRule__AttributesAssignment_2
            	    {
            	    pushFollow(FOLLOW_22);
            	    rule__InstanceLiteralRule__AttributesAssignment_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop38;
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
    // InternalOptimisationLanguage.g:5278:1: rule__InstanceLiteralRule__Group__3 : rule__InstanceLiteralRule__Group__3__Impl ;
    public final void rule__InstanceLiteralRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5282:1: ( rule__InstanceLiteralRule__Group__3__Impl )
            // InternalOptimisationLanguage.g:5283:2: rule__InstanceLiteralRule__Group__3__Impl
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
    // InternalOptimisationLanguage.g:5289:1: rule__InstanceLiteralRule__Group__3__Impl : ( '}' ) ;
    public final void rule__InstanceLiteralRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5293:1: ( ( '}' ) )
            // InternalOptimisationLanguage.g:5294:1: ( '}' )
            {
            // InternalOptimisationLanguage.g:5294:1: ( '}' )
            // InternalOptimisationLanguage.g:5295:2: '}'
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
    // InternalOptimisationLanguage.g:5305:1: rule__AttributeRule__Group__0 : rule__AttributeRule__Group__0__Impl rule__AttributeRule__Group__1 ;
    public final void rule__AttributeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5309:1: ( rule__AttributeRule__Group__0__Impl rule__AttributeRule__Group__1 )
            // InternalOptimisationLanguage.g:5310:2: rule__AttributeRule__Group__0__Impl rule__AttributeRule__Group__1
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
    // InternalOptimisationLanguage.g:5317:1: rule__AttributeRule__Group__0__Impl : ( ( rule__AttributeRule__DefinitionAssignment_0 ) ) ;
    public final void rule__AttributeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5321:1: ( ( ( rule__AttributeRule__DefinitionAssignment_0 ) ) )
            // InternalOptimisationLanguage.g:5322:1: ( ( rule__AttributeRule__DefinitionAssignment_0 ) )
            {
            // InternalOptimisationLanguage.g:5322:1: ( ( rule__AttributeRule__DefinitionAssignment_0 ) )
            // InternalOptimisationLanguage.g:5323:2: ( rule__AttributeRule__DefinitionAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeRuleAccess().getDefinitionAssignment_0()); 
            }
            // InternalOptimisationLanguage.g:5324:2: ( rule__AttributeRule__DefinitionAssignment_0 )
            // InternalOptimisationLanguage.g:5324:3: rule__AttributeRule__DefinitionAssignment_0
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
    // InternalOptimisationLanguage.g:5332:1: rule__AttributeRule__Group__1 : rule__AttributeRule__Group__1__Impl rule__AttributeRule__Group__2 ;
    public final void rule__AttributeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5336:1: ( rule__AttributeRule__Group__1__Impl rule__AttributeRule__Group__2 )
            // InternalOptimisationLanguage.g:5337:2: rule__AttributeRule__Group__1__Impl rule__AttributeRule__Group__2
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
    // InternalOptimisationLanguage.g:5344:1: rule__AttributeRule__Group__1__Impl : ( ':=' ) ;
    public final void rule__AttributeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5348:1: ( ( ':=' ) )
            // InternalOptimisationLanguage.g:5349:1: ( ':=' )
            {
            // InternalOptimisationLanguage.g:5349:1: ( ':=' )
            // InternalOptimisationLanguage.g:5350:2: ':='
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
    // InternalOptimisationLanguage.g:5359:1: rule__AttributeRule__Group__2 : rule__AttributeRule__Group__2__Impl rule__AttributeRule__Group__3 ;
    public final void rule__AttributeRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5363:1: ( rule__AttributeRule__Group__2__Impl rule__AttributeRule__Group__3 )
            // InternalOptimisationLanguage.g:5364:2: rule__AttributeRule__Group__2__Impl rule__AttributeRule__Group__3
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
    // InternalOptimisationLanguage.g:5371:1: rule__AttributeRule__Group__2__Impl : ( ( rule__AttributeRule__ValueAssignment_2 ) ) ;
    public final void rule__AttributeRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5375:1: ( ( ( rule__AttributeRule__ValueAssignment_2 ) ) )
            // InternalOptimisationLanguage.g:5376:1: ( ( rule__AttributeRule__ValueAssignment_2 ) )
            {
            // InternalOptimisationLanguage.g:5376:1: ( ( rule__AttributeRule__ValueAssignment_2 ) )
            // InternalOptimisationLanguage.g:5377:2: ( rule__AttributeRule__ValueAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeRuleAccess().getValueAssignment_2()); 
            }
            // InternalOptimisationLanguage.g:5378:2: ( rule__AttributeRule__ValueAssignment_2 )
            // InternalOptimisationLanguage.g:5378:3: rule__AttributeRule__ValueAssignment_2
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
    // InternalOptimisationLanguage.g:5386:1: rule__AttributeRule__Group__3 : rule__AttributeRule__Group__3__Impl ;
    public final void rule__AttributeRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5390:1: ( rule__AttributeRule__Group__3__Impl )
            // InternalOptimisationLanguage.g:5391:2: rule__AttributeRule__Group__3__Impl
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
    // InternalOptimisationLanguage.g:5397:1: rule__AttributeRule__Group__3__Impl : ( ';' ) ;
    public final void rule__AttributeRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5401:1: ( ( ';' ) )
            // InternalOptimisationLanguage.g:5402:1: ( ';' )
            {
            // InternalOptimisationLanguage.g:5402:1: ( ';' )
            // InternalOptimisationLanguage.g:5403:2: ';'
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
    // InternalOptimisationLanguage.g:5413:1: rule__RealLiteralRule__Group__0 : rule__RealLiteralRule__Group__0__Impl rule__RealLiteralRule__Group__1 ;
    public final void rule__RealLiteralRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5417:1: ( rule__RealLiteralRule__Group__0__Impl rule__RealLiteralRule__Group__1 )
            // InternalOptimisationLanguage.g:5418:2: rule__RealLiteralRule__Group__0__Impl rule__RealLiteralRule__Group__1
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
    // InternalOptimisationLanguage.g:5425:1: rule__RealLiteralRule__Group__0__Impl : ( ( rule__RealLiteralRule__LiteralAssignment_0 ) ) ;
    public final void rule__RealLiteralRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5429:1: ( ( ( rule__RealLiteralRule__LiteralAssignment_0 ) ) )
            // InternalOptimisationLanguage.g:5430:1: ( ( rule__RealLiteralRule__LiteralAssignment_0 ) )
            {
            // InternalOptimisationLanguage.g:5430:1: ( ( rule__RealLiteralRule__LiteralAssignment_0 ) )
            // InternalOptimisationLanguage.g:5431:2: ( rule__RealLiteralRule__LiteralAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealLiteralRuleAccess().getLiteralAssignment_0()); 
            }
            // InternalOptimisationLanguage.g:5432:2: ( rule__RealLiteralRule__LiteralAssignment_0 )
            // InternalOptimisationLanguage.g:5432:3: rule__RealLiteralRule__LiteralAssignment_0
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
    // InternalOptimisationLanguage.g:5440:1: rule__RealLiteralRule__Group__1 : rule__RealLiteralRule__Group__1__Impl ;
    public final void rule__RealLiteralRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5444:1: ( rule__RealLiteralRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:5445:2: rule__RealLiteralRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:5451:1: rule__RealLiteralRule__Group__1__Impl : ( ( rule__RealLiteralRule__FactorAssignment_1 )? ) ;
    public final void rule__RealLiteralRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5455:1: ( ( ( rule__RealLiteralRule__FactorAssignment_1 )? ) )
            // InternalOptimisationLanguage.g:5456:1: ( ( rule__RealLiteralRule__FactorAssignment_1 )? )
            {
            // InternalOptimisationLanguage.g:5456:1: ( ( rule__RealLiteralRule__FactorAssignment_1 )? )
            // InternalOptimisationLanguage.g:5457:2: ( rule__RealLiteralRule__FactorAssignment_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealLiteralRuleAccess().getFactorAssignment_1()); 
            }
            // InternalOptimisationLanguage.g:5458:2: ( rule__RealLiteralRule__FactorAssignment_1 )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( ((LA39_0>=27 && LA39_0<=46)) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalOptimisationLanguage.g:5458:3: rule__RealLiteralRule__FactorAssignment_1
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
    // InternalOptimisationLanguage.g:5467:1: rule__IntegerLiteralRule__Group__0 : rule__IntegerLiteralRule__Group__0__Impl rule__IntegerLiteralRule__Group__1 ;
    public final void rule__IntegerLiteralRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5471:1: ( rule__IntegerLiteralRule__Group__0__Impl rule__IntegerLiteralRule__Group__1 )
            // InternalOptimisationLanguage.g:5472:2: rule__IntegerLiteralRule__Group__0__Impl rule__IntegerLiteralRule__Group__1
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
    // InternalOptimisationLanguage.g:5479:1: rule__IntegerLiteralRule__Group__0__Impl : ( ( rule__IntegerLiteralRule__LiteralAssignment_0 ) ) ;
    public final void rule__IntegerLiteralRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5483:1: ( ( ( rule__IntegerLiteralRule__LiteralAssignment_0 ) ) )
            // InternalOptimisationLanguage.g:5484:1: ( ( rule__IntegerLiteralRule__LiteralAssignment_0 ) )
            {
            // InternalOptimisationLanguage.g:5484:1: ( ( rule__IntegerLiteralRule__LiteralAssignment_0 ) )
            // InternalOptimisationLanguage.g:5485:2: ( rule__IntegerLiteralRule__LiteralAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegerLiteralRuleAccess().getLiteralAssignment_0()); 
            }
            // InternalOptimisationLanguage.g:5486:2: ( rule__IntegerLiteralRule__LiteralAssignment_0 )
            // InternalOptimisationLanguage.g:5486:3: rule__IntegerLiteralRule__LiteralAssignment_0
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
    // InternalOptimisationLanguage.g:5494:1: rule__IntegerLiteralRule__Group__1 : rule__IntegerLiteralRule__Group__1__Impl ;
    public final void rule__IntegerLiteralRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5498:1: ( rule__IntegerLiteralRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:5499:2: rule__IntegerLiteralRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:5505:1: rule__IntegerLiteralRule__Group__1__Impl : ( ( rule__IntegerLiteralRule__FactorAssignment_1 )? ) ;
    public final void rule__IntegerLiteralRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5509:1: ( ( ( rule__IntegerLiteralRule__FactorAssignment_1 )? ) )
            // InternalOptimisationLanguage.g:5510:1: ( ( rule__IntegerLiteralRule__FactorAssignment_1 )? )
            {
            // InternalOptimisationLanguage.g:5510:1: ( ( rule__IntegerLiteralRule__FactorAssignment_1 )? )
            // InternalOptimisationLanguage.g:5511:2: ( rule__IntegerLiteralRule__FactorAssignment_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegerLiteralRuleAccess().getFactorAssignment_1()); 
            }
            // InternalOptimisationLanguage.g:5512:2: ( rule__IntegerLiteralRule__FactorAssignment_1 )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( ((LA40_0>=27 && LA40_0<=46)) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalOptimisationLanguage.g:5512:3: rule__IntegerLiteralRule__FactorAssignment_1
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
    // InternalOptimisationLanguage.g:5521:1: rule__BooleanLiteralRule__Group__0 : rule__BooleanLiteralRule__Group__0__Impl rule__BooleanLiteralRule__Group__1 ;
    public final void rule__BooleanLiteralRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5525:1: ( rule__BooleanLiteralRule__Group__0__Impl rule__BooleanLiteralRule__Group__1 )
            // InternalOptimisationLanguage.g:5526:2: rule__BooleanLiteralRule__Group__0__Impl rule__BooleanLiteralRule__Group__1
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
    // InternalOptimisationLanguage.g:5533:1: rule__BooleanLiteralRule__Group__0__Impl : ( () ) ;
    public final void rule__BooleanLiteralRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5537:1: ( ( () ) )
            // InternalOptimisationLanguage.g:5538:1: ( () )
            {
            // InternalOptimisationLanguage.g:5538:1: ( () )
            // InternalOptimisationLanguage.g:5539:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralRuleAccess().getBooleanLiteralAction_0()); 
            }
            // InternalOptimisationLanguage.g:5540:2: ()
            // InternalOptimisationLanguage.g:5540:3: 
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
    // InternalOptimisationLanguage.g:5548:1: rule__BooleanLiteralRule__Group__1 : rule__BooleanLiteralRule__Group__1__Impl ;
    public final void rule__BooleanLiteralRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5552:1: ( rule__BooleanLiteralRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:5553:2: rule__BooleanLiteralRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:5559:1: rule__BooleanLiteralRule__Group__1__Impl : ( ( rule__BooleanLiteralRule__Alternatives_1 ) ) ;
    public final void rule__BooleanLiteralRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5563:1: ( ( ( rule__BooleanLiteralRule__Alternatives_1 ) ) )
            // InternalOptimisationLanguage.g:5564:1: ( ( rule__BooleanLiteralRule__Alternatives_1 ) )
            {
            // InternalOptimisationLanguage.g:5564:1: ( ( rule__BooleanLiteralRule__Alternatives_1 ) )
            // InternalOptimisationLanguage.g:5565:2: ( rule__BooleanLiteralRule__Alternatives_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralRuleAccess().getAlternatives_1()); 
            }
            // InternalOptimisationLanguage.g:5566:2: ( rule__BooleanLiteralRule__Alternatives_1 )
            // InternalOptimisationLanguage.g:5566:3: rule__BooleanLiteralRule__Alternatives_1
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
    // InternalOptimisationLanguage.g:5575:1: rule__ConstraintRule__Group__0 : rule__ConstraintRule__Group__0__Impl rule__ConstraintRule__Group__1 ;
    public final void rule__ConstraintRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5579:1: ( rule__ConstraintRule__Group__0__Impl rule__ConstraintRule__Group__1 )
            // InternalOptimisationLanguage.g:5580:2: rule__ConstraintRule__Group__0__Impl rule__ConstraintRule__Group__1
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
    // InternalOptimisationLanguage.g:5587:1: rule__ConstraintRule__Group__0__Impl : ( '@' ) ;
    public final void rule__ConstraintRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5591:1: ( ( '@' ) )
            // InternalOptimisationLanguage.g:5592:1: ( '@' )
            {
            // InternalOptimisationLanguage.g:5592:1: ( '@' )
            // InternalOptimisationLanguage.g:5593:2: '@'
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
    // InternalOptimisationLanguage.g:5602:1: rule__ConstraintRule__Group__1 : rule__ConstraintRule__Group__1__Impl ;
    public final void rule__ConstraintRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5606:1: ( rule__ConstraintRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:5607:2: rule__ConstraintRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:5613:1: rule__ConstraintRule__Group__1__Impl : ( ruleInstanceLiteralRule ) ;
    public final void rule__ConstraintRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5617:1: ( ( ruleInstanceLiteralRule ) )
            // InternalOptimisationLanguage.g:5618:1: ( ruleInstanceLiteralRule )
            {
            // InternalOptimisationLanguage.g:5618:1: ( ruleInstanceLiteralRule )
            // InternalOptimisationLanguage.g:5619:2: ruleInstanceLiteralRule
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
    // InternalOptimisationLanguage.g:5629:1: rule__AttributeDefinitionRule__Group__0 : rule__AttributeDefinitionRule__Group__0__Impl rule__AttributeDefinitionRule__Group__1 ;
    public final void rule__AttributeDefinitionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5633:1: ( rule__AttributeDefinitionRule__Group__0__Impl rule__AttributeDefinitionRule__Group__1 )
            // InternalOptimisationLanguage.g:5634:2: rule__AttributeDefinitionRule__Group__0__Impl rule__AttributeDefinitionRule__Group__1
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
    // InternalOptimisationLanguage.g:5641:1: rule__AttributeDefinitionRule__Group__0__Impl : ( ( rule__AttributeDefinitionRule__ConstraintsAssignment_0 )* ) ;
    public final void rule__AttributeDefinitionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5645:1: ( ( ( rule__AttributeDefinitionRule__ConstraintsAssignment_0 )* ) )
            // InternalOptimisationLanguage.g:5646:1: ( ( rule__AttributeDefinitionRule__ConstraintsAssignment_0 )* )
            {
            // InternalOptimisationLanguage.g:5646:1: ( ( rule__AttributeDefinitionRule__ConstraintsAssignment_0 )* )
            // InternalOptimisationLanguage.g:5647:2: ( rule__AttributeDefinitionRule__ConstraintsAssignment_0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getConstraintsAssignment_0()); 
            }
            // InternalOptimisationLanguage.g:5648:2: ( rule__AttributeDefinitionRule__ConstraintsAssignment_0 )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==79) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:5648:3: rule__AttributeDefinitionRule__ConstraintsAssignment_0
            	    {
            	    pushFollow(FOLLOW_49);
            	    rule__AttributeDefinitionRule__ConstraintsAssignment_0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop41;
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
    // InternalOptimisationLanguage.g:5656:1: rule__AttributeDefinitionRule__Group__1 : rule__AttributeDefinitionRule__Group__1__Impl rule__AttributeDefinitionRule__Group__2 ;
    public final void rule__AttributeDefinitionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5660:1: ( rule__AttributeDefinitionRule__Group__1__Impl rule__AttributeDefinitionRule__Group__2 )
            // InternalOptimisationLanguage.g:5661:2: rule__AttributeDefinitionRule__Group__1__Impl rule__AttributeDefinitionRule__Group__2
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
    // InternalOptimisationLanguage.g:5668:1: rule__AttributeDefinitionRule__Group__1__Impl : ( ( rule__AttributeDefinitionRule__NameAssignment_1 ) ) ;
    public final void rule__AttributeDefinitionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5672:1: ( ( ( rule__AttributeDefinitionRule__NameAssignment_1 ) ) )
            // InternalOptimisationLanguage.g:5673:1: ( ( rule__AttributeDefinitionRule__NameAssignment_1 ) )
            {
            // InternalOptimisationLanguage.g:5673:1: ( ( rule__AttributeDefinitionRule__NameAssignment_1 ) )
            // InternalOptimisationLanguage.g:5674:2: ( rule__AttributeDefinitionRule__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getNameAssignment_1()); 
            }
            // InternalOptimisationLanguage.g:5675:2: ( rule__AttributeDefinitionRule__NameAssignment_1 )
            // InternalOptimisationLanguage.g:5675:3: rule__AttributeDefinitionRule__NameAssignment_1
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
    // InternalOptimisationLanguage.g:5683:1: rule__AttributeDefinitionRule__Group__2 : rule__AttributeDefinitionRule__Group__2__Impl rule__AttributeDefinitionRule__Group__3 ;
    public final void rule__AttributeDefinitionRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5687:1: ( rule__AttributeDefinitionRule__Group__2__Impl rule__AttributeDefinitionRule__Group__3 )
            // InternalOptimisationLanguage.g:5688:2: rule__AttributeDefinitionRule__Group__2__Impl rule__AttributeDefinitionRule__Group__3
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
    // InternalOptimisationLanguage.g:5695:1: rule__AttributeDefinitionRule__Group__2__Impl : ( ':' ) ;
    public final void rule__AttributeDefinitionRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5699:1: ( ( ':' ) )
            // InternalOptimisationLanguage.g:5700:1: ( ':' )
            {
            // InternalOptimisationLanguage.g:5700:1: ( ':' )
            // InternalOptimisationLanguage.g:5701:2: ':'
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
    // InternalOptimisationLanguage.g:5710:1: rule__AttributeDefinitionRule__Group__3 : rule__AttributeDefinitionRule__Group__3__Impl rule__AttributeDefinitionRule__Group__4 ;
    public final void rule__AttributeDefinitionRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5714:1: ( rule__AttributeDefinitionRule__Group__3__Impl rule__AttributeDefinitionRule__Group__4 )
            // InternalOptimisationLanguage.g:5715:2: rule__AttributeDefinitionRule__Group__3__Impl rule__AttributeDefinitionRule__Group__4
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
    // InternalOptimisationLanguage.g:5722:1: rule__AttributeDefinitionRule__Group__3__Impl : ( ( rule__AttributeDefinitionRule__OptionalAssignment_3 )? ) ;
    public final void rule__AttributeDefinitionRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5726:1: ( ( ( rule__AttributeDefinitionRule__OptionalAssignment_3 )? ) )
            // InternalOptimisationLanguage.g:5727:1: ( ( rule__AttributeDefinitionRule__OptionalAssignment_3 )? )
            {
            // InternalOptimisationLanguage.g:5727:1: ( ( rule__AttributeDefinitionRule__OptionalAssignment_3 )? )
            // InternalOptimisationLanguage.g:5728:2: ( rule__AttributeDefinitionRule__OptionalAssignment_3 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getOptionalAssignment_3()); 
            }
            // InternalOptimisationLanguage.g:5729:2: ( rule__AttributeDefinitionRule__OptionalAssignment_3 )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==94) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalOptimisationLanguage.g:5729:3: rule__AttributeDefinitionRule__OptionalAssignment_3
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
    // InternalOptimisationLanguage.g:5737:1: rule__AttributeDefinitionRule__Group__4 : rule__AttributeDefinitionRule__Group__4__Impl rule__AttributeDefinitionRule__Group__5 ;
    public final void rule__AttributeDefinitionRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5741:1: ( rule__AttributeDefinitionRule__Group__4__Impl rule__AttributeDefinitionRule__Group__5 )
            // InternalOptimisationLanguage.g:5742:2: rule__AttributeDefinitionRule__Group__4__Impl rule__AttributeDefinitionRule__Group__5
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
    // InternalOptimisationLanguage.g:5749:1: rule__AttributeDefinitionRule__Group__4__Impl : ( ( rule__AttributeDefinitionRule__TypeAssignment_4 ) ) ;
    public final void rule__AttributeDefinitionRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5753:1: ( ( ( rule__AttributeDefinitionRule__TypeAssignment_4 ) ) )
            // InternalOptimisationLanguage.g:5754:1: ( ( rule__AttributeDefinitionRule__TypeAssignment_4 ) )
            {
            // InternalOptimisationLanguage.g:5754:1: ( ( rule__AttributeDefinitionRule__TypeAssignment_4 ) )
            // InternalOptimisationLanguage.g:5755:2: ( rule__AttributeDefinitionRule__TypeAssignment_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getTypeAssignment_4()); 
            }
            // InternalOptimisationLanguage.g:5756:2: ( rule__AttributeDefinitionRule__TypeAssignment_4 )
            // InternalOptimisationLanguage.g:5756:3: rule__AttributeDefinitionRule__TypeAssignment_4
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
    // InternalOptimisationLanguage.g:5764:1: rule__AttributeDefinitionRule__Group__5 : rule__AttributeDefinitionRule__Group__5__Impl rule__AttributeDefinitionRule__Group__6 ;
    public final void rule__AttributeDefinitionRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5768:1: ( rule__AttributeDefinitionRule__Group__5__Impl rule__AttributeDefinitionRule__Group__6 )
            // InternalOptimisationLanguage.g:5769:2: rule__AttributeDefinitionRule__Group__5__Impl rule__AttributeDefinitionRule__Group__6
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
    // InternalOptimisationLanguage.g:5776:1: rule__AttributeDefinitionRule__Group__5__Impl : ( ( rule__AttributeDefinitionRule__Group_5__0 )? ) ;
    public final void rule__AttributeDefinitionRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5780:1: ( ( ( rule__AttributeDefinitionRule__Group_5__0 )? ) )
            // InternalOptimisationLanguage.g:5781:1: ( ( rule__AttributeDefinitionRule__Group_5__0 )? )
            {
            // InternalOptimisationLanguage.g:5781:1: ( ( rule__AttributeDefinitionRule__Group_5__0 )? )
            // InternalOptimisationLanguage.g:5782:2: ( rule__AttributeDefinitionRule__Group_5__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getGroup_5()); 
            }
            // InternalOptimisationLanguage.g:5783:2: ( rule__AttributeDefinitionRule__Group_5__0 )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==64) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalOptimisationLanguage.g:5783:3: rule__AttributeDefinitionRule__Group_5__0
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
    // InternalOptimisationLanguage.g:5791:1: rule__AttributeDefinitionRule__Group__6 : rule__AttributeDefinitionRule__Group__6__Impl ;
    public final void rule__AttributeDefinitionRule__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5795:1: ( rule__AttributeDefinitionRule__Group__6__Impl )
            // InternalOptimisationLanguage.g:5796:2: rule__AttributeDefinitionRule__Group__6__Impl
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
    // InternalOptimisationLanguage.g:5802:1: rule__AttributeDefinitionRule__Group__6__Impl : ( ';' ) ;
    public final void rule__AttributeDefinitionRule__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5806:1: ( ( ';' ) )
            // InternalOptimisationLanguage.g:5807:1: ( ';' )
            {
            // InternalOptimisationLanguage.g:5807:1: ( ';' )
            // InternalOptimisationLanguage.g:5808:2: ';'
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
    // InternalOptimisationLanguage.g:5818:1: rule__AttributeDefinitionRule__Group_5__0 : rule__AttributeDefinitionRule__Group_5__0__Impl rule__AttributeDefinitionRule__Group_5__1 ;
    public final void rule__AttributeDefinitionRule__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5822:1: ( rule__AttributeDefinitionRule__Group_5__0__Impl rule__AttributeDefinitionRule__Group_5__1 )
            // InternalOptimisationLanguage.g:5823:2: rule__AttributeDefinitionRule__Group_5__0__Impl rule__AttributeDefinitionRule__Group_5__1
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
    // InternalOptimisationLanguage.g:5830:1: rule__AttributeDefinitionRule__Group_5__0__Impl : ( ':=' ) ;
    public final void rule__AttributeDefinitionRule__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5834:1: ( ( ':=' ) )
            // InternalOptimisationLanguage.g:5835:1: ( ':=' )
            {
            // InternalOptimisationLanguage.g:5835:1: ( ':=' )
            // InternalOptimisationLanguage.g:5836:2: ':='
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
    // InternalOptimisationLanguage.g:5845:1: rule__AttributeDefinitionRule__Group_5__1 : rule__AttributeDefinitionRule__Group_5__1__Impl ;
    public final void rule__AttributeDefinitionRule__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5849:1: ( rule__AttributeDefinitionRule__Group_5__1__Impl )
            // InternalOptimisationLanguage.g:5850:2: rule__AttributeDefinitionRule__Group_5__1__Impl
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
    // InternalOptimisationLanguage.g:5856:1: rule__AttributeDefinitionRule__Group_5__1__Impl : ( ( rule__AttributeDefinitionRule__InitialisationAssignment_5_1 ) ) ;
    public final void rule__AttributeDefinitionRule__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5860:1: ( ( ( rule__AttributeDefinitionRule__InitialisationAssignment_5_1 ) ) )
            // InternalOptimisationLanguage.g:5861:1: ( ( rule__AttributeDefinitionRule__InitialisationAssignment_5_1 ) )
            {
            // InternalOptimisationLanguage.g:5861:1: ( ( rule__AttributeDefinitionRule__InitialisationAssignment_5_1 ) )
            // InternalOptimisationLanguage.g:5862:2: ( rule__AttributeDefinitionRule__InitialisationAssignment_5_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getInitialisationAssignment_5_1()); 
            }
            // InternalOptimisationLanguage.g:5863:2: ( rule__AttributeDefinitionRule__InitialisationAssignment_5_1 )
            // InternalOptimisationLanguage.g:5863:3: rule__AttributeDefinitionRule__InitialisationAssignment_5_1
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
    // InternalOptimisationLanguage.g:5872:1: rule__EnumReferenceRule__Group__0 : rule__EnumReferenceRule__Group__0__Impl rule__EnumReferenceRule__Group__1 ;
    public final void rule__EnumReferenceRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5876:1: ( rule__EnumReferenceRule__Group__0__Impl rule__EnumReferenceRule__Group__1 )
            // InternalOptimisationLanguage.g:5877:2: rule__EnumReferenceRule__Group__0__Impl rule__EnumReferenceRule__Group__1
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
    // InternalOptimisationLanguage.g:5884:1: rule__EnumReferenceRule__Group__0__Impl : ( 'enum' ) ;
    public final void rule__EnumReferenceRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5888:1: ( ( 'enum' ) )
            // InternalOptimisationLanguage.g:5889:1: ( 'enum' )
            {
            // InternalOptimisationLanguage.g:5889:1: ( 'enum' )
            // InternalOptimisationLanguage.g:5890:2: 'enum'
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
    // InternalOptimisationLanguage.g:5899:1: rule__EnumReferenceRule__Group__1 : rule__EnumReferenceRule__Group__1__Impl ;
    public final void rule__EnumReferenceRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5903:1: ( rule__EnumReferenceRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:5904:2: rule__EnumReferenceRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:5910:1: rule__EnumReferenceRule__Group__1__Impl : ( ( rule__EnumReferenceRule__DefinitionAssignment_1 ) ) ;
    public final void rule__EnumReferenceRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5914:1: ( ( ( rule__EnumReferenceRule__DefinitionAssignment_1 ) ) )
            // InternalOptimisationLanguage.g:5915:1: ( ( rule__EnumReferenceRule__DefinitionAssignment_1 ) )
            {
            // InternalOptimisationLanguage.g:5915:1: ( ( rule__EnumReferenceRule__DefinitionAssignment_1 ) )
            // InternalOptimisationLanguage.g:5916:2: ( rule__EnumReferenceRule__DefinitionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumReferenceRuleAccess().getDefinitionAssignment_1()); 
            }
            // InternalOptimisationLanguage.g:5917:2: ( rule__EnumReferenceRule__DefinitionAssignment_1 )
            // InternalOptimisationLanguage.g:5917:3: rule__EnumReferenceRule__DefinitionAssignment_1
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
    // InternalOptimisationLanguage.g:5926:1: rule__TypeReferenceRule__Group__0 : rule__TypeReferenceRule__Group__0__Impl rule__TypeReferenceRule__Group__1 ;
    public final void rule__TypeReferenceRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5930:1: ( rule__TypeReferenceRule__Group__0__Impl rule__TypeReferenceRule__Group__1 )
            // InternalOptimisationLanguage.g:5931:2: rule__TypeReferenceRule__Group__0__Impl rule__TypeReferenceRule__Group__1
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
    // InternalOptimisationLanguage.g:5938:1: rule__TypeReferenceRule__Group__0__Impl : ( 'instance' ) ;
    public final void rule__TypeReferenceRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5942:1: ( ( 'instance' ) )
            // InternalOptimisationLanguage.g:5943:1: ( 'instance' )
            {
            // InternalOptimisationLanguage.g:5943:1: ( 'instance' )
            // InternalOptimisationLanguage.g:5944:2: 'instance'
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
    // InternalOptimisationLanguage.g:5953:1: rule__TypeReferenceRule__Group__1 : rule__TypeReferenceRule__Group__1__Impl ;
    public final void rule__TypeReferenceRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5957:1: ( rule__TypeReferenceRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:5958:2: rule__TypeReferenceRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:5964:1: rule__TypeReferenceRule__Group__1__Impl : ( ( rule__TypeReferenceRule__DefinitionAssignment_1 ) ) ;
    public final void rule__TypeReferenceRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5968:1: ( ( ( rule__TypeReferenceRule__DefinitionAssignment_1 ) ) )
            // InternalOptimisationLanguage.g:5969:1: ( ( rule__TypeReferenceRule__DefinitionAssignment_1 ) )
            {
            // InternalOptimisationLanguage.g:5969:1: ( ( rule__TypeReferenceRule__DefinitionAssignment_1 ) )
            // InternalOptimisationLanguage.g:5970:2: ( rule__TypeReferenceRule__DefinitionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeReferenceRuleAccess().getDefinitionAssignment_1()); 
            }
            // InternalOptimisationLanguage.g:5971:2: ( rule__TypeReferenceRule__DefinitionAssignment_1 )
            // InternalOptimisationLanguage.g:5971:3: rule__TypeReferenceRule__DefinitionAssignment_1
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
    // InternalOptimisationLanguage.g:5980:1: rule__LiteralTypeRule__Group__0 : rule__LiteralTypeRule__Group__0__Impl rule__LiteralTypeRule__Group__1 ;
    public final void rule__LiteralTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5984:1: ( rule__LiteralTypeRule__Group__0__Impl rule__LiteralTypeRule__Group__1 )
            // InternalOptimisationLanguage.g:5985:2: rule__LiteralTypeRule__Group__0__Impl rule__LiteralTypeRule__Group__1
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
    // InternalOptimisationLanguage.g:5992:1: rule__LiteralTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__LiteralTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5996:1: ( ( () ) )
            // InternalOptimisationLanguage.g:5997:1: ( () )
            {
            // InternalOptimisationLanguage.g:5997:1: ( () )
            // InternalOptimisationLanguage.g:5998:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralTypeRuleAccess().getLiteralTypeAction_0()); 
            }
            // InternalOptimisationLanguage.g:5999:2: ()
            // InternalOptimisationLanguage.g:5999:3: 
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
    // InternalOptimisationLanguage.g:6007:1: rule__LiteralTypeRule__Group__1 : rule__LiteralTypeRule__Group__1__Impl ;
    public final void rule__LiteralTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6011:1: ( rule__LiteralTypeRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:6012:2: rule__LiteralTypeRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:6018:1: rule__LiteralTypeRule__Group__1__Impl : ( 'literal' ) ;
    public final void rule__LiteralTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6022:1: ( ( 'literal' ) )
            // InternalOptimisationLanguage.g:6023:1: ( 'literal' )
            {
            // InternalOptimisationLanguage.g:6023:1: ( 'literal' )
            // InternalOptimisationLanguage.g:6024:2: 'literal'
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
    // InternalOptimisationLanguage.g:6034:1: rule__DataTypeRule__Group__0 : rule__DataTypeRule__Group__0__Impl rule__DataTypeRule__Group__1 ;
    public final void rule__DataTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6038:1: ( rule__DataTypeRule__Group__0__Impl rule__DataTypeRule__Group__1 )
            // InternalOptimisationLanguage.g:6039:2: rule__DataTypeRule__Group__0__Impl rule__DataTypeRule__Group__1
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
    // InternalOptimisationLanguage.g:6046:1: rule__DataTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__DataTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6050:1: ( ( () ) )
            // InternalOptimisationLanguage.g:6051:1: ( () )
            {
            // InternalOptimisationLanguage.g:6051:1: ( () )
            // InternalOptimisationLanguage.g:6052:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getDataTypeAction_0()); 
            }
            // InternalOptimisationLanguage.g:6053:2: ()
            // InternalOptimisationLanguage.g:6053:3: 
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
    // InternalOptimisationLanguage.g:6061:1: rule__DataTypeRule__Group__1 : rule__DataTypeRule__Group__1__Impl ;
    public final void rule__DataTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6065:1: ( rule__DataTypeRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:6066:2: rule__DataTypeRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:6072:1: rule__DataTypeRule__Group__1__Impl : ( 'data' ) ;
    public final void rule__DataTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6076:1: ( ( 'data' ) )
            // InternalOptimisationLanguage.g:6077:1: ( 'data' )
            {
            // InternalOptimisationLanguage.g:6077:1: ( 'data' )
            // InternalOptimisationLanguage.g:6078:2: 'data'
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
    // InternalOptimisationLanguage.g:6088:1: rule__StringTypeRule__Group__0 : rule__StringTypeRule__Group__0__Impl rule__StringTypeRule__Group__1 ;
    public final void rule__StringTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6092:1: ( rule__StringTypeRule__Group__0__Impl rule__StringTypeRule__Group__1 )
            // InternalOptimisationLanguage.g:6093:2: rule__StringTypeRule__Group__0__Impl rule__StringTypeRule__Group__1
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
    // InternalOptimisationLanguage.g:6100:1: rule__StringTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__StringTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6104:1: ( ( () ) )
            // InternalOptimisationLanguage.g:6105:1: ( () )
            {
            // InternalOptimisationLanguage.g:6105:1: ( () )
            // InternalOptimisationLanguage.g:6106:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringTypeRuleAccess().getStringTypeAction_0()); 
            }
            // InternalOptimisationLanguage.g:6107:2: ()
            // InternalOptimisationLanguage.g:6107:3: 
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
    // InternalOptimisationLanguage.g:6115:1: rule__StringTypeRule__Group__1 : rule__StringTypeRule__Group__1__Impl ;
    public final void rule__StringTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6119:1: ( rule__StringTypeRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:6120:2: rule__StringTypeRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:6126:1: rule__StringTypeRule__Group__1__Impl : ( 'string' ) ;
    public final void rule__StringTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6130:1: ( ( 'string' ) )
            // InternalOptimisationLanguage.g:6131:1: ( 'string' )
            {
            // InternalOptimisationLanguage.g:6131:1: ( 'string' )
            // InternalOptimisationLanguage.g:6132:2: 'string'
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
    // InternalOptimisationLanguage.g:6142:1: rule__ExpressionTypeRule__Group__0 : rule__ExpressionTypeRule__Group__0__Impl rule__ExpressionTypeRule__Group__1 ;
    public final void rule__ExpressionTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6146:1: ( rule__ExpressionTypeRule__Group__0__Impl rule__ExpressionTypeRule__Group__1 )
            // InternalOptimisationLanguage.g:6147:2: rule__ExpressionTypeRule__Group__0__Impl rule__ExpressionTypeRule__Group__1
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
    // InternalOptimisationLanguage.g:6154:1: rule__ExpressionTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__ExpressionTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6158:1: ( ( () ) )
            // InternalOptimisationLanguage.g:6159:1: ( () )
            {
            // InternalOptimisationLanguage.g:6159:1: ( () )
            // InternalOptimisationLanguage.g:6160:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionTypeRuleAccess().getExpressionTypeAction_0()); 
            }
            // InternalOptimisationLanguage.g:6161:2: ()
            // InternalOptimisationLanguage.g:6161:3: 
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
    // InternalOptimisationLanguage.g:6169:1: rule__ExpressionTypeRule__Group__1 : rule__ExpressionTypeRule__Group__1__Impl ;
    public final void rule__ExpressionTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6173:1: ( rule__ExpressionTypeRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:6174:2: rule__ExpressionTypeRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:6180:1: rule__ExpressionTypeRule__Group__1__Impl : ( 'expression' ) ;
    public final void rule__ExpressionTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6184:1: ( ( 'expression' ) )
            // InternalOptimisationLanguage.g:6185:1: ( 'expression' )
            {
            // InternalOptimisationLanguage.g:6185:1: ( 'expression' )
            // InternalOptimisationLanguage.g:6186:2: 'expression'
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
    // InternalOptimisationLanguage.g:6196:1: rule__IntTypeRule__Group__0 : rule__IntTypeRule__Group__0__Impl rule__IntTypeRule__Group__1 ;
    public final void rule__IntTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6200:1: ( rule__IntTypeRule__Group__0__Impl rule__IntTypeRule__Group__1 )
            // InternalOptimisationLanguage.g:6201:2: rule__IntTypeRule__Group__0__Impl rule__IntTypeRule__Group__1
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
    // InternalOptimisationLanguage.g:6208:1: rule__IntTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__IntTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6212:1: ( ( () ) )
            // InternalOptimisationLanguage.g:6213:1: ( () )
            {
            // InternalOptimisationLanguage.g:6213:1: ( () )
            // InternalOptimisationLanguage.g:6214:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntTypeRuleAccess().getIntTypeAction_0()); 
            }
            // InternalOptimisationLanguage.g:6215:2: ()
            // InternalOptimisationLanguage.g:6215:3: 
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
    // InternalOptimisationLanguage.g:6223:1: rule__IntTypeRule__Group__1 : rule__IntTypeRule__Group__1__Impl ;
    public final void rule__IntTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6227:1: ( rule__IntTypeRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:6228:2: rule__IntTypeRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:6234:1: rule__IntTypeRule__Group__1__Impl : ( 'int' ) ;
    public final void rule__IntTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6238:1: ( ( 'int' ) )
            // InternalOptimisationLanguage.g:6239:1: ( 'int' )
            {
            // InternalOptimisationLanguage.g:6239:1: ( 'int' )
            // InternalOptimisationLanguage.g:6240:2: 'int'
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
    // InternalOptimisationLanguage.g:6250:1: rule__RealTypeRule__Group__0 : rule__RealTypeRule__Group__0__Impl rule__RealTypeRule__Group__1 ;
    public final void rule__RealTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6254:1: ( rule__RealTypeRule__Group__0__Impl rule__RealTypeRule__Group__1 )
            // InternalOptimisationLanguage.g:6255:2: rule__RealTypeRule__Group__0__Impl rule__RealTypeRule__Group__1
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
    // InternalOptimisationLanguage.g:6262:1: rule__RealTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__RealTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6266:1: ( ( () ) )
            // InternalOptimisationLanguage.g:6267:1: ( () )
            {
            // InternalOptimisationLanguage.g:6267:1: ( () )
            // InternalOptimisationLanguage.g:6268:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealTypeRuleAccess().getRealTypeAction_0()); 
            }
            // InternalOptimisationLanguage.g:6269:2: ()
            // InternalOptimisationLanguage.g:6269:3: 
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
    // InternalOptimisationLanguage.g:6277:1: rule__RealTypeRule__Group__1 : rule__RealTypeRule__Group__1__Impl ;
    public final void rule__RealTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6281:1: ( rule__RealTypeRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:6282:2: rule__RealTypeRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:6288:1: rule__RealTypeRule__Group__1__Impl : ( 'real' ) ;
    public final void rule__RealTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6292:1: ( ( 'real' ) )
            // InternalOptimisationLanguage.g:6293:1: ( 'real' )
            {
            // InternalOptimisationLanguage.g:6293:1: ( 'real' )
            // InternalOptimisationLanguage.g:6294:2: 'real'
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
    // InternalOptimisationLanguage.g:6304:1: rule__BooleanTypeRule__Group__0 : rule__BooleanTypeRule__Group__0__Impl rule__BooleanTypeRule__Group__1 ;
    public final void rule__BooleanTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6308:1: ( rule__BooleanTypeRule__Group__0__Impl rule__BooleanTypeRule__Group__1 )
            // InternalOptimisationLanguage.g:6309:2: rule__BooleanTypeRule__Group__0__Impl rule__BooleanTypeRule__Group__1
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
    // InternalOptimisationLanguage.g:6316:1: rule__BooleanTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__BooleanTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6320:1: ( ( () ) )
            // InternalOptimisationLanguage.g:6321:1: ( () )
            {
            // InternalOptimisationLanguage.g:6321:1: ( () )
            // InternalOptimisationLanguage.g:6322:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanTypeRuleAccess().getBooleanTypeAction_0()); 
            }
            // InternalOptimisationLanguage.g:6323:2: ()
            // InternalOptimisationLanguage.g:6323:3: 
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
    // InternalOptimisationLanguage.g:6331:1: rule__BooleanTypeRule__Group__1 : rule__BooleanTypeRule__Group__1__Impl ;
    public final void rule__BooleanTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6335:1: ( rule__BooleanTypeRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:6336:2: rule__BooleanTypeRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:6342:1: rule__BooleanTypeRule__Group__1__Impl : ( 'boolean' ) ;
    public final void rule__BooleanTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6346:1: ( ( 'boolean' ) )
            // InternalOptimisationLanguage.g:6347:1: ( 'boolean' )
            {
            // InternalOptimisationLanguage.g:6347:1: ( 'boolean' )
            // InternalOptimisationLanguage.g:6348:2: 'boolean'
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
    // InternalOptimisationLanguage.g:6358:1: rule__VoidTypeRule__Group__0 : rule__VoidTypeRule__Group__0__Impl rule__VoidTypeRule__Group__1 ;
    public final void rule__VoidTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6362:1: ( rule__VoidTypeRule__Group__0__Impl rule__VoidTypeRule__Group__1 )
            // InternalOptimisationLanguage.g:6363:2: rule__VoidTypeRule__Group__0__Impl rule__VoidTypeRule__Group__1
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
    // InternalOptimisationLanguage.g:6370:1: rule__VoidTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__VoidTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6374:1: ( ( () ) )
            // InternalOptimisationLanguage.g:6375:1: ( () )
            {
            // InternalOptimisationLanguage.g:6375:1: ( () )
            // InternalOptimisationLanguage.g:6376:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVoidTypeRuleAccess().getVoidTypeAction_0()); 
            }
            // InternalOptimisationLanguage.g:6377:2: ()
            // InternalOptimisationLanguage.g:6377:3: 
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
    // InternalOptimisationLanguage.g:6385:1: rule__VoidTypeRule__Group__1 : rule__VoidTypeRule__Group__1__Impl ;
    public final void rule__VoidTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6389:1: ( rule__VoidTypeRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:6390:2: rule__VoidTypeRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:6396:1: rule__VoidTypeRule__Group__1__Impl : ( 'void' ) ;
    public final void rule__VoidTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6400:1: ( ( 'void' ) )
            // InternalOptimisationLanguage.g:6401:1: ( 'void' )
            {
            // InternalOptimisationLanguage.g:6401:1: ( 'void' )
            // InternalOptimisationLanguage.g:6402:2: 'void'
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
    // InternalOptimisationLanguage.g:6412:1: rule__ArrayTypeRule__Group__0 : rule__ArrayTypeRule__Group__0__Impl rule__ArrayTypeRule__Group__1 ;
    public final void rule__ArrayTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6416:1: ( rule__ArrayTypeRule__Group__0__Impl rule__ArrayTypeRule__Group__1 )
            // InternalOptimisationLanguage.g:6417:2: rule__ArrayTypeRule__Group__0__Impl rule__ArrayTypeRule__Group__1
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
    // InternalOptimisationLanguage.g:6424:1: rule__ArrayTypeRule__Group__0__Impl : ( 'array' ) ;
    public final void rule__ArrayTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6428:1: ( ( 'array' ) )
            // InternalOptimisationLanguage.g:6429:1: ( 'array' )
            {
            // InternalOptimisationLanguage.g:6429:1: ( 'array' )
            // InternalOptimisationLanguage.g:6430:2: 'array'
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
    // InternalOptimisationLanguage.g:6439:1: rule__ArrayTypeRule__Group__1 : rule__ArrayTypeRule__Group__1__Impl ;
    public final void rule__ArrayTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6443:1: ( rule__ArrayTypeRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:6444:2: rule__ArrayTypeRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:6450:1: rule__ArrayTypeRule__Group__1__Impl : ( ( rule__ArrayTypeRule__ElementsAssignment_1 ) ) ;
    public final void rule__ArrayTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6454:1: ( ( ( rule__ArrayTypeRule__ElementsAssignment_1 ) ) )
            // InternalOptimisationLanguage.g:6455:1: ( ( rule__ArrayTypeRule__ElementsAssignment_1 ) )
            {
            // InternalOptimisationLanguage.g:6455:1: ( ( rule__ArrayTypeRule__ElementsAssignment_1 ) )
            // InternalOptimisationLanguage.g:6456:2: ( rule__ArrayTypeRule__ElementsAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayTypeRuleAccess().getElementsAssignment_1()); 
            }
            // InternalOptimisationLanguage.g:6457:2: ( rule__ArrayTypeRule__ElementsAssignment_1 )
            // InternalOptimisationLanguage.g:6457:3: rule__ArrayTypeRule__ElementsAssignment_1
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
    // InternalOptimisationLanguage.g:6466:1: rule__ParameterRule__Group__0 : rule__ParameterRule__Group__0__Impl rule__ParameterRule__Group__1 ;
    public final void rule__ParameterRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6470:1: ( rule__ParameterRule__Group__0__Impl rule__ParameterRule__Group__1 )
            // InternalOptimisationLanguage.g:6471:2: rule__ParameterRule__Group__0__Impl rule__ParameterRule__Group__1
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
    // InternalOptimisationLanguage.g:6478:1: rule__ParameterRule__Group__0__Impl : ( ( rule__ParameterRule__TypeAssignment_0 ) ) ;
    public final void rule__ParameterRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6482:1: ( ( ( rule__ParameterRule__TypeAssignment_0 ) ) )
            // InternalOptimisationLanguage.g:6483:1: ( ( rule__ParameterRule__TypeAssignment_0 ) )
            {
            // InternalOptimisationLanguage.g:6483:1: ( ( rule__ParameterRule__TypeAssignment_0 ) )
            // InternalOptimisationLanguage.g:6484:2: ( rule__ParameterRule__TypeAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterRuleAccess().getTypeAssignment_0()); 
            }
            // InternalOptimisationLanguage.g:6485:2: ( rule__ParameterRule__TypeAssignment_0 )
            // InternalOptimisationLanguage.g:6485:3: rule__ParameterRule__TypeAssignment_0
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
    // InternalOptimisationLanguage.g:6493:1: rule__ParameterRule__Group__1 : rule__ParameterRule__Group__1__Impl ;
    public final void rule__ParameterRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6497:1: ( rule__ParameterRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:6498:2: rule__ParameterRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:6504:1: rule__ParameterRule__Group__1__Impl : ( ( rule__ParameterRule__NameAssignment_1 ) ) ;
    public final void rule__ParameterRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6508:1: ( ( ( rule__ParameterRule__NameAssignment_1 ) ) )
            // InternalOptimisationLanguage.g:6509:1: ( ( rule__ParameterRule__NameAssignment_1 ) )
            {
            // InternalOptimisationLanguage.g:6509:1: ( ( rule__ParameterRule__NameAssignment_1 ) )
            // InternalOptimisationLanguage.g:6510:2: ( rule__ParameterRule__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterRuleAccess().getNameAssignment_1()); 
            }
            // InternalOptimisationLanguage.g:6511:2: ( rule__ParameterRule__NameAssignment_1 )
            // InternalOptimisationLanguage.g:6511:3: rule__ParameterRule__NameAssignment_1
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
    // InternalOptimisationLanguage.g:6520:1: rule__ImportRule__Group__0 : rule__ImportRule__Group__0__Impl rule__ImportRule__Group__1 ;
    public final void rule__ImportRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6524:1: ( rule__ImportRule__Group__0__Impl rule__ImportRule__Group__1 )
            // InternalOptimisationLanguage.g:6525:2: rule__ImportRule__Group__0__Impl rule__ImportRule__Group__1
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
    // InternalOptimisationLanguage.g:6532:1: rule__ImportRule__Group__0__Impl : ( 'import' ) ;
    public final void rule__ImportRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6536:1: ( ( 'import' ) )
            // InternalOptimisationLanguage.g:6537:1: ( 'import' )
            {
            // InternalOptimisationLanguage.g:6537:1: ( 'import' )
            // InternalOptimisationLanguage.g:6538:2: 'import'
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
    // InternalOptimisationLanguage.g:6547:1: rule__ImportRule__Group__1 : rule__ImportRule__Group__1__Impl rule__ImportRule__Group__2 ;
    public final void rule__ImportRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6551:1: ( rule__ImportRule__Group__1__Impl rule__ImportRule__Group__2 )
            // InternalOptimisationLanguage.g:6552:2: rule__ImportRule__Group__1__Impl rule__ImportRule__Group__2
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
    // InternalOptimisationLanguage.g:6559:1: rule__ImportRule__Group__1__Impl : ( ( rule__ImportRule__LanguageAssignment_1 ) ) ;
    public final void rule__ImportRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6563:1: ( ( ( rule__ImportRule__LanguageAssignment_1 ) ) )
            // InternalOptimisationLanguage.g:6564:1: ( ( rule__ImportRule__LanguageAssignment_1 ) )
            {
            // InternalOptimisationLanguage.g:6564:1: ( ( rule__ImportRule__LanguageAssignment_1 ) )
            // InternalOptimisationLanguage.g:6565:2: ( rule__ImportRule__LanguageAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportRuleAccess().getLanguageAssignment_1()); 
            }
            // InternalOptimisationLanguage.g:6566:2: ( rule__ImportRule__LanguageAssignment_1 )
            // InternalOptimisationLanguage.g:6566:3: rule__ImportRule__LanguageAssignment_1
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
    // InternalOptimisationLanguage.g:6574:1: rule__ImportRule__Group__2 : rule__ImportRule__Group__2__Impl rule__ImportRule__Group__3 ;
    public final void rule__ImportRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6578:1: ( rule__ImportRule__Group__2__Impl rule__ImportRule__Group__3 )
            // InternalOptimisationLanguage.g:6579:2: rule__ImportRule__Group__2__Impl rule__ImportRule__Group__3
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
    // InternalOptimisationLanguage.g:6586:1: rule__ImportRule__Group__2__Impl : ( 'from' ) ;
    public final void rule__ImportRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6590:1: ( ( 'from' ) )
            // InternalOptimisationLanguage.g:6591:1: ( 'from' )
            {
            // InternalOptimisationLanguage.g:6591:1: ( 'from' )
            // InternalOptimisationLanguage.g:6592:2: 'from'
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
    // InternalOptimisationLanguage.g:6601:1: rule__ImportRule__Group__3 : rule__ImportRule__Group__3__Impl rule__ImportRule__Group__4 ;
    public final void rule__ImportRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6605:1: ( rule__ImportRule__Group__3__Impl rule__ImportRule__Group__4 )
            // InternalOptimisationLanguage.g:6606:2: rule__ImportRule__Group__3__Impl rule__ImportRule__Group__4
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
    // InternalOptimisationLanguage.g:6613:1: rule__ImportRule__Group__3__Impl : ( ( rule__ImportRule__ImportedNamespaceAssignment_3 ) ) ;
    public final void rule__ImportRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6617:1: ( ( ( rule__ImportRule__ImportedNamespaceAssignment_3 ) ) )
            // InternalOptimisationLanguage.g:6618:1: ( ( rule__ImportRule__ImportedNamespaceAssignment_3 ) )
            {
            // InternalOptimisationLanguage.g:6618:1: ( ( rule__ImportRule__ImportedNamespaceAssignment_3 ) )
            // InternalOptimisationLanguage.g:6619:2: ( rule__ImportRule__ImportedNamespaceAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportRuleAccess().getImportedNamespaceAssignment_3()); 
            }
            // InternalOptimisationLanguage.g:6620:2: ( rule__ImportRule__ImportedNamespaceAssignment_3 )
            // InternalOptimisationLanguage.g:6620:3: rule__ImportRule__ImportedNamespaceAssignment_3
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
    // InternalOptimisationLanguage.g:6628:1: rule__ImportRule__Group__4 : rule__ImportRule__Group__4__Impl ;
    public final void rule__ImportRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6632:1: ( rule__ImportRule__Group__4__Impl )
            // InternalOptimisationLanguage.g:6633:2: rule__ImportRule__Group__4__Impl
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
    // InternalOptimisationLanguage.g:6639:1: rule__ImportRule__Group__4__Impl : ( ';' ) ;
    public final void rule__ImportRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6643:1: ( ( ';' ) )
            // InternalOptimisationLanguage.g:6644:1: ( ';' )
            {
            // InternalOptimisationLanguage.g:6644:1: ( ';' )
            // InternalOptimisationLanguage.g:6645:2: ';'
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
    // InternalOptimisationLanguage.g:6655:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6659:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // InternalOptimisationLanguage.g:6660:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
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
    // InternalOptimisationLanguage.g:6667:1: rule__QualifiedName__Group__0__Impl : ( ruleStringOrId ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6671:1: ( ( ruleStringOrId ) )
            // InternalOptimisationLanguage.g:6672:1: ( ruleStringOrId )
            {
            // InternalOptimisationLanguage.g:6672:1: ( ruleStringOrId )
            // InternalOptimisationLanguage.g:6673:2: ruleStringOrId
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
    // InternalOptimisationLanguage.g:6682:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6686:1: ( rule__QualifiedName__Group__1__Impl )
            // InternalOptimisationLanguage.g:6687:2: rule__QualifiedName__Group__1__Impl
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
    // InternalOptimisationLanguage.g:6693:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6697:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // InternalOptimisationLanguage.g:6698:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // InternalOptimisationLanguage.g:6698:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // InternalOptimisationLanguage.g:6699:2: ( rule__QualifiedName__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            }
            // InternalOptimisationLanguage.g:6700:2: ( rule__QualifiedName__Group_1__0 )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==58) ) {
                    int LA44_2 = input.LA(2);

                    if ( (LA44_2==RULE_QUOTED_ID) ) {
                        int LA44_3 = input.LA(3);

                        if ( (synpred83_InternalOptimisationLanguage()) ) {
                            alt44=1;
                        }


                    }
                    else if ( (LA44_2==RULE_ID) ) {
                        int LA44_4 = input.LA(3);

                        if ( (synpred83_InternalOptimisationLanguage()) ) {
                            alt44=1;
                        }


                    }


                }


                switch (alt44) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:6700:3: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_45);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop44;
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
    // InternalOptimisationLanguage.g:6709:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6713:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // InternalOptimisationLanguage.g:6714:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
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
    // InternalOptimisationLanguage.g:6721:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6725:1: ( ( '.' ) )
            // InternalOptimisationLanguage.g:6726:1: ( '.' )
            {
            // InternalOptimisationLanguage.g:6726:1: ( '.' )
            // InternalOptimisationLanguage.g:6727:2: '.'
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
    // InternalOptimisationLanguage.g:6736:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6740:1: ( rule__QualifiedName__Group_1__1__Impl )
            // InternalOptimisationLanguage.g:6741:2: rule__QualifiedName__Group_1__1__Impl
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
    // InternalOptimisationLanguage.g:6747:1: rule__QualifiedName__Group_1__1__Impl : ( ruleStringOrId ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6751:1: ( ( ruleStringOrId ) )
            // InternalOptimisationLanguage.g:6752:1: ( ruleStringOrId )
            {
            // InternalOptimisationLanguage.g:6752:1: ( ruleStringOrId )
            // InternalOptimisationLanguage.g:6753:2: ruleStringOrId
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
    // InternalOptimisationLanguage.g:6763:1: rule__OptimisationModelRule__ImportsAssignment_0 : ( ruleImportRule ) ;
    public final void rule__OptimisationModelRule__ImportsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6767:1: ( ( ruleImportRule ) )
            // InternalOptimisationLanguage.g:6768:2: ( ruleImportRule )
            {
            // InternalOptimisationLanguage.g:6768:2: ( ruleImportRule )
            // InternalOptimisationLanguage.g:6769:3: ruleImportRule
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
    // InternalOptimisationLanguage.g:6778:1: rule__OptimisationModelRule__NameAssignment_2 : ( ruleQualifiedName ) ;
    public final void rule__OptimisationModelRule__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6782:1: ( ( ruleQualifiedName ) )
            // InternalOptimisationLanguage.g:6783:2: ( ruleQualifiedName )
            {
            // InternalOptimisationLanguage.g:6783:2: ( ruleQualifiedName )
            // InternalOptimisationLanguage.g:6784:3: ruleQualifiedName
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
    // InternalOptimisationLanguage.g:6793:1: rule__OptimisationModelRule__ProblemAssignment_4 : ( ruleProblemRule ) ;
    public final void rule__OptimisationModelRule__ProblemAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6797:1: ( ( ruleProblemRule ) )
            // InternalOptimisationLanguage.g:6798:2: ( ruleProblemRule )
            {
            // InternalOptimisationLanguage.g:6798:2: ( ruleProblemRule )
            // InternalOptimisationLanguage.g:6799:3: ruleProblemRule
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
    // InternalOptimisationLanguage.g:6808:1: rule__OptimisationModelRule__AlgorithmAssignment_5 : ( ruleAlgorithmInstanceRule ) ;
    public final void rule__OptimisationModelRule__AlgorithmAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6812:1: ( ( ruleAlgorithmInstanceRule ) )
            // InternalOptimisationLanguage.g:6813:2: ( ruleAlgorithmInstanceRule )
            {
            // InternalOptimisationLanguage.g:6813:2: ( ruleAlgorithmInstanceRule )
            // InternalOptimisationLanguage.g:6814:3: ruleAlgorithmInstanceRule
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
    // InternalOptimisationLanguage.g:6823:1: rule__ProblemRule__DefinitionAssignment_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__ProblemRule__DefinitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6827:1: ( ( ( ruleQualifiedName ) ) )
            // InternalOptimisationLanguage.g:6828:2: ( ( ruleQualifiedName ) )
            {
            // InternalOptimisationLanguage.g:6828:2: ( ( ruleQualifiedName ) )
            // InternalOptimisationLanguage.g:6829:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProblemRuleAccess().getDefinitionClassDefinitionCrossReference_1_0()); 
            }
            // InternalOptimisationLanguage.g:6830:3: ( ruleQualifiedName )
            // InternalOptimisationLanguage.g:6831:4: ruleQualifiedName
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
    // InternalOptimisationLanguage.g:6842:1: rule__ProblemRule__NameAssignment_2 : ( ruleStringOrId ) ;
    public final void rule__ProblemRule__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6846:1: ( ( ruleStringOrId ) )
            // InternalOptimisationLanguage.g:6847:2: ( ruleStringOrId )
            {
            // InternalOptimisationLanguage.g:6847:2: ( ruleStringOrId )
            // InternalOptimisationLanguage.g:6848:3: ruleStringOrId
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
    // InternalOptimisationLanguage.g:6857:1: rule__ProblemRule__SearchSpaceAssignment_6 : ( ruleTypeDefinitionReferenceRule ) ;
    public final void rule__ProblemRule__SearchSpaceAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6861:1: ( ( ruleTypeDefinitionReferenceRule ) )
            // InternalOptimisationLanguage.g:6862:2: ( ruleTypeDefinitionReferenceRule )
            {
            // InternalOptimisationLanguage.g:6862:2: ( ruleTypeDefinitionReferenceRule )
            // InternalOptimisationLanguage.g:6863:3: ruleTypeDefinitionReferenceRule
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
    // InternalOptimisationLanguage.g:6872:1: rule__ProblemRule__SearchSpaceAssignment_7_1 : ( ruleTypeDefinitionReferenceRule ) ;
    public final void rule__ProblemRule__SearchSpaceAssignment_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6876:1: ( ( ruleTypeDefinitionReferenceRule ) )
            // InternalOptimisationLanguage.g:6877:2: ( ruleTypeDefinitionReferenceRule )
            {
            // InternalOptimisationLanguage.g:6877:2: ( ruleTypeDefinitionReferenceRule )
            // InternalOptimisationLanguage.g:6878:3: ruleTypeDefinitionReferenceRule
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
    // InternalOptimisationLanguage.g:6887:1: rule__ProblemRule__OptimisationFunctionAssignment_10 : ( ruleInstanceLiteralRule ) ;
    public final void rule__ProblemRule__OptimisationFunctionAssignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6891:1: ( ( ruleInstanceLiteralRule ) )
            // InternalOptimisationLanguage.g:6892:2: ( ruleInstanceLiteralRule )
            {
            // InternalOptimisationLanguage.g:6892:2: ( ruleInstanceLiteralRule )
            // InternalOptimisationLanguage.g:6893:3: ruleInstanceLiteralRule
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
    // InternalOptimisationLanguage.g:6902:1: rule__ProblemRule__OptimisationSpaceAssignment_12 : ( ruleOptimisationGoalRule ) ;
    public final void rule__ProblemRule__OptimisationSpaceAssignment_12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6906:1: ( ( ruleOptimisationGoalRule ) )
            // InternalOptimisationLanguage.g:6907:2: ( ruleOptimisationGoalRule )
            {
            // InternalOptimisationLanguage.g:6907:2: ( ruleOptimisationGoalRule )
            // InternalOptimisationLanguage.g:6908:3: ruleOptimisationGoalRule
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
    // InternalOptimisationLanguage.g:6917:1: rule__ProblemRule__OptimisationSpaceAssignment_13_1 : ( ruleOptimisationGoalRule ) ;
    public final void rule__ProblemRule__OptimisationSpaceAssignment_13_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6921:1: ( ( ruleOptimisationGoalRule ) )
            // InternalOptimisationLanguage.g:6922:2: ( ruleOptimisationGoalRule )
            {
            // InternalOptimisationLanguage.g:6922:2: ( ruleOptimisationGoalRule )
            // InternalOptimisationLanguage.g:6923:3: ruleOptimisationGoalRule
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
    // InternalOptimisationLanguage.g:6932:1: rule__ProblemRule__DocumentationAssignment_14_1 : ( ruleArrayRule ) ;
    public final void rule__ProblemRule__DocumentationAssignment_14_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6936:1: ( ( ruleArrayRule ) )
            // InternalOptimisationLanguage.g:6937:2: ( ruleArrayRule )
            {
            // InternalOptimisationLanguage.g:6937:2: ( ruleArrayRule )
            // InternalOptimisationLanguage.g:6938:3: ruleArrayRule
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
    // InternalOptimisationLanguage.g:6947:1: rule__MaximiseGoalRule__DataAssignment_1 : ( ruleTypeDefinitionReferenceRule ) ;
    public final void rule__MaximiseGoalRule__DataAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6951:1: ( ( ruleTypeDefinitionReferenceRule ) )
            // InternalOptimisationLanguage.g:6952:2: ( ruleTypeDefinitionReferenceRule )
            {
            // InternalOptimisationLanguage.g:6952:2: ( ruleTypeDefinitionReferenceRule )
            // InternalOptimisationLanguage.g:6953:3: ruleTypeDefinitionReferenceRule
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
    // InternalOptimisationLanguage.g:6962:1: rule__MinimiseGoalRule__DataAssignment_1 : ( ruleTypeDefinitionReferenceRule ) ;
    public final void rule__MinimiseGoalRule__DataAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6966:1: ( ( ruleTypeDefinitionReferenceRule ) )
            // InternalOptimisationLanguage.g:6967:2: ( ruleTypeDefinitionReferenceRule )
            {
            // InternalOptimisationLanguage.g:6967:2: ( ruleTypeDefinitionReferenceRule )
            // InternalOptimisationLanguage.g:6968:3: ruleTypeDefinitionReferenceRule
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
    // InternalOptimisationLanguage.g:6977:1: rule__TargetGoalRule__DataAssignment_1 : ( ruleTypeDefinitionReferenceRule ) ;
    public final void rule__TargetGoalRule__DataAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6981:1: ( ( ruleTypeDefinitionReferenceRule ) )
            // InternalOptimisationLanguage.g:6982:2: ( ruleTypeDefinitionReferenceRule )
            {
            // InternalOptimisationLanguage.g:6982:2: ( ruleTypeDefinitionReferenceRule )
            // InternalOptimisationLanguage.g:6983:3: ruleTypeDefinitionReferenceRule
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


    // $ANTLR start "rule__TargetGoalRule__ValueAssignment_3"
    // InternalOptimisationLanguage.g:6992:1: rule__TargetGoalRule__ValueAssignment_3 : ( ruleLiteralRule ) ;
    public final void rule__TargetGoalRule__ValueAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6996:1: ( ( ruleLiteralRule ) )
            // InternalOptimisationLanguage.g:6997:2: ( ruleLiteralRule )
            {
            // InternalOptimisationLanguage.g:6997:2: ( ruleLiteralRule )
            // InternalOptimisationLanguage.g:6998:3: ruleLiteralRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTargetGoalRuleAccess().getValueLiteralRuleParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleLiteralRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTargetGoalRuleAccess().getValueLiteralRuleParserRuleCall_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TargetGoalRule__ValueAssignment_3"


    // $ANTLR start "rule__AlgorithmInstanceRule__DefinitionAssignment_1"
    // InternalOptimisationLanguage.g:7007:1: rule__AlgorithmInstanceRule__DefinitionAssignment_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__AlgorithmInstanceRule__DefinitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7011:1: ( ( ( ruleQualifiedName ) ) )
            // InternalOptimisationLanguage.g:7012:2: ( ( ruleQualifiedName ) )
            {
            // InternalOptimisationLanguage.g:7012:2: ( ( ruleQualifiedName ) )
            // InternalOptimisationLanguage.g:7013:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAlgorithmInstanceRuleAccess().getDefinitionClassDefinitionCrossReference_1_0()); 
            }
            // InternalOptimisationLanguage.g:7014:3: ( ruleQualifiedName )
            // InternalOptimisationLanguage.g:7015:4: ruleQualifiedName
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
    // InternalOptimisationLanguage.g:7026:1: rule__AlgorithmInstanceRule__ProblemAssignment_3 : ( ( ruleQualifiedName ) ) ;
    public final void rule__AlgorithmInstanceRule__ProblemAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7030:1: ( ( ( ruleQualifiedName ) ) )
            // InternalOptimisationLanguage.g:7031:2: ( ( ruleQualifiedName ) )
            {
            // InternalOptimisationLanguage.g:7031:2: ( ( ruleQualifiedName ) )
            // InternalOptimisationLanguage.g:7032:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAlgorithmInstanceRuleAccess().getProblemProblemInstanceCrossReference_3_0()); 
            }
            // InternalOptimisationLanguage.g:7033:3: ( ruleQualifiedName )
            // InternalOptimisationLanguage.g:7034:4: ruleQualifiedName
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
    // InternalOptimisationLanguage.g:7045:1: rule__AlgorithmInstanceRule__AttributesAssignment_5 : ( ruleAttributeRule ) ;
    public final void rule__AlgorithmInstanceRule__AttributesAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7049:1: ( ( ruleAttributeRule ) )
            // InternalOptimisationLanguage.g:7050:2: ( ruleAttributeRule )
            {
            // InternalOptimisationLanguage.g:7050:2: ( ruleAttributeRule )
            // InternalOptimisationLanguage.g:7051:3: ruleAttributeRule
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
    // InternalOptimisationLanguage.g:7060:1: rule__AlgorithmInstanceRule__DocumentationAssignment_6_2 : ( ruleArrayRule ) ;
    public final void rule__AlgorithmInstanceRule__DocumentationAssignment_6_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7064:1: ( ( ruleArrayRule ) )
            // InternalOptimisationLanguage.g:7065:2: ( ruleArrayRule )
            {
            // InternalOptimisationLanguage.g:7065:2: ( ruleArrayRule )
            // InternalOptimisationLanguage.g:7066:3: ruleArrayRule
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
    // InternalOptimisationLanguage.g:7075:1: rule__OrExpressionRule__SubExpressionsAssignment_0 : ( ruleXorExpressionRule ) ;
    public final void rule__OrExpressionRule__SubExpressionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7079:1: ( ( ruleXorExpressionRule ) )
            // InternalOptimisationLanguage.g:7080:2: ( ruleXorExpressionRule )
            {
            // InternalOptimisationLanguage.g:7080:2: ( ruleXorExpressionRule )
            // InternalOptimisationLanguage.g:7081:3: ruleXorExpressionRule
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
    // InternalOptimisationLanguage.g:7090:1: rule__OrExpressionRule__SubExpressionsAssignment_1_1 : ( ruleXorExpressionRule ) ;
    public final void rule__OrExpressionRule__SubExpressionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7094:1: ( ( ruleXorExpressionRule ) )
            // InternalOptimisationLanguage.g:7095:2: ( ruleXorExpressionRule )
            {
            // InternalOptimisationLanguage.g:7095:2: ( ruleXorExpressionRule )
            // InternalOptimisationLanguage.g:7096:3: ruleXorExpressionRule
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
    // InternalOptimisationLanguage.g:7105:1: rule__XorExpressionRule__SubExpressionsAssignment_0 : ( ruleAndExpressionRule ) ;
    public final void rule__XorExpressionRule__SubExpressionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7109:1: ( ( ruleAndExpressionRule ) )
            // InternalOptimisationLanguage.g:7110:2: ( ruleAndExpressionRule )
            {
            // InternalOptimisationLanguage.g:7110:2: ( ruleAndExpressionRule )
            // InternalOptimisationLanguage.g:7111:3: ruleAndExpressionRule
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
    // InternalOptimisationLanguage.g:7120:1: rule__XorExpressionRule__SubExpressionsAssignment_1_1 : ( ruleAndExpressionRule ) ;
    public final void rule__XorExpressionRule__SubExpressionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7124:1: ( ( ruleAndExpressionRule ) )
            // InternalOptimisationLanguage.g:7125:2: ( ruleAndExpressionRule )
            {
            // InternalOptimisationLanguage.g:7125:2: ( ruleAndExpressionRule )
            // InternalOptimisationLanguage.g:7126:3: ruleAndExpressionRule
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
    // InternalOptimisationLanguage.g:7135:1: rule__AndExpressionRule__SubExpressionsAssignment_0 : ( ruleNotExpressionRule ) ;
    public final void rule__AndExpressionRule__SubExpressionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7139:1: ( ( ruleNotExpressionRule ) )
            // InternalOptimisationLanguage.g:7140:2: ( ruleNotExpressionRule )
            {
            // InternalOptimisationLanguage.g:7140:2: ( ruleNotExpressionRule )
            // InternalOptimisationLanguage.g:7141:3: ruleNotExpressionRule
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
    // InternalOptimisationLanguage.g:7150:1: rule__AndExpressionRule__SubExpressionsAssignment_1_1 : ( ruleNotExpressionRule ) ;
    public final void rule__AndExpressionRule__SubExpressionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7154:1: ( ( ruleNotExpressionRule ) )
            // InternalOptimisationLanguage.g:7155:2: ( ruleNotExpressionRule )
            {
            // InternalOptimisationLanguage.g:7155:2: ( ruleNotExpressionRule )
            // InternalOptimisationLanguage.g:7156:3: ruleNotExpressionRule
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
    // InternalOptimisationLanguage.g:7165:1: rule__NotExpressionRule__NegatedAssignment_0 : ( ( '!' ) ) ;
    public final void rule__NotExpressionRule__NegatedAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7169:1: ( ( ( '!' ) ) )
            // InternalOptimisationLanguage.g:7170:2: ( ( '!' ) )
            {
            // InternalOptimisationLanguage.g:7170:2: ( ( '!' ) )
            // InternalOptimisationLanguage.g:7171:3: ( '!' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNotExpressionRuleAccess().getNegatedExclamationMarkKeyword_0_0()); 
            }
            // InternalOptimisationLanguage.g:7172:3: ( '!' )
            // InternalOptimisationLanguage.g:7173:4: '!'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNotExpressionRuleAccess().getNegatedExclamationMarkKeyword_0_0()); 
            }
            match(input,92,FOLLOW_2); if (state.failed) return ;
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
    // InternalOptimisationLanguage.g:7184:1: rule__NotExpressionRule__OperandAssignment_1 : ( ruleComparisonExpressionRule ) ;
    public final void rule__NotExpressionRule__OperandAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7188:1: ( ( ruleComparisonExpressionRule ) )
            // InternalOptimisationLanguage.g:7189:2: ( ruleComparisonExpressionRule )
            {
            // InternalOptimisationLanguage.g:7189:2: ( ruleComparisonExpressionRule )
            // InternalOptimisationLanguage.g:7190:3: ruleComparisonExpressionRule
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
    // InternalOptimisationLanguage.g:7199:1: rule__ComparisonExpressionRule__LeftOperandAssignment_0 : ( ruleAddOrSubtractExpressionRule ) ;
    public final void rule__ComparisonExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7203:1: ( ( ruleAddOrSubtractExpressionRule ) )
            // InternalOptimisationLanguage.g:7204:2: ( ruleAddOrSubtractExpressionRule )
            {
            // InternalOptimisationLanguage.g:7204:2: ( ruleAddOrSubtractExpressionRule )
            // InternalOptimisationLanguage.g:7205:3: ruleAddOrSubtractExpressionRule
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
    // InternalOptimisationLanguage.g:7214:1: rule__ComparisonExpressionRule__ComparisonAssignment_1 : ( rulePartialComparisonExpressionRule ) ;
    public final void rule__ComparisonExpressionRule__ComparisonAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7218:1: ( ( rulePartialComparisonExpressionRule ) )
            // InternalOptimisationLanguage.g:7219:2: ( rulePartialComparisonExpressionRule )
            {
            // InternalOptimisationLanguage.g:7219:2: ( rulePartialComparisonExpressionRule )
            // InternalOptimisationLanguage.g:7220:3: rulePartialComparisonExpressionRule
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
    // InternalOptimisationLanguage.g:7229:1: rule__PartialComparisonExpressionRule__OperatorAssignment_0 : ( ruleComparisonOperatorRule ) ;
    public final void rule__PartialComparisonExpressionRule__OperatorAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7233:1: ( ( ruleComparisonOperatorRule ) )
            // InternalOptimisationLanguage.g:7234:2: ( ruleComparisonOperatorRule )
            {
            // InternalOptimisationLanguage.g:7234:2: ( ruleComparisonOperatorRule )
            // InternalOptimisationLanguage.g:7235:3: ruleComparisonOperatorRule
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
    // InternalOptimisationLanguage.g:7244:1: rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 : ( ruleAddOrSubtractExpressionRule ) ;
    public final void rule__PartialComparisonExpressionRule__SubExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7248:1: ( ( ruleAddOrSubtractExpressionRule ) )
            // InternalOptimisationLanguage.g:7249:2: ( ruleAddOrSubtractExpressionRule )
            {
            // InternalOptimisationLanguage.g:7249:2: ( ruleAddOrSubtractExpressionRule )
            // InternalOptimisationLanguage.g:7250:3: ruleAddOrSubtractExpressionRule
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
    // InternalOptimisationLanguage.g:7259:1: rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 : ( ruleMultiplyDivideModuloExpressionRule ) ;
    public final void rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7263:1: ( ( ruleMultiplyDivideModuloExpressionRule ) )
            // InternalOptimisationLanguage.g:7264:2: ( ruleMultiplyDivideModuloExpressionRule )
            {
            // InternalOptimisationLanguage.g:7264:2: ( ruleMultiplyDivideModuloExpressionRule )
            // InternalOptimisationLanguage.g:7265:3: ruleMultiplyDivideModuloExpressionRule
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
    // InternalOptimisationLanguage.g:7274:1: rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 : ( ruleAddOrSubtractOperatorRule ) ;
    public final void rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7278:1: ( ( ruleAddOrSubtractOperatorRule ) )
            // InternalOptimisationLanguage.g:7279:2: ( ruleAddOrSubtractOperatorRule )
            {
            // InternalOptimisationLanguage.g:7279:2: ( ruleAddOrSubtractOperatorRule )
            // InternalOptimisationLanguage.g:7280:3: ruleAddOrSubtractOperatorRule
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
    // InternalOptimisationLanguage.g:7289:1: rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 : ( ruleMultiplyDivideModuloExpressionRule ) ;
    public final void rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7293:1: ( ( ruleMultiplyDivideModuloExpressionRule ) )
            // InternalOptimisationLanguage.g:7294:2: ( ruleMultiplyDivideModuloExpressionRule )
            {
            // InternalOptimisationLanguage.g:7294:2: ( ruleMultiplyDivideModuloExpressionRule )
            // InternalOptimisationLanguage.g:7295:3: ruleMultiplyDivideModuloExpressionRule
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
    // InternalOptimisationLanguage.g:7304:1: rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 : ( rulePowerOfExpressionRule ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7308:1: ( ( rulePowerOfExpressionRule ) )
            // InternalOptimisationLanguage.g:7309:2: ( rulePowerOfExpressionRule )
            {
            // InternalOptimisationLanguage.g:7309:2: ( rulePowerOfExpressionRule )
            // InternalOptimisationLanguage.g:7310:3: rulePowerOfExpressionRule
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
    // InternalOptimisationLanguage.g:7319:1: rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 : ( ruleMultiplyDivideModuloOperatorRule ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7323:1: ( ( ruleMultiplyDivideModuloOperatorRule ) )
            // InternalOptimisationLanguage.g:7324:2: ( ruleMultiplyDivideModuloOperatorRule )
            {
            // InternalOptimisationLanguage.g:7324:2: ( ruleMultiplyDivideModuloOperatorRule )
            // InternalOptimisationLanguage.g:7325:3: ruleMultiplyDivideModuloOperatorRule
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
    // InternalOptimisationLanguage.g:7334:1: rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 : ( rulePowerOfExpressionRule ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7338:1: ( ( rulePowerOfExpressionRule ) )
            // InternalOptimisationLanguage.g:7339:2: ( rulePowerOfExpressionRule )
            {
            // InternalOptimisationLanguage.g:7339:2: ( rulePowerOfExpressionRule )
            // InternalOptimisationLanguage.g:7340:3: rulePowerOfExpressionRule
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
    // InternalOptimisationLanguage.g:7349:1: rule__PowerOfExpressionRule__LeftOperandAssignment_0 : ( ruleUnaryAddOrSubtractExpressionRule ) ;
    public final void rule__PowerOfExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7353:1: ( ( ruleUnaryAddOrSubtractExpressionRule ) )
            // InternalOptimisationLanguage.g:7354:2: ( ruleUnaryAddOrSubtractExpressionRule )
            {
            // InternalOptimisationLanguage.g:7354:2: ( ruleUnaryAddOrSubtractExpressionRule )
            // InternalOptimisationLanguage.g:7355:3: ruleUnaryAddOrSubtractExpressionRule
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
    // InternalOptimisationLanguage.g:7364:1: rule__PowerOfExpressionRule__RightOperandAssignment_1_1 : ( rulePowerOfExpressionRule ) ;
    public final void rule__PowerOfExpressionRule__RightOperandAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7368:1: ( ( rulePowerOfExpressionRule ) )
            // InternalOptimisationLanguage.g:7369:2: ( rulePowerOfExpressionRule )
            {
            // InternalOptimisationLanguage.g:7369:2: ( rulePowerOfExpressionRule )
            // InternalOptimisationLanguage.g:7370:3: rulePowerOfExpressionRule
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
    // InternalOptimisationLanguage.g:7379:1: rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 : ( ruleAddOrSubtractOperatorRule ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7383:1: ( ( ruleAddOrSubtractOperatorRule ) )
            // InternalOptimisationLanguage.g:7384:2: ( ruleAddOrSubtractOperatorRule )
            {
            // InternalOptimisationLanguage.g:7384:2: ( ruleAddOrSubtractOperatorRule )
            // InternalOptimisationLanguage.g:7385:3: ruleAddOrSubtractOperatorRule
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
    // InternalOptimisationLanguage.g:7394:1: rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 : ( ruleReadExpressionRule ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7398:1: ( ( ruleReadExpressionRule ) )
            // InternalOptimisationLanguage.g:7399:2: ( ruleReadExpressionRule )
            {
            // InternalOptimisationLanguage.g:7399:2: ( ruleReadExpressionRule )
            // InternalOptimisationLanguage.g:7400:3: ruleReadExpressionRule
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
    // InternalOptimisationLanguage.g:7409:1: rule__ArrayRule__ValuesAssignment_2_0 : ( ruleReadExpressionRule ) ;
    public final void rule__ArrayRule__ValuesAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7413:1: ( ( ruleReadExpressionRule ) )
            // InternalOptimisationLanguage.g:7414:2: ( ruleReadExpressionRule )
            {
            // InternalOptimisationLanguage.g:7414:2: ( ruleReadExpressionRule )
            // InternalOptimisationLanguage.g:7415:3: ruleReadExpressionRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayRuleAccess().getValuesReadExpressionRuleParserRuleCall_2_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleReadExpressionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getArrayRuleAccess().getValuesReadExpressionRuleParserRuleCall_2_0_0()); 
            }

            }


            }

        }
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
    // InternalOptimisationLanguage.g:7424:1: rule__ArrayRule__ValuesAssignment_2_1_1 : ( ruleReadExpressionRule ) ;
    public final void rule__ArrayRule__ValuesAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7428:1: ( ( ruleReadExpressionRule ) )
            // InternalOptimisationLanguage.g:7429:2: ( ruleReadExpressionRule )
            {
            // InternalOptimisationLanguage.g:7429:2: ( ruleReadExpressionRule )
            // InternalOptimisationLanguage.g:7430:3: ruleReadExpressionRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayRuleAccess().getValuesReadExpressionRuleParserRuleCall_2_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleReadExpressionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getArrayRuleAccess().getValuesReadExpressionRuleParserRuleCall_2_1_1_0()); 
            }

            }


            }

        }
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
    // InternalOptimisationLanguage.g:7439:1: rule__ParanthesesRule__SubExpressionAssignment_1 : ( ruleExpressionRule ) ;
    public final void rule__ParanthesesRule__SubExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7443:1: ( ( ruleExpressionRule ) )
            // InternalOptimisationLanguage.g:7444:2: ( ruleExpressionRule )
            {
            // InternalOptimisationLanguage.g:7444:2: ( ruleExpressionRule )
            // InternalOptimisationLanguage.g:7445:3: ruleExpressionRule
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
    // InternalOptimisationLanguage.g:7454:1: rule__CallRule__FunctionAssignment_0 : ( ( ruleQualifiedName ) ) ;
    public final void rule__CallRule__FunctionAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7458:1: ( ( ( ruleQualifiedName ) ) )
            // InternalOptimisationLanguage.g:7459:2: ( ( ruleQualifiedName ) )
            {
            // InternalOptimisationLanguage.g:7459:2: ( ( ruleQualifiedName ) )
            // InternalOptimisationLanguage.g:7460:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getFunctionFunctionDefinitionCrossReference_0_0()); 
            }
            // InternalOptimisationLanguage.g:7461:3: ( ruleQualifiedName )
            // InternalOptimisationLanguage.g:7462:4: ruleQualifiedName
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
    // InternalOptimisationLanguage.g:7473:1: rule__CallRule__ParametersAssignment_2_0 : ( ruleExpressionRule ) ;
    public final void rule__CallRule__ParametersAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7477:1: ( ( ruleExpressionRule ) )
            // InternalOptimisationLanguage.g:7478:2: ( ruleExpressionRule )
            {
            // InternalOptimisationLanguage.g:7478:2: ( ruleExpressionRule )
            // InternalOptimisationLanguage.g:7479:3: ruleExpressionRule
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
    // InternalOptimisationLanguage.g:7488:1: rule__CallRule__ParametersAssignment_2_1_1 : ( ruleExpressionRule ) ;
    public final void rule__CallRule__ParametersAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7492:1: ( ( ruleExpressionRule ) )
            // InternalOptimisationLanguage.g:7493:2: ( ruleExpressionRule )
            {
            // InternalOptimisationLanguage.g:7493:2: ( ruleExpressionRule )
            // InternalOptimisationLanguage.g:7494:3: ruleExpressionRule
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
    // InternalOptimisationLanguage.g:7503:1: rule__AttributeReferenceRule__SelfAssignment_0 : ( ruleSelfReferenceRule ) ;
    public final void rule__AttributeReferenceRule__SelfAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7507:1: ( ( ruleSelfReferenceRule ) )
            // InternalOptimisationLanguage.g:7508:2: ( ruleSelfReferenceRule )
            {
            // InternalOptimisationLanguage.g:7508:2: ( ruleSelfReferenceRule )
            // InternalOptimisationLanguage.g:7509:3: ruleSelfReferenceRule
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
    // InternalOptimisationLanguage.g:7518:1: rule__AttributeReferenceRule__ChainAssignment_1_1 : ( ruleValuelDefinitionReferenceRule ) ;
    public final void rule__AttributeReferenceRule__ChainAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7522:1: ( ( ruleValuelDefinitionReferenceRule ) )
            // InternalOptimisationLanguage.g:7523:2: ( ruleValuelDefinitionReferenceRule )
            {
            // InternalOptimisationLanguage.g:7523:2: ( ruleValuelDefinitionReferenceRule )
            // InternalOptimisationLanguage.g:7524:3: ruleValuelDefinitionReferenceRule
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
    // InternalOptimisationLanguage.g:7533:1: rule__ConfigurationReferenceRule__ReferenceAssignment_1 : ( ruleStringOrId ) ;
    public final void rule__ConfigurationReferenceRule__ReferenceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7537:1: ( ( ruleStringOrId ) )
            // InternalOptimisationLanguage.g:7538:2: ( ruleStringOrId )
            {
            // InternalOptimisationLanguage.g:7538:2: ( ruleStringOrId )
            // InternalOptimisationLanguage.g:7539:3: ruleStringOrId
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
    // InternalOptimisationLanguage.g:7548:1: rule__ValuelDefinitionReferenceRule__DefinitionAssignment : ( ( ruleQualifiedName ) ) ;
    public final void rule__ValuelDefinitionReferenceRule__DefinitionAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7552:1: ( ( ( ruleQualifiedName ) ) )
            // InternalOptimisationLanguage.g:7553:2: ( ( ruleQualifiedName ) )
            {
            // InternalOptimisationLanguage.g:7553:2: ( ( ruleQualifiedName ) )
            // InternalOptimisationLanguage.g:7554:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValuelDefinitionReferenceRuleAccess().getDefinitionValueDefinitionCrossReference_0()); 
            }
            // InternalOptimisationLanguage.g:7555:3: ( ruleQualifiedName )
            // InternalOptimisationLanguage.g:7556:4: ruleQualifiedName
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
    // InternalOptimisationLanguage.g:7567:1: rule__BaseDataReferenceRule__DefinitionAssignment_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__BaseDataReferenceRule__DefinitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7571:1: ( ( ( ruleQualifiedName ) ) )
            // InternalOptimisationLanguage.g:7572:2: ( ( ruleQualifiedName ) )
            {
            // InternalOptimisationLanguage.g:7572:2: ( ( ruleQualifiedName ) )
            // InternalOptimisationLanguage.g:7573:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBaseDataReferenceRuleAccess().getDefinitionBaseDataDescriptionCrossReference_1_0()); 
            }
            // InternalOptimisationLanguage.g:7574:3: ( ruleQualifiedName )
            // InternalOptimisationLanguage.g:7575:4: ruleQualifiedName
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
    // InternalOptimisationLanguage.g:7586:1: rule__StructuredDataDescriptionReferenceRule__DefinitionAssignment_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__StructuredDataDescriptionReferenceRule__DefinitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7590:1: ( ( ( ruleQualifiedName ) ) )
            // InternalOptimisationLanguage.g:7591:2: ( ( ruleQualifiedName ) )
            {
            // InternalOptimisationLanguage.g:7591:2: ( ( ruleQualifiedName ) )
            // InternalOptimisationLanguage.g:7592:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStructuredDataDescriptionReferenceRuleAccess().getDefinitionStructuredDataDescriptionCrossReference_1_0()); 
            }
            // InternalOptimisationLanguage.g:7593:3: ( ruleQualifiedName )
            // InternalOptimisationLanguage.g:7594:4: ruleQualifiedName
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
    // InternalOptimisationLanguage.g:7605:1: rule__InstanceLiteralRule__DefinitionAssignment_0 : ( ( ruleQualifiedName ) ) ;
    public final void rule__InstanceLiteralRule__DefinitionAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7609:1: ( ( ( ruleQualifiedName ) ) )
            // InternalOptimisationLanguage.g:7610:2: ( ( ruleQualifiedName ) )
            {
            // InternalOptimisationLanguage.g:7610:2: ( ( ruleQualifiedName ) )
            // InternalOptimisationLanguage.g:7611:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceLiteralRuleAccess().getDefinitionClassDefinitionCrossReference_0_0()); 
            }
            // InternalOptimisationLanguage.g:7612:3: ( ruleQualifiedName )
            // InternalOptimisationLanguage.g:7613:4: ruleQualifiedName
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
    // InternalOptimisationLanguage.g:7624:1: rule__InstanceLiteralRule__AttributesAssignment_2 : ( ruleAttributeRule ) ;
    public final void rule__InstanceLiteralRule__AttributesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7628:1: ( ( ruleAttributeRule ) )
            // InternalOptimisationLanguage.g:7629:2: ( ruleAttributeRule )
            {
            // InternalOptimisationLanguage.g:7629:2: ( ruleAttributeRule )
            // InternalOptimisationLanguage.g:7630:3: ruleAttributeRule
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
    // InternalOptimisationLanguage.g:7639:1: rule__AttributeRule__DefinitionAssignment_0 : ( ( ruleStringOrId ) ) ;
    public final void rule__AttributeRule__DefinitionAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7643:1: ( ( ( ruleStringOrId ) ) )
            // InternalOptimisationLanguage.g:7644:2: ( ( ruleStringOrId ) )
            {
            // InternalOptimisationLanguage.g:7644:2: ( ( ruleStringOrId ) )
            // InternalOptimisationLanguage.g:7645:3: ( ruleStringOrId )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeRuleAccess().getDefinitionAttributeDefinitionCrossReference_0_0()); 
            }
            // InternalOptimisationLanguage.g:7646:3: ( ruleStringOrId )
            // InternalOptimisationLanguage.g:7647:4: ruleStringOrId
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
    // InternalOptimisationLanguage.g:7658:1: rule__AttributeRule__ValueAssignment_2 : ( ruleExpressionRule ) ;
    public final void rule__AttributeRule__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7662:1: ( ( ruleExpressionRule ) )
            // InternalOptimisationLanguage.g:7663:2: ( ruleExpressionRule )
            {
            // InternalOptimisationLanguage.g:7663:2: ( ruleExpressionRule )
            // InternalOptimisationLanguage.g:7664:3: ruleExpressionRule
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
    // InternalOptimisationLanguage.g:7673:1: rule__RealLiteralRule__LiteralAssignment_0 : ( RULE_DOUBLE ) ;
    public final void rule__RealLiteralRule__LiteralAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7677:1: ( ( RULE_DOUBLE ) )
            // InternalOptimisationLanguage.g:7678:2: ( RULE_DOUBLE )
            {
            // InternalOptimisationLanguage.g:7678:2: ( RULE_DOUBLE )
            // InternalOptimisationLanguage.g:7679:3: RULE_DOUBLE
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
    // InternalOptimisationLanguage.g:7688:1: rule__RealLiteralRule__FactorAssignment_1 : ( ruleFactorRule ) ;
    public final void rule__RealLiteralRule__FactorAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7692:1: ( ( ruleFactorRule ) )
            // InternalOptimisationLanguage.g:7693:2: ( ruleFactorRule )
            {
            // InternalOptimisationLanguage.g:7693:2: ( ruleFactorRule )
            // InternalOptimisationLanguage.g:7694:3: ruleFactorRule
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
    // InternalOptimisationLanguage.g:7703:1: rule__IntegerLiteralRule__LiteralAssignment_0 : ( RULE_INT ) ;
    public final void rule__IntegerLiteralRule__LiteralAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7707:1: ( ( RULE_INT ) )
            // InternalOptimisationLanguage.g:7708:2: ( RULE_INT )
            {
            // InternalOptimisationLanguage.g:7708:2: ( RULE_INT )
            // InternalOptimisationLanguage.g:7709:3: RULE_INT
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
    // InternalOptimisationLanguage.g:7718:1: rule__IntegerLiteralRule__FactorAssignment_1 : ( ruleFactorRule ) ;
    public final void rule__IntegerLiteralRule__FactorAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7722:1: ( ( ruleFactorRule ) )
            // InternalOptimisationLanguage.g:7723:2: ( ruleFactorRule )
            {
            // InternalOptimisationLanguage.g:7723:2: ( ruleFactorRule )
            // InternalOptimisationLanguage.g:7724:3: ruleFactorRule
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
    // InternalOptimisationLanguage.g:7733:1: rule__StringLiteralRule__LiteralAssignment : ( RULE_STRING ) ;
    public final void rule__StringLiteralRule__LiteralAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7737:1: ( ( RULE_STRING ) )
            // InternalOptimisationLanguage.g:7738:2: ( RULE_STRING )
            {
            // InternalOptimisationLanguage.g:7738:2: ( RULE_STRING )
            // InternalOptimisationLanguage.g:7739:3: RULE_STRING
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
    // InternalOptimisationLanguage.g:7748:1: rule__BooleanLiteralRule__LiteralAssignment_1_0 : ( ( 'true' ) ) ;
    public final void rule__BooleanLiteralRule__LiteralAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7752:1: ( ( ( 'true' ) ) )
            // InternalOptimisationLanguage.g:7753:2: ( ( 'true' ) )
            {
            // InternalOptimisationLanguage.g:7753:2: ( ( 'true' ) )
            // InternalOptimisationLanguage.g:7754:3: ( 'true' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralRuleAccess().getLiteralTrueKeyword_1_0_0()); 
            }
            // InternalOptimisationLanguage.g:7755:3: ( 'true' )
            // InternalOptimisationLanguage.g:7756:4: 'true'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralRuleAccess().getLiteralTrueKeyword_1_0_0()); 
            }
            match(input,93,FOLLOW_2); if (state.failed) return ;
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
    // InternalOptimisationLanguage.g:7767:1: rule__AttributeDefinitionRule__ConstraintsAssignment_0 : ( ruleConstraintRule ) ;
    public final void rule__AttributeDefinitionRule__ConstraintsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7771:1: ( ( ruleConstraintRule ) )
            // InternalOptimisationLanguage.g:7772:2: ( ruleConstraintRule )
            {
            // InternalOptimisationLanguage.g:7772:2: ( ruleConstraintRule )
            // InternalOptimisationLanguage.g:7773:3: ruleConstraintRule
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
    // InternalOptimisationLanguage.g:7782:1: rule__AttributeDefinitionRule__NameAssignment_1 : ( ruleStringOrId ) ;
    public final void rule__AttributeDefinitionRule__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7786:1: ( ( ruleStringOrId ) )
            // InternalOptimisationLanguage.g:7787:2: ( ruleStringOrId )
            {
            // InternalOptimisationLanguage.g:7787:2: ( ruleStringOrId )
            // InternalOptimisationLanguage.g:7788:3: ruleStringOrId
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
    // InternalOptimisationLanguage.g:7797:1: rule__AttributeDefinitionRule__OptionalAssignment_3 : ( ( 'optional' ) ) ;
    public final void rule__AttributeDefinitionRule__OptionalAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7801:1: ( ( ( 'optional' ) ) )
            // InternalOptimisationLanguage.g:7802:2: ( ( 'optional' ) )
            {
            // InternalOptimisationLanguage.g:7802:2: ( ( 'optional' ) )
            // InternalOptimisationLanguage.g:7803:3: ( 'optional' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getOptionalOptionalKeyword_3_0()); 
            }
            // InternalOptimisationLanguage.g:7804:3: ( 'optional' )
            // InternalOptimisationLanguage.g:7805:4: 'optional'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getOptionalOptionalKeyword_3_0()); 
            }
            match(input,94,FOLLOW_2); if (state.failed) return ;
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
    // InternalOptimisationLanguage.g:7816:1: rule__AttributeDefinitionRule__TypeAssignment_4 : ( ruleTypeRule ) ;
    public final void rule__AttributeDefinitionRule__TypeAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7820:1: ( ( ruleTypeRule ) )
            // InternalOptimisationLanguage.g:7821:2: ( ruleTypeRule )
            {
            // InternalOptimisationLanguage.g:7821:2: ( ruleTypeRule )
            // InternalOptimisationLanguage.g:7822:3: ruleTypeRule
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
    // InternalOptimisationLanguage.g:7831:1: rule__AttributeDefinitionRule__InitialisationAssignment_5_1 : ( ruleExpressionRule ) ;
    public final void rule__AttributeDefinitionRule__InitialisationAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7835:1: ( ( ruleExpressionRule ) )
            // InternalOptimisationLanguage.g:7836:2: ( ruleExpressionRule )
            {
            // InternalOptimisationLanguage.g:7836:2: ( ruleExpressionRule )
            // InternalOptimisationLanguage.g:7837:3: ruleExpressionRule
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
    // InternalOptimisationLanguage.g:7846:1: rule__EnumReferenceRule__DefinitionAssignment_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__EnumReferenceRule__DefinitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7850:1: ( ( ( ruleQualifiedName ) ) )
            // InternalOptimisationLanguage.g:7851:2: ( ( ruleQualifiedName ) )
            {
            // InternalOptimisationLanguage.g:7851:2: ( ( ruleQualifiedName ) )
            // InternalOptimisationLanguage.g:7852:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumReferenceRuleAccess().getDefinitionEnumDefinitionCrossReference_1_0()); 
            }
            // InternalOptimisationLanguage.g:7853:3: ( ruleQualifiedName )
            // InternalOptimisationLanguage.g:7854:4: ruleQualifiedName
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
    // InternalOptimisationLanguage.g:7865:1: rule__TypeReferenceRule__DefinitionAssignment_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__TypeReferenceRule__DefinitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7869:1: ( ( ( ruleQualifiedName ) ) )
            // InternalOptimisationLanguage.g:7870:2: ( ( ruleQualifiedName ) )
            {
            // InternalOptimisationLanguage.g:7870:2: ( ( ruleQualifiedName ) )
            // InternalOptimisationLanguage.g:7871:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeReferenceRuleAccess().getDefinitionClassDefinitionCrossReference_1_0()); 
            }
            // InternalOptimisationLanguage.g:7872:3: ( ruleQualifiedName )
            // InternalOptimisationLanguage.g:7873:4: ruleQualifiedName
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
    // InternalOptimisationLanguage.g:7884:1: rule__ArrayTypeRule__ElementsAssignment_1 : ( ruleTypeRule ) ;
    public final void rule__ArrayTypeRule__ElementsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7888:1: ( ( ruleTypeRule ) )
            // InternalOptimisationLanguage.g:7889:2: ( ruleTypeRule )
            {
            // InternalOptimisationLanguage.g:7889:2: ( ruleTypeRule )
            // InternalOptimisationLanguage.g:7890:3: ruleTypeRule
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
    // InternalOptimisationLanguage.g:7899:1: rule__ParameterRule__TypeAssignment_0 : ( ruleTypeRule ) ;
    public final void rule__ParameterRule__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7903:1: ( ( ruleTypeRule ) )
            // InternalOptimisationLanguage.g:7904:2: ( ruleTypeRule )
            {
            // InternalOptimisationLanguage.g:7904:2: ( ruleTypeRule )
            // InternalOptimisationLanguage.g:7905:3: ruleTypeRule
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
    // InternalOptimisationLanguage.g:7914:1: rule__ParameterRule__NameAssignment_1 : ( ruleStringOrId ) ;
    public final void rule__ParameterRule__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7918:1: ( ( ruleStringOrId ) )
            // InternalOptimisationLanguage.g:7919:2: ( ruleStringOrId )
            {
            // InternalOptimisationLanguage.g:7919:2: ( ruleStringOrId )
            // InternalOptimisationLanguage.g:7920:3: ruleStringOrId
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
    // InternalOptimisationLanguage.g:7929:1: rule__ImportRule__LanguageAssignment_1 : ( RULE_STRING ) ;
    public final void rule__ImportRule__LanguageAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7933:1: ( ( RULE_STRING ) )
            // InternalOptimisationLanguage.g:7934:2: ( RULE_STRING )
            {
            // InternalOptimisationLanguage.g:7934:2: ( RULE_STRING )
            // InternalOptimisationLanguage.g:7935:3: RULE_STRING
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
    // InternalOptimisationLanguage.g:7944:1: rule__ImportRule__ImportedNamespaceAssignment_3 : ( ruleQualifiedName ) ;
    public final void rule__ImportRule__ImportedNamespaceAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:7948:1: ( ( ruleQualifiedName ) )
            // InternalOptimisationLanguage.g:7949:2: ( ruleQualifiedName )
            {
            // InternalOptimisationLanguage.g:7949:2: ( ruleQualifiedName )
            // InternalOptimisationLanguage.g:7950:3: ruleQualifiedName
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

    // $ANTLR start synpred83_InternalOptimisationLanguage
    public final void synpred83_InternalOptimisationLanguage_fragment() throws RecognitionException {   
        // InternalOptimisationLanguage.g:6700:3: ( rule__QualifiedName__Group_1__0 )
        // InternalOptimisationLanguage.g:6700:3: rule__QualifiedName__Group_1__0
        {
        pushFollow(FOLLOW_2);
        rule__QualifiedName__Group_1__0();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred83_InternalOptimisationLanguage

    // Delegated rules

    public final boolean synpred83_InternalOptimisationLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred83_InternalOptimisationLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA2 dfa2 = new DFA2(this);
    static final String dfa_1s = "\13\uffff";
    static final String dfa_2s = "\2\uffff\2\6\5\uffff\2\6";
    static final String dfa_3s = "\1\4\1\uffff\2\20\3\uffff\1\4\1\uffff\2\20";
    static final String dfa_4s = "\1\135\1\uffff\2\111\3\uffff\1\5\1\uffff\2\111";
    static final String dfa_5s = "\1\uffff\1\1\2\uffff\1\3\1\4\1\5\1\uffff\1\2\2\uffff";
    static final String dfa_6s = "\13\uffff}>";
    static final String[] dfa_7s = {
            "\1\2\1\3\3\4\6\uffff\1\4\66\uffff\1\1\1\uffff\1\5\1\uffff\5\6\16\uffff\1\4",
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
            return "1570:1: rule__ReadExpressionRule__Alternatives : ( ( ruleArrayRule ) | ( ruleCallRule ) | ( ruleLiteralRule ) | ( ruleParanthesesRule ) | ( ruleReferenceRule ) );";
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
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x00000000000081F0L,0x0000000020000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0202000000000030L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000C081F0L,0x0000000030007D40L});
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
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000C081F0L,0x0000000030007DC0L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000C081F0L,0x0000000030007F40L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0002000000000030L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x00007FFFF8000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000008000L,0x0000000020000000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000000L,0x0000000043FE6000L});
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
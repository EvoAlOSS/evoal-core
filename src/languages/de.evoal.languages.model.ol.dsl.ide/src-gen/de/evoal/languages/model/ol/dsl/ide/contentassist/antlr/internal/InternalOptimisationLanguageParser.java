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

@SuppressWarnings("all")
public class InternalOptimisationLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_QUOTED_ID", "RULE_ID", "RULE_DOUBLE", "RULE_INT", "RULE_STRING", "RULE_DIGIT", "RULE_EXPONENT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'false'", "'>='", "'>'", "'='", "'!='", "'<'", "'<='", "'+'", "'-'", "'*'", "'/'", "'%'", "'Y'", "'Z'", "'E'", "'P'", "'T'", "'G'", "'M'", "'k'", "'h'", "'da'", "'d'", "'c'", "'m'", "'\\u00B5'", "'n'", "'p'", "'f'", "'a'", "'z'", "'y'", "'import'", "';'", "'declare'", "'as'", "'documenting'", "':='", "'instance'", "'for'", "'with'", "'algorithm'", "'{'", "'}'", "'['", "']'", "','", "'data'", "'.'", "'OR'", "'XOR'", "'AND'", "'^'", "'('", "')'", "'value'", "':'", "'literal'", "'|'", "'string'", "'expression'", "'int'", "'float'", "'boolean'", "'void'", "'array'", "'!'", "'true'"
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
    // InternalOptimisationLanguage.g:54:1: entryRuleOptimisationModelRule : ruleOptimisationModelRule EOF ;
    public final void entryRuleOptimisationModelRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:55:1: ( ruleOptimisationModelRule EOF )
            // InternalOptimisationLanguage.g:56:1: ruleOptimisationModelRule EOF
            {
             before(grammarAccess.getOptimisationModelRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleOptimisationModelRule();

            state._fsp--;

             after(grammarAccess.getOptimisationModelRuleRule()); 
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
    // $ANTLR end "entryRuleOptimisationModelRule"


    // $ANTLR start "ruleOptimisationModelRule"
    // InternalOptimisationLanguage.g:63:1: ruleOptimisationModelRule : ( ( rule__OptimisationModelRule__Group__0 ) ) ;
    public final void ruleOptimisationModelRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:67:2: ( ( ( rule__OptimisationModelRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:68:2: ( ( rule__OptimisationModelRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:68:2: ( ( rule__OptimisationModelRule__Group__0 ) )
            // InternalOptimisationLanguage.g:69:3: ( rule__OptimisationModelRule__Group__0 )
            {
             before(grammarAccess.getOptimisationModelRuleAccess().getGroup()); 
            // InternalOptimisationLanguage.g:70:3: ( rule__OptimisationModelRule__Group__0 )
            // InternalOptimisationLanguage.g:70:4: rule__OptimisationModelRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__OptimisationModelRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getOptimisationModelRuleAccess().getGroup()); 

            }


            }

        }
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


    // $ANTLR start "entryRuleImportRule"
    // InternalOptimisationLanguage.g:79:1: entryRuleImportRule : ruleImportRule EOF ;
    public final void entryRuleImportRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:80:1: ( ruleImportRule EOF )
            // InternalOptimisationLanguage.g:81:1: ruleImportRule EOF
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
    // InternalOptimisationLanguage.g:88:1: ruleImportRule : ( ( rule__ImportRule__Group__0 ) ) ;
    public final void ruleImportRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:92:2: ( ( ( rule__ImportRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:93:2: ( ( rule__ImportRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:93:2: ( ( rule__ImportRule__Group__0 ) )
            // InternalOptimisationLanguage.g:94:3: ( rule__ImportRule__Group__0 )
            {
             before(grammarAccess.getImportRuleAccess().getGroup()); 
            // InternalOptimisationLanguage.g:95:3: ( rule__ImportRule__Group__0 )
            // InternalOptimisationLanguage.g:95:4: rule__ImportRule__Group__0
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


    // $ANTLR start "entryRuleProblemRule"
    // InternalOptimisationLanguage.g:104:1: entryRuleProblemRule : ruleProblemRule EOF ;
    public final void entryRuleProblemRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:105:1: ( ruleProblemRule EOF )
            // InternalOptimisationLanguage.g:106:1: ruleProblemRule EOF
            {
             before(grammarAccess.getProblemRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleProblemRule();

            state._fsp--;

             after(grammarAccess.getProblemRuleRule()); 
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
    // $ANTLR end "entryRuleProblemRule"


    // $ANTLR start "ruleProblemRule"
    // InternalOptimisationLanguage.g:113:1: ruleProblemRule : ( ( rule__ProblemRule__Group__0 ) ) ;
    public final void ruleProblemRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:117:2: ( ( ( rule__ProblemRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:118:2: ( ( rule__ProblemRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:118:2: ( ( rule__ProblemRule__Group__0 ) )
            // InternalOptimisationLanguage.g:119:3: ( rule__ProblemRule__Group__0 )
            {
             before(grammarAccess.getProblemRuleAccess().getGroup()); 
            // InternalOptimisationLanguage.g:120:3: ( rule__ProblemRule__Group__0 )
            // InternalOptimisationLanguage.g:120:4: rule__ProblemRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ProblemRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getProblemRuleAccess().getGroup()); 

            }


            }

        }
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
    // InternalOptimisationLanguage.g:129:1: entryRuleAlgorithmInstanceRule : ruleAlgorithmInstanceRule EOF ;
    public final void entryRuleAlgorithmInstanceRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:130:1: ( ruleAlgorithmInstanceRule EOF )
            // InternalOptimisationLanguage.g:131:1: ruleAlgorithmInstanceRule EOF
            {
             before(grammarAccess.getAlgorithmInstanceRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleAlgorithmInstanceRule();

            state._fsp--;

             after(grammarAccess.getAlgorithmInstanceRuleRule()); 
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
    // $ANTLR end "entryRuleAlgorithmInstanceRule"


    // $ANTLR start "ruleAlgorithmInstanceRule"
    // InternalOptimisationLanguage.g:138:1: ruleAlgorithmInstanceRule : ( ( rule__AlgorithmInstanceRule__Group__0 ) ) ;
    public final void ruleAlgorithmInstanceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:142:2: ( ( ( rule__AlgorithmInstanceRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:143:2: ( ( rule__AlgorithmInstanceRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:143:2: ( ( rule__AlgorithmInstanceRule__Group__0 ) )
            // InternalOptimisationLanguage.g:144:3: ( rule__AlgorithmInstanceRule__Group__0 )
            {
             before(grammarAccess.getAlgorithmInstanceRuleAccess().getGroup()); 
            // InternalOptimisationLanguage.g:145:3: ( rule__AlgorithmInstanceRule__Group__0 )
            // InternalOptimisationLanguage.g:145:4: rule__AlgorithmInstanceRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__AlgorithmInstanceRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAlgorithmInstanceRuleAccess().getGroup()); 

            }


            }

        }
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


    // $ANTLR start "entryRuleInstanceRule"
    // InternalOptimisationLanguage.g:154:1: entryRuleInstanceRule : ruleInstanceRule EOF ;
    public final void entryRuleInstanceRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:155:1: ( ruleInstanceRule EOF )
            // InternalOptimisationLanguage.g:156:1: ruleInstanceRule EOF
            {
             before(grammarAccess.getInstanceRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleInstanceRule();

            state._fsp--;

             after(grammarAccess.getInstanceRuleRule()); 
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
    // $ANTLR end "entryRuleInstanceRule"


    // $ANTLR start "ruleInstanceRule"
    // InternalOptimisationLanguage.g:163:1: ruleInstanceRule : ( ( rule__InstanceRule__Group__0 ) ) ;
    public final void ruleInstanceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:167:2: ( ( ( rule__InstanceRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:168:2: ( ( rule__InstanceRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:168:2: ( ( rule__InstanceRule__Group__0 ) )
            // InternalOptimisationLanguage.g:169:3: ( rule__InstanceRule__Group__0 )
            {
             before(grammarAccess.getInstanceRuleAccess().getGroup()); 
            // InternalOptimisationLanguage.g:170:3: ( rule__InstanceRule__Group__0 )
            // InternalOptimisationLanguage.g:170:4: rule__InstanceRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__InstanceRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getInstanceRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleInstanceRule"


    // $ANTLR start "entryRuleAttributeRule"
    // InternalOptimisationLanguage.g:179:1: entryRuleAttributeRule : ruleAttributeRule EOF ;
    public final void entryRuleAttributeRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:180:1: ( ruleAttributeRule EOF )
            // InternalOptimisationLanguage.g:181:1: ruleAttributeRule EOF
            {
             before(grammarAccess.getAttributeRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleAttributeRule();

            state._fsp--;

             after(grammarAccess.getAttributeRuleRule()); 
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
    // $ANTLR end "entryRuleAttributeRule"


    // $ANTLR start "ruleAttributeRule"
    // InternalOptimisationLanguage.g:188:1: ruleAttributeRule : ( ( rule__AttributeRule__Group__0 ) ) ;
    public final void ruleAttributeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:192:2: ( ( ( rule__AttributeRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:193:2: ( ( rule__AttributeRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:193:2: ( ( rule__AttributeRule__Group__0 ) )
            // InternalOptimisationLanguage.g:194:3: ( rule__AttributeRule__Group__0 )
            {
             before(grammarAccess.getAttributeRuleAccess().getGroup()); 
            // InternalOptimisationLanguage.g:195:3: ( rule__AttributeRule__Group__0 )
            // InternalOptimisationLanguage.g:195:4: rule__AttributeRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__AttributeRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAttributeRuleAccess().getGroup()); 

            }


            }

        }
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


    // $ANTLR start "entryRuleValueRule"
    // InternalOptimisationLanguage.g:204:1: entryRuleValueRule : ruleValueRule EOF ;
    public final void entryRuleValueRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:205:1: ( ruleValueRule EOF )
            // InternalOptimisationLanguage.g:206:1: ruleValueRule EOF
            {
             before(grammarAccess.getValueRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleValueRule();

            state._fsp--;

             after(grammarAccess.getValueRuleRule()); 
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
    // $ANTLR end "entryRuleValueRule"


    // $ANTLR start "ruleValueRule"
    // InternalOptimisationLanguage.g:213:1: ruleValueRule : ( ( rule__ValueRule__Alternatives ) ) ;
    public final void ruleValueRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:217:2: ( ( ( rule__ValueRule__Alternatives ) ) )
            // InternalOptimisationLanguage.g:218:2: ( ( rule__ValueRule__Alternatives ) )
            {
            // InternalOptimisationLanguage.g:218:2: ( ( rule__ValueRule__Alternatives ) )
            // InternalOptimisationLanguage.g:219:3: ( rule__ValueRule__Alternatives )
            {
             before(grammarAccess.getValueRuleAccess().getAlternatives()); 
            // InternalOptimisationLanguage.g:220:3: ( rule__ValueRule__Alternatives )
            // InternalOptimisationLanguage.g:220:4: rule__ValueRule__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__ValueRule__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getValueRuleAccess().getAlternatives()); 

            }


            }

        }
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
    // InternalOptimisationLanguage.g:229:1: entryRuleArrayRule : ruleArrayRule EOF ;
    public final void entryRuleArrayRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:230:1: ( ruleArrayRule EOF )
            // InternalOptimisationLanguage.g:231:1: ruleArrayRule EOF
            {
             before(grammarAccess.getArrayRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleArrayRule();

            state._fsp--;

             after(grammarAccess.getArrayRuleRule()); 
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
    // $ANTLR end "entryRuleArrayRule"


    // $ANTLR start "ruleArrayRule"
    // InternalOptimisationLanguage.g:238:1: ruleArrayRule : ( ( rule__ArrayRule__Group__0 ) ) ;
    public final void ruleArrayRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:242:2: ( ( ( rule__ArrayRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:243:2: ( ( rule__ArrayRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:243:2: ( ( rule__ArrayRule__Group__0 ) )
            // InternalOptimisationLanguage.g:244:3: ( rule__ArrayRule__Group__0 )
            {
             before(grammarAccess.getArrayRuleAccess().getGroup()); 
            // InternalOptimisationLanguage.g:245:3: ( rule__ArrayRule__Group__0 )
            // InternalOptimisationLanguage.g:245:4: rule__ArrayRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ArrayRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getArrayRuleAccess().getGroup()); 

            }


            }

        }
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


    // $ANTLR start "entryRuleLiteralValueRule"
    // InternalOptimisationLanguage.g:254:1: entryRuleLiteralValueRule : ruleLiteralValueRule EOF ;
    public final void entryRuleLiteralValueRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:255:1: ( ruleLiteralValueRule EOF )
            // InternalOptimisationLanguage.g:256:1: ruleLiteralValueRule EOF
            {
             before(grammarAccess.getLiteralValueRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleLiteralValueRule();

            state._fsp--;

             after(grammarAccess.getLiteralValueRuleRule()); 
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
    // $ANTLR end "entryRuleLiteralValueRule"


    // $ANTLR start "ruleLiteralValueRule"
    // InternalOptimisationLanguage.g:263:1: ruleLiteralValueRule : ( ( rule__LiteralValueRule__LiteralAssignment ) ) ;
    public final void ruleLiteralValueRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:267:2: ( ( ( rule__LiteralValueRule__LiteralAssignment ) ) )
            // InternalOptimisationLanguage.g:268:2: ( ( rule__LiteralValueRule__LiteralAssignment ) )
            {
            // InternalOptimisationLanguage.g:268:2: ( ( rule__LiteralValueRule__LiteralAssignment ) )
            // InternalOptimisationLanguage.g:269:3: ( rule__LiteralValueRule__LiteralAssignment )
            {
             before(grammarAccess.getLiteralValueRuleAccess().getLiteralAssignment()); 
            // InternalOptimisationLanguage.g:270:3: ( rule__LiteralValueRule__LiteralAssignment )
            // InternalOptimisationLanguage.g:270:4: rule__LiteralValueRule__LiteralAssignment
            {
            pushFollow(FOLLOW_2);
            rule__LiteralValueRule__LiteralAssignment();

            state._fsp--;


            }

             after(grammarAccess.getLiteralValueRuleAccess().getLiteralAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLiteralValueRule"


    // $ANTLR start "entryRuleDataReferenceRule"
    // InternalOptimisationLanguage.g:279:1: entryRuleDataReferenceRule : ruleDataReferenceRule EOF ;
    public final void entryRuleDataReferenceRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:280:1: ( ruleDataReferenceRule EOF )
            // InternalOptimisationLanguage.g:281:1: ruleDataReferenceRule EOF
            {
             before(grammarAccess.getDataReferenceRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleDataReferenceRule();

            state._fsp--;

             after(grammarAccess.getDataReferenceRuleRule()); 
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
    // $ANTLR end "entryRuleDataReferenceRule"


    // $ANTLR start "ruleDataReferenceRule"
    // InternalOptimisationLanguage.g:288:1: ruleDataReferenceRule : ( ( rule__DataReferenceRule__Group__0 ) ) ;
    public final void ruleDataReferenceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:292:2: ( ( ( rule__DataReferenceRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:293:2: ( ( rule__DataReferenceRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:293:2: ( ( rule__DataReferenceRule__Group__0 ) )
            // InternalOptimisationLanguage.g:294:3: ( rule__DataReferenceRule__Group__0 )
            {
             before(grammarAccess.getDataReferenceRuleAccess().getGroup()); 
            // InternalOptimisationLanguage.g:295:3: ( rule__DataReferenceRule__Group__0 )
            // InternalOptimisationLanguage.g:295:4: rule__DataReferenceRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DataReferenceRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDataReferenceRuleAccess().getGroup()); 

            }


            }

        }
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


    // $ANTLR start "entryRuleQualifiedNameRule"
    // InternalOptimisationLanguage.g:304:1: entryRuleQualifiedNameRule : ruleQualifiedNameRule EOF ;
    public final void entryRuleQualifiedNameRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:305:1: ( ruleQualifiedNameRule EOF )
            // InternalOptimisationLanguage.g:306:1: ruleQualifiedNameRule EOF
            {
             before(grammarAccess.getQualifiedNameRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleQualifiedNameRule();

            state._fsp--;

             after(grammarAccess.getQualifiedNameRuleRule()); 
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
    // $ANTLR end "entryRuleQualifiedNameRule"


    // $ANTLR start "ruleQualifiedNameRule"
    // InternalOptimisationLanguage.g:313:1: ruleQualifiedNameRule : ( ( rule__QualifiedNameRule__Group__0 ) ) ;
    public final void ruleQualifiedNameRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:317:2: ( ( ( rule__QualifiedNameRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:318:2: ( ( rule__QualifiedNameRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:318:2: ( ( rule__QualifiedNameRule__Group__0 ) )
            // InternalOptimisationLanguage.g:319:3: ( rule__QualifiedNameRule__Group__0 )
            {
             before(grammarAccess.getQualifiedNameRuleAccess().getGroup()); 
            // InternalOptimisationLanguage.g:320:3: ( rule__QualifiedNameRule__Group__0 )
            // InternalOptimisationLanguage.g:320:4: rule__QualifiedNameRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedNameRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQualifiedNameRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQualifiedNameRule"


    // $ANTLR start "entryRuleExpressionRule"
    // InternalOptimisationLanguage.g:329:1: entryRuleExpressionRule : ruleExpressionRule EOF ;
    public final void entryRuleExpressionRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:330:1: ( ruleExpressionRule EOF )
            // InternalOptimisationLanguage.g:331:1: ruleExpressionRule EOF
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
    // InternalOptimisationLanguage.g:338:1: ruleExpressionRule : ( ruleOrExpressionRule ) ;
    public final void ruleExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:342:2: ( ( ruleOrExpressionRule ) )
            // InternalOptimisationLanguage.g:343:2: ( ruleOrExpressionRule )
            {
            // InternalOptimisationLanguage.g:343:2: ( ruleOrExpressionRule )
            // InternalOptimisationLanguage.g:344:3: ruleOrExpressionRule
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
    // InternalOptimisationLanguage.g:354:1: entryRuleOrExpressionRule : ruleOrExpressionRule EOF ;
    public final void entryRuleOrExpressionRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:355:1: ( ruleOrExpressionRule EOF )
            // InternalOptimisationLanguage.g:356:1: ruleOrExpressionRule EOF
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
    // InternalOptimisationLanguage.g:363:1: ruleOrExpressionRule : ( ( rule__OrExpressionRule__Group__0 ) ) ;
    public final void ruleOrExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:367:2: ( ( ( rule__OrExpressionRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:368:2: ( ( rule__OrExpressionRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:368:2: ( ( rule__OrExpressionRule__Group__0 ) )
            // InternalOptimisationLanguage.g:369:3: ( rule__OrExpressionRule__Group__0 )
            {
             before(grammarAccess.getOrExpressionRuleAccess().getGroup()); 
            // InternalOptimisationLanguage.g:370:3: ( rule__OrExpressionRule__Group__0 )
            // InternalOptimisationLanguage.g:370:4: rule__OrExpressionRule__Group__0
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
    // InternalOptimisationLanguage.g:379:1: entryRuleXorExpressionRule : ruleXorExpressionRule EOF ;
    public final void entryRuleXorExpressionRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:380:1: ( ruleXorExpressionRule EOF )
            // InternalOptimisationLanguage.g:381:1: ruleXorExpressionRule EOF
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
    // InternalOptimisationLanguage.g:388:1: ruleXorExpressionRule : ( ( rule__XorExpressionRule__Group__0 ) ) ;
    public final void ruleXorExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:392:2: ( ( ( rule__XorExpressionRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:393:2: ( ( rule__XorExpressionRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:393:2: ( ( rule__XorExpressionRule__Group__0 ) )
            // InternalOptimisationLanguage.g:394:3: ( rule__XorExpressionRule__Group__0 )
            {
             before(grammarAccess.getXorExpressionRuleAccess().getGroup()); 
            // InternalOptimisationLanguage.g:395:3: ( rule__XorExpressionRule__Group__0 )
            // InternalOptimisationLanguage.g:395:4: rule__XorExpressionRule__Group__0
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
    // InternalOptimisationLanguage.g:404:1: entryRuleAndExpressionRule : ruleAndExpressionRule EOF ;
    public final void entryRuleAndExpressionRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:405:1: ( ruleAndExpressionRule EOF )
            // InternalOptimisationLanguage.g:406:1: ruleAndExpressionRule EOF
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
    // InternalOptimisationLanguage.g:413:1: ruleAndExpressionRule : ( ( rule__AndExpressionRule__Group__0 ) ) ;
    public final void ruleAndExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:417:2: ( ( ( rule__AndExpressionRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:418:2: ( ( rule__AndExpressionRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:418:2: ( ( rule__AndExpressionRule__Group__0 ) )
            // InternalOptimisationLanguage.g:419:3: ( rule__AndExpressionRule__Group__0 )
            {
             before(grammarAccess.getAndExpressionRuleAccess().getGroup()); 
            // InternalOptimisationLanguage.g:420:3: ( rule__AndExpressionRule__Group__0 )
            // InternalOptimisationLanguage.g:420:4: rule__AndExpressionRule__Group__0
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
    // InternalOptimisationLanguage.g:429:1: entryRuleNotExpressionRule : ruleNotExpressionRule EOF ;
    public final void entryRuleNotExpressionRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:430:1: ( ruleNotExpressionRule EOF )
            // InternalOptimisationLanguage.g:431:1: ruleNotExpressionRule EOF
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
    // InternalOptimisationLanguage.g:438:1: ruleNotExpressionRule : ( ( rule__NotExpressionRule__Group__0 ) ) ;
    public final void ruleNotExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:442:2: ( ( ( rule__NotExpressionRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:443:2: ( ( rule__NotExpressionRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:443:2: ( ( rule__NotExpressionRule__Group__0 ) )
            // InternalOptimisationLanguage.g:444:3: ( rule__NotExpressionRule__Group__0 )
            {
             before(grammarAccess.getNotExpressionRuleAccess().getGroup()); 
            // InternalOptimisationLanguage.g:445:3: ( rule__NotExpressionRule__Group__0 )
            // InternalOptimisationLanguage.g:445:4: rule__NotExpressionRule__Group__0
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
    // InternalOptimisationLanguage.g:454:1: entryRuleComparisonExpressionRule : ruleComparisonExpressionRule EOF ;
    public final void entryRuleComparisonExpressionRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:455:1: ( ruleComparisonExpressionRule EOF )
            // InternalOptimisationLanguage.g:456:1: ruleComparisonExpressionRule EOF
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
    // InternalOptimisationLanguage.g:463:1: ruleComparisonExpressionRule : ( ( rule__ComparisonExpressionRule__Group__0 ) ) ;
    public final void ruleComparisonExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:467:2: ( ( ( rule__ComparisonExpressionRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:468:2: ( ( rule__ComparisonExpressionRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:468:2: ( ( rule__ComparisonExpressionRule__Group__0 ) )
            // InternalOptimisationLanguage.g:469:3: ( rule__ComparisonExpressionRule__Group__0 )
            {
             before(grammarAccess.getComparisonExpressionRuleAccess().getGroup()); 
            // InternalOptimisationLanguage.g:470:3: ( rule__ComparisonExpressionRule__Group__0 )
            // InternalOptimisationLanguage.g:470:4: rule__ComparisonExpressionRule__Group__0
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
    // InternalOptimisationLanguage.g:479:1: entryRulePartialComparisonExpressionRule : rulePartialComparisonExpressionRule EOF ;
    public final void entryRulePartialComparisonExpressionRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:480:1: ( rulePartialComparisonExpressionRule EOF )
            // InternalOptimisationLanguage.g:481:1: rulePartialComparisonExpressionRule EOF
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
    // InternalOptimisationLanguage.g:488:1: rulePartialComparisonExpressionRule : ( ( rule__PartialComparisonExpressionRule__Group__0 ) ) ;
    public final void rulePartialComparisonExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:492:2: ( ( ( rule__PartialComparisonExpressionRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:493:2: ( ( rule__PartialComparisonExpressionRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:493:2: ( ( rule__PartialComparisonExpressionRule__Group__0 ) )
            // InternalOptimisationLanguage.g:494:3: ( rule__PartialComparisonExpressionRule__Group__0 )
            {
             before(grammarAccess.getPartialComparisonExpressionRuleAccess().getGroup()); 
            // InternalOptimisationLanguage.g:495:3: ( rule__PartialComparisonExpressionRule__Group__0 )
            // InternalOptimisationLanguage.g:495:4: rule__PartialComparisonExpressionRule__Group__0
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
    // InternalOptimisationLanguage.g:504:1: entryRuleAddOrSubtractExpressionRule : ruleAddOrSubtractExpressionRule EOF ;
    public final void entryRuleAddOrSubtractExpressionRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:505:1: ( ruleAddOrSubtractExpressionRule EOF )
            // InternalOptimisationLanguage.g:506:1: ruleAddOrSubtractExpressionRule EOF
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
    // InternalOptimisationLanguage.g:513:1: ruleAddOrSubtractExpressionRule : ( ( rule__AddOrSubtractExpressionRule__Group__0 ) ) ;
    public final void ruleAddOrSubtractExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:517:2: ( ( ( rule__AddOrSubtractExpressionRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:518:2: ( ( rule__AddOrSubtractExpressionRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:518:2: ( ( rule__AddOrSubtractExpressionRule__Group__0 ) )
            // InternalOptimisationLanguage.g:519:3: ( rule__AddOrSubtractExpressionRule__Group__0 )
            {
             before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getGroup()); 
            // InternalOptimisationLanguage.g:520:3: ( rule__AddOrSubtractExpressionRule__Group__0 )
            // InternalOptimisationLanguage.g:520:4: rule__AddOrSubtractExpressionRule__Group__0
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
    // InternalOptimisationLanguage.g:529:1: entryRuleMultiplyDivideModuloExpressionRule : ruleMultiplyDivideModuloExpressionRule EOF ;
    public final void entryRuleMultiplyDivideModuloExpressionRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:530:1: ( ruleMultiplyDivideModuloExpressionRule EOF )
            // InternalOptimisationLanguage.g:531:1: ruleMultiplyDivideModuloExpressionRule EOF
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
    // InternalOptimisationLanguage.g:538:1: ruleMultiplyDivideModuloExpressionRule : ( ( rule__MultiplyDivideModuloExpressionRule__Group__0 ) ) ;
    public final void ruleMultiplyDivideModuloExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:542:2: ( ( ( rule__MultiplyDivideModuloExpressionRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:543:2: ( ( rule__MultiplyDivideModuloExpressionRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:543:2: ( ( rule__MultiplyDivideModuloExpressionRule__Group__0 ) )
            // InternalOptimisationLanguage.g:544:3: ( rule__MultiplyDivideModuloExpressionRule__Group__0 )
            {
             before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getGroup()); 
            // InternalOptimisationLanguage.g:545:3: ( rule__MultiplyDivideModuloExpressionRule__Group__0 )
            // InternalOptimisationLanguage.g:545:4: rule__MultiplyDivideModuloExpressionRule__Group__0
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
    // InternalOptimisationLanguage.g:554:1: entryRulePowerOfExpressionRule : rulePowerOfExpressionRule EOF ;
    public final void entryRulePowerOfExpressionRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:555:1: ( rulePowerOfExpressionRule EOF )
            // InternalOptimisationLanguage.g:556:1: rulePowerOfExpressionRule EOF
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
    // InternalOptimisationLanguage.g:563:1: rulePowerOfExpressionRule : ( ( rule__PowerOfExpressionRule__Group__0 ) ) ;
    public final void rulePowerOfExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:567:2: ( ( ( rule__PowerOfExpressionRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:568:2: ( ( rule__PowerOfExpressionRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:568:2: ( ( rule__PowerOfExpressionRule__Group__0 ) )
            // InternalOptimisationLanguage.g:569:3: ( rule__PowerOfExpressionRule__Group__0 )
            {
             before(grammarAccess.getPowerOfExpressionRuleAccess().getGroup()); 
            // InternalOptimisationLanguage.g:570:3: ( rule__PowerOfExpressionRule__Group__0 )
            // InternalOptimisationLanguage.g:570:4: rule__PowerOfExpressionRule__Group__0
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
    // InternalOptimisationLanguage.g:579:1: entryRuleUnaryAddOrSubtractExpressionRule : ruleUnaryAddOrSubtractExpressionRule EOF ;
    public final void entryRuleUnaryAddOrSubtractExpressionRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:580:1: ( ruleUnaryAddOrSubtractExpressionRule EOF )
            // InternalOptimisationLanguage.g:581:1: ruleUnaryAddOrSubtractExpressionRule EOF
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
    // InternalOptimisationLanguage.g:588:1: ruleUnaryAddOrSubtractExpressionRule : ( ( rule__UnaryAddOrSubtractExpressionRule__Group__0 ) ) ;
    public final void ruleUnaryAddOrSubtractExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:592:2: ( ( ( rule__UnaryAddOrSubtractExpressionRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:593:2: ( ( rule__UnaryAddOrSubtractExpressionRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:593:2: ( ( rule__UnaryAddOrSubtractExpressionRule__Group__0 ) )
            // InternalOptimisationLanguage.g:594:3: ( rule__UnaryAddOrSubtractExpressionRule__Group__0 )
            {
             before(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getGroup()); 
            // InternalOptimisationLanguage.g:595:3: ( rule__UnaryAddOrSubtractExpressionRule__Group__0 )
            // InternalOptimisationLanguage.g:595:4: rule__UnaryAddOrSubtractExpressionRule__Group__0
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
    // InternalOptimisationLanguage.g:604:1: entryRuleLiteralOrReferenceRule : ruleLiteralOrReferenceRule EOF ;
    public final void entryRuleLiteralOrReferenceRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:605:1: ( ruleLiteralOrReferenceRule EOF )
            // InternalOptimisationLanguage.g:606:1: ruleLiteralOrReferenceRule EOF
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
    // InternalOptimisationLanguage.g:613:1: ruleLiteralOrReferenceRule : ( ( rule__LiteralOrReferenceRule__Alternatives ) ) ;
    public final void ruleLiteralOrReferenceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:617:2: ( ( ( rule__LiteralOrReferenceRule__Alternatives ) ) )
            // InternalOptimisationLanguage.g:618:2: ( ( rule__LiteralOrReferenceRule__Alternatives ) )
            {
            // InternalOptimisationLanguage.g:618:2: ( ( rule__LiteralOrReferenceRule__Alternatives ) )
            // InternalOptimisationLanguage.g:619:3: ( rule__LiteralOrReferenceRule__Alternatives )
            {
             before(grammarAccess.getLiteralOrReferenceRuleAccess().getAlternatives()); 
            // InternalOptimisationLanguage.g:620:3: ( rule__LiteralOrReferenceRule__Alternatives )
            // InternalOptimisationLanguage.g:620:4: rule__LiteralOrReferenceRule__Alternatives
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
    // InternalOptimisationLanguage.g:629:1: entryRuleParanthesesRule : ruleParanthesesRule EOF ;
    public final void entryRuleParanthesesRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:630:1: ( ruleParanthesesRule EOF )
            // InternalOptimisationLanguage.g:631:1: ruleParanthesesRule EOF
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
    // InternalOptimisationLanguage.g:638:1: ruleParanthesesRule : ( ( rule__ParanthesesRule__Group__0 ) ) ;
    public final void ruleParanthesesRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:642:2: ( ( ( rule__ParanthesesRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:643:2: ( ( rule__ParanthesesRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:643:2: ( ( rule__ParanthesesRule__Group__0 ) )
            // InternalOptimisationLanguage.g:644:3: ( rule__ParanthesesRule__Group__0 )
            {
             before(grammarAccess.getParanthesesRuleAccess().getGroup()); 
            // InternalOptimisationLanguage.g:645:3: ( rule__ParanthesesRule__Group__0 )
            // InternalOptimisationLanguage.g:645:4: rule__ParanthesesRule__Group__0
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
    // InternalOptimisationLanguage.g:654:1: entryRuleCallRule : ruleCallRule EOF ;
    public final void entryRuleCallRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:655:1: ( ruleCallRule EOF )
            // InternalOptimisationLanguage.g:656:1: ruleCallRule EOF
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
    // InternalOptimisationLanguage.g:663:1: ruleCallRule : ( ( rule__CallRule__Group__0 ) ) ;
    public final void ruleCallRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:667:2: ( ( ( rule__CallRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:668:2: ( ( rule__CallRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:668:2: ( ( rule__CallRule__Group__0 ) )
            // InternalOptimisationLanguage.g:669:3: ( rule__CallRule__Group__0 )
            {
             before(grammarAccess.getCallRuleAccess().getGroup()); 
            // InternalOptimisationLanguage.g:670:3: ( rule__CallRule__Group__0 )
            // InternalOptimisationLanguage.g:670:4: rule__CallRule__Group__0
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
    // InternalOptimisationLanguage.g:679:1: entryRuleValueReferenceRule : ruleValueReferenceRule EOF ;
    public final void entryRuleValueReferenceRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:680:1: ( ruleValueReferenceRule EOF )
            // InternalOptimisationLanguage.g:681:1: ruleValueReferenceRule EOF
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
    // InternalOptimisationLanguage.g:688:1: ruleValueReferenceRule : ( ( rule__ValueReferenceRule__Group__0 ) ) ;
    public final void ruleValueReferenceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:692:2: ( ( ( rule__ValueReferenceRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:693:2: ( ( rule__ValueReferenceRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:693:2: ( ( rule__ValueReferenceRule__Group__0 ) )
            // InternalOptimisationLanguage.g:694:3: ( rule__ValueReferenceRule__Group__0 )
            {
             before(grammarAccess.getValueReferenceRuleAccess().getGroup()); 
            // InternalOptimisationLanguage.g:695:3: ( rule__ValueReferenceRule__Group__0 )
            // InternalOptimisationLanguage.g:695:4: rule__ValueReferenceRule__Group__0
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
    // InternalOptimisationLanguage.g:704:1: entryRuleLiteralRule : ruleLiteralRule EOF ;
    public final void entryRuleLiteralRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:705:1: ( ruleLiteralRule EOF )
            // InternalOptimisationLanguage.g:706:1: ruleLiteralRule EOF
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
    // InternalOptimisationLanguage.g:713:1: ruleLiteralRule : ( ( rule__LiteralRule__Alternatives ) ) ;
    public final void ruleLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:717:2: ( ( ( rule__LiteralRule__Alternatives ) ) )
            // InternalOptimisationLanguage.g:718:2: ( ( rule__LiteralRule__Alternatives ) )
            {
            // InternalOptimisationLanguage.g:718:2: ( ( rule__LiteralRule__Alternatives ) )
            // InternalOptimisationLanguage.g:719:3: ( rule__LiteralRule__Alternatives )
            {
             before(grammarAccess.getLiteralRuleAccess().getAlternatives()); 
            // InternalOptimisationLanguage.g:720:3: ( rule__LiteralRule__Alternatives )
            // InternalOptimisationLanguage.g:720:4: rule__LiteralRule__Alternatives
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
    // InternalOptimisationLanguage.g:729:1: entryRuleNumberLiteralRule : ruleNumberLiteralRule EOF ;
    public final void entryRuleNumberLiteralRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:730:1: ( ruleNumberLiteralRule EOF )
            // InternalOptimisationLanguage.g:731:1: ruleNumberLiteralRule EOF
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
    // InternalOptimisationLanguage.g:738:1: ruleNumberLiteralRule : ( ( rule__NumberLiteralRule__Alternatives ) ) ;
    public final void ruleNumberLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:742:2: ( ( ( rule__NumberLiteralRule__Alternatives ) ) )
            // InternalOptimisationLanguage.g:743:2: ( ( rule__NumberLiteralRule__Alternatives ) )
            {
            // InternalOptimisationLanguage.g:743:2: ( ( rule__NumberLiteralRule__Alternatives ) )
            // InternalOptimisationLanguage.g:744:3: ( rule__NumberLiteralRule__Alternatives )
            {
             before(grammarAccess.getNumberLiteralRuleAccess().getAlternatives()); 
            // InternalOptimisationLanguage.g:745:3: ( rule__NumberLiteralRule__Alternatives )
            // InternalOptimisationLanguage.g:745:4: rule__NumberLiteralRule__Alternatives
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
    // InternalOptimisationLanguage.g:754:1: entryRuleDoubleLiteralRule : ruleDoubleLiteralRule EOF ;
    public final void entryRuleDoubleLiteralRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:755:1: ( ruleDoubleLiteralRule EOF )
            // InternalOptimisationLanguage.g:756:1: ruleDoubleLiteralRule EOF
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
    // InternalOptimisationLanguage.g:763:1: ruleDoubleLiteralRule : ( ( rule__DoubleLiteralRule__Group__0 ) ) ;
    public final void ruleDoubleLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:767:2: ( ( ( rule__DoubleLiteralRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:768:2: ( ( rule__DoubleLiteralRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:768:2: ( ( rule__DoubleLiteralRule__Group__0 ) )
            // InternalOptimisationLanguage.g:769:3: ( rule__DoubleLiteralRule__Group__0 )
            {
             before(grammarAccess.getDoubleLiteralRuleAccess().getGroup()); 
            // InternalOptimisationLanguage.g:770:3: ( rule__DoubleLiteralRule__Group__0 )
            // InternalOptimisationLanguage.g:770:4: rule__DoubleLiteralRule__Group__0
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
    // InternalOptimisationLanguage.g:779:1: entryRuleIntegerLiteralRule : ruleIntegerLiteralRule EOF ;
    public final void entryRuleIntegerLiteralRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:780:1: ( ruleIntegerLiteralRule EOF )
            // InternalOptimisationLanguage.g:781:1: ruleIntegerLiteralRule EOF
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
    // InternalOptimisationLanguage.g:788:1: ruleIntegerLiteralRule : ( ( rule__IntegerLiteralRule__Group__0 ) ) ;
    public final void ruleIntegerLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:792:2: ( ( ( rule__IntegerLiteralRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:793:2: ( ( rule__IntegerLiteralRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:793:2: ( ( rule__IntegerLiteralRule__Group__0 ) )
            // InternalOptimisationLanguage.g:794:3: ( rule__IntegerLiteralRule__Group__0 )
            {
             before(grammarAccess.getIntegerLiteralRuleAccess().getGroup()); 
            // InternalOptimisationLanguage.g:795:3: ( rule__IntegerLiteralRule__Group__0 )
            // InternalOptimisationLanguage.g:795:4: rule__IntegerLiteralRule__Group__0
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
    // InternalOptimisationLanguage.g:804:1: entryRuleStringLiteralRule : ruleStringLiteralRule EOF ;
    public final void entryRuleStringLiteralRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:805:1: ( ruleStringLiteralRule EOF )
            // InternalOptimisationLanguage.g:806:1: ruleStringLiteralRule EOF
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
    // InternalOptimisationLanguage.g:813:1: ruleStringLiteralRule : ( ( rule__StringLiteralRule__ValueAssignment ) ) ;
    public final void ruleStringLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:817:2: ( ( ( rule__StringLiteralRule__ValueAssignment ) ) )
            // InternalOptimisationLanguage.g:818:2: ( ( rule__StringLiteralRule__ValueAssignment ) )
            {
            // InternalOptimisationLanguage.g:818:2: ( ( rule__StringLiteralRule__ValueAssignment ) )
            // InternalOptimisationLanguage.g:819:3: ( rule__StringLiteralRule__ValueAssignment )
            {
             before(grammarAccess.getStringLiteralRuleAccess().getValueAssignment()); 
            // InternalOptimisationLanguage.g:820:3: ( rule__StringLiteralRule__ValueAssignment )
            // InternalOptimisationLanguage.g:820:4: rule__StringLiteralRule__ValueAssignment
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
    // InternalOptimisationLanguage.g:829:1: entryRuleBooleanLiteralRule : ruleBooleanLiteralRule EOF ;
    public final void entryRuleBooleanLiteralRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:830:1: ( ruleBooleanLiteralRule EOF )
            // InternalOptimisationLanguage.g:831:1: ruleBooleanLiteralRule EOF
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
    // InternalOptimisationLanguage.g:838:1: ruleBooleanLiteralRule : ( ( rule__BooleanLiteralRule__Group__0 ) ) ;
    public final void ruleBooleanLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:842:2: ( ( ( rule__BooleanLiteralRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:843:2: ( ( rule__BooleanLiteralRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:843:2: ( ( rule__BooleanLiteralRule__Group__0 ) )
            // InternalOptimisationLanguage.g:844:3: ( rule__BooleanLiteralRule__Group__0 )
            {
             before(grammarAccess.getBooleanLiteralRuleAccess().getGroup()); 
            // InternalOptimisationLanguage.g:845:3: ( rule__BooleanLiteralRule__Group__0 )
            // InternalOptimisationLanguage.g:845:4: rule__BooleanLiteralRule__Group__0
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
    // InternalOptimisationLanguage.g:854:1: entryRuleAttributeDefinitionRule : ruleAttributeDefinitionRule EOF ;
    public final void entryRuleAttributeDefinitionRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:855:1: ( ruleAttributeDefinitionRule EOF )
            // InternalOptimisationLanguage.g:856:1: ruleAttributeDefinitionRule EOF
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
    // InternalOptimisationLanguage.g:863:1: ruleAttributeDefinitionRule : ( ( rule__AttributeDefinitionRule__Group__0 ) ) ;
    public final void ruleAttributeDefinitionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:867:2: ( ( ( rule__AttributeDefinitionRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:868:2: ( ( rule__AttributeDefinitionRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:868:2: ( ( rule__AttributeDefinitionRule__Group__0 ) )
            // InternalOptimisationLanguage.g:869:3: ( rule__AttributeDefinitionRule__Group__0 )
            {
             before(grammarAccess.getAttributeDefinitionRuleAccess().getGroup()); 
            // InternalOptimisationLanguage.g:870:3: ( rule__AttributeDefinitionRule__Group__0 )
            // InternalOptimisationLanguage.g:870:4: rule__AttributeDefinitionRule__Group__0
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
    // InternalOptimisationLanguage.g:879:1: entryRuleTypeRule : ruleTypeRule EOF ;
    public final void entryRuleTypeRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:880:1: ( ruleTypeRule EOF )
            // InternalOptimisationLanguage.g:881:1: ruleTypeRule EOF
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
    // InternalOptimisationLanguage.g:888:1: ruleTypeRule : ( ( rule__TypeRule__Alternatives ) ) ;
    public final void ruleTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:892:2: ( ( ( rule__TypeRule__Alternatives ) ) )
            // InternalOptimisationLanguage.g:893:2: ( ( rule__TypeRule__Alternatives ) )
            {
            // InternalOptimisationLanguage.g:893:2: ( ( rule__TypeRule__Alternatives ) )
            // InternalOptimisationLanguage.g:894:3: ( rule__TypeRule__Alternatives )
            {
             before(grammarAccess.getTypeRuleAccess().getAlternatives()); 
            // InternalOptimisationLanguage.g:895:3: ( rule__TypeRule__Alternatives )
            // InternalOptimisationLanguage.g:895:4: rule__TypeRule__Alternatives
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
    // InternalOptimisationLanguage.g:904:1: entryRuleLiteralTypeRule : ruleLiteralTypeRule EOF ;
    public final void entryRuleLiteralTypeRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:905:1: ( ruleLiteralTypeRule EOF )
            // InternalOptimisationLanguage.g:906:1: ruleLiteralTypeRule EOF
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
    // InternalOptimisationLanguage.g:913:1: ruleLiteralTypeRule : ( ( rule__LiteralTypeRule__Group__0 ) ) ;
    public final void ruleLiteralTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:917:2: ( ( ( rule__LiteralTypeRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:918:2: ( ( rule__LiteralTypeRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:918:2: ( ( rule__LiteralTypeRule__Group__0 ) )
            // InternalOptimisationLanguage.g:919:3: ( rule__LiteralTypeRule__Group__0 )
            {
             before(grammarAccess.getLiteralTypeRuleAccess().getGroup()); 
            // InternalOptimisationLanguage.g:920:3: ( rule__LiteralTypeRule__Group__0 )
            // InternalOptimisationLanguage.g:920:4: rule__LiteralTypeRule__Group__0
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
    // InternalOptimisationLanguage.g:929:1: entryRuleInstanceTypeRule : ruleInstanceTypeRule EOF ;
    public final void entryRuleInstanceTypeRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:930:1: ( ruleInstanceTypeRule EOF )
            // InternalOptimisationLanguage.g:931:1: ruleInstanceTypeRule EOF
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
    // InternalOptimisationLanguage.g:938:1: ruleInstanceTypeRule : ( ( rule__InstanceTypeRule__Group__0 ) ) ;
    public final void ruleInstanceTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:942:2: ( ( ( rule__InstanceTypeRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:943:2: ( ( rule__InstanceTypeRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:943:2: ( ( rule__InstanceTypeRule__Group__0 ) )
            // InternalOptimisationLanguage.g:944:3: ( rule__InstanceTypeRule__Group__0 )
            {
             before(grammarAccess.getInstanceTypeRuleAccess().getGroup()); 
            // InternalOptimisationLanguage.g:945:3: ( rule__InstanceTypeRule__Group__0 )
            // InternalOptimisationLanguage.g:945:4: rule__InstanceTypeRule__Group__0
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
    // InternalOptimisationLanguage.g:954:1: entryRuleStringTypeRule : ruleStringTypeRule EOF ;
    public final void entryRuleStringTypeRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:955:1: ( ruleStringTypeRule EOF )
            // InternalOptimisationLanguage.g:956:1: ruleStringTypeRule EOF
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
    // InternalOptimisationLanguage.g:963:1: ruleStringTypeRule : ( ( rule__StringTypeRule__Group__0 ) ) ;
    public final void ruleStringTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:967:2: ( ( ( rule__StringTypeRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:968:2: ( ( rule__StringTypeRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:968:2: ( ( rule__StringTypeRule__Group__0 ) )
            // InternalOptimisationLanguage.g:969:3: ( rule__StringTypeRule__Group__0 )
            {
             before(grammarAccess.getStringTypeRuleAccess().getGroup()); 
            // InternalOptimisationLanguage.g:970:3: ( rule__StringTypeRule__Group__0 )
            // InternalOptimisationLanguage.g:970:4: rule__StringTypeRule__Group__0
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
    // InternalOptimisationLanguage.g:979:1: entryRuleExpressionTypeRule : ruleExpressionTypeRule EOF ;
    public final void entryRuleExpressionTypeRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:980:1: ( ruleExpressionTypeRule EOF )
            // InternalOptimisationLanguage.g:981:1: ruleExpressionTypeRule EOF
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
    // InternalOptimisationLanguage.g:988:1: ruleExpressionTypeRule : ( ( rule__ExpressionTypeRule__Group__0 ) ) ;
    public final void ruleExpressionTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:992:2: ( ( ( rule__ExpressionTypeRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:993:2: ( ( rule__ExpressionTypeRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:993:2: ( ( rule__ExpressionTypeRule__Group__0 ) )
            // InternalOptimisationLanguage.g:994:3: ( rule__ExpressionTypeRule__Group__0 )
            {
             before(grammarAccess.getExpressionTypeRuleAccess().getGroup()); 
            // InternalOptimisationLanguage.g:995:3: ( rule__ExpressionTypeRule__Group__0 )
            // InternalOptimisationLanguage.g:995:4: rule__ExpressionTypeRule__Group__0
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
    // InternalOptimisationLanguage.g:1004:1: entryRuleIntTypeRule : ruleIntTypeRule EOF ;
    public final void entryRuleIntTypeRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:1005:1: ( ruleIntTypeRule EOF )
            // InternalOptimisationLanguage.g:1006:1: ruleIntTypeRule EOF
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
    // InternalOptimisationLanguage.g:1013:1: ruleIntTypeRule : ( ( rule__IntTypeRule__Group__0 ) ) ;
    public final void ruleIntTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1017:2: ( ( ( rule__IntTypeRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:1018:2: ( ( rule__IntTypeRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:1018:2: ( ( rule__IntTypeRule__Group__0 ) )
            // InternalOptimisationLanguage.g:1019:3: ( rule__IntTypeRule__Group__0 )
            {
             before(grammarAccess.getIntTypeRuleAccess().getGroup()); 
            // InternalOptimisationLanguage.g:1020:3: ( rule__IntTypeRule__Group__0 )
            // InternalOptimisationLanguage.g:1020:4: rule__IntTypeRule__Group__0
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
    // InternalOptimisationLanguage.g:1029:1: entryRuleFloatTypeRule : ruleFloatTypeRule EOF ;
    public final void entryRuleFloatTypeRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:1030:1: ( ruleFloatTypeRule EOF )
            // InternalOptimisationLanguage.g:1031:1: ruleFloatTypeRule EOF
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
    // InternalOptimisationLanguage.g:1038:1: ruleFloatTypeRule : ( ( rule__FloatTypeRule__Group__0 ) ) ;
    public final void ruleFloatTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1042:2: ( ( ( rule__FloatTypeRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:1043:2: ( ( rule__FloatTypeRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:1043:2: ( ( rule__FloatTypeRule__Group__0 ) )
            // InternalOptimisationLanguage.g:1044:3: ( rule__FloatTypeRule__Group__0 )
            {
             before(grammarAccess.getFloatTypeRuleAccess().getGroup()); 
            // InternalOptimisationLanguage.g:1045:3: ( rule__FloatTypeRule__Group__0 )
            // InternalOptimisationLanguage.g:1045:4: rule__FloatTypeRule__Group__0
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
    // InternalOptimisationLanguage.g:1054:1: entryRuleBooleanTypeRule : ruleBooleanTypeRule EOF ;
    public final void entryRuleBooleanTypeRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:1055:1: ( ruleBooleanTypeRule EOF )
            // InternalOptimisationLanguage.g:1056:1: ruleBooleanTypeRule EOF
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
    // InternalOptimisationLanguage.g:1063:1: ruleBooleanTypeRule : ( ( rule__BooleanTypeRule__Group__0 ) ) ;
    public final void ruleBooleanTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1067:2: ( ( ( rule__BooleanTypeRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:1068:2: ( ( rule__BooleanTypeRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:1068:2: ( ( rule__BooleanTypeRule__Group__0 ) )
            // InternalOptimisationLanguage.g:1069:3: ( rule__BooleanTypeRule__Group__0 )
            {
             before(grammarAccess.getBooleanTypeRuleAccess().getGroup()); 
            // InternalOptimisationLanguage.g:1070:3: ( rule__BooleanTypeRule__Group__0 )
            // InternalOptimisationLanguage.g:1070:4: rule__BooleanTypeRule__Group__0
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
    // InternalOptimisationLanguage.g:1079:1: entryRuleVoidTypeRule : ruleVoidTypeRule EOF ;
    public final void entryRuleVoidTypeRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:1080:1: ( ruleVoidTypeRule EOF )
            // InternalOptimisationLanguage.g:1081:1: ruleVoidTypeRule EOF
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
    // InternalOptimisationLanguage.g:1088:1: ruleVoidTypeRule : ( ( rule__VoidTypeRule__Group__0 ) ) ;
    public final void ruleVoidTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1092:2: ( ( ( rule__VoidTypeRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:1093:2: ( ( rule__VoidTypeRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:1093:2: ( ( rule__VoidTypeRule__Group__0 ) )
            // InternalOptimisationLanguage.g:1094:3: ( rule__VoidTypeRule__Group__0 )
            {
             before(grammarAccess.getVoidTypeRuleAccess().getGroup()); 
            // InternalOptimisationLanguage.g:1095:3: ( rule__VoidTypeRule__Group__0 )
            // InternalOptimisationLanguage.g:1095:4: rule__VoidTypeRule__Group__0
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
    // InternalOptimisationLanguage.g:1104:1: entryRuleDataTypeRule : ruleDataTypeRule EOF ;
    public final void entryRuleDataTypeRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:1105:1: ( ruleDataTypeRule EOF )
            // InternalOptimisationLanguage.g:1106:1: ruleDataTypeRule EOF
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
    // InternalOptimisationLanguage.g:1113:1: ruleDataTypeRule : ( ( rule__DataTypeRule__Group__0 ) ) ;
    public final void ruleDataTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1117:2: ( ( ( rule__DataTypeRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:1118:2: ( ( rule__DataTypeRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:1118:2: ( ( rule__DataTypeRule__Group__0 ) )
            // InternalOptimisationLanguage.g:1119:3: ( rule__DataTypeRule__Group__0 )
            {
             before(grammarAccess.getDataTypeRuleAccess().getGroup()); 
            // InternalOptimisationLanguage.g:1120:3: ( rule__DataTypeRule__Group__0 )
            // InternalOptimisationLanguage.g:1120:4: rule__DataTypeRule__Group__0
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
    // InternalOptimisationLanguage.g:1129:1: entryRuleArrayTypeRule : ruleArrayTypeRule EOF ;
    public final void entryRuleArrayTypeRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:1130:1: ( ruleArrayTypeRule EOF )
            // InternalOptimisationLanguage.g:1131:1: ruleArrayTypeRule EOF
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
    // InternalOptimisationLanguage.g:1138:1: ruleArrayTypeRule : ( ( rule__ArrayTypeRule__Group__0 ) ) ;
    public final void ruleArrayTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1142:2: ( ( ( rule__ArrayTypeRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:1143:2: ( ( rule__ArrayTypeRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:1143:2: ( ( rule__ArrayTypeRule__Group__0 ) )
            // InternalOptimisationLanguage.g:1144:3: ( rule__ArrayTypeRule__Group__0 )
            {
             before(grammarAccess.getArrayTypeRuleAccess().getGroup()); 
            // InternalOptimisationLanguage.g:1145:3: ( rule__ArrayTypeRule__Group__0 )
            // InternalOptimisationLanguage.g:1145:4: rule__ArrayTypeRule__Group__0
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
    // InternalOptimisationLanguage.g:1154:1: entryRuleParameterRule : ruleParameterRule EOF ;
    public final void entryRuleParameterRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:1155:1: ( ruleParameterRule EOF )
            // InternalOptimisationLanguage.g:1156:1: ruleParameterRule EOF
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
    // InternalOptimisationLanguage.g:1163:1: ruleParameterRule : ( ( rule__ParameterRule__Group__0 ) ) ;
    public final void ruleParameterRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1167:2: ( ( ( rule__ParameterRule__Group__0 ) ) )
            // InternalOptimisationLanguage.g:1168:2: ( ( rule__ParameterRule__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:1168:2: ( ( rule__ParameterRule__Group__0 ) )
            // InternalOptimisationLanguage.g:1169:3: ( rule__ParameterRule__Group__0 )
            {
             before(grammarAccess.getParameterRuleAccess().getGroup()); 
            // InternalOptimisationLanguage.g:1170:3: ( rule__ParameterRule__Group__0 )
            // InternalOptimisationLanguage.g:1170:4: rule__ParameterRule__Group__0
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
    // InternalOptimisationLanguage.g:1179:1: entryRuleFunctionNameRule : ruleFunctionNameRule EOF ;
    public final void entryRuleFunctionNameRule() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:1180:1: ( ruleFunctionNameRule EOF )
            // InternalOptimisationLanguage.g:1181:1: ruleFunctionNameRule EOF
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
    // InternalOptimisationLanguage.g:1188:1: ruleFunctionNameRule : ( ( rule__FunctionNameRule__DefinitionAssignment ) ) ;
    public final void ruleFunctionNameRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1192:2: ( ( ( rule__FunctionNameRule__DefinitionAssignment ) ) )
            // InternalOptimisationLanguage.g:1193:2: ( ( rule__FunctionNameRule__DefinitionAssignment ) )
            {
            // InternalOptimisationLanguage.g:1193:2: ( ( rule__FunctionNameRule__DefinitionAssignment ) )
            // InternalOptimisationLanguage.g:1194:3: ( rule__FunctionNameRule__DefinitionAssignment )
            {
             before(grammarAccess.getFunctionNameRuleAccess().getDefinitionAssignment()); 
            // InternalOptimisationLanguage.g:1195:3: ( rule__FunctionNameRule__DefinitionAssignment )
            // InternalOptimisationLanguage.g:1195:4: rule__FunctionNameRule__DefinitionAssignment
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
    // InternalOptimisationLanguage.g:1204:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:1205:1: ( ruleQualifiedName EOF )
            // InternalOptimisationLanguage.g:1206:1: ruleQualifiedName EOF
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
    // InternalOptimisationLanguage.g:1213:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1217:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // InternalOptimisationLanguage.g:1218:2: ( ( rule__QualifiedName__Group__0 ) )
            {
            // InternalOptimisationLanguage.g:1218:2: ( ( rule__QualifiedName__Group__0 ) )
            // InternalOptimisationLanguage.g:1219:3: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // InternalOptimisationLanguage.g:1220:3: ( rule__QualifiedName__Group__0 )
            // InternalOptimisationLanguage.g:1220:4: rule__QualifiedName__Group__0
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
    // InternalOptimisationLanguage.g:1229:1: entryRuleStringOrId : ruleStringOrId EOF ;
    public final void entryRuleStringOrId() throws RecognitionException {
        try {
            // InternalOptimisationLanguage.g:1230:1: ( ruleStringOrId EOF )
            // InternalOptimisationLanguage.g:1231:1: ruleStringOrId EOF
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
    // InternalOptimisationLanguage.g:1238:1: ruleStringOrId : ( ( rule__StringOrId__Alternatives ) ) ;
    public final void ruleStringOrId() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1242:2: ( ( ( rule__StringOrId__Alternatives ) ) )
            // InternalOptimisationLanguage.g:1243:2: ( ( rule__StringOrId__Alternatives ) )
            {
            // InternalOptimisationLanguage.g:1243:2: ( ( rule__StringOrId__Alternatives ) )
            // InternalOptimisationLanguage.g:1244:3: ( rule__StringOrId__Alternatives )
            {
             before(grammarAccess.getStringOrIdAccess().getAlternatives()); 
            // InternalOptimisationLanguage.g:1245:3: ( rule__StringOrId__Alternatives )
            // InternalOptimisationLanguage.g:1245:4: rule__StringOrId__Alternatives
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
    // InternalOptimisationLanguage.g:1254:1: ruleComparisonOperatorRule : ( ( rule__ComparisonOperatorRule__Alternatives ) ) ;
    public final void ruleComparisonOperatorRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1258:1: ( ( ( rule__ComparisonOperatorRule__Alternatives ) ) )
            // InternalOptimisationLanguage.g:1259:2: ( ( rule__ComparisonOperatorRule__Alternatives ) )
            {
            // InternalOptimisationLanguage.g:1259:2: ( ( rule__ComparisonOperatorRule__Alternatives ) )
            // InternalOptimisationLanguage.g:1260:3: ( rule__ComparisonOperatorRule__Alternatives )
            {
             before(grammarAccess.getComparisonOperatorRuleAccess().getAlternatives()); 
            // InternalOptimisationLanguage.g:1261:3: ( rule__ComparisonOperatorRule__Alternatives )
            // InternalOptimisationLanguage.g:1261:4: rule__ComparisonOperatorRule__Alternatives
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
    // InternalOptimisationLanguage.g:1270:1: ruleAddOrSubtractOperatorRule : ( ( rule__AddOrSubtractOperatorRule__Alternatives ) ) ;
    public final void ruleAddOrSubtractOperatorRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1274:1: ( ( ( rule__AddOrSubtractOperatorRule__Alternatives ) ) )
            // InternalOptimisationLanguage.g:1275:2: ( ( rule__AddOrSubtractOperatorRule__Alternatives ) )
            {
            // InternalOptimisationLanguage.g:1275:2: ( ( rule__AddOrSubtractOperatorRule__Alternatives ) )
            // InternalOptimisationLanguage.g:1276:3: ( rule__AddOrSubtractOperatorRule__Alternatives )
            {
             before(grammarAccess.getAddOrSubtractOperatorRuleAccess().getAlternatives()); 
            // InternalOptimisationLanguage.g:1277:3: ( rule__AddOrSubtractOperatorRule__Alternatives )
            // InternalOptimisationLanguage.g:1277:4: rule__AddOrSubtractOperatorRule__Alternatives
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
    // InternalOptimisationLanguage.g:1286:1: ruleMultiplyDivideModuloOperatorRule : ( ( rule__MultiplyDivideModuloOperatorRule__Alternatives ) ) ;
    public final void ruleMultiplyDivideModuloOperatorRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1290:1: ( ( ( rule__MultiplyDivideModuloOperatorRule__Alternatives ) ) )
            // InternalOptimisationLanguage.g:1291:2: ( ( rule__MultiplyDivideModuloOperatorRule__Alternatives ) )
            {
            // InternalOptimisationLanguage.g:1291:2: ( ( rule__MultiplyDivideModuloOperatorRule__Alternatives ) )
            // InternalOptimisationLanguage.g:1292:3: ( rule__MultiplyDivideModuloOperatorRule__Alternatives )
            {
             before(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getAlternatives()); 
            // InternalOptimisationLanguage.g:1293:3: ( rule__MultiplyDivideModuloOperatorRule__Alternatives )
            // InternalOptimisationLanguage.g:1293:4: rule__MultiplyDivideModuloOperatorRule__Alternatives
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
    // InternalOptimisationLanguage.g:1302:1: ruleFactorRule : ( ( rule__FactorRule__Alternatives ) ) ;
    public final void ruleFactorRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1306:1: ( ( ( rule__FactorRule__Alternatives ) ) )
            // InternalOptimisationLanguage.g:1307:2: ( ( rule__FactorRule__Alternatives ) )
            {
            // InternalOptimisationLanguage.g:1307:2: ( ( rule__FactorRule__Alternatives ) )
            // InternalOptimisationLanguage.g:1308:3: ( rule__FactorRule__Alternatives )
            {
             before(grammarAccess.getFactorRuleAccess().getAlternatives()); 
            // InternalOptimisationLanguage.g:1309:3: ( rule__FactorRule__Alternatives )
            // InternalOptimisationLanguage.g:1309:4: rule__FactorRule__Alternatives
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


    // $ANTLR start "rule__ValueRule__Alternatives"
    // InternalOptimisationLanguage.g:1317:1: rule__ValueRule__Alternatives : ( ( ruleArrayRule ) | ( ruleDataReferenceRule ) | ( ruleInstanceRule ) | ( ruleLiteralValueRule ) );
    public final void rule__ValueRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1321:1: ( ( ruleArrayRule ) | ( ruleDataReferenceRule ) | ( ruleInstanceRule ) | ( ruleLiteralValueRule ) )
            int alt1=4;
            switch ( input.LA(1) ) {
            case 59:
                {
                alt1=1;
                }
                break;
            case 62:
                {
                alt1=2;
                }
                break;
            case RULE_QUOTED_ID:
            case RULE_ID:
                {
                alt1=3;
                }
                break;
            case RULE_DOUBLE:
            case RULE_INT:
            case RULE_STRING:
            case 15:
            case 82:
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
                    // InternalOptimisationLanguage.g:1322:2: ( ruleArrayRule )
                    {
                    // InternalOptimisationLanguage.g:1322:2: ( ruleArrayRule )
                    // InternalOptimisationLanguage.g:1323:3: ruleArrayRule
                    {
                     before(grammarAccess.getValueRuleAccess().getArrayRuleParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleArrayRule();

                    state._fsp--;

                     after(grammarAccess.getValueRuleAccess().getArrayRuleParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOptimisationLanguage.g:1328:2: ( ruleDataReferenceRule )
                    {
                    // InternalOptimisationLanguage.g:1328:2: ( ruleDataReferenceRule )
                    // InternalOptimisationLanguage.g:1329:3: ruleDataReferenceRule
                    {
                     before(grammarAccess.getValueRuleAccess().getDataReferenceRuleParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleDataReferenceRule();

                    state._fsp--;

                     after(grammarAccess.getValueRuleAccess().getDataReferenceRuleParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalOptimisationLanguage.g:1334:2: ( ruleInstanceRule )
                    {
                    // InternalOptimisationLanguage.g:1334:2: ( ruleInstanceRule )
                    // InternalOptimisationLanguage.g:1335:3: ruleInstanceRule
                    {
                     before(grammarAccess.getValueRuleAccess().getInstanceRuleParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleInstanceRule();

                    state._fsp--;

                     after(grammarAccess.getValueRuleAccess().getInstanceRuleParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalOptimisationLanguage.g:1340:2: ( ruleLiteralValueRule )
                    {
                    // InternalOptimisationLanguage.g:1340:2: ( ruleLiteralValueRule )
                    // InternalOptimisationLanguage.g:1341:3: ruleLiteralValueRule
                    {
                     before(grammarAccess.getValueRuleAccess().getLiteralValueRuleParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleLiteralValueRule();

                    state._fsp--;

                     after(grammarAccess.getValueRuleAccess().getLiteralValueRuleParserRuleCall_3()); 

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


    // $ANTLR start "rule__LiteralOrReferenceRule__Alternatives"
    // InternalOptimisationLanguage.g:1350:1: rule__LiteralOrReferenceRule__Alternatives : ( ( ruleCallRule ) | ( ruleLiteralRule ) | ( ruleParanthesesRule ) | ( ruleValueReferenceRule ) );
    public final void rule__LiteralOrReferenceRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1354:1: ( ( ruleCallRule ) | ( ruleLiteralRule ) | ( ruleParanthesesRule ) | ( ruleValueReferenceRule ) )
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
            case 82:
                {
                alt2=2;
                }
                break;
            case 68:
                {
                alt2=3;
                }
                break;
            case 70:
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
                    // InternalOptimisationLanguage.g:1355:2: ( ruleCallRule )
                    {
                    // InternalOptimisationLanguage.g:1355:2: ( ruleCallRule )
                    // InternalOptimisationLanguage.g:1356:3: ruleCallRule
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
                    // InternalOptimisationLanguage.g:1361:2: ( ruleLiteralRule )
                    {
                    // InternalOptimisationLanguage.g:1361:2: ( ruleLiteralRule )
                    // InternalOptimisationLanguage.g:1362:3: ruleLiteralRule
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
                    // InternalOptimisationLanguage.g:1367:2: ( ruleParanthesesRule )
                    {
                    // InternalOptimisationLanguage.g:1367:2: ( ruleParanthesesRule )
                    // InternalOptimisationLanguage.g:1368:3: ruleParanthesesRule
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
                    // InternalOptimisationLanguage.g:1373:2: ( ruleValueReferenceRule )
                    {
                    // InternalOptimisationLanguage.g:1373:2: ( ruleValueReferenceRule )
                    // InternalOptimisationLanguage.g:1374:3: ruleValueReferenceRule
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
    // InternalOptimisationLanguage.g:1383:1: rule__LiteralRule__Alternatives : ( ( ruleNumberLiteralRule ) | ( ruleStringLiteralRule ) | ( ruleBooleanLiteralRule ) );
    public final void rule__LiteralRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1387:1: ( ( ruleNumberLiteralRule ) | ( ruleStringLiteralRule ) | ( ruleBooleanLiteralRule ) )
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
            case 82:
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
                    // InternalOptimisationLanguage.g:1388:2: ( ruleNumberLiteralRule )
                    {
                    // InternalOptimisationLanguage.g:1388:2: ( ruleNumberLiteralRule )
                    // InternalOptimisationLanguage.g:1389:3: ruleNumberLiteralRule
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
                    // InternalOptimisationLanguage.g:1394:2: ( ruleStringLiteralRule )
                    {
                    // InternalOptimisationLanguage.g:1394:2: ( ruleStringLiteralRule )
                    // InternalOptimisationLanguage.g:1395:3: ruleStringLiteralRule
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
                    // InternalOptimisationLanguage.g:1400:2: ( ruleBooleanLiteralRule )
                    {
                    // InternalOptimisationLanguage.g:1400:2: ( ruleBooleanLiteralRule )
                    // InternalOptimisationLanguage.g:1401:3: ruleBooleanLiteralRule
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
    // InternalOptimisationLanguage.g:1410:1: rule__NumberLiteralRule__Alternatives : ( ( ruleDoubleLiteralRule ) | ( ruleIntegerLiteralRule ) );
    public final void rule__NumberLiteralRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1414:1: ( ( ruleDoubleLiteralRule ) | ( ruleIntegerLiteralRule ) )
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
                    // InternalOptimisationLanguage.g:1415:2: ( ruleDoubleLiteralRule )
                    {
                    // InternalOptimisationLanguage.g:1415:2: ( ruleDoubleLiteralRule )
                    // InternalOptimisationLanguage.g:1416:3: ruleDoubleLiteralRule
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
                    // InternalOptimisationLanguage.g:1421:2: ( ruleIntegerLiteralRule )
                    {
                    // InternalOptimisationLanguage.g:1421:2: ( ruleIntegerLiteralRule )
                    // InternalOptimisationLanguage.g:1422:3: ruleIntegerLiteralRule
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
    // InternalOptimisationLanguage.g:1431:1: rule__BooleanLiteralRule__Alternatives_1 : ( ( ( rule__BooleanLiteralRule__ValueAssignment_1_0 ) ) | ( 'false' ) );
    public final void rule__BooleanLiteralRule__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1435:1: ( ( ( rule__BooleanLiteralRule__ValueAssignment_1_0 ) ) | ( 'false' ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==82) ) {
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
                    // InternalOptimisationLanguage.g:1436:2: ( ( rule__BooleanLiteralRule__ValueAssignment_1_0 ) )
                    {
                    // InternalOptimisationLanguage.g:1436:2: ( ( rule__BooleanLiteralRule__ValueAssignment_1_0 ) )
                    // InternalOptimisationLanguage.g:1437:3: ( rule__BooleanLiteralRule__ValueAssignment_1_0 )
                    {
                     before(grammarAccess.getBooleanLiteralRuleAccess().getValueAssignment_1_0()); 
                    // InternalOptimisationLanguage.g:1438:3: ( rule__BooleanLiteralRule__ValueAssignment_1_0 )
                    // InternalOptimisationLanguage.g:1438:4: rule__BooleanLiteralRule__ValueAssignment_1_0
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
                    // InternalOptimisationLanguage.g:1442:2: ( 'false' )
                    {
                    // InternalOptimisationLanguage.g:1442:2: ( 'false' )
                    // InternalOptimisationLanguage.g:1443:3: 'false'
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
    // InternalOptimisationLanguage.g:1452:1: rule__TypeRule__Alternatives : ( ( ruleStringTypeRule ) | ( ruleIntTypeRule ) | ( ruleFloatTypeRule ) | ( ruleBooleanTypeRule ) | ( ruleLiteralTypeRule ) | ( ruleArrayTypeRule ) | ( ruleInstanceTypeRule ) | ( ruleVoidTypeRule ) | ( ruleExpressionTypeRule ) | ( ruleDataTypeRule ) );
    public final void rule__TypeRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1456:1: ( ( ruleStringTypeRule ) | ( ruleIntTypeRule ) | ( ruleFloatTypeRule ) | ( ruleBooleanTypeRule ) | ( ruleLiteralTypeRule ) | ( ruleArrayTypeRule ) | ( ruleInstanceTypeRule ) | ( ruleVoidTypeRule ) | ( ruleExpressionTypeRule ) | ( ruleDataTypeRule ) )
            int alt6=10;
            switch ( input.LA(1) ) {
            case 74:
                {
                alt6=1;
                }
                break;
            case 76:
                {
                alt6=2;
                }
                break;
            case 77:
                {
                alt6=3;
                }
                break;
            case 78:
                {
                alt6=4;
                }
                break;
            case 72:
                {
                alt6=5;
                }
                break;
            case 80:
                {
                alt6=6;
                }
                break;
            case 53:
                {
                alt6=7;
                }
                break;
            case 79:
                {
                alt6=8;
                }
                break;
            case 75:
                {
                alt6=9;
                }
                break;
            case 62:
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
                    // InternalOptimisationLanguage.g:1457:2: ( ruleStringTypeRule )
                    {
                    // InternalOptimisationLanguage.g:1457:2: ( ruleStringTypeRule )
                    // InternalOptimisationLanguage.g:1458:3: ruleStringTypeRule
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
                    // InternalOptimisationLanguage.g:1463:2: ( ruleIntTypeRule )
                    {
                    // InternalOptimisationLanguage.g:1463:2: ( ruleIntTypeRule )
                    // InternalOptimisationLanguage.g:1464:3: ruleIntTypeRule
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
                    // InternalOptimisationLanguage.g:1469:2: ( ruleFloatTypeRule )
                    {
                    // InternalOptimisationLanguage.g:1469:2: ( ruleFloatTypeRule )
                    // InternalOptimisationLanguage.g:1470:3: ruleFloatTypeRule
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
                    // InternalOptimisationLanguage.g:1475:2: ( ruleBooleanTypeRule )
                    {
                    // InternalOptimisationLanguage.g:1475:2: ( ruleBooleanTypeRule )
                    // InternalOptimisationLanguage.g:1476:3: ruleBooleanTypeRule
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
                    // InternalOptimisationLanguage.g:1481:2: ( ruleLiteralTypeRule )
                    {
                    // InternalOptimisationLanguage.g:1481:2: ( ruleLiteralTypeRule )
                    // InternalOptimisationLanguage.g:1482:3: ruleLiteralTypeRule
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
                    // InternalOptimisationLanguage.g:1487:2: ( ruleArrayTypeRule )
                    {
                    // InternalOptimisationLanguage.g:1487:2: ( ruleArrayTypeRule )
                    // InternalOptimisationLanguage.g:1488:3: ruleArrayTypeRule
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
                    // InternalOptimisationLanguage.g:1493:2: ( ruleInstanceTypeRule )
                    {
                    // InternalOptimisationLanguage.g:1493:2: ( ruleInstanceTypeRule )
                    // InternalOptimisationLanguage.g:1494:3: ruleInstanceTypeRule
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
                    // InternalOptimisationLanguage.g:1499:2: ( ruleVoidTypeRule )
                    {
                    // InternalOptimisationLanguage.g:1499:2: ( ruleVoidTypeRule )
                    // InternalOptimisationLanguage.g:1500:3: ruleVoidTypeRule
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
                    // InternalOptimisationLanguage.g:1505:2: ( ruleExpressionTypeRule )
                    {
                    // InternalOptimisationLanguage.g:1505:2: ( ruleExpressionTypeRule )
                    // InternalOptimisationLanguage.g:1506:3: ruleExpressionTypeRule
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
                    // InternalOptimisationLanguage.g:1511:2: ( ruleDataTypeRule )
                    {
                    // InternalOptimisationLanguage.g:1511:2: ( ruleDataTypeRule )
                    // InternalOptimisationLanguage.g:1512:3: ruleDataTypeRule
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
    // InternalOptimisationLanguage.g:1521:1: rule__StringOrId__Alternatives : ( ( RULE_QUOTED_ID ) | ( RULE_ID ) );
    public final void rule__StringOrId__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1525:1: ( ( RULE_QUOTED_ID ) | ( RULE_ID ) )
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
                    // InternalOptimisationLanguage.g:1526:2: ( RULE_QUOTED_ID )
                    {
                    // InternalOptimisationLanguage.g:1526:2: ( RULE_QUOTED_ID )
                    // InternalOptimisationLanguage.g:1527:3: RULE_QUOTED_ID
                    {
                     before(grammarAccess.getStringOrIdAccess().getQUOTED_IDTerminalRuleCall_0()); 
                    match(input,RULE_QUOTED_ID,FOLLOW_2); 
                     after(grammarAccess.getStringOrIdAccess().getQUOTED_IDTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOptimisationLanguage.g:1532:2: ( RULE_ID )
                    {
                    // InternalOptimisationLanguage.g:1532:2: ( RULE_ID )
                    // InternalOptimisationLanguage.g:1533:3: RULE_ID
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
    // InternalOptimisationLanguage.g:1542:1: rule__ComparisonOperatorRule__Alternatives : ( ( ( '>=' ) ) | ( ( '>' ) ) | ( ( '=' ) ) | ( ( '!=' ) ) | ( ( '<' ) ) | ( ( '<=' ) ) );
    public final void rule__ComparisonOperatorRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1546:1: ( ( ( '>=' ) ) | ( ( '>' ) ) | ( ( '=' ) ) | ( ( '!=' ) ) | ( ( '<' ) ) | ( ( '<=' ) ) )
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
                    // InternalOptimisationLanguage.g:1547:2: ( ( '>=' ) )
                    {
                    // InternalOptimisationLanguage.g:1547:2: ( ( '>=' ) )
                    // InternalOptimisationLanguage.g:1548:3: ( '>=' )
                    {
                     before(grammarAccess.getComparisonOperatorRuleAccess().getGreaterThanEnumLiteralDeclaration_0()); 
                    // InternalOptimisationLanguage.g:1549:3: ( '>=' )
                    // InternalOptimisationLanguage.g:1549:4: '>='
                    {
                    match(input,16,FOLLOW_2); 

                    }

                     after(grammarAccess.getComparisonOperatorRuleAccess().getGreaterThanEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOptimisationLanguage.g:1553:2: ( ( '>' ) )
                    {
                    // InternalOptimisationLanguage.g:1553:2: ( ( '>' ) )
                    // InternalOptimisationLanguage.g:1554:3: ( '>' )
                    {
                     before(grammarAccess.getComparisonOperatorRuleAccess().getGreaterEqualEnumLiteralDeclaration_1()); 
                    // InternalOptimisationLanguage.g:1555:3: ( '>' )
                    // InternalOptimisationLanguage.g:1555:4: '>'
                    {
                    match(input,17,FOLLOW_2); 

                    }

                     after(grammarAccess.getComparisonOperatorRuleAccess().getGreaterEqualEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalOptimisationLanguage.g:1559:2: ( ( '=' ) )
                    {
                    // InternalOptimisationLanguage.g:1559:2: ( ( '=' ) )
                    // InternalOptimisationLanguage.g:1560:3: ( '=' )
                    {
                     before(grammarAccess.getComparisonOperatorRuleAccess().getEqualEnumLiteralDeclaration_2()); 
                    // InternalOptimisationLanguage.g:1561:3: ( '=' )
                    // InternalOptimisationLanguage.g:1561:4: '='
                    {
                    match(input,18,FOLLOW_2); 

                    }

                     after(grammarAccess.getComparisonOperatorRuleAccess().getEqualEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalOptimisationLanguage.g:1565:2: ( ( '!=' ) )
                    {
                    // InternalOptimisationLanguage.g:1565:2: ( ( '!=' ) )
                    // InternalOptimisationLanguage.g:1566:3: ( '!=' )
                    {
                     before(grammarAccess.getComparisonOperatorRuleAccess().getUnequalEnumLiteralDeclaration_3()); 
                    // InternalOptimisationLanguage.g:1567:3: ( '!=' )
                    // InternalOptimisationLanguage.g:1567:4: '!='
                    {
                    match(input,19,FOLLOW_2); 

                    }

                     after(grammarAccess.getComparisonOperatorRuleAccess().getUnequalEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalOptimisationLanguage.g:1571:2: ( ( '<' ) )
                    {
                    // InternalOptimisationLanguage.g:1571:2: ( ( '<' ) )
                    // InternalOptimisationLanguage.g:1572:3: ( '<' )
                    {
                     before(grammarAccess.getComparisonOperatorRuleAccess().getLessEqualEnumLiteralDeclaration_4()); 
                    // InternalOptimisationLanguage.g:1573:3: ( '<' )
                    // InternalOptimisationLanguage.g:1573:4: '<'
                    {
                    match(input,20,FOLLOW_2); 

                    }

                     after(grammarAccess.getComparisonOperatorRuleAccess().getLessEqualEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalOptimisationLanguage.g:1577:2: ( ( '<=' ) )
                    {
                    // InternalOptimisationLanguage.g:1577:2: ( ( '<=' ) )
                    // InternalOptimisationLanguage.g:1578:3: ( '<=' )
                    {
                     before(grammarAccess.getComparisonOperatorRuleAccess().getLessThanEnumLiteralDeclaration_5()); 
                    // InternalOptimisationLanguage.g:1579:3: ( '<=' )
                    // InternalOptimisationLanguage.g:1579:4: '<='
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
    // InternalOptimisationLanguage.g:1587:1: rule__AddOrSubtractOperatorRule__Alternatives : ( ( ( '+' ) ) | ( ( '-' ) ) );
    public final void rule__AddOrSubtractOperatorRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1591:1: ( ( ( '+' ) ) | ( ( '-' ) ) )
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
                    // InternalOptimisationLanguage.g:1592:2: ( ( '+' ) )
                    {
                    // InternalOptimisationLanguage.g:1592:2: ( ( '+' ) )
                    // InternalOptimisationLanguage.g:1593:3: ( '+' )
                    {
                     before(grammarAccess.getAddOrSubtractOperatorRuleAccess().getAddEnumLiteralDeclaration_0()); 
                    // InternalOptimisationLanguage.g:1594:3: ( '+' )
                    // InternalOptimisationLanguage.g:1594:4: '+'
                    {
                    match(input,22,FOLLOW_2); 

                    }

                     after(grammarAccess.getAddOrSubtractOperatorRuleAccess().getAddEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOptimisationLanguage.g:1598:2: ( ( '-' ) )
                    {
                    // InternalOptimisationLanguage.g:1598:2: ( ( '-' ) )
                    // InternalOptimisationLanguage.g:1599:3: ( '-' )
                    {
                     before(grammarAccess.getAddOrSubtractOperatorRuleAccess().getSubtractEnumLiteralDeclaration_1()); 
                    // InternalOptimisationLanguage.g:1600:3: ( '-' )
                    // InternalOptimisationLanguage.g:1600:4: '-'
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
    // InternalOptimisationLanguage.g:1608:1: rule__MultiplyDivideModuloOperatorRule__Alternatives : ( ( ( '*' ) ) | ( ( '/' ) ) | ( ( '%' ) ) );
    public final void rule__MultiplyDivideModuloOperatorRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1612:1: ( ( ( '*' ) ) | ( ( '/' ) ) | ( ( '%' ) ) )
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
                    // InternalOptimisationLanguage.g:1613:2: ( ( '*' ) )
                    {
                    // InternalOptimisationLanguage.g:1613:2: ( ( '*' ) )
                    // InternalOptimisationLanguage.g:1614:3: ( '*' )
                    {
                     before(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getMultiplyEnumLiteralDeclaration_0()); 
                    // InternalOptimisationLanguage.g:1615:3: ( '*' )
                    // InternalOptimisationLanguage.g:1615:4: '*'
                    {
                    match(input,24,FOLLOW_2); 

                    }

                     after(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getMultiplyEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOptimisationLanguage.g:1619:2: ( ( '/' ) )
                    {
                    // InternalOptimisationLanguage.g:1619:2: ( ( '/' ) )
                    // InternalOptimisationLanguage.g:1620:3: ( '/' )
                    {
                     before(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getDivideEnumLiteralDeclaration_1()); 
                    // InternalOptimisationLanguage.g:1621:3: ( '/' )
                    // InternalOptimisationLanguage.g:1621:4: '/'
                    {
                    match(input,25,FOLLOW_2); 

                    }

                     after(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getDivideEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalOptimisationLanguage.g:1625:2: ( ( '%' ) )
                    {
                    // InternalOptimisationLanguage.g:1625:2: ( ( '%' ) )
                    // InternalOptimisationLanguage.g:1626:3: ( '%' )
                    {
                     before(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getModuloEnumLiteralDeclaration_2()); 
                    // InternalOptimisationLanguage.g:1627:3: ( '%' )
                    // InternalOptimisationLanguage.g:1627:4: '%'
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
    // InternalOptimisationLanguage.g:1635:1: rule__FactorRule__Alternatives : ( ( ( 'Y' ) ) | ( ( 'Z' ) ) | ( ( 'E' ) ) | ( ( 'P' ) ) | ( ( 'T' ) ) | ( ( 'G' ) ) | ( ( 'M' ) ) | ( ( 'k' ) ) | ( ( 'h' ) ) | ( ( 'da' ) ) | ( ( 'd' ) ) | ( ( 'c' ) ) | ( ( 'm' ) ) | ( ( '\\u00B5' ) ) | ( ( 'n' ) ) | ( ( 'p' ) ) | ( ( 'f' ) ) | ( ( 'a' ) ) | ( ( 'z' ) ) | ( ( 'y' ) ) );
    public final void rule__FactorRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1639:1: ( ( ( 'Y' ) ) | ( ( 'Z' ) ) | ( ( 'E' ) ) | ( ( 'P' ) ) | ( ( 'T' ) ) | ( ( 'G' ) ) | ( ( 'M' ) ) | ( ( 'k' ) ) | ( ( 'h' ) ) | ( ( 'da' ) ) | ( ( 'd' ) ) | ( ( 'c' ) ) | ( ( 'm' ) ) | ( ( '\\u00B5' ) ) | ( ( 'n' ) ) | ( ( 'p' ) ) | ( ( 'f' ) ) | ( ( 'a' ) ) | ( ( 'z' ) ) | ( ( 'y' ) ) )
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
                    // InternalOptimisationLanguage.g:1640:2: ( ( 'Y' ) )
                    {
                    // InternalOptimisationLanguage.g:1640:2: ( ( 'Y' ) )
                    // InternalOptimisationLanguage.g:1641:3: ( 'Y' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getYottaEnumLiteralDeclaration_0()); 
                    // InternalOptimisationLanguage.g:1642:3: ( 'Y' )
                    // InternalOptimisationLanguage.g:1642:4: 'Y'
                    {
                    match(input,27,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getYottaEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOptimisationLanguage.g:1646:2: ( ( 'Z' ) )
                    {
                    // InternalOptimisationLanguage.g:1646:2: ( ( 'Z' ) )
                    // InternalOptimisationLanguage.g:1647:3: ( 'Z' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getZettaEnumLiteralDeclaration_1()); 
                    // InternalOptimisationLanguage.g:1648:3: ( 'Z' )
                    // InternalOptimisationLanguage.g:1648:4: 'Z'
                    {
                    match(input,28,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getZettaEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalOptimisationLanguage.g:1652:2: ( ( 'E' ) )
                    {
                    // InternalOptimisationLanguage.g:1652:2: ( ( 'E' ) )
                    // InternalOptimisationLanguage.g:1653:3: ( 'E' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getExaEnumLiteralDeclaration_2()); 
                    // InternalOptimisationLanguage.g:1654:3: ( 'E' )
                    // InternalOptimisationLanguage.g:1654:4: 'E'
                    {
                    match(input,29,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getExaEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalOptimisationLanguage.g:1658:2: ( ( 'P' ) )
                    {
                    // InternalOptimisationLanguage.g:1658:2: ( ( 'P' ) )
                    // InternalOptimisationLanguage.g:1659:3: ( 'P' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getPetaEnumLiteralDeclaration_3()); 
                    // InternalOptimisationLanguage.g:1660:3: ( 'P' )
                    // InternalOptimisationLanguage.g:1660:4: 'P'
                    {
                    match(input,30,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getPetaEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalOptimisationLanguage.g:1664:2: ( ( 'T' ) )
                    {
                    // InternalOptimisationLanguage.g:1664:2: ( ( 'T' ) )
                    // InternalOptimisationLanguage.g:1665:3: ( 'T' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getTeraEnumLiteralDeclaration_4()); 
                    // InternalOptimisationLanguage.g:1666:3: ( 'T' )
                    // InternalOptimisationLanguage.g:1666:4: 'T'
                    {
                    match(input,31,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getTeraEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalOptimisationLanguage.g:1670:2: ( ( 'G' ) )
                    {
                    // InternalOptimisationLanguage.g:1670:2: ( ( 'G' ) )
                    // InternalOptimisationLanguage.g:1671:3: ( 'G' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getGigaEnumLiteralDeclaration_5()); 
                    // InternalOptimisationLanguage.g:1672:3: ( 'G' )
                    // InternalOptimisationLanguage.g:1672:4: 'G'
                    {
                    match(input,32,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getGigaEnumLiteralDeclaration_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalOptimisationLanguage.g:1676:2: ( ( 'M' ) )
                    {
                    // InternalOptimisationLanguage.g:1676:2: ( ( 'M' ) )
                    // InternalOptimisationLanguage.g:1677:3: ( 'M' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getMegaEnumLiteralDeclaration_6()); 
                    // InternalOptimisationLanguage.g:1678:3: ( 'M' )
                    // InternalOptimisationLanguage.g:1678:4: 'M'
                    {
                    match(input,33,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getMegaEnumLiteralDeclaration_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalOptimisationLanguage.g:1682:2: ( ( 'k' ) )
                    {
                    // InternalOptimisationLanguage.g:1682:2: ( ( 'k' ) )
                    // InternalOptimisationLanguage.g:1683:3: ( 'k' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getKiloEnumLiteralDeclaration_7()); 
                    // InternalOptimisationLanguage.g:1684:3: ( 'k' )
                    // InternalOptimisationLanguage.g:1684:4: 'k'
                    {
                    match(input,34,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getKiloEnumLiteralDeclaration_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalOptimisationLanguage.g:1688:2: ( ( 'h' ) )
                    {
                    // InternalOptimisationLanguage.g:1688:2: ( ( 'h' ) )
                    // InternalOptimisationLanguage.g:1689:3: ( 'h' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getHectoEnumLiteralDeclaration_8()); 
                    // InternalOptimisationLanguage.g:1690:3: ( 'h' )
                    // InternalOptimisationLanguage.g:1690:4: 'h'
                    {
                    match(input,35,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getHectoEnumLiteralDeclaration_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalOptimisationLanguage.g:1694:2: ( ( 'da' ) )
                    {
                    // InternalOptimisationLanguage.g:1694:2: ( ( 'da' ) )
                    // InternalOptimisationLanguage.g:1695:3: ( 'da' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getDekaEnumLiteralDeclaration_9()); 
                    // InternalOptimisationLanguage.g:1696:3: ( 'da' )
                    // InternalOptimisationLanguage.g:1696:4: 'da'
                    {
                    match(input,36,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getDekaEnumLiteralDeclaration_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalOptimisationLanguage.g:1700:2: ( ( 'd' ) )
                    {
                    // InternalOptimisationLanguage.g:1700:2: ( ( 'd' ) )
                    // InternalOptimisationLanguage.g:1701:3: ( 'd' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getDeciEnumLiteralDeclaration_10()); 
                    // InternalOptimisationLanguage.g:1702:3: ( 'd' )
                    // InternalOptimisationLanguage.g:1702:4: 'd'
                    {
                    match(input,37,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getDeciEnumLiteralDeclaration_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalOptimisationLanguage.g:1706:2: ( ( 'c' ) )
                    {
                    // InternalOptimisationLanguage.g:1706:2: ( ( 'c' ) )
                    // InternalOptimisationLanguage.g:1707:3: ( 'c' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getCentiEnumLiteralDeclaration_11()); 
                    // InternalOptimisationLanguage.g:1708:3: ( 'c' )
                    // InternalOptimisationLanguage.g:1708:4: 'c'
                    {
                    match(input,38,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getCentiEnumLiteralDeclaration_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalOptimisationLanguage.g:1712:2: ( ( 'm' ) )
                    {
                    // InternalOptimisationLanguage.g:1712:2: ( ( 'm' ) )
                    // InternalOptimisationLanguage.g:1713:3: ( 'm' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getMilliEnumLiteralDeclaration_12()); 
                    // InternalOptimisationLanguage.g:1714:3: ( 'm' )
                    // InternalOptimisationLanguage.g:1714:4: 'm'
                    {
                    match(input,39,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getMilliEnumLiteralDeclaration_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalOptimisationLanguage.g:1718:2: ( ( '\\u00B5' ) )
                    {
                    // InternalOptimisationLanguage.g:1718:2: ( ( '\\u00B5' ) )
                    // InternalOptimisationLanguage.g:1719:3: ( '\\u00B5' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getMicroEnumLiteralDeclaration_13()); 
                    // InternalOptimisationLanguage.g:1720:3: ( '\\u00B5' )
                    // InternalOptimisationLanguage.g:1720:4: '\\u00B5'
                    {
                    match(input,40,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getMicroEnumLiteralDeclaration_13()); 

                    }


                    }
                    break;
                case 15 :
                    // InternalOptimisationLanguage.g:1724:2: ( ( 'n' ) )
                    {
                    // InternalOptimisationLanguage.g:1724:2: ( ( 'n' ) )
                    // InternalOptimisationLanguage.g:1725:3: ( 'n' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getNanoEnumLiteralDeclaration_14()); 
                    // InternalOptimisationLanguage.g:1726:3: ( 'n' )
                    // InternalOptimisationLanguage.g:1726:4: 'n'
                    {
                    match(input,41,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getNanoEnumLiteralDeclaration_14()); 

                    }


                    }
                    break;
                case 16 :
                    // InternalOptimisationLanguage.g:1730:2: ( ( 'p' ) )
                    {
                    // InternalOptimisationLanguage.g:1730:2: ( ( 'p' ) )
                    // InternalOptimisationLanguage.g:1731:3: ( 'p' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getPikoEnumLiteralDeclaration_15()); 
                    // InternalOptimisationLanguage.g:1732:3: ( 'p' )
                    // InternalOptimisationLanguage.g:1732:4: 'p'
                    {
                    match(input,42,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getPikoEnumLiteralDeclaration_15()); 

                    }


                    }
                    break;
                case 17 :
                    // InternalOptimisationLanguage.g:1736:2: ( ( 'f' ) )
                    {
                    // InternalOptimisationLanguage.g:1736:2: ( ( 'f' ) )
                    // InternalOptimisationLanguage.g:1737:3: ( 'f' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getFemtoEnumLiteralDeclaration_16()); 
                    // InternalOptimisationLanguage.g:1738:3: ( 'f' )
                    // InternalOptimisationLanguage.g:1738:4: 'f'
                    {
                    match(input,43,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getFemtoEnumLiteralDeclaration_16()); 

                    }


                    }
                    break;
                case 18 :
                    // InternalOptimisationLanguage.g:1742:2: ( ( 'a' ) )
                    {
                    // InternalOptimisationLanguage.g:1742:2: ( ( 'a' ) )
                    // InternalOptimisationLanguage.g:1743:3: ( 'a' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getAttoEnumLiteralDeclaration_17()); 
                    // InternalOptimisationLanguage.g:1744:3: ( 'a' )
                    // InternalOptimisationLanguage.g:1744:4: 'a'
                    {
                    match(input,44,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getAttoEnumLiteralDeclaration_17()); 

                    }


                    }
                    break;
                case 19 :
                    // InternalOptimisationLanguage.g:1748:2: ( ( 'z' ) )
                    {
                    // InternalOptimisationLanguage.g:1748:2: ( ( 'z' ) )
                    // InternalOptimisationLanguage.g:1749:3: ( 'z' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getZeptoEnumLiteralDeclaration_18()); 
                    // InternalOptimisationLanguage.g:1750:3: ( 'z' )
                    // InternalOptimisationLanguage.g:1750:4: 'z'
                    {
                    match(input,45,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getZeptoEnumLiteralDeclaration_18()); 

                    }


                    }
                    break;
                case 20 :
                    // InternalOptimisationLanguage.g:1754:2: ( ( 'y' ) )
                    {
                    // InternalOptimisationLanguage.g:1754:2: ( ( 'y' ) )
                    // InternalOptimisationLanguage.g:1755:3: ( 'y' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getYoctoEnumLiteralDeclaration_19()); 
                    // InternalOptimisationLanguage.g:1756:3: ( 'y' )
                    // InternalOptimisationLanguage.g:1756:4: 'y'
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


    // $ANTLR start "rule__OptimisationModelRule__Group__0"
    // InternalOptimisationLanguage.g:1764:1: rule__OptimisationModelRule__Group__0 : rule__OptimisationModelRule__Group__0__Impl rule__OptimisationModelRule__Group__1 ;
    public final void rule__OptimisationModelRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1768:1: ( rule__OptimisationModelRule__Group__0__Impl rule__OptimisationModelRule__Group__1 )
            // InternalOptimisationLanguage.g:1769:2: rule__OptimisationModelRule__Group__0__Impl rule__OptimisationModelRule__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__OptimisationModelRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OptimisationModelRule__Group__1();

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
    // $ANTLR end "rule__OptimisationModelRule__Group__0"


    // $ANTLR start "rule__OptimisationModelRule__Group__0__Impl"
    // InternalOptimisationLanguage.g:1776:1: rule__OptimisationModelRule__Group__0__Impl : ( ( rule__OptimisationModelRule__ImportsAssignment_0 )* ) ;
    public final void rule__OptimisationModelRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1780:1: ( ( ( rule__OptimisationModelRule__ImportsAssignment_0 )* ) )
            // InternalOptimisationLanguage.g:1781:1: ( ( rule__OptimisationModelRule__ImportsAssignment_0 )* )
            {
            // InternalOptimisationLanguage.g:1781:1: ( ( rule__OptimisationModelRule__ImportsAssignment_0 )* )
            // InternalOptimisationLanguage.g:1782:2: ( rule__OptimisationModelRule__ImportsAssignment_0 )*
            {
             before(grammarAccess.getOptimisationModelRuleAccess().getImportsAssignment_0()); 
            // InternalOptimisationLanguage.g:1783:2: ( rule__OptimisationModelRule__ImportsAssignment_0 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==47) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:1783:3: rule__OptimisationModelRule__ImportsAssignment_0
            	    {
            	    pushFollow(FOLLOW_4);
            	    rule__OptimisationModelRule__ImportsAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

             after(grammarAccess.getOptimisationModelRuleAccess().getImportsAssignment_0()); 

            }


            }

        }
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
    // InternalOptimisationLanguage.g:1791:1: rule__OptimisationModelRule__Group__1 : rule__OptimisationModelRule__Group__1__Impl rule__OptimisationModelRule__Group__2 ;
    public final void rule__OptimisationModelRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1795:1: ( rule__OptimisationModelRule__Group__1__Impl rule__OptimisationModelRule__Group__2 )
            // InternalOptimisationLanguage.g:1796:2: rule__OptimisationModelRule__Group__1__Impl rule__OptimisationModelRule__Group__2
            {
            pushFollow(FOLLOW_3);
            rule__OptimisationModelRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OptimisationModelRule__Group__2();

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
    // $ANTLR end "rule__OptimisationModelRule__Group__1"


    // $ANTLR start "rule__OptimisationModelRule__Group__1__Impl"
    // InternalOptimisationLanguage.g:1803:1: rule__OptimisationModelRule__Group__1__Impl : ( ( rule__OptimisationModelRule__ProblemAssignment_1 )? ) ;
    public final void rule__OptimisationModelRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1807:1: ( ( ( rule__OptimisationModelRule__ProblemAssignment_1 )? ) )
            // InternalOptimisationLanguage.g:1808:1: ( ( rule__OptimisationModelRule__ProblemAssignment_1 )? )
            {
            // InternalOptimisationLanguage.g:1808:1: ( ( rule__OptimisationModelRule__ProblemAssignment_1 )? )
            // InternalOptimisationLanguage.g:1809:2: ( rule__OptimisationModelRule__ProblemAssignment_1 )?
            {
             before(grammarAccess.getOptimisationModelRuleAccess().getProblemAssignment_1()); 
            // InternalOptimisationLanguage.g:1810:2: ( rule__OptimisationModelRule__ProblemAssignment_1 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==49) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalOptimisationLanguage.g:1810:3: rule__OptimisationModelRule__ProblemAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__OptimisationModelRule__ProblemAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getOptimisationModelRuleAccess().getProblemAssignment_1()); 

            }


            }

        }
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
    // InternalOptimisationLanguage.g:1818:1: rule__OptimisationModelRule__Group__2 : rule__OptimisationModelRule__Group__2__Impl ;
    public final void rule__OptimisationModelRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1822:1: ( rule__OptimisationModelRule__Group__2__Impl )
            // InternalOptimisationLanguage.g:1823:2: rule__OptimisationModelRule__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OptimisationModelRule__Group__2__Impl();

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
    // $ANTLR end "rule__OptimisationModelRule__Group__2"


    // $ANTLR start "rule__OptimisationModelRule__Group__2__Impl"
    // InternalOptimisationLanguage.g:1829:1: rule__OptimisationModelRule__Group__2__Impl : ( ( rule__OptimisationModelRule__AlgorithmAssignment_2 )? ) ;
    public final void rule__OptimisationModelRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1833:1: ( ( ( rule__OptimisationModelRule__AlgorithmAssignment_2 )? ) )
            // InternalOptimisationLanguage.g:1834:1: ( ( rule__OptimisationModelRule__AlgorithmAssignment_2 )? )
            {
            // InternalOptimisationLanguage.g:1834:1: ( ( rule__OptimisationModelRule__AlgorithmAssignment_2 )? )
            // InternalOptimisationLanguage.g:1835:2: ( rule__OptimisationModelRule__AlgorithmAssignment_2 )?
            {
             before(grammarAccess.getOptimisationModelRuleAccess().getAlgorithmAssignment_2()); 
            // InternalOptimisationLanguage.g:1836:2: ( rule__OptimisationModelRule__AlgorithmAssignment_2 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==53) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalOptimisationLanguage.g:1836:3: rule__OptimisationModelRule__AlgorithmAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__OptimisationModelRule__AlgorithmAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getOptimisationModelRuleAccess().getAlgorithmAssignment_2()); 

            }


            }

        }
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


    // $ANTLR start "rule__ImportRule__Group__0"
    // InternalOptimisationLanguage.g:1845:1: rule__ImportRule__Group__0 : rule__ImportRule__Group__0__Impl rule__ImportRule__Group__1 ;
    public final void rule__ImportRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1849:1: ( rule__ImportRule__Group__0__Impl rule__ImportRule__Group__1 )
            // InternalOptimisationLanguage.g:1850:2: rule__ImportRule__Group__0__Impl rule__ImportRule__Group__1
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
    // InternalOptimisationLanguage.g:1857:1: rule__ImportRule__Group__0__Impl : ( 'import' ) ;
    public final void rule__ImportRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1861:1: ( ( 'import' ) )
            // InternalOptimisationLanguage.g:1862:1: ( 'import' )
            {
            // InternalOptimisationLanguage.g:1862:1: ( 'import' )
            // InternalOptimisationLanguage.g:1863:2: 'import'
            {
             before(grammarAccess.getImportRuleAccess().getImportKeyword_0()); 
            match(input,47,FOLLOW_2); 
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
    // InternalOptimisationLanguage.g:1872:1: rule__ImportRule__Group__1 : rule__ImportRule__Group__1__Impl rule__ImportRule__Group__2 ;
    public final void rule__ImportRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1876:1: ( rule__ImportRule__Group__1__Impl rule__ImportRule__Group__2 )
            // InternalOptimisationLanguage.g:1877:2: rule__ImportRule__Group__1__Impl rule__ImportRule__Group__2
            {
            pushFollow(FOLLOW_6);
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
    // InternalOptimisationLanguage.g:1884:1: rule__ImportRule__Group__1__Impl : ( ( rule__ImportRule__ImportedNamespaceAssignment_1 ) ) ;
    public final void rule__ImportRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1888:1: ( ( ( rule__ImportRule__ImportedNamespaceAssignment_1 ) ) )
            // InternalOptimisationLanguage.g:1889:1: ( ( rule__ImportRule__ImportedNamespaceAssignment_1 ) )
            {
            // InternalOptimisationLanguage.g:1889:1: ( ( rule__ImportRule__ImportedNamespaceAssignment_1 ) )
            // InternalOptimisationLanguage.g:1890:2: ( rule__ImportRule__ImportedNamespaceAssignment_1 )
            {
             before(grammarAccess.getImportRuleAccess().getImportedNamespaceAssignment_1()); 
            // InternalOptimisationLanguage.g:1891:2: ( rule__ImportRule__ImportedNamespaceAssignment_1 )
            // InternalOptimisationLanguage.g:1891:3: rule__ImportRule__ImportedNamespaceAssignment_1
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
    // InternalOptimisationLanguage.g:1899:1: rule__ImportRule__Group__2 : rule__ImportRule__Group__2__Impl ;
    public final void rule__ImportRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1903:1: ( rule__ImportRule__Group__2__Impl )
            // InternalOptimisationLanguage.g:1904:2: rule__ImportRule__Group__2__Impl
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
    // InternalOptimisationLanguage.g:1910:1: rule__ImportRule__Group__2__Impl : ( ';' ) ;
    public final void rule__ImportRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1914:1: ( ( ';' ) )
            // InternalOptimisationLanguage.g:1915:1: ( ';' )
            {
            // InternalOptimisationLanguage.g:1915:1: ( ';' )
            // InternalOptimisationLanguage.g:1916:2: ';'
            {
             before(grammarAccess.getImportRuleAccess().getSemicolonKeyword_2()); 
            match(input,48,FOLLOW_2); 
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


    // $ANTLR start "rule__ProblemRule__Group__0"
    // InternalOptimisationLanguage.g:1926:1: rule__ProblemRule__Group__0 : rule__ProblemRule__Group__0__Impl rule__ProblemRule__Group__1 ;
    public final void rule__ProblemRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1930:1: ( rule__ProblemRule__Group__0__Impl rule__ProblemRule__Group__1 )
            // InternalOptimisationLanguage.g:1931:2: rule__ProblemRule__Group__0__Impl rule__ProblemRule__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__ProblemRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ProblemRule__Group__1();

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
    // $ANTLR end "rule__ProblemRule__Group__0"


    // $ANTLR start "rule__ProblemRule__Group__0__Impl"
    // InternalOptimisationLanguage.g:1938:1: rule__ProblemRule__Group__0__Impl : ( 'declare' ) ;
    public final void rule__ProblemRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1942:1: ( ( 'declare' ) )
            // InternalOptimisationLanguage.g:1943:1: ( 'declare' )
            {
            // InternalOptimisationLanguage.g:1943:1: ( 'declare' )
            // InternalOptimisationLanguage.g:1944:2: 'declare'
            {
             before(grammarAccess.getProblemRuleAccess().getDeclareKeyword_0()); 
            match(input,49,FOLLOW_2); 
             after(grammarAccess.getProblemRuleAccess().getDeclareKeyword_0()); 

            }


            }

        }
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
    // InternalOptimisationLanguage.g:1953:1: rule__ProblemRule__Group__1 : rule__ProblemRule__Group__1__Impl rule__ProblemRule__Group__2 ;
    public final void rule__ProblemRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1957:1: ( rule__ProblemRule__Group__1__Impl rule__ProblemRule__Group__2 )
            // InternalOptimisationLanguage.g:1958:2: rule__ProblemRule__Group__1__Impl rule__ProblemRule__Group__2
            {
            pushFollow(FOLLOW_7);
            rule__ProblemRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ProblemRule__Group__2();

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
    // $ANTLR end "rule__ProblemRule__Group__1"


    // $ANTLR start "rule__ProblemRule__Group__1__Impl"
    // InternalOptimisationLanguage.g:1965:1: rule__ProblemRule__Group__1__Impl : ( ( rule__ProblemRule__NameAssignment_1 ) ) ;
    public final void rule__ProblemRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1969:1: ( ( ( rule__ProblemRule__NameAssignment_1 ) ) )
            // InternalOptimisationLanguage.g:1970:1: ( ( rule__ProblemRule__NameAssignment_1 ) )
            {
            // InternalOptimisationLanguage.g:1970:1: ( ( rule__ProblemRule__NameAssignment_1 ) )
            // InternalOptimisationLanguage.g:1971:2: ( rule__ProblemRule__NameAssignment_1 )
            {
             before(grammarAccess.getProblemRuleAccess().getNameAssignment_1()); 
            // InternalOptimisationLanguage.g:1972:2: ( rule__ProblemRule__NameAssignment_1 )
            // InternalOptimisationLanguage.g:1972:3: rule__ProblemRule__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__ProblemRule__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getProblemRuleAccess().getNameAssignment_1()); 

            }


            }

        }
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
    // InternalOptimisationLanguage.g:1980:1: rule__ProblemRule__Group__2 : rule__ProblemRule__Group__2__Impl rule__ProblemRule__Group__3 ;
    public final void rule__ProblemRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1984:1: ( rule__ProblemRule__Group__2__Impl rule__ProblemRule__Group__3 )
            // InternalOptimisationLanguage.g:1985:2: rule__ProblemRule__Group__2__Impl rule__ProblemRule__Group__3
            {
            pushFollow(FOLLOW_5);
            rule__ProblemRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ProblemRule__Group__3();

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
    // $ANTLR end "rule__ProblemRule__Group__2"


    // $ANTLR start "rule__ProblemRule__Group__2__Impl"
    // InternalOptimisationLanguage.g:1992:1: rule__ProblemRule__Group__2__Impl : ( 'as' ) ;
    public final void rule__ProblemRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:1996:1: ( ( 'as' ) )
            // InternalOptimisationLanguage.g:1997:1: ( 'as' )
            {
            // InternalOptimisationLanguage.g:1997:1: ( 'as' )
            // InternalOptimisationLanguage.g:1998:2: 'as'
            {
             before(grammarAccess.getProblemRuleAccess().getAsKeyword_2()); 
            match(input,50,FOLLOW_2); 
             after(grammarAccess.getProblemRuleAccess().getAsKeyword_2()); 

            }


            }

        }
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
    // InternalOptimisationLanguage.g:2007:1: rule__ProblemRule__Group__3 : rule__ProblemRule__Group__3__Impl rule__ProblemRule__Group__4 ;
    public final void rule__ProblemRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2011:1: ( rule__ProblemRule__Group__3__Impl rule__ProblemRule__Group__4 )
            // InternalOptimisationLanguage.g:2012:2: rule__ProblemRule__Group__3__Impl rule__ProblemRule__Group__4
            {
            pushFollow(FOLLOW_8);
            rule__ProblemRule__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ProblemRule__Group__4();

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
    // $ANTLR end "rule__ProblemRule__Group__3"


    // $ANTLR start "rule__ProblemRule__Group__3__Impl"
    // InternalOptimisationLanguage.g:2019:1: rule__ProblemRule__Group__3__Impl : ( ( rule__ProblemRule__ProblemAssignment_3 ) ) ;
    public final void rule__ProblemRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2023:1: ( ( ( rule__ProblemRule__ProblemAssignment_3 ) ) )
            // InternalOptimisationLanguage.g:2024:1: ( ( rule__ProblemRule__ProblemAssignment_3 ) )
            {
            // InternalOptimisationLanguage.g:2024:1: ( ( rule__ProblemRule__ProblemAssignment_3 ) )
            // InternalOptimisationLanguage.g:2025:2: ( rule__ProblemRule__ProblemAssignment_3 )
            {
             before(grammarAccess.getProblemRuleAccess().getProblemAssignment_3()); 
            // InternalOptimisationLanguage.g:2026:2: ( rule__ProblemRule__ProblemAssignment_3 )
            // InternalOptimisationLanguage.g:2026:3: rule__ProblemRule__ProblemAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__ProblemRule__ProblemAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getProblemRuleAccess().getProblemAssignment_3()); 

            }


            }

        }
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
    // InternalOptimisationLanguage.g:2034:1: rule__ProblemRule__Group__4 : rule__ProblemRule__Group__4__Impl ;
    public final void rule__ProblemRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2038:1: ( rule__ProblemRule__Group__4__Impl )
            // InternalOptimisationLanguage.g:2039:2: rule__ProblemRule__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ProblemRule__Group__4__Impl();

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
    // $ANTLR end "rule__ProblemRule__Group__4"


    // $ANTLR start "rule__ProblemRule__Group__4__Impl"
    // InternalOptimisationLanguage.g:2045:1: rule__ProblemRule__Group__4__Impl : ( ( rule__ProblemRule__Group_4__0 )? ) ;
    public final void rule__ProblemRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2049:1: ( ( ( rule__ProblemRule__Group_4__0 )? ) )
            // InternalOptimisationLanguage.g:2050:1: ( ( rule__ProblemRule__Group_4__0 )? )
            {
            // InternalOptimisationLanguage.g:2050:1: ( ( rule__ProblemRule__Group_4__0 )? )
            // InternalOptimisationLanguage.g:2051:2: ( rule__ProblemRule__Group_4__0 )?
            {
             before(grammarAccess.getProblemRuleAccess().getGroup_4()); 
            // InternalOptimisationLanguage.g:2052:2: ( rule__ProblemRule__Group_4__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==51) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalOptimisationLanguage.g:2052:3: rule__ProblemRule__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ProblemRule__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getProblemRuleAccess().getGroup_4()); 

            }


            }

        }
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


    // $ANTLR start "rule__ProblemRule__Group_4__0"
    // InternalOptimisationLanguage.g:2061:1: rule__ProblemRule__Group_4__0 : rule__ProblemRule__Group_4__0__Impl rule__ProblemRule__Group_4__1 ;
    public final void rule__ProblemRule__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2065:1: ( rule__ProblemRule__Group_4__0__Impl rule__ProblemRule__Group_4__1 )
            // InternalOptimisationLanguage.g:2066:2: rule__ProblemRule__Group_4__0__Impl rule__ProblemRule__Group_4__1
            {
            pushFollow(FOLLOW_9);
            rule__ProblemRule__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ProblemRule__Group_4__1();

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
    // $ANTLR end "rule__ProblemRule__Group_4__0"


    // $ANTLR start "rule__ProblemRule__Group_4__0__Impl"
    // InternalOptimisationLanguage.g:2073:1: rule__ProblemRule__Group_4__0__Impl : ( 'documenting' ) ;
    public final void rule__ProblemRule__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2077:1: ( ( 'documenting' ) )
            // InternalOptimisationLanguage.g:2078:1: ( 'documenting' )
            {
            // InternalOptimisationLanguage.g:2078:1: ( 'documenting' )
            // InternalOptimisationLanguage.g:2079:2: 'documenting'
            {
             before(grammarAccess.getProblemRuleAccess().getDocumentingKeyword_4_0()); 
            match(input,51,FOLLOW_2); 
             after(grammarAccess.getProblemRuleAccess().getDocumentingKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemRule__Group_4__0__Impl"


    // $ANTLR start "rule__ProblemRule__Group_4__1"
    // InternalOptimisationLanguage.g:2088:1: rule__ProblemRule__Group_4__1 : rule__ProblemRule__Group_4__1__Impl rule__ProblemRule__Group_4__2 ;
    public final void rule__ProblemRule__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2092:1: ( rule__ProblemRule__Group_4__1__Impl rule__ProblemRule__Group_4__2 )
            // InternalOptimisationLanguage.g:2093:2: rule__ProblemRule__Group_4__1__Impl rule__ProblemRule__Group_4__2
            {
            pushFollow(FOLLOW_10);
            rule__ProblemRule__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ProblemRule__Group_4__2();

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
    // $ANTLR end "rule__ProblemRule__Group_4__1"


    // $ANTLR start "rule__ProblemRule__Group_4__1__Impl"
    // InternalOptimisationLanguage.g:2100:1: rule__ProblemRule__Group_4__1__Impl : ( ':=' ) ;
    public final void rule__ProblemRule__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2104:1: ( ( ':=' ) )
            // InternalOptimisationLanguage.g:2105:1: ( ':=' )
            {
            // InternalOptimisationLanguage.g:2105:1: ( ':=' )
            // InternalOptimisationLanguage.g:2106:2: ':='
            {
             before(grammarAccess.getProblemRuleAccess().getColonEqualsSignKeyword_4_1()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getProblemRuleAccess().getColonEqualsSignKeyword_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemRule__Group_4__1__Impl"


    // $ANTLR start "rule__ProblemRule__Group_4__2"
    // InternalOptimisationLanguage.g:2115:1: rule__ProblemRule__Group_4__2 : rule__ProblemRule__Group_4__2__Impl rule__ProblemRule__Group_4__3 ;
    public final void rule__ProblemRule__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2119:1: ( rule__ProblemRule__Group_4__2__Impl rule__ProblemRule__Group_4__3 )
            // InternalOptimisationLanguage.g:2120:2: rule__ProblemRule__Group_4__2__Impl rule__ProblemRule__Group_4__3
            {
            pushFollow(FOLLOW_6);
            rule__ProblemRule__Group_4__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ProblemRule__Group_4__3();

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
    // $ANTLR end "rule__ProblemRule__Group_4__2"


    // $ANTLR start "rule__ProblemRule__Group_4__2__Impl"
    // InternalOptimisationLanguage.g:2127:1: rule__ProblemRule__Group_4__2__Impl : ( ( rule__ProblemRule__DocumentationAssignment_4_2 ) ) ;
    public final void rule__ProblemRule__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2131:1: ( ( ( rule__ProblemRule__DocumentationAssignment_4_2 ) ) )
            // InternalOptimisationLanguage.g:2132:1: ( ( rule__ProblemRule__DocumentationAssignment_4_2 ) )
            {
            // InternalOptimisationLanguage.g:2132:1: ( ( rule__ProblemRule__DocumentationAssignment_4_2 ) )
            // InternalOptimisationLanguage.g:2133:2: ( rule__ProblemRule__DocumentationAssignment_4_2 )
            {
             before(grammarAccess.getProblemRuleAccess().getDocumentationAssignment_4_2()); 
            // InternalOptimisationLanguage.g:2134:2: ( rule__ProblemRule__DocumentationAssignment_4_2 )
            // InternalOptimisationLanguage.g:2134:3: rule__ProblemRule__DocumentationAssignment_4_2
            {
            pushFollow(FOLLOW_2);
            rule__ProblemRule__DocumentationAssignment_4_2();

            state._fsp--;


            }

             after(grammarAccess.getProblemRuleAccess().getDocumentationAssignment_4_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemRule__Group_4__2__Impl"


    // $ANTLR start "rule__ProblemRule__Group_4__3"
    // InternalOptimisationLanguage.g:2142:1: rule__ProblemRule__Group_4__3 : rule__ProblemRule__Group_4__3__Impl ;
    public final void rule__ProblemRule__Group_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2146:1: ( rule__ProblemRule__Group_4__3__Impl )
            // InternalOptimisationLanguage.g:2147:2: rule__ProblemRule__Group_4__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ProblemRule__Group_4__3__Impl();

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
    // $ANTLR end "rule__ProblemRule__Group_4__3"


    // $ANTLR start "rule__ProblemRule__Group_4__3__Impl"
    // InternalOptimisationLanguage.g:2153:1: rule__ProblemRule__Group_4__3__Impl : ( ';' ) ;
    public final void rule__ProblemRule__Group_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2157:1: ( ( ';' ) )
            // InternalOptimisationLanguage.g:2158:1: ( ';' )
            {
            // InternalOptimisationLanguage.g:2158:1: ( ';' )
            // InternalOptimisationLanguage.g:2159:2: ';'
            {
             before(grammarAccess.getProblemRuleAccess().getSemicolonKeyword_4_3()); 
            match(input,48,FOLLOW_2); 
             after(grammarAccess.getProblemRuleAccess().getSemicolonKeyword_4_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemRule__Group_4__3__Impl"


    // $ANTLR start "rule__AlgorithmInstanceRule__Group__0"
    // InternalOptimisationLanguage.g:2169:1: rule__AlgorithmInstanceRule__Group__0 : rule__AlgorithmInstanceRule__Group__0__Impl rule__AlgorithmInstanceRule__Group__1 ;
    public final void rule__AlgorithmInstanceRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2173:1: ( rule__AlgorithmInstanceRule__Group__0__Impl rule__AlgorithmInstanceRule__Group__1 )
            // InternalOptimisationLanguage.g:2174:2: rule__AlgorithmInstanceRule__Group__0__Impl rule__AlgorithmInstanceRule__Group__1
            {
            pushFollow(FOLLOW_11);
            rule__AlgorithmInstanceRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AlgorithmInstanceRule__Group__1();

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
    // $ANTLR end "rule__AlgorithmInstanceRule__Group__0"


    // $ANTLR start "rule__AlgorithmInstanceRule__Group__0__Impl"
    // InternalOptimisationLanguage.g:2181:1: rule__AlgorithmInstanceRule__Group__0__Impl : ( 'instance' ) ;
    public final void rule__AlgorithmInstanceRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2185:1: ( ( 'instance' ) )
            // InternalOptimisationLanguage.g:2186:1: ( 'instance' )
            {
            // InternalOptimisationLanguage.g:2186:1: ( 'instance' )
            // InternalOptimisationLanguage.g:2187:2: 'instance'
            {
             before(grammarAccess.getAlgorithmInstanceRuleAccess().getInstanceKeyword_0()); 
            match(input,53,FOLLOW_2); 
             after(grammarAccess.getAlgorithmInstanceRuleAccess().getInstanceKeyword_0()); 

            }


            }

        }
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
    // InternalOptimisationLanguage.g:2196:1: rule__AlgorithmInstanceRule__Group__1 : rule__AlgorithmInstanceRule__Group__1__Impl rule__AlgorithmInstanceRule__Group__2 ;
    public final void rule__AlgorithmInstanceRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2200:1: ( rule__AlgorithmInstanceRule__Group__1__Impl rule__AlgorithmInstanceRule__Group__2 )
            // InternalOptimisationLanguage.g:2201:2: rule__AlgorithmInstanceRule__Group__1__Impl rule__AlgorithmInstanceRule__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__AlgorithmInstanceRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AlgorithmInstanceRule__Group__2();

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
    // $ANTLR end "rule__AlgorithmInstanceRule__Group__1"


    // $ANTLR start "rule__AlgorithmInstanceRule__Group__1__Impl"
    // InternalOptimisationLanguage.g:2208:1: rule__AlgorithmInstanceRule__Group__1__Impl : ( 'for' ) ;
    public final void rule__AlgorithmInstanceRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2212:1: ( ( 'for' ) )
            // InternalOptimisationLanguage.g:2213:1: ( 'for' )
            {
            // InternalOptimisationLanguage.g:2213:1: ( 'for' )
            // InternalOptimisationLanguage.g:2214:2: 'for'
            {
             before(grammarAccess.getAlgorithmInstanceRuleAccess().getForKeyword_1()); 
            match(input,54,FOLLOW_2); 
             after(grammarAccess.getAlgorithmInstanceRuleAccess().getForKeyword_1()); 

            }


            }

        }
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
    // InternalOptimisationLanguage.g:2223:1: rule__AlgorithmInstanceRule__Group__2 : rule__AlgorithmInstanceRule__Group__2__Impl rule__AlgorithmInstanceRule__Group__3 ;
    public final void rule__AlgorithmInstanceRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2227:1: ( rule__AlgorithmInstanceRule__Group__2__Impl rule__AlgorithmInstanceRule__Group__3 )
            // InternalOptimisationLanguage.g:2228:2: rule__AlgorithmInstanceRule__Group__2__Impl rule__AlgorithmInstanceRule__Group__3
            {
            pushFollow(FOLLOW_12);
            rule__AlgorithmInstanceRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AlgorithmInstanceRule__Group__3();

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
    // $ANTLR end "rule__AlgorithmInstanceRule__Group__2"


    // $ANTLR start "rule__AlgorithmInstanceRule__Group__2__Impl"
    // InternalOptimisationLanguage.g:2235:1: rule__AlgorithmInstanceRule__Group__2__Impl : ( ( rule__AlgorithmInstanceRule__ProblemAssignment_2 ) ) ;
    public final void rule__AlgorithmInstanceRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2239:1: ( ( ( rule__AlgorithmInstanceRule__ProblemAssignment_2 ) ) )
            // InternalOptimisationLanguage.g:2240:1: ( ( rule__AlgorithmInstanceRule__ProblemAssignment_2 ) )
            {
            // InternalOptimisationLanguage.g:2240:1: ( ( rule__AlgorithmInstanceRule__ProblemAssignment_2 ) )
            // InternalOptimisationLanguage.g:2241:2: ( rule__AlgorithmInstanceRule__ProblemAssignment_2 )
            {
             before(grammarAccess.getAlgorithmInstanceRuleAccess().getProblemAssignment_2()); 
            // InternalOptimisationLanguage.g:2242:2: ( rule__AlgorithmInstanceRule__ProblemAssignment_2 )
            // InternalOptimisationLanguage.g:2242:3: rule__AlgorithmInstanceRule__ProblemAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__AlgorithmInstanceRule__ProblemAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getAlgorithmInstanceRuleAccess().getProblemAssignment_2()); 

            }


            }

        }
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
    // InternalOptimisationLanguage.g:2250:1: rule__AlgorithmInstanceRule__Group__3 : rule__AlgorithmInstanceRule__Group__3__Impl rule__AlgorithmInstanceRule__Group__4 ;
    public final void rule__AlgorithmInstanceRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2254:1: ( rule__AlgorithmInstanceRule__Group__3__Impl rule__AlgorithmInstanceRule__Group__4 )
            // InternalOptimisationLanguage.g:2255:2: rule__AlgorithmInstanceRule__Group__3__Impl rule__AlgorithmInstanceRule__Group__4
            {
            pushFollow(FOLLOW_13);
            rule__AlgorithmInstanceRule__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AlgorithmInstanceRule__Group__4();

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
    // $ANTLR end "rule__AlgorithmInstanceRule__Group__3"


    // $ANTLR start "rule__AlgorithmInstanceRule__Group__3__Impl"
    // InternalOptimisationLanguage.g:2262:1: rule__AlgorithmInstanceRule__Group__3__Impl : ( 'with' ) ;
    public final void rule__AlgorithmInstanceRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2266:1: ( ( 'with' ) )
            // InternalOptimisationLanguage.g:2267:1: ( 'with' )
            {
            // InternalOptimisationLanguage.g:2267:1: ( 'with' )
            // InternalOptimisationLanguage.g:2268:2: 'with'
            {
             before(grammarAccess.getAlgorithmInstanceRuleAccess().getWithKeyword_3()); 
            match(input,55,FOLLOW_2); 
             after(grammarAccess.getAlgorithmInstanceRuleAccess().getWithKeyword_3()); 

            }


            }

        }
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
    // InternalOptimisationLanguage.g:2277:1: rule__AlgorithmInstanceRule__Group__4 : rule__AlgorithmInstanceRule__Group__4__Impl rule__AlgorithmInstanceRule__Group__5 ;
    public final void rule__AlgorithmInstanceRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2281:1: ( rule__AlgorithmInstanceRule__Group__4__Impl rule__AlgorithmInstanceRule__Group__5 )
            // InternalOptimisationLanguage.g:2282:2: rule__AlgorithmInstanceRule__Group__4__Impl rule__AlgorithmInstanceRule__Group__5
            {
            pushFollow(FOLLOW_5);
            rule__AlgorithmInstanceRule__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AlgorithmInstanceRule__Group__5();

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
    // $ANTLR end "rule__AlgorithmInstanceRule__Group__4"


    // $ANTLR start "rule__AlgorithmInstanceRule__Group__4__Impl"
    // InternalOptimisationLanguage.g:2289:1: rule__AlgorithmInstanceRule__Group__4__Impl : ( 'algorithm' ) ;
    public final void rule__AlgorithmInstanceRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2293:1: ( ( 'algorithm' ) )
            // InternalOptimisationLanguage.g:2294:1: ( 'algorithm' )
            {
            // InternalOptimisationLanguage.g:2294:1: ( 'algorithm' )
            // InternalOptimisationLanguage.g:2295:2: 'algorithm'
            {
             before(grammarAccess.getAlgorithmInstanceRuleAccess().getAlgorithmKeyword_4()); 
            match(input,56,FOLLOW_2); 
             after(grammarAccess.getAlgorithmInstanceRuleAccess().getAlgorithmKeyword_4()); 

            }


            }

        }
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
    // InternalOptimisationLanguage.g:2304:1: rule__AlgorithmInstanceRule__Group__5 : rule__AlgorithmInstanceRule__Group__5__Impl rule__AlgorithmInstanceRule__Group__6 ;
    public final void rule__AlgorithmInstanceRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2308:1: ( rule__AlgorithmInstanceRule__Group__5__Impl rule__AlgorithmInstanceRule__Group__6 )
            // InternalOptimisationLanguage.g:2309:2: rule__AlgorithmInstanceRule__Group__5__Impl rule__AlgorithmInstanceRule__Group__6
            {
            pushFollow(FOLLOW_8);
            rule__AlgorithmInstanceRule__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AlgorithmInstanceRule__Group__6();

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
    // $ANTLR end "rule__AlgorithmInstanceRule__Group__5"


    // $ANTLR start "rule__AlgorithmInstanceRule__Group__5__Impl"
    // InternalOptimisationLanguage.g:2316:1: rule__AlgorithmInstanceRule__Group__5__Impl : ( ( rule__AlgorithmInstanceRule__AlgorithmAssignment_5 ) ) ;
    public final void rule__AlgorithmInstanceRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2320:1: ( ( ( rule__AlgorithmInstanceRule__AlgorithmAssignment_5 ) ) )
            // InternalOptimisationLanguage.g:2321:1: ( ( rule__AlgorithmInstanceRule__AlgorithmAssignment_5 ) )
            {
            // InternalOptimisationLanguage.g:2321:1: ( ( rule__AlgorithmInstanceRule__AlgorithmAssignment_5 ) )
            // InternalOptimisationLanguage.g:2322:2: ( rule__AlgorithmInstanceRule__AlgorithmAssignment_5 )
            {
             before(grammarAccess.getAlgorithmInstanceRuleAccess().getAlgorithmAssignment_5()); 
            // InternalOptimisationLanguage.g:2323:2: ( rule__AlgorithmInstanceRule__AlgorithmAssignment_5 )
            // InternalOptimisationLanguage.g:2323:3: rule__AlgorithmInstanceRule__AlgorithmAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__AlgorithmInstanceRule__AlgorithmAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getAlgorithmInstanceRuleAccess().getAlgorithmAssignment_5()); 

            }


            }

        }
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
    // InternalOptimisationLanguage.g:2331:1: rule__AlgorithmInstanceRule__Group__6 : rule__AlgorithmInstanceRule__Group__6__Impl ;
    public final void rule__AlgorithmInstanceRule__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2335:1: ( rule__AlgorithmInstanceRule__Group__6__Impl )
            // InternalOptimisationLanguage.g:2336:2: rule__AlgorithmInstanceRule__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AlgorithmInstanceRule__Group__6__Impl();

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
    // $ANTLR end "rule__AlgorithmInstanceRule__Group__6"


    // $ANTLR start "rule__AlgorithmInstanceRule__Group__6__Impl"
    // InternalOptimisationLanguage.g:2342:1: rule__AlgorithmInstanceRule__Group__6__Impl : ( ( rule__AlgorithmInstanceRule__Group_6__0 )? ) ;
    public final void rule__AlgorithmInstanceRule__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2346:1: ( ( ( rule__AlgorithmInstanceRule__Group_6__0 )? ) )
            // InternalOptimisationLanguage.g:2347:1: ( ( rule__AlgorithmInstanceRule__Group_6__0 )? )
            {
            // InternalOptimisationLanguage.g:2347:1: ( ( rule__AlgorithmInstanceRule__Group_6__0 )? )
            // InternalOptimisationLanguage.g:2348:2: ( rule__AlgorithmInstanceRule__Group_6__0 )?
            {
             before(grammarAccess.getAlgorithmInstanceRuleAccess().getGroup_6()); 
            // InternalOptimisationLanguage.g:2349:2: ( rule__AlgorithmInstanceRule__Group_6__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==51) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalOptimisationLanguage.g:2349:3: rule__AlgorithmInstanceRule__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__AlgorithmInstanceRule__Group_6__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAlgorithmInstanceRuleAccess().getGroup_6()); 

            }


            }

        }
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


    // $ANTLR start "rule__AlgorithmInstanceRule__Group_6__0"
    // InternalOptimisationLanguage.g:2358:1: rule__AlgorithmInstanceRule__Group_6__0 : rule__AlgorithmInstanceRule__Group_6__0__Impl rule__AlgorithmInstanceRule__Group_6__1 ;
    public final void rule__AlgorithmInstanceRule__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2362:1: ( rule__AlgorithmInstanceRule__Group_6__0__Impl rule__AlgorithmInstanceRule__Group_6__1 )
            // InternalOptimisationLanguage.g:2363:2: rule__AlgorithmInstanceRule__Group_6__0__Impl rule__AlgorithmInstanceRule__Group_6__1
            {
            pushFollow(FOLLOW_9);
            rule__AlgorithmInstanceRule__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AlgorithmInstanceRule__Group_6__1();

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
    // $ANTLR end "rule__AlgorithmInstanceRule__Group_6__0"


    // $ANTLR start "rule__AlgorithmInstanceRule__Group_6__0__Impl"
    // InternalOptimisationLanguage.g:2370:1: rule__AlgorithmInstanceRule__Group_6__0__Impl : ( 'documenting' ) ;
    public final void rule__AlgorithmInstanceRule__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2374:1: ( ( 'documenting' ) )
            // InternalOptimisationLanguage.g:2375:1: ( 'documenting' )
            {
            // InternalOptimisationLanguage.g:2375:1: ( 'documenting' )
            // InternalOptimisationLanguage.g:2376:2: 'documenting'
            {
             before(grammarAccess.getAlgorithmInstanceRuleAccess().getDocumentingKeyword_6_0()); 
            match(input,51,FOLLOW_2); 
             after(grammarAccess.getAlgorithmInstanceRuleAccess().getDocumentingKeyword_6_0()); 

            }


            }

        }
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
    // InternalOptimisationLanguage.g:2385:1: rule__AlgorithmInstanceRule__Group_6__1 : rule__AlgorithmInstanceRule__Group_6__1__Impl rule__AlgorithmInstanceRule__Group_6__2 ;
    public final void rule__AlgorithmInstanceRule__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2389:1: ( rule__AlgorithmInstanceRule__Group_6__1__Impl rule__AlgorithmInstanceRule__Group_6__2 )
            // InternalOptimisationLanguage.g:2390:2: rule__AlgorithmInstanceRule__Group_6__1__Impl rule__AlgorithmInstanceRule__Group_6__2
            {
            pushFollow(FOLLOW_10);
            rule__AlgorithmInstanceRule__Group_6__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AlgorithmInstanceRule__Group_6__2();

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
    // $ANTLR end "rule__AlgorithmInstanceRule__Group_6__1"


    // $ANTLR start "rule__AlgorithmInstanceRule__Group_6__1__Impl"
    // InternalOptimisationLanguage.g:2397:1: rule__AlgorithmInstanceRule__Group_6__1__Impl : ( ':=' ) ;
    public final void rule__AlgorithmInstanceRule__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2401:1: ( ( ':=' ) )
            // InternalOptimisationLanguage.g:2402:1: ( ':=' )
            {
            // InternalOptimisationLanguage.g:2402:1: ( ':=' )
            // InternalOptimisationLanguage.g:2403:2: ':='
            {
             before(grammarAccess.getAlgorithmInstanceRuleAccess().getColonEqualsSignKeyword_6_1()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getAlgorithmInstanceRuleAccess().getColonEqualsSignKeyword_6_1()); 

            }


            }

        }
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
    // InternalOptimisationLanguage.g:2412:1: rule__AlgorithmInstanceRule__Group_6__2 : rule__AlgorithmInstanceRule__Group_6__2__Impl rule__AlgorithmInstanceRule__Group_6__3 ;
    public final void rule__AlgorithmInstanceRule__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2416:1: ( rule__AlgorithmInstanceRule__Group_6__2__Impl rule__AlgorithmInstanceRule__Group_6__3 )
            // InternalOptimisationLanguage.g:2417:2: rule__AlgorithmInstanceRule__Group_6__2__Impl rule__AlgorithmInstanceRule__Group_6__3
            {
            pushFollow(FOLLOW_6);
            rule__AlgorithmInstanceRule__Group_6__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AlgorithmInstanceRule__Group_6__3();

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
    // $ANTLR end "rule__AlgorithmInstanceRule__Group_6__2"


    // $ANTLR start "rule__AlgorithmInstanceRule__Group_6__2__Impl"
    // InternalOptimisationLanguage.g:2424:1: rule__AlgorithmInstanceRule__Group_6__2__Impl : ( ( rule__AlgorithmInstanceRule__DocumentationAssignment_6_2 ) ) ;
    public final void rule__AlgorithmInstanceRule__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2428:1: ( ( ( rule__AlgorithmInstanceRule__DocumentationAssignment_6_2 ) ) )
            // InternalOptimisationLanguage.g:2429:1: ( ( rule__AlgorithmInstanceRule__DocumentationAssignment_6_2 ) )
            {
            // InternalOptimisationLanguage.g:2429:1: ( ( rule__AlgorithmInstanceRule__DocumentationAssignment_6_2 ) )
            // InternalOptimisationLanguage.g:2430:2: ( rule__AlgorithmInstanceRule__DocumentationAssignment_6_2 )
            {
             before(grammarAccess.getAlgorithmInstanceRuleAccess().getDocumentationAssignment_6_2()); 
            // InternalOptimisationLanguage.g:2431:2: ( rule__AlgorithmInstanceRule__DocumentationAssignment_6_2 )
            // InternalOptimisationLanguage.g:2431:3: rule__AlgorithmInstanceRule__DocumentationAssignment_6_2
            {
            pushFollow(FOLLOW_2);
            rule__AlgorithmInstanceRule__DocumentationAssignment_6_2();

            state._fsp--;


            }

             after(grammarAccess.getAlgorithmInstanceRuleAccess().getDocumentationAssignment_6_2()); 

            }


            }

        }
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
    // InternalOptimisationLanguage.g:2439:1: rule__AlgorithmInstanceRule__Group_6__3 : rule__AlgorithmInstanceRule__Group_6__3__Impl ;
    public final void rule__AlgorithmInstanceRule__Group_6__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2443:1: ( rule__AlgorithmInstanceRule__Group_6__3__Impl )
            // InternalOptimisationLanguage.g:2444:2: rule__AlgorithmInstanceRule__Group_6__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AlgorithmInstanceRule__Group_6__3__Impl();

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
    // $ANTLR end "rule__AlgorithmInstanceRule__Group_6__3"


    // $ANTLR start "rule__AlgorithmInstanceRule__Group_6__3__Impl"
    // InternalOptimisationLanguage.g:2450:1: rule__AlgorithmInstanceRule__Group_6__3__Impl : ( ';' ) ;
    public final void rule__AlgorithmInstanceRule__Group_6__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2454:1: ( ( ';' ) )
            // InternalOptimisationLanguage.g:2455:1: ( ';' )
            {
            // InternalOptimisationLanguage.g:2455:1: ( ';' )
            // InternalOptimisationLanguage.g:2456:2: ';'
            {
             before(grammarAccess.getAlgorithmInstanceRuleAccess().getSemicolonKeyword_6_3()); 
            match(input,48,FOLLOW_2); 
             after(grammarAccess.getAlgorithmInstanceRuleAccess().getSemicolonKeyword_6_3()); 

            }


            }

        }
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


    // $ANTLR start "rule__InstanceRule__Group__0"
    // InternalOptimisationLanguage.g:2466:1: rule__InstanceRule__Group__0 : rule__InstanceRule__Group__0__Impl rule__InstanceRule__Group__1 ;
    public final void rule__InstanceRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2470:1: ( rule__InstanceRule__Group__0__Impl rule__InstanceRule__Group__1 )
            // InternalOptimisationLanguage.g:2471:2: rule__InstanceRule__Group__0__Impl rule__InstanceRule__Group__1
            {
            pushFollow(FOLLOW_14);
            rule__InstanceRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__InstanceRule__Group__1();

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
    // $ANTLR end "rule__InstanceRule__Group__0"


    // $ANTLR start "rule__InstanceRule__Group__0__Impl"
    // InternalOptimisationLanguage.g:2478:1: rule__InstanceRule__Group__0__Impl : ( ( rule__InstanceRule__DefinitionAssignment_0 ) ) ;
    public final void rule__InstanceRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2482:1: ( ( ( rule__InstanceRule__DefinitionAssignment_0 ) ) )
            // InternalOptimisationLanguage.g:2483:1: ( ( rule__InstanceRule__DefinitionAssignment_0 ) )
            {
            // InternalOptimisationLanguage.g:2483:1: ( ( rule__InstanceRule__DefinitionAssignment_0 ) )
            // InternalOptimisationLanguage.g:2484:2: ( rule__InstanceRule__DefinitionAssignment_0 )
            {
             before(grammarAccess.getInstanceRuleAccess().getDefinitionAssignment_0()); 
            // InternalOptimisationLanguage.g:2485:2: ( rule__InstanceRule__DefinitionAssignment_0 )
            // InternalOptimisationLanguage.g:2485:3: rule__InstanceRule__DefinitionAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__InstanceRule__DefinitionAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getInstanceRuleAccess().getDefinitionAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceRule__Group__0__Impl"


    // $ANTLR start "rule__InstanceRule__Group__1"
    // InternalOptimisationLanguage.g:2493:1: rule__InstanceRule__Group__1 : rule__InstanceRule__Group__1__Impl ;
    public final void rule__InstanceRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2497:1: ( rule__InstanceRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:2498:2: rule__InstanceRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__InstanceRule__Group__1__Impl();

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
    // $ANTLR end "rule__InstanceRule__Group__1"


    // $ANTLR start "rule__InstanceRule__Group__1__Impl"
    // InternalOptimisationLanguage.g:2504:1: rule__InstanceRule__Group__1__Impl : ( ( rule__InstanceRule__Group_1__0 )? ) ;
    public final void rule__InstanceRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2508:1: ( ( ( rule__InstanceRule__Group_1__0 )? ) )
            // InternalOptimisationLanguage.g:2509:1: ( ( rule__InstanceRule__Group_1__0 )? )
            {
            // InternalOptimisationLanguage.g:2509:1: ( ( rule__InstanceRule__Group_1__0 )? )
            // InternalOptimisationLanguage.g:2510:2: ( rule__InstanceRule__Group_1__0 )?
            {
             before(grammarAccess.getInstanceRuleAccess().getGroup_1()); 
            // InternalOptimisationLanguage.g:2511:2: ( rule__InstanceRule__Group_1__0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==57) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalOptimisationLanguage.g:2511:3: rule__InstanceRule__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__InstanceRule__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getInstanceRuleAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceRule__Group__1__Impl"


    // $ANTLR start "rule__InstanceRule__Group_1__0"
    // InternalOptimisationLanguage.g:2520:1: rule__InstanceRule__Group_1__0 : rule__InstanceRule__Group_1__0__Impl rule__InstanceRule__Group_1__1 ;
    public final void rule__InstanceRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2524:1: ( rule__InstanceRule__Group_1__0__Impl rule__InstanceRule__Group_1__1 )
            // InternalOptimisationLanguage.g:2525:2: rule__InstanceRule__Group_1__0__Impl rule__InstanceRule__Group_1__1
            {
            pushFollow(FOLLOW_15);
            rule__InstanceRule__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__InstanceRule__Group_1__1();

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
    // $ANTLR end "rule__InstanceRule__Group_1__0"


    // $ANTLR start "rule__InstanceRule__Group_1__0__Impl"
    // InternalOptimisationLanguage.g:2532:1: rule__InstanceRule__Group_1__0__Impl : ( '{' ) ;
    public final void rule__InstanceRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2536:1: ( ( '{' ) )
            // InternalOptimisationLanguage.g:2537:1: ( '{' )
            {
            // InternalOptimisationLanguage.g:2537:1: ( '{' )
            // InternalOptimisationLanguage.g:2538:2: '{'
            {
             before(grammarAccess.getInstanceRuleAccess().getLeftCurlyBracketKeyword_1_0()); 
            match(input,57,FOLLOW_2); 
             after(grammarAccess.getInstanceRuleAccess().getLeftCurlyBracketKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceRule__Group_1__0__Impl"


    // $ANTLR start "rule__InstanceRule__Group_1__1"
    // InternalOptimisationLanguage.g:2547:1: rule__InstanceRule__Group_1__1 : rule__InstanceRule__Group_1__1__Impl rule__InstanceRule__Group_1__2 ;
    public final void rule__InstanceRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2551:1: ( rule__InstanceRule__Group_1__1__Impl rule__InstanceRule__Group_1__2 )
            // InternalOptimisationLanguage.g:2552:2: rule__InstanceRule__Group_1__1__Impl rule__InstanceRule__Group_1__2
            {
            pushFollow(FOLLOW_15);
            rule__InstanceRule__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__InstanceRule__Group_1__2();

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
    // $ANTLR end "rule__InstanceRule__Group_1__1"


    // $ANTLR start "rule__InstanceRule__Group_1__1__Impl"
    // InternalOptimisationLanguage.g:2559:1: rule__InstanceRule__Group_1__1__Impl : ( ( rule__InstanceRule__AttributesAssignment_1_1 )* ) ;
    public final void rule__InstanceRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2563:1: ( ( ( rule__InstanceRule__AttributesAssignment_1_1 )* ) )
            // InternalOptimisationLanguage.g:2564:1: ( ( rule__InstanceRule__AttributesAssignment_1_1 )* )
            {
            // InternalOptimisationLanguage.g:2564:1: ( ( rule__InstanceRule__AttributesAssignment_1_1 )* )
            // InternalOptimisationLanguage.g:2565:2: ( rule__InstanceRule__AttributesAssignment_1_1 )*
            {
             before(grammarAccess.getInstanceRuleAccess().getAttributesAssignment_1_1()); 
            // InternalOptimisationLanguage.g:2566:2: ( rule__InstanceRule__AttributesAssignment_1_1 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>=RULE_QUOTED_ID && LA18_0<=RULE_ID)) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:2566:3: rule__InstanceRule__AttributesAssignment_1_1
            	    {
            	    pushFollow(FOLLOW_16);
            	    rule__InstanceRule__AttributesAssignment_1_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

             after(grammarAccess.getInstanceRuleAccess().getAttributesAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceRule__Group_1__1__Impl"


    // $ANTLR start "rule__InstanceRule__Group_1__2"
    // InternalOptimisationLanguage.g:2574:1: rule__InstanceRule__Group_1__2 : rule__InstanceRule__Group_1__2__Impl ;
    public final void rule__InstanceRule__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2578:1: ( rule__InstanceRule__Group_1__2__Impl )
            // InternalOptimisationLanguage.g:2579:2: rule__InstanceRule__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__InstanceRule__Group_1__2__Impl();

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
    // $ANTLR end "rule__InstanceRule__Group_1__2"


    // $ANTLR start "rule__InstanceRule__Group_1__2__Impl"
    // InternalOptimisationLanguage.g:2585:1: rule__InstanceRule__Group_1__2__Impl : ( '}' ) ;
    public final void rule__InstanceRule__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2589:1: ( ( '}' ) )
            // InternalOptimisationLanguage.g:2590:1: ( '}' )
            {
            // InternalOptimisationLanguage.g:2590:1: ( '}' )
            // InternalOptimisationLanguage.g:2591:2: '}'
            {
             before(grammarAccess.getInstanceRuleAccess().getRightCurlyBracketKeyword_1_2()); 
            match(input,58,FOLLOW_2); 
             after(grammarAccess.getInstanceRuleAccess().getRightCurlyBracketKeyword_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceRule__Group_1__2__Impl"


    // $ANTLR start "rule__AttributeRule__Group__0"
    // InternalOptimisationLanguage.g:2601:1: rule__AttributeRule__Group__0 : rule__AttributeRule__Group__0__Impl rule__AttributeRule__Group__1 ;
    public final void rule__AttributeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2605:1: ( rule__AttributeRule__Group__0__Impl rule__AttributeRule__Group__1 )
            // InternalOptimisationLanguage.g:2606:2: rule__AttributeRule__Group__0__Impl rule__AttributeRule__Group__1
            {
            pushFollow(FOLLOW_9);
            rule__AttributeRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AttributeRule__Group__1();

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
    // $ANTLR end "rule__AttributeRule__Group__0"


    // $ANTLR start "rule__AttributeRule__Group__0__Impl"
    // InternalOptimisationLanguage.g:2613:1: rule__AttributeRule__Group__0__Impl : ( ( rule__AttributeRule__DefinitionAssignment_0 ) ) ;
    public final void rule__AttributeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2617:1: ( ( ( rule__AttributeRule__DefinitionAssignment_0 ) ) )
            // InternalOptimisationLanguage.g:2618:1: ( ( rule__AttributeRule__DefinitionAssignment_0 ) )
            {
            // InternalOptimisationLanguage.g:2618:1: ( ( rule__AttributeRule__DefinitionAssignment_0 ) )
            // InternalOptimisationLanguage.g:2619:2: ( rule__AttributeRule__DefinitionAssignment_0 )
            {
             before(grammarAccess.getAttributeRuleAccess().getDefinitionAssignment_0()); 
            // InternalOptimisationLanguage.g:2620:2: ( rule__AttributeRule__DefinitionAssignment_0 )
            // InternalOptimisationLanguage.g:2620:3: rule__AttributeRule__DefinitionAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__AttributeRule__DefinitionAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getAttributeRuleAccess().getDefinitionAssignment_0()); 

            }


            }

        }
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
    // InternalOptimisationLanguage.g:2628:1: rule__AttributeRule__Group__1 : rule__AttributeRule__Group__1__Impl rule__AttributeRule__Group__2 ;
    public final void rule__AttributeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2632:1: ( rule__AttributeRule__Group__1__Impl rule__AttributeRule__Group__2 )
            // InternalOptimisationLanguage.g:2633:2: rule__AttributeRule__Group__1__Impl rule__AttributeRule__Group__2
            {
            pushFollow(FOLLOW_17);
            rule__AttributeRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AttributeRule__Group__2();

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
    // $ANTLR end "rule__AttributeRule__Group__1"


    // $ANTLR start "rule__AttributeRule__Group__1__Impl"
    // InternalOptimisationLanguage.g:2640:1: rule__AttributeRule__Group__1__Impl : ( ':=' ) ;
    public final void rule__AttributeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2644:1: ( ( ':=' ) )
            // InternalOptimisationLanguage.g:2645:1: ( ':=' )
            {
            // InternalOptimisationLanguage.g:2645:1: ( ':=' )
            // InternalOptimisationLanguage.g:2646:2: ':='
            {
             before(grammarAccess.getAttributeRuleAccess().getColonEqualsSignKeyword_1()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getAttributeRuleAccess().getColonEqualsSignKeyword_1()); 

            }


            }

        }
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
    // InternalOptimisationLanguage.g:2655:1: rule__AttributeRule__Group__2 : rule__AttributeRule__Group__2__Impl rule__AttributeRule__Group__3 ;
    public final void rule__AttributeRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2659:1: ( rule__AttributeRule__Group__2__Impl rule__AttributeRule__Group__3 )
            // InternalOptimisationLanguage.g:2660:2: rule__AttributeRule__Group__2__Impl rule__AttributeRule__Group__3
            {
            pushFollow(FOLLOW_6);
            rule__AttributeRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AttributeRule__Group__3();

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
    // $ANTLR end "rule__AttributeRule__Group__2"


    // $ANTLR start "rule__AttributeRule__Group__2__Impl"
    // InternalOptimisationLanguage.g:2667:1: rule__AttributeRule__Group__2__Impl : ( ( rule__AttributeRule__ValueAssignment_2 ) ) ;
    public final void rule__AttributeRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2671:1: ( ( ( rule__AttributeRule__ValueAssignment_2 ) ) )
            // InternalOptimisationLanguage.g:2672:1: ( ( rule__AttributeRule__ValueAssignment_2 ) )
            {
            // InternalOptimisationLanguage.g:2672:1: ( ( rule__AttributeRule__ValueAssignment_2 ) )
            // InternalOptimisationLanguage.g:2673:2: ( rule__AttributeRule__ValueAssignment_2 )
            {
             before(grammarAccess.getAttributeRuleAccess().getValueAssignment_2()); 
            // InternalOptimisationLanguage.g:2674:2: ( rule__AttributeRule__ValueAssignment_2 )
            // InternalOptimisationLanguage.g:2674:3: rule__AttributeRule__ValueAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__AttributeRule__ValueAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getAttributeRuleAccess().getValueAssignment_2()); 

            }


            }

        }
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
    // InternalOptimisationLanguage.g:2682:1: rule__AttributeRule__Group__3 : rule__AttributeRule__Group__3__Impl ;
    public final void rule__AttributeRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2686:1: ( rule__AttributeRule__Group__3__Impl )
            // InternalOptimisationLanguage.g:2687:2: rule__AttributeRule__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AttributeRule__Group__3__Impl();

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
    // $ANTLR end "rule__AttributeRule__Group__3"


    // $ANTLR start "rule__AttributeRule__Group__3__Impl"
    // InternalOptimisationLanguage.g:2693:1: rule__AttributeRule__Group__3__Impl : ( ';' ) ;
    public final void rule__AttributeRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2697:1: ( ( ';' ) )
            // InternalOptimisationLanguage.g:2698:1: ( ';' )
            {
            // InternalOptimisationLanguage.g:2698:1: ( ';' )
            // InternalOptimisationLanguage.g:2699:2: ';'
            {
             before(grammarAccess.getAttributeRuleAccess().getSemicolonKeyword_3()); 
            match(input,48,FOLLOW_2); 
             after(grammarAccess.getAttributeRuleAccess().getSemicolonKeyword_3()); 

            }


            }

        }
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


    // $ANTLR start "rule__ArrayRule__Group__0"
    // InternalOptimisationLanguage.g:2709:1: rule__ArrayRule__Group__0 : rule__ArrayRule__Group__0__Impl rule__ArrayRule__Group__1 ;
    public final void rule__ArrayRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2713:1: ( rule__ArrayRule__Group__0__Impl rule__ArrayRule__Group__1 )
            // InternalOptimisationLanguage.g:2714:2: rule__ArrayRule__Group__0__Impl rule__ArrayRule__Group__1
            {
            pushFollow(FOLLOW_10);
            rule__ArrayRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ArrayRule__Group__1();

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
    // $ANTLR end "rule__ArrayRule__Group__0"


    // $ANTLR start "rule__ArrayRule__Group__0__Impl"
    // InternalOptimisationLanguage.g:2721:1: rule__ArrayRule__Group__0__Impl : ( () ) ;
    public final void rule__ArrayRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2725:1: ( ( () ) )
            // InternalOptimisationLanguage.g:2726:1: ( () )
            {
            // InternalOptimisationLanguage.g:2726:1: ( () )
            // InternalOptimisationLanguage.g:2727:2: ()
            {
             before(grammarAccess.getArrayRuleAccess().getArrayAction_0()); 
            // InternalOptimisationLanguage.g:2728:2: ()
            // InternalOptimisationLanguage.g:2728:3: 
            {
            }

             after(grammarAccess.getArrayRuleAccess().getArrayAction_0()); 

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
    // InternalOptimisationLanguage.g:2736:1: rule__ArrayRule__Group__1 : rule__ArrayRule__Group__1__Impl rule__ArrayRule__Group__2 ;
    public final void rule__ArrayRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2740:1: ( rule__ArrayRule__Group__1__Impl rule__ArrayRule__Group__2 )
            // InternalOptimisationLanguage.g:2741:2: rule__ArrayRule__Group__1__Impl rule__ArrayRule__Group__2
            {
            pushFollow(FOLLOW_18);
            rule__ArrayRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ArrayRule__Group__2();

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
    // $ANTLR end "rule__ArrayRule__Group__1"


    // $ANTLR start "rule__ArrayRule__Group__1__Impl"
    // InternalOptimisationLanguage.g:2748:1: rule__ArrayRule__Group__1__Impl : ( '[' ) ;
    public final void rule__ArrayRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2752:1: ( ( '[' ) )
            // InternalOptimisationLanguage.g:2753:1: ( '[' )
            {
            // InternalOptimisationLanguage.g:2753:1: ( '[' )
            // InternalOptimisationLanguage.g:2754:2: '['
            {
             before(grammarAccess.getArrayRuleAccess().getLeftSquareBracketKeyword_1()); 
            match(input,59,FOLLOW_2); 
             after(grammarAccess.getArrayRuleAccess().getLeftSquareBracketKeyword_1()); 

            }


            }

        }
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
    // InternalOptimisationLanguage.g:2763:1: rule__ArrayRule__Group__2 : rule__ArrayRule__Group__2__Impl rule__ArrayRule__Group__3 ;
    public final void rule__ArrayRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2767:1: ( rule__ArrayRule__Group__2__Impl rule__ArrayRule__Group__3 )
            // InternalOptimisationLanguage.g:2768:2: rule__ArrayRule__Group__2__Impl rule__ArrayRule__Group__3
            {
            pushFollow(FOLLOW_18);
            rule__ArrayRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ArrayRule__Group__3();

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
    // $ANTLR end "rule__ArrayRule__Group__2"


    // $ANTLR start "rule__ArrayRule__Group__2__Impl"
    // InternalOptimisationLanguage.g:2775:1: rule__ArrayRule__Group__2__Impl : ( ( rule__ArrayRule__Group_2__0 )? ) ;
    public final void rule__ArrayRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2779:1: ( ( ( rule__ArrayRule__Group_2__0 )? ) )
            // InternalOptimisationLanguage.g:2780:1: ( ( rule__ArrayRule__Group_2__0 )? )
            {
            // InternalOptimisationLanguage.g:2780:1: ( ( rule__ArrayRule__Group_2__0 )? )
            // InternalOptimisationLanguage.g:2781:2: ( rule__ArrayRule__Group_2__0 )?
            {
             before(grammarAccess.getArrayRuleAccess().getGroup_2()); 
            // InternalOptimisationLanguage.g:2782:2: ( rule__ArrayRule__Group_2__0 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( ((LA19_0>=RULE_QUOTED_ID && LA19_0<=RULE_STRING)||LA19_0==15||LA19_0==59||LA19_0==62||LA19_0==82) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalOptimisationLanguage.g:2782:3: rule__ArrayRule__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ArrayRule__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getArrayRuleAccess().getGroup_2()); 

            }


            }

        }
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
    // InternalOptimisationLanguage.g:2790:1: rule__ArrayRule__Group__3 : rule__ArrayRule__Group__3__Impl ;
    public final void rule__ArrayRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2794:1: ( rule__ArrayRule__Group__3__Impl )
            // InternalOptimisationLanguage.g:2795:2: rule__ArrayRule__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ArrayRule__Group__3__Impl();

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
    // $ANTLR end "rule__ArrayRule__Group__3"


    // $ANTLR start "rule__ArrayRule__Group__3__Impl"
    // InternalOptimisationLanguage.g:2801:1: rule__ArrayRule__Group__3__Impl : ( ']' ) ;
    public final void rule__ArrayRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2805:1: ( ( ']' ) )
            // InternalOptimisationLanguage.g:2806:1: ( ']' )
            {
            // InternalOptimisationLanguage.g:2806:1: ( ']' )
            // InternalOptimisationLanguage.g:2807:2: ']'
            {
             before(grammarAccess.getArrayRuleAccess().getRightSquareBracketKeyword_3()); 
            match(input,60,FOLLOW_2); 
             after(grammarAccess.getArrayRuleAccess().getRightSquareBracketKeyword_3()); 

            }


            }

        }
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
    // InternalOptimisationLanguage.g:2817:1: rule__ArrayRule__Group_2__0 : rule__ArrayRule__Group_2__0__Impl rule__ArrayRule__Group_2__1 ;
    public final void rule__ArrayRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2821:1: ( rule__ArrayRule__Group_2__0__Impl rule__ArrayRule__Group_2__1 )
            // InternalOptimisationLanguage.g:2822:2: rule__ArrayRule__Group_2__0__Impl rule__ArrayRule__Group_2__1
            {
            pushFollow(FOLLOW_19);
            rule__ArrayRule__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ArrayRule__Group_2__1();

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
    // $ANTLR end "rule__ArrayRule__Group_2__0"


    // $ANTLR start "rule__ArrayRule__Group_2__0__Impl"
    // InternalOptimisationLanguage.g:2829:1: rule__ArrayRule__Group_2__0__Impl : ( ( rule__ArrayRule__ValuesAssignment_2_0 ) ) ;
    public final void rule__ArrayRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2833:1: ( ( ( rule__ArrayRule__ValuesAssignment_2_0 ) ) )
            // InternalOptimisationLanguage.g:2834:1: ( ( rule__ArrayRule__ValuesAssignment_2_0 ) )
            {
            // InternalOptimisationLanguage.g:2834:1: ( ( rule__ArrayRule__ValuesAssignment_2_0 ) )
            // InternalOptimisationLanguage.g:2835:2: ( rule__ArrayRule__ValuesAssignment_2_0 )
            {
             before(grammarAccess.getArrayRuleAccess().getValuesAssignment_2_0()); 
            // InternalOptimisationLanguage.g:2836:2: ( rule__ArrayRule__ValuesAssignment_2_0 )
            // InternalOptimisationLanguage.g:2836:3: rule__ArrayRule__ValuesAssignment_2_0
            {
            pushFollow(FOLLOW_2);
            rule__ArrayRule__ValuesAssignment_2_0();

            state._fsp--;


            }

             after(grammarAccess.getArrayRuleAccess().getValuesAssignment_2_0()); 

            }


            }

        }
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
    // InternalOptimisationLanguage.g:2844:1: rule__ArrayRule__Group_2__1 : rule__ArrayRule__Group_2__1__Impl ;
    public final void rule__ArrayRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2848:1: ( rule__ArrayRule__Group_2__1__Impl )
            // InternalOptimisationLanguage.g:2849:2: rule__ArrayRule__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ArrayRule__Group_2__1__Impl();

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
    // $ANTLR end "rule__ArrayRule__Group_2__1"


    // $ANTLR start "rule__ArrayRule__Group_2__1__Impl"
    // InternalOptimisationLanguage.g:2855:1: rule__ArrayRule__Group_2__1__Impl : ( ( rule__ArrayRule__Group_2_1__0 )* ) ;
    public final void rule__ArrayRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2859:1: ( ( ( rule__ArrayRule__Group_2_1__0 )* ) )
            // InternalOptimisationLanguage.g:2860:1: ( ( rule__ArrayRule__Group_2_1__0 )* )
            {
            // InternalOptimisationLanguage.g:2860:1: ( ( rule__ArrayRule__Group_2_1__0 )* )
            // InternalOptimisationLanguage.g:2861:2: ( rule__ArrayRule__Group_2_1__0 )*
            {
             before(grammarAccess.getArrayRuleAccess().getGroup_2_1()); 
            // InternalOptimisationLanguage.g:2862:2: ( rule__ArrayRule__Group_2_1__0 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==61) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:2862:3: rule__ArrayRule__Group_2_1__0
            	    {
            	    pushFollow(FOLLOW_20);
            	    rule__ArrayRule__Group_2_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

             after(grammarAccess.getArrayRuleAccess().getGroup_2_1()); 

            }


            }

        }
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
    // InternalOptimisationLanguage.g:2871:1: rule__ArrayRule__Group_2_1__0 : rule__ArrayRule__Group_2_1__0__Impl rule__ArrayRule__Group_2_1__1 ;
    public final void rule__ArrayRule__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2875:1: ( rule__ArrayRule__Group_2_1__0__Impl rule__ArrayRule__Group_2_1__1 )
            // InternalOptimisationLanguage.g:2876:2: rule__ArrayRule__Group_2_1__0__Impl rule__ArrayRule__Group_2_1__1
            {
            pushFollow(FOLLOW_17);
            rule__ArrayRule__Group_2_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ArrayRule__Group_2_1__1();

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
    // $ANTLR end "rule__ArrayRule__Group_2_1__0"


    // $ANTLR start "rule__ArrayRule__Group_2_1__0__Impl"
    // InternalOptimisationLanguage.g:2883:1: rule__ArrayRule__Group_2_1__0__Impl : ( ',' ) ;
    public final void rule__ArrayRule__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2887:1: ( ( ',' ) )
            // InternalOptimisationLanguage.g:2888:1: ( ',' )
            {
            // InternalOptimisationLanguage.g:2888:1: ( ',' )
            // InternalOptimisationLanguage.g:2889:2: ','
            {
             before(grammarAccess.getArrayRuleAccess().getCommaKeyword_2_1_0()); 
            match(input,61,FOLLOW_2); 
             after(grammarAccess.getArrayRuleAccess().getCommaKeyword_2_1_0()); 

            }


            }

        }
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
    // InternalOptimisationLanguage.g:2898:1: rule__ArrayRule__Group_2_1__1 : rule__ArrayRule__Group_2_1__1__Impl ;
    public final void rule__ArrayRule__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2902:1: ( rule__ArrayRule__Group_2_1__1__Impl )
            // InternalOptimisationLanguage.g:2903:2: rule__ArrayRule__Group_2_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ArrayRule__Group_2_1__1__Impl();

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
    // $ANTLR end "rule__ArrayRule__Group_2_1__1"


    // $ANTLR start "rule__ArrayRule__Group_2_1__1__Impl"
    // InternalOptimisationLanguage.g:2909:1: rule__ArrayRule__Group_2_1__1__Impl : ( ( rule__ArrayRule__ValuesAssignment_2_1_1 ) ) ;
    public final void rule__ArrayRule__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2913:1: ( ( ( rule__ArrayRule__ValuesAssignment_2_1_1 ) ) )
            // InternalOptimisationLanguage.g:2914:1: ( ( rule__ArrayRule__ValuesAssignment_2_1_1 ) )
            {
            // InternalOptimisationLanguage.g:2914:1: ( ( rule__ArrayRule__ValuesAssignment_2_1_1 ) )
            // InternalOptimisationLanguage.g:2915:2: ( rule__ArrayRule__ValuesAssignment_2_1_1 )
            {
             before(grammarAccess.getArrayRuleAccess().getValuesAssignment_2_1_1()); 
            // InternalOptimisationLanguage.g:2916:2: ( rule__ArrayRule__ValuesAssignment_2_1_1 )
            // InternalOptimisationLanguage.g:2916:3: rule__ArrayRule__ValuesAssignment_2_1_1
            {
            pushFollow(FOLLOW_2);
            rule__ArrayRule__ValuesAssignment_2_1_1();

            state._fsp--;


            }

             after(grammarAccess.getArrayRuleAccess().getValuesAssignment_2_1_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__DataReferenceRule__Group__0"
    // InternalOptimisationLanguage.g:2925:1: rule__DataReferenceRule__Group__0 : rule__DataReferenceRule__Group__0__Impl rule__DataReferenceRule__Group__1 ;
    public final void rule__DataReferenceRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2929:1: ( rule__DataReferenceRule__Group__0__Impl rule__DataReferenceRule__Group__1 )
            // InternalOptimisationLanguage.g:2930:2: rule__DataReferenceRule__Group__0__Impl rule__DataReferenceRule__Group__1
            {
            pushFollow(FOLLOW_21);
            rule__DataReferenceRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataReferenceRule__Group__1();

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
    // $ANTLR end "rule__DataReferenceRule__Group__0"


    // $ANTLR start "rule__DataReferenceRule__Group__0__Impl"
    // InternalOptimisationLanguage.g:2937:1: rule__DataReferenceRule__Group__0__Impl : ( () ) ;
    public final void rule__DataReferenceRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2941:1: ( ( () ) )
            // InternalOptimisationLanguage.g:2942:1: ( () )
            {
            // InternalOptimisationLanguage.g:2942:1: ( () )
            // InternalOptimisationLanguage.g:2943:2: ()
            {
             before(grammarAccess.getDataReferenceRuleAccess().getDataReferenceAction_0()); 
            // InternalOptimisationLanguage.g:2944:2: ()
            // InternalOptimisationLanguage.g:2944:3: 
            {
            }

             after(grammarAccess.getDataReferenceRuleAccess().getDataReferenceAction_0()); 

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
    // InternalOptimisationLanguage.g:2952:1: rule__DataReferenceRule__Group__1 : rule__DataReferenceRule__Group__1__Impl rule__DataReferenceRule__Group__2 ;
    public final void rule__DataReferenceRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2956:1: ( rule__DataReferenceRule__Group__1__Impl rule__DataReferenceRule__Group__2 )
            // InternalOptimisationLanguage.g:2957:2: rule__DataReferenceRule__Group__1__Impl rule__DataReferenceRule__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__DataReferenceRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataReferenceRule__Group__2();

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
    // $ANTLR end "rule__DataReferenceRule__Group__1"


    // $ANTLR start "rule__DataReferenceRule__Group__1__Impl"
    // InternalOptimisationLanguage.g:2964:1: rule__DataReferenceRule__Group__1__Impl : ( 'data' ) ;
    public final void rule__DataReferenceRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2968:1: ( ( 'data' ) )
            // InternalOptimisationLanguage.g:2969:1: ( 'data' )
            {
            // InternalOptimisationLanguage.g:2969:1: ( 'data' )
            // InternalOptimisationLanguage.g:2970:2: 'data'
            {
             before(grammarAccess.getDataReferenceRuleAccess().getDataKeyword_1()); 
            match(input,62,FOLLOW_2); 
             after(grammarAccess.getDataReferenceRuleAccess().getDataKeyword_1()); 

            }


            }

        }
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
    // InternalOptimisationLanguage.g:2979:1: rule__DataReferenceRule__Group__2 : rule__DataReferenceRule__Group__2__Impl ;
    public final void rule__DataReferenceRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2983:1: ( rule__DataReferenceRule__Group__2__Impl )
            // InternalOptimisationLanguage.g:2984:2: rule__DataReferenceRule__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataReferenceRule__Group__2__Impl();

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
    // $ANTLR end "rule__DataReferenceRule__Group__2"


    // $ANTLR start "rule__DataReferenceRule__Group__2__Impl"
    // InternalOptimisationLanguage.g:2990:1: rule__DataReferenceRule__Group__2__Impl : ( ( rule__DataReferenceRule__DefinitionAssignment_2 ) ) ;
    public final void rule__DataReferenceRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:2994:1: ( ( ( rule__DataReferenceRule__DefinitionAssignment_2 ) ) )
            // InternalOptimisationLanguage.g:2995:1: ( ( rule__DataReferenceRule__DefinitionAssignment_2 ) )
            {
            // InternalOptimisationLanguage.g:2995:1: ( ( rule__DataReferenceRule__DefinitionAssignment_2 ) )
            // InternalOptimisationLanguage.g:2996:2: ( rule__DataReferenceRule__DefinitionAssignment_2 )
            {
             before(grammarAccess.getDataReferenceRuleAccess().getDefinitionAssignment_2()); 
            // InternalOptimisationLanguage.g:2997:2: ( rule__DataReferenceRule__DefinitionAssignment_2 )
            // InternalOptimisationLanguage.g:2997:3: rule__DataReferenceRule__DefinitionAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__DataReferenceRule__DefinitionAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getDataReferenceRuleAccess().getDefinitionAssignment_2()); 

            }


            }

        }
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


    // $ANTLR start "rule__QualifiedNameRule__Group__0"
    // InternalOptimisationLanguage.g:3006:1: rule__QualifiedNameRule__Group__0 : rule__QualifiedNameRule__Group__0__Impl rule__QualifiedNameRule__Group__1 ;
    public final void rule__QualifiedNameRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3010:1: ( rule__QualifiedNameRule__Group__0__Impl rule__QualifiedNameRule__Group__1 )
            // InternalOptimisationLanguage.g:3011:2: rule__QualifiedNameRule__Group__0__Impl rule__QualifiedNameRule__Group__1
            {
            pushFollow(FOLLOW_22);
            rule__QualifiedNameRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QualifiedNameRule__Group__1();

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
    // $ANTLR end "rule__QualifiedNameRule__Group__0"


    // $ANTLR start "rule__QualifiedNameRule__Group__0__Impl"
    // InternalOptimisationLanguage.g:3018:1: rule__QualifiedNameRule__Group__0__Impl : ( ruleStringOrId ) ;
    public final void rule__QualifiedNameRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3022:1: ( ( ruleStringOrId ) )
            // InternalOptimisationLanguage.g:3023:1: ( ruleStringOrId )
            {
            // InternalOptimisationLanguage.g:3023:1: ( ruleStringOrId )
            // InternalOptimisationLanguage.g:3024:2: ruleStringOrId
            {
             before(grammarAccess.getQualifiedNameRuleAccess().getStringOrIdParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleStringOrId();

            state._fsp--;

             after(grammarAccess.getQualifiedNameRuleAccess().getStringOrIdParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedNameRule__Group__0__Impl"


    // $ANTLR start "rule__QualifiedNameRule__Group__1"
    // InternalOptimisationLanguage.g:3033:1: rule__QualifiedNameRule__Group__1 : rule__QualifiedNameRule__Group__1__Impl ;
    public final void rule__QualifiedNameRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3037:1: ( rule__QualifiedNameRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:3038:2: rule__QualifiedNameRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedNameRule__Group__1__Impl();

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
    // $ANTLR end "rule__QualifiedNameRule__Group__1"


    // $ANTLR start "rule__QualifiedNameRule__Group__1__Impl"
    // InternalOptimisationLanguage.g:3044:1: rule__QualifiedNameRule__Group__1__Impl : ( ( rule__QualifiedNameRule__Group_1__0 )* ) ;
    public final void rule__QualifiedNameRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3048:1: ( ( ( rule__QualifiedNameRule__Group_1__0 )* ) )
            // InternalOptimisationLanguage.g:3049:1: ( ( rule__QualifiedNameRule__Group_1__0 )* )
            {
            // InternalOptimisationLanguage.g:3049:1: ( ( rule__QualifiedNameRule__Group_1__0 )* )
            // InternalOptimisationLanguage.g:3050:2: ( rule__QualifiedNameRule__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedNameRuleAccess().getGroup_1()); 
            // InternalOptimisationLanguage.g:3051:2: ( rule__QualifiedNameRule__Group_1__0 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==63) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:3051:3: rule__QualifiedNameRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_23);
            	    rule__QualifiedNameRule__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

             after(grammarAccess.getQualifiedNameRuleAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedNameRule__Group__1__Impl"


    // $ANTLR start "rule__QualifiedNameRule__Group_1__0"
    // InternalOptimisationLanguage.g:3060:1: rule__QualifiedNameRule__Group_1__0 : rule__QualifiedNameRule__Group_1__0__Impl rule__QualifiedNameRule__Group_1__1 ;
    public final void rule__QualifiedNameRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3064:1: ( rule__QualifiedNameRule__Group_1__0__Impl rule__QualifiedNameRule__Group_1__1 )
            // InternalOptimisationLanguage.g:3065:2: rule__QualifiedNameRule__Group_1__0__Impl rule__QualifiedNameRule__Group_1__1
            {
            pushFollow(FOLLOW_5);
            rule__QualifiedNameRule__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QualifiedNameRule__Group_1__1();

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
    // $ANTLR end "rule__QualifiedNameRule__Group_1__0"


    // $ANTLR start "rule__QualifiedNameRule__Group_1__0__Impl"
    // InternalOptimisationLanguage.g:3072:1: rule__QualifiedNameRule__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedNameRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3076:1: ( ( '.' ) )
            // InternalOptimisationLanguage.g:3077:1: ( '.' )
            {
            // InternalOptimisationLanguage.g:3077:1: ( '.' )
            // InternalOptimisationLanguage.g:3078:2: '.'
            {
             before(grammarAccess.getQualifiedNameRuleAccess().getFullStopKeyword_1_0()); 
            match(input,63,FOLLOW_2); 
             after(grammarAccess.getQualifiedNameRuleAccess().getFullStopKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedNameRule__Group_1__0__Impl"


    // $ANTLR start "rule__QualifiedNameRule__Group_1__1"
    // InternalOptimisationLanguage.g:3087:1: rule__QualifiedNameRule__Group_1__1 : rule__QualifiedNameRule__Group_1__1__Impl ;
    public final void rule__QualifiedNameRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3091:1: ( rule__QualifiedNameRule__Group_1__1__Impl )
            // InternalOptimisationLanguage.g:3092:2: rule__QualifiedNameRule__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedNameRule__Group_1__1__Impl();

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
    // $ANTLR end "rule__QualifiedNameRule__Group_1__1"


    // $ANTLR start "rule__QualifiedNameRule__Group_1__1__Impl"
    // InternalOptimisationLanguage.g:3098:1: rule__QualifiedNameRule__Group_1__1__Impl : ( ruleStringOrId ) ;
    public final void rule__QualifiedNameRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3102:1: ( ( ruleStringOrId ) )
            // InternalOptimisationLanguage.g:3103:1: ( ruleStringOrId )
            {
            // InternalOptimisationLanguage.g:3103:1: ( ruleStringOrId )
            // InternalOptimisationLanguage.g:3104:2: ruleStringOrId
            {
             before(grammarAccess.getQualifiedNameRuleAccess().getStringOrIdParserRuleCall_1_1()); 
            pushFollow(FOLLOW_2);
            ruleStringOrId();

            state._fsp--;

             after(grammarAccess.getQualifiedNameRuleAccess().getStringOrIdParserRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedNameRule__Group_1__1__Impl"


    // $ANTLR start "rule__OrExpressionRule__Group__0"
    // InternalOptimisationLanguage.g:3114:1: rule__OrExpressionRule__Group__0 : rule__OrExpressionRule__Group__0__Impl rule__OrExpressionRule__Group__1 ;
    public final void rule__OrExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3118:1: ( rule__OrExpressionRule__Group__0__Impl rule__OrExpressionRule__Group__1 )
            // InternalOptimisationLanguage.g:3119:2: rule__OrExpressionRule__Group__0__Impl rule__OrExpressionRule__Group__1
            {
            pushFollow(FOLLOW_24);
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
    // InternalOptimisationLanguage.g:3126:1: rule__OrExpressionRule__Group__0__Impl : ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) ) ;
    public final void rule__OrExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3130:1: ( ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) ) )
            // InternalOptimisationLanguage.g:3131:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) )
            {
            // InternalOptimisationLanguage.g:3131:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) )
            // InternalOptimisationLanguage.g:3132:2: ( rule__OrExpressionRule__SubExpressionsAssignment_0 )
            {
             before(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsAssignment_0()); 
            // InternalOptimisationLanguage.g:3133:2: ( rule__OrExpressionRule__SubExpressionsAssignment_0 )
            // InternalOptimisationLanguage.g:3133:3: rule__OrExpressionRule__SubExpressionsAssignment_0
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
    // InternalOptimisationLanguage.g:3141:1: rule__OrExpressionRule__Group__1 : rule__OrExpressionRule__Group__1__Impl ;
    public final void rule__OrExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3145:1: ( rule__OrExpressionRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:3146:2: rule__OrExpressionRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:3152:1: rule__OrExpressionRule__Group__1__Impl : ( ( rule__OrExpressionRule__Group_1__0 )* ) ;
    public final void rule__OrExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3156:1: ( ( ( rule__OrExpressionRule__Group_1__0 )* ) )
            // InternalOptimisationLanguage.g:3157:1: ( ( rule__OrExpressionRule__Group_1__0 )* )
            {
            // InternalOptimisationLanguage.g:3157:1: ( ( rule__OrExpressionRule__Group_1__0 )* )
            // InternalOptimisationLanguage.g:3158:2: ( rule__OrExpressionRule__Group_1__0 )*
            {
             before(grammarAccess.getOrExpressionRuleAccess().getGroup_1()); 
            // InternalOptimisationLanguage.g:3159:2: ( rule__OrExpressionRule__Group_1__0 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==64) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:3159:3: rule__OrExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_25);
            	    rule__OrExpressionRule__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop22;
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
    // InternalOptimisationLanguage.g:3168:1: rule__OrExpressionRule__Group_1__0 : rule__OrExpressionRule__Group_1__0__Impl rule__OrExpressionRule__Group_1__1 ;
    public final void rule__OrExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3172:1: ( rule__OrExpressionRule__Group_1__0__Impl rule__OrExpressionRule__Group_1__1 )
            // InternalOptimisationLanguage.g:3173:2: rule__OrExpressionRule__Group_1__0__Impl rule__OrExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_26);
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
    // InternalOptimisationLanguage.g:3180:1: rule__OrExpressionRule__Group_1__0__Impl : ( 'OR' ) ;
    public final void rule__OrExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3184:1: ( ( 'OR' ) )
            // InternalOptimisationLanguage.g:3185:1: ( 'OR' )
            {
            // InternalOptimisationLanguage.g:3185:1: ( 'OR' )
            // InternalOptimisationLanguage.g:3186:2: 'OR'
            {
             before(grammarAccess.getOrExpressionRuleAccess().getORKeyword_1_0()); 
            match(input,64,FOLLOW_2); 
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
    // InternalOptimisationLanguage.g:3195:1: rule__OrExpressionRule__Group_1__1 : rule__OrExpressionRule__Group_1__1__Impl ;
    public final void rule__OrExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3199:1: ( rule__OrExpressionRule__Group_1__1__Impl )
            // InternalOptimisationLanguage.g:3200:2: rule__OrExpressionRule__Group_1__1__Impl
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
    // InternalOptimisationLanguage.g:3206:1: rule__OrExpressionRule__Group_1__1__Impl : ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) ) ;
    public final void rule__OrExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3210:1: ( ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) ) )
            // InternalOptimisationLanguage.g:3211:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) )
            {
            // InternalOptimisationLanguage.g:3211:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) )
            // InternalOptimisationLanguage.g:3212:2: ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 )
            {
             before(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsAssignment_1_1()); 
            // InternalOptimisationLanguage.g:3213:2: ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 )
            // InternalOptimisationLanguage.g:3213:3: rule__OrExpressionRule__SubExpressionsAssignment_1_1
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
    // InternalOptimisationLanguage.g:3222:1: rule__XorExpressionRule__Group__0 : rule__XorExpressionRule__Group__0__Impl rule__XorExpressionRule__Group__1 ;
    public final void rule__XorExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3226:1: ( rule__XorExpressionRule__Group__0__Impl rule__XorExpressionRule__Group__1 )
            // InternalOptimisationLanguage.g:3227:2: rule__XorExpressionRule__Group__0__Impl rule__XorExpressionRule__Group__1
            {
            pushFollow(FOLLOW_27);
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
    // InternalOptimisationLanguage.g:3234:1: rule__XorExpressionRule__Group__0__Impl : ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) ) ;
    public final void rule__XorExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3238:1: ( ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) ) )
            // InternalOptimisationLanguage.g:3239:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) )
            {
            // InternalOptimisationLanguage.g:3239:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) )
            // InternalOptimisationLanguage.g:3240:2: ( rule__XorExpressionRule__SubExpressionsAssignment_0 )
            {
             before(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAssignment_0()); 
            // InternalOptimisationLanguage.g:3241:2: ( rule__XorExpressionRule__SubExpressionsAssignment_0 )
            // InternalOptimisationLanguage.g:3241:3: rule__XorExpressionRule__SubExpressionsAssignment_0
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
    // InternalOptimisationLanguage.g:3249:1: rule__XorExpressionRule__Group__1 : rule__XorExpressionRule__Group__1__Impl ;
    public final void rule__XorExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3253:1: ( rule__XorExpressionRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:3254:2: rule__XorExpressionRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:3260:1: rule__XorExpressionRule__Group__1__Impl : ( ( rule__XorExpressionRule__Group_1__0 )* ) ;
    public final void rule__XorExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3264:1: ( ( ( rule__XorExpressionRule__Group_1__0 )* ) )
            // InternalOptimisationLanguage.g:3265:1: ( ( rule__XorExpressionRule__Group_1__0 )* )
            {
            // InternalOptimisationLanguage.g:3265:1: ( ( rule__XorExpressionRule__Group_1__0 )* )
            // InternalOptimisationLanguage.g:3266:2: ( rule__XorExpressionRule__Group_1__0 )*
            {
             before(grammarAccess.getXorExpressionRuleAccess().getGroup_1()); 
            // InternalOptimisationLanguage.g:3267:2: ( rule__XorExpressionRule__Group_1__0 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==65) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:3267:3: rule__XorExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_28);
            	    rule__XorExpressionRule__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop23;
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
    // InternalOptimisationLanguage.g:3276:1: rule__XorExpressionRule__Group_1__0 : rule__XorExpressionRule__Group_1__0__Impl rule__XorExpressionRule__Group_1__1 ;
    public final void rule__XorExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3280:1: ( rule__XorExpressionRule__Group_1__0__Impl rule__XorExpressionRule__Group_1__1 )
            // InternalOptimisationLanguage.g:3281:2: rule__XorExpressionRule__Group_1__0__Impl rule__XorExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_26);
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
    // InternalOptimisationLanguage.g:3288:1: rule__XorExpressionRule__Group_1__0__Impl : ( 'XOR' ) ;
    public final void rule__XorExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3292:1: ( ( 'XOR' ) )
            // InternalOptimisationLanguage.g:3293:1: ( 'XOR' )
            {
            // InternalOptimisationLanguage.g:3293:1: ( 'XOR' )
            // InternalOptimisationLanguage.g:3294:2: 'XOR'
            {
             before(grammarAccess.getXorExpressionRuleAccess().getXORKeyword_1_0()); 
            match(input,65,FOLLOW_2); 
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
    // InternalOptimisationLanguage.g:3303:1: rule__XorExpressionRule__Group_1__1 : rule__XorExpressionRule__Group_1__1__Impl ;
    public final void rule__XorExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3307:1: ( rule__XorExpressionRule__Group_1__1__Impl )
            // InternalOptimisationLanguage.g:3308:2: rule__XorExpressionRule__Group_1__1__Impl
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
    // InternalOptimisationLanguage.g:3314:1: rule__XorExpressionRule__Group_1__1__Impl : ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) ) ;
    public final void rule__XorExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3318:1: ( ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) ) )
            // InternalOptimisationLanguage.g:3319:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) )
            {
            // InternalOptimisationLanguage.g:3319:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) )
            // InternalOptimisationLanguage.g:3320:2: ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 )
            {
             before(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAssignment_1_1()); 
            // InternalOptimisationLanguage.g:3321:2: ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 )
            // InternalOptimisationLanguage.g:3321:3: rule__XorExpressionRule__SubExpressionsAssignment_1_1
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
    // InternalOptimisationLanguage.g:3330:1: rule__AndExpressionRule__Group__0 : rule__AndExpressionRule__Group__0__Impl rule__AndExpressionRule__Group__1 ;
    public final void rule__AndExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3334:1: ( rule__AndExpressionRule__Group__0__Impl rule__AndExpressionRule__Group__1 )
            // InternalOptimisationLanguage.g:3335:2: rule__AndExpressionRule__Group__0__Impl rule__AndExpressionRule__Group__1
            {
            pushFollow(FOLLOW_29);
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
    // InternalOptimisationLanguage.g:3342:1: rule__AndExpressionRule__Group__0__Impl : ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) ) ;
    public final void rule__AndExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3346:1: ( ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) ) )
            // InternalOptimisationLanguage.g:3347:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) )
            {
            // InternalOptimisationLanguage.g:3347:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) )
            // InternalOptimisationLanguage.g:3348:2: ( rule__AndExpressionRule__SubExpressionsAssignment_0 )
            {
             before(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsAssignment_0()); 
            // InternalOptimisationLanguage.g:3349:2: ( rule__AndExpressionRule__SubExpressionsAssignment_0 )
            // InternalOptimisationLanguage.g:3349:3: rule__AndExpressionRule__SubExpressionsAssignment_0
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
    // InternalOptimisationLanguage.g:3357:1: rule__AndExpressionRule__Group__1 : rule__AndExpressionRule__Group__1__Impl ;
    public final void rule__AndExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3361:1: ( rule__AndExpressionRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:3362:2: rule__AndExpressionRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:3368:1: rule__AndExpressionRule__Group__1__Impl : ( ( rule__AndExpressionRule__Group_1__0 )* ) ;
    public final void rule__AndExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3372:1: ( ( ( rule__AndExpressionRule__Group_1__0 )* ) )
            // InternalOptimisationLanguage.g:3373:1: ( ( rule__AndExpressionRule__Group_1__0 )* )
            {
            // InternalOptimisationLanguage.g:3373:1: ( ( rule__AndExpressionRule__Group_1__0 )* )
            // InternalOptimisationLanguage.g:3374:2: ( rule__AndExpressionRule__Group_1__0 )*
            {
             before(grammarAccess.getAndExpressionRuleAccess().getGroup_1()); 
            // InternalOptimisationLanguage.g:3375:2: ( rule__AndExpressionRule__Group_1__0 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==66) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:3375:3: rule__AndExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_30);
            	    rule__AndExpressionRule__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop24;
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
    // InternalOptimisationLanguage.g:3384:1: rule__AndExpressionRule__Group_1__0 : rule__AndExpressionRule__Group_1__0__Impl rule__AndExpressionRule__Group_1__1 ;
    public final void rule__AndExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3388:1: ( rule__AndExpressionRule__Group_1__0__Impl rule__AndExpressionRule__Group_1__1 )
            // InternalOptimisationLanguage.g:3389:2: rule__AndExpressionRule__Group_1__0__Impl rule__AndExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_26);
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
    // InternalOptimisationLanguage.g:3396:1: rule__AndExpressionRule__Group_1__0__Impl : ( 'AND' ) ;
    public final void rule__AndExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3400:1: ( ( 'AND' ) )
            // InternalOptimisationLanguage.g:3401:1: ( 'AND' )
            {
            // InternalOptimisationLanguage.g:3401:1: ( 'AND' )
            // InternalOptimisationLanguage.g:3402:2: 'AND'
            {
             before(grammarAccess.getAndExpressionRuleAccess().getANDKeyword_1_0()); 
            match(input,66,FOLLOW_2); 
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
    // InternalOptimisationLanguage.g:3411:1: rule__AndExpressionRule__Group_1__1 : rule__AndExpressionRule__Group_1__1__Impl ;
    public final void rule__AndExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3415:1: ( rule__AndExpressionRule__Group_1__1__Impl )
            // InternalOptimisationLanguage.g:3416:2: rule__AndExpressionRule__Group_1__1__Impl
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
    // InternalOptimisationLanguage.g:3422:1: rule__AndExpressionRule__Group_1__1__Impl : ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) ) ;
    public final void rule__AndExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3426:1: ( ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) ) )
            // InternalOptimisationLanguage.g:3427:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) )
            {
            // InternalOptimisationLanguage.g:3427:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) )
            // InternalOptimisationLanguage.g:3428:2: ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 )
            {
             before(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsAssignment_1_1()); 
            // InternalOptimisationLanguage.g:3429:2: ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 )
            // InternalOptimisationLanguage.g:3429:3: rule__AndExpressionRule__SubExpressionsAssignment_1_1
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
    // InternalOptimisationLanguage.g:3438:1: rule__NotExpressionRule__Group__0 : rule__NotExpressionRule__Group__0__Impl rule__NotExpressionRule__Group__1 ;
    public final void rule__NotExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3442:1: ( rule__NotExpressionRule__Group__0__Impl rule__NotExpressionRule__Group__1 )
            // InternalOptimisationLanguage.g:3443:2: rule__NotExpressionRule__Group__0__Impl rule__NotExpressionRule__Group__1
            {
            pushFollow(FOLLOW_26);
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
    // InternalOptimisationLanguage.g:3450:1: rule__NotExpressionRule__Group__0__Impl : ( ( rule__NotExpressionRule__NegatedAssignment_0 )? ) ;
    public final void rule__NotExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3454:1: ( ( ( rule__NotExpressionRule__NegatedAssignment_0 )? ) )
            // InternalOptimisationLanguage.g:3455:1: ( ( rule__NotExpressionRule__NegatedAssignment_0 )? )
            {
            // InternalOptimisationLanguage.g:3455:1: ( ( rule__NotExpressionRule__NegatedAssignment_0 )? )
            // InternalOptimisationLanguage.g:3456:2: ( rule__NotExpressionRule__NegatedAssignment_0 )?
            {
             before(grammarAccess.getNotExpressionRuleAccess().getNegatedAssignment_0()); 
            // InternalOptimisationLanguage.g:3457:2: ( rule__NotExpressionRule__NegatedAssignment_0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==81) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalOptimisationLanguage.g:3457:3: rule__NotExpressionRule__NegatedAssignment_0
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
    // InternalOptimisationLanguage.g:3465:1: rule__NotExpressionRule__Group__1 : rule__NotExpressionRule__Group__1__Impl ;
    public final void rule__NotExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3469:1: ( rule__NotExpressionRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:3470:2: rule__NotExpressionRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:3476:1: rule__NotExpressionRule__Group__1__Impl : ( ( rule__NotExpressionRule__OperandAssignment_1 ) ) ;
    public final void rule__NotExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3480:1: ( ( ( rule__NotExpressionRule__OperandAssignment_1 ) ) )
            // InternalOptimisationLanguage.g:3481:1: ( ( rule__NotExpressionRule__OperandAssignment_1 ) )
            {
            // InternalOptimisationLanguage.g:3481:1: ( ( rule__NotExpressionRule__OperandAssignment_1 ) )
            // InternalOptimisationLanguage.g:3482:2: ( rule__NotExpressionRule__OperandAssignment_1 )
            {
             before(grammarAccess.getNotExpressionRuleAccess().getOperandAssignment_1()); 
            // InternalOptimisationLanguage.g:3483:2: ( rule__NotExpressionRule__OperandAssignment_1 )
            // InternalOptimisationLanguage.g:3483:3: rule__NotExpressionRule__OperandAssignment_1
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
    // InternalOptimisationLanguage.g:3492:1: rule__ComparisonExpressionRule__Group__0 : rule__ComparisonExpressionRule__Group__0__Impl rule__ComparisonExpressionRule__Group__1 ;
    public final void rule__ComparisonExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3496:1: ( rule__ComparisonExpressionRule__Group__0__Impl rule__ComparisonExpressionRule__Group__1 )
            // InternalOptimisationLanguage.g:3497:2: rule__ComparisonExpressionRule__Group__0__Impl rule__ComparisonExpressionRule__Group__1
            {
            pushFollow(FOLLOW_31);
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
    // InternalOptimisationLanguage.g:3504:1: rule__ComparisonExpressionRule__Group__0__Impl : ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__ComparisonExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3508:1: ( ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalOptimisationLanguage.g:3509:1: ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalOptimisationLanguage.g:3509:1: ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) )
            // InternalOptimisationLanguage.g:3510:2: ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 )
            {
             before(grammarAccess.getComparisonExpressionRuleAccess().getLeftOperandAssignment_0()); 
            // InternalOptimisationLanguage.g:3511:2: ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 )
            // InternalOptimisationLanguage.g:3511:3: rule__ComparisonExpressionRule__LeftOperandAssignment_0
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
    // InternalOptimisationLanguage.g:3519:1: rule__ComparisonExpressionRule__Group__1 : rule__ComparisonExpressionRule__Group__1__Impl ;
    public final void rule__ComparisonExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3523:1: ( rule__ComparisonExpressionRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:3524:2: rule__ComparisonExpressionRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:3530:1: rule__ComparisonExpressionRule__Group__1__Impl : ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* ) ;
    public final void rule__ComparisonExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3534:1: ( ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* ) )
            // InternalOptimisationLanguage.g:3535:1: ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* )
            {
            // InternalOptimisationLanguage.g:3535:1: ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* )
            // InternalOptimisationLanguage.g:3536:2: ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )*
            {
             before(grammarAccess.getComparisonExpressionRuleAccess().getComparisonAssignment_1()); 
            // InternalOptimisationLanguage.g:3537:2: ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( ((LA26_0>=16 && LA26_0<=21)) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:3537:3: rule__ComparisonExpressionRule__ComparisonAssignment_1
            	    {
            	    pushFollow(FOLLOW_32);
            	    rule__ComparisonExpressionRule__ComparisonAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop26;
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
    // InternalOptimisationLanguage.g:3546:1: rule__PartialComparisonExpressionRule__Group__0 : rule__PartialComparisonExpressionRule__Group__0__Impl rule__PartialComparisonExpressionRule__Group__1 ;
    public final void rule__PartialComparisonExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3550:1: ( rule__PartialComparisonExpressionRule__Group__0__Impl rule__PartialComparisonExpressionRule__Group__1 )
            // InternalOptimisationLanguage.g:3551:2: rule__PartialComparisonExpressionRule__Group__0__Impl rule__PartialComparisonExpressionRule__Group__1
            {
            pushFollow(FOLLOW_26);
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
    // InternalOptimisationLanguage.g:3558:1: rule__PartialComparisonExpressionRule__Group__0__Impl : ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) ) ;
    public final void rule__PartialComparisonExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3562:1: ( ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) ) )
            // InternalOptimisationLanguage.g:3563:1: ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) )
            {
            // InternalOptimisationLanguage.g:3563:1: ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) )
            // InternalOptimisationLanguage.g:3564:2: ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 )
            {
             before(grammarAccess.getPartialComparisonExpressionRuleAccess().getOperatorAssignment_0()); 
            // InternalOptimisationLanguage.g:3565:2: ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 )
            // InternalOptimisationLanguage.g:3565:3: rule__PartialComparisonExpressionRule__OperatorAssignment_0
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
    // InternalOptimisationLanguage.g:3573:1: rule__PartialComparisonExpressionRule__Group__1 : rule__PartialComparisonExpressionRule__Group__1__Impl ;
    public final void rule__PartialComparisonExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3577:1: ( rule__PartialComparisonExpressionRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:3578:2: rule__PartialComparisonExpressionRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:3584:1: rule__PartialComparisonExpressionRule__Group__1__Impl : ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) ) ;
    public final void rule__PartialComparisonExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3588:1: ( ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) ) )
            // InternalOptimisationLanguage.g:3589:1: ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) )
            {
            // InternalOptimisationLanguage.g:3589:1: ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) )
            // InternalOptimisationLanguage.g:3590:2: ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 )
            {
             before(grammarAccess.getPartialComparisonExpressionRuleAccess().getSubExpressionAssignment_1()); 
            // InternalOptimisationLanguage.g:3591:2: ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 )
            // InternalOptimisationLanguage.g:3591:3: rule__PartialComparisonExpressionRule__SubExpressionAssignment_1
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
    // InternalOptimisationLanguage.g:3600:1: rule__AddOrSubtractExpressionRule__Group__0 : rule__AddOrSubtractExpressionRule__Group__0__Impl rule__AddOrSubtractExpressionRule__Group__1 ;
    public final void rule__AddOrSubtractExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3604:1: ( rule__AddOrSubtractExpressionRule__Group__0__Impl rule__AddOrSubtractExpressionRule__Group__1 )
            // InternalOptimisationLanguage.g:3605:2: rule__AddOrSubtractExpressionRule__Group__0__Impl rule__AddOrSubtractExpressionRule__Group__1
            {
            pushFollow(FOLLOW_33);
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
    // InternalOptimisationLanguage.g:3612:1: rule__AddOrSubtractExpressionRule__Group__0__Impl : ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__AddOrSubtractExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3616:1: ( ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalOptimisationLanguage.g:3617:1: ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalOptimisationLanguage.g:3617:1: ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) )
            // InternalOptimisationLanguage.g:3618:2: ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 )
            {
             before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getLeftOperandAssignment_0()); 
            // InternalOptimisationLanguage.g:3619:2: ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 )
            // InternalOptimisationLanguage.g:3619:3: rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0
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
    // InternalOptimisationLanguage.g:3627:1: rule__AddOrSubtractExpressionRule__Group__1 : rule__AddOrSubtractExpressionRule__Group__1__Impl ;
    public final void rule__AddOrSubtractExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3631:1: ( rule__AddOrSubtractExpressionRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:3632:2: rule__AddOrSubtractExpressionRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:3638:1: rule__AddOrSubtractExpressionRule__Group__1__Impl : ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* ) ;
    public final void rule__AddOrSubtractExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3642:1: ( ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* ) )
            // InternalOptimisationLanguage.g:3643:1: ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* )
            {
            // InternalOptimisationLanguage.g:3643:1: ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* )
            // InternalOptimisationLanguage.g:3644:2: ( rule__AddOrSubtractExpressionRule__Group_1__0 )*
            {
             before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getGroup_1()); 
            // InternalOptimisationLanguage.g:3645:2: ( rule__AddOrSubtractExpressionRule__Group_1__0 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( ((LA27_0>=22 && LA27_0<=23)) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:3645:3: rule__AddOrSubtractExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_34);
            	    rule__AddOrSubtractExpressionRule__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop27;
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
    // InternalOptimisationLanguage.g:3654:1: rule__AddOrSubtractExpressionRule__Group_1__0 : rule__AddOrSubtractExpressionRule__Group_1__0__Impl rule__AddOrSubtractExpressionRule__Group_1__1 ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3658:1: ( rule__AddOrSubtractExpressionRule__Group_1__0__Impl rule__AddOrSubtractExpressionRule__Group_1__1 )
            // InternalOptimisationLanguage.g:3659:2: rule__AddOrSubtractExpressionRule__Group_1__0__Impl rule__AddOrSubtractExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_26);
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
    // InternalOptimisationLanguage.g:3666:1: rule__AddOrSubtractExpressionRule__Group_1__0__Impl : ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) ) ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3670:1: ( ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) ) )
            // InternalOptimisationLanguage.g:3671:1: ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) )
            {
            // InternalOptimisationLanguage.g:3671:1: ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) )
            // InternalOptimisationLanguage.g:3672:2: ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 )
            {
             before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperatorsAssignment_1_0()); 
            // InternalOptimisationLanguage.g:3673:2: ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 )
            // InternalOptimisationLanguage.g:3673:3: rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0
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
    // InternalOptimisationLanguage.g:3681:1: rule__AddOrSubtractExpressionRule__Group_1__1 : rule__AddOrSubtractExpressionRule__Group_1__1__Impl ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3685:1: ( rule__AddOrSubtractExpressionRule__Group_1__1__Impl )
            // InternalOptimisationLanguage.g:3686:2: rule__AddOrSubtractExpressionRule__Group_1__1__Impl
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
    // InternalOptimisationLanguage.g:3692:1: rule__AddOrSubtractExpressionRule__Group_1__1__Impl : ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) ) ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3696:1: ( ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) ) )
            // InternalOptimisationLanguage.g:3697:1: ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) )
            {
            // InternalOptimisationLanguage.g:3697:1: ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) )
            // InternalOptimisationLanguage.g:3698:2: ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 )
            {
             before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperandsAssignment_1_1()); 
            // InternalOptimisationLanguage.g:3699:2: ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 )
            // InternalOptimisationLanguage.g:3699:3: rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1
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
    // InternalOptimisationLanguage.g:3708:1: rule__MultiplyDivideModuloExpressionRule__Group__0 : rule__MultiplyDivideModuloExpressionRule__Group__0__Impl rule__MultiplyDivideModuloExpressionRule__Group__1 ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3712:1: ( rule__MultiplyDivideModuloExpressionRule__Group__0__Impl rule__MultiplyDivideModuloExpressionRule__Group__1 )
            // InternalOptimisationLanguage.g:3713:2: rule__MultiplyDivideModuloExpressionRule__Group__0__Impl rule__MultiplyDivideModuloExpressionRule__Group__1
            {
            pushFollow(FOLLOW_35);
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
    // InternalOptimisationLanguage.g:3720:1: rule__MultiplyDivideModuloExpressionRule__Group__0__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3724:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalOptimisationLanguage.g:3725:1: ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalOptimisationLanguage.g:3725:1: ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) )
            // InternalOptimisationLanguage.g:3726:2: ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 )
            {
             before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getLeftOperandAssignment_0()); 
            // InternalOptimisationLanguage.g:3727:2: ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 )
            // InternalOptimisationLanguage.g:3727:3: rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0
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
    // InternalOptimisationLanguage.g:3735:1: rule__MultiplyDivideModuloExpressionRule__Group__1 : rule__MultiplyDivideModuloExpressionRule__Group__1__Impl ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3739:1: ( rule__MultiplyDivideModuloExpressionRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:3740:2: rule__MultiplyDivideModuloExpressionRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:3746:1: rule__MultiplyDivideModuloExpressionRule__Group__1__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3750:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* ) )
            // InternalOptimisationLanguage.g:3751:1: ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* )
            {
            // InternalOptimisationLanguage.g:3751:1: ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* )
            // InternalOptimisationLanguage.g:3752:2: ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )*
            {
             before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getGroup_1()); 
            // InternalOptimisationLanguage.g:3753:2: ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( ((LA28_0>=24 && LA28_0<=26)) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:3753:3: rule__MultiplyDivideModuloExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_36);
            	    rule__MultiplyDivideModuloExpressionRule__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop28;
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
    // InternalOptimisationLanguage.g:3762:1: rule__MultiplyDivideModuloExpressionRule__Group_1__0 : rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl rule__MultiplyDivideModuloExpressionRule__Group_1__1 ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3766:1: ( rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl rule__MultiplyDivideModuloExpressionRule__Group_1__1 )
            // InternalOptimisationLanguage.g:3767:2: rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl rule__MultiplyDivideModuloExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_26);
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
    // InternalOptimisationLanguage.g:3774:1: rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3778:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) ) )
            // InternalOptimisationLanguage.g:3779:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) )
            {
            // InternalOptimisationLanguage.g:3779:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) )
            // InternalOptimisationLanguage.g:3780:2: ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 )
            {
             before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperatorsAssignment_1_0()); 
            // InternalOptimisationLanguage.g:3781:2: ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 )
            // InternalOptimisationLanguage.g:3781:3: rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0
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
    // InternalOptimisationLanguage.g:3789:1: rule__MultiplyDivideModuloExpressionRule__Group_1__1 : rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3793:1: ( rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl )
            // InternalOptimisationLanguage.g:3794:2: rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl
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
    // InternalOptimisationLanguage.g:3800:1: rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3804:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) ) )
            // InternalOptimisationLanguage.g:3805:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) )
            {
            // InternalOptimisationLanguage.g:3805:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) )
            // InternalOptimisationLanguage.g:3806:2: ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 )
            {
             before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperandsAssignment_1_1()); 
            // InternalOptimisationLanguage.g:3807:2: ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 )
            // InternalOptimisationLanguage.g:3807:3: rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1
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
    // InternalOptimisationLanguage.g:3816:1: rule__PowerOfExpressionRule__Group__0 : rule__PowerOfExpressionRule__Group__0__Impl rule__PowerOfExpressionRule__Group__1 ;
    public final void rule__PowerOfExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3820:1: ( rule__PowerOfExpressionRule__Group__0__Impl rule__PowerOfExpressionRule__Group__1 )
            // InternalOptimisationLanguage.g:3821:2: rule__PowerOfExpressionRule__Group__0__Impl rule__PowerOfExpressionRule__Group__1
            {
            pushFollow(FOLLOW_37);
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
    // InternalOptimisationLanguage.g:3828:1: rule__PowerOfExpressionRule__Group__0__Impl : ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__PowerOfExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3832:1: ( ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalOptimisationLanguage.g:3833:1: ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalOptimisationLanguage.g:3833:1: ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) )
            // InternalOptimisationLanguage.g:3834:2: ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 )
            {
             before(grammarAccess.getPowerOfExpressionRuleAccess().getLeftOperandAssignment_0()); 
            // InternalOptimisationLanguage.g:3835:2: ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 )
            // InternalOptimisationLanguage.g:3835:3: rule__PowerOfExpressionRule__LeftOperandAssignment_0
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
    // InternalOptimisationLanguage.g:3843:1: rule__PowerOfExpressionRule__Group__1 : rule__PowerOfExpressionRule__Group__1__Impl ;
    public final void rule__PowerOfExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3847:1: ( rule__PowerOfExpressionRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:3848:2: rule__PowerOfExpressionRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:3854:1: rule__PowerOfExpressionRule__Group__1__Impl : ( ( rule__PowerOfExpressionRule__Group_1__0 )? ) ;
    public final void rule__PowerOfExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3858:1: ( ( ( rule__PowerOfExpressionRule__Group_1__0 )? ) )
            // InternalOptimisationLanguage.g:3859:1: ( ( rule__PowerOfExpressionRule__Group_1__0 )? )
            {
            // InternalOptimisationLanguage.g:3859:1: ( ( rule__PowerOfExpressionRule__Group_1__0 )? )
            // InternalOptimisationLanguage.g:3860:2: ( rule__PowerOfExpressionRule__Group_1__0 )?
            {
             before(grammarAccess.getPowerOfExpressionRuleAccess().getGroup_1()); 
            // InternalOptimisationLanguage.g:3861:2: ( rule__PowerOfExpressionRule__Group_1__0 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==67) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalOptimisationLanguage.g:3861:3: rule__PowerOfExpressionRule__Group_1__0
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
    // InternalOptimisationLanguage.g:3870:1: rule__PowerOfExpressionRule__Group_1__0 : rule__PowerOfExpressionRule__Group_1__0__Impl rule__PowerOfExpressionRule__Group_1__1 ;
    public final void rule__PowerOfExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3874:1: ( rule__PowerOfExpressionRule__Group_1__0__Impl rule__PowerOfExpressionRule__Group_1__1 )
            // InternalOptimisationLanguage.g:3875:2: rule__PowerOfExpressionRule__Group_1__0__Impl rule__PowerOfExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_26);
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
    // InternalOptimisationLanguage.g:3882:1: rule__PowerOfExpressionRule__Group_1__0__Impl : ( '^' ) ;
    public final void rule__PowerOfExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3886:1: ( ( '^' ) )
            // InternalOptimisationLanguage.g:3887:1: ( '^' )
            {
            // InternalOptimisationLanguage.g:3887:1: ( '^' )
            // InternalOptimisationLanguage.g:3888:2: '^'
            {
             before(grammarAccess.getPowerOfExpressionRuleAccess().getCircumflexAccentKeyword_1_0()); 
            match(input,67,FOLLOW_2); 
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
    // InternalOptimisationLanguage.g:3897:1: rule__PowerOfExpressionRule__Group_1__1 : rule__PowerOfExpressionRule__Group_1__1__Impl ;
    public final void rule__PowerOfExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3901:1: ( rule__PowerOfExpressionRule__Group_1__1__Impl )
            // InternalOptimisationLanguage.g:3902:2: rule__PowerOfExpressionRule__Group_1__1__Impl
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
    // InternalOptimisationLanguage.g:3908:1: rule__PowerOfExpressionRule__Group_1__1__Impl : ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) ) ;
    public final void rule__PowerOfExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3912:1: ( ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) ) )
            // InternalOptimisationLanguage.g:3913:1: ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) )
            {
            // InternalOptimisationLanguage.g:3913:1: ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) )
            // InternalOptimisationLanguage.g:3914:2: ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 )
            {
             before(grammarAccess.getPowerOfExpressionRuleAccess().getRightOperandAssignment_1_1()); 
            // InternalOptimisationLanguage.g:3915:2: ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 )
            // InternalOptimisationLanguage.g:3915:3: rule__PowerOfExpressionRule__RightOperandAssignment_1_1
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
    // InternalOptimisationLanguage.g:3924:1: rule__UnaryAddOrSubtractExpressionRule__Group__0 : rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl rule__UnaryAddOrSubtractExpressionRule__Group__1 ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3928:1: ( rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl rule__UnaryAddOrSubtractExpressionRule__Group__1 )
            // InternalOptimisationLanguage.g:3929:2: rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl rule__UnaryAddOrSubtractExpressionRule__Group__1
            {
            pushFollow(FOLLOW_26);
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
    // InternalOptimisationLanguage.g:3936:1: rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl : ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3940:1: ( ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* ) )
            // InternalOptimisationLanguage.g:3941:1: ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* )
            {
            // InternalOptimisationLanguage.g:3941:1: ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* )
            // InternalOptimisationLanguage.g:3942:2: ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )*
            {
             before(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getOperatorsAssignment_0()); 
            // InternalOptimisationLanguage.g:3943:2: ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( ((LA30_0>=22 && LA30_0<=23)) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:3943:3: rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0
            	    {
            	    pushFollow(FOLLOW_34);
            	    rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop30;
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
    // InternalOptimisationLanguage.g:3951:1: rule__UnaryAddOrSubtractExpressionRule__Group__1 : rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3955:1: ( rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:3956:2: rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:3962:1: rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl : ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3966:1: ( ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) ) )
            // InternalOptimisationLanguage.g:3967:1: ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) )
            {
            // InternalOptimisationLanguage.g:3967:1: ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) )
            // InternalOptimisationLanguage.g:3968:2: ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 )
            {
             before(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getSubExpressionAssignment_1()); 
            // InternalOptimisationLanguage.g:3969:2: ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 )
            // InternalOptimisationLanguage.g:3969:3: rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1
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
    // InternalOptimisationLanguage.g:3978:1: rule__ParanthesesRule__Group__0 : rule__ParanthesesRule__Group__0__Impl rule__ParanthesesRule__Group__1 ;
    public final void rule__ParanthesesRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3982:1: ( rule__ParanthesesRule__Group__0__Impl rule__ParanthesesRule__Group__1 )
            // InternalOptimisationLanguage.g:3983:2: rule__ParanthesesRule__Group__0__Impl rule__ParanthesesRule__Group__1
            {
            pushFollow(FOLLOW_26);
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
    // InternalOptimisationLanguage.g:3990:1: rule__ParanthesesRule__Group__0__Impl : ( '(' ) ;
    public final void rule__ParanthesesRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:3994:1: ( ( '(' ) )
            // InternalOptimisationLanguage.g:3995:1: ( '(' )
            {
            // InternalOptimisationLanguage.g:3995:1: ( '(' )
            // InternalOptimisationLanguage.g:3996:2: '('
            {
             before(grammarAccess.getParanthesesRuleAccess().getLeftParenthesisKeyword_0()); 
            match(input,68,FOLLOW_2); 
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
    // InternalOptimisationLanguage.g:4005:1: rule__ParanthesesRule__Group__1 : rule__ParanthesesRule__Group__1__Impl rule__ParanthesesRule__Group__2 ;
    public final void rule__ParanthesesRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4009:1: ( rule__ParanthesesRule__Group__1__Impl rule__ParanthesesRule__Group__2 )
            // InternalOptimisationLanguage.g:4010:2: rule__ParanthesesRule__Group__1__Impl rule__ParanthesesRule__Group__2
            {
            pushFollow(FOLLOW_38);
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
    // InternalOptimisationLanguage.g:4017:1: rule__ParanthesesRule__Group__1__Impl : ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) ) ;
    public final void rule__ParanthesesRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4021:1: ( ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) ) )
            // InternalOptimisationLanguage.g:4022:1: ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) )
            {
            // InternalOptimisationLanguage.g:4022:1: ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) )
            // InternalOptimisationLanguage.g:4023:2: ( rule__ParanthesesRule__SubExpressionAssignment_1 )
            {
             before(grammarAccess.getParanthesesRuleAccess().getSubExpressionAssignment_1()); 
            // InternalOptimisationLanguage.g:4024:2: ( rule__ParanthesesRule__SubExpressionAssignment_1 )
            // InternalOptimisationLanguage.g:4024:3: rule__ParanthesesRule__SubExpressionAssignment_1
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
    // InternalOptimisationLanguage.g:4032:1: rule__ParanthesesRule__Group__2 : rule__ParanthesesRule__Group__2__Impl ;
    public final void rule__ParanthesesRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4036:1: ( rule__ParanthesesRule__Group__2__Impl )
            // InternalOptimisationLanguage.g:4037:2: rule__ParanthesesRule__Group__2__Impl
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
    // InternalOptimisationLanguage.g:4043:1: rule__ParanthesesRule__Group__2__Impl : ( ')' ) ;
    public final void rule__ParanthesesRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4047:1: ( ( ')' ) )
            // InternalOptimisationLanguage.g:4048:1: ( ')' )
            {
            // InternalOptimisationLanguage.g:4048:1: ( ')' )
            // InternalOptimisationLanguage.g:4049:2: ')'
            {
             before(grammarAccess.getParanthesesRuleAccess().getRightParenthesisKeyword_2()); 
            match(input,69,FOLLOW_2); 
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
    // InternalOptimisationLanguage.g:4059:1: rule__CallRule__Group__0 : rule__CallRule__Group__0__Impl rule__CallRule__Group__1 ;
    public final void rule__CallRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4063:1: ( rule__CallRule__Group__0__Impl rule__CallRule__Group__1 )
            // InternalOptimisationLanguage.g:4064:2: rule__CallRule__Group__0__Impl rule__CallRule__Group__1
            {
            pushFollow(FOLLOW_39);
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
    // InternalOptimisationLanguage.g:4071:1: rule__CallRule__Group__0__Impl : ( ( rule__CallRule__FunctionAssignment_0 ) ) ;
    public final void rule__CallRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4075:1: ( ( ( rule__CallRule__FunctionAssignment_0 ) ) )
            // InternalOptimisationLanguage.g:4076:1: ( ( rule__CallRule__FunctionAssignment_0 ) )
            {
            // InternalOptimisationLanguage.g:4076:1: ( ( rule__CallRule__FunctionAssignment_0 ) )
            // InternalOptimisationLanguage.g:4077:2: ( rule__CallRule__FunctionAssignment_0 )
            {
             before(grammarAccess.getCallRuleAccess().getFunctionAssignment_0()); 
            // InternalOptimisationLanguage.g:4078:2: ( rule__CallRule__FunctionAssignment_0 )
            // InternalOptimisationLanguage.g:4078:3: rule__CallRule__FunctionAssignment_0
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
    // InternalOptimisationLanguage.g:4086:1: rule__CallRule__Group__1 : rule__CallRule__Group__1__Impl rule__CallRule__Group__2 ;
    public final void rule__CallRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4090:1: ( rule__CallRule__Group__1__Impl rule__CallRule__Group__2 )
            // InternalOptimisationLanguage.g:4091:2: rule__CallRule__Group__1__Impl rule__CallRule__Group__2
            {
            pushFollow(FOLLOW_40);
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
    // InternalOptimisationLanguage.g:4098:1: rule__CallRule__Group__1__Impl : ( '(' ) ;
    public final void rule__CallRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4102:1: ( ( '(' ) )
            // InternalOptimisationLanguage.g:4103:1: ( '(' )
            {
            // InternalOptimisationLanguage.g:4103:1: ( '(' )
            // InternalOptimisationLanguage.g:4104:2: '('
            {
             before(grammarAccess.getCallRuleAccess().getLeftParenthesisKeyword_1()); 
            match(input,68,FOLLOW_2); 
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
    // InternalOptimisationLanguage.g:4113:1: rule__CallRule__Group__2 : rule__CallRule__Group__2__Impl rule__CallRule__Group__3 ;
    public final void rule__CallRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4117:1: ( rule__CallRule__Group__2__Impl rule__CallRule__Group__3 )
            // InternalOptimisationLanguage.g:4118:2: rule__CallRule__Group__2__Impl rule__CallRule__Group__3
            {
            pushFollow(FOLLOW_40);
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
    // InternalOptimisationLanguage.g:4125:1: rule__CallRule__Group__2__Impl : ( ( rule__CallRule__Group_2__0 )? ) ;
    public final void rule__CallRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4129:1: ( ( ( rule__CallRule__Group_2__0 )? ) )
            // InternalOptimisationLanguage.g:4130:1: ( ( rule__CallRule__Group_2__0 )? )
            {
            // InternalOptimisationLanguage.g:4130:1: ( ( rule__CallRule__Group_2__0 )? )
            // InternalOptimisationLanguage.g:4131:2: ( rule__CallRule__Group_2__0 )?
            {
             before(grammarAccess.getCallRuleAccess().getGroup_2()); 
            // InternalOptimisationLanguage.g:4132:2: ( rule__CallRule__Group_2__0 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( ((LA31_0>=RULE_QUOTED_ID && LA31_0<=RULE_STRING)||LA31_0==15||(LA31_0>=22 && LA31_0<=23)||LA31_0==68||LA31_0==70||(LA31_0>=81 && LA31_0<=82)) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalOptimisationLanguage.g:4132:3: rule__CallRule__Group_2__0
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
    // InternalOptimisationLanguage.g:4140:1: rule__CallRule__Group__3 : rule__CallRule__Group__3__Impl ;
    public final void rule__CallRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4144:1: ( rule__CallRule__Group__3__Impl )
            // InternalOptimisationLanguage.g:4145:2: rule__CallRule__Group__3__Impl
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
    // InternalOptimisationLanguage.g:4151:1: rule__CallRule__Group__3__Impl : ( ')' ) ;
    public final void rule__CallRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4155:1: ( ( ')' ) )
            // InternalOptimisationLanguage.g:4156:1: ( ')' )
            {
            // InternalOptimisationLanguage.g:4156:1: ( ')' )
            // InternalOptimisationLanguage.g:4157:2: ')'
            {
             before(grammarAccess.getCallRuleAccess().getRightParenthesisKeyword_3()); 
            match(input,69,FOLLOW_2); 
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
    // InternalOptimisationLanguage.g:4167:1: rule__CallRule__Group_2__0 : rule__CallRule__Group_2__0__Impl rule__CallRule__Group_2__1 ;
    public final void rule__CallRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4171:1: ( rule__CallRule__Group_2__0__Impl rule__CallRule__Group_2__1 )
            // InternalOptimisationLanguage.g:4172:2: rule__CallRule__Group_2__0__Impl rule__CallRule__Group_2__1
            {
            pushFollow(FOLLOW_19);
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
    // InternalOptimisationLanguage.g:4179:1: rule__CallRule__Group_2__0__Impl : ( ( rule__CallRule__ParametersAssignment_2_0 ) ) ;
    public final void rule__CallRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4183:1: ( ( ( rule__CallRule__ParametersAssignment_2_0 ) ) )
            // InternalOptimisationLanguage.g:4184:1: ( ( rule__CallRule__ParametersAssignment_2_0 ) )
            {
            // InternalOptimisationLanguage.g:4184:1: ( ( rule__CallRule__ParametersAssignment_2_0 ) )
            // InternalOptimisationLanguage.g:4185:2: ( rule__CallRule__ParametersAssignment_2_0 )
            {
             before(grammarAccess.getCallRuleAccess().getParametersAssignment_2_0()); 
            // InternalOptimisationLanguage.g:4186:2: ( rule__CallRule__ParametersAssignment_2_0 )
            // InternalOptimisationLanguage.g:4186:3: rule__CallRule__ParametersAssignment_2_0
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
    // InternalOptimisationLanguage.g:4194:1: rule__CallRule__Group_2__1 : rule__CallRule__Group_2__1__Impl ;
    public final void rule__CallRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4198:1: ( rule__CallRule__Group_2__1__Impl )
            // InternalOptimisationLanguage.g:4199:2: rule__CallRule__Group_2__1__Impl
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
    // InternalOptimisationLanguage.g:4205:1: rule__CallRule__Group_2__1__Impl : ( ( rule__CallRule__Group_2_1__0 )* ) ;
    public final void rule__CallRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4209:1: ( ( ( rule__CallRule__Group_2_1__0 )* ) )
            // InternalOptimisationLanguage.g:4210:1: ( ( rule__CallRule__Group_2_1__0 )* )
            {
            // InternalOptimisationLanguage.g:4210:1: ( ( rule__CallRule__Group_2_1__0 )* )
            // InternalOptimisationLanguage.g:4211:2: ( rule__CallRule__Group_2_1__0 )*
            {
             before(grammarAccess.getCallRuleAccess().getGroup_2_1()); 
            // InternalOptimisationLanguage.g:4212:2: ( rule__CallRule__Group_2_1__0 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==61) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:4212:3: rule__CallRule__Group_2_1__0
            	    {
            	    pushFollow(FOLLOW_20);
            	    rule__CallRule__Group_2_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop32;
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
    // InternalOptimisationLanguage.g:4221:1: rule__CallRule__Group_2_1__0 : rule__CallRule__Group_2_1__0__Impl rule__CallRule__Group_2_1__1 ;
    public final void rule__CallRule__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4225:1: ( rule__CallRule__Group_2_1__0__Impl rule__CallRule__Group_2_1__1 )
            // InternalOptimisationLanguage.g:4226:2: rule__CallRule__Group_2_1__0__Impl rule__CallRule__Group_2_1__1
            {
            pushFollow(FOLLOW_26);
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
    // InternalOptimisationLanguage.g:4233:1: rule__CallRule__Group_2_1__0__Impl : ( ',' ) ;
    public final void rule__CallRule__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4237:1: ( ( ',' ) )
            // InternalOptimisationLanguage.g:4238:1: ( ',' )
            {
            // InternalOptimisationLanguage.g:4238:1: ( ',' )
            // InternalOptimisationLanguage.g:4239:2: ','
            {
             before(grammarAccess.getCallRuleAccess().getCommaKeyword_2_1_0()); 
            match(input,61,FOLLOW_2); 
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
    // InternalOptimisationLanguage.g:4248:1: rule__CallRule__Group_2_1__1 : rule__CallRule__Group_2_1__1__Impl ;
    public final void rule__CallRule__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4252:1: ( rule__CallRule__Group_2_1__1__Impl )
            // InternalOptimisationLanguage.g:4253:2: rule__CallRule__Group_2_1__1__Impl
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
    // InternalOptimisationLanguage.g:4259:1: rule__CallRule__Group_2_1__1__Impl : ( ( rule__CallRule__ParametersAssignment_2_1_1 ) ) ;
    public final void rule__CallRule__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4263:1: ( ( ( rule__CallRule__ParametersAssignment_2_1_1 ) ) )
            // InternalOptimisationLanguage.g:4264:1: ( ( rule__CallRule__ParametersAssignment_2_1_1 ) )
            {
            // InternalOptimisationLanguage.g:4264:1: ( ( rule__CallRule__ParametersAssignment_2_1_1 ) )
            // InternalOptimisationLanguage.g:4265:2: ( rule__CallRule__ParametersAssignment_2_1_1 )
            {
             before(grammarAccess.getCallRuleAccess().getParametersAssignment_2_1_1()); 
            // InternalOptimisationLanguage.g:4266:2: ( rule__CallRule__ParametersAssignment_2_1_1 )
            // InternalOptimisationLanguage.g:4266:3: rule__CallRule__ParametersAssignment_2_1_1
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
    // InternalOptimisationLanguage.g:4275:1: rule__ValueReferenceRule__Group__0 : rule__ValueReferenceRule__Group__0__Impl rule__ValueReferenceRule__Group__1 ;
    public final void rule__ValueReferenceRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4279:1: ( rule__ValueReferenceRule__Group__0__Impl rule__ValueReferenceRule__Group__1 )
            // InternalOptimisationLanguage.g:4280:2: rule__ValueReferenceRule__Group__0__Impl rule__ValueReferenceRule__Group__1
            {
            pushFollow(FOLLOW_26);
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
    // InternalOptimisationLanguage.g:4287:1: rule__ValueReferenceRule__Group__0__Impl : ( () ) ;
    public final void rule__ValueReferenceRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4291:1: ( ( () ) )
            // InternalOptimisationLanguage.g:4292:1: ( () )
            {
            // InternalOptimisationLanguage.g:4292:1: ( () )
            // InternalOptimisationLanguage.g:4293:2: ()
            {
             before(grammarAccess.getValueReferenceRuleAccess().getValueReferenceAction_0()); 
            // InternalOptimisationLanguage.g:4294:2: ()
            // InternalOptimisationLanguage.g:4294:3: 
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
    // InternalOptimisationLanguage.g:4302:1: rule__ValueReferenceRule__Group__1 : rule__ValueReferenceRule__Group__1__Impl ;
    public final void rule__ValueReferenceRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4306:1: ( rule__ValueReferenceRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:4307:2: rule__ValueReferenceRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:4313:1: rule__ValueReferenceRule__Group__1__Impl : ( 'value' ) ;
    public final void rule__ValueReferenceRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4317:1: ( ( 'value' ) )
            // InternalOptimisationLanguage.g:4318:1: ( 'value' )
            {
            // InternalOptimisationLanguage.g:4318:1: ( 'value' )
            // InternalOptimisationLanguage.g:4319:2: 'value'
            {
             before(grammarAccess.getValueReferenceRuleAccess().getValueKeyword_1()); 
            match(input,70,FOLLOW_2); 
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
    // InternalOptimisationLanguage.g:4329:1: rule__DoubleLiteralRule__Group__0 : rule__DoubleLiteralRule__Group__0__Impl rule__DoubleLiteralRule__Group__1 ;
    public final void rule__DoubleLiteralRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4333:1: ( rule__DoubleLiteralRule__Group__0__Impl rule__DoubleLiteralRule__Group__1 )
            // InternalOptimisationLanguage.g:4334:2: rule__DoubleLiteralRule__Group__0__Impl rule__DoubleLiteralRule__Group__1
            {
            pushFollow(FOLLOW_41);
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
    // InternalOptimisationLanguage.g:4341:1: rule__DoubleLiteralRule__Group__0__Impl : ( ( rule__DoubleLiteralRule__LiteralAssignment_0 ) ) ;
    public final void rule__DoubleLiteralRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4345:1: ( ( ( rule__DoubleLiteralRule__LiteralAssignment_0 ) ) )
            // InternalOptimisationLanguage.g:4346:1: ( ( rule__DoubleLiteralRule__LiteralAssignment_0 ) )
            {
            // InternalOptimisationLanguage.g:4346:1: ( ( rule__DoubleLiteralRule__LiteralAssignment_0 ) )
            // InternalOptimisationLanguage.g:4347:2: ( rule__DoubleLiteralRule__LiteralAssignment_0 )
            {
             before(grammarAccess.getDoubleLiteralRuleAccess().getLiteralAssignment_0()); 
            // InternalOptimisationLanguage.g:4348:2: ( rule__DoubleLiteralRule__LiteralAssignment_0 )
            // InternalOptimisationLanguage.g:4348:3: rule__DoubleLiteralRule__LiteralAssignment_0
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
    // InternalOptimisationLanguage.g:4356:1: rule__DoubleLiteralRule__Group__1 : rule__DoubleLiteralRule__Group__1__Impl ;
    public final void rule__DoubleLiteralRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4360:1: ( rule__DoubleLiteralRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:4361:2: rule__DoubleLiteralRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:4367:1: rule__DoubleLiteralRule__Group__1__Impl : ( ( rule__DoubleLiteralRule__FactorAssignment_1 )? ) ;
    public final void rule__DoubleLiteralRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4371:1: ( ( ( rule__DoubleLiteralRule__FactorAssignment_1 )? ) )
            // InternalOptimisationLanguage.g:4372:1: ( ( rule__DoubleLiteralRule__FactorAssignment_1 )? )
            {
            // InternalOptimisationLanguage.g:4372:1: ( ( rule__DoubleLiteralRule__FactorAssignment_1 )? )
            // InternalOptimisationLanguage.g:4373:2: ( rule__DoubleLiteralRule__FactorAssignment_1 )?
            {
             before(grammarAccess.getDoubleLiteralRuleAccess().getFactorAssignment_1()); 
            // InternalOptimisationLanguage.g:4374:2: ( rule__DoubleLiteralRule__FactorAssignment_1 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( ((LA33_0>=27 && LA33_0<=46)) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalOptimisationLanguage.g:4374:3: rule__DoubleLiteralRule__FactorAssignment_1
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
    // InternalOptimisationLanguage.g:4383:1: rule__IntegerLiteralRule__Group__0 : rule__IntegerLiteralRule__Group__0__Impl rule__IntegerLiteralRule__Group__1 ;
    public final void rule__IntegerLiteralRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4387:1: ( rule__IntegerLiteralRule__Group__0__Impl rule__IntegerLiteralRule__Group__1 )
            // InternalOptimisationLanguage.g:4388:2: rule__IntegerLiteralRule__Group__0__Impl rule__IntegerLiteralRule__Group__1
            {
            pushFollow(FOLLOW_41);
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
    // InternalOptimisationLanguage.g:4395:1: rule__IntegerLiteralRule__Group__0__Impl : ( ( rule__IntegerLiteralRule__LiteralAssignment_0 ) ) ;
    public final void rule__IntegerLiteralRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4399:1: ( ( ( rule__IntegerLiteralRule__LiteralAssignment_0 ) ) )
            // InternalOptimisationLanguage.g:4400:1: ( ( rule__IntegerLiteralRule__LiteralAssignment_0 ) )
            {
            // InternalOptimisationLanguage.g:4400:1: ( ( rule__IntegerLiteralRule__LiteralAssignment_0 ) )
            // InternalOptimisationLanguage.g:4401:2: ( rule__IntegerLiteralRule__LiteralAssignment_0 )
            {
             before(grammarAccess.getIntegerLiteralRuleAccess().getLiteralAssignment_0()); 
            // InternalOptimisationLanguage.g:4402:2: ( rule__IntegerLiteralRule__LiteralAssignment_0 )
            // InternalOptimisationLanguage.g:4402:3: rule__IntegerLiteralRule__LiteralAssignment_0
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
    // InternalOptimisationLanguage.g:4410:1: rule__IntegerLiteralRule__Group__1 : rule__IntegerLiteralRule__Group__1__Impl ;
    public final void rule__IntegerLiteralRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4414:1: ( rule__IntegerLiteralRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:4415:2: rule__IntegerLiteralRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:4421:1: rule__IntegerLiteralRule__Group__1__Impl : ( ( rule__IntegerLiteralRule__FactorAssignment_1 )? ) ;
    public final void rule__IntegerLiteralRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4425:1: ( ( ( rule__IntegerLiteralRule__FactorAssignment_1 )? ) )
            // InternalOptimisationLanguage.g:4426:1: ( ( rule__IntegerLiteralRule__FactorAssignment_1 )? )
            {
            // InternalOptimisationLanguage.g:4426:1: ( ( rule__IntegerLiteralRule__FactorAssignment_1 )? )
            // InternalOptimisationLanguage.g:4427:2: ( rule__IntegerLiteralRule__FactorAssignment_1 )?
            {
             before(grammarAccess.getIntegerLiteralRuleAccess().getFactorAssignment_1()); 
            // InternalOptimisationLanguage.g:4428:2: ( rule__IntegerLiteralRule__FactorAssignment_1 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( ((LA34_0>=27 && LA34_0<=46)) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalOptimisationLanguage.g:4428:3: rule__IntegerLiteralRule__FactorAssignment_1
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
    // InternalOptimisationLanguage.g:4437:1: rule__BooleanLiteralRule__Group__0 : rule__BooleanLiteralRule__Group__0__Impl rule__BooleanLiteralRule__Group__1 ;
    public final void rule__BooleanLiteralRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4441:1: ( rule__BooleanLiteralRule__Group__0__Impl rule__BooleanLiteralRule__Group__1 )
            // InternalOptimisationLanguage.g:4442:2: rule__BooleanLiteralRule__Group__0__Impl rule__BooleanLiteralRule__Group__1
            {
            pushFollow(FOLLOW_17);
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
    // InternalOptimisationLanguage.g:4449:1: rule__BooleanLiteralRule__Group__0__Impl : ( () ) ;
    public final void rule__BooleanLiteralRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4453:1: ( ( () ) )
            // InternalOptimisationLanguage.g:4454:1: ( () )
            {
            // InternalOptimisationLanguage.g:4454:1: ( () )
            // InternalOptimisationLanguage.g:4455:2: ()
            {
             before(grammarAccess.getBooleanLiteralRuleAccess().getBooleanLiteralAction_0()); 
            // InternalOptimisationLanguage.g:4456:2: ()
            // InternalOptimisationLanguage.g:4456:3: 
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
    // InternalOptimisationLanguage.g:4464:1: rule__BooleanLiteralRule__Group__1 : rule__BooleanLiteralRule__Group__1__Impl ;
    public final void rule__BooleanLiteralRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4468:1: ( rule__BooleanLiteralRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:4469:2: rule__BooleanLiteralRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:4475:1: rule__BooleanLiteralRule__Group__1__Impl : ( ( rule__BooleanLiteralRule__Alternatives_1 ) ) ;
    public final void rule__BooleanLiteralRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4479:1: ( ( ( rule__BooleanLiteralRule__Alternatives_1 ) ) )
            // InternalOptimisationLanguage.g:4480:1: ( ( rule__BooleanLiteralRule__Alternatives_1 ) )
            {
            // InternalOptimisationLanguage.g:4480:1: ( ( rule__BooleanLiteralRule__Alternatives_1 ) )
            // InternalOptimisationLanguage.g:4481:2: ( rule__BooleanLiteralRule__Alternatives_1 )
            {
             before(grammarAccess.getBooleanLiteralRuleAccess().getAlternatives_1()); 
            // InternalOptimisationLanguage.g:4482:2: ( rule__BooleanLiteralRule__Alternatives_1 )
            // InternalOptimisationLanguage.g:4482:3: rule__BooleanLiteralRule__Alternatives_1
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
    // InternalOptimisationLanguage.g:4491:1: rule__AttributeDefinitionRule__Group__0 : rule__AttributeDefinitionRule__Group__0__Impl rule__AttributeDefinitionRule__Group__1 ;
    public final void rule__AttributeDefinitionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4495:1: ( rule__AttributeDefinitionRule__Group__0__Impl rule__AttributeDefinitionRule__Group__1 )
            // InternalOptimisationLanguage.g:4496:2: rule__AttributeDefinitionRule__Group__0__Impl rule__AttributeDefinitionRule__Group__1
            {
            pushFollow(FOLLOW_42);
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
    // InternalOptimisationLanguage.g:4503:1: rule__AttributeDefinitionRule__Group__0__Impl : ( ( rule__AttributeDefinitionRule__NameAssignment_0 ) ) ;
    public final void rule__AttributeDefinitionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4507:1: ( ( ( rule__AttributeDefinitionRule__NameAssignment_0 ) ) )
            // InternalOptimisationLanguage.g:4508:1: ( ( rule__AttributeDefinitionRule__NameAssignment_0 ) )
            {
            // InternalOptimisationLanguage.g:4508:1: ( ( rule__AttributeDefinitionRule__NameAssignment_0 ) )
            // InternalOptimisationLanguage.g:4509:2: ( rule__AttributeDefinitionRule__NameAssignment_0 )
            {
             before(grammarAccess.getAttributeDefinitionRuleAccess().getNameAssignment_0()); 
            // InternalOptimisationLanguage.g:4510:2: ( rule__AttributeDefinitionRule__NameAssignment_0 )
            // InternalOptimisationLanguage.g:4510:3: rule__AttributeDefinitionRule__NameAssignment_0
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
    // InternalOptimisationLanguage.g:4518:1: rule__AttributeDefinitionRule__Group__1 : rule__AttributeDefinitionRule__Group__1__Impl rule__AttributeDefinitionRule__Group__2 ;
    public final void rule__AttributeDefinitionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4522:1: ( rule__AttributeDefinitionRule__Group__1__Impl rule__AttributeDefinitionRule__Group__2 )
            // InternalOptimisationLanguage.g:4523:2: rule__AttributeDefinitionRule__Group__1__Impl rule__AttributeDefinitionRule__Group__2
            {
            pushFollow(FOLLOW_43);
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
    // InternalOptimisationLanguage.g:4530:1: rule__AttributeDefinitionRule__Group__1__Impl : ( ':' ) ;
    public final void rule__AttributeDefinitionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4534:1: ( ( ':' ) )
            // InternalOptimisationLanguage.g:4535:1: ( ':' )
            {
            // InternalOptimisationLanguage.g:4535:1: ( ':' )
            // InternalOptimisationLanguage.g:4536:2: ':'
            {
             before(grammarAccess.getAttributeDefinitionRuleAccess().getColonKeyword_1()); 
            match(input,71,FOLLOW_2); 
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
    // InternalOptimisationLanguage.g:4545:1: rule__AttributeDefinitionRule__Group__2 : rule__AttributeDefinitionRule__Group__2__Impl rule__AttributeDefinitionRule__Group__3 ;
    public final void rule__AttributeDefinitionRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4549:1: ( rule__AttributeDefinitionRule__Group__2__Impl rule__AttributeDefinitionRule__Group__3 )
            // InternalOptimisationLanguage.g:4550:2: rule__AttributeDefinitionRule__Group__2__Impl rule__AttributeDefinitionRule__Group__3
            {
            pushFollow(FOLLOW_6);
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
    // InternalOptimisationLanguage.g:4557:1: rule__AttributeDefinitionRule__Group__2__Impl : ( ( rule__AttributeDefinitionRule__TypeAssignment_2 ) ) ;
    public final void rule__AttributeDefinitionRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4561:1: ( ( ( rule__AttributeDefinitionRule__TypeAssignment_2 ) ) )
            // InternalOptimisationLanguage.g:4562:1: ( ( rule__AttributeDefinitionRule__TypeAssignment_2 ) )
            {
            // InternalOptimisationLanguage.g:4562:1: ( ( rule__AttributeDefinitionRule__TypeAssignment_2 ) )
            // InternalOptimisationLanguage.g:4563:2: ( rule__AttributeDefinitionRule__TypeAssignment_2 )
            {
             before(grammarAccess.getAttributeDefinitionRuleAccess().getTypeAssignment_2()); 
            // InternalOptimisationLanguage.g:4564:2: ( rule__AttributeDefinitionRule__TypeAssignment_2 )
            // InternalOptimisationLanguage.g:4564:3: rule__AttributeDefinitionRule__TypeAssignment_2
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
    // InternalOptimisationLanguage.g:4572:1: rule__AttributeDefinitionRule__Group__3 : rule__AttributeDefinitionRule__Group__3__Impl ;
    public final void rule__AttributeDefinitionRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4576:1: ( rule__AttributeDefinitionRule__Group__3__Impl )
            // InternalOptimisationLanguage.g:4577:2: rule__AttributeDefinitionRule__Group__3__Impl
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
    // InternalOptimisationLanguage.g:4583:1: rule__AttributeDefinitionRule__Group__3__Impl : ( ';' ) ;
    public final void rule__AttributeDefinitionRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4587:1: ( ( ';' ) )
            // InternalOptimisationLanguage.g:4588:1: ( ';' )
            {
            // InternalOptimisationLanguage.g:4588:1: ( ';' )
            // InternalOptimisationLanguage.g:4589:2: ';'
            {
             before(grammarAccess.getAttributeDefinitionRuleAccess().getSemicolonKeyword_3()); 
            match(input,48,FOLLOW_2); 
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
    // InternalOptimisationLanguage.g:4599:1: rule__LiteralTypeRule__Group__0 : rule__LiteralTypeRule__Group__0__Impl rule__LiteralTypeRule__Group__1 ;
    public final void rule__LiteralTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4603:1: ( rule__LiteralTypeRule__Group__0__Impl rule__LiteralTypeRule__Group__1 )
            // InternalOptimisationLanguage.g:4604:2: rule__LiteralTypeRule__Group__0__Impl rule__LiteralTypeRule__Group__1
            {
            pushFollow(FOLLOW_44);
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
    // InternalOptimisationLanguage.g:4611:1: rule__LiteralTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__LiteralTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4615:1: ( ( () ) )
            // InternalOptimisationLanguage.g:4616:1: ( () )
            {
            // InternalOptimisationLanguage.g:4616:1: ( () )
            // InternalOptimisationLanguage.g:4617:2: ()
            {
             before(grammarAccess.getLiteralTypeRuleAccess().getLiteralTypeAction_0()); 
            // InternalOptimisationLanguage.g:4618:2: ()
            // InternalOptimisationLanguage.g:4618:3: 
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
    // InternalOptimisationLanguage.g:4626:1: rule__LiteralTypeRule__Group__1 : rule__LiteralTypeRule__Group__1__Impl ;
    public final void rule__LiteralTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4630:1: ( rule__LiteralTypeRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:4631:2: rule__LiteralTypeRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:4637:1: rule__LiteralTypeRule__Group__1__Impl : ( 'literal' ) ;
    public final void rule__LiteralTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4641:1: ( ( 'literal' ) )
            // InternalOptimisationLanguage.g:4642:1: ( 'literal' )
            {
            // InternalOptimisationLanguage.g:4642:1: ( 'literal' )
            // InternalOptimisationLanguage.g:4643:2: 'literal'
            {
             before(grammarAccess.getLiteralTypeRuleAccess().getLiteralKeyword_1()); 
            match(input,72,FOLLOW_2); 
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
    // InternalOptimisationLanguage.g:4653:1: rule__InstanceTypeRule__Group__0 : rule__InstanceTypeRule__Group__0__Impl rule__InstanceTypeRule__Group__1 ;
    public final void rule__InstanceTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4657:1: ( rule__InstanceTypeRule__Group__0__Impl rule__InstanceTypeRule__Group__1 )
            // InternalOptimisationLanguage.g:4658:2: rule__InstanceTypeRule__Group__0__Impl rule__InstanceTypeRule__Group__1
            {
            pushFollow(FOLLOW_45);
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
    // InternalOptimisationLanguage.g:4665:1: rule__InstanceTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__InstanceTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4669:1: ( ( () ) )
            // InternalOptimisationLanguage.g:4670:1: ( () )
            {
            // InternalOptimisationLanguage.g:4670:1: ( () )
            // InternalOptimisationLanguage.g:4671:2: ()
            {
             before(grammarAccess.getInstanceTypeRuleAccess().getInstanceTypeAction_0()); 
            // InternalOptimisationLanguage.g:4672:2: ()
            // InternalOptimisationLanguage.g:4672:3: 
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
    // InternalOptimisationLanguage.g:4680:1: rule__InstanceTypeRule__Group__1 : rule__InstanceTypeRule__Group__1__Impl rule__InstanceTypeRule__Group__2 ;
    public final void rule__InstanceTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4684:1: ( rule__InstanceTypeRule__Group__1__Impl rule__InstanceTypeRule__Group__2 )
            // InternalOptimisationLanguage.g:4685:2: rule__InstanceTypeRule__Group__1__Impl rule__InstanceTypeRule__Group__2
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
    // InternalOptimisationLanguage.g:4692:1: rule__InstanceTypeRule__Group__1__Impl : ( 'instance' ) ;
    public final void rule__InstanceTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4696:1: ( ( 'instance' ) )
            // InternalOptimisationLanguage.g:4697:1: ( 'instance' )
            {
            // InternalOptimisationLanguage.g:4697:1: ( 'instance' )
            // InternalOptimisationLanguage.g:4698:2: 'instance'
            {
             before(grammarAccess.getInstanceTypeRuleAccess().getInstanceKeyword_1()); 
            match(input,53,FOLLOW_2); 
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
    // InternalOptimisationLanguage.g:4707:1: rule__InstanceTypeRule__Group__2 : rule__InstanceTypeRule__Group__2__Impl rule__InstanceTypeRule__Group__3 ;
    public final void rule__InstanceTypeRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4711:1: ( rule__InstanceTypeRule__Group__2__Impl rule__InstanceTypeRule__Group__3 )
            // InternalOptimisationLanguage.g:4712:2: rule__InstanceTypeRule__Group__2__Impl rule__InstanceTypeRule__Group__3
            {
            pushFollow(FOLLOW_46);
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
    // InternalOptimisationLanguage.g:4719:1: rule__InstanceTypeRule__Group__2__Impl : ( ( rule__InstanceTypeRule__DefinitionsAssignment_2 ) ) ;
    public final void rule__InstanceTypeRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4723:1: ( ( ( rule__InstanceTypeRule__DefinitionsAssignment_2 ) ) )
            // InternalOptimisationLanguage.g:4724:1: ( ( rule__InstanceTypeRule__DefinitionsAssignment_2 ) )
            {
            // InternalOptimisationLanguage.g:4724:1: ( ( rule__InstanceTypeRule__DefinitionsAssignment_2 ) )
            // InternalOptimisationLanguage.g:4725:2: ( rule__InstanceTypeRule__DefinitionsAssignment_2 )
            {
             before(grammarAccess.getInstanceTypeRuleAccess().getDefinitionsAssignment_2()); 
            // InternalOptimisationLanguage.g:4726:2: ( rule__InstanceTypeRule__DefinitionsAssignment_2 )
            // InternalOptimisationLanguage.g:4726:3: rule__InstanceTypeRule__DefinitionsAssignment_2
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
    // InternalOptimisationLanguage.g:4734:1: rule__InstanceTypeRule__Group__3 : rule__InstanceTypeRule__Group__3__Impl ;
    public final void rule__InstanceTypeRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4738:1: ( rule__InstanceTypeRule__Group__3__Impl )
            // InternalOptimisationLanguage.g:4739:2: rule__InstanceTypeRule__Group__3__Impl
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
    // InternalOptimisationLanguage.g:4745:1: rule__InstanceTypeRule__Group__3__Impl : ( ( rule__InstanceTypeRule__Group_3__0 )* ) ;
    public final void rule__InstanceTypeRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4749:1: ( ( ( rule__InstanceTypeRule__Group_3__0 )* ) )
            // InternalOptimisationLanguage.g:4750:1: ( ( rule__InstanceTypeRule__Group_3__0 )* )
            {
            // InternalOptimisationLanguage.g:4750:1: ( ( rule__InstanceTypeRule__Group_3__0 )* )
            // InternalOptimisationLanguage.g:4751:2: ( rule__InstanceTypeRule__Group_3__0 )*
            {
             before(grammarAccess.getInstanceTypeRuleAccess().getGroup_3()); 
            // InternalOptimisationLanguage.g:4752:2: ( rule__InstanceTypeRule__Group_3__0 )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==73) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:4752:3: rule__InstanceTypeRule__Group_3__0
            	    {
            	    pushFollow(FOLLOW_47);
            	    rule__InstanceTypeRule__Group_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop35;
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
    // InternalOptimisationLanguage.g:4761:1: rule__InstanceTypeRule__Group_3__0 : rule__InstanceTypeRule__Group_3__0__Impl rule__InstanceTypeRule__Group_3__1 ;
    public final void rule__InstanceTypeRule__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4765:1: ( rule__InstanceTypeRule__Group_3__0__Impl rule__InstanceTypeRule__Group_3__1 )
            // InternalOptimisationLanguage.g:4766:2: rule__InstanceTypeRule__Group_3__0__Impl rule__InstanceTypeRule__Group_3__1
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
    // InternalOptimisationLanguage.g:4773:1: rule__InstanceTypeRule__Group_3__0__Impl : ( '|' ) ;
    public final void rule__InstanceTypeRule__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4777:1: ( ( '|' ) )
            // InternalOptimisationLanguage.g:4778:1: ( '|' )
            {
            // InternalOptimisationLanguage.g:4778:1: ( '|' )
            // InternalOptimisationLanguage.g:4779:2: '|'
            {
             before(grammarAccess.getInstanceTypeRuleAccess().getVerticalLineKeyword_3_0()); 
            match(input,73,FOLLOW_2); 
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
    // InternalOptimisationLanguage.g:4788:1: rule__InstanceTypeRule__Group_3__1 : rule__InstanceTypeRule__Group_3__1__Impl ;
    public final void rule__InstanceTypeRule__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4792:1: ( rule__InstanceTypeRule__Group_3__1__Impl )
            // InternalOptimisationLanguage.g:4793:2: rule__InstanceTypeRule__Group_3__1__Impl
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
    // InternalOptimisationLanguage.g:4799:1: rule__InstanceTypeRule__Group_3__1__Impl : ( ( rule__InstanceTypeRule__DefinitionsAssignment_3_1 ) ) ;
    public final void rule__InstanceTypeRule__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4803:1: ( ( ( rule__InstanceTypeRule__DefinitionsAssignment_3_1 ) ) )
            // InternalOptimisationLanguage.g:4804:1: ( ( rule__InstanceTypeRule__DefinitionsAssignment_3_1 ) )
            {
            // InternalOptimisationLanguage.g:4804:1: ( ( rule__InstanceTypeRule__DefinitionsAssignment_3_1 ) )
            // InternalOptimisationLanguage.g:4805:2: ( rule__InstanceTypeRule__DefinitionsAssignment_3_1 )
            {
             before(grammarAccess.getInstanceTypeRuleAccess().getDefinitionsAssignment_3_1()); 
            // InternalOptimisationLanguage.g:4806:2: ( rule__InstanceTypeRule__DefinitionsAssignment_3_1 )
            // InternalOptimisationLanguage.g:4806:3: rule__InstanceTypeRule__DefinitionsAssignment_3_1
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
    // InternalOptimisationLanguage.g:4815:1: rule__StringTypeRule__Group__0 : rule__StringTypeRule__Group__0__Impl rule__StringTypeRule__Group__1 ;
    public final void rule__StringTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4819:1: ( rule__StringTypeRule__Group__0__Impl rule__StringTypeRule__Group__1 )
            // InternalOptimisationLanguage.g:4820:2: rule__StringTypeRule__Group__0__Impl rule__StringTypeRule__Group__1
            {
            pushFollow(FOLLOW_48);
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
    // InternalOptimisationLanguage.g:4827:1: rule__StringTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__StringTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4831:1: ( ( () ) )
            // InternalOptimisationLanguage.g:4832:1: ( () )
            {
            // InternalOptimisationLanguage.g:4832:1: ( () )
            // InternalOptimisationLanguage.g:4833:2: ()
            {
             before(grammarAccess.getStringTypeRuleAccess().getStringTypeAction_0()); 
            // InternalOptimisationLanguage.g:4834:2: ()
            // InternalOptimisationLanguage.g:4834:3: 
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
    // InternalOptimisationLanguage.g:4842:1: rule__StringTypeRule__Group__1 : rule__StringTypeRule__Group__1__Impl ;
    public final void rule__StringTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4846:1: ( rule__StringTypeRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:4847:2: rule__StringTypeRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:4853:1: rule__StringTypeRule__Group__1__Impl : ( 'string' ) ;
    public final void rule__StringTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4857:1: ( ( 'string' ) )
            // InternalOptimisationLanguage.g:4858:1: ( 'string' )
            {
            // InternalOptimisationLanguage.g:4858:1: ( 'string' )
            // InternalOptimisationLanguage.g:4859:2: 'string'
            {
             before(grammarAccess.getStringTypeRuleAccess().getStringKeyword_1()); 
            match(input,74,FOLLOW_2); 
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
    // InternalOptimisationLanguage.g:4869:1: rule__ExpressionTypeRule__Group__0 : rule__ExpressionTypeRule__Group__0__Impl rule__ExpressionTypeRule__Group__1 ;
    public final void rule__ExpressionTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4873:1: ( rule__ExpressionTypeRule__Group__0__Impl rule__ExpressionTypeRule__Group__1 )
            // InternalOptimisationLanguage.g:4874:2: rule__ExpressionTypeRule__Group__0__Impl rule__ExpressionTypeRule__Group__1
            {
            pushFollow(FOLLOW_49);
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
    // InternalOptimisationLanguage.g:4881:1: rule__ExpressionTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__ExpressionTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4885:1: ( ( () ) )
            // InternalOptimisationLanguage.g:4886:1: ( () )
            {
            // InternalOptimisationLanguage.g:4886:1: ( () )
            // InternalOptimisationLanguage.g:4887:2: ()
            {
             before(grammarAccess.getExpressionTypeRuleAccess().getExpressionTypeAction_0()); 
            // InternalOptimisationLanguage.g:4888:2: ()
            // InternalOptimisationLanguage.g:4888:3: 
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
    // InternalOptimisationLanguage.g:4896:1: rule__ExpressionTypeRule__Group__1 : rule__ExpressionTypeRule__Group__1__Impl ;
    public final void rule__ExpressionTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4900:1: ( rule__ExpressionTypeRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:4901:2: rule__ExpressionTypeRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:4907:1: rule__ExpressionTypeRule__Group__1__Impl : ( 'expression' ) ;
    public final void rule__ExpressionTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4911:1: ( ( 'expression' ) )
            // InternalOptimisationLanguage.g:4912:1: ( 'expression' )
            {
            // InternalOptimisationLanguage.g:4912:1: ( 'expression' )
            // InternalOptimisationLanguage.g:4913:2: 'expression'
            {
             before(grammarAccess.getExpressionTypeRuleAccess().getExpressionKeyword_1()); 
            match(input,75,FOLLOW_2); 
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
    // InternalOptimisationLanguage.g:4923:1: rule__IntTypeRule__Group__0 : rule__IntTypeRule__Group__0__Impl rule__IntTypeRule__Group__1 ;
    public final void rule__IntTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4927:1: ( rule__IntTypeRule__Group__0__Impl rule__IntTypeRule__Group__1 )
            // InternalOptimisationLanguage.g:4928:2: rule__IntTypeRule__Group__0__Impl rule__IntTypeRule__Group__1
            {
            pushFollow(FOLLOW_50);
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
    // InternalOptimisationLanguage.g:4935:1: rule__IntTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__IntTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4939:1: ( ( () ) )
            // InternalOptimisationLanguage.g:4940:1: ( () )
            {
            // InternalOptimisationLanguage.g:4940:1: ( () )
            // InternalOptimisationLanguage.g:4941:2: ()
            {
             before(grammarAccess.getIntTypeRuleAccess().getIntTypeAction_0()); 
            // InternalOptimisationLanguage.g:4942:2: ()
            // InternalOptimisationLanguage.g:4942:3: 
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
    // InternalOptimisationLanguage.g:4950:1: rule__IntTypeRule__Group__1 : rule__IntTypeRule__Group__1__Impl ;
    public final void rule__IntTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4954:1: ( rule__IntTypeRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:4955:2: rule__IntTypeRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:4961:1: rule__IntTypeRule__Group__1__Impl : ( 'int' ) ;
    public final void rule__IntTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4965:1: ( ( 'int' ) )
            // InternalOptimisationLanguage.g:4966:1: ( 'int' )
            {
            // InternalOptimisationLanguage.g:4966:1: ( 'int' )
            // InternalOptimisationLanguage.g:4967:2: 'int'
            {
             before(grammarAccess.getIntTypeRuleAccess().getIntKeyword_1()); 
            match(input,76,FOLLOW_2); 
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
    // InternalOptimisationLanguage.g:4977:1: rule__FloatTypeRule__Group__0 : rule__FloatTypeRule__Group__0__Impl rule__FloatTypeRule__Group__1 ;
    public final void rule__FloatTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4981:1: ( rule__FloatTypeRule__Group__0__Impl rule__FloatTypeRule__Group__1 )
            // InternalOptimisationLanguage.g:4982:2: rule__FloatTypeRule__Group__0__Impl rule__FloatTypeRule__Group__1
            {
            pushFollow(FOLLOW_51);
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
    // InternalOptimisationLanguage.g:4989:1: rule__FloatTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__FloatTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:4993:1: ( ( () ) )
            // InternalOptimisationLanguage.g:4994:1: ( () )
            {
            // InternalOptimisationLanguage.g:4994:1: ( () )
            // InternalOptimisationLanguage.g:4995:2: ()
            {
             before(grammarAccess.getFloatTypeRuleAccess().getFloatTypeAction_0()); 
            // InternalOptimisationLanguage.g:4996:2: ()
            // InternalOptimisationLanguage.g:4996:3: 
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
    // InternalOptimisationLanguage.g:5004:1: rule__FloatTypeRule__Group__1 : rule__FloatTypeRule__Group__1__Impl ;
    public final void rule__FloatTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5008:1: ( rule__FloatTypeRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:5009:2: rule__FloatTypeRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:5015:1: rule__FloatTypeRule__Group__1__Impl : ( 'float' ) ;
    public final void rule__FloatTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5019:1: ( ( 'float' ) )
            // InternalOptimisationLanguage.g:5020:1: ( 'float' )
            {
            // InternalOptimisationLanguage.g:5020:1: ( 'float' )
            // InternalOptimisationLanguage.g:5021:2: 'float'
            {
             before(grammarAccess.getFloatTypeRuleAccess().getFloatKeyword_1()); 
            match(input,77,FOLLOW_2); 
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
    // InternalOptimisationLanguage.g:5031:1: rule__BooleanTypeRule__Group__0 : rule__BooleanTypeRule__Group__0__Impl rule__BooleanTypeRule__Group__1 ;
    public final void rule__BooleanTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5035:1: ( rule__BooleanTypeRule__Group__0__Impl rule__BooleanTypeRule__Group__1 )
            // InternalOptimisationLanguage.g:5036:2: rule__BooleanTypeRule__Group__0__Impl rule__BooleanTypeRule__Group__1
            {
            pushFollow(FOLLOW_52);
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
    // InternalOptimisationLanguage.g:5043:1: rule__BooleanTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__BooleanTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5047:1: ( ( () ) )
            // InternalOptimisationLanguage.g:5048:1: ( () )
            {
            // InternalOptimisationLanguage.g:5048:1: ( () )
            // InternalOptimisationLanguage.g:5049:2: ()
            {
             before(grammarAccess.getBooleanTypeRuleAccess().getBooleanTypeAction_0()); 
            // InternalOptimisationLanguage.g:5050:2: ()
            // InternalOptimisationLanguage.g:5050:3: 
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
    // InternalOptimisationLanguage.g:5058:1: rule__BooleanTypeRule__Group__1 : rule__BooleanTypeRule__Group__1__Impl ;
    public final void rule__BooleanTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5062:1: ( rule__BooleanTypeRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:5063:2: rule__BooleanTypeRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:5069:1: rule__BooleanTypeRule__Group__1__Impl : ( 'boolean' ) ;
    public final void rule__BooleanTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5073:1: ( ( 'boolean' ) )
            // InternalOptimisationLanguage.g:5074:1: ( 'boolean' )
            {
            // InternalOptimisationLanguage.g:5074:1: ( 'boolean' )
            // InternalOptimisationLanguage.g:5075:2: 'boolean'
            {
             before(grammarAccess.getBooleanTypeRuleAccess().getBooleanKeyword_1()); 
            match(input,78,FOLLOW_2); 
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
    // InternalOptimisationLanguage.g:5085:1: rule__VoidTypeRule__Group__0 : rule__VoidTypeRule__Group__0__Impl rule__VoidTypeRule__Group__1 ;
    public final void rule__VoidTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5089:1: ( rule__VoidTypeRule__Group__0__Impl rule__VoidTypeRule__Group__1 )
            // InternalOptimisationLanguage.g:5090:2: rule__VoidTypeRule__Group__0__Impl rule__VoidTypeRule__Group__1
            {
            pushFollow(FOLLOW_53);
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
    // InternalOptimisationLanguage.g:5097:1: rule__VoidTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__VoidTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5101:1: ( ( () ) )
            // InternalOptimisationLanguage.g:5102:1: ( () )
            {
            // InternalOptimisationLanguage.g:5102:1: ( () )
            // InternalOptimisationLanguage.g:5103:2: ()
            {
             before(grammarAccess.getVoidTypeRuleAccess().getVoidTypeAction_0()); 
            // InternalOptimisationLanguage.g:5104:2: ()
            // InternalOptimisationLanguage.g:5104:3: 
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
    // InternalOptimisationLanguage.g:5112:1: rule__VoidTypeRule__Group__1 : rule__VoidTypeRule__Group__1__Impl ;
    public final void rule__VoidTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5116:1: ( rule__VoidTypeRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:5117:2: rule__VoidTypeRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:5123:1: rule__VoidTypeRule__Group__1__Impl : ( 'void' ) ;
    public final void rule__VoidTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5127:1: ( ( 'void' ) )
            // InternalOptimisationLanguage.g:5128:1: ( 'void' )
            {
            // InternalOptimisationLanguage.g:5128:1: ( 'void' )
            // InternalOptimisationLanguage.g:5129:2: 'void'
            {
             before(grammarAccess.getVoidTypeRuleAccess().getVoidKeyword_1()); 
            match(input,79,FOLLOW_2); 
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
    // InternalOptimisationLanguage.g:5139:1: rule__DataTypeRule__Group__0 : rule__DataTypeRule__Group__0__Impl rule__DataTypeRule__Group__1 ;
    public final void rule__DataTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5143:1: ( rule__DataTypeRule__Group__0__Impl rule__DataTypeRule__Group__1 )
            // InternalOptimisationLanguage.g:5144:2: rule__DataTypeRule__Group__0__Impl rule__DataTypeRule__Group__1
            {
            pushFollow(FOLLOW_43);
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
    // InternalOptimisationLanguage.g:5151:1: rule__DataTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__DataTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5155:1: ( ( () ) )
            // InternalOptimisationLanguage.g:5156:1: ( () )
            {
            // InternalOptimisationLanguage.g:5156:1: ( () )
            // InternalOptimisationLanguage.g:5157:2: ()
            {
             before(grammarAccess.getDataTypeRuleAccess().getDataTypeAction_0()); 
            // InternalOptimisationLanguage.g:5158:2: ()
            // InternalOptimisationLanguage.g:5158:3: 
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
    // InternalOptimisationLanguage.g:5166:1: rule__DataTypeRule__Group__1 : rule__DataTypeRule__Group__1__Impl ;
    public final void rule__DataTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5170:1: ( rule__DataTypeRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:5171:2: rule__DataTypeRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:5177:1: rule__DataTypeRule__Group__1__Impl : ( 'data' ) ;
    public final void rule__DataTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5181:1: ( ( 'data' ) )
            // InternalOptimisationLanguage.g:5182:1: ( 'data' )
            {
            // InternalOptimisationLanguage.g:5182:1: ( 'data' )
            // InternalOptimisationLanguage.g:5183:2: 'data'
            {
             before(grammarAccess.getDataTypeRuleAccess().getDataKeyword_1()); 
            match(input,62,FOLLOW_2); 
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
    // InternalOptimisationLanguage.g:5193:1: rule__ArrayTypeRule__Group__0 : rule__ArrayTypeRule__Group__0__Impl rule__ArrayTypeRule__Group__1 ;
    public final void rule__ArrayTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5197:1: ( rule__ArrayTypeRule__Group__0__Impl rule__ArrayTypeRule__Group__1 )
            // InternalOptimisationLanguage.g:5198:2: rule__ArrayTypeRule__Group__0__Impl rule__ArrayTypeRule__Group__1
            {
            pushFollow(FOLLOW_43);
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
    // InternalOptimisationLanguage.g:5205:1: rule__ArrayTypeRule__Group__0__Impl : ( 'array' ) ;
    public final void rule__ArrayTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5209:1: ( ( 'array' ) )
            // InternalOptimisationLanguage.g:5210:1: ( 'array' )
            {
            // InternalOptimisationLanguage.g:5210:1: ( 'array' )
            // InternalOptimisationLanguage.g:5211:2: 'array'
            {
             before(grammarAccess.getArrayTypeRuleAccess().getArrayKeyword_0()); 
            match(input,80,FOLLOW_2); 
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
    // InternalOptimisationLanguage.g:5220:1: rule__ArrayTypeRule__Group__1 : rule__ArrayTypeRule__Group__1__Impl ;
    public final void rule__ArrayTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5224:1: ( rule__ArrayTypeRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:5225:2: rule__ArrayTypeRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:5231:1: rule__ArrayTypeRule__Group__1__Impl : ( ( rule__ArrayTypeRule__ElementsAssignment_1 ) ) ;
    public final void rule__ArrayTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5235:1: ( ( ( rule__ArrayTypeRule__ElementsAssignment_1 ) ) )
            // InternalOptimisationLanguage.g:5236:1: ( ( rule__ArrayTypeRule__ElementsAssignment_1 ) )
            {
            // InternalOptimisationLanguage.g:5236:1: ( ( rule__ArrayTypeRule__ElementsAssignment_1 ) )
            // InternalOptimisationLanguage.g:5237:2: ( rule__ArrayTypeRule__ElementsAssignment_1 )
            {
             before(grammarAccess.getArrayTypeRuleAccess().getElementsAssignment_1()); 
            // InternalOptimisationLanguage.g:5238:2: ( rule__ArrayTypeRule__ElementsAssignment_1 )
            // InternalOptimisationLanguage.g:5238:3: rule__ArrayTypeRule__ElementsAssignment_1
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
    // InternalOptimisationLanguage.g:5247:1: rule__ParameterRule__Group__0 : rule__ParameterRule__Group__0__Impl rule__ParameterRule__Group__1 ;
    public final void rule__ParameterRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5251:1: ( rule__ParameterRule__Group__0__Impl rule__ParameterRule__Group__1 )
            // InternalOptimisationLanguage.g:5252:2: rule__ParameterRule__Group__0__Impl rule__ParameterRule__Group__1
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
    // InternalOptimisationLanguage.g:5259:1: rule__ParameterRule__Group__0__Impl : ( ( rule__ParameterRule__TypeAssignment_0 ) ) ;
    public final void rule__ParameterRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5263:1: ( ( ( rule__ParameterRule__TypeAssignment_0 ) ) )
            // InternalOptimisationLanguage.g:5264:1: ( ( rule__ParameterRule__TypeAssignment_0 ) )
            {
            // InternalOptimisationLanguage.g:5264:1: ( ( rule__ParameterRule__TypeAssignment_0 ) )
            // InternalOptimisationLanguage.g:5265:2: ( rule__ParameterRule__TypeAssignment_0 )
            {
             before(grammarAccess.getParameterRuleAccess().getTypeAssignment_0()); 
            // InternalOptimisationLanguage.g:5266:2: ( rule__ParameterRule__TypeAssignment_0 )
            // InternalOptimisationLanguage.g:5266:3: rule__ParameterRule__TypeAssignment_0
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
    // InternalOptimisationLanguage.g:5274:1: rule__ParameterRule__Group__1 : rule__ParameterRule__Group__1__Impl ;
    public final void rule__ParameterRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5278:1: ( rule__ParameterRule__Group__1__Impl )
            // InternalOptimisationLanguage.g:5279:2: rule__ParameterRule__Group__1__Impl
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
    // InternalOptimisationLanguage.g:5285:1: rule__ParameterRule__Group__1__Impl : ( ( rule__ParameterRule__NameAssignment_1 ) ) ;
    public final void rule__ParameterRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5289:1: ( ( ( rule__ParameterRule__NameAssignment_1 ) ) )
            // InternalOptimisationLanguage.g:5290:1: ( ( rule__ParameterRule__NameAssignment_1 ) )
            {
            // InternalOptimisationLanguage.g:5290:1: ( ( rule__ParameterRule__NameAssignment_1 ) )
            // InternalOptimisationLanguage.g:5291:2: ( rule__ParameterRule__NameAssignment_1 )
            {
             before(grammarAccess.getParameterRuleAccess().getNameAssignment_1()); 
            // InternalOptimisationLanguage.g:5292:2: ( rule__ParameterRule__NameAssignment_1 )
            // InternalOptimisationLanguage.g:5292:3: rule__ParameterRule__NameAssignment_1
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
    // InternalOptimisationLanguage.g:5301:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5305:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // InternalOptimisationLanguage.g:5306:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_22);
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
    // InternalOptimisationLanguage.g:5313:1: rule__QualifiedName__Group__0__Impl : ( ruleStringOrId ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5317:1: ( ( ruleStringOrId ) )
            // InternalOptimisationLanguage.g:5318:1: ( ruleStringOrId )
            {
            // InternalOptimisationLanguage.g:5318:1: ( ruleStringOrId )
            // InternalOptimisationLanguage.g:5319:2: ruleStringOrId
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
    // InternalOptimisationLanguage.g:5328:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5332:1: ( rule__QualifiedName__Group__1__Impl )
            // InternalOptimisationLanguage.g:5333:2: rule__QualifiedName__Group__1__Impl
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
    // InternalOptimisationLanguage.g:5339:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5343:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // InternalOptimisationLanguage.g:5344:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // InternalOptimisationLanguage.g:5344:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // InternalOptimisationLanguage.g:5345:2: ( rule__QualifiedName__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // InternalOptimisationLanguage.g:5346:2: ( rule__QualifiedName__Group_1__0 )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==63) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:5346:3: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_23);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop36;
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
    // InternalOptimisationLanguage.g:5355:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5359:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // InternalOptimisationLanguage.g:5360:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
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
    // InternalOptimisationLanguage.g:5367:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5371:1: ( ( '.' ) )
            // InternalOptimisationLanguage.g:5372:1: ( '.' )
            {
            // InternalOptimisationLanguage.g:5372:1: ( '.' )
            // InternalOptimisationLanguage.g:5373:2: '.'
            {
             before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            match(input,63,FOLLOW_2); 
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
    // InternalOptimisationLanguage.g:5382:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5386:1: ( rule__QualifiedName__Group_1__1__Impl )
            // InternalOptimisationLanguage.g:5387:2: rule__QualifiedName__Group_1__1__Impl
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
    // InternalOptimisationLanguage.g:5393:1: rule__QualifiedName__Group_1__1__Impl : ( ruleStringOrId ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5397:1: ( ( ruleStringOrId ) )
            // InternalOptimisationLanguage.g:5398:1: ( ruleStringOrId )
            {
            // InternalOptimisationLanguage.g:5398:1: ( ruleStringOrId )
            // InternalOptimisationLanguage.g:5399:2: ruleStringOrId
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


    // $ANTLR start "rule__OptimisationModelRule__ImportsAssignment_0"
    // InternalOptimisationLanguage.g:5409:1: rule__OptimisationModelRule__ImportsAssignment_0 : ( ruleImportRule ) ;
    public final void rule__OptimisationModelRule__ImportsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5413:1: ( ( ruleImportRule ) )
            // InternalOptimisationLanguage.g:5414:2: ( ruleImportRule )
            {
            // InternalOptimisationLanguage.g:5414:2: ( ruleImportRule )
            // InternalOptimisationLanguage.g:5415:3: ruleImportRule
            {
             before(grammarAccess.getOptimisationModelRuleAccess().getImportsImportRuleParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleImportRule();

            state._fsp--;

             after(grammarAccess.getOptimisationModelRuleAccess().getImportsImportRuleParserRuleCall_0_0()); 

            }


            }

        }
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


    // $ANTLR start "rule__OptimisationModelRule__ProblemAssignment_1"
    // InternalOptimisationLanguage.g:5424:1: rule__OptimisationModelRule__ProblemAssignment_1 : ( ruleProblemRule ) ;
    public final void rule__OptimisationModelRule__ProblemAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5428:1: ( ( ruleProblemRule ) )
            // InternalOptimisationLanguage.g:5429:2: ( ruleProblemRule )
            {
            // InternalOptimisationLanguage.g:5429:2: ( ruleProblemRule )
            // InternalOptimisationLanguage.g:5430:3: ruleProblemRule
            {
             before(grammarAccess.getOptimisationModelRuleAccess().getProblemProblemRuleParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleProblemRule();

            state._fsp--;

             after(grammarAccess.getOptimisationModelRuleAccess().getProblemProblemRuleParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OptimisationModelRule__ProblemAssignment_1"


    // $ANTLR start "rule__OptimisationModelRule__AlgorithmAssignment_2"
    // InternalOptimisationLanguage.g:5439:1: rule__OptimisationModelRule__AlgorithmAssignment_2 : ( ruleAlgorithmInstanceRule ) ;
    public final void rule__OptimisationModelRule__AlgorithmAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5443:1: ( ( ruleAlgorithmInstanceRule ) )
            // InternalOptimisationLanguage.g:5444:2: ( ruleAlgorithmInstanceRule )
            {
            // InternalOptimisationLanguage.g:5444:2: ( ruleAlgorithmInstanceRule )
            // InternalOptimisationLanguage.g:5445:3: ruleAlgorithmInstanceRule
            {
             before(grammarAccess.getOptimisationModelRuleAccess().getAlgorithmAlgorithmInstanceRuleParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleAlgorithmInstanceRule();

            state._fsp--;

             after(grammarAccess.getOptimisationModelRuleAccess().getAlgorithmAlgorithmInstanceRuleParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OptimisationModelRule__AlgorithmAssignment_2"


    // $ANTLR start "rule__ImportRule__ImportedNamespaceAssignment_1"
    // InternalOptimisationLanguage.g:5454:1: rule__ImportRule__ImportedNamespaceAssignment_1 : ( ruleQualifiedNameRule ) ;
    public final void rule__ImportRule__ImportedNamespaceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5458:1: ( ( ruleQualifiedNameRule ) )
            // InternalOptimisationLanguage.g:5459:2: ( ruleQualifiedNameRule )
            {
            // InternalOptimisationLanguage.g:5459:2: ( ruleQualifiedNameRule )
            // InternalOptimisationLanguage.g:5460:3: ruleQualifiedNameRule
            {
             before(grammarAccess.getImportRuleAccess().getImportedNamespaceQualifiedNameRuleParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedNameRule();

            state._fsp--;

             after(grammarAccess.getImportRuleAccess().getImportedNamespaceQualifiedNameRuleParserRuleCall_1_0()); 

            }


            }

        }
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


    // $ANTLR start "rule__ProblemRule__NameAssignment_1"
    // InternalOptimisationLanguage.g:5469:1: rule__ProblemRule__NameAssignment_1 : ( ruleStringOrId ) ;
    public final void rule__ProblemRule__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5473:1: ( ( ruleStringOrId ) )
            // InternalOptimisationLanguage.g:5474:2: ( ruleStringOrId )
            {
            // InternalOptimisationLanguage.g:5474:2: ( ruleStringOrId )
            // InternalOptimisationLanguage.g:5475:3: ruleStringOrId
            {
             before(grammarAccess.getProblemRuleAccess().getNameStringOrIdParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleStringOrId();

            state._fsp--;

             after(grammarAccess.getProblemRuleAccess().getNameStringOrIdParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemRule__NameAssignment_1"


    // $ANTLR start "rule__ProblemRule__ProblemAssignment_3"
    // InternalOptimisationLanguage.g:5484:1: rule__ProblemRule__ProblemAssignment_3 : ( ruleInstanceRule ) ;
    public final void rule__ProblemRule__ProblemAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5488:1: ( ( ruleInstanceRule ) )
            // InternalOptimisationLanguage.g:5489:2: ( ruleInstanceRule )
            {
            // InternalOptimisationLanguage.g:5489:2: ( ruleInstanceRule )
            // InternalOptimisationLanguage.g:5490:3: ruleInstanceRule
            {
             before(grammarAccess.getProblemRuleAccess().getProblemInstanceRuleParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleInstanceRule();

            state._fsp--;

             after(grammarAccess.getProblemRuleAccess().getProblemInstanceRuleParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemRule__ProblemAssignment_3"


    // $ANTLR start "rule__ProblemRule__DocumentationAssignment_4_2"
    // InternalOptimisationLanguage.g:5499:1: rule__ProblemRule__DocumentationAssignment_4_2 : ( ruleArrayRule ) ;
    public final void rule__ProblemRule__DocumentationAssignment_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5503:1: ( ( ruleArrayRule ) )
            // InternalOptimisationLanguage.g:5504:2: ( ruleArrayRule )
            {
            // InternalOptimisationLanguage.g:5504:2: ( ruleArrayRule )
            // InternalOptimisationLanguage.g:5505:3: ruleArrayRule
            {
             before(grammarAccess.getProblemRuleAccess().getDocumentationArrayRuleParserRuleCall_4_2_0()); 
            pushFollow(FOLLOW_2);
            ruleArrayRule();

            state._fsp--;

             after(grammarAccess.getProblemRuleAccess().getDocumentationArrayRuleParserRuleCall_4_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemRule__DocumentationAssignment_4_2"


    // $ANTLR start "rule__AlgorithmInstanceRule__ProblemAssignment_2"
    // InternalOptimisationLanguage.g:5514:1: rule__AlgorithmInstanceRule__ProblemAssignment_2 : ( ( ruleQualifiedNameRule ) ) ;
    public final void rule__AlgorithmInstanceRule__ProblemAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5518:1: ( ( ( ruleQualifiedNameRule ) ) )
            // InternalOptimisationLanguage.g:5519:2: ( ( ruleQualifiedNameRule ) )
            {
            // InternalOptimisationLanguage.g:5519:2: ( ( ruleQualifiedNameRule ) )
            // InternalOptimisationLanguage.g:5520:3: ( ruleQualifiedNameRule )
            {
             before(grammarAccess.getAlgorithmInstanceRuleAccess().getProblemProblemCrossReference_2_0()); 
            // InternalOptimisationLanguage.g:5521:3: ( ruleQualifiedNameRule )
            // InternalOptimisationLanguage.g:5522:4: ruleQualifiedNameRule
            {
             before(grammarAccess.getAlgorithmInstanceRuleAccess().getProblemProblemQualifiedNameRuleParserRuleCall_2_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedNameRule();

            state._fsp--;

             after(grammarAccess.getAlgorithmInstanceRuleAccess().getProblemProblemQualifiedNameRuleParserRuleCall_2_0_1()); 

            }

             after(grammarAccess.getAlgorithmInstanceRuleAccess().getProblemProblemCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlgorithmInstanceRule__ProblemAssignment_2"


    // $ANTLR start "rule__AlgorithmInstanceRule__AlgorithmAssignment_5"
    // InternalOptimisationLanguage.g:5533:1: rule__AlgorithmInstanceRule__AlgorithmAssignment_5 : ( ruleInstanceRule ) ;
    public final void rule__AlgorithmInstanceRule__AlgorithmAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5537:1: ( ( ruleInstanceRule ) )
            // InternalOptimisationLanguage.g:5538:2: ( ruleInstanceRule )
            {
            // InternalOptimisationLanguage.g:5538:2: ( ruleInstanceRule )
            // InternalOptimisationLanguage.g:5539:3: ruleInstanceRule
            {
             before(grammarAccess.getAlgorithmInstanceRuleAccess().getAlgorithmInstanceRuleParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleInstanceRule();

            state._fsp--;

             after(grammarAccess.getAlgorithmInstanceRuleAccess().getAlgorithmInstanceRuleParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlgorithmInstanceRule__AlgorithmAssignment_5"


    // $ANTLR start "rule__AlgorithmInstanceRule__DocumentationAssignment_6_2"
    // InternalOptimisationLanguage.g:5548:1: rule__AlgorithmInstanceRule__DocumentationAssignment_6_2 : ( ruleArrayRule ) ;
    public final void rule__AlgorithmInstanceRule__DocumentationAssignment_6_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5552:1: ( ( ruleArrayRule ) )
            // InternalOptimisationLanguage.g:5553:2: ( ruleArrayRule )
            {
            // InternalOptimisationLanguage.g:5553:2: ( ruleArrayRule )
            // InternalOptimisationLanguage.g:5554:3: ruleArrayRule
            {
             before(grammarAccess.getAlgorithmInstanceRuleAccess().getDocumentationArrayRuleParserRuleCall_6_2_0()); 
            pushFollow(FOLLOW_2);
            ruleArrayRule();

            state._fsp--;

             after(grammarAccess.getAlgorithmInstanceRuleAccess().getDocumentationArrayRuleParserRuleCall_6_2_0()); 

            }


            }

        }
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


    // $ANTLR start "rule__InstanceRule__DefinitionAssignment_0"
    // InternalOptimisationLanguage.g:5563:1: rule__InstanceRule__DefinitionAssignment_0 : ( ( ruleQualifiedNameRule ) ) ;
    public final void rule__InstanceRule__DefinitionAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5567:1: ( ( ( ruleQualifiedNameRule ) ) )
            // InternalOptimisationLanguage.g:5568:2: ( ( ruleQualifiedNameRule ) )
            {
            // InternalOptimisationLanguage.g:5568:2: ( ( ruleQualifiedNameRule ) )
            // InternalOptimisationLanguage.g:5569:3: ( ruleQualifiedNameRule )
            {
             before(grammarAccess.getInstanceRuleAccess().getDefinitionTypeDefinitionCrossReference_0_0()); 
            // InternalOptimisationLanguage.g:5570:3: ( ruleQualifiedNameRule )
            // InternalOptimisationLanguage.g:5571:4: ruleQualifiedNameRule
            {
             before(grammarAccess.getInstanceRuleAccess().getDefinitionTypeDefinitionQualifiedNameRuleParserRuleCall_0_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedNameRule();

            state._fsp--;

             after(grammarAccess.getInstanceRuleAccess().getDefinitionTypeDefinitionQualifiedNameRuleParserRuleCall_0_0_1()); 

            }

             after(grammarAccess.getInstanceRuleAccess().getDefinitionTypeDefinitionCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceRule__DefinitionAssignment_0"


    // $ANTLR start "rule__InstanceRule__AttributesAssignment_1_1"
    // InternalOptimisationLanguage.g:5582:1: rule__InstanceRule__AttributesAssignment_1_1 : ( ruleAttributeRule ) ;
    public final void rule__InstanceRule__AttributesAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5586:1: ( ( ruleAttributeRule ) )
            // InternalOptimisationLanguage.g:5587:2: ( ruleAttributeRule )
            {
            // InternalOptimisationLanguage.g:5587:2: ( ruleAttributeRule )
            // InternalOptimisationLanguage.g:5588:3: ruleAttributeRule
            {
             before(grammarAccess.getInstanceRuleAccess().getAttributesAttributeRuleParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleAttributeRule();

            state._fsp--;

             after(grammarAccess.getInstanceRuleAccess().getAttributesAttributeRuleParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceRule__AttributesAssignment_1_1"


    // $ANTLR start "rule__AttributeRule__DefinitionAssignment_0"
    // InternalOptimisationLanguage.g:5597:1: rule__AttributeRule__DefinitionAssignment_0 : ( ( ruleStringOrId ) ) ;
    public final void rule__AttributeRule__DefinitionAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5601:1: ( ( ( ruleStringOrId ) ) )
            // InternalOptimisationLanguage.g:5602:2: ( ( ruleStringOrId ) )
            {
            // InternalOptimisationLanguage.g:5602:2: ( ( ruleStringOrId ) )
            // InternalOptimisationLanguage.g:5603:3: ( ruleStringOrId )
            {
             before(grammarAccess.getAttributeRuleAccess().getDefinitionAttributeDefinitionCrossReference_0_0()); 
            // InternalOptimisationLanguage.g:5604:3: ( ruleStringOrId )
            // InternalOptimisationLanguage.g:5605:4: ruleStringOrId
            {
             before(grammarAccess.getAttributeRuleAccess().getDefinitionAttributeDefinitionStringOrIdParserRuleCall_0_0_1()); 
            pushFollow(FOLLOW_2);
            ruleStringOrId();

            state._fsp--;

             after(grammarAccess.getAttributeRuleAccess().getDefinitionAttributeDefinitionStringOrIdParserRuleCall_0_0_1()); 

            }

             after(grammarAccess.getAttributeRuleAccess().getDefinitionAttributeDefinitionCrossReference_0_0()); 

            }


            }

        }
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
    // InternalOptimisationLanguage.g:5616:1: rule__AttributeRule__ValueAssignment_2 : ( ruleValueRule ) ;
    public final void rule__AttributeRule__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5620:1: ( ( ruleValueRule ) )
            // InternalOptimisationLanguage.g:5621:2: ( ruleValueRule )
            {
            // InternalOptimisationLanguage.g:5621:2: ( ruleValueRule )
            // InternalOptimisationLanguage.g:5622:3: ruleValueRule
            {
             before(grammarAccess.getAttributeRuleAccess().getValueValueRuleParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleValueRule();

            state._fsp--;

             after(grammarAccess.getAttributeRuleAccess().getValueValueRuleParserRuleCall_2_0()); 

            }


            }

        }
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


    // $ANTLR start "rule__ArrayRule__ValuesAssignment_2_0"
    // InternalOptimisationLanguage.g:5631:1: rule__ArrayRule__ValuesAssignment_2_0 : ( ruleValueRule ) ;
    public final void rule__ArrayRule__ValuesAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5635:1: ( ( ruleValueRule ) )
            // InternalOptimisationLanguage.g:5636:2: ( ruleValueRule )
            {
            // InternalOptimisationLanguage.g:5636:2: ( ruleValueRule )
            // InternalOptimisationLanguage.g:5637:3: ruleValueRule
            {
             before(grammarAccess.getArrayRuleAccess().getValuesValueRuleParserRuleCall_2_0_0()); 
            pushFollow(FOLLOW_2);
            ruleValueRule();

            state._fsp--;

             after(grammarAccess.getArrayRuleAccess().getValuesValueRuleParserRuleCall_2_0_0()); 

            }


            }

        }
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
    // InternalOptimisationLanguage.g:5646:1: rule__ArrayRule__ValuesAssignment_2_1_1 : ( ruleValueRule ) ;
    public final void rule__ArrayRule__ValuesAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5650:1: ( ( ruleValueRule ) )
            // InternalOptimisationLanguage.g:5651:2: ( ruleValueRule )
            {
            // InternalOptimisationLanguage.g:5651:2: ( ruleValueRule )
            // InternalOptimisationLanguage.g:5652:3: ruleValueRule
            {
             before(grammarAccess.getArrayRuleAccess().getValuesValueRuleParserRuleCall_2_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleValueRule();

            state._fsp--;

             after(grammarAccess.getArrayRuleAccess().getValuesValueRuleParserRuleCall_2_1_1_0()); 

            }


            }

        }
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


    // $ANTLR start "rule__LiteralValueRule__LiteralAssignment"
    // InternalOptimisationLanguage.g:5661:1: rule__LiteralValueRule__LiteralAssignment : ( ruleLiteralRule ) ;
    public final void rule__LiteralValueRule__LiteralAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5665:1: ( ( ruleLiteralRule ) )
            // InternalOptimisationLanguage.g:5666:2: ( ruleLiteralRule )
            {
            // InternalOptimisationLanguage.g:5666:2: ( ruleLiteralRule )
            // InternalOptimisationLanguage.g:5667:3: ruleLiteralRule
            {
             before(grammarAccess.getLiteralValueRuleAccess().getLiteralLiteralRuleParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleLiteralRule();

            state._fsp--;

             after(grammarAccess.getLiteralValueRuleAccess().getLiteralLiteralRuleParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LiteralValueRule__LiteralAssignment"


    // $ANTLR start "rule__DataReferenceRule__DefinitionAssignment_2"
    // InternalOptimisationLanguage.g:5676:1: rule__DataReferenceRule__DefinitionAssignment_2 : ( ( ruleStringOrId ) ) ;
    public final void rule__DataReferenceRule__DefinitionAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5680:1: ( ( ( ruleStringOrId ) ) )
            // InternalOptimisationLanguage.g:5681:2: ( ( ruleStringOrId ) )
            {
            // InternalOptimisationLanguage.g:5681:2: ( ( ruleStringOrId ) )
            // InternalOptimisationLanguage.g:5682:3: ( ruleStringOrId )
            {
             before(grammarAccess.getDataReferenceRuleAccess().getDefinitionDataDescriptionCrossReference_2_0()); 
            // InternalOptimisationLanguage.g:5683:3: ( ruleStringOrId )
            // InternalOptimisationLanguage.g:5684:4: ruleStringOrId
            {
             before(grammarAccess.getDataReferenceRuleAccess().getDefinitionDataDescriptionStringOrIdParserRuleCall_2_0_1()); 
            pushFollow(FOLLOW_2);
            ruleStringOrId();

            state._fsp--;

             after(grammarAccess.getDataReferenceRuleAccess().getDefinitionDataDescriptionStringOrIdParserRuleCall_2_0_1()); 

            }

             after(grammarAccess.getDataReferenceRuleAccess().getDefinitionDataDescriptionCrossReference_2_0()); 

            }


            }

        }
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
    // InternalOptimisationLanguage.g:5695:1: rule__OrExpressionRule__SubExpressionsAssignment_0 : ( ruleXorExpressionRule ) ;
    public final void rule__OrExpressionRule__SubExpressionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5699:1: ( ( ruleXorExpressionRule ) )
            // InternalOptimisationLanguage.g:5700:2: ( ruleXorExpressionRule )
            {
            // InternalOptimisationLanguage.g:5700:2: ( ruleXorExpressionRule )
            // InternalOptimisationLanguage.g:5701:3: ruleXorExpressionRule
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
    // InternalOptimisationLanguage.g:5710:1: rule__OrExpressionRule__SubExpressionsAssignment_1_1 : ( ruleXorExpressionRule ) ;
    public final void rule__OrExpressionRule__SubExpressionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5714:1: ( ( ruleXorExpressionRule ) )
            // InternalOptimisationLanguage.g:5715:2: ( ruleXorExpressionRule )
            {
            // InternalOptimisationLanguage.g:5715:2: ( ruleXorExpressionRule )
            // InternalOptimisationLanguage.g:5716:3: ruleXorExpressionRule
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
    // InternalOptimisationLanguage.g:5725:1: rule__XorExpressionRule__SubExpressionsAssignment_0 : ( ruleAndExpressionRule ) ;
    public final void rule__XorExpressionRule__SubExpressionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5729:1: ( ( ruleAndExpressionRule ) )
            // InternalOptimisationLanguage.g:5730:2: ( ruleAndExpressionRule )
            {
            // InternalOptimisationLanguage.g:5730:2: ( ruleAndExpressionRule )
            // InternalOptimisationLanguage.g:5731:3: ruleAndExpressionRule
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
    // InternalOptimisationLanguage.g:5740:1: rule__XorExpressionRule__SubExpressionsAssignment_1_1 : ( ruleAndExpressionRule ) ;
    public final void rule__XorExpressionRule__SubExpressionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5744:1: ( ( ruleAndExpressionRule ) )
            // InternalOptimisationLanguage.g:5745:2: ( ruleAndExpressionRule )
            {
            // InternalOptimisationLanguage.g:5745:2: ( ruleAndExpressionRule )
            // InternalOptimisationLanguage.g:5746:3: ruleAndExpressionRule
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
    // InternalOptimisationLanguage.g:5755:1: rule__AndExpressionRule__SubExpressionsAssignment_0 : ( ruleNotExpressionRule ) ;
    public final void rule__AndExpressionRule__SubExpressionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5759:1: ( ( ruleNotExpressionRule ) )
            // InternalOptimisationLanguage.g:5760:2: ( ruleNotExpressionRule )
            {
            // InternalOptimisationLanguage.g:5760:2: ( ruleNotExpressionRule )
            // InternalOptimisationLanguage.g:5761:3: ruleNotExpressionRule
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
    // InternalOptimisationLanguage.g:5770:1: rule__AndExpressionRule__SubExpressionsAssignment_1_1 : ( ruleNotExpressionRule ) ;
    public final void rule__AndExpressionRule__SubExpressionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5774:1: ( ( ruleNotExpressionRule ) )
            // InternalOptimisationLanguage.g:5775:2: ( ruleNotExpressionRule )
            {
            // InternalOptimisationLanguage.g:5775:2: ( ruleNotExpressionRule )
            // InternalOptimisationLanguage.g:5776:3: ruleNotExpressionRule
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
    // InternalOptimisationLanguage.g:5785:1: rule__NotExpressionRule__NegatedAssignment_0 : ( ( '!' ) ) ;
    public final void rule__NotExpressionRule__NegatedAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5789:1: ( ( ( '!' ) ) )
            // InternalOptimisationLanguage.g:5790:2: ( ( '!' ) )
            {
            // InternalOptimisationLanguage.g:5790:2: ( ( '!' ) )
            // InternalOptimisationLanguage.g:5791:3: ( '!' )
            {
             before(grammarAccess.getNotExpressionRuleAccess().getNegatedExclamationMarkKeyword_0_0()); 
            // InternalOptimisationLanguage.g:5792:3: ( '!' )
            // InternalOptimisationLanguage.g:5793:4: '!'
            {
             before(grammarAccess.getNotExpressionRuleAccess().getNegatedExclamationMarkKeyword_0_0()); 
            match(input,81,FOLLOW_2); 
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
    // InternalOptimisationLanguage.g:5804:1: rule__NotExpressionRule__OperandAssignment_1 : ( ruleComparisonExpressionRule ) ;
    public final void rule__NotExpressionRule__OperandAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5808:1: ( ( ruleComparisonExpressionRule ) )
            // InternalOptimisationLanguage.g:5809:2: ( ruleComparisonExpressionRule )
            {
            // InternalOptimisationLanguage.g:5809:2: ( ruleComparisonExpressionRule )
            // InternalOptimisationLanguage.g:5810:3: ruleComparisonExpressionRule
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
    // InternalOptimisationLanguage.g:5819:1: rule__ComparisonExpressionRule__LeftOperandAssignment_0 : ( ruleAddOrSubtractExpressionRule ) ;
    public final void rule__ComparisonExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5823:1: ( ( ruleAddOrSubtractExpressionRule ) )
            // InternalOptimisationLanguage.g:5824:2: ( ruleAddOrSubtractExpressionRule )
            {
            // InternalOptimisationLanguage.g:5824:2: ( ruleAddOrSubtractExpressionRule )
            // InternalOptimisationLanguage.g:5825:3: ruleAddOrSubtractExpressionRule
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
    // InternalOptimisationLanguage.g:5834:1: rule__ComparisonExpressionRule__ComparisonAssignment_1 : ( rulePartialComparisonExpressionRule ) ;
    public final void rule__ComparisonExpressionRule__ComparisonAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5838:1: ( ( rulePartialComparisonExpressionRule ) )
            // InternalOptimisationLanguage.g:5839:2: ( rulePartialComparisonExpressionRule )
            {
            // InternalOptimisationLanguage.g:5839:2: ( rulePartialComparisonExpressionRule )
            // InternalOptimisationLanguage.g:5840:3: rulePartialComparisonExpressionRule
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
    // InternalOptimisationLanguage.g:5849:1: rule__PartialComparisonExpressionRule__OperatorAssignment_0 : ( ruleComparisonOperatorRule ) ;
    public final void rule__PartialComparisonExpressionRule__OperatorAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5853:1: ( ( ruleComparisonOperatorRule ) )
            // InternalOptimisationLanguage.g:5854:2: ( ruleComparisonOperatorRule )
            {
            // InternalOptimisationLanguage.g:5854:2: ( ruleComparisonOperatorRule )
            // InternalOptimisationLanguage.g:5855:3: ruleComparisonOperatorRule
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
    // InternalOptimisationLanguage.g:5864:1: rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 : ( ruleAddOrSubtractExpressionRule ) ;
    public final void rule__PartialComparisonExpressionRule__SubExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5868:1: ( ( ruleAddOrSubtractExpressionRule ) )
            // InternalOptimisationLanguage.g:5869:2: ( ruleAddOrSubtractExpressionRule )
            {
            // InternalOptimisationLanguage.g:5869:2: ( ruleAddOrSubtractExpressionRule )
            // InternalOptimisationLanguage.g:5870:3: ruleAddOrSubtractExpressionRule
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
    // InternalOptimisationLanguage.g:5879:1: rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 : ( ruleMultiplyDivideModuloExpressionRule ) ;
    public final void rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5883:1: ( ( ruleMultiplyDivideModuloExpressionRule ) )
            // InternalOptimisationLanguage.g:5884:2: ( ruleMultiplyDivideModuloExpressionRule )
            {
            // InternalOptimisationLanguage.g:5884:2: ( ruleMultiplyDivideModuloExpressionRule )
            // InternalOptimisationLanguage.g:5885:3: ruleMultiplyDivideModuloExpressionRule
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
    // InternalOptimisationLanguage.g:5894:1: rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 : ( ruleAddOrSubtractOperatorRule ) ;
    public final void rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5898:1: ( ( ruleAddOrSubtractOperatorRule ) )
            // InternalOptimisationLanguage.g:5899:2: ( ruleAddOrSubtractOperatorRule )
            {
            // InternalOptimisationLanguage.g:5899:2: ( ruleAddOrSubtractOperatorRule )
            // InternalOptimisationLanguage.g:5900:3: ruleAddOrSubtractOperatorRule
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
    // InternalOptimisationLanguage.g:5909:1: rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 : ( ruleMultiplyDivideModuloExpressionRule ) ;
    public final void rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5913:1: ( ( ruleMultiplyDivideModuloExpressionRule ) )
            // InternalOptimisationLanguage.g:5914:2: ( ruleMultiplyDivideModuloExpressionRule )
            {
            // InternalOptimisationLanguage.g:5914:2: ( ruleMultiplyDivideModuloExpressionRule )
            // InternalOptimisationLanguage.g:5915:3: ruleMultiplyDivideModuloExpressionRule
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
    // InternalOptimisationLanguage.g:5924:1: rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 : ( rulePowerOfExpressionRule ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5928:1: ( ( rulePowerOfExpressionRule ) )
            // InternalOptimisationLanguage.g:5929:2: ( rulePowerOfExpressionRule )
            {
            // InternalOptimisationLanguage.g:5929:2: ( rulePowerOfExpressionRule )
            // InternalOptimisationLanguage.g:5930:3: rulePowerOfExpressionRule
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
    // InternalOptimisationLanguage.g:5939:1: rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 : ( ruleMultiplyDivideModuloOperatorRule ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5943:1: ( ( ruleMultiplyDivideModuloOperatorRule ) )
            // InternalOptimisationLanguage.g:5944:2: ( ruleMultiplyDivideModuloOperatorRule )
            {
            // InternalOptimisationLanguage.g:5944:2: ( ruleMultiplyDivideModuloOperatorRule )
            // InternalOptimisationLanguage.g:5945:3: ruleMultiplyDivideModuloOperatorRule
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
    // InternalOptimisationLanguage.g:5954:1: rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 : ( rulePowerOfExpressionRule ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5958:1: ( ( rulePowerOfExpressionRule ) )
            // InternalOptimisationLanguage.g:5959:2: ( rulePowerOfExpressionRule )
            {
            // InternalOptimisationLanguage.g:5959:2: ( rulePowerOfExpressionRule )
            // InternalOptimisationLanguage.g:5960:3: rulePowerOfExpressionRule
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
    // InternalOptimisationLanguage.g:5969:1: rule__PowerOfExpressionRule__LeftOperandAssignment_0 : ( ruleUnaryAddOrSubtractExpressionRule ) ;
    public final void rule__PowerOfExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5973:1: ( ( ruleUnaryAddOrSubtractExpressionRule ) )
            // InternalOptimisationLanguage.g:5974:2: ( ruleUnaryAddOrSubtractExpressionRule )
            {
            // InternalOptimisationLanguage.g:5974:2: ( ruleUnaryAddOrSubtractExpressionRule )
            // InternalOptimisationLanguage.g:5975:3: ruleUnaryAddOrSubtractExpressionRule
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
    // InternalOptimisationLanguage.g:5984:1: rule__PowerOfExpressionRule__RightOperandAssignment_1_1 : ( rulePowerOfExpressionRule ) ;
    public final void rule__PowerOfExpressionRule__RightOperandAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:5988:1: ( ( rulePowerOfExpressionRule ) )
            // InternalOptimisationLanguage.g:5989:2: ( rulePowerOfExpressionRule )
            {
            // InternalOptimisationLanguage.g:5989:2: ( rulePowerOfExpressionRule )
            // InternalOptimisationLanguage.g:5990:3: rulePowerOfExpressionRule
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
    // InternalOptimisationLanguage.g:5999:1: rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 : ( ruleAddOrSubtractOperatorRule ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6003:1: ( ( ruleAddOrSubtractOperatorRule ) )
            // InternalOptimisationLanguage.g:6004:2: ( ruleAddOrSubtractOperatorRule )
            {
            // InternalOptimisationLanguage.g:6004:2: ( ruleAddOrSubtractOperatorRule )
            // InternalOptimisationLanguage.g:6005:3: ruleAddOrSubtractOperatorRule
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
    // InternalOptimisationLanguage.g:6014:1: rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 : ( ruleLiteralOrReferenceRule ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6018:1: ( ( ruleLiteralOrReferenceRule ) )
            // InternalOptimisationLanguage.g:6019:2: ( ruleLiteralOrReferenceRule )
            {
            // InternalOptimisationLanguage.g:6019:2: ( ruleLiteralOrReferenceRule )
            // InternalOptimisationLanguage.g:6020:3: ruleLiteralOrReferenceRule
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
    // InternalOptimisationLanguage.g:6029:1: rule__ParanthesesRule__SubExpressionAssignment_1 : ( ruleExpressionRule ) ;
    public final void rule__ParanthesesRule__SubExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6033:1: ( ( ruleExpressionRule ) )
            // InternalOptimisationLanguage.g:6034:2: ( ruleExpressionRule )
            {
            // InternalOptimisationLanguage.g:6034:2: ( ruleExpressionRule )
            // InternalOptimisationLanguage.g:6035:3: ruleExpressionRule
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
    // InternalOptimisationLanguage.g:6044:1: rule__CallRule__FunctionAssignment_0 : ( ruleFunctionNameRule ) ;
    public final void rule__CallRule__FunctionAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6048:1: ( ( ruleFunctionNameRule ) )
            // InternalOptimisationLanguage.g:6049:2: ( ruleFunctionNameRule )
            {
            // InternalOptimisationLanguage.g:6049:2: ( ruleFunctionNameRule )
            // InternalOptimisationLanguage.g:6050:3: ruleFunctionNameRule
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
    // InternalOptimisationLanguage.g:6059:1: rule__CallRule__ParametersAssignment_2_0 : ( ruleExpressionRule ) ;
    public final void rule__CallRule__ParametersAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6063:1: ( ( ruleExpressionRule ) )
            // InternalOptimisationLanguage.g:6064:2: ( ruleExpressionRule )
            {
            // InternalOptimisationLanguage.g:6064:2: ( ruleExpressionRule )
            // InternalOptimisationLanguage.g:6065:3: ruleExpressionRule
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
    // InternalOptimisationLanguage.g:6074:1: rule__CallRule__ParametersAssignment_2_1_1 : ( ruleExpressionRule ) ;
    public final void rule__CallRule__ParametersAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6078:1: ( ( ruleExpressionRule ) )
            // InternalOptimisationLanguage.g:6079:2: ( ruleExpressionRule )
            {
            // InternalOptimisationLanguage.g:6079:2: ( ruleExpressionRule )
            // InternalOptimisationLanguage.g:6080:3: ruleExpressionRule
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
    // InternalOptimisationLanguage.g:6089:1: rule__DoubleLiteralRule__LiteralAssignment_0 : ( RULE_DOUBLE ) ;
    public final void rule__DoubleLiteralRule__LiteralAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6093:1: ( ( RULE_DOUBLE ) )
            // InternalOptimisationLanguage.g:6094:2: ( RULE_DOUBLE )
            {
            // InternalOptimisationLanguage.g:6094:2: ( RULE_DOUBLE )
            // InternalOptimisationLanguage.g:6095:3: RULE_DOUBLE
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
    // InternalOptimisationLanguage.g:6104:1: rule__DoubleLiteralRule__FactorAssignment_1 : ( ruleFactorRule ) ;
    public final void rule__DoubleLiteralRule__FactorAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6108:1: ( ( ruleFactorRule ) )
            // InternalOptimisationLanguage.g:6109:2: ( ruleFactorRule )
            {
            // InternalOptimisationLanguage.g:6109:2: ( ruleFactorRule )
            // InternalOptimisationLanguage.g:6110:3: ruleFactorRule
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
    // InternalOptimisationLanguage.g:6119:1: rule__IntegerLiteralRule__LiteralAssignment_0 : ( RULE_INT ) ;
    public final void rule__IntegerLiteralRule__LiteralAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6123:1: ( ( RULE_INT ) )
            // InternalOptimisationLanguage.g:6124:2: ( RULE_INT )
            {
            // InternalOptimisationLanguage.g:6124:2: ( RULE_INT )
            // InternalOptimisationLanguage.g:6125:3: RULE_INT
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
    // InternalOptimisationLanguage.g:6134:1: rule__IntegerLiteralRule__FactorAssignment_1 : ( ruleFactorRule ) ;
    public final void rule__IntegerLiteralRule__FactorAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6138:1: ( ( ruleFactorRule ) )
            // InternalOptimisationLanguage.g:6139:2: ( ruleFactorRule )
            {
            // InternalOptimisationLanguage.g:6139:2: ( ruleFactorRule )
            // InternalOptimisationLanguage.g:6140:3: ruleFactorRule
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
    // InternalOptimisationLanguage.g:6149:1: rule__StringLiteralRule__ValueAssignment : ( RULE_STRING ) ;
    public final void rule__StringLiteralRule__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6153:1: ( ( RULE_STRING ) )
            // InternalOptimisationLanguage.g:6154:2: ( RULE_STRING )
            {
            // InternalOptimisationLanguage.g:6154:2: ( RULE_STRING )
            // InternalOptimisationLanguage.g:6155:3: RULE_STRING
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
    // InternalOptimisationLanguage.g:6164:1: rule__BooleanLiteralRule__ValueAssignment_1_0 : ( ( 'true' ) ) ;
    public final void rule__BooleanLiteralRule__ValueAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6168:1: ( ( ( 'true' ) ) )
            // InternalOptimisationLanguage.g:6169:2: ( ( 'true' ) )
            {
            // InternalOptimisationLanguage.g:6169:2: ( ( 'true' ) )
            // InternalOptimisationLanguage.g:6170:3: ( 'true' )
            {
             before(grammarAccess.getBooleanLiteralRuleAccess().getValueTrueKeyword_1_0_0()); 
            // InternalOptimisationLanguage.g:6171:3: ( 'true' )
            // InternalOptimisationLanguage.g:6172:4: 'true'
            {
             before(grammarAccess.getBooleanLiteralRuleAccess().getValueTrueKeyword_1_0_0()); 
            match(input,82,FOLLOW_2); 
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
    // InternalOptimisationLanguage.g:6183:1: rule__AttributeDefinitionRule__NameAssignment_0 : ( ruleStringOrId ) ;
    public final void rule__AttributeDefinitionRule__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6187:1: ( ( ruleStringOrId ) )
            // InternalOptimisationLanguage.g:6188:2: ( ruleStringOrId )
            {
            // InternalOptimisationLanguage.g:6188:2: ( ruleStringOrId )
            // InternalOptimisationLanguage.g:6189:3: ruleStringOrId
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
    // InternalOptimisationLanguage.g:6198:1: rule__AttributeDefinitionRule__TypeAssignment_2 : ( ruleTypeRule ) ;
    public final void rule__AttributeDefinitionRule__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6202:1: ( ( ruleTypeRule ) )
            // InternalOptimisationLanguage.g:6203:2: ( ruleTypeRule )
            {
            // InternalOptimisationLanguage.g:6203:2: ( ruleTypeRule )
            // InternalOptimisationLanguage.g:6204:3: ruleTypeRule
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
    // InternalOptimisationLanguage.g:6213:1: rule__InstanceTypeRule__DefinitionsAssignment_2 : ( ( ruleQualifiedName ) ) ;
    public final void rule__InstanceTypeRule__DefinitionsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6217:1: ( ( ( ruleQualifiedName ) ) )
            // InternalOptimisationLanguage.g:6218:2: ( ( ruleQualifiedName ) )
            {
            // InternalOptimisationLanguage.g:6218:2: ( ( ruleQualifiedName ) )
            // InternalOptimisationLanguage.g:6219:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getInstanceTypeRuleAccess().getDefinitionsTypeDefinitionCrossReference_2_0()); 
            // InternalOptimisationLanguage.g:6220:3: ( ruleQualifiedName )
            // InternalOptimisationLanguage.g:6221:4: ruleQualifiedName
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
    // InternalOptimisationLanguage.g:6232:1: rule__InstanceTypeRule__DefinitionsAssignment_3_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__InstanceTypeRule__DefinitionsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6236:1: ( ( ( ruleQualifiedName ) ) )
            // InternalOptimisationLanguage.g:6237:2: ( ( ruleQualifiedName ) )
            {
            // InternalOptimisationLanguage.g:6237:2: ( ( ruleQualifiedName ) )
            // InternalOptimisationLanguage.g:6238:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getInstanceTypeRuleAccess().getDefinitionsTypeDefinitionCrossReference_3_1_0()); 
            // InternalOptimisationLanguage.g:6239:3: ( ruleQualifiedName )
            // InternalOptimisationLanguage.g:6240:4: ruleQualifiedName
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
    // InternalOptimisationLanguage.g:6251:1: rule__ArrayTypeRule__ElementsAssignment_1 : ( ruleTypeRule ) ;
    public final void rule__ArrayTypeRule__ElementsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6255:1: ( ( ruleTypeRule ) )
            // InternalOptimisationLanguage.g:6256:2: ( ruleTypeRule )
            {
            // InternalOptimisationLanguage.g:6256:2: ( ruleTypeRule )
            // InternalOptimisationLanguage.g:6257:3: ruleTypeRule
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
    // InternalOptimisationLanguage.g:6266:1: rule__ParameterRule__TypeAssignment_0 : ( ruleTypeRule ) ;
    public final void rule__ParameterRule__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6270:1: ( ( ruleTypeRule ) )
            // InternalOptimisationLanguage.g:6271:2: ( ruleTypeRule )
            {
            // InternalOptimisationLanguage.g:6271:2: ( ruleTypeRule )
            // InternalOptimisationLanguage.g:6272:3: ruleTypeRule
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
    // InternalOptimisationLanguage.g:6281:1: rule__ParameterRule__NameAssignment_1 : ( ruleStringOrId ) ;
    public final void rule__ParameterRule__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6285:1: ( ( ruleStringOrId ) )
            // InternalOptimisationLanguage.g:6286:2: ( ruleStringOrId )
            {
            // InternalOptimisationLanguage.g:6286:2: ( ruleStringOrId )
            // InternalOptimisationLanguage.g:6287:3: ruleStringOrId
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
    // InternalOptimisationLanguage.g:6296:1: rule__FunctionNameRule__DefinitionAssignment : ( ( ruleQualifiedName ) ) ;
    public final void rule__FunctionNameRule__DefinitionAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOptimisationLanguage.g:6300:1: ( ( ( ruleQualifiedName ) ) )
            // InternalOptimisationLanguage.g:6301:2: ( ( ruleQualifiedName ) )
            {
            // InternalOptimisationLanguage.g:6301:2: ( ( ruleQualifiedName ) )
            // InternalOptimisationLanguage.g:6302:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getFunctionNameRuleAccess().getDefinitionFunctionDefinitionCrossReference_0()); 
            // InternalOptimisationLanguage.g:6303:3: ( ruleQualifiedName )
            // InternalOptimisationLanguage.g:6304:4: ruleQualifiedName
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
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0022000000000000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0400000000000030L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x48000000000081F0L,0x0000000000040000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x58000000000081F0L,0x0000000000040000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x2000000000000002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x4800000000C081F0L,0x0000000000060050L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x00000000003F0000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x00000000003F0002L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000007000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000007000002L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x4800000000C081F0L,0x0000000000060070L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x00007FFFF8000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x4020000000000000L,0x000000000001FD00L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});

}
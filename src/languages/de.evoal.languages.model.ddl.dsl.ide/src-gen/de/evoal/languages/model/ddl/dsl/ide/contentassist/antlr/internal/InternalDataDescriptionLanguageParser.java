package de.evoal.languages.model.ddl.dsl.ide.contentassist.antlr.internal;

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
import de.evoal.languages.model.ddl.dsl.services.DataDescriptionLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalDataDescriptionLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_QUOTED_ID", "RULE_ID", "RULE_STRING", "RULE_DOUBLE", "RULE_INT", "RULE_DIGIT", "RULE_EXPONENT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'false'", "'nominal'", "'ordinal'", "'cardinal'", "'quotient'", "'real'", "'integer'", "'boolean'", "'string'", "'>='", "'>'", "'='", "'!='", "'<'", "'<='", "'+'", "'-'", "'*'", "'/'", "'%'", "'Y'", "'Z'", "'E'", "'P'", "'T'", "'G'", "'M'", "'k'", "'h'", "'da'", "'d'", "'c'", "'m'", "'\\u00B5'", "'n'", "'p'", "'f'", "'a'", "'z'", "'y'", "'types'", "':'", "'data'", "'constraints'", "'use'", "';'", "'type'", "'description'", "'with'", "'of'", "'value'", "'OR'", "'XOR'", "'AND'", "'^'", "'('", "')'", "','", "'!'", "'true'"
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
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__74=74;
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


        public InternalDataDescriptionLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalDataDescriptionLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalDataDescriptionLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalDataDescriptionLanguage.g"; }


    	private DataDescriptionLanguageGrammarAccess grammarAccess;

    	public void setGrammarAccess(DataDescriptionLanguageGrammarAccess grammarAccess) {
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



    // $ANTLR start "entryRuleDataDescriptionModelRule"
    // InternalDataDescriptionLanguage.g:55:1: entryRuleDataDescriptionModelRule : ruleDataDescriptionModelRule EOF ;
    public final void entryRuleDataDescriptionModelRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:56:1: ( ruleDataDescriptionModelRule EOF )
            // InternalDataDescriptionLanguage.g:57:1: ruleDataDescriptionModelRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleDataDescriptionModelRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataDescriptionModelRuleRule()); 
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
    // $ANTLR end "entryRuleDataDescriptionModelRule"


    // $ANTLR start "ruleDataDescriptionModelRule"
    // InternalDataDescriptionLanguage.g:64:1: ruleDataDescriptionModelRule : ( ( rule__DataDescriptionModelRule__Group__0 ) ) ;
    public final void ruleDataDescriptionModelRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:68:2: ( ( ( rule__DataDescriptionModelRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:69:2: ( ( rule__DataDescriptionModelRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:69:2: ( ( rule__DataDescriptionModelRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:70:3: ( rule__DataDescriptionModelRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:71:3: ( rule__DataDescriptionModelRule__Group__0 )
            // InternalDataDescriptionLanguage.g:71:4: rule__DataDescriptionModelRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DataDescriptionModelRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataDescriptionModelRuleAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDataDescriptionModelRule"


    // $ANTLR start "entryRuleUseRule"
    // InternalDataDescriptionLanguage.g:80:1: entryRuleUseRule : ruleUseRule EOF ;
    public final void entryRuleUseRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:81:1: ( ruleUseRule EOF )
            // InternalDataDescriptionLanguage.g:82:1: ruleUseRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUseRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleUseRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUseRuleRule()); 
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
    // $ANTLR end "entryRuleUseRule"


    // $ANTLR start "ruleUseRule"
    // InternalDataDescriptionLanguage.g:89:1: ruleUseRule : ( ( rule__UseRule__Group__0 ) ) ;
    public final void ruleUseRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:93:2: ( ( ( rule__UseRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:94:2: ( ( rule__UseRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:94:2: ( ( rule__UseRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:95:3: ( rule__UseRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUseRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:96:3: ( rule__UseRule__Group__0 )
            // InternalDataDescriptionLanguage.g:96:4: rule__UseRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__UseRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getUseRuleAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleUseRule"


    // $ANTLR start "entryRuleDataTypeRule"
    // InternalDataDescriptionLanguage.g:105:1: entryRuleDataTypeRule : ruleDataTypeRule EOF ;
    public final void entryRuleDataTypeRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:106:1: ( ruleDataTypeRule EOF )
            // InternalDataDescriptionLanguage.g:107:1: ruleDataTypeRule EOF
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
    // InternalDataDescriptionLanguage.g:114:1: ruleDataTypeRule : ( ( rule__DataTypeRule__Group__0 ) ) ;
    public final void ruleDataTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:118:2: ( ( ( rule__DataTypeRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:119:2: ( ( rule__DataTypeRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:119:2: ( ( rule__DataTypeRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:120:3: ( rule__DataTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:121:3: ( rule__DataTypeRule__Group__0 )
            // InternalDataDescriptionLanguage.g:121:4: rule__DataTypeRule__Group__0
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


    // $ANTLR start "entryRuleDataDescriptionRule"
    // InternalDataDescriptionLanguage.g:130:1: entryRuleDataDescriptionRule : ruleDataDescriptionRule EOF ;
    public final void entryRuleDataDescriptionRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:131:1: ( ruleDataDescriptionRule EOF )
            // InternalDataDescriptionLanguage.g:132:1: ruleDataDescriptionRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleDataDescriptionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataDescriptionRuleRule()); 
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
    // $ANTLR end "entryRuleDataDescriptionRule"


    // $ANTLR start "ruleDataDescriptionRule"
    // InternalDataDescriptionLanguage.g:139:1: ruleDataDescriptionRule : ( ( rule__DataDescriptionRule__Alternatives ) ) ;
    public final void ruleDataDescriptionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:143:2: ( ( ( rule__DataDescriptionRule__Alternatives ) ) )
            // InternalDataDescriptionLanguage.g:144:2: ( ( rule__DataDescriptionRule__Alternatives ) )
            {
            // InternalDataDescriptionLanguage.g:144:2: ( ( rule__DataDescriptionRule__Alternatives ) )
            // InternalDataDescriptionLanguage.g:145:3: ( rule__DataDescriptionRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionRuleAccess().getAlternatives()); 
            }
            // InternalDataDescriptionLanguage.g:146:3: ( rule__DataDescriptionRule__Alternatives )
            // InternalDataDescriptionLanguage.g:146:4: rule__DataDescriptionRule__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__DataDescriptionRule__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataDescriptionRuleAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDataDescriptionRule"


    // $ANTLR start "entryRuleTypedDataDescriptionRule"
    // InternalDataDescriptionLanguage.g:155:1: entryRuleTypedDataDescriptionRule : ruleTypedDataDescriptionRule EOF ;
    public final void entryRuleTypedDataDescriptionRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:156:1: ( ruleTypedDataDescriptionRule EOF )
            // InternalDataDescriptionLanguage.g:157:1: ruleTypedDataDescriptionRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedDataDescriptionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleTypedDataDescriptionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedDataDescriptionRuleRule()); 
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
    // $ANTLR end "entryRuleTypedDataDescriptionRule"


    // $ANTLR start "ruleTypedDataDescriptionRule"
    // InternalDataDescriptionLanguage.g:164:1: ruleTypedDataDescriptionRule : ( ( rule__TypedDataDescriptionRule__Group__0 ) ) ;
    public final void ruleTypedDataDescriptionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:168:2: ( ( ( rule__TypedDataDescriptionRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:169:2: ( ( rule__TypedDataDescriptionRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:169:2: ( ( rule__TypedDataDescriptionRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:170:3: ( rule__TypedDataDescriptionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedDataDescriptionRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:171:3: ( rule__TypedDataDescriptionRule__Group__0 )
            // InternalDataDescriptionLanguage.g:171:4: rule__TypedDataDescriptionRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TypedDataDescriptionRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedDataDescriptionRuleAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTypedDataDescriptionRule"


    // $ANTLR start "entryRuleUntypedDataDescriptionRule"
    // InternalDataDescriptionLanguage.g:180:1: entryRuleUntypedDataDescriptionRule : ruleUntypedDataDescriptionRule EOF ;
    public final void entryRuleUntypedDataDescriptionRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:181:1: ( ruleUntypedDataDescriptionRule EOF )
            // InternalDataDescriptionLanguage.g:182:1: ruleUntypedDataDescriptionRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUntypedDataDescriptionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleUntypedDataDescriptionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUntypedDataDescriptionRuleRule()); 
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
    // $ANTLR end "entryRuleUntypedDataDescriptionRule"


    // $ANTLR start "ruleUntypedDataDescriptionRule"
    // InternalDataDescriptionLanguage.g:189:1: ruleUntypedDataDescriptionRule : ( ( rule__UntypedDataDescriptionRule__Group__0 ) ) ;
    public final void ruleUntypedDataDescriptionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:193:2: ( ( ( rule__UntypedDataDescriptionRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:194:2: ( ( rule__UntypedDataDescriptionRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:194:2: ( ( rule__UntypedDataDescriptionRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:195:3: ( rule__UntypedDataDescriptionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUntypedDataDescriptionRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:196:3: ( rule__UntypedDataDescriptionRule__Group__0 )
            // InternalDataDescriptionLanguage.g:196:4: rule__UntypedDataDescriptionRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__UntypedDataDescriptionRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getUntypedDataDescriptionRuleAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleUntypedDataDescriptionRule"


    // $ANTLR start "entryRuleStatementRule"
    // InternalDataDescriptionLanguage.g:205:1: entryRuleStatementRule : ruleStatementRule EOF ;
    public final void entryRuleStatementRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:206:1: ( ruleStatementRule EOF )
            // InternalDataDescriptionLanguage.g:207:1: ruleStatementRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStatementRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleStatementRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getStatementRuleRule()); 
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
    // $ANTLR end "entryRuleStatementRule"


    // $ANTLR start "ruleStatementRule"
    // InternalDataDescriptionLanguage.g:214:1: ruleStatementRule : ( ( rule__StatementRule__Group__0 ) ) ;
    public final void ruleStatementRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:218:2: ( ( ( rule__StatementRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:219:2: ( ( rule__StatementRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:219:2: ( ( rule__StatementRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:220:3: ( rule__StatementRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStatementRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:221:3: ( rule__StatementRule__Group__0 )
            // InternalDataDescriptionLanguage.g:221:4: rule__StatementRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__StatementRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getStatementRuleAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleStatementRule"


    // $ANTLR start "entryRuleFunctionNameRule"
    // InternalDataDescriptionLanguage.g:230:1: entryRuleFunctionNameRule : ruleFunctionNameRule EOF ;
    public final void entryRuleFunctionNameRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:231:1: ( ruleFunctionNameRule EOF )
            // InternalDataDescriptionLanguage.g:232:1: ruleFunctionNameRule EOF
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
    // InternalDataDescriptionLanguage.g:239:1: ruleFunctionNameRule : ( ( rule__FunctionNameRule__DefinitionAssignment ) ) ;
    public final void ruleFunctionNameRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:243:2: ( ( ( rule__FunctionNameRule__DefinitionAssignment ) ) )
            // InternalDataDescriptionLanguage.g:244:2: ( ( rule__FunctionNameRule__DefinitionAssignment ) )
            {
            // InternalDataDescriptionLanguage.g:244:2: ( ( rule__FunctionNameRule__DefinitionAssignment ) )
            // InternalDataDescriptionLanguage.g:245:3: ( rule__FunctionNameRule__DefinitionAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionNameRuleAccess().getDefinitionAssignment()); 
            }
            // InternalDataDescriptionLanguage.g:246:3: ( rule__FunctionNameRule__DefinitionAssignment )
            // InternalDataDescriptionLanguage.g:246:4: rule__FunctionNameRule__DefinitionAssignment
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


    // $ANTLR start "entryRuleValueReferenceRule"
    // InternalDataDescriptionLanguage.g:255:1: entryRuleValueReferenceRule : ruleValueReferenceRule EOF ;
    public final void entryRuleValueReferenceRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:256:1: ( ruleValueReferenceRule EOF )
            // InternalDataDescriptionLanguage.g:257:1: ruleValueReferenceRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueReferenceRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleValueReferenceRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueReferenceRuleRule()); 
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
    // $ANTLR end "entryRuleValueReferenceRule"


    // $ANTLR start "ruleValueReferenceRule"
    // InternalDataDescriptionLanguage.g:264:1: ruleValueReferenceRule : ( ( rule__ValueReferenceRule__Alternatives ) ) ;
    public final void ruleValueReferenceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:268:2: ( ( ( rule__ValueReferenceRule__Alternatives ) ) )
            // InternalDataDescriptionLanguage.g:269:2: ( ( rule__ValueReferenceRule__Alternatives ) )
            {
            // InternalDataDescriptionLanguage.g:269:2: ( ( rule__ValueReferenceRule__Alternatives ) )
            // InternalDataDescriptionLanguage.g:270:3: ( rule__ValueReferenceRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueReferenceRuleAccess().getAlternatives()); 
            }
            // InternalDataDescriptionLanguage.g:271:3: ( rule__ValueReferenceRule__Alternatives )
            // InternalDataDescriptionLanguage.g:271:4: rule__ValueReferenceRule__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__ValueReferenceRule__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueReferenceRuleAccess().getAlternatives()); 
            }

            }


            }

        }
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


    // $ANTLR start "entryRuleDataReferenceRule"
    // InternalDataDescriptionLanguage.g:280:1: entryRuleDataReferenceRule : ruleDataReferenceRule EOF ;
    public final void entryRuleDataReferenceRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:281:1: ( ruleDataReferenceRule EOF )
            // InternalDataDescriptionLanguage.g:282:1: ruleDataReferenceRule EOF
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
    // InternalDataDescriptionLanguage.g:289:1: ruleDataReferenceRule : ( ( rule__DataReferenceRule__DefinitionAssignment ) ) ;
    public final void ruleDataReferenceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:293:2: ( ( ( rule__DataReferenceRule__DefinitionAssignment ) ) )
            // InternalDataDescriptionLanguage.g:294:2: ( ( rule__DataReferenceRule__DefinitionAssignment ) )
            {
            // InternalDataDescriptionLanguage.g:294:2: ( ( rule__DataReferenceRule__DefinitionAssignment ) )
            // InternalDataDescriptionLanguage.g:295:3: ( rule__DataReferenceRule__DefinitionAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataReferenceRuleAccess().getDefinitionAssignment()); 
            }
            // InternalDataDescriptionLanguage.g:296:3: ( rule__DataReferenceRule__DefinitionAssignment )
            // InternalDataDescriptionLanguage.g:296:4: rule__DataReferenceRule__DefinitionAssignment
            {
            pushFollow(FOLLOW_2);
            rule__DataReferenceRule__DefinitionAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataReferenceRuleAccess().getDefinitionAssignment()); 
            }

            }


            }

        }
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


    // $ANTLR start "entryRuleSelfReferenceRule"
    // InternalDataDescriptionLanguage.g:305:1: entryRuleSelfReferenceRule : ruleSelfReferenceRule EOF ;
    public final void entryRuleSelfReferenceRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:306:1: ( ruleSelfReferenceRule EOF )
            // InternalDataDescriptionLanguage.g:307:1: ruleSelfReferenceRule EOF
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
    // InternalDataDescriptionLanguage.g:314:1: ruleSelfReferenceRule : ( ( rule__SelfReferenceRule__Group__0 ) ) ;
    public final void ruleSelfReferenceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:318:2: ( ( ( rule__SelfReferenceRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:319:2: ( ( rule__SelfReferenceRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:319:2: ( ( rule__SelfReferenceRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:320:3: ( rule__SelfReferenceRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSelfReferenceRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:321:3: ( rule__SelfReferenceRule__Group__0 )
            // InternalDataDescriptionLanguage.g:321:4: rule__SelfReferenceRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__SelfReferenceRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSelfReferenceRuleAccess().getGroup()); 
            }

            }


            }

        }
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


    // $ANTLR start "entryRuleExpressionRule"
    // InternalDataDescriptionLanguage.g:330:1: entryRuleExpressionRule : ruleExpressionRule EOF ;
    public final void entryRuleExpressionRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:331:1: ( ruleExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:332:1: ruleExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:339:1: ruleExpressionRule : ( ruleOrExpressionRule ) ;
    public final void ruleExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:343:2: ( ( ruleOrExpressionRule ) )
            // InternalDataDescriptionLanguage.g:344:2: ( ruleOrExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:344:2: ( ruleOrExpressionRule )
            // InternalDataDescriptionLanguage.g:345:3: ruleOrExpressionRule
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
    // InternalDataDescriptionLanguage.g:355:1: entryRuleOrExpressionRule : ruleOrExpressionRule EOF ;
    public final void entryRuleOrExpressionRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:356:1: ( ruleOrExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:357:1: ruleOrExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:364:1: ruleOrExpressionRule : ( ( rule__OrExpressionRule__Group__0 ) ) ;
    public final void ruleOrExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:368:2: ( ( ( rule__OrExpressionRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:369:2: ( ( rule__OrExpressionRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:369:2: ( ( rule__OrExpressionRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:370:3: ( rule__OrExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:371:3: ( rule__OrExpressionRule__Group__0 )
            // InternalDataDescriptionLanguage.g:371:4: rule__OrExpressionRule__Group__0
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
    // InternalDataDescriptionLanguage.g:380:1: entryRuleXorExpressionRule : ruleXorExpressionRule EOF ;
    public final void entryRuleXorExpressionRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:381:1: ( ruleXorExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:382:1: ruleXorExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:389:1: ruleXorExpressionRule : ( ( rule__XorExpressionRule__Group__0 ) ) ;
    public final void ruleXorExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:393:2: ( ( ( rule__XorExpressionRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:394:2: ( ( rule__XorExpressionRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:394:2: ( ( rule__XorExpressionRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:395:3: ( rule__XorExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXorExpressionRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:396:3: ( rule__XorExpressionRule__Group__0 )
            // InternalDataDescriptionLanguage.g:396:4: rule__XorExpressionRule__Group__0
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
    // InternalDataDescriptionLanguage.g:405:1: entryRuleAndExpressionRule : ruleAndExpressionRule EOF ;
    public final void entryRuleAndExpressionRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:406:1: ( ruleAndExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:407:1: ruleAndExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:414:1: ruleAndExpressionRule : ( ( rule__AndExpressionRule__Group__0 ) ) ;
    public final void ruleAndExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:418:2: ( ( ( rule__AndExpressionRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:419:2: ( ( rule__AndExpressionRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:419:2: ( ( rule__AndExpressionRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:420:3: ( rule__AndExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:421:3: ( rule__AndExpressionRule__Group__0 )
            // InternalDataDescriptionLanguage.g:421:4: rule__AndExpressionRule__Group__0
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
    // InternalDataDescriptionLanguage.g:430:1: entryRuleNotExpressionRule : ruleNotExpressionRule EOF ;
    public final void entryRuleNotExpressionRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:431:1: ( ruleNotExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:432:1: ruleNotExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:439:1: ruleNotExpressionRule : ( ( rule__NotExpressionRule__Group__0 ) ) ;
    public final void ruleNotExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:443:2: ( ( ( rule__NotExpressionRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:444:2: ( ( rule__NotExpressionRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:444:2: ( ( rule__NotExpressionRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:445:3: ( rule__NotExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNotExpressionRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:446:3: ( rule__NotExpressionRule__Group__0 )
            // InternalDataDescriptionLanguage.g:446:4: rule__NotExpressionRule__Group__0
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
    // InternalDataDescriptionLanguage.g:455:1: entryRuleComparisonExpressionRule : ruleComparisonExpressionRule EOF ;
    public final void entryRuleComparisonExpressionRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:456:1: ( ruleComparisonExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:457:1: ruleComparisonExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:464:1: ruleComparisonExpressionRule : ( ( rule__ComparisonExpressionRule__Group__0 ) ) ;
    public final void ruleComparisonExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:468:2: ( ( ( rule__ComparisonExpressionRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:469:2: ( ( rule__ComparisonExpressionRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:469:2: ( ( rule__ComparisonExpressionRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:470:3: ( rule__ComparisonExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonExpressionRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:471:3: ( rule__ComparisonExpressionRule__Group__0 )
            // InternalDataDescriptionLanguage.g:471:4: rule__ComparisonExpressionRule__Group__0
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
    // InternalDataDescriptionLanguage.g:480:1: entryRulePartialComparisonExpressionRule : rulePartialComparisonExpressionRule EOF ;
    public final void entryRulePartialComparisonExpressionRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:481:1: ( rulePartialComparisonExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:482:1: rulePartialComparisonExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:489:1: rulePartialComparisonExpressionRule : ( ( rule__PartialComparisonExpressionRule__Group__0 ) ) ;
    public final void rulePartialComparisonExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:493:2: ( ( ( rule__PartialComparisonExpressionRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:494:2: ( ( rule__PartialComparisonExpressionRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:494:2: ( ( rule__PartialComparisonExpressionRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:495:3: ( rule__PartialComparisonExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartialComparisonExpressionRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:496:3: ( rule__PartialComparisonExpressionRule__Group__0 )
            // InternalDataDescriptionLanguage.g:496:4: rule__PartialComparisonExpressionRule__Group__0
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
    // InternalDataDescriptionLanguage.g:505:1: entryRuleAddOrSubtractExpressionRule : ruleAddOrSubtractExpressionRule EOF ;
    public final void entryRuleAddOrSubtractExpressionRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:506:1: ( ruleAddOrSubtractExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:507:1: ruleAddOrSubtractExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:514:1: ruleAddOrSubtractExpressionRule : ( ( rule__AddOrSubtractExpressionRule__Group__0 ) ) ;
    public final void ruleAddOrSubtractExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:518:2: ( ( ( rule__AddOrSubtractExpressionRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:519:2: ( ( rule__AddOrSubtractExpressionRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:519:2: ( ( rule__AddOrSubtractExpressionRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:520:3: ( rule__AddOrSubtractExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:521:3: ( rule__AddOrSubtractExpressionRule__Group__0 )
            // InternalDataDescriptionLanguage.g:521:4: rule__AddOrSubtractExpressionRule__Group__0
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
    // InternalDataDescriptionLanguage.g:530:1: entryRuleMultiplyDivideModuloExpressionRule : ruleMultiplyDivideModuloExpressionRule EOF ;
    public final void entryRuleMultiplyDivideModuloExpressionRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:531:1: ( ruleMultiplyDivideModuloExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:532:1: ruleMultiplyDivideModuloExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:539:1: ruleMultiplyDivideModuloExpressionRule : ( ( rule__MultiplyDivideModuloExpressionRule__Group__0 ) ) ;
    public final void ruleMultiplyDivideModuloExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:543:2: ( ( ( rule__MultiplyDivideModuloExpressionRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:544:2: ( ( rule__MultiplyDivideModuloExpressionRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:544:2: ( ( rule__MultiplyDivideModuloExpressionRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:545:3: ( rule__MultiplyDivideModuloExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:546:3: ( rule__MultiplyDivideModuloExpressionRule__Group__0 )
            // InternalDataDescriptionLanguage.g:546:4: rule__MultiplyDivideModuloExpressionRule__Group__0
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
    // InternalDataDescriptionLanguage.g:555:1: entryRulePowerOfExpressionRule : rulePowerOfExpressionRule EOF ;
    public final void entryRulePowerOfExpressionRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:556:1: ( rulePowerOfExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:557:1: rulePowerOfExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:564:1: rulePowerOfExpressionRule : ( ( rule__PowerOfExpressionRule__Group__0 ) ) ;
    public final void rulePowerOfExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:568:2: ( ( ( rule__PowerOfExpressionRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:569:2: ( ( rule__PowerOfExpressionRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:569:2: ( ( rule__PowerOfExpressionRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:570:3: ( rule__PowerOfExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPowerOfExpressionRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:571:3: ( rule__PowerOfExpressionRule__Group__0 )
            // InternalDataDescriptionLanguage.g:571:4: rule__PowerOfExpressionRule__Group__0
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
    // InternalDataDescriptionLanguage.g:580:1: entryRuleUnaryAddOrSubtractExpressionRule : ruleUnaryAddOrSubtractExpressionRule EOF ;
    public final void entryRuleUnaryAddOrSubtractExpressionRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:581:1: ( ruleUnaryAddOrSubtractExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:582:1: ruleUnaryAddOrSubtractExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:589:1: ruleUnaryAddOrSubtractExpressionRule : ( ( rule__UnaryAddOrSubtractExpressionRule__Group__0 ) ) ;
    public final void ruleUnaryAddOrSubtractExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:593:2: ( ( ( rule__UnaryAddOrSubtractExpressionRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:594:2: ( ( rule__UnaryAddOrSubtractExpressionRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:594:2: ( ( rule__UnaryAddOrSubtractExpressionRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:595:3: ( rule__UnaryAddOrSubtractExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:596:3: ( rule__UnaryAddOrSubtractExpressionRule__Group__0 )
            // InternalDataDescriptionLanguage.g:596:4: rule__UnaryAddOrSubtractExpressionRule__Group__0
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


    // $ANTLR start "entryRuleLiteralOrReferenceRule"
    // InternalDataDescriptionLanguage.g:605:1: entryRuleLiteralOrReferenceRule : ruleLiteralOrReferenceRule EOF ;
    public final void entryRuleLiteralOrReferenceRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:606:1: ( ruleLiteralOrReferenceRule EOF )
            // InternalDataDescriptionLanguage.g:607:1: ruleLiteralOrReferenceRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralOrReferenceRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleLiteralOrReferenceRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLiteralOrReferenceRuleRule()); 
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
    // $ANTLR end "entryRuleLiteralOrReferenceRule"


    // $ANTLR start "ruleLiteralOrReferenceRule"
    // InternalDataDescriptionLanguage.g:614:1: ruleLiteralOrReferenceRule : ( ( rule__LiteralOrReferenceRule__Alternatives ) ) ;
    public final void ruleLiteralOrReferenceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:618:2: ( ( ( rule__LiteralOrReferenceRule__Alternatives ) ) )
            // InternalDataDescriptionLanguage.g:619:2: ( ( rule__LiteralOrReferenceRule__Alternatives ) )
            {
            // InternalDataDescriptionLanguage.g:619:2: ( ( rule__LiteralOrReferenceRule__Alternatives ) )
            // InternalDataDescriptionLanguage.g:620:3: ( rule__LiteralOrReferenceRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralOrReferenceRuleAccess().getAlternatives()); 
            }
            // InternalDataDescriptionLanguage.g:621:3: ( rule__LiteralOrReferenceRule__Alternatives )
            // InternalDataDescriptionLanguage.g:621:4: rule__LiteralOrReferenceRule__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__LiteralOrReferenceRule__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLiteralOrReferenceRuleAccess().getAlternatives()); 
            }

            }


            }

        }
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
    // InternalDataDescriptionLanguage.g:630:1: entryRuleParanthesesRule : ruleParanthesesRule EOF ;
    public final void entryRuleParanthesesRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:631:1: ( ruleParanthesesRule EOF )
            // InternalDataDescriptionLanguage.g:632:1: ruleParanthesesRule EOF
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
    // InternalDataDescriptionLanguage.g:639:1: ruleParanthesesRule : ( ( rule__ParanthesesRule__Group__0 ) ) ;
    public final void ruleParanthesesRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:643:2: ( ( ( rule__ParanthesesRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:644:2: ( ( rule__ParanthesesRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:644:2: ( ( rule__ParanthesesRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:645:3: ( rule__ParanthesesRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParanthesesRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:646:3: ( rule__ParanthesesRule__Group__0 )
            // InternalDataDescriptionLanguage.g:646:4: rule__ParanthesesRule__Group__0
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
    // InternalDataDescriptionLanguage.g:655:1: entryRuleCallRule : ruleCallRule EOF ;
    public final void entryRuleCallRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:656:1: ( ruleCallRule EOF )
            // InternalDataDescriptionLanguage.g:657:1: ruleCallRule EOF
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
    // InternalDataDescriptionLanguage.g:664:1: ruleCallRule : ( ( rule__CallRule__Group__0 ) ) ;
    public final void ruleCallRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:668:2: ( ( ( rule__CallRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:669:2: ( ( rule__CallRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:669:2: ( ( rule__CallRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:670:3: ( rule__CallRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:671:3: ( rule__CallRule__Group__0 )
            // InternalDataDescriptionLanguage.g:671:4: rule__CallRule__Group__0
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


    // $ANTLR start "entryRuleLiteralRule"
    // InternalDataDescriptionLanguage.g:680:1: entryRuleLiteralRule : ruleLiteralRule EOF ;
    public final void entryRuleLiteralRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:681:1: ( ruleLiteralRule EOF )
            // InternalDataDescriptionLanguage.g:682:1: ruleLiteralRule EOF
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
    // InternalDataDescriptionLanguage.g:689:1: ruleLiteralRule : ( ( rule__LiteralRule__Alternatives ) ) ;
    public final void ruleLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:693:2: ( ( ( rule__LiteralRule__Alternatives ) ) )
            // InternalDataDescriptionLanguage.g:694:2: ( ( rule__LiteralRule__Alternatives ) )
            {
            // InternalDataDescriptionLanguage.g:694:2: ( ( rule__LiteralRule__Alternatives ) )
            // InternalDataDescriptionLanguage.g:695:3: ( rule__LiteralRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralRuleAccess().getAlternatives()); 
            }
            // InternalDataDescriptionLanguage.g:696:3: ( rule__LiteralRule__Alternatives )
            // InternalDataDescriptionLanguage.g:696:4: rule__LiteralRule__Alternatives
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


    // $ANTLR start "entryRuleNumberLiteralRule"
    // InternalDataDescriptionLanguage.g:705:1: entryRuleNumberLiteralRule : ruleNumberLiteralRule EOF ;
    public final void entryRuleNumberLiteralRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:706:1: ( ruleNumberLiteralRule EOF )
            // InternalDataDescriptionLanguage.g:707:1: ruleNumberLiteralRule EOF
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
    // InternalDataDescriptionLanguage.g:714:1: ruleNumberLiteralRule : ( ( rule__NumberLiteralRule__Alternatives ) ) ;
    public final void ruleNumberLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:718:2: ( ( ( rule__NumberLiteralRule__Alternatives ) ) )
            // InternalDataDescriptionLanguage.g:719:2: ( ( rule__NumberLiteralRule__Alternatives ) )
            {
            // InternalDataDescriptionLanguage.g:719:2: ( ( rule__NumberLiteralRule__Alternatives ) )
            // InternalDataDescriptionLanguage.g:720:3: ( rule__NumberLiteralRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumberLiteralRuleAccess().getAlternatives()); 
            }
            // InternalDataDescriptionLanguage.g:721:3: ( rule__NumberLiteralRule__Alternatives )
            // InternalDataDescriptionLanguage.g:721:4: rule__NumberLiteralRule__Alternatives
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


    // $ANTLR start "entryRuleDoubleLiteralRule"
    // InternalDataDescriptionLanguage.g:730:1: entryRuleDoubleLiteralRule : ruleDoubleLiteralRule EOF ;
    public final void entryRuleDoubleLiteralRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:731:1: ( ruleDoubleLiteralRule EOF )
            // InternalDataDescriptionLanguage.g:732:1: ruleDoubleLiteralRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDoubleLiteralRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleDoubleLiteralRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDoubleLiteralRuleRule()); 
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
    // $ANTLR end "entryRuleDoubleLiteralRule"


    // $ANTLR start "ruleDoubleLiteralRule"
    // InternalDataDescriptionLanguage.g:739:1: ruleDoubleLiteralRule : ( ( rule__DoubleLiteralRule__Group__0 ) ) ;
    public final void ruleDoubleLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:743:2: ( ( ( rule__DoubleLiteralRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:744:2: ( ( rule__DoubleLiteralRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:744:2: ( ( rule__DoubleLiteralRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:745:3: ( rule__DoubleLiteralRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDoubleLiteralRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:746:3: ( rule__DoubleLiteralRule__Group__0 )
            // InternalDataDescriptionLanguage.g:746:4: rule__DoubleLiteralRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DoubleLiteralRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDoubleLiteralRuleAccess().getGroup()); 
            }

            }


            }

        }
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
    // InternalDataDescriptionLanguage.g:755:1: entryRuleIntegerLiteralRule : ruleIntegerLiteralRule EOF ;
    public final void entryRuleIntegerLiteralRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:756:1: ( ruleIntegerLiteralRule EOF )
            // InternalDataDescriptionLanguage.g:757:1: ruleIntegerLiteralRule EOF
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
    // InternalDataDescriptionLanguage.g:764:1: ruleIntegerLiteralRule : ( ( rule__IntegerLiteralRule__Group__0 ) ) ;
    public final void ruleIntegerLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:768:2: ( ( ( rule__IntegerLiteralRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:769:2: ( ( rule__IntegerLiteralRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:769:2: ( ( rule__IntegerLiteralRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:770:3: ( rule__IntegerLiteralRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegerLiteralRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:771:3: ( rule__IntegerLiteralRule__Group__0 )
            // InternalDataDescriptionLanguage.g:771:4: rule__IntegerLiteralRule__Group__0
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
    // InternalDataDescriptionLanguage.g:780:1: entryRuleStringLiteralRule : ruleStringLiteralRule EOF ;
    public final void entryRuleStringLiteralRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:781:1: ( ruleStringLiteralRule EOF )
            // InternalDataDescriptionLanguage.g:782:1: ruleStringLiteralRule EOF
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
    // InternalDataDescriptionLanguage.g:789:1: ruleStringLiteralRule : ( ( rule__StringLiteralRule__ValueAssignment ) ) ;
    public final void ruleStringLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:793:2: ( ( ( rule__StringLiteralRule__ValueAssignment ) ) )
            // InternalDataDescriptionLanguage.g:794:2: ( ( rule__StringLiteralRule__ValueAssignment ) )
            {
            // InternalDataDescriptionLanguage.g:794:2: ( ( rule__StringLiteralRule__ValueAssignment ) )
            // InternalDataDescriptionLanguage.g:795:3: ( rule__StringLiteralRule__ValueAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringLiteralRuleAccess().getValueAssignment()); 
            }
            // InternalDataDescriptionLanguage.g:796:3: ( rule__StringLiteralRule__ValueAssignment )
            // InternalDataDescriptionLanguage.g:796:4: rule__StringLiteralRule__ValueAssignment
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
    // InternalDataDescriptionLanguage.g:805:1: entryRuleBooleanLiteralRule : ruleBooleanLiteralRule EOF ;
    public final void entryRuleBooleanLiteralRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:806:1: ( ruleBooleanLiteralRule EOF )
            // InternalDataDescriptionLanguage.g:807:1: ruleBooleanLiteralRule EOF
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
    // InternalDataDescriptionLanguage.g:814:1: ruleBooleanLiteralRule : ( ( rule__BooleanLiteralRule__Group__0 ) ) ;
    public final void ruleBooleanLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:818:2: ( ( ( rule__BooleanLiteralRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:819:2: ( ( rule__BooleanLiteralRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:819:2: ( ( rule__BooleanLiteralRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:820:3: ( rule__BooleanLiteralRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:821:3: ( rule__BooleanLiteralRule__Group__0 )
            // InternalDataDescriptionLanguage.g:821:4: rule__BooleanLiteralRule__Group__0
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


    // $ANTLR start "entryRuleStringOrId"
    // InternalDataDescriptionLanguage.g:830:1: entryRuleStringOrId : ruleStringOrId EOF ;
    public final void entryRuleStringOrId() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:831:1: ( ruleStringOrId EOF )
            // InternalDataDescriptionLanguage.g:832:1: ruleStringOrId EOF
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
    // InternalDataDescriptionLanguage.g:839:1: ruleStringOrId : ( ( rule__StringOrId__Alternatives ) ) ;
    public final void ruleStringOrId() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:843:2: ( ( ( rule__StringOrId__Alternatives ) ) )
            // InternalDataDescriptionLanguage.g:844:2: ( ( rule__StringOrId__Alternatives ) )
            {
            // InternalDataDescriptionLanguage.g:844:2: ( ( rule__StringOrId__Alternatives ) )
            // InternalDataDescriptionLanguage.g:845:3: ( rule__StringOrId__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringOrIdAccess().getAlternatives()); 
            }
            // InternalDataDescriptionLanguage.g:846:3: ( rule__StringOrId__Alternatives )
            // InternalDataDescriptionLanguage.g:846:4: rule__StringOrId__Alternatives
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


    // $ANTLR start "ruleScaleType"
    // InternalDataDescriptionLanguage.g:855:1: ruleScaleType : ( ( rule__ScaleType__Alternatives ) ) ;
    public final void ruleScaleType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:859:1: ( ( ( rule__ScaleType__Alternatives ) ) )
            // InternalDataDescriptionLanguage.g:860:2: ( ( rule__ScaleType__Alternatives ) )
            {
            // InternalDataDescriptionLanguage.g:860:2: ( ( rule__ScaleType__Alternatives ) )
            // InternalDataDescriptionLanguage.g:861:3: ( rule__ScaleType__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScaleTypeAccess().getAlternatives()); 
            }
            // InternalDataDescriptionLanguage.g:862:3: ( rule__ScaleType__Alternatives )
            // InternalDataDescriptionLanguage.g:862:4: rule__ScaleType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__ScaleType__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getScaleTypeAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleScaleType"


    // $ANTLR start "ruleRepresentationType"
    // InternalDataDescriptionLanguage.g:871:1: ruleRepresentationType : ( ( rule__RepresentationType__Alternatives ) ) ;
    public final void ruleRepresentationType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:875:1: ( ( ( rule__RepresentationType__Alternatives ) ) )
            // InternalDataDescriptionLanguage.g:876:2: ( ( rule__RepresentationType__Alternatives ) )
            {
            // InternalDataDescriptionLanguage.g:876:2: ( ( rule__RepresentationType__Alternatives ) )
            // InternalDataDescriptionLanguage.g:877:3: ( rule__RepresentationType__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRepresentationTypeAccess().getAlternatives()); 
            }
            // InternalDataDescriptionLanguage.g:878:3: ( rule__RepresentationType__Alternatives )
            // InternalDataDescriptionLanguage.g:878:4: rule__RepresentationType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__RepresentationType__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRepresentationTypeAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRepresentationType"


    // $ANTLR start "ruleComparisonOperatorRule"
    // InternalDataDescriptionLanguage.g:887:1: ruleComparisonOperatorRule : ( ( rule__ComparisonOperatorRule__Alternatives ) ) ;
    public final void ruleComparisonOperatorRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:891:1: ( ( ( rule__ComparisonOperatorRule__Alternatives ) ) )
            // InternalDataDescriptionLanguage.g:892:2: ( ( rule__ComparisonOperatorRule__Alternatives ) )
            {
            // InternalDataDescriptionLanguage.g:892:2: ( ( rule__ComparisonOperatorRule__Alternatives ) )
            // InternalDataDescriptionLanguage.g:893:3: ( rule__ComparisonOperatorRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonOperatorRuleAccess().getAlternatives()); 
            }
            // InternalDataDescriptionLanguage.g:894:3: ( rule__ComparisonOperatorRule__Alternatives )
            // InternalDataDescriptionLanguage.g:894:4: rule__ComparisonOperatorRule__Alternatives
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
    // InternalDataDescriptionLanguage.g:903:1: ruleAddOrSubtractOperatorRule : ( ( rule__AddOrSubtractOperatorRule__Alternatives ) ) ;
    public final void ruleAddOrSubtractOperatorRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:907:1: ( ( ( rule__AddOrSubtractOperatorRule__Alternatives ) ) )
            // InternalDataDescriptionLanguage.g:908:2: ( ( rule__AddOrSubtractOperatorRule__Alternatives ) )
            {
            // InternalDataDescriptionLanguage.g:908:2: ( ( rule__AddOrSubtractOperatorRule__Alternatives ) )
            // InternalDataDescriptionLanguage.g:909:3: ( rule__AddOrSubtractOperatorRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOrSubtractOperatorRuleAccess().getAlternatives()); 
            }
            // InternalDataDescriptionLanguage.g:910:3: ( rule__AddOrSubtractOperatorRule__Alternatives )
            // InternalDataDescriptionLanguage.g:910:4: rule__AddOrSubtractOperatorRule__Alternatives
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
    // InternalDataDescriptionLanguage.g:919:1: ruleMultiplyDivideModuloOperatorRule : ( ( rule__MultiplyDivideModuloOperatorRule__Alternatives ) ) ;
    public final void ruleMultiplyDivideModuloOperatorRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:923:1: ( ( ( rule__MultiplyDivideModuloOperatorRule__Alternatives ) ) )
            // InternalDataDescriptionLanguage.g:924:2: ( ( rule__MultiplyDivideModuloOperatorRule__Alternatives ) )
            {
            // InternalDataDescriptionLanguage.g:924:2: ( ( rule__MultiplyDivideModuloOperatorRule__Alternatives ) )
            // InternalDataDescriptionLanguage.g:925:3: ( rule__MultiplyDivideModuloOperatorRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getAlternatives()); 
            }
            // InternalDataDescriptionLanguage.g:926:3: ( rule__MultiplyDivideModuloOperatorRule__Alternatives )
            // InternalDataDescriptionLanguage.g:926:4: rule__MultiplyDivideModuloOperatorRule__Alternatives
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
    // InternalDataDescriptionLanguage.g:935:1: ruleFactorRule : ( ( rule__FactorRule__Alternatives ) ) ;
    public final void ruleFactorRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:939:1: ( ( ( rule__FactorRule__Alternatives ) ) )
            // InternalDataDescriptionLanguage.g:940:2: ( ( rule__FactorRule__Alternatives ) )
            {
            // InternalDataDescriptionLanguage.g:940:2: ( ( rule__FactorRule__Alternatives ) )
            // InternalDataDescriptionLanguage.g:941:3: ( rule__FactorRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFactorRuleAccess().getAlternatives()); 
            }
            // InternalDataDescriptionLanguage.g:942:3: ( rule__FactorRule__Alternatives )
            // InternalDataDescriptionLanguage.g:942:4: rule__FactorRule__Alternatives
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


    // $ANTLR start "rule__DataDescriptionRule__Alternatives"
    // InternalDataDescriptionLanguage.g:950:1: rule__DataDescriptionRule__Alternatives : ( ( ruleTypedDataDescriptionRule ) | ( ruleUntypedDataDescriptionRule ) );
    public final void rule__DataDescriptionRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:954:1: ( ( ruleTypedDataDescriptionRule ) | ( ruleUntypedDataDescriptionRule ) )
            int alt1=2;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:955:2: ( ruleTypedDataDescriptionRule )
                    {
                    // InternalDataDescriptionLanguage.g:955:2: ( ruleTypedDataDescriptionRule )
                    // InternalDataDescriptionLanguage.g:956:3: ruleTypedDataDescriptionRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDataDescriptionRuleAccess().getTypedDataDescriptionRuleParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleTypedDataDescriptionRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDataDescriptionRuleAccess().getTypedDataDescriptionRuleParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalDataDescriptionLanguage.g:961:2: ( ruleUntypedDataDescriptionRule )
                    {
                    // InternalDataDescriptionLanguage.g:961:2: ( ruleUntypedDataDescriptionRule )
                    // InternalDataDescriptionLanguage.g:962:3: ruleUntypedDataDescriptionRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDataDescriptionRuleAccess().getUntypedDataDescriptionRuleParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleUntypedDataDescriptionRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDataDescriptionRuleAccess().getUntypedDataDescriptionRuleParserRuleCall_1()); 
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
    // $ANTLR end "rule__DataDescriptionRule__Alternatives"


    // $ANTLR start "rule__ValueReferenceRule__Alternatives"
    // InternalDataDescriptionLanguage.g:971:1: rule__ValueReferenceRule__Alternatives : ( ( ruleDataReferenceRule ) | ( ruleSelfReferenceRule ) );
    public final void rule__ValueReferenceRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:975:1: ( ( ruleDataReferenceRule ) | ( ruleSelfReferenceRule ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( ((LA2_0>=RULE_QUOTED_ID && LA2_0<=RULE_ID)) ) {
                alt2=1;
            }
            else if ( (LA2_0==65) ) {
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
                    // InternalDataDescriptionLanguage.g:976:2: ( ruleDataReferenceRule )
                    {
                    // InternalDataDescriptionLanguage.g:976:2: ( ruleDataReferenceRule )
                    // InternalDataDescriptionLanguage.g:977:3: ruleDataReferenceRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getValueReferenceRuleAccess().getDataReferenceRuleParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleDataReferenceRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getValueReferenceRuleAccess().getDataReferenceRuleParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalDataDescriptionLanguage.g:982:2: ( ruleSelfReferenceRule )
                    {
                    // InternalDataDescriptionLanguage.g:982:2: ( ruleSelfReferenceRule )
                    // InternalDataDescriptionLanguage.g:983:3: ruleSelfReferenceRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getValueReferenceRuleAccess().getSelfReferenceRuleParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleSelfReferenceRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getValueReferenceRuleAccess().getSelfReferenceRuleParserRuleCall_1()); 
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
    // $ANTLR end "rule__ValueReferenceRule__Alternatives"


    // $ANTLR start "rule__LiteralOrReferenceRule__Alternatives"
    // InternalDataDescriptionLanguage.g:992:1: rule__LiteralOrReferenceRule__Alternatives : ( ( ruleCallRule ) | ( ruleLiteralRule ) | ( ruleParanthesesRule ) | ( ruleValueReferenceRule ) );
    public final void rule__LiteralOrReferenceRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:996:1: ( ( ruleCallRule ) | ( ruleLiteralRule ) | ( ruleParanthesesRule ) | ( ruleValueReferenceRule ) )
            int alt3=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==70) ) {
                    alt3=1;
                }
                else if ( (LA3_1==EOF||(LA3_1>=24 && LA3_1<=34)||LA3_1==60||(LA3_1>=66 && LA3_1<=69)||(LA3_1>=71 && LA3_1<=72)) ) {
                    alt3=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_STRING:
            case RULE_DOUBLE:
            case RULE_INT:
            case 15:
            case 74:
                {
                alt3=2;
                }
                break;
            case 70:
                {
                alt3=3;
                }
                break;
            case RULE_QUOTED_ID:
            case 65:
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
                    // InternalDataDescriptionLanguage.g:997:2: ( ruleCallRule )
                    {
                    // InternalDataDescriptionLanguage.g:997:2: ( ruleCallRule )
                    // InternalDataDescriptionLanguage.g:998:3: ruleCallRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralOrReferenceRuleAccess().getCallRuleParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleCallRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLiteralOrReferenceRuleAccess().getCallRuleParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalDataDescriptionLanguage.g:1003:2: ( ruleLiteralRule )
                    {
                    // InternalDataDescriptionLanguage.g:1003:2: ( ruleLiteralRule )
                    // InternalDataDescriptionLanguage.g:1004:3: ruleLiteralRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralOrReferenceRuleAccess().getLiteralRuleParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleLiteralRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLiteralOrReferenceRuleAccess().getLiteralRuleParserRuleCall_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalDataDescriptionLanguage.g:1009:2: ( ruleParanthesesRule )
                    {
                    // InternalDataDescriptionLanguage.g:1009:2: ( ruleParanthesesRule )
                    // InternalDataDescriptionLanguage.g:1010:3: ruleParanthesesRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralOrReferenceRuleAccess().getParanthesesRuleParserRuleCall_2()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleParanthesesRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLiteralOrReferenceRuleAccess().getParanthesesRuleParserRuleCall_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalDataDescriptionLanguage.g:1015:2: ( ruleValueReferenceRule )
                    {
                    // InternalDataDescriptionLanguage.g:1015:2: ( ruleValueReferenceRule )
                    // InternalDataDescriptionLanguage.g:1016:3: ruleValueReferenceRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralOrReferenceRuleAccess().getValueReferenceRuleParserRuleCall_3()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleValueReferenceRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLiteralOrReferenceRuleAccess().getValueReferenceRuleParserRuleCall_3()); 
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
    // $ANTLR end "rule__LiteralOrReferenceRule__Alternatives"


    // $ANTLR start "rule__LiteralRule__Alternatives"
    // InternalDataDescriptionLanguage.g:1025:1: rule__LiteralRule__Alternatives : ( ( ruleNumberLiteralRule ) | ( ruleStringLiteralRule ) | ( ruleBooleanLiteralRule ) );
    public final void rule__LiteralRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1029:1: ( ( ruleNumberLiteralRule ) | ( ruleStringLiteralRule ) | ( ruleBooleanLiteralRule ) )
            int alt4=3;
            switch ( input.LA(1) ) {
            case RULE_DOUBLE:
            case RULE_INT:
                {
                alt4=1;
                }
                break;
            case RULE_STRING:
                {
                alt4=2;
                }
                break;
            case 15:
            case 74:
                {
                alt4=3;
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
                    // InternalDataDescriptionLanguage.g:1030:2: ( ruleNumberLiteralRule )
                    {
                    // InternalDataDescriptionLanguage.g:1030:2: ( ruleNumberLiteralRule )
                    // InternalDataDescriptionLanguage.g:1031:3: ruleNumberLiteralRule
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
                    // InternalDataDescriptionLanguage.g:1036:2: ( ruleStringLiteralRule )
                    {
                    // InternalDataDescriptionLanguage.g:1036:2: ( ruleStringLiteralRule )
                    // InternalDataDescriptionLanguage.g:1037:3: ruleStringLiteralRule
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
                    // InternalDataDescriptionLanguage.g:1042:2: ( ruleBooleanLiteralRule )
                    {
                    // InternalDataDescriptionLanguage.g:1042:2: ( ruleBooleanLiteralRule )
                    // InternalDataDescriptionLanguage.g:1043:3: ruleBooleanLiteralRule
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

            }
        }
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
    // InternalDataDescriptionLanguage.g:1052:1: rule__NumberLiteralRule__Alternatives : ( ( ruleDoubleLiteralRule ) | ( ruleIntegerLiteralRule ) );
    public final void rule__NumberLiteralRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1056:1: ( ( ruleDoubleLiteralRule ) | ( ruleIntegerLiteralRule ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_DOUBLE) ) {
                alt5=1;
            }
            else if ( (LA5_0==RULE_INT) ) {
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
                    // InternalDataDescriptionLanguage.g:1057:2: ( ruleDoubleLiteralRule )
                    {
                    // InternalDataDescriptionLanguage.g:1057:2: ( ruleDoubleLiteralRule )
                    // InternalDataDescriptionLanguage.g:1058:3: ruleDoubleLiteralRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getNumberLiteralRuleAccess().getDoubleLiteralRuleParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleDoubleLiteralRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getNumberLiteralRuleAccess().getDoubleLiteralRuleParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalDataDescriptionLanguage.g:1063:2: ( ruleIntegerLiteralRule )
                    {
                    // InternalDataDescriptionLanguage.g:1063:2: ( ruleIntegerLiteralRule )
                    // InternalDataDescriptionLanguage.g:1064:3: ruleIntegerLiteralRule
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
    // InternalDataDescriptionLanguage.g:1073:1: rule__BooleanLiteralRule__Alternatives_1 : ( ( ( rule__BooleanLiteralRule__ValueAssignment_1_0 ) ) | ( 'false' ) );
    public final void rule__BooleanLiteralRule__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1077:1: ( ( ( rule__BooleanLiteralRule__ValueAssignment_1_0 ) ) | ( 'false' ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==74) ) {
                alt6=1;
            }
            else if ( (LA6_0==15) ) {
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
                    // InternalDataDescriptionLanguage.g:1078:2: ( ( rule__BooleanLiteralRule__ValueAssignment_1_0 ) )
                    {
                    // InternalDataDescriptionLanguage.g:1078:2: ( ( rule__BooleanLiteralRule__ValueAssignment_1_0 ) )
                    // InternalDataDescriptionLanguage.g:1079:3: ( rule__BooleanLiteralRule__ValueAssignment_1_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBooleanLiteralRuleAccess().getValueAssignment_1_0()); 
                    }
                    // InternalDataDescriptionLanguage.g:1080:3: ( rule__BooleanLiteralRule__ValueAssignment_1_0 )
                    // InternalDataDescriptionLanguage.g:1080:4: rule__BooleanLiteralRule__ValueAssignment_1_0
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
                    // InternalDataDescriptionLanguage.g:1084:2: ( 'false' )
                    {
                    // InternalDataDescriptionLanguage.g:1084:2: ( 'false' )
                    // InternalDataDescriptionLanguage.g:1085:3: 'false'
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


    // $ANTLR start "rule__StringOrId__Alternatives"
    // InternalDataDescriptionLanguage.g:1094:1: rule__StringOrId__Alternatives : ( ( RULE_QUOTED_ID ) | ( RULE_ID ) );
    public final void rule__StringOrId__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1098:1: ( ( RULE_QUOTED_ID ) | ( RULE_ID ) )
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
                    // InternalDataDescriptionLanguage.g:1099:2: ( RULE_QUOTED_ID )
                    {
                    // InternalDataDescriptionLanguage.g:1099:2: ( RULE_QUOTED_ID )
                    // InternalDataDescriptionLanguage.g:1100:3: RULE_QUOTED_ID
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
                    // InternalDataDescriptionLanguage.g:1105:2: ( RULE_ID )
                    {
                    // InternalDataDescriptionLanguage.g:1105:2: ( RULE_ID )
                    // InternalDataDescriptionLanguage.g:1106:3: RULE_ID
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


    // $ANTLR start "rule__ScaleType__Alternatives"
    // InternalDataDescriptionLanguage.g:1115:1: rule__ScaleType__Alternatives : ( ( ( 'nominal' ) ) | ( ( 'ordinal' ) ) | ( ( 'cardinal' ) ) | ( ( 'quotient' ) ) );
    public final void rule__ScaleType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1119:1: ( ( ( 'nominal' ) ) | ( ( 'ordinal' ) ) | ( ( 'cardinal' ) ) | ( ( 'quotient' ) ) )
            int alt8=4;
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
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:1120:2: ( ( 'nominal' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1120:2: ( ( 'nominal' ) )
                    // InternalDataDescriptionLanguage.g:1121:3: ( 'nominal' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getScaleTypeAccess().getNominalEnumLiteralDeclaration_0()); 
                    }
                    // InternalDataDescriptionLanguage.g:1122:3: ( 'nominal' )
                    // InternalDataDescriptionLanguage.g:1122:4: 'nominal'
                    {
                    match(input,16,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getScaleTypeAccess().getNominalEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalDataDescriptionLanguage.g:1126:2: ( ( 'ordinal' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1126:2: ( ( 'ordinal' ) )
                    // InternalDataDescriptionLanguage.g:1127:3: ( 'ordinal' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getScaleTypeAccess().getOrdinalEnumLiteralDeclaration_1()); 
                    }
                    // InternalDataDescriptionLanguage.g:1128:3: ( 'ordinal' )
                    // InternalDataDescriptionLanguage.g:1128:4: 'ordinal'
                    {
                    match(input,17,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getScaleTypeAccess().getOrdinalEnumLiteralDeclaration_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalDataDescriptionLanguage.g:1132:2: ( ( 'cardinal' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1132:2: ( ( 'cardinal' ) )
                    // InternalDataDescriptionLanguage.g:1133:3: ( 'cardinal' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getScaleTypeAccess().getCardinalEnumLiteralDeclaration_2()); 
                    }
                    // InternalDataDescriptionLanguage.g:1134:3: ( 'cardinal' )
                    // InternalDataDescriptionLanguage.g:1134:4: 'cardinal'
                    {
                    match(input,18,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getScaleTypeAccess().getCardinalEnumLiteralDeclaration_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalDataDescriptionLanguage.g:1138:2: ( ( 'quotient' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1138:2: ( ( 'quotient' ) )
                    // InternalDataDescriptionLanguage.g:1139:3: ( 'quotient' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getScaleTypeAccess().getQuotientEnumLiteralDeclaration_3()); 
                    }
                    // InternalDataDescriptionLanguage.g:1140:3: ( 'quotient' )
                    // InternalDataDescriptionLanguage.g:1140:4: 'quotient'
                    {
                    match(input,19,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getScaleTypeAccess().getQuotientEnumLiteralDeclaration_3()); 
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
    // $ANTLR end "rule__ScaleType__Alternatives"


    // $ANTLR start "rule__RepresentationType__Alternatives"
    // InternalDataDescriptionLanguage.g:1148:1: rule__RepresentationType__Alternatives : ( ( ( 'real' ) ) | ( ( 'integer' ) ) | ( ( 'boolean' ) ) | ( ( 'string' ) ) );
    public final void rule__RepresentationType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1152:1: ( ( ( 'real' ) ) | ( ( 'integer' ) ) | ( ( 'boolean' ) ) | ( ( 'string' ) ) )
            int alt9=4;
            switch ( input.LA(1) ) {
            case 20:
                {
                alt9=1;
                }
                break;
            case 21:
                {
                alt9=2;
                }
                break;
            case 22:
                {
                alt9=3;
                }
                break;
            case 23:
                {
                alt9=4;
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
                    // InternalDataDescriptionLanguage.g:1153:2: ( ( 'real' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1153:2: ( ( 'real' ) )
                    // InternalDataDescriptionLanguage.g:1154:3: ( 'real' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRepresentationTypeAccess().getRealEnumLiteralDeclaration_0()); 
                    }
                    // InternalDataDescriptionLanguage.g:1155:3: ( 'real' )
                    // InternalDataDescriptionLanguage.g:1155:4: 'real'
                    {
                    match(input,20,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRepresentationTypeAccess().getRealEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalDataDescriptionLanguage.g:1159:2: ( ( 'integer' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1159:2: ( ( 'integer' ) )
                    // InternalDataDescriptionLanguage.g:1160:3: ( 'integer' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRepresentationTypeAccess().getIntegerEnumLiteralDeclaration_1()); 
                    }
                    // InternalDataDescriptionLanguage.g:1161:3: ( 'integer' )
                    // InternalDataDescriptionLanguage.g:1161:4: 'integer'
                    {
                    match(input,21,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRepresentationTypeAccess().getIntegerEnumLiteralDeclaration_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalDataDescriptionLanguage.g:1165:2: ( ( 'boolean' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1165:2: ( ( 'boolean' ) )
                    // InternalDataDescriptionLanguage.g:1166:3: ( 'boolean' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRepresentationTypeAccess().getBooleanEnumLiteralDeclaration_2()); 
                    }
                    // InternalDataDescriptionLanguage.g:1167:3: ( 'boolean' )
                    // InternalDataDescriptionLanguage.g:1167:4: 'boolean'
                    {
                    match(input,22,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRepresentationTypeAccess().getBooleanEnumLiteralDeclaration_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalDataDescriptionLanguage.g:1171:2: ( ( 'string' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1171:2: ( ( 'string' ) )
                    // InternalDataDescriptionLanguage.g:1172:3: ( 'string' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRepresentationTypeAccess().getStringEnumLiteralDeclaration_3()); 
                    }
                    // InternalDataDescriptionLanguage.g:1173:3: ( 'string' )
                    // InternalDataDescriptionLanguage.g:1173:4: 'string'
                    {
                    match(input,23,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRepresentationTypeAccess().getStringEnumLiteralDeclaration_3()); 
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
    // $ANTLR end "rule__RepresentationType__Alternatives"


    // $ANTLR start "rule__ComparisonOperatorRule__Alternatives"
    // InternalDataDescriptionLanguage.g:1181:1: rule__ComparisonOperatorRule__Alternatives : ( ( ( '>=' ) ) | ( ( '>' ) ) | ( ( '=' ) ) | ( ( '!=' ) ) | ( ( '<' ) ) | ( ( '<=' ) ) );
    public final void rule__ComparisonOperatorRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1185:1: ( ( ( '>=' ) ) | ( ( '>' ) ) | ( ( '=' ) ) | ( ( '!=' ) ) | ( ( '<' ) ) | ( ( '<=' ) ) )
            int alt10=6;
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
            case 27:
                {
                alt10=4;
                }
                break;
            case 28:
                {
                alt10=5;
                }
                break;
            case 29:
                {
                alt10=6;
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
                    // InternalDataDescriptionLanguage.g:1186:2: ( ( '>=' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1186:2: ( ( '>=' ) )
                    // InternalDataDescriptionLanguage.g:1187:3: ( '>=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getGreaterThanEnumLiteralDeclaration_0()); 
                    }
                    // InternalDataDescriptionLanguage.g:1188:3: ( '>=' )
                    // InternalDataDescriptionLanguage.g:1188:4: '>='
                    {
                    match(input,24,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getComparisonOperatorRuleAccess().getGreaterThanEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalDataDescriptionLanguage.g:1192:2: ( ( '>' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1192:2: ( ( '>' ) )
                    // InternalDataDescriptionLanguage.g:1193:3: ( '>' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getGreaterEqualEnumLiteralDeclaration_1()); 
                    }
                    // InternalDataDescriptionLanguage.g:1194:3: ( '>' )
                    // InternalDataDescriptionLanguage.g:1194:4: '>'
                    {
                    match(input,25,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getComparisonOperatorRuleAccess().getGreaterEqualEnumLiteralDeclaration_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalDataDescriptionLanguage.g:1198:2: ( ( '=' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1198:2: ( ( '=' ) )
                    // InternalDataDescriptionLanguage.g:1199:3: ( '=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getEqualEnumLiteralDeclaration_2()); 
                    }
                    // InternalDataDescriptionLanguage.g:1200:3: ( '=' )
                    // InternalDataDescriptionLanguage.g:1200:4: '='
                    {
                    match(input,26,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getComparisonOperatorRuleAccess().getEqualEnumLiteralDeclaration_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalDataDescriptionLanguage.g:1204:2: ( ( '!=' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1204:2: ( ( '!=' ) )
                    // InternalDataDescriptionLanguage.g:1205:3: ( '!=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getUnequalEnumLiteralDeclaration_3()); 
                    }
                    // InternalDataDescriptionLanguage.g:1206:3: ( '!=' )
                    // InternalDataDescriptionLanguage.g:1206:4: '!='
                    {
                    match(input,27,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getComparisonOperatorRuleAccess().getUnequalEnumLiteralDeclaration_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalDataDescriptionLanguage.g:1210:2: ( ( '<' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1210:2: ( ( '<' ) )
                    // InternalDataDescriptionLanguage.g:1211:3: ( '<' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getLessEqualEnumLiteralDeclaration_4()); 
                    }
                    // InternalDataDescriptionLanguage.g:1212:3: ( '<' )
                    // InternalDataDescriptionLanguage.g:1212:4: '<'
                    {
                    match(input,28,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getComparisonOperatorRuleAccess().getLessEqualEnumLiteralDeclaration_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalDataDescriptionLanguage.g:1216:2: ( ( '<=' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1216:2: ( ( '<=' ) )
                    // InternalDataDescriptionLanguage.g:1217:3: ( '<=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getLessThanEnumLiteralDeclaration_5()); 
                    }
                    // InternalDataDescriptionLanguage.g:1218:3: ( '<=' )
                    // InternalDataDescriptionLanguage.g:1218:4: '<='
                    {
                    match(input,29,FOLLOW_2); if (state.failed) return ;

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
    // InternalDataDescriptionLanguage.g:1226:1: rule__AddOrSubtractOperatorRule__Alternatives : ( ( ( '+' ) ) | ( ( '-' ) ) );
    public final void rule__AddOrSubtractOperatorRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1230:1: ( ( ( '+' ) ) | ( ( '-' ) ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==30) ) {
                alt11=1;
            }
            else if ( (LA11_0==31) ) {
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
                    // InternalDataDescriptionLanguage.g:1231:2: ( ( '+' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1231:2: ( ( '+' ) )
                    // InternalDataDescriptionLanguage.g:1232:3: ( '+' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAddOrSubtractOperatorRuleAccess().getAddEnumLiteralDeclaration_0()); 
                    }
                    // InternalDataDescriptionLanguage.g:1233:3: ( '+' )
                    // InternalDataDescriptionLanguage.g:1233:4: '+'
                    {
                    match(input,30,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAddOrSubtractOperatorRuleAccess().getAddEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalDataDescriptionLanguage.g:1237:2: ( ( '-' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1237:2: ( ( '-' ) )
                    // InternalDataDescriptionLanguage.g:1238:3: ( '-' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAddOrSubtractOperatorRuleAccess().getSubtractEnumLiteralDeclaration_1()); 
                    }
                    // InternalDataDescriptionLanguage.g:1239:3: ( '-' )
                    // InternalDataDescriptionLanguage.g:1239:4: '-'
                    {
                    match(input,31,FOLLOW_2); if (state.failed) return ;

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
    // InternalDataDescriptionLanguage.g:1247:1: rule__MultiplyDivideModuloOperatorRule__Alternatives : ( ( ( '*' ) ) | ( ( '/' ) ) | ( ( '%' ) ) );
    public final void rule__MultiplyDivideModuloOperatorRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1251:1: ( ( ( '*' ) ) | ( ( '/' ) ) | ( ( '%' ) ) )
            int alt12=3;
            switch ( input.LA(1) ) {
            case 32:
                {
                alt12=1;
                }
                break;
            case 33:
                {
                alt12=2;
                }
                break;
            case 34:
                {
                alt12=3;
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
                    // InternalDataDescriptionLanguage.g:1252:2: ( ( '*' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1252:2: ( ( '*' ) )
                    // InternalDataDescriptionLanguage.g:1253:3: ( '*' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getMultiplyEnumLiteralDeclaration_0()); 
                    }
                    // InternalDataDescriptionLanguage.g:1254:3: ( '*' )
                    // InternalDataDescriptionLanguage.g:1254:4: '*'
                    {
                    match(input,32,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getMultiplyEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalDataDescriptionLanguage.g:1258:2: ( ( '/' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1258:2: ( ( '/' ) )
                    // InternalDataDescriptionLanguage.g:1259:3: ( '/' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getDivideEnumLiteralDeclaration_1()); 
                    }
                    // InternalDataDescriptionLanguage.g:1260:3: ( '/' )
                    // InternalDataDescriptionLanguage.g:1260:4: '/'
                    {
                    match(input,33,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getDivideEnumLiteralDeclaration_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalDataDescriptionLanguage.g:1264:2: ( ( '%' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1264:2: ( ( '%' ) )
                    // InternalDataDescriptionLanguage.g:1265:3: ( '%' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getModuloEnumLiteralDeclaration_2()); 
                    }
                    // InternalDataDescriptionLanguage.g:1266:3: ( '%' )
                    // InternalDataDescriptionLanguage.g:1266:4: '%'
                    {
                    match(input,34,FOLLOW_2); if (state.failed) return ;

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
    // InternalDataDescriptionLanguage.g:1274:1: rule__FactorRule__Alternatives : ( ( ( 'Y' ) ) | ( ( 'Z' ) ) | ( ( 'E' ) ) | ( ( 'P' ) ) | ( ( 'T' ) ) | ( ( 'G' ) ) | ( ( 'M' ) ) | ( ( 'k' ) ) | ( ( 'h' ) ) | ( ( 'da' ) ) | ( ( 'd' ) ) | ( ( 'c' ) ) | ( ( 'm' ) ) | ( ( '\\u00B5' ) ) | ( ( 'n' ) ) | ( ( 'p' ) ) | ( ( 'f' ) ) | ( ( 'a' ) ) | ( ( 'z' ) ) | ( ( 'y' ) ) );
    public final void rule__FactorRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1278:1: ( ( ( 'Y' ) ) | ( ( 'Z' ) ) | ( ( 'E' ) ) | ( ( 'P' ) ) | ( ( 'T' ) ) | ( ( 'G' ) ) | ( ( 'M' ) ) | ( ( 'k' ) ) | ( ( 'h' ) ) | ( ( 'da' ) ) | ( ( 'd' ) ) | ( ( 'c' ) ) | ( ( 'm' ) ) | ( ( '\\u00B5' ) ) | ( ( 'n' ) ) | ( ( 'p' ) ) | ( ( 'f' ) ) | ( ( 'a' ) ) | ( ( 'z' ) ) | ( ( 'y' ) ) )
            int alt13=20;
            switch ( input.LA(1) ) {
            case 35:
                {
                alt13=1;
                }
                break;
            case 36:
                {
                alt13=2;
                }
                break;
            case 37:
                {
                alt13=3;
                }
                break;
            case 38:
                {
                alt13=4;
                }
                break;
            case 39:
                {
                alt13=5;
                }
                break;
            case 40:
                {
                alt13=6;
                }
                break;
            case 41:
                {
                alt13=7;
                }
                break;
            case 42:
                {
                alt13=8;
                }
                break;
            case 43:
                {
                alt13=9;
                }
                break;
            case 44:
                {
                alt13=10;
                }
                break;
            case 45:
                {
                alt13=11;
                }
                break;
            case 46:
                {
                alt13=12;
                }
                break;
            case 47:
                {
                alt13=13;
                }
                break;
            case 48:
                {
                alt13=14;
                }
                break;
            case 49:
                {
                alt13=15;
                }
                break;
            case 50:
                {
                alt13=16;
                }
                break;
            case 51:
                {
                alt13=17;
                }
                break;
            case 52:
                {
                alt13=18;
                }
                break;
            case 53:
                {
                alt13=19;
                }
                break;
            case 54:
                {
                alt13=20;
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
                    // InternalDataDescriptionLanguage.g:1279:2: ( ( 'Y' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1279:2: ( ( 'Y' ) )
                    // InternalDataDescriptionLanguage.g:1280:3: ( 'Y' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getYottaEnumLiteralDeclaration_0()); 
                    }
                    // InternalDataDescriptionLanguage.g:1281:3: ( 'Y' )
                    // InternalDataDescriptionLanguage.g:1281:4: 'Y'
                    {
                    match(input,35,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getYottaEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalDataDescriptionLanguage.g:1285:2: ( ( 'Z' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1285:2: ( ( 'Z' ) )
                    // InternalDataDescriptionLanguage.g:1286:3: ( 'Z' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getZettaEnumLiteralDeclaration_1()); 
                    }
                    // InternalDataDescriptionLanguage.g:1287:3: ( 'Z' )
                    // InternalDataDescriptionLanguage.g:1287:4: 'Z'
                    {
                    match(input,36,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getZettaEnumLiteralDeclaration_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalDataDescriptionLanguage.g:1291:2: ( ( 'E' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1291:2: ( ( 'E' ) )
                    // InternalDataDescriptionLanguage.g:1292:3: ( 'E' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getExaEnumLiteralDeclaration_2()); 
                    }
                    // InternalDataDescriptionLanguage.g:1293:3: ( 'E' )
                    // InternalDataDescriptionLanguage.g:1293:4: 'E'
                    {
                    match(input,37,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getExaEnumLiteralDeclaration_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalDataDescriptionLanguage.g:1297:2: ( ( 'P' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1297:2: ( ( 'P' ) )
                    // InternalDataDescriptionLanguage.g:1298:3: ( 'P' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getPetaEnumLiteralDeclaration_3()); 
                    }
                    // InternalDataDescriptionLanguage.g:1299:3: ( 'P' )
                    // InternalDataDescriptionLanguage.g:1299:4: 'P'
                    {
                    match(input,38,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getPetaEnumLiteralDeclaration_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalDataDescriptionLanguage.g:1303:2: ( ( 'T' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1303:2: ( ( 'T' ) )
                    // InternalDataDescriptionLanguage.g:1304:3: ( 'T' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getTeraEnumLiteralDeclaration_4()); 
                    }
                    // InternalDataDescriptionLanguage.g:1305:3: ( 'T' )
                    // InternalDataDescriptionLanguage.g:1305:4: 'T'
                    {
                    match(input,39,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getTeraEnumLiteralDeclaration_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalDataDescriptionLanguage.g:1309:2: ( ( 'G' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1309:2: ( ( 'G' ) )
                    // InternalDataDescriptionLanguage.g:1310:3: ( 'G' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getGigaEnumLiteralDeclaration_5()); 
                    }
                    // InternalDataDescriptionLanguage.g:1311:3: ( 'G' )
                    // InternalDataDescriptionLanguage.g:1311:4: 'G'
                    {
                    match(input,40,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getGigaEnumLiteralDeclaration_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalDataDescriptionLanguage.g:1315:2: ( ( 'M' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1315:2: ( ( 'M' ) )
                    // InternalDataDescriptionLanguage.g:1316:3: ( 'M' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getMegaEnumLiteralDeclaration_6()); 
                    }
                    // InternalDataDescriptionLanguage.g:1317:3: ( 'M' )
                    // InternalDataDescriptionLanguage.g:1317:4: 'M'
                    {
                    match(input,41,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getMegaEnumLiteralDeclaration_6()); 
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalDataDescriptionLanguage.g:1321:2: ( ( 'k' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1321:2: ( ( 'k' ) )
                    // InternalDataDescriptionLanguage.g:1322:3: ( 'k' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getKiloEnumLiteralDeclaration_7()); 
                    }
                    // InternalDataDescriptionLanguage.g:1323:3: ( 'k' )
                    // InternalDataDescriptionLanguage.g:1323:4: 'k'
                    {
                    match(input,42,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getKiloEnumLiteralDeclaration_7()); 
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalDataDescriptionLanguage.g:1327:2: ( ( 'h' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1327:2: ( ( 'h' ) )
                    // InternalDataDescriptionLanguage.g:1328:3: ( 'h' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getHectoEnumLiteralDeclaration_8()); 
                    }
                    // InternalDataDescriptionLanguage.g:1329:3: ( 'h' )
                    // InternalDataDescriptionLanguage.g:1329:4: 'h'
                    {
                    match(input,43,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getHectoEnumLiteralDeclaration_8()); 
                    }

                    }


                    }
                    break;
                case 10 :
                    // InternalDataDescriptionLanguage.g:1333:2: ( ( 'da' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1333:2: ( ( 'da' ) )
                    // InternalDataDescriptionLanguage.g:1334:3: ( 'da' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getDekaEnumLiteralDeclaration_9()); 
                    }
                    // InternalDataDescriptionLanguage.g:1335:3: ( 'da' )
                    // InternalDataDescriptionLanguage.g:1335:4: 'da'
                    {
                    match(input,44,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getDekaEnumLiteralDeclaration_9()); 
                    }

                    }


                    }
                    break;
                case 11 :
                    // InternalDataDescriptionLanguage.g:1339:2: ( ( 'd' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1339:2: ( ( 'd' ) )
                    // InternalDataDescriptionLanguage.g:1340:3: ( 'd' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getDeciEnumLiteralDeclaration_10()); 
                    }
                    // InternalDataDescriptionLanguage.g:1341:3: ( 'd' )
                    // InternalDataDescriptionLanguage.g:1341:4: 'd'
                    {
                    match(input,45,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getDeciEnumLiteralDeclaration_10()); 
                    }

                    }


                    }
                    break;
                case 12 :
                    // InternalDataDescriptionLanguage.g:1345:2: ( ( 'c' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1345:2: ( ( 'c' ) )
                    // InternalDataDescriptionLanguage.g:1346:3: ( 'c' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getCentiEnumLiteralDeclaration_11()); 
                    }
                    // InternalDataDescriptionLanguage.g:1347:3: ( 'c' )
                    // InternalDataDescriptionLanguage.g:1347:4: 'c'
                    {
                    match(input,46,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getCentiEnumLiteralDeclaration_11()); 
                    }

                    }


                    }
                    break;
                case 13 :
                    // InternalDataDescriptionLanguage.g:1351:2: ( ( 'm' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1351:2: ( ( 'm' ) )
                    // InternalDataDescriptionLanguage.g:1352:3: ( 'm' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getMilliEnumLiteralDeclaration_12()); 
                    }
                    // InternalDataDescriptionLanguage.g:1353:3: ( 'm' )
                    // InternalDataDescriptionLanguage.g:1353:4: 'm'
                    {
                    match(input,47,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getMilliEnumLiteralDeclaration_12()); 
                    }

                    }


                    }
                    break;
                case 14 :
                    // InternalDataDescriptionLanguage.g:1357:2: ( ( '\\u00B5' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1357:2: ( ( '\\u00B5' ) )
                    // InternalDataDescriptionLanguage.g:1358:3: ( '\\u00B5' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getMicroEnumLiteralDeclaration_13()); 
                    }
                    // InternalDataDescriptionLanguage.g:1359:3: ( '\\u00B5' )
                    // InternalDataDescriptionLanguage.g:1359:4: '\\u00B5'
                    {
                    match(input,48,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getMicroEnumLiteralDeclaration_13()); 
                    }

                    }


                    }
                    break;
                case 15 :
                    // InternalDataDescriptionLanguage.g:1363:2: ( ( 'n' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1363:2: ( ( 'n' ) )
                    // InternalDataDescriptionLanguage.g:1364:3: ( 'n' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getNanoEnumLiteralDeclaration_14()); 
                    }
                    // InternalDataDescriptionLanguage.g:1365:3: ( 'n' )
                    // InternalDataDescriptionLanguage.g:1365:4: 'n'
                    {
                    match(input,49,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getNanoEnumLiteralDeclaration_14()); 
                    }

                    }


                    }
                    break;
                case 16 :
                    // InternalDataDescriptionLanguage.g:1369:2: ( ( 'p' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1369:2: ( ( 'p' ) )
                    // InternalDataDescriptionLanguage.g:1370:3: ( 'p' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getPikoEnumLiteralDeclaration_15()); 
                    }
                    // InternalDataDescriptionLanguage.g:1371:3: ( 'p' )
                    // InternalDataDescriptionLanguage.g:1371:4: 'p'
                    {
                    match(input,50,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getPikoEnumLiteralDeclaration_15()); 
                    }

                    }


                    }
                    break;
                case 17 :
                    // InternalDataDescriptionLanguage.g:1375:2: ( ( 'f' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1375:2: ( ( 'f' ) )
                    // InternalDataDescriptionLanguage.g:1376:3: ( 'f' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getFemtoEnumLiteralDeclaration_16()); 
                    }
                    // InternalDataDescriptionLanguage.g:1377:3: ( 'f' )
                    // InternalDataDescriptionLanguage.g:1377:4: 'f'
                    {
                    match(input,51,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getFemtoEnumLiteralDeclaration_16()); 
                    }

                    }


                    }
                    break;
                case 18 :
                    // InternalDataDescriptionLanguage.g:1381:2: ( ( 'a' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1381:2: ( ( 'a' ) )
                    // InternalDataDescriptionLanguage.g:1382:3: ( 'a' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getAttoEnumLiteralDeclaration_17()); 
                    }
                    // InternalDataDescriptionLanguage.g:1383:3: ( 'a' )
                    // InternalDataDescriptionLanguage.g:1383:4: 'a'
                    {
                    match(input,52,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getAttoEnumLiteralDeclaration_17()); 
                    }

                    }


                    }
                    break;
                case 19 :
                    // InternalDataDescriptionLanguage.g:1387:2: ( ( 'z' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1387:2: ( ( 'z' ) )
                    // InternalDataDescriptionLanguage.g:1388:3: ( 'z' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getZeptoEnumLiteralDeclaration_18()); 
                    }
                    // InternalDataDescriptionLanguage.g:1389:3: ( 'z' )
                    // InternalDataDescriptionLanguage.g:1389:4: 'z'
                    {
                    match(input,53,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getZeptoEnumLiteralDeclaration_18()); 
                    }

                    }


                    }
                    break;
                case 20 :
                    // InternalDataDescriptionLanguage.g:1393:2: ( ( 'y' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1393:2: ( ( 'y' ) )
                    // InternalDataDescriptionLanguage.g:1394:3: ( 'y' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getYoctoEnumLiteralDeclaration_19()); 
                    }
                    // InternalDataDescriptionLanguage.g:1395:3: ( 'y' )
                    // InternalDataDescriptionLanguage.g:1395:4: 'y'
                    {
                    match(input,54,FOLLOW_2); if (state.failed) return ;

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


    // $ANTLR start "rule__DataDescriptionModelRule__Group__0"
    // InternalDataDescriptionLanguage.g:1403:1: rule__DataDescriptionModelRule__Group__0 : rule__DataDescriptionModelRule__Group__0__Impl rule__DataDescriptionModelRule__Group__1 ;
    public final void rule__DataDescriptionModelRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1407:1: ( rule__DataDescriptionModelRule__Group__0__Impl rule__DataDescriptionModelRule__Group__1 )
            // InternalDataDescriptionLanguage.g:1408:2: rule__DataDescriptionModelRule__Group__0__Impl rule__DataDescriptionModelRule__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__DataDescriptionModelRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__DataDescriptionModelRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataDescriptionModelRule__Group__0"


    // $ANTLR start "rule__DataDescriptionModelRule__Group__0__Impl"
    // InternalDataDescriptionLanguage.g:1415:1: rule__DataDescriptionModelRule__Group__0__Impl : ( () ) ;
    public final void rule__DataDescriptionModelRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1419:1: ( ( () ) )
            // InternalDataDescriptionLanguage.g:1420:1: ( () )
            {
            // InternalDataDescriptionLanguage.g:1420:1: ( () )
            // InternalDataDescriptionLanguage.g:1421:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getDataDescriptionModelAction_0()); 
            }
            // InternalDataDescriptionLanguage.g:1422:2: ()
            // InternalDataDescriptionLanguage.g:1422:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataDescriptionModelRuleAccess().getDataDescriptionModelAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataDescriptionModelRule__Group__0__Impl"


    // $ANTLR start "rule__DataDescriptionModelRule__Group__1"
    // InternalDataDescriptionLanguage.g:1430:1: rule__DataDescriptionModelRule__Group__1 : rule__DataDescriptionModelRule__Group__1__Impl rule__DataDescriptionModelRule__Group__2 ;
    public final void rule__DataDescriptionModelRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1434:1: ( rule__DataDescriptionModelRule__Group__1__Impl rule__DataDescriptionModelRule__Group__2 )
            // InternalDataDescriptionLanguage.g:1435:2: rule__DataDescriptionModelRule__Group__1__Impl rule__DataDescriptionModelRule__Group__2
            {
            pushFollow(FOLLOW_3);
            rule__DataDescriptionModelRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__DataDescriptionModelRule__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataDescriptionModelRule__Group__1"


    // $ANTLR start "rule__DataDescriptionModelRule__Group__1__Impl"
    // InternalDataDescriptionLanguage.g:1442:1: rule__DataDescriptionModelRule__Group__1__Impl : ( ( rule__DataDescriptionModelRule__UsesAssignment_1 )* ) ;
    public final void rule__DataDescriptionModelRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1446:1: ( ( ( rule__DataDescriptionModelRule__UsesAssignment_1 )* ) )
            // InternalDataDescriptionLanguage.g:1447:1: ( ( rule__DataDescriptionModelRule__UsesAssignment_1 )* )
            {
            // InternalDataDescriptionLanguage.g:1447:1: ( ( rule__DataDescriptionModelRule__UsesAssignment_1 )* )
            // InternalDataDescriptionLanguage.g:1448:2: ( rule__DataDescriptionModelRule__UsesAssignment_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getUsesAssignment_1()); 
            }
            // InternalDataDescriptionLanguage.g:1449:2: ( rule__DataDescriptionModelRule__UsesAssignment_1 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==59) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:1449:3: rule__DataDescriptionModelRule__UsesAssignment_1
            	    {
            	    pushFollow(FOLLOW_4);
            	    rule__DataDescriptionModelRule__UsesAssignment_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataDescriptionModelRuleAccess().getUsesAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataDescriptionModelRule__Group__1__Impl"


    // $ANTLR start "rule__DataDescriptionModelRule__Group__2"
    // InternalDataDescriptionLanguage.g:1457:1: rule__DataDescriptionModelRule__Group__2 : rule__DataDescriptionModelRule__Group__2__Impl rule__DataDescriptionModelRule__Group__3 ;
    public final void rule__DataDescriptionModelRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1461:1: ( rule__DataDescriptionModelRule__Group__2__Impl rule__DataDescriptionModelRule__Group__3 )
            // InternalDataDescriptionLanguage.g:1462:2: rule__DataDescriptionModelRule__Group__2__Impl rule__DataDescriptionModelRule__Group__3
            {
            pushFollow(FOLLOW_3);
            rule__DataDescriptionModelRule__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__DataDescriptionModelRule__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataDescriptionModelRule__Group__2"


    // $ANTLR start "rule__DataDescriptionModelRule__Group__2__Impl"
    // InternalDataDescriptionLanguage.g:1469:1: rule__DataDescriptionModelRule__Group__2__Impl : ( ( rule__DataDescriptionModelRule__Group_2__0 )? ) ;
    public final void rule__DataDescriptionModelRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1473:1: ( ( ( rule__DataDescriptionModelRule__Group_2__0 )? ) )
            // InternalDataDescriptionLanguage.g:1474:1: ( ( rule__DataDescriptionModelRule__Group_2__0 )? )
            {
            // InternalDataDescriptionLanguage.g:1474:1: ( ( rule__DataDescriptionModelRule__Group_2__0 )? )
            // InternalDataDescriptionLanguage.g:1475:2: ( rule__DataDescriptionModelRule__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getGroup_2()); 
            }
            // InternalDataDescriptionLanguage.g:1476:2: ( rule__DataDescriptionModelRule__Group_2__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==55) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:1476:3: rule__DataDescriptionModelRule__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataDescriptionModelRule__Group_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataDescriptionModelRuleAccess().getGroup_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataDescriptionModelRule__Group__2__Impl"


    // $ANTLR start "rule__DataDescriptionModelRule__Group__3"
    // InternalDataDescriptionLanguage.g:1484:1: rule__DataDescriptionModelRule__Group__3 : rule__DataDescriptionModelRule__Group__3__Impl rule__DataDescriptionModelRule__Group__4 ;
    public final void rule__DataDescriptionModelRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1488:1: ( rule__DataDescriptionModelRule__Group__3__Impl rule__DataDescriptionModelRule__Group__4 )
            // InternalDataDescriptionLanguage.g:1489:2: rule__DataDescriptionModelRule__Group__3__Impl rule__DataDescriptionModelRule__Group__4
            {
            pushFollow(FOLLOW_3);
            rule__DataDescriptionModelRule__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__DataDescriptionModelRule__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataDescriptionModelRule__Group__3"


    // $ANTLR start "rule__DataDescriptionModelRule__Group__3__Impl"
    // InternalDataDescriptionLanguage.g:1496:1: rule__DataDescriptionModelRule__Group__3__Impl : ( ( rule__DataDescriptionModelRule__Group_3__0 )? ) ;
    public final void rule__DataDescriptionModelRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1500:1: ( ( ( rule__DataDescriptionModelRule__Group_3__0 )? ) )
            // InternalDataDescriptionLanguage.g:1501:1: ( ( rule__DataDescriptionModelRule__Group_3__0 )? )
            {
            // InternalDataDescriptionLanguage.g:1501:1: ( ( rule__DataDescriptionModelRule__Group_3__0 )? )
            // InternalDataDescriptionLanguage.g:1502:2: ( rule__DataDescriptionModelRule__Group_3__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getGroup_3()); 
            }
            // InternalDataDescriptionLanguage.g:1503:2: ( rule__DataDescriptionModelRule__Group_3__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==57) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:1503:3: rule__DataDescriptionModelRule__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataDescriptionModelRule__Group_3__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataDescriptionModelRuleAccess().getGroup_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataDescriptionModelRule__Group__3__Impl"


    // $ANTLR start "rule__DataDescriptionModelRule__Group__4"
    // InternalDataDescriptionLanguage.g:1511:1: rule__DataDescriptionModelRule__Group__4 : rule__DataDescriptionModelRule__Group__4__Impl ;
    public final void rule__DataDescriptionModelRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1515:1: ( rule__DataDescriptionModelRule__Group__4__Impl )
            // InternalDataDescriptionLanguage.g:1516:2: rule__DataDescriptionModelRule__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataDescriptionModelRule__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataDescriptionModelRule__Group__4"


    // $ANTLR start "rule__DataDescriptionModelRule__Group__4__Impl"
    // InternalDataDescriptionLanguage.g:1522:1: rule__DataDescriptionModelRule__Group__4__Impl : ( ( rule__DataDescriptionModelRule__Group_4__0 )? ) ;
    public final void rule__DataDescriptionModelRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1526:1: ( ( ( rule__DataDescriptionModelRule__Group_4__0 )? ) )
            // InternalDataDescriptionLanguage.g:1527:1: ( ( rule__DataDescriptionModelRule__Group_4__0 )? )
            {
            // InternalDataDescriptionLanguage.g:1527:1: ( ( rule__DataDescriptionModelRule__Group_4__0 )? )
            // InternalDataDescriptionLanguage.g:1528:2: ( rule__DataDescriptionModelRule__Group_4__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getGroup_4()); 
            }
            // InternalDataDescriptionLanguage.g:1529:2: ( rule__DataDescriptionModelRule__Group_4__0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==58) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:1529:3: rule__DataDescriptionModelRule__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataDescriptionModelRule__Group_4__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataDescriptionModelRuleAccess().getGroup_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataDescriptionModelRule__Group__4__Impl"


    // $ANTLR start "rule__DataDescriptionModelRule__Group_2__0"
    // InternalDataDescriptionLanguage.g:1538:1: rule__DataDescriptionModelRule__Group_2__0 : rule__DataDescriptionModelRule__Group_2__0__Impl rule__DataDescriptionModelRule__Group_2__1 ;
    public final void rule__DataDescriptionModelRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1542:1: ( rule__DataDescriptionModelRule__Group_2__0__Impl rule__DataDescriptionModelRule__Group_2__1 )
            // InternalDataDescriptionLanguage.g:1543:2: rule__DataDescriptionModelRule__Group_2__0__Impl rule__DataDescriptionModelRule__Group_2__1
            {
            pushFollow(FOLLOW_5);
            rule__DataDescriptionModelRule__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__DataDescriptionModelRule__Group_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataDescriptionModelRule__Group_2__0"


    // $ANTLR start "rule__DataDescriptionModelRule__Group_2__0__Impl"
    // InternalDataDescriptionLanguage.g:1550:1: rule__DataDescriptionModelRule__Group_2__0__Impl : ( 'types' ) ;
    public final void rule__DataDescriptionModelRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1554:1: ( ( 'types' ) )
            // InternalDataDescriptionLanguage.g:1555:1: ( 'types' )
            {
            // InternalDataDescriptionLanguage.g:1555:1: ( 'types' )
            // InternalDataDescriptionLanguage.g:1556:2: 'types'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getTypesKeyword_2_0()); 
            }
            match(input,55,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataDescriptionModelRuleAccess().getTypesKeyword_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataDescriptionModelRule__Group_2__0__Impl"


    // $ANTLR start "rule__DataDescriptionModelRule__Group_2__1"
    // InternalDataDescriptionLanguage.g:1565:1: rule__DataDescriptionModelRule__Group_2__1 : rule__DataDescriptionModelRule__Group_2__1__Impl rule__DataDescriptionModelRule__Group_2__2 ;
    public final void rule__DataDescriptionModelRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1569:1: ( rule__DataDescriptionModelRule__Group_2__1__Impl rule__DataDescriptionModelRule__Group_2__2 )
            // InternalDataDescriptionLanguage.g:1570:2: rule__DataDescriptionModelRule__Group_2__1__Impl rule__DataDescriptionModelRule__Group_2__2
            {
            pushFollow(FOLLOW_6);
            rule__DataDescriptionModelRule__Group_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__DataDescriptionModelRule__Group_2__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataDescriptionModelRule__Group_2__1"


    // $ANTLR start "rule__DataDescriptionModelRule__Group_2__1__Impl"
    // InternalDataDescriptionLanguage.g:1577:1: rule__DataDescriptionModelRule__Group_2__1__Impl : ( ':' ) ;
    public final void rule__DataDescriptionModelRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1581:1: ( ( ':' ) )
            // InternalDataDescriptionLanguage.g:1582:1: ( ':' )
            {
            // InternalDataDescriptionLanguage.g:1582:1: ( ':' )
            // InternalDataDescriptionLanguage.g:1583:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getColonKeyword_2_1()); 
            }
            match(input,56,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataDescriptionModelRuleAccess().getColonKeyword_2_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataDescriptionModelRule__Group_2__1__Impl"


    // $ANTLR start "rule__DataDescriptionModelRule__Group_2__2"
    // InternalDataDescriptionLanguage.g:1592:1: rule__DataDescriptionModelRule__Group_2__2 : rule__DataDescriptionModelRule__Group_2__2__Impl ;
    public final void rule__DataDescriptionModelRule__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1596:1: ( rule__DataDescriptionModelRule__Group_2__2__Impl )
            // InternalDataDescriptionLanguage.g:1597:2: rule__DataDescriptionModelRule__Group_2__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataDescriptionModelRule__Group_2__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataDescriptionModelRule__Group_2__2"


    // $ANTLR start "rule__DataDescriptionModelRule__Group_2__2__Impl"
    // InternalDataDescriptionLanguage.g:1603:1: rule__DataDescriptionModelRule__Group_2__2__Impl : ( ( rule__DataDescriptionModelRule__TypesAssignment_2_2 )* ) ;
    public final void rule__DataDescriptionModelRule__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1607:1: ( ( ( rule__DataDescriptionModelRule__TypesAssignment_2_2 )* ) )
            // InternalDataDescriptionLanguage.g:1608:1: ( ( rule__DataDescriptionModelRule__TypesAssignment_2_2 )* )
            {
            // InternalDataDescriptionLanguage.g:1608:1: ( ( rule__DataDescriptionModelRule__TypesAssignment_2_2 )* )
            // InternalDataDescriptionLanguage.g:1609:2: ( rule__DataDescriptionModelRule__TypesAssignment_2_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getTypesAssignment_2_2()); 
            }
            // InternalDataDescriptionLanguage.g:1610:2: ( rule__DataDescriptionModelRule__TypesAssignment_2_2 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>=16 && LA18_0<=19)) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:1610:3: rule__DataDescriptionModelRule__TypesAssignment_2_2
            	    {
            	    pushFollow(FOLLOW_7);
            	    rule__DataDescriptionModelRule__TypesAssignment_2_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataDescriptionModelRuleAccess().getTypesAssignment_2_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataDescriptionModelRule__Group_2__2__Impl"


    // $ANTLR start "rule__DataDescriptionModelRule__Group_3__0"
    // InternalDataDescriptionLanguage.g:1619:1: rule__DataDescriptionModelRule__Group_3__0 : rule__DataDescriptionModelRule__Group_3__0__Impl rule__DataDescriptionModelRule__Group_3__1 ;
    public final void rule__DataDescriptionModelRule__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1623:1: ( rule__DataDescriptionModelRule__Group_3__0__Impl rule__DataDescriptionModelRule__Group_3__1 )
            // InternalDataDescriptionLanguage.g:1624:2: rule__DataDescriptionModelRule__Group_3__0__Impl rule__DataDescriptionModelRule__Group_3__1
            {
            pushFollow(FOLLOW_5);
            rule__DataDescriptionModelRule__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__DataDescriptionModelRule__Group_3__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataDescriptionModelRule__Group_3__0"


    // $ANTLR start "rule__DataDescriptionModelRule__Group_3__0__Impl"
    // InternalDataDescriptionLanguage.g:1631:1: rule__DataDescriptionModelRule__Group_3__0__Impl : ( 'data' ) ;
    public final void rule__DataDescriptionModelRule__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1635:1: ( ( 'data' ) )
            // InternalDataDescriptionLanguage.g:1636:1: ( 'data' )
            {
            // InternalDataDescriptionLanguage.g:1636:1: ( 'data' )
            // InternalDataDescriptionLanguage.g:1637:2: 'data'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getDataKeyword_3_0()); 
            }
            match(input,57,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataDescriptionModelRuleAccess().getDataKeyword_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataDescriptionModelRule__Group_3__0__Impl"


    // $ANTLR start "rule__DataDescriptionModelRule__Group_3__1"
    // InternalDataDescriptionLanguage.g:1646:1: rule__DataDescriptionModelRule__Group_3__1 : rule__DataDescriptionModelRule__Group_3__1__Impl rule__DataDescriptionModelRule__Group_3__2 ;
    public final void rule__DataDescriptionModelRule__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1650:1: ( rule__DataDescriptionModelRule__Group_3__1__Impl rule__DataDescriptionModelRule__Group_3__2 )
            // InternalDataDescriptionLanguage.g:1651:2: rule__DataDescriptionModelRule__Group_3__1__Impl rule__DataDescriptionModelRule__Group_3__2
            {
            pushFollow(FOLLOW_8);
            rule__DataDescriptionModelRule__Group_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__DataDescriptionModelRule__Group_3__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataDescriptionModelRule__Group_3__1"


    // $ANTLR start "rule__DataDescriptionModelRule__Group_3__1__Impl"
    // InternalDataDescriptionLanguage.g:1658:1: rule__DataDescriptionModelRule__Group_3__1__Impl : ( ':' ) ;
    public final void rule__DataDescriptionModelRule__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1662:1: ( ( ':' ) )
            // InternalDataDescriptionLanguage.g:1663:1: ( ':' )
            {
            // InternalDataDescriptionLanguage.g:1663:1: ( ':' )
            // InternalDataDescriptionLanguage.g:1664:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getColonKeyword_3_1()); 
            }
            match(input,56,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataDescriptionModelRuleAccess().getColonKeyword_3_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataDescriptionModelRule__Group_3__1__Impl"


    // $ANTLR start "rule__DataDescriptionModelRule__Group_3__2"
    // InternalDataDescriptionLanguage.g:1673:1: rule__DataDescriptionModelRule__Group_3__2 : rule__DataDescriptionModelRule__Group_3__2__Impl ;
    public final void rule__DataDescriptionModelRule__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1677:1: ( rule__DataDescriptionModelRule__Group_3__2__Impl )
            // InternalDataDescriptionLanguage.g:1678:2: rule__DataDescriptionModelRule__Group_3__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataDescriptionModelRule__Group_3__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataDescriptionModelRule__Group_3__2"


    // $ANTLR start "rule__DataDescriptionModelRule__Group_3__2__Impl"
    // InternalDataDescriptionLanguage.g:1684:1: rule__DataDescriptionModelRule__Group_3__2__Impl : ( ( rule__DataDescriptionModelRule__DescriptionsAssignment_3_2 )* ) ;
    public final void rule__DataDescriptionModelRule__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1688:1: ( ( ( rule__DataDescriptionModelRule__DescriptionsAssignment_3_2 )* ) )
            // InternalDataDescriptionLanguage.g:1689:1: ( ( rule__DataDescriptionModelRule__DescriptionsAssignment_3_2 )* )
            {
            // InternalDataDescriptionLanguage.g:1689:1: ( ( rule__DataDescriptionModelRule__DescriptionsAssignment_3_2 )* )
            // InternalDataDescriptionLanguage.g:1690:2: ( rule__DataDescriptionModelRule__DescriptionsAssignment_3_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getDescriptionsAssignment_3_2()); 
            }
            // InternalDataDescriptionLanguage.g:1691:2: ( rule__DataDescriptionModelRule__DescriptionsAssignment_3_2 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>=16 && LA19_0<=23)) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:1691:3: rule__DataDescriptionModelRule__DescriptionsAssignment_3_2
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__DataDescriptionModelRule__DescriptionsAssignment_3_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataDescriptionModelRuleAccess().getDescriptionsAssignment_3_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataDescriptionModelRule__Group_3__2__Impl"


    // $ANTLR start "rule__DataDescriptionModelRule__Group_4__0"
    // InternalDataDescriptionLanguage.g:1700:1: rule__DataDescriptionModelRule__Group_4__0 : rule__DataDescriptionModelRule__Group_4__0__Impl rule__DataDescriptionModelRule__Group_4__1 ;
    public final void rule__DataDescriptionModelRule__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1704:1: ( rule__DataDescriptionModelRule__Group_4__0__Impl rule__DataDescriptionModelRule__Group_4__1 )
            // InternalDataDescriptionLanguage.g:1705:2: rule__DataDescriptionModelRule__Group_4__0__Impl rule__DataDescriptionModelRule__Group_4__1
            {
            pushFollow(FOLLOW_5);
            rule__DataDescriptionModelRule__Group_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__DataDescriptionModelRule__Group_4__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataDescriptionModelRule__Group_4__0"


    // $ANTLR start "rule__DataDescriptionModelRule__Group_4__0__Impl"
    // InternalDataDescriptionLanguage.g:1712:1: rule__DataDescriptionModelRule__Group_4__0__Impl : ( 'constraints' ) ;
    public final void rule__DataDescriptionModelRule__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1716:1: ( ( 'constraints' ) )
            // InternalDataDescriptionLanguage.g:1717:1: ( 'constraints' )
            {
            // InternalDataDescriptionLanguage.g:1717:1: ( 'constraints' )
            // InternalDataDescriptionLanguage.g:1718:2: 'constraints'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getConstraintsKeyword_4_0()); 
            }
            match(input,58,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataDescriptionModelRuleAccess().getConstraintsKeyword_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataDescriptionModelRule__Group_4__0__Impl"


    // $ANTLR start "rule__DataDescriptionModelRule__Group_4__1"
    // InternalDataDescriptionLanguage.g:1727:1: rule__DataDescriptionModelRule__Group_4__1 : rule__DataDescriptionModelRule__Group_4__1__Impl rule__DataDescriptionModelRule__Group_4__2 ;
    public final void rule__DataDescriptionModelRule__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1731:1: ( rule__DataDescriptionModelRule__Group_4__1__Impl rule__DataDescriptionModelRule__Group_4__2 )
            // InternalDataDescriptionLanguage.g:1732:2: rule__DataDescriptionModelRule__Group_4__1__Impl rule__DataDescriptionModelRule__Group_4__2
            {
            pushFollow(FOLLOW_10);
            rule__DataDescriptionModelRule__Group_4__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__DataDescriptionModelRule__Group_4__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataDescriptionModelRule__Group_4__1"


    // $ANTLR start "rule__DataDescriptionModelRule__Group_4__1__Impl"
    // InternalDataDescriptionLanguage.g:1739:1: rule__DataDescriptionModelRule__Group_4__1__Impl : ( ':' ) ;
    public final void rule__DataDescriptionModelRule__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1743:1: ( ( ':' ) )
            // InternalDataDescriptionLanguage.g:1744:1: ( ':' )
            {
            // InternalDataDescriptionLanguage.g:1744:1: ( ':' )
            // InternalDataDescriptionLanguage.g:1745:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getColonKeyword_4_1()); 
            }
            match(input,56,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataDescriptionModelRuleAccess().getColonKeyword_4_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataDescriptionModelRule__Group_4__1__Impl"


    // $ANTLR start "rule__DataDescriptionModelRule__Group_4__2"
    // InternalDataDescriptionLanguage.g:1754:1: rule__DataDescriptionModelRule__Group_4__2 : rule__DataDescriptionModelRule__Group_4__2__Impl ;
    public final void rule__DataDescriptionModelRule__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1758:1: ( rule__DataDescriptionModelRule__Group_4__2__Impl )
            // InternalDataDescriptionLanguage.g:1759:2: rule__DataDescriptionModelRule__Group_4__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataDescriptionModelRule__Group_4__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataDescriptionModelRule__Group_4__2"


    // $ANTLR start "rule__DataDescriptionModelRule__Group_4__2__Impl"
    // InternalDataDescriptionLanguage.g:1765:1: rule__DataDescriptionModelRule__Group_4__2__Impl : ( ( rule__DataDescriptionModelRule__ConstraintsAssignment_4_2 )* ) ;
    public final void rule__DataDescriptionModelRule__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1769:1: ( ( ( rule__DataDescriptionModelRule__ConstraintsAssignment_4_2 )* ) )
            // InternalDataDescriptionLanguage.g:1770:1: ( ( rule__DataDescriptionModelRule__ConstraintsAssignment_4_2 )* )
            {
            // InternalDataDescriptionLanguage.g:1770:1: ( ( rule__DataDescriptionModelRule__ConstraintsAssignment_4_2 )* )
            // InternalDataDescriptionLanguage.g:1771:2: ( rule__DataDescriptionModelRule__ConstraintsAssignment_4_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getConstraintsAssignment_4_2()); 
            }
            // InternalDataDescriptionLanguage.g:1772:2: ( rule__DataDescriptionModelRule__ConstraintsAssignment_4_2 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>=RULE_QUOTED_ID && LA20_0<=RULE_INT)||LA20_0==15||(LA20_0>=30 && LA20_0<=31)||LA20_0==65||LA20_0==70||(LA20_0>=73 && LA20_0<=74)) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:1772:3: rule__DataDescriptionModelRule__ConstraintsAssignment_4_2
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__DataDescriptionModelRule__ConstraintsAssignment_4_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataDescriptionModelRuleAccess().getConstraintsAssignment_4_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataDescriptionModelRule__Group_4__2__Impl"


    // $ANTLR start "rule__UseRule__Group__0"
    // InternalDataDescriptionLanguage.g:1781:1: rule__UseRule__Group__0 : rule__UseRule__Group__0__Impl rule__UseRule__Group__1 ;
    public final void rule__UseRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1785:1: ( rule__UseRule__Group__0__Impl rule__UseRule__Group__1 )
            // InternalDataDescriptionLanguage.g:1786:2: rule__UseRule__Group__0__Impl rule__UseRule__Group__1
            {
            pushFollow(FOLLOW_12);
            rule__UseRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__UseRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UseRule__Group__0"


    // $ANTLR start "rule__UseRule__Group__0__Impl"
    // InternalDataDescriptionLanguage.g:1793:1: rule__UseRule__Group__0__Impl : ( 'use' ) ;
    public final void rule__UseRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1797:1: ( ( 'use' ) )
            // InternalDataDescriptionLanguage.g:1798:1: ( 'use' )
            {
            // InternalDataDescriptionLanguage.g:1798:1: ( 'use' )
            // InternalDataDescriptionLanguage.g:1799:2: 'use'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUseRuleAccess().getUseKeyword_0()); 
            }
            match(input,59,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUseRuleAccess().getUseKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UseRule__Group__0__Impl"


    // $ANTLR start "rule__UseRule__Group__1"
    // InternalDataDescriptionLanguage.g:1808:1: rule__UseRule__Group__1 : rule__UseRule__Group__1__Impl rule__UseRule__Group__2 ;
    public final void rule__UseRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1812:1: ( rule__UseRule__Group__1__Impl rule__UseRule__Group__2 )
            // InternalDataDescriptionLanguage.g:1813:2: rule__UseRule__Group__1__Impl rule__UseRule__Group__2
            {
            pushFollow(FOLLOW_13);
            rule__UseRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__UseRule__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UseRule__Group__1"


    // $ANTLR start "rule__UseRule__Group__1__Impl"
    // InternalDataDescriptionLanguage.g:1820:1: rule__UseRule__Group__1__Impl : ( ( rule__UseRule__ImportURIAssignment_1 ) ) ;
    public final void rule__UseRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1824:1: ( ( ( rule__UseRule__ImportURIAssignment_1 ) ) )
            // InternalDataDescriptionLanguage.g:1825:1: ( ( rule__UseRule__ImportURIAssignment_1 ) )
            {
            // InternalDataDescriptionLanguage.g:1825:1: ( ( rule__UseRule__ImportURIAssignment_1 ) )
            // InternalDataDescriptionLanguage.g:1826:2: ( rule__UseRule__ImportURIAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUseRuleAccess().getImportURIAssignment_1()); 
            }
            // InternalDataDescriptionLanguage.g:1827:2: ( rule__UseRule__ImportURIAssignment_1 )
            // InternalDataDescriptionLanguage.g:1827:3: rule__UseRule__ImportURIAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__UseRule__ImportURIAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getUseRuleAccess().getImportURIAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UseRule__Group__1__Impl"


    // $ANTLR start "rule__UseRule__Group__2"
    // InternalDataDescriptionLanguage.g:1835:1: rule__UseRule__Group__2 : rule__UseRule__Group__2__Impl ;
    public final void rule__UseRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1839:1: ( rule__UseRule__Group__2__Impl )
            // InternalDataDescriptionLanguage.g:1840:2: rule__UseRule__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__UseRule__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UseRule__Group__2"


    // $ANTLR start "rule__UseRule__Group__2__Impl"
    // InternalDataDescriptionLanguage.g:1846:1: rule__UseRule__Group__2__Impl : ( ';' ) ;
    public final void rule__UseRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1850:1: ( ( ';' ) )
            // InternalDataDescriptionLanguage.g:1851:1: ( ';' )
            {
            // InternalDataDescriptionLanguage.g:1851:1: ( ';' )
            // InternalDataDescriptionLanguage.g:1852:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUseRuleAccess().getSemicolonKeyword_2()); 
            }
            match(input,60,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUseRuleAccess().getSemicolonKeyword_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UseRule__Group__2__Impl"


    // $ANTLR start "rule__DataTypeRule__Group__0"
    // InternalDataDescriptionLanguage.g:1862:1: rule__DataTypeRule__Group__0 : rule__DataTypeRule__Group__0__Impl rule__DataTypeRule__Group__1 ;
    public final void rule__DataTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1866:1: ( rule__DataTypeRule__Group__0__Impl rule__DataTypeRule__Group__1 )
            // InternalDataDescriptionLanguage.g:1867:2: rule__DataTypeRule__Group__0__Impl rule__DataTypeRule__Group__1
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
    // InternalDataDescriptionLanguage.g:1874:1: rule__DataTypeRule__Group__0__Impl : ( ( rule__DataTypeRule__ScaleAssignment_0 ) ) ;
    public final void rule__DataTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1878:1: ( ( ( rule__DataTypeRule__ScaleAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:1879:1: ( ( rule__DataTypeRule__ScaleAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:1879:1: ( ( rule__DataTypeRule__ScaleAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:1880:2: ( rule__DataTypeRule__ScaleAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getScaleAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:1881:2: ( rule__DataTypeRule__ScaleAssignment_0 )
            // InternalDataDescriptionLanguage.g:1881:3: rule__DataTypeRule__ScaleAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__DataTypeRule__ScaleAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataTypeRuleAccess().getScaleAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeRule__Group__0__Impl"


    // $ANTLR start "rule__DataTypeRule__Group__1"
    // InternalDataDescriptionLanguage.g:1889:1: rule__DataTypeRule__Group__1 : rule__DataTypeRule__Group__1__Impl rule__DataTypeRule__Group__2 ;
    public final void rule__DataTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1893:1: ( rule__DataTypeRule__Group__1__Impl rule__DataTypeRule__Group__2 )
            // InternalDataDescriptionLanguage.g:1894:2: rule__DataTypeRule__Group__1__Impl rule__DataTypeRule__Group__2
            {
            pushFollow(FOLLOW_15);
            rule__DataTypeRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__DataTypeRule__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalDataDescriptionLanguage.g:1901:1: rule__DataTypeRule__Group__1__Impl : ( 'type' ) ;
    public final void rule__DataTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1905:1: ( ( 'type' ) )
            // InternalDataDescriptionLanguage.g:1906:1: ( 'type' )
            {
            // InternalDataDescriptionLanguage.g:1906:1: ( 'type' )
            // InternalDataDescriptionLanguage.g:1907:2: 'type'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getTypeKeyword_1()); 
            }
            match(input,61,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataTypeRuleAccess().getTypeKeyword_1()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__DataTypeRule__Group__2"
    // InternalDataDescriptionLanguage.g:1916:1: rule__DataTypeRule__Group__2 : rule__DataTypeRule__Group__2__Impl rule__DataTypeRule__Group__3 ;
    public final void rule__DataTypeRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1920:1: ( rule__DataTypeRule__Group__2__Impl rule__DataTypeRule__Group__3 )
            // InternalDataDescriptionLanguage.g:1921:2: rule__DataTypeRule__Group__2__Impl rule__DataTypeRule__Group__3
            {
            pushFollow(FOLLOW_16);
            rule__DataTypeRule__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__DataTypeRule__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeRule__Group__2"


    // $ANTLR start "rule__DataTypeRule__Group__2__Impl"
    // InternalDataDescriptionLanguage.g:1928:1: rule__DataTypeRule__Group__2__Impl : ( ( rule__DataTypeRule__NameAssignment_2 ) ) ;
    public final void rule__DataTypeRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1932:1: ( ( ( rule__DataTypeRule__NameAssignment_2 ) ) )
            // InternalDataDescriptionLanguage.g:1933:1: ( ( rule__DataTypeRule__NameAssignment_2 ) )
            {
            // InternalDataDescriptionLanguage.g:1933:1: ( ( rule__DataTypeRule__NameAssignment_2 ) )
            // InternalDataDescriptionLanguage.g:1934:2: ( rule__DataTypeRule__NameAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getNameAssignment_2()); 
            }
            // InternalDataDescriptionLanguage.g:1935:2: ( rule__DataTypeRule__NameAssignment_2 )
            // InternalDataDescriptionLanguage.g:1935:3: rule__DataTypeRule__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__DataTypeRule__NameAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataTypeRuleAccess().getNameAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeRule__Group__2__Impl"


    // $ANTLR start "rule__DataTypeRule__Group__3"
    // InternalDataDescriptionLanguage.g:1943:1: rule__DataTypeRule__Group__3 : rule__DataTypeRule__Group__3__Impl rule__DataTypeRule__Group__4 ;
    public final void rule__DataTypeRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1947:1: ( rule__DataTypeRule__Group__3__Impl rule__DataTypeRule__Group__4 )
            // InternalDataDescriptionLanguage.g:1948:2: rule__DataTypeRule__Group__3__Impl rule__DataTypeRule__Group__4
            {
            pushFollow(FOLLOW_16);
            rule__DataTypeRule__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__DataTypeRule__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeRule__Group__3"


    // $ANTLR start "rule__DataTypeRule__Group__3__Impl"
    // InternalDataDescriptionLanguage.g:1955:1: rule__DataTypeRule__Group__3__Impl : ( ( rule__DataTypeRule__Group_3__0 )? ) ;
    public final void rule__DataTypeRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1959:1: ( ( ( rule__DataTypeRule__Group_3__0 )? ) )
            // InternalDataDescriptionLanguage.g:1960:1: ( ( rule__DataTypeRule__Group_3__0 )? )
            {
            // InternalDataDescriptionLanguage.g:1960:1: ( ( rule__DataTypeRule__Group_3__0 )? )
            // InternalDataDescriptionLanguage.g:1961:2: ( rule__DataTypeRule__Group_3__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getGroup_3()); 
            }
            // InternalDataDescriptionLanguage.g:1962:2: ( rule__DataTypeRule__Group_3__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==62) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:1962:3: rule__DataTypeRule__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataTypeRule__Group_3__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataTypeRuleAccess().getGroup_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeRule__Group__3__Impl"


    // $ANTLR start "rule__DataTypeRule__Group__4"
    // InternalDataDescriptionLanguage.g:1970:1: rule__DataTypeRule__Group__4 : rule__DataTypeRule__Group__4__Impl rule__DataTypeRule__Group__5 ;
    public final void rule__DataTypeRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1974:1: ( rule__DataTypeRule__Group__4__Impl rule__DataTypeRule__Group__5 )
            // InternalDataDescriptionLanguage.g:1975:2: rule__DataTypeRule__Group__4__Impl rule__DataTypeRule__Group__5
            {
            pushFollow(FOLLOW_16);
            rule__DataTypeRule__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__DataTypeRule__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeRule__Group__4"


    // $ANTLR start "rule__DataTypeRule__Group__4__Impl"
    // InternalDataDescriptionLanguage.g:1982:1: rule__DataTypeRule__Group__4__Impl : ( ( rule__DataTypeRule__Group_4__0 )? ) ;
    public final void rule__DataTypeRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1986:1: ( ( ( rule__DataTypeRule__Group_4__0 )? ) )
            // InternalDataDescriptionLanguage.g:1987:1: ( ( rule__DataTypeRule__Group_4__0 )? )
            {
            // InternalDataDescriptionLanguage.g:1987:1: ( ( rule__DataTypeRule__Group_4__0 )? )
            // InternalDataDescriptionLanguage.g:1988:2: ( rule__DataTypeRule__Group_4__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getGroup_4()); 
            }
            // InternalDataDescriptionLanguage.g:1989:2: ( rule__DataTypeRule__Group_4__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==63) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:1989:3: rule__DataTypeRule__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataTypeRule__Group_4__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataTypeRuleAccess().getGroup_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeRule__Group__4__Impl"


    // $ANTLR start "rule__DataTypeRule__Group__5"
    // InternalDataDescriptionLanguage.g:1997:1: rule__DataTypeRule__Group__5 : rule__DataTypeRule__Group__5__Impl ;
    public final void rule__DataTypeRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2001:1: ( rule__DataTypeRule__Group__5__Impl )
            // InternalDataDescriptionLanguage.g:2002:2: rule__DataTypeRule__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataTypeRule__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeRule__Group__5"


    // $ANTLR start "rule__DataTypeRule__Group__5__Impl"
    // InternalDataDescriptionLanguage.g:2008:1: rule__DataTypeRule__Group__5__Impl : ( ';' ) ;
    public final void rule__DataTypeRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2012:1: ( ( ';' ) )
            // InternalDataDescriptionLanguage.g:2013:1: ( ';' )
            {
            // InternalDataDescriptionLanguage.g:2013:1: ( ';' )
            // InternalDataDescriptionLanguage.g:2014:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getSemicolonKeyword_5()); 
            }
            match(input,60,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataTypeRuleAccess().getSemicolonKeyword_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeRule__Group__5__Impl"


    // $ANTLR start "rule__DataTypeRule__Group_3__0"
    // InternalDataDescriptionLanguage.g:2024:1: rule__DataTypeRule__Group_3__0 : rule__DataTypeRule__Group_3__0__Impl rule__DataTypeRule__Group_3__1 ;
    public final void rule__DataTypeRule__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2028:1: ( rule__DataTypeRule__Group_3__0__Impl rule__DataTypeRule__Group_3__1 )
            // InternalDataDescriptionLanguage.g:2029:2: rule__DataTypeRule__Group_3__0__Impl rule__DataTypeRule__Group_3__1
            {
            pushFollow(FOLLOW_5);
            rule__DataTypeRule__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__DataTypeRule__Group_3__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeRule__Group_3__0"


    // $ANTLR start "rule__DataTypeRule__Group_3__0__Impl"
    // InternalDataDescriptionLanguage.g:2036:1: rule__DataTypeRule__Group_3__0__Impl : ( 'description' ) ;
    public final void rule__DataTypeRule__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2040:1: ( ( 'description' ) )
            // InternalDataDescriptionLanguage.g:2041:1: ( 'description' )
            {
            // InternalDataDescriptionLanguage.g:2041:1: ( 'description' )
            // InternalDataDescriptionLanguage.g:2042:2: 'description'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getDescriptionKeyword_3_0()); 
            }
            match(input,62,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataTypeRuleAccess().getDescriptionKeyword_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeRule__Group_3__0__Impl"


    // $ANTLR start "rule__DataTypeRule__Group_3__1"
    // InternalDataDescriptionLanguage.g:2051:1: rule__DataTypeRule__Group_3__1 : rule__DataTypeRule__Group_3__1__Impl rule__DataTypeRule__Group_3__2 ;
    public final void rule__DataTypeRule__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2055:1: ( rule__DataTypeRule__Group_3__1__Impl rule__DataTypeRule__Group_3__2 )
            // InternalDataDescriptionLanguage.g:2056:2: rule__DataTypeRule__Group_3__1__Impl rule__DataTypeRule__Group_3__2
            {
            pushFollow(FOLLOW_12);
            rule__DataTypeRule__Group_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__DataTypeRule__Group_3__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeRule__Group_3__1"


    // $ANTLR start "rule__DataTypeRule__Group_3__1__Impl"
    // InternalDataDescriptionLanguage.g:2063:1: rule__DataTypeRule__Group_3__1__Impl : ( ':' ) ;
    public final void rule__DataTypeRule__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2067:1: ( ( ':' ) )
            // InternalDataDescriptionLanguage.g:2068:1: ( ':' )
            {
            // InternalDataDescriptionLanguage.g:2068:1: ( ':' )
            // InternalDataDescriptionLanguage.g:2069:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getColonKeyword_3_1()); 
            }
            match(input,56,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataTypeRuleAccess().getColonKeyword_3_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeRule__Group_3__1__Impl"


    // $ANTLR start "rule__DataTypeRule__Group_3__2"
    // InternalDataDescriptionLanguage.g:2078:1: rule__DataTypeRule__Group_3__2 : rule__DataTypeRule__Group_3__2__Impl ;
    public final void rule__DataTypeRule__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2082:1: ( rule__DataTypeRule__Group_3__2__Impl )
            // InternalDataDescriptionLanguage.g:2083:2: rule__DataTypeRule__Group_3__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataTypeRule__Group_3__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeRule__Group_3__2"


    // $ANTLR start "rule__DataTypeRule__Group_3__2__Impl"
    // InternalDataDescriptionLanguage.g:2089:1: rule__DataTypeRule__Group_3__2__Impl : ( ( rule__DataTypeRule__DescriptionAssignment_3_2 ) ) ;
    public final void rule__DataTypeRule__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2093:1: ( ( ( rule__DataTypeRule__DescriptionAssignment_3_2 ) ) )
            // InternalDataDescriptionLanguage.g:2094:1: ( ( rule__DataTypeRule__DescriptionAssignment_3_2 ) )
            {
            // InternalDataDescriptionLanguage.g:2094:1: ( ( rule__DataTypeRule__DescriptionAssignment_3_2 ) )
            // InternalDataDescriptionLanguage.g:2095:2: ( rule__DataTypeRule__DescriptionAssignment_3_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getDescriptionAssignment_3_2()); 
            }
            // InternalDataDescriptionLanguage.g:2096:2: ( rule__DataTypeRule__DescriptionAssignment_3_2 )
            // InternalDataDescriptionLanguage.g:2096:3: rule__DataTypeRule__DescriptionAssignment_3_2
            {
            pushFollow(FOLLOW_2);
            rule__DataTypeRule__DescriptionAssignment_3_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataTypeRuleAccess().getDescriptionAssignment_3_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeRule__Group_3__2__Impl"


    // $ANTLR start "rule__DataTypeRule__Group_4__0"
    // InternalDataDescriptionLanguage.g:2105:1: rule__DataTypeRule__Group_4__0 : rule__DataTypeRule__Group_4__0__Impl rule__DataTypeRule__Group_4__1 ;
    public final void rule__DataTypeRule__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2109:1: ( rule__DataTypeRule__Group_4__0__Impl rule__DataTypeRule__Group_4__1 )
            // InternalDataDescriptionLanguage.g:2110:2: rule__DataTypeRule__Group_4__0__Impl rule__DataTypeRule__Group_4__1
            {
            pushFollow(FOLLOW_17);
            rule__DataTypeRule__Group_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__DataTypeRule__Group_4__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeRule__Group_4__0"


    // $ANTLR start "rule__DataTypeRule__Group_4__0__Impl"
    // InternalDataDescriptionLanguage.g:2117:1: rule__DataTypeRule__Group_4__0__Impl : ( 'with' ) ;
    public final void rule__DataTypeRule__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2121:1: ( ( 'with' ) )
            // InternalDataDescriptionLanguage.g:2122:1: ( 'with' )
            {
            // InternalDataDescriptionLanguage.g:2122:1: ( 'with' )
            // InternalDataDescriptionLanguage.g:2123:2: 'with'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getWithKeyword_4_0()); 
            }
            match(input,63,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataTypeRuleAccess().getWithKeyword_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeRule__Group_4__0__Impl"


    // $ANTLR start "rule__DataTypeRule__Group_4__1"
    // InternalDataDescriptionLanguage.g:2132:1: rule__DataTypeRule__Group_4__1 : rule__DataTypeRule__Group_4__1__Impl rule__DataTypeRule__Group_4__2 ;
    public final void rule__DataTypeRule__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2136:1: ( rule__DataTypeRule__Group_4__1__Impl rule__DataTypeRule__Group_4__2 )
            // InternalDataDescriptionLanguage.g:2137:2: rule__DataTypeRule__Group_4__1__Impl rule__DataTypeRule__Group_4__2
            {
            pushFollow(FOLLOW_5);
            rule__DataTypeRule__Group_4__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__DataTypeRule__Group_4__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeRule__Group_4__1"


    // $ANTLR start "rule__DataTypeRule__Group_4__1__Impl"
    // InternalDataDescriptionLanguage.g:2144:1: rule__DataTypeRule__Group_4__1__Impl : ( 'constraints' ) ;
    public final void rule__DataTypeRule__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2148:1: ( ( 'constraints' ) )
            // InternalDataDescriptionLanguage.g:2149:1: ( 'constraints' )
            {
            // InternalDataDescriptionLanguage.g:2149:1: ( 'constraints' )
            // InternalDataDescriptionLanguage.g:2150:2: 'constraints'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getConstraintsKeyword_4_1()); 
            }
            match(input,58,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataTypeRuleAccess().getConstraintsKeyword_4_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeRule__Group_4__1__Impl"


    // $ANTLR start "rule__DataTypeRule__Group_4__2"
    // InternalDataDescriptionLanguage.g:2159:1: rule__DataTypeRule__Group_4__2 : rule__DataTypeRule__Group_4__2__Impl rule__DataTypeRule__Group_4__3 ;
    public final void rule__DataTypeRule__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2163:1: ( rule__DataTypeRule__Group_4__2__Impl rule__DataTypeRule__Group_4__3 )
            // InternalDataDescriptionLanguage.g:2164:2: rule__DataTypeRule__Group_4__2__Impl rule__DataTypeRule__Group_4__3
            {
            pushFollow(FOLLOW_10);
            rule__DataTypeRule__Group_4__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__DataTypeRule__Group_4__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeRule__Group_4__2"


    // $ANTLR start "rule__DataTypeRule__Group_4__2__Impl"
    // InternalDataDescriptionLanguage.g:2171:1: rule__DataTypeRule__Group_4__2__Impl : ( ':' ) ;
    public final void rule__DataTypeRule__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2175:1: ( ( ':' ) )
            // InternalDataDescriptionLanguage.g:2176:1: ( ':' )
            {
            // InternalDataDescriptionLanguage.g:2176:1: ( ':' )
            // InternalDataDescriptionLanguage.g:2177:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getColonKeyword_4_2()); 
            }
            match(input,56,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataTypeRuleAccess().getColonKeyword_4_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeRule__Group_4__2__Impl"


    // $ANTLR start "rule__DataTypeRule__Group_4__3"
    // InternalDataDescriptionLanguage.g:2186:1: rule__DataTypeRule__Group_4__3 : rule__DataTypeRule__Group_4__3__Impl ;
    public final void rule__DataTypeRule__Group_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2190:1: ( rule__DataTypeRule__Group_4__3__Impl )
            // InternalDataDescriptionLanguage.g:2191:2: rule__DataTypeRule__Group_4__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataTypeRule__Group_4__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeRule__Group_4__3"


    // $ANTLR start "rule__DataTypeRule__Group_4__3__Impl"
    // InternalDataDescriptionLanguage.g:2197:1: rule__DataTypeRule__Group_4__3__Impl : ( ( rule__DataTypeRule__ConstraintsAssignment_4_3 )* ) ;
    public final void rule__DataTypeRule__Group_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2201:1: ( ( ( rule__DataTypeRule__ConstraintsAssignment_4_3 )* ) )
            // InternalDataDescriptionLanguage.g:2202:1: ( ( rule__DataTypeRule__ConstraintsAssignment_4_3 )* )
            {
            // InternalDataDescriptionLanguage.g:2202:1: ( ( rule__DataTypeRule__ConstraintsAssignment_4_3 )* )
            // InternalDataDescriptionLanguage.g:2203:2: ( rule__DataTypeRule__ConstraintsAssignment_4_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getConstraintsAssignment_4_3()); 
            }
            // InternalDataDescriptionLanguage.g:2204:2: ( rule__DataTypeRule__ConstraintsAssignment_4_3 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0>=RULE_QUOTED_ID && LA23_0<=RULE_INT)||LA23_0==15||(LA23_0>=30 && LA23_0<=31)||LA23_0==65||LA23_0==70||(LA23_0>=73 && LA23_0<=74)) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:2204:3: rule__DataTypeRule__ConstraintsAssignment_4_3
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__DataTypeRule__ConstraintsAssignment_4_3();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataTypeRuleAccess().getConstraintsAssignment_4_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeRule__Group_4__3__Impl"


    // $ANTLR start "rule__TypedDataDescriptionRule__Group__0"
    // InternalDataDescriptionLanguage.g:2213:1: rule__TypedDataDescriptionRule__Group__0 : rule__TypedDataDescriptionRule__Group__0__Impl rule__TypedDataDescriptionRule__Group__1 ;
    public final void rule__TypedDataDescriptionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2217:1: ( rule__TypedDataDescriptionRule__Group__0__Impl rule__TypedDataDescriptionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:2218:2: rule__TypedDataDescriptionRule__Group__0__Impl rule__TypedDataDescriptionRule__Group__1
            {
            pushFollow(FOLLOW_18);
            rule__TypedDataDescriptionRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TypedDataDescriptionRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedDataDescriptionRule__Group__0"


    // $ANTLR start "rule__TypedDataDescriptionRule__Group__0__Impl"
    // InternalDataDescriptionLanguage.g:2225:1: rule__TypedDataDescriptionRule__Group__0__Impl : ( ( rule__TypedDataDescriptionRule__RepresentationAssignment_0 ) ) ;
    public final void rule__TypedDataDescriptionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2229:1: ( ( ( rule__TypedDataDescriptionRule__RepresentationAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:2230:1: ( ( rule__TypedDataDescriptionRule__RepresentationAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:2230:1: ( ( rule__TypedDataDescriptionRule__RepresentationAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:2231:2: ( rule__TypedDataDescriptionRule__RepresentationAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedDataDescriptionRuleAccess().getRepresentationAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:2232:2: ( rule__TypedDataDescriptionRule__RepresentationAssignment_0 )
            // InternalDataDescriptionLanguage.g:2232:3: rule__TypedDataDescriptionRule__RepresentationAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__TypedDataDescriptionRule__RepresentationAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedDataDescriptionRuleAccess().getRepresentationAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedDataDescriptionRule__Group__0__Impl"


    // $ANTLR start "rule__TypedDataDescriptionRule__Group__1"
    // InternalDataDescriptionLanguage.g:2240:1: rule__TypedDataDescriptionRule__Group__1 : rule__TypedDataDescriptionRule__Group__1__Impl rule__TypedDataDescriptionRule__Group__2 ;
    public final void rule__TypedDataDescriptionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2244:1: ( rule__TypedDataDescriptionRule__Group__1__Impl rule__TypedDataDescriptionRule__Group__2 )
            // InternalDataDescriptionLanguage.g:2245:2: rule__TypedDataDescriptionRule__Group__1__Impl rule__TypedDataDescriptionRule__Group__2
            {
            pushFollow(FOLLOW_15);
            rule__TypedDataDescriptionRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TypedDataDescriptionRule__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedDataDescriptionRule__Group__1"


    // $ANTLR start "rule__TypedDataDescriptionRule__Group__1__Impl"
    // InternalDataDescriptionLanguage.g:2252:1: rule__TypedDataDescriptionRule__Group__1__Impl : ( 'data' ) ;
    public final void rule__TypedDataDescriptionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2256:1: ( ( 'data' ) )
            // InternalDataDescriptionLanguage.g:2257:1: ( 'data' )
            {
            // InternalDataDescriptionLanguage.g:2257:1: ( 'data' )
            // InternalDataDescriptionLanguage.g:2258:2: 'data'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedDataDescriptionRuleAccess().getDataKeyword_1()); 
            }
            match(input,57,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedDataDescriptionRuleAccess().getDataKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedDataDescriptionRule__Group__1__Impl"


    // $ANTLR start "rule__TypedDataDescriptionRule__Group__2"
    // InternalDataDescriptionLanguage.g:2267:1: rule__TypedDataDescriptionRule__Group__2 : rule__TypedDataDescriptionRule__Group__2__Impl rule__TypedDataDescriptionRule__Group__3 ;
    public final void rule__TypedDataDescriptionRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2271:1: ( rule__TypedDataDescriptionRule__Group__2__Impl rule__TypedDataDescriptionRule__Group__3 )
            // InternalDataDescriptionLanguage.g:2272:2: rule__TypedDataDescriptionRule__Group__2__Impl rule__TypedDataDescriptionRule__Group__3
            {
            pushFollow(FOLLOW_19);
            rule__TypedDataDescriptionRule__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TypedDataDescriptionRule__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedDataDescriptionRule__Group__2"


    // $ANTLR start "rule__TypedDataDescriptionRule__Group__2__Impl"
    // InternalDataDescriptionLanguage.g:2279:1: rule__TypedDataDescriptionRule__Group__2__Impl : ( ( rule__TypedDataDescriptionRule__NameAssignment_2 ) ) ;
    public final void rule__TypedDataDescriptionRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2283:1: ( ( ( rule__TypedDataDescriptionRule__NameAssignment_2 ) ) )
            // InternalDataDescriptionLanguage.g:2284:1: ( ( rule__TypedDataDescriptionRule__NameAssignment_2 ) )
            {
            // InternalDataDescriptionLanguage.g:2284:1: ( ( rule__TypedDataDescriptionRule__NameAssignment_2 ) )
            // InternalDataDescriptionLanguage.g:2285:2: ( rule__TypedDataDescriptionRule__NameAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedDataDescriptionRuleAccess().getNameAssignment_2()); 
            }
            // InternalDataDescriptionLanguage.g:2286:2: ( rule__TypedDataDescriptionRule__NameAssignment_2 )
            // InternalDataDescriptionLanguage.g:2286:3: rule__TypedDataDescriptionRule__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__TypedDataDescriptionRule__NameAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedDataDescriptionRuleAccess().getNameAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedDataDescriptionRule__Group__2__Impl"


    // $ANTLR start "rule__TypedDataDescriptionRule__Group__3"
    // InternalDataDescriptionLanguage.g:2294:1: rule__TypedDataDescriptionRule__Group__3 : rule__TypedDataDescriptionRule__Group__3__Impl rule__TypedDataDescriptionRule__Group__4 ;
    public final void rule__TypedDataDescriptionRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2298:1: ( rule__TypedDataDescriptionRule__Group__3__Impl rule__TypedDataDescriptionRule__Group__4 )
            // InternalDataDescriptionLanguage.g:2299:2: rule__TypedDataDescriptionRule__Group__3__Impl rule__TypedDataDescriptionRule__Group__4
            {
            pushFollow(FOLLOW_14);
            rule__TypedDataDescriptionRule__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TypedDataDescriptionRule__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedDataDescriptionRule__Group__3"


    // $ANTLR start "rule__TypedDataDescriptionRule__Group__3__Impl"
    // InternalDataDescriptionLanguage.g:2306:1: rule__TypedDataDescriptionRule__Group__3__Impl : ( 'of' ) ;
    public final void rule__TypedDataDescriptionRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2310:1: ( ( 'of' ) )
            // InternalDataDescriptionLanguage.g:2311:1: ( 'of' )
            {
            // InternalDataDescriptionLanguage.g:2311:1: ( 'of' )
            // InternalDataDescriptionLanguage.g:2312:2: 'of'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedDataDescriptionRuleAccess().getOfKeyword_3()); 
            }
            match(input,64,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedDataDescriptionRuleAccess().getOfKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedDataDescriptionRule__Group__3__Impl"


    // $ANTLR start "rule__TypedDataDescriptionRule__Group__4"
    // InternalDataDescriptionLanguage.g:2321:1: rule__TypedDataDescriptionRule__Group__4 : rule__TypedDataDescriptionRule__Group__4__Impl rule__TypedDataDescriptionRule__Group__5 ;
    public final void rule__TypedDataDescriptionRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2325:1: ( rule__TypedDataDescriptionRule__Group__4__Impl rule__TypedDataDescriptionRule__Group__5 )
            // InternalDataDescriptionLanguage.g:2326:2: rule__TypedDataDescriptionRule__Group__4__Impl rule__TypedDataDescriptionRule__Group__5
            {
            pushFollow(FOLLOW_15);
            rule__TypedDataDescriptionRule__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TypedDataDescriptionRule__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedDataDescriptionRule__Group__4"


    // $ANTLR start "rule__TypedDataDescriptionRule__Group__4__Impl"
    // InternalDataDescriptionLanguage.g:2333:1: rule__TypedDataDescriptionRule__Group__4__Impl : ( 'type' ) ;
    public final void rule__TypedDataDescriptionRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2337:1: ( ( 'type' ) )
            // InternalDataDescriptionLanguage.g:2338:1: ( 'type' )
            {
            // InternalDataDescriptionLanguage.g:2338:1: ( 'type' )
            // InternalDataDescriptionLanguage.g:2339:2: 'type'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedDataDescriptionRuleAccess().getTypeKeyword_4()); 
            }
            match(input,61,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedDataDescriptionRuleAccess().getTypeKeyword_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedDataDescriptionRule__Group__4__Impl"


    // $ANTLR start "rule__TypedDataDescriptionRule__Group__5"
    // InternalDataDescriptionLanguage.g:2348:1: rule__TypedDataDescriptionRule__Group__5 : rule__TypedDataDescriptionRule__Group__5__Impl rule__TypedDataDescriptionRule__Group__6 ;
    public final void rule__TypedDataDescriptionRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2352:1: ( rule__TypedDataDescriptionRule__Group__5__Impl rule__TypedDataDescriptionRule__Group__6 )
            // InternalDataDescriptionLanguage.g:2353:2: rule__TypedDataDescriptionRule__Group__5__Impl rule__TypedDataDescriptionRule__Group__6
            {
            pushFollow(FOLLOW_20);
            rule__TypedDataDescriptionRule__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TypedDataDescriptionRule__Group__6();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedDataDescriptionRule__Group__5"


    // $ANTLR start "rule__TypedDataDescriptionRule__Group__5__Impl"
    // InternalDataDescriptionLanguage.g:2360:1: rule__TypedDataDescriptionRule__Group__5__Impl : ( ( rule__TypedDataDescriptionRule__TypeAssignment_5 ) ) ;
    public final void rule__TypedDataDescriptionRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2364:1: ( ( ( rule__TypedDataDescriptionRule__TypeAssignment_5 ) ) )
            // InternalDataDescriptionLanguage.g:2365:1: ( ( rule__TypedDataDescriptionRule__TypeAssignment_5 ) )
            {
            // InternalDataDescriptionLanguage.g:2365:1: ( ( rule__TypedDataDescriptionRule__TypeAssignment_5 ) )
            // InternalDataDescriptionLanguage.g:2366:2: ( rule__TypedDataDescriptionRule__TypeAssignment_5 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedDataDescriptionRuleAccess().getTypeAssignment_5()); 
            }
            // InternalDataDescriptionLanguage.g:2367:2: ( rule__TypedDataDescriptionRule__TypeAssignment_5 )
            // InternalDataDescriptionLanguage.g:2367:3: rule__TypedDataDescriptionRule__TypeAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__TypedDataDescriptionRule__TypeAssignment_5();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedDataDescriptionRuleAccess().getTypeAssignment_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedDataDescriptionRule__Group__5__Impl"


    // $ANTLR start "rule__TypedDataDescriptionRule__Group__6"
    // InternalDataDescriptionLanguage.g:2375:1: rule__TypedDataDescriptionRule__Group__6 : rule__TypedDataDescriptionRule__Group__6__Impl rule__TypedDataDescriptionRule__Group__7 ;
    public final void rule__TypedDataDescriptionRule__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2379:1: ( rule__TypedDataDescriptionRule__Group__6__Impl rule__TypedDataDescriptionRule__Group__7 )
            // InternalDataDescriptionLanguage.g:2380:2: rule__TypedDataDescriptionRule__Group__6__Impl rule__TypedDataDescriptionRule__Group__7
            {
            pushFollow(FOLLOW_20);
            rule__TypedDataDescriptionRule__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TypedDataDescriptionRule__Group__7();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedDataDescriptionRule__Group__6"


    // $ANTLR start "rule__TypedDataDescriptionRule__Group__6__Impl"
    // InternalDataDescriptionLanguage.g:2387:1: rule__TypedDataDescriptionRule__Group__6__Impl : ( ( rule__TypedDataDescriptionRule__Group_6__0 )? ) ;
    public final void rule__TypedDataDescriptionRule__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2391:1: ( ( ( rule__TypedDataDescriptionRule__Group_6__0 )? ) )
            // InternalDataDescriptionLanguage.g:2392:1: ( ( rule__TypedDataDescriptionRule__Group_6__0 )? )
            {
            // InternalDataDescriptionLanguage.g:2392:1: ( ( rule__TypedDataDescriptionRule__Group_6__0 )? )
            // InternalDataDescriptionLanguage.g:2393:2: ( rule__TypedDataDescriptionRule__Group_6__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedDataDescriptionRuleAccess().getGroup_6()); 
            }
            // InternalDataDescriptionLanguage.g:2394:2: ( rule__TypedDataDescriptionRule__Group_6__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==63) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:2394:3: rule__TypedDataDescriptionRule__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TypedDataDescriptionRule__Group_6__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedDataDescriptionRuleAccess().getGroup_6()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedDataDescriptionRule__Group__6__Impl"


    // $ANTLR start "rule__TypedDataDescriptionRule__Group__7"
    // InternalDataDescriptionLanguage.g:2402:1: rule__TypedDataDescriptionRule__Group__7 : rule__TypedDataDescriptionRule__Group__7__Impl ;
    public final void rule__TypedDataDescriptionRule__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2406:1: ( rule__TypedDataDescriptionRule__Group__7__Impl )
            // InternalDataDescriptionLanguage.g:2407:2: rule__TypedDataDescriptionRule__Group__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TypedDataDescriptionRule__Group__7__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedDataDescriptionRule__Group__7"


    // $ANTLR start "rule__TypedDataDescriptionRule__Group__7__Impl"
    // InternalDataDescriptionLanguage.g:2413:1: rule__TypedDataDescriptionRule__Group__7__Impl : ( ';' ) ;
    public final void rule__TypedDataDescriptionRule__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2417:1: ( ( ';' ) )
            // InternalDataDescriptionLanguage.g:2418:1: ( ';' )
            {
            // InternalDataDescriptionLanguage.g:2418:1: ( ';' )
            // InternalDataDescriptionLanguage.g:2419:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedDataDescriptionRuleAccess().getSemicolonKeyword_7()); 
            }
            match(input,60,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedDataDescriptionRuleAccess().getSemicolonKeyword_7()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedDataDescriptionRule__Group__7__Impl"


    // $ANTLR start "rule__TypedDataDescriptionRule__Group_6__0"
    // InternalDataDescriptionLanguage.g:2429:1: rule__TypedDataDescriptionRule__Group_6__0 : rule__TypedDataDescriptionRule__Group_6__0__Impl rule__TypedDataDescriptionRule__Group_6__1 ;
    public final void rule__TypedDataDescriptionRule__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2433:1: ( rule__TypedDataDescriptionRule__Group_6__0__Impl rule__TypedDataDescriptionRule__Group_6__1 )
            // InternalDataDescriptionLanguage.g:2434:2: rule__TypedDataDescriptionRule__Group_6__0__Impl rule__TypedDataDescriptionRule__Group_6__1
            {
            pushFollow(FOLLOW_17);
            rule__TypedDataDescriptionRule__Group_6__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TypedDataDescriptionRule__Group_6__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedDataDescriptionRule__Group_6__0"


    // $ANTLR start "rule__TypedDataDescriptionRule__Group_6__0__Impl"
    // InternalDataDescriptionLanguage.g:2441:1: rule__TypedDataDescriptionRule__Group_6__0__Impl : ( 'with' ) ;
    public final void rule__TypedDataDescriptionRule__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2445:1: ( ( 'with' ) )
            // InternalDataDescriptionLanguage.g:2446:1: ( 'with' )
            {
            // InternalDataDescriptionLanguage.g:2446:1: ( 'with' )
            // InternalDataDescriptionLanguage.g:2447:2: 'with'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedDataDescriptionRuleAccess().getWithKeyword_6_0()); 
            }
            match(input,63,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedDataDescriptionRuleAccess().getWithKeyword_6_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedDataDescriptionRule__Group_6__0__Impl"


    // $ANTLR start "rule__TypedDataDescriptionRule__Group_6__1"
    // InternalDataDescriptionLanguage.g:2456:1: rule__TypedDataDescriptionRule__Group_6__1 : rule__TypedDataDescriptionRule__Group_6__1__Impl rule__TypedDataDescriptionRule__Group_6__2 ;
    public final void rule__TypedDataDescriptionRule__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2460:1: ( rule__TypedDataDescriptionRule__Group_6__1__Impl rule__TypedDataDescriptionRule__Group_6__2 )
            // InternalDataDescriptionLanguage.g:2461:2: rule__TypedDataDescriptionRule__Group_6__1__Impl rule__TypedDataDescriptionRule__Group_6__2
            {
            pushFollow(FOLLOW_5);
            rule__TypedDataDescriptionRule__Group_6__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TypedDataDescriptionRule__Group_6__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedDataDescriptionRule__Group_6__1"


    // $ANTLR start "rule__TypedDataDescriptionRule__Group_6__1__Impl"
    // InternalDataDescriptionLanguage.g:2468:1: rule__TypedDataDescriptionRule__Group_6__1__Impl : ( 'constraints' ) ;
    public final void rule__TypedDataDescriptionRule__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2472:1: ( ( 'constraints' ) )
            // InternalDataDescriptionLanguage.g:2473:1: ( 'constraints' )
            {
            // InternalDataDescriptionLanguage.g:2473:1: ( 'constraints' )
            // InternalDataDescriptionLanguage.g:2474:2: 'constraints'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedDataDescriptionRuleAccess().getConstraintsKeyword_6_1()); 
            }
            match(input,58,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedDataDescriptionRuleAccess().getConstraintsKeyword_6_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedDataDescriptionRule__Group_6__1__Impl"


    // $ANTLR start "rule__TypedDataDescriptionRule__Group_6__2"
    // InternalDataDescriptionLanguage.g:2483:1: rule__TypedDataDescriptionRule__Group_6__2 : rule__TypedDataDescriptionRule__Group_6__2__Impl rule__TypedDataDescriptionRule__Group_6__3 ;
    public final void rule__TypedDataDescriptionRule__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2487:1: ( rule__TypedDataDescriptionRule__Group_6__2__Impl rule__TypedDataDescriptionRule__Group_6__3 )
            // InternalDataDescriptionLanguage.g:2488:2: rule__TypedDataDescriptionRule__Group_6__2__Impl rule__TypedDataDescriptionRule__Group_6__3
            {
            pushFollow(FOLLOW_10);
            rule__TypedDataDescriptionRule__Group_6__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TypedDataDescriptionRule__Group_6__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedDataDescriptionRule__Group_6__2"


    // $ANTLR start "rule__TypedDataDescriptionRule__Group_6__2__Impl"
    // InternalDataDescriptionLanguage.g:2495:1: rule__TypedDataDescriptionRule__Group_6__2__Impl : ( ':' ) ;
    public final void rule__TypedDataDescriptionRule__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2499:1: ( ( ':' ) )
            // InternalDataDescriptionLanguage.g:2500:1: ( ':' )
            {
            // InternalDataDescriptionLanguage.g:2500:1: ( ':' )
            // InternalDataDescriptionLanguage.g:2501:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedDataDescriptionRuleAccess().getColonKeyword_6_2()); 
            }
            match(input,56,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedDataDescriptionRuleAccess().getColonKeyword_6_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedDataDescriptionRule__Group_6__2__Impl"


    // $ANTLR start "rule__TypedDataDescriptionRule__Group_6__3"
    // InternalDataDescriptionLanguage.g:2510:1: rule__TypedDataDescriptionRule__Group_6__3 : rule__TypedDataDescriptionRule__Group_6__3__Impl ;
    public final void rule__TypedDataDescriptionRule__Group_6__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2514:1: ( rule__TypedDataDescriptionRule__Group_6__3__Impl )
            // InternalDataDescriptionLanguage.g:2515:2: rule__TypedDataDescriptionRule__Group_6__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TypedDataDescriptionRule__Group_6__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedDataDescriptionRule__Group_6__3"


    // $ANTLR start "rule__TypedDataDescriptionRule__Group_6__3__Impl"
    // InternalDataDescriptionLanguage.g:2521:1: rule__TypedDataDescriptionRule__Group_6__3__Impl : ( ( rule__TypedDataDescriptionRule__ConstraintsAssignment_6_3 )* ) ;
    public final void rule__TypedDataDescriptionRule__Group_6__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2525:1: ( ( ( rule__TypedDataDescriptionRule__ConstraintsAssignment_6_3 )* ) )
            // InternalDataDescriptionLanguage.g:2526:1: ( ( rule__TypedDataDescriptionRule__ConstraintsAssignment_6_3 )* )
            {
            // InternalDataDescriptionLanguage.g:2526:1: ( ( rule__TypedDataDescriptionRule__ConstraintsAssignment_6_3 )* )
            // InternalDataDescriptionLanguage.g:2527:2: ( rule__TypedDataDescriptionRule__ConstraintsAssignment_6_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedDataDescriptionRuleAccess().getConstraintsAssignment_6_3()); 
            }
            // InternalDataDescriptionLanguage.g:2528:2: ( rule__TypedDataDescriptionRule__ConstraintsAssignment_6_3 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0>=RULE_QUOTED_ID && LA25_0<=RULE_INT)||LA25_0==15||(LA25_0>=30 && LA25_0<=31)||LA25_0==65||LA25_0==70||(LA25_0>=73 && LA25_0<=74)) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:2528:3: rule__TypedDataDescriptionRule__ConstraintsAssignment_6_3
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__TypedDataDescriptionRule__ConstraintsAssignment_6_3();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedDataDescriptionRuleAccess().getConstraintsAssignment_6_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedDataDescriptionRule__Group_6__3__Impl"


    // $ANTLR start "rule__UntypedDataDescriptionRule__Group__0"
    // InternalDataDescriptionLanguage.g:2537:1: rule__UntypedDataDescriptionRule__Group__0 : rule__UntypedDataDescriptionRule__Group__0__Impl rule__UntypedDataDescriptionRule__Group__1 ;
    public final void rule__UntypedDataDescriptionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2541:1: ( rule__UntypedDataDescriptionRule__Group__0__Impl rule__UntypedDataDescriptionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:2542:2: rule__UntypedDataDescriptionRule__Group__0__Impl rule__UntypedDataDescriptionRule__Group__1
            {
            pushFollow(FOLLOW_8);
            rule__UntypedDataDescriptionRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__UntypedDataDescriptionRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntypedDataDescriptionRule__Group__0"


    // $ANTLR start "rule__UntypedDataDescriptionRule__Group__0__Impl"
    // InternalDataDescriptionLanguage.g:2549:1: rule__UntypedDataDescriptionRule__Group__0__Impl : ( ( rule__UntypedDataDescriptionRule__ScaleAssignment_0 )? ) ;
    public final void rule__UntypedDataDescriptionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2553:1: ( ( ( rule__UntypedDataDescriptionRule__ScaleAssignment_0 )? ) )
            // InternalDataDescriptionLanguage.g:2554:1: ( ( rule__UntypedDataDescriptionRule__ScaleAssignment_0 )? )
            {
            // InternalDataDescriptionLanguage.g:2554:1: ( ( rule__UntypedDataDescriptionRule__ScaleAssignment_0 )? )
            // InternalDataDescriptionLanguage.g:2555:2: ( rule__UntypedDataDescriptionRule__ScaleAssignment_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUntypedDataDescriptionRuleAccess().getScaleAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:2556:2: ( rule__UntypedDataDescriptionRule__ScaleAssignment_0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( ((LA26_0>=16 && LA26_0<=19)) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:2556:3: rule__UntypedDataDescriptionRule__ScaleAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__UntypedDataDescriptionRule__ScaleAssignment_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getUntypedDataDescriptionRuleAccess().getScaleAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntypedDataDescriptionRule__Group__0__Impl"


    // $ANTLR start "rule__UntypedDataDescriptionRule__Group__1"
    // InternalDataDescriptionLanguage.g:2564:1: rule__UntypedDataDescriptionRule__Group__1 : rule__UntypedDataDescriptionRule__Group__1__Impl rule__UntypedDataDescriptionRule__Group__2 ;
    public final void rule__UntypedDataDescriptionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2568:1: ( rule__UntypedDataDescriptionRule__Group__1__Impl rule__UntypedDataDescriptionRule__Group__2 )
            // InternalDataDescriptionLanguage.g:2569:2: rule__UntypedDataDescriptionRule__Group__1__Impl rule__UntypedDataDescriptionRule__Group__2
            {
            pushFollow(FOLLOW_18);
            rule__UntypedDataDescriptionRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__UntypedDataDescriptionRule__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntypedDataDescriptionRule__Group__1"


    // $ANTLR start "rule__UntypedDataDescriptionRule__Group__1__Impl"
    // InternalDataDescriptionLanguage.g:2576:1: rule__UntypedDataDescriptionRule__Group__1__Impl : ( ( rule__UntypedDataDescriptionRule__RepresentationAssignment_1 ) ) ;
    public final void rule__UntypedDataDescriptionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2580:1: ( ( ( rule__UntypedDataDescriptionRule__RepresentationAssignment_1 ) ) )
            // InternalDataDescriptionLanguage.g:2581:1: ( ( rule__UntypedDataDescriptionRule__RepresentationAssignment_1 ) )
            {
            // InternalDataDescriptionLanguage.g:2581:1: ( ( rule__UntypedDataDescriptionRule__RepresentationAssignment_1 ) )
            // InternalDataDescriptionLanguage.g:2582:2: ( rule__UntypedDataDescriptionRule__RepresentationAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUntypedDataDescriptionRuleAccess().getRepresentationAssignment_1()); 
            }
            // InternalDataDescriptionLanguage.g:2583:2: ( rule__UntypedDataDescriptionRule__RepresentationAssignment_1 )
            // InternalDataDescriptionLanguage.g:2583:3: rule__UntypedDataDescriptionRule__RepresentationAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__UntypedDataDescriptionRule__RepresentationAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getUntypedDataDescriptionRuleAccess().getRepresentationAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntypedDataDescriptionRule__Group__1__Impl"


    // $ANTLR start "rule__UntypedDataDescriptionRule__Group__2"
    // InternalDataDescriptionLanguage.g:2591:1: rule__UntypedDataDescriptionRule__Group__2 : rule__UntypedDataDescriptionRule__Group__2__Impl rule__UntypedDataDescriptionRule__Group__3 ;
    public final void rule__UntypedDataDescriptionRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2595:1: ( rule__UntypedDataDescriptionRule__Group__2__Impl rule__UntypedDataDescriptionRule__Group__3 )
            // InternalDataDescriptionLanguage.g:2596:2: rule__UntypedDataDescriptionRule__Group__2__Impl rule__UntypedDataDescriptionRule__Group__3
            {
            pushFollow(FOLLOW_15);
            rule__UntypedDataDescriptionRule__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__UntypedDataDescriptionRule__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntypedDataDescriptionRule__Group__2"


    // $ANTLR start "rule__UntypedDataDescriptionRule__Group__2__Impl"
    // InternalDataDescriptionLanguage.g:2603:1: rule__UntypedDataDescriptionRule__Group__2__Impl : ( 'data' ) ;
    public final void rule__UntypedDataDescriptionRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2607:1: ( ( 'data' ) )
            // InternalDataDescriptionLanguage.g:2608:1: ( 'data' )
            {
            // InternalDataDescriptionLanguage.g:2608:1: ( 'data' )
            // InternalDataDescriptionLanguage.g:2609:2: 'data'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUntypedDataDescriptionRuleAccess().getDataKeyword_2()); 
            }
            match(input,57,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUntypedDataDescriptionRuleAccess().getDataKeyword_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntypedDataDescriptionRule__Group__2__Impl"


    // $ANTLR start "rule__UntypedDataDescriptionRule__Group__3"
    // InternalDataDescriptionLanguage.g:2618:1: rule__UntypedDataDescriptionRule__Group__3 : rule__UntypedDataDescriptionRule__Group__3__Impl rule__UntypedDataDescriptionRule__Group__4 ;
    public final void rule__UntypedDataDescriptionRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2622:1: ( rule__UntypedDataDescriptionRule__Group__3__Impl rule__UntypedDataDescriptionRule__Group__4 )
            // InternalDataDescriptionLanguage.g:2623:2: rule__UntypedDataDescriptionRule__Group__3__Impl rule__UntypedDataDescriptionRule__Group__4
            {
            pushFollow(FOLLOW_20);
            rule__UntypedDataDescriptionRule__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__UntypedDataDescriptionRule__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntypedDataDescriptionRule__Group__3"


    // $ANTLR start "rule__UntypedDataDescriptionRule__Group__3__Impl"
    // InternalDataDescriptionLanguage.g:2630:1: rule__UntypedDataDescriptionRule__Group__3__Impl : ( ( rule__UntypedDataDescriptionRule__NameAssignment_3 ) ) ;
    public final void rule__UntypedDataDescriptionRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2634:1: ( ( ( rule__UntypedDataDescriptionRule__NameAssignment_3 ) ) )
            // InternalDataDescriptionLanguage.g:2635:1: ( ( rule__UntypedDataDescriptionRule__NameAssignment_3 ) )
            {
            // InternalDataDescriptionLanguage.g:2635:1: ( ( rule__UntypedDataDescriptionRule__NameAssignment_3 ) )
            // InternalDataDescriptionLanguage.g:2636:2: ( rule__UntypedDataDescriptionRule__NameAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUntypedDataDescriptionRuleAccess().getNameAssignment_3()); 
            }
            // InternalDataDescriptionLanguage.g:2637:2: ( rule__UntypedDataDescriptionRule__NameAssignment_3 )
            // InternalDataDescriptionLanguage.g:2637:3: rule__UntypedDataDescriptionRule__NameAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__UntypedDataDescriptionRule__NameAssignment_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getUntypedDataDescriptionRuleAccess().getNameAssignment_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntypedDataDescriptionRule__Group__3__Impl"


    // $ANTLR start "rule__UntypedDataDescriptionRule__Group__4"
    // InternalDataDescriptionLanguage.g:2645:1: rule__UntypedDataDescriptionRule__Group__4 : rule__UntypedDataDescriptionRule__Group__4__Impl rule__UntypedDataDescriptionRule__Group__5 ;
    public final void rule__UntypedDataDescriptionRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2649:1: ( rule__UntypedDataDescriptionRule__Group__4__Impl rule__UntypedDataDescriptionRule__Group__5 )
            // InternalDataDescriptionLanguage.g:2650:2: rule__UntypedDataDescriptionRule__Group__4__Impl rule__UntypedDataDescriptionRule__Group__5
            {
            pushFollow(FOLLOW_20);
            rule__UntypedDataDescriptionRule__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__UntypedDataDescriptionRule__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntypedDataDescriptionRule__Group__4"


    // $ANTLR start "rule__UntypedDataDescriptionRule__Group__4__Impl"
    // InternalDataDescriptionLanguage.g:2657:1: rule__UntypedDataDescriptionRule__Group__4__Impl : ( ( rule__UntypedDataDescriptionRule__Group_4__0 )? ) ;
    public final void rule__UntypedDataDescriptionRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2661:1: ( ( ( rule__UntypedDataDescriptionRule__Group_4__0 )? ) )
            // InternalDataDescriptionLanguage.g:2662:1: ( ( rule__UntypedDataDescriptionRule__Group_4__0 )? )
            {
            // InternalDataDescriptionLanguage.g:2662:1: ( ( rule__UntypedDataDescriptionRule__Group_4__0 )? )
            // InternalDataDescriptionLanguage.g:2663:2: ( rule__UntypedDataDescriptionRule__Group_4__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUntypedDataDescriptionRuleAccess().getGroup_4()); 
            }
            // InternalDataDescriptionLanguage.g:2664:2: ( rule__UntypedDataDescriptionRule__Group_4__0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==63) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:2664:3: rule__UntypedDataDescriptionRule__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__UntypedDataDescriptionRule__Group_4__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getUntypedDataDescriptionRuleAccess().getGroup_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntypedDataDescriptionRule__Group__4__Impl"


    // $ANTLR start "rule__UntypedDataDescriptionRule__Group__5"
    // InternalDataDescriptionLanguage.g:2672:1: rule__UntypedDataDescriptionRule__Group__5 : rule__UntypedDataDescriptionRule__Group__5__Impl ;
    public final void rule__UntypedDataDescriptionRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2676:1: ( rule__UntypedDataDescriptionRule__Group__5__Impl )
            // InternalDataDescriptionLanguage.g:2677:2: rule__UntypedDataDescriptionRule__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__UntypedDataDescriptionRule__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntypedDataDescriptionRule__Group__5"


    // $ANTLR start "rule__UntypedDataDescriptionRule__Group__5__Impl"
    // InternalDataDescriptionLanguage.g:2683:1: rule__UntypedDataDescriptionRule__Group__5__Impl : ( ';' ) ;
    public final void rule__UntypedDataDescriptionRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2687:1: ( ( ';' ) )
            // InternalDataDescriptionLanguage.g:2688:1: ( ';' )
            {
            // InternalDataDescriptionLanguage.g:2688:1: ( ';' )
            // InternalDataDescriptionLanguage.g:2689:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUntypedDataDescriptionRuleAccess().getSemicolonKeyword_5()); 
            }
            match(input,60,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUntypedDataDescriptionRuleAccess().getSemicolonKeyword_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntypedDataDescriptionRule__Group__5__Impl"


    // $ANTLR start "rule__UntypedDataDescriptionRule__Group_4__0"
    // InternalDataDescriptionLanguage.g:2699:1: rule__UntypedDataDescriptionRule__Group_4__0 : rule__UntypedDataDescriptionRule__Group_4__0__Impl rule__UntypedDataDescriptionRule__Group_4__1 ;
    public final void rule__UntypedDataDescriptionRule__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2703:1: ( rule__UntypedDataDescriptionRule__Group_4__0__Impl rule__UntypedDataDescriptionRule__Group_4__1 )
            // InternalDataDescriptionLanguage.g:2704:2: rule__UntypedDataDescriptionRule__Group_4__0__Impl rule__UntypedDataDescriptionRule__Group_4__1
            {
            pushFollow(FOLLOW_17);
            rule__UntypedDataDescriptionRule__Group_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__UntypedDataDescriptionRule__Group_4__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntypedDataDescriptionRule__Group_4__0"


    // $ANTLR start "rule__UntypedDataDescriptionRule__Group_4__0__Impl"
    // InternalDataDescriptionLanguage.g:2711:1: rule__UntypedDataDescriptionRule__Group_4__0__Impl : ( 'with' ) ;
    public final void rule__UntypedDataDescriptionRule__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2715:1: ( ( 'with' ) )
            // InternalDataDescriptionLanguage.g:2716:1: ( 'with' )
            {
            // InternalDataDescriptionLanguage.g:2716:1: ( 'with' )
            // InternalDataDescriptionLanguage.g:2717:2: 'with'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUntypedDataDescriptionRuleAccess().getWithKeyword_4_0()); 
            }
            match(input,63,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUntypedDataDescriptionRuleAccess().getWithKeyword_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntypedDataDescriptionRule__Group_4__0__Impl"


    // $ANTLR start "rule__UntypedDataDescriptionRule__Group_4__1"
    // InternalDataDescriptionLanguage.g:2726:1: rule__UntypedDataDescriptionRule__Group_4__1 : rule__UntypedDataDescriptionRule__Group_4__1__Impl rule__UntypedDataDescriptionRule__Group_4__2 ;
    public final void rule__UntypedDataDescriptionRule__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2730:1: ( rule__UntypedDataDescriptionRule__Group_4__1__Impl rule__UntypedDataDescriptionRule__Group_4__2 )
            // InternalDataDescriptionLanguage.g:2731:2: rule__UntypedDataDescriptionRule__Group_4__1__Impl rule__UntypedDataDescriptionRule__Group_4__2
            {
            pushFollow(FOLLOW_5);
            rule__UntypedDataDescriptionRule__Group_4__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__UntypedDataDescriptionRule__Group_4__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntypedDataDescriptionRule__Group_4__1"


    // $ANTLR start "rule__UntypedDataDescriptionRule__Group_4__1__Impl"
    // InternalDataDescriptionLanguage.g:2738:1: rule__UntypedDataDescriptionRule__Group_4__1__Impl : ( 'constraints' ) ;
    public final void rule__UntypedDataDescriptionRule__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2742:1: ( ( 'constraints' ) )
            // InternalDataDescriptionLanguage.g:2743:1: ( 'constraints' )
            {
            // InternalDataDescriptionLanguage.g:2743:1: ( 'constraints' )
            // InternalDataDescriptionLanguage.g:2744:2: 'constraints'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUntypedDataDescriptionRuleAccess().getConstraintsKeyword_4_1()); 
            }
            match(input,58,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUntypedDataDescriptionRuleAccess().getConstraintsKeyword_4_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntypedDataDescriptionRule__Group_4__1__Impl"


    // $ANTLR start "rule__UntypedDataDescriptionRule__Group_4__2"
    // InternalDataDescriptionLanguage.g:2753:1: rule__UntypedDataDescriptionRule__Group_4__2 : rule__UntypedDataDescriptionRule__Group_4__2__Impl rule__UntypedDataDescriptionRule__Group_4__3 ;
    public final void rule__UntypedDataDescriptionRule__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2757:1: ( rule__UntypedDataDescriptionRule__Group_4__2__Impl rule__UntypedDataDescriptionRule__Group_4__3 )
            // InternalDataDescriptionLanguage.g:2758:2: rule__UntypedDataDescriptionRule__Group_4__2__Impl rule__UntypedDataDescriptionRule__Group_4__3
            {
            pushFollow(FOLLOW_10);
            rule__UntypedDataDescriptionRule__Group_4__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__UntypedDataDescriptionRule__Group_4__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntypedDataDescriptionRule__Group_4__2"


    // $ANTLR start "rule__UntypedDataDescriptionRule__Group_4__2__Impl"
    // InternalDataDescriptionLanguage.g:2765:1: rule__UntypedDataDescriptionRule__Group_4__2__Impl : ( ':' ) ;
    public final void rule__UntypedDataDescriptionRule__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2769:1: ( ( ':' ) )
            // InternalDataDescriptionLanguage.g:2770:1: ( ':' )
            {
            // InternalDataDescriptionLanguage.g:2770:1: ( ':' )
            // InternalDataDescriptionLanguage.g:2771:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUntypedDataDescriptionRuleAccess().getColonKeyword_4_2()); 
            }
            match(input,56,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUntypedDataDescriptionRuleAccess().getColonKeyword_4_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntypedDataDescriptionRule__Group_4__2__Impl"


    // $ANTLR start "rule__UntypedDataDescriptionRule__Group_4__3"
    // InternalDataDescriptionLanguage.g:2780:1: rule__UntypedDataDescriptionRule__Group_4__3 : rule__UntypedDataDescriptionRule__Group_4__3__Impl ;
    public final void rule__UntypedDataDescriptionRule__Group_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2784:1: ( rule__UntypedDataDescriptionRule__Group_4__3__Impl )
            // InternalDataDescriptionLanguage.g:2785:2: rule__UntypedDataDescriptionRule__Group_4__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__UntypedDataDescriptionRule__Group_4__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntypedDataDescriptionRule__Group_4__3"


    // $ANTLR start "rule__UntypedDataDescriptionRule__Group_4__3__Impl"
    // InternalDataDescriptionLanguage.g:2791:1: rule__UntypedDataDescriptionRule__Group_4__3__Impl : ( ( rule__UntypedDataDescriptionRule__ConstraintsAssignment_4_3 )* ) ;
    public final void rule__UntypedDataDescriptionRule__Group_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2795:1: ( ( ( rule__UntypedDataDescriptionRule__ConstraintsAssignment_4_3 )* ) )
            // InternalDataDescriptionLanguage.g:2796:1: ( ( rule__UntypedDataDescriptionRule__ConstraintsAssignment_4_3 )* )
            {
            // InternalDataDescriptionLanguage.g:2796:1: ( ( rule__UntypedDataDescriptionRule__ConstraintsAssignment_4_3 )* )
            // InternalDataDescriptionLanguage.g:2797:2: ( rule__UntypedDataDescriptionRule__ConstraintsAssignment_4_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUntypedDataDescriptionRuleAccess().getConstraintsAssignment_4_3()); 
            }
            // InternalDataDescriptionLanguage.g:2798:2: ( rule__UntypedDataDescriptionRule__ConstraintsAssignment_4_3 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( ((LA28_0>=RULE_QUOTED_ID && LA28_0<=RULE_INT)||LA28_0==15||(LA28_0>=30 && LA28_0<=31)||LA28_0==65||LA28_0==70||(LA28_0>=73 && LA28_0<=74)) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:2798:3: rule__UntypedDataDescriptionRule__ConstraintsAssignment_4_3
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__UntypedDataDescriptionRule__ConstraintsAssignment_4_3();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getUntypedDataDescriptionRuleAccess().getConstraintsAssignment_4_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntypedDataDescriptionRule__Group_4__3__Impl"


    // $ANTLR start "rule__StatementRule__Group__0"
    // InternalDataDescriptionLanguage.g:2807:1: rule__StatementRule__Group__0 : rule__StatementRule__Group__0__Impl rule__StatementRule__Group__1 ;
    public final void rule__StatementRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2811:1: ( rule__StatementRule__Group__0__Impl rule__StatementRule__Group__1 )
            // InternalDataDescriptionLanguage.g:2812:2: rule__StatementRule__Group__0__Impl rule__StatementRule__Group__1
            {
            pushFollow(FOLLOW_13);
            rule__StatementRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__StatementRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StatementRule__Group__0"


    // $ANTLR start "rule__StatementRule__Group__0__Impl"
    // InternalDataDescriptionLanguage.g:2819:1: rule__StatementRule__Group__0__Impl : ( ruleExpressionRule ) ;
    public final void rule__StatementRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2823:1: ( ( ruleExpressionRule ) )
            // InternalDataDescriptionLanguage.g:2824:1: ( ruleExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:2824:1: ( ruleExpressionRule )
            // InternalDataDescriptionLanguage.g:2825:2: ruleExpressionRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStatementRuleAccess().getExpressionRuleParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleExpressionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getStatementRuleAccess().getExpressionRuleParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StatementRule__Group__0__Impl"


    // $ANTLR start "rule__StatementRule__Group__1"
    // InternalDataDescriptionLanguage.g:2834:1: rule__StatementRule__Group__1 : rule__StatementRule__Group__1__Impl ;
    public final void rule__StatementRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2838:1: ( rule__StatementRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:2839:2: rule__StatementRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__StatementRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StatementRule__Group__1"


    // $ANTLR start "rule__StatementRule__Group__1__Impl"
    // InternalDataDescriptionLanguage.g:2845:1: rule__StatementRule__Group__1__Impl : ( ';' ) ;
    public final void rule__StatementRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2849:1: ( ( ';' ) )
            // InternalDataDescriptionLanguage.g:2850:1: ( ';' )
            {
            // InternalDataDescriptionLanguage.g:2850:1: ( ';' )
            // InternalDataDescriptionLanguage.g:2851:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStatementRuleAccess().getSemicolonKeyword_1()); 
            }
            match(input,60,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getStatementRuleAccess().getSemicolonKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StatementRule__Group__1__Impl"


    // $ANTLR start "rule__SelfReferenceRule__Group__0"
    // InternalDataDescriptionLanguage.g:2861:1: rule__SelfReferenceRule__Group__0 : rule__SelfReferenceRule__Group__0__Impl rule__SelfReferenceRule__Group__1 ;
    public final void rule__SelfReferenceRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2865:1: ( rule__SelfReferenceRule__Group__0__Impl rule__SelfReferenceRule__Group__1 )
            // InternalDataDescriptionLanguage.g:2866:2: rule__SelfReferenceRule__Group__0__Impl rule__SelfReferenceRule__Group__1
            {
            pushFollow(FOLLOW_10);
            rule__SelfReferenceRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__SelfReferenceRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelfReferenceRule__Group__0"


    // $ANTLR start "rule__SelfReferenceRule__Group__0__Impl"
    // InternalDataDescriptionLanguage.g:2873:1: rule__SelfReferenceRule__Group__0__Impl : ( () ) ;
    public final void rule__SelfReferenceRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2877:1: ( ( () ) )
            // InternalDataDescriptionLanguage.g:2878:1: ( () )
            {
            // InternalDataDescriptionLanguage.g:2878:1: ( () )
            // InternalDataDescriptionLanguage.g:2879:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSelfReferenceRuleAccess().getSelfReferenceAction_0()); 
            }
            // InternalDataDescriptionLanguage.g:2880:2: ()
            // InternalDataDescriptionLanguage.g:2880:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSelfReferenceRuleAccess().getSelfReferenceAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelfReferenceRule__Group__0__Impl"


    // $ANTLR start "rule__SelfReferenceRule__Group__1"
    // InternalDataDescriptionLanguage.g:2888:1: rule__SelfReferenceRule__Group__1 : rule__SelfReferenceRule__Group__1__Impl ;
    public final void rule__SelfReferenceRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2892:1: ( rule__SelfReferenceRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:2893:2: rule__SelfReferenceRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SelfReferenceRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelfReferenceRule__Group__1"


    // $ANTLR start "rule__SelfReferenceRule__Group__1__Impl"
    // InternalDataDescriptionLanguage.g:2899:1: rule__SelfReferenceRule__Group__1__Impl : ( 'value' ) ;
    public final void rule__SelfReferenceRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2903:1: ( ( 'value' ) )
            // InternalDataDescriptionLanguage.g:2904:1: ( 'value' )
            {
            // InternalDataDescriptionLanguage.g:2904:1: ( 'value' )
            // InternalDataDescriptionLanguage.g:2905:2: 'value'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSelfReferenceRuleAccess().getValueKeyword_1()); 
            }
            match(input,65,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSelfReferenceRuleAccess().getValueKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelfReferenceRule__Group__1__Impl"


    // $ANTLR start "rule__OrExpressionRule__Group__0"
    // InternalDataDescriptionLanguage.g:2915:1: rule__OrExpressionRule__Group__0 : rule__OrExpressionRule__Group__0__Impl rule__OrExpressionRule__Group__1 ;
    public final void rule__OrExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2919:1: ( rule__OrExpressionRule__Group__0__Impl rule__OrExpressionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:2920:2: rule__OrExpressionRule__Group__0__Impl rule__OrExpressionRule__Group__1
            {
            pushFollow(FOLLOW_21);
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
    // InternalDataDescriptionLanguage.g:2927:1: rule__OrExpressionRule__Group__0__Impl : ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) ) ;
    public final void rule__OrExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2931:1: ( ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:2932:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:2932:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:2933:2: ( rule__OrExpressionRule__SubExpressionsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:2934:2: ( rule__OrExpressionRule__SubExpressionsAssignment_0 )
            // InternalDataDescriptionLanguage.g:2934:3: rule__OrExpressionRule__SubExpressionsAssignment_0
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
    // InternalDataDescriptionLanguage.g:2942:1: rule__OrExpressionRule__Group__1 : rule__OrExpressionRule__Group__1__Impl ;
    public final void rule__OrExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2946:1: ( rule__OrExpressionRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:2947:2: rule__OrExpressionRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:2953:1: rule__OrExpressionRule__Group__1__Impl : ( ( rule__OrExpressionRule__Group_1__0 )* ) ;
    public final void rule__OrExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2957:1: ( ( ( rule__OrExpressionRule__Group_1__0 )* ) )
            // InternalDataDescriptionLanguage.g:2958:1: ( ( rule__OrExpressionRule__Group_1__0 )* )
            {
            // InternalDataDescriptionLanguage.g:2958:1: ( ( rule__OrExpressionRule__Group_1__0 )* )
            // InternalDataDescriptionLanguage.g:2959:2: ( rule__OrExpressionRule__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionRuleAccess().getGroup_1()); 
            }
            // InternalDataDescriptionLanguage.g:2960:2: ( rule__OrExpressionRule__Group_1__0 )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==66) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:2960:3: rule__OrExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_22);
            	    rule__OrExpressionRule__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop29;
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
    // InternalDataDescriptionLanguage.g:2969:1: rule__OrExpressionRule__Group_1__0 : rule__OrExpressionRule__Group_1__0__Impl rule__OrExpressionRule__Group_1__1 ;
    public final void rule__OrExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2973:1: ( rule__OrExpressionRule__Group_1__0__Impl rule__OrExpressionRule__Group_1__1 )
            // InternalDataDescriptionLanguage.g:2974:2: rule__OrExpressionRule__Group_1__0__Impl rule__OrExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_10);
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
    // InternalDataDescriptionLanguage.g:2981:1: rule__OrExpressionRule__Group_1__0__Impl : ( 'OR' ) ;
    public final void rule__OrExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2985:1: ( ( 'OR' ) )
            // InternalDataDescriptionLanguage.g:2986:1: ( 'OR' )
            {
            // InternalDataDescriptionLanguage.g:2986:1: ( 'OR' )
            // InternalDataDescriptionLanguage.g:2987:2: 'OR'
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
    // InternalDataDescriptionLanguage.g:2996:1: rule__OrExpressionRule__Group_1__1 : rule__OrExpressionRule__Group_1__1__Impl ;
    public final void rule__OrExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3000:1: ( rule__OrExpressionRule__Group_1__1__Impl )
            // InternalDataDescriptionLanguage.g:3001:2: rule__OrExpressionRule__Group_1__1__Impl
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
    // InternalDataDescriptionLanguage.g:3007:1: rule__OrExpressionRule__Group_1__1__Impl : ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) ) ;
    public final void rule__OrExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3011:1: ( ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) ) )
            // InternalDataDescriptionLanguage.g:3012:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) )
            {
            // InternalDataDescriptionLanguage.g:3012:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) )
            // InternalDataDescriptionLanguage.g:3013:2: ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsAssignment_1_1()); 
            }
            // InternalDataDescriptionLanguage.g:3014:2: ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 )
            // InternalDataDescriptionLanguage.g:3014:3: rule__OrExpressionRule__SubExpressionsAssignment_1_1
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
    // InternalDataDescriptionLanguage.g:3023:1: rule__XorExpressionRule__Group__0 : rule__XorExpressionRule__Group__0__Impl rule__XorExpressionRule__Group__1 ;
    public final void rule__XorExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3027:1: ( rule__XorExpressionRule__Group__0__Impl rule__XorExpressionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:3028:2: rule__XorExpressionRule__Group__0__Impl rule__XorExpressionRule__Group__1
            {
            pushFollow(FOLLOW_23);
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
    // InternalDataDescriptionLanguage.g:3035:1: rule__XorExpressionRule__Group__0__Impl : ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) ) ;
    public final void rule__XorExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3039:1: ( ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:3040:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:3040:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:3041:2: ( rule__XorExpressionRule__SubExpressionsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:3042:2: ( rule__XorExpressionRule__SubExpressionsAssignment_0 )
            // InternalDataDescriptionLanguage.g:3042:3: rule__XorExpressionRule__SubExpressionsAssignment_0
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
    // InternalDataDescriptionLanguage.g:3050:1: rule__XorExpressionRule__Group__1 : rule__XorExpressionRule__Group__1__Impl ;
    public final void rule__XorExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3054:1: ( rule__XorExpressionRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:3055:2: rule__XorExpressionRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:3061:1: rule__XorExpressionRule__Group__1__Impl : ( ( rule__XorExpressionRule__Group_1__0 )* ) ;
    public final void rule__XorExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3065:1: ( ( ( rule__XorExpressionRule__Group_1__0 )* ) )
            // InternalDataDescriptionLanguage.g:3066:1: ( ( rule__XorExpressionRule__Group_1__0 )* )
            {
            // InternalDataDescriptionLanguage.g:3066:1: ( ( rule__XorExpressionRule__Group_1__0 )* )
            // InternalDataDescriptionLanguage.g:3067:2: ( rule__XorExpressionRule__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXorExpressionRuleAccess().getGroup_1()); 
            }
            // InternalDataDescriptionLanguage.g:3068:2: ( rule__XorExpressionRule__Group_1__0 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==67) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:3068:3: rule__XorExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_24);
            	    rule__XorExpressionRule__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop30;
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
    // InternalDataDescriptionLanguage.g:3077:1: rule__XorExpressionRule__Group_1__0 : rule__XorExpressionRule__Group_1__0__Impl rule__XorExpressionRule__Group_1__1 ;
    public final void rule__XorExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3081:1: ( rule__XorExpressionRule__Group_1__0__Impl rule__XorExpressionRule__Group_1__1 )
            // InternalDataDescriptionLanguage.g:3082:2: rule__XorExpressionRule__Group_1__0__Impl rule__XorExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_10);
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
    // InternalDataDescriptionLanguage.g:3089:1: rule__XorExpressionRule__Group_1__0__Impl : ( 'XOR' ) ;
    public final void rule__XorExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3093:1: ( ( 'XOR' ) )
            // InternalDataDescriptionLanguage.g:3094:1: ( 'XOR' )
            {
            // InternalDataDescriptionLanguage.g:3094:1: ( 'XOR' )
            // InternalDataDescriptionLanguage.g:3095:2: 'XOR'
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
    // InternalDataDescriptionLanguage.g:3104:1: rule__XorExpressionRule__Group_1__1 : rule__XorExpressionRule__Group_1__1__Impl ;
    public final void rule__XorExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3108:1: ( rule__XorExpressionRule__Group_1__1__Impl )
            // InternalDataDescriptionLanguage.g:3109:2: rule__XorExpressionRule__Group_1__1__Impl
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
    // InternalDataDescriptionLanguage.g:3115:1: rule__XorExpressionRule__Group_1__1__Impl : ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) ) ;
    public final void rule__XorExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3119:1: ( ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) ) )
            // InternalDataDescriptionLanguage.g:3120:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) )
            {
            // InternalDataDescriptionLanguage.g:3120:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) )
            // InternalDataDescriptionLanguage.g:3121:2: ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAssignment_1_1()); 
            }
            // InternalDataDescriptionLanguage.g:3122:2: ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 )
            // InternalDataDescriptionLanguage.g:3122:3: rule__XorExpressionRule__SubExpressionsAssignment_1_1
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
    // InternalDataDescriptionLanguage.g:3131:1: rule__AndExpressionRule__Group__0 : rule__AndExpressionRule__Group__0__Impl rule__AndExpressionRule__Group__1 ;
    public final void rule__AndExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3135:1: ( rule__AndExpressionRule__Group__0__Impl rule__AndExpressionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:3136:2: rule__AndExpressionRule__Group__0__Impl rule__AndExpressionRule__Group__1
            {
            pushFollow(FOLLOW_25);
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
    // InternalDataDescriptionLanguage.g:3143:1: rule__AndExpressionRule__Group__0__Impl : ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) ) ;
    public final void rule__AndExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3147:1: ( ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:3148:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:3148:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:3149:2: ( rule__AndExpressionRule__SubExpressionsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:3150:2: ( rule__AndExpressionRule__SubExpressionsAssignment_0 )
            // InternalDataDescriptionLanguage.g:3150:3: rule__AndExpressionRule__SubExpressionsAssignment_0
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
    // InternalDataDescriptionLanguage.g:3158:1: rule__AndExpressionRule__Group__1 : rule__AndExpressionRule__Group__1__Impl ;
    public final void rule__AndExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3162:1: ( rule__AndExpressionRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:3163:2: rule__AndExpressionRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:3169:1: rule__AndExpressionRule__Group__1__Impl : ( ( rule__AndExpressionRule__Group_1__0 )* ) ;
    public final void rule__AndExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3173:1: ( ( ( rule__AndExpressionRule__Group_1__0 )* ) )
            // InternalDataDescriptionLanguage.g:3174:1: ( ( rule__AndExpressionRule__Group_1__0 )* )
            {
            // InternalDataDescriptionLanguage.g:3174:1: ( ( rule__AndExpressionRule__Group_1__0 )* )
            // InternalDataDescriptionLanguage.g:3175:2: ( rule__AndExpressionRule__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionRuleAccess().getGroup_1()); 
            }
            // InternalDataDescriptionLanguage.g:3176:2: ( rule__AndExpressionRule__Group_1__0 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==68) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:3176:3: rule__AndExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_26);
            	    rule__AndExpressionRule__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop31;
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
    // InternalDataDescriptionLanguage.g:3185:1: rule__AndExpressionRule__Group_1__0 : rule__AndExpressionRule__Group_1__0__Impl rule__AndExpressionRule__Group_1__1 ;
    public final void rule__AndExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3189:1: ( rule__AndExpressionRule__Group_1__0__Impl rule__AndExpressionRule__Group_1__1 )
            // InternalDataDescriptionLanguage.g:3190:2: rule__AndExpressionRule__Group_1__0__Impl rule__AndExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_10);
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
    // InternalDataDescriptionLanguage.g:3197:1: rule__AndExpressionRule__Group_1__0__Impl : ( 'AND' ) ;
    public final void rule__AndExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3201:1: ( ( 'AND' ) )
            // InternalDataDescriptionLanguage.g:3202:1: ( 'AND' )
            {
            // InternalDataDescriptionLanguage.g:3202:1: ( 'AND' )
            // InternalDataDescriptionLanguage.g:3203:2: 'AND'
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
    // InternalDataDescriptionLanguage.g:3212:1: rule__AndExpressionRule__Group_1__1 : rule__AndExpressionRule__Group_1__1__Impl ;
    public final void rule__AndExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3216:1: ( rule__AndExpressionRule__Group_1__1__Impl )
            // InternalDataDescriptionLanguage.g:3217:2: rule__AndExpressionRule__Group_1__1__Impl
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
    // InternalDataDescriptionLanguage.g:3223:1: rule__AndExpressionRule__Group_1__1__Impl : ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) ) ;
    public final void rule__AndExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3227:1: ( ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) ) )
            // InternalDataDescriptionLanguage.g:3228:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) )
            {
            // InternalDataDescriptionLanguage.g:3228:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) )
            // InternalDataDescriptionLanguage.g:3229:2: ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsAssignment_1_1()); 
            }
            // InternalDataDescriptionLanguage.g:3230:2: ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 )
            // InternalDataDescriptionLanguage.g:3230:3: rule__AndExpressionRule__SubExpressionsAssignment_1_1
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
    // InternalDataDescriptionLanguage.g:3239:1: rule__NotExpressionRule__Group__0 : rule__NotExpressionRule__Group__0__Impl rule__NotExpressionRule__Group__1 ;
    public final void rule__NotExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3243:1: ( rule__NotExpressionRule__Group__0__Impl rule__NotExpressionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:3244:2: rule__NotExpressionRule__Group__0__Impl rule__NotExpressionRule__Group__1
            {
            pushFollow(FOLLOW_10);
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
    // InternalDataDescriptionLanguage.g:3251:1: rule__NotExpressionRule__Group__0__Impl : ( ( rule__NotExpressionRule__NegatedAssignment_0 )? ) ;
    public final void rule__NotExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3255:1: ( ( ( rule__NotExpressionRule__NegatedAssignment_0 )? ) )
            // InternalDataDescriptionLanguage.g:3256:1: ( ( rule__NotExpressionRule__NegatedAssignment_0 )? )
            {
            // InternalDataDescriptionLanguage.g:3256:1: ( ( rule__NotExpressionRule__NegatedAssignment_0 )? )
            // InternalDataDescriptionLanguage.g:3257:2: ( rule__NotExpressionRule__NegatedAssignment_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNotExpressionRuleAccess().getNegatedAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:3258:2: ( rule__NotExpressionRule__NegatedAssignment_0 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==73) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:3258:3: rule__NotExpressionRule__NegatedAssignment_0
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
    // InternalDataDescriptionLanguage.g:3266:1: rule__NotExpressionRule__Group__1 : rule__NotExpressionRule__Group__1__Impl ;
    public final void rule__NotExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3270:1: ( rule__NotExpressionRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:3271:2: rule__NotExpressionRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:3277:1: rule__NotExpressionRule__Group__1__Impl : ( ( rule__NotExpressionRule__OperandAssignment_1 ) ) ;
    public final void rule__NotExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3281:1: ( ( ( rule__NotExpressionRule__OperandAssignment_1 ) ) )
            // InternalDataDescriptionLanguage.g:3282:1: ( ( rule__NotExpressionRule__OperandAssignment_1 ) )
            {
            // InternalDataDescriptionLanguage.g:3282:1: ( ( rule__NotExpressionRule__OperandAssignment_1 ) )
            // InternalDataDescriptionLanguage.g:3283:2: ( rule__NotExpressionRule__OperandAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNotExpressionRuleAccess().getOperandAssignment_1()); 
            }
            // InternalDataDescriptionLanguage.g:3284:2: ( rule__NotExpressionRule__OperandAssignment_1 )
            // InternalDataDescriptionLanguage.g:3284:3: rule__NotExpressionRule__OperandAssignment_1
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
    // InternalDataDescriptionLanguage.g:3293:1: rule__ComparisonExpressionRule__Group__0 : rule__ComparisonExpressionRule__Group__0__Impl rule__ComparisonExpressionRule__Group__1 ;
    public final void rule__ComparisonExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3297:1: ( rule__ComparisonExpressionRule__Group__0__Impl rule__ComparisonExpressionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:3298:2: rule__ComparisonExpressionRule__Group__0__Impl rule__ComparisonExpressionRule__Group__1
            {
            pushFollow(FOLLOW_27);
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
    // InternalDataDescriptionLanguage.g:3305:1: rule__ComparisonExpressionRule__Group__0__Impl : ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__ComparisonExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3309:1: ( ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:3310:1: ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:3310:1: ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:3311:2: ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonExpressionRuleAccess().getLeftOperandAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:3312:2: ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 )
            // InternalDataDescriptionLanguage.g:3312:3: rule__ComparisonExpressionRule__LeftOperandAssignment_0
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
    // InternalDataDescriptionLanguage.g:3320:1: rule__ComparisonExpressionRule__Group__1 : rule__ComparisonExpressionRule__Group__1__Impl ;
    public final void rule__ComparisonExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3324:1: ( rule__ComparisonExpressionRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:3325:2: rule__ComparisonExpressionRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:3331:1: rule__ComparisonExpressionRule__Group__1__Impl : ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* ) ;
    public final void rule__ComparisonExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3335:1: ( ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* ) )
            // InternalDataDescriptionLanguage.g:3336:1: ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* )
            {
            // InternalDataDescriptionLanguage.g:3336:1: ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* )
            // InternalDataDescriptionLanguage.g:3337:2: ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonExpressionRuleAccess().getComparisonAssignment_1()); 
            }
            // InternalDataDescriptionLanguage.g:3338:2: ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( ((LA33_0>=24 && LA33_0<=29)) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:3338:3: rule__ComparisonExpressionRule__ComparisonAssignment_1
            	    {
            	    pushFollow(FOLLOW_28);
            	    rule__ComparisonExpressionRule__ComparisonAssignment_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop33;
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
    // InternalDataDescriptionLanguage.g:3347:1: rule__PartialComparisonExpressionRule__Group__0 : rule__PartialComparisonExpressionRule__Group__0__Impl rule__PartialComparisonExpressionRule__Group__1 ;
    public final void rule__PartialComparisonExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3351:1: ( rule__PartialComparisonExpressionRule__Group__0__Impl rule__PartialComparisonExpressionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:3352:2: rule__PartialComparisonExpressionRule__Group__0__Impl rule__PartialComparisonExpressionRule__Group__1
            {
            pushFollow(FOLLOW_10);
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
    // InternalDataDescriptionLanguage.g:3359:1: rule__PartialComparisonExpressionRule__Group__0__Impl : ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) ) ;
    public final void rule__PartialComparisonExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3363:1: ( ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:3364:1: ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:3364:1: ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:3365:2: ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartialComparisonExpressionRuleAccess().getOperatorAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:3366:2: ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 )
            // InternalDataDescriptionLanguage.g:3366:3: rule__PartialComparisonExpressionRule__OperatorAssignment_0
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
    // InternalDataDescriptionLanguage.g:3374:1: rule__PartialComparisonExpressionRule__Group__1 : rule__PartialComparisonExpressionRule__Group__1__Impl ;
    public final void rule__PartialComparisonExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3378:1: ( rule__PartialComparisonExpressionRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:3379:2: rule__PartialComparisonExpressionRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:3385:1: rule__PartialComparisonExpressionRule__Group__1__Impl : ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) ) ;
    public final void rule__PartialComparisonExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3389:1: ( ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) ) )
            // InternalDataDescriptionLanguage.g:3390:1: ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) )
            {
            // InternalDataDescriptionLanguage.g:3390:1: ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) )
            // InternalDataDescriptionLanguage.g:3391:2: ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartialComparisonExpressionRuleAccess().getSubExpressionAssignment_1()); 
            }
            // InternalDataDescriptionLanguage.g:3392:2: ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 )
            // InternalDataDescriptionLanguage.g:3392:3: rule__PartialComparisonExpressionRule__SubExpressionAssignment_1
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
    // InternalDataDescriptionLanguage.g:3401:1: rule__AddOrSubtractExpressionRule__Group__0 : rule__AddOrSubtractExpressionRule__Group__0__Impl rule__AddOrSubtractExpressionRule__Group__1 ;
    public final void rule__AddOrSubtractExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3405:1: ( rule__AddOrSubtractExpressionRule__Group__0__Impl rule__AddOrSubtractExpressionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:3406:2: rule__AddOrSubtractExpressionRule__Group__0__Impl rule__AddOrSubtractExpressionRule__Group__1
            {
            pushFollow(FOLLOW_29);
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
    // InternalDataDescriptionLanguage.g:3413:1: rule__AddOrSubtractExpressionRule__Group__0__Impl : ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__AddOrSubtractExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3417:1: ( ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:3418:1: ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:3418:1: ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:3419:2: ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getLeftOperandAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:3420:2: ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 )
            // InternalDataDescriptionLanguage.g:3420:3: rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0
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
    // InternalDataDescriptionLanguage.g:3428:1: rule__AddOrSubtractExpressionRule__Group__1 : rule__AddOrSubtractExpressionRule__Group__1__Impl ;
    public final void rule__AddOrSubtractExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3432:1: ( rule__AddOrSubtractExpressionRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:3433:2: rule__AddOrSubtractExpressionRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:3439:1: rule__AddOrSubtractExpressionRule__Group__1__Impl : ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* ) ;
    public final void rule__AddOrSubtractExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3443:1: ( ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* ) )
            // InternalDataDescriptionLanguage.g:3444:1: ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* )
            {
            // InternalDataDescriptionLanguage.g:3444:1: ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* )
            // InternalDataDescriptionLanguage.g:3445:2: ( rule__AddOrSubtractExpressionRule__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getGroup_1()); 
            }
            // InternalDataDescriptionLanguage.g:3446:2: ( rule__AddOrSubtractExpressionRule__Group_1__0 )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( ((LA34_0>=30 && LA34_0<=31)) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:3446:3: rule__AddOrSubtractExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_30);
            	    rule__AddOrSubtractExpressionRule__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop34;
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
    // InternalDataDescriptionLanguage.g:3455:1: rule__AddOrSubtractExpressionRule__Group_1__0 : rule__AddOrSubtractExpressionRule__Group_1__0__Impl rule__AddOrSubtractExpressionRule__Group_1__1 ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3459:1: ( rule__AddOrSubtractExpressionRule__Group_1__0__Impl rule__AddOrSubtractExpressionRule__Group_1__1 )
            // InternalDataDescriptionLanguage.g:3460:2: rule__AddOrSubtractExpressionRule__Group_1__0__Impl rule__AddOrSubtractExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_10);
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
    // InternalDataDescriptionLanguage.g:3467:1: rule__AddOrSubtractExpressionRule__Group_1__0__Impl : ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) ) ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3471:1: ( ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) ) )
            // InternalDataDescriptionLanguage.g:3472:1: ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) )
            {
            // InternalDataDescriptionLanguage.g:3472:1: ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) )
            // InternalDataDescriptionLanguage.g:3473:2: ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperatorsAssignment_1_0()); 
            }
            // InternalDataDescriptionLanguage.g:3474:2: ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 )
            // InternalDataDescriptionLanguage.g:3474:3: rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0
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
    // InternalDataDescriptionLanguage.g:3482:1: rule__AddOrSubtractExpressionRule__Group_1__1 : rule__AddOrSubtractExpressionRule__Group_1__1__Impl ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3486:1: ( rule__AddOrSubtractExpressionRule__Group_1__1__Impl )
            // InternalDataDescriptionLanguage.g:3487:2: rule__AddOrSubtractExpressionRule__Group_1__1__Impl
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
    // InternalDataDescriptionLanguage.g:3493:1: rule__AddOrSubtractExpressionRule__Group_1__1__Impl : ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) ) ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3497:1: ( ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) ) )
            // InternalDataDescriptionLanguage.g:3498:1: ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) )
            {
            // InternalDataDescriptionLanguage.g:3498:1: ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) )
            // InternalDataDescriptionLanguage.g:3499:2: ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperandsAssignment_1_1()); 
            }
            // InternalDataDescriptionLanguage.g:3500:2: ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 )
            // InternalDataDescriptionLanguage.g:3500:3: rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1
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
    // InternalDataDescriptionLanguage.g:3509:1: rule__MultiplyDivideModuloExpressionRule__Group__0 : rule__MultiplyDivideModuloExpressionRule__Group__0__Impl rule__MultiplyDivideModuloExpressionRule__Group__1 ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3513:1: ( rule__MultiplyDivideModuloExpressionRule__Group__0__Impl rule__MultiplyDivideModuloExpressionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:3514:2: rule__MultiplyDivideModuloExpressionRule__Group__0__Impl rule__MultiplyDivideModuloExpressionRule__Group__1
            {
            pushFollow(FOLLOW_31);
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
    // InternalDataDescriptionLanguage.g:3521:1: rule__MultiplyDivideModuloExpressionRule__Group__0__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3525:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:3526:1: ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:3526:1: ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:3527:2: ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getLeftOperandAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:3528:2: ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 )
            // InternalDataDescriptionLanguage.g:3528:3: rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0
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
    // InternalDataDescriptionLanguage.g:3536:1: rule__MultiplyDivideModuloExpressionRule__Group__1 : rule__MultiplyDivideModuloExpressionRule__Group__1__Impl ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3540:1: ( rule__MultiplyDivideModuloExpressionRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:3541:2: rule__MultiplyDivideModuloExpressionRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:3547:1: rule__MultiplyDivideModuloExpressionRule__Group__1__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3551:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* ) )
            // InternalDataDescriptionLanguage.g:3552:1: ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* )
            {
            // InternalDataDescriptionLanguage.g:3552:1: ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* )
            // InternalDataDescriptionLanguage.g:3553:2: ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getGroup_1()); 
            }
            // InternalDataDescriptionLanguage.g:3554:2: ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( ((LA35_0>=32 && LA35_0<=34)) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:3554:3: rule__MultiplyDivideModuloExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_32);
            	    rule__MultiplyDivideModuloExpressionRule__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop35;
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
    // InternalDataDescriptionLanguage.g:3563:1: rule__MultiplyDivideModuloExpressionRule__Group_1__0 : rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl rule__MultiplyDivideModuloExpressionRule__Group_1__1 ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3567:1: ( rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl rule__MultiplyDivideModuloExpressionRule__Group_1__1 )
            // InternalDataDescriptionLanguage.g:3568:2: rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl rule__MultiplyDivideModuloExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_10);
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
    // InternalDataDescriptionLanguage.g:3575:1: rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3579:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) ) )
            // InternalDataDescriptionLanguage.g:3580:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) )
            {
            // InternalDataDescriptionLanguage.g:3580:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) )
            // InternalDataDescriptionLanguage.g:3581:2: ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperatorsAssignment_1_0()); 
            }
            // InternalDataDescriptionLanguage.g:3582:2: ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 )
            // InternalDataDescriptionLanguage.g:3582:3: rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0
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
    // InternalDataDescriptionLanguage.g:3590:1: rule__MultiplyDivideModuloExpressionRule__Group_1__1 : rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3594:1: ( rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl )
            // InternalDataDescriptionLanguage.g:3595:2: rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl
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
    // InternalDataDescriptionLanguage.g:3601:1: rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3605:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) ) )
            // InternalDataDescriptionLanguage.g:3606:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) )
            {
            // InternalDataDescriptionLanguage.g:3606:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) )
            // InternalDataDescriptionLanguage.g:3607:2: ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperandsAssignment_1_1()); 
            }
            // InternalDataDescriptionLanguage.g:3608:2: ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 )
            // InternalDataDescriptionLanguage.g:3608:3: rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1
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
    // InternalDataDescriptionLanguage.g:3617:1: rule__PowerOfExpressionRule__Group__0 : rule__PowerOfExpressionRule__Group__0__Impl rule__PowerOfExpressionRule__Group__1 ;
    public final void rule__PowerOfExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3621:1: ( rule__PowerOfExpressionRule__Group__0__Impl rule__PowerOfExpressionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:3622:2: rule__PowerOfExpressionRule__Group__0__Impl rule__PowerOfExpressionRule__Group__1
            {
            pushFollow(FOLLOW_33);
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
    // InternalDataDescriptionLanguage.g:3629:1: rule__PowerOfExpressionRule__Group__0__Impl : ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__PowerOfExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3633:1: ( ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:3634:1: ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:3634:1: ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:3635:2: ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPowerOfExpressionRuleAccess().getLeftOperandAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:3636:2: ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 )
            // InternalDataDescriptionLanguage.g:3636:3: rule__PowerOfExpressionRule__LeftOperandAssignment_0
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
    // InternalDataDescriptionLanguage.g:3644:1: rule__PowerOfExpressionRule__Group__1 : rule__PowerOfExpressionRule__Group__1__Impl ;
    public final void rule__PowerOfExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3648:1: ( rule__PowerOfExpressionRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:3649:2: rule__PowerOfExpressionRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:3655:1: rule__PowerOfExpressionRule__Group__1__Impl : ( ( rule__PowerOfExpressionRule__Group_1__0 )? ) ;
    public final void rule__PowerOfExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3659:1: ( ( ( rule__PowerOfExpressionRule__Group_1__0 )? ) )
            // InternalDataDescriptionLanguage.g:3660:1: ( ( rule__PowerOfExpressionRule__Group_1__0 )? )
            {
            // InternalDataDescriptionLanguage.g:3660:1: ( ( rule__PowerOfExpressionRule__Group_1__0 )? )
            // InternalDataDescriptionLanguage.g:3661:2: ( rule__PowerOfExpressionRule__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPowerOfExpressionRuleAccess().getGroup_1()); 
            }
            // InternalDataDescriptionLanguage.g:3662:2: ( rule__PowerOfExpressionRule__Group_1__0 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==69) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:3662:3: rule__PowerOfExpressionRule__Group_1__0
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
    // InternalDataDescriptionLanguage.g:3671:1: rule__PowerOfExpressionRule__Group_1__0 : rule__PowerOfExpressionRule__Group_1__0__Impl rule__PowerOfExpressionRule__Group_1__1 ;
    public final void rule__PowerOfExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3675:1: ( rule__PowerOfExpressionRule__Group_1__0__Impl rule__PowerOfExpressionRule__Group_1__1 )
            // InternalDataDescriptionLanguage.g:3676:2: rule__PowerOfExpressionRule__Group_1__0__Impl rule__PowerOfExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_10);
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
    // InternalDataDescriptionLanguage.g:3683:1: rule__PowerOfExpressionRule__Group_1__0__Impl : ( '^' ) ;
    public final void rule__PowerOfExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3687:1: ( ( '^' ) )
            // InternalDataDescriptionLanguage.g:3688:1: ( '^' )
            {
            // InternalDataDescriptionLanguage.g:3688:1: ( '^' )
            // InternalDataDescriptionLanguage.g:3689:2: '^'
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
    // InternalDataDescriptionLanguage.g:3698:1: rule__PowerOfExpressionRule__Group_1__1 : rule__PowerOfExpressionRule__Group_1__1__Impl ;
    public final void rule__PowerOfExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3702:1: ( rule__PowerOfExpressionRule__Group_1__1__Impl )
            // InternalDataDescriptionLanguage.g:3703:2: rule__PowerOfExpressionRule__Group_1__1__Impl
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
    // InternalDataDescriptionLanguage.g:3709:1: rule__PowerOfExpressionRule__Group_1__1__Impl : ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) ) ;
    public final void rule__PowerOfExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3713:1: ( ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) ) )
            // InternalDataDescriptionLanguage.g:3714:1: ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) )
            {
            // InternalDataDescriptionLanguage.g:3714:1: ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) )
            // InternalDataDescriptionLanguage.g:3715:2: ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPowerOfExpressionRuleAccess().getRightOperandAssignment_1_1()); 
            }
            // InternalDataDescriptionLanguage.g:3716:2: ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 )
            // InternalDataDescriptionLanguage.g:3716:3: rule__PowerOfExpressionRule__RightOperandAssignment_1_1
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
    // InternalDataDescriptionLanguage.g:3725:1: rule__UnaryAddOrSubtractExpressionRule__Group__0 : rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl rule__UnaryAddOrSubtractExpressionRule__Group__1 ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3729:1: ( rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl rule__UnaryAddOrSubtractExpressionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:3730:2: rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl rule__UnaryAddOrSubtractExpressionRule__Group__1
            {
            pushFollow(FOLLOW_10);
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
    // InternalDataDescriptionLanguage.g:3737:1: rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl : ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3741:1: ( ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* ) )
            // InternalDataDescriptionLanguage.g:3742:1: ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* )
            {
            // InternalDataDescriptionLanguage.g:3742:1: ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* )
            // InternalDataDescriptionLanguage.g:3743:2: ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getOperatorsAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:3744:2: ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( ((LA37_0>=30 && LA37_0<=31)) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:3744:3: rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0
            	    {
            	    pushFollow(FOLLOW_30);
            	    rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop37;
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
    // InternalDataDescriptionLanguage.g:3752:1: rule__UnaryAddOrSubtractExpressionRule__Group__1 : rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3756:1: ( rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:3757:2: rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:3763:1: rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl : ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3767:1: ( ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) ) )
            // InternalDataDescriptionLanguage.g:3768:1: ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) )
            {
            // InternalDataDescriptionLanguage.g:3768:1: ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) )
            // InternalDataDescriptionLanguage.g:3769:2: ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getSubExpressionAssignment_1()); 
            }
            // InternalDataDescriptionLanguage.g:3770:2: ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 )
            // InternalDataDescriptionLanguage.g:3770:3: rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1
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


    // $ANTLR start "rule__ParanthesesRule__Group__0"
    // InternalDataDescriptionLanguage.g:3779:1: rule__ParanthesesRule__Group__0 : rule__ParanthesesRule__Group__0__Impl rule__ParanthesesRule__Group__1 ;
    public final void rule__ParanthesesRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3783:1: ( rule__ParanthesesRule__Group__0__Impl rule__ParanthesesRule__Group__1 )
            // InternalDataDescriptionLanguage.g:3784:2: rule__ParanthesesRule__Group__0__Impl rule__ParanthesesRule__Group__1
            {
            pushFollow(FOLLOW_10);
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
    // InternalDataDescriptionLanguage.g:3791:1: rule__ParanthesesRule__Group__0__Impl : ( '(' ) ;
    public final void rule__ParanthesesRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3795:1: ( ( '(' ) )
            // InternalDataDescriptionLanguage.g:3796:1: ( '(' )
            {
            // InternalDataDescriptionLanguage.g:3796:1: ( '(' )
            // InternalDataDescriptionLanguage.g:3797:2: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParanthesesRuleAccess().getLeftParenthesisKeyword_0()); 
            }
            match(input,70,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:3806:1: rule__ParanthesesRule__Group__1 : rule__ParanthesesRule__Group__1__Impl rule__ParanthesesRule__Group__2 ;
    public final void rule__ParanthesesRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3810:1: ( rule__ParanthesesRule__Group__1__Impl rule__ParanthesesRule__Group__2 )
            // InternalDataDescriptionLanguage.g:3811:2: rule__ParanthesesRule__Group__1__Impl rule__ParanthesesRule__Group__2
            {
            pushFollow(FOLLOW_34);
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
    // InternalDataDescriptionLanguage.g:3818:1: rule__ParanthesesRule__Group__1__Impl : ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) ) ;
    public final void rule__ParanthesesRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3822:1: ( ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) ) )
            // InternalDataDescriptionLanguage.g:3823:1: ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) )
            {
            // InternalDataDescriptionLanguage.g:3823:1: ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) )
            // InternalDataDescriptionLanguage.g:3824:2: ( rule__ParanthesesRule__SubExpressionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParanthesesRuleAccess().getSubExpressionAssignment_1()); 
            }
            // InternalDataDescriptionLanguage.g:3825:2: ( rule__ParanthesesRule__SubExpressionAssignment_1 )
            // InternalDataDescriptionLanguage.g:3825:3: rule__ParanthesesRule__SubExpressionAssignment_1
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
    // InternalDataDescriptionLanguage.g:3833:1: rule__ParanthesesRule__Group__2 : rule__ParanthesesRule__Group__2__Impl ;
    public final void rule__ParanthesesRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3837:1: ( rule__ParanthesesRule__Group__2__Impl )
            // InternalDataDescriptionLanguage.g:3838:2: rule__ParanthesesRule__Group__2__Impl
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
    // InternalDataDescriptionLanguage.g:3844:1: rule__ParanthesesRule__Group__2__Impl : ( ')' ) ;
    public final void rule__ParanthesesRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3848:1: ( ( ')' ) )
            // InternalDataDescriptionLanguage.g:3849:1: ( ')' )
            {
            // InternalDataDescriptionLanguage.g:3849:1: ( ')' )
            // InternalDataDescriptionLanguage.g:3850:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParanthesesRuleAccess().getRightParenthesisKeyword_2()); 
            }
            match(input,71,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:3860:1: rule__CallRule__Group__0 : rule__CallRule__Group__0__Impl rule__CallRule__Group__1 ;
    public final void rule__CallRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3864:1: ( rule__CallRule__Group__0__Impl rule__CallRule__Group__1 )
            // InternalDataDescriptionLanguage.g:3865:2: rule__CallRule__Group__0__Impl rule__CallRule__Group__1
            {
            pushFollow(FOLLOW_35);
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
    // InternalDataDescriptionLanguage.g:3872:1: rule__CallRule__Group__0__Impl : ( ( rule__CallRule__FunctionAssignment_0 ) ) ;
    public final void rule__CallRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3876:1: ( ( ( rule__CallRule__FunctionAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:3877:1: ( ( rule__CallRule__FunctionAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:3877:1: ( ( rule__CallRule__FunctionAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:3878:2: ( rule__CallRule__FunctionAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getFunctionAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:3879:2: ( rule__CallRule__FunctionAssignment_0 )
            // InternalDataDescriptionLanguage.g:3879:3: rule__CallRule__FunctionAssignment_0
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
    // InternalDataDescriptionLanguage.g:3887:1: rule__CallRule__Group__1 : rule__CallRule__Group__1__Impl rule__CallRule__Group__2 ;
    public final void rule__CallRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3891:1: ( rule__CallRule__Group__1__Impl rule__CallRule__Group__2 )
            // InternalDataDescriptionLanguage.g:3892:2: rule__CallRule__Group__1__Impl rule__CallRule__Group__2
            {
            pushFollow(FOLLOW_36);
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
    // InternalDataDescriptionLanguage.g:3899:1: rule__CallRule__Group__1__Impl : ( '(' ) ;
    public final void rule__CallRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3903:1: ( ( '(' ) )
            // InternalDataDescriptionLanguage.g:3904:1: ( '(' )
            {
            // InternalDataDescriptionLanguage.g:3904:1: ( '(' )
            // InternalDataDescriptionLanguage.g:3905:2: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getLeftParenthesisKeyword_1()); 
            }
            match(input,70,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:3914:1: rule__CallRule__Group__2 : rule__CallRule__Group__2__Impl rule__CallRule__Group__3 ;
    public final void rule__CallRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3918:1: ( rule__CallRule__Group__2__Impl rule__CallRule__Group__3 )
            // InternalDataDescriptionLanguage.g:3919:2: rule__CallRule__Group__2__Impl rule__CallRule__Group__3
            {
            pushFollow(FOLLOW_36);
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
    // InternalDataDescriptionLanguage.g:3926:1: rule__CallRule__Group__2__Impl : ( ( rule__CallRule__Group_2__0 )? ) ;
    public final void rule__CallRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3930:1: ( ( ( rule__CallRule__Group_2__0 )? ) )
            // InternalDataDescriptionLanguage.g:3931:1: ( ( rule__CallRule__Group_2__0 )? )
            {
            // InternalDataDescriptionLanguage.g:3931:1: ( ( rule__CallRule__Group_2__0 )? )
            // InternalDataDescriptionLanguage.g:3932:2: ( rule__CallRule__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getGroup_2()); 
            }
            // InternalDataDescriptionLanguage.g:3933:2: ( rule__CallRule__Group_2__0 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( ((LA38_0>=RULE_QUOTED_ID && LA38_0<=RULE_INT)||LA38_0==15||(LA38_0>=30 && LA38_0<=31)||LA38_0==65||LA38_0==70||(LA38_0>=73 && LA38_0<=74)) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:3933:3: rule__CallRule__Group_2__0
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
    // InternalDataDescriptionLanguage.g:3941:1: rule__CallRule__Group__3 : rule__CallRule__Group__3__Impl ;
    public final void rule__CallRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3945:1: ( rule__CallRule__Group__3__Impl )
            // InternalDataDescriptionLanguage.g:3946:2: rule__CallRule__Group__3__Impl
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
    // InternalDataDescriptionLanguage.g:3952:1: rule__CallRule__Group__3__Impl : ( ')' ) ;
    public final void rule__CallRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3956:1: ( ( ')' ) )
            // InternalDataDescriptionLanguage.g:3957:1: ( ')' )
            {
            // InternalDataDescriptionLanguage.g:3957:1: ( ')' )
            // InternalDataDescriptionLanguage.g:3958:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getRightParenthesisKeyword_3()); 
            }
            match(input,71,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:3968:1: rule__CallRule__Group_2__0 : rule__CallRule__Group_2__0__Impl rule__CallRule__Group_2__1 ;
    public final void rule__CallRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3972:1: ( rule__CallRule__Group_2__0__Impl rule__CallRule__Group_2__1 )
            // InternalDataDescriptionLanguage.g:3973:2: rule__CallRule__Group_2__0__Impl rule__CallRule__Group_2__1
            {
            pushFollow(FOLLOW_37);
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
    // InternalDataDescriptionLanguage.g:3980:1: rule__CallRule__Group_2__0__Impl : ( ( rule__CallRule__ParametersAssignment_2_0 ) ) ;
    public final void rule__CallRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3984:1: ( ( ( rule__CallRule__ParametersAssignment_2_0 ) ) )
            // InternalDataDescriptionLanguage.g:3985:1: ( ( rule__CallRule__ParametersAssignment_2_0 ) )
            {
            // InternalDataDescriptionLanguage.g:3985:1: ( ( rule__CallRule__ParametersAssignment_2_0 ) )
            // InternalDataDescriptionLanguage.g:3986:2: ( rule__CallRule__ParametersAssignment_2_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getParametersAssignment_2_0()); 
            }
            // InternalDataDescriptionLanguage.g:3987:2: ( rule__CallRule__ParametersAssignment_2_0 )
            // InternalDataDescriptionLanguage.g:3987:3: rule__CallRule__ParametersAssignment_2_0
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
    // InternalDataDescriptionLanguage.g:3995:1: rule__CallRule__Group_2__1 : rule__CallRule__Group_2__1__Impl ;
    public final void rule__CallRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3999:1: ( rule__CallRule__Group_2__1__Impl )
            // InternalDataDescriptionLanguage.g:4000:2: rule__CallRule__Group_2__1__Impl
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
    // InternalDataDescriptionLanguage.g:4006:1: rule__CallRule__Group_2__1__Impl : ( ( rule__CallRule__Group_2_1__0 )* ) ;
    public final void rule__CallRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4010:1: ( ( ( rule__CallRule__Group_2_1__0 )* ) )
            // InternalDataDescriptionLanguage.g:4011:1: ( ( rule__CallRule__Group_2_1__0 )* )
            {
            // InternalDataDescriptionLanguage.g:4011:1: ( ( rule__CallRule__Group_2_1__0 )* )
            // InternalDataDescriptionLanguage.g:4012:2: ( rule__CallRule__Group_2_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getGroup_2_1()); 
            }
            // InternalDataDescriptionLanguage.g:4013:2: ( rule__CallRule__Group_2_1__0 )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==72) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:4013:3: rule__CallRule__Group_2_1__0
            	    {
            	    pushFollow(FOLLOW_38);
            	    rule__CallRule__Group_2_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop39;
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
    // InternalDataDescriptionLanguage.g:4022:1: rule__CallRule__Group_2_1__0 : rule__CallRule__Group_2_1__0__Impl rule__CallRule__Group_2_1__1 ;
    public final void rule__CallRule__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4026:1: ( rule__CallRule__Group_2_1__0__Impl rule__CallRule__Group_2_1__1 )
            // InternalDataDescriptionLanguage.g:4027:2: rule__CallRule__Group_2_1__0__Impl rule__CallRule__Group_2_1__1
            {
            pushFollow(FOLLOW_10);
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
    // InternalDataDescriptionLanguage.g:4034:1: rule__CallRule__Group_2_1__0__Impl : ( ',' ) ;
    public final void rule__CallRule__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4038:1: ( ( ',' ) )
            // InternalDataDescriptionLanguage.g:4039:1: ( ',' )
            {
            // InternalDataDescriptionLanguage.g:4039:1: ( ',' )
            // InternalDataDescriptionLanguage.g:4040:2: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getCommaKeyword_2_1_0()); 
            }
            match(input,72,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:4049:1: rule__CallRule__Group_2_1__1 : rule__CallRule__Group_2_1__1__Impl ;
    public final void rule__CallRule__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4053:1: ( rule__CallRule__Group_2_1__1__Impl )
            // InternalDataDescriptionLanguage.g:4054:2: rule__CallRule__Group_2_1__1__Impl
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
    // InternalDataDescriptionLanguage.g:4060:1: rule__CallRule__Group_2_1__1__Impl : ( ( rule__CallRule__ParametersAssignment_2_1_1 ) ) ;
    public final void rule__CallRule__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4064:1: ( ( ( rule__CallRule__ParametersAssignment_2_1_1 ) ) )
            // InternalDataDescriptionLanguage.g:4065:1: ( ( rule__CallRule__ParametersAssignment_2_1_1 ) )
            {
            // InternalDataDescriptionLanguage.g:4065:1: ( ( rule__CallRule__ParametersAssignment_2_1_1 ) )
            // InternalDataDescriptionLanguage.g:4066:2: ( rule__CallRule__ParametersAssignment_2_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getParametersAssignment_2_1_1()); 
            }
            // InternalDataDescriptionLanguage.g:4067:2: ( rule__CallRule__ParametersAssignment_2_1_1 )
            // InternalDataDescriptionLanguage.g:4067:3: rule__CallRule__ParametersAssignment_2_1_1
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


    // $ANTLR start "rule__DoubleLiteralRule__Group__0"
    // InternalDataDescriptionLanguage.g:4076:1: rule__DoubleLiteralRule__Group__0 : rule__DoubleLiteralRule__Group__0__Impl rule__DoubleLiteralRule__Group__1 ;
    public final void rule__DoubleLiteralRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4080:1: ( rule__DoubleLiteralRule__Group__0__Impl rule__DoubleLiteralRule__Group__1 )
            // InternalDataDescriptionLanguage.g:4081:2: rule__DoubleLiteralRule__Group__0__Impl rule__DoubleLiteralRule__Group__1
            {
            pushFollow(FOLLOW_39);
            rule__DoubleLiteralRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__DoubleLiteralRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalDataDescriptionLanguage.g:4088:1: rule__DoubleLiteralRule__Group__0__Impl : ( ( rule__DoubleLiteralRule__LiteralAssignment_0 ) ) ;
    public final void rule__DoubleLiteralRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4092:1: ( ( ( rule__DoubleLiteralRule__LiteralAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:4093:1: ( ( rule__DoubleLiteralRule__LiteralAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:4093:1: ( ( rule__DoubleLiteralRule__LiteralAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:4094:2: ( rule__DoubleLiteralRule__LiteralAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDoubleLiteralRuleAccess().getLiteralAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:4095:2: ( rule__DoubleLiteralRule__LiteralAssignment_0 )
            // InternalDataDescriptionLanguage.g:4095:3: rule__DoubleLiteralRule__LiteralAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__DoubleLiteralRule__LiteralAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDoubleLiteralRuleAccess().getLiteralAssignment_0()); 
            }

            }


            }

        }
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
    // InternalDataDescriptionLanguage.g:4103:1: rule__DoubleLiteralRule__Group__1 : rule__DoubleLiteralRule__Group__1__Impl ;
    public final void rule__DoubleLiteralRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4107:1: ( rule__DoubleLiteralRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:4108:2: rule__DoubleLiteralRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DoubleLiteralRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalDataDescriptionLanguage.g:4114:1: rule__DoubleLiteralRule__Group__1__Impl : ( ( rule__DoubleLiteralRule__FactorAssignment_1 )? ) ;
    public final void rule__DoubleLiteralRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4118:1: ( ( ( rule__DoubleLiteralRule__FactorAssignment_1 )? ) )
            // InternalDataDescriptionLanguage.g:4119:1: ( ( rule__DoubleLiteralRule__FactorAssignment_1 )? )
            {
            // InternalDataDescriptionLanguage.g:4119:1: ( ( rule__DoubleLiteralRule__FactorAssignment_1 )? )
            // InternalDataDescriptionLanguage.g:4120:2: ( rule__DoubleLiteralRule__FactorAssignment_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDoubleLiteralRuleAccess().getFactorAssignment_1()); 
            }
            // InternalDataDescriptionLanguage.g:4121:2: ( rule__DoubleLiteralRule__FactorAssignment_1 )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( ((LA40_0>=35 && LA40_0<=54)) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:4121:3: rule__DoubleLiteralRule__FactorAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__DoubleLiteralRule__FactorAssignment_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDoubleLiteralRuleAccess().getFactorAssignment_1()); 
            }

            }


            }

        }
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
    // InternalDataDescriptionLanguage.g:4130:1: rule__IntegerLiteralRule__Group__0 : rule__IntegerLiteralRule__Group__0__Impl rule__IntegerLiteralRule__Group__1 ;
    public final void rule__IntegerLiteralRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4134:1: ( rule__IntegerLiteralRule__Group__0__Impl rule__IntegerLiteralRule__Group__1 )
            // InternalDataDescriptionLanguage.g:4135:2: rule__IntegerLiteralRule__Group__0__Impl rule__IntegerLiteralRule__Group__1
            {
            pushFollow(FOLLOW_39);
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
    // InternalDataDescriptionLanguage.g:4142:1: rule__IntegerLiteralRule__Group__0__Impl : ( ( rule__IntegerLiteralRule__LiteralAssignment_0 ) ) ;
    public final void rule__IntegerLiteralRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4146:1: ( ( ( rule__IntegerLiteralRule__LiteralAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:4147:1: ( ( rule__IntegerLiteralRule__LiteralAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:4147:1: ( ( rule__IntegerLiteralRule__LiteralAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:4148:2: ( rule__IntegerLiteralRule__LiteralAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegerLiteralRuleAccess().getLiteralAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:4149:2: ( rule__IntegerLiteralRule__LiteralAssignment_0 )
            // InternalDataDescriptionLanguage.g:4149:3: rule__IntegerLiteralRule__LiteralAssignment_0
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
    // InternalDataDescriptionLanguage.g:4157:1: rule__IntegerLiteralRule__Group__1 : rule__IntegerLiteralRule__Group__1__Impl ;
    public final void rule__IntegerLiteralRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4161:1: ( rule__IntegerLiteralRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:4162:2: rule__IntegerLiteralRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:4168:1: rule__IntegerLiteralRule__Group__1__Impl : ( ( rule__IntegerLiteralRule__FactorAssignment_1 )? ) ;
    public final void rule__IntegerLiteralRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4172:1: ( ( ( rule__IntegerLiteralRule__FactorAssignment_1 )? ) )
            // InternalDataDescriptionLanguage.g:4173:1: ( ( rule__IntegerLiteralRule__FactorAssignment_1 )? )
            {
            // InternalDataDescriptionLanguage.g:4173:1: ( ( rule__IntegerLiteralRule__FactorAssignment_1 )? )
            // InternalDataDescriptionLanguage.g:4174:2: ( rule__IntegerLiteralRule__FactorAssignment_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegerLiteralRuleAccess().getFactorAssignment_1()); 
            }
            // InternalDataDescriptionLanguage.g:4175:2: ( rule__IntegerLiteralRule__FactorAssignment_1 )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( ((LA41_0>=35 && LA41_0<=54)) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:4175:3: rule__IntegerLiteralRule__FactorAssignment_1
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
    // InternalDataDescriptionLanguage.g:4184:1: rule__BooleanLiteralRule__Group__0 : rule__BooleanLiteralRule__Group__0__Impl rule__BooleanLiteralRule__Group__1 ;
    public final void rule__BooleanLiteralRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4188:1: ( rule__BooleanLiteralRule__Group__0__Impl rule__BooleanLiteralRule__Group__1 )
            // InternalDataDescriptionLanguage.g:4189:2: rule__BooleanLiteralRule__Group__0__Impl rule__BooleanLiteralRule__Group__1
            {
            pushFollow(FOLLOW_40);
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
    // InternalDataDescriptionLanguage.g:4196:1: rule__BooleanLiteralRule__Group__0__Impl : ( () ) ;
    public final void rule__BooleanLiteralRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4200:1: ( ( () ) )
            // InternalDataDescriptionLanguage.g:4201:1: ( () )
            {
            // InternalDataDescriptionLanguage.g:4201:1: ( () )
            // InternalDataDescriptionLanguage.g:4202:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralRuleAccess().getBooleanLiteralAction_0()); 
            }
            // InternalDataDescriptionLanguage.g:4203:2: ()
            // InternalDataDescriptionLanguage.g:4203:3: 
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
    // InternalDataDescriptionLanguage.g:4211:1: rule__BooleanLiteralRule__Group__1 : rule__BooleanLiteralRule__Group__1__Impl ;
    public final void rule__BooleanLiteralRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4215:1: ( rule__BooleanLiteralRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:4216:2: rule__BooleanLiteralRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:4222:1: rule__BooleanLiteralRule__Group__1__Impl : ( ( rule__BooleanLiteralRule__Alternatives_1 ) ) ;
    public final void rule__BooleanLiteralRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4226:1: ( ( ( rule__BooleanLiteralRule__Alternatives_1 ) ) )
            // InternalDataDescriptionLanguage.g:4227:1: ( ( rule__BooleanLiteralRule__Alternatives_1 ) )
            {
            // InternalDataDescriptionLanguage.g:4227:1: ( ( rule__BooleanLiteralRule__Alternatives_1 ) )
            // InternalDataDescriptionLanguage.g:4228:2: ( rule__BooleanLiteralRule__Alternatives_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralRuleAccess().getAlternatives_1()); 
            }
            // InternalDataDescriptionLanguage.g:4229:2: ( rule__BooleanLiteralRule__Alternatives_1 )
            // InternalDataDescriptionLanguage.g:4229:3: rule__BooleanLiteralRule__Alternatives_1
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


    // $ANTLR start "rule__DataDescriptionModelRule__UsesAssignment_1"
    // InternalDataDescriptionLanguage.g:4238:1: rule__DataDescriptionModelRule__UsesAssignment_1 : ( ruleUseRule ) ;
    public final void rule__DataDescriptionModelRule__UsesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4242:1: ( ( ruleUseRule ) )
            // InternalDataDescriptionLanguage.g:4243:2: ( ruleUseRule )
            {
            // InternalDataDescriptionLanguage.g:4243:2: ( ruleUseRule )
            // InternalDataDescriptionLanguage.g:4244:3: ruleUseRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getUsesUseRuleParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleUseRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataDescriptionModelRuleAccess().getUsesUseRuleParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataDescriptionModelRule__UsesAssignment_1"


    // $ANTLR start "rule__DataDescriptionModelRule__TypesAssignment_2_2"
    // InternalDataDescriptionLanguage.g:4253:1: rule__DataDescriptionModelRule__TypesAssignment_2_2 : ( ruleDataTypeRule ) ;
    public final void rule__DataDescriptionModelRule__TypesAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4257:1: ( ( ruleDataTypeRule ) )
            // InternalDataDescriptionLanguage.g:4258:2: ( ruleDataTypeRule )
            {
            // InternalDataDescriptionLanguage.g:4258:2: ( ruleDataTypeRule )
            // InternalDataDescriptionLanguage.g:4259:3: ruleDataTypeRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getTypesDataTypeRuleParserRuleCall_2_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleDataTypeRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataDescriptionModelRuleAccess().getTypesDataTypeRuleParserRuleCall_2_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataDescriptionModelRule__TypesAssignment_2_2"


    // $ANTLR start "rule__DataDescriptionModelRule__DescriptionsAssignment_3_2"
    // InternalDataDescriptionLanguage.g:4268:1: rule__DataDescriptionModelRule__DescriptionsAssignment_3_2 : ( ruleDataDescriptionRule ) ;
    public final void rule__DataDescriptionModelRule__DescriptionsAssignment_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4272:1: ( ( ruleDataDescriptionRule ) )
            // InternalDataDescriptionLanguage.g:4273:2: ( ruleDataDescriptionRule )
            {
            // InternalDataDescriptionLanguage.g:4273:2: ( ruleDataDescriptionRule )
            // InternalDataDescriptionLanguage.g:4274:3: ruleDataDescriptionRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getDescriptionsDataDescriptionRuleParserRuleCall_3_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleDataDescriptionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataDescriptionModelRuleAccess().getDescriptionsDataDescriptionRuleParserRuleCall_3_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataDescriptionModelRule__DescriptionsAssignment_3_2"


    // $ANTLR start "rule__DataDescriptionModelRule__ConstraintsAssignment_4_2"
    // InternalDataDescriptionLanguage.g:4283:1: rule__DataDescriptionModelRule__ConstraintsAssignment_4_2 : ( ruleStatementRule ) ;
    public final void rule__DataDescriptionModelRule__ConstraintsAssignment_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4287:1: ( ( ruleStatementRule ) )
            // InternalDataDescriptionLanguage.g:4288:2: ( ruleStatementRule )
            {
            // InternalDataDescriptionLanguage.g:4288:2: ( ruleStatementRule )
            // InternalDataDescriptionLanguage.g:4289:3: ruleStatementRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getConstraintsStatementRuleParserRuleCall_4_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleStatementRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataDescriptionModelRuleAccess().getConstraintsStatementRuleParserRuleCall_4_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataDescriptionModelRule__ConstraintsAssignment_4_2"


    // $ANTLR start "rule__UseRule__ImportURIAssignment_1"
    // InternalDataDescriptionLanguage.g:4298:1: rule__UseRule__ImportURIAssignment_1 : ( RULE_STRING ) ;
    public final void rule__UseRule__ImportURIAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4302:1: ( ( RULE_STRING ) )
            // InternalDataDescriptionLanguage.g:4303:2: ( RULE_STRING )
            {
            // InternalDataDescriptionLanguage.g:4303:2: ( RULE_STRING )
            // InternalDataDescriptionLanguage.g:4304:3: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUseRuleAccess().getImportURISTRINGTerminalRuleCall_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUseRuleAccess().getImportURISTRINGTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UseRule__ImportURIAssignment_1"


    // $ANTLR start "rule__DataTypeRule__ScaleAssignment_0"
    // InternalDataDescriptionLanguage.g:4313:1: rule__DataTypeRule__ScaleAssignment_0 : ( ruleScaleType ) ;
    public final void rule__DataTypeRule__ScaleAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4317:1: ( ( ruleScaleType ) )
            // InternalDataDescriptionLanguage.g:4318:2: ( ruleScaleType )
            {
            // InternalDataDescriptionLanguage.g:4318:2: ( ruleScaleType )
            // InternalDataDescriptionLanguage.g:4319:3: ruleScaleType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getScaleScaleTypeEnumRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleScaleType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataTypeRuleAccess().getScaleScaleTypeEnumRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeRule__ScaleAssignment_0"


    // $ANTLR start "rule__DataTypeRule__NameAssignment_2"
    // InternalDataDescriptionLanguage.g:4328:1: rule__DataTypeRule__NameAssignment_2 : ( ruleStringOrId ) ;
    public final void rule__DataTypeRule__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4332:1: ( ( ruleStringOrId ) )
            // InternalDataDescriptionLanguage.g:4333:2: ( ruleStringOrId )
            {
            // InternalDataDescriptionLanguage.g:4333:2: ( ruleStringOrId )
            // InternalDataDescriptionLanguage.g:4334:3: ruleStringOrId
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getNameStringOrIdParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleStringOrId();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataTypeRuleAccess().getNameStringOrIdParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeRule__NameAssignment_2"


    // $ANTLR start "rule__DataTypeRule__DescriptionAssignment_3_2"
    // InternalDataDescriptionLanguage.g:4343:1: rule__DataTypeRule__DescriptionAssignment_3_2 : ( RULE_STRING ) ;
    public final void rule__DataTypeRule__DescriptionAssignment_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4347:1: ( ( RULE_STRING ) )
            // InternalDataDescriptionLanguage.g:4348:2: ( RULE_STRING )
            {
            // InternalDataDescriptionLanguage.g:4348:2: ( RULE_STRING )
            // InternalDataDescriptionLanguage.g:4349:3: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getDescriptionSTRINGTerminalRuleCall_3_2_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataTypeRuleAccess().getDescriptionSTRINGTerminalRuleCall_3_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeRule__DescriptionAssignment_3_2"


    // $ANTLR start "rule__DataTypeRule__ConstraintsAssignment_4_3"
    // InternalDataDescriptionLanguage.g:4358:1: rule__DataTypeRule__ConstraintsAssignment_4_3 : ( ruleStatementRule ) ;
    public final void rule__DataTypeRule__ConstraintsAssignment_4_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4362:1: ( ( ruleStatementRule ) )
            // InternalDataDescriptionLanguage.g:4363:2: ( ruleStatementRule )
            {
            // InternalDataDescriptionLanguage.g:4363:2: ( ruleStatementRule )
            // InternalDataDescriptionLanguage.g:4364:3: ruleStatementRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getConstraintsStatementRuleParserRuleCall_4_3_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleStatementRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataTypeRuleAccess().getConstraintsStatementRuleParserRuleCall_4_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeRule__ConstraintsAssignment_4_3"


    // $ANTLR start "rule__TypedDataDescriptionRule__RepresentationAssignment_0"
    // InternalDataDescriptionLanguage.g:4373:1: rule__TypedDataDescriptionRule__RepresentationAssignment_0 : ( ruleRepresentationType ) ;
    public final void rule__TypedDataDescriptionRule__RepresentationAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4377:1: ( ( ruleRepresentationType ) )
            // InternalDataDescriptionLanguage.g:4378:2: ( ruleRepresentationType )
            {
            // InternalDataDescriptionLanguage.g:4378:2: ( ruleRepresentationType )
            // InternalDataDescriptionLanguage.g:4379:3: ruleRepresentationType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedDataDescriptionRuleAccess().getRepresentationRepresentationTypeEnumRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleRepresentationType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedDataDescriptionRuleAccess().getRepresentationRepresentationTypeEnumRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedDataDescriptionRule__RepresentationAssignment_0"


    // $ANTLR start "rule__TypedDataDescriptionRule__NameAssignment_2"
    // InternalDataDescriptionLanguage.g:4388:1: rule__TypedDataDescriptionRule__NameAssignment_2 : ( ruleStringOrId ) ;
    public final void rule__TypedDataDescriptionRule__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4392:1: ( ( ruleStringOrId ) )
            // InternalDataDescriptionLanguage.g:4393:2: ( ruleStringOrId )
            {
            // InternalDataDescriptionLanguage.g:4393:2: ( ruleStringOrId )
            // InternalDataDescriptionLanguage.g:4394:3: ruleStringOrId
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedDataDescriptionRuleAccess().getNameStringOrIdParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleStringOrId();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedDataDescriptionRuleAccess().getNameStringOrIdParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedDataDescriptionRule__NameAssignment_2"


    // $ANTLR start "rule__TypedDataDescriptionRule__TypeAssignment_5"
    // InternalDataDescriptionLanguage.g:4403:1: rule__TypedDataDescriptionRule__TypeAssignment_5 : ( ( ruleStringOrId ) ) ;
    public final void rule__TypedDataDescriptionRule__TypeAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4407:1: ( ( ( ruleStringOrId ) ) )
            // InternalDataDescriptionLanguage.g:4408:2: ( ( ruleStringOrId ) )
            {
            // InternalDataDescriptionLanguage.g:4408:2: ( ( ruleStringOrId ) )
            // InternalDataDescriptionLanguage.g:4409:3: ( ruleStringOrId )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedDataDescriptionRuleAccess().getTypeDataTypeCrossReference_5_0()); 
            }
            // InternalDataDescriptionLanguage.g:4410:3: ( ruleStringOrId )
            // InternalDataDescriptionLanguage.g:4411:4: ruleStringOrId
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedDataDescriptionRuleAccess().getTypeDataTypeStringOrIdParserRuleCall_5_0_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleStringOrId();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedDataDescriptionRuleAccess().getTypeDataTypeStringOrIdParserRuleCall_5_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedDataDescriptionRuleAccess().getTypeDataTypeCrossReference_5_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedDataDescriptionRule__TypeAssignment_5"


    // $ANTLR start "rule__TypedDataDescriptionRule__ConstraintsAssignment_6_3"
    // InternalDataDescriptionLanguage.g:4422:1: rule__TypedDataDescriptionRule__ConstraintsAssignment_6_3 : ( ruleStatementRule ) ;
    public final void rule__TypedDataDescriptionRule__ConstraintsAssignment_6_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4426:1: ( ( ruleStatementRule ) )
            // InternalDataDescriptionLanguage.g:4427:2: ( ruleStatementRule )
            {
            // InternalDataDescriptionLanguage.g:4427:2: ( ruleStatementRule )
            // InternalDataDescriptionLanguage.g:4428:3: ruleStatementRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedDataDescriptionRuleAccess().getConstraintsStatementRuleParserRuleCall_6_3_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleStatementRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedDataDescriptionRuleAccess().getConstraintsStatementRuleParserRuleCall_6_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedDataDescriptionRule__ConstraintsAssignment_6_3"


    // $ANTLR start "rule__UntypedDataDescriptionRule__ScaleAssignment_0"
    // InternalDataDescriptionLanguage.g:4437:1: rule__UntypedDataDescriptionRule__ScaleAssignment_0 : ( ruleScaleType ) ;
    public final void rule__UntypedDataDescriptionRule__ScaleAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4441:1: ( ( ruleScaleType ) )
            // InternalDataDescriptionLanguage.g:4442:2: ( ruleScaleType )
            {
            // InternalDataDescriptionLanguage.g:4442:2: ( ruleScaleType )
            // InternalDataDescriptionLanguage.g:4443:3: ruleScaleType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUntypedDataDescriptionRuleAccess().getScaleScaleTypeEnumRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleScaleType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUntypedDataDescriptionRuleAccess().getScaleScaleTypeEnumRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntypedDataDescriptionRule__ScaleAssignment_0"


    // $ANTLR start "rule__UntypedDataDescriptionRule__RepresentationAssignment_1"
    // InternalDataDescriptionLanguage.g:4452:1: rule__UntypedDataDescriptionRule__RepresentationAssignment_1 : ( ruleRepresentationType ) ;
    public final void rule__UntypedDataDescriptionRule__RepresentationAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4456:1: ( ( ruleRepresentationType ) )
            // InternalDataDescriptionLanguage.g:4457:2: ( ruleRepresentationType )
            {
            // InternalDataDescriptionLanguage.g:4457:2: ( ruleRepresentationType )
            // InternalDataDescriptionLanguage.g:4458:3: ruleRepresentationType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUntypedDataDescriptionRuleAccess().getRepresentationRepresentationTypeEnumRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleRepresentationType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUntypedDataDescriptionRuleAccess().getRepresentationRepresentationTypeEnumRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntypedDataDescriptionRule__RepresentationAssignment_1"


    // $ANTLR start "rule__UntypedDataDescriptionRule__NameAssignment_3"
    // InternalDataDescriptionLanguage.g:4467:1: rule__UntypedDataDescriptionRule__NameAssignment_3 : ( ruleStringOrId ) ;
    public final void rule__UntypedDataDescriptionRule__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4471:1: ( ( ruleStringOrId ) )
            // InternalDataDescriptionLanguage.g:4472:2: ( ruleStringOrId )
            {
            // InternalDataDescriptionLanguage.g:4472:2: ( ruleStringOrId )
            // InternalDataDescriptionLanguage.g:4473:3: ruleStringOrId
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUntypedDataDescriptionRuleAccess().getNameStringOrIdParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleStringOrId();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUntypedDataDescriptionRuleAccess().getNameStringOrIdParserRuleCall_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntypedDataDescriptionRule__NameAssignment_3"


    // $ANTLR start "rule__UntypedDataDescriptionRule__ConstraintsAssignment_4_3"
    // InternalDataDescriptionLanguage.g:4482:1: rule__UntypedDataDescriptionRule__ConstraintsAssignment_4_3 : ( ruleStatementRule ) ;
    public final void rule__UntypedDataDescriptionRule__ConstraintsAssignment_4_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4486:1: ( ( ruleStatementRule ) )
            // InternalDataDescriptionLanguage.g:4487:2: ( ruleStatementRule )
            {
            // InternalDataDescriptionLanguage.g:4487:2: ( ruleStatementRule )
            // InternalDataDescriptionLanguage.g:4488:3: ruleStatementRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUntypedDataDescriptionRuleAccess().getConstraintsStatementRuleParserRuleCall_4_3_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleStatementRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUntypedDataDescriptionRuleAccess().getConstraintsStatementRuleParserRuleCall_4_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntypedDataDescriptionRule__ConstraintsAssignment_4_3"


    // $ANTLR start "rule__FunctionNameRule__DefinitionAssignment"
    // InternalDataDescriptionLanguage.g:4497:1: rule__FunctionNameRule__DefinitionAssignment : ( ( RULE_ID ) ) ;
    public final void rule__FunctionNameRule__DefinitionAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4501:1: ( ( ( RULE_ID ) ) )
            // InternalDataDescriptionLanguage.g:4502:2: ( ( RULE_ID ) )
            {
            // InternalDataDescriptionLanguage.g:4502:2: ( ( RULE_ID ) )
            // InternalDataDescriptionLanguage.g:4503:3: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionNameRuleAccess().getDefinitionFunctionDefinitionCrossReference_0()); 
            }
            // InternalDataDescriptionLanguage.g:4504:3: ( RULE_ID )
            // InternalDataDescriptionLanguage.g:4505:4: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionNameRuleAccess().getDefinitionFunctionDefinitionIDTerminalRuleCall_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunctionNameRuleAccess().getDefinitionFunctionDefinitionIDTerminalRuleCall_0_1()); 
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


    // $ANTLR start "rule__DataReferenceRule__DefinitionAssignment"
    // InternalDataDescriptionLanguage.g:4516:1: rule__DataReferenceRule__DefinitionAssignment : ( ( ruleStringOrId ) ) ;
    public final void rule__DataReferenceRule__DefinitionAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4520:1: ( ( ( ruleStringOrId ) ) )
            // InternalDataDescriptionLanguage.g:4521:2: ( ( ruleStringOrId ) )
            {
            // InternalDataDescriptionLanguage.g:4521:2: ( ( ruleStringOrId ) )
            // InternalDataDescriptionLanguage.g:4522:3: ( ruleStringOrId )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataReferenceRuleAccess().getDefinitionDataDescriptionCrossReference_0()); 
            }
            // InternalDataDescriptionLanguage.g:4523:3: ( ruleStringOrId )
            // InternalDataDescriptionLanguage.g:4524:4: ruleStringOrId
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataReferenceRuleAccess().getDefinitionDataDescriptionStringOrIdParserRuleCall_0_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleStringOrId();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataReferenceRuleAccess().getDefinitionDataDescriptionStringOrIdParserRuleCall_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataReferenceRuleAccess().getDefinitionDataDescriptionCrossReference_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataReferenceRule__DefinitionAssignment"


    // $ANTLR start "rule__OrExpressionRule__SubExpressionsAssignment_0"
    // InternalDataDescriptionLanguage.g:4535:1: rule__OrExpressionRule__SubExpressionsAssignment_0 : ( ruleXorExpressionRule ) ;
    public final void rule__OrExpressionRule__SubExpressionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4539:1: ( ( ruleXorExpressionRule ) )
            // InternalDataDescriptionLanguage.g:4540:2: ( ruleXorExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:4540:2: ( ruleXorExpressionRule )
            // InternalDataDescriptionLanguage.g:4541:3: ruleXorExpressionRule
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
    // InternalDataDescriptionLanguage.g:4550:1: rule__OrExpressionRule__SubExpressionsAssignment_1_1 : ( ruleXorExpressionRule ) ;
    public final void rule__OrExpressionRule__SubExpressionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4554:1: ( ( ruleXorExpressionRule ) )
            // InternalDataDescriptionLanguage.g:4555:2: ( ruleXorExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:4555:2: ( ruleXorExpressionRule )
            // InternalDataDescriptionLanguage.g:4556:3: ruleXorExpressionRule
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
    // InternalDataDescriptionLanguage.g:4565:1: rule__XorExpressionRule__SubExpressionsAssignment_0 : ( ruleAndExpressionRule ) ;
    public final void rule__XorExpressionRule__SubExpressionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4569:1: ( ( ruleAndExpressionRule ) )
            // InternalDataDescriptionLanguage.g:4570:2: ( ruleAndExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:4570:2: ( ruleAndExpressionRule )
            // InternalDataDescriptionLanguage.g:4571:3: ruleAndExpressionRule
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
    // InternalDataDescriptionLanguage.g:4580:1: rule__XorExpressionRule__SubExpressionsAssignment_1_1 : ( ruleAndExpressionRule ) ;
    public final void rule__XorExpressionRule__SubExpressionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4584:1: ( ( ruleAndExpressionRule ) )
            // InternalDataDescriptionLanguage.g:4585:2: ( ruleAndExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:4585:2: ( ruleAndExpressionRule )
            // InternalDataDescriptionLanguage.g:4586:3: ruleAndExpressionRule
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
    // InternalDataDescriptionLanguage.g:4595:1: rule__AndExpressionRule__SubExpressionsAssignment_0 : ( ruleNotExpressionRule ) ;
    public final void rule__AndExpressionRule__SubExpressionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4599:1: ( ( ruleNotExpressionRule ) )
            // InternalDataDescriptionLanguage.g:4600:2: ( ruleNotExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:4600:2: ( ruleNotExpressionRule )
            // InternalDataDescriptionLanguage.g:4601:3: ruleNotExpressionRule
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
    // InternalDataDescriptionLanguage.g:4610:1: rule__AndExpressionRule__SubExpressionsAssignment_1_1 : ( ruleNotExpressionRule ) ;
    public final void rule__AndExpressionRule__SubExpressionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4614:1: ( ( ruleNotExpressionRule ) )
            // InternalDataDescriptionLanguage.g:4615:2: ( ruleNotExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:4615:2: ( ruleNotExpressionRule )
            // InternalDataDescriptionLanguage.g:4616:3: ruleNotExpressionRule
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
    // InternalDataDescriptionLanguage.g:4625:1: rule__NotExpressionRule__NegatedAssignment_0 : ( ( '!' ) ) ;
    public final void rule__NotExpressionRule__NegatedAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4629:1: ( ( ( '!' ) ) )
            // InternalDataDescriptionLanguage.g:4630:2: ( ( '!' ) )
            {
            // InternalDataDescriptionLanguage.g:4630:2: ( ( '!' ) )
            // InternalDataDescriptionLanguage.g:4631:3: ( '!' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNotExpressionRuleAccess().getNegatedExclamationMarkKeyword_0_0()); 
            }
            // InternalDataDescriptionLanguage.g:4632:3: ( '!' )
            // InternalDataDescriptionLanguage.g:4633:4: '!'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNotExpressionRuleAccess().getNegatedExclamationMarkKeyword_0_0()); 
            }
            match(input,73,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:4644:1: rule__NotExpressionRule__OperandAssignment_1 : ( ruleComparisonExpressionRule ) ;
    public final void rule__NotExpressionRule__OperandAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4648:1: ( ( ruleComparisonExpressionRule ) )
            // InternalDataDescriptionLanguage.g:4649:2: ( ruleComparisonExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:4649:2: ( ruleComparisonExpressionRule )
            // InternalDataDescriptionLanguage.g:4650:3: ruleComparisonExpressionRule
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
    // InternalDataDescriptionLanguage.g:4659:1: rule__ComparisonExpressionRule__LeftOperandAssignment_0 : ( ruleAddOrSubtractExpressionRule ) ;
    public final void rule__ComparisonExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4663:1: ( ( ruleAddOrSubtractExpressionRule ) )
            // InternalDataDescriptionLanguage.g:4664:2: ( ruleAddOrSubtractExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:4664:2: ( ruleAddOrSubtractExpressionRule )
            // InternalDataDescriptionLanguage.g:4665:3: ruleAddOrSubtractExpressionRule
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
    // InternalDataDescriptionLanguage.g:4674:1: rule__ComparisonExpressionRule__ComparisonAssignment_1 : ( rulePartialComparisonExpressionRule ) ;
    public final void rule__ComparisonExpressionRule__ComparisonAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4678:1: ( ( rulePartialComparisonExpressionRule ) )
            // InternalDataDescriptionLanguage.g:4679:2: ( rulePartialComparisonExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:4679:2: ( rulePartialComparisonExpressionRule )
            // InternalDataDescriptionLanguage.g:4680:3: rulePartialComparisonExpressionRule
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
    // InternalDataDescriptionLanguage.g:4689:1: rule__PartialComparisonExpressionRule__OperatorAssignment_0 : ( ruleComparisonOperatorRule ) ;
    public final void rule__PartialComparisonExpressionRule__OperatorAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4693:1: ( ( ruleComparisonOperatorRule ) )
            // InternalDataDescriptionLanguage.g:4694:2: ( ruleComparisonOperatorRule )
            {
            // InternalDataDescriptionLanguage.g:4694:2: ( ruleComparisonOperatorRule )
            // InternalDataDescriptionLanguage.g:4695:3: ruleComparisonOperatorRule
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
    // InternalDataDescriptionLanguage.g:4704:1: rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 : ( ruleAddOrSubtractExpressionRule ) ;
    public final void rule__PartialComparisonExpressionRule__SubExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4708:1: ( ( ruleAddOrSubtractExpressionRule ) )
            // InternalDataDescriptionLanguage.g:4709:2: ( ruleAddOrSubtractExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:4709:2: ( ruleAddOrSubtractExpressionRule )
            // InternalDataDescriptionLanguage.g:4710:3: ruleAddOrSubtractExpressionRule
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
    // InternalDataDescriptionLanguage.g:4719:1: rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 : ( ruleMultiplyDivideModuloExpressionRule ) ;
    public final void rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4723:1: ( ( ruleMultiplyDivideModuloExpressionRule ) )
            // InternalDataDescriptionLanguage.g:4724:2: ( ruleMultiplyDivideModuloExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:4724:2: ( ruleMultiplyDivideModuloExpressionRule )
            // InternalDataDescriptionLanguage.g:4725:3: ruleMultiplyDivideModuloExpressionRule
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
    // InternalDataDescriptionLanguage.g:4734:1: rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 : ( ruleAddOrSubtractOperatorRule ) ;
    public final void rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4738:1: ( ( ruleAddOrSubtractOperatorRule ) )
            // InternalDataDescriptionLanguage.g:4739:2: ( ruleAddOrSubtractOperatorRule )
            {
            // InternalDataDescriptionLanguage.g:4739:2: ( ruleAddOrSubtractOperatorRule )
            // InternalDataDescriptionLanguage.g:4740:3: ruleAddOrSubtractOperatorRule
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
    // InternalDataDescriptionLanguage.g:4749:1: rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 : ( ruleMultiplyDivideModuloExpressionRule ) ;
    public final void rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4753:1: ( ( ruleMultiplyDivideModuloExpressionRule ) )
            // InternalDataDescriptionLanguage.g:4754:2: ( ruleMultiplyDivideModuloExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:4754:2: ( ruleMultiplyDivideModuloExpressionRule )
            // InternalDataDescriptionLanguage.g:4755:3: ruleMultiplyDivideModuloExpressionRule
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
    // InternalDataDescriptionLanguage.g:4764:1: rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 : ( rulePowerOfExpressionRule ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4768:1: ( ( rulePowerOfExpressionRule ) )
            // InternalDataDescriptionLanguage.g:4769:2: ( rulePowerOfExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:4769:2: ( rulePowerOfExpressionRule )
            // InternalDataDescriptionLanguage.g:4770:3: rulePowerOfExpressionRule
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
    // InternalDataDescriptionLanguage.g:4779:1: rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 : ( ruleMultiplyDivideModuloOperatorRule ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4783:1: ( ( ruleMultiplyDivideModuloOperatorRule ) )
            // InternalDataDescriptionLanguage.g:4784:2: ( ruleMultiplyDivideModuloOperatorRule )
            {
            // InternalDataDescriptionLanguage.g:4784:2: ( ruleMultiplyDivideModuloOperatorRule )
            // InternalDataDescriptionLanguage.g:4785:3: ruleMultiplyDivideModuloOperatorRule
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
    // InternalDataDescriptionLanguage.g:4794:1: rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 : ( rulePowerOfExpressionRule ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4798:1: ( ( rulePowerOfExpressionRule ) )
            // InternalDataDescriptionLanguage.g:4799:2: ( rulePowerOfExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:4799:2: ( rulePowerOfExpressionRule )
            // InternalDataDescriptionLanguage.g:4800:3: rulePowerOfExpressionRule
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
    // InternalDataDescriptionLanguage.g:4809:1: rule__PowerOfExpressionRule__LeftOperandAssignment_0 : ( ruleUnaryAddOrSubtractExpressionRule ) ;
    public final void rule__PowerOfExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4813:1: ( ( ruleUnaryAddOrSubtractExpressionRule ) )
            // InternalDataDescriptionLanguage.g:4814:2: ( ruleUnaryAddOrSubtractExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:4814:2: ( ruleUnaryAddOrSubtractExpressionRule )
            // InternalDataDescriptionLanguage.g:4815:3: ruleUnaryAddOrSubtractExpressionRule
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
    // InternalDataDescriptionLanguage.g:4824:1: rule__PowerOfExpressionRule__RightOperandAssignment_1_1 : ( rulePowerOfExpressionRule ) ;
    public final void rule__PowerOfExpressionRule__RightOperandAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4828:1: ( ( rulePowerOfExpressionRule ) )
            // InternalDataDescriptionLanguage.g:4829:2: ( rulePowerOfExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:4829:2: ( rulePowerOfExpressionRule )
            // InternalDataDescriptionLanguage.g:4830:3: rulePowerOfExpressionRule
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
    // InternalDataDescriptionLanguage.g:4839:1: rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 : ( ruleAddOrSubtractOperatorRule ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4843:1: ( ( ruleAddOrSubtractOperatorRule ) )
            // InternalDataDescriptionLanguage.g:4844:2: ( ruleAddOrSubtractOperatorRule )
            {
            // InternalDataDescriptionLanguage.g:4844:2: ( ruleAddOrSubtractOperatorRule )
            // InternalDataDescriptionLanguage.g:4845:3: ruleAddOrSubtractOperatorRule
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
    // InternalDataDescriptionLanguage.g:4854:1: rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 : ( ruleLiteralOrReferenceRule ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4858:1: ( ( ruleLiteralOrReferenceRule ) )
            // InternalDataDescriptionLanguage.g:4859:2: ( ruleLiteralOrReferenceRule )
            {
            // InternalDataDescriptionLanguage.g:4859:2: ( ruleLiteralOrReferenceRule )
            // InternalDataDescriptionLanguage.g:4860:3: ruleLiteralOrReferenceRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getSubExpressionLiteralOrReferenceRuleParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleLiteralOrReferenceRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getSubExpressionLiteralOrReferenceRuleParserRuleCall_1_0()); 
            }

            }


            }

        }
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
    // InternalDataDescriptionLanguage.g:4869:1: rule__ParanthesesRule__SubExpressionAssignment_1 : ( ruleExpressionRule ) ;
    public final void rule__ParanthesesRule__SubExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4873:1: ( ( ruleExpressionRule ) )
            // InternalDataDescriptionLanguage.g:4874:2: ( ruleExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:4874:2: ( ruleExpressionRule )
            // InternalDataDescriptionLanguage.g:4875:3: ruleExpressionRule
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
    // InternalDataDescriptionLanguage.g:4884:1: rule__CallRule__FunctionAssignment_0 : ( ruleFunctionNameRule ) ;
    public final void rule__CallRule__FunctionAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4888:1: ( ( ruleFunctionNameRule ) )
            // InternalDataDescriptionLanguage.g:4889:2: ( ruleFunctionNameRule )
            {
            // InternalDataDescriptionLanguage.g:4889:2: ( ruleFunctionNameRule )
            // InternalDataDescriptionLanguage.g:4890:3: ruleFunctionNameRule
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
    // InternalDataDescriptionLanguage.g:4899:1: rule__CallRule__ParametersAssignment_2_0 : ( ruleExpressionRule ) ;
    public final void rule__CallRule__ParametersAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4903:1: ( ( ruleExpressionRule ) )
            // InternalDataDescriptionLanguage.g:4904:2: ( ruleExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:4904:2: ( ruleExpressionRule )
            // InternalDataDescriptionLanguage.g:4905:3: ruleExpressionRule
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
    // InternalDataDescriptionLanguage.g:4914:1: rule__CallRule__ParametersAssignment_2_1_1 : ( ruleExpressionRule ) ;
    public final void rule__CallRule__ParametersAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4918:1: ( ( ruleExpressionRule ) )
            // InternalDataDescriptionLanguage.g:4919:2: ( ruleExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:4919:2: ( ruleExpressionRule )
            // InternalDataDescriptionLanguage.g:4920:3: ruleExpressionRule
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


    // $ANTLR start "rule__DoubleLiteralRule__LiteralAssignment_0"
    // InternalDataDescriptionLanguage.g:4929:1: rule__DoubleLiteralRule__LiteralAssignment_0 : ( RULE_DOUBLE ) ;
    public final void rule__DoubleLiteralRule__LiteralAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4933:1: ( ( RULE_DOUBLE ) )
            // InternalDataDescriptionLanguage.g:4934:2: ( RULE_DOUBLE )
            {
            // InternalDataDescriptionLanguage.g:4934:2: ( RULE_DOUBLE )
            // InternalDataDescriptionLanguage.g:4935:3: RULE_DOUBLE
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDoubleLiteralRuleAccess().getLiteralDOUBLETerminalRuleCall_0_0()); 
            }
            match(input,RULE_DOUBLE,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDoubleLiteralRuleAccess().getLiteralDOUBLETerminalRuleCall_0_0()); 
            }

            }


            }

        }
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
    // InternalDataDescriptionLanguage.g:4944:1: rule__DoubleLiteralRule__FactorAssignment_1 : ( ruleFactorRule ) ;
    public final void rule__DoubleLiteralRule__FactorAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4948:1: ( ( ruleFactorRule ) )
            // InternalDataDescriptionLanguage.g:4949:2: ( ruleFactorRule )
            {
            // InternalDataDescriptionLanguage.g:4949:2: ( ruleFactorRule )
            // InternalDataDescriptionLanguage.g:4950:3: ruleFactorRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDoubleLiteralRuleAccess().getFactorFactorRuleEnumRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleFactorRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDoubleLiteralRuleAccess().getFactorFactorRuleEnumRuleCall_1_0()); 
            }

            }


            }

        }
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
    // InternalDataDescriptionLanguage.g:4959:1: rule__IntegerLiteralRule__LiteralAssignment_0 : ( RULE_INT ) ;
    public final void rule__IntegerLiteralRule__LiteralAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4963:1: ( ( RULE_INT ) )
            // InternalDataDescriptionLanguage.g:4964:2: ( RULE_INT )
            {
            // InternalDataDescriptionLanguage.g:4964:2: ( RULE_INT )
            // InternalDataDescriptionLanguage.g:4965:3: RULE_INT
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
    // InternalDataDescriptionLanguage.g:4974:1: rule__IntegerLiteralRule__FactorAssignment_1 : ( ruleFactorRule ) ;
    public final void rule__IntegerLiteralRule__FactorAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4978:1: ( ( ruleFactorRule ) )
            // InternalDataDescriptionLanguage.g:4979:2: ( ruleFactorRule )
            {
            // InternalDataDescriptionLanguage.g:4979:2: ( ruleFactorRule )
            // InternalDataDescriptionLanguage.g:4980:3: ruleFactorRule
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
    // InternalDataDescriptionLanguage.g:4989:1: rule__StringLiteralRule__ValueAssignment : ( RULE_STRING ) ;
    public final void rule__StringLiteralRule__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4993:1: ( ( RULE_STRING ) )
            // InternalDataDescriptionLanguage.g:4994:2: ( RULE_STRING )
            {
            // InternalDataDescriptionLanguage.g:4994:2: ( RULE_STRING )
            // InternalDataDescriptionLanguage.g:4995:3: RULE_STRING
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
    // InternalDataDescriptionLanguage.g:5004:1: rule__BooleanLiteralRule__ValueAssignment_1_0 : ( ( 'true' ) ) ;
    public final void rule__BooleanLiteralRule__ValueAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5008:1: ( ( ( 'true' ) ) )
            // InternalDataDescriptionLanguage.g:5009:2: ( ( 'true' ) )
            {
            // InternalDataDescriptionLanguage.g:5009:2: ( ( 'true' ) )
            // InternalDataDescriptionLanguage.g:5010:3: ( 'true' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralRuleAccess().getValueTrueKeyword_1_0_0()); 
            }
            // InternalDataDescriptionLanguage.g:5011:3: ( 'true' )
            // InternalDataDescriptionLanguage.g:5012:4: 'true'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralRuleAccess().getValueTrueKeyword_1_0_0()); 
            }
            match(input,74,FOLLOW_2); if (state.failed) return ;
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

    // Delegated rules


    protected DFA1 dfa1 = new DFA1(this);
    static final String dfa_1s = "\12\uffff";
    static final String dfa_2s = "\1\20\4\71\1\uffff\1\4\2\74\1\uffff";
    static final String dfa_3s = "\1\27\4\71\1\uffff\1\5\2\100\1\uffff";
    static final String dfa_4s = "\5\uffff\1\2\3\uffff\1\1";
    static final String dfa_5s = "\12\uffff}>";
    static final String[] dfa_6s = {
            "\4\5\1\1\1\2\1\3\1\4",
            "\1\6",
            "\1\6",
            "\1\6",
            "\1\6",
            "",
            "\1\7\1\10",
            "\1\5\2\uffff\1\5\1\11",
            "\1\5\2\uffff\1\5\1\11",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA1 extends DFA {

        public DFA1(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 1;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "950:1: rule__DataDescriptionRule__Alternatives : ( ( ruleTypedDataDescriptionRule ) | ( ruleUntypedDataDescriptionRule ) );";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0E80000000000000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x00000000000F0000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x00000000000F0002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000FF0000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000FF0002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x00000000C00081F0L,0x0000000000000642L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x00000000C00081F2L,0x0000000000000642L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0xD000000000000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x9000000000000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000008L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x000000003F000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x000000003F000002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x00000000C0000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x00000000C0000002L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000700000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000700000002L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x00000000C00081F0L,0x00000000000006C2L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x007FFFF800000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x00000000000081C0L,0x0000000000000400L});

}
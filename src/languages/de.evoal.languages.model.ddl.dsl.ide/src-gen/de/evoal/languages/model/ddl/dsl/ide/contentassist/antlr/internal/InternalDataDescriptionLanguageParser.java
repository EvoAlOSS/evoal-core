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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_QUOTED_ID", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'false'", "'nominal'", "'ordinal'", "'cardinal'", "'quotient'", "'real'", "'integer'", "'boolean'", "'string'", "'>='", "'>'", "'='", "'!='", "'<'", "'<='", "'+'", "'-'", "'*'", "'/'", "'%'", "'Y'", "'Z'", "'E'", "'P'", "'T'", "'G'", "'M'", "'k'", "'h'", "'da'", "'d'", "'c'", "'m'", "'\\u00B5'", "'n'", "'p'", "'f'", "'a'", "'z'", "'y'", "'types'", "':'", "'data'", "'constraints'", "'use'", "';'", "'type'", "'description'", "'with'", "'of'", "'value'", "'OR'", "'XOR'", "'AND'", "'^'", "'('", "')'", "','", "'.'", "'!'", "'true'"
    };
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
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
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


    // $ANTLR start "entryRuleDOUBLE"
    // InternalDataDescriptionLanguage.g:855:1: entryRuleDOUBLE : ruleDOUBLE EOF ;
    public final void entryRuleDOUBLE() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:856:1: ( ruleDOUBLE EOF )
            // InternalDataDescriptionLanguage.g:857:1: ruleDOUBLE EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDOUBLERule()); 
            }
            pushFollow(FOLLOW_1);
            ruleDOUBLE();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDOUBLERule()); 
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
    // $ANTLR end "entryRuleDOUBLE"


    // $ANTLR start "ruleDOUBLE"
    // InternalDataDescriptionLanguage.g:864:1: ruleDOUBLE : ( ( rule__DOUBLE__Group__0 ) ) ;
    public final void ruleDOUBLE() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:868:2: ( ( ( rule__DOUBLE__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:869:2: ( ( rule__DOUBLE__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:869:2: ( ( rule__DOUBLE__Group__0 ) )
            // InternalDataDescriptionLanguage.g:870:3: ( rule__DOUBLE__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDOUBLEAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:871:3: ( rule__DOUBLE__Group__0 )
            // InternalDataDescriptionLanguage.g:871:4: rule__DOUBLE__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DOUBLE__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDOUBLEAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDOUBLE"


    // $ANTLR start "ruleScaleType"
    // InternalDataDescriptionLanguage.g:880:1: ruleScaleType : ( ( rule__ScaleType__Alternatives ) ) ;
    public final void ruleScaleType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:884:1: ( ( ( rule__ScaleType__Alternatives ) ) )
            // InternalDataDescriptionLanguage.g:885:2: ( ( rule__ScaleType__Alternatives ) )
            {
            // InternalDataDescriptionLanguage.g:885:2: ( ( rule__ScaleType__Alternatives ) )
            // InternalDataDescriptionLanguage.g:886:3: ( rule__ScaleType__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScaleTypeAccess().getAlternatives()); 
            }
            // InternalDataDescriptionLanguage.g:887:3: ( rule__ScaleType__Alternatives )
            // InternalDataDescriptionLanguage.g:887:4: rule__ScaleType__Alternatives
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
    // InternalDataDescriptionLanguage.g:896:1: ruleRepresentationType : ( ( rule__RepresentationType__Alternatives ) ) ;
    public final void ruleRepresentationType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:900:1: ( ( ( rule__RepresentationType__Alternatives ) ) )
            // InternalDataDescriptionLanguage.g:901:2: ( ( rule__RepresentationType__Alternatives ) )
            {
            // InternalDataDescriptionLanguage.g:901:2: ( ( rule__RepresentationType__Alternatives ) )
            // InternalDataDescriptionLanguage.g:902:3: ( rule__RepresentationType__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRepresentationTypeAccess().getAlternatives()); 
            }
            // InternalDataDescriptionLanguage.g:903:3: ( rule__RepresentationType__Alternatives )
            // InternalDataDescriptionLanguage.g:903:4: rule__RepresentationType__Alternatives
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
    // InternalDataDescriptionLanguage.g:912:1: ruleComparisonOperatorRule : ( ( rule__ComparisonOperatorRule__Alternatives ) ) ;
    public final void ruleComparisonOperatorRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:916:1: ( ( ( rule__ComparisonOperatorRule__Alternatives ) ) )
            // InternalDataDescriptionLanguage.g:917:2: ( ( rule__ComparisonOperatorRule__Alternatives ) )
            {
            // InternalDataDescriptionLanguage.g:917:2: ( ( rule__ComparisonOperatorRule__Alternatives ) )
            // InternalDataDescriptionLanguage.g:918:3: ( rule__ComparisonOperatorRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonOperatorRuleAccess().getAlternatives()); 
            }
            // InternalDataDescriptionLanguage.g:919:3: ( rule__ComparisonOperatorRule__Alternatives )
            // InternalDataDescriptionLanguage.g:919:4: rule__ComparisonOperatorRule__Alternatives
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
    // InternalDataDescriptionLanguage.g:928:1: ruleAddOrSubtractOperatorRule : ( ( rule__AddOrSubtractOperatorRule__Alternatives ) ) ;
    public final void ruleAddOrSubtractOperatorRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:932:1: ( ( ( rule__AddOrSubtractOperatorRule__Alternatives ) ) )
            // InternalDataDescriptionLanguage.g:933:2: ( ( rule__AddOrSubtractOperatorRule__Alternatives ) )
            {
            // InternalDataDescriptionLanguage.g:933:2: ( ( rule__AddOrSubtractOperatorRule__Alternatives ) )
            // InternalDataDescriptionLanguage.g:934:3: ( rule__AddOrSubtractOperatorRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOrSubtractOperatorRuleAccess().getAlternatives()); 
            }
            // InternalDataDescriptionLanguage.g:935:3: ( rule__AddOrSubtractOperatorRule__Alternatives )
            // InternalDataDescriptionLanguage.g:935:4: rule__AddOrSubtractOperatorRule__Alternatives
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
    // InternalDataDescriptionLanguage.g:944:1: ruleMultiplyDivideModuloOperatorRule : ( ( rule__MultiplyDivideModuloOperatorRule__Alternatives ) ) ;
    public final void ruleMultiplyDivideModuloOperatorRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:948:1: ( ( ( rule__MultiplyDivideModuloOperatorRule__Alternatives ) ) )
            // InternalDataDescriptionLanguage.g:949:2: ( ( rule__MultiplyDivideModuloOperatorRule__Alternatives ) )
            {
            // InternalDataDescriptionLanguage.g:949:2: ( ( rule__MultiplyDivideModuloOperatorRule__Alternatives ) )
            // InternalDataDescriptionLanguage.g:950:3: ( rule__MultiplyDivideModuloOperatorRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getAlternatives()); 
            }
            // InternalDataDescriptionLanguage.g:951:3: ( rule__MultiplyDivideModuloOperatorRule__Alternatives )
            // InternalDataDescriptionLanguage.g:951:4: rule__MultiplyDivideModuloOperatorRule__Alternatives
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
    // InternalDataDescriptionLanguage.g:960:1: ruleFactorRule : ( ( rule__FactorRule__Alternatives ) ) ;
    public final void ruleFactorRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:964:1: ( ( ( rule__FactorRule__Alternatives ) ) )
            // InternalDataDescriptionLanguage.g:965:2: ( ( rule__FactorRule__Alternatives ) )
            {
            // InternalDataDescriptionLanguage.g:965:2: ( ( rule__FactorRule__Alternatives ) )
            // InternalDataDescriptionLanguage.g:966:3: ( rule__FactorRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFactorRuleAccess().getAlternatives()); 
            }
            // InternalDataDescriptionLanguage.g:967:3: ( rule__FactorRule__Alternatives )
            // InternalDataDescriptionLanguage.g:967:4: rule__FactorRule__Alternatives
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
    // InternalDataDescriptionLanguage.g:975:1: rule__DataDescriptionRule__Alternatives : ( ( ruleTypedDataDescriptionRule ) | ( ruleUntypedDataDescriptionRule ) );
    public final void rule__DataDescriptionRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:979:1: ( ( ruleTypedDataDescriptionRule ) | ( ruleUntypedDataDescriptionRule ) )
            int alt1=2;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:980:2: ( ruleTypedDataDescriptionRule )
                    {
                    // InternalDataDescriptionLanguage.g:980:2: ( ruleTypedDataDescriptionRule )
                    // InternalDataDescriptionLanguage.g:981:3: ruleTypedDataDescriptionRule
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
                    // InternalDataDescriptionLanguage.g:986:2: ( ruleUntypedDataDescriptionRule )
                    {
                    // InternalDataDescriptionLanguage.g:986:2: ( ruleUntypedDataDescriptionRule )
                    // InternalDataDescriptionLanguage.g:987:3: ruleUntypedDataDescriptionRule
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
    // InternalDataDescriptionLanguage.g:996:1: rule__ValueReferenceRule__Alternatives : ( ( ruleDataReferenceRule ) | ( ruleSelfReferenceRule ) );
    public final void rule__ValueReferenceRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1000:1: ( ( ruleDataReferenceRule ) | ( ruleSelfReferenceRule ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( ((LA2_0>=RULE_QUOTED_ID && LA2_0<=RULE_ID)) ) {
                alt2=1;
            }
            else if ( (LA2_0==62) ) {
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
                    // InternalDataDescriptionLanguage.g:1001:2: ( ruleDataReferenceRule )
                    {
                    // InternalDataDescriptionLanguage.g:1001:2: ( ruleDataReferenceRule )
                    // InternalDataDescriptionLanguage.g:1002:3: ruleDataReferenceRule
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
                    // InternalDataDescriptionLanguage.g:1007:2: ( ruleSelfReferenceRule )
                    {
                    // InternalDataDescriptionLanguage.g:1007:2: ( ruleSelfReferenceRule )
                    // InternalDataDescriptionLanguage.g:1008:3: ruleSelfReferenceRule
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
    // InternalDataDescriptionLanguage.g:1017:1: rule__LiteralOrReferenceRule__Alternatives : ( ( ruleCallRule ) | ( ruleLiteralRule ) | ( ruleParanthesesRule ) | ( ruleValueReferenceRule ) );
    public final void rule__LiteralOrReferenceRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1021:1: ( ( ruleCallRule ) | ( ruleLiteralRule ) | ( ruleParanthesesRule ) | ( ruleValueReferenceRule ) )
            int alt3=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==67) ) {
                    alt3=1;
                }
                else if ( (LA3_1==EOF||(LA3_1>=21 && LA3_1<=31)||LA3_1==57||(LA3_1>=63 && LA3_1<=66)||(LA3_1>=68 && LA3_1<=69)) ) {
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
            case RULE_INT:
            case RULE_STRING:
            case 12:
            case 72:
                {
                alt3=2;
                }
                break;
            case 67:
                {
                alt3=3;
                }
                break;
            case RULE_QUOTED_ID:
            case 62:
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
                    // InternalDataDescriptionLanguage.g:1022:2: ( ruleCallRule )
                    {
                    // InternalDataDescriptionLanguage.g:1022:2: ( ruleCallRule )
                    // InternalDataDescriptionLanguage.g:1023:3: ruleCallRule
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
                    // InternalDataDescriptionLanguage.g:1028:2: ( ruleLiteralRule )
                    {
                    // InternalDataDescriptionLanguage.g:1028:2: ( ruleLiteralRule )
                    // InternalDataDescriptionLanguage.g:1029:3: ruleLiteralRule
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
                    // InternalDataDescriptionLanguage.g:1034:2: ( ruleParanthesesRule )
                    {
                    // InternalDataDescriptionLanguage.g:1034:2: ( ruleParanthesesRule )
                    // InternalDataDescriptionLanguage.g:1035:3: ruleParanthesesRule
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
                    // InternalDataDescriptionLanguage.g:1040:2: ( ruleValueReferenceRule )
                    {
                    // InternalDataDescriptionLanguage.g:1040:2: ( ruleValueReferenceRule )
                    // InternalDataDescriptionLanguage.g:1041:3: ruleValueReferenceRule
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
    // InternalDataDescriptionLanguage.g:1050:1: rule__LiteralRule__Alternatives : ( ( ruleNumberLiteralRule ) | ( ruleStringLiteralRule ) | ( ruleBooleanLiteralRule ) );
    public final void rule__LiteralRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1054:1: ( ( ruleNumberLiteralRule ) | ( ruleStringLiteralRule ) | ( ruleBooleanLiteralRule ) )
            int alt4=3;
            switch ( input.LA(1) ) {
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
            case 12:
            case 72:
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
                    // InternalDataDescriptionLanguage.g:1055:2: ( ruleNumberLiteralRule )
                    {
                    // InternalDataDescriptionLanguage.g:1055:2: ( ruleNumberLiteralRule )
                    // InternalDataDescriptionLanguage.g:1056:3: ruleNumberLiteralRule
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
                    // InternalDataDescriptionLanguage.g:1061:2: ( ruleStringLiteralRule )
                    {
                    // InternalDataDescriptionLanguage.g:1061:2: ( ruleStringLiteralRule )
                    // InternalDataDescriptionLanguage.g:1062:3: ruleStringLiteralRule
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
                    // InternalDataDescriptionLanguage.g:1067:2: ( ruleBooleanLiteralRule )
                    {
                    // InternalDataDescriptionLanguage.g:1067:2: ( ruleBooleanLiteralRule )
                    // InternalDataDescriptionLanguage.g:1068:3: ruleBooleanLiteralRule
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
    // InternalDataDescriptionLanguage.g:1077:1: rule__NumberLiteralRule__Alternatives : ( ( ruleDoubleLiteralRule ) | ( ruleIntegerLiteralRule ) );
    public final void rule__NumberLiteralRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1081:1: ( ( ruleDoubleLiteralRule ) | ( ruleIntegerLiteralRule ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_INT) ) {
                int LA5_1 = input.LA(2);

                if ( ((LA5_1>=32 && LA5_1<=51)) ) {
                    alt5=2;
                }
                else if ( (LA5_1==70) ) {
                    alt5=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:1082:2: ( ruleDoubleLiteralRule )
                    {
                    // InternalDataDescriptionLanguage.g:1082:2: ( ruleDoubleLiteralRule )
                    // InternalDataDescriptionLanguage.g:1083:3: ruleDoubleLiteralRule
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
                    // InternalDataDescriptionLanguage.g:1088:2: ( ruleIntegerLiteralRule )
                    {
                    // InternalDataDescriptionLanguage.g:1088:2: ( ruleIntegerLiteralRule )
                    // InternalDataDescriptionLanguage.g:1089:3: ruleIntegerLiteralRule
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
    // InternalDataDescriptionLanguage.g:1098:1: rule__BooleanLiteralRule__Alternatives_1 : ( ( ( rule__BooleanLiteralRule__ValueAssignment_1_0 ) ) | ( 'false' ) );
    public final void rule__BooleanLiteralRule__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1102:1: ( ( ( rule__BooleanLiteralRule__ValueAssignment_1_0 ) ) | ( 'false' ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==72) ) {
                alt6=1;
            }
            else if ( (LA6_0==12) ) {
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
                    // InternalDataDescriptionLanguage.g:1103:2: ( ( rule__BooleanLiteralRule__ValueAssignment_1_0 ) )
                    {
                    // InternalDataDescriptionLanguage.g:1103:2: ( ( rule__BooleanLiteralRule__ValueAssignment_1_0 ) )
                    // InternalDataDescriptionLanguage.g:1104:3: ( rule__BooleanLiteralRule__ValueAssignment_1_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBooleanLiteralRuleAccess().getValueAssignment_1_0()); 
                    }
                    // InternalDataDescriptionLanguage.g:1105:3: ( rule__BooleanLiteralRule__ValueAssignment_1_0 )
                    // InternalDataDescriptionLanguage.g:1105:4: rule__BooleanLiteralRule__ValueAssignment_1_0
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
                    // InternalDataDescriptionLanguage.g:1109:2: ( 'false' )
                    {
                    // InternalDataDescriptionLanguage.g:1109:2: ( 'false' )
                    // InternalDataDescriptionLanguage.g:1110:3: 'false'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBooleanLiteralRuleAccess().getFalseKeyword_1_1()); 
                    }
                    match(input,12,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:1119:1: rule__StringOrId__Alternatives : ( ( RULE_QUOTED_ID ) | ( RULE_ID ) );
    public final void rule__StringOrId__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1123:1: ( ( RULE_QUOTED_ID ) | ( RULE_ID ) )
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
                    // InternalDataDescriptionLanguage.g:1124:2: ( RULE_QUOTED_ID )
                    {
                    // InternalDataDescriptionLanguage.g:1124:2: ( RULE_QUOTED_ID )
                    // InternalDataDescriptionLanguage.g:1125:3: RULE_QUOTED_ID
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
                    // InternalDataDescriptionLanguage.g:1130:2: ( RULE_ID )
                    {
                    // InternalDataDescriptionLanguage.g:1130:2: ( RULE_ID )
                    // InternalDataDescriptionLanguage.g:1131:3: RULE_ID
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
    // InternalDataDescriptionLanguage.g:1140:1: rule__ScaleType__Alternatives : ( ( ( 'nominal' ) ) | ( ( 'ordinal' ) ) | ( ( 'cardinal' ) ) | ( ( 'quotient' ) ) );
    public final void rule__ScaleType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1144:1: ( ( ( 'nominal' ) ) | ( ( 'ordinal' ) ) | ( ( 'cardinal' ) ) | ( ( 'quotient' ) ) )
            int alt8=4;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt8=1;
                }
                break;
            case 14:
                {
                alt8=2;
                }
                break;
            case 15:
                {
                alt8=3;
                }
                break;
            case 16:
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
                    // InternalDataDescriptionLanguage.g:1145:2: ( ( 'nominal' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1145:2: ( ( 'nominal' ) )
                    // InternalDataDescriptionLanguage.g:1146:3: ( 'nominal' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getScaleTypeAccess().getNominalEnumLiteralDeclaration_0()); 
                    }
                    // InternalDataDescriptionLanguage.g:1147:3: ( 'nominal' )
                    // InternalDataDescriptionLanguage.g:1147:4: 'nominal'
                    {
                    match(input,13,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getScaleTypeAccess().getNominalEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalDataDescriptionLanguage.g:1151:2: ( ( 'ordinal' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1151:2: ( ( 'ordinal' ) )
                    // InternalDataDescriptionLanguage.g:1152:3: ( 'ordinal' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getScaleTypeAccess().getOrdinalEnumLiteralDeclaration_1()); 
                    }
                    // InternalDataDescriptionLanguage.g:1153:3: ( 'ordinal' )
                    // InternalDataDescriptionLanguage.g:1153:4: 'ordinal'
                    {
                    match(input,14,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getScaleTypeAccess().getOrdinalEnumLiteralDeclaration_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalDataDescriptionLanguage.g:1157:2: ( ( 'cardinal' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1157:2: ( ( 'cardinal' ) )
                    // InternalDataDescriptionLanguage.g:1158:3: ( 'cardinal' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getScaleTypeAccess().getCardinalEnumLiteralDeclaration_2()); 
                    }
                    // InternalDataDescriptionLanguage.g:1159:3: ( 'cardinal' )
                    // InternalDataDescriptionLanguage.g:1159:4: 'cardinal'
                    {
                    match(input,15,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getScaleTypeAccess().getCardinalEnumLiteralDeclaration_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalDataDescriptionLanguage.g:1163:2: ( ( 'quotient' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1163:2: ( ( 'quotient' ) )
                    // InternalDataDescriptionLanguage.g:1164:3: ( 'quotient' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getScaleTypeAccess().getQuotientEnumLiteralDeclaration_3()); 
                    }
                    // InternalDataDescriptionLanguage.g:1165:3: ( 'quotient' )
                    // InternalDataDescriptionLanguage.g:1165:4: 'quotient'
                    {
                    match(input,16,FOLLOW_2); if (state.failed) return ;

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
    // InternalDataDescriptionLanguage.g:1173:1: rule__RepresentationType__Alternatives : ( ( ( 'real' ) ) | ( ( 'integer' ) ) | ( ( 'boolean' ) ) | ( ( 'string' ) ) );
    public final void rule__RepresentationType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1177:1: ( ( ( 'real' ) ) | ( ( 'integer' ) ) | ( ( 'boolean' ) ) | ( ( 'string' ) ) )
            int alt9=4;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt9=1;
                }
                break;
            case 18:
                {
                alt9=2;
                }
                break;
            case 19:
                {
                alt9=3;
                }
                break;
            case 20:
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
                    // InternalDataDescriptionLanguage.g:1178:2: ( ( 'real' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1178:2: ( ( 'real' ) )
                    // InternalDataDescriptionLanguage.g:1179:3: ( 'real' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRepresentationTypeAccess().getRealEnumLiteralDeclaration_0()); 
                    }
                    // InternalDataDescriptionLanguage.g:1180:3: ( 'real' )
                    // InternalDataDescriptionLanguage.g:1180:4: 'real'
                    {
                    match(input,17,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRepresentationTypeAccess().getRealEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalDataDescriptionLanguage.g:1184:2: ( ( 'integer' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1184:2: ( ( 'integer' ) )
                    // InternalDataDescriptionLanguage.g:1185:3: ( 'integer' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRepresentationTypeAccess().getIntegerEnumLiteralDeclaration_1()); 
                    }
                    // InternalDataDescriptionLanguage.g:1186:3: ( 'integer' )
                    // InternalDataDescriptionLanguage.g:1186:4: 'integer'
                    {
                    match(input,18,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRepresentationTypeAccess().getIntegerEnumLiteralDeclaration_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalDataDescriptionLanguage.g:1190:2: ( ( 'boolean' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1190:2: ( ( 'boolean' ) )
                    // InternalDataDescriptionLanguage.g:1191:3: ( 'boolean' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRepresentationTypeAccess().getBooleanEnumLiteralDeclaration_2()); 
                    }
                    // InternalDataDescriptionLanguage.g:1192:3: ( 'boolean' )
                    // InternalDataDescriptionLanguage.g:1192:4: 'boolean'
                    {
                    match(input,19,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRepresentationTypeAccess().getBooleanEnumLiteralDeclaration_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalDataDescriptionLanguage.g:1196:2: ( ( 'string' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1196:2: ( ( 'string' ) )
                    // InternalDataDescriptionLanguage.g:1197:3: ( 'string' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRepresentationTypeAccess().getStringEnumLiteralDeclaration_3()); 
                    }
                    // InternalDataDescriptionLanguage.g:1198:3: ( 'string' )
                    // InternalDataDescriptionLanguage.g:1198:4: 'string'
                    {
                    match(input,20,FOLLOW_2); if (state.failed) return ;

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
    // InternalDataDescriptionLanguage.g:1206:1: rule__ComparisonOperatorRule__Alternatives : ( ( ( '>=' ) ) | ( ( '>' ) ) | ( ( '=' ) ) | ( ( '!=' ) ) | ( ( '<' ) ) | ( ( '<=' ) ) );
    public final void rule__ComparisonOperatorRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1210:1: ( ( ( '>=' ) ) | ( ( '>' ) ) | ( ( '=' ) ) | ( ( '!=' ) ) | ( ( '<' ) ) | ( ( '<=' ) ) )
            int alt10=6;
            switch ( input.LA(1) ) {
            case 21:
                {
                alt10=1;
                }
                break;
            case 22:
                {
                alt10=2;
                }
                break;
            case 23:
                {
                alt10=3;
                }
                break;
            case 24:
                {
                alt10=4;
                }
                break;
            case 25:
                {
                alt10=5;
                }
                break;
            case 26:
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
                    // InternalDataDescriptionLanguage.g:1211:2: ( ( '>=' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1211:2: ( ( '>=' ) )
                    // InternalDataDescriptionLanguage.g:1212:3: ( '>=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getGreaterThanEnumLiteralDeclaration_0()); 
                    }
                    // InternalDataDescriptionLanguage.g:1213:3: ( '>=' )
                    // InternalDataDescriptionLanguage.g:1213:4: '>='
                    {
                    match(input,21,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getComparisonOperatorRuleAccess().getGreaterThanEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalDataDescriptionLanguage.g:1217:2: ( ( '>' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1217:2: ( ( '>' ) )
                    // InternalDataDescriptionLanguage.g:1218:3: ( '>' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getGreaterEqualEnumLiteralDeclaration_1()); 
                    }
                    // InternalDataDescriptionLanguage.g:1219:3: ( '>' )
                    // InternalDataDescriptionLanguage.g:1219:4: '>'
                    {
                    match(input,22,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getComparisonOperatorRuleAccess().getGreaterEqualEnumLiteralDeclaration_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalDataDescriptionLanguage.g:1223:2: ( ( '=' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1223:2: ( ( '=' ) )
                    // InternalDataDescriptionLanguage.g:1224:3: ( '=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getEqualEnumLiteralDeclaration_2()); 
                    }
                    // InternalDataDescriptionLanguage.g:1225:3: ( '=' )
                    // InternalDataDescriptionLanguage.g:1225:4: '='
                    {
                    match(input,23,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getComparisonOperatorRuleAccess().getEqualEnumLiteralDeclaration_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalDataDescriptionLanguage.g:1229:2: ( ( '!=' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1229:2: ( ( '!=' ) )
                    // InternalDataDescriptionLanguage.g:1230:3: ( '!=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getUnequalEnumLiteralDeclaration_3()); 
                    }
                    // InternalDataDescriptionLanguage.g:1231:3: ( '!=' )
                    // InternalDataDescriptionLanguage.g:1231:4: '!='
                    {
                    match(input,24,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getComparisonOperatorRuleAccess().getUnequalEnumLiteralDeclaration_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalDataDescriptionLanguage.g:1235:2: ( ( '<' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1235:2: ( ( '<' ) )
                    // InternalDataDescriptionLanguage.g:1236:3: ( '<' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getLessEqualEnumLiteralDeclaration_4()); 
                    }
                    // InternalDataDescriptionLanguage.g:1237:3: ( '<' )
                    // InternalDataDescriptionLanguage.g:1237:4: '<'
                    {
                    match(input,25,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getComparisonOperatorRuleAccess().getLessEqualEnumLiteralDeclaration_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalDataDescriptionLanguage.g:1241:2: ( ( '<=' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1241:2: ( ( '<=' ) )
                    // InternalDataDescriptionLanguage.g:1242:3: ( '<=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getLessThanEnumLiteralDeclaration_5()); 
                    }
                    // InternalDataDescriptionLanguage.g:1243:3: ( '<=' )
                    // InternalDataDescriptionLanguage.g:1243:4: '<='
                    {
                    match(input,26,FOLLOW_2); if (state.failed) return ;

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
    // InternalDataDescriptionLanguage.g:1251:1: rule__AddOrSubtractOperatorRule__Alternatives : ( ( ( '+' ) ) | ( ( '-' ) ) );
    public final void rule__AddOrSubtractOperatorRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1255:1: ( ( ( '+' ) ) | ( ( '-' ) ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==27) ) {
                alt11=1;
            }
            else if ( (LA11_0==28) ) {
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
                    // InternalDataDescriptionLanguage.g:1256:2: ( ( '+' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1256:2: ( ( '+' ) )
                    // InternalDataDescriptionLanguage.g:1257:3: ( '+' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAddOrSubtractOperatorRuleAccess().getAddEnumLiteralDeclaration_0()); 
                    }
                    // InternalDataDescriptionLanguage.g:1258:3: ( '+' )
                    // InternalDataDescriptionLanguage.g:1258:4: '+'
                    {
                    match(input,27,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAddOrSubtractOperatorRuleAccess().getAddEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalDataDescriptionLanguage.g:1262:2: ( ( '-' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1262:2: ( ( '-' ) )
                    // InternalDataDescriptionLanguage.g:1263:3: ( '-' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAddOrSubtractOperatorRuleAccess().getSubtractEnumLiteralDeclaration_1()); 
                    }
                    // InternalDataDescriptionLanguage.g:1264:3: ( '-' )
                    // InternalDataDescriptionLanguage.g:1264:4: '-'
                    {
                    match(input,28,FOLLOW_2); if (state.failed) return ;

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
    // InternalDataDescriptionLanguage.g:1272:1: rule__MultiplyDivideModuloOperatorRule__Alternatives : ( ( ( '*' ) ) | ( ( '/' ) ) | ( ( '%' ) ) );
    public final void rule__MultiplyDivideModuloOperatorRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1276:1: ( ( ( '*' ) ) | ( ( '/' ) ) | ( ( '%' ) ) )
            int alt12=3;
            switch ( input.LA(1) ) {
            case 29:
                {
                alt12=1;
                }
                break;
            case 30:
                {
                alt12=2;
                }
                break;
            case 31:
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
                    // InternalDataDescriptionLanguage.g:1277:2: ( ( '*' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1277:2: ( ( '*' ) )
                    // InternalDataDescriptionLanguage.g:1278:3: ( '*' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getMultiplyEnumLiteralDeclaration_0()); 
                    }
                    // InternalDataDescriptionLanguage.g:1279:3: ( '*' )
                    // InternalDataDescriptionLanguage.g:1279:4: '*'
                    {
                    match(input,29,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getMultiplyEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalDataDescriptionLanguage.g:1283:2: ( ( '/' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1283:2: ( ( '/' ) )
                    // InternalDataDescriptionLanguage.g:1284:3: ( '/' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getDivideEnumLiteralDeclaration_1()); 
                    }
                    // InternalDataDescriptionLanguage.g:1285:3: ( '/' )
                    // InternalDataDescriptionLanguage.g:1285:4: '/'
                    {
                    match(input,30,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getDivideEnumLiteralDeclaration_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalDataDescriptionLanguage.g:1289:2: ( ( '%' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1289:2: ( ( '%' ) )
                    // InternalDataDescriptionLanguage.g:1290:3: ( '%' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getModuloEnumLiteralDeclaration_2()); 
                    }
                    // InternalDataDescriptionLanguage.g:1291:3: ( '%' )
                    // InternalDataDescriptionLanguage.g:1291:4: '%'
                    {
                    match(input,31,FOLLOW_2); if (state.failed) return ;

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
    // InternalDataDescriptionLanguage.g:1299:1: rule__FactorRule__Alternatives : ( ( ( 'Y' ) ) | ( ( 'Z' ) ) | ( ( 'E' ) ) | ( ( 'P' ) ) | ( ( 'T' ) ) | ( ( 'G' ) ) | ( ( 'M' ) ) | ( ( 'k' ) ) | ( ( 'h' ) ) | ( ( 'da' ) ) | ( ( 'd' ) ) | ( ( 'c' ) ) | ( ( 'm' ) ) | ( ( '\\u00B5' ) ) | ( ( 'n' ) ) | ( ( 'p' ) ) | ( ( 'f' ) ) | ( ( 'a' ) ) | ( ( 'z' ) ) | ( ( 'y' ) ) );
    public final void rule__FactorRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1303:1: ( ( ( 'Y' ) ) | ( ( 'Z' ) ) | ( ( 'E' ) ) | ( ( 'P' ) ) | ( ( 'T' ) ) | ( ( 'G' ) ) | ( ( 'M' ) ) | ( ( 'k' ) ) | ( ( 'h' ) ) | ( ( 'da' ) ) | ( ( 'd' ) ) | ( ( 'c' ) ) | ( ( 'm' ) ) | ( ( '\\u00B5' ) ) | ( ( 'n' ) ) | ( ( 'p' ) ) | ( ( 'f' ) ) | ( ( 'a' ) ) | ( ( 'z' ) ) | ( ( 'y' ) ) )
            int alt13=20;
            switch ( input.LA(1) ) {
            case 32:
                {
                alt13=1;
                }
                break;
            case 33:
                {
                alt13=2;
                }
                break;
            case 34:
                {
                alt13=3;
                }
                break;
            case 35:
                {
                alt13=4;
                }
                break;
            case 36:
                {
                alt13=5;
                }
                break;
            case 37:
                {
                alt13=6;
                }
                break;
            case 38:
                {
                alt13=7;
                }
                break;
            case 39:
                {
                alt13=8;
                }
                break;
            case 40:
                {
                alt13=9;
                }
                break;
            case 41:
                {
                alt13=10;
                }
                break;
            case 42:
                {
                alt13=11;
                }
                break;
            case 43:
                {
                alt13=12;
                }
                break;
            case 44:
                {
                alt13=13;
                }
                break;
            case 45:
                {
                alt13=14;
                }
                break;
            case 46:
                {
                alt13=15;
                }
                break;
            case 47:
                {
                alt13=16;
                }
                break;
            case 48:
                {
                alt13=17;
                }
                break;
            case 49:
                {
                alt13=18;
                }
                break;
            case 50:
                {
                alt13=19;
                }
                break;
            case 51:
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
                    // InternalDataDescriptionLanguage.g:1304:2: ( ( 'Y' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1304:2: ( ( 'Y' ) )
                    // InternalDataDescriptionLanguage.g:1305:3: ( 'Y' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getYottaEnumLiteralDeclaration_0()); 
                    }
                    // InternalDataDescriptionLanguage.g:1306:3: ( 'Y' )
                    // InternalDataDescriptionLanguage.g:1306:4: 'Y'
                    {
                    match(input,32,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getYottaEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalDataDescriptionLanguage.g:1310:2: ( ( 'Z' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1310:2: ( ( 'Z' ) )
                    // InternalDataDescriptionLanguage.g:1311:3: ( 'Z' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getZettaEnumLiteralDeclaration_1()); 
                    }
                    // InternalDataDescriptionLanguage.g:1312:3: ( 'Z' )
                    // InternalDataDescriptionLanguage.g:1312:4: 'Z'
                    {
                    match(input,33,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getZettaEnumLiteralDeclaration_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalDataDescriptionLanguage.g:1316:2: ( ( 'E' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1316:2: ( ( 'E' ) )
                    // InternalDataDescriptionLanguage.g:1317:3: ( 'E' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getExaEnumLiteralDeclaration_2()); 
                    }
                    // InternalDataDescriptionLanguage.g:1318:3: ( 'E' )
                    // InternalDataDescriptionLanguage.g:1318:4: 'E'
                    {
                    match(input,34,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getExaEnumLiteralDeclaration_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalDataDescriptionLanguage.g:1322:2: ( ( 'P' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1322:2: ( ( 'P' ) )
                    // InternalDataDescriptionLanguage.g:1323:3: ( 'P' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getPetaEnumLiteralDeclaration_3()); 
                    }
                    // InternalDataDescriptionLanguage.g:1324:3: ( 'P' )
                    // InternalDataDescriptionLanguage.g:1324:4: 'P'
                    {
                    match(input,35,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getPetaEnumLiteralDeclaration_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalDataDescriptionLanguage.g:1328:2: ( ( 'T' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1328:2: ( ( 'T' ) )
                    // InternalDataDescriptionLanguage.g:1329:3: ( 'T' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getTeraEnumLiteralDeclaration_4()); 
                    }
                    // InternalDataDescriptionLanguage.g:1330:3: ( 'T' )
                    // InternalDataDescriptionLanguage.g:1330:4: 'T'
                    {
                    match(input,36,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getTeraEnumLiteralDeclaration_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalDataDescriptionLanguage.g:1334:2: ( ( 'G' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1334:2: ( ( 'G' ) )
                    // InternalDataDescriptionLanguage.g:1335:3: ( 'G' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getGigaEnumLiteralDeclaration_5()); 
                    }
                    // InternalDataDescriptionLanguage.g:1336:3: ( 'G' )
                    // InternalDataDescriptionLanguage.g:1336:4: 'G'
                    {
                    match(input,37,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getGigaEnumLiteralDeclaration_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalDataDescriptionLanguage.g:1340:2: ( ( 'M' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1340:2: ( ( 'M' ) )
                    // InternalDataDescriptionLanguage.g:1341:3: ( 'M' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getMegaEnumLiteralDeclaration_6()); 
                    }
                    // InternalDataDescriptionLanguage.g:1342:3: ( 'M' )
                    // InternalDataDescriptionLanguage.g:1342:4: 'M'
                    {
                    match(input,38,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getMegaEnumLiteralDeclaration_6()); 
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalDataDescriptionLanguage.g:1346:2: ( ( 'k' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1346:2: ( ( 'k' ) )
                    // InternalDataDescriptionLanguage.g:1347:3: ( 'k' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getKiloEnumLiteralDeclaration_7()); 
                    }
                    // InternalDataDescriptionLanguage.g:1348:3: ( 'k' )
                    // InternalDataDescriptionLanguage.g:1348:4: 'k'
                    {
                    match(input,39,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getKiloEnumLiteralDeclaration_7()); 
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalDataDescriptionLanguage.g:1352:2: ( ( 'h' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1352:2: ( ( 'h' ) )
                    // InternalDataDescriptionLanguage.g:1353:3: ( 'h' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getHectoEnumLiteralDeclaration_8()); 
                    }
                    // InternalDataDescriptionLanguage.g:1354:3: ( 'h' )
                    // InternalDataDescriptionLanguage.g:1354:4: 'h'
                    {
                    match(input,40,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getHectoEnumLiteralDeclaration_8()); 
                    }

                    }


                    }
                    break;
                case 10 :
                    // InternalDataDescriptionLanguage.g:1358:2: ( ( 'da' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1358:2: ( ( 'da' ) )
                    // InternalDataDescriptionLanguage.g:1359:3: ( 'da' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getDekaEnumLiteralDeclaration_9()); 
                    }
                    // InternalDataDescriptionLanguage.g:1360:3: ( 'da' )
                    // InternalDataDescriptionLanguage.g:1360:4: 'da'
                    {
                    match(input,41,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getDekaEnumLiteralDeclaration_9()); 
                    }

                    }


                    }
                    break;
                case 11 :
                    // InternalDataDescriptionLanguage.g:1364:2: ( ( 'd' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1364:2: ( ( 'd' ) )
                    // InternalDataDescriptionLanguage.g:1365:3: ( 'd' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getDeciEnumLiteralDeclaration_10()); 
                    }
                    // InternalDataDescriptionLanguage.g:1366:3: ( 'd' )
                    // InternalDataDescriptionLanguage.g:1366:4: 'd'
                    {
                    match(input,42,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getDeciEnumLiteralDeclaration_10()); 
                    }

                    }


                    }
                    break;
                case 12 :
                    // InternalDataDescriptionLanguage.g:1370:2: ( ( 'c' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1370:2: ( ( 'c' ) )
                    // InternalDataDescriptionLanguage.g:1371:3: ( 'c' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getCentiEnumLiteralDeclaration_11()); 
                    }
                    // InternalDataDescriptionLanguage.g:1372:3: ( 'c' )
                    // InternalDataDescriptionLanguage.g:1372:4: 'c'
                    {
                    match(input,43,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getCentiEnumLiteralDeclaration_11()); 
                    }

                    }


                    }
                    break;
                case 13 :
                    // InternalDataDescriptionLanguage.g:1376:2: ( ( 'm' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1376:2: ( ( 'm' ) )
                    // InternalDataDescriptionLanguage.g:1377:3: ( 'm' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getMilliEnumLiteralDeclaration_12()); 
                    }
                    // InternalDataDescriptionLanguage.g:1378:3: ( 'm' )
                    // InternalDataDescriptionLanguage.g:1378:4: 'm'
                    {
                    match(input,44,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getMilliEnumLiteralDeclaration_12()); 
                    }

                    }


                    }
                    break;
                case 14 :
                    // InternalDataDescriptionLanguage.g:1382:2: ( ( '\\u00B5' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1382:2: ( ( '\\u00B5' ) )
                    // InternalDataDescriptionLanguage.g:1383:3: ( '\\u00B5' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getMicroEnumLiteralDeclaration_13()); 
                    }
                    // InternalDataDescriptionLanguage.g:1384:3: ( '\\u00B5' )
                    // InternalDataDescriptionLanguage.g:1384:4: '\\u00B5'
                    {
                    match(input,45,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getMicroEnumLiteralDeclaration_13()); 
                    }

                    }


                    }
                    break;
                case 15 :
                    // InternalDataDescriptionLanguage.g:1388:2: ( ( 'n' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1388:2: ( ( 'n' ) )
                    // InternalDataDescriptionLanguage.g:1389:3: ( 'n' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getNanoEnumLiteralDeclaration_14()); 
                    }
                    // InternalDataDescriptionLanguage.g:1390:3: ( 'n' )
                    // InternalDataDescriptionLanguage.g:1390:4: 'n'
                    {
                    match(input,46,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getNanoEnumLiteralDeclaration_14()); 
                    }

                    }


                    }
                    break;
                case 16 :
                    // InternalDataDescriptionLanguage.g:1394:2: ( ( 'p' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1394:2: ( ( 'p' ) )
                    // InternalDataDescriptionLanguage.g:1395:3: ( 'p' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getPikoEnumLiteralDeclaration_15()); 
                    }
                    // InternalDataDescriptionLanguage.g:1396:3: ( 'p' )
                    // InternalDataDescriptionLanguage.g:1396:4: 'p'
                    {
                    match(input,47,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getPikoEnumLiteralDeclaration_15()); 
                    }

                    }


                    }
                    break;
                case 17 :
                    // InternalDataDescriptionLanguage.g:1400:2: ( ( 'f' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1400:2: ( ( 'f' ) )
                    // InternalDataDescriptionLanguage.g:1401:3: ( 'f' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getFemtoEnumLiteralDeclaration_16()); 
                    }
                    // InternalDataDescriptionLanguage.g:1402:3: ( 'f' )
                    // InternalDataDescriptionLanguage.g:1402:4: 'f'
                    {
                    match(input,48,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getFemtoEnumLiteralDeclaration_16()); 
                    }

                    }


                    }
                    break;
                case 18 :
                    // InternalDataDescriptionLanguage.g:1406:2: ( ( 'a' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1406:2: ( ( 'a' ) )
                    // InternalDataDescriptionLanguage.g:1407:3: ( 'a' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getAttoEnumLiteralDeclaration_17()); 
                    }
                    // InternalDataDescriptionLanguage.g:1408:3: ( 'a' )
                    // InternalDataDescriptionLanguage.g:1408:4: 'a'
                    {
                    match(input,49,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getAttoEnumLiteralDeclaration_17()); 
                    }

                    }


                    }
                    break;
                case 19 :
                    // InternalDataDescriptionLanguage.g:1412:2: ( ( 'z' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1412:2: ( ( 'z' ) )
                    // InternalDataDescriptionLanguage.g:1413:3: ( 'z' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getZeptoEnumLiteralDeclaration_18()); 
                    }
                    // InternalDataDescriptionLanguage.g:1414:3: ( 'z' )
                    // InternalDataDescriptionLanguage.g:1414:4: 'z'
                    {
                    match(input,50,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getZeptoEnumLiteralDeclaration_18()); 
                    }

                    }


                    }
                    break;
                case 20 :
                    // InternalDataDescriptionLanguage.g:1418:2: ( ( 'y' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1418:2: ( ( 'y' ) )
                    // InternalDataDescriptionLanguage.g:1419:3: ( 'y' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getYoctoEnumLiteralDeclaration_19()); 
                    }
                    // InternalDataDescriptionLanguage.g:1420:3: ( 'y' )
                    // InternalDataDescriptionLanguage.g:1420:4: 'y'
                    {
                    match(input,51,FOLLOW_2); if (state.failed) return ;

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
    // InternalDataDescriptionLanguage.g:1428:1: rule__DataDescriptionModelRule__Group__0 : rule__DataDescriptionModelRule__Group__0__Impl rule__DataDescriptionModelRule__Group__1 ;
    public final void rule__DataDescriptionModelRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1432:1: ( rule__DataDescriptionModelRule__Group__0__Impl rule__DataDescriptionModelRule__Group__1 )
            // InternalDataDescriptionLanguage.g:1433:2: rule__DataDescriptionModelRule__Group__0__Impl rule__DataDescriptionModelRule__Group__1
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
    // InternalDataDescriptionLanguage.g:1440:1: rule__DataDescriptionModelRule__Group__0__Impl : ( () ) ;
    public final void rule__DataDescriptionModelRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1444:1: ( ( () ) )
            // InternalDataDescriptionLanguage.g:1445:1: ( () )
            {
            // InternalDataDescriptionLanguage.g:1445:1: ( () )
            // InternalDataDescriptionLanguage.g:1446:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getDataDescriptionModelAction_0()); 
            }
            // InternalDataDescriptionLanguage.g:1447:2: ()
            // InternalDataDescriptionLanguage.g:1447:3: 
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
    // InternalDataDescriptionLanguage.g:1455:1: rule__DataDescriptionModelRule__Group__1 : rule__DataDescriptionModelRule__Group__1__Impl rule__DataDescriptionModelRule__Group__2 ;
    public final void rule__DataDescriptionModelRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1459:1: ( rule__DataDescriptionModelRule__Group__1__Impl rule__DataDescriptionModelRule__Group__2 )
            // InternalDataDescriptionLanguage.g:1460:2: rule__DataDescriptionModelRule__Group__1__Impl rule__DataDescriptionModelRule__Group__2
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
    // InternalDataDescriptionLanguage.g:1467:1: rule__DataDescriptionModelRule__Group__1__Impl : ( ( rule__DataDescriptionModelRule__UsesAssignment_1 )* ) ;
    public final void rule__DataDescriptionModelRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1471:1: ( ( ( rule__DataDescriptionModelRule__UsesAssignment_1 )* ) )
            // InternalDataDescriptionLanguage.g:1472:1: ( ( rule__DataDescriptionModelRule__UsesAssignment_1 )* )
            {
            // InternalDataDescriptionLanguage.g:1472:1: ( ( rule__DataDescriptionModelRule__UsesAssignment_1 )* )
            // InternalDataDescriptionLanguage.g:1473:2: ( rule__DataDescriptionModelRule__UsesAssignment_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getUsesAssignment_1()); 
            }
            // InternalDataDescriptionLanguage.g:1474:2: ( rule__DataDescriptionModelRule__UsesAssignment_1 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==56) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:1474:3: rule__DataDescriptionModelRule__UsesAssignment_1
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
    // InternalDataDescriptionLanguage.g:1482:1: rule__DataDescriptionModelRule__Group__2 : rule__DataDescriptionModelRule__Group__2__Impl rule__DataDescriptionModelRule__Group__3 ;
    public final void rule__DataDescriptionModelRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1486:1: ( rule__DataDescriptionModelRule__Group__2__Impl rule__DataDescriptionModelRule__Group__3 )
            // InternalDataDescriptionLanguage.g:1487:2: rule__DataDescriptionModelRule__Group__2__Impl rule__DataDescriptionModelRule__Group__3
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
    // InternalDataDescriptionLanguage.g:1494:1: rule__DataDescriptionModelRule__Group__2__Impl : ( ( rule__DataDescriptionModelRule__Group_2__0 )? ) ;
    public final void rule__DataDescriptionModelRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1498:1: ( ( ( rule__DataDescriptionModelRule__Group_2__0 )? ) )
            // InternalDataDescriptionLanguage.g:1499:1: ( ( rule__DataDescriptionModelRule__Group_2__0 )? )
            {
            // InternalDataDescriptionLanguage.g:1499:1: ( ( rule__DataDescriptionModelRule__Group_2__0 )? )
            // InternalDataDescriptionLanguage.g:1500:2: ( rule__DataDescriptionModelRule__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getGroup_2()); 
            }
            // InternalDataDescriptionLanguage.g:1501:2: ( rule__DataDescriptionModelRule__Group_2__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==52) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:1501:3: rule__DataDescriptionModelRule__Group_2__0
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
    // InternalDataDescriptionLanguage.g:1509:1: rule__DataDescriptionModelRule__Group__3 : rule__DataDescriptionModelRule__Group__3__Impl rule__DataDescriptionModelRule__Group__4 ;
    public final void rule__DataDescriptionModelRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1513:1: ( rule__DataDescriptionModelRule__Group__3__Impl rule__DataDescriptionModelRule__Group__4 )
            // InternalDataDescriptionLanguage.g:1514:2: rule__DataDescriptionModelRule__Group__3__Impl rule__DataDescriptionModelRule__Group__4
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
    // InternalDataDescriptionLanguage.g:1521:1: rule__DataDescriptionModelRule__Group__3__Impl : ( ( rule__DataDescriptionModelRule__Group_3__0 )? ) ;
    public final void rule__DataDescriptionModelRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1525:1: ( ( ( rule__DataDescriptionModelRule__Group_3__0 )? ) )
            // InternalDataDescriptionLanguage.g:1526:1: ( ( rule__DataDescriptionModelRule__Group_3__0 )? )
            {
            // InternalDataDescriptionLanguage.g:1526:1: ( ( rule__DataDescriptionModelRule__Group_3__0 )? )
            // InternalDataDescriptionLanguage.g:1527:2: ( rule__DataDescriptionModelRule__Group_3__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getGroup_3()); 
            }
            // InternalDataDescriptionLanguage.g:1528:2: ( rule__DataDescriptionModelRule__Group_3__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==54) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:1528:3: rule__DataDescriptionModelRule__Group_3__0
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
    // InternalDataDescriptionLanguage.g:1536:1: rule__DataDescriptionModelRule__Group__4 : rule__DataDescriptionModelRule__Group__4__Impl ;
    public final void rule__DataDescriptionModelRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1540:1: ( rule__DataDescriptionModelRule__Group__4__Impl )
            // InternalDataDescriptionLanguage.g:1541:2: rule__DataDescriptionModelRule__Group__4__Impl
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
    // InternalDataDescriptionLanguage.g:1547:1: rule__DataDescriptionModelRule__Group__4__Impl : ( ( rule__DataDescriptionModelRule__Group_4__0 )? ) ;
    public final void rule__DataDescriptionModelRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1551:1: ( ( ( rule__DataDescriptionModelRule__Group_4__0 )? ) )
            // InternalDataDescriptionLanguage.g:1552:1: ( ( rule__DataDescriptionModelRule__Group_4__0 )? )
            {
            // InternalDataDescriptionLanguage.g:1552:1: ( ( rule__DataDescriptionModelRule__Group_4__0 )? )
            // InternalDataDescriptionLanguage.g:1553:2: ( rule__DataDescriptionModelRule__Group_4__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getGroup_4()); 
            }
            // InternalDataDescriptionLanguage.g:1554:2: ( rule__DataDescriptionModelRule__Group_4__0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==55) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:1554:3: rule__DataDescriptionModelRule__Group_4__0
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
    // InternalDataDescriptionLanguage.g:1563:1: rule__DataDescriptionModelRule__Group_2__0 : rule__DataDescriptionModelRule__Group_2__0__Impl rule__DataDescriptionModelRule__Group_2__1 ;
    public final void rule__DataDescriptionModelRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1567:1: ( rule__DataDescriptionModelRule__Group_2__0__Impl rule__DataDescriptionModelRule__Group_2__1 )
            // InternalDataDescriptionLanguage.g:1568:2: rule__DataDescriptionModelRule__Group_2__0__Impl rule__DataDescriptionModelRule__Group_2__1
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
    // InternalDataDescriptionLanguage.g:1575:1: rule__DataDescriptionModelRule__Group_2__0__Impl : ( 'types' ) ;
    public final void rule__DataDescriptionModelRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1579:1: ( ( 'types' ) )
            // InternalDataDescriptionLanguage.g:1580:1: ( 'types' )
            {
            // InternalDataDescriptionLanguage.g:1580:1: ( 'types' )
            // InternalDataDescriptionLanguage.g:1581:2: 'types'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getTypesKeyword_2_0()); 
            }
            match(input,52,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:1590:1: rule__DataDescriptionModelRule__Group_2__1 : rule__DataDescriptionModelRule__Group_2__1__Impl rule__DataDescriptionModelRule__Group_2__2 ;
    public final void rule__DataDescriptionModelRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1594:1: ( rule__DataDescriptionModelRule__Group_2__1__Impl rule__DataDescriptionModelRule__Group_2__2 )
            // InternalDataDescriptionLanguage.g:1595:2: rule__DataDescriptionModelRule__Group_2__1__Impl rule__DataDescriptionModelRule__Group_2__2
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
    // InternalDataDescriptionLanguage.g:1602:1: rule__DataDescriptionModelRule__Group_2__1__Impl : ( ':' ) ;
    public final void rule__DataDescriptionModelRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1606:1: ( ( ':' ) )
            // InternalDataDescriptionLanguage.g:1607:1: ( ':' )
            {
            // InternalDataDescriptionLanguage.g:1607:1: ( ':' )
            // InternalDataDescriptionLanguage.g:1608:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getColonKeyword_2_1()); 
            }
            match(input,53,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:1617:1: rule__DataDescriptionModelRule__Group_2__2 : rule__DataDescriptionModelRule__Group_2__2__Impl ;
    public final void rule__DataDescriptionModelRule__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1621:1: ( rule__DataDescriptionModelRule__Group_2__2__Impl )
            // InternalDataDescriptionLanguage.g:1622:2: rule__DataDescriptionModelRule__Group_2__2__Impl
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
    // InternalDataDescriptionLanguage.g:1628:1: rule__DataDescriptionModelRule__Group_2__2__Impl : ( ( rule__DataDescriptionModelRule__TypesAssignment_2_2 )* ) ;
    public final void rule__DataDescriptionModelRule__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1632:1: ( ( ( rule__DataDescriptionModelRule__TypesAssignment_2_2 )* ) )
            // InternalDataDescriptionLanguage.g:1633:1: ( ( rule__DataDescriptionModelRule__TypesAssignment_2_2 )* )
            {
            // InternalDataDescriptionLanguage.g:1633:1: ( ( rule__DataDescriptionModelRule__TypesAssignment_2_2 )* )
            // InternalDataDescriptionLanguage.g:1634:2: ( rule__DataDescriptionModelRule__TypesAssignment_2_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getTypesAssignment_2_2()); 
            }
            // InternalDataDescriptionLanguage.g:1635:2: ( rule__DataDescriptionModelRule__TypesAssignment_2_2 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>=13 && LA18_0<=16)) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:1635:3: rule__DataDescriptionModelRule__TypesAssignment_2_2
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
    // InternalDataDescriptionLanguage.g:1644:1: rule__DataDescriptionModelRule__Group_3__0 : rule__DataDescriptionModelRule__Group_3__0__Impl rule__DataDescriptionModelRule__Group_3__1 ;
    public final void rule__DataDescriptionModelRule__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1648:1: ( rule__DataDescriptionModelRule__Group_3__0__Impl rule__DataDescriptionModelRule__Group_3__1 )
            // InternalDataDescriptionLanguage.g:1649:2: rule__DataDescriptionModelRule__Group_3__0__Impl rule__DataDescriptionModelRule__Group_3__1
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
    // InternalDataDescriptionLanguage.g:1656:1: rule__DataDescriptionModelRule__Group_3__0__Impl : ( 'data' ) ;
    public final void rule__DataDescriptionModelRule__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1660:1: ( ( 'data' ) )
            // InternalDataDescriptionLanguage.g:1661:1: ( 'data' )
            {
            // InternalDataDescriptionLanguage.g:1661:1: ( 'data' )
            // InternalDataDescriptionLanguage.g:1662:2: 'data'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getDataKeyword_3_0()); 
            }
            match(input,54,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:1671:1: rule__DataDescriptionModelRule__Group_3__1 : rule__DataDescriptionModelRule__Group_3__1__Impl rule__DataDescriptionModelRule__Group_3__2 ;
    public final void rule__DataDescriptionModelRule__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1675:1: ( rule__DataDescriptionModelRule__Group_3__1__Impl rule__DataDescriptionModelRule__Group_3__2 )
            // InternalDataDescriptionLanguage.g:1676:2: rule__DataDescriptionModelRule__Group_3__1__Impl rule__DataDescriptionModelRule__Group_3__2
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
    // InternalDataDescriptionLanguage.g:1683:1: rule__DataDescriptionModelRule__Group_3__1__Impl : ( ':' ) ;
    public final void rule__DataDescriptionModelRule__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1687:1: ( ( ':' ) )
            // InternalDataDescriptionLanguage.g:1688:1: ( ':' )
            {
            // InternalDataDescriptionLanguage.g:1688:1: ( ':' )
            // InternalDataDescriptionLanguage.g:1689:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getColonKeyword_3_1()); 
            }
            match(input,53,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:1698:1: rule__DataDescriptionModelRule__Group_3__2 : rule__DataDescriptionModelRule__Group_3__2__Impl ;
    public final void rule__DataDescriptionModelRule__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1702:1: ( rule__DataDescriptionModelRule__Group_3__2__Impl )
            // InternalDataDescriptionLanguage.g:1703:2: rule__DataDescriptionModelRule__Group_3__2__Impl
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
    // InternalDataDescriptionLanguage.g:1709:1: rule__DataDescriptionModelRule__Group_3__2__Impl : ( ( rule__DataDescriptionModelRule__DescriptionsAssignment_3_2 )* ) ;
    public final void rule__DataDescriptionModelRule__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1713:1: ( ( ( rule__DataDescriptionModelRule__DescriptionsAssignment_3_2 )* ) )
            // InternalDataDescriptionLanguage.g:1714:1: ( ( rule__DataDescriptionModelRule__DescriptionsAssignment_3_2 )* )
            {
            // InternalDataDescriptionLanguage.g:1714:1: ( ( rule__DataDescriptionModelRule__DescriptionsAssignment_3_2 )* )
            // InternalDataDescriptionLanguage.g:1715:2: ( rule__DataDescriptionModelRule__DescriptionsAssignment_3_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getDescriptionsAssignment_3_2()); 
            }
            // InternalDataDescriptionLanguage.g:1716:2: ( rule__DataDescriptionModelRule__DescriptionsAssignment_3_2 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>=13 && LA19_0<=20)) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:1716:3: rule__DataDescriptionModelRule__DescriptionsAssignment_3_2
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
    // InternalDataDescriptionLanguage.g:1725:1: rule__DataDescriptionModelRule__Group_4__0 : rule__DataDescriptionModelRule__Group_4__0__Impl rule__DataDescriptionModelRule__Group_4__1 ;
    public final void rule__DataDescriptionModelRule__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1729:1: ( rule__DataDescriptionModelRule__Group_4__0__Impl rule__DataDescriptionModelRule__Group_4__1 )
            // InternalDataDescriptionLanguage.g:1730:2: rule__DataDescriptionModelRule__Group_4__0__Impl rule__DataDescriptionModelRule__Group_4__1
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
    // InternalDataDescriptionLanguage.g:1737:1: rule__DataDescriptionModelRule__Group_4__0__Impl : ( 'constraints' ) ;
    public final void rule__DataDescriptionModelRule__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1741:1: ( ( 'constraints' ) )
            // InternalDataDescriptionLanguage.g:1742:1: ( 'constraints' )
            {
            // InternalDataDescriptionLanguage.g:1742:1: ( 'constraints' )
            // InternalDataDescriptionLanguage.g:1743:2: 'constraints'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getConstraintsKeyword_4_0()); 
            }
            match(input,55,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:1752:1: rule__DataDescriptionModelRule__Group_4__1 : rule__DataDescriptionModelRule__Group_4__1__Impl rule__DataDescriptionModelRule__Group_4__2 ;
    public final void rule__DataDescriptionModelRule__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1756:1: ( rule__DataDescriptionModelRule__Group_4__1__Impl rule__DataDescriptionModelRule__Group_4__2 )
            // InternalDataDescriptionLanguage.g:1757:2: rule__DataDescriptionModelRule__Group_4__1__Impl rule__DataDescriptionModelRule__Group_4__2
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
    // InternalDataDescriptionLanguage.g:1764:1: rule__DataDescriptionModelRule__Group_4__1__Impl : ( ':' ) ;
    public final void rule__DataDescriptionModelRule__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1768:1: ( ( ':' ) )
            // InternalDataDescriptionLanguage.g:1769:1: ( ':' )
            {
            // InternalDataDescriptionLanguage.g:1769:1: ( ':' )
            // InternalDataDescriptionLanguage.g:1770:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getColonKeyword_4_1()); 
            }
            match(input,53,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:1779:1: rule__DataDescriptionModelRule__Group_4__2 : rule__DataDescriptionModelRule__Group_4__2__Impl ;
    public final void rule__DataDescriptionModelRule__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1783:1: ( rule__DataDescriptionModelRule__Group_4__2__Impl )
            // InternalDataDescriptionLanguage.g:1784:2: rule__DataDescriptionModelRule__Group_4__2__Impl
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
    // InternalDataDescriptionLanguage.g:1790:1: rule__DataDescriptionModelRule__Group_4__2__Impl : ( ( rule__DataDescriptionModelRule__ConstraintsAssignment_4_2 )* ) ;
    public final void rule__DataDescriptionModelRule__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1794:1: ( ( ( rule__DataDescriptionModelRule__ConstraintsAssignment_4_2 )* ) )
            // InternalDataDescriptionLanguage.g:1795:1: ( ( rule__DataDescriptionModelRule__ConstraintsAssignment_4_2 )* )
            {
            // InternalDataDescriptionLanguage.g:1795:1: ( ( rule__DataDescriptionModelRule__ConstraintsAssignment_4_2 )* )
            // InternalDataDescriptionLanguage.g:1796:2: ( rule__DataDescriptionModelRule__ConstraintsAssignment_4_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getConstraintsAssignment_4_2()); 
            }
            // InternalDataDescriptionLanguage.g:1797:2: ( rule__DataDescriptionModelRule__ConstraintsAssignment_4_2 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>=RULE_QUOTED_ID && LA20_0<=RULE_STRING)||LA20_0==12||(LA20_0>=27 && LA20_0<=28)||LA20_0==62||LA20_0==67||(LA20_0>=71 && LA20_0<=72)) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:1797:3: rule__DataDescriptionModelRule__ConstraintsAssignment_4_2
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
    // InternalDataDescriptionLanguage.g:1806:1: rule__UseRule__Group__0 : rule__UseRule__Group__0__Impl rule__UseRule__Group__1 ;
    public final void rule__UseRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1810:1: ( rule__UseRule__Group__0__Impl rule__UseRule__Group__1 )
            // InternalDataDescriptionLanguage.g:1811:2: rule__UseRule__Group__0__Impl rule__UseRule__Group__1
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
    // InternalDataDescriptionLanguage.g:1818:1: rule__UseRule__Group__0__Impl : ( 'use' ) ;
    public final void rule__UseRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1822:1: ( ( 'use' ) )
            // InternalDataDescriptionLanguage.g:1823:1: ( 'use' )
            {
            // InternalDataDescriptionLanguage.g:1823:1: ( 'use' )
            // InternalDataDescriptionLanguage.g:1824:2: 'use'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUseRuleAccess().getUseKeyword_0()); 
            }
            match(input,56,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:1833:1: rule__UseRule__Group__1 : rule__UseRule__Group__1__Impl rule__UseRule__Group__2 ;
    public final void rule__UseRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1837:1: ( rule__UseRule__Group__1__Impl rule__UseRule__Group__2 )
            // InternalDataDescriptionLanguage.g:1838:2: rule__UseRule__Group__1__Impl rule__UseRule__Group__2
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
    // InternalDataDescriptionLanguage.g:1845:1: rule__UseRule__Group__1__Impl : ( ( rule__UseRule__ImportURIAssignment_1 ) ) ;
    public final void rule__UseRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1849:1: ( ( ( rule__UseRule__ImportURIAssignment_1 ) ) )
            // InternalDataDescriptionLanguage.g:1850:1: ( ( rule__UseRule__ImportURIAssignment_1 ) )
            {
            // InternalDataDescriptionLanguage.g:1850:1: ( ( rule__UseRule__ImportURIAssignment_1 ) )
            // InternalDataDescriptionLanguage.g:1851:2: ( rule__UseRule__ImportURIAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUseRuleAccess().getImportURIAssignment_1()); 
            }
            // InternalDataDescriptionLanguage.g:1852:2: ( rule__UseRule__ImportURIAssignment_1 )
            // InternalDataDescriptionLanguage.g:1852:3: rule__UseRule__ImportURIAssignment_1
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
    // InternalDataDescriptionLanguage.g:1860:1: rule__UseRule__Group__2 : rule__UseRule__Group__2__Impl ;
    public final void rule__UseRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1864:1: ( rule__UseRule__Group__2__Impl )
            // InternalDataDescriptionLanguage.g:1865:2: rule__UseRule__Group__2__Impl
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
    // InternalDataDescriptionLanguage.g:1871:1: rule__UseRule__Group__2__Impl : ( ';' ) ;
    public final void rule__UseRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1875:1: ( ( ';' ) )
            // InternalDataDescriptionLanguage.g:1876:1: ( ';' )
            {
            // InternalDataDescriptionLanguage.g:1876:1: ( ';' )
            // InternalDataDescriptionLanguage.g:1877:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUseRuleAccess().getSemicolonKeyword_2()); 
            }
            match(input,57,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:1887:1: rule__DataTypeRule__Group__0 : rule__DataTypeRule__Group__0__Impl rule__DataTypeRule__Group__1 ;
    public final void rule__DataTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1891:1: ( rule__DataTypeRule__Group__0__Impl rule__DataTypeRule__Group__1 )
            // InternalDataDescriptionLanguage.g:1892:2: rule__DataTypeRule__Group__0__Impl rule__DataTypeRule__Group__1
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
    // InternalDataDescriptionLanguage.g:1899:1: rule__DataTypeRule__Group__0__Impl : ( ( rule__DataTypeRule__ScaleAssignment_0 ) ) ;
    public final void rule__DataTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1903:1: ( ( ( rule__DataTypeRule__ScaleAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:1904:1: ( ( rule__DataTypeRule__ScaleAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:1904:1: ( ( rule__DataTypeRule__ScaleAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:1905:2: ( rule__DataTypeRule__ScaleAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getScaleAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:1906:2: ( rule__DataTypeRule__ScaleAssignment_0 )
            // InternalDataDescriptionLanguage.g:1906:3: rule__DataTypeRule__ScaleAssignment_0
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
    // InternalDataDescriptionLanguage.g:1914:1: rule__DataTypeRule__Group__1 : rule__DataTypeRule__Group__1__Impl rule__DataTypeRule__Group__2 ;
    public final void rule__DataTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1918:1: ( rule__DataTypeRule__Group__1__Impl rule__DataTypeRule__Group__2 )
            // InternalDataDescriptionLanguage.g:1919:2: rule__DataTypeRule__Group__1__Impl rule__DataTypeRule__Group__2
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
    // InternalDataDescriptionLanguage.g:1926:1: rule__DataTypeRule__Group__1__Impl : ( 'type' ) ;
    public final void rule__DataTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1930:1: ( ( 'type' ) )
            // InternalDataDescriptionLanguage.g:1931:1: ( 'type' )
            {
            // InternalDataDescriptionLanguage.g:1931:1: ( 'type' )
            // InternalDataDescriptionLanguage.g:1932:2: 'type'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getTypeKeyword_1()); 
            }
            match(input,58,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:1941:1: rule__DataTypeRule__Group__2 : rule__DataTypeRule__Group__2__Impl rule__DataTypeRule__Group__3 ;
    public final void rule__DataTypeRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1945:1: ( rule__DataTypeRule__Group__2__Impl rule__DataTypeRule__Group__3 )
            // InternalDataDescriptionLanguage.g:1946:2: rule__DataTypeRule__Group__2__Impl rule__DataTypeRule__Group__3
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
    // InternalDataDescriptionLanguage.g:1953:1: rule__DataTypeRule__Group__2__Impl : ( ( rule__DataTypeRule__NameAssignment_2 ) ) ;
    public final void rule__DataTypeRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1957:1: ( ( ( rule__DataTypeRule__NameAssignment_2 ) ) )
            // InternalDataDescriptionLanguage.g:1958:1: ( ( rule__DataTypeRule__NameAssignment_2 ) )
            {
            // InternalDataDescriptionLanguage.g:1958:1: ( ( rule__DataTypeRule__NameAssignment_2 ) )
            // InternalDataDescriptionLanguage.g:1959:2: ( rule__DataTypeRule__NameAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getNameAssignment_2()); 
            }
            // InternalDataDescriptionLanguage.g:1960:2: ( rule__DataTypeRule__NameAssignment_2 )
            // InternalDataDescriptionLanguage.g:1960:3: rule__DataTypeRule__NameAssignment_2
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
    // InternalDataDescriptionLanguage.g:1968:1: rule__DataTypeRule__Group__3 : rule__DataTypeRule__Group__3__Impl rule__DataTypeRule__Group__4 ;
    public final void rule__DataTypeRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1972:1: ( rule__DataTypeRule__Group__3__Impl rule__DataTypeRule__Group__4 )
            // InternalDataDescriptionLanguage.g:1973:2: rule__DataTypeRule__Group__3__Impl rule__DataTypeRule__Group__4
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
    // InternalDataDescriptionLanguage.g:1980:1: rule__DataTypeRule__Group__3__Impl : ( ( rule__DataTypeRule__Group_3__0 )? ) ;
    public final void rule__DataTypeRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1984:1: ( ( ( rule__DataTypeRule__Group_3__0 )? ) )
            // InternalDataDescriptionLanguage.g:1985:1: ( ( rule__DataTypeRule__Group_3__0 )? )
            {
            // InternalDataDescriptionLanguage.g:1985:1: ( ( rule__DataTypeRule__Group_3__0 )? )
            // InternalDataDescriptionLanguage.g:1986:2: ( rule__DataTypeRule__Group_3__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getGroup_3()); 
            }
            // InternalDataDescriptionLanguage.g:1987:2: ( rule__DataTypeRule__Group_3__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==59) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:1987:3: rule__DataTypeRule__Group_3__0
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
    // InternalDataDescriptionLanguage.g:1995:1: rule__DataTypeRule__Group__4 : rule__DataTypeRule__Group__4__Impl rule__DataTypeRule__Group__5 ;
    public final void rule__DataTypeRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1999:1: ( rule__DataTypeRule__Group__4__Impl rule__DataTypeRule__Group__5 )
            // InternalDataDescriptionLanguage.g:2000:2: rule__DataTypeRule__Group__4__Impl rule__DataTypeRule__Group__5
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
    // InternalDataDescriptionLanguage.g:2007:1: rule__DataTypeRule__Group__4__Impl : ( ( rule__DataTypeRule__Group_4__0 )? ) ;
    public final void rule__DataTypeRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2011:1: ( ( ( rule__DataTypeRule__Group_4__0 )? ) )
            // InternalDataDescriptionLanguage.g:2012:1: ( ( rule__DataTypeRule__Group_4__0 )? )
            {
            // InternalDataDescriptionLanguage.g:2012:1: ( ( rule__DataTypeRule__Group_4__0 )? )
            // InternalDataDescriptionLanguage.g:2013:2: ( rule__DataTypeRule__Group_4__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getGroup_4()); 
            }
            // InternalDataDescriptionLanguage.g:2014:2: ( rule__DataTypeRule__Group_4__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==60) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:2014:3: rule__DataTypeRule__Group_4__0
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
    // InternalDataDescriptionLanguage.g:2022:1: rule__DataTypeRule__Group__5 : rule__DataTypeRule__Group__5__Impl ;
    public final void rule__DataTypeRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2026:1: ( rule__DataTypeRule__Group__5__Impl )
            // InternalDataDescriptionLanguage.g:2027:2: rule__DataTypeRule__Group__5__Impl
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
    // InternalDataDescriptionLanguage.g:2033:1: rule__DataTypeRule__Group__5__Impl : ( ';' ) ;
    public final void rule__DataTypeRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2037:1: ( ( ';' ) )
            // InternalDataDescriptionLanguage.g:2038:1: ( ';' )
            {
            // InternalDataDescriptionLanguage.g:2038:1: ( ';' )
            // InternalDataDescriptionLanguage.g:2039:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getSemicolonKeyword_5()); 
            }
            match(input,57,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:2049:1: rule__DataTypeRule__Group_3__0 : rule__DataTypeRule__Group_3__0__Impl rule__DataTypeRule__Group_3__1 ;
    public final void rule__DataTypeRule__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2053:1: ( rule__DataTypeRule__Group_3__0__Impl rule__DataTypeRule__Group_3__1 )
            // InternalDataDescriptionLanguage.g:2054:2: rule__DataTypeRule__Group_3__0__Impl rule__DataTypeRule__Group_3__1
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
    // InternalDataDescriptionLanguage.g:2061:1: rule__DataTypeRule__Group_3__0__Impl : ( 'description' ) ;
    public final void rule__DataTypeRule__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2065:1: ( ( 'description' ) )
            // InternalDataDescriptionLanguage.g:2066:1: ( 'description' )
            {
            // InternalDataDescriptionLanguage.g:2066:1: ( 'description' )
            // InternalDataDescriptionLanguage.g:2067:2: 'description'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getDescriptionKeyword_3_0()); 
            }
            match(input,59,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:2076:1: rule__DataTypeRule__Group_3__1 : rule__DataTypeRule__Group_3__1__Impl rule__DataTypeRule__Group_3__2 ;
    public final void rule__DataTypeRule__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2080:1: ( rule__DataTypeRule__Group_3__1__Impl rule__DataTypeRule__Group_3__2 )
            // InternalDataDescriptionLanguage.g:2081:2: rule__DataTypeRule__Group_3__1__Impl rule__DataTypeRule__Group_3__2
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
    // InternalDataDescriptionLanguage.g:2088:1: rule__DataTypeRule__Group_3__1__Impl : ( ':' ) ;
    public final void rule__DataTypeRule__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2092:1: ( ( ':' ) )
            // InternalDataDescriptionLanguage.g:2093:1: ( ':' )
            {
            // InternalDataDescriptionLanguage.g:2093:1: ( ':' )
            // InternalDataDescriptionLanguage.g:2094:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getColonKeyword_3_1()); 
            }
            match(input,53,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:2103:1: rule__DataTypeRule__Group_3__2 : rule__DataTypeRule__Group_3__2__Impl ;
    public final void rule__DataTypeRule__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2107:1: ( rule__DataTypeRule__Group_3__2__Impl )
            // InternalDataDescriptionLanguage.g:2108:2: rule__DataTypeRule__Group_3__2__Impl
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
    // InternalDataDescriptionLanguage.g:2114:1: rule__DataTypeRule__Group_3__2__Impl : ( ( rule__DataTypeRule__DescriptionAssignment_3_2 ) ) ;
    public final void rule__DataTypeRule__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2118:1: ( ( ( rule__DataTypeRule__DescriptionAssignment_3_2 ) ) )
            // InternalDataDescriptionLanguage.g:2119:1: ( ( rule__DataTypeRule__DescriptionAssignment_3_2 ) )
            {
            // InternalDataDescriptionLanguage.g:2119:1: ( ( rule__DataTypeRule__DescriptionAssignment_3_2 ) )
            // InternalDataDescriptionLanguage.g:2120:2: ( rule__DataTypeRule__DescriptionAssignment_3_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getDescriptionAssignment_3_2()); 
            }
            // InternalDataDescriptionLanguage.g:2121:2: ( rule__DataTypeRule__DescriptionAssignment_3_2 )
            // InternalDataDescriptionLanguage.g:2121:3: rule__DataTypeRule__DescriptionAssignment_3_2
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
    // InternalDataDescriptionLanguage.g:2130:1: rule__DataTypeRule__Group_4__0 : rule__DataTypeRule__Group_4__0__Impl rule__DataTypeRule__Group_4__1 ;
    public final void rule__DataTypeRule__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2134:1: ( rule__DataTypeRule__Group_4__0__Impl rule__DataTypeRule__Group_4__1 )
            // InternalDataDescriptionLanguage.g:2135:2: rule__DataTypeRule__Group_4__0__Impl rule__DataTypeRule__Group_4__1
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
    // InternalDataDescriptionLanguage.g:2142:1: rule__DataTypeRule__Group_4__0__Impl : ( 'with' ) ;
    public final void rule__DataTypeRule__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2146:1: ( ( 'with' ) )
            // InternalDataDescriptionLanguage.g:2147:1: ( 'with' )
            {
            // InternalDataDescriptionLanguage.g:2147:1: ( 'with' )
            // InternalDataDescriptionLanguage.g:2148:2: 'with'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getWithKeyword_4_0()); 
            }
            match(input,60,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:2157:1: rule__DataTypeRule__Group_4__1 : rule__DataTypeRule__Group_4__1__Impl rule__DataTypeRule__Group_4__2 ;
    public final void rule__DataTypeRule__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2161:1: ( rule__DataTypeRule__Group_4__1__Impl rule__DataTypeRule__Group_4__2 )
            // InternalDataDescriptionLanguage.g:2162:2: rule__DataTypeRule__Group_4__1__Impl rule__DataTypeRule__Group_4__2
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
    // InternalDataDescriptionLanguage.g:2169:1: rule__DataTypeRule__Group_4__1__Impl : ( 'constraints' ) ;
    public final void rule__DataTypeRule__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2173:1: ( ( 'constraints' ) )
            // InternalDataDescriptionLanguage.g:2174:1: ( 'constraints' )
            {
            // InternalDataDescriptionLanguage.g:2174:1: ( 'constraints' )
            // InternalDataDescriptionLanguage.g:2175:2: 'constraints'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getConstraintsKeyword_4_1()); 
            }
            match(input,55,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:2184:1: rule__DataTypeRule__Group_4__2 : rule__DataTypeRule__Group_4__2__Impl rule__DataTypeRule__Group_4__3 ;
    public final void rule__DataTypeRule__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2188:1: ( rule__DataTypeRule__Group_4__2__Impl rule__DataTypeRule__Group_4__3 )
            // InternalDataDescriptionLanguage.g:2189:2: rule__DataTypeRule__Group_4__2__Impl rule__DataTypeRule__Group_4__3
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
    // InternalDataDescriptionLanguage.g:2196:1: rule__DataTypeRule__Group_4__2__Impl : ( ':' ) ;
    public final void rule__DataTypeRule__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2200:1: ( ( ':' ) )
            // InternalDataDescriptionLanguage.g:2201:1: ( ':' )
            {
            // InternalDataDescriptionLanguage.g:2201:1: ( ':' )
            // InternalDataDescriptionLanguage.g:2202:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getColonKeyword_4_2()); 
            }
            match(input,53,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:2211:1: rule__DataTypeRule__Group_4__3 : rule__DataTypeRule__Group_4__3__Impl ;
    public final void rule__DataTypeRule__Group_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2215:1: ( rule__DataTypeRule__Group_4__3__Impl )
            // InternalDataDescriptionLanguage.g:2216:2: rule__DataTypeRule__Group_4__3__Impl
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
    // InternalDataDescriptionLanguage.g:2222:1: rule__DataTypeRule__Group_4__3__Impl : ( ( rule__DataTypeRule__ConstraintsAssignment_4_3 )* ) ;
    public final void rule__DataTypeRule__Group_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2226:1: ( ( ( rule__DataTypeRule__ConstraintsAssignment_4_3 )* ) )
            // InternalDataDescriptionLanguage.g:2227:1: ( ( rule__DataTypeRule__ConstraintsAssignment_4_3 )* )
            {
            // InternalDataDescriptionLanguage.g:2227:1: ( ( rule__DataTypeRule__ConstraintsAssignment_4_3 )* )
            // InternalDataDescriptionLanguage.g:2228:2: ( rule__DataTypeRule__ConstraintsAssignment_4_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getConstraintsAssignment_4_3()); 
            }
            // InternalDataDescriptionLanguage.g:2229:2: ( rule__DataTypeRule__ConstraintsAssignment_4_3 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0>=RULE_QUOTED_ID && LA23_0<=RULE_STRING)||LA23_0==12||(LA23_0>=27 && LA23_0<=28)||LA23_0==62||LA23_0==67||(LA23_0>=71 && LA23_0<=72)) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:2229:3: rule__DataTypeRule__ConstraintsAssignment_4_3
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
    // InternalDataDescriptionLanguage.g:2238:1: rule__TypedDataDescriptionRule__Group__0 : rule__TypedDataDescriptionRule__Group__0__Impl rule__TypedDataDescriptionRule__Group__1 ;
    public final void rule__TypedDataDescriptionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2242:1: ( rule__TypedDataDescriptionRule__Group__0__Impl rule__TypedDataDescriptionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:2243:2: rule__TypedDataDescriptionRule__Group__0__Impl rule__TypedDataDescriptionRule__Group__1
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
    // InternalDataDescriptionLanguage.g:2250:1: rule__TypedDataDescriptionRule__Group__0__Impl : ( ( rule__TypedDataDescriptionRule__RepresentationAssignment_0 ) ) ;
    public final void rule__TypedDataDescriptionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2254:1: ( ( ( rule__TypedDataDescriptionRule__RepresentationAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:2255:1: ( ( rule__TypedDataDescriptionRule__RepresentationAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:2255:1: ( ( rule__TypedDataDescriptionRule__RepresentationAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:2256:2: ( rule__TypedDataDescriptionRule__RepresentationAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedDataDescriptionRuleAccess().getRepresentationAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:2257:2: ( rule__TypedDataDescriptionRule__RepresentationAssignment_0 )
            // InternalDataDescriptionLanguage.g:2257:3: rule__TypedDataDescriptionRule__RepresentationAssignment_0
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
    // InternalDataDescriptionLanguage.g:2265:1: rule__TypedDataDescriptionRule__Group__1 : rule__TypedDataDescriptionRule__Group__1__Impl rule__TypedDataDescriptionRule__Group__2 ;
    public final void rule__TypedDataDescriptionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2269:1: ( rule__TypedDataDescriptionRule__Group__1__Impl rule__TypedDataDescriptionRule__Group__2 )
            // InternalDataDescriptionLanguage.g:2270:2: rule__TypedDataDescriptionRule__Group__1__Impl rule__TypedDataDescriptionRule__Group__2
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
    // InternalDataDescriptionLanguage.g:2277:1: rule__TypedDataDescriptionRule__Group__1__Impl : ( 'data' ) ;
    public final void rule__TypedDataDescriptionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2281:1: ( ( 'data' ) )
            // InternalDataDescriptionLanguage.g:2282:1: ( 'data' )
            {
            // InternalDataDescriptionLanguage.g:2282:1: ( 'data' )
            // InternalDataDescriptionLanguage.g:2283:2: 'data'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedDataDescriptionRuleAccess().getDataKeyword_1()); 
            }
            match(input,54,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:2292:1: rule__TypedDataDescriptionRule__Group__2 : rule__TypedDataDescriptionRule__Group__2__Impl rule__TypedDataDescriptionRule__Group__3 ;
    public final void rule__TypedDataDescriptionRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2296:1: ( rule__TypedDataDescriptionRule__Group__2__Impl rule__TypedDataDescriptionRule__Group__3 )
            // InternalDataDescriptionLanguage.g:2297:2: rule__TypedDataDescriptionRule__Group__2__Impl rule__TypedDataDescriptionRule__Group__3
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
    // InternalDataDescriptionLanguage.g:2304:1: rule__TypedDataDescriptionRule__Group__2__Impl : ( ( rule__TypedDataDescriptionRule__NameAssignment_2 ) ) ;
    public final void rule__TypedDataDescriptionRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2308:1: ( ( ( rule__TypedDataDescriptionRule__NameAssignment_2 ) ) )
            // InternalDataDescriptionLanguage.g:2309:1: ( ( rule__TypedDataDescriptionRule__NameAssignment_2 ) )
            {
            // InternalDataDescriptionLanguage.g:2309:1: ( ( rule__TypedDataDescriptionRule__NameAssignment_2 ) )
            // InternalDataDescriptionLanguage.g:2310:2: ( rule__TypedDataDescriptionRule__NameAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedDataDescriptionRuleAccess().getNameAssignment_2()); 
            }
            // InternalDataDescriptionLanguage.g:2311:2: ( rule__TypedDataDescriptionRule__NameAssignment_2 )
            // InternalDataDescriptionLanguage.g:2311:3: rule__TypedDataDescriptionRule__NameAssignment_2
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
    // InternalDataDescriptionLanguage.g:2319:1: rule__TypedDataDescriptionRule__Group__3 : rule__TypedDataDescriptionRule__Group__3__Impl rule__TypedDataDescriptionRule__Group__4 ;
    public final void rule__TypedDataDescriptionRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2323:1: ( rule__TypedDataDescriptionRule__Group__3__Impl rule__TypedDataDescriptionRule__Group__4 )
            // InternalDataDescriptionLanguage.g:2324:2: rule__TypedDataDescriptionRule__Group__3__Impl rule__TypedDataDescriptionRule__Group__4
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
    // InternalDataDescriptionLanguage.g:2331:1: rule__TypedDataDescriptionRule__Group__3__Impl : ( 'of' ) ;
    public final void rule__TypedDataDescriptionRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2335:1: ( ( 'of' ) )
            // InternalDataDescriptionLanguage.g:2336:1: ( 'of' )
            {
            // InternalDataDescriptionLanguage.g:2336:1: ( 'of' )
            // InternalDataDescriptionLanguage.g:2337:2: 'of'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedDataDescriptionRuleAccess().getOfKeyword_3()); 
            }
            match(input,61,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:2346:1: rule__TypedDataDescriptionRule__Group__4 : rule__TypedDataDescriptionRule__Group__4__Impl rule__TypedDataDescriptionRule__Group__5 ;
    public final void rule__TypedDataDescriptionRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2350:1: ( rule__TypedDataDescriptionRule__Group__4__Impl rule__TypedDataDescriptionRule__Group__5 )
            // InternalDataDescriptionLanguage.g:2351:2: rule__TypedDataDescriptionRule__Group__4__Impl rule__TypedDataDescriptionRule__Group__5
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
    // InternalDataDescriptionLanguage.g:2358:1: rule__TypedDataDescriptionRule__Group__4__Impl : ( 'type' ) ;
    public final void rule__TypedDataDescriptionRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2362:1: ( ( 'type' ) )
            // InternalDataDescriptionLanguage.g:2363:1: ( 'type' )
            {
            // InternalDataDescriptionLanguage.g:2363:1: ( 'type' )
            // InternalDataDescriptionLanguage.g:2364:2: 'type'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedDataDescriptionRuleAccess().getTypeKeyword_4()); 
            }
            match(input,58,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:2373:1: rule__TypedDataDescriptionRule__Group__5 : rule__TypedDataDescriptionRule__Group__5__Impl rule__TypedDataDescriptionRule__Group__6 ;
    public final void rule__TypedDataDescriptionRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2377:1: ( rule__TypedDataDescriptionRule__Group__5__Impl rule__TypedDataDescriptionRule__Group__6 )
            // InternalDataDescriptionLanguage.g:2378:2: rule__TypedDataDescriptionRule__Group__5__Impl rule__TypedDataDescriptionRule__Group__6
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
    // InternalDataDescriptionLanguage.g:2385:1: rule__TypedDataDescriptionRule__Group__5__Impl : ( ( rule__TypedDataDescriptionRule__TypeAssignment_5 ) ) ;
    public final void rule__TypedDataDescriptionRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2389:1: ( ( ( rule__TypedDataDescriptionRule__TypeAssignment_5 ) ) )
            // InternalDataDescriptionLanguage.g:2390:1: ( ( rule__TypedDataDescriptionRule__TypeAssignment_5 ) )
            {
            // InternalDataDescriptionLanguage.g:2390:1: ( ( rule__TypedDataDescriptionRule__TypeAssignment_5 ) )
            // InternalDataDescriptionLanguage.g:2391:2: ( rule__TypedDataDescriptionRule__TypeAssignment_5 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedDataDescriptionRuleAccess().getTypeAssignment_5()); 
            }
            // InternalDataDescriptionLanguage.g:2392:2: ( rule__TypedDataDescriptionRule__TypeAssignment_5 )
            // InternalDataDescriptionLanguage.g:2392:3: rule__TypedDataDescriptionRule__TypeAssignment_5
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
    // InternalDataDescriptionLanguage.g:2400:1: rule__TypedDataDescriptionRule__Group__6 : rule__TypedDataDescriptionRule__Group__6__Impl rule__TypedDataDescriptionRule__Group__7 ;
    public final void rule__TypedDataDescriptionRule__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2404:1: ( rule__TypedDataDescriptionRule__Group__6__Impl rule__TypedDataDescriptionRule__Group__7 )
            // InternalDataDescriptionLanguage.g:2405:2: rule__TypedDataDescriptionRule__Group__6__Impl rule__TypedDataDescriptionRule__Group__7
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
    // InternalDataDescriptionLanguage.g:2412:1: rule__TypedDataDescriptionRule__Group__6__Impl : ( ( rule__TypedDataDescriptionRule__Group_6__0 )? ) ;
    public final void rule__TypedDataDescriptionRule__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2416:1: ( ( ( rule__TypedDataDescriptionRule__Group_6__0 )? ) )
            // InternalDataDescriptionLanguage.g:2417:1: ( ( rule__TypedDataDescriptionRule__Group_6__0 )? )
            {
            // InternalDataDescriptionLanguage.g:2417:1: ( ( rule__TypedDataDescriptionRule__Group_6__0 )? )
            // InternalDataDescriptionLanguage.g:2418:2: ( rule__TypedDataDescriptionRule__Group_6__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedDataDescriptionRuleAccess().getGroup_6()); 
            }
            // InternalDataDescriptionLanguage.g:2419:2: ( rule__TypedDataDescriptionRule__Group_6__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==60) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:2419:3: rule__TypedDataDescriptionRule__Group_6__0
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
    // InternalDataDescriptionLanguage.g:2427:1: rule__TypedDataDescriptionRule__Group__7 : rule__TypedDataDescriptionRule__Group__7__Impl ;
    public final void rule__TypedDataDescriptionRule__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2431:1: ( rule__TypedDataDescriptionRule__Group__7__Impl )
            // InternalDataDescriptionLanguage.g:2432:2: rule__TypedDataDescriptionRule__Group__7__Impl
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
    // InternalDataDescriptionLanguage.g:2438:1: rule__TypedDataDescriptionRule__Group__7__Impl : ( ';' ) ;
    public final void rule__TypedDataDescriptionRule__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2442:1: ( ( ';' ) )
            // InternalDataDescriptionLanguage.g:2443:1: ( ';' )
            {
            // InternalDataDescriptionLanguage.g:2443:1: ( ';' )
            // InternalDataDescriptionLanguage.g:2444:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedDataDescriptionRuleAccess().getSemicolonKeyword_7()); 
            }
            match(input,57,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:2454:1: rule__TypedDataDescriptionRule__Group_6__0 : rule__TypedDataDescriptionRule__Group_6__0__Impl rule__TypedDataDescriptionRule__Group_6__1 ;
    public final void rule__TypedDataDescriptionRule__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2458:1: ( rule__TypedDataDescriptionRule__Group_6__0__Impl rule__TypedDataDescriptionRule__Group_6__1 )
            // InternalDataDescriptionLanguage.g:2459:2: rule__TypedDataDescriptionRule__Group_6__0__Impl rule__TypedDataDescriptionRule__Group_6__1
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
    // InternalDataDescriptionLanguage.g:2466:1: rule__TypedDataDescriptionRule__Group_6__0__Impl : ( 'with' ) ;
    public final void rule__TypedDataDescriptionRule__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2470:1: ( ( 'with' ) )
            // InternalDataDescriptionLanguage.g:2471:1: ( 'with' )
            {
            // InternalDataDescriptionLanguage.g:2471:1: ( 'with' )
            // InternalDataDescriptionLanguage.g:2472:2: 'with'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedDataDescriptionRuleAccess().getWithKeyword_6_0()); 
            }
            match(input,60,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:2481:1: rule__TypedDataDescriptionRule__Group_6__1 : rule__TypedDataDescriptionRule__Group_6__1__Impl rule__TypedDataDescriptionRule__Group_6__2 ;
    public final void rule__TypedDataDescriptionRule__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2485:1: ( rule__TypedDataDescriptionRule__Group_6__1__Impl rule__TypedDataDescriptionRule__Group_6__2 )
            // InternalDataDescriptionLanguage.g:2486:2: rule__TypedDataDescriptionRule__Group_6__1__Impl rule__TypedDataDescriptionRule__Group_6__2
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
    // InternalDataDescriptionLanguage.g:2493:1: rule__TypedDataDescriptionRule__Group_6__1__Impl : ( 'constraints' ) ;
    public final void rule__TypedDataDescriptionRule__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2497:1: ( ( 'constraints' ) )
            // InternalDataDescriptionLanguage.g:2498:1: ( 'constraints' )
            {
            // InternalDataDescriptionLanguage.g:2498:1: ( 'constraints' )
            // InternalDataDescriptionLanguage.g:2499:2: 'constraints'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedDataDescriptionRuleAccess().getConstraintsKeyword_6_1()); 
            }
            match(input,55,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:2508:1: rule__TypedDataDescriptionRule__Group_6__2 : rule__TypedDataDescriptionRule__Group_6__2__Impl rule__TypedDataDescriptionRule__Group_6__3 ;
    public final void rule__TypedDataDescriptionRule__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2512:1: ( rule__TypedDataDescriptionRule__Group_6__2__Impl rule__TypedDataDescriptionRule__Group_6__3 )
            // InternalDataDescriptionLanguage.g:2513:2: rule__TypedDataDescriptionRule__Group_6__2__Impl rule__TypedDataDescriptionRule__Group_6__3
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
    // InternalDataDescriptionLanguage.g:2520:1: rule__TypedDataDescriptionRule__Group_6__2__Impl : ( ':' ) ;
    public final void rule__TypedDataDescriptionRule__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2524:1: ( ( ':' ) )
            // InternalDataDescriptionLanguage.g:2525:1: ( ':' )
            {
            // InternalDataDescriptionLanguage.g:2525:1: ( ':' )
            // InternalDataDescriptionLanguage.g:2526:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedDataDescriptionRuleAccess().getColonKeyword_6_2()); 
            }
            match(input,53,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:2535:1: rule__TypedDataDescriptionRule__Group_6__3 : rule__TypedDataDescriptionRule__Group_6__3__Impl ;
    public final void rule__TypedDataDescriptionRule__Group_6__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2539:1: ( rule__TypedDataDescriptionRule__Group_6__3__Impl )
            // InternalDataDescriptionLanguage.g:2540:2: rule__TypedDataDescriptionRule__Group_6__3__Impl
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
    // InternalDataDescriptionLanguage.g:2546:1: rule__TypedDataDescriptionRule__Group_6__3__Impl : ( ( rule__TypedDataDescriptionRule__ConstraintsAssignment_6_3 )* ) ;
    public final void rule__TypedDataDescriptionRule__Group_6__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2550:1: ( ( ( rule__TypedDataDescriptionRule__ConstraintsAssignment_6_3 )* ) )
            // InternalDataDescriptionLanguage.g:2551:1: ( ( rule__TypedDataDescriptionRule__ConstraintsAssignment_6_3 )* )
            {
            // InternalDataDescriptionLanguage.g:2551:1: ( ( rule__TypedDataDescriptionRule__ConstraintsAssignment_6_3 )* )
            // InternalDataDescriptionLanguage.g:2552:2: ( rule__TypedDataDescriptionRule__ConstraintsAssignment_6_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedDataDescriptionRuleAccess().getConstraintsAssignment_6_3()); 
            }
            // InternalDataDescriptionLanguage.g:2553:2: ( rule__TypedDataDescriptionRule__ConstraintsAssignment_6_3 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0>=RULE_QUOTED_ID && LA25_0<=RULE_STRING)||LA25_0==12||(LA25_0>=27 && LA25_0<=28)||LA25_0==62||LA25_0==67||(LA25_0>=71 && LA25_0<=72)) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:2553:3: rule__TypedDataDescriptionRule__ConstraintsAssignment_6_3
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
    // InternalDataDescriptionLanguage.g:2562:1: rule__UntypedDataDescriptionRule__Group__0 : rule__UntypedDataDescriptionRule__Group__0__Impl rule__UntypedDataDescriptionRule__Group__1 ;
    public final void rule__UntypedDataDescriptionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2566:1: ( rule__UntypedDataDescriptionRule__Group__0__Impl rule__UntypedDataDescriptionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:2567:2: rule__UntypedDataDescriptionRule__Group__0__Impl rule__UntypedDataDescriptionRule__Group__1
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
    // InternalDataDescriptionLanguage.g:2574:1: rule__UntypedDataDescriptionRule__Group__0__Impl : ( ( rule__UntypedDataDescriptionRule__ScaleAssignment_0 )? ) ;
    public final void rule__UntypedDataDescriptionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2578:1: ( ( ( rule__UntypedDataDescriptionRule__ScaleAssignment_0 )? ) )
            // InternalDataDescriptionLanguage.g:2579:1: ( ( rule__UntypedDataDescriptionRule__ScaleAssignment_0 )? )
            {
            // InternalDataDescriptionLanguage.g:2579:1: ( ( rule__UntypedDataDescriptionRule__ScaleAssignment_0 )? )
            // InternalDataDescriptionLanguage.g:2580:2: ( rule__UntypedDataDescriptionRule__ScaleAssignment_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUntypedDataDescriptionRuleAccess().getScaleAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:2581:2: ( rule__UntypedDataDescriptionRule__ScaleAssignment_0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( ((LA26_0>=13 && LA26_0<=16)) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:2581:3: rule__UntypedDataDescriptionRule__ScaleAssignment_0
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
    // InternalDataDescriptionLanguage.g:2589:1: rule__UntypedDataDescriptionRule__Group__1 : rule__UntypedDataDescriptionRule__Group__1__Impl rule__UntypedDataDescriptionRule__Group__2 ;
    public final void rule__UntypedDataDescriptionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2593:1: ( rule__UntypedDataDescriptionRule__Group__1__Impl rule__UntypedDataDescriptionRule__Group__2 )
            // InternalDataDescriptionLanguage.g:2594:2: rule__UntypedDataDescriptionRule__Group__1__Impl rule__UntypedDataDescriptionRule__Group__2
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
    // InternalDataDescriptionLanguage.g:2601:1: rule__UntypedDataDescriptionRule__Group__1__Impl : ( ( rule__UntypedDataDescriptionRule__RepresentationAssignment_1 ) ) ;
    public final void rule__UntypedDataDescriptionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2605:1: ( ( ( rule__UntypedDataDescriptionRule__RepresentationAssignment_1 ) ) )
            // InternalDataDescriptionLanguage.g:2606:1: ( ( rule__UntypedDataDescriptionRule__RepresentationAssignment_1 ) )
            {
            // InternalDataDescriptionLanguage.g:2606:1: ( ( rule__UntypedDataDescriptionRule__RepresentationAssignment_1 ) )
            // InternalDataDescriptionLanguage.g:2607:2: ( rule__UntypedDataDescriptionRule__RepresentationAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUntypedDataDescriptionRuleAccess().getRepresentationAssignment_1()); 
            }
            // InternalDataDescriptionLanguage.g:2608:2: ( rule__UntypedDataDescriptionRule__RepresentationAssignment_1 )
            // InternalDataDescriptionLanguage.g:2608:3: rule__UntypedDataDescriptionRule__RepresentationAssignment_1
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
    // InternalDataDescriptionLanguage.g:2616:1: rule__UntypedDataDescriptionRule__Group__2 : rule__UntypedDataDescriptionRule__Group__2__Impl rule__UntypedDataDescriptionRule__Group__3 ;
    public final void rule__UntypedDataDescriptionRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2620:1: ( rule__UntypedDataDescriptionRule__Group__2__Impl rule__UntypedDataDescriptionRule__Group__3 )
            // InternalDataDescriptionLanguage.g:2621:2: rule__UntypedDataDescriptionRule__Group__2__Impl rule__UntypedDataDescriptionRule__Group__3
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
    // InternalDataDescriptionLanguage.g:2628:1: rule__UntypedDataDescriptionRule__Group__2__Impl : ( 'data' ) ;
    public final void rule__UntypedDataDescriptionRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2632:1: ( ( 'data' ) )
            // InternalDataDescriptionLanguage.g:2633:1: ( 'data' )
            {
            // InternalDataDescriptionLanguage.g:2633:1: ( 'data' )
            // InternalDataDescriptionLanguage.g:2634:2: 'data'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUntypedDataDescriptionRuleAccess().getDataKeyword_2()); 
            }
            match(input,54,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:2643:1: rule__UntypedDataDescriptionRule__Group__3 : rule__UntypedDataDescriptionRule__Group__3__Impl rule__UntypedDataDescriptionRule__Group__4 ;
    public final void rule__UntypedDataDescriptionRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2647:1: ( rule__UntypedDataDescriptionRule__Group__3__Impl rule__UntypedDataDescriptionRule__Group__4 )
            // InternalDataDescriptionLanguage.g:2648:2: rule__UntypedDataDescriptionRule__Group__3__Impl rule__UntypedDataDescriptionRule__Group__4
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
    // InternalDataDescriptionLanguage.g:2655:1: rule__UntypedDataDescriptionRule__Group__3__Impl : ( ( rule__UntypedDataDescriptionRule__NameAssignment_3 ) ) ;
    public final void rule__UntypedDataDescriptionRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2659:1: ( ( ( rule__UntypedDataDescriptionRule__NameAssignment_3 ) ) )
            // InternalDataDescriptionLanguage.g:2660:1: ( ( rule__UntypedDataDescriptionRule__NameAssignment_3 ) )
            {
            // InternalDataDescriptionLanguage.g:2660:1: ( ( rule__UntypedDataDescriptionRule__NameAssignment_3 ) )
            // InternalDataDescriptionLanguage.g:2661:2: ( rule__UntypedDataDescriptionRule__NameAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUntypedDataDescriptionRuleAccess().getNameAssignment_3()); 
            }
            // InternalDataDescriptionLanguage.g:2662:2: ( rule__UntypedDataDescriptionRule__NameAssignment_3 )
            // InternalDataDescriptionLanguage.g:2662:3: rule__UntypedDataDescriptionRule__NameAssignment_3
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
    // InternalDataDescriptionLanguage.g:2670:1: rule__UntypedDataDescriptionRule__Group__4 : rule__UntypedDataDescriptionRule__Group__4__Impl rule__UntypedDataDescriptionRule__Group__5 ;
    public final void rule__UntypedDataDescriptionRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2674:1: ( rule__UntypedDataDescriptionRule__Group__4__Impl rule__UntypedDataDescriptionRule__Group__5 )
            // InternalDataDescriptionLanguage.g:2675:2: rule__UntypedDataDescriptionRule__Group__4__Impl rule__UntypedDataDescriptionRule__Group__5
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
    // InternalDataDescriptionLanguage.g:2682:1: rule__UntypedDataDescriptionRule__Group__4__Impl : ( ( rule__UntypedDataDescriptionRule__Group_4__0 )? ) ;
    public final void rule__UntypedDataDescriptionRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2686:1: ( ( ( rule__UntypedDataDescriptionRule__Group_4__0 )? ) )
            // InternalDataDescriptionLanguage.g:2687:1: ( ( rule__UntypedDataDescriptionRule__Group_4__0 )? )
            {
            // InternalDataDescriptionLanguage.g:2687:1: ( ( rule__UntypedDataDescriptionRule__Group_4__0 )? )
            // InternalDataDescriptionLanguage.g:2688:2: ( rule__UntypedDataDescriptionRule__Group_4__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUntypedDataDescriptionRuleAccess().getGroup_4()); 
            }
            // InternalDataDescriptionLanguage.g:2689:2: ( rule__UntypedDataDescriptionRule__Group_4__0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==60) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:2689:3: rule__UntypedDataDescriptionRule__Group_4__0
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
    // InternalDataDescriptionLanguage.g:2697:1: rule__UntypedDataDescriptionRule__Group__5 : rule__UntypedDataDescriptionRule__Group__5__Impl ;
    public final void rule__UntypedDataDescriptionRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2701:1: ( rule__UntypedDataDescriptionRule__Group__5__Impl )
            // InternalDataDescriptionLanguage.g:2702:2: rule__UntypedDataDescriptionRule__Group__5__Impl
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
    // InternalDataDescriptionLanguage.g:2708:1: rule__UntypedDataDescriptionRule__Group__5__Impl : ( ';' ) ;
    public final void rule__UntypedDataDescriptionRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2712:1: ( ( ';' ) )
            // InternalDataDescriptionLanguage.g:2713:1: ( ';' )
            {
            // InternalDataDescriptionLanguage.g:2713:1: ( ';' )
            // InternalDataDescriptionLanguage.g:2714:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUntypedDataDescriptionRuleAccess().getSemicolonKeyword_5()); 
            }
            match(input,57,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:2724:1: rule__UntypedDataDescriptionRule__Group_4__0 : rule__UntypedDataDescriptionRule__Group_4__0__Impl rule__UntypedDataDescriptionRule__Group_4__1 ;
    public final void rule__UntypedDataDescriptionRule__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2728:1: ( rule__UntypedDataDescriptionRule__Group_4__0__Impl rule__UntypedDataDescriptionRule__Group_4__1 )
            // InternalDataDescriptionLanguage.g:2729:2: rule__UntypedDataDescriptionRule__Group_4__0__Impl rule__UntypedDataDescriptionRule__Group_4__1
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
    // InternalDataDescriptionLanguage.g:2736:1: rule__UntypedDataDescriptionRule__Group_4__0__Impl : ( 'with' ) ;
    public final void rule__UntypedDataDescriptionRule__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2740:1: ( ( 'with' ) )
            // InternalDataDescriptionLanguage.g:2741:1: ( 'with' )
            {
            // InternalDataDescriptionLanguage.g:2741:1: ( 'with' )
            // InternalDataDescriptionLanguage.g:2742:2: 'with'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUntypedDataDescriptionRuleAccess().getWithKeyword_4_0()); 
            }
            match(input,60,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:2751:1: rule__UntypedDataDescriptionRule__Group_4__1 : rule__UntypedDataDescriptionRule__Group_4__1__Impl rule__UntypedDataDescriptionRule__Group_4__2 ;
    public final void rule__UntypedDataDescriptionRule__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2755:1: ( rule__UntypedDataDescriptionRule__Group_4__1__Impl rule__UntypedDataDescriptionRule__Group_4__2 )
            // InternalDataDescriptionLanguage.g:2756:2: rule__UntypedDataDescriptionRule__Group_4__1__Impl rule__UntypedDataDescriptionRule__Group_4__2
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
    // InternalDataDescriptionLanguage.g:2763:1: rule__UntypedDataDescriptionRule__Group_4__1__Impl : ( 'constraints' ) ;
    public final void rule__UntypedDataDescriptionRule__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2767:1: ( ( 'constraints' ) )
            // InternalDataDescriptionLanguage.g:2768:1: ( 'constraints' )
            {
            // InternalDataDescriptionLanguage.g:2768:1: ( 'constraints' )
            // InternalDataDescriptionLanguage.g:2769:2: 'constraints'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUntypedDataDescriptionRuleAccess().getConstraintsKeyword_4_1()); 
            }
            match(input,55,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:2778:1: rule__UntypedDataDescriptionRule__Group_4__2 : rule__UntypedDataDescriptionRule__Group_4__2__Impl rule__UntypedDataDescriptionRule__Group_4__3 ;
    public final void rule__UntypedDataDescriptionRule__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2782:1: ( rule__UntypedDataDescriptionRule__Group_4__2__Impl rule__UntypedDataDescriptionRule__Group_4__3 )
            // InternalDataDescriptionLanguage.g:2783:2: rule__UntypedDataDescriptionRule__Group_4__2__Impl rule__UntypedDataDescriptionRule__Group_4__3
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
    // InternalDataDescriptionLanguage.g:2790:1: rule__UntypedDataDescriptionRule__Group_4__2__Impl : ( ':' ) ;
    public final void rule__UntypedDataDescriptionRule__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2794:1: ( ( ':' ) )
            // InternalDataDescriptionLanguage.g:2795:1: ( ':' )
            {
            // InternalDataDescriptionLanguage.g:2795:1: ( ':' )
            // InternalDataDescriptionLanguage.g:2796:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUntypedDataDescriptionRuleAccess().getColonKeyword_4_2()); 
            }
            match(input,53,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:2805:1: rule__UntypedDataDescriptionRule__Group_4__3 : rule__UntypedDataDescriptionRule__Group_4__3__Impl ;
    public final void rule__UntypedDataDescriptionRule__Group_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2809:1: ( rule__UntypedDataDescriptionRule__Group_4__3__Impl )
            // InternalDataDescriptionLanguage.g:2810:2: rule__UntypedDataDescriptionRule__Group_4__3__Impl
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
    // InternalDataDescriptionLanguage.g:2816:1: rule__UntypedDataDescriptionRule__Group_4__3__Impl : ( ( rule__UntypedDataDescriptionRule__ConstraintsAssignment_4_3 )* ) ;
    public final void rule__UntypedDataDescriptionRule__Group_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2820:1: ( ( ( rule__UntypedDataDescriptionRule__ConstraintsAssignment_4_3 )* ) )
            // InternalDataDescriptionLanguage.g:2821:1: ( ( rule__UntypedDataDescriptionRule__ConstraintsAssignment_4_3 )* )
            {
            // InternalDataDescriptionLanguage.g:2821:1: ( ( rule__UntypedDataDescriptionRule__ConstraintsAssignment_4_3 )* )
            // InternalDataDescriptionLanguage.g:2822:2: ( rule__UntypedDataDescriptionRule__ConstraintsAssignment_4_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUntypedDataDescriptionRuleAccess().getConstraintsAssignment_4_3()); 
            }
            // InternalDataDescriptionLanguage.g:2823:2: ( rule__UntypedDataDescriptionRule__ConstraintsAssignment_4_3 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( ((LA28_0>=RULE_QUOTED_ID && LA28_0<=RULE_STRING)||LA28_0==12||(LA28_0>=27 && LA28_0<=28)||LA28_0==62||LA28_0==67||(LA28_0>=71 && LA28_0<=72)) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:2823:3: rule__UntypedDataDescriptionRule__ConstraintsAssignment_4_3
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
    // InternalDataDescriptionLanguage.g:2832:1: rule__StatementRule__Group__0 : rule__StatementRule__Group__0__Impl rule__StatementRule__Group__1 ;
    public final void rule__StatementRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2836:1: ( rule__StatementRule__Group__0__Impl rule__StatementRule__Group__1 )
            // InternalDataDescriptionLanguage.g:2837:2: rule__StatementRule__Group__0__Impl rule__StatementRule__Group__1
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
    // InternalDataDescriptionLanguage.g:2844:1: rule__StatementRule__Group__0__Impl : ( ruleExpressionRule ) ;
    public final void rule__StatementRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2848:1: ( ( ruleExpressionRule ) )
            // InternalDataDescriptionLanguage.g:2849:1: ( ruleExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:2849:1: ( ruleExpressionRule )
            // InternalDataDescriptionLanguage.g:2850:2: ruleExpressionRule
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
    // InternalDataDescriptionLanguage.g:2859:1: rule__StatementRule__Group__1 : rule__StatementRule__Group__1__Impl ;
    public final void rule__StatementRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2863:1: ( rule__StatementRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:2864:2: rule__StatementRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:2870:1: rule__StatementRule__Group__1__Impl : ( ';' ) ;
    public final void rule__StatementRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2874:1: ( ( ';' ) )
            // InternalDataDescriptionLanguage.g:2875:1: ( ';' )
            {
            // InternalDataDescriptionLanguage.g:2875:1: ( ';' )
            // InternalDataDescriptionLanguage.g:2876:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStatementRuleAccess().getSemicolonKeyword_1()); 
            }
            match(input,57,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:2886:1: rule__SelfReferenceRule__Group__0 : rule__SelfReferenceRule__Group__0__Impl rule__SelfReferenceRule__Group__1 ;
    public final void rule__SelfReferenceRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2890:1: ( rule__SelfReferenceRule__Group__0__Impl rule__SelfReferenceRule__Group__1 )
            // InternalDataDescriptionLanguage.g:2891:2: rule__SelfReferenceRule__Group__0__Impl rule__SelfReferenceRule__Group__1
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
    // InternalDataDescriptionLanguage.g:2898:1: rule__SelfReferenceRule__Group__0__Impl : ( () ) ;
    public final void rule__SelfReferenceRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2902:1: ( ( () ) )
            // InternalDataDescriptionLanguage.g:2903:1: ( () )
            {
            // InternalDataDescriptionLanguage.g:2903:1: ( () )
            // InternalDataDescriptionLanguage.g:2904:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSelfReferenceRuleAccess().getSelfReferenceAction_0()); 
            }
            // InternalDataDescriptionLanguage.g:2905:2: ()
            // InternalDataDescriptionLanguage.g:2905:3: 
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
    // InternalDataDescriptionLanguage.g:2913:1: rule__SelfReferenceRule__Group__1 : rule__SelfReferenceRule__Group__1__Impl ;
    public final void rule__SelfReferenceRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2917:1: ( rule__SelfReferenceRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:2918:2: rule__SelfReferenceRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:2924:1: rule__SelfReferenceRule__Group__1__Impl : ( 'value' ) ;
    public final void rule__SelfReferenceRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2928:1: ( ( 'value' ) )
            // InternalDataDescriptionLanguage.g:2929:1: ( 'value' )
            {
            // InternalDataDescriptionLanguage.g:2929:1: ( 'value' )
            // InternalDataDescriptionLanguage.g:2930:2: 'value'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSelfReferenceRuleAccess().getValueKeyword_1()); 
            }
            match(input,62,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:2940:1: rule__OrExpressionRule__Group__0 : rule__OrExpressionRule__Group__0__Impl rule__OrExpressionRule__Group__1 ;
    public final void rule__OrExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2944:1: ( rule__OrExpressionRule__Group__0__Impl rule__OrExpressionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:2945:2: rule__OrExpressionRule__Group__0__Impl rule__OrExpressionRule__Group__1
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
    // InternalDataDescriptionLanguage.g:2952:1: rule__OrExpressionRule__Group__0__Impl : ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) ) ;
    public final void rule__OrExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2956:1: ( ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:2957:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:2957:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:2958:2: ( rule__OrExpressionRule__SubExpressionsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:2959:2: ( rule__OrExpressionRule__SubExpressionsAssignment_0 )
            // InternalDataDescriptionLanguage.g:2959:3: rule__OrExpressionRule__SubExpressionsAssignment_0
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
    // InternalDataDescriptionLanguage.g:2967:1: rule__OrExpressionRule__Group__1 : rule__OrExpressionRule__Group__1__Impl ;
    public final void rule__OrExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2971:1: ( rule__OrExpressionRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:2972:2: rule__OrExpressionRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:2978:1: rule__OrExpressionRule__Group__1__Impl : ( ( rule__OrExpressionRule__Group_1__0 )* ) ;
    public final void rule__OrExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2982:1: ( ( ( rule__OrExpressionRule__Group_1__0 )* ) )
            // InternalDataDescriptionLanguage.g:2983:1: ( ( rule__OrExpressionRule__Group_1__0 )* )
            {
            // InternalDataDescriptionLanguage.g:2983:1: ( ( rule__OrExpressionRule__Group_1__0 )* )
            // InternalDataDescriptionLanguage.g:2984:2: ( rule__OrExpressionRule__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionRuleAccess().getGroup_1()); 
            }
            // InternalDataDescriptionLanguage.g:2985:2: ( rule__OrExpressionRule__Group_1__0 )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==63) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:2985:3: rule__OrExpressionRule__Group_1__0
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
    // InternalDataDescriptionLanguage.g:2994:1: rule__OrExpressionRule__Group_1__0 : rule__OrExpressionRule__Group_1__0__Impl rule__OrExpressionRule__Group_1__1 ;
    public final void rule__OrExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2998:1: ( rule__OrExpressionRule__Group_1__0__Impl rule__OrExpressionRule__Group_1__1 )
            // InternalDataDescriptionLanguage.g:2999:2: rule__OrExpressionRule__Group_1__0__Impl rule__OrExpressionRule__Group_1__1
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
    // InternalDataDescriptionLanguage.g:3006:1: rule__OrExpressionRule__Group_1__0__Impl : ( 'OR' ) ;
    public final void rule__OrExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3010:1: ( ( 'OR' ) )
            // InternalDataDescriptionLanguage.g:3011:1: ( 'OR' )
            {
            // InternalDataDescriptionLanguage.g:3011:1: ( 'OR' )
            // InternalDataDescriptionLanguage.g:3012:2: 'OR'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionRuleAccess().getORKeyword_1_0()); 
            }
            match(input,63,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:3021:1: rule__OrExpressionRule__Group_1__1 : rule__OrExpressionRule__Group_1__1__Impl ;
    public final void rule__OrExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3025:1: ( rule__OrExpressionRule__Group_1__1__Impl )
            // InternalDataDescriptionLanguage.g:3026:2: rule__OrExpressionRule__Group_1__1__Impl
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
    // InternalDataDescriptionLanguage.g:3032:1: rule__OrExpressionRule__Group_1__1__Impl : ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) ) ;
    public final void rule__OrExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3036:1: ( ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) ) )
            // InternalDataDescriptionLanguage.g:3037:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) )
            {
            // InternalDataDescriptionLanguage.g:3037:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) )
            // InternalDataDescriptionLanguage.g:3038:2: ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsAssignment_1_1()); 
            }
            // InternalDataDescriptionLanguage.g:3039:2: ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 )
            // InternalDataDescriptionLanguage.g:3039:3: rule__OrExpressionRule__SubExpressionsAssignment_1_1
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
    // InternalDataDescriptionLanguage.g:3048:1: rule__XorExpressionRule__Group__0 : rule__XorExpressionRule__Group__0__Impl rule__XorExpressionRule__Group__1 ;
    public final void rule__XorExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3052:1: ( rule__XorExpressionRule__Group__0__Impl rule__XorExpressionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:3053:2: rule__XorExpressionRule__Group__0__Impl rule__XorExpressionRule__Group__1
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
    // InternalDataDescriptionLanguage.g:3060:1: rule__XorExpressionRule__Group__0__Impl : ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) ) ;
    public final void rule__XorExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3064:1: ( ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:3065:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:3065:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:3066:2: ( rule__XorExpressionRule__SubExpressionsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:3067:2: ( rule__XorExpressionRule__SubExpressionsAssignment_0 )
            // InternalDataDescriptionLanguage.g:3067:3: rule__XorExpressionRule__SubExpressionsAssignment_0
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
    // InternalDataDescriptionLanguage.g:3075:1: rule__XorExpressionRule__Group__1 : rule__XorExpressionRule__Group__1__Impl ;
    public final void rule__XorExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3079:1: ( rule__XorExpressionRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:3080:2: rule__XorExpressionRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:3086:1: rule__XorExpressionRule__Group__1__Impl : ( ( rule__XorExpressionRule__Group_1__0 )* ) ;
    public final void rule__XorExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3090:1: ( ( ( rule__XorExpressionRule__Group_1__0 )* ) )
            // InternalDataDescriptionLanguage.g:3091:1: ( ( rule__XorExpressionRule__Group_1__0 )* )
            {
            // InternalDataDescriptionLanguage.g:3091:1: ( ( rule__XorExpressionRule__Group_1__0 )* )
            // InternalDataDescriptionLanguage.g:3092:2: ( rule__XorExpressionRule__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXorExpressionRuleAccess().getGroup_1()); 
            }
            // InternalDataDescriptionLanguage.g:3093:2: ( rule__XorExpressionRule__Group_1__0 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==64) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:3093:3: rule__XorExpressionRule__Group_1__0
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
    // InternalDataDescriptionLanguage.g:3102:1: rule__XorExpressionRule__Group_1__0 : rule__XorExpressionRule__Group_1__0__Impl rule__XorExpressionRule__Group_1__1 ;
    public final void rule__XorExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3106:1: ( rule__XorExpressionRule__Group_1__0__Impl rule__XorExpressionRule__Group_1__1 )
            // InternalDataDescriptionLanguage.g:3107:2: rule__XorExpressionRule__Group_1__0__Impl rule__XorExpressionRule__Group_1__1
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
    // InternalDataDescriptionLanguage.g:3114:1: rule__XorExpressionRule__Group_1__0__Impl : ( 'XOR' ) ;
    public final void rule__XorExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3118:1: ( ( 'XOR' ) )
            // InternalDataDescriptionLanguage.g:3119:1: ( 'XOR' )
            {
            // InternalDataDescriptionLanguage.g:3119:1: ( 'XOR' )
            // InternalDataDescriptionLanguage.g:3120:2: 'XOR'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXorExpressionRuleAccess().getXORKeyword_1_0()); 
            }
            match(input,64,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:3129:1: rule__XorExpressionRule__Group_1__1 : rule__XorExpressionRule__Group_1__1__Impl ;
    public final void rule__XorExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3133:1: ( rule__XorExpressionRule__Group_1__1__Impl )
            // InternalDataDescriptionLanguage.g:3134:2: rule__XorExpressionRule__Group_1__1__Impl
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
    // InternalDataDescriptionLanguage.g:3140:1: rule__XorExpressionRule__Group_1__1__Impl : ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) ) ;
    public final void rule__XorExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3144:1: ( ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) ) )
            // InternalDataDescriptionLanguage.g:3145:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) )
            {
            // InternalDataDescriptionLanguage.g:3145:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) )
            // InternalDataDescriptionLanguage.g:3146:2: ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAssignment_1_1()); 
            }
            // InternalDataDescriptionLanguage.g:3147:2: ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 )
            // InternalDataDescriptionLanguage.g:3147:3: rule__XorExpressionRule__SubExpressionsAssignment_1_1
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
    // InternalDataDescriptionLanguage.g:3156:1: rule__AndExpressionRule__Group__0 : rule__AndExpressionRule__Group__0__Impl rule__AndExpressionRule__Group__1 ;
    public final void rule__AndExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3160:1: ( rule__AndExpressionRule__Group__0__Impl rule__AndExpressionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:3161:2: rule__AndExpressionRule__Group__0__Impl rule__AndExpressionRule__Group__1
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
    // InternalDataDescriptionLanguage.g:3168:1: rule__AndExpressionRule__Group__0__Impl : ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) ) ;
    public final void rule__AndExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3172:1: ( ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:3173:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:3173:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:3174:2: ( rule__AndExpressionRule__SubExpressionsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:3175:2: ( rule__AndExpressionRule__SubExpressionsAssignment_0 )
            // InternalDataDescriptionLanguage.g:3175:3: rule__AndExpressionRule__SubExpressionsAssignment_0
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
    // InternalDataDescriptionLanguage.g:3183:1: rule__AndExpressionRule__Group__1 : rule__AndExpressionRule__Group__1__Impl ;
    public final void rule__AndExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3187:1: ( rule__AndExpressionRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:3188:2: rule__AndExpressionRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:3194:1: rule__AndExpressionRule__Group__1__Impl : ( ( rule__AndExpressionRule__Group_1__0 )* ) ;
    public final void rule__AndExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3198:1: ( ( ( rule__AndExpressionRule__Group_1__0 )* ) )
            // InternalDataDescriptionLanguage.g:3199:1: ( ( rule__AndExpressionRule__Group_1__0 )* )
            {
            // InternalDataDescriptionLanguage.g:3199:1: ( ( rule__AndExpressionRule__Group_1__0 )* )
            // InternalDataDescriptionLanguage.g:3200:2: ( rule__AndExpressionRule__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionRuleAccess().getGroup_1()); 
            }
            // InternalDataDescriptionLanguage.g:3201:2: ( rule__AndExpressionRule__Group_1__0 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==65) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:3201:3: rule__AndExpressionRule__Group_1__0
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
    // InternalDataDescriptionLanguage.g:3210:1: rule__AndExpressionRule__Group_1__0 : rule__AndExpressionRule__Group_1__0__Impl rule__AndExpressionRule__Group_1__1 ;
    public final void rule__AndExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3214:1: ( rule__AndExpressionRule__Group_1__0__Impl rule__AndExpressionRule__Group_1__1 )
            // InternalDataDescriptionLanguage.g:3215:2: rule__AndExpressionRule__Group_1__0__Impl rule__AndExpressionRule__Group_1__1
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
    // InternalDataDescriptionLanguage.g:3222:1: rule__AndExpressionRule__Group_1__0__Impl : ( 'AND' ) ;
    public final void rule__AndExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3226:1: ( ( 'AND' ) )
            // InternalDataDescriptionLanguage.g:3227:1: ( 'AND' )
            {
            // InternalDataDescriptionLanguage.g:3227:1: ( 'AND' )
            // InternalDataDescriptionLanguage.g:3228:2: 'AND'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionRuleAccess().getANDKeyword_1_0()); 
            }
            match(input,65,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:3237:1: rule__AndExpressionRule__Group_1__1 : rule__AndExpressionRule__Group_1__1__Impl ;
    public final void rule__AndExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3241:1: ( rule__AndExpressionRule__Group_1__1__Impl )
            // InternalDataDescriptionLanguage.g:3242:2: rule__AndExpressionRule__Group_1__1__Impl
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
    // InternalDataDescriptionLanguage.g:3248:1: rule__AndExpressionRule__Group_1__1__Impl : ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) ) ;
    public final void rule__AndExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3252:1: ( ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) ) )
            // InternalDataDescriptionLanguage.g:3253:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) )
            {
            // InternalDataDescriptionLanguage.g:3253:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) )
            // InternalDataDescriptionLanguage.g:3254:2: ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsAssignment_1_1()); 
            }
            // InternalDataDescriptionLanguage.g:3255:2: ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 )
            // InternalDataDescriptionLanguage.g:3255:3: rule__AndExpressionRule__SubExpressionsAssignment_1_1
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
    // InternalDataDescriptionLanguage.g:3264:1: rule__NotExpressionRule__Group__0 : rule__NotExpressionRule__Group__0__Impl rule__NotExpressionRule__Group__1 ;
    public final void rule__NotExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3268:1: ( rule__NotExpressionRule__Group__0__Impl rule__NotExpressionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:3269:2: rule__NotExpressionRule__Group__0__Impl rule__NotExpressionRule__Group__1
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
    // InternalDataDescriptionLanguage.g:3276:1: rule__NotExpressionRule__Group__0__Impl : ( ( rule__NotExpressionRule__NegatedAssignment_0 )? ) ;
    public final void rule__NotExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3280:1: ( ( ( rule__NotExpressionRule__NegatedAssignment_0 )? ) )
            // InternalDataDescriptionLanguage.g:3281:1: ( ( rule__NotExpressionRule__NegatedAssignment_0 )? )
            {
            // InternalDataDescriptionLanguage.g:3281:1: ( ( rule__NotExpressionRule__NegatedAssignment_0 )? )
            // InternalDataDescriptionLanguage.g:3282:2: ( rule__NotExpressionRule__NegatedAssignment_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNotExpressionRuleAccess().getNegatedAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:3283:2: ( rule__NotExpressionRule__NegatedAssignment_0 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==71) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:3283:3: rule__NotExpressionRule__NegatedAssignment_0
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
    // InternalDataDescriptionLanguage.g:3291:1: rule__NotExpressionRule__Group__1 : rule__NotExpressionRule__Group__1__Impl ;
    public final void rule__NotExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3295:1: ( rule__NotExpressionRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:3296:2: rule__NotExpressionRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:3302:1: rule__NotExpressionRule__Group__1__Impl : ( ( rule__NotExpressionRule__OperandAssignment_1 ) ) ;
    public final void rule__NotExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3306:1: ( ( ( rule__NotExpressionRule__OperandAssignment_1 ) ) )
            // InternalDataDescriptionLanguage.g:3307:1: ( ( rule__NotExpressionRule__OperandAssignment_1 ) )
            {
            // InternalDataDescriptionLanguage.g:3307:1: ( ( rule__NotExpressionRule__OperandAssignment_1 ) )
            // InternalDataDescriptionLanguage.g:3308:2: ( rule__NotExpressionRule__OperandAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNotExpressionRuleAccess().getOperandAssignment_1()); 
            }
            // InternalDataDescriptionLanguage.g:3309:2: ( rule__NotExpressionRule__OperandAssignment_1 )
            // InternalDataDescriptionLanguage.g:3309:3: rule__NotExpressionRule__OperandAssignment_1
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
    // InternalDataDescriptionLanguage.g:3318:1: rule__ComparisonExpressionRule__Group__0 : rule__ComparisonExpressionRule__Group__0__Impl rule__ComparisonExpressionRule__Group__1 ;
    public final void rule__ComparisonExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3322:1: ( rule__ComparisonExpressionRule__Group__0__Impl rule__ComparisonExpressionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:3323:2: rule__ComparisonExpressionRule__Group__0__Impl rule__ComparisonExpressionRule__Group__1
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
    // InternalDataDescriptionLanguage.g:3330:1: rule__ComparisonExpressionRule__Group__0__Impl : ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__ComparisonExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3334:1: ( ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:3335:1: ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:3335:1: ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:3336:2: ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonExpressionRuleAccess().getLeftOperandAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:3337:2: ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 )
            // InternalDataDescriptionLanguage.g:3337:3: rule__ComparisonExpressionRule__LeftOperandAssignment_0
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
    // InternalDataDescriptionLanguage.g:3345:1: rule__ComparisonExpressionRule__Group__1 : rule__ComparisonExpressionRule__Group__1__Impl ;
    public final void rule__ComparisonExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3349:1: ( rule__ComparisonExpressionRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:3350:2: rule__ComparisonExpressionRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:3356:1: rule__ComparisonExpressionRule__Group__1__Impl : ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* ) ;
    public final void rule__ComparisonExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3360:1: ( ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* ) )
            // InternalDataDescriptionLanguage.g:3361:1: ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* )
            {
            // InternalDataDescriptionLanguage.g:3361:1: ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* )
            // InternalDataDescriptionLanguage.g:3362:2: ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonExpressionRuleAccess().getComparisonAssignment_1()); 
            }
            // InternalDataDescriptionLanguage.g:3363:2: ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( ((LA33_0>=21 && LA33_0<=26)) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:3363:3: rule__ComparisonExpressionRule__ComparisonAssignment_1
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
    // InternalDataDescriptionLanguage.g:3372:1: rule__PartialComparisonExpressionRule__Group__0 : rule__PartialComparisonExpressionRule__Group__0__Impl rule__PartialComparisonExpressionRule__Group__1 ;
    public final void rule__PartialComparisonExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3376:1: ( rule__PartialComparisonExpressionRule__Group__0__Impl rule__PartialComparisonExpressionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:3377:2: rule__PartialComparisonExpressionRule__Group__0__Impl rule__PartialComparisonExpressionRule__Group__1
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
    // InternalDataDescriptionLanguage.g:3384:1: rule__PartialComparisonExpressionRule__Group__0__Impl : ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) ) ;
    public final void rule__PartialComparisonExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3388:1: ( ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:3389:1: ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:3389:1: ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:3390:2: ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartialComparisonExpressionRuleAccess().getOperatorAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:3391:2: ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 )
            // InternalDataDescriptionLanguage.g:3391:3: rule__PartialComparisonExpressionRule__OperatorAssignment_0
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
    // InternalDataDescriptionLanguage.g:3399:1: rule__PartialComparisonExpressionRule__Group__1 : rule__PartialComparisonExpressionRule__Group__1__Impl ;
    public final void rule__PartialComparisonExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3403:1: ( rule__PartialComparisonExpressionRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:3404:2: rule__PartialComparisonExpressionRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:3410:1: rule__PartialComparisonExpressionRule__Group__1__Impl : ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) ) ;
    public final void rule__PartialComparisonExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3414:1: ( ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) ) )
            // InternalDataDescriptionLanguage.g:3415:1: ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) )
            {
            // InternalDataDescriptionLanguage.g:3415:1: ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) )
            // InternalDataDescriptionLanguage.g:3416:2: ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartialComparisonExpressionRuleAccess().getSubExpressionAssignment_1()); 
            }
            // InternalDataDescriptionLanguage.g:3417:2: ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 )
            // InternalDataDescriptionLanguage.g:3417:3: rule__PartialComparisonExpressionRule__SubExpressionAssignment_1
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
    // InternalDataDescriptionLanguage.g:3426:1: rule__AddOrSubtractExpressionRule__Group__0 : rule__AddOrSubtractExpressionRule__Group__0__Impl rule__AddOrSubtractExpressionRule__Group__1 ;
    public final void rule__AddOrSubtractExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3430:1: ( rule__AddOrSubtractExpressionRule__Group__0__Impl rule__AddOrSubtractExpressionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:3431:2: rule__AddOrSubtractExpressionRule__Group__0__Impl rule__AddOrSubtractExpressionRule__Group__1
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
    // InternalDataDescriptionLanguage.g:3438:1: rule__AddOrSubtractExpressionRule__Group__0__Impl : ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__AddOrSubtractExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3442:1: ( ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:3443:1: ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:3443:1: ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:3444:2: ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getLeftOperandAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:3445:2: ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 )
            // InternalDataDescriptionLanguage.g:3445:3: rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0
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
    // InternalDataDescriptionLanguage.g:3453:1: rule__AddOrSubtractExpressionRule__Group__1 : rule__AddOrSubtractExpressionRule__Group__1__Impl ;
    public final void rule__AddOrSubtractExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3457:1: ( rule__AddOrSubtractExpressionRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:3458:2: rule__AddOrSubtractExpressionRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:3464:1: rule__AddOrSubtractExpressionRule__Group__1__Impl : ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* ) ;
    public final void rule__AddOrSubtractExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3468:1: ( ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* ) )
            // InternalDataDescriptionLanguage.g:3469:1: ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* )
            {
            // InternalDataDescriptionLanguage.g:3469:1: ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* )
            // InternalDataDescriptionLanguage.g:3470:2: ( rule__AddOrSubtractExpressionRule__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getGroup_1()); 
            }
            // InternalDataDescriptionLanguage.g:3471:2: ( rule__AddOrSubtractExpressionRule__Group_1__0 )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( ((LA34_0>=27 && LA34_0<=28)) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:3471:3: rule__AddOrSubtractExpressionRule__Group_1__0
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
    // InternalDataDescriptionLanguage.g:3480:1: rule__AddOrSubtractExpressionRule__Group_1__0 : rule__AddOrSubtractExpressionRule__Group_1__0__Impl rule__AddOrSubtractExpressionRule__Group_1__1 ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3484:1: ( rule__AddOrSubtractExpressionRule__Group_1__0__Impl rule__AddOrSubtractExpressionRule__Group_1__1 )
            // InternalDataDescriptionLanguage.g:3485:2: rule__AddOrSubtractExpressionRule__Group_1__0__Impl rule__AddOrSubtractExpressionRule__Group_1__1
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
    // InternalDataDescriptionLanguage.g:3492:1: rule__AddOrSubtractExpressionRule__Group_1__0__Impl : ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) ) ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3496:1: ( ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) ) )
            // InternalDataDescriptionLanguage.g:3497:1: ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) )
            {
            // InternalDataDescriptionLanguage.g:3497:1: ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) )
            // InternalDataDescriptionLanguage.g:3498:2: ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperatorsAssignment_1_0()); 
            }
            // InternalDataDescriptionLanguage.g:3499:2: ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 )
            // InternalDataDescriptionLanguage.g:3499:3: rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0
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
    // InternalDataDescriptionLanguage.g:3507:1: rule__AddOrSubtractExpressionRule__Group_1__1 : rule__AddOrSubtractExpressionRule__Group_1__1__Impl ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3511:1: ( rule__AddOrSubtractExpressionRule__Group_1__1__Impl )
            // InternalDataDescriptionLanguage.g:3512:2: rule__AddOrSubtractExpressionRule__Group_1__1__Impl
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
    // InternalDataDescriptionLanguage.g:3518:1: rule__AddOrSubtractExpressionRule__Group_1__1__Impl : ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) ) ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3522:1: ( ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) ) )
            // InternalDataDescriptionLanguage.g:3523:1: ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) )
            {
            // InternalDataDescriptionLanguage.g:3523:1: ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) )
            // InternalDataDescriptionLanguage.g:3524:2: ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperandsAssignment_1_1()); 
            }
            // InternalDataDescriptionLanguage.g:3525:2: ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 )
            // InternalDataDescriptionLanguage.g:3525:3: rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1
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
    // InternalDataDescriptionLanguage.g:3534:1: rule__MultiplyDivideModuloExpressionRule__Group__0 : rule__MultiplyDivideModuloExpressionRule__Group__0__Impl rule__MultiplyDivideModuloExpressionRule__Group__1 ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3538:1: ( rule__MultiplyDivideModuloExpressionRule__Group__0__Impl rule__MultiplyDivideModuloExpressionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:3539:2: rule__MultiplyDivideModuloExpressionRule__Group__0__Impl rule__MultiplyDivideModuloExpressionRule__Group__1
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
    // InternalDataDescriptionLanguage.g:3546:1: rule__MultiplyDivideModuloExpressionRule__Group__0__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3550:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:3551:1: ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:3551:1: ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:3552:2: ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getLeftOperandAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:3553:2: ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 )
            // InternalDataDescriptionLanguage.g:3553:3: rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0
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
    // InternalDataDescriptionLanguage.g:3561:1: rule__MultiplyDivideModuloExpressionRule__Group__1 : rule__MultiplyDivideModuloExpressionRule__Group__1__Impl ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3565:1: ( rule__MultiplyDivideModuloExpressionRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:3566:2: rule__MultiplyDivideModuloExpressionRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:3572:1: rule__MultiplyDivideModuloExpressionRule__Group__1__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3576:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* ) )
            // InternalDataDescriptionLanguage.g:3577:1: ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* )
            {
            // InternalDataDescriptionLanguage.g:3577:1: ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* )
            // InternalDataDescriptionLanguage.g:3578:2: ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getGroup_1()); 
            }
            // InternalDataDescriptionLanguage.g:3579:2: ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( ((LA35_0>=29 && LA35_0<=31)) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:3579:3: rule__MultiplyDivideModuloExpressionRule__Group_1__0
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
    // InternalDataDescriptionLanguage.g:3588:1: rule__MultiplyDivideModuloExpressionRule__Group_1__0 : rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl rule__MultiplyDivideModuloExpressionRule__Group_1__1 ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3592:1: ( rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl rule__MultiplyDivideModuloExpressionRule__Group_1__1 )
            // InternalDataDescriptionLanguage.g:3593:2: rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl rule__MultiplyDivideModuloExpressionRule__Group_1__1
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
    // InternalDataDescriptionLanguage.g:3600:1: rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3604:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) ) )
            // InternalDataDescriptionLanguage.g:3605:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) )
            {
            // InternalDataDescriptionLanguage.g:3605:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) )
            // InternalDataDescriptionLanguage.g:3606:2: ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperatorsAssignment_1_0()); 
            }
            // InternalDataDescriptionLanguage.g:3607:2: ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 )
            // InternalDataDescriptionLanguage.g:3607:3: rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0
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
    // InternalDataDescriptionLanguage.g:3615:1: rule__MultiplyDivideModuloExpressionRule__Group_1__1 : rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3619:1: ( rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl )
            // InternalDataDescriptionLanguage.g:3620:2: rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl
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
    // InternalDataDescriptionLanguage.g:3626:1: rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3630:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) ) )
            // InternalDataDescriptionLanguage.g:3631:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) )
            {
            // InternalDataDescriptionLanguage.g:3631:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) )
            // InternalDataDescriptionLanguage.g:3632:2: ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperandsAssignment_1_1()); 
            }
            // InternalDataDescriptionLanguage.g:3633:2: ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 )
            // InternalDataDescriptionLanguage.g:3633:3: rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1
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
    // InternalDataDescriptionLanguage.g:3642:1: rule__PowerOfExpressionRule__Group__0 : rule__PowerOfExpressionRule__Group__0__Impl rule__PowerOfExpressionRule__Group__1 ;
    public final void rule__PowerOfExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3646:1: ( rule__PowerOfExpressionRule__Group__0__Impl rule__PowerOfExpressionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:3647:2: rule__PowerOfExpressionRule__Group__0__Impl rule__PowerOfExpressionRule__Group__1
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
    // InternalDataDescriptionLanguage.g:3654:1: rule__PowerOfExpressionRule__Group__0__Impl : ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__PowerOfExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3658:1: ( ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:3659:1: ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:3659:1: ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:3660:2: ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPowerOfExpressionRuleAccess().getLeftOperandAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:3661:2: ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 )
            // InternalDataDescriptionLanguage.g:3661:3: rule__PowerOfExpressionRule__LeftOperandAssignment_0
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
    // InternalDataDescriptionLanguage.g:3669:1: rule__PowerOfExpressionRule__Group__1 : rule__PowerOfExpressionRule__Group__1__Impl ;
    public final void rule__PowerOfExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3673:1: ( rule__PowerOfExpressionRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:3674:2: rule__PowerOfExpressionRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:3680:1: rule__PowerOfExpressionRule__Group__1__Impl : ( ( rule__PowerOfExpressionRule__Group_1__0 )? ) ;
    public final void rule__PowerOfExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3684:1: ( ( ( rule__PowerOfExpressionRule__Group_1__0 )? ) )
            // InternalDataDescriptionLanguage.g:3685:1: ( ( rule__PowerOfExpressionRule__Group_1__0 )? )
            {
            // InternalDataDescriptionLanguage.g:3685:1: ( ( rule__PowerOfExpressionRule__Group_1__0 )? )
            // InternalDataDescriptionLanguage.g:3686:2: ( rule__PowerOfExpressionRule__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPowerOfExpressionRuleAccess().getGroup_1()); 
            }
            // InternalDataDescriptionLanguage.g:3687:2: ( rule__PowerOfExpressionRule__Group_1__0 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==66) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:3687:3: rule__PowerOfExpressionRule__Group_1__0
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
    // InternalDataDescriptionLanguage.g:3696:1: rule__PowerOfExpressionRule__Group_1__0 : rule__PowerOfExpressionRule__Group_1__0__Impl rule__PowerOfExpressionRule__Group_1__1 ;
    public final void rule__PowerOfExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3700:1: ( rule__PowerOfExpressionRule__Group_1__0__Impl rule__PowerOfExpressionRule__Group_1__1 )
            // InternalDataDescriptionLanguage.g:3701:2: rule__PowerOfExpressionRule__Group_1__0__Impl rule__PowerOfExpressionRule__Group_1__1
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
    // InternalDataDescriptionLanguage.g:3708:1: rule__PowerOfExpressionRule__Group_1__0__Impl : ( '^' ) ;
    public final void rule__PowerOfExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3712:1: ( ( '^' ) )
            // InternalDataDescriptionLanguage.g:3713:1: ( '^' )
            {
            // InternalDataDescriptionLanguage.g:3713:1: ( '^' )
            // InternalDataDescriptionLanguage.g:3714:2: '^'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPowerOfExpressionRuleAccess().getCircumflexAccentKeyword_1_0()); 
            }
            match(input,66,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:3723:1: rule__PowerOfExpressionRule__Group_1__1 : rule__PowerOfExpressionRule__Group_1__1__Impl ;
    public final void rule__PowerOfExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3727:1: ( rule__PowerOfExpressionRule__Group_1__1__Impl )
            // InternalDataDescriptionLanguage.g:3728:2: rule__PowerOfExpressionRule__Group_1__1__Impl
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
    // InternalDataDescriptionLanguage.g:3734:1: rule__PowerOfExpressionRule__Group_1__1__Impl : ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) ) ;
    public final void rule__PowerOfExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3738:1: ( ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) ) )
            // InternalDataDescriptionLanguage.g:3739:1: ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) )
            {
            // InternalDataDescriptionLanguage.g:3739:1: ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) )
            // InternalDataDescriptionLanguage.g:3740:2: ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPowerOfExpressionRuleAccess().getRightOperandAssignment_1_1()); 
            }
            // InternalDataDescriptionLanguage.g:3741:2: ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 )
            // InternalDataDescriptionLanguage.g:3741:3: rule__PowerOfExpressionRule__RightOperandAssignment_1_1
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
    // InternalDataDescriptionLanguage.g:3750:1: rule__UnaryAddOrSubtractExpressionRule__Group__0 : rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl rule__UnaryAddOrSubtractExpressionRule__Group__1 ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3754:1: ( rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl rule__UnaryAddOrSubtractExpressionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:3755:2: rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl rule__UnaryAddOrSubtractExpressionRule__Group__1
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
    // InternalDataDescriptionLanguage.g:3762:1: rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl : ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3766:1: ( ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* ) )
            // InternalDataDescriptionLanguage.g:3767:1: ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* )
            {
            // InternalDataDescriptionLanguage.g:3767:1: ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* )
            // InternalDataDescriptionLanguage.g:3768:2: ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getOperatorsAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:3769:2: ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( ((LA37_0>=27 && LA37_0<=28)) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:3769:3: rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0
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
    // InternalDataDescriptionLanguage.g:3777:1: rule__UnaryAddOrSubtractExpressionRule__Group__1 : rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3781:1: ( rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:3782:2: rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:3788:1: rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl : ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3792:1: ( ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) ) )
            // InternalDataDescriptionLanguage.g:3793:1: ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) )
            {
            // InternalDataDescriptionLanguage.g:3793:1: ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) )
            // InternalDataDescriptionLanguage.g:3794:2: ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getSubExpressionAssignment_1()); 
            }
            // InternalDataDescriptionLanguage.g:3795:2: ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 )
            // InternalDataDescriptionLanguage.g:3795:3: rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1
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
    // InternalDataDescriptionLanguage.g:3804:1: rule__ParanthesesRule__Group__0 : rule__ParanthesesRule__Group__0__Impl rule__ParanthesesRule__Group__1 ;
    public final void rule__ParanthesesRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3808:1: ( rule__ParanthesesRule__Group__0__Impl rule__ParanthesesRule__Group__1 )
            // InternalDataDescriptionLanguage.g:3809:2: rule__ParanthesesRule__Group__0__Impl rule__ParanthesesRule__Group__1
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
    // InternalDataDescriptionLanguage.g:3816:1: rule__ParanthesesRule__Group__0__Impl : ( '(' ) ;
    public final void rule__ParanthesesRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3820:1: ( ( '(' ) )
            // InternalDataDescriptionLanguage.g:3821:1: ( '(' )
            {
            // InternalDataDescriptionLanguage.g:3821:1: ( '(' )
            // InternalDataDescriptionLanguage.g:3822:2: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParanthesesRuleAccess().getLeftParenthesisKeyword_0()); 
            }
            match(input,67,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:3831:1: rule__ParanthesesRule__Group__1 : rule__ParanthesesRule__Group__1__Impl rule__ParanthesesRule__Group__2 ;
    public final void rule__ParanthesesRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3835:1: ( rule__ParanthesesRule__Group__1__Impl rule__ParanthesesRule__Group__2 )
            // InternalDataDescriptionLanguage.g:3836:2: rule__ParanthesesRule__Group__1__Impl rule__ParanthesesRule__Group__2
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
    // InternalDataDescriptionLanguage.g:3843:1: rule__ParanthesesRule__Group__1__Impl : ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) ) ;
    public final void rule__ParanthesesRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3847:1: ( ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) ) )
            // InternalDataDescriptionLanguage.g:3848:1: ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) )
            {
            // InternalDataDescriptionLanguage.g:3848:1: ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) )
            // InternalDataDescriptionLanguage.g:3849:2: ( rule__ParanthesesRule__SubExpressionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParanthesesRuleAccess().getSubExpressionAssignment_1()); 
            }
            // InternalDataDescriptionLanguage.g:3850:2: ( rule__ParanthesesRule__SubExpressionAssignment_1 )
            // InternalDataDescriptionLanguage.g:3850:3: rule__ParanthesesRule__SubExpressionAssignment_1
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
    // InternalDataDescriptionLanguage.g:3858:1: rule__ParanthesesRule__Group__2 : rule__ParanthesesRule__Group__2__Impl ;
    public final void rule__ParanthesesRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3862:1: ( rule__ParanthesesRule__Group__2__Impl )
            // InternalDataDescriptionLanguage.g:3863:2: rule__ParanthesesRule__Group__2__Impl
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
    // InternalDataDescriptionLanguage.g:3869:1: rule__ParanthesesRule__Group__2__Impl : ( ')' ) ;
    public final void rule__ParanthesesRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3873:1: ( ( ')' ) )
            // InternalDataDescriptionLanguage.g:3874:1: ( ')' )
            {
            // InternalDataDescriptionLanguage.g:3874:1: ( ')' )
            // InternalDataDescriptionLanguage.g:3875:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParanthesesRuleAccess().getRightParenthesisKeyword_2()); 
            }
            match(input,68,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:3885:1: rule__CallRule__Group__0 : rule__CallRule__Group__0__Impl rule__CallRule__Group__1 ;
    public final void rule__CallRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3889:1: ( rule__CallRule__Group__0__Impl rule__CallRule__Group__1 )
            // InternalDataDescriptionLanguage.g:3890:2: rule__CallRule__Group__0__Impl rule__CallRule__Group__1
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
    // InternalDataDescriptionLanguage.g:3897:1: rule__CallRule__Group__0__Impl : ( ( rule__CallRule__FunctionAssignment_0 ) ) ;
    public final void rule__CallRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3901:1: ( ( ( rule__CallRule__FunctionAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:3902:1: ( ( rule__CallRule__FunctionAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:3902:1: ( ( rule__CallRule__FunctionAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:3903:2: ( rule__CallRule__FunctionAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getFunctionAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:3904:2: ( rule__CallRule__FunctionAssignment_0 )
            // InternalDataDescriptionLanguage.g:3904:3: rule__CallRule__FunctionAssignment_0
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
    // InternalDataDescriptionLanguage.g:3912:1: rule__CallRule__Group__1 : rule__CallRule__Group__1__Impl rule__CallRule__Group__2 ;
    public final void rule__CallRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3916:1: ( rule__CallRule__Group__1__Impl rule__CallRule__Group__2 )
            // InternalDataDescriptionLanguage.g:3917:2: rule__CallRule__Group__1__Impl rule__CallRule__Group__2
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
    // InternalDataDescriptionLanguage.g:3924:1: rule__CallRule__Group__1__Impl : ( '(' ) ;
    public final void rule__CallRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3928:1: ( ( '(' ) )
            // InternalDataDescriptionLanguage.g:3929:1: ( '(' )
            {
            // InternalDataDescriptionLanguage.g:3929:1: ( '(' )
            // InternalDataDescriptionLanguage.g:3930:2: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getLeftParenthesisKeyword_1()); 
            }
            match(input,67,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:3939:1: rule__CallRule__Group__2 : rule__CallRule__Group__2__Impl rule__CallRule__Group__3 ;
    public final void rule__CallRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3943:1: ( rule__CallRule__Group__2__Impl rule__CallRule__Group__3 )
            // InternalDataDescriptionLanguage.g:3944:2: rule__CallRule__Group__2__Impl rule__CallRule__Group__3
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
    // InternalDataDescriptionLanguage.g:3951:1: rule__CallRule__Group__2__Impl : ( ( rule__CallRule__Group_2__0 )? ) ;
    public final void rule__CallRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3955:1: ( ( ( rule__CallRule__Group_2__0 )? ) )
            // InternalDataDescriptionLanguage.g:3956:1: ( ( rule__CallRule__Group_2__0 )? )
            {
            // InternalDataDescriptionLanguage.g:3956:1: ( ( rule__CallRule__Group_2__0 )? )
            // InternalDataDescriptionLanguage.g:3957:2: ( rule__CallRule__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getGroup_2()); 
            }
            // InternalDataDescriptionLanguage.g:3958:2: ( rule__CallRule__Group_2__0 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( ((LA38_0>=RULE_QUOTED_ID && LA38_0<=RULE_STRING)||LA38_0==12||(LA38_0>=27 && LA38_0<=28)||LA38_0==62||LA38_0==67||(LA38_0>=71 && LA38_0<=72)) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:3958:3: rule__CallRule__Group_2__0
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
    // InternalDataDescriptionLanguage.g:3966:1: rule__CallRule__Group__3 : rule__CallRule__Group__3__Impl ;
    public final void rule__CallRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3970:1: ( rule__CallRule__Group__3__Impl )
            // InternalDataDescriptionLanguage.g:3971:2: rule__CallRule__Group__3__Impl
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
    // InternalDataDescriptionLanguage.g:3977:1: rule__CallRule__Group__3__Impl : ( ')' ) ;
    public final void rule__CallRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3981:1: ( ( ')' ) )
            // InternalDataDescriptionLanguage.g:3982:1: ( ')' )
            {
            // InternalDataDescriptionLanguage.g:3982:1: ( ')' )
            // InternalDataDescriptionLanguage.g:3983:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getRightParenthesisKeyword_3()); 
            }
            match(input,68,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:3993:1: rule__CallRule__Group_2__0 : rule__CallRule__Group_2__0__Impl rule__CallRule__Group_2__1 ;
    public final void rule__CallRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3997:1: ( rule__CallRule__Group_2__0__Impl rule__CallRule__Group_2__1 )
            // InternalDataDescriptionLanguage.g:3998:2: rule__CallRule__Group_2__0__Impl rule__CallRule__Group_2__1
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
    // InternalDataDescriptionLanguage.g:4005:1: rule__CallRule__Group_2__0__Impl : ( ( rule__CallRule__ParametersAssignment_2_0 ) ) ;
    public final void rule__CallRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4009:1: ( ( ( rule__CallRule__ParametersAssignment_2_0 ) ) )
            // InternalDataDescriptionLanguage.g:4010:1: ( ( rule__CallRule__ParametersAssignment_2_0 ) )
            {
            // InternalDataDescriptionLanguage.g:4010:1: ( ( rule__CallRule__ParametersAssignment_2_0 ) )
            // InternalDataDescriptionLanguage.g:4011:2: ( rule__CallRule__ParametersAssignment_2_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getParametersAssignment_2_0()); 
            }
            // InternalDataDescriptionLanguage.g:4012:2: ( rule__CallRule__ParametersAssignment_2_0 )
            // InternalDataDescriptionLanguage.g:4012:3: rule__CallRule__ParametersAssignment_2_0
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
    // InternalDataDescriptionLanguage.g:4020:1: rule__CallRule__Group_2__1 : rule__CallRule__Group_2__1__Impl ;
    public final void rule__CallRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4024:1: ( rule__CallRule__Group_2__1__Impl )
            // InternalDataDescriptionLanguage.g:4025:2: rule__CallRule__Group_2__1__Impl
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
    // InternalDataDescriptionLanguage.g:4031:1: rule__CallRule__Group_2__1__Impl : ( ( rule__CallRule__Group_2_1__0 )* ) ;
    public final void rule__CallRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4035:1: ( ( ( rule__CallRule__Group_2_1__0 )* ) )
            // InternalDataDescriptionLanguage.g:4036:1: ( ( rule__CallRule__Group_2_1__0 )* )
            {
            // InternalDataDescriptionLanguage.g:4036:1: ( ( rule__CallRule__Group_2_1__0 )* )
            // InternalDataDescriptionLanguage.g:4037:2: ( rule__CallRule__Group_2_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getGroup_2_1()); 
            }
            // InternalDataDescriptionLanguage.g:4038:2: ( rule__CallRule__Group_2_1__0 )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==69) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:4038:3: rule__CallRule__Group_2_1__0
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
    // InternalDataDescriptionLanguage.g:4047:1: rule__CallRule__Group_2_1__0 : rule__CallRule__Group_2_1__0__Impl rule__CallRule__Group_2_1__1 ;
    public final void rule__CallRule__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4051:1: ( rule__CallRule__Group_2_1__0__Impl rule__CallRule__Group_2_1__1 )
            // InternalDataDescriptionLanguage.g:4052:2: rule__CallRule__Group_2_1__0__Impl rule__CallRule__Group_2_1__1
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
    // InternalDataDescriptionLanguage.g:4059:1: rule__CallRule__Group_2_1__0__Impl : ( ',' ) ;
    public final void rule__CallRule__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4063:1: ( ( ',' ) )
            // InternalDataDescriptionLanguage.g:4064:1: ( ',' )
            {
            // InternalDataDescriptionLanguage.g:4064:1: ( ',' )
            // InternalDataDescriptionLanguage.g:4065:2: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getCommaKeyword_2_1_0()); 
            }
            match(input,69,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:4074:1: rule__CallRule__Group_2_1__1 : rule__CallRule__Group_2_1__1__Impl ;
    public final void rule__CallRule__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4078:1: ( rule__CallRule__Group_2_1__1__Impl )
            // InternalDataDescriptionLanguage.g:4079:2: rule__CallRule__Group_2_1__1__Impl
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
    // InternalDataDescriptionLanguage.g:4085:1: rule__CallRule__Group_2_1__1__Impl : ( ( rule__CallRule__ParametersAssignment_2_1_1 ) ) ;
    public final void rule__CallRule__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4089:1: ( ( ( rule__CallRule__ParametersAssignment_2_1_1 ) ) )
            // InternalDataDescriptionLanguage.g:4090:1: ( ( rule__CallRule__ParametersAssignment_2_1_1 ) )
            {
            // InternalDataDescriptionLanguage.g:4090:1: ( ( rule__CallRule__ParametersAssignment_2_1_1 ) )
            // InternalDataDescriptionLanguage.g:4091:2: ( rule__CallRule__ParametersAssignment_2_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getParametersAssignment_2_1_1()); 
            }
            // InternalDataDescriptionLanguage.g:4092:2: ( rule__CallRule__ParametersAssignment_2_1_1 )
            // InternalDataDescriptionLanguage.g:4092:3: rule__CallRule__ParametersAssignment_2_1_1
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
    // InternalDataDescriptionLanguage.g:4101:1: rule__DoubleLiteralRule__Group__0 : rule__DoubleLiteralRule__Group__0__Impl rule__DoubleLiteralRule__Group__1 ;
    public final void rule__DoubleLiteralRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4105:1: ( rule__DoubleLiteralRule__Group__0__Impl rule__DoubleLiteralRule__Group__1 )
            // InternalDataDescriptionLanguage.g:4106:2: rule__DoubleLiteralRule__Group__0__Impl rule__DoubleLiteralRule__Group__1
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
    // InternalDataDescriptionLanguage.g:4113:1: rule__DoubleLiteralRule__Group__0__Impl : ( ( rule__DoubleLiteralRule__LiteralAssignment_0 ) ) ;
    public final void rule__DoubleLiteralRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4117:1: ( ( ( rule__DoubleLiteralRule__LiteralAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:4118:1: ( ( rule__DoubleLiteralRule__LiteralAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:4118:1: ( ( rule__DoubleLiteralRule__LiteralAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:4119:2: ( rule__DoubleLiteralRule__LiteralAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDoubleLiteralRuleAccess().getLiteralAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:4120:2: ( rule__DoubleLiteralRule__LiteralAssignment_0 )
            // InternalDataDescriptionLanguage.g:4120:3: rule__DoubleLiteralRule__LiteralAssignment_0
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
    // InternalDataDescriptionLanguage.g:4128:1: rule__DoubleLiteralRule__Group__1 : rule__DoubleLiteralRule__Group__1__Impl ;
    public final void rule__DoubleLiteralRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4132:1: ( rule__DoubleLiteralRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:4133:2: rule__DoubleLiteralRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:4139:1: rule__DoubleLiteralRule__Group__1__Impl : ( ( rule__DoubleLiteralRule__FactorAssignment_1 ) ) ;
    public final void rule__DoubleLiteralRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4143:1: ( ( ( rule__DoubleLiteralRule__FactorAssignment_1 ) ) )
            // InternalDataDescriptionLanguage.g:4144:1: ( ( rule__DoubleLiteralRule__FactorAssignment_1 ) )
            {
            // InternalDataDescriptionLanguage.g:4144:1: ( ( rule__DoubleLiteralRule__FactorAssignment_1 ) )
            // InternalDataDescriptionLanguage.g:4145:2: ( rule__DoubleLiteralRule__FactorAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDoubleLiteralRuleAccess().getFactorAssignment_1()); 
            }
            // InternalDataDescriptionLanguage.g:4146:2: ( rule__DoubleLiteralRule__FactorAssignment_1 )
            // InternalDataDescriptionLanguage.g:4146:3: rule__DoubleLiteralRule__FactorAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__DoubleLiteralRule__FactorAssignment_1();

            state._fsp--;
            if (state.failed) return ;

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
    // InternalDataDescriptionLanguage.g:4155:1: rule__IntegerLiteralRule__Group__0 : rule__IntegerLiteralRule__Group__0__Impl rule__IntegerLiteralRule__Group__1 ;
    public final void rule__IntegerLiteralRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4159:1: ( rule__IntegerLiteralRule__Group__0__Impl rule__IntegerLiteralRule__Group__1 )
            // InternalDataDescriptionLanguage.g:4160:2: rule__IntegerLiteralRule__Group__0__Impl rule__IntegerLiteralRule__Group__1
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
    // InternalDataDescriptionLanguage.g:4167:1: rule__IntegerLiteralRule__Group__0__Impl : ( ( rule__IntegerLiteralRule__LiteralAssignment_0 ) ) ;
    public final void rule__IntegerLiteralRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4171:1: ( ( ( rule__IntegerLiteralRule__LiteralAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:4172:1: ( ( rule__IntegerLiteralRule__LiteralAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:4172:1: ( ( rule__IntegerLiteralRule__LiteralAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:4173:2: ( rule__IntegerLiteralRule__LiteralAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegerLiteralRuleAccess().getLiteralAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:4174:2: ( rule__IntegerLiteralRule__LiteralAssignment_0 )
            // InternalDataDescriptionLanguage.g:4174:3: rule__IntegerLiteralRule__LiteralAssignment_0
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
    // InternalDataDescriptionLanguage.g:4182:1: rule__IntegerLiteralRule__Group__1 : rule__IntegerLiteralRule__Group__1__Impl ;
    public final void rule__IntegerLiteralRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4186:1: ( rule__IntegerLiteralRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:4187:2: rule__IntegerLiteralRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:4193:1: rule__IntegerLiteralRule__Group__1__Impl : ( ( rule__IntegerLiteralRule__FactorAssignment_1 ) ) ;
    public final void rule__IntegerLiteralRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4197:1: ( ( ( rule__IntegerLiteralRule__FactorAssignment_1 ) ) )
            // InternalDataDescriptionLanguage.g:4198:1: ( ( rule__IntegerLiteralRule__FactorAssignment_1 ) )
            {
            // InternalDataDescriptionLanguage.g:4198:1: ( ( rule__IntegerLiteralRule__FactorAssignment_1 ) )
            // InternalDataDescriptionLanguage.g:4199:2: ( rule__IntegerLiteralRule__FactorAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegerLiteralRuleAccess().getFactorAssignment_1()); 
            }
            // InternalDataDescriptionLanguage.g:4200:2: ( rule__IntegerLiteralRule__FactorAssignment_1 )
            // InternalDataDescriptionLanguage.g:4200:3: rule__IntegerLiteralRule__FactorAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__IntegerLiteralRule__FactorAssignment_1();

            state._fsp--;
            if (state.failed) return ;

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
    // InternalDataDescriptionLanguage.g:4209:1: rule__BooleanLiteralRule__Group__0 : rule__BooleanLiteralRule__Group__0__Impl rule__BooleanLiteralRule__Group__1 ;
    public final void rule__BooleanLiteralRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4213:1: ( rule__BooleanLiteralRule__Group__0__Impl rule__BooleanLiteralRule__Group__1 )
            // InternalDataDescriptionLanguage.g:4214:2: rule__BooleanLiteralRule__Group__0__Impl rule__BooleanLiteralRule__Group__1
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
    // InternalDataDescriptionLanguage.g:4221:1: rule__BooleanLiteralRule__Group__0__Impl : ( () ) ;
    public final void rule__BooleanLiteralRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4225:1: ( ( () ) )
            // InternalDataDescriptionLanguage.g:4226:1: ( () )
            {
            // InternalDataDescriptionLanguage.g:4226:1: ( () )
            // InternalDataDescriptionLanguage.g:4227:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralRuleAccess().getBooleanLiteralAction_0()); 
            }
            // InternalDataDescriptionLanguage.g:4228:2: ()
            // InternalDataDescriptionLanguage.g:4228:3: 
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
    // InternalDataDescriptionLanguage.g:4236:1: rule__BooleanLiteralRule__Group__1 : rule__BooleanLiteralRule__Group__1__Impl ;
    public final void rule__BooleanLiteralRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4240:1: ( rule__BooleanLiteralRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:4241:2: rule__BooleanLiteralRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:4247:1: rule__BooleanLiteralRule__Group__1__Impl : ( ( rule__BooleanLiteralRule__Alternatives_1 ) ) ;
    public final void rule__BooleanLiteralRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4251:1: ( ( ( rule__BooleanLiteralRule__Alternatives_1 ) ) )
            // InternalDataDescriptionLanguage.g:4252:1: ( ( rule__BooleanLiteralRule__Alternatives_1 ) )
            {
            // InternalDataDescriptionLanguage.g:4252:1: ( ( rule__BooleanLiteralRule__Alternatives_1 ) )
            // InternalDataDescriptionLanguage.g:4253:2: ( rule__BooleanLiteralRule__Alternatives_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralRuleAccess().getAlternatives_1()); 
            }
            // InternalDataDescriptionLanguage.g:4254:2: ( rule__BooleanLiteralRule__Alternatives_1 )
            // InternalDataDescriptionLanguage.g:4254:3: rule__BooleanLiteralRule__Alternatives_1
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


    // $ANTLR start "rule__DOUBLE__Group__0"
    // InternalDataDescriptionLanguage.g:4263:1: rule__DOUBLE__Group__0 : rule__DOUBLE__Group__0__Impl rule__DOUBLE__Group__1 ;
    public final void rule__DOUBLE__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4267:1: ( rule__DOUBLE__Group__0__Impl rule__DOUBLE__Group__1 )
            // InternalDataDescriptionLanguage.g:4268:2: rule__DOUBLE__Group__0__Impl rule__DOUBLE__Group__1
            {
            pushFollow(FOLLOW_41);
            rule__DOUBLE__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__DOUBLE__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DOUBLE__Group__0"


    // $ANTLR start "rule__DOUBLE__Group__0__Impl"
    // InternalDataDescriptionLanguage.g:4275:1: rule__DOUBLE__Group__0__Impl : ( RULE_INT ) ;
    public final void rule__DOUBLE__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4279:1: ( ( RULE_INT ) )
            // InternalDataDescriptionLanguage.g:4280:1: ( RULE_INT )
            {
            // InternalDataDescriptionLanguage.g:4280:1: ( RULE_INT )
            // InternalDataDescriptionLanguage.g:4281:2: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDOUBLEAccess().getINTTerminalRuleCall_0()); 
            }
            match(input,RULE_INT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDOUBLEAccess().getINTTerminalRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DOUBLE__Group__0__Impl"


    // $ANTLR start "rule__DOUBLE__Group__1"
    // InternalDataDescriptionLanguage.g:4290:1: rule__DOUBLE__Group__1 : rule__DOUBLE__Group__1__Impl rule__DOUBLE__Group__2 ;
    public final void rule__DOUBLE__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4294:1: ( rule__DOUBLE__Group__1__Impl rule__DOUBLE__Group__2 )
            // InternalDataDescriptionLanguage.g:4295:2: rule__DOUBLE__Group__1__Impl rule__DOUBLE__Group__2
            {
            pushFollow(FOLLOW_42);
            rule__DOUBLE__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__DOUBLE__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DOUBLE__Group__1"


    // $ANTLR start "rule__DOUBLE__Group__1__Impl"
    // InternalDataDescriptionLanguage.g:4302:1: rule__DOUBLE__Group__1__Impl : ( '.' ) ;
    public final void rule__DOUBLE__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4306:1: ( ( '.' ) )
            // InternalDataDescriptionLanguage.g:4307:1: ( '.' )
            {
            // InternalDataDescriptionLanguage.g:4307:1: ( '.' )
            // InternalDataDescriptionLanguage.g:4308:2: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDOUBLEAccess().getFullStopKeyword_1()); 
            }
            match(input,70,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDOUBLEAccess().getFullStopKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DOUBLE__Group__1__Impl"


    // $ANTLR start "rule__DOUBLE__Group__2"
    // InternalDataDescriptionLanguage.g:4317:1: rule__DOUBLE__Group__2 : rule__DOUBLE__Group__2__Impl ;
    public final void rule__DOUBLE__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4321:1: ( rule__DOUBLE__Group__2__Impl )
            // InternalDataDescriptionLanguage.g:4322:2: rule__DOUBLE__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DOUBLE__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DOUBLE__Group__2"


    // $ANTLR start "rule__DOUBLE__Group__2__Impl"
    // InternalDataDescriptionLanguage.g:4328:1: rule__DOUBLE__Group__2__Impl : ( RULE_INT ) ;
    public final void rule__DOUBLE__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4332:1: ( ( RULE_INT ) )
            // InternalDataDescriptionLanguage.g:4333:1: ( RULE_INT )
            {
            // InternalDataDescriptionLanguage.g:4333:1: ( RULE_INT )
            // InternalDataDescriptionLanguage.g:4334:2: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDOUBLEAccess().getINTTerminalRuleCall_2()); 
            }
            match(input,RULE_INT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDOUBLEAccess().getINTTerminalRuleCall_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DOUBLE__Group__2__Impl"


    // $ANTLR start "rule__DataDescriptionModelRule__UsesAssignment_1"
    // InternalDataDescriptionLanguage.g:4344:1: rule__DataDescriptionModelRule__UsesAssignment_1 : ( ruleUseRule ) ;
    public final void rule__DataDescriptionModelRule__UsesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4348:1: ( ( ruleUseRule ) )
            // InternalDataDescriptionLanguage.g:4349:2: ( ruleUseRule )
            {
            // InternalDataDescriptionLanguage.g:4349:2: ( ruleUseRule )
            // InternalDataDescriptionLanguage.g:4350:3: ruleUseRule
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
    // InternalDataDescriptionLanguage.g:4359:1: rule__DataDescriptionModelRule__TypesAssignment_2_2 : ( ruleDataTypeRule ) ;
    public final void rule__DataDescriptionModelRule__TypesAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4363:1: ( ( ruleDataTypeRule ) )
            // InternalDataDescriptionLanguage.g:4364:2: ( ruleDataTypeRule )
            {
            // InternalDataDescriptionLanguage.g:4364:2: ( ruleDataTypeRule )
            // InternalDataDescriptionLanguage.g:4365:3: ruleDataTypeRule
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
    // InternalDataDescriptionLanguage.g:4374:1: rule__DataDescriptionModelRule__DescriptionsAssignment_3_2 : ( ruleDataDescriptionRule ) ;
    public final void rule__DataDescriptionModelRule__DescriptionsAssignment_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4378:1: ( ( ruleDataDescriptionRule ) )
            // InternalDataDescriptionLanguage.g:4379:2: ( ruleDataDescriptionRule )
            {
            // InternalDataDescriptionLanguage.g:4379:2: ( ruleDataDescriptionRule )
            // InternalDataDescriptionLanguage.g:4380:3: ruleDataDescriptionRule
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
    // InternalDataDescriptionLanguage.g:4389:1: rule__DataDescriptionModelRule__ConstraintsAssignment_4_2 : ( ruleStatementRule ) ;
    public final void rule__DataDescriptionModelRule__ConstraintsAssignment_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4393:1: ( ( ruleStatementRule ) )
            // InternalDataDescriptionLanguage.g:4394:2: ( ruleStatementRule )
            {
            // InternalDataDescriptionLanguage.g:4394:2: ( ruleStatementRule )
            // InternalDataDescriptionLanguage.g:4395:3: ruleStatementRule
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
    // InternalDataDescriptionLanguage.g:4404:1: rule__UseRule__ImportURIAssignment_1 : ( RULE_STRING ) ;
    public final void rule__UseRule__ImportURIAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4408:1: ( ( RULE_STRING ) )
            // InternalDataDescriptionLanguage.g:4409:2: ( RULE_STRING )
            {
            // InternalDataDescriptionLanguage.g:4409:2: ( RULE_STRING )
            // InternalDataDescriptionLanguage.g:4410:3: RULE_STRING
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
    // InternalDataDescriptionLanguage.g:4419:1: rule__DataTypeRule__ScaleAssignment_0 : ( ruleScaleType ) ;
    public final void rule__DataTypeRule__ScaleAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4423:1: ( ( ruleScaleType ) )
            // InternalDataDescriptionLanguage.g:4424:2: ( ruleScaleType )
            {
            // InternalDataDescriptionLanguage.g:4424:2: ( ruleScaleType )
            // InternalDataDescriptionLanguage.g:4425:3: ruleScaleType
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
    // InternalDataDescriptionLanguage.g:4434:1: rule__DataTypeRule__NameAssignment_2 : ( ruleStringOrId ) ;
    public final void rule__DataTypeRule__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4438:1: ( ( ruleStringOrId ) )
            // InternalDataDescriptionLanguage.g:4439:2: ( ruleStringOrId )
            {
            // InternalDataDescriptionLanguage.g:4439:2: ( ruleStringOrId )
            // InternalDataDescriptionLanguage.g:4440:3: ruleStringOrId
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
    // InternalDataDescriptionLanguage.g:4449:1: rule__DataTypeRule__DescriptionAssignment_3_2 : ( RULE_STRING ) ;
    public final void rule__DataTypeRule__DescriptionAssignment_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4453:1: ( ( RULE_STRING ) )
            // InternalDataDescriptionLanguage.g:4454:2: ( RULE_STRING )
            {
            // InternalDataDescriptionLanguage.g:4454:2: ( RULE_STRING )
            // InternalDataDescriptionLanguage.g:4455:3: RULE_STRING
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
    // InternalDataDescriptionLanguage.g:4464:1: rule__DataTypeRule__ConstraintsAssignment_4_3 : ( ruleStatementRule ) ;
    public final void rule__DataTypeRule__ConstraintsAssignment_4_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4468:1: ( ( ruleStatementRule ) )
            // InternalDataDescriptionLanguage.g:4469:2: ( ruleStatementRule )
            {
            // InternalDataDescriptionLanguage.g:4469:2: ( ruleStatementRule )
            // InternalDataDescriptionLanguage.g:4470:3: ruleStatementRule
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
    // InternalDataDescriptionLanguage.g:4479:1: rule__TypedDataDescriptionRule__RepresentationAssignment_0 : ( ruleRepresentationType ) ;
    public final void rule__TypedDataDescriptionRule__RepresentationAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4483:1: ( ( ruleRepresentationType ) )
            // InternalDataDescriptionLanguage.g:4484:2: ( ruleRepresentationType )
            {
            // InternalDataDescriptionLanguage.g:4484:2: ( ruleRepresentationType )
            // InternalDataDescriptionLanguage.g:4485:3: ruleRepresentationType
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
    // InternalDataDescriptionLanguage.g:4494:1: rule__TypedDataDescriptionRule__NameAssignment_2 : ( ruleStringOrId ) ;
    public final void rule__TypedDataDescriptionRule__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4498:1: ( ( ruleStringOrId ) )
            // InternalDataDescriptionLanguage.g:4499:2: ( ruleStringOrId )
            {
            // InternalDataDescriptionLanguage.g:4499:2: ( ruleStringOrId )
            // InternalDataDescriptionLanguage.g:4500:3: ruleStringOrId
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
    // InternalDataDescriptionLanguage.g:4509:1: rule__TypedDataDescriptionRule__TypeAssignment_5 : ( ( ruleStringOrId ) ) ;
    public final void rule__TypedDataDescriptionRule__TypeAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4513:1: ( ( ( ruleStringOrId ) ) )
            // InternalDataDescriptionLanguage.g:4514:2: ( ( ruleStringOrId ) )
            {
            // InternalDataDescriptionLanguage.g:4514:2: ( ( ruleStringOrId ) )
            // InternalDataDescriptionLanguage.g:4515:3: ( ruleStringOrId )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedDataDescriptionRuleAccess().getTypeDataTypeCrossReference_5_0()); 
            }
            // InternalDataDescriptionLanguage.g:4516:3: ( ruleStringOrId )
            // InternalDataDescriptionLanguage.g:4517:4: ruleStringOrId
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
    // InternalDataDescriptionLanguage.g:4528:1: rule__TypedDataDescriptionRule__ConstraintsAssignment_6_3 : ( ruleStatementRule ) ;
    public final void rule__TypedDataDescriptionRule__ConstraintsAssignment_6_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4532:1: ( ( ruleStatementRule ) )
            // InternalDataDescriptionLanguage.g:4533:2: ( ruleStatementRule )
            {
            // InternalDataDescriptionLanguage.g:4533:2: ( ruleStatementRule )
            // InternalDataDescriptionLanguage.g:4534:3: ruleStatementRule
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
    // InternalDataDescriptionLanguage.g:4543:1: rule__UntypedDataDescriptionRule__ScaleAssignment_0 : ( ruleScaleType ) ;
    public final void rule__UntypedDataDescriptionRule__ScaleAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4547:1: ( ( ruleScaleType ) )
            // InternalDataDescriptionLanguage.g:4548:2: ( ruleScaleType )
            {
            // InternalDataDescriptionLanguage.g:4548:2: ( ruleScaleType )
            // InternalDataDescriptionLanguage.g:4549:3: ruleScaleType
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
    // InternalDataDescriptionLanguage.g:4558:1: rule__UntypedDataDescriptionRule__RepresentationAssignment_1 : ( ruleRepresentationType ) ;
    public final void rule__UntypedDataDescriptionRule__RepresentationAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4562:1: ( ( ruleRepresentationType ) )
            // InternalDataDescriptionLanguage.g:4563:2: ( ruleRepresentationType )
            {
            // InternalDataDescriptionLanguage.g:4563:2: ( ruleRepresentationType )
            // InternalDataDescriptionLanguage.g:4564:3: ruleRepresentationType
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
    // InternalDataDescriptionLanguage.g:4573:1: rule__UntypedDataDescriptionRule__NameAssignment_3 : ( ruleStringOrId ) ;
    public final void rule__UntypedDataDescriptionRule__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4577:1: ( ( ruleStringOrId ) )
            // InternalDataDescriptionLanguage.g:4578:2: ( ruleStringOrId )
            {
            // InternalDataDescriptionLanguage.g:4578:2: ( ruleStringOrId )
            // InternalDataDescriptionLanguage.g:4579:3: ruleStringOrId
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
    // InternalDataDescriptionLanguage.g:4588:1: rule__UntypedDataDescriptionRule__ConstraintsAssignment_4_3 : ( ruleStatementRule ) ;
    public final void rule__UntypedDataDescriptionRule__ConstraintsAssignment_4_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4592:1: ( ( ruleStatementRule ) )
            // InternalDataDescriptionLanguage.g:4593:2: ( ruleStatementRule )
            {
            // InternalDataDescriptionLanguage.g:4593:2: ( ruleStatementRule )
            // InternalDataDescriptionLanguage.g:4594:3: ruleStatementRule
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
    // InternalDataDescriptionLanguage.g:4603:1: rule__FunctionNameRule__DefinitionAssignment : ( ( RULE_ID ) ) ;
    public final void rule__FunctionNameRule__DefinitionAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4607:1: ( ( ( RULE_ID ) ) )
            // InternalDataDescriptionLanguage.g:4608:2: ( ( RULE_ID ) )
            {
            // InternalDataDescriptionLanguage.g:4608:2: ( ( RULE_ID ) )
            // InternalDataDescriptionLanguage.g:4609:3: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionNameRuleAccess().getDefinitionFunctionDefinitionCrossReference_0()); 
            }
            // InternalDataDescriptionLanguage.g:4610:3: ( RULE_ID )
            // InternalDataDescriptionLanguage.g:4611:4: RULE_ID
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
    // InternalDataDescriptionLanguage.g:4622:1: rule__DataReferenceRule__DefinitionAssignment : ( ( ruleStringOrId ) ) ;
    public final void rule__DataReferenceRule__DefinitionAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4626:1: ( ( ( ruleStringOrId ) ) )
            // InternalDataDescriptionLanguage.g:4627:2: ( ( ruleStringOrId ) )
            {
            // InternalDataDescriptionLanguage.g:4627:2: ( ( ruleStringOrId ) )
            // InternalDataDescriptionLanguage.g:4628:3: ( ruleStringOrId )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataReferenceRuleAccess().getDefinitionDataDescriptionCrossReference_0()); 
            }
            // InternalDataDescriptionLanguage.g:4629:3: ( ruleStringOrId )
            // InternalDataDescriptionLanguage.g:4630:4: ruleStringOrId
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
    // InternalDataDescriptionLanguage.g:4641:1: rule__OrExpressionRule__SubExpressionsAssignment_0 : ( ruleXorExpressionRule ) ;
    public final void rule__OrExpressionRule__SubExpressionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4645:1: ( ( ruleXorExpressionRule ) )
            // InternalDataDescriptionLanguage.g:4646:2: ( ruleXorExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:4646:2: ( ruleXorExpressionRule )
            // InternalDataDescriptionLanguage.g:4647:3: ruleXorExpressionRule
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
    // InternalDataDescriptionLanguage.g:4656:1: rule__OrExpressionRule__SubExpressionsAssignment_1_1 : ( ruleXorExpressionRule ) ;
    public final void rule__OrExpressionRule__SubExpressionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4660:1: ( ( ruleXorExpressionRule ) )
            // InternalDataDescriptionLanguage.g:4661:2: ( ruleXorExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:4661:2: ( ruleXorExpressionRule )
            // InternalDataDescriptionLanguage.g:4662:3: ruleXorExpressionRule
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
    // InternalDataDescriptionLanguage.g:4671:1: rule__XorExpressionRule__SubExpressionsAssignment_0 : ( ruleAndExpressionRule ) ;
    public final void rule__XorExpressionRule__SubExpressionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4675:1: ( ( ruleAndExpressionRule ) )
            // InternalDataDescriptionLanguage.g:4676:2: ( ruleAndExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:4676:2: ( ruleAndExpressionRule )
            // InternalDataDescriptionLanguage.g:4677:3: ruleAndExpressionRule
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
    // InternalDataDescriptionLanguage.g:4686:1: rule__XorExpressionRule__SubExpressionsAssignment_1_1 : ( ruleAndExpressionRule ) ;
    public final void rule__XorExpressionRule__SubExpressionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4690:1: ( ( ruleAndExpressionRule ) )
            // InternalDataDescriptionLanguage.g:4691:2: ( ruleAndExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:4691:2: ( ruleAndExpressionRule )
            // InternalDataDescriptionLanguage.g:4692:3: ruleAndExpressionRule
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
    // InternalDataDescriptionLanguage.g:4701:1: rule__AndExpressionRule__SubExpressionsAssignment_0 : ( ruleNotExpressionRule ) ;
    public final void rule__AndExpressionRule__SubExpressionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4705:1: ( ( ruleNotExpressionRule ) )
            // InternalDataDescriptionLanguage.g:4706:2: ( ruleNotExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:4706:2: ( ruleNotExpressionRule )
            // InternalDataDescriptionLanguage.g:4707:3: ruleNotExpressionRule
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
    // InternalDataDescriptionLanguage.g:4716:1: rule__AndExpressionRule__SubExpressionsAssignment_1_1 : ( ruleNotExpressionRule ) ;
    public final void rule__AndExpressionRule__SubExpressionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4720:1: ( ( ruleNotExpressionRule ) )
            // InternalDataDescriptionLanguage.g:4721:2: ( ruleNotExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:4721:2: ( ruleNotExpressionRule )
            // InternalDataDescriptionLanguage.g:4722:3: ruleNotExpressionRule
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
    // InternalDataDescriptionLanguage.g:4731:1: rule__NotExpressionRule__NegatedAssignment_0 : ( ( '!' ) ) ;
    public final void rule__NotExpressionRule__NegatedAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4735:1: ( ( ( '!' ) ) )
            // InternalDataDescriptionLanguage.g:4736:2: ( ( '!' ) )
            {
            // InternalDataDescriptionLanguage.g:4736:2: ( ( '!' ) )
            // InternalDataDescriptionLanguage.g:4737:3: ( '!' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNotExpressionRuleAccess().getNegatedExclamationMarkKeyword_0_0()); 
            }
            // InternalDataDescriptionLanguage.g:4738:3: ( '!' )
            // InternalDataDescriptionLanguage.g:4739:4: '!'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNotExpressionRuleAccess().getNegatedExclamationMarkKeyword_0_0()); 
            }
            match(input,71,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:4750:1: rule__NotExpressionRule__OperandAssignment_1 : ( ruleComparisonExpressionRule ) ;
    public final void rule__NotExpressionRule__OperandAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4754:1: ( ( ruleComparisonExpressionRule ) )
            // InternalDataDescriptionLanguage.g:4755:2: ( ruleComparisonExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:4755:2: ( ruleComparisonExpressionRule )
            // InternalDataDescriptionLanguage.g:4756:3: ruleComparisonExpressionRule
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
    // InternalDataDescriptionLanguage.g:4765:1: rule__ComparisonExpressionRule__LeftOperandAssignment_0 : ( ruleAddOrSubtractExpressionRule ) ;
    public final void rule__ComparisonExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4769:1: ( ( ruleAddOrSubtractExpressionRule ) )
            // InternalDataDescriptionLanguage.g:4770:2: ( ruleAddOrSubtractExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:4770:2: ( ruleAddOrSubtractExpressionRule )
            // InternalDataDescriptionLanguage.g:4771:3: ruleAddOrSubtractExpressionRule
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
    // InternalDataDescriptionLanguage.g:4780:1: rule__ComparisonExpressionRule__ComparisonAssignment_1 : ( rulePartialComparisonExpressionRule ) ;
    public final void rule__ComparisonExpressionRule__ComparisonAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4784:1: ( ( rulePartialComparisonExpressionRule ) )
            // InternalDataDescriptionLanguage.g:4785:2: ( rulePartialComparisonExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:4785:2: ( rulePartialComparisonExpressionRule )
            // InternalDataDescriptionLanguage.g:4786:3: rulePartialComparisonExpressionRule
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
    // InternalDataDescriptionLanguage.g:4795:1: rule__PartialComparisonExpressionRule__OperatorAssignment_0 : ( ruleComparisonOperatorRule ) ;
    public final void rule__PartialComparisonExpressionRule__OperatorAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4799:1: ( ( ruleComparisonOperatorRule ) )
            // InternalDataDescriptionLanguage.g:4800:2: ( ruleComparisonOperatorRule )
            {
            // InternalDataDescriptionLanguage.g:4800:2: ( ruleComparisonOperatorRule )
            // InternalDataDescriptionLanguage.g:4801:3: ruleComparisonOperatorRule
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
    // InternalDataDescriptionLanguage.g:4810:1: rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 : ( ruleAddOrSubtractExpressionRule ) ;
    public final void rule__PartialComparisonExpressionRule__SubExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4814:1: ( ( ruleAddOrSubtractExpressionRule ) )
            // InternalDataDescriptionLanguage.g:4815:2: ( ruleAddOrSubtractExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:4815:2: ( ruleAddOrSubtractExpressionRule )
            // InternalDataDescriptionLanguage.g:4816:3: ruleAddOrSubtractExpressionRule
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
    // InternalDataDescriptionLanguage.g:4825:1: rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 : ( ruleMultiplyDivideModuloExpressionRule ) ;
    public final void rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4829:1: ( ( ruleMultiplyDivideModuloExpressionRule ) )
            // InternalDataDescriptionLanguage.g:4830:2: ( ruleMultiplyDivideModuloExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:4830:2: ( ruleMultiplyDivideModuloExpressionRule )
            // InternalDataDescriptionLanguage.g:4831:3: ruleMultiplyDivideModuloExpressionRule
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
    // InternalDataDescriptionLanguage.g:4840:1: rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 : ( ruleAddOrSubtractOperatorRule ) ;
    public final void rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4844:1: ( ( ruleAddOrSubtractOperatorRule ) )
            // InternalDataDescriptionLanguage.g:4845:2: ( ruleAddOrSubtractOperatorRule )
            {
            // InternalDataDescriptionLanguage.g:4845:2: ( ruleAddOrSubtractOperatorRule )
            // InternalDataDescriptionLanguage.g:4846:3: ruleAddOrSubtractOperatorRule
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
    // InternalDataDescriptionLanguage.g:4855:1: rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 : ( ruleMultiplyDivideModuloExpressionRule ) ;
    public final void rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4859:1: ( ( ruleMultiplyDivideModuloExpressionRule ) )
            // InternalDataDescriptionLanguage.g:4860:2: ( ruleMultiplyDivideModuloExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:4860:2: ( ruleMultiplyDivideModuloExpressionRule )
            // InternalDataDescriptionLanguage.g:4861:3: ruleMultiplyDivideModuloExpressionRule
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
    // InternalDataDescriptionLanguage.g:4870:1: rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 : ( rulePowerOfExpressionRule ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4874:1: ( ( rulePowerOfExpressionRule ) )
            // InternalDataDescriptionLanguage.g:4875:2: ( rulePowerOfExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:4875:2: ( rulePowerOfExpressionRule )
            // InternalDataDescriptionLanguage.g:4876:3: rulePowerOfExpressionRule
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
    // InternalDataDescriptionLanguage.g:4885:1: rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 : ( ruleMultiplyDivideModuloOperatorRule ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4889:1: ( ( ruleMultiplyDivideModuloOperatorRule ) )
            // InternalDataDescriptionLanguage.g:4890:2: ( ruleMultiplyDivideModuloOperatorRule )
            {
            // InternalDataDescriptionLanguage.g:4890:2: ( ruleMultiplyDivideModuloOperatorRule )
            // InternalDataDescriptionLanguage.g:4891:3: ruleMultiplyDivideModuloOperatorRule
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
    // InternalDataDescriptionLanguage.g:4900:1: rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 : ( rulePowerOfExpressionRule ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4904:1: ( ( rulePowerOfExpressionRule ) )
            // InternalDataDescriptionLanguage.g:4905:2: ( rulePowerOfExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:4905:2: ( rulePowerOfExpressionRule )
            // InternalDataDescriptionLanguage.g:4906:3: rulePowerOfExpressionRule
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
    // InternalDataDescriptionLanguage.g:4915:1: rule__PowerOfExpressionRule__LeftOperandAssignment_0 : ( ruleUnaryAddOrSubtractExpressionRule ) ;
    public final void rule__PowerOfExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4919:1: ( ( ruleUnaryAddOrSubtractExpressionRule ) )
            // InternalDataDescriptionLanguage.g:4920:2: ( ruleUnaryAddOrSubtractExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:4920:2: ( ruleUnaryAddOrSubtractExpressionRule )
            // InternalDataDescriptionLanguage.g:4921:3: ruleUnaryAddOrSubtractExpressionRule
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
    // InternalDataDescriptionLanguage.g:4930:1: rule__PowerOfExpressionRule__RightOperandAssignment_1_1 : ( rulePowerOfExpressionRule ) ;
    public final void rule__PowerOfExpressionRule__RightOperandAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4934:1: ( ( rulePowerOfExpressionRule ) )
            // InternalDataDescriptionLanguage.g:4935:2: ( rulePowerOfExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:4935:2: ( rulePowerOfExpressionRule )
            // InternalDataDescriptionLanguage.g:4936:3: rulePowerOfExpressionRule
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
    // InternalDataDescriptionLanguage.g:4945:1: rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 : ( ruleAddOrSubtractOperatorRule ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4949:1: ( ( ruleAddOrSubtractOperatorRule ) )
            // InternalDataDescriptionLanguage.g:4950:2: ( ruleAddOrSubtractOperatorRule )
            {
            // InternalDataDescriptionLanguage.g:4950:2: ( ruleAddOrSubtractOperatorRule )
            // InternalDataDescriptionLanguage.g:4951:3: ruleAddOrSubtractOperatorRule
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
    // InternalDataDescriptionLanguage.g:4960:1: rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 : ( ruleLiteralOrReferenceRule ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4964:1: ( ( ruleLiteralOrReferenceRule ) )
            // InternalDataDescriptionLanguage.g:4965:2: ( ruleLiteralOrReferenceRule )
            {
            // InternalDataDescriptionLanguage.g:4965:2: ( ruleLiteralOrReferenceRule )
            // InternalDataDescriptionLanguage.g:4966:3: ruleLiteralOrReferenceRule
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
    // InternalDataDescriptionLanguage.g:4975:1: rule__ParanthesesRule__SubExpressionAssignment_1 : ( ruleExpressionRule ) ;
    public final void rule__ParanthesesRule__SubExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4979:1: ( ( ruleExpressionRule ) )
            // InternalDataDescriptionLanguage.g:4980:2: ( ruleExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:4980:2: ( ruleExpressionRule )
            // InternalDataDescriptionLanguage.g:4981:3: ruleExpressionRule
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
    // InternalDataDescriptionLanguage.g:4990:1: rule__CallRule__FunctionAssignment_0 : ( ruleFunctionNameRule ) ;
    public final void rule__CallRule__FunctionAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4994:1: ( ( ruleFunctionNameRule ) )
            // InternalDataDescriptionLanguage.g:4995:2: ( ruleFunctionNameRule )
            {
            // InternalDataDescriptionLanguage.g:4995:2: ( ruleFunctionNameRule )
            // InternalDataDescriptionLanguage.g:4996:3: ruleFunctionNameRule
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
    // InternalDataDescriptionLanguage.g:5005:1: rule__CallRule__ParametersAssignment_2_0 : ( ruleExpressionRule ) ;
    public final void rule__CallRule__ParametersAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5009:1: ( ( ruleExpressionRule ) )
            // InternalDataDescriptionLanguage.g:5010:2: ( ruleExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:5010:2: ( ruleExpressionRule )
            // InternalDataDescriptionLanguage.g:5011:3: ruleExpressionRule
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
    // InternalDataDescriptionLanguage.g:5020:1: rule__CallRule__ParametersAssignment_2_1_1 : ( ruleExpressionRule ) ;
    public final void rule__CallRule__ParametersAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5024:1: ( ( ruleExpressionRule ) )
            // InternalDataDescriptionLanguage.g:5025:2: ( ruleExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:5025:2: ( ruleExpressionRule )
            // InternalDataDescriptionLanguage.g:5026:3: ruleExpressionRule
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
    // InternalDataDescriptionLanguage.g:5035:1: rule__DoubleLiteralRule__LiteralAssignment_0 : ( ruleDOUBLE ) ;
    public final void rule__DoubleLiteralRule__LiteralAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5039:1: ( ( ruleDOUBLE ) )
            // InternalDataDescriptionLanguage.g:5040:2: ( ruleDOUBLE )
            {
            // InternalDataDescriptionLanguage.g:5040:2: ( ruleDOUBLE )
            // InternalDataDescriptionLanguage.g:5041:3: ruleDOUBLE
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDoubleLiteralRuleAccess().getLiteralDOUBLEParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleDOUBLE();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDoubleLiteralRuleAccess().getLiteralDOUBLEParserRuleCall_0_0()); 
            }

            }


            }

        }
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
    // InternalDataDescriptionLanguage.g:5050:1: rule__DoubleLiteralRule__FactorAssignment_1 : ( ruleFactorRule ) ;
    public final void rule__DoubleLiteralRule__FactorAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5054:1: ( ( ruleFactorRule ) )
            // InternalDataDescriptionLanguage.g:5055:2: ( ruleFactorRule )
            {
            // InternalDataDescriptionLanguage.g:5055:2: ( ruleFactorRule )
            // InternalDataDescriptionLanguage.g:5056:3: ruleFactorRule
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
    // InternalDataDescriptionLanguage.g:5065:1: rule__IntegerLiteralRule__LiteralAssignment_0 : ( RULE_INT ) ;
    public final void rule__IntegerLiteralRule__LiteralAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5069:1: ( ( RULE_INT ) )
            // InternalDataDescriptionLanguage.g:5070:2: ( RULE_INT )
            {
            // InternalDataDescriptionLanguage.g:5070:2: ( RULE_INT )
            // InternalDataDescriptionLanguage.g:5071:3: RULE_INT
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
    // InternalDataDescriptionLanguage.g:5080:1: rule__IntegerLiteralRule__FactorAssignment_1 : ( ruleFactorRule ) ;
    public final void rule__IntegerLiteralRule__FactorAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5084:1: ( ( ruleFactorRule ) )
            // InternalDataDescriptionLanguage.g:5085:2: ( ruleFactorRule )
            {
            // InternalDataDescriptionLanguage.g:5085:2: ( ruleFactorRule )
            // InternalDataDescriptionLanguage.g:5086:3: ruleFactorRule
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
    // InternalDataDescriptionLanguage.g:5095:1: rule__StringLiteralRule__ValueAssignment : ( RULE_STRING ) ;
    public final void rule__StringLiteralRule__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5099:1: ( ( RULE_STRING ) )
            // InternalDataDescriptionLanguage.g:5100:2: ( RULE_STRING )
            {
            // InternalDataDescriptionLanguage.g:5100:2: ( RULE_STRING )
            // InternalDataDescriptionLanguage.g:5101:3: RULE_STRING
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
    // InternalDataDescriptionLanguage.g:5110:1: rule__BooleanLiteralRule__ValueAssignment_1_0 : ( ( 'true' ) ) ;
    public final void rule__BooleanLiteralRule__ValueAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5114:1: ( ( ( 'true' ) ) )
            // InternalDataDescriptionLanguage.g:5115:2: ( ( 'true' ) )
            {
            // InternalDataDescriptionLanguage.g:5115:2: ( ( 'true' ) )
            // InternalDataDescriptionLanguage.g:5116:3: ( 'true' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralRuleAccess().getValueTrueKeyword_1_0_0()); 
            }
            // InternalDataDescriptionLanguage.g:5117:3: ( 'true' )
            // InternalDataDescriptionLanguage.g:5118:4: 'true'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralRuleAccess().getValueTrueKeyword_1_0_0()); 
            }
            match(input,72,FOLLOW_2); if (state.failed) return ;
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
    static final String dfa_2s = "\1\15\4\66\1\uffff\1\4\2\71\1\uffff";
    static final String dfa_3s = "\1\24\4\66\1\uffff\1\5\2\75\1\uffff";
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
            return "975:1: rule__DataDescriptionRule__Alternatives : ( ( ruleTypedDataDescriptionRule ) | ( ruleUntypedDataDescriptionRule ) );";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x01D0000000000000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0100000000000002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x000000000001E000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x000000000001E002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x00000000001FE000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x00000000001FE002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x40000000180010F0L,0x0000000000000188L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x40000000180010F2L,0x0000000000000188L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x1A00000000000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x1200000000000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000007E00000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000007E00002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000018000002L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x00000000E0000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x00000000E0000002L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x40000000180010F0L,0x0000000000000198L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x000FFFFF00000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x00000000000010C0L,0x0000000000000100L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000040L});

}